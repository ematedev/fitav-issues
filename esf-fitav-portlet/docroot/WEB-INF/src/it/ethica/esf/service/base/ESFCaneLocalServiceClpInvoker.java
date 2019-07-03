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

import it.ethica.esf.service.ESFCaneLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Ethica
 * @generated
 */
public class ESFCaneLocalServiceClpInvoker {
	public ESFCaneLocalServiceClpInvoker() {
		_methodName0 = "addESFCane";

		_methodParameterTypes0 = new String[] { "it.ethica.esf.model.ESFCane" };

		_methodName1 = "createESFCane";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteESFCane";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteESFCane";

		_methodParameterTypes3 = new String[] { "it.ethica.esf.model.ESFCane" };

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

		_methodName10 = "fetchESFCane";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getESFCane";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getESFCanes";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getESFCanesCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateESFCane";

		_methodParameterTypes15 = new String[] { "it.ethica.esf.model.ESFCane" };

		_methodName444 = "getBeanIdentifier";

		_methodParameterTypes444 = new String[] {  };

		_methodName445 = "setBeanIdentifier";

		_methodParameterTypes445 = new String[] { "java.lang.String" };

		_methodName450 = "addESFCane";

		_methodParameterTypes450 = new String[] {
				"long", "long", "long", "long", "long", "java.lang.String",
				"long", "int", "java.lang.String", "boolean", "long",
				"java.lang.String", "com.liferay.portal.service.ServiceContext"
			};

		_methodName451 = "updateESFCane";

		_methodParameterTypes451 = new String[] {
				"long", "long", "long", "long", "long", "java.lang.String",
				"long", "int", "java.lang.String", "boolean", "long",
				"java.lang.String", "long",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName452 = "deleteESFCane";

		_methodParameterTypes452 = new String[] {
				"long", "com.liferay.portal.service.ServiceContext"
			};

		_methodName453 = "getESFCanesByUserId";

		_methodParameterTypes453 = new String[] { "long" };

		_methodName454 = "getESFCanesByUserId";

		_methodParameterTypes454 = new String[] { "long", "int", "int" };

		_methodName455 = "getESFCanes";

		_methodParameterTypes455 = new String[] {  };

		_methodName456 = "getESFCanes";

		_methodParameterTypes456 = new String[] { "int", "int" };

		_methodName457 = "getESFCaneByLikeC_K";

		_methodParameterTypes457 = new String[] { "java.lang.String", "long" };

		_methodName458 = "getESFCaneByLikeC_K";

		_methodParameterTypes458 = new String[] {
				"java.lang.String", "long", "int", "int"
			};

		_methodName459 = "getESFGunByLikeC_K_U";

		_methodParameterTypes459 = new String[] {
				"java.lang.String", "long", "long"
			};

		_methodName460 = "getESFGunByLikeC_K_U";

		_methodParameterTypes460 = new String[] {
				"java.lang.String", "long", "long", "int", "int"
			};

		_methodName461 = "getESFGunByLikeT_C_K_U";

		_methodParameterTypes461 = new String[] {
				"long", "java.lang.String", "long", "long", "int", "int"
			};

		_methodName462 = "countESFGunByLikeT_C_K_U";

		_methodParameterTypes462 = new String[] {
				"long", "java.lang.String", "long", "long"
			};

		_methodName463 = "getESFGunByLikeT_K";

		_methodParameterTypes463 = new String[] { "long", "long", "int", "int" };

		_methodName464 = "countESFGunByLikeT_K";

		_methodParameterTypes464 = new String[] { "long", "long" };

		_methodName465 = "getESFGunByLikeT";

		_methodParameterTypes465 = new String[] { "long", "int", "int" };

		_methodName466 = "countESFGunByLikeT";

		_methodParameterTypes466 = new String[] { "long" };

		_methodName467 = "getFullName";

		_methodParameterTypes467 = new String[] { "it.ethica.esf.model.ESFCane" };

		_methodName469 = "getNameMod";

		_methodParameterTypes469 = new String[] { "it.ethica.esf.model.ESFCane" };

		_methodName470 = "getNameM";

		_methodParameterTypes470 = new String[] { "it.ethica.esf.model.ESFCane" };

		_methodName471 = "getNameT";

		_methodParameterTypes471 = new String[] { "it.ethica.esf.model.ESFCane" };

		_methodName472 = "checkCode";

		_methodParameterTypes472 = new String[] {
				"java.lang.String", "com.liferay.portal.service.ServiceContext"
			};

		_methodName473 = "getCanebyK";

		_methodParameterTypes473 = new String[] { "long" };

		_methodName474 = "getCanebyKindId";

		_methodParameterTypes474 = new String[] { "long", "int", "int" };

		_methodName475 = "countCanebyKindId";

		_methodParameterTypes475 = new String[] { "long" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return ESFCaneLocalServiceUtil.addESFCane((it.ethica.esf.model.ESFCane)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return ESFCaneLocalServiceUtil.createESFCane(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return ESFCaneLocalServiceUtil.deleteESFCane(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return ESFCaneLocalServiceUtil.deleteESFCane((it.ethica.esf.model.ESFCane)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return ESFCaneLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return ESFCaneLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return ESFCaneLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return ESFCaneLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return ESFCaneLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return ESFCaneLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return ESFCaneLocalServiceUtil.fetchESFCane(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return ESFCaneLocalServiceUtil.getESFCane(((Long)arguments[0]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return ESFCaneLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return ESFCaneLocalServiceUtil.getESFCanes(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return ESFCaneLocalServiceUtil.getESFCanesCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return ESFCaneLocalServiceUtil.updateESFCane((it.ethica.esf.model.ESFCane)arguments[0]);
		}

		if (_methodName444.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes444, parameterTypes)) {
			return ESFCaneLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName445.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes445, parameterTypes)) {
			ESFCaneLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName450.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes450, parameterTypes)) {
			return ESFCaneLocalServiceUtil.addESFCane(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue(),
				((Long)arguments[4]).longValue(),
				(java.lang.String)arguments[5],
				((Long)arguments[6]).longValue(),
				((Integer)arguments[7]).intValue(),
				(java.lang.String)arguments[8],
				((Boolean)arguments[9]).booleanValue(),
				((Long)arguments[10]).longValue(),
				(java.lang.String)arguments[11],
				(com.liferay.portal.service.ServiceContext)arguments[12]);
		}

		if (_methodName451.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes451, parameterTypes)) {
			return ESFCaneLocalServiceUtil.updateESFCane(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue(),
				((Long)arguments[4]).longValue(),
				(java.lang.String)arguments[5],
				((Long)arguments[6]).longValue(),
				((Integer)arguments[7]).intValue(),
				(java.lang.String)arguments[8],
				((Boolean)arguments[9]).booleanValue(),
				((Long)arguments[10]).longValue(),
				(java.lang.String)arguments[11],
				((Long)arguments[12]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[13]);
		}

		if (_methodName452.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes452, parameterTypes)) {
			return ESFCaneLocalServiceUtil.deleteESFCane(((Long)arguments[0]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[1]);
		}

		if (_methodName453.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes453, parameterTypes)) {
			return ESFCaneLocalServiceUtil.getESFCanesByUserId(((Long)arguments[0]).longValue());
		}

		if (_methodName454.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes454, parameterTypes)) {
			return ESFCaneLocalServiceUtil.getESFCanesByUserId(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName455.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes455, parameterTypes)) {
			return ESFCaneLocalServiceUtil.getESFCanes();
		}

		if (_methodName456.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes456, parameterTypes)) {
			return ESFCaneLocalServiceUtil.getESFCanes(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName457.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes457, parameterTypes)) {
			return ESFCaneLocalServiceUtil.getESFCaneByLikeC_K((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName458.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes458, parameterTypes)) {
			return ESFCaneLocalServiceUtil.getESFCaneByLikeC_K((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName459.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes459, parameterTypes)) {
			return ESFCaneLocalServiceUtil.getESFGunByLikeC_K_U((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue());
		}

		if (_methodName460.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes460, parameterTypes)) {
			return ESFCaneLocalServiceUtil.getESFGunByLikeC_K_U((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue());
		}

		if (_methodName461.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes461, parameterTypes)) {
			return ESFCaneLocalServiceUtil.getESFGunByLikeT_C_K_U(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1],
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue(),
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue());
		}

		if (_methodName462.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes462, parameterTypes)) {
			return ESFCaneLocalServiceUtil.countESFGunByLikeT_C_K_U(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1],
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue());
		}

		if (_methodName463.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes463, parameterTypes)) {
			return ESFCaneLocalServiceUtil.getESFGunByLikeT_K(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName464.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes464, parameterTypes)) {
			return ESFCaneLocalServiceUtil.countESFGunByLikeT_K(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName465.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes465, parameterTypes)) {
			return ESFCaneLocalServiceUtil.getESFGunByLikeT(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName466.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes466, parameterTypes)) {
			return ESFCaneLocalServiceUtil.countESFGunByLikeT(((Long)arguments[0]).longValue());
		}

		if (_methodName467.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes467, parameterTypes)) {
			return ESFCaneLocalServiceUtil.getFullName((it.ethica.esf.model.ESFCane)arguments[0]);
		}

		if (_methodName469.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes469, parameterTypes)) {
			return ESFCaneLocalServiceUtil.getNameMod((it.ethica.esf.model.ESFCane)arguments[0]);
		}

		if (_methodName470.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes470, parameterTypes)) {
			return ESFCaneLocalServiceUtil.getNameM((it.ethica.esf.model.ESFCane)arguments[0]);
		}

		if (_methodName471.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes471, parameterTypes)) {
			return ESFCaneLocalServiceUtil.getNameT((it.ethica.esf.model.ESFCane)arguments[0]);
		}

		if (_methodName472.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes472, parameterTypes)) {
			return ESFCaneLocalServiceUtil.checkCode((java.lang.String)arguments[0],
				(com.liferay.portal.service.ServiceContext)arguments[1]);
		}

		if (_methodName473.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes473, parameterTypes)) {
			return ESFCaneLocalServiceUtil.getCanebyK(((Long)arguments[0]).longValue());
		}

		if (_methodName474.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes474, parameterTypes)) {
			return ESFCaneLocalServiceUtil.getCanebyKindId(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName475.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes475, parameterTypes)) {
			return ESFCaneLocalServiceUtil.countCanebyKindId(((Long)arguments[0]).longValue());
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
	private String _methodName463;
	private String[] _methodParameterTypes463;
	private String _methodName464;
	private String[] _methodParameterTypes464;
	private String _methodName465;
	private String[] _methodParameterTypes465;
	private String _methodName466;
	private String[] _methodParameterTypes466;
	private String _methodName467;
	private String[] _methodParameterTypes467;
	private String _methodName469;
	private String[] _methodParameterTypes469;
	private String _methodName470;
	private String[] _methodParameterTypes470;
	private String _methodName471;
	private String[] _methodParameterTypes471;
	private String _methodName472;
	private String[] _methodParameterTypes472;
	private String _methodName473;
	private String[] _methodParameterTypes473;
	private String _methodName474;
	private String[] _methodParameterTypes474;
	private String _methodName475;
	private String[] _methodParameterTypes475;
}