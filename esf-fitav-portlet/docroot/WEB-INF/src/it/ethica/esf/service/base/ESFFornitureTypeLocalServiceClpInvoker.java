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

import it.ethica.esf.service.ESFFornitureTypeLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Ethica
 * @generated
 */
public class ESFFornitureTypeLocalServiceClpInvoker {
	public ESFFornitureTypeLocalServiceClpInvoker() {
		_methodName0 = "addESFFornitureType";

		_methodParameterTypes0 = new String[] {
				"it.ethica.esf.model.ESFFornitureType"
			};

		_methodName1 = "createESFFornitureType";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteESFFornitureType";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteESFFornitureType";

		_methodParameterTypes3 = new String[] {
				"it.ethica.esf.model.ESFFornitureType"
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

		_methodName10 = "fetchESFFornitureType";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "fetchESFFornitureTypeByUuidAndCompanyId";

		_methodParameterTypes11 = new String[] { "java.lang.String", "long" };

		_methodName12 = "fetchESFFornitureTypeByUuidAndGroupId";

		_methodParameterTypes12 = new String[] { "java.lang.String", "long" };

		_methodName13 = "getESFFornitureType";

		_methodParameterTypes13 = new String[] { "long" };

		_methodName14 = "getPersistedModel";

		_methodParameterTypes14 = new String[] { "java.io.Serializable" };

		_methodName15 = "getESFFornitureTypeByUuidAndCompanyId";

		_methodParameterTypes15 = new String[] { "java.lang.String", "long" };

		_methodName16 = "getESFFornitureTypeByUuidAndGroupId";

		_methodParameterTypes16 = new String[] { "java.lang.String", "long" };

		_methodName17 = "getESFFornitureTypes";

		_methodParameterTypes17 = new String[] { "int", "int" };

		_methodName18 = "getESFFornitureTypesCount";

		_methodParameterTypes18 = new String[] {  };

		_methodName19 = "updateESFFornitureType";

		_methodParameterTypes19 = new String[] {
				"it.ethica.esf.model.ESFFornitureType"
			};

<<<<<<< HEAD
		_methodName396 = "getBeanIdentifier";

		_methodParameterTypes396 = new String[] {  };

		_methodName397 = "setBeanIdentifier";

		_methodParameterTypes397 = new String[] { "java.lang.String" };

		_methodName402 = "getAllESFFornitureTypes";

		_methodParameterTypes402 = new String[] {  };

		_methodName403 = "getAllESFFornitureTypes";

		_methodParameterTypes403 = new String[] { "int", "int" };

		_methodName404 = "getAllESFFornitureTypes";

		_methodParameterTypes404 = new String[] { "long" };

		_methodName405 = "getAllESFFornitureTypes";

		_methodParameterTypes405 = new String[] { "long", "int", "int" };

		_methodName406 = "countByGroupId";

		_methodParameterTypes406 = new String[] { "long" };

		_methodName407 = "findESFFornitureTypeByDescription";

		_methodParameterTypes407 = new String[] { "java.lang.String" };

		_methodName408 = "addESFForntureType";

		_methodParameterTypes408 = new String[] {
=======
		_methodName390 = "getBeanIdentifier";

		_methodParameterTypes390 = new String[] {  };

		_methodName391 = "setBeanIdentifier";

		_methodParameterTypes391 = new String[] { "java.lang.String" };

		_methodName396 = "getAllESFFornitureTypes";

		_methodParameterTypes396 = new String[] {  };

		_methodName397 = "getAllESFFornitureTypes";

		_methodParameterTypes397 = new String[] { "int", "int" };

		_methodName398 = "getAllESFFornitureTypes";

		_methodParameterTypes398 = new String[] { "long" };

		_methodName399 = "getAllESFFornitureTypes";

		_methodParameterTypes399 = new String[] { "long", "int", "int" };

		_methodName400 = "countByGroupId";

		_methodParameterTypes400 = new String[] { "long" };

		_methodName401 = "findESFFornitureTypeByDescription";

		_methodParameterTypes401 = new String[] { "java.lang.String" };

		_methodName402 = "addESFForntureType";

		_methodParameterTypes402 = new String[] {
>>>>>>> origin/ID32
				"long", "java.lang.String",
				"com.liferay.portal.service.ServiceContext"
			};

<<<<<<< HEAD
		_methodName409 = "updateESFFornitureType";

		_methodParameterTypes409 = new String[] {
=======
		_methodName403 = "updateESFFornitureType";

		_methodParameterTypes403 = new String[] {
>>>>>>> origin/ID32
				"long", "long", "java.lang.String",
				"com.liferay.portal.service.ServiceContext"
			};

<<<<<<< HEAD
		_methodName410 = "deleteESFFornitureType";

		_methodParameterTypes410 = new String[] {
=======
		_methodName404 = "deleteESFFornitureType";

		_methodParameterTypes404 = new String[] {
>>>>>>> origin/ID32
				"long", "com.liferay.portal.service.ServiceContext"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return ESFFornitureTypeLocalServiceUtil.addESFFornitureType((it.ethica.esf.model.ESFFornitureType)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return ESFFornitureTypeLocalServiceUtil.createESFFornitureType(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return ESFFornitureTypeLocalServiceUtil.deleteESFFornitureType(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return ESFFornitureTypeLocalServiceUtil.deleteESFFornitureType((it.ethica.esf.model.ESFFornitureType)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return ESFFornitureTypeLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return ESFFornitureTypeLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return ESFFornitureTypeLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return ESFFornitureTypeLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return ESFFornitureTypeLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return ESFFornitureTypeLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return ESFFornitureTypeLocalServiceUtil.fetchESFFornitureType(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return ESFFornitureTypeLocalServiceUtil.fetchESFFornitureTypeByUuidAndCompanyId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return ESFFornitureTypeLocalServiceUtil.fetchESFFornitureTypeByUuidAndGroupId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return ESFFornitureTypeLocalServiceUtil.getESFFornitureType(((Long)arguments[0]).longValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return ESFFornitureTypeLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return ESFFornitureTypeLocalServiceUtil.getESFFornitureTypeByUuidAndCompanyId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName16.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes16, parameterTypes)) {
			return ESFFornitureTypeLocalServiceUtil.getESFFornitureTypeByUuidAndGroupId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName17.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes17, parameterTypes)) {
			return ESFFornitureTypeLocalServiceUtil.getESFFornitureTypes(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName18.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes18, parameterTypes)) {
			return ESFFornitureTypeLocalServiceUtil.getESFFornitureTypesCount();
		}

		if (_methodName19.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes19, parameterTypes)) {
			return ESFFornitureTypeLocalServiceUtil.updateESFFornitureType((it.ethica.esf.model.ESFFornitureType)arguments[0]);
		}

<<<<<<< HEAD
		if (_methodName396.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes396, parameterTypes)) {
			return ESFFornitureTypeLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName397.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes397, parameterTypes)) {
=======
		if (_methodName390.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes390, parameterTypes)) {
			return ESFFornitureTypeLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName391.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes391, parameterTypes)) {
>>>>>>> origin/ID32
			ESFFornitureTypeLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

<<<<<<< HEAD
		if (_methodName402.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes402, parameterTypes)) {
			return ESFFornitureTypeLocalServiceUtil.getAllESFFornitureTypes();
		}

		if (_methodName403.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes403, parameterTypes)) {
=======
		if (_methodName396.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes396, parameterTypes)) {
			return ESFFornitureTypeLocalServiceUtil.getAllESFFornitureTypes();
		}

		if (_methodName397.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes397, parameterTypes)) {
>>>>>>> origin/ID32
			return ESFFornitureTypeLocalServiceUtil.getAllESFFornitureTypes(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

<<<<<<< HEAD
		if (_methodName404.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes404, parameterTypes)) {
			return ESFFornitureTypeLocalServiceUtil.getAllESFFornitureTypes(((Long)arguments[0]).longValue());
		}

		if (_methodName405.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes405, parameterTypes)) {
=======
		if (_methodName398.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes398, parameterTypes)) {
			return ESFFornitureTypeLocalServiceUtil.getAllESFFornitureTypes(((Long)arguments[0]).longValue());
		}

		if (_methodName399.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes399, parameterTypes)) {
>>>>>>> origin/ID32
			return ESFFornitureTypeLocalServiceUtil.getAllESFFornitureTypes(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

<<<<<<< HEAD
		if (_methodName406.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes406, parameterTypes)) {
			return ESFFornitureTypeLocalServiceUtil.countByGroupId(((Long)arguments[0]).longValue());
		}

		if (_methodName407.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes407, parameterTypes)) {
			return ESFFornitureTypeLocalServiceUtil.findESFFornitureTypeByDescription((java.lang.String)arguments[0]);
		}

		if (_methodName408.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes408, parameterTypes)) {
=======
		if (_methodName400.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes400, parameterTypes)) {
			return ESFFornitureTypeLocalServiceUtil.countByGroupId(((Long)arguments[0]).longValue());
		}

		if (_methodName401.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes401, parameterTypes)) {
			return ESFFornitureTypeLocalServiceUtil.findESFFornitureTypeByDescription((java.lang.String)arguments[0]);
		}

