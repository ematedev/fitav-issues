package it.ethica.esf.permission;


import it.ethica.esf.model.ESFDescription;
import it.ethica.esf.service.ESFDescriptionLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;

public class ESFDescriptionPermission {
	
	public static final String RESOURCE_NAME = "it.ethica.esf.model.esfdescription";
	
	public static void check(PermissionChecker permissionChecker, long esfDescriptionId, long groupId, String actionId)
			throws PortalException, SystemException {

		if (!contains(permissionChecker, esfDescriptionId, groupId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(PermissionChecker permissionChecker, long esfDescriptionId, long groupId, String actionId)
			throws PortalException, SystemException {

		ESFDescription description = ESFDescriptionLocalServiceUtil.fetchESFDescription(esfDescriptionId);

		return permissionChecker.hasPermission(groupId, RESOURCE_NAME,
				description.getEsfDescriptionId(), actionId);

	}

}
