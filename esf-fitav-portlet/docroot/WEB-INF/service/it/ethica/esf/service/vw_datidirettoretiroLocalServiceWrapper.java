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
 * Provides a wrapper for {@link vw_datidirettoretiroLocalService}.
 *
 * @author Ethica
 * @see vw_datidirettoretiroLocalService
 * @generated
 */
public class vw_datidirettoretiroLocalServiceWrapper
	implements vw_datidirettoretiroLocalService,
		ServiceWrapper<vw_datidirettoretiroLocalService> {
	public vw_datidirettoretiroLocalServiceWrapper(
		vw_datidirettoretiroLocalService vw_datidirettoretiroLocalService) {
		_vw_datidirettoretiroLocalService = vw_datidirettoretiroLocalService;
	}

	/**
	* Adds the vw_datidirettoretiro to the database. Also notifies the appropriate model listeners.
	*
	* @param vw_datidirettoretiro the vw_datidirettoretiro
	* @return the vw_datidirettoretiro that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.vw_datidirettoretiro addvw_datidirettoretiro(
		it.ethica.esf.model.vw_datidirettoretiro vw_datidirettoretiro)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vw_datidirettoretiroLocalService.addvw_datidirettoretiro(vw_datidirettoretiro);
	}

	/**
	* Creates a new vw_datidirettoretiro with the primary key. Does not add the vw_datidirettoretiro to the database.
	*
	* @param vw_datidirettoretiroPK the primary key for the new vw_datidirettoretiro
	* @return the new vw_datidirettoretiro
	*/
	@Override
	public it.ethica.esf.model.vw_datidirettoretiro createvw_datidirettoretiro(
		it.ethica.esf.service.persistence.vw_datidirettoretiroPK vw_datidirettoretiroPK) {
		return _vw_datidirettoretiroLocalService.createvw_datidirettoretiro(vw_datidirettoretiroPK);
	}

	/**
	* Deletes the vw_datidirettoretiro with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param vw_datidirettoretiroPK the primary key of the vw_datidirettoretiro
	* @return the vw_datidirettoretiro that was removed
	* @throws PortalException if a vw_datidirettoretiro with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.vw_datidirettoretiro deletevw_datidirettoretiro(
		it.ethica.esf.service.persistence.vw_datidirettoretiroPK vw_datidirettoretiroPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _vw_datidirettoretiroLocalService.deletevw_datidirettoretiro(vw_datidirettoretiroPK);
	}

	/**
	* Deletes the vw_datidirettoretiro from the database. Also notifies the appropriate model listeners.
	*
	* @param vw_datidirettoretiro the vw_datidirettoretiro
	* @return the vw_datidirettoretiro that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.vw_datidirettoretiro deletevw_datidirettoretiro(
		it.ethica.esf.model.vw_datidirettoretiro vw_datidirettoretiro)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vw_datidirettoretiroLocalService.deletevw_datidirettoretiro(vw_datidirettoretiro);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _vw_datidirettoretiroLocalService.dynamicQuery();
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
		return _vw_datidirettoretiroLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.vw_datidirettoretiroModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _vw_datidirettoretiroLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.vw_datidirettoretiroModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _vw_datidirettoretiroLocalService.dynamicQuery(dynamicQuery,
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
		return _vw_datidirettoretiroLocalService.dynamicQueryCount(dynamicQuery);
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
		return _vw_datidirettoretiroLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public it.ethica.esf.model.vw_datidirettoretiro fetchvw_datidirettoretiro(
		it.ethica.esf.service.persistence.vw_datidirettoretiroPK vw_datidirettoretiroPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vw_datidirettoretiroLocalService.fetchvw_datidirettoretiro(vw_datidirettoretiroPK);
	}

	/**
	* Returns the vw_datidirettoretiro with the primary key.
	*
	* @param vw_datidirettoretiroPK the primary key of the vw_datidirettoretiro
	* @return the vw_datidirettoretiro
	* @throws PortalException if a vw_datidirettoretiro with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.vw_datidirettoretiro getvw_datidirettoretiro(
		it.ethica.esf.service.persistence.vw_datidirettoretiroPK vw_datidirettoretiroPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _vw_datidirettoretiroLocalService.getvw_datidirettoretiro(vw_datidirettoretiroPK);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _vw_datidirettoretiroLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the vw_datidirettoretiros.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.vw_datidirettoretiroModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of vw_datidirettoretiros
	* @param end the upper bound of the range of vw_datidirettoretiros (not inclusive)
	* @return the range of vw_datidirettoretiros
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<it.ethica.esf.model.vw_datidirettoretiro> getvw_datidirettoretiros(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vw_datidirettoretiroLocalService.getvw_datidirettoretiros(start,
			end);
	}

	/**
	* Returns the number of vw_datidirettoretiros.
	*
	* @return the number of vw_datidirettoretiros
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getvw_datidirettoretirosCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vw_datidirettoretiroLocalService.getvw_datidirettoretirosCount();
	}

	/**
	* Updates the vw_datidirettoretiro in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param vw_datidirettoretiro the vw_datidirettoretiro
	* @return the vw_datidirettoretiro that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.vw_datidirettoretiro updatevw_datidirettoretiro(
		it.ethica.esf.model.vw_datidirettoretiro vw_datidirettoretiro)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vw_datidirettoretiroLocalService.updatevw_datidirettoretiro(vw_datidirettoretiro);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _vw_datidirettoretiroLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_vw_datidirettoretiroLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _vw_datidirettoretiroLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public vw_datidirettoretiroLocalService getWrappedvw_datidirettoretiroLocalService() {
		return _vw_datidirettoretiroLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedvw_datidirettoretiroLocalService(
		vw_datidirettoretiroLocalService vw_datidirettoretiroLocalService) {
		_vw_datidirettoretiroLocalService = vw_datidirettoretiroLocalService;
	}

	@Override
	public vw_datidirettoretiroLocalService getWrappedService() {
		return _vw_datidirettoretiroLocalService;
	}

	@Override
	public void setWrappedService(
		vw_datidirettoretiroLocalService vw_datidirettoretiroLocalService) {
		_vw_datidirettoretiroLocalService = vw_datidirettoretiroLocalService;
	}

	private vw_datidirettoretiroLocalService _vw_datidirettoretiroLocalService;
}