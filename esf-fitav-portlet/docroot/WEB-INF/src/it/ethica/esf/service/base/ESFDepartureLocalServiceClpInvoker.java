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

import it.ethica.esf.service.ESFDepartureLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Ethica
 * @generated
 */
public class ESFDepartureLocalServiceClpInvoker {
	public ESFDepartureLocalServiceClpInvoker() {
		_methodName0 = "addESFDeparture";

		_methodParameterTypes0 = new String[] { "it.ethica.esf.model.ESFDeparture" };

		_methodName1 = "createESFDeparture";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteESFDeparture";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteESFDeparture";

		_methodParameterTypes3 = new String[] { "it.ethica.esf.model.ESFDeparture" };

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

		_methodName10 = "fetchESFDeparture";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getESFDeparture";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getESFDepartures";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getESFDeparturesCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateESFDeparture";

		_methodParameterTypes15 = new String[] {
				"it.ethica.esf.model.ESFDeparture"
			};

		_methodName444 = "getBeanIdentifier";

		_methodParameterTypes444 = new String[] {  };

		_methodName445 = "setBeanIdentifier";

		_methodParameterTypes445 = new String[] { "java.lang.String" };

		_methodName450 = "addEsfDeparture";

		_methodParameterTypes450 = new String[] {
				"long", "long", "java.lang.String", "long", "long",
				"java.lang.String", "java.util.Date", "java.util.Date",
				"java.util.Date", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"long", "boolean", "java.lang.String", "java.lang.String",
				"java.lang.String"
			};

		_methodName451 = "updateEsfDeparture";

		_methodParameterTypes451 = new String[] {
				"long", "long", "long", "java.lang.String", "long", "long",
				"java.lang.String", "java.util.Date", "java.util.Date",
				"java.lang.String", "java.util.Date", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"long", "boolean", "java.lang.String", "java.lang.String",
				"java.lang.String"
			};

		_methodName452 = "findESFDeparturesByESFMatchId";

		_methodParameterTypes452 = new String[] { "long" };

		_methodName453 = "findESFDeparturesByESFMatchId";

		_methodParameterTypes453 = new String[] { "long", "int", "int" };

		_methodName454 = "findDeparturesByCode";

		_methodParameterTypes454 = new String[] { "java.lang.String" };

		_methodName455 = "findDeparturesByCode";

		_methodParameterTypes455 = new String[] { "java.lang.String", "int", "int" };

		_methodName456 = "getByEsfMatchIdEsfUserId";

		_methodParameterTypes456 = new String[] { "long", "long" };

		_methodName457 = "getByEsfMatchIdEsfUserId";

		_methodParameterTypes457 = new String[] { "long", "long", "int", "int" };

		_methodName458 = "getESFDeparturesByEsfMatchId_F_L_L_C_D";

		_methodParameterTypes458 = new String[] {
				"long", "java.lang.String", "java.util.Date", "java.lang.String",
				"java.lang.String", "java.lang.String"
			};

		_methodName459 = "getESFDeparturesByEsfMatchId_F_L_L_C_D";

		_methodParameterTypes459 = new String[] {
				"long", "java.lang.String", "java.util.Date", "java.lang.String",
				"java.lang.String", "java.lang.String", "int", "int"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return ESFDepartureLocalServiceUtil.addESFDeparture((it.ethica.esf.model.ESFDeparture)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return ESFDepartureLocalServiceUtil.createESFDeparture(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return ESFDepartureLocalServiceUtil.deleteESFDeparture(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return ESFDepartureLocalServiceUtil.deleteESFDeparture((it.ethica.esf.model.ESFDeparture)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return ESFDepartureLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return ESFDepartureLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return ESFDepartureLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return ESFDepartureLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return ESFDepartureLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return ESFDepartureLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return ESFDepartureLocalServiceUtil.fetchESFDeparture(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return ESFDepartureLocalServiceUtil.getESFDeparture(((Long)arguments[0]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return ESFDepartureLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return ESFDepartureLocalServiceUtil.getESFDepartures(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return ESFDepartureLocalServiceUtil.getESFDeparturesCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return ESFDepartureLocalServiceUtil.updateESFDeparture((it.ethica.esf.model.ESFDeparture)arguments[0]);
		}

		if (_methodName444.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes444, parameterTypes)) {
			return ESFDepartureLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName445.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes445, parameterTypes)) {
			ESFDepartureLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName450.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes450, parameterTypes)) {
			return ESFDepartureLocalServiceUtil.addEsfDeparture(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				(java.lang.String)arguments[2],
				((Long)arguments[3]).longValue(),
				((Long)arguments[4]).longValue(),
				(java.lang.String)arguments[5], (java.util.Date)arguments[6],
				(java.util.Date)arguments[7], (java.util.Date)arguments[8],
				(java.lang.String)arguments[9],
				(java.lang.String)arguments[10],
				(java.lang.String)arguments[11],
				(java.lang.String)arguments[12],
				(java.lang.String)arguments[13],
				((Long)arguments[14]).longValue(),
				((Boolean)arguments[15]).booleanValue(),
				(java.lang.String)arguments[16],
				(java.lang.String)arguments[17], (java.lang.String)arguments[18]);
		}

		if (_methodName451.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes451, parameterTypes)) {
			return ESFDepartureLocalServiceUtil.updateEsfDeparture(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				(java.lang.String)arguments[3],
				((Long)arguments[4]).longValue(),
				((Long)arguments[5]).longValue(),
				(java.lang.String)arguments[6], (java.util.Date)arguments[7],
				(java.util.Date)arguments[8], (java.lang.String)arguments[9],
				(java.util.Date)arguments[10], (java.lang.String)arguments[11],
				(java.lang.String)arguments[12],
				(java.lang.String)arguments[13],
				(java.lang.String)arguments[14],
				((Long)arguments[15]).longValue(),
				((Boolean)arguments[16]).booleanValue(),
				(java.lang.String)arguments[17],
				(java.lang.String)arguments[18], (java.lang.String)arguments[19]);
		}

		if (_methodName452.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes452, parameterTypes)) {
			return ESFDepartureLocalServiceUtil.findESFDeparturesByESFMatchId(((Long)arguments[0]).longValue());
		}

		if (_methodName453.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes453, parameterTypes)) {
			return ESFDepartureLocalServiceUtil.findESFDeparturesByESFMatchId(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName454.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes454, parameterTypes)) {
			return ESFDepartureLocalServiceUtil.findDeparturesByCode((java.lang.String)arguments[0]);
		}

		if (_methodName455.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes455, parameterTypes)) {
			return ESFDepartureLocalServiceUtil.findDeparturesByCode((java.lang.String)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName456.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes456, parameterTypes)) {
			return ESFDepartureLocalServiceUtil.getByEsfMatchIdEsfUserId(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName457.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes457, parameterTypes)) {
			return ESFDepartureLocalServiceUtil.getByEsfMatchIdEsfUserId(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName458.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes458, parameterTypes)) {
			return ESFDepartureLocalServiceUtil.getESFDeparturesByEsfMatchId_F_L_L_C_D(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.util.Date)arguments[2],
				(java.lang.String)arguments[3], (java.lang.String)arguments[4],
				(java.lang.String)arguments[5]);
		}

		if (_methodName459.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes459, parameterTypes)) {
			return ESFDepartureLocalServiceUtil.getESFDeparturesByEsfMatchId_F_L_L_C_D(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.util.Date)arguments[2],
				(java.lang.String)arguments[3], (java.lang.String)arguments[4],
				(java.lang.String)arguments[5],
				((Integer)arguments[6]).intValue(),
				((Integer)arguments[7]).intValue());
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
	private String _methodName455;
	private String[] _methodParameterTypes455;
	private String _methodName456;
	private String[] _methodParameterTypes456;
	private String _methodName457;
	private String[] _methodParameterTypes457;
	private String _methodName458;
	private String[] _methodParameterTypes458;
	private String _methodName459;
	private String[] _methodParameterTypes459;
}