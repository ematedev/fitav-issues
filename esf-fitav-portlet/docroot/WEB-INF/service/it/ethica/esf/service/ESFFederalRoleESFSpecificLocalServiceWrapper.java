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
 * Provides a wrapper for {@link ESFFederalRoleESFSpecificLocalService}.
 *
 * @author Ethica
 * @see ESFFederalRoleESFSpecificLocalService
 * @generated
 */
public class ESFFederalRoleESFSpecificLocalServiceWrapper
	implements ESFFederalRoleESFSpecificLocalService,
		ServiceWrapper<ESFFederalRoleESFSpecificLocalService> {
	public ESFFederalRoleESFSpecificLocalServiceWrapper(
		ESFFederalRoleESFSpecificLocalService esfFederalRoleESFSpecificLocalService) {
		_esfFederalRoleESFSpecificLocalService = esfFederalRoleESFSpecificLocalService;
	}

	/**
	* Adds the e s f federal role e s f specific to the database. Also notifies the appropriate model listeners.
	*
	* @param esfFederalRoleESFSpecific the e s f federal role e s f specific
	* @return the e s f federal role e s f specific that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFFederalRoleESFSpecific addESFFederalRoleESFSpecific(
		it.ethica.esf.model.ESFFederalRoleESFSpecific esfFederalRoleESFSpecific)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfFederalRoleESFSpecificLocalService.addESFFederalRoleESFSpecific(esfFederalRoleESFSpecific);
	}

	/**
	* Creates a new e s f federal role e s f specific with the primary key. Does not add the e s f federal role e s f specific to the database.
	*
	* @param esfFederalRoleESFSpecificPK the primary key for the new e s f federal role e s f specific
	* @return the new e s f federal role e s f specific
	*/
	@Override
	public it.ethica.esf.model.ESFFederalRoleESFSpecific createESFFederalRoleESFSpecific(
		it.ethica.esf.service.persistence.ESFFederalRoleESFSpecificPK esfFederalRoleESFSpecificPK) {
		return _esfFederalRoleESFSpecificLocalService.createESFFederalRoleESFSpecific(esfFederalRoleESFSpecificPK);
	}

	/**
	* Deletes the e s f federal role e s f specific with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfFederalRoleESFSpecificPK the primary key of the e s f federal role e s f specific
	* @return the e s f federal role e s f specific that was removed
	* @throws PortalException if a e s f federal role e s f specific with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFFederalRoleESFSpecific deleteESFFederalRoleESFSpecific(
		it.ethica.esf.service.persistence.ESFFederalRoleESFSpecificPK esfFederalRoleESFSpecificPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfFederalRoleESFSpecificLocalService.deleteESFFederalRoleESFSpecific(esfFederalRoleESFSpecificPK);
	}

	/**
	* Deletes the e s f federal role e s f specific from the database. Also notifies the appropriate model listeners.
	*
	* @param esfFederalRoleESFSpecific the e s f federal role e s f specific
	* @return the e s f federal role e s f specific that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFFederalRoleESFSpecific deleteESFFederalRoleESFSpecific(
		it.ethica.esf.model.ESFFederalRoleESFSpecific esfFederalRoleESFSpecific)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfFederalRoleESFSpecificLocalService.deleteESFFederalRoleESFSpecific(esfFederalRoleESFSpecific);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _esfFederalRoleESFSpecificLocalService.dynamicQuery();
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
		return _esfFederalRoleESFSpecificLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFederalRoleESFSpecificModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _esfFederalRoleESFSpecificLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFederalRoleESFSpecificModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _esfFederalRoleESFSpecificLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
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
		return _esfFederalRoleESFSpecificLocalService.dynamicQueryCount(dynamicQuery);
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
		return _esfFederalRoleESFSpecificLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public it.ethica.esf.model.ESFFederalRoleESFSpecific fetchESFFederalRoleESFSpecific(
		it.ethica.esf.service.persistence.ESFFederalRoleESFSpecificPK esfFederalRoleESFSpecificPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfFederalRoleESFSpecificLocalService.fetchESFFederalRoleESFSpecific(esfFederalRoleESFSpecificPK);
	}

	/**
	* Returns the e s f federal role e s f specific with the primary key.
	*
	* @param esfFederalRoleESFSpecificPK the primary key of the e s f federal role e s f specific
	* @return the e s f federal role e s f specific
	* @throws PortalException if a e s f federal role e s f specific with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFFederalRoleESFSpecific getESFFederalRoleESFSpecific(
		it.ethica.esf.service.persistence.ESFFederalRoleESFSpecificPK esfFederalRoleESFSpecificPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfFederalRoleESFSpecificLocalService.getESFFederalRoleESFSpecific(esfFederalRoleESFSpecificPK);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfFederalRoleESFSpecificLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the e s f federal role e s f specifics.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFederalRoleESFSpecificModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f federal role e s f specifics
	* @param end the upper bound of the range of e s f federal role e s f specifics (not inclusive)
	* @return the range of e s f federal role e s f specifics
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<it.ethica.esf.model.ESFFederalRoleESFSpecific> getESFFederalRoleESFSpecifics(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfFederalRoleESFSpecificLocalService.getESFFederalRoleESFSpecifics(start,
			end);
	}

	/**
	* Returns the number of e s f federal role e s f specifics.
	*
	* @return the number of e s f federal role e s f specifics
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getESFFederalRoleESFSpecificsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfFederalRoleESFSpecificLocalService.getESFFederalRoleESFSpecificsCount();
	}

	/**
	* Updates the e s f federal role e s f specific in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param esfFederalRoleESFSpecific the e s f federal role e s f specific
	* @return the e s f federal role e s f specific that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFFederalRoleESFSpecific updateESFFederalRoleESFSpecific(
		it.ethica.esf.model.ESFFederalRoleESFSpecific esfFederalRoleESFSpecific)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfFederalRoleESFSpecificLocalService.updateESFFederalRoleESFSpecific(esfFederalRoleESFSpecific);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _esfFederalRoleESFSpecificLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_esfFederalRoleESFSpecificLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _esfFederalRoleESFSpecificLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFFederalRoleESFSpecific> findByESFFederalRoleId(
		long esfFederalRoleId) {
		return _esfFederalRoleESFSpecificLocalService.findByESFFederalRoleId(esfFederalRoleId);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFFederalRoleESFSpecific> findBySpecificId(
		long esfSpecificId) {
		return _esfFederalRoleESFSpecificLocalService.findBySpecificId(esfSpecificId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ESFFederalRoleESFSpecificLocalService getWrappedESFFederalRoleESFSpecificLocalService() {
		return _esfFederalRoleESFSpecificLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedESFFederalRoleESFSpecificLocalService(
		ESFFederalRoleESFSpecificLocalService esfFederalRoleESFSpecificLocalService) {
		_esfFederalRoleESFSpecificLocalService = esfFederalRoleESFSpecificLocalService;
	}

	@Override
	public ESFFederalRoleESFSpecificLocalService getWrappedService() {
		return _esfFederalRoleESFSpecificLocalService;
	}

	@Override
	public void setWrappedService(
		ESFFederalRoleESFSpecificLocalService esfFederalRoleESFSpecificLocalService) {
		_esfFederalRoleESFSpecificLocalService = esfFederalRoleESFSpecificLocalService;
	}

	private ESFFederalRoleESFSpecificLocalService _esfFederalRoleESFSpecificLocalService;
}