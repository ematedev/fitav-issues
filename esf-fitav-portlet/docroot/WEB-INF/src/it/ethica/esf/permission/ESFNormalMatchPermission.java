package it.ethica.esf.permission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;

import it.ethica.esf.model.ESFMatch;
import it.ethica.esf.service.ESFMatchLocalServiceUtil;

public class ESFNormalMatchPermission {

	public static final String RESOURCE_NAME = "it.ethica.esf.model.esfnormalmatch";
	
	public static void check(PermissionChecker permissionChecker, long esfOrganizationId, String actionId)
			throws PortalException, SystemException {

		if (!contains(permissionChecker, esfOrganizationId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(PermissionChecker permissionChecker, long esfMatchId, String actionId)
			throws PortalException, SystemException {

		/** ID 34 2019
		 * // TODO GRINALDI - Se non hai creato la Gara il matchID = 0
		 * 	altrimenti non e' possibile aggiungere tipo e descrizione
		 * durante la creazione della GARA
		 */
		boolean hasPermission = ( esfMatchId == 0 );
		
		if ( ! hasPermission ) {
			ESFMatch esfMatch = ESFMatchLocalServiceUtil.fetchESFMatch(esfMatchId);
	
			hasPermission = permissionChecker.hasPermission(esfMatch.getGroupId(), RESOURCE_NAME,
					esfMatch.getEsfMatchId(), actionId);
			}
		return hasPermission;
	}
}
