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

import it.ethica.esf.service.ESFUserRoleLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Ethica
 * @generated
 */
public class ESFUserRoleLocalServiceClpInvoker {
	public ESFUserRoleLocalServiceClpInvoker() {
		_methodName0 = "addESFUserRole";

		_methodParameterTypes0 = new String[] { "it.ethica.esf.model.ESFUserRole" };

		_methodName1 = "createESFUserRole";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteESFUserRole";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteESFUserRole";

		_methodParameterTypes3 = new String[] { "it.ethica.esf.model.ESFUserRole" };

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

		_methodName10 = "fetchESFUserRole";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "fetchESFUserRoleByUuidAndCompanyId";

		_methodParameterTypes11 = new String[] { "java.lang.String", "long" };

		_methodName12 = "fetchESFUserRoleByUuidAndGroupId";

		_methodParameterTypes12 = new String[] { "java.lang.String", "long" };

		_methodName13 = "getESFUserRole";

		_methodParameterTypes13 = new String[] { "long" };

		_methodName14 = "getPersistedModel";

		_methodParameterTypes14 = new String[] { "java.io.Serializable" };

		_methodName15 = "getESFUserRoleByUuidAndCompanyId";

		_methodParameterTypes15 = new String[] { "java.lang.String", "long" };

		_methodName16 = "getESFUserRoleByUuidAndGroupId";

		_methodParameterTypes16 = new String[] { "java.lang.String", "long" };

		_methodName17 = "getESFUserRoles";

		_methodParameterTypes17 = new String[] { "int", "int" };

		_methodName18 = "getESFUserRolesCount";

		_methodParameterTypes18 = new String[] {  };

		_methodName19 = "updateESFUserRole";

		_methodParameterTypes19 = new String[] { "it.ethica.esf.model.ESFUserRole" };

		_methodName448 = "getBeanIdentifier";

		_methodParameterTypes448 = new String[] {  };

		_methodName449 = "setBeanIdentifier";

		_methodParameterTypes449 = new String[] { "java.lang.String" };

		_methodName454 = "getAllEsfUserRole";

		_methodParameterTypes454 = new String[] {  };

		_methodName455 = "getAllEsfUserRole";

		_methodParameterTypes455 = new String[] { "int", "int" };

		_methodName456 = "getAllEsfUserRoleByType";

		_methodParameterTypes456 = new String[] { "int" };

		_methodName457 = "getAllEsfUserRoleByType";

		_methodParameterTypes457 = new String[] { "int", "int", "int" };

		_methodName458 = "getAllEsfUserRoleByStateNoAssign";

		_methodParameterTypes458 = new String[] { "long", "int", "int" };

		_methodName459 = "countAllEsfUserRoleByStateNoAssign";

		_methodParameterTypes459 = new String[] { "long" };

		_methodName460 = "getAllUserRoleByLikeT_N";

		_methodParameterTypes460 = new String[] {
				"java.lang.String", "java.lang.String", "int", "int", "int"
			};

		_methodName461 = "getAllUserRoleByLikeT_N";

		_methodParameterTypes461 = new String[] {
				"java.lang.String", "java.lang.String", "int"
			};

		_methodName462 = "getEsfUserRoleByState";

		_methodParameterTypes462 = new String[] { "int" };

		_methodName463 = "getEsfUserRoleByState";

		_methodParameterTypes463 = new String[] { "int", "int", "int" };

		_methodName464 = "getAllEsfUserRoleByT_S";

		_methodParameterTypes464 = new String[] { "int", "int" };

		_methodName465 = "getAllEsfUserRoleByT_S";

		_methodParameterTypes465 = new String[] { "int", "int", "int", "int" };

		_methodName466 = "getEsfUserRoleByT_S_BDO";

		_methodParameterTypes466 = new String[] { "int", "int", "boolean" };

		_methodName467 = "getEsfUserRoleByT_S_BDO";

		_methodParameterTypes467 = new String[] {
				"int", "int", "boolean", "int", "int"
			};

		_methodName468 = "getEsfUserRoleByT_S_BDO_OrgId";

		_methodParameterTypes468 = new String[] { "int", "int", "boolean", "long" };

		_methodName469 = "getAllEsfUserRoleCount";

		_methodParameterTypes469 = new String[] {  };

		_methodName470 = "addESFUserRole";

		_methodParameterTypes470 = new String[] {
				"long", "long", "long", "java.lang.String", "java.lang.String",
				"java.util.Map", "java.util.Map", "int", "java.lang.String",
				"boolean", "boolean", "boolean", "boolean", "int",
				"it.ethica.esf.model.ESFEntityState"
			};

		_methodName471 = "addESFUserRole";

		_methodParameterTypes471 = new String[] {
				"long", "java.lang.String", "java.lang.String",
				"java.lang.String", "long", "java.util.Map", "java.util.Map",
				"int", "java.lang.String", "boolean", "boolean", "boolean",
				"boolean", "int", "it.ethica.esf.model.ESFEntityState",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName472 = "deleteESFUserRole";

		_methodParameterTypes472 = new String[] {
				"long", "com.liferay.portal.service.ServiceContext"
			};

		_methodName473 = "updateESFUserRole";

		_methodParameterTypes473 = new String[] {
				"long", "long", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.util.Map", "java.util.Map", "int",
				"java.lang.String", "boolean", "boolean", "boolean", "boolean",
				"int", "com.liferay.portal.service.ServiceContext"
			};

		_methodName474 = "checkNome";

		_methodParameterTypes474 = new String[] {
				"java.lang.String", "com.liferay.portal.service.ServiceContext"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return ESFUserRoleLocalServiceUtil.addESFUserRole((it.ethica.esf.model.ESFUserRole)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return ESFUserRoleLocalServiceUtil.createESFUserRole(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return ESFUserRoleLocalServiceUtil.deleteESFUserRole(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return ESFUserRoleLocalServiceUtil.deleteESFUserRole((it.ethica.esf.model.ESFUserRole)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return ESFUserRoleLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return ESFUserRoleLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return ESFUserRoleLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return ESFUserRoleLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return ESFUserRoleLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return ESFUserRoleLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return ESFUserRoleLocalServiceUtil.fetchESFUserRole(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return ESFUserRoleLocalServiceUtil.fetchESFUserRoleByUuidAndCompanyId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return ESFUserRoleLocalServiceUtil.fetchESFUserRoleByUuidAndGroupId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return ESFUserRoleLocalServiceUtil.getESFUserRole(((Long)arguments[0]).longValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return ESFUserRoleLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return ESFUserRoleLocalServiceUtil.getESFUserRoleByUuidAndCompanyId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName16.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes16, parameterTypes)) {
			return ESFUserRoleLocalServiceUtil.getESFUserRoleByUuidAndGroupId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName17.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes17, parameterTypes)) {
			return ESFUserRoleLocalServiceUtil.getESFUserRoles(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName18.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes18, parameterTypes)) {
			return ESFUserRoleLocalServiceUtil.getESFUserRolesCount();
		}

		if (_methodName19.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes19, parameterTypes)) {
			return ESFUserRoleLocalServiceUtil.updateESFUserRole((it.ethica.esf.model.ESFUserRole)arguments[0]);
		}

		if (_methodName448.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes448, parameterTypes)) {
			return ESFUserRoleLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName449.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes449, parameterTypes)) {
			ESFUserRoleLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName454.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes454, parameterTypes)) {
			return ESFUserRoleLocalServiceUtil.getAllEsfUserRole();
		}

		if (_methodName455.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes455, parameterTypes)) {
			return ESFUserRoleLocalServiceUtil.getAllEsfUserRole(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName456.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes456, parameterTypes)) {
			return ESFUserRoleLocalServiceUtil.getAllEsfUserRoleByType(((Integer)arguments[0]).intValue());
		}

		if (_methodName457.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes457, parameterTypes)) {
			return ESFUserRoleLocalServiceUtil.getAllEsfUserRoleByType(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName458.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes458, parameterTypes)) {
			return ESFUserRoleLocalServiceUtil.getAllEsfUserRoleByStateNoAssign(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName459.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes459, parameterTypes)) {
			return ESFUserRoleLocalServiceUtil.countAllEsfUserRoleByStateNoAssign(((Long)arguments[0]).longValue());
		}

