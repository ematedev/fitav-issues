package it.ethica.esf.permission;

import it.ethica.esf.model.ESFFornitureType;
import it.ethica.esf.service.ESFFornitureTypeLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;

public class ESFFornitureTypePermission {
	public static void check(PermissionChecker permissionChecker,
			long eSFFornitureTypeId, String actionId) throws PortalException,
			SystemException {

		if (!contains(permissionChecker, eSFFornitureTypeId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(PermissionChecker permissionChecker,
			long eSFFornitureTypeId, String actionId) throws PortalException,
			SystemException {

		ESFFornitureType eSFFornitureType = ESFFornitureTypeLocalServiceUtil
				.getESFFornitureType(eSFFornitureTypeId);

		return permissionChecker.hasPermission(eSFFornitureType.getGroupId(),
				ESFFornitureType.class.getName(), eSFFornitureType.getEsfFornitureTypeId(),
				actionId);

	}
}
