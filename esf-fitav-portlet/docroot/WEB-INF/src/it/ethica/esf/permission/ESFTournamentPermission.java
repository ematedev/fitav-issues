
package it.ethica.esf.permission;

import it.ethica.esf.model.ESFTournament;
import it.ethica.esf.service.ESFTournamentLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;

public class ESFTournamentPermission {

	public static void check(
		PermissionChecker permissionChecker, long esfTournamentId,
		String actionId)
		throws PortalException, SystemException {

		if (!contains(permissionChecker, esfTournamentId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(
		PermissionChecker permissionChecker, long esfTournamentId,
		String actionId)
		throws PortalException, SystemException {

		ESFTournament esfTournament =
			ESFTournamentLocalServiceUtil.getESFTournament(esfTournamentId);

		return permissionChecker.hasPermission(
			esfTournament.getGroupId(), ESFTournament.class.getName(),
			esfTournament.getEsfTournamentId(), actionId);

	}
}
