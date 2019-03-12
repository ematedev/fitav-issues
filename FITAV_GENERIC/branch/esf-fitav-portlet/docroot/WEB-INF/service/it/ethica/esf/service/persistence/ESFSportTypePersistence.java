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

import it.ethica.esf.model.ESFSportType;

/**
 * The persistence interface for the e s f sport type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFSportTypePersistenceImpl
 * @see ESFSportTypeUtil
 * @generated
 */
public interface ESFSportTypePersistence extends BasePersistence<ESFSportType> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ESFSportTypeUtil} to access the e s f sport type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the e s f sport types where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching e s f sport types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFSportType> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f sport types where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFSportTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of e s f sport types
	* @param end the upper bound of the range of e s f sport types (not inclusive)
	* @return the range of matching e s f sport types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFSportType> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f sport types where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFSportTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of e s f sport types
	* @param end the upper bound of the range of e s f sport types (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f sport types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFSportType> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f sport type in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f sport type
	* @throws it.ethica.esf.NoSuchSportTypeException if a matching e s f sport type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFSportType findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchSportTypeException;

	/**
	* Returns the first e s f sport type in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f sport type, or <code>null</code> if a matching e s f sport type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFSportType fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f sport type in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f sport type
	* @throws it.ethica.esf.NoSuchSportTypeException if a matching e s f sport type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFSportType findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchSportTypeException;

	/**
	* Returns the last e s f sport type in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f sport type, or <code>null</code> if a matching e s f sport type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFSportType fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f sport types before and after the current e s f sport type in the ordered set where uuid = &#63;.
	*
	* @param esfSportTypeId the primary key of the current e s f sport type
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f sport type
	* @throws it.ethica.esf.NoSuchSportTypeException if a e s f sport type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFSportType[] findByUuid_PrevAndNext(
		long esfSportTypeId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchSportTypeException;

	/**
	* Removes all the e s f sport types where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f sport types where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching e s f sport types
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f sport type where uuid = &#63; and groupId = &#63; or throws a {@link it.ethica.esf.NoSuchSportTypeException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching e s f sport type
	* @throws it.ethica.esf.NoSuchSportTypeException if a matching e s f sport type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFSportType findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchSportTypeException;

	/**
	* Returns the e s f sport type where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching e s f sport type, or <code>null</code> if a matching e s f sport type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFSportType fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f sport type where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching e s f sport type, or <code>null</code> if a matching e s f sport type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFSportType fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the e s f sport type where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the e s f sport type that was removed
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFSportType removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchSportTypeException;

	/**
	* Returns the number of e s f sport types where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching e s f sport types
	* @throws SystemException if a system exception occurred
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f sport types where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching e s f sport types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFSportType> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f sport types where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFSportTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of e s f sport types
	* @param end the upper bound of the range of e s f sport types (not inclusive)
	* @return the range of matching e s f sport types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFSportType> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f sport types where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFSportTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of e s f sport types
	* @param end the upper bound of the range of e s f sport types (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f sport types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFSportType> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f sport type in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f sport type
	* @throws it.ethica.esf.NoSuchSportTypeException if a matching e s f sport type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFSportType findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchSportTypeException;

	/**
	* Returns the first e s f sport type in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f sport type, or <code>null</code> if a matching e s f sport type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFSportType fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f sport type in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f sport type
	* @throws it.ethica.esf.NoSuchSportTypeException if a matching e s f sport type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFSportType findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchSportTypeException;

	/**
	* Returns the last e s f sport type in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f sport type, or <code>null</code> if a matching e s f sport type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFSportType fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f sport types before and after the current e s f sport type in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param esfSportTypeId the primary key of the current e s f sport type
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f sport type
	* @throws it.ethica.esf.NoSuchSportTypeException if a e s f sport type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFSportType[] findByUuid_C_PrevAndNext(
		long esfSportTypeId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchSportTypeException;

	/**
	* Removes all the e s f sport types where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f sport types where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching e s f sport types
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f sport types where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching e s f sport types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFSportType> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f sport types where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFSportTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of e s f sport types
	* @param end the upper bound of the range of e s f sport types (not inclusive)
	* @return the range of matching e s f sport types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFSportType> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f sport types where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFSportTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of e s f sport types
	* @param end the upper bound of the range of e s f sport types (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f sport types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFSportType> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f sport type in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f sport type
	* @throws it.ethica.esf.NoSuchSportTypeException if a matching e s f sport type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFSportType findByGroupId_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchSportTypeException;

	/**
	* Returns the first e s f sport type in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f sport type, or <code>null</code> if a matching e s f sport type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFSportType fetchByGroupId_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f sport type in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f sport type
	* @throws it.ethica.esf.NoSuchSportTypeException if a matching e s f sport type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFSportType findByGroupId_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchSportTypeException;

	/**
	* Returns the last e s f sport type in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f sport type, or <code>null</code> if a matching e s f sport type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFSportType fetchByGroupId_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f sport types before and after the current e s f sport type in the ordered set where groupId = &#63;.
	*
	* @param esfSportTypeId the primary key of the current e s f sport type
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f sport type
	* @throws it.ethica.esf.NoSuchSportTypeException if a e s f sport type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFSportType[] findByGroupId_PrevAndNext(
		long esfSportTypeId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchSportTypeException;

	/**
	* Removes all the e s f sport types where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f sport types where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching e s f sport types
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f sport types where name LIKE &#63;.
	*
	* @param name the name
	* @return the matching e s f sport types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFSportType> findByName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f sport types where name LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFSportTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param name the name
	* @param start the lower bound of the range of e s f sport types
	* @param end the upper bound of the range of e s f sport types (not inclusive)
	* @return the range of matching e s f sport types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFSportType> findByName(
		java.lang.String name, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f sport types where name LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFSportTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param name the name
	* @param start the lower bound of the range of e s f sport types
	* @param end the upper bound of the range of e s f sport types (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f sport types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFSportType> findByName(
		java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f sport type in the ordered set where name LIKE &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f sport type
	* @throws it.ethica.esf.NoSuchSportTypeException if a matching e s f sport type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFSportType findByName_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchSportTypeException;

	/**
	* Returns the first e s f sport type in the ordered set where name LIKE &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f sport type, or <code>null</code> if a matching e s f sport type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFSportType fetchByName_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f sport type in the ordered set where name LIKE &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f sport type
	* @throws it.ethica.esf.NoSuchSportTypeException if a matching e s f sport type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFSportType findByName_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchSportTypeException;

	/**
	* Returns the last e s f sport type in the ordered set where name LIKE &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f sport type, or <code>null</code> if a matching e s f sport type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFSportType fetchByName_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f sport types before and after the current e s f sport type in the ordered set where name LIKE &#63;.
	*
	* @param esfSportTypeId the primary key of the current e s f sport type
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f sport type
	* @throws it.ethica.esf.NoSuchSportTypeException if a e s f sport type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFSportType[] findByName_PrevAndNext(
		long esfSportTypeId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchSportTypeException;

	/**
	* Removes all the e s f sport types where name LIKE &#63; from the database.
	*
	* @param name the name
	* @throws SystemException if a system exception occurred
	*/
	public void removeByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f sport types where name LIKE &#63;.
	*
	* @param name the name
	* @return the number of matching e s f sport types
	* @throws SystemException if a system exception occurred
	*/
	public int countByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f sport types where national = &#63; and isOlimpic = &#63;.
	*
	* @param national the national
	* @param isOlimpic the is olimpic
	* @return the matching e s f sport types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFSportType> findByNational(
		boolean national, boolean isOlimpic)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f sport types where national = &#63; and isOlimpic = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFSportTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param national the national
	* @param isOlimpic the is olimpic
	* @param start the lower bound of the range of e s f sport types
	* @param end the upper bound of the range of e s f sport types (not inclusive)
	* @return the range of matching e s f sport types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFSportType> findByNational(
		boolean national, boolean isOlimpic, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f sport types where national = &#63; and isOlimpic = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFSportTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param national the national
	* @param isOlimpic the is olimpic
	* @param start the lower bound of the range of e s f sport types
	* @param end the upper bound of the range of e s f sport types (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f sport types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFSportType> findByNational(
		boolean national, boolean isOlimpic, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f sport type in the ordered set where national = &#63; and isOlimpic = &#63;.
	*
	* @param national the national
	* @param isOlimpic the is olimpic
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f sport type
	* @throws it.ethica.esf.NoSuchSportTypeException if a matching e s f sport type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFSportType findByNational_First(
		boolean national, boolean isOlimpic,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchSportTypeException;

	/**
	* Returns the first e s f sport type in the ordered set where national = &#63; and isOlimpic = &#63;.
	*
	* @param national the national
	* @param isOlimpic the is olimpic
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f sport type, or <code>null</code> if a matching e s f sport type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFSportType fetchByNational_First(
		boolean national, boolean isOlimpic,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f sport type in the ordered set where national = &#63; and isOlimpic = &#63;.
	*
	* @param national the national
	* @param isOlimpic the is olimpic
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f sport type
	* @throws it.ethica.esf.NoSuchSportTypeException if a matching e s f sport type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFSportType findByNational_Last(
		boolean national, boolean isOlimpic,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchSportTypeException;

	/**
	* Returns the last e s f sport type in the ordered set where national = &#63; and isOlimpic = &#63;.
	*
	* @param national the national
	* @param isOlimpic the is olimpic
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f sport type, or <code>null</code> if a matching e s f sport type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFSportType fetchByNational_Last(
		boolean national, boolean isOlimpic,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f sport types before and after the current e s f sport type in the ordered set where national = &#63; and isOlimpic = &#63;.
	*
	* @param esfSportTypeId the primary key of the current e s f sport type
	* @param national the national
	* @param isOlimpic the is olimpic
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f sport type
	* @throws it.ethica.esf.NoSuchSportTypeException if a e s f sport type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFSportType[] findByNational_PrevAndNext(
		long esfSportTypeId, boolean national, boolean isOlimpic,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchSportTypeException;

	/**
	* Removes all the e s f sport types where national = &#63; and isOlimpic = &#63; from the database.
	*
	* @param national the national
	* @param isOlimpic the is olimpic
	* @throws SystemException if a system exception occurred
	*/
	public void removeByNational(boolean national, boolean isOlimpic)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f sport types where national = &#63; and isOlimpic = &#63;.
	*
	* @param national the national
	* @param isOlimpic the is olimpic
	* @return the number of matching e s f sport types
	* @throws SystemException if a system exception occurred
	*/
	public int countByNational(boolean national, boolean isOlimpic)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f sport types where isOlimpic = &#63;.
	*
	* @param isOlimpic the is olimpic
	* @return the matching e s f sport types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFSportType> findByisOlimpic(
		boolean isOlimpic)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f sport types where isOlimpic = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFSportTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param isOlimpic the is olimpic
	* @param start the lower bound of the range of e s f sport types
	* @param end the upper bound of the range of e s f sport types (not inclusive)
	* @return the range of matching e s f sport types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFSportType> findByisOlimpic(
		boolean isOlimpic, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f sport types where isOlimpic = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFSportTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param isOlimpic the is olimpic
	* @param start the lower bound of the range of e s f sport types
	* @param end the upper bound of the range of e s f sport types (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f sport types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFSportType> findByisOlimpic(
		boolean isOlimpic, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f sport type in the ordered set where isOlimpic = &#63;.
	*
	* @param isOlimpic the is olimpic
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f sport type
	* @throws it.ethica.esf.NoSuchSportTypeException if a matching e s f sport type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFSportType findByisOlimpic_First(
		boolean isOlimpic,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchSportTypeException;

	/**
	* Returns the first e s f sport type in the ordered set where isOlimpic = &#63;.
	*
	* @param isOlimpic the is olimpic
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f sport type, or <code>null</code> if a matching e s f sport type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFSportType fetchByisOlimpic_First(
		boolean isOlimpic,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f sport type in the ordered set where isOlimpic = &#63;.
	*
	* @param isOlimpic the is olimpic
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f sport type
	* @throws it.ethica.esf.NoSuchSportTypeException if a matching e s f sport type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFSportType findByisOlimpic_Last(
		boolean isOlimpic,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchSportTypeException;

	/**
	* Returns the last e s f sport type in the ordered set where isOlimpic = &#63;.
	*
	* @param isOlimpic the is olimpic
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f sport type, or <code>null</code> if a matching e s f sport type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFSportType fetchByisOlimpic_Last(
		boolean isOlimpic,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f sport types before and after the current e s f sport type in the ordered set where isOlimpic = &#63;.
	*
	* @param esfSportTypeId the primary key of the current e s f sport type
	* @param isOlimpic the is olimpic
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f sport type
	* @throws it.ethica.esf.NoSuchSportTypeException if a e s f sport type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFSportType[] findByisOlimpic_PrevAndNext(
		long esfSportTypeId, boolean isOlimpic,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchSportTypeException;

	/**
	* Removes all the e s f sport types where isOlimpic = &#63; from the database.
	*
	* @param isOlimpic the is olimpic
	* @throws SystemException if a system exception occurred
	*/
	public void removeByisOlimpic(boolean isOlimpic)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f sport types where isOlimpic = &#63;.
	*
	* @param isOlimpic the is olimpic
	* @return the number of matching e s f sport types
	* @throws SystemException if a system exception occurred
	*/
	public int countByisOlimpic(boolean isOlimpic)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the e s f sport type in the entity cache if it is enabled.
	*
	* @param esfSportType the e s f sport type
	*/
	public void cacheResult(it.ethica.esf.model.ESFSportType esfSportType);

	/**
	* Caches the e s f sport types in the entity cache if it is enabled.
	*
	* @param esfSportTypes the e s f sport types
	*/
	public void cacheResult(
		java.util.List<it.ethica.esf.model.ESFSportType> esfSportTypes);

	/**
	* Creates a new e s f sport type with the primary key. Does not add the e s f sport type to the database.
	*
	* @param esfSportTypeId the primary key for the new e s f sport type
	* @return the new e s f sport type
	*/
	public it.ethica.esf.model.ESFSportType create(long esfSportTypeId);

	/**
	* Removes the e s f sport type with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfSportTypeId the primary key of the e s f sport type
	* @return the e s f sport type that was removed
	* @throws it.ethica.esf.NoSuchSportTypeException if a e s f sport type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFSportType remove(long esfSportTypeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchSportTypeException;

	public it.ethica.esf.model.ESFSportType updateImpl(
		it.ethica.esf.model.ESFSportType esfSportType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f sport type with the primary key or throws a {@link it.ethica.esf.NoSuchSportTypeException} if it could not be found.
	*
	* @param esfSportTypeId the primary key of the e s f sport type
	* @return the e s f sport type
	* @throws it.ethica.esf.NoSuchSportTypeException if a e s f sport type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFSportType findByPrimaryKey(
		long esfSportTypeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchSportTypeException;

	/**
	* Returns the e s f sport type with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param esfSportTypeId the primary key of the e s f sport type
	* @return the e s f sport type, or <code>null</code> if a e s f sport type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFSportType fetchByPrimaryKey(
		long esfSportTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f sport types.
	*
	* @return the e s f sport types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFSportType> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f sport types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFSportTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f sport types
	* @param end the upper bound of the range of e s f sport types (not inclusive)
	* @return the range of e s f sport types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFSportType> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f sport types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFSportTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f sport types
	* @param end the upper bound of the range of e s f sport types (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of e s f sport types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFSportType> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the e s f sport types from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f sport types.
	*
	* @return the number of e s f sport types
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}