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

import it.ethica.esf.service.ESFAddressLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Ethica
 * @generated
 */
public class ESFAddressLocalServiceClpInvoker {
	public ESFAddressLocalServiceClpInvoker() {
		_methodName0 = "addESFAddress";

		_methodParameterTypes0 = new String[] { "it.ethica.esf.model.ESFAddress" };

		_methodName1 = "createESFAddress";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteESFAddress";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteESFAddress";

		_methodParameterTypes3 = new String[] { "it.ethica.esf.model.ESFAddress" };

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

		_methodName10 = "fetchESFAddress";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "fetchESFAddressByUuidAndGroupId";

		_methodParameterTypes11 = new String[] { "java.lang.String", "long" };

		_methodName12 = "getESFAddress";

		_methodParameterTypes12 = new String[] { "long" };

		_methodName13 = "getPersistedModel";

		_methodParameterTypes13 = new String[] { "java.io.Serializable" };

		_methodName14 = "getESFAddressByUuidAndGroupId";

		_methodParameterTypes14 = new String[] { "java.lang.String", "long" };

		_methodName15 = "getESFAddresses";

		_methodParameterTypes15 = new String[] { "int", "int" };

		_methodName16 = "getESFAddressesCount";

		_methodParameterTypes16 = new String[] {  };

		_methodName17 = "updateESFAddress";

		_methodParameterTypes17 = new String[] { "it.ethica.esf.model.ESFAddress" };

<<<<<<< HEAD
		_methodName398 = "getBeanIdentifier";

		_methodParameterTypes398 = new String[] {  };

		_methodName399 = "setBeanIdentifier";

		_methodParameterTypes399 = new String[] { "java.lang.String" };

		_methodName404 = "newESFAddress";

		_methodParameterTypes404 = new String[] {  };

		_methodName405 = "findByL_L";

		_methodParameterTypes405 = new String[] { "double", "double" };

		_methodName406 = "getESFAddresses";

		_methodParameterTypes406 = new String[] {
				"long", "java.lang.String", "long"
			};

		_methodName407 = "getNameRegion";

		_methodParameterTypes407 = new String[] { "java.lang.String" };

		_methodName408 = "getNameProvince";

		_methodParameterTypes408 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName409 = "getNameCity";

		_methodParameterTypes409 = new String[] {
				"java.lang.String", "java.lang.String", "long"
			};

		_methodName410 = "findAllCountry";

		_methodParameterTypes410 = new String[] {  };

		_methodName411 = "findAllCountry";

		_methodParameterTypes411 = new String[] { "int", "int" };

		_methodName412 = "findAllRegions";

		_methodParameterTypes412 = new String[] {  };

		_methodName413 = "findByCountry";

		_methodParameterTypes413 = new String[] { "java.lang.String" };

		_methodName414 = "findByCountry";

		_methodParameterTypes414 = new String[] { "java.lang.String", "int", "int" };

		_methodName415 = "findByC_R";

		_methodParameterTypes415 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName416 = "findByC_R";

		_methodParameterTypes416 = new String[] {
				"java.lang.String", "java.lang.String", "int", "int"
			};

		_methodName417 = "findByC_R_P";

		_methodParameterTypes417 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String"
			};

		_methodName418 = "findByC_R_P";

