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

import it.ethica.esf.service.ESFSpecificServiceUtil;

import java.util.Arrays;

/**
 * @author Ethica
 * @generated
 */
public class ESFSpecificServiceClpInvoker {
	public ESFSpecificServiceClpInvoker() {
		_methodName356 = "getBeanIdentifier";

		_methodParameterTypes356 = new String[] {  };

		_methodName357 = "setBeanIdentifier";

		_methodParameterTypes357 = new String[] { "java.lang.String" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName356.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes356, parameterTypes)) {
			return ESFSpecificServiceUtil.getBeanIdentifier();
		}

		if (_methodName357.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes357, parameterTypes)) {
			ESFSpecificServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName356;
	private String[] _methodParameterTypes356;
	private String _methodName357;
	private String[] _methodParameterTypes357;
}