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

		_methodName426 = "getBeanIdentifier";

		_methodParameterTypes426 = new String[] {  };

		_methodName427 = "setBeanIdentifier";

		_methodParameterTypes427 = new String[] { "java.lang.String" };

		_methodName432 = "addESFOrganization";

		_methodParameterTypes432 = new String[] {
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

		_methodName433 = "addESFOrganization";

		_methodParameterTypes433 = new String[] {
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

		_methodName434 = "updateESFOrganization";

		_methodParameterTypes434 = new String[] {
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

		_methodName435 = "updateESFOrganization";

		_methodParameterTypes435 = new String[] {
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

		_methodName436 = "findByGroupId";

		_methodParameterTypes436 = new String[] { "long" };

		_methodName437 = "getByProvinceCode";

		_methodParameterTypes437 = new String[] { "java.lang.String" };

		_methodName438 = "findByGroupId";

		_methodParameterTypes438 = new String[] { "long", "int", "int" };

		_methodName439 = "findByCode";

		_methodParameterTypes439 = new String[] { "java.lang.String" };

		_methodName440 = "getRealOwner";

		_methodParameterTypes440 = new String[] { "long", "long" };

		_methodName441 = "findAllESFOrganizations";

		_methodParameterTypes441 = new String[] { "long", "int" };

		_methodName442 = "findESFOrganizationsByCode";

		_methodParameterTypes442 = new String[] { "java.lang.String" };

		_methodName443 = "findESFOrganizationsByT_C";

		_methodParameterTypes443 = new String[] {
				"long", "java.lang.String", "int"
			};

		_methodName444 = "findESFOrganizationsByT_C";

		_methodParameterTypes444 = new String[] {
				"long", "java.lang.String", "int", "int", "int"
			};

		_methodName445 = "findESFOrganizationsByT_C_N";

		_methodParameterTypes445 = new String[] {
				"long", "java.lang.String", "java.lang.String", "int", "int",
				"int"
			};

		_methodName446 = "findESFOrganizationsByT_C_N";

		_methodParameterTypes446 = new String[] {
				"long", "java.lang.String", "java.lang.String", "int"
			};

		_methodName447 = "findESFOrganizationsByT_C";

		_methodParameterTypes447 = new String[] { "long", "int" };

		_methodName448 = "findESFOrganizationsByT_C";

		_methodParameterTypes448 = new String[] { "long", "int", "int", "int" };

		_methodName449 = "findESFOrganizationsByCode";

		_methodParameterTypes449 = new String[] {
				"long", "java.lang.String", "int"
			};

		_methodName450 = "findESFOrganizationsByCode";

		_methodParameterTypes450 = new String[] {
				"long", "java.lang.String", "int", "int", "int"
			};

		_methodName451 = "findESFOrganizationsByO_T";

		_methodParameterTypes451 = new String[] { "long", "long" };

		_methodName452 = "findESFOrganizationsByO_T_C_N";

		_methodParameterTypes452 = new String[] {
				"long", "long", "java.lang.String", "java.lang.String"
			};

		_methodName453 = "findESFOrganizationsByO_T_C_N";

		_methodParameterTypes453 = new String[] {
				"long", "long", "java.lang.String", "java.lang.String", "int",
				"int"
			};

		_methodName454 = "getOrganizzationLeafByLikeN_C";

		_methodParameterTypes454 = new String[] {
				"java.lang.String", "java.lang.String", "long", "long"
			};

		_methodName455 = "getOrganizzationLeafByLikeN_C";

		_methodParameterTypes455 = new String[] {
				"java.lang.String", "java.lang.String", "long", "long", "int",
				"int"
			};

		_methodName456 = "findAllLeafOrganizations";

		_methodParameterTypes456 = new String[] { "long" };

		_methodName457 = "findAllLeafOrganizations";

		_methodParameterTypes457 = new String[] {
				"long", "java.lang.String", "java.lang.String"
			};

		_methodName458 = "findAllOrganizationsIncrements";

		_methodParameterTypes458 = new String[] {
				"java.lang.String", "java.lang.String", "int", "int"
			};

		_methodName459 = "findAllOrganizationsIncrements";

		_methodParameterTypes459 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName460 = "findAllLeafOrganizations";

		_methodParameterTypes460 = new String[] { "long", "int", "int" };

		_methodName461 = "findAllLeafOrganizations";

		_methodParameterTypes461 = new String[] {
				"long", "java.lang.String", "java.lang.String", "int", "int"
			};

		_methodName462 = "findAllLeafOrganizations";

		_methodParameterTypes462 = new String[] { "long", "int" };

		_methodName463 = "findAllLeafOrganizations";

		_methodParameterTypes463 = new String[] { "long", "int", "int", "int" };

		_methodName464 = "findAllChildOrganizations";

		_methodParameterTypes464 = new String[] { "long" };

		_methodName465 = "findAllChildOrganizations";

		_methodParameterTypes465 = new String[] { "long", "int", "int" };

		_methodName466 = "findAllChildOrganizations";

		_methodParameterTypes466 = new String[] { "long", "int" };

		_methodName467 = "findAllChildOrganizations";

		_methodParameterTypes467 = new String[] { "long", "int", "int", "int" };

		_methodName468 = "findByPaymentYear";

		_methodParameterTypes468 = new String[] { "int", "int", "int" };

		_methodName469 = "countByPaymentYear";

		_methodParameterTypes469 = new String[] { "int" };

		_methodName470 = "getAllEsfOrganizationByState";

		_methodParameterTypes470 = new String[] { "int" };

		_methodName471 = "getAllEsfOrganizationByState";

		_methodParameterTypes471 = new String[] { "int", "int", "int" };

		_methodName472 = "getAllEsfOrganizationDisabled";

		_methodParameterTypes472 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName473 = "getAllEsfOrganizationDisabledStartEnd";

		_methodParameterTypes473 = new String[] {
				"java.lang.String", "java.lang.String", "int", "int"
			};

		_methodName474 = "deleteESFOrganization";

		_methodParameterTypes474 = new String[] {
				"long", "com.liferay.portal.service.ServiceContext"
			};

		_methodName475 = "updateESFOrganitazionESFCard";

		_methodParameterTypes475 = new String[] { "long", "long" };

		_methodName476 = "updateOnlyESFOrganitazionState";

		_methodParameterTypes476 = new String[] {
				"long", "com.liferay.portal.service.ServiceContext"
			};

		_methodName482 = "getNameT";

		_methodParameterTypes482 = new String[] {
				"it.ethica.esf.model.ESFOrganization"
			};

		_methodName483 = "findByT_C_N";

		_methodParameterTypes483 = new String[] {
				"java.lang.Long", "java.lang.String", "java.lang.String",
				"java.lang.Long", "int", "int"
			};

		_methodName484 = "countByT_C_N";

		_methodParameterTypes484 = new String[] {
				"java.lang.Long", "java.lang.String", "java.lang.String",
				"java.lang.Long"
			};

		_methodName485 = "findAllAffilationConiReportAndArmy";

		_methodParameterTypes485 = new String[] {  };

		_methodName486 = "findNewAffilationConiReportAndArmy";

		_methodParameterTypes486 = new String[] { "int" };

		_methodName487 = "findByType";

		_methodParameterTypes487 = new String[] { "int", "int", "int" };
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

		if (_methodName426.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes426, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName427.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes427, parameterTypes)) {
			ESFOrganizationLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName432.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes432, parameterTypes)) {
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

		if (_methodName433.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes433, parameterTypes)) {
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

		if (_methodName434.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes434, parameterTypes)) {
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

		if (_methodName435.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes435, parameterTypes)) {
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

		if (_methodName436.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes436, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.findByGroupId(((Long)arguments[0]).longValue());
		}

		if (_methodName437.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes437, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.getByProvinceCode((java.lang.String)arguments[0]);
		}

		if (_methodName438.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes438, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.findByGroupId(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName439.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes439, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.findByCode((java.lang.String)arguments[0]);
		}

		if (_methodName440.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes440, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.getRealOwner(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName441.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes441, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.findAllESFOrganizations(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName442.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes442, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.findESFOrganizationsByCode((java.lang.String)arguments[0]);
		}

		if (_methodName443.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes443, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.findESFOrganizationsByT_C(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1],
				((Integer)arguments[2]).intValue());
		}

		if (_methodName444.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes444, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.findESFOrganizationsByT_C(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1],
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue());
		}

		if (_methodName445.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes445, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.findESFOrganizationsByT_C_N(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue());
		}

		if (_methodName446.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes446, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.findESFOrganizationsByT_C_N(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				((Integer)arguments[3]).intValue());
		}

		if (_methodName447.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes447, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.findESFOrganizationsByT_C(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName448.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes448, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.findESFOrganizationsByT_C(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName449.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes449, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.findESFOrganizationsByCode(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1],
				((Integer)arguments[2]).intValue());
		}

		if (_methodName450.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes450, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.findESFOrganizationsByCode(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1],
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue());
		}

		if (_methodName451.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes451, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.findESFOrganizationsByO_T(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName452.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes452, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.findESFOrganizationsByO_T_C_N(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3]);
		}

		if (_methodName453.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes453, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.findESFOrganizationsByO_T_C_N(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3],
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue());
		}

		if (_methodName454.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes454, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.getOrganizzationLeafByLikeN_C((java.lang.String)arguments[0],
				(java.lang.String)arguments[1],
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue());
		}

		if (_methodName455.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes455, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.getOrganizzationLeafByLikeN_C((java.lang.String)arguments[0],
				(java.lang.String)arguments[1],
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue(),
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue());
		}

		if (_methodName456.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes456, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.findAllLeafOrganizations(((Long)arguments[0]).longValue());
		}

		if (_methodName457.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes457, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.findAllLeafOrganizations(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2]);
		}

		if (_methodName458.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes458, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.findAllOrganizationsIncrements((java.lang.String)arguments[0],
				(java.lang.String)arguments[1],
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName459.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes459, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.findAllOrganizationsIncrements((java.lang.String)arguments[0],
				(java.lang.String)arguments[1]);
		}

		if (_methodName460.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes460, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.findAllLeafOrganizations(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName461.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes461, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.findAllLeafOrganizations(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue());
		}

		if (_methodName462.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes462, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.findAllLeafOrganizations(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName463.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes463, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.findAllLeafOrganizations(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName464.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes464, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.findAllChildOrganizations(((Long)arguments[0]).longValue());
		}

		if (_methodName465.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes465, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.findAllChildOrganizations(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName466.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes466, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.findAllChildOrganizations(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName467.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes467, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.findAllChildOrganizations(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName468.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes468, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.findByPaymentYear(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName469.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes469, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.countByPaymentYear(((Integer)arguments[0]).intValue());
		}

		if (_methodName470.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes470, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.getAllEsfOrganizationByState(((Integer)arguments[0]).intValue());
		}

		if (_methodName471.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes471, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.getAllEsfOrganizationByState(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName472.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes472, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.getAllEsfOrganizationDisabled((java.lang.String)arguments[0],
				(java.lang.String)arguments[1]);
		}

		if (_methodName473.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes473, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.getAllEsfOrganizationDisabledStartEnd((java.lang.String)arguments[0],
				(java.lang.String)arguments[1],
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName474.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes474, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.deleteESFOrganization(((Long)arguments[0]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[1]);
		}

		if (_methodName475.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes475, parameterTypes)) {
			ESFOrganizationLocalServiceUtil.updateESFOrganitazionESFCard(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());

			return null;
		}

		if (_methodName476.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes476, parameterTypes)) {
			ESFOrganizationLocalServiceUtil.updateOnlyESFOrganitazionState(((Long)arguments[0]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[1]);

			return null;
		}

		if (_methodName482.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes482, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.getNameT((it.ethica.esf.model.ESFOrganization)arguments[0]);
		}

		if (_methodName483.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes483, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.findByT_C_N((java.lang.Long)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.Long)arguments[3],
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue());
		}

		if (_methodName484.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes484, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.countByT_C_N((java.lang.Long)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.Long)arguments[3]);
		}

		if (_methodName485.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes485, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.findAllAffilationConiReportAndArmy();
		}

		if (_methodName486.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes486, parameterTypes)) {
			return ESFOrganizationLocalServiceUtil.findNewAffilationConiReportAndArmy(((Integer)arguments[0]).intValue());
		}

		if (_methodName487.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes487, parameterTypes)) {
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
	private String _methodName426;
	private String[] _methodParameterTypes426;
	private String _methodName427;
	private String[] _methodParameterTypes427;
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
	private String _methodName476;
	private String[] _methodParameterTypes476;
	private String _methodName482;
	private String[] _methodParameterTypes482;
	private String _methodName483;
	private String[] _methodParameterTypes483;
	private String _methodName484;
	private String[] _methodParameterTypes484;
	private String _methodName485;
	private String[] _methodParameterTypes485;
	private String _methodName486;
	private String[] _methodParameterTypes486;
	private String _methodName487;
	private String[] _methodParameterTypes487;
}