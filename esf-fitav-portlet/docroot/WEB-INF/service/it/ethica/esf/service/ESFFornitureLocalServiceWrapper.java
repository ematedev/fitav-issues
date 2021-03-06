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
 * Provides a wrapper for {@link ESFFornitureLocalService}.
 *
 * @author Ethica
 * @see ESFFornitureLocalService
 * @generated
 */
public class ESFFornitureLocalServiceWrapper implements ESFFornitureLocalService,
	ServiceWrapper<ESFFornitureLocalService> {
	public ESFFornitureLocalServiceWrapper(
		ESFFornitureLocalService esfFornitureLocalService) {
		_esfFornitureLocalService = esfFornitureLocalService;
	}

	/**
	* Adds the e s f forniture to the database. Also notifies the appropriate model listeners.
	*
	* @param esfForniture the e s f forniture
	* @return the e s f forniture that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFForniture addESFForniture(
		it.ethica.esf.model.ESFForniture esfForniture)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfFornitureLocalService.addESFForniture(esfForniture);
	}

	/**
	* Creates a new e s f forniture with the primary key. Does not add the e s f forniture to the database.
	*
	* @param esfFornitureId the primary key for the new e s f forniture
	* @return the new e s f forniture
	*/
	@Override
	public it.ethica.esf.model.ESFForniture createESFForniture(
		long esfFornitureId) {
		return _esfFornitureLocalService.createESFForniture(esfFornitureId);
	}

	/**
	* Deletes the e s f forniture with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfFornitureId the primary key of the e s f forniture
	* @return the e s f forniture that was removed
	* @throws PortalException if a e s f forniture with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFForniture deleteESFForniture(
		long esfFornitureId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfFornitureLocalService.deleteESFForniture(esfFornitureId);
	}

	/**
	* Deletes the e s f forniture from the database. Also notifies the appropriate model listeners.
	*
	* @param esfForniture the e s f forniture
	* @return the e s f forniture that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFForniture deleteESFForniture(
		it.ethica.esf.model.ESFForniture esfForniture)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfFornitureLocalService.deleteESFForniture(esfForniture);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _esfFornitureLocalService.dynamicQuery();
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
		return _esfFornitureLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFornitureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _esfFornitureLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFornitureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _esfFornitureLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _esfFornitureLocalService.dynamicQueryCount(dynamicQuery);
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
		return _esfFornitureLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public it.ethica.esf.model.ESFForniture fetchESFForniture(
		long esfFornitureId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfFornitureLocalService.fetchESFForniture(esfFornitureId);
	}

	/**
	* Returns the e s f forniture with the matching UUID and company.
	*
	* @param uuid the e s f forniture's UUID
	* @param companyId the primary key of the company
	* @return the matching e s f forniture, or <code>null</code> if a matching e s f forniture could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFForniture fetchESFFornitureByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfFornitureLocalService.fetchESFFornitureByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the e s f forniture matching the UUID and group.
	*
	* @param uuid the e s f forniture's UUID
	* @param groupId the primary key of the group
	* @return the matching e s f forniture, or <code>null</code> if a matching e s f forniture could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFForniture fetchESFFornitureByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfFornitureLocalService.fetchESFFornitureByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns the e s f forniture with the primary key.
	*
	* @param esfFornitureId the primary key of the e s f forniture
	* @return the e s f forniture
	* @throws PortalException if a e s f forniture with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFForniture getESFForniture(long esfFornitureId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfFornitureLocalService.getESFForniture(esfFornitureId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfFornitureLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the e s f forniture with the matching UUID and company.
	*
	* @param uuid the e s f forniture's UUID
	* @param companyId the primary key of the company
	* @return the matching e s f forniture
	* @throws PortalException if a matching e s f forniture could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFForniture getESFFornitureByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfFornitureLocalService.getESFFornitureByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the e s f forniture matching the UUID and group.
	*
	* @param uuid the e s f forniture's UUID
	* @param groupId the primary key of the group
	* @return the matching e s f forniture
	* @throws PortalException if a matching e s f forniture could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFForniture getESFFornitureByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfFornitureLocalService.getESFFornitureByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns a range of all the e s f fornitures.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFornitureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f fornitures
	* @param end the upper bound of the range of e s f fornitures (not inclusive)
	* @return the range of e s f fornitures
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<it.ethica.esf.model.ESFForniture> getESFFornitures(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfFornitureLocalService.getESFFornitures(start, end);
	}

	/**
	* Returns the number of e s f fornitures.
	*
	* @return the number of e s f fornitures
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getESFFornituresCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfFornitureLocalService.getESFFornituresCount();
	}

	/**
	* Updates the e s f forniture in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param esfForniture the e s f forniture
	* @return the e s f forniture that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFForniture updateESFForniture(
		it.ethica.esf.model.ESFForniture esfForniture)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfFornitureLocalService.updateESFForniture(esfForniture);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _esfFornitureLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_esfFornitureLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _esfFornitureLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFForniture> getAllESFFornitures()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfFornitureLocalService.getAllESFFornitures();
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFForniture> getAllESFFornitures(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfFornitureLocalService.getAllESFFornitures(start, end);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFForniture> getAllESFFornitures(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfFornitureLocalService.getAllESFFornitures(groupId);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFForniture> getAllESFFornitures(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfFornitureLocalService.getAllESFFornitures(groupId, start, end);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFForniture> findAllESFFornituresByType(
		long type) throws com.liferay.portal.kernel.exception.SystemException {
		return _esfFornitureLocalService.findAllESFFornituresByType(type);
	}

	@Override
	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfFornitureLocalService.countByGroupId(groupId);
	}

	@Override
	public it.ethica.esf.model.ESFForniture addESFForniture(long userId,
		java.lang.String code, java.lang.String description,
		java.lang.String name, long esfFornitureTypeId, long numberFornitures,
		java.util.Date insertDate, java.lang.String size,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfFornitureLocalService.addESFForniture(userId, code,
			description, name, esfFornitureTypeId, numberFornitures,
			insertDate, size, serviceContext);
	}

	@Override
	public it.ethica.esf.model.ESFForniture updateESFForniture(long userId,
		long esfFornitureId, java.lang.String code,
		java.lang.String description, java.lang.String name,
		long esfFornitureTypeId, long numberFornitures,
		java.util.Date insertDate, java.lang.String size,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfFornitureLocalService.updateESFForniture(userId,
			esfFornitureId, code, description, name, esfFornitureTypeId,
			numberFornitures, insertDate, size, serviceContext);
	}

	@Override
	public it.ethica.esf.model.ESFForniture deleteESFForniture(
		long esfFornitureId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfFornitureLocalService.deleteESFForniture(esfFornitureId,
			serviceContext);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ESFFornitureLocalService getWrappedESFFornitureLocalService() {
		return _esfFornitureLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedESFFornitureLocalService(
		ESFFornitureLocalService esfFornitureLocalService) {
		_esfFornitureLocalService = esfFornitureLocalService;
	}

	@Override
	public ESFFornitureLocalService getWrappedService() {
		return _esfFornitureLocalService;
	}

	@Override
	public void setWrappedService(
		ESFFornitureLocalService esfFornitureLocalService) {
		_esfFornitureLocalService = esfFornitureLocalService;
	}

	private ESFFornitureLocalService _esfFornitureLocalService;
}