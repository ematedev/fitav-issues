/**
 * 
 */

package it.ethica.esf.permission;

import it.ethica.esf.model.ESFTool;
import it.ethica.esf.service.ESFToolLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;

/**
 * @author Antonio
 */
public class ESFToolPermission {

	public static void check(
		PermissionChecker permissionChecker, long esfToolId, String actionId)
		throws PortalException, SystemException {

		if (!contains(permissionChecker, esfToolId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(
		PermissionChecker permissionChecker, long esfToolId, String actionId)
		throws PortalException, SystemException {

		ESFTool esfTool=
			ESFToolLocalServiceUtil.getESFTool(esfToolId);

		return permissionChecker.hasPermission(
			esfTool.getGroupId(), ESFTool.class.getName(),
			esfTool.getEsfToolId(), actionId);

	}
}
