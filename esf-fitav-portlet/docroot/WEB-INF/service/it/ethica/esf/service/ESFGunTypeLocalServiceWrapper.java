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
 * Provides a wrapper for {@link ESFGunTypeLocalService}.
 *
 * @author Ethica
 * @see ESFGunTypeLocalService
 * @generated
 */
public class ESFGunTypeLocalServiceWrapper implements ESFGunTypeLocalService,
	ServiceWrapper<ESFGunTypeLocalService> {
	public ESFGunTypeLocalServiceWrapper(
		ESFGunTypeLocalService esfGunTypeLocalService) {
		_esfGunTypeLocalService = esfGunTypeLocalService;
	}

	/**
	* Adds the e s f gun type to the database. Also notifies the appropriate model listeners.
	*
	* @param esfGunType the e s f gun type
	* @return the e s f gun type that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFGunType addESFGunType(
		it.ethica.esf.model.ESFGunType esfGunType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfGunTypeLocalService.addESFGunType(esfGunType);
	}

	/**
	* Creates a new e s f gun type with the primary key. Does not add the e s f gun type to the database.
	*
	* @param esfGunTypeId the primary key for the new e s f gun type
	* @return the new e s f gun type
	*/
	@Override
	public it.ethica.esf.model.ESFGunType createESFGunType(long esfGunTypeId) {
		return _esfGunTypeLocalService.createESFGunType(esfGunTypeId);
	}

	/**
	* Deletes the e s f gun type with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfGunTypeId the primary key of the e s f gun type
	* @return the e s f gun type that was removed
	* @throws PortalException if a e s f gun type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFGunType deleteESFGunType(long esfGunTypeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfGunTypeLocalService.deleteESFGunType(esfGunTypeId);
	}

	/**
	* Deletes the e s f gun type from the database. Also notifies the appropriate model listeners.
	*
	* @param esfGunType the e s f gun type
	* @return the e s f gun type that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFGunType deleteESFGunType(
		it.ethica.esf.model.ESFGunType esfGunType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfGunTypeLocalService.deleteESFGunType(esfGunType);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _esfGunTypeLocalService.dynamicQuery();
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
		return _esfGunTypeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFGunTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _esfGunTypeLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFGunTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _esfGunTypeLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _esfGunTypeLocalService.dynamicQueryCount(dynamicQuery);
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
		return _esfGunTypeLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public it.ethica.esf.model.ESFGunType fetchESFGunType(long esfGunTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfGunTypeLocalService.fetchESFGunType(esfGunTypeId);
	}

	/**
	* Returns the e s f gun type with the matching UUID and company.
	*
	* @param uuid the e s f gun type's UUID
	* @param companyId the primary key of the company
	* @return the matching e s f gun type, or <code>null</code> if a matching e s f gun type could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFGunType fetchESFGunTypeByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfGunTypeLocalService.fetchESFGunTypeByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the e s f gun type matching the UUID and group.
	*
	* @param uuid the e s f gun type's UUID
	* @param groupId the primary key of the group
	* @return the matching e s f gun type, or <code>null</code> if a matching e s f gun type could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFGunType fetchESFGunTypeByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfGunTypeLocalService.fetchESFGunTypeByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns the e s f gun type with the primary key.
	*
	* @param esfGunTypeId the primary key of the e s f gun type
	* @return the e s f gun type
	* @throws PortalException if a e s f gun type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFGunType getESFGunType(long esfGunTypeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfGunTypeLocalService.getESFGunType(esfGunTypeId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfGunTypeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the e s f gun type with the matching UUID and company.
	*
	* @param uuid the e s f gun type's UUID
	* @param companyId the primary key of the company
	* @return the matching e s f gun type
	* @throws PortalException if a matching e s f gun type could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFGunType getESFGunTypeByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfGunTypeLocalService.getESFGunTypeByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the e s f gun type matching the UUID and group.
	*
	* @param uuid the e s f gun type's UUID
	* @param groupId the primary key of the group
	* @return the matching e s f gun type
	* @throws PortalException if a matching e s f gun type could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFGunType getESFGunTypeByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfGunTypeLocalService.getESFGunTypeByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns a range of all the e s f gun types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFGunTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f gun types
	* @param end the upper bound of the range of e s f gun types (not inclusive)
	* @return the range of e s f gun types
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<it.ethica.esf.model.ESFGunType> getESFGunTypes(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfGunTypeLocalService.getESFGunTypes(start, end);
	}

	/**
	* Returns the number of e s f gun types.
	*
	* @return the number of e s f gun types
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getESFGunTypesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfGunTypeLocalService.getESFGunTypesCount();
	}

	/**
	* Updates the e s f gun type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param esfGunType the e s f gun type
	* @return the e s f gun type that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFGunType updateESFGunType(
		it.ethica.esf.model.ESFGunType esfGunType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfGunTypeLocalService.updateESFGunType(esfGunType);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _esfGunTypeLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_esfGunTypeLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _esfGunTypeLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFGunType> getESFGunTypes()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfGunTypeLocalService.getESFGunTypes();
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFGunType> getisCatridgeProductor(
		boolean isCatridgeProductor)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchGunTypeException {
		return _esfGunTypeLocalService.getisCatridgeProductor(isCatridgeProductor);
	}

	@Override
	public it.ethica.esf.model.ESFGunType addESFGunType(long userId,
		java.lang.String name, java.lang.String description,
		boolean isCatridgeProductor,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfGunTypeLocalService.addESFGunType(userId, name, description,
			isCatridgeProductor, serviceContext);
	}

	@Override
	public it.ethica.esf.model.ESFGunType updateESFGunType(long userId,
		long esfGunTypeId, java.lang.String name, java.lang.String description,
		boolean isCatridgeProductor,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfGunTypeLocalService.updateESFGunType(userId, esfGunTypeId,
			name, description, isCatridgeProductor, serviceContext);
	}

	@Override
	public it.ethica.esf.model.ESFGunType deleteESFGunType(long esfGunTypeId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfGunTypeLocalService.deleteESFGunType(esfGunTypeId,
			serviceContext);
	}

	@Override
	public it.ethica.esf.model.ESFGunType checkNome(java.lang.String name,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfGunTypeLocalService.checkNome(name, serviceContext);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ESFGunTypeLocalService getWrappedESFGunTypeLocalService() {
		return _esfGunTypeLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedESFGunTypeLocalService(
		ESFGunTypeLocalService esfGunTypeLocalService) {
		_esfGunTypeLocalService = esfGunTypeLocalService;
	}

	@Override
	public ESFGunTypeLocalService getWrappedService() {
		return _esfGunTypeLocalService;
	}

	@Override
	public void setWrappedService(ESFGunTypeLocalService esfGunTypeLocalService) {
		_esfGunTypeLocalService = esfGunTypeLocalService;
	}

	private ESFGunTypeLocalService _esfGunTypeLocalService;
}