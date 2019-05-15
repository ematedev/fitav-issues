
package it.ethica.esf.portlet;

import java.io.IOException;
import java.text.ParseException;
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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import it.ethica.esf.migration.util.ManageDate;
import it.ethica.esf.model.ESFGunKind;
import it.ethica.esf.model.ESFGunType;
import it.ethica.esf.service.ESFGunKindLocalServiceUtil;
import it.ethica.esf.service.ESFGunTypeLocalServiceUtil;
import it.ethica.esf.service.ESFPartecipantInfoLocalServiceUtil;
import it.ethica.esf.util.ESFPartecipantUtil;

/**
 * Portlet implementation class ESFPartecipantInfo
 */
public class ESFPartecipantInfo extends MVCPortlet {
	
	@Override
	public void render(RenderRequest request, RenderResponse response) throws PortletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Almeno qui ci arrivo");
		super.render(request, response);
	}
	
	@Override
	public void serveResource(
		ResourceRequest resourceRequest, ResourceResponse resourceResponse)
		throws IOException, PortletException {
		System.out.println("Sono qui!!");
		HttpServletRequest httpReq =
			PortalUtil.getHttpServletRequest(resourceRequest);
		httpReq = PortalUtil.getOriginalServletRequest(httpReq);

		long esfGunTypeId = ParamUtil.getLong(httpReq, "esfGunTypeId", 0);

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
				System.out.println("Nel for");
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
	}
	
	public void downloadPDF(ActionRequest request, ActionResponse respose){
		long esfPartecipantInfoId = ParamUtil.getLong(request, "esfPartecipantInfoId");
			ESFPartecipantUtil.generatePasses(esfPartecipantInfoId);
	}

	public void editESFPartecipantInfo(
		ActionRequest request, ActionResponse response)
		throws PortalException, SystemException, ParseException {

		ServiceContext serviceContext =
			ServiceContextFactory.getInstance(
				ESFPartecipantInfo.class.getName(), request);
		long companyId = serviceContext.getCompanyId();
		long userId = serviceContext.getUserId();

		User user = UserLocalServiceUtil.getUser(userId);
		String userName = user.getFullName();
		long groupId = user.getGroupId();

		boolean isPortalUser = ParamUtil.getBoolean(request, "isPortalUser");
		long esfPartecipantInfoId =
			ParamUtil.getLong(request, "esfPartecipantInfoId");
		long protocol = 0;

		if (esfPartecipantInfoId == 0 /*&&
			Validator.isNotNull(esfPartecipantInfoId)*/) {
			List<it.ethica.esf.model.ESFPartecipantInfo> e =
				ESFPartecipantInfoLocalServiceUtil.getESFPartecipantInfos(
					0,
					ESFPartecipantInfoLocalServiceUtil.getESFPartecipantInfosCount());
			
			if (Validator.isNotNull(e)) {
				long max = 0;
				for (it.ethica.esf.model.ESFPartecipantInfo p : e) {
					if (p.getProtocol() > max) {
						max = p.getProtocol();
					}
				}
				protocol = max + 1;
			}
			else {
				protocol = 1;
			}
		}
		
		long esfUserId = ParamUtil.getLong(request, "esfUserId");
		String firstName = ParamUtil.getString(request, "firstName");
		String lastName = ParamUtil.getString(request, "lastName");
		String placeOfBirth = ParamUtil.getString(request, "placeOfBirth");
		String dateOfBirthString = ParamUtil.getString(request, "dateOfBirth");
		Date dateOfBirth = ManageDate.StringToDate(dateOfBirthString);

		String residenceCity = ParamUtil.getString(request, "residenceCity");
		String province = ParamUtil.getString(request, "province");
		int zip = ParamUtil.getInteger(request, "zip");
		String address = ParamUtil.getString(request, "address");
		String phoneNumber = ParamUtil.getString(request, "phoneNumber");
		String maritialStatus = ParamUtil.getString(request, "maritialStatus");
		String email = ParamUtil.getString(request, "email");
		String fiscalCode = ParamUtil.getString(request, "fiscalCode");
		String passport = ParamUtil.getString(request, "passport");
		String releasedBy = ParamUtil.getString(request, "releasedBy");
		String passportReleaseDateString =
			ParamUtil.getString(request, "passportReleaseDate");
		Date passportReleaseDate =
			ManageDate.StringToDate(passportReleaseDateString);
		String passportExpirationDateString =
			ParamUtil.getString(request, "passportExpirationDate");
		Date passportExpiration =
			ManageDate.StringToDate(passportExpirationDateString);

		String europeanCardNumber =
			ParamUtil.getString(request, "europeanCardNumber");

		String europeanCardReleaseDateString =
			ParamUtil.getString(request, "europeanCardReleaseDate");
		Date europeanCardReleaseDate =
			ManageDate.StringToDate(europeanCardReleaseDateString);

		String europeanCardExpirationDateString =
			ParamUtil.getString(request, "europeanCardExpirationDate");
		Date europeanCardExpirationDate =
			ManageDate.StringToDate(europeanCardExpirationDateString);

		String gunLicenceNumber =
			ParamUtil.getString(request, "gunLicenceNumber");

		String gunLicenceReleaseDateString =
			ParamUtil.getString(request, "gunLicenceReleaseDate");
		Date gunLicenceReleaseDate =
			ManageDate.StringToDate(gunLicenceReleaseDateString);

		String gunLicenceExpirationDateString =
			ParamUtil.getString(request, "gunLicenceExpirationDate");
		Date gunLicenceExpirationDate =
			ManageDate.StringToDate(gunLicenceExpirationDateString);

		String esfGunTypeNameOne = "";
		String esfGunKindNameOne = "";
		double firstGunCaliber = 0;
		String firstGunCode = "";
		String firstGunExtraCanes = "";

		String esfGunTypeNameTwo = "";
		String esfGunKindNameTwo = "";
		double secondGunCaliber = 0;
		String secondGunCode = "";
		String secondGunExtraCanes = "";
		/*
		 * First Gun
		 */
		long esfGunKindIdOne = 0;
		long esfGunTypeIdOne = ParamUtil.getLong(request, "esfGunTypeIdOne");
		if (esfGunTypeIdOne > 0 && Validator.isNotNull(esfGunTypeIdOne)) {
			ESFGunType esfGunType =
				ESFGunTypeLocalServiceUtil.getESFGunType(esfGunTypeIdOne);
			if (Validator.isNotNull(esfGunType) &&
				Validator.isNotNull(esfGunType.getName())) {
				esfGunTypeNameOne = esfGunType.getName();
			}
			 esfGunKindIdOne =
				ParamUtil.getLong(request, "esfGunKindIdOne");
			if (esfGunTypeIdOne > 0 && Validator.isNotNull(esfGunTypeIdOne)) {
				ESFGunKind esfGunKind =
					ESFGunKindLocalServiceUtil.getESFGunKind(esfGunKindIdOne);
				if (Validator.isNotNull(esfGunKind) &&
					Validator.isNotNull(esfGunKind.getName())) {
					esfGunKindNameOne = esfGunKind.getName();
				}
			}
			firstGunCaliber = ParamUtil.getDouble(request, "firstGunCaliber");
			firstGunCode = ParamUtil.getString(request, "firstGunCode");
			firstGunExtraCanes =
				ParamUtil.getString(request, "firstGunExtraCanes");
		}
		/*
		 * Second Gun
		 */
		long esfGunKindIdTwo = 0;
		
		long esfGunTypeIdTwo = ParamUtil.getLong(request, "esfGunTypeIdTwo");
		if (esfGunTypeIdTwo > 0 && Validator.isNotNull(esfGunTypeIdTwo)) {
			ESFGunType esfGunType =
				ESFGunTypeLocalServiceUtil.getESFGunType(esfGunTypeIdTwo);
			if (Validator.isNotNull(esfGunType) &&
				Validator.isNotNull(esfGunType.getName())) {
				esfGunTypeNameTwo = esfGunType.getName();
			}
				esfGunKindIdTwo =
				ParamUtil.getLong(request, "esfGunKindIdTwo");
			if (esfGunTypeIdTwo > 0 && Validator.isNotNull(esfGunTypeIdTwo)) {
				ESFGunKind esfGunKind =
					ESFGunKindLocalServiceUtil.getESFGunKind(esfGunKindIdTwo);
				if (Validator.isNotNull(esfGunKind) &&
					Validator.isNotNull(esfGunKind.getName())) {
					esfGunKindNameTwo = esfGunKind.getName();
				}
			}
			secondGunCaliber = ParamUtil.getDouble(request, "secondGunCaliber");
			secondGunCode = ParamUtil.getString(request, "secondGunCode");
			secondGunExtraCanes =
				ParamUtil.getString(request, "secondGunExtraCanes");
		}

		String gunCartridgeType =
			ParamUtil.getString(request, "gunCartridgeType");
		String gunCartridgeKind =
			ParamUtil.getString(request, "gunCartridgeKind");
		String cartridgeCaliber =
			ParamUtil.getString(request, "cartridgeCaliber");

		if (esfPartecipantInfoId == 0) {
			Date createDate = new Date();
			ESFPartecipantInfoLocalServiceUtil.addESFPartecipantInfo(
				groupId, companyId, userId, userName, createDate, isPortalUser,
				esfUserId, protocol, firstName, lastName, placeOfBirth,
				dateOfBirth, residenceCity, province, zip, address,
				phoneNumber, email, maritialStatus, fiscalCode, passport,
				releasedBy, passportReleaseDate, passportExpiration,
				europeanCardNumber, europeanCardReleaseDate,
				europeanCardExpirationDate, gunLicenceNumber,
				gunLicenceReleaseDate, gunLicenceExpirationDate,
				esfGunTypeNameOne, esfGunKindNameOne, firstGunCode,
				firstGunCaliber, firstGunExtraCanes, esfGunTypeNameTwo,
				esfGunKindNameTwo, secondGunCode, secondGunCaliber,
				secondGunExtraCanes, gunCartridgeType, gunCartridgeKind,
				cartridgeCaliber, 0, esfGunTypeIdOne, esfGunKindIdOne, 
				 esfGunTypeIdTwo, esfGunKindIdTwo);
		}
		else {
			protocol = ESFPartecipantInfoLocalServiceUtil.
							getESFPartecipantInfo(esfPartecipantInfoId).
																getProtocol();
			ESFPartecipantInfoLocalServiceUtil.updateESFPartecipantInfo(
				esfPartecipantInfoId, groupId, companyId, userId, userName,
				isPortalUser, esfUserId, protocol, firstName, lastName,
				placeOfBirth, dateOfBirth, residenceCity, province, zip,
				address, phoneNumber, email, maritialStatus, fiscalCode,
				passport, releasedBy, passportReleaseDate, passportExpiration,
				europeanCardNumber, europeanCardReleaseDate,
				europeanCardExpirationDate, gunLicenceNumber,
				gunLicenceReleaseDate, gunLicenceExpirationDate,
				esfGunTypeNameOne, esfGunKindNameOne, firstGunCode,
				firstGunCaliber, firstGunExtraCanes, esfGunTypeNameTwo,
				esfGunKindNameTwo, secondGunCode, secondGunCaliber,
				secondGunExtraCanes, gunCartridgeType, gunCartridgeKind,
				cartridgeCaliber,0, esfGunTypeIdOne, esfGunKindIdOne, 
				 esfGunTypeIdTwo, esfGunKindIdTwo);
		}
		response.setRenderParameter("esfPartecipantInfoId", String.valueOf(esfPartecipantInfoId));
		response.setRenderParameter(
				"mvcPath", "/html/esfpartecipantinfo/edit_esfPartecipantInfo.jsp");
	}
	
}
