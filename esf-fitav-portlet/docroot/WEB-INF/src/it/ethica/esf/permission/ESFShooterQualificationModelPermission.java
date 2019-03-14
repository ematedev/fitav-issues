package it.ethica.esf.permission;


import it.ethica.esf.model.ESFShooterQualification;
import it.ethica.esf.service.ESFShooterQualificationLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;

public class ESFShooterQualificationModelPermission {
	
	public static final String RESOURCE_NAME = "it.ethica.esf.model.esfshooterqualificationmodel";

	public static void check(PermissionChecker permissionChecker, long groupId,	String actionId) throws PortalException {

		if (!contains(permissionChecker, groupId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(PermissionChecker permissionChecker,
			long groupId, String actionId) {

		return permissionChecker.hasPermission(groupId, RESOURCE_NAME, groupId,
				actionId);
	}
	
}
