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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for ESFDeparture. This utility wraps
 * {@link it.ethica.esf.service.impl.ESFDepartureLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Ethica
 * @see ESFDepartureLocalService
 * @see it.ethica.esf.service.base.ESFDepartureLocalServiceBaseImpl
 * @see it.ethica.esf.service.impl.ESFDepartureLocalServiceImpl
 * @generated
 */
public class ESFDepartureLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link it.ethica.esf.service.impl.ESFDepartureLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the e s f departure to the database. Also notifies the appropriate model listeners.
	*
	* @param esfDeparture the e s f departure
	* @return the e s f departure that was added
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFDeparture addESFDeparture(
		it.ethica.esf.model.ESFDeparture esfDeparture)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addESFDeparture(esfDeparture);
	}

	/**
	* Creates a new e s f departure with the primary key. Does not add the e s f departure to the database.
	*
	* @param esfDepartureId the primary key for the new e s f departure
	* @return the new e s f departure
	*/
	public static it.ethica.esf.model.ESFDeparture createESFDeparture(
		long esfDepartureId) {
		return getService().createESFDeparture(esfDepartureId);
	}

	/**
	* Deletes the e s f departure with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfDepartureId the primary key of the e s f departure
	* @return the e s f departure that was removed
	* @throws PortalException if a e s f departure with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFDeparture deleteESFDeparture(
		long esfDepartureId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteESFDeparture(esfDepartureId);
	}

	/**
	* Deletes the e s f departure from the database. Also notifies the appropriate model listeners.
	*
	* @param esfDeparture the e s f departure
	* @return the e s f departure that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFDeparture deleteESFDeparture(
		it.ethica.esf.model.ESFDeparture esfDeparture)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteESFDeparture(esfDeparture);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFDepartureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFDepartureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static it.ethica.esf.model.ESFDeparture fetchESFDeparture(
		long esfDepartureId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchESFDeparture(esfDepartureId);
	}

	/**
	* Returns the e s f departure with the primary key.
	*
	* @param esfDepartureId the primary key of the e s f departure
	* @return the e s f departure
	* @throws PortalException if a e s f departure with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFDeparture getESFDeparture(
		long esfDepartureId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFDeparture(esfDepartureId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the e s f departures.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFDepartureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f departures
	* @param end the upper bound of the range of e s f departures (not inclusive)
	* @return the range of e s f departures
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFDeparture> getESFDepartures(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFDepartures(start, end);
	}

	/**
	* Returns the number of e s f departures.
	*
	* @return the number of e s f departures
	* @throws SystemException if a system exception occurred
	*/
	public static int getESFDeparturesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFDeparturesCount();
	}

	/**
	* Updates the e s f departure in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param esfDeparture the e s f departure
	* @return the e s f departure that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFDeparture updateESFDeparture(
		it.ethica.esf.model.ESFDeparture esfDeparture)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateESFDeparture(esfDeparture);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static it.ethica.esf.model.ESFDeparture addEsfDeparture(
		long groupId, long companyId, java.lang.String userName, long userId,
		long esfUserId, java.lang.String code, java.util.Date leaveDate,
		java.util.Date arriveDate, java.util.Date createDate,
		java.lang.String leaveHour, java.lang.String arriveHour,
		java.lang.String companyName, java.lang.String departureFrom,
		java.lang.String arrivalTo, long esfMatchId, boolean returned,
		java.lang.String meetingPlace, java.lang.String typeTravel,
		java.lang.String stopover)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addEsfDeparture(groupId, companyId, userName, userId,
			esfUserId, code, leaveDate, arriveDate, createDate, leaveHour,
			arriveHour, companyName, departureFrom, arrivalTo, esfMatchId,
			returned, meetingPlace, typeTravel, stopover);
	}

	public static it.ethica.esf.model.ESFDeparture updateEsfDeparture(
		long esfDepartureId, long groupId, long companyId,
		java.lang.String userName, long esfUserId, long userId,
		java.lang.String code, java.util.Date modifiedDate,
		java.util.Date leaveDate, java.lang.String leaveHour,
		java.util.Date arriveDate, java.lang.String arriveHour,
		java.lang.String companyName, java.lang.String departureFrom,
		java.lang.String arrivalTo, long esfMatchId, boolean returned,
		java.lang.String meetingPlace, java.lang.String typeTravel,
		java.lang.String stopover)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateEsfDeparture(esfDepartureId, groupId, companyId,
			userName, esfUserId, userId, code, modifiedDate, leaveDate,
			leaveHour, arriveDate, arriveHour, companyName, departureFrom,
			arrivalTo, esfMatchId, returned, meetingPlace, typeTravel, stopover);
	}

	public static java.util.List<it.ethica.esf.model.ESFDeparture> findESFDeparturesByESFMatchId(
		long esfMatchId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findESFDeparturesByESFMatchId(esfMatchId);
	}

	public static java.util.List<it.ethica.esf.model.ESFDeparture> findESFDeparturesByESFMatchId(
		long esfMatchId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findESFDeparturesByESFMatchId(esfMatchId, start, end);
	}

	public static java.util.List<it.ethica.esf.model.ESFDeparture> findDeparturesByCode(
		java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findDeparturesByCode(code);
	}

	public static java.util.List<it.ethica.esf.model.ESFDeparture> findDeparturesByCode(
		java.lang.String code, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findDeparturesByCode(code, start, end);
	}

	public static java.util.List<it.ethica.esf.model.ESFDeparture> getByEsfMatchIdEsfUserId(
		long esfMatchId, long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getByEsfMatchIdEsfUserId(esfMatchId, esfUserId);
	}

	public static java.util.List<it.ethica.esf.model.ESFDeparture> getByEsfMatchIdEsfUserId(
		long esfMatchId, long esfUserId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getByEsfMatchIdEsfUserId(esfMatchId, esfUserId, start, end);
	}

	public static java.util.List<it.ethica.esf.model.ESFDeparture> getESFDeparturesByEsfMatchId_F_L_L_C_D(
		long esfMatchId, java.lang.String code, java.util.Date leaveDate,
		java.lang.String leaveHour, java.lang.String companyName,
		java.lang.String departureFrom)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getESFDeparturesByEsfMatchId_F_L_L_C_D(esfMatchId, code,
			leaveDate, leaveHour, companyName, departureFrom);
	}

	public static java.util.List<it.ethica.esf.model.ESFDeparture> getESFDeparturesByEsfMatchId_F_L_L_C_D(
		long esfMatchId, java.lang.String code, java.util.Date leaveDate,
		java.lang.String leaveHour, java.lang.String companyName,
		java.lang.String departureFrom, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getESFDeparturesByEsfMatchId_F_L_L_C_D(esfMatchId, code,
			leaveDate, leaveHour, companyName, departureFrom, start, end);
	}

	public static void clearService() {
		_service = null;
	}

	public static ESFDepartureLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ESFDepartureLocalService.class.getName());

			if (invokableLocalService instanceof ESFDepartureLocalService) {
				_service = (ESFDepartureLocalService)invokableLocalService;
			}
			else {
				_service = new ESFDepartureLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(ESFDepartureLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(ESFDepartureLocalService service) {
	}

	private static ESFDepartureLocalService _service;
}