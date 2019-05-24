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

import it.ethica.esf.service.ESFUserESFUserRoleLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Ethica
 * @generated
 */
public class ESFUserESFUserRoleLocalServiceClpInvoker {
	public ESFUserESFUserRoleLocalServiceClpInvoker() {
		_methodName0 = "addESFUserESFUserRole";

		_methodParameterTypes0 = new String[] {
				"it.ethica.esf.model.ESFUserESFUserRole"
			};

		_methodName1 = "createESFUserESFUserRole";

		_methodParameterTypes1 = new String[] {
				"it.ethica.esf.service.persistence.ESFUserESFUserRolePK"
			};

		_methodName2 = "deleteESFUserESFUserRole";

		_methodParameterTypes2 = new String[] {
				"it.ethica.esf.service.persistence.ESFUserESFUserRolePK"
			};

		_methodName3 = "deleteESFUserESFUserRole";

		_methodParameterTypes3 = new String[] {
				"it.ethica.esf.model.ESFUserESFUserRole"
			};

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

		_methodName10 = "fetchESFUserESFUserRole";

		_methodParameterTypes10 = new String[] {
				"it.ethica.esf.service.persistence.ESFUserESFUserRolePK"
			};

		_methodName11 = "getESFUserESFUserRole";

		_methodParameterTypes11 = new String[] {
				"it.ethica.esf.service.persistence.ESFUserESFUserRolePK"
			};

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getESFUserESFUserRoles";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getESFUserESFUserRolesCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateESFUserESFUserRole";

		_methodParameterTypes15 = new String[] {
				"it.ethica.esf.model.ESFUserESFUserRole"
			};

		_methodName384 = "getBeanIdentifier";

		_methodParameterTypes384 = new String[] {  };

		_methodName385 = "setBeanIdentifier";

		_methodParameterTypes385 = new String[] { "java.lang.String" };

		_methodName390 = "findESFUserESFRolesByEsfUserRoleId";

		_methodParameterTypes390 = new String[] { "long" };

		_methodName391 = "findESFUserESFRolesByEsfOrganizzationId";

		_methodParameterTypes391 = new String[] { "long" };

		_methodName392 = "findESFUserESFRolesAll";

		_methodParameterTypes392 = new String[] {  };

		_methodName393 = "findESFUserESFRoleByPrimaryKey";

		_methodParameterTypes393 = new String[] {
				"long", "long", "long", "java.util.Date"
			};

		_methodName394 = "findESFUserESFRoleByU_R_O";

		_methodParameterTypes394 = new String[] { "long", "long", "long" };

		_methodName395 = "findESFUserESFRoleByO_R";

		_methodParameterTypes395 = new String[] { "long", "long" };

		_methodName396 = "getAllESFUserESFUserRoleByESFUserId";

		_methodParameterTypes396 = new String[] { "long", "int", "int" };

		_methodName397 = "getESFUserESFUserRoleByESFUserId_ED";

		_methodParameterTypes397 = new String[] { "long" };

		_methodName398 = "getESFUserESFUserRoleByOrganizationId";

		_methodParameterTypes398 = new String[] { "long" };

		_methodName399 = "getESFUserESFUserRoleByOrganizationId";

		_methodParameterTypes399 = new String[] { "long", "int", "int" };

		_methodName400 = "getESFUserESFUserRoleAllStaff";

		_methodParameterTypes400 = new String[] { "long" };

		_methodName401 = "getESFUserESFUserRoleAllStaff";

		_methodParameterTypes401 = new String[] { "long", "int", "int" };

		_methodName402 = "getESFUserESFUserRoleAllNationalStaff";

		_methodParameterTypes402 = new String[] { "long", "int", "int" };

		_methodName403 = "getESFUserESFUserRoleAllNationalStaff";

		_methodParameterTypes403 = new String[] { "long" };

		_methodName404 = "getESFUserESFUserRoleStaff";

		_methodParameterTypes404 = new String[] { "long", "int", "int" };

		_methodName405 = "getESFUserESFUserRoleStaff";

		_methodParameterTypes405 = new String[] { "long" };

		_methodName406 = "getAllESFUserESFUserRoleCountByESFUserId";

		_methodParameterTypes406 = new String[] { "long" };

		_methodName407 = "addESFUserESFRole";

		_methodParameterTypes407 = new String[] {
				"long", "long", "long", "java.util.Date"
			};

		_methodName408 = "addESFUserESFRoleMigr";

		_methodParameterTypes408 = new String[] {
				"long", "long", "long", "java.util.Date", "java.util.Date"
			};

		_methodName409 = "updateESFUserESFRole";

		_methodParameterTypes409 = new String[] {
				"long", "long", "long", "java.util.Date",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName410 = "getESFUSerRoleByR_ED";

		_methodParameterTypes410 = new String[] { "long" };

		_methodName411 = "findbyBDOUserRolenoEnd";

		_methodParameterTypes411 = new String[] { "long", "long" };

		_methodName412 = "findbyBDORole";

		_methodParameterTypes412 = new String[] { "long" };

		_methodName413 = "findStaffRole";

		_methodParameterTypes413 = new String[] { "long" };

		_methodName414 = "findESFUserESFRoleByO_R_D_NOL";

		_methodParameterTypes414 = new String[] { "long", "long", "java.sql.Date" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return ESFUserESFUserRoleLocalServiceUtil.addESFUserESFUserRole((it.ethica.esf.model.ESFUserESFUserRole)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return ESFUserESFUserRoleLocalServiceUtil.createESFUserESFUserRole((it.ethica.esf.service.persistence.ESFUserESFUserRolePK)arguments[0]);
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return ESFUserESFUserRoleLocalServiceUtil.deleteESFUserESFUserRole((it.ethica.esf.service.persistence.ESFUserESFUserRolePK)arguments[0]);
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return ESFUserESFUserRoleLocalServiceUtil.deleteESFUserESFUserRole((it.ethica.esf.model.ESFUserESFUserRole)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return ESFUserESFUserRoleLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return ESFUserESFUserRoleLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return ESFUserESFUserRoleLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return ESFUserESFUserRoleLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return ESFUserESFUserRoleLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return ESFUserESFUserRoleLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return ESFUserESFUserRoleLocalServiceUtil.fetchESFUserESFUserRole((it.ethica.esf.service.persistence.ESFUserESFUserRolePK)arguments[0]);
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return ESFUserESFUserRoleLocalServiceUtil.getESFUserESFUserRole((it.ethica.esf.service.persistence.ESFUserESFUserRolePK)arguments[0]);
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return ESFUserESFUserRoleLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return ESFUserESFUserRoleLocalServiceUtil.getESFUserESFUserRoles(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return ESFUserESFUserRoleLocalServiceUtil.getESFUserESFUserRolesCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return ESFUserESFUserRoleLocalServiceUtil.updateESFUserESFUserRole((it.ethica.esf.model.ESFUserESFUserRole)arguments[0]);
		}

		if (_methodName384.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes384, parameterTypes)) {
			return ESFUserESFUserRoleLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName385.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes385, parameterTypes)) {
			ESFUserESFUserRoleLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName390.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes390, parameterTypes)) {
			return ESFUserESFUserRoleLocalServiceUtil.findESFUserESFRolesByEsfUserRoleId(((Long)arguments[0]).longValue());
		}

		if (_methodName391.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes391, parameterTypes)) {
			return ESFUserESFUserRoleLocalServiceUtil.findESFUserESFRolesByEsfOrganizzationId(((Long)arguments[0]).longValue());
		}

		if (_methodName392.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes392, parameterTypes)) {
			return ESFUserESFUserRoleLocalServiceUtil.findESFUserESFRolesAll();
		}

