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

<<<<<<< HEAD
		_methodName396 = "getBeanIdentifier";

		_methodParameterTypes396 = new String[] {  };

		_methodName397 = "setBeanIdentifier";

		_methodParameterTypes397 = new String[] { "java.lang.String" };

		_methodName402 = "getESFUsersByDeparture";

		_methodParameterTypes402 = new String[] { "long" };

		_methodName403 = "getESFUsersByCodeCode";

		_methodParameterTypes403 = new String[] { "java.lang.String" };

		_methodName404 = "getESFUserByUserCode";

		_methodParameterTypes404 = new String[] { "long" };

		_methodName405 = "getESFUserByCodeUser2";

		_methodParameterTypes405 = new String[] { "long" };

		_methodName406 = "getESFUserByFirstName_LastName_FiscalCode_NotPartecipants";

		_methodParameterTypes406 = new String[] {
=======
		_methodName388 = "getBeanIdentifier";

		_methodParameterTypes388 = new String[] {  };

		_methodName389 = "setBeanIdentifier";

		_methodParameterTypes389 = new String[] { "java.lang.String" };

		_methodName394 = "getESFUsersByDeparture";

		_methodParameterTypes394 = new String[] { "long" };

		_methodName395 = "getESFUsersByCodeCode";

		_methodParameterTypes395 = new String[] { "java.lang.String" };

		_methodName396 = "getESFUserByUserCode";

		_methodParameterTypes396 = new String[] { "long" };

		_methodName397 = "getESFUserByCodeUser2";

		_methodParameterTypes397 = new String[] { "long" };

		_methodName398 = "getESFUserByFirstName_LastName_FiscalCode_NotPartecipants";

		_methodParameterTypes398 = new String[] {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
				"long", "java.lang.String", "java.lang.String",
				"java.lang.String", "int", "long"
			};

<<<<<<< HEAD
		_methodName407 = "getESFUserByFirstName_LastName_FiscalCode_NotPartecipants";

		_methodParameterTypes407 = new String[] {
=======
		_methodName399 = "getESFUserByFirstName_LastName_FiscalCode_NotPartecipants";

		_methodParameterTypes399 = new String[] {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
				"long", "java.lang.String", "java.lang.String",
				"java.lang.String", "int", "long", "int", "int"
			};

<<<<<<< HEAD
		_methodName408 = "getESFUserByFirstName_LastName_FiscalCode";

		_methodParameterTypes408 = new String[] {
=======
		_methodName400 = "getESFUserByFirstName_LastName_FiscalCode";

		_methodParameterTypes400 = new String[] {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
				"java.lang.String", "java.lang.String", "java.lang.String",
				"int", "long", "int", "int"
			};

<<<<<<< HEAD
		_methodName409 = "getESFUserByFiscalCode";

		_methodParameterTypes409 = new String[] { "java.lang.String" };

		_methodName410 = "getAllUserByLikeF_L";

		_methodParameterTypes410 = new String[] {
=======
		_methodName401 = "getESFUserByFiscalCode";

		_methodParameterTypes401 = new String[] { "java.lang.String" };

		_methodName402 = "getAllUserByLikeF_L";

		_methodParameterTypes402 = new String[] {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
				"java.lang.String", "java.lang.String", "java.lang.String",
				"int", "int"
			};

<<<<<<< HEAD
		_methodName411 = "countAllUserByLikeF_L";

		_methodParameterTypes411 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String"
			};

		_methodName412 = "getAllUserByLikeF_L_S";

		_methodParameterTypes412 = new String[] {
=======
		_methodName403 = "countAllUserByLikeF_L";

		_methodParameterTypes403 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String"
			};

		_methodName404 = "getAllUserByLikeF_L_S";

		_methodParameterTypes404 = new String[] {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
				"java.lang.String", "java.lang.String", "java.lang.String",
				"int", "int", "int"
			};

<<<<<<< HEAD
		_methodName413 = "getAllUserByLikeF_L_S";

		_methodParameterTypes413 = new String[] {
=======
		_methodName405 = "getAllUserByLikeF_L_S";

		_methodParameterTypes405 = new String[] {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
				"java.lang.String", "java.lang.String", "java.lang.String",
				"int"
			};

<<<<<<< HEAD
		_methodName414 = "getAllUserByLikeF_C_S";

		_methodParameterTypes414 = new String[] {
=======
		_methodName406 = "getAllUserByLikeF_C_S";

		_methodParameterTypes406 = new String[] {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
				"java.lang.String", "java.lang.String", "java.lang.String",
				"int", "long", "int", "int"
			};

<<<<<<< HEAD
		_methodName415 = "getAllUserByLikeF_C_S";

		_methodParameterTypes415 = new String[] {
=======
		_methodName407 = "getAllUserByLikeF_C_S";

		_methodParameterTypes407 = new String[] {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
				"java.lang.String", "java.lang.String", "java.lang.String",
				"int", "long"
			};

<<<<<<< HEAD
		_methodName416 = "getAllShooterByLikeF_C_S";

		_methodParameterTypes416 = new String[] {
=======
		_methodName408 = "getAllShooterByLikeF_C_S";

		_methodParameterTypes408 = new String[] {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
				"java.lang.String", "java.lang.String", "java.lang.String",
				"long", "int", "int"
			};

<<<<<<< HEAD
		_methodName417 = "getAllShooterByLikeF_C_S";

		_methodParameterTypes417 = new String[] {
=======
		_methodName409 = "getAllShooterByLikeF_C_S";

		_methodParameterTypes409 = new String[] {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
				"java.lang.String", "java.lang.String", "java.lang.String",
				"long"
			};

<<<<<<< HEAD
		_methodName418 = "getAllEsfUserByState";

		_methodParameterTypes418 = new String[] { "int" };

		_methodName419 = "getAllEsfUserByState";

		_methodParameterTypes419 = new String[] { "int", "int", "int" };

		_methodName420 = "findUserByRoleT_N_S";

		_methodParameterTypes420 = new String[] {
				"java.lang.String", "java.lang.String", "int"
			};

		_methodName421 = "findAllShooters";

		_methodParameterTypes421 = new String[] { "int", "int" };

		_methodName422 = "findAllShooters";

		_methodParameterTypes422 = new String[] { "long", "int", "int" };

		_methodName423 = "findAllShooters";

		_methodParameterTypes423 = new String[] {
				"long", "int", "int", "int", "int"
			};

		_methodName424 = "findRoledUserOrganization";

		_methodParameterTypes424 = new String[] { "long" };

		_methodName425 = "findRoledUserOrganization";

		_methodParameterTypes425 = new String[] { "long", "int", "int" };

		_methodName426 = "findAllShootersByLeafOrgAssigned";

		_methodParameterTypes426 = new String[] {
				"long", "int", "long", "int", "int", "int"
			};

		_methodName427 = "findAllShootersByLeafOrgAssignedName";

		_methodParameterTypes427 = new String[] {
=======
		_methodName410 = "getAllEsfUserByState";

		_methodParameterTypes410 = new String[] { "int" };

		_methodName411 = "getAllEsfUserByState";

		_methodParameterTypes411 = new String[] { "int", "int", "int" };

		_methodName412 = "findUserByRoleT_N_S";

		_methodParameterTypes412 = new String[] {
				"java.lang.String", "java.lang.String", "int"
			};

		_methodName413 = "findAllShooters";

		_methodParameterTypes413 = new String[] { "int", "int" };

		_methodName414 = "findAllShooters";

		_methodParameterTypes414 = new String[] { "long", "int", "int" };

		_methodName415 = "findAllShooters";

		_methodParameterTypes415 = new String[] {
				"long", "int", "int", "int", "int"
			};

		_methodName416 = "findRoledUserOrganization";

		_methodParameterTypes416 = new String[] { "long" };

		_methodName417 = "findRoledUserOrganization";

		_methodParameterTypes417 = new String[] { "long", "int", "int" };

		_methodName418 = "findAllShootersByLeafOrgAssigned";

		_methodParameterTypes418 = new String[] {
				"long", "int", "long", "int", "int", "int"
			};

		_methodName419 = "findAllShootersByLeafOrgAssignedName";

		_methodParameterTypes419 = new String[] {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
				"java.lang.String", "java.lang.String", "long", "int", "long",
				"int", "int", "int"
			};

<<<<<<< HEAD
		_methodName428 = "countAllShootersByLeafOrgAssignedName";

		_methodParameterTypes428 = new String[] {
=======
		_methodName420 = "countAllShootersByLeafOrgAssignedName";

		_methodParameterTypes420 = new String[] {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
				"java.lang.String", "java.lang.String", "long", "int", "long",
				"int"
			};

<<<<<<< HEAD
		_methodName429 = "findAllShootersByLeafOrgAssigned";

		_methodParameterTypes429 = new String[] { "long", "int", "long", "int" };

		_methodName430 = "findAllShootersByLeafOrg";

		_methodParameterTypes430 = new String[] { "long", "int", "int" };

		_methodName431 = "findAllShootersByLeafOrg";

		_methodParameterTypes431 = new String[] {
				"long", "int", "int", "int", "int"
			};

		_methodName432 = "finNationalDelegationESFUsersByMatchId";

		_methodParameterTypes432 = new String[] { "long" };

		_methodName433 = "findAllStaff";

		_methodParameterTypes433 = new String[] {
=======
		_methodName421 = "findAllShootersByLeafOrgAssigned";

		_methodParameterTypes421 = new String[] { "long", "int", "long", "int" };

		_methodName422 = "findAllShootersByLeafOrg";

		_methodParameterTypes422 = new String[] { "long", "int", "int" };

		_methodName423 = "findAllShootersByLeafOrg";

		_methodParameterTypes423 = new String[] {
				"long", "int", "int", "int", "int"
			};

		_methodName424 = "finNationalDelegationESFUsersByMatchId";

		_methodParameterTypes424 = new String[] { "long" };

		_methodName425 = "findAllStaff";

		_methodParameterTypes425 = new String[] {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
				"java.lang.Long", "java.lang.String", "java.lang.String",
				"java.lang.String", "int", "java.lang.Long", "int", "int"
			};

<<<<<<< HEAD
		_methodName434 = "findAllStaffNamed";

		_methodParameterTypes434 = new String[] {
=======
		_methodName426 = "findAllStaffNamed";

		_methodParameterTypes426 = new String[] {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
				"java.lang.Long", "java.lang.String", "java.lang.String",
				"java.lang.String", "int", "java.lang.Long", "int", "int"
			};

<<<<<<< HEAD
		_methodName435 = "findStaffNamed";

		_methodParameterTypes435 = new String[] {
=======
		_methodName427 = "findStaffNamed";

		_methodParameterTypes427 = new String[] {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
				"long", "java.lang.String", "java.lang.String",
				"java.lang.String"
			};

<<<<<<< HEAD
		_methodName436 = "findStaffNamed";

		_methodParameterTypes436 = new String[] {
=======
		_methodName428 = "findStaffNamed";

		_methodParameterTypes428 = new String[] {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
				"long", "java.lang.String", "java.lang.String",
				"java.lang.String", "int", "int"
			};

<<<<<<< HEAD
		_methodName437 = "findStaffNamedNational";

		_methodParameterTypes437 = new String[] {
=======
		_methodName429 = "findStaffNamedNational";

		_methodParameterTypes429 = new String[] {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
				"long", "java.lang.String", "java.lang.String",
				"java.lang.String"
			};

<<<<<<< HEAD
		_methodName438 = "findStaffNamedNational";

		_methodParameterTypes438 = new String[] {
=======
		_methodName430 = "findStaffNamedNational";

		_methodParameterTypes430 = new String[] {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
				"long", "java.lang.String", "java.lang.String",
				"java.lang.String", "int", "int"
			};

<<<<<<< HEAD
		_methodName439 = "findStaff";

		_methodParameterTypes439 = new String[] { "long" };

		_methodName440 = "findStaff";

		_methodParameterTypes440 = new String[] { "long", "int", "int" };

		_methodName441 = "finNationalDelegationESFUsersByMatchId";

		_methodParameterTypes441 = new String[] { "long", "int", "int" };

		_methodName442 = "findNationalDelegationStaffESFUsersByMatchId";

		_methodParameterTypes442 = new String[] { "long" };

		_methodName443 = "findNationalDelegationStaffESFUsersByMatchId";

		_methodParameterTypes443 = new String[] { "long", "int", "int" };

		_methodName444 = "findNationalDelegationsESFUsersByMatchId";

		_methodParameterTypes444 = new String[] { "long" };

		_methodName445 = "findNationalDelegationsESFUsersByMatchId";

		_methodParameterTypes445 = new String[] { "long", "int", "int" };

		_methodName446 = "findNationalDelegationsESFUsersByMatchId_PartecipantTypeId";

		_methodParameterTypes446 = new String[] { "long", "long" };

		_methodName447 = "findNationalDelegationsESFUsersByMatchId_PartecipantTypeId";

		_methodParameterTypes447 = new String[] { "long", "long", "int", "int" };

		_methodName448 = "findNationalShooters";

		_methodParameterTypes448 = new String[] {  };

		_methodName449 = "findNationalShooters";

		_methodParameterTypes449 = new String[] { "int", "int" };

		_methodName450 = "findNationalPartecipantShooters";

		_methodParameterTypes450 = new String[] { "long", "boolean" };

		_methodName451 = "findNationalPartecipantShooters";

		_methodParameterTypes451 = new String[] { "long", "boolean", "int", "int" };

		_methodName452 = "findPartecipantShooters";

		_methodParameterTypes452 = new String[] { "int", "int", "long", "boolean" };

		_methodName453 = "findPartecipantShooters";

		_methodParameterTypes453 = new String[] {
				"int", "int", "long", "boolean", "int", "int"
			};

		_methodName454 = "findNationalPartecipantCoaches";

		_methodParameterTypes454 = new String[] { "long", "boolean" };

		_methodName455 = "findNationalPartecipantCoaches";

		_methodParameterTypes455 = new String[] { "long", "boolean", "int", "int" };

		_methodName456 = "findPartecipantCoaches";

		_methodParameterTypes456 = new String[] { "int", "long", "boolean" };

		_methodName457 = "findPartecipantCoaches";

		_methodParameterTypes457 = new String[] {
				"int", "long", "boolean", "int", "int"
			};

		_methodName458 = "findNationalPartecipantReferees";

		_methodParameterTypes458 = new String[] { "long", "boolean" };

		_methodName459 = "findNationalPartecipantReferees";

		_methodParameterTypes459 = new String[] { "long", "boolean", "int", "int" };

		_methodName460 = "findPartecipantReferees";

		_methodParameterTypes460 = new String[] {
				"int", "long", "boolean", "int", "int"
			};

		_methodName461 = "findPartecipantReferees";

		_methodParameterTypes461 = new String[] { "int", "long", "boolean" };

		_methodName462 = "findNationalPartecipantDoctor";

		_methodParameterTypes462 = new String[] { "long", "boolean" };

		_methodName463 = "findNationalPartecipantDoctor";

		_methodParameterTypes463 = new String[] { "long", "boolean", "int", "int" };

		_methodName464 = "findPartecipantDoctor";

		_methodParameterTypes464 = new String[] { "int", "long", "boolean" };

		_methodName465 = "findPartecipantDoctor";

		_methodParameterTypes465 = new String[] {
				"int", "long", "boolean", "int", "int"
			};

		_methodName468 = "addESFUser";

		_methodParameterTypes468 = new String[] {
=======
		_methodName431 = "findStaff";

		_methodParameterTypes431 = new String[] { "long" };

		_methodName432 = "findStaff";

		_methodParameterTypes432 = new String[] { "long", "int", "int" };

		_methodName433 = "finNationalDelegationESFUsersByMatchId";

		_methodParameterTypes433 = new String[] { "long", "int", "int" };

		_methodName434 = "findNationalDelegationStaffESFUsersByMatchId";

		_methodParameterTypes434 = new String[] { "long" };

		_methodName435 = "findNationalDelegationStaffESFUsersByMatchId";

		_methodParameterTypes435 = new String[] { "long", "int", "int" };

		_methodName436 = "findNationalDelegationsESFUsersByMatchId";

		_methodParameterTypes436 = new String[] { "long" };

		_methodName437 = "findNationalDelegationsESFUsersByMatchId";

		_methodParameterTypes437 = new String[] { "long", "int", "int" };

		_methodName438 = "findNationalDelegationsESFUsersByMatchId_PartecipantTypeId";

		_methodParameterTypes438 = new String[] { "long", "long" };

		_methodName439 = "findNationalDelegationsESFUsersByMatchId_PartecipantTypeId";

		_methodParameterTypes439 = new String[] { "long", "long", "int", "int" };

		_methodName440 = "findNationalShooters";

		_methodParameterTypes440 = new String[] {  };

		_methodName441 = "findNationalShooters";

		_methodParameterTypes441 = new String[] { "int", "int" };

		_methodName442 = "findNationalPartecipantShooters";

		_methodParameterTypes442 = new String[] { "long", "boolean" };

		_methodName443 = "findNationalPartecipantShooters";

		_methodParameterTypes443 = new String[] { "long", "boolean", "int", "int" };

		_methodName444 = "findPartecipantShooters";

		_methodParameterTypes444 = new String[] { "int", "int", "long", "boolean" };

		_methodName445 = "findPartecipantShooters";

		_methodParameterTypes445 = new String[] {
				"int", "int", "long", "boolean", "int", "int"
			};

		_methodName446 = "findNationalPartecipantCoaches";

		_methodParameterTypes446 = new String[] { "long", "boolean" };

		_methodName447 = "findNationalPartecipantCoaches";

		_methodParameterTypes447 = new String[] { "long", "boolean", "int", "int" };

		_methodName448 = "findPartecipantCoaches";

		_methodParameterTypes448 = new String[] { "int", "long", "boolean" };

		_methodName449 = "findPartecipantCoaches";

		_methodParameterTypes449 = new String[] {
				"int", "long", "boolean", "int", "int"
			};

		_methodName450 = "findNationalPartecipantReferees";

		_methodParameterTypes450 = new String[] { "long", "boolean" };

		_methodName451 = "findNationalPartecipantReferees";

		_methodParameterTypes451 = new String[] { "long", "boolean", "int", "int" };

		_methodName452 = "findPartecipantReferees";

		_methodParameterTypes452 = new String[] {
				"int", "long", "boolean", "int", "int"
			};

		_methodName453 = "findPartecipantReferees";

		_methodParameterTypes453 = new String[] { "int", "long", "boolean" };

		_methodName454 = "findNationalPartecipantDoctor";

		_methodParameterTypes454 = new String[] { "long", "boolean" };

		_methodName455 = "findNationalPartecipantDoctor";

		_methodParameterTypes455 = new String[] { "long", "boolean", "int", "int" };

		_methodName456 = "findPartecipantDoctor";

		_methodParameterTypes456 = new String[] { "int", "long", "boolean" };

		_methodName457 = "findPartecipantDoctor";

		_methodParameterTypes457 = new String[] {
				"int", "long", "boolean", "int", "int"
			};

		_methodName460 = "addESFUser";

		_methodParameterTypes460 = new String[] {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
				"long", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "int", "int", "int", "boolean",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "it.ethica.esf.model.ESFEntityState",
				"java.util.List", "java.util.List", "java.lang.String",
				"com.liferay.portal.service.ServiceContext"
			};

<<<<<<< HEAD
		_methodName469 = "addESFUserInOrganization";

		_methodParameterTypes469 = new String[] {
=======
		_methodName461 = "addESFUserInOrganization";

		_methodParameterTypes461 = new String[] {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
				"long", "java.lang.String", "java.lang.String",
				"java.lang.String", "long", "java.util.Locale",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"int", "int", "boolean", "int", "int", "int", "java.lang.String",
				"it.ethica.esf.model.ESFAddress",
				"it.ethica.esf.model.ESFEntityState", "java.util.List",
				"com.liferay.portal.service.ServiceContext",
				"com.liferay.portal.service.ServiceContext"
			};

<<<<<<< HEAD
		_methodName470 = "addESFUserInOrganization";

		_methodParameterTypes470 = new String[] {
=======
		_methodName462 = "addESFUserInOrganization";

		_methodParameterTypes462 = new String[] {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
				"long", "java.lang.String", "java.lang.String",
				"java.lang.String", "long", "java.util.Locale",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"int", "int", "boolean", "int", "int", "int", "java.lang.String",
				"it.ethica.esf.model.ESFAddress", "long", "java.util.List",
				"com.liferay.portal.service.ServiceContext",
				"com.liferay.portal.service.ServiceContext"
			};

<<<<<<< HEAD
		_methodName471 = "deleteESFUser";

		_methodParameterTypes471 = new String[] {
=======
		_methodName463 = "deleteESFUser";

		_methodParameterTypes463 = new String[] {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
				"long", "java.util.List",
				"com.liferay.portal.service.ServiceContext"
			};

<<<<<<< HEAD
		_methodName472 = "updateESFUser";

		_methodParameterTypes472 = new String[] {
=======
		_methodName464 = "updateESFUser";

		_methodParameterTypes464 = new String[] {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
				"long", "long", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "int", "int", "int", "boolean", "boolean",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "it.ethica.esf.model.ESFEntityState",
				"java.util.List", "java.util.List", "java.lang.String",
				"com.liferay.portal.service.ServiceContext"
			};

<<<<<<< HEAD
		_methodName473 = "addESFShooter";

		_methodParameterTypes473 = new String[] {
=======
		_methodName465 = "addESFShooter";

		_methodParameterTypes465 = new String[] {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
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

<<<<<<< HEAD
		_methodName474 = "updateESFShooter";

		_methodParameterTypes474 = new String[] {
=======
		_methodName466 = "updateESFShooter";

		_methodParameterTypes466 = new String[] {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
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

<<<<<<< HEAD
		_methodName475 = "updateESFUserToESFShooter";

		_methodParameterTypes475 = new String[] {
=======
		_methodName467 = "updateESFUserToESFShooter";

		_methodParameterTypes467 = new String[] {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
				"long", "long", "it.ethica.esf.model.ESFCard", "java.util.List",
				"com.liferay.portal.service.ServiceContext"
			};

<<<<<<< HEAD
		_methodName476 = "addESFUserToESFShooter";

		_methodParameterTypes476 = new String[] { "long", "long" };

		_methodName478 = "countByESFUserRole";

		_methodParameterTypes478 = new String[] { "long" };

		_methodName479 = "getESFUserRoles";

		_methodParameterTypes479 = new String[] { "long", "boolean" };

		_methodName480 = "getActiveESFUserRoles";

		_methodParameterTypes480 = new String[] { "long" };

		_methodName481 = "findAllUser";

		_methodParameterTypes481 = new String[] {  };

		_methodName482 = "checkEmailAddress";

		_methodParameterTypes482 = new String[] {
				"java.lang.String", "com.liferay.portal.service.ServiceContext"
			};

		_methodName483 = "checkScreenName";

		_methodParameterTypes483 = new String[] {
				"java.lang.String", "com.liferay.portal.service.ServiceContext"
			};

		_methodName484 = "findAllUserByAgeOnlyPeople";

		_methodParameterTypes484 = new String[] {  };

		_methodName485 = "findAllUserByRolenoNull";

		_methodParameterTypes485 = new String[] { "long", "long" };

		_methodName486 = "findShooterRoleAssignedName";

		_methodParameterTypes486 = new String[] {
=======
		_methodName468 = "addESFUserToESFShooter";

		_methodParameterTypes468 = new String[] { "long", "long" };

		_methodName470 = "countByESFUserRole";

		_methodParameterTypes470 = new String[] { "long" };

		_methodName471 = "getESFUserRoles";

		_methodParameterTypes471 = new String[] { "long", "boolean" };

		_methodName472 = "getActiveESFUserRoles";

		_methodParameterTypes472 = new String[] { "long" };

		_methodName473 = "findAllUser";

		_methodParameterTypes473 = new String[] {  };

		_methodName474 = "checkEmailAddress";

		_methodParameterTypes474 = new String[] {
				"java.lang.String", "com.liferay.portal.service.ServiceContext"
			};

		_methodName475 = "checkScreenName";

		_methodParameterTypes475 = new String[] {
				"java.lang.String", "com.liferay.portal.service.ServiceContext"
			};

		_methodName476 = "findAllUserByAgeOnlyPeople";

		_methodParameterTypes476 = new String[] {  };

		_methodName477 = "findAllUserByRolenoNull";

		_methodParameterTypes477 = new String[] { "long", "long" };

		_methodName478 = "findShooterRoleAssignedName";

		_methodParameterTypes478 = new String[] {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
				"java.lang.String", "java.lang.String", "long", "long", "int",
				"int"
			};

<<<<<<< HEAD
		_methodName487 = "countShooterRoleAssignedName";

		_methodParameterTypes487 = new String[] {
				"java.lang.String", "java.lang.String", "long", "long"
			};

		_methodName488 = "findStaffMatch";

		_methodParameterTypes488 = new String[] {
=======
		_methodName479 = "countShooterRoleAssignedName";

		_methodParameterTypes479 = new String[] {
				"java.lang.String", "java.lang.String", "long", "long"
			};

		_methodName480 = "findStaffMatch";

		_methodParameterTypes480 = new String[] {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
				"java.lang.String", "java.lang.String", "java.lang.String",
				"long", "long", "int", "int"
			};

<<<<<<< HEAD
		_methodName489 = "countStaffMatch";

		_methodParameterTypes489 = new String[] {
=======
		_methodName481 = "countStaffMatch";

		_methodParameterTypes481 = new String[] {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
				"java.lang.String", "java.lang.String", "java.lang.String",
				"long", "long"
			};

<<<<<<< HEAD
		_methodName490 = "findShooterNotAssociated";

		_methodParameterTypes490 = new String[] {
=======
		_methodName482 = "findShooterNotAssociated";

		_methodParameterTypes482 = new String[] {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
				"java.lang.String", "java.lang.String", "java.lang.String",
				"long", "int", "int"
			};

<<<<<<< HEAD
		_methodName491 = "countNotNationalShooterBySPT";

		_methodParameterTypes491 = new String[] {
=======
		_methodName483 = "countNotNationalShooterBySPT";

		_methodParameterTypes483 = new String[] {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
				"java.lang.String", "java.lang.String", "java.lang.String",
				"long"
			};

<<<<<<< HEAD
		_methodName492 = "findALLShooterNotAssociated";

		_methodParameterTypes492 = new String[] {
=======
		_methodName484 = "findALLShooterNotAssociated";

		_methodParameterTypes484 = new String[] {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
				"java.lang.String", "java.lang.String", "java.lang.String",
				"long", "int", "int"
			};

<<<<<<< HEAD
		_methodName493 = "countALLNotNationalShooterBySPT";

		_methodParameterTypes493 = new String[] {
=======
		_methodName485 = "countALLNotNationalShooterBySPT";

		_methodParameterTypes485 = new String[] {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
				"java.lang.String", "java.lang.String", "java.lang.String",
				"long"
			};

<<<<<<< HEAD
		_methodName494 = "findStaffNormalMatch";

		_methodParameterTypes494 = new String[] {
=======
		_methodName486 = "findStaffNormalMatch";

		_methodParameterTypes486 = new String[] {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
				"java.lang.String", "java.lang.String", "java.lang.String",
				"long", "int", "int"
			};

<<<<<<< HEAD
		_methodName495 = "countStaffNormalMatch";

		_methodParameterTypes495 = new String[] {
=======
		_methodName487 = "countStaffNormalMatch";

		_methodParameterTypes487 = new String[] {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
				"java.lang.String", "java.lang.String", "java.lang.String",
				"long"
			};

<<<<<<< HEAD
		_methodName496 = "countRenwalUser";

		_methodParameterTypes496 = new String[] {
				"java.lang.String", "java.lang.String", "long"
			};

		_methodName497 = "countNewUser";

		_methodParameterTypes497 = new String[] {
				"java.lang.String", "java.lang.String", "long"
			};

		_methodName498 = "findByKeyword";

		_methodParameterTypes498 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName499 = "findShooterByAss";

		_methodParameterTypes499 = new String[] {
=======
		_methodName488 = "countRenwalUser";

		_methodParameterTypes488 = new String[] {
				"java.lang.String", "java.lang.String", "long"
			};

		_methodName489 = "countNewUser";

		_methodParameterTypes489 = new String[] {
				"java.lang.String", "java.lang.String", "long"
			};

		_methodName490 = "findByKeyword";

		_methodParameterTypes490 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName491 = "findShooterByAss";

		_methodParameterTypes491 = new String[] {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
				"java.lang.String", "java.lang.String", "java.lang.String",
				"long", "int", "int"
			};

<<<<<<< HEAD
		_methodName500 = "countShooterByAss";

		_methodParameterTypes500 = new String[] {
=======
		_methodName492 = "countShooterByAss";

		_methodParameterTypes492 = new String[] {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
				"java.lang.String", "java.lang.String", "java.lang.String",
				"long"
			};

<<<<<<< HEAD
		_methodName501 = "findShooterByAssAndNoAss";

		_methodParameterTypes501 = new String[] {
=======
		_methodName493 = "findShooterByAssAndNoAss";

		_methodParameterTypes493 = new String[] {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
				"java.lang.String", "java.lang.String", "java.lang.String",
				"long", "int", "int"
			};

<<<<<<< HEAD
		_methodName502 = "countShooterByAssAndNoAss";

		_methodParameterTypes502 = new String[] {
=======
		_methodName494 = "countShooterByAssAndNoAss";

		_methodParameterTypes494 = new String[] {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
				"java.lang.String", "java.lang.String", "java.lang.String",
				"long"
			};

<<<<<<< HEAD
		_methodName503 = "findDirectorByMatch";

		_methodParameterTypes503 = new String[] {
=======
		_methodName495 = "findDirectorByMatch";

		_methodParameterTypes495 = new String[] {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
				"java.lang.String", "java.lang.String", "long", "long", "int",
				"int"
			};

<<<<<<< HEAD
		_methodName504 = "countDirectorByMatch";

		_methodParameterTypes504 = new String[] {
				"java.lang.String", "java.lang.String", "long", "long"
			};

		_methodName505 = "findNewYouthShooter";

		_methodParameterTypes505 = new String[] { "int" };

		_methodName506 = "findYouthByCategory";

		_methodParameterTypes506 = new String[] { "long", "int", "int", "int" };

		_methodName507 = "findYouthByCategoryTotal";

		_methodParameterTypes507 = new String[] { "long", "int" };

		_methodName508 = "findNotBDOMemberByAssociatioId";

		_methodParameterTypes508 = new String[] {
				"java.lang.String", "java.lang.String", "long", "int", "int"
			};

		_methodName509 = "countNotBDOMemberByAssociatioId";

		_methodParameterTypes509 = new String[] {
				"java.lang.String", "java.lang.String", "long"
			};

		_methodName510 = "findAssociatedShooterOrganization";

		_methodParameterTypes510 = new String[] {
=======
		_methodName496 = "countDirectorByMatch";

		_methodParameterTypes496 = new String[] {
				"java.lang.String", "java.lang.String", "long", "long"
			};

		_methodName497 = "findNewYouthShooter";

		_methodParameterTypes497 = new String[] { "int" };

		_methodName498 = "findYouthByCategory";

		_methodParameterTypes498 = new String[] { "long", "int", "int", "int" };

		_methodName499 = "findYouthByCategoryTotal";

		_methodParameterTypes499 = new String[] { "long", "int" };

		_methodName500 = "findNotBDOMemberByAssociatioId";

		_methodParameterTypes500 = new String[] {
				"java.lang.String", "java.lang.String", "long", "int", "int"
			};

		_methodName501 = "countNotBDOMemberByAssociatioId";

		_methodParameterTypes501 = new String[] {
				"java.lang.String", "java.lang.String", "long"
			};

		_methodName502 = "findAssociatedShooterOrganization";

		_methodParameterTypes502 = new String[] {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
				"java.lang.String", "java.lang.String", "java.lang.String",
				"long", "int", "int"
			};

<<<<<<< HEAD
		_methodName511 = "countAssociatedShooterOrganization";

		_methodParameterTypes511 = new String[] {
=======
		_methodName503 = "countAssociatedShooterOrganization";

		_methodParameterTypes503 = new String[] {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
				"java.lang.String", "java.lang.String", "java.lang.String",
				"long"
			};

<<<<<<< HEAD
		_methodName512 = "findByESFFederalRole";

		_methodParameterTypes512 = new String[] { "long" };
=======
		_methodName504 = "findByESFFederalRole";

		_methodParameterTypes504 = new String[] { "long" };
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
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

<<<<<<< HEAD
		if (_methodName396.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes396, parameterTypes)) {
			return ESFUserLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName397.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes397, parameterTypes)) {
=======
		if (_methodName388.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes388, parameterTypes)) {
			return ESFUserLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName389.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes389, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			ESFUserLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

<<<<<<< HEAD
		if (_methodName402.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes402, parameterTypes)) {
			return ESFUserLocalServiceUtil.getESFUsersByDeparture(((Long)arguments[0]).longValue());
		}

		if (_methodName403.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes403, parameterTypes)) {
			return ESFUserLocalServiceUtil.getESFUsersByCodeCode((java.lang.String)arguments[0]);
		}

		if (_methodName404.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes404, parameterTypes)) {
			return ESFUserLocalServiceUtil.getESFUserByUserCode(((Long)arguments[0]).longValue());
		}

		if (_methodName405.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes405, parameterTypes)) {
			return ESFUserLocalServiceUtil.getESFUserByCodeUser2(((Long)arguments[0]).longValue());
		}

		if (_methodName406.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes406, parameterTypes)) {
=======
		if (_methodName394.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes394, parameterTypes)) {
			return ESFUserLocalServiceUtil.getESFUsersByDeparture(((Long)arguments[0]).longValue());
		}

		if (_methodName395.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes395, parameterTypes)) {
			return ESFUserLocalServiceUtil.getESFUsersByCodeCode((java.lang.String)arguments[0]);
		}

		if (_methodName396.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes396, parameterTypes)) {
			return ESFUserLocalServiceUtil.getESFUserByUserCode(((Long)arguments[0]).longValue());
		}

		if (_methodName397.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes397, parameterTypes)) {
			return ESFUserLocalServiceUtil.getESFUserByCodeUser2(((Long)arguments[0]).longValue());
		}

		if (_methodName398.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes398, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFUserLocalServiceUtil.getESFUserByFirstName_LastName_FiscalCode_NotPartecipants(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3],
				((Integer)arguments[4]).intValue(),
				((Long)arguments[5]).longValue());
		}

<<<<<<< HEAD
		if (_methodName407.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes407, parameterTypes)) {
=======
		if (_methodName399.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes399, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFUserLocalServiceUtil.getESFUserByFirstName_LastName_FiscalCode_NotPartecipants(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3],
				((Integer)arguments[4]).intValue(),
				((Long)arguments[5]).longValue(),
				((Integer)arguments[6]).intValue(),
				((Integer)arguments[7]).intValue());
		}

<<<<<<< HEAD
		if (_methodName408.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes408, parameterTypes)) {
=======
		if (_methodName400.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes400, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFUserLocalServiceUtil.getESFUserByFirstName_LastName_FiscalCode((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				((Integer)arguments[3]).intValue(),
				((Long)arguments[4]).longValue(),
				((Integer)arguments[5]).intValue(),
				((Integer)arguments[6]).intValue());
		}

<<<<<<< HEAD
		if (_methodName409.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes409, parameterTypes)) {
			return ESFUserLocalServiceUtil.getESFUserByFiscalCode((java.lang.String)arguments[0]);
		}

		if (_methodName410.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes410, parameterTypes)) {
=======
		if (_methodName401.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes401, parameterTypes)) {
			return ESFUserLocalServiceUtil.getESFUserByFiscalCode((java.lang.String)arguments[0]);
		}

		if (_methodName402.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes402, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFUserLocalServiceUtil.getAllUserByLikeF_L((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue());
		}

<<<<<<< HEAD
		if (_methodName411.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes411, parameterTypes)) {
=======
		if (_methodName403.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes403, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFUserLocalServiceUtil.countAllUserByLikeF_L((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2]);
		}

<<<<<<< HEAD
		if (_methodName412.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes412, parameterTypes)) {
=======
		if (_methodName404.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes404, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFUserLocalServiceUtil.getAllUserByLikeF_L_S((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue());
		}

<<<<<<< HEAD
		if (_methodName413.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes413, parameterTypes)) {
=======
		if (_methodName405.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes405, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFUserLocalServiceUtil.getAllUserByLikeF_L_S((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				((Integer)arguments[3]).intValue());
		}

<<<<<<< HEAD
		if (_methodName414.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes414, parameterTypes)) {
=======
		if (_methodName406.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes406, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFUserLocalServiceUtil.getAllUserByLikeF_C_S((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				((Integer)arguments[3]).intValue(),
				((Long)arguments[4]).longValue(),
				((Integer)arguments[5]).intValue(),
				((Integer)arguments[6]).intValue());
		}

<<<<<<< HEAD
		if (_methodName415.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes415, parameterTypes)) {
=======
		if (_methodName407.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes407, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFUserLocalServiceUtil.getAllUserByLikeF_C_S((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				((Integer)arguments[3]).intValue(),
				((Long)arguments[4]).longValue());
		}

<<<<<<< HEAD
		if (_methodName416.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes416, parameterTypes)) {
=======
		if (_methodName408.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes408, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFUserLocalServiceUtil.getAllShooterByLikeF_C_S((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				((Long)arguments[3]).longValue(),
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue());
		}

<<<<<<< HEAD
		if (_methodName417.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes417, parameterTypes)) {
=======
		if (_methodName409.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes409, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFUserLocalServiceUtil.getAllShooterByLikeF_C_S((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				((Long)arguments[3]).longValue());
		}

<<<<<<< HEAD
		if (_methodName418.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes418, parameterTypes)) {
			return ESFUserLocalServiceUtil.getAllEsfUserByState(((Integer)arguments[0]).intValue());
		}

		if (_methodName419.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes419, parameterTypes)) {
=======
		if (_methodName410.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes410, parameterTypes)) {
			return ESFUserLocalServiceUtil.getAllEsfUserByState(((Integer)arguments[0]).intValue());
		}

		if (_methodName411.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes411, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFUserLocalServiceUtil.getAllEsfUserByState(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

<<<<<<< HEAD
		if (_methodName420.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes420, parameterTypes)) {
=======
		if (_methodName412.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes412, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFUserLocalServiceUtil.findUserByRoleT_N_S((java.lang.String)arguments[0],
				(java.lang.String)arguments[1],
				((Integer)arguments[2]).intValue());
		}

<<<<<<< HEAD
		if (_methodName421.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes421, parameterTypes)) {
=======
		if (_methodName413.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes413, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFUserLocalServiceUtil.findAllShooters(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

<<<<<<< HEAD
		if (_methodName422.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes422, parameterTypes)) {
=======
		if (_methodName414.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes414, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFUserLocalServiceUtil.findAllShooters(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

<<<<<<< HEAD
		if (_methodName423.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes423, parameterTypes)) {
=======
		if (_methodName415.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes415, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFUserLocalServiceUtil.findAllShooters(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue());
		}

<<<<<<< HEAD
		if (_methodName424.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes424, parameterTypes)) {
			return ESFUserLocalServiceUtil.findRoledUserOrganization(((Long)arguments[0]).longValue());
		}

		if (_methodName425.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes425, parameterTypes)) {
=======
		if (_methodName416.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes416, parameterTypes)) {
			return ESFUserLocalServiceUtil.findRoledUserOrganization(((Long)arguments[0]).longValue());
		}

		if (_methodName417.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes417, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFUserLocalServiceUtil.findRoledUserOrganization(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

<<<<<<< HEAD
		if (_methodName426.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes426, parameterTypes)) {
=======
		if (_methodName418.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes418, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFUserLocalServiceUtil.findAllShootersByLeafOrgAssigned(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Long)arguments[2]).longValue(),
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue());
		}

<<<<<<< HEAD
		if (_methodName427.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes427, parameterTypes)) {
=======
		if (_methodName419.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes419, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFUserLocalServiceUtil.findAllShootersByLeafOrgAssignedName((java.lang.String)arguments[0],
				(java.lang.String)arguments[1],
				((Long)arguments[2]).longValue(),
				((Integer)arguments[3]).intValue(),
				((Long)arguments[4]).longValue(),
				((Integer)arguments[5]).intValue(),
				((Integer)arguments[6]).intValue(),
				((Integer)arguments[7]).intValue());
		}

<<<<<<< HEAD
		if (_methodName428.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes428, parameterTypes)) {
=======
		if (_methodName420.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes420, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFUserLocalServiceUtil.countAllShootersByLeafOrgAssignedName((java.lang.String)arguments[0],
				(java.lang.String)arguments[1],
				((Long)arguments[2]).longValue(),
				((Integer)arguments[3]).intValue(),
				((Long)arguments[4]).longValue(),
				((Integer)arguments[5]).intValue());
		}

<<<<<<< HEAD
		if (_methodName429.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes429, parameterTypes)) {
=======
		if (_methodName421.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes421, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFUserLocalServiceUtil.findAllShootersByLeafOrgAssigned(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Long)arguments[2]).longValue(),
				((Integer)arguments[3]).intValue());
		}

<<<<<<< HEAD
		if (_methodName430.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes430, parameterTypes)) {
=======
		if (_methodName422.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes422, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFUserLocalServiceUtil.findAllShootersByLeafOrg(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

<<<<<<< HEAD
		if (_methodName431.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes431, parameterTypes)) {
=======
		if (_methodName423.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes423, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFUserLocalServiceUtil.findAllShootersByLeafOrg(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue());
		}

<<<<<<< HEAD
		if (_methodName432.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes432, parameterTypes)) {
			return ESFUserLocalServiceUtil.finNationalDelegationESFUsersByMatchId(((Long)arguments[0]).longValue());
		}

		if (_methodName433.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes433, parameterTypes)) {
=======
		if (_methodName424.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes424, parameterTypes)) {
			return ESFUserLocalServiceUtil.finNationalDelegationESFUsersByMatchId(((Long)arguments[0]).longValue());
		}

		if (_methodName425.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes425, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFUserLocalServiceUtil.findAllStaff((java.lang.Long)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3],
				((Integer)arguments[4]).intValue(),
				(java.lang.Long)arguments[5],
				((Integer)arguments[6]).intValue(),
				((Integer)arguments[7]).intValue());
		}

<<<<<<< HEAD
		if (_methodName434.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes434, parameterTypes)) {
=======
		if (_methodName426.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes426, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFUserLocalServiceUtil.findAllStaffNamed((java.lang.Long)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3],
				((Integer)arguments[4]).intValue(),
				(java.lang.Long)arguments[5],
				((Integer)arguments[6]).intValue(),
				((Integer)arguments[7]).intValue());
		}

<<<<<<< HEAD
		if (_methodName435.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes435, parameterTypes)) {
=======
		if (_methodName427.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes427, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFUserLocalServiceUtil.findStaffNamed(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3]);
		}

<<<<<<< HEAD
		if (_methodName436.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes436, parameterTypes)) {
=======
		if (_methodName428.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes428, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFUserLocalServiceUtil.findStaffNamed(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3],
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue());
		}

<<<<<<< HEAD
		if (_methodName437.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes437, parameterTypes)) {
=======
		if (_methodName429.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes429, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFUserLocalServiceUtil.findStaffNamedNational(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3]);
		}

<<<<<<< HEAD
		if (_methodName438.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes438, parameterTypes)) {
=======
		if (_methodName430.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes430, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFUserLocalServiceUtil.findStaffNamedNational(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3],
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue());
		}

<<<<<<< HEAD
		if (_methodName439.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes439, parameterTypes)) {
			return ESFUserLocalServiceUtil.findStaff(((Long)arguments[0]).longValue());
		}

		if (_methodName440.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes440, parameterTypes)) {
=======
		if (_methodName431.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes431, parameterTypes)) {
			return ESFUserLocalServiceUtil.findStaff(((Long)arguments[0]).longValue());
		}

		if (_methodName432.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes432, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFUserLocalServiceUtil.findStaff(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

<<<<<<< HEAD
		if (_methodName441.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes441, parameterTypes)) {
=======
		if (_methodName433.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes433, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFUserLocalServiceUtil.finNationalDelegationESFUsersByMatchId(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

<<<<<<< HEAD
		if (_methodName442.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes442, parameterTypes)) {
			return ESFUserLocalServiceUtil.findNationalDelegationStaffESFUsersByMatchId(((Long)arguments[0]).longValue());
		}

		if (_methodName443.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes443, parameterTypes)) {
=======
		if (_methodName434.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes434, parameterTypes)) {
			return ESFUserLocalServiceUtil.findNationalDelegationStaffESFUsersByMatchId(((Long)arguments[0]).longValue());
		}

		if (_methodName435.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes435, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFUserLocalServiceUtil.findNationalDelegationStaffESFUsersByMatchId(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

<<<<<<< HEAD
		if (_methodName444.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes444, parameterTypes)) {
			return ESFUserLocalServiceUtil.findNationalDelegationsESFUsersByMatchId(((Long)arguments[0]).longValue());
		}

		if (_methodName445.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes445, parameterTypes)) {
=======
		if (_methodName436.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes436, parameterTypes)) {
			return ESFUserLocalServiceUtil.findNationalDelegationsESFUsersByMatchId(((Long)arguments[0]).longValue());
		}

		if (_methodName437.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes437, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFUserLocalServiceUtil.findNationalDelegationsESFUsersByMatchId(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

<<<<<<< HEAD
		if (_methodName446.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes446, parameterTypes)) {
=======
		if (_methodName438.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes438, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFUserLocalServiceUtil.findNationalDelegationsESFUsersByMatchId_PartecipantTypeId(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

<<<<<<< HEAD
		if (_methodName447.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes447, parameterTypes)) {
=======
		if (_methodName439.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes439, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFUserLocalServiceUtil.findNationalDelegationsESFUsersByMatchId_PartecipantTypeId(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

<<<<<<< HEAD
		if (_methodName448.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes448, parameterTypes)) {
			return ESFUserLocalServiceUtil.findNationalShooters();
		}

		if (_methodName449.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes449, parameterTypes)) {
=======
		if (_methodName440.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes440, parameterTypes)) {
			return ESFUserLocalServiceUtil.findNationalShooters();
		}

		if (_methodName441.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes441, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFUserLocalServiceUtil.findNationalShooters(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

<<<<<<< HEAD
		if (_methodName450.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes450, parameterTypes)) {
=======
		if (_methodName442.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes442, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFUserLocalServiceUtil.findNationalPartecipantShooters(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue());
		}

<<<<<<< HEAD
		if (_methodName451.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes451, parameterTypes)) {
=======
		if (_methodName443.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes443, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFUserLocalServiceUtil.findNationalPartecipantShooters(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

<<<<<<< HEAD
		if (_methodName452.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes452, parameterTypes)) {
=======
		if (_methodName444.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes444, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFUserLocalServiceUtil.findPartecipantShooters(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue(),
				((Long)arguments[2]).longValue(),
				((Boolean)arguments[3]).booleanValue());
		}

<<<<<<< HEAD
		if (_methodName453.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes453, parameterTypes)) {
=======
		if (_methodName445.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes445, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFUserLocalServiceUtil.findPartecipantShooters(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue(),
				((Long)arguments[2]).longValue(),
				((Boolean)arguments[3]).booleanValue(),
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue());
		}

<<<<<<< HEAD
		if (_methodName454.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes454, parameterTypes)) {
=======
		if (_methodName446.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes446, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFUserLocalServiceUtil.findNationalPartecipantCoaches(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue());
		}

<<<<<<< HEAD
		if (_methodName455.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes455, parameterTypes)) {
=======
		if (_methodName447.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes447, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFUserLocalServiceUtil.findNationalPartecipantCoaches(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

<<<<<<< HEAD
		if (_methodName456.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes456, parameterTypes)) {
=======
		if (_methodName448.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes448, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFUserLocalServiceUtil.findPartecipantCoaches(((Integer)arguments[0]).intValue(),
				((Long)arguments[1]).longValue(),
				((Boolean)arguments[2]).booleanValue());
		}

<<<<<<< HEAD
		if (_methodName457.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes457, parameterTypes)) {
=======
		if (_methodName449.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes449, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFUserLocalServiceUtil.findPartecipantCoaches(((Integer)arguments[0]).intValue(),
				((Long)arguments[1]).longValue(),
				((Boolean)arguments[2]).booleanValue(),
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue());
		}

<<<<<<< HEAD
		if (_methodName458.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes458, parameterTypes)) {
=======
		if (_methodName450.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes450, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFUserLocalServiceUtil.findNationalPartecipantReferees(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue());
		}

<<<<<<< HEAD
		if (_methodName459.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes459, parameterTypes)) {
=======
		if (_methodName451.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes451, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFUserLocalServiceUtil.findNationalPartecipantReferees(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

<<<<<<< HEAD
		if (_methodName460.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes460, parameterTypes)) {
=======
		if (_methodName452.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes452, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFUserLocalServiceUtil.findPartecipantReferees(((Integer)arguments[0]).intValue(),
				((Long)arguments[1]).longValue(),
				((Boolean)arguments[2]).booleanValue(),
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue());
		}

<<<<<<< HEAD
		if (_methodName461.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes461, parameterTypes)) {
=======
		if (_methodName453.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes453, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFUserLocalServiceUtil.findPartecipantReferees(((Integer)arguments[0]).intValue(),
				((Long)arguments[1]).longValue(),
				((Boolean)arguments[2]).booleanValue());
		}

<<<<<<< HEAD
		if (_methodName462.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes462, parameterTypes)) {
=======
		if (_methodName454.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes454, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFUserLocalServiceUtil.findNationalPartecipantDoctor(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue());
		}

<<<<<<< HEAD
		if (_methodName463.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes463, parameterTypes)) {
=======
		if (_methodName455.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes455, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFUserLocalServiceUtil.findNationalPartecipantDoctor(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

<<<<<<< HEAD
		if (_methodName464.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes464, parameterTypes)) {
=======
		if (_methodName456.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes456, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFUserLocalServiceUtil.findPartecipantDoctor(((Integer)arguments[0]).intValue(),
				((Long)arguments[1]).longValue(),
				((Boolean)arguments[2]).booleanValue());
		}

<<<<<<< HEAD
		if (_methodName465.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes465, parameterTypes)) {
=======
		if (_methodName457.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes457, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFUserLocalServiceUtil.findPartecipantDoctor(((Integer)arguments[0]).intValue(),
				((Long)arguments[1]).longValue(),
				((Boolean)arguments[2]).booleanValue(),
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue());
		}

<<<<<<< HEAD
		if (_methodName468.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes468, parameterTypes)) {
=======
		if (_methodName460.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes460, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
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

<<<<<<< HEAD
		if (_methodName469.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes469, parameterTypes)) {
=======
		if (_methodName461.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes461, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
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

<<<<<<< HEAD
		if (_methodName470.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes470, parameterTypes)) {
=======
		if (_methodName462.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes462, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
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

<<<<<<< HEAD
		if (_methodName471.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes471, parameterTypes)) {
=======
		if (_methodName463.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes463, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFUserLocalServiceUtil.deleteESFUser(((Long)arguments[0]).longValue(),
				(java.util.List<it.ethica.esf.model.ESFAddress>)arguments[1],
				(com.liferay.portal.service.ServiceContext)arguments[2]);
		}

<<<<<<< HEAD
		if (_methodName472.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes472, parameterTypes)) {
=======
		if (_methodName464.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes464, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
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

<<<<<<< HEAD
		if (_methodName473.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes473, parameterTypes)) {
=======
		if (_methodName465.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes465, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
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

<<<<<<< HEAD
		if (_methodName474.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes474, parameterTypes)) {
=======
		if (_methodName466.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes466, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
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

<<<<<<< HEAD
		if (_methodName475.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes475, parameterTypes)) {
=======
		if (_methodName467.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes467, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			ESFUserLocalServiceUtil.updateESFUserToESFShooter(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				(it.ethica.esf.model.ESFCard)arguments[2],
				(java.util.List<it.ethica.esf.model.ESFCard>)arguments[3],
				(com.liferay.portal.service.ServiceContext)arguments[4]);

			return null;
		}

<<<<<<< HEAD
		if (_methodName476.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes476, parameterTypes)) {
=======
		if (_methodName468.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes468, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			ESFUserLocalServiceUtil.addESFUserToESFShooter(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());

			return null;
		}

<<<<<<< HEAD
		if (_methodName478.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes478, parameterTypes)) {
			return ESFUserLocalServiceUtil.countByESFUserRole(((Long)arguments[0]).longValue());
		}

		if (_methodName479.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes479, parameterTypes)) {
=======
		if (_methodName470.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes470, parameterTypes)) {
			return ESFUserLocalServiceUtil.countByESFUserRole(((Long)arguments[0]).longValue());
		}

		if (_methodName471.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes471, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFUserLocalServiceUtil.getESFUserRoles(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue());
		}

<<<<<<< HEAD
		if (_methodName480.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes480, parameterTypes)) {
			return ESFUserLocalServiceUtil.getActiveESFUserRoles(((Long)arguments[0]).longValue());
		}

		if (_methodName481.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes481, parameterTypes)) {
			return ESFUserLocalServiceUtil.findAllUser();
		}

		if (_methodName482.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes482, parameterTypes)) {
=======
		if (_methodName472.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes472, parameterTypes)) {
			return ESFUserLocalServiceUtil.getActiveESFUserRoles(((Long)arguments[0]).longValue());
		}

		if (_methodName473.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes473, parameterTypes)) {
			return ESFUserLocalServiceUtil.findAllUser();
		}

		if (_methodName474.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes474, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFUserLocalServiceUtil.checkEmailAddress((java.lang.String)arguments[0],
				(com.liferay.portal.service.ServiceContext)arguments[1]);
		}

<<<<<<< HEAD
		if (_methodName483.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes483, parameterTypes)) {
=======
		if (_methodName475.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes475, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFUserLocalServiceUtil.checkScreenName((java.lang.String)arguments[0],
				(com.liferay.portal.service.ServiceContext)arguments[1]);
		}

<<<<<<< HEAD
		if (_methodName484.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes484, parameterTypes)) {
			return ESFUserLocalServiceUtil.findAllUserByAgeOnlyPeople();
		}

		if (_methodName485.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes485, parameterTypes)) {
=======
		if (_methodName476.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes476, parameterTypes)) {
			return ESFUserLocalServiceUtil.findAllUserByAgeOnlyPeople();
		}

		if (_methodName477.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes477, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFUserLocalServiceUtil.findAllUserByRolenoNull(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

<<<<<<< HEAD
		if (_methodName486.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes486, parameterTypes)) {
=======
		if (_methodName478.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes478, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFUserLocalServiceUtil.findShooterRoleAssignedName((java.lang.String)arguments[0],
				(java.lang.String)arguments[1],
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue(),
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue());
		}

<<<<<<< HEAD
		if (_methodName487.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes487, parameterTypes)) {
=======
		if (_methodName479.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes479, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFUserLocalServiceUtil.countShooterRoleAssignedName((java.lang.String)arguments[0],
				(java.lang.String)arguments[1],
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue());
		}

<<<<<<< HEAD
		if (_methodName488.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes488, parameterTypes)) {
=======
		if (_methodName480.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes480, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFUserLocalServiceUtil.findStaffMatch((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				((Long)arguments[3]).longValue(),
				((Long)arguments[4]).longValue(),
				((Integer)arguments[5]).intValue(),
				((Integer)arguments[6]).intValue());
		}

<<<<<<< HEAD
		if (_methodName489.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes489, parameterTypes)) {
=======
		if (_methodName481.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes481, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFUserLocalServiceUtil.countStaffMatch((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				((Long)arguments[3]).longValue(),
				((Long)arguments[4]).longValue());
		}

<<<<<<< HEAD
		if (_methodName490.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes490, parameterTypes)) {
=======
		if (_methodName482.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes482, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFUserLocalServiceUtil.findShooterNotAssociated((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				((Long)arguments[3]).longValue(),
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue());
		}

<<<<<<< HEAD
		if (_methodName491.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes491, parameterTypes)) {
=======
		if (_methodName483.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes483, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFUserLocalServiceUtil.countNotNationalShooterBySPT((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				((Long)arguments[3]).longValue());
		}

<<<<<<< HEAD
		if (_methodName492.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes492, parameterTypes)) {
=======
		if (_methodName484.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes484, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFUserLocalServiceUtil.findALLShooterNotAssociated((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				((Long)arguments[3]).longValue(),
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue());
		}

<<<<<<< HEAD
		if (_methodName493.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes493, parameterTypes)) {
=======
		if (_methodName485.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes485, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFUserLocalServiceUtil.countALLNotNationalShooterBySPT((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				((Long)arguments[3]).longValue());
		}

<<<<<<< HEAD
		if (_methodName494.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes494, parameterTypes)) {
=======
		if (_methodName486.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes486, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFUserLocalServiceUtil.findStaffNormalMatch((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				((Long)arguments[3]).longValue(),
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue());
		}

<<<<<<< HEAD
		if (_methodName495.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes495, parameterTypes)) {
=======
		if (_methodName487.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes487, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFUserLocalServiceUtil.countStaffNormalMatch((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				((Long)arguments[3]).longValue());
		}

<<<<<<< HEAD
		if (_methodName496.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes496, parameterTypes)) {
=======
		if (_methodName488.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes488, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFUserLocalServiceUtil.countRenwalUser((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], ((Long)arguments[2]).longValue());
		}

<<<<<<< HEAD
		if (_methodName497.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes497, parameterTypes)) {
=======
		if (_methodName489.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes489, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFUserLocalServiceUtil.countNewUser((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], ((Long)arguments[2]).longValue());
		}

<<<<<<< HEAD
		if (_methodName498.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes498, parameterTypes)) {
=======
		if (_methodName490.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes490, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFUserLocalServiceUtil.findByKeyword((java.lang.String)arguments[0],
				(java.lang.String)arguments[1]);
		}

<<<<<<< HEAD
		if (_methodName499.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes499, parameterTypes)) {
=======
		if (_methodName491.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes491, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFUserLocalServiceUtil.findShooterByAss((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				((Long)arguments[3]).longValue(),
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue());
		}

<<<<<<< HEAD
		if (_methodName500.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes500, parameterTypes)) {
=======
		if (_methodName492.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes492, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFUserLocalServiceUtil.countShooterByAss((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				((Long)arguments[3]).longValue());
		}

<<<<<<< HEAD
		if (_methodName501.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes501, parameterTypes)) {
=======
		if (_methodName493.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes493, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFUserLocalServiceUtil.findShooterByAssAndNoAss((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				((Long)arguments[3]).longValue(),
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue());
		}

<<<<<<< HEAD
		if (_methodName502.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes502, parameterTypes)) {
=======
		if (_methodName494.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes494, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFUserLocalServiceUtil.countShooterByAssAndNoAss((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				((Long)arguments[3]).longValue());
		}

<<<<<<< HEAD
		if (_methodName503.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes503, parameterTypes)) {
=======
		if (_methodName495.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes495, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFUserLocalServiceUtil.findDirectorByMatch((java.lang.String)arguments[0],
				(java.lang.String)arguments[1],
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue(),
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue());
		}

<<<<<<< HEAD
		if (_methodName504.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes504, parameterTypes)) {
=======
		if (_methodName496.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes496, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFUserLocalServiceUtil.countDirectorByMatch((java.lang.String)arguments[0],
				(java.lang.String)arguments[1],
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue());
		}

<<<<<<< HEAD
		if (_methodName505.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes505, parameterTypes)) {
			return ESFUserLocalServiceUtil.findNewYouthShooter(((Integer)arguments[0]).intValue());
		}

		if (_methodName506.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes506, parameterTypes)) {
=======
		if (_methodName497.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes497, parameterTypes)) {
			return ESFUserLocalServiceUtil.findNewYouthShooter(((Integer)arguments[0]).intValue());
		}

		if (_methodName498.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes498, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFUserLocalServiceUtil.findYouthByCategory(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

<<<<<<< HEAD
		if (_methodName507.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes507, parameterTypes)) {
=======
		if (_methodName499.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes499, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFUserLocalServiceUtil.findYouthByCategoryTotal(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue());
		}

<<<<<<< HEAD
		if (_methodName508.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes508, parameterTypes)) {
=======
		if (_methodName500.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes500, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFUserLocalServiceUtil.findNotBDOMemberByAssociatioId((java.lang.String)arguments[0],
				(java.lang.String)arguments[1],
				((Long)arguments[2]).longValue(),
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue());
		}

<<<<<<< HEAD
		if (_methodName509.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes509, parameterTypes)) {
=======
		if (_methodName501.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes501, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFUserLocalServiceUtil.countNotBDOMemberByAssociatioId((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], ((Long)arguments[2]).longValue());
		}

<<<<<<< HEAD
		if (_methodName510.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes510, parameterTypes)) {
=======
		if (_methodName502.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes502, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFUserLocalServiceUtil.findAssociatedShooterOrganization((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				((Long)arguments[3]).longValue(),
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue());
		}

<<<<<<< HEAD
		if (_methodName511.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes511, parameterTypes)) {
=======
		if (_methodName503.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes503, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFUserLocalServiceUtil.countAssociatedShooterOrganization((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				((Long)arguments[3]).longValue());
		}

<<<<<<< HEAD
		if (_methodName512.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes512, parameterTypes)) {
=======
		if (_methodName504.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes504, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
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
<<<<<<< HEAD
=======
	private String _methodName388;
	private String[] _methodParameterTypes388;
	private String _methodName389;
	private String[] _methodParameterTypes389;
	private String _methodName394;
	private String[] _methodParameterTypes394;
	private String _methodName395;
	private String[] _methodParameterTypes395;
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
	private String _methodName396;
	private String[] _methodParameterTypes396;
	private String _methodName397;
	private String[] _methodParameterTypes397;
	private String _methodName402;
	private String[] _methodParameterTypes402;
	private String _methodName403;
	private String[] _methodParameterTypes403;
	private String _methodName404;
	private String[] _methodParameterTypes404;
	private String _methodName405;
	private String[] _methodParameterTypes405;
	private String _methodName406;
	private String[] _methodParameterTypes406;
	private String _methodName407;
	private String[] _methodParameterTypes407;
	private String _methodName408;
	private String[] _methodParameterTypes408;
	private String _methodName409;
	private String[] _methodParameterTypes409;
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
<<<<<<< HEAD
=======
	private String _methodName466;
	private String[] _methodParameterTypes466;
	private String _methodName467;
	private String[] _methodParameterTypes467;
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
	private String _methodName468;
	private String[] _methodParameterTypes468;
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
<<<<<<< HEAD
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
=======
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
}