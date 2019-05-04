<<<<<<< HEAD
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

import it.ethica.esf.service.ESFFederalRoleLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Ethica
 * @generated
 */
public class ESFFederalRoleLocalServiceClpInvoker {
	public ESFFederalRoleLocalServiceClpInvoker() {
		_methodName0 = "addESFFederalRole";

		_methodParameterTypes0 = new String[] {
				"it.ethica.esf.model.ESFFederalRole"
			};

		_methodName1 = "createESFFederalRole";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteESFFederalRole";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteESFFederalRole";

		_methodParameterTypes3 = new String[] {
				"it.ethica.esf.model.ESFFederalRole"
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

		_methodName10 = "fetchESFFederalRole";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "fetchESFFederalRoleByUuidAndCompanyId";

		_methodParameterTypes11 = new String[] { "java.lang.String", "long" };

		_methodName12 = "fetchESFFederalRoleByUuidAndGroupId";

		_methodParameterTypes12 = new String[] { "java.lang.String", "long" };

		_methodName13 = "getESFFederalRole";

		_methodParameterTypes13 = new String[] { "long" };

		_methodName14 = "getPersistedModel";

		_methodParameterTypes14 = new String[] { "java.io.Serializable" };

		_methodName15 = "getESFFederalRoleByUuidAndCompanyId";

		_methodParameterTypes15 = new String[] { "java.lang.String", "long" };

		_methodName16 = "getESFFederalRoleByUuidAndGroupId";

		_methodParameterTypes16 = new String[] { "java.lang.String", "long" };

		_methodName17 = "getESFFederalRoles";

		_methodParameterTypes17 = new String[] { "int", "int" };

		_methodName18 = "getESFFederalRolesCount";

		_methodParameterTypes18 = new String[] {  };

		_methodName19 = "updateESFFederalRole";

		_methodParameterTypes19 = new String[] {
				"it.ethica.esf.model.ESFFederalRole"
			};

		_methodName384 = "getBeanIdentifier";

		_methodParameterTypes384 = new String[] {  };

		_methodName385 = "setBeanIdentifier";

		_methodParameterTypes385 = new String[] { "java.lang.String" };

		_methodName390 = "findByESFUser";

		_methodParameterTypes390 = new String[] { "long" };

		_methodName391 = "findByESFFederalRole";

		_methodParameterTypes391 = new String[] { "long" };

		_methodName392 = "updateEsfFederalRole";

		_methodParameterTypes392 = new String[] {
				"long", "java.lang.String", "java.lang.String", "boolean",
				"boolean"
			};

		_methodName393 = "findByCode";

		_methodParameterTypes393 = new String[] { "java.lang.String" };

		_methodName394 = "associateEsfUser";

		_methodParameterTypes394 = new String[] {
				"long", "long", "long", "long", "java.lang.String"
			};

		_methodName395 = "deAssociateEsfUser";

		_methodParameterTypes395 = new String[] { "long", "long" };

		_methodName396 = "getAssociation";

		_methodParameterTypes396 = new String[] { "long", "long", "long" };

		_methodName397 = "getActiveAssociationDate";

		_methodParameterTypes397 = new String[] { "long", "long" };

		_methodName398 = "getAssociationsByEsfUser";

		_methodParameterTypes398 = new String[] { "long" };

		_methodName399 = "getAssociationsByEsfUserActive";

		_methodParameterTypes399 = new String[] { "long", "boolean" };

		_methodName400 = "isAssociated";

		_methodParameterTypes400 = new String[] { "long", "long" };

		_methodName401 = "cleanEsfUserAssociation";

		_methodParameterTypes401 = new String[] { "long" };

		_methodName402 = "cleanEsfFederalRoleAssociation";

		_methodParameterTypes402 = new String[] { "long" };

		_methodName403 = "getFederalRoleSpecifics";

		_methodParameterTypes403 = new String[] { "long" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return ESFFederalRoleLocalServiceUtil.addESFFederalRole((it.ethica.esf.model.ESFFederalRole)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return ESFFederalRoleLocalServiceUtil.createESFFederalRole(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return ESFFederalRoleLocalServiceUtil.deleteESFFederalRole(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return ESFFederalRoleLocalServiceUtil.deleteESFFederalRole((it.ethica.esf.model.ESFFederalRole)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return ESFFederalRoleLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return ESFFederalRoleLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return ESFFederalRoleLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return ESFFederalRoleLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return ESFFederalRoleLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return ESFFederalRoleLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return ESFFederalRoleLocalServiceUtil.fetchESFFederalRole(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return ESFFederalRoleLocalServiceUtil.fetchESFFederalRoleByUuidAndCompanyId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return ESFFederalRoleLocalServiceUtil.fetchESFFederalRoleByUuidAndGroupId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return ESFFederalRoleLocalServiceUtil.getESFFederalRole(((Long)arguments[0]).longValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return ESFFederalRoleLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return ESFFederalRoleLocalServiceUtil.getESFFederalRoleByUuidAndCompanyId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName16.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes16, parameterTypes)) {
			return ESFFederalRoleLocalServiceUtil.getESFFederalRoleByUuidAndGroupId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName17.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes17, parameterTypes)) {
			return ESFFederalRoleLocalServiceUtil.getESFFederalRoles(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName18.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes18, parameterTypes)) {
			return ESFFederalRoleLocalServiceUtil.getESFFederalRolesCount();
		}

		if (_methodName19.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes19, parameterTypes)) {
			return ESFFederalRoleLocalServiceUtil.updateESFFederalRole((it.ethica.esf.model.ESFFederalRole)arguments[0]);
		}

		if (_methodName384.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes384, parameterTypes)) {
			return ESFFederalRoleLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName385.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes385, parameterTypes)) {
			ESFFederalRoleLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName390.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes390, parameterTypes)) {
			return ESFFederalRoleLocalServiceUtil.findByESFUser(((Long)arguments[0]).longValue());
		}

		if (_methodName391.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes391, parameterTypes)) {
			return ESFFederalRoleLocalServiceUtil.findByESFFederalRole(((Long)arguments[0]).longValue());
		}

		if (_methodName392.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes392, parameterTypes)) {
			return ESFFederalRoleLocalServiceUtil.updateEsfFederalRole(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				((Boolean)arguments[3]).booleanValue(),
				((Boolean)arguments[4]).booleanValue());
		}

