
package it.ethica.esf.permission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;

import it.ethica.esf.model.ESFUser;
import it.ethica.esf.service.ESFUserLocalServiceUtil;

public class ESFUserAdminPermission {

	public static void check(
		PermissionChecker permissionChecker, long esfUserId, String actionId)
		throws PrincipalException, PortalException, SystemException {

		if (!contains(permissionChecker, esfUserId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(
		PermissionChecker permissionChecker, long esfUserId, String actionId)
		throws PortalException, SystemException {

		ESFUser esfUser=
			ESFUserLocalServiceUtil.getESFUser(esfUserId);

		return permissionChecker.hasPermission(
			esfUser.getGroupId(), ESFUser.class.getName(),
			esfUser.getEsfUserId(), actionId);
	}
}
