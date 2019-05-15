package it.ethica.esf.permission;


import it.ethica.esf.model.ESFGunType;
import it.ethica.esf.service.ESFGunTypeLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;

public class ESFGunCategorizationPermission {
	
	public static final String RESOURCE_NAME = "it.ethica.esf.model.ESFGunCategorizationPortlet";
	
	public static void check(PermissionChecker permissionChecker, long esfGuuTypeId, String actionId)
			throws PortalException, SystemException {

		if (!contains(permissionChecker, esfGuuTypeId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(PermissionChecker permissionChecker, long esfGunTypeId, String actionId)
			throws PortalException, SystemException {

		ESFGunType gunType = ESFGunTypeLocalServiceUtil.fetchESFGunType(esfGunTypeId);

		return permissionChecker.hasPermission(gunType.getGroupId(), RESOURCE_NAME,
				gunType.getEsfGunTypeId(), actionId);

	}

}
