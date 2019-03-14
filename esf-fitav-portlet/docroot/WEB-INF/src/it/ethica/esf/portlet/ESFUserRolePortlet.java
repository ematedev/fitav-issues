
package it.ethica.esf.portlet;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import it.ethica.esf.NoSuchUserESFUserRoleException;
import it.ethica.esf.model.ESFAddress;
import it.ethica.esf.model.ESFEntityState;
import it.ethica.esf.model.ESFUser;
import it.ethica.esf.model.ESFUserESFUserRole;
import it.ethica.esf.model.ESFUserRole;
import it.ethica.esf.model.impl.ESFEntityStateImpl;
import it.ethica.esf.service.ESFAddressLocalServiceUtil;
import it.ethica.esf.service.ESFEntityStateLocalServiceUtil;
import it.ethica.esf.service.ESFUserESFUserRoleLocalServiceUtil;
import it.ethica.esf.service.ESFUserLocalServiceUtil;
import it.ethica.esf.service.ESFUserRoleLocalServiceUtil;
import it.ethica.esf.util.ESFJsonUtil;
import it.ethica.esf.util.ESFKeys;
import it.ethica.esf.util.ESFServiceUtil;

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
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.Role;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class ESFUserRolePortlet
 */
public class ESFUserRolePortlet extends MVCPortlet {

	@Override
	public void render(RenderRequest request, RenderResponse response)
		throws IOException, PortletException {

		ESFJsonUtil esfJsonUtil = new ESFJsonUtil();

		try {
			String op = ParamUtil.getString(request, "op");
			// String type = ParamUtil.getString(request, "type");
			// System.out.println("TYPE: "+type);

			if (op.equals("chooseorg")) {
				esfJsonUtil.prepareJSONOrganizations(request, response);
			}
			// else if(type.equals("")){
			// long esfOrganizationId = ParamUtil.getLong(request,
			// "esfOrganizationId");
			// long esfUserRoleId = ParamUtil.getLong(request, "esfUserRoleId");
			// response.addProperty(
			// "esfOrganizationId", String.valueOf(esfOrganizationId));
			// response.addProperty(
			// "esfUserRoleId", String.valueOf(esfUserRoleId));
			// }

		}
		catch (PortalException e) {
			e.printStackTrace();
		}

		super.render(request, response);
	}

