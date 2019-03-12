
package it.ethica.esf.util;

public class CustomQuery {

	public final static String FINDALLUSFUSERBY_NAME_OSTATE =
		"Select * from user_ u, esfuser eu where u.lastName like 'LNVAR%' "
		+"and u.firstName like 'FNVAR%' and u.userId in "
		+"(Select esfUserId from esfcard c, esfentitystate e where esforganizationId in "
		+"(select  organizationId from organization_ o where o.treePath LIKE '%OIDVAR%') and "
		+"e.esfStateId = EVAR  and c.esfcardId = e.classPK and e.endDate is null and "
		+"e.className = 'it.ethica.esf.model.ESFCard' CDCVAR ) and u.userId = eu.esfUserId ";

}
