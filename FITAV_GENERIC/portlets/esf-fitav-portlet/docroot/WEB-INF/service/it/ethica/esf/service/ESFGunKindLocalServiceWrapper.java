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
 * Provides a wrapper for {@link ESFGunKindLocalService}.
 *
 * @author Ethica
 * @see ESFGunKindLocalService
 * @generated
 */
public class ESFGunKindLocalServiceWrapper implements ESFGunKindLocalService,
	ServiceWrapper<ESFGunKindLocalService> {
	public ESFGunKindLocalServiceWrapper(
		ESFGunKindLocalService esfGunKindLocalService) {
		_esfGunKindLocalService = esfGunKindLocalService;
	}

	/**
	* Adds the e s f gun kind to the database. Also notifies the appropriate model listeners.
	*
	* @param esfGunKind the e s f gun kind
	* @return the e s f gun kind that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFGunKind addESFGunKind(
		it.ethica.esf.model.ESFGunKind esfGunKind)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfGunKindLocalService.addESFGunKind(esfGunKind);
	}

	/**
	* Creates a new e s f gun kind with the primary key. Does not add the e s f gun kind to the database.
	*
	* @param esfGunKindId the primary key for the new e s f gun kind
	* @return the new e s f gun kind
	*/
	@Override
	public it.ethica.esf.model.ESFGunKind createESFGunKind(long esfGunKindId) {
		return _esfGunKindLocalService.createESFGunKind(esfGunKindId);
	}

	/**
	* Deletes the e s f gun kind with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfGunKindId the primary key of the e s f gun kind
	* @return the e s f gun kind that was removed
	* @throws PortalException if a e s f gun kind with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFGunKind deleteESFGunKind(long esfGunKindId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfGunKindLocalService.deleteESFGunKind(esfGunKindId);
	}

	/**
	* Deletes the e s f gun kind from the database. Also notifies the appropriate model listeners.
	*
	* @param esfGunKind the e s f gun kind
	* @return the e s f gun kind that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFGunKind deleteESFGunKind(
		it.ethica.esf.model.ESFGunKind esfGunKind)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfGunKindLocalService.deleteESFGunKind(esfGunKind);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _esfGunKindLocalService.dynamicQuery();
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
		return _esfGunKindLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFGunKindModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _esfGunKindLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFGunKindModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _esfGunKindLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _esfGunKindLocalService.dynamicQueryCount(dynamicQuery);
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
		return _esfGunKindLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public it.ethica.esf.model.ESFGunKind fetchESFGunKind(long esfGunKindId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfGunKindLocalService.fetchESFGunKind(esfGunKindId);
	}

	/**
	* Returns the e s f gun kind with the matching UUID and company.
	*
	* @param uuid the e s f gun kind's UUID
	* @param companyId the primary key of the company
	* @return the matching e s f gun kind, or <code>null</code> if a matching e s f gun kind could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFGunKind fetchESFGunKindByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfGunKindLocalService.fetchESFGunKindByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the e s f gun kind matching the UUID and group.
	*
	* @param uuid the e s f gun kind's UUID
	* @param groupId the primary key of the group
	* @return the matching e s f gun kind, or <code>null</code> if a matching e s f gun kind could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFGunKind fetchESFGunKindByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfGunKindLocalService.fetchESFGunKindByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns the e s f gun kind with the primary key.
	*
	* @param esfGunKindId the primary key of the e s f gun kind
	* @return the e s f gun kind
	* @throws PortalException if a e s f gun kind with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFGunKind getESFGunKind(long esfGunKindId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfGunKindLocalService.getESFGunKind(esfGunKindId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfGunKindLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the e s f gun kind with the matching UUID and company.
	*
	* @param uuid the e s f gun kind's UUID
	* @param companyId the primary key of the company
	* @return the matching e s f gun kind
	* @throws PortalException if a matching e s f gun kind could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFGunKind getESFGunKindByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfGunKindLocalService.getESFGunKindByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the e s f gun kind matching the UUID and group.
	*
	* @param uuid the e s f gun kind's UUID
	* @param groupId the primary key of the group
	* @return the matching e s f gun kind
	* @throws PortalException if a matching e s f gun kind could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFGunKind getESFGunKindByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfGunKindLocalService.getESFGunKindByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns a range of all the e s f gun kinds.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFGunKindModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f gun kinds
	* @param end the upper bound of the range of e s f gun kinds (not inclusive)
	* @return the range of e s f gun kinds
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<it.ethica.esf.model.ESFGunKind> getESFGunKinds(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfGunKindLocalService.getESFGunKinds(start, end);
	}

	/**
	* Returns the number of e s f gun kinds.
	*
	* @return the number of e s f gun kinds
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getESFGunKindsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfGunKindLocalService.getESFGunKindsCount();
	}

	/**
	* Updates the e s f gun kind in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param esfGunKind the e s f gun kind
	* @return the e s f gun kind that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFGunKind updateESFGunKind(
		it.ethica.esf.model.ESFGunKind esfGunKind)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfGunKindLocalService.updateESFGunKind(esfGunKind);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _esfGunKindLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_esfGunKindLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _esfGunKindLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFGunKind> getESFGunKindsByLikeN_D_M(
		java.lang.String name, java.lang.String description,
		java.lang.String model, long esfGunTypeId) {
		return _esfGunKindLocalService.getESFGunKindsByLikeN_D_M(name,
			description, model, esfGunTypeId);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFGunKind> getESFGunKindsByLikeN_D_M(
		java.lang.String name, java.lang.String description,
		java.lang.String model, long esfGunTypeId, int start, int end) {
		return _esfGunKindLocalService.getESFGunKindsByLikeN_D_M(name,
			description, model, esfGunTypeId, start, end);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFGunKind> getESFGunKinds()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfGunKindLocalService.getESFGunKinds();
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFGunKind> getESFGunKindsByESFGunType(
		long esfGunTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfGunKindLocalService.getESFGunKindsByESFGunType(esfGunTypeId);
	}

	@Override
	public it.ethica.esf.model.ESFGunKind getESFGunKindsById(long esfGunKindId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfGunKindLocalService.getESFGunKindsById(esfGunKindId);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFGunKind> getESFGunKindsByESFGunType(
		long esfGunTypeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfGunKindLocalService.getESFGunKindsByESFGunType(esfGunTypeId,
			start, end);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFGunKind> getESFRifle(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchGunTypeException {
		return _esfGunKindLocalService.getESFRifle(start, end);
	}

	@Override
	public int countESFRifle()
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchGunTypeException {
		return _esfGunKindLocalService.countESFRifle();
	}

	@Override
	public int getESFGunKindCountByESFGunType(long esfGunTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfGunKindLocalService.getESFGunKindCountByESFGunType(esfGunTypeId);
	}

	@Override
	public it.ethica.esf.model.ESFGunKind addESFGunKind(long userId,
		java.lang.String name, java.lang.String description, long esfGunTypeId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfGunKindLocalService.addESFGunKind(userId, name, description,
			esfGunTypeId, serviceContext);
	}

	@Override
	public it.ethica.esf.model.ESFGunKind updateESFGunKind(long userId,
		long esfGunKindId, java.lang.String name, java.lang.String description,
		long esfGunTypeId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfGunKindLocalService.updateESFGunKind(userId, esfGunKindId,
			name, description, esfGunTypeId, serviceContext);
	}

	@Override
	public it.ethica.esf.model.ESFGunKind deleteESFGunKind(long esfGunKindId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfGunKindLocalService.deleteESFGunKind(esfGunKindId,
			serviceContext);
	}

	@Override
	public it.ethica.esf.model.ESFGunKind checkNome(java.lang.String name,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfGunKindLocalService.checkNome(name, serviceContext);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ESFGunKindLocalService getWrappedESFGunKindLocalService() {
		return _esfGunKindLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedESFGunKindLocalService(
		ESFGunKindLocalService esfGunKindLocalService) {
		_esfGunKindLocalService = esfGunKindLocalService;
	}

	@Override
	public ESFGunKindLocalService getWrappedService() {
		return _esfGunKindLocalService;
	}

	@Override
	public void setWrappedService(ESFGunKindLocalService esfGunKindLocalService) {
		_esfGunKindLocalService = esfGunKindLocalService;
	}

	private ESFGunKindLocalService _esfGunKindLocalService;
}