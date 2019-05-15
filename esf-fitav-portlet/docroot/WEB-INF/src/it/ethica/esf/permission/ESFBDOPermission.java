package it.ethica.esf.permission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;

import it.ethica.esf.model.ESFUserRole;
import it.ethica.esf.service.ESFUserRoleLocalServiceUtil;

public class ESFBDOPermission {

	public static final String RESOURCE_NAME = "it.ethica.esf.model.esfbdo";
	
	public static void check(PermissionChecker permissionChecker, long esfOrganizationId, String actionId)
			throws PortalException, SystemException {

		if (!contains(permissionChecker, esfOrganizationId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(PermissionChecker permissionChecker, long esfUserRoleId, String actionId)
			throws PortalException, SystemException {

		ESFUserRole esfUserRole = ESFUserRoleLocalServiceUtil.fetchESFUserRole(esfUserRoleId);

		return permissionChecker.hasPermission(esfUserRole.getGroupId(), RESOURCE_NAME,
				esfUserRole.getEsfUserRoleId(), actionId);

	}
}
