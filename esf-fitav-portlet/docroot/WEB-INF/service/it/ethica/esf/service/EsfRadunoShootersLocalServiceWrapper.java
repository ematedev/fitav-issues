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
 * Provides a wrapper for {@link EsfRadunoShootersLocalService}.
 *
 * @author Ethica
 * @see EsfRadunoShootersLocalService
 * @generated
 */
public class EsfRadunoShootersLocalServiceWrapper
	implements EsfRadunoShootersLocalService,
		ServiceWrapper<EsfRadunoShootersLocalService> {
	public EsfRadunoShootersLocalServiceWrapper(
		EsfRadunoShootersLocalService esfRadunoShootersLocalService) {
		_esfRadunoShootersLocalService = esfRadunoShootersLocalService;
	}

	/**
	* Adds the esf raduno shooters to the database. Also notifies the appropriate model listeners.
	*
	* @param esfRadunoShooters the esf raduno shooters
	* @return the esf raduno shooters that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.EsfRadunoShooters addEsfRadunoShooters(
		it.ethica.esf.model.EsfRadunoShooters esfRadunoShooters)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfRadunoShootersLocalService.addEsfRadunoShooters(esfRadunoShooters);
	}

	/**
	* Creates a new esf raduno shooters with the primary key. Does not add the esf raduno shooters to the database.
	*
	* @param esfRadunoShootersPK the primary key for the new esf raduno shooters
	* @return the new esf raduno shooters
	*/
	@Override
	public it.ethica.esf.model.EsfRadunoShooters createEsfRadunoShooters(
		it.ethica.esf.service.persistence.EsfRadunoShootersPK esfRadunoShootersPK) {
		return _esfRadunoShootersLocalService.createEsfRadunoShooters(esfRadunoShootersPK);
	}

	/**
	* Deletes the esf raduno shooters with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfRadunoShootersPK the primary key of the esf raduno shooters
	* @return the esf raduno shooters that was removed
	* @throws PortalException if a esf raduno shooters with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.EsfRadunoShooters deleteEsfRadunoShooters(
		it.ethica.esf.service.persistence.EsfRadunoShootersPK esfRadunoShootersPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfRadunoShootersLocalService.deleteEsfRadunoShooters(esfRadunoShootersPK);
	}

	/**
	* Deletes the esf raduno shooters from the database. Also notifies the appropriate model listeners.
	*
	* @param esfRadunoShooters the esf raduno shooters
	* @return the esf raduno shooters that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.EsfRadunoShooters deleteEsfRadunoShooters(
		it.ethica.esf.model.EsfRadunoShooters esfRadunoShooters)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfRadunoShootersLocalService.deleteEsfRadunoShooters(esfRadunoShooters);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _esfRadunoShootersLocalService.dynamicQuery();
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
		return _esfRadunoShootersLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.EsfRadunoShootersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _esfRadunoShootersLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.EsfRadunoShootersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _esfRadunoShootersLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
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
		return _esfRadunoShootersLocalService.dynamicQueryCount(dynamicQuery);
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
		return _esfRadunoShootersLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public it.ethica.esf.model.EsfRadunoShooters fetchEsfRadunoShooters(
		it.ethica.esf.service.persistence.EsfRadunoShootersPK esfRadunoShootersPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfRadunoShootersLocalService.fetchEsfRadunoShooters(esfRadunoShootersPK);
	}

	/**
	* Returns the esf raduno shooters with the primary key.
	*
	* @param esfRadunoShootersPK the primary key of the esf raduno shooters
	* @return the esf raduno shooters
	* @throws PortalException if a esf raduno shooters with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.EsfRadunoShooters getEsfRadunoShooters(
		it.ethica.esf.service.persistence.EsfRadunoShootersPK esfRadunoShootersPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfRadunoShootersLocalService.getEsfRadunoShooters(esfRadunoShootersPK);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfRadunoShootersLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the esf raduno shooterses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.EsfRadunoShootersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of esf raduno shooterses
	* @param end the upper bound of the range of esf raduno shooterses (not inclusive)
	* @return the range of esf raduno shooterses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<it.ethica.esf.model.EsfRadunoShooters> getEsfRadunoShooterses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfRadunoShootersLocalService.getEsfRadunoShooterses(start, end);
	}

	/**
	* Returns the number of esf raduno shooterses.
	*
	* @return the number of esf raduno shooterses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getEsfRadunoShootersesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfRadunoShootersLocalService.getEsfRadunoShootersesCount();
	}

	/**
	* Updates the esf raduno shooters in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param esfRadunoShooters the esf raduno shooters
	* @return the esf raduno shooters that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.EsfRadunoShooters updateEsfRadunoShooters(
		it.ethica.esf.model.EsfRadunoShooters esfRadunoShooters)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfRadunoShootersLocalService.updateEsfRadunoShooters(esfRadunoShooters);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _esfRadunoShootersLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_esfRadunoShootersLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _esfRadunoShootersLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public java.util.List<it.ethica.esf.model.EsfRadunoShooters> findById(
		long id_esf_raduno)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfRadunoShootersLocalService.findById(id_esf_raduno);
	}

	@Override
	public void associaShooters(long id_esf_raduno,
		java.util.List<java.lang.String> listaChecked,
		java.util.List<java.lang.String> listaUnchecked)
		throws com.liferay.portal.kernel.exception.SystemException,
			java.lang.NumberFormatException {
		_esfRadunoShootersLocalService.associaShooters(id_esf_raduno,
			listaChecked, listaUnchecked);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public EsfRadunoShootersLocalService getWrappedEsfRadunoShootersLocalService() {
		return _esfRadunoShootersLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedEsfRadunoShootersLocalService(
		EsfRadunoShootersLocalService esfRadunoShootersLocalService) {
		_esfRadunoShootersLocalService = esfRadunoShootersLocalService;
	}

	@Override
	public EsfRadunoShootersLocalService getWrappedService() {
		return _esfRadunoShootersLocalService;
	}

	@Override
	public void setWrappedService(
		EsfRadunoShootersLocalService esfRadunoShootersLocalService) {
		_esfRadunoShootersLocalService = esfRadunoShootersLocalService;
	}

	private EsfRadunoShootersLocalService _esfRadunoShootersLocalService;
}