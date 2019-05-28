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
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 4e2f23245d33f5cc80bffcdd36acf34e75accc38
		_methodName368 = "getBeanIdentifier";

		_methodParameterTypes368 = new String[] {  };

		_methodName369 = "setBeanIdentifier";

		_methodParameterTypes369 = new String[] { "java.lang.String" };
<<<<<<< HEAD
=======
		_methodName360 = "getBeanIdentifier";

		_methodParameterTypes360 = new String[] {  };

		_methodName361 = "setBeanIdentifier";

		_methodParameterTypes361 = new String[] { "java.lang.String" };
>>>>>>> anomalia-id16
=======
>>>>>>> 4e2f23245d33f5cc80bffcdd36acf34e75accc38
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 4e2f23245d33f5cc80bffcdd36acf34e75accc38
		if (_methodName368.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes368, parameterTypes)) {
			return ESFSpecificServiceUtil.getBeanIdentifier();
		}

		if (_methodName369.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes369, parameterTypes)) {
<<<<<<< HEAD
=======
		if (_methodName360.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes360, parameterTypes)) {
			return ESFSpecificServiceUtil.getBeanIdentifier();
		}

		if (_methodName361.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes361, parameterTypes)) {
>>>>>>> anomalia-id16
=======
>>>>>>> 4e2f23245d33f5cc80bffcdd36acf34e75accc38
			ESFSpecificServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		throw new UnsupportedOperationException();
	}

<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 4e2f23245d33f5cc80bffcdd36acf34e75accc38
	private String _methodName368;
	private String[] _methodParameterTypes368;
	private String _methodName369;
	private String[] _methodParameterTypes369;
<<<<<<< HEAD
=======
	private String _methodName360;
	private String[] _methodParameterTypes360;
	private String _methodName361;
	private String[] _methodParameterTypes361;
>>>>>>> anomalia-id16
=======
>>>>>>> 4e2f23245d33f5cc80bffcdd36acf34e75accc38
}