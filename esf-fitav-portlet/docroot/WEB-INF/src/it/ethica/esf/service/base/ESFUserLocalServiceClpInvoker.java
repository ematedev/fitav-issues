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

		_methodName404 = "getBeanIdentifier";

		_methodParameterTypes404 = new String[] {  };

		_methodName405 = "setBeanIdentifier";

		_methodParameterTypes405 = new String[] { "java.lang.String" };

		_methodName410 = "getESFUsersByDeparture";

		_methodParameterTypes410 = new String[] { "long" };

		_methodName411 = "getESFUsersByCodeCode";

		_methodParameterTypes411 = new String[] { "java.lang.String" };

		_methodName412 = "getESFUserByUserCode";

		_methodParameterTypes412 = new String[] { "long" };

		_methodName413 = "getESFUserByCodeUser2";

		_methodParameterTypes413 = new String[] { "long" };

		_methodName414 = "getESFUserByFirstName_LastName_FiscalCode_NotPartecipants";

		_methodParameterTypes414 = new String[] {
				"long", "java.lang.String", "java.lang.String",
				"java.lang.String", "int", "long"
			};

		_methodName415 = "getESFUserByFirstName_LastName_FiscalCode_NotPartecipants";

		_methodParameterTypes415 = new String[] {
				"long", "java.lang.String", "java.lang.String",
				"java.lang.String", "int", "long", "int", "int"
			};

		_methodName416 = "getESFUserByFirstName_LastName_FiscalCode";

		_methodParameterTypes416 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"int", "long", "int", "int"
			};

		_methodName417 = "getESFUserByFiscalCode";

		_methodParameterTypes417 = new String[] { "java.lang.String" };

		_methodName418 = "getAllUserByLikeF_L";

		_methodParameterTypes418 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"int", "int"
			};

		_methodName419 = "countAllUserByLikeF_L";

		_methodParameterTypes419 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String"
			};

		_methodName420 = "getAllUserByLikeF_L_S";

		_methodParameterTypes420 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"int", "int", "int"
			};

		_methodName421 = "getAllUserByLikeF_L_S";

		_methodParameterTypes421 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"int"
			};

		_methodName422 = "getAllUserByLikeF_C_S";

		_methodParameterTypes422 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"int", "long", "int", "int"
			};

		_methodName423 = "getAllUserByLikeF_C_S";

		_methodParameterTypes423 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"int", "long"
			};

		_methodName424 = "getAllShooterByLikeF_C_S";

		_methodParameterTypes424 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"long", "int", "int"
			};

		_methodName425 = "getAllShooterByLikeF_C_S";

		_methodParameterTypes425 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"long"
			};

		_methodName426 = "getAllEsfUserByState";

		_methodParameterTypes426 = new String[] { "int" };

		_methodName427 = "getAllEsfUserByState";

		_methodParameterTypes427 = new String[] { "int", "int", "int" };

		_methodName428 = "findUserByRoleT_N_S";

		_methodParameterTypes428 = new String[] {
				"java.lang.String", "java.lang.String", "int"
			};

		_methodName429 = "findAllShooters";

		_methodParameterTypes429 = new String[] { "int", "int" };

		_methodName430 = "findAllShooters";

		_methodParameterTypes430 = new String[] { "long", "int", "int" };

		_methodName431 = "findAllShooters";

		_methodParameterTypes431 = new String[] {
				"long", "int", "int", "int", "int"
			};

		_methodName432 = "findRoledUserOrganization";

		_methodParameterTypes432 = new String[] { "long" };

		_methodName433 = "findRoledUserOrganization";

		_methodParameterTypes433 = new String[] { "long", "int", "int" };

		_methodName434 = "findAllShootersByLeafOrgAssigned";

		_methodParameterTypes434 = new String[] {
				"long", "int", "long", "int", "int", "int"
			};

		_methodName435 = "findAllShootersByLeafOrgAssignedName";

		_methodParameterTypes435 = new String[] {
				"java.lang.String", "java.lang.String", "long", "int", "long",
				"int", "int", "int"
			};

		_methodName436 = "countAllShootersByLeafOrgAssignedName";

		_methodParameterTypes436 = new String[] {
				"java.lang.String", "java.lang.String", "long", "int", "long",
				"int"
			};

		_methodName437 = "findAllShootersByLeafOrgAssigned";

		_methodParameterTypes437 = new String[] { "long", "int", "long", "int" };

		_methodName438 = "findAllShootersByLeafOrg";

		_methodParameterTypes438 = new String[] { "long", "int", "int" };

		_methodName439 = "findAllShootersByLeafOrg";

		_methodParameterTypes439 = new String[] {
				"long", "int", "int", "int", "int"
			};

		_methodName440 = "finNationalDelegationESFUsersByMatchId";

		_methodParameterTypes440 = new String[] { "long" };

		_methodName441 = "findAllStaff";

		_methodParameterTypes441 = new String[] {
				"java.lang.Long", "java.lang.String", "java.lang.String",
				"java.lang.String", "int", "java.lang.Long", "int", "int"
			};

		_methodName442 = "findAllStaffNamed";

		_methodParameterTypes442 = new String[] {
				"java.lang.Long", "java.lang.String", "java.lang.String",
				"java.lang.String", "int", "java.lang.Long", "int", "int"
			};

		_methodName443 = "findStaffNamed";

		_methodParameterTypes443 = new String[] {
				"long", "java.lang.String", "java.lang.String",
				"java.lang.String"
			};

		_methodName444 = "findStaffNamed";

		_methodParameterTypes444 = new String[] {
				"long", "java.lang.String", "java.lang.String",
				"java.lang.String", "int", "int"
			};

		_methodName445 = "findStaffNamedNational";

		_methodParameterTypes445 = new String[] {
				"long", "java.lang.String", "java.lang.String",
				"java.lang.String"
			};

		_methodName446 = "findStaffNamedNational";

		_methodParameterTypes446 = new String[] {
				"long", "java.lang.String", "java.lang.String",
				"java.lang.String", "int", "int"
			};

		_methodName447 = "findStaff";

		_methodParameterTypes447 = new String[] { "long" };

		_methodName448 = "findStaff";

		_methodParameterTypes448 = new String[] { "long", "int", "int" };

		_methodName449 = "finNationalDelegationESFUsersByMatchId";

		_methodParameterTypes449 = new String[] { "long", "int", "int" };

		_methodName450 = "findNationalDelegationStaffESFUsersByMatchId";

		_methodParameterTypes450 = new String[] { "long" };

		_methodName451 = "findNationalDelegationStaffESFUsersByMatchId";

		_methodParameterTypes451 = new String[] { "long", "int", "int" };

		_methodName452 = "findNationalDelegationsESFUsersByMatchId";

		_methodParameterTypes452 = new String[] { "long" };

		_methodName453 = "findNationalDelegationsESFUsersByMatchId";

		_methodParameterTypes453 = new String[] { "long", "int", "int" };

		_methodName454 = "findNationalDelegationsESFUsersByMatchId_PartecipantTypeId";

		_methodParameterTypes454 = new String[] { "long", "long" };

		_methodName455 = "findNationalDelegationsESFUsersByMatchId_PartecipantTypeId";

		_methodParameterTypes455 = new String[] { "long", "long", "int", "int" };

		_methodName456 = "findNationalShooters";

		_methodParameterTypes456 = new String[] {  };

		_methodName457 = "findNationalShooters";

		_methodParameterTypes457 = new String[] { "int", "int" };

		_methodName458 = "findNationalPartecipantShooters";

		_methodParameterTypes458 = new String[] { "long", "boolean" };

		_methodName459 = "findNationalPartecipantShooters";

		_methodParameterTypes459 = new String[] { "long", "boolean", "int", "int" };

		_methodName460 = "findPartecipantShooters";

		_methodParameterTypes460 = new String[] { "int", "int", "long", "boolean" };

		_methodName461 = "findPartecipantShooters";

		_methodParameterTypes461 = new String[] {
				"int", "int", "long", "boolean", "int", "int"
			};

		_methodName462 = "findNationalPartecipantCoaches";

		_methodParameterTypes462 = new String[] { "long", "boolean" };

		_methodName463 = "findNationalPartecipantCoaches";

		_methodParameterTypes463 = new String[] { "long", "boolean", "int", "int" };

		_methodName464 = "findPartecipantCoaches";

		_methodParameterTypes464 = new String[] { "int", "long", "boolean" };

		_methodName465 = "findPartecipantCoaches";

		_methodParameterTypes465 = new String[] {
				"int", "long", "boolean", "int", "int"
			};

		_methodName466 = "findNationalPartecipantReferees";

		_methodParameterTypes466 = new String[] { "long", "boolean" };

		_methodName467 = "findNationalPartecipantReferees";

		_methodParameterTypes467 = new String[] { "long", "boolean", "int", "int" };

		_methodName468 = "findPartecipantReferees";

		_methodParameterTypes468 = new String[] {
				"int", "long", "boolean", "int", "int"
			};

		_methodName469 = "findPartecipantReferees";

		_methodParameterTypes469 = new String[] { "int", "long", "boolean" };

		_methodName470 = "findNationalPartecipantDoctor";

		_methodParameterTypes470 = new String[] { "long", "boolean" };

		_methodName471 = "findNationalPartecipantDoctor";

		_methodParameterTypes471 = new String[] { "long", "boolean", "int", "int" };

		_methodName472 = "findPartecipantDoctor";

		_methodParameterTypes472 = new String[] { "int", "long", "boolean" };

		_methodName473 = "findPartecipantDoctor";

		_methodParameterTypes473 = new String[] {
				"int", "long", "boolean", "int", "int"
			};

		_methodName476 = "addESFUser";

		_methodParameterTypes476 = new String[] {
				"long", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "int", "int", "int", "boolean",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "it.ethica.esf.model.ESFEntityState",
				"java.util.List", "java.util.List", "java.lang.String",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName477 = "addESFUserInOrganization";

		_methodParameterTypes477 = new String[] {
				"long", "java.lang.String", "java.lang.String",
				"java.lang.String", "long", "java.util.Locale",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"int", "int", "boolean", "int", "int", "int", "java.lang.String",
				"it.ethica.esf.model.ESFAddress",
				"it.ethica.esf.model.ESFEntityState", "java.util.List",
				"com.liferay.portal.service.ServiceContext",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName478 = "addESFUserInOrganization";

		_methodParameterTypes478 = new String[] {
				"long", "java.lang.String", "java.lang.String",
				"java.lang.String", "long", "java.util.Locale",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"int", "int", "boolean", "int", "int", "int", "java.lang.String",
				"it.ethica.esf.model.ESFAddress", "long", "java.util.List",
				"com.liferay.portal.service.ServiceContext",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName479 = "deleteESFUser";

		_methodParameterTypes479 = new String[] {
				"long", "java.util.List",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName480 = "updateESFUser";

		_methodParameterTypes480 = new String[] {
				"long", "long", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "int", "int", "int", "boolean", "boolean",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "it.ethica.esf.model.ESFEntityState",
				"java.util.List", "java.util.List", "java.lang.String",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName481 = "addESFShooter";

		_methodParameterTypes481 = new String[] {
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

		_methodName482 = "updateESFShooter";

		_methodParameterTypes482 = new String[] {
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

		_methodName483 = "updateESFUserToESFShooter";

		_methodParameterTypes483 = new String[] {
				"long", "long", "it.ethica.esf.model.ESFCard", "java.util.List",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName484 = "addESFUserToESFShooter";

		_methodParameterTypes484 = new String[] { "long", "long" };

		_methodName486 = "countByESFUserRole";

		_methodParameterTypes486 = new String[] { "long" };

		_methodName487 = "getESFUserRoles";

		_methodParameterTypes487 = new String[] { "long", "boolean" };

		_methodName488 = "getActiveESFUserRoles";

		_methodParameterTypes488 = new String[] { "long" };

		_methodName489 = "findAllUser";

		_methodParameterTypes489 = new String[] {  };

		_methodName490 = "checkEmailAddress";

		_methodParameterTypes490 = new String[] {
				"java.lang.String", "com.liferay.portal.service.ServiceContext"
			};

		_methodName491 = "checkScreenName";

		_methodParameterTypes491 = new String[] {
				"java.lang.String", "com.liferay.portal.service.ServiceContext"
			};

		_methodName492 = "findAllUserByAgeOnlyPeople";

		_methodParameterTypes492 = new String[] {  };

		_methodName493 = "findAllUserByRolenoNull";

		_methodParameterTypes493 = new String[] { "long", "long" };

		_methodName494 = "findShooterRoleAssignedName";

		_methodParameterTypes494 = new String[] {
				"java.lang.String", "java.lang.String", "long", "long", "int",
				"int"
			};

		_methodName495 = "countShooterRoleAssignedName";

		_methodParameterTypes495 = new String[] {
				"java.lang.String", "java.lang.String", "long", "long"
			};

		_methodName496 = "findStaffMatch";

		_methodParameterTypes496 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"long", "long", "int", "int"
			};

		_methodName497 = "countStaffMatch";

		_methodParameterTypes497 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"long", "long"
			};

		_methodName498 = "findShooterNotAssociated";

		_methodParameterTypes498 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"long", "int", "int"
			};

		_methodName499 = "countNotNationalShooterBySPT";

		_methodParameterTypes499 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"long"
			};

		_methodName500 = "findALLShooterNotAssociated";

		_methodParameterTypes500 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"long", "int", "int"
			};

		_methodName501 = "countALLNotNationalShooterBySPT";

		_methodParameterTypes501 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"long"
			};

		_methodName502 = "findStaffNormalMatch";

		_methodParameterTypes502 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"long", "int", "int"
			};

		_methodName503 = "countStaffNormalMatch";

		_methodParameterTypes503 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"long"
			};

		_methodName504 = "countRenwalUser";

		_methodParameterTypes504 = new String[] {
				"java.lang.String", "java.lang.String", "long"
			};

		_methodName505 = "countNewUser";

		_methodParameterTypes505 = new String[] {
				"java.lang.String", "java.lang.String", "long"
			};

		_methodName506 = "findByKeyword";

		_methodParameterTypes506 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName507 = "findShooterByAss";

		_methodParameterTypes507 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"long", "int", "int"
			};

		_methodName508 = "countShooterByAss";

		_methodParameterTypes508 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"long"
			};

		_methodName509 = "findShooterByAssAndNoAss";

		_methodParameterTypes509 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"long", "int", "int"
			};

		_methodName510 = "countShooterByAssAndNoAss";

		_methodParameterTypes510 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"long"
			};

		_methodName511 = "findDirectorByMatch";

		_methodParameterTypes511 = new String[] {
				"java.lang.String", "java.lang.String", "long", "long", "int",
				"int"
			};

		_methodName512 = "countDirectorByMatch";

		_methodParameterTypes512 = new String[] {
				"java.lang.String", "java.lang.String", "long", "long"
			};

		_methodName513 = "findNewYouthShooter";

		_methodParameterTypes513 = new String[] { "int" };

		_methodName514 = "findYouthByCategory";

		_methodParameterTypes514 = new String[] { "long", "int", "int", "int" };

		_methodName515 = "findYouthByCategoryTotal";

		_methodParameterTypes515 = new String[] { "long", "int" };

		_methodName516 = "findNotBDOMemberByAssociatioId";

		_methodParameterTypes516 = new String[] {
				"java.lang.String", "java.lang.String", "long", "int", "int"
			};

		_methodName517 = "countNotBDOMemberByAssociatioId";

		_methodParameterTypes517 = new String[] {
				"java.lang.String", "java.lang.String", "long"
			};

		_methodName518 = "findAssociatedShooterOrganization";

		_methodParameterTypes518 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"long", "int", "int"
			};

		_methodName519 = "countAssociatedShooterOrganization";

		_methodParameterTypes519 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"long"
			};

		_methodName520 = "findByESFFederalRole";

		_methodParameterTypes520 = new String[] { "long" };
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

		if (_methodName404.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes404, parameterTypes)) {
			return ESFUserLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName405.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes405, parameterTypes)) {
			ESFUserLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName410.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes410, parameterTypes)) {
			return ESFUserLocalServiceUtil.getESFUsersByDeparture(((Long)arguments[0]).longValue());
		}

		if (_methodName411.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes411, parameterTypes)) {
			return ESFUserLocalServiceUtil.getESFUsersByCodeCode((java.lang.String)arguments[0]);
		}

		if (_methodName412.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes412, parameterTypes)) {
			return ESFUserLocalServiceUtil.getESFUserByUserCode(((Long)arguments[0]).longValue());
		}

		if (_methodName413.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes413, parameterTypes)) {
			return ESFUserLocalServiceUtil.getESFUserByCodeUser2(((Long)arguments[0]).longValue());
		}

		if (_methodName414.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes414, parameterTypes)) {
			return ESFUserLocalServiceUtil.getESFUserByFirstName_LastName_FiscalCode_NotPartecipants(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3],
				((Integer)arguments[4]).intValue(),
				((Long)arguments[5]).longValue());
		}

		if (_methodName415.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes415, parameterTypes)) {
			return ESFUserLocalServiceUtil.getESFUserByFirstName_LastName_FiscalCode_NotPartecipants(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3],
				((Integer)arguments[4]).intValue(),
				((Long)arguments[5]).longValue(),
				((Integer)arguments[6]).intValue(),
				((Integer)arguments[7]).intValue());
		}

		if (_methodName416.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes416, parameterTypes)) {
			return ESFUserLocalServiceUtil.getESFUserByFirstName_LastName_FiscalCode((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				((Integer)arguments[3]).intValue(),
				((Long)arguments[4]).longValue(),
				((Integer)arguments[5]).intValue(),
				((Integer)arguments[6]).intValue());
		}

		if (_methodName417.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes417, parameterTypes)) {
			return ESFUserLocalServiceUtil.getESFUserByFiscalCode((java.lang.String)arguments[0]);
		}

		if (_methodName418.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes418, parameterTypes)) {
			return ESFUserLocalServiceUtil.getAllUserByLikeF_L((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue());
		}

		if (_methodName419.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes419, parameterTypes)) {
			return ESFUserLocalServiceUtil.countAllUserByLikeF_L((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2]);
		}

		if (_methodName420.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes420, parameterTypes)) {
			return ESFUserLocalServiceUtil.getAllUserByLikeF_L_S((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue());
		}

		if (_methodName421.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes421, parameterTypes)) {
			return ESFUserLocalServiceUtil.getAllUserByLikeF_L_S((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				((Integer)arguments[3]).intValue());
		}

		if (_methodName422.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes422, parameterTypes)) {
			return ESFUserLocalServiceUtil.getAllUserByLikeF_C_S((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				((Integer)arguments[3]).intValue(),
				((Long)arguments[4]).longValue(),
				((Integer)arguments[5]).intValue(),
				((Integer)arguments[6]).intValue());
		}

		if (_methodName423.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes423, parameterTypes)) {
			return ESFUserLocalServiceUtil.getAllUserByLikeF_C_S((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				((Integer)arguments[3]).intValue(),
				((Long)arguments[4]).longValue());
		}

		if (_methodName424.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes424, parameterTypes)) {
			return ESFUserLocalServiceUtil.getAllShooterByLikeF_C_S((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				((Long)arguments[3]).longValue(),
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue());
		}

		if (_methodName425.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes425, parameterTypes)) {
			return ESFUserLocalServiceUtil.getAllShooterByLikeF_C_S((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				((Long)arguments[3]).longValue());
		}

		if (_methodName426.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes426, parameterTypes)) {
			return ESFUserLocalServiceUtil.getAllEsfUserByState(((Integer)arguments[0]).intValue());
		}

		if (_methodName427.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes427, parameterTypes)) {
			return ESFUserLocalServiceUtil.getAllEsfUserByState(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName428.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes428, parameterTypes)) {
			return ESFUserLocalServiceUtil.findUserByRoleT_N_S((java.lang.String)arguments[0],
				(java.lang.String)arguments[1],
				((Integer)arguments[2]).intValue());
		}

		if (_methodName429.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes429, parameterTypes)) {
			return ESFUserLocalServiceUtil.findAllShooters(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName430.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes430, parameterTypes)) {
			return ESFUserLocalServiceUtil.findAllShooters(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName431.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes431, parameterTypes)) {
			return ESFUserLocalServiceUtil.findAllShooters(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue());
		}

		if (_methodName432.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes432, parameterTypes)) {
			return ESFUserLocalServiceUtil.findRoledUserOrganization(((Long)arguments[0]).longValue());
		}

		if (_methodName433.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes433, parameterTypes)) {
			return ESFUserLocalServiceUtil.findRoledUserOrganization(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName434.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes434, parameterTypes)) {
			return ESFUserLocalServiceUtil.findAllShootersByLeafOrgAssigned(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Long)arguments[2]).longValue(),
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue());
		}

		if (_methodName435.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes435, parameterTypes)) {
			return ESFUserLocalServiceUtil.findAllShootersByLeafOrgAssignedName((java.lang.String)arguments[0],
				(java.lang.String)arguments[1],
				((Long)arguments[2]).longValue(),
				((Integer)arguments[3]).intValue(),
				((Long)arguments[4]).longValue(),
				((Integer)arguments[5]).intValue(),
				((Integer)arguments[6]).intValue(),
				((Integer)arguments[7]).intValue());
		}

		if (_methodName436.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes436, parameterTypes)) {
			return ESFUserLocalServiceUtil.countAllShootersByLeafOrgAssignedName((java.lang.String)arguments[0],
				(java.lang.String)arguments[1],
				((Long)arguments[2]).longValue(),
				((Integer)arguments[3]).intValue(),
				((Long)arguments[4]).longValue(),
				((Integer)arguments[5]).intValue());
		}

		if (_methodName437.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes437, parameterTypes)) {
			return ESFUserLocalServiceUtil.findAllShootersByLeafOrgAssigned(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Long)arguments[2]).longValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName438.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes438, parameterTypes)) {
			return ESFUserLocalServiceUtil.findAllShootersByLeafOrg(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName439.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes439, parameterTypes)) {
			return ESFUserLocalServiceUtil.findAllShootersByLeafOrg(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue());
		}

		if (_methodName440.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes440, parameterTypes)) {
			return ESFUserLocalServiceUtil.finNationalDelegationESFUsersByMatchId(((Long)arguments[0]).longValue());
		}

		if (_methodName441.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes441, parameterTypes)) {
			return ESFUserLocalServiceUtil.findAllStaff((java.lang.Long)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3],
				((Integer)arguments[4]).intValue(),
				(java.lang.Long)arguments[5],
				((Integer)arguments[6]).intValue(),
				((Integer)arguments[7]).intValue());
		}

		if (_methodName442.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes442, parameterTypes)) {
			return ESFUserLocalServiceUtil.findAllStaffNamed((java.lang.Long)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3],
				((Integer)arguments[4]).intValue(),
				(java.lang.Long)arguments[5],
				((Integer)arguments[6]).intValue(),
				((Integer)arguments[7]).intValue());
		}

		if (_methodName443.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes443, parameterTypes)) {
			return ESFUserLocalServiceUtil.findStaffNamed(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3]);
		}

		if (_methodName444.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes444, parameterTypes)) {
			return ESFUserLocalServiceUtil.findStaffNamed(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3],
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue());
		}

		if (_methodName445.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes445, parameterTypes)) {
			return ESFUserLocalServiceUtil.findStaffNamedNational(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3]);
		}

		if (_methodName446.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes446, parameterTypes)) {
			return ESFUserLocalServiceUtil.findStaffNamedNational(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3],
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue());
		}

		if (_methodName447.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes447, parameterTypes)) {
			return ESFUserLocalServiceUtil.findStaff(((Long)arguments[0]).longValue());
		}

		if (_methodName448.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes448, parameterTypes)) {
			return ESFUserLocalServiceUtil.findStaff(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName449.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes449, parameterTypes)) {
			return ESFUserLocalServiceUtil.finNationalDelegationESFUsersByMatchId(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName450.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes450, parameterTypes)) {
			return ESFUserLocalServiceUtil.findNationalDelegationStaffESFUsersByMatchId(((Long)arguments[0]).longValue());
		}

		if (_methodName451.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes451, parameterTypes)) {
			return ESFUserLocalServiceUtil.findNationalDelegationStaffESFUsersByMatchId(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName452.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes452, parameterTypes)) {
			return ESFUserLocalServiceUtil.findNationalDelegationsESFUsersByMatchId(((Long)arguments[0]).longValue());
		}

		if (_methodName453.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes453, parameterTypes)) {
			return ESFUserLocalServiceUtil.findNationalDelegationsESFUsersByMatchId(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName454.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes454, parameterTypes)) {
			return ESFUserLocalServiceUtil.findNationalDelegationsESFUsersByMatchId_PartecipantTypeId(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName455.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes455, parameterTypes)) {
			return ESFUserLocalServiceUtil.findNationalDelegationsESFUsersByMatchId_PartecipantTypeId(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName456.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes456, parameterTypes)) {
			return ESFUserLocalServiceUtil.findNationalShooters();
		}

		if (_methodName457.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes457, parameterTypes)) {
			return ESFUserLocalServiceUtil.findNationalShooters(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName458.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes458, parameterTypes)) {
			return ESFUserLocalServiceUtil.findNationalPartecipantShooters(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue());
		}

		if (_methodName459.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes459, parameterTypes)) {
			return ESFUserLocalServiceUtil.findNationalPartecipantShooters(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName460.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes460, parameterTypes)) {
			return ESFUserLocalServiceUtil.findPartecipantShooters(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue(),
				((Long)arguments[2]).longValue(),
				((Boolean)arguments[3]).booleanValue());
		}

		if (_methodName461.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes461, parameterTypes)) {
			return ESFUserLocalServiceUtil.findPartecipantShooters(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue(),
				((Long)arguments[2]).longValue(),
				((Boolean)arguments[3]).booleanValue(),
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue());
		}

		if (_methodName462.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes462, parameterTypes)) {
			return ESFUserLocalServiceUtil.findNationalPartecipantCoaches(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue());
		}

		if (_methodName463.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes463, parameterTypes)) {
			return ESFUserLocalServiceUtil.findNationalPartecipantCoaches(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName464.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes464, parameterTypes)) {
			return ESFUserLocalServiceUtil.findPartecipantCoaches(((Integer)arguments[0]).intValue(),
				((Long)arguments[1]).longValue(),
				((Boolean)arguments[2]).booleanValue());
		}

		if (_methodName465.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes465, parameterTypes)) {
			return ESFUserLocalServiceUtil.findPartecipantCoaches(((Integer)arguments[0]).intValue(),
				((Long)arguments[1]).longValue(),
				((Boolean)arguments[2]).booleanValue(),
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue());
		}

		if (_methodName466.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes466, parameterTypes)) {
			return ESFUserLocalServiceUtil.findNationalPartecipantReferees(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue());
		}

		if (_methodName467.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes467, parameterTypes)) {
			return ESFUserLocalServiceUtil.findNationalPartecipantReferees(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName468.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes468, parameterTypes)) {
			return ESFUserLocalServiceUtil.findPartecipantReferees(((Integer)arguments[0]).intValue(),
				((Long)arguments[1]).longValue(),
				((Boolean)arguments[2]).booleanValue(),
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue());
		}

		if (_methodName469.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes469, parameterTypes)) {
			return ESFUserLocalServiceUtil.findPartecipantReferees(((Integer)arguments[0]).intValue(),
				((Long)arguments[1]).longValue(),
				((Boolean)arguments[2]).booleanValue());
		}

		if (_methodName470.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes470, parameterTypes)) {
			return ESFUserLocalServiceUtil.findNationalPartecipantDoctor(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue());
		}

		if (_methodName471.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes471, parameterTypes)) {
			return ESFUserLocalServiceUtil.findNationalPartecipantDoctor(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName472.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes472, parameterTypes)) {
			return ESFUserLocalServiceUtil.findPartecipantDoctor(((Integer)arguments[0]).intValue(),
				((Long)arguments[1]).longValue(),
				((Boolean)arguments[2]).booleanValue());
		}

		if (_methodName473.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes473, parameterTypes)) {
			return ESFUserLocalServiceUtil.findPartecipantDoctor(((Integer)arguments[0]).intValue(),
				((Long)arguments[1]).longValue(),
				((Boolean)arguments[2]).booleanValue(),
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue());
		}

		if (_methodName476.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes476, parameterTypes)) {
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

		if (_methodName477.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes477, parameterTypes)) {
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

		if (_methodName478.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes478, parameterTypes)) {
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

		if (_methodName479.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes479, parameterTypes)) {
			return ESFUserLocalServiceUtil.deleteESFUser(((Long)arguments[0]).longValue(),
				(java.util.List<it.ethica.esf.model.ESFAddress>)arguments[1],
				(com.liferay.portal.service.ServiceContext)arguments[2]);
		}

		if (_methodName480.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes480, parameterTypes)) {
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

		if (_methodName481.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes481, parameterTypes)) {
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

		if (_methodName482.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes482, parameterTypes)) {
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

		if (_methodName483.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes483, parameterTypes)) {
			ESFUserLocalServiceUtil.updateESFUserToESFShooter(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				(it.ethica.esf.model.ESFCard)arguments[2],
				(java.util.List<it.ethica.esf.model.ESFCard>)arguments[3],
				(com.liferay.portal.service.ServiceContext)arguments[4]);

			return null;
		}

		if (_methodName484.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes484, parameterTypes)) {
			ESFUserLocalServiceUtil.addESFUserToESFShooter(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());

			return null;
		}

		if (_methodName486.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes486, parameterTypes)) {
			return ESFUserLocalServiceUtil.countByESFUserRole(((Long)arguments[0]).longValue());
		}

		if (_methodName487.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes487, parameterTypes)) {
			return ESFUserLocalServiceUtil.getESFUserRoles(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue());
		}

		if (_methodName488.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes488, parameterTypes)) {
			return ESFUserLocalServiceUtil.getActiveESFUserRoles(((Long)arguments[0]).longValue());
		}

		if (_methodName489.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes489, parameterTypes)) {
			return ESFUserLocalServiceUtil.findAllUser();
		}

		if (_methodName490.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes490, parameterTypes)) {
			return ESFUserLocalServiceUtil.checkEmailAddress((java.lang.String)arguments[0],
				(com.liferay.portal.service.ServiceContext)arguments[1]);
		}

		if (_methodName491.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes491, parameterTypes)) {
			return ESFUserLocalServiceUtil.checkScreenName((java.lang.String)arguments[0],
				(com.liferay.portal.service.ServiceContext)arguments[1]);
		}

		if (_methodName492.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes492, parameterTypes)) {
			return ESFUserLocalServiceUtil.findAllUserByAgeOnlyPeople();
		}

		if (_methodName493.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes493, parameterTypes)) {
			return ESFUserLocalServiceUtil.findAllUserByRolenoNull(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName494.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes494, parameterTypes)) {
			return ESFUserLocalServiceUtil.findShooterRoleAssignedName((java.lang.String)arguments[0],
				(java.lang.String)arguments[1],
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue(),
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue());
		}

		if (_methodName495.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes495, parameterTypes)) {
			return ESFUserLocalServiceUtil.countShooterRoleAssignedName((java.lang.String)arguments[0],
				(java.lang.String)arguments[1],
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue());
		}

		if (_methodName496.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes496, parameterTypes)) {
			return ESFUserLocalServiceUtil.findStaffMatch((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				((Long)arguments[3]).longValue(),
				((Long)arguments[4]).longValue(),
				((Integer)arguments[5]).intValue(),
				((Integer)arguments[6]).intValue());
		}

		if (_methodName497.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes497, parameterTypes)) {
			return ESFUserLocalServiceUtil.countStaffMatch((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				((Long)arguments[3]).longValue(),
				((Long)arguments[4]).longValue());
		}

		if (_methodName498.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes498, parameterTypes)) {
			return ESFUserLocalServiceUtil.findShooterNotAssociated((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				((Long)arguments[3]).longValue(),
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue());
		}

		if (_methodName499.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes499, parameterTypes)) {
			return ESFUserLocalServiceUtil.countNotNationalShooterBySPT((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				((Long)arguments[3]).longValue());
		}

		if (_methodName500.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes500, parameterTypes)) {
			return ESFUserLocalServiceUtil.findALLShooterNotAssociated((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				((Long)arguments[3]).longValue(),
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue());
		}

		if (_methodName501.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes501, parameterTypes)) {
			return ESFUserLocalServiceUtil.countALLNotNationalShooterBySPT((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				((Long)arguments[3]).longValue());
		}

		if (_methodName502.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes502, parameterTypes)) {
			return ESFUserLocalServiceUtil.findStaffNormalMatch((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				((Long)arguments[3]).longValue(),
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue());
		}

		if (_methodName503.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes503, parameterTypes)) {
			return ESFUserLocalServiceUtil.countStaffNormalMatch((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				((Long)arguments[3]).longValue());
		}

		if (_methodName504.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes504, parameterTypes)) {
			return ESFUserLocalServiceUtil.countRenwalUser((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], ((Long)arguments[2]).longValue());
		}

		if (_methodName505.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes505, parameterTypes)) {
			return ESFUserLocalServiceUtil.countNewUser((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], ((Long)arguments[2]).longValue());
		}

		if (_methodName506.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes506, parameterTypes)) {
			return ESFUserLocalServiceUtil.findByKeyword((java.lang.String)arguments[0],
				(java.lang.String)arguments[1]);
		}

		if (_methodName507.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes507, parameterTypes)) {
			return ESFUserLocalServiceUtil.findShooterByAss((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				((Long)arguments[3]).longValue(),
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue());
		}

		if (_methodName508.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes508, parameterTypes)) {
			return ESFUserLocalServiceUtil.countShooterByAss((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				((Long)arguments[3]).longValue());
		}

		if (_methodName509.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes509, parameterTypes)) {
			return ESFUserLocalServiceUtil.findShooterByAssAndNoAss((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				((Long)arguments[3]).longValue(),
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue());
		}

		if (_methodName510.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes510, parameterTypes)) {
			return ESFUserLocalServiceUtil.countShooterByAssAndNoAss((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				((Long)arguments[3]).longValue());
		}

		if (_methodName511.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes511, parameterTypes)) {
			return ESFUserLocalServiceUtil.findDirectorByMatch((java.lang.String)arguments[0],
				(java.lang.String)arguments[1],
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue(),
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue());
		}

		if (_methodName512.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes512, parameterTypes)) {
			return ESFUserLocalServiceUtil.countDirectorByMatch((java.lang.String)arguments[0],
				(java.lang.String)arguments[1],
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue());
		}

		if (_methodName513.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes513, parameterTypes)) {
			return ESFUserLocalServiceUtil.findNewYouthShooter(((Integer)arguments[0]).intValue());
		}

		if (_methodName514.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes514, parameterTypes)) {
			return ESFUserLocalServiceUtil.findYouthByCategory(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName515.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes515, parameterTypes)) {
			return ESFUserLocalServiceUtil.findYouthByCategoryTotal(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName516.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes516, parameterTypes)) {
			return ESFUserLocalServiceUtil.findNotBDOMemberByAssociatioId((java.lang.String)arguments[0],
				(java.lang.String)arguments[1],
				((Long)arguments[2]).longValue(),
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue());
		}

		if (_methodName517.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes517, parameterTypes)) {
			return ESFUserLocalServiceUtil.countNotBDOMemberByAssociatioId((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], ((Long)arguments[2]).longValue());
		}

		if (_methodName518.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes518, parameterTypes)) {
			return ESFUserLocalServiceUtil.findAssociatedShooterOrganization((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				((Long)arguments[3]).longValue(),
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue());
		}

		if (_methodName519.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes519, parameterTypes)) {
			return ESFUserLocalServiceUtil.countAssociatedShooterOrganization((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				((Long)arguments[3]).longValue());
		}

		if (_methodName520.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes520, parameterTypes)) {
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
	private String _methodName404;
	private String[] _methodParameterTypes404;
	private String _methodName405;
	private String[] _methodParameterTypes405;
	private String _methodName410;
	private String[] _methodParameterTypes410;
	private String _methodName411;
	private String[] _methodParameterTypes411;
	private String _methodName412;
	private String[] _methodParameterTypes412;
	private String _methodName413;
	private String[] _methodParameterTypes413;
	private String _methodName414;
	private String[] _methodParameterTypes414;
	private String _methodName415;
	private String[] _methodParameterTypes415;
	private String _methodName416;
	private String[] _methodParameterTypes416;
	private String _methodName417;
	private String[] _methodParameterTypes417;
	private String _methodName418;
	private String[] _methodParameterTypes418;
	private String _methodName419;
	private String[] _methodParameterTypes419;
	private String _methodName420;
	private String[] _methodParameterTypes420;
	private String _methodName421;
	private String[] _methodParameterTypes421;
	private String _methodName422;
	private String[] _methodParameterTypes422;
	private String _methodName423;
	private String[] _methodParameterTypes423;
	private String _methodName424;
	private String[] _methodParameterTypes424;
	private String _methodName425;
	private String[] _methodParameterTypes425;
	private String _methodName426;
	private String[] _methodParameterTypes426;
	private String _methodName427;
	private String[] _methodParameterTypes427;
	private String _methodName428;
	private String[] _methodParameterTypes428;
	private String _methodName429;
	private String[] _methodParameterTypes429;
	private String _methodName430;
	private String[] _methodParameterTypes430;
	private String _methodName431;
	private String[] _methodParameterTypes431;
	private String _methodName432;
	private String[] _methodParameterTypes432;
	private String _methodName433;
	private String[] _methodParameterTypes433;
	private String _methodName434;
	private String[] _methodParameterTypes434;
	private String _methodName435;
	private String[] _methodParameterTypes435;
	private String _methodName436;
	private String[] _methodParameterTypes436;
	private String _methodName437;
	private String[] _methodParameterTypes437;
	private String _methodName438;
	private String[] _methodParameterTypes438;
	private String _methodName439;
	private String[] _methodParameterTypes439;
	private String _methodName440;
	private String[] _methodParameterTypes440;
	private String _methodName441;
	private String[] _methodParameterTypes441;
	private String _methodName442;
	private String[] _methodParameterTypes442;
	private String _methodName443;
	private String[] _methodParameterTypes443;
	private String _methodName444;
	private String[] _methodParameterTypes444;
	private String _methodName445;
	private String[] _methodParameterTypes445;
	private String _methodName446;
	private String[] _methodParameterTypes446;
	private String _methodName447;
	private String[] _methodParameterTypes447;
	private String _methodName448;
	private String[] _methodParameterTypes448;
	private String _methodName449;
	private String[] _methodParameterTypes449;
	private String _methodName450;
	private String[] _methodParameterTypes450;
	private String _methodName451;
	private String[] _methodParameterTypes451;
	private String _methodName452;
	private String[] _methodParameterTypes452;
	private String _methodName453;
	private String[] _methodParameterTypes453;
	private String _methodName454;
	private String[] _methodParameterTypes454;
	private String _methodName455;
	private String[] _methodParameterTypes455;
	private String _methodName456;
	private String[] _methodParameterTypes456;
	private String _methodName457;
	private String[] _methodParameterTypes457;
	private String _methodName458;
	private String[] _methodParameterTypes458;
	private String _methodName459;
	private String[] _methodParameterTypes459;
	private String _methodName460;
	private String[] _methodParameterTypes460;
	private String _methodName461;
	private String[] _methodParameterTypes461;
	private String _methodName462;
	private String[] _methodParameterTypes462;
	private String _methodName463;
	private String[] _methodParameterTypes463;
	private String _methodName464;
	private String[] _methodParameterTypes464;
	private String _methodName465;
	private String[] _methodParameterTypes465;
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
}