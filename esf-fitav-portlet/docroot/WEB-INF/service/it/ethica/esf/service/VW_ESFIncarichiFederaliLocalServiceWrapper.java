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
 * Provides a wrapper for {@link VW_ESFIncarichiFederaliLocalService}.
 *
 * @author Ethica
 * @see VW_ESFIncarichiFederaliLocalService
 * @generated
 */
public class VW_ESFIncarichiFederaliLocalServiceWrapper
	implements VW_ESFIncarichiFederaliLocalService,
		ServiceWrapper<VW_ESFIncarichiFederaliLocalService> {
	public VW_ESFIncarichiFederaliLocalServiceWrapper(
		VW_ESFIncarichiFederaliLocalService vw_esfIncarichiFederaliLocalService) {
		_vw_esfIncarichiFederaliLocalService = vw_esfIncarichiFederaliLocalService;
	}

	/**
	* Adds the v w_ e s f incarichi federali to the database. Also notifies the appropriate model listeners.
	*
	* @param vw_esfIncarichiFederali the v w_ e s f incarichi federali
	* @return the v w_ e s f incarichi federali that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.VW_ESFIncarichiFederali addVW_ESFIncarichiFederali(
		it.ethica.esf.model.VW_ESFIncarichiFederali vw_esfIncarichiFederali)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vw_esfIncarichiFederaliLocalService.addVW_ESFIncarichiFederali(vw_esfIncarichiFederali);
	}

	/**
	* Creates a new v w_ e s f incarichi federali with the primary key. Does not add the v w_ e s f incarichi federali to the database.
	*
	* @param vw_esfIncarichiFederaliPK the primary key for the new v w_ e s f incarichi federali
	* @return the new v w_ e s f incarichi federali
	*/
	@Override
	public it.ethica.esf.model.VW_ESFIncarichiFederali createVW_ESFIncarichiFederali(
		it.ethica.esf.service.persistence.VW_ESFIncarichiFederaliPK vw_esfIncarichiFederaliPK) {
		return _vw_esfIncarichiFederaliLocalService.createVW_ESFIncarichiFederali(vw_esfIncarichiFederaliPK);
	}

	/**
	* Deletes the v w_ e s f incarichi federali with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param vw_esfIncarichiFederaliPK the primary key of the v w_ e s f incarichi federali
	* @return the v w_ e s f incarichi federali that was removed
	* @throws PortalException if a v w_ e s f incarichi federali with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.VW_ESFIncarichiFederali deleteVW_ESFIncarichiFederali(
		it.ethica.esf.service.persistence.VW_ESFIncarichiFederaliPK vw_esfIncarichiFederaliPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _vw_esfIncarichiFederaliLocalService.deleteVW_ESFIncarichiFederali(vw_esfIncarichiFederaliPK);
	}

	/**
	* Deletes the v w_ e s f incarichi federali from the database. Also notifies the appropriate model listeners.
	*
	* @param vw_esfIncarichiFederali the v w_ e s f incarichi federali
	* @return the v w_ e s f incarichi federali that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.VW_ESFIncarichiFederali deleteVW_ESFIncarichiFederali(
		it.ethica.esf.model.VW_ESFIncarichiFederali vw_esfIncarichiFederali)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vw_esfIncarichiFederaliLocalService.deleteVW_ESFIncarichiFederali(vw_esfIncarichiFederali);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _vw_esfIncarichiFederaliLocalService.dynamicQuery();
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
		return _vw_esfIncarichiFederaliLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.VW_ESFIncarichiFederaliModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _vw_esfIncarichiFederaliLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.VW_ESFIncarichiFederaliModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _vw_esfIncarichiFederaliLocalService.dynamicQuery(dynamicQuery,
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
		return _vw_esfIncarichiFederaliLocalService.dynamicQueryCount(dynamicQuery);
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
		return _vw_esfIncarichiFederaliLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public it.ethica.esf.model.VW_ESFIncarichiFederali fetchVW_ESFIncarichiFederali(
		it.ethica.esf.service.persistence.VW_ESFIncarichiFederaliPK vw_esfIncarichiFederaliPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vw_esfIncarichiFederaliLocalService.fetchVW_ESFIncarichiFederali(vw_esfIncarichiFederaliPK);
	}

	/**
	* Returns the v w_ e s f incarichi federali with the primary key.
	*
	* @param vw_esfIncarichiFederaliPK the primary key of the v w_ e s f incarichi federali
	* @return the v w_ e s f incarichi federali
	* @throws PortalException if a v w_ e s f incarichi federali with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.VW_ESFIncarichiFederali getVW_ESFIncarichiFederali(
		it.ethica.esf.service.persistence.VW_ESFIncarichiFederaliPK vw_esfIncarichiFederaliPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _vw_esfIncarichiFederaliLocalService.getVW_ESFIncarichiFederali(vw_esfIncarichiFederaliPK);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _vw_esfIncarichiFederaliLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the v w_ e s f incarichi federalis.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.VW_ESFIncarichiFederaliModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of v w_ e s f incarichi federalis
	* @param end the upper bound of the range of v w_ e s f incarichi federalis (not inclusive)
	* @return the range of v w_ e s f incarichi federalis
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<it.ethica.esf.model.VW_ESFIncarichiFederali> getVW_ESFIncarichiFederalis(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vw_esfIncarichiFederaliLocalService.getVW_ESFIncarichiFederalis(start,
			end);
	}

	/**
	* Returns the number of v w_ e s f incarichi federalis.
	*
	* @return the number of v w_ e s f incarichi federalis
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getVW_ESFIncarichiFederalisCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vw_esfIncarichiFederaliLocalService.getVW_ESFIncarichiFederalisCount();
	}

	/**
	* Updates the v w_ e s f incarichi federali in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param vw_esfIncarichiFederali the v w_ e s f incarichi federali
	* @return the v w_ e s f incarichi federali that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.VW_ESFIncarichiFederali updateVW_ESFIncarichiFederali(
		it.ethica.esf.model.VW_ESFIncarichiFederali vw_esfIncarichiFederali)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vw_esfIncarichiFederaliLocalService.updateVW_ESFIncarichiFederali(vw_esfIncarichiFederali);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _vw_esfIncarichiFederaliLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_vw_esfIncarichiFederaliLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _vw_esfIncarichiFederaliLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public java.util.List<it.ethica.esf.model.VW_ESFIncarichiFederali> findBylistaIncarichi(
		long esfUserId, boolean attivo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vw_esfIncarichiFederaliLocalService.findBylistaIncarichi(esfUserId,
			attivo);
	}

	@Override
	public java.util.List<it.ethica.esf.model.VW_ESFIncarichiFederali> getListaIncarichifindBylistaIncarichi(
		long esfUserId, boolean attivo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vw_esfIncarichiFederaliLocalService.getListaIncarichifindBylistaIncarichi(esfUserId,
			attivo);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public VW_ESFIncarichiFederaliLocalService getWrappedVW_ESFIncarichiFederaliLocalService() {
		return _vw_esfIncarichiFederaliLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedVW_ESFIncarichiFederaliLocalService(
		VW_ESFIncarichiFederaliLocalService vw_esfIncarichiFederaliLocalService) {
		_vw_esfIncarichiFederaliLocalService = vw_esfIncarichiFederaliLocalService;
	}

	@Override
	public VW_ESFIncarichiFederaliLocalService getWrappedService() {
		return _vw_esfIncarichiFederaliLocalService;
	}

	@Override
	public void setWrappedService(
		VW_ESFIncarichiFederaliLocalService vw_esfIncarichiFederaliLocalService) {
		_vw_esfIncarichiFederaliLocalService = vw_esfIncarichiFederaliLocalService;
	}

	private VW_ESFIncarichiFederaliLocalService _vw_esfIncarichiFederaliLocalService;
}