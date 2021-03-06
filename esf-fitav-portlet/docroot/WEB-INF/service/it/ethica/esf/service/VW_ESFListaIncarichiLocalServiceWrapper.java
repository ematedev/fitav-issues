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
 * Provides a wrapper for {@link VW_ESFListaIncarichiLocalService}.
 *
 * @author Ethica
 * @see VW_ESFListaIncarichiLocalService
 * @generated
 */
public class VW_ESFListaIncarichiLocalServiceWrapper
	implements VW_ESFListaIncarichiLocalService,
		ServiceWrapper<VW_ESFListaIncarichiLocalService> {
	public VW_ESFListaIncarichiLocalServiceWrapper(
		VW_ESFListaIncarichiLocalService vw_esfListaIncarichiLocalService) {
		_vw_esfListaIncarichiLocalService = vw_esfListaIncarichiLocalService;
	}

	/**
	* Adds the v w_ e s f lista incarichi to the database. Also notifies the appropriate model listeners.
	*
	* @param vw_esfListaIncarichi the v w_ e s f lista incarichi
	* @return the v w_ e s f lista incarichi that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.VW_ESFListaIncarichi addVW_ESFListaIncarichi(
		it.ethica.esf.model.VW_ESFListaIncarichi vw_esfListaIncarichi)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vw_esfListaIncarichiLocalService.addVW_ESFListaIncarichi(vw_esfListaIncarichi);
	}

	/**
	* Creates a new v w_ e s f lista incarichi with the primary key. Does not add the v w_ e s f lista incarichi to the database.
	*
	* @param vw_esfListaIncarichiPK the primary key for the new v w_ e s f lista incarichi
	* @return the new v w_ e s f lista incarichi
	*/
	@Override
	public it.ethica.esf.model.VW_ESFListaIncarichi createVW_ESFListaIncarichi(
		it.ethica.esf.service.persistence.VW_ESFListaIncarichiPK vw_esfListaIncarichiPK) {
		return _vw_esfListaIncarichiLocalService.createVW_ESFListaIncarichi(vw_esfListaIncarichiPK);
	}

	/**
	* Deletes the v w_ e s f lista incarichi with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param vw_esfListaIncarichiPK the primary key of the v w_ e s f lista incarichi
	* @return the v w_ e s f lista incarichi that was removed
	* @throws PortalException if a v w_ e s f lista incarichi with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.VW_ESFListaIncarichi deleteVW_ESFListaIncarichi(
		it.ethica.esf.service.persistence.VW_ESFListaIncarichiPK vw_esfListaIncarichiPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _vw_esfListaIncarichiLocalService.deleteVW_ESFListaIncarichi(vw_esfListaIncarichiPK);
	}

	/**
	* Deletes the v w_ e s f lista incarichi from the database. Also notifies the appropriate model listeners.
	*
	* @param vw_esfListaIncarichi the v w_ e s f lista incarichi
	* @return the v w_ e s f lista incarichi that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.VW_ESFListaIncarichi deleteVW_ESFListaIncarichi(
		it.ethica.esf.model.VW_ESFListaIncarichi vw_esfListaIncarichi)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vw_esfListaIncarichiLocalService.deleteVW_ESFListaIncarichi(vw_esfListaIncarichi);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _vw_esfListaIncarichiLocalService.dynamicQuery();
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
		return _vw_esfListaIncarichiLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.VW_ESFListaIncarichiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _vw_esfListaIncarichiLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.VW_ESFListaIncarichiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _vw_esfListaIncarichiLocalService.dynamicQuery(dynamicQuery,
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
		return _vw_esfListaIncarichiLocalService.dynamicQueryCount(dynamicQuery);
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
		return _vw_esfListaIncarichiLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public it.ethica.esf.model.VW_ESFListaIncarichi fetchVW_ESFListaIncarichi(
		it.ethica.esf.service.persistence.VW_ESFListaIncarichiPK vw_esfListaIncarichiPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vw_esfListaIncarichiLocalService.fetchVW_ESFListaIncarichi(vw_esfListaIncarichiPK);
	}

	/**
	* Returns the v w_ e s f lista incarichi with the primary key.
	*
	* @param vw_esfListaIncarichiPK the primary key of the v w_ e s f lista incarichi
	* @return the v w_ e s f lista incarichi
	* @throws PortalException if a v w_ e s f lista incarichi with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.VW_ESFListaIncarichi getVW_ESFListaIncarichi(
		it.ethica.esf.service.persistence.VW_ESFListaIncarichiPK vw_esfListaIncarichiPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _vw_esfListaIncarichiLocalService.getVW_ESFListaIncarichi(vw_esfListaIncarichiPK);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _vw_esfListaIncarichiLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the v w_ e s f lista incarichis.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.VW_ESFListaIncarichiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of v w_ e s f lista incarichis
	* @param end the upper bound of the range of v w_ e s f lista incarichis (not inclusive)
	* @return the range of v w_ e s f lista incarichis
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<it.ethica.esf.model.VW_ESFListaIncarichi> getVW_ESFListaIncarichis(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vw_esfListaIncarichiLocalService.getVW_ESFListaIncarichis(start,
			end);
	}

	/**
	* Returns the number of v w_ e s f lista incarichis.
	*
	* @return the number of v w_ e s f lista incarichis
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getVW_ESFListaIncarichisCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vw_esfListaIncarichiLocalService.getVW_ESFListaIncarichisCount();
	}

	/**
	* Updates the v w_ e s f lista incarichi in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param vw_esfListaIncarichi the v w_ e s f lista incarichi
	* @return the v w_ e s f lista incarichi that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.VW_ESFListaIncarichi updateVW_ESFListaIncarichi(
		it.ethica.esf.model.VW_ESFListaIncarichi vw_esfListaIncarichi)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vw_esfListaIncarichiLocalService.updateVW_ESFListaIncarichi(vw_esfListaIncarichi);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _vw_esfListaIncarichiLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_vw_esfListaIncarichiLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _vw_esfListaIncarichiLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public java.util.List<it.ethica.esf.model.VW_ESFListaIncarichi> findByorganizzazione(
		long esfOrganizationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vw_esfListaIncarichiLocalService.findByorganizzazione(esfOrganizationId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public VW_ESFListaIncarichiLocalService getWrappedVW_ESFListaIncarichiLocalService() {
		return _vw_esfListaIncarichiLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedVW_ESFListaIncarichiLocalService(
		VW_ESFListaIncarichiLocalService vw_esfListaIncarichiLocalService) {
		_vw_esfListaIncarichiLocalService = vw_esfListaIncarichiLocalService;
	}

	@Override
	public VW_ESFListaIncarichiLocalService getWrappedService() {
		return _vw_esfListaIncarichiLocalService;
	}

	@Override
	public void setWrappedService(
		VW_ESFListaIncarichiLocalService vw_esfListaIncarichiLocalService) {
		_vw_esfListaIncarichiLocalService = vw_esfListaIncarichiLocalService;
	}

	private VW_ESFListaIncarichiLocalService _vw_esfListaIncarichiLocalService;
}