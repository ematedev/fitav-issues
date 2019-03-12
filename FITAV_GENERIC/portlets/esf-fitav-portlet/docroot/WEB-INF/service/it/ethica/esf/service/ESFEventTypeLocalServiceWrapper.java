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
 * Provides a wrapper for {@link ESFEventTypeLocalService}.
 *
 * @author Ethica
 * @see ESFEventTypeLocalService
 * @generated
 */
public class ESFEventTypeLocalServiceWrapper implements ESFEventTypeLocalService,
	ServiceWrapper<ESFEventTypeLocalService> {
	public ESFEventTypeLocalServiceWrapper(
		ESFEventTypeLocalService esfEventTypeLocalService) {
		_esfEventTypeLocalService = esfEventTypeLocalService;
	}

	/**
	* Adds the e s f event type to the database. Also notifies the appropriate model listeners.
	*
	* @param esfEventType the e s f event type
	* @return the e s f event type that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFEventType addESFEventType(
		it.ethica.esf.model.ESFEventType esfEventType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfEventTypeLocalService.addESFEventType(esfEventType);
	}

	/**
	* Creates a new e s f event type with the primary key. Does not add the e s f event type to the database.
	*
	* @param esfEventTypeId the primary key for the new e s f event type
	* @return the new e s f event type
	*/
	@Override
	public it.ethica.esf.model.ESFEventType createESFEventType(
		long esfEventTypeId) {
		return _esfEventTypeLocalService.createESFEventType(esfEventTypeId);
	}

	/**
	* Deletes the e s f event type with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfEventTypeId the primary key of the e s f event type
	* @return the e s f event type that was removed
	* @throws PortalException if a e s f event type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFEventType deleteESFEventType(
		long esfEventTypeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfEventTypeLocalService.deleteESFEventType(esfEventTypeId);
	}

	/**
	* Deletes the e s f event type from the database. Also notifies the appropriate model listeners.
	*
	* @param esfEventType the e s f event type
	* @return the e s f event type that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFEventType deleteESFEventType(
		it.ethica.esf.model.ESFEventType esfEventType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfEventTypeLocalService.deleteESFEventType(esfEventType);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _esfEventTypeLocalService.dynamicQuery();
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
		return _esfEventTypeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFEventTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _esfEventTypeLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFEventTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _esfEventTypeLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _esfEventTypeLocalService.dynamicQueryCount(dynamicQuery);
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
		return _esfEventTypeLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public it.ethica.esf.model.ESFEventType fetchESFEventType(
		long esfEventTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfEventTypeLocalService.fetchESFEventType(esfEventTypeId);
	}

	/**
	* Returns the e s f event type with the primary key.
	*
	* @param esfEventTypeId the primary key of the e s f event type
	* @return the e s f event type
	* @throws PortalException if a e s f event type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFEventType getESFEventType(long esfEventTypeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfEventTypeLocalService.getESFEventType(esfEventTypeId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfEventTypeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the e s f event types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFEventTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f event types
	* @param end the upper bound of the range of e s f event types (not inclusive)
	* @return the range of e s f event types
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<it.ethica.esf.model.ESFEventType> getESFEventTypes(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfEventTypeLocalService.getESFEventTypes(start, end);
	}

	/**
	* Returns the number of e s f event types.
	*
	* @return the number of e s f event types
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getESFEventTypesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfEventTypeLocalService.getESFEventTypesCount();
	}

	/**
	* Updates the e s f event type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param esfEventType the e s f event type
	* @return the e s f event type that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFEventType updateESFEventType(
		it.ethica.esf.model.ESFEventType esfEventType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfEventTypeLocalService.updateESFEventType(esfEventType);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _esfEventTypeLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_esfEventTypeLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _esfEventTypeLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFEventType> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfEventTypeLocalService.findAll();
	}

	@Override
	public it.ethica.esf.model.ESFEventType addEsfEventType(long groupId,
		long companyId, java.lang.String userName, long esfUserId,
		java.util.Date createDate, java.lang.String macrocategory,
		java.lang.String eventType,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfEventTypeLocalService.addEsfEventType(groupId, companyId,
			userName, esfUserId, createDate, macrocategory, eventType,
			serviceContext);
	}

	@Override
	public it.ethica.esf.model.ESFEventType updateEsfEventType(
		long esfEventTypeId, long groupId, long companyId,
		java.lang.String userName, long esfUserId, java.util.Date modifiedDate,
		java.lang.String macrocategory, java.lang.String eventType,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfEventTypeLocalService.updateEsfEventType(esfEventTypeId,
			groupId, companyId, userName, esfUserId, modifiedDate,
			macrocategory, eventType, serviceContext);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ESFEventTypeLocalService getWrappedESFEventTypeLocalService() {
		return _esfEventTypeLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedESFEventTypeLocalService(
		ESFEventTypeLocalService esfEventTypeLocalService) {
		_esfEventTypeLocalService = esfEventTypeLocalService;
	}

	@Override
	public ESFEventTypeLocalService getWrappedService() {
		return _esfEventTypeLocalService;
	}

	@Override
	public void setWrappedService(
		ESFEventTypeLocalService esfEventTypeLocalService) {
		_esfEventTypeLocalService = esfEventTypeLocalService;
	}

	private ESFEventTypeLocalService _esfEventTypeLocalService;
}