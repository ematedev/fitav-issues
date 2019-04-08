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

package it.ethica.esf.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import it.ethica.esf.model.ESFTeam;

import java.util.List;

/**
 * The persistence utility for the e s f team service. This utility wraps {@link ESFTeamPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFTeamPersistence
 * @see ESFTeamPersistenceImpl
 * @generated
 */
public class ESFTeamUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(ESFTeam esfTeam) {
		getPersistence().clearCache(esfTeam);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ESFTeam> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ESFTeam> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ESFTeam> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ESFTeam update(ESFTeam esfTeam) throws SystemException {
		return getPersistence().update(esfTeam);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ESFTeam update(ESFTeam esfTeam, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(esfTeam, serviceContext);
	}

	/**
	* Returns all the e s f teams where esfTournamentId = &#63;.
	*
	* @param esfTournamentId the esf tournament ID
	* @return the matching e s f teams
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFTeam> findByTournament(
		long esfTournamentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTournament(esfTournamentId);
	}

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
	public static java.util.List<it.ethica.esf.model.ESFTeam> findByTournament(
		long esfTournamentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTournament(esfTournamentId, start, end);
	}

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
	public static java.util.List<it.ethica.esf.model.ESFTeam> findByTournament(
		long esfTournamentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTournament(esfTournamentId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first e s f team in the ordered set where esfTournamentId = &#63;.
	*
	* @param esfTournamentId the esf tournament ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f team
	* @throws it.ethica.esf.NoSuchTeamException if a matching e s f team could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFTeam findByTournament_First(
		long esfTournamentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchTeamException {
		return getPersistence()
				   .findByTournament_First(esfTournamentId, orderByComparator);
	}

	/**
	* Returns the first e s f team in the ordered set where esfTournamentId = &#63;.
	*
	* @param esfTournamentId the esf tournament ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f team, or <code>null</code> if a matching e s f team could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFTeam fetchByTournament_First(
		long esfTournamentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTournament_First(esfTournamentId, orderByComparator);
	}

	/**
	* Returns the last e s f team in the ordered set where esfTournamentId = &#63;.
	*
	* @param esfTournamentId the esf tournament ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f team
	* @throws it.ethica.esf.NoSuchTeamException if a matching e s f team could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFTeam findByTournament_Last(
		long esfTournamentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchTeamException {
		return getPersistence()
				   .findByTournament_Last(esfTournamentId, orderByComparator);
	}

	/**
	* Returns the last e s f team in the ordered set where esfTournamentId = &#63;.
	*
	* @param esfTournamentId the esf tournament ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f team, or <code>null</code> if a matching e s f team could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFTeam fetchByTournament_Last(
		long esfTournamentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTournament_Last(esfTournamentId, orderByComparator);
	}

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
	public static it.ethica.esf.model.ESFTeam[] findByTournament_PrevAndNext(
		long esfTeamId, long esfTournamentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchTeamException {
		return getPersistence()
				   .findByTournament_PrevAndNext(esfTeamId, esfTournamentId,
			orderByComparator);
	}

	/**
	* Removes all the e s f teams where esfTournamentId = &#63; from the database.
	*
	* @param esfTournamentId the esf tournament ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTournament(long esfTournamentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTournament(esfTournamentId);
	}

	/**
	* Returns the number of e s f teams where esfTournamentId = &#63;.
	*
	* @param esfTournamentId the esf tournament ID
	* @return the number of matching e s f teams
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTournament(long esfTournamentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTournament(esfTournamentId);
	}

	/**
	* Caches the e s f team in the entity cache if it is enabled.
	*
	* @param esfTeam the e s f team
	*/
	public static void cacheResult(it.ethica.esf.model.ESFTeam esfTeam) {
		getPersistence().cacheResult(esfTeam);
	}

	/**
	* Caches the e s f teams in the entity cache if it is enabled.
	*
	* @param esfTeams the e s f teams
	*/
	public static void cacheResult(
		java.util.List<it.ethica.esf.model.ESFTeam> esfTeams) {
		getPersistence().cacheResult(esfTeams);
	}

	/**
	* Creates a new e s f team with the primary key. Does not add the e s f team to the database.
	*
	* @param esfTeamId the primary key for the new e s f team
	* @return the new e s f team
	*/
	public static it.ethica.esf.model.ESFTeam create(long esfTeamId) {
		return getPersistence().create(esfTeamId);
	}

	/**
	* Removes the e s f team with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfTeamId the primary key of the e s f team
	* @return the e s f team that was removed
	* @throws it.ethica.esf.NoSuchTeamException if a e s f team with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFTeam remove(long esfTeamId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchTeamException {
		return getPersistence().remove(esfTeamId);
	}

	public static it.ethica.esf.model.ESFTeam updateImpl(
		it.ethica.esf.model.ESFTeam esfTeam)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(esfTeam);
	}

	/**
	* Returns the e s f team with the primary key or throws a {@link it.ethica.esf.NoSuchTeamException} if it could not be found.
	*
	* @param esfTeamId the primary key of the e s f team
	* @return the e s f team
	* @throws it.ethica.esf.NoSuchTeamException if a e s f team with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFTeam findByPrimaryKey(long esfTeamId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchTeamException {
		return getPersistence().findByPrimaryKey(esfTeamId);
	}

	/**
	* Returns the e s f team with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param esfTeamId the primary key of the e s f team
	* @return the e s f team, or <code>null</code> if a e s f team with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFTeam fetchByPrimaryKey(long esfTeamId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(esfTeamId);
	}

	/**
	* Returns all the e s f teams.
	*
	* @return the e s f teams
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFTeam> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<it.ethica.esf.model.ESFTeam> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<it.ethica.esf.model.ESFTeam> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the e s f teams from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of e s f teams.
	*
	* @return the number of e s f teams
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ESFTeamPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ESFTeamPersistence)PortletBeanLocatorUtil.locate(it.ethica.esf.service.ClpSerializer.getServletContextName(),
					ESFTeamPersistence.class.getName());

			ReferenceRegistry.registerReference(ESFTeamUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ESFTeamPersistence persistence) {
	}

	private static ESFTeamPersistence _persistence;
}