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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.BaseLocalService;
import com.liferay.portal.service.InvokableLocalService;
import com.liferay.portal.service.PersistedModelLocalService;

/**
 * Provides the local service interface for ESFTournament. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Ethica
 * @see ESFTournamentLocalServiceUtil
 * @see it.ethica.esf.service.base.ESFTournamentLocalServiceBaseImpl
 * @see it.ethica.esf.service.impl.ESFTournamentLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface ESFTournamentLocalService extends BaseLocalService,
	InvokableLocalService, PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ESFTournamentLocalServiceUtil} to access the e s f tournament local service. Add custom service methods to {@link it.ethica.esf.service.impl.ESFTournamentLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the e s f tournament to the database. Also notifies the appropriate model listeners.
	*
	* @param esfTournament the e s f tournament
	* @return the e s f tournament that was added
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.REINDEX)
	public it.ethica.esf.model.ESFTournament addESFTournament(
		it.ethica.esf.model.ESFTournament esfTournament)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Creates a new e s f tournament with the primary key. Does not add the e s f tournament to the database.
	*
	* @param esfTournamentId the primary key for the new e s f tournament
	* @return the new e s f tournament
	*/
	public it.ethica.esf.model.ESFTournament createESFTournament(
		long esfTournamentId);

	/**
	* Deletes the e s f tournament with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfTournamentId the primary key of the e s f tournament
	* @return the e s f tournament that was removed
	* @throws PortalException if a e s f tournament with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.DELETE)
	public it.ethica.esf.model.ESFTournament deleteESFTournament(
		long esfTournamentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Deletes the e s f tournament from the database. Also notifies the appropriate model listeners.
	*
	* @param esfTournament the e s f tournament
	* @return the e s f tournament that was removed
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.DELETE)
	public it.ethica.esf.model.ESFTournament deleteESFTournament(
		it.ethica.esf.model.ESFTournament esfTournament)
		throws com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery();

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFTournamentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFTournamentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public it.ethica.esf.model.ESFTournament fetchESFTournament(
		long esfTournamentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f tournament with the matching UUID and company.
	*
	* @param uuid the e s f tournament's UUID
	* @param companyId the primary key of the company
	* @return the matching e s f tournament, or <code>null</code> if a matching e s f tournament could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public it.ethica.esf.model.ESFTournament fetchESFTournamentByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f tournament matching the UUID and group.
	*
	* @param uuid the e s f tournament's UUID
	* @param groupId the primary key of the group
	* @return the matching e s f tournament, or <code>null</code> if a matching e s f tournament could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public it.ethica.esf.model.ESFTournament fetchESFTournamentByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f tournament with the primary key.
	*
	* @param esfTournamentId the primary key of the e s f tournament
	* @return the e s f tournament
	* @throws PortalException if a e s f tournament with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public it.ethica.esf.model.ESFTournament getESFTournament(
		long esfTournamentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f tournament with the matching UUID and company.
	*
	* @param uuid the e s f tournament's UUID
	* @param companyId the primary key of the company
	* @return the matching e s f tournament
	* @throws PortalException if a matching e s f tournament could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public it.ethica.esf.model.ESFTournament getESFTournamentByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f tournament matching the UUID and group.
	*
	* @param uuid the e s f tournament's UUID
	* @param groupId the primary key of the group
	* @return the matching e s f tournament
	* @throws PortalException if a matching e s f tournament could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public it.ethica.esf.model.ESFTournament getESFTournamentByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f tournaments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFTournamentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f tournaments
	* @param end the upper bound of the range of e s f tournaments (not inclusive)
	* @return the range of e s f tournaments
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<it.ethica.esf.model.ESFTournament> getESFTournaments(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f tournaments.
	*
	* @return the number of e s f tournaments
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getESFTournamentsCount()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the e s f tournament in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param esfTournament the e s f tournament
	* @return the e s f tournament that was updated
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.REINDEX)
	public it.ethica.esf.model.ESFTournament updateESFTournament(
		it.ethica.esf.model.ESFTournament esfTournament)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier();

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier);

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable;

	/**
	* Cerca tutti I tornei sulla base dello stato [attivo o disattivo]
	*/
	public java.util.List<it.ethica.esf.model.ESFTournament> findESFTournamentsByState(
		int state);

	/**
	* Cerca tutti I tornei sulla base dello stato [attivo o disattivo]
	*/
	public java.util.List<it.ethica.esf.model.ESFTournament> findESFTournamentsByState(
		int state, int start, int end);

	/**
	* Cerca tutti i Tornei che hanno uno stato [attivo o disattivo] e che sono
	* associate o alle organizzazioni sportive foglie dell' organizazione con
	* Id = organizationId (caso isLeaf = false) o all' organizzazione sportiva
	* con Id = organizationId (caso isLeaf = true)
	*/
	public java.util.List<it.ethica.esf.model.ESFTournament> findESFTournamentsByOrganizationId(
		long organizationId, boolean isLeaf, int state, boolean isNationalMatch);

	/**
	* Cerca tutti i Tornei che hanno uno stato [attivo o disattivo] e che sono
	* associate o alle organizzazioni sportive foglie dell' organizazione con
	* Id = organizationId (caso isLeaf = false) o all' organizzazione sportiva
	* con Id = organizationId (caso isLeaf = true)
	*/
	public java.util.List<it.ethica.esf.model.ESFTournament> findESFTournamentsByOrganizationId(
		long organizationId, boolean isLeaf, int state,
		boolean isNationalMatch, int start, int end);

	public it.ethica.esf.model.ESFTournament addESFTournament(long userId,
		long esfOrganizationId, java.lang.String title,
		java.lang.String description, int maxnum, int minnum,
		boolean isSingleMatch, boolean isTeamMatch, boolean isNationalMatch,
		boolean isIndividualMatch, boolean isJuniorMatch, boolean isFinal,
		long[] esfShooterCategoryIds, long[] esfShooterQualificationIds,
		java.util.Date startDate, java.util.Date endDate,
		java.util.List<it.ethica.esf.model.ESFTeam> esfTeams,
		it.ethica.esf.model.ESFEntityState esfEntityState,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public it.ethica.esf.model.ESFTournament deleteESFTournament(
		long esfTournamentId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public it.ethica.esf.model.ESFTournament updateESFTournament(long userId,
		long esfTournamentId, long esfOrganizationId, java.lang.String title,
		java.lang.String description, int maxnum, int minnum,
		boolean isSingleMatch, boolean isTeamMatch, boolean isNationalMatch,
		boolean isIndividualMatch, boolean isJuniorMatch, boolean isFinal,
		long[] categories, long[] qualifications, java.util.Date startDate,
		java.util.Date endDate,
		java.util.List<it.ethica.esf.model.ESFTeam> esfTeams,
		it.ethica.esf.model.ESFEntityState esfEntityState,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;
}