		_methodParameterTypes418 = new String[] {
=======
		_methodName390 = "getBeanIdentifier";

		_methodParameterTypes390 = new String[] {  };

		_methodName391 = "setBeanIdentifier";

		_methodParameterTypes391 = new String[] { "java.lang.String" };

		_methodName396 = "newESFAddress";

		_methodParameterTypes396 = new String[] {  };

		_methodName397 = "findByL_L";

		_methodParameterTypes397 = new String[] { "double", "double" };

		_methodName398 = "getESFAddresses";

		_methodParameterTypes398 = new String[] {
				"long", "java.lang.String", "long"
			};

		_methodName399 = "getNameRegion";

		_methodParameterTypes399 = new String[] { "java.lang.String" };

		_methodName400 = "getNameProvince";

		_methodParameterTypes400 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName401 = "getNameCity";

		_methodParameterTypes401 = new String[] {
				"java.lang.String", "java.lang.String", "long"
			};

		_methodName402 = "findAllCountry";

		_methodParameterTypes402 = new String[] {  };

		_methodName403 = "findAllCountry";

		_methodParameterTypes403 = new String[] { "int", "int" };

		_methodName404 = "findAllRegions";

		_methodParameterTypes404 = new String[] {  };

		_methodName405 = "findByCountry";

		_methodParameterTypes405 = new String[] { "java.lang.String" };

		_methodName406 = "findByCountry";

		_methodParameterTypes406 = new String[] { "java.lang.String", "int", "int" };

		_methodName407 = "findByC_R";

		_methodParameterTypes407 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName408 = "findByC_R";

		_methodParameterTypes408 = new String[] {
				"java.lang.String", "java.lang.String", "int", "int"
			};

		_methodName409 = "findByC_R_P";

		_methodParameterTypes409 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String"
			};

		_methodName410 = "findByC_R_P";

		_methodParameterTypes410 = new String[] {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
				"java.lang.String", "java.lang.String", "java.lang.String",
				"int", "int"
			};

<<<<<<< HEAD
		_methodName419 = "addESFAddress";

		_methodParameterTypes419 = new String[] {
=======
		_methodName411 = "addESFAddress";

		_methodParameterTypes411 = new String[] {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
				"long", "double", "java.lang.String", "java.lang.String",
				"java.lang.String", "long", "double", "java.lang.String", "int",
				"java.lang.String", "long", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"int", "boolean", "boolean", "boolean",
				"com.liferay.portal.service.ServiceContext"
			};

<<<<<<< HEAD
		_methodName420 = "updateESFAddress";

		_methodParameterTypes420 = new String[] {
=======
		_methodName412 = "updateESFAddress";

		_methodParameterTypes412 = new String[] {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
				"long", "long", "java.lang.String", "java.lang.String",
				"java.lang.String", "long", "double", "double",
				"java.lang.String", "int", "java.lang.String", "long",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "int", "boolean", "boolean", "boolean",
				"com.liferay.portal.service.ServiceContext"
			};

<<<<<<< HEAD
		_methodName421 = "deleteESFAddress";

		_methodParameterTypes421 = new String[] {
=======
		_methodName413 = "deleteESFAddress";

		_methodParameterTypes413 = new String[] {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
				"long", "com.liferay.portal.service.ServiceContext"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return ESFAddressLocalServiceUtil.addESFAddress((it.ethica.esf.model.ESFAddress)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return ESFAddressLocalServiceUtil.createESFAddress(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return ESFAddressLocalServiceUtil.deleteESFAddress(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return ESFAddressLocalServiceUtil.deleteESFAddress((it.ethica.esf.model.ESFAddress)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return ESFAddressLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return ESFAddressLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return ESFAddressLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return ESFAddressLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return ESFAddressLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return ESFAddressLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return ESFAddressLocalServiceUtil.fetchESFAddress(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return ESFAddressLocalServiceUtil.fetchESFAddressByUuidAndGroupId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return ESFAddressLocalServiceUtil.getESFAddress(((Long)arguments[0]).longValue());
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return ESFAddressLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return ESFAddressLocalServiceUtil.getESFAddressByUuidAndGroupId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return ESFAddressLocalServiceUtil.getESFAddresses(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName16.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes16, parameterTypes)) {
			return ESFAddressLocalServiceUtil.getESFAddressesCount();
		}

		if (_methodName17.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes17, parameterTypes)) {
			return ESFAddressLocalServiceUtil.updateESFAddress((it.ethica.esf.model.ESFAddress)arguments[0]);
		}

<<<<<<< HEAD
		if (_methodName398.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes398, parameterTypes)) {
			return ESFAddressLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName399.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes399, parameterTypes)) {
=======
		if (_methodName390.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes390, parameterTypes)) {
			return ESFAddressLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName391.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes391, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			ESFAddressLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

<<<<<<< HEAD
		if (_methodName404.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes404, parameterTypes)) {
			return ESFAddressLocalServiceUtil.newESFAddress();
		}

		if (_methodName405.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes405, parameterTypes)) {
=======
		if (_methodName396.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes396, parameterTypes)) {
			return ESFAddressLocalServiceUtil.newESFAddress();
		}

		if (_methodName397.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes397, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFAddressLocalServiceUtil.findByL_L(((Double)arguments[0]).doubleValue(),
				((Double)arguments[1]).doubleValue());
		}

<<<<<<< HEAD
		if (_methodName406.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes406, parameterTypes)) {
=======
		if (_methodName398.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes398, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFAddressLocalServiceUtil.getESFAddresses(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], ((Long)arguments[2]).longValue());
		}

<<<<<<< HEAD
		if (_methodName407.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes407, parameterTypes)) {
			return ESFAddressLocalServiceUtil.getNameRegion((java.lang.String)arguments[0]);
		}

		if (_methodName408.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes408, parameterTypes)) {
=======
		if (_methodName399.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes399, parameterTypes)) {
			return ESFAddressLocalServiceUtil.getNameRegion((java.lang.String)arguments[0]);
		}

		if (_methodName400.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes400, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFAddressLocalServiceUtil.getNameProvince((java.lang.String)arguments[0],
				(java.lang.String)arguments[1]);
		}

<<<<<<< HEAD
		if (_methodName409.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes409, parameterTypes)) {
=======
		if (_methodName401.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes401, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFAddressLocalServiceUtil.getNameCity((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], ((Long)arguments[2]).longValue());
		}

<<<<<<< HEAD
		if (_methodName410.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes410, parameterTypes)) {
			return ESFAddressLocalServiceUtil.findAllCountry();
		}

