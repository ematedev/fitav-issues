
package it.ethica.esf.service.permission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.service.UserLocalServiceUtil;

public class ESFUserPermission {

	public static final String RESOURCE_NAME = "it.ethica.esf.model.ESFUser";

	public static void check(
		PermissionChecker permissionChecker, long esfUserId, String actionId)
		throws PortalException, SystemException {

		if (!contains(permissionChecker, esfUserId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(
		PermissionChecker permissionChecker, long esfUserId, String actionId)
		throws PortalException, SystemException {

		User user = UserLocalServiceUtil.getUser(esfUserId);

		return permissionChecker.hasPermission(
			user.getGroupId(), RESOURCE_NAME, esfUserId,
			actionId);
	}
}
