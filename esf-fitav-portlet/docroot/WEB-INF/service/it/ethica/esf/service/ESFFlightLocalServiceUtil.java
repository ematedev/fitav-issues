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
 * Provides the local service utility for ESFFlight. This utility wraps
 * {@link it.ethica.esf.service.impl.ESFFlightLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Ethica
 * @see ESFFlightLocalService
 * @see it.ethica.esf.service.base.ESFFlightLocalServiceBaseImpl
 * @see it.ethica.esf.service.impl.ESFFlightLocalServiceImpl
 * @generated
 */
public class ESFFlightLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link it.ethica.esf.service.impl.ESFFlightLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the e s f flight to the database. Also notifies the appropriate model listeners.
	*
	* @param esfFlight the e s f flight
	* @return the e s f flight that was added
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFFlight addESFFlight(
		it.ethica.esf.model.ESFFlight esfFlight)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addESFFlight(esfFlight);
	}

	/**
	* Creates a new e s f flight with the primary key. Does not add the e s f flight to the database.
	*
	* @param esfFlightId the primary key for the new e s f flight
	* @return the new e s f flight
	*/
	public static it.ethica.esf.model.ESFFlight createESFFlight(
		long esfFlightId) {
		return getService().createESFFlight(esfFlightId);
	}

	/**
	* Deletes the e s f flight with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfFlightId the primary key of the e s f flight
	* @return the e s f flight that was removed
	* @throws PortalException if a e s f flight with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFFlight deleteESFFlight(
		long esfFlightId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteESFFlight(esfFlightId);
	}

	/**
	* Deletes the e s f flight from the database. Also notifies the appropriate model listeners.
	*
	* @param esfFlight the e s f flight
	* @return the e s f flight that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFFlight deleteESFFlight(
		it.ethica.esf.model.ESFFlight esfFlight)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteESFFlight(esfFlight);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFlightModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFlightModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static it.ethica.esf.model.ESFFlight fetchESFFlight(long esfFlightId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchESFFlight(esfFlightId);
	}

	/**
	* Returns the e s f flight with the primary key.
	*
	* @param esfFlightId the primary key of the e s f flight
	* @return the e s f flight
	* @throws PortalException if a e s f flight with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFFlight getESFFlight(long esfFlightId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFFlight(esfFlightId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the e s f flights.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFlightModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f flights
	* @param end the upper bound of the range of e s f flights (not inclusive)
	* @return the range of e s f flights
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFFlight> getESFFlights(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFFlights(start, end);
	}

	/**
	* Returns the number of e s f flights.
	*
	* @return the number of e s f flights
	* @throws SystemException if a system exception occurred
	*/
	public static int getESFFlightsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFFlightsCount();
	}

	/**
	* Updates the e s f flight in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param esfFlight the e s f flight
	* @return the e s f flight that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFFlight updateESFFlight(
		it.ethica.esf.model.ESFFlight esfFlight)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateESFFlight(esfFlight);
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

	public static it.ethica.esf.model.ESFFlight addEsfFlight(long groupId,
		long companyId, java.lang.String userName, long userId, long esfUserId,
		java.lang.String flightCode, java.util.Date leaveDate,
		java.util.Date arriveDate, java.util.Date createDate,
		java.lang.String leaveHour, java.lang.String arriveHour,
		java.lang.String companyName, java.lang.String departureAirport,
		java.lang.String arrivalAirport, long esfMatchId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addEsfFlight(groupId, companyId, userName, userId,
			esfUserId, flightCode, leaveDate, arriveDate, createDate,
			leaveHour, arriveHour, companyName, departureAirport,
			arrivalAirport, esfMatchId);
	}

	public static it.ethica.esf.model.ESFFlight updateEsfFlight(
		long esfFlightId, long groupId, long companyId,
		java.lang.String userName, long esfUserId, long userId,
		java.lang.String flightCode, java.util.Date modifiedDate,
		java.util.Date leaveDate, java.lang.String leaveHour,
		java.util.Date arriveDate, java.lang.String arriveHour,
		java.lang.String companyName, java.lang.String departureAirport,
		java.lang.String arrivalAirport, long esfMatchId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateEsfFlight(esfFlightId, groupId, companyId, userName,
			esfUserId, userId, flightCode, modifiedDate, leaveDate, leaveHour,
			arriveDate, arriveHour, companyName, departureAirport,
			arrivalAirport, esfMatchId);
	}

	public static java.util.List<it.ethica.esf.model.ESFFlight> findFlightsByESFMatchId(
		long esfMatchId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findFlightsByESFMatchId(esfMatchId);
	}

	public static java.util.List<it.ethica.esf.model.ESFFlight> findFlightsByFlightCode(
		java.lang.String flightCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findFlightsByFlightCode(flightCode);
	}

	public static java.util.List<it.ethica.esf.model.ESFFlight> getByEsfMatchIdEsfUserId(
		long esfMatchId, long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getByEsfMatchIdEsfUserId(esfMatchId, esfUserId);
	}

	public static java.util.List<it.ethica.esf.model.ESFFlight> getESFFlightsByEsfMatchId_F_L_L_C_D(
		long esfMatchId, java.lang.String flightCode, java.util.Date leaveDate,
		java.lang.String leaveHour, java.lang.String companyName,
		java.lang.String departureAirport)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getESFFlightsByEsfMatchId_F_L_L_C_D(esfMatchId, flightCode,
			leaveDate, leaveHour, companyName, departureAirport);
	}

	public static void clearService() {
		_service = null;
	}

	public static ESFFlightLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ESFFlightLocalService.class.getName());

			if (invokableLocalService instanceof ESFFlightLocalService) {
				_service = (ESFFlightLocalService)invokableLocalService;
			}
			else {
				_service = new ESFFlightLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(ESFFlightLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(ESFFlightLocalService service) {
	}

	private static ESFFlightLocalService _service;
}