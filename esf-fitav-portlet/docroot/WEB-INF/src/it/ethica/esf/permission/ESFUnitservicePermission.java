package it.ethica.esf.permission;

import it.ethica.esf.model.ESFUnitservice;
import it.ethica.esf.service.ESFUnitserviceLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;

public class ESFUnitservicePermission {
	
	public static final String RESOURCE_NAME = "it.ethica.esf.model.ESFUnitservice";
	
	public static void check(PermissionChecker permissionChecker,
			long esfUnitserviceId, long groupId, String actionId) throws PortalException,
			SystemException {

		if (!contains(permissionChecker, esfUnitserviceId, groupId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(PermissionChecker permissionChecker,
			long esfUnitserviceId, long groupId, String actionId) throws PortalException,
			SystemException {

		ESFUnitservice esfUnitservice = ESFUnitserviceLocalServiceUtil.getESFUnitservice(esfUnitserviceId);

		return permissionChecker.hasPermission(groupId,
				ESFUnitservice.class.getName(), esfUnitservice.getEsfUnitserviceId(),
				actionId);

	}

}
