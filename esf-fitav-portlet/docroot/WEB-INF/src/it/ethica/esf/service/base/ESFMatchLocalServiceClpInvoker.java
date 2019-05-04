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

import it.ethica.esf.service.ESFMatchLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Ethica
 * @generated
 */
public class ESFMatchLocalServiceClpInvoker {
	public ESFMatchLocalServiceClpInvoker() {
		_methodName0 = "addESFMatch";

		_methodParameterTypes0 = new String[] { "it.ethica.esf.model.ESFMatch" };

		_methodName1 = "createESFMatch";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteESFMatch";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteESFMatch";

		_methodParameterTypes3 = new String[] { "it.ethica.esf.model.ESFMatch" };

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

		_methodName10 = "fetchESFMatch";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "fetchESFMatchByUuidAndCompanyId";

		_methodParameterTypes11 = new String[] { "java.lang.String", "long" };

		_methodName12 = "fetchESFMatchByUuidAndGroupId";

		_methodParameterTypes12 = new String[] { "java.lang.String", "long" };

		_methodName13 = "getESFMatch";

		_methodParameterTypes13 = new String[] { "long" };

		_methodName14 = "getPersistedModel";

		_methodParameterTypes14 = new String[] { "java.io.Serializable" };

		_methodName15 = "getESFMatchByUuidAndCompanyId";

		_methodParameterTypes15 = new String[] { "java.lang.String", "long" };

		_methodName16 = "getESFMatchByUuidAndGroupId";

		_methodParameterTypes16 = new String[] { "java.lang.String", "long" };

		_methodName17 = "getESFMatchs";

		_methodParameterTypes17 = new String[] { "int", "int" };

		_methodName18 = "getESFMatchsCount";

		_methodParameterTypes18 = new String[] {  };

		_methodName19 = "updateESFMatch";

		_methodParameterTypes19 = new String[] { "it.ethica.esf.model.ESFMatch" };

<<<<<<< HEAD
		_methodName394 = "getBeanIdentifier";

		_methodParameterTypes394 = new String[] {  };

		_methodName395 = "setBeanIdentifier";

		_methodParameterTypes395 = new String[] { "java.lang.String" };

		_methodName400 = "findESFMatchesByYearIsNational";

		_methodParameterTypes400 = new String[] { "int", "boolean" };

		_methodName401 = "findESFMatchsByStateIsNational_C_S_M_C_O";

		_methodParameterTypes401 = new String[] {
=======
		_methodName386 = "getBeanIdentifier";

		_methodParameterTypes386 = new String[] {  };

		_methodName387 = "setBeanIdentifier";

		_methodParameterTypes387 = new String[] { "java.lang.String" };

		_methodName392 = "findESFMatchesByYearIsNational";

		_methodParameterTypes392 = new String[] { "int", "boolean" };

		_methodName393 = "findESFMatchsByStateIsNational_C_S_M_C_O";

		_methodParameterTypes393 = new String[] {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
				"int", "boolean", "java.lang.String", "java.util.Date", "long",
				"long", "java.lang.String"
			};

<<<<<<< HEAD
		_methodName402 = "findESFMatchsByStateIsNational_C_S_M_C_O";

		_methodParameterTypes402 = new String[] {
=======
		_methodName394 = "findESFMatchsByStateIsNational_C_S_M_C_O";

		_methodParameterTypes394 = new String[] {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
				"int", "boolean", "java.lang.String", "java.util.Date", "long",
				"long", "java.lang.String", "int", "int"
			};

<<<<<<< HEAD
		_methodName403 = "findESFMatchsByStateIsNational_C_S_M_C_A";

		_methodParameterTypes403 = new String[] {
=======
		_methodName395 = "findESFMatchsByStateIsNational_C_S_M_C_A";

		_methodParameterTypes395 = new String[] {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
				"int", "boolean", "java.lang.String", "java.util.Date", "long",
				"long"
			};

<<<<<<< HEAD
		_methodName404 = "findESFMatchsByStateIsNational_C_S_M_C_A";

		_methodParameterTypes404 = new String[] {
=======
		_methodName396 = "findESFMatchsByStateIsNational_C_S_M_C_A";

		_methodParameterTypes396 = new String[] {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
				"int", "boolean", "java.lang.String", "java.util.Date", "long",
				"long", "int", "int"
			};

<<<<<<< HEAD
		_methodName405 = "findESFMatchsByStateIsNational_C_S_M_C_I";

		_methodParameterTypes405 = new String[] {
=======
		_methodName397 = "findESFMatchsByStateIsNational_C_S_M_C_I";

		_methodParameterTypes397 = new String[] {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
				"int", "boolean", "java.lang.String", "java.util.Date", "long",
				"long"
			};

<<<<<<< HEAD
		_methodName406 = "findESFMatchsByStateIsNational_C_S_M_C_I";

		_methodParameterTypes406 = new String[] {
=======
		_methodName398 = "findESFMatchsByStateIsNational_C_S_M_C_I";

		_methodParameterTypes398 = new String[] {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
				"int", "boolean", "java.lang.String", "java.util.Date", "long",
				"long", "int", "int"
			};

<<<<<<< HEAD
		_methodName407 = "findESFMatchsByStateIsNational";

		_methodParameterTypes407 = new String[] { "int", "boolean" };

		_methodName408 = "findESFMatchsByStateIsNational";

		_methodParameterTypes408 = new String[] { "int", "boolean", "int", "int" };

		_methodName409 = "findESFMatchsByO_S_N";

		_methodParameterTypes409 = new String[] {
				"long", "int", "boolean", "int", "int"
			};

		_methodName410 = "findbyIsChangeCategoryYear";

		_methodParameterTypes410 = new String[] { "boolean", "long", "int" };

		_methodName411 = "findbyIsChangeCategoryYearDescription";

		_methodParameterTypes411 = new String[] {
				"boolean", "long", "int", "java.lang.Long"
			};

		_methodName412 = "getESFMatchesByMatchStartDate_T_A_D_N";

		_methodParameterTypes412 = new String[] {
				"java.util.Date", "long", "long", "long", "boolean"
			};

		_methodName413 = "findMyMatches";

		_methodParameterTypes413 = new String[] {
				"long", "boolean", "long", "java.util.Date", "long", "long"
			};

		_methodName414 = "findByUI_iN_OI_sD_dId_STId";

		_methodParameterTypes414 = new String[] {
=======
		_methodName399 = "findESFMatchsByStateIsNational";

		_methodParameterTypes399 = new String[] { "int", "boolean" };

		_methodName400 = "findESFMatchsByStateIsNational";

		_methodParameterTypes400 = new String[] { "int", "boolean", "int", "int" };

		_methodName401 = "findESFMatchsByO_S_N";

		_methodParameterTypes401 = new String[] {
				"long", "int", "boolean", "int", "int"
			};

		_methodName402 = "findbyIsChangeCategoryYear";

		_methodParameterTypes402 = new String[] { "boolean", "long", "int" };

		_methodName403 = "findbyIsChangeCategoryYearDescription";

		_methodParameterTypes403 = new String[] {
				"boolean", "long", "int", "java.lang.Long"
			};

		_methodName404 = "getESFMatchesByMatchStartDate_T_A_D_N";

		_methodParameterTypes404 = new String[] {
				"java.util.Date", "long", "long", "long", "boolean"
			};

		_methodName405 = "findMyMatches";

		_methodParameterTypes405 = new String[] {
				"long", "boolean", "long", "java.util.Date", "long", "long"
			};

		_methodName406 = "findByUI_iN_OI_sD_dId_STId";

		_methodParameterTypes406 = new String[] {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
				"long", "boolean", "long", "java.util.Date", "long", "long",
				"int", "int"
			};

<<<<<<< HEAD
		_methodName415 = "findESFMatchsByO_S_N";

		_methodParameterTypes415 = new String[] { "long", "int", "boolean" };

		_methodName416 = "findbyUserId_IsNational";

		_methodParameterTypes416 = new String[] { "long", "boolean" };

		_methodName417 = "findbyIsChangeCategory";

		_methodParameterTypes417 = new String[] { "boolean", "long" };

		_methodName418 = "findbyUserId_IsNational";

		_methodParameterTypes418 = new String[] { "long", "boolean", "int", "int" };

		_methodName419 = "findbyMatchType";

		_methodParameterTypes419 = new String[] { "long" };

		_methodName420 = "addOrUpdateESFMatch";

		_methodParameterTypes420 = new String[] {
=======
		_methodName407 = "findESFMatchsByO_S_N";

		_methodParameterTypes407 = new String[] { "long", "int", "boolean" };

		_methodName408 = "findbyUserId_IsNational";

		_methodParameterTypes408 = new String[] { "long", "boolean" };

		_methodName409 = "findbyIsChangeCategory";

		_methodParameterTypes409 = new String[] { "boolean", "long" };

		_methodName410 = "findbyUserId_IsNational";

		_methodParameterTypes410 = new String[] { "long", "boolean", "int", "int" };

		_methodName411 = "findbyMatchType";

		_methodParameterTypes411 = new String[] { "long" };

		_methodName412 = "addOrUpdateESFMatch";

		_methodParameterTypes412 = new String[] {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
				"long", "long", "long", "java.lang.String", "java.util.Date",
				"java.util.Date", "java.lang.String", "long", "java.lang.String",
				"boolean", "int", "long", "int", "int", "boolean", "boolean",
				"boolean", "long", "boolean", "long[][]", "long[][]", "long",
				"java.lang.String", "boolean",
				"it.ethica.esf.model.ESFEntityState",
				"com.liferay.portal.service.ServiceContext"
			};

<<<<<<< HEAD
		_methodName421 = "addOrUpdateESFMatch";

		_methodParameterTypes421 = new String[] {
=======
		_methodName413 = "addOrUpdateESFMatch";

		_methodParameterTypes413 = new String[] {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
				"long", "long", "long", "java.lang.String", "java.util.Date",
				"java.util.Date", "java.lang.String", "long", "java.lang.String",
				"boolean", "int", "long", "int", "int", "boolean", "boolean",
				"boolean", "long", "boolean", "long[][]", "long[][]", "long",
				"java.lang.String", "boolean", "boolean",
				"it.ethica.esf.model.ESFEntityState",
				"com.liferay.portal.service.ServiceContext", "java.lang.String",
				"java.lang.String", "java.lang.String"
			};

<<<<<<< HEAD
		_methodName422 = "addOrUpdateESFMatch";

		_methodParameterTypes422 = new String[] {
=======
		_methodName414 = "addOrUpdateESFMatch";

		_methodParameterTypes414 = new String[] {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
				"long", "long", "long", "java.lang.String", "java.util.Date",
				"java.util.Date", "java.lang.String", "long", "java.lang.String",
				"boolean", "int", "long", "int", "int", "boolean", "boolean",
				"boolean", "long", "boolean", "long[][]", "long[][]", "long",
				"java.lang.String", "boolean", "boolean",
				"it.ethica.esf.model.ESFEntityState",
				"com.liferay.portal.service.ServiceContext"
			};

<<<<<<< HEAD
		_methodName423 = "deleteESFMatch";

		_methodParameterTypes423 = new String[] {
				"long", "com.liferay.portal.service.ServiceContext"
			};

		_methodName424 = "findbyeventType";

		_methodParameterTypes424 = new String[] { "java.lang.String" };

		_methodName425 = "findByDescription";

		_methodParameterTypes425 = new String[] { "long" };

		_methodName426 = "findDelegationActiveMatch";

		_methodParameterTypes426 = new String[] { "long" };

		_methodName427 = "findUnfinishedMatch_UserId";

		_methodParameterTypes427 = new String[] { "long" };

		_methodName428 = "getAllEsfMatchByResults";

		_methodParameterTypes428 = new String[] { "java.util.List" };

		_methodName429 = "addOrUpdateOldESFMatch";

		_methodParameterTypes429 = new String[] {
=======
		_methodName415 = "deleteESFMatch";

		_methodParameterTypes415 = new String[] {
				"long", "com.liferay.portal.service.ServiceContext"
			};

		_methodName416 = "findbyeventType";

		_methodParameterTypes416 = new String[] { "java.lang.String" };

		_methodName417 = "findByDescription";

		_methodParameterTypes417 = new String[] { "long" };

		_methodName418 = "findDelegationActiveMatch";

		_methodParameterTypes418 = new String[] { "long" };

		_methodName419 = "findUnfinishedMatch_UserId";

		_methodParameterTypes419 = new String[] { "long" };

		_methodName420 = "getAllEsfMatchByResults";

		_methodParameterTypes420 = new String[] { "java.util.List" };

		_methodName421 = "addOrUpdateOldESFMatch";

		_methodParameterTypes421 = new String[] {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
				"long", "long", "long", "java.lang.String", "java.util.Date",
				"java.util.Date", "java.lang.String", "long", "java.lang.String",
				"boolean", "int", "long", "int", "int", "boolean", "boolean",
				"boolean", "long", "boolean", "long[][]", "long[][]", "long",
				"java.lang.String", "boolean",
				"it.ethica.esf.model.ESFEntityState",
				"com.liferay.portal.service.ServiceContext", "java.lang.String"
			};

<<<<<<< HEAD
		_methodName430 = "findMatchToDispute";

		_methodParameterTypes430 = new String[] {
				"java.lang.String", "boolean", "int", "int"
			};

		_methodName431 = "countMatchToDispute";

		_methodParameterTypes431 = new String[] { "java.lang.String", "boolean" };
=======
		_methodName422 = "findMatchToDispute";

		_methodParameterTypes422 = new String[] {
				"java.lang.String", "boolean", "int", "int"
			};

		_methodName423 = "countMatchToDispute";

		_methodParameterTypes423 = new String[] { "java.lang.String", "boolean" };
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return ESFMatchLocalServiceUtil.addESFMatch((it.ethica.esf.model.ESFMatch)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return ESFMatchLocalServiceUtil.createESFMatch(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return ESFMatchLocalServiceUtil.deleteESFMatch(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return ESFMatchLocalServiceUtil.deleteESFMatch((it.ethica.esf.model.ESFMatch)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return ESFMatchLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return ESFMatchLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return ESFMatchLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return ESFMatchLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return ESFMatchLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return ESFMatchLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return ESFMatchLocalServiceUtil.fetchESFMatch(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return ESFMatchLocalServiceUtil.fetchESFMatchByUuidAndCompanyId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return ESFMatchLocalServiceUtil.fetchESFMatchByUuidAndGroupId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return ESFMatchLocalServiceUtil.getESFMatch(((Long)arguments[0]).longValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return ESFMatchLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return ESFMatchLocalServiceUtil.getESFMatchByUuidAndCompanyId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName16.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes16, parameterTypes)) {
			return ESFMatchLocalServiceUtil.getESFMatchByUuidAndGroupId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName17.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes17, parameterTypes)) {
			return ESFMatchLocalServiceUtil.getESFMatchs(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName18.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes18, parameterTypes)) {
			return ESFMatchLocalServiceUtil.getESFMatchsCount();
		}

		if (_methodName19.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes19, parameterTypes)) {
			return ESFMatchLocalServiceUtil.updateESFMatch((it.ethica.esf.model.ESFMatch)arguments[0]);
		}

<<<<<<< HEAD
		if (_methodName394.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes394, parameterTypes)) {
			return ESFMatchLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName395.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes395, parameterTypes)) {
=======
		if (_methodName386.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes386, parameterTypes)) {
			return ESFMatchLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName387.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes387, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			ESFMatchLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

<<<<<<< HEAD
		if (_methodName400.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes400, parameterTypes)) {
=======
		if (_methodName392.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes392, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFMatchLocalServiceUtil.findESFMatchesByYearIsNational(((Integer)arguments[0]).intValue(),
				((Boolean)arguments[1]).booleanValue());
		}

<<<<<<< HEAD
		if (_methodName401.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes401, parameterTypes)) {
=======
		if (_methodName393.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes393, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFMatchLocalServiceUtil.findESFMatchsByStateIsNational_C_S_M_C_O(((Integer)arguments[0]).intValue(),
				((Boolean)arguments[1]).booleanValue(),
				(java.lang.String)arguments[2], (java.util.Date)arguments[3],
				((Long)arguments[4]).longValue(),
				((Long)arguments[5]).longValue(), (java.lang.String)arguments[6]);
		}

<<<<<<< HEAD
		if (_methodName402.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes402, parameterTypes)) {
=======
		if (_methodName394.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes394, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFMatchLocalServiceUtil.findESFMatchsByStateIsNational_C_S_M_C_O(((Integer)arguments[0]).intValue(),
				((Boolean)arguments[1]).booleanValue(),
				(java.lang.String)arguments[2], (java.util.Date)arguments[3],
				((Long)arguments[4]).longValue(),
				((Long)arguments[5]).longValue(),
				(java.lang.String)arguments[6],
				((Integer)arguments[7]).intValue(),
				((Integer)arguments[8]).intValue());
		}

<<<<<<< HEAD
		if (_methodName403.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes403, parameterTypes)) {
=======
		if (_methodName395.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes395, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFMatchLocalServiceUtil.findESFMatchsByStateIsNational_C_S_M_C_A(((Integer)arguments[0]).intValue(),
				((Boolean)arguments[1]).booleanValue(),
				(java.lang.String)arguments[2], (java.util.Date)arguments[3],
				((Long)arguments[4]).longValue(),
				((Long)arguments[5]).longValue());
		}

<<<<<<< HEAD
		if (_methodName404.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes404, parameterTypes)) {
=======
		if (_methodName396.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes396, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFMatchLocalServiceUtil.findESFMatchsByStateIsNational_C_S_M_C_A(((Integer)arguments[0]).intValue(),
				((Boolean)arguments[1]).booleanValue(),
				(java.lang.String)arguments[2], (java.util.Date)arguments[3],
				((Long)arguments[4]).longValue(),
				((Long)arguments[5]).longValue(),
				((Integer)arguments[6]).intValue(),
				((Integer)arguments[7]).intValue());
		}

<<<<<<< HEAD
		if (_methodName405.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes405, parameterTypes)) {
=======
		if (_methodName397.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes397, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFMatchLocalServiceUtil.findESFMatchsByStateIsNational_C_S_M_C_I(((Integer)arguments[0]).intValue(),
				((Boolean)arguments[1]).booleanValue(),
				(java.lang.String)arguments[2], (java.util.Date)arguments[3],
				((Long)arguments[4]).longValue(),
				((Long)arguments[5]).longValue());
		}

<<<<<<< HEAD
		if (_methodName406.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes406, parameterTypes)) {
=======
		if (_methodName398.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes398, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFMatchLocalServiceUtil.findESFMatchsByStateIsNational_C_S_M_C_I(((Integer)arguments[0]).intValue(),
				((Boolean)arguments[1]).booleanValue(),
				(java.lang.String)arguments[2], (java.util.Date)arguments[3],
				((Long)arguments[4]).longValue(),
				((Long)arguments[5]).longValue(),
				((Integer)arguments[6]).intValue(),
				((Integer)arguments[7]).intValue());
		}

<<<<<<< HEAD
		if (_methodName407.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes407, parameterTypes)) {
=======
		if (_methodName399.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes399, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFMatchLocalServiceUtil.findESFMatchsByStateIsNational(((Integer)arguments[0]).intValue(),
				((Boolean)arguments[1]).booleanValue());
		}

<<<<<<< HEAD
		if (_methodName408.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes408, parameterTypes)) {
=======
		if (_methodName400.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes400, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFMatchLocalServiceUtil.findESFMatchsByStateIsNational(((Integer)arguments[0]).intValue(),
				((Boolean)arguments[1]).booleanValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

<<<<<<< HEAD
		if (_methodName409.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes409, parameterTypes)) {
=======
		if (_methodName401.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes401, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFMatchLocalServiceUtil.findESFMatchsByO_S_N(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Boolean)arguments[2]).booleanValue(),
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue());
		}

<<<<<<< HEAD
		if (_methodName410.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes410, parameterTypes)) {
=======
		if (_methodName402.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes402, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFMatchLocalServiceUtil.findbyIsChangeCategoryYear(((Boolean)arguments[0]).booleanValue(),
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue());
		}

<<<<<<< HEAD
		if (_methodName411.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes411, parameterTypes)) {
=======
		if (_methodName403.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes403, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFMatchLocalServiceUtil.findbyIsChangeCategoryYearDescription(((Boolean)arguments[0]).booleanValue(),
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue(), (java.lang.Long)arguments[3]);
		}

<<<<<<< HEAD
		if (_methodName412.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes412, parameterTypes)) {
=======
		if (_methodName404.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes404, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFMatchLocalServiceUtil.getESFMatchesByMatchStartDate_T_A_D_N((java.util.Date)arguments[0],
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue(),
				((Boolean)arguments[4]).booleanValue());
		}

<<<<<<< HEAD
		if (_methodName413.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes413, parameterTypes)) {
=======
		if (_methodName405.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes405, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFMatchLocalServiceUtil.findMyMatches(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue(),
				((Long)arguments[2]).longValue(), (java.util.Date)arguments[3],
				((Long)arguments[4]).longValue(),
				((Long)arguments[5]).longValue());
		}

<<<<<<< HEAD
		if (_methodName414.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes414, parameterTypes)) {
=======
		if (_methodName406.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes406, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFMatchLocalServiceUtil.findByUI_iN_OI_sD_dId_STId(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue(),
				((Long)arguments[2]).longValue(), (java.util.Date)arguments[3],
				((Long)arguments[4]).longValue(),
				((Long)arguments[5]).longValue(),
				((Integer)arguments[6]).intValue(),
				((Integer)arguments[7]).intValue());
		}

<<<<<<< HEAD
		if (_methodName415.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes415, parameterTypes)) {
=======
		if (_methodName407.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes407, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFMatchLocalServiceUtil.findESFMatchsByO_S_N(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Boolean)arguments[2]).booleanValue());
		}

<<<<<<< HEAD
		if (_methodName416.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes416, parameterTypes)) {
=======
		if (_methodName408.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes408, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFMatchLocalServiceUtil.findbyUserId_IsNational(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue());
		}

<<<<<<< HEAD
		if (_methodName417.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes417, parameterTypes)) {
=======
		if (_methodName409.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes409, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFMatchLocalServiceUtil.findbyIsChangeCategory(((Boolean)arguments[0]).booleanValue(),
				((Long)arguments[1]).longValue());
		}

<<<<<<< HEAD
		if (_methodName418.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes418, parameterTypes)) {
=======
		if (_methodName410.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes410, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFMatchLocalServiceUtil.findbyUserId_IsNational(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

<<<<<<< HEAD
		if (_methodName419.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes419, parameterTypes)) {
			return ESFMatchLocalServiceUtil.findbyMatchType(((Long)arguments[0]).longValue());
		}

		if (_methodName420.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes420, parameterTypes)) {
=======
		if (_methodName411.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes411, parameterTypes)) {
			return ESFMatchLocalServiceUtil.findbyMatchType(((Long)arguments[0]).longValue());
		}

		if (_methodName412.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes412, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFMatchLocalServiceUtil.addOrUpdateESFMatch(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				(java.lang.String)arguments[3], (java.util.Date)arguments[4],
				(java.util.Date)arguments[5], (java.lang.String)arguments[6],
				((Long)arguments[7]).longValue(),
				(java.lang.String)arguments[8],
				((Boolean)arguments[9]).booleanValue(),
				((Integer)arguments[10]).intValue(),
				((Long)arguments[11]).longValue(),
				((Integer)arguments[12]).intValue(),
				((Integer)arguments[13]).intValue(),
				((Boolean)arguments[14]).booleanValue(),
				((Boolean)arguments[15]).booleanValue(),
				((Boolean)arguments[16]).booleanValue(),
				((Long)arguments[17]).longValue(),
				((Boolean)arguments[18]).booleanValue(), (long[])arguments[19],
				(long[])arguments[20], ((Long)arguments[21]).longValue(),
				(java.lang.String)arguments[22],
				((Boolean)arguments[23]).booleanValue(),
				(it.ethica.esf.model.ESFEntityState)arguments[24],
				(com.liferay.portal.service.ServiceContext)arguments[25]);
		}

<<<<<<< HEAD
		if (_methodName421.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes421, parameterTypes)) {
=======
		if (_methodName413.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes413, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFMatchLocalServiceUtil.addOrUpdateESFMatch(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				(java.lang.String)arguments[3], (java.util.Date)arguments[4],
				(java.util.Date)arguments[5], (java.lang.String)arguments[6],
				((Long)arguments[7]).longValue(),
				(java.lang.String)arguments[8],
				((Boolean)arguments[9]).booleanValue(),
				((Integer)arguments[10]).intValue(),
				((Long)arguments[11]).longValue(),
				((Integer)arguments[12]).intValue(),
				((Integer)arguments[13]).intValue(),
				((Boolean)arguments[14]).booleanValue(),
				((Boolean)arguments[15]).booleanValue(),
				((Boolean)arguments[16]).booleanValue(),
				((Long)arguments[17]).longValue(),
				((Boolean)arguments[18]).booleanValue(), (long[])arguments[19],
				(long[])arguments[20], ((Long)arguments[21]).longValue(),
				(java.lang.String)arguments[22],
				((Boolean)arguments[23]).booleanValue(),
				((Boolean)arguments[24]).booleanValue(),
				(it.ethica.esf.model.ESFEntityState)arguments[25],
				(com.liferay.portal.service.ServiceContext)arguments[26],
				(java.lang.String)arguments[27],
				(java.lang.String)arguments[28], (java.lang.String)arguments[29]);
		}

<<<<<<< HEAD
		if (_methodName422.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes422, parameterTypes)) {
=======
		if (_methodName414.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes414, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFMatchLocalServiceUtil.addOrUpdateESFMatch(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				(java.lang.String)arguments[3], (java.util.Date)arguments[4],
				(java.util.Date)arguments[5], (java.lang.String)arguments[6],
				((Long)arguments[7]).longValue(),
				(java.lang.String)arguments[8],
				((Boolean)arguments[9]).booleanValue(),
				((Integer)arguments[10]).intValue(),
				((Long)arguments[11]).longValue(),
				((Integer)arguments[12]).intValue(),
				((Integer)arguments[13]).intValue(),
				((Boolean)arguments[14]).booleanValue(),
				((Boolean)arguments[15]).booleanValue(),
				((Boolean)arguments[16]).booleanValue(),
				((Long)arguments[17]).longValue(),
				((Boolean)arguments[18]).booleanValue(), (long[])arguments[19],
				(long[])arguments[20], ((Long)arguments[21]).longValue(),
				(java.lang.String)arguments[22],
				((Boolean)arguments[23]).booleanValue(),
				((Boolean)arguments[24]).booleanValue(),
				(it.ethica.esf.model.ESFEntityState)arguments[25],
				(com.liferay.portal.service.ServiceContext)arguments[26]);
		}

<<<<<<< HEAD
		if (_methodName423.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes423, parameterTypes)) {
=======
		if (_methodName415.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes415, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFMatchLocalServiceUtil.deleteESFMatch(((Long)arguments[0]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[1]);
		}

<<<<<<< HEAD
		if (_methodName424.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes424, parameterTypes)) {
			return ESFMatchLocalServiceUtil.findbyeventType((java.lang.String)arguments[0]);
		}

		if (_methodName425.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes425, parameterTypes)) {
			return ESFMatchLocalServiceUtil.findByDescription(((Long)arguments[0]).longValue());
		}

		if (_methodName426.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes426, parameterTypes)) {
			return ESFMatchLocalServiceUtil.findDelegationActiveMatch(((Long)arguments[0]).longValue());
		}

		if (_methodName427.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes427, parameterTypes)) {
			return ESFMatchLocalServiceUtil.findUnfinishedMatch_UserId(((Long)arguments[0]).longValue());
		}

		if (_methodName428.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes428, parameterTypes)) {
			return ESFMatchLocalServiceUtil.getAllEsfMatchByResults((java.util.List<it.ethica.esf.model.ESFNationalMatchResult>)arguments[0]);
		}

		if (_methodName429.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes429, parameterTypes)) {
=======
		if (_methodName416.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes416, parameterTypes)) {
			return ESFMatchLocalServiceUtil.findbyeventType((java.lang.String)arguments[0]);
		}

		if (_methodName417.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes417, parameterTypes)) {
			return ESFMatchLocalServiceUtil.findByDescription(((Long)arguments[0]).longValue());
		}

		if (_methodName418.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes418, parameterTypes)) {
			return ESFMatchLocalServiceUtil.findDelegationActiveMatch(((Long)arguments[0]).longValue());
		}

		if (_methodName419.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes419, parameterTypes)) {
			return ESFMatchLocalServiceUtil.findUnfinishedMatch_UserId(((Long)arguments[0]).longValue());
		}

		if (_methodName420.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes420, parameterTypes)) {
			return ESFMatchLocalServiceUtil.getAllEsfMatchByResults((java.util.List<it.ethica.esf.model.ESFNationalMatchResult>)arguments[0]);
		}

		if (_methodName421.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes421, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFMatchLocalServiceUtil.addOrUpdateOldESFMatch(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				(java.lang.String)arguments[3], (java.util.Date)arguments[4],
				(java.util.Date)arguments[5], (java.lang.String)arguments[6],
				((Long)arguments[7]).longValue(),
				(java.lang.String)arguments[8],
				((Boolean)arguments[9]).booleanValue(),
				((Integer)arguments[10]).intValue(),
				((Long)arguments[11]).longValue(),
				((Integer)arguments[12]).intValue(),
				((Integer)arguments[13]).intValue(),
				((Boolean)arguments[14]).booleanValue(),
				((Boolean)arguments[15]).booleanValue(),
				((Boolean)arguments[16]).booleanValue(),
				((Long)arguments[17]).longValue(),
				((Boolean)arguments[18]).booleanValue(), (long[])arguments[19],
				(long[])arguments[20], ((Long)arguments[21]).longValue(),
				(java.lang.String)arguments[22],
				((Boolean)arguments[23]).booleanValue(),
				(it.ethica.esf.model.ESFEntityState)arguments[24],
				(com.liferay.portal.service.ServiceContext)arguments[25],
				(java.lang.String)arguments[26]);
		}

<<<<<<< HEAD
		if (_methodName430.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes430, parameterTypes)) {
=======
		if (_methodName422.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes422, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFMatchLocalServiceUtil.findMatchToDispute((java.lang.String)arguments[0],
				((Boolean)arguments[1]).booleanValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

<<<<<<< HEAD
		if (_methodName431.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes431, parameterTypes)) {
=======
		if (_methodName423.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes423, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFMatchLocalServiceUtil.countMatchToDispute((java.lang.String)arguments[0],
				((Boolean)arguments[1]).booleanValue());
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
	private String _methodName16;
	private String[] _methodParameterTypes16;
	private String _methodName17;
	private String[] _methodParameterTypes17;
	private String _methodName18;
	private String[] _methodParameterTypes18;
	private String _methodName19;
	private String[] _methodParameterTypes19;
<<<<<<< HEAD
=======
	private String _methodName386;
	private String[] _methodParameterTypes386;
	private String _methodName387;
	private String[] _methodParameterTypes387;
	private String _methodName392;
	private String[] _methodParameterTypes392;
	private String _methodName393;
	private String[] _methodParameterTypes393;
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
	private String _methodName394;
	private String[] _methodParameterTypes394;
	private String _methodName395;
	private String[] _methodParameterTypes395;
	private String _methodName400;
	private String[] _methodParameterTypes400;
	private String _methodName401;
	private String[] _methodParameterTypes401;
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
<<<<<<< HEAD
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
=======
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
}