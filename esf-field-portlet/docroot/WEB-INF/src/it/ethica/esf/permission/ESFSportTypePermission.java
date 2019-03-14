package it.ethica.esf.permission;

import it.ethica.esf.model.ESFSportType;
import it.ethica.esf.service.ESFSportTypeLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;

public class ESFSportTypePermission {
	public static void check(PermissionChecker permissionChecker,
			long esfSportTypeId, String actionId) throws PortalException,
			SystemException {

		if (!contains(permissionChecker, esfSportTypeId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(PermissionChecker permissionChecker,
			long esfSportTypeId, String actionId) throws PortalException,
			SystemException {

		ESFSportType esfSportType = ESFSportTypeLocalServiceUtil
				.getESFSportType(esfSportTypeId);

		return permissionChecker.hasPermission(esfSportType.getGroupId(),
				ESFSportType.class.getName(), esfSportType.getEsfSportTypeId(),
				actionId);

	}
}
