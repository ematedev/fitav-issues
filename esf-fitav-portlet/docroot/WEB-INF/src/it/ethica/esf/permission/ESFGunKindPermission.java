package it.ethica.esf.permission;

import it.ethica.esf.model.ESFGunKind;
import it.ethica.esf.service.ESFGunKindLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;

public class ESFGunKindPermission {
	public static void check(PermissionChecker permissionChecker,
			long esfGunKindId, String actionId) throws PortalException,
			SystemException {

		if (!contains(permissionChecker, esfGunKindId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(PermissionChecker permissionChecker,
			long esfGunKindId, String actionId) throws PortalException,
			SystemException {

		ESFGunKind esfGunKind = ESFGunKindLocalServiceUtil
				.getESFGunKind(esfGunKindId);

		return permissionChecker.hasPermission(esfGunKind.getGroupId(),
				ESFGunKind.class.getName(), esfGunKind.getEsfGunKindId(),
				actionId);

	}
}
