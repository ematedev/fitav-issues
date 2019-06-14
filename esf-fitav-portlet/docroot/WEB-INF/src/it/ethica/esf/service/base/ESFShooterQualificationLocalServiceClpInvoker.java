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

import it.ethica.esf.service.ESFShooterQualificationLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Ethica
 * @generated
 */
public class ESFShooterQualificationLocalServiceClpInvoker {
	public ESFShooterQualificationLocalServiceClpInvoker() {
		_methodName0 = "addESFShooterQualification";

		_methodParameterTypes0 = new String[] {
				"it.ethica.esf.model.ESFShooterQualification"
			};

		_methodName1 = "createESFShooterQualification";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteESFShooterQualification";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteESFShooterQualification";

		_methodParameterTypes3 = new String[] {
				"it.ethica.esf.model.ESFShooterQualification"
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

		_methodName10 = "fetchESFShooterQualification";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "fetchESFShooterQualificationByUuidAndCompanyId";

		_methodParameterTypes11 = new String[] { "java.lang.String", "long" };

		_methodName12 = "fetchESFShooterQualificationByUuidAndGroupId";

		_methodParameterTypes12 = new String[] { "java.lang.String", "long" };

		_methodName13 = "getESFShooterQualification";

		_methodParameterTypes13 = new String[] { "long" };

		_methodName14 = "getPersistedModel";

		_methodParameterTypes14 = new String[] { "java.io.Serializable" };

		_methodName15 = "getESFShooterQualificationByUuidAndCompanyId";

		_methodParameterTypes15 = new String[] { "java.lang.String", "long" };

		_methodName16 = "getESFShooterQualificationByUuidAndGroupId";

		_methodParameterTypes16 = new String[] { "java.lang.String", "long" };

		_methodName17 = "getESFShooterQualifications";

		_methodParameterTypes17 = new String[] { "int", "int" };

		_methodName18 = "getESFShooterQualificationsCount";

		_methodParameterTypes18 = new String[] {  };

		_methodName19 = "updateESFShooterQualification";

		_methodParameterTypes19 = new String[] {
				"it.ethica.esf.model.ESFShooterQualification"
			};

		_methodName396 = "getBeanIdentifier";

		_methodParameterTypes396 = new String[] {  };

		_methodName397 = "setBeanIdentifier";

		_methodParameterTypes397 = new String[] { "java.lang.String" };

		_methodName402 = "getESFShooterQualifications";

		_methodParameterTypes402 = new String[] {  };

		_methodName403 = "getESFShooterQualifications";

		_methodParameterTypes403 = new String[] { "int", "int" };

		_methodName404 = "getESFShooterCategories";

		_methodParameterTypes404 = new String[] { "long" };

		_methodName405 = "findByMatchId";

		_methodParameterTypes405 = new String[] { "long" };

		_methodName406 = "addESFShooterQualification";

		_methodParameterTypes406 = new String[] {
				"long", "java.lang.String", "java.lang.String",
				"java.lang.String", "com.liferay.portal.service.ServiceContext"
			};

		_methodName407 = "updateESFShooterQualification";

		_methodParameterTypes407 = new String[] {
				"long", "java.lang.String", "java.lang.String",
				"java.lang.String", "com.liferay.portal.service.ServiceContext"
			};

		_methodName408 = "deleteESFShooterQualification";

		_methodParameterTypes408 = new String[] {
				"long", "com.liferay.portal.service.ServiceContext"
			};

		_methodName409 = "findIDQualificationByCode";

		_methodParameterTypes409 = new String[] { "java.lang.String" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return ESFShooterQualificationLocalServiceUtil.addESFShooterQualification((it.ethica.esf.model.ESFShooterQualification)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return ESFShooterQualificationLocalServiceUtil.createESFShooterQualification(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return ESFShooterQualificationLocalServiceUtil.deleteESFShooterQualification(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return ESFShooterQualificationLocalServiceUtil.deleteESFShooterQualification((it.ethica.esf.model.ESFShooterQualification)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return ESFShooterQualificationLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return ESFShooterQualificationLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return ESFShooterQualificationLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return ESFShooterQualificationLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return ESFShooterQualificationLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return ESFShooterQualificationLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return ESFShooterQualificationLocalServiceUtil.fetchESFShooterQualification(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return ESFShooterQualificationLocalServiceUtil.fetchESFShooterQualificationByUuidAndCompanyId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return ESFShooterQualificationLocalServiceUtil.fetchESFShooterQualificationByUuidAndGroupId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return ESFShooterQualificationLocalServiceUtil.getESFShooterQualification(((Long)arguments[0]).longValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return ESFShooterQualificationLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return ESFShooterQualificationLocalServiceUtil.getESFShooterQualificationByUuidAndCompanyId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName16.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes16, parameterTypes)) {
			return ESFShooterQualificationLocalServiceUtil.getESFShooterQualificationByUuidAndGroupId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName17.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes17, parameterTypes)) {
			return ESFShooterQualificationLocalServiceUtil.getESFShooterQualifications(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName18.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes18, parameterTypes)) {
			return ESFShooterQualificationLocalServiceUtil.getESFShooterQualificationsCount();
		}

		if (_methodName19.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes19, parameterTypes)) {
			return ESFShooterQualificationLocalServiceUtil.updateESFShooterQualification((it.ethica.esf.model.ESFShooterQualification)arguments[0]);
		}

		if (_methodName396.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes396, parameterTypes)) {
			return ESFShooterQualificationLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName397.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes397, parameterTypes)) {
			ESFShooterQualificationLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName402.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes402, parameterTypes)) {
			return ESFShooterQualificationLocalServiceUtil.getESFShooterQualifications();
		}

		if (_methodName403.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes403, parameterTypes)) {
			return ESFShooterQualificationLocalServiceUtil.getESFShooterQualifications(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName404.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes404, parameterTypes)) {
			return ESFShooterQualificationLocalServiceUtil.getESFShooterCategories(((Long)arguments[0]).longValue());
		}

		if (_methodName405.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes405, parameterTypes)) {
			return ESFShooterQualificationLocalServiceUtil.findByMatchId(((Long)arguments[0]).longValue());
		}

		if (_methodName406.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes406, parameterTypes)) {
			return ESFShooterQualificationLocalServiceUtil.addESFShooterQualification(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3],
				(com.liferay.portal.service.ServiceContext)arguments[4]);
		}

		if (_methodName407.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes407, parameterTypes)) {
			return ESFShooterQualificationLocalServiceUtil.updateESFShooterQualification(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3],
				(com.liferay.portal.service.ServiceContext)arguments[4]);
		}

		if (_methodName408.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes408, parameterTypes)) {
			return ESFShooterQualificationLocalServiceUtil.deleteESFShooterQualification(((Long)arguments[0]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[1]);
		}

		if (_methodName409.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes409, parameterTypes)) {
			return ESFShooterQualificationLocalServiceUtil.findIDQualificationByCode((java.lang.String)arguments[0]);
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
}