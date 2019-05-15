package it.ethica.esf.permission;


import it.ethica.esf.model.ESFShooterCategory;
import it.ethica.esf.service.ESFShooterCategoryLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;

public class ESFShooterCategoryPermission {
	
	public static final String RESOURCE_NAME = "it.ethica.esf.model.ESFShooterCategory";
	
	public static void check(PermissionChecker permissionChecker, long esfOrganizationId, String actionId)
			throws PortalException, SystemException {

		if (!contains(permissionChecker, esfOrganizationId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(PermissionChecker permissionChecker, long esfShooterCategoryId, String actionId)
			throws PortalException, SystemException {

		ESFShooterCategory esfSC = ESFShooterCategoryLocalServiceUtil.fetchESFShooterCategory(esfShooterCategoryId);

		return permissionChecker.hasPermission(esfSC.getGroupId(), RESOURCE_NAME,
				esfSC.getEsfShooterCategoryId(), actionId);

	}

}
