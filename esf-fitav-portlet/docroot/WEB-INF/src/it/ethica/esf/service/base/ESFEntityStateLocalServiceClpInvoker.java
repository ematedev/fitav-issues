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

		_methodName420 = "getBeanIdentifier";

		_methodParameterTypes420 = new String[] {  };

		_methodName421 = "setBeanIdentifier";

		_methodParameterTypes421 = new String[] { "java.lang.String" };

		_methodName426 = "findESFEntityStateByCN";

		_methodParameterTypes426 = new String[] { "java.lang.String" };

		_methodName427 = "findESFEntityStateByC_PK";

		_methodParameterTypes427 = new String[] { "java.lang.String", "long" };

		_methodName428 = "findESFEntityStateByC_PK_S";

		_methodParameterTypes428 = new String[] {
				"java.lang.String", "long", "long"
			};

		_methodName429 = "findESFEntityStateByC_S";

		_methodParameterTypes429 = new String[] { "java.lang.String", "long" };

		_methodName430 = "findESFEntityStateCName_CPk";

		_methodParameterTypes430 = new String[] { "java.lang.String", "long" };

		_methodName431 = "findESFEntityStateByC_S";

		_methodParameterTypes431 = new String[] {
				"java.lang.String", "long", "int", "int"
			};

		_methodName432 = "addEntityState";

		_methodParameterTypes432 = new String[] {
				"long", "long", "long", "java.lang.String", "long", "long"
			};

		_methodName433 = "addEntityState";

		_methodParameterTypes433 = new String[] {
				"long", "java.lang.String", "long", "long",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName434 = "addEntityState";

		_methodParameterTypes434 = new String[] {
				"long", "java.lang.String", "long", "long", "java.util.Date",
				"java.util.Date", "com.liferay.portal.service.ServiceContext"
			};

		_methodName435 = "updateEntityState";

		_methodParameterTypes435 = new String[] {
				"long", "long", "com.liferay.portal.service.ServiceContext"
			};

		_methodName436 = "findAllESFEntityStateByClassName_ClassPK";

		_methodParameterTypes436 = new String[] { "java.lang.String", "long" };

		_methodName437 = "findESShooterLastCardActive";

		_methodParameterTypes437 = new String[] { "long" };
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

		if (_methodName420.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes420, parameterTypes)) {
			return ESFEntityStateLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName421.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes421, parameterTypes)) {
			ESFEntityStateLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName426.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes426, parameterTypes)) {
			return ESFEntityStateLocalServiceUtil.findESFEntityStateByCN((java.lang.String)arguments[0]);
		}

		if (_methodName427.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes427, parameterTypes)) {
			return ESFEntityStateLocalServiceUtil.findESFEntityStateByC_PK((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName428.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes428, parameterTypes)) {
			return ESFEntityStateLocalServiceUtil.findESFEntityStateByC_PK_S((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue());
		}

		if (_methodName429.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes429, parameterTypes)) {
			return ESFEntityStateLocalServiceUtil.findESFEntityStateByC_S((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName430.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes430, parameterTypes)) {
			return ESFEntityStateLocalServiceUtil.findESFEntityStateCName_CPk((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName431.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes431, parameterTypes)) {
			return ESFEntityStateLocalServiceUtil.findESFEntityStateByC_S((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName432.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes432, parameterTypes)) {
			return ESFEntityStateLocalServiceUtil.addEntityState(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				(java.lang.String)arguments[3],
				((Long)arguments[4]).longValue(),
				((Long)arguments[5]).longValue());
		}

		if (_methodName433.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes433, parameterTypes)) {
			return ESFEntityStateLocalServiceUtil.addEntityState(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1],
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[4]);
		}

		if (_methodName434.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes434, parameterTypes)) {
			return ESFEntityStateLocalServiceUtil.addEntityState(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1],
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue(), (java.util.Date)arguments[4],
				(java.util.Date)arguments[5],
				(com.liferay.portal.service.ServiceContext)arguments[6]);
		}

		if (_methodName435.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes435, parameterTypes)) {
			return ESFEntityStateLocalServiceUtil.updateEntityState(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[2]);
		}

		if (_methodName436.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes436, parameterTypes)) {
			return ESFEntityStateLocalServiceUtil.findAllESFEntityStateByClassName_ClassPK((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName437.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes437, parameterTypes)) {
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
	private String _methodName420;
	private String[] _methodParameterTypes420;
	private String _methodName421;
	private String[] _methodParameterTypes421;
	private String _methodName426;
	private String[] _methodParameterTypes426;
	private String _methodName427;
	private String[] _methodParameterTypes427;
	private String _methodName428;
	private String[] _methodParameterTypes428;
	private String _methodName429;
	private String[] _methodParameterTypes429;
	private String _methodName430;
	private String[] _methodParameterTypes430;
	private String _methodName431;
	private String[] _methodParameterTypes431;
	private String _methodName432;
	private String[] _methodParameterTypes432;
	private String _methodName433;
	private String[] _methodParameterTypes433;
	private String _methodName434;
	private String[] _methodParameterTypes434;
	private String _methodName435;
	private String[] _methodParameterTypes435;
	private String _methodName436;
	private String[] _methodParameterTypes436;
	private String _methodName437;
	private String[] _methodParameterTypes437;
}