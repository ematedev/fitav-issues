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

		_methodName434 = "getBeanIdentifier";

		_methodParameterTypes434 = new String[] {  };

		_methodName435 = "setBeanIdentifier";

		_methodParameterTypes435 = new String[] { "java.lang.String" };

		_methodName440 = "getEsfCardByEsfUserId";

		_methodParameterTypes440 = new String[] { "long" };

		_methodName441 = "addESFCard";

		_methodParameterTypes441 = new String[] {
				"long", "java.lang.String", "java.lang.String", "long",
				"it.ethica.esf.model.ESFEntityState", "long", "long",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName442 = "getAllESFCardsByEsfUserId";

		_methodParameterTypes442 = new String[] { "long" };

		_methodName443 = "createMultiESFCard";

		_methodParameterTypes443 = new String[] {
				"long", "int", "com.liferay.portal.service.ServiceContext"
			};

		_methodName444 = "addSelectedCard";

		_methodParameterTypes444 = new String[] {
				"long", "int", "int", "java.lang.String", "long",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName445 = "findAllESFCardsChildOrg";

		_methodParameterTypes445 = new String[] { "long" };

		_methodName446 = "findAllESFCardsReg_Prov";

		_methodParameterTypes446 = new String[] { "long" };

		_methodName447 = "findAllESFCardsReg_ProvFree";

		_methodParameterTypes447 = new String[] { "long" };

		_methodName448 = "getAllFreeCard";

		_methodParameterTypes448 = new String[] {  };

		_methodName449 = "findAllFreeCardInt";

		_methodParameterTypes449 = new String[] {  };

		_methodName450 = "findAllFreeCards";

		_methodParameterTypes450 = new String[] { "int", "int" };

		_methodName451 = "addMultiESFCard";

		_methodParameterTypes451 = new String[] {
				"long", "java.lang.String", "long",
				"it.ethica.esf.model.ESFEntityState", "long", "long",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName452 = "deleteESFCard";

		_methodParameterTypes452 = new String[] {
				"long", "com.liferay.portal.service.ServiceContext"
			};

		_methodName453 = "deleteESFCard";

		_methodParameterTypes453 = new String[] {
				"long[][]", "com.liferay.portal.service.ServiceContext"
			};

		_methodName454 = "updateESFCard";

		_methodParameterTypes454 = new String[] {
				"long", "long", "java.lang.String", "java.lang.String", "long",
				"long", "long", "it.ethica.esf.model.ESFEntityState", "boolean",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName455 = "findAllESFCardsByCode_Organization";

		_methodParameterTypes455 = new String[] { "java.lang.String", "long" };

		_methodName456 = "findAllESFCardsByC_U_O";

		_methodParameterTypes456 = new String[] {
				"java.lang.String", "long", "long"
			};

		_methodName457 = "findAllESFCardsByState";

		_methodParameterTypes457 = new String[] { "int" };

		_methodName458 = "findAllESFCardsByState";

		_methodParameterTypes458 = new String[] { "int", "int", "int" };

		_methodName459 = "findAllByOrganizationId";

		_methodParameterTypes459 = new String[] { "long", "boolean", "int" };

		_methodName460 = "findAllByOrganizationId";

		_methodParameterTypes460 = new String[] {
				"long", "boolean", "int", "int", "int"
			};

		_methodName461 = "findAllESFCardsByOrganizationId";

		_methodParameterTypes461 = new String[] { "long", "boolean", "int" };

		_methodName462 = "findAllESFCardsByOrganizationId";

		_methodParameterTypes462 = new String[] {
				"long", "boolean", "int", "int", "int"
			};

		_methodName463 = "findAllESFCardsByRootOrganizationId";

		_methodParameterTypes463 = new String[] { "long", "int" };

		_methodName464 = "findAllESFCardsByRootOrganizationId";

		_methodParameterTypes464 = new String[] { "long", "int", "int", "int" };

		_methodName465 = "findESFCardByO_C";

		_methodParameterTypes465 = new String[] { "long", "long", "int" };

		_methodName466 = "findAllNotAssignedESFCardsByO_S";

		_methodParameterTypes466 = new String[] { "long", "boolean", "int" };

		_methodName467 = "findAllNotAssignedESFCardsByO_S";

		_methodParameterTypes467 = new String[] {
				"long", "boolean", "int", "int", "int"
			};

		_methodName468 = "findAllNotAssignedESFCardsByO_U_S";

		_methodParameterTypes468 = new String[] {
				"long", "long", "boolean", "int", "int", "int"
			};

		_methodName469 = "findAllNotAssignedESFCardsByO_U_S";

		_methodParameterTypes469 = new String[] { "long", "boolean", "long", "int" };

		_methodName471 = "findAllESFCardsByU_O_S";

		_methodParameterTypes471 = new String[] { "long", "long", "int" };

		_methodName472 = "findAllESFCardsByU_S_Y";

		_methodParameterTypes472 = new String[] { "long", "java.util.Date" };

		_methodName473 = "findAllESFCardsByU_S_Y";

		_methodParameterTypes473 = new String[] {
				"long", "java.util.Date", "int", "int"
			};

		_methodName474 = "findAllESFCardsByU_S";

		_methodParameterTypes474 = new String[] { "long", "int" };

		_methodName475 = "findCardByUser";

		_methodParameterTypes475 = new String[] { "long" };

		_methodName476 = "getAllEsfCardByLikeC";

		_methodParameterTypes476 = new String[] {
				"java.lang.String", "int", "int", "int"
			};

		_methodName477 = "getAllEsfCardByLikeC";

		_methodParameterTypes477 = new String[] { "java.lang.String", "int" };

		_methodName478 = "getEsfCardByCode";

		_methodParameterTypes478 = new String[] { "java.lang.String", "int" };

		_methodName479 = "checkCode";

		_methodParameterTypes479 = new String[] {
				"java.lang.String", "com.liferay.portal.service.ServiceContext"
			};

		_methodName481 = "buildCode";

		_methodParameterTypes481 = new String[] { "java.lang.String", "long" };

		_methodName482 = "findActualUserCards";

		_methodParameterTypes482 = new String[] { "long" };

		_methodName483 = "findShooterByCardActiveInMatch";

		_methodParameterTypes483 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String"
			};

		_methodName484 = "addESFCardOldCode";

		_methodParameterTypes484 = new String[] {
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

		if (_methodName434.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes434, parameterTypes)) {
			return ESFCardLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName435.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes435, parameterTypes)) {
			ESFCardLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName440.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes440, parameterTypes)) {
			return ESFCardLocalServiceUtil.getEsfCardByEsfUserId(((Long)arguments[0]).longValue());
		}

		if (_methodName441.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes441, parameterTypes)) {
			return ESFCardLocalServiceUtil.addESFCard(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				((Long)arguments[3]).longValue(),
				(it.ethica.esf.model.ESFEntityState)arguments[4],
				((Long)arguments[5]).longValue(),
				((Long)arguments[6]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[7]);
		}

		if (_methodName442.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes442, parameterTypes)) {
			return ESFCardLocalServiceUtil.getAllESFCardsByEsfUserId(((Long)arguments[0]).longValue());
		}

		if (_methodName443.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes443, parameterTypes)) {
			return ESFCardLocalServiceUtil.createMultiESFCard(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				(com.liferay.portal.service.ServiceContext)arguments[2]);
		}

		if (_methodName444.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes444, parameterTypes)) {
			return ESFCardLocalServiceUtil.addSelectedCard(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(java.lang.String)arguments[3],
				((Long)arguments[4]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[5]);
		}

		if (_methodName445.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes445, parameterTypes)) {
			return ESFCardLocalServiceUtil.findAllESFCardsChildOrg(((Long)arguments[0]).longValue());
		}

		if (_methodName446.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes446, parameterTypes)) {
			return ESFCardLocalServiceUtil.findAllESFCardsReg_Prov(((Long)arguments[0]).longValue());
		}

		if (_methodName447.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes447, parameterTypes)) {
			return ESFCardLocalServiceUtil.findAllESFCardsReg_ProvFree(((Long)arguments[0]).longValue());
		}

		if (_methodName448.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes448, parameterTypes)) {
			return ESFCardLocalServiceUtil.getAllFreeCard();
		}

		if (_methodName449.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes449, parameterTypes)) {
			return ESFCardLocalServiceUtil.findAllFreeCardInt();
		}

		if (_methodName450.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes450, parameterTypes)) {
			return ESFCardLocalServiceUtil.findAllFreeCards(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName451.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes451, parameterTypes)) {
			return ESFCardLocalServiceUtil.addMultiESFCard(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1],
				((Long)arguments[2]).longValue(),
				(it.ethica.esf.model.ESFEntityState)arguments[3],
				((Long)arguments[4]).longValue(),
				((Long)arguments[5]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[6]);
		}

		if (_methodName452.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes452, parameterTypes)) {
			return ESFCardLocalServiceUtil.deleteESFCard(((Long)arguments[0]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[1]);
		}

		if (_methodName453.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes453, parameterTypes)) {
			ESFCardLocalServiceUtil.deleteESFCard((long[])arguments[0],
				(com.liferay.portal.service.ServiceContext)arguments[1]);

			return null;
		}

		if (_methodName454.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes454, parameterTypes)) {
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

		if (_methodName455.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes455, parameterTypes)) {
			return ESFCardLocalServiceUtil.findAllESFCardsByCode_Organization((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName456.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes456, parameterTypes)) {
			return ESFCardLocalServiceUtil.findAllESFCardsByC_U_O((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue());
		}

		if (_methodName457.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes457, parameterTypes)) {
			return ESFCardLocalServiceUtil.findAllESFCardsByState(((Integer)arguments[0]).intValue());
		}

		if (_methodName458.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes458, parameterTypes)) {
			return ESFCardLocalServiceUtil.findAllESFCardsByState(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName459.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes459, parameterTypes)) {
			return ESFCardLocalServiceUtil.findAllByOrganizationId(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName460.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes460, parameterTypes)) {
			return ESFCardLocalServiceUtil.findAllByOrganizationId(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue());
		}

		if (_methodName461.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes461, parameterTypes)) {
			return ESFCardLocalServiceUtil.findAllESFCardsByOrganizationId(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName462.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes462, parameterTypes)) {
			return ESFCardLocalServiceUtil.findAllESFCardsByOrganizationId(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue());
		}

		if (_methodName463.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes463, parameterTypes)) {
			return ESFCardLocalServiceUtil.findAllESFCardsByRootOrganizationId(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName464.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes464, parameterTypes)) {
			return ESFCardLocalServiceUtil.findAllESFCardsByRootOrganizationId(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName465.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes465, parameterTypes)) {
			return ESFCardLocalServiceUtil.findESFCardByO_C(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName466.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes466, parameterTypes)) {
			return ESFCardLocalServiceUtil.findAllNotAssignedESFCardsByO_S(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName467.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes467, parameterTypes)) {
			return ESFCardLocalServiceUtil.findAllNotAssignedESFCardsByO_S(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue());
		}

		if (_methodName468.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes468, parameterTypes)) {
			return ESFCardLocalServiceUtil.findAllNotAssignedESFCardsByO_U_S(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Boolean)arguments[2]).booleanValue(),
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue());
		}

		if (_methodName469.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes469, parameterTypes)) {
			return ESFCardLocalServiceUtil.findAllNotAssignedESFCardsByO_U_S(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue(),
				((Long)arguments[2]).longValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName471.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes471, parameterTypes)) {
			return ESFCardLocalServiceUtil.findAllESFCardsByU_O_S(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName472.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes472, parameterTypes)) {
			return ESFCardLocalServiceUtil.findAllESFCardsByU_S_Y(((Long)arguments[0]).longValue(),
				(java.util.Date)arguments[1]);
		}

		if (_methodName473.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes473, parameterTypes)) {
			return ESFCardLocalServiceUtil.findAllESFCardsByU_S_Y(((Long)arguments[0]).longValue(),
				(java.util.Date)arguments[1],
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName474.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes474, parameterTypes)) {
			return ESFCardLocalServiceUtil.findAllESFCardsByU_S(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName475.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes475, parameterTypes)) {
			return ESFCardLocalServiceUtil.findCardByUser(((Long)arguments[0]).longValue());
		}

		if (_methodName476.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes476, parameterTypes)) {
			return ESFCardLocalServiceUtil.getAllEsfCardByLikeC((java.lang.String)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName477.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes477, parameterTypes)) {
			return ESFCardLocalServiceUtil.getAllEsfCardByLikeC((java.lang.String)arguments[0],
				((Integer)arguments[1]).intValue());
		}

		if (_methodName478.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes478, parameterTypes)) {
			return ESFCardLocalServiceUtil.getEsfCardByCode((java.lang.String)arguments[0],
				((Integer)arguments[1]).intValue());
		}

		if (_methodName479.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes479, parameterTypes)) {
			return ESFCardLocalServiceUtil.checkCode((java.lang.String)arguments[0],
				(com.liferay.portal.service.ServiceContext)arguments[1]);
		}

		if (_methodName481.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes481, parameterTypes)) {
			return ESFCardLocalServiceUtil.buildCode((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName482.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes482, parameterTypes)) {
			return ESFCardLocalServiceUtil.findActualUserCards(((Long)arguments[0]).longValue());
		}

		if (_methodName483.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes483, parameterTypes)) {
			return ESFCardLocalServiceUtil.findShooterByCardActiveInMatch((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2]);
		}

		if (_methodName484.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes484, parameterTypes)) {
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
	private String _methodName434;
	private String[] _methodParameterTypes434;
	private String _methodName435;
	private String[] _methodParameterTypes435;
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
	private String _methodName477;
	private String[] _methodParameterTypes477;
	private String _methodName478;
	private String[] _methodParameterTypes478;
	private String _methodName479;
	private String[] _methodParameterTypes479;
	private String _methodName481;
	private String[] _methodParameterTypes481;
	private String _methodName482;
	private String[] _methodParameterTypes482;
	private String _methodName483;
	private String[] _methodParameterTypes483;
	private String _methodName484;
	private String[] _methodParameterTypes484;
}