		if (_methodName393.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes393, parameterTypes)) {
			return ESFUserESFUserRoleLocalServiceUtil.findESFUserESFRoleByPrimaryKey(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(), (java.util.Date)arguments[3]);
		}

		if (_methodName394.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes394, parameterTypes)) {
			return ESFUserESFUserRoleLocalServiceUtil.findESFUserESFRoleByU_R_O(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue());
		}

		if (_methodName395.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes395, parameterTypes)) {
			return ESFUserESFUserRoleLocalServiceUtil.findESFUserESFRoleByO_R(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName396.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes396, parameterTypes)) {
			return ESFUserESFUserRoleLocalServiceUtil.getAllESFUserESFUserRoleByESFUserId(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName397.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes397, parameterTypes)) {
			return ESFUserESFUserRoleLocalServiceUtil.getESFUserESFUserRoleByESFUserId_ED(((Long)arguments[0]).longValue());
		}

		if (_methodName398.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes398, parameterTypes)) {
			return ESFUserESFUserRoleLocalServiceUtil.getESFUserESFUserRoleByOrganizationId(((Long)arguments[0]).longValue());
		}

		if (_methodName399.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes399, parameterTypes)) {
			return ESFUserESFUserRoleLocalServiceUtil.getESFUserESFUserRoleByOrganizationId(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName400.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes400, parameterTypes)) {
			return ESFUserESFUserRoleLocalServiceUtil.getESFUserESFUserRoleAllStaff(((Long)arguments[0]).longValue());
		}

		if (_methodName401.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes401, parameterTypes)) {
			return ESFUserESFUserRoleLocalServiceUtil.getESFUserESFUserRoleAllStaff(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName402.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes402, parameterTypes)) {
			return ESFUserESFUserRoleLocalServiceUtil.getESFUserESFUserRoleAllNationalStaff(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName403.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes403, parameterTypes)) {
			return ESFUserESFUserRoleLocalServiceUtil.getESFUserESFUserRoleAllNationalStaff(((Long)arguments[0]).longValue());
		}

		if (_methodName404.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes404, parameterTypes)) {
			return ESFUserESFUserRoleLocalServiceUtil.getESFUserESFUserRoleStaff(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName405.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes405, parameterTypes)) {
			return ESFUserESFUserRoleLocalServiceUtil.getESFUserESFUserRoleStaff(((Long)arguments[0]).longValue());
		}

		if (_methodName406.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes406, parameterTypes)) {
			return ESFUserESFUserRoleLocalServiceUtil.getAllESFUserESFUserRoleCountByESFUserId(((Long)arguments[0]).longValue());
		}

		if (_methodName407.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes407, parameterTypes)) {
			return ESFUserESFUserRoleLocalServiceUtil.addESFUserESFRole(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(), (java.util.Date)arguments[3]);
		}

		if (_methodName408.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes408, parameterTypes)) {
			return ESFUserESFUserRoleLocalServiceUtil.addESFUserESFRoleMigr(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(), (java.util.Date)arguments[3],
				(java.util.Date)arguments[4]);
		}

		if (_methodName409.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes409, parameterTypes)) {
			return ESFUserESFUserRoleLocalServiceUtil.updateESFUserESFRole(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(), (java.util.Date)arguments[3],
				(com.liferay.portal.service.ServiceContext)arguments[4]);
		}

		if (_methodName410.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes410, parameterTypes)) {
			return ESFUserESFUserRoleLocalServiceUtil.getESFUSerRoleByR_ED(((Long)arguments[0]).longValue());
		}

		if (_methodName411.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes411, parameterTypes)) {
			return ESFUserESFUserRoleLocalServiceUtil.findbyBDOUserRolenoEnd(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName412.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes412, parameterTypes)) {
			return ESFUserESFUserRoleLocalServiceUtil.findbyBDORole(((Long)arguments[0]).longValue());
		}

		if (_methodName413.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes413, parameterTypes)) {
			return ESFUserESFUserRoleLocalServiceUtil.findStaffRole(((Long)arguments[0]).longValue());
		}

		if (_methodName414.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes414, parameterTypes)) {
			return ESFUserESFUserRoleLocalServiceUtil.findESFUserESFRoleByO_R_D_NOL(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(), (java.sql.Date)arguments[2]);
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
	private String _methodName384;
	private String[] _methodParameterTypes384;
	private String _methodName385;
	private String[] _methodParameterTypes385;
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
}