		if (_methodName402.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes402, parameterTypes)) {
>>>>>>> origin/ID32
			return ESFFornitureTypeLocalServiceUtil.addESFForntureType(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1],
				(com.liferay.portal.service.ServiceContext)arguments[2]);
		}

<<<<<<< HEAD
		if (_methodName409.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes409, parameterTypes)) {
=======
		if (_methodName403.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes403, parameterTypes)) {
>>>>>>> origin/ID32
			return ESFFornitureTypeLocalServiceUtil.updateESFFornitureType(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				(java.lang.String)arguments[2],
				(com.liferay.portal.service.ServiceContext)arguments[3]);
		}

<<<<<<< HEAD
		if (_methodName410.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes410, parameterTypes)) {
=======
		if (_methodName404.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes404, parameterTypes)) {
>>>>>>> origin/ID32
			return ESFFornitureTypeLocalServiceUtil.deleteESFFornitureType(((Long)arguments[0]).longValue(),
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
<<<<<<< HEAD
=======
	private String _methodName390;
	private String[] _methodParameterTypes390;
	private String _methodName391;
	private String[] _methodParameterTypes391;
>>>>>>> origin/ID32
	private String _methodName396;
	private String[] _methodParameterTypes396;
	private String _methodName397;
	private String[] _methodParameterTypes397;
	private String _methodName402;
	private String[] _methodParameterTypes402;
	private String _methodName403;
	private String[] _methodParameterTypes403;
	private String _methodName404;
	private String[] _methodParameterTypes404;
<<<<<<< HEAD
	private String _methodName405;
	private String[] _methodParameterTypes405;
	private String _methodName406;
	private String[] _methodParameterTypes406;
	private String _methodName407;
	private String[] _methodParameterTypes407;
	private String _methodName408;
	private String[] _methodParameterTypes408;
	private String _methodName409;
	private String[] _methodParameterTypes409;
	private String _methodName410;
	private String[] _methodParameterTypes410;
=======
>>>>>>> origin/ID32
}