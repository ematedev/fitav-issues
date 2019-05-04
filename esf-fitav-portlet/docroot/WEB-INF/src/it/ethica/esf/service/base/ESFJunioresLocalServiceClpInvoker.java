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

import it.ethica.esf.service.ESFJunioresLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Ethica
 * @generated
 */
public class ESFJunioresLocalServiceClpInvoker {
	public ESFJunioresLocalServiceClpInvoker() {
		_methodName0 = "addESFJuniores";

		_methodParameterTypes0 = new String[] { "it.ethica.esf.model.ESFJuniores" };

		_methodName1 = "createESFJuniores";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteESFJuniores";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteESFJuniores";

		_methodParameterTypes3 = new String[] { "it.ethica.esf.model.ESFJuniores" };

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

		_methodName10 = "fetchESFJuniores";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getESFJuniores";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getESFJunioreses";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getESFJunioresesCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateESFJuniores";

		_methodParameterTypes15 = new String[] { "it.ethica.esf.model.ESFJuniores" };

<<<<<<< HEAD
		_methodName380 = "getBeanIdentifier";

		_methodParameterTypes380 = new String[] {  };

		_methodName381 = "setBeanIdentifier";

		_methodParameterTypes381 = new String[] { "java.lang.String" };
=======
		_methodName372 = "getBeanIdentifier";

		_methodParameterTypes372 = new String[] {  };

		_methodName373 = "setBeanIdentifier";

		_methodParameterTypes373 = new String[] { "java.lang.String" };
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return ESFJunioresLocalServiceUtil.addESFJuniores((it.ethica.esf.model.ESFJuniores)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return ESFJunioresLocalServiceUtil.createESFJuniores(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return ESFJunioresLocalServiceUtil.deleteESFJuniores(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return ESFJunioresLocalServiceUtil.deleteESFJuniores((it.ethica.esf.model.ESFJuniores)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return ESFJunioresLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return ESFJunioresLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return ESFJunioresLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return ESFJunioresLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return ESFJunioresLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return ESFJunioresLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return ESFJunioresLocalServiceUtil.fetchESFJuniores(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return ESFJunioresLocalServiceUtil.getESFJuniores(((Long)arguments[0]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return ESFJunioresLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return ESFJunioresLocalServiceUtil.getESFJunioreses(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return ESFJunioresLocalServiceUtil.getESFJunioresesCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return ESFJunioresLocalServiceUtil.updateESFJuniores((it.ethica.esf.model.ESFJuniores)arguments[0]);
		}

<<<<<<< HEAD
		if (_methodName380.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes380, parameterTypes)) {
			return ESFJunioresLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName381.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes381, parameterTypes)) {
=======
		if (_methodName372.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes372, parameterTypes)) {
			return ESFJunioresLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName373.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes373, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			ESFJunioresLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

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
<<<<<<< HEAD
	private String _methodName380;
	private String[] _methodParameterTypes380;
	private String _methodName381;
	private String[] _methodParameterTypes381;
=======
	private String _methodName372;
	private String[] _methodParameterTypes372;
	private String _methodName373;
	private String[] _methodParameterTypes373;
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
}