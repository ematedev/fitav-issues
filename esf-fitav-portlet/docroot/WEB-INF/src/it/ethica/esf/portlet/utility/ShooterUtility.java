
package it.ethica.esf.portlet.utility;

import it.ethica.esf.model.ESFAddress;
import it.ethica.esf.model.ESFCard;
import it.ethica.esf.model.ESFCatridge;
import it.ethica.esf.model.ESFDocument;
import it.ethica.esf.model.ESFEntityState;
import it.ethica.esf.model.ESFGun;
import it.ethica.esf.model.ESFOrganization;
import it.ethica.esf.model.ESFPhone;
import it.ethica.esf.model.ESFUser;
import it.ethica.esf.model.impl.ESFCardImpl;
import it.ethica.esf.model.impl.ESFDocumentImpl;
import it.ethica.esf.model.impl.ESFEntityStateImpl;
import it.ethica.esf.model.impl.ESFOrganizationImpl;
import it.ethica.esf.portlet.ESFMatchTypePortlet;
import it.ethica.esf.portlet.ESFUserAdminPortlet;
import it.ethica.esf.service.ESFAddressLocalServiceUtil;
import it.ethica.esf.service.ESFCardLocalServiceUtil;
import it.ethica.esf.service.ESFCatridgeLocalServiceUtil;
import it.ethica.esf.service.ESFDocumentLocalServiceUtil;
import it.ethica.esf.service.ESFEntityStateLocalServiceUtil;
import it.ethica.esf.service.ESFGunKindLocalServiceUtil;
import it.ethica.esf.service.ESFGunLocalServiceUtil;
import it.ethica.esf.service.ESFOrganizationLocalServiceUtil;
import it.ethica.esf.service.ESFUserLocalServiceUtil;
import it.ethica.esf.util.ESFJsonUtil;
import it.ethica.esf.util.ESFKeys;
import it.ethica.esf.util.ESFServiceUtil;
import it.ethica.esf.util.ManageDate;
import it.ethica.esf.util.ManageOperationsField;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.ContactBirthdayException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Phone;
import com.liferay.portal.model.User;
import com.liferay.portal.service.PhoneLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.liferay.util.portlet.PortletProps;

public class ShooterUtility extends MVCPortlet {

	@Override
	public void render(RenderRequest request, RenderResponse response)
		throws IOException, PortletException {


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
				PortletProps.get("auto.deploy.tomcat.dest.dir") + File.separator +
					"match_document" + File.separator + esfMatchId;
			String documentPath =
				File.separator + "match_document" + File.separator +
					esfMatchId + File.separator;
			File dir = new File(path);
			String files[] = dir.exists() ? dir.list() : null;
			if (files != null && files.length > 0) {
				for (int i = 0; i < files.length; i++) {
					files[i] = files[i];
					System.out.println(" files[i] " + files[i]);
				}

			}
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
			}
			else {
				
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
		}

