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
		_methodName362 = "getBeanIdentifier";

		_methodParameterTypes362 = new String[] {  };

		_methodName363 = "setBeanIdentifier";

		_methodParameterTypes363 = new String[] { "java.lang.String" };

		_methodName368 = "findByUserId";

		_methodParameterTypes368 = new String[] { "long" };

		_methodName369 = "findCurrentByUserId";

		_methodParameterTypes369 = new String[] { "long" };

		_methodName370 = "findHistoryByUserId";

		_methodParameterTypes370 = new String[] { "long" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName362.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes362, parameterTypes)) {
			return ESFCardServiceUtil.getBeanIdentifier();
		}

		if (_methodName363.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes363, parameterTypes)) {
			ESFCardServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName368.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes368, parameterTypes)) {
			return ESFCardServiceUtil.findByUserId(((Long)arguments[0]).longValue());
		}

		if (_methodName369.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes369, parameterTypes)) {
			return ESFCardServiceUtil.findCurrentByUserId(((Long)arguments[0]).longValue());
		}

		if (_methodName370.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes370, parameterTypes)) {
			return ESFCardServiceUtil.findHistoryByUserId(((Long)arguments[0]).longValue());
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName362;
	private String[] _methodParameterTypes362;
	private String _methodName363;
	private String[] _methodParameterTypes363;
	private String _methodName368;
	private String[] _methodParameterTypes368;
	private String _methodName369;
	private String[] _methodParameterTypes369;
	private String _methodName370;
	private String[] _methodParameterTypes370;
}