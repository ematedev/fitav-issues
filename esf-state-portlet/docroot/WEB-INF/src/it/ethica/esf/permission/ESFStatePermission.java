package it.ethica.esf.permission;
import it.ethica.esf.model.ESFState;
import it.ethica.esf.service.ESFStateLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;


public class ESFStatePermission {
	
	public static void check(
		PermissionChecker permissionChecker, long esfStateId, String actionId)
		throws PortalException, SystemException {

		if (!contains(permissionChecker, esfStateId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(
		PermissionChecker permissionChecker, long esfStateId, String actionId)
		throws PortalException, SystemException {

		ESFState esfState=
			ESFStateLocalServiceUtil.getESFState(esfStateId);

		return permissionChecker.hasPermission(
			esfState.getGroupId(), ESFState.class.getName(),
			esfState.getEsfStateId(), actionId);

	}
}
