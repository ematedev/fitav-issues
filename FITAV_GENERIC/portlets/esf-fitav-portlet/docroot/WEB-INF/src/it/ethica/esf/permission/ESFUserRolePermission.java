
package it.ethica.esf.permission;

import it.ethica.esf.model.ESFUserRole;
import it.ethica.esf.service.ESFUserRoleLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;

public class ESFUserRolePermission {

	public static final String RESOURCE_NAME = "it.ethica.esf.model.esfuserrole";
	
	public static void check(PermissionChecker permissionChecker, long esfUserRoleId, long groupId, String actionId)
			throws PortalException, SystemException {

		if (!contains(permissionChecker, esfUserRoleId, groupId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(PermissionChecker permissionChecker, long esfUserRoleId, long groupId, String actionId)
			throws PortalException, SystemException {

		ESFUserRole esfUserRole = ESFUserRoleLocalServiceUtil.fetchESFUserRole(esfUserRoleId);

		return permissionChecker.hasPermission(groupId, RESOURCE_NAME,
				esfUserRole.getEsfUserRoleId(), actionId);

	}

}
