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
 * Provides a wrapper for {@link ESFSpecificLocalService}.
 *
 * @author Ethica
 * @see ESFSpecificLocalService
 * @generated
 */
public class ESFSpecificLocalServiceWrapper implements ESFSpecificLocalService,
	ServiceWrapper<ESFSpecificLocalService> {
	public ESFSpecificLocalServiceWrapper(
		ESFSpecificLocalService esfSpecificLocalService) {
		_esfSpecificLocalService = esfSpecificLocalService;
	}

	/**
	* Adds the e s f specific to the database. Also notifies the appropriate model listeners.
	*
	* @param esfSpecific the e s f specific
	* @return the e s f specific that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFSpecific addESFSpecific(
		it.ethica.esf.model.ESFSpecific esfSpecific)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfSpecificLocalService.addESFSpecific(esfSpecific);
	}

	/**
	* Creates a new e s f specific with the primary key. Does not add the e s f specific to the database.
	*
	* @param esfSpecificId the primary key for the new e s f specific
	* @return the new e s f specific
	*/
	@Override
	public it.ethica.esf.model.ESFSpecific createESFSpecific(long esfSpecificId) {
		return _esfSpecificLocalService.createESFSpecific(esfSpecificId);
	}

	/**
	* Deletes the e s f specific with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfSpecificId the primary key of the e s f specific
	* @return the e s f specific that was removed
	* @throws PortalException if a e s f specific with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFSpecific deleteESFSpecific(long esfSpecificId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfSpecificLocalService.deleteESFSpecific(esfSpecificId);
	}

	/**
	* Deletes the e s f specific from the database. Also notifies the appropriate model listeners.
	*
	* @param esfSpecific the e s f specific
	* @return the e s f specific that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFSpecific deleteESFSpecific(
		it.ethica.esf.model.ESFSpecific esfSpecific)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfSpecificLocalService.deleteESFSpecific(esfSpecific);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _esfSpecificLocalService.dynamicQuery();
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
		return _esfSpecificLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFSpecificModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _esfSpecificLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFSpecificModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _esfSpecificLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _esfSpecificLocalService.dynamicQueryCount(dynamicQuery);
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
		return _esfSpecificLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public it.ethica.esf.model.ESFSpecific fetchESFSpecific(long esfSpecificId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfSpecificLocalService.fetchESFSpecific(esfSpecificId);
	}

	/**
	* Returns the e s f specific with the matching UUID and company.
	*
	* @param uuid the e s f specific's UUID
	* @param companyId the primary key of the company
	* @return the matching e s f specific, or <code>null</code> if a matching e s f specific could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFSpecific fetchESFSpecificByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfSpecificLocalService.fetchESFSpecificByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the e s f specific matching the UUID and group.
	*
	* @param uuid the e s f specific's UUID
	* @param groupId the primary key of the group
	* @return the matching e s f specific, or <code>null</code> if a matching e s f specific could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFSpecific fetchESFSpecificByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfSpecificLocalService.fetchESFSpecificByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns the e s f specific with the primary key.
	*
	* @param esfSpecificId the primary key of the e s f specific
	* @return the e s f specific
	* @throws PortalException if a e s f specific with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFSpecific getESFSpecific(long esfSpecificId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfSpecificLocalService.getESFSpecific(esfSpecificId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfSpecificLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the e s f specific with the matching UUID and company.
	*
	* @param uuid the e s f specific's UUID
	* @param companyId the primary key of the company
	* @return the matching e s f specific
	* @throws PortalException if a matching e s f specific could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFSpecific getESFSpecificByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfSpecificLocalService.getESFSpecificByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the e s f specific matching the UUID and group.
	*
	* @param uuid the e s f specific's UUID
	* @param groupId the primary key of the group
	* @return the matching e s f specific
	* @throws PortalException if a matching e s f specific could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFSpecific getESFSpecificByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfSpecificLocalService.getESFSpecificByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns a range of all the e s f specifics.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFSpecificModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f specifics
	* @param end the upper bound of the range of e s f specifics (not inclusive)
	* @return the range of e s f specifics
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<it.ethica.esf.model.ESFSpecific> getESFSpecifics(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfSpecificLocalService.getESFSpecifics(start, end);
	}

	/**
	* Returns the number of e s f specifics.
	*
	* @return the number of e s f specifics
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getESFSpecificsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfSpecificLocalService.getESFSpecificsCount();
	}

	/**
	* Updates the e s f specific in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param esfSpecific the e s f specific
	* @return the e s f specific that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFSpecific updateESFSpecific(
		it.ethica.esf.model.ESFSpecific esfSpecific)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfSpecificLocalService.updateESFSpecific(esfSpecific);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _esfSpecificLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_esfSpecificLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _esfSpecificLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ESFSpecificLocalService getWrappedESFSpecificLocalService() {
		return _esfSpecificLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedESFSpecificLocalService(
		ESFSpecificLocalService esfSpecificLocalService) {
		_esfSpecificLocalService = esfSpecificLocalService;
	}

	@Override
	public ESFSpecificLocalService getWrappedService() {
		return _esfSpecificLocalService;
	}

	@Override
	public void setWrappedService(
		ESFSpecificLocalService esfSpecificLocalService) {
		_esfSpecificLocalService = esfSpecificLocalService;
	}

	private ESFSpecificLocalService _esfSpecificLocalService;
}