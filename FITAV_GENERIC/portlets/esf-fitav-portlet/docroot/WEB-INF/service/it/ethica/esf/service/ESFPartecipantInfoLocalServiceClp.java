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

package it.ethica.esf.service;

import com.liferay.portal.service.InvokableLocalService;

/**
 * @author Ethica
 * @generated
 */
public class ESFPartecipantInfoLocalServiceClp
	implements ESFPartecipantInfoLocalService {
	public ESFPartecipantInfoLocalServiceClp(
		InvokableLocalService invokableLocalService) {
		_invokableLocalService = invokableLocalService;

		_methodName0 = "addESFPartecipantInfo";

		_methodParameterTypes0 = new String[] {
				"it.ethica.esf.model.ESFPartecipantInfo"
			};

		_methodName1 = "createESFPartecipantInfo";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteESFPartecipantInfo";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteESFPartecipantInfo";

		_methodParameterTypes3 = new String[] {
				"it.ethica.esf.model.ESFPartecipantInfo"
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

		_methodName10 = "fetchESFPartecipantInfo";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getESFPartecipantInfo";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getESFPartecipantInfos";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getESFPartecipantInfosCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateESFPartecipantInfo";

		_methodParameterTypes15 = new String[] {
				"it.ethica.esf.model.ESFPartecipantInfo"
			};

		_methodName16 = "getBeanIdentifier";

		_methodParameterTypes16 = new String[] {  };

		_methodName17 = "setBeanIdentifier";

		_methodParameterTypes17 = new String[] { "java.lang.String" };

		_methodName19 = "getESFPartecipantInfosByFirstName_L_P";

		_methodParameterTypes19 = new String[] {
				"java.lang.String", "java.lang.String", "long"
			};

		_methodName20 = "getESFPartecipantInfosByFirstName_L_P";

		_methodParameterTypes20 = new String[] {
				"java.lang.String", "java.lang.String", "long", "int", "int"
			};

		_methodName21 = "updateESFPartecipantInfo";

		_methodParameterTypes21 = new String[] {
				"long", "long", "long", "long", "java.lang.String", "boolean",
				"long", "long", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.util.Date", "java.lang.String",
				"java.lang.String", "int", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.util.Date", "java.util.Date", "java.lang.String",
				"java.util.Date", "java.util.Date", "java.lang.String",
				"java.util.Date", "java.util.Date", "java.lang.String",
				"java.lang.String", "java.lang.String", "double",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "double", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"long", "long", "long", "long", "long"
			};

		_methodName22 = "addESFPartecipantInfo";

		_methodParameterTypes22 = new String[] {
				"long", "long", "long", "java.lang.String", "java.util.Date",
				"boolean", "long", "long", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.util.Date",
				"java.lang.String", "java.lang.String", "int",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.util.Date", "java.util.Date",
				"java.lang.String", "java.util.Date", "java.util.Date",
				"java.lang.String", "java.util.Date", "java.util.Date",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"double", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "double",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "long", "long", "long", "long", "long"
			};

		_methodName23 = "addESFPartecipantInfoAndReturnId";

		_methodParameterTypes23 = new String[] {
				"long", "long", "long", "java.lang.String", "java.util.Date",
				"boolean", "long", "long", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.util.Date",
				"java.lang.String", "java.lang.String", "int",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.util.Date", "java.util.Date",
				"java.lang.String", "java.util.Date", "java.util.Date",
				"java.lang.String", "java.util.Date", "java.util.Date",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"double", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "double",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "long", "long", "long", "long", "long"
			};
	}

	@Override
	public it.ethica.esf.model.ESFPartecipantInfo addESFPartecipantInfo(
		it.ethica.esf.model.ESFPartecipantInfo esfPartecipantInfo)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName0,
					_methodParameterTypes0,
					new Object[] {
						ClpSerializer.translateInput(esfPartecipantInfo)
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

		return (it.ethica.esf.model.ESFPartecipantInfo)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public it.ethica.esf.model.ESFPartecipantInfo createESFPartecipantInfo(
		long esfPartecipantInfoId) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName1,
					_methodParameterTypes1,
					new Object[] { esfPartecipantInfoId });
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

		return (it.ethica.esf.model.ESFPartecipantInfo)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public it.ethica.esf.model.ESFPartecipantInfo deleteESFPartecipantInfo(
		long esfPartecipantInfoId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName2,
					_methodParameterTypes2,
					new Object[] { esfPartecipantInfoId });
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

		return (it.ethica.esf.model.ESFPartecipantInfo)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public it.ethica.esf.model.ESFPartecipantInfo deleteESFPartecipantInfo(
		it.ethica.esf.model.ESFPartecipantInfo esfPartecipantInfo)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName3,
					_methodParameterTypes3,
					new Object[] {
						ClpSerializer.translateInput(esfPartecipantInfo)
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

		return (it.ethica.esf.model.ESFPartecipantInfo)ClpSerializer.translateOutput(returnObj);
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
	public it.ethica.esf.model.ESFPartecipantInfo fetchESFPartecipantInfo(
		long esfPartecipantInfoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName10,
					_methodParameterTypes10,
					new Object[] { esfPartecipantInfoId });
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

		return (it.ethica.esf.model.ESFPartecipantInfo)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public it.ethica.esf.model.ESFPartecipantInfo getESFPartecipantInfo(
		long esfPartecipantInfoId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName11,
					_methodParameterTypes11,
					new Object[] { esfPartecipantInfoId });
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

		return (it.ethica.esf.model.ESFPartecipantInfo)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName12,
					_methodParameterTypes12,
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
	public java.util.List<it.ethica.esf.model.ESFPartecipantInfo> getESFPartecipantInfos(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName13,
					_methodParameterTypes13, new Object[] { start, end });
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

		return (java.util.List<it.ethica.esf.model.ESFPartecipantInfo>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public int getESFPartecipantInfosCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName14,
					_methodParameterTypes14, new Object[] {  });
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
	public it.ethica.esf.model.ESFPartecipantInfo updateESFPartecipantInfo(
		it.ethica.esf.model.ESFPartecipantInfo esfPartecipantInfo)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName15,
					_methodParameterTypes15,
					new Object[] {
						ClpSerializer.translateInput(esfPartecipantInfo)
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

		return (it.ethica.esf.model.ESFPartecipantInfo)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.String getBeanIdentifier() {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName16,
					_methodParameterTypes16, new Object[] {  });
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
			_invokableLocalService.invokeMethod(_methodName17,
				_methodParameterTypes17,
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
	public java.util.List<it.ethica.esf.model.ESFPartecipantInfo> getESFPartecipantInfosByFirstName_L_P(
		java.lang.String firstName, java.lang.String lastName, long protocol) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName19,
					_methodParameterTypes19,
					new Object[] {
						ClpSerializer.translateInput(firstName),
						
					ClpSerializer.translateInput(lastName),
						
					protocol
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

		return (java.util.List<it.ethica.esf.model.ESFPartecipantInfo>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFPartecipantInfo> getESFPartecipantInfosByFirstName_L_P(
		java.lang.String firstName, java.lang.String lastName, long protocol,
		int start, int end) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName20,
					_methodParameterTypes20,
					new Object[] {
						ClpSerializer.translateInput(firstName),
						
					ClpSerializer.translateInput(lastName),
						
					protocol,
						
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

		return (java.util.List<it.ethica.esf.model.ESFPartecipantInfo>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public void updateESFPartecipantInfo(long esfPartecipantInfoId,
		long groupId, long companyId, long userId, java.lang.String userName,
		boolean isPortalUser, long esfUserId, long protocol,
		java.lang.String firstName, java.lang.String lastName,
		java.lang.String placeOfBirth, java.util.Date dateOfBirth,
		java.lang.String residenceCity, java.lang.String province, int zip,
		java.lang.String address, java.lang.String phoneNumber,
		java.lang.String email, java.lang.String maritialStatus,
		java.lang.String fiscalCode, java.lang.String passport,
		java.lang.String releasedBy, java.util.Date passportReleaseDate,
		java.util.Date passportExpirationDate,
		java.lang.String europeanCardNumber,
		java.util.Date europeanCardReleaseDate,
		java.util.Date europeanCardExpirationDate,
		java.lang.String gunLicenceNumber,
		java.util.Date gunLicenceReleaseDate,
		java.util.Date gunLicenceExpirationDate,
		java.lang.String esfGunTypeNameOne, java.lang.String esfGunKindNameOne,
		java.lang.String firstGunCode, double firstGunCaliber,
		java.lang.String firstGunExtraCanes,
		java.lang.String esfGunTypeNameTwo, java.lang.String esfGunKindNameTwo,
		java.lang.String secondGunCode, double secondGunCaliber,
		java.lang.String secondGunExtraCanes,
		java.lang.String gunCartridgeType, java.lang.String gunCartridgeKind,
		java.lang.String cartridgeCaliber, long esfMatchId,
		long esfGunTypeIdOne, long esfGunKindIdOne, long esfGunTypeIdTwo,
		long esfGunKindIdTwo)
		throws com.liferay.portal.kernel.exception.SystemException {
		try {
			_invokableLocalService.invokeMethod(_methodName21,
				_methodParameterTypes21,
				new Object[] {
					esfPartecipantInfoId,
					
				groupId,
					
				companyId,
					
				userId,
					
				ClpSerializer.translateInput(userName),
					
				isPortalUser,
					
				esfUserId,
					
				protocol,
					
				ClpSerializer.translateInput(firstName),
					
				ClpSerializer.translateInput(lastName),
					
				ClpSerializer.translateInput(placeOfBirth),
					
				ClpSerializer.translateInput(dateOfBirth),
					
				ClpSerializer.translateInput(residenceCity),
					
				ClpSerializer.translateInput(province),
					
				zip,
					
				ClpSerializer.translateInput(address),
					
				ClpSerializer.translateInput(phoneNumber),
					
				ClpSerializer.translateInput(email),
					
				ClpSerializer.translateInput(maritialStatus),
					
				ClpSerializer.translateInput(fiscalCode),
					
				ClpSerializer.translateInput(passport),
					
				ClpSerializer.translateInput(releasedBy),
					
				ClpSerializer.translateInput(passportReleaseDate),
					
				ClpSerializer.translateInput(passportExpirationDate),
					
				ClpSerializer.translateInput(europeanCardNumber),
					
				ClpSerializer.translateInput(europeanCardReleaseDate),
					
				ClpSerializer.translateInput(europeanCardExpirationDate),
					
				ClpSerializer.translateInput(gunLicenceNumber),
					
				ClpSerializer.translateInput(gunLicenceReleaseDate),
					
				ClpSerializer.translateInput(gunLicenceExpirationDate),
					
				ClpSerializer.translateInput(esfGunTypeNameOne),
					
				ClpSerializer.translateInput(esfGunKindNameOne),
					
				ClpSerializer.translateInput(firstGunCode),
					
				firstGunCaliber,
					
				ClpSerializer.translateInput(firstGunExtraCanes),
					
				ClpSerializer.translateInput(esfGunTypeNameTwo),
					
				ClpSerializer.translateInput(esfGunKindNameTwo),
					
				ClpSerializer.translateInput(secondGunCode),
					
				secondGunCaliber,
					
				ClpSerializer.translateInput(secondGunExtraCanes),
					
				ClpSerializer.translateInput(gunCartridgeType),
					
				ClpSerializer.translateInput(gunCartridgeKind),
					
				ClpSerializer.translateInput(cartridgeCaliber),
					
				esfMatchId,
					
				esfGunTypeIdOne,
					
				esfGunKindIdOne,
					
				esfGunTypeIdTwo,
					
				esfGunKindIdTwo
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
	}

	@Override
	public void addESFPartecipantInfo(long groupId, long companyId,
		long userId, java.lang.String userName, java.util.Date createDate,
		boolean isPortalUser, long esfUserId, long protocol,
		java.lang.String firstName, java.lang.String lastName,
		java.lang.String placeOfBirth, java.util.Date dateOfBirth,
		java.lang.String residenceCity, java.lang.String province, int zip,
		java.lang.String address, java.lang.String phoneNumber,
		java.lang.String email, java.lang.String maritialStatus,
		java.lang.String fiscalCode, java.lang.String passport,
		java.lang.String releasedBy, java.util.Date passportReleaseDate,
		java.util.Date passportExpirationDate,
		java.lang.String europeanCardNumber,
		java.util.Date europeanCardReleaseDate,
		java.util.Date europeanCardExpirationDate,
		java.lang.String gunLicenceNumber,
		java.util.Date gunLicenceReleaseDate,
		java.util.Date gunLicenceExpirationDate,
		java.lang.String esfGunTypeNameOne, java.lang.String esfGunKindNameOne,
		java.lang.String firstGunCode, double firstGunCaliber,
		java.lang.String firstGunExtraCanes,
		java.lang.String esfGunTypeNameTwo, java.lang.String esfGunKindNameTwo,
		java.lang.String secondGunCode, double secondGunCaliber,
		java.lang.String secondGunExtraCanes,
		java.lang.String gunCartridgeType, java.lang.String gunCartridgeKind,
		java.lang.String cartridgeCaliber, long esfMatchId,
		long esfGunTypeIdOne, long esfGunKindIdOne, long esfGunTypeIdTwo,
		long esfGunKindIdTwo)
		throws com.liferay.portal.kernel.exception.SystemException {
		try {
			_invokableLocalService.invokeMethod(_methodName22,
				_methodParameterTypes22,
				new Object[] {
					groupId,
					
				companyId,
					
				userId,
					
				ClpSerializer.translateInput(userName),
					
				ClpSerializer.translateInput(createDate),
					
				isPortalUser,
					
				esfUserId,
					
				protocol,
					
				ClpSerializer.translateInput(firstName),
					
				ClpSerializer.translateInput(lastName),
					
				ClpSerializer.translateInput(placeOfBirth),
					
				ClpSerializer.translateInput(dateOfBirth),
					
				ClpSerializer.translateInput(residenceCity),
					
				ClpSerializer.translateInput(province),
					
				zip,
					
				ClpSerializer.translateInput(address),
					
				ClpSerializer.translateInput(phoneNumber),
					
				ClpSerializer.translateInput(email),
					
				ClpSerializer.translateInput(maritialStatus),
					
				ClpSerializer.translateInput(fiscalCode),
					
				ClpSerializer.translateInput(passport),
					
				ClpSerializer.translateInput(releasedBy),
					
				ClpSerializer.translateInput(passportReleaseDate),
					
				ClpSerializer.translateInput(passportExpirationDate),
					
				ClpSerializer.translateInput(europeanCardNumber),
					
				ClpSerializer.translateInput(europeanCardReleaseDate),
					
				ClpSerializer.translateInput(europeanCardExpirationDate),
					
				ClpSerializer.translateInput(gunLicenceNumber),
					
				ClpSerializer.translateInput(gunLicenceReleaseDate),
					
				ClpSerializer.translateInput(gunLicenceExpirationDate),
					
				ClpSerializer.translateInput(esfGunTypeNameOne),
					
				ClpSerializer.translateInput(esfGunKindNameOne),
					
				ClpSerializer.translateInput(firstGunCode),
					
				firstGunCaliber,
					
				ClpSerializer.translateInput(firstGunExtraCanes),
					
				ClpSerializer.translateInput(esfGunTypeNameTwo),
					
				ClpSerializer.translateInput(esfGunKindNameTwo),
					
				ClpSerializer.translateInput(secondGunCode),
					
				secondGunCaliber,
					
				ClpSerializer.translateInput(secondGunExtraCanes),
					
				ClpSerializer.translateInput(gunCartridgeType),
					
				ClpSerializer.translateInput(gunCartridgeKind),
					
				ClpSerializer.translateInput(cartridgeCaliber),
					
				esfMatchId,
					
				esfGunTypeIdOne,
					
				esfGunKindIdOne,
					
				esfGunTypeIdTwo,
					
				esfGunKindIdTwo
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
	}

	@Override
	public long addESFPartecipantInfoAndReturnId(long groupId, long companyId,
		long userId, java.lang.String userName, java.util.Date createDate,
		boolean isPortalUser, long esfUserId, long protocol,
		java.lang.String firstName, java.lang.String lastName,
		java.lang.String placeOfBirth, java.util.Date dateOfBirth,
		java.lang.String residenceCity, java.lang.String province, int zip,
		java.lang.String address, java.lang.String phoneNumber,
		java.lang.String email, java.lang.String maritialStatus,
		java.lang.String fiscalCode, java.lang.String passport,
		java.lang.String releasedBy, java.util.Date passportReleaseDate,
		java.util.Date passportExpirationDate,
		java.lang.String europeanCardNumber,
		java.util.Date europeanCardReleaseDate,
		java.util.Date europeanCardExpirationDate,
		java.lang.String gunLicenceNumber,
		java.util.Date gunLicenceReleaseDate,
		java.util.Date gunLicenceExpirationDate,
		java.lang.String esfGunTypeNameOne, java.lang.String esfGunKindNameOne,
		java.lang.String firstGunCode, double firstGunCaliber,
		java.lang.String firstGunExtraCanes,
		java.lang.String esfGunTypeNameTwo, java.lang.String esfGunKindNameTwo,
		java.lang.String secondGunCode, double secondGunCaliber,
		java.lang.String secondGunExtraCanes,
		java.lang.String gunCartridgeType, java.lang.String gunCartridgeKind,
		java.lang.String cartridgeCaliber, long esfMatchId,
		long esfGunTypeIdOne, long esfGunKindIdOne, long esfGunTypeIdTwo,
		long esfGunKindIdTwo)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName23,
					_methodParameterTypes23,
					new Object[] {
						groupId,
						
					companyId,
						
					userId,
						
					ClpSerializer.translateInput(userName),
						
					ClpSerializer.translateInput(createDate),
						
					isPortalUser,
						
					esfUserId,
						
					protocol,
						
					ClpSerializer.translateInput(firstName),
						
					ClpSerializer.translateInput(lastName),
						
					ClpSerializer.translateInput(placeOfBirth),
						
					ClpSerializer.translateInput(dateOfBirth),
						
					ClpSerializer.translateInput(residenceCity),
						
					ClpSerializer.translateInput(province),
						
					zip,
						
					ClpSerializer.translateInput(address),
						
					ClpSerializer.translateInput(phoneNumber),
						
					ClpSerializer.translateInput(email),
						
					ClpSerializer.translateInput(maritialStatus),
						
					ClpSerializer.translateInput(fiscalCode),
						
					ClpSerializer.translateInput(passport),
						
					ClpSerializer.translateInput(releasedBy),
						
					ClpSerializer.translateInput(passportReleaseDate),
						
					ClpSerializer.translateInput(passportExpirationDate),
						
					ClpSerializer.translateInput(europeanCardNumber),
						
					ClpSerializer.translateInput(europeanCardReleaseDate),
						
					ClpSerializer.translateInput(europeanCardExpirationDate),
						
					ClpSerializer.translateInput(gunLicenceNumber),
						
					ClpSerializer.translateInput(gunLicenceReleaseDate),
						
					ClpSerializer.translateInput(gunLicenceExpirationDate),
						
					ClpSerializer.translateInput(esfGunTypeNameOne),
						
					ClpSerializer.translateInput(esfGunKindNameOne),
						
					ClpSerializer.translateInput(firstGunCode),
						
					firstGunCaliber,
						
					ClpSerializer.translateInput(firstGunExtraCanes),
						
					ClpSerializer.translateInput(esfGunTypeNameTwo),
						
					ClpSerializer.translateInput(esfGunKindNameTwo),
						
					ClpSerializer.translateInput(secondGunCode),
						
					secondGunCaliber,
						
					ClpSerializer.translateInput(secondGunExtraCanes),
						
					ClpSerializer.translateInput(gunCartridgeType),
						
					ClpSerializer.translateInput(gunCartridgeKind),
						
					ClpSerializer.translateInput(cartridgeCaliber),
						
					esfMatchId,
						
					esfGunTypeIdOne,
						
					esfGunKindIdOne,
						
					esfGunTypeIdTwo,
						
					esfGunKindIdTwo
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
	private String _methodName19;
	private String[] _methodParameterTypes19;
	private String _methodName20;
	private String[] _methodParameterTypes20;
	private String _methodName21;
	private String[] _methodParameterTypes21;
	private String _methodName22;
	private String[] _methodParameterTypes22;
	private String _methodName23;
	private String[] _methodParameterTypes23;
}