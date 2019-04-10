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
 * Provides a wrapper for {@link ESFTransitionLocalService}.
 *
 * @author Ethica
 * @see ESFTransitionLocalService
 * @generated
 */
public class ESFTransitionLocalServiceWrapper
	implements ESFTransitionLocalService,
		ServiceWrapper<ESFTransitionLocalService> {
	public ESFTransitionLocalServiceWrapper(
		ESFTransitionLocalService esfTransitionLocalService) {
		_esfTransitionLocalService = esfTransitionLocalService;
	}

	/**
	* Adds the e s f transition to the database. Also notifies the appropriate model listeners.
	*
	* @param esfTransition the e s f transition
	* @return the e s f transition that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFTransition addESFTransition(
		it.ethica.esf.model.ESFTransition esfTransition)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfTransitionLocalService.addESFTransition(esfTransition);
	}

	/**
	* Creates a new e s f transition with the primary key. Does not add the e s f transition to the database.
	*
	* @param esfTransitionId the primary key for the new e s f transition
	* @return the new e s f transition
	*/
	@Override
	public it.ethica.esf.model.ESFTransition createESFTransition(
		long esfTransitionId) {
		return _esfTransitionLocalService.createESFTransition(esfTransitionId);
	}

	/**
	* Deletes the e s f transition with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfTransitionId the primary key of the e s f transition
	* @return the e s f transition that was removed
	* @throws PortalException if a e s f transition with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFTransition deleteESFTransition(
		long esfTransitionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfTransitionLocalService.deleteESFTransition(esfTransitionId);
	}

	/**
	* Deletes the e s f transition from the database. Also notifies the appropriate model listeners.
	*
	* @param esfTransition the e s f transition
	* @return the e s f transition that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFTransition deleteESFTransition(
		it.ethica.esf.model.ESFTransition esfTransition)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfTransitionLocalService.deleteESFTransition(esfTransition);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _esfTransitionLocalService.dynamicQuery();
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
		return _esfTransitionLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFTransitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _esfTransitionLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFTransitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _esfTransitionLocalService.dynamicQuery(dynamicQuery, start,
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
		return _esfTransitionLocalService.dynamicQueryCount(dynamicQuery);
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
		return _esfTransitionLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public it.ethica.esf.model.ESFTransition fetchESFTransition(
		long esfTransitionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfTransitionLocalService.fetchESFTransition(esfTransitionId);
	}

	/**
	* Returns the e s f transition with the primary key.
	*
	* @param esfTransitionId the primary key of the e s f transition
	* @return the e s f transition
	* @throws PortalException if a e s f transition with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFTransition getESFTransition(
		long esfTransitionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfTransitionLocalService.getESFTransition(esfTransitionId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfTransitionLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the e s f transitions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFTransitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f transitions
	* @param end the upper bound of the range of e s f transitions (not inclusive)
	* @return the range of e s f transitions
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<it.ethica.esf.model.ESFTransition> getESFTransitions(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfTransitionLocalService.getESFTransitions(start, end);
	}

	/**
	* Returns the number of e s f transitions.
	*
	* @return the number of e s f transitions
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getESFTransitionsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfTransitionLocalService.getESFTransitionsCount();
	}

	/**
	* Updates the e s f transition in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param esfTransition the e s f transition
	* @return the e s f transition that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFTransition updateESFTransition(
		it.ethica.esf.model.ESFTransition esfTransition)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfTransitionLocalService.updateESFTransition(esfTransition);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _esfTransitionLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_esfTransitionLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _esfTransitionLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ESFTransitionLocalService getWrappedESFTransitionLocalService() {
		return _esfTransitionLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedESFTransitionLocalService(
		ESFTransitionLocalService esfTransitionLocalService) {
		_esfTransitionLocalService = esfTransitionLocalService;
	}

	@Override
	public ESFTransitionLocalService getWrappedService() {
		return _esfTransitionLocalService;
	}

	@Override
	public void setWrappedService(
		ESFTransitionLocalService esfTransitionLocalService) {
		_esfTransitionLocalService = esfTransitionLocalService;
	}

	private ESFTransitionLocalService _esfTransitionLocalService;
}