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

import it.ethica.esf.model.ESFNationalDelegation;

/**
 * The persistence interface for the e s f national delegation service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFNationalDelegationPersistenceImpl
 * @see ESFNationalDelegationUtil
 * @generated
 */
public interface ESFNationalDelegationPersistence extends BasePersistence<ESFNationalDelegation> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ESFNationalDelegationUtil} to access the e s f national delegation persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the e s f national delegations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching e s f national delegations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFNationalDelegation> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f national delegations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalDelegationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of e s f national delegations
	* @param end the upper bound of the range of e s f national delegations (not inclusive)
	* @return the range of matching e s f national delegations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFNationalDelegation> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f national delegations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalDelegationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of e s f national delegations
	* @param end the upper bound of the range of e s f national delegations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f national delegations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFNationalDelegation> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f national delegation in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f national delegation
	* @throws it.ethica.esf.NoSuchNationalDelegationException if a matching e s f national delegation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFNationalDelegation findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalDelegationException;

	/**
	* Returns the first e s f national delegation in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f national delegation, or <code>null</code> if a matching e s f national delegation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFNationalDelegation fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f national delegation in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f national delegation
	* @throws it.ethica.esf.NoSuchNationalDelegationException if a matching e s f national delegation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFNationalDelegation findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalDelegationException;

	/**
	* Returns the last e s f national delegation in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f national delegation, or <code>null</code> if a matching e s f national delegation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFNationalDelegation fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f national delegations before and after the current e s f national delegation in the ordered set where uuid = &#63;.
	*
	* @param esfNationalDelgationId the primary key of the current e s f national delegation
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f national delegation
	* @throws it.ethica.esf.NoSuchNationalDelegationException if a e s f national delegation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFNationalDelegation[] findByUuid_PrevAndNext(
		long esfNationalDelgationId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalDelegationException;

	/**
	* Removes all the e s f national delegations where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f national delegations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching e s f national delegations
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f national delegation where uuid = &#63; and groupId = &#63; or throws a {@link it.ethica.esf.NoSuchNationalDelegationException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching e s f national delegation
	* @throws it.ethica.esf.NoSuchNationalDelegationException if a matching e s f national delegation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFNationalDelegation findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalDelegationException;

	/**
	* Returns the e s f national delegation where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching e s f national delegation, or <code>null</code> if a matching e s f national delegation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFNationalDelegation fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f national delegation where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching e s f national delegation, or <code>null</code> if a matching e s f national delegation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFNationalDelegation fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the e s f national delegation where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the e s f national delegation that was removed
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFNationalDelegation removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalDelegationException;

	/**
	* Returns the number of e s f national delegations where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching e s f national delegations
	* @throws SystemException if a system exception occurred
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f national delegations where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching e s f national delegations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFNationalDelegation> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f national delegations where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalDelegationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of e s f national delegations
	* @param end the upper bound of the range of e s f national delegations (not inclusive)
	* @return the range of matching e s f national delegations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFNationalDelegation> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f national delegations where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalDelegationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of e s f national delegations
	* @param end the upper bound of the range of e s f national delegations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f national delegations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFNationalDelegation> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f national delegation in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f national delegation
	* @throws it.ethica.esf.NoSuchNationalDelegationException if a matching e s f national delegation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFNationalDelegation findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalDelegationException;

	/**
	* Returns the first e s f national delegation in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f national delegation, or <code>null</code> if a matching e s f national delegation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFNationalDelegation fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f national delegation in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f national delegation
	* @throws it.ethica.esf.NoSuchNationalDelegationException if a matching e s f national delegation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFNationalDelegation findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalDelegationException;

	/**
	* Returns the last e s f national delegation in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f national delegation, or <code>null</code> if a matching e s f national delegation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFNationalDelegation fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f national delegations before and after the current e s f national delegation in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param esfNationalDelgationId the primary key of the current e s f national delegation
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f national delegation
	* @throws it.ethica.esf.NoSuchNationalDelegationException if a e s f national delegation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFNationalDelegation[] findByUuid_C_PrevAndNext(
		long esfNationalDelgationId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalDelegationException;

	/**
	* Removes all the e s f national delegations where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f national delegations where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching e s f national delegations
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f national delegations where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @return the matching e s f national delegations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFNationalDelegation> findByESFUser(
		long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f national delegations where esfUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalDelegationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfUserId the esf user ID
	* @param start the lower bound of the range of e s f national delegations
	* @param end the upper bound of the range of e s f national delegations (not inclusive)
	* @return the range of matching e s f national delegations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFNationalDelegation> findByESFUser(
		long esfUserId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f national delegations where esfUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalDelegationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfUserId the esf user ID
	* @param start the lower bound of the range of e s f national delegations
	* @param end the upper bound of the range of e s f national delegations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f national delegations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFNationalDelegation> findByESFUser(
		long esfUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f national delegation in the ordered set where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f national delegation
	* @throws it.ethica.esf.NoSuchNationalDelegationException if a matching e s f national delegation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFNationalDelegation findByESFUser_First(
		long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalDelegationException;

	/**
	* Returns the first e s f national delegation in the ordered set where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f national delegation, or <code>null</code> if a matching e s f national delegation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFNationalDelegation fetchByESFUser_First(
		long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f national delegation in the ordered set where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f national delegation
	* @throws it.ethica.esf.NoSuchNationalDelegationException if a matching e s f national delegation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFNationalDelegation findByESFUser_Last(
		long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalDelegationException;

	/**
	* Returns the last e s f national delegation in the ordered set where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f national delegation, or <code>null</code> if a matching e s f national delegation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFNationalDelegation fetchByESFUser_Last(
		long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f national delegations before and after the current e s f national delegation in the ordered set where esfUserId = &#63;.
	*
	* @param esfNationalDelgationId the primary key of the current e s f national delegation
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f national delegation
	* @throws it.ethica.esf.NoSuchNationalDelegationException if a e s f national delegation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFNationalDelegation[] findByESFUser_PrevAndNext(
		long esfNationalDelgationId, long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalDelegationException;

	/**
	* Removes all the e s f national delegations where esfUserId = &#63; from the database.
	*
	* @param esfUserId the esf user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByESFUser(long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f national delegations where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @return the number of matching e s f national delegations
	* @throws SystemException if a system exception occurred
	*/
	public int countByESFUser(long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f national delegations where esfUserId = &#63; and leaveDate &gt; &#63;.
	*
	* @param esfUserId the esf user ID
	* @param leaveDate the leave date
	* @return the matching e s f national delegations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFNationalDelegation> findByU_L(
		long esfUserId, java.util.Date leaveDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f national delegations where esfUserId = &#63; and leaveDate &gt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalDelegationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfUserId the esf user ID
	* @param leaveDate the leave date
	* @param start the lower bound of the range of e s f national delegations
	* @param end the upper bound of the range of e s f national delegations (not inclusive)
	* @return the range of matching e s f national delegations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFNationalDelegation> findByU_L(
		long esfUserId, java.util.Date leaveDate, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f national delegations where esfUserId = &#63; and leaveDate &gt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalDelegationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfUserId the esf user ID
	* @param leaveDate the leave date
	* @param start the lower bound of the range of e s f national delegations
	* @param end the upper bound of the range of e s f national delegations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f national delegations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFNationalDelegation> findByU_L(
		long esfUserId, java.util.Date leaveDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f national delegation in the ordered set where esfUserId = &#63; and leaveDate &gt; &#63;.
	*
	* @param esfUserId the esf user ID
	* @param leaveDate the leave date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f national delegation
	* @throws it.ethica.esf.NoSuchNationalDelegationException if a matching e s f national delegation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFNationalDelegation findByU_L_First(
		long esfUserId, java.util.Date leaveDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalDelegationException;

	/**
	* Returns the first e s f national delegation in the ordered set where esfUserId = &#63; and leaveDate &gt; &#63;.
	*
	* @param esfUserId the esf user ID
	* @param leaveDate the leave date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f national delegation, or <code>null</code> if a matching e s f national delegation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFNationalDelegation fetchByU_L_First(
		long esfUserId, java.util.Date leaveDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f national delegation in the ordered set where esfUserId = &#63; and leaveDate &gt; &#63;.
	*
	* @param esfUserId the esf user ID
	* @param leaveDate the leave date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f national delegation
	* @throws it.ethica.esf.NoSuchNationalDelegationException if a matching e s f national delegation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFNationalDelegation findByU_L_Last(
		long esfUserId, java.util.Date leaveDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalDelegationException;

	/**
	* Returns the last e s f national delegation in the ordered set where esfUserId = &#63; and leaveDate &gt; &#63;.
	*
	* @param esfUserId the esf user ID
	* @param leaveDate the leave date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f national delegation, or <code>null</code> if a matching e s f national delegation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFNationalDelegation fetchByU_L_Last(
		long esfUserId, java.util.Date leaveDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f national delegations before and after the current e s f national delegation in the ordered set where esfUserId = &#63; and leaveDate &gt; &#63;.
	*
	* @param esfNationalDelgationId the primary key of the current e s f national delegation
	* @param esfUserId the esf user ID
	* @param leaveDate the leave date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f national delegation
	* @throws it.ethica.esf.NoSuchNationalDelegationException if a e s f national delegation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFNationalDelegation[] findByU_L_PrevAndNext(
		long esfNationalDelgationId, long esfUserId, java.util.Date leaveDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalDelegationException;

	/**
	* Removes all the e s f national delegations where esfUserId = &#63; and leaveDate &gt; &#63; from the database.
	*
	* @param esfUserId the esf user ID
	* @param leaveDate the leave date
	* @throws SystemException if a system exception occurred
	*/
	public void removeByU_L(long esfUserId, java.util.Date leaveDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f national delegations where esfUserId = &#63; and leaveDate &gt; &#63;.
	*
	* @param esfUserId the esf user ID
	* @param leaveDate the leave date
	* @return the number of matching e s f national delegations
	* @throws SystemException if a system exception occurred
	*/
	public int countByU_L(long esfUserId, java.util.Date leaveDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f national delegations where esfMatchId = &#63; and esfPartecipantTypeId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfPartecipantTypeId the esf partecipant type ID
	* @return the matching e s f national delegations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFNationalDelegation> findByESFMatchESFPartecipantType(
		long esfMatchId, long esfPartecipantTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f national delegations where esfMatchId = &#63; and esfPartecipantTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalDelegationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfMatchId the esf match ID
	* @param esfPartecipantTypeId the esf partecipant type ID
	* @param start the lower bound of the range of e s f national delegations
	* @param end the upper bound of the range of e s f national delegations (not inclusive)
	* @return the range of matching e s f national delegations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFNationalDelegation> findByESFMatchESFPartecipantType(
		long esfMatchId, long esfPartecipantTypeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f national delegations where esfMatchId = &#63; and esfPartecipantTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalDelegationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfMatchId the esf match ID
	* @param esfPartecipantTypeId the esf partecipant type ID
	* @param start the lower bound of the range of e s f national delegations
	* @param end the upper bound of the range of e s f national delegations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f national delegations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFNationalDelegation> findByESFMatchESFPartecipantType(
		long esfMatchId, long esfPartecipantTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f national delegation in the ordered set where esfMatchId = &#63; and esfPartecipantTypeId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfPartecipantTypeId the esf partecipant type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f national delegation
	* @throws it.ethica.esf.NoSuchNationalDelegationException if a matching e s f national delegation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFNationalDelegation findByESFMatchESFPartecipantType_First(
		long esfMatchId, long esfPartecipantTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalDelegationException;

	/**
	* Returns the first e s f national delegation in the ordered set where esfMatchId = &#63; and esfPartecipantTypeId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfPartecipantTypeId the esf partecipant type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f national delegation, or <code>null</code> if a matching e s f national delegation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFNationalDelegation fetchByESFMatchESFPartecipantType_First(
		long esfMatchId, long esfPartecipantTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f national delegation in the ordered set where esfMatchId = &#63; and esfPartecipantTypeId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfPartecipantTypeId the esf partecipant type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f national delegation
	* @throws it.ethica.esf.NoSuchNationalDelegationException if a matching e s f national delegation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFNationalDelegation findByESFMatchESFPartecipantType_Last(
		long esfMatchId, long esfPartecipantTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalDelegationException;

	/**
	* Returns the last e s f national delegation in the ordered set where esfMatchId = &#63; and esfPartecipantTypeId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfPartecipantTypeId the esf partecipant type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f national delegation, or <code>null</code> if a matching e s f national delegation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFNationalDelegation fetchByESFMatchESFPartecipantType_Last(
		long esfMatchId, long esfPartecipantTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f national delegations before and after the current e s f national delegation in the ordered set where esfMatchId = &#63; and esfPartecipantTypeId = &#63;.
	*
	* @param esfNationalDelgationId the primary key of the current e s f national delegation
	* @param esfMatchId the esf match ID
	* @param esfPartecipantTypeId the esf partecipant type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f national delegation
	* @throws it.ethica.esf.NoSuchNationalDelegationException if a e s f national delegation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFNationalDelegation[] findByESFMatchESFPartecipantType_PrevAndNext(
		long esfNationalDelgationId, long esfMatchId,
		long esfPartecipantTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalDelegationException;

	/**
	* Removes all the e s f national delegations where esfMatchId = &#63; and esfPartecipantTypeId = &#63; from the database.
	*
	* @param esfMatchId the esf match ID
	* @param esfPartecipantTypeId the esf partecipant type ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByESFMatchESFPartecipantType(long esfMatchId,
		long esfPartecipantTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f national delegations where esfMatchId = &#63; and esfPartecipantTypeId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfPartecipantTypeId the esf partecipant type ID
	* @return the number of matching e s f national delegations
	* @throws SystemException if a system exception occurred
	*/
	public int countByESFMatchESFPartecipantType(long esfMatchId,
		long esfPartecipantTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f national delegations where esfUserId = &#63; and esfMatchId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param esfMatchId the esf match ID
	* @return the matching e s f national delegations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFNationalDelegation> findByESFMatch_U(
		long esfUserId, long esfMatchId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f national delegations where esfUserId = &#63; and esfMatchId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalDelegationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfUserId the esf user ID
	* @param esfMatchId the esf match ID
	* @param start the lower bound of the range of e s f national delegations
	* @param end the upper bound of the range of e s f national delegations (not inclusive)
	* @return the range of matching e s f national delegations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFNationalDelegation> findByESFMatch_U(
		long esfUserId, long esfMatchId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f national delegations where esfUserId = &#63; and esfMatchId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalDelegationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfUserId the esf user ID
	* @param esfMatchId the esf match ID
	* @param start the lower bound of the range of e s f national delegations
	* @param end the upper bound of the range of e s f national delegations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f national delegations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFNationalDelegation> findByESFMatch_U(
		long esfUserId, long esfMatchId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f national delegation in the ordered set where esfUserId = &#63; and esfMatchId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param esfMatchId the esf match ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f national delegation
	* @throws it.ethica.esf.NoSuchNationalDelegationException if a matching e s f national delegation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFNationalDelegation findByESFMatch_U_First(
		long esfUserId, long esfMatchId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalDelegationException;

	/**
	* Returns the first e s f national delegation in the ordered set where esfUserId = &#63; and esfMatchId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param esfMatchId the esf match ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f national delegation, or <code>null</code> if a matching e s f national delegation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFNationalDelegation fetchByESFMatch_U_First(
		long esfUserId, long esfMatchId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f national delegation in the ordered set where esfUserId = &#63; and esfMatchId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param esfMatchId the esf match ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f national delegation
	* @throws it.ethica.esf.NoSuchNationalDelegationException if a matching e s f national delegation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFNationalDelegation findByESFMatch_U_Last(
		long esfUserId, long esfMatchId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalDelegationException;

	/**
	* Returns the last e s f national delegation in the ordered set where esfUserId = &#63; and esfMatchId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param esfMatchId the esf match ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f national delegation, or <code>null</code> if a matching e s f national delegation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFNationalDelegation fetchByESFMatch_U_Last(
		long esfUserId, long esfMatchId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f national delegations before and after the current e s f national delegation in the ordered set where esfUserId = &#63; and esfMatchId = &#63;.
	*
	* @param esfNationalDelgationId the primary key of the current e s f national delegation
	* @param esfUserId the esf user ID
	* @param esfMatchId the esf match ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f national delegation
	* @throws it.ethica.esf.NoSuchNationalDelegationException if a e s f national delegation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFNationalDelegation[] findByESFMatch_U_PrevAndNext(
		long esfNationalDelgationId, long esfUserId, long esfMatchId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalDelegationException;

	/**
	* Removes all the e s f national delegations where esfUserId = &#63; and esfMatchId = &#63; from the database.
	*
	* @param esfUserId the esf user ID
	* @param esfMatchId the esf match ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByESFMatch_U(long esfUserId, long esfMatchId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f national delegations where esfUserId = &#63; and esfMatchId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param esfMatchId the esf match ID
	* @return the number of matching e s f national delegations
	* @throws SystemException if a system exception occurred
	*/
	public int countByESFMatch_U(long esfUserId, long esfMatchId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f national delegations where esfUserId = &#63; and esfMatchId = &#63; and esfPartecipantTypeId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param esfMatchId the esf match ID
	* @param esfPartecipantTypeId the esf partecipant type ID
	* @return the matching e s f national delegations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFNationalDelegation> findByESFMatch_U_T(
		long esfUserId, long esfMatchId, long esfPartecipantTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f national delegations where esfUserId = &#63; and esfMatchId = &#63; and esfPartecipantTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalDelegationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfUserId the esf user ID
	* @param esfMatchId the esf match ID
	* @param esfPartecipantTypeId the esf partecipant type ID
	* @param start the lower bound of the range of e s f national delegations
	* @param end the upper bound of the range of e s f national delegations (not inclusive)
	* @return the range of matching e s f national delegations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFNationalDelegation> findByESFMatch_U_T(
		long esfUserId, long esfMatchId, long esfPartecipantTypeId, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f national delegations where esfUserId = &#63; and esfMatchId = &#63; and esfPartecipantTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalDelegationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfUserId the esf user ID
	* @param esfMatchId the esf match ID
	* @param esfPartecipantTypeId the esf partecipant type ID
	* @param start the lower bound of the range of e s f national delegations
	* @param end the upper bound of the range of e s f national delegations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f national delegations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFNationalDelegation> findByESFMatch_U_T(
		long esfUserId, long esfMatchId, long esfPartecipantTypeId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f national delegation in the ordered set where esfUserId = &#63; and esfMatchId = &#63; and esfPartecipantTypeId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param esfMatchId the esf match ID
	* @param esfPartecipantTypeId the esf partecipant type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f national delegation
	* @throws it.ethica.esf.NoSuchNationalDelegationException if a matching e s f national delegation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFNationalDelegation findByESFMatch_U_T_First(
		long esfUserId, long esfMatchId, long esfPartecipantTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalDelegationException;

	/**
	* Returns the first e s f national delegation in the ordered set where esfUserId = &#63; and esfMatchId = &#63; and esfPartecipantTypeId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param esfMatchId the esf match ID
	* @param esfPartecipantTypeId the esf partecipant type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f national delegation, or <code>null</code> if a matching e s f national delegation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFNationalDelegation fetchByESFMatch_U_T_First(
		long esfUserId, long esfMatchId, long esfPartecipantTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f national delegation in the ordered set where esfUserId = &#63; and esfMatchId = &#63; and esfPartecipantTypeId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param esfMatchId the esf match ID
	* @param esfPartecipantTypeId the esf partecipant type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f national delegation
	* @throws it.ethica.esf.NoSuchNationalDelegationException if a matching e s f national delegation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFNationalDelegation findByESFMatch_U_T_Last(
		long esfUserId, long esfMatchId, long esfPartecipantTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalDelegationException;

	/**
	* Returns the last e s f national delegation in the ordered set where esfUserId = &#63; and esfMatchId = &#63; and esfPartecipantTypeId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param esfMatchId the esf match ID
	* @param esfPartecipantTypeId the esf partecipant type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f national delegation, or <code>null</code> if a matching e s f national delegation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFNationalDelegation fetchByESFMatch_U_T_Last(
		long esfUserId, long esfMatchId, long esfPartecipantTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f national delegations before and after the current e s f national delegation in the ordered set where esfUserId = &#63; and esfMatchId = &#63; and esfPartecipantTypeId = &#63;.
	*
	* @param esfNationalDelgationId the primary key of the current e s f national delegation
	* @param esfUserId the esf user ID
	* @param esfMatchId the esf match ID
	* @param esfPartecipantTypeId the esf partecipant type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f national delegation
	* @throws it.ethica.esf.NoSuchNationalDelegationException if a e s f national delegation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFNationalDelegation[] findByESFMatch_U_T_PrevAndNext(
		long esfNationalDelgationId, long esfUserId, long esfMatchId,
		long esfPartecipantTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalDelegationException;

	/**
	* Removes all the e s f national delegations where esfUserId = &#63; and esfMatchId = &#63; and esfPartecipantTypeId = &#63; from the database.
	*
	* @param esfUserId the esf user ID
	* @param esfMatchId the esf match ID
	* @param esfPartecipantTypeId the esf partecipant type ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByESFMatch_U_T(long esfUserId, long esfMatchId,
		long esfPartecipantTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f national delegations where esfUserId = &#63; and esfMatchId = &#63; and esfPartecipantTypeId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param esfMatchId the esf match ID
	* @param esfPartecipantTypeId the esf partecipant type ID
	* @return the number of matching e s f national delegations
	* @throws SystemException if a system exception occurred
	*/
	public int countByESFMatch_U_T(long esfUserId, long esfMatchId,
		long esfPartecipantTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f national delegations where esfMatchId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @return the matching e s f national delegations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFNationalDelegation> findByESFMatch(
		long esfMatchId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f national delegations where esfMatchId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalDelegationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfMatchId the esf match ID
	* @param start the lower bound of the range of e s f national delegations
	* @param end the upper bound of the range of e s f national delegations (not inclusive)
	* @return the range of matching e s f national delegations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFNationalDelegation> findByESFMatch(
		long esfMatchId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f national delegations where esfMatchId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalDelegationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfMatchId the esf match ID
	* @param start the lower bound of the range of e s f national delegations
	* @param end the upper bound of the range of e s f national delegations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f national delegations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFNationalDelegation> findByESFMatch(
		long esfMatchId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f national delegation in the ordered set where esfMatchId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f national delegation
	* @throws it.ethica.esf.NoSuchNationalDelegationException if a matching e s f national delegation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFNationalDelegation findByESFMatch_First(
		long esfMatchId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalDelegationException;

	/**
	* Returns the first e s f national delegation in the ordered set where esfMatchId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f national delegation, or <code>null</code> if a matching e s f national delegation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFNationalDelegation fetchByESFMatch_First(
		long esfMatchId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f national delegation in the ordered set where esfMatchId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f national delegation
	* @throws it.ethica.esf.NoSuchNationalDelegationException if a matching e s f national delegation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFNationalDelegation findByESFMatch_Last(
		long esfMatchId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalDelegationException;

	/**
	* Returns the last e s f national delegation in the ordered set where esfMatchId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f national delegation, or <code>null</code> if a matching e s f national delegation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFNationalDelegation fetchByESFMatch_Last(
		long esfMatchId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f national delegations before and after the current e s f national delegation in the ordered set where esfMatchId = &#63;.
	*
	* @param esfNationalDelgationId the primary key of the current e s f national delegation
	* @param esfMatchId the esf match ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f national delegation
	* @throws it.ethica.esf.NoSuchNationalDelegationException if a e s f national delegation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFNationalDelegation[] findByESFMatch_PrevAndNext(
		long esfNationalDelgationId, long esfMatchId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalDelegationException;

	/**
	* Removes all the e s f national delegations where esfMatchId = &#63; from the database.
	*
	* @param esfMatchId the esf match ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByESFMatch(long esfMatchId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f national delegations where esfMatchId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @return the number of matching e s f national delegations
	* @throws SystemException if a system exception occurred
	*/
	public int countByESFMatch(long esfMatchId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f national delegations where esfUserId = &#63; and esfPartecipantTypeId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param esfPartecipantTypeId the esf partecipant type ID
	* @return the matching e s f national delegations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFNationalDelegation> findByPartecipantType_EsfUserId(
		long esfUserId, long esfPartecipantTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f national delegations where esfUserId = &#63; and esfPartecipantTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalDelegationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfUserId the esf user ID
	* @param esfPartecipantTypeId the esf partecipant type ID
	* @param start the lower bound of the range of e s f national delegations
	* @param end the upper bound of the range of e s f national delegations (not inclusive)
	* @return the range of matching e s f national delegations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFNationalDelegation> findByPartecipantType_EsfUserId(
		long esfUserId, long esfPartecipantTypeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f national delegations where esfUserId = &#63; and esfPartecipantTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalDelegationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfUserId the esf user ID
	* @param esfPartecipantTypeId the esf partecipant type ID
	* @param start the lower bound of the range of e s f national delegations
	* @param end the upper bound of the range of e s f national delegations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f national delegations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFNationalDelegation> findByPartecipantType_EsfUserId(
		long esfUserId, long esfPartecipantTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f national delegation in the ordered set where esfUserId = &#63; and esfPartecipantTypeId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param esfPartecipantTypeId the esf partecipant type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f national delegation
	* @throws it.ethica.esf.NoSuchNationalDelegationException if a matching e s f national delegation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFNationalDelegation findByPartecipantType_EsfUserId_First(
		long esfUserId, long esfPartecipantTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalDelegationException;

	/**
	* Returns the first e s f national delegation in the ordered set where esfUserId = &#63; and esfPartecipantTypeId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param esfPartecipantTypeId the esf partecipant type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f national delegation, or <code>null</code> if a matching e s f national delegation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFNationalDelegation fetchByPartecipantType_EsfUserId_First(
		long esfUserId, long esfPartecipantTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f national delegation in the ordered set where esfUserId = &#63; and esfPartecipantTypeId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param esfPartecipantTypeId the esf partecipant type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f national delegation
	* @throws it.ethica.esf.NoSuchNationalDelegationException if a matching e s f national delegation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFNationalDelegation findByPartecipantType_EsfUserId_Last(
		long esfUserId, long esfPartecipantTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalDelegationException;

	/**
	* Returns the last e s f national delegation in the ordered set where esfUserId = &#63; and esfPartecipantTypeId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param esfPartecipantTypeId the esf partecipant type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f national delegation, or <code>null</code> if a matching e s f national delegation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFNationalDelegation fetchByPartecipantType_EsfUserId_Last(
		long esfUserId, long esfPartecipantTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f national delegations before and after the current e s f national delegation in the ordered set where esfUserId = &#63; and esfPartecipantTypeId = &#63;.
	*
	* @param esfNationalDelgationId the primary key of the current e s f national delegation
	* @param esfUserId the esf user ID
	* @param esfPartecipantTypeId the esf partecipant type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f national delegation
	* @throws it.ethica.esf.NoSuchNationalDelegationException if a e s f national delegation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFNationalDelegation[] findByPartecipantType_EsfUserId_PrevAndNext(
		long esfNationalDelgationId, long esfUserId, long esfPartecipantTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalDelegationException;

	/**
	* Removes all the e s f national delegations where esfUserId = &#63; and esfPartecipantTypeId = &#63; from the database.
	*
	* @param esfUserId the esf user ID
	* @param esfPartecipantTypeId the esf partecipant type ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByPartecipantType_EsfUserId(long esfUserId,
		long esfPartecipantTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f national delegations where esfUserId = &#63; and esfPartecipantTypeId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param esfPartecipantTypeId the esf partecipant type ID
	* @return the number of matching e s f national delegations
	* @throws SystemException if a system exception occurred
	*/
	public int countByPartecipantType_EsfUserId(long esfUserId,
		long esfPartecipantTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f national delegations where esfSportTypeId = &#63; and esfMatchId = &#63; and esfPartecipantTypeId = &#63;.
	*
	* @param esfSportTypeId the esf sport type ID
	* @param esfMatchId the esf match ID
	* @param esfPartecipantTypeId the esf partecipant type ID
	* @return the matching e s f national delegations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFNationalDelegation> findByPartecipantType_MatchId_SportTypeId(
		long esfSportTypeId, long esfMatchId, long esfPartecipantTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f national delegations where esfSportTypeId = &#63; and esfMatchId = &#63; and esfPartecipantTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalDelegationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfSportTypeId the esf sport type ID
	* @param esfMatchId the esf match ID
	* @param esfPartecipantTypeId the esf partecipant type ID
	* @param start the lower bound of the range of e s f national delegations
	* @param end the upper bound of the range of e s f national delegations (not inclusive)
	* @return the range of matching e s f national delegations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFNationalDelegation> findByPartecipantType_MatchId_SportTypeId(
		long esfSportTypeId, long esfMatchId, long esfPartecipantTypeId,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f national delegations where esfSportTypeId = &#63; and esfMatchId = &#63; and esfPartecipantTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalDelegationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfSportTypeId the esf sport type ID
	* @param esfMatchId the esf match ID
	* @param esfPartecipantTypeId the esf partecipant type ID
	* @param start the lower bound of the range of e s f national delegations
	* @param end the upper bound of the range of e s f national delegations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f national delegations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFNationalDelegation> findByPartecipantType_MatchId_SportTypeId(
		long esfSportTypeId, long esfMatchId, long esfPartecipantTypeId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f national delegation in the ordered set where esfSportTypeId = &#63; and esfMatchId = &#63; and esfPartecipantTypeId = &#63;.
	*
	* @param esfSportTypeId the esf sport type ID
	* @param esfMatchId the esf match ID
	* @param esfPartecipantTypeId the esf partecipant type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f national delegation
	* @throws it.ethica.esf.NoSuchNationalDelegationException if a matching e s f national delegation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFNationalDelegation findByPartecipantType_MatchId_SportTypeId_First(
		long esfSportTypeId, long esfMatchId, long esfPartecipantTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalDelegationException;

	/**
	* Returns the first e s f national delegation in the ordered set where esfSportTypeId = &#63; and esfMatchId = &#63; and esfPartecipantTypeId = &#63;.
	*
	* @param esfSportTypeId the esf sport type ID
	* @param esfMatchId the esf match ID
	* @param esfPartecipantTypeId the esf partecipant type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f national delegation, or <code>null</code> if a matching e s f national delegation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFNationalDelegation fetchByPartecipantType_MatchId_SportTypeId_First(
		long esfSportTypeId, long esfMatchId, long esfPartecipantTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f national delegation in the ordered set where esfSportTypeId = &#63; and esfMatchId = &#63; and esfPartecipantTypeId = &#63;.
	*
	* @param esfSportTypeId the esf sport type ID
	* @param esfMatchId the esf match ID
	* @param esfPartecipantTypeId the esf partecipant type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f national delegation
	* @throws it.ethica.esf.NoSuchNationalDelegationException if a matching e s f national delegation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFNationalDelegation findByPartecipantType_MatchId_SportTypeId_Last(
		long esfSportTypeId, long esfMatchId, long esfPartecipantTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalDelegationException;

	/**
	* Returns the last e s f national delegation in the ordered set where esfSportTypeId = &#63; and esfMatchId = &#63; and esfPartecipantTypeId = &#63;.
	*
	* @param esfSportTypeId the esf sport type ID
	* @param esfMatchId the esf match ID
	* @param esfPartecipantTypeId the esf partecipant type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f national delegation, or <code>null</code> if a matching e s f national delegation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFNationalDelegation fetchByPartecipantType_MatchId_SportTypeId_Last(
		long esfSportTypeId, long esfMatchId, long esfPartecipantTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f national delegations before and after the current e s f national delegation in the ordered set where esfSportTypeId = &#63; and esfMatchId = &#63; and esfPartecipantTypeId = &#63;.
	*
	* @param esfNationalDelgationId the primary key of the current e s f national delegation
	* @param esfSportTypeId the esf sport type ID
	* @param esfMatchId the esf match ID
	* @param esfPartecipantTypeId the esf partecipant type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f national delegation
	* @throws it.ethica.esf.NoSuchNationalDelegationException if a e s f national delegation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFNationalDelegation[] findByPartecipantType_MatchId_SportTypeId_PrevAndNext(
		long esfNationalDelgationId, long esfSportTypeId, long esfMatchId,
		long esfPartecipantTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalDelegationException;

	/**
	* Removes all the e s f national delegations where esfSportTypeId = &#63; and esfMatchId = &#63; and esfPartecipantTypeId = &#63; from the database.
	*
	* @param esfSportTypeId the esf sport type ID
	* @param esfMatchId the esf match ID
	* @param esfPartecipantTypeId the esf partecipant type ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByPartecipantType_MatchId_SportTypeId(
		long esfSportTypeId, long esfMatchId, long esfPartecipantTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f national delegations where esfSportTypeId = &#63; and esfMatchId = &#63; and esfPartecipantTypeId = &#63;.
	*
	* @param esfSportTypeId the esf sport type ID
	* @param esfMatchId the esf match ID
	* @param esfPartecipantTypeId the esf partecipant type ID
	* @return the number of matching e s f national delegations
	* @throws SystemException if a system exception occurred
	*/
	public int countByPartecipantType_MatchId_SportTypeId(long esfSportTypeId,
		long esfMatchId, long esfPartecipantTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f national delegations where esfMatchId = &#63; and esfSportTypeId = &#63; and esfShooterQualificationId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfSportTypeId the esf sport type ID
	* @param esfShooterQualificationId the esf shooter qualification ID
	* @return the matching e s f national delegations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFNationalDelegation> findByMatchId_SportTypeId_QualificationId(
		long esfMatchId, long esfSportTypeId, long esfShooterQualificationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f national delegations where esfMatchId = &#63; and esfSportTypeId = &#63; and esfShooterQualificationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalDelegationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfMatchId the esf match ID
	* @param esfSportTypeId the esf sport type ID
	* @param esfShooterQualificationId the esf shooter qualification ID
	* @param start the lower bound of the range of e s f national delegations
	* @param end the upper bound of the range of e s f national delegations (not inclusive)
	* @return the range of matching e s f national delegations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFNationalDelegation> findByMatchId_SportTypeId_QualificationId(
		long esfMatchId, long esfSportTypeId, long esfShooterQualificationId,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f national delegations where esfMatchId = &#63; and esfSportTypeId = &#63; and esfShooterQualificationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalDelegationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfMatchId the esf match ID
	* @param esfSportTypeId the esf sport type ID
	* @param esfShooterQualificationId the esf shooter qualification ID
	* @param start the lower bound of the range of e s f national delegations
	* @param end the upper bound of the range of e s f national delegations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f national delegations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFNationalDelegation> findByMatchId_SportTypeId_QualificationId(
		long esfMatchId, long esfSportTypeId, long esfShooterQualificationId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f national delegation in the ordered set where esfMatchId = &#63; and esfSportTypeId = &#63; and esfShooterQualificationId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfSportTypeId the esf sport type ID
	* @param esfShooterQualificationId the esf shooter qualification ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f national delegation
	* @throws it.ethica.esf.NoSuchNationalDelegationException if a matching e s f national delegation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFNationalDelegation findByMatchId_SportTypeId_QualificationId_First(
		long esfMatchId, long esfSportTypeId, long esfShooterQualificationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalDelegationException;

	/**
	* Returns the first e s f national delegation in the ordered set where esfMatchId = &#63; and esfSportTypeId = &#63; and esfShooterQualificationId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfSportTypeId the esf sport type ID
	* @param esfShooterQualificationId the esf shooter qualification ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f national delegation, or <code>null</code> if a matching e s f national delegation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFNationalDelegation fetchByMatchId_SportTypeId_QualificationId_First(
		long esfMatchId, long esfSportTypeId, long esfShooterQualificationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f national delegation in the ordered set where esfMatchId = &#63; and esfSportTypeId = &#63; and esfShooterQualificationId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfSportTypeId the esf sport type ID
	* @param esfShooterQualificationId the esf shooter qualification ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f national delegation
	* @throws it.ethica.esf.NoSuchNationalDelegationException if a matching e s f national delegation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFNationalDelegation findByMatchId_SportTypeId_QualificationId_Last(
		long esfMatchId, long esfSportTypeId, long esfShooterQualificationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalDelegationException;

	/**
	* Returns the last e s f national delegation in the ordered set where esfMatchId = &#63; and esfSportTypeId = &#63; and esfShooterQualificationId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfSportTypeId the esf sport type ID
	* @param esfShooterQualificationId the esf shooter qualification ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f national delegation, or <code>null</code> if a matching e s f national delegation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFNationalDelegation fetchByMatchId_SportTypeId_QualificationId_Last(
		long esfMatchId, long esfSportTypeId, long esfShooterQualificationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f national delegations before and after the current e s f national delegation in the ordered set where esfMatchId = &#63; and esfSportTypeId = &#63; and esfShooterQualificationId = &#63;.
	*
	* @param esfNationalDelgationId the primary key of the current e s f national delegation
	* @param esfMatchId the esf match ID
	* @param esfSportTypeId the esf sport type ID
	* @param esfShooterQualificationId the esf shooter qualification ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f national delegation
	* @throws it.ethica.esf.NoSuchNationalDelegationException if a e s f national delegation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFNationalDelegation[] findByMatchId_SportTypeId_QualificationId_PrevAndNext(
		long esfNationalDelgationId, long esfMatchId, long esfSportTypeId,
		long esfShooterQualificationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalDelegationException;

	/**
	* Removes all the e s f national delegations where esfMatchId = &#63; and esfSportTypeId = &#63; and esfShooterQualificationId = &#63; from the database.
	*
	* @param esfMatchId the esf match ID
	* @param esfSportTypeId the esf sport type ID
	* @param esfShooterQualificationId the esf shooter qualification ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByMatchId_SportTypeId_QualificationId(long esfMatchId,
		long esfSportTypeId, long esfShooterQualificationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f national delegations where esfMatchId = &#63; and esfSportTypeId = &#63; and esfShooterQualificationId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfSportTypeId the esf sport type ID
	* @param esfShooterQualificationId the esf shooter qualification ID
	* @return the number of matching e s f national delegations
	* @throws SystemException if a system exception occurred
	*/
	public int countByMatchId_SportTypeId_QualificationId(long esfMatchId,
		long esfSportTypeId, long esfShooterQualificationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f national delegation where esfMatchId = &#63; and esfUserId = &#63; and esfSportTypeId = &#63; and esfShooterQualificationId = &#63; or throws a {@link it.ethica.esf.NoSuchNationalDelegationException} if it could not be found.
	*
	* @param esfMatchId the esf match ID
	* @param esfUserId the esf user ID
	* @param esfSportTypeId the esf sport type ID
	* @param esfShooterQualificationId the esf shooter qualification ID
	* @return the matching e s f national delegation
	* @throws it.ethica.esf.NoSuchNationalDelegationException if a matching e s f national delegation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFNationalDelegation findByMatchId_UserId_SportTypeId_QualificationId(
		long esfMatchId, long esfUserId, long esfSportTypeId,
		long esfShooterQualificationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalDelegationException;

	/**
	* Returns the e s f national delegation where esfMatchId = &#63; and esfUserId = &#63; and esfSportTypeId = &#63; and esfShooterQualificationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param esfMatchId the esf match ID
	* @param esfUserId the esf user ID
	* @param esfSportTypeId the esf sport type ID
	* @param esfShooterQualificationId the esf shooter qualification ID
	* @return the matching e s f national delegation, or <code>null</code> if a matching e s f national delegation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFNationalDelegation fetchByMatchId_UserId_SportTypeId_QualificationId(
		long esfMatchId, long esfUserId, long esfSportTypeId,
		long esfShooterQualificationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f national delegation where esfMatchId = &#63; and esfUserId = &#63; and esfSportTypeId = &#63; and esfShooterQualificationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param esfMatchId the esf match ID
	* @param esfUserId the esf user ID
	* @param esfSportTypeId the esf sport type ID
	* @param esfShooterQualificationId the esf shooter qualification ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching e s f national delegation, or <code>null</code> if a matching e s f national delegation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFNationalDelegation fetchByMatchId_UserId_SportTypeId_QualificationId(
		long esfMatchId, long esfUserId, long esfSportTypeId,
		long esfShooterQualificationId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the e s f national delegation where esfMatchId = &#63; and esfUserId = &#63; and esfSportTypeId = &#63; and esfShooterQualificationId = &#63; from the database.
	*
	* @param esfMatchId the esf match ID
	* @param esfUserId the esf user ID
	* @param esfSportTypeId the esf sport type ID
	* @param esfShooterQualificationId the esf shooter qualification ID
	* @return the e s f national delegation that was removed
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFNationalDelegation removeByMatchId_UserId_SportTypeId_QualificationId(
		long esfMatchId, long esfUserId, long esfSportTypeId,
		long esfShooterQualificationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalDelegationException;

	/**
	* Returns the number of e s f national delegations where esfMatchId = &#63; and esfUserId = &#63; and esfSportTypeId = &#63; and esfShooterQualificationId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfUserId the esf user ID
	* @param esfSportTypeId the esf sport type ID
	* @param esfShooterQualificationId the esf shooter qualification ID
	* @return the number of matching e s f national delegations
	* @throws SystemException if a system exception occurred
	*/
	public int countByMatchId_UserId_SportTypeId_QualificationId(
		long esfMatchId, long esfUserId, long esfSportTypeId,
		long esfShooterQualificationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the e s f national delegation in the entity cache if it is enabled.
	*
	* @param esfNationalDelegation the e s f national delegation
	*/
	public void cacheResult(
		it.ethica.esf.model.ESFNationalDelegation esfNationalDelegation);

	/**
	* Caches the e s f national delegations in the entity cache if it is enabled.
	*
	* @param esfNationalDelegations the e s f national delegations
	*/
	public void cacheResult(
		java.util.List<it.ethica.esf.model.ESFNationalDelegation> esfNationalDelegations);

	/**
	* Creates a new e s f national delegation with the primary key. Does not add the e s f national delegation to the database.
	*
	* @param esfNationalDelgationId the primary key for the new e s f national delegation
	* @return the new e s f national delegation
	*/
	public it.ethica.esf.model.ESFNationalDelegation create(
		long esfNationalDelgationId);

	/**
	* Removes the e s f national delegation with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfNationalDelgationId the primary key of the e s f national delegation
	* @return the e s f national delegation that was removed
	* @throws it.ethica.esf.NoSuchNationalDelegationException if a e s f national delegation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFNationalDelegation remove(
		long esfNationalDelgationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalDelegationException;

	public it.ethica.esf.model.ESFNationalDelegation updateImpl(
		it.ethica.esf.model.ESFNationalDelegation esfNationalDelegation)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f national delegation with the primary key or throws a {@link it.ethica.esf.NoSuchNationalDelegationException} if it could not be found.
	*
	* @param esfNationalDelgationId the primary key of the e s f national delegation
	* @return the e s f national delegation
	* @throws it.ethica.esf.NoSuchNationalDelegationException if a e s f national delegation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFNationalDelegation findByPrimaryKey(
		long esfNationalDelgationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalDelegationException;

	/**
	* Returns the e s f national delegation with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param esfNationalDelgationId the primary key of the e s f national delegation
	* @return the e s f national delegation, or <code>null</code> if a e s f national delegation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFNationalDelegation fetchByPrimaryKey(
		long esfNationalDelgationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f national delegations.
	*
	* @return the e s f national delegations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFNationalDelegation> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f national delegations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalDelegationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f national delegations
	* @param end the upper bound of the range of e s f national delegations (not inclusive)
	* @return the range of e s f national delegations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFNationalDelegation> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f national delegations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalDelegationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f national delegations
	* @param end the upper bound of the range of e s f national delegations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of e s f national delegations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFNationalDelegation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the e s f national delegations from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f national delegations.
	*
	* @return the number of e s f national delegations
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}