		super.render(request, response);
	}

	public void editESFGun(
		ActionRequest request, ActionResponse response, String dir)

		throws PortalException, SystemException {

		ServiceContext serviceContext =
			ServiceContextFactory.getInstance(ESFGun.class.getName(), request);

		// long organizationId = ParamUtil.getLong(request, "organizationId");
		long esfMatchId = ParamUtil.getLong(request, "esfMatchId");
		long esfGunId = ParamUtil.getLong(request, "esfGunId");
		String code = ParamUtil.getString(request, "code");
		long esfGunKindId = ParamUtil.getLong(request, "esfGunKindId");

		long esfOrganizationId =
			ParamUtil.getLong(request, "esfOrganizationId");
		long esfUserId = ParamUtil.getLong(request, "esfUserId");
		String registrationNumber =
			ParamUtil.getString(request, "registrationNumber");
		long catridgeCaliber = ParamUtil.getLong(request, "catridgeCaliber");
		boolean isFavoriteGun = ParamUtil.getBoolean(request, "isFavoriteGun",false);
		long esfGunTypeId = ParamUtil.getLong(request, "esfGunTypeId");
		//Boolean checkval=ParamUtil.getBoolean(request, "new-brand");
		String note=ParamUtil.getString(request, "note");
		String name=ParamUtil.getString(request, "name");
	int typology=ParamUtil.getInteger(request, "typology");
		String measures=ParamUtil.getString(request, "measures");


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
		
		response.setRenderParameter("mvcPath", "/html/" + dir +
			"/edit_esfShooter.jsp");
		
		response.setRenderParameter("esfUserId", String.valueOf(esfUserId));
		response.setRenderParameter("esfMatchId", String.valueOf(esfMatchId));
		response.setRenderParameter("op", "updAddr");

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

	public void editESFdocument(
		ActionRequest request, ActionResponse response, String dir)
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
		
		long userId =  ParamUtil.getLong(request, "esfUserId");
		
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
			response.setRenderParameter("mvcPath", "/html/" + dir +
							"/edit_esfShooter.jsp");
			response.setRenderParameter("esfUserId", String.valueOf(esfUserId));
			response.setRenderParameter(
				"esfMatchId", String.valueOf(esfMatchId));
			response.setRenderParameter("op", "updAddr");
		}
	}

	public void deleteESFdocument(
		ActionRequest request, ActionResponse response, String dir)
		throws PortalException, SystemException, ParseException {
		
		long esfDocumentId = ParamUtil.getLong(request, "esfDocumentId");
		String startPath = PropsUtil.get("auto.deploy.tomcat.dest.dir") ;
		String filePath = "";
		ESFDocument docuemnt = new ESFDocumentImpl();
		long esfMatchId = ParamUtil.getLong(request, "esfMatchId");
		long esfUserId = ParamUtil.getLong(request, "esfUserId");
		long organizationId = ParamUtil.getLong(request, "organizationId");
		
		try {
			docuemnt = ESFDocumentLocalServiceUtil.fetchESFDocument(esfDocumentId);
			filePath = docuemnt.getPath();
			File toBeDeletedFile = new File(startPath+filePath);
			toBeDeletedFile.delete();
			
			docuemnt = ESFDocumentLocalServiceUtil.deleteESFDocument(esfDocumentId);
			SessionMessages.add(request, "esfDocumentDeleted");
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			request.setAttribute("esfMatchId", esfMatchId);
			request.setAttribute("esfUserId", esfUserId);
			request.setAttribute("op", "updAddr");
			request.setAttribute("organizationId", organizationId);
			
			if(0<esfMatchId){
				response.setRenderParameter("mvcPath", "/html/esfnationalmatch/tabs/edit_esfShooter.jsp");
			}else{
				response.setRenderParameter("mvcPath", "/html/" + dir +
								"/edit_esfShooter.jsp");
			}
			
			response.setRenderParameter("esfUserId", String.valueOf(esfUserId));
			response.setRenderParameter(
				"esfMatchId", String.valueOf(esfMatchId));
			response.setRenderParameter("op", "updAddr");
		}
		
		
	}
	
	
	public void updateESFShooter(
		ActionRequest actionRequest, ActionResponse actionResponse, String dir)
		throws PortalException, SystemException, ParseException {

		ServiceContext serviceContext =
			ServiceContextFactory.getInstance(
				ESFUser.class.getName(), actionRequest);

		long esfUserId = ParamUtil.getLong(actionRequest, "esfUserId");
		
		ESFUser shooter = ESFUserLocalServiceUtil.fetchESFUser(esfUserId);
		
		
		boolean saveAndContinue = ParamUtil.getBoolean(actionRequest, "saveAndContinue");
		String firstName = ParamUtil.getString(actionRequest, "firstName");
		String lastName = ParamUtil.getString(actionRequest, "lastName");
		String middleName = ParamUtil.getString(actionRequest, "middleName");
		String userEmail = ParamUtil.getString(actionRequest, "userEmail");
		String fiscalCode = ParamUtil.getString(actionRequest, "fiscalCode");
		long esfMatchId = ParamUtil.getLong(actionRequest, "esfMatchId");
		boolean validateCF = ParamUtil.getBoolean(actionRequest, "validateCF");
		long oldShooterCode = ParamUtil.getLong(actionRequest,
			"oldShooterCode",-1);
		
		if(0 > oldShooterCode){
			if(Validator.isNotNull(shooter) && 
							Validator.isNotNull(shooter.getCodeUser())){
				oldShooterCode = shooter.getCodeUser();
			}
		}
		
		
		String dateFormat1= "dd/MM/yyyy";
		
		String dOD = ParamUtil.getString(actionRequest, "dateOfDeathString");
		Date dateOfDeath = null;
		
		Date privacy1Date = null;
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

		try {
			dateOfDeath = ManageDate.StringToDate(dOD);

		}
		catch (ParseException e1) {
			SessionErrors.add(actionRequest, "shooter-error-update-deathDate");
			actionResponse.setRenderParameter("esfUserId", String.valueOf(esfUserId) );
			actionResponse.setRenderParameter("mvcPath","/html/esfshooter/edit_esfShooter.jsp");
			e1.printStackTrace();
			throw new PortalException(e1);
		}
		
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
		_log.info("State da request: "+esfEntityStateId);
		_log.info("variabile disabled: "+disable);
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
				privacy1Date = esfUserToUpdate.getDatePrivacy1();
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
						addresses, phones, dateOfDeath, privacy1, privacy2, privacy3,
						privacy1Date, privacy2Date, privacy3Date, validateCF,
						oldShooterCode,serviceContext);
				
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
			e.printStackTrace();
		}
		finally {
			actionRequest.setAttribute("esfMatchId", esfMatchId);
			actionRequest.setAttribute("esfUserId", esfUserId);
			actionRequest.setAttribute("op", "updAddr");
			actionResponse.setRenderParameter("myParam", "Generale");
			
			if(saveAndContinue){
				actionResponse.setRenderParameter("mvcPath", "/html/" + dir +
						"/edit_esfShooter.jsp");
				actionResponse.setRenderParameter("esfUserId", String.valueOf(esfUserId));
			}else{
				actionResponse.setRenderParameter("mvcPath", "/html/" + dir +
						"/view.jsp");
				actionResponse.setRenderParameter("esfUserId", String.valueOf(esfUserId));
			}
			
		}
	}

	@Override
	public void serveResource(
		ResourceRequest resourceRequest, ResourceResponse resourceResponse)
		throws IOException, PortletException {
		
		try {
		HttpServletRequest httpReq =
			PortalUtil.getHttpServletRequest(resourceRequest);
		httpReq = PortalUtil.getOriginalServletRequest(httpReq);

		
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
			long esfGunTypeId =StringToLong(PortalUtil.getOriginalServletRequest(httpReq).getParameter(
							"esfGunTypeId")); 

			String resourceID = resourceRequest.getResourceID();
			
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
			}
			else if (Validator.isNotNull(resourceID) && resourceID.equals("esfGunTypeId")) {
				esfServiceUtil.serveGunKinds(
					resourceRequest, resourceResponse, param, esfGunTypeId,
					esfUserId);
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

	private long StringToLong(String value) {

		if (value != null && !value.equals(""))
			return Long.parseLong(value);

		else
			return 0;
	}
	
	public void editESFCard(ActionRequest actionRequest, ActionResponse actionResponse,String dir) 
			throws SystemException, PortalException{
		_log.info("entro in editESFCard");
		
		String operation= ParamUtil.getString(actionRequest, "typeOperation");
		String mvcPath  = ParamUtil.getString(actionRequest, "mvcPath");
		long cardUserId = ParamUtil.getLong(actionRequest, "cardUserId",0);
		long esfMatchId = ParamUtil.getLong(actionRequest, "esfMatchId");
		long esfUserId = ParamUtil.getLong(actionRequest, "esfUserId");
		long esfOrganizationId =
			ParamUtil.getLong(actionRequest, "esfOrganizationId");
		Date data = new Date();
		
		long associations =
				ParamUtil.getLong(actionRequest, "associations");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		long newCardId = ParamUtil.getLong(actionRequest,"esfCardId");
		Date newData = ParamUtil.getDate(actionRequest, "startDate", sdf);
		Date now = new Date();
		
		
		ESFCard oldCard = new ESFCardImpl();
		ESFCard newCard = new ESFCardImpl();
		ESFEntityState oldCardEntityState = new ESFEntityStateImpl();
		ESFEntityState newCardEntityState = new ESFEntityStateImpl();
		ESFOrganization oldOrg = new ESFOrganizationImpl();
		ESFOrganization newOrg = new ESFOrganizationImpl();
		
		String oldCardTreepath = "";
		String newCardTreepath = "";
		
		try {
			oldCard = ESFCardLocalServiceUtil.fetchESFCard(cardUserId);
			_log.info("oldCard="+oldCard);
		} catch (Exception e) {
			// TODO: handle exception
			actionRequest.setAttribute("esfMatchId", esfMatchId);
			actionRequest.setAttribute("esfUserId", esfUserId);
			actionRequest.setAttribute("organizationId", esfOrganizationId);
			actionResponse.setRenderParameter("cardUserId",String.valueOf(newCardId));
			actionResponse.setRenderParameter("esfUserId", String.valueOf(esfUserId));
			actionResponse.setRenderParameter("esfMatchId", String.valueOf(esfMatchId));
			actionResponse.setRenderParameter("mvcPath", "/html/" + dir + "/"+mvcPath);
			SessionErrors.add(actionRequest, "esfCard-noFind-reference-error");
			return;
		}
		
		try{
			
			newCard = ESFCardLocalServiceUtil.fetchESFCard(newCardId);
			_log.info("newCard="+newCard);
		} catch (Exception e) {
			// TODO: handle exception
			actionRequest.setAttribute("esfMatchId", esfMatchId);
			actionRequest.setAttribute("esfUserId", esfUserId);
			actionRequest.setAttribute("organizationId", esfOrganizationId);
			actionResponse.setRenderParameter("cardUserId",String.valueOf(newCardId));
			actionResponse.setRenderParameter("esfUserId", String.valueOf(esfUserId));
			actionResponse.setRenderParameter("esfMatchId", String.valueOf(esfMatchId));
			actionResponse.setRenderParameter("mvcPath", "/html/" + dir + "/"+mvcPath);
			SessionErrors.add(actionRequest, "esfCard-noFind-reference-error");
			return;
		}
		
		try{
			long oldOrgId = oldCard.getEsfOrganizationId();
			long newOrgId = newCard.getEsfOrganizationId();
			_log.info("oldOrgId="+oldOrgId);
			_log.info("newOrgId="+newOrgId);
			
			oldOrg = ESFOrganizationLocalServiceUtil.fetchESFOrganization(oldOrgId);
			newOrg = ESFOrganizationLocalServiceUtil.fetchESFOrganization(newOrgId);
			
			oldCardTreepath = oldOrg.getTreePath();
			newCardTreepath = newOrg.getTreePath();
			
			String[] oldCardTreepathSplit = oldCardTreepath.split("/");
			String[] newCardTreepathSplit = newCardTreepath.split("/");
			
			_log.info("oldCardTreepathSplit[2]="+oldCardTreepathSplit[2]);
			_log.info("newCardTreepathSplit[2]="+newCardTreepathSplit[2]);
			
			if(oldCardTreepathSplit[2].equals(newCardTreepathSplit[2]) ){
				_log.info("nel if");
				ESFCardLocalServiceUtil.deleteESFCard(newCard);
				
				
				
				oldCard.setEsfOrganizationId(newOrgId);
				ESFCardLocalServiceUtil.updateESFCard(oldCard);
				
			}else{
				_log.info("in else");
				try {
					
					oldCardEntityState = ESFEntityStateLocalServiceUtil.findESFEntityStateByC_PK("it.ethica.esf.model.ESFCard", cardUserId);
					oldCardEntityState.setEndDate(newData);
					ESFEntityStateLocalServiceUtil.updateESFEntityState(oldCardEntityState);
					_log.info("oldCardEntityState dopo="+oldCardEntityState);
					
				} catch (Exception e) {
					// TODO: handle exception
					actionRequest.setAttribute("esfMatchId", esfMatchId);
					actionRequest.setAttribute("esfUserId", esfUserId);
					actionRequest.setAttribute("organizationId", esfOrganizationId);
					actionResponse.setRenderParameter("cardUserId",String.valueOf(newCardId));
					actionResponse.setRenderParameter("esfUserId", String.valueOf(esfUserId));
					actionResponse.setRenderParameter("esfMatchId", String.valueOf(esfMatchId));
					actionResponse.setRenderParameter("mvcPath", "/html/" + dir + "/"+mvcPath);
					SessionErrors.add(actionRequest, "esfCard-noFind-reference-error");
					return;
				}
				
				ThemeDisplay themeDisplay = 
						(ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
				long groupId = themeDisplay.getLayout().getGroupId();
				long companyId = themeDisplay.getLayout().getCompanyId();
				long userId = themeDisplay.getLayout().getUserId();
				String userName = themeDisplay.getLayout().getUserName();
				
				newCard.setEsfUserId(esfUserId);
				ESFCardLocalServiceUtil.updateESFCard(newCard);
				
				_log.info("newCard dopo="+newCard);
				
				
				newCardEntityState.setEsfEntityStateId(CounterLocalServiceUtil.increment("it.ethica.esf.model.ESFEntityState"));
				newCardEntityState.setClassName("it.ethica.esf.model.ESFCard");
				newCardEntityState.setClassPK(newCard.getEsfCardId());
				newCardEntityState.setEsfStateId(ESFKeys.ESFStateType.ENABLE);
				newCardEntityState.setStartDate(newData);
				newCardEntityState.setEndDate(null);
				newCardEntityState.setCreateDate(now);
				newCardEntityState.setGroupId(groupId);
				newCardEntityState.setCompanyId(companyId);
				newCardEntityState.setUserId(userId);
				newCardEntityState.setUserName(userName);
				ESFEntityStateLocalServiceUtil.updateESFEntityState(newCardEntityState);
				
				_log.info("newCardEntityState dopo="+newCardEntityState);
				
				oldCard.setEsfUserId(0);
				ESFCardLocalServiceUtil.updateESFCard(oldCard);
				
				_log.info("oldCard dopo="+oldCard);
			}
			
			
			
			
			
		
		} catch (Exception e) {
			// TODO: handle exception
			actionRequest.setAttribute("esfMatchId", esfMatchId);
			actionRequest.setAttribute("esfUserId", esfUserId);
			actionRequest.setAttribute("organizationId", esfOrganizationId);
			actionResponse.setRenderParameter("cardUserId",String.valueOf(newCardId));
			actionResponse.setRenderParameter("esfUserId", String.valueOf(esfUserId));
			actionResponse.setRenderParameter("esfMatchId", String.valueOf(esfMatchId));
			actionResponse.setRenderParameter("mvcPath", "/html/" + dir + "/"+mvcPath);
			SessionErrors.add(actionRequest, "esfCard-noFind-reference-error");
			return;
		}
		
		actionRequest.setAttribute("esfMatchId", esfMatchId);
		actionRequest.setAttribute("esfUserId", esfUserId);
		//actionRequest.setAttribute("op", "updAddr");
		actionRequest.setAttribute("organizationId", esfOrganizationId);
		
		actionResponse.setRenderParameter("cardUserId",String.valueOf(newCardId));
		actionResponse.setRenderParameter("esfUserId", String.valueOf(esfUserId));
		actionResponse.setRenderParameter("esfMatchId", String.valueOf(esfMatchId));
		actionResponse.setRenderParameter("mvcPath", "/html/" + dir +
				"/"+mvcPath);
		//actionResponse.setRenderParameter("op", "updAddr");
		
	}
	
	public void newCard(ActionRequest actionRequest, ActionResponse actionResponse,String dir) 
			throws SystemException{
		_log.info("****************in shooterUtility in newcard");
		String mvcPath  = ParamUtil.getString(actionRequest, "mvcPath");
		long esfUserId = ParamUtil.getLong(actionRequest, "esfUserId");
		_log.info("****************in shooterUtility in newcard esfUserId = "+esfUserId);
		long esfOrganizationId =
			ParamUtil.getLong(actionRequest, "esfOrganizationId");
		_log.info("****************in shooterUtility in newcard esfOrganizationId = "+esfOrganizationId);
		Date data = new Date();
		long newCardId = ParamUtil.getLong(actionRequest,"esfCardId");
		_log.info("****************in shooterUtility in newcard newCardId = "+newCardId);
		ESFCard newCard = ESFCardLocalServiceUtil.fetchESFCard(newCardId);
		_log.info("****************in shooterUtility in newcard newCard = "+newCard);
		newCard.setEsfUserId(esfUserId);
		ESFCardLocalServiceUtil.updateESFCard(newCard);
		_log.info("****************in shooterUtility in newcard newCard.userit = "+newCard.getUserId());
		
		actionRequest.setAttribute("esfUserId", esfUserId);
		actionRequest.setAttribute("organizationId", esfOrganizationId);
		actionResponse.setRenderParameter("cardUserId",String.valueOf(newCardId));
		actionResponse.setRenderParameter("esfUserId", String.valueOf(esfUserId));
		actionResponse.setRenderParameter("mvcPath", "/html/" + dir +
				"/"+mvcPath);
	}

	public void editESFCatridge(
		ActionRequest request, ActionResponse response, String dir)
		throws PortalException, SystemException {

		ServiceContext serviceContext =
			ServiceContextFactory.getInstance(ESFGun.class.getName(), request);

		// long organizationId = ParamUtil.getLong(request, "organizationId");
		long esfMatchId = ParamUtil.getLong(request, "esfMatchId");
		long esfCatridgeId = ParamUtil.getLong(request, "esfCatridgeId");
		long esfUserId = ParamUtil.getLong(request, "esfUserId");
		String catridgeModel = ParamUtil.getString(request, "catridgeModel");
		long catridgeCaliber = ParamUtil.getLong(request, "catridgeCaliber");
		long esfGunTypeId = ParamUtil.getLong(request, "esfGunTypeId");
		String note=ParamUtil.getString(request, "note");
		if (esfCatridgeId > 0) {
			ESFCatridge esfCatridge = ESFCatridgeLocalServiceUtil.getESFCatridge(esfCatridgeId);

			
				ESFCatridgeLocalServiceUtil.updateESFCatridge(
					serviceContext.getUserId(), esfCatridgeId, esfGunTypeId,
					 esfUserId,  catridgeModel, catridgeCaliber,note, serviceContext);

		}
		else {
				try{
				ESFCatridgeLocalServiceUtil.addESFCatridge(
					serviceContext.getUserId(), esfGunTypeId,
					 esfUserId, catridgeModel, catridgeCaliber,note, serviceContext);
				} catch (Exception e){
					System.out.println(e.toString());
				}
		}
		request.setAttribute("esfMatchId", esfMatchId);
		request.setAttribute("esfUserId", esfUserId);
		request.setAttribute("op", "updAddr");
		//request.setAttribute("organizationId", esfOrganizationId);
		
		response.setRenderParameter("mvcPath", "/html/" + dir +
			"/edit_esfShooter.jsp");
		
		response.setRenderParameter("esfUserId", String.valueOf(esfUserId));
		response.setRenderParameter("esfMatchId", String.valueOf(esfMatchId));
		response.setRenderParameter("op", "updAddr");

	}
	private static Log _log = LogFactoryUtil.getLog(ESFUserAdminPortlet.class);

}
