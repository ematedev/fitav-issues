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

import it.ethica.esf.service.ESFRadunoAzzurriLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Ethica
 * @generated
 */
public class ESFRadunoAzzurriLocalServiceClpInvoker {
	public ESFRadunoAzzurriLocalServiceClpInvoker() {
		_methodName0 = "addESFRadunoAzzurri";

		_methodParameterTypes0 = new String[] {
				"it.ethica.esf.model.ESFRadunoAzzurri"
			};

		_methodName1 = "createESFRadunoAzzurri";

		_methodParameterTypes1 = new String[] {
				"it.ethica.esf.service.persistence.ESFRadunoAzzurriPK"
			};

		_methodName2 = "deleteESFRadunoAzzurri";

		_methodParameterTypes2 = new String[] {
				"it.ethica.esf.service.persistence.ESFRadunoAzzurriPK"
			};

		_methodName3 = "deleteESFRadunoAzzurri";

		_methodParameterTypes3 = new String[] {
				"it.ethica.esf.model.ESFRadunoAzzurri"
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

		_methodName10 = "fetchESFRadunoAzzurri";

		_methodParameterTypes10 = new String[] {
				"it.ethica.esf.service.persistence.ESFRadunoAzzurriPK"
			};

		_methodName11 = "getESFRadunoAzzurri";

		_methodParameterTypes11 = new String[] {
				"it.ethica.esf.service.persistence.ESFRadunoAzzurriPK"
			};

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getESFRadunoAzzurris";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getESFRadunoAzzurrisCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateESFRadunoAzzurri";

		_methodParameterTypes15 = new String[] {
				"it.ethica.esf.model.ESFRadunoAzzurri"
			};

		_methodName408 = "getBeanIdentifier";

		_methodParameterTypes408 = new String[] {  };

		_methodName409 = "setBeanIdentifier";

		_methodParameterTypes409 = new String[] { "java.lang.String" };

		_methodName414 = "findById";

		_methodParameterTypes414 = new String[] { "long" };

		_methodName415 = "associaAzzurri";

		_methodParameterTypes415 = new String[] {
				"long", "java.util.List", "java.util.List"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return ESFRadunoAzzurriLocalServiceUtil.addESFRadunoAzzurri((it.ethica.esf.model.ESFRadunoAzzurri)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return ESFRadunoAzzurriLocalServiceUtil.createESFRadunoAzzurri((it.ethica.esf.service.persistence.ESFRadunoAzzurriPK)arguments[0]);
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return ESFRadunoAzzurriLocalServiceUtil.deleteESFRadunoAzzurri((it.ethica.esf.service.persistence.ESFRadunoAzzurriPK)arguments[0]);
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return ESFRadunoAzzurriLocalServiceUtil.deleteESFRadunoAzzurri((it.ethica.esf.model.ESFRadunoAzzurri)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return ESFRadunoAzzurriLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return ESFRadunoAzzurriLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return ESFRadunoAzzurriLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return ESFRadunoAzzurriLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return ESFRadunoAzzurriLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return ESFRadunoAzzurriLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return ESFRadunoAzzurriLocalServiceUtil.fetchESFRadunoAzzurri((it.ethica.esf.service.persistence.ESFRadunoAzzurriPK)arguments[0]);
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return ESFRadunoAzzurriLocalServiceUtil.getESFRadunoAzzurri((it.ethica.esf.service.persistence.ESFRadunoAzzurriPK)arguments[0]);
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return ESFRadunoAzzurriLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return ESFRadunoAzzurriLocalServiceUtil.getESFRadunoAzzurris(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return ESFRadunoAzzurriLocalServiceUtil.getESFRadunoAzzurrisCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return ESFRadunoAzzurriLocalServiceUtil.updateESFRadunoAzzurri((it.ethica.esf.model.ESFRadunoAzzurri)arguments[0]);
		}

		if (_methodName408.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes408, parameterTypes)) {
			return ESFRadunoAzzurriLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName409.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes409, parameterTypes)) {
			ESFRadunoAzzurriLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName414.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes414, parameterTypes)) {
			return ESFRadunoAzzurriLocalServiceUtil.findById(((Long)arguments[0]).longValue());
		}

		if (_methodName415.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes415, parameterTypes)) {
			ESFRadunoAzzurriLocalServiceUtil.associaAzzurri(((Long)arguments[0]).longValue(),
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
	private String _methodName408;
	private String[] _methodParameterTypes408;
	private String _methodName409;
	private String[] _methodParameterTypes409;
	private String _methodName414;
	private String[] _methodParameterTypes414;
	private String _methodName415;
	private String[] _methodParameterTypes415;
}