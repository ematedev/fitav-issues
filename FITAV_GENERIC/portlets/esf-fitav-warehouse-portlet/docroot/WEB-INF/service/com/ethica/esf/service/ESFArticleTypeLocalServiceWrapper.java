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
 * Provides a wrapper for {@link ESFArticleTypeLocalService}.
 *
 * @author Ethica
 * @see ESFArticleTypeLocalService
 * @generated
 */
public class ESFArticleTypeLocalServiceWrapper
	implements ESFArticleTypeLocalService,
		ServiceWrapper<ESFArticleTypeLocalService> {
	public ESFArticleTypeLocalServiceWrapper(
		ESFArticleTypeLocalService esfArticleTypeLocalService) {
		_esfArticleTypeLocalService = esfArticleTypeLocalService;
	}

	/**
	* Adds the e s f article type to the database. Also notifies the appropriate model listeners.
	*
	* @param esfArticleType the e s f article type
	* @return the e s f article type that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ethica.esf.model.ESFArticleType addESFArticleType(
		com.ethica.esf.model.ESFArticleType esfArticleType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfArticleTypeLocalService.addESFArticleType(esfArticleType);
	}

	/**
	* Creates a new e s f article type with the primary key. Does not add the e s f article type to the database.
	*
	* @param esfArticleTypeId the primary key for the new e s f article type
	* @return the new e s f article type
	*/
	@Override
	public com.ethica.esf.model.ESFArticleType createESFArticleType(
		long esfArticleTypeId) {
		return _esfArticleTypeLocalService.createESFArticleType(esfArticleTypeId);
	}

	/**
	* Deletes the e s f article type with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfArticleTypeId the primary key of the e s f article type
	* @return the e s f article type that was removed
	* @throws PortalException if a e s f article type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ethica.esf.model.ESFArticleType deleteESFArticleType(
		long esfArticleTypeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfArticleTypeLocalService.deleteESFArticleType(esfArticleTypeId);
	}

	/**
	* Deletes the e s f article type from the database. Also notifies the appropriate model listeners.
	*
	* @param esfArticleType the e s f article type
	* @return the e s f article type that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ethica.esf.model.ESFArticleType deleteESFArticleType(
		com.ethica.esf.model.ESFArticleType esfArticleType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfArticleTypeLocalService.deleteESFArticleType(esfArticleType);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _esfArticleTypeLocalService.dynamicQuery();
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
		return _esfArticleTypeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ethica.esf.model.impl.ESFArticleTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _esfArticleTypeLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ethica.esf.model.impl.ESFArticleTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _esfArticleTypeLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
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
		return _esfArticleTypeLocalService.dynamicQueryCount(dynamicQuery);
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
		return _esfArticleTypeLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.ethica.esf.model.ESFArticleType fetchESFArticleType(
		long esfArticleTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfArticleTypeLocalService.fetchESFArticleType(esfArticleTypeId);
	}

	/**
	* Returns the e s f article type with the primary key.
	*
	* @param esfArticleTypeId the primary key of the e s f article type
	* @return the e s f article type
	* @throws PortalException if a e s f article type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ethica.esf.model.ESFArticleType getESFArticleType(
		long esfArticleTypeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfArticleTypeLocalService.getESFArticleType(esfArticleTypeId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfArticleTypeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the e s f article types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ethica.esf.model.impl.ESFArticleTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f article types
	* @param end the upper bound of the range of e s f article types (not inclusive)
	* @return the range of e s f article types
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.ethica.esf.model.ESFArticleType> getESFArticleTypes(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfArticleTypeLocalService.getESFArticleTypes(start, end);
	}

	/**
	* Returns the number of e s f article types.
	*
	* @return the number of e s f article types
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getESFArticleTypesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfArticleTypeLocalService.getESFArticleTypesCount();
	}

	/**
	* Updates the e s f article type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param esfArticleType the e s f article type
	* @return the e s f article type that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ethica.esf.model.ESFArticleType updateESFArticleType(
		com.ethica.esf.model.ESFArticleType esfArticleType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfArticleTypeLocalService.updateESFArticleType(esfArticleType);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _esfArticleTypeLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_esfArticleTypeLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _esfArticleTypeLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.ethica.esf.model.ESFArticleType addESFArticleType(
		java.lang.String description, java.lang.String area,
		java.lang.String department)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfArticleTypeLocalService.addESFArticleType(description, area,
			department);
	}

	@Override
	public com.ethica.esf.model.ESFArticleType updateESFArticleType(
		long esfArticleTypeId, java.lang.String description,
		java.lang.String area, java.lang.String department)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfArticleTypeLocalService.updateESFArticleType(esfArticleTypeId,
			description, area, department);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ESFArticleTypeLocalService getWrappedESFArticleTypeLocalService() {
		return _esfArticleTypeLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedESFArticleTypeLocalService(
		ESFArticleTypeLocalService esfArticleTypeLocalService) {
		_esfArticleTypeLocalService = esfArticleTypeLocalService;
	}

	@Override
	public ESFArticleTypeLocalService getWrappedService() {
		return _esfArticleTypeLocalService;
	}

	@Override
	public void setWrappedService(
		ESFArticleTypeLocalService esfArticleTypeLocalService) {
		_esfArticleTypeLocalService = esfArticleTypeLocalService;
	}

	private ESFArticleTypeLocalService _esfArticleTypeLocalService;
}