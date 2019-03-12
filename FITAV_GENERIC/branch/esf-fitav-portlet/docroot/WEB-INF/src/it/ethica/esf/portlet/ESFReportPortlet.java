package it.ethica.esf.portlet;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JRField;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.engine.data.JRXmlDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.export.ExporterInput;
import net.sf.jasperreports.export.OutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
import net.sf.jasperreports.swing.JRViewer;
import net.sf.jasperreports.view.JasperViewer;

import com.liferay.portal.kernel.events.Action;
import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.ListType;
import com.liferay.portal.model.Region;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.ListTypeServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.mysql.jdbc.Connection;
import com.sun.mail.iap.ResponseInputStream;

import it.ethica.esf.model.ESFBrand;
import it.ethica.esf.model.ESFCity;
import it.ethica.esf.model.ESFElectronic;
import it.ethica.esf.model.ESFEntityState;
import it.ethica.esf.model.ESFField;
import it.ethica.esf.model.ESFOrganization;
import it.ethica.esf.model.ESFProvince;
import it.ethica.esf.model.ESFRegion;
import it.ethica.esf.model.ESFSportType;
import it.ethica.esf.model.ESFState;
import it.ethica.esf.model.ESFUnitservice;
import it.ethica.esf.model.ESFUser;
import it.ethica.esf.model.impl.ESFOrganizationImpl;
import it.ethica.esf.service.ESFAddressLocalServiceUtil;
import it.ethica.esf.service.ESFBrandLocalServiceUtil;
import it.ethica.esf.service.ESFElectronicLocalServiceUtil;
import it.ethica.esf.service.ESFEntityStateLocalServiceUtil;
import it.ethica.esf.service.ESFFieldLocalServiceUtil;
import it.ethica.esf.service.ESFOrganizationLocalServiceUtil;
import it.ethica.esf.service.ESFProvinceLocalServiceUtil;
import it.ethica.esf.service.ESFRegionLocalServiceUtil;
import it.ethica.esf.service.ESFSportTypeLocalServiceUtil;
import it.ethica.esf.service.ESFStateLocalServiceUtil;
import it.ethica.esf.service.ESFUnitserviceLocalServiceUtil;
import it.ethica.esf.service.RegionLocalServiceUtil;
import it.ethica.esf.util.ESFServiceUtil;
import it.ethica.esf.util.ManageDate;
import it.ethica.esf.util.ManageOperationsField;

/**
 * Portlet implementation class ESFReportPortlet
 */
public class ESFReportPortlet extends MVCPortlet {

	public void actReportAssociazioni(ActionRequest req, ActionResponse resp)
			throws PortletException, SystemException {
		ListType ls = null;
		List<ESFOrganization> organizations = null;

		HttpServletRequest request = PortalUtil.getHttpServletRequest(req);
		HttpServletResponse response = PortalUtil.getHttpServletResponse(resp);
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = (Connection) DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/", "root", "");
		} catch (SQLException ex) {
			System.out.println("SQLEXCEPTION#################");
			ex.printStackTrace();

		} catch (ClassNotFoundException ex) {

			System.out.println("CLASSNOTFOUND#################");
			ex.printStackTrace();
		}
		long idOrganization = ParamUtil.getLong(req, "selOrganization");
		System.out.println("idOrganization: " + idOrganization);

		OutputStream outputStream = null;
		try {
			System.out.println("############################### PRIMA");
			outputStream = response.getOutputStream();
			System.out.println("############################### DOPO");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.out.println("##############################riga 328");
		}
		String tipoFormato = req.getParameter("downloadAs");