	@Override
	public void serveResource(
		ResourceRequest resourceRequest, ResourceResponse resourceResponse)
		throws IOException, PortletException {

		try {
			ESFServiceUtil esfServiceUtil =
				new ESFServiceUtil(ESFUser.class.getName(), resourceRequest);

			HttpServletRequest httpReq =
				PortalUtil.getHttpServletRequest(resourceRequest);

			String param =
				PortalUtil.getOriginalServletRequest(httpReq).getParameter(
					"param");
			String idEsfOrganization =
				PortalUtil.getOriginalServletRequest(httpReq).getParameter(
					"esfOrganizationId");
			String resourceID = resourceRequest.getResourceID();

			esfServiceUtil.serveOrganization(
				resourceRequest, resourceResponse, param, idEsfOrganization);

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

	public void renderAssignMembers(
		ActionRequest actionRequest, ActionResponse actionResponse) {

		long esfUserRoleId = ParamUtil.getLong(actionRequest, "esfUserRoleId");

		long esfLiv0Id = ParamUtil.getLong(actionRequest, "esfLiv0Id");
		long esfLiv1Id = ParamUtil.getLong(actionRequest, "esfLiv1Id");
		long esfLiv2Id = ParamUtil.getLong(actionRequest, "esfLiv2Id");
		long esfLiv3Id = ParamUtil.getLong(actionRequest, "esfLiv3Id");

		long esfOrganizationId = 0;
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

		actionResponse.setRenderParameter(
			"esfOrganizationId", String.valueOf(esfOrganizationId));
		actionResponse.setRenderParameter(
			"esfUserRoleId", String.valueOf(esfUserRoleId));
		actionResponse.setRenderParameter("mvcPath", templatePath +
			"assignMembers_esfUserRole.jsp");

	}

	public void addESFUserRole(
		ActionRequest actionRequest, ActionResponse actionResponse)
		throws PortalException, SystemException {

		ServiceContext serviceContext =
			ServiceContextFactory.getInstance(
				ESFUserRole.class.getName(), actionRequest);

		String name = ParamUtil.getString(actionRequest, "name");
		String description = ParamUtil.getString(actionRequest, "description");
		String title = ParamUtil.getString(actionRequest, "title");
		boolean isBDO = ParamUtil.getBoolean(actionRequest, "isBDO");
		boolean isLEA = ParamUtil.getBoolean(actionRequest, "isLEA");
		boolean isOrgAdmin = ParamUtil.getBoolean(actionRequest, "isOrgAdmin");
		int type = ParamUtil.getInteger(actionRequest, "type");
		int maxUser = ParamUtil.getInteger(actionRequest, "maxUser");
		long esfStateId = ESFKeys.ESFStateType.ENABLE;

		Map<Locale, String> descriptionMap = new HashMap<Locale, String>();
		descriptionMap.put(LocaleUtil.getDefault(), description);

		Map<Locale, String> titleMap = new HashMap<Locale, String>();
		titleMap.put(LocaleUtil.getDefault(), title);

		ESFUserRole eSFUserRole = null;
		try {
			if (ESFUserRoleLocalServiceUtil.checkNome(name, serviceContext) != null) {
				SessionErrors.add(actionRequest, "userrole-name-message");
			}
			else {
				ESFEntityState esfEntityState = new ESFEntityStateImpl();
				esfEntityState.setEsfStateId(esfStateId);

				eSFUserRole =
					ESFUserRoleLocalServiceUtil.addESFUserRole(
						serviceContext.getUserId(), name, description,
						Role.class.getName(), serviceContext.getScopeGroupId(),
						descriptionMap, titleMap, type, StringPool.BLANK,
						isBDO, isLEA, isOrgAdmin, true, maxUser,
						esfEntityState, serviceContext);

				SessionMessages.add(actionRequest, "addESFUserRole");
				_log.info("Adding User Role: " + eSFUserRole.getEsfUserRoleId());
			}
		}
		catch (Exception e) {
			_log.error("Error in addESFUserRole method: " + e.getMessage());
			e.printStackTrace();
		}

	}

	public void updateESFUserRole(
		ActionRequest actionRequest, ActionResponse actionResponse)
		throws PortalException, SystemException {

		ServiceContext serviceContext =
			ServiceContextFactory.getInstance(
				ESFUserRole.class.getName(), actionRequest);

		String name = ParamUtil.getString(actionRequest, "name");
		String description = ParamUtil.getString(actionRequest, "description");
		String title = ParamUtil.getString(actionRequest, "title");
		long esfUserRoleId = ParamUtil.getLong(actionRequest, "esfUserRoleId");
		boolean isBDO = ParamUtil.getBoolean(actionRequest, "isBDO");
		boolean isLEA = ParamUtil.getBoolean(actionRequest, "isLEA");
		boolean isOrgAdmin = ParamUtil.getBoolean(actionRequest, "isOrgAdmin");
		int type = ParamUtil.getInteger(actionRequest, "type");
		int maxUser = ParamUtil.getInteger(actionRequest, "maxUser");

		Map<Locale, String> descriptionMap = new HashMap<Locale, String>();
		descriptionMap.put(LocaleUtil.getDefault(), description);

		Map<Locale, String> titleMap = new HashMap<Locale, String>();
		titleMap.put(LocaleUtil.getDefault(), title);

		Role role = RoleLocalServiceUtil.getRole(esfUserRoleId);

		try {
			if (ESFUserRoleLocalServiceUtil.checkNome(name, serviceContext) != null &&
				!role.getName().equals(name)) {
				SessionErrors.add(actionRequest, "userrole-name-message");
			}
			else {
				ESFUserRole esfUserRole =
					ESFUserRoleLocalServiceUtil.updateESFUserRole(
						serviceContext.getUserId(), esfUserRoleId, name,
						description, Role.class.getName(), descriptionMap,
						titleMap, type, StringPool.BLANK, isBDO, isLEA,
						isOrgAdmin, true, maxUser, serviceContext);

				SessionMessages.add(actionRequest, "updateESFUserRole");
				_log.info("Updating User Role: " + esfUserRoleId);
			}
		}
		catch (Exception e) {
			_log.error("Error in updateESFUserRole method: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void deleteESFUserRole(
		ActionRequest actionRequest, ActionResponse actionResponse)
		throws PortalException, SystemException {

		ServiceContext serviceContext =
			ServiceContextFactory.getInstance(
				ESFUserRole.class.getName(), actionRequest);

		long esfUserRoleId = ParamUtil.getLong(actionRequest, "esfUserRoleId");

		try {
			ESFUserRoleLocalServiceUtil.deleteESFUserRole(
				esfUserRoleId, serviceContext);

			SessionMessages.add(actionRequest, "deleteESFUserRole");
			_log.info("Deleting User Role: " + esfUserRoleId);
		}
		catch (Exception e) {
			_log.error("Error in deleteESFUserRole method: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void updateESFEntityState(
		ActionRequest actionRequest, ActionResponse actionResponse)
		throws PortalException, SystemException {

		long esfStateId = ParamUtil.getLong(actionRequest, "esfStateId");
		long esfUserRoleId = ParamUtil.getLong(actionRequest, "esfUserRoleId");

		List<ESFUserESFUserRole> esfUserESFUserRoles =
			ESFUserESFUserRoleLocalServiceUtil.getESFUSerRoleByR_ED(esfUserRoleId);

		if (esfUserESFUserRoles.size() == 0) {
			ServiceContext serviceContext =
				ServiceContextFactory.getInstance(
					ESFUserRole.class.getName(), actionRequest);

			ESFEntityState esfEntityState =
				ESFEntityStateLocalServiceUtil.findESFEntityStateByC_PK(
					ESFUserRole.class.getName(), esfUserRoleId);

			if (esfEntityState != null &&
				esfEntityState.getEsfStateId() != esfStateId) {

				ESFEntityStateLocalServiceUtil.updateEntityState(
					serviceContext.getUserId(),
					esfEntityState.getEsfEntityStateId(), serviceContext);

				ESFEntityStateLocalServiceUtil.addEntityState(
					serviceContext.getUserId(), ESFUserRole.class.getName(),
					esfUserRoleId, esfStateId, serviceContext);
			}
		}
		else {
			SessionErrors.add(actionRequest, "userrole-state-error");
		}
	}

	public void updateAddESFUserESFRole(
		ActionRequest actionRequest, ActionResponse actionResponse)
		throws SystemException, PortalException {

		ServiceContext serviceContext =
			ServiceContextFactory.getInstance(actionRequest);

		boolean[] chooses = ParamUtil.getBooleanValues(actionRequest, "choose");
		long[] esfUserIds =
			ParamUtil.getLongValues(actionRequest, "esfUserIds");
		long esfUserRoleId = ParamUtil.getLong(actionRequest, "esfUserRoleId");
		long esfOrganizationId =
			ParamUtil.getLong(actionRequest, "esfOrganizationId");
		String type = ParamUtil.getString(actionRequest, "type");
		Date date = new Date();

		ESFUserRole esfUserRole =
			ESFUserRoleLocalServiceUtil.fetchESFUserRole(esfUserRoleId);
		int maxUser = esfUserRole.getMaxUser();

		List<ESFUserESFUserRole> esfUserESFUserRoles =
			ESFUserESFUserRoleLocalServiceUtil.findESFUserESFRoleByO_R(
				esfOrganizationId, esfUserRoleId);

		int checkMax = 0;
		if (type.equals("NA")) {
			for (int j = 0; j < chooses.length; j++) {
				if (chooses[j])
					checkMax++;
			}
		}

		if (maxUser == 0 || esfUserESFUserRoles.size() + checkMax <= maxUser ||
			type.equals("A")) {
			for (int i = 0; i < esfUserIds.length; i++) {

				if (type.equals("NA") && chooses[i]) {
					ESFUserESFUserRoleLocalServiceUtil.addESFUserESFRole(
						esfUserIds[i], esfUserRoleId, esfOrganizationId, date);
				}
				else if (type.equals("A") && chooses[i]) {
					ESFUserESFUserRoleLocalServiceUtil.updateESFUserESFRole(
						esfUserIds[i], esfUserRoleId, esfOrganizationId, date, serviceContext);
				}
			}
		}
		else {
			SessionErrors.add(actionRequest, "userrole-maxuser-error");
		}

	}
	private static Log _log =
		LogFactoryUtil.getLog(ESFOrganizationAdminPortlet.class);
}
