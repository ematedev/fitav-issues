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

import it.ethica.esf.service.ESFShooterCategoryESFMatchLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Ethica
 * @generated
 */
public class ESFShooterCategoryESFMatchLocalServiceClpInvoker {
	public ESFShooterCategoryESFMatchLocalServiceClpInvoker() {
		_methodName0 = "addESFShooterCategoryESFMatch";

		_methodParameterTypes0 = new String[] {
				"it.ethica.esf.model.ESFShooterCategoryESFMatch"
			};

		_methodName1 = "createESFShooterCategoryESFMatch";

		_methodParameterTypes1 = new String[] {
				"it.ethica.esf.service.persistence.ESFShooterCategoryESFMatchPK"
			};

		_methodName2 = "deleteESFShooterCategoryESFMatch";

		_methodParameterTypes2 = new String[] {
				"it.ethica.esf.service.persistence.ESFShooterCategoryESFMatchPK"
			};

		_methodName3 = "deleteESFShooterCategoryESFMatch";

		_methodParameterTypes3 = new String[] {
				"it.ethica.esf.model.ESFShooterCategoryESFMatch"
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

		_methodName10 = "fetchESFShooterCategoryESFMatch";

		_methodParameterTypes10 = new String[] {
				"it.ethica.esf.service.persistence.ESFShooterCategoryESFMatchPK"
			};

		_methodName11 = "fetchESFShooterCategoryESFMatchByUuidAndCompanyId";

		_methodParameterTypes11 = new String[] { "java.lang.String", "long" };

		_methodName12 = "fetchESFShooterCategoryESFMatchByUuidAndGroupId";

		_methodParameterTypes12 = new String[] { "java.lang.String", "long" };

		_methodName13 = "getESFShooterCategoryESFMatch";

		_methodParameterTypes13 = new String[] {
				"it.ethica.esf.service.persistence.ESFShooterCategoryESFMatchPK"
			};

		_methodName14 = "getPersistedModel";

		_methodParameterTypes14 = new String[] { "java.io.Serializable" };

		_methodName15 = "getESFShooterCategoryESFMatchByUuidAndCompanyId";

		_methodParameterTypes15 = new String[] { "java.lang.String", "long" };

		_methodName16 = "getESFShooterCategoryESFMatchByUuidAndGroupId";

		_methodParameterTypes16 = new String[] { "java.lang.String", "long" };

		_methodName17 = "getESFShooterCategoryESFMatchs";

		_methodParameterTypes17 = new String[] { "int", "int" };

		_methodName18 = "getESFShooterCategoryESFMatchsCount";

		_methodParameterTypes18 = new String[] {  };

		_methodName19 = "updateESFShooterCategoryESFMatch";

		_methodParameterTypes19 = new String[] {
				"it.ethica.esf.model.ESFShooterCategoryESFMatch"
			};

		_methodName448 = "getBeanIdentifier";

		_methodParameterTypes448 = new String[] {  };

		_methodName449 = "setBeanIdentifier";

		_methodParameterTypes449 = new String[] { "java.lang.String" };

		_methodName454 = "deleteESFShooterCategoryByESFMatchId";

		_methodParameterTypes454 = new String[] { "long" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return ESFShooterCategoryESFMatchLocalServiceUtil.addESFShooterCategoryESFMatch((it.ethica.esf.model.ESFShooterCategoryESFMatch)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return ESFShooterCategoryESFMatchLocalServiceUtil.createESFShooterCategoryESFMatch((it.ethica.esf.service.persistence.ESFShooterCategoryESFMatchPK)arguments[0]);
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return ESFShooterCategoryESFMatchLocalServiceUtil.deleteESFShooterCategoryESFMatch((it.ethica.esf.service.persistence.ESFShooterCategoryESFMatchPK)arguments[0]);
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return ESFShooterCategoryESFMatchLocalServiceUtil.deleteESFShooterCategoryESFMatch((it.ethica.esf.model.ESFShooterCategoryESFMatch)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return ESFShooterCategoryESFMatchLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return ESFShooterCategoryESFMatchLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return ESFShooterCategoryESFMatchLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return ESFShooterCategoryESFMatchLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return ESFShooterCategoryESFMatchLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return ESFShooterCategoryESFMatchLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return ESFShooterCategoryESFMatchLocalServiceUtil.fetchESFShooterCategoryESFMatch((it.ethica.esf.service.persistence.ESFShooterCategoryESFMatchPK)arguments[0]);
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return ESFShooterCategoryESFMatchLocalServiceUtil.fetchESFShooterCategoryESFMatchByUuidAndCompanyId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return ESFShooterCategoryESFMatchLocalServiceUtil.fetchESFShooterCategoryESFMatchByUuidAndGroupId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return ESFShooterCategoryESFMatchLocalServiceUtil.getESFShooterCategoryESFMatch((it.ethica.esf.service.persistence.ESFShooterCategoryESFMatchPK)arguments[0]);
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return ESFShooterCategoryESFMatchLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return ESFShooterCategoryESFMatchLocalServiceUtil.getESFShooterCategoryESFMatchByUuidAndCompanyId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName16.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes16, parameterTypes)) {
			return ESFShooterCategoryESFMatchLocalServiceUtil.getESFShooterCategoryESFMatchByUuidAndGroupId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName17.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes17, parameterTypes)) {
			return ESFShooterCategoryESFMatchLocalServiceUtil.getESFShooterCategoryESFMatchs(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName18.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes18, parameterTypes)) {
			return ESFShooterCategoryESFMatchLocalServiceUtil.getESFShooterCategoryESFMatchsCount();
		}

		if (_methodName19.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes19, parameterTypes)) {
			return ESFShooterCategoryESFMatchLocalServiceUtil.updateESFShooterCategoryESFMatch((it.ethica.esf.model.ESFShooterCategoryESFMatch)arguments[0]);
		}

		if (_methodName448.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes448, parameterTypes)) {
			return ESFShooterCategoryESFMatchLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName449.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes449, parameterTypes)) {
			ESFShooterCategoryESFMatchLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName454.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes454, parameterTypes)) {
			ESFShooterCategoryESFMatchLocalServiceUtil.deleteESFShooterCategoryByESFMatchId(((Long)arguments[0]).longValue());

			return null;
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
	private String _methodName448;
	private String[] _methodParameterTypes448;
	private String _methodName449;
	private String[] _methodParameterTypes449;
	private String _methodName454;
	private String[] _methodParameterTypes454;
}