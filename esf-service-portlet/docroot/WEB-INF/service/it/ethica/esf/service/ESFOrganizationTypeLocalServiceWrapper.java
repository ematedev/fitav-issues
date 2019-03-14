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
 * Provides a wrapper for {@link ESFOrganizationTypeLocalService}.
 *
 * @author Ethica
 * @see ESFOrganizationTypeLocalService
 * @generated
 */
public class ESFOrganizationTypeLocalServiceWrapper
	implements ESFOrganizationTypeLocalService,
		ServiceWrapper<ESFOrganizationTypeLocalService> {
	public ESFOrganizationTypeLocalServiceWrapper(
		ESFOrganizationTypeLocalService esfOrganizationTypeLocalService) {
		_esfOrganizationTypeLocalService = esfOrganizationTypeLocalService;
	}

	/**
	* Adds the e s f organization type to the database. Also notifies the appropriate model listeners.
	*
	* @param esfOrganizationType the e s f organization type
	* @return the e s f organization type that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFOrganizationType addESFOrganizationType(
		it.ethica.esf.model.ESFOrganizationType esfOrganizationType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfOrganizationTypeLocalService.addESFOrganizationType(esfOrganizationType);
	}

	/**
	* Creates a new e s f organization type with the primary key. Does not add the e s f organization type to the database.
	*
	* @param esfOrganizationTypeId the primary key for the new e s f organization type
	* @return the new e s f organization type
	*/
	@Override
	public it.ethica.esf.model.ESFOrganizationType createESFOrganizationType(
		long esfOrganizationTypeId) {
		return _esfOrganizationTypeLocalService.createESFOrganizationType(esfOrganizationTypeId);
	}

	/**
	* Deletes the e s f organization type with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfOrganizationTypeId the primary key of the e s f organization type
	* @return the e s f organization type that was removed
	* @throws PortalException if a e s f organization type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFOrganizationType deleteESFOrganizationType(
		long esfOrganizationTypeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfOrganizationTypeLocalService.deleteESFOrganizationType(esfOrganizationTypeId);
	}

	/**
	* Deletes the e s f organization type from the database. Also notifies the appropriate model listeners.
	*
	* @param esfOrganizationType the e s f organization type
	* @return the e s f organization type that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFOrganizationType deleteESFOrganizationType(
		it.ethica.esf.model.ESFOrganizationType esfOrganizationType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfOrganizationTypeLocalService.deleteESFOrganizationType(esfOrganizationType);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _esfOrganizationTypeLocalService.dynamicQuery();
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
		return _esfOrganizationTypeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFOrganizationTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _esfOrganizationTypeLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFOrganizationTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _esfOrganizationTypeLocalService.dynamicQuery(dynamicQuery,
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
		return _esfOrganizationTypeLocalService.dynamicQueryCount(dynamicQuery);
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
		return _esfOrganizationTypeLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public it.ethica.esf.model.ESFOrganizationType fetchESFOrganizationType(
		long esfOrganizationTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfOrganizationTypeLocalService.fetchESFOrganizationType(esfOrganizationTypeId);
	}

	/**
	* Returns the e s f organization type with the primary key.
	*
	* @param esfOrganizationTypeId the primary key of the e s f organization type
	* @return the e s f organization type
	* @throws PortalException if a e s f organization type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFOrganizationType getESFOrganizationType(
		long esfOrganizationTypeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfOrganizationTypeLocalService.getESFOrganizationType(esfOrganizationTypeId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfOrganizationTypeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the e s f organization types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFOrganizationTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f organization types
	* @param end the upper bound of the range of e s f organization types (not inclusive)
	* @return the range of e s f organization types
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<it.ethica.esf.model.ESFOrganizationType> getESFOrganizationTypes(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfOrganizationTypeLocalService.getESFOrganizationTypes(start,
			end);
	}

	/**
	* Returns the number of e s f organization types.
	*
	* @return the number of e s f organization types
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getESFOrganizationTypesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfOrganizationTypeLocalService.getESFOrganizationTypesCount();
	}

	/**
	* Updates the e s f organization type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param esfOrganizationType the e s f organization type
	* @return the e s f organization type that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFOrganizationType updateESFOrganizationType(
		it.ethica.esf.model.ESFOrganizationType esfOrganizationType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfOrganizationTypeLocalService.updateESFOrganizationType(esfOrganizationType);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _esfOrganizationTypeLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_esfOrganizationTypeLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _esfOrganizationTypeLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public java.util.List<java.lang.String> getOrganizationTypes(
		long esfOrganizationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfOrganizationTypeLocalService.getOrganizationTypes(esfOrganizationId);
	}

	@Override
	public it.ethica.esf.model.ESFOrganizationType addESFOrganizationType(
		long userId, long esfTypeId, long esfOrganizationId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfOrganizationTypeLocalService.addESFOrganizationType(userId,
			esfTypeId, esfOrganizationId, serviceContext);
	}

	@Override
	public it.ethica.esf.model.ESFOrganizationType deleteESFOrganizationType(
		long esfOrganizationTypeId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfOrganizationTypeLocalService.deleteESFOrganizationType(esfOrganizationTypeId,
			serviceContext);
	}

	@Override
	public it.ethica.esf.model.ESFOrganizationType updateESFOrganizationType(
		long userId, long esfOrganizationTypeId, long esfTypeId,
		long esfOrganizationId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfOrganizationTypeLocalService.updateESFOrganizationType(userId,
			esfOrganizationTypeId, esfTypeId, esfOrganizationId, serviceContext);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ESFOrganizationTypeLocalService getWrappedESFOrganizationTypeLocalService() {
		return _esfOrganizationTypeLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedESFOrganizationTypeLocalService(
		ESFOrganizationTypeLocalService esfOrganizationTypeLocalService) {
		_esfOrganizationTypeLocalService = esfOrganizationTypeLocalService;
	}

	@Override
	public ESFOrganizationTypeLocalService getWrappedService() {
		return _esfOrganizationTypeLocalService;
	}

	@Override
	public void setWrappedService(
		ESFOrganizationTypeLocalService esfOrganizationTypeLocalService) {
		_esfOrganizationTypeLocalService = esfOrganizationTypeLocalService;
	}

	private ESFOrganizationTypeLocalService _esfOrganizationTypeLocalService;
}