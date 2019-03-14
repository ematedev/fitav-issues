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

import it.ethica.esf.model.ESFGunKind;

/**
 * The persistence interface for the e s f gun kind service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFGunKindPersistenceImpl
 * @see ESFGunKindUtil
 * @generated
 */
public interface ESFGunKindPersistence extends BasePersistence<ESFGunKind> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ESFGunKindUtil} to access the e s f gun kind persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the e s f gun kinds where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching e s f gun kinds
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFGunKind> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f gun kinds where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFGunKindModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of e s f gun kinds
	* @param end the upper bound of the range of e s f gun kinds (not inclusive)
	* @return the range of matching e s f gun kinds
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFGunKind> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f gun kinds where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFGunKindModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of e s f gun kinds
	* @param end the upper bound of the range of e s f gun kinds (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f gun kinds
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFGunKind> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f gun kind in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f gun kind
	* @throws it.ethica.esf.NoSuchGunKindException if a matching e s f gun kind could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFGunKind findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchGunKindException;

	/**
	* Returns the first e s f gun kind in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f gun kind, or <code>null</code> if a matching e s f gun kind could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFGunKind fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f gun kind in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f gun kind
	* @throws it.ethica.esf.NoSuchGunKindException if a matching e s f gun kind could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFGunKind findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchGunKindException;

	/**
	* Returns the last e s f gun kind in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f gun kind, or <code>null</code> if a matching e s f gun kind could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFGunKind fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f gun kinds before and after the current e s f gun kind in the ordered set where uuid = &#63;.
	*
	* @param esfGunKindId the primary key of the current e s f gun kind
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f gun kind
	* @throws it.ethica.esf.NoSuchGunKindException if a e s f gun kind with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFGunKind[] findByUuid_PrevAndNext(
		long esfGunKindId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchGunKindException;

	/**
	* Removes all the e s f gun kinds where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f gun kinds where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching e s f gun kinds
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f gun kind where uuid = &#63; and groupId = &#63; or throws a {@link it.ethica.esf.NoSuchGunKindException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching e s f gun kind
	* @throws it.ethica.esf.NoSuchGunKindException if a matching e s f gun kind could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFGunKind findByUUID_G(java.lang.String uuid,
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchGunKindException;

	/**
	* Returns the e s f gun kind where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching e s f gun kind, or <code>null</code> if a matching e s f gun kind could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFGunKind fetchByUUID_G(java.lang.String uuid,
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f gun kind where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching e s f gun kind, or <code>null</code> if a matching e s f gun kind could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFGunKind fetchByUUID_G(java.lang.String uuid,
		long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the e s f gun kind where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the e s f gun kind that was removed
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFGunKind removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchGunKindException;

	/**
	* Returns the number of e s f gun kinds where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching e s f gun kinds
	* @throws SystemException if a system exception occurred
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f gun kinds where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching e s f gun kinds
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFGunKind> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f gun kinds where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFGunKindModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of e s f gun kinds
	* @param end the upper bound of the range of e s f gun kinds (not inclusive)
	* @return the range of matching e s f gun kinds
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFGunKind> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f gun kinds where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFGunKindModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of e s f gun kinds
	* @param end the upper bound of the range of e s f gun kinds (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f gun kinds
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFGunKind> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f gun kind in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f gun kind
	* @throws it.ethica.esf.NoSuchGunKindException if a matching e s f gun kind could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFGunKind findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchGunKindException;

	/**
	* Returns the first e s f gun kind in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f gun kind, or <code>null</code> if a matching e s f gun kind could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFGunKind fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f gun kind in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f gun kind
	* @throws it.ethica.esf.NoSuchGunKindException if a matching e s f gun kind could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFGunKind findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchGunKindException;

	/**
	* Returns the last e s f gun kind in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f gun kind, or <code>null</code> if a matching e s f gun kind could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFGunKind fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f gun kinds before and after the current e s f gun kind in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param esfGunKindId the primary key of the current e s f gun kind
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f gun kind
	* @throws it.ethica.esf.NoSuchGunKindException if a e s f gun kind with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFGunKind[] findByUuid_C_PrevAndNext(
		long esfGunKindId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchGunKindException;

	/**
	* Removes all the e s f gun kinds where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f gun kinds where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching e s f gun kinds
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f gun kinds where esfGunTypeId = &#63;.
	*
	* @param esfGunTypeId the esf gun type ID
	* @return the matching e s f gun kinds
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFGunKind> findByEsfGunTypeId(
		long esfGunTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f gun kinds where esfGunTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFGunKindModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfGunTypeId the esf gun type ID
	* @param start the lower bound of the range of e s f gun kinds
	* @param end the upper bound of the range of e s f gun kinds (not inclusive)
	* @return the range of matching e s f gun kinds
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFGunKind> findByEsfGunTypeId(
		long esfGunTypeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f gun kinds where esfGunTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFGunKindModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfGunTypeId the esf gun type ID
	* @param start the lower bound of the range of e s f gun kinds
	* @param end the upper bound of the range of e s f gun kinds (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f gun kinds
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFGunKind> findByEsfGunTypeId(
		long esfGunTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f gun kind in the ordered set where esfGunTypeId = &#63;.
	*
	* @param esfGunTypeId the esf gun type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f gun kind
	* @throws it.ethica.esf.NoSuchGunKindException if a matching e s f gun kind could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFGunKind findByEsfGunTypeId_First(
		long esfGunTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchGunKindException;

	/**
	* Returns the first e s f gun kind in the ordered set where esfGunTypeId = &#63;.
	*
	* @param esfGunTypeId the esf gun type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f gun kind, or <code>null</code> if a matching e s f gun kind could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFGunKind fetchByEsfGunTypeId_First(
		long esfGunTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f gun kind in the ordered set where esfGunTypeId = &#63;.
	*
	* @param esfGunTypeId the esf gun type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f gun kind
	* @throws it.ethica.esf.NoSuchGunKindException if a matching e s f gun kind could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFGunKind findByEsfGunTypeId_Last(
		long esfGunTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchGunKindException;

	/**
	* Returns the last e s f gun kind in the ordered set where esfGunTypeId = &#63;.
	*
	* @param esfGunTypeId the esf gun type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f gun kind, or <code>null</code> if a matching e s f gun kind could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFGunKind fetchByEsfGunTypeId_Last(
		long esfGunTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f gun kinds before and after the current e s f gun kind in the ordered set where esfGunTypeId = &#63;.
	*
	* @param esfGunKindId the primary key of the current e s f gun kind
	* @param esfGunTypeId the esf gun type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f gun kind
	* @throws it.ethica.esf.NoSuchGunKindException if a e s f gun kind with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFGunKind[] findByEsfGunTypeId_PrevAndNext(
		long esfGunKindId, long esfGunTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchGunKindException;

	/**
	* Removes all the e s f gun kinds where esfGunTypeId = &#63; from the database.
	*
	* @param esfGunTypeId the esf gun type ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByEsfGunTypeId(long esfGunTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f gun kinds where esfGunTypeId = &#63;.
	*
	* @param esfGunTypeId the esf gun type ID
	* @return the number of matching e s f gun kinds
	* @throws SystemException if a system exception occurred
	*/
	public int countByEsfGunTypeId(long esfGunTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the e s f gun kind in the entity cache if it is enabled.
	*
	* @param esfGunKind the e s f gun kind
	*/
	public void cacheResult(it.ethica.esf.model.ESFGunKind esfGunKind);

	/**
	* Caches the e s f gun kinds in the entity cache if it is enabled.
	*
	* @param esfGunKinds the e s f gun kinds
	*/
	public void cacheResult(
		java.util.List<it.ethica.esf.model.ESFGunKind> esfGunKinds);

	/**
	* Creates a new e s f gun kind with the primary key. Does not add the e s f gun kind to the database.
	*
	* @param esfGunKindId the primary key for the new e s f gun kind
	* @return the new e s f gun kind
	*/
	public it.ethica.esf.model.ESFGunKind create(long esfGunKindId);

	/**
	* Removes the e s f gun kind with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfGunKindId the primary key of the e s f gun kind
	* @return the e s f gun kind that was removed
	* @throws it.ethica.esf.NoSuchGunKindException if a e s f gun kind with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFGunKind remove(long esfGunKindId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchGunKindException;

	public it.ethica.esf.model.ESFGunKind updateImpl(
		it.ethica.esf.model.ESFGunKind esfGunKind)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f gun kind with the primary key or throws a {@link it.ethica.esf.NoSuchGunKindException} if it could not be found.
	*
	* @param esfGunKindId the primary key of the e s f gun kind
	* @return the e s f gun kind
	* @throws it.ethica.esf.NoSuchGunKindException if a e s f gun kind with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFGunKind findByPrimaryKey(long esfGunKindId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchGunKindException;

	/**
	* Returns the e s f gun kind with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param esfGunKindId the primary key of the e s f gun kind
	* @return the e s f gun kind, or <code>null</code> if a e s f gun kind with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFGunKind fetchByPrimaryKey(long esfGunKindId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f gun kinds.
	*
	* @return the e s f gun kinds
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFGunKind> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f gun kinds.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFGunKindModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f gun kinds
	* @param end the upper bound of the range of e s f gun kinds (not inclusive)
	* @return the range of e s f gun kinds
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFGunKind> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f gun kinds.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFGunKindModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f gun kinds
	* @param end the upper bound of the range of e s f gun kinds (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of e s f gun kinds
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFGunKind> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the e s f gun kinds from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f gun kinds.
	*
	* @return the number of e s f gun kinds
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}