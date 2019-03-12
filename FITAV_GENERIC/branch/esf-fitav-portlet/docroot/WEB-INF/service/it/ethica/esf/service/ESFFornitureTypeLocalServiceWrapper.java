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
 * Provides a wrapper for {@link ESFFornitureTypeLocalService}.
 *
 * @author Ethica
 * @see ESFFornitureTypeLocalService
 * @generated
 */
public class ESFFornitureTypeLocalServiceWrapper
	implements ESFFornitureTypeLocalService,
		ServiceWrapper<ESFFornitureTypeLocalService> {
	public ESFFornitureTypeLocalServiceWrapper(
		ESFFornitureTypeLocalService esfFornitureTypeLocalService) {
		_esfFornitureTypeLocalService = esfFornitureTypeLocalService;
	}

	/**
	* Adds the e s f forniture type to the database. Also notifies the appropriate model listeners.
	*
	* @param esfFornitureType the e s f forniture type
	* @return the e s f forniture type that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFFornitureType addESFFornitureType(
		it.ethica.esf.model.ESFFornitureType esfFornitureType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfFornitureTypeLocalService.addESFFornitureType(esfFornitureType);
	}

	/**
	* Creates a new e s f forniture type with the primary key. Does not add the e s f forniture type to the database.
	*
	* @param esfFornitureTypeId the primary key for the new e s f forniture type
	* @return the new e s f forniture type
	*/
	@Override
	public it.ethica.esf.model.ESFFornitureType createESFFornitureType(
		long esfFornitureTypeId) {
		return _esfFornitureTypeLocalService.createESFFornitureType(esfFornitureTypeId);
	}

	/**
	* Deletes the e s f forniture type with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfFornitureTypeId the primary key of the e s f forniture type
	* @return the e s f forniture type that was removed
	* @throws PortalException if a e s f forniture type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFFornitureType deleteESFFornitureType(
		long esfFornitureTypeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfFornitureTypeLocalService.deleteESFFornitureType(esfFornitureTypeId);
	}

	/**
	* Deletes the e s f forniture type from the database. Also notifies the appropriate model listeners.
	*
	* @param esfFornitureType the e s f forniture type
	* @return the e s f forniture type that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFFornitureType deleteESFFornitureType(
		it.ethica.esf.model.ESFFornitureType esfFornitureType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfFornitureTypeLocalService.deleteESFFornitureType(esfFornitureType);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _esfFornitureTypeLocalService.dynamicQuery();
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
		return _esfFornitureTypeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFornitureTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _esfFornitureTypeLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFornitureTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _esfFornitureTypeLocalService.dynamicQuery(dynamicQuery, start,
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
		return _esfFornitureTypeLocalService.dynamicQueryCount(dynamicQuery);
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
		return _esfFornitureTypeLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public it.ethica.esf.model.ESFFornitureType fetchESFFornitureType(
		long esfFornitureTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfFornitureTypeLocalService.fetchESFFornitureType(esfFornitureTypeId);
	}

	/**
	* Returns the e s f forniture type with the matching UUID and company.
	*
	* @param uuid the e s f forniture type's UUID
	* @param companyId the primary key of the company
	* @return the matching e s f forniture type, or <code>null</code> if a matching e s f forniture type could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFFornitureType fetchESFFornitureTypeByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfFornitureTypeLocalService.fetchESFFornitureTypeByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the e s f forniture type matching the UUID and group.
	*
	* @param uuid the e s f forniture type's UUID
	* @param groupId the primary key of the group
	* @return the matching e s f forniture type, or <code>null</code> if a matching e s f forniture type could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFFornitureType fetchESFFornitureTypeByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfFornitureTypeLocalService.fetchESFFornitureTypeByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns the e s f forniture type with the primary key.
	*
	* @param esfFornitureTypeId the primary key of the e s f forniture type
	* @return the e s f forniture type
	* @throws PortalException if a e s f forniture type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFFornitureType getESFFornitureType(
		long esfFornitureTypeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfFornitureTypeLocalService.getESFFornitureType(esfFornitureTypeId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfFornitureTypeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the e s f forniture type with the matching UUID and company.
	*
	* @param uuid the e s f forniture type's UUID
	* @param companyId the primary key of the company
	* @return the matching e s f forniture type
	* @throws PortalException if a matching e s f forniture type could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFFornitureType getESFFornitureTypeByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfFornitureTypeLocalService.getESFFornitureTypeByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the e s f forniture type matching the UUID and group.
	*
	* @param uuid the e s f forniture type's UUID
	* @param groupId the primary key of the group
	* @return the matching e s f forniture type
	* @throws PortalException if a matching e s f forniture type could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFFornitureType getESFFornitureTypeByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfFornitureTypeLocalService.getESFFornitureTypeByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns a range of all the e s f forniture types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFornitureTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f forniture types
	* @param end the upper bound of the range of e s f forniture types (not inclusive)
	* @return the range of e s f forniture types
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<it.ethica.esf.model.ESFFornitureType> getESFFornitureTypes(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfFornitureTypeLocalService.getESFFornitureTypes(start, end);
	}

	/**
	* Returns the number of e s f forniture types.
	*
	* @return the number of e s f forniture types
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getESFFornitureTypesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfFornitureTypeLocalService.getESFFornitureTypesCount();
	}

	/**
	* Updates the e s f forniture type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param esfFornitureType the e s f forniture type
	* @return the e s f forniture type that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFFornitureType updateESFFornitureType(
		it.ethica.esf.model.ESFFornitureType esfFornitureType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfFornitureTypeLocalService.updateESFFornitureType(esfFornitureType);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _esfFornitureTypeLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_esfFornitureTypeLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _esfFornitureTypeLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFFornitureType> getAllESFFornitureTypes()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfFornitureTypeLocalService.getAllESFFornitureTypes();
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFFornitureType> getAllESFFornitureTypes(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfFornitureTypeLocalService.getAllESFFornitureTypes(start, end);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFFornitureType> getAllESFFornitureTypes(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfFornitureTypeLocalService.getAllESFFornitureTypes(groupId);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFFornitureType> getAllESFFornitureTypes(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfFornitureTypeLocalService.getAllESFFornitureTypes(groupId,
			start, end);
	}

	@Override
	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfFornitureTypeLocalService.countByGroupId(groupId);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFFornitureType> findESFFornitureTypeByDescription(
		java.lang.String description)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfFornitureTypeLocalService.findESFFornitureTypeByDescription(description);
	}

	@Override
	public it.ethica.esf.model.ESFFornitureType addESFForntureType(
		long userId, java.lang.String description,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfFornitureTypeLocalService.addESFForntureType(userId,
			description, serviceContext);
	}

	@Override
	public it.ethica.esf.model.ESFFornitureType updateESFFornitureType(
		long userId, long esfFornitureTypeId, java.lang.String description,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfFornitureTypeLocalService.updateESFFornitureType(userId,
			esfFornitureTypeId, description, serviceContext);
	}

	@Override
	public it.ethica.esf.model.ESFFornitureType deleteESFFornitureType(
		long esfFornitureTypeId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfFornitureTypeLocalService.deleteESFFornitureType(esfFornitureTypeId,
			serviceContext);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ESFFornitureTypeLocalService getWrappedESFFornitureTypeLocalService() {
		return _esfFornitureTypeLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedESFFornitureTypeLocalService(
		ESFFornitureTypeLocalService esfFornitureTypeLocalService) {
		_esfFornitureTypeLocalService = esfFornitureTypeLocalService;
	}

	@Override
	public ESFFornitureTypeLocalService getWrappedService() {
		return _esfFornitureTypeLocalService;
	}

	@Override
	public void setWrappedService(
		ESFFornitureTypeLocalService esfFornitureTypeLocalService) {
		_esfFornitureTypeLocalService = esfFornitureTypeLocalService;
	}

	private ESFFornitureTypeLocalService _esfFornitureTypeLocalService;
}