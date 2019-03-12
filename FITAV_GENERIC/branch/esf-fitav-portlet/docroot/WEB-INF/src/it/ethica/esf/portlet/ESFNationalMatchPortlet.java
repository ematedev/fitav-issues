
package it.ethica.esf.portlet;

/*import net.sf.jasperreports.export.ExporterInput;
import net.sf.jasperreports.export.OutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;*/
import it.ethica.esf.model.ESFAddress;
import it.ethica.esf.model.ESFCane;
import it.ethica.esf.model.ESFCard;
import it.ethica.esf.model.ESFCatridge;
import it.ethica.esf.model.ESFConfiguration;
import it.ethica.esf.model.ESFDeparture;
import it.ethica.esf.model.ESFDocument;
import it.ethica.esf.model.ESFEntityState;
import it.ethica.esf.model.ESFGun;
import it.ethica.esf.model.ESFGunKind;
import it.ethica.esf.model.ESFGunType;
import it.ethica.esf.model.ESFMatch;
import it.ethica.esf.model.ESFMatchType;
import it.ethica.esf.model.ESFNationalDelegation;
import it.ethica.esf.model.ESFNationalMatchResult;
import it.ethica.esf.model.ESFPartecipant;
import it.ethica.esf.model.ESFPhone;
import it.ethica.esf.model.ESFSportType;
import it.ethica.esf.model.ESFUser;
import it.ethica.esf.model.ESFUserESFUserRole;
import it.ethica.esf.model.ESFUserRole;
import it.ethica.esf.model.ESFgunUser;
import it.ethica.esf.model.impl.ESFCaneImpl;
import it.ethica.esf.model.impl.ESFConfigurationImpl;
import it.ethica.esf.model.impl.ESFDepartureImpl;
import it.ethica.esf.model.impl.ESFEntityStateImpl;
import it.ethica.esf.model.impl.ESFGunKindImpl;
import it.ethica.esf.model.impl.ESFMatchImpl;
import it.ethica.esf.model.impl.ESFNationalMatchResultImpl;
import it.ethica.esf.model.impl.ESFSportTypeImpl;
import it.ethica.esf.model.impl.ESFUserImpl;
import it.ethica.esf.model.impl.ESFUserRoleImpl;
import it.ethica.esf.portlet.utility.ShooterUtility;
import it.ethica.esf.service.ESFAddressLocalServiceUtil;
import it.ethica.esf.service.ESFAirportLocalServiceUtil;
import it.ethica.esf.service.ESFCaneLocalServiceUtil;
import it.ethica.esf.service.ESFCardLocalServiceUtil;
import it.ethica.esf.service.ESFCatridgeLocalServiceUtil;
import it.ethica.esf.service.ESFConfigurationLocalServiceUtil;
import it.ethica.esf.service.ESFDepartureLocalServiceUtil;
import it.ethica.esf.service.ESFDescriptionLocalServiceUtil;
import it.ethica.esf.service.ESFDocumentLocalServiceUtil;
import it.ethica.esf.service.ESFGunKindLocalServiceUtil;
import it.ethica.esf.service.ESFGunLocalServiceUtil;
import it.ethica.esf.service.ESFGunTypeLocalServiceUtil;
import it.ethica.esf.service.ESFMatchLocalServiceUtil;
import it.ethica.esf.service.ESFMatchTypeLocalServiceUtil;
import it.ethica.esf.service.ESFNationalDelegationLocalServiceUtil;
import it.ethica.esf.service.ESFNationalMatchResultLocalServiceUtil;
import it.ethica.esf.service.ESFPartecipantLocalServiceUtil;
import it.ethica.esf.service.ESFSportTypeLocalServiceUtil;
import it.ethica.esf.service.ESFUserESFUserRoleLocalServiceUtil;
import it.ethica.esf.service.ESFUserLocalServiceUtil;
import it.ethica.esf.service.ESFUserRoleLocalServiceUtil;
import it.ethica.esf.service.ESFgunUserLocalServiceUtil;
import it.ethica.esf.service.persistence.ESFUserESFUserRolePK;
import it.ethica.esf.util.ESFJsonUtil;
import it.ethica.esf.util.ESFKeys;
import it.ethica.esf.util.ESFServiceUtil;
import it.ethica.esf.util.ManageDate;
import it.ethica.esf.util.ManageOperationsField;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.mail.internet.InternetAddress;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.StateAwareResponse;
import javax.print.Doc;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.export.ExporterInput;
import net.sf.jasperreports.export.OutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
import net.sf.jasperreports.export.SimpleXlsReportConfiguration;















///////////////////////////////////////
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
///////////////////////////////////////





















import org.allcolor.yahp.converter.CYaHPConverter;
import org.allcolor.yahp.converter.IHtmlToPdfTransformer;
/*
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.codec.Base64.OutputStream;
*/
import org.apache.commons.io.FileUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.common.PDStream;
//import org.apache.jasper.JasperException;
import org.joda.time.DateTime;
import org.joda.time.Days;

import com.itextpdf.text.DocListener;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.html.simpleparser.HTMLWorker;
import com.itextpdf.tool.xml.XMLWorkerHelper;
//import com.itextpdf.text.pdf.qrcode.WriterException;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.ContactBirthdayException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.HttpHeaders;
//import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.ListType;
import com.liferay.portal.model.Phone;
import com.liferay.portal.model.User;
import com.liferay.portal.service.CountryServiceUtil;
import com.liferay.portal.service.ListTypeServiceUtil;
import com.liferay.portal.service.PhoneLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.portlet.journal.service.persistence.JournalArticleFinderUtil;
import com.liferay.portlet.journalcontent.util.JournalContentUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.liferay.util.mail.MailEngine;
import com.liferay.util.mail.MailEngineException;
import com.liferay.util.portlet.PortletProps;
//import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
//import com.lowagie.text.pdf.PdfWriter;
//import com.lowagie.text.pdf.codec.Base64.OutputStream;
import com.mysql.jdbc.Connection;
//import com.sun.xml.internal.stream.buffer.sax.Properties;
//email
import com.sun.corba.se.spi.ior.iiop.GIOPVersion;

//import org.apache.commons.digester.Digester;


//import org.apache.commons.digester

/**
 * Portlet implementation class NationalMatchPortlet
 */
public class ESFNationalMatchPortlet extends MVCPortlet { 

	private Log _log = LogFactoryUtil.getLog(ESFNationalMatchPortlet.class);
	
