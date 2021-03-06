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
 * Provides a wrapper for {@link ESFMatchResultLocalService}.
 *
 * @author Ethica
 * @see ESFMatchResultLocalService
 * @generated
 */
public class ESFMatchResultLocalServiceWrapper
	implements ESFMatchResultLocalService,
		ServiceWrapper<ESFMatchResultLocalService> {
	public ESFMatchResultLocalServiceWrapper(
		ESFMatchResultLocalService esfMatchResultLocalService) {
		_esfMatchResultLocalService = esfMatchResultLocalService;
	}

	/**
	* Adds the e s f match result to the database. Also notifies the appropriate model listeners.
	*
	* @param esfMatchResult the e s f match result
	* @return the e s f match result that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFMatchResult addESFMatchResult(
		it.ethica.esf.model.ESFMatchResult esfMatchResult)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfMatchResultLocalService.addESFMatchResult(esfMatchResult);
	}

	/**
	* Creates a new e s f match result with the primary key. Does not add the e s f match result to the database.
	*
	* @param esfMatchResultId the primary key for the new e s f match result
	* @return the new e s f match result
	*/
	@Override
	public it.ethica.esf.model.ESFMatchResult createESFMatchResult(
		long esfMatchResultId) {
		return _esfMatchResultLocalService.createESFMatchResult(esfMatchResultId);
	}

	/**
	* Deletes the e s f match result with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfMatchResultId the primary key of the e s f match result
	* @return the e s f match result that was removed
	* @throws PortalException if a e s f match result with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFMatchResult deleteESFMatchResult(
		long esfMatchResultId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfMatchResultLocalService.deleteESFMatchResult(esfMatchResultId);
	}

	/**
	* Deletes the e s f match result from the database. Also notifies the appropriate model listeners.
	*
	* @param esfMatchResult the e s f match result
	* @return the e s f match result that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFMatchResult deleteESFMatchResult(
		it.ethica.esf.model.ESFMatchResult esfMatchResult)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfMatchResultLocalService.deleteESFMatchResult(esfMatchResult);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _esfMatchResultLocalService.dynamicQuery();
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
		return _esfMatchResultLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFMatchResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _esfMatchResultLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFMatchResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _esfMatchResultLocalService.dynamicQuery(dynamicQuery, start,
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
		return _esfMatchResultLocalService.dynamicQueryCount(dynamicQuery);
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
		return _esfMatchResultLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public it.ethica.esf.model.ESFMatchResult fetchESFMatchResult(
		long esfMatchResultId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfMatchResultLocalService.fetchESFMatchResult(esfMatchResultId);
	}

	/**
	* Returns the e s f match result with the primary key.
	*
	* @param esfMatchResultId the primary key of the e s f match result
	* @return the e s f match result
	* @throws PortalException if a e s f match result with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFMatchResult getESFMatchResult(
		long esfMatchResultId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfMatchResultLocalService.getESFMatchResult(esfMatchResultId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfMatchResultLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the e s f match results.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFMatchResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f match results
	* @param end the upper bound of the range of e s f match results (not inclusive)
	* @return the range of e s f match results
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<it.ethica.esf.model.ESFMatchResult> getESFMatchResults(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfMatchResultLocalService.getESFMatchResults(start, end);
	}

	/**
	* Returns the number of e s f match results.
	*
	* @return the number of e s f match results
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getESFMatchResultsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfMatchResultLocalService.getESFMatchResultsCount();
	}

	/**
	* Updates the e s f match result in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param esfMatchResult the e s f match result
	* @return the e s f match result that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFMatchResult updateESFMatchResult(
		it.ethica.esf.model.ESFMatchResult esfMatchResult)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfMatchResultLocalService.updateESFMatchResult(esfMatchResult);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _esfMatchResultLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_esfMatchResultLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _esfMatchResultLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFMatchResult> findbyEsfMatchId(
		long esfMatchId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfMatchResultLocalService.findbyEsfMatchId(esfMatchId);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFMatchResult> findByResultUserId(
		long esfPartecipantId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfMatchResultLocalService.findByResultUserId(esfPartecipantId);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFMatchResult> findByResultUserId(
		long esfPartecipantId, long matchId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfMatchResultLocalService.findByResultUserId(esfPartecipantId,
			matchId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ESFMatchResultLocalService getWrappedESFMatchResultLocalService() {
		return _esfMatchResultLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedESFMatchResultLocalService(
		ESFMatchResultLocalService esfMatchResultLocalService) {
		_esfMatchResultLocalService = esfMatchResultLocalService;
	}

	@Override
	public ESFMatchResultLocalService getWrappedService() {
		return _esfMatchResultLocalService;
	}

	@Override
	public void setWrappedService(
		ESFMatchResultLocalService esfMatchResultLocalService) {
		_esfMatchResultLocalService = esfMatchResultLocalService;
	}

	private ESFMatchResultLocalService _esfMatchResultLocalService;
}