		if (_methodName460.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes460, parameterTypes)) {
			return ESFUserRoleLocalServiceUtil.getAllUserRoleByLikeT_N((java.lang.String)arguments[0],
				(java.lang.String)arguments[1],
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue());
		}

		if (_methodName461.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes461, parameterTypes)) {
			return ESFUserRoleLocalServiceUtil.getAllUserRoleByLikeT_N((java.lang.String)arguments[0],
				(java.lang.String)arguments[1],
				((Integer)arguments[2]).intValue());
		}

		if (_methodName462.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes462, parameterTypes)) {
			return ESFUserRoleLocalServiceUtil.getEsfUserRoleByState(((Integer)arguments[0]).intValue());
		}

		if (_methodName463.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes463, parameterTypes)) {
			return ESFUserRoleLocalServiceUtil.getEsfUserRoleByState(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName464.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes464, parameterTypes)) {
			return ESFUserRoleLocalServiceUtil.getAllEsfUserRoleByT_S(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName465.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes465, parameterTypes)) {
			return ESFUserRoleLocalServiceUtil.getAllEsfUserRoleByT_S(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName466.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes466, parameterTypes)) {
			return ESFUserRoleLocalServiceUtil.getEsfUserRoleByT_S_BDO(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue(),
				((Boolean)arguments[2]).booleanValue());
		}

		if (_methodName467.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes467, parameterTypes)) {
			return ESFUserRoleLocalServiceUtil.getEsfUserRoleByT_S_BDO(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue(),
				((Boolean)arguments[2]).booleanValue(),
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue());
		}

		if (_methodName468.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes468, parameterTypes)) {
			return ESFUserRoleLocalServiceUtil.getEsfUserRoleByT_S_BDO_OrgId(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue(),
				((Boolean)arguments[2]).booleanValue(),
				((Long)arguments[3]).longValue());
		}

		if (_methodName469.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes469, parameterTypes)) {
			return ESFUserRoleLocalServiceUtil.getAllEsfUserRoleCount();
		}

		if (_methodName470.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes470, parameterTypes)) {
			return ESFUserRoleLocalServiceUtil.addESFUserRole(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				(java.lang.String)arguments[3], (java.lang.String)arguments[4],
				(java.util.Map<java.util.Locale, java.lang.String>)arguments[5],
				(java.util.Map<java.util.Locale, java.lang.String>)arguments[6],
				((Integer)arguments[7]).intValue(),
				(java.lang.String)arguments[8],
				((Boolean)arguments[9]).booleanValue(),
				((Boolean)arguments[10]).booleanValue(),
				((Boolean)arguments[11]).booleanValue(),
				((Boolean)arguments[12]).booleanValue(),
				((Integer)arguments[13]).intValue(),
				(it.ethica.esf.model.ESFEntityState)arguments[14]);
		}

		if (_methodName471.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes471, parameterTypes)) {
			return ESFUserRoleLocalServiceUtil.addESFUserRole(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3],
				((Long)arguments[4]).longValue(),
				(java.util.Map<java.util.Locale, java.lang.String>)arguments[5],
				(java.util.Map<java.util.Locale, java.lang.String>)arguments[6],
				((Integer)arguments[7]).intValue(),
				(java.lang.String)arguments[8],
				((Boolean)arguments[9]).booleanValue(),
				((Boolean)arguments[10]).booleanValue(),
				((Boolean)arguments[11]).booleanValue(),
				((Boolean)arguments[12]).booleanValue(),
				((Integer)arguments[13]).intValue(),
				(it.ethica.esf.model.ESFEntityState)arguments[14],
				(com.liferay.portal.service.ServiceContext)arguments[15]);
		}

		if (_methodName472.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes472, parameterTypes)) {
			return ESFUserRoleLocalServiceUtil.deleteESFUserRole(((Long)arguments[0]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[1]);
		}

		if (_methodName473.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes473, parameterTypes)) {
			return ESFUserRoleLocalServiceUtil.updateESFUserRole(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3],
				(java.lang.String)arguments[4],
				(java.util.Map<java.util.Locale, java.lang.String>)arguments[5],
				(java.util.Map<java.util.Locale, java.lang.String>)arguments[6],
				((Integer)arguments[7]).intValue(),
				(java.lang.String)arguments[8],
				((Boolean)arguments[9]).booleanValue(),
				((Boolean)arguments[10]).booleanValue(),
				((Boolean)arguments[11]).booleanValue(),
				((Boolean)arguments[12]).booleanValue(),
				((Integer)arguments[13]).intValue(),
				(com.liferay.portal.service.ServiceContext)arguments[14]);
		}

		if (_methodName474.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes474, parameterTypes)) {
			return ESFUserRoleLocalServiceUtil.checkNome((java.lang.String)arguments[0],
				(com.liferay.portal.service.ServiceContext)arguments[1]);
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
	private String _methodName448;
	private String[] _methodParameterTypes448;
	private String _methodName449;
	private String[] _methodParameterTypes449;
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
}