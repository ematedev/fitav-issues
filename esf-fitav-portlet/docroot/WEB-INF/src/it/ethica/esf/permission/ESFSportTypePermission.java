package it.ethica.esf.permission;


import it.ethica.esf.model.ESFSportType;
import it.ethica.esf.service.ESFSportTypeLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;

public class ESFSportTypePermission {

	public static final String RESOURCE_NAME = "it.ethica.esf.model.esfsporttype";
	
	public static void check(PermissionChecker permissionChecker, long esfSportTypeId, long groupId, String actionId)
			throws PortalException, SystemException {

		if (!contains(permissionChecker, esfSportTypeId, groupId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(PermissionChecker permissionChecker, long esfSportTypeId, long groupId, String actionId)
			throws PortalException, SystemException {

		ESFSportType esfSportType = ESFSportTypeLocalServiceUtil.fetchESFSportType(esfSportTypeId);

		return permissionChecker.hasPermission(groupId, RESOURCE_NAME,
				esfSportType.getEsfSportTypeId(), actionId);

	}
}
