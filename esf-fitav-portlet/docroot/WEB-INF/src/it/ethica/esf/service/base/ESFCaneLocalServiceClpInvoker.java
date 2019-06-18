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

<<<<<<< HEAD
		_methodName392 = "getBeanIdentifier";

		_methodParameterTypes392 = new String[] {  };

		_methodName393 = "setBeanIdentifier";

		_methodParameterTypes393 = new String[] { "java.lang.String" };

		_methodName398 = "addESFCane";

		_methodParameterTypes398 = new String[] {
=======
		_methodName386 = "getBeanIdentifier";

		_methodParameterTypes386 = new String[] {  };

		_methodName387 = "setBeanIdentifier";

		_methodParameterTypes387 = new String[] { "java.lang.String" };

		_methodName392 = "addESFCane";

		_methodParameterTypes392 = new String[] {
>>>>>>> origin/ID32
				"long", "long", "long", "long", "long", "java.lang.String",
				"long", "int", "java.lang.String", "boolean", "long",
				"java.lang.String", "com.liferay.portal.service.ServiceContext"
			};

<<<<<<< HEAD
		_methodName399 = "updateESFCane";

		_methodParameterTypes399 = new String[] {
=======
		_methodName393 = "updateESFCane";

		_methodParameterTypes393 = new String[] {
>>>>>>> origin/ID32
				"long", "long", "long", "long", "long", "java.lang.String",
				"long", "int", "java.lang.String", "boolean", "long",
				"java.lang.String", "long",
				"com.liferay.portal.service.ServiceContext"
			};

<<<<<<< HEAD
		_methodName400 = "deleteESFCane";

		_methodParameterTypes400 = new String[] {
				"long", "com.liferay.portal.service.ServiceContext"
			};

		_methodName401 = "getESFCanesByUserId";

		_methodParameterTypes401 = new String[] { "long" };

		_methodName402 = "getESFCanesByUserId";

		_methodParameterTypes402 = new String[] { "long", "int", "int" };

		_methodName403 = "getESFCanes";

		_methodParameterTypes403 = new String[] {  };

		_methodName404 = "getESFCanes";

		_methodParameterTypes404 = new String[] { "int", "int" };

		_methodName405 = "getESFCaneByLikeC_K";

		_methodParameterTypes405 = new String[] { "java.lang.String", "long" };

		_methodName406 = "getESFCaneByLikeC_K";

		_methodParameterTypes406 = new String[] {
				"java.lang.String", "long", "int", "int"
			};

		_methodName407 = "getESFGunByLikeC_K_U";

		_methodParameterTypes407 = new String[] {
				"java.lang.String", "long", "long"
			};

		_methodName408 = "getESFGunByLikeC_K_U";

		_methodParameterTypes408 = new String[] {
				"java.lang.String", "long", "long", "int", "int"
			};

		_methodName409 = "getESFGunByLikeT_C_K_U";

		_methodParameterTypes409 = new String[] {
				"long", "java.lang.String", "long", "long", "int", "int"
			};

		_methodName410 = "countESFGunByLikeT_C_K_U";

		_methodParameterTypes410 = new String[] {
				"long", "java.lang.String", "long", "long"
			};

		_methodName411 = "getESFGunByLikeT_K";

		_methodParameterTypes411 = new String[] { "long", "long", "int", "int" };

		_methodName412 = "countESFGunByLikeT_K";

		_methodParameterTypes412 = new String[] { "long", "long" };

		_methodName413 = "getESFGunByLikeT";

		_methodParameterTypes413 = new String[] { "long", "int", "int" };

		_methodName414 = "countESFGunByLikeT";

		_methodParameterTypes414 = new String[] { "long" };

		_methodName415 = "getFullName";

		_methodParameterTypes415 = new String[] { "it.ethica.esf.model.ESFCane" };

		_methodName417 = "getNameMod";

		_methodParameterTypes417 = new String[] { "it.ethica.esf.model.ESFCane" };

		_methodName418 = "getNameM";

		_methodParameterTypes418 = new String[] { "it.ethica.esf.model.ESFCane" };

		_methodName419 = "getNameT";

		_methodParameterTypes419 = new String[] { "it.ethica.esf.model.ESFCane" };

		_methodName420 = "checkCode";

		_methodParameterTypes420 = new String[] {
				"java.lang.String", "com.liferay.portal.service.ServiceContext"
			};

		_methodName421 = "getCanebyK";

		_methodParameterTypes421 = new String[] { "long" };

		_methodName422 = "getCanebyKindId";

		_methodParameterTypes422 = new String[] { "long", "int", "int" };

		_methodName423 = "countCanebyKindId";

		_methodParameterTypes423 = new String[] { "long" };
=======
		_methodName394 = "deleteESFCane";

		_methodParameterTypes394 = new String[] {
				"long", "com.liferay.portal.service.ServiceContext"
			};

		_methodName395 = "getESFCanesByUserId";

		_methodParameterTypes395 = new String[] { "long" };

		_methodName396 = "getESFCanesByUserId";

		_methodParameterTypes396 = new String[] { "long", "int", "int" };

		_methodName397 = "getESFCanes";

		_methodParameterTypes397 = new String[] {  };

		_methodName398 = "getESFCanes";

		_methodParameterTypes398 = new String[] { "int", "int" };

		_methodName399 = "getESFCaneByLikeC_K";

		_methodParameterTypes399 = new String[] { "java.lang.String", "long" };

		_methodName400 = "getESFCaneByLikeC_K";

		_methodParameterTypes400 = new String[] {
				"java.lang.String", "long", "int", "int"
			};

		_methodName401 = "getESFGunByLikeC_K_U";

		_methodParameterTypes401 = new String[] {
				"java.lang.String", "long", "long"
			};

		_methodName402 = "getESFGunByLikeC_K_U";

		_methodParameterTypes402 = new String[] {
				"java.lang.String", "long", "long", "int", "int"
			};

		_methodName403 = "getESFGunByLikeT_C_K_U";

		_methodParameterTypes403 = new String[] {
				"long", "java.lang.String", "long", "long", "int", "int"
			};

		_methodName404 = "countESFGunByLikeT_C_K_U";

		_methodParameterTypes404 = new String[] {
				"long", "java.lang.String", "long", "long"
			};

		_methodName405 = "getESFGunByLikeT_K";

		_methodParameterTypes405 = new String[] { "long", "long", "int", "int" };

		_methodName406 = "countESFGunByLikeT_K";

		_methodParameterTypes406 = new String[] { "long", "long" };

		_methodName407 = "getESFGunByLikeT";

		_methodParameterTypes407 = new String[] { "long", "int", "int" };

		_methodName408 = "countESFGunByLikeT";

		_methodParameterTypes408 = new String[] { "long" };

		_methodName409 = "getFullName";

		_methodParameterTypes409 = new String[] { "it.ethica.esf.model.ESFCane" };

		_methodName411 = "getNameMod";

		_methodParameterTypes411 = new String[] { "it.ethica.esf.model.ESFCane" };

		_methodName412 = "getNameM";

		_methodParameterTypes412 = new String[] { "it.ethica.esf.model.ESFCane" };

		_methodName413 = "getNameT";

		_methodParameterTypes413 = new String[] { "it.ethica.esf.model.ESFCane" };

		_methodName414 = "checkCode";

		_methodParameterTypes414 = new String[] {
				"java.lang.String", "com.liferay.portal.service.ServiceContext"
			};

		_methodName415 = "getCanebyK";

		_methodParameterTypes415 = new String[] { "long" };

		_methodName416 = "getCanebyKindId";

		_methodParameterTypes416 = new String[] { "long", "int", "int" };

		_methodName417 = "countCanebyKindId";

		_methodParameterTypes417 = new String[] { "long" };
>>>>>>> origin/ID32
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

<<<<<<< HEAD
		if (_methodName392.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes392, parameterTypes)) {
			return ESFCaneLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName393.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes393, parameterTypes)) {
=======
		if (_methodName386.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes386, parameterTypes)) {
			return ESFCaneLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName387.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes387, parameterTypes)) {
>>>>>>> origin/ID32
			ESFCaneLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

<<<<<<< HEAD
		if (_methodName398.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes398, parameterTypes)) {
=======
		if (_methodName392.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes392, parameterTypes)) {
>>>>>>> origin/ID32
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

<<<<<<< HEAD
		if (_methodName399.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes399, parameterTypes)) {
=======
		if (_methodName393.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes393, parameterTypes)) {
>>>>>>> origin/ID32
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

<<<<<<< HEAD
		if (_methodName400.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes400, parameterTypes)) {
=======
		if (_methodName394.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes394, parameterTypes)) {
>>>>>>> origin/ID32
			return ESFCaneLocalServiceUtil.deleteESFCane(((Long)arguments[0]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[1]);
		}

<<<<<<< HEAD
		if (_methodName401.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes401, parameterTypes)) {
			return ESFCaneLocalServiceUtil.getESFCanesByUserId(((Long)arguments[0]).longValue());
		}

		if (_methodName402.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes402, parameterTypes)) {
=======
		if (_methodName395.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes395, parameterTypes)) {
			return ESFCaneLocalServiceUtil.getESFCanesByUserId(((Long)arguments[0]).longValue());
		}

		if (_methodName396.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes396, parameterTypes)) {
>>>>>>> origin/ID32
			return ESFCaneLocalServiceUtil.getESFCanesByUserId(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

<<<<<<< HEAD
		if (_methodName403.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes403, parameterTypes)) {
			return ESFCaneLocalServiceUtil.getESFCanes();
		}

		if (_methodName404.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes404, parameterTypes)) {
=======
		if (_methodName397.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes397, parameterTypes)) {
			return ESFCaneLocalServiceUtil.getESFCanes();
		}

		if (_methodName398.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes398, parameterTypes)) {
>>>>>>> origin/ID32
			return ESFCaneLocalServiceUtil.getESFCanes(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

<<<<<<< HEAD
		if (_methodName405.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes405, parameterTypes)) {
=======
		if (_methodName399.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes399, parameterTypes)) {
>>>>>>> origin/ID32
			return ESFCaneLocalServiceUtil.getESFCaneByLikeC_K((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

<<<<<<< HEAD
		if (_methodName406.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes406, parameterTypes)) {
=======
		if (_methodName400.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes400, parameterTypes)) {
>>>>>>> origin/ID32
			return ESFCaneLocalServiceUtil.getESFCaneByLikeC_K((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

<<<<<<< HEAD
		if (_methodName407.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes407, parameterTypes)) {
=======
		if (_methodName401.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes401, parameterTypes)) {
>>>>>>> origin/ID32
			return ESFCaneLocalServiceUtil.getESFGunByLikeC_K_U((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue());
		}

<<<<<<< HEAD
		if (_methodName408.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes408, parameterTypes)) {
=======
		if (_methodName402.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes402, parameterTypes)) {
>>>>>>> origin/ID32
			return ESFCaneLocalServiceUtil.getESFGunByLikeC_K_U((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue());
		}

<<<<<<< HEAD
		if (_methodName409.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes409, parameterTypes)) {
=======
		if (_methodName403.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes403, parameterTypes)) {
>>>>>>> origin/ID32
			return ESFCaneLocalServiceUtil.getESFGunByLikeT_C_K_U(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1],
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue(),
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue());
		}

<<<<<<< HEAD
		if (_methodName410.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes410, parameterTypes)) {
=======
		if (_methodName404.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes404, parameterTypes)) {
>>>>>>> origin/ID32
			return ESFCaneLocalServiceUtil.countESFGunByLikeT_C_K_U(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1],
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue());
		}

<<<<<<< HEAD
		if (_methodName411.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes411, parameterTypes)) {
=======
		if (_methodName405.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes405, parameterTypes)) {
>>>>>>> origin/ID32
			return ESFCaneLocalServiceUtil.getESFGunByLikeT_K(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

<<<<<<< HEAD
		if (_methodName412.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes412, parameterTypes)) {
=======
		if (_methodName406.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes406, parameterTypes)) {
>>>>>>> origin/ID32
			return ESFCaneLocalServiceUtil.countESFGunByLikeT_K(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

<<<<<<< HEAD
		if (_methodName413.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes413, parameterTypes)) {
=======
		if (_methodName407.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes407, parameterTypes)) {
>>>>>>> origin/ID32
			return ESFCaneLocalServiceUtil.getESFGunByLikeT(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

<<<<<<< HEAD
		if (_methodName414.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes414, parameterTypes)) {
			return ESFCaneLocalServiceUtil.countESFGunByLikeT(((Long)arguments[0]).longValue());
		}

		if (_methodName415.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes415, parameterTypes)) {
			return ESFCaneLocalServiceUtil.getFullName((it.ethica.esf.model.ESFCane)arguments[0]);
		}

		if (_methodName417.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes417, parameterTypes)) {
			return ESFCaneLocalServiceUtil.getNameMod((it.ethica.esf.model.ESFCane)arguments[0]);
		}

		if (_methodName418.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes418, parameterTypes)) {
			return ESFCaneLocalServiceUtil.getNameM((it.ethica.esf.model.ESFCane)arguments[0]);
		}

		if (_methodName419.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes419, parameterTypes)) {
			return ESFCaneLocalServiceUtil.getNameT((it.ethica.esf.model.ESFCane)arguments[0]);
		}

		if (_methodName420.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes420, parameterTypes)) {
=======
		if (_methodName408.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes408, parameterTypes)) {
			return ESFCaneLocalServiceUtil.countESFGunByLikeT(((Long)arguments[0]).longValue());
		}

		if (_methodName409.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes409, parameterTypes)) {
			return ESFCaneLocalServiceUtil.getFullName((it.ethica.esf.model.ESFCane)arguments[0]);
		}

		if (_methodName411.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes411, parameterTypes)) {
			return ESFCaneLocalServiceUtil.getNameMod((it.ethica.esf.model.ESFCane)arguments[0]);
		}

		if (_methodName412.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes412, parameterTypes)) {
			return ESFCaneLocalServiceUtil.getNameM((it.ethica.esf.model.ESFCane)arguments[0]);
		}

		if (_methodName413.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes413, parameterTypes)) {
			return ESFCaneLocalServiceUtil.getNameT((it.ethica.esf.model.ESFCane)arguments[0]);
		}

		if (_methodName414.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes414, parameterTypes)) {
>>>>>>> origin/ID32
			return ESFCaneLocalServiceUtil.checkCode((java.lang.String)arguments[0],
				(com.liferay.portal.service.ServiceContext)arguments[1]);
		}

