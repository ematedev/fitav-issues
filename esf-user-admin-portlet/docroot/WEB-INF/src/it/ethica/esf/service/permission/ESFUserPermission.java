package it.ethica.esf.service.permission;

import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;

public class ESFUserPermission {
	public static final String RESOURCE_NAME = "it.ethica.esf.ESFUser";
	
	public static void check(PermissionChecker permissionChecker, long groupId, long esfUserId, String actionId) throws PrincipalException {
		if(!contains(permissionChecker, groupId, esfUserId, actionId)) {
			throw new PrincipalException();
		}
	}
	
	public static boolean contains(PermissionChecker permissionChecker, long groupId, long esfUserId, String actionId) {
		return permissionChecker.hasPermission(groupId, RESOURCE_NAME, esfUserId, actionId);
	}
}
