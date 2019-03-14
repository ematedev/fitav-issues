package it.ethica.esf.service.permission;

import it.ethica.esf.model.ESFOrganization;
import it.ethica.esf.service.ESFOrganizationLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;

public class ESFOrganizationPermission {
	
	public static void check(PermissionChecker permissionChecker,
            long esfOrganizationId, String actionId) throws PortalException,
            SystemException {

        if (!contains(permissionChecker, esfOrganizationId, actionId)) {
            throw new PrincipalException();
        }
    }

    public static boolean contains(PermissionChecker permissionChecker,
            long esfOrganizationId, String actionId) throws PortalException,
            SystemException {

        ESFOrganization esfOrganization = ESFOrganizationLocalServiceUtil.getESFOrganization(esfOrganizationId);

        return permissionChecker
                .hasPermission(esfOrganization.getGroupId(),
                		ESFOrganization.class.getName(), esfOrganizationId,
                        actionId);

    }	

}
