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

import it.ethica.esf.service.ESFSportTypeLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Ethica
 * @generated
 */
public class ESFSportTypeLocalServiceClpInvoker {
	public ESFSportTypeLocalServiceClpInvoker() {
		_methodName0 = "addESFSportType";

		_methodParameterTypes0 = new String[] { "it.ethica.esf.model.ESFSportType" };

		_methodName1 = "createESFSportType";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteESFSportType";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteESFSportType";

		_methodParameterTypes3 = new String[] { "it.ethica.esf.model.ESFSportType" };

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

		_methodName10 = "fetchESFSportType";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "fetchESFSportTypeByUuidAndCompanyId";

		_methodParameterTypes11 = new String[] { "java.lang.String", "long" };

		_methodName12 = "fetchESFSportTypeByUuidAndGroupId";

		_methodParameterTypes12 = new String[] { "java.lang.String", "long" };

		_methodName13 = "getESFSportType";

		_methodParameterTypes13 = new String[] { "long" };

		_methodName14 = "getPersistedModel";

		_methodParameterTypes14 = new String[] { "java.io.Serializable" };

		_methodName15 = "getESFSportTypeByUuidAndCompanyId";

		_methodParameterTypes15 = new String[] { "java.lang.String", "long" };

		_methodName16 = "getESFSportTypeByUuidAndGroupId";

		_methodParameterTypes16 = new String[] { "java.lang.String", "long" };

		_methodName17 = "getESFSportTypes";

		_methodParameterTypes17 = new String[] { "int", "int" };

		_methodName18 = "getESFSportTypesCount";

		_methodParameterTypes18 = new String[] {  };

		_methodName19 = "updateESFSportType";

		_methodParameterTypes19 = new String[] {
				"it.ethica.esf.model.ESFSportType"
			};

<<<<<<< HEAD
		_methodName384 = "getBeanIdentifier";

		_methodParameterTypes384 = new String[] {  };

		_methodName385 = "setBeanIdentifier";

		_methodParameterTypes385 = new String[] { "java.lang.String" };

		_methodName390 = "getNational";

		_methodParameterTypes390 = new String[] { "boolean" };

		_methodName391 = "getisOlimpic";

		_methodParameterTypes391 = new String[] { "boolean" };

		_methodName392 = "getAllESFSportTypes";

		_methodParameterTypes392 = new String[] {  };

		_methodName393 = "getAllESFSportTypes";

		_methodParameterTypes393 = new String[] { "int", "int" };

		_methodName394 = "getESFSportTypes";

		_methodParameterTypes394 = new String[] { "long" };

		_methodName395 = "getESFSportTypesIsChangeCategory";

		_methodParameterTypes395 = new String[] { "boolean" };

		_methodName396 = "getESFSportTypes";

		_methodParameterTypes396 = new String[] { "long", "int", "int" };

		_methodName397 = "countByGroupId";

		_methodParameterTypes397 = new String[] { "long" };

		_methodName398 = "findByESFFieldId";

		_methodParameterTypes398 = new String[] { "long" };

		_methodName399 = "findESFSportTypeByName";

		_methodParameterTypes399 = new String[] { "java.lang.String" };

		_methodName400 = "addESFSportType";

		_methodParameterTypes400 = new String[] {
=======
		_methodName376 = "getBeanIdentifier";

		_methodParameterTypes376 = new String[] {  };

		_methodName377 = "setBeanIdentifier";

		_methodParameterTypes377 = new String[] { "java.lang.String" };

		_methodName382 = "getNational";

		_methodParameterTypes382 = new String[] { "boolean" };

		_methodName383 = "getisOlimpic";

		_methodParameterTypes383 = new String[] { "boolean" };

		_methodName384 = "getAllESFSportTypes";

		_methodParameterTypes384 = new String[] {  };

		_methodName385 = "getAllESFSportTypes";

		_methodParameterTypes385 = new String[] { "int", "int" };

		_methodName386 = "getESFSportTypes";

		_methodParameterTypes386 = new String[] { "long" };

		_methodName387 = "getESFSportTypesIsChangeCategory";

		_methodParameterTypes387 = new String[] { "boolean" };

		_methodName388 = "getESFSportTypes";

		_methodParameterTypes388 = new String[] { "long", "int", "int" };

		_methodName389 = "countByGroupId";

		_methodParameterTypes389 = new String[] { "long" };

		_methodName390 = "findByESFFieldId";

		_methodParameterTypes390 = new String[] { "long" };

		_methodName391 = "findESFSportTypeByName";

		_methodParameterTypes391 = new String[] { "java.lang.String" };

		_methodName392 = "addESFSportType";

		_methodParameterTypes392 = new String[] {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
				"long", "java.lang.String", "java.lang.String",
				"java.lang.String", "boolean", "boolean", "boolean",
				"com.liferay.portal.service.ServiceContext"
			};

<<<<<<< HEAD
		_methodName401 = "updateESFSportType";

		_methodParameterTypes401 = new String[] {
=======
		_methodName393 = "updateESFSportType";

		_methodParameterTypes393 = new String[] {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
				"long", "long", "java.lang.String", "java.lang.String",
				"java.lang.String", "boolean", "boolean", "boolean",
				"com.liferay.portal.service.ServiceContext"
			};

<<<<<<< HEAD
		_methodName402 = "deleteESFSportType";

		_methodParameterTypes402 = new String[] {
				"long", "com.liferay.portal.service.ServiceContext"
			};

		_methodName404 = "findIDSportByName";

		_methodParameterTypes404 = new String[] {  };

		_methodName405 = "findIDSportByName";

		_methodParameterTypes405 = new String[] { "java.lang.String" };

		_methodName406 = "findIDSportByCode";

		_methodParameterTypes406 = new String[] { "java.lang.String" };
=======
		_methodName394 = "deleteESFSportType";

		_methodParameterTypes394 = new String[] {
				"long", "com.liferay.portal.service.ServiceContext"
			};

		_methodName396 = "findIDSportByName";

		_methodParameterTypes396 = new String[] {  };

		_methodName397 = "findIDSportByName";

		_methodParameterTypes397 = new String[] { "java.lang.String" };

		_methodName398 = "findIDSportByCode";

		_methodParameterTypes398 = new String[] { "java.lang.String" };
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return ESFSportTypeLocalServiceUtil.addESFSportType((it.ethica.esf.model.ESFSportType)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return ESFSportTypeLocalServiceUtil.createESFSportType(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return ESFSportTypeLocalServiceUtil.deleteESFSportType(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return ESFSportTypeLocalServiceUtil.deleteESFSportType((it.ethica.esf.model.ESFSportType)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return ESFSportTypeLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return ESFSportTypeLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return ESFSportTypeLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return ESFSportTypeLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return ESFSportTypeLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return ESFSportTypeLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return ESFSportTypeLocalServiceUtil.fetchESFSportType(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return ESFSportTypeLocalServiceUtil.fetchESFSportTypeByUuidAndCompanyId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return ESFSportTypeLocalServiceUtil.fetchESFSportTypeByUuidAndGroupId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return ESFSportTypeLocalServiceUtil.getESFSportType(((Long)arguments[0]).longValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return ESFSportTypeLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return ESFSportTypeLocalServiceUtil.getESFSportTypeByUuidAndCompanyId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName16.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes16, parameterTypes)) {
			return ESFSportTypeLocalServiceUtil.getESFSportTypeByUuidAndGroupId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName17.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes17, parameterTypes)) {
			return ESFSportTypeLocalServiceUtil.getESFSportTypes(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName18.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes18, parameterTypes)) {
			return ESFSportTypeLocalServiceUtil.getESFSportTypesCount();
		}

		if (_methodName19.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes19, parameterTypes)) {
			return ESFSportTypeLocalServiceUtil.updateESFSportType((it.ethica.esf.model.ESFSportType)arguments[0]);
		}

<<<<<<< HEAD
		if (_methodName384.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes384, parameterTypes)) {
			return ESFSportTypeLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName385.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes385, parameterTypes)) {
=======
		if (_methodName376.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes376, parameterTypes)) {
			return ESFSportTypeLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName377.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes377, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			ESFSportTypeLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

<<<<<<< HEAD
		if (_methodName390.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes390, parameterTypes)) {
			return ESFSportTypeLocalServiceUtil.getNational(((Boolean)arguments[0]).booleanValue());
		}

		if (_methodName391.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes391, parameterTypes)) {
			return ESFSportTypeLocalServiceUtil.getisOlimpic(((Boolean)arguments[0]).booleanValue());
		}

		if (_methodName392.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes392, parameterTypes)) {
			return ESFSportTypeLocalServiceUtil.getAllESFSportTypes();
		}

		if (_methodName393.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes393, parameterTypes)) {
=======
		if (_methodName382.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes382, parameterTypes)) {
			return ESFSportTypeLocalServiceUtil.getNational(((Boolean)arguments[0]).booleanValue());
		}

