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

import it.ethica.esf.model.ESFNationalMatchResult;

/**
 * The persistence interface for the e s f national match result service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFNationalMatchResultPersistenceImpl
 * @see ESFNationalMatchResultUtil
 * @generated
 */
public interface ESFNationalMatchResultPersistence extends BasePersistence<ESFNationalMatchResult> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ESFNationalMatchResultUtil} to access the e s f national match result persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the e s f national match results where esfMatchId = &#63; and esfUserId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfUserId the esf user ID
	* @return the matching e s f national match results
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFNationalMatchResult> findByESFMatchId_ESFUserId(
		long esfMatchId, long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f national match results where esfMatchId = &#63; and esfUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalMatchResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfMatchId the esf match ID
	* @param esfUserId the esf user ID
	* @param start the lower bound of the range of e s f national match results
	* @param end the upper bound of the range of e s f national match results (not inclusive)
	* @return the range of matching e s f national match results
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFNationalMatchResult> findByESFMatchId_ESFUserId(
		long esfMatchId, long esfUserId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f national match results where esfMatchId = &#63; and esfUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalMatchResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfMatchId the esf match ID
	* @param esfUserId the esf user ID
	* @param start the lower bound of the range of e s f national match results
	* @param end the upper bound of the range of e s f national match results (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f national match results
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFNationalMatchResult> findByESFMatchId_ESFUserId(
		long esfMatchId, long esfUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f national match result in the ordered set where esfMatchId = &#63; and esfUserId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f national match result
	* @throws it.ethica.esf.NoSuchNationalMatchResultException if a matching e s f national match result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFNationalMatchResult findByESFMatchId_ESFUserId_First(
		long esfMatchId, long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalMatchResultException;

	/**
	* Returns the first e s f national match result in the ordered set where esfMatchId = &#63; and esfUserId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f national match result, or <code>null</code> if a matching e s f national match result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFNationalMatchResult fetchByESFMatchId_ESFUserId_First(
		long esfMatchId, long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f national match result in the ordered set where esfMatchId = &#63; and esfUserId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f national match result
	* @throws it.ethica.esf.NoSuchNationalMatchResultException if a matching e s f national match result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFNationalMatchResult findByESFMatchId_ESFUserId_Last(
		long esfMatchId, long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalMatchResultException;

	/**
	* Returns the last e s f national match result in the ordered set where esfMatchId = &#63; and esfUserId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f national match result, or <code>null</code> if a matching e s f national match result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFNationalMatchResult fetchByESFMatchId_ESFUserId_Last(
		long esfMatchId, long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f national match results before and after the current e s f national match result in the ordered set where esfMatchId = &#63; and esfUserId = &#63;.
	*
	* @param esfNationalMatchResultId the primary key of the current e s f national match result
	* @param esfMatchId the esf match ID
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f national match result
	* @throws it.ethica.esf.NoSuchNationalMatchResultException if a e s f national match result with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFNationalMatchResult[] findByESFMatchId_ESFUserId_PrevAndNext(
		long esfNationalMatchResultId, long esfMatchId, long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalMatchResultException;

	/**
	* Removes all the e s f national match results where esfMatchId = &#63; and esfUserId = &#63; from the database.
	*
	* @param esfMatchId the esf match ID
	* @param esfUserId the esf user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByESFMatchId_ESFUserId(long esfMatchId, long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f national match results where esfMatchId = &#63; and esfUserId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfUserId the esf user ID
	* @return the number of matching e s f national match results
	* @throws SystemException if a system exception occurred
	*/
	public int countByESFMatchId_ESFUserId(long esfMatchId, long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f national match results where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @return the matching e s f national match results
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFNationalMatchResult> findByESFUserId(
		long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f national match results where esfUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalMatchResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfUserId the esf user ID
	* @param start the lower bound of the range of e s f national match results
	* @param end the upper bound of the range of e s f national match results (not inclusive)
	* @return the range of matching e s f national match results
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFNationalMatchResult> findByESFUserId(
		long esfUserId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f national match results where esfUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalMatchResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfUserId the esf user ID
	* @param start the lower bound of the range of e s f national match results
	* @param end the upper bound of the range of e s f national match results (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f national match results
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFNationalMatchResult> findByESFUserId(
		long esfUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f national match result in the ordered set where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f national match result
	* @throws it.ethica.esf.NoSuchNationalMatchResultException if a matching e s f national match result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFNationalMatchResult findByESFUserId_First(
		long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalMatchResultException;

	/**
	* Returns the first e s f national match result in the ordered set where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f national match result, or <code>null</code> if a matching e s f national match result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFNationalMatchResult fetchByESFUserId_First(
		long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f national match result in the ordered set where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f national match result
	* @throws it.ethica.esf.NoSuchNationalMatchResultException if a matching e s f national match result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFNationalMatchResult findByESFUserId_Last(
		long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalMatchResultException;

	/**
	* Returns the last e s f national match result in the ordered set where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f national match result, or <code>null</code> if a matching e s f national match result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFNationalMatchResult fetchByESFUserId_Last(
		long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f national match results before and after the current e s f national match result in the ordered set where esfUserId = &#63;.
	*
	* @param esfNationalMatchResultId the primary key of the current e s f national match result
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f national match result
	* @throws it.ethica.esf.NoSuchNationalMatchResultException if a e s f national match result with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFNationalMatchResult[] findByESFUserId_PrevAndNext(
		long esfNationalMatchResultId, long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalMatchResultException;

	/**
	* Removes all the e s f national match results where esfUserId = &#63; from the database.
	*
	* @param esfUserId the esf user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByESFUserId(long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f national match results where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @return the number of matching e s f national match results
	* @throws SystemException if a system exception occurred
	*/
	public int countByESFUserId(long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f national match result where esfMatchId = &#63; or throws a {@link it.ethica.esf.NoSuchNationalMatchResultException} if it could not be found.
	*
	* @param esfMatchId the esf match ID
	* @return the matching e s f national match result
	* @throws it.ethica.esf.NoSuchNationalMatchResultException if a matching e s f national match result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFNationalMatchResult findByESFMatchId(
		long esfMatchId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalMatchResultException;

	/**
	* Returns the e s f national match result where esfMatchId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param esfMatchId the esf match ID
	* @return the matching e s f national match result, or <code>null</code> if a matching e s f national match result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFNationalMatchResult fetchByESFMatchId(
		long esfMatchId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f national match result where esfMatchId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param esfMatchId the esf match ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching e s f national match result, or <code>null</code> if a matching e s f national match result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFNationalMatchResult fetchByESFMatchId(
		long esfMatchId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the e s f national match result where esfMatchId = &#63; from the database.
	*
	* @param esfMatchId the esf match ID
	* @return the e s f national match result that was removed
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFNationalMatchResult removeByESFMatchId(
		long esfMatchId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalMatchResultException;

	/**
	* Returns the number of e s f national match results where esfMatchId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @return the number of matching e s f national match results
	* @throws SystemException if a system exception occurred
	*/
	public int countByESFMatchId(long esfMatchId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f national match results where esfMatchId = &#63; and externalShooter = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param externalShooter the external shooter
	* @return the matching e s f national match results
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFNationalMatchResult> findByESFMatchId_ExternalShooter(
		long esfMatchId, boolean externalShooter)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f national match results where esfMatchId = &#63; and externalShooter = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalMatchResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfMatchId the esf match ID
	* @param externalShooter the external shooter
	* @param start the lower bound of the range of e s f national match results
	* @param end the upper bound of the range of e s f national match results (not inclusive)
	* @return the range of matching e s f national match results
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFNationalMatchResult> findByESFMatchId_ExternalShooter(
		long esfMatchId, boolean externalShooter, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f national match results where esfMatchId = &#63; and externalShooter = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalMatchResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfMatchId the esf match ID
	* @param externalShooter the external shooter
	* @param start the lower bound of the range of e s f national match results
	* @param end the upper bound of the range of e s f national match results (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f national match results
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFNationalMatchResult> findByESFMatchId_ExternalShooter(
		long esfMatchId, boolean externalShooter, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f national match result in the ordered set where esfMatchId = &#63; and externalShooter = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param externalShooter the external shooter
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f national match result
	* @throws it.ethica.esf.NoSuchNationalMatchResultException if a matching e s f national match result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFNationalMatchResult findByESFMatchId_ExternalShooter_First(
		long esfMatchId, boolean externalShooter,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalMatchResultException;

	/**
	* Returns the first e s f national match result in the ordered set where esfMatchId = &#63; and externalShooter = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param externalShooter the external shooter
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f national match result, or <code>null</code> if a matching e s f national match result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFNationalMatchResult fetchByESFMatchId_ExternalShooter_First(
		long esfMatchId, boolean externalShooter,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f national match result in the ordered set where esfMatchId = &#63; and externalShooter = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param externalShooter the external shooter
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f national match result
	* @throws it.ethica.esf.NoSuchNationalMatchResultException if a matching e s f national match result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFNationalMatchResult findByESFMatchId_ExternalShooter_Last(
		long esfMatchId, boolean externalShooter,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalMatchResultException;

	/**
	* Returns the last e s f national match result in the ordered set where esfMatchId = &#63; and externalShooter = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param externalShooter the external shooter
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f national match result, or <code>null</code> if a matching e s f national match result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFNationalMatchResult fetchByESFMatchId_ExternalShooter_Last(
		long esfMatchId, boolean externalShooter,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f national match results before and after the current e s f national match result in the ordered set where esfMatchId = &#63; and externalShooter = &#63;.
	*
	* @param esfNationalMatchResultId the primary key of the current e s f national match result
	* @param esfMatchId the esf match ID
	* @param externalShooter the external shooter
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f national match result
	* @throws it.ethica.esf.NoSuchNationalMatchResultException if a e s f national match result with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFNationalMatchResult[] findByESFMatchId_ExternalShooter_PrevAndNext(
		long esfNationalMatchResultId, long esfMatchId,
		boolean externalShooter,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalMatchResultException;

	/**
	* Removes all the e s f national match results where esfMatchId = &#63; and externalShooter = &#63; from the database.
	*
	* @param esfMatchId the esf match ID
	* @param externalShooter the external shooter
	* @throws SystemException if a system exception occurred
	*/
	public void removeByESFMatchId_ExternalShooter(long esfMatchId,
		boolean externalShooter)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f national match results where esfMatchId = &#63; and externalShooter = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param externalShooter the external shooter
	* @return the number of matching e s f national match results
	* @throws SystemException if a system exception occurred
	*/
	public int countByESFMatchId_ExternalShooter(long esfMatchId,
		boolean externalShooter)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the e s f national match result in the entity cache if it is enabled.
	*
	* @param esfNationalMatchResult the e s f national match result
	*/
	public void cacheResult(
		it.ethica.esf.model.ESFNationalMatchResult esfNationalMatchResult);

	/**
	* Caches the e s f national match results in the entity cache if it is enabled.
	*
	* @param esfNationalMatchResults the e s f national match results
	*/
	public void cacheResult(
		java.util.List<it.ethica.esf.model.ESFNationalMatchResult> esfNationalMatchResults);

	/**
	* Creates a new e s f national match result with the primary key. Does not add the e s f national match result to the database.
	*
	* @param esfNationalMatchResultId the primary key for the new e s f national match result
	* @return the new e s f national match result
	*/
	public it.ethica.esf.model.ESFNationalMatchResult create(
		long esfNationalMatchResultId);

	/**
	* Removes the e s f national match result with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfNationalMatchResultId the primary key of the e s f national match result
	* @return the e s f national match result that was removed
	* @throws it.ethica.esf.NoSuchNationalMatchResultException if a e s f national match result with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFNationalMatchResult remove(
		long esfNationalMatchResultId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalMatchResultException;

	public it.ethica.esf.model.ESFNationalMatchResult updateImpl(
		it.ethica.esf.model.ESFNationalMatchResult esfNationalMatchResult)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f national match result with the primary key or throws a {@link it.ethica.esf.NoSuchNationalMatchResultException} if it could not be found.
	*
	* @param esfNationalMatchResultId the primary key of the e s f national match result
	* @return the e s f national match result
	* @throws it.ethica.esf.NoSuchNationalMatchResultException if a e s f national match result with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFNationalMatchResult findByPrimaryKey(
		long esfNationalMatchResultId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalMatchResultException;

	/**
	* Returns the e s f national match result with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param esfNationalMatchResultId the primary key of the e s f national match result
	* @return the e s f national match result, or <code>null</code> if a e s f national match result with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFNationalMatchResult fetchByPrimaryKey(
		long esfNationalMatchResultId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f national match results.
	*
	* @return the e s f national match results
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFNationalMatchResult> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.ethica.esf.model.ESFNationalMatchResult> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f national match results.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalMatchResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f national match results
	* @param end the upper bound of the range of e s f national match results (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of e s f national match results
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFNationalMatchResult> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the e s f national match results from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f national match results.
	*
	* @return the number of e s f national match results
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}