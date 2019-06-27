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

		_methodName438 = "getBeanIdentifier";

		_methodParameterTypes438 = new String[] {  };

		_methodName439 = "setBeanIdentifier";

		_methodParameterTypes439 = new String[] { "java.lang.String" };

		_methodName444 = "findESFMatchesByYearIsNational";

		_methodParameterTypes444 = new String[] { "int", "boolean" };

		_methodName445 = "findESFMatchsByStateIsNational_C_S_M_C_O";

		_methodParameterTypes445 = new String[] {
				"int", "boolean", "java.lang.String", "java.util.Date", "long",
				"long", "java.lang.String"
			};

		_methodName446 = "findESFMatchsByStateIsNational_C_S_M_C_O";

		_methodParameterTypes446 = new String[] {
				"int", "boolean", "java.lang.String", "java.util.Date", "long",
				"long", "java.lang.String", "int", "int"
			};

		_methodName447 = "findESFMatchsByStateIsNational_C_S_M_C_A";

		_methodParameterTypes447 = new String[] {
				"int", "boolean", "java.lang.String", "java.util.Date", "long",
				"long"
			};

		_methodName448 = "findESFMatchsByStateIsNational_C_S_M_C_A";

		_methodParameterTypes448 = new String[] {
				"int", "boolean", "java.lang.String", "java.util.Date", "long",
				"long", "int", "int"
			};

		_methodName449 = "findESFMatchsByStateIsNational_C_S_M_C_I";

		_methodParameterTypes449 = new String[] {
				"int", "boolean", "java.lang.String", "java.util.Date", "long",
				"long"
			};

		_methodName450 = "findESFMatchsByStateIsNational_C_S_M_C_I";

		_methodParameterTypes450 = new String[] {
				"int", "boolean", "java.lang.String", "java.util.Date", "long",
				"long", "int", "int"
			};

		_methodName451 = "findESFMatchsByStateIsNational";

		_methodParameterTypes451 = new String[] { "int", "boolean" };

		_methodName452 = "findESFMatchsByStateIsNational";

		_methodParameterTypes452 = new String[] { "int", "boolean", "int", "int" };

		_methodName453 = "findESFMatchsByO_S_N";

		_methodParameterTypes453 = new String[] {
				"long", "int", "boolean", "int", "int"
			};

		_methodName454 = "findbyIsChangeCategoryYear";

		_methodParameterTypes454 = new String[] { "boolean", "long", "int" };

		_methodName455 = "findbyIsChangeCategoryYearDescription";

		_methodParameterTypes455 = new String[] {
				"boolean", "long", "int", "java.lang.Long"
			};

		_methodName456 = "getESFMatchesByMatchStartDate_T_A_D_N";

		_methodParameterTypes456 = new String[] {
				"java.util.Date", "long", "long", "long", "boolean"
			};

		_methodName457 = "findMyMatches";

		_methodParameterTypes457 = new String[] {
				"long", "boolean", "long", "java.util.Date", "long", "long"
			};

		_methodName458 = "findByUI_iN_OI_sD_dId_STId";

		_methodParameterTypes458 = new String[] {
				"long", "boolean", "long", "java.util.Date", "long", "long",
				"int", "int"
			};

		_methodName459 = "findESFMatchsByO_S_N";

		_methodParameterTypes459 = new String[] { "long", "int", "boolean" };

		_methodName460 = "findbyUserId_IsNational";

		_methodParameterTypes460 = new String[] { "long", "boolean" };

		_methodName461 = "findbyIsChangeCategory";

		_methodParameterTypes461 = new String[] { "boolean", "long" };

		_methodName462 = "findbyUserId_IsNational";

		_methodParameterTypes462 = new String[] { "long", "boolean", "int", "int" };

		_methodName463 = "findbyMatchType";

		_methodParameterTypes463 = new String[] { "long" };

		_methodName464 = "addOrUpdateESFMatch";

		_methodParameterTypes464 = new String[] {
				"long", "long", "long", "java.lang.String", "java.util.Date",
				"java.util.Date", "java.lang.String", "long", "java.lang.String",
				"boolean", "int", "long", "int", "int", "boolean", "boolean",
				"boolean", "long", "boolean", "long[][]", "long[][]", "long",
				"java.lang.String", "boolean",
				"it.ethica.esf.model.ESFEntityState",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName465 = "addOrUpdateESFMatch";

		_methodParameterTypes465 = new String[] {
				"long", "long", "long", "java.lang.String", "java.util.Date",
				"java.util.Date", "java.lang.String", "long", "java.lang.String",
				"boolean", "int", "long", "int", "int", "boolean", "boolean",
				"boolean", "long", "boolean", "long[][]", "long[][]", "long",
				"java.lang.String", "boolean", "boolean",
				"it.ethica.esf.model.ESFEntityState",
				"com.liferay.portal.service.ServiceContext", "java.lang.String",
				"java.lang.String", "java.lang.String"
			};

		_methodName466 = "addOrUpdateESFMatch";

		_methodParameterTypes466 = new String[] {
				"long", "long", "long", "java.lang.String", "java.util.Date",
				"java.util.Date", "java.lang.String", "long", "java.lang.String",
				"boolean", "int", "long", "int", "int", "boolean", "boolean",
				"boolean", "long", "boolean", "long[][]", "long[][]", "long",
				"java.lang.String", "boolean", "boolean",
				"it.ethica.esf.model.ESFEntityState",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName467 = "deleteESFMatch";

		_methodParameterTypes467 = new String[] {
				"long", "com.liferay.portal.service.ServiceContext"
			};

		_methodName468 = "findbyeventType";

		_methodParameterTypes468 = new String[] { "java.lang.String" };

		_methodName469 = "findByDescription";

		_methodParameterTypes469 = new String[] { "long" };

		_methodName470 = "findDelegationActiveMatch";

		_methodParameterTypes470 = new String[] { "long" };

		_methodName471 = "findUnfinishedMatch_UserId";

		_methodParameterTypes471 = new String[] { "long" };

		_methodName472 = "getAllEsfMatchByResults";

		_methodParameterTypes472 = new String[] { "java.util.List" };

		_methodName473 = "addOrUpdateOldESFMatch";

		_methodParameterTypes473 = new String[] {
				"long", "long", "long", "java.lang.String", "java.util.Date",
				"java.util.Date", "java.lang.String", "long", "java.lang.String",
				"boolean", "int", "long", "int", "int", "boolean", "boolean",
				"boolean", "long", "boolean", "long[][]", "long[][]", "long",
				"java.lang.String", "boolean",
				"it.ethica.esf.model.ESFEntityState",
				"com.liferay.portal.service.ServiceContext", "java.lang.String"
			};

		_methodName474 = "findMatchToDispute";

		_methodParameterTypes474 = new String[] {
				"java.lang.String", "boolean", "int", "int"
			};

		_methodName475 = "countMatchToDispute";

		_methodParameterTypes475 = new String[] { "java.lang.String", "boolean" };
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

		if (_methodName438.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes438, parameterTypes)) {
			return ESFMatchLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName439.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes439, parameterTypes)) {
			ESFMatchLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName444.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes444, parameterTypes)) {
			return ESFMatchLocalServiceUtil.findESFMatchesByYearIsNational(((Integer)arguments[0]).intValue(),
				((Boolean)arguments[1]).booleanValue());
		}

		if (_methodName445.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes445, parameterTypes)) {
			return ESFMatchLocalServiceUtil.findESFMatchsByStateIsNational_C_S_M_C_O(((Integer)arguments[0]).intValue(),
				((Boolean)arguments[1]).booleanValue(),
				(java.lang.String)arguments[2], (java.util.Date)arguments[3],
				((Long)arguments[4]).longValue(),
				((Long)arguments[5]).longValue(), (java.lang.String)arguments[6]);
		}

		if (_methodName446.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes446, parameterTypes)) {
			return ESFMatchLocalServiceUtil.findESFMatchsByStateIsNational_C_S_M_C_O(((Integer)arguments[0]).intValue(),
				((Boolean)arguments[1]).booleanValue(),
				(java.lang.String)arguments[2], (java.util.Date)arguments[3],
				((Long)arguments[4]).longValue(),
				((Long)arguments[5]).longValue(),
				(java.lang.String)arguments[6],
				((Integer)arguments[7]).intValue(),
				((Integer)arguments[8]).intValue());
		}

		if (_methodName447.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes447, parameterTypes)) {
			return ESFMatchLocalServiceUtil.findESFMatchsByStateIsNational_C_S_M_C_A(((Integer)arguments[0]).intValue(),
				((Boolean)arguments[1]).booleanValue(),
				(java.lang.String)arguments[2], (java.util.Date)arguments[3],
				((Long)arguments[4]).longValue(),
				((Long)arguments[5]).longValue());
		}

		if (_methodName448.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes448, parameterTypes)) {
			return ESFMatchLocalServiceUtil.findESFMatchsByStateIsNational_C_S_M_C_A(((Integer)arguments[0]).intValue(),
				((Boolean)arguments[1]).booleanValue(),
				(java.lang.String)arguments[2], (java.util.Date)arguments[3],
				((Long)arguments[4]).longValue(),
				((Long)arguments[5]).longValue(),
				((Integer)arguments[6]).intValue(),
				((Integer)arguments[7]).intValue());
		}

		if (_methodName449.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes449, parameterTypes)) {
			return ESFMatchLocalServiceUtil.findESFMatchsByStateIsNational_C_S_M_C_I(((Integer)arguments[0]).intValue(),
				((Boolean)arguments[1]).booleanValue(),
				(java.lang.String)arguments[2], (java.util.Date)arguments[3],
				((Long)arguments[4]).longValue(),
				((Long)arguments[5]).longValue());
		}

		if (_methodName450.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes450, parameterTypes)) {
			return ESFMatchLocalServiceUtil.findESFMatchsByStateIsNational_C_S_M_C_I(((Integer)arguments[0]).intValue(),
				((Boolean)arguments[1]).booleanValue(),
				(java.lang.String)arguments[2], (java.util.Date)arguments[3],
				((Long)arguments[4]).longValue(),
				((Long)arguments[5]).longValue(),
				((Integer)arguments[6]).intValue(),
				((Integer)arguments[7]).intValue());
		}

		if (_methodName451.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes451, parameterTypes)) {
			return ESFMatchLocalServiceUtil.findESFMatchsByStateIsNational(((Integer)arguments[0]).intValue(),
				((Boolean)arguments[1]).booleanValue());
		}

		if (_methodName452.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes452, parameterTypes)) {
			return ESFMatchLocalServiceUtil.findESFMatchsByStateIsNational(((Integer)arguments[0]).intValue(),
				((Boolean)arguments[1]).booleanValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName453.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes453, parameterTypes)) {
			return ESFMatchLocalServiceUtil.findESFMatchsByO_S_N(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Boolean)arguments[2]).booleanValue(),
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue());
		}

		if (_methodName454.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes454, parameterTypes)) {
			return ESFMatchLocalServiceUtil.findbyIsChangeCategoryYear(((Boolean)arguments[0]).booleanValue(),
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName455.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes455, parameterTypes)) {
			return ESFMatchLocalServiceUtil.findbyIsChangeCategoryYearDescription(((Boolean)arguments[0]).booleanValue(),
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue(), (java.lang.Long)arguments[3]);
		}

		if (_methodName456.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes456, parameterTypes)) {
			return ESFMatchLocalServiceUtil.getESFMatchesByMatchStartDate_T_A_D_N((java.util.Date)arguments[0],
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue(),
				((Boolean)arguments[4]).booleanValue());
		}

		if (_methodName457.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes457, parameterTypes)) {
			return ESFMatchLocalServiceUtil.findMyMatches(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue(),
				((Long)arguments[2]).longValue(), (java.util.Date)arguments[3],
				((Long)arguments[4]).longValue(),
				((Long)arguments[5]).longValue());
		}

		if (_methodName458.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes458, parameterTypes)) {
			return ESFMatchLocalServiceUtil.findByUI_iN_OI_sD_dId_STId(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue(),
				((Long)arguments[2]).longValue(), (java.util.Date)arguments[3],
				((Long)arguments[4]).longValue(),
				((Long)arguments[5]).longValue(),
				((Integer)arguments[6]).intValue(),
				((Integer)arguments[7]).intValue());
		}

		if (_methodName459.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes459, parameterTypes)) {
			return ESFMatchLocalServiceUtil.findESFMatchsByO_S_N(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Boolean)arguments[2]).booleanValue());
		}

		if (_methodName460.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes460, parameterTypes)) {
			return ESFMatchLocalServiceUtil.findbyUserId_IsNational(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue());
		}

		if (_methodName461.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes461, parameterTypes)) {
			return ESFMatchLocalServiceUtil.findbyIsChangeCategory(((Boolean)arguments[0]).booleanValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName462.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes462, parameterTypes)) {
			return ESFMatchLocalServiceUtil.findbyUserId_IsNational(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName463.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes463, parameterTypes)) {
			return ESFMatchLocalServiceUtil.findbyMatchType(((Long)arguments[0]).longValue());
		}

		if (_methodName464.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes464, parameterTypes)) {
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

		if (_methodName465.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes465, parameterTypes)) {
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

		if (_methodName466.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes466, parameterTypes)) {
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

		if (_methodName467.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes467, parameterTypes)) {
			return ESFMatchLocalServiceUtil.deleteESFMatch(((Long)arguments[0]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[1]);
		}

		if (_methodName468.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes468, parameterTypes)) {
			return ESFMatchLocalServiceUtil.findbyeventType((java.lang.String)arguments[0]);
		}

		if (_methodName469.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes469, parameterTypes)) {
			return ESFMatchLocalServiceUtil.findByDescription(((Long)arguments[0]).longValue());
		}

		if (_methodName470.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes470, parameterTypes)) {
			return ESFMatchLocalServiceUtil.findDelegationActiveMatch(((Long)arguments[0]).longValue());
		}

		if (_methodName471.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes471, parameterTypes)) {
			return ESFMatchLocalServiceUtil.findUnfinishedMatch_UserId(((Long)arguments[0]).longValue());
		}

		if (_methodName472.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes472, parameterTypes)) {
			return ESFMatchLocalServiceUtil.getAllEsfMatchByResults((java.util.List<it.ethica.esf.model.ESFNationalMatchResult>)arguments[0]);
		}

		if (_methodName473.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes473, parameterTypes)) {
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

		if (_methodName474.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes474, parameterTypes)) {
			return ESFMatchLocalServiceUtil.findMatchToDispute((java.lang.String)arguments[0],
				((Boolean)arguments[1]).booleanValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName475.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes475, parameterTypes)) {
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
	private String _methodName438;
	private String[] _methodParameterTypes438;
	private String _methodName439;
	private String[] _methodParameterTypes439;
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
	private String _methodName474;
	private String[] _methodParameterTypes474;
	private String _methodName475;
	private String[] _methodParameterTypes475;
}