		if (_methodName383.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes383, parameterTypes)) {
			return ESFSportTypeLocalServiceUtil.getisOlimpic(((Boolean)arguments[0]).booleanValue());
		}

		if (_methodName384.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes384, parameterTypes)) {
			return ESFSportTypeLocalServiceUtil.getAllESFSportTypes();
		}

		if (_methodName385.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes385, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFSportTypeLocalServiceUtil.getAllESFSportTypes(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

<<<<<<< HEAD
		if (_methodName394.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes394, parameterTypes)) {
			return ESFSportTypeLocalServiceUtil.getESFSportTypes(((Long)arguments[0]).longValue());
		}

		if (_methodName395.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes395, parameterTypes)) {
			return ESFSportTypeLocalServiceUtil.getESFSportTypesIsChangeCategory(((Boolean)arguments[0]).booleanValue());
		}

		if (_methodName396.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes396, parameterTypes)) {
=======
		if (_methodName386.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes386, parameterTypes)) {
			return ESFSportTypeLocalServiceUtil.getESFSportTypes(((Long)arguments[0]).longValue());
		}

		if (_methodName387.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes387, parameterTypes)) {
			return ESFSportTypeLocalServiceUtil.getESFSportTypesIsChangeCategory(((Boolean)arguments[0]).booleanValue());
		}

		if (_methodName388.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes388, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFSportTypeLocalServiceUtil.getESFSportTypes(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

<<<<<<< HEAD
		if (_methodName397.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes397, parameterTypes)) {
			return ESFSportTypeLocalServiceUtil.countByGroupId(((Long)arguments[0]).longValue());
		}

		if (_methodName398.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes398, parameterTypes)) {
			return ESFSportTypeLocalServiceUtil.findByESFFieldId(((Long)arguments[0]).longValue());
		}

		if (_methodName399.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes399, parameterTypes)) {
			return ESFSportTypeLocalServiceUtil.findESFSportTypeByName((java.lang.String)arguments[0]);
		}

		if (_methodName400.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes400, parameterTypes)) {
=======
		if (_methodName389.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes389, parameterTypes)) {
			return ESFSportTypeLocalServiceUtil.countByGroupId(((Long)arguments[0]).longValue());
		}

		if (_methodName390.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes390, parameterTypes)) {
			return ESFSportTypeLocalServiceUtil.findByESFFieldId(((Long)arguments[0]).longValue());
		}

		if (_methodName391.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes391, parameterTypes)) {
			return ESFSportTypeLocalServiceUtil.findESFSportTypeByName((java.lang.String)arguments[0]);
		}

		if (_methodName392.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes392, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFSportTypeLocalServiceUtil.addESFSportType(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3],
				((Boolean)arguments[4]).booleanValue(),
				((Boolean)arguments[5]).booleanValue(),
				((Boolean)arguments[6]).booleanValue(),
				(com.liferay.portal.service.ServiceContext)arguments[7]);
		}

