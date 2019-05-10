
package it.ethica.esf.permission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;

import it.ethica.esf.model.ESFOrganization;
import it.ethica.esf.service.ESFOrganizationLocalServiceUtil;

public class ESFSportAssociationPermission {

	public static final String RESOURCE_NAME = "it.ethica.esf.model.esfsportassociation";

	public static void check(
		PermissionChecker permissionChecker, long esfOrganizationId,
		String actionId)
		throws PortalException, SystemException {

		if (!contains(permissionChecker, esfOrganizationId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(	PermissionChecker permissionChecker,
			long esfOrganizationId,String actionId)
		throws PortalException, SystemException {

		ESFOrganization esfOrganization =
			ESFOrganizationLocalServiceUtil.getESFOrganization(esfOrganizationId);
		
		return permissionChecker.hasPermission(
				esfOrganization.getGroupId(),RESOURCE_NAME,esfOrganization.getEsfOrganizationId(), actionId);

	}
}
