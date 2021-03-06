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

import it.ethica.esf.service.ESFPartecipantInfoLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Ethica
 * @generated
 */
public class ESFPartecipantInfoLocalServiceClpInvoker {
	public ESFPartecipantInfoLocalServiceClpInvoker() {
		_methodName0 = "addESFPartecipantInfo";

		_methodParameterTypes0 = new String[] {
				"it.ethica.esf.model.ESFPartecipantInfo"
			};

		_methodName1 = "createESFPartecipantInfo";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteESFPartecipantInfo";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteESFPartecipantInfo";

		_methodParameterTypes3 = new String[] {
				"it.ethica.esf.model.ESFPartecipantInfo"
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

		_methodName10 = "fetchESFPartecipantInfo";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getESFPartecipantInfo";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getESFPartecipantInfos";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getESFPartecipantInfosCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateESFPartecipantInfo";

		_methodParameterTypes15 = new String[] {
				"it.ethica.esf.model.ESFPartecipantInfo"
			};

		_methodName444 = "getBeanIdentifier";

		_methodParameterTypes444 = new String[] {  };

		_methodName445 = "setBeanIdentifier";

		_methodParameterTypes445 = new String[] { "java.lang.String" };

		_methodName450 = "getESFPartecipantInfosByFirstName_L_P";

		_methodParameterTypes450 = new String[] {
				"java.lang.String", "java.lang.String", "long"
			};

		_methodName451 = "getESFPartecipantInfosByFirstName_L_P";

		_methodParameterTypes451 = new String[] {
				"java.lang.String", "java.lang.String", "long", "int", "int"
			};

		_methodName452 = "updateESFPartecipantInfo";

		_methodParameterTypes452 = new String[] {
				"long", "long", "long", "long", "java.lang.String", "boolean",
				"long", "long", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.util.Date", "java.lang.String",
				"java.lang.String", "int", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.util.Date", "java.util.Date", "java.lang.String",
				"java.util.Date", "java.util.Date", "java.lang.String",
				"java.util.Date", "java.util.Date", "java.lang.String",
				"java.lang.String", "java.lang.String", "double",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "double", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"long", "long", "long", "long", "long"
			};

		_methodName453 = "addESFPartecipantInfo";

		_methodParameterTypes453 = new String[] {
				"long", "long", "long", "java.lang.String", "java.util.Date",
				"boolean", "long", "long", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.util.Date",
				"java.lang.String", "java.lang.String", "int",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.util.Date", "java.util.Date",
				"java.lang.String", "java.util.Date", "java.util.Date",
				"java.lang.String", "java.util.Date", "java.util.Date",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"double", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "double",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "long", "long", "long", "long", "long"
			};

		_methodName454 = "addESFPartecipantInfoAndReturnId";

		_methodParameterTypes454 = new String[] {
				"long", "long", "long", "java.lang.String", "java.util.Date",
				"boolean", "long", "long", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.util.Date",
				"java.lang.String", "java.lang.String", "int",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.util.Date", "java.util.Date",
				"java.lang.String", "java.util.Date", "java.util.Date",
				"java.lang.String", "java.util.Date", "java.util.Date",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"double", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "double",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "long", "long", "long", "long", "long"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return ESFPartecipantInfoLocalServiceUtil.addESFPartecipantInfo((it.ethica.esf.model.ESFPartecipantInfo)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return ESFPartecipantInfoLocalServiceUtil.createESFPartecipantInfo(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return ESFPartecipantInfoLocalServiceUtil.deleteESFPartecipantInfo(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return ESFPartecipantInfoLocalServiceUtil.deleteESFPartecipantInfo((it.ethica.esf.model.ESFPartecipantInfo)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return ESFPartecipantInfoLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return ESFPartecipantInfoLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return ESFPartecipantInfoLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return ESFPartecipantInfoLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return ESFPartecipantInfoLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return ESFPartecipantInfoLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return ESFPartecipantInfoLocalServiceUtil.fetchESFPartecipantInfo(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return ESFPartecipantInfoLocalServiceUtil.getESFPartecipantInfo(((Long)arguments[0]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return ESFPartecipantInfoLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return ESFPartecipantInfoLocalServiceUtil.getESFPartecipantInfos(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return ESFPartecipantInfoLocalServiceUtil.getESFPartecipantInfosCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return ESFPartecipantInfoLocalServiceUtil.updateESFPartecipantInfo((it.ethica.esf.model.ESFPartecipantInfo)arguments[0]);
		}

		if (_methodName444.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes444, parameterTypes)) {
			return ESFPartecipantInfoLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName445.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes445, parameterTypes)) {
			ESFPartecipantInfoLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName450.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes450, parameterTypes)) {
			return ESFPartecipantInfoLocalServiceUtil.getESFPartecipantInfosByFirstName_L_P((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], ((Long)arguments[2]).longValue());
		}

		if (_methodName451.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes451, parameterTypes)) {
			return ESFPartecipantInfoLocalServiceUtil.getESFPartecipantInfosByFirstName_L_P((java.lang.String)arguments[0],
				(java.lang.String)arguments[1],
				((Long)arguments[2]).longValue(),
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue());
		}

		if (_methodName452.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes452, parameterTypes)) {
			ESFPartecipantInfoLocalServiceUtil.updateESFPartecipantInfo(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue(),
				(java.lang.String)arguments[4],
				((Boolean)arguments[5]).booleanValue(),
				((Long)arguments[6]).longValue(),
				((Long)arguments[7]).longValue(),
				(java.lang.String)arguments[8], (java.lang.String)arguments[9],
				(java.lang.String)arguments[10], (java.util.Date)arguments[11],
				(java.lang.String)arguments[12],
				(java.lang.String)arguments[13],
				((Integer)arguments[14]).intValue(),
				(java.lang.String)arguments[15],
				(java.lang.String)arguments[16],
				(java.lang.String)arguments[17],
				(java.lang.String)arguments[18],
				(java.lang.String)arguments[19],
				(java.lang.String)arguments[20],
				(java.lang.String)arguments[21], (java.util.Date)arguments[22],
				(java.util.Date)arguments[23], (java.lang.String)arguments[24],
				(java.util.Date)arguments[25], (java.util.Date)arguments[26],
				(java.lang.String)arguments[27], (java.util.Date)arguments[28],
				(java.util.Date)arguments[29], (java.lang.String)arguments[30],
				(java.lang.String)arguments[31],
				(java.lang.String)arguments[32],
				((Double)arguments[33]).doubleValue(),
				(java.lang.String)arguments[34],
				(java.lang.String)arguments[35],
				(java.lang.String)arguments[36],
				(java.lang.String)arguments[37],
				((Double)arguments[38]).doubleValue(),
				(java.lang.String)arguments[39],
				(java.lang.String)arguments[40],
				(java.lang.String)arguments[41],
				(java.lang.String)arguments[42],
				((Long)arguments[43]).longValue(),
				((Long)arguments[44]).longValue(),
				((Long)arguments[45]).longValue(),
				((Long)arguments[46]).longValue(),
				((Long)arguments[47]).longValue());

			return null;
		}

		if (_methodName453.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes453, parameterTypes)) {
			ESFPartecipantInfoLocalServiceUtil.addESFPartecipantInfo(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				(java.lang.String)arguments[3], (java.util.Date)arguments[4],
				((Boolean)arguments[5]).booleanValue(),
				((Long)arguments[6]).longValue(),
				((Long)arguments[7]).longValue(),
				(java.lang.String)arguments[8], (java.lang.String)arguments[9],
				(java.lang.String)arguments[10], (java.util.Date)arguments[11],
				(java.lang.String)arguments[12],
				(java.lang.String)arguments[13],
				((Integer)arguments[14]).intValue(),
				(java.lang.String)arguments[15],
				(java.lang.String)arguments[16],
				(java.lang.String)arguments[17],
				(java.lang.String)arguments[18],
				(java.lang.String)arguments[19],
				(java.lang.String)arguments[20],
				(java.lang.String)arguments[21], (java.util.Date)arguments[22],
				(java.util.Date)arguments[23], (java.lang.String)arguments[24],
				(java.util.Date)arguments[25], (java.util.Date)arguments[26],
				(java.lang.String)arguments[27], (java.util.Date)arguments[28],
				(java.util.Date)arguments[29], (java.lang.String)arguments[30],
				(java.lang.String)arguments[31],
				(java.lang.String)arguments[32],
				((Double)arguments[33]).doubleValue(),
				(java.lang.String)arguments[34],
				(java.lang.String)arguments[35],
				(java.lang.String)arguments[36],
				(java.lang.String)arguments[37],
				((Double)arguments[38]).doubleValue(),
				(java.lang.String)arguments[39],
				(java.lang.String)arguments[40],
				(java.lang.String)arguments[41],
				(java.lang.String)arguments[42],
				((Long)arguments[43]).longValue(),
				((Long)arguments[44]).longValue(),
				((Long)arguments[45]).longValue(),
				((Long)arguments[46]).longValue(),
				((Long)arguments[47]).longValue());

			return null;
		}

		if (_methodName454.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes454, parameterTypes)) {
			return ESFPartecipantInfoLocalServiceUtil.addESFPartecipantInfoAndReturnId(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				(java.lang.String)arguments[3], (java.util.Date)arguments[4],
				((Boolean)arguments[5]).booleanValue(),
				((Long)arguments[6]).longValue(),
				((Long)arguments[7]).longValue(),
				(java.lang.String)arguments[8], (java.lang.String)arguments[9],
				(java.lang.String)arguments[10], (java.util.Date)arguments[11],
				(java.lang.String)arguments[12],
				(java.lang.String)arguments[13],
				((Integer)arguments[14]).intValue(),
				(java.lang.String)arguments[15],
				(java.lang.String)arguments[16],
				(java.lang.String)arguments[17],
				(java.lang.String)arguments[18],
				(java.lang.String)arguments[19],
				(java.lang.String)arguments[20],
				(java.lang.String)arguments[21], (java.util.Date)arguments[22],
				(java.util.Date)arguments[23], (java.lang.String)arguments[24],
				(java.util.Date)arguments[25], (java.util.Date)arguments[26],
				(java.lang.String)arguments[27], (java.util.Date)arguments[28],
				(java.util.Date)arguments[29], (java.lang.String)arguments[30],
				(java.lang.String)arguments[31],
				(java.lang.String)arguments[32],
				((Double)arguments[33]).doubleValue(),
				(java.lang.String)arguments[34],
				(java.lang.String)arguments[35],
				(java.lang.String)arguments[36],
				(java.lang.String)arguments[37],
				((Double)arguments[38]).doubleValue(),
				(java.lang.String)arguments[39],
				(java.lang.String)arguments[40],
				(java.lang.String)arguments[41],
				(java.lang.String)arguments[42],
				((Long)arguments[43]).longValue(),
				((Long)arguments[44]).longValue(),
				((Long)arguments[45]).longValue(),
				((Long)arguments[46]).longValue(),
				((Long)arguments[47]).longValue());
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
	private String _methodName444;
	private String[] _methodParameterTypes444;
	private String _methodName445;
	private String[] _methodParameterTypes445;
	private String _methodName450;
	private String[] _methodParameterTypes450;
	private String _methodName451;
	private String[] _methodParameterTypes451;
	private String _methodName452;
	private String[] _methodParameterTypes452;
	private String _methodName453;
	private String[] _methodParameterTypes453;
	private String _methodName454;
	private String[] _methodParameterTypes454;
}