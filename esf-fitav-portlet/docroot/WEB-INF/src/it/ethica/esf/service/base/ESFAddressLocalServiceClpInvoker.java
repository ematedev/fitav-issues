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

		_methodName462 = "getBeanIdentifier";

		_methodParameterTypes462 = new String[] {  };

		_methodName463 = "setBeanIdentifier";

		_methodParameterTypes463 = new String[] { "java.lang.String" };

		_methodName468 = "newESFAddress";

		_methodParameterTypes468 = new String[] {  };

		_methodName469 = "findByL_L";

		_methodParameterTypes469 = new String[] { "double", "double" };

		_methodName470 = "getESFAddresses";

		_methodParameterTypes470 = new String[] {
				"long", "java.lang.String", "long"
			};

		_methodName471 = "getNameRegion";

		_methodParameterTypes471 = new String[] { "java.lang.String" };

		_methodName472 = "getNameProvince";

		_methodParameterTypes472 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName473 = "getNameCity";

		_methodParameterTypes473 = new String[] {
				"java.lang.String", "java.lang.String", "long"
			};

		_methodName474 = "findAllCountry";

		_methodParameterTypes474 = new String[] {  };

		_methodName475 = "findAllCountry";

		_methodParameterTypes475 = new String[] { "int", "int" };

		_methodName476 = "findAllRegions";

		_methodParameterTypes476 = new String[] {  };

		_methodName477 = "findByCountry";

		_methodParameterTypes477 = new String[] { "java.lang.String" };

		_methodName478 = "findByCountry";

		_methodParameterTypes478 = new String[] { "java.lang.String", "int", "int" };

		_methodName479 = "findByC_R";

		_methodParameterTypes479 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName480 = "findByC_R";

		_methodParameterTypes480 = new String[] {
				"java.lang.String", "java.lang.String", "int", "int"
			};

		_methodName481 = "findByC_R_P";

		_methodParameterTypes481 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String"
			};

		_methodName482 = "findByC_R_P";

		_methodParameterTypes482 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"int", "int"
			};

		_methodName483 = "addESFAddress";

		_methodParameterTypes483 = new String[] {
				"long", "double", "java.lang.String", "java.lang.String",
				"java.lang.String", "long", "double", "java.lang.String", "int",
				"java.lang.String", "long", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"int", "boolean", "boolean", "boolean",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName484 = "updateESFAddress";

		_methodParameterTypes484 = new String[] {
				"long", "long", "java.lang.String", "java.lang.String",
				"java.lang.String", "long", "double", "double",
				"java.lang.String", "int", "java.lang.String", "long",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "int", "boolean", "boolean", "boolean",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName485 = "deleteESFAddress";

		_methodParameterTypes485 = new String[] {
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

		if (_methodName462.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes462, parameterTypes)) {
			return ESFAddressLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName463.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes463, parameterTypes)) {
			ESFAddressLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName468.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes468, parameterTypes)) {
			return ESFAddressLocalServiceUtil.newESFAddress();
		}

		if (_methodName469.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes469, parameterTypes)) {
			return ESFAddressLocalServiceUtil.findByL_L(((Double)arguments[0]).doubleValue(),
				((Double)arguments[1]).doubleValue());
		}

		if (_methodName470.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes470, parameterTypes)) {
			return ESFAddressLocalServiceUtil.getESFAddresses(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], ((Long)arguments[2]).longValue());
		}

		if (_methodName471.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes471, parameterTypes)) {
			return ESFAddressLocalServiceUtil.getNameRegion((java.lang.String)arguments[0]);
		}

		if (_methodName472.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes472, parameterTypes)) {
			return ESFAddressLocalServiceUtil.getNameProvince((java.lang.String)arguments[0],
				(java.lang.String)arguments[1]);
		}

		if (_methodName473.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes473, parameterTypes)) {
			return ESFAddressLocalServiceUtil.getNameCity((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], ((Long)arguments[2]).longValue());
		}

		if (_methodName474.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes474, parameterTypes)) {
			return ESFAddressLocalServiceUtil.findAllCountry();
		}

		if (_methodName475.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes475, parameterTypes)) {
			return ESFAddressLocalServiceUtil.findAllCountry(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName476.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes476, parameterTypes)) {
			return ESFAddressLocalServiceUtil.findAllRegions();
		}

		if (_methodName477.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes477, parameterTypes)) {
			return ESFAddressLocalServiceUtil.findByCountry((java.lang.String)arguments[0]);
		}

		if (_methodName478.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes478, parameterTypes)) {
			return ESFAddressLocalServiceUtil.findByCountry((java.lang.String)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName479.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes479, parameterTypes)) {
			return ESFAddressLocalServiceUtil.findByC_R((java.lang.String)arguments[0],
				(java.lang.String)arguments[1]);
		}

		if (_methodName480.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes480, parameterTypes)) {
			return ESFAddressLocalServiceUtil.findByC_R((java.lang.String)arguments[0],
				(java.lang.String)arguments[1],
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName481.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes481, parameterTypes)) {
			return ESFAddressLocalServiceUtil.findByC_R_P((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2]);
		}

		if (_methodName482.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes482, parameterTypes)) {
			return ESFAddressLocalServiceUtil.findByC_R_P((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue());
		}

		if (_methodName483.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes483, parameterTypes)) {
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

		if (_methodName484.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes484, parameterTypes)) {
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

		if (_methodName485.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes485, parameterTypes)) {
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
	private String _methodName462;
	private String[] _methodParameterTypes462;
	private String _methodName463;
	private String[] _methodParameterTypes463;
	private String _methodName468;
	private String[] _methodParameterTypes468;
	private String _methodName469;
	private String[] _methodParameterTypes469;
	private String _methodName470;
	private String[] _methodParameterTypes470;
	private String _methodName471;
	private String[] _methodParameterTypes471;
	private String _methodName472;
	private String[] _methodParameterTypes472;
	private String _methodName473;
	private String[] _methodParameterTypes473;
	private String _methodName474;
	private String[] _methodParameterTypes474;
	private String _methodName475;
	private String[] _methodParameterTypes475;
	private String _methodName476;
	private String[] _methodParameterTypes476;
	private String _methodName477;
	private String[] _methodParameterTypes477;
	private String _methodName478;
	private String[] _methodParameterTypes478;
	private String _methodName479;
	private String[] _methodParameterTypes479;
	private String _methodName480;
	private String[] _methodParameterTypes480;
	private String _methodName481;
	private String[] _methodParameterTypes481;
	private String _methodName482;
	private String[] _methodParameterTypes482;
	private String _methodName483;
	private String[] _methodParameterTypes483;
	private String _methodName484;
	private String[] _methodParameterTypes484;
	private String _methodName485;
	private String[] _methodParameterTypes485;
}