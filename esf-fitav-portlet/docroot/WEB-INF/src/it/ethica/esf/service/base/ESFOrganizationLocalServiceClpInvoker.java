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

		_methodName418 = "getBeanIdentifier";

		_methodParameterTypes418 = new String[] {  };

		_methodName419 = "setBeanIdentifier";

		_methodParameterTypes419 = new String[] { "java.lang.String" };

		_methodName424 = "addESFOrganization";

		_methodParameterTypes424 = new String[] {
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

		_methodName425 = "addESFOrganization";

		_methodParameterTypes425 = new String[] {
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

		_methodName426 = "updateESFOrganization";

		_methodParameterTypes426 = new String[] {
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

		_methodName427 = "updateESFOrganization";

		_methodParameterTypes427 = new String[] {
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

		_methodName428 = "findByGroupId";

		_methodParameterTypes428 = new String[] { "long" };

		_methodName429 = "getByProvinceCode";

		_methodParameterTypes429 = new String[] { "java.lang.String" };

		_methodName430 = "findByGroupId";

		_methodParameterTypes430 = new String[] { "long", "int", "int" };

		_methodName431 = "findByCode";

		_methodParameterTypes431 = new String[] { "java.lang.String" };

		_methodName432 = "getRealOwner";

		_methodParameterTypes432 = new String[] { "long", "long" };

		_methodName433 = "findAllESFOrganizations";

		_methodParameterTypes433 = new String[] { "long", "int" };

		_methodName434 = "findESFOrganizationsByCode";

		_methodParameterTypes434 = new String[] { "java.lang.String" };

		_methodName435 = "findESFOrganizationsByT_C";

		_methodParameterTypes435 = new String[] {
				"long", "java.lang.String", "int"
			};

		_methodName436 = "findESFOrganizationsByT_C";

		_methodParameterTypes436 = new String[] {
				"long", "java.lang.String", "int", "int", "int"
			};

		_methodName437 = "findESFOrganizationsByT_C_N";

		_methodParameterTypes437 = new String[] {
				"long", "java.lang.String", "java.lang.String", "int", "int",
				"int"
			};

		_methodName438 = "findESFOrganizationsByT_C_N";

		_methodParameterTypes438 = new String[] {
				"long", "java.lang.String", "java.lang.String", "int"
			};

		_methodName439 = "findESFOrganizationsByT_C";

		_methodParameterTypes439 = new String[] { "long", "int" };

		_methodName440 = "findESFOrganizationsByT_C";

		_methodParameterTypes440 = new String[] { "long", "int", "int", "int" };

		_methodName441 = "findESFOrganizationsByCode";

		_methodParameterTypes441 = new String[] {
				"long", "java.lang.String", "int"
			};

		_methodName442 = "findESFOrganizationsByCode";

		_methodParameterTypes442 = new String[] {
				"long", "java.lang.String", "int", "int", "int"
			};

		_methodName443 = "findESFOrganizationsByO_T";

		_methodParameterTypes443 = new String[] { "long", "long" };

		_methodName444 = "findESFOrganizationsByO_T_C_N";

		_methodParameterTypes444 = new String[] {
				"long", "long", "java.lang.String", "java.lang.String"
			};

		_methodName445 = "findESFOrganizationsByO_T_C_N";

		_methodParameterTypes445 = new String[] {
				"long", "long", "java.lang.String", "java.lang.String", "int",
				"int"
			};

		_methodName446 = "getOrganizzationLeafByLikeN_C";

		_methodParameterTypes446 = new String[] {
				"java.lang.String", "java.lang.String", "long", "long"
			};

		_methodName447 = "getOrganizzationLeafByLikeN_C";

		_methodParameterTypes447 = new String[] {
				"java.lang.String", "java.lang.String", "long", "long", "int",
				"int"
			};

		_methodName448 = "findAllLeafOrganizations";

		_methodParameterTypes448 = new String[] { "long" };

		_methodName449 = "findAllLeafOrganizations";

		_methodParameterTypes449 = new String[] {
				"long", "java.lang.String", "java.lang.String"
			};

		_methodName450 = "findAllOrganizationsIncrements";

		_methodParameterTypes450 = new String[] {
				"java.lang.String", "java.lang.String", "int", "int"
			};

		_methodName451 = "findAllOrganizationsIncrements";

		_methodParameterTypes451 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName452 = "findAllLeafOrganizations";

		_methodParameterTypes452 = new String[] { "long", "int", "int" };

		_methodName453 = "findAllLeafOrganizations";

		_methodParameterTypes453 = new String[] {
				"long", "java.lang.String", "java.lang.String", "int", "int"
			};

		_methodName454 = "findAllLeafOrganizations";

		_methodParameterTypes454 = new String[] { "long", "int" };

		_methodName455 = "findAllLeafOrganizations";

		_methodParameterTypes455 = new String[] { "long", "int", "int", "int" };

		_methodName456 = "findAllChildOrganizations";

		_methodParameterTypes456 = new String[] { "long" };

		_methodName457 = "findAllChildOrganizations";

		_methodParameterTypes457 = new String[] { "long", "int", "int" };

		_methodName458 = "findAllChildOrganizations";

		_methodParameterTypes458 = new String[] { "long", "int" };

		_methodName459 = "findAllChildOrganizations";

		_methodParameterTypes459 = new String[] { "long", "int", "int", "int" };

		_methodName460 = "findByPaymentYear";

		_methodParameterTypes460 = new String[] { "int", "int", "int" };

		_methodName461 = "countByPaymentYear";

		_methodParameterTypes461 = new String[] { "int" };

		_methodName462 = "getAllEsfOrganizationByState";

		_methodParameterTypes462 = new String[] { "int" };

		_methodName463 = "getAllEsfOrganizationByState";

		_methodParameterTypes463 = new String[] { "int", "int", "int" };

		_methodName464 = "getAllEsfOrganizationDisabled";

		_methodParameterTypes464 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName465 = "getAllEsfOrganizationDisabledStartEnd";

		_methodParameterTypes465 = new String[] {
				"java.lang.String", "java.lang.String", "int", "int"
			};

		_methodName466 = "deleteESFOrganization";

		_methodParameterTypes466 = new String[] {
				"long", "com.liferay.portal.service.ServiceContext"
			};

		_methodName467 = "updateESFOrganitazionESFCard";

		_methodParameterTypes467 = new String[] { "long", "long" };

		_methodName468 = "updateOnlyESFOrganitazionState";

		_methodParameterTypes468 = new String[] {
				"long", "com.liferay.portal.service.ServiceContext"
			};

		_methodName474 = "getNameT";

		_methodParameterTypes474 = new String[] {
				"it.ethica.esf.model.ESFOrganization"
			};

		_methodName475 = "findByT_C_N";

		_methodParameterTypes475 = new String[] {
				"java.lang.Long", "java.lang.String", "java.lang.String",
				"java.lang.Long", "int", "int"
			};

		_methodName476 = "countByT_C_N";

		_methodParameterTypes476 = new String[] {
				"java.lang.Long", "java.lang.String", "java.lang.String",
				"java.lang.Long"
			};

		_methodName477 = "findAllAffilationConiReportAndArmy";

		_methodParameterTypes477 = new String[] {  };

		_methodName478 = "findNewAffilationConiReportAndArmy";

		_methodParameterTypes478 = new String[] { "int" };

		_methodName479 = "findByType";

		_methodParameterTypes479 = new String[] { "int", "int", "int" };
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

		if (_methodName418.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes418, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName419.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes419, parameterTypes)) {
			ESFOrganizationLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName424.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes424, parameterTypes)) {
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

		if (_methodName425.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes425, parameterTypes)) {
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

		if (_methodName426.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes426, parameterTypes)) {
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

		if (_methodName427.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes427, parameterTypes)) {
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

		if (_methodName428.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes428, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.findByGroupId(((Long)arguments[0]).longValue());
		}

		if (_methodName429.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes429, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.getByProvinceCode((java.lang.String)arguments[0]);
		}

		if (_methodName430.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes430, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.findByGroupId(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName431.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes431, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.findByCode((java.lang.String)arguments[0]);
		}

		if (_methodName432.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes432, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.getRealOwner(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName433.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes433, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.findAllESFOrganizations(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName434.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes434, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.findESFOrganizationsByCode((java.lang.String)arguments[0]);
		}

		if (_methodName435.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes435, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.findESFOrganizationsByT_C(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1],
				((Integer)arguments[2]).intValue());
		}

		if (_methodName436.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes436, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.findESFOrganizationsByT_C(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1],
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue());
		}

		if (_methodName437.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes437, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.findESFOrganizationsByT_C_N(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue());
		}

		if (_methodName438.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes438, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.findESFOrganizationsByT_C_N(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				((Integer)arguments[3]).intValue());
		}

		if (_methodName439.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes439, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.findESFOrganizationsByT_C(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName440.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes440, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.findESFOrganizationsByT_C(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName441.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes441, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.findESFOrganizationsByCode(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1],
				((Integer)arguments[2]).intValue());
		}

		if (_methodName442.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes442, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.findESFOrganizationsByCode(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1],
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue());
		}

		if (_methodName443.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes443, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.findESFOrganizationsByO_T(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName444.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes444, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.findESFOrganizationsByO_T_C_N(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3]);
		}

		if (_methodName445.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes445, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.findESFOrganizationsByO_T_C_N(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3],
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue());
		}

		if (_methodName446.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes446, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.getOrganizzationLeafByLikeN_C((java.lang.String)arguments[0],
				(java.lang.String)arguments[1],
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue());
		}

		if (_methodName447.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes447, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.getOrganizzationLeafByLikeN_C((java.lang.String)arguments[0],
				(java.lang.String)arguments[1],
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue(),
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue());
		}

		if (_methodName448.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes448, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.findAllLeafOrganizations(((Long)arguments[0]).longValue());
		}

		if (_methodName449.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes449, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.findAllLeafOrganizations(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2]);
		}

		if (_methodName450.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes450, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.findAllOrganizationsIncrements((java.lang.String)arguments[0],
				(java.lang.String)arguments[1],
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName451.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes451, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.findAllOrganizationsIncrements((java.lang.String)arguments[0],
				(java.lang.String)arguments[1]);
		}

		if (_methodName452.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes452, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.findAllLeafOrganizations(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName453.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes453, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.findAllLeafOrganizations(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue());
		}

		if (_methodName454.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes454, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.findAllLeafOrganizations(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName455.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes455, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.findAllLeafOrganizations(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName456.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes456, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.findAllChildOrganizations(((Long)arguments[0]).longValue());
		}

		if (_methodName457.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes457, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.findAllChildOrganizations(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName458.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes458, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.findAllChildOrganizations(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName459.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes459, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.findAllChildOrganizations(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName460.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes460, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.findByPaymentYear(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName461.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes461, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.countByPaymentYear(((Integer)arguments[0]).intValue());
		}

		if (_methodName462.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes462, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.getAllEsfOrganizationByState(((Integer)arguments[0]).intValue());
		}

		if (_methodName463.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes463, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.getAllEsfOrganizationByState(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName464.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes464, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.getAllEsfOrganizationDisabled((java.lang.String)arguments[0],
				(java.lang.String)arguments[1]);
		}

		if (_methodName465.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes465, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.getAllEsfOrganizationDisabledStartEnd((java.lang.String)arguments[0],
				(java.lang.String)arguments[1],
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName466.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes466, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.deleteESFOrganization(((Long)arguments[0]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[1]);
		}

		if (_methodName467.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes467, parameterTypes)) {
			ESFOrganizationLocalServiceUtil.updateESFOrganitazionESFCard(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());

			return null;
		}

		if (_methodName468.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes468, parameterTypes)) {
			ESFOrganizationLocalServiceUtil.updateOnlyESFOrganitazionState(((Long)arguments[0]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[1]);

			return null;
		}

		if (_methodName474.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes474, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.getNameT((it.ethica.esf.model.ESFOrganization)arguments[0]);
		}

		if (_methodName475.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes475, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.findByT_C_N((java.lang.Long)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.Long)arguments[3],
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue());
		}

		if (_methodName476.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes476, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.countByT_C_N((java.lang.Long)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.Long)arguments[3]);
		}

		if (_methodName477.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes477, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.findAllAffilationConiReportAndArmy();
		}

		if (_methodName478.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes478, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.findNewAffilationConiReportAndArmy(((Integer)arguments[0]).intValue());
		}

		if (_methodName479.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes479, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.findByType(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
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
	private String _methodName418;
	private String[] _methodParameterTypes418;
	private String _methodName419;
	private String[] _methodParameterTypes419;
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
	private String _methodName437;
	private String[] _methodParameterTypes437;
	private String _methodName438;
	private String[] _methodParameterTypes438;
	private String _methodName439;
	private String[] _methodParameterTypes439;
	private String _methodName440;
	private String[] _methodParameterTypes440;
	private String _methodName441;
	private String[] _methodParameterTypes441;
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
	private String _methodName447;
	private String[] _methodParameterTypes447;
	private String _methodName448;
	private String[] _methodParameterTypes448;
	private String _methodName449;
	private String[] _methodParameterTypes449;
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
	private String _methodName468;
	private String[] _methodParameterTypes468;
	private String _methodName474;
	private String[] _methodParameterTypes474;
	private String _methodName475;
	private String[] _methodParameterTypes475;
	private String _methodName476;
	private String[] _methodParameterTypes476;
	private String _methodName477;
	private String[] _methodParameterTypes477;
	private String _methodName478;
	private String[] _methodParameterTypes478;
	private String _methodName479;
	private String[] _methodParameterTypes479;
}