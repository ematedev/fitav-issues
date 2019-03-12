package it.ethica.esf.permission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;

import it.ethica.esf.model.ESFOrganizationUnitservice;
import it.ethica.esf.service.ESFOrganizationUnitserviceLocalServiceUtil;

public class ESFOrganizationUnitServicePermission {

	
	public static void check(PermissionChecker permissionChecker, long esfOrganizationId, String actionId)
			throws PortalException, SystemException {

		if (!contains(permissionChecker, esfOrganizationId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(PermissionChecker permissionChecker, long esfOrganizationUnitserviceId, String actionId)
			throws PortalException, SystemException {

		ESFOrganizationUnitservice esfOrganizationUnitservice = ESFOrganizationUnitserviceLocalServiceUtil.fetchESFOrganizationUnitservice(esfOrganizationUnitserviceId);

		return permissionChecker.hasPermission(esfOrganizationUnitservice.getGroupId(), ESFOrganizationUnitservice.class.getName(),
				esfOrganizationUnitservice.getEsfOrganizationId(), actionId);

	}
}
