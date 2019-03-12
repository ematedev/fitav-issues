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
 * Provides a wrapper for {@link ESFCatridgeLocalService}.
 *
 * @author Ethica
 * @see ESFCatridgeLocalService
 * @generated
 */
public class ESFCatridgeLocalServiceWrapper implements ESFCatridgeLocalService,
	ServiceWrapper<ESFCatridgeLocalService> {
	public ESFCatridgeLocalServiceWrapper(
		ESFCatridgeLocalService esfCatridgeLocalService) {
		_esfCatridgeLocalService = esfCatridgeLocalService;
	}

	/**
	* Adds the e s f catridge to the database. Also notifies the appropriate model listeners.
	*
	* @param esfCatridge the e s f catridge
	* @return the e s f catridge that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFCatridge addESFCatridge(
		it.ethica.esf.model.ESFCatridge esfCatridge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfCatridgeLocalService.addESFCatridge(esfCatridge);
	}

	/**
	* Creates a new e s f catridge with the primary key. Does not add the e s f catridge to the database.
	*
	* @param esfCatridgeId the primary key for the new e s f catridge
	* @return the new e s f catridge
	*/
	@Override
	public it.ethica.esf.model.ESFCatridge createESFCatridge(long esfCatridgeId) {
		return _esfCatridgeLocalService.createESFCatridge(esfCatridgeId);
	}

	/**
	* Deletes the e s f catridge with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfCatridgeId the primary key of the e s f catridge
	* @return the e s f catridge that was removed
	* @throws PortalException if a e s f catridge with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFCatridge deleteESFCatridge(long esfCatridgeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfCatridgeLocalService.deleteESFCatridge(esfCatridgeId);
	}

	/**
	* Deletes the e s f catridge from the database. Also notifies the appropriate model listeners.
	*
	* @param esfCatridge the e s f catridge
	* @return the e s f catridge that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFCatridge deleteESFCatridge(
		it.ethica.esf.model.ESFCatridge esfCatridge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfCatridgeLocalService.deleteESFCatridge(esfCatridge);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _esfCatridgeLocalService.dynamicQuery();
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
		return _esfCatridgeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFCatridgeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _esfCatridgeLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFCatridgeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _esfCatridgeLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _esfCatridgeLocalService.dynamicQueryCount(dynamicQuery);
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
		return _esfCatridgeLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public it.ethica.esf.model.ESFCatridge fetchESFCatridge(long esfCatridgeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfCatridgeLocalService.fetchESFCatridge(esfCatridgeId);
	}

	/**
	* Returns the e s f catridge with the primary key.
	*
	* @param esfCatridgeId the primary key of the e s f catridge
	* @return the e s f catridge
	* @throws PortalException if a e s f catridge with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFCatridge getESFCatridge(long esfCatridgeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfCatridgeLocalService.getESFCatridge(esfCatridgeId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfCatridgeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the e s f catridges.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFCatridgeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f catridges
	* @param end the upper bound of the range of e s f catridges (not inclusive)
	* @return the range of e s f catridges
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<it.ethica.esf.model.ESFCatridge> getESFCatridges(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfCatridgeLocalService.getESFCatridges(start, end);
	}

	/**
	* Returns the number of e s f catridges.
	*
	* @return the number of e s f catridges
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getESFCatridgesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfCatridgeLocalService.getESFCatridgesCount();
	}

	/**
	* Updates the e s f catridge in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param esfCatridge the e s f catridge
	* @return the e s f catridge that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFCatridge updateESFCatridge(
		it.ethica.esf.model.ESFCatridge esfCatridge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfCatridgeLocalService.updateESFCatridge(esfCatridge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _esfCatridgeLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_esfCatridgeLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _esfCatridgeLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	* Ricerca tutti gli oggetti ESFCatridge sulla base dell'utente.
	*
	* @param esfUserId l'identificativo dell'utente
	* @return List<ESFCatridge>
	*/
	@Override
	public java.util.List<it.ethica.esf.model.ESFCatridge> getESFCatridgesByUserId(
		long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfCatridgeLocalService.getESFCatridgesByUserId(esfUserId);
	}

	/**
	* Ricerca tutti gli oggetti ESFCatridge sulla base dell'utente.
	* I parametri di <b>start</b> e <b>end</b> definiscono il range di oggetti da restituire
	*
	* @param esfUserId l'identificativo dell'utente
	* @param start
	* @param end
	* @return List<ESFCatridge>
	*/
	@Override
	public java.util.List<it.ethica.esf.model.ESFCatridge> getESFCatridgesByUserId(
		long esfUserId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfCatridgeLocalService.getESFCatridgesByUserId(esfUserId,
			start, end);
	}

	/**
	* Ricerca le cartucce in base al produttore
	*/
	@Override
	public java.util.List<it.ethica.esf.model.ESFCatridge> getESFCatridgesByType(
		long esfTypeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfCatridgeLocalService.getESFCatridgesByType(esfTypeId, start,
			end);
	}

	@Override
	public int countESFCatridgesByType(long esfTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfCatridgeLocalService.countESFCatridgesByType(esfTypeId);
	}

	/**
	* Ricerca tutti gli oggetti ESFCatridge.
	* I parametri di <b>start</b> e <b>end</b> definiscono il range di oggetti da restituire
	*
	* @return List<ESFCatridge>
	*/
	@Override
	public java.util.List<it.ethica.esf.model.ESFCatridge> getESFCatridges()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfCatridgeLocalService.getESFCatridges();
	}

	@Override
	public it.ethica.esf.model.ESFCatridge addESFCatridge(long userId,
		long esfGunTypeId, long esfUserId, java.lang.String catridgeModel,
		long catridgeCaliber, java.lang.String note,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfCatridgeLocalService.addESFCatridge(userId, esfGunTypeId,
			esfUserId, catridgeModel, catridgeCaliber, note, serviceContext);
	}

	@Override
	public it.ethica.esf.model.ESFCatridge updateESFCatridge(long userId,
		long esfCatridgeId, long esfGunTypeId, long esfUserId,
		java.lang.String catridgeModel, long catridgeCaliber,
		java.lang.String note,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfCatridgeLocalService.updateESFCatridge(userId,
			esfCatridgeId, esfGunTypeId, esfUserId, catridgeModel,
			catridgeCaliber, note, serviceContext);
	}

	@Override
	public it.ethica.esf.model.ESFCatridge deleteESFCatridge(
		long esfCatridgeId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfCatridgeLocalService.deleteESFCatridge(esfCatridgeId,
			serviceContext);
	}

	@Override
	public java.lang.String getNameM(
		it.ethica.esf.model.ESFCatridge esfCatridge)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfCatridgeLocalService.getNameM(esfCatridge);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ESFCatridgeLocalService getWrappedESFCatridgeLocalService() {
		return _esfCatridgeLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedESFCatridgeLocalService(
		ESFCatridgeLocalService esfCatridgeLocalService) {
		_esfCatridgeLocalService = esfCatridgeLocalService;
	}

	@Override
	public ESFCatridgeLocalService getWrappedService() {
		return _esfCatridgeLocalService;
	}

	@Override
	public void setWrappedService(
		ESFCatridgeLocalService esfCatridgeLocalService) {
		_esfCatridgeLocalService = esfCatridgeLocalService;
	}

	private ESFCatridgeLocalService _esfCatridgeLocalService;
}