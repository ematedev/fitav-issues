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

import it.ethica.esf.service.EsfRadunoShootersLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Ethica
 * @generated
 */
public class EsfRadunoShootersLocalServiceClpInvoker {
	public EsfRadunoShootersLocalServiceClpInvoker() {
		_methodName0 = "addEsfRadunoShooters";

		_methodParameterTypes0 = new String[] {
				"it.ethica.esf.model.EsfRadunoShooters"
			};

		_methodName1 = "createEsfRadunoShooters";

		_methodParameterTypes1 = new String[] {
				"it.ethica.esf.service.persistence.EsfRadunoShootersPK"
			};

		_methodName2 = "deleteEsfRadunoShooters";

		_methodParameterTypes2 = new String[] {
				"it.ethica.esf.service.persistence.EsfRadunoShootersPK"
			};

		_methodName3 = "deleteEsfRadunoShooters";

		_methodParameterTypes3 = new String[] {
				"it.ethica.esf.model.EsfRadunoShooters"
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

		_methodName10 = "fetchEsfRadunoShooters";

		_methodParameterTypes10 = new String[] {
				"it.ethica.esf.service.persistence.EsfRadunoShootersPK"
			};

		_methodName11 = "getEsfRadunoShooters";

		_methodParameterTypes11 = new String[] {
				"it.ethica.esf.service.persistence.EsfRadunoShootersPK"
			};

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getEsfRadunoShooterses";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getEsfRadunoShootersesCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateEsfRadunoShooters";

		_methodParameterTypes15 = new String[] {
				"it.ethica.esf.model.EsfRadunoShooters"
			};

		_methodName424 = "getBeanIdentifier";

		_methodParameterTypes424 = new String[] {  };

		_methodName425 = "setBeanIdentifier";

		_methodParameterTypes425 = new String[] { "java.lang.String" };

		_methodName430 = "findById";

		_methodParameterTypes430 = new String[] { "long" };

		_methodName431 = "associaShooters";

		_methodParameterTypes431 = new String[] {
				"long", "java.util.List", "java.util.List"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return EsfRadunoShootersLocalServiceUtil.addEsfRadunoShooters((it.ethica.esf.model.EsfRadunoShooters)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return EsfRadunoShootersLocalServiceUtil.createEsfRadunoShooters((it.ethica.esf.service.persistence.EsfRadunoShootersPK)arguments[0]);
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return EsfRadunoShootersLocalServiceUtil.deleteEsfRadunoShooters((it.ethica.esf.service.persistence.EsfRadunoShootersPK)arguments[0]);
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return EsfRadunoShootersLocalServiceUtil.deleteEsfRadunoShooters((it.ethica.esf.model.EsfRadunoShooters)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return EsfRadunoShootersLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return EsfRadunoShootersLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return EsfRadunoShootersLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return EsfRadunoShootersLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return EsfRadunoShootersLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return EsfRadunoShootersLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return EsfRadunoShootersLocalServiceUtil.fetchEsfRadunoShooters((it.ethica.esf.service.persistence.EsfRadunoShootersPK)arguments[0]);
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return EsfRadunoShootersLocalServiceUtil.getEsfRadunoShooters((it.ethica.esf.service.persistence.EsfRadunoShootersPK)arguments[0]);
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return EsfRadunoShootersLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return EsfRadunoShootersLocalServiceUtil.getEsfRadunoShooterses(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return EsfRadunoShootersLocalServiceUtil.getEsfRadunoShootersesCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return EsfRadunoShootersLocalServiceUtil.updateEsfRadunoShooters((it.ethica.esf.model.EsfRadunoShooters)arguments[0]);
		}

		if (_methodName424.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes424, parameterTypes)) {
			return EsfRadunoShootersLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName425.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes425, parameterTypes)) {
			EsfRadunoShootersLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName430.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes430, parameterTypes)) {
			return EsfRadunoShootersLocalServiceUtil.findById(((Long)arguments[0]).longValue());
		}

		if (_methodName431.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes431, parameterTypes)) {
			EsfRadunoShootersLocalServiceUtil.associaShooters(((Long)arguments[0]).longValue(),
				(java.util.List<java.lang.String>)arguments[1],
				(java.util.List<java.lang.String>)arguments[2]);

			return null;
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
}