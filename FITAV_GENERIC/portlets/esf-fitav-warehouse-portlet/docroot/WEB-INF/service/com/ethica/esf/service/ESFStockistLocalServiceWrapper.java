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

package com.ethica.esf.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ESFStockistLocalService}.
 *
 * @author Ethica
 * @see ESFStockistLocalService
 * @generated
 */
public class ESFStockistLocalServiceWrapper implements ESFStockistLocalService,
	ServiceWrapper<ESFStockistLocalService> {
	public ESFStockistLocalServiceWrapper(
		ESFStockistLocalService esfStockistLocalService) {
		_esfStockistLocalService = esfStockistLocalService;
	}

	/**
	* Adds the e s f stockist to the database. Also notifies the appropriate model listeners.
	*
	* @param esfStockist the e s f stockist
	* @return the e s f stockist that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ethica.esf.model.ESFStockist addESFStockist(
		com.ethica.esf.model.ESFStockist esfStockist)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfStockistLocalService.addESFStockist(esfStockist);
	}

	/**
	* Creates a new e s f stockist with the primary key. Does not add the e s f stockist to the database.
	*
	* @param esfStockistId the primary key for the new e s f stockist
	* @return the new e s f stockist
	*/
	@Override
	public com.ethica.esf.model.ESFStockist createESFStockist(
		long esfStockistId) {
		return _esfStockistLocalService.createESFStockist(esfStockistId);
	}

	/**
	* Deletes the e s f stockist with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfStockistId the primary key of the e s f stockist
	* @return the e s f stockist that was removed
	* @throws PortalException if a e s f stockist with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ethica.esf.model.ESFStockist deleteESFStockist(
		long esfStockistId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfStockistLocalService.deleteESFStockist(esfStockistId);
	}

	/**
	* Deletes the e s f stockist from the database. Also notifies the appropriate model listeners.
	*
	* @param esfStockist the e s f stockist
	* @return the e s f stockist that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ethica.esf.model.ESFStockist deleteESFStockist(
		com.ethica.esf.model.ESFStockist esfStockist)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfStockistLocalService.deleteESFStockist(esfStockist);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _esfStockistLocalService.dynamicQuery();
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
		return _esfStockistLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ethica.esf.model.impl.ESFStockistModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _esfStockistLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ethica.esf.model.impl.ESFStockistModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _esfStockistLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _esfStockistLocalService.dynamicQueryCount(dynamicQuery);
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
		return _esfStockistLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.ethica.esf.model.ESFStockist fetchESFStockist(long esfStockistId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfStockistLocalService.fetchESFStockist(esfStockistId);
	}

	/**
	* Returns the e s f stockist with the primary key.
	*
	* @param esfStockistId the primary key of the e s f stockist
	* @return the e s f stockist
	* @throws PortalException if a e s f stockist with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ethica.esf.model.ESFStockist getESFStockist(long esfStockistId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfStockistLocalService.getESFStockist(esfStockistId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfStockistLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the e s f stockists.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ethica.esf.model.impl.ESFStockistModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f stockists
	* @param end the upper bound of the range of e s f stockists (not inclusive)
	* @return the range of e s f stockists
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.ethica.esf.model.ESFStockist> getESFStockists(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfStockistLocalService.getESFStockists(start, end);
	}

	/**
	* Returns the number of e s f stockists.
	*
	* @return the number of e s f stockists
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getESFStockistsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfStockistLocalService.getESFStockistsCount();
	}

	/**
	* Updates the e s f stockist in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param esfStockist the e s f stockist
	* @return the e s f stockist that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ethica.esf.model.ESFStockist updateESFStockist(
		com.ethica.esf.model.ESFStockist esfStockist)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfStockistLocalService.updateESFStockist(esfStockist);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _esfStockistLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_esfStockistLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _esfStockistLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.ethica.esf.model.ESFStockist addESFStockist(
		java.lang.String name, java.lang.String email, java.lang.String phone,
		java.lang.String address, java.lang.String nameReference,
		java.lang.String lastNameReference, java.lang.String emailReference,
		java.lang.String phoneReference, java.lang.String description,
		java.lang.String other)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfStockistLocalService.addESFStockist(name, email, phone,
			address, nameReference, lastNameReference, emailReference,
			phoneReference, description, other);
	}

	@Override
	public com.ethica.esf.model.ESFStockist updateESFStockist(
		long esfStockistId, java.lang.String name, java.lang.String email,
		java.lang.String phone, java.lang.String address,
		java.lang.String nameReference, java.lang.String lastNameReference,
		java.lang.String emailReference, java.lang.String phoneReference,
		java.lang.String description, java.lang.String other)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfStockistLocalService.updateESFStockist(esfStockistId, name,
			email, phone, address, nameReference, lastNameReference,
			emailReference, phoneReference, description, other);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ESFStockistLocalService getWrappedESFStockistLocalService() {
		return _esfStockistLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedESFStockistLocalService(
		ESFStockistLocalService esfStockistLocalService) {
		_esfStockistLocalService = esfStockistLocalService;
	}

	@Override
	public ESFStockistLocalService getWrappedService() {
		return _esfStockistLocalService;
	}

	@Override
	public void setWrappedService(
		ESFStockistLocalService esfStockistLocalService) {
		_esfStockistLocalService = esfStockistLocalService;
	}

	private ESFStockistLocalService _esfStockistLocalService;
}