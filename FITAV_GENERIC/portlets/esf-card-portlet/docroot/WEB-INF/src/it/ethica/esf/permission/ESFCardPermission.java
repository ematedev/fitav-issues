
package it.ethica.esf.permission;
import it.ethica.esf.model.ESFCard;
import it.ethica.esf.service.ESFCardLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;

public class ESFCardPermission {

	public static void check(
		PermissionChecker permissionChecker, long esfCardId, String actionId)
		throws PortalException, SystemException {

		if (!contains(permissionChecker, esfCardId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(
		PermissionChecker permissionChecker, long esfCardId, String actionId)
		throws PortalException, SystemException {

		ESFCard esfCard=
			ESFCardLocalServiceUtil.getESFCard(esfCardId);

		return permissionChecker.hasPermission(
			esfCard.getGroupId(), ESFCard.class.getName(),
			esfCard.getEsfCardId(), actionId);

	}
}
