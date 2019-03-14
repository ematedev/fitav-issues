package it.ethica.esf.permission;


import com.ethica.esf.model.ESFStockist;
import com.ethica.esf.service.ESFStockistLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;

public class ESFStokistPermission {
	
	public static void check(
			PermissionChecker permissionChecker, long esfStockistId, long groupId, String actionId)
			throws PrincipalException, PortalException, SystemException {

			if (!contains(permissionChecker, esfStockistId, groupId, actionId)) {
				throw new PrincipalException();
			}
		}

		public static boolean contains(
			PermissionChecker permissionChecker, long esfStockistId, long groupId, String actionId)
			throws PortalException, SystemException {

			ESFStockist esfstokist =
					ESFStockistLocalServiceUtil.fetchESFStockist(esfStockistId);

			return permissionChecker.hasPermission(
					groupId, ESFStockist.class.getName(),
					esfstokist.getEsfStockistId(), actionId);
		}
}
