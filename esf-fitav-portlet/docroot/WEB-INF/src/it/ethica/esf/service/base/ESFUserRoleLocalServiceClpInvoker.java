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

import it.ethica.esf.service.ESFUserRoleLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Ethica
 * @generated
 */
public class ESFUserRoleLocalServiceClpInvoker {
	public ESFUserRoleLocalServiceClpInvoker() {
		_methodName0 = "addESFUserRole";

		_methodParameterTypes0 = new String[] { "it.ethica.esf.model.ESFUserRole" };

		_methodName1 = "createESFUserRole";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteESFUserRole";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteESFUserRole";

		_methodParameterTypes3 = new String[] { "it.ethica.esf.model.ESFUserRole" };

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

		_methodName10 = "fetchESFUserRole";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "fetchESFUserRoleByUuidAndCompanyId";

		_methodParameterTypes11 = new String[] { "java.lang.String", "long" };

		_methodName12 = "fetchESFUserRoleByUuidAndGroupId";

		_methodParameterTypes12 = new String[] { "java.lang.String", "long" };

		_methodName13 = "getESFUserRole";

		_methodParameterTypes13 = new String[] { "long" };

		_methodName14 = "getPersistedModel";

		_methodParameterTypes14 = new String[] { "java.io.Serializable" };

		_methodName15 = "getESFUserRoleByUuidAndCompanyId";

		_methodParameterTypes15 = new String[] { "java.lang.String", "long" };

		_methodName16 = "getESFUserRoleByUuidAndGroupId";

		_methodParameterTypes16 = new String[] { "java.lang.String", "long" };

		_methodName17 = "getESFUserRoles";

		_methodParameterTypes17 = new String[] { "int", "int" };

		_methodName18 = "getESFUserRolesCount";

		_methodParameterTypes18 = new String[] {  };

		_methodName19 = "updateESFUserRole";

		_methodParameterTypes19 = new String[] { "it.ethica.esf.model.ESFUserRole" };

<<<<<<< HEAD
		_methodName384 = "getBeanIdentifier";

		_methodParameterTypes384 = new String[] {  };

		_methodName385 = "setBeanIdentifier";

		_methodParameterTypes385 = new String[] { "java.lang.String" };

		_methodName390 = "getAllEsfUserRole";

		_methodParameterTypes390 = new String[] {  };

		_methodName391 = "getAllEsfUserRole";

		_methodParameterTypes391 = new String[] { "int", "int" };

		_methodName392 = "getAllEsfUserRoleByType";

		_methodParameterTypes392 = new String[] { "int" };

		_methodName393 = "getAllEsfUserRoleByType";

		_methodParameterTypes393 = new String[] { "int", "int", "int" };

		_methodName394 = "getAllEsfUserRoleByStateNoAssign";

		_methodParameterTypes394 = new String[] { "long", "int", "int" };

		_methodName395 = "countAllEsfUserRoleByStateNoAssign";

		_methodParameterTypes395 = new String[] { "long" };

		_methodName396 = "getAllUserRoleByLikeT_N";

		_methodParameterTypes396 = new String[] {
				"java.lang.String", "java.lang.String", "int", "int", "int"
			};

		_methodName397 = "getAllUserRoleByLikeT_N";

		_methodParameterTypes397 = new String[] {
				"java.lang.String", "java.lang.String", "int"
			};

		_methodName398 = "getEsfUserRoleByState";

		_methodParameterTypes398 = new String[] { "int" };

		_methodName399 = "getEsfUserRoleByState";

		_methodParameterTypes399 = new String[] { "int", "int", "int" };

		_methodName400 = "getAllEsfUserRoleByT_S";

		_methodParameterTypes400 = new String[] { "int", "int" };

		_methodName401 = "getAllEsfUserRoleByT_S";

		_methodParameterTypes401 = new String[] { "int", "int", "int", "int" };

		_methodName402 = "getEsfUserRoleByT_S_BDO";

		_methodParameterTypes402 = new String[] { "int", "int", "boolean" };

		_methodName403 = "getEsfUserRoleByT_S_BDO";

		_methodParameterTypes403 = new String[] {
				"int", "int", "boolean", "int", "int"
			};

		_methodName404 = "getEsfUserRoleByT_S_BDO_OrgId";

		_methodParameterTypes404 = new String[] { "int", "int", "boolean", "long" };

		_methodName405 = "getAllEsfUserRoleCount";

		_methodParameterTypes405 = new String[] {  };

		_methodName406 = "addESFUserRole";

		_methodParameterTypes406 = new String[] {
=======
		_methodName376 = "getBeanIdentifier";

		_methodParameterTypes376 = new String[] {  };

		_methodName377 = "setBeanIdentifier";

		_methodParameterTypes377 = new String[] { "java.lang.String" };

		_methodName382 = "getAllEsfUserRole";

		_methodParameterTypes382 = new String[] {  };

		_methodName383 = "getAllEsfUserRole";

		_methodParameterTypes383 = new String[] { "int", "int" };

		_methodName384 = "getAllEsfUserRoleByType";

		_methodParameterTypes384 = new String[] { "int" };

		_methodName385 = "getAllEsfUserRoleByType";

		_methodParameterTypes385 = new String[] { "int", "int", "int" };

		_methodName386 = "getAllEsfUserRoleByStateNoAssign";

		_methodParameterTypes386 = new String[] { "long", "int", "int" };

		_methodName387 = "countAllEsfUserRoleByStateNoAssign";

		_methodParameterTypes387 = new String[] { "long" };

		_methodName388 = "getAllUserRoleByLikeT_N";

		_methodParameterTypes388 = new String[] {
				"java.lang.String", "java.lang.String", "int", "int", "int"
			};

		_methodName389 = "getAllUserRoleByLikeT_N";

		_methodParameterTypes389 = new String[] {
				"java.lang.String", "java.lang.String", "int"
			};

		_methodName390 = "getEsfUserRoleByState";

		_methodParameterTypes390 = new String[] { "int" };

		_methodName391 = "getEsfUserRoleByState";

		_methodParameterTypes391 = new String[] { "int", "int", "int" };

		_methodName392 = "getAllEsfUserRoleByT_S";

		_methodParameterTypes392 = new String[] { "int", "int" };

		_methodName393 = "getAllEsfUserRoleByT_S";

		_methodParameterTypes393 = new String[] { "int", "int", "int", "int" };

		_methodName394 = "getEsfUserRoleByT_S_BDO";

		_methodParameterTypes394 = new String[] { "int", "int", "boolean" };

		_methodName395 = "getEsfUserRoleByT_S_BDO";

		_methodParameterTypes395 = new String[] {
				"int", "int", "boolean", "int", "int"
			};

		_methodName396 = "getEsfUserRoleByT_S_BDO_OrgId";

		_methodParameterTypes396 = new String[] { "int", "int", "boolean", "long" };

		_methodName397 = "getAllEsfUserRoleCount";

		_methodParameterTypes397 = new String[] {  };

		_methodName398 = "addESFUserRole";

		_methodParameterTypes398 = new String[] {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
				"long", "long", "long", "java.lang.String", "java.lang.String",
				"java.util.Map", "java.util.Map", "int", "java.lang.String",
				"boolean", "boolean", "boolean", "boolean", "int",
				"it.ethica.esf.model.ESFEntityState"
			};

<<<<<<< HEAD
		_methodName407 = "addESFUserRole";

		_methodParameterTypes407 = new String[] {
=======
		_methodName399 = "addESFUserRole";

		_methodParameterTypes399 = new String[] {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
				"long", "java.lang.String", "java.lang.String",
				"java.lang.String", "long", "java.util.Map", "java.util.Map",
				"int", "java.lang.String", "boolean", "boolean", "boolean",
				"boolean", "int", "it.ethica.esf.model.ESFEntityState",
				"com.liferay.portal.service.ServiceContext"
			};

<<<<<<< HEAD
		_methodName408 = "deleteESFUserRole";

		_methodParameterTypes408 = new String[] {
				"long", "com.liferay.portal.service.ServiceContext"
			};

		_methodName409 = "updateESFUserRole";

		_methodParameterTypes409 = new String[] {
=======
		_methodName400 = "deleteESFUserRole";

		_methodParameterTypes400 = new String[] {
				"long", "com.liferay.portal.service.ServiceContext"
			};

		_methodName401 = "updateESFUserRole";

		_methodParameterTypes401 = new String[] {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
				"long", "long", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.util.Map", "java.util.Map", "int",
				"java.lang.String", "boolean", "boolean", "boolean", "boolean",
				"int", "com.liferay.portal.service.ServiceContext"
			};

<<<<<<< HEAD
		_methodName410 = "checkNome";

		_methodParameterTypes410 = new String[] {
=======
		_methodName402 = "checkNome";

		_methodParameterTypes402 = new String[] {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
				"java.lang.String", "com.liferay.portal.service.ServiceContext"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return ESFUserRoleLocalServiceUtil.addESFUserRole((it.ethica.esf.model.ESFUserRole)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return ESFUserRoleLocalServiceUtil.createESFUserRole(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return ESFUserRoleLocalServiceUtil.deleteESFUserRole(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return ESFUserRoleLocalServiceUtil.deleteESFUserRole((it.ethica.esf.model.ESFUserRole)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return ESFUserRoleLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return ESFUserRoleLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return ESFUserRoleLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return ESFUserRoleLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return ESFUserRoleLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return ESFUserRoleLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return ESFUserRoleLocalServiceUtil.fetchESFUserRole(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return ESFUserRoleLocalServiceUtil.fetchESFUserRoleByUuidAndCompanyId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return ESFUserRoleLocalServiceUtil.fetchESFUserRoleByUuidAndGroupId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return ESFUserRoleLocalServiceUtil.getESFUserRole(((Long)arguments[0]).longValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return ESFUserRoleLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return ESFUserRoleLocalServiceUtil.getESFUserRoleByUuidAndCompanyId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName16.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes16, parameterTypes)) {
			return ESFUserRoleLocalServiceUtil.getESFUserRoleByUuidAndGroupId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName17.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes17, parameterTypes)) {
			return ESFUserRoleLocalServiceUtil.getESFUserRoles(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName18.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes18, parameterTypes)) {
			return ESFUserRoleLocalServiceUtil.getESFUserRolesCount();
		}

		if (_methodName19.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes19, parameterTypes)) {
			return ESFUserRoleLocalServiceUtil.updateESFUserRole((it.ethica.esf.model.ESFUserRole)arguments[0]);
		}

<<<<<<< HEAD
		if (_methodName384.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes384, parameterTypes)) {
			return ESFUserRoleLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName385.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes385, parameterTypes)) {
=======
		if (_methodName376.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes376, parameterTypes)) {
			return ESFUserRoleLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName377.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes377, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			ESFUserRoleLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

<<<<<<< HEAD
		if (_methodName390.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes390, parameterTypes)) {
			return ESFUserRoleLocalServiceUtil.getAllEsfUserRole();
		}

		if (_methodName391.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes391, parameterTypes)) {
=======
		if (_methodName382.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes382, parameterTypes)) {
			return ESFUserRoleLocalServiceUtil.getAllEsfUserRole();
		}

		if (_methodName383.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes383, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFUserRoleLocalServiceUtil.getAllEsfUserRole(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

<<<<<<< HEAD
		if (_methodName392.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes392, parameterTypes)) {
			return ESFUserRoleLocalServiceUtil.getAllEsfUserRoleByType(((Integer)arguments[0]).intValue());
		}

		if (_methodName393.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes393, parameterTypes)) {
=======
		if (_methodName384.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes384, parameterTypes)) {
			return ESFUserRoleLocalServiceUtil.getAllEsfUserRoleByType(((Integer)arguments[0]).intValue());
		}

		if (_methodName385.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes385, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFUserRoleLocalServiceUtil.getAllEsfUserRoleByType(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

<<<<<<< HEAD
		if (_methodName394.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes394, parameterTypes)) {
=======
		if (_methodName386.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes386, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFUserRoleLocalServiceUtil.getAllEsfUserRoleByStateNoAssign(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

<<<<<<< HEAD
		if (_methodName395.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes395, parameterTypes)) {
			return ESFUserRoleLocalServiceUtil.countAllEsfUserRoleByStateNoAssign(((Long)arguments[0]).longValue());
		}

		if (_methodName396.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes396, parameterTypes)) {
=======
		if (_methodName387.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes387, parameterTypes)) {
			return ESFUserRoleLocalServiceUtil.countAllEsfUserRoleByStateNoAssign(((Long)arguments[0]).longValue());
		}

		if (_methodName388.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes388, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFUserRoleLocalServiceUtil.getAllUserRoleByLikeT_N((java.lang.String)arguments[0],
				(java.lang.String)arguments[1],
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue());
		}

<<<<<<< HEAD
		if (_methodName397.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes397, parameterTypes)) {
=======
		if (_methodName389.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes389, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFUserRoleLocalServiceUtil.getAllUserRoleByLikeT_N((java.lang.String)arguments[0],
				(java.lang.String)arguments[1],
				((Integer)arguments[2]).intValue());
		}

<<<<<<< HEAD
		if (_methodName398.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes398, parameterTypes)) {
			return ESFUserRoleLocalServiceUtil.getEsfUserRoleByState(((Integer)arguments[0]).intValue());
		}

		if (_methodName399.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes399, parameterTypes)) {
=======
		if (_methodName390.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes390, parameterTypes)) {
			return ESFUserRoleLocalServiceUtil.getEsfUserRoleByState(((Integer)arguments[0]).intValue());
		}

		if (_methodName391.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes391, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFUserRoleLocalServiceUtil.getEsfUserRoleByState(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

<<<<<<< HEAD
		if (_methodName400.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes400, parameterTypes)) {
=======
		if (_methodName392.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes392, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFUserRoleLocalServiceUtil.getAllEsfUserRoleByT_S(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

<<<<<<< HEAD
		if (_methodName401.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes401, parameterTypes)) {
=======
		if (_methodName393.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes393, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFUserRoleLocalServiceUtil.getAllEsfUserRoleByT_S(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

<<<<<<< HEAD
		if (_methodName402.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes402, parameterTypes)) {
=======
		if (_methodName394.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes394, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFUserRoleLocalServiceUtil.getEsfUserRoleByT_S_BDO(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue(),
				((Boolean)arguments[2]).booleanValue());
		}

<<<<<<< HEAD
		if (_methodName403.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes403, parameterTypes)) {
=======
		if (_methodName395.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes395, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFUserRoleLocalServiceUtil.getEsfUserRoleByT_S_BDO(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue(),
				((Boolean)arguments[2]).booleanValue(),
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue());
		}

<<<<<<< HEAD
		if (_methodName404.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes404, parameterTypes)) {
=======
		if (_methodName396.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes396, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFUserRoleLocalServiceUtil.getEsfUserRoleByT_S_BDO_OrgId(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue(),
				((Boolean)arguments[2]).booleanValue(),
				((Long)arguments[3]).longValue());
		}

<<<<<<< HEAD
		if (_methodName405.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes405, parameterTypes)) {
			return ESFUserRoleLocalServiceUtil.getAllEsfUserRoleCount();
		}

		if (_methodName406.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes406, parameterTypes)) {
=======
		if (_methodName397.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes397, parameterTypes)) {
			return ESFUserRoleLocalServiceUtil.getAllEsfUserRoleCount();
		}

		if (_methodName398.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes398, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFUserRoleLocalServiceUtil.addESFUserRole(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				(java.lang.String)arguments[3], (java.lang.String)arguments[4],
				(java.util.Map<java.util.Locale, java.lang.String>)arguments[5],
				(java.util.Map<java.util.Locale, java.lang.String>)arguments[6],
				((Integer)arguments[7]).intValue(),
				(java.lang.String)arguments[8],
				((Boolean)arguments[9]).booleanValue(),
				((Boolean)arguments[10]).booleanValue(),
				((Boolean)arguments[11]).booleanValue(),
				((Boolean)arguments[12]).booleanValue(),
				((Integer)arguments[13]).intValue(),
				(it.ethica.esf.model.ESFEntityState)arguments[14]);
		}

<<<<<<< HEAD
		if (_methodName407.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes407, parameterTypes)) {
=======
		if (_methodName399.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes399, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFUserRoleLocalServiceUtil.addESFUserRole(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3],
				((Long)arguments[4]).longValue(),
				(java.util.Map<java.util.Locale, java.lang.String>)arguments[5],
				(java.util.Map<java.util.Locale, java.lang.String>)arguments[6],
				((Integer)arguments[7]).intValue(),
				(java.lang.String)arguments[8],
				((Boolean)arguments[9]).booleanValue(),
				((Boolean)arguments[10]).booleanValue(),
				((Boolean)arguments[11]).booleanValue(),
				((Boolean)arguments[12]).booleanValue(),
				((Integer)arguments[13]).intValue(),
				(it.ethica.esf.model.ESFEntityState)arguments[14],
				(com.liferay.portal.service.ServiceContext)arguments[15]);
		}

<<<<<<< HEAD
		if (_methodName408.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes408, parameterTypes)) {
=======
		if (_methodName400.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes400, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFUserRoleLocalServiceUtil.deleteESFUserRole(((Long)arguments[0]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[1]);
		}

<<<<<<< HEAD
		if (_methodName409.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes409, parameterTypes)) {
=======
		if (_methodName401.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes401, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFUserRoleLocalServiceUtil.updateESFUserRole(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3],
				(java.lang.String)arguments[4],
				(java.util.Map<java.util.Locale, java.lang.String>)arguments[5],
				(java.util.Map<java.util.Locale, java.lang.String>)arguments[6],
				((Integer)arguments[7]).intValue(),
				(java.lang.String)arguments[8],
				((Boolean)arguments[9]).booleanValue(),
				((Boolean)arguments[10]).booleanValue(),
				((Boolean)arguments[11]).booleanValue(),
				((Boolean)arguments[12]).booleanValue(),
				((Integer)arguments[13]).intValue(),
				(com.liferay.portal.service.ServiceContext)arguments[14]);
		}

<<<<<<< HEAD
		if (_methodName410.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes410, parameterTypes)) {
=======
		if (_methodName402.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes402, parameterTypes)) {
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
			return ESFUserRoleLocalServiceUtil.checkNome((java.lang.String)arguments[0],
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
<<<<<<< HEAD
=======
	private String _methodName376;
	private String[] _methodParameterTypes376;
	private String _methodName377;
	private String[] _methodParameterTypes377;
	private String _methodName382;
	private String[] _methodParameterTypes382;
	private String _methodName383;
	private String[] _methodParameterTypes383;
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
	private String _methodName384;
	private String[] _methodParameterTypes384;
	private String _methodName385;
	private String[] _methodParameterTypes385;
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
<<<<<<< HEAD
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
	private String _methodName410;
	private String[] _methodParameterTypes410;
=======
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
}