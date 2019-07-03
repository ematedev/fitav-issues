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

package it.ethica.esf.service.base;

import it.ethica.esf.service.ESFUserLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Ethica
 * @generated
 */
public class ESFUserLocalServiceClpInvoker {
	public ESFUserLocalServiceClpInvoker() {
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

		_methodName460 = "getBeanIdentifier";

		_methodParameterTypes460 = new String[] {  };

		_methodName461 = "setBeanIdentifier";

		_methodParameterTypes461 = new String[] { "java.lang.String" };

		_methodName466 = "getESFUsersByDeparture";

		_methodParameterTypes466 = new String[] { "long" };

		_methodName467 = "getESFUsersByCodeCode";

		_methodParameterTypes467 = new String[] { "java.lang.String" };

		_methodName468 = "getESFUserByUserCode";

		_methodParameterTypes468 = new String[] { "long" };

		_methodName469 = "getESFUserByCodeUser2";

		_methodParameterTypes469 = new String[] { "long" };

		_methodName470 = "getESFUserByFirstName_LastName_FiscalCode_NotPartecipants";

		_methodParameterTypes470 = new String[] {
				"long", "java.lang.String", "java.lang.String",
				"java.lang.String", "int", "long"
			};

		_methodName471 = "getESFUserByFirstName_LastName_FiscalCode_NotPartecipants";

		_methodParameterTypes471 = new String[] {
				"long", "java.lang.String", "java.lang.String",
				"java.lang.String", "int", "long", "int", "int"
			};

		_methodName472 = "getESFUserByFirstName_LastName_FiscalCode";

		_methodParameterTypes472 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"int", "long", "int", "int"
			};

		_methodName473 = "getESFUserByFiscalCode";

		_methodParameterTypes473 = new String[] { "java.lang.String" };

		_methodName474 = "getAllUserByLikeF_L";

