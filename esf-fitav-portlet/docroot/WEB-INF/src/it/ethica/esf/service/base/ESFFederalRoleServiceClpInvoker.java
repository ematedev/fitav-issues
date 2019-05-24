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

import it.ethica.esf.service.ESFFederalRoleServiceUtil;

import java.util.Arrays;

/**
 * @author Ethica
 * @generated
 */
public class ESFFederalRoleServiceClpInvoker {
	public ESFFederalRoleServiceClpInvoker() {
		_methodName360 = "getBeanIdentifier";

		_methodParameterTypes360 = new String[] {  };

		_methodName361 = "setBeanIdentifier";

		_methodParameterTypes361 = new String[] { "java.lang.String" };

		_methodName366 = "updateEsfFederalRole";

		_methodParameterTypes366 = new String[] {
				"long", "java.lang.String", "java.lang.String", "boolean",
				"boolean"
			};

		_methodName367 = "getFederalRoleSpecifics";

		_methodParameterTypes367 = new String[] { "long" };

		_methodName368 = "findByCode";

		_methodParameterTypes368 = new String[] { "java.lang.String" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName360.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes360, parameterTypes)) {
			return ESFFederalRoleServiceUtil.getBeanIdentifier();
		}

		if (_methodName361.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes361, parameterTypes)) {
			ESFFederalRoleServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName366.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes366, parameterTypes)) {
			return ESFFederalRoleServiceUtil.updateEsfFederalRole(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				((Boolean)arguments[3]).booleanValue(),
				((Boolean)arguments[4]).booleanValue());
		}

		if (_methodName367.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes367, parameterTypes)) {
			return ESFFederalRoleServiceUtil.getFederalRoleSpecifics(((Long)arguments[0]).longValue());
		}

		if (_methodName368.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes368, parameterTypes)) {
			return ESFFederalRoleServiceUtil.findByCode((java.lang.String)arguments[0]);
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName360;
	private String[] _methodParameterTypes360;
	private String _methodName361;
	private String[] _methodParameterTypes361;
	private String _methodName366;
	private String[] _methodParameterTypes366;
	private String _methodName367;
	private String[] _methodParameterTypes367;
	private String _methodName368;
	private String[] _methodParameterTypes368;
}