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

import it.ethica.esf.service.ESFNationalLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Ethica
 * @generated
 */
public class ESFNationalLocalServiceClpInvoker {
	public ESFNationalLocalServiceClpInvoker() {
		_methodName0 = "addESFNational";

		_methodParameterTypes0 = new String[] { "it.ethica.esf.model.ESFNational" };

		_methodName1 = "createESFNational";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteESFNational";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteESFNational";

		_methodParameterTypes3 = new String[] { "it.ethica.esf.model.ESFNational" };

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

		_methodName10 = "fetchESFNational";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getESFNational";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getESFNationals";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getESFNationalsCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateESFNational";

		_methodParameterTypes15 = new String[] { "it.ethica.esf.model.ESFNational" };

		_methodName444 = "getBeanIdentifier";

		_methodParameterTypes444 = new String[] {  };

		_methodName445 = "setBeanIdentifier";

		_methodParameterTypes445 = new String[] { "java.lang.String" };

		_methodName450 = "getActiveESFNationals";

		_methodParameterTypes450 = new String[] { "long", "int", "int" };

		_methodName451 = "getActiveESFNationals";

		_methodParameterTypes451 = new String[] { "int", "int" };

		_methodName452 = "countActiveESFNationals";

		_methodParameterTypes452 = new String[] { "long", "int", "int" };

		_methodName453 = "countActiveESFNationals";

		_methodParameterTypes453 = new String[] {  };

		_methodName454 = "getActiveESFNational";

		_methodParameterTypes454 = new String[] { "long" };

		_methodName455 = "getActiveESFNational_UserId";

		_methodParameterTypes455 = new String[] { "long" };

		_methodName456 = "isActiveESFNationals";

		_methodParameterTypes456 = new String[] { "long" };

		_methodName457 = "addESFNational";

		_methodParameterTypes457 = new String[] {
				"long", "long", "long", "java.util.Date", "java.util.Date",
				"java.util.Date", "com.liferay.portal.service.ServiceContext"
			};

		_methodName458 = "deleteESFNational";

		_methodParameterTypes458 = new String[] {
				"long", "long", "java.util.Date",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName459 = "getEXESFNationalUser";

		_methodParameterTypes459 = new String[] { "long" };

		_methodName460 = "findNationalbySportId_MatchId";

		_methodParameterTypes460 = new String[] { "long", "long", "int", "int" };

		_methodName461 = "countNationalbySportId_MatchId";

		_methodParameterTypes461 = new String[] { "long", "long" };

		_methodName462 = "findNationalFreeMatchIdSportId";

		_methodParameterTypes462 = new String[] { "long", "long", "int", "int" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return ESFNationalLocalServiceUtil.addESFNational((it.ethica.esf.model.ESFNational)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return ESFNationalLocalServiceUtil.createESFNational(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return ESFNationalLocalServiceUtil.deleteESFNational(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return ESFNationalLocalServiceUtil.deleteESFNational((it.ethica.esf.model.ESFNational)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return ESFNationalLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return ESFNationalLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return ESFNationalLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return ESFNationalLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return ESFNationalLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return ESFNationalLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return ESFNationalLocalServiceUtil.fetchESFNational(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return ESFNationalLocalServiceUtil.getESFNational(((Long)arguments[0]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return ESFNationalLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return ESFNationalLocalServiceUtil.getESFNationals(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return ESFNationalLocalServiceUtil.getESFNationalsCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return ESFNationalLocalServiceUtil.updateESFNational((it.ethica.esf.model.ESFNational)arguments[0]);
		}

		if (_methodName444.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes444, parameterTypes)) {
			return ESFNationalLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName445.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes445, parameterTypes)) {
			ESFNationalLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName450.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes450, parameterTypes)) {
			return ESFNationalLocalServiceUtil.getActiveESFNationals(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName451.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes451, parameterTypes)) {
			return ESFNationalLocalServiceUtil.getActiveESFNationals(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName452.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes452, parameterTypes)) {
			return ESFNationalLocalServiceUtil.countActiveESFNationals(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName453.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes453, parameterTypes)) {
			return ESFNationalLocalServiceUtil.countActiveESFNationals();
		}

		if (_methodName454.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes454, parameterTypes)) {
			return ESFNationalLocalServiceUtil.getActiveESFNational(((Long)arguments[0]).longValue());
		}

		if (_methodName455.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes455, parameterTypes)) {
			return ESFNationalLocalServiceUtil.getActiveESFNational_UserId(((Long)arguments[0]).longValue());
		}

		if (_methodName456.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes456, parameterTypes)) {
			return ESFNationalLocalServiceUtil.isActiveESFNationals(((Long)arguments[0]).longValue());
		}

		if (_methodName457.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes457, parameterTypes)) {
			return ESFNationalLocalServiceUtil.addESFNational(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(), (java.util.Date)arguments[3],
				(java.util.Date)arguments[4], (java.util.Date)arguments[5],
				(com.liferay.portal.service.ServiceContext)arguments[6]);
		}

		if (_methodName458.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes458, parameterTypes)) {
			return ESFNationalLocalServiceUtil.deleteESFNational(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(), (java.util.Date)arguments[2],
				(com.liferay.portal.service.ServiceContext)arguments[3]);
		}

		if (_methodName459.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes459, parameterTypes)) {
			return ESFNationalLocalServiceUtil.getEXESFNationalUser(((Long)arguments[0]).longValue());
		}

		if (_methodName460.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes460, parameterTypes)) {
			return ESFNationalLocalServiceUtil.findNationalbySportId_MatchId(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName461.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes461, parameterTypes)) {
			return ESFNationalLocalServiceUtil.countNationalbySportId_MatchId(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName462.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes462, parameterTypes)) {
			return ESFNationalLocalServiceUtil.findNationalFreeMatchIdSportId(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
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
	private String _methodName460;
	private String[] _methodParameterTypes460;
	private String _methodName461;
	private String[] _methodParameterTypes461;
	private String _methodName462;
	private String[] _methodParameterTypes462;
}