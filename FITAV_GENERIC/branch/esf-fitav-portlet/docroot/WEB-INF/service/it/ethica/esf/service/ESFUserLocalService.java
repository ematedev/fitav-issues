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
 * Provides the local service interface for ESFUser. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Ethica
 * @see ESFUserLocalServiceUtil
 * @see it.ethica.esf.service.base.ESFUserLocalServiceBaseImpl
 * @see it.ethica.esf.service.impl.ESFUserLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface ESFUserLocalService extends BaseLocalService,
	InvokableLocalService, PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ESFUserLocalServiceUtil} to access the e s f user local service. Add custom service methods to {@link it.ethica.esf.service.impl.ESFUserLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the e s f user to the database. Also notifies the appropriate model listeners.
	*
	* @param esfUser the e s f user
	* @return the e s f user that was added
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.REINDEX)
	public it.ethica.esf.model.ESFUser addESFUser(
		it.ethica.esf.model.ESFUser esfUser)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Creates a new e s f user with the primary key. Does not add the e s f user to the database.
	*
	* @param esfUserId the primary key for the new e s f user
	* @return the new e s f user
	*/
	public it.ethica.esf.model.ESFUser createESFUser(long esfUserId);

	/**
	* Deletes the e s f user with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfUserId the primary key of the e s f user
	* @return the e s f user that was removed
	* @throws PortalException if a e s f user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.DELETE)
	public it.ethica.esf.model.ESFUser deleteESFUser(long esfUserId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Deletes the e s f user from the database. Also notifies the appropriate model listeners.
	*
	* @param esfUser the e s f user
	* @return the e s f user that was removed
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.DELETE)
	public it.ethica.esf.model.ESFUser deleteESFUser(
		it.ethica.esf.model.ESFUser esfUser)
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public it.ethica.esf.model.ESFUser fetchESFUser(long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f user with the primary key.
	*
	* @param esfUserId the primary key of the e s f user
	* @return the e s f user
	* @throws PortalException if a e s f user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public it.ethica.esf.model.ESFUser getESFUser(long esfUserId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f users.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f users
	* @param end the upper bound of the range of e s f users (not inclusive)
	* @return the range of e s f users
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<it.ethica.esf.model.ESFUser> getESFUsers(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f users.
	*
	* @return the number of e s f users
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getESFUsersCount()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the e s f user in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param esfUser the e s f user
	* @return the e s f user that was updated
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.REINDEX)
	public it.ethica.esf.model.ESFUser updateESFUser(
		it.ethica.esf.model.ESFUser esfUser)
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

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<it.ethica.esf.model.ESFUser> getESFUsersByDeparture(
		long esfDepartureId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<it.ethica.esf.model.ESFUser> getESFUsersByCodeCode(
		java.lang.String code);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public it.ethica.esf.model.ESFUser getESFUserByUserCode(long userCode)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<it.ethica.esf.model.ESFUser> getESFUserByFirstName_LastName_FiscalCode_NotPartecipants(
		long esfMatchId, java.lang.String firstName, java.lang.String lastName,
		java.lang.String fiscalCode, int state, long organizationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<it.ethica.esf.model.ESFUser> getESFUserByFirstName_LastName_FiscalCode_NotPartecipants(
		long esfMatchId, java.lang.String firstName, java.lang.String lastName,
		java.lang.String fiscalCode, int state, long organizationId, int start,
		int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<it.ethica.esf.model.ESFUser> getESFUserByFirstName_LastName_FiscalCode(
		java.lang.String firstName, java.lang.String lastName,
		java.lang.String fiscalCode, int state, long organizationId, int start,
		int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public it.ethica.esf.model.ESFUser getESFUserByFiscalCode(
		java.lang.String fiscalCode);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<it.ethica.esf.model.ESFUser> getAllUserByLikeF_L_S(
		java.lang.String firstName, java.lang.String lastName,
		java.lang.String screenName, int state, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<it.ethica.esf.model.ESFUser> getAllUserByLikeF_L_S(
		java.lang.String firstName, java.lang.String lastName,
		java.lang.String screenName, int state);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<it.ethica.esf.model.ESFUser> getAllUserByLikeF_C_S(
		java.lang.String firstName, java.lang.String lastName,
		java.lang.String cardCode, int state, long organizationId, int start,
		int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<it.ethica.esf.model.ESFUser> getAllUserByLikeF_C_S(
		java.lang.String firstName, java.lang.String lastName,
		java.lang.String cardCode, int state, long organizationId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<it.ethica.esf.model.ESFUser> getAllShooterByLikeF_C_S(
		java.lang.String firstName, java.lang.String lastName,
		java.lang.String cardCode, long organizationId, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<it.ethica.esf.model.ESFUser> getAllShooterByLikeF_C_S(
		java.lang.String firstName, java.lang.String lastName,
		java.lang.String cardCode, long organizationId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<it.ethica.esf.model.ESFUser> getAllEsfUserByState(
		int state);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<it.ethica.esf.model.ESFUser> getAllEsfUserByState(
		int state, int start, int end);

	public java.util.List<it.ethica.esf.model.ESFUser> findUserByRoleT_N_S(
		java.lang.String title, java.lang.String name, int state)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserESFUserRoleException;

	public java.util.List<it.ethica.esf.model.ESFUser> findAllShooters(
		int stateCard, int stateUser);

	public java.util.List<it.ethica.esf.model.ESFUser> findAllShooters(
		long organizationId, int stateCard, int stateUser);

	public java.util.List<it.ethica.esf.model.ESFUser> findAllShooters(
		long organizationId, int stateCard, int stateUser, int start, int end);

	public java.util.List<it.ethica.esf.model.ESFUser> findRoledUserOrganization(
		long organizationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<it.ethica.esf.model.ESFUser> findRoledUserOrganization(
		long organizationId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<it.ethica.esf.model.ESFUser> findAllShootersByLeafOrgAssigned(
		long organizationId, int stateCard, long esfUserRoleId, int stateUser,
		int start, int end);

	public java.util.List<it.ethica.esf.model.ESFUser> findAllShootersByLeafOrgAssignedName(
		java.lang.String name, java.lang.String lastName, long organizationId,
		int stateCard, long esfUserRoleId, int stateUser, int start, int end);

	public int countAllShootersByLeafOrgAssignedName(java.lang.String name,
		java.lang.String lastName, long organizationId, int stateCard,
		long esfUserRoleId, int stateUser);

	public java.util.List<it.ethica.esf.model.ESFUser> findAllShootersByLeafOrgAssigned(
		long organizationId, int stateCard, long esfUserRoleId, int stateUser);

	public java.util.List<it.ethica.esf.model.ESFUser> findAllShootersByLeafOrg(
		long organizationId, int stateCard, int stateUser);

	public java.util.List<it.ethica.esf.model.ESFUser> findAllShootersByLeafOrg(
		long organizationId, int stateCard, int stateUser, int start, int end);

	public java.util.List<it.ethica.esf.model.ESFUser> finNationalDelegationESFUsersByMatchId(
		long esfMatchId);

	public java.util.List<it.ethica.esf.model.ESFUser> findAllStaff(
		java.lang.Long esfMatchId, java.lang.String firstName,
		java.lang.String lastName, java.lang.String fiscalCode, int state,
		java.lang.Long organizationId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<it.ethica.esf.model.ESFUser> findAllStaffNamed(
		java.lang.Long esfMatchId, java.lang.String firstName,
		java.lang.String lastName, java.lang.String fiscalCode, int state,
		java.lang.Long organizationId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<it.ethica.esf.model.ESFUser> findStaffNamed(
		long esfMatchId, java.lang.String firstName, java.lang.String lastName,
		java.lang.String fiscalCode)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<it.ethica.esf.model.ESFUser> findStaffNamed(
		long esfMatchId, java.lang.String firstName, java.lang.String lastName,
		java.lang.String fiscalCode, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<it.ethica.esf.model.ESFUser> findStaffNamedNational(
		long esfMatchId, java.lang.String firstName, java.lang.String lastName,
		java.lang.String fiscalCode)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<it.ethica.esf.model.ESFUser> findStaffNamedNational(
		long esfMatchId, java.lang.String firstName, java.lang.String lastName,
		java.lang.String fiscalCode, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<it.ethica.esf.model.ESFUser> findStaff(
		long esfMatchId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<it.ethica.esf.model.ESFUser> findStaff(
		long esfMatchId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<it.ethica.esf.model.ESFUser> finNationalDelegationESFUsersByMatchId(
		long esfMatchId, int start, int end);

	/**
	* Trova lo staff di una specifica gara
	*/
	public java.util.List<it.ethica.esf.model.ESFUser> findNationalDelegationStaffESFUsersByMatchId(
		long esfMatchId);

	/**
	* Trova lo staff di una specifica gara
	*/
	public java.util.List<it.ethica.esf.model.ESFUser> findNationalDelegationStaffESFUsersByMatchId(
		long esfMatchId, int start, int end);

	public java.util.List<it.ethica.esf.model.ESFUser> findNationalDelegationsESFUsersByMatchId(
		long esfMatchId);

	public java.util.List<it.ethica.esf.model.ESFUser> findNationalDelegationsESFUsersByMatchId(
		long esfMatchId, int start, int end);

	public java.util.List<it.ethica.esf.model.ESFUser> findNationalDelegationsESFUsersByMatchId_PartecipantTypeId(
		long esfMatchId, long esfPartecipantTypeId);

	public java.util.List<it.ethica.esf.model.ESFUser> findNationalDelegationsESFUsersByMatchId_PartecipantTypeId(
		long esfMatchId, long esfPartecipantTypeId, int start, int end);

	public java.util.List<it.ethica.esf.model.ESFUser> findNationalShooters();

	public java.util.List<it.ethica.esf.model.ESFUser> findNationalShooters(
		int start, int end);

	/**
	* Ricerca tutti gli Shooters che possono essere gia' stati associati ad una
	* gara con id <b>idMatch</b> (caso <b>isPartecipant</b> = true) o ancora
	* non associati (caso <b>isPartecipant</b> = false)
	*
	* @param idMatch
	id del Match
	* @param isPartecipant
	'true' se voglio ricercare gli utenti associati ad una gara,
	'false' altrimenti
	* @return List<ESFUser>
	* @throws SystemException
	*/
	public java.util.List<it.ethica.esf.model.ESFUser> findNationalPartecipantShooters(
		long idMatch, boolean isPartecipant)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Ricerca tutti gli Shooters che possono essere gia' stati associati ad una
	* gara con id <b>idMatch</b> (caso <b>isPartecipant</b> = true) o ancora
	* non associati (caso <b>isPartecipant</b> = false)
	*
	* @param esfTournamentId
	id del Torneo
	* @param idMatch
	id del Match
	* @param isPartecipant
	'true' se voglio ricercare gli utenti associati ad una gara,
	'false' altrimenti
	* @param start
	* @param end
	* @return List<ESFUser>
	* @throws SystemException
	*/
	public java.util.List<it.ethica.esf.model.ESFUser> findNationalPartecipantShooters(
		long idMatch, boolean isPartecipant, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Ricerca tutti gli Shooters con stato utente <b>stateUser</b> e con stato
	* card <b>stateCard</b> che possono essere gia' stati associati ad una gara
	* con id <b>idMatch</b> (caso <b>isPartecipant</b> = true) o ancora non
	* associati (caso <b>isPartecipant</b> = false)
	*
	* @param stateCard
	stato della Card
	* @param stateUser
	stato dello User
	* @param idMatch
	id del Match
	* @param isPartecipant
	'true' se voglio ricercare gli utenti associati ad una gara,
	'false' altrimenti
	* @return List<ESFUser>
	* @throws SystemException
	*/
	public java.util.List<it.ethica.esf.model.ESFUser> findPartecipantShooters(
		int stateCard, int stateUser, long idMatch, boolean isPartecipant)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Ricerca tutti gli Shooters con stato utente <b>stateUser</b> e con stato
	* card <b>stateCard</b> che possono essere gia' stati associati ad una gara
	* con id <b>idMatch</b> (caso <b>isPartecipant</b> = true) o ancora non
	* associati (caso <b>isPartecipant</b> = false) I parametri di <b>start</b>
	* e <b>end</b> definiscono il range di oggetti da restituire.
	*
	* @param stateCard
	stato della Card
	* @param stateUser
	stato dello User
	* @param idMatch
	id del Match
	* @param isPartecipant
	'true' se voglio ricercare gli utenti associati ad una gara,
	'false' altrimenti
	* @param start
	* @param end
	* @return List<ESFUser>
	* @throws SystemException
	*/
	public java.util.List<it.ethica.esf.model.ESFUser> findPartecipantShooters(
		int stateCard, int stateUser, long idMatch, boolean isPartecipant,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Ricerca tutti gli utenti che sono stati assegnati ad un match nazionale
	* con ruolo Allenatore. L'utetne pu� esseree gia' stati associato ad una
	* gara con id <b>idMatch</b> (caso <b>isPartecipant</b> = true) o ancora
	* non associati (caso <b>isPartecipant</b> = false)
	*
	* @param esfTournamentId
	id del Torneo
	* @param idMatch
	id del Match
	* @param isPartecipant
	'true' se voglio ricercare gli utenti associati ad una gara,
	'false' altrimenti
	* @return List<ESFUser>
	* @throws SystemException
	* @throws NoSuchUserESFUserRoleException
	*/
	public java.util.List<it.ethica.esf.model.ESFUser> findNationalPartecipantCoaches(
		long idMatch, boolean isPartecipant)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserESFUserRoleException;

	/**
	* Ricerca tutti gli utenti che sono stati assegnati ad un match nazionale
	* con ruolo Allenatore. L'utetne pu� esseree gia' stati associato ad una
	* gara con id <b>idMatch</b> (caso <b>isPartecipant</b> = true) o ancora
	* non associati (caso <b>isPartecipant</b> = false)
	*
	* @param esfTournamentId
	id del Torneo
	* @param idMatch
	id del Match
	* @param isPartecipant
	'true' se voglio ricercare gli utenti associati ad una gara,
	'false' altrimenti
	* @param start
	* @param end
	* @return List<ESFUser>
	* @throws SystemException
	* @throws NoSuchUserESFUserRoleException
	*/
	public java.util.List<it.ethica.esf.model.ESFUser> findNationalPartecipantCoaches(
		long idMatch, boolean isPartecipant, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserESFUserRoleException;

	/**
	* Ricerca tutti gli utenti con ruolo Allenatore con stato utente
	* <b>stateUser</b> che possono essere gia' stati associati ad una gara con
	* id <b>idMatch</b> (caso <b>isPartecipant</b> = true) o ancora non
	* associati (caso <b>isPartecipant</b> = false)
	*
	* @param stateUser
	stato dello User
	* @param idMatch
	id del Match
	* @param isPartecipant
	'true' se voglio ricercare gli utenti associati ad una gara,
	'false' altrimenti
	* @return List<ESFUser>
	* @throws SystemException
	* @throws NoSuchUserESFUserRoleException
	*/
	public java.util.List<it.ethica.esf.model.ESFUser> findPartecipantCoaches(
		int stateUser, long idMatch, boolean isPartecipant)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserESFUserRoleException;

	/**
	* Ricerca tutti gli utenti con ruolo Allenatore con stato utente
	* <b>stateUser</b> che possono essere gia' stati associati ad una gara con
	* id <b>idMatch</b> (caso <b>isPartecipant</b> = true) o ancora non
	* associati (caso <b>isPartecipant</b> = false)
	*
	* @param stateUser
	stato dello User
	* @param idMatch
	id del Match
	* @param isPartecipant
	'true' se voglio ricercare gli utenti associati ad una gara,
	'false' altrimenti
	* @param start
	* @param end
	* @return List<ESFUser>
	* @throws SystemException
	* @throws NoSuchUserESFUserRoleException
	*/
	public java.util.List<it.ethica.esf.model.ESFUser> findPartecipantCoaches(
		int stateUser, long idMatch, boolean isPartecipant, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserESFUserRoleException;

	/**
	* Ricerca tutti gli utenti con ruolo Arbitro che possono essere gia' stati
	* associati ad una gara con id <b>idMatch</b> (caso <b>isPartecipant</b> =
	* true) o ancora non associati (caso <b>isPartecipant</b> = false)
	*
	* @param esfTournamentId
	id del Torneo
	* @param idMatch
	id del Match
	* @param isPartecipant
	'true' se voglio ricercare gli utenti associati ad una gara,
	'false' altrimenti
	* @return List<ESFUser>
	* @throws SystemException
	* @throws NoSuchUserESFUserRoleException
	*/
	public java.util.List<it.ethica.esf.model.ESFUser> findNationalPartecipantReferees(
		long idMatch, boolean isPartecipant)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserESFUserRoleException;

	/**
	* Ricerca tutti gli utenti con ruolo Arbitro che possono essere gia' stati
	* associati ad una gara con id <b>idMatch</b> (caso <b>isPartecipant</b> =
	* true) o ancora non associati (caso <b>isPartecipant</b> = false)
	*
	* @param esfTournamentId
	id del Torneo
	* @param idMatch
	id del Match
	* @param isPartecipant
	'true' se voglio ricercare gli utenti associati ad una gara,
	'false' altrimenti
	* @param start
	* @param end
	* @return List<ESFUser>
	* @throws SystemException
	* @throws NoSuchUserESFUserRoleException
	*/
	public java.util.List<it.ethica.esf.model.ESFUser> findNationalPartecipantReferees(
		long idMatch, boolean isPartecipant, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserESFUserRoleException;

	/**
	* Ricerca tutti gli utenti con ruolo Arbitro con stato utente
	* <b>stateUser</b> che possono essere gia' stati associati ad una gara con
	* id <b>idMatch</b> (caso <b>isPartecipant</b> = true) o ancora non
	* associati (caso <b>isPartecipant</b> = false)
	*
	* @param stateUser
	stato dello User
	* @param idMatch
	id del Match
	* @param isPartecipant
	'true' se voglio ricercare gli utenti associati ad una gara,
	'false' altrimenti
	* @param start
	* @param end
	* @return List<ESFUser>
	* @throws SystemException
	* @throws NoSuchUserESFUserRoleException
	*/
	public java.util.List<it.ethica.esf.model.ESFUser> findPartecipantReferees(
		int stateUser, long idMatch, boolean isPartecipant, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserESFUserRoleException;

	/**
	* Ricerca tutti gli utenti con ruolo Arbitro con stato utente
	* <b>stateUser</b> che possono essere gia' stati associati ad una gara con
	* id <b>idMatch</b> (caso <b>isPartecipant</b> = true) o ancora non
	* associati (caso <b>isPartecipant</b> = false)
	*
	* @param stateUser
	stato dello User
	* @param idMatch
	id del Match
	* @param isPartecipant
	'true' se voglio ricercare gli utenti associati ad una gara,
	'false' altrimenti
	* @return List<ESFUser>
	* @throws SystemException
	* @throws NoSuchUserESFUserRoleException
	*/
	public java.util.List<it.ethica.esf.model.ESFUser> findPartecipantReferees(
		int stateUser, long idMatch, boolean isPartecipant)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserESFUserRoleException;

	/**
	* Ricerca tutti gli utenti con ruolo Medico che possono essere gia' stati
	* associati ad una gara con id <b>idMatch</b> (caso <b>isPartecipant</b> =
	* true) o ancora non associati (caso <b>isPartecipant</b> = false)
	*
	* @param esfTournamentId
	id del Torneo
	* @param idMatch
	id del Match
	* @param isPartecipant
	'true' se voglio ricercare gli utenti associati ad una gara,
	'false' altrimenti
	* @return List<ESFUser>
	* @throws SystemException
	* @throws NoSuchUserESFUserRoleException
	*/
	public java.util.List<it.ethica.esf.model.ESFUser> findNationalPartecipantDoctor(
		long idMatch, boolean isPartecipant)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserESFUserRoleException;

	/**
	* Ricerca tutti gli utenti con ruolo Medico che possono essere gia' stati
	* associati ad una gara con id <b>idMatch</b> (caso <b>isPartecipant</b> =
	* true) o ancora non associati (caso <b>isPartecipant</b> = false)
	*
	* @param esfTournamentId
	id del Torneo
	* @param idMatch
	id del Match
	* @param isPartecipant
	'true' se voglio ricercare gli utenti associati ad una gara,
	'false' altrimenti
	* @return List<ESFUser>
	* @throws SystemException
	* @throws NoSuchUserESFUserRoleException
	*/
	public java.util.List<it.ethica.esf.model.ESFUser> findNationalPartecipantDoctor(
		long idMatch, boolean isPartecipant, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserESFUserRoleException;

	/**
	* Ricerca tutti gli utenti con ruolo Medico con stato utente
	* <b>stateUser</b> che possono essere gia' stati associati ad una gara con
	* id <b>idMatch</b> (caso <b>isPartecipant</b> = true) o ancora non
	* associati (caso <b>isPartecipant</b> = false)
	*
	* @param stateUser
	stato dello User
	* @param idMatch
	id del Match
	* @param isPartecipant
	'true' se voglio ricercare gli utenti associati ad una gara,
	'false' altrimenti
	* @return List<ESFUser>
	* @throws SystemException
	* @throws NoSuchUserESFUserRoleException
	*/
	public java.util.List<it.ethica.esf.model.ESFUser> findPartecipantDoctor(
		int stateUser, long idMatch, boolean isPartecipant)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserESFUserRoleException;

	/**
	* Ricerca tutti gli utenti con ruolo Medico con stato utente
	* <b>stateUser</b> che possono essere gia' stati associati ad una gara con
	* id <b>idMatch</b> (caso <b>isPartecipant</b> = true) o ancora non
	* associati (caso <b>isPartecipant</b> = false)
	*
	* @param stateUser
	stato dello User
	* @param idMatch
	id del Match
	* @param isPartecipant
	'true' se voglio ricercare gli utenti associati ad una gara,
	'false' altrimenti
	* @return List<ESFUser>
	* @throws SystemException
	* @throws NoSuchUserESFUserRoleException
	*/
	public java.util.List<it.ethica.esf.model.ESFUser> findPartecipantDoctor(
		int stateUser, long idMatch, boolean isPartecipant, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserESFUserRoleException;

	public it.ethica.esf.model.ESFUser addESFUser(long operatorId,
		java.lang.String code, java.lang.String firstName,
		java.lang.String middleName, java.lang.String lastName,
		java.lang.String userEmail, java.lang.String fiscalCode,
		int birthdayDay, int birthdayMonth, int birthdayYear, boolean male,
		java.lang.String skype, java.lang.String facebook,
		java.lang.String twitter, java.lang.String jobTitle,
		it.ethica.esf.model.ESFEntityState esfEntityState,
		java.util.List<it.ethica.esf.model.ESFAddress> esfAddresses,
		java.util.List<it.ethica.esf.model.ESFPhone> phones,
		java.lang.String birthcity,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public it.ethica.esf.model.ESFUser addESFUserInOrganization(long userId,
		java.lang.String code, java.lang.String screenName,
		java.lang.String emailAddress, long facebookId,
		java.util.Locale locale, java.lang.String firstName,
		java.lang.String middleName, java.lang.String lastName, int prefixId,
		int suffixId, boolean male, int birthdayMonth, int birthdayDay,
		int birthdayYear, java.lang.String jobTitle,
		it.ethica.esf.model.ESFAddress esfAddress,
		it.ethica.esf.model.ESFEntityState esfEntityState,
		java.util.List<com.liferay.portal.model.Phone> phones,
		com.liferay.portal.service.ServiceContext portalUserServiceContext,
		com.liferay.portal.service.ServiceContext esfUserServiceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public it.ethica.esf.model.ESFUser addESFUserInOrganization(long userId,
		java.lang.String code, java.lang.String screenName,
		java.lang.String emailAddress, long facebookId,
		java.util.Locale locale, java.lang.String firstName,
		java.lang.String middleName, java.lang.String lastName, int prefixId,
		int suffixId, boolean male, int birthdayMonth, int birthdayDay,
		int birthdayYear, java.lang.String jobTitle,
		it.ethica.esf.model.ESFAddress esfAddress, long esfStateId,
		java.util.List<com.liferay.portal.model.Phone> phones,
		com.liferay.portal.service.ServiceContext portalUserServiceContext,
		com.liferay.portal.service.ServiceContext esfUserServiceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public it.ethica.esf.model.ESFUser deleteESFUser(long esfUserId,
		java.util.List<it.ethica.esf.model.ESFAddress> esfAddresses,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public it.ethica.esf.model.ESFUser updateESFUser(long operatorId,
		long esfUserId, java.lang.String code, java.lang.String firstName,
		java.lang.String middleName, java.lang.String lastName,
		java.lang.String userEmail, java.lang.String fiscalCode,
		int birthdayDay, int birthdayMonth, int birthdayYear, boolean male,
		boolean disable, java.lang.String skype, java.lang.String facebook,
		java.lang.String twitter, java.lang.String jobTitle,
		it.ethica.esf.model.ESFEntityState esfEntityState,
		java.util.List<it.ethica.esf.model.ESFAddress> esfAddresses,
		java.util.List<it.ethica.esf.model.ESFPhone> phones,
		java.lang.String birthcity,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public it.ethica.esf.model.ESFUser addESFShooter(long operatorId,
		java.lang.String code, java.lang.String firstName,
		java.lang.String middleName, java.lang.String lastName,
		java.lang.String userEmail, java.lang.String fiscalCode,
		int birthdayDay, int birthdayMonth, int birthdayYear,
		java.lang.String birthcity, java.lang.String nationality, boolean male,
		java.lang.String skype, java.lang.String facebook,
		java.lang.String twitter, long typearmy, boolean isSportsGroups,
		java.lang.String job, java.lang.String jobTitle,
		java.lang.String issfIdNumber,
		it.ethica.esf.model.ESFEntityState esfEntityState,
		it.ethica.esf.model.ESFCard esfCard,
		java.util.List<it.ethica.esf.model.ESFAddress> esfAddresses,
		java.util.List<it.ethica.esf.model.ESFPhone> phones,
		com.liferay.portal.service.ServiceContext esfUserServiceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public it.ethica.esf.model.ESFUser updateESFShooter(long operatorId,
		long esfUserId, java.lang.String code, java.lang.String firstName,
		java.lang.String middleName, java.lang.String lastName,
		java.lang.String userEmail, java.lang.String fiscalCode,
		int birthdayDay, int birthdayMonth, int birthdayYear,
		java.lang.String birthcity, java.lang.String nationality, boolean male,
		boolean disable, java.lang.String skype, java.lang.String facebook,
		java.lang.String twitter, long typearmy, boolean isSportsGroups,
		java.lang.String job, java.lang.String jobTitle,
		java.lang.String issfIdNumber,
		it.ethica.esf.model.ESFEntityState esfEntityState,
		it.ethica.esf.model.ESFCard esfCard,
		java.util.List<it.ethica.esf.model.ESFAddress> esfAddresses,
		java.util.List<it.ethica.esf.model.ESFPhone> phones,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public void updateESFUserToESFShooter(long userId, long esfUserId,
		it.ethica.esf.model.ESFCard esfCard,
		java.util.List<it.ethica.esf.model.ESFCard> esfCards,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public void addESFUserToESFShooter(long esfUserId, long esfCardId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchCardException;

	public int countByESFUserRole(long esfUserRoleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<it.ethica.esf.model.ESFUserESFUserRole> getESFUserRoles(
		long esfUserId, boolean active)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<it.ethica.esf.model.ESFUserESFUserRole> getActiveESFUserRoles(
		long esfUserId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<it.ethica.esf.model.ESFUser> findAllUser()
		throws com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.portal.model.User checkEmailAddress(
		java.lang.String emailAddress,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.portal.model.User checkScreenName(
		java.lang.String screenName,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<it.ethica.esf.model.ESFUser> findAllUserByAgeOnlyPeople()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<it.ethica.esf.model.ESFUser> findAllUserByRolenoNull(
		long roleId, long organizationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<it.ethica.esf.model.ESFUser> findShooterRoleAssignedName(
		java.lang.String name, java.lang.String lastName, long roleId,
		long organizationId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public int countShooterRoleAssignedName(java.lang.String name,
		java.lang.String lastName, long roleId, long organizationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<it.ethica.esf.model.ESFUser> findStaffMatch(
		java.lang.String name, java.lang.String lastName,
		java.lang.String fiscalcode, long matchId, long fitavId, int start,
		int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public int countStaffMatch(java.lang.String name,
		java.lang.String lastName, java.lang.String fiscalcode, long matchId,
		long fitavId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<it.ethica.esf.model.ESFUser> findStaffNormalMatch(
		java.lang.String name, java.lang.String lastName,
		java.lang.String fiscalcode, long matchId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public int countStaffNormalMatch(java.lang.String name,
		java.lang.String lastName, java.lang.String fiscalcode, long matchId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;
}