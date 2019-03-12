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
 * Provides a wrapper for {@link ESFPartecipantTypeLocalService}.
 *
 * @author Ethica
 * @see ESFPartecipantTypeLocalService
 * @generated
 */
public class ESFPartecipantTypeLocalServiceWrapper
	implements ESFPartecipantTypeLocalService,
		ServiceWrapper<ESFPartecipantTypeLocalService> {
	public ESFPartecipantTypeLocalServiceWrapper(
		ESFPartecipantTypeLocalService esfPartecipantTypeLocalService) {
		_esfPartecipantTypeLocalService = esfPartecipantTypeLocalService;
	}

	/**
	* Adds the e s f partecipant type to the database. Also notifies the appropriate model listeners.
	*
	* @param esfPartecipantType the e s f partecipant type
	* @return the e s f partecipant type that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFPartecipantType addESFPartecipantType(
		it.ethica.esf.model.ESFPartecipantType esfPartecipantType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfPartecipantTypeLocalService.addESFPartecipantType(esfPartecipantType);
	}

	/**
	* Creates a new e s f partecipant type with the primary key. Does not add the e s f partecipant type to the database.
	*
	* @param esfPartecipantTypeId the primary key for the new e s f partecipant type
	* @return the new e s f partecipant type
	*/
	@Override
	public it.ethica.esf.model.ESFPartecipantType createESFPartecipantType(
		long esfPartecipantTypeId) {
		return _esfPartecipantTypeLocalService.createESFPartecipantType(esfPartecipantTypeId);
	}

	/**
	* Deletes the e s f partecipant type with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfPartecipantTypeId the primary key of the e s f partecipant type
	* @return the e s f partecipant type that was removed
	* @throws PortalException if a e s f partecipant type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFPartecipantType deleteESFPartecipantType(
		long esfPartecipantTypeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfPartecipantTypeLocalService.deleteESFPartecipantType(esfPartecipantTypeId);
	}

	/**
	* Deletes the e s f partecipant type from the database. Also notifies the appropriate model listeners.
	*
	* @param esfPartecipantType the e s f partecipant type
	* @return the e s f partecipant type that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFPartecipantType deleteESFPartecipantType(
		it.ethica.esf.model.ESFPartecipantType esfPartecipantType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfPartecipantTypeLocalService.deleteESFPartecipantType(esfPartecipantType);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _esfPartecipantTypeLocalService.dynamicQuery();
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
		return _esfPartecipantTypeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFPartecipantTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _esfPartecipantTypeLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFPartecipantTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _esfPartecipantTypeLocalService.dynamicQuery(dynamicQuery,
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
		return _esfPartecipantTypeLocalService.dynamicQueryCount(dynamicQuery);
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
		return _esfPartecipantTypeLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public it.ethica.esf.model.ESFPartecipantType fetchESFPartecipantType(
		long esfPartecipantTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfPartecipantTypeLocalService.fetchESFPartecipantType(esfPartecipantTypeId);
	}

	/**
	* Returns the e s f partecipant type with the primary key.
	*
	* @param esfPartecipantTypeId the primary key of the e s f partecipant type
	* @return the e s f partecipant type
	* @throws PortalException if a e s f partecipant type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFPartecipantType getESFPartecipantType(
		long esfPartecipantTypeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfPartecipantTypeLocalService.getESFPartecipantType(esfPartecipantTypeId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfPartecipantTypeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the e s f partecipant types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFPartecipantTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f partecipant types
	* @param end the upper bound of the range of e s f partecipant types (not inclusive)
	* @return the range of e s f partecipant types
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<it.ethica.esf.model.ESFPartecipantType> getESFPartecipantTypes(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfPartecipantTypeLocalService.getESFPartecipantTypes(start, end);
	}

	/**
	* Returns the number of e s f partecipant types.
	*
	* @return the number of e s f partecipant types
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getESFPartecipantTypesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfPartecipantTypeLocalService.getESFPartecipantTypesCount();
	}

	/**
	* Updates the e s f partecipant type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param esfPartecipantType the e s f partecipant type
	* @return the e s f partecipant type that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFPartecipantType updateESFPartecipantType(
		it.ethica.esf.model.ESFPartecipantType esfPartecipantType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfPartecipantTypeLocalService.updateESFPartecipantType(esfPartecipantType);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _esfPartecipantTypeLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_esfPartecipantTypeLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _esfPartecipantTypeLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ESFPartecipantTypeLocalService getWrappedESFPartecipantTypeLocalService() {
		return _esfPartecipantTypeLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedESFPartecipantTypeLocalService(
		ESFPartecipantTypeLocalService esfPartecipantTypeLocalService) {
		_esfPartecipantTypeLocalService = esfPartecipantTypeLocalService;
	}

	@Override
	public ESFPartecipantTypeLocalService getWrappedService() {
		return _esfPartecipantTypeLocalService;
	}

	@Override
	public void setWrappedService(
		ESFPartecipantTypeLocalService esfPartecipantTypeLocalService) {
		_esfPartecipantTypeLocalService = esfPartecipantTypeLocalService;
	}

	private ESFPartecipantTypeLocalService _esfPartecipantTypeLocalService;
}