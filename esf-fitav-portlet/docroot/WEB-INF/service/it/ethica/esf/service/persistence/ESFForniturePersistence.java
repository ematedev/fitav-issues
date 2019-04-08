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

import it.ethica.esf.model.ESFForniture;

/**
 * The persistence interface for the e s f forniture service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFForniturePersistenceImpl
 * @see ESFFornitureUtil
 * @generated
 */
public interface ESFForniturePersistence extends BasePersistence<ESFForniture> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ESFFornitureUtil} to access the e s f forniture persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the e s f fornitures where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching e s f fornitures
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFForniture> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f fornitures where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFornitureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of e s f fornitures
	* @param end the upper bound of the range of e s f fornitures (not inclusive)
	* @return the range of matching e s f fornitures
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFForniture> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f fornitures where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFornitureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of e s f fornitures
	* @param end the upper bound of the range of e s f fornitures (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f fornitures
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFForniture> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f forniture in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f forniture
	* @throws it.ethica.esf.NoSuchFornitureException if a matching e s f forniture could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFForniture findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFornitureException;

	/**
	* Returns the first e s f forniture in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f forniture, or <code>null</code> if a matching e s f forniture could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFForniture fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f forniture in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f forniture
	* @throws it.ethica.esf.NoSuchFornitureException if a matching e s f forniture could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFForniture findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFornitureException;

	/**
	* Returns the last e s f forniture in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f forniture, or <code>null</code> if a matching e s f forniture could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFForniture fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f fornitures before and after the current e s f forniture in the ordered set where uuid = &#63;.
	*
	* @param esfFornitureId the primary key of the current e s f forniture
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f forniture
	* @throws it.ethica.esf.NoSuchFornitureException if a e s f forniture with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFForniture[] findByUuid_PrevAndNext(
		long esfFornitureId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFornitureException;

	/**
	* Removes all the e s f fornitures where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f fornitures where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching e s f fornitures
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f forniture where uuid = &#63; and groupId = &#63; or throws a {@link it.ethica.esf.NoSuchFornitureException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching e s f forniture
	* @throws it.ethica.esf.NoSuchFornitureException if a matching e s f forniture could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFForniture findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFornitureException;

	/**
	* Returns the e s f forniture where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching e s f forniture, or <code>null</code> if a matching e s f forniture could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFForniture fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f forniture where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching e s f forniture, or <code>null</code> if a matching e s f forniture could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFForniture fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the e s f forniture where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the e s f forniture that was removed
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFForniture removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFornitureException;

	/**
	* Returns the number of e s f fornitures where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching e s f fornitures
	* @throws SystemException if a system exception occurred
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f fornitures where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching e s f fornitures
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFForniture> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f fornitures where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFornitureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of e s f fornitures
	* @param end the upper bound of the range of e s f fornitures (not inclusive)
	* @return the range of matching e s f fornitures
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFForniture> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f fornitures where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFornitureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of e s f fornitures
	* @param end the upper bound of the range of e s f fornitures (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f fornitures
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFForniture> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f forniture in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f forniture
	* @throws it.ethica.esf.NoSuchFornitureException if a matching e s f forniture could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFForniture findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFornitureException;

	/**
	* Returns the first e s f forniture in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f forniture, or <code>null</code> if a matching e s f forniture could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFForniture fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f forniture in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f forniture
	* @throws it.ethica.esf.NoSuchFornitureException if a matching e s f forniture could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFForniture findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFornitureException;

	/**
	* Returns the last e s f forniture in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f forniture, or <code>null</code> if a matching e s f forniture could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFForniture fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f fornitures before and after the current e s f forniture in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param esfFornitureId the primary key of the current e s f forniture
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f forniture
	* @throws it.ethica.esf.NoSuchFornitureException if a e s f forniture with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFForniture[] findByUuid_C_PrevAndNext(
		long esfFornitureId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFornitureException;

	/**
	* Removes all the e s f fornitures where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f fornitures where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching e s f fornitures
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f fornitures where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching e s f fornitures
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFForniture> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f fornitures where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFornitureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of e s f fornitures
	* @param end the upper bound of the range of e s f fornitures (not inclusive)
	* @return the range of matching e s f fornitures
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFForniture> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f fornitures where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFornitureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of e s f fornitures
	* @param end the upper bound of the range of e s f fornitures (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f fornitures
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFForniture> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f forniture in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f forniture
	* @throws it.ethica.esf.NoSuchFornitureException if a matching e s f forniture could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFForniture findByGroupId_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFornitureException;

	/**
	* Returns the first e s f forniture in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f forniture, or <code>null</code> if a matching e s f forniture could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFForniture fetchByGroupId_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f forniture in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f forniture
	* @throws it.ethica.esf.NoSuchFornitureException if a matching e s f forniture could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFForniture findByGroupId_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFornitureException;

	/**
	* Returns the last e s f forniture in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f forniture, or <code>null</code> if a matching e s f forniture could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFForniture fetchByGroupId_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f fornitures before and after the current e s f forniture in the ordered set where groupId = &#63;.
	*
	* @param esfFornitureId the primary key of the current e s f forniture
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f forniture
	* @throws it.ethica.esf.NoSuchFornitureException if a e s f forniture with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFForniture[] findByGroupId_PrevAndNext(
		long esfFornitureId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFornitureException;

	/**
	* Removes all the e s f fornitures where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f fornitures where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching e s f fornitures
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f forniture where code = &#63; or throws a {@link it.ethica.esf.NoSuchFornitureException} if it could not be found.
	*
	* @param code the code
	* @return the matching e s f forniture
	* @throws it.ethica.esf.NoSuchFornitureException if a matching e s f forniture could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFForniture findByCode(java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFornitureException;

	/**
	* Returns the e s f forniture where code = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param code the code
	* @return the matching e s f forniture, or <code>null</code> if a matching e s f forniture could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFForniture fetchByCode(java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f forniture where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param code the code
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching e s f forniture, or <code>null</code> if a matching e s f forniture could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFForniture fetchByCode(java.lang.String code,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the e s f forniture where code = &#63; from the database.
	*
	* @param code the code
	* @return the e s f forniture that was removed
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFForniture removeByCode(java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFornitureException;

	/**
	* Returns the number of e s f fornitures where code = &#63;.
	*
	* @param code the code
	* @return the number of matching e s f fornitures
	* @throws SystemException if a system exception occurred
	*/
	public int countByCode(java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f fornitures where name = &#63;.
	*
	* @param name the name
	* @return the matching e s f fornitures
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFForniture> findByName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f fornitures where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFornitureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param name the name
	* @param start the lower bound of the range of e s f fornitures
	* @param end the upper bound of the range of e s f fornitures (not inclusive)
	* @return the range of matching e s f fornitures
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFForniture> findByName(
		java.lang.String name, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f fornitures where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFornitureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param name the name
	* @param start the lower bound of the range of e s f fornitures
	* @param end the upper bound of the range of e s f fornitures (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f fornitures
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFForniture> findByName(
		java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f forniture in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f forniture
	* @throws it.ethica.esf.NoSuchFornitureException if a matching e s f forniture could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFForniture findByName_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFornitureException;

	/**
	* Returns the first e s f forniture in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f forniture, or <code>null</code> if a matching e s f forniture could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFForniture fetchByName_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f forniture in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f forniture
	* @throws it.ethica.esf.NoSuchFornitureException if a matching e s f forniture could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFForniture findByName_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFornitureException;

	/**
	* Returns the last e s f forniture in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f forniture, or <code>null</code> if a matching e s f forniture could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFForniture fetchByName_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f fornitures before and after the current e s f forniture in the ordered set where name = &#63;.
	*
	* @param esfFornitureId the primary key of the current e s f forniture
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f forniture
	* @throws it.ethica.esf.NoSuchFornitureException if a e s f forniture with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFForniture[] findByName_PrevAndNext(
		long esfFornitureId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFornitureException;

	/**
	* Removes all the e s f fornitures where name = &#63; from the database.
	*
	* @param name the name
	* @throws SystemException if a system exception occurred
	*/
	public void removeByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f fornitures where name = &#63;.
	*
	* @param name the name
	* @return the number of matching e s f fornitures
	* @throws SystemException if a system exception occurred
	*/
	public int countByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f forniture where description = &#63; or throws a {@link it.ethica.esf.NoSuchFornitureException} if it could not be found.
	*
	* @param description the description
	* @return the matching e s f forniture
	* @throws it.ethica.esf.NoSuchFornitureException if a matching e s f forniture could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFForniture findByDescription(
		java.lang.String description)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFornitureException;

	/**
	* Returns the e s f forniture where description = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param description the description
	* @return the matching e s f forniture, or <code>null</code> if a matching e s f forniture could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFForniture fetchByDescription(
		java.lang.String description)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f forniture where description = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param description the description
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching e s f forniture, or <code>null</code> if a matching e s f forniture could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFForniture fetchByDescription(
		java.lang.String description, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the e s f forniture where description = &#63; from the database.
	*
	* @param description the description
	* @return the e s f forniture that was removed
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFForniture removeByDescription(
		java.lang.String description)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFornitureException;

	/**
	* Returns the number of e s f fornitures where description = &#63;.
	*
	* @param description the description
	* @return the number of matching e s f fornitures
	* @throws SystemException if a system exception occurred
	*/
	public int countByDescription(java.lang.String description)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f fornitures where type = &#63;.
	*
	* @param type the type
	* @return the matching e s f fornitures
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFForniture> findByType(
		long type) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f fornitures where type = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFornitureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param type the type
	* @param start the lower bound of the range of e s f fornitures
	* @param end the upper bound of the range of e s f fornitures (not inclusive)
	* @return the range of matching e s f fornitures
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFForniture> findByType(
		long type, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f fornitures where type = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFornitureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param type the type
	* @param start the lower bound of the range of e s f fornitures
	* @param end the upper bound of the range of e s f fornitures (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f fornitures
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFForniture> findByType(
		long type, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f forniture in the ordered set where type = &#63;.
	*
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f forniture
	* @throws it.ethica.esf.NoSuchFornitureException if a matching e s f forniture could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFForniture findByType_First(long type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFornitureException;

	/**
	* Returns the first e s f forniture in the ordered set where type = &#63;.
	*
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f forniture, or <code>null</code> if a matching e s f forniture could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFForniture fetchByType_First(long type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f forniture in the ordered set where type = &#63;.
	*
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f forniture
	* @throws it.ethica.esf.NoSuchFornitureException if a matching e s f forniture could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFForniture findByType_Last(long type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFornitureException;

	/**
	* Returns the last e s f forniture in the ordered set where type = &#63;.
	*
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f forniture, or <code>null</code> if a matching e s f forniture could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFForniture fetchByType_Last(long type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f fornitures before and after the current e s f forniture in the ordered set where type = &#63;.
	*
	* @param esfFornitureId the primary key of the current e s f forniture
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f forniture
	* @throws it.ethica.esf.NoSuchFornitureException if a e s f forniture with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFForniture[] findByType_PrevAndNext(
		long esfFornitureId, long type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFornitureException;

	/**
	* Removes all the e s f fornitures where type = &#63; from the database.
	*
	* @param type the type
	* @throws SystemException if a system exception occurred
	*/
	public void removeByType(long type)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f fornitures where type = &#63;.
	*
	* @param type the type
	* @return the number of matching e s f fornitures
	* @throws SystemException if a system exception occurred
	*/
	public int countByType(long type)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f fornitures where insertDate = &#63;.
	*
	* @param insertDate the insert date
	* @return the matching e s f fornitures
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFForniture> findByInsertDate(
		java.util.Date insertDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f fornitures where insertDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFornitureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param insertDate the insert date
	* @param start the lower bound of the range of e s f fornitures
	* @param end the upper bound of the range of e s f fornitures (not inclusive)
	* @return the range of matching e s f fornitures
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFForniture> findByInsertDate(
		java.util.Date insertDate, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f fornitures where insertDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFornitureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param insertDate the insert date
	* @param start the lower bound of the range of e s f fornitures
	* @param end the upper bound of the range of e s f fornitures (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f fornitures
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFForniture> findByInsertDate(
		java.util.Date insertDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f forniture in the ordered set where insertDate = &#63;.
	*
	* @param insertDate the insert date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f forniture
	* @throws it.ethica.esf.NoSuchFornitureException if a matching e s f forniture could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFForniture findByInsertDate_First(
		java.util.Date insertDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFornitureException;

	/**
	* Returns the first e s f forniture in the ordered set where insertDate = &#63;.
	*
	* @param insertDate the insert date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f forniture, or <code>null</code> if a matching e s f forniture could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFForniture fetchByInsertDate_First(
		java.util.Date insertDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f forniture in the ordered set where insertDate = &#63;.
	*
	* @param insertDate the insert date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f forniture
	* @throws it.ethica.esf.NoSuchFornitureException if a matching e s f forniture could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFForniture findByInsertDate_Last(
		java.util.Date insertDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFornitureException;

	/**
	* Returns the last e s f forniture in the ordered set where insertDate = &#63;.
	*
	* @param insertDate the insert date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f forniture, or <code>null</code> if a matching e s f forniture could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFForniture fetchByInsertDate_Last(
		java.util.Date insertDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f fornitures before and after the current e s f forniture in the ordered set where insertDate = &#63;.
	*
	* @param esfFornitureId the primary key of the current e s f forniture
	* @param insertDate the insert date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f forniture
	* @throws it.ethica.esf.NoSuchFornitureException if a e s f forniture with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFForniture[] findByInsertDate_PrevAndNext(
		long esfFornitureId, java.util.Date insertDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFornitureException;

	/**
	* Removes all the e s f fornitures where insertDate = &#63; from the database.
	*
	* @param insertDate the insert date
	* @throws SystemException if a system exception occurred
	*/
	public void removeByInsertDate(java.util.Date insertDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f fornitures where insertDate = &#63;.
	*
	* @param insertDate the insert date
	* @return the number of matching e s f fornitures
	* @throws SystemException if a system exception occurred
	*/
	public int countByInsertDate(java.util.Date insertDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f fornitures where numberFornitures = &#63;.
	*
	* @param numberFornitures the number fornitures
	* @return the matching e s f fornitures
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFForniture> findByNumberFornitures(
		long numberFornitures)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f fornitures where numberFornitures = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFornitureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param numberFornitures the number fornitures
	* @param start the lower bound of the range of e s f fornitures
	* @param end the upper bound of the range of e s f fornitures (not inclusive)
	* @return the range of matching e s f fornitures
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFForniture> findByNumberFornitures(
		long numberFornitures, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f fornitures where numberFornitures = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFornitureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param numberFornitures the number fornitures
	* @param start the lower bound of the range of e s f fornitures
	* @param end the upper bound of the range of e s f fornitures (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f fornitures
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFForniture> findByNumberFornitures(
		long numberFornitures, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f forniture in the ordered set where numberFornitures = &#63;.
	*
	* @param numberFornitures the number fornitures
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f forniture
	* @throws it.ethica.esf.NoSuchFornitureException if a matching e s f forniture could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFForniture findByNumberFornitures_First(
		long numberFornitures,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFornitureException;

	/**
	* Returns the first e s f forniture in the ordered set where numberFornitures = &#63;.
	*
	* @param numberFornitures the number fornitures
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f forniture, or <code>null</code> if a matching e s f forniture could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFForniture fetchByNumberFornitures_First(
		long numberFornitures,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f forniture in the ordered set where numberFornitures = &#63;.
	*
	* @param numberFornitures the number fornitures
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f forniture
	* @throws it.ethica.esf.NoSuchFornitureException if a matching e s f forniture could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFForniture findByNumberFornitures_Last(
		long numberFornitures,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFornitureException;

	/**
	* Returns the last e s f forniture in the ordered set where numberFornitures = &#63;.
	*
	* @param numberFornitures the number fornitures
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f forniture, or <code>null</code> if a matching e s f forniture could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFForniture fetchByNumberFornitures_Last(
		long numberFornitures,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f fornitures before and after the current e s f forniture in the ordered set where numberFornitures = &#63;.
	*
	* @param esfFornitureId the primary key of the current e s f forniture
	* @param numberFornitures the number fornitures
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f forniture
	* @throws it.ethica.esf.NoSuchFornitureException if a e s f forniture with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFForniture[] findByNumberFornitures_PrevAndNext(
		long esfFornitureId, long numberFornitures,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFornitureException;

	/**
	* Removes all the e s f fornitures where numberFornitures = &#63; from the database.
	*
	* @param numberFornitures the number fornitures
	* @throws SystemException if a system exception occurred
	*/
	public void removeByNumberFornitures(long numberFornitures)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f fornitures where numberFornitures = &#63;.
	*
	* @param numberFornitures the number fornitures
	* @return the number of matching e s f fornitures
	* @throws SystemException if a system exception occurred
	*/
	public int countByNumberFornitures(long numberFornitures)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f fornitures where esfFornitureId = &#63; and groupId = &#63;.
	*
	* @param esfFornitureId the esf forniture ID
	* @param groupId the group ID
	* @return the matching e s f fornitures
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFForniture> findByT_G(
		long esfFornitureId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f fornitures where esfFornitureId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFornitureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfFornitureId the esf forniture ID
	* @param groupId the group ID
	* @param start the lower bound of the range of e s f fornitures
	* @param end the upper bound of the range of e s f fornitures (not inclusive)
	* @return the range of matching e s f fornitures
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFForniture> findByT_G(
		long esfFornitureId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f fornitures where esfFornitureId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFornitureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfFornitureId the esf forniture ID
	* @param groupId the group ID
	* @param start the lower bound of the range of e s f fornitures
	* @param end the upper bound of the range of e s f fornitures (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f fornitures
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFForniture> findByT_G(
		long esfFornitureId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f forniture in the ordered set where esfFornitureId = &#63; and groupId = &#63;.
	*
	* @param esfFornitureId the esf forniture ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f forniture
	* @throws it.ethica.esf.NoSuchFornitureException if a matching e s f forniture could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFForniture findByT_G_First(
		long esfFornitureId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFornitureException;

	/**
	* Returns the first e s f forniture in the ordered set where esfFornitureId = &#63; and groupId = &#63;.
	*
	* @param esfFornitureId the esf forniture ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f forniture, or <code>null</code> if a matching e s f forniture could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFForniture fetchByT_G_First(
		long esfFornitureId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f forniture in the ordered set where esfFornitureId = &#63; and groupId = &#63;.
	*
	* @param esfFornitureId the esf forniture ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f forniture
	* @throws it.ethica.esf.NoSuchFornitureException if a matching e s f forniture could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFForniture findByT_G_Last(
		long esfFornitureId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFornitureException;

	/**
	* Returns the last e s f forniture in the ordered set where esfFornitureId = &#63; and groupId = &#63;.
	*
	* @param esfFornitureId the esf forniture ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f forniture, or <code>null</code> if a matching e s f forniture could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFForniture fetchByT_G_Last(
		long esfFornitureId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the e s f fornitures where esfFornitureId = &#63; and groupId = &#63; from the database.
	*
	* @param esfFornitureId the esf forniture ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByT_G(long esfFornitureId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f fornitures where esfFornitureId = &#63; and groupId = &#63;.
	*
	* @param esfFornitureId the esf forniture ID
	* @param groupId the group ID
	* @return the number of matching e s f fornitures
	* @throws SystemException if a system exception occurred
	*/
	public int countByT_G(long esfFornitureId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the e s f forniture in the entity cache if it is enabled.
	*
	* @param esfForniture the e s f forniture
	*/
	public void cacheResult(it.ethica.esf.model.ESFForniture esfForniture);

	/**
	* Caches the e s f fornitures in the entity cache if it is enabled.
	*
	* @param esfFornitures the e s f fornitures
	*/
	public void cacheResult(
		java.util.List<it.ethica.esf.model.ESFForniture> esfFornitures);

	/**
	* Creates a new e s f forniture with the primary key. Does not add the e s f forniture to the database.
	*
	* @param esfFornitureId the primary key for the new e s f forniture
	* @return the new e s f forniture
	*/
	public it.ethica.esf.model.ESFForniture create(long esfFornitureId);

	/**
	* Removes the e s f forniture with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfFornitureId the primary key of the e s f forniture
	* @return the e s f forniture that was removed
	* @throws it.ethica.esf.NoSuchFornitureException if a e s f forniture with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFForniture remove(long esfFornitureId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFornitureException;

	public it.ethica.esf.model.ESFForniture updateImpl(
		it.ethica.esf.model.ESFForniture esfForniture)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f forniture with the primary key or throws a {@link it.ethica.esf.NoSuchFornitureException} if it could not be found.
	*
	* @param esfFornitureId the primary key of the e s f forniture
	* @return the e s f forniture
	* @throws it.ethica.esf.NoSuchFornitureException if a e s f forniture with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFForniture findByPrimaryKey(
		long esfFornitureId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFornitureException;

	/**
	* Returns the e s f forniture with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param esfFornitureId the primary key of the e s f forniture
	* @return the e s f forniture, or <code>null</code> if a e s f forniture with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFForniture fetchByPrimaryKey(
		long esfFornitureId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f fornitures.
	*
	* @return the e s f fornitures
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFForniture> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f fornitures.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFornitureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f fornitures
	* @param end the upper bound of the range of e s f fornitures (not inclusive)
	* @return the range of e s f fornitures
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFForniture> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f fornitures.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFornitureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f fornitures
	* @param end the upper bound of the range of e s f fornitures (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of e s f fornitures
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFForniture> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the e s f fornitures from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f fornitures.
	*
	* @return the number of e s f fornitures
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}