<<<<<<< HEAD
		if (_methodName421.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes421, parameterTypes)) {
			return ESFCaneLocalServiceUtil.getCanebyK(((Long)arguments[0]).longValue());
		}

		if (_methodName422.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes422, parameterTypes)) {
=======
		if (_methodName415.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes415, parameterTypes)) {
			return ESFCaneLocalServiceUtil.getCanebyK(((Long)arguments[0]).longValue());
		}

		if (_methodName416.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes416, parameterTypes)) {
>>>>>>> origin/ID32
			return ESFCaneLocalServiceUtil.getCanebyKindId(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

<<<<<<< HEAD
		if (_methodName423.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes423, parameterTypes)) {
=======
		if (_methodName417.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes417, parameterTypes)) {
>>>>>>> origin/ID32
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
	private String _methodName406;
	private String[] _methodParameterTypes406;
	private String _methodName407;
	private String[] _methodParameterTypes407;
	private String _methodName408;
	private String[] _methodParameterTypes408;
	private String _methodName409;
	private String[] _methodParameterTypes409;
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
<<<<<<< HEAD
	private String _methodName417;
	private String[] _methodParameterTypes417;
	private String _methodName418;
	private String[] _methodParameterTypes418;
	private String _methodName419;
	private String[] _methodParameterTypes419;
	private String _methodName420;
	private String[] _methodParameterTypes420;
	private String _methodName421;
	private String[] _methodParameterTypes421;
	private String _methodName422;
	private String[] _methodParameterTypes422;
	private String _methodName423;
	private String[] _methodParameterTypes423;
=======
	private String _methodName416;
	private String[] _methodParameterTypes416;
	private String _methodName417;
	private String[] _methodParameterTypes417;
>>>>>>> origin/ID32
}