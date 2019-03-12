package it.ethica.esf.permission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;

import it.ethica.esf.model.ESFCard;
import it.ethica.esf.model.ESFOrganization;
import it.ethica.esf.service.ESFOrganizationLocalServiceUtil;

public class ESFCardPermission {
	public static void check(PermissionChecker permissionChecker, long esfOrganizationId, String actionId)
			throws PortalException, SystemException {

		if (!contains(permissionChecker, esfOrganizationId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(PermissionChecker permissionChecker, long esfOrganizationId, String actionId)
			throws PortalException, SystemException {

		ESFOrganization esfOrganization = ESFOrganizationLocalServiceUtil.getESFOrganization(esfOrganizationId);

		return permissionChecker.hasPermission(esfOrganization.getGroupId(), ESFCard.class.getName(),
				esfOrganization.getEsfOrganizationId(), actionId);

	}
}
