package it.ethica.esf.permission;

import it.ethica.esf.model.ESFField;
import it.ethica.esf.service.ESFFieldLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;

public class ESFFieldPermission {
	public static void check(PermissionChecker permissionChecker,
			long esfFieldId, String actionId) throws PortalException,
			SystemException {

		if (!contains(permissionChecker, esfFieldId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(PermissionChecker permissionChecker,
			long esfFieldId, String actionId) throws PortalException,
			SystemException {

		ESFField esfField = ESFFieldLocalServiceUtil.getESFField(esfFieldId);

		return permissionChecker.hasPermission(esfField.getGroupId(),
				ESFField.class.getName(), esfField.getEsfFieldId(),
				actionId);

	}
}
