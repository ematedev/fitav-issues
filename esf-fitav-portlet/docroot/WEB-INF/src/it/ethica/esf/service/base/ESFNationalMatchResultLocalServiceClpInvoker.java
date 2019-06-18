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

<<<<<<< HEAD
		_methodName392 = "getBeanIdentifier";

		_methodParameterTypes392 = new String[] {  };

		_methodName393 = "setBeanIdentifier";

		_methodParameterTypes393 = new String[] { "java.lang.String" };

		_methodName398 = "getESFNationalMatchResultsByESFMatchId";

		_methodParameterTypes398 = new String[] { "long" };

		_methodName399 = "getESFNationalMatchResultByESFMatchId_ESFUserId";

		_methodParameterTypes399 = new String[] { "long", "long" };

		_methodName400 = "getESFNationalMatchResultByESFMatchId_ESFUserId_SportTypeId";

		_methodParameterTypes400 = new String[] { "long", "long", "long" };

		_methodName401 = "getESFMatchByEsfMatchResultUserId";

		_methodParameterTypes401 = new String[] { "long" };

		_methodName402 = "getESFMatchByEsfMatchId_ESFQualificationId_ESFSportTypeId";

		_methodParameterTypes402 = new String[] { "long", "long", "long" };

		_methodName403 = "getESFMatchByEsfMatchId_ESFSportTypeId";

		_methodParameterTypes403 = new String[] { "long", "long" };

		_methodName404 = "getExternalShooter";

		_methodParameterTypes404 = new String[] { "long" };

		_methodName405 = "getExternalShooterSportType";

		_methodParameterTypes405 = new String[] { "long", "long" };

		_methodName406 = "getNMRByMatchId_UserId";

		_methodParameterTypes406 = new String[] { "long", "long" };

		_methodName407 = "getESFNationalMatchByEsFMatchId";

		_methodParameterTypes407 = new String[] { "long" };
=======
		_methodName386 = "getBeanIdentifier";

		_methodParameterTypes386 = new String[] {  };

		_methodName387 = "setBeanIdentifier";

		_methodParameterTypes387 = new String[] { "java.lang.String" };

		_methodName392 = "getESFNationalMatchResultsByESFMatchId";

		_methodParameterTypes392 = new String[] { "long" };

		_methodName393 = "getESFNationalMatchResultByESFMatchId_ESFUserId";

		_methodParameterTypes393 = new String[] { "long", "long" };

		_methodName394 = "getESFNationalMatchResultByESFMatchId_ESFUserId_SportTypeId";

		_methodParameterTypes394 = new String[] { "long", "long", "long" };

		_methodName395 = "getESFMatchByEsfMatchResultUserId";

		_methodParameterTypes395 = new String[] { "long" };

		_methodName396 = "getESFMatchByEsfMatchId_ESFQualificationId_ESFSportTypeId";

		_methodParameterTypes396 = new String[] { "long", "long", "long" };

		_methodName397 = "getESFMatchByEsfMatchId_ESFSportTypeId";

		_methodParameterTypes397 = new String[] { "long", "long" };

		_methodName398 = "getExternalShooter";

		_methodParameterTypes398 = new String[] { "long" };

		_methodName399 = "getExternalShooterSportType";

		_methodParameterTypes399 = new String[] { "long", "long" };

		_methodName400 = "getNMRByMatchId_UserId";

		_methodParameterTypes400 = new String[] { "long", "long" };

		_methodName401 = "getESFNationalMatchByEsFMatchId";

		_methodParameterTypes401 = new String[] { "long" };
>>>>>>> origin/ID32
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

