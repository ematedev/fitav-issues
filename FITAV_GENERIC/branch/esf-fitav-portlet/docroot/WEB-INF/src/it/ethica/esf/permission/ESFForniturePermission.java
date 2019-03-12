package it.ethica.esf.permission;

import it.ethica.esf.model.ESFForniture;
import it.ethica.esf.service.ESFFornitureLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;

public class ESFForniturePermission {
	public static void check(PermissionChecker permissionChecker,
			long eSFFornitureId, String actionId) throws PortalException,
			SystemException {

		if (!contains(permissionChecker, eSFFornitureId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(PermissionChecker permissionChecker,
			long eSFFornitureId, String actionId) throws PortalException,
			SystemException {

		ESFForniture eSFForniture = ESFFornitureLocalServiceUtil
				.getESFForniture(eSFFornitureId);

		return permissionChecker.hasPermission(eSFForniture.getGroupId(),
				ESFForniture.class.getName(), eSFForniture.getEsfFornitureId(),
				actionId);

	}
}
