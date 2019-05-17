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

import it.ethica.esf.service.ESFCardLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Ethica
 * @generated
 */
public class ESFCardLocalServiceClpInvoker {
	public ESFCardLocalServiceClpInvoker() {
		_methodName0 = "addESFCard";

		_methodParameterTypes0 = new String[] { "it.ethica.esf.model.ESFCard" };

		_methodName1 = "createESFCard";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteESFCard";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteESFCard";

		_methodParameterTypes3 = new String[] { "it.ethica.esf.model.ESFCard" };

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

		_methodName10 = "fetchESFCard";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "fetchESFCardByUuidAndCompanyId";

		_methodParameterTypes11 = new String[] { "java.lang.String", "long" };

		_methodName12 = "fetchESFCardByUuidAndGroupId";

		_methodParameterTypes12 = new String[] { "java.lang.String", "long" };

		_methodName13 = "getESFCard";

		_methodParameterTypes13 = new String[] { "long" };

		_methodName14 = "getPersistedModel";

		_methodParameterTypes14 = new String[] { "java.io.Serializable" };

		_methodName15 = "getESFCardByUuidAndCompanyId";

		_methodParameterTypes15 = new String[] { "java.lang.String", "long" };

		_methodName16 = "getESFCardByUuidAndGroupId";

		_methodParameterTypes16 = new String[] { "java.lang.String", "long" };

		_methodName17 = "getESFCards";

		_methodParameterTypes17 = new String[] { "int", "int" };

		_methodName18 = "getESFCardsCount";

		_methodParameterTypes18 = new String[] {  };

		_methodName19 = "updateESFCard";

		_methodParameterTypes19 = new String[] { "it.ethica.esf.model.ESFCard" };

		_methodName394 = "getBeanIdentifier";

		_methodParameterTypes394 = new String[] {  };

		_methodName395 = "setBeanIdentifier";

		_methodParameterTypes395 = new String[] { "java.lang.String" };

		_methodName400 = "getEsfCardByEsfUserId";

		_methodParameterTypes400 = new String[] { "long" };

		_methodName401 = "addESFCard";

		_methodParameterTypes401 = new String[] {
				"long", "java.lang.String", "java.lang.String", "long",
				"it.ethica.esf.model.ESFEntityState", "long", "long",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName402 = "getAllESFCardsByEsfUserId";

		_methodParameterTypes402 = new String[] { "long" };

		_methodName403 = "createMultiESFCard";

		_methodParameterTypes403 = new String[] {
				"long", "int", "com.liferay.portal.service.ServiceContext"
			};

		_methodName404 = "addSelectedCard";

		_methodParameterTypes404 = new String[] {
				"long", "int", "int", "java.lang.String", "long",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName405 = "findAllESFCardsChildOrg";

		_methodParameterTypes405 = new String[] { "long" };

		_methodName406 = "findAllESFCardsReg_Prov";

		_methodParameterTypes406 = new String[] { "long" };

		_methodName407 = "findAllESFCardsReg_ProvFree";

		_methodParameterTypes407 = new String[] { "long" };

		_methodName408 = "getAllFreeCard";

		_methodParameterTypes408 = new String[] {  };

		_methodName409 = "findAllFreeCardInt";

		_methodParameterTypes409 = new String[] {  };

		_methodName410 = "findAllFreeCards";

		_methodParameterTypes410 = new String[] { "int", "int" };

		_methodName411 = "addMultiESFCard";

		_methodParameterTypes411 = new String[] {
				"long", "java.lang.String", "long",
				"it.ethica.esf.model.ESFEntityState", "long", "long",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName412 = "deleteESFCard";

		_methodParameterTypes412 = new String[] {
				"long", "com.liferay.portal.service.ServiceContext"
			};

		_methodName413 = "deleteESFCard";

		_methodParameterTypes413 = new String[] {
				"long[][]", "com.liferay.portal.service.ServiceContext"
			};

		_methodName414 = "updateESFCard";

		_methodParameterTypes414 = new String[] {
				"long", "long", "java.lang.String", "java.lang.String", "long",
				"long", "long", "it.ethica.esf.model.ESFEntityState", "boolean",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName415 = "findAllESFCardsByCode_Organization";

		_methodParameterTypes415 = new String[] { "java.lang.String", "long" };

		_methodName416 = "findAllESFCardsByC_U_O";

		_methodParameterTypes416 = new String[] {
				"java.lang.String", "long", "long"
			};

		_methodName417 = "findAllESFCardsByState";

		_methodParameterTypes417 = new String[] { "int" };

		_methodName418 = "findAllESFCardsByState";

		_methodParameterTypes418 = new String[] { "int", "int", "int" };

		_methodName419 = "findAllByOrganizationId";

		_methodParameterTypes419 = new String[] { "long", "boolean", "int" };

		_methodName420 = "findAllByOrganizationId";

		_methodParameterTypes420 = new String[] {
				"long", "boolean", "int", "int", "int"
			};

		_methodName421 = "findAllESFCardsByOrganizationId";

		_methodParameterTypes421 = new String[] { "long", "boolean", "int" };

		_methodName422 = "findAllESFCardsByOrganizationId";

		_methodParameterTypes422 = new String[] {
				"long", "boolean", "int", "int", "int"
			};

		_methodName423 = "findAllESFCardsByRootOrganizationId";

		_methodParameterTypes423 = new String[] { "long", "int" };

		_methodName424 = "findAllESFCardsByRootOrganizationId";

		_methodParameterTypes424 = new String[] { "long", "int", "int", "int" };

		_methodName425 = "findESFCardByO_C";

		_methodParameterTypes425 = new String[] { "long", "long", "int" };

		_methodName426 = "findAllNotAssignedESFCardsByO_S";

		_methodParameterTypes426 = new String[] { "long", "boolean", "int" };

		_methodName427 = "findAllNotAssignedESFCardsByO_S";

		_methodParameterTypes427 = new String[] {
				"long", "boolean", "int", "int", "int"
			};

		_methodName428 = "findAllNotAssignedESFCardsByO_U_S";

		_methodParameterTypes428 = new String[] {
				"long", "long", "boolean", "int", "int", "int"
			};

		_methodName429 = "findAllNotAssignedESFCardsByO_U_S";

		_methodParameterTypes429 = new String[] { "long", "boolean", "long", "int" };

		_methodName431 = "findAllESFCardsByU_O_S";

		_methodParameterTypes431 = new String[] { "long", "long", "int" };

		_methodName432 = "findAllESFCardsByU_S_Y";

		_methodParameterTypes432 = new String[] { "long", "java.util.Date" };

		_methodName433 = "findAllESFCardsByU_S_Y";

		_methodParameterTypes433 = new String[] {
				"long", "java.util.Date", "int", "int"
			};

		_methodName434 = "findAllESFCardsByU_S";

		_methodParameterTypes434 = new String[] { "long", "int" };

		_methodName435 = "findCardByUser";

		_methodParameterTypes435 = new String[] { "long" };

		_methodName436 = "getAllEsfCardByLikeC";

		_methodParameterTypes436 = new String[] {
				"java.lang.String", "int", "int", "int"
			};

		_methodName437 = "getAllEsfCardByLikeC";

		_methodParameterTypes437 = new String[] { "java.lang.String", "int" };

		_methodName438 = "getEsfCardByCode";

		_methodParameterTypes438 = new String[] { "java.lang.String", "int" };

		_methodName439 = "checkCode";

		_methodParameterTypes439 = new String[] {
				"java.lang.String", "com.liferay.portal.service.ServiceContext"
			};

		_methodName441 = "buildCode";

		_methodParameterTypes441 = new String[] { "java.lang.String", "long" };

		_methodName442 = "findActualUserCards";

		_methodParameterTypes442 = new String[] { "long" };

		_methodName443 = "findShooterByCardActiveInMatch";

		_methodParameterTypes443 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String"
			};

		_methodName444 = "addESFCardOldCode";

		_methodParameterTypes444 = new String[] {
				"java.lang.String", "long", "java.lang.String",
				"java.lang.String", "long", "it.ethica.esf.model.ESFEntityState",
				"long", "long", "com.liferay.portal.service.ServiceContext"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return ESFCardLocalServiceUtil.addESFCard((it.ethica.esf.model.ESFCard)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return ESFCardLocalServiceUtil.createESFCard(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return ESFCardLocalServiceUtil.deleteESFCard(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return ESFCardLocalServiceUtil.deleteESFCard((it.ethica.esf.model.ESFCard)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return ESFCardLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return ESFCardLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return ESFCardLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return ESFCardLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return ESFCardLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return ESFCardLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return ESFCardLocalServiceUtil.fetchESFCard(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return ESFCardLocalServiceUtil.fetchESFCardByUuidAndCompanyId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return ESFCardLocalServiceUtil.fetchESFCardByUuidAndGroupId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return ESFCardLocalServiceUtil.getESFCard(((Long)arguments[0]).longValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return ESFCardLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return ESFCardLocalServiceUtil.getESFCardByUuidAndCompanyId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName16.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes16, parameterTypes)) {
			return ESFCardLocalServiceUtil.getESFCardByUuidAndGroupId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName17.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes17, parameterTypes)) {
			return ESFCardLocalServiceUtil.getESFCards(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName18.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes18, parameterTypes)) {
			return ESFCardLocalServiceUtil.getESFCardsCount();
		}

		if (_methodName19.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes19, parameterTypes)) {
			return ESFCardLocalServiceUtil.updateESFCard((it.ethica.esf.model.ESFCard)arguments[0]);
		}

		if (_methodName394.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes394, parameterTypes)) {
			return ESFCardLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName395.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes395, parameterTypes)) {
			ESFCardLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName400.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes400, parameterTypes)) {
			return ESFCardLocalServiceUtil.getEsfCardByEsfUserId(((Long)arguments[0]).longValue());
		}

		if (_methodName401.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes401, parameterTypes)) {
			return ESFCardLocalServiceUtil.addESFCard(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				((Long)arguments[3]).longValue(),
				(it.ethica.esf.model.ESFEntityState)arguments[4],
				((Long)arguments[5]).longValue(),
				((Long)arguments[6]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[7]);
		}

		if (_methodName402.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes402, parameterTypes)) {
			return ESFCardLocalServiceUtil.getAllESFCardsByEsfUserId(((Long)arguments[0]).longValue());
		}

		if (_methodName403.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes403, parameterTypes)) {
			return ESFCardLocalServiceUtil.createMultiESFCard(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				(com.liferay.portal.service.ServiceContext)arguments[2]);
		}

		if (_methodName404.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes404, parameterTypes)) {
			return ESFCardLocalServiceUtil.addSelectedCard(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(java.lang.String)arguments[3],
				((Long)arguments[4]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[5]);
		}

		if (_methodName405.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes405, parameterTypes)) {
			return ESFCardLocalServiceUtil.findAllESFCardsChildOrg(((Long)arguments[0]).longValue());
		}

		if (_methodName406.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes406, parameterTypes)) {
			return ESFCardLocalServiceUtil.findAllESFCardsReg_Prov(((Long)arguments[0]).longValue());
		}

