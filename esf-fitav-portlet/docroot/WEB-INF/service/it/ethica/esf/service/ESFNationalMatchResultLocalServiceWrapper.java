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
 * Provides a wrapper for {@link ESFNationalMatchResultLocalService}.
 *
 * @author Ethica
 * @see ESFNationalMatchResultLocalService
 * @generated
 */
public class ESFNationalMatchResultLocalServiceWrapper
	implements ESFNationalMatchResultLocalService,
		ServiceWrapper<ESFNationalMatchResultLocalService> {
	public ESFNationalMatchResultLocalServiceWrapper(
		ESFNationalMatchResultLocalService esfNationalMatchResultLocalService) {
		_esfNationalMatchResultLocalService = esfNationalMatchResultLocalService;
	}

	/**
	* Adds the e s f national match result to the database. Also notifies the appropriate model listeners.
	*
	* @param esfNationalMatchResult the e s f national match result
	* @return the e s f national match result that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFNationalMatchResult addESFNationalMatchResult(
		it.ethica.esf.model.ESFNationalMatchResult esfNationalMatchResult)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfNationalMatchResultLocalService.addESFNationalMatchResult(esfNationalMatchResult);
	}

	/**
	* Creates a new e s f national match result with the primary key. Does not add the e s f national match result to the database.
	*
	* @param esfNationalMatchResultId the primary key for the new e s f national match result
	* @return the new e s f national match result
	*/
	@Override
	public it.ethica.esf.model.ESFNationalMatchResult createESFNationalMatchResult(
		long esfNationalMatchResultId) {
		return _esfNationalMatchResultLocalService.createESFNationalMatchResult(esfNationalMatchResultId);
	}

	/**
	* Deletes the e s f national match result with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfNationalMatchResultId the primary key of the e s f national match result
	* @return the e s f national match result that was removed
	* @throws PortalException if a e s f national match result with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFNationalMatchResult deleteESFNationalMatchResult(
		long esfNationalMatchResultId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfNationalMatchResultLocalService.deleteESFNationalMatchResult(esfNationalMatchResultId);
	}

	/**
	* Deletes the e s f national match result from the database. Also notifies the appropriate model listeners.
	*
	* @param esfNationalMatchResult the e s f national match result
	* @return the e s f national match result that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFNationalMatchResult deleteESFNationalMatchResult(
		it.ethica.esf.model.ESFNationalMatchResult esfNationalMatchResult)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfNationalMatchResultLocalService.deleteESFNationalMatchResult(esfNationalMatchResult);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _esfNationalMatchResultLocalService.dynamicQuery();
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
		return _esfNationalMatchResultLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalMatchResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _esfNationalMatchResultLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalMatchResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _esfNationalMatchResultLocalService.dynamicQuery(dynamicQuery,
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
		return _esfNationalMatchResultLocalService.dynamicQueryCount(dynamicQuery);
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
		return _esfNationalMatchResultLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public it.ethica.esf.model.ESFNationalMatchResult fetchESFNationalMatchResult(
		long esfNationalMatchResultId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfNationalMatchResultLocalService.fetchESFNationalMatchResult(esfNationalMatchResultId);
	}

	/**
	* Returns the e s f national match result with the primary key.
	*
	* @param esfNationalMatchResultId the primary key of the e s f national match result
	* @return the e s f national match result
	* @throws PortalException if a e s f national match result with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFNationalMatchResult getESFNationalMatchResult(
		long esfNationalMatchResultId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfNationalMatchResultLocalService.getESFNationalMatchResult(esfNationalMatchResultId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfNationalMatchResultLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the e s f national match results.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalMatchResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f national match results
	* @param end the upper bound of the range of e s f national match results (not inclusive)
	* @return the range of e s f national match results
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<it.ethica.esf.model.ESFNationalMatchResult> getESFNationalMatchResults(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfNationalMatchResultLocalService.getESFNationalMatchResults(start,
			end);
	}

	/**
	* Returns the number of e s f national match results.
	*
	* @return the number of e s f national match results
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getESFNationalMatchResultsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfNationalMatchResultLocalService.getESFNationalMatchResultsCount();
	}

	/**
	* Updates the e s f national match result in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param esfNationalMatchResult the e s f national match result
	* @return the e s f national match result that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFNationalMatchResult updateESFNationalMatchResult(
		it.ethica.esf.model.ESFNationalMatchResult esfNationalMatchResult)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfNationalMatchResultLocalService.updateESFNationalMatchResult(esfNationalMatchResult);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _esfNationalMatchResultLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_esfNationalMatchResultLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _esfNationalMatchResultLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFNationalMatchResult> getESFNationalMatchResultsByESFMatchId(
		long esfMatchId) {
		return _esfNationalMatchResultLocalService.getESFNationalMatchResultsByESFMatchId(esfMatchId);
	}

	@Override
	public it.ethica.esf.model.ESFNationalMatchResult getESFNationalMatchResultByESFMatchId_ESFUserId(
		long esfMatchId, long esfUserId) {
		return _esfNationalMatchResultLocalService.getESFNationalMatchResultByESFMatchId_ESFUserId(esfMatchId,
			esfUserId);
	}

	@Override
	public it.ethica.esf.model.ESFNationalMatchResult getESFNationalMatchResultByESFMatchId_ESFUserId_SportTypeId(
		long esfMatchId, long esfUserId, long sportTypeId) {
		return _esfNationalMatchResultLocalService.getESFNationalMatchResultByESFMatchId_ESFUserId_SportTypeId(esfMatchId,
			esfUserId, sportTypeId);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFNationalMatchResult> getESFMatchByEsfMatchResultUserId(
		long esfUserId) {
		return _esfNationalMatchResultLocalService.getESFMatchByEsfMatchResultUserId(esfUserId);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFNationalMatchResult> getESFMatchByEsfMatchId_ESFQualificationId_ESFSportTypeId(
		long matchId, long qualificationId, long sportTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfNationalMatchResultLocalService.getESFMatchByEsfMatchId_ESFQualificationId_ESFSportTypeId(matchId,
			qualificationId, sportTypeId);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFNationalMatchResult> getESFMatchByEsfMatchId_ESFSportTypeId(
		long matchId, long sportTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfNationalMatchResultLocalService.getESFMatchByEsfMatchId_ESFSportTypeId(matchId,
			sportTypeId);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFNationalMatchResult> getExternalShooter(
		long esfMatchId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfNationalMatchResultLocalService.getExternalShooter(esfMatchId);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFNationalMatchResult> getExternalShooterSportType(
		long esfMatchId, long sportTypeid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfNationalMatchResultLocalService.getExternalShooterSportType(esfMatchId,
			sportTypeid);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFNationalMatchResult> getNMRByMatchId_UserId(
		long esfMatchId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfNationalMatchResultLocalService.getNMRByMatchId_UserId(esfMatchId,
			userId);
	}

	@Override
	public it.ethica.esf.model.ESFNationalMatchResult getESFNationalMatchByEsFMatchId(
		long esfMatchId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalMatchResultException {
		return _esfNationalMatchResultLocalService.getESFNationalMatchByEsFMatchId(esfMatchId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ESFNationalMatchResultLocalService getWrappedESFNationalMatchResultLocalService() {
		return _esfNationalMatchResultLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedESFNationalMatchResultLocalService(
		ESFNationalMatchResultLocalService esfNationalMatchResultLocalService) {
		_esfNationalMatchResultLocalService = esfNationalMatchResultLocalService;
	}

	@Override
	public ESFNationalMatchResultLocalService getWrappedService() {
		return _esfNationalMatchResultLocalService;
	}

	@Override
	public void setWrappedService(
		ESFNationalMatchResultLocalService esfNationalMatchResultLocalService) {
		_esfNationalMatchResultLocalService = esfNationalMatchResultLocalService;
	}

	private ESFNationalMatchResultLocalService _esfNationalMatchResultLocalService;
}