		if (_methodName411.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes411, parameterTypes)) {
=======
		if (_methodName402.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes402, parameterTypes)) {
			return ESFAddressLocalServiceUtil.findAllCountry();
		}

		if (_methodName403.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes403, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFAddressLocalServiceUtil.findAllCountry(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

<<<<<<< HEAD
		if (_methodName412.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes412, parameterTypes)) {
			return ESFAddressLocalServiceUtil.findAllRegions();
		}

		if (_methodName413.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes413, parameterTypes)) {
			return ESFAddressLocalServiceUtil.findByCountry((java.lang.String)arguments[0]);
		}

		if (_methodName414.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes414, parameterTypes)) {
=======
		if (_methodName404.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes404, parameterTypes)) {
			return ESFAddressLocalServiceUtil.findAllRegions();
		}

		if (_methodName405.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes405, parameterTypes)) {
			return ESFAddressLocalServiceUtil.findByCountry((java.lang.String)arguments[0]);
		}

		if (_methodName406.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes406, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFAddressLocalServiceUtil.findByCountry((java.lang.String)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

<<<<<<< HEAD
		if (_methodName415.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes415, parameterTypes)) {
=======
		if (_methodName407.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes407, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFAddressLocalServiceUtil.findByC_R((java.lang.String)arguments[0],
				(java.lang.String)arguments[1]);
		}

<<<<<<< HEAD
		if (_methodName416.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes416, parameterTypes)) {
=======
		if (_methodName408.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes408, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFAddressLocalServiceUtil.findByC_R((java.lang.String)arguments[0],
				(java.lang.String)arguments[1],
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

<<<<<<< HEAD
		if (_methodName417.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes417, parameterTypes)) {
=======
		if (_methodName409.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes409, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFAddressLocalServiceUtil.findByC_R_P((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2]);
		}

<<<<<<< HEAD
		if (_methodName418.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes418, parameterTypes)) {
=======
		if (_methodName410.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes410, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFAddressLocalServiceUtil.findByC_R_P((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue());
		}

<<<<<<< HEAD
		if (_methodName419.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes419, parameterTypes)) {
=======
		if (_methodName411.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes411, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFAddressLocalServiceUtil.addESFAddress(((Long)arguments[0]).longValue(),
				((Double)arguments[1]).doubleValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3],
				(java.lang.String)arguments[4],
				((Long)arguments[5]).longValue(),
				((Double)arguments[6]).doubleValue(),
				(java.lang.String)arguments[7],
				((Integer)arguments[8]).intValue(),
				(java.lang.String)arguments[9],
				((Long)arguments[10]).longValue(),
				(java.lang.String)arguments[11],
				(java.lang.String)arguments[12],
				(java.lang.String)arguments[13],
				(java.lang.String)arguments[14],
				((Integer)arguments[15]).intValue(),
				((Boolean)arguments[16]).booleanValue(),
				((Boolean)arguments[17]).booleanValue(),
				((Boolean)arguments[18]).booleanValue(),
				(com.liferay.portal.service.ServiceContext)arguments[19]);
		}

<<<<<<< HEAD
		if (_methodName420.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes420, parameterTypes)) {
=======
		if (_methodName412.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes412, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFAddressLocalServiceUtil.updateESFAddress(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3],
				(java.lang.String)arguments[4],
				((Long)arguments[5]).longValue(),
				((Double)arguments[6]).doubleValue(),
				((Double)arguments[7]).doubleValue(),
				(java.lang.String)arguments[8],
				((Integer)arguments[9]).intValue(),
				(java.lang.String)arguments[10],
				((Long)arguments[11]).longValue(),
				(java.lang.String)arguments[12],
				(java.lang.String)arguments[13],
				(java.lang.String)arguments[14],
				(java.lang.String)arguments[15],
				((Integer)arguments[16]).intValue(),
				((Boolean)arguments[17]).booleanValue(),
				((Boolean)arguments[18]).booleanValue(),
				((Boolean)arguments[19]).booleanValue(),
				(com.liferay.portal.service.ServiceContext)arguments[20]);
		}

<<<<<<< HEAD
		if (_methodName421.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes421, parameterTypes)) {
=======
		if (_methodName413.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes413, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFAddressLocalServiceUtil.deleteESFAddress(((Long)arguments[0]).longValue(),
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
<<<<<<< HEAD
=======
	private String _methodName390;
	private String[] _methodParameterTypes390;
	private String _methodName391;
	private String[] _methodParameterTypes391;
	private String _methodName396;
	private String[] _methodParameterTypes396;
	private String _methodName397;
	private String[] _methodParameterTypes397;
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
	private String _methodName398;
	private String[] _methodParameterTypes398;
	private String _methodName399;
	private String[] _methodParameterTypes399;
	private String _methodName404;
	private String[] _methodParameterTypes404;
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
	private String _methodName411;
	private String[] _methodParameterTypes411;
	private String _methodName412;
	private String[] _methodParameterTypes412;
	private String _methodName413;
	private String[] _methodParameterTypes413;
<<<<<<< HEAD
	private String _methodName414;
	private String[] _methodParameterTypes414;
	private String _methodName415;
	private String[] _methodParameterTypes415;
	private String _methodName416;
	private String[] _methodParameterTypes416;
	private String _methodName417;
	private String[] _methodParameterTypes417;
	private String _methodName418;
	private String[] _methodParameterTypes418;
	private String _methodName419;
	private String[] _methodParameterTypes419;
	private String _methodName420;
	private String[] _methodParameterTypes420;
	private String _methodName421;
	private String[] _methodParameterTypes421;
=======
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
}