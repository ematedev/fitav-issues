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

import it.ethica.esf.service.ESFFederalRoleESFSpecificServiceUtil;

import java.util.Arrays;

/**
 * @author Ethica
 * @generated
 */
public class ESFFederalRoleESFSpecificServiceClpInvoker {
	public ESFFederalRoleESFSpecificServiceClpInvoker() {
		_methodName352 = "getBeanIdentifier";

		_methodParameterTypes352 = new String[] {  };

		_methodName353 = "setBeanIdentifier";

		_methodParameterTypes353 = new String[] { "java.lang.String" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName352.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes352, parameterTypes)) {
			return ESFFederalRoleESFSpecificServiceUtil.getBeanIdentifier();
		}

		if (_methodName353.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes353, parameterTypes)) {
			ESFFederalRoleESFSpecificServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName352;
	private String[] _methodParameterTypes352;
	private String _methodName353;
	private String[] _methodParameterTypes353;
}