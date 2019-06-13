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
 * Provides a wrapper for {@link ESFRadunoTipoLocalService}.
 *
 * @author Ethica
 * @see ESFRadunoTipoLocalService
 * @generated
 */
public class ESFRadunoTipoLocalServiceWrapper
	implements ESFRadunoTipoLocalService,
		ServiceWrapper<ESFRadunoTipoLocalService> {
	public ESFRadunoTipoLocalServiceWrapper(
		ESFRadunoTipoLocalService esfRadunoTipoLocalService) {
		_esfRadunoTipoLocalService = esfRadunoTipoLocalService;
	}

	/**
	* Adds the e s f raduno tipo to the database. Also notifies the appropriate model listeners.
	*
	* @param esfRadunoTipo the e s f raduno tipo
	* @return the e s f raduno tipo that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFRadunoTipo addESFRadunoTipo(
		it.ethica.esf.model.ESFRadunoTipo esfRadunoTipo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfRadunoTipoLocalService.addESFRadunoTipo(esfRadunoTipo);
	}

	/**
	* Creates a new e s f raduno tipo with the primary key. Does not add the e s f raduno tipo to the database.
	*
	* @param id_esf_raduno_tipo the primary key for the new e s f raduno tipo
	* @return the new e s f raduno tipo
	*/
	@Override
	public it.ethica.esf.model.ESFRadunoTipo createESFRadunoTipo(
		long id_esf_raduno_tipo) {
		return _esfRadunoTipoLocalService.createESFRadunoTipo(id_esf_raduno_tipo);
	}

	/**
	* Deletes the e s f raduno tipo with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_esf_raduno_tipo the primary key of the e s f raduno tipo
	* @return the e s f raduno tipo that was removed
	* @throws PortalException if a e s f raduno tipo with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFRadunoTipo deleteESFRadunoTipo(
		long id_esf_raduno_tipo)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfRadunoTipoLocalService.deleteESFRadunoTipo(id_esf_raduno_tipo);
	}

	/**
	* Deletes the e s f raduno tipo from the database. Also notifies the appropriate model listeners.
	*
	* @param esfRadunoTipo the e s f raduno tipo
	* @return the e s f raduno tipo that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFRadunoTipo deleteESFRadunoTipo(
		it.ethica.esf.model.ESFRadunoTipo esfRadunoTipo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfRadunoTipoLocalService.deleteESFRadunoTipo(esfRadunoTipo);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _esfRadunoTipoLocalService.dynamicQuery();
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
		return _esfRadunoTipoLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFRadunoTipoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _esfRadunoTipoLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFRadunoTipoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _esfRadunoTipoLocalService.dynamicQuery(dynamicQuery, start,
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
		return _esfRadunoTipoLocalService.dynamicQueryCount(dynamicQuery);
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
		return _esfRadunoTipoLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public it.ethica.esf.model.ESFRadunoTipo fetchESFRadunoTipo(
		long id_esf_raduno_tipo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfRadunoTipoLocalService.fetchESFRadunoTipo(id_esf_raduno_tipo);
	}

	/**
	* Returns the e s f raduno tipo with the primary key.
	*
	* @param id_esf_raduno_tipo the primary key of the e s f raduno tipo
	* @return the e s f raduno tipo
	* @throws PortalException if a e s f raduno tipo with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFRadunoTipo getESFRadunoTipo(
		long id_esf_raduno_tipo)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfRadunoTipoLocalService.getESFRadunoTipo(id_esf_raduno_tipo);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfRadunoTipoLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the e s f raduno tipos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFRadunoTipoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f raduno tipos
	* @param end the upper bound of the range of e s f raduno tipos (not inclusive)
	* @return the range of e s f raduno tipos
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<it.ethica.esf.model.ESFRadunoTipo> getESFRadunoTipos(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfRadunoTipoLocalService.getESFRadunoTipos(start, end);
	}

	/**
	* Returns the number of e s f raduno tipos.
	*
	* @return the number of e s f raduno tipos
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getESFRadunoTiposCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfRadunoTipoLocalService.getESFRadunoTiposCount();
	}

	/**
	* Updates the e s f raduno tipo in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param esfRadunoTipo the e s f raduno tipo
	* @return the e s f raduno tipo that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFRadunoTipo updateESFRadunoTipo(
		it.ethica.esf.model.ESFRadunoTipo esfRadunoTipo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfRadunoTipoLocalService.updateESFRadunoTipo(esfRadunoTipo);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _esfRadunoTipoLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_esfRadunoTipoLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _esfRadunoTipoLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFRadunoTipo> findAllTipi()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfRadunoTipoLocalService.findAllTipi();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ESFRadunoTipoLocalService getWrappedESFRadunoTipoLocalService() {
		return _esfRadunoTipoLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedESFRadunoTipoLocalService(
		ESFRadunoTipoLocalService esfRadunoTipoLocalService) {
		_esfRadunoTipoLocalService = esfRadunoTipoLocalService;
	}

	@Override
	public ESFRadunoTipoLocalService getWrappedService() {
		return _esfRadunoTipoLocalService;
	}

	@Override
	public void setWrappedService(
		ESFRadunoTipoLocalService esfRadunoTipoLocalService) {
		_esfRadunoTipoLocalService = esfRadunoTipoLocalService;
	}

	private ESFRadunoTipoLocalService _esfRadunoTipoLocalService;
}