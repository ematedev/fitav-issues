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
 * Provides a wrapper for {@link ESFCategoryLocalService}.
 *
 * @author Ethica
 * @see ESFCategoryLocalService
 * @generated
 */
public class ESFCategoryLocalServiceWrapper implements ESFCategoryLocalService,
	ServiceWrapper<ESFCategoryLocalService> {
	public ESFCategoryLocalServiceWrapper(
		ESFCategoryLocalService esfCategoryLocalService) {
		_esfCategoryLocalService = esfCategoryLocalService;
	}

	/**
	* Adds the e s f category to the database. Also notifies the appropriate model listeners.
	*
	* @param esfCategory the e s f category
	* @return the e s f category that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFCategory addESFCategory(
		it.ethica.esf.model.ESFCategory esfCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfCategoryLocalService.addESFCategory(esfCategory);
	}

	/**
	* Creates a new e s f category with the primary key. Does not add the e s f category to the database.
	*
	* @param esfCategoryId the primary key for the new e s f category
	* @return the new e s f category
	*/
	@Override
	public it.ethica.esf.model.ESFCategory createESFCategory(long esfCategoryId) {
		return _esfCategoryLocalService.createESFCategory(esfCategoryId);
	}

	/**
	* Deletes the e s f category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfCategoryId the primary key of the e s f category
	* @return the e s f category that was removed
	* @throws PortalException if a e s f category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFCategory deleteESFCategory(long esfCategoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfCategoryLocalService.deleteESFCategory(esfCategoryId);
	}

	/**
	* Deletes the e s f category from the database. Also notifies the appropriate model listeners.
	*
	* @param esfCategory the e s f category
	* @return the e s f category that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFCategory deleteESFCategory(
		it.ethica.esf.model.ESFCategory esfCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfCategoryLocalService.deleteESFCategory(esfCategory);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _esfCategoryLocalService.dynamicQuery();
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
		return _esfCategoryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _esfCategoryLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _esfCategoryLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _esfCategoryLocalService.dynamicQueryCount(dynamicQuery);
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
		return _esfCategoryLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public it.ethica.esf.model.ESFCategory fetchESFCategory(long esfCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfCategoryLocalService.fetchESFCategory(esfCategoryId);
	}

	/**
	* Returns the e s f category with the primary key.
	*
	* @param esfCategoryId the primary key of the e s f category
	* @return the e s f category
	* @throws PortalException if a e s f category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFCategory getESFCategory(long esfCategoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfCategoryLocalService.getESFCategory(esfCategoryId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfCategoryLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the e s f categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f categories
	* @param end the upper bound of the range of e s f categories (not inclusive)
	* @return the range of e s f categories
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<it.ethica.esf.model.ESFCategory> getESFCategories(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfCategoryLocalService.getESFCategories(start, end);
	}

	/**
	* Returns the number of e s f categories.
	*
	* @return the number of e s f categories
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getESFCategoriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfCategoryLocalService.getESFCategoriesCount();
	}

	/**
	* Updates the e s f category in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param esfCategory the e s f category
	* @return the e s f category that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFCategory updateESFCategory(
		it.ethica.esf.model.ESFCategory esfCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfCategoryLocalService.updateESFCategory(esfCategory);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _esfCategoryLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_esfCategoryLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _esfCategoryLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.HashMap<java.lang.String, java.lang.Long> findMapLongIdCategory()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfCategoryLocalService.findMapLongIdCategory();
	}

	@Override
	public it.ethica.esf.model.ESFCategory addESFCategory(
		java.lang.String name, java.lang.String description)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfCategoryLocalService.addESFCategory(name, description);
	}

	@Override
	public it.ethica.esf.model.ESFCategory updateESFCategory(
		long esfCategoryId, java.lang.String name, java.lang.String description)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfCategoryLocalService.updateESFCategory(esfCategoryId, name,
			description);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ESFCategoryLocalService getWrappedESFCategoryLocalService() {
		return _esfCategoryLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedESFCategoryLocalService(
		ESFCategoryLocalService esfCategoryLocalService) {
		_esfCategoryLocalService = esfCategoryLocalService;
	}

	@Override
	public ESFCategoryLocalService getWrappedService() {
		return _esfCategoryLocalService;
	}

	@Override
	public void setWrappedService(
		ESFCategoryLocalService esfCategoryLocalService) {
		_esfCategoryLocalService = esfCategoryLocalService;
	}

	private ESFCategoryLocalService _esfCategoryLocalService;
}