		if (_methodName407.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes407, parameterTypes)) {
			return ESFCardLocalServiceUtil.findAllESFCardsReg_ProvFree(((Long)arguments[0]).longValue());
		}

		if (_methodName408.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes408, parameterTypes)) {
			return ESFCardLocalServiceUtil.getAllFreeCard();
		}

		if (_methodName409.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes409, parameterTypes)) {
			return ESFCardLocalServiceUtil.findAllFreeCardInt();
		}

		if (_methodName410.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes410, parameterTypes)) {
			return ESFCardLocalServiceUtil.findAllFreeCards(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName411.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes411, parameterTypes)) {
			return ESFCardLocalServiceUtil.addMultiESFCard(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1],
				((Long)arguments[2]).longValue(),
				(it.ethica.esf.model.ESFEntityState)arguments[3],
				((Long)arguments[4]).longValue(),
				((Long)arguments[5]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[6]);
		}

		if (_methodName412.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes412, parameterTypes)) {
			return ESFCardLocalServiceUtil.deleteESFCard(((Long)arguments[0]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[1]);
		}

		if (_methodName413.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes413, parameterTypes)) {
			ESFCardLocalServiceUtil.deleteESFCard((long[])arguments[0],
				(com.liferay.portal.service.ServiceContext)arguments[1]);

			return null;
		}

		if (_methodName414.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes414, parameterTypes)) {
			return ESFCardLocalServiceUtil.updateESFCard(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3],
				((Long)arguments[4]).longValue(),
				((Long)arguments[5]).longValue(),
				((Long)arguments[6]).longValue(),
				(it.ethica.esf.model.ESFEntityState)arguments[7],
				((Boolean)arguments[8]).booleanValue(),
				(com.liferay.portal.service.ServiceContext)arguments[9]);
		}

		if (_methodName415.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes415, parameterTypes)) {
			return ESFCardLocalServiceUtil.findAllESFCardsByCode_Organization((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName416.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes416, parameterTypes)) {
			return ESFCardLocalServiceUtil.findAllESFCardsByC_U_O((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue());
		}

		if (_methodName417.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes417, parameterTypes)) {
			return ESFCardLocalServiceUtil.findAllESFCardsByState(((Integer)arguments[0]).intValue());
		}

		if (_methodName418.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes418, parameterTypes)) {
			return ESFCardLocalServiceUtil.findAllESFCardsByState(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName419.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes419, parameterTypes)) {
			return ESFCardLocalServiceUtil.findAllByOrganizationId(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName420.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes420, parameterTypes)) {
			return ESFCardLocalServiceUtil.findAllByOrganizationId(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue());
		}

		if (_methodName421.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes421, parameterTypes)) {
			return ESFCardLocalServiceUtil.findAllESFCardsByOrganizationId(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName422.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes422, parameterTypes)) {
			return ESFCardLocalServiceUtil.findAllESFCardsByOrganizationId(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue());
		}

		if (_methodName423.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes423, parameterTypes)) {
			return ESFCardLocalServiceUtil.findAllESFCardsByRootOrganizationId(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName424.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes424, parameterTypes)) {
			return ESFCardLocalServiceUtil.findAllESFCardsByRootOrganizationId(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName425.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes425, parameterTypes)) {
			return ESFCardLocalServiceUtil.findESFCardByO_C(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName426.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes426, parameterTypes)) {
			return ESFCardLocalServiceUtil.findAllNotAssignedESFCardsByO_S(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName427.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes427, parameterTypes)) {
			return ESFCardLocalServiceUtil.findAllNotAssignedESFCardsByO_S(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue());
		}

		if (_methodName428.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes428, parameterTypes)) {
			return ESFCardLocalServiceUtil.findAllNotAssignedESFCardsByO_U_S(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Boolean)arguments[2]).booleanValue(),
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue());
		}

		if (_methodName429.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes429, parameterTypes)) {
			return ESFCardLocalServiceUtil.findAllNotAssignedESFCardsByO_U_S(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue(),
				((Long)arguments[2]).longValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName431.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes431, parameterTypes)) {
			return ESFCardLocalServiceUtil.findAllESFCardsByU_O_S(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName432.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes432, parameterTypes)) {
			return ESFCardLocalServiceUtil.findAllESFCardsByU_S_Y(((Long)arguments[0]).longValue(),
				(java.util.Date)arguments[1]);
		}

		if (_methodName433.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes433, parameterTypes)) {
			return ESFCardLocalServiceUtil.findAllESFCardsByU_S_Y(((Long)arguments[0]).longValue(),
				(java.util.Date)arguments[1],
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName434.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes434, parameterTypes)) {
			return ESFCardLocalServiceUtil.findAllESFCardsByU_S(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName435.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes435, parameterTypes)) {
			return ESFCardLocalServiceUtil.findCardByUser(((Long)arguments[0]).longValue());
		}

		if (_methodName436.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes436, parameterTypes)) {
			return ESFCardLocalServiceUtil.getAllEsfCardByLikeC((java.lang.String)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName437.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes437, parameterTypes)) {
			return ESFCardLocalServiceUtil.getAllEsfCardByLikeC((java.lang.String)arguments[0],
				((Integer)arguments[1]).intValue());
		}

		if (_methodName438.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes438, parameterTypes)) {
			return ESFCardLocalServiceUtil.getEsfCardByCode((java.lang.String)arguments[0],
				((Integer)arguments[1]).intValue());
		}

		if (_methodName439.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes439, parameterTypes)) {
			return ESFCardLocalServiceUtil.checkCode((java.lang.String)arguments[0],
				(com.liferay.portal.service.ServiceContext)arguments[1]);
		}

		if (_methodName441.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes441, parameterTypes)) {
			return ESFCardLocalServiceUtil.buildCode((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName442.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes442, parameterTypes)) {
			return ESFCardLocalServiceUtil.findActualUserCards(((Long)arguments[0]).longValue());
		}

		if (_methodName443.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes443, parameterTypes)) {
			return ESFCardLocalServiceUtil.findShooterByCardActiveInMatch((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2]);
		}

		if (_methodName444.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes444, parameterTypes)) {
			return ESFCardLocalServiceUtil.addESFCardOldCode((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3],
				((Long)arguments[4]).longValue(),
				(it.ethica.esf.model.ESFEntityState)arguments[5],
				((Long)arguments[6]).longValue(),
				((Long)arguments[7]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[8]);
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
	private String _methodName394;
	private String[] _methodParameterTypes394;
	private String _methodName395;
	private String[] _methodParameterTypes395;
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
	private String _methodName441;
	private String[] _methodParameterTypes441;
	private String _methodName442;
	private String[] _methodParameterTypes442;
	private String _methodName443;
	private String[] _methodParameterTypes443;
	private String _methodName444;
	private String[] _methodParameterTypes444;
}