/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package it.ethica.esf.service;

import com.liferay.portal.service.InvokableLocalService;

/**
 * @author Ethica
 * @generated
 */
public class ESFUserLocalServiceClp implements ESFUserLocalService {
	public ESFUserLocalServiceClp(InvokableLocalService invokableLocalService) {
		_invokableLocalService = invokableLocalService;

		_methodName0 = "addESFUser";

		_methodParameterTypes0 = new String[] { "it.ethica.esf.model.ESFUser" };

		_methodName1 = "createESFUser";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteESFUser";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteESFUser";

		_methodParameterTypes3 = new String[] { "it.ethica.esf.model.ESFUser" };

		_methodName4 = "dynamicQuery";

		_methodParameterTypes4 = new String[] {  };

		_methodName5 = "dynamicQuery";

		_methodParameterTypes5 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName6 = "dynamicQuery";

		_methodParameterTypes6 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int"
			};

		_methodName7 = "dynamicQuery";

		_methodParameterTypes7 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName8 = "dynamicQueryCount";

		_methodParameterTypes8 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName9 = "dynamicQueryCount";

		_methodParameterTypes9 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery",
				"com.liferay.portal.kernel.dao.orm.Projection"
			};

		_methodName10 = "fetchESFUser";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getESFUser";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getESFUsers";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getESFUsersCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateESFUser";

		_methodParameterTypes15 = new String[] { "it.ethica.esf.model.ESFUser" };

		_methodName16 = "getBeanIdentifier";

		_methodParameterTypes16 = new String[] {  };

		_methodName17 = "setBeanIdentifier";

		_methodParameterTypes17 = new String[] { "java.lang.String" };

		_methodName19 = "getESFUsersByDeparture";

		_methodParameterTypes19 = new String[] { "long" };

		_methodName20 = "getESFUsersByCodeCode";

		_methodParameterTypes20 = new String[] { "java.lang.String" };

		_methodName21 = "getESFUserByUserCode";

		_methodParameterTypes21 = new String[] { "long" };

		_methodName22 = "getESFUserByCodeUser2";

		_methodParameterTypes22 = new String[] { "long" };

		_methodName23 = "getESFUserByFirstName_LastName_FiscalCode_NotPartecipants";

		_methodParameterTypes23 = new String[] {
				"long", "java.lang.String", "java.lang.String",
				"java.lang.String", "int", "long"
			};

		_methodName24 = "getESFUserByFirstName_LastName_FiscalCode_NotPartecipants";

		_methodParameterTypes24 = new String[] {
				"long", "java.lang.String", "java.lang.String",
				"java.lang.String", "int", "long", "int", "int"
			};

		_methodName25 = "getESFUserByFirstName_LastName_FiscalCode";

		_methodParameterTypes25 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"int", "long", "int", "int"
			};

		_methodName26 = "getESFUserByFiscalCode";

		_methodParameterTypes26 = new String[] { "java.lang.String" };

		_methodName27 = "getAllUserByLikeF_L";

		_methodParameterTypes27 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"int", "int"
			};

		_methodName28 = "countAllUserByLikeF_L";

		_methodParameterTypes28 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String"
			};

		_methodName29 = "getAllUserByLikeF_L_S";

		_methodParameterTypes29 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"int", "int", "int"
			};

		_methodName30 = "getAllUserByLikeF_L_S";

		_methodParameterTypes30 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"int"
			};

		_methodName31 = "getAllUserByLikeF_C_S";

		_methodParameterTypes31 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"int", "long", "int", "int"
			};

		_methodName32 = "getAllUserByLikeF_C_S";

		_methodParameterTypes32 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"int", "long"
			};

		_methodName33 = "getShooterByStateAndOrganization";

		_methodParameterTypes33 = new String[] { "int", "long" };

		_methodName34 = "getAllShooterByLikeF_C_S";

		_methodParameterTypes34 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"long", "int", "int"
			};

		_methodName35 = "getAllShooterByLikeF_C_S";

		_methodParameterTypes35 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"long"
			};

		_methodName36 = "getAllEsfUserByState";

		_methodParameterTypes36 = new String[] { "int" };

		_methodName37 = "getAllEsfUserByState";

		_methodParameterTypes37 = new String[] { "int", "int", "int" };

		_methodName38 = "findUserByRoleT_N_S";

		_methodParameterTypes38 = new String[] {
				"java.lang.String", "java.lang.String", "int"
			};

		_methodName39 = "findAllShooters";

		_methodParameterTypes39 = new String[] { "int", "int" };

		_methodName40 = "findAllShooters";

		_methodParameterTypes40 = new String[] { "long", "int", "int" };

		_methodName41 = "findAllShooters";

		_methodParameterTypes41 = new String[] {
				"long", "int", "int", "int", "int"
			};

		_methodName42 = "findRoledUserOrganization";

		_methodParameterTypes42 = new String[] { "long" };

		_methodName43 = "findRoledUserOrganization";

		_methodParameterTypes43 = new String[] { "long", "int", "int" };

		_methodName44 = "findAllShootersByLeafOrgAssigned";

		_methodParameterTypes44 = new String[] {
				"long", "int", "long", "int", "int", "int"
			};

		_methodName45 = "findAllShootersByLeafOrgAssignedName";

		_methodParameterTypes45 = new String[] {
				"java.lang.String", "java.lang.String", "long", "int", "long",
				"int", "int", "int"
			};

		_methodName46 = "countAllShootersByLeafOrgAssignedName";

		_methodParameterTypes46 = new String[] {
				"java.lang.String", "java.lang.String", "long", "int", "long",
				"int"
			};

		_methodName47 = "findAllShootersByLeafOrgAssigned";

		_methodParameterTypes47 = new String[] { "long", "int", "long", "int" };

		_methodName48 = "findAllShootersByLeafOrg";

		_methodParameterTypes48 = new String[] { "long", "int", "int" };

		_methodName49 = "findAllShootersByLeafOrg";

		_methodParameterTypes49 = new String[] {
				"long", "int", "int", "int", "int"
			};

		_methodName50 = "finNationalDelegationESFUsersByMatchId";

		_methodParameterTypes50 = new String[] { "long" };

		_methodName51 = "findAllStaff";

		_methodParameterTypes51 = new String[] {
				"java.lang.Long", "java.lang.String", "java.lang.String",
				"java.lang.String", "int", "java.lang.Long", "int", "int"
			};

		_methodName52 = "findAllStaffNamed";

		_methodParameterTypes52 = new String[] {
				"java.lang.Long", "java.lang.String", "java.lang.String",
				"java.lang.String", "int", "java.lang.Long", "int", "int"
			};

		_methodName53 = "findStaffNamed";

		_methodParameterTypes53 = new String[] {
				"long", "java.lang.String", "java.lang.String",
				"java.lang.String"
			};

		_methodName54 = "findStaffNamed";

		_methodParameterTypes54 = new String[] {
				"long", "java.lang.String", "java.lang.String",
				"java.lang.String", "int", "int"
			};

		_methodName55 = "findStaffNamedNational";

		_methodParameterTypes55 = new String[] {
				"long", "java.lang.String", "java.lang.String",
				"java.lang.String"
			};

		_methodName56 = "findStaffNamedNational";

		_methodParameterTypes56 = new String[] {
				"long", "java.lang.String", "java.lang.String",
				"java.lang.String", "int", "int"
			};

		_methodName57 = "findStaff";

		_methodParameterTypes57 = new String[] { "long" };

		_methodName58 = "findStaff";

		_methodParameterTypes58 = new String[] { "long", "int", "int" };

		_methodName59 = "finNationalDelegationESFUsersByMatchId";

		_methodParameterTypes59 = new String[] { "long", "int", "int" };

		_methodName60 = "findNationalDelegationStaffESFUsersByMatchId";

		_methodParameterTypes60 = new String[] { "long" };

		_methodName61 = "findNationalDelegationStaffESFUsersByMatchId";

		_methodParameterTypes61 = new String[] { "long", "int", "int" };

		_methodName62 = "findNationalDelegationsESFUsersByMatchId";

		_methodParameterTypes62 = new String[] { "long" };

		_methodName63 = "findNationalDelegationsESFUsersByMatchId";

		_methodParameterTypes63 = new String[] { "long", "int", "int" };

		_methodName64 = "findNationalDelegationsESFUsersByMatchId_PartecipantTypeId";

		_methodParameterTypes64 = new String[] { "long", "long" };

		_methodName65 = "findNationalDelegationsESFUsersByMatchId_PartecipantTypeId";

		_methodParameterTypes65 = new String[] { "long", "long", "int", "int" };

		_methodName66 = "findNationalShooters";

		_methodParameterTypes66 = new String[] {  };

		_methodName67 = "findNationalShooters";

		_methodParameterTypes67 = new String[] { "int", "int" };

		_methodName68 = "findNationalPartecipantShooters";

		_methodParameterTypes68 = new String[] { "long", "boolean" };

		_methodName69 = "findNationalPartecipantShooters";

		_methodParameterTypes69 = new String[] { "long", "boolean", "int", "int" };

		_methodName70 = "findPartecipantShooters";

		_methodParameterTypes70 = new String[] { "int", "int", "long", "boolean" };

		_methodName71 = "findPartecipantShooters";

		_methodParameterTypes71 = new String[] {
				"int", "int", "long", "boolean", "int", "int"
			};

		_methodName72 = "findNationalPartecipantCoaches";

		_methodParameterTypes72 = new String[] { "long", "boolean" };

		_methodName73 = "findNationalPartecipantCoaches";

		_methodParameterTypes73 = new String[] { "long", "boolean", "int", "int" };

		_methodName74 = "findPartecipantCoaches";

		_methodParameterTypes74 = new String[] { "int", "long", "boolean" };

		_methodName75 = "findPartecipantCoaches";

		_methodParameterTypes75 = new String[] {
				"int", "long", "boolean", "int", "int"
			};

		_methodName76 = "findNationalPartecipantReferees";

		_methodParameterTypes76 = new String[] { "long", "boolean" };

		_methodName77 = "findNationalPartecipantReferees";

		_methodParameterTypes77 = new String[] { "long", "boolean", "int", "int" };

		_methodName78 = "findPartecipantReferees";

		_methodParameterTypes78 = new String[] {
				"int", "long", "boolean", "int", "int"
			};

		_methodName79 = "findPartecipantReferees";

		_methodParameterTypes79 = new String[] { "int", "long", "boolean" };

		_methodName80 = "findNationalPartecipantDoctor";

		_methodParameterTypes80 = new String[] { "long", "boolean" };

		_methodName81 = "findNationalPartecipantDoctor";

		_methodParameterTypes81 = new String[] { "long", "boolean", "int", "int" };

		_methodName82 = "findPartecipantDoctor";

		_methodParameterTypes82 = new String[] { "int", "long", "boolean" };

		_methodName83 = "findPartecipantDoctor";

		_methodParameterTypes83 = new String[] {
				"int", "long", "boolean", "int", "int"
			};

		_methodName84 = "addESFUser";

		_methodParameterTypes84 = new String[] {
				"long", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "int", "int", "int", "boolean",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "it.ethica.esf.model.ESFEntityState",
				"java.util.List", "java.util.List", "java.lang.String",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName85 = "addESFUserInOrganization";

		_methodParameterTypes85 = new String[] {
				"long", "java.lang.String", "java.lang.String",
				"java.lang.String", "long", "java.util.Locale",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"int", "int", "boolean", "int", "int", "int", "java.lang.String",
				"it.ethica.esf.model.ESFAddress",
				"it.ethica.esf.model.ESFEntityState", "java.util.List",
				"com.liferay.portal.service.ServiceContext",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName86 = "addESFUserInOrganization";

		_methodParameterTypes86 = new String[] {
				"long", "java.lang.String", "java.lang.String",
				"java.lang.String", "long", "java.util.Locale",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"int", "int", "boolean", "int", "int", "int", "java.lang.String",
				"it.ethica.esf.model.ESFAddress", "long", "java.util.List",
				"com.liferay.portal.service.ServiceContext",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName87 = "deleteESFUser";

		_methodParameterTypes87 = new String[] {
				"long", "java.util.List",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName88 = "updateESFUser";

		_methodParameterTypes88 = new String[] {
				"long", "long", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "int", "int", "int", "boolean", "boolean",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "it.ethica.esf.model.ESFEntityState",
				"java.util.List", "java.util.List", "java.lang.String",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName89 = "addESFShooter";

		_methodParameterTypes89 = new String[] {
				"long", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "int", "int", "int", "java.lang.String",
				"java.lang.String", "boolean", "java.lang.String",
				"java.lang.String", "java.lang.String", "long", "boolean",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"it.ethica.esf.model.ESFEntityState",
				"it.ethica.esf.model.ESFCard", "java.util.List",
				"java.util.List", "boolean", "boolean", "boolean",
				"java.util.Date", "java.util.Date", "java.util.Date", "boolean",
				"long", "com.liferay.portal.service.ServiceContext"
			};

		_methodName90 = "updateESFShooter";

		_methodParameterTypes90 = new String[] {
				"long", "long", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "int", "int", "int", "java.lang.String",
				"java.lang.String", "boolean", "boolean", "java.lang.String",
				"java.lang.String", "java.lang.String", "long", "boolean",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"it.ethica.esf.model.ESFEntityState",
				"it.ethica.esf.model.ESFCard", "java.util.List",
				"java.util.List", "java.util.Date", "boolean", "boolean",
				"boolean", "java.util.Date", "java.util.Date", "java.util.Date",
				"boolean", "long", "com.liferay.portal.service.ServiceContext"
			};

		_methodName91 = "updateESFUserToESFShooter";

		_methodParameterTypes91 = new String[] {
				"long", "long", "it.ethica.esf.model.ESFCard", "java.util.List",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName92 = "addESFUserToESFShooter";

		_methodParameterTypes92 = new String[] { "long", "long" };

		_methodName93 = "countByESFUserRole";

		_methodParameterTypes93 = new String[] { "long" };

		_methodName94 = "getESFUserRoles";

		_methodParameterTypes94 = new String[] { "long", "boolean" };

		_methodName95 = "getActiveESFUserRoles";

		_methodParameterTypes95 = new String[] { "long" };

		_methodName96 = "findAllUser";

		_methodParameterTypes96 = new String[] {  };

		_methodName97 = "checkEmailAddress";

		_methodParameterTypes97 = new String[] {
				"java.lang.String", "com.liferay.portal.service.ServiceContext"
			};

		_methodName98 = "checkScreenName";

		_methodParameterTypes98 = new String[] {
				"java.lang.String", "com.liferay.portal.service.ServiceContext"
			};

		_methodName99 = "findAllUserByAgeOnlyPeople";

		_methodParameterTypes99 = new String[] {  };

		_methodName100 = "findAllUserByRolenoNull";

		_methodParameterTypes100 = new String[] { "long", "long" };

		_methodName101 = "findShooterRoleAssignedName";

		_methodParameterTypes101 = new String[] {
				"java.lang.String", "java.lang.String", "long", "long", "int",
				"int"
			};

		_methodName102 = "countShooterRoleAssignedName";

		_methodParameterTypes102 = new String[] {
				"java.lang.String", "java.lang.String", "long", "long"
			};

		_methodName103 = "findStaffMatch";

		_methodParameterTypes103 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"long", "long", "int", "int"
			};

		_methodName104 = "countStaffMatch";

		_methodParameterTypes104 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"long", "long"
			};

		_methodName105 = "findShooterNotAssociated";

		_methodParameterTypes105 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"long", "int", "int"
			};

		_methodName106 = "countNotNationalShooterBySPT";

		_methodParameterTypes106 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"long"
			};

		_methodName107 = "findALLShooterNotAssociated";

		_methodParameterTypes107 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"long", "int", "int"
			};

		_methodName108 = "countALLNotNationalShooterBySPT";

		_methodParameterTypes108 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"long"
			};

		_methodName109 = "findStaffNormalMatch";

		_methodParameterTypes109 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"long", "int", "int"
			};

		_methodName110 = "countStaffNormalMatch";

		_methodParameterTypes110 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"long"
			};

		_methodName111 = "countRenwalUser";

		_methodParameterTypes111 = new String[] {
				"java.lang.String", "java.lang.String", "long"
			};

		_methodName112 = "countNewUser";

		_methodParameterTypes112 = new String[] {
				"java.lang.String", "java.lang.String", "long"
			};

		_methodName113 = "findByKeyword";

		_methodParameterTypes113 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName114 = "findShooterByAss";

		_methodParameterTypes114 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"long", "int", "int"
			};

		_methodName115 = "countShooterByAss";

		_methodParameterTypes115 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"long"
			};

		_methodName116 = "findShooterByAssAndNoAss";

		_methodParameterTypes116 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"long", "int", "int"
			};

		_methodName117 = "countShooterByAssAndNoAss";

		_methodParameterTypes117 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"long"
			};

		_methodName118 = "findDirectorByMatch";

		_methodParameterTypes118 = new String[] {
				"java.lang.String", "java.lang.String", "long", "long", "int",
				"int"
			};

		_methodName119 = "countDirectorByMatch";

		_methodParameterTypes119 = new String[] {
				"java.lang.String", "java.lang.String", "long", "long"
			};

		_methodName120 = "findNewYouthShooter";

		_methodParameterTypes120 = new String[] { "int" };

		_methodName121 = "findYouthByCategory";

		_methodParameterTypes121 = new String[] { "long", "int", "int", "int" };

		_methodName122 = "findYouthByCategoryTotal";

		_methodParameterTypes122 = new String[] { "long", "int" };

		_methodName123 = "findNotBDOMemberByAssociatioId";

		_methodParameterTypes123 = new String[] {
				"java.lang.String", "java.lang.String", "long", "int", "int"
			};

		_methodName124 = "countNotBDOMemberByAssociatioId";

		_methodParameterTypes124 = new String[] {
				"java.lang.String", "java.lang.String", "long"
			};

		_methodName125 = "findAssociatedShooterOrganization";

		_methodParameterTypes125 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"long", "int", "int"
			};

		_methodName126 = "countAssociatedShooterOrganization";

		_methodParameterTypes126 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"long"
			};

		_methodName127 = "findByESFFederalRole";

		_methodParameterTypes127 = new String[] { "long" };
	}

	@Override
	public it.ethica.esf.model.ESFUser addESFUser(
		it.ethica.esf.model.ESFUser esfUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName0,
					_methodParameterTypes0,
					new Object[] { ClpSerializer.translateInput(esfUser) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (it.ethica.esf.model.ESFUser)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public it.ethica.esf.model.ESFUser createESFUser(long esfUserId) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName1,
					_methodParameterTypes1, new Object[] { esfUserId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (it.ethica.esf.model.ESFUser)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public it.ethica.esf.model.ESFUser deleteESFUser(long esfUserId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName2,
					_methodParameterTypes2, new Object[] { esfUserId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (it.ethica.esf.model.ESFUser)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public it.ethica.esf.model.ESFUser deleteESFUser(
		it.ethica.esf.model.ESFUser esfUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName3,
					_methodParameterTypes3,
					new Object[] { ClpSerializer.translateInput(esfUser) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (it.ethica.esf.model.ESFUser)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName4,
					_methodParameterTypes4, new Object[] {  });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.liferay.portal.kernel.dao.orm.DynamicQuery)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName5,
					_methodParameterTypes5,
					new Object[] { ClpSerializer.translateInput(dynamicQuery) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName6,
					_methodParameterTypes6,
					new Object[] {
						ClpSerializer.translateInput(dynamicQuery),
						
					start,
						
					end
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName7,
					_methodParameterTypes7,
					new Object[] {
						ClpSerializer.translateInput(dynamicQuery),
						
					start,
						
					end,
						
					ClpSerializer.translateInput(orderByComparator)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName8,
					_methodParameterTypes8,
					new Object[] { ClpSerializer.translateInput(dynamicQuery) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Long)returnObj).longValue();
	}

	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName9,
					_methodParameterTypes9,
					new Object[] {
						ClpSerializer.translateInput(dynamicQuery),
						
					ClpSerializer.translateInput(projection)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Long)returnObj).longValue();
	}

	@Override
	public it.ethica.esf.model.ESFUser fetchESFUser(long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName10,
					_methodParameterTypes10, new Object[] { esfUserId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (it.ethica.esf.model.ESFUser)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public it.ethica.esf.model.ESFUser getESFUser(long esfUserId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName11,
					_methodParameterTypes11, new Object[] { esfUserId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (it.ethica.esf.model.ESFUser)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName12,
					_methodParameterTypes12,
					new Object[] { ClpSerializer.translateInput(primaryKeyObj) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.liferay.portal.model.PersistedModel)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> getESFUsers(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName13,
					_methodParameterTypes13, new Object[] { start, end });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<it.ethica.esf.model.ESFUser>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public int getESFUsersCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName14,
					_methodParameterTypes14, new Object[] {  });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	@Override
	public it.ethica.esf.model.ESFUser updateESFUser(
		it.ethica.esf.model.ESFUser esfUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName15,
					_methodParameterTypes15,
					new Object[] { ClpSerializer.translateInput(esfUser) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (it.ethica.esf.model.ESFUser)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.String getBeanIdentifier() {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName16,
					_methodParameterTypes16, new Object[] {  });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		try {
			_invokableLocalService.invokeMethod(_methodName17,
				_methodParameterTypes17,
				new Object[] { ClpSerializer.translateInput(beanIdentifier) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		throw new UnsupportedOperationException();
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> getESFUsersByDeparture(
		long esfDepartureId) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName19,
					_methodParameterTypes19, new Object[] { esfDepartureId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<it.ethica.esf.model.ESFUser>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> getESFUsersByCodeCode(
		java.lang.String code) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName20,
					_methodParameterTypes20,
					new Object[] { ClpSerializer.translateInput(code) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<it.ethica.esf.model.ESFUser>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public it.ethica.esf.model.ESFUser getESFUserByUserCode(long userCode)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName21,
					_methodParameterTypes21, new Object[] { userCode });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof it.ethica.esf.NoSuchUserException) {
				throw (it.ethica.esf.NoSuchUserException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (it.ethica.esf.model.ESFUser)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public it.ethica.esf.model.ESFUser getESFUserByCodeUser2(long userCode)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName22,
					_methodParameterTypes22, new Object[] { userCode });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof it.ethica.esf.NoSuchUserException) {
				throw (it.ethica.esf.NoSuchUserException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (it.ethica.esf.model.ESFUser)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> getESFUserByFirstName_LastName_FiscalCode_NotPartecipants(
		long esfMatchId, java.lang.String firstName, java.lang.String lastName,
		java.lang.String fiscalCode, int state, long organizationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName23,
					_methodParameterTypes23,
					new Object[] {
						esfMatchId,
						
					ClpSerializer.translateInput(firstName),
						
					ClpSerializer.translateInput(lastName),
						
					ClpSerializer.translateInput(fiscalCode),
						
					state,
						
					organizationId
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<it.ethica.esf.model.ESFUser>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> getESFUserByFirstName_LastName_FiscalCode_NotPartecipants(
		long esfMatchId, java.lang.String firstName, java.lang.String lastName,
		java.lang.String fiscalCode, int state, long organizationId, int start,
		int end) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName24,
					_methodParameterTypes24,
					new Object[] {
						esfMatchId,
						
					ClpSerializer.translateInput(firstName),
						
					ClpSerializer.translateInput(lastName),
						
					ClpSerializer.translateInput(fiscalCode),
						
					state,
						
					organizationId,
						
					start,
						
					end
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<it.ethica.esf.model.ESFUser>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> getESFUserByFirstName_LastName_FiscalCode(
		java.lang.String firstName, java.lang.String lastName,
		java.lang.String fiscalCode, int state, long organizationId, int start,
		int end) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName25,
					_methodParameterTypes25,
					new Object[] {
						ClpSerializer.translateInput(firstName),
						
					ClpSerializer.translateInput(lastName),
						
					ClpSerializer.translateInput(fiscalCode),
						
					state,
						
					organizationId,
						
					start,
						
					end
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<it.ethica.esf.model.ESFUser>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public it.ethica.esf.model.ESFUser getESFUserByFiscalCode(
		java.lang.String fiscalCode) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName26,
					_methodParameterTypes26,
					new Object[] { ClpSerializer.translateInput(fiscalCode) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (it.ethica.esf.model.ESFUser)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> getAllUserByLikeF_L(
		java.lang.String firstName, java.lang.String lastName,
		java.lang.String screenName, int start, int end) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName27,
					_methodParameterTypes27,
					new Object[] {
						ClpSerializer.translateInput(firstName),
						
					ClpSerializer.translateInput(lastName),
						
					ClpSerializer.translateInput(screenName),
						
					start,
						
					end
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<it.ethica.esf.model.ESFUser>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public int countAllUserByLikeF_L(java.lang.String firstName,
		java.lang.String lastName, java.lang.String screenName) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName28,
					_methodParameterTypes28,
					new Object[] {
						ClpSerializer.translateInput(firstName),
						
					ClpSerializer.translateInput(lastName),
						
					ClpSerializer.translateInput(screenName)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> getAllUserByLikeF_L_S(
		java.lang.String firstName, java.lang.String lastName,
		java.lang.String screenName, int state, int start, int end) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName29,
					_methodParameterTypes29,
					new Object[] {
						ClpSerializer.translateInput(firstName),
						
					ClpSerializer.translateInput(lastName),
						
					ClpSerializer.translateInput(screenName),
						
					state,
						
					start,
						
					end
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<it.ethica.esf.model.ESFUser>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> getAllUserByLikeF_L_S(
		java.lang.String firstName, java.lang.String lastName,
		java.lang.String screenName, int state) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName30,
					_methodParameterTypes30,
					new Object[] {
						ClpSerializer.translateInput(firstName),
						
					ClpSerializer.translateInput(lastName),
						
					ClpSerializer.translateInput(screenName),
						
					state
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<it.ethica.esf.model.ESFUser>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> getAllUserByLikeF_C_S(
		java.lang.String firstName, java.lang.String lastName,
		java.lang.String cardCode, int state, long organizationId, int start,
		int end) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName31,
					_methodParameterTypes31,
					new Object[] {
						ClpSerializer.translateInput(firstName),
						
					ClpSerializer.translateInput(lastName),
						
					ClpSerializer.translateInput(cardCode),
						
					state,
						
					organizationId,
						
					start,
						
					end
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<it.ethica.esf.model.ESFUser>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> getAllUserByLikeF_C_S(
		java.lang.String firstName, java.lang.String lastName,
		java.lang.String cardCode, int state, long organizationId) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName32,
					_methodParameterTypes32,
					new Object[] {
						ClpSerializer.translateInput(firstName),
						
					ClpSerializer.translateInput(lastName),
						
					ClpSerializer.translateInput(cardCode),
						
					state,
						
					organizationId
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<it.ethica.esf.model.ESFUser>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> getShooterByStateAndOrganization(
		int state, long organizationId) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName33,
					_methodParameterTypes33,
					new Object[] { state, organizationId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<it.ethica.esf.model.ESFUser>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> getAllShooterByLikeF_C_S(
		java.lang.String firstName, java.lang.String lastName,
		java.lang.String cardCode, long organizationId, int start, int end) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName34,
					_methodParameterTypes34,
					new Object[] {
						ClpSerializer.translateInput(firstName),
						
					ClpSerializer.translateInput(lastName),
						
					ClpSerializer.translateInput(cardCode),
						
					organizationId,
						
					start,
						
					end
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<it.ethica.esf.model.ESFUser>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> getAllShooterByLikeF_C_S(
		java.lang.String firstName, java.lang.String lastName,
		java.lang.String cardCode, long organizationId) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName35,
					_methodParameterTypes35,
					new Object[] {
						ClpSerializer.translateInput(firstName),
						
					ClpSerializer.translateInput(lastName),
						
					ClpSerializer.translateInput(cardCode),
						
					organizationId
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<it.ethica.esf.model.ESFUser>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> getAllEsfUserByState(
		int state) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName36,
					_methodParameterTypes36, new Object[] { state });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<it.ethica.esf.model.ESFUser>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> getAllEsfUserByState(
		int state, int start, int end) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName37,
					_methodParameterTypes37, new Object[] { state, start, end });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<it.ethica.esf.model.ESFUser>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findUserByRoleT_N_S(
		java.lang.String title, java.lang.String name, int state)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserESFUserRoleException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName38,
					_methodParameterTypes38,
					new Object[] {
						ClpSerializer.translateInput(title),
						
					ClpSerializer.translateInput(name),
						
					state
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof it.ethica.esf.NoSuchUserESFUserRoleException) {
				throw (it.ethica.esf.NoSuchUserESFUserRoleException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<it.ethica.esf.model.ESFUser>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findAllShooters(
		int stateCard, int stateUser) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName39,
					_methodParameterTypes39,
					new Object[] { stateCard, stateUser });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<it.ethica.esf.model.ESFUser>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findAllShooters(
		long organizationId, int stateCard, int stateUser) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName40,
					_methodParameterTypes40,
					new Object[] { organizationId, stateCard, stateUser });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<it.ethica.esf.model.ESFUser>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findAllShooters(
		long organizationId, int stateCard, int stateUser, int start, int end) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName41,
					_methodParameterTypes41,
					new Object[] {
						organizationId,
						
					stateCard,
						
					stateUser,
						
					start,
						
					end
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<it.ethica.esf.model.ESFUser>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findRoledUserOrganization(
		long organizationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName42,
					_methodParameterTypes42, new Object[] { organizationId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<it.ethica.esf.model.ESFUser>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findRoledUserOrganization(
		long organizationId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName43,
					_methodParameterTypes43,
					new Object[] { organizationId, start, end });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<it.ethica.esf.model.ESFUser>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findAllShootersByLeafOrgAssigned(
		long organizationId, int stateCard, long esfUserRoleId, int stateUser,
		int start, int end) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName44,
					_methodParameterTypes44,
					new Object[] {
						organizationId,
						
					stateCard,
						
					esfUserRoleId,
						
					stateUser,
						
					start,
						
					end
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<it.ethica.esf.model.ESFUser>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findAllShootersByLeafOrgAssignedName(
		java.lang.String name, java.lang.String lastName, long organizationId,
		int stateCard, long esfUserRoleId, int stateUser, int start, int end) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName45,
					_methodParameterTypes45,
					new Object[] {
						ClpSerializer.translateInput(name),
						
					ClpSerializer.translateInput(lastName),
						
					organizationId,
						
					stateCard,
						
					esfUserRoleId,
						
					stateUser,
						
					start,
						
					end
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<it.ethica.esf.model.ESFUser>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public int countAllShootersByLeafOrgAssignedName(java.lang.String name,
		java.lang.String lastName, long organizationId, int stateCard,
		long esfUserRoleId, int stateUser) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName46,
					_methodParameterTypes46,
					new Object[] {
						ClpSerializer.translateInput(name),
						
					ClpSerializer.translateInput(lastName),
						
					organizationId,
						
					stateCard,
						
					esfUserRoleId,
						
					stateUser
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findAllShootersByLeafOrgAssigned(
		long organizationId, int stateCard, long esfUserRoleId, int stateUser) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName47,
					_methodParameterTypes47,
					new Object[] {
						organizationId,
						
					stateCard,
						
					esfUserRoleId,
						
					stateUser
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<it.ethica.esf.model.ESFUser>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findAllShootersByLeafOrg(
		long organizationId, int stateCard, int stateUser) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName48,
					_methodParameterTypes48,
					new Object[] { organizationId, stateCard, stateUser });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<it.ethica.esf.model.ESFUser>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findAllShootersByLeafOrg(
		long organizationId, int stateCard, int stateUser, int start, int end) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName49,
					_methodParameterTypes49,
					new Object[] {
						organizationId,
						
					stateCard,
						
					stateUser,
						
					start,
						
					end
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<it.ethica.esf.model.ESFUser>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> finNationalDelegationESFUsersByMatchId(
		long esfMatchId) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName50,
					_methodParameterTypes50, new Object[] { esfMatchId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<it.ethica.esf.model.ESFUser>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findAllStaff(
		java.lang.Long esfMatchId, java.lang.String firstName,
		java.lang.String lastName, java.lang.String fiscalCode, int state,
		java.lang.Long organizationId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName51,
					_methodParameterTypes51,
					new Object[] {
						ClpSerializer.translateInput(esfMatchId),
						
					ClpSerializer.translateInput(firstName),
						
					ClpSerializer.translateInput(lastName),
						
					ClpSerializer.translateInput(fiscalCode),
						
					state,
						
					ClpSerializer.translateInput(organizationId),
						
					start,
						
					end
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<it.ethica.esf.model.ESFUser>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findAllStaffNamed(
		java.lang.Long esfMatchId, java.lang.String firstName,
		java.lang.String lastName, java.lang.String fiscalCode, int state,
		java.lang.Long organizationId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName52,
					_methodParameterTypes52,
					new Object[] {
						ClpSerializer.translateInput(esfMatchId),
						
					ClpSerializer.translateInput(firstName),
						
					ClpSerializer.translateInput(lastName),
						
					ClpSerializer.translateInput(fiscalCode),
						
					state,
						
					ClpSerializer.translateInput(organizationId),
						
					start,
						
					end
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<it.ethica.esf.model.ESFUser>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findStaffNamed(
		long esfMatchId, java.lang.String firstName, java.lang.String lastName,
		java.lang.String fiscalCode)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName53,
					_methodParameterTypes53,
					new Object[] {
						esfMatchId,
						
					ClpSerializer.translateInput(firstName),
						
					ClpSerializer.translateInput(lastName),
						
					ClpSerializer.translateInput(fiscalCode)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<it.ethica.esf.model.ESFUser>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findStaffNamed(
		long esfMatchId, java.lang.String firstName, java.lang.String lastName,
		java.lang.String fiscalCode, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName54,
					_methodParameterTypes54,
					new Object[] {
						esfMatchId,
						
					ClpSerializer.translateInput(firstName),
						
					ClpSerializer.translateInput(lastName),
						
					ClpSerializer.translateInput(fiscalCode),
						
					start,
						
					end
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<it.ethica.esf.model.ESFUser>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findStaffNamedNational(
		long esfMatchId, java.lang.String firstName, java.lang.String lastName,
		java.lang.String fiscalCode)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName55,
					_methodParameterTypes55,
					new Object[] {
						esfMatchId,
						
					ClpSerializer.translateInput(firstName),
						
					ClpSerializer.translateInput(lastName),
						
					ClpSerializer.translateInput(fiscalCode)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<it.ethica.esf.model.ESFUser>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findStaffNamedNational(
		long esfMatchId, java.lang.String firstName, java.lang.String lastName,
		java.lang.String fiscalCode, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName56,
					_methodParameterTypes56,
					new Object[] {
						esfMatchId,
						
					ClpSerializer.translateInput(firstName),
						
					ClpSerializer.translateInput(lastName),
						
					ClpSerializer.translateInput(fiscalCode),
						
					start,
						
					end
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<it.ethica.esf.model.ESFUser>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findStaff(
		long esfMatchId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName57,
					_methodParameterTypes57, new Object[] { esfMatchId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<it.ethica.esf.model.ESFUser>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findStaff(
		long esfMatchId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName58,
					_methodParameterTypes58,
					new Object[] { esfMatchId, start, end });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<it.ethica.esf.model.ESFUser>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> finNationalDelegationESFUsersByMatchId(
		long esfMatchId, int start, int end) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName59,
					_methodParameterTypes59,
					new Object[] { esfMatchId, start, end });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<it.ethica.esf.model.ESFUser>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findNationalDelegationStaffESFUsersByMatchId(
		long esfMatchId) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName60,
					_methodParameterTypes60, new Object[] { esfMatchId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<it.ethica.esf.model.ESFUser>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findNationalDelegationStaffESFUsersByMatchId(
		long esfMatchId, int start, int end) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName61,
					_methodParameterTypes61,
					new Object[] { esfMatchId, start, end });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<it.ethica.esf.model.ESFUser>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findNationalDelegationsESFUsersByMatchId(
		long esfMatchId) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName62,
					_methodParameterTypes62, new Object[] { esfMatchId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<it.ethica.esf.model.ESFUser>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findNationalDelegationsESFUsersByMatchId(
		long esfMatchId, int start, int end) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName63,
					_methodParameterTypes63,
					new Object[] { esfMatchId, start, end });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<it.ethica.esf.model.ESFUser>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findNationalDelegationsESFUsersByMatchId_PartecipantTypeId(
		long esfMatchId, long esfPartecipantTypeId) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName64,
					_methodParameterTypes64,
					new Object[] { esfMatchId, esfPartecipantTypeId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<it.ethica.esf.model.ESFUser>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findNationalDelegationsESFUsersByMatchId_PartecipantTypeId(
		long esfMatchId, long esfPartecipantTypeId, int start, int end) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName65,
					_methodParameterTypes65,
					new Object[] { esfMatchId, esfPartecipantTypeId, start, end });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<it.ethica.esf.model.ESFUser>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findNationalShooters() {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName66,
					_methodParameterTypes66, new Object[] {  });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<it.ethica.esf.model.ESFUser>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findNationalShooters(
		int start, int end) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName67,
					_methodParameterTypes67, new Object[] { start, end });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<it.ethica.esf.model.ESFUser>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findNationalPartecipantShooters(
		long idMatch, boolean isPartecipant)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName68,
					_methodParameterTypes68,
					new Object[] { idMatch, isPartecipant });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<it.ethica.esf.model.ESFUser>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findNationalPartecipantShooters(
		long idMatch, boolean isPartecipant, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName69,
					_methodParameterTypes69,
					new Object[] { idMatch, isPartecipant, start, end });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<it.ethica.esf.model.ESFUser>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findPartecipantShooters(
		int stateCard, int stateUser, long idMatch, boolean isPartecipant)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName70,
					_methodParameterTypes70,
					new Object[] { stateCard, stateUser, idMatch, isPartecipant });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<it.ethica.esf.model.ESFUser>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findPartecipantShooters(
		int stateCard, int stateUser, long idMatch, boolean isPartecipant,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName71,
					_methodParameterTypes71,
					new Object[] {
						stateCard,
						
					stateUser,
						
					idMatch,
						
					isPartecipant,
						
					start,
						
					end
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<it.ethica.esf.model.ESFUser>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findNationalPartecipantCoaches(
		long idMatch, boolean isPartecipant)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserESFUserRoleException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName72,
					_methodParameterTypes72,
					new Object[] { idMatch, isPartecipant });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof it.ethica.esf.NoSuchUserESFUserRoleException) {
				throw (it.ethica.esf.NoSuchUserESFUserRoleException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<it.ethica.esf.model.ESFUser>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findNationalPartecipantCoaches(
		long idMatch, boolean isPartecipant, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserESFUserRoleException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName73,
					_methodParameterTypes73,
					new Object[] { idMatch, isPartecipant, start, end });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof it.ethica.esf.NoSuchUserESFUserRoleException) {
				throw (it.ethica.esf.NoSuchUserESFUserRoleException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<it.ethica.esf.model.ESFUser>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findPartecipantCoaches(
		int stateUser, long idMatch, boolean isPartecipant)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserESFUserRoleException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName74,
					_methodParameterTypes74,
					new Object[] { stateUser, idMatch, isPartecipant });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof it.ethica.esf.NoSuchUserESFUserRoleException) {
				throw (it.ethica.esf.NoSuchUserESFUserRoleException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<it.ethica.esf.model.ESFUser>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findPartecipantCoaches(
		int stateUser, long idMatch, boolean isPartecipant, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserESFUserRoleException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName75,
					_methodParameterTypes75,
					new Object[] { stateUser, idMatch, isPartecipant, start, end });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof it.ethica.esf.NoSuchUserESFUserRoleException) {
				throw (it.ethica.esf.NoSuchUserESFUserRoleException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<it.ethica.esf.model.ESFUser>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findNationalPartecipantReferees(
		long idMatch, boolean isPartecipant)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserESFUserRoleException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName76,
					_methodParameterTypes76,
					new Object[] { idMatch, isPartecipant });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof it.ethica.esf.NoSuchUserESFUserRoleException) {
				throw (it.ethica.esf.NoSuchUserESFUserRoleException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<it.ethica.esf.model.ESFUser>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findNationalPartecipantReferees(
		long idMatch, boolean isPartecipant, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserESFUserRoleException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName77,
					_methodParameterTypes77,
					new Object[] { idMatch, isPartecipant, start, end });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof it.ethica.esf.NoSuchUserESFUserRoleException) {
				throw (it.ethica.esf.NoSuchUserESFUserRoleException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<it.ethica.esf.model.ESFUser>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findPartecipantReferees(
		int stateUser, long idMatch, boolean isPartecipant, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserESFUserRoleException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName78,
					_methodParameterTypes78,
					new Object[] { stateUser, idMatch, isPartecipant, start, end });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof it.ethica.esf.NoSuchUserESFUserRoleException) {
				throw (it.ethica.esf.NoSuchUserESFUserRoleException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<it.ethica.esf.model.ESFUser>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findPartecipantReferees(
		int stateUser, long idMatch, boolean isPartecipant)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserESFUserRoleException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName79,
					_methodParameterTypes79,
					new Object[] { stateUser, idMatch, isPartecipant });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof it.ethica.esf.NoSuchUserESFUserRoleException) {
				throw (it.ethica.esf.NoSuchUserESFUserRoleException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<it.ethica.esf.model.ESFUser>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findNationalPartecipantDoctor(
		long idMatch, boolean isPartecipant)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserESFUserRoleException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName80,
					_methodParameterTypes80,
					new Object[] { idMatch, isPartecipant });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof it.ethica.esf.NoSuchUserESFUserRoleException) {
				throw (it.ethica.esf.NoSuchUserESFUserRoleException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<it.ethica.esf.model.ESFUser>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findNationalPartecipantDoctor(
		long idMatch, boolean isPartecipant, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserESFUserRoleException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName81,
					_methodParameterTypes81,
					new Object[] { idMatch, isPartecipant, start, end });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof it.ethica.esf.NoSuchUserESFUserRoleException) {
				throw (it.ethica.esf.NoSuchUserESFUserRoleException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<it.ethica.esf.model.ESFUser>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findPartecipantDoctor(
		int stateUser, long idMatch, boolean isPartecipant)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserESFUserRoleException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName82,
					_methodParameterTypes82,
					new Object[] { stateUser, idMatch, isPartecipant });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof it.ethica.esf.NoSuchUserESFUserRoleException) {
				throw (it.ethica.esf.NoSuchUserESFUserRoleException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<it.ethica.esf.model.ESFUser>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findPartecipantDoctor(
		int stateUser, long idMatch, boolean isPartecipant, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserESFUserRoleException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName83,
					_methodParameterTypes83,
					new Object[] { stateUser, idMatch, isPartecipant, start, end });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof it.ethica.esf.NoSuchUserESFUserRoleException) {
				throw (it.ethica.esf.NoSuchUserESFUserRoleException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<it.ethica.esf.model.ESFUser>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public it.ethica.esf.model.ESFUser addESFUser(long operatorId,
		java.lang.String code, java.lang.String firstName,
		java.lang.String middleName, java.lang.String lastName,
		java.lang.String userEmail, java.lang.String fiscalCode,
		int birthdayDay, int birthdayMonth, int birthdayYear, boolean male,
		java.lang.String skype, java.lang.String facebook,
		java.lang.String twitter, java.lang.String jobTitle,
		it.ethica.esf.model.ESFEntityState esfEntityState,
		java.util.List<it.ethica.esf.model.ESFAddress> esfAddresses,
		java.util.List<it.ethica.esf.model.ESFPhone> phones,
		java.lang.String birthcity,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName84,
					_methodParameterTypes84,
					new Object[] {
						operatorId,
						
					ClpSerializer.translateInput(code),
						
					ClpSerializer.translateInput(firstName),
						
					ClpSerializer.translateInput(middleName),
						
					ClpSerializer.translateInput(lastName),
						
					ClpSerializer.translateInput(userEmail),
						
					ClpSerializer.translateInput(fiscalCode),
						
					birthdayDay,
						
					birthdayMonth,
						
					birthdayYear,
						
					male,
						
					ClpSerializer.translateInput(skype),
						
					ClpSerializer.translateInput(facebook),
						
					ClpSerializer.translateInput(twitter),
						
					ClpSerializer.translateInput(jobTitle),
						
					ClpSerializer.translateInput(esfEntityState),
						
					ClpSerializer.translateInput(esfAddresses),
						
					ClpSerializer.translateInput(phones),
						
					ClpSerializer.translateInput(birthcity),
						
					ClpSerializer.translateInput(serviceContext)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (it.ethica.esf.model.ESFUser)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public it.ethica.esf.model.ESFUser addESFUserInOrganization(long userId,
		java.lang.String code, java.lang.String screenName,
		java.lang.String emailAddress, long facebookId,
		java.util.Locale locale, java.lang.String firstName,
		java.lang.String middleName, java.lang.String lastName, int prefixId,
		int suffixId, boolean male, int birthdayMonth, int birthdayDay,
		int birthdayYear, java.lang.String jobTitle,
		it.ethica.esf.model.ESFAddress esfAddress,
		it.ethica.esf.model.ESFEntityState esfEntityState,
		java.util.List<com.liferay.portal.model.Phone> phones,
		com.liferay.portal.service.ServiceContext portalUserServiceContext,
		com.liferay.portal.service.ServiceContext esfUserServiceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName85,
					_methodParameterTypes85,
					new Object[] {
						userId,
						
					ClpSerializer.translateInput(code),
						
					ClpSerializer.translateInput(screenName),
						
					ClpSerializer.translateInput(emailAddress),
						
					facebookId,
						
					ClpSerializer.translateInput(locale),
						
					ClpSerializer.translateInput(firstName),
						
					ClpSerializer.translateInput(middleName),
						
					ClpSerializer.translateInput(lastName),
						
					prefixId,
						
					suffixId,
						
					male,
						
					birthdayMonth,
						
					birthdayDay,
						
					birthdayYear,
						
					ClpSerializer.translateInput(jobTitle),
						
					ClpSerializer.translateInput(esfAddress),
						
					ClpSerializer.translateInput(esfEntityState),
						
					ClpSerializer.translateInput(phones),
						
					ClpSerializer.translateInput(portalUserServiceContext),
						
					ClpSerializer.translateInput(esfUserServiceContext)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (it.ethica.esf.model.ESFUser)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public it.ethica.esf.model.ESFUser addESFUserInOrganization(long userId,
		java.lang.String code, java.lang.String screenName,
		java.lang.String emailAddress, long facebookId,
		java.util.Locale locale, java.lang.String firstName,
		java.lang.String middleName, java.lang.String lastName, int prefixId,
		int suffixId, boolean male, int birthdayMonth, int birthdayDay,
		int birthdayYear, java.lang.String jobTitle,
		it.ethica.esf.model.ESFAddress esfAddress, long esfStateId,
		java.util.List<com.liferay.portal.model.Phone> phones,
		com.liferay.portal.service.ServiceContext portalUserServiceContext,
		com.liferay.portal.service.ServiceContext esfUserServiceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName86,
					_methodParameterTypes86,
					new Object[] {
						userId,
						
					ClpSerializer.translateInput(code),
						
					ClpSerializer.translateInput(screenName),
						
					ClpSerializer.translateInput(emailAddress),
						
					facebookId,
						
					ClpSerializer.translateInput(locale),
						
					ClpSerializer.translateInput(firstName),
						
					ClpSerializer.translateInput(middleName),
						
					ClpSerializer.translateInput(lastName),
						
					prefixId,
						
					suffixId,
						
					male,
						
					birthdayMonth,
						
					birthdayDay,
						
					birthdayYear,
						
					ClpSerializer.translateInput(jobTitle),
						
					ClpSerializer.translateInput(esfAddress),
						
					esfStateId,
						
					ClpSerializer.translateInput(phones),
						
					ClpSerializer.translateInput(portalUserServiceContext),
						
					ClpSerializer.translateInput(esfUserServiceContext)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (it.ethica.esf.model.ESFUser)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public it.ethica.esf.model.ESFUser deleteESFUser(long esfUserId,
		java.util.List<it.ethica.esf.model.ESFAddress> esfAddresses,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName87,
					_methodParameterTypes87,
					new Object[] {
						esfUserId,
						
					ClpSerializer.translateInput(esfAddresses),
						
					ClpSerializer.translateInput(serviceContext)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (it.ethica.esf.model.ESFUser)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public it.ethica.esf.model.ESFUser updateESFUser(long operatorId,
		long esfUserId, java.lang.String code, java.lang.String firstName,
		java.lang.String middleName, java.lang.String lastName,
		java.lang.String userEmail, java.lang.String fiscalCode,
		int birthdayDay, int birthdayMonth, int birthdayYear, boolean male,
		boolean disable, java.lang.String skype, java.lang.String facebook,
		java.lang.String twitter, java.lang.String jobTitle,
		it.ethica.esf.model.ESFEntityState esfEntityState,
		java.util.List<it.ethica.esf.model.ESFAddress> esfAddresses,
		java.util.List<it.ethica.esf.model.ESFPhone> phones,
		java.lang.String birthcity,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName88,
					_methodParameterTypes88,
					new Object[] {
						operatorId,
						
					esfUserId,
						
					ClpSerializer.translateInput(code),
						
					ClpSerializer.translateInput(firstName),
						
					ClpSerializer.translateInput(middleName),
						
					ClpSerializer.translateInput(lastName),
						
					ClpSerializer.translateInput(userEmail),
						
					ClpSerializer.translateInput(fiscalCode),
						
					birthdayDay,
						
					birthdayMonth,
						
					birthdayYear,
						
					male,
						
					disable,
						
					ClpSerializer.translateInput(skype),
						
					ClpSerializer.translateInput(facebook),
						
					ClpSerializer.translateInput(twitter),
						
					ClpSerializer.translateInput(jobTitle),
						
					ClpSerializer.translateInput(esfEntityState),
						
					ClpSerializer.translateInput(esfAddresses),
						
					ClpSerializer.translateInput(phones),
						
					ClpSerializer.translateInput(birthcity),
						
					ClpSerializer.translateInput(serviceContext)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (it.ethica.esf.model.ESFUser)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public it.ethica.esf.model.ESFUser addESFShooter(long operatorId,
		java.lang.String code, java.lang.String firstName,
		java.lang.String middleName, java.lang.String lastName,
		java.lang.String userEmail, java.lang.String fiscalCode,
		int birthdayDay, int birthdayMonth, int birthdayYear,
		java.lang.String birthcity, java.lang.String nationality, boolean male,
		java.lang.String skype, java.lang.String facebook,
		java.lang.String twitter, long typearmy, boolean isSportsGroups,
		java.lang.String job, java.lang.String jobTitle,
		java.lang.String issfIdNumber,
		it.ethica.esf.model.ESFEntityState esfEntityState,
		it.ethica.esf.model.ESFCard esfCard,
		java.util.List<it.ethica.esf.model.ESFAddress> esfAddresses,
		java.util.List<it.ethica.esf.model.ESFPhone> phones, boolean privacy1,
		boolean privacy2, boolean privacy3, java.util.Date datePrivacy1,
		java.util.Date datePrivacy2, java.util.Date datePrivacy3,
		boolean validateCF, long codeUser,
		com.liferay.portal.service.ServiceContext esfUserServiceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName89,
					_methodParameterTypes89,
					new Object[] {
						operatorId,
						
					ClpSerializer.translateInput(code),
						
					ClpSerializer.translateInput(firstName),
						
					ClpSerializer.translateInput(middleName),
						
					ClpSerializer.translateInput(lastName),
						
					ClpSerializer.translateInput(userEmail),
						
					ClpSerializer.translateInput(fiscalCode),
						
					birthdayDay,
						
					birthdayMonth,
						
					birthdayYear,
						
					ClpSerializer.translateInput(birthcity),
						
					ClpSerializer.translateInput(nationality),
						
					male,
						
					ClpSerializer.translateInput(skype),
						
					ClpSerializer.translateInput(facebook),
						
					ClpSerializer.translateInput(twitter),
						
					typearmy,
						
					isSportsGroups,
						
					ClpSerializer.translateInput(job),
						
					ClpSerializer.translateInput(jobTitle),
						
					ClpSerializer.translateInput(issfIdNumber),
						
					ClpSerializer.translateInput(esfEntityState),
						
					ClpSerializer.translateInput(esfCard),
						
					ClpSerializer.translateInput(esfAddresses),
						
					ClpSerializer.translateInput(phones),
						
					privacy1,
						
					privacy2,
						
					privacy3,
						
					ClpSerializer.translateInput(datePrivacy1),
						
					ClpSerializer.translateInput(datePrivacy2),
						
					ClpSerializer.translateInput(datePrivacy3),
						
					validateCF,
						
					codeUser,
						
					ClpSerializer.translateInput(esfUserServiceContext)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (it.ethica.esf.model.ESFUser)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public it.ethica.esf.model.ESFUser updateESFShooter(long operatorId,
		long esfUserId, java.lang.String code, java.lang.String firstName,
		java.lang.String middleName, java.lang.String lastName,
		java.lang.String userEmail, java.lang.String fiscalCode,
		int birthdayDay, int birthdayMonth, int birthdayYear,
		java.lang.String birthcity, java.lang.String nationality, boolean male,
		boolean disable, java.lang.String skype, java.lang.String facebook,
		java.lang.String twitter, long typearmy, boolean isSportsGroups,
		java.lang.String job, java.lang.String jobTitle,
		java.lang.String issfIdNumber,
		it.ethica.esf.model.ESFEntityState esfEntityState,
		it.ethica.esf.model.ESFCard esfCard,
		java.util.List<it.ethica.esf.model.ESFAddress> esfAddresses,
		java.util.List<it.ethica.esf.model.ESFPhone> phones,
		java.util.Date dateOfDeath, boolean privacy1, boolean privacy2,
		boolean privacy3, java.util.Date datePrivacy1,
		java.util.Date datePrivacy2, java.util.Date datePrivacy3,
		boolean validateCF, long codeUser,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName90,
					_methodParameterTypes90,
					new Object[] {
						operatorId,
						
					esfUserId,
						
					ClpSerializer.translateInput(code),
						
					ClpSerializer.translateInput(firstName),
						
					ClpSerializer.translateInput(middleName),
						
					ClpSerializer.translateInput(lastName),
						
					ClpSerializer.translateInput(userEmail),
						
					ClpSerializer.translateInput(fiscalCode),
						
					birthdayDay,
						
					birthdayMonth,
						
					birthdayYear,
						
					ClpSerializer.translateInput(birthcity),
						
					ClpSerializer.translateInput(nationality),
						
					male,
						
					disable,
						
					ClpSerializer.translateInput(skype),
						
					ClpSerializer.translateInput(facebook),
						
					ClpSerializer.translateInput(twitter),
						
					typearmy,
						
					isSportsGroups,
						
					ClpSerializer.translateInput(job),
						
					ClpSerializer.translateInput(jobTitle),
						
					ClpSerializer.translateInput(issfIdNumber),
						
					ClpSerializer.translateInput(esfEntityState),
						
					ClpSerializer.translateInput(esfCard),
						
					ClpSerializer.translateInput(esfAddresses),
						
					ClpSerializer.translateInput(phones),
						
					ClpSerializer.translateInput(dateOfDeath),
						
					privacy1,
						
					privacy2,
						
					privacy3,
						
					ClpSerializer.translateInput(datePrivacy1),
						
					ClpSerializer.translateInput(datePrivacy2),
						
					ClpSerializer.translateInput(datePrivacy3),
						
					validateCF,
						
					codeUser,
						
					ClpSerializer.translateInput(serviceContext)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (it.ethica.esf.model.ESFUser)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public void updateESFUserToESFShooter(long userId, long esfUserId,
		it.ethica.esf.model.ESFCard esfCard,
		java.util.List<it.ethica.esf.model.ESFCard> esfCards,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		try {
			_invokableLocalService.invokeMethod(_methodName91,
				_methodParameterTypes91,
				new Object[] {
					userId,
					
				esfUserId,
					
				ClpSerializer.translateInput(esfCard),
					
				ClpSerializer.translateInput(esfCards),
					
				ClpSerializer.translateInput(serviceContext)
				});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	@Override
	public void addESFUserToESFShooter(long esfUserId, long esfCardId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchCardException {
		try {
			_invokableLocalService.invokeMethod(_methodName92,
				_methodParameterTypes92, new Object[] { esfUserId, esfCardId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof it.ethica.esf.NoSuchCardException) {
				throw (it.ethica.esf.NoSuchCardException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	@Override
	public int countByESFUserRole(long esfUserRoleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName93,
					_methodParameterTypes93, new Object[] { esfUserRoleId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUserESFUserRole> getESFUserRoles(
		long esfUserId, boolean active)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName94,
					_methodParameterTypes94, new Object[] { esfUserId, active });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<it.ethica.esf.model.ESFUserESFUserRole>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUserESFUserRole> getActiveESFUserRoles(
		long esfUserId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName95,
					_methodParameterTypes95, new Object[] { esfUserId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<it.ethica.esf.model.ESFUserESFUserRole>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findAllUser()
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName96,
					_methodParameterTypes96, new Object[] {  });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<it.ethica.esf.model.ESFUser>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.liferay.portal.model.User checkEmailAddress(
		java.lang.String emailAddress,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName97,
					_methodParameterTypes97,
					new Object[] {
						ClpSerializer.translateInput(emailAddress),
						
					ClpSerializer.translateInput(serviceContext)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.liferay.portal.model.User)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.liferay.portal.model.User checkScreenName(
		java.lang.String screenName,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName98,
					_methodParameterTypes98,
					new Object[] {
						ClpSerializer.translateInput(screenName),
						
					ClpSerializer.translateInput(serviceContext)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.liferay.portal.model.User)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findAllUserByAgeOnlyPeople()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName99,
					_methodParameterTypes99, new Object[] {  });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<it.ethica.esf.model.ESFUser>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findAllUserByRolenoNull(
		long roleId, long organizationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName100,
					_methodParameterTypes100,
					new Object[] { roleId, organizationId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<it.ethica.esf.model.ESFUser>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findShooterRoleAssignedName(
		java.lang.String name, java.lang.String lastName, long roleId,
		long organizationId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName101,
					_methodParameterTypes101,
					new Object[] {
						ClpSerializer.translateInput(name),
						
					ClpSerializer.translateInput(lastName),
						
					roleId,
						
					organizationId,
						
					start,
						
					end
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<it.ethica.esf.model.ESFUser>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public int countShooterRoleAssignedName(java.lang.String name,
		java.lang.String lastName, long roleId, long organizationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName102,
					_methodParameterTypes102,
					new Object[] {
						ClpSerializer.translateInput(name),
						
					ClpSerializer.translateInput(lastName),
						
					roleId,
						
					organizationId
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findStaffMatch(
		java.lang.String name, java.lang.String lastName,
		java.lang.String fiscalcode, long matchId, long fitavId, int start,
		int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName103,
					_methodParameterTypes103,
					new Object[] {
						ClpSerializer.translateInput(name),
						
					ClpSerializer.translateInput(lastName),
						
					ClpSerializer.translateInput(fiscalcode),
						
					matchId,
						
					fitavId,
						
					start,
						
					end
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<it.ethica.esf.model.ESFUser>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public int countStaffMatch(java.lang.String name,
		java.lang.String lastName, java.lang.String fiscalcode, long matchId,
		long fitavId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName104,
					_methodParameterTypes104,
					new Object[] {
						ClpSerializer.translateInput(name),
						
					ClpSerializer.translateInput(lastName),
						
					ClpSerializer.translateInput(fiscalcode),
						
					matchId,
						
					fitavId
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findShooterNotAssociated(
		java.lang.String name, java.lang.String lastName,
		java.lang.String cardCode, long sportTypeId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName105,
					_methodParameterTypes105,
					new Object[] {
						ClpSerializer.translateInput(name),
						
					ClpSerializer.translateInput(lastName),
						
					ClpSerializer.translateInput(cardCode),
						
					sportTypeId,
						
					start,
						
					end
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<it.ethica.esf.model.ESFUser>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public int countNotNationalShooterBySPT(java.lang.String name,
		java.lang.String lastName, java.lang.String cardCode, long sportTypeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName106,
					_methodParameterTypes106,
					new Object[] {
						ClpSerializer.translateInput(name),
						
					ClpSerializer.translateInput(lastName),
						
					ClpSerializer.translateInput(cardCode),
						
					sportTypeId
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findALLShooterNotAssociated(
		java.lang.String name, java.lang.String lastName,
		java.lang.String cardCode, long sportTypeId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName107,
					_methodParameterTypes107,
					new Object[] {
						ClpSerializer.translateInput(name),
						
					ClpSerializer.translateInput(lastName),
						
					ClpSerializer.translateInput(cardCode),
						
					sportTypeId,
						
					start,
						
					end
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<it.ethica.esf.model.ESFUser>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public int countALLNotNationalShooterBySPT(java.lang.String name,
		java.lang.String lastName, java.lang.String cardCode, long sportTypeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName108,
					_methodParameterTypes108,
					new Object[] {
						ClpSerializer.translateInput(name),
						
					ClpSerializer.translateInput(lastName),
						
					ClpSerializer.translateInput(cardCode),
						
					sportTypeId
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findStaffNormalMatch(
		java.lang.String name, java.lang.String lastName,
		java.lang.String fiscalcode, long matchId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName109,
					_methodParameterTypes109,
					new Object[] {
						ClpSerializer.translateInput(name),
						
					ClpSerializer.translateInput(lastName),
						
					ClpSerializer.translateInput(fiscalcode),
						
					matchId,
						
					start,
						
					end
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<it.ethica.esf.model.ESFUser>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public int countStaffNormalMatch(java.lang.String name,
		java.lang.String lastName, java.lang.String fiscalcode, long matchId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName110,
					_methodParameterTypes110,
					new Object[] {
						ClpSerializer.translateInput(name),
						
					ClpSerializer.translateInput(lastName),
						
					ClpSerializer.translateInput(fiscalcode),
						
					matchId
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	@Override
	public int countRenwalUser(java.lang.String thisYear,
		java.lang.String lastYear, long orgId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName111,
					_methodParameterTypes111,
					new Object[] {
						ClpSerializer.translateInput(thisYear),
						
					ClpSerializer.translateInput(lastYear),
						
					orgId
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	@Override
	public int countNewUser(java.lang.String endDate,
		java.lang.String startDate, long orgId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName112,
					_methodParameterTypes112,
					new Object[] {
						ClpSerializer.translateInput(endDate),
						
					ClpSerializer.translateInput(startDate),
						
					orgId
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findByKeyword(
		java.lang.String keyword, java.lang.String columnName)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName113,
					_methodParameterTypes113,
					new Object[] {
						ClpSerializer.translateInput(keyword),
						
					ClpSerializer.translateInput(columnName)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<it.ethica.esf.model.ESFUser>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findShooterByAss(
		java.lang.String firstName, java.lang.String lastName,
		java.lang.String cardCode, long orgId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName114,
					_methodParameterTypes114,
					new Object[] {
						ClpSerializer.translateInput(firstName),
						
					ClpSerializer.translateInput(lastName),
						
					ClpSerializer.translateInput(cardCode),
						
					orgId,
						
					start,
						
					end
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<it.ethica.esf.model.ESFUser>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public int countShooterByAss(java.lang.String firstName,
		java.lang.String lastName, java.lang.String cardCode, long orgId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName115,
					_methodParameterTypes115,
					new Object[] {
						ClpSerializer.translateInput(firstName),
						
					ClpSerializer.translateInput(lastName),
						
					ClpSerializer.translateInput(cardCode),
						
					orgId
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findShooterByAssAndNoAss(
		java.lang.String firstName, java.lang.String lastName,
		java.lang.String cardCode, long orgId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName116,
					_methodParameterTypes116,
					new Object[] {
						ClpSerializer.translateInput(firstName),
						
					ClpSerializer.translateInput(lastName),
						
					ClpSerializer.translateInput(cardCode),
						
					orgId,
						
					start,
						
					end
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<it.ethica.esf.model.ESFUser>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public int countShooterByAssAndNoAss(java.lang.String firstName,
		java.lang.String lastName, java.lang.String cardCode, long orgId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName117,
					_methodParameterTypes117,
					new Object[] {
						ClpSerializer.translateInput(firstName),
						
					ClpSerializer.translateInput(lastName),
						
					ClpSerializer.translateInput(cardCode),
						
					orgId
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findDirectorByMatch(
		java.lang.String firstName, java.lang.String lastName, long matchId,
		long shootingDirectorQualificationId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName118,
					_methodParameterTypes118,
					new Object[] {
						ClpSerializer.translateInput(firstName),
						
					ClpSerializer.translateInput(lastName),
						
					matchId,
						
					shootingDirectorQualificationId,
						
					start,
						
					end
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<it.ethica.esf.model.ESFUser>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public int countDirectorByMatch(java.lang.String firstName,
		java.lang.String lastName, long matchId,
		long shootingDirectorQualificationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName119,
					_methodParameterTypes119,
					new Object[] {
						ClpSerializer.translateInput(firstName),
						
					ClpSerializer.translateInput(lastName),
						
					matchId,
						
					shootingDirectorQualificationId
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findNewYouthShooter(
		int year)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName120,
					_methodParameterTypes120, new Object[] { year });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<it.ethica.esf.model.ESFUser>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findYouthByCategory(
		long categoryId, int year, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName121,
					_methodParameterTypes121,
					new Object[] { categoryId, year, start, end });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<it.ethica.esf.model.ESFUser>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public int findYouthByCategoryTotal(long categoryId, int year)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName122,
					_methodParameterTypes122, new Object[] { categoryId, year });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findNotBDOMemberByAssociatioId(
		java.lang.String lastName, java.lang.String firstName,
		long associationId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName123,
					_methodParameterTypes123,
					new Object[] {
						ClpSerializer.translateInput(lastName),
						
					ClpSerializer.translateInput(firstName),
						
					associationId,
						
					start,
						
					end
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<it.ethica.esf.model.ESFUser>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public int countNotBDOMemberByAssociatioId(java.lang.String lastName,
		java.lang.String firstName, long associationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName124,
					_methodParameterTypes124,
					new Object[] {
						ClpSerializer.translateInput(lastName),
						
					ClpSerializer.translateInput(firstName),
						
					associationId
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findAssociatedShooterOrganization(
		java.lang.String firstName, java.lang.String lastName,
		java.lang.String card, long associationId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName125,
					_methodParameterTypes125,
					new Object[] {
						ClpSerializer.translateInput(firstName),
						
					ClpSerializer.translateInput(lastName),
						
					ClpSerializer.translateInput(card),
						
					associationId,
						
					start,
						
					end
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<it.ethica.esf.model.ESFUser>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public int countAssociatedShooterOrganization(java.lang.String firstName,
		java.lang.String lastName, java.lang.String card, long associationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName126,
					_methodParameterTypes126,
					new Object[] {
						ClpSerializer.translateInput(firstName),
						
					ClpSerializer.translateInput(lastName),
						
					ClpSerializer.translateInput(card),
						
					associationId
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFUser> findByESFFederalRole(
		long esfFederalRoleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName127,
					_methodParameterTypes127, new Object[] { esfFederalRoleId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<it.ethica.esf.model.ESFUser>)ClpSerializer.translateOutput(returnObj);
	}

	private InvokableLocalService _invokableLocalService;
	private String _methodName0;
	private String[] _methodParameterTypes0;
	private String _methodName1;
	private String[] _methodParameterTypes1;
	private String _methodName2;
	private String[] _methodParameterTypes2;
	private String _methodName3;
	private String[] _methodParameterTypes3;
	private String _methodName4;
	private String[] _methodParameterTypes4;
	private String _methodName5;
	private String[] _methodParameterTypes5;
	private String _methodName6;
	private String[] _methodParameterTypes6;
	private String _methodName7;
	private String[] _methodParameterTypes7;
	private String _methodName8;
	private String[] _methodParameterTypes8;
	private String _methodName9;
	private String[] _methodParameterTypes9;
	private String _methodName10;
	private String[] _methodParameterTypes10;
	private String _methodName11;
	private String[] _methodParameterTypes11;
	private String _methodName12;
	private String[] _methodParameterTypes12;
	private String _methodName13;
	private String[] _methodParameterTypes13;
	private String _methodName14;
	private String[] _methodParameterTypes14;
	private String _methodName15;
	private String[] _methodParameterTypes15;
	private String _methodName16;
	private String[] _methodParameterTypes16;
	private String _methodName17;
	private String[] _methodParameterTypes17;
	private String _methodName19;
	private String[] _methodParameterTypes19;
	private String _methodName20;
	private String[] _methodParameterTypes20;
	private String _methodName21;
	private String[] _methodParameterTypes21;
	private String _methodName22;
	private String[] _methodParameterTypes22;
	private String _methodName23;
	private String[] _methodParameterTypes23;
	private String _methodName24;
	private String[] _methodParameterTypes24;
	private String _methodName25;
	private String[] _methodParameterTypes25;
	private String _methodName26;
	private String[] _methodParameterTypes26;
	private String _methodName27;
	private String[] _methodParameterTypes27;
	private String _methodName28;
	private String[] _methodParameterTypes28;
	private String _methodName29;
	private String[] _methodParameterTypes29;
	private String _methodName30;
	private String[] _methodParameterTypes30;
	private String _methodName31;
	private String[] _methodParameterTypes31;
	private String _methodName32;
	private String[] _methodParameterTypes32;
	private String _methodName33;
	private String[] _methodParameterTypes33;
	private String _methodName34;
	private String[] _methodParameterTypes34;
	private String _methodName35;
	private String[] _methodParameterTypes35;
	private String _methodName36;
	private String[] _methodParameterTypes36;
	private String _methodName37;
	private String[] _methodParameterTypes37;
	private String _methodName38;
	private String[] _methodParameterTypes38;
	private String _methodName39;
	private String[] _methodParameterTypes39;
	private String _methodName40;
	private String[] _methodParameterTypes40;
	private String _methodName41;
	private String[] _methodParameterTypes41;
	private String _methodName42;
	private String[] _methodParameterTypes42;
	private String _methodName43;
	private String[] _methodParameterTypes43;
	private String _methodName44;
	private String[] _methodParameterTypes44;
	private String _methodName45;
	private String[] _methodParameterTypes45;
	private String _methodName46;
	private String[] _methodParameterTypes46;
	private String _methodName47;
	private String[] _methodParameterTypes47;
	private String _methodName48;
	private String[] _methodParameterTypes48;
	private String _methodName49;
	private String[] _methodParameterTypes49;
	private String _methodName50;
	private String[] _methodParameterTypes50;
	private String _methodName51;
	private String[] _methodParameterTypes51;
	private String _methodName52;
	private String[] _methodParameterTypes52;
	private String _methodName53;
	private String[] _methodParameterTypes53;
	private String _methodName54;
	private String[] _methodParameterTypes54;
	private String _methodName55;
	private String[] _methodParameterTypes55;
	private String _methodName56;
	private String[] _methodParameterTypes56;
	private String _methodName57;
	private String[] _methodParameterTypes57;
	private String _methodName58;
	private String[] _methodParameterTypes58;
	private String _methodName59;
	private String[] _methodParameterTypes59;
	private String _methodName60;
	private String[] _methodParameterTypes60;
	private String _methodName61;
	private String[] _methodParameterTypes61;
	private String _methodName62;
	private String[] _methodParameterTypes62;
	private String _methodName63;
	private String[] _methodParameterTypes63;
	private String _methodName64;
	private String[] _methodParameterTypes64;
	private String _methodName65;
	private String[] _methodParameterTypes65;
	private String _methodName66;
	private String[] _methodParameterTypes66;
	private String _methodName67;
	private String[] _methodParameterTypes67;
	private String _methodName68;
	private String[] _methodParameterTypes68;
	private String _methodName69;
	private String[] _methodParameterTypes69;
	private String _methodName70;
	private String[] _methodParameterTypes70;
	private String _methodName71;
	private String[] _methodParameterTypes71;
	private String _methodName72;
	private String[] _methodParameterTypes72;
	private String _methodName73;
	private String[] _methodParameterTypes73;
	private String _methodName74;
	private String[] _methodParameterTypes74;
	private String _methodName75;
	private String[] _methodParameterTypes75;
	private String _methodName76;
	private String[] _methodParameterTypes76;
	private String _methodName77;
	private String[] _methodParameterTypes77;
	private String _methodName78;
	private String[] _methodParameterTypes78;
	private String _methodName79;
	private String[] _methodParameterTypes79;
	private String _methodName80;
	private String[] _methodParameterTypes80;
	private String _methodName81;
	private String[] _methodParameterTypes81;
	private String _methodName82;
	private String[] _methodParameterTypes82;
	private String _methodName83;
	private String[] _methodParameterTypes83;
	private String _methodName84;
	private String[] _methodParameterTypes84;
	private String _methodName85;
	private String[] _methodParameterTypes85;
	private String _methodName86;
	private String[] _methodParameterTypes86;
	private String _methodName87;
	private String[] _methodParameterTypes87;
	private String _methodName88;
	private String[] _methodParameterTypes88;
	private String _methodName89;
	private String[] _methodParameterTypes89;
	private String _methodName90;
	private String[] _methodParameterTypes90;
	private String _methodName91;
	private String[] _methodParameterTypes91;
	private String _methodName92;
	private String[] _methodParameterTypes92;
	private String _methodName93;
	private String[] _methodParameterTypes93;
	private String _methodName94;
	private String[] _methodParameterTypes94;
	private String _methodName95;
	private String[] _methodParameterTypes95;
	private String _methodName96;
	private String[] _methodParameterTypes96;
	private String _methodName97;
	private String[] _methodParameterTypes97;
	private String _methodName98;
	private String[] _methodParameterTypes98;
	private String _methodName99;
	private String[] _methodParameterTypes99;
	private String _methodName100;
	private String[] _methodParameterTypes100;
	private String _methodName101;
	private String[] _methodParameterTypes101;
	private String _methodName102;
	private String[] _methodParameterTypes102;
	private String _methodName103;
	private String[] _methodParameterTypes103;
	private String _methodName104;
	private String[] _methodParameterTypes104;
	private String _methodName105;
	private String[] _methodParameterTypes105;
	private String _methodName106;
	private String[] _methodParameterTypes106;
	private String _methodName107;
	private String[] _methodParameterTypes107;
	private String _methodName108;
	private String[] _methodParameterTypes108;
	private String _methodName109;
	private String[] _methodParameterTypes109;
	private String _methodName110;
	private String[] _methodParameterTypes110;
	private String _methodName111;
	private String[] _methodParameterTypes111;
	private String _methodName112;
	private String[] _methodParameterTypes112;
	private String _methodName113;
	private String[] _methodParameterTypes113;
	private String _methodName114;
	private String[] _methodParameterTypes114;
	private String _methodName115;
	private String[] _methodParameterTypes115;
	private String _methodName116;
	private String[] _methodParameterTypes116;
	private String _methodName117;
	private String[] _methodParameterTypes117;
	private String _methodName118;
	private String[] _methodParameterTypes118;
	private String _methodName119;
	private String[] _methodParameterTypes119;
	private String _methodName120;
	private String[] _methodParameterTypes120;
	private String _methodName121;
	private String[] _methodParameterTypes121;
	private String _methodName122;
	private String[] _methodParameterTypes122;
	private String _methodName123;
	private String[] _methodParameterTypes123;
	private String _methodName124;
	private String[] _methodParameterTypes124;
	private String _methodName125;
	private String[] _methodParameterTypes125;
	private String _methodName126;
	private String[] _methodParameterTypes126;
	private String _methodName127;
	private String[] _methodParameterTypes127;
}