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

import it.ethica.esf.service.ESFCardServiceUtil;

import java.util.Arrays;

/**
 * @author Ethica
 * @generated
 */
public class ESFCardServiceClpInvoker {
	public ESFCardServiceClpInvoker() {
		_methodName366 = "getBeanIdentifier";

		_methodParameterTypes366 = new String[] {  };

		_methodName367 = "setBeanIdentifier";

		_methodParameterTypes367 = new String[] { "java.lang.String" };

		_methodName372 = "findByUserId";

		_methodParameterTypes372 = new String[] { "long" };

		_methodName373 = "findCurrentByUserId";

		_methodParameterTypes373 = new String[] { "long" };

		_methodName374 = "findHistoryByUserId";

		_methodParameterTypes374 = new String[] { "long" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName366.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes366, parameterTypes)) {
			return ESFCardServiceUtil.getBeanIdentifier();
		}

		if (_methodName367.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes367, parameterTypes)) {
			ESFCardServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName372.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes372, parameterTypes)) {
			return ESFCardServiceUtil.findByUserId(((Long)arguments[0]).longValue());
		}

		if (_methodName373.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes373, parameterTypes)) {
			return ESFCardServiceUtil.findCurrentByUserId(((Long)arguments[0]).longValue());
		}

		if (_methodName374.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes374, parameterTypes)) {
			return ESFCardServiceUtil.findHistoryByUserId(((Long)arguments[0]).longValue());
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName366;
	private String[] _methodParameterTypes366;
	private String _methodName367;
	private String[] _methodParameterTypes367;
	private String _methodName372;
	private String[] _methodParameterTypes372;
	private String _methodName373;
	private String[] _methodParameterTypes373;
	private String _methodName374;
	private String[] _methodParameterTypes374;
}