
package it.ethica.esf.renewal.admin.portlet;

import it.ethica.esf.model.ESFEntityState;
import it.ethica.esf.model.ESFOrganization;
import it.ethica.esf.model.ESFUserESFUserRole;
import it.ethica.esf.renewal.model.ESFRenewalCompany;
import it.ethica.esf.renewal.service.ESFRenewalCompanyLocalServiceUtil;
import it.ethica.esf.service.ESFEntityStateLocalServiceUtil;
import it.ethica.esf.service.ESFOrganizationLocalServiceUtil;
import it.ethica.esf.service.ESFUserESFUserRoleLocalServiceUtil;
import it.ethica.esf.util.ESFKeys;
import it.ethica.esf.util.ESFRenewalConstants;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Role;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class RenewalCompanyAdminPortlet extends MVCPortlet {

	public void populateESFRenewalCompany(
		ActionRequest actionRequest, ActionResponse actionResponse)
		throws PortalException, SystemException {

		ThemeDisplay themeDisplay =
			(ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		long userId = themeDisplay.getUserId();

		List<ESFOrganization> esfOrganizations =
			ESFOrganizationLocalServiceUtil.findAllLeafOrganizations(
				10827, QueryUtil.ALL_POS, QueryUtil.ALL_POS);

		for (ESFOrganization esfOrganization : esfOrganizations) {
			long esfOrganizationId = esfOrganization.getEsfOrganizationId();

			try {
				ESFRenewalCompanyLocalServiceUtil.addESFRenewalCompany(
					userId, esfOrganizationId, 0, 2016, new Date(), 0, 0, 0,
					StringPool.BLANK, StringPool.BLANK, null, 0, null, 0,
					StringPool.BLANK, false);
				System.out.println("Added Renewal for Organization " +
					esfOrganizationId);
			}
			catch (Exception e) {
				System.out.println("Problems with " + esfOrganizationId);
			}
		}
	}

	public void enableAssociation(
		ActionRequest actionRequest, ActionResponse actionResponse)
		throws PortalException, SystemException {

		ThemeDisplay themeDisplay =
			(ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		long esfRenewalCompanyId =
			ParamUtil.getLong(actionRequest, "esfRenewalCompanyId");

		ESFRenewalCompany esfRenewalCompany =
			ESFRenewalCompanyLocalServiceUtil.getESFRenewalCompany(esfRenewalCompanyId);

		Role presidente =
			RoleLocalServiceUtil.getRole(
				themeDisplay.getCompanyId(), "Presidente Associazione");

		long presidentePK = presidente.getPrimaryKey();

		List<ESFUserESFUserRole> temp =
			ESFUserESFUserRoleLocalServiceUtil.findESFUserESFRoleByO_R(
				esfRenewalCompany.getEsfOrganizationId(), presidentePK);
//		if (temp.size() == 0) {
//			SessionErrors.add(actionRequest, "no-president");
//			actionResponse.setRenderParameter(
//				"esfOrganizationId",
//				Long.toString(esfRenewalCompany.getEsfOrganizationId()));
//			actionResponse.setRenderParameter(
//				"year", Integer.toString(esfRenewalCompany.getYear()));
//			actionResponse.setRenderParameter(
//				"mvcPath", "/html/renewal/admin/edit.jsp");
//			return;
//		}

		if (temp.size() > 0) {
			ESFEntityState esfEntityState =
				ESFEntityStateLocalServiceUtil.findESFEntityStateByC_PK_S(
					ESFOrganization.class.getName(),
					esfRenewalCompany.getEsfOrganizationId(),
					ESFKeys.ESFStateType.DISABLE);
			Calendar cal = Calendar.getInstance();
			cal.set(Calendar.YEAR, esfRenewalCompany.getYear());
			cal.set(Calendar.DAY_OF_YEAR, 1);
			Date startDate = cal.getTime();
	
			if (Validator.isNull(esfEntityState)) {
				ServiceContext serviceContext =
					ServiceContextFactory.getInstance(
						ESFEntityState.class.getName(), actionRequest);
				esfEntityState =
					ESFEntityStateLocalServiceUtil.addEntityState(
						themeDisplay.getUserId(), ESFOrganization.class.getName(),
						esfRenewalCompany.getEsfOrganizationId(),
						ESFKeys.ESFStateType.ENABLE, startDate, null,
						serviceContext);
			}
			esfEntityState.setStartDate(startDate);
			esfEntityState.setEndDate(null);
	
			ESFEntityStateLocalServiceUtil.updateESFEntityState(esfEntityState);

			esfRenewalCompany.setJoin(true);
			esfRenewalCompany.setStatus(ESFRenewalConstants.RENEWAL_STATUS_COMPLETED);

			_log.info("Affiliation for company " +
							esfRenewalCompany.getEsfOrganizationId() + " affialiated!");
		}
		else {
			esfRenewalCompany.setJoin(false);
			esfRenewalCompany.setStatus(ESFRenewalConstants.RENEWAL_STATUS_COMPLETED_NOT_AFFILIATED);

			_log.info("Payment done " +
							esfRenewalCompany.getEsfOrganizationId() + " but not affialiated!");
		}

		ESFRenewalCompanyLocalServiceUtil.updateESFRenewalCompany(esfRenewalCompany);

	}

	public void disableAssociation(
		ActionRequest actionRequest, ActionResponse actionResponse)
		throws PortalException, SystemException {

		long esfRenewalCompanyId =
			ParamUtil.getLong(actionRequest, "esfRenewalCompanyId");

		ESFRenewalCompany esfRenewalCompany =
			ESFRenewalCompanyLocalServiceUtil.getESFRenewalCompany(esfRenewalCompanyId);
		ESFEntityState esfEntityState =
			ESFEntityStateLocalServiceUtil.findESFEntityStateByC_PK_S(
				ESFOrganization.class.getName(),
				esfRenewalCompany.getEsfOrganizationId(),
				ESFKeys.ESFStateType.ENABLE);
		esfEntityState.setEsfStateId(ESFKeys.ESFStateType.DISABLE);
		esfEntityState.setEndDate(new Date());

		ESFEntityStateLocalServiceUtil.updateESFEntityState(esfEntityState);

		esfRenewalCompany.setJoin(false);
		esfRenewalCompany.setStatus(ESFRenewalConstants.RENEWAL_STATUS_COMPLETED_NOT_AFFILIATED);

		ESFRenewalCompanyLocalServiceUtil.updateESFRenewalCompany(esfRenewalCompany);

		_log.info("Affiliation for company " +
			esfRenewalCompany.getEsfOrganizationId() + " removed!");
	}

	public void updateESFRenewalCompany(
		ActionRequest actionRequest, ActionResponse actionResponse)
		throws PortalException, SystemException {

		ThemeDisplay themeDisplay =
			(ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		ServiceContext serviceContext =
			ServiceContextFactory.getInstance(actionRequest);

		int actualYear = Calendar.getInstance().get(Calendar.YEAR);

		long userId = themeDisplay.getUserId();

		long esfRenewalCompanyId =
			ParamUtil.getLong(actionRequest, "esfRenewalCompanyId");
		long esfOrganizationId =
			ParamUtil.getLong(actionRequest, "esfOrganizationId");
		int cardsNumber = ParamUtil.getInteger(actionRequest, "cardsNumber");
		int year = ParamUtil.getInteger(actionRequest, "year");
		int paymentType = ParamUtil.getInteger(actionRequest, "paymentType");
		double amount = ParamUtil.getDouble(actionRequest, "amount");
		double totalAmount = ParamUtil.getDouble(actionRequest, "totalAmount");
		String info = ParamUtil.getString(actionRequest, "info");
		String accountholder =
			ParamUtil.getString(actionRequest, "accountholder");
		Date paymentDate =
			ParamUtil.getDate(
				actionRequest, "paymentDate",
				DateFormatFactoryUtil.getSimpleDateFormat("dd/MM/yyyy"));
		double integrationAmount =
			ParamUtil.getDouble(actionRequest, "integrationAmount");
		Date integrationDate =
			ParamUtil.getDate(
				actionRequest, "integrationDate",
				DateFormatFactoryUtil.getSimpleDateFormat("dd/MM/yyyy"));
		int integrationType =
			ParamUtil.getInteger(actionRequest, "integrationType");
		String integrationAccountholder =
			ParamUtil.getString(actionRequest, "integrationAccountholder");
		boolean join = ParamUtil.getBoolean(actionRequest, "join");

		int status = ESFRenewalConstants.RENEWAL_STATUS_NO_PAYMENT;

		if (0 <= amount && amount < totalAmount) {
			status = ESFRenewalConstants.RENEWAL_STATUS_PENDING;
		}
		if ((totalAmount == amount + integrationAmount) && join) {
			status = ESFRenewalConstants.RENEWAL_STATUS_COMPLETED;
			
			//Check president
			Role presidente =
				RoleLocalServiceUtil.getRole(
					themeDisplay.getCompanyId(), "Presidente Associazione");

			long presidentePK = presidente.getPrimaryKey();
			System.out.println("PK Presidente " + presidentePK);

			List<ESFUserESFUserRole> temp =
				ESFUserESFUserRoleLocalServiceUtil.findESFUserESFRoleByO_R(
					esfOrganizationId, presidentePK);
			if (temp.size() == 0) {
				status = ESFRenewalConstants.RENEWAL_STATUS_COMPLETED_NOT_AFFILIATED;
				join = false;
//				SessionErrors.add(actionRequest, "no-president");
//				actionResponse.setRenderParameter(
//					"esfOrganizationId",
//					Long.toString(esfOrganizationId));
//				actionResponse.setRenderParameter(
//					"year", Integer.toString(year));
//				actionResponse.setRenderParameter(
//					"mvcPath", "/html/renewal/admin/edit.jsp");
//				return;
				
			}
		}
		if ((totalAmount == amount + integrationAmount) && !join) {
			status =
				ESFRenewalConstants.RENEWAL_STATUS_COMPLETED_NOT_AFFILIATED;
		}

		if (amount == totalAmount) {
			integrationAmount = 0;
			integrationDate = null;
			integrationType =
				ESFRenewalConstants.RENEWAL_PAYMENT_TYPE_NO_PAYMENT;
			integrationAccountholder = StringPool.BLANK;
		}
		
		

		ESFRenewalCompany esfRenewalCompany = null;
		if (Validator.isNotNull(esfRenewalCompanyId)) {
			esfRenewalCompany =
				ESFRenewalCompanyLocalServiceUtil.updateESFRenewalCompany(
					esfRenewalCompanyId, userId, esfOrganizationId,
					cardsNumber, year, new Date(), paymentType, status, amount,
					info, accountholder, paymentDate, integrationAmount,
					integrationDate, integrationType, integrationAccountholder,
					join);
			_log.info("Updated Renewal Company " +
				esfRenewalCompany.getEsfRenewalCompanyId());
		}
		else {
			esfRenewalCompany =
				ESFRenewalCompanyLocalServiceUtil.addESFRenewalCompany(
					userId, esfOrganizationId, cardsNumber, year, new Date(),
					paymentType, status, amount, info, accountholder,
					paymentDate, integrationAmount, integrationDate,
					integrationType, integrationAccountholder, join);
			_log.info("Added Renewal Company " +
				esfRenewalCompany.getEsfRenewalCompanyId());
		}

		if (status == ESFRenewalConstants.RENEWAL_STATUS_COMPLETED && join &&
			year == actualYear) {
			Calendar cal = Calendar.getInstance();
			cal.set(Calendar.YEAR, year);
			cal.set(Calendar.DAY_OF_YEAR, 1);
			Date startDate = cal.getTime();

			ESFEntityStateLocalServiceUtil.addEntityState(
				userId, ESFOrganization.class.getName(), esfOrganizationId,
				ESFKeys.ESFStateType.ENABLE, startDate, null, serviceContext);
			_log.info("Organization " + esfOrganizationId + " affiliated!");
		}

	}
	private static Log _log =
		LogFactoryUtil.getLog(RenewalCompanyAdminPortlet.class);
}
