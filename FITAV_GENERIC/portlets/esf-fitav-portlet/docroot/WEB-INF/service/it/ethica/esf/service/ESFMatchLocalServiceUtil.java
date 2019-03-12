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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for ESFMatch. This utility wraps
 * {@link it.ethica.esf.service.impl.ESFMatchLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Ethica
 * @see ESFMatchLocalService
 * @see it.ethica.esf.service.base.ESFMatchLocalServiceBaseImpl
 * @see it.ethica.esf.service.impl.ESFMatchLocalServiceImpl
 * @generated
 */
public class ESFMatchLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link it.ethica.esf.service.impl.ESFMatchLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the e s f match to the database. Also notifies the appropriate model listeners.
	*
	* @param esfMatch the e s f match
	* @return the e s f match that was added
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFMatch addESFMatch(
		it.ethica.esf.model.ESFMatch esfMatch)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addESFMatch(esfMatch);
	}

	/**
	* Creates a new e s f match with the primary key. Does not add the e s f match to the database.
	*
	* @param esfMatchId the primary key for the new e s f match
	* @return the new e s f match
	*/
	public static it.ethica.esf.model.ESFMatch createESFMatch(long esfMatchId) {
		return getService().createESFMatch(esfMatchId);
	}

	/**
	* Deletes the e s f match with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfMatchId the primary key of the e s f match
	* @return the e s f match that was removed
	* @throws PortalException if a e s f match with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFMatch deleteESFMatch(long esfMatchId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteESFMatch(esfMatchId);
	}

	/**
	* Deletes the e s f match from the database. Also notifies the appropriate model listeners.
	*
	* @param esfMatch the e s f match
	* @return the e s f match that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFMatch deleteESFMatch(
		it.ethica.esf.model.ESFMatch esfMatch)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteESFMatch(esfMatch);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static it.ethica.esf.model.ESFMatch fetchESFMatch(long esfMatchId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchESFMatch(esfMatchId);
	}

	/**
	* Returns the e s f match with the matching UUID and company.
	*
	* @param uuid the e s f match's UUID
	* @param companyId the primary key of the company
	* @return the matching e s f match, or <code>null</code> if a matching e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFMatch fetchESFMatchByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchESFMatchByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the e s f match matching the UUID and group.
	*
	* @param uuid the e s f match's UUID
	* @param groupId the primary key of the group
	* @return the matching e s f match, or <code>null</code> if a matching e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFMatch fetchESFMatchByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchESFMatchByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the e s f match with the primary key.
	*
	* @param esfMatchId the primary key of the e s f match
	* @return the e s f match
	* @throws PortalException if a e s f match with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFMatch getESFMatch(long esfMatchId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFMatch(esfMatchId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static it.ethica.esf.model.ESFMatch getESFMatchByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFMatchByUuidAndCompanyId(uuid, companyId);
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
	public static it.ethica.esf.model.ESFMatch getESFMatchByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFMatchByUuidAndGroupId(uuid, groupId);
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
	public static java.util.List<it.ethica.esf.model.ESFMatch> getESFMatchs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFMatchs(start, end);
	}

	/**
	* Returns the number of e s f matchs.
	*
	* @return the number of e s f matchs
	* @throws SystemException if a system exception occurred
	*/
	public static int getESFMatchsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFMatchsCount();
	}

	/**
	* Updates the e s f match in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param esfMatch the e s f match
	* @return the e s f match that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFMatch updateESFMatch(
		it.ethica.esf.model.ESFMatch esfMatch)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateESFMatch(esfMatch);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static java.util.List<it.ethica.esf.model.ESFMatch> findESFMatchesByYearIsNational(
		int year, boolean isNational) {
		return getService().findESFMatchesByYearIsNational(year, isNational);
	}

	public static java.util.List<it.ethica.esf.model.ESFMatch> findESFMatchsByStateIsNational_C_S_M_C_O(
		int state, boolean isNational, java.lang.String code,
		java.util.Date startDate, long esfMatchType, long country,
		java.lang.String eventType) {
		return getService()
				   .findESFMatchsByStateIsNational_C_S_M_C_O(state, isNational,
			code, startDate, esfMatchType, country, eventType);
	}

	public static java.util.List<it.ethica.esf.model.ESFMatch> findESFMatchsByStateIsNational_C_S_M_C_O(
		int state, boolean isNational, java.lang.String code,
		java.util.Date startDate, long esfMatchType, long country,
		java.lang.String eventType, int start, int end) {
		return getService()
				   .findESFMatchsByStateIsNational_C_S_M_C_O(state, isNational,
			code, startDate, esfMatchType, country, eventType, start, end);
	}

	public static java.util.List<it.ethica.esf.model.ESFMatch> findESFMatchsByStateIsNational_C_S_M_C_A(
		int state, boolean isNational, java.lang.String code,
		java.util.Date startDate, long esfMatchType, long assotiationName) {
		return getService()
				   .findESFMatchsByStateIsNational_C_S_M_C_A(state, isNational,
			code, startDate, esfMatchType, assotiationName);
	}

	public static java.util.List<it.ethica.esf.model.ESFMatch> findESFMatchsByStateIsNational_C_S_M_C_A(
		int state, boolean isNational, java.lang.String code,
		java.util.Date startDate, long esfMatchType, long assotiationName,
		int start, int end) {
		return getService()
				   .findESFMatchsByStateIsNational_C_S_M_C_A(state, isNational,
			code, startDate, esfMatchType, assotiationName, start, end);
	}

	public static java.util.List<it.ethica.esf.model.ESFMatch> findESFMatchsByStateIsNational_C_S_M_C_I(
		int state, boolean isNational, java.lang.String code,
		java.util.Date startDate, long esfMatchType, long assotiationId) {
		return getService()
				   .findESFMatchsByStateIsNational_C_S_M_C_I(state, isNational,
			code, startDate, esfMatchType, assotiationId);
	}

	public static java.util.List<it.ethica.esf.model.ESFMatch> findESFMatchsByStateIsNational_C_S_M_C_I(
		int state, boolean isNational, java.lang.String code,
		java.util.Date startDate, long esfMatchType, long assotiationId,
		int start, int end) {
		return getService()
				   .findESFMatchsByStateIsNational_C_S_M_C_I(state, isNational,
			code, startDate, esfMatchType, assotiationId, start, end);
	}

	/**
	* Cerca tutti I match sulla base dello stato [attivo o disattivo]
	*/
	public static java.util.List<it.ethica.esf.model.ESFMatch> findESFMatchsByStateIsNational(
		int state, boolean isNational) {
		return getService().findESFMatchsByStateIsNational(state, isNational);
	}

	/**
	* Cerca tutti I match sulla base dello stato [attivo o disattivo]
	*/
	public static java.util.List<it.ethica.esf.model.ESFMatch> findESFMatchsByStateIsNational(
		int state, boolean isNational, int start, int end) {
		return getService()
				   .findESFMatchsByStateIsNational(state, isNational, start, end);
	}

	/**
	* Cerca tutti I match sulla base dell'ornanizationId e dello stato [attivo
	* o disattivo]
	*/
	public static java.util.List<it.ethica.esf.model.ESFMatch> findESFMatchsByO_S_N(
		long esfOrganizationId, int state, boolean isNational, int start,
		int end) {
		return getService()
				   .findESFMatchsByO_S_N(esfOrganizationId, state, isNational,
			start, end);
	}

	public static java.util.List<it.ethica.esf.model.ESFMatch> findbyIsChangeCategoryYear(
		boolean IsChangeCategory, long sportType, int year)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findbyIsChangeCategoryYear(IsChangeCategory, sportType, year);
	}

	public static java.util.List<it.ethica.esf.model.ESFMatch> findbyIsChangeCategoryYearDescription(
		boolean IsChangeCategory, long sportType, int year,
		java.lang.Long description)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findbyIsChangeCategoryYearDescription(IsChangeCategory,
			sportType, year, description);
	}

	public static java.util.List<it.ethica.esf.model.ESFMatch> getESFMatchesByMatchStartDate_T_A_D_N(
		java.util.Date startDate, long matchType, long associationId,
		long descriptionId, boolean isNational) {
		return getService()
				   .getESFMatchesByMatchStartDate_T_A_D_N(startDate, matchType,
			associationId, descriptionId, isNational);
	}

	public static java.util.List<it.ethica.esf.model.ESFMatch> findMyMatches(
		long userId, boolean isNational, long organizationId,
		java.util.Date startDate, long descriptionId, long SportTypeId)
		throws java.lang.Exception {
		return getService()
				   .findMyMatches(userId, isNational, organizationId,
			startDate, descriptionId, SportTypeId);
	}

	public static java.util.List<it.ethica.esf.model.ESFMatch> findByUI_iN_OI_sD_dId_STId(
		long userId, boolean isNational, long organizationId,
		java.util.Date startDate, long descriptionId, long SportTypeId,
		int start, int end) throws java.lang.Exception {
		return getService()
				   .findByUI_iN_OI_sD_dId_STId(userId, isNational,
			organizationId, startDate, descriptionId, SportTypeId, start, end);
	}

	/**
	* Cerca tutti I match sulla base dell'ornanizationId e dello stato [attivo
	* o disattivo]
	*/
	public static java.util.List<it.ethica.esf.model.ESFMatch> findESFMatchsByO_S_N(
		long esfOrganizationId, int state, boolean isNational) {
		return getService()
				   .findESFMatchsByO_S_N(esfOrganizationId, state, isNational);
	}

	public static java.util.List<it.ethica.esf.model.ESFMatch> findbyUserId_IsNational(
		long userId, boolean isNational)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findbyUserId_IsNational(userId, isNational);
	}

	public static java.util.List<it.ethica.esf.model.ESFMatch> findbyIsChangeCategory(
		boolean IsChangeCategory, long sportType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findbyIsChangeCategory(IsChangeCategory, sportType);
	}

	public static java.util.List<it.ethica.esf.model.ESFMatch> findbyUserId_IsNational(
		long userId, boolean isNational, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findbyUserId_IsNational(userId, isNational, start, end);
	}

	public static java.util.List<it.ethica.esf.model.ESFMatch> findbyMatchType(
		long esfMatchTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findbyMatchType(esfMatchTypeId);
	}

	public static it.ethica.esf.model.ESFMatch addOrUpdateESFMatch(
		long userId, long esfMatchId, long esfAssociationId,
		java.lang.String code, java.util.Date startDate,
		java.util.Date endDate, java.lang.String startHour, long description,
		java.lang.String note, boolean isDraft, int numFields,
		long esfSportTypeId, int numDisk, int numDiskTeam,
		boolean isIndividualMatch, boolean isTeamMatch, boolean isJuniorMatch,
		long esfMatchTypeId, boolean isChangeCategoryMatch,
		long[] esfShooterCategoryIds, long[] esfShooterQualificationIds,
		long esfCountryId, java.lang.String site, boolean isNational,
		it.ethica.esf.model.ESFEntityState esfEntityState,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addOrUpdateESFMatch(userId, esfMatchId, esfAssociationId,
			code, startDate, endDate, startHour, description, note, isDraft,
			numFields, esfSportTypeId, numDisk, numDiskTeam, isIndividualMatch,
			isTeamMatch, isJuniorMatch, esfMatchTypeId, isChangeCategoryMatch,
			esfShooterCategoryIds, esfShooterQualificationIds, esfCountryId,
			site, isNational, esfEntityState, serviceContext);
	}

	public static it.ethica.esf.model.ESFMatch addOrUpdateESFMatch(
		long userId, long esfMatchId, long esfAssociationId,
		java.lang.String code, java.util.Date startDate,
		java.util.Date endDate, java.lang.String startHour, long description,
		java.lang.String note, boolean isDraft, int numFields,
		long esfSportTypeId, int numDisk, int numDiskTeam,
		boolean isIndividualMatch, boolean isTeamMatch, boolean isJuniorMatch,
		long esfMatchTypeId, boolean isChangeCategoryMatch,
		long[] esfShooterCategoryIds, long[] esfShooterQualificationIds,
		long esfCountryId, java.lang.String site, boolean isNational,
		boolean isOlimpicQualificationMatch,
		it.ethica.esf.model.ESFEntityState esfEntityState,
		com.liferay.portal.service.ServiceContext serviceContext,
		java.lang.String notNationalAssotiation, java.lang.String eventType,
		java.lang.String esfNationalSportTypeidString)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addOrUpdateESFMatch(userId, esfMatchId, esfAssociationId,
			code, startDate, endDate, startHour, description, note, isDraft,
			numFields, esfSportTypeId, numDisk, numDiskTeam, isIndividualMatch,
			isTeamMatch, isJuniorMatch, esfMatchTypeId, isChangeCategoryMatch,
			esfShooterCategoryIds, esfShooterQualificationIds, esfCountryId,
			site, isNational, isOlimpicQualificationMatch, esfEntityState,
			serviceContext, notNationalAssotiation, eventType,
			esfNationalSportTypeidString);
	}

	public static it.ethica.esf.model.ESFMatch addOrUpdateESFMatch(
		long userId, long esfMatchId, long esfAssociationId,
		java.lang.String code, java.util.Date startDate,
		java.util.Date endDate, java.lang.String startHour, long description,
		java.lang.String note, boolean isDraft, int numFields,
		long esfSportTypeId, int numDisk, int numDiskTeam,
		boolean isIndividualMatch, boolean isTeamMatch, boolean isJuniorMatch,
		long esfMatchTypeId, boolean isChangeCategoryMatch,
		long[] esfShooterCategoryIds, long[] esfShooterQualificationIds,
		long esfCountryId, java.lang.String site, boolean isNational,
		boolean isOlimpicQualificationMatch,
		it.ethica.esf.model.ESFEntityState esfEntityState,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addOrUpdateESFMatch(userId, esfMatchId, esfAssociationId,
			code, startDate, endDate, startHour, description, note, isDraft,
			numFields, esfSportTypeId, numDisk, numDiskTeam, isIndividualMatch,
			isTeamMatch, isJuniorMatch, esfMatchTypeId, isChangeCategoryMatch,
			esfShooterCategoryIds, esfShooterQualificationIds, esfCountryId,
			site, isNational, isOlimpicQualificationMatch, esfEntityState,
			serviceContext);
	}

	public static it.ethica.esf.model.ESFMatch deleteESFMatch(long esfMatchId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteESFMatch(esfMatchId, serviceContext);
	}

	public static java.util.List<it.ethica.esf.model.ESFMatch> findbyeventType(
		java.lang.String eventType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findbyeventType(eventType);
	}

	public static java.util.List<it.ethica.esf.model.ESFMatch> findByDescription(
		long description)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByDescription(description);
	}

	public static java.util.List<it.ethica.esf.model.ESFMatch> findDelegationActiveMatch(
		long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findDelegationActiveMatch(esfUserId);
	}

	public static java.util.List<it.ethica.esf.model.ESFMatch> findUnfinishedMatch_UserId(
		long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findUnfinishedMatch_UserId(esfUserId);
	}

	public static java.util.List<it.ethica.esf.model.ESFMatch> getAllEsfMatchByResults(
		java.util.List<it.ethica.esf.model.ESFNationalMatchResult> results)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAllEsfMatchByResults(results);
	}

	public static it.ethica.esf.model.ESFMatch addOrUpdateOldESFMatch(
		long userId, long esfMatchId, long esfAssociationId,
		java.lang.String code, java.util.Date startDate,
		java.util.Date endDate, java.lang.String startHour, long description,
		java.lang.String note, boolean isDraft, int numFields,
		long esfSportTypeId, int numDisk, int numDiskTeam,
		boolean isIndividualMatch, boolean isTeamMatch, boolean isJuniorMatch,
		long esfMatchTypeId, boolean isChangeCategoryMatch,
		long[] esfShooterCategoryIds, long[] esfShooterQualificationIds,
		long esfCountryId, java.lang.String site, boolean isNational,
		it.ethica.esf.model.ESFEntityState esfEntityState,
		com.liferay.portal.service.ServiceContext serviceContext,
		java.lang.String oldCode)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addOrUpdateOldESFMatch(userId, esfMatchId,
			esfAssociationId, code, startDate, endDate, startHour, description,
			note, isDraft, numFields, esfSportTypeId, numDisk, numDiskTeam,
			isIndividualMatch, isTeamMatch, isJuniorMatch, esfMatchTypeId,
			isChangeCategoryMatch, esfShooterCategoryIds,
			esfShooterQualificationIds, esfCountryId, site, isNational,
			esfEntityState, serviceContext, oldCode);
	}

	public static java.util.List<it.ethica.esf.model.ESFMatch> findMatchToDispute(
		java.lang.String code, boolean isnational, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findMatchToDispute(code, isnational, start, end);
	}

	public static int countMatchToDispute(java.lang.String code,
		boolean isnational)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countMatchToDispute(code, isnational);
	}

	public static void clearService() {
		_service = null;
	}

	public static ESFMatchLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ESFMatchLocalService.class.getName());

			if (invokableLocalService instanceof ESFMatchLocalService) {
				_service = (ESFMatchLocalService)invokableLocalService;
			}
			else {
				_service = new ESFMatchLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(ESFMatchLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(ESFMatchLocalService service) {
	}

	private static ESFMatchLocalService _service;
}