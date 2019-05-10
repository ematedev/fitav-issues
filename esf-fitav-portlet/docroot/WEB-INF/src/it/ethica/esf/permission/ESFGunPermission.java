package it.ethica.esf.permission;

import it.ethica.esf.model.ESFCane;
import it.ethica.esf.model.ESFCatridge;
import it.ethica.esf.model.ESFGun;
import it.ethica.esf.model.ESFGunKind;
import it.ethica.esf.service.ESFCaneLocalServiceUtil;
import it.ethica.esf.service.ESFCatridgeLocalServiceUtil;
import it.ethica.esf.service.ESFGunKindLocalServiceUtil;
import it.ethica.esf.service.ESFGunLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;

public class ESFGunPermission {
	
	public static void checkRifle(PermissionChecker permissionChecker,
			long esfGunId, String actionId) throws PortalException,
			SystemException {

		if (!containsRifle(permissionChecker, esfGunId, actionId)) {
			throw new PrincipalException();
		}
	}
	
	public static void checkCane(PermissionChecker permissionChecker,
			long esfGunId, String actionId) throws PortalException,
			SystemException {

		if (!containsCane(permissionChecker, esfGunId, actionId)) {
			throw new PrincipalException();
		}
	}
	
	public static void checkCatridge(PermissionChecker permissionChecker,
			long esfGunId, long groupId,String actionId) throws PortalException,
			SystemException {

		if (!containsCatridge(permissionChecker, esfGunId, groupId , actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean containsRifle(PermissionChecker permissionChecker,
			long esfGunKindId, String actionId) throws PortalException,
			SystemException {

		ESFGunKind esfGunKind = ESFGunKindLocalServiceUtil
				.getESFGunKind(esfGunKindId);

		return permissionChecker
				.hasPermission(esfGunKind.getGroupId(),
						ESFGun.class.getName(), esfGunKind.getEsfGunKindId(),
						actionId);

	}
	
	public static boolean containsCane(PermissionChecker permissionChecker,
			long esfCaneId, String actionId) throws PortalException,
			SystemException {

		ESFCane esfCane = ESFCaneLocalServiceUtil
				.getESFCane(esfCaneId);

		return permissionChecker
				.hasPermission(esfCane.getEsfOrganizationId(),
						ESFGun.class.getName(), esfCane.getEsfCaneId(),
						actionId);

	}
	
	public static boolean containsCatridge(PermissionChecker permissionChecker,
			long esfCatridgeId,long groupId ,String actionId) throws PortalException,
			SystemException {

		ESFCatridge esfCatridge = ESFCatridgeLocalServiceUtil
				.getESFCatridge(esfCatridgeId);

		return permissionChecker
				.hasPermission(groupId,
						ESFGun.class.getName(), esfCatridge.getEsfCatridgeId(),
						actionId);

	}
}
