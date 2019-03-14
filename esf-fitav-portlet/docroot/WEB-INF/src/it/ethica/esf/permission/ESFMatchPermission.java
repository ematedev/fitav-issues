package it.ethica.esf.permission;

import it.ethica.esf.model.ESFMatch;
import it.ethica.esf.service.ESFMatchLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;


public class ESFMatchPermission {

	public static void check(
		PermissionChecker permissionChecker, long esfMatchId,
		String actionId)
		throws PortalException, SystemException {

		if (!contains(permissionChecker, esfMatchId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(
		PermissionChecker permissionChecker, long esfMatchId,
		String actionId)
		throws PortalException, SystemException {

		ESFMatch esfMatch =
			ESFMatchLocalServiceUtil.getESFMatch(esfMatchId);

		return permissionChecker.hasPermission(
			esfMatch.getGroupId(), ESFMatch.class.getName(),
			esfMatch.getEsfMatchId(), actionId);

	}
}
