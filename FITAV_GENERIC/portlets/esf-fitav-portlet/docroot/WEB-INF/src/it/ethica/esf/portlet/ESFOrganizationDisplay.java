
package it.ethica.esf.portlet;

import java.io.IOException;
import java.text.ParseException;
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
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Organization;
import com.liferay.portal.model.Phone;
import com.liferay.portal.service.PhoneLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import it.ethica.esf.NoSuchUserESFUserRoleException;
import it.ethica.esf.model.ESFAddress;
import it.ethica.esf.model.ESFEntityState;
import it.ethica.esf.model.ESFField;
import it.ethica.esf.model.ESFOrganization;
import it.ethica.esf.model.ESFPhone;
import it.ethica.esf.model.ESFUserESFUserRole;
import it.ethica.esf.model.ESFUserRole;
import it.ethica.esf.model.impl.ESFEntityStateImpl;
import it.ethica.esf.service.ESFAddressLocalServiceUtil;
import it.ethica.esf.service.ESFEntityStateLocalServiceUtil;
import it.ethica.esf.service.ESFFieldLocalServiceUtil;
import it.ethica.esf.service.ESFHistoricalAssociationLocalServiceUtil;
import it.ethica.esf.service.ESFOrganizationLocalServiceUtil;
import it.ethica.esf.service.ESFUserESFUserRoleLocalServiceUtil;
import it.ethica.esf.service.ESFUserRoleLocalServiceUtil;
import it.ethica.esf.util.ESFJsonUtil;
import it.ethica.esf.util.ESFKeys;
import it.ethica.esf.util.ESFServiceUtil;
import it.ethica.esf.util.ManageDate;
import it.ethica.esf.util.ManageOperationsField;

/**
 * Portlet implementation class ESFOrganizationDisplay
 */
public class ESFOrganizationDisplay extends MVCPortlet {

	@Override
	public void render(RenderRequest request, RenderResponse response)
		throws IOException, PortletException {

		ESFJsonUtil esfJsonUtil = new ESFJsonUtil();
		// long esfAddressId = ParamUtil.getLong(request, "esfAddressId");
		long esfOrganizationId =
			ParamUtil.getLong(request, "esfOrganizationId");

		String op = ParamUtil.getString(request, "op");

		if (op.equals("addAddr")) {

			for (int i = 0; i < ESFKeys.MinElemIncludePage.MAXADDRESSORG; i++) {

				esfJsonUtil.prepareJSONAddAddress(request, response, i);

			}

			request.setAttribute(
				"number", ESFKeys.MinElemIncludePage.MINADDRESSORG);
			request.setAttribute(
				"numberOfPhones", ESFKeys.MinElemIncludePage.MINPHONEORG);

		}
		else if (op.equals("updAddr")) {
			try {
				ESFOrganization esfOrganization =
					ESFOrganizationLocalServiceUtil.fetchESFOrganization(esfOrganizationId);
				
				
				
				List<ESFAddress> esfAddresses =
					ESFAddressLocalServiceUtil.getESFAddresses(
						esfOrganization.getCompanyId(),
						Organization.class.getName(), esfOrganizationId);
				
				List<Phone> phones =
					PhoneLocalServiceUtil.getPhones(
						esfOrganization.getCompanyId(),
						Organization.class.getName(), esfOrganizationId);

				int index = 0;

				for (ESFAddress esfAddress : esfAddresses) {

					if(esfAddress != null){
						esfJsonUtil.prepareJSONUpdAddress(
								request, response, esfAddress.getEsfAddressId(), index);

							index++;
					}
				}

				if (index < ESFKeys.MinElemIncludePage.MAXADDRESSORG) {

					for (int i = index; i < ESFKeys.MinElemIncludePage.MAXADDRESSORG; i++) {

						esfJsonUtil.prepareJSONAddAddress(request, response, i);

					}

				}

				if (index < ESFKeys.MinElemIncludePage.MINADDRESSORG) {

					request.setAttribute(
						"number", ESFKeys.MinElemIncludePage.MINADDRESSORG);

				}
				else {

					request.setAttribute("number", index);

				}

				if (phones.size() < ESFKeys.MinElemIncludePage.MINPHONEORG) {

					request.setAttribute(
						"numberOfPhones",
						ESFKeys.MinElemIncludePage.MINPHONEORG);

				}
				else {

					request.setAttribute("numberOfPhones", phones.size());

				}

			}
			catch (PortalException e) {
				e.printStackTrace();
			}
			catch (SystemException e) {
				e.printStackTrace();
			}
		}
		super.render(request, response);
	}

