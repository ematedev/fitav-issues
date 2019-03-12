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

import it.ethica.esf.model.ESFAddress;

/**
 * The persistence interface for the e s f address service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFAddressPersistenceImpl
 * @see ESFAddressUtil
 * @generated
 */
public interface ESFAddressPersistence extends BasePersistence<ESFAddress> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ESFAddressUtil} to access the e s f address persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the e s f addresses where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching e s f addresses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFAddress> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f addresses where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFAddressModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of e s f addresses
	* @param end the upper bound of the range of e s f addresses (not inclusive)
	* @return the range of matching e s f addresses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFAddress> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f addresses where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFAddressModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of e s f addresses
	* @param end the upper bound of the range of e s f addresses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f addresses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFAddress> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f address in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f address
	* @throws it.ethica.esf.NoSuchAddressException if a matching e s f address could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFAddress findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchAddressException;

	/**
	* Returns the first e s f address in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f address, or <code>null</code> if a matching e s f address could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFAddress fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f address in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f address
	* @throws it.ethica.esf.NoSuchAddressException if a matching e s f address could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFAddress findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchAddressException;

	/**
	* Returns the last e s f address in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f address, or <code>null</code> if a matching e s f address could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFAddress fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f addresses before and after the current e s f address in the ordered set where uuid = &#63;.
	*
	* @param esfAddressId the primary key of the current e s f address
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f address
	* @throws it.ethica.esf.NoSuchAddressException if a e s f address with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFAddress[] findByUuid_PrevAndNext(
		long esfAddressId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchAddressException;

	/**
	* Removes all the e s f addresses where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f addresses where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching e s f addresses
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f address where uuid = &#63; and groupId = &#63; or throws a {@link it.ethica.esf.NoSuchAddressException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching e s f address
	* @throws it.ethica.esf.NoSuchAddressException if a matching e s f address could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFAddress findByUUID_G(java.lang.String uuid,
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchAddressException;

	/**
	* Returns the e s f address where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching e s f address, or <code>null</code> if a matching e s f address could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFAddress fetchByUUID_G(java.lang.String uuid,
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f address where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching e s f address, or <code>null</code> if a matching e s f address could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFAddress fetchByUUID_G(java.lang.String uuid,
		long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the e s f address where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the e s f address that was removed
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFAddress removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchAddressException;

	/**
	* Returns the number of e s f addresses where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching e s f addresses
	* @throws SystemException if a system exception occurred
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f addresses where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching e s f addresses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFAddress> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f addresses where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFAddressModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of e s f addresses
	* @param end the upper bound of the range of e s f addresses (not inclusive)
	* @return the range of matching e s f addresses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFAddress> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f addresses where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFAddressModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of e s f addresses
	* @param end the upper bound of the range of e s f addresses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f addresses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFAddress> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f address in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f address
	* @throws it.ethica.esf.NoSuchAddressException if a matching e s f address could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFAddress findByGroupId_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchAddressException;

	/**
	* Returns the first e s f address in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f address, or <code>null</code> if a matching e s f address could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFAddress fetchByGroupId_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f address in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f address
	* @throws it.ethica.esf.NoSuchAddressException if a matching e s f address could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFAddress findByGroupId_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchAddressException;

	/**
	* Returns the last e s f address in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f address, or <code>null</code> if a matching e s f address could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFAddress fetchByGroupId_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f addresses before and after the current e s f address in the ordered set where groupId = &#63;.
	*
	* @param esfAddressId the primary key of the current e s f address
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f address
	* @throws it.ethica.esf.NoSuchAddressException if a e s f address with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFAddress[] findByGroupId_PrevAndNext(
		long esfAddressId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchAddressException;

	/**
	* Returns all the e s f addresses that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching e s f addresses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFAddress> filterFindByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f addresses that the user has permission to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFAddressModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of e s f addresses
	* @param end the upper bound of the range of e s f addresses (not inclusive)
	* @return the range of matching e s f addresses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFAddress> filterFindByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f addresses that the user has permissions to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFAddressModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of e s f addresses
	* @param end the upper bound of the range of e s f addresses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f addresses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFAddress> filterFindByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f addresses before and after the current e s f address in the ordered set of e s f addresses that the user has permission to view where groupId = &#63;.
	*
	* @param esfAddressId the primary key of the current e s f address
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f address
	* @throws it.ethica.esf.NoSuchAddressException if a e s f address with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFAddress[] filterFindByGroupId_PrevAndNext(
		long esfAddressId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchAddressException;

	/**
	* Removes all the e s f addresses where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f addresses where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching e s f addresses
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f addresses that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching e s f addresses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f address where longitude = &#63; and latitude = &#63; or throws a {@link it.ethica.esf.NoSuchAddressException} if it could not be found.
	*
	* @param longitude the longitude
	* @param latitude the latitude
	* @return the matching e s f address
	* @throws it.ethica.esf.NoSuchAddressException if a matching e s f address could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFAddress findByL_L(double longitude,
		double latitude)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchAddressException;

	/**
	* Returns the e s f address where longitude = &#63; and latitude = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param longitude the longitude
	* @param latitude the latitude
	* @return the matching e s f address, or <code>null</code> if a matching e s f address could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFAddress fetchByL_L(double longitude,
		double latitude)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f address where longitude = &#63; and latitude = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param longitude the longitude
	* @param latitude the latitude
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching e s f address, or <code>null</code> if a matching e s f address could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFAddress fetchByL_L(double longitude,
		double latitude, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the e s f address where longitude = &#63; and latitude = &#63; from the database.
	*
	* @param longitude the longitude
	* @param latitude the latitude
	* @return the e s f address that was removed
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFAddress removeByL_L(double longitude,
		double latitude)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchAddressException;

	/**
	* Returns the number of e s f addresses where longitude = &#63; and latitude = &#63;.
	*
	* @param longitude the longitude
	* @param latitude the latitude
	* @return the number of matching e s f addresses
	* @throws SystemException if a system exception occurred
	*/
	public int countByL_L(double longitude, double latitude)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the e s f address in the entity cache if it is enabled.
	*
	* @param esfAddress the e s f address
	*/
	public void cacheResult(it.ethica.esf.model.ESFAddress esfAddress);

	/**
	* Caches the e s f addresses in the entity cache if it is enabled.
	*
	* @param esfAddresses the e s f addresses
	*/
	public void cacheResult(
		java.util.List<it.ethica.esf.model.ESFAddress> esfAddresses);

	/**
	* Creates a new e s f address with the primary key. Does not add the e s f address to the database.
	*
	* @param esfAddressId the primary key for the new e s f address
	* @return the new e s f address
	*/
	public it.ethica.esf.model.ESFAddress create(long esfAddressId);

	/**
	* Removes the e s f address with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfAddressId the primary key of the e s f address
	* @return the e s f address that was removed
	* @throws it.ethica.esf.NoSuchAddressException if a e s f address with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFAddress remove(long esfAddressId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchAddressException;

	public it.ethica.esf.model.ESFAddress updateImpl(
		it.ethica.esf.model.ESFAddress esfAddress)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f address with the primary key or throws a {@link it.ethica.esf.NoSuchAddressException} if it could not be found.
	*
	* @param esfAddressId the primary key of the e s f address
	* @return the e s f address
	* @throws it.ethica.esf.NoSuchAddressException if a e s f address with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFAddress findByPrimaryKey(long esfAddressId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchAddressException;

	/**
	* Returns the e s f address with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param esfAddressId the primary key of the e s f address
	* @return the e s f address, or <code>null</code> if a e s f address with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFAddress fetchByPrimaryKey(long esfAddressId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f addresses.
	*
	* @return the e s f addresses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFAddress> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f addresses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFAddressModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f addresses
	* @param end the upper bound of the range of e s f addresses (not inclusive)
	* @return the range of e s f addresses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFAddress> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f addresses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFAddressModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f addresses
	* @param end the upper bound of the range of e s f addresses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of e s f addresses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFAddress> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the e s f addresses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f addresses.
	*
	* @return the number of e s f addresses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}