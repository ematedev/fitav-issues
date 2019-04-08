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

import it.ethica.esf.model.ESFMatch;

/**
 * The persistence interface for the e s f match service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFMatchPersistenceImpl
 * @see ESFMatchUtil
 * @generated
 */
public interface ESFMatchPersistence extends BasePersistence<ESFMatch> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ESFMatchUtil} to access the e s f match persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the e s f matchs where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching e s f matchs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFMatch> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f matchs where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFMatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of e s f matchs
	* @param end the upper bound of the range of e s f matchs (not inclusive)
	* @return the range of matching e s f matchs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFMatch> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f matchs where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFMatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of e s f matchs
	* @param end the upper bound of the range of e s f matchs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f matchs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFMatch> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f match in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f match
	* @throws it.ethica.esf.NoSuchMatchException if a matching e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFMatch findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchMatchException;

	/**
	* Returns the first e s f match in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f match, or <code>null</code> if a matching e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFMatch fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f match in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f match
	* @throws it.ethica.esf.NoSuchMatchException if a matching e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFMatch findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchMatchException;

	/**
	* Returns the last e s f match in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f match, or <code>null</code> if a matching e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFMatch fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f matchs before and after the current e s f match in the ordered set where uuid = &#63;.
	*
	* @param esfMatchId the primary key of the current e s f match
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f match
	* @throws it.ethica.esf.NoSuchMatchException if a e s f match with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFMatch[] findByUuid_PrevAndNext(
		long esfMatchId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchMatchException;

	/**
	* Removes all the e s f matchs where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f matchs where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching e s f matchs
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f match where uuid = &#63; and groupId = &#63; or throws a {@link it.ethica.esf.NoSuchMatchException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching e s f match
	* @throws it.ethica.esf.NoSuchMatchException if a matching e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFMatch findByUUID_G(java.lang.String uuid,
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchMatchException;

	/**
	* Returns the e s f match where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching e s f match, or <code>null</code> if a matching e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFMatch fetchByUUID_G(java.lang.String uuid,
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f match where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching e s f match, or <code>null</code> if a matching e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFMatch fetchByUUID_G(java.lang.String uuid,
		long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the e s f match where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the e s f match that was removed
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFMatch removeByUUID_G(java.lang.String uuid,
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchMatchException;

	/**
	* Returns the number of e s f matchs where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching e s f matchs
	* @throws SystemException if a system exception occurred
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f matchs where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching e s f matchs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFMatch> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f matchs where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFMatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of e s f matchs
	* @param end the upper bound of the range of e s f matchs (not inclusive)
	* @return the range of matching e s f matchs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFMatch> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f matchs where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFMatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of e s f matchs
	* @param end the upper bound of the range of e s f matchs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f matchs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFMatch> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f match in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f match
	* @throws it.ethica.esf.NoSuchMatchException if a matching e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFMatch findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchMatchException;

	/**
	* Returns the first e s f match in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f match, or <code>null</code> if a matching e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFMatch fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f match in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f match
	* @throws it.ethica.esf.NoSuchMatchException if a matching e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFMatch findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchMatchException;

	/**
	* Returns the last e s f match in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f match, or <code>null</code> if a matching e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFMatch fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f matchs before and after the current e s f match in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param esfMatchId the primary key of the current e s f match
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f match
	* @throws it.ethica.esf.NoSuchMatchException if a e s f match with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFMatch[] findByUuid_C_PrevAndNext(
		long esfMatchId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchMatchException;

	/**
	* Removes all the e s f matchs where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f matchs where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching e s f matchs
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f matchs where esfMatchTypeId = &#63;.
	*
	* @param esfMatchTypeId the esf match type ID
	* @return the matching e s f matchs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFMatch> findByMatchTypeId(
		long esfMatchTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f matchs where esfMatchTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFMatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfMatchTypeId the esf match type ID
	* @param start the lower bound of the range of e s f matchs
	* @param end the upper bound of the range of e s f matchs (not inclusive)
	* @return the range of matching e s f matchs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFMatch> findByMatchTypeId(
		long esfMatchTypeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f matchs where esfMatchTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFMatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfMatchTypeId the esf match type ID
	* @param start the lower bound of the range of e s f matchs
	* @param end the upper bound of the range of e s f matchs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f matchs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFMatch> findByMatchTypeId(
		long esfMatchTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f match in the ordered set where esfMatchTypeId = &#63;.
	*
	* @param esfMatchTypeId the esf match type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f match
	* @throws it.ethica.esf.NoSuchMatchException if a matching e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFMatch findByMatchTypeId_First(
		long esfMatchTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchMatchException;

	/**
	* Returns the first e s f match in the ordered set where esfMatchTypeId = &#63;.
	*
	* @param esfMatchTypeId the esf match type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f match, or <code>null</code> if a matching e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFMatch fetchByMatchTypeId_First(
		long esfMatchTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f match in the ordered set where esfMatchTypeId = &#63;.
	*
	* @param esfMatchTypeId the esf match type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f match
	* @throws it.ethica.esf.NoSuchMatchException if a matching e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFMatch findByMatchTypeId_Last(
		long esfMatchTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchMatchException;

	/**
	* Returns the last e s f match in the ordered set where esfMatchTypeId = &#63;.
	*
	* @param esfMatchTypeId the esf match type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f match, or <code>null</code> if a matching e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFMatch fetchByMatchTypeId_Last(
		long esfMatchTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f matchs before and after the current e s f match in the ordered set where esfMatchTypeId = &#63;.
	*
	* @param esfMatchId the primary key of the current e s f match
	* @param esfMatchTypeId the esf match type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f match
	* @throws it.ethica.esf.NoSuchMatchException if a e s f match with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFMatch[] findByMatchTypeId_PrevAndNext(
		long esfMatchId, long esfMatchTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchMatchException;

	/**
	* Removes all the e s f matchs where esfMatchTypeId = &#63; from the database.
	*
	* @param esfMatchTypeId the esf match type ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByMatchTypeId(long esfMatchTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f matchs where esfMatchTypeId = &#63;.
	*
	* @param esfMatchTypeId the esf match type ID
	* @return the number of matching e s f matchs
	* @throws SystemException if a system exception occurred
	*/
	public int countByMatchTypeId(long esfMatchTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f match where startDate = &#63; and esfMatchTypeId = &#63; and esfAssociationId = &#63; and description = &#63; and isNational = &#63; or throws a {@link it.ethica.esf.NoSuchMatchException} if it could not be found.
	*
	* @param startDate the start date
	* @param esfMatchTypeId the esf match type ID
	* @param esfAssociationId the esf association ID
	* @param description the description
	* @param isNational the is national
	* @return the matching e s f match
	* @throws it.ethica.esf.NoSuchMatchException if a matching e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFMatch findByMatchStartDate_T_A_D_N(
		java.util.Date startDate, long esfMatchTypeId, long esfAssociationId,
		long description, boolean isNational)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchMatchException;

	/**
	* Returns the e s f match where startDate = &#63; and esfMatchTypeId = &#63; and esfAssociationId = &#63; and description = &#63; and isNational = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param startDate the start date
	* @param esfMatchTypeId the esf match type ID
	* @param esfAssociationId the esf association ID
	* @param description the description
	* @param isNational the is national
	* @return the matching e s f match, or <code>null</code> if a matching e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFMatch fetchByMatchStartDate_T_A_D_N(
		java.util.Date startDate, long esfMatchTypeId, long esfAssociationId,
		long description, boolean isNational)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f match where startDate = &#63; and esfMatchTypeId = &#63; and esfAssociationId = &#63; and description = &#63; and isNational = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param startDate the start date
	* @param esfMatchTypeId the esf match type ID
	* @param esfAssociationId the esf association ID
	* @param description the description
	* @param isNational the is national
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching e s f match, or <code>null</code> if a matching e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFMatch fetchByMatchStartDate_T_A_D_N(
		java.util.Date startDate, long esfMatchTypeId, long esfAssociationId,
		long description, boolean isNational, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the e s f match where startDate = &#63; and esfMatchTypeId = &#63; and esfAssociationId = &#63; and description = &#63; and isNational = &#63; from the database.
	*
	* @param startDate the start date
	* @param esfMatchTypeId the esf match type ID
	* @param esfAssociationId the esf association ID
	* @param description the description
	* @param isNational the is national
	* @return the e s f match that was removed
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFMatch removeByMatchStartDate_T_A_D_N(
		java.util.Date startDate, long esfMatchTypeId, long esfAssociationId,
		long description, boolean isNational)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchMatchException;

	/**
	* Returns the number of e s f matchs where startDate = &#63; and esfMatchTypeId = &#63; and esfAssociationId = &#63; and description = &#63; and isNational = &#63;.
	*
	* @param startDate the start date
	* @param esfMatchTypeId the esf match type ID
	* @param esfAssociationId the esf association ID
	* @param description the description
	* @param isNational the is national
	* @return the number of matching e s f matchs
	* @throws SystemException if a system exception occurred
	*/
	public int countByMatchStartDate_T_A_D_N(java.util.Date startDate,
		long esfMatchTypeId, long esfAssociationId, long description,
		boolean isNational)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f matchs where userId = &#63; and isNational = &#63;.
	*
	* @param userId the user ID
	* @param isNational the is national
	* @return the matching e s f matchs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFMatch> findByUserId_IsNat(
		long userId, boolean isNational)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f matchs where userId = &#63; and isNational = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFMatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param isNational the is national
	* @param start the lower bound of the range of e s f matchs
	* @param end the upper bound of the range of e s f matchs (not inclusive)
	* @return the range of matching e s f matchs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFMatch> findByUserId_IsNat(
		long userId, boolean isNational, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f matchs where userId = &#63; and isNational = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFMatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param isNational the is national
	* @param start the lower bound of the range of e s f matchs
	* @param end the upper bound of the range of e s f matchs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f matchs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFMatch> findByUserId_IsNat(
		long userId, boolean isNational, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f match in the ordered set where userId = &#63; and isNational = &#63;.
	*
	* @param userId the user ID
	* @param isNational the is national
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f match
	* @throws it.ethica.esf.NoSuchMatchException if a matching e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFMatch findByUserId_IsNat_First(long userId,
		boolean isNational,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchMatchException;

	/**
	* Returns the first e s f match in the ordered set where userId = &#63; and isNational = &#63;.
	*
	* @param userId the user ID
	* @param isNational the is national
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f match, or <code>null</code> if a matching e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFMatch fetchByUserId_IsNat_First(long userId,
		boolean isNational,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f match in the ordered set where userId = &#63; and isNational = &#63;.
	*
	* @param userId the user ID
	* @param isNational the is national
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f match
	* @throws it.ethica.esf.NoSuchMatchException if a matching e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFMatch findByUserId_IsNat_Last(long userId,
		boolean isNational,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchMatchException;

	/**
	* Returns the last e s f match in the ordered set where userId = &#63; and isNational = &#63;.
	*
	* @param userId the user ID
	* @param isNational the is national
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f match, or <code>null</code> if a matching e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFMatch fetchByUserId_IsNat_Last(long userId,
		boolean isNational,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f matchs before and after the current e s f match in the ordered set where userId = &#63; and isNational = &#63;.
	*
	* @param esfMatchId the primary key of the current e s f match
	* @param userId the user ID
	* @param isNational the is national
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f match
	* @throws it.ethica.esf.NoSuchMatchException if a e s f match with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFMatch[] findByUserId_IsNat_PrevAndNext(
		long esfMatchId, long userId, boolean isNational,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchMatchException;

	/**
	* Removes all the e s f matchs where userId = &#63; and isNational = &#63; from the database.
	*
	* @param userId the user ID
	* @param isNational the is national
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUserId_IsNat(long userId, boolean isNational)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f matchs where userId = &#63; and isNational = &#63;.
	*
	* @param userId the user ID
	* @param isNational the is national
	* @return the number of matching e s f matchs
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserId_IsNat(long userId, boolean isNational)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f matchs where userId = &#63; and isNational = &#63; and esfAssociationId = &#63; and startDate = &#63; and description = &#63; and esfSportTypeId = &#63;.
	*
	* @param userId the user ID
	* @param isNational the is national
	* @param esfAssociationId the esf association ID
	* @param startDate the start date
	* @param description the description
	* @param esfSportTypeId the esf sport type ID
	* @return the matching e s f matchs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFMatch> findBymyMatch(
		long userId, boolean isNational, long esfAssociationId,
		java.util.Date startDate, long description, long esfSportTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f matchs where userId = &#63; and isNational = &#63; and esfAssociationId = &#63; and startDate = &#63; and description = &#63; and esfSportTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFMatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param isNational the is national
	* @param esfAssociationId the esf association ID
	* @param startDate the start date
	* @param description the description
	* @param esfSportTypeId the esf sport type ID
	* @param start the lower bound of the range of e s f matchs
	* @param end the upper bound of the range of e s f matchs (not inclusive)
	* @return the range of matching e s f matchs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFMatch> findBymyMatch(
		long userId, boolean isNational, long esfAssociationId,
		java.util.Date startDate, long description, long esfSportTypeId,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f matchs where userId = &#63; and isNational = &#63; and esfAssociationId = &#63; and startDate = &#63; and description = &#63; and esfSportTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFMatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param isNational the is national
	* @param esfAssociationId the esf association ID
	* @param startDate the start date
	* @param description the description
	* @param esfSportTypeId the esf sport type ID
	* @param start the lower bound of the range of e s f matchs
	* @param end the upper bound of the range of e s f matchs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f matchs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFMatch> findBymyMatch(
		long userId, boolean isNational, long esfAssociationId,
		java.util.Date startDate, long description, long esfSportTypeId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f match in the ordered set where userId = &#63; and isNational = &#63; and esfAssociationId = &#63; and startDate = &#63; and description = &#63; and esfSportTypeId = &#63;.
	*
	* @param userId the user ID
	* @param isNational the is national
	* @param esfAssociationId the esf association ID
	* @param startDate the start date
	* @param description the description
	* @param esfSportTypeId the esf sport type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f match
	* @throws it.ethica.esf.NoSuchMatchException if a matching e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFMatch findBymyMatch_First(long userId,
		boolean isNational, long esfAssociationId, java.util.Date startDate,
		long description, long esfSportTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchMatchException;

	/**
	* Returns the first e s f match in the ordered set where userId = &#63; and isNational = &#63; and esfAssociationId = &#63; and startDate = &#63; and description = &#63; and esfSportTypeId = &#63;.
	*
	* @param userId the user ID
	* @param isNational the is national
	* @param esfAssociationId the esf association ID
	* @param startDate the start date
	* @param description the description
	* @param esfSportTypeId the esf sport type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f match, or <code>null</code> if a matching e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFMatch fetchBymyMatch_First(long userId,
		boolean isNational, long esfAssociationId, java.util.Date startDate,
		long description, long esfSportTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f match in the ordered set where userId = &#63; and isNational = &#63; and esfAssociationId = &#63; and startDate = &#63; and description = &#63; and esfSportTypeId = &#63;.
	*
	* @param userId the user ID
	* @param isNational the is national
	* @param esfAssociationId the esf association ID
	* @param startDate the start date
	* @param description the description
	* @param esfSportTypeId the esf sport type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f match
	* @throws it.ethica.esf.NoSuchMatchException if a matching e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFMatch findBymyMatch_Last(long userId,
		boolean isNational, long esfAssociationId, java.util.Date startDate,
		long description, long esfSportTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchMatchException;

	/**
	* Returns the last e s f match in the ordered set where userId = &#63; and isNational = &#63; and esfAssociationId = &#63; and startDate = &#63; and description = &#63; and esfSportTypeId = &#63;.
	*
	* @param userId the user ID
	* @param isNational the is national
	* @param esfAssociationId the esf association ID
	* @param startDate the start date
	* @param description the description
	* @param esfSportTypeId the esf sport type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f match, or <code>null</code> if a matching e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFMatch fetchBymyMatch_Last(long userId,
		boolean isNational, long esfAssociationId, java.util.Date startDate,
		long description, long esfSportTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f matchs before and after the current e s f match in the ordered set where userId = &#63; and isNational = &#63; and esfAssociationId = &#63; and startDate = &#63; and description = &#63; and esfSportTypeId = &#63;.
	*
	* @param esfMatchId the primary key of the current e s f match
	* @param userId the user ID
	* @param isNational the is national
	* @param esfAssociationId the esf association ID
	* @param startDate the start date
	* @param description the description
	* @param esfSportTypeId the esf sport type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f match
	* @throws it.ethica.esf.NoSuchMatchException if a e s f match with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFMatch[] findBymyMatch_PrevAndNext(
		long esfMatchId, long userId, boolean isNational,
		long esfAssociationId, java.util.Date startDate, long description,
		long esfSportTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchMatchException;

	/**
	* Removes all the e s f matchs where userId = &#63; and isNational = &#63; and esfAssociationId = &#63; and startDate = &#63; and description = &#63; and esfSportTypeId = &#63; from the database.
	*
	* @param userId the user ID
	* @param isNational the is national
	* @param esfAssociationId the esf association ID
	* @param startDate the start date
	* @param description the description
	* @param esfSportTypeId the esf sport type ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeBymyMatch(long userId, boolean isNational,
		long esfAssociationId, java.util.Date startDate, long description,
		long esfSportTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f matchs where userId = &#63; and isNational = &#63; and esfAssociationId = &#63; and startDate = &#63; and description = &#63; and esfSportTypeId = &#63;.
	*
	* @param userId the user ID
	* @param isNational the is national
	* @param esfAssociationId the esf association ID
	* @param startDate the start date
	* @param description the description
	* @param esfSportTypeId the esf sport type ID
	* @return the number of matching e s f matchs
	* @throws SystemException if a system exception occurred
	*/
	public int countBymyMatch(long userId, boolean isNational,
		long esfAssociationId, java.util.Date startDate, long description,
		long esfSportTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f matchs where eventType = &#63;.
	*
	* @param eventType the event type
	* @return the matching e s f matchs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFMatch> findByEventType(
		java.lang.String eventType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f matchs where eventType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFMatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param eventType the event type
	* @param start the lower bound of the range of e s f matchs
	* @param end the upper bound of the range of e s f matchs (not inclusive)
	* @return the range of matching e s f matchs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFMatch> findByEventType(
		java.lang.String eventType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f matchs where eventType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFMatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param eventType the event type
	* @param start the lower bound of the range of e s f matchs
	* @param end the upper bound of the range of e s f matchs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f matchs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFMatch> findByEventType(
		java.lang.String eventType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f match in the ordered set where eventType = &#63;.
	*
	* @param eventType the event type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f match
	* @throws it.ethica.esf.NoSuchMatchException if a matching e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFMatch findByEventType_First(
		java.lang.String eventType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchMatchException;

	/**
	* Returns the first e s f match in the ordered set where eventType = &#63;.
	*
	* @param eventType the event type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f match, or <code>null</code> if a matching e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFMatch fetchByEventType_First(
		java.lang.String eventType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f match in the ordered set where eventType = &#63;.
	*
	* @param eventType the event type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f match
	* @throws it.ethica.esf.NoSuchMatchException if a matching e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFMatch findByEventType_Last(
		java.lang.String eventType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchMatchException;

	/**
	* Returns the last e s f match in the ordered set where eventType = &#63;.
	*
	* @param eventType the event type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f match, or <code>null</code> if a matching e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFMatch fetchByEventType_Last(
		java.lang.String eventType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f matchs before and after the current e s f match in the ordered set where eventType = &#63;.
	*
	* @param esfMatchId the primary key of the current e s f match
	* @param eventType the event type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f match
	* @throws it.ethica.esf.NoSuchMatchException if a e s f match with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFMatch[] findByEventType_PrevAndNext(
		long esfMatchId, java.lang.String eventType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchMatchException;

	/**
	* Removes all the e s f matchs where eventType = &#63; from the database.
	*
	* @param eventType the event type
	* @throws SystemException if a system exception occurred
	*/
	public void removeByEventType(java.lang.String eventType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f matchs where eventType = &#63;.
	*
	* @param eventType the event type
	* @return the number of matching e s f matchs
	* @throws SystemException if a system exception occurred
	*/
	public int countByEventType(java.lang.String eventType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f matchs where isChangeCategoryMatch = &#63;.
	*
	* @param isChangeCategoryMatch the is change category match
	* @return the matching e s f matchs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFMatch> findByIsChangeCategory(
		boolean isChangeCategoryMatch)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f matchs where isChangeCategoryMatch = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFMatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param isChangeCategoryMatch the is change category match
	* @param start the lower bound of the range of e s f matchs
	* @param end the upper bound of the range of e s f matchs (not inclusive)
	* @return the range of matching e s f matchs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFMatch> findByIsChangeCategory(
		boolean isChangeCategoryMatch, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f matchs where isChangeCategoryMatch = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFMatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param isChangeCategoryMatch the is change category match
	* @param start the lower bound of the range of e s f matchs
	* @param end the upper bound of the range of e s f matchs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f matchs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFMatch> findByIsChangeCategory(
		boolean isChangeCategoryMatch, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f match in the ordered set where isChangeCategoryMatch = &#63;.
	*
	* @param isChangeCategoryMatch the is change category match
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f match
	* @throws it.ethica.esf.NoSuchMatchException if a matching e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFMatch findByIsChangeCategory_First(
		boolean isChangeCategoryMatch,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchMatchException;

	/**
	* Returns the first e s f match in the ordered set where isChangeCategoryMatch = &#63;.
	*
	* @param isChangeCategoryMatch the is change category match
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f match, or <code>null</code> if a matching e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFMatch fetchByIsChangeCategory_First(
		boolean isChangeCategoryMatch,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f match in the ordered set where isChangeCategoryMatch = &#63;.
	*
	* @param isChangeCategoryMatch the is change category match
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f match
	* @throws it.ethica.esf.NoSuchMatchException if a matching e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFMatch findByIsChangeCategory_Last(
		boolean isChangeCategoryMatch,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchMatchException;

	/**
	* Returns the last e s f match in the ordered set where isChangeCategoryMatch = &#63;.
	*
	* @param isChangeCategoryMatch the is change category match
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f match, or <code>null</code> if a matching e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFMatch fetchByIsChangeCategory_Last(
		boolean isChangeCategoryMatch,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f matchs before and after the current e s f match in the ordered set where isChangeCategoryMatch = &#63;.
	*
	* @param esfMatchId the primary key of the current e s f match
	* @param isChangeCategoryMatch the is change category match
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f match
	* @throws it.ethica.esf.NoSuchMatchException if a e s f match with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFMatch[] findByIsChangeCategory_PrevAndNext(
		long esfMatchId, boolean isChangeCategoryMatch,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchMatchException;

	/**
	* Removes all the e s f matchs where isChangeCategoryMatch = &#63; from the database.
	*
	* @param isChangeCategoryMatch the is change category match
	* @throws SystemException if a system exception occurred
	*/
	public void removeByIsChangeCategory(boolean isChangeCategoryMatch)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f matchs where isChangeCategoryMatch = &#63;.
	*
	* @param isChangeCategoryMatch the is change category match
	* @return the number of matching e s f matchs
	* @throws SystemException if a system exception occurred
	*/
	public int countByIsChangeCategory(boolean isChangeCategoryMatch)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f matchs where description = &#63;.
	*
	* @param description the description
	* @return the matching e s f matchs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFMatch> findByDescription(
		long description)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f matchs where description = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFMatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param description the description
	* @param start the lower bound of the range of e s f matchs
	* @param end the upper bound of the range of e s f matchs (not inclusive)
	* @return the range of matching e s f matchs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFMatch> findByDescription(
		long description, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f matchs where description = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFMatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param description the description
	* @param start the lower bound of the range of e s f matchs
	* @param end the upper bound of the range of e s f matchs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f matchs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFMatch> findByDescription(
		long description, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f match in the ordered set where description = &#63;.
	*
	* @param description the description
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f match
	* @throws it.ethica.esf.NoSuchMatchException if a matching e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFMatch findByDescription_First(
		long description,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchMatchException;

	/**
	* Returns the first e s f match in the ordered set where description = &#63;.
	*
	* @param description the description
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f match, or <code>null</code> if a matching e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFMatch fetchByDescription_First(
		long description,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f match in the ordered set where description = &#63;.
	*
	* @param description the description
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f match
	* @throws it.ethica.esf.NoSuchMatchException if a matching e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFMatch findByDescription_Last(
		long description,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchMatchException;

	/**
	* Returns the last e s f match in the ordered set where description = &#63;.
	*
	* @param description the description
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f match, or <code>null</code> if a matching e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFMatch fetchByDescription_Last(
		long description,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f matchs before and after the current e s f match in the ordered set where description = &#63;.
	*
	* @param esfMatchId the primary key of the current e s f match
	* @param description the description
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f match
	* @throws it.ethica.esf.NoSuchMatchException if a e s f match with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFMatch[] findByDescription_PrevAndNext(
		long esfMatchId, long description,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchMatchException;

	/**
	* Removes all the e s f matchs where description = &#63; from the database.
	*
	* @param description the description
	* @throws SystemException if a system exception occurred
	*/
	public void removeByDescription(long description)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f matchs where description = &#63;.
	*
	* @param description the description
	* @return the number of matching e s f matchs
	* @throws SystemException if a system exception occurred
	*/
	public int countByDescription(long description)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f match where code = &#63; or throws a {@link it.ethica.esf.NoSuchMatchException} if it could not be found.
	*
	* @param code the code
	* @return the matching e s f match
	* @throws it.ethica.esf.NoSuchMatchException if a matching e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFMatch findByCode(java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchMatchException;

	/**
	* Returns the e s f match where code = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param code the code
	* @return the matching e s f match, or <code>null</code> if a matching e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFMatch fetchByCode(java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f match where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param code the code
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching e s f match, or <code>null</code> if a matching e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFMatch fetchByCode(java.lang.String code,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the e s f match where code = &#63; from the database.
	*
	* @param code the code
	* @return the e s f match that was removed
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFMatch removeByCode(java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchMatchException;

	/**
	* Returns the number of e s f matchs where code = &#63;.
	*
	* @param code the code
	* @return the number of matching e s f matchs
	* @throws SystemException if a system exception occurred
	*/
	public int countByCode(java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f matchs where startDate &gt; &#63; and isNational = &#63; and code LIKE &#63;.
	*
	* @param startDate the start date
	* @param isNational the is national
	* @param code the code
	* @return the matching e s f matchs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFMatch> findByDate_Code(
		java.util.Date startDate, boolean isNational, java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f matchs where startDate &gt; &#63; and isNational = &#63; and code LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFMatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param startDate the start date
	* @param isNational the is national
	* @param code the code
	* @param start the lower bound of the range of e s f matchs
	* @param end the upper bound of the range of e s f matchs (not inclusive)
	* @return the range of matching e s f matchs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFMatch> findByDate_Code(
		java.util.Date startDate, boolean isNational, java.lang.String code,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f matchs where startDate &gt; &#63; and isNational = &#63; and code LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFMatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param startDate the start date
	* @param isNational the is national
	* @param code the code
	* @param start the lower bound of the range of e s f matchs
	* @param end the upper bound of the range of e s f matchs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f matchs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFMatch> findByDate_Code(
		java.util.Date startDate, boolean isNational, java.lang.String code,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f match in the ordered set where startDate &gt; &#63; and isNational = &#63; and code LIKE &#63;.
	*
	* @param startDate the start date
	* @param isNational the is national
	* @param code the code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f match
	* @throws it.ethica.esf.NoSuchMatchException if a matching e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFMatch findByDate_Code_First(
		java.util.Date startDate, boolean isNational, java.lang.String code,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchMatchException;

	/**
	* Returns the first e s f match in the ordered set where startDate &gt; &#63; and isNational = &#63; and code LIKE &#63;.
	*
	* @param startDate the start date
	* @param isNational the is national
	* @param code the code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f match, or <code>null</code> if a matching e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFMatch fetchByDate_Code_First(
		java.util.Date startDate, boolean isNational, java.lang.String code,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f match in the ordered set where startDate &gt; &#63; and isNational = &#63; and code LIKE &#63;.
	*
	* @param startDate the start date
	* @param isNational the is national
	* @param code the code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f match
	* @throws it.ethica.esf.NoSuchMatchException if a matching e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFMatch findByDate_Code_Last(
		java.util.Date startDate, boolean isNational, java.lang.String code,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchMatchException;

	/**
	* Returns the last e s f match in the ordered set where startDate &gt; &#63; and isNational = &#63; and code LIKE &#63;.
	*
	* @param startDate the start date
	* @param isNational the is national
	* @param code the code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f match, or <code>null</code> if a matching e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFMatch fetchByDate_Code_Last(
		java.util.Date startDate, boolean isNational, java.lang.String code,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f matchs before and after the current e s f match in the ordered set where startDate &gt; &#63; and isNational = &#63; and code LIKE &#63;.
	*
	* @param esfMatchId the primary key of the current e s f match
	* @param startDate the start date
	* @param isNational the is national
	* @param code the code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f match
	* @throws it.ethica.esf.NoSuchMatchException if a e s f match with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFMatch[] findByDate_Code_PrevAndNext(
		long esfMatchId, java.util.Date startDate, boolean isNational,
		java.lang.String code,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchMatchException;

	/**
	* Removes all the e s f matchs where startDate &gt; &#63; and isNational = &#63; and code LIKE &#63; from the database.
	*
	* @param startDate the start date
	* @param isNational the is national
	* @param code the code
	* @throws SystemException if a system exception occurred
	*/
	public void removeByDate_Code(java.util.Date startDate, boolean isNational,
		java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f matchs where startDate &gt; &#63; and isNational = &#63; and code LIKE &#63;.
	*
	* @param startDate the start date
	* @param isNational the is national
	* @param code the code
	* @return the number of matching e s f matchs
	* @throws SystemException if a system exception occurred
	*/
	public int countByDate_Code(java.util.Date startDate, boolean isNational,
		java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the e s f match in the entity cache if it is enabled.
	*
	* @param esfMatch the e s f match
	*/
	public void cacheResult(it.ethica.esf.model.ESFMatch esfMatch);

	/**
	* Caches the e s f matchs in the entity cache if it is enabled.
	*
	* @param esfMatchs the e s f matchs
	*/
	public void cacheResult(
		java.util.List<it.ethica.esf.model.ESFMatch> esfMatchs);

	/**
	* Creates a new e s f match with the primary key. Does not add the e s f match to the database.
	*
	* @param esfMatchId the primary key for the new e s f match
	* @return the new e s f match
	*/
	public it.ethica.esf.model.ESFMatch create(long esfMatchId);

	/**
	* Removes the e s f match with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfMatchId the primary key of the e s f match
	* @return the e s f match that was removed
	* @throws it.ethica.esf.NoSuchMatchException if a e s f match with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFMatch remove(long esfMatchId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchMatchException;

	public it.ethica.esf.model.ESFMatch updateImpl(
		it.ethica.esf.model.ESFMatch esfMatch)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f match with the primary key or throws a {@link it.ethica.esf.NoSuchMatchException} if it could not be found.
	*
	* @param esfMatchId the primary key of the e s f match
	* @return the e s f match
	* @throws it.ethica.esf.NoSuchMatchException if a e s f match with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFMatch findByPrimaryKey(long esfMatchId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchMatchException;

	/**
	* Returns the e s f match with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param esfMatchId the primary key of the e s f match
	* @return the e s f match, or <code>null</code> if a e s f match with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFMatch fetchByPrimaryKey(long esfMatchId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f matchs.
	*
	* @return the e s f matchs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFMatch> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.ethica.esf.model.ESFMatch> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f matchs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFMatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f matchs
	* @param end the upper bound of the range of e s f matchs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of e s f matchs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFMatch> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the e s f matchs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f matchs.
	*
	* @return the number of e s f matchs
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}