package it.ethica.esf.permission;

import it.ethica.esf.model.ESFMatchType;
import it.ethica.esf.service.ESFMatchTypeLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;

public class ESFMatchTypePermission {
	
	public static final String RESOURCE_NAME = "it.ethica.esf.model.esfmatchtype";
	
	public static void check(PermissionChecker permissionChecker, long esfMatchTypeId, long groupId, String actionId)
			throws PortalException, SystemException {

		if (!contains(permissionChecker, esfMatchTypeId, groupId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(PermissionChecker permissionChecker, long esfMatchTypeId, long groupId, String actionId)
			throws PortalException, SystemException {

		ESFMatchType esfMatchType = ESFMatchTypeLocalServiceUtil.fetchESFMatchType(esfMatchTypeId);

		return permissionChecker.hasPermission(groupId, RESOURCE_NAME,
				esfMatchType.getEsfMatchTypeId(), actionId);

	}

}
