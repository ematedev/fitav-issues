package it.ethica.esf.permission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;

import it.ethica.esf.model.ESFMatch;
import it.ethica.esf.service.ESFMatchLocalServiceUtil;

public class ESFNationalMatchPermission {

	public static final String RESOURCE_NAME = "it.ethica.esf.model.esfnationalmatch";
	
	public static void check(PermissionChecker permissionChecker, long esfOrganizationId, String actionId)
			throws PortalException, SystemException {

		if (!contains(permissionChecker, esfOrganizationId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(PermissionChecker permissionChecker, long esfMatchId, String actionId)
			throws PortalException, SystemException {

		ESFMatch esfMatch = ESFMatchLocalServiceUtil.fetchESFMatch(esfMatchId);

		return permissionChecker.hasPermission(esfMatch.getGroupId(), RESOURCE_NAME,
				esfMatch.getEsfMatchId(), actionId);

	}
}