		// ######## Uso JASPERREPORT ########
		if (tipoFormato != null && !tipoFormato.equals("")) {
			JasperReport jasperReport;
			JasperPrint jasperPrint = null;
			JasperDesign jasperDesign;

			try {
				int tipoJr = 0;

				// ######## Ottengo la path per accedere al file jasper ########
				// ParametriAccessoFile paraccfile = new ParametriAccessoFile();
				String pathJrXml = null;

				// ######## Costruisco la path per accedere al file jasper
				// ########
				pathJrXml = "C:/Users/Andrea/Documents/DettaglioAssSportiva.jasper";
				// ######## Creo la mappa di valori da passare al riport
				// ########
				Map<String, Object> parameters = new HashMap<String, Object>();
				parameters.put("P" + 1, idOrganization);

				// ######## Carico il .jasper ########
				jasperReport = (JasperReport) JRLoader.loadObject(new File(
						pathJrXml));
				System.out
						.println("dopo il caricamento del jasper###############");
				// ######## Carico il JasperDesign dall'XML e lo compilo
				// ########
				pathJrXml = "C:/Users/Andrea/Documents/DettaglioAssSportiva.jrxml";
				jasperDesign = JRXmlLoader.load(pathJrXml);
				System.out
						.println("dopo il caricamento del designb###############");
				jasperReport = JasperCompileManager.compileReport(jasperDesign);

				System.out
						.println("dopo il caricamento del report###############");
				// ######## Riempio il report con i parametri ########
				try {
					jasperPrint = JasperFillManager.fillReport(jasperReport,
							parameters, conn);
				} catch (JRException e) {
					e.printStackTrace();
				}
				System.out
						.println("dopo il caricamento del jasperPrint###############");
				if (tipoFormato.equalsIgnoreCase("pdf")) {
					// ######## esporto il report nel formato pdf -> in un file
					// ########
					// JasperExportManager.exportReportToPdfFile(jasperPrint,
					// "C:/jasperReports/demo.pdf");
					response.setContentType("application/pdf");

					// ######## esporto il report nel formato pdf -> nello
					// stream di output ########
					JasperExportManager.exportReportToPdfStream(jasperPrint,
							outputStream);

					System.out
							.println("################### dopo L'export ###############");
				} else if (tipoFormato.equalsIgnoreCase("xsd")) {
					// ######## esporto il report nel formato exel -> in un file
					// ########

					response.setContentType("application/vnd.ms-excel");
					// ######## Usando Jasper########
					// ByteArrayOutputStream byout = new
					// ByteArrayOutputStream();
					JRXlsExporter exporterXls = new JRXlsExporter();
					exporterXls.setParameter(JRExporterParameter.JASPER_PRINT,
							jasperPrint);
					exporterXls.setParameter(
							JRXlsExporterParameter.JASPER_PRINT, jasperPrint);
					// exporterXls.setParameter(JRXlsExporterParameter.OUTPUT_STREAM,
					// byout);
					exporterXls
							.setParameter(
									JRXlsExporterParameter.OUTPUT_FILE_NAME,
									"demo.xls");
					exporterXls.setParameter(
							JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET,
							Boolean.TRUE);
					exporterXls.setParameter(
							JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND,
							Boolean.FALSE);
					exporterXls
							.setParameter(
									JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS,
									Boolean.TRUE);
					exporterXls.exportReport();
					// servletOutputStream.write(byout.toByteArray());

				}

			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("##############################riga 445");
			} finally {
				// ######## chiudo la connessione ########
				try {
					outputStream.flush();
					outputStream.close();

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out
							.println("##############################riga 456");
				}

			}
		}

	}

	public void actionMatchReport(ActionRequest request, ActionResponse response)
			throws PortletException, SystemException {

	}

	public void actReportTiratori(ActionRequest request, ActionResponse response)
			throws PortletException, SystemException {

	}

	@Override
	public void serveResource(ResourceRequest request, ResourceResponse response)
			throws IOException, PortletException {
		
		String resourceID = request.getResourceID();
		
		HttpServletRequest httpReq =
				PortalUtil.getHttpServletRequest(request);
		httpReq = PortalUtil.getOriginalServletRequest(httpReq);
		
	/*	String provinceList = "";
		String provinceCode = "";
		String organizationList = "";
		String organizationCode = "";
		String regionCode = ParamUtil.getString(request, "regionCode");
		String regionSelected = ParamUtil.getString(request, "regionSelected");
		String provinceSelectedCode = ParamUtil.getString(request,
				"provinceSelectedCode");
		String provinceSelected = ParamUtil.getString(request,
				"provinceSelected");
		String countrySelected = ParamUtil
				.getString(request, "countrySelected");
		String countryCode = ParamUtil.getString(request, "countryCode");
		String regionShooterSelected = ParamUtil.getString(request,
				"regionShooterSelected");
		String regionShooterCode = ParamUtil.getString(request,
				"regionShooterCode");*/
		

		if (resourceID.equals("getProvinceReportBDO") || resourceID.equals("getProvinceReportStand") ||
				resourceID.equals("getProvinceReportAss")) {
		
			try {
				ESFServiceUtil esfServiceUtil =
						new ESFServiceUtil(ESFUser.class.getName(), request);
				String param =
						PortalUtil.getOriginalServletRequest(httpReq).getParameter(
							"param");
				String idEsfOrganization =
						PortalUtil.getOriginalServletRequest(httpReq).getParameter(
							"regionId");
				esfServiceUtil.serveOrganization(
						request, response, param, idEsfOrganization);
					
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if (resourceID.equals("getOrganizationBDO") || resourceID.equals("getOrganizationStand") ||
				resourceID.equals("getOrganizationAss")) {
			
			try {
				ESFServiceUtil esfServiceUtil =
						new ESFServiceUtil(ESFUser.class.getName(), request);
				String param =
						PortalUtil.getOriginalServletRequest(httpReq).getParameter(
							"param");
				String idEsfOrganization =
						PortalUtil.getOriginalServletRequest(httpReq).getParameter(
							"regionId");
				esfServiceUtil.serveOrganization(
						request, response, param, idEsfOrganization);
					
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		/*
		 * 
		 * 
		 * Connection conn=null; try { Class.forName("com.mysql.jdbc.Driver");
		 * conn = (Connection)
		 * DriverManager.getConnection("jdbc:mysql://localhost:3306/"
		 * ,"test2","tenzidre260291"); } catch (SQLException ex) {
		 * System.out.println("SQLEXCEPTION#################");
		 * ex.printStackTrace();
		 * 
		 * } catch (ClassNotFoundException ex) {
		 * 
		 * System.out.println("CLASSNOTFOUND#################");
		 * ex.printStackTrace(); } long idOrganization =
		 * ParamUtil.getLong(request, "selOrganization");
		 * System.out.println("idOrganization: "
		 * +String.valueOf(idOrganization));
		 * 
		 * ByteArrayOutputStream portletOutputStream=null; try {
		 * System.out.println("############################### PRIMA");
		 * portletOutputStream =(ByteArrayOutputStream)
		 * response.getPortletOutputStream();
		 * 
		 * System.out.println("############################### DOPO"); } catch
		 * (Exception e1) { // TODO Auto-generated catch block
		 * e1.printStackTrace();
		 * System.out.println("##############################riga 328"); }
		 * String tipoFormato = request.getParameter("downloadAs");
		 * 
		 * 
		 * //######## Uso JASPERREPORT ######## if(tipoFormato!=null &&
		 * !tipoFormato.equals("")){ JasperReport jasperReport; JasperPrint
		 * jasperPrint=null; JasperDesign jasperDesign;
		 * 
		 * try{
		 * 
		 * 
		 * //######## Ottengo la path per accedere al file jasper ######## //
		 * ParametriAccessoFile paraccfile = new ParametriAccessoFile(); String
		 * pathJrXml=null;
		 * 
		 * 
		 * //######## Costruisco la path per accedere al file jasper ########
		 * pathJrXml =
		 * "C:\\Users\\Andrea\\Documents\\DettaglioAssSportiva.jasper";
		 * //######## Creo la mappa di valori da passare al riport ########
		 * Map<String,Object> parameters = new HashMap<String, Object>();
		 * parameters.put("P"+1, String.valueOf(idOrganization));
		 * System.out.println("###############PARAMETRI : "+parameters);
		 * 
		 * //######## Carico il .jasper ######## File f=new File(pathJrXml);
		 * System.out.println("<<<<< 1 "+f.exists());
		 * System.out.println("<<<<< 2 "+f.isFile());
		 * System.out.println("<<<<< 3 "+f.getAbsoluteFile());
		 * 
		 * 
		 * jasperReport = (JasperReport)JRLoader.loadObject(f);
		 * System.out.println("dopo il caricamento del jasper###############");
		 * //######## Carico il JasperDesign dall'XML e lo compilo ########
		 * pathJrXml = "C:/Users/Andrea/Documents/DettaglioAssSportiva.jrxml";
		 * //InputStream inputStream = new FileInputStream(pathJrXml);
		 * //jasperDesign = JRXmlLoader.load(inputStream);
		 * 
		 * for(String param :jasperReport.getPropertyNames())
		 * System.out.println("<<<<<< 4 "+param.toString());
		 * System.out.println("dopo il caricamento del designb###############");
		 * //jasperReport = JasperCompileManager.compileReport(jasperDesign);
		 * 
		 * System.out.println("dopo il caricamento del report###############");
		 * //######## Riempio il report con i parametri ########
		 * 
		 * jasperPrint =
		 * JasperFillManager.fillReport(jasperReport,parameters,conn);
		 * System.out
		 * .println("dopo il caricamento del jasperPrint###############");
		 * 
		 * if(tipoFormato.equalsIgnoreCase("pdf")){ //######## esporto il report
		 * nel formato pdf -> in un file ########
		 * //JasperExportManager.exportReportToPdfFile(jasperPrint,
		 * "C:/jasperReports/demo.pdf");
		 * response.setContentType("application/pdf");
		 * response.setContentLength(portletOutputStream.toByteArray().length);
		 * //######## esporto il report nel formato pdf -> nello stream di
		 * output ########
		 * JasperExportManager.exportReportToPdfStream(jasperPrint,
		 * portletOutputStream);
		 * 
		 * System.out.println("################### dopo L'export ###############"
		 * ); } else if(tipoFormato.equalsIgnoreCase("xsd")){ //######## esporto
		 * il report nel formato exel -> in un file ########
		 * 
		 * response.setContentType("application/vnd.ms-excel"); //########
		 * Usando Jasper######## // ByteArrayOutputStream byout = new
		 * ByteArrayOutputStream(); JRXlsExporter exporterXls = new
		 * JRXlsExporter();
		 * exporterXls.setParameter(JRExporterParameter.JASPER_PRINT,
		 * jasperPrint);
		 * exporterXls.setParameter(JRXlsExporterParameter.JASPER_PRINT,
		 * jasperPrint); //
		 * exporterXls.setParameter(JRXlsExporterParameter.OUTPUT_STREAM,
		 * byout);
		 * exporterXls.setParameter(JRXlsExporterParameter.OUTPUT_FILE_NAME,
		 * "demo.xls");
		 * exporterXls.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET
		 * , Boolean.TRUE);
		 * exporterXls.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND
		 * , Boolean.FALSE); exporterXls.setParameter(JRXlsExporterParameter.
		 * IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
		 * exporterXls.exportReport(); //
		 * servletOutputStream.write(byout.toByteArray());
		 * 
		 * 
		 * 
		 * }
		 * 
		 * 
		 * } catch(Exception e ){ e.printStackTrace();
		 * System.out.println("##############################riga 445"); }
		 * finally{ //######## chiudo la connessione ######## try {
		 * portletOutputStream.flush(); portletOutputStream.close();
		 * 
		 * } catch (Exception e) { // TODO Auto-generated catch block
		 * e.printStackTrace();
		 * System.out.println("##############################riga 456"); }
		 * 
		 * }
		 * 
		 * 
		 * 
		 * }
		 */
		/*
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		if (regionSelected.equalsIgnoreCase("regionSelected")) {
			try {
				List<ESFProvince> provinceLi = ESFProvinceLocalServiceUtil
						.getByRegionCode(regionCode); // to get list of country
														// available based on
														// continent Code
				for (ESFProvince conList : provinceLi) {
					provinceList = conList.getName();
					provinceCode = String.valueOf(conList.getIdProvince());
					JSONObject jsonObject = JSONFactoryUtil.createJSONObject(); // creating
																				// json
																				// object
																				// parse
																				// the
																				// request
																				// using
																				// json
																				// object

					jsonObject.put("provinceList", provinceList);
					jsonObject.put("provinceCode", provinceCode);
					jsonArray.put(jsonObject);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (provinceSelected.equalsIgnoreCase("provinceSelected")) {
			try {
				List<ESFOrganization> provinceLi = ESFOrganizationLocalServiceUtil
						.getByProvinceCode(provinceSelectedCode); // to get list
																	// of
																	// country
																	// available
																	// based on
																	// continent
																	// Code
				System.out.println("########################## LISTA"
						+ provinceLi.toString());
				for (ESFOrganization conList : provinceLi) {

					organizationList = conList.getName();
					organizationCode = String.valueOf(conList
							.getEsfOrganizationId());
					JSONObject jsonObject = JSONFactoryUtil.createJSONObject(); // creating
																				// json
																				// object
																				// parse
																				// the
																				// request
																				// using
																				// json
																				// object

					jsonObject.put("organizationList", organizationList);
					jsonObject.put("organizationCode", organizationCode);
					jsonArray.put(jsonObject);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (regionShooterSelected.equalsIgnoreCase("regionShooterSelected")) {
			try {
				List<ESFProvince> provinceLi = ESFProvinceLocalServiceUtil
						.getByRegionCode(regionShooterCode); // to get list of
																// country
																// available
																// based on
																// continent
																// Code
				for (ESFProvince conList : provinceLi) {
					provinceList = conList.getName();
					provinceCode = String.valueOf(conList.getIdProvince());
					JSONObject jsonObject = JSONFactoryUtil.createJSONObject(); // creating
																				// json
																				// object
																				// parse
																				// the
																				// request
																				// using
																				// json
																				// object

					jsonObject.put("provinceShooterList", provinceList);
					jsonObject.put("provinceShooterCode", provinceCode);
					jsonArray.put(jsonObject);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		if (countrySelected.equalsIgnoreCase("countrySelected")) {
			try {
				if (countryCode.equals("IT")) {
					List<ESFRegion> provinceLi = ESFRegionLocalServiceUtil
							.getAllRegionByCountryId(countryCode); // to get
																	// list of
																	// country
																	// available
																	// based on
																	// continent
																	// Code
					for (ESFRegion conList : provinceLi) {
						provinceList = conList.getName();
						provinceCode = String.valueOf(conList.getIdRegion());
						JSONObject jsonObject = JSONFactoryUtil
								.createJSONObject(); // creating json object
														// parse the request
														// using json object

						jsonObject.put("regionList", provinceList);
						jsonObject.put("regionCode", provinceCode);
						jsonArray.put(jsonObject);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		PrintWriter writer = response.getWriter();
		writer.write(jsonArray.toString());
		writer.flush();
		*/
	}

	
	//////////////////////////////////////////////////
	public void sendReportElencoReportXmlPdf(ActionRequest req, ActionResponse resp)
			throws IOException, SAXException, ParserConfigurationException, JRException, SQLException, PortalException, SystemException {
		_log.info("--1--");
	/*	HttpServletRequest request = PortalUtil.getHttpServletRequest(req);
		HttpServletResponse response = PortalUtil.getHttpServletResponse(resp);
		_log.info("--2--");
		JasperReport jasperReport = JasperCompileManager.compileReport("C:/Users/PcEthicaVD/Desktop/Report/Report1.jrxml");
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,new HashMap(), new JREmptyDataSource());
		JasperExportManager.exportReportToPdfFile(jasperPrint, "C:/Users/PcEthicaVD/Desktop/Report/Report1.pdf");
		_log.info("--11--");
		*/
		String userName = "root";
		String password = "";
		
		ThemeDisplay themeDisplay = (ThemeDisplay)req.getAttribute(WebKeys.THEME_DISPLAY);
		
		Group group =themeDisplay.getLayout().getGroup();

		long currentOrganizationId = group.getOrganizationId();
		
		long regionId = ParamUtil.getLong(req, "selRegion");
		long provinceId = ParamUtil.getLong(req, "selProvince");
		long associationId = ParamUtil.getLong(req, "selOrganization");
		
		
		try {
			_log.info("--2--");
			Class.forName("com.mysql.jdbc.Driver");
			
			String connectionURL = "jdbc:mysql://127.0.0.1:3306/fitav";
			
			Connection conn = (Connection) DriverManager.getConnection(connectionURL, userName,password);
			
			_log.info("--3--");
			
			String reportSrcFile = "C:/Users/PcEthicaVD/Desktop/Report/Report1.jrxml";
			
			_log.info("--4--");
			JasperReport jasperReport = JasperCompileManager.compileReport(reportSrcFile);
			
			//Map<String, Object> parameters = new HashMap<String, Object>();
			
			////////////////
			
			//String user = request.getParameter("USER");
			HashMap map = new HashMap();
			long id = ParamUtil.getLong(req, "selSportType");
			map.put("esfSportTypeId", id); 
			//JasperPrint print = JasperFillManager.fillReport(report, map, conn);
			
			////////////////
			//JasperPrint print = JasperFillManager.fillReport(jasperReport,
				//	parameters, conn);
			
			JasperPrint print = JasperFillManager.fillReport(jasperReport,
					map, conn);
			
			_log.info("--5--");
			
			File outDir = new File("C:/Users/PcEthicaVD/Desktop/Report");
			outDir.mkdirs();
			
			_log.info("--6--");
			
			JRPdfExporter exporter = new JRPdfExporter();
			 
			ExporterInput exporterInput = new SimpleExporterInput(print);
			
			_log.info("--7--");
			
			exporter.setExporterInput(exporterInput);
			
			OutputStreamExporterOutput exporterOutput = new SimpleOutputStreamExporterOutput(
					"C:/Users/PcEthicaVD/Desktop/Report1.pdf");
			
			_log.info("--8--");
			
			exporter.setExporterOutput(exporterOutput);
			
			SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
			exporter.setConfiguration(configuration);
			exporter.exportReport();
			
			_log.info("--9--");
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void bdoReport(ActionRequest req, ActionResponse resp)
			throws IOException, SAXException, ParserConfigurationException, JRException, SQLException, PortalException, SystemException {
		
		String userName = "root";
		String password = "";
		String orgName = "";
		
		ESFOrganization org = new ESFOrganizationImpl();
		
		ThemeDisplay themeDisplay = (ThemeDisplay)req.getAttribute(WebKeys.THEME_DISPLAY);
		Group group =themeDisplay.getLayout().getGroup();

		long currentOrganizationId = group.getOrganizationId();
		long regionId = ParamUtil.getLong(req, "selRegion");
		long provinceId = ParamUtil.getLong(req, "selProvince");
		long associationId = ParamUtil.getLong(req, "selOrganization");
		long stateId = ParamUtil.getLong(req, "esfStateId");
		
		Date d = new Date();
		String  year = String.valueOf(Calendar.getInstance().get(Calendar.YEAR)) ;
		
		if(0 != associationId){
			org = ESFOrganizationLocalServiceUtil.fetchESFOrganization(associationId);
			orgName = org.getName();
		}else if( 0 == associationId && 0 != provinceId){
			org = ESFOrganizationLocalServiceUtil.fetchESFOrganization(provinceId);
			orgName = org.getName(); 
		}else if(0 == provinceId &&  0 != regionId){
			org = ESFOrganizationLocalServiceUtil.fetchESFOrganization(regionId);
			orgName = org.getName();
		}else{
			org = ESFOrganizationLocalServiceUtil.fetchESFOrganization(currentOrganizationId);
			orgName = org.getName();
		}
		
		try {
			String assId = "";
			
			HashMap map = new HashMap();
			
			Class.forName("com.mysql.jdbc.Driver");
			
			String connectionURL = "jdbc:mysql://127.0.0.1:3306/fitav";
			
			Connection conn = (Connection) DriverManager.getConnection(connectionURL, userName,password);
			
			
			if(0 != associationId){
				//assId = "%/"+associationId +"%/";
				map.put("assId", associationId); 
			}else if( 0 == associationId && 0 != provinceId){
				//assId = "%/"+provinceId +"%/";
				map.put("assId", provinceId); 
			}else if(0 == provinceId &&  0 != regionId){
				//assId = "%/"+ regionId+"%/";
				map.put("assId", regionId);
			}else{
				//assId = "%/"+currentOrganizationId +"%/";
				map.put("assId", currentOrganizationId);
			}
			
			map.put("_orgName", orgName);
			map.put("_year", year);
			
			String reportSrcFile = "C:/Users/PcEthicaVD/Desktop/Report/Consiglio Direttivo.jrxml";
			JasperReport jasperReport = JasperCompileManager.compileReport(reportSrcFile);
			
			JasperPrint print = JasperFillManager.fillReport(jasperReport,
					map, conn);
			
			File outDir = new File("C:/Users/PcEthicaVD/Desktop/Report");
			outDir.mkdirs();
			
			JRPdfExporter exporter = new JRPdfExporter();
			 
			ExporterInput exporterInput = new SimpleExporterInput(print);
			
			exporter.setExporterInput(exporterInput);
			
			OutputStreamExporterOutput exporterOutput = new SimpleOutputStreamExporterOutput(
					"C:/Users/PcEthicaVD/Desktop/Consiglio direttivo.pdf");
			
			exporter.setExporterOutput(exporterOutput);
			
			SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
			exporter.setConfiguration(configuration);
			exporter.exportReport();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	private static Log _log = LogFactoryUtil.getLog(ESFReportPortlet.class);
}