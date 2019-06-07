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

		_methodName402 = "getBeanIdentifier";

		_methodParameterTypes402 = new String[] {  };

		_methodName403 = "setBeanIdentifier";

		_methodParameterTypes403 = new String[] { "java.lang.String" };

		_methodName408 = "findESFMatchesByYearIsNational";

		_methodParameterTypes408 = new String[] { "int", "boolean" };

		_methodName409 = "findESFMatchsByStateIsNational_C_S_M_C_O";

		_methodParameterTypes409 = new String[] {
				"int", "boolean", "java.lang.String", "java.util.Date", "long",
				"long", "java.lang.String"
			};

		_methodName410 = "findESFMatchsByStateIsNational_C_S_M_C_O";

		_methodParameterTypes410 = new String[] {
				"int", "boolean", "java.lang.String", "java.util.Date", "long",
				"long", "java.lang.String", "int", "int"
			};

		_methodName411 = "findESFMatchsByStateIsNational_C_S_M_C_A";

		_methodParameterTypes411 = new String[] {
				"int", "boolean", "java.lang.String", "java.util.Date", "long",
				"long"
			};

		_methodName412 = "findESFMatchsByStateIsNational_C_S_M_C_A";

		_methodParameterTypes412 = new String[] {
				"int", "boolean", "java.lang.String", "java.util.Date", "long",
				"long", "int", "int"
			};

		_methodName413 = "findESFMatchsByStateIsNational_C_S_M_C_I";

		_methodParameterTypes413 = new String[] {
				"int", "boolean", "java.lang.String", "java.util.Date", "long",
				"long"
			};

		_methodName414 = "findESFMatchsByStateIsNational_C_S_M_C_I";

		_methodParameterTypes414 = new String[] {
				"int", "boolean", "java.lang.String", "java.util.Date", "long",
				"long", "int", "int"
			};

		_methodName415 = "findESFMatchsByStateIsNational";

		_methodParameterTypes415 = new String[] { "int", "boolean" };

		_methodName416 = "findESFMatchsByStateIsNational";

		_methodParameterTypes416 = new String[] { "int", "boolean", "int", "int" };

		_methodName417 = "findESFMatchsByO_S_N";

		_methodParameterTypes417 = new String[] {
				"long", "int", "boolean", "int", "int"
			};

		_methodName418 = "findbyIsChangeCategoryYear";

		_methodParameterTypes418 = new String[] { "boolean", "long", "int" };

		_methodName419 = "findbyIsChangeCategoryYearDescription";

		_methodParameterTypes419 = new String[] {
				"boolean", "long", "int", "java.lang.Long"
			};

		_methodName420 = "getESFMatchesByMatchStartDate_T_A_D_N";

		_methodParameterTypes420 = new String[] {
				"java.util.Date", "long", "long", "long", "boolean"
			};

		_methodName421 = "findMyMatches";

		_methodParameterTypes421 = new String[] {
				"long", "boolean", "long", "java.util.Date", "long", "long"
			};

		_methodName422 = "findByUI_iN_OI_sD_dId_STId";

		_methodParameterTypes422 = new String[] {
				"long", "boolean", "long", "java.util.Date", "long", "long",
				"int", "int"
			};

		_methodName423 = "findESFMatchsByO_S_N";

		_methodParameterTypes423 = new String[] { "long", "int", "boolean" };

		_methodName424 = "findbyUserId_IsNational";

		_methodParameterTypes424 = new String[] { "long", "boolean" };

		_methodName425 = "findbyIsChangeCategory";

		_methodParameterTypes425 = new String[] { "boolean", "long" };

		_methodName426 = "findbyUserId_IsNational";

		_methodParameterTypes426 = new String[] { "long", "boolean", "int", "int" };

		_methodName427 = "findbyMatchType";

		_methodParameterTypes427 = new String[] { "long" };

		_methodName428 = "addOrUpdateESFMatch";

		_methodParameterTypes428 = new String[] {
				"long", "long", "long", "java.lang.String", "java.util.Date",
				"java.util.Date", "java.lang.String", "long", "java.lang.String",
				"boolean", "int", "long", "int", "int", "boolean", "boolean",
				"boolean", "long", "boolean", "long[][]", "long[][]", "long",
				"java.lang.String", "boolean",
				"it.ethica.esf.model.ESFEntityState",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName429 = "addOrUpdateESFMatch";

		_methodParameterTypes429 = new String[] {
				"long", "long", "long", "java.lang.String", "java.util.Date",
				"java.util.Date", "java.lang.String", "long", "java.lang.String",
				"boolean", "int", "long", "int", "int", "boolean", "boolean",
				"boolean", "long", "boolean", "long[][]", "long[][]", "long",
				"java.lang.String", "boolean", "boolean",
				"it.ethica.esf.model.ESFEntityState",
				"com.liferay.portal.service.ServiceContext", "java.lang.String",
				"java.lang.String", "java.lang.String"
			};

		_methodName430 = "addOrUpdateESFMatch";

		_methodParameterTypes430 = new String[] {
				"long", "long", "long", "java.lang.String", "java.util.Date",
				"java.util.Date", "java.lang.String", "long", "java.lang.String",
				"boolean", "int", "long", "int", "int", "boolean", "boolean",
				"boolean", "long", "boolean", "long[][]", "long[][]", "long",
				"java.lang.String", "boolean", "boolean",
				"it.ethica.esf.model.ESFEntityState",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName431 = "deleteESFMatch";

		_methodParameterTypes431 = new String[] {
				"long", "com.liferay.portal.service.ServiceContext"
			};

		_methodName432 = "findbyeventType";

		_methodParameterTypes432 = new String[] { "java.lang.String" };

		_methodName433 = "findByDescription";

		_methodParameterTypes433 = new String[] { "long" };

		_methodName434 = "findDelegationActiveMatch";

		_methodParameterTypes434 = new String[] { "long" };

		_methodName435 = "findUnfinishedMatch_UserId";

		_methodParameterTypes435 = new String[] { "long" };

		_methodName436 = "getAllEsfMatchByResults";

		_methodParameterTypes436 = new String[] { "java.util.List" };

		_methodName437 = "addOrUpdateOldESFMatch";

		_methodParameterTypes437 = new String[] {
				"long", "long", "long", "java.lang.String", "java.util.Date",
				"java.util.Date", "java.lang.String", "long", "java.lang.String",
				"boolean", "int", "long", "int", "int", "boolean", "boolean",
				"boolean", "long", "boolean", "long[][]", "long[][]", "long",
				"java.lang.String", "boolean",
				"it.ethica.esf.model.ESFEntityState",
				"com.liferay.portal.service.ServiceContext", "java.lang.String"
			};

		_methodName438 = "findMatchToDispute";

		_methodParameterTypes438 = new String[] {
				"java.lang.String", "boolean", "int", "int"
			};

		_methodName439 = "countMatchToDispute";

		_methodParameterTypes439 = new String[] { "java.lang.String", "boolean" };
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

		if (_methodName402.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes402, parameterTypes)) {
			return ESFMatchLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName403.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes403, parameterTypes)) {
			ESFMatchLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName408.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes408, parameterTypes)) {
			return ESFMatchLocalServiceUtil.findESFMatchesByYearIsNational(((Integer)arguments[0]).intValue(),
				((Boolean)arguments[1]).booleanValue());
		}

		if (_methodName409.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes409, parameterTypes)) {
			return ESFMatchLocalServiceUtil.findESFMatchsByStateIsNational_C_S_M_C_O(((Integer)arguments[0]).intValue(),
				((Boolean)arguments[1]).booleanValue(),
				(java.lang.String)arguments[2], (java.util.Date)arguments[3],
				((Long)arguments[4]).longValue(),
				((Long)arguments[5]).longValue(), (java.lang.String)arguments[6]);
		}

		if (_methodName410.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes410, parameterTypes)) {
			return ESFMatchLocalServiceUtil.findESFMatchsByStateIsNational_C_S_M_C_O(((Integer)arguments[0]).intValue(),
				((Boolean)arguments[1]).booleanValue(),
				(java.lang.String)arguments[2], (java.util.Date)arguments[3],
				((Long)arguments[4]).longValue(),
				((Long)arguments[5]).longValue(),
				(java.lang.String)arguments[6],
				((Integer)arguments[7]).intValue(),
				((Integer)arguments[8]).intValue());
		}

		if (_methodName411.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes411, parameterTypes)) {
			return ESFMatchLocalServiceUtil.findESFMatchsByStateIsNational_C_S_M_C_A(((Integer)arguments[0]).intValue(),
				((Boolean)arguments[1]).booleanValue(),
				(java.lang.String)arguments[2], (java.util.Date)arguments[3],
				((Long)arguments[4]).longValue(),
				((Long)arguments[5]).longValue());
		}

		if (_methodName412.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes412, parameterTypes)) {
			return ESFMatchLocalServiceUtil.findESFMatchsByStateIsNational_C_S_M_C_A(((Integer)arguments[0]).intValue(),
				((Boolean)arguments[1]).booleanValue(),
				(java.lang.String)arguments[2], (java.util.Date)arguments[3],
				((Long)arguments[4]).longValue(),
				((Long)arguments[5]).longValue(),
				((Integer)arguments[6]).intValue(),
				((Integer)arguments[7]).intValue());
		}

		if (_methodName413.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes413, parameterTypes)) {
			return ESFMatchLocalServiceUtil.findESFMatchsByStateIsNational_C_S_M_C_I(((Integer)arguments[0]).intValue(),
				((Boolean)arguments[1]).booleanValue(),
				(java.lang.String)arguments[2], (java.util.Date)arguments[3],
				((Long)arguments[4]).longValue(),
				((Long)arguments[5]).longValue());
		}

		if (_methodName414.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes414, parameterTypes)) {
			return ESFMatchLocalServiceUtil.findESFMatchsByStateIsNational_C_S_M_C_I(((Integer)arguments[0]).intValue(),
				((Boolean)arguments[1]).booleanValue(),
				(java.lang.String)arguments[2], (java.util.Date)arguments[3],
				((Long)arguments[4]).longValue(),
				((Long)arguments[5]).longValue(),
				((Integer)arguments[6]).intValue(),
				((Integer)arguments[7]).intValue());
		}

		if (_methodName415.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes415, parameterTypes)) {
			return ESFMatchLocalServiceUtil.findESFMatchsByStateIsNational(((Integer)arguments[0]).intValue(),
				((Boolean)arguments[1]).booleanValue());
		}

		if (_methodName416.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes416, parameterTypes)) {
			return ESFMatchLocalServiceUtil.findESFMatchsByStateIsNational(((Integer)arguments[0]).intValue(),
				((Boolean)arguments[1]).booleanValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName417.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes417, parameterTypes)) {
			return ESFMatchLocalServiceUtil.findESFMatchsByO_S_N(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Boolean)arguments[2]).booleanValue(),
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue());
		}

		if (_methodName418.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes418, parameterTypes)) {
			return ESFMatchLocalServiceUtil.findbyIsChangeCategoryYear(((Boolean)arguments[0]).booleanValue(),
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName419.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes419, parameterTypes)) {
			return ESFMatchLocalServiceUtil.findbyIsChangeCategoryYearDescription(((Boolean)arguments[0]).booleanValue(),
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue(), (java.lang.Long)arguments[3]);
		}

		if (_methodName420.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes420, parameterTypes)) {
			return ESFMatchLocalServiceUtil.getESFMatchesByMatchStartDate_T_A_D_N((java.util.Date)arguments[0],
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue(),
				((Boolean)arguments[4]).booleanValue());
		}

		if (_methodName421.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes421, parameterTypes)) {
			return ESFMatchLocalServiceUtil.findMyMatches(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue(),
				((Long)arguments[2]).longValue(), (java.util.Date)arguments[3],
				((Long)arguments[4]).longValue(),
				((Long)arguments[5]).longValue());
		}

		if (_methodName422.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes422, parameterTypes)) {
			return ESFMatchLocalServiceUtil.findByUI_iN_OI_sD_dId_STId(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue(),
				((Long)arguments[2]).longValue(), (java.util.Date)arguments[3],
				((Long)arguments[4]).longValue(),
				((Long)arguments[5]).longValue(),
				((Integer)arguments[6]).intValue(),
				((Integer)arguments[7]).intValue());
		}

		if (_methodName423.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes423, parameterTypes)) {
			return ESFMatchLocalServiceUtil.findESFMatchsByO_S_N(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Boolean)arguments[2]).booleanValue());
		}

		if (_methodName424.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes424, parameterTypes)) {
			return ESFMatchLocalServiceUtil.findbyUserId_IsNational(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue());
		}

		if (_methodName425.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes425, parameterTypes)) {
			return ESFMatchLocalServiceUtil.findbyIsChangeCategory(((Boolean)arguments[0]).booleanValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName426.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes426, parameterTypes)) {
			return ESFMatchLocalServiceUtil.findbyUserId_IsNational(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName427.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes427, parameterTypes)) {
			return ESFMatchLocalServiceUtil.findbyMatchType(((Long)arguments[0]).longValue());
		}

		if (_methodName428.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes428, parameterTypes)) {
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

		if (_methodName429.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes429, parameterTypes)) {
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

		if (_methodName430.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes430, parameterTypes)) {
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

		if (_methodName431.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes431, parameterTypes)) {
			return ESFMatchLocalServiceUtil.deleteESFMatch(((Long)arguments[0]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[1]);
		}

		if (_methodName432.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes432, parameterTypes)) {
			return ESFMatchLocalServiceUtil.findbyeventType((java.lang.String)arguments[0]);
		}

		if (_methodName433.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes433, parameterTypes)) {
			return ESFMatchLocalServiceUtil.findByDescription(((Long)arguments[0]).longValue());
		}

		if (_methodName434.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes434, parameterTypes)) {
			return ESFMatchLocalServiceUtil.findDelegationActiveMatch(((Long)arguments[0]).longValue());
		}

		if (_methodName435.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes435, parameterTypes)) {
			return ESFMatchLocalServiceUtil.findUnfinishedMatch_UserId(((Long)arguments[0]).longValue());
		}

		if (_methodName436.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes436, parameterTypes)) {
			return ESFMatchLocalServiceUtil.getAllEsfMatchByResults((java.util.List<it.ethica.esf.model.ESFNationalMatchResult>)arguments[0]);
		}

		if (_methodName437.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes437, parameterTypes)) {
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

		if (_methodName438.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes438, parameterTypes)) {
			return ESFMatchLocalServiceUtil.findMatchToDispute((java.lang.String)arguments[0],
				((Boolean)arguments[1]).booleanValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName439.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes439, parameterTypes)) {
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
	private String _methodName402;
	private String[] _methodParameterTypes402;
	private String _methodName403;
	private String[] _methodParameterTypes403;
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
}