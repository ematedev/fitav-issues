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
		_methodName356 = "getBeanIdentifier";

		_methodParameterTypes356 = new String[] {  };

		_methodName357 = "setBeanIdentifier";

		_methodParameterTypes357 = new String[] { "java.lang.String" };

		_methodName362 = "updateEsfFederalRole";

		_methodParameterTypes362 = new String[] {
				"long", "java.lang.String", "java.lang.String", "boolean",
				"boolean"
			};

		_methodName363 = "getFederalRoleSpecifics";

		_methodParameterTypes363 = new String[] { "long" };

		_methodName364 = "findByCode";

		_methodParameterTypes364 = new String[] { "java.lang.String" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName356.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes356, parameterTypes)) {
			return ESFFederalRoleServiceUtil.getBeanIdentifier();
		}

		if (_methodName357.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes357, parameterTypes)) {
			ESFFederalRoleServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName362.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes362, parameterTypes)) {
			return ESFFederalRoleServiceUtil.updateEsfFederalRole(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				((Boolean)arguments[3]).booleanValue(),
				((Boolean)arguments[4]).booleanValue());
		}

		if (_methodName363.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes363, parameterTypes)) {
			return ESFFederalRoleServiceUtil.getFederalRoleSpecifics(((Long)arguments[0]).longValue());
		}

		if (_methodName364.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes364, parameterTypes)) {
			return ESFFederalRoleServiceUtil.findByCode((java.lang.String)arguments[0]);
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName356;
	private String[] _methodParameterTypes356;
	private String _methodName357;
	private String[] _methodParameterTypes357;
	private String _methodName362;
	private String[] _methodParameterTypes362;
	private String _methodName363;
	private String[] _methodParameterTypes363;
	private String _methodName364;
	private String[] _methodParameterTypes364;
}