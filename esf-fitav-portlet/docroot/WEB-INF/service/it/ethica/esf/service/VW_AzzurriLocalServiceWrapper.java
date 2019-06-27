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
 * Provides a wrapper for {@link VW_AzzurriLocalService}.
 *
 * @author Ethica
 * @see VW_AzzurriLocalService
 * @generated
 */
public class VW_AzzurriLocalServiceWrapper implements VW_AzzurriLocalService,
	ServiceWrapper<VW_AzzurriLocalService> {
	public VW_AzzurriLocalServiceWrapper(
		VW_AzzurriLocalService vw_AzzurriLocalService) {
		_vw_AzzurriLocalService = vw_AzzurriLocalService;
	}

	/**
	* Adds the v w_ azzurri to the database. Also notifies the appropriate model listeners.
	*
	* @param vw_Azzurri the v w_ azzurri
	* @return the v w_ azzurri that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.VW_Azzurri addVW_Azzurri(
		it.ethica.esf.model.VW_Azzurri vw_Azzurri)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vw_AzzurriLocalService.addVW_Azzurri(vw_Azzurri);
	}

	/**
	* Creates a new v w_ azzurri with the primary key. Does not add the v w_ azzurri to the database.
	*
	* @param vw_AzzurriPK the primary key for the new v w_ azzurri
	* @return the new v w_ azzurri
	*/
	@Override
	public it.ethica.esf.model.VW_Azzurri createVW_Azzurri(
		it.ethica.esf.service.persistence.VW_AzzurriPK vw_AzzurriPK) {
		return _vw_AzzurriLocalService.createVW_Azzurri(vw_AzzurriPK);
	}

	/**
	* Deletes the v w_ azzurri with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param vw_AzzurriPK the primary key of the v w_ azzurri
	* @return the v w_ azzurri that was removed
	* @throws PortalException if a v w_ azzurri with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.VW_Azzurri deleteVW_Azzurri(
		it.ethica.esf.service.persistence.VW_AzzurriPK vw_AzzurriPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _vw_AzzurriLocalService.deleteVW_Azzurri(vw_AzzurriPK);
	}

	/**
	* Deletes the v w_ azzurri from the database. Also notifies the appropriate model listeners.
	*
	* @param vw_Azzurri the v w_ azzurri
	* @return the v w_ azzurri that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.VW_Azzurri deleteVW_Azzurri(
		it.ethica.esf.model.VW_Azzurri vw_Azzurri)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vw_AzzurriLocalService.deleteVW_Azzurri(vw_Azzurri);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _vw_AzzurriLocalService.dynamicQuery();
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
		return _vw_AzzurriLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.VW_AzzurriModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _vw_AzzurriLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.VW_AzzurriModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _vw_AzzurriLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _vw_AzzurriLocalService.dynamicQueryCount(dynamicQuery);
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
		return _vw_AzzurriLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public it.ethica.esf.model.VW_Azzurri fetchVW_Azzurri(
		it.ethica.esf.service.persistence.VW_AzzurriPK vw_AzzurriPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vw_AzzurriLocalService.fetchVW_Azzurri(vw_AzzurriPK);
	}

	/**
	* Returns the v w_ azzurri with the primary key.
	*
	* @param vw_AzzurriPK the primary key of the v w_ azzurri
	* @return the v w_ azzurri
	* @throws PortalException if a v w_ azzurri with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.VW_Azzurri getVW_Azzurri(
		it.ethica.esf.service.persistence.VW_AzzurriPK vw_AzzurriPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _vw_AzzurriLocalService.getVW_Azzurri(vw_AzzurriPK);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _vw_AzzurriLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the v w_ azzurris.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.VW_AzzurriModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of v w_ azzurris
	* @param end the upper bound of the range of v w_ azzurris (not inclusive)
	* @return the range of v w_ azzurris
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<it.ethica.esf.model.VW_Azzurri> getVW_Azzurris(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vw_AzzurriLocalService.getVW_Azzurris(start, end);
	}

	/**
	* Returns the number of v w_ azzurris.
	*
	* @return the number of v w_ azzurris
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getVW_AzzurrisCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vw_AzzurriLocalService.getVW_AzzurrisCount();
	}

	/**
	* Updates the v w_ azzurri in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param vw_Azzurri the v w_ azzurri
	* @return the v w_ azzurri that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.VW_Azzurri updateVW_Azzurri(
		it.ethica.esf.model.VW_Azzurri vw_Azzurri)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vw_AzzurriLocalService.updateVW_Azzurri(vw_Azzurri);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _vw_AzzurriLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_vw_AzzurriLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _vw_AzzurriLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public it.ethica.esf.model.VW_Azzurri cercaAzzurro(long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchVW_AzzurriException {
		return _vw_AzzurriLocalService.cercaAzzurro(userId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public VW_AzzurriLocalService getWrappedVW_AzzurriLocalService() {
		return _vw_AzzurriLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedVW_AzzurriLocalService(
		VW_AzzurriLocalService vw_AzzurriLocalService) {
		_vw_AzzurriLocalService = vw_AzzurriLocalService;
	}

	@Override
	public VW_AzzurriLocalService getWrappedService() {
		return _vw_AzzurriLocalService;
	}

	@Override
	public void setWrappedService(VW_AzzurriLocalService vw_AzzurriLocalService) {
		_vw_AzzurriLocalService = vw_AzzurriLocalService;
	}

	private VW_AzzurriLocalService _vw_AzzurriLocalService;
}