	@Override
	public void serveResource(
		ResourceRequest resourceRequest, ResourceResponse resourceResponse)
		throws IOException, PortletException {

		try {
			ESFServiceUtil esfServiceUtil =
				new ESFServiceUtil(
					ESFOrganization.class.getName(), resourceRequest);

			HttpServletRequest httpReq =
				PortalUtil.getHttpServletRequest(resourceRequest);

			String param =
				PortalUtil.getOriginalServletRequest(httpReq).getParameter(
					"param");
			String idRegion =
				PortalUtil.getOriginalServletRequest(httpReq).getParameter(
					"idRegion");
			String idProvince =
				PortalUtil.getOriginalServletRequest(httpReq).getParameter(
					"idProvince");

			String resourceID = resourceRequest.getResourceID();

			if (resourceID.contains("regions")) {
				esfServiceUtil.serveRegions(
					resourceRequest, resourceResponse, param,
					ESFKeys.ESFAddressConstant.DEFAULT_COUNTRY, idRegion);
			}
			else if (resourceID.contains("provinces")) {
				esfServiceUtil.serveProvinces(
					resourceRequest, resourceResponse, param,
					ESFKeys.ESFAddressConstant.DEFAULT_COUNTRY, idRegion,
					idProvince);
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
		
		

		// super.serveResource(resourceRequest, resourceResponse);
	}

	public void editESFOrganization(
		ActionRequest request, ActionResponse response)
		throws PortalException, SystemException, ParseException {

		ServiceContext serviceContext =
			ServiceContextFactory.getInstance(
				ESFOrganizationAdminPortlet.class.getName(), request);

		long esfOrganizationId =
			ParamUtil.getLong(request, "esfOrganizationId");
		String name = ParamUtil.getString(request, "name");
		String emailAddress = ParamUtil.getString(request, "emailAddress");
		String vat = ParamUtil.getString(request, "vat");
		String fiscalCode = ParamUtil.getString(request, "fiscalCode");
		String ibanCode = ParamUtil.getString(request, "ibanCode");
		String legalForm = ParamUtil.getString(request, "legalForm");
		String category = ParamUtil.getString(request, "category");
		long esfStateId = ESFKeys.ESFStateType.DISABLE;
		long regionCode = ParamUtil.getLong(request, "regionCode");
		if (esfOrganizationId > 0){
			esfStateId = ParamUtil.getLong(request, "esfStateId");
		}
		boolean isMultiSport = ParamUtil.getBoolean(request, "isMultiSport");
		String coniCode = ParamUtil.getString(request, "coniCode");
		String description = ParamUtil.getString(request, "description");
		boolean isYouthActiv = ParamUtil.getBoolean(request, "isYouthActiv");
		Date insertDate = new Date();
		long variationId =	ParamUtil.getLong(request, "variation");
		String fad = ParamUtil.getString(request, "firstAffiliationDate");
		String es = ParamUtil.getString(request, "establishmentDate");
		String coni = ParamUtil.getString(request, "coniDate");
		String close = ParamUtil.getString(request, "closureDate");
		String stateVariationDate = ParamUtil.getString(request, "stateVariationDate");
		long idFatherAssociation = ParamUtil.getLong(request, "idFatherAssociation");
		boolean constitutiveAct = ParamUtil.getBoolean(request, "constitutiveAct");
		boolean registeredStatus = ParamUtil.getBoolean(request, "registeredStatus");
		boolean planimetrySportsStand = ParamUtil.getBoolean(request, "planimetrySportsStand");
		boolean certificateFITAV = ParamUtil.getBoolean(request, "certificateFITAV");
		boolean isSimplyOrganizzation = ParamUtil.getBoolean(request, "isSimplyOrganizzation",false);
		String note = ParamUtil.getString(request, "note");
		String webSite = ParamUtil.getString(request, "webSite");
		boolean addToConiReport = ParamUtil.getBoolean(request, "addToConiReport",false);
		
		Date establishmentDate = null;
		Date firstAffiliationDate = null;
		Date coniDate = null;
		Date closureDate = null;

		try {
			establishmentDate = ManageDate.StringToDate(es);
			firstAffiliationDate = ManageDate.StringToDate(fad);
			coniDate = ManageDate.StringToDate(coni);
			closureDate = ManageDate.StringToDate(close);
		}
		catch (ParseException e1) {
			e1.printStackTrace();
			throw new PortalException(e1);
		}

		List<ESFAddress> esfAddresses =
			ManageOperationsField.getAddresses(request, response);

		List<ESFPhone> phones =
			ManageOperationsField.getPhones(request, response);

		int typeOrg = ParamUtil.getInteger(request, "typeOrg");

		String code = "";
		if (typeOrg == ESFKeys.ESFOrganizationTypeId.ASSOCIATION) {
			code = ParamUtil.getString(request, "code");
		}
		else {
			code =
				ManageOperationsField.calculateDelegationCode(
					typeOrg, esfAddresses);
		}

		long parentOrganizationId = 0;
		
		ESFEntityState esfEntityStateOld =
				ESFEntityStateLocalServiceUtil.findESFEntityStateByC_PK(
					ESFOrganization.class.getName(), esfOrganizationId);

		ESFEntityState esfEntityState = new ESFEntityStateImpl();
		esfEntityState.setEsfStateId(esfStateId);
		
		if (esfOrganizationId > 0) {
			if (checkType(esfOrganizationId) == ESFKeys.ESFOrganizationTypeId.ASSOCIATION &&
				esfStateId != ESFKeys.ESFStateType.DISABLE &&
				!checkField(esfOrganizationId, ESFKeys.ESFStateType.ENABLE)) {
				SessionErrors.add(request, "organiz-field-message");
			}
			else if (checkType(esfOrganizationId) == ESFKeys.ESFOrganizationTypeId.ASSOCIATION &&
				esfStateId != ESFKeys.ESFStateType.DISABLE &&
				!checkPayment(esfOrganizationId)) {
				SessionErrors.add(request, "organiz-payment-message");
			}
			else {
				
				ESFOrganization oldOrg = ESFOrganizationLocalServiceUtil.fetchESFOrganization(esfOrganizationId);
				
				long oldStateId = ESFKeys.ESFStateType.DISABLE;
				
				if(Validator.isNotNull(esfEntityStateOld) && Validator.isNotNull(esfEntityStateOld.getEsfEntityStateId())){
					oldStateId = esfEntityStateOld.getEsfEntityStateId() ;
				}
				
				if(!oldOrg.getName().equals(name) || !oldOrg.getCode().equals(code) ||
						!(oldStateId == esfStateId) || !(oldOrg.getVariations() == variationId)){
					
					ESFHistoricalAssociationLocalServiceUtil.addESFHistoricalAssociation(esfOrganizationId,
						oldOrg.getName(), oldOrg.getCode(), esfStateId, oldOrg.getVariations(), stateVariationDate );
				}

				ESFOrganizationLocalServiceUtil.updateESFOrganization(
					serviceContext.getUserId(), esfOrganizationId,
					parentOrganizationId, name, emailAddress, code, vat,
					fiscalCode, ibanCode, establishmentDate, closureDate,
					insertDate, coniDate, coniCode, legalForm, category,
					esfAddresses, phones, isMultiSport, description,
					isYouthActiv, firstAffiliationDate, esfEntityState, variationId, regionCode, idFatherAssociation,
					constitutiveAct, registeredStatus, planimetrySportsStand, certificateFITAV, note, webSite,addToConiReport,
					serviceContext);

				response.setRenderParameter(
					"esfOrganizationId", Long.toString(esfOrganizationId));
			}
		}
		else {

			
			ESFOrganizationLocalServiceUtil.addESFOrganization(
				serviceContext.getUserId(), parentOrganizationId, name,
				emailAddress, code, vat, fiscalCode, ibanCode,
				establishmentDate, closureDate, insertDate, coniDate, coniCode,
				legalForm, category, esfAddresses, phones, false, true,
				isMultiSport, description, isYouthActiv, firstAffiliationDate,
				esfEntityState, variationId, regionCode, 
				constitutiveAct, registeredStatus, planimetrySportsStand, certificateFITAV,isSimplyOrganizzation,note, webSite,
				addToConiReport, serviceContext);

			SessionMessages.add(request, "esfOrganizationAdded");

			response.setRenderParameter(
				"esfOrganizationId", Long.toString(esfOrganizationId));
		}

	}

	private boolean checkBdo(long esfOrganizationId)
		throws NoSuchUserESFUserRoleException, SystemException {

		boolean result = false;

		List<ESFUserESFUserRole> esfUserESFUserRoles =
			ESFUserESFUserRoleLocalServiceUtil.findESFUserESFRolesByEsfOrganizzationId(esfOrganizationId);

		for (ESFUserESFUserRole esfUserESFUserRole : esfUserESFUserRoles) {
			ESFUserRole esfUserRole =
				ESFUserRoleLocalServiceUtil.fetchESFUserRole(esfUserESFUserRole.getEsfUserRoleId());

			if (esfUserRole.getIsBDO())
				result = true;
		}

		return result;
	}

	private boolean checkField(long esfOrganizationId, int state)
		throws PortalException, SystemException {

		boolean result = false;

		List<ESFField> esfFields =
			ESFFieldLocalServiceUtil.findByESFOrganization(
				esfOrganizationId, state);

		if (!esfFields.isEmpty()) {
			result = true;
		}

		return result;
	}

	private boolean checkPayment(long esfOrganizationId)
		throws PortalException, SystemException {

		boolean result = true;

		return result;
	}

	private long checkType(long esfOrganizationId)
		throws SystemException, NumberFormatException, PortalException {

		long type = 0;

		ESFOrganization esfOrganization =
			ESFOrganizationLocalServiceUtil.fetchESFOrganization(esfOrganizationId);

		if (esfOrganization != null)
			type = esfOrganization.getType();

		return type;
	}

	private static Log _log =
		LogFactoryUtil.getLog(ESFOrganizationAdminPortlet.class);
}
