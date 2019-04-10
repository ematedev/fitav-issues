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

import it.ethica.esf.model.ESFPartecipant;

/**
 * The persistence interface for the e s f partecipant service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFPartecipantPersistenceImpl
 * @see ESFPartecipantUtil
 * @generated
 */
public interface ESFPartecipantPersistence extends BasePersistence<ESFPartecipant> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ESFPartecipantUtil} to access the e s f partecipant persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the e s f partecipants where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching e s f partecipants
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFPartecipant> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f partecipants where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFPartecipantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of e s f partecipants
	* @param end the upper bound of the range of e s f partecipants (not inclusive)
	* @return the range of matching e s f partecipants
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFPartecipant> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f partecipants where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFPartecipantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of e s f partecipants
	* @param end the upper bound of the range of e s f partecipants (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f partecipants
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFPartecipant> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f partecipant in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f partecipant
	* @throws it.ethica.esf.NoSuchPartecipantException if a matching e s f partecipant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFPartecipant findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchPartecipantException;

	/**
	* Returns the first e s f partecipant in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f partecipant, or <code>null</code> if a matching e s f partecipant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFPartecipant fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f partecipant in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f partecipant
	* @throws it.ethica.esf.NoSuchPartecipantException if a matching e s f partecipant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFPartecipant findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchPartecipantException;

	/**
	* Returns the last e s f partecipant in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f partecipant, or <code>null</code> if a matching e s f partecipant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFPartecipant fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f partecipants before and after the current e s f partecipant in the ordered set where uuid = &#63;.
	*
	* @param esfPartecipantId the primary key of the current e s f partecipant
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f partecipant
	* @throws it.ethica.esf.NoSuchPartecipantException if a e s f partecipant with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFPartecipant[] findByUuid_PrevAndNext(
		long esfPartecipantId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchPartecipantException;

	/**
	* Removes all the e s f partecipants where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f partecipants where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching e s f partecipants
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f partecipant where uuid = &#63; and groupId = &#63; or throws a {@link it.ethica.esf.NoSuchPartecipantException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching e s f partecipant
	* @throws it.ethica.esf.NoSuchPartecipantException if a matching e s f partecipant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFPartecipant findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchPartecipantException;

	/**
	* Returns the e s f partecipant where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching e s f partecipant, or <code>null</code> if a matching e s f partecipant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFPartecipant fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f partecipant where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching e s f partecipant, or <code>null</code> if a matching e s f partecipant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFPartecipant fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the e s f partecipant where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the e s f partecipant that was removed
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFPartecipant removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchPartecipantException;

	/**
	* Returns the number of e s f partecipants where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching e s f partecipants
	* @throws SystemException if a system exception occurred
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f partecipants where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching e s f partecipants
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFPartecipant> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f partecipants where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFPartecipantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of e s f partecipants
	* @param end the upper bound of the range of e s f partecipants (not inclusive)
	* @return the range of matching e s f partecipants
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFPartecipant> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f partecipants where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFPartecipantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of e s f partecipants
	* @param end the upper bound of the range of e s f partecipants (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f partecipants
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFPartecipant> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f partecipant in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f partecipant
	* @throws it.ethica.esf.NoSuchPartecipantException if a matching e s f partecipant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFPartecipant findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchPartecipantException;

	/**
	* Returns the first e s f partecipant in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f partecipant, or <code>null</code> if a matching e s f partecipant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFPartecipant fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f partecipant in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f partecipant
	* @throws it.ethica.esf.NoSuchPartecipantException if a matching e s f partecipant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFPartecipant findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchPartecipantException;

	/**
	* Returns the last e s f partecipant in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f partecipant, or <code>null</code> if a matching e s f partecipant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFPartecipant fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f partecipants before and after the current e s f partecipant in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param esfPartecipantId the primary key of the current e s f partecipant
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f partecipant
	* @throws it.ethica.esf.NoSuchPartecipantException if a e s f partecipant with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFPartecipant[] findByUuid_C_PrevAndNext(
		long esfPartecipantId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchPartecipantException;

	/**
	* Removes all the e s f partecipants where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f partecipants where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching e s f partecipants
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f partecipants where esfMatchId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @return the matching e s f partecipants
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFPartecipant> findByMatch(
		long esfMatchId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f partecipants where esfMatchId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFPartecipantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfMatchId the esf match ID
	* @param start the lower bound of the range of e s f partecipants
	* @param end the upper bound of the range of e s f partecipants (not inclusive)
	* @return the range of matching e s f partecipants
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFPartecipant> findByMatch(
		long esfMatchId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f partecipants where esfMatchId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFPartecipantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfMatchId the esf match ID
	* @param start the lower bound of the range of e s f partecipants
	* @param end the upper bound of the range of e s f partecipants (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f partecipants
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFPartecipant> findByMatch(
		long esfMatchId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f partecipant in the ordered set where esfMatchId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f partecipant
	* @throws it.ethica.esf.NoSuchPartecipantException if a matching e s f partecipant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFPartecipant findByMatch_First(
		long esfMatchId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchPartecipantException;

	/**
	* Returns the first e s f partecipant in the ordered set where esfMatchId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f partecipant, or <code>null</code> if a matching e s f partecipant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFPartecipant fetchByMatch_First(
		long esfMatchId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f partecipant in the ordered set where esfMatchId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f partecipant
	* @throws it.ethica.esf.NoSuchPartecipantException if a matching e s f partecipant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFPartecipant findByMatch_Last(
		long esfMatchId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchPartecipantException;

	/**
	* Returns the last e s f partecipant in the ordered set where esfMatchId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f partecipant, or <code>null</code> if a matching e s f partecipant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFPartecipant fetchByMatch_Last(
		long esfMatchId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f partecipants before and after the current e s f partecipant in the ordered set where esfMatchId = &#63;.
	*
	* @param esfPartecipantId the primary key of the current e s f partecipant
	* @param esfMatchId the esf match ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f partecipant
	* @throws it.ethica.esf.NoSuchPartecipantException if a e s f partecipant with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFPartecipant[] findByMatch_PrevAndNext(
		long esfPartecipantId, long esfMatchId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchPartecipantException;

	/**
	* Removes all the e s f partecipants where esfMatchId = &#63; from the database.
	*
	* @param esfMatchId the esf match ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByMatch(long esfMatchId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f partecipants where esfMatchId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @return the number of matching e s f partecipants
	* @throws SystemException if a system exception occurred
	*/
	public int countByMatch(long esfMatchId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f partecipants where esfMatchId = &#63; and esfPartecipantTypeId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfPartecipantTypeId the esf partecipant type ID
	* @return the matching e s f partecipants
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFPartecipant> findByM_T(
		long esfMatchId, long esfPartecipantTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f partecipants where esfMatchId = &#63; and esfPartecipantTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFPartecipantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfMatchId the esf match ID
	* @param esfPartecipantTypeId the esf partecipant type ID
	* @param start the lower bound of the range of e s f partecipants
	* @param end the upper bound of the range of e s f partecipants (not inclusive)
	* @return the range of matching e s f partecipants
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFPartecipant> findByM_T(
		long esfMatchId, long esfPartecipantTypeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f partecipants where esfMatchId = &#63; and esfPartecipantTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFPartecipantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfMatchId the esf match ID
	* @param esfPartecipantTypeId the esf partecipant type ID
	* @param start the lower bound of the range of e s f partecipants
	* @param end the upper bound of the range of e s f partecipants (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f partecipants
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFPartecipant> findByM_T(
		long esfMatchId, long esfPartecipantTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f partecipant in the ordered set where esfMatchId = &#63; and esfPartecipantTypeId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfPartecipantTypeId the esf partecipant type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f partecipant
	* @throws it.ethica.esf.NoSuchPartecipantException if a matching e s f partecipant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFPartecipant findByM_T_First(long esfMatchId,
		long esfPartecipantTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchPartecipantException;

	/**
	* Returns the first e s f partecipant in the ordered set where esfMatchId = &#63; and esfPartecipantTypeId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfPartecipantTypeId the esf partecipant type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f partecipant, or <code>null</code> if a matching e s f partecipant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFPartecipant fetchByM_T_First(
		long esfMatchId, long esfPartecipantTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f partecipant in the ordered set where esfMatchId = &#63; and esfPartecipantTypeId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfPartecipantTypeId the esf partecipant type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f partecipant
	* @throws it.ethica.esf.NoSuchPartecipantException if a matching e s f partecipant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFPartecipant findByM_T_Last(long esfMatchId,
		long esfPartecipantTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchPartecipantException;

	/**
	* Returns the last e s f partecipant in the ordered set where esfMatchId = &#63; and esfPartecipantTypeId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfPartecipantTypeId the esf partecipant type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f partecipant, or <code>null</code> if a matching e s f partecipant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFPartecipant fetchByM_T_Last(long esfMatchId,
		long esfPartecipantTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f partecipants before and after the current e s f partecipant in the ordered set where esfMatchId = &#63; and esfPartecipantTypeId = &#63;.
	*
	* @param esfPartecipantId the primary key of the current e s f partecipant
	* @param esfMatchId the esf match ID
	* @param esfPartecipantTypeId the esf partecipant type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f partecipant
	* @throws it.ethica.esf.NoSuchPartecipantException if a e s f partecipant with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFPartecipant[] findByM_T_PrevAndNext(
		long esfPartecipantId, long esfMatchId, long esfPartecipantTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchPartecipantException;

	/**
	* Removes all the e s f partecipants where esfMatchId = &#63; and esfPartecipantTypeId = &#63; from the database.
	*
	* @param esfMatchId the esf match ID
	* @param esfPartecipantTypeId the esf partecipant type ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByM_T(long esfMatchId, long esfPartecipantTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f partecipants where esfMatchId = &#63; and esfPartecipantTypeId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfPartecipantTypeId the esf partecipant type ID
	* @return the number of matching e s f partecipants
	* @throws SystemException if a system exception occurred
	*/
	public int countByM_T(long esfMatchId, long esfPartecipantTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f partecipant where esfUserId = &#63; and esfMatchId = &#63; and esfPartecipantTypeId = &#63; or throws a {@link it.ethica.esf.NoSuchPartecipantException} if it could not be found.
	*
	* @param esfUserId the esf user ID
	* @param esfMatchId the esf match ID
	* @param esfPartecipantTypeId the esf partecipant type ID
	* @return the matching e s f partecipant
	* @throws it.ethica.esf.NoSuchPartecipantException if a matching e s f partecipant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFPartecipant findByU_M_T(long esfUserId,
		long esfMatchId, long esfPartecipantTypeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchPartecipantException;

	/**
	* Returns the e s f partecipant where esfUserId = &#63; and esfMatchId = &#63; and esfPartecipantTypeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param esfUserId the esf user ID
	* @param esfMatchId the esf match ID
	* @param esfPartecipantTypeId the esf partecipant type ID
	* @return the matching e s f partecipant, or <code>null</code> if a matching e s f partecipant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFPartecipant fetchByU_M_T(long esfUserId,
		long esfMatchId, long esfPartecipantTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f partecipant where esfUserId = &#63; and esfMatchId = &#63; and esfPartecipantTypeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param esfUserId the esf user ID
	* @param esfMatchId the esf match ID
	* @param esfPartecipantTypeId the esf partecipant type ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching e s f partecipant, or <code>null</code> if a matching e s f partecipant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFPartecipant fetchByU_M_T(long esfUserId,
		long esfMatchId, long esfPartecipantTypeId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the e s f partecipant where esfUserId = &#63; and esfMatchId = &#63; and esfPartecipantTypeId = &#63; from the database.
	*
	* @param esfUserId the esf user ID
	* @param esfMatchId the esf match ID
	* @param esfPartecipantTypeId the esf partecipant type ID
	* @return the e s f partecipant that was removed
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFPartecipant removeByU_M_T(long esfUserId,
		long esfMatchId, long esfPartecipantTypeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchPartecipantException;

	/**
	* Returns the number of e s f partecipants where esfUserId = &#63; and esfMatchId = &#63; and esfPartecipantTypeId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param esfMatchId the esf match ID
	* @param esfPartecipantTypeId the esf partecipant type ID
	* @return the number of matching e s f partecipants
	* @throws SystemException if a system exception occurred
	*/
	public int countByU_M_T(long esfUserId, long esfMatchId,
		long esfPartecipantTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f partecipant where userId = &#63; or throws a {@link it.ethica.esf.NoSuchPartecipantException} if it could not be found.
	*
	* @param userId the user ID
	* @return the matching e s f partecipant
	* @throws it.ethica.esf.NoSuchPartecipantException if a matching e s f partecipant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFPartecipant findByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchPartecipantException;

	/**
	* Returns the e s f partecipant where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userId the user ID
	* @return the matching e s f partecipant, or <code>null</code> if a matching e s f partecipant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFPartecipant fetchByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f partecipant where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userId the user ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching e s f partecipant, or <code>null</code> if a matching e s f partecipant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFPartecipant fetchByUserId(long userId,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the e s f partecipant where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @return the e s f partecipant that was removed
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFPartecipant removeByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchPartecipantException;

	/**
	* Returns the number of e s f partecipants where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching e s f partecipants
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the e s f partecipant in the entity cache if it is enabled.
	*
	* @param esfPartecipant the e s f partecipant
	*/
	public void cacheResult(it.ethica.esf.model.ESFPartecipant esfPartecipant);

	/**
	* Caches the e s f partecipants in the entity cache if it is enabled.
	*
	* @param esfPartecipants the e s f partecipants
	*/
	public void cacheResult(
		java.util.List<it.ethica.esf.model.ESFPartecipant> esfPartecipants);

	/**
	* Creates a new e s f partecipant with the primary key. Does not add the e s f partecipant to the database.
	*
	* @param esfPartecipantId the primary key for the new e s f partecipant
	* @return the new e s f partecipant
	*/
	public it.ethica.esf.model.ESFPartecipant create(long esfPartecipantId);

	/**
	* Removes the e s f partecipant with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfPartecipantId the primary key of the e s f partecipant
	* @return the e s f partecipant that was removed
	* @throws it.ethica.esf.NoSuchPartecipantException if a e s f partecipant with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFPartecipant remove(long esfPartecipantId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchPartecipantException;

	public it.ethica.esf.model.ESFPartecipant updateImpl(
		it.ethica.esf.model.ESFPartecipant esfPartecipant)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f partecipant with the primary key or throws a {@link it.ethica.esf.NoSuchPartecipantException} if it could not be found.
	*
	* @param esfPartecipantId the primary key of the e s f partecipant
	* @return the e s f partecipant
	* @throws it.ethica.esf.NoSuchPartecipantException if a e s f partecipant with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFPartecipant findByPrimaryKey(
		long esfPartecipantId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchPartecipantException;

	/**
	* Returns the e s f partecipant with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param esfPartecipantId the primary key of the e s f partecipant
	* @return the e s f partecipant, or <code>null</code> if a e s f partecipant with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFPartecipant fetchByPrimaryKey(
		long esfPartecipantId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f partecipants.
	*
	* @return the e s f partecipants
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFPartecipant> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f partecipants.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFPartecipantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f partecipants
	* @param end the upper bound of the range of e s f partecipants (not inclusive)
	* @return the range of e s f partecipants
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFPartecipant> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f partecipants.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFPartecipantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f partecipants
	* @param end the upper bound of the range of e s f partecipants (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of e s f partecipants
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFPartecipant> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the e s f partecipants from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f partecipants.
	*
	* @return the number of e s f partecipants
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}