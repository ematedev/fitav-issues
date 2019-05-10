package it.ethica.esf.permission;


import it.ethica.esf.model.ESFState;
import it.ethica.esf.service.ESFStateLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;

public class ESFConfigurationStatePermission {
	
	public static final String RESOURCE_NAME = "it.ethica.esf.model.ESFConfigurationState";
	
	public static void check(PermissionChecker permissionChecker, long esfStateId, long groupId, String actionId)
			throws PortalException, SystemException {

		if (!contains(permissionChecker, esfStateId, groupId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(PermissionChecker permissionChecker, long esfStateId, long groupId, String actionId)
			throws PortalException, SystemException {

		ESFState esfState = ESFStateLocalServiceUtil.fetchESFState(esfStateId);

		return permissionChecker.hasPermission(groupId, RESOURCE_NAME,
				esfState.getEsfStateId(), actionId);

	}

}
