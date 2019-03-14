package it.ethica.esf.permission;

import com.ethica.esf.model.ESFArticle;
import com.ethica.esf.service.ESFArticleLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;

public class ESFArticleManagerPermission {
	
		public static void check(
				PermissionChecker permissionChecker, long esfArticleId, long groupId, String actionId)
				throws PrincipalException, PortalException, SystemException {

				if (!contains(permissionChecker, esfArticleId, groupId, actionId)) {
					throw new PrincipalException();
				}
			}

			public static boolean contains(
				PermissionChecker permissionChecker, long esfArticleId, long groupId, String actionId)
				throws PortalException, SystemException {

				ESFArticle esfarticle =
						ESFArticleLocalServiceUtil.fetchESFArticle(esfArticleId);

				return permissionChecker.hasPermission(
						groupId, ESFArticle.class.getName(),
						esfarticle.getEsfArticleId(), actionId);
			}
			
}
