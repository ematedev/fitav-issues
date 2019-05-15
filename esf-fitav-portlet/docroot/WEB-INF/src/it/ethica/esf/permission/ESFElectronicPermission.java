package it.ethica.esf.permission;

import it.ethica.esf.model.ESFElectronic;
import it.ethica.esf.service.ESFElectronicLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;

public class ESFElectronicPermission {
	
	public static final String RESOURCE_NAME = "it.ethica.esf.model.esfelectronic";
	
	public static void check(PermissionChecker permissionChecker, long esfElectronicId, long groupId, String actionId)
			throws PortalException, SystemException {

		if (!contains(permissionChecker, esfElectronicId, groupId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(PermissionChecker permissionChecker, long esfElectronicId, long groupId, String actionId)
			throws PortalException, SystemException {

		ESFElectronic esfElectronic = ESFElectronicLocalServiceUtil.fetchESFElectronic(esfElectronicId);

		return permissionChecker.hasPermission(groupId, RESOURCE_NAME,
				esfElectronic.getElectronicId(), actionId);

	}

}
