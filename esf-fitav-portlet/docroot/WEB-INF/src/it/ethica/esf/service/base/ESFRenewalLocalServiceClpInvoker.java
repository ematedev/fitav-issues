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

import it.ethica.esf.service.ESFRenewalLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Ethica
 * @generated
 */
public class ESFRenewalLocalServiceClpInvoker {
	public ESFRenewalLocalServiceClpInvoker() {
		_methodName0 = "addESFRenewal";

		_methodParameterTypes0 = new String[] { "it.ethica.esf.model.ESFRenewal" };

		_methodName1 = "createESFRenewal";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteESFRenewal";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteESFRenewal";

		_methodParameterTypes3 = new String[] { "it.ethica.esf.model.ESFRenewal" };

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

		_methodName10 = "fetchESFRenewal";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getESFRenewal";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getESFRenewals";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getESFRenewalsCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateESFRenewal";

		_methodParameterTypes15 = new String[] { "it.ethica.esf.model.ESFRenewal" };

		_methodName388 = "getBeanIdentifier";

		_methodParameterTypes388 = new String[] {  };

		_methodName389 = "setBeanIdentifier";

		_methodParameterTypes389 = new String[] { "java.lang.String" };

		_methodName394 = "findByESFRenewalUser_id";

		_methodParameterTypes394 = new String[] { "long" };

		_methodName395 = "findAll";

		_methodParameterTypes395 = new String[] {  };

		_methodName396 = "findByRegion";

		_methodParameterTypes396 = new String[] { "long" };

		_methodName397 = "findByRegion";

		_methodParameterTypes397 = new String[] { "long", "int", "int" };

		_methodName398 = "findByOrgId_IsTotal";

		_methodParameterTypes398 = new String[] { "long", "boolean" };

		_methodName399 = "findByRenewalFatherId";

		_methodParameterTypes399 = new String[] { "long" };

		_methodName400 = "findByOrg_Year";

		_methodParameterTypes400 = new String[] { "long", "int" };

		_methodName401 = "findByReason_IsTotal";

		_methodParameterTypes401 = new String[] { "java.lang.String", "boolean" };

		_methodName402 = "findByRenewalFatherId_OrgId";

		_methodParameterTypes402 = new String[] { "long", "long" };

		_methodName403 = "findByOrgId";

		_methodParameterTypes403 = new String[] { "long" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return ESFRenewalLocalServiceUtil.addESFRenewal((it.ethica.esf.model.ESFRenewal)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return ESFRenewalLocalServiceUtil.createESFRenewal(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return ESFRenewalLocalServiceUtil.deleteESFRenewal(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return ESFRenewalLocalServiceUtil.deleteESFRenewal((it.ethica.esf.model.ESFRenewal)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return ESFRenewalLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return ESFRenewalLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return ESFRenewalLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return ESFRenewalLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return ESFRenewalLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return ESFRenewalLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return ESFRenewalLocalServiceUtil.fetchESFRenewal(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return ESFRenewalLocalServiceUtil.getESFRenewal(((Long)arguments[0]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return ESFRenewalLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return ESFRenewalLocalServiceUtil.getESFRenewals(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return ESFRenewalLocalServiceUtil.getESFRenewalsCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return ESFRenewalLocalServiceUtil.updateESFRenewal((it.ethica.esf.model.ESFRenewal)arguments[0]);
		}

		if (_methodName388.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes388, parameterTypes)) {
			return ESFRenewalLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName389.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes389, parameterTypes)) {
			ESFRenewalLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName394.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes394, parameterTypes)) {
			return ESFRenewalLocalServiceUtil.findByESFRenewalUser_id(((Long)arguments[0]).longValue());
		}

		if (_methodName395.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes395, parameterTypes)) {
			return ESFRenewalLocalServiceUtil.findAll();
		}

		if (_methodName396.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes396, parameterTypes)) {
			return ESFRenewalLocalServiceUtil.findByRegion(((Long)arguments[0]).longValue());
		}

		if (_methodName397.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes397, parameterTypes)) {
			return ESFRenewalLocalServiceUtil.findByRegion(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName398.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes398, parameterTypes)) {
			return ESFRenewalLocalServiceUtil.findByOrgId_IsTotal(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue());
		}

		if (_methodName399.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes399, parameterTypes)) {
			return ESFRenewalLocalServiceUtil.findByRenewalFatherId(((Long)arguments[0]).longValue());
		}

		if (_methodName400.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes400, parameterTypes)) {
			return ESFRenewalLocalServiceUtil.findByOrg_Year(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName401.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes401, parameterTypes)) {
			return ESFRenewalLocalServiceUtil.findByReason_IsTotal((java.lang.String)arguments[0],
				((Boolean)arguments[1]).booleanValue());
		}

		if (_methodName402.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes402, parameterTypes)) {
			return ESFRenewalLocalServiceUtil.findByRenewalFatherId_OrgId(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName403.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes403, parameterTypes)) {
			return ESFRenewalLocalServiceUtil.findByOrgId(((Long)arguments[0]).longValue());
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
	private String _methodName388;
	private String[] _methodParameterTypes388;
	private String _methodName389;
	private String[] _methodParameterTypes389;
	private String _methodName394;
	private String[] _methodParameterTypes394;
	private String _methodName395;
	private String[] _methodParameterTypes395;
	private String _methodName396;
	private String[] _methodParameterTypes396;
	private String _methodName397;
	private String[] _methodParameterTypes397;
	private String _methodName398;
	private String[] _methodParameterTypes398;
	private String _methodName399;
	private String[] _methodParameterTypes399;
	private String _methodName400;
	private String[] _methodParameterTypes400;
	private String _methodName401;
	private String[] _methodParameterTypes401;
	private String _methodName402;
	private String[] _methodParameterTypes402;
	private String _methodName403;
	private String[] _methodParameterTypes403;
}