<<<<<<< HEAD
		if (_methodName401.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes401, parameterTypes)) {
=======
		if (_methodName393.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes393, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFSportTypeLocalServiceUtil.updateESFSportType(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3],
				(java.lang.String)arguments[4],
				((Boolean)arguments[5]).booleanValue(),
				((Boolean)arguments[6]).booleanValue(),
				((Boolean)arguments[7]).booleanValue(),
				(com.liferay.portal.service.ServiceContext)arguments[8]);
		}

<<<<<<< HEAD
		if (_methodName402.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes402, parameterTypes)) {
=======
		if (_methodName394.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes394, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFSportTypeLocalServiceUtil.deleteESFSportType(((Long)arguments[0]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[1]);
		}

<<<<<<< HEAD
		if (_methodName404.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes404, parameterTypes)) {
			return ESFSportTypeLocalServiceUtil.findIDSportByName();
		}

		if (_methodName405.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes405, parameterTypes)) {
			return ESFSportTypeLocalServiceUtil.findIDSportByName((java.lang.String)arguments[0]);
		}

		if (_methodName406.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes406, parameterTypes)) {
=======
		if (_methodName396.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes396, parameterTypes)) {
			return ESFSportTypeLocalServiceUtil.findIDSportByName();
		}

		if (_methodName397.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes397, parameterTypes)) {
			return ESFSportTypeLocalServiceUtil.findIDSportByName((java.lang.String)arguments[0]);
		}

		if (_methodName398.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes398, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFSportTypeLocalServiceUtil.findIDSportByCode((java.lang.String)arguments[0]);
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
	private String _methodName376;
	private String[] _methodParameterTypes376;
	private String _methodName377;
	private String[] _methodParameterTypes377;
	private String _methodName382;
	private String[] _methodParameterTypes382;
	private String _methodName383;
	private String[] _methodParameterTypes383;
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
	private String _methodName384;
	private String[] _methodParameterTypes384;
	private String _methodName385;
	private String[] _methodParameterTypes385;
	private String _methodName390;
	private String[] _methodParameterTypes390;
	private String _methodName391;
	private String[] _methodParameterTypes391;
	private String _methodName392;
	private String[] _methodParameterTypes392;
	private String _methodName393;
	private String[] _methodParameterTypes393;
	private String _methodName394;
	private String[] _methodParameterTypes394;
<<<<<<< HEAD
	private String _methodName395;
	private String[] _methodParameterTypes395;
=======
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
	private String _methodName396;
	private String[] _methodParameterTypes396;
	private String _methodName397;
	private String[] _methodParameterTypes397;
	private String _methodName398;
	private String[] _methodParameterTypes398;
<<<<<<< HEAD
	private String _methodName399;
	private String[] _methodParameterTypes399;
	private String _methodName400;
	private String[] _methodParameterTypes400;
	private String _methodName401;
	private String[] _methodParameterTypes401;
	private String _methodName402;
	private String[] _methodParameterTypes402;
	private String _methodName404;
	private String[] _methodParameterTypes404;
	private String _methodName405;
	private String[] _methodParameterTypes405;
	private String _methodName406;
	private String[] _methodParameterTypes406;
=======
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
}