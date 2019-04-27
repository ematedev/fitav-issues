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

		_methodName380 = "getBeanIdentifier";

		_methodParameterTypes380 = new String[] {  };

		_methodName381 = "setBeanIdentifier";

		_methodParameterTypes381 = new String[] { "java.lang.String" };

		_methodName386 = "getAllEsfUserRole";

		_methodParameterTypes386 = new String[] {  };

		_methodName387 = "getAllEsfUserRole";

		_methodParameterTypes387 = new String[] { "int", "int" };

		_methodName388 = "getAllEsfUserRoleByType";

		_methodParameterTypes388 = new String[] { "int" };

		_methodName389 = "getAllEsfUserRoleByType";

		_methodParameterTypes389 = new String[] { "int", "int", "int" };

		_methodName390 = "getAllEsfUserRoleByStateNoAssign";

		_methodParameterTypes390 = new String[] { "long", "int", "int" };

		_methodName391 = "countAllEsfUserRoleByStateNoAssign";

		_methodParameterTypes391 = new String[] { "long" };

		_methodName392 = "getAllUserRoleByLikeT_N";

		_methodParameterTypes392 = new String[] {
				"java.lang.String", "java.lang.String", "int", "int", "int"
			};

		_methodName393 = "getAllUserRoleByLikeT_N";

		_methodParameterTypes393 = new String[] {
				"java.lang.String", "java.lang.String", "int"
			};

		_methodName394 = "getEsfUserRoleByState";

		_methodParameterTypes394 = new String[] { "int" };

		_methodName395 = "getEsfUserRoleByState";

		_methodParameterTypes395 = new String[] { "int", "int", "int" };

		_methodName396 = "getAllEsfUserRoleByT_S";

		_methodParameterTypes396 = new String[] { "int", "int" };

		_methodName397 = "getAllEsfUserRoleByT_S";

		_methodParameterTypes397 = new String[] { "int", "int", "int", "int" };

		_methodName398 = "getEsfUserRoleByT_S_BDO";

		_methodParameterTypes398 = new String[] { "int", "int", "boolean" };

		_methodName399 = "getEsfUserRoleByT_S_BDO";

		_methodParameterTypes399 = new String[] {
				"int", "int", "boolean", "int", "int"
			};

		_methodName400 = "getEsfUserRoleByT_S_BDO_OrgId";

		_methodParameterTypes400 = new String[] { "int", "int", "boolean", "long" };

		_methodName401 = "getAllEsfUserRoleCount";

		_methodParameterTypes401 = new String[] {  };

		_methodName402 = "addESFUserRole";

		_methodParameterTypes402 = new String[] {
				"long", "long", "long", "java.lang.String", "java.lang.String",
				"java.util.Map", "java.util.Map", "int", "java.lang.String",
				"boolean", "boolean", "boolean", "boolean", "int",
				"it.ethica.esf.model.ESFEntityState"
			};

		_methodName403 = "addESFUserRole";

		_methodParameterTypes403 = new String[] {
				"long", "java.lang.String", "java.lang.String",
				"java.lang.String", "long", "java.util.Map", "java.util.Map",
				"int", "java.lang.String", "boolean", "boolean", "boolean",
				"boolean", "int", "it.ethica.esf.model.ESFEntityState",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName404 = "deleteESFUserRole";

		_methodParameterTypes404 = new String[] {
				"long", "com.liferay.portal.service.ServiceContext"
			};

		_methodName405 = "updateESFUserRole";

		_methodParameterTypes405 = new String[] {
				"long", "long", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.util.Map", "java.util.Map", "int",
				"java.lang.String", "boolean", "boolean", "boolean", "boolean",
				"int", "com.liferay.portal.service.ServiceContext"
			};

		_methodName406 = "checkNome";

		_methodParameterTypes406 = new String[] {
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

		if (_methodName380.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes380, parameterTypes)) {
			return ESFUserRoleLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName381.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes381, parameterTypes)) {
			ESFUserRoleLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName386.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes386, parameterTypes)) {
			return ESFUserRoleLocalServiceUtil.getAllEsfUserRole();
		}

		if (_methodName387.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes387, parameterTypes)) {
			return ESFUserRoleLocalServiceUtil.getAllEsfUserRole(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName388.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes388, parameterTypes)) {
			return ESFUserRoleLocalServiceUtil.getAllEsfUserRoleByType(((Integer)arguments[0]).intValue());
		}

		if (_methodName389.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes389, parameterTypes)) {
			return ESFUserRoleLocalServiceUtil.getAllEsfUserRoleByType(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName390.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes390, parameterTypes)) {
			return ESFUserRoleLocalServiceUtil.getAllEsfUserRoleByStateNoAssign(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName391.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes391, parameterTypes)) {
			return ESFUserRoleLocalServiceUtil.countAllEsfUserRoleByStateNoAssign(((Long)arguments[0]).longValue());
		}

		if (_methodName392.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes392, parameterTypes)) {
			return ESFUserRoleLocalServiceUtil.getAllUserRoleByLikeT_N((java.lang.String)arguments[0],
				(java.lang.String)arguments[1],
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue());
		}

		if (_methodName393.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes393, parameterTypes)) {
			return ESFUserRoleLocalServiceUtil.getAllUserRoleByLikeT_N((java.lang.String)arguments[0],
				(java.lang.String)arguments[1],
				((Integer)arguments[2]).intValue());
		}

		if (_methodName394.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes394, parameterTypes)) {
			return ESFUserRoleLocalServiceUtil.getEsfUserRoleByState(((Integer)arguments[0]).intValue());
		}

		if (_methodName395.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes395, parameterTypes)) {
			return ESFUserRoleLocalServiceUtil.getEsfUserRoleByState(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName396.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes396, parameterTypes)) {
			return ESFUserRoleLocalServiceUtil.getAllEsfUserRoleByT_S(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName397.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes397, parameterTypes)) {
			return ESFUserRoleLocalServiceUtil.getAllEsfUserRoleByT_S(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName398.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes398, parameterTypes)) {
			return ESFUserRoleLocalServiceUtil.getEsfUserRoleByT_S_BDO(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue(),
				((Boolean)arguments[2]).booleanValue());
		}

		if (_methodName399.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes399, parameterTypes)) {
			return ESFUserRoleLocalServiceUtil.getEsfUserRoleByT_S_BDO(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue(),
				((Boolean)arguments[2]).booleanValue(),
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue());
		}

		if (_methodName400.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes400, parameterTypes)) {
			return ESFUserRoleLocalServiceUtil.getEsfUserRoleByT_S_BDO_OrgId(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue(),
				((Boolean)arguments[2]).booleanValue(),
				((Long)arguments[3]).longValue());
		}

		if (_methodName401.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes401, parameterTypes)) {
			return ESFUserRoleLocalServiceUtil.getAllEsfUserRoleCount();
		}

		if (_methodName402.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes402, parameterTypes)) {
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

		if (_methodName403.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes403, parameterTypes)) {
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

		if (_methodName404.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes404, parameterTypes)) {
			return ESFUserRoleLocalServiceUtil.deleteESFUserRole(((Long)arguments[0]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[1]);
		}

		if (_methodName405.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes405, parameterTypes)) {
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

		if (_methodName406.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes406, parameterTypes)) {
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
	private String _methodName380;
	private String[] _methodParameterTypes380;
	private String _methodName381;
	private String[] _methodParameterTypes381;
	private String _methodName386;
	private String[] _methodParameterTypes386;
	private String _methodName387;
	private String[] _methodParameterTypes387;
	private String _methodName388;
	private String[] _methodParameterTypes388;
	private String _methodName389;
	private String[] _methodParameterTypes389;
	private String _methodName390;
	private String[] _methodParameterTypes390;
	private String _methodName391;
	private String[] _methodParameterTypes391;
	private String _methodName392;
	private String[] _methodParameterTypes392;
	private String _methodName393;
	private String[] _methodParameterTypes393;
	private String _methodName394;
	private String[] _methodParameterTypes394;
	private String _methodName395;
	private String[] _methodParameterTypes395;
	private String _methodName396;
	private String[] _methodParameterTypes396;
	private String _methodName397;
	private String[] _methodParameterTypes397;
	private String _methodName398;
	private String[] _methodParameterTypes398;
	private String _methodName399;
	private String[] _methodParameterTypes399;
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
}