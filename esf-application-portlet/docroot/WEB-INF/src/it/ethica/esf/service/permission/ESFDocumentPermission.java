package it.ethica.esf.service.permission;

import it.ethica.esf.model.ESFDocument;
import it.ethica.esf.service.ESFDocumentLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;

public class ESFDocumentPermission {
	
	public static void check(PermissionChecker permissionChecker,
            long esfDocumentId, String actionId) throws PortalException,
            SystemException {

        if (!contains(permissionChecker, esfDocumentId, actionId)) {
            throw new PrincipalException();
        }
    }

    public static boolean contains(PermissionChecker permissionChecker,
            long esfDocumentId, String actionId) throws PortalException,
            SystemException {

        ESFDocument esfDocument = ESFDocumentLocalServiceUtil.getESFDocument(esfDocumentId);

        return permissionChecker
                .hasPermission(esfDocument.getGroupId(),
                		ESFDocument.class.getName(), esfDocumentId,
                        actionId);

    }		
		
}
