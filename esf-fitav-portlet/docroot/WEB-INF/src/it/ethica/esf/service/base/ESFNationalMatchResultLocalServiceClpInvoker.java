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

import it.ethica.esf.service.ESFNationalMatchResultLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Ethica
 * @generated
 */
public class ESFNationalMatchResultLocalServiceClpInvoker {
	public ESFNationalMatchResultLocalServiceClpInvoker() {
		_methodName0 = "addESFNationalMatchResult";

		_methodParameterTypes0 = new String[] {
				"it.ethica.esf.model.ESFNationalMatchResult"
			};

		_methodName1 = "createESFNationalMatchResult";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteESFNationalMatchResult";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteESFNationalMatchResult";

		_methodParameterTypes3 = new String[] {
				"it.ethica.esf.model.ESFNationalMatchResult"
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

		_methodName10 = "fetchESFNationalMatchResult";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getESFNationalMatchResult";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getESFNationalMatchResults";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getESFNationalMatchResultsCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateESFNationalMatchResult";

		_methodParameterTypes15 = new String[] {
				"it.ethica.esf.model.ESFNationalMatchResult"
			};

		_methodName400 = "getBeanIdentifier";

		_methodParameterTypes400 = new String[] {  };

		_methodName401 = "setBeanIdentifier";

		_methodParameterTypes401 = new String[] { "java.lang.String" };

		_methodName406 = "getESFNationalMatchResultsByESFMatchId";

		_methodParameterTypes406 = new String[] { "long" };

		_methodName407 = "getESFNationalMatchResultByESFMatchId_ESFUserId";

		_methodParameterTypes407 = new String[] { "long", "long" };

		_methodName408 = "getESFNationalMatchResultByESFMatchId_ESFUserId_SportTypeId";

		_methodParameterTypes408 = new String[] { "long", "long", "long" };

		_methodName409 = "getESFMatchByEsfMatchResultUserId";

		_methodParameterTypes409 = new String[] { "long" };

		_methodName410 = "getESFMatchByEsfMatchId_ESFQualificationId_ESFSportTypeId";

		_methodParameterTypes410 = new String[] { "long", "long", "long" };

		_methodName411 = "getESFMatchByEsfMatchId_ESFSportTypeId";

		_methodParameterTypes411 = new String[] { "long", "long" };

		_methodName412 = "getExternalShooter";

		_methodParameterTypes412 = new String[] { "long" };

		_methodName413 = "getExternalShooterSportType";

		_methodParameterTypes413 = new String[] { "long", "long" };

		_methodName414 = "getNMRByMatchId_UserId";

		_methodParameterTypes414 = new String[] { "long", "long" };

		_methodName415 = "getESFNationalMatchByEsFMatchId";

		_methodParameterTypes415 = new String[] { "long" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return ESFNationalMatchResultLocalServiceUtil.addESFNationalMatchResult((it.ethica.esf.model.ESFNationalMatchResult)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return ESFNationalMatchResultLocalServiceUtil.createESFNationalMatchResult(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return ESFNationalMatchResultLocalServiceUtil.deleteESFNationalMatchResult(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return ESFNationalMatchResultLocalServiceUtil.deleteESFNationalMatchResult((it.ethica.esf.model.ESFNationalMatchResult)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return ESFNationalMatchResultLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return ESFNationalMatchResultLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return ESFNationalMatchResultLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return ESFNationalMatchResultLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return ESFNationalMatchResultLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return ESFNationalMatchResultLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return ESFNationalMatchResultLocalServiceUtil.fetchESFNationalMatchResult(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return ESFNationalMatchResultLocalServiceUtil.getESFNationalMatchResult(((Long)arguments[0]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return ESFNationalMatchResultLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return ESFNationalMatchResultLocalServiceUtil.getESFNationalMatchResults(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return ESFNationalMatchResultLocalServiceUtil.getESFNationalMatchResultsCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return ESFNationalMatchResultLocalServiceUtil.updateESFNationalMatchResult((it.ethica.esf.model.ESFNationalMatchResult)arguments[0]);
		}

		if (_methodName400.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes400, parameterTypes)) {
			return ESFNationalMatchResultLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName401.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes401, parameterTypes)) {
			ESFNationalMatchResultLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName406.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes406, parameterTypes)) {
			return ESFNationalMatchResultLocalServiceUtil.getESFNationalMatchResultsByESFMatchId(((Long)arguments[0]).longValue());
		}

		if (_methodName407.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes407, parameterTypes)) {
			return ESFNationalMatchResultLocalServiceUtil.getESFNationalMatchResultByESFMatchId_ESFUserId(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName408.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes408, parameterTypes)) {
			return ESFNationalMatchResultLocalServiceUtil.getESFNationalMatchResultByESFMatchId_ESFUserId_SportTypeId(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue());
		}

		if (_methodName409.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes409, parameterTypes)) {
			return ESFNationalMatchResultLocalServiceUtil.getESFMatchByEsfMatchResultUserId(((Long)arguments[0]).longValue());
		}

		if (_methodName410.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes410, parameterTypes)) {
			return ESFNationalMatchResultLocalServiceUtil.getESFMatchByEsfMatchId_ESFQualificationId_ESFSportTypeId(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue());
		}

		if (_methodName411.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes411, parameterTypes)) {
			return ESFNationalMatchResultLocalServiceUtil.getESFMatchByEsfMatchId_ESFSportTypeId(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName412.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes412, parameterTypes)) {
			return ESFNationalMatchResultLocalServiceUtil.getExternalShooter(((Long)arguments[0]).longValue());
		}

		if (_methodName413.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes413, parameterTypes)) {
			return ESFNationalMatchResultLocalServiceUtil.getExternalShooterSportType(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName414.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes414, parameterTypes)) {
			return ESFNationalMatchResultLocalServiceUtil.getNMRByMatchId_UserId(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName415.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes415, parameterTypes)) {
			return ESFNationalMatchResultLocalServiceUtil.getESFNationalMatchByEsFMatchId(((Long)arguments[0]).longValue());
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
	private String _methodName400;
	private String[] _methodParameterTypes400;
	private String _methodName401;
	private String[] _methodParameterTypes401;
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
	private String _methodName414;
	private String[] _methodParameterTypes414;
	private String _methodName415;
	private String[] _methodParameterTypes415;
}