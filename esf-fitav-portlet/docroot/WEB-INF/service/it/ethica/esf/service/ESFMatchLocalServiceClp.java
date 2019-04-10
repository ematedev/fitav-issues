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

package it.ethica.esf.service;

import com.liferay.portal.service.InvokableLocalService;

/**
 * @author Ethica
 * @generated
 */
public class ESFMatchLocalServiceClp implements ESFMatchLocalService {
	public ESFMatchLocalServiceClp(InvokableLocalService invokableLocalService) {
		_invokableLocalService = invokableLocalService;

		_methodName0 = "addESFMatch";

		_methodParameterTypes0 = new String[] { "it.ethica.esf.model.ESFMatch" };

		_methodName1 = "createESFMatch";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteESFMatch";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteESFMatch";

		_methodParameterTypes3 = new String[] { "it.ethica.esf.model.ESFMatch" };

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

		_methodName10 = "fetchESFMatch";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "fetchESFMatchByUuidAndCompanyId";

		_methodParameterTypes11 = new String[] { "java.lang.String", "long" };

		_methodName12 = "fetchESFMatchByUuidAndGroupId";

		_methodParameterTypes12 = new String[] { "java.lang.String", "long" };

		_methodName13 = "getESFMatch";

		_methodParameterTypes13 = new String[] { "long" };

		_methodName14 = "getPersistedModel";

		_methodParameterTypes14 = new String[] { "java.io.Serializable" };

		_methodName15 = "getESFMatchByUuidAndCompanyId";

		_methodParameterTypes15 = new String[] { "java.lang.String", "long" };

		_methodName16 = "getESFMatchByUuidAndGroupId";

		_methodParameterTypes16 = new String[] { "java.lang.String", "long" };

		_methodName17 = "getESFMatchs";

		_methodParameterTypes17 = new String[] { "int", "int" };

		_methodName18 = "getESFMatchsCount";

		_methodParameterTypes18 = new String[] {  };

		_methodName19 = "updateESFMatch";

		_methodParameterTypes19 = new String[] { "it.ethica.esf.model.ESFMatch" };

		_methodName20 = "getBeanIdentifier";

		_methodParameterTypes20 = new String[] {  };

		_methodName21 = "setBeanIdentifier";

		_methodParameterTypes21 = new String[] { "java.lang.String" };

		_methodName23 = "findESFMatchesByYearIsNational";

		_methodParameterTypes23 = new String[] { "int", "boolean" };

		_methodName24 = "findESFMatchsByStateIsNational_C_S_M_C_O";

		_methodParameterTypes24 = new String[] {
				"int", "boolean", "java.lang.String", "java.util.Date", "long",
				"long", "java.lang.String"
			};

		_methodName25 = "findESFMatchsByStateIsNational_C_S_M_C_O";

		_methodParameterTypes25 = new String[] {
				"int", "boolean", "java.lang.String", "java.util.Date", "long",
				"long", "java.lang.String", "int", "int"
			};

		_methodName26 = "findESFMatchsByStateIsNational_C_S_M_C_A";

		_methodParameterTypes26 = new String[] {
				"int", "boolean", "java.lang.String", "java.util.Date", "long",
				"long"
			};

		_methodName27 = "findESFMatchsByStateIsNational_C_S_M_C_A";

		_methodParameterTypes27 = new String[] {
				"int", "boolean", "java.lang.String", "java.util.Date", "long",
				"long", "int", "int"
			};

		_methodName28 = "findESFMatchsByStateIsNational_C_S_M_C_I";

		_methodParameterTypes28 = new String[] {
				"int", "boolean", "java.lang.String", "java.util.Date", "long",
				"long"
			};

		_methodName29 = "findESFMatchsByStateIsNational_C_S_M_C_I";

		_methodParameterTypes29 = new String[] {
				"int", "boolean", "java.lang.String", "java.util.Date", "long",
				"long", "int", "int"
			};

		_methodName30 = "findESFMatchsByStateIsNational";

		_methodParameterTypes30 = new String[] { "int", "boolean" };

		_methodName31 = "findESFMatchsByStateIsNational";

		_methodParameterTypes31 = new String[] { "int", "boolean", "int", "int" };

		_methodName32 = "findESFMatchsByO_S_N";

		_methodParameterTypes32 = new String[] {
				"long", "int", "boolean", "int", "int"
			};

		_methodName33 = "findbyIsChangeCategoryYear";

		_methodParameterTypes33 = new String[] { "boolean", "long", "int" };

		_methodName34 = "findbyIsChangeCategoryYearDescription";

		_methodParameterTypes34 = new String[] {
				"boolean", "long", "int", "java.lang.Long"
			};

		_methodName35 = "getESFMatchesByMatchStartDate_T_A_D_N";

		_methodParameterTypes35 = new String[] {
				"java.util.Date", "long", "long", "long", "boolean"
			};

		_methodName36 = "findMyMatches";

		_methodParameterTypes36 = new String[] {
				"long", "boolean", "long", "java.util.Date", "long", "long"
			};

		_methodName37 = "findByUI_iN_OI_sD_dId_STId";

		_methodParameterTypes37 = new String[] {
				"long", "boolean", "long", "java.util.Date", "long", "long",
				"int", "int"
			};

		_methodName38 = "findESFMatchsByO_S_N";

		_methodParameterTypes38 = new String[] { "long", "int", "boolean" };

		_methodName39 = "findbyUserId_IsNational";

		_methodParameterTypes39 = new String[] { "long", "boolean" };

		_methodName40 = "findbyIsChangeCategory";

		_methodParameterTypes40 = new String[] { "boolean", "long" };

		_methodName41 = "findbyUserId_IsNational";

		_methodParameterTypes41 = new String[] { "long", "boolean", "int", "int" };

		_methodName42 = "findbyMatchType";

		_methodParameterTypes42 = new String[] { "long" };

		_methodName43 = "addOrUpdateESFMatch";

		_methodParameterTypes43 = new String[] {
				"long", "long", "long", "java.lang.String", "java.util.Date",
				"java.util.Date", "java.lang.String", "long", "java.lang.String",
				"boolean", "int", "long", "int", "int", "boolean", "boolean",
				"boolean", "long", "boolean", "long[][]", "long[][]", "long",
				"java.lang.String", "boolean",
				"it.ethica.esf.model.ESFEntityState",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName44 = "addOrUpdateESFMatch";

		_methodParameterTypes44 = new String[] {
				"long", "long", "long", "java.lang.String", "java.util.Date",
				"java.util.Date", "java.lang.String", "long", "java.lang.String",
				"boolean", "int", "long", "int", "int", "boolean", "boolean",
				"boolean", "long", "boolean", "long[][]", "long[][]", "long",
				"java.lang.String", "boolean", "boolean",
				"it.ethica.esf.model.ESFEntityState",
				"com.liferay.portal.service.ServiceContext", "java.lang.String",
				"java.lang.String", "java.lang.String"
			};

		_methodName45 = "addOrUpdateESFMatch";

		_methodParameterTypes45 = new String[] {
				"long", "long", "long", "java.lang.String", "java.util.Date",
				"java.util.Date", "java.lang.String", "long", "java.lang.String",
				"boolean", "int", "long", "int", "int", "boolean", "boolean",
				"boolean", "long", "boolean", "long[][]", "long[][]", "long",
				"java.lang.String", "boolean", "boolean",
				"it.ethica.esf.model.ESFEntityState",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName46 = "deleteESFMatch";

		_methodParameterTypes46 = new String[] {
				"long", "com.liferay.portal.service.ServiceContext"
			};

		_methodName47 = "findbyeventType";

		_methodParameterTypes47 = new String[] { "java.lang.String" };

		_methodName48 = "findByDescription";

		_methodParameterTypes48 = new String[] { "long" };

		_methodName49 = "findDelegationActiveMatch";

		_methodParameterTypes49 = new String[] { "long" };

		_methodName50 = "findUnfinishedMatch_UserId";

		_methodParameterTypes50 = new String[] { "long" };

		_methodName51 = "getAllEsfMatchByResults";

		_methodParameterTypes51 = new String[] { "java.util.List" };

		_methodName52 = "addOrUpdateOldESFMatch";

		_methodParameterTypes52 = new String[] {
				"long", "long", "long", "java.lang.String", "java.util.Date",
				"java.util.Date", "java.lang.String", "long", "java.lang.String",
				"boolean", "int", "long", "int", "int", "boolean", "boolean",
				"boolean", "long", "boolean", "long[][]", "long[][]", "long",
				"java.lang.String", "boolean",
				"it.ethica.esf.model.ESFEntityState",
				"com.liferay.portal.service.ServiceContext", "java.lang.String"
			};

		_methodName53 = "findMatchToDispute";

		_methodParameterTypes53 = new String[] {
				"java.lang.String", "boolean", "int", "int"
			};

		_methodName54 = "countMatchToDispute";

		_methodParameterTypes54 = new String[] { "java.lang.String", "boolean" };
	}

	@Override
	public it.ethica.esf.model.ESFMatch addESFMatch(
		it.ethica.esf.model.ESFMatch esfMatch)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName0,
					_methodParameterTypes0,
					new Object[] { ClpSerializer.translateInput(esfMatch) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (it.ethica.esf.model.ESFMatch)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public it.ethica.esf.model.ESFMatch createESFMatch(long esfMatchId) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName1,
					_methodParameterTypes1, new Object[] { esfMatchId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (it.ethica.esf.model.ESFMatch)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public it.ethica.esf.model.ESFMatch deleteESFMatch(long esfMatchId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName2,
					_methodParameterTypes2, new Object[] { esfMatchId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (it.ethica.esf.model.ESFMatch)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public it.ethica.esf.model.ESFMatch deleteESFMatch(
		it.ethica.esf.model.ESFMatch esfMatch)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName3,
					_methodParameterTypes3,
					new Object[] { ClpSerializer.translateInput(esfMatch) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (it.ethica.esf.model.ESFMatch)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName4,
					_methodParameterTypes4, new Object[] {  });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.liferay.portal.kernel.dao.orm.DynamicQuery)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName5,
					_methodParameterTypes5,
					new Object[] { ClpSerializer.translateInput(dynamicQuery) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName6,
					_methodParameterTypes6,
					new Object[] {
						ClpSerializer.translateInput(dynamicQuery),
						
					start,
						
					end
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName7,
					_methodParameterTypes7,
					new Object[] {
						ClpSerializer.translateInput(dynamicQuery),
						
					start,
						
					end,
						
					ClpSerializer.translateInput(orderByComparator)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName8,
					_methodParameterTypes8,
					new Object[] { ClpSerializer.translateInput(dynamicQuery) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Long)returnObj).longValue();
	}

	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName9,
					_methodParameterTypes9,
					new Object[] {
						ClpSerializer.translateInput(dynamicQuery),
						
					ClpSerializer.translateInput(projection)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Long)returnObj).longValue();
	}

	@Override
	public it.ethica.esf.model.ESFMatch fetchESFMatch(long esfMatchId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName10,
					_methodParameterTypes10, new Object[] { esfMatchId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (it.ethica.esf.model.ESFMatch)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public it.ethica.esf.model.ESFMatch fetchESFMatchByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName11,
					_methodParameterTypes11,
					new Object[] { ClpSerializer.translateInput(uuid), companyId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (it.ethica.esf.model.ESFMatch)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public it.ethica.esf.model.ESFMatch fetchESFMatchByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName12,
					_methodParameterTypes12,
					new Object[] { ClpSerializer.translateInput(uuid), groupId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (it.ethica.esf.model.ESFMatch)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public it.ethica.esf.model.ESFMatch getESFMatch(long esfMatchId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName13,
					_methodParameterTypes13, new Object[] { esfMatchId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (it.ethica.esf.model.ESFMatch)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName14,
					_methodParameterTypes14,
					new Object[] { ClpSerializer.translateInput(primaryKeyObj) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.liferay.portal.model.PersistedModel)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public it.ethica.esf.model.ESFMatch getESFMatchByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName15,
					_methodParameterTypes15,
					new Object[] { ClpSerializer.translateInput(uuid), companyId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (it.ethica.esf.model.ESFMatch)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public it.ethica.esf.model.ESFMatch getESFMatchByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName16,
					_methodParameterTypes16,
					new Object[] { ClpSerializer.translateInput(uuid), groupId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (it.ethica.esf.model.ESFMatch)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFMatch> getESFMatchs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName17,
					_methodParameterTypes17, new Object[] { start, end });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<it.ethica.esf.model.ESFMatch>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public int getESFMatchsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName18,
					_methodParameterTypes18, new Object[] {  });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	@Override
	public it.ethica.esf.model.ESFMatch updateESFMatch(
		it.ethica.esf.model.ESFMatch esfMatch)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName19,
					_methodParameterTypes19,
					new Object[] { ClpSerializer.translateInput(esfMatch) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (it.ethica.esf.model.ESFMatch)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.String getBeanIdentifier() {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName20,
					_methodParameterTypes20, new Object[] {  });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		try {
			_invokableLocalService.invokeMethod(_methodName21,
				_methodParameterTypes21,
				new Object[] { ClpSerializer.translateInput(beanIdentifier) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		throw new UnsupportedOperationException();
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFMatch> findESFMatchesByYearIsNational(
		int year, boolean isNational) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName23,
					_methodParameterTypes23, new Object[] { year, isNational });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<it.ethica.esf.model.ESFMatch>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFMatch> findESFMatchsByStateIsNational_C_S_M_C_O(
		int state, boolean isNational, java.lang.String code,
		java.util.Date startDate, long esfMatchType, long country,
		java.lang.String eventType) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName24,
					_methodParameterTypes24,
					new Object[] {
						state,
						
					isNational,
						
					ClpSerializer.translateInput(code),
						
					ClpSerializer.translateInput(startDate),
						
					esfMatchType,
						
					country,
						
					ClpSerializer.translateInput(eventType)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<it.ethica.esf.model.ESFMatch>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFMatch> findESFMatchsByStateIsNational_C_S_M_C_O(
		int state, boolean isNational, java.lang.String code,
		java.util.Date startDate, long esfMatchType, long country,
		java.lang.String eventType, int start, int end) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName25,
					_methodParameterTypes25,
					new Object[] {
						state,
						
					isNational,
						
					ClpSerializer.translateInput(code),
						
					ClpSerializer.translateInput(startDate),
						
					esfMatchType,
						
					country,
						
					ClpSerializer.translateInput(eventType),
						
					start,
						
					end
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<it.ethica.esf.model.ESFMatch>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFMatch> findESFMatchsByStateIsNational_C_S_M_C_A(
		int state, boolean isNational, java.lang.String code,
		java.util.Date startDate, long esfMatchType, long assotiationName) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName26,
					_methodParameterTypes26,
					new Object[] {
						state,
						
					isNational,
						
					ClpSerializer.translateInput(code),
						
					ClpSerializer.translateInput(startDate),
						
					esfMatchType,
						
					assotiationName
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<it.ethica.esf.model.ESFMatch>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFMatch> findESFMatchsByStateIsNational_C_S_M_C_A(
		int state, boolean isNational, java.lang.String code,
		java.util.Date startDate, long esfMatchType, long assotiationName,
		int start, int end) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName27,
					_methodParameterTypes27,
					new Object[] {
						state,
						
					isNational,
						
					ClpSerializer.translateInput(code),
						
					ClpSerializer.translateInput(startDate),
						
					esfMatchType,
						
					assotiationName,
						
					start,
						
					end
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<it.ethica.esf.model.ESFMatch>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFMatch> findESFMatchsByStateIsNational_C_S_M_C_I(
		int state, boolean isNational, java.lang.String code,
		java.util.Date startDate, long esfMatchType, long assotiationId) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName28,
					_methodParameterTypes28,
					new Object[] {
						state,
						
					isNational,
						
					ClpSerializer.translateInput(code),
						
					ClpSerializer.translateInput(startDate),
						
					esfMatchType,
						
					assotiationId
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<it.ethica.esf.model.ESFMatch>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFMatch> findESFMatchsByStateIsNational_C_S_M_C_I(
		int state, boolean isNational, java.lang.String code,
		java.util.Date startDate, long esfMatchType, long assotiationId,
		int start, int end) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName29,
					_methodParameterTypes29,
					new Object[] {
						state,
						
					isNational,
						
					ClpSerializer.translateInput(code),
						
					ClpSerializer.translateInput(startDate),
						
					esfMatchType,
						
					assotiationId,
						
					start,
						
					end
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<it.ethica.esf.model.ESFMatch>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFMatch> findESFMatchsByStateIsNational(
		int state, boolean isNational) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName30,
					_methodParameterTypes30, new Object[] { state, isNational });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<it.ethica.esf.model.ESFMatch>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFMatch> findESFMatchsByStateIsNational(
		int state, boolean isNational, int start, int end) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName31,
					_methodParameterTypes31,
					new Object[] { state, isNational, start, end });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<it.ethica.esf.model.ESFMatch>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFMatch> findESFMatchsByO_S_N(
		long esfOrganizationId, int state, boolean isNational, int start,
		int end) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName32,
					_methodParameterTypes32,
					new Object[] {
						esfOrganizationId,
						
					state,
						
					isNational,
						
					start,
						
					end
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<it.ethica.esf.model.ESFMatch>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFMatch> findbyIsChangeCategoryYear(
		boolean IsChangeCategory, long sportType, int year)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName33,
					_methodParameterTypes33,
					new Object[] { IsChangeCategory, sportType, year });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<it.ethica.esf.model.ESFMatch>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFMatch> findbyIsChangeCategoryYearDescription(
		boolean IsChangeCategory, long sportType, int year,
		java.lang.Long description)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName34,
					_methodParameterTypes34,
					new Object[] {
						IsChangeCategory,
						
					sportType,
						
					year,
						
					ClpSerializer.translateInput(description)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<it.ethica.esf.model.ESFMatch>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFMatch> getESFMatchesByMatchStartDate_T_A_D_N(
		java.util.Date startDate, long matchType, long associationId,
		long descriptionId, boolean isNational) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName35,
					_methodParameterTypes35,
					new Object[] {
						ClpSerializer.translateInput(startDate),
						
					matchType,
						
					associationId,
						
					descriptionId,
						
					isNational
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<it.ethica.esf.model.ESFMatch>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFMatch> findMyMatches(
		long userId, boolean isNational, long organizationId,
		java.util.Date startDate, long descriptionId, long SportTypeId)
		throws java.lang.Exception {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName36,
					_methodParameterTypes36,
					new Object[] {
						userId,
						
					isNational,
						
					organizationId,
						
					ClpSerializer.translateInput(startDate),
						
					descriptionId,
						
					SportTypeId
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof java.lang.Exception) {
				throw (java.lang.Exception)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<it.ethica.esf.model.ESFMatch>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFMatch> findByUI_iN_OI_sD_dId_STId(
		long userId, boolean isNational, long organizationId,
		java.util.Date startDate, long descriptionId, long SportTypeId,
		int start, int end) throws java.lang.Exception {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName37,
					_methodParameterTypes37,
					new Object[] {
						userId,
						
					isNational,
						
					organizationId,
						
					ClpSerializer.translateInput(startDate),
						
					descriptionId,
						
					SportTypeId,
						
					start,
						
					end
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof java.lang.Exception) {
				throw (java.lang.Exception)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<it.ethica.esf.model.ESFMatch>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFMatch> findESFMatchsByO_S_N(
		long esfOrganizationId, int state, boolean isNational) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName38,
					_methodParameterTypes38,
					new Object[] { esfOrganizationId, state, isNational });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<it.ethica.esf.model.ESFMatch>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFMatch> findbyUserId_IsNational(
		long userId, boolean isNational)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName39,
					_methodParameterTypes39, new Object[] { userId, isNational });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<it.ethica.esf.model.ESFMatch>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFMatch> findbyIsChangeCategory(
		boolean IsChangeCategory, long sportType)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName40,
					_methodParameterTypes40,
					new Object[] { IsChangeCategory, sportType });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<it.ethica.esf.model.ESFMatch>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFMatch> findbyUserId_IsNational(
		long userId, boolean isNational, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName41,
					_methodParameterTypes41,
					new Object[] { userId, isNational, start, end });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<it.ethica.esf.model.ESFMatch>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFMatch> findbyMatchType(
		long esfMatchTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName42,
					_methodParameterTypes42, new Object[] { esfMatchTypeId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<it.ethica.esf.model.ESFMatch>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public it.ethica.esf.model.ESFMatch addOrUpdateESFMatch(long userId,
		long esfMatchId, long esfAssociationId, java.lang.String code,
		java.util.Date startDate, java.util.Date endDate,
		java.lang.String startHour, long description, java.lang.String note,
		boolean isDraft, int numFields, long esfSportTypeId, int numDisk,
		int numDiskTeam, boolean isIndividualMatch, boolean isTeamMatch,
		boolean isJuniorMatch, long esfMatchTypeId,
		boolean isChangeCategoryMatch, long[] esfShooterCategoryIds,
		long[] esfShooterQualificationIds, long esfCountryId,
		java.lang.String site, boolean isNational,
		it.ethica.esf.model.ESFEntityState esfEntityState,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName43,
					_methodParameterTypes43,
					new Object[] {
						userId,
						
					esfMatchId,
						
					esfAssociationId,
						
					ClpSerializer.translateInput(code),
						
					ClpSerializer.translateInput(startDate),
						
					ClpSerializer.translateInput(endDate),
						
					ClpSerializer.translateInput(startHour),
						
					description,
						
					ClpSerializer.translateInput(note),
						
					isDraft,
						
					numFields,
						
					esfSportTypeId,
						
					numDisk,
						
					numDiskTeam,
						
					isIndividualMatch,
						
					isTeamMatch,
						
					isJuniorMatch,
						
					esfMatchTypeId,
						
					isChangeCategoryMatch,
						
					ClpSerializer.translateInput(esfShooterCategoryIds),
						
					ClpSerializer.translateInput(esfShooterQualificationIds),
						
					esfCountryId,
						
					ClpSerializer.translateInput(site),
						
					isNational,
						
					ClpSerializer.translateInput(esfEntityState),
						
					ClpSerializer.translateInput(serviceContext)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (it.ethica.esf.model.ESFMatch)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public it.ethica.esf.model.ESFMatch addOrUpdateESFMatch(long userId,
		long esfMatchId, long esfAssociationId, java.lang.String code,
		java.util.Date startDate, java.util.Date endDate,
		java.lang.String startHour, long description, java.lang.String note,
		boolean isDraft, int numFields, long esfSportTypeId, int numDisk,
		int numDiskTeam, boolean isIndividualMatch, boolean isTeamMatch,
		boolean isJuniorMatch, long esfMatchTypeId,
		boolean isChangeCategoryMatch, long[] esfShooterCategoryIds,
		long[] esfShooterQualificationIds, long esfCountryId,
		java.lang.String site, boolean isNational,
		boolean isOlimpicQualificationMatch,
		it.ethica.esf.model.ESFEntityState esfEntityState,
		com.liferay.portal.service.ServiceContext serviceContext,
		java.lang.String notNationalAssotiation, java.lang.String eventType,
		java.lang.String esfNationalSportTypeidString)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName44,
					_methodParameterTypes44,
					new Object[] {
						userId,
						
					esfMatchId,
						
					esfAssociationId,
						
					ClpSerializer.translateInput(code),
						
					ClpSerializer.translateInput(startDate),
						
					ClpSerializer.translateInput(endDate),
						
					ClpSerializer.translateInput(startHour),
						
					description,
						
					ClpSerializer.translateInput(note),
						
					isDraft,
						
					numFields,
						
					esfSportTypeId,
						
					numDisk,
						
					numDiskTeam,
						
					isIndividualMatch,
						
					isTeamMatch,
						
					isJuniorMatch,
						
					esfMatchTypeId,
						
					isChangeCategoryMatch,
						
					ClpSerializer.translateInput(esfShooterCategoryIds),
						
					ClpSerializer.translateInput(esfShooterQualificationIds),
						
					esfCountryId,
						
					ClpSerializer.translateInput(site),
						
					isNational,
						
					isOlimpicQualificationMatch,
						
					ClpSerializer.translateInput(esfEntityState),
						
					ClpSerializer.translateInput(serviceContext),
						
					ClpSerializer.translateInput(notNationalAssotiation),
						
					ClpSerializer.translateInput(eventType),
						
					ClpSerializer.translateInput(esfNationalSportTypeidString)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (it.ethica.esf.model.ESFMatch)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public it.ethica.esf.model.ESFMatch addOrUpdateESFMatch(long userId,
		long esfMatchId, long esfAssociationId, java.lang.String code,
		java.util.Date startDate, java.util.Date endDate,
		java.lang.String startHour, long description, java.lang.String note,
		boolean isDraft, int numFields, long esfSportTypeId, int numDisk,
		int numDiskTeam, boolean isIndividualMatch, boolean isTeamMatch,
		boolean isJuniorMatch, long esfMatchTypeId,
		boolean isChangeCategoryMatch, long[] esfShooterCategoryIds,
		long[] esfShooterQualificationIds, long esfCountryId,
		java.lang.String site, boolean isNational,
		boolean isOlimpicQualificationMatch,
		it.ethica.esf.model.ESFEntityState esfEntityState,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName45,
					_methodParameterTypes45,
					new Object[] {
						userId,
						
					esfMatchId,
						
					esfAssociationId,
						
					ClpSerializer.translateInput(code),
						
					ClpSerializer.translateInput(startDate),
						
					ClpSerializer.translateInput(endDate),
						
					ClpSerializer.translateInput(startHour),
						
					description,
						
					ClpSerializer.translateInput(note),
						
					isDraft,
						
					numFields,
						
					esfSportTypeId,
						
					numDisk,
						
					numDiskTeam,
						
					isIndividualMatch,
						
					isTeamMatch,
						
					isJuniorMatch,
						
					esfMatchTypeId,
						
					isChangeCategoryMatch,
						
					ClpSerializer.translateInput(esfShooterCategoryIds),
						
					ClpSerializer.translateInput(esfShooterQualificationIds),
						
					esfCountryId,
						
					ClpSerializer.translateInput(site),
						
					isNational,
						
					isOlimpicQualificationMatch,
						
					ClpSerializer.translateInput(esfEntityState),
						
					ClpSerializer.translateInput(serviceContext)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (it.ethica.esf.model.ESFMatch)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public it.ethica.esf.model.ESFMatch deleteESFMatch(long esfMatchId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName46,
					_methodParameterTypes46,
					new Object[] {
						esfMatchId,
						
					ClpSerializer.translateInput(serviceContext)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (it.ethica.esf.model.ESFMatch)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFMatch> findbyeventType(
		java.lang.String eventType)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName47,
					_methodParameterTypes47,
					new Object[] { ClpSerializer.translateInput(eventType) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<it.ethica.esf.model.ESFMatch>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFMatch> findByDescription(
		long description)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName48,
					_methodParameterTypes48, new Object[] { description });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<it.ethica.esf.model.ESFMatch>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFMatch> findDelegationActiveMatch(
		long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName49,
					_methodParameterTypes49, new Object[] { esfUserId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<it.ethica.esf.model.ESFMatch>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFMatch> findUnfinishedMatch_UserId(
		long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName50,
					_methodParameterTypes50, new Object[] { esfUserId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<it.ethica.esf.model.ESFMatch>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFMatch> getAllEsfMatchByResults(
		java.util.List<it.ethica.esf.model.ESFNationalMatchResult> results)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName51,
					_methodParameterTypes51,
					new Object[] { ClpSerializer.translateInput(results) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<it.ethica.esf.model.ESFMatch>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public it.ethica.esf.model.ESFMatch addOrUpdateOldESFMatch(long userId,
		long esfMatchId, long esfAssociationId, java.lang.String code,
		java.util.Date startDate, java.util.Date endDate,
		java.lang.String startHour, long description, java.lang.String note,
		boolean isDraft, int numFields, long esfSportTypeId, int numDisk,
		int numDiskTeam, boolean isIndividualMatch, boolean isTeamMatch,
		boolean isJuniorMatch, long esfMatchTypeId,
		boolean isChangeCategoryMatch, long[] esfShooterCategoryIds,
		long[] esfShooterQualificationIds, long esfCountryId,
		java.lang.String site, boolean isNational,
		it.ethica.esf.model.ESFEntityState esfEntityState,
		com.liferay.portal.service.ServiceContext serviceContext,
		java.lang.String oldCode)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName52,
					_methodParameterTypes52,
					new Object[] {
						userId,
						
					esfMatchId,
						
					esfAssociationId,
						
					ClpSerializer.translateInput(code),
						
					ClpSerializer.translateInput(startDate),
						
					ClpSerializer.translateInput(endDate),
						
					ClpSerializer.translateInput(startHour),
						
					description,
						
					ClpSerializer.translateInput(note),
						
					isDraft,
						
					numFields,
						
					esfSportTypeId,
						
					numDisk,
						
					numDiskTeam,
						
					isIndividualMatch,
						
					isTeamMatch,
						
					isJuniorMatch,
						
					esfMatchTypeId,
						
					isChangeCategoryMatch,
						
					ClpSerializer.translateInput(esfShooterCategoryIds),
						
					ClpSerializer.translateInput(esfShooterQualificationIds),
						
					esfCountryId,
						
					ClpSerializer.translateInput(site),
						
					isNational,
						
					ClpSerializer.translateInput(esfEntityState),
						
					ClpSerializer.translateInput(serviceContext),
						
					ClpSerializer.translateInput(oldCode)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (it.ethica.esf.model.ESFMatch)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFMatch> findMatchToDispute(
		java.lang.String code, boolean isnational, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName53,
					_methodParameterTypes53,
					new Object[] {
						ClpSerializer.translateInput(code),
						
					isnational,
						
					start,
						
					end
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<it.ethica.esf.model.ESFMatch>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public int countMatchToDispute(java.lang.String code, boolean isnational)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName54,
					_methodParameterTypes54,
					new Object[] { ClpSerializer.translateInput(code), isnational });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	private InvokableLocalService _invokableLocalService;
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
	private String _methodName20;
	private String[] _methodParameterTypes20;
	private String _methodName21;
	private String[] _methodParameterTypes21;
	private String _methodName23;
	private String[] _methodParameterTypes23;
	private String _methodName24;
	private String[] _methodParameterTypes24;
	private String _methodName25;
	private String[] _methodParameterTypes25;
	private String _methodName26;
	private String[] _methodParameterTypes26;
	private String _methodName27;
	private String[] _methodParameterTypes27;
	private String _methodName28;
	private String[] _methodParameterTypes28;
	private String _methodName29;
	private String[] _methodParameterTypes29;
	private String _methodName30;
	private String[] _methodParameterTypes30;
	private String _methodName31;
	private String[] _methodParameterTypes31;
	private String _methodName32;
	private String[] _methodParameterTypes32;
	private String _methodName33;
	private String[] _methodParameterTypes33;
	private String _methodName34;
	private String[] _methodParameterTypes34;
	private String _methodName35;
	private String[] _methodParameterTypes35;
	private String _methodName36;
	private String[] _methodParameterTypes36;
	private String _methodName37;
	private String[] _methodParameterTypes37;
	private String _methodName38;
	private String[] _methodParameterTypes38;
	private String _methodName39;
	private String[] _methodParameterTypes39;
	private String _methodName40;
	private String[] _methodParameterTypes40;
	private String _methodName41;
	private String[] _methodParameterTypes41;
	private String _methodName42;
	private String[] _methodParameterTypes42;
	private String _methodName43;
	private String[] _methodParameterTypes43;
	private String _methodName44;
	private String[] _methodParameterTypes44;
	private String _methodName45;
	private String[] _methodParameterTypes45;
	private String _methodName46;
	private String[] _methodParameterTypes46;
	private String _methodName47;
	private String[] _methodParameterTypes47;
	private String _methodName48;
	private String[] _methodParameterTypes48;
	private String _methodName49;
	private String[] _methodParameterTypes49;
	private String _methodName50;
	private String[] _methodParameterTypes50;
	private String _methodName51;
	private String[] _methodParameterTypes51;
	private String _methodName52;
	private String[] _methodParameterTypes52;
	private String _methodName53;
	private String[] _methodParameterTypes53;
	private String _methodName54;
	private String[] _methodParameterTypes54;
}