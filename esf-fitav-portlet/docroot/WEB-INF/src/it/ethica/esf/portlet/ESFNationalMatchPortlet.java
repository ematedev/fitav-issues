
package it.ethica.esf.portlet;


import it.ethica.esf.model.ESFAddress;
import it.ethica.esf.model.ESFCane;
import it.ethica.esf.model.ESFCard;
import it.ethica.esf.model.ESFCatridge;
import it.ethica.esf.model.ESFCity;
import it.ethica.esf.model.ESFDeparture;
import it.ethica.esf.model.ESFDocument;
import it.ethica.esf.model.ESFEntityState;
//import it.ethica.esf.model.ESFEventMatchResult;
import it.ethica.esf.model.ESFGun;
import it.ethica.esf.model.ESFGunKind;
import it.ethica.esf.model.ESFGunType;
import it.ethica.esf.model.ESFMatch;
import it.ethica.esf.model.ESFMatchResult;
import it.ethica.esf.model.ESFMatchType;
import it.ethica.esf.model.ESFNationalDelegation;
import it.ethica.esf.model.ESFNationalMatchResult;
//import it.ethica.esf.model.ESFNotOlimpicMatchResult;
import it.ethica.esf.model.ESFOrganization;
import it.ethica.esf.model.ESFPartecipant;
import it.ethica.esf.model.ESFPhone;
import it.ethica.esf.model.ESFResult;
import it.ethica.esf.model.ESFShooterQualificationESFMatch;
import it.ethica.esf.model.ESFSportType;
import it.ethica.esf.model.ESFUser;
import it.ethica.esf.model.ESFUserESFUserRole;
import it.ethica.esf.model.ESFUserRole;
import it.ethica.esf.model.ESFgunUser;
import it.ethica.esf.model.impl.ESFAddressImpl;
import it.ethica.esf.model.impl.ESFCaneImpl;
import it.ethica.esf.model.impl.ESFCardImpl;
import it.ethica.esf.model.impl.ESFCityImpl;
import it.ethica.esf.model.impl.ESFDepartureImpl;
import it.ethica.esf.model.impl.ESFEntityStateImpl;
//import it.ethica.esf.model.impl.ESFEventMatchResultImpl;
import it.ethica.esf.model.impl.ESFGunKindImpl;
import it.ethica.esf.model.impl.ESFGunTypeImpl;
import it.ethica.esf.model.impl.ESFMatchImpl;
import it.ethica.esf.model.impl.ESFMatchResultImpl;
import it.ethica.esf.model.impl.ESFNationalDelegationImpl;
import it.ethica.esf.model.impl.ESFNationalMatchResultImpl;
//import it.ethica.esf.model.impl.ESFNotOlimpicMatchResultImpl;
import it.ethica.esf.model.impl.ESFOrganizationImpl;
import it.ethica.esf.model.impl.ESFResultImpl;
import it.ethica.esf.model.impl.ESFSportTypeImpl;
import it.ethica.esf.model.impl.ESFUserImpl;
import it.ethica.esf.model.impl.ESFUserRoleImpl;
import it.ethica.esf.model.impl.ESFgunUserImpl;
import it.ethica.esf.portlet.utility.MatchComparator;
import it.ethica.esf.portlet.utility.NationalResultsComparator;
import it.ethica.esf.portlet.utility.ShooterUtility;
import it.ethica.esf.service.ESFAddressLocalServiceUtil;
import it.ethica.esf.service.ESFAirportLocalServiceUtil;
import it.ethica.esf.service.ESFCaneLocalServiceUtil;
import it.ethica.esf.service.ESFCardLocalServiceUtil;
import it.ethica.esf.service.ESFCatridgeLocalServiceUtil;
import it.ethica.esf.service.ESFCityLocalServiceUtil;
import it.ethica.esf.service.ESFDepartureLocalServiceUtil;
import it.ethica.esf.service.ESFDescriptionLocalServiceUtil;
import it.ethica.esf.service.ESFDocumentLocalServiceUtil;
//import it.ethica.esf.service.ESFEventMatchResultLocalServiceUtil;
import it.ethica.esf.service.ESFGunKindLocalServiceUtil;
import it.ethica.esf.service.ESFGunLocalServiceUtil;
import it.ethica.esf.service.ESFGunTypeLocalServiceUtil;
import it.ethica.esf.service.ESFMatchLocalServiceUtil;
import it.ethica.esf.service.ESFMatchTypeLocalServiceUtil;
import it.ethica.esf.service.ESFNationalDelegationLocalServiceUtil;
import it.ethica.esf.service.ESFNationalMatchResultLocalServiceUtil;
//import it.ethica.esf.service.ESFNotOlimpicMatchResultLocalServiceUtil;
import it.ethica.esf.service.ESFOrganizationLocalServiceUtil;
import it.ethica.esf.service.ESFPartecipantLocalServiceUtil;
import it.ethica.esf.service.ESFResultLocalServiceUtil;
import it.ethica.esf.service.ESFShooterQualificationESFMatchLocalServiceUtil;
import it.ethica.esf.service.ESFShooterQualificationLocalServiceUtil;
import it.ethica.esf.service.ESFSportTypeLocalServiceUtil;
import it.ethica.esf.service.ESFUserESFUserRoleLocalServiceUtil;
import it.ethica.esf.service.ESFUserLocalServiceUtil;
import it.ethica.esf.service.ESFUserRoleLocalServiceUtil;
import it.ethica.esf.service.ESFgunUserLocalServiceUtil;
import it.ethica.esf.service.persistence.ESFCityPK;
import it.ethica.esf.service.persistence.ESFMatchResultUtil;
import it.ethica.esf.service.persistence.ESFUserESFUserRolePK;
import it.ethica.esf.util.ESFJsonUtil;
import it.ethica.esf.util.ESFKeys;
import it.ethica.esf.util.ESFServiceUtil;
import it.ethica.esf.util.ManageDate;
import it.ethica.esf.util.ManageOperationsField;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.mail.internet.InternetAddress;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.StateAwareResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.w3c.dom.Element;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;
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
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Address;
import com.liferay.portal.model.ListType;
import com.liferay.portal.model.Organization;
import com.liferay.portal.model.Phone;
import com.liferay.portal.model.User;
import com.liferay.portal.service.AddressLocalServiceUtil;
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
import com.liferay.portlet.journalcontent.util.JournalContentUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.liferay.util.mail.MailEngine;
import com.liferay.util.mail.MailEngineException;
//import com.lowagie.text.Element;
//import com.lowagie.text.Phrase;
//import com.lowagie.text.pdf.PdfPCell;
//import com.lowagie.text.pdf.PdfPTable;
//import com.itextpdf.text.Document;


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
		boolean printResults = ParamUtil.getBoolean(resourceRequest, "printResults");
		boolean olimpicMatch = ParamUtil.getBoolean(resourceRequest, "olimpicMatch");
		boolean nationalMatch = ParamUtil.getBoolean(resourceRequest, "nationalMatch");
		boolean eventMatch = ParamUtil.getBoolean(resourceRequest, "eventMatch");

		String resourceID = resourceRequest.getResourceID();

		if ( Validator.isNotNull(resourceID) && "deleteExternalShooter".equals(resourceID)) {
			
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
		
		if ( Validator.isNotNull(resourceID) && "deleteEventExternalShooter".equals(resourceID)) {
			
			long esfNationalMatchResultId = ParamUtil.getLong(resourceRequest, "esfNationalMatchResultId", 0);
			/*try {
				ESFEventMatchResultLocalServiceUtil.deleteESFEventMatchResult(esfNationalMatchResultId);
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
			}*/
			return;
		}
		
		if ( Validator.isNotNull(resourceID) && "deleteNotOlimpicExternalShooter".equals(resourceID)) {
			
			long esfNationalMatchResultId = ParamUtil.getLong(resourceRequest, "esfNationalMatchResultId", 0);
			/*try {
				ESFNotOlimpicMatchResultLocalServiceUtil.deleteESFNotOlimpicMatchResult(esfNationalMatchResultId);
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
			}*/
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
		//prima modifica
		
		if((Validator.isNotNull(matchReport) || "".equals(matchReport) ) && !"ok".equals(matchReport)){
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

		if ( Validator.isNotNull(resourceID) && resourceID.equals("fiscalCode")) {
			try {
				JSONObject fiscalcode;
				fiscalcode = serveFiscalCode(resourceRequest,resourceResponse);
				resourceResponse.getWriter().print(fiscalcode);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
					_log.error(" nel serve resurce catch 1");
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (PortalException e) {
					// TODO Auto-generated catch block
					_log.error(" nel serve resurce catch 2");
					e.printStackTrace();
				} catch (com.lowagie.text.DocumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	}
        
	        if(generateLicences){
	    		
	    		try {
					generateLicences(resourceRequest , resourceResponse, esfMatchId);
				} catch (SystemException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (PortalException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	}
	    	
	    	if(generatePasses){
	    		try {
	    			generatePasses(resourceRequest , resourceResponse, esfMatchId);
				} catch (SystemException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (PortalException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	}
	    	
	        if(printResults){

	        	try {
	    			generateResults(resourceRequest , resourceResponse, esfMatchId);
				} catch (SystemException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (PortalException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				catch (DocumentException e) {
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
	
	public void generateResults(ResourceRequest req, ResourceResponse resp, long esfMatchId)
					throws SystemException, PortalException, DocumentException, IOException{

		ESFMatch match = ESFMatchLocalServiceUtil.fetchESFMatch(esfMatchId);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		List<ESFResult> result = new ArrayList<ESFResult>();
		String matchName = "";
		String matchInformation = "";
		String startDate = "";
		String endDate = "";
		String speciality = "";
		String eventName = "";
		String eventType = "";
		String nationCode="";
		String individualMatch = "";
		int numDisk = 0;
		String matchType = "";
		String matchCountry = "";
		
		ESFSportType spec = new ESFSportTypeImpl();
		
		String sportType = match.getEsfNationalSportTypeId();
		String [] splits = null;
		
		List<ESFNationalMatchResult> matchResults = new ArrayList<ESFNationalMatchResult>();
		//List<ESFNotOlimpicMatchResult> nationaMatchResults = new ArrayList<ESFNotOlimpicMatchResult>();
		//List<ESFEventMatchResult> eventResults = new ArrayList<ESFEventMatchResult>();
		List<ESFShooterQualificationESFMatch> sqMs = new ArrayList<ESFShooterQualificationESFMatch>();
		List<Long> sqmIds = new ArrayList<Long>();
		List<Long> count = new ArrayList<Long>();
		ESFNationalMatchResult matchRsult = new ESFNationalMatchResultImpl();
		
		if(Validator.isNotNull(match)){
			
			if(Validator.isNotNull(match.getCode())){
				matchName = match.getCode();
			}
			if(Validator.isNotNull(match.getStartDate())){
				startDate = sdf.format(match.getStartDate());
			}
			if(Validator.isNotNull(match.getStartDate())){
				endDate = sdf.format(match.getEndDate());
			}
			if(Validator.isNotNull(match.getNumDisk())){
				numDisk = match.getNumDisk();
			}
			if(Validator.isNotNull(match.getEsfMatchTypeId()) && 
							Validator.isNotNull(ESFMatchTypeLocalServiceUtil.fetchESFMatchType(match.getEsfMatchTypeId()).getName())
							&& !"".equalsIgnoreCase(ESFMatchTypeLocalServiceUtil.fetchESFMatchType(match.getEsfMatchTypeId()).getName())){
						matchType = ESFMatchTypeLocalServiceUtil.fetchESFMatchType(match.getEsfMatchTypeId()).getName();
			}
			if(Validator.isNotNull(match.getDescription())) {
				eventName =	ESFDescriptionLocalServiceUtil.fetchESFDescription( match.getDescription()).getName()+"-";
			}
			
			/*if(match.getIsIndividualMatch()) {
				individualMatch =	"INDIVIDUALE";
			}else{
				individualMatch =	"SQUADRA";
			}*/
			
			
			if(Validator.isNotNull(match.getNotNationalAssotiation())){
				
				matchCountry = match.getNotNationalAssotiation().toUpperCase();
				
				
				if(Validator.isNotNull(match.getCountryId()) &&
								Validator.isNotNull(CountryServiceUtil.fetchCountry(match.getCountryId()).getName())){
					
					nationCode = CountryServiceUtil.fetchCountry(match.getCountryId()).getA2();
					
					matchCountry = matchCountry +"("+ nationCode+")";
				}
				
				
			}else{
				matchCountry = "ITALIA";
			}
		}
		
		if(Validator.isNotNull(sportType)){
			
			splits = sportType.split("-");
		
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
		
		sqMs = ESFShooterQualificationESFMatchLocalServiceUtil.findbyMatchId(esfMatchId);
		
		for(ESFShooterQualificationESFMatch sqM : sqMs){
			
			sqmIds.add(sqM.getEsfShooterQualificationId());
		}
		
		com.itextpdf.text.Document document = new com.itextpdf.text.Document(); 
		ByteArrayOutputStream baos = new ByteArrayOutputStream(); 
		PdfWriter writer = PdfWriter.getInstance(document, baos);
		document.open();
		
		Paragraph paragraph = new Paragraph();
		
		Font fontT = new Font(Font.FontFamily.TIMES_ROMAN, 30);
		Font fontTeam = new Font(Font.FontFamily.TIMES_ROMAN, 13, Font.BOLD | Font.UNDERLINE);
		Font font = new Font(Font.FontFamily.TIMES_ROMAN, 10);
		
		paragraph.setIndentationLeft(180);
		paragraph.setIndentationRight(180);
		paragraph.add("ALBO D'ORO");
		paragraph.setAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
		paragraph.setSpacingAfter(15);
		paragraph.setFont(fontT);
		
		
		/*Paragraph paragraphTeam = new Paragraph();
		paragraphTeam.setAlignment(com.itextpdf.text.Element.ALIGN_LEFT);
		paragraphTeam.setSpacingAfter(15);
		paragraphTeam.setFont(fontTeam);
		paragraphTeam.add(individualMatch);*/
		
		document.add(paragraph);
		
		float[] columnWidths = {20,30,15,20};
		float paddingleft=15f;
		PdfPTable tableT = new PdfPTable(columnWidths);
		
		tableT.setWidthPercentage(100);
		tableT.getDefaultCell().setPaddingLeft(paddingleft);
		
		PdfPCell cell1 = new PdfPCell(new Paragraph("TIPO MANIFESTAZIONE ",font));
		PdfPCell cell2 = new PdfPCell(new Paragraph("SPECIALITA'",font));
		PdfPCell cell3 = new PdfPCell(new Paragraph("LOCALITA'",font));
		PdfPCell cell4 = new PdfPCell(new Paragraph("DATA",font));
		
		cell1.setBorder(0);
		cell2.setBorder(0);
		cell3.setBorder(0);
		cell4.setBorder(0);
		
		tableT.addCell(cell1);
		tableT.addCell(cell2);
		tableT.addCell(cell3);
		tableT.addCell(cell4);
		
		PdfPCell cell11 = new PdfPCell(new Paragraph(matchType,font));
		PdfPCell cell12 = new PdfPCell(new Paragraph(speciality,font));
		PdfPCell cell13 = new PdfPCell(new Paragraph(matchCountry,font));
		PdfPCell cell14 = new PdfPCell(new Paragraph(startDate+"-"+endDate,font));
		
		cell11.setBorder(0);
		cell12.setBorder(0);
		cell13.setBorder(0);
		cell14.setBorder(0);
		
		tableT.addCell(cell11);
		tableT.addCell(cell12);
		tableT.addCell(cell13);
		tableT.addCell(cell14);
		
		document.add(tableT);
		
		//document.add(paragraphTeam);
		
		sqmIds.add((long) 0);
		
		String qualificationName = "";
		String sportTypeName = "";
		
		for(String s : splits){	
			
			long stId = 0;
			
			if(!StringPool.BLANK.equals(s)){
				stId = Long.valueOf(s);
			}
			
			for(Long sqmId : sqmIds){
				qualificationName = "";
				sportTypeName = "";
				
				if( 0 < sqmId && Validator.isNotNull(ESFShooterQualificationLocalServiceUtil.fetchESFShooterQualification(sqmId)) &&
								Validator.isNotNull(ESFShooterQualificationLocalServiceUtil.fetchESFShooterQualification(sqmId).getName())){
					qualificationName = ESFShooterQualificationLocalServiceUtil.fetchESFShooterQualification(sqmId).getName();
				}
				
				if(!StringPool.BLANK.equals(s) && Validator.isNotNull(ESFSportTypeLocalServiceUtil.fetchESFSportType(Long.valueOf(s))) &&
								Validator.isNotNull(ESFSportTypeLocalServiceUtil.fetchESFSportType(Long.valueOf(s)).getName())){
					sportTypeName = (ESFSportTypeLocalServiceUtil.fetchESFSportType(Long.valueOf(s)).getName());
				}
				
				//result = ESFResultLocalServiceUtil.findByESFMId_STId_SQId(esfMatchId, stId, sqmId);
				result = ESFResultLocalServiceUtil.findByESFMId_STId_SQId_Single(esfMatchId, stId, sqmId);
				
				if(0 < result.size()){
					Paragraph paragraphSportQUal = new Paragraph();
					paragraphSportQUal.setAlignment(com.itextpdf.text.Element.ALIGN_LEFT);
					paragraphSportQUal.setSpacingAfter(15);
					paragraphSportQUal.setFont(fontTeam);
					paragraphSportQUal.add(qualificationName+" "+sportTypeName);
					document.add(paragraphSportQUal);
					
					for(ESFResult res : result){
						
						float[] columnWidthsResult = {5,30,20,10,10};
						PdfPTable tableResult = new PdfPTable(columnWidthsResult);
						
						tableResult.setWidthPercentage(100);
						tableResult.getDefaultCell().setPaddingLeft(paddingleft);
						
						String position = ")";
						String shooterName = "";
						String seriesResult = "/"+String.valueOf(numDisk);
						String ShootOff1 ="";
						String ShootOff2 ="";
						
						if(Validator.isNotNull(res)){
							if(Validator.isNotNull(res.getPosition()) ){
								position = String.valueOf(res.getPosition()) + position ;
							}
							if(Validator.isNotNull(res.getShooterName())){
								shooterName = res.getShooterName() + "("+ res.getNationCode()+")";
							}
							if(Validator.isNotNull(res.getTotalS())){
								seriesResult = res.getTotalS()+seriesResult;
							}
							if(Validator.isNotNull(res.getShootOff1s())){
								ShootOff1 =String.valueOf(res.getShootOff1s()) ;
							}
							if(Validator.isNotNull(res.getShootOff2s())){
								ShootOff2 =String.valueOf(res.getShootOff2s()) ;
							}
						}
						
						PdfPCell cellR1 = new PdfPCell(new Paragraph(position));
						PdfPCell cellR2 = new PdfPCell(new Paragraph(shooterName));
						PdfPCell cellR3 = new PdfPCell(new Paragraph(seriesResult));
						PdfPCell cellR4 = new PdfPCell(new Paragraph(ShootOff1));
						PdfPCell cellR5 = new PdfPCell(new Paragraph(ShootOff2));
						
						cellR1.setBorder(0);
						cellR2.setBorder(0);
						cellR3.setBorder(0);
						cellR4.setBorder(0);
						cellR5.setBorder(0);
						
						tableResult.addCell(cellR1);
						tableResult.addCell(cellR2);
						tableResult.addCell(cellR3);
						tableResult.addCell(cellR4);
						tableResult.addCell(cellR5);
						
						document.add(tableResult);
					}
					
				}
				
			}
		}
		boolean fristTeam = true;
		for(String s : splits){
			
			long stId = 0;
			
			if(!StringPool.BLANK.equals(s)){
				stId = Long.valueOf(s);
			}
			for(Long sqmId : sqmIds){
				qualificationName = "";
				sportTypeName = "";
				
				if( 0 < sqmId && Validator.isNotNull(ESFShooterQualificationLocalServiceUtil.fetchESFShooterQualification(sqmId)) &&
								Validator.isNotNull(ESFShooterQualificationLocalServiceUtil.fetchESFShooterQualification(sqmId).getName())){
					qualificationName = ESFShooterQualificationLocalServiceUtil.fetchESFShooterQualification(sqmId).getName();
				}
				
				if(!StringPool.BLANK.equals(s) && Validator.isNotNull(ESFSportTypeLocalServiceUtil.fetchESFSportType(Long.valueOf(s))) &&
								Validator.isNotNull(ESFSportTypeLocalServiceUtil.fetchESFSportType(Long.valueOf(s)).getName())){
					sportTypeName = (ESFSportTypeLocalServiceUtil.fetchESFSportType(Long.valueOf(s)).getName());
				}
				
				result = ESFResultLocalServiceUtil.findByESFMId_STId_SQId_TEAM(esfMatchId, stId, sqmId);
				
				if(0 < result.size()){
					String positionTeam="";
					String teamNation ="ITA";
					int teamTotal = 0;
					
					positionTeam =String.valueOf(result.get(0).getResultClassTeam());
					
					if(fristTeam){
						
						Paragraph paragraphTeam = new Paragraph();
						paragraphTeam.setAlignment(com.itextpdf.text.Element.ALIGN_LEFT);
						paragraphTeam.setSpacingAfter(15);
						paragraphTeam.setFont(fontTeam);
						paragraphTeam.add("Squadre");
						document.add(paragraphTeam);
						fristTeam = false;
					}
					
					Paragraph paragraphTeamIntestation = new Paragraph();
					paragraphTeamIntestation.setAlignment(com.itextpdf.text.Element.ALIGN_LEFT);
					paragraphTeamIntestation.setSpacingAfter(15);
					paragraphTeamIntestation.setFont(fontTeam);
					paragraphTeamIntestation.add(qualificationName+" "+sportTypeName+"                   "+positionTeam+") "+ teamNation);
					document.add(paragraphTeamIntestation);
					
					
					
					for(ESFResult res : result){
						String shooterName = "";
						int resultShooterTeam = 0;
						
						// mi serve per calcolare ritrovare i piattelli sparati
						
						try {
							ESFResult singoleTeamResult = new ESFResultImpl();
							singoleTeamResult = (ESFResult) ESFResultLocalServiceUtil.findByESFMId_STId_SQId_Single(esfMatchId, stId, sqmId);
							
							if(Validator.isNotNull(singoleTeamResult)){
								resultShooterTeam = singoleTeamResult.getTotalS();
							}
						}
						catch (Exception e) {
							// TODO: handle exception
						}
						
						teamTotal = teamTotal +resultShooterTeam;
						
						float[] columnWidthsResult = {5,30,20,10,10};
						PdfPTable tableResult = new PdfPTable(columnWidthsResult);
						
						tableResult.setWidthPercentage(100);
						tableResult.getDefaultCell().setPaddingLeft(paddingleft);
						
						
						if(Validator.isNotNull(res)){
							if(Validator.isNotNull(res.getShooterName())){
								shooterName = res.getShooterName() ;
							}
							
							
						}
						

						PdfPCell cellR1 = new PdfPCell(new Paragraph());
						PdfPCell cellR2 = new PdfPCell(new Paragraph(shooterName));
						PdfPCell cellR3 = new PdfPCell(new Paragraph(resultShooterTeam));
						PdfPCell cellR4 = new PdfPCell(new Paragraph());
						PdfPCell cellR5 = new PdfPCell(new Paragraph());
						
						cellR1.setBorder(0);
						cellR2.setBorder(0);
						cellR3.setBorder(0);
						cellR4.setBorder(0);
						cellR5.setBorder(0);
						
						tableResult.addCell(cellR1);
						tableResult.addCell(cellR2);
						tableResult.addCell(cellR3);
						tableResult.addCell(cellR4);
						tableResult.addCell(cellR5);
						
						document.add(tableResult);
						
						
						
					}
					Paragraph paragraphTeamtotal = new Paragraph();
					paragraphTeamtotal.setAlignment(com.itextpdf.text.Element.ALIGN_LEFT);
					paragraphTeamtotal.setSpacingAfter(15);
					paragraphTeamtotal.setFont(fontTeam);
					paragraphTeamtotal.add(teamTotal+"/"+match.getNumDiskTeam());
					document.add(paragraphTeamtotal);
					
				}
				
			}
			
		}
		
		XMLWorkerHelper worker = XMLWorkerHelper.getInstance();	
		document.newPage();
		document.close();

		resp.setContentType("application/pdf");
		resp.addProperty(HttpHeaders.CACHE_CONTROL, "max-age=3600, must-revalidate");
		resp.addProperty(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=Albo d'oro.pdf");
		OutputStream out = resp.getPortletOutputStream();
		baos.writeTo(out);
		out.flush();
		out.close();
		
		
	}
	
	public void generatePasses(ResourceRequest req, ResourceResponse resp, long esfMatchId)
			throws SystemException, PortalException{
		
		ESFMatch match = ESFMatchLocalServiceUtil.fetchESFMatch(esfMatchId);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
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
			
			delegations = ESFNationalDelegationLocalServiceUtil.getESFNationalDelegationByESFMatchId(esfMatchId);
			
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
			
			ThemeDisplay themeDisplay = (ThemeDisplay)req.getAttribute(WebKeys.THEME_DISPLAY);
			
			JournalArticle article = JournalArticleLocalServiceUtil.getArticleByUrlTitle(themeDisplay.getScopeGroupId(), "Pass-Model");
			
			String contentNoDel = JournalContentUtil.getContent( themeDisplay.getPortletGroupId(), article.getArticleId(), "", themeDisplay.getLocale().toString(), themeDisplay );
		
			contentNoDel = contentNoDel.replaceAll("_matchInformation", description);
			contentNoDel = contentNoDel.replaceAll("_matchStartDate ", startDate);
			contentNoDel = contentNoDel.replaceAll("_matchEndDate", endDate);
			contentNoDel = contentNoDel.replaceAll("_matchSite", matchCountry);
			
			try{
				//PER STAMPA PDF
				/*com.itextpdf.text.Document document = new com.itextpdf.text.Document();
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				PdfWriter writer = PdfWriter.getInstance(document, baos);
				document.open();
				*/
				String htmlstring="<html>";
				if(Validator.isNotNull(delegations) && delegations.size()>0){
					
					for(ESFNationalDelegation del : delegations){

						String content = JournalContentUtil.getContent( themeDisplay.getPortletGroupId(), article.getArticleId(), "", themeDisplay.getLocale().toString(), themeDisplay );

						content = content.replaceAll("_matchDescription", description);
						content = content.replaceAll("_matchStartDate ", startDate);
						content = content.replaceAll("_matchEndDate", endDate);
						content = content.replaceAll("_matchSite", matchCountry);
						
						
						int rifle = ESFKeys.ESFGunType.RIFLE;
						int caneType = ESFKeys.ESFGunType.CANE;
						int catridgeType = ESFKeys.ESFGunType.CATRIDGE;
						int numberGuns = 0;
						
						ESFUser shooter = new ESFUserImpl();
						List<ESFAddress> address = new ArrayList<ESFAddress>();
						ESFgunUser gun = new ESFgunUserImpl();
						List<ESFCane> canes = new ArrayList<ESFCane>();
						List<ESFCatridge> catridges = new ArrayList<ESFCatridge>();
						ESFAddress esfAddress = new ESFAddressImpl();
						Address addr = null;
						ESFCity city = new ESFCityImpl();
						List<ESFgunUser> gunUser = new ArrayList<ESFgunUser>();
						ESFGunType gunType = new ESFGunTypeImpl();
						ESFGunKind gunKind = new ESFGunKindImpl();
						ListType type = null;
						
						String partecipantName = "";
						String _shooterBirthday = "";
						String _shooterCity = "";
						String _shooterCountry = "";
						String _shooterStreet = "";
						String _matchPlace = "";
						String _gunType0 = "";
						String _gunCaliber0 = "";
						String _gunBrand0 = "";
						String _gunModel0 = "";
						String _gunCode0 = "";
						String _gunType1 = "";
						String _gunCaliber1 = "";
						String _gunBrand1 = "";
						String _gunModel1 = "";
						String _gunCode1 = "";
						String _catridgeBrand = "";
						String _catridgeCaliber = "";
						String _caneType0 = "";
						String _caneType1 = "";
						String _caneType2 = "";
						
						shooter = ESFUserLocalServiceUtil.fetchESFUser(del.getEsfUserId());
						String className = ESFUser.class.getName();
						long classPK = shooter.getEsfUserId();
						
						address = ESFAddressLocalServiceUtil.getESFAddresses(themeDisplay.getCompanyId(), className, classPK);
						
						if(Validator.isNotNull(shooter.getFirstName())){
							partecipantName = (partecipantName + shooter.getFirstName()+" ").toUpperCase();
						}
						
						
						if(Validator.isNotNull(shooter.getLastName())){
							partecipantName = (partecipantName + shooter.getLastName()).toUpperCase();
						} 
						
						
						if(Validator.isNotNull(shooter.getBirthday())){
							_shooterBirthday = sdf.format(shooter.getBirthday());
						}
						
						if(Validator.isNotNull(address) && address.size() > 0){
							for(ESFAddress a : address){
								if(a.getListTypeId() == ESFKeys.ESFAddressListType.LEGAL){
									esfAddress = a;
								}
							}
						}
						
						if(Validator.isNotNull(esfAddress)){
							addr = AddressLocalServiceUtil.fetchAddress(esfAddress.getEsfAddressId());
							ESFCityPK cityPk = new ESFCityPK();
							cityPk.setIdCity(esfAddress.getEsfCityId());
							cityPk.setIdCountry(esfAddress.getEsfCountryId());
							cityPk.setIdProvince(esfAddress.getEsfProvinceId());
							cityPk.setIdRegion(esfAddress.getEsfRegionId());
							city = ESFCityLocalServiceUtil.fetchESFCity(cityPk);
						}
						
						if(Validator.isNotNull(addr) && Validator.isNotNull(CountryServiceUtil.fetchCountry(addr.getCountryId()))){
							_shooterCountry = CountryServiceUtil.fetchCountry(addr.getCountryId()).getName().toUpperCase();
						}
						
						if(Validator.isNotNull(addr) && Validator.isNotNull(addr.getStreet1())){
							_shooterStreet = addr.getStreet1();
						}
						
						if(Validator.isNotNull(city)){
							_shooterCity = city.getName();
						}
						
						if(Validator.isNotNull(match) && Validator.isNotNull(match.getSite())){
							_matchPlace = match.getSite();
						}
						
						gunUser = ESFgunUserLocalServiceUtil.getESFGunByLikeS_T(shooter.getEsfUserId(), rifle, 
								0, Integer.MAX_VALUE);
						
						for(ESFgunUser gu : gunUser){
							
							if(gu.getIsFavorite() && numberGuns == 0){
								
								if(Validator.isNotNull(ESFGunTypeLocalServiceUtil.fetchESFGunType(gu.getEsfGunnTypeId())) &&
										Validator.isNotNull(ESFGunTypeLocalServiceUtil.fetchESFGunType(gu.getEsfGunnTypeId()).getName()) &&
											gu.getEsfGunnTypeId() > 0){
									
									_gunBrand0 = ESFGunTypeLocalServiceUtil.fetchESFGunType(gu.getEsfGunnTypeId()).getName();
									
								}
								
								if(Validator.isNotNull(ESFGunKindLocalServiceUtil.fetchESFGunKind(gu.getEsfGunKindId())) &&
										Validator.isNotNull(ESFGunKindLocalServiceUtil.fetchESFGunKind(gu.getEsfGunKindId()).getName())){
									
									_gunModel0 = ESFGunKindLocalServiceUtil.fetchESFGunKind(gu.getEsfGunKindId()).getName();
									
								}
								
								if(Validator.isNotNull(ListTypeServiceUtil.getListType((int)(gu.getTypeId()))) &&
										Validator.isNotNull(ListTypeServiceUtil.getListType((int)(gu.getTypeId())).getName())){
									
									_gunType0 = ListTypeServiceUtil.getListType((int)(gu.getTypeId())).getName();
									
								}
								
								_gunCode0 = gu.getCode();
								_gunCaliber0 = gu.getEsfCaliber();
								
								numberGuns = numberGuns +1;
								
							}else if(gu.getIsFavorite() && numberGuns == 1){
								if(Validator.isNotNull(ESFGunTypeLocalServiceUtil.fetchESFGunType(gu.getEsfGunnTypeId())) &&
										Validator.isNotNull(ESFGunTypeLocalServiceUtil.fetchESFGunType(gu.getEsfGunnTypeId()).getName()) &&
										gu.getEsfGunnTypeId() > 0){
									
									_gunBrand1 = ESFGunTypeLocalServiceUtil.fetchESFGunType(gu.getEsfGunnTypeId()).getName();
									
								}
								
								if(Validator.isNotNull(ESFGunKindLocalServiceUtil.fetchESFGunKind(gu.getEsfGunKindId())) &&
										Validator.isNotNull(ESFGunKindLocalServiceUtil.fetchESFGunKind(gu.getEsfGunKindId()).getName())){
									
									_gunModel1 = ESFGunKindLocalServiceUtil.fetchESFGunKind(gu.getEsfGunKindId()).getName();
									
								}
								
								if(Validator.isNotNull(ListTypeServiceUtil.getListType((int)(gu.getTypeId()))) &&
										Validator.isNotNull(ListTypeServiceUtil.getListType((int)(gu.getTypeId())).getName())){
									
									_gunType1 = ListTypeServiceUtil.getListType((int)(gu.getTypeId())).getName();
									
								}
								
								_gunCode1 = gu.getCode();
								_gunCaliber1 = gu.getEsfCaliber();
								
								numberGuns = numberGuns +1;
								
							}
						}
						
						numberGuns = 0;
						
						gunUser = ESFgunUserLocalServiceUtil.getESFGunByLikeS_T(shooter.getEsfUserId(), caneType, 
								0, Integer.MAX_VALUE);
						///canne inizio
						
						for(ESFgunUser gu : gunUser){
							
							if(gu.getIsFavorite() && numberGuns == 0){
								
								if(gu.getEsfGunnTypeId() > 0 && Validator.isNotNull(ESFGunTypeLocalServiceUtil.fetchESFGunType(gu.getEsfGunnTypeId())) 
										&& Validator.isNotNull(ESFGunTypeLocalServiceUtil.fetchESFGunType(gu.getEsfGunnTypeId()).getName())){
									_caneType0 = ESFGunTypeLocalServiceUtil.fetchESFGunType(gu.getEsfGunnTypeId()).getName();
								
									numberGuns = numberGuns +1;
								}
								
							}else if(gu.getIsFavorite() && numberGuns == 1){
								
								if(gu.getEsfGunnTypeId() > 0 && Validator.isNotNull(ESFGunTypeLocalServiceUtil.fetchESFGunType(gu.getEsfGunnTypeId())) 
										&& Validator.isNotNull(ESFGunTypeLocalServiceUtil.fetchESFGunType(gu.getEsfGunnTypeId()).getName())){
									_caneType1 = ESFGunTypeLocalServiceUtil.fetchESFGunType(gu.getEsfGunnTypeId()).getName();
								
									numberGuns = numberGuns +1;
								}
								
							}else if(gu.getIsFavorite() && numberGuns == 2){
								
								if(gu.getEsfGunnTypeId() > 0 && Validator.isNotNull(ESFGunTypeLocalServiceUtil.fetchESFGunType(gu.getEsfGunnTypeId())) 
										&& Validator.isNotNull(ESFGunTypeLocalServiceUtil.fetchESFGunType(gu.getEsfGunnTypeId()).getName())){
									_caneType2 = ESFGunTypeLocalServiceUtil.fetchESFGunType(gu.getEsfGunnTypeId()).getName();
								
									numberGuns = numberGuns +1;
								}
							}
						}
						
						gunUser = ESFgunUserLocalServiceUtil.getESFGunByLikeS_T(shooter.getEsfUserId(), catridgeType, 
								0, Integer.MAX_VALUE);
						numberGuns = 0;
						for(ESFgunUser gu : gunUser){
							
							if(gu.getIsFavorite() && numberGuns == 0){
								
								if(gu.getEsfGunnTypeId() > 0 && Validator.isNotNull(ESFGunTypeLocalServiceUtil.fetchESFGunType(gu.getEsfGunnTypeId())) 
										&& Validator.isNotNull(ESFGunTypeLocalServiceUtil.fetchESFGunType(gu.getEsfGunnTypeId()).getName())){
									
									_catridgeBrand = ESFGunTypeLocalServiceUtil.fetchESFGunType(gu.getEsfGunnTypeId()).getName();
								
									numberGuns = numberGuns +1;
								}
								
								_catridgeCaliber = gu.getEsfCaliber();
							}
							
						}
						
						content = content.replaceAll("_shooterName", partecipantName);
						content = content.replaceAll("_shooterBirthday", _shooterBirthday); 
						content = content.replaceAll("_shooterCity", _shooterCity); 
						content = content.replaceAll("_shooterCountry", _shooterCountry); 
						content = content.replaceAll("_shooterStreet", _shooterStreet);
						content = content.replaceAll("_matchPlace", _matchPlace);
						
						content = content.replaceAll("_gunBrand0", _gunBrand0);
						content = content.replaceAll("_gunModel0", _gunModel0);
						content = content.replaceAll("_gunType0", _gunType0);
						content = content.replaceAll("_gunCode0", _gunCode0);
						content = content.replaceAll("_gunCaliber0", _gunCaliber0);
						content = content.replaceAll("_gunBrand1", _gunBrand1);
						content = content.replaceAll("_gunModel1", _gunModel1);
						content = content.replaceAll("_gunType1", _gunType1);
						content = content.replaceAll("_gunCode1", _gunCode1);
						content = content.replaceAll("_gunCaliber1", _gunCaliber1);
						
						content = content.replaceAll("_catridgeBrand", _catridgeBrand);
						content = content.replaceAll("_catridgeCaliber", _catridgeCaliber);
						content = content.replaceAll("_caneType0", _caneType0);
						content = content.replaceAll("_caneType1", _caneType1);
						content = content.replaceAll("_caneType2", _caneType2);
						
						/* PER STAMPA PDF
						XMLWorkerHelper worker = XMLWorkerHelper.getInstance();
						InputStream is = new ByteArrayInputStream(content.getBytes(StandardCharsets.UTF_8));
						worker.parseXHtml(writer, document, is, Charset.forName("UTF-8"));
						document.newPage();
						*/
						htmlstring= ""+htmlstring+content.toString()+"<br clear=\"all\" style=\"page-break-before:always\" />";	 
					}
				
				}else{
					/*PER STAMPA PDF
					XMLWorkerHelper worker = XMLWorkerHelper.getInstance();
					InputStream is = new ByteArrayInputStream(contentNoDel.getBytes(StandardCharsets.UTF_8));
					worker.parseXHtml(writer, document, is, Charset.forName("UTF-8"));
					*/
					htmlstring= ""+htmlstring+contentNoDel.toString();	 
				}
				/* PER STAMPA PDF		
				document.close();
				resp.setContentType("application/pdf");
				resp.addProperty(HttpHeaders.CACHE_CONTROL, "max-age=3600, must-revalidate");
				resp.addProperty(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename= Lasciapassare per la gara "+match.getCode()+".pdf;");
				OutputStream out = resp.getPortletOutputStream();
				baos.writeTo(out);
				out.flush();
				out.close();
				*/
				String pgBreak="<br clear=\"all\" style=\"page-break-before:always\" />";
				htmlstring=removeEnd(htmlstring,pgBreak);
				htmlstring=htmlstring+"</html>";
				String docname="Lasciapassare per la gara "+match.getCode()+".doc";
				String contextPath = getPortletContext().getRealPath(File.separator);
				String namefile=contextPath+docname;
				BufferedWriter bw = null;
				FileWriter fw = null;
				fw = new FileWriter(namefile);
				bw = new BufferedWriter(fw);
				bw.write(htmlstring);
				bw.close();
				resp.setContentType("msword/doc");
				resp.addProperty(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename="+docname);
				FileInputStream fileInputStream = new FileInputStream(namefile);
				OutputStream responseOutputStream = resp.getPortletOutputStream();
				int bytes;
				while ((bytes = fileInputStream.read()) != -1) {
					responseOutputStream.write(bytes);
					
				}
				fileInputStream.close();
				 	
				

			}catch (Exception e2) {

				e2.printStackTrace();
			}
		
		}
		
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
			
			ThemeDisplay themeDisplay = (ThemeDisplay)req.getAttribute(WebKeys.THEME_DISPLAY);
			
			JournalArticle article = JournalArticleLocalServiceUtil.getArticleByUrlTitle(themeDisplay.getScopeGroupId(), "Convocations-Model");
			
			String contentNoDel = JournalContentUtil.getContent( themeDisplay.getPortletGroupId(), article.getArticleId(), "", themeDisplay.getLocale().toString(), themeDisplay );
			
			//System.out.println("contentnodel tostring: "+contentNoDel);
			

			contentNoDel = contentNoDel.replaceAll("_today", today);
			contentNoDel = contentNoDel.replaceAll("_NMInformation", description);
			contentNoDel = contentNoDel.replaceAll("_startDateNM", startDate);
			contentNoDel = contentNoDel.replaceAll("_endDateNM", endDate);
			
			
			try{
				/*com.itextpdf.text.Document document = new com.itextpdf.text.Document(); 
				ByteArrayOutputStream baos = new ByteArrayOutputStream(); 				
				PdfWriter writer = PdfWriter.getInstance(document, baos); 
				document.open();	per stampa PDF, da rimuovere*/
				String htmlstring="<html>";
				if(Validator.isNotNull(delegations) && delegations.size()>0){

					for(ESFNationalDelegation del : delegations){
						
						ESFUser shooter = new ESFUserImpl();
						String partecipantName = "";
						
						shooter = ESFUserLocalServiceUtil.fetchESFUser(del.getEsfUserId());
						long armyTypeId=shooter.getTypearmy();
						if (armyTypeId != 0)
						{
							String armyName=ListTypeServiceUtil.getListType((int)armyTypeId).getName();
							
							if(armyName.equals("Polizia")){
								article = JournalArticleLocalServiceUtil.getArticleByUrlTitle(themeDisplay.getScopeGroupId(), "Convocations-Model-Polizia");
							}else if(armyName.equals("Carabinieri")){
								article = JournalArticleLocalServiceUtil.getArticleByUrlTitle(themeDisplay.getScopeGroupId(), "Convocations-Model-Carabinieri");
							}else if(armyName.equals("Esercito")){
								article = JournalArticleLocalServiceUtil.getArticleByUrlTitle(themeDisplay.getScopeGroupId(), "Convocations-Model-Esercito");
							}else if(armyName.equals("Marina Militare")){
								article = JournalArticleLocalServiceUtil.getArticleByUrlTitle(themeDisplay.getScopeGroupId(), "Convocations-Model-Marina-Militare");
							}else if(armyName.equals("Aeronautica")){
								article = JournalArticleLocalServiceUtil.getArticleByUrlTitle(themeDisplay.getScopeGroupId(), "Convocations-Model-Aeronautica");
							}else if(armyName.equals("Vigili del Fuoco")){
								article = JournalArticleLocalServiceUtil.getArticleByUrlTitle(themeDisplay.getScopeGroupId(), "Convocations-Model-Vigili-del-Fuoco");
							}else if(armyName.equals("Guardia di Finanza")){
								article = JournalArticleLocalServiceUtil.getArticleByUrlTitle(themeDisplay.getScopeGroupId(), "Convocations-Model-Guardia-di-Finanza");
							}else if(armyName.equals("Polizia Municipale")){
								article = JournalArticleLocalServiceUtil.getArticleByUrlTitle(themeDisplay.getScopeGroupId(), "Convocations-Model-Polizia-Municipale");
							}else if(armyName.equals("Polizia Penitenziaria")){
								article = JournalArticleLocalServiceUtil.getArticleByUrlTitle(themeDisplay.getScopeGroupId(), "Convocations-Model-Polizia-Penitenziaria");
							}else{
								article = JournalArticleLocalServiceUtil.getArticleByUrlTitle(themeDisplay.getScopeGroupId(), "Convocations-Model");
							}
							
						}
						
						String content = JournalContentUtil.getContent( themeDisplay.getPortletGroupId(), article.getArticleId(), "", themeDisplay.getLocale().toString(), themeDisplay );
						
						content = content.replaceAll("_today", today);
						content = content.replaceAll("_NMInformation", description);
						content = content.replaceAll("_startDateNM", startDate);
						content = content.replaceAll("_endDateNM", endDate);
						
						
						if(Validator.isNotNull(shooter.getFirstName())){
							partecipantName = (partecipantName + shooter.getFirstName()+" ").toUpperCase();
						}
						if(Validator.isNotNull(shooter.getLastName())){
							partecipantName = (partecipantName + shooter.getLastName()).toUpperCase();
						}

						content = content.replaceAll("_shooterNameNM", partecipantName);
						
						ESFDeparture leaveDeparture = null;
						ESFDeparture returnDeparture = null;
						
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

						if(Validator.isNotNull(departures) && departures.size() > 0){
							
							for(ESFDeparture dep : departures){

								if(dep.getIsReturn()){
									returnDeparture = dep;
								}else{
									leaveDeparture = dep;
								}
							}
							
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

							content = content.replaceAll("_tralvelReturnDate", _tralvelReturnDate);
							content = content.replaceAll("_travelReturnHour", _travelReturnHourStart);
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
							
						/*	XMLWorkerHelper worker = XMLWorkerHelper.getInstance();							
							InputStream is = new ByteArrayInputStream(content.getBytes(StandardCharsets.UTF_8));
							worker.parseXHtml(writer, document, is, Charset.forName("UTF-8"));
							document.newPage();     per stampa PDF, da rimuovere*/
							htmlstring= ""+htmlstring+content.toString()+"<br clear=\"all\" style=\"page-break-before:always\" />";						
							
							
													
						}else{
							/*
							XMLWorkerHelper worker = XMLWorkerHelper.getInstance();
							InputStream is = new ByteArrayInputStream(content.getBytes(StandardCharsets.UTF_8));
							worker.parseXHtml(writer, document, is, Charset.forName("UTF-8"));
							document.newPage();
							 per stampa PDF, da rimuovere*/
							htmlstring= ""+htmlstring+content.toString()+"<br clear=\"all\" style=\"page-break-before:always\" />";						
							
						}
					}
				}else{
					/*XMLWorkerHelper worker = XMLWorkerHelper.getInstance();
					InputStream is = new ByteArrayInputStream(contentNoDel.getBytes(StandardCharsets.UTF_8));
					worker.parseXHtml(writer, document, is, Charset.forName("UTF-8"));
					per stampa PDF, da rimuovere
					htmlstring= ""+htmlstring+contentNoDel.toString();																
					per stampa PDF, da rimuovere*/
					
					htmlstring= ""+htmlstring+contentNoDel.toString();																
				}
				
			//	document.close();  per stampa PDF, da rimuovere*/
				String pgBreak="<br clear=\"all\" style=\"page-break-before:always\" />";
				htmlstring=removeEnd(htmlstring,pgBreak);
				htmlstring=htmlstring+"</html>";
				String docname="Convocazione alla gara "+match.getCode()+".doc";
				String contextPath = getPortletContext().getRealPath(File.separator);
				String namefile=contextPath+docname;
				BufferedWriter bw = null;
				FileWriter fw = null;
				fw = new FileWriter(namefile);
				bw = new BufferedWriter(fw);
				bw.write(htmlstring);
				bw.close();
				resp.setContentType("msword/doc");				
				//resp.setContentType("application/pdf");
				
				resp.addProperty(HttpHeaders.CACHE_CONTROL, "max-age=3600, must-revalidate");
				/*resp.addProperty(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename= Convocazione alla gara "+match.getCode()+".pdf;");
				per stampa PDF, da rimuovere*/
				
				resp.addProperty(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename="+docname);
				
				/*OutputStream out = resp.getPortletOutputStream();
				baos.writeTo(out);
				out.flush();
				out.close();
				*/
				FileInputStream fileInputStream = new FileInputStream(namefile);
				OutputStream responseOutputStream = resp.getPortletOutputStream();
				int bytes;
				while ((bytes = fileInputStream.read()) != -1) {
					responseOutputStream.write(bytes);
					
				}
				fileInputStream.close();
			}catch (Exception e2) {
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
				ParamUtil.getString(resourceRequest,"lastName").replace(" ","");
		String firstName =
				ParamUtil.getString(resourceRequest,"firstName").replace(" ","");
		String middleName =
				ParamUtil.getString(resourceRequest,"middleName").replace(" ","");
		String birthcity =
				ParamUtil.getString(resourceRequest,"birthcity").replace(" ","");
		Boolean male =
				ParamUtil.getBoolean(resourceRequest,"male");
		String birthday =
				ParamUtil.getString(resourceRequest,"birthday");
		String sex = "f";
		if (male){
			
			sex = "m";
			
		}
		String totalName = firstName.concat(middleName);
		String url = "http://webservices.dotnethell.it/codicefiscale.asmx/CalcolaCodiceFiscale?Nome="+totalName+"&Cognome="+lastName+"&ComuneNascita="
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
		boolean validateCF = ParamUtil.getBoolean(actionRequest, "validateCF");
		
		if (Validator.isNotNull(fiscalCode)) {

			if (!ManageOperationsField.validate(fiscalCode))

				SessionErrors.add(actionRequest, "error");
			return;
		}
		
		String privacy1DateS = ParamUtil.getString(actionRequest, "privacy1Date");
		Date privacy1Date = ManageDate.StringToDate(privacy1DateS);
		Date privacy2Date = null;
		Date privacy3Date = null;
		
		boolean privacy1 = true;
		boolean privacy2 = ParamUtil.getBoolean(actionRequest, "privacy2");
		boolean privacy3 = ParamUtil.getBoolean(actionRequest, "privacy3");
		
		if(privacy2){
			privacy2Date = ManageDate.StringToDate(ParamUtil.getString(actionRequest, "privacy2Date"));
		}
		
		if(privacy3){
			privacy3Date = ManageDate.StringToDate(ParamUtil.getString(actionRequest, "privacy3Date"));
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
				ESFUser user=ESFUserLocalServiceUtil.fetchESFUser(serviceContext.getUserId());
				ESFUser userResult =
					ESFUserLocalServiceUtil.addESFShooter(
						serviceContext.getUserId(), StringPool.BLANK,
						firstName, middleName, lastName, userEmail, fiscalCode,
						day, month, year, birthcity, nationality, male, skype,
						facebook, twitter, typearmy, isSportsGroups, job,
						jobTitle, issfIdNumber, esfEntityState, esfCard,
						addresses, phones, 
						privacy1, privacy2, privacy3,
						privacy1Date, privacy2Date, privacy3Date, validateCF,0,
						serviceContext);

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
		boolean validateCF = ParamUtil.getBoolean(actionRequest, "validateCF");
		
		if (Validator.isNotNull(fiscalCode)) {
			
			if (!ManageOperationsField.validate(fiscalCode)){
				SessionErrors.add(actionRequest, "error");
				return;
			}
		}
		
		String privacy1DateS = ParamUtil.getString(actionRequest, "privacy1Date");
		Date privacy1Date = ManageDate.StringToDate(privacy1DateS);
		Date privacy2Date = null;
		Date privacy3Date = null;
		
		boolean privacy1 = true;
		boolean privacy2 = ParamUtil.getBoolean(actionRequest, "privacy2");
		boolean privacy3 = ParamUtil.getBoolean(actionRequest, "privacy3");
		
		if(privacy2){
			privacy2Date = ManageDate.StringToDate(ParamUtil.getString(actionRequest, "privacy2Date"));
		}
		
		if(privacy3){
			privacy3Date = ManageDate.StringToDate(ParamUtil.getString(actionRequest, "privacy3Date"));
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
				Date deathDate = esfUserToUpdate.getDateOfDeath();
				ESFUser userResult =
					ESFUserLocalServiceUtil.updateESFShooter(
						serviceContext.getUserId(), esfUserId, "", firstName,
						middleName, lastName, userEmail, fiscalCode, day,
						month, year, birthcity, nationality, male, disable,
						skype, facebook, twitter, typearmy, isSportsGroups,
						job, jobTitle, issfIdNumber, esfEntityState, esfCard,
						addresses, phones, deathDate, 
						privacy1, privacy2, privacy3,
						privacy1Date, privacy2Date, privacy3Date, validateCF,esfUserToUpdate.getCodeUser(),
						serviceContext);

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
			actionResponse.setRenderParameter("esfMatchId",String.valueOf(esfMatchId));
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
	
	
	/*public void editESFdocument(ActionRequest request, ActionResponse response)
		throws PortalException, SystemException, ParseException {

		ServiceContext serviceContext =
				ServiceContextFactory.getInstance(
						ESFNationalMatchPortlet.class.getName(), request);

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

			/*try {
				User user = UserLocalServiceUtil.fetchUser(userId);

				long groupId = user.getGroupId();

				long companyId = user.getCompanyId();

				String userName = user.getFullName();

				String path = "";

				if (esfDocumentId > 0) {
					
					String oldFilePath = "";
					String dirDeleteFile = "";
					
					try {
						dirDeleteFile = PropsUtil.get("auto.deploy.tomcat.dest.dir") ;
						oldFilePath = ESFDocumentLocalServiceUtil.fetchESFDocument(esfDocumentId).getPath();
						
					}
					catch (Exception e) {
						// TODO: handle exception
					}
					
					path = uploadFile(uploadRequest, user, type);

					if("".equals(path) && "".equals(ESFDocumentLocalServiceUtil.fetchESFDocument(esfDocumentId).getPath())){
						path = "";
					}else if(!"".equals(ESFDocumentLocalServiceUtil.fetchESFDocument(esfDocumentId).getPath())){
						
						if(!"".equals(path) && !oldFilePath.equalsIgnoreCase(path)){
							path = path;
						}else{
							path = ESFDocumentLocalServiceUtil.fetchESFDocument(esfDocumentId).getPath();
						}
					}

					Date modifiedDate = new Date();

					ESFDocumentLocalServiceUtil.updateEsfDocument(
						esfDocumentId, groupId, companyId, userName,
						user.getUserId(), code, releasedBy, modifiedDate,
						releaseDate, expirationDate, type, path, serviceContext);
					
					if(!oldFilePath.equalsIgnoreCase(path)){
						File toBeDeletedFile = new File(dirDeleteFile+oldFilePath);
						toBeDeletedFile.delete();
						
					}
					
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
				response.setRenderParameter("mvcPath", "/html/esfnationalmatch/" +
							"/management_esfMatch.jsp");
				response.setRenderParameter("esfUserId", String.valueOf(esfUserId));
				response.setRenderParameter(
					"esfMatchId", String.valueOf(esfMatchId));
				response.setRenderParameter("op", "updAddr");
			}
	}*/
	
	public void editESFdocument(ActionRequest request, ActionResponse response)
					throws PortalException, SystemException, ParseException,
					PortletException {
					ShooterUtility su = new ShooterUtility();
					su.init(this.getPortletConfig());
					su.editESFdocument(request, response, "esfnationalmatch/tabs");

	}
	
	public void deleteESFdocument(ActionRequest request, ActionResponse response)
					throws PortalException, SystemException, ParseException,
					PortletException {

					ShooterUtility su = new ShooterUtility();
					su.init(this.getPortletConfig());
					su.deleteESFdocument(request, response, "esfnationalmatch/tabs");

	}

	private String uploadFile(
		UploadPortletRequest uploadRequest, User user, String type) {

		String dir = PropsUtil.get("auto.deploy.tomcat.dest.dir") + File.separator +
				"shooter_document"+ File.separator +user.getUserId();
		
		String paramName = "path";
		
		if (uploadRequest.getSize(paramName) == 0) {
			return "";
		}
		
		File uploadedFile = uploadRequest.getFile(paramName);
		
		String ext =
			uploadedFile.getName().substring(
				uploadedFile.getName().lastIndexOf("."));
		
		//String sourceFileName = type + "_" + user.getEmailAddress();
		String sourceFileName = type + "_" + user.getUserId();
		
		
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
		return File.separator + "shooter_document" + File.separator +user.getUserId() + File.separator +
			sourceFileName + ext;
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
		long sportTypeId =
						ParamUtil.getLong(request, "sportTypeId");
		long qualificationId =
						ParamUtil.getLong(request, "qualificationId");
		boolean isAzzurro = ParamUtil.getBoolean(request, "isAzzurro");
		
		List<ESFResult> result = new ArrayList<ESFResult>();
		
		result = ESFResultLocalServiceUtil.findByESFMatchid(esfMatchId);
		
		try {
				
			if(0 <= result.size()){
			
				if(isAzzurro){
					
					ESFNationalDelegation shooter = new ESFNationalDelegationImpl();
					shooter = ESFNationalDelegationLocalServiceUtil.
									getMatchId_UserId_SportTypeId_QualificationId(esfMatchId, esfUserId, sportTypeId, qualificationId);
					
					
					if(Validator.isNotNull(shooter) ){
						ESFNationalDelegationLocalServiceUtil.deleteESFNationalDelegation(shooter);
					} else{
						SessionErrors.add(request, "errorDeleteDelegationImpl");
					}
					
				}else{
					
					List<ESFNationalDelegation> delegations = new ArrayList<ESFNationalDelegation>();
					delegations = ESFNationalDelegationLocalServiceUtil.getESFNationalDelegationByESFUserId_ESFMatchId(esfUserId, esfMatchId);
					
					for(ESFNationalDelegation del: delegations){
						if(del.getEsfPartecipantTypeId() != ESFKeys.ESFNationalDelegationType.SHOOTER){
							ESFNationalDelegationLocalServiceUtil.deleteESFNationalDelegation(del);
						}
					}
				}
			} else{
				SessionErrors.add(request, "errorDeleteDelegation");
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

	public void updateESFMatch(ActionRequest request, ActionResponse response)
		throws PortalException, SystemException, ParseException {

		ServiceContext serviceContext =
			ServiceContextFactory.getInstance(ESFMatch.class.getName(), request);
		long esfMatchId = ParamUtil.getLong(request, "esfMatchId");
		String code = ParamUtil.getString(request, "code");
		String sd = ParamUtil.getString(request, "startDate");
		String ed = ParamUtil.getString(request, "endDate");
		_log.debug("ESFNationalMatchPortlet - esfMatchId:"+esfMatchId+" - code: "+code);
		boolean internationalPlace =
			ParamUtil.getBoolean(request, "siteInternational");
		Date startDate = null;
		Date endDate = null;
		try {
			startDate = ManageDate.StringToDate(sd);
			endDate = ManageDate.StringToDate(ed);
		} catch (ParseException e1) {
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
		} else {
			notNationalAssotiation = "";
			esfCountryId = 0;
		}
		
		ESFEntityState esfEntityState = new ESFEntityStateImpl();
		esfEntityState.setEsfStateId(ESFKeys.ESFStateType.ENABLE);
		
		if (startDate.after(endDate)) {
			SessionErrors.add(request, "date-message");
		} else {
			ESFMatch newMatch =
				ESFMatchLocalServiceUtil.addOrUpdateESFMatch(
					serviceContext.getUserId(), esfMatchId, esfAssociationId,
					code, startDate, endDate, startHour, description, note,
					isDraft, numFields, esfSportTypeId, numDisk, numDiskTeam,
					isIndividualMatch, isTeamMatch, isJuniorMatch,
					esfMatchTypeId, isChangeCategoryMatch, esfShooterCategoryIds,
					esfShooterQualificationIds, esfCountryId, site, true, false,
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
			} else if (esfMatchId == 0) {
				SessionMessages.add(request, "match-success-insert");
				response.setRenderParameter("successMessage", newMatch.getCode());
			} else {
				SessionMessages.add(request, "match-success-update");
				response.setRenderParameter("successMessage", newMatch.getCode());
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
		long esfShooterQualificationIds = ParamUtil.getLong(request, "esfShooterQualificationIds");
		
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
				esfShooterQualificationIds = 0;

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
			esfNationalDelegation.setEsfShooterQualificationId(esfShooterQualificationIds);
			

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
							 " che si terrï¿½ in " + matchPlace + ".\n"+
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

	public void generateLicences( ResourceRequest req, ResourceResponse resp, long esfMatchId) 
			throws SystemException, PortalException{

		ESFMatch match = ESFMatchLocalServiceUtil.fetchESFMatch(esfMatchId);
		
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
			delegations = ESFNationalDelegationLocalServiceUtil.getESFNationalDelegationByESFMatchId(esfMatchId);
			
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
			
			ThemeDisplay themeDisplay = (ThemeDisplay)req.getAttribute(WebKeys.THEME_DISPLAY);
			
			JournalArticle article = JournalArticleLocalServiceUtil.getArticleByUrlTitle(themeDisplay.getScopeGroupId(), "License-Model");
			
			String contentNoDel = JournalContentUtil.getContent( themeDisplay.getPortletGroupId(), article.getArticleId(), "", themeDisplay.getLocale().toString(), themeDisplay );
			
			contentNoDel = contentNoDel.replaceAll("_today", today);
			contentNoDel = contentNoDel.replaceAll("_matchInformation", description);
			contentNoDel = contentNoDel.replaceAll("_matchStartDate ", startDate);
			contentNoDel = contentNoDel.replaceAll("_matchEndDate", endDate);
			contentNoDel = contentNoDel.replaceAll("_matchSite", matchCountry);

			try{
				/* PER STAMPA PDF
				com.itextpdf.text.Document document = new com.itextpdf.text.Document();
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				PdfWriter writer = PdfWriter.getInstance(document, baos);
				document.open();
				 */
				String htmlstring="<html>"; 
				if(Validator.isNotNull(delegations) && delegations.size()>0){

					for(ESFNationalDelegation del : delegations){

						String content = JournalContentUtil.getContent( themeDisplay.getPortletGroupId(), article.getArticleId(), "", themeDisplay.getLocale().toString(), themeDisplay );

						content = content.replaceAll("_today", today);
						content = content.replaceAll("_matchInformation", description);
						content = content.replaceAll("_matchStartDate ", startDate);
						content = content.replaceAll("_matchEndDate", endDate);
						content = content.replaceAll("_matchSite", matchCountry);
						
						ESFUser shooter = new ESFUserImpl();
						ESFCard card =new ESFCardImpl();
						ESFOrganization org = new ESFOrganizationImpl();
						List<ESFAddress> address = new ArrayList<ESFAddress>();
						ESFAddress esfAddress = new ESFAddressImpl();
						List<Phone> phones = new ArrayList<Phone>();
						Address addr = null;
						ESFCity city = new ESFCityImpl();
						
						String partecipantName = "";
						String _associationName = "";
						String _sportGroup = "";
						String _associationAddress = "";
						String _associationCity = "";
						String _associationFaxNumber = "";
						String _associationZip = "";

						shooter = ESFUserLocalServiceUtil.fetchESFUser(del.getEsfUserId());
						card = ESFCardLocalServiceUtil.getEsfCardByEsfUserId(del.getEsfUserId());
						org = ESFOrganizationLocalServiceUtil.fetchESFOrganization(card.getEsfOrganizationId());

						String className = Organization.class.getName();
						long classPK = org.getEsfOrganizationId();
						int addressType = ESFKeys.ESFAddressListType.LEGAL;
						int fax = ESFKeys.ESFPhoneListType.BUSINESSFAX;
						address = ESFAddressLocalServiceUtil.getESFAddresses(themeDisplay.getCompanyId(), className, classPK);
						phones = PhoneLocalServiceUtil.getPhones(themeDisplay.getCompanyId(), className, classPK);
						
						for(Phone p : phones){
							if(p.getTypeId() == fax){
								_associationFaxNumber = p.getNumber();
							}
						}
						
						for(ESFAddress a : address){
							if(a.getListTypeId() == addressType){
								addr = AddressLocalServiceUtil.fetchAddress(a.getEsfAddressId());
								ESFCityPK cityPk = new ESFCityPK();
								cityPk.setIdCity(a.getEsfCityId());
								cityPk.setIdCountry(a.getEsfCountryId());
								cityPk.setIdProvince(a.getEsfProvinceId());
								cityPk.setIdRegion(a.getEsfRegionId());
								city = ESFCityLocalServiceUtil.fetchESFCity(cityPk);
							}
						}
						
						if(Validator.isNotNull(org)){
							_associationName = org.getName();
						}

						if(Validator.isNotNull(city)){
							_associationCity = city.getName();
						}

						if(Validator.isNotNull(shooter.getFirstName())){
							partecipantName = (partecipantName + shooter.getFirstName()+" ").toUpperCase();
						}
						if(Validator.isNotNull(shooter.getLastName())){
							partecipantName = (partecipantName + shooter.getLastName()).toUpperCase();
						}
						
						if(Validator.isNotNull(addr)){
							_associationAddress = addr.getStreet1();
							_associationZip = addr.getZip();
						}
						
						content = content.replaceAll("_shooterName", partecipantName);
						content = content.replaceAll("_associationName", _associationName);
						content = content.replaceAll("_associationAddress", _associationAddress);
						content = content.replaceAll("_associationZip", _associationZip);
						content = content.replaceAll("_associationCity", _associationCity);
						content = content.replaceAll("_associationFaxNumber", _associationFaxNumber);
						/* PER STAMPA PDF
						XMLWorkerHelper worker = XMLWorkerHelper.getInstance();
						InputStream is = new ByteArrayInputStream(content.getBytes(StandardCharsets.UTF_8));
						worker.parseXHtml(writer, document, is, Charset.forName("UTF-8"));
						document.newPage();
						*/
						htmlstring= ""+htmlstring+content.toString()+"<br clear=\"all\" style=\"page-break-before:always\" />";
						
					}
				
				}else{
					/* PER STAMPA PDF
					XMLWorkerHelper worker = XMLWorkerHelper.getInstance();
					InputStream is = new ByteArrayInputStream(contentNoDel.getBytes(StandardCharsets.UTF_8));
					worker.parseXHtml(writer, document, is, Charset.forName("UTF-8"));
					*/
					htmlstring= ""+htmlstring+contentNoDel.toString();	
				}
				/* PER STAMPA PDF
				document.close();
				resp.setContentType("application/pdf");
				resp.addProperty(HttpHeaders.CACHE_CONTROL, "max-age=3600, must-revalidate");
				resp.addProperty(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename= Licenza per la gara "+match.getCode()+".pdf;");
				OutputStream out = resp.getPortletOutputStream();
				baos.writeTo(out);
				out.flush();
				out.close();
				*/
				String pgBreak="<br clear=\"all\" style=\"page-break-before:always\" />";
				htmlstring=removeEnd(htmlstring,pgBreak);
				htmlstring=htmlstring+"</html>";
				String docname="Licenza per la gara "+match.getCode()+".doc";
				String contextPath = getPortletContext().getRealPath(File.separator);
				String namefile=contextPath+docname;
				BufferedWriter bw = null;
				FileWriter fw = null;
				fw = new FileWriter(namefile);
				bw = new BufferedWriter(fw);
				bw.write(htmlstring);
				bw.close();
				resp.setContentType("msword/doc");
				resp.addProperty(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename="+docname);
				FileInputStream fileInputStream = new FileInputStream(namefile);
				OutputStream responseOutputStream = resp.getPortletOutputStream();
				int bytes;
				while ((bytes = fileInputStream.read()) != -1) {
					responseOutputStream.write(bytes);
					
				}
				fileInputStream.close();
				 				
			
			}catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}
		
	}
	
	
	public void convocations(
			List<Long> convocations, long esfMatchId, boolean preView, ActionRequest req, ActionResponse resp)
					throws MailEngineException, SystemException, PortalException{
		//da capire se vï¿½ bene
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
					 " che si terrï¿½ in " + matchPlace + ".\n"+
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
				
				//System.out.println("Valori esfNationalDelegations: "+esfNationalDelegations.toString());
				
				int i = 0;
				long userId = ParamUtil.getLong(request, "userId");
				long companyId = ParamUtil.getLong(request, "companyId");
				long groupId = ParamUtil.getLong(request, "groupId");
				
				User user = UserLocalServiceUtil.getUser(userId);
				
				for (ESFNationalDelegation e : esfNationalDelegations) {
					
					long esfUserId = ParamUtil.getLong(request, "ESFShooterId" + i, -2);
					_log.debug("esfUserId="+esfUserId);
					
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
					long sportTypeid = ParamUtil.getLong(request,"sportTypeid"+i,0);
					String userNationality = ParamUtil.getString (request,"userNationality"+i,"");
					ESFNationalMatchResult esfNationalMatchResult =
						ESFNationalMatchResultLocalServiceUtil.
							getESFNationalMatchResultByESFMatchId_ESFUserId_SportTypeId(esfMatchId,e.getEsfUserId(), sportTypeid);
					long esfNationalMatchResultsId =
						CounterLocalServiceUtil.increment(ESFNationalMatchResult.class.getName());

					if (Validator.isNotNull(esfNationalMatchResult)) {
						System.out.println("C e");
						esfNationalMatchResultsId =
							esfNationalMatchResult.getEsfNationalMatchResultId();
					}

					if (!Validator.isNotNull(esfNationalMatchResult)) {
						System.out.println(" Non C e");
						esfNationalMatchResult = new ESFNationalMatchResultImpl();
						esfNationalMatchResult.setPrimaryKey(esfNationalMatchResultsId);
					}
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
					esfNationalMatchResult.setEsfSportTypeId(sportTypeid);
					esfNationalMatchResult.setExternalName(StringPool.BLANK);
					esfNationalMatchResult.setUserNationality(userNationality);
					ESFNationalMatchResultLocalServiceUtil.updateESFNationalMatchResult(esfNationalMatchResult);
					i++;
					System.out.println("Valore i:"+i);
				}
				
				String externalIdsParam = ParamUtil.getString(request, "externalIds");
				String[] externalIds = StringUtil.split(externalIdsParam);
				
				System.out.println("Valore externalsId: "+externalIdsParam);
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
					long esfSportTypeid= ParamUtil.getLong(request, "sportTypeid" + suffix + externalId, -1);
					String userNationality= ParamUtil.getString(request, "userNationality" + suffix + externalId, "");
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
					esfNationalMatchResult.setEsfSportTypeId(esfSportTypeid);
					esfNationalMatchResult.setUserNationality(userNationality);
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
		actionResponse.setRenderParameter("esfDepartureId", ParamUtil.getString(actionRequest,"esfDepartureId"));
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
			
			ESFMatchType eSFMatchType;
			
			if (esfMatchTypeId > 0) {

				eSFMatchType = ESFMatchTypeLocalServiceUtil.updateEsfMatchType(
					esfMatchTypeId, name, isCategoryQualification, isNational,
					 serviceContext);

			}
			else {

				eSFMatchType = ESFMatchTypeLocalServiceUtil.addEsfMatchType(
					name, isCategoryQualification, isNational,
					serviceContext);
			}
			
			response.setRenderParameter("mvcPath", templatePath+"new_edit_esfMatch.jsp");
			response.setRenderParameter("esfMatchId",String.valueOf(esfMatchId) );
			response.setRenderParameter("esfMatchTypeId",String.valueOf(eSFMatchType.getEsfMatchTypeId()) );
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
	
	/*public void addNationalMatchResNew (ActionRequest request, ActionResponse response)
					throws PortalException, SystemException {
		
		long esfMatchId = ParamUtil.getLong(request, "esfMatchId");
		List<ESFNationalDelegation> nds = new ArrayList<ESFNationalDelegation>();
		
		nds = ESFNationalDelegationLocalServiceUtil.getESFNationalDelegationByMatchId_PartecipantTypeId(esfMatchId, ESFKeys.ESFNationalDelegationType.SHOOTER);
		int i = 0;
		for(ESFNationalDelegation del : nds){
			
			long shooterId = ParamUtil.getLong(request, "ESFShooterId" + i);
			long sportTypeId = ParamUtil.getLong(request, "ESFsportTypeId" + i);
			long qualificationId = ParamUtil.getLong(request, "qualification"+ i);
			int position = ParamUtil.getInteger(request, "position"+ i);
			int qualification = ParamUtil.getInteger(request, "qualification"+ i);
			int shootOff = ParamUtil.getInteger(request, "shoot-off"+ i);
			int clayPigeon = ParamUtil.getInteger(request, "clay-pigeon-total"+ i);
			int finalResult = ParamUtil.getInteger(request, "final-result"+ i);
			int shootOffFinal = ParamUtil.getInteger(request, "shoot-off-final"+ i);
			String userNationality = ParamUtil.getString(request, "user-nationality"+ i);
			i++;
			_log.debug("dati in back-end:shooterId="+shooterId+",sportTypeId="+sportTypeId+",qualificationId="+qualificationId+",position="+position+",qualification="+qualification+",");
			_log.debug("dati in back-end2:shootOff="+shootOff+",clayPigeon="+clayPigeon+",finalResult="+finalResult+",shootOffFinal="+shootOffFinal+",userNationality="+userNationality+".");
			_log.debug("i="+i);
			_log.debug("********************************************************************************************************************************************************************");
			
			
		}
		
	}*/
	
	
	public void addNationalMatchResNew(
		ActionRequest request, ActionResponse response) {
		
		int nationalCounter = ParamUtil.getInteger(request, "nationalShooterCounter", 0);
		int externalCounter = ParamUtil.getInteger(request, "externalShooterCounter", 0);
		
		long esfMatchId = ParamUtil.getLong(request, "esfMatchId");
		long userId = ParamUtil.getLong(request, "userId");
		long companyId = ParamUtil.getLong(request, "companyId");
		long groupId = ParamUtil.getLong(request, "groupId");
		Date startDate = null;
		Date endDate = null;
		
		ESFMatch match = new ESFMatchImpl();
		
		String naz_Int = "Int";
		
		try{
			match = ESFMatchLocalServiceUtil.fetchESFMatch(esfMatchId);
			User user = UserLocalServiceUtil.getUser(userId);
			
			startDate = match.getStartDate();
			endDate = match.getEndDate();
			
			for(int i = 0; i < nationalCounter; i++){
				
					
					long esfUserId = ParamUtil.getLong(request, "ESFShooterId" + i, -2);
					
					
					long sportTypeid = ParamUtil.getLong(request,"ESFsportTypeId"+i,0);
					
					long shooterQualificationId = ParamUtil.getInteger(request, "shooterQualification" + i, 0);
					
					int position = ParamUtil.getInteger(request, "position" + i, 0);
					
					int s1 = ParamUtil.getInteger(request, "s1" + i, 0);
					
					int s2 = ParamUtil.getInteger(request, "s2" + i, 0);
					
					int s3 = ParamUtil.getInteger(request, "s3" + i, 0);
					
					int s4 = ParamUtil.getInteger(request, "s4" + i, 0);
					
					int s5 = ParamUtil.getInteger(request, "s5" + i, 0);
					
					int s6 = ParamUtil.getInteger(request, "s6" + i, 0);
					
					int s7 = ParamUtil.getInteger(request, "s7" + i, 0);
					
					int s8 = ParamUtil.getInteger(request, "s8" + i, 0);
					
					int totalS = ParamUtil.getInteger(request, "totalS" + i, 0);
					
					int finalS = ParamUtil.getInteger(request, "finalS" + i, 0);
					
					int finalTotal = ParamUtil.getInteger(request, "finalTotal" + i, 0);
					
					String nationality = ParamUtil.getString(request, "user-nationality" + i,"");
					
					String shooterName = ParamUtil.getString(request, "shooterName" + i,"");
					
					ESFUser esfUser = ESFUserLocalServiceUtil.getESFUser(esfUserId);
					
					ESFResult esfResult = ESFResultLocalServiceUtil.getESFResultByESFMatchId_ESFUserId_SportTypeId_Sigle(esfMatchId,esfUserId, sportTypeid);
					
					if(Validator.isNull(esfResult)){
						esfResult = new ESFResultImpl();
						long esfResultsId = CounterLocalServiceUtil.increment(ESFResult.class.getName());
						esfResult.setPrimaryKey(esfResultsId);
					}
					
					esfResult.setCompanyId(companyId);
					esfResult.setCreateDate(new Date());
					esfResult.setEsfMatchId(esfMatchId);
					esfResult.setGroupId(groupId);
					esfResult.setModifiedDate(new Date());
					esfResult.setUserId(user.getUserId());
					esfResult.setUserName(user.getFullName());
					esfResult.setShooterName(shooterName);
					esfResult.setEsfUserId(esfUserId);
					esfResult.setPosition(position);
					esfResult.setResultS1(s1);
					esfResult.setResultS2(s2);
					esfResult.setResultS3(s3);
					esfResult.setResultS4(s4);
					esfResult.setResultS5(s5);
					esfResult.setResultS6(s6);
					esfResult.setResultS7(s7);
					esfResult.setResultS8(s8);
					esfResult.setTotalS(totalS);
					esfResult.setFinalS(finalS);
					esfResult.setFinalTotal(finalTotal);
					esfResult.setEsfMatchTypeId(sportTypeid);
					esfResult.setShooterQualification(shooterQualificationId);
					esfResult.setNaz_int(naz_Int);
					esfResult.setNationCode(nationality);
					esfResult.setStartdDate(startDate);
					esfResult.setEndDate(endDate);
					
					ESFResultLocalServiceUtil.updateESFResult(esfResult);
			}
			if(externalCounter != 0){
				
				for(int externalId = nationalCounter; externalId < (nationalCounter + externalCounter); externalId++){
	
					String suffix = "_ext_";

					//long esfUserId = ParamUtil.getLong(request, "ESFShooterId" + suffix + externalId);
					
					long sportTypeid = ParamUtil.getLong(request,"sportTypeName" + suffix + externalId);
					
					long shooterQualificationId = ParamUtil.getInteger(request, "shooterQualification" + suffix + externalId);
					
					int position = ParamUtil.getInteger(request, "position" + suffix + externalId);
					
					int s1 = ParamUtil.getInteger(request, "s1" + suffix + externalId);
					
					int s2 = ParamUtil.getInteger(request, "s2" + suffix + externalId);
					
					int s3 = ParamUtil.getInteger(request, "s3" + suffix + externalId);
					
					int s4 = ParamUtil.getInteger(request, "s4" + suffix + externalId);
					
					int s5 = ParamUtil.getInteger(request, "s5" + suffix + externalId);
					
					int s6 = ParamUtil.getInteger(request, "s6" + suffix + externalId);
					
					int s7 = ParamUtil.getInteger(request, "s7" + suffix + externalId);
					
					int s8 = ParamUtil.getInteger(request, "s8" + suffix + externalId);
					
					int totalS = ParamUtil.getInteger(request, "totalS" + suffix + externalId);
					
					int finalS = ParamUtil.getInteger(request, "finalS" + suffix + externalId);
					
					int finalTotal = ParamUtil.getInteger(request, "finalTotal" + suffix + externalId);
					
					String nationality = ParamUtil.getString(request, "shooterNation" + suffix + externalId);
					
					String shooterName = ParamUtil.getString(request, "shooterName" + suffix + externalId);
					
					long esfNationalMatchResultId = ParamUtil.getLong(request, "esfNationalMatchResultId"+ suffix + externalId);
					
					ESFResult esfResultExt;
					try {
						esfResultExt = ESFResultLocalServiceUtil.getESFResult(esfNationalMatchResultId);
					}
					catch (Exception e) {
						esfResultExt = new ESFResultImpl();
						long esfNationalMatchResultsId = CounterLocalServiceUtil.increment(ESFResult.class.getName());
						esfResultExt.setPrimaryKey(esfNationalMatchResultsId);
					}
					
					esfResultExt.setCompanyId(companyId);
					esfResultExt.setCreateDate(new Date());
					esfResultExt.setEsfMatchId(esfMatchId);
					esfResultExt.setEsfUserId(-1);
					esfResultExt.setGroupId(groupId);
					esfResultExt.setModifiedDate(new Date());
					esfResultExt.setUserId(user.getUserId());
					esfResultExt.setUserName(user.getFullName());
					esfResultExt.setShooterName(shooterName);
					esfResultExt.setPosition(position);
					esfResultExt.setResultS1(s1);
					esfResultExt.setResultS2(s2);
					esfResultExt.setResultS3(s3);
					esfResultExt.setResultS4(s4);
					esfResultExt.setResultS5(s5);
					esfResultExt.setResultS6(s6);
					esfResultExt.setResultS7(s7);
					esfResultExt.setResultS8(s8);
					esfResultExt.setTotalS(totalS);
					esfResultExt.setFinalS(finalS);
					esfResultExt.setFinalTotal(finalTotal);
					esfResultExt.setEsfMatchTypeId(sportTypeid);
					esfResultExt.setShooterQualification(shooterQualificationId);
					esfResultExt.setNaz_int(naz_Int);
					esfResultExt.setNationCode(nationality);
					esfResultExt.setStartdDate(startDate);
					esfResultExt.setEndDate(endDate);
					
					ESFResultLocalServiceUtil.updateESFResult(esfResultExt);
				}
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		response.setRenderParameter( "mvcPath", "/html/esfnationalmatch/addResult.jsp");
		response.setRenderParameter( "esfMatchId", String.valueOf(esfMatchId));
	}
	
/*	public void addEventMatchRes(
		ActionRequest request, ActionResponse response) {
	
		int nationalCounter = ParamUtil.getInteger(request, "nationalShooterCounter", 0);
		int externalCounter = ParamUtil.getInteger(request, "externalShooterCounter", 0);
		
		
		if(0 < externalCounter ){
			externalCounter = externalCounter -1;
		}
		
		long esfMatchId = ParamUtil.getLong(request, "esfMatchId");
		long userId = ParamUtil.getLong(request, "userId");
		long companyId = ParamUtil.getLong(request, "companyId");
		long groupId = ParamUtil.getLong(request, "groupId");
		
		try{
			
			User user = UserLocalServiceUtil.getUser(userId);
			
			
			for(int i = 0; i < nationalCounter; i++){
					long esfUserId = ParamUtil.getLong(request, "ESFShooterId" + i, -2);
					
					ESFUser esfUser = ESFUserLocalServiceUtil.getESFUser(esfUserId);
					
					long shooterQualification = ParamUtil.getInteger(request, "shooterQualification" + i, 0);
					int position =
						ParamUtil.getInteger(request, "position" + i, 0);
					int qualification =
						ParamUtil.getInteger(request, "qualification" + i, 0);
					int shootOff =
						ParamUtil.getInteger(request, "shoot-off" + i, 0);
					int clayPigeonTotal =
							ParamUtil.getInteger(request, "clay-pigeon-total" + i, 0);
					int finalResult =
						ParamUtil.getInteger(request, "final-result" + i, 0);
					int shootOffFinal =
						ParamUtil.getInteger(request, "shoot-off-final" + i, 0);
					long sportTypeid = ParamUtil.getLong(request,"shooterSportType"+i,0);
					String userNationality = ParamUtil.getString (request,"user-nationality"+i,"");
					
					ESFEventMatchResult esfNationalMatchResult =
									ESFEventMatchResultLocalServiceUtil.
								getESFEventMatchResultByESFMatchId_ESFUserId_SportTypeId(esfMatchId,esfUserId, sportTypeid);
					
					if(Validator.isNull(esfNationalMatchResult)){
						esfNationalMatchResult = new ESFEventMatchResultImpl();
						long esfNationalMatchResultsId = CounterLocalServiceUtil.increment(ESFEventMatchResult.class.getName());
						esfNationalMatchResult.setPrimaryKey(esfNationalMatchResultsId);
					}
					
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
					esfNationalMatchResult.setEsfSportTypeId(sportTypeid);
					esfNationalMatchResult.setExternalName(StringPool.BLANK);
					esfNationalMatchResult.setUserNationality(userNationality);
					esfNationalMatchResult.setEsfUserQualification(shooterQualification);
					
					ESFEventMatchResultLocalServiceUtil.updateESFEventMatchResult(esfNationalMatchResult);
			}
			if(externalCounter != 0 && 0 < externalCounter ){
				
					for(int externalId = nationalCounter; externalId < (nationalCounter + externalCounter); externalId++){
						String suffix = "_ext_";
						String externalName = ParamUtil.getString(request, "shooterName" + suffix + externalId);
						
					if(!"".equalsIgnoreCase(externalName)){
						
						int position = ParamUtil.getInteger(request, "position" + suffix + externalId);
						long shooterQualification= ParamUtil.getInteger(request, "shooterQualification" + suffix + externalId);
						int shootOff = ParamUtil.getInteger(request, "shoot-off" + suffix + externalId);
						int clayPigeonTotal = ParamUtil.getInteger(request, "clay-pigeon-total" + suffix + externalId);
						int finalResult = ParamUtil.getInteger(request, "final-result" + suffix + externalId);
						int shootOffFinal = ParamUtil.getInteger(request, "shoot-off-final" + suffix + externalId);
						long esfNationalMatchResultId = ParamUtil.getLong(request, "esfNationalMatchResultId" + suffix + externalId, -1);
						long esfSportTypeid= ParamUtil.getLong(request, "sportTypeName" + suffix + externalId, -1);
						int qualification = ParamUtil.getInteger(request, "qualification" + suffix + externalId);
						String userNationality= ParamUtil.getString(request, "user-nationality" + suffix + externalId, "");
						
						ESFEventMatchResult esfNationalMatchResult;
						try {
							esfNationalMatchResult = ESFEventMatchResultLocalServiceUtil.getESFEventMatchResult(esfNationalMatchResultId);
						}
						catch (Exception e) {
							esfNationalMatchResult = new ESFEventMatchResultImpl();
							long esfNationalMatchResultsId = CounterLocalServiceUtil.increment(ESFEventMatchResult.class.getName());
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
						esfNationalMatchResult.setEsfSportTypeId(esfSportTypeid);
						esfNationalMatchResult.setUserNationality(userNationality);
						esfNationalMatchResult.setEsfUserQualification(shooterQualification);
						ESFEventMatchResultLocalServiceUtil.updateESFEventMatchResult(esfNationalMatchResult);
					}
				}
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	
	}
	
	*/
	
	public void addNotOlimpicMatchRes(
		ActionRequest request, ActionResponse response) {
	
		int nationalCounter = ParamUtil.getInteger(request, "nationalShooterCounter", 0);
		int externalCounter = ParamUtil.getInteger(request, "externalShooterCounter", 0);
		
		
		if(0 < externalCounter ){
			externalCounter = externalCounter -1;
		}
		
		long esfMatchId = ParamUtil.getLong(request, "esfMatchId");
		long userId = ParamUtil.getLong(request, "userId");
		long companyId = ParamUtil.getLong(request, "companyId");
		long groupId = ParamUtil.getLong(request, "groupId");
		
		try{
			
			User user = UserLocalServiceUtil.getUser(userId);
			
			
			for(int i = 0; i < nationalCounter; i++){
					long esfUserId = ParamUtil.getLong(request, "ESFShooterId" + i, -2);
					
					ESFUser esfUser = ESFUserLocalServiceUtil.getESFUser(esfUserId);
					
					long shooterQualification = ParamUtil.getInteger(request, "shooterQualification" + i, 0);
					int position =
						ParamUtil.getInteger(request, "position" + i, 0);
					int qualification =
						ParamUtil.getInteger(request, "qualification" + i, 0);
					int shootOff =
						ParamUtil.getInteger(request, "shoot-off" + i, 0);
					int clayPigeonTotal =
							ParamUtil.getInteger(request, "clay-pigeon-total" + i, 0);
					int finalResult =
						ParamUtil.getInteger(request, "final-result" + i, 0);
					int shootOffFinal =
						ParamUtil.getInteger(request, "shoot-off-final" + i, 0);
					long sportTypeid = ParamUtil.getLong(request,"shooterSportType"+i,0);
					
					String userNationality = ParamUtil.getString (request,"user-nationality"+i,"");
					
					ESFNationalMatchResult esfNationalMatchResult =
									ESFNationalMatchResultLocalServiceUtil.
								getESFNationalMatchResultByESFMatchId_ESFUserId_SportTypeId(esfMatchId,esfUserId, sportTypeid);
					
					if(Validator.isNull(esfNationalMatchResult)){
						esfNationalMatchResult = new ESFNationalMatchResultImpl();
						//long esfNationalMatchResultsId = CounterLocalServiceUtil.increment(ESFNotOlimpicMatchResult.class.getName());
						//esfNationalMatchResult.setPrimaryKey(esfNationalMatchResultsId);
					}
					
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
					esfNationalMatchResult.setEsfSportTypeId(sportTypeid);
					esfNationalMatchResult.setExternalName(StringPool.BLANK);
					esfNationalMatchResult.setUserNationality(userNationality);
					esfNationalMatchResult.setEsfUserQualification(shooterQualification);
					
					ESFNationalMatchResultLocalServiceUtil.updateESFNationalMatchResult(esfNationalMatchResult);
			}
			if(externalCounter != 0 && 0 < externalCounter ){
				
					for(int externalId = nationalCounter; externalId < (nationalCounter + externalCounter); externalId++){
						String suffix = "_ext_";
						String externalName = ParamUtil.getString(request, "shooterName" + suffix + externalId);
						
					if(!"".equalsIgnoreCase(externalName)){
						
						int position = ParamUtil.getInteger(request, "position" + suffix + externalId);
						long shooterQualification= ParamUtil.getInteger(request, "shooterQualification" + suffix + externalId);
						int shootOff = ParamUtil.getInteger(request, "shoot-off" + suffix + externalId);
						int clayPigeonTotal = ParamUtil.getInteger(request, "clay-pigeon-total" + suffix + externalId);
						int finalResult = ParamUtil.getInteger(request, "final-result" + suffix + externalId);
						int shootOffFinal = ParamUtil.getInteger(request, "shoot-off-final" + suffix + externalId);
						long esfNationalMatchResultId = ParamUtil.getLong(request, "esfNationalMatchResultId" + suffix + externalId, -1);
						long esfSportTypeid= ParamUtil.getLong(request, "sportTypeName" + suffix + externalId, -1);
						int qualification = ParamUtil.getInteger(request, "qualification" + suffix + externalId);
						String userNationality= ParamUtil.getString(request, "user-nationality" + suffix + externalId, "");
						
						ESFNationalMatchResult esfNationalMatchResult;
						try {
							esfNationalMatchResult =ESFNationalMatchResultLocalServiceUtil.getESFNationalMatchResult(esfNationalMatchResultId);
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
						esfNationalMatchResult.setEsfSportTypeId(esfSportTypeid);
						esfNationalMatchResult.setUserNationality(userNationality);
						esfNationalMatchResult.setEsfUserQualification(shooterQualification);
						ESFNationalMatchResultLocalServiceUtil.updateESFNationalMatchResult(esfNationalMatchResult);
					}
				}
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	
	}
	
	public void addNationalTeamResNew(
		ActionRequest request, ActionResponse response) {
		
		long esfMatchId = ParamUtil.getLong(request, "esfMatchId");
		int numTeam = ParamUtil.getInteger(request, "numTeam", 0);
		long companyId =  ParamUtil.getLong(request, "companyId");
		long groupId =  ParamUtil.getLong(request, "groupId");
		long userId =  ParamUtil.getLong(request, "userId");
		
		User user ;;
		ESFUser shooter = new ESFUserImpl();
		ESFMatch match = new ESFMatchImpl();
		try {
			user = UserLocalServiceUtil.getUser(userId);
			match = ESFMatchLocalServiceUtil.fetchESFMatch(esfMatchId);
			
			for(int i = 0; i < numTeam ; i++){
				
				String shooterName = "";
				String nationCode = "ITA";
				String naz_int = "Int";
				String teamCategory = "";
				boolean selected = ParamUtil.getBoolean(request, "selected"+i);
				long shooterQualificationId = ParamUtil.getLong(request, "shooterQualificationId"+i);
				long shooterSportTypeId = ParamUtil.getLong(request, "shooterSportTypeIdId"+i);
				long shooterId = ParamUtil.getLong(request, "shooterId"+i);
				int position = ParamUtil.getInteger(request, "position"+shooterQualificationId+shooterSportTypeId, 0);
				
				shooter = ESFUserLocalServiceUtil.fetchESFUser(shooterId);
				
				if(Validator.isNotNull(shooter)){
					shooterName = shooter.getFirstName() + " " + shooter.getLastName();
				}
				if(0 < shooterQualificationId &&
						Validator.isNotNull(ESFShooterQualificationLocalServiceUtil.fetchESFShooterQualification(shooterQualificationId)) &&
							Validator.isNotNull(ESFShooterQualificationLocalServiceUtil.fetchESFShooterQualification(shooterQualificationId).getName())){
					teamCategory = ESFShooterQualificationLocalServiceUtil.fetchESFShooterQualification(shooterQualificationId).getName();
				}
				
				/////////////verifica se sono presnti vecchi risultati Team e li cancello
				
				ESFResult oldResult = new ESFResultImpl();
				
				oldResult = ESFResultLocalServiceUtil.
								getESFResultByESFMatchId_ESFUserId_SportTypeId_QualificationId_Team(esfMatchId,shooterId,shooterSportTypeId,shooterQualificationId);
				
				if(Validator.isNotNull(oldResult)){
					ESFResultLocalServiceUtil.deleteESFResult(oldResult);
					
				}
				
				///////creo i risultati team
				ESFResult result = new ESFResultImpl();
				//long esfNationalMatchResultsId = CounterLocalServiceUtil.increment(ESFNotOlimpicMatchResult.class.getName());
				//result.setPrimaryKey(esfNationalMatchResultsId);
				
				if(selected){
					
					result.setCompanyId(companyId);
					result.setCreateDate(new Date());
					result.setEsfMatchId(esfMatchId);
					result.setEsfUserId(shooterId);
					result.setGroupId(groupId);
					result.setModifiedDate(new Date());
					result.setUserId(user.getUserId());
					result.setUserName(user.getFullName());
					result.setPosition(position);
					result.setShooterName(shooterName);
					result.setNationCode(nationCode);
					result.setNaz_int(naz_int);
					result.setResultClassTeam(position);
					result.setEsfMatchTypeId(shooterSportTypeId);
					result.setShooterQualification(shooterQualificationId);
					result.setTeamCategory(teamCategory);
					
					if(Validator.isNotNull(match)){
						result.setStartdDate(match.getStartDate());
						result.setEndDate(match.getEndDate());
					}
					
					ESFResultLocalServiceUtil.addESFResult(result);
				}
				
				
				
				
				
				
			}
		}
		catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.setRenderParameter( "mvcPath", "/html/esfnationalmatch/addResult.jsp");
		response.setRenderParameter( "esfMatchId", String.valueOf(esfMatchId));
		
	}
	
	private static void insertCell(PdfPTable table, Phrase phrase, int colspan){
		   
		  //create a new cell with the specified Text and Font
		  PdfPCell cell = new PdfPCell(phrase);
		  //set the cell alignment
		  cell.setHorizontalAlignment(com.lowagie.text.Element.ALIGN_RIGHT);
	
		   cell.setColspan(colspan);
		   cell.setBorder(0);
		   cell.setMinimumHeight(12f);
		   table.addCell("");
		
		  //add the call to the table
		  table.addCell(cell);

	}
	public static boolean isEmpty(String str) {
	      return str == null || str.length() == 0;
	  }
	public static String removeEnd(String str, String remove) {
	      if (isEmpty(str) || isEmpty(remove)) {
	          return str;
	      }
	      if (str.endsWith(remove)) {
	          return str.substring(0, str.length() - remove.length());
	      }
	      return str;
	  }
	
}