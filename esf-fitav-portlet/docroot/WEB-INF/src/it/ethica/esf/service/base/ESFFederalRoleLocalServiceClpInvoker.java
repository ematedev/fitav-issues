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

		_methodName388 = "getBeanIdentifier";

		_methodParameterTypes388 = new String[] {  };

		_methodName389 = "setBeanIdentifier";

		_methodParameterTypes389 = new String[] { "java.lang.String" };

		_methodName394 = "findByESFUser";

		_methodParameterTypes394 = new String[] { "long" };

		_methodName395 = "findByESFFederalRole";

		_methodParameterTypes395 = new String[] { "long" };

		_methodName396 = "updateEsfFederalRole";

		_methodParameterTypes396 = new String[] {
				"long", "java.lang.String", "java.lang.String", "boolean",
				"boolean"
			};

		_methodName397 = "findByCode";

		_methodParameterTypes397 = new String[] { "java.lang.String" };

		_methodName398 = "associateEsfUser";

		_methodParameterTypes398 = new String[] {
<<<<<<< HEAD
				"long", "long", "long", "long", "java.lang.String"
=======
				"long", "long", "long", "java.util.Date", "long",
				"java.lang.String"
>>>>>>> 4e2f23245d33f5cc80bffcdd36acf34e75accc38
			};

		_methodName399 = "deAssociateEsfUser";

		_methodParameterTypes399 = new String[] { "long", "long" };

		_methodName400 = "getAssociation";

		_methodParameterTypes400 = new String[] { "long", "long", "long" };

		_methodName401 = "getActiveAssociationDate";

		_methodParameterTypes401 = new String[] { "long", "long" };

<<<<<<< HEAD
		_methodName402 = "getAssociationsByEsfUser";

		_methodParameterTypes402 = new String[] { "long" };

		_methodName403 = "getAssociationsByEsfUserActive";

		_methodParameterTypes403 = new String[] { "long", "boolean" };

		_methodName404 = "isAssociated";

		_methodParameterTypes404 = new String[] { "long", "long" };

		_methodName405 = "cleanEsfUserAssociation";

		_methodParameterTypes405 = new String[] { "long" };

		_methodName406 = "cleanEsfFederalRoleAssociation";

		_methodParameterTypes406 = new String[] { "long" };

		_methodName407 = "getFederalRoleSpecifics";

		_methodParameterTypes407 = new String[] { "long" };
=======
		_methodName402 = "getEndAssociationDate";

		_methodParameterTypes402 = new String[] { "long", "long" };

		_methodName403 = "deleteEsfUserEsfFederalRole";

		_methodParameterTypes403 = new String[] { "long", "long" };

		_methodName404 = "getAssociationsByEsfUser";

		_methodParameterTypes404 = new String[] { "long" };

		_methodName405 = "getAssociationsByEsfUserActive";

		_methodParameterTypes405 = new String[] { "long", "boolean" };

		_methodName406 = "isAssociated";

		_methodParameterTypes406 = new String[] { "long", "long" };

		_methodName407 = "cleanEsfUserAssociation";

		_methodParameterTypes407 = new String[] { "long" };

		_methodName408 = "cleanEsfFederalRoleAssociation";

		_methodParameterTypes408 = new String[] { "long" };

		_methodName409 = "getFederalRoleSpecifics";

		_methodParameterTypes409 = new String[] { "long" };
