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
 * Provides a wrapper for {@link VW_StaffLocalService}.
 *
 * @author Ethica
 * @see VW_StaffLocalService
 * @generated
 */
public class VW_StaffLocalServiceWrapper implements VW_StaffLocalService,
	ServiceWrapper<VW_StaffLocalService> {
	public VW_StaffLocalServiceWrapper(
		VW_StaffLocalService vw_StaffLocalService) {
		_vw_StaffLocalService = vw_StaffLocalService;
	}

	/**
	* Adds the v w_ staff to the database. Also notifies the appropriate model listeners.
	*
	* @param vw_Staff the v w_ staff
	* @return the v w_ staff that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.VW_Staff addVW_Staff(
		it.ethica.esf.model.VW_Staff vw_Staff)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vw_StaffLocalService.addVW_Staff(vw_Staff);
	}

	/**
	* Creates a new v w_ staff with the primary key. Does not add the v w_ staff to the database.
	*
	* @param vw_StaffPK the primary key for the new v w_ staff
	* @return the new v w_ staff
	*/
	@Override
	public it.ethica.esf.model.VW_Staff createVW_Staff(
		it.ethica.esf.service.persistence.VW_StaffPK vw_StaffPK) {
		return _vw_StaffLocalService.createVW_Staff(vw_StaffPK);
	}

	/**
	* Deletes the v w_ staff with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param vw_StaffPK the primary key of the v w_ staff
	* @return the v w_ staff that was removed
	* @throws PortalException if a v w_ staff with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.VW_Staff deleteVW_Staff(
		it.ethica.esf.service.persistence.VW_StaffPK vw_StaffPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _vw_StaffLocalService.deleteVW_Staff(vw_StaffPK);
	}

	/**
	* Deletes the v w_ staff from the database. Also notifies the appropriate model listeners.
	*
	* @param vw_Staff the v w_ staff
	* @return the v w_ staff that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.VW_Staff deleteVW_Staff(
		it.ethica.esf.model.VW_Staff vw_Staff)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vw_StaffLocalService.deleteVW_Staff(vw_Staff);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _vw_StaffLocalService.dynamicQuery();
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
		return _vw_StaffLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.VW_StaffModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _vw_StaffLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.VW_StaffModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _vw_StaffLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _vw_StaffLocalService.dynamicQueryCount(dynamicQuery);
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
		return _vw_StaffLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public it.ethica.esf.model.VW_Staff fetchVW_Staff(
		it.ethica.esf.service.persistence.VW_StaffPK vw_StaffPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vw_StaffLocalService.fetchVW_Staff(vw_StaffPK);
	}

	/**
	* Returns the v w_ staff with the primary key.
	*
	* @param vw_StaffPK the primary key of the v w_ staff
	* @return the v w_ staff
	* @throws PortalException if a v w_ staff with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.VW_Staff getVW_Staff(
		it.ethica.esf.service.persistence.VW_StaffPK vw_StaffPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _vw_StaffLocalService.getVW_Staff(vw_StaffPK);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _vw_StaffLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the v w_ staffs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.VW_StaffModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of v w_ staffs
	* @param end the upper bound of the range of v w_ staffs (not inclusive)
	* @return the range of v w_ staffs
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<it.ethica.esf.model.VW_Staff> getVW_Staffs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vw_StaffLocalService.getVW_Staffs(start, end);
	}

	/**
	* Returns the number of v w_ staffs.
	*
	* @return the number of v w_ staffs
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getVW_StaffsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vw_StaffLocalService.getVW_StaffsCount();
	}

	/**
	* Updates the v w_ staff in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param vw_Staff the v w_ staff
	* @return the v w_ staff that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.VW_Staff updateVW_Staff(
		it.ethica.esf.model.VW_Staff vw_Staff)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vw_StaffLocalService.updateVW_Staff(vw_Staff);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _vw_StaffLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_vw_StaffLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _vw_StaffLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public it.ethica.esf.model.VW_Staff cercaStaff(long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchVW_StaffException {
		return _vw_StaffLocalService.cercaStaff(userId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public VW_StaffLocalService getWrappedVW_StaffLocalService() {
		return _vw_StaffLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedVW_StaffLocalService(
		VW_StaffLocalService vw_StaffLocalService) {
		_vw_StaffLocalService = vw_StaffLocalService;
	}

	@Override
	public VW_StaffLocalService getWrappedService() {
		return _vw_StaffLocalService;
	}

	@Override
	public void setWrappedService(VW_StaffLocalService vw_StaffLocalService) {
		_vw_StaffLocalService = vw_StaffLocalService;
	}

	private VW_StaffLocalService _vw_StaffLocalService;
}