package it.ethica.esf.portlet;

import it.ethica.esf.model.ESFConfiguration;
import it.ethica.esf.model.ESFOrganization;
import it.ethica.esf.model.ESFUser;
import it.ethica.esf.model.impl.ESFConfigurationImpl;
import it.ethica.esf.model.impl.ESFOrganizationImpl;
import it.ethica.esf.service.ESFConfigurationLocalServiceUtil;
import it.ethica.esf.service.ESFOrganizationLocalServiceUtil;
import it.ethica.esf.util.ESFServiceUtil;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.util.JRLoader;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Organization;
import com.liferay.portal.service.persistence.OrganizationUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.mysql.jdbc.Connection;


public class ESFPrintPostalPortlet extends MVCPortlet{
	
	@Override
	public void serveResource(ResourceRequest request, ResourceResponse response)
			throws IOException, PortletException {
		
		String resourceID = request.getResourceID();
		boolean printPostal = ParamUtil.getBoolean(request, "printPostal");
		
		HttpServletRequest httpReq =
						PortalUtil.getHttpServletRequest(request);
		httpReq = PortalUtil.getOriginalServletRequest(httpReq);
		
		if(Validator.isNotNull(resourceID)){
			
			if(resourceID.equals("getProvince")){
				
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
		}
		
		String connectionURL = PropsUtil.get("jdbc.default.url");
		String userName = PropsUtil.get("jdbc.default.username");
		String password = PropsUtil.get("jdbc.default.password");
		
		if(printPostal){
			
			ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
			Group group;
			try {
					group = themeDisplay.getLayout().getGroup();
				
				long currentOrganizationId = group.getOrganizationId();
				
				long regionId = ParamUtil.getLong(request, "regionIdValue");
				long provinceId = ParamUtil.getLong(request, "provinceIdValue");
				long associationId = ParamUtil.getLong(request, "organizationIdValue");
				
				String postalType = ParamUtil.getString(request, "postalType");
				
				ESFOrganization org = new ESFOrganizationImpl();
				ESFConfiguration bankaccount = new ESFConfigurationImpl();
				String orgName = "";
				String checkingAccount = "";
				
				bankaccount = ESFConfigurationLocalServiceUtil.getESFConfigurationByESFKey("Conto_Corrente");
				checkingAccount = bankaccount.getValue()+"<"+postalType+">";
				
				HashMap map = new HashMap();
				
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = (Connection) DriverManager.getConnection(connectionURL, userName,password);
				
				if(0 != associationId){
	
					map.put("assId", associationId); 
	
				}else if( 0 == associationId && 0 != provinceId){
	
					map.put("assId", provinceId); 
	
				}else if(0 == provinceId &&  0 != regionId){
	
					map.put("assId", regionId);
	
				}else{
	
					map.put("assId", currentOrganizationId);
					
				}
				
				map.put("numConto",checkingAccount );
				
				String path = PropsUtil.get("auto.deploy.tomcat.dest.dir") + File.separator +
								"report"+ File.separator +"BollettiniRinnovoTiratori.jasper";
				
				InputStream jasperStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(path);
				
				JasperReport jasperReport = (JasperReport) JRLoader.loadObject(new File(path));
				
				JasperPrint print = JasperFillManager.fillReport(jasperReport,map, conn);
				
				byte[] bytes = null;
				bytes = JasperRunManager.runReportToPdf(jasperReport,map,conn);
				response.reset();
				response.resetBuffer();
				response.setContentType("application/pdf");
				response.addProperty(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=Bollettini Rinnovo TIratori.pdf;");
				response.setContentLength(bytes.length);
				OutputStream ouputStream =  response.getPortletOutputStream();
				ouputStream.write(bytes, 0, bytes.length);
				ouputStream.flush();
				ouputStream.close();
				
			}
			
			catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch ( SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (JRException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	private static Log _log = LogFactoryUtil.getLog(ESFPrintPostalPortlet.class);
}
