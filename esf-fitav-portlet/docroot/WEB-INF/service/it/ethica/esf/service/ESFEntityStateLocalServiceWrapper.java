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
 * Provides a wrapper for {@link ESFEntityStateLocalService}.
 *
 * @author Ethica
 * @see ESFEntityStateLocalService
 * @generated
 */
public class ESFEntityStateLocalServiceWrapper
	implements ESFEntityStateLocalService,
		ServiceWrapper<ESFEntityStateLocalService> {
	public ESFEntityStateLocalServiceWrapper(
		ESFEntityStateLocalService esfEntityStateLocalService) {
		_esfEntityStateLocalService = esfEntityStateLocalService;
	}

	/**
	* Adds the e s f entity state to the database. Also notifies the appropriate model listeners.
	*
	* @param esfEntityState the e s f entity state
	* @return the e s f entity state that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFEntityState addESFEntityState(
		it.ethica.esf.model.ESFEntityState esfEntityState)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfEntityStateLocalService.addESFEntityState(esfEntityState);
	}

	/**
	* Creates a new e s f entity state with the primary key. Does not add the e s f entity state to the database.
	*
	* @param esfEntityStateId the primary key for the new e s f entity state
	* @return the new e s f entity state
	*/
	@Override
	public it.ethica.esf.model.ESFEntityState createESFEntityState(
		long esfEntityStateId) {
		return _esfEntityStateLocalService.createESFEntityState(esfEntityStateId);
	}

	/**
	* Deletes the e s f entity state with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfEntityStateId the primary key of the e s f entity state
	* @return the e s f entity state that was removed
	* @throws PortalException if a e s f entity state with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFEntityState deleteESFEntityState(
		long esfEntityStateId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfEntityStateLocalService.deleteESFEntityState(esfEntityStateId);
	}

	/**
	* Deletes the e s f entity state from the database. Also notifies the appropriate model listeners.
	*
	* @param esfEntityState the e s f entity state
	* @return the e s f entity state that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFEntityState deleteESFEntityState(
		it.ethica.esf.model.ESFEntityState esfEntityState)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfEntityStateLocalService.deleteESFEntityState(esfEntityState);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _esfEntityStateLocalService.dynamicQuery();
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
		return _esfEntityStateLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFEntityStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _esfEntityStateLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFEntityStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _esfEntityStateLocalService.dynamicQuery(dynamicQuery, start,
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
		return _esfEntityStateLocalService.dynamicQueryCount(dynamicQuery);
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
		return _esfEntityStateLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public it.ethica.esf.model.ESFEntityState fetchESFEntityState(
		long esfEntityStateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfEntityStateLocalService.fetchESFEntityState(esfEntityStateId);
	}

	/**
	* Returns the e s f entity state with the primary key.
	*
	* @param esfEntityStateId the primary key of the e s f entity state
	* @return the e s f entity state
	* @throws PortalException if a e s f entity state with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFEntityState getESFEntityState(
		long esfEntityStateId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfEntityStateLocalService.getESFEntityState(esfEntityStateId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfEntityStateLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the e s f entity states.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFEntityStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f entity states
	* @param end the upper bound of the range of e s f entity states (not inclusive)
	* @return the range of e s f entity states
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<it.ethica.esf.model.ESFEntityState> getESFEntityStates(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfEntityStateLocalService.getESFEntityStates(start, end);
	}

	/**
	* Returns the number of e s f entity states.
	*
	* @return the number of e s f entity states
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getESFEntityStatesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfEntityStateLocalService.getESFEntityStatesCount();
	}

	/**
	* Updates the e s f entity state in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param esfEntityState the e s f entity state
	* @return the e s f entity state that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFEntityState updateESFEntityState(
		it.ethica.esf.model.ESFEntityState esfEntityState)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfEntityStateLocalService.updateESFEntityState(esfEntityState);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _esfEntityStateLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_esfEntityStateLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _esfEntityStateLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	* Ricerca l'entit� ESFEntityState sulla base dei sequenti filtri: -
	* className; - classPK; - WHERE CONDITION ( endDate=null )
	*
	* @throws SystemException
	*/
	@Override
	public java.util.List<it.ethica.esf.model.ESFEntityState> findESFEntityStateByCN(
		java.lang.String className)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfEntityStateLocalService.findESFEntityStateByCN(className);
	}

	@Override
	public it.ethica.esf.model.ESFEntityState findESFEntityStateByC_PK(
		java.lang.String className, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfEntityStateLocalService.findESFEntityStateByC_PK(className,
			classPK);
	}

	/**
	* Ricerca l'entit� ESFEntityState sulla base dei sequenti filtri: -
	* className; - classPK; - esfStateId - WHERE CONDITION ( endDate=null )
	*/
	@Override
	public it.ethica.esf.model.ESFEntityState findESFEntityStateByC_PK_S(
		java.lang.String className, long classPK, long esfStateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfEntityStateLocalService.findESFEntityStateByC_PK_S(className,
			classPK, esfStateId);
	}

	/**
	* Ricerca le entit� ESFEntityState sulla base dei sequenti filtri: -
	* className; - esfStateId - WHERE CONDITION ( endDate=null )
	*/
	@Override
	public java.util.List<it.ethica.esf.model.ESFEntityState> findESFEntityStateByC_S(
		java.lang.String className, long esfStateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfEntityStateLocalService.findESFEntityStateByC_S(className,
			esfStateId);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFEntityState> findESFEntityStateCName_CPk(
		java.lang.String className, long classPk)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfEntityStateLocalService.findESFEntityStateCName_CPk(className,
			classPk);
	}

	/**
	* Ricerca le entit� ESFEntityState sulla base dei sequenti filtri: -
	* className; - esfStateId - WHERE CONDITION ( endDate=null )
	*/
	@Override
	public java.util.List<it.ethica.esf.model.ESFEntityState> findESFEntityStateByC_S(
		java.lang.String className, long esfStateId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfEntityStateLocalService.findESFEntityStateByC_S(className,
			esfStateId, start, end);
	}

	@Override
	public it.ethica.esf.model.ESFEntityState addEntityState(long userId,
		long groupId, long companyId, java.lang.String className, long classPK,
		long esfStateId)
		throws com.liferay.portal.NoSuchUserException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfEntityStateLocalService.addEntityState(userId, groupId,
			companyId, className, classPK, esfStateId);
	}

	@Override
	public it.ethica.esf.model.ESFEntityState addEntityState(long userId,
		java.lang.String className, long classPK, long esfStateId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.NoSuchUserException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfEntityStateLocalService.addEntityState(userId, className,
			classPK, esfStateId, serviceContext);
	}

	@Override
	public it.ethica.esf.model.ESFEntityState addEntityState(long userId,
		java.lang.String className, long classPK, long esfStateId,
		java.util.Date startDate, java.util.Date endDate,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.NoSuchUserException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfEntityStateLocalService.addEntityState(userId, className,
			classPK, esfStateId, startDate, endDate, serviceContext);
	}

	/**
	* Effettua l'update di tutti i parametri di ESFEntityState settando la data
	* endDate = data attuale
	*/
	@Override
	public it.ethica.esf.model.ESFEntityState updateEntityState(long userId,
		long esfEntityStateId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfEntityStateLocalService.updateEntityState(userId,
			esfEntityStateId, serviceContext);
	}

	/**
	* Ricerca l'entit� ESFEntityState sulla base dei sequenti filtri: -
	* className; - classPK;
	*/
	@Override
	public it.ethica.esf.model.ESFEntityState findAllESFEntityStateByClassName_ClassPK(
		java.lang.String className, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfEntityStateLocalService.findAllESFEntityStateByClassName_ClassPK(className,
			classPK);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFEntityState> findESShooterLastCardActive(
		long shooterId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfEntityStateLocalService.findESShooterLastCardActive(shooterId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ESFEntityStateLocalService getWrappedESFEntityStateLocalService() {
		return _esfEntityStateLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedESFEntityStateLocalService(
		ESFEntityStateLocalService esfEntityStateLocalService) {
		_esfEntityStateLocalService = esfEntityStateLocalService;
	}

	@Override
	public ESFEntityStateLocalService getWrappedService() {
		return _esfEntityStateLocalService;
	}

	@Override
	public void setWrappedService(
		ESFEntityStateLocalService esfEntityStateLocalService) {
		_esfEntityStateLocalService = esfEntityStateLocalService;
	}

	private ESFEntityStateLocalService _esfEntityStateLocalService;
}