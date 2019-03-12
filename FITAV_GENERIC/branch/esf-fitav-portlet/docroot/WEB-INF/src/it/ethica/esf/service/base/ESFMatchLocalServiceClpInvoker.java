/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

		_methodName304 = "getBeanIdentifier";

		_methodParameterTypes304 = new String[] {  };

		_methodName305 = "setBeanIdentifier";

		_methodParameterTypes305 = new String[] { "java.lang.String" };

		_methodName310 = "findESFMatchesByYearIsNational";

		_methodParameterTypes310 = new String[] { "int", "boolean" };

		_methodName311 = "findESFMatchsByStateIsNational_C_S_M_C_O";

		_methodParameterTypes311 = new String[] {
				"int", "boolean", "java.lang.String", "java.util.Date", "long",
				"long", "java.lang.String"
			};

		_methodName312 = "findESFMatchsByStateIsNational_C_S_M_C_O";

		_methodParameterTypes312 = new String[] {
				"int", "boolean", "java.lang.String", "java.util.Date", "long",
				"long", "java.lang.String", "int", "int"
			};

		_methodName313 = "findESFMatchsByStateIsNational_C_S_M_C_A";

		_methodParameterTypes313 = new String[] {
				"int", "boolean", "java.lang.String", "java.util.Date", "long",
				"long"
			};

		_methodName314 = "findESFMatchsByStateIsNational_C_S_M_C_A";

		_methodParameterTypes314 = new String[] {
				"int", "boolean", "java.lang.String", "java.util.Date", "long",
				"long", "int", "int"
			};

		_methodName315 = "findESFMatchsByStateIsNational_C_S_M_C_I";

		_methodParameterTypes315 = new String[] {
				"int", "boolean", "java.lang.String", "java.util.Date", "long",
				"long"
			};

		_methodName316 = "findESFMatchsByStateIsNational_C_S_M_C_I";

		_methodParameterTypes316 = new String[] {
				"int", "boolean", "java.lang.String", "java.util.Date", "long",
				"long", "int", "int"
			};

		_methodName317 = "findESFMatchsByStateIsNational";

		_methodParameterTypes317 = new String[] { "int", "boolean" };

		_methodName318 = "findESFMatchsByStateIsNational";

		_methodParameterTypes318 = new String[] { "int", "boolean", "int", "int" };

		_methodName319 = "findESFMatchsByO_S_N";

		_methodParameterTypes319 = new String[] {
				"long", "int", "boolean", "int", "int"
			};

		_methodName320 = "findbyIsChangeCategoryYear";

		_methodParameterTypes320 = new String[] { "boolean", "long", "int" };

		_methodName321 = "findbyIsChangeCategoryYearDescription";

		_methodParameterTypes321 = new String[] {
				"boolean", "long", "int", "java.lang.Long"
			};

		_methodName322 = "getESFMatchesByMatchStartDate_T_A_D_N";

		_methodParameterTypes322 = new String[] {
				"java.util.Date", "long", "long", "long", "boolean"
			};

		_methodName323 = "findMyMatches";

		_methodParameterTypes323 = new String[] {
				"long", "boolean", "long", "java.util.Date", "long", "long"
			};

		_methodName324 = "findByUI_iN_OI_sD_dId_STId";

		_methodParameterTypes324 = new String[] {
				"long", "boolean", "long", "java.util.Date", "long", "long",
				"int", "int"
			};

		_methodName325 = "findESFMatchsByO_S_N";

		_methodParameterTypes325 = new String[] { "long", "int", "boolean" };

		_methodName326 = "findbyUserId_IsNational";

		_methodParameterTypes326 = new String[] { "long", "boolean" };

		_methodName327 = "findbyIsChangeCategory";

		_methodParameterTypes327 = new String[] { "boolean", "long" };

		_methodName328 = "findbyUserId_IsNational";

		_methodParameterTypes328 = new String[] { "long", "boolean", "int", "int" };

		_methodName329 = "findbyMatchType";

		_methodParameterTypes329 = new String[] { "long" };

		_methodName330 = "addOrUpdateESFMatch";

		_methodParameterTypes330 = new String[] {
				"long", "long", "long", "java.lang.String", "java.util.Date",
				"java.util.Date", "java.lang.String", "long", "java.lang.String",
				"boolean", "int", "long", "int", "int", "boolean", "boolean",
				"boolean", "long", "boolean", "long[][]", "long[][]", "long",
				"java.lang.String", "boolean",
				"it.ethica.esf.model.ESFEntityState",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName331 = "addOrUpdateESFMatch";

		_methodParameterTypes331 = new String[] {
				"long", "long", "long", "java.lang.String", "java.util.Date",
				"java.util.Date", "java.lang.String", "long", "java.lang.String",
				"boolean", "int", "long", "int", "int", "boolean", "boolean",
				"boolean", "long", "boolean", "long[][]", "long[][]", "long",
				"java.lang.String", "boolean", "boolean",
				"it.ethica.esf.model.ESFEntityState",
				"com.liferay.portal.service.ServiceContext", "java.lang.String",
				"java.lang.String", "java.lang.String"
			};

		_methodName332 = "addOrUpdateESFMatch";

		_methodParameterTypes332 = new String[] {
				"long", "long", "long", "java.lang.String", "java.util.Date",
				"java.util.Date", "java.lang.String", "long", "java.lang.String",
				"boolean", "int", "long", "int", "int", "boolean", "boolean",
				"boolean", "long", "boolean", "long[][]", "long[][]", "long",
				"java.lang.String", "boolean", "boolean",
				"it.ethica.esf.model.ESFEntityState",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName333 = "deleteESFMatch";

		_methodParameterTypes333 = new String[] {
				"long", "com.liferay.portal.service.ServiceContext"
			};

		_methodName334 = "findbyeventType";

		_methodParameterTypes334 = new String[] { "java.lang.String" };

		_methodName335 = "findByDescription";

		_methodParameterTypes335 = new String[] { "long" };

		_methodName336 = "findDelegationActiveMatch";

		_methodParameterTypes336 = new String[] { "long" };

		_methodName337 = "findUnfinishedMatch_UserId";

		_methodParameterTypes337 = new String[] { "long" };

		_methodName338 = "getAllEsfMatchByResults";

		_methodParameterTypes338 = new String[] { "java.util.List" };
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

		if (_methodName304.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes304, parameterTypes)) {
			return ESFMatchLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName305.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes305, parameterTypes)) {
			ESFMatchLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName310.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes310, parameterTypes)) {
			return ESFMatchLocalServiceUtil.findESFMatchesByYearIsNational(((Integer)arguments[0]).intValue(),
				((Boolean)arguments[1]).booleanValue());
		}

		if (_methodName311.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes311, parameterTypes)) {
			return ESFMatchLocalServiceUtil.findESFMatchsByStateIsNational_C_S_M_C_O(((Integer)arguments[0]).intValue(),
				((Boolean)arguments[1]).booleanValue(),
				(java.lang.String)arguments[2], (java.util.Date)arguments[3],
				((Long)arguments[4]).longValue(),
				((Long)arguments[5]).longValue(), (java.lang.String)arguments[6]);
		}

		if (_methodName312.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes312, parameterTypes)) {
			return ESFMatchLocalServiceUtil.findESFMatchsByStateIsNational_C_S_M_C_O(((Integer)arguments[0]).intValue(),
				((Boolean)arguments[1]).booleanValue(),
				(java.lang.String)arguments[2], (java.util.Date)arguments[3],
				((Long)arguments[4]).longValue(),
				((Long)arguments[5]).longValue(),
				(java.lang.String)arguments[6],
				((Integer)arguments[7]).intValue(),
				((Integer)arguments[8]).intValue());
		}

		if (_methodName313.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes313, parameterTypes)) {
			return ESFMatchLocalServiceUtil.findESFMatchsByStateIsNational_C_S_M_C_A(((Integer)arguments[0]).intValue(),
				((Boolean)arguments[1]).booleanValue(),
				(java.lang.String)arguments[2], (java.util.Date)arguments[3],
				((Long)arguments[4]).longValue(),
				((Long)arguments[5]).longValue());
		}

		if (_methodName314.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes314, parameterTypes)) {
			return ESFMatchLocalServiceUtil.findESFMatchsByStateIsNational_C_S_M_C_A(((Integer)arguments[0]).intValue(),
				((Boolean)arguments[1]).booleanValue(),
				(java.lang.String)arguments[2], (java.util.Date)arguments[3],
				((Long)arguments[4]).longValue(),
				((Long)arguments[5]).longValue(),
				((Integer)arguments[6]).intValue(),
				((Integer)arguments[7]).intValue());
		}

		if (_methodName315.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes315, parameterTypes)) {
			return ESFMatchLocalServiceUtil.findESFMatchsByStateIsNational_C_S_M_C_I(((Integer)arguments[0]).intValue(),
				((Boolean)arguments[1]).booleanValue(),
				(java.lang.String)arguments[2], (java.util.Date)arguments[3],
				((Long)arguments[4]).longValue(),
				((Long)arguments[5]).longValue());
		}

		if (_methodName316.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes316, parameterTypes)) {
			return ESFMatchLocalServiceUtil.findESFMatchsByStateIsNational_C_S_M_C_I(((Integer)arguments[0]).intValue(),
				((Boolean)arguments[1]).booleanValue(),
				(java.lang.String)arguments[2], (java.util.Date)arguments[3],
				((Long)arguments[4]).longValue(),
				((Long)arguments[5]).longValue(),
				((Integer)arguments[6]).intValue(),
				((Integer)arguments[7]).intValue());
		}

		if (_methodName317.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes317, parameterTypes)) {
			return ESFMatchLocalServiceUtil.findESFMatchsByStateIsNational(((Integer)arguments[0]).intValue(),
				((Boolean)arguments[1]).booleanValue());
		}

		if (_methodName318.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes318, parameterTypes)) {
			return ESFMatchLocalServiceUtil.findESFMatchsByStateIsNational(((Integer)arguments[0]).intValue(),
				((Boolean)arguments[1]).booleanValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName319.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes319, parameterTypes)) {
			return ESFMatchLocalServiceUtil.findESFMatchsByO_S_N(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Boolean)arguments[2]).booleanValue(),
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue());
		}

		if (_methodName320.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes320, parameterTypes)) {
			return ESFMatchLocalServiceUtil.findbyIsChangeCategoryYear(((Boolean)arguments[0]).booleanValue(),
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName321.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes321, parameterTypes)) {
			return ESFMatchLocalServiceUtil.findbyIsChangeCategoryYearDescription(((Boolean)arguments[0]).booleanValue(),
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue(), (java.lang.Long)arguments[3]);
		}

		if (_methodName322.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes322, parameterTypes)) {
			return ESFMatchLocalServiceUtil.getESFMatchesByMatchStartDate_T_A_D_N((java.util.Date)arguments[0],
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue(),
				((Boolean)arguments[4]).booleanValue());
		}

		if (_methodName323.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes323, parameterTypes)) {
			return ESFMatchLocalServiceUtil.findMyMatches(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue(),
				((Long)arguments[2]).longValue(), (java.util.Date)arguments[3],
				((Long)arguments[4]).longValue(),
				((Long)arguments[5]).longValue());
		}

		if (_methodName324.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes324, parameterTypes)) {
			return ESFMatchLocalServiceUtil.findByUI_iN_OI_sD_dId_STId(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue(),
				((Long)arguments[2]).longValue(), (java.util.Date)arguments[3],
				((Long)arguments[4]).longValue(),
				((Long)arguments[5]).longValue(),
				((Integer)arguments[6]).intValue(),
				((Integer)arguments[7]).intValue());
		}

		if (_methodName325.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes325, parameterTypes)) {
			return ESFMatchLocalServiceUtil.findESFMatchsByO_S_N(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Boolean)arguments[2]).booleanValue());
		}

		if (_methodName326.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes326, parameterTypes)) {
			return ESFMatchLocalServiceUtil.findbyUserId_IsNational(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue());
		}

		if (_methodName327.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes327, parameterTypes)) {
			return ESFMatchLocalServiceUtil.findbyIsChangeCategory(((Boolean)arguments[0]).booleanValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName328.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes328, parameterTypes)) {
			return ESFMatchLocalServiceUtil.findbyUserId_IsNational(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName329.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes329, parameterTypes)) {
			return ESFMatchLocalServiceUtil.findbyMatchType(((Long)arguments[0]).longValue());
		}

		if (_methodName330.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes330, parameterTypes)) {
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

		if (_methodName331.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes331, parameterTypes)) {
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

		if (_methodName332.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes332, parameterTypes)) {
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

		if (_methodName333.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes333, parameterTypes)) {
			return ESFMatchLocalServiceUtil.deleteESFMatch(((Long)arguments[0]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[1]);
		}

		if (_methodName334.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes334, parameterTypes)) {
			return ESFMatchLocalServiceUtil.findbyeventType((java.lang.String)arguments[0]);
		}

		if (_methodName335.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes335, parameterTypes)) {
			return ESFMatchLocalServiceUtil.findByDescription(((Long)arguments[0]).longValue());
		}

		if (_methodName336.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes336, parameterTypes)) {
			return ESFMatchLocalServiceUtil.findDelegationActiveMatch(((Long)arguments[0]).longValue());
		}

		if (_methodName337.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes337, parameterTypes)) {
			return ESFMatchLocalServiceUtil.findUnfinishedMatch_UserId(((Long)arguments[0]).longValue());
		}

		if (_methodName338.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes338, parameterTypes)) {
			return ESFMatchLocalServiceUtil.getAllEsfMatchByResults((java.util.List<it.ethica.esf.model.ESFNationalMatchResult>)arguments[0]);
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
	private String _methodName304;
	private String[] _methodParameterTypes304;
	private String _methodName305;
	private String[] _methodParameterTypes305;
	private String _methodName310;
	private String[] _methodParameterTypes310;
	private String _methodName311;
	private String[] _methodParameterTypes311;
	private String _methodName312;
	private String[] _methodParameterTypes312;
	private String _methodName313;
	private String[] _methodParameterTypes313;
	private String _methodName314;
	private String[] _methodParameterTypes314;
	private String _methodName315;
	private String[] _methodParameterTypes315;
	private String _methodName316;
	private String[] _methodParameterTypes316;
	private String _methodName317;
	private String[] _methodParameterTypes317;
	private String _methodName318;
	private String[] _methodParameterTypes318;
	private String _methodName319;
	private String[] _methodParameterTypes319;
	private String _methodName320;
	private String[] _methodParameterTypes320;
	private String _methodName321;
	private String[] _methodParameterTypes321;
	private String _methodName322;
	private String[] _methodParameterTypes322;
	private String _methodName323;
	private String[] _methodParameterTypes323;
	private String _methodName324;
	private String[] _methodParameterTypes324;
	private String _methodName325;
	private String[] _methodParameterTypes325;
	private String _methodName326;
	private String[] _methodParameterTypes326;
	private String _methodName327;
	private String[] _methodParameterTypes327;
	private String _methodName328;
	private String[] _methodParameterTypes328;
	private String _methodName329;
	private String[] _methodParameterTypes329;
	private String _methodName330;
	private String[] _methodParameterTypes330;
	private String _methodName331;
	private String[] _methodParameterTypes331;
	private String _methodName332;
	private String[] _methodParameterTypes332;
	private String _methodName333;
	private String[] _methodParameterTypes333;
	private String _methodName334;
	private String[] _methodParameterTypes334;
	private String _methodName335;
	private String[] _methodParameterTypes335;
	private String _methodName336;
	private String[] _methodParameterTypes336;
	private String _methodName337;
	private String[] _methodParameterTypes337;
	private String _methodName338;
	private String[] _methodParameterTypes338;
}