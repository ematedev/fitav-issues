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

import it.ethica.esf.model.ESFResult;

/**
 * The persistence interface for the e s f result service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFResultPersistenceImpl
 * @see ESFResultUtil
 * @generated
 */
public interface ESFResultPersistence extends BasePersistence<ESFResult> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ESFResultUtil} to access the e s f result persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the e s f results where esfMatchId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @return the matching e s f results
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFResult> findByESFMatchId(
		long esfMatchId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f results where esfMatchId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfMatchId the esf match ID
	* @param start the lower bound of the range of e s f results
	* @param end the upper bound of the range of e s f results (not inclusive)
	* @return the range of matching e s f results
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFResult> findByESFMatchId(
		long esfMatchId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f results where esfMatchId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfMatchId the esf match ID
	* @param start the lower bound of the range of e s f results
	* @param end the upper bound of the range of e s f results (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f results
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFResult> findByESFMatchId(
		long esfMatchId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f result in the ordered set where esfMatchId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f result
	* @throws it.ethica.esf.NoSuchResultException if a matching e s f result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFResult findByESFMatchId_First(
		long esfMatchId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchResultException;

	/**
	* Returns the first e s f result in the ordered set where esfMatchId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f result, or <code>null</code> if a matching e s f result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFResult fetchByESFMatchId_First(
		long esfMatchId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f result in the ordered set where esfMatchId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f result
	* @throws it.ethica.esf.NoSuchResultException if a matching e s f result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFResult findByESFMatchId_Last(
		long esfMatchId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchResultException;

	/**
	* Returns the last e s f result in the ordered set where esfMatchId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f result, or <code>null</code> if a matching e s f result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFResult fetchByESFMatchId_Last(
		long esfMatchId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f results before and after the current e s f result in the ordered set where esfMatchId = &#63;.
	*
	* @param esfResultId the primary key of the current e s f result
	* @param esfMatchId the esf match ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f result
	* @throws it.ethica.esf.NoSuchResultException if a e s f result with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFResult[] findByESFMatchId_PrevAndNext(
		long esfResultId, long esfMatchId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchResultException;

	/**
	* Removes all the e s f results where esfMatchId = &#63; from the database.
	*
	* @param esfMatchId the esf match ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByESFMatchId(long esfMatchId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f results where esfMatchId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @return the number of matching e s f results
	* @throws SystemException if a system exception occurred
	*/
	public int countByESFMatchId(long esfMatchId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f results where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @return the matching e s f results
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFResult> findByESFShooterId(
		long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f results where esfUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfUserId the esf user ID
	* @param start the lower bound of the range of e s f results
	* @param end the upper bound of the range of e s f results (not inclusive)
	* @return the range of matching e s f results
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFResult> findByESFShooterId(
		long esfUserId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f results where esfUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfUserId the esf user ID
	* @param start the lower bound of the range of e s f results
	* @param end the upper bound of the range of e s f results (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f results
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFResult> findByESFShooterId(
		long esfUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f result in the ordered set where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f result
	* @throws it.ethica.esf.NoSuchResultException if a matching e s f result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFResult findByESFShooterId_First(
		long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchResultException;

	/**
	* Returns the first e s f result in the ordered set where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f result, or <code>null</code> if a matching e s f result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFResult fetchByESFShooterId_First(
		long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f result in the ordered set where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f result
	* @throws it.ethica.esf.NoSuchResultException if a matching e s f result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFResult findByESFShooterId_Last(
		long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchResultException;

	/**
	* Returns the last e s f result in the ordered set where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f result, or <code>null</code> if a matching e s f result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFResult fetchByESFShooterId_Last(
		long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f results before and after the current e s f result in the ordered set where esfUserId = &#63;.
	*
	* @param esfResultId the primary key of the current e s f result
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f result
	* @throws it.ethica.esf.NoSuchResultException if a e s f result with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFResult[] findByESFShooterId_PrevAndNext(
		long esfResultId, long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchResultException;

	/**
	* Removes all the e s f results where esfUserId = &#63; from the database.
	*
	* @param esfUserId the esf user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByESFShooterId(long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f results where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @return the number of matching e s f results
	* @throws SystemException if a system exception occurred
	*/
	public int countByESFShooterId(long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f results where esfMatchId = &#63; and esfUserId = &#63; and esfMatchTypeId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfUserId the esf user ID
	* @param esfMatchTypeId the esf match type ID
	* @return the matching e s f results
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFResult> findByESFMId_UId_STId(
		long esfMatchId, long esfUserId, long esfMatchTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f results where esfMatchId = &#63; and esfUserId = &#63; and esfMatchTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfMatchId the esf match ID
	* @param esfUserId the esf user ID
	* @param esfMatchTypeId the esf match type ID
	* @param start the lower bound of the range of e s f results
	* @param end the upper bound of the range of e s f results (not inclusive)
	* @return the range of matching e s f results
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFResult> findByESFMId_UId_STId(
		long esfMatchId, long esfUserId, long esfMatchTypeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f results where esfMatchId = &#63; and esfUserId = &#63; and esfMatchTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfMatchId the esf match ID
	* @param esfUserId the esf user ID
	* @param esfMatchTypeId the esf match type ID
	* @param start the lower bound of the range of e s f results
	* @param end the upper bound of the range of e s f results (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f results
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFResult> findByESFMId_UId_STId(
		long esfMatchId, long esfUserId, long esfMatchTypeId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f result in the ordered set where esfMatchId = &#63; and esfUserId = &#63; and esfMatchTypeId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfUserId the esf user ID
	* @param esfMatchTypeId the esf match type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f result
	* @throws it.ethica.esf.NoSuchResultException if a matching e s f result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFResult findByESFMId_UId_STId_First(
		long esfMatchId, long esfUserId, long esfMatchTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchResultException;

	/**
	* Returns the first e s f result in the ordered set where esfMatchId = &#63; and esfUserId = &#63; and esfMatchTypeId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfUserId the esf user ID
	* @param esfMatchTypeId the esf match type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f result, or <code>null</code> if a matching e s f result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFResult fetchByESFMId_UId_STId_First(
		long esfMatchId, long esfUserId, long esfMatchTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f result in the ordered set where esfMatchId = &#63; and esfUserId = &#63; and esfMatchTypeId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfUserId the esf user ID
	* @param esfMatchTypeId the esf match type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f result
	* @throws it.ethica.esf.NoSuchResultException if a matching e s f result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFResult findByESFMId_UId_STId_Last(
		long esfMatchId, long esfUserId, long esfMatchTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchResultException;

	/**
	* Returns the last e s f result in the ordered set where esfMatchId = &#63; and esfUserId = &#63; and esfMatchTypeId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfUserId the esf user ID
	* @param esfMatchTypeId the esf match type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f result, or <code>null</code> if a matching e s f result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFResult fetchByESFMId_UId_STId_Last(
		long esfMatchId, long esfUserId, long esfMatchTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f results before and after the current e s f result in the ordered set where esfMatchId = &#63; and esfUserId = &#63; and esfMatchTypeId = &#63;.
	*
	* @param esfResultId the primary key of the current e s f result
	* @param esfMatchId the esf match ID
	* @param esfUserId the esf user ID
	* @param esfMatchTypeId the esf match type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f result
	* @throws it.ethica.esf.NoSuchResultException if a e s f result with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFResult[] findByESFMId_UId_STId_PrevAndNext(
		long esfResultId, long esfMatchId, long esfUserId, long esfMatchTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchResultException;

	/**
	* Removes all the e s f results where esfMatchId = &#63; and esfUserId = &#63; and esfMatchTypeId = &#63; from the database.
	*
	* @param esfMatchId the esf match ID
	* @param esfUserId the esf user ID
	* @param esfMatchTypeId the esf match type ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByESFMId_UId_STId(long esfMatchId, long esfUserId,
		long esfMatchTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f results where esfMatchId = &#63; and esfUserId = &#63; and esfMatchTypeId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfUserId the esf user ID
	* @param esfMatchTypeId the esf match type ID
	* @return the number of matching e s f results
	* @throws SystemException if a system exception occurred
	*/
	public int countByESFMId_UId_STId(long esfMatchId, long esfUserId,
		long esfMatchTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f results where esfMatchId = &#63; and esfUserId = &#63; and esfMatchTypeId = &#63; and resultClassTeam = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfUserId the esf user ID
	* @param esfMatchTypeId the esf match type ID
	* @param resultClassTeam the result class team
	* @return the matching e s f results
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFResult> findByESFMId_UId_STId_Single(
		long esfMatchId, long esfUserId, long esfMatchTypeId,
		int resultClassTeam)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f results where esfMatchId = &#63; and esfUserId = &#63; and esfMatchTypeId = &#63; and resultClassTeam = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfMatchId the esf match ID
	* @param esfUserId the esf user ID
	* @param esfMatchTypeId the esf match type ID
	* @param resultClassTeam the result class team
	* @param start the lower bound of the range of e s f results
	* @param end the upper bound of the range of e s f results (not inclusive)
	* @return the range of matching e s f results
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFResult> findByESFMId_UId_STId_Single(
		long esfMatchId, long esfUserId, long esfMatchTypeId,
		int resultClassTeam, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f results where esfMatchId = &#63; and esfUserId = &#63; and esfMatchTypeId = &#63; and resultClassTeam = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfMatchId the esf match ID
	* @param esfUserId the esf user ID
	* @param esfMatchTypeId the esf match type ID
	* @param resultClassTeam the result class team
	* @param start the lower bound of the range of e s f results
	* @param end the upper bound of the range of e s f results (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f results
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFResult> findByESFMId_UId_STId_Single(
		long esfMatchId, long esfUserId, long esfMatchTypeId,
		int resultClassTeam, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f result in the ordered set where esfMatchId = &#63; and esfUserId = &#63; and esfMatchTypeId = &#63; and resultClassTeam = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfUserId the esf user ID
	* @param esfMatchTypeId the esf match type ID
	* @param resultClassTeam the result class team
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f result
	* @throws it.ethica.esf.NoSuchResultException if a matching e s f result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFResult findByESFMId_UId_STId_Single_First(
		long esfMatchId, long esfUserId, long esfMatchTypeId,
		int resultClassTeam,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchResultException;

	/**
	* Returns the first e s f result in the ordered set where esfMatchId = &#63; and esfUserId = &#63; and esfMatchTypeId = &#63; and resultClassTeam = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfUserId the esf user ID
	* @param esfMatchTypeId the esf match type ID
	* @param resultClassTeam the result class team
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f result, or <code>null</code> if a matching e s f result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFResult fetchByESFMId_UId_STId_Single_First(
		long esfMatchId, long esfUserId, long esfMatchTypeId,
		int resultClassTeam,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f result in the ordered set where esfMatchId = &#63; and esfUserId = &#63; and esfMatchTypeId = &#63; and resultClassTeam = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfUserId the esf user ID
	* @param esfMatchTypeId the esf match type ID
	* @param resultClassTeam the result class team
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f result
	* @throws it.ethica.esf.NoSuchResultException if a matching e s f result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFResult findByESFMId_UId_STId_Single_Last(
		long esfMatchId, long esfUserId, long esfMatchTypeId,
		int resultClassTeam,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchResultException;

	/**
	* Returns the last e s f result in the ordered set where esfMatchId = &#63; and esfUserId = &#63; and esfMatchTypeId = &#63; and resultClassTeam = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfUserId the esf user ID
	* @param esfMatchTypeId the esf match type ID
	* @param resultClassTeam the result class team
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f result, or <code>null</code> if a matching e s f result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFResult fetchByESFMId_UId_STId_Single_Last(
		long esfMatchId, long esfUserId, long esfMatchTypeId,
		int resultClassTeam,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f results before and after the current e s f result in the ordered set where esfMatchId = &#63; and esfUserId = &#63; and esfMatchTypeId = &#63; and resultClassTeam = &#63;.
	*
	* @param esfResultId the primary key of the current e s f result
	* @param esfMatchId the esf match ID
	* @param esfUserId the esf user ID
	* @param esfMatchTypeId the esf match type ID
	* @param resultClassTeam the result class team
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f result
	* @throws it.ethica.esf.NoSuchResultException if a e s f result with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFResult[] findByESFMId_UId_STId_Single_PrevAndNext(
		long esfResultId, long esfMatchId, long esfUserId, long esfMatchTypeId,
		int resultClassTeam,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchResultException;

	/**
	* Removes all the e s f results where esfMatchId = &#63; and esfUserId = &#63; and esfMatchTypeId = &#63; and resultClassTeam = &#63; from the database.
	*
	* @param esfMatchId the esf match ID
	* @param esfUserId the esf user ID
	* @param esfMatchTypeId the esf match type ID
	* @param resultClassTeam the result class team
	* @throws SystemException if a system exception occurred
	*/
	public void removeByESFMId_UId_STId_Single(long esfMatchId, long esfUserId,
		long esfMatchTypeId, int resultClassTeam)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f results where esfMatchId = &#63; and esfUserId = &#63; and esfMatchTypeId = &#63; and resultClassTeam = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfUserId the esf user ID
	* @param esfMatchTypeId the esf match type ID
	* @param resultClassTeam the result class team
	* @return the number of matching e s f results
	* @throws SystemException if a system exception occurred
	*/
	public int countByESFMId_UId_STId_Single(long esfMatchId, long esfUserId,
		long esfMatchTypeId, int resultClassTeam)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f results where esfMatchId = &#63; and esfMatchTypeId = &#63; and shooterQualification = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfMatchTypeId the esf match type ID
	* @param shooterQualification the shooter qualification
	* @return the matching e s f results
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFResult> findByESFMId_STId_SQId(
		long esfMatchId, long esfMatchTypeId, long shooterQualification)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f results where esfMatchId = &#63; and esfMatchTypeId = &#63; and shooterQualification = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfMatchId the esf match ID
	* @param esfMatchTypeId the esf match type ID
	* @param shooterQualification the shooter qualification
	* @param start the lower bound of the range of e s f results
	* @param end the upper bound of the range of e s f results (not inclusive)
	* @return the range of matching e s f results
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFResult> findByESFMId_STId_SQId(
		long esfMatchId, long esfMatchTypeId, long shooterQualification,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f results where esfMatchId = &#63; and esfMatchTypeId = &#63; and shooterQualification = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfMatchId the esf match ID
	* @param esfMatchTypeId the esf match type ID
	* @param shooterQualification the shooter qualification
	* @param start the lower bound of the range of e s f results
	* @param end the upper bound of the range of e s f results (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f results
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFResult> findByESFMId_STId_SQId(
		long esfMatchId, long esfMatchTypeId, long shooterQualification,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f result in the ordered set where esfMatchId = &#63; and esfMatchTypeId = &#63; and shooterQualification = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfMatchTypeId the esf match type ID
	* @param shooterQualification the shooter qualification
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f result
	* @throws it.ethica.esf.NoSuchResultException if a matching e s f result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFResult findByESFMId_STId_SQId_First(
		long esfMatchId, long esfMatchTypeId, long shooterQualification,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchResultException;

	/**
	* Returns the first e s f result in the ordered set where esfMatchId = &#63; and esfMatchTypeId = &#63; and shooterQualification = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfMatchTypeId the esf match type ID
	* @param shooterQualification the shooter qualification
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f result, or <code>null</code> if a matching e s f result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFResult fetchByESFMId_STId_SQId_First(
		long esfMatchId, long esfMatchTypeId, long shooterQualification,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f result in the ordered set where esfMatchId = &#63; and esfMatchTypeId = &#63; and shooterQualification = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfMatchTypeId the esf match type ID
	* @param shooterQualification the shooter qualification
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f result
	* @throws it.ethica.esf.NoSuchResultException if a matching e s f result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFResult findByESFMId_STId_SQId_Last(
		long esfMatchId, long esfMatchTypeId, long shooterQualification,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchResultException;

	/**
	* Returns the last e s f result in the ordered set where esfMatchId = &#63; and esfMatchTypeId = &#63; and shooterQualification = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfMatchTypeId the esf match type ID
	* @param shooterQualification the shooter qualification
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f result, or <code>null</code> if a matching e s f result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFResult fetchByESFMId_STId_SQId_Last(
		long esfMatchId, long esfMatchTypeId, long shooterQualification,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f results before and after the current e s f result in the ordered set where esfMatchId = &#63; and esfMatchTypeId = &#63; and shooterQualification = &#63;.
	*
	* @param esfResultId the primary key of the current e s f result
	* @param esfMatchId the esf match ID
	* @param esfMatchTypeId the esf match type ID
	* @param shooterQualification the shooter qualification
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f result
	* @throws it.ethica.esf.NoSuchResultException if a e s f result with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFResult[] findByESFMId_STId_SQId_PrevAndNext(
		long esfResultId, long esfMatchId, long esfMatchTypeId,
		long shooterQualification,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchResultException;

	/**
	* Removes all the e s f results where esfMatchId = &#63; and esfMatchTypeId = &#63; and shooterQualification = &#63; from the database.
	*
	* @param esfMatchId the esf match ID
	* @param esfMatchTypeId the esf match type ID
	* @param shooterQualification the shooter qualification
	* @throws SystemException if a system exception occurred
	*/
	public void removeByESFMId_STId_SQId(long esfMatchId, long esfMatchTypeId,
		long shooterQualification)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f results where esfMatchId = &#63; and esfMatchTypeId = &#63; and shooterQualification = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfMatchTypeId the esf match type ID
	* @param shooterQualification the shooter qualification
	* @return the number of matching e s f results
	* @throws SystemException if a system exception occurred
	*/
	public int countByESFMId_STId_SQId(long esfMatchId, long esfMatchTypeId,
		long shooterQualification)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f results where esfMatchId = &#63; and esfMatchTypeId = &#63; and shooterQualification = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfMatchTypeId the esf match type ID
	* @param shooterQualification the shooter qualification
	* @return the matching e s f results
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFResult> findByESFMId_STId_SQId_ResultClassTeam(
		long esfMatchId, long esfMatchTypeId, long shooterQualification)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f results where esfMatchId = &#63; and esfMatchTypeId = &#63; and shooterQualification = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfMatchId the esf match ID
	* @param esfMatchTypeId the esf match type ID
	* @param shooterQualification the shooter qualification
	* @param start the lower bound of the range of e s f results
	* @param end the upper bound of the range of e s f results (not inclusive)
	* @return the range of matching e s f results
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFResult> findByESFMId_STId_SQId_ResultClassTeam(
		long esfMatchId, long esfMatchTypeId, long shooterQualification,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f results where esfMatchId = &#63; and esfMatchTypeId = &#63; and shooterQualification = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfMatchId the esf match ID
	* @param esfMatchTypeId the esf match type ID
	* @param shooterQualification the shooter qualification
	* @param start the lower bound of the range of e s f results
	* @param end the upper bound of the range of e s f results (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f results
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFResult> findByESFMId_STId_SQId_ResultClassTeam(
		long esfMatchId, long esfMatchTypeId, long shooterQualification,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f result in the ordered set where esfMatchId = &#63; and esfMatchTypeId = &#63; and shooterQualification = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfMatchTypeId the esf match type ID
	* @param shooterQualification the shooter qualification
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f result
	* @throws it.ethica.esf.NoSuchResultException if a matching e s f result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFResult findByESFMId_STId_SQId_ResultClassTeam_First(
		long esfMatchId, long esfMatchTypeId, long shooterQualification,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchResultException;

	/**
	* Returns the first e s f result in the ordered set where esfMatchId = &#63; and esfMatchTypeId = &#63; and shooterQualification = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfMatchTypeId the esf match type ID
	* @param shooterQualification the shooter qualification
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f result, or <code>null</code> if a matching e s f result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFResult fetchByESFMId_STId_SQId_ResultClassTeam_First(
		long esfMatchId, long esfMatchTypeId, long shooterQualification,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f result in the ordered set where esfMatchId = &#63; and esfMatchTypeId = &#63; and shooterQualification = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfMatchTypeId the esf match type ID
	* @param shooterQualification the shooter qualification
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f result
	* @throws it.ethica.esf.NoSuchResultException if a matching e s f result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFResult findByESFMId_STId_SQId_ResultClassTeam_Last(
		long esfMatchId, long esfMatchTypeId, long shooterQualification,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchResultException;

	/**
	* Returns the last e s f result in the ordered set where esfMatchId = &#63; and esfMatchTypeId = &#63; and shooterQualification = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfMatchTypeId the esf match type ID
	* @param shooterQualification the shooter qualification
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f result, or <code>null</code> if a matching e s f result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFResult fetchByESFMId_STId_SQId_ResultClassTeam_Last(
		long esfMatchId, long esfMatchTypeId, long shooterQualification,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f results before and after the current e s f result in the ordered set where esfMatchId = &#63; and esfMatchTypeId = &#63; and shooterQualification = &#63;.
	*
	* @param esfResultId the primary key of the current e s f result
	* @param esfMatchId the esf match ID
	* @param esfMatchTypeId the esf match type ID
	* @param shooterQualification the shooter qualification
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f result
	* @throws it.ethica.esf.NoSuchResultException if a e s f result with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFResult[] findByESFMId_STId_SQId_ResultClassTeam_PrevAndNext(
		long esfResultId, long esfMatchId, long esfMatchTypeId,
		long shooterQualification,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchResultException;

	/**
	* Removes all the e s f results where esfMatchId = &#63; and esfMatchTypeId = &#63; and shooterQualification = &#63; from the database.
	*
	* @param esfMatchId the esf match ID
	* @param esfMatchTypeId the esf match type ID
	* @param shooterQualification the shooter qualification
	* @throws SystemException if a system exception occurred
	*/
	public void removeByESFMId_STId_SQId_ResultClassTeam(long esfMatchId,
		long esfMatchTypeId, long shooterQualification)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f results where esfMatchId = &#63; and esfMatchTypeId = &#63; and shooterQualification = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfMatchTypeId the esf match type ID
	* @param shooterQualification the shooter qualification
	* @return the number of matching e s f results
	* @throws SystemException if a system exception occurred
	*/
	public int countByESFMId_STId_SQId_ResultClassTeam(long esfMatchId,
		long esfMatchTypeId, long shooterQualification)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f results where esfMatchId = &#63; and esfMatchTypeId = &#63; and shooterQualification = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfMatchTypeId the esf match type ID
	* @param shooterQualification the shooter qualification
	* @return the matching e s f results
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFResult> findByESFMId_STId_SQId_Single(
		long esfMatchId, long esfMatchTypeId, long shooterQualification)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f results where esfMatchId = &#63; and esfMatchTypeId = &#63; and shooterQualification = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfMatchId the esf match ID
	* @param esfMatchTypeId the esf match type ID
	* @param shooterQualification the shooter qualification
	* @param start the lower bound of the range of e s f results
	* @param end the upper bound of the range of e s f results (not inclusive)
	* @return the range of matching e s f results
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFResult> findByESFMId_STId_SQId_Single(
		long esfMatchId, long esfMatchTypeId, long shooterQualification,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f results where esfMatchId = &#63; and esfMatchTypeId = &#63; and shooterQualification = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfMatchId the esf match ID
	* @param esfMatchTypeId the esf match type ID
	* @param shooterQualification the shooter qualification
	* @param start the lower bound of the range of e s f results
	* @param end the upper bound of the range of e s f results (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f results
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFResult> findByESFMId_STId_SQId_Single(
		long esfMatchId, long esfMatchTypeId, long shooterQualification,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f result in the ordered set where esfMatchId = &#63; and esfMatchTypeId = &#63; and shooterQualification = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfMatchTypeId the esf match type ID
	* @param shooterQualification the shooter qualification
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f result
	* @throws it.ethica.esf.NoSuchResultException if a matching e s f result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFResult findByESFMId_STId_SQId_Single_First(
		long esfMatchId, long esfMatchTypeId, long shooterQualification,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchResultException;

	/**
	* Returns the first e s f result in the ordered set where esfMatchId = &#63; and esfMatchTypeId = &#63; and shooterQualification = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfMatchTypeId the esf match type ID
	* @param shooterQualification the shooter qualification
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f result, or <code>null</code> if a matching e s f result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFResult fetchByESFMId_STId_SQId_Single_First(
		long esfMatchId, long esfMatchTypeId, long shooterQualification,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f result in the ordered set where esfMatchId = &#63; and esfMatchTypeId = &#63; and shooterQualification = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfMatchTypeId the esf match type ID
	* @param shooterQualification the shooter qualification
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f result
	* @throws it.ethica.esf.NoSuchResultException if a matching e s f result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFResult findByESFMId_STId_SQId_Single_Last(
		long esfMatchId, long esfMatchTypeId, long shooterQualification,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchResultException;

	/**
	* Returns the last e s f result in the ordered set where esfMatchId = &#63; and esfMatchTypeId = &#63; and shooterQualification = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfMatchTypeId the esf match type ID
	* @param shooterQualification the shooter qualification
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f result, or <code>null</code> if a matching e s f result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFResult fetchByESFMId_STId_SQId_Single_Last(
		long esfMatchId, long esfMatchTypeId, long shooterQualification,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f results before and after the current e s f result in the ordered set where esfMatchId = &#63; and esfMatchTypeId = &#63; and shooterQualification = &#63;.
	*
	* @param esfResultId the primary key of the current e s f result
	* @param esfMatchId the esf match ID
	* @param esfMatchTypeId the esf match type ID
	* @param shooterQualification the shooter qualification
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f result
	* @throws it.ethica.esf.NoSuchResultException if a e s f result with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFResult[] findByESFMId_STId_SQId_Single_PrevAndNext(
		long esfResultId, long esfMatchId, long esfMatchTypeId,
		long shooterQualification,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchResultException;

	/**
	* Removes all the e s f results where esfMatchId = &#63; and esfMatchTypeId = &#63; and shooterQualification = &#63; from the database.
	*
	* @param esfMatchId the esf match ID
	* @param esfMatchTypeId the esf match type ID
	* @param shooterQualification the shooter qualification
	* @throws SystemException if a system exception occurred
	*/
	public void removeByESFMId_STId_SQId_Single(long esfMatchId,
		long esfMatchTypeId, long shooterQualification)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f results where esfMatchId = &#63; and esfMatchTypeId = &#63; and shooterQualification = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfMatchTypeId the esf match type ID
	* @param shooterQualification the shooter qualification
	* @return the number of matching e s f results
	* @throws SystemException if a system exception occurred
	*/
	public int countByESFMId_STId_SQId_Single(long esfMatchId,
		long esfMatchTypeId, long shooterQualification)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the e s f result in the entity cache if it is enabled.
	*
	* @param esfResult the e s f result
	*/
	public void cacheResult(it.ethica.esf.model.ESFResult esfResult);

	/**
	* Caches the e s f results in the entity cache if it is enabled.
	*
	* @param esfResults the e s f results
	*/
	public void cacheResult(
		java.util.List<it.ethica.esf.model.ESFResult> esfResults);

	/**
	* Creates a new e s f result with the primary key. Does not add the e s f result to the database.
	*
	* @param esfResultId the primary key for the new e s f result
	* @return the new e s f result
	*/
	public it.ethica.esf.model.ESFResult create(long esfResultId);

	/**
	* Removes the e s f result with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfResultId the primary key of the e s f result
	* @return the e s f result that was removed
	* @throws it.ethica.esf.NoSuchResultException if a e s f result with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFResult remove(long esfResultId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchResultException;

	public it.ethica.esf.model.ESFResult updateImpl(
		it.ethica.esf.model.ESFResult esfResult)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f result with the primary key or throws a {@link it.ethica.esf.NoSuchResultException} if it could not be found.
	*
	* @param esfResultId the primary key of the e s f result
	* @return the e s f result
	* @throws it.ethica.esf.NoSuchResultException if a e s f result with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFResult findByPrimaryKey(long esfResultId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchResultException;

	/**
	* Returns the e s f result with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param esfResultId the primary key of the e s f result
	* @return the e s f result, or <code>null</code> if a e s f result with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFResult fetchByPrimaryKey(long esfResultId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f results.
	*
	* @return the e s f results
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFResult> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f results.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f results
	* @param end the upper bound of the range of e s f results (not inclusive)
	* @return the range of e s f results
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFResult> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f results.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f results
	* @param end the upper bound of the range of e s f results (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of e s f results
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFResult> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the e s f results from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f results.
	*
	* @return the number of e s f results
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}