		_methodParameterTypes474 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"int", "int"
			};

		_methodName475 = "countAllUserByLikeF_L";

		_methodParameterTypes475 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String"
			};

		_methodName476 = "getAllUserByLikeF_L_S";

		_methodParameterTypes476 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"int", "int", "int"
			};

		_methodName477 = "getAllUserByLikeF_L_S";

		_methodParameterTypes477 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"int"
			};

		_methodName478 = "getAllUserByLikeF_C_S";

		_methodParameterTypes478 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"int", "long", "int", "int"
			};

		_methodName479 = "getAllUserByLikeF_C_S";

		_methodParameterTypes479 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"int", "long"
			};

		_methodName480 = "getShooterByStateAndOrganization";

		_methodParameterTypes480 = new String[] { "int", "long" };

		_methodName481 = "getAllShooterByLikeF_C_S";

		_methodParameterTypes481 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"long", "int", "int"
			};

		_methodName482 = "getAllShooterByLikeF_C_S";

		_methodParameterTypes482 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"long"
			};

		_methodName483 = "getAllEsfUserByState";

		_methodParameterTypes483 = new String[] { "int" };

		_methodName484 = "getAllEsfUserByState";

		_methodParameterTypes484 = new String[] { "int", "int", "int" };

		_methodName485 = "findUserByRoleT_N_S";

		_methodParameterTypes485 = new String[] {
				"java.lang.String", "java.lang.String", "int"
			};

		_methodName486 = "findAllShooters";

		_methodParameterTypes486 = new String[] { "int", "int" };

		_methodName487 = "findAllShooters";

		_methodParameterTypes487 = new String[] { "long", "int", "int" };

		_methodName488 = "findAllShooters";

		_methodParameterTypes488 = new String[] {
				"long", "int", "int", "int", "int"
			};

		_methodName489 = "findRoledUserOrganization";

		_methodParameterTypes489 = new String[] { "long" };

		_methodName490 = "findRoledUserOrganization";

		_methodParameterTypes490 = new String[] { "long", "int", "int" };

		_methodName491 = "findAllShootersByLeafOrgAssigned";

		_methodParameterTypes491 = new String[] {
				"long", "int", "long", "int", "int", "int"
			};

		_methodName492 = "findAllShootersByLeafOrgAssignedName";

		_methodParameterTypes492 = new String[] {
				"java.lang.String", "java.lang.String", "long", "int", "long",
				"int", "int", "int"
			};

		_methodName493 = "countAllShootersByLeafOrgAssignedName";

		_methodParameterTypes493 = new String[] {
				"java.lang.String", "java.lang.String", "long", "int", "long",
				"int"
			};

		_methodName494 = "findAllShootersByLeafOrgAssigned";

		_methodParameterTypes494 = new String[] { "long", "int", "long", "int" };

		_methodName495 = "findAllShootersByLeafOrg";

		_methodParameterTypes495 = new String[] { "long", "int", "int" };

		_methodName496 = "findAllShootersByLeafOrg";

		_methodParameterTypes496 = new String[] {
				"long", "int", "int", "int", "int"
			};

		_methodName497 = "finNationalDelegationESFUsersByMatchId";

		_methodParameterTypes497 = new String[] { "long" };

		_methodName498 = "findAllStaff";

		_methodParameterTypes498 = new String[] {
				"java.lang.Long", "java.lang.String", "java.lang.String",
				"java.lang.String", "int", "java.lang.Long", "int", "int"
			};

		_methodName499 = "findAllStaffNamed";

		_methodParameterTypes499 = new String[] {
				"java.lang.Long", "java.lang.String", "java.lang.String",
				"java.lang.String", "int", "java.lang.Long", "int", "int"
			};

		_methodName500 = "findStaffNamed";

		_methodParameterTypes500 = new String[] {
				"long", "java.lang.String", "java.lang.String",
				"java.lang.String"
			};

		_methodName501 = "findStaffNamed";

		_methodParameterTypes501 = new String[] {
				"long", "java.lang.String", "java.lang.String",
				"java.lang.String", "int", "int"
			};

		_methodName502 = "findStaffNamedNational";

		_methodParameterTypes502 = new String[] {
				"long", "java.lang.String", "java.lang.String",
				"java.lang.String"
			};

		_methodName503 = "findStaffNamedNational";

		_methodParameterTypes503 = new String[] {
				"long", "java.lang.String", "java.lang.String",
				"java.lang.String", "int", "int"
			};

		_methodName504 = "findStaff";

		_methodParameterTypes504 = new String[] { "long" };

		_methodName505 = "findStaff";

		_methodParameterTypes505 = new String[] { "long", "int", "int" };

		_methodName506 = "finNationalDelegationESFUsersByMatchId";

		_methodParameterTypes506 = new String[] { "long", "int", "int" };

		_methodName507 = "findNationalDelegationStaffESFUsersByMatchId";

		_methodParameterTypes507 = new String[] { "long" };

		_methodName508 = "findNationalDelegationStaffESFUsersByMatchId";

		_methodParameterTypes508 = new String[] { "long", "int", "int" };

		_methodName509 = "findNationalDelegationsESFUsersByMatchId";

		_methodParameterTypes509 = new String[] { "long" };

		_methodName510 = "findNationalDelegationsESFUsersByMatchId";

		_methodParameterTypes510 = new String[] { "long", "int", "int" };

		_methodName511 = "findNationalDelegationsESFUsersByMatchId_PartecipantTypeId";

		_methodParameterTypes511 = new String[] { "long", "long" };

		_methodName512 = "findNationalDelegationsESFUsersByMatchId_PartecipantTypeId";

		_methodParameterTypes512 = new String[] { "long", "long", "int", "int" };

		_methodName513 = "findNationalShooters";

		_methodParameterTypes513 = new String[] {  };

		_methodName514 = "findNationalShooters";

		_methodParameterTypes514 = new String[] { "int", "int" };

		_methodName515 = "findNationalPartecipantShooters";

		_methodParameterTypes515 = new String[] { "long", "boolean" };

		_methodName516 = "findNationalPartecipantShooters";

		_methodParameterTypes516 = new String[] { "long", "boolean", "int", "int" };

		_methodName517 = "findPartecipantShooters";

		_methodParameterTypes517 = new String[] { "int", "int", "long", "boolean" };

		_methodName518 = "findPartecipantShooters";

		_methodParameterTypes518 = new String[] {
				"int", "int", "long", "boolean", "int", "int"
			};

		_methodName519 = "findNationalPartecipantCoaches";

		_methodParameterTypes519 = new String[] { "long", "boolean" };

		_methodName520 = "findNationalPartecipantCoaches";

		_methodParameterTypes520 = new String[] { "long", "boolean", "int", "int" };

		_methodName521 = "findPartecipantCoaches";

		_methodParameterTypes521 = new String[] { "int", "long", "boolean" };

		_methodName522 = "findPartecipantCoaches";

		_methodParameterTypes522 = new String[] {
				"int", "long", "boolean", "int", "int"
			};

		_methodName523 = "findNationalPartecipantReferees";

		_methodParameterTypes523 = new String[] { "long", "boolean" };

		_methodName524 = "findNationalPartecipantReferees";

		_methodParameterTypes524 = new String[] { "long", "boolean", "int", "int" };

		_methodName525 = "findPartecipantReferees";

		_methodParameterTypes525 = new String[] {
				"int", "long", "boolean", "int", "int"
			};

		_methodName526 = "findPartecipantReferees";

		_methodParameterTypes526 = new String[] { "int", "long", "boolean" };

		_methodName527 = "findNationalPartecipantDoctor";

		_methodParameterTypes527 = new String[] { "long", "boolean" };

		_methodName528 = "findNationalPartecipantDoctor";

		_methodParameterTypes528 = new String[] { "long", "boolean", "int", "int" };

		_methodName529 = "findPartecipantDoctor";

		_methodParameterTypes529 = new String[] { "int", "long", "boolean" };

		_methodName530 = "findPartecipantDoctor";

		_methodParameterTypes530 = new String[] {
				"int", "long", "boolean", "int", "int"
			};

		_methodName533 = "addESFUser";

		_methodParameterTypes533 = new String[] {
				"long", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "int", "int", "int", "boolean",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "it.ethica.esf.model.ESFEntityState",
				"java.util.List", "java.util.List", "java.lang.String",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName534 = "addESFUserInOrganization";

		_methodParameterTypes534 = new String[] {
				"long", "java.lang.String", "java.lang.String",
				"java.lang.String", "long", "java.util.Locale",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"int", "int", "boolean", "int", "int", "int", "java.lang.String",
				"it.ethica.esf.model.ESFAddress",
				"it.ethica.esf.model.ESFEntityState", "java.util.List",
				"com.liferay.portal.service.ServiceContext",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName535 = "addESFUserInOrganization";

		_methodParameterTypes535 = new String[] {
				"long", "java.lang.String", "java.lang.String",
				"java.lang.String", "long", "java.util.Locale",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"int", "int", "boolean", "int", "int", "int", "java.lang.String",
				"it.ethica.esf.model.ESFAddress", "long", "java.util.List",
				"com.liferay.portal.service.ServiceContext",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName536 = "deleteESFUser";

		_methodParameterTypes536 = new String[] {
				"long", "java.util.List",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName537 = "updateESFUser";

		_methodParameterTypes537 = new String[] {
				"long", "long", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "int", "int", "int", "boolean", "boolean",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "it.ethica.esf.model.ESFEntityState",
				"java.util.List", "java.util.List", "java.lang.String",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName538 = "addESFShooter";

		_methodParameterTypes538 = new String[] {
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

		_methodName539 = "updateESFShooter";

		_methodParameterTypes539 = new String[] {
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

		_methodName540 = "updateESFUserToESFShooter";

		_methodParameterTypes540 = new String[] {
				"long", "long", "it.ethica.esf.model.ESFCard", "java.util.List",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName541 = "addESFUserToESFShooter";

		_methodParameterTypes541 = new String[] { "long", "long" };

		_methodName543 = "countByESFUserRole";

		_methodParameterTypes543 = new String[] { "long" };

		_methodName544 = "getESFUserRoles";

		_methodParameterTypes544 = new String[] { "long", "boolean" };

		_methodName545 = "getActiveESFUserRoles";

		_methodParameterTypes545 = new String[] { "long" };

		_methodName546 = "findAllUser";

		_methodParameterTypes546 = new String[] {  };

		_methodName547 = "checkEmailAddress";

		_methodParameterTypes547 = new String[] {
				"java.lang.String", "com.liferay.portal.service.ServiceContext"
			};

		_methodName548 = "checkScreenName";

		_methodParameterTypes548 = new String[] {
				"java.lang.String", "com.liferay.portal.service.ServiceContext"
			};

		_methodName549 = "findAllUserByAgeOnlyPeople";

		_methodParameterTypes549 = new String[] {  };

		_methodName550 = "findAllUserByRolenoNull";

		_methodParameterTypes550 = new String[] { "long", "long" };

		_methodName551 = "findShooterRoleAssignedName";

		_methodParameterTypes551 = new String[] {
				"java.lang.String", "java.lang.String", "long", "long", "int",
				"int"
			};

		_methodName552 = "countShooterRoleAssignedName";

		_methodParameterTypes552 = new String[] {
				"java.lang.String", "java.lang.String", "long", "long"
			};

		_methodName553 = "findStaffMatch";

		_methodParameterTypes553 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"long", "long", "int", "int"
			};

		_methodName554 = "countStaffMatch";

		_methodParameterTypes554 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"long", "long"
			};

		_methodName555 = "findShooterNotAssociated";

		_methodParameterTypes555 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"long", "int", "int"
			};

		_methodName556 = "countNotNationalShooterBySPT";

		_methodParameterTypes556 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"long"
			};

		_methodName557 = "findALLShooterNotAssociated";

		_methodParameterTypes557 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"long", "int", "int"
			};

		_methodName558 = "countALLNotNationalShooterBySPT";

		_methodParameterTypes558 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"long"
			};

		_methodName559 = "findStaffNormalMatch";

		_methodParameterTypes559 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"long", "int", "int"
			};

		_methodName560 = "countStaffNormalMatch";

		_methodParameterTypes560 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"long"
			};

		_methodName561 = "countRenwalUser";

		_methodParameterTypes561 = new String[] {
				"java.lang.String", "java.lang.String", "long"
			};

		_methodName562 = "countNewUser";

		_methodParameterTypes562 = new String[] {
				"java.lang.String", "java.lang.String", "long"
			};

		_methodName563 = "findByKeyword";

		_methodParameterTypes563 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName564 = "findShooterByAss";

		_methodParameterTypes564 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"long", "int", "int"
			};

		_methodName565 = "countShooterByAss";

		_methodParameterTypes565 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"long"
			};

		_methodName566 = "findShooterByAssAndNoAss";

		_methodParameterTypes566 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"long", "int", "int"
			};

		_methodName567 = "countShooterByAssAndNoAss";

		_methodParameterTypes567 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"long"
			};

		_methodName568 = "findDirectorByMatch";

		_methodParameterTypes568 = new String[] {
				"java.lang.String", "java.lang.String", "long", "long", "int",
				"int"
			};

		_methodName569 = "countDirectorByMatch";

		_methodParameterTypes569 = new String[] {
				"java.lang.String", "java.lang.String", "long", "long"
			};

		_methodName570 = "findNewYouthShooter";

		_methodParameterTypes570 = new String[] { "int" };

		_methodName571 = "findYouthByCategory";

		_methodParameterTypes571 = new String[] { "long", "int", "int", "int" };

		_methodName572 = "findYouthByCategoryTotal";

		_methodParameterTypes572 = new String[] { "long", "int" };

		_methodName573 = "findNotBDOMemberByAssociatioId";

		_methodParameterTypes573 = new String[] {
				"java.lang.String", "java.lang.String", "long", "int", "int"
			};

		_methodName574 = "countNotBDOMemberByAssociatioId";

		_methodParameterTypes574 = new String[] {
				"java.lang.String", "java.lang.String", "long"
			};

		_methodName575 = "findAssociatedShooterOrganization";

		_methodParameterTypes575 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"long", "int", "int"
			};

		_methodName576 = "countAssociatedShooterOrganization";

		_methodParameterTypes576 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"long"
			};

		_methodName577 = "findByESFFederalRole";

		_methodParameterTypes577 = new String[] { "long" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return ESFUserLocalServiceUtil.addESFUser((it.ethica.esf.model.ESFUser)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return ESFUserLocalServiceUtil.createESFUser(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return ESFUserLocalServiceUtil.deleteESFUser(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return ESFUserLocalServiceUtil.deleteESFUser((it.ethica.esf.model.ESFUser)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return ESFUserLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return ESFUserLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return ESFUserLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return ESFUserLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return ESFUserLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return ESFUserLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return ESFUserLocalServiceUtil.fetchESFUser(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return ESFUserLocalServiceUtil.getESFUser(((Long)arguments[0]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return ESFUserLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return ESFUserLocalServiceUtil.getESFUsers(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return ESFUserLocalServiceUtil.getESFUsersCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return ESFUserLocalServiceUtil.updateESFUser((it.ethica.esf.model.ESFUser)arguments[0]);
		}

		if (_methodName460.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes460, parameterTypes)) {
			return ESFUserLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName461.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes461, parameterTypes)) {
			ESFUserLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName466.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes466, parameterTypes)) {
			return ESFUserLocalServiceUtil.getESFUsersByDeparture(((Long)arguments[0]).longValue());
		}

		if (_methodName467.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes467, parameterTypes)) {
			return ESFUserLocalServiceUtil.getESFUsersByCodeCode((java.lang.String)arguments[0]);
		}

		if (_methodName468.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes468, parameterTypes)) {
			return ESFUserLocalServiceUtil.getESFUserByUserCode(((Long)arguments[0]).longValue());
		}

		if (_methodName469.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes469, parameterTypes)) {
			return ESFUserLocalServiceUtil.getESFUserByCodeUser2(((Long)arguments[0]).longValue());
		}

		if (_methodName470.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes470, parameterTypes)) {
			return ESFUserLocalServiceUtil.getESFUserByFirstName_LastName_FiscalCode_NotPartecipants(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3],
				((Integer)arguments[4]).intValue(),
				((Long)arguments[5]).longValue());
		}

		if (_methodName471.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes471, parameterTypes)) {
			return ESFUserLocalServiceUtil.getESFUserByFirstName_LastName_FiscalCode_NotPartecipants(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3],
				((Integer)arguments[4]).intValue(),
				((Long)arguments[5]).longValue(),
				((Integer)arguments[6]).intValue(),
				((Integer)arguments[7]).intValue());
		}

		if (_methodName472.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes472, parameterTypes)) {
			return ESFUserLocalServiceUtil.getESFUserByFirstName_LastName_FiscalCode((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				((Integer)arguments[3]).intValue(),
				((Long)arguments[4]).longValue(),
				((Integer)arguments[5]).intValue(),
				((Integer)arguments[6]).intValue());
		}

		if (_methodName473.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes473, parameterTypes)) {
			return ESFUserLocalServiceUtil.getESFUserByFiscalCode((java.lang.String)arguments[0]);
		}

		if (_methodName474.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes474, parameterTypes)) {
			return ESFUserLocalServiceUtil.getAllUserByLikeF_L((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue());
		}

		if (_methodName475.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes475, parameterTypes)) {
			return ESFUserLocalServiceUtil.countAllUserByLikeF_L((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2]);
		}

		if (_methodName476.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes476, parameterTypes)) {
			return ESFUserLocalServiceUtil.getAllUserByLikeF_L_S((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue());
		}

		if (_methodName477.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes477, parameterTypes)) {
			return ESFUserLocalServiceUtil.getAllUserByLikeF_L_S((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				((Integer)arguments[3]).intValue());
		}

		if (_methodName478.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes478, parameterTypes)) {
			return ESFUserLocalServiceUtil.getAllUserByLikeF_C_S((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				((Integer)arguments[3]).intValue(),
				((Long)arguments[4]).longValue(),
				((Integer)arguments[5]).intValue(),
				((Integer)arguments[6]).intValue());
		}

		if (_methodName479.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes479, parameterTypes)) {
			return ESFUserLocalServiceUtil.getAllUserByLikeF_C_S((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				((Integer)arguments[3]).intValue(),
				((Long)arguments[4]).longValue());
		}

		if (_methodName480.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes480, parameterTypes)) {
			return ESFUserLocalServiceUtil.getShooterByStateAndOrganization(((Integer)arguments[0]).intValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName481.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes481, parameterTypes)) {
			return ESFUserLocalServiceUtil.getAllShooterByLikeF_C_S((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				((Long)arguments[3]).longValue(),
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue());
		}

		if (_methodName482.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes482, parameterTypes)) {
			return ESFUserLocalServiceUtil.getAllShooterByLikeF_C_S((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				((Long)arguments[3]).longValue());
		}

		if (_methodName483.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes483, parameterTypes)) {
			return ESFUserLocalServiceUtil.getAllEsfUserByState(((Integer)arguments[0]).intValue());
		}

		if (_methodName484.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes484, parameterTypes)) {
			return ESFUserLocalServiceUtil.getAllEsfUserByState(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName485.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes485, parameterTypes)) {
			return ESFUserLocalServiceUtil.findUserByRoleT_N_S((java.lang.String)arguments[0],
				(java.lang.String)arguments[1],
				((Integer)arguments[2]).intValue());
		}

		if (_methodName486.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes486, parameterTypes)) {
			return ESFUserLocalServiceUtil.findAllShooters(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName487.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes487, parameterTypes)) {
			return ESFUserLocalServiceUtil.findAllShooters(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName488.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes488, parameterTypes)) {
			return ESFUserLocalServiceUtil.findAllShooters(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue());
		}

		if (_methodName489.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes489, parameterTypes)) {
			return ESFUserLocalServiceUtil.findRoledUserOrganization(((Long)arguments[0]).longValue());
		}

		if (_methodName490.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes490, parameterTypes)) {
			return ESFUserLocalServiceUtil.findRoledUserOrganization(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName491.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes491, parameterTypes)) {
			return ESFUserLocalServiceUtil.findAllShootersByLeafOrgAssigned(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Long)arguments[2]).longValue(),
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue());
		}

		if (_methodName492.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes492, parameterTypes)) {
			return ESFUserLocalServiceUtil.findAllShootersByLeafOrgAssignedName((java.lang.String)arguments[0],
				(java.lang.String)arguments[1],
				((Long)arguments[2]).longValue(),
				((Integer)arguments[3]).intValue(),
				((Long)arguments[4]).longValue(),
				((Integer)arguments[5]).intValue(),
				((Integer)arguments[6]).intValue(),
				((Integer)arguments[7]).intValue());
		}

		if (_methodName493.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes493, parameterTypes)) {
			return ESFUserLocalServiceUtil.countAllShootersByLeafOrgAssignedName((java.lang.String)arguments[0],
				(java.lang.String)arguments[1],
				((Long)arguments[2]).longValue(),
				((Integer)arguments[3]).intValue(),
				((Long)arguments[4]).longValue(),
				((Integer)arguments[5]).intValue());
		}

		if (_methodName494.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes494, parameterTypes)) {
			return ESFUserLocalServiceUtil.findAllShootersByLeafOrgAssigned(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Long)arguments[2]).longValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName495.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes495, parameterTypes)) {
			return ESFUserLocalServiceUtil.findAllShootersByLeafOrg(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName496.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes496, parameterTypes)) {
			return ESFUserLocalServiceUtil.findAllShootersByLeafOrg(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue());
		}

		if (_methodName497.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes497, parameterTypes)) {
			return ESFUserLocalServiceUtil.finNationalDelegationESFUsersByMatchId(((Long)arguments[0]).longValue());
		}

		if (_methodName498.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes498, parameterTypes)) {
			return ESFUserLocalServiceUtil.findAllStaff((java.lang.Long)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3],
				((Integer)arguments[4]).intValue(),
				(java.lang.Long)arguments[5],
				((Integer)arguments[6]).intValue(),
				((Integer)arguments[7]).intValue());
		}

		if (_methodName499.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes499, parameterTypes)) {
			return ESFUserLocalServiceUtil.findAllStaffNamed((java.lang.Long)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3],
				((Integer)arguments[4]).intValue(),
				(java.lang.Long)arguments[5],
				((Integer)arguments[6]).intValue(),
				((Integer)arguments[7]).intValue());
		}

		if (_methodName500.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes500, parameterTypes)) {
			return ESFUserLocalServiceUtil.findStaffNamed(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3]);
		}

		if (_methodName501.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes501, parameterTypes)) {
			return ESFUserLocalServiceUtil.findStaffNamed(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3],
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue());
		}

		if (_methodName502.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes502, parameterTypes)) {
			return ESFUserLocalServiceUtil.findStaffNamedNational(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3]);
		}

		if (_methodName503.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes503, parameterTypes)) {
			return ESFUserLocalServiceUtil.findStaffNamedNational(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3],
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue());
		}

		if (_methodName504.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes504, parameterTypes)) {
			return ESFUserLocalServiceUtil.findStaff(((Long)arguments[0]).longValue());
		}

		if (_methodName505.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes505, parameterTypes)) {
			return ESFUserLocalServiceUtil.findStaff(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName506.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes506, parameterTypes)) {
			return ESFUserLocalServiceUtil.finNationalDelegationESFUsersByMatchId(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName507.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes507, parameterTypes)) {
			return ESFUserLocalServiceUtil.findNationalDelegationStaffESFUsersByMatchId(((Long)arguments[0]).longValue());
		}

		if (_methodName508.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes508, parameterTypes)) {
			return ESFUserLocalServiceUtil.findNationalDelegationStaffESFUsersByMatchId(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName509.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes509, parameterTypes)) {
			return ESFUserLocalServiceUtil.findNationalDelegationsESFUsersByMatchId(((Long)arguments[0]).longValue());
		}

		if (_methodName510.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes510, parameterTypes)) {
			return ESFUserLocalServiceUtil.findNationalDelegationsESFUsersByMatchId(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName511.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes511, parameterTypes)) {
			return ESFUserLocalServiceUtil.findNationalDelegationsESFUsersByMatchId_PartecipantTypeId(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName512.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes512, parameterTypes)) {
			return ESFUserLocalServiceUtil.findNationalDelegationsESFUsersByMatchId_PartecipantTypeId(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName513.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes513, parameterTypes)) {
			return ESFUserLocalServiceUtil.findNationalShooters();
		}

		if (_methodName514.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes514, parameterTypes)) {
			return ESFUserLocalServiceUtil.findNationalShooters(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName515.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes515, parameterTypes)) {
			return ESFUserLocalServiceUtil.findNationalPartecipantShooters(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue());
		}

		if (_methodName516.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes516, parameterTypes)) {
			return ESFUserLocalServiceUtil.findNationalPartecipantShooters(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName517.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes517, parameterTypes)) {
			return ESFUserLocalServiceUtil.findPartecipantShooters(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue(),
				((Long)arguments[2]).longValue(),
				((Boolean)arguments[3]).booleanValue());
		}

		if (_methodName518.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes518, parameterTypes)) {
			return ESFUserLocalServiceUtil.findPartecipantShooters(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue(),
				((Long)arguments[2]).longValue(),
				((Boolean)arguments[3]).booleanValue(),
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue());
		}

		if (_methodName519.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes519, parameterTypes)) {
			return ESFUserLocalServiceUtil.findNationalPartecipantCoaches(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue());
		}

		if (_methodName520.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes520, parameterTypes)) {
			return ESFUserLocalServiceUtil.findNationalPartecipantCoaches(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName521.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes521, parameterTypes)) {
			return ESFUserLocalServiceUtil.findPartecipantCoaches(((Integer)arguments[0]).intValue(),
				((Long)arguments[1]).longValue(),
				((Boolean)arguments[2]).booleanValue());
		}

		if (_methodName522.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes522, parameterTypes)) {
			return ESFUserLocalServiceUtil.findPartecipantCoaches(((Integer)arguments[0]).intValue(),
				((Long)arguments[1]).longValue(),
				((Boolean)arguments[2]).booleanValue(),
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue());
		}

		if (_methodName523.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes523, parameterTypes)) {
			return ESFUserLocalServiceUtil.findNationalPartecipantReferees(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue());
		}

		if (_methodName524.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes524, parameterTypes)) {
			return ESFUserLocalServiceUtil.findNationalPartecipantReferees(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName525.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes525, parameterTypes)) {
			return ESFUserLocalServiceUtil.findPartecipantReferees(((Integer)arguments[0]).intValue(),
				((Long)arguments[1]).longValue(),
				((Boolean)arguments[2]).booleanValue(),
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue());
		}

		if (_methodName526.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes526, parameterTypes)) {
			return ESFUserLocalServiceUtil.findPartecipantReferees(((Integer)arguments[0]).intValue(),
				((Long)arguments[1]).longValue(),
				((Boolean)arguments[2]).booleanValue());
		}

		if (_methodName527.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes527, parameterTypes)) {
			return ESFUserLocalServiceUtil.findNationalPartecipantDoctor(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue());
		}

		if (_methodName528.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes528, parameterTypes)) {
			return ESFUserLocalServiceUtil.findNationalPartecipantDoctor(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName529.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes529, parameterTypes)) {
			return ESFUserLocalServiceUtil.findPartecipantDoctor(((Integer)arguments[0]).intValue(),
				((Long)arguments[1]).longValue(),
				((Boolean)arguments[2]).booleanValue());
		}

		if (_methodName530.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes530, parameterTypes)) {
			return ESFUserLocalServiceUtil.findPartecipantDoctor(((Integer)arguments[0]).intValue(),
				((Long)arguments[1]).longValue(),
				((Boolean)arguments[2]).booleanValue(),
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue());
		}

		if (_methodName533.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes533, parameterTypes)) {
			return ESFUserLocalServiceUtil.addESFUser(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3], (java.lang.String)arguments[4],
				(java.lang.String)arguments[5], (java.lang.String)arguments[6],
				((Integer)arguments[7]).intValue(),
				((Integer)arguments[8]).intValue(),
				((Integer)arguments[9]).intValue(),
				((Boolean)arguments[10]).booleanValue(),
				(java.lang.String)arguments[11],
				(java.lang.String)arguments[12],
				(java.lang.String)arguments[13],
				(java.lang.String)arguments[14],
				(it.ethica.esf.model.ESFEntityState)arguments[15],
				(java.util.List<it.ethica.esf.model.ESFAddress>)arguments[16],
				(java.util.List<it.ethica.esf.model.ESFPhone>)arguments[17],
				(java.lang.String)arguments[18],
				(com.liferay.portal.service.ServiceContext)arguments[19]);
		}

		if (_methodName534.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes534, parameterTypes)) {
			return ESFUserLocalServiceUtil.addESFUserInOrganization(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3],
				((Long)arguments[4]).longValue(),
				(java.util.Locale)arguments[5], (java.lang.String)arguments[6],
				(java.lang.String)arguments[7], (java.lang.String)arguments[8],
				((Integer)arguments[9]).intValue(),
				((Integer)arguments[10]).intValue(),
				((Boolean)arguments[11]).booleanValue(),
				((Integer)arguments[12]).intValue(),
				((Integer)arguments[13]).intValue(),
				((Integer)arguments[14]).intValue(),
				(java.lang.String)arguments[15],
				(it.ethica.esf.model.ESFAddress)arguments[16],
				(it.ethica.esf.model.ESFEntityState)arguments[17],
				(java.util.List<com.liferay.portal.model.Phone>)arguments[18],
				(com.liferay.portal.service.ServiceContext)arguments[19],
				(com.liferay.portal.service.ServiceContext)arguments[20]);
		}

		if (_methodName535.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes535, parameterTypes)) {
			return ESFUserLocalServiceUtil.addESFUserInOrganization(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3],
				((Long)arguments[4]).longValue(),
				(java.util.Locale)arguments[5], (java.lang.String)arguments[6],
				(java.lang.String)arguments[7], (java.lang.String)arguments[8],
				((Integer)arguments[9]).intValue(),
				((Integer)arguments[10]).intValue(),
				((Boolean)arguments[11]).booleanValue(),
				((Integer)arguments[12]).intValue(),
				((Integer)arguments[13]).intValue(),
				((Integer)arguments[14]).intValue(),
				(java.lang.String)arguments[15],
				(it.ethica.esf.model.ESFAddress)arguments[16],
				((Long)arguments[17]).longValue(),
				(java.util.List<com.liferay.portal.model.Phone>)arguments[18],
				(com.liferay.portal.service.ServiceContext)arguments[19],
				(com.liferay.portal.service.ServiceContext)arguments[20]);
		}

		if (_methodName536.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes536, parameterTypes)) {
			return ESFUserLocalServiceUtil.deleteESFUser(((Long)arguments[0]).longValue(),
				(java.util.List<it.ethica.esf.model.ESFAddress>)arguments[1],
				(com.liferay.portal.service.ServiceContext)arguments[2]);
		}

		if (_methodName537.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes537, parameterTypes)) {
			return ESFUserLocalServiceUtil.updateESFUser(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3],
				(java.lang.String)arguments[4], (java.lang.String)arguments[5],
				(java.lang.String)arguments[6], (java.lang.String)arguments[7],
				((Integer)arguments[8]).intValue(),
				((Integer)arguments[9]).intValue(),
				((Integer)arguments[10]).intValue(),
				((Boolean)arguments[11]).booleanValue(),
				((Boolean)arguments[12]).booleanValue(),
				(java.lang.String)arguments[13],
				(java.lang.String)arguments[14],
				(java.lang.String)arguments[15],
				(java.lang.String)arguments[16],
				(it.ethica.esf.model.ESFEntityState)arguments[17],
				(java.util.List<it.ethica.esf.model.ESFAddress>)arguments[18],
				(java.util.List<it.ethica.esf.model.ESFPhone>)arguments[19],
				(java.lang.String)arguments[20],
				(com.liferay.portal.service.ServiceContext)arguments[21]);
		}

		if (_methodName538.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes538, parameterTypes)) {
			return ESFUserLocalServiceUtil.addESFShooter(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3], (java.lang.String)arguments[4],
				(java.lang.String)arguments[5], (java.lang.String)arguments[6],
				((Integer)arguments[7]).intValue(),
				((Integer)arguments[8]).intValue(),
				((Integer)arguments[9]).intValue(),
				(java.lang.String)arguments[10],
				(java.lang.String)arguments[11],
				((Boolean)arguments[12]).booleanValue(),
				(java.lang.String)arguments[13],
				(java.lang.String)arguments[14],
				(java.lang.String)arguments[15],
				((Long)arguments[16]).longValue(),
				((Boolean)arguments[17]).booleanValue(),
				(java.lang.String)arguments[18],
				(java.lang.String)arguments[19],
				(java.lang.String)arguments[20],
				(it.ethica.esf.model.ESFEntityState)arguments[21],
				(it.ethica.esf.model.ESFCard)arguments[22],
				(java.util.List<it.ethica.esf.model.ESFAddress>)arguments[23],
				(java.util.List<it.ethica.esf.model.ESFPhone>)arguments[24],
				((Boolean)arguments[25]).booleanValue(),
				((Boolean)arguments[26]).booleanValue(),
				((Boolean)arguments[27]).booleanValue(),
				(java.util.Date)arguments[28], (java.util.Date)arguments[29],
				(java.util.Date)arguments[30],
				((Boolean)arguments[31]).booleanValue(),
				((Long)arguments[32]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[33]);
		}

		if (_methodName539.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes539, parameterTypes)) {
			return ESFUserLocalServiceUtil.updateESFShooter(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3],
				(java.lang.String)arguments[4], (java.lang.String)arguments[5],
				(java.lang.String)arguments[6], (java.lang.String)arguments[7],
				((Integer)arguments[8]).intValue(),
				((Integer)arguments[9]).intValue(),
				((Integer)arguments[10]).intValue(),
				(java.lang.String)arguments[11],
				(java.lang.String)arguments[12],
				((Boolean)arguments[13]).booleanValue(),
				((Boolean)arguments[14]).booleanValue(),
				(java.lang.String)arguments[15],
				(java.lang.String)arguments[16],
				(java.lang.String)arguments[17],
				((Long)arguments[18]).longValue(),
				((Boolean)arguments[19]).booleanValue(),
				(java.lang.String)arguments[20],
				(java.lang.String)arguments[21],
				(java.lang.String)arguments[22],
				(it.ethica.esf.model.ESFEntityState)arguments[23],
				(it.ethica.esf.model.ESFCard)arguments[24],
				(java.util.List<it.ethica.esf.model.ESFAddress>)arguments[25],
				(java.util.List<it.ethica.esf.model.ESFPhone>)arguments[26],
				(java.util.Date)arguments[27],
				((Boolean)arguments[28]).booleanValue(),
				((Boolean)arguments[29]).booleanValue(),
				((Boolean)arguments[30]).booleanValue(),
				(java.util.Date)arguments[31], (java.util.Date)arguments[32],
				(java.util.Date)arguments[33],
				((Boolean)arguments[34]).booleanValue(),
				((Long)arguments[35]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[36]);
		}

		if (_methodName540.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes540, parameterTypes)) {
			ESFUserLocalServiceUtil.updateESFUserToESFShooter(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				(it.ethica.esf.model.ESFCard)arguments[2],
				(java.util.List<it.ethica.esf.model.ESFCard>)arguments[3],
				(com.liferay.portal.service.ServiceContext)arguments[4]);

			return null;
		}

		if (_methodName541.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes541, parameterTypes)) {
			ESFUserLocalServiceUtil.addESFUserToESFShooter(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());

			return null;
		}

		if (_methodName543.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes543, parameterTypes)) {
			return ESFUserLocalServiceUtil.countByESFUserRole(((Long)arguments[0]).longValue());
		}

		if (_methodName544.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes544, parameterTypes)) {
			return ESFUserLocalServiceUtil.getESFUserRoles(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue());
		}

		if (_methodName545.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes545, parameterTypes)) {
			return ESFUserLocalServiceUtil.getActiveESFUserRoles(((Long)arguments[0]).longValue());
		}

		if (_methodName546.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes546, parameterTypes)) {
			return ESFUserLocalServiceUtil.findAllUser();
		}

		if (_methodName547.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes547, parameterTypes)) {
			return ESFUserLocalServiceUtil.checkEmailAddress((java.lang.String)arguments[0],
				(com.liferay.portal.service.ServiceContext)arguments[1]);
		}

		if (_methodName548.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes548, parameterTypes)) {
			return ESFUserLocalServiceUtil.checkScreenName((java.lang.String)arguments[0],
				(com.liferay.portal.service.ServiceContext)arguments[1]);
		}

		if (_methodName549.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes549, parameterTypes)) {
			return ESFUserLocalServiceUtil.findAllUserByAgeOnlyPeople();
		}

		if (_methodName550.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes550, parameterTypes)) {
			return ESFUserLocalServiceUtil.findAllUserByRolenoNull(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName551.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes551, parameterTypes)) {
			return ESFUserLocalServiceUtil.findShooterRoleAssignedName((java.lang.String)arguments[0],
				(java.lang.String)arguments[1],
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue(),
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue());
		}

		if (_methodName552.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes552, parameterTypes)) {
			return ESFUserLocalServiceUtil.countShooterRoleAssignedName((java.lang.String)arguments[0],
				(java.lang.String)arguments[1],
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue());
		}

		if (_methodName553.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes553, parameterTypes)) {
			return ESFUserLocalServiceUtil.findStaffMatch((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				((Long)arguments[3]).longValue(),
				((Long)arguments[4]).longValue(),
				((Integer)arguments[5]).intValue(),
				((Integer)arguments[6]).intValue());
		}

		if (_methodName554.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes554, parameterTypes)) {
			return ESFUserLocalServiceUtil.countStaffMatch((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				((Long)arguments[3]).longValue(),
				((Long)arguments[4]).longValue());
		}

		if (_methodName555.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes555, parameterTypes)) {
			return ESFUserLocalServiceUtil.findShooterNotAssociated((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				((Long)arguments[3]).longValue(),
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue());
		}

		if (_methodName556.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes556, parameterTypes)) {
			return ESFUserLocalServiceUtil.countNotNationalShooterBySPT((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				((Long)arguments[3]).longValue());
		}

		if (_methodName557.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes557, parameterTypes)) {
			return ESFUserLocalServiceUtil.findALLShooterNotAssociated((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				((Long)arguments[3]).longValue(),
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue());
		}

		if (_methodName558.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes558, parameterTypes)) {
			return ESFUserLocalServiceUtil.countALLNotNationalShooterBySPT((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				((Long)arguments[3]).longValue());
		}

		if (_methodName559.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes559, parameterTypes)) {
			return ESFUserLocalServiceUtil.findStaffNormalMatch((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				((Long)arguments[3]).longValue(),
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue());
		}

		if (_methodName560.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes560, parameterTypes)) {
			return ESFUserLocalServiceUtil.countStaffNormalMatch((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				((Long)arguments[3]).longValue());
		}

		if (_methodName561.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes561, parameterTypes)) {
			return ESFUserLocalServiceUtil.countRenwalUser((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], ((Long)arguments[2]).longValue());
		}

		if (_methodName562.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes562, parameterTypes)) {
			return ESFUserLocalServiceUtil.countNewUser((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], ((Long)arguments[2]).longValue());
		}

		if (_methodName563.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes563, parameterTypes)) {
			return ESFUserLocalServiceUtil.findByKeyword((java.lang.String)arguments[0],
				(java.lang.String)arguments[1]);
		}

		if (_methodName564.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes564, parameterTypes)) {
			return ESFUserLocalServiceUtil.findShooterByAss((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				((Long)arguments[3]).longValue(),
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue());
		}

		if (_methodName565.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes565, parameterTypes)) {
			return ESFUserLocalServiceUtil.countShooterByAss((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				((Long)arguments[3]).longValue());
		}

		if (_methodName566.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes566, parameterTypes)) {
			return ESFUserLocalServiceUtil.findShooterByAssAndNoAss((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				((Long)arguments[3]).longValue(),
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue());
		}

		if (_methodName567.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes567, parameterTypes)) {
			return ESFUserLocalServiceUtil.countShooterByAssAndNoAss((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				((Long)arguments[3]).longValue());
		}

		if (_methodName568.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes568, parameterTypes)) {
			return ESFUserLocalServiceUtil.findDirectorByMatch((java.lang.String)arguments[0],
				(java.lang.String)arguments[1],
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue(),
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue());
		}

		if (_methodName569.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes569, parameterTypes)) {
			return ESFUserLocalServiceUtil.countDirectorByMatch((java.lang.String)arguments[0],
				(java.lang.String)arguments[1],
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue());
		}

		if (_methodName570.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes570, parameterTypes)) {
			return ESFUserLocalServiceUtil.findNewYouthShooter(((Integer)arguments[0]).intValue());
		}

		if (_methodName571.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes571, parameterTypes)) {
			return ESFUserLocalServiceUtil.findYouthByCategory(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName572.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes572, parameterTypes)) {
			return ESFUserLocalServiceUtil.findYouthByCategoryTotal(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName573.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes573, parameterTypes)) {
			return ESFUserLocalServiceUtil.findNotBDOMemberByAssociatioId((java.lang.String)arguments[0],
				(java.lang.String)arguments[1],
				((Long)arguments[2]).longValue(),
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue());
		}

		if (_methodName574.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes574, parameterTypes)) {
			return ESFUserLocalServiceUtil.countNotBDOMemberByAssociatioId((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], ((Long)arguments[2]).longValue());
		}

		if (_methodName575.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes575, parameterTypes)) {
			return ESFUserLocalServiceUtil.findAssociatedShooterOrganization((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				((Long)arguments[3]).longValue(),
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue());
		}

		if (_methodName576.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes576, parameterTypes)) {
			return ESFUserLocalServiceUtil.countAssociatedShooterOrganization((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				((Long)arguments[3]).longValue());
		}

		if (_methodName577.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes577, parameterTypes)) {
			return ESFUserLocalServiceUtil.findByESFFederalRole(((Long)arguments[0]).longValue());
		}

		throw new UnsupportedOperationException();
	}

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
	private String _methodName460;
	private String[] _methodParameterTypes460;
	private String _methodName461;
	private String[] _methodParameterTypes461;
	private String _methodName466;
	private String[] _methodParameterTypes466;
	private String _methodName467;
	private String[] _methodParameterTypes467;
	private String _methodName468;
	private String[] _methodParameterTypes468;
	private String _methodName469;
	private String[] _methodParameterTypes469;
	private String _methodName470;
	private String[] _methodParameterTypes470;
	private String _methodName471;
	private String[] _methodParameterTypes471;
	private String _methodName472;
	private String[] _methodParameterTypes472;
	private String _methodName473;
	private String[] _methodParameterTypes473;
	private String _methodName474;
	private String[] _methodParameterTypes474;
	private String _methodName475;
	private String[] _methodParameterTypes475;
	private String _methodName476;
	private String[] _methodParameterTypes476;
	private String _methodName477;
	private String[] _methodParameterTypes477;
	private String _methodName478;
	private String[] _methodParameterTypes478;
	private String _methodName479;
	private String[] _methodParameterTypes479;
	private String _methodName480;
	private String[] _methodParameterTypes480;
	private String _methodName481;
	private String[] _methodParameterTypes481;
	private String _methodName482;
	private String[] _methodParameterTypes482;
	private String _methodName483;
	private String[] _methodParameterTypes483;
	private String _methodName484;
	private String[] _methodParameterTypes484;
	private String _methodName485;
	private String[] _methodParameterTypes485;
	private String _methodName486;
	private String[] _methodParameterTypes486;
	private String _methodName487;
	private String[] _methodParameterTypes487;
	private String _methodName488;
	private String[] _methodParameterTypes488;
	private String _methodName489;
	private String[] _methodParameterTypes489;
	private String _methodName490;
	private String[] _methodParameterTypes490;
	private String _methodName491;
	private String[] _methodParameterTypes491;
	private String _methodName492;
	private String[] _methodParameterTypes492;
	private String _methodName493;
	private String[] _methodParameterTypes493;
	private String _methodName494;
	private String[] _methodParameterTypes494;
	private String _methodName495;
	private String[] _methodParameterTypes495;
	private String _methodName496;
	private String[] _methodParameterTypes496;
	private String _methodName497;
	private String[] _methodParameterTypes497;
	private String _methodName498;
	private String[] _methodParameterTypes498;
	private String _methodName499;
	private String[] _methodParameterTypes499;
	private String _methodName500;
	private String[] _methodParameterTypes500;
	private String _methodName501;
	private String[] _methodParameterTypes501;
	private String _methodName502;
	private String[] _methodParameterTypes502;
	private String _methodName503;
	private String[] _methodParameterTypes503;
	private String _methodName504;
	private String[] _methodParameterTypes504;
	private String _methodName505;
	private String[] _methodParameterTypes505;
	private String _methodName506;
	private String[] _methodParameterTypes506;
	private String _methodName507;
	private String[] _methodParameterTypes507;
	private String _methodName508;
	private String[] _methodParameterTypes508;
	private String _methodName509;
	private String[] _methodParameterTypes509;
	private String _methodName510;
	private String[] _methodParameterTypes510;
	private String _methodName511;
	private String[] _methodParameterTypes511;
	private String _methodName512;
	private String[] _methodParameterTypes512;
	private String _methodName513;
	private String[] _methodParameterTypes513;
	private String _methodName514;
	private String[] _methodParameterTypes514;
	private String _methodName515;
	private String[] _methodParameterTypes515;
	private String _methodName516;
	private String[] _methodParameterTypes516;
	private String _methodName517;
	private String[] _methodParameterTypes517;
	private String _methodName518;
	private String[] _methodParameterTypes518;
	private String _methodName519;
	private String[] _methodParameterTypes519;
	private String _methodName520;
	private String[] _methodParameterTypes520;
	private String _methodName521;
	private String[] _methodParameterTypes521;
	private String _methodName522;
	private String[] _methodParameterTypes522;
	private String _methodName523;
	private String[] _methodParameterTypes523;
	private String _methodName524;
	private String[] _methodParameterTypes524;
	private String _methodName525;
	private String[] _methodParameterTypes525;
	private String _methodName526;
	private String[] _methodParameterTypes526;
	private String _methodName527;
	private String[] _methodParameterTypes527;
	private String _methodName528;
	private String[] _methodParameterTypes528;
	private String _methodName529;
	private String[] _methodParameterTypes529;
	private String _methodName530;
	private String[] _methodParameterTypes530;
	private String _methodName533;
	private String[] _methodParameterTypes533;
	private String _methodName534;
	private String[] _methodParameterTypes534;
	private String _methodName535;
	private String[] _methodParameterTypes535;
	private String _methodName536;
	private String[] _methodParameterTypes536;
	private String _methodName537;
	private String[] _methodParameterTypes537;
	private String _methodName538;
	private String[] _methodParameterTypes538;
	private String _methodName539;
	private String[] _methodParameterTypes539;
	private String _methodName540;
	private String[] _methodParameterTypes540;
	private String _methodName541;
	private String[] _methodParameterTypes541;
	private String _methodName543;
	private String[] _methodParameterTypes543;
	private String _methodName544;
	private String[] _methodParameterTypes544;
	private String _methodName545;
	private String[] _methodParameterTypes545;
	private String _methodName546;
	private String[] _methodParameterTypes546;
	private String _methodName547;
	private String[] _methodParameterTypes547;
	private String _methodName548;
	private String[] _methodParameterTypes548;
	private String _methodName549;
	private String[] _methodParameterTypes549;
	private String _methodName550;
	private String[] _methodParameterTypes550;
	private String _methodName551;
	private String[] _methodParameterTypes551;
	private String _methodName552;
	private String[] _methodParameterTypes552;
	private String _methodName553;
	private String[] _methodParameterTypes553;
	private String _methodName554;
	private String[] _methodParameterTypes554;
	private String _methodName555;
	private String[] _methodParameterTypes555;
	private String _methodName556;
	private String[] _methodParameterTypes556;
	private String _methodName557;
	private String[] _methodParameterTypes557;
	private String _methodName558;
	private String[] _methodParameterTypes558;
	private String _methodName559;
	private String[] _methodParameterTypes559;
	private String _methodName560;
	private String[] _methodParameterTypes560;
	private String _methodName561;
	private String[] _methodParameterTypes561;
	private String _methodName562;
	private String[] _methodParameterTypes562;
	private String _methodName563;
	private String[] _methodParameterTypes563;
	private String _methodName564;
	private String[] _methodParameterTypes564;
	private String _methodName565;
	private String[] _methodParameterTypes565;
	private String _methodName566;
	private String[] _methodParameterTypes566;
	private String _methodName567;
	private String[] _methodParameterTypes567;
	private String _methodName568;
	private String[] _methodParameterTypes568;
	private String _methodName569;
	private String[] _methodParameterTypes569;
	private String _methodName570;
	private String[] _methodParameterTypes570;
	private String _methodName571;
	private String[] _methodParameterTypes571;
	private String _methodName572;
	private String[] _methodParameterTypes572;
	private String _methodName573;
	private String[] _methodParameterTypes573;
	private String _methodName574;
	private String[] _methodParameterTypes574;
	private String _methodName575;
	private String[] _methodParameterTypes575;
	private String _methodName576;
	private String[] _methodParameterTypes576;
	private String _methodName577;
	private String[] _methodParameterTypes577;
}