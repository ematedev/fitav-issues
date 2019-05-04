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
		_methodName380 = "getBeanIdentifier";

		_methodParameterTypes380 = new String[] {  };

		_methodName381 = "setBeanIdentifier";

		_methodParameterTypes381 = new String[] { "java.lang.String" };

		_methodName386 = "addESFGunUser";

		_methodParameterTypes386 = new String[] {
=======
		_methodName372 = "getBeanIdentifier";

		_methodParameterTypes372 = new String[] {  };

		_methodName373 = "setBeanIdentifier";

		_methodParameterTypes373 = new String[] { "java.lang.String" };

		_methodName378 = "addESFGunUser";

		_methodParameterTypes378 = new String[] {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
				"long", "long", "java.lang.String", "boolean", "int",
				"java.lang.String", "long", "long", "int", "java.lang.String",
				"long", "com.liferay.portal.service.ServiceContext"
			};

<<<<<<< HEAD
		_methodName387 = "getESFGunByLikeC_K_T";

		_methodParameterTypes387 = new String[] {
				"java.lang.String", "long", "int", "int", "int"
			};

		_methodName388 = "countESFGunByLikeC_K_T";

		_methodParameterTypes388 = new String[] {
				"java.lang.String", "long", "int"
			};

		_methodName389 = "getESFGunByLikeS_T";

		_methodParameterTypes389 = new String[] { "long", "int", "int", "int" };

		_methodName390 = "countESFGunByLikeS_T";

		_methodParameterTypes390 = new String[] { "long", "int" };

		_methodName391 = "getESFGunByT";

		_methodParameterTypes391 = new String[] { "int", "int", "int" };

		_methodName392 = "countESFGunByT";

		_methodParameterTypes392 = new String[] { "int" };

		_methodName393 = "findbyESFGunId";

		_methodParameterTypes393 = new String[] { "long" };

		_methodName394 = "findbyESFGunId_Type";

		_methodParameterTypes394 = new String[] { "long", "int" };

		_methodName395 = "findbyCode";

		_methodParameterTypes395 = new String[] { "java.lang.String" };

		_methodName396 = "findbyGunId_Type";

		_methodParameterTypes396 = new String[] { "long", "int", "int", "int" };

		_methodName397 = "countbyGunId_Type";

		_methodParameterTypes397 = new String[] { "long", "int" };

		_methodName398 = "findbyKind_Shooter";

		_methodParameterTypes398 = new String[] {
				"java.lang.String", "java.lang.String", "long", "int", "int"
			};

		_methodName399 = "findCanebyKind_Shooter";

		_methodParameterTypes399 = new String[] {
=======
		_methodName379 = "getESFGunByLikeC_K_T";

		_methodParameterTypes379 = new String[] {
				"java.lang.String", "long", "int", "int", "int"
			};

		_methodName380 = "countESFGunByLikeC_K_T";

		_methodParameterTypes380 = new String[] {
				"java.lang.String", "long", "int"
			};

		_methodName381 = "getESFGunByLikeS_T";

		_methodParameterTypes381 = new String[] { "long", "int", "int", "int" };

		_methodName382 = "countESFGunByLikeS_T";

		_methodParameterTypes382 = new String[] { "long", "int" };

		_methodName383 = "getESFGunByT";

		_methodParameterTypes383 = new String[] { "int", "int", "int" };

		_methodName384 = "countESFGunByT";

		_methodParameterTypes384 = new String[] { "int" };

		_methodName385 = "findbyESFGunId";

		_methodParameterTypes385 = new String[] { "long" };

		_methodName386 = "findbyESFGunId_Type";

		_methodParameterTypes386 = new String[] { "long", "int" };

		_methodName387 = "findbyCode";

		_methodParameterTypes387 = new String[] { "java.lang.String" };

		_methodName388 = "findbyGunId_Type";

		_methodParameterTypes388 = new String[] { "long", "int", "int", "int" };

		_methodName389 = "countbyGunId_Type";

		_methodParameterTypes389 = new String[] { "long", "int" };

		_methodName390 = "findbyKind_Shooter";

		_methodParameterTypes390 = new String[] {
				"java.lang.String", "java.lang.String", "long", "int", "int"
			};

		_methodName391 = "findCanebyKind_Shooter";

		_methodParameterTypes391 = new String[] {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
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
		if (_methodName380.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes380, parameterTypes)) {
			return ESFgunUserLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName381.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes381, parameterTypes)) {
=======
		if (_methodName372.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes372, parameterTypes)) {
			return ESFgunUserLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName373.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes373, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			ESFgunUserLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

<<<<<<< HEAD
		if (_methodName386.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes386, parameterTypes)) {
=======
		if (_methodName378.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes378, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
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
		if (_methodName387.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes387, parameterTypes)) {
=======
		if (_methodName379.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes379, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFgunUserLocalServiceUtil.getESFGunByLikeC_K_T((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue());
		}

<<<<<<< HEAD
		if (_methodName388.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes388, parameterTypes)) {
=======
		if (_methodName380.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes380, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFgunUserLocalServiceUtil.countESFGunByLikeC_K_T((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue());
		}

<<<<<<< HEAD
		if (_methodName389.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes389, parameterTypes)) {
=======
		if (_methodName381.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes381, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFgunUserLocalServiceUtil.getESFGunByLikeS_T(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

<<<<<<< HEAD
		if (_methodName390.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes390, parameterTypes)) {
=======
		if (_methodName382.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes382, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFgunUserLocalServiceUtil.countESFGunByLikeS_T(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue());
		}

<<<<<<< HEAD
		if (_methodName391.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes391, parameterTypes)) {
=======
		if (_methodName383.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes383, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFgunUserLocalServiceUtil.getESFGunByT(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

<<<<<<< HEAD
		if (_methodName392.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes392, parameterTypes)) {
			return ESFgunUserLocalServiceUtil.countESFGunByT(((Integer)arguments[0]).intValue());
		}

		if (_methodName393.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes393, parameterTypes)) {
			return ESFgunUserLocalServiceUtil.findbyESFGunId(((Long)arguments[0]).longValue());
		}

		if (_methodName394.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes394, parameterTypes)) {
=======
		if (_methodName384.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes384, parameterTypes)) {
			return ESFgunUserLocalServiceUtil.countESFGunByT(((Integer)arguments[0]).intValue());
		}

		if (_methodName385.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes385, parameterTypes)) {
			return ESFgunUserLocalServiceUtil.findbyESFGunId(((Long)arguments[0]).longValue());
		}

		if (_methodName386.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes386, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFgunUserLocalServiceUtil.findbyESFGunId_Type(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue());
		}

<<<<<<< HEAD
		if (_methodName395.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes395, parameterTypes)) {
			return ESFgunUserLocalServiceUtil.findbyCode((java.lang.String)arguments[0]);
		}

		if (_methodName396.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes396, parameterTypes)) {
=======
		if (_methodName387.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes387, parameterTypes)) {
			return ESFgunUserLocalServiceUtil.findbyCode((java.lang.String)arguments[0]);
		}

		if (_methodName388.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes388, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFgunUserLocalServiceUtil.findbyGunId_Type(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

<<<<<<< HEAD
		if (_methodName397.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes397, parameterTypes)) {
=======
		if (_methodName389.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes389, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFgunUserLocalServiceUtil.countbyGunId_Type(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue());
		}

<<<<<<< HEAD
		if (_methodName398.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes398, parameterTypes)) {
=======
		if (_methodName390.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes390, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFgunUserLocalServiceUtil.findbyKind_Shooter((java.lang.String)arguments[0],
				(java.lang.String)arguments[1],
				((Long)arguments[2]).longValue(),
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue());
		}

<<<<<<< HEAD
		if (_methodName399.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes399, parameterTypes)) {
=======
		if (_methodName391.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes391, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
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
	private String _methodName372;
	private String[] _methodParameterTypes372;
	private String _methodName373;
	private String[] _methodParameterTypes373;
	private String _methodName378;
	private String[] _methodParameterTypes378;
	private String _methodName379;
	private String[] _methodParameterTypes379;
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
	private String _methodName380;
	private String[] _methodParameterTypes380;
	private String _methodName381;
	private String[] _methodParameterTypes381;
	private String _methodName386;
	private String[] _methodParameterTypes386;
	private String _methodName387;
	private String[] _methodParameterTypes387;
	private String _methodName388;
	private String[] _methodParameterTypes388;
	private String _methodName389;
	private String[] _methodParameterTypes389;
	private String _methodName390;
	private String[] _methodParameterTypes390;
	private String _methodName391;
	private String[] _methodParameterTypes391;
<<<<<<< HEAD
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
	private String _methodName397;
	private String[] _methodParameterTypes397;
	private String _methodName398;
	private String[] _methodParameterTypes398;
	private String _methodName399;
	private String[] _methodParameterTypes399;
=======
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
}