>>>>>>> 4e2f23245d33f5cc80bffcdd36acf34e75accc38
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

		if (_methodName388.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes388, parameterTypes)) {
			return ESFFederalRoleLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName389.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes389, parameterTypes)) {
			ESFFederalRoleLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName394.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes394, parameterTypes)) {
			return ESFFederalRoleLocalServiceUtil.findByESFUser(((Long)arguments[0]).longValue());
		}

		if (_methodName395.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes395, parameterTypes)) {
			return ESFFederalRoleLocalServiceUtil.findByESFFederalRole(((Long)arguments[0]).longValue());
		}

		if (_methodName396.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes396, parameterTypes)) {
			return ESFFederalRoleLocalServiceUtil.updateEsfFederalRole(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				((Boolean)arguments[3]).booleanValue(),
				((Boolean)arguments[4]).booleanValue());
		}

		if (_methodName397.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes397, parameterTypes)) {
			return ESFFederalRoleLocalServiceUtil.findByCode((java.lang.String)arguments[0]);
		}

		if (_methodName398.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes398, parameterTypes)) {
			ESFFederalRoleLocalServiceUtil.associateEsfUser(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(), (java.util.Date)arguments[3],
				((Long)arguments[4]).longValue(), (java.lang.String)arguments[5]);

			return null;
		}

		if (_methodName399.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes399, parameterTypes)) {
			ESFFederalRoleLocalServiceUtil.deAssociateEsfUser(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());

			return null;
		}

		if (_methodName400.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes400, parameterTypes)) {
			return ESFFederalRoleLocalServiceUtil.getAssociation(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue());
		}

		if (_methodName401.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes401, parameterTypes)) {
			return ESFFederalRoleLocalServiceUtil.getActiveAssociationDate(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName402.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes402, parameterTypes)) {
<<<<<<< HEAD
			return ESFFederalRoleLocalServiceUtil.getAssociationsByEsfUser(((Long)arguments[0]).longValue());
		}

		if (_methodName403.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes403, parameterTypes)) {
=======
			return ESFFederalRoleLocalServiceUtil.getEndAssociationDate(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName403.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes403, parameterTypes)) {
			ESFFederalRoleLocalServiceUtil.deleteEsfUserEsfFederalRole(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());

			return null;
		}

		if (_methodName404.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes404, parameterTypes)) {
			return ESFFederalRoleLocalServiceUtil.getAssociationsByEsfUser(((Long)arguments[0]).longValue());
		}

		if (_methodName405.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes405, parameterTypes)) {
>>>>>>> 4e2f23245d33f5cc80bffcdd36acf34e75accc38
			return ESFFederalRoleLocalServiceUtil.getAssociationsByEsfUserActive(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue());
		}

<<<<<<< HEAD
		if (_methodName404.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes404, parameterTypes)) {
=======
		if (_methodName406.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes406, parameterTypes)) {
>>>>>>> 4e2f23245d33f5cc80bffcdd36acf34e75accc38
			return ESFFederalRoleLocalServiceUtil.isAssociated(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

<<<<<<< HEAD
		if (_methodName405.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes405, parameterTypes)) {
=======
		if (_methodName407.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes407, parameterTypes)) {
>>>>>>> 4e2f23245d33f5cc80bffcdd36acf34e75accc38
			ESFFederalRoleLocalServiceUtil.cleanEsfUserAssociation(((Long)arguments[0]).longValue());

			return null;
		}

<<<<<<< HEAD
		if (_methodName406.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes406, parameterTypes)) {
=======
		if (_methodName408.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes408, parameterTypes)) {
>>>>>>> 4e2f23245d33f5cc80bffcdd36acf34e75accc38
			ESFFederalRoleLocalServiceUtil.cleanEsfFederalRoleAssociation(((Long)arguments[0]).longValue());

			return null;
		}

<<<<<<< HEAD
		if (_methodName407.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes407, parameterTypes)) {
=======
		if (_methodName409.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes409, parameterTypes)) {
>>>>>>> 4e2f23245d33f5cc80bffcdd36acf34e75accc38
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
	private String _methodName388;
	private String[] _methodParameterTypes388;
	private String _methodName389;
	private String[] _methodParameterTypes389;
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
	private String _methodName404;
	private String[] _methodParameterTypes404;
	private String _methodName405;
	private String[] _methodParameterTypes405;
	private String _methodName406;
	private String[] _methodParameterTypes406;
	private String _methodName407;
	private String[] _methodParameterTypes407;
<<<<<<< HEAD
=======
	private String _methodName408;
	private String[] _methodParameterTypes408;
	private String _methodName409;
	private String[] _methodParameterTypes409;
>>>>>>> 4e2f23245d33f5cc80bffcdd36acf34e75accc38
}