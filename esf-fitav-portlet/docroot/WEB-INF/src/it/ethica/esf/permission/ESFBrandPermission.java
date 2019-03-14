package it.ethica.esf.permission;


import it.ethica.esf.model.ESFBrand;
import it.ethica.esf.service.ESFBrandLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;

public class ESFBrandPermission {
	
	public static final String RESOURCE_NAME = "it.ethica.esf.model.esfbrand";
	
	public static void check(PermissionChecker permissionChecker, long brandId, long groupId, String actionId)
			throws PortalException, SystemException {

		if (!contains(permissionChecker, brandId, groupId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(PermissionChecker permissionChecker, long brandId, long groupId, String actionId)
			throws PortalException, SystemException {

		ESFBrand esfBrand = ESFBrandLocalServiceUtil.fetchESFBrand(brandId);

		return permissionChecker.hasPermission(groupId, RESOURCE_NAME,
				esfBrand.getBrandId(), actionId);

	}

}
