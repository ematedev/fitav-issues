package it.ethica.esf.portlet;

import com.liferay.util.bridges.mvc.MVCPortlet;

import it.ethica.esf.portlet.utility.GenerateAffiliationReport;
import it.ethica.esf.portlet.utility.GenerateShooterCV;

import it.ethica.esf.service.ESFCityLocalServiceWrapper;
import it.ethica.esf.util.RenewalAffiliationShooter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.upload.UploadServletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;


public class ESFShooterRenewalPortlet extends MVCPortlet{
		
	private final static int ONE_GB = 1073741824;
	
	private final static String baseDir = "/tmp/uploaded/";
	
	private final static String fileInputName = "fileName";
	
	public void serveResource(ResourceRequest request, ResourceResponse response)
					throws IOException, PortletException {
		
		HttpServletRequest httpReq =
						PortalUtil.getHttpServletRequest(request);
		httpReq = PortalUtil.getOriginalServletRequest(httpReq);
		
		HttpServletResponse httpResp = PortalUtil.getHttpServletResponse(response);
		
		String resourceID = request.getResourceID();
		boolean generateAffiliationShooterReport = ParamUtil.getBoolean(request, "generateAffiliationShooterReport");
		boolean generateAffiliationShooterReportYear = ParamUtil.getBoolean(request, "generateAffiliationShooterReportYear");
		
		if(generateAffiliationShooterReport){
			String  affiliationDate = ParamUtil.getString(request, "affiliationDate");
			
			String day = "";
			String mounth = "";
			String year = "";
			
			day = affiliationDate.substring(0, 2);
			mounth = affiliationDate.substring(3,5);
			year = affiliationDate.substring(6,10);
			
			affiliationDate = year+"-"+mounth+"-"+day;
			try {
				
				GenerateAffiliationReport gAR = new GenerateAffiliationReport();
				
				gAR.init(this.getPortletConfig());
				gAR.generateAffiliationShooterReportDate(request , response, affiliationDate);
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(generateAffiliationShooterReportYear){
			try {
				
				GenerateAffiliationReport gAR = new GenerateAffiliationReport();
				
				gAR.init(this.getPortletConfig());
				gAR.generateAffiliationShooterReportDateYear(request , response);
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Rinnovo Affiliazione Tiratori Tramite 5 Campo Bollettino Postale
	 * @param request
	 * @param response
	 * @throws Exception
	*/
	public void uploadAffiliation(ActionRequest request, ActionResponse response)
					throws Exception {
		
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(request);
		DateFormat df = new SimpleDateFormat("dd/MM/yy");		
		
		String creditDateS=ParamUtil.getString(uploadRequest, "creditDate");
		Date  creditDate = ParamUtil.getDate(uploadRequest, "creditDate",df);
		request.setAttribute("creditDate", creditDateS);
		response.setRenderParameter("creditDate", ""+creditDateS);
		long sizeInBytes = uploadRequest.getSize("fileName");
		int error = 0;
		String sourceFileName = uploadRequest.getFileName("fileName");
		
		File file = uploadRequest.getFile("fileName");
		
		BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
		
		RenewalAffiliationShooter renewalAffiliation = new RenewalAffiliationShooter();
		renewalAffiliation.setRequest(request);
		renewalAffiliation.setResponse(response);
		error = renewalAffiliation.renewalAffiliation(bufferedReader,creditDate);
		if(0 < error){
			_log.error("numero di errori ="+error);
			response.setRenderParameter("numberLineError",String.valueOf(error) );
			SessionErrors.add(request, "error-Shooter-Affiliation");
		}

		response.setRenderParameter("mvcPath", ParamUtil.getString(request, "mvcPath"));
	}
	
	private static Log _log = LogFactoryUtil.getLog(ESFShooterRenewalPortlet.class);

}
