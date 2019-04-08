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
 * Provides a wrapper for {@link ESFShooterCategoryLocalService}.
 *
 * @author Ethica
 * @see ESFShooterCategoryLocalService
 * @generated
 */
public class ESFShooterCategoryLocalServiceWrapper
	implements ESFShooterCategoryLocalService,
		ServiceWrapper<ESFShooterCategoryLocalService> {
	public ESFShooterCategoryLocalServiceWrapper(
		ESFShooterCategoryLocalService esfShooterCategoryLocalService) {
		_esfShooterCategoryLocalService = esfShooterCategoryLocalService;
	}

	/**
	* Adds the e s f shooter category to the database. Also notifies the appropriate model listeners.
	*
	* @param esfShooterCategory the e s f shooter category
	* @return the e s f shooter category that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFShooterCategory addESFShooterCategory(
		it.ethica.esf.model.ESFShooterCategory esfShooterCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfShooterCategoryLocalService.addESFShooterCategory(esfShooterCategory);
	}

	/**
	* Creates a new e s f shooter category with the primary key. Does not add the e s f shooter category to the database.
	*
	* @param esfShooterCategoryId the primary key for the new e s f shooter category
	* @return the new e s f shooter category
	*/
	@Override
	public it.ethica.esf.model.ESFShooterCategory createESFShooterCategory(
		long esfShooterCategoryId) {
		return _esfShooterCategoryLocalService.createESFShooterCategory(esfShooterCategoryId);
	}

	/**
	* Deletes the e s f shooter category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfShooterCategoryId the primary key of the e s f shooter category
	* @return the e s f shooter category that was removed
	* @throws PortalException if a e s f shooter category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFShooterCategory deleteESFShooterCategory(
		long esfShooterCategoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfShooterCategoryLocalService.deleteESFShooterCategory(esfShooterCategoryId);
	}

	/**
	* Deletes the e s f shooter category from the database. Also notifies the appropriate model listeners.
	*
	* @param esfShooterCategory the e s f shooter category
	* @return the e s f shooter category that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFShooterCategory deleteESFShooterCategory(
		it.ethica.esf.model.ESFShooterCategory esfShooterCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfShooterCategoryLocalService.deleteESFShooterCategory(esfShooterCategory);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _esfShooterCategoryLocalService.dynamicQuery();
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
		return _esfShooterCategoryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShooterCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _esfShooterCategoryLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShooterCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _esfShooterCategoryLocalService.dynamicQuery(dynamicQuery,
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
		return _esfShooterCategoryLocalService.dynamicQueryCount(dynamicQuery);
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
		return _esfShooterCategoryLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public it.ethica.esf.model.ESFShooterCategory fetchESFShooterCategory(
		long esfShooterCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfShooterCategoryLocalService.fetchESFShooterCategory(esfShooterCategoryId);
	}

	/**
	* Returns the e s f shooter category with the matching UUID and company.
	*
	* @param uuid the e s f shooter category's UUID
	* @param companyId the primary key of the company
	* @return the matching e s f shooter category, or <code>null</code> if a matching e s f shooter category could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFShooterCategory fetchESFShooterCategoryByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfShooterCategoryLocalService.fetchESFShooterCategoryByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the e s f shooter category matching the UUID and group.
	*
	* @param uuid the e s f shooter category's UUID
	* @param groupId the primary key of the group
	* @return the matching e s f shooter category, or <code>null</code> if a matching e s f shooter category could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFShooterCategory fetchESFShooterCategoryByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfShooterCategoryLocalService.fetchESFShooterCategoryByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns the e s f shooter category with the primary key.
	*
	* @param esfShooterCategoryId the primary key of the e s f shooter category
	* @return the e s f shooter category
	* @throws PortalException if a e s f shooter category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFShooterCategory getESFShooterCategory(
		long esfShooterCategoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfShooterCategoryLocalService.getESFShooterCategory(esfShooterCategoryId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfShooterCategoryLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the e s f shooter category with the matching UUID and company.
	*
	* @param uuid the e s f shooter category's UUID
	* @param companyId the primary key of the company
	* @return the matching e s f shooter category
	* @throws PortalException if a matching e s f shooter category could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFShooterCategory getESFShooterCategoryByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfShooterCategoryLocalService.getESFShooterCategoryByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the e s f shooter category matching the UUID and group.
	*
	* @param uuid the e s f shooter category's UUID
	* @param groupId the primary key of the group
	* @return the matching e s f shooter category
	* @throws PortalException if a matching e s f shooter category could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFShooterCategory getESFShooterCategoryByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfShooterCategoryLocalService.getESFShooterCategoryByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns a range of all the e s f shooter categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShooterCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f shooter categories
	* @param end the upper bound of the range of e s f shooter categories (not inclusive)
	* @return the range of e s f shooter categories
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<it.ethica.esf.model.ESFShooterCategory> getESFShooterCategories(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfShooterCategoryLocalService.getESFShooterCategories(start,
			end);
	}

	/**
	* Returns the number of e s f shooter categories.
	*
	* @return the number of e s f shooter categories
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getESFShooterCategoriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfShooterCategoryLocalService.getESFShooterCategoriesCount();
	}

	/**
	* Updates the e s f shooter category in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param esfShooterCategory the e s f shooter category
	* @return the e s f shooter category that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFShooterCategory updateESFShooterCategory(
		it.ethica.esf.model.ESFShooterCategory esfShooterCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfShooterCategoryLocalService.updateESFShooterCategory(esfShooterCategory);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _esfShooterCategoryLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_esfShooterCategoryLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _esfShooterCategoryLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFShooterCategory> getESFShooterCategories()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfShooterCategoryLocalService.getESFShooterCategories();
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFShooterCategory> getESFShooterCategories(
		long esfTournamentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchShooterCategoryException {
		return _esfShooterCategoryLocalService.getESFShooterCategories(esfTournamentId);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFShooterCategory> findByMatchId(
		long esfMatchId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchShooterCategoryException {
		return _esfShooterCategoryLocalService.findByMatchId(esfMatchId);
	}

	@Override
	public it.ethica.esf.model.ESFShooterCategory addESFShooterCategory(
		long userId, java.lang.String name, java.lang.String description,
		java.lang.String code,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfShooterCategoryLocalService.addESFShooterCategory(userId,
			name, description, code, serviceContext);
	}

	@Override
	public it.ethica.esf.model.ESFShooterCategory updateESFShooterCategory(
		long esfShooterCategoryId, java.lang.String name,
		java.lang.String description, java.lang.String code,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfShooterCategoryLocalService.updateESFShooterCategory(esfShooterCategoryId,
			name, description, code, serviceContext);
	}

	@Override
	public it.ethica.esf.model.ESFShooterCategory deleteESFShooterCategory(
		long esfShooterCategoryId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfShooterCategoryLocalService.deleteESFShooterCategory(esfShooterCategoryId,
			serviceContext);
	}

	@Override
	public long findIDCategoryByName(java.lang.String name)
		throws java.lang.Exception {
		return _esfShooterCategoryLocalService.findIDCategoryByName(name);
	}

	@Override
	public long findIDCategoryByCode(java.lang.String code)
		throws java.lang.Exception {
		return _esfShooterCategoryLocalService.findIDCategoryByCode(code);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ESFShooterCategoryLocalService getWrappedESFShooterCategoryLocalService() {
		return _esfShooterCategoryLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedESFShooterCategoryLocalService(
		ESFShooterCategoryLocalService esfShooterCategoryLocalService) {
		_esfShooterCategoryLocalService = esfShooterCategoryLocalService;
	}

	@Override
	public ESFShooterCategoryLocalService getWrappedService() {
		return _esfShooterCategoryLocalService;
	}

	@Override
	public void setWrappedService(
		ESFShooterCategoryLocalService esfShooterCategoryLocalService) {
		_esfShooterCategoryLocalService = esfShooterCategoryLocalService;
	}

	private ESFShooterCategoryLocalService _esfShooterCategoryLocalService;
}