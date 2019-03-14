package it.ethica.esf.permission;

import it.ethica.esf.model.ESFGun;
import it.ethica.esf.service.ESFGunLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;

public class ESFGunPermission {
	public static void check(PermissionChecker permissionChecker,
			long esfFieldId, String actionId) throws PortalException,
			SystemException {

		if (!contains(permissionChecker, esfFieldId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(PermissionChecker permissionChecker,
			long esfGunId, String actionId) throws PortalException,
			SystemException {

		ESFGun esfGun = ESFGunLocalServiceUtil
				.getESFGun(esfGunId);

		return permissionChecker
				.hasPermission(esfGun.getGroupId(),
						ESFGun.class.getName(), esfGun.getEsfGunId(),
						actionId);

	}
}