<<<<<<< HEAD
		if (_methodName392.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes392, parameterTypes)) {
			return ESFNationalMatchResultLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName393.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes393, parameterTypes)) {
=======
		if (_methodName386.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes386, parameterTypes)) {
			return ESFNationalMatchResultLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName387.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes387, parameterTypes)) {
>>>>>>> origin/ID32
			ESFNationalMatchResultLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

<<<<<<< HEAD
		if (_methodName398.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes398, parameterTypes)) {
			return ESFNationalMatchResultLocalServiceUtil.getESFNationalMatchResultsByESFMatchId(((Long)arguments[0]).longValue());
		}

		if (_methodName399.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes399, parameterTypes)) {
=======
		if (_methodName392.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes392, parameterTypes)) {
			return ESFNationalMatchResultLocalServiceUtil.getESFNationalMatchResultsByESFMatchId(((Long)arguments[0]).longValue());
		}

		if (_methodName393.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes393, parameterTypes)) {
>>>>>>> origin/ID32
			return ESFNationalMatchResultLocalServiceUtil.getESFNationalMatchResultByESFMatchId_ESFUserId(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

<<<<<<< HEAD
		if (_methodName400.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes400, parameterTypes)) {
=======
		if (_methodName394.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes394, parameterTypes)) {
>>>>>>> origin/ID32
			return ESFNationalMatchResultLocalServiceUtil.getESFNationalMatchResultByESFMatchId_ESFUserId_SportTypeId(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue());
		}

<<<<<<< HEAD
		if (_methodName401.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes401, parameterTypes)) {
			return ESFNationalMatchResultLocalServiceUtil.getESFMatchByEsfMatchResultUserId(((Long)arguments[0]).longValue());
		}

		if (_methodName402.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes402, parameterTypes)) {
=======
		if (_methodName395.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes395, parameterTypes)) {
			return ESFNationalMatchResultLocalServiceUtil.getESFMatchByEsfMatchResultUserId(((Long)arguments[0]).longValue());
		}

		if (_methodName396.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes396, parameterTypes)) {
>>>>>>> origin/ID32
			return ESFNationalMatchResultLocalServiceUtil.getESFMatchByEsfMatchId_ESFQualificationId_ESFSportTypeId(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue());
		}

<<<<<<< HEAD
		if (_methodName403.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes403, parameterTypes)) {
=======
		if (_methodName397.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes397, parameterTypes)) {
>>>>>>> origin/ID32
			return ESFNationalMatchResultLocalServiceUtil.getESFMatchByEsfMatchId_ESFSportTypeId(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

<<<<<<< HEAD
		if (_methodName404.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes404, parameterTypes)) {
			return ESFNationalMatchResultLocalServiceUtil.getExternalShooter(((Long)arguments[0]).longValue());
		}

		if (_methodName405.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes405, parameterTypes)) {
=======
		if (_methodName398.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes398, parameterTypes)) {
			return ESFNationalMatchResultLocalServiceUtil.getExternalShooter(((Long)arguments[0]).longValue());
		}

		if (_methodName399.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes399, parameterTypes)) {
>>>>>>> origin/ID32
			return ESFNationalMatchResultLocalServiceUtil.getExternalShooterSportType(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

<<<<<<< HEAD
		if (_methodName406.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes406, parameterTypes)) {
=======
		if (_methodName400.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes400, parameterTypes)) {
>>>>>>> origin/ID32
			return ESFNationalMatchResultLocalServiceUtil.getNMRByMatchId_UserId(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

<<<<<<< HEAD
		if (_methodName407.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes407, parameterTypes)) {
=======
		if (_methodName401.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes401, parameterTypes)) {
>>>>>>> origin/ID32
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
<<<<<<< HEAD
=======
	private String _methodName386;
	private String[] _methodParameterTypes386;
	private String _methodName387;
	private String[] _methodParameterTypes387;
>>>>>>> origin/ID32
	private String _methodName392;
	private String[] _methodParameterTypes392;
	private String _methodName393;
	private String[] _methodParameterTypes393;
	private String _methodName398;
	private String[] _methodParameterTypes398;
	private String _methodName399;
	private String[] _methodParameterTypes399;
	private String _methodName400;
	private String[] _methodParameterTypes400;
	private String _methodName401;
	private String[] _methodParameterTypes401;
<<<<<<< HEAD
	private String _methodName402;
	private String[] _methodParameterTypes402;
	private String _methodName403;
	private String[] _methodParameterTypes403;
	private String _methodName404;
	private String[] _methodParameterTypes404;
	private String _methodName405;
	private String[] _methodParameterTypes405;
	private String _methodName406;
	private String[] _methodParameterTypes406;
	private String _methodName407;
	private String[] _methodParameterTypes407;
=======
>>>>>>> origin/ID32
}