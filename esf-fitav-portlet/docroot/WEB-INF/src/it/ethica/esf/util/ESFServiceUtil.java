
package it.ethica.esf.util;

import it.ethica.esf.model.ESFCard;
import it.ethica.esf.model.ESFCity;
import it.ethica.esf.model.ESFField;
import it.ethica.esf.model.ESFGunKind;
import it.ethica.esf.model.ESFOrganization;
import it.ethica.esf.model.ESFProvince;
import it.ethica.esf.model.ESFSportType;
import it.ethica.esf.portlet.ESFSportAssociationPortlet;
import it.ethica.esf.service.ESFAddressLocalServiceUtil;
import it.ethica.esf.service.ESFCardLocalServiceUtil;
import it.ethica.esf.service.ESFFieldLocalServiceUtil;
import it.ethica.esf.service.ESFGunKindLocalServiceUtil;
import it.ethica.esf.service.ESFOrganizationLocalServiceUtil;
import it.ethica.esf.service.ESFSportTypeLocalServiceUtil;
import it.ethica.esf.service.ESFUserLocalServiceUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.EmailAddressException;
import com.liferay.portal.NoSuchUserException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;

public class ESFServiceUtil {

	private ServiceContext serviceContext;

	public ESFServiceUtil(String className, ResourceRequest request)
		throws ClassNotFoundException, PortalException, SystemException {

		Class classObject = Class.forName(className);
		serviceContext =
			ServiceContextFactory.getInstance(classObject.getName(), request);
	}

	public ESFServiceUtil() {

	}

	public void serveRegions(
		ResourceRequest resourceRequest, ResourceResponse resourceResponse,
		String param, String idCountry, String idRegion)
		throws Exception {

		JSONArray resultJSONArr = JSONFactoryUtil.createJSONArray();

		try {
			List<ESFProvince> province =
				ESFAddressLocalServiceUtil.findByC_R(idRegion, idCountry);
			for (ESFProvince provincia : province) {
				JSONArray regioniJSONSubarray =
					JSONFactoryUtil.createJSONArray();
				regioniJSONSubarray.put(provincia.getIdProvince());
				regioniJSONSubarray.put(provincia.getName());
				resultJSONArr.put(regioniJSONSubarray);
			}
		}
		catch (SystemException e) {
			throw new PortletException(e);
		}
		resourceResponse.getWriter().write(resultJSONArr.toString());
	}

	public void serveProvinces(
		ResourceRequest resourceRequest, ResourceResponse resourceResponse,
		String param, String idCountry, String idRegion, String idProvince)
		throws Exception {

		JSONArray resultJSONArr = JSONFactoryUtil.createJSONArray();

		try {
			List<ESFCity> comuni = new ArrayList<ESFCity>();
			comuni =
				ESFAddressLocalServiceUtil.findByC_R_P(
					idCountry, idRegion, idProvince);
			for (ESFCity comune : comuni) {
				JSONArray regioniJSONSubarray =
					JSONFactoryUtil.createJSONArray();
				regioniJSONSubarray.put(comune.getIdCity());
				regioniJSONSubarray.put(comune.getName());
				resultJSONArr.put(regioniJSONSubarray);
			}
		}
		catch (SystemException e) {
			throw new PortletException(e);
		}

		resourceResponse.getWriter().write(resultJSONArr.toString());
	}

	public void serveCode(
		ResourceRequest resourceRequest, ResourceResponse resourceResponse,
		String idProvince)
		throws Exception {

		String code =
			ManageOperationsField.calculateAssociationCode(idProvince);
		JSONArray resultJSONArr = JSONFactoryUtil.createJSONArray();
		resultJSONArr.put(code);
		resourceResponse.getWriter().write(resultJSONArr.toString());
	}

	public void serveOrganization(
		ResourceRequest resourceRequest, ResourceResponse resourceResponse,
		String param, String idEsfOrganization)
		throws Exception {

		JSONArray resultJSONArr = JSONFactoryUtil.createJSONArray();

		long id = -1;

		if (validate(idEsfOrganization)) {
			id = Long.parseLong(idEsfOrganization);
		}

		try {
			List<ESFOrganization> organizations =
				ESFOrganizationLocalServiceUtil.findAllChildOrganizations(id);
			for (ESFOrganization organization : organizations) {
				JSONArray organizationJSONSubarray =
					JSONFactoryUtil.createJSONArray();
				organizationJSONSubarray.put(organization.getEsfOrganizationId());
				organizationJSONSubarray.put(organization.getName());
				resultJSONArr.put(organizationJSONSubarray);
			}
		}
		catch (SystemException e) {
			throw new PortletException(e);
		}
		resourceResponse.getWriter().write(resultJSONArr.toString());
	}

