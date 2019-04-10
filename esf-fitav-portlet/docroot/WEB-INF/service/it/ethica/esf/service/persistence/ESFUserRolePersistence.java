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

import it.ethica.esf.model.ESFUserRole;

/**
 * The persistence interface for the e s f user role service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFUserRolePersistenceImpl
 * @see ESFUserRoleUtil
 * @generated
 */
public interface ESFUserRolePersistence extends BasePersistence<ESFUserRole> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ESFUserRoleUtil} to access the e s f user role persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the e s f user roles where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching e s f user roles
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFUserRole> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f user roles where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of e s f user roles
	* @param end the upper bound of the range of e s f user roles (not inclusive)
	* @return the range of matching e s f user roles
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFUserRole> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f user roles where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of e s f user roles
	* @param end the upper bound of the range of e s f user roles (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f user roles
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFUserRole> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f user role in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f user role
	* @throws it.ethica.esf.NoSuchUserRoleException if a matching e s f user role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFUserRole findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserRoleException;

	/**
	* Returns the first e s f user role in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f user role, or <code>null</code> if a matching e s f user role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFUserRole fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f user role in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f user role
	* @throws it.ethica.esf.NoSuchUserRoleException if a matching e s f user role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFUserRole findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserRoleException;

	/**
	* Returns the last e s f user role in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f user role, or <code>null</code> if a matching e s f user role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFUserRole fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f user roles before and after the current e s f user role in the ordered set where uuid = &#63;.
	*
	* @param esfUserRoleId the primary key of the current e s f user role
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f user role
	* @throws it.ethica.esf.NoSuchUserRoleException if a e s f user role with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFUserRole[] findByUuid_PrevAndNext(
		long esfUserRoleId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserRoleException;

	/**
	* Removes all the e s f user roles where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f user roles where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching e s f user roles
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f user role where uuid = &#63; and groupId = &#63; or throws a {@link it.ethica.esf.NoSuchUserRoleException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching e s f user role
	* @throws it.ethica.esf.NoSuchUserRoleException if a matching e s f user role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFUserRole findByUUID_G(java.lang.String uuid,
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserRoleException;

	/**
	* Returns the e s f user role where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching e s f user role, or <code>null</code> if a matching e s f user role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFUserRole fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f user role where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching e s f user role, or <code>null</code> if a matching e s f user role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFUserRole fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the e s f user role where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the e s f user role that was removed
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFUserRole removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserRoleException;

	/**
	* Returns the number of e s f user roles where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching e s f user roles
	* @throws SystemException if a system exception occurred
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f user roles where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching e s f user roles
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFUserRole> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f user roles where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of e s f user roles
	* @param end the upper bound of the range of e s f user roles (not inclusive)
	* @return the range of matching e s f user roles
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFUserRole> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f user roles where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of e s f user roles
	* @param end the upper bound of the range of e s f user roles (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f user roles
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFUserRole> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f user role in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f user role
	* @throws it.ethica.esf.NoSuchUserRoleException if a matching e s f user role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFUserRole findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserRoleException;

	/**
	* Returns the first e s f user role in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f user role, or <code>null</code> if a matching e s f user role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFUserRole fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f user role in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f user role
	* @throws it.ethica.esf.NoSuchUserRoleException if a matching e s f user role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFUserRole findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserRoleException;

	/**
	* Returns the last e s f user role in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f user role, or <code>null</code> if a matching e s f user role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFUserRole fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f user roles before and after the current e s f user role in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param esfUserRoleId the primary key of the current e s f user role
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f user role
	* @throws it.ethica.esf.NoSuchUserRoleException if a e s f user role with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFUserRole[] findByUuid_C_PrevAndNext(
		long esfUserRoleId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserRoleException;

	/**
	* Removes all the e s f user roles where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f user roles where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching e s f user roles
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f user roles where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching e s f user roles
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFUserRole> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f user roles where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of e s f user roles
	* @param end the upper bound of the range of e s f user roles (not inclusive)
	* @return the range of matching e s f user roles
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFUserRole> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f user roles where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of e s f user roles
	* @param end the upper bound of the range of e s f user roles (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f user roles
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFUserRole> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f user role in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f user role
	* @throws it.ethica.esf.NoSuchUserRoleException if a matching e s f user role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFUserRole findByGroupId_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserRoleException;

	/**
	* Returns the first e s f user role in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f user role, or <code>null</code> if a matching e s f user role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFUserRole fetchByGroupId_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f user role in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f user role
	* @throws it.ethica.esf.NoSuchUserRoleException if a matching e s f user role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFUserRole findByGroupId_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserRoleException;

	/**
	* Returns the last e s f user role in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f user role, or <code>null</code> if a matching e s f user role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFUserRole fetchByGroupId_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f user roles before and after the current e s f user role in the ordered set where groupId = &#63;.
	*
	* @param esfUserRoleId the primary key of the current e s f user role
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f user role
	* @throws it.ethica.esf.NoSuchUserRoleException if a e s f user role with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFUserRole[] findByGroupId_PrevAndNext(
		long esfUserRoleId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserRoleException;

	/**
	* Removes all the e s f user roles where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f user roles where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching e s f user roles
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f user roles where type = &#63;.
	*
	* @param type the type
	* @return the matching e s f user roles
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFUserRole> findByType(int type)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f user roles where type = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param type the type
	* @param start the lower bound of the range of e s f user roles
	* @param end the upper bound of the range of e s f user roles (not inclusive)
	* @return the range of matching e s f user roles
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFUserRole> findByType(
		int type, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f user roles where type = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param type the type
	* @param start the lower bound of the range of e s f user roles
	* @param end the upper bound of the range of e s f user roles (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f user roles
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFUserRole> findByType(
		int type, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f user role in the ordered set where type = &#63;.
	*
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f user role
	* @throws it.ethica.esf.NoSuchUserRoleException if a matching e s f user role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFUserRole findByType_First(int type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserRoleException;

	/**
	* Returns the first e s f user role in the ordered set where type = &#63;.
	*
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f user role, or <code>null</code> if a matching e s f user role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFUserRole fetchByType_First(int type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f user role in the ordered set where type = &#63;.
	*
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f user role
	* @throws it.ethica.esf.NoSuchUserRoleException if a matching e s f user role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFUserRole findByType_Last(int type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserRoleException;

	/**
	* Returns the last e s f user role in the ordered set where type = &#63;.
	*
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f user role, or <code>null</code> if a matching e s f user role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFUserRole fetchByType_Last(int type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f user roles before and after the current e s f user role in the ordered set where type = &#63;.
	*
	* @param esfUserRoleId the primary key of the current e s f user role
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f user role
	* @throws it.ethica.esf.NoSuchUserRoleException if a e s f user role with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFUserRole[] findByType_PrevAndNext(
		long esfUserRoleId, int type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserRoleException;

	/**
	* Removes all the e s f user roles where type = &#63; from the database.
	*
	* @param type the type
	* @throws SystemException if a system exception occurred
	*/
	public void removeByType(int type)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f user roles where type = &#63;.
	*
	* @param type the type
	* @return the number of matching e s f user roles
	* @throws SystemException if a system exception occurred
	*/
	public int countByType(int type)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f user roles where isBDO = &#63;.
	*
	* @param isBDO the is b d o
	* @return the matching e s f user roles
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFUserRole> findByBDO(
		boolean isBDO)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f user roles where isBDO = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param isBDO the is b d o
	* @param start the lower bound of the range of e s f user roles
	* @param end the upper bound of the range of e s f user roles (not inclusive)
	* @return the range of matching e s f user roles
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFUserRole> findByBDO(
		boolean isBDO, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f user roles where isBDO = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param isBDO the is b d o
	* @param start the lower bound of the range of e s f user roles
	* @param end the upper bound of the range of e s f user roles (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f user roles
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFUserRole> findByBDO(
		boolean isBDO, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f user role in the ordered set where isBDO = &#63;.
	*
	* @param isBDO the is b d o
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f user role
	* @throws it.ethica.esf.NoSuchUserRoleException if a matching e s f user role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFUserRole findByBDO_First(boolean isBDO,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserRoleException;

	/**
	* Returns the first e s f user role in the ordered set where isBDO = &#63;.
	*
	* @param isBDO the is b d o
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f user role, or <code>null</code> if a matching e s f user role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFUserRole fetchByBDO_First(boolean isBDO,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f user role in the ordered set where isBDO = &#63;.
	*
	* @param isBDO the is b d o
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f user role
	* @throws it.ethica.esf.NoSuchUserRoleException if a matching e s f user role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFUserRole findByBDO_Last(boolean isBDO,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserRoleException;

	/**
	* Returns the last e s f user role in the ordered set where isBDO = &#63;.
	*
	* @param isBDO the is b d o
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f user role, or <code>null</code> if a matching e s f user role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFUserRole fetchByBDO_Last(boolean isBDO,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f user roles before and after the current e s f user role in the ordered set where isBDO = &#63;.
	*
	* @param esfUserRoleId the primary key of the current e s f user role
	* @param isBDO the is b d o
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f user role
	* @throws it.ethica.esf.NoSuchUserRoleException if a e s f user role with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFUserRole[] findByBDO_PrevAndNext(
		long esfUserRoleId, boolean isBDO,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserRoleException;

	/**
	* Removes all the e s f user roles where isBDO = &#63; from the database.
	*
	* @param isBDO the is b d o
	* @throws SystemException if a system exception occurred
	*/
	public void removeByBDO(boolean isBDO)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f user roles where isBDO = &#63;.
	*
	* @param isBDO the is b d o
	* @return the number of matching e s f user roles
	* @throws SystemException if a system exception occurred
	*/
	public int countByBDO(boolean isBDO)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f user roles where isLEA = &#63;.
	*
	* @param isLEA the is l e a
	* @return the matching e s f user roles
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFUserRole> findByLEA(
		boolean isLEA)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f user roles where isLEA = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param isLEA the is l e a
	* @param start the lower bound of the range of e s f user roles
	* @param end the upper bound of the range of e s f user roles (not inclusive)
	* @return the range of matching e s f user roles
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFUserRole> findByLEA(
		boolean isLEA, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f user roles where isLEA = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param isLEA the is l e a
	* @param start the lower bound of the range of e s f user roles
	* @param end the upper bound of the range of e s f user roles (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f user roles
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFUserRole> findByLEA(
		boolean isLEA, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f user role in the ordered set where isLEA = &#63;.
	*
	* @param isLEA the is l e a
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f user role
	* @throws it.ethica.esf.NoSuchUserRoleException if a matching e s f user role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFUserRole findByLEA_First(boolean isLEA,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserRoleException;

	/**
	* Returns the first e s f user role in the ordered set where isLEA = &#63;.
	*
	* @param isLEA the is l e a
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f user role, or <code>null</code> if a matching e s f user role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFUserRole fetchByLEA_First(boolean isLEA,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f user role in the ordered set where isLEA = &#63;.
	*
	* @param isLEA the is l e a
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f user role
	* @throws it.ethica.esf.NoSuchUserRoleException if a matching e s f user role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFUserRole findByLEA_Last(boolean isLEA,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserRoleException;

	/**
	* Returns the last e s f user role in the ordered set where isLEA = &#63;.
	*
	* @param isLEA the is l e a
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f user role, or <code>null</code> if a matching e s f user role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFUserRole fetchByLEA_Last(boolean isLEA,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f user roles before and after the current e s f user role in the ordered set where isLEA = &#63;.
	*
	* @param esfUserRoleId the primary key of the current e s f user role
	* @param isLEA the is l e a
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f user role
	* @throws it.ethica.esf.NoSuchUserRoleException if a e s f user role with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFUserRole[] findByLEA_PrevAndNext(
		long esfUserRoleId, boolean isLEA,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserRoleException;

	/**
	* Removes all the e s f user roles where isLEA = &#63; from the database.
	*
	* @param isLEA the is l e a
	* @throws SystemException if a system exception occurred
	*/
	public void removeByLEA(boolean isLEA)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f user roles where isLEA = &#63;.
	*
	* @param isLEA the is l e a
	* @return the number of matching e s f user roles
	* @throws SystemException if a system exception occurred
	*/
	public int countByLEA(boolean isLEA)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the e s f user role in the entity cache if it is enabled.
	*
	* @param esfUserRole the e s f user role
	*/
	public void cacheResult(it.ethica.esf.model.ESFUserRole esfUserRole);

	/**
	* Caches the e s f user roles in the entity cache if it is enabled.
	*
	* @param esfUserRoles the e s f user roles
	*/
	public void cacheResult(
		java.util.List<it.ethica.esf.model.ESFUserRole> esfUserRoles);

	/**
	* Creates a new e s f user role with the primary key. Does not add the e s f user role to the database.
	*
	* @param esfUserRoleId the primary key for the new e s f user role
	* @return the new e s f user role
	*/
	public it.ethica.esf.model.ESFUserRole create(long esfUserRoleId);

	/**
	* Removes the e s f user role with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfUserRoleId the primary key of the e s f user role
	* @return the e s f user role that was removed
	* @throws it.ethica.esf.NoSuchUserRoleException if a e s f user role with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFUserRole remove(long esfUserRoleId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserRoleException;

	public it.ethica.esf.model.ESFUserRole updateImpl(
		it.ethica.esf.model.ESFUserRole esfUserRole)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f user role with the primary key or throws a {@link it.ethica.esf.NoSuchUserRoleException} if it could not be found.
	*
	* @param esfUserRoleId the primary key of the e s f user role
	* @return the e s f user role
	* @throws it.ethica.esf.NoSuchUserRoleException if a e s f user role with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFUserRole findByPrimaryKey(long esfUserRoleId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserRoleException;

	/**
	* Returns the e s f user role with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param esfUserRoleId the primary key of the e s f user role
	* @return the e s f user role, or <code>null</code> if a e s f user role with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFUserRole fetchByPrimaryKey(long esfUserRoleId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f user roles.
	*
	* @return the e s f user roles
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFUserRole> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f user roles.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f user roles
	* @param end the upper bound of the range of e s f user roles (not inclusive)
	* @return the range of e s f user roles
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFUserRole> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f user roles.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f user roles
	* @param end the upper bound of the range of e s f user roles (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of e s f user roles
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFUserRole> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the e s f user roles from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f user roles.
	*
	* @return the number of e s f user roles
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}