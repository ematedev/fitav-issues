package it.ethica.esf.permission;

import it.ethica.esf.model.ESFGunType;
import it.ethica.esf.service.ESFGunTypeLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;

public class ESFGunTypePermission {
	public static void check(PermissionChecker permissionChecker,
			long esfGunTypeId, String actionId) throws PortalException,
			SystemException {

		if (!contains(permissionChecker, esfGunTypeId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(PermissionChecker permissionChecker,
			long esfGunTypeId, String actionId) throws PortalException,
			SystemException {

		ESFGunType esfGunType = ESFGunTypeLocalServiceUtil
				.getESFGunType(esfGunTypeId);

		return permissionChecker.hasPermission(esfGunType.getGroupId(),
				ESFGunType.class.getName(), esfGunType.getEsfGunTypeId(),
				actionId);

	}
}
