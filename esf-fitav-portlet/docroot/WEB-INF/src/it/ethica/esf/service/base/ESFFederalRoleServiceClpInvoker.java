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
		_methodName352 = "getBeanIdentifier";

		_methodParameterTypes352 = new String[] {  };

		_methodName353 = "setBeanIdentifier";

		_methodParameterTypes353 = new String[] { "java.lang.String" };

		_methodName358 = "updateEsfFederalRole";

		_methodParameterTypes358 = new String[] {
				"long", "java.lang.String", "java.lang.String", "boolean",
				"boolean"
			};

		_methodName359 = "getFederalRoleSpecifics";

		_methodParameterTypes359 = new String[] { "long" };

		_methodName360 = "findByCode";

		_methodParameterTypes360 = new String[] { "java.lang.String" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName352.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes352, parameterTypes)) {
			return ESFFederalRoleServiceUtil.getBeanIdentifier();
		}

		if (_methodName353.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes353, parameterTypes)) {
			ESFFederalRoleServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName358.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes358, parameterTypes)) {
			return ESFFederalRoleServiceUtil.updateEsfFederalRole(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				((Boolean)arguments[3]).booleanValue(),
				((Boolean)arguments[4]).booleanValue());
		}

		if (_methodName359.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes359, parameterTypes)) {
			return ESFFederalRoleServiceUtil.getFederalRoleSpecifics(((Long)arguments[0]).longValue());
		}

		if (_methodName360.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes360, parameterTypes)) {
			return ESFFederalRoleServiceUtil.findByCode((java.lang.String)arguments[0]);
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName352;
	private String[] _methodParameterTypes352;
	private String _methodName353;
	private String[] _methodParameterTypes353;
	private String _methodName358;
	private String[] _methodParameterTypes358;
	private String _methodName359;
	private String[] _methodParameterTypes359;
	private String _methodName360;
	private String[] _methodParameterTypes360;
}