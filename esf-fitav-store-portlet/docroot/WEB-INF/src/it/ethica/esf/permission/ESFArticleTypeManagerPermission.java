package it.ethica.esf.permission;

import com.ethica.esf.model.ESFArticleType;
import com.ethica.esf.service.ESFArticleTypeLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;

public class ESFArticleTypeManagerPermission {
	
	public static void check(
			PermissionChecker permissionChecker, long esfArticolTypeId, long groupId, String actionId)
			throws PrincipalException, PortalException, SystemException {

			if (!contains(permissionChecker, esfArticolTypeId, groupId, actionId)) {
				throw new PrincipalException();
			}
		}

		public static boolean contains(
			PermissionChecker permissionChecker, long esfArticolTypeId, long groupId, String actionId)
			throws PortalException, SystemException {

			ESFArticleType esfarticolType =
					ESFArticleTypeLocalServiceUtil.fetchESFArticleType(esfArticolTypeId);

			return permissionChecker.hasPermission(
					groupId, ESFArticleType.class.getName(),
					esfarticolType.getEsfArticleTypeId(), actionId);
		}

}
