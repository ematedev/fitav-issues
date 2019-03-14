
package it.ethica.esf.permission;

import it.ethica.esf.model.ESFAddress;
import it.ethica.esf.service.ESFAddressLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;

public class ESFAddressPermission {

	public static void check(
		PermissionChecker permissionChecker, long esfAddressId, String actionId)
		throws PortalException, SystemException {

		if (!contains(permissionChecker, esfAddressId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(
		PermissionChecker permissionChecker, long esfAddressId, String actionId)
		throws PortalException, SystemException {
		
		ESFAddress esfAddress = ESFAddressLocalServiceUtil.getESFAddress(esfAddressId);

		return permissionChecker.hasPermission(
			esfAddress.getGroupId(), ESFAddress.class.getName(),
			esfAddress.getEsfAddressId(), actionId);

	}
}
