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
 * Provides a wrapper for {@link ESFBrandLocalService}.
 *
 * @author Ethica
 * @see ESFBrandLocalService
 * @generated
 */
public class ESFBrandLocalServiceWrapper implements ESFBrandLocalService,
	ServiceWrapper<ESFBrandLocalService> {
	public ESFBrandLocalServiceWrapper(
		ESFBrandLocalService esfBrandLocalService) {
		_esfBrandLocalService = esfBrandLocalService;
	}

	/**
	* Adds the e s f brand to the database. Also notifies the appropriate model listeners.
	*
	* @param esfBrand the e s f brand
	* @return the e s f brand that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFBrand addESFBrand(
		it.ethica.esf.model.ESFBrand esfBrand)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfBrandLocalService.addESFBrand(esfBrand);
	}

	/**
	* Creates a new e s f brand with the primary key. Does not add the e s f brand to the database.
	*
	* @param brandId the primary key for the new e s f brand
	* @return the new e s f brand
	*/
	@Override
	public it.ethica.esf.model.ESFBrand createESFBrand(long brandId) {
		return _esfBrandLocalService.createESFBrand(brandId);
	}

	/**
	* Deletes the e s f brand with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param brandId the primary key of the e s f brand
	* @return the e s f brand that was removed
	* @throws PortalException if a e s f brand with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFBrand deleteESFBrand(long brandId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfBrandLocalService.deleteESFBrand(brandId);
	}

	/**
	* Deletes the e s f brand from the database. Also notifies the appropriate model listeners.
	*
	* @param esfBrand the e s f brand
	* @return the e s f brand that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFBrand deleteESFBrand(
		it.ethica.esf.model.ESFBrand esfBrand)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfBrandLocalService.deleteESFBrand(esfBrand);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _esfBrandLocalService.dynamicQuery();
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
		return _esfBrandLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFBrandModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _esfBrandLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFBrandModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _esfBrandLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _esfBrandLocalService.dynamicQueryCount(dynamicQuery);
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
		return _esfBrandLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public it.ethica.esf.model.ESFBrand fetchESFBrand(long brandId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfBrandLocalService.fetchESFBrand(brandId);
	}

	/**
	* Returns the e s f brand with the primary key.
	*
	* @param brandId the primary key of the e s f brand
	* @return the e s f brand
	* @throws PortalException if a e s f brand with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFBrand getESFBrand(long brandId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfBrandLocalService.getESFBrand(brandId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfBrandLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the e s f brands.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFBrandModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f brands
	* @param end the upper bound of the range of e s f brands (not inclusive)
	* @return the range of e s f brands
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<it.ethica.esf.model.ESFBrand> getESFBrands(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfBrandLocalService.getESFBrands(start, end);
	}

	/**
	* Returns the number of e s f brands.
	*
	* @return the number of e s f brands
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getESFBrandsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfBrandLocalService.getESFBrandsCount();
	}

	/**
	* Updates the e s f brand in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param esfBrand the e s f brand
	* @return the e s f brand that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFBrand updateESFBrand(
		it.ethica.esf.model.ESFBrand esfBrand)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfBrandLocalService.updateESFBrand(esfBrand);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _esfBrandLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_esfBrandLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _esfBrandLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFBrand> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfBrandLocalService.findAll();
	}

	@Override
	public it.ethica.esf.model.ESFBrand addEsfBrand(java.lang.String name,
		java.lang.String description,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfBrandLocalService.addEsfBrand(name, description,
			serviceContext);
	}

	@Override
	public it.ethica.esf.model.ESFBrand updateEsfBrand(long brandId,
		java.lang.String name, java.lang.String description,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfBrandLocalService.updateEsfBrand(brandId, name, description,
			serviceContext);
	}

	@Override
	public it.ethica.esf.model.ESFBrand deleteEsfBrand(long brandId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfBrandLocalService.deleteEsfBrand(brandId, serviceContext);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ESFBrandLocalService getWrappedESFBrandLocalService() {
		return _esfBrandLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedESFBrandLocalService(
		ESFBrandLocalService esfBrandLocalService) {
		_esfBrandLocalService = esfBrandLocalService;
	}

	@Override
	public ESFBrandLocalService getWrappedService() {
		return _esfBrandLocalService;
	}

	@Override
	public void setWrappedService(ESFBrandLocalService esfBrandLocalService) {
		_esfBrandLocalService = esfBrandLocalService;
	}

	private ESFBrandLocalService _esfBrandLocalService;
}