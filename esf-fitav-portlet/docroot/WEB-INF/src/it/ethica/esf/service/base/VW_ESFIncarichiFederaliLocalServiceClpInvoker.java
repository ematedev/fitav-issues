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

import it.ethica.esf.service.VW_ESFIncarichiFederaliLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Ethica
 * @generated
 */
public class VW_ESFIncarichiFederaliLocalServiceClpInvoker {
	public VW_ESFIncarichiFederaliLocalServiceClpInvoker() {
		_methodName0 = "addVW_ESFIncarichiFederali";

		_methodParameterTypes0 = new String[] {
				"it.ethica.esf.model.VW_ESFIncarichiFederali"
			};

		_methodName1 = "createVW_ESFIncarichiFederali";

		_methodParameterTypes1 = new String[] {
				"it.ethica.esf.service.persistence.VW_ESFIncarichiFederaliPK"
			};

		_methodName2 = "deleteVW_ESFIncarichiFederali";

		_methodParameterTypes2 = new String[] {
				"it.ethica.esf.service.persistence.VW_ESFIncarichiFederaliPK"
			};

		_methodName3 = "deleteVW_ESFIncarichiFederali";

		_methodParameterTypes3 = new String[] {
				"it.ethica.esf.model.VW_ESFIncarichiFederali"
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

		_methodName10 = "fetchVW_ESFIncarichiFederali";

		_methodParameterTypes10 = new String[] {
				"it.ethica.esf.service.persistence.VW_ESFIncarichiFederaliPK"
			};

		_methodName11 = "getVW_ESFIncarichiFederali";

		_methodParameterTypes11 = new String[] {
				"it.ethica.esf.service.persistence.VW_ESFIncarichiFederaliPK"
			};

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getVW_ESFIncarichiFederalis";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getVW_ESFIncarichiFederalisCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateVW_ESFIncarichiFederali";

		_methodParameterTypes15 = new String[] {
				"it.ethica.esf.model.VW_ESFIncarichiFederali"
			};

		_methodName392 = "getBeanIdentifier";

		_methodParameterTypes392 = new String[] {  };

		_methodName393 = "setBeanIdentifier";

		_methodParameterTypes393 = new String[] { "java.lang.String" };

		_methodName398 = "findBylistaIncarichi";

		_methodParameterTypes398 = new String[] { "long", "boolean" };

		_methodName399 = "getListaIncarichifindBylistaIncarichi";

		_methodParameterTypes399 = new String[] { "long", "boolean" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return VW_ESFIncarichiFederaliLocalServiceUtil.addVW_ESFIncarichiFederali((it.ethica.esf.model.VW_ESFIncarichiFederali)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return VW_ESFIncarichiFederaliLocalServiceUtil.createVW_ESFIncarichiFederali((it.ethica.esf.service.persistence.VW_ESFIncarichiFederaliPK)arguments[0]);
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return VW_ESFIncarichiFederaliLocalServiceUtil.deleteVW_ESFIncarichiFederali((it.ethica.esf.service.persistence.VW_ESFIncarichiFederaliPK)arguments[0]);
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return VW_ESFIncarichiFederaliLocalServiceUtil.deleteVW_ESFIncarichiFederali((it.ethica.esf.model.VW_ESFIncarichiFederali)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return VW_ESFIncarichiFederaliLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return VW_ESFIncarichiFederaliLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return VW_ESFIncarichiFederaliLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return VW_ESFIncarichiFederaliLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return VW_ESFIncarichiFederaliLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return VW_ESFIncarichiFederaliLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return VW_ESFIncarichiFederaliLocalServiceUtil.fetchVW_ESFIncarichiFederali((it.ethica.esf.service.persistence.VW_ESFIncarichiFederaliPK)arguments[0]);
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return VW_ESFIncarichiFederaliLocalServiceUtil.getVW_ESFIncarichiFederali((it.ethica.esf.service.persistence.VW_ESFIncarichiFederaliPK)arguments[0]);
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return VW_ESFIncarichiFederaliLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return VW_ESFIncarichiFederaliLocalServiceUtil.getVW_ESFIncarichiFederalis(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return VW_ESFIncarichiFederaliLocalServiceUtil.getVW_ESFIncarichiFederalisCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return VW_ESFIncarichiFederaliLocalServiceUtil.updateVW_ESFIncarichiFederali((it.ethica.esf.model.VW_ESFIncarichiFederali)arguments[0]);
		}

		if (_methodName392.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes392, parameterTypes)) {
			return VW_ESFIncarichiFederaliLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName393.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes393, parameterTypes)) {
			VW_ESFIncarichiFederaliLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName398.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes398, parameterTypes)) {
			return VW_ESFIncarichiFederaliLocalServiceUtil.findBylistaIncarichi(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue());
		}

		if (_methodName399.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes399, parameterTypes)) {
			return VW_ESFIncarichiFederaliLocalServiceUtil.getListaIncarichifindBylistaIncarichi(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue());
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
	private String _methodName392;
	private String[] _methodParameterTypes392;
	private String _methodName393;
	private String[] _methodParameterTypes393;
	private String _methodName398;
	private String[] _methodParameterTypes398;
	private String _methodName399;
	private String[] _methodParameterTypes399;
}