		if (_methodName393.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes393, parameterTypes)) {
			return ESFFederalRoleLocalServiceUtil.findByCode((java.lang.String)arguments[0]);
		}

		if (_methodName394.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes394, parameterTypes)) {
			ESFFederalRoleLocalServiceUtil.associateEsfUser(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue(), (java.lang.String)arguments[4]);

			return null;
		}

		if (_methodName395.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes395, parameterTypes)) {
			ESFFederalRoleLocalServiceUtil.deAssociateEsfUser(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());

			return null;
		}

		if (_methodName396.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes396, parameterTypes)) {
			return ESFFederalRoleLocalServiceUtil.getAssociation(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue());
		}

		if (_methodName397.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes397, parameterTypes)) {
			return ESFFederalRoleLocalServiceUtil.getActiveAssociationDate(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName398.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes398, parameterTypes)) {
			return ESFFederalRoleLocalServiceUtil.getAssociationsByEsfUser(((Long)arguments[0]).longValue());
		}

		if (_methodName399.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes399, parameterTypes)) {
			return ESFFederalRoleLocalServiceUtil.getAssociationsByEsfUserActive(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue());
		}

		if (_methodName400.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes400, parameterTypes)) {
			return ESFFederalRoleLocalServiceUtil.isAssociated(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName401.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes401, parameterTypes)) {
			ESFFederalRoleLocalServiceUtil.cleanEsfUserAssociation(((Long)arguments[0]).longValue());

			return null;
		}

		if (_methodName402.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes402, parameterTypes)) {
			ESFFederalRoleLocalServiceUtil.cleanEsfFederalRoleAssociation(((Long)arguments[0]).longValue());

			return null;
		}

		if (_methodName403.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes403, parameterTypes)) {
			return ESFFederalRoleLocalServiceUtil.getFederalRoleSpecifics(((Long)arguments[0]).longValue());
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
	private String _methodName403;
	private String[] _methodParameterTypes403;
=======
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

import it.ethica.esf.service.ESFFederalRoleLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Ethica
 * @generated
 */
public class ESFFederalRoleLocalServiceClpInvoker {
	public ESFFederalRoleLocalServiceClpInvoker() {
		_methodName0 = "addESFFederalRole";

		_methodParameterTypes0 = new String[] {
				"it.ethica.esf.model.ESFFederalRole"
			};

		_methodName1 = "createESFFederalRole";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteESFFederalRole";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteESFFederalRole";

		_methodParameterTypes3 = new String[] {
				"it.ethica.esf.model.ESFFederalRole"
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

		_methodName10 = "fetchESFFederalRole";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "fetchESFFederalRoleByUuidAndCompanyId";

		_methodParameterTypes11 = new String[] { "java.lang.String", "long" };

		_methodName12 = "fetchESFFederalRoleByUuidAndGroupId";

		_methodParameterTypes12 = new String[] { "java.lang.String", "long" };

		_methodName13 = "getESFFederalRole";

		_methodParameterTypes13 = new String[] { "long" };

		_methodName14 = "getPersistedModel";

		_methodParameterTypes14 = new String[] { "java.io.Serializable" };

		_methodName15 = "getESFFederalRoleByUuidAndCompanyId";

		_methodParameterTypes15 = new String[] { "java.lang.String", "long" };

		_methodName16 = "getESFFederalRoleByUuidAndGroupId";

		_methodParameterTypes16 = new String[] { "java.lang.String", "long" };

		_methodName17 = "getESFFederalRoles";

		_methodParameterTypes17 = new String[] { "int", "int" };

		_methodName18 = "getESFFederalRolesCount";

		_methodParameterTypes18 = new String[] {  };

		_methodName19 = "updateESFFederalRole";

		_methodParameterTypes19 = new String[] {
				"it.ethica.esf.model.ESFFederalRole"
			};

		_methodName376 = "getBeanIdentifier";

		_methodParameterTypes376 = new String[] {  };

		_methodName377 = "setBeanIdentifier";

		_methodParameterTypes377 = new String[] { "java.lang.String" };

		_methodName382 = "findByESFUser";

		_methodParameterTypes382 = new String[] { "long" };

		_methodName383 = "findByESFFederalRole";

		_methodParameterTypes383 = new String[] { "long" };

		_methodName384 = "updateEsfFederalRole";

		_methodParameterTypes384 = new String[] {
				"long", "java.lang.String", "java.lang.String", "boolean",
				"boolean"
			};

		_methodName385 = "findByCode";

		_methodParameterTypes385 = new String[] { "java.lang.String" };

		_methodName386 = "associateEsfUser";

		_methodParameterTypes386 = new String[] {
				"long", "long", "long", "long", "java.lang.String"
			};

		_methodName387 = "deAssociateEsfUser";

		_methodParameterTypes387 = new String[] { "long", "long" };

		_methodName388 = "getAssociation";

		_methodParameterTypes388 = new String[] { "long", "long", "long" };

		_methodName389 = "getActiveAssociationDate";

		_methodParameterTypes389 = new String[] { "long", "long" };

		_methodName390 = "getAssociationsByEsfUser";

		_methodParameterTypes390 = new String[] { "long" };

		_methodName391 = "getAssociationsByEsfUserActive";

		_methodParameterTypes391 = new String[] { "long", "boolean" };

		_methodName392 = "isAssociated";

		_methodParameterTypes392 = new String[] { "long", "long" };

		_methodName393 = "cleanEsfUserAssociation";

		_methodParameterTypes393 = new String[] { "long" };

		_methodName394 = "cleanEsfFederalRoleAssociation";

		_methodParameterTypes394 = new String[] { "long" };

		_methodName395 = "getFederalRoleSpecifics";

		_methodParameterTypes395 = new String[] { "long" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return ESFFederalRoleLocalServiceUtil.addESFFederalRole((it.ethica.esf.model.ESFFederalRole)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return ESFFederalRoleLocalServiceUtil.createESFFederalRole(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return ESFFederalRoleLocalServiceUtil.deleteESFFederalRole(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return ESFFederalRoleLocalServiceUtil.deleteESFFederalRole((it.ethica.esf.model.ESFFederalRole)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return ESFFederalRoleLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return ESFFederalRoleLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return ESFFederalRoleLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return ESFFederalRoleLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return ESFFederalRoleLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return ESFFederalRoleLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return ESFFederalRoleLocalServiceUtil.fetchESFFederalRole(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return ESFFederalRoleLocalServiceUtil.fetchESFFederalRoleByUuidAndCompanyId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return ESFFederalRoleLocalServiceUtil.fetchESFFederalRoleByUuidAndGroupId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return ESFFederalRoleLocalServiceUtil.getESFFederalRole(((Long)arguments[0]).longValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return ESFFederalRoleLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return ESFFederalRoleLocalServiceUtil.getESFFederalRoleByUuidAndCompanyId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName16.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes16, parameterTypes)) {
			return ESFFederalRoleLocalServiceUtil.getESFFederalRoleByUuidAndGroupId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName17.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes17, parameterTypes)) {
			return ESFFederalRoleLocalServiceUtil.getESFFederalRoles(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName18.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes18, parameterTypes)) {
			return ESFFederalRoleLocalServiceUtil.getESFFederalRolesCount();
		}

		if (_methodName19.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes19, parameterTypes)) {
			return ESFFederalRoleLocalServiceUtil.updateESFFederalRole((it.ethica.esf.model.ESFFederalRole)arguments[0]);
		}

		if (_methodName376.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes376, parameterTypes)) {
			return ESFFederalRoleLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName377.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes377, parameterTypes)) {
			ESFFederalRoleLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName382.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes382, parameterTypes)) {
			return ESFFederalRoleLocalServiceUtil.findByESFUser(((Long)arguments[0]).longValue());
		}

		if (_methodName383.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes383, parameterTypes)) {
			return ESFFederalRoleLocalServiceUtil.findByESFFederalRole(((Long)arguments[0]).longValue());
		}

		if (_methodName384.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes384, parameterTypes)) {
			return ESFFederalRoleLocalServiceUtil.updateEsfFederalRole(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				((Boolean)arguments[3]).booleanValue(),
				((Boolean)arguments[4]).booleanValue());
		}

		if (_methodName385.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes385, parameterTypes)) {
			return ESFFederalRoleLocalServiceUtil.findByCode((java.lang.String)arguments[0]);
		}

		if (_methodName386.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes386, parameterTypes)) {
			ESFFederalRoleLocalServiceUtil.associateEsfUser(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue(), (java.lang.String)arguments[4]);

			return null;
		}

		if (_methodName387.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes387, parameterTypes)) {
			ESFFederalRoleLocalServiceUtil.deAssociateEsfUser(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());

			return null;
		}

		if (_methodName388.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes388, parameterTypes)) {
			return ESFFederalRoleLocalServiceUtil.getAssociation(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue());
		}

		if (_methodName389.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes389, parameterTypes)) {
			return ESFFederalRoleLocalServiceUtil.getActiveAssociationDate(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName390.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes390, parameterTypes)) {
			return ESFFederalRoleLocalServiceUtil.getAssociationsByEsfUser(((Long)arguments[0]).longValue());
		}

		if (_methodName391.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes391, parameterTypes)) {
			return ESFFederalRoleLocalServiceUtil.getAssociationsByEsfUserActive(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue());
		}

		if (_methodName392.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes392, parameterTypes)) {
			return ESFFederalRoleLocalServiceUtil.isAssociated(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName393.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes393, parameterTypes)) {
			ESFFederalRoleLocalServiceUtil.cleanEsfUserAssociation(((Long)arguments[0]).longValue());

			return null;
		}

		if (_methodName394.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes394, parameterTypes)) {
			ESFFederalRoleLocalServiceUtil.cleanEsfFederalRoleAssociation(((Long)arguments[0]).longValue());

			return null;
		}

		if (_methodName395.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes395, parameterTypes)) {
			return ESFFederalRoleLocalServiceUtil.getFederalRoleSpecifics(((Long)arguments[0]).longValue());
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
	private String _methodName376;
	private String[] _methodParameterTypes376;
	private String _methodName377;
	private String[] _methodParameterTypes377;
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
>>>>>>> 26da9bbffb059331ed6f543a72e339a809eb5ce6
}