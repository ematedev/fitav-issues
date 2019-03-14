
package com.ethica.esf.permission;

import it.ethica.esf.model.ESFUserRole;
import it.ethica.esf.service.ESFUserRoleLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;

public class ESFUserRolePermission {

	public static void check(
		PermissionChecker permissionChecker, long esfUserRoolId, String actionId)
		throws PrincipalException, PortalException, SystemException {

		if (!contains(permissionChecker, esfUserRoolId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(
		PermissionChecker permissionChecker, long esfUserRoolId, String actionId)
		throws PortalException, SystemException {

		ESFUserRole esfUserRole =
			ESFUserRoleLocalServiceUtil.getESFUserRole(esfUserRoolId);

		return permissionChecker.hasPermission(
			esfUserRole.getGroupId(), ESFUserRole.class.getName(),
			esfUserRole.getEsfUserRoleId(), actionId);
	}

}
