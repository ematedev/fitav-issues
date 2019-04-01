/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

import it.ethica.esf.service.ESFOrganizationLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Ethica
 * @generated
 */
public class ESFOrganizationLocalServiceClpInvoker {
	public ESFOrganizationLocalServiceClpInvoker() {
		_methodName0 = "addESFOrganization";

		_methodParameterTypes0 = new String[] {
				"it.ethica.esf.model.ESFOrganization"
			};

		_methodName1 = "createESFOrganization";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteESFOrganization";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteESFOrganization";

		_methodParameterTypes3 = new String[] {
				"it.ethica.esf.model.ESFOrganization"
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

		_methodName10 = "fetchESFOrganization";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "fetchESFOrganizationByUuidAndGroupId";

		_methodParameterTypes11 = new String[] { "java.lang.String", "long" };

		_methodName12 = "getESFOrganization";

		_methodParameterTypes12 = new String[] { "long" };

		_methodName13 = "getPersistedModel";

		_methodParameterTypes13 = new String[] { "java.io.Serializable" };

		_methodName14 = "getESFOrganizationByUuidAndGroupId";

		_methodParameterTypes14 = new String[] { "java.lang.String", "long" };

		_methodName15 = "getESFOrganizations";

		_methodParameterTypes15 = new String[] { "int", "int" };

		_methodName16 = "getESFOrganizationsCount";

		_methodParameterTypes16 = new String[] {  };

		_methodName17 = "updateESFOrganization";

		_methodParameterTypes17 = new String[] {
				"it.ethica.esf.model.ESFOrganization"
			};

		_methodName386 = "getBeanIdentifier";

		_methodParameterTypes386 = new String[] {  };

		_methodName387 = "setBeanIdentifier";

		_methodParameterTypes387 = new String[] { "java.lang.String" };

		_methodName392 = "addESFOrganization";

		_methodParameterTypes392 = new String[] {
				"long", "long", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.util.Date", "java.util.Date",
				"java.util.Date", "java.util.Date", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.util.List",
				"java.util.List", "boolean", "boolean", "boolean",
				"java.lang.String", "boolean", "java.util.Date",
				"it.ethica.esf.model.ESFEntityState", "long", "long", "boolean",
				"boolean", "boolean", "boolean", "boolean", "java.lang.String",
				"java.lang.String", "boolean",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName393 = "addESFOrganization";

		_methodParameterTypes393 = new String[] {
				"long", "long", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.util.Date", "java.util.Date", "java.util.Date",
				"java.util.Date", "java.lang.String", "java.lang.String",
				"java.lang.String", "boolean", "boolean", "boolean",
				"java.lang.String", "boolean", "java.util.Date",
				"it.ethica.esf.model.ESFEntityState", "long", "long", "boolean",
				"boolean", "boolean", "boolean", "boolean", "java.lang.String",
				"java.lang.String", "boolean",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName394 = "updateESFOrganization";

		_methodParameterTypes394 = new String[] {
				"long", "long", "long", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.util.Date", "java.util.Date",
				"java.util.Date", "java.util.Date", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.util.List",
				"java.util.List", "boolean", "java.lang.String", "boolean",
				"java.util.Date", "it.ethica.esf.model.ESFEntityState", "long",
				"long", "long", "boolean", "boolean", "boolean", "boolean",
				"java.lang.String", "java.lang.String", "boolean",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName395 = "updateESFOrganization";

		_methodParameterTypes395 = new String[] {
				"long", "long", "long", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.util.Date", "java.util.Date", "java.util.Date",
				"java.util.Date", "java.lang.String", "java.lang.String",
				"java.lang.String", "boolean", "java.lang.String", "boolean",
				"java.util.Date", "it.ethica.esf.model.ESFEntityState", "long",
				"long", "long", "boolean", "boolean", "boolean", "boolean",
				"java.lang.String", "java.lang.String", "boolean",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName396 = "findByGroupId";

		_methodParameterTypes396 = new String[] { "long" };

		_methodName397 = "getByProvinceCode";

		_methodParameterTypes397 = new String[] { "java.lang.String" };

		_methodName398 = "findByGroupId";

		_methodParameterTypes398 = new String[] { "long", "int", "int" };

		_methodName399 = "findByCode";

		_methodParameterTypes399 = new String[] { "java.lang.String" };

		_methodName400 = "getRealOwner";

		_methodParameterTypes400 = new String[] { "long", "long" };

		_methodName401 = "findAllESFOrganizations";

		_methodParameterTypes401 = new String[] { "long", "int" };

		_methodName402 = "findESFOrganizationsByCode";

		_methodParameterTypes402 = new String[] { "java.lang.String" };

		_methodName403 = "findESFOrganizationsByT_C";

		_methodParameterTypes403 = new String[] {
				"long", "java.lang.String", "int"
			};

		_methodName404 = "findESFOrganizationsByT_C";

		_methodParameterTypes404 = new String[] {
				"long", "java.lang.String", "int", "int", "int"
			};

		_methodName405 = "findESFOrganizationsByT_C_N";

		_methodParameterTypes405 = new String[] {
				"long", "java.lang.String", "java.lang.String", "int", "int",
				"int"
			};

		_methodName406 = "findESFOrganizationsByT_C_N";

		_methodParameterTypes406 = new String[] {
				"long", "java.lang.String", "java.lang.String", "int"
			};

		_methodName407 = "findESFOrganizationsByT_C";

		_methodParameterTypes407 = new String[] { "long", "int" };

		_methodName408 = "findESFOrganizationsByT_C";

		_methodParameterTypes408 = new String[] { "long", "int", "int", "int" };

		_methodName409 = "findESFOrganizationsByCode";

		_methodParameterTypes409 = new String[] {
				"long", "java.lang.String", "int"
			};

		_methodName410 = "findESFOrganizationsByCode";

		_methodParameterTypes410 = new String[] {
				"long", "java.lang.String", "int", "int", "int"
			};

		_methodName411 = "findESFOrganizationsByO_T";

		_methodParameterTypes411 = new String[] { "long", "long" };

		_methodName412 = "findESFOrganizationsByO_T_C_N";

		_methodParameterTypes412 = new String[] {
				"long", "long", "java.lang.String", "java.lang.String"
			};

		_methodName413 = "findESFOrganizationsByO_T_C_N";

		_methodParameterTypes413 = new String[] {
				"long", "long", "java.lang.String", "java.lang.String", "int",
				"int"
			};

		_methodName414 = "getOrganizzationLeafByLikeN_C";

		_methodParameterTypes414 = new String[] {
				"java.lang.String", "java.lang.String", "long", "long"
			};

		_methodName415 = "getOrganizzationLeafByLikeN_C";

		_methodParameterTypes415 = new String[] {
				"java.lang.String", "java.lang.String", "long", "long", "int",
				"int"
			};

		_methodName416 = "findAllLeafOrganizations";

		_methodParameterTypes416 = new String[] { "long" };

		_methodName417 = "findAllLeafOrganizations";

		_methodParameterTypes417 = new String[] {
				"long", "java.lang.String", "java.lang.String"
			};

		_methodName418 = "findAllOrganizationsIncrements";

		_methodParameterTypes418 = new String[] {
				"java.lang.String", "java.lang.String", "int", "int"
			};

		_methodName419 = "findAllOrganizationsIncrements";

		_methodParameterTypes419 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName420 = "findAllLeafOrganizations";

		_methodParameterTypes420 = new String[] { "long", "int", "int" };

		_methodName421 = "findAllLeafOrganizations";

		_methodParameterTypes421 = new String[] {
				"long", "java.lang.String", "java.lang.String", "int", "int"
			};

		_methodName422 = "findAllLeafOrganizations";

		_methodParameterTypes422 = new String[] { "long", "int" };

		_methodName423 = "findAllLeafOrganizations";

		_methodParameterTypes423 = new String[] { "long", "int", "int", "int" };

		_methodName424 = "findAllChildOrganizations";

		_methodParameterTypes424 = new String[] { "long" };

		_methodName425 = "findAllChildOrganizations";

		_methodParameterTypes425 = new String[] { "long", "int", "int" };

		_methodName426 = "findAllChildOrganizations";

		_methodParameterTypes426 = new String[] { "long", "int" };

		_methodName427 = "findAllChildOrganizations";

		_methodParameterTypes427 = new String[] { "long", "int", "int", "int" };

		_methodName428 = "findByPaymentYear";

		_methodParameterTypes428 = new String[] { "int", "int", "int" };

		_methodName429 = "countByPaymentYear";

		_methodParameterTypes429 = new String[] { "int" };

		_methodName430 = "getAllEsfOrganizationByState";

		_methodParameterTypes430 = new String[] { "int" };

		_methodName431 = "getAllEsfOrganizationByState";

		_methodParameterTypes431 = new String[] { "int", "int", "int" };

		_methodName432 = "getAllEsfOrganizationDisabled";

		_methodParameterTypes432 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName433 = "getAllEsfOrganizationDisabledStartEnd";

		_methodParameterTypes433 = new String[] {
				"java.lang.String", "java.lang.String", "int", "int"
			};

		_methodName434 = "deleteESFOrganization";

		_methodParameterTypes434 = new String[] {
				"long", "com.liferay.portal.service.ServiceContext"
			};

		_methodName435 = "updateESFOrganitazionESFCard";

		_methodParameterTypes435 = new String[] { "long", "long" };

		_methodName436 = "updateOnlyESFOrganitazionState";

		_methodParameterTypes436 = new String[] {
				"long", "com.liferay.portal.service.ServiceContext"
			};

		_methodName442 = "getNameT";

		_methodParameterTypes442 = new String[] {
				"it.ethica.esf.model.ESFOrganization"
			};

		_methodName443 = "findByT_C_N";

		_methodParameterTypes443 = new String[] {
				"java.lang.Long", "java.lang.String", "java.lang.String",
				"java.lang.Long", "int", "int"
			};

		_methodName444 = "countByT_C_N";

		_methodParameterTypes444 = new String[] {
				"java.lang.Long", "java.lang.String", "java.lang.String",
				"java.lang.Long"
			};

		_methodName445 = "findAllAffilationConiReportAndArmy";

		_methodParameterTypes445 = new String[] {  };

		_methodName446 = "findNewAffilationConiReportAndArmy";

		_methodParameterTypes446 = new String[] { "int" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.addESFOrganization((it.ethica.esf.model.ESFOrganization)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.createESFOrganization(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.deleteESFOrganization(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.deleteESFOrganization((it.ethica.esf.model.ESFOrganization)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.fetchESFOrganization(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.fetchESFOrganizationByUuidAndGroupId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.getESFOrganization(((Long)arguments[0]).longValue());
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.getESFOrganizationByUuidAndGroupId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.getESFOrganizations(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName16.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes16, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.getESFOrganizationsCount();
		}

		if (_methodName17.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes17, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.updateESFOrganization((it.ethica.esf.model.ESFOrganization)arguments[0]);
		}

		if (_methodName386.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes386, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName387.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes387, parameterTypes)) {
			ESFOrganizationLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName392.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes392, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.addESFOrganization(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3],
				(java.lang.String)arguments[4], (java.lang.String)arguments[5],
				(java.lang.String)arguments[6], (java.lang.String)arguments[7],
				(java.util.Date)arguments[8], (java.util.Date)arguments[9],
				(java.util.Date)arguments[10], (java.util.Date)arguments[11],
				(java.lang.String)arguments[12],
				(java.lang.String)arguments[13],
				(java.lang.String)arguments[14],
				(java.util.List<it.ethica.esf.model.ESFAddress>)arguments[15],
				(java.util.List<it.ethica.esf.model.ESFPhone>)arguments[16],
				((Boolean)arguments[17]).booleanValue(),
				((Boolean)arguments[18]).booleanValue(),
				((Boolean)arguments[19]).booleanValue(),
				(java.lang.String)arguments[20],
				((Boolean)arguments[21]).booleanValue(),
				(java.util.Date)arguments[22],
				(it.ethica.esf.model.ESFEntityState)arguments[23],
				((Long)arguments[24]).longValue(),
				((Long)arguments[25]).longValue(),
				((Boolean)arguments[26]).booleanValue(),
				((Boolean)arguments[27]).booleanValue(),
				((Boolean)arguments[28]).booleanValue(),
				((Boolean)arguments[29]).booleanValue(),
				((Boolean)arguments[30]).booleanValue(),
				(java.lang.String)arguments[31],
				(java.lang.String)arguments[32],
				((Boolean)arguments[33]).booleanValue(),
				(com.liferay.portal.service.ServiceContext)arguments[34]);
		}

		if (_methodName393.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes393, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.addESFOrganization(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3],
				(java.lang.String)arguments[4], (java.lang.String)arguments[5],
				(java.lang.String)arguments[6], (java.util.Date)arguments[7],
				(java.util.Date)arguments[8], (java.util.Date)arguments[9],
				(java.util.Date)arguments[10], (java.lang.String)arguments[11],
				(java.lang.String)arguments[12],
				(java.lang.String)arguments[13],
				((Boolean)arguments[14]).booleanValue(),
				((Boolean)arguments[15]).booleanValue(),
				((Boolean)arguments[16]).booleanValue(),
				(java.lang.String)arguments[17],
				((Boolean)arguments[18]).booleanValue(),
				(java.util.Date)arguments[19],
				(it.ethica.esf.model.ESFEntityState)arguments[20],
				((Long)arguments[21]).longValue(),
				((Long)arguments[22]).longValue(),
				((Boolean)arguments[23]).booleanValue(),
				((Boolean)arguments[24]).booleanValue(),
				((Boolean)arguments[25]).booleanValue(),
				((Boolean)arguments[26]).booleanValue(),
				((Boolean)arguments[27]).booleanValue(),
				(java.lang.String)arguments[28],
				(java.lang.String)arguments[29],
				((Boolean)arguments[30]).booleanValue(),
				(com.liferay.portal.service.ServiceContext)arguments[31]);
		}

		if (_methodName394.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes394, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.updateESFOrganization(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				(java.lang.String)arguments[3], (java.lang.String)arguments[4],
				(java.lang.String)arguments[5], (java.lang.String)arguments[6],
				(java.lang.String)arguments[7], (java.lang.String)arguments[8],
				(java.util.Date)arguments[9], (java.util.Date)arguments[10],
				(java.util.Date)arguments[11], (java.util.Date)arguments[12],
				(java.lang.String)arguments[13],
				(java.lang.String)arguments[14],
				(java.lang.String)arguments[15],
				(java.util.List<it.ethica.esf.model.ESFAddress>)arguments[16],
				(java.util.List<it.ethica.esf.model.ESFPhone>)arguments[17],
				((Boolean)arguments[18]).booleanValue(),
				(java.lang.String)arguments[19],
				((Boolean)arguments[20]).booleanValue(),
				(java.util.Date)arguments[21],
				(it.ethica.esf.model.ESFEntityState)arguments[22],
				((Long)arguments[23]).longValue(),
				((Long)arguments[24]).longValue(),
				((Long)arguments[25]).longValue(),
				((Boolean)arguments[26]).booleanValue(),
				((Boolean)arguments[27]).booleanValue(),
				((Boolean)arguments[28]).booleanValue(),
				((Boolean)arguments[29]).booleanValue(),
				(java.lang.String)arguments[30],
				(java.lang.String)arguments[31],
				((Boolean)arguments[32]).booleanValue(),
				(com.liferay.portal.service.ServiceContext)arguments[33]);
		}

		if (_methodName395.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes395, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.updateESFOrganization(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				(java.lang.String)arguments[3], (java.lang.String)arguments[4],
				(java.lang.String)arguments[5], (java.lang.String)arguments[6],
				(java.lang.String)arguments[7], (java.util.Date)arguments[8],
				(java.util.Date)arguments[9], (java.util.Date)arguments[10],
				(java.util.Date)arguments[11], (java.lang.String)arguments[12],
				(java.lang.String)arguments[13],
				(java.lang.String)arguments[14],
				((Boolean)arguments[15]).booleanValue(),
				(java.lang.String)arguments[16],
				((Boolean)arguments[17]).booleanValue(),
				(java.util.Date)arguments[18],
				(it.ethica.esf.model.ESFEntityState)arguments[19],
				((Long)arguments[20]).longValue(),
				((Long)arguments[21]).longValue(),
				((Long)arguments[22]).longValue(),
				((Boolean)arguments[23]).booleanValue(),
				((Boolean)arguments[24]).booleanValue(),
				((Boolean)arguments[25]).booleanValue(),
				((Boolean)arguments[26]).booleanValue(),
				(java.lang.String)arguments[27],
				(java.lang.String)arguments[28],
				((Boolean)arguments[29]).booleanValue(),
				(com.liferay.portal.service.ServiceContext)arguments[30]);
		}

		if (_methodName396.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes396, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.findByGroupId(((Long)arguments[0]).longValue());
		}

		if (_methodName397.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes397, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.getByProvinceCode((java.lang.String)arguments[0]);
		}

		if (_methodName398.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes398, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.findByGroupId(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName399.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes399, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.findByCode((java.lang.String)arguments[0]);
		}

		if (_methodName400.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes400, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.getRealOwner(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName401.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes401, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.findAllESFOrganizations(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName402.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes402, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.findESFOrganizationsByCode((java.lang.String)arguments[0]);
		}

		if (_methodName403.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes403, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.findESFOrganizationsByT_C(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1],
				((Integer)arguments[2]).intValue());
		}

		if (_methodName404.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes404, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.findESFOrganizationsByT_C(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1],
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue());
		}

		if (_methodName405.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes405, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.findESFOrganizationsByT_C_N(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue());
		}

		if (_methodName406.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes406, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.findESFOrganizationsByT_C_N(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				((Integer)arguments[3]).intValue());
		}

		if (_methodName407.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes407, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.findESFOrganizationsByT_C(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName408.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes408, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.findESFOrganizationsByT_C(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName409.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes409, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.findESFOrganizationsByCode(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1],
				((Integer)arguments[2]).intValue());
		}

		if (_methodName410.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes410, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.findESFOrganizationsByCode(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1],
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue());
		}

		if (_methodName411.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes411, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.findESFOrganizationsByO_T(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName412.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes412, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.findESFOrganizationsByO_T_C_N(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3]);
		}

		if (_methodName413.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes413, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.findESFOrganizationsByO_T_C_N(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3],
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue());
		}

		if (_methodName414.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes414, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.getOrganizzationLeafByLikeN_C((java.lang.String)arguments[0],
				(java.lang.String)arguments[1],
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue());
		}

		if (_methodName415.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes415, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.getOrganizzationLeafByLikeN_C((java.lang.String)arguments[0],
				(java.lang.String)arguments[1],
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue(),
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue());
		}

		if (_methodName416.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes416, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.findAllLeafOrganizations(((Long)arguments[0]).longValue());
		}

		if (_methodName417.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes417, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.findAllLeafOrganizations(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2]);
		}

		if (_methodName418.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes418, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.findAllOrganizationsIncrements((java.lang.String)arguments[0],
				(java.lang.String)arguments[1],
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName419.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes419, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.findAllOrganizationsIncrements((java.lang.String)arguments[0],
				(java.lang.String)arguments[1]);
		}

		if (_methodName420.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes420, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.findAllLeafOrganizations(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName421.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes421, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.findAllLeafOrganizations(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue());
		}

		if (_methodName422.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes422, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.findAllLeafOrganizations(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName423.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes423, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.findAllLeafOrganizations(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName424.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes424, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.findAllChildOrganizations(((Long)arguments[0]).longValue());
		}

		if (_methodName425.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes425, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.findAllChildOrganizations(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName426.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes426, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.findAllChildOrganizations(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName427.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes427, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.findAllChildOrganizations(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName428.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes428, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.findByPaymentYear(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName429.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes429, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.countByPaymentYear(((Integer)arguments[0]).intValue());
		}

		if (_methodName430.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes430, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.getAllEsfOrganizationByState(((Integer)arguments[0]).intValue());
		}

		if (_methodName431.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes431, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.getAllEsfOrganizationByState(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName432.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes432, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.getAllEsfOrganizationDisabled((java.lang.String)arguments[0],
				(java.lang.String)arguments[1]);
		}

		if (_methodName433.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes433, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.getAllEsfOrganizationDisabledStartEnd((java.lang.String)arguments[0],
				(java.lang.String)arguments[1],
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName434.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes434, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.deleteESFOrganization(((Long)arguments[0]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[1]);
		}

		if (_methodName435.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes435, parameterTypes)) {
			ESFOrganizationLocalServiceUtil.updateESFOrganitazionESFCard(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());

			return null;
		}

		if (_methodName436.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes436, parameterTypes)) {
			ESFOrganizationLocalServiceUtil.updateOnlyESFOrganitazionState(((Long)arguments[0]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[1]);

			return null;
		}

		if (_methodName442.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes442, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.getNameT((it.ethica.esf.model.ESFOrganization)arguments[0]);
		}

		if (_methodName443.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes443, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.findByT_C_N((java.lang.Long)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.Long)arguments[3],
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue());
		}

		if (_methodName444.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes444, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.countByT_C_N((java.lang.Long)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.Long)arguments[3]);
		}

		if (_methodName445.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes445, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.findAllAffilationConiReportAndArmy();
		}

		if (_methodName446.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes446, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.findNewAffilationConiReportAndArmy(((Integer)arguments[0]).intValue());
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
	private String _methodName386;
	private String[] _methodParameterTypes386;
	private String _methodName387;
	private String[] _methodParameterTypes387;
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
	private String _methodName416;
	private String[] _methodParameterTypes416;
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
	private String _methodName424;
	private String[] _methodParameterTypes424;
	private String _methodName425;
	private String[] _methodParameterTypes425;
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
	private String _methodName442;
	private String[] _methodParameterTypes442;
	private String _methodName443;
	private String[] _methodParameterTypes443;
	private String _methodName444;
	private String[] _methodParameterTypes444;
	private String _methodName445;
	private String[] _methodParameterTypes445;
	private String _methodName446;
	private String[] _methodParameterTypes446;
}