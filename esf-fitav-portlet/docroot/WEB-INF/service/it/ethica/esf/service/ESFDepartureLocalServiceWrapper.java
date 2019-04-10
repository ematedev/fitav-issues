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

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ESFDepartureLocalService}.
 *
 * @author Ethica
 * @see ESFDepartureLocalService
 * @generated
 */
public class ESFDepartureLocalServiceWrapper implements ESFDepartureLocalService,
	ServiceWrapper<ESFDepartureLocalService> {
	public ESFDepartureLocalServiceWrapper(
		ESFDepartureLocalService esfDepartureLocalService) {
		_esfDepartureLocalService = esfDepartureLocalService;
	}

	/**
	* Adds the e s f departure to the database. Also notifies the appropriate model listeners.
	*
	* @param esfDeparture the e s f departure
	* @return the e s f departure that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFDeparture addESFDeparture(
		it.ethica.esf.model.ESFDeparture esfDeparture)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfDepartureLocalService.addESFDeparture(esfDeparture);
	}

	/**
	* Creates a new e s f departure with the primary key. Does not add the e s f departure to the database.
	*
	* @param esfDepartureId the primary key for the new e s f departure
	* @return the new e s f departure
	*/
	@Override
	public it.ethica.esf.model.ESFDeparture createESFDeparture(
		long esfDepartureId) {
		return _esfDepartureLocalService.createESFDeparture(esfDepartureId);
	}

	/**
	* Deletes the e s f departure with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfDepartureId the primary key of the e s f departure
	* @return the e s f departure that was removed
	* @throws PortalException if a e s f departure with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFDeparture deleteESFDeparture(
		long esfDepartureId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfDepartureLocalService.deleteESFDeparture(esfDepartureId);
	}

	/**
	* Deletes the e s f departure from the database. Also notifies the appropriate model listeners.
	*
	* @param esfDeparture the e s f departure
	* @return the e s f departure that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFDeparture deleteESFDeparture(
		it.ethica.esf.model.ESFDeparture esfDeparture)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfDepartureLocalService.deleteESFDeparture(esfDeparture);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _esfDepartureLocalService.dynamicQuery();
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
		return _esfDepartureLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _esfDepartureLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfDepartureLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _esfDepartureLocalService.dynamicQueryCount(dynamicQuery);
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
		return _esfDepartureLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public it.ethica.esf.model.ESFDeparture fetchESFDeparture(
		long esfDepartureId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfDepartureLocalService.fetchESFDeparture(esfDepartureId);
	}

	/**
	* Returns the e s f departure with the primary key.
	*
	* @param esfDepartureId the primary key of the e s f departure
	* @return the e s f departure
	* @throws PortalException if a e s f departure with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFDeparture getESFDeparture(long esfDepartureId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfDepartureLocalService.getESFDeparture(esfDepartureId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfDepartureLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<it.ethica.esf.model.ESFDeparture> getESFDepartures(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfDepartureLocalService.getESFDepartures(start, end);
	}

	/**
	* Returns the number of e s f departures.
	*
	* @return the number of e s f departures
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getESFDeparturesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfDepartureLocalService.getESFDeparturesCount();
	}

	/**
	* Updates the e s f departure in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param esfDeparture the e s f departure
	* @return the e s f departure that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFDeparture updateESFDeparture(
		it.ethica.esf.model.ESFDeparture esfDeparture)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfDepartureLocalService.updateESFDeparture(esfDeparture);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _esfDepartureLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_esfDepartureLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _esfDepartureLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public it.ethica.esf.model.ESFDeparture addEsfDeparture(long groupId,
		long companyId, java.lang.String userName, long userId, long esfUserId,
		java.lang.String code, java.util.Date leaveDate,
		java.util.Date arriveDate, java.util.Date createDate,
		java.lang.String leaveHour, java.lang.String arriveHour,
		java.lang.String companyName, java.lang.String departureFrom,
		java.lang.String arrivalTo, long esfMatchId, boolean returned,
		java.lang.String meetingPlace, java.lang.String typeTravel,
		java.lang.String stopover)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfDepartureLocalService.addEsfDeparture(groupId, companyId,
			userName, userId, esfUserId, code, leaveDate, arriveDate,
			createDate, leaveHour, arriveHour, companyName, departureFrom,
			arrivalTo, esfMatchId, returned, meetingPlace, typeTravel, stopover);
	}

	@Override
	public it.ethica.esf.model.ESFDeparture updateEsfDeparture(
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
		return _esfDepartureLocalService.updateEsfDeparture(esfDepartureId,
			groupId, companyId, userName, esfUserId, userId, code,
			modifiedDate, leaveDate, leaveHour, arriveDate, arriveHour,
			companyName, departureFrom, arrivalTo, esfMatchId, returned,
			meetingPlace, typeTravel, stopover);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFDeparture> findESFDeparturesByESFMatchId(
		long esfMatchId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfDepartureLocalService.findESFDeparturesByESFMatchId(esfMatchId);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFDeparture> findESFDeparturesByESFMatchId(
		long esfMatchId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfDepartureLocalService.findESFDeparturesByESFMatchId(esfMatchId,
			start, end);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFDeparture> findDeparturesByCode(
		java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfDepartureLocalService.findDeparturesByCode(code);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFDeparture> findDeparturesByCode(
		java.lang.String code, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfDepartureLocalService.findDeparturesByCode(code, start, end);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFDeparture> getByEsfMatchIdEsfUserId(
		long esfMatchId, long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfDepartureLocalService.getByEsfMatchIdEsfUserId(esfMatchId,
			esfUserId);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFDeparture> getByEsfMatchIdEsfUserId(
		long esfMatchId, long esfUserId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfDepartureLocalService.getByEsfMatchIdEsfUserId(esfMatchId,
			esfUserId, start, end);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFDeparture> getESFDeparturesByEsfMatchId_F_L_L_C_D(
		long esfMatchId, java.lang.String code, java.util.Date leaveDate,
		java.lang.String leaveHour, java.lang.String companyName,
		java.lang.String departureFrom)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfDepartureLocalService.getESFDeparturesByEsfMatchId_F_L_L_C_D(esfMatchId,
			code, leaveDate, leaveHour, companyName, departureFrom);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFDeparture> getESFDeparturesByEsfMatchId_F_L_L_C_D(
		long esfMatchId, java.lang.String code, java.util.Date leaveDate,
		java.lang.String leaveHour, java.lang.String companyName,
		java.lang.String departureFrom, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfDepartureLocalService.getESFDeparturesByEsfMatchId_F_L_L_C_D(esfMatchId,
			code, leaveDate, leaveHour, companyName, departureFrom, start, end);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ESFDepartureLocalService getWrappedESFDepartureLocalService() {
		return _esfDepartureLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedESFDepartureLocalService(
		ESFDepartureLocalService esfDepartureLocalService) {
		_esfDepartureLocalService = esfDepartureLocalService;
	}

	@Override
	public ESFDepartureLocalService getWrappedService() {
		return _esfDepartureLocalService;
	}

	@Override
	public void setWrappedService(
		ESFDepartureLocalService esfDepartureLocalService) {
		_esfDepartureLocalService = esfDepartureLocalService;
	}

	private ESFDepartureLocalService _esfDepartureLocalService;
}