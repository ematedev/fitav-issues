package it.ethica.esf.service.permission;

import it.ethica.esf.model.ESFOrganization;
import it.ethica.esf.model.ESFType;
import it.ethica.esf.service.ESFOrganizationLocalServiceUtil;
import it.ethica.esf.service.ESFTypeLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;

public class ESFTypePermission {

	public static void check(PermissionChecker permissionChecker,
            long esfTypeId, String actionId) throws PortalException,
            SystemException {

        if (!contains(permissionChecker, esfTypeId, actionId)) {
            throw new PrincipalException();
        }
    }

    public static boolean contains(PermissionChecker permissionChecker,
            long esfTypeId, String actionId) throws PortalException,
            SystemException {

        ESFType esfType = ESFTypeLocalServiceUtil.getESFType(esfTypeId);

        return permissionChecker
                .hasPermission(esfType.getGroupId(),
                		ESFType.class.getName(), esfTypeId,
                        actionId);

    }	
    
}
