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
 * Provides a wrapper for {@link VW_ShootersLocalService}.
 *
 * @author Ethica
 * @see VW_ShootersLocalService
 * @generated
 */
public class VW_ShootersLocalServiceWrapper implements VW_ShootersLocalService,
	ServiceWrapper<VW_ShootersLocalService> {
	public VW_ShootersLocalServiceWrapper(
		VW_ShootersLocalService vw_ShootersLocalService) {
		_vw_ShootersLocalService = vw_ShootersLocalService;
	}

	/**
	* Adds the v w_ shooters to the database. Also notifies the appropriate model listeners.
	*
	* @param vw_Shooters the v w_ shooters
	* @return the v w_ shooters that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.VW_Shooters addVW_Shooters(
		it.ethica.esf.model.VW_Shooters vw_Shooters)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vw_ShootersLocalService.addVW_Shooters(vw_Shooters);
	}

	/**
	* Creates a new v w_ shooters with the primary key. Does not add the v w_ shooters to the database.
	*
	* @param vw_ShootersPK the primary key for the new v w_ shooters
	* @return the new v w_ shooters
	*/
	@Override
	public it.ethica.esf.model.VW_Shooters createVW_Shooters(
		it.ethica.esf.service.persistence.VW_ShootersPK vw_ShootersPK) {
		return _vw_ShootersLocalService.createVW_Shooters(vw_ShootersPK);
	}

	/**
	* Deletes the v w_ shooters with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param vw_ShootersPK the primary key of the v w_ shooters
	* @return the v w_ shooters that was removed
	* @throws PortalException if a v w_ shooters with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.VW_Shooters deleteVW_Shooters(
		it.ethica.esf.service.persistence.VW_ShootersPK vw_ShootersPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _vw_ShootersLocalService.deleteVW_Shooters(vw_ShootersPK);
	}

	/**
	* Deletes the v w_ shooters from the database. Also notifies the appropriate model listeners.
	*
	* @param vw_Shooters the v w_ shooters
	* @return the v w_ shooters that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.VW_Shooters deleteVW_Shooters(
		it.ethica.esf.model.VW_Shooters vw_Shooters)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vw_ShootersLocalService.deleteVW_Shooters(vw_Shooters);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _vw_ShootersLocalService.dynamicQuery();
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
		return _vw_ShootersLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.VW_ShootersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _vw_ShootersLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.VW_ShootersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _vw_ShootersLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _vw_ShootersLocalService.dynamicQueryCount(dynamicQuery);
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
		return _vw_ShootersLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public it.ethica.esf.model.VW_Shooters fetchVW_Shooters(
		it.ethica.esf.service.persistence.VW_ShootersPK vw_ShootersPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vw_ShootersLocalService.fetchVW_Shooters(vw_ShootersPK);
	}

	/**
	* Returns the v w_ shooters with the primary key.
	*
	* @param vw_ShootersPK the primary key of the v w_ shooters
	* @return the v w_ shooters
	* @throws PortalException if a v w_ shooters with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.VW_Shooters getVW_Shooters(
		it.ethica.esf.service.persistence.VW_ShootersPK vw_ShootersPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _vw_ShootersLocalService.getVW_Shooters(vw_ShootersPK);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _vw_ShootersLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the v w_ shooterses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.VW_ShootersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of v w_ shooterses
	* @param end the upper bound of the range of v w_ shooterses (not inclusive)
	* @return the range of v w_ shooterses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<it.ethica.esf.model.VW_Shooters> getVW_Shooterses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vw_ShootersLocalService.getVW_Shooterses(start, end);
	}

	/**
	* Returns the number of v w_ shooterses.
	*
	* @return the number of v w_ shooterses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getVW_ShootersesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vw_ShootersLocalService.getVW_ShootersesCount();
	}

	/**
	* Updates the v w_ shooters in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param vw_Shooters the v w_ shooters
	* @return the v w_ shooters that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.VW_Shooters updateVW_Shooters(
		it.ethica.esf.model.VW_Shooters vw_Shooters)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vw_ShootersLocalService.updateVW_Shooters(vw_Shooters);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _vw_ShootersLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_vw_ShootersLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _vw_ShootersLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public it.ethica.esf.model.VW_Shooters cercaShooter(long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchVW_ShootersException {
		return _vw_ShootersLocalService.cercaShooter(userId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public VW_ShootersLocalService getWrappedVW_ShootersLocalService() {
		return _vw_ShootersLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedVW_ShootersLocalService(
		VW_ShootersLocalService vw_ShootersLocalService) {
		_vw_ShootersLocalService = vw_ShootersLocalService;
	}

	@Override
	public VW_ShootersLocalService getWrappedService() {
		return _vw_ShootersLocalService;
	}

	@Override
	public void setWrappedService(
		VW_ShootersLocalService vw_ShootersLocalService) {
		_vw_ShootersLocalService = vw_ShootersLocalService;
	}

	private VW_ShootersLocalService _vw_ShootersLocalService;
}