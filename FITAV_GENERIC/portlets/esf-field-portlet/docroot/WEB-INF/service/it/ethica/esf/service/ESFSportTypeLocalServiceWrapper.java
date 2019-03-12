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
 * Provides a wrapper for {@link ESFSportTypeLocalService}.
 *
 * @author ethica
 * @see ESFSportTypeLocalService
 * @generated
 */
public class ESFSportTypeLocalServiceWrapper implements ESFSportTypeLocalService,
	ServiceWrapper<ESFSportTypeLocalService> {
	public ESFSportTypeLocalServiceWrapper(
		ESFSportTypeLocalService esfSportTypeLocalService) {
		_esfSportTypeLocalService = esfSportTypeLocalService;
	}

	/**
	* Adds the e s f sport type to the database. Also notifies the appropriate model listeners.
	*
	* @param esfSportType the e s f sport type
	* @return the e s f sport type that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFSportType addESFSportType(
		it.ethica.esf.model.ESFSportType esfSportType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfSportTypeLocalService.addESFSportType(esfSportType);
	}

	/**
	* Creates a new e s f sport type with the primary key. Does not add the e s f sport type to the database.
	*
	* @param esfSportTypeId the primary key for the new e s f sport type
	* @return the new e s f sport type
	*/
	@Override
	public it.ethica.esf.model.ESFSportType createESFSportType(
		long esfSportTypeId) {
		return _esfSportTypeLocalService.createESFSportType(esfSportTypeId);
	}

	/**
	* Deletes the e s f sport type with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfSportTypeId the primary key of the e s f sport type
	* @return the e s f sport type that was removed
	* @throws PortalException if a e s f sport type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFSportType deleteESFSportType(
		long esfSportTypeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfSportTypeLocalService.deleteESFSportType(esfSportTypeId);
	}

	/**
	* Deletes the e s f sport type from the database. Also notifies the appropriate model listeners.
	*
	* @param esfSportType the e s f sport type
	* @return the e s f sport type that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFSportType deleteESFSportType(
		it.ethica.esf.model.ESFSportType esfSportType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfSportTypeLocalService.deleteESFSportType(esfSportType);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _esfSportTypeLocalService.dynamicQuery();
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
		return _esfSportTypeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFSportTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _esfSportTypeLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFSportTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _esfSportTypeLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _esfSportTypeLocalService.dynamicQueryCount(dynamicQuery);
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
		return _esfSportTypeLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public it.ethica.esf.model.ESFSportType fetchESFSportType(
		long esfSportTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfSportTypeLocalService.fetchESFSportType(esfSportTypeId);
	}

	/**
	* Returns the e s f sport type with the matching UUID and company.
	*
	* @param uuid the e s f sport type's UUID
	* @param companyId the primary key of the company
	* @return the matching e s f sport type, or <code>null</code> if a matching e s f sport type could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFSportType fetchESFSportTypeByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfSportTypeLocalService.fetchESFSportTypeByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the e s f sport type matching the UUID and group.
	*
	* @param uuid the e s f sport type's UUID
	* @param groupId the primary key of the group
	* @return the matching e s f sport type, or <code>null</code> if a matching e s f sport type could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFSportType fetchESFSportTypeByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfSportTypeLocalService.fetchESFSportTypeByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns the e s f sport type with the primary key.
	*
	* @param esfSportTypeId the primary key of the e s f sport type
	* @return the e s f sport type
	* @throws PortalException if a e s f sport type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFSportType getESFSportType(long esfSportTypeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfSportTypeLocalService.getESFSportType(esfSportTypeId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfSportTypeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the e s f sport type with the matching UUID and company.
	*
	* @param uuid the e s f sport type's UUID
	* @param companyId the primary key of the company
	* @return the matching e s f sport type
	* @throws PortalException if a matching e s f sport type could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFSportType getESFSportTypeByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfSportTypeLocalService.getESFSportTypeByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the e s f sport type matching the UUID and group.
	*
	* @param uuid the e s f sport type's UUID
	* @param groupId the primary key of the group
	* @return the matching e s f sport type
	* @throws PortalException if a matching e s f sport type could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFSportType getESFSportTypeByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfSportTypeLocalService.getESFSportTypeByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns a range of all the e s f sport types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFSportTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f sport types
	* @param end the upper bound of the range of e s f sport types (not inclusive)
	* @return the range of e s f sport types
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<it.ethica.esf.model.ESFSportType> getESFSportTypes(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfSportTypeLocalService.getESFSportTypes(start, end);
	}

	/**
	* Returns the number of e s f sport types.
	*
	* @return the number of e s f sport types
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getESFSportTypesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfSportTypeLocalService.getESFSportTypesCount();
	}

	/**
	* Updates the e s f sport type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param esfSportType the e s f sport type
	* @return the e s f sport type that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFSportType updateESFSportType(
		it.ethica.esf.model.ESFSportType esfSportType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfSportTypeLocalService.updateESFSportType(esfSportType);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _esfSportTypeLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_esfSportTypeLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _esfSportTypeLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFSportType> getAllESFSportTypes()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfSportTypeLocalService.getAllESFSportTypes();
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFSportType> getAllESFSportTypes(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfSportTypeLocalService.getAllESFSportTypes(start, end);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFSportType> getESFSportTypes(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfSportTypeLocalService.getESFSportTypes(groupId);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFSportType> getESFSportTypes(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfSportTypeLocalService.getESFSportTypes(groupId, start, end);
	}

	@Override
	public int getESFSportTypesCountByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfSportTypeLocalService.getESFSportTypesCountByGroupId(groupId);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFSportType> getESFSportTypesByESFField(
		long esfFieldId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfSportTypeLocalService.getESFSportTypesByESFField(esfFieldId);
	}

	@Override
	public it.ethica.esf.model.ESFSportType addESFSportType(long userId,
		java.lang.String name, java.lang.String description,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfSportTypeLocalService.addESFSportType(userId, name,
			description, serviceContext);
	}

	@Override
	public it.ethica.esf.model.ESFSportType updateESFSportType(long userId,
		long esfSportTypeId, java.lang.String name,
		java.lang.String description,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfSportTypeLocalService.updateESFSportType(userId,
			esfSportTypeId, name, description, serviceContext);
	}

	@Override
	public it.ethica.esf.model.ESFSportType deleteESFSportType(
		long esfSportTypeId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfSportTypeLocalService.deleteESFSportType(esfSportTypeId,
			serviceContext);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ESFSportTypeLocalService getWrappedESFSportTypeLocalService() {
		return _esfSportTypeLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedESFSportTypeLocalService(
		ESFSportTypeLocalService esfSportTypeLocalService) {
		_esfSportTypeLocalService = esfSportTypeLocalService;
	}

	@Override
	public ESFSportTypeLocalService getWrappedService() {
		return _esfSportTypeLocalService;
	}

	@Override
	public void setWrappedService(
		ESFSportTypeLocalService esfSportTypeLocalService) {
		_esfSportTypeLocalService = esfSportTypeLocalService;
	}

	private ESFSportTypeLocalService _esfSportTypeLocalService;
}