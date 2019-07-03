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

		_methodName458 = "getBeanIdentifier";

		_methodParameterTypes458 = new String[] {  };

		_methodName459 = "setBeanIdentifier";

		_methodParameterTypes459 = new String[] { "java.lang.String" };

		_methodName464 = "getEsfCardByEsfUserId";

		_methodParameterTypes464 = new String[] { "long" };

		_methodName465 = "addESFCard";

		_methodParameterTypes465 = new String[] {
				"long", "java.lang.String", "java.lang.String", "long",
				"it.ethica.esf.model.ESFEntityState", "long", "long",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName466 = "getAllESFCardsByEsfUserId";

		_methodParameterTypes466 = new String[] { "long" };

		_methodName467 = "createMultiESFCard";

		_methodParameterTypes467 = new String[] {
				"long", "int", "com.liferay.portal.service.ServiceContext"
			};

		_methodName468 = "addSelectedCard";

		_methodParameterTypes468 = new String[] {
				"long", "int", "int", "java.lang.String", "long",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName469 = "findAllESFCardsChildOrg";

		_methodParameterTypes469 = new String[] { "long" };

		_methodName470 = "findAllESFCardsReg_Prov";

		_methodParameterTypes470 = new String[] { "long" };

		_methodName471 = "findAllESFCardsReg_ProvFree";

		_methodParameterTypes471 = new String[] { "long" };

		_methodName472 = "getAllFreeCard";

		_methodParameterTypes472 = new String[] {  };

		_methodName473 = "findAllFreeCardInt";

		_methodParameterTypes473 = new String[] {  };

		_methodName474 = "findAllFreeCards";

		_methodParameterTypes474 = new String[] { "int", "int" };

		_methodName475 = "addMultiESFCard";

		_methodParameterTypes475 = new String[] {
				"long", "java.lang.String", "long",
				"it.ethica.esf.model.ESFEntityState", "long", "long",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName476 = "deleteESFCard";

		_methodParameterTypes476 = new String[] {
				"long", "com.liferay.portal.service.ServiceContext"
			};

		_methodName477 = "deleteESFCard";

		_methodParameterTypes477 = new String[] {
				"long[][]", "com.liferay.portal.service.ServiceContext"
			};

		_methodName478 = "updateESFCard";

		_methodParameterTypes478 = new String[] {
				"long", "long", "java.lang.String", "java.lang.String", "long",
				"long", "long", "it.ethica.esf.model.ESFEntityState", "boolean",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName479 = "findAllESFCardsByCode_Organization";

		_methodParameterTypes479 = new String[] { "java.lang.String", "long" };

		_methodName480 = "findAllESFCardsByC_U_O";

		_methodParameterTypes480 = new String[] {
				"java.lang.String", "long", "long"
			};

		_methodName481 = "findAllESFCardsByState";

		_methodParameterTypes481 = new String[] { "int" };

		_methodName482 = "findAllESFCardsByState";

		_methodParameterTypes482 = new String[] { "int", "int", "int" };

		_methodName483 = "findAllByOrganizationId";

		_methodParameterTypes483 = new String[] { "long", "boolean", "int" };

		_methodName484 = "findAllByOrganizationId";

		_methodParameterTypes484 = new String[] {
				"long", "boolean", "int", "int", "int"
			};

		_methodName485 = "findAllESFCardsByOrganizationId";

		_methodParameterTypes485 = new String[] { "long", "boolean", "int" };

		_methodName486 = "findAllESFCardsByOrganizationId";

		_methodParameterTypes486 = new String[] {
				"long", "boolean", "int", "int", "int"
			};

		_methodName487 = "findAllESFCardsByRootOrganizationId";

		_methodParameterTypes487 = new String[] { "long", "int" };

		_methodName488 = "findAllESFCardsByRootOrganizationId";

		_methodParameterTypes488 = new String[] { "long", "int", "int", "int" };

		_methodName489 = "findESFCardByO_C";

		_methodParameterTypes489 = new String[] { "long", "long", "int" };

		_methodName490 = "findAllNotAssignedESFCardsByO_S";

		_methodParameterTypes490 = new String[] { "long", "boolean", "int" };

		_methodName491 = "findAllNotAssignedESFCardsByO_S";

		_methodParameterTypes491 = new String[] {
				"long", "boolean", "int", "int", "int"
			};

		_methodName492 = "findAllNotAssignedESFCardsByO_U_S";

		_methodParameterTypes492 = new String[] {
				"long", "long", "boolean", "int", "int", "int"
			};

		_methodName493 = "findAllNotAssignedESFCardsByO_U_S";

		_methodParameterTypes493 = new String[] { "long", "boolean", "long", "int" };

		_methodName495 = "findAllESFCardsByU_O_S";

		_methodParameterTypes495 = new String[] { "long", "long", "int" };

		_methodName496 = "findAllESFCardsByU_S_Y";

		_methodParameterTypes496 = new String[] { "long", "java.util.Date" };

		_methodName497 = "findAllESFCardsByU_S_Y";

		_methodParameterTypes497 = new String[] {
				"long", "java.util.Date", "int", "int"
			};

		_methodName498 = "findAllESFCardsByU_S";

		_methodParameterTypes498 = new String[] { "long", "int" };

		_methodName499 = "findCardByUser";

		_methodParameterTypes499 = new String[] { "long" };

		_methodName500 = "getAllEsfCardByLikeC";

		_methodParameterTypes500 = new String[] {
				"java.lang.String", "int", "int", "int"
			};

		_methodName501 = "getAllEsfCardByLikeC";

		_methodParameterTypes501 = new String[] { "java.lang.String", "int" };

		_methodName502 = "getEsfCardByCode";

		_methodParameterTypes502 = new String[] { "java.lang.String", "int" };

		_methodName503 = "checkCode";

		_methodParameterTypes503 = new String[] {
				"java.lang.String", "com.liferay.portal.service.ServiceContext"
			};

		_methodName505 = "buildCode";

		_methodParameterTypes505 = new String[] { "java.lang.String", "long" };

		_methodName506 = "findActualUserCards";

		_methodParameterTypes506 = new String[] { "long" };

		_methodName507 = "findShooterByCardActiveInMatch";

		_methodParameterTypes507 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String"
			};

		_methodName508 = "addESFCardOldCode";

		_methodParameterTypes508 = new String[] {
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

		if (_methodName458.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes458, parameterTypes)) {
			return ESFCardLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName459.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes459, parameterTypes)) {
			ESFCardLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName464.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes464, parameterTypes)) {
			return ESFCardLocalServiceUtil.getEsfCardByEsfUserId(((Long)arguments[0]).longValue());
		}

		if (_methodName465.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes465, parameterTypes)) {
			return ESFCardLocalServiceUtil.addESFCard(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				((Long)arguments[3]).longValue(),
				(it.ethica.esf.model.ESFEntityState)arguments[4],
				((Long)arguments[5]).longValue(),
				((Long)arguments[6]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[7]);
		}

		if (_methodName466.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes466, parameterTypes)) {
			return ESFCardLocalServiceUtil.getAllESFCardsByEsfUserId(((Long)arguments[0]).longValue());
		}

		if (_methodName467.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes467, parameterTypes)) {
			return ESFCardLocalServiceUtil.createMultiESFCard(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				(com.liferay.portal.service.ServiceContext)arguments[2]);
		}

		if (_methodName468.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes468, parameterTypes)) {
			return ESFCardLocalServiceUtil.addSelectedCard(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(java.lang.String)arguments[3],
				((Long)arguments[4]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[5]);
		}

		if (_methodName469.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes469, parameterTypes)) {
			return ESFCardLocalServiceUtil.findAllESFCardsChildOrg(((Long)arguments[0]).longValue());
		}

		if (_methodName470.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes470, parameterTypes)) {
			return ESFCardLocalServiceUtil.findAllESFCardsReg_Prov(((Long)arguments[0]).longValue());
		}

		if (_methodName471.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes471, parameterTypes)) {
			return ESFCardLocalServiceUtil.findAllESFCardsReg_ProvFree(((Long)arguments[0]).longValue());
		}

		if (_methodName472.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes472, parameterTypes)) {
			return ESFCardLocalServiceUtil.getAllFreeCard();
		}

		if (_methodName473.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes473, parameterTypes)) {
			return ESFCardLocalServiceUtil.findAllFreeCardInt();
		}

		if (_methodName474.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes474, parameterTypes)) {
			return ESFCardLocalServiceUtil.findAllFreeCards(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName475.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes475, parameterTypes)) {
			return ESFCardLocalServiceUtil.addMultiESFCard(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1],
				((Long)arguments[2]).longValue(),
				(it.ethica.esf.model.ESFEntityState)arguments[3],
				((Long)arguments[4]).longValue(),
				((Long)arguments[5]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[6]);
		}

		if (_methodName476.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes476, parameterTypes)) {
			return ESFCardLocalServiceUtil.deleteESFCard(((Long)arguments[0]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[1]);
		}

		if (_methodName477.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes477, parameterTypes)) {
			ESFCardLocalServiceUtil.deleteESFCard((long[])arguments[0],
				(com.liferay.portal.service.ServiceContext)arguments[1]);

			return null;
		}

		if (_methodName478.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes478, parameterTypes)) {
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

		if (_methodName479.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes479, parameterTypes)) {
			return ESFCardLocalServiceUtil.findAllESFCardsByCode_Organization((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName480.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes480, parameterTypes)) {
			return ESFCardLocalServiceUtil.findAllESFCardsByC_U_O((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue());
		}

		if (_methodName481.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes481, parameterTypes)) {
			return ESFCardLocalServiceUtil.findAllESFCardsByState(((Integer)arguments[0]).intValue());
		}

		if (_methodName482.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes482, parameterTypes)) {
			return ESFCardLocalServiceUtil.findAllESFCardsByState(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName483.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes483, parameterTypes)) {
			return ESFCardLocalServiceUtil.findAllByOrganizationId(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName484.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes484, parameterTypes)) {
			return ESFCardLocalServiceUtil.findAllByOrganizationId(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue());
		}

		if (_methodName485.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes485, parameterTypes)) {
			return ESFCardLocalServiceUtil.findAllESFCardsByOrganizationId(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName486.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes486, parameterTypes)) {
			return ESFCardLocalServiceUtil.findAllESFCardsByOrganizationId(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue());
		}

		if (_methodName487.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes487, parameterTypes)) {
			return ESFCardLocalServiceUtil.findAllESFCardsByRootOrganizationId(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName488.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes488, parameterTypes)) {
			return ESFCardLocalServiceUtil.findAllESFCardsByRootOrganizationId(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName489.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes489, parameterTypes)) {
			return ESFCardLocalServiceUtil.findESFCardByO_C(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName490.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes490, parameterTypes)) {
			return ESFCardLocalServiceUtil.findAllNotAssignedESFCardsByO_S(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName491.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes491, parameterTypes)) {
			return ESFCardLocalServiceUtil.findAllNotAssignedESFCardsByO_S(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue());
		}

		if (_methodName492.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes492, parameterTypes)) {
			return ESFCardLocalServiceUtil.findAllNotAssignedESFCardsByO_U_S(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Boolean)arguments[2]).booleanValue(),
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue());
		}

		if (_methodName493.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes493, parameterTypes)) {
			return ESFCardLocalServiceUtil.findAllNotAssignedESFCardsByO_U_S(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue(),
				((Long)arguments[2]).longValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName495.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes495, parameterTypes)) {
			return ESFCardLocalServiceUtil.findAllESFCardsByU_O_S(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName496.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes496, parameterTypes)) {
			return ESFCardLocalServiceUtil.findAllESFCardsByU_S_Y(((Long)arguments[0]).longValue(),
				(java.util.Date)arguments[1]);
		}

		if (_methodName497.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes497, parameterTypes)) {
			return ESFCardLocalServiceUtil.findAllESFCardsByU_S_Y(((Long)arguments[0]).longValue(),
				(java.util.Date)arguments[1],
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName498.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes498, parameterTypes)) {
			return ESFCardLocalServiceUtil.findAllESFCardsByU_S(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName499.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes499, parameterTypes)) {
			return ESFCardLocalServiceUtil.findCardByUser(((Long)arguments[0]).longValue());
		}

		if (_methodName500.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes500, parameterTypes)) {
			return ESFCardLocalServiceUtil.getAllEsfCardByLikeC((java.lang.String)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName501.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes501, parameterTypes)) {
			return ESFCardLocalServiceUtil.getAllEsfCardByLikeC((java.lang.String)arguments[0],
				((Integer)arguments[1]).intValue());
		}

		if (_methodName502.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes502, parameterTypes)) {
			return ESFCardLocalServiceUtil.getEsfCardByCode((java.lang.String)arguments[0],
				((Integer)arguments[1]).intValue());
		}

		if (_methodName503.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes503, parameterTypes)) {
			return ESFCardLocalServiceUtil.checkCode((java.lang.String)arguments[0],
				(com.liferay.portal.service.ServiceContext)arguments[1]);
		}

		if (_methodName505.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes505, parameterTypes)) {
			return ESFCardLocalServiceUtil.buildCode((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName506.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes506, parameterTypes)) {
			return ESFCardLocalServiceUtil.findActualUserCards(((Long)arguments[0]).longValue());
		}

		if (_methodName507.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes507, parameterTypes)) {
			return ESFCardLocalServiceUtil.findShooterByCardActiveInMatch((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2]);
		}

		if (_methodName508.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes508, parameterTypes)) {
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
	private String _methodName458;
	private String[] _methodParameterTypes458;
	private String _methodName459;
	private String[] _methodParameterTypes459;
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
	private String _methodName477;
	private String[] _methodParameterTypes477;
	private String _methodName478;
	private String[] _methodParameterTypes478;
	private String _methodName479;
	private String[] _methodParameterTypes479;
	private String _methodName480;
	private String[] _methodParameterTypes480;
	private String _methodName481;
	private String[] _methodParameterTypes481;
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
	private String _methodName488;
	private String[] _methodParameterTypes488;
	private String _methodName489;
	private String[] _methodParameterTypes489;
	private String _methodName490;
	private String[] _methodParameterTypes490;
	private String _methodName491;
	private String[] _methodParameterTypes491;
	private String _methodName492;
	private String[] _methodParameterTypes492;
	private String _methodName493;
	private String[] _methodParameterTypes493;
	private String _methodName495;
	private String[] _methodParameterTypes495;
	private String _methodName496;
	private String[] _methodParameterTypes496;
	private String _methodName497;
	private String[] _methodParameterTypes497;
	private String _methodName498;
	private String[] _methodParameterTypes498;
	private String _methodName499;
	private String[] _methodParameterTypes499;
	private String _methodName500;
	private String[] _methodParameterTypes500;
	private String _methodName501;
	private String[] _methodParameterTypes501;
	private String _methodName502;
	private String[] _methodParameterTypes502;
	private String _methodName503;
	private String[] _methodParameterTypes503;
	private String _methodName505;
	private String[] _methodParameterTypes505;
	private String _methodName506;
	private String[] _methodParameterTypes506;
	private String _methodName507;
	private String[] _methodParameterTypes507;
	private String _methodName508;
	private String[] _methodParameterTypes508;
}