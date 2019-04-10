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

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ESFFlightLocalService}.
 *
 * @author Ethica
 * @see ESFFlightLocalService
 * @generated
 */
public class ESFFlightLocalServiceWrapper implements ESFFlightLocalService,
	ServiceWrapper<ESFFlightLocalService> {
	public ESFFlightLocalServiceWrapper(
		ESFFlightLocalService esfFlightLocalService) {
		_esfFlightLocalService = esfFlightLocalService;
	}

	/**
	* Adds the e s f flight to the database. Also notifies the appropriate model listeners.
	*
	* @param esfFlight the e s f flight
	* @return the e s f flight that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFFlight addESFFlight(
		it.ethica.esf.model.ESFFlight esfFlight)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfFlightLocalService.addESFFlight(esfFlight);
	}

	/**
	* Creates a new e s f flight with the primary key. Does not add the e s f flight to the database.
	*
	* @param esfFlightId the primary key for the new e s f flight
	* @return the new e s f flight
	*/
	@Override
	public it.ethica.esf.model.ESFFlight createESFFlight(long esfFlightId) {
		return _esfFlightLocalService.createESFFlight(esfFlightId);
	}

	/**
	* Deletes the e s f flight with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfFlightId the primary key of the e s f flight
	* @return the e s f flight that was removed
	* @throws PortalException if a e s f flight with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFFlight deleteESFFlight(long esfFlightId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfFlightLocalService.deleteESFFlight(esfFlightId);
	}

	/**
	* Deletes the e s f flight from the database. Also notifies the appropriate model listeners.
	*
	* @param esfFlight the e s f flight
	* @return the e s f flight that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFFlight deleteESFFlight(
		it.ethica.esf.model.ESFFlight esfFlight)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfFlightLocalService.deleteESFFlight(esfFlight);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _esfFlightLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfFlightLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _esfFlightLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfFlightLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfFlightLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfFlightLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public it.ethica.esf.model.ESFFlight fetchESFFlight(long esfFlightId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfFlightLocalService.fetchESFFlight(esfFlightId);
	}

	/**
	* Returns the e s f flight with the primary key.
	*
	* @param esfFlightId the primary key of the e s f flight
	* @return the e s f flight
	* @throws PortalException if a e s f flight with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFFlight getESFFlight(long esfFlightId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfFlightLocalService.getESFFlight(esfFlightId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfFlightLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<it.ethica.esf.model.ESFFlight> getESFFlights(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfFlightLocalService.getESFFlights(start, end);
	}

	/**
	* Returns the number of e s f flights.
	*
	* @return the number of e s f flights
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getESFFlightsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfFlightLocalService.getESFFlightsCount();
	}

	/**
	* Updates the e s f flight in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param esfFlight the e s f flight
	* @return the e s f flight that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFFlight updateESFFlight(
		it.ethica.esf.model.ESFFlight esfFlight)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfFlightLocalService.updateESFFlight(esfFlight);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _esfFlightLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_esfFlightLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _esfFlightLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public it.ethica.esf.model.ESFFlight addEsfFlight(long groupId,
		long companyId, java.lang.String userName, long userId, long esfUserId,
		java.lang.String flightCode, java.util.Date leaveDate,
		java.util.Date arriveDate, java.util.Date createDate,
		java.lang.String leaveHour, java.lang.String arriveHour,
		java.lang.String companyName, java.lang.String departureAirport,
		java.lang.String arrivalAirport, long esfMatchId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfFlightLocalService.addEsfFlight(groupId, companyId,
			userName, userId, esfUserId, flightCode, leaveDate, arriveDate,
			createDate, leaveHour, arriveHour, companyName, departureAirport,
			arrivalAirport, esfMatchId);
	}

	@Override
	public it.ethica.esf.model.ESFFlight updateEsfFlight(long esfFlightId,
		long groupId, long companyId, java.lang.String userName,
		long esfUserId, long userId, java.lang.String flightCode,
		java.util.Date modifiedDate, java.util.Date leaveDate,
		java.lang.String leaveHour, java.util.Date arriveDate,
		java.lang.String arriveHour, java.lang.String companyName,
		java.lang.String departureAirport, java.lang.String arrivalAirport,
		long esfMatchId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfFlightLocalService.updateEsfFlight(esfFlightId, groupId,
			companyId, userName, esfUserId, userId, flightCode, modifiedDate,
			leaveDate, leaveHour, arriveDate, arriveHour, companyName,
			departureAirport, arrivalAirport, esfMatchId);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFFlight> findFlightsByESFMatchId(
		long esfMatchId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfFlightLocalService.findFlightsByESFMatchId(esfMatchId);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFFlight> findFlightsByFlightCode(
		java.lang.String flightCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfFlightLocalService.findFlightsByFlightCode(flightCode);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFFlight> getByEsfMatchIdEsfUserId(
		long esfMatchId, long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfFlightLocalService.getByEsfMatchIdEsfUserId(esfMatchId,
			esfUserId);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFFlight> getESFFlightsByEsfMatchId_F_L_L_C_D(
		long esfMatchId, java.lang.String flightCode, java.util.Date leaveDate,
		java.lang.String leaveHour, java.lang.String companyName,
		java.lang.String departureAirport)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfFlightLocalService.getESFFlightsByEsfMatchId_F_L_L_C_D(esfMatchId,
			flightCode, leaveDate, leaveHour, companyName, departureAirport);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ESFFlightLocalService getWrappedESFFlightLocalService() {
		return _esfFlightLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedESFFlightLocalService(
		ESFFlightLocalService esfFlightLocalService) {
		_esfFlightLocalService = esfFlightLocalService;
	}

	@Override
	public ESFFlightLocalService getWrappedService() {
		return _esfFlightLocalService;
	}

	@Override
	public void setWrappedService(ESFFlightLocalService esfFlightLocalService) {
		_esfFlightLocalService = esfFlightLocalService;
	}

	private ESFFlightLocalService _esfFlightLocalService;
}