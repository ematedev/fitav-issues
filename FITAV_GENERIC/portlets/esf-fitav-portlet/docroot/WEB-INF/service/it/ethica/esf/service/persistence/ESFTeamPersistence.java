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

package it.ethica.esf.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import it.ethica.esf.model.ESFTeam;

/**
 * The persistence interface for the e s f team service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFTeamPersistenceImpl
 * @see ESFTeamUtil
 * @generated
 */
public interface ESFTeamPersistence extends BasePersistence<ESFTeam> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ESFTeamUtil} to access the e s f team persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the e s f teams where esfTournamentId = &#63;.
	*
	* @param esfTournamentId the esf tournament ID
	* @return the matching e s f teams
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFTeam> findByTournament(
		long esfTournamentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f teams where esfTournamentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFTeamModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfTournamentId the esf tournament ID
	* @param start the lower bound of the range of e s f teams
	* @param end the upper bound of the range of e s f teams (not inclusive)
	* @return the range of matching e s f teams
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFTeam> findByTournament(
		long esfTournamentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f teams where esfTournamentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFTeamModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfTournamentId the esf tournament ID
	* @param start the lower bound of the range of e s f teams
	* @param end the upper bound of the range of e s f teams (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f teams
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFTeam> findByTournament(
		long esfTournamentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f team in the ordered set where esfTournamentId = &#63;.
	*
	* @param esfTournamentId the esf tournament ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f team
	* @throws it.ethica.esf.NoSuchTeamException if a matching e s f team could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFTeam findByTournament_First(
		long esfTournamentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchTeamException;

	/**
	* Returns the first e s f team in the ordered set where esfTournamentId = &#63;.
	*
	* @param esfTournamentId the esf tournament ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f team, or <code>null</code> if a matching e s f team could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFTeam fetchByTournament_First(
		long esfTournamentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f team in the ordered set where esfTournamentId = &#63;.
	*
	* @param esfTournamentId the esf tournament ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f team
	* @throws it.ethica.esf.NoSuchTeamException if a matching e s f team could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFTeam findByTournament_Last(
		long esfTournamentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchTeamException;

	/**
	* Returns the last e s f team in the ordered set where esfTournamentId = &#63;.
	*
	* @param esfTournamentId the esf tournament ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f team, or <code>null</code> if a matching e s f team could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFTeam fetchByTournament_Last(
		long esfTournamentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f teams before and after the current e s f team in the ordered set where esfTournamentId = &#63;.
	*
	* @param esfTeamId the primary key of the current e s f team
	* @param esfTournamentId the esf tournament ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f team
	* @throws it.ethica.esf.NoSuchTeamException if a e s f team with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFTeam[] findByTournament_PrevAndNext(
		long esfTeamId, long esfTournamentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchTeamException;

	/**
	* Removes all the e s f teams where esfTournamentId = &#63; from the database.
	*
	* @param esfTournamentId the esf tournament ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTournament(long esfTournamentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f teams where esfTournamentId = &#63;.
	*
	* @param esfTournamentId the esf tournament ID
	* @return the number of matching e s f teams
	* @throws SystemException if a system exception occurred
	*/
	public int countByTournament(long esfTournamentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the e s f team in the entity cache if it is enabled.
	*
	* @param esfTeam the e s f team
	*/
	public void cacheResult(it.ethica.esf.model.ESFTeam esfTeam);

	/**
	* Caches the e s f teams in the entity cache if it is enabled.
	*
	* @param esfTeams the e s f teams
	*/
	public void cacheResult(
		java.util.List<it.ethica.esf.model.ESFTeam> esfTeams);

	/**
	* Creates a new e s f team with the primary key. Does not add the e s f team to the database.
	*
	* @param esfTeamId the primary key for the new e s f team
	* @return the new e s f team
	*/
	public it.ethica.esf.model.ESFTeam create(long esfTeamId);

	/**
	* Removes the e s f team with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfTeamId the primary key of the e s f team
	* @return the e s f team that was removed
	* @throws it.ethica.esf.NoSuchTeamException if a e s f team with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFTeam remove(long esfTeamId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchTeamException;

	public it.ethica.esf.model.ESFTeam updateImpl(
		it.ethica.esf.model.ESFTeam esfTeam)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f team with the primary key or throws a {@link it.ethica.esf.NoSuchTeamException} if it could not be found.
	*
	* @param esfTeamId the primary key of the e s f team
	* @return the e s f team
	* @throws it.ethica.esf.NoSuchTeamException if a e s f team with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFTeam findByPrimaryKey(long esfTeamId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchTeamException;

	/**
	* Returns the e s f team with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param esfTeamId the primary key of the e s f team
	* @return the e s f team, or <code>null</code> if a e s f team with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFTeam fetchByPrimaryKey(long esfTeamId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f teams.
	*
	* @return the e s f teams
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFTeam> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f teams.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFTeamModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f teams
	* @param end the upper bound of the range of e s f teams (not inclusive)
	* @return the range of e s f teams
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFTeam> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f teams.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFTeamModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f teams
	* @param end the upper bound of the range of e s f teams (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of e s f teams
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFTeam> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the e s f teams from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f teams.
	*
	* @return the number of e s f teams
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}