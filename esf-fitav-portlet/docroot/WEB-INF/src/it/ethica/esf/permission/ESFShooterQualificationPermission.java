package it.ethica.esf.permission;

import it.ethica.esf.model.ESFShooterQualification;
import it.ethica.esf.service.ESFShooterQualificationLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;

public class ESFShooterQualificationPermission {
	
public static final String RESOURCE_NAME = "it.ethica.esf.model.esfshooterqualification";
	
	public static void check(PermissionChecker permissionChecker, long esfSQId, long groupId, String actionId)
			throws PortalException, SystemException {

		if (!contains(permissionChecker, esfSQId, groupId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(PermissionChecker permissionChecker, long esfSQId, long groupId, String actionId)
			throws PortalException, SystemException {

		ESFShooterQualification esfSQ = ESFShooterQualificationLocalServiceUtil.fetchESFShooterQualification(esfSQId);

		return permissionChecker.hasPermission(groupId, RESOURCE_NAME,
				esfSQ.getEsfShooterQualificationId(), actionId);

	}


}
