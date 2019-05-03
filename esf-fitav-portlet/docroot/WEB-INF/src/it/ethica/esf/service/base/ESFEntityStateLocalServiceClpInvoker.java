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

import it.ethica.esf.service.ESFEntityStateLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Ethica
 * @generated
 */
public class ESFEntityStateLocalServiceClpInvoker {
	public ESFEntityStateLocalServiceClpInvoker() {
		_methodName0 = "addESFEntityState";

		_methodParameterTypes0 = new String[] {
				"it.ethica.esf.model.ESFEntityState"
			};

		_methodName1 = "createESFEntityState";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteESFEntityState";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteESFEntityState";

		_methodParameterTypes3 = new String[] {
				"it.ethica.esf.model.ESFEntityState"
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

		_methodName10 = "fetchESFEntityState";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getESFEntityState";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getESFEntityStates";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getESFEntityStatesCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateESFEntityState";

		_methodParameterTypes15 = new String[] {
				"it.ethica.esf.model.ESFEntityState"
			};

		_methodName372 = "getBeanIdentifier";

		_methodParameterTypes372 = new String[] {  };

		_methodName373 = "setBeanIdentifier";

		_methodParameterTypes373 = new String[] { "java.lang.String" };

		_methodName378 = "findESFEntityStateByCN";

		_methodParameterTypes378 = new String[] { "java.lang.String" };

		_methodName379 = "findESFEntityStateByC_PK";

		_methodParameterTypes379 = new String[] { "java.lang.String", "long" };

		_methodName380 = "findESFEntityStateByC_PK_S";

		_methodParameterTypes380 = new String[] {
				"java.lang.String", "long", "long"
			};

		_methodName381 = "findESFEntityStateByC_S";

		_methodParameterTypes381 = new String[] { "java.lang.String", "long" };

		_methodName382 = "findESFEntityStateCName_CPk";

		_methodParameterTypes382 = new String[] { "java.lang.String", "long" };

		_methodName383 = "findESFEntityStateByC_S";

		_methodParameterTypes383 = new String[] {
				"java.lang.String", "long", "int", "int"
			};

		_methodName384 = "addEntityState";

		_methodParameterTypes384 = new String[] {
				"long", "long", "long", "java.lang.String", "long", "long"
			};

		_methodName385 = "addEntityState";

		_methodParameterTypes385 = new String[] {
				"long", "java.lang.String", "long", "long",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName386 = "addEntityState";

		_methodParameterTypes386 = new String[] {
				"long", "java.lang.String", "long", "long", "java.util.Date",
				"java.util.Date", "com.liferay.portal.service.ServiceContext"
			};

		_methodName387 = "updateEntityState";

		_methodParameterTypes387 = new String[] {
				"long", "long", "com.liferay.portal.service.ServiceContext"
			};

		_methodName388 = "findAllESFEntityStateByClassName_ClassPK";

		_methodParameterTypes388 = new String[] { "java.lang.String", "long" };

		_methodName389 = "findESShooterLastCardActive";

		_methodParameterTypes389 = new String[] { "long" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return ESFEntityStateLocalServiceUtil.addESFEntityState((it.ethica.esf.model.ESFEntityState)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return ESFEntityStateLocalServiceUtil.createESFEntityState(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return ESFEntityStateLocalServiceUtil.deleteESFEntityState(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return ESFEntityStateLocalServiceUtil.deleteESFEntityState((it.ethica.esf.model.ESFEntityState)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return ESFEntityStateLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return ESFEntityStateLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return ESFEntityStateLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return ESFEntityStateLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return ESFEntityStateLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return ESFEntityStateLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return ESFEntityStateLocalServiceUtil.fetchESFEntityState(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return ESFEntityStateLocalServiceUtil.getESFEntityState(((Long)arguments[0]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return ESFEntityStateLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return ESFEntityStateLocalServiceUtil.getESFEntityStates(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return ESFEntityStateLocalServiceUtil.getESFEntityStatesCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return ESFEntityStateLocalServiceUtil.updateESFEntityState((it.ethica.esf.model.ESFEntityState)arguments[0]);
		}

		if (_methodName372.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes372, parameterTypes)) {
			return ESFEntityStateLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName373.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes373, parameterTypes)) {
			ESFEntityStateLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName378.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes378, parameterTypes)) {
			return ESFEntityStateLocalServiceUtil.findESFEntityStateByCN((java.lang.String)arguments[0]);
		}

		if (_methodName379.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes379, parameterTypes)) {
			return ESFEntityStateLocalServiceUtil.findESFEntityStateByC_PK((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName380.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes380, parameterTypes)) {
			return ESFEntityStateLocalServiceUtil.findESFEntityStateByC_PK_S((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue());
		}

		if (_methodName381.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes381, parameterTypes)) {
			return ESFEntityStateLocalServiceUtil.findESFEntityStateByC_S((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName382.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes382, parameterTypes)) {
			return ESFEntityStateLocalServiceUtil.findESFEntityStateCName_CPk((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName383.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes383, parameterTypes)) {
			return ESFEntityStateLocalServiceUtil.findESFEntityStateByC_S((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName384.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes384, parameterTypes)) {
			return ESFEntityStateLocalServiceUtil.addEntityState(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				(java.lang.String)arguments[3],
				((Long)arguments[4]).longValue(),
				((Long)arguments[5]).longValue());
		}

		if (_methodName385.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes385, parameterTypes)) {
			return ESFEntityStateLocalServiceUtil.addEntityState(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1],
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[4]);
		}

		if (_methodName386.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes386, parameterTypes)) {
			return ESFEntityStateLocalServiceUtil.addEntityState(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1],
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue(), (java.util.Date)arguments[4],
				(java.util.Date)arguments[5],
				(com.liferay.portal.service.ServiceContext)arguments[6]);
		}

		if (_methodName387.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes387, parameterTypes)) {
			return ESFEntityStateLocalServiceUtil.updateEntityState(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[2]);
		}

		if (_methodName388.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes388, parameterTypes)) {
			return ESFEntityStateLocalServiceUtil.findAllESFEntityStateByClassName_ClassPK((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName389.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes389, parameterTypes)) {
			return ESFEntityStateLocalServiceUtil.findESShooterLastCardActive(((Long)arguments[0]).longValue());
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
	private String _methodName372;
	private String[] _methodParameterTypes372;
	private String _methodName373;
	private String[] _methodParameterTypes373;
	private String _methodName378;
	private String[] _methodParameterTypes378;
	private String _methodName379;
	private String[] _methodParameterTypes379;
	private String _methodName380;
	private String[] _methodParameterTypes380;
	private String _methodName381;
	private String[] _methodParameterTypes381;
	private String _methodName382;
	private String[] _methodParameterTypes382;
	private String _methodName383;
	private String[] _methodParameterTypes383;
	private String _methodName384;
	private String[] _methodParameterTypes384;
	private String _methodName385;
	private String[] _methodParameterTypes385;
	private String _methodName386;
	private String[] _methodParameterTypes386;
	private String _methodName387;
	private String[] _methodParameterTypes387;
	private String _methodName388;
	private String[] _methodParameterTypes388;
	private String _methodName389;
	private String[] _methodParameterTypes389;
}