	public void serveEmailAddress(
		ResourceRequest resourceRequest, ResourceResponse resourceResponse,
		String emailAddress)
		throws PortalException, SystemException, IOException {

		JSONArray resultJSONArr = JSONFactoryUtil.createJSONArray();

		try {
			if (ESFUserLocalServiceUtil.checkEmailAddress(
				emailAddress, serviceContext) != null) {
				SessionErrors.add(resourceRequest, "user-email-message");
				resultJSONArr.put("The Email Address is already exist");
				resourceResponse.getWriter().write(resultJSONArr.toString());
			}
		}
		catch (EmailAddressException e) {

		}
		catch (NoSuchUserException u) {
		}

	}

	public void serveAssociationsCards(
		ResourceRequest resourceRequest, ResourceResponse resourceResponse,
		String param, long idAssociation, long esfUserId)
		throws Exception {

		JSONArray resultJSONArr = JSONFactoryUtil.createJSONArray();

		List<ESFCard> esfCards =
			ESFCardLocalServiceUtil.findAllNotAssignedESFCardsByO_U_S(
				idAssociation, true, esfUserId, ESFKeys.ESFStateType.ENABLE);

		for (ESFCard esfCard : esfCards) {
			JSONArray cardsJSONSubarray = JSONFactoryUtil.createJSONArray();
			cardsJSONSubarray.put(esfCard.getEsfCardId());
			cardsJSONSubarray.put(esfCard.getCode());
			resultJSONArr.put(cardsJSONSubarray);
		}
		resourceResponse.getWriter().write(resultJSONArr.toString());
	}

	public void serveAssociationsFields(
		ResourceRequest resourceRequest, ResourceResponse resourceResponse,
		String param, long idAssociation)
		throws Exception {

		JSONArray resultJSONArr = JSONFactoryUtil.createJSONArray();

		List<ESFField> esfFields =
			ESFFieldLocalServiceUtil.findByESFOrganization(
				idAssociation, ESFKeys.ESFStateType.ENABLE);

		for (ESFField esfField : esfFields) {
			JSONArray fieldsJSONSubarray = JSONFactoryUtil.createJSONArray();
			fieldsJSONSubarray.put(esfField.getEsfFieldId());
			fieldsJSONSubarray.put(esfField.getName());
			resultJSONArr.put(fieldsJSONSubarray);
		}
		resourceResponse.getWriter().write(resultJSONArr.toString());
	}

	public void serveAssociationsSportTypes(
		ResourceRequest resourceRequest, ResourceResponse resourceResponse,
		String param, long idField)
		throws Exception {

		JSONArray resultJSONArr = JSONFactoryUtil.createJSONArray();

		List<ESFSportType> esfSportTypes =
			ESFSportTypeLocalServiceUtil.findByESFFieldId(idField);

		for (ESFSportType esfSportType : esfSportTypes) {
			JSONArray sporttypesJSONSubarray =
				JSONFactoryUtil.createJSONArray();
			sporttypesJSONSubarray.put(esfSportType.getEsfSportTypeId());
			sporttypesJSONSubarray.put(esfSportType.getName());
			resultJSONArr.put(sporttypesJSONSubarray);
		}
		resourceResponse.getWriter().write(resultJSONArr.toString());
	}

	private boolean validate(String item) {

		if (Validator.isNotNull(item) && !Validator.isBlank(item)) {
			return true;
		}
		else
			return false;
	}

	public void serveGunKinds(
		ResourceRequest resourceRequest, ResourceResponse resourceResponse,
		String param, long esfGunTypeId, long esfUserId) {

		try {
			if (esfGunTypeId > 0) {

				List<ESFGunKind> esfGunKinds = 	ESFGunKindLocalServiceUtil.
							getESFGunKindsByESFGunType(esfGunTypeId);

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
		}
		catch (SystemException e) {
			
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	private static Log _log =
			LogFactoryUtil.getLog(ESFServiceUtil.class);
}