	@Override
	public void render(RenderRequest request, RenderResponse response)
		throws IOException, PortletException {
		
		
		Long esfDepartureId = ParamUtil.getLong(request, "esfDepartureId");
		if(esfDepartureId!=0){
			request.setAttribute("esfDepartureId", esfDepartureId);
		}
		String from = ParamUtil.getString(request, "from");
		ESFJsonUtil esfJsonUtil = new ESFJsonUtil();
		// long esfAddressId = ParamUtil.getLong(request, "esfAddressId");
		long esfUserId = ParamUtil.getLong(request, "esfUserId");
		
		long esfMatchId = ParamUtil.getLong(request, "esfMatchId");
		if (esfMatchId > 0) {
			request.setAttribute("esfMatchId", esfMatchId);
		}
		String op = ParamUtil.getString(request, "op");

		if (Validator.isNotNull(esfMatchId)) {
			
			String path =
					PropsUtil.get("auto.deploy.tomcat.dest.dir") +
					File.separator + "match_document" + File.separator +
						esfMatchId;
			
			String documentPath =
				File.separator + "match_document" + File.separator +
					esfMatchId + File.separator;
			
			File dir = new File(path);
			String files[] = dir.exists() ? dir.list() : null;

			request.setAttribute("filePath", documentPath);
			request.setAttribute("filesToDownload", files);
		}
		if (op.equals("addAddr")) {
			try {
				for (int i = 0; i < ESFKeys.MinElemIncludePage.MAXADDRESSUSER; i++) {

					esfJsonUtil.prepareJSONAddAddress(request, response, i);

				}

				request.setAttribute(
					"number", ESFKeys.MinElemIncludePage.MINADDRESSUSER);
				request.setAttribute(
					"numberOfPhones", ESFKeys.MinElemIncludePage.MINPHONEUSER);

				esfJsonUtil.prepareJSONAddAssociations(request, response);
			}
			catch (PortalException e) {
				e.printStackTrace();
			}
		}
		else if (esfUserId > 0) {
			
			if (op.equals("updAddr")) {

				try {
					
					ESFUser esfUser =
						ESFUserLocalServiceUtil.getESFUser(esfUserId);

					List<ESFAddress> esfAddresses =
						ESFAddressLocalServiceUtil.getESFAddresses(
							esfUser.getCompanyId(), ESFUser.class.getName(),
							esfUserId);
					//
					List<Phone> phones =
						PhoneLocalServiceUtil.getPhones(
							esfUser.getCompanyId(), ESFUser.class.getName(),
							esfUserId);

					int index = 0;

					for (ESFAddress esfAddress : esfAddresses) {
						if (Validator.isNotNull(esfAddress)) {
							esfJsonUtil.prepareJSONUpdAddress(
								request, response,
								esfAddress.getEsfAddressId(), index);
						}

						index++;
					}

					if (index < ESFKeys.MinElemIncludePage.MAXADDRESSUSER) {

						for (int i = index; i < ESFKeys.MinElemIncludePage.MAXADDRESSUSER; i++) {

							esfJsonUtil.prepareJSONAddAddress(
								request, response, i);

						}

					}

					if (index < ESFKeys.MinElemIncludePage.MINADDRESSUSER) {

						request.setAttribute(
							"number", ESFKeys.MinElemIncludePage.MINADDRESSUSER);

					}
					else {
						request.setAttribute("number", index);

					}

					if (phones.size() < ESFKeys.MinElemIncludePage.MINPHONEUSER) {

						request.setAttribute(
							"numberOfPhones",
							ESFKeys.MinElemIncludePage.MINPHONEUSER);
					}
					else {
						request.setAttribute("numberOfPhones", phones.size());
					}

					esfJsonUtil.prepareJSONUpdAssociationsCards(
						request, response);
				}
				catch (PortalException e) {
					e.printStackTrace();
				}
				catch (SystemException e) {
					e.printStackTrace();
				}
				
			}else {
				
				try {
					
					ESFUser esfUser =
							ESFUserLocalServiceUtil.getESFUser(esfUserId);
					
					
					//aggiunto da Dario//
					List<ESFAddress> esfAddresses =
							ESFAddressLocalServiceUtil.getESFAddresses(
								esfUser.getCompanyId(), ESFUser.class.getName(),
								esfUserId);

					int index = 0;

					for (ESFAddress esfAddress : esfAddresses) {
						if (Validator.isNotNull(esfAddress)) {
							esfJsonUtil.prepareJSONUpdAddress(
								request, response,
								esfAddress.getEsfAddressId(), index);
						}

						index++;
					}

					if (index < ESFKeys.MinElemIncludePage.MAXADDRESSUSER) {

						for (int i = index; i < ESFKeys.MinElemIncludePage.MAXADDRESSUSER; i++) {

							esfJsonUtil.prepareJSONAddAddress(
								request, response, i);
						}

					}

					if (index < ESFKeys.MinElemIncludePage.MINADDRESSUSER) {
						
						request.setAttribute(
							"number", ESFKeys.MinElemIncludePage.MINADDRESSUSER);

					}
					else {
						
						request.setAttribute("number", index);

					}
					
					//aggiunto da Dario//

					List<Phone> phones =
						PhoneLocalServiceUtil.getPhones(
							esfUser.getCompanyId(), ESFUser.class.getName(),
							esfUserId);

					if (phones.size() < ESFKeys.MinElemIncludePage.MINPHONEUSER) {
						
						request.setAttribute(
							"numberOfPhones",
							ESFKeys.MinElemIncludePage.MINPHONEUSER);
					}
					else {

						request.setAttribute("numberOfPhones", phones.size());

					}

				}
				catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		}else if(op.equals("chooseorg")) {
			try {
				esfJsonUtil.prepareJSONOrganizations(request, response);
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			from = "from";
		}
		
		super.render(request, response);
	}

	@Override
	public void serveResource(
		ResourceRequest resourceRequest, ResourceResponse resourceResponse)
		throws IOException, PortletException {

		HttpServletRequest httpReq =
			PortalUtil.getHttpServletRequest(resourceRequest);
		httpReq = PortalUtil.getOriginalServletRequest(httpReq);
		boolean preView = ParamUtil.getBoolean(httpReq, "preView");
		long esfGunTypeId = ParamUtil.getLong(httpReq, "esfGunTypeId", 0);
		
		String matchReport = ParamUtil.getString(resourceRequest, "genrateMatchReport");

		String resourceID = resourceRequest.getResourceID();

		if ("deleteExternalShooter".equals(resourceID)) {

			long esfNationalMatchResultId = ParamUtil.getLong(resourceRequest, "esfNationalMatchResultId", 0);
			try {
				ESFNationalMatchResultLocalServiceUtil.deleteESFNationalMatchResult(esfNationalMatchResultId);
			} catch (SystemException e) {
				if (_log.isErrorEnabled()) {
					_log.error(e);
				}
				throw new PortletException();
			} catch (PortalException e) {
				if (_log.isErrorEnabled()) {
					_log.error(e);
				}
				throw new PortletException();
			}
			return;
		}
		
		if (esfGunTypeId > 0) {

			List<ESFGunKind> esfGunKinds = new ArrayList<ESFGunKind>();

			try {
				esfGunKinds =
					ESFGunKindLocalServiceUtil.getESFGunKindsByESFGunType(esfGunTypeId);
			}
			catch (SystemException e) {
				e.printStackTrace();
			}

			JSONObject resultJSONObj = JSONFactoryUtil.createJSONObject();
			JSONArray resultJSONArr = JSONFactoryUtil.createJSONArray();

			for (ESFGunKind esfGunKind : esfGunKinds) {

				JSONObject esfGunKindIdName =
					JSONFactoryUtil.createJSONObject();

				esfGunKindIdName.put(
					"esfGunKindId", esfGunKind.getEsfGunKindId());
				esfGunKindIdName.put("name", esfGunKind.getName());

				resultJSONArr.put(esfGunKindIdName);
			}

			resultJSONObj.put("esfGunKinds", resultJSONArr);

			resourceResponse.getWriter().write(resultJSONObj.toString());
		}
		
		if(Validator.isNotNull(matchReport) && !"ok".equals(matchReport)){
			try {
				ESFServiceUtil esfServiceUtil =
					new ESFServiceUtil(ESFUser.class.getName(), resourceRequest);
	
				String param =
					PortalUtil.getOriginalServletRequest(httpReq).getParameter(
						"param");
				String idRegion =
					PortalUtil.getOriginalServletRequest(httpReq).getParameter(
						"idRegion");
				String idProvince =
					PortalUtil.getOriginalServletRequest(httpReq).getParameter(
						"idProvince");
				String emailAddress =
					PortalUtil.getOriginalServletRequest(httpReq).getParameter(
						"emailVal");
	
				long associationId =
					StringToLong(PortalUtil.getOriginalServletRequest(httpReq).getParameter(
						"idAssociation"));
				long esfUserId =
					StringToLong(PortalUtil.getOriginalServletRequest(httpReq).getParameter(
						"esfUserId"));
				
	
				if (Validator.isNotNull(resourceID) && resourceID.contains("regions")) {
					esfServiceUtil.serveRegions(
						resourceRequest, resourceResponse, param,
						ESFKeys.ESFAddressConstant.DEFAULT_COUNTRY, idRegion);
				}
				else if (Validator.isNotNull(resourceID) && resourceID.contains("provinces")) {
					esfServiceUtil.serveProvinces(
						resourceRequest, resourceResponse, param,
						ESFKeys.ESFAddressConstant.DEFAULT_COUNTRY, idRegion,
						idProvince);
				}
				else if (Validator.isNotNull(resourceID) && resourceID.equals("emailaddresses")) {
					esfServiceUtil.serveEmailAddress(
						resourceRequest, resourceResponse, emailAddress);
				}
				else if (Validator.isNotNull(resourceID) && resourceID.equals("associations")) {
					esfServiceUtil.serveAssociationsCards(
						resourceRequest, resourceResponse, param, associationId,
						esfUserId);
				}else if (resourceID.equals("fiscalCode")) {
					JSONObject fiscalcode = serveFiscalCode(resourceRequest,resourceResponse);
					resourceResponse.getWriter().print(fiscalcode);
				}else if (resourceID.equals("liv1") || resourceID.equals("liv2") ||
						resourceID.equals("liv3")) {
				 esfServiceUtil =
					new ESFServiceUtil(ESFUser.class.getName(), resourceRequest);
	
				param =
					PortalUtil.getOriginalServletRequest(httpReq).getParameter(
						"param");
				String idEsfOrganization =
					PortalUtil.getOriginalServletRequest(httpReq).getParameter(
						"esfOrganizationId");
				esfServiceUtil.serveOrganization(
					resourceRequest, resourceResponse, param, idEsfOrganization);
				}
			}
			catch (IOException ioe) {
				throw ioe;
			}
			catch (PortletException pe) {
				throw pe;
			}
			catch (Exception e) {
				throw new PortletException(e);
			}
		}
		
		long description = ParamUtil.getLong(httpReq, "description",0);
		
		if (description > 0) {
			
			List<ESFMatchType> esfMatchTypes = new ArrayList<ESFMatchType>();
			
			try {
				esfMatchTypes=ESFMatchTypeLocalServiceUtil.
						findByDescription(ESFDescriptionLocalServiceUtil
								.fetchESFDescription(description).getName());
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			JSONObject resultJSONObj = JSONFactoryUtil.createJSONObject();
			JSONArray resultJSONArr = JSONFactoryUtil.createJSONArray();
			
			for(ESFMatchType esfMatchType : esfMatchTypes ){
				
				JSONObject esfMatchTypeIdName =
						JSONFactoryUtil.createJSONObject();
				
				esfMatchTypeIdName.put(
						"esfMatchTypesId", esfMatchType.getEsfMatchTypeId());
				esfMatchTypeIdName.put("name", esfMatchType.getName());
					resultJSONArr.put(esfMatchTypeIdName);
				}
			resultJSONObj.put("esfMatchTypes", resultJSONArr);
			resourceResponse.getWriter().write(resultJSONObj.toString());
			}
		
		//genera pdf
		
        if(Validator.isNotNull(matchReport) && matchReport.equals("ok")) {
        	
        
        	boolean generatePasses = ParamUtil.getBoolean(resourceRequest, "generatePasses");
        	boolean generateLicences = ParamUtil.getBoolean(resourceRequest, "generateLicences");
        	boolean generateconvocations = ParamUtil.getBoolean(resourceRequest, "generateconvocations");
        	boolean convocations = ParamUtil.getBoolean(resourceRequest, "convocations");
        	boolean preview = ParamUtil.getBoolean(resourceRequest, "pre-view");
        	long esfMatchId = ParamUtil.getLong(resourceRequest, "esfMatchId");
        	
        	if(generateconvocations){
        		try {
        			boolean generatePdfOk = false;
        			generatePdfOk = generateConvocations(resourceRequest , resourceResponse, esfMatchId);
        			
        			if(!generatePdfOk){
        				SessionErrors.add(resourceRequest, "generatePDF-reference-error");
        				
    					((StateAwareResponse) resourceResponse).setRenderParameter( "mvcPath", "/html/esfnationalmatch/view.jsp");
    					((StateAwareResponse) resourceResponse).setRenderParameter("esfMatchId", String.valueOf(esfMatchId));
    					
        			}
				} catch (SystemException e) {
					_log.info(" nel serve resurce catch 1");
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (PortalException e) {
					// TODO Auto-generated catch block
					_log.info(" nel serve resurce catch 2");
					e.printStackTrace();
				} catch (com.lowagie.text.DocumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	}
        }
		// genera pdf

		/*
		 * try { ESFServiceUtil esfServiceUtil = new
		 * ESFServiceUtil(ESFUser.class.getName(), resourceRequest);
		 * HttpServletRequest httpReq =
		 * PortalUtil.getHttpServletRequest(resourceRequest); long esfGunTypeId
		 * = ParamUtil.getLong(httpReq, "esfGunTypeId", 0); String param =
		 * PortalUtil.getOriginalServletRequest(httpReq).getParameter( "param");
		 * String idRegion =
		 * PortalUtil.getOriginalServletRequest(httpReq).getParameter(
		 * "idRegion"); String idProvince =
		 * PortalUtil.getOriginalServletRequest(httpReq).getParameter(
		 * "idProvince"); String emailAddress =
		 * PortalUtil.getOriginalServletRequest(httpReq).getParameter(
		 * "emailVal"); if (esfGunTypeId > 0) { List<ESFGunKind> esfGunKinds =
		 * new ArrayList<ESFGunKind>(); esfGunKinds =
		 * ESFGunKindLocalServiceUtil.getESFGunKindsByESFGunType(esfGunTypeId);
		 * JSONObject resultJSONObj = JSONFactoryUtil.createJSONObject();
		 * JSONArray resultJSONArr = JSONFactoryUtil.createJSONArray(); for
		 * (ESFGunKind esfGunKind : esfGunKinds) { JSONObject esfGunKindIdName =
		 * JSONFactoryUtil.createJSONObject(); esfGunKindIdName.put(
		 * "esfGunKindId", esfGunKind.getEsfGunKindId());
		 * esfGunKindIdName.put("name", esfGunKind.getName());
		 * resultJSONArr.put(esfGunKindIdName); resultJSONObj.put("esfGunKinds",
		 * resultJSONArr); } resultJSONObj.put("esfGunKinds", resultJSONArr);
		 * resourceResponse.getWriter().write(resultJSONObj.toString()); } long
		 * associationId =
		 * StringToLong(PortalUtil.getOriginalServletRequest(httpReq
		 * ).getParameter( "idAssociation")); long esfUserId =
		 * StringToLong(PortalUtil
		 * .getOriginalServletRequest(httpReq).getParameter( "esfUserId"));
		 * String resourceID = resourceRequest.getResourceID(); if
		 * (resourceID.contains("regions")) { esfServiceUtil.serveRegions(
		 * resourceRequest, resourceResponse, param,
		 * ESFKeys.ESFAddressConstant.DEFAULT_COUNTRY, idRegion); } else if
		 * (resourceID.contains("provinces")) { esfServiceUtil.serveProvinces(
		 * resourceRequest, resourceResponse, param,
		 * ESFKeys.ESFAddressConstant.DEFAULT_COUNTRY, idRegion, idProvince); }
		 * else if (resourceID.equals("emailaddresses")) {
		 * esfServiceUtil.serveEmailAddress( resourceRequest, resourceResponse,
		 * emailAddress); } else if (resourceID.equals("associations")) {
		 * esfServiceUtil.serveAssociationsCards( resourceRequest,
		 * resourceResponse, param, associationId, esfUserId); } } catch
		 * (IOException ioe) { throw ioe; } catch (PortletException pe) { throw
		 * pe; } catch (Exception e) { throw new PortletException(e); }
		 * super.serveResource(resourceRequest, resourceResponse);
		 */
		
		
		
	}
	
	public boolean generateConvocations(ResourceRequest req, ResourceResponse resp, 
			long matchId) throws SystemException, PortalException, FileNotFoundException, 
				com.lowagie.text.DocumentException {
			
			boolean isOk = false;
		
			ESFMatch match = ESFMatchLocalServiceUtil.fetchESFMatch(matchId);
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date now = new Date();
			String today = sdf.format(now);
			String matchName = "";
			
			String matchInformation = "";
			String startDate = "";
			String endDate = "";
			String speciality = "";
			String eventName = "";
			
			
			if(Validator.isNotNull(match)){
				
				List<ESFNationalDelegation> delegations = new ArrayList<ESFNationalDelegation>();
				ESFUser user = new ESFUserImpl();
				
				if(Validator.isNotNull(match) && Validator.isNotNull(match.getCode())){
					matchName = match.getCode();
				}
				
				delegations = ESFNationalDelegationLocalServiceUtil.getESFNationalDelegationByESFMatchId(matchId);
				

				
				if(Validator.isNotNull(match.getStartDate())){
					startDate = sdf.format(match.getStartDate());
				}
				if(Validator.isNotNull(match.getStartDate())){
					endDate = sdf.format(match.getEndDate());
				}
				
				
				ESFSportType spec = new ESFSportTypeImpl();
				
				String sportType = match.getEsfNationalSportTypeId();
				
				if(Validator.isNotNull(sportType)){
					
					String [] splits = sportType.split("-");
				
					if( 0 < splits.length ){
						
						for(String s : splits){
							
							if( Validator.isNumber(s)){
								spec = ESFSportTypeLocalServiceUtil.fetchESFSportType(Long.parseLong(s));
								if(Validator.isNotNull(spec) && Validator.isNotNull(spec.getName())){
									speciality = speciality + " " +spec.getName();
								}
							}
							
						}
					   
					}
				
				}
				
				if(!"".equals(speciality)){
					speciality = speciality + "-";
				}

				String matchType = "";
				if(Validator.isNotNull(match.getEsfMatchTypeId()) && 
						Validator.isNotNull(ESFMatchTypeLocalServiceUtil.fetchESFMatchType(match.getEsfMatchTypeId()).getName())
						&& !"".equalsIgnoreCase(ESFMatchTypeLocalServiceUtil.fetchESFMatchType(match.getEsfMatchTypeId()).getName())){
					matchType = ESFMatchTypeLocalServiceUtil.fetchESFMatchType(match.getEsfMatchTypeId()).getName()+"-";
				}
				
				String matchCountry = "";
				if(Validator.isNotNull(match.getCountryId()) &&
					Validator.isNotNull(CountryServiceUtil.fetchCountry(match.getCountryId()).getName())){
					matchCountry = CountryServiceUtil.fetchCountry(match.getCountryId()).getName();
					matchCountry = matchCountry.toUpperCase();
				}else{
					matchCountry = "ITALIA";
				}	

				if(Validator.isNotNull(match.getDescription())) {
					eventName =	ESFDescriptionLocalServiceUtil.fetchESFDescription( match.getDescription()).getName()+"-";
				}

				String description = "";

				description = matchType+eventName+speciality+matchCountry;
				
				/*
				 _today
				 _shooterNameNM
				 _NMInformation
				 _startDateNM
				 _endDateNM
				 */
				
				ThemeDisplay themeDisplay = (ThemeDisplay)req.getAttribute(WebKeys.THEME_DISPLAY);
				
				JournalArticle article = JournalArticleLocalServiceUtil.getArticleByUrlTitle(themeDisplay.getScopeGroupId(), "Convocations-Model");
				String content =JournalContentUtil.getContent( themeDisplay.getPortletGroupId(), article.getArticleId(), "", themeDisplay.getLocale().toString(), themeDisplay );
				
				content = content.replaceAll("_today", today);
				content = content.replaceAll("_NMInformation", description);
				content = content.replaceAll("_startDateNM", startDate);
				content = content.replaceAll("_endDateNM", endDate);
				
				
				
				
				_log.info("----1----");
				
				Document document = new Document();
				try{
					_log.info("----1 bis----");
					ByteArrayOutputStream baos = new ByteArrayOutputStream();
					PdfWriter writer = PdfWriter.getInstance(document, baos);
					document.open();
					_log.info("----2----");
					_log.info("delegations="+delegations);
					if(Validator.isNotNull(delegations)){
						_log.info("----3----");
						for(ESFNationalDelegation del : delegations){
							_log.info("----4----");
							_log.info("del="+del);
							ESFUser shooter = new ESFUserImpl();
							ESFDeparture leaveDeparture = new ESFDepartureImpl();
							ESFDeparture returnDeparture = new ESFDepartureImpl();
							
							String partecipantName = "";
							String _travelLeaveDate = "";
							String _travelLeaveMeetingHour = "";
							String _meetingLeavePace = "";
							String _travelLeaveHour = "";
							String _travelLeaveCode = "";
							String _travelLeaveArrivalTo = "";
							String _travelArrivalHour = "";
							String _tralvelReturnDate = "";
							String _travelReturnHourStart  = "";
							String _travelReturnMeetingPlace  = "";
							String _travelReturnCode = "";
							String _travelRturnArrivalTo = "";
							String _travelReturnHourArrive = "";
							
							List<ESFDeparture> departures = ESFDepartureLocalServiceUtil.getByEsfMatchIdEsfUserId(matchId, del.getEsfUserId());
							_log.info("----5----");
							_log.info("----departures----"+departures);
							for(ESFDeparture dep : departures){
								_log.info("----6----");
								if(dep.getIsReturn()){
									returnDeparture = dep;
								}else{
									leaveDeparture = dep;
								}
							}
							_log.info("----7----");
							if(Validator.isNotNull(returnDeparture)){
								_tralvelReturnDate = sdf.format(returnDeparture.getLeaveDate());
								_travelReturnHourStart = returnDeparture.getLeaveHour();
								_travelReturnMeetingPlace = returnDeparture.getDepartureFrom();
								_travelReturnCode = returnDeparture.getCode();
								_travelRturnArrivalTo = returnDeparture.getArrivalTo();
								_travelReturnHourArrive = returnDeparture.getArriveHour();
							}
							
							if(Validator.isNotNull(leaveDeparture)){
								_travelLeaveDate = sdf.format(leaveDeparture.getLeaveDate());
								_travelLeaveMeetingHour = leaveDeparture.getLeaveHour();
								_meetingLeavePace = leaveDeparture.getMeetingPlace();
								_travelLeaveHour = leaveDeparture.getLeaveHour();
								_travelLeaveCode = leaveDeparture.getCode();
								_travelLeaveArrivalTo = leaveDeparture.getArrivalTo();
								_travelArrivalHour = leaveDeparture.getArriveHour();
							}
							_log.info("----8----");
							content = content.replaceAll("_tralvelReturnDate", _tralvelReturnDate);
							content = content.replaceAll("_travelReturnHourStart", _travelReturnHourStart);
							content = content.replaceAll("_travelReturnMeetingPlace", _travelReturnMeetingPlace);
							content = content.replaceAll("_travelReturnCode", _travelReturnCode);
							content = content.replaceAll("_travelRturnArrivalTo", _travelRturnArrivalTo);
							content = content.replaceAll("_travelReturnHourArrive", _travelReturnHourArrive);
							
							
							content = content.replaceAll("_travelLeaveDate", _travelLeaveDate);
							content = content.replaceAll("_travelLeaveMeetingHour", _travelLeaveMeetingHour);
							content = content.replaceAll("_meetingLeavePace", _meetingLeavePace);
							content = content.replaceAll("_travelLeaveHour", _travelLeaveHour);
							content = content.replaceAll("_travelLeaveCode", _travelLeaveCode);
							content = content.replaceAll("_travelLeaveArrivalTo", _travelLeaveArrivalTo);
							content = content.replaceAll("_travelArrivalHour", _travelArrivalHour);
							
							_log.info("----9----");
							
							if(Validator.isNotNull(del.getEsfUserId()) && Validator.isNotNull(ESFUserLocalServiceUtil.fetchESFUser(del.getEsfUserId()))){
								_log.info("----10----");
								shooter = ESFUserLocalServiceUtil.fetchESFUser(del.getEsfUserId());
								_log.info("----10----shooter="+shooter);
								if(Validator.isNotNull(shooter.getFirstName())){
									partecipantName = (partecipantName + shooter.getFirstName()+" ").toUpperCase();
								}
								if(Validator.isNotNull(shooter.getLastName())){
									partecipantName = (partecipantName + shooter.getLastName()).toUpperCase();
								}
								_log.info("----11----");
								content = content.replaceAll("_shooterNameNM", partecipantName);
								
								_log.info("----12----");
								XMLWorkerHelper worker = XMLWorkerHelper.getInstance();
								InputStream is = new ByteArrayInputStream(content.getBytes(StandardCharsets.UTF_8));
								worker.parseXHtml(writer, document, is, Charset.forName("UTF-8"));
								_log.info("----13----");
							}
							
						}
					}
					_log.info("----14----");
					document.close();
					resp.setContentType("application/pdf");
					resp.addProperty(HttpHeaders.CACHE_CONTROL, "max-age=3600, must-revalidate");
					resp.addProperty(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename= Convocazione alla gara "+match.getCode()+".pdf;");
					_log.info("----15----");
					OutputStream out = resp.getPortletOutputStream();
					baos.writeTo(out);
					out.flush();
					out.close();
					_log.info("----16----");
				}catch (Exception e2) {
				_log.info("nel catch");
				e2.printStackTrace();
				return isOk=false;
			}
			return isOk=true;
		}else{
			return isOk=false;
		}	
	
	}
	
	public JSONObject serveFiscalCode(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws Exception {
		// TODO Auto-generated method stub
		
		JSONObject jsonFiscalCode = JSONFactoryUtil.createJSONObject();
		
		String result = "ko";
		String fiscalCode = "01";
		
		String lastName =
				ParamUtil.getString(resourceRequest,"lastName");
		String firstName =
				ParamUtil.getString(resourceRequest,"firstName");
		String birthcity =
				ParamUtil.getString(resourceRequest,"birthcity");
		Boolean male =
				ParamUtil.getBoolean(resourceRequest,"male");
		String birthday =
				ParamUtil.getString(resourceRequest,"birthday");
		String sex = "f";
		if (male){
			
			sex = "m";
			
		}
		
		String url = "http://webservices.dotnethell.it/codicefiscale.asmx/CalcolaCodiceFiscale?Nome="+firstName+"&Cognome="+lastName+"&ComuneNascita="
					+birthcity+"&DataNascita="+birthday+"&Sesso="+sex;
		URL obj = new URL(url);
		
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		
		URLConnection connection = new URL(url).openConnection();
		
		con.setRequestMethod("GET");
		
		try {
			int responseCode = con.getResponseCode();
		} catch (Exception e) {
			// TODO: handle exception
			fiscalCode = "02";
			jsonFiscalCode.put("result", result);
			jsonFiscalCode.put("fiscalCode", fiscalCode);
			
			return jsonFiscalCode;
		}
		
		int responseCode = con.getResponseCode();
		
		BufferedReader in = new BufferedReader(
			new InputStreamReader(con.getInputStream()));
		
		String inputLine;
		
		StringBuffer response = new StringBuffer();
		
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		
		String responseString = response.toString();
		
		
				
		if(responseString.length()>117 && !responseString.substring(101,117).contains(" ") && (StringPool.BLANK != birthday )
				&& (StringPool.BLANK != lastName ) && (StringPool.BLANK != firstName ) && (StringPool.BLANK != birthcity)){
			result = "ok";
			fiscalCode = responseString.substring(101,117);
		}
		jsonFiscalCode.put("result", result);
		jsonFiscalCode.put("fiscalCode", fiscalCode);
		return jsonFiscalCode;
	}

	public void addESFShooter(
		ActionRequest actionRequest, ActionResponse actionResponse)
		throws PortalException, SystemException, ParseException {

		ServiceContext serviceContext =
			ServiceContextFactory.getInstance(
				ESFUser.class.getName(), actionRequest);

		String firstName = ParamUtil.getString(actionRequest, "firstName");
		String lastName = ParamUtil.getString(actionRequest, "lastName");
		String middleName = ParamUtil.getString(actionRequest, "middleName");
		String userEmail = ParamUtil.getString(actionRequest, "userEmail");
		String fiscalCode = ParamUtil.getString(actionRequest, "fiscalCode");
		
		if (Validator.isNotNull(fiscalCode)) {

			if (!ManageOperationsField.validate(fiscalCode))

				SessionErrors.add(actionRequest, "error");
			return;
		}
		String es = ParamUtil.getString(actionRequest, "birthday");
		Date birthday = null;
		try {
			birthday = ManageDate.StringToDate(es);
		}
		catch (ParseException e1) {
			e1.printStackTrace();
			throw new PortalException(e1);
		}
		int year = ManageDate.getYear(birthday);
		int month = ManageDate.getMonth(birthday);
		int day = ManageDate.getDay(birthday);

		String birthcity = ParamUtil.getString(actionRequest, "birthcity");

		String nationality = ParamUtil.getString(actionRequest, "nationality");

		boolean male = ParamUtil.getBoolean(actionRequest, "male");

		long esfEntityStateId = ParamUtil.getLong(actionRequest, "esfStateId");

		List<ESFPhone> phones =
			ManageOperationsField.getPhones(actionRequest, actionResponse);

		long esfCardId = ParamUtil.getLong(actionRequest, "esfCardId");

		List<ESFAddress> addresses =
			ManageOperationsField.getAddresses(actionRequest, actionResponse);

		String skype = ParamUtil.getString(actionRequest, "skype");
		String facebook = ParamUtil.getString(actionRequest, "facebook");
		String twitter = ParamUtil.getString(actionRequest, "twitter");

		boolean ckisarmy = ParamUtil.getBoolean(actionRequest, "ckisarmy");
		boolean isSportsGroups = false;
		long typearmy = 0;
		if (ckisarmy) {
			typearmy = ParamUtil.getLong(actionRequest, "typearmy");
			isSportsGroups =
				ParamUtil.getBoolean(actionRequest, "isSportsGroups");
		}

		String job = ParamUtil.getString(actionRequest, "job");

		String jobTitle = ParamUtil.getString(actionRequest, "jobTitle");

		String issfIdNumber =
			ParamUtil.getString(actionRequest, "issfIdNumber");

		try {
			if (ESFUserLocalServiceUtil.checkEmailAddress(
				userEmail, serviceContext) != null) {
				SessionErrors.add(actionRequest, "user-email-message");
			}
			else if (ckisarmy && typearmy <= 0) {
				SessionErrors.add(actionRequest, "select-type-of-army");
			}
			else {

				ESFEntityState esfEntityState = new ESFEntityStateImpl();
				esfEntityState.setEsfStateId(esfEntityStateId);

				ESFCard esfCard = ESFCardLocalServiceUtil.getESFCard(esfCardId);

				ESFUser userResult =
					ESFUserLocalServiceUtil.addESFShooter(
						serviceContext.getUserId(), StringPool.BLANK,
						firstName, middleName, lastName, userEmail, fiscalCode,
						day, month, year, birthcity, nationality, male, skype,
						facebook, twitter, typearmy, isSportsGroups, job,
						jobTitle, issfIdNumber, esfEntityState, esfCard,
						addresses, phones, serviceContext);

				if (Validator.isNotNull(userResult) &&
					userResult.getEsfUserId() > 0)
					SessionMessages.add(actionRequest, "shooter-success-insert");
				else
					SessionErrors.add(actionRequest, "shooter-error-insert");

			}
		}
		catch (ContactBirthdayException cbe) {
			SessionErrors.add(actionRequest, "user-birthday-message");
			cbe.printStackTrace();
		}
		catch (Exception e) {
			_log.error("Error in addESFUser method: " + e.getMessage());
			SessionErrors.add(actionRequest, "shooter-error-insert");
			e.printStackTrace();
		}
	}

	public void updateESFShooter(
		ActionRequest actionRequest, ActionResponse actionResponse)
		throws PortalException, SystemException, ParseException {

		ServiceContext serviceContext =
			ServiceContextFactory.getInstance(
				ESFUser.class.getName(), actionRequest);
		
		long esfUserId = ParamUtil.getLong(actionRequest, "esfUserId");
		String firstName = ParamUtil.getString(actionRequest, "firstName");
		String lastName = ParamUtil.getString(actionRequest, "lastName");
		String middleName = ParamUtil.getString(actionRequest, "middleName");
		String userEmail = ParamUtil.getString(actionRequest, "userEmail");
		String fiscalCode = ParamUtil.getString(actionRequest, "fiscalCode");
		long esfMatchId = ParamUtil.getLong(actionRequest, "esfMatchId");
		
		if (Validator.isNotNull(fiscalCode)) {
			
			if (!ManageOperationsField.validate(fiscalCode)){
				SessionErrors.add(actionRequest, "error");
				return;
			}
		}
		
		String es = ParamUtil.getString(actionRequest, "birthday");
		Date birthday = null;
		try {
			birthday = ManageDate.StringToDate(es);
		}
		catch (ParseException e1) {
			e1.printStackTrace();
			throw new PortalException(e1);
		}

		int year = ManageDate.getYear(birthday);
		int month = ManageDate.getMonth(birthday);
		int day = ManageDate.getDay(birthday);
		
		String birthcity = ParamUtil.getString(actionRequest, "birthcity");
		
		String nationality = ParamUtil.getString(actionRequest, "nationality");
		boolean male = ParamUtil.getBoolean(actionRequest, "male");

		long esfEntityStateId = ParamUtil.getLong(actionRequest, "esfStateId");
		
		ESFCard card = ESFCardLocalServiceUtil.getEsfCardByEsfUserId(esfUserId);

		long esfCardId = card.getEsfCardId();

		//long esfCardId = ParamUtil.getLong(actionRequest, "esfCardId");
		List<ESFAddress> addresses =
			ManageOperationsField.getAddresses(actionRequest, actionResponse);

		List<ESFPhone> phones =
			ManageOperationsField.getPhones(actionRequest, actionResponse);

		String skype = ParamUtil.getString(actionRequest, "skype");
		String facebook = ParamUtil.getString(actionRequest, "facebook");
		String twitter = ParamUtil.getString(actionRequest, "twitter");

		boolean ckisarmy = ParamUtil.getBoolean(actionRequest, "ckisarmy");
		boolean isSportsGroups = false;
		long typearmy = 0;
		if (ckisarmy) {
			typearmy = ParamUtil.getLong(actionRequest, "typearmy");
			isSportsGroups =
				ParamUtil.getBoolean(actionRequest, "isSportsGroups");
		}

		String job = ParamUtil.getString(actionRequest, "job");
		String jobTitle = ParamUtil.getString(actionRequest, "work");
		String issfIdNumber =
			ParamUtil.getString(actionRequest, "issfIdNumber");

		boolean disable = ParamUtil.getBoolean(actionRequest, "disable");

		ESFUser esfUserToUpdate = null;
		
		try {
			esfUserToUpdate = ESFUserLocalServiceUtil.getESFUser(esfUserId);
			if (ESFUserLocalServiceUtil.checkEmailAddress(
				userEmail, serviceContext) != null &&
				!esfUserToUpdate.getUserEmail().equals(userEmail)) {
				SessionErrors.add(actionRequest, "user-email-message");
			}
			else if (ckisarmy && typearmy <= 0) {
				SessionErrors.add(actionRequest, "select-type-of-army");
			}
			else {

				ESFEntityState esfEntityState = new ESFEntityStateImpl();
				esfEntityState.setEsfStateId(esfEntityStateId);

				ESFCard esfCard = ESFCardLocalServiceUtil.getESFCard(esfCardId);

				ESFUser userResult =
					ESFUserLocalServiceUtil.updateESFShooter(
						serviceContext.getUserId(), esfUserId, "", firstName,
						middleName, lastName, userEmail, fiscalCode, day,
						month, year, birthcity, nationality, male, disable,
						skype, facebook, twitter, typearmy, isSportsGroups,
						job, jobTitle, issfIdNumber, esfEntityState, esfCard,
						addresses, phones, serviceContext);

				if (Validator.isNotNull(userResult) &&
					userResult.getEsfUserId() > 0) {
					SessionMessages.add(actionRequest, "shooter-success-update");

				}
				else
					SessionErrors.add(actionRequest, "shooter-error-update");

			}
		}
		catch (ContactBirthdayException cbe) {
			SessionErrors.add(actionRequest, "user-birthday-message");
		}
		catch (Exception e) {
			SessionErrors.add(actionRequest, "shooter-error-update");
			_log.error("Error in updateESFUser method: " + e.getMessage());
			e.printStackTrace();
		}
		finally {
			actionRequest.setAttribute("esfMatchId", esfMatchId);
			actionRequest.setAttribute("esfUserId", esfUserId);
			actionRequest.setAttribute("op", "updAddr");
			actionResponse.setRenderParameter("esfUserId",String.valueOf(esfUserId));
			actionResponse.setRenderParameter("myParam", "Generale");
			actionResponse.setRenderParameter(
				"mvcPath", "/html/esfnationalmatch/tabs/edit_esfShooter.jsp");
		}
	}

	private long StringToLong(String value) {

		if (value != null && !value.equals(""))
			return Long.parseLong(value);

		else
			return 0;
	}

	public void deleteESFDeparturePartecipant(
		ActionRequest request, ActionResponse response)
		throws SystemException {

		long esfUserId = ParamUtil.getLong(request, "esfUserId");
		long esfMatchId = ParamUtil.getLong(request, "esfMatchId");

		ESFDeparture esfDeparture;
		try {
			esfDeparture =
				ESFDepartureLocalServiceUtil.getByEsfMatchIdEsfUserId(
					esfMatchId, esfUserId).get(0);
			ESFDepartureLocalServiceUtil.deleteESFDeparture(esfDeparture);
		}
		catch (Exception e) {
			e.getMessage();
		}

		response.setRenderParameter("esfMatchId", String.valueOf(esfMatchId) );
		response.setRenderParameter("myParam", "Itenerari");
		response.setRenderParameter(
			"mvcPath", "/html/esfnationalmatch/management_esfMatch.jsp");
	}

	public void deleteESFDeparture(ActionRequest request, ActionResponse response) {

		long esfDepartureId = ParamUtil.getLong(request, "esfDepartureId");
		long esfMatchId = ParamUtil.getLong(request, "esfMatchId");
		
		try {
			ESFDeparture esfDeparture = ESFDepartureLocalServiceUtil.
											fetchESFDeparture(esfDepartureId);
			
			/*Cancello anche tutti gli utenti assegnati*/
			
			if(Validator.isNull(esfDeparture.getEsfUserId()) || 
							esfDeparture.getEsfUserId() != 0){
				List<ESFDeparture> allDepartures = ESFDepartureLocalServiceUtil.
										getESFDeparturesByEsfMatchId_F_L_L_C_D(
											esfMatchId, esfDeparture.getCode(), 
											esfDeparture.getLeaveDate(),
											esfDeparture.getLeaveHour(),
											esfDeparture.getCompanyName(),
											esfDeparture.getDepartureFrom());
				if(Validator.isNotNull(allDepartures)){
					for(ESFDeparture e : allDepartures){
						if(Validator.isNotNull(e.getEsfUserId()) && e.getEsfUserId() > 0){
							ESFDepartureLocalServiceUtil.deleteESFDeparture(e);
						}
					}
				}
			}
		}
		catch (SystemException e1) {
			e1.printStackTrace();
		}

		try {
			ESFDepartureLocalServiceUtil.deleteESFDeparture(esfDepartureId);
		}
		catch (Exception e) {
			e.getMessage();
		}
		finally {
			response.setRenderParameter("esfMatchId", String.valueOf(esfMatchId) );
			response.setRenderParameter("myParam", "Itenerari");
			response.setRenderParameter(
				"mvcPath", "/html/esfnationalmatch/management_esfMatch.jsp");
		}

	}

	public void addUserToESFDeparture(
		ActionRequest request, ActionResponse response) {

		long esfDepartureId = ParamUtil.getLong(request, "esfDepartureId");

		long esfUserId = ParamUtil.getLong(request, "esfUserId");

		long esfMatchId = ParamUtil.getLong(request, "esfMatchId");
		try {
			ESFDeparture esfDeparture =
				ESFDepartureLocalServiceUtil.fetchESFDeparture(esfDepartureId);

			ServiceContext serviceContext =
				ServiceContextFactory.getInstance(request);

			long userId = serviceContext.getUserId();

			String code = esfDeparture.getCode();

			String companyName = esfDeparture.getCompanyName();

			String departureFrom = esfDeparture.getDepartureFrom();

			String arrivalTo = esfDeparture.getArrivalTo();

			Date leaveDate = esfDeparture.getLeaveDate();

			String leaveHour = esfDeparture.getLeaveHour();

			Date arriveDate = esfDeparture.getArriveDate();

			String arriveHour = esfDeparture.getArriveHour();

			User user = UserLocalServiceUtil.fetchUser(userId);
			
			String stopover = esfDeparture.getStopoverId();

			long groupId = user.getGroupId();

			long companyId = user.getCompanyId();

			Date createDate = new Date();
			String meetingPlace = esfDeparture.getMeetingPlace();
			String typeTravel = esfDeparture.getTypeTravel();
			Boolean returned = ParamUtil.getBoolean(request, "isReturn");

			ESFDepartureLocalServiceUtil.addEsfDeparture(
				groupId, companyId, user.getFullName(), userId, esfUserId,
				code, leaveDate, arriveDate, createDate, leaveHour,
				arriveHour, companyName, departureFrom, arrivalTo,
				esfMatchId, returned,meetingPlace, typeTravel, stopover);

			SessionMessages.add(request, "esfDepartureAdded");

			response.setRenderParameter(
				"esfDepartureId", Long.toString(esfDepartureId));
		}
		catch (Exception e) {
			e.getMessage();
		}
		finally {
			response.setRenderParameter("esfMatchId", String.valueOf(esfMatchId));
			response.setRenderParameter("myParam", "Itenerari");
			response.setRenderParameter(
				"mvcPath", "/html/esfnationalmatch/management_esfMatch.jsp");
		}
	}

	public void editESFDeparture(ActionRequest request, ActionResponse response)
		throws PortalException, SystemException, ParseException {

		ServiceContext serviceContext =
			ServiceContextFactory.getInstance(request);
		ESFDeparture created = new ESFDepartureImpl();
		String allUserIds = ParamUtil.getString(request, "allPresentUsers");
		String allUsersToAddString = ParamUtil.getString(request, "esfUserIds");
		String isBus = ParamUtil.getString(request, "isBus");
	
		long userId = serviceContext.getUserId();

		long esfDepartureId = ParamUtil.getLong(request, "esfDepartureId");

		long esfUserId = ParamUtil.getLong(request, "esfUserId");

		long esfMatchId = ParamUtil.getLong(request, "esfMatchId");

		String companyName = ParamUtil.getString(request, "companyName");
		String departureFrom =	ParamUtil.getString(request, "departureFrom");
		String code = ParamUtil.getString(request, "code");
		String arrivalTo= ParamUtil.getString(request, "arrivalTo");

		String leaveD = ParamUtil.getString(request, "leaveDate");

		Date leaveDate = ManageDate.StringToDate(leaveD);

		String leaveHour = ParamUtil.getString(request, "leaveHour");

		String arriveD = ParamUtil.getString(request, "arriveDate");

		Date arriveDate = ManageDate.StringToDate(arriveD);

		String arriveHour = ParamUtil.getString(request, "arriveHour");
		String meetingPlace = ParamUtil.getString(request, "meetingPlace");
	    String typeTravel =  ParamUtil.getString(request, "typeTravel");
		Boolean returned = ParamUtil.getBoolean(request, "isReturn");
		String[] values = ParamUtil.getParameterValues(request, "values", new String[0]);
		String stopover = "";
		
		int lastIndexUserToDelete = 0;
		List <Long> longUserIdisToDelete = new ArrayList<Long>();
		if(Validator.isNotNull(allUserIds)){
			for(int i = 0; i < allUserIds.length(); i++){
				if(allUserIds.charAt(i) == ('/')){
					String userIdString = allUserIds.substring(lastIndexUserToDelete, i);
					lastIndexUserToDelete = i + 1;
					long userIdLong = Long.valueOf(userIdString);
					if(userIdLong > 0){
						longUserIdisToDelete.add(userIdLong);
					}
				}
			}
		}
		int lastIndexUsersToAdd = 0;
		List <Long> longUserIdisToAdd = new ArrayList<Long>();
		if(Validator.isNotNull(allUsersToAddString)){
			for(int i = 0; i < allUsersToAddString.length(); i++){
				if(allUsersToAddString.charAt(i) == ('/')){
					String userIdString = allUsersToAddString.substring(lastIndexUsersToAdd, i);
					lastIndexUsersToAdd = i + 1;
					long userIdLong = Long.valueOf(userIdString);
					if(userIdLong > 0){
						longUserIdisToAdd.add(userIdLong);
					}
				}
			}
		}
		if(values.length > 0){
			for(String val : values){
				
				stopover = stopover+"-"+val;
				
			}
		}
		try {
			User user = UserLocalServiceUtil.fetchUser(userId);

			long groupId = user.getGroupId();

			long companyId = user.getCompanyId();

			if (esfDepartureId > 0) {
				ESFDeparture e = ESFDepartureLocalServiceUtil.getESFDeparture(esfDepartureId);
				
				List<ESFDeparture> esfDepartures = ESFDepartureLocalServiceUtil.getESFDeparturesByEsfMatchId_F_L_L_C_D(esfMatchId, e.getCode(), 
						e.getLeaveDate(), e.getLeaveHour(), e.getCompanyName(), e.getDepartureFrom());
				
				for(ESFDeparture esfDeparture : esfDepartures){
					
					if(esfDeparture.getEsfUserId()!=0){
						Date modifiedDate = new Date();
						ESFDepartureLocalServiceUtil.updateEsfDeparture(
							esfDeparture.getEsfDepartureId(), groupId, companyId, user.getFullName(),
							esfDeparture.getEsfUserId(), user.getUserId(), code, modifiedDate,
							leaveDate, leaveHour, arriveDate, arriveHour, companyName,
							departureFrom, arrivalTo, esfMatchId, returned,meetingPlace,typeTravel,stopover);
					}
				}
				
				if(longUserIdisToDelete.size() > 0){
					for(ESFDeparture esfDeparture : esfDepartures){
						for(Long l : longUserIdisToDelete){
							if(esfDeparture.getEsfUserId() == l){
								ESFDepartureLocalServiceUtil.deleteESFDeparture(
									esfDeparture.getEsfDepartureId());
							}
						}
					}
				}
				
				
				if(longUserIdisToAdd.size() > 0){
						for(Long l : longUserIdisToAdd){
								Date createDate = new Date();
								ESFDepartureLocalServiceUtil.addEsfDeparture(
									groupId, companyId, user.getFullName(), userId, l,
									code, leaveDate, arriveDate, createDate, leaveHour,
									arriveHour, companyName, departureFrom, arrivalTo,
									esfMatchId, returned,meetingPlace,typeTravel,stopover);
						}
				}
				
				
				Date modifiedDate = new Date();
				ESFDepartureLocalServiceUtil.updateEsfDeparture(
					esfDepartureId, groupId, companyId, user.getFullName(),
					esfUserId, user.getUserId(), code, modifiedDate,
					leaveDate, leaveHour, arriveDate, arriveHour, companyName,
					departureFrom, arrivalTo, esfMatchId, returned,meetingPlace,typeTravel,stopover);
				

				SessionMessages.add(request, "esfDepartureUpdated");
				response.setRenderParameter("esfMatchId", String.valueOf(esfMatchId));
				response.setRenderParameter( "esfDepartureId", Long.toString(esfDepartureId));
				
			}else {
				Date createDate = new Date();
				created = ESFDepartureLocalServiceUtil.addEsfDeparture(
					groupId, companyId, user.getFullName(), userId, esfUserId,
					code, leaveDate, arriveDate, createDate, leaveHour,
					arriveHour, companyName, departureFrom, arrivalTo,
					esfMatchId, returned,meetingPlace,typeTravel,stopover);
				if(longUserIdisToAdd.size() > 0){
					for(Long l : longUserIdisToAdd){
						ESFDepartureLocalServiceUtil.addEsfDeparture(
							groupId, companyId, user.getFullName(), userId, l,
							code, leaveDate, arriveDate, createDate, leaveHour,
							arriveHour, companyName, departureFrom, arrivalTo,
							esfMatchId, returned,meetingPlace,typeTravel,stopover);
					}
				}

				SessionMessages.add(request, "esfDeaprtureAdded");
			}
		}
		catch (Exception e) {
			e.getMessage();
		}
		finally {
			response.setRenderParameter("esfMatchId", String.valueOf(esfMatchId));

			if(Validator.isNotNull(created) && 
							Validator.isNotNull(created.getEsfDepartureId())&&
							created.getEsfDepartureId() > 0){
				
				//request.setAttribute("esfDepartureId", created.getEsfDepartureId());
				//request.setAttribute("esfDepartureId", esfDepartureId);
				response.setRenderParameter("esfDepartureId", String.valueOf(created.getEsfDepartureId()));
				
			}
			else{
				response.setRenderParameter("esfMatchId", String.valueOf(esfMatchId));
				request.setAttribute("esfDepartureId", esfDepartureId);
			}
			//response.setRenderParameter("myParam", "Itenerari");
			if(isBus.equals("true")){
				response.setRenderParameter("esfMatchId", String.valueOf(esfMatchId));
				response.setRenderParameter("mvcPath", "/html/esfnationalmatch/edit_esfDepartureB.jsp");
			}
			else{
			response.setRenderParameter("esfMatchId", String.valueOf(esfMatchId));
			response.setRenderParameter("mvcPath", "/html/esfnationalmatch/edit_esfDeparture.jsp");
			}
		}

	}

	public void editESFGun(ActionRequest request, ActionResponse response)
		throws PortalException, SystemException {

		ServiceContext serviceContext =
			ServiceContextFactory.getInstance(ESFGun.class.getName(), request);
		// long organizationId = ParamUtil.getLong(request, "organizationId");
		long esfMatchId = ParamUtil.getLong(request, "esfMatchId");
		long esfGunId = ParamUtil.getLong(request, "esfGunId");
		String code = ParamUtil.getString(request, "code");
		long esfGunKindId = ParamUtil.getLong(request, "esfGunKindId");
		// long esfGunTypeId = ParamUtil.getLong(request, "esfGunTypeId");
		long esfOrganizationId =
			ParamUtil.getLong(request, "esfOrganizationId");
		long esfUserId = ParamUtil.getLong(request, "esfUserId");
		String registrationNumber =
			ParamUtil.getString(request, "registrationNumber");
		long catridgeCaliber = ParamUtil.getLong(request, "catridgeCaliber");
		boolean isFavoriteGun = ParamUtil.getBoolean(request, "isFavoriteGun");
		String note=ParamUtil.getString(request, "note");
		int typology=ParamUtil.getInteger(request, "typology");
		String measures=ParamUtil.getString(request, "measures");
		String name = ParamUtil.getString(request, "name");;
		if (esfGunId > 0) {
			ESFGun esfGun = ESFGunLocalServiceUtil.getESFGun(esfGunId);

			if (ESFGunLocalServiceUtil.checkCode(code, serviceContext) != null &&
				!esfGun.getCode().equals(code)) {
				SessionErrors.add(request, "esfGun-reference-error");
			}
			else {
				ESFGunLocalServiceUtil.updateESFGun(
					serviceContext.getUserId(), esfGunId, code, esfGunKindId,
					esfOrganizationId, esfUserId, registrationNumber,
				 catridgeCaliber,typology,measures,
					isFavoriteGun,note, name, serviceContext);
			}
		}
		else {
			if (ESFGunLocalServiceUtil.checkCode(code, serviceContext) != null) {
				SessionErrors.add(request, "esfGun-reference-error");
			}
			else {
				ESFGunLocalServiceUtil.addESFGun(
					serviceContext.getUserId(), code, esfGunKindId,
					esfOrganizationId, esfUserId, registrationNumber,
					 catridgeCaliber, typology,measures,
					isFavoriteGun,note, name, serviceContext);
			}
		}
		request.setAttribute("esfMatchId", esfMatchId);
		request.setAttribute("esfUserId", esfUserId);
		request.setAttribute("op", "updAddr");
		request.setAttribute("organizationId", esfOrganizationId);
		response.setRenderParameter(
			"mvcPath", "/html/esfnationalmatch/tabs/edit_esfShooter.jsp");
		response.setRenderParameter("esfUserId", String.valueOf(esfUserId));
		response.setRenderParameter("esfMatchId", String.valueOf(esfMatchId));
		response.setRenderParameter("op", "updAddr");

	}
	
	public void editESFCatridge(ActionRequest request, ActionResponse response)
			throws PortalException, SystemException, PortletException {

ServiceContext serviceContext =
		ServiceContextFactory.getInstance(ESFGun.class.getName(), request);
	long esfMatchId = ParamUtil.getLong(request, "esfMatchId");
	long esfCatridgeId = ParamUtil.getLong(request, "esfCatridgeId");
	long esfUserId = ParamUtil.getLong(request, "esfUserId");
	long catridgeModel = ParamUtil.getLong(request, "catridgeModel");
	long catridgeCaliber = ParamUtil.getLong(request, "catridgeCaliber");
	long esfGunTypeId = ParamUtil.getLong(request, "esfGunTypeId");
	String note=ParamUtil.getString(request, "note");
	long esfOrganizationId =
			ParamUtil.getLong(request, "esfOrganizationId");
	long shooteId = ParamUtil.getLong(request, "esfUserId");
	long catridgeModelId = ParamUtil.getLong(request, "catridgeModel");
	int type = ESFKeys.ESFGunType.CATRIDGE;
	String code = "";
	boolean isFavoriteGun = false;
	long gunId = 0;
	long caliber = 0;
	
	
	if(catridgeModelId > 0){
		gunId = catridgeModelId;
		ESFCatridge catridge = ESFCatridgeLocalServiceUtil.fetchESFCatridge(catridgeModelId);
		caliber = catridge.getCatridgeCaliber();
	
	}else{
		gunId = esfGunTypeId;
	}
	
	
	
	if( shooteId > 0){
		ESFgunUserLocalServiceUtil.addESFGunUser(gunId, shooteId,
				code, isFavoriteGun, type, note, esfGunTypeId,
				catridgeModelId, 0, "", caliber , serviceContext);
	}else{
		SessionErrors.add(request, "Catridge-reference-error");
	}
	
	
		request.setAttribute("esfMatchId", esfMatchId);
		request.setAttribute("esfUserId", esfUserId);
		request.setAttribute("op", "updAddr");
		
		response.setRenderParameter("mvcPath", "/html/esfnationalmatch/tabs/edit_esfShooter.jsp");
		
		response.setRenderParameter("esfUserId", String.valueOf(esfUserId));
		response.setRenderParameter("esfMatchId", String.valueOf(esfMatchId));
		response.setRenderParameter("op", "updAddr");

	}
	
	public void editESFCane(ActionRequest request, ActionResponse response)
			throws PortalException, SystemException {

			ServiceContext serviceContext =
				ServiceContextFactory.getInstance(ESFGun.class.getName(), request);
			// long organizationId = ParamUtil.getLong(request, "organizationId");
			long esfMatchId = ParamUtil.getLong(request, "esfMatchId");
			long esfCaneId = ParamUtil.getLong(request, "esfCaneId");
			long esfGunKindId = ParamUtil.getLong(request, "esfGunKindId");
			long esfOrganizationId =
				ParamUtil.getLong(request, "esfOrganizationId");
			long esfUserId = ParamUtil.getLong(request, "esfUserId");
			long caneCaliber =  ParamUtil.getLong(request, "caliber");
			int typeId= ParamUtil.getInteger(request, "typology") ;
			String measures=ParamUtil.getString(request, "measures");
			boolean isFavoriteGun = ParamUtil.getBoolean(request, "isFavoriteGun");
			String code=ParamUtil.getString(request, "code");
			long shooterId = ParamUtil.getLong(request, "userId");
			String noteShooter=ParamUtil.getString(request, "noteShooter");
			long esfGunUserId = ParamUtil.getLong(request, "esfGunUserId");
			long esfGunTypeId = ParamUtil.getLong(request, "esfGunTypeId");
			

			int type = ESFKeys.ESFGunType.CANE;
			String shooter_note = ParamUtil.getString(request, "shooter_note");
			
			ESFGunKind kind = new ESFGunKindImpl();
			List<ESFgunUser> codeGuns = new ArrayList<ESFgunUser>();
			
			
		
			codeGuns = ESFgunUserLocalServiceUtil.findbyCode(code);
			
			if(codeGuns.size() > 0){
				SessionErrors.add(request, "duplicate_code");
				
				response.setRenderParameter( "mvcPath", "/html/esfnationalmatch/tabs/edit_esfShooter.jsp");
				response.setRenderParameter("esfUserId", String.valueOf(esfUserId));
				response.setRenderParameter( "esfMatchId", String.valueOf(esfMatchId));

				return ; 
			}else{
				
				ESFCaneLocalServiceUtil.addESFCane(
					serviceContext.getUserId(), esfGunKindId,esfGunTypeId,
					esfUserId, esfOrganizationId, code, caneCaliber, typeId, 
					measures, isFavoriteGun, esfUserId, shooter_note, serviceContext);

			
			}	
			response.setRenderParameter( "mvcPath", "/html/esfnationalmatch/tabs/edit_esfShooter.jsp");
			response.setRenderParameter("esfUserId", String.valueOf(esfUserId));
			response.setRenderParameter( "esfMatchId", String.valueOf(esfMatchId));

		}
	
	
	
	public void deleteESFGun(ActionRequest request, ActionResponse response)
			throws PortalException, SystemException {

			ServiceContext serviceContext =
				ServiceContextFactory.getInstance(ESFGun.class.getName(), request);
			String esfUserId=ParamUtil.getString(request, "esfUserId");

			//String mvc=ParamUtil.getString(request, "mvcPath");
			
			long esfMatchId = ParamUtil.getLong(request, "esfMatchId");
			long esfGunId = ParamUtil.getLong(request, "esfGunId");
			long esfgunUserId = ParamUtil.getLong(request, "esfgunUserId");
			if (esfgunUserId > 0) {
				ESFgunUser esFgunUser = ESFgunUserLocalServiceUtil.fetchESFgunUser(esfgunUserId);
				ESFgunUserLocalServiceUtil.deleteESFgunUser(esFgunUser);
			}
			response.setRenderParameter("mvcPath", "/html/esfnationalmatch/tabs/edit_esfShooter.jsp");
			response.setRenderParameter("esfUserId", String.valueOf(esfUserId));
			response.setRenderParameter("esfMatchId", String.valueOf(esfMatchId));
		
}
	
	
	
	public void deleteESFCatridge(ActionRequest request, ActionResponse response)

					throws PortalException, SystemException {

					ServiceContext serviceContext =
						ServiceContextFactory.getInstance(ESFCatridge.class.getName(), request);
					String esfUserId=ParamUtil.getString(request, "esfUserId");
					long esfMatchId = ParamUtil.getLong(request, "esfMatchId");
					long esfCatridgeId = ParamUtil.getLong(request, "esfCatridgeId");
					if (esfCatridgeId > 0) {

						ESFCatridgeLocalServiceUtil.deleteESFCatridge(esfCatridgeId, serviceContext);
					}
					response.setRenderParameter(
						"mvcPath", "/html/esfnationalmatch/tabs/edit_esfShooter.jsp");
					response.setRenderParameter("esfUserId", String.valueOf(esfUserId));
					response.setRenderParameter("esfMatchId", String.valueOf(esfMatchId));
					
				
	}
	
	public void deleteESFCane(ActionRequest request, ActionResponse response)

					throws PortalException, SystemException {

					ServiceContext serviceContext =
						ServiceContextFactory.getInstance(ESFCatridge.class.getName(), request);
					String esfUserId=ParamUtil.getString(request, "esfUserId");
					long esfMatchId = ParamUtil.getLong(request, "esfMatchId");
					long esfCaneId = ParamUtil.getLong(request, "esfCaneId");
					
					if (esfCaneId > 0) {

						ESFCaneLocalServiceUtil.deleteESFCane(esfCaneId, serviceContext);
					}
					response.setRenderParameter(
						"mvcPath", "/html/esfnationalmatch/tabs/edit_esfShooter.jsp");
					response.setRenderParameter("esfUserId", String.valueOf(esfUserId));
					response.setRenderParameter("esfMatchId", String.valueOf(esfMatchId));
					
				
	}
	

	public void editESFGunType(ActionRequest request, ActionResponse response)
					throws PortalException, SystemException {
					String esfUserId=ParamUtil.getString(request, "esfUserId");
					String mvc=ParamUtil.getString(request, "mvcPath");
					boolean found = false;
					ServiceContext serviceContext =
						ServiceContextFactory.getInstance(ESFGun.class.getName(), request);

					long esfGunTypeId = ParamUtil.getLong(request, "esfGunTypeId");
					String name = ParamUtil.getString(request, "name");
					String description = ParamUtil.getString(request, "description");
					String modifyMode=ParamUtil.getString(request, "modifyMode");
					boolean isCatridgeProductor = ParamUtil.getBoolean(request, "isCatridgeProductor");
					if (esfGunTypeId > 0) {
						ESFGunType esfGunType =
							ESFGunTypeLocalServiceUtil.getESFGunType(esfGunTypeId);

						if (ESFGunTypeLocalServiceUtil.checkNome(name, serviceContext) != null &&
							!esfGunType.getName().equals(name)) {
							SessionErrors.add(request, "esfGunType-reference-error");
						}
						else {
							ESFGunTypeLocalServiceUtil.updateESFGunType(
								serviceContext.getUserId(), esfGunTypeId, name,
								description, isCatridgeProductor, serviceContext);
						}
					}
					else {
						if (ESFGunTypeLocalServiceUtil.checkNome(name, serviceContext) != null) {
							SessionErrors.add(request, "esfGunType-reference-error");
						}
						else {
							ESFGunTypeLocalServiceUtil.addESFGunType(
								serviceContext.getUserId(), name, description, isCatridgeProductor,
								serviceContext);
						}
					}
					response.setRenderParameter("pathBack",mvc);
					response.setRenderParameter("esfUserId", esfUserId);
					response.setRenderParameter("mvcPath",mvc);
					response.setRenderParameter("modifyMode", modifyMode);
	}
	public void editESFGunKind(ActionRequest request, ActionResponse response)
					throws PortalException, SystemException {
					String esfUserId=ParamUtil.getString(request, "esfUserId");
					String mvc=ParamUtil.getString(request, "mvcPath");
					boolean found = false;
					ServiceContext serviceContext =
						ServiceContextFactory.getInstance(ESFGun.class.getName(), request);

					long esfGunKindId = ParamUtil.getLong(request, "esfGunKindId");
					long esfGunTypeId = ParamUtil.getLong(request, "gunTypeId");
					String description = ParamUtil.getString(request, "description");
					String model = ParamUtil.getString(request, "model");
					long caliber = ParamUtil.getLong(request, "caliber");
					String esfGunId=ParamUtil.getString(request, "esfGunId");
					String modifyMode=ParamUtil.getString(request, "modifyMode");
					String measures = ParamUtil.getString(request, "measures");
					long typologyId = ParamUtil.getLong(request, "typology");
					
					String name = ParamUtil.getString(request, "name");
					String from =ParamUtil.getString(request, "from");
					String esfCaneId=ParamUtil.getString(request, "esfCaneId");
					if (esfGunKindId > 0) {
						
							ESFGunKindLocalServiceUtil.updateESFGunKind(
								serviceContext.getUserId(), esfGunKindId, name,
								description, esfGunTypeId, serviceContext);
					}
					else {

						ESFGunKindLocalServiceUtil.addESFGunKind(
								serviceContext.getUserId(), name, description, 
								esfGunTypeId, serviceContext);

					}
					response.setRenderParameter("pathBack",mvc);
					response.setRenderParameter("esfUserId", esfUserId);
					response.setRenderParameter("mvcPath",mvc);
					response.setRenderParameter("modifyMode", modifyMode);
	}	
	
	
	public void editESFdocument(ActionRequest request, ActionResponse response)
		throws PortalException, SystemException, ParseException {

		ServiceContext serviceContext =
			ServiceContextFactory.getInstance(
				ESFMatchTypePortlet.class.getName(), request);

		UploadPortletRequest uploadRequest =
			PortalUtil.getUploadPortletRequest(request);

		long organizationId = ParamUtil.getLong(request, "organizationId");

		long esfUserId = ParamUtil.getLong(request, "esfUserId");

		long esfDocumentId = ParamUtil.getLong(uploadRequest, "esfDocumentId");

		String code = ParamUtil.getString(uploadRequest, "code");

		long esfMatchId = ParamUtil.getLong(request, "esfMatchId");

		String releasedBy = ParamUtil.getString(uploadRequest, "releasedby");

		String rDate = ParamUtil.getString(uploadRequest, "releasedate");

		Date releaseDate = ManageDate.StringToDate(rDate);

		String eDate = ParamUtil.getString(uploadRequest, "expirationDate");

		Date expirationDate = ManageDate.StringToDate(eDate);

		String type = ParamUtil.getString(uploadRequest, "type");

		long userId = ParamUtil.getLong(uploadRequest, "esfUserId");

		/*
		 * ThemeDisplay themeDisplay = (ThemeDisplay)
		 * request.getAttribute(WebKeys.THEME_DISPLAY);
		 */
		try {
			User user = UserLocalServiceUtil.fetchUser(userId);

			long groupId = user.getGroupId();

			long companyId = user.getCompanyId();

			String userName = user.getFullName();

			String path = "";

			if (esfDocumentId > 0) {
				path = uploadFile(uploadRequest, user, type);
				Date modifiedDate = new Date();
				ESFDocumentLocalServiceUtil.updateEsfDocument(
					esfDocumentId, groupId, companyId, userName,
					user.getUserId(), code, releasedBy, modifiedDate,
					releaseDate, expirationDate, type, path, serviceContext);

				SessionMessages.add(request, "esfDocumentUpdated");

				response.setRenderParameter(
					"esfDocumentId", Long.toString(esfDocumentId));
			}
			else {
				Date createDate = new Date();
				List<ESFDocument> list =
					ESFDocumentLocalServiceUtil.findByT_U(
						type, user.getUserId());
				if (Validator.isNotNull(list) && list.size() > 0) {
					SessionErrors.add(request, "Document-type-message");
				}
				else {
					path = uploadFile(uploadRequest, user, type);
					ESFDocumentLocalServiceUtil.addEsfDocument(
						groupId, companyId, userName, user.getUserId(), code,
						releasedBy, createDate, releaseDate, expirationDate,
						type, path, serviceContext);

					SessionMessages.add(request, "esfDocumentUpdated");

					response.setRenderParameter(
						"esfDocumentId", Long.toString(esfDocumentId));
				}
			}
		}
		catch (Exception e) {
			e.getMessage();
		}
		finally {
			request.setAttribute("esfMatchId", esfMatchId);
			request.setAttribute("esfUserId", esfUserId);
			request.setAttribute("op", "updAddr");
			request.setAttribute("organizationId", organizationId);
			// response.setRenderParameter("myParam", "Documenti");
			response.setRenderParameter(
				"mvcPath", "/html/esfnationalmatch/tabs/edit_esfShooter.jsp");
			response.setRenderParameter("esfUserId", String.valueOf(esfUserId));
			response.setRenderParameter(
				"esfMatchId", String.valueOf(esfMatchId));
			response.setRenderParameter("op", "updAddr");
		}
	}

	private String uploadFile(
		UploadPortletRequest uploadRequest, User user, String type) {

		String dir =
			PortletProps.get("auto.deploy.tomcat.dest.dir") + File.separator +
				"shooter_document" + File.separator + user.getUserId();

		String paramName = "path";

		if (uploadRequest.getSize(paramName) == 0) {
			return "";
		}
		File uploadedFile = uploadRequest.getFile(paramName);
		String ext =
			uploadedFile.getName().substring(
				uploadedFile.getName().lastIndexOf("."));

		String sourceFileName = type + "_" + user.getEmailAddress();
		File folder = new File(dir);
		File filePath =
			new File(folder.getAbsolutePath() + File.separator +
				sourceFileName + ext);
		try {
			FileUtils.copyFile(uploadedFile, filePath);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return File.separator + "shooter_document" + File.separator +
			user.getUserId() + File.separator + sourceFileName + ext;
	}

	public void modifyESFNationalDelegationDates(
		ActionRequest request, ActionResponse response)
		throws ParseException {

		Long esfMatchId = ParamUtil.getLong(request, "esfMatchId");

		List<ESFNationalDelegation> officialPartecipants =
			new ArrayList<ESFNationalDelegation>();

		List<ESFNationalDelegation> shooterPartecipants;

		try {
			shooterPartecipants =
				ESFNationalDelegationLocalServiceUtil.getESFNationalDelegationByMatchId_PartecipantTypeId(
					esfMatchId, ESFKeys.ESFNationalDelegationType.SHOOTER);

			List<ESFNationalDelegation> officialPartecipantsImmutableList =
				ESFNationalDelegationLocalServiceUtil.getESFNationalDelegations(
					0,
					ESFNationalDelegationLocalServiceUtil.getESFNationalDelegationsCount());

			for (ESFNationalDelegation s : officialPartecipantsImmutableList) {
				if (s.getEsfPartecipantTypeId() != ESFKeys.ESFNationalDelegationType.SHOOTER) {
					officialPartecipants.add(s);
				}
			}
			/*
			 * Aggiorno i tiratori
			 */
			for (ESFNationalDelegation e : shooterPartecipants) {

				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

				Date leaveDate = null;
				Date returnDate = null;
				leaveDate =
					ManageDate.StringToDate(
						ParamUtil.getString(
							request, "leaveDate" + e.getEsfUserId()), sdf);
				returnDate =
					ManageDate.StringToDate(
						ParamUtil.getString(
							request, "returnDate" + e.getEsfUserId()), sdf);

				if (Validator.isNotNull(leaveDate)) {
					e.setLeaveDate(leaveDate);
					ESFNationalDelegationLocalServiceUtil.updateESFNationalDelegation(e);
				}
				if (Validator.isNotNull(returnDate)) {
					e.setReturnDate(returnDate);
					ESFNationalDelegationLocalServiceUtil.updateESFNationalDelegation(e);
				}
			}

			/*
			 * Aggiorno il personale
			 */

			for (ESFNationalDelegation e : officialPartecipants) {

				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

				Date leaveDate = null;
				Date returnDate = null;

				leaveDate =
					ManageDate.StringToDate(
						ParamUtil.getString(
							request, "leaveDate" + e.getEsfUserId()), sdf);
				returnDate =
					ManageDate.StringToDate(
						ParamUtil.getString(
							request, "returnDate" + e.getEsfUserId()), sdf);

				if (Validator.isNotNull(leaveDate)) {
					e.setLeaveDate(leaveDate);
					ESFNationalDelegationLocalServiceUtil.updateESFNationalDelegation(e);
				}
				if (Validator.isNotNull(returnDate)) {
					e.setReturnDate(returnDate);
					ESFNationalDelegationLocalServiceUtil.updateESFNationalDelegation(e);
				}
			}
		}
		catch (SystemException e) {
			e.getMessage();
		}

		finally {
			response.setRenderParameter( "esfMatchId", String.valueOf(esfMatchId));
			response.setRenderParameter(
				"mvcPath", "/html/esfnationalmatch/management_esfMatch.jsp");
		}
	}

	public void uploadDocument(
		ActionRequest actionRequest, ActionResponse actionResponse)
		throws IOException, PortletException, PortalException, SystemException {

		UploadPortletRequest uploadRequest =
			PortalUtil.getUploadPortletRequest(actionRequest);
	//	ThemeDisplay themeDisplay =
	//		(ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		long matchId = ParamUtil.getLong(uploadRequest, "esfMatchId");

		String dir =
				PropsUtil.get("auto.deploy.tomcat.dest.dir") + File.separator +
				"match_document" + File.separator + matchId;

		String paramName = "uploadedFile";

		if (uploadRequest.getSize(paramName) == 0) {
			return ;
		}
		File uploadedFile = uploadRequest.getFile(paramName);

		String sourceFileName = uploadedFile.getName();
		File folder = new File(dir);
		File filePath =
			new File(folder.getAbsolutePath() + File.separator + sourceFileName);
		try {
			FileUtils.copyFile(uploadedFile, filePath);
			}
		catch (IOException e) {
			e.printStackTrace();
		}
		actionResponse.setRenderParameter("esfMatchId", String.valueOf(matchId));
		actionResponse.setRenderParameter(
				"mvcPath", "/html/esfnationalmatch/uploadFileNationalMatch.jsp");		
	}

	public void deleteESFNationalDelegation(
		ActionRequest request, ActionResponse response) throws SystemException {

		long esfUserId = ParamUtil.getLong(request, "esfUserId");
		long esfMatchId = ParamUtil.getLong(request, "esfMatchId");
		long esfPartecipantTypeId =
			ParamUtil.getLong(request, "esfPartecipantTypeId");
		boolean isAzzurro = ParamUtil.getBoolean(request, "isAzzurro");
		
		List<ESFNationalDelegation> delegations = new ArrayList<ESFNationalDelegation>();
		delegations = ESFNationalDelegationLocalServiceUtil.getESFNationalDelegationByESFUserId_ESFMatchId(esfUserId, esfMatchId);
		

		try {

			for(ESFNationalDelegation del: delegations){
				if(del.getEsfPartecipantTypeId() == esfPartecipantTypeId){
					ESFNationalDelegationLocalServiceUtil.deleteESFNationalDelegation(del);
				}
			}
			
		//	ESFNationalDelegationLocalServiceUtil.deleteESFNationalDelegation(
			//	esfMatchId, esfUserId);

			if (isAzzurro) {
				response.setRenderParameter(
					"mvcPath", "/html/esfnationalmatch/edit_azzurri.jsp");
			}

			else if (esfPartecipantTypeId == ESFKeys.ESFNationalDelegationType.SHOOTER) {

				response.setRenderParameter(
					"mvcPath", "/html/esfnationalmatch/edit_esfShooter.jsp");
			}
			else {

				response.setRenderParameter(
					"mvcPath", "/html/esfnationalmatch/edit_staff.jsp");
			}

			response.setRenderParameter(
				"esfMatchId", String.valueOf(esfMatchId));

		}
		catch (Exception e) {
			e.getMessage();
		}
	}

	public void updateESFMatch(ActionRequest request, ActionResponse response)
		throws PortalException, SystemException, ParseException {

		ServiceContext serviceContext =
			ServiceContextFactory.getInstance(ESFMatch.class.getName(), request);
		long esfMatchId = ParamUtil.getLong(request, "esfMatchId");
		String code = ParamUtil.getString(request, "code");
		String sd = ParamUtil.getString(request, "startDate");
		String ed = ParamUtil.getString(request, "endDate");
		boolean internationalPlace =
			ParamUtil.getBoolean(request, "siteInternational");
		Date startDate = null;
		Date endDate = null;
		try {
			startDate = ManageDate.StringToDate(sd);
			endDate = ManageDate.StringToDate(ed);
		}
		catch (ParseException e1) {
			e1.printStackTrace();
			throw new PortalException(e1);
		}
		long description = ParamUtil.getLong(request, "description");
		String note = ParamUtil.getString(request, "notes");
		boolean isDraft = ParamUtil.getBoolean(request, "isDraft");
		long esfAssociationId = ParamUtil.getLong(request, "esfAssociationId");
		long esfCountryId = ParamUtil.getLong(request, "esfCountryId");
		String site = ParamUtil.getString(request, "site");
		boolean isJuniorMatch = ParamUtil.getBoolean(request, "isJuniorMatch");
		boolean isOlimpicQualificationMatch =
			ParamUtil.getBoolean(request, "isOlimpicQualificationMatch");
		long esfMatchTypeId = ParamUtil.getLong(request, "esfMatchTypeId");
		//long[] esfShooterQualificationIds =
			//ParamUtil.getLongValues(request, "esfShooterQualificationIds");
		String eventType = ParamUtil.getString(request, "eventType");
		long esfSportTypeId = ParamUtil.getLong(request, "esfSportTypeid");
		/* Setto a null i dati non necessari per un match nazionale */
		String startHour = StringPool.BLANK;
		int numFields = 0;
		int numDisk = ParamUtil.getInteger(request, "numDisk");
		int numDiskTeam = ParamUtil.getInteger(request, "numDiskTeam");
		String notNationalAssotiation =	ParamUtil.getString(request, "notNationalAssotiation");
		boolean isTeamMatch = false;
		boolean isIndividualMatch = false;
		boolean isChangeCategoryMatch = false;
		long[] esfShooterCategoryIds = null;
		String[] values = ParamUtil.getParameterValues(request, "values", new String[0]);
		String[] valuesSportType = ParamUtil.getParameterValues(request, "valuesSportType", new String[0]);
		long[] esfShooterQualificationIds = new long[values.length];
		for(int i = 0; i < values.length; i++) {
			esfShooterQualificationIds[i] = Long.valueOf(values[i]);
	    }
			
		String esfNationalSportTypeidString = "";
		for(String s : valuesSportType){

			esfNationalSportTypeidString = esfNationalSportTypeidString+"-"+s;
		}
		if (internationalPlace) {
			esfAssociationId = 0;
			site = "";
		}
		else {
			notNationalAssotiation = "";
			esfCountryId = 0;
		}
		ESFEntityState esfEntityState = new ESFEntityStateImpl();
		esfEntityState.setEsfStateId(ESFKeys.ESFStateType.ENABLE);
		if (startDate.after(endDate)) {
			SessionErrors.add(request, "date-message");
		}
		else {
			ESFMatch newMatch =
				ESFMatchLocalServiceUtil.addOrUpdateESFMatch(
					serviceContext.getUserId(), esfMatchId, esfAssociationId,
					code, startDate, endDate, startHour, description, note,
					isDraft, numFields, esfSportTypeId, numDisk, numDiskTeam,
					isIndividualMatch, isTeamMatch, isJuniorMatch,
					esfMatchTypeId, isChangeCategoryMatch, esfShooterCategoryIds,
					esfShooterQualificationIds, esfCountryId, site, true,
					isOlimpicQualificationMatch, esfEntityState,
					serviceContext, notNationalAssotiation, eventType, esfNationalSportTypeidString);
			/*
			 * ESFMatchLocalServiceUtil.addOrUpdateESFMatch(
			 * serviceContext.getUserId(), esfMatchId, esfAssociationId, code,
			 * startDate, endDate, startHour, description, note, isDraft,
			 * numFields, esfSportTypeId, numDisk, numDiskTeam,
			 * isIndividualMatch, isTeamMatch, isJuniorMatch, esfMatchTypeId,
			 * esfShooterCategoryIds, esfShooterQualificationIds, esfCountryId,
			 * site, isNational, isOlimpicQualificationMatch, esfEntityState,
			 * serviceContext, notNationalAssotiation);
			 */
			if(!isDraft){
				try {
					sendMail(esfMatchId, request, response);
				} catch (MailEngineException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					SessionMessages.add(request, "mail_error");
				}
			}
			

			if (newMatch == null || newMatch.getPrimaryKey() == 0) {
				SessionErrors.add(request, "match-error-operatiorn");
			}
			else if (esfMatchId == 0) {
				SessionMessages.add(request, "match-success-insert");
			}
			else {
				SessionMessages.add(request, "match-success-update");
			}
		}

		response.setRenderParameter("mvcPath", templatePath + "view.jsp");
	}

	public void addESFNationalDelegation(
		ActionRequest request, ActionResponse response) {

		long esfUserId = ParamUtil.getLong(request, "esfUserId");
		long esfMatchId = ParamUtil.getLong(request, "esfMatchId");
		long esfPartecipantTypeId = ParamUtil.getLong(request, "esfPartecipantTypeId");
		boolean isAzzurro = ParamUtil.getBoolean(request, "isAzzurro");
		
		long sportTypeId = ParamUtil.getLong(request, "sportTypeId");
		
		long esfGunIdFirst = 0;
		long esfGunIdSecond = 0;
		try {

			ESFMatch esfMatch =
				ESFMatchLocalServiceUtil.getESFMatch(esfMatchId);

			List<ESFGun> esfUserGuns =
				ESFGunLocalServiceUtil.getESFGunsByUserId(esfUserId);

			long esfNationalDelegationId =
				CounterLocalServiceUtil.increment(ESFNationalDelegation.class.getName());

			ServiceContext serviceContext =
				ServiceContextFactory.getInstance(
					ESFPartecipant.class.getName(), request);

			if (Validator.isNotNull(esfUserGuns)) {
				if (esfUserGuns.size() > 1) {
					esfGunIdFirst = esfUserGuns.get(0).getEsfGunId();
				}
				if (esfUserGuns.size() > 2) {
					esfGunIdSecond = esfUserGuns.get(1).getEsfGunId();
				}
			}

			if (esfPartecipantTypeId == ESFKeys.ESFNationalDelegationType.COACH ||
				esfPartecipantTypeId == ESFKeys.ESFNationalDelegationType.DOCTOR ||
				esfPartecipantTypeId == ESFKeys.ESFNationalDelegationType.REFEREE ||
				esfPartecipantTypeId == ESFKeys.ESFNationalDelegationType.STAFF) {

				sportTypeId = 0;
				esfGunIdFirst = 0;
				esfGunIdSecond = 0;

			}
			ESFNationalDelegation esfNationalDelegation =
				ESFNationalDelegationLocalServiceUtil.createESFNationalDelegation(esfNationalDelegationId);

			esfNationalDelegation.setPrimaryKey(esfNationalDelegationId);
			esfNationalDelegation.setEsfMatchId(esfMatchId);
			esfNationalDelegation.setCompanyId(serviceContext.getCompanyId());
			esfNationalDelegation.setCreateDate(new Date());
			esfNationalDelegation.setModifiedDate(new Date());
			esfNationalDelegation.setEsfPartecipantTypeId(esfPartecipantTypeId);
			esfNationalDelegation.setEsfSportTypeId(sportTypeId);
			esfNationalDelegation.setEsfGunId1(esfGunIdFirst);
			esfNationalDelegation.setEsfGunId2(esfGunIdSecond);
			esfNationalDelegation.setEsfUserId(esfUserId);
			esfNationalDelegation.setGroupId(esfMatch.getGroupId());
			esfNationalDelegation.setUserId(serviceContext.getUserId());
			esfNationalDelegation.setUserName(UserLocalServiceUtil.fetchUser(
				serviceContext.getUserId()).getFullName());

			ESFNationalDelegationLocalServiceUtil.addESFNationalDelegation(esfNationalDelegation);
			
			
			if(Validator.isNotNull(esfMatch) && !esfMatch.isIsDraft()){
				
				String mail = "";
				String shooter = "";
				List<ESFDocument> documents = new ArrayList<ESFDocument>();
				boolean dayError = false;
				boolean documentNumberError = false;
				String documentDayError = "";
				String userMailError = "";
				String documentNumberMinError = "" ;
				String matchCode = "";
				String matchStartDate = "";
				String matchEndDate = "";
				String matchPlace = "";
				String matchInformation = "";
				String error = "";
				
				User user = UserLocalServiceUtil.fetchUser(esfUserId) ;
				
				
				if(Validator.isNotNull(esfMatch)){
					if(Validator.isNotNull(esfMatch.getCode())){
						matchCode = esfMatch.getCode();
					}
					if(Validator.isNotNull(esfMatch.getStartDate())){
						matchStartDate = esfMatch.getStartDate().toString();
					}
					if(Validator.isNotNull(esfMatch.getEndDate())){
						matchEndDate = esfMatch.getEndDate().toString();
					}
					if(Validator.isNotNull(esfMatch.getNotNationalAssotiation())){
						matchPlace = esfMatch.getNotNationalAssotiation();
					}
					matchInformation = matchCode + ",con data d'inizio " + matchStartDate + " e data di fine " + matchEndDate +
							 " che si terr� in " + matchPlace + ".\n"+
							 "Siete pregati di controllare che i documenti siano in regola.\n";
				}
				
				
				if(Validator.isNotNull(user) &&  Validator.isNotNull(user.getEmailAddress()) &&
						 !StringPool.BLANK.equalsIgnoreCase(user.getEmailAddress())) {
					
					mail = user.getEmailAddress();
					
					shooter = user.getFirstName() + " "+ user.getLastName();
					
					documents = ESFDocumentLocalServiceUtil.findByesfUserId(user.getUserId());
					
					if(Validator.isNotNull(documents) ){
						
						List<ListType> listType = new ArrayList<ListType>();
						
						listType = ListTypeServiceUtil.getListTypes("it.ethica.esf.model.ESFDocument.document");
						
						if(documents.size() < listType.size()){
							documentNumberError = true;
						}
						for(ESFDocument doc : documents){
							
							int days = Days.daysBetween(
									new DateTime(esfMatch.getStartDate()),
									new DateTime(doc.getExpirationDate())).getDays();
							if (days <=30){
								dayError = true;
							}
						}
						
					}else{
						 error = "Sei pregato di inserire tutti i documenti necessari.";
					}
					String documentInformation = "";
					
					if(documentNumberError){
						documentNumberMinError = "Verifica di avere tutti i documenti.";
					}
					if(dayError){
						documentDayError = "Verifica che la scadenza dei tuoi documenti sia valida.";
					}
					//modificare pass
					String from = "fitav@fitav.it";
					//String from = "parseo81@gmail.com";
					
					String to = mail;
					
					//String to = "dariovelotti@hotmail.com";
				 
					String subject="Convocazione Gara Internazionale";
					
					String body ="Gentile " + shooter +",\n"+
									"sei stato convocato per il match:" + matchInformation +"\n"+
									documentNumberMinError + "\n"+
									documentDayError +"\n"+
									error ;
			 
					MailEngine.send(from, to, subject, body);
					
				}
				
			}

			if (isAzzurro) {
				response.setRenderParameter(
					"mvcPath", "/html/esfnationalmatch/edit_azzurri.jsp");
			}else if (esfPartecipantTypeId == ESFKeys.ESFNationalDelegationType.SHOOTER) {

				response.setRenderParameter(
					"mvcPath", "/html/esfnationalmatch/edit_esfShooter.jsp");

			}else {

				response.setRenderParameter(
					"mvcPath", "/html/esfnationalmatch/edit_staff.jsp");
			}

			response.setRenderParameter(
				"esfMatchId", String.valueOf(esfMatchId));
		}
		catch (Exception e) {
			e.getMessage();
		}
	}

	public void addESFPartecipant(ActionRequest request, ActionResponse response)
		throws PortalException, SystemException {

		ServiceContext serviceContext =
			ServiceContextFactory.getInstance(
				ESFPartecipant.class.getName(), request);

		long esfUserId = ParamUtil.getLong(request, "esfUserId");
		long esfMatchId = ParamUtil.getLong(request, "esfMatchId");
		long esfTeamId = ParamUtil.getLong(request, "esfTeamId");
		long ct = ParamUtil.getLong(request, "ct");
		long esfPartecipantTypeId =
			ParamUtil.getLong(request, "esfPartecipantTypeId");
		long result = ParamUtil.getLong(request, "result");

		ESFPartecipantLocalServiceUtil.addESFPartecipant(
			serviceContext.getUserId(), esfUserId, esfMatchId, esfTeamId, ct,
			esfPartecipantTypeId, result, serviceContext);

		if (esfPartecipantTypeId == ESFKeys.ESFNationalDelegationType.SHOOTER) {

			response.setRenderParameter(
				"mvcPath", "/html/esfnationalmatch/edit_esfShooter.jsp");

		}
		else{
			response.setRenderParameter(
				"mvcPath", "/html/esfnationalmatch/edit_staff.jsp");
		}

		response.setRenderParameter("esfMatchId", String.valueOf(esfMatchId));
		response.setRenderParameter(
				"mvcPath", "/html/esfnationalmatch/edit_staff.jsp");	

	}

	public void updateESFPartecipant(
		ActionRequest request, ActionResponse response)
		throws PortalException, SystemException {

		ServiceContext serviceContext =
			ServiceContextFactory.getInstance(
				ESFPartecipant.class.getName(), request);

		long esfUserId = ParamUtil.getLong(request, "esfUserId");
		long esfPartecipantId = ParamUtil.getLong(request, "esfPartecipantId");
		long esfMatchId = ParamUtil.getLong(request, "esfMatchId");
		long esfTeamId = ParamUtil.getLong(request, "esfTeamId");
		long ct = ParamUtil.getLong(request, "ct");
		long esfPartecipantTypeId =
			ParamUtil.getLong(request, "esfPartecipantTypeId");
		long result = ParamUtil.getLong(request, "result");

		ESFPartecipantLocalServiceUtil.updateESFPartecipant(
			serviceContext.getUserId(), esfPartecipantId, esfUserId,
			esfMatchId, esfTeamId, ct, esfPartecipantTypeId, result,
			serviceContext);

		if (esfPartecipantTypeId == ESFKeys.ESFNationalDelegationType.SHOOTER) {

			response.setRenderParameter(
				"mvcPath", "/html/esfnationalmatch/edit_esfShooter.jsp");

		}
		else if (esfPartecipantTypeId == ESFKeys.ESFNationalDelegationType.COACH) {

			response.setRenderParameter(
				"mvcPath", "/html/esfnationalmatch/edit_esfCT.jsp");

		}
		else if (esfPartecipantTypeId == ESFKeys.ESFNationalDelegationType.REFEREE) {

			response.setRenderParameter(
				"mvcPath", "/html/esfnationalmatch/edit_esfReferee.jsp");

		}
		else if (esfPartecipantTypeId == ESFKeys.ESFNationalDelegationType.DOCTOR) {

			response.setRenderParameter(
				"mvcPath", "/html/esfnationalmatch/edit_esfDoctor.jsp");

		}

		response.setRenderParameter("esfMatchId", String.valueOf(esfMatchId));
	}

	public void updateMultiESFPartecipant(
		ActionRequest request, ActionResponse response)
		throws PortalException, SystemException {

		ServiceContext serviceContext =
			ServiceContextFactory.getInstance(
				ESFPartecipant.class.getName(), request);

		long esfPartecipantTypeId =
			ParamUtil.getLong(request, "esfPartecipantTypeId");
		long esfMatchId = ParamUtil.getLong(request, "esfMatchId");
		long[] esfUserId = ParamUtil.getLongValues(request, "esfUserId");
		long[] esfPartecipantId =
			ParamUtil.getLongValues(request, "esfPartecipantId");
		long[] esfTeamId = ParamUtil.getLongValues(request, "esfTeamId");
		long[] ct = ParamUtil.getLongValues(request, "ct");
		long[] result = ParamUtil.getLongValues(request, "result");

		for (int i = 0; i < esfUserId.length; i++) {

			ESFPartecipantLocalServiceUtil.updateESFPartecipant(
				serviceContext.getUserId(), esfPartecipantId[i], esfUserId[i],
				esfMatchId, esfTeamId[i], ct[i], esfPartecipantTypeId,
				result[i], serviceContext);
		}

		if (esfPartecipantTypeId == ESFKeys.ESFNationalDelegationType.SHOOTER) {

			response.setRenderParameter(
				"mvcPath", "/html/esfnationalmatch/edit_esfShooter.jsp");

		}
		else if (esfPartecipantTypeId == ESFKeys.ESFNationalDelegationType.COACH) {

			response.setRenderParameter(
				"mvcPath", "/html/esfnationalmatch/edit_esfCT.jsp");

		}
		else if (esfPartecipantTypeId == ESFKeys.ESFNationalDelegationType.REFEREE) {

			response.setRenderParameter(
				"mvcPath", "/html/esfnationalmatch/edit_esfReferee.jsp");

		}
		else if (esfPartecipantTypeId == ESFKeys.ESFNationalDelegationType.DOCTOR) {

			response.setRenderParameter(
				"mvcPath", "/html/esfnationalmatch/edit_esfDoctor.jsp");

		}

		response.setRenderParameter("esfMatchId", String.valueOf(esfMatchId));
	}

	public void deleteESFMatch(ActionRequest request, ActionResponse response)
			throws PortalException, SystemException {

			ServiceContext serviceContext =
				ServiceContextFactory.getInstance(ESFMatch.class.getName(), request);

			long esfMatchId = ParamUtil.getLong(request, "esfMatchId");

			List<ESFPartecipant> esfPartecipants =
				ESFPartecipantLocalServiceUtil.findPartecipantsByMatch(esfMatchId);

			if (!esfPartecipants.isEmpty()) {

				SessionErrors.add(request, "partecipant-already-assigned-message");

			}
			else {
				ESFMatchLocalServiceUtil.deleteESFMatch(esfMatchId, serviceContext);

				SessionMessages.add(request, "deleteESFMatch");
			}

			response.setRenderParameter("mvcPath", templatePath + "view.jsp");
		}
	public void deleteESFPartecipant(
		ActionRequest request, ActionResponse response)
		throws PortalException, SystemException {

		ServiceContext serviceContext =
			ServiceContextFactory.getInstance(
				ESFPartecipant.class.getName(), request);

		long esfPartecipantTypeId =
			ParamUtil.getLong(request, "esfPartecipantTypeId");
		long esfPartecipantId = ParamUtil.getLong(request, "esfPartecipantId");
		long esfMatchId = ParamUtil.getLong(request, "esfMatchId");

		ESFPartecipantLocalServiceUtil.deleteESFPartecipant(
			esfPartecipantId, serviceContext);

		if (esfPartecipantTypeId == ESFKeys.ESFNationalDelegationType.SHOOTER) {

			response.setRenderParameter(
				"mvcPath", "/html/esfnationalmatch/edit_esfShooter.jsp");

		}
		else{
			response.setRenderParameter(
				"mvcPath", "/html/esfnationalmatch/edit_staff.jsp");
		}
		/*else if (esfPartecipantTypeId == ESFKeys.ESFNationalDelegationType.COACH) {

			response.setRenderParameter(
				"mvcPath", "/html/esfnationalmatch/edit_esfCT.jsp");

		}
		else if (esfPartecipantTypeId == ESFKeys.ESFNationalDelegationType.REFEREE) {

			response.setRenderParameter(
				"mvcPath", "/html/esfnationalmatch/edit_esfReferee.jsp");

		}
		else if (esfPartecipantTypeId == ESFKeys.ESFNationalDelegationType.DOCTOR) {

			response.setRenderParameter(
				"mvcPath", "/html/esfnationalmatch/edit_esfDoctor.jsp");

		}*/

		response.setRenderParameter("esfMatchId", String.valueOf(esfMatchId));

	}

	@SuppressWarnings("null")
	public void generateDocumets(ActionRequest req, ActionResponse resp) throws PortalException,
		InstantiationException, IllegalAccessException, SystemException{
		
		long esfMatchId = ParamUtil.getLong(req, "esfMatchId");

		boolean generatePasses = ParamUtil.getBoolean(req, "generatePasses");
		boolean generateLicences =
			ParamUtil.getBoolean(req, "generateLicences");
		boolean convocations = ParamUtil.getBoolean(req, "convocations");
		boolean preView = ParamUtil.getBoolean(req,"pre-view");
		boolean valid = true;
		boolean format = ParamUtil.getBoolean(req, "format");
		
		List<Long> userId = new ArrayList<Long>();
		List<ESFDocument> document = new ArrayList<ESFDocument>();
		List<Long> allUsers = new ArrayList<Long>();
		List<ESFNationalDelegation> allESFNationalDelegations =
				ESFNationalDelegationLocalServiceUtil
					.getESFNationalDelegationByESFMatchId(esfMatchId);

		for(ESFNationalDelegation n : allESFNationalDelegations){
			userId.add(n.getEsfUserId());
		}
		
		/* DANIELE VOLPARI: il metodo separa gli utenti con i documenti in regola da quelli con i
		 * documenti non in regola; poi invia l'email a coloro che hanno i documenti in regola,
		 * La generazione dei documenti � rimasta pending per incomprensione dei requisiti.
		 * */
		if(preView){
			
			for(int i = 0 ; i < userId.size() ; i++){
				valid = true;
				document = ESFDocumentLocalServiceUtil.findByesfUserId(userId.get(i));
				for(ESFDocument d : document ){
					int days = Days.daysBetween(
										new DateTime(new Date()),
										new DateTime(d.getExpirationDate())).getDays();
					if(days <= 30){
						valid = false;
						allUsers.add(userId.get(i));
						break;
					}
					
				}
			}
		}else{
			allUsers.addAll(userId);
		}
		//if(convocations && !preView && valid ){
		/*
		try {
			convocations(allUsers, esfMatchId,  preView, req, resp);
		} catch (MailEngineException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//}
	*/
		if(generatePasses){
			try {
				generatePasses(esfMatchId, req, resp);
			}
			catch (Exception e) {
				e.getMessage();
			}
		}
		if(generateLicences){
			try {
				generateLicences(
					esfMatchId, req, resp);
			}
			catch (Exception e) {
				e.getMessage();
			}
		}
		
		resp.setRenderParameter(
				"mvcPath", "/html/esfnationalmatch/tabs/stampe.jsp");
		
		
		/*
		if(generatePasses){
			try {
				generatePasses(esfMatchId, req, resp);
			}
			catch (Exception e) {
				e.getMessage();
			}
		}
		
		try {
			List<ESFNationalDelegation> allESFNationalDelegations =
							ESFNationalDelegationLocalServiceUtil
								.getESFNationalDelegationByESFMatchId(esfMatchId);
			ServiceContext serviceContext = ServiceContextFactory.getInstance(
								ESFPartecipantInfo.class.getName(), req);
			for (ESFNationalDelegation e : allESFNationalDelegations) { 
				long esfUserId = e.getEsfUserId();
				long esfPartecipantId = ESFPartecipantUtil.generateESFPartecipantInfo(
									esfUserId, esfMatchId, true, serviceContext); 
		
			} 
			
		} catch(SystemException e) { 
			e.printStackTrace(); 
		}
		
		if(generateLicences){
			try {
				generateLicences(
					esfMatchId, req, resp);
			}
			catch (Exception e) {
				e.getMessage();
			}
		}
		if(convocations){
			convocations(esfMatchId,  preView, req, resp);
		}*/
		
	}
		
	
	
	
	
	
	
		// finally{
	/*	resp.setRenderParameter("myParam", "Stampe");
		resp.setRenderParameter(
			"mvcPath", "/html/esfnationalmatch/management_esfMatch.jsp");
		resp.setRenderParameter("esfMatchId", String.valueOf(esfMatchId));*/
		// }
		/*
		 * ListType ls = null; List<ESFOrganization> organizations = null;
		 * HttpServletRequest request = PortalUtil.getHttpServletRequest(req);
		 * HttpServletResponse response =
		 * PortalUtil.getHttpServletResponse(resp); Connection conn = null; try
		 * { Class.forName("com.mysql.jdbc.Driver"); conn = (Connection)
		 * DriverManager.getConnection( "jdbc:mysql://127.0.0.1:3306/lportal",
		 * "root", "password"); } catch (SQLException ex) {
		 * System.out.println("SQLEXCEPTION#################");
		 * ex.printStackTrace(); } catch (ClassNotFoundException ex) {
		 * System.out.println("CLASSNOTFOUND#################");
		 * ex.printStackTrace(); } long esfMatchId = ParamUtil.getLong(req,
		 * "esfMatchId"); OutputStream outputStream = null; try {
		 * System.out.println("############################### PRIMA");
		 * outputStream = response.getOutputStream();
		 * System.out.println("############################### DOPO"); } catch
		 * (Exception e1) { // TODO Auto-generated catch block
		 * e1.printStackTrace();
		 * System.out.println("##############################riga 328"); }
		 * String tipoFormato = "pdf"; // ######## Uso JASPERREPORT ######## if
		 * (tipoFormato != null && !tipoFormato.equals("")) { JasperReport
		 * jasperReport; JasperPrint jasperPrint = null; JasperDesign
		 * jasperDesign; try { int tipoJr = 0; // ######## Ottengo la path per
		 * accedere al file jasper ######## // ParametriAccessoFile paraccfile =
		 * new ParametriAccessoFile(); String pathJrXml = null; // ########
		 * Costruisco la path per accedere al file jasper // ######## pathJrXml
		 * = "/home/igor/Scrivania/report/LettereAutorizzazione.jasper"; //
		 * ######## Creo la mappa di valori da passare al riport // ########
		 * Map<String, Object> parameters = new HashMap<String, Object>();
		 * parameters.put("P" + 1, esfMatchId); // ######## Carico il .jasper
		 * ######## jasperReport = (JasperReport) JRLoader.loadObject(new
		 * File(pathJrXml));
		 * System.out.println("dopo il caricamento del jasper###############");
		 * // ######## Carico il JasperDesign dall'XML e lo compilo // ########
		 * pathJrXml =
		 * "/home/igor/Scrivania/report/LettereAutorizzazione.jrxml";
		 * jasperDesign = JRXmlLoader.load(pathJrXml);
		 * System.out.println("dopo il caricamento del designb###############");
		 * jasperReport = JasperCompileManager.compileReport(jasperDesign);
		 * System.out.println("dopo il caricamento del report###############");
		 * // ######## Riempio il report con i parametri ######## try {
		 * jasperPrint = JasperFillManager.fillReport( jasperReport, parameters,
		 * conn); } catch (JRException e) { e.printStackTrace(); }
		 * System.out.println
		 * ("dopo il caricamento del jasperPrint###############"); if
		 * (tipoFormato.equalsIgnoreCase("pdf")) { // ######## esporto il report
		 * nel formato pdf -> in un file // ######## //
		 * JasperExportManager.exportReportToPdfFile(jasperPrint, //
		 * "C:/jasperReports/demo.pdf");
		 * response.setContentType("application/pdf"); // ######## esporto il
		 * report nel formato pdf -> nello // stream di output ########
		 * JasperExportManager.exportReportToPdfStream( jasperPrint,
		 * outputStream);
		 * System.out.println("################### dopo L'export ###############"
		 * ); } } catch (Exception e) { e.printStackTrace();
		 * System.out.println("##############################riga 445"); }
		 * finally { // ######## chiudo la connessione ######## try {
		 * outputStream.flush(); outputStream.close(); } catch (Exception e) {
		 * // TODO Auto-generated catch block e.printStackTrace();
		 * System.out.println("##############################riga 456"); } } }
		 */
/*	}*/

	public void generatePasses(
		long esfMatchId, ActionRequest req, ActionResponse resp){
		
		System.out.println("----------------1----------");
		String format=ParamUtil.getString(req, "format");
		System.out.println("formato output -"+format);
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn =
				(Connection) DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/fitav", "fitav", "F1I2t3v4");
		
			
			System.out.println("----------------2----------");
			
			// Compile jrxml file.
			//JasperReport jasperReport = 
				//JasperCompileManager.compileReport("C://Users//CM/Desktop//report_di_prova//LettereAutorizzazione.jrxml");
			// Parameters for report
			//JasperReport jasperReport = (JasperReport)JRLoader.loadObject(new File("C://Users//CM/Desktop//report_di_prova//DichiarazioneTiratoreAzzurro.jasper"));
			JasperReport jasperReport = (JasperReport)JRLoader.loadObject(new File("C://Users//CM/Desktop//ReportFITAV//LettereAutorizzazione.jasper"));
			
			System.out.println("----------------3----------");
			
			esfMatchId = 600701;
			String strLong = Long.toString(esfMatchId);
			//long Puser=16358;
			//long PId=1;
			String ppath="C:/Users/CM/Desktop/ReportFITAV/";
			
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("P_MatchId", strLong);
			//parameters.put("P1", "Prova");
			//parameters.put("P_user", Puser);
			//parameters.put("PId", PId);
			parameters.put("Ppath", ppath);
			
			System.out.println("----------------4----------");
			
			JasperPrint jasperPrint =
				JasperFillManager.fillReport(jasperReport, parameters, conn);
				
	
			System.out.println("----------------4.1----------");
			// Make sure the output directory exists.
			
			if (format.equals("pdf")){
			//File outDir = new File("C:\\Users\\CM\\Desktop\\risultati\\");
			//outDir.mkdirs();
			System.out.println("----------------4.2----------");
			JRPdfExporter exporter = new JRPdfExporter();
			System.out.println("----------------4.3----------");
			ExporterInput exporterInput = new SimpleExporterInput(jasperPrint);
			
			System.out.println("----------------5----------");
			
			
			
			
			// ExporterInput
			 exporter.setExporterInput(exporterInput);
			// ExporterOutput
			OutputStreamExporterOutput exporterOutput =
				new SimpleOutputStreamExporterOutput(
					"C:\\Users\\CM\\Desktop\\ReportFITAV\\lasciapassare.pdf");
			// Output
			System.out.println("----------------6----------");
			exporter.setExporterOutput(exporterOutput);
			SimplePdfExporterConfiguration configuration =
				new SimplePdfExporterConfiguration();
			
			exporter.setConfiguration(configuration);
			exporter.exportReport();
			exporterOutput.close();
			
			
			System.out.println("----------------7----------");
			}
			else{
				ByteArrayOutputStream byout = new ByteArrayOutputStream();
				JRXlsExporter exporterXls = new JRXlsExporter();
				
			
				ExporterInput exporterInput = new SimpleExporterInput(jasperPrint);
			
				System.out.println("----------------excel----------");
			
			
			
			
			// ExporterInput
				exporterXls.setExporterInput(exporterInput);
			// ExporterOutput
			OutputStreamExporterOutput exporterOutput =
				new SimpleOutputStreamExporterOutput(
					"C:\\Users\\CM\\Desktop\\ReportFITAV\\lasciapassare.xls");
			// Output
			System.out.println("----------------excel----------");
			exporterXls.setExporterOutput(exporterOutput);
			//SimpleXlsExporterConfiguration configuration =
				//new SimpleXlsExporterConfiguration();
			SimpleXlsReportConfiguration configuration= new SimpleXlsReportConfiguration();
			configuration.setOnePagePerSheet(true);
			configuration.setRemoveEmptySpaceBetweenRows(false);
			configuration.setDetectCellType(true);
			configuration.setWhitePageBackground(false);
			exporterXls.setConfiguration(configuration);
			exporterXls.exportReport();
			exporterOutput.close();
			}
			/*
			HttpServletResponse httpServletResponse = PortalUtil.getHttpServletResponse(resp);
						httpServletResponse.flushBuffer();
			OutputStream  outputStream = httpServletResponse.getOutputStream();
			byte[] contentArray = null;
			System.out.println("PDF calling");
			contentArray = JasperExportManager.exportReportToPdf(jasperPrint);
			System.out.println("PDF calling 2");
			//httpServletResponse.setContentType("application/pdf"); 
			System.out.println("PDF calling4");
			 httpServletResponse.setHeader("Content-Disposition","attachment;filename=test.pdf");
			 httpServletResponse.setHeader("Content-Transfer-Encoding", "binary");
			 httpServletResponse.setContentType("MimeConstants.MIME_PDF");
			 System.out.println("PDF calling5");
			 outputStream.write(contentArray);
			 System.out.println("PDF calling6");
			 //outputStream.flush();
			 System.out.println("PDF calling7");
			 outputStream.close();
			 System.out.println("PDF calling8");
			 */
		}catch(Exception e){
			e.getMessage();
		}
		
		try {
			conn.close();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}
	

	
	public void generateLicences(
			long esfMatchId, ActionRequest req, ActionResponse resp){
	}
	
	
	public void convocations(
			List<Long> convocations, long esfMatchId, boolean preView, ActionRequest req, ActionResponse resp)
					throws MailEngineException, SystemException, PortalException{
		//da capire se v� bene
		boolean preview = preView;
		List<Long> idConvocation = convocations;
		
		if(Validator.isNotNull(idConvocation)){
			if(preView){
				
				String body = "I seguenti utenti Hanno i documenti in scadenza:";
				for(Long i : idConvocation){
					ESFUser user = ESFUserLocalServiceUtil.fetchESFUser(i);
					String userDetails = user.getFirstName()+","+user.getLastName()+","+user.getUserEmail()+";";
					body= body+userDetails;
				}
				
				
				//String body = "prova body";
				
				 System.out.println(body);
				 //inserire indirizzi corretti
				 String from = "daniele.volpari85@gmail.com";
		 
				 String to = "daniele.volpari85@gmail.com";
		 
				 String subject="This is email title";
		 
		 
				 MailEngine.send(from, to, subject, body);
				
				
			}else{
			
			
				
				for(long i:convocations){
				
				ESFUser user = ESFUserLocalServiceUtil.fetchESFUser(i);
				
				String body = "prova body";
				System.out.println(body);
		
				String from = "daniele.volpari85@gmail.com";
		 
				String to = user.getUserEmail();
		 
				String subject="This is email title";
		 
		 
				MailEngine.send(from, to, subject, body);
				 
				}

			}
		}
		boolean sendHtml = true;
		 String from = "parseo81@gmail.com";
		 String rcpt = "dariovelotti@hotmail.it";
		 String subject = "prova subject";

		 
		 InternetAddress fromAddress = null;
		 InternetAddress toAddress = null;
		 
		// String host = "127.0.0.1";

	       /* java.util.Properties props = System.getProperties();
	        props.put("mail.host", host);
	        props.put("mail.transport.protocol", "smtps");
	        props.put("mail.smtps.auth", "true");
	        props.put("mail.smtps.port", "465");
	        props.put("mail.smtps.ssl.trust", host);

	        Session mailSession = Session.getInstance(props);
	        mailSession.setDebug(true);*/
		 /*
	        
		try { 
			
			fromAddress = new InternetAddress("parseo81@gmail.com");
	 		toAddress = new InternetAddress("dariovelotti@hotmail.com");
	 		 
            MailMessage mailMessage = new MailMessage(); 
           
			mailMessage.setBody(body); 
           
			mailMessage.setHTMLFormat(sendHtml); 
           
			mailMessage.setFrom(fromAddress); 
            
			mailMessage.setTo(toAddress); 
           
			mailMessage.setSubject(subject); 
			
            MailServiceUtil.sendEmail(mailMessage); 
            
            
            //System.out.println("mailMessage vale:"+mailMessage);
        } catch (Exception e) { 
            throw new RuntimeException(e); 
        } 
		*/

		
		
	}
	
	public void sendMail(long matchId, ActionRequest request, ActionResponse response) 
			throws MailEngineException, SystemException{
			
		
		long esfMatchId = ParamUtil.getLong(request, "esfMatchId");
		
		
		ESFMatch match = new ESFMatchImpl();
		List<ESFNationalDelegation> delegations = new ArrayList<ESFNationalDelegation>();
		List<Long> partecipantId = new ArrayList<Long>();
		User user = null;
		String matchCode = "";
		String matchStartDate = "";
		String matchEndDate = "";
		String matchPlace = "";
		String matchInformation = "";
		String error = "";
		
		try {
			match = ESFMatchLocalServiceUtil.fetchESFMatch(matchId);
			delegations = ESFNationalDelegationLocalServiceUtil.getESFNationalDelegationByESFMatchId(esfMatchId);
		} catch (Exception e) {
			// TODO: handle exception
			SessionMessages.add(request, "mail_error");
			
			return;
		}
		
		
		if(Validator.isNotNull(match)){
			if(Validator.isNotNull(match.getCode())){
				matchCode = match.getCode();
			}
			if(Validator.isNotNull(match.getStartDate())){
				matchStartDate = match.getStartDate().toString();
			}
			if(Validator.isNotNull(match.getEndDate())){
				matchEndDate = match.getEndDate().toString();
			}
			if(Validator.isNotNull(match.getNotNationalAssotiation())){
				matchPlace = match.getNotNationalAssotiation();
			}
			matchInformation = matchCode + ",con data d'inizio " + matchStartDate + " e data di fine " + matchEndDate +
					 " che si terr� in " + matchPlace + ".\n"+
					 "Siete pregati di controllare che i documenti siano in regola.\n";
		}
		
		for(ESFNationalDelegation del : delegations){
			if(!partecipantId.contains(del.getEsfUserId())){
				partecipantId.add(del.getEsfUserId());
			}
		}
		
		String email = "";
		String ErroreDocuemnti = "";
		
		if(partecipantId.size() > 0){
			
			String userMail = "";
			String documentDayError = "";
			String userMailError = "";
			String documentNumberMinError = "" ;
			List<ESFDocument> documents = new ArrayList<ESFDocument>();
			boolean dayError = false;
			boolean documentNumberError = false;
			
			for(long id : partecipantId){
				dayError = false;
				documentNumberError = false;
				documentNumberMinError = "" ;
				documentDayError = "";
				try {
					
					user = UserLocalServiceUtil.fetchUser(id);
					
					if(Validator.isNotNull(user) &&  Validator.isNotNull(user.getEmailAddress()) &&
							 !StringPool.BLANK.equalsIgnoreCase(user.getEmailAddress())) {
						
						String shooter = "";
						shooter = user.getFirstName() + " "+ user.getLastName();
						
						email = user.getEmailAddress().toString();
						
						documents = ESFDocumentLocalServiceUtil.findByesfUserId(user.getUserId());
						
						if(Validator.isNotNull(documents) ){
							
							List<ListType> listType = new ArrayList<ListType>();
							
							listType = ListTypeServiceUtil.getListTypes("it.ethica.esf.model.ESFDocument.document");
							
							if(documents.size() < listType.size()){
								documentNumberError = true;
							}
							for(ESFDocument doc : documents){
								
								int days = Days.daysBetween(
										new DateTime(match.getStartDate()),
										new DateTime(doc.getExpirationDate())).getDays();
								if (days <=30){
									dayError = true;
								}
							}
							
						}else{
							 error = "Sei pregato di inserire tutti i documenti necessari.";
						}
						String documentInformation = "";
						
						if(documentNumberError){
							documentNumberMinError = "Verifica di avere tutti i documenti.";
						}
						if(dayError){
							documentDayError = "Verifica che la scadenza dei tuoi documenti sia valida.";
						}
						
						String from = "fitav@fitav.it";
						//String from = "parseo81@gmail.com";
						
						String to = email;
						
						//String to = "dariovelotti@hotmail.com";
					 
						String subject="Convocazione Gara Internazionale";
						
						String body ="Gentile " + shooter +",\n"+
										"sei stato convocato per il match:" + matchInformation +"\n"+
										documentNumberMinError + "\n"+
										documentDayError +"\n"+
										error ;
				 
						MailEngine.send(from, to, subject, body);
					}
					
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			
		}
		
		 return;
		
	}
	
	
	
	
	
	
	
	/*
	 * Aggiunge i risultati della gara nazionale nella tabella
	 * NationalMatchResult
	 */

	public void addNationalMatchRes(
			ActionRequest request, ActionResponse response) {

			long esfMatchId = ParamUtil.getLong(request, "esfMatchId");
			try {
				List<ESFNationalDelegation> esfNationalDelegations =
					ESFNationalDelegationLocalServiceUtil.getESFNationalDelegationByMatchId_PartecipantTypeId(
						esfMatchId, ESFKeys.ESFNationalDelegationType.SHOOTER);
				int i = 0;
				long userId = ParamUtil.getLong(request, "userId");
				long companyId = ParamUtil.getLong(request, "companyId");
				long groupId = ParamUtil.getLong(request, "groupId");
				User user = UserLocalServiceUtil.getUser(userId);
				for (ESFNationalDelegation e : esfNationalDelegations) {

					long esfUserId = ParamUtil.getLong(request, "ESFShooterId" + i, -2);
					if (esfUserId == -2) {
						continue;
					}
					int position =
						ParamUtil.getInteger(request, "position" + i, 0);
					int qualification =
						ParamUtil.getInteger(request, "qualification" + i, 0);
					int shootOff =
						ParamUtil.getInteger(request, "shootOff" + i, 0);
					int clayPigeonTotal =
							ParamUtil.getInteger(request, "clayPigeonTotal" + i, 0);
					int finalResult =
						ParamUtil.getInteger(request, "finalResult" + i, 0);
					int shootOffFinal =
						ParamUtil.getInteger(request, "shootOffFinal" + i, 0);

					ESFNationalMatchResult esfNationalMatchResult =
						ESFNationalMatchResultLocalServiceUtil.getESFNationalMatchResultByESFMatchId_ESFUserId(
							esfMatchId, esfUserId);

					long esfNationalMatchResultsId =
						CounterLocalServiceUtil.increment(ESFNationalMatchResult.class.getName());

					if (Validator.isNotNull(esfNationalMatchResult)) {
						esfNationalMatchResultsId =
							esfNationalMatchResult.getEsfNationalMatchResultId();
					}

					if (!Validator.isNotNull(esfNationalMatchResult)) {
						esfNationalMatchResult = new ESFNationalMatchResultImpl();
					}


					esfNationalMatchResult.setPrimaryKey(esfNationalMatchResultsId);
					esfNationalMatchResult.setCompanyId(companyId);
					esfNationalMatchResult.setCreateDate(new Date());
					esfNationalMatchResult.setEsfMatchId(esfMatchId);
					esfNationalMatchResult.setEsfUserId(esfUserId);
					esfNationalMatchResult.setGroupId(groupId);
					esfNationalMatchResult.setModifiedDate(new Date());
					esfNationalMatchResult.setUserId(user.getUserId());
					esfNationalMatchResult.setUserName(user.getFullName());

					esfNationalMatchResult.setPosition(position);
					esfNationalMatchResult.setQualification(qualification);
					esfNationalMatchResult.setShootOff(shootOff);
					esfNationalMatchResult.setClayPigeonTotal(clayPigeonTotal);
					esfNationalMatchResult.setFinalResult(finalResult);
					esfNationalMatchResult.setShootOffFinal(shootOffFinal);
					esfNationalMatchResult.setExternalShooter(false);
					esfNationalMatchResult.setExternalName(StringPool.BLANK);

					ESFNationalMatchResultLocalServiceUtil.updateESFNationalMatchResult(esfNationalMatchResult);

					i++;
				}
				
				String externalIdsParam = ParamUtil.getString(request, "externalIds");
				String[] externalIds = StringUtil.split(externalIdsParam);
				for (String externalId : externalIds) {
					if (Validator.isNull(externalId)) {
						continue;
					}
					String suffix = "_ext_";
					String externalName = ParamUtil.getString(request, "shooterName" + suffix + externalId);
					int position = ParamUtil.getInteger(request, "position" + suffix + externalId);
					int qualification = ParamUtil.getInteger(request, "qualification" + suffix + externalId);
					int shootOff = ParamUtil.getInteger(request, "shootOff" + suffix + externalId);
					int clayPigeonTotal = ParamUtil.getInteger(request, "clayPigeonTotal" + suffix + externalId);
					int finalResult = ParamUtil.getInteger(request, "finalResult" + suffix + externalId);
					int shootOffFinal = ParamUtil.getInteger(request, "shootOffFinal" + suffix + externalId);
					
					long esfNationalMatchResultId = ParamUtil.getLong(request, "esfNationalMatchResultId" + suffix + externalId, -1);
					
					ESFNationalMatchResult esfNationalMatchResult;
					try {
						esfNationalMatchResult = ESFNationalMatchResultLocalServiceUtil.getESFNationalMatchResult(esfNationalMatchResultId);
					}
					catch (Exception e) {
						esfNationalMatchResult = new ESFNationalMatchResultImpl();
						long esfNationalMatchResultsId = CounterLocalServiceUtil.increment(ESFNationalMatchResult.class.getName());
						esfNationalMatchResult.setPrimaryKey(esfNationalMatchResultsId);
					}
					
					esfNationalMatchResult.setCompanyId(companyId);
					esfNationalMatchResult.setCreateDate(new Date());
					esfNationalMatchResult.setEsfMatchId(esfMatchId);
					esfNationalMatchResult.setEsfUserId(-1);
					esfNationalMatchResult.setGroupId(groupId);
					esfNationalMatchResult.setModifiedDate(new Date());
					esfNationalMatchResult.setUserId(user.getUserId());
					esfNationalMatchResult.setUserName(user.getFullName());

					esfNationalMatchResult.setPosition(position);
					esfNationalMatchResult.setQualification(qualification);
					esfNationalMatchResult.setShootOff(shootOff);
					esfNationalMatchResult.setClayPigeonTotal(clayPigeonTotal);
					esfNationalMatchResult.setFinalResult(finalResult);
					esfNationalMatchResult.setShootOffFinal(shootOffFinal);
					esfNationalMatchResult.setExternalShooter(true);
					esfNationalMatchResult.setExternalName(externalName);

					ESFNationalMatchResultLocalServiceUtil.updateESFNationalMatchResult(esfNationalMatchResult);
				}
			}
			catch (Exception e) {
				e.getMessage();
			}
		}
	
	public void addESFAirportNow(
			ActionRequest actionRequest, ActionResponse actionResponse) throws SystemException {
		String name = actionRequest.getParameter("name");
		String city = actionRequest.getParameter("city");
		String country = actionRequest.getParameter("country");
		actionResponse.setRenderParameter("esfMatchId", ParamUtil.getString(actionRequest,"esfMatchId"));
		actionResponse.setRenderParameter("mvcPath", ParamUtil.getString(actionRequest, "mvcPath"));
		ESFAirportLocalServiceUtil.adESFAirport(name, city, country);
	}
	
	public void changeCard(ActionRequest request, ActionResponse response) throws SystemException,
	 PortletException, PortalException, ParseException
	 {
	  ShooterUtility su = new ShooterUtility();
	  su.init(this.getPortletConfig());
	  su.editESFCard(request, response,"esfnationalmatch");
	 }
	
	public void newCard(ActionRequest request, ActionResponse response) throws SystemException,
	PortletException, PortalException, ParseException
	{
		ShooterUtility su = new ShooterUtility();
		su.init(this.getPortletConfig());
		su.newCard(request, response,"esfnationalmatch");
	}
	
	public void editESFdescription(
			ActionRequest request, ActionResponse response)
			throws PortalException, SystemException {

			ServiceContext serviceContext =
				ServiceContextFactory.getInstance(
					ESFMatchTypePortlet.class.getName(), request);

			long esfDescriptionId = ParamUtil.getLong(request, "esfDescriptionId");
			long esfMatchId = ParamUtil.getLong(request, "esfMatchId");
			String name = ParamUtil.getString(request, "name");
			boolean isNational = ParamUtil.getBoolean(request, "isNational");
			if (esfDescriptionId > 0) {
				ESFDescriptionLocalServiceUtil.updateEsfDescription(
					esfDescriptionId, name, isNational, serviceContext);
			}
			else {
				ESFDescriptionLocalServiceUtil.addEsfDescription(
					name, isNational, serviceContext);
			}
			response.setRenderParameter("mvcPath", templatePath+"new_edit_esfMatch.jsp");
			response.setRenderParameter("esfMatchId",String.valueOf(esfMatchId) );
		}
	
	public void editESFMatchType(ActionRequest request, ActionResponse response)
			throws PortalException, SystemException {

			ServiceContext serviceContext =
				ServiceContextFactory.getInstance(
					ESFMatchTypePortlet.class.getName(), request);
			
			long esfMatchId = ParamUtil.getLong(request, "esfMatchId");
			long esfMatchTypeId = ParamUtil.getLong(request, "esfMatchTypeId");
			String name = ParamUtil.getString(request, "name");
			boolean isCategoryQualification =
				ParamUtil.getBoolean(request, "isCategoryQualification");
			boolean isNational = ParamUtil.getBoolean(request, "isNational");
			
			if (esfMatchTypeId > 0) {

				ESFMatchTypeLocalServiceUtil.updateEsfMatchType(
					esfMatchTypeId, name, isCategoryQualification, isNational,
					 serviceContext);

			}
			else {

				ESFMatchTypeLocalServiceUtil.addEsfMatchType(
					name, isCategoryQualification, isNational,
					serviceContext);
			}
			
			response.setRenderParameter("mvcPath", templatePath+"new_edit_esfMatch.jsp");
			response.setRenderParameter("esfMatchId",String.valueOf(esfMatchId) );

		}
	
	public void editESFRifle (ActionRequest request, ActionResponse response)
			throws PortalException, SystemException {
		
		ServiceContext serviceContext =
				ServiceContextFactory.getInstance(ESFgunUser.class.getName(), request);
		
		long shooterId = ParamUtil.getLong(request, "esfUserId");
		long esfGunTypeId = ParamUtil.getLong(request, "esfGunTypeId");
		long esfGunKindId = ParamUtil.getLong(request, "esfGunKindId");
		long esfMatchId = ParamUtil.getLong(request, "esfMatchId");
		int type =ESFKeys.ESFGunType.RIFLE;
		
		String shooter_note = ParamUtil.getString(request, "shooter_note");
		String freshman = ParamUtil.getString(request, "code");
		boolean isFavoriteGun = ParamUtil.getBoolean(request, "isFavoriteGun");
		int typeId = ParamUtil.getInteger(request, "typology");
		String measures = ParamUtil.getString(request, "measures");
		long caliber = ParamUtil.getLong(request, "caliber");
		
		List<ESFgunUser> gunUsers = ESFgunUserLocalServiceUtil.findbyCode(freshman);
		
		if(gunUsers.size() == 0){
			ESFgunUserLocalServiceUtil.addESFGunUser(esfGunTypeId, shooterId, freshman, isFavoriteGun,
					type, shooter_note, esfGunTypeId, esfGunKindId,
					typeId, measures, caliber, serviceContext);
		}else{
			SessionErrors.add(request, "duplicate_code");
		}
		response.setRenderParameter( "mvcPath", "/html/esfnationalmatch/tabs/edit_esfShooter.jsp");
		response.setRenderParameter("esfUserId", String.valueOf(shooterId));
		response.setRenderParameter( "esfMatchId", String.valueOf(esfMatchId));
		request.setAttribute("op", "updAddr");
		
	}
	
	public void alterESFRifle (ActionRequest request, ActionResponse response)

			throws PortalException, SystemException {
		
		long esfGunUserId = ParamUtil.getLong(request, "esfGunUserId");
		long userId = ParamUtil.getLong(request, "userId");
		String shooter_note = ParamUtil.getString(request, "shooter_note");
		String freshman = ParamUtil.getString(request, "freshman");
		boolean favorite = ParamUtil.getBoolean(request, "is-favorite-gun");
		ESFgunUser gunUser = null;
		int typeId = ParamUtil.getInteger(request, "typology");
		String measures = ParamUtil.getString(request, "measures");
		String caliber = ParamUtil.getString(request, "caliber");
		List<ESFgunUser> esfGunUsers = ESFgunUserLocalServiceUtil.findbyCode(freshman);
		long esfMatchId = ParamUtil.getLong(request, "esfMatchId");
		
		
		try {
			 gunUser = ESFgunUserLocalServiceUtil.fetchESFgunUser(esfGunUserId);
		} catch (Exception e) {
			// TODO: handle exception
			SessionErrors.add(request, "esfGunType-reference-error");
		}
	
		if(esfGunUsers.size() > 0 &&
				esfGunUsers.get(0).getEsfGunUserId() != esfGunUserId){
			SessionErrors.add(request, "duplicate_code");
		}else{
		
			if(Validator.isNotNull(gunUser)){
				
				gunUser.setCode(freshman);
				gunUser.setNote(shooter_note);
				gunUser.setIsFavorite(favorite);
				gunUser.setEsfCaliber(caliber);
				gunUser.setEsfMeasures(measures);
				gunUser.setTypeId(typeId);
				
				ESFgunUserLocalServiceUtil.updateESFgunUser(gunUser);
				
			}else{
				response.setRenderParameter( "mvcPath", "/html/esfnationalmatch/tabs/edit_esfShooter.jsp");
				response.setRenderParameter("esfUserId", String.valueOf(userId));
				response.setRenderParameter( "esfMatchId", String.valueOf(esfMatchId));;
				return;
			}
		}
		
		response.setRenderParameter( "mvcPath", "/html/esfnationalmatch/tabs/edit_esfShooter.jsp");
		response.setRenderParameter("esfUserId", String.valueOf(userId));
		response.setRenderParameter( "esfMatchId", String.valueOf(esfMatchId));
		request.setAttribute("op", "updAddr");
	}
	
	public void alterESFCane (ActionRequest request, ActionResponse response)

			throws PortalException, SystemException {
		
		
		long esfGunUserId = ParamUtil.getLong(request, "esfGunUserId");
		long userId = ParamUtil.getLong(request, "userId");
		String shooter_note = ParamUtil.getString(request, "shooter_note");
		String freshman = ParamUtil.getString(request, "freshman");
		String measures= ParamUtil.getString(request, "measures");
		long caliber= ParamUtil.getLong(request, "caliber");
		int typologyId = ParamUtil.getInteger(request, "typology");
		boolean favorite = ParamUtil.getBoolean(request, "is-favorite-gun");
		ESFgunUser gunUser = null;
		List<ESFgunUser> esfGunUsers = ESFgunUserLocalServiceUtil.findbyCode(freshman);
		ESFCane esfCane = new ESFCaneImpl();
		long esfMatchId = ParamUtil.getLong(request, "esfMatchId");
		
		try {
			 gunUser = ESFgunUserLocalServiceUtil.fetchESFgunUser(esfGunUserId);
		} catch (Exception e) {
			// TODO: handle exception
			SessionErrors.add(request, "esfGunType-reference-error");
		}
		esfCane = ESFCaneLocalServiceUtil.fetchESFCane(gunUser.getEsfGunId());
		
		if(esfGunUsers.size() > 0 &&
				esfGunUsers.get(0).getEsfGunUserId() != esfGunUserId){
			SessionErrors.add(request, "duplicate_code");
			
		}else{
			
			if(Validator.isNotNull(gunUser) && Validator.isNotNull(esfCane)){
				
				gunUser.setCode(freshman);
				gunUser.setNote(shooter_note);
				gunUser.setIsFavorite(favorite);
				gunUser.setEsfCaliber(String.valueOf(caliber));
				gunUser.setEsfMeasures(measures);
				gunUser.setTypeId(typologyId);
				
				ESFgunUserLocalServiceUtil.updateESFgunUser(gunUser);
				
				esfCane.setCode(freshman);
				esfCane.setIsFavoriteGun(favorite);
				esfCane.setCaneCaliber(caliber);
				esfCane.setMeasures(measures);
				esfCane.setTypeId(typologyId);
				
				ESFCaneLocalServiceUtil.updateESFCane(esfCane);
				
			}else{
				response.setRenderParameter( "mvcPath", "/html/esfnationalmatch/tabs/edit_esfShooter.jsp");
				response.setRenderParameter("esfUserId", String.valueOf(userId));
				response.setRenderParameter( "esfMatchId", String.valueOf(esfMatchId));
					
				return;
			}
			
		}
		response.setRenderParameter( "mvcPath", "/html/esfnationalmatch/tabs/edit_esfShooter.jsp");
		response.setRenderParameter("esfUserId", String.valueOf(userId));
		response.setRenderParameter( "esfMatchId", String.valueOf(esfMatchId));
		request.setAttribute("op", "updAddr");
	}
	
	public void removeRole(ActionRequest request, ActionResponse response)
			throws PortalException, SystemException, ParseException {
		
			ServiceContext serviceContext =
				ServiceContextFactory.getInstance(ESFGun.class.getName(), request);
			
			String mvcPath = ParamUtil.getString(request, "mvcPath");
			long esfUserId = ParamUtil.getLong(request, "esfUserId");
			long esfUserRoleId = ParamUtil.getLong(request, "esfUserRoleId");
			long esforgId = ParamUtil.getLong(request, "esforgId");
			String esfstartDate = ParamUtil.getString(request,  "esfstartDate");
			long esfMatchId = ParamUtil.getLong(request, "esfMatchId");
			//esfstartDate = esfstartDate.substring(0, (esfstartDate.length()-2));
			
			SimpleDateFormat dateParser = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date startDate  = dateParser.parse(esfstartDate);
			
			ESFUserESFUserRolePK esfUserESFUserRolePK = new ESFUserESFUserRolePK();
			esfUserESFUserRolePK.setEsfUserId(esfUserId);
			esfUserESFUserRolePK.setEsfUserRoleId(esfUserRoleId);
			esfUserESFUserRolePK.setEsfOrganizationId(esforgId);
			esfUserESFUserRolePK.setStartDate(startDate);
			ESFUserESFUserRole userRole = ESFUserESFUserRoleLocalServiceUtil.fetchESFUserESFUserRole(esfUserESFUserRolePK);
			if(Validator.isNotNull(userRole)){
				ESFUserESFUserRoleLocalServiceUtil.deleteESFUserESFUserRole(userRole);
			}
			response.setRenderParameter( "mvcPath", "/html/esfnationalmatch/tabs/edit_esfShooter.jsp");
			response.setRenderParameter("esfUserId", String.valueOf(esfUserId));
			response.setRenderParameter( "esfMatchId", String.valueOf(esfMatchId));
			request.setAttribute("op", "updAddr");
	}
	
	
	public void assignMember (ActionRequest request, ActionResponse response)

			throws PortalException, SystemException {
		
		long esfUserRoleId = ParamUtil.getLong(request, "esfUserRoleId");
		long esfUserId = ParamUtil.getLong(request, "esfUserId");
		long esfMatchId = ParamUtil.getLong(request, "esfMatchId");
		
		long esfLiv0Id = ParamUtil.getLong(request, "esfLiv0Id");
		long esfLiv1Id = ParamUtil.getLong(request, "esfLiv1Id");
		long esfLiv2Id = ParamUtil.getLong(request, "esfLiv2Id");
		long esfLiv3Id = ParamUtil.getLong(request, "esfLiv3Id");

		ESFUserRole userRole = new ESFUserRoleImpl();
		userRole = ESFUserRoleLocalServiceUtil.fetchESFUserRole(esfUserRoleId);
		int maxUser = userRole.getMaxUser();
		
		long esfOrganizationId = 0;
		Date date = new Date();
		if (esfLiv3Id != 0) {
			esfOrganizationId = esfLiv3Id;
		}
		else if (esfLiv2Id != 0) {
			esfOrganizationId = esfLiv2Id;
		}
		else if (esfLiv1Id != 0) {
			esfOrganizationId = esfLiv1Id;
		}
		else {
			esfOrganizationId = esfLiv0Id;
		}
		
		if(userRole.isIsBDO()){
			
			if(esfLiv3Id == 0){
				SessionErrors.add(request, "esfRole-reference-error");
				
				response.setRenderParameter( "mvcPath", "/html/esfnationalmatch/tabs/edit_esfShooter.jsp");
				response.setRenderParameter("esfUserId", String.valueOf(esfUserId));
				response.setRenderParameter( "esfMatchId", String.valueOf(esfMatchId));
				return;
			}else{
				
				List<ESFUserESFUserRole> userRoleBDO =  ESFUserESFUserRoleLocalServiceUtil.findbyBDOUserRolenoEnd(esfUserRoleId, esfLiv3Id);
				if ( userRoleBDO.size() >= maxUser){
					SessionErrors.add(request, "esfRole-MAx-User-reference-error");
					
					response.setRenderParameter( "mvcPath", "/html/esfnationalmatch/tabs/edit_esfShooter.jsp");
					response.setRenderParameter("esfUserId", String.valueOf(esfUserId));
					response.setRenderParameter( "esfMatchId", String.valueOf(esfMatchId));
					return;
				}
			}
			
		}
		
		ESFUserESFUserRoleLocalServiceUtil.addESFUserESFRole(
				esfUserId, esfUserRoleId, esfOrganizationId, date);
		
		response.setRenderParameter( "mvcPath", "/html/esfnationalmatch/tabs/edit_esfShooter.jsp");
		response.setRenderParameter("esfUserId", String.valueOf(esfUserId));
		response.setRenderParameter( "esfMatchId", String.valueOf(esfMatchId));
		request.setAttribute("op", "updAddr");
		
	}
	
	
	private static void insertCell(PdfPTable table, Phrase phrase, int colspan){
		   
		  //create a new cell with the specified Text and Font
		  PdfPCell cell = new PdfPCell(phrase);
		  //set the cell alignment
		  cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
	
		   cell.setColspan(colspan);
		   cell.setBorder(0);
		   cell.setMinimumHeight(12f);
		   table.addCell("");
		
		  //add the call to the table
		  table.addCell(cell);

	}
	
}
