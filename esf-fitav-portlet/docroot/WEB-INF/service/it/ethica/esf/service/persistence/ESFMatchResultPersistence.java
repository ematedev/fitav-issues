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

import it.ethica.esf.model.ESFMatchResult;

/**
 * The persistence interface for the e s f match result service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFMatchResultPersistenceImpl
 * @see ESFMatchResultUtil
 * @generated
 */
public interface ESFMatchResultPersistence extends BasePersistence<ESFMatchResult> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ESFMatchResultUtil} to access the e s f match result persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the e s f match results where esfMatchId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @return the matching e s f match results
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFMatchResult> findByEsfMatchId(
		long esfMatchId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f match results where esfMatchId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFMatchResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfMatchId the esf match ID
	* @param start the lower bound of the range of e s f match results
	* @param end the upper bound of the range of e s f match results (not inclusive)
	* @return the range of matching e s f match results
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFMatchResult> findByEsfMatchId(
		long esfMatchId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f match results where esfMatchId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFMatchResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfMatchId the esf match ID
	* @param start the lower bound of the range of e s f match results
	* @param end the upper bound of the range of e s f match results (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f match results
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFMatchResult> findByEsfMatchId(
		long esfMatchId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f match result in the ordered set where esfMatchId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f match result
	* @throws it.ethica.esf.NoSuchMatchResultException if a matching e s f match result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFMatchResult findByEsfMatchId_First(
		long esfMatchId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchMatchResultException;

	/**
	* Returns the first e s f match result in the ordered set where esfMatchId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f match result, or <code>null</code> if a matching e s f match result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFMatchResult fetchByEsfMatchId_First(
		long esfMatchId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f match result in the ordered set where esfMatchId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f match result
	* @throws it.ethica.esf.NoSuchMatchResultException if a matching e s f match result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFMatchResult findByEsfMatchId_Last(
		long esfMatchId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchMatchResultException;

	/**
	* Returns the last e s f match result in the ordered set where esfMatchId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f match result, or <code>null</code> if a matching e s f match result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFMatchResult fetchByEsfMatchId_Last(
		long esfMatchId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f match results before and after the current e s f match result in the ordered set where esfMatchId = &#63;.
	*
	* @param esfMatchResultId the primary key of the current e s f match result
	* @param esfMatchId the esf match ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f match result
	* @throws it.ethica.esf.NoSuchMatchResultException if a e s f match result with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFMatchResult[] findByEsfMatchId_PrevAndNext(
		long esfMatchResultId, long esfMatchId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchMatchResultException;

	/**
	* Removes all the e s f match results where esfMatchId = &#63; from the database.
	*
	* @param esfMatchId the esf match ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByEsfMatchId(long esfMatchId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f match results where esfMatchId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @return the number of matching e s f match results
	* @throws SystemException if a system exception occurred
	*/
	public int countByEsfMatchId(long esfMatchId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f match results where esfPartecipantId = &#63;.
	*
	* @param esfPartecipantId the esf partecipant ID
	* @return the matching e s f match results
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFMatchResult> findByResultUserId(
		long esfPartecipantId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f match results where esfPartecipantId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFMatchResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfPartecipantId the esf partecipant ID
	* @param start the lower bound of the range of e s f match results
	* @param end the upper bound of the range of e s f match results (not inclusive)
	* @return the range of matching e s f match results
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFMatchResult> findByResultUserId(
		long esfPartecipantId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f match results where esfPartecipantId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFMatchResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfPartecipantId the esf partecipant ID
	* @param start the lower bound of the range of e s f match results
	* @param end the upper bound of the range of e s f match results (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f match results
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFMatchResult> findByResultUserId(
		long esfPartecipantId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f match result in the ordered set where esfPartecipantId = &#63;.
	*
	* @param esfPartecipantId the esf partecipant ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f match result
	* @throws it.ethica.esf.NoSuchMatchResultException if a matching e s f match result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFMatchResult findByResultUserId_First(
		long esfPartecipantId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchMatchResultException;

	/**
	* Returns the first e s f match result in the ordered set where esfPartecipantId = &#63;.
	*
	* @param esfPartecipantId the esf partecipant ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f match result, or <code>null</code> if a matching e s f match result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFMatchResult fetchByResultUserId_First(
		long esfPartecipantId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f match result in the ordered set where esfPartecipantId = &#63;.
	*
	* @param esfPartecipantId the esf partecipant ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f match result
	* @throws it.ethica.esf.NoSuchMatchResultException if a matching e s f match result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFMatchResult findByResultUserId_Last(
		long esfPartecipantId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchMatchResultException;

	/**
	* Returns the last e s f match result in the ordered set where esfPartecipantId = &#63;.
	*
	* @param esfPartecipantId the esf partecipant ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f match result, or <code>null</code> if a matching e s f match result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFMatchResult fetchByResultUserId_Last(
		long esfPartecipantId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f match results before and after the current e s f match result in the ordered set where esfPartecipantId = &#63;.
	*
	* @param esfMatchResultId the primary key of the current e s f match result
	* @param esfPartecipantId the esf partecipant ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f match result
	* @throws it.ethica.esf.NoSuchMatchResultException if a e s f match result with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFMatchResult[] findByResultUserId_PrevAndNext(
		long esfMatchResultId, long esfPartecipantId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchMatchResultException;

	/**
	* Removes all the e s f match results where esfPartecipantId = &#63; from the database.
	*
	* @param esfPartecipantId the esf partecipant ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByResultUserId(long esfPartecipantId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f match results where esfPartecipantId = &#63;.
	*
	* @param esfPartecipantId the esf partecipant ID
	* @return the number of matching e s f match results
	* @throws SystemException if a system exception occurred
	*/
	public int countByResultUserId(long esfPartecipantId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f match results where esfPartecipantId = &#63; and esfMatchId = &#63;.
	*
	* @param esfPartecipantId the esf partecipant ID
	* @param esfMatchId the esf match ID
	* @return the matching e s f match results
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFMatchResult> findBymatchId_PartecipantId(
		long esfPartecipantId, long esfMatchId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f match results where esfPartecipantId = &#63; and esfMatchId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFMatchResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfPartecipantId the esf partecipant ID
	* @param esfMatchId the esf match ID
	* @param start the lower bound of the range of e s f match results
	* @param end the upper bound of the range of e s f match results (not inclusive)
	* @return the range of matching e s f match results
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFMatchResult> findBymatchId_PartecipantId(
		long esfPartecipantId, long esfMatchId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f match results where esfPartecipantId = &#63; and esfMatchId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFMatchResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfPartecipantId the esf partecipant ID
	* @param esfMatchId the esf match ID
	* @param start the lower bound of the range of e s f match results
	* @param end the upper bound of the range of e s f match results (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f match results
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFMatchResult> findBymatchId_PartecipantId(
		long esfPartecipantId, long esfMatchId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f match result in the ordered set where esfPartecipantId = &#63; and esfMatchId = &#63;.
	*
	* @param esfPartecipantId the esf partecipant ID
	* @param esfMatchId the esf match ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f match result
	* @throws it.ethica.esf.NoSuchMatchResultException if a matching e s f match result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFMatchResult findBymatchId_PartecipantId_First(
		long esfPartecipantId, long esfMatchId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchMatchResultException;

	/**
	* Returns the first e s f match result in the ordered set where esfPartecipantId = &#63; and esfMatchId = &#63;.
	*
	* @param esfPartecipantId the esf partecipant ID
	* @param esfMatchId the esf match ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f match result, or <code>null</code> if a matching e s f match result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFMatchResult fetchBymatchId_PartecipantId_First(
		long esfPartecipantId, long esfMatchId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f match result in the ordered set where esfPartecipantId = &#63; and esfMatchId = &#63;.
	*
	* @param esfPartecipantId the esf partecipant ID
	* @param esfMatchId the esf match ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f match result
	* @throws it.ethica.esf.NoSuchMatchResultException if a matching e s f match result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFMatchResult findBymatchId_PartecipantId_Last(
		long esfPartecipantId, long esfMatchId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchMatchResultException;

	/**
	* Returns the last e s f match result in the ordered set where esfPartecipantId = &#63; and esfMatchId = &#63;.
	*
	* @param esfPartecipantId the esf partecipant ID
	* @param esfMatchId the esf match ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f match result, or <code>null</code> if a matching e s f match result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFMatchResult fetchBymatchId_PartecipantId_Last(
		long esfPartecipantId, long esfMatchId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f match results before and after the current e s f match result in the ordered set where esfPartecipantId = &#63; and esfMatchId = &#63;.
	*
	* @param esfMatchResultId the primary key of the current e s f match result
	* @param esfPartecipantId the esf partecipant ID
	* @param esfMatchId the esf match ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f match result
	* @throws it.ethica.esf.NoSuchMatchResultException if a e s f match result with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFMatchResult[] findBymatchId_PartecipantId_PrevAndNext(
		long esfMatchResultId, long esfPartecipantId, long esfMatchId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchMatchResultException;

	/**
	* Removes all the e s f match results where esfPartecipantId = &#63; and esfMatchId = &#63; from the database.
	*
	* @param esfPartecipantId the esf partecipant ID
	* @param esfMatchId the esf match ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeBymatchId_PartecipantId(long esfPartecipantId,
		long esfMatchId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f match results where esfPartecipantId = &#63; and esfMatchId = &#63;.
	*
	* @param esfPartecipantId the esf partecipant ID
	* @param esfMatchId the esf match ID
	* @return the number of matching e s f match results
	* @throws SystemException if a system exception occurred
	*/
	public int countBymatchId_PartecipantId(long esfPartecipantId,
		long esfMatchId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the e s f match result in the entity cache if it is enabled.
	*
	* @param esfMatchResult the e s f match result
	*/
	public void cacheResult(it.ethica.esf.model.ESFMatchResult esfMatchResult);

	/**
	* Caches the e s f match results in the entity cache if it is enabled.
	*
	* @param esfMatchResults the e s f match results
	*/
	public void cacheResult(
		java.util.List<it.ethica.esf.model.ESFMatchResult> esfMatchResults);

	/**
	* Creates a new e s f match result with the primary key. Does not add the e s f match result to the database.
	*
	* @param esfMatchResultId the primary key for the new e s f match result
	* @return the new e s f match result
	*/
	public it.ethica.esf.model.ESFMatchResult create(long esfMatchResultId);

	/**
	* Removes the e s f match result with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfMatchResultId the primary key of the e s f match result
	* @return the e s f match result that was removed
	* @throws it.ethica.esf.NoSuchMatchResultException if a e s f match result with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFMatchResult remove(long esfMatchResultId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchMatchResultException;

	public it.ethica.esf.model.ESFMatchResult updateImpl(
		it.ethica.esf.model.ESFMatchResult esfMatchResult)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f match result with the primary key or throws a {@link it.ethica.esf.NoSuchMatchResultException} if it could not be found.
	*
	* @param esfMatchResultId the primary key of the e s f match result
	* @return the e s f match result
	* @throws it.ethica.esf.NoSuchMatchResultException if a e s f match result with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFMatchResult findByPrimaryKey(
		long esfMatchResultId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchMatchResultException;

	/**
	* Returns the e s f match result with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param esfMatchResultId the primary key of the e s f match result
	* @return the e s f match result, or <code>null</code> if a e s f match result with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFMatchResult fetchByPrimaryKey(
		long esfMatchResultId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f match results.
	*
	* @return the e s f match results
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFMatchResult> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.ethica.esf.model.ESFMatchResult> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f match results.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFMatchResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f match results
	* @param end the upper bound of the range of e s f match results (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of e s f match results
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFMatchResult> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the e s f match results from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f match results.
	*
	* @return the number of e s f match results
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}