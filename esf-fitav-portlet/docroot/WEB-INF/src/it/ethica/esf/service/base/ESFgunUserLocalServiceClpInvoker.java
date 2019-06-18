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

import it.ethica.esf.service.ESFgunUserLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Ethica
 * @generated
 */
public class ESFgunUserLocalServiceClpInvoker {
	public ESFgunUserLocalServiceClpInvoker() {
		_methodName0 = "addESFgunUser";

		_methodParameterTypes0 = new String[] { "it.ethica.esf.model.ESFgunUser" };

		_methodName1 = "createESFgunUser";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteESFgunUser";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteESFgunUser";

		_methodParameterTypes3 = new String[] { "it.ethica.esf.model.ESFgunUser" };

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

		_methodName10 = "fetchESFgunUser";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getESFgunUser";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getESFgunUsers";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getESFgunUsersCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateESFgunUser";

		_methodParameterTypes15 = new String[] { "it.ethica.esf.model.ESFgunUser" };

<<<<<<< HEAD
		_methodName392 = "getBeanIdentifier";

		_methodParameterTypes392 = new String[] {  };

		_methodName393 = "setBeanIdentifier";

		_methodParameterTypes393 = new String[] { "java.lang.String" };

		_methodName398 = "addESFGunUser";

		_methodParameterTypes398 = new String[] {
=======
		_methodName386 = "getBeanIdentifier";

		_methodParameterTypes386 = new String[] {  };

		_methodName387 = "setBeanIdentifier";

		_methodParameterTypes387 = new String[] { "java.lang.String" };

		_methodName392 = "addESFGunUser";

		_methodParameterTypes392 = new String[] {
>>>>>>> origin/ID32
				"long", "long", "java.lang.String", "boolean", "int",
				"java.lang.String", "long", "long", "int", "java.lang.String",
				"long", "com.liferay.portal.service.ServiceContext"
			};

<<<<<<< HEAD
		_methodName399 = "getESFGunByLikeC_K_T";

		_methodParameterTypes399 = new String[] {
				"java.lang.String", "long", "int", "int", "int"
			};

		_methodName400 = "countESFGunByLikeC_K_T";

		_methodParameterTypes400 = new String[] {
				"java.lang.String", "long", "int"
			};

		_methodName401 = "getESFGunByLikeS_T";

		_methodParameterTypes401 = new String[] { "long", "int", "int", "int" };

		_methodName402 = "countESFGunByLikeS_T";

		_methodParameterTypes402 = new String[] { "long", "int" };

		_methodName403 = "getESFGunByT";

		_methodParameterTypes403 = new String[] { "int", "int", "int" };

		_methodName404 = "countESFGunByT";

		_methodParameterTypes404 = new String[] { "int" };

		_methodName405 = "findbyESFGunId";

		_methodParameterTypes405 = new String[] { "long" };

		_methodName406 = "findbyESFGunId_Type";

		_methodParameterTypes406 = new String[] { "long", "int" };

		_methodName407 = "findbyCode";

		_methodParameterTypes407 = new String[] { "java.lang.String" };

		_methodName408 = "findbyGunId_Type";

		_methodParameterTypes408 = new String[] { "long", "int", "int", "int" };

		_methodName409 = "countbyGunId_Type";

		_methodParameterTypes409 = new String[] { "long", "int" };

		_methodName410 = "findbyKind_Shooter";

		_methodParameterTypes410 = new String[] {
				"java.lang.String", "java.lang.String", "long", "int", "int"
			};

		_methodName411 = "findCanebyKind_Shooter";

		_methodParameterTypes411 = new String[] {
=======
		_methodName393 = "getESFGunByLikeC_K_T";

		_methodParameterTypes393 = new String[] {
				"java.lang.String", "long", "int", "int", "int"
			};

		_methodName394 = "countESFGunByLikeC_K_T";

		_methodParameterTypes394 = new String[] {
				"java.lang.String", "long", "int"
			};

		_methodName395 = "getESFGunByLikeS_T";

		_methodParameterTypes395 = new String[] { "long", "int", "int", "int" };

		_methodName396 = "countESFGunByLikeS_T";

		_methodParameterTypes396 = new String[] { "long", "int" };

		_methodName397 = "getESFGunByT";

		_methodParameterTypes397 = new String[] { "int", "int", "int" };

		_methodName398 = "countESFGunByT";

		_methodParameterTypes398 = new String[] { "int" };

		_methodName399 = "findbyESFGunId";

		_methodParameterTypes399 = new String[] { "long" };

		_methodName400 = "findbyESFGunId_Type";

		_methodParameterTypes400 = new String[] { "long", "int" };

		_methodName401 = "findbyCode";

		_methodParameterTypes401 = new String[] { "java.lang.String" };

		_methodName402 = "findbyGunId_Type";

		_methodParameterTypes402 = new String[] { "long", "int", "int", "int" };

		_methodName403 = "countbyGunId_Type";

		_methodParameterTypes403 = new String[] { "long", "int" };

		_methodName404 = "findbyKind_Shooter";

		_methodParameterTypes404 = new String[] {
				"java.lang.String", "java.lang.String", "long", "int", "int"
			};

		_methodName405 = "findCanebyKind_Shooter";

		_methodParameterTypes405 = new String[] {
>>>>>>> origin/ID32
				"java.lang.String", "java.lang.String", "long", "int", "int"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return ESFgunUserLocalServiceUtil.addESFgunUser((it.ethica.esf.model.ESFgunUser)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return ESFgunUserLocalServiceUtil.createESFgunUser(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return ESFgunUserLocalServiceUtil.deleteESFgunUser(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return ESFgunUserLocalServiceUtil.deleteESFgunUser((it.ethica.esf.model.ESFgunUser)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return ESFgunUserLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return ESFgunUserLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return ESFgunUserLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return ESFgunUserLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return ESFgunUserLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return ESFgunUserLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return ESFgunUserLocalServiceUtil.fetchESFgunUser(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return ESFgunUserLocalServiceUtil.getESFgunUser(((Long)arguments[0]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return ESFgunUserLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return ESFgunUserLocalServiceUtil.getESFgunUsers(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return ESFgunUserLocalServiceUtil.getESFgunUsersCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return ESFgunUserLocalServiceUtil.updateESFgunUser((it.ethica.esf.model.ESFgunUser)arguments[0]);
		}

<<<<<<< HEAD
		if (_methodName392.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes392, parameterTypes)) {
			return ESFgunUserLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName393.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes393, parameterTypes)) {
=======
		if (_methodName386.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes386, parameterTypes)) {
			return ESFgunUserLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName387.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes387, parameterTypes)) {
>>>>>>> origin/ID32
			ESFgunUserLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

<<<<<<< HEAD
		if (_methodName398.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes398, parameterTypes)) {
=======
		if (_methodName392.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes392, parameterTypes)) {
>>>>>>> origin/ID32
			return ESFgunUserLocalServiceUtil.addESFGunUser(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				(java.lang.String)arguments[2],
				((Boolean)arguments[3]).booleanValue(),
				((Integer)arguments[4]).intValue(),
				(java.lang.String)arguments[5],
				((Long)arguments[6]).longValue(),
				((Long)arguments[7]).longValue(),
				((Integer)arguments[8]).intValue(),
				(java.lang.String)arguments[9],
				((Long)arguments[10]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[11]);
		}

<<<<<<< HEAD
		if (_methodName399.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes399, parameterTypes)) {
=======
		if (_methodName393.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes393, parameterTypes)) {
>>>>>>> origin/ID32
			return ESFgunUserLocalServiceUtil.getESFGunByLikeC_K_T((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue());
		}

<<<<<<< HEAD
		if (_methodName400.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes400, parameterTypes)) {
=======
		if (_methodName394.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes394, parameterTypes)) {
>>>>>>> origin/ID32
			return ESFgunUserLocalServiceUtil.countESFGunByLikeC_K_T((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue());
		}

<<<<<<< HEAD
		if (_methodName401.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes401, parameterTypes)) {
=======
		if (_methodName395.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes395, parameterTypes)) {
>>>>>>> origin/ID32
			return ESFgunUserLocalServiceUtil.getESFGunByLikeS_T(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

<<<<<<< HEAD
		if (_methodName402.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes402, parameterTypes)) {
=======
		if (_methodName396.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes396, parameterTypes)) {
>>>>>>> origin/ID32
			return ESFgunUserLocalServiceUtil.countESFGunByLikeS_T(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue());
		}

<<<<<<< HEAD
		if (_methodName403.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes403, parameterTypes)) {
=======
		if (_methodName397.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes397, parameterTypes)) {
>>>>>>> origin/ID32
			return ESFgunUserLocalServiceUtil.getESFGunByT(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

<<<<<<< HEAD
		if (_methodName404.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes404, parameterTypes)) {
			return ESFgunUserLocalServiceUtil.countESFGunByT(((Integer)arguments[0]).intValue());
		}

		if (_methodName405.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes405, parameterTypes)) {
			return ESFgunUserLocalServiceUtil.findbyESFGunId(((Long)arguments[0]).longValue());
		}

		if (_methodName406.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes406, parameterTypes)) {
=======
		if (_methodName398.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes398, parameterTypes)) {
			return ESFgunUserLocalServiceUtil.countESFGunByT(((Integer)arguments[0]).intValue());
		}

		if (_methodName399.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes399, parameterTypes)) {
			return ESFgunUserLocalServiceUtil.findbyESFGunId(((Long)arguments[0]).longValue());
		}

		if (_methodName400.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes400, parameterTypes)) {
>>>>>>> origin/ID32
			return ESFgunUserLocalServiceUtil.findbyESFGunId_Type(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue());
		}

<<<<<<< HEAD
		if (_methodName407.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes407, parameterTypes)) {
			return ESFgunUserLocalServiceUtil.findbyCode((java.lang.String)arguments[0]);
		}

		if (_methodName408.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes408, parameterTypes)) {
=======
		if (_methodName401.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes401, parameterTypes)) {
			return ESFgunUserLocalServiceUtil.findbyCode((java.lang.String)arguments[0]);
		}

		if (_methodName402.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes402, parameterTypes)) {
>>>>>>> origin/ID32
			return ESFgunUserLocalServiceUtil.findbyGunId_Type(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

<<<<<<< HEAD
		if (_methodName409.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes409, parameterTypes)) {
=======
		if (_methodName403.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes403, parameterTypes)) {
>>>>>>> origin/ID32
			return ESFgunUserLocalServiceUtil.countbyGunId_Type(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue());
		}

<<<<<<< HEAD
		if (_methodName410.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes410, parameterTypes)) {
=======
		if (_methodName404.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes404, parameterTypes)) {
>>>>>>> origin/ID32
			return ESFgunUserLocalServiceUtil.findbyKind_Shooter((java.lang.String)arguments[0],
				(java.lang.String)arguments[1],
				((Long)arguments[2]).longValue(),
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue());
		}

<<<<<<< HEAD
		if (_methodName411.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes411, parameterTypes)) {
=======
		if (_methodName405.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes405, parameterTypes)) {
>>>>>>> origin/ID32
			return ESFgunUserLocalServiceUtil.findCanebyKind_Shooter((java.lang.String)arguments[0],
				(java.lang.String)arguments[1],
				((Long)arguments[2]).longValue(),
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue());
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
	private String _methodName402;
	private String[] _methodParameterTypes402;
	private String _methodName403;
	private String[] _methodParameterTypes403;
	private String _methodName404;
	private String[] _methodParameterTypes404;
	private String _methodName405;
	private String[] _methodParameterTypes405;
<<<<<<< HEAD
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
=======
>>>>>>> origin/ID32
}