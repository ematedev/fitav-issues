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

import it.ethica.esf.service.ESFFornitureLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Ethica
 * @generated
 */
public class ESFFornitureLocalServiceClpInvoker {
	public ESFFornitureLocalServiceClpInvoker() {
		_methodName0 = "addESFForniture";

		_methodParameterTypes0 = new String[] { "it.ethica.esf.model.ESFForniture" };

		_methodName1 = "createESFForniture";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteESFForniture";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteESFForniture";

		_methodParameterTypes3 = new String[] { "it.ethica.esf.model.ESFForniture" };

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

		_methodName10 = "fetchESFForniture";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "fetchESFFornitureByUuidAndCompanyId";

		_methodParameterTypes11 = new String[] { "java.lang.String", "long" };

		_methodName12 = "fetchESFFornitureByUuidAndGroupId";

		_methodParameterTypes12 = new String[] { "java.lang.String", "long" };

		_methodName13 = "getESFForniture";

		_methodParameterTypes13 = new String[] { "long" };

		_methodName14 = "getPersistedModel";

		_methodParameterTypes14 = new String[] { "java.io.Serializable" };

		_methodName15 = "getESFFornitureByUuidAndCompanyId";

		_methodParameterTypes15 = new String[] { "java.lang.String", "long" };

		_methodName16 = "getESFFornitureByUuidAndGroupId";

		_methodParameterTypes16 = new String[] { "java.lang.String", "long" };

		_methodName17 = "getESFFornitures";

		_methodParameterTypes17 = new String[] { "int", "int" };

		_methodName18 = "getESFFornituresCount";

		_methodParameterTypes18 = new String[] {  };

		_methodName19 = "updateESFForniture";

		_methodParameterTypes19 = new String[] {
				"it.ethica.esf.model.ESFForniture"
			};

		_methodName382 = "getBeanIdentifier";

		_methodParameterTypes382 = new String[] {  };

		_methodName383 = "setBeanIdentifier";

		_methodParameterTypes383 = new String[] { "java.lang.String" };

		_methodName388 = "getAllESFFornitures";

		_methodParameterTypes388 = new String[] {  };

		_methodName389 = "getAllESFFornitures";

		_methodParameterTypes389 = new String[] { "int", "int" };

		_methodName390 = "getAllESFFornitures";

		_methodParameterTypes390 = new String[] { "long" };

		_methodName391 = "getAllESFFornitures";

		_methodParameterTypes391 = new String[] { "long", "int", "int" };

		_methodName392 = "findAllESFFornituresByType";

		_methodParameterTypes392 = new String[] { "long" };

		_methodName393 = "countByGroupId";

		_methodParameterTypes393 = new String[] { "long" };

		_methodName394 = "addESFForniture";

		_methodParameterTypes394 = new String[] {
				"long", "java.lang.String", "java.lang.String",
				"java.lang.String", "long", "long", "java.util.Date",
				"java.lang.String", "com.liferay.portal.service.ServiceContext"
			};

		_methodName395 = "updateESFForniture";

		_methodParameterTypes395 = new String[] {
				"long", "long", "java.lang.String", "java.lang.String",
				"java.lang.String", "long", "long", "java.util.Date",
				"java.lang.String", "com.liferay.portal.service.ServiceContext"
			};

		_methodName396 = "deleteESFForniture";

		_methodParameterTypes396 = new String[] {
				"long", "com.liferay.portal.service.ServiceContext"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return ESFFornitureLocalServiceUtil.addESFForniture((it.ethica.esf.model.ESFForniture)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return ESFFornitureLocalServiceUtil.createESFForniture(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return ESFFornitureLocalServiceUtil.deleteESFForniture(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return ESFFornitureLocalServiceUtil.deleteESFForniture((it.ethica.esf.model.ESFForniture)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return ESFFornitureLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return ESFFornitureLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return ESFFornitureLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return ESFFornitureLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return ESFFornitureLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return ESFFornitureLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return ESFFornitureLocalServiceUtil.fetchESFForniture(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return ESFFornitureLocalServiceUtil.fetchESFFornitureByUuidAndCompanyId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return ESFFornitureLocalServiceUtil.fetchESFFornitureByUuidAndGroupId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return ESFFornitureLocalServiceUtil.getESFForniture(((Long)arguments[0]).longValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return ESFFornitureLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return ESFFornitureLocalServiceUtil.getESFFornitureByUuidAndCompanyId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName16.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes16, parameterTypes)) {
			return ESFFornitureLocalServiceUtil.getESFFornitureByUuidAndGroupId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName17.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes17, parameterTypes)) {
			return ESFFornitureLocalServiceUtil.getESFFornitures(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName18.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes18, parameterTypes)) {
			return ESFFornitureLocalServiceUtil.getESFFornituresCount();
		}

		if (_methodName19.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes19, parameterTypes)) {
			return ESFFornitureLocalServiceUtil.updateESFForniture((it.ethica.esf.model.ESFForniture)arguments[0]);
		}

		if (_methodName382.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes382, parameterTypes)) {
			return ESFFornitureLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName383.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes383, parameterTypes)) {
			ESFFornitureLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName388.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes388, parameterTypes)) {
			return ESFFornitureLocalServiceUtil.getAllESFFornitures();
		}

		if (_methodName389.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes389, parameterTypes)) {
			return ESFFornitureLocalServiceUtil.getAllESFFornitures(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName390.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes390, parameterTypes)) {
			return ESFFornitureLocalServiceUtil.getAllESFFornitures(((Long)arguments[0]).longValue());
		}

		if (_methodName391.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes391, parameterTypes)) {
			return ESFFornitureLocalServiceUtil.getAllESFFornitures(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName392.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes392, parameterTypes)) {
			return ESFFornitureLocalServiceUtil.findAllESFFornituresByType(((Long)arguments[0]).longValue());
		}

		if (_methodName393.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes393, parameterTypes)) {
			return ESFFornitureLocalServiceUtil.countByGroupId(((Long)arguments[0]).longValue());
		}

		if (_methodName394.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes394, parameterTypes)) {
			return ESFFornitureLocalServiceUtil.addESFForniture(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3],
				((Long)arguments[4]).longValue(),
				((Long)arguments[5]).longValue(), (java.util.Date)arguments[6],
				(java.lang.String)arguments[7],
				(com.liferay.portal.service.ServiceContext)arguments[8]);
		}

		if (_methodName395.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes395, parameterTypes)) {
			return ESFFornitureLocalServiceUtil.updateESFForniture(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3],
				(java.lang.String)arguments[4],
				((Long)arguments[5]).longValue(),
				((Long)arguments[6]).longValue(), (java.util.Date)arguments[7],
				(java.lang.String)arguments[8],
				(com.liferay.portal.service.ServiceContext)arguments[9]);
		}

		if (_methodName396.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes396, parameterTypes)) {
			return ESFFornitureLocalServiceUtil.deleteESFForniture(((Long)arguments[0]).longValue(),
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
	private String _methodName18;
	private String[] _methodParameterTypes18;
	private String _methodName19;
	private String[] _methodParameterTypes19;
	private String _methodName382;
	private String[] _methodParameterTypes382;
	private String _methodName383;
	private String[] _methodParameterTypes383;
	private String _methodName388;
	private String[] _methodParameterTypes388;
	private String _methodName389;
	private String[] _methodParameterTypes389;
	private String _methodName390;
	private String[] _methodParameterTypes390;
	private String _methodName391;
	private String[] _methodParameterTypes391;
	private String _methodName392;
	private String[] _methodParameterTypes392;
	private String _methodName393;
	private String[] _methodParameterTypes393;
	private String _methodName394;
	private String[] _methodParameterTypes394;
	private String _methodName395;
	private String[] _methodParameterTypes395;
	private String _methodName396;
	private String[] _methodParameterTypes396;
}