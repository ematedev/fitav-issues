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

		_methodName424 = "getBeanIdentifier";

		_methodParameterTypes424 = new String[] {  };

		_methodName425 = "setBeanIdentifier";

		_methodParameterTypes425 = new String[] { "java.lang.String" };

		_methodName430 = "findESFUserESFRolesByEsfUserRoleId";

		_methodParameterTypes430 = new String[] { "long" };

		_methodName431 = "findESFUserESFRolesByEsfOrganizzationId";

		_methodParameterTypes431 = new String[] { "long" };

		_methodName432 = "findESFUserESFRolesAll";

		_methodParameterTypes432 = new String[] {  };

		_methodName433 = "findESFUserESFRoleByPrimaryKey";

		_methodParameterTypes433 = new String[] {
				"long", "long", "long", "java.util.Date"
			};

		_methodName434 = "findESFUserESFRoleByU_R_O";

		_methodParameterTypes434 = new String[] { "long", "long", "long" };

		_methodName435 = "findESFUserESFRoleByO_R";

		_methodParameterTypes435 = new String[] { "long", "long" };

		_methodName436 = "getAllESFUserESFUserRoleByESFUserId";

		_methodParameterTypes436 = new String[] { "long", "int", "int" };

		_methodName437 = "getESFUserESFUserRoleByESFUserId_ED";

		_methodParameterTypes437 = new String[] { "long" };

		_methodName438 = "getESFUserESFUserRoleByOrganizationId";

		_methodParameterTypes438 = new String[] { "long" };

		_methodName439 = "getESFUserESFUserRoleByOrganizationId";

		_methodParameterTypes439 = new String[] { "long", "int", "int" };

		_methodName440 = "getESFUserESFUserRoleAllStaff";

		_methodParameterTypes440 = new String[] { "long" };

		_methodName441 = "getESFUserESFUserRoleAllStaff";

		_methodParameterTypes441 = new String[] { "long", "int", "int" };

		_methodName442 = "getESFUserESFUserRoleAllNationalStaff";

		_methodParameterTypes442 = new String[] { "long", "int", "int" };

		_methodName443 = "getESFUserESFUserRoleAllNationalStaff";

		_methodParameterTypes443 = new String[] { "long" };

		_methodName444 = "getESFUserESFUserRoleStaff";

		_methodParameterTypes444 = new String[] { "long", "int", "int" };

		_methodName445 = "getESFUserESFUserRoleStaff";

		_methodParameterTypes445 = new String[] { "long" };

		_methodName446 = "getAllESFUserESFUserRoleCountByESFUserId";

		_methodParameterTypes446 = new String[] { "long" };

		_methodName447 = "addESFUserESFRole";

		_methodParameterTypes447 = new String[] {
				"long", "long", "long", "java.util.Date"
			};

		_methodName448 = "addESFUserESFRoleMigr";

		_methodParameterTypes448 = new String[] {
				"long", "long", "long", "java.util.Date", "java.util.Date"
			};

		_methodName449 = "updateESFUserESFRole";

		_methodParameterTypes449 = new String[] {
				"long", "long", "long", "java.util.Date",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName450 = "getESFUSerRoleByR_ED";

		_methodParameterTypes450 = new String[] { "long" };

		_methodName451 = "findbyBDOUserRolenoEnd";

		_methodParameterTypes451 = new String[] { "long", "long" };

		_methodName452 = "findbyBDORole";

		_methodParameterTypes452 = new String[] { "long" };

		_methodName453 = "findStaffRole";

		_methodParameterTypes453 = new String[] { "long" };

		_methodName454 = "findESFUserESFRoleByO_R_D_NOL";

		_methodParameterTypes454 = new String[] { "long", "long", "java.sql.Date" };
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

		if (_methodName424.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes424, parameterTypes)) {
			return ESFUserESFUserRoleLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName425.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes425, parameterTypes)) {
			ESFUserESFUserRoleLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName430.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes430, parameterTypes)) {
			return ESFUserESFUserRoleLocalServiceUtil.findESFUserESFRolesByEsfUserRoleId(((Long)arguments[0]).longValue());
		}

		if (_methodName431.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes431, parameterTypes)) {
			return ESFUserESFUserRoleLocalServiceUtil.findESFUserESFRolesByEsfOrganizzationId(((Long)arguments[0]).longValue());
		}

		if (_methodName432.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes432, parameterTypes)) {
			return ESFUserESFUserRoleLocalServiceUtil.findESFUserESFRolesAll();
		}

		if (_methodName433.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes433, parameterTypes)) {
			return ESFUserESFUserRoleLocalServiceUtil.findESFUserESFRoleByPrimaryKey(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(), (java.util.Date)arguments[3]);
		}

		if (_methodName434.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes434, parameterTypes)) {
			return ESFUserESFUserRoleLocalServiceUtil.findESFUserESFRoleByU_R_O(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue());
		}

		if (_methodName435.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes435, parameterTypes)) {
			return ESFUserESFUserRoleLocalServiceUtil.findESFUserESFRoleByO_R(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName436.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes436, parameterTypes)) {
			return ESFUserESFUserRoleLocalServiceUtil.getAllESFUserESFUserRoleByESFUserId(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName437.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes437, parameterTypes)) {
			return ESFUserESFUserRoleLocalServiceUtil.getESFUserESFUserRoleByESFUserId_ED(((Long)arguments[0]).longValue());
		}

		if (_methodName438.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes438, parameterTypes)) {
			return ESFUserESFUserRoleLocalServiceUtil.getESFUserESFUserRoleByOrganizationId(((Long)arguments[0]).longValue());
		}

		if (_methodName439.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes439, parameterTypes)) {
			return ESFUserESFUserRoleLocalServiceUtil.getESFUserESFUserRoleByOrganizationId(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName440.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes440, parameterTypes)) {
			return ESFUserESFUserRoleLocalServiceUtil.getESFUserESFUserRoleAllStaff(((Long)arguments[0]).longValue());
		}

		if (_methodName441.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes441, parameterTypes)) {
			return ESFUserESFUserRoleLocalServiceUtil.getESFUserESFUserRoleAllStaff(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName442.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes442, parameterTypes)) {
			return ESFUserESFUserRoleLocalServiceUtil.getESFUserESFUserRoleAllNationalStaff(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName443.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes443, parameterTypes)) {
			return ESFUserESFUserRoleLocalServiceUtil.getESFUserESFUserRoleAllNationalStaff(((Long)arguments[0]).longValue());
		}

		if (_methodName444.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes444, parameterTypes)) {
			return ESFUserESFUserRoleLocalServiceUtil.getESFUserESFUserRoleStaff(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName445.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes445, parameterTypes)) {
			return ESFUserESFUserRoleLocalServiceUtil.getESFUserESFUserRoleStaff(((Long)arguments[0]).longValue());
		}

		if (_methodName446.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes446, parameterTypes)) {
			return ESFUserESFUserRoleLocalServiceUtil.getAllESFUserESFUserRoleCountByESFUserId(((Long)arguments[0]).longValue());
		}

		if (_methodName447.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes447, parameterTypes)) {
			return ESFUserESFUserRoleLocalServiceUtil.addESFUserESFRole(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(), (java.util.Date)arguments[3]);
		}

		if (_methodName448.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes448, parameterTypes)) {
			return ESFUserESFUserRoleLocalServiceUtil.addESFUserESFRoleMigr(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(), (java.util.Date)arguments[3],
				(java.util.Date)arguments[4]);
		}

		if (_methodName449.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes449, parameterTypes)) {
			return ESFUserESFUserRoleLocalServiceUtil.updateESFUserESFRole(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(), (java.util.Date)arguments[3],
				(com.liferay.portal.service.ServiceContext)arguments[4]);
		}

		if (_methodName450.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes450, parameterTypes)) {
			return ESFUserESFUserRoleLocalServiceUtil.getESFUSerRoleByR_ED(((Long)arguments[0]).longValue());
		}

		if (_methodName451.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes451, parameterTypes)) {
			return ESFUserESFUserRoleLocalServiceUtil.findbyBDOUserRolenoEnd(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName452.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes452, parameterTypes)) {
			return ESFUserESFUserRoleLocalServiceUtil.findbyBDORole(((Long)arguments[0]).longValue());
		}

		if (_methodName453.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes453, parameterTypes)) {
			return ESFUserESFUserRoleLocalServiceUtil.findStaffRole(((Long)arguments[0]).longValue());
		}

		if (_methodName454.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes454, parameterTypes)) {
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
	private String _methodName424;
	private String[] _methodParameterTypes424;
	private String _methodName425;
	private String[] _methodParameterTypes425;
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
}