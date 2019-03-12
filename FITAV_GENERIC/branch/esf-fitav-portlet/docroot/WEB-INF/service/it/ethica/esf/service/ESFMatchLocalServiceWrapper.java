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
 * Provides a wrapper for {@link ESFMatchLocalService}.
 *
 * @author Ethica
 * @see ESFMatchLocalService
 * @generated
 */
public class ESFMatchLocalServiceWrapper implements ESFMatchLocalService,
	ServiceWrapper<ESFMatchLocalService> {
	public ESFMatchLocalServiceWrapper(
		ESFMatchLocalService esfMatchLocalService) {
		_esfMatchLocalService = esfMatchLocalService;
	}

	/**
	* Adds the e s f match to the database. Also notifies the appropriate model listeners.
	*
	* @param esfMatch the e s f match
	* @return the e s f match that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFMatch addESFMatch(
		it.ethica.esf.model.ESFMatch esfMatch)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfMatchLocalService.addESFMatch(esfMatch);
	}

	/**
	* Creates a new e s f match with the primary key. Does not add the e s f match to the database.
	*
	* @param esfMatchId the primary key for the new e s f match
	* @return the new e s f match
	*/
	@Override
	public it.ethica.esf.model.ESFMatch createESFMatch(long esfMatchId) {
		return _esfMatchLocalService.createESFMatch(esfMatchId);
	}

	/**
	* Deletes the e s f match with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfMatchId the primary key of the e s f match
	* @return the e s f match that was removed
	* @throws PortalException if a e s f match with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFMatch deleteESFMatch(long esfMatchId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfMatchLocalService.deleteESFMatch(esfMatchId);
	}

	/**
	* Deletes the e s f match from the database. Also notifies the appropriate model listeners.
	*
	* @param esfMatch the e s f match
	* @return the e s f match that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFMatch deleteESFMatch(
		it.ethica.esf.model.ESFMatch esfMatch)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfMatchLocalService.deleteESFMatch(esfMatch);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _esfMatchLocalService.dynamicQuery();
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
		return _esfMatchLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFMatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _esfMatchLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFMatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _esfMatchLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _esfMatchLocalService.dynamicQueryCount(dynamicQuery);
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
		return _esfMatchLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public it.ethica.esf.model.ESFMatch fetchESFMatch(long esfMatchId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfMatchLocalService.fetchESFMatch(esfMatchId);
	}

	/**
	* Returns the e s f match with the matching UUID and company.
	*
	* @param uuid the e s f match's UUID
	* @param companyId the primary key of the company
	* @return the matching e s f match, or <code>null</code> if a matching e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFMatch fetchESFMatchByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfMatchLocalService.fetchESFMatchByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the e s f match matching the UUID and group.
	*
	* @param uuid the e s f match's UUID
	* @param groupId the primary key of the group
	* @return the matching e s f match, or <code>null</code> if a matching e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFMatch fetchESFMatchByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfMatchLocalService.fetchESFMatchByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the e s f match with the primary key.
	*
	* @param esfMatchId the primary key of the e s f match
	* @return the e s f match
	* @throws PortalException if a e s f match with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFMatch getESFMatch(long esfMatchId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfMatchLocalService.getESFMatch(esfMatchId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfMatchLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the e s f match with the matching UUID and company.
	*
	* @param uuid the e s f match's UUID
	* @param companyId the primary key of the company
	* @return the matching e s f match
	* @throws PortalException if a matching e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFMatch getESFMatchByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfMatchLocalService.getESFMatchByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the e s f match matching the UUID and group.
	*
	* @param uuid the e s f match's UUID
	* @param groupId the primary key of the group
	* @return the matching e s f match
	* @throws PortalException if a matching e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFMatch getESFMatchByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfMatchLocalService.getESFMatchByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns a range of all the e s f matchs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFMatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f matchs
	* @param end the upper bound of the range of e s f matchs (not inclusive)
	* @return the range of e s f matchs
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<it.ethica.esf.model.ESFMatch> getESFMatchs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfMatchLocalService.getESFMatchs(start, end);
	}

	/**
	* Returns the number of e s f matchs.
	*
	* @return the number of e s f matchs
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getESFMatchsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfMatchLocalService.getESFMatchsCount();
	}

	/**
	* Updates the e s f match in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param esfMatch the e s f match
	* @return the e s f match that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFMatch updateESFMatch(
		it.ethica.esf.model.ESFMatch esfMatch)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfMatchLocalService.updateESFMatch(esfMatch);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _esfMatchLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_esfMatchLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _esfMatchLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFMatch> findESFMatchesByYearIsNational(
		int year, boolean isNational) {
		return _esfMatchLocalService.findESFMatchesByYearIsNational(year,
			isNational);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFMatch> findESFMatchsByStateIsNational_C_S_M_C_O(
		int state, boolean isNational, java.lang.String code,
		java.util.Date startDate, long esfMatchType, long country,
		java.lang.String eventType) {
		return _esfMatchLocalService.findESFMatchsByStateIsNational_C_S_M_C_O(state,
			isNational, code, startDate, esfMatchType, country, eventType);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFMatch> findESFMatchsByStateIsNational_C_S_M_C_O(
		int state, boolean isNational, java.lang.String code,
		java.util.Date startDate, long esfMatchType, long country,
		java.lang.String eventType, int start, int end) {
		return _esfMatchLocalService.findESFMatchsByStateIsNational_C_S_M_C_O(state,
			isNational, code, startDate, esfMatchType, country, eventType,
			start, end);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFMatch> findESFMatchsByStateIsNational_C_S_M_C_A(
		int state, boolean isNational, java.lang.String code,
		java.util.Date startDate, long esfMatchType, long assotiationName) {
		return _esfMatchLocalService.findESFMatchsByStateIsNational_C_S_M_C_A(state,
			isNational, code, startDate, esfMatchType, assotiationName);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFMatch> findESFMatchsByStateIsNational_C_S_M_C_A(
		int state, boolean isNational, java.lang.String code,
		java.util.Date startDate, long esfMatchType, long assotiationName,
		int start, int end) {
		return _esfMatchLocalService.findESFMatchsByStateIsNational_C_S_M_C_A(state,
			isNational, code, startDate, esfMatchType, assotiationName, start,
			end);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFMatch> findESFMatchsByStateIsNational_C_S_M_C_I(
		int state, boolean isNational, java.lang.String code,
		java.util.Date startDate, long esfMatchType, long assotiationId) {
		return _esfMatchLocalService.findESFMatchsByStateIsNational_C_S_M_C_I(state,
			isNational, code, startDate, esfMatchType, assotiationId);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFMatch> findESFMatchsByStateIsNational_C_S_M_C_I(
		int state, boolean isNational, java.lang.String code,
		java.util.Date startDate, long esfMatchType, long assotiationId,
		int start, int end) {
		return _esfMatchLocalService.findESFMatchsByStateIsNational_C_S_M_C_I(state,
			isNational, code, startDate, esfMatchType, assotiationId, start, end);
	}

	/**
	* Cerca tutti I match sulla base dello stato [attivo o disattivo]
	*/
	@Override
	public java.util.List<it.ethica.esf.model.ESFMatch> findESFMatchsByStateIsNational(
		int state, boolean isNational) {
		return _esfMatchLocalService.findESFMatchsByStateIsNational(state,
			isNational);
	}

	/**
	* Cerca tutti I match sulla base dello stato [attivo o disattivo]
	*/
	@Override
	public java.util.List<it.ethica.esf.model.ESFMatch> findESFMatchsByStateIsNational(
		int state, boolean isNational, int start, int end) {
		return _esfMatchLocalService.findESFMatchsByStateIsNational(state,
			isNational, start, end);
	}

	/**
	* Cerca tutti I match sulla base dell'ornanizationId e dello stato [attivo
	* o disattivo]
	*/
	@Override
	public java.util.List<it.ethica.esf.model.ESFMatch> findESFMatchsByO_S_N(
		long esfOrganizationId, int state, boolean isNational, int start,
		int end) {
		return _esfMatchLocalService.findESFMatchsByO_S_N(esfOrganizationId,
			state, isNational, start, end);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFMatch> findbyIsChangeCategoryYear(
		boolean IsChangeCategory, long sportType, int year)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfMatchLocalService.findbyIsChangeCategoryYear(IsChangeCategory,
			sportType, year);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFMatch> findbyIsChangeCategoryYearDescription(
		boolean IsChangeCategory, long sportType, int year,
		java.lang.Long description)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfMatchLocalService.findbyIsChangeCategoryYearDescription(IsChangeCategory,
			sportType, year, description);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFMatch> getESFMatchesByMatchStartDate_T_A_D_N(
		java.util.Date startDate, long matchType, long associationId,
		long descriptionId, boolean isNational) {
		return _esfMatchLocalService.getESFMatchesByMatchStartDate_T_A_D_N(startDate,
			matchType, associationId, descriptionId, isNational);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFMatch> findMyMatches(
		long userId, boolean isNational, long organizationId,
		java.util.Date startDate, long descriptionId, long SportTypeId)
		throws java.lang.Exception {
		return _esfMatchLocalService.findMyMatches(userId, isNational,
			organizationId, startDate, descriptionId, SportTypeId);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFMatch> findByUI_iN_OI_sD_dId_STId(
		long userId, boolean isNational, long organizationId,
		java.util.Date startDate, long descriptionId, long SportTypeId,
		int start, int end) throws java.lang.Exception {
		return _esfMatchLocalService.findByUI_iN_OI_sD_dId_STId(userId,
			isNational, organizationId, startDate, descriptionId, SportTypeId,
			start, end);
	}

	/**
	* Cerca tutti I match sulla base dell'ornanizationId e dello stato [attivo
	* o disattivo]
	*/
	@Override
	public java.util.List<it.ethica.esf.model.ESFMatch> findESFMatchsByO_S_N(
		long esfOrganizationId, int state, boolean isNational) {
		return _esfMatchLocalService.findESFMatchsByO_S_N(esfOrganizationId,
			state, isNational);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFMatch> findbyUserId_IsNational(
		long userId, boolean isNational)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfMatchLocalService.findbyUserId_IsNational(userId, isNational);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFMatch> findbyIsChangeCategory(
		boolean IsChangeCategory, long sportType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfMatchLocalService.findbyIsChangeCategory(IsChangeCategory,
			sportType);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFMatch> findbyUserId_IsNational(
		long userId, boolean isNational, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfMatchLocalService.findbyUserId_IsNational(userId,
			isNational, start, end);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFMatch> findbyMatchType(
		long esfMatchTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfMatchLocalService.findbyMatchType(esfMatchTypeId);
	}

	@Override
	public it.ethica.esf.model.ESFMatch addOrUpdateESFMatch(long userId,
		long esfMatchId, long esfAssociationId, java.lang.String code,
		java.util.Date startDate, java.util.Date endDate,
		java.lang.String startHour, long description, java.lang.String note,
		boolean isDraft, int numFields, long esfSportTypeId, int numDisk,
		int numDiskTeam, boolean isIndividualMatch, boolean isTeamMatch,
		boolean isJuniorMatch, long esfMatchTypeId,
		boolean isChangeCategoryMatch, long[] esfShooterCategoryIds,
		long[] esfShooterQualificationIds, long esfCountryId,
		java.lang.String site, boolean isNational,
		it.ethica.esf.model.ESFEntityState esfEntityState,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfMatchLocalService.addOrUpdateESFMatch(userId, esfMatchId,
			esfAssociationId, code, startDate, endDate, startHour, description,
			note, isDraft, numFields, esfSportTypeId, numDisk, numDiskTeam,
			isIndividualMatch, isTeamMatch, isJuniorMatch, esfMatchTypeId,
			isChangeCategoryMatch, esfShooterCategoryIds,
			esfShooterQualificationIds, esfCountryId, site, isNational,
			esfEntityState, serviceContext);
	}

	@Override
	public it.ethica.esf.model.ESFMatch addOrUpdateESFMatch(long userId,
		long esfMatchId, long esfAssociationId, java.lang.String code,
		java.util.Date startDate, java.util.Date endDate,
		java.lang.String startHour, long description, java.lang.String note,
		boolean isDraft, int numFields, long esfSportTypeId, int numDisk,
		int numDiskTeam, boolean isIndividualMatch, boolean isTeamMatch,
		boolean isJuniorMatch, long esfMatchTypeId,
		boolean isChangeCategoryMatch, long[] esfShooterCategoryIds,
		long[] esfShooterQualificationIds, long esfCountryId,
		java.lang.String site, boolean isNational,
		boolean isOlimpicQualificationMatch,
		it.ethica.esf.model.ESFEntityState esfEntityState,
		com.liferay.portal.service.ServiceContext serviceContext,
		java.lang.String notNationalAssotiation, java.lang.String eventType,
		java.lang.String esfNationalSportTypeidString)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfMatchLocalService.addOrUpdateESFMatch(userId, esfMatchId,
			esfAssociationId, code, startDate, endDate, startHour, description,
			note, isDraft, numFields, esfSportTypeId, numDisk, numDiskTeam,
			isIndividualMatch, isTeamMatch, isJuniorMatch, esfMatchTypeId,
			isChangeCategoryMatch, esfShooterCategoryIds,
			esfShooterQualificationIds, esfCountryId, site, isNational,
			isOlimpicQualificationMatch, esfEntityState, serviceContext,
			notNationalAssotiation, eventType, esfNationalSportTypeidString);
	}

	@Override
	public it.ethica.esf.model.ESFMatch addOrUpdateESFMatch(long userId,
		long esfMatchId, long esfAssociationId, java.lang.String code,
		java.util.Date startDate, java.util.Date endDate,
		java.lang.String startHour, long description, java.lang.String note,
		boolean isDraft, int numFields, long esfSportTypeId, int numDisk,
		int numDiskTeam, boolean isIndividualMatch, boolean isTeamMatch,
		boolean isJuniorMatch, long esfMatchTypeId,
		boolean isChangeCategoryMatch, long[] esfShooterCategoryIds,
		long[] esfShooterQualificationIds, long esfCountryId,
		java.lang.String site, boolean isNational,
		boolean isOlimpicQualificationMatch,
		it.ethica.esf.model.ESFEntityState esfEntityState,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfMatchLocalService.addOrUpdateESFMatch(userId, esfMatchId,
			esfAssociationId, code, startDate, endDate, startHour, description,
			note, isDraft, numFields, esfSportTypeId, numDisk, numDiskTeam,
			isIndividualMatch, isTeamMatch, isJuniorMatch, esfMatchTypeId,
			isChangeCategoryMatch, esfShooterCategoryIds,
			esfShooterQualificationIds, esfCountryId, site, isNational,
			isOlimpicQualificationMatch, esfEntityState, serviceContext);
	}

	@Override
	public it.ethica.esf.model.ESFMatch deleteESFMatch(long esfMatchId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfMatchLocalService.deleteESFMatch(esfMatchId, serviceContext);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFMatch> findbyeventType(
		java.lang.String eventType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfMatchLocalService.findbyeventType(eventType);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFMatch> findByDescription(
		long description)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfMatchLocalService.findByDescription(description);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFMatch> findDelegationActiveMatch(
		long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfMatchLocalService.findDelegationActiveMatch(esfUserId);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFMatch> findUnfinishedMatch_UserId(
		long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfMatchLocalService.findUnfinishedMatch_UserId(esfUserId);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFMatch> getAllEsfMatchByResults(
		java.util.List<it.ethica.esf.model.ESFNationalMatchResult> results)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfMatchLocalService.getAllEsfMatchByResults(results);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ESFMatchLocalService getWrappedESFMatchLocalService() {
		return _esfMatchLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedESFMatchLocalService(
		ESFMatchLocalService esfMatchLocalService) {
		_esfMatchLocalService = esfMatchLocalService;
	}

	@Override
	public ESFMatchLocalService getWrappedService() {
		return _esfMatchLocalService;
	}

	@Override
	public void setWrappedService(ESFMatchLocalService esfMatchLocalService) {
		_esfMatchLocalService = esfMatchLocalService;
	}

	private ESFMatchLocalService _esfMatchLocalService;
}