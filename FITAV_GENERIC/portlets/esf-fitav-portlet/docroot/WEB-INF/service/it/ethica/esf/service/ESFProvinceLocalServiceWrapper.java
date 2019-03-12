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
 * Provides a wrapper for {@link ESFProvinceLocalService}.
 *
 * @author Ethica
 * @see ESFProvinceLocalService
 * @generated
 */
public class ESFProvinceLocalServiceWrapper implements ESFProvinceLocalService,
	ServiceWrapper<ESFProvinceLocalService> {
	public ESFProvinceLocalServiceWrapper(
		ESFProvinceLocalService esfProvinceLocalService) {
		_esfProvinceLocalService = esfProvinceLocalService;
	}

	/**
	* Adds the e s f province to the database. Also notifies the appropriate model listeners.
	*
	* @param esfProvince the e s f province
	* @return the e s f province that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFProvince addESFProvince(
		it.ethica.esf.model.ESFProvince esfProvince)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfProvinceLocalService.addESFProvince(esfProvince);
	}

	/**
	* Creates a new e s f province with the primary key. Does not add the e s f province to the database.
	*
	* @param esfProvincePK the primary key for the new e s f province
	* @return the new e s f province
	*/
	@Override
	public it.ethica.esf.model.ESFProvince createESFProvince(
		it.ethica.esf.service.persistence.ESFProvincePK esfProvincePK) {
		return _esfProvinceLocalService.createESFProvince(esfProvincePK);
	}

	/**
	* Deletes the e s f province with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfProvincePK the primary key of the e s f province
	* @return the e s f province that was removed
	* @throws PortalException if a e s f province with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFProvince deleteESFProvince(
		it.ethica.esf.service.persistence.ESFProvincePK esfProvincePK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfProvinceLocalService.deleteESFProvince(esfProvincePK);
	}

	/**
	* Deletes the e s f province from the database. Also notifies the appropriate model listeners.
	*
	* @param esfProvince the e s f province
	* @return the e s f province that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFProvince deleteESFProvince(
		it.ethica.esf.model.ESFProvince esfProvince)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfProvinceLocalService.deleteESFProvince(esfProvince);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _esfProvinceLocalService.dynamicQuery();
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
		return _esfProvinceLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFProvinceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _esfProvinceLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFProvinceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _esfProvinceLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _esfProvinceLocalService.dynamicQueryCount(dynamicQuery);
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
		return _esfProvinceLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public it.ethica.esf.model.ESFProvince fetchESFProvince(
		it.ethica.esf.service.persistence.ESFProvincePK esfProvincePK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfProvinceLocalService.fetchESFProvince(esfProvincePK);
	}

	/**
	* Returns the e s f province with the primary key.
	*
	* @param esfProvincePK the primary key of the e s f province
	* @return the e s f province
	* @throws PortalException if a e s f province with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFProvince getESFProvince(
		it.ethica.esf.service.persistence.ESFProvincePK esfProvincePK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfProvinceLocalService.getESFProvince(esfProvincePK);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfProvinceLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the e s f provinces.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFProvinceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f provinces
	* @param end the upper bound of the range of e s f provinces (not inclusive)
	* @return the range of e s f provinces
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<it.ethica.esf.model.ESFProvince> getESFProvinces(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfProvinceLocalService.getESFProvinces(start, end);
	}

	/**
	* Returns the number of e s f provinces.
	*
	* @return the number of e s f provinces
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getESFProvincesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfProvinceLocalService.getESFProvincesCount();
	}

	/**
	* Updates the e s f province in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param esfProvince the e s f province
	* @return the e s f province that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFProvince updateESFProvince(
		it.ethica.esf.model.ESFProvince esfProvince)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfProvinceLocalService.updateESFProvince(esfProvince);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _esfProvinceLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_esfProvinceLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _esfProvinceLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFProvince> findByCountry_Name(
		java.lang.String idCountry, java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserESFUserRoleException {
		return _esfProvinceLocalService.findByCountry_Name(idCountry, name);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFProvince> getByRegionCode(
		java.lang.String id)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserESFUserRoleException {
		return _esfProvinceLocalService.getByRegionCode(id);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFProvince> findByProvinceId(
		java.lang.String id)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserESFUserRoleException {
		return _esfProvinceLocalService.findByProvinceId(id);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ESFProvinceLocalService getWrappedESFProvinceLocalService() {
		return _esfProvinceLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedESFProvinceLocalService(
		ESFProvinceLocalService esfProvinceLocalService) {
		_esfProvinceLocalService = esfProvinceLocalService;
	}

	@Override
	public ESFProvinceLocalService getWrappedService() {
		return _esfProvinceLocalService;
	}

	@Override
	public void setWrappedService(
		ESFProvinceLocalService esfProvinceLocalService) {
		_esfProvinceLocalService = esfProvinceLocalService;
	}

	private ESFProvinceLocalService _esfProvinceLocalService;
}