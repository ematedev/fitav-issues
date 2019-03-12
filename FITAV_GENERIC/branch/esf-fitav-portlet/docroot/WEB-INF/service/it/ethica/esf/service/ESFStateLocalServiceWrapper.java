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
 * Provides a wrapper for {@link ESFStateLocalService}.
 *
 * @author Ethica
 * @see ESFStateLocalService
 * @generated
 */
public class ESFStateLocalServiceWrapper implements ESFStateLocalService,
	ServiceWrapper<ESFStateLocalService> {
	public ESFStateLocalServiceWrapper(
		ESFStateLocalService esfStateLocalService) {
		_esfStateLocalService = esfStateLocalService;
	}

	/**
	* Adds the e s f state to the database. Also notifies the appropriate model listeners.
	*
	* @param esfState the e s f state
	* @return the e s f state that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFState addESFState(
		it.ethica.esf.model.ESFState esfState)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfStateLocalService.addESFState(esfState);
	}

	/**
	* Creates a new e s f state with the primary key. Does not add the e s f state to the database.
	*
	* @param esfStateId the primary key for the new e s f state
	* @return the new e s f state
	*/
	@Override
	public it.ethica.esf.model.ESFState createESFState(long esfStateId) {
		return _esfStateLocalService.createESFState(esfStateId);
	}

	/**
	* Deletes the e s f state with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfStateId the primary key of the e s f state
	* @return the e s f state that was removed
	* @throws PortalException if a e s f state with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFState deleteESFState(long esfStateId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfStateLocalService.deleteESFState(esfStateId);
	}

	/**
	* Deletes the e s f state from the database. Also notifies the appropriate model listeners.
	*
	* @param esfState the e s f state
	* @return the e s f state that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFState deleteESFState(
		it.ethica.esf.model.ESFState esfState)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfStateLocalService.deleteESFState(esfState);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _esfStateLocalService.dynamicQuery();
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
		return _esfStateLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _esfStateLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _esfStateLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _esfStateLocalService.dynamicQueryCount(dynamicQuery);
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
		return _esfStateLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public it.ethica.esf.model.ESFState fetchESFState(long esfStateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfStateLocalService.fetchESFState(esfStateId);
	}

	/**
	* Returns the e s f state with the primary key.
	*
	* @param esfStateId the primary key of the e s f state
	* @return the e s f state
	* @throws PortalException if a e s f state with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFState getESFState(long esfStateId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfStateLocalService.getESFState(esfStateId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfStateLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the e s f states.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f states
	* @param end the upper bound of the range of e s f states (not inclusive)
	* @return the range of e s f states
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<it.ethica.esf.model.ESFState> getESFStates(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfStateLocalService.getESFStates(start, end);
	}

	/**
	* Returns the number of e s f states.
	*
	* @return the number of e s f states
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getESFStatesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfStateLocalService.getESFStatesCount();
	}

	/**
	* Updates the e s f state in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param esfState the e s f state
	* @return the e s f state that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFState updateESFState(
		it.ethica.esf.model.ESFState esfState)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfStateLocalService.updateESFState(esfState);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _esfStateLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_esfStateLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _esfStateLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFState> findESFStates(
		java.lang.String className)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfStateLocalService.findESFStates(className);
	}

	@Override
	public it.ethica.esf.model.ESFState findESFStateById(long esfStateId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchStateException {
		return _esfStateLocalService.findESFStateById(esfStateId);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFState> findAllESFStates()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfStateLocalService.findAllESFStates();
	}

	@Override
	public it.ethica.esf.model.ESFStateAssEntity getESFStateAssEntitybyId_CN(
		long esfStateId, java.lang.String className)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfStateLocalService.getESFStateAssEntitybyId_CN(esfStateId,
			className);
	}

	/**
	* Torna tutti i className associati alle entit� portlet ESF gi� assegnati
	* allo stato con id esfStateId
	*
	* @return entit� portlet ESF gi� assegnati ad uno stato
	* @throws SystemException
	*/
	@Override
	public java.util.List<com.liferay.portal.model.ClassName> getESFClassNameAssigned(
		long esfStateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfStateLocalService.getESFClassNameAssigned(esfStateId);
	}

	/**
	* Torna tutti i className associati alle entit� portlet ESF e ancora non
	* assegnati allo stato con id esfStateId
	*
	* @return entit� portlet ESF non assegnati ad uno stato
	* @throws SystemException
	*/
	@Override
	public java.util.List<com.liferay.portal.model.ClassName> getESFClassNameNotAssigned(
		long esfStateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfStateLocalService.getESFClassNameNotAssigned(esfStateId);
	}

	@Override
	public it.ethica.esf.model.ESFState addState(java.lang.String name,
		java.lang.String description)
		throws com.liferay.portal.NoSuchUserException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfStateLocalService.addState(name, description);
	}

	@Override
	public it.ethica.esf.model.ESFState updateState(long esfStateId,
		java.lang.String name, java.lang.String description)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfStateLocalService.updateState(esfStateId, name, description);
	}

	@Override
	public it.ethica.esf.model.ESFState deleteState(long esfStateId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfStateLocalService.deleteState(esfStateId);
	}

	@Override
	public it.ethica.esf.model.ESFStateAssEntity addESFStateAssEntity(
		long esfStateId, long classNameId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfStateLocalService.addESFStateAssEntity(esfStateId,
			classNameId);
	}

	@Override
	public it.ethica.esf.model.ESFStateAssEntity deleteESFStateAssEntity(
		long esfStateId, long classNameId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfStateLocalService.deleteESFStateAssEntity(esfStateId,
			classNameId);
	}

	@Override
	public it.ethica.esf.model.ESFState checkName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfStateLocalService.checkName(name);
	}

	/**
	* Verifica se � stato assegnata una o pi� entit� allo stato con id
	* esfStateId
	*
	* @return true se gia assegnata
	*/
	@Override
	public boolean isStateAssEntity(long esfStateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfStateLocalService.isStateAssEntity(esfStateId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ESFStateLocalService getWrappedESFStateLocalService() {
		return _esfStateLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedESFStateLocalService(
		ESFStateLocalService esfStateLocalService) {
		_esfStateLocalService = esfStateLocalService;
	}

	@Override
	public ESFStateLocalService getWrappedService() {
		return _esfStateLocalService;
	}

	@Override
	public void setWrappedService(ESFStateLocalService esfStateLocalService) {
		_esfStateLocalService = esfStateLocalService;
	}

	private ESFStateLocalService _esfStateLocalService;
}