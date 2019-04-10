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
 * Provides a wrapper for {@link ESFFieldESFElectronicLocalService}.
 *
 * @author Ethica
 * @see ESFFieldESFElectronicLocalService
 * @generated
 */
public class ESFFieldESFElectronicLocalServiceWrapper
	implements ESFFieldESFElectronicLocalService,
		ServiceWrapper<ESFFieldESFElectronicLocalService> {
	public ESFFieldESFElectronicLocalServiceWrapper(
		ESFFieldESFElectronicLocalService esfFieldESFElectronicLocalService) {
		_esfFieldESFElectronicLocalService = esfFieldESFElectronicLocalService;
	}

	/**
	* Adds the e s f field e s f electronic to the database. Also notifies the appropriate model listeners.
	*
	* @param esfFieldESFElectronic the e s f field e s f electronic
	* @return the e s f field e s f electronic that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFFieldESFElectronic addESFFieldESFElectronic(
		it.ethica.esf.model.ESFFieldESFElectronic esfFieldESFElectronic)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfFieldESFElectronicLocalService.addESFFieldESFElectronic(esfFieldESFElectronic);
	}

	/**
	* Creates a new e s f field e s f electronic with the primary key. Does not add the e s f field e s f electronic to the database.
	*
	* @param id the primary key for the new e s f field e s f electronic
	* @return the new e s f field e s f electronic
	*/
	@Override
	public it.ethica.esf.model.ESFFieldESFElectronic createESFFieldESFElectronic(
		long id) {
		return _esfFieldESFElectronicLocalService.createESFFieldESFElectronic(id);
	}

	/**
	* Deletes the e s f field e s f electronic with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the e s f field e s f electronic
	* @return the e s f field e s f electronic that was removed
	* @throws PortalException if a e s f field e s f electronic with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFFieldESFElectronic deleteESFFieldESFElectronic(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfFieldESFElectronicLocalService.deleteESFFieldESFElectronic(id);
	}

	/**
	* Deletes the e s f field e s f electronic from the database. Also notifies the appropriate model listeners.
	*
	* @param esfFieldESFElectronic the e s f field e s f electronic
	* @return the e s f field e s f electronic that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFFieldESFElectronic deleteESFFieldESFElectronic(
		it.ethica.esf.model.ESFFieldESFElectronic esfFieldESFElectronic)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfFieldESFElectronicLocalService.deleteESFFieldESFElectronic(esfFieldESFElectronic);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _esfFieldESFElectronicLocalService.dynamicQuery();
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
		return _esfFieldESFElectronicLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFieldESFElectronicModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _esfFieldESFElectronicLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFieldESFElectronicModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _esfFieldESFElectronicLocalService.dynamicQuery(dynamicQuery,
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
		return _esfFieldESFElectronicLocalService.dynamicQueryCount(dynamicQuery);
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
		return _esfFieldESFElectronicLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public it.ethica.esf.model.ESFFieldESFElectronic fetchESFFieldESFElectronic(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return _esfFieldESFElectronicLocalService.fetchESFFieldESFElectronic(id);
	}

	/**
	* Returns the e s f field e s f electronic with the primary key.
	*
	* @param id the primary key of the e s f field e s f electronic
	* @return the e s f field e s f electronic
	* @throws PortalException if a e s f field e s f electronic with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFFieldESFElectronic getESFFieldESFElectronic(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfFieldESFElectronicLocalService.getESFFieldESFElectronic(id);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfFieldESFElectronicLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the e s f field e s f electronics.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFieldESFElectronicModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f field e s f electronics
	* @param end the upper bound of the range of e s f field e s f electronics (not inclusive)
	* @return the range of e s f field e s f electronics
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<it.ethica.esf.model.ESFFieldESFElectronic> getESFFieldESFElectronics(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfFieldESFElectronicLocalService.getESFFieldESFElectronics(start,
			end);
	}

	/**
	* Returns the number of e s f field e s f electronics.
	*
	* @return the number of e s f field e s f electronics
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getESFFieldESFElectronicsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfFieldESFElectronicLocalService.getESFFieldESFElectronicsCount();
	}

	/**
	* Updates the e s f field e s f electronic in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param esfFieldESFElectronic the e s f field e s f electronic
	* @return the e s f field e s f electronic that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFFieldESFElectronic updateESFFieldESFElectronic(
		it.ethica.esf.model.ESFFieldESFElectronic esfFieldESFElectronic)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfFieldESFElectronicLocalService.updateESFFieldESFElectronic(esfFieldESFElectronic);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _esfFieldESFElectronicLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_esfFieldESFElectronicLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _esfFieldESFElectronicLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFFieldESFElectronic> findByFieldId(
		long fieldId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfFieldESFElectronicLocalService.findByFieldId(fieldId);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFFieldESFElectronic> findByBrandId(
		long brandId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfFieldESFElectronicLocalService.findByBrandId(brandId);
	}

	@Override
	public it.ethica.esf.model.ESFFieldESFElectronic findByFieldIdBrandIdElectronicId(
		long fieldId, long brandId, long electronicId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfFieldESFElectronicLocalService.findByFieldIdBrandIdElectronicId(fieldId,
			brandId, electronicId);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFFieldESFElectronic> findByElectronicId(
		long electronicId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfFieldESFElectronicLocalService.findByElectronicId(electronicId);
	}

	@Override
	public it.ethica.esf.model.ESFFieldESFElectronic addESFFieldESFElectronic(
		long brandId, long electronicId, long fieldId,
		java.lang.String description,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfFieldESFElectronicLocalService.addESFFieldESFElectronic(brandId,
			electronicId, fieldId, description, serviceContext);
	}

	@Override
	public it.ethica.esf.model.ESFFieldESFElectronic updateESFFieldESFElectronic(
		long esfFieldESFElectronicId, long brandId, long electronicId,
		long fieldId, java.lang.String description,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfFieldESFElectronicLocalService.updateESFFieldESFElectronic(esfFieldESFElectronicId,
			brandId, electronicId, fieldId, description, serviceContext);
	}

	@Override
	public it.ethica.esf.model.ESFFieldESFElectronic deleteESFFieldESFElectronic(
		long esfFieldESFElectronicId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfFieldESFElectronicLocalService.deleteESFFieldESFElectronic(esfFieldESFElectronicId,
			serviceContext);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ESFFieldESFElectronicLocalService getWrappedESFFieldESFElectronicLocalService() {
		return _esfFieldESFElectronicLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedESFFieldESFElectronicLocalService(
		ESFFieldESFElectronicLocalService esfFieldESFElectronicLocalService) {
		_esfFieldESFElectronicLocalService = esfFieldESFElectronicLocalService;
	}

	@Override
	public ESFFieldESFElectronicLocalService getWrappedService() {
		return _esfFieldESFElectronicLocalService;
	}

	@Override
	public void setWrappedService(
		ESFFieldESFElectronicLocalService esfFieldESFElectronicLocalService) {
		_esfFieldESFElectronicLocalService = esfFieldESFElectronicLocalService;
	}

	private ESFFieldESFElectronicLocalService _esfFieldESFElectronicLocalService;
}