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

import com.liferay.portal.service.persistence.BasePersistence;

import it.ethica.esf.model.ESFShooterQualificationESFTournament;

/**
 * The persistence interface for the e s f shooter qualification e s f tournament service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFShooterQualificationESFTournamentPersistenceImpl
 * @see ESFShooterQualificationESFTournamentUtil
 * @generated
 */
public interface ESFShooterQualificationESFTournamentPersistence
	extends BasePersistence<ESFShooterQualificationESFTournament> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ESFShooterQualificationESFTournamentUtil} to access the e s f shooter qualification e s f tournament persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the e s f shooter qualification e s f tournaments where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching e s f shooter qualification e s f tournaments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFShooterQualificationESFTournament> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f shooter qualification e s f tournaments where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShooterQualificationESFTournamentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of e s f shooter qualification e s f tournaments
	* @param end the upper bound of the range of e s f shooter qualification e s f tournaments (not inclusive)
	* @return the range of matching e s f shooter qualification e s f tournaments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFShooterQualificationESFTournament> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f shooter qualification e s f tournaments where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShooterQualificationESFTournamentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of e s f shooter qualification e s f tournaments
	* @param end the upper bound of the range of e s f shooter qualification e s f tournaments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f shooter qualification e s f tournaments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFShooterQualificationESFTournament> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f shooter qualification e s f tournament in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f shooter qualification e s f tournament
	* @throws it.ethica.esf.NoSuchShooterQualificationESFTournamentException if a matching e s f shooter qualification e s f tournament could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFShooterQualificationESFTournament findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchShooterQualificationESFTournamentException;

	/**
	* Returns the first e s f shooter qualification e s f tournament in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f shooter qualification e s f tournament, or <code>null</code> if a matching e s f shooter qualification e s f tournament could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFShooterQualificationESFTournament fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f shooter qualification e s f tournament in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f shooter qualification e s f tournament
	* @throws it.ethica.esf.NoSuchShooterQualificationESFTournamentException if a matching e s f shooter qualification e s f tournament could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFShooterQualificationESFTournament findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchShooterQualificationESFTournamentException;

	/**
	* Returns the last e s f shooter qualification e s f tournament in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f shooter qualification e s f tournament, or <code>null</code> if a matching e s f shooter qualification e s f tournament could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFShooterQualificationESFTournament fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f shooter qualification e s f tournaments before and after the current e s f shooter qualification e s f tournament in the ordered set where uuid = &#63;.
	*
	* @param esfShooterQualificationESFTournamentPK the primary key of the current e s f shooter qualification e s f tournament
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f shooter qualification e s f tournament
	* @throws it.ethica.esf.NoSuchShooterQualificationESFTournamentException if a e s f shooter qualification e s f tournament with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFShooterQualificationESFTournament[] findByUuid_PrevAndNext(
		it.ethica.esf.service.persistence.ESFShooterQualificationESFTournamentPK esfShooterQualificationESFTournamentPK,
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchShooterQualificationESFTournamentException;

	/**
	* Removes all the e s f shooter qualification e s f tournaments where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f shooter qualification e s f tournaments where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching e s f shooter qualification e s f tournaments
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f shooter qualification e s f tournament where uuid = &#63; and groupId = &#63; or throws a {@link it.ethica.esf.NoSuchShooterQualificationESFTournamentException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching e s f shooter qualification e s f tournament
	* @throws it.ethica.esf.NoSuchShooterQualificationESFTournamentException if a matching e s f shooter qualification e s f tournament could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFShooterQualificationESFTournament findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchShooterQualificationESFTournamentException;

	/**
	* Returns the e s f shooter qualification e s f tournament where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching e s f shooter qualification e s f tournament, or <code>null</code> if a matching e s f shooter qualification e s f tournament could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFShooterQualificationESFTournament fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f shooter qualification e s f tournament where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching e s f shooter qualification e s f tournament, or <code>null</code> if a matching e s f shooter qualification e s f tournament could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFShooterQualificationESFTournament fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the e s f shooter qualification e s f tournament where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the e s f shooter qualification e s f tournament that was removed
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFShooterQualificationESFTournament removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchShooterQualificationESFTournamentException;

	/**
	* Returns the number of e s f shooter qualification e s f tournaments where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching e s f shooter qualification e s f tournaments
	* @throws SystemException if a system exception occurred
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f shooter qualification e s f tournaments where esfTournamentId = &#63;.
	*
	* @param esfTournamentId the esf tournament ID
	* @return the matching e s f shooter qualification e s f tournaments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFShooterQualificationESFTournament> findByESFTournament(
		long esfTournamentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f shooter qualification e s f tournaments where esfTournamentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShooterQualificationESFTournamentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfTournamentId the esf tournament ID
	* @param start the lower bound of the range of e s f shooter qualification e s f tournaments
	* @param end the upper bound of the range of e s f shooter qualification e s f tournaments (not inclusive)
	* @return the range of matching e s f shooter qualification e s f tournaments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFShooterQualificationESFTournament> findByESFTournament(
		long esfTournamentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f shooter qualification e s f tournaments where esfTournamentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShooterQualificationESFTournamentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfTournamentId the esf tournament ID
	* @param start the lower bound of the range of e s f shooter qualification e s f tournaments
	* @param end the upper bound of the range of e s f shooter qualification e s f tournaments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f shooter qualification e s f tournaments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFShooterQualificationESFTournament> findByESFTournament(
		long esfTournamentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f shooter qualification e s f tournament in the ordered set where esfTournamentId = &#63;.
	*
	* @param esfTournamentId the esf tournament ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f shooter qualification e s f tournament
	* @throws it.ethica.esf.NoSuchShooterQualificationESFTournamentException if a matching e s f shooter qualification e s f tournament could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFShooterQualificationESFTournament findByESFTournament_First(
		long esfTournamentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchShooterQualificationESFTournamentException;

	/**
	* Returns the first e s f shooter qualification e s f tournament in the ordered set where esfTournamentId = &#63;.
	*
	* @param esfTournamentId the esf tournament ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f shooter qualification e s f tournament, or <code>null</code> if a matching e s f shooter qualification e s f tournament could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFShooterQualificationESFTournament fetchByESFTournament_First(
		long esfTournamentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f shooter qualification e s f tournament in the ordered set where esfTournamentId = &#63;.
	*
	* @param esfTournamentId the esf tournament ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f shooter qualification e s f tournament
	* @throws it.ethica.esf.NoSuchShooterQualificationESFTournamentException if a matching e s f shooter qualification e s f tournament could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFShooterQualificationESFTournament findByESFTournament_Last(
		long esfTournamentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchShooterQualificationESFTournamentException;

	/**
	* Returns the last e s f shooter qualification e s f tournament in the ordered set where esfTournamentId = &#63;.
	*
	* @param esfTournamentId the esf tournament ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f shooter qualification e s f tournament, or <code>null</code> if a matching e s f shooter qualification e s f tournament could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFShooterQualificationESFTournament fetchByESFTournament_Last(
		long esfTournamentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f shooter qualification e s f tournaments before and after the current e s f shooter qualification e s f tournament in the ordered set where esfTournamentId = &#63;.
	*
	* @param esfShooterQualificationESFTournamentPK the primary key of the current e s f shooter qualification e s f tournament
	* @param esfTournamentId the esf tournament ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f shooter qualification e s f tournament
	* @throws it.ethica.esf.NoSuchShooterQualificationESFTournamentException if a e s f shooter qualification e s f tournament with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFShooterQualificationESFTournament[] findByESFTournament_PrevAndNext(
		it.ethica.esf.service.persistence.ESFShooterQualificationESFTournamentPK esfShooterQualificationESFTournamentPK,
		long esfTournamentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchShooterQualificationESFTournamentException;

	/**
	* Removes all the e s f shooter qualification e s f tournaments where esfTournamentId = &#63; from the database.
	*
	* @param esfTournamentId the esf tournament ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByESFTournament(long esfTournamentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f shooter qualification e s f tournaments where esfTournamentId = &#63;.
	*
	* @param esfTournamentId the esf tournament ID
	* @return the number of matching e s f shooter qualification e s f tournaments
	* @throws SystemException if a system exception occurred
	*/
	public int countByESFTournament(long esfTournamentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the e s f shooter qualification e s f tournament in the entity cache if it is enabled.
	*
	* @param esfShooterQualificationESFTournament the e s f shooter qualification e s f tournament
	*/
	public void cacheResult(
		it.ethica.esf.model.ESFShooterQualificationESFTournament esfShooterQualificationESFTournament);

	/**
	* Caches the e s f shooter qualification e s f tournaments in the entity cache if it is enabled.
	*
	* @param esfShooterQualificationESFTournaments the e s f shooter qualification e s f tournaments
	*/
	public void cacheResult(
		java.util.List<it.ethica.esf.model.ESFShooterQualificationESFTournament> esfShooterQualificationESFTournaments);

	/**
	* Creates a new e s f shooter qualification e s f tournament with the primary key. Does not add the e s f shooter qualification e s f tournament to the database.
	*
	* @param esfShooterQualificationESFTournamentPK the primary key for the new e s f shooter qualification e s f tournament
	* @return the new e s f shooter qualification e s f tournament
	*/
	public it.ethica.esf.model.ESFShooterQualificationESFTournament create(
		it.ethica.esf.service.persistence.ESFShooterQualificationESFTournamentPK esfShooterQualificationESFTournamentPK);

	/**
	* Removes the e s f shooter qualification e s f tournament with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfShooterQualificationESFTournamentPK the primary key of the e s f shooter qualification e s f tournament
	* @return the e s f shooter qualification e s f tournament that was removed
	* @throws it.ethica.esf.NoSuchShooterQualificationESFTournamentException if a e s f shooter qualification e s f tournament with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFShooterQualificationESFTournament remove(
		it.ethica.esf.service.persistence.ESFShooterQualificationESFTournamentPK esfShooterQualificationESFTournamentPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchShooterQualificationESFTournamentException;

	public it.ethica.esf.model.ESFShooterQualificationESFTournament updateImpl(
		it.ethica.esf.model.ESFShooterQualificationESFTournament esfShooterQualificationESFTournament)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f shooter qualification e s f tournament with the primary key or throws a {@link it.ethica.esf.NoSuchShooterQualificationESFTournamentException} if it could not be found.
	*
	* @param esfShooterQualificationESFTournamentPK the primary key of the e s f shooter qualification e s f tournament
	* @return the e s f shooter qualification e s f tournament
	* @throws it.ethica.esf.NoSuchShooterQualificationESFTournamentException if a e s f shooter qualification e s f tournament with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFShooterQualificationESFTournament findByPrimaryKey(
		it.ethica.esf.service.persistence.ESFShooterQualificationESFTournamentPK esfShooterQualificationESFTournamentPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchShooterQualificationESFTournamentException;

	/**
	* Returns the e s f shooter qualification e s f tournament with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param esfShooterQualificationESFTournamentPK the primary key of the e s f shooter qualification e s f tournament
	* @return the e s f shooter qualification e s f tournament, or <code>null</code> if a e s f shooter qualification e s f tournament with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFShooterQualificationESFTournament fetchByPrimaryKey(
		it.ethica.esf.service.persistence.ESFShooterQualificationESFTournamentPK esfShooterQualificationESFTournamentPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f shooter qualification e s f tournaments.
	*
	* @return the e s f shooter qualification e s f tournaments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFShooterQualificationESFTournament> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f shooter qualification e s f tournaments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShooterQualificationESFTournamentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f shooter qualification e s f tournaments
	* @param end the upper bound of the range of e s f shooter qualification e s f tournaments (not inclusive)
	* @return the range of e s f shooter qualification e s f tournaments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFShooterQualificationESFTournament> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f shooter qualification e s f tournaments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShooterQualificationESFTournamentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f shooter qualification e s f tournaments
	* @param end the upper bound of the range of e s f shooter qualification e s f tournaments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of e s f shooter qualification e s f tournaments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFShooterQualificationESFTournament> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the e s f shooter qualification e s f tournaments from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f shooter qualification e s f tournaments.
	*
	* @return the number of e s f shooter qualification e s f tournaments
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}