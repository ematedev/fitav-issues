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

import it.ethica.esf.service.ESFGunTypeLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Ethica
 * @generated
 */
public class ESFGunTypeLocalServiceClpInvoker {
	public ESFGunTypeLocalServiceClpInvoker() {
		_methodName0 = "addESFGunType";

		_methodParameterTypes0 = new String[] { "it.ethica.esf.model.ESFGunType" };

		_methodName1 = "createESFGunType";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteESFGunType";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteESFGunType";

		_methodParameterTypes3 = new String[] { "it.ethica.esf.model.ESFGunType" };

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

		_methodName10 = "fetchESFGunType";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "fetchESFGunTypeByUuidAndCompanyId";

		_methodParameterTypes11 = new String[] { "java.lang.String", "long" };

		_methodName12 = "fetchESFGunTypeByUuidAndGroupId";

		_methodParameterTypes12 = new String[] { "java.lang.String", "long" };

		_methodName13 = "getESFGunType";

		_methodParameterTypes13 = new String[] { "long" };

		_methodName14 = "getPersistedModel";

		_methodParameterTypes14 = new String[] { "java.io.Serializable" };

		_methodName15 = "getESFGunTypeByUuidAndCompanyId";

		_methodParameterTypes15 = new String[] { "java.lang.String", "long" };

		_methodName16 = "getESFGunTypeByUuidAndGroupId";

		_methodParameterTypes16 = new String[] { "java.lang.String", "long" };

		_methodName17 = "getESFGunTypes";

		_methodParameterTypes17 = new String[] { "int", "int" };

		_methodName18 = "getESFGunTypesCount";

		_methodParameterTypes18 = new String[] {  };

		_methodName19 = "updateESFGunType";

		_methodParameterTypes19 = new String[] { "it.ethica.esf.model.ESFGunType" };

		_methodName44 = "getBeanIdentifier";

		_methodParameterTypes44 = new String[] {  };

		_methodName45 = "setBeanIdentifier";

		_methodParameterTypes45 = new String[] { "java.lang.String" };

		_methodName50 = "getESFGunTypes";

		_methodParameterTypes50 = new String[] {  };

		_methodName51 = "getESFGunTypes";

		_methodParameterTypes51 = new String[] { "int", "int" };

		_methodName52 = "addESFGunType";

		_methodParameterTypes52 = new String[] {
				"long", "java.lang.String", "java.lang.String",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName53 = "updateESFGunType";

		_methodParameterTypes53 = new String[] {
				"long", "long", "java.lang.String", "java.lang.String",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName54 = "deleteESFGunType";

		_methodParameterTypes54 = new String[] {
				"long", "com.liferay.portal.service.ServiceContext"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return ESFGunTypeLocalServiceUtil.addESFGunType((it.ethica.esf.model.ESFGunType)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return ESFGunTypeLocalServiceUtil.createESFGunType(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return ESFGunTypeLocalServiceUtil.deleteESFGunType(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return ESFGunTypeLocalServiceUtil.deleteESFGunType((it.ethica.esf.model.ESFGunType)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return ESFGunTypeLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return ESFGunTypeLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return ESFGunTypeLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return ESFGunTypeLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return ESFGunTypeLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return ESFGunTypeLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return ESFGunTypeLocalServiceUtil.fetchESFGunType(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return ESFGunTypeLocalServiceUtil.fetchESFGunTypeByUuidAndCompanyId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return ESFGunTypeLocalServiceUtil.fetchESFGunTypeByUuidAndGroupId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return ESFGunTypeLocalServiceUtil.getESFGunType(((Long)arguments[0]).longValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return ESFGunTypeLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return ESFGunTypeLocalServiceUtil.getESFGunTypeByUuidAndCompanyId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName16.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes16, parameterTypes)) {
			return ESFGunTypeLocalServiceUtil.getESFGunTypeByUuidAndGroupId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName17.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes17, parameterTypes)) {
			return ESFGunTypeLocalServiceUtil.getESFGunTypes(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName18.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes18, parameterTypes)) {
			return ESFGunTypeLocalServiceUtil.getESFGunTypesCount();
		}

		if (_methodName19.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes19, parameterTypes)) {
			return ESFGunTypeLocalServiceUtil.updateESFGunType((it.ethica.esf.model.ESFGunType)arguments[0]);
		}

		if (_methodName44.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes44, parameterTypes)) {
			return ESFGunTypeLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName45.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes45, parameterTypes)) {
			ESFGunTypeLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName50.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes50, parameterTypes)) {
			return ESFGunTypeLocalServiceUtil.getESFGunTypes();
		}

		if (_methodName51.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes51, parameterTypes)) {
			return ESFGunTypeLocalServiceUtil.getESFGunTypes(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName52.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes52, parameterTypes)) {
			return ESFGunTypeLocalServiceUtil.addESFGunType(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(com.liferay.portal.service.ServiceContext)arguments[3]);
		}

		if (_methodName53.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes53, parameterTypes)) {
			return ESFGunTypeLocalServiceUtil.updateESFGunType(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3],
				(com.liferay.portal.service.ServiceContext)arguments[4]);
		}

		if (_methodName54.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes54, parameterTypes)) {
			return ESFGunTypeLocalServiceUtil.deleteESFGunType(((Long)arguments[0]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[1]);
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
	private String _methodName16;
	private String[] _methodParameterTypes16;
	private String _methodName17;
	private String[] _methodParameterTypes17;
	private String _methodName18;
	private String[] _methodParameterTypes18;
	private String _methodName19;
	private String[] _methodParameterTypes19;
	private String _methodName44;
	private String[] _methodParameterTypes44;
	private String _methodName45;
	private String[] _methodParameterTypes45;
	private String _methodName50;
	private String[] _methodParameterTypes50;
	private String _methodName51;
	private String[] _methodParameterTypes51;
	private String _methodName52;
	private String[] _methodParameterTypes52;
	private String _methodName53;
	private String[] _methodParameterTypes53;
	private String _methodName54;
	private String[] _methodParameterTypes54;
}