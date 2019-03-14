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

import it.ethica.esf.model.ESFToolRel;

/**
 * The persistence interface for the e s f tool rel service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFToolRelPersistenceImpl
 * @see ESFToolRelUtil
 * @generated
 */
public interface ESFToolRelPersistence extends BasePersistence<ESFToolRel> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ESFToolRelUtil} to access the e s f tool rel persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the e s f tool rels where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching e s f tool rels
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFToolRel> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f tool rels where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFToolRelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of e s f tool rels
	* @param end the upper bound of the range of e s f tool rels (not inclusive)
	* @return the range of matching e s f tool rels
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFToolRel> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f tool rels where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFToolRelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of e s f tool rels
	* @param end the upper bound of the range of e s f tool rels (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f tool rels
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFToolRel> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f tool rel in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f tool rel
	* @throws it.ethica.esf.NoSuchToolRelException if a matching e s f tool rel could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFToolRel findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchToolRelException;

	/**
	* Returns the first e s f tool rel in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f tool rel, or <code>null</code> if a matching e s f tool rel could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFToolRel fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f tool rel in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f tool rel
	* @throws it.ethica.esf.NoSuchToolRelException if a matching e s f tool rel could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFToolRel findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchToolRelException;

	/**
	* Returns the last e s f tool rel in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f tool rel, or <code>null</code> if a matching e s f tool rel could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFToolRel fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f tool rels before and after the current e s f tool rel in the ordered set where uuid = &#63;.
	*
	* @param esfToolRelPK the primary key of the current e s f tool rel
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f tool rel
	* @throws it.ethica.esf.NoSuchToolRelException if a e s f tool rel with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFToolRel[] findByUuid_PrevAndNext(
		it.ethica.esf.service.persistence.ESFToolRelPK esfToolRelPK,
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchToolRelException;

	/**
	* Removes all the e s f tool rels where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f tool rels where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching e s f tool rels
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f tool rel where uuid = &#63; and groupId = &#63; or throws a {@link it.ethica.esf.NoSuchToolRelException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching e s f tool rel
	* @throws it.ethica.esf.NoSuchToolRelException if a matching e s f tool rel could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFToolRel findByUUID_G(java.lang.String uuid,
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchToolRelException;

	/**
	* Returns the e s f tool rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching e s f tool rel, or <code>null</code> if a matching e s f tool rel could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFToolRel fetchByUUID_G(java.lang.String uuid,
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f tool rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching e s f tool rel, or <code>null</code> if a matching e s f tool rel could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFToolRel fetchByUUID_G(java.lang.String uuid,
		long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the e s f tool rel where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the e s f tool rel that was removed
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFToolRel removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchToolRelException;

	/**
	* Returns the number of e s f tool rels where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching e s f tool rels
	* @throws SystemException if a system exception occurred
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f tool rels where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching e s f tool rels
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFToolRel> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f tool rels where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFToolRelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of e s f tool rels
	* @param end the upper bound of the range of e s f tool rels (not inclusive)
	* @return the range of matching e s f tool rels
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFToolRel> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f tool rels where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFToolRelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of e s f tool rels
	* @param end the upper bound of the range of e s f tool rels (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f tool rels
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFToolRel> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f tool rel in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f tool rel
	* @throws it.ethica.esf.NoSuchToolRelException if a matching e s f tool rel could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFToolRel findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchToolRelException;

	/**
	* Returns the first e s f tool rel in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f tool rel, or <code>null</code> if a matching e s f tool rel could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFToolRel fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f tool rel in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f tool rel
	* @throws it.ethica.esf.NoSuchToolRelException if a matching e s f tool rel could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFToolRel findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchToolRelException;

	/**
	* Returns the last e s f tool rel in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f tool rel, or <code>null</code> if a matching e s f tool rel could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFToolRel fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f tool rels before and after the current e s f tool rel in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param esfToolRelPK the primary key of the current e s f tool rel
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f tool rel
	* @throws it.ethica.esf.NoSuchToolRelException if a e s f tool rel with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFToolRel[] findByUuid_C_PrevAndNext(
		it.ethica.esf.service.persistence.ESFToolRelPK esfToolRelPK,
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchToolRelException;

	/**
	* Removes all the e s f tool rels where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f tool rels where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching e s f tool rels
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f tool rels where esfToolId = &#63;.
	*
	* @param esfToolId the esf tool ID
	* @return the matching e s f tool rels
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFToolRel> findByESFToolId(
		long esfToolId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f tool rels where esfToolId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFToolRelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfToolId the esf tool ID
	* @param start the lower bound of the range of e s f tool rels
	* @param end the upper bound of the range of e s f tool rels (not inclusive)
	* @return the range of matching e s f tool rels
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFToolRel> findByESFToolId(
		long esfToolId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f tool rels where esfToolId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFToolRelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfToolId the esf tool ID
	* @param start the lower bound of the range of e s f tool rels
	* @param end the upper bound of the range of e s f tool rels (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f tool rels
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFToolRel> findByESFToolId(
		long esfToolId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f tool rel in the ordered set where esfToolId = &#63;.
	*
	* @param esfToolId the esf tool ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f tool rel
	* @throws it.ethica.esf.NoSuchToolRelException if a matching e s f tool rel could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFToolRel findByESFToolId_First(
		long esfToolId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchToolRelException;

	/**
	* Returns the first e s f tool rel in the ordered set where esfToolId = &#63;.
	*
	* @param esfToolId the esf tool ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f tool rel, or <code>null</code> if a matching e s f tool rel could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFToolRel fetchByESFToolId_First(
		long esfToolId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f tool rel in the ordered set where esfToolId = &#63;.
	*
	* @param esfToolId the esf tool ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f tool rel
	* @throws it.ethica.esf.NoSuchToolRelException if a matching e s f tool rel could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFToolRel findByESFToolId_Last(long esfToolId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchToolRelException;

	/**
	* Returns the last e s f tool rel in the ordered set where esfToolId = &#63;.
	*
	* @param esfToolId the esf tool ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f tool rel, or <code>null</code> if a matching e s f tool rel could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFToolRel fetchByESFToolId_Last(
		long esfToolId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f tool rels before and after the current e s f tool rel in the ordered set where esfToolId = &#63;.
	*
	* @param esfToolRelPK the primary key of the current e s f tool rel
	* @param esfToolId the esf tool ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f tool rel
	* @throws it.ethica.esf.NoSuchToolRelException if a e s f tool rel with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFToolRel[] findByESFToolId_PrevAndNext(
		it.ethica.esf.service.persistence.ESFToolRelPK esfToolRelPK,
		long esfToolId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchToolRelException;

	/**
	* Removes all the e s f tool rels where esfToolId = &#63; from the database.
	*
	* @param esfToolId the esf tool ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByESFToolId(long esfToolId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f tool rels where esfToolId = &#63;.
	*
	* @param esfToolId the esf tool ID
	* @return the number of matching e s f tool rels
	* @throws SystemException if a system exception occurred
	*/
	public int countByESFToolId(long esfToolId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f tool rels where className = &#63; and classPK = &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @return the matching e s f tool rels
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFToolRel> findByN_P(
		java.lang.String className, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f tool rels where className = &#63; and classPK = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFToolRelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param className the class name
	* @param classPK the class p k
	* @param start the lower bound of the range of e s f tool rels
	* @param end the upper bound of the range of e s f tool rels (not inclusive)
	* @return the range of matching e s f tool rels
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFToolRel> findByN_P(
		java.lang.String className, long classPK, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f tool rels where className = &#63; and classPK = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFToolRelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param className the class name
	* @param classPK the class p k
	* @param start the lower bound of the range of e s f tool rels
	* @param end the upper bound of the range of e s f tool rels (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f tool rels
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFToolRel> findByN_P(
		java.lang.String className, long classPK, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f tool rel in the ordered set where className = &#63; and classPK = &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f tool rel
	* @throws it.ethica.esf.NoSuchToolRelException if a matching e s f tool rel could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFToolRel findByN_P_First(
		java.lang.String className, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchToolRelException;

	/**
	* Returns the first e s f tool rel in the ordered set where className = &#63; and classPK = &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f tool rel, or <code>null</code> if a matching e s f tool rel could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFToolRel fetchByN_P_First(
		java.lang.String className, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f tool rel in the ordered set where className = &#63; and classPK = &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f tool rel
	* @throws it.ethica.esf.NoSuchToolRelException if a matching e s f tool rel could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFToolRel findByN_P_Last(
		java.lang.String className, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchToolRelException;

	/**
	* Returns the last e s f tool rel in the ordered set where className = &#63; and classPK = &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f tool rel, or <code>null</code> if a matching e s f tool rel could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFToolRel fetchByN_P_Last(
		java.lang.String className, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f tool rels before and after the current e s f tool rel in the ordered set where className = &#63; and classPK = &#63;.
	*
	* @param esfToolRelPK the primary key of the current e s f tool rel
	* @param className the class name
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f tool rel
	* @throws it.ethica.esf.NoSuchToolRelException if a e s f tool rel with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFToolRel[] findByN_P_PrevAndNext(
		it.ethica.esf.service.persistence.ESFToolRelPK esfToolRelPK,
		java.lang.String className, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchToolRelException;

	/**
	* Removes all the e s f tool rels where className = &#63; and classPK = &#63; from the database.
	*
	* @param className the class name
	* @param classPK the class p k
	* @throws SystemException if a system exception occurred
	*/
	public void removeByN_P(java.lang.String className, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f tool rels where className = &#63; and classPK = &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @return the number of matching e s f tool rels
	* @throws SystemException if a system exception occurred
	*/
	public int countByN_P(java.lang.String className, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f tool rels where assignmentDate = &#63;.
	*
	* @param assignmentDate the assignment date
	* @return the matching e s f tool rels
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFToolRel> findByAssignmentDate(
		java.util.Date assignmentDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f tool rels where assignmentDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFToolRelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param assignmentDate the assignment date
	* @param start the lower bound of the range of e s f tool rels
	* @param end the upper bound of the range of e s f tool rels (not inclusive)
	* @return the range of matching e s f tool rels
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFToolRel> findByAssignmentDate(
		java.util.Date assignmentDate, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f tool rels where assignmentDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFToolRelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param assignmentDate the assignment date
	* @param start the lower bound of the range of e s f tool rels
	* @param end the upper bound of the range of e s f tool rels (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f tool rels
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFToolRel> findByAssignmentDate(
		java.util.Date assignmentDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f tool rel in the ordered set where assignmentDate = &#63;.
	*
	* @param assignmentDate the assignment date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f tool rel
	* @throws it.ethica.esf.NoSuchToolRelException if a matching e s f tool rel could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFToolRel findByAssignmentDate_First(
		java.util.Date assignmentDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchToolRelException;

	/**
	* Returns the first e s f tool rel in the ordered set where assignmentDate = &#63;.
	*
	* @param assignmentDate the assignment date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f tool rel, or <code>null</code> if a matching e s f tool rel could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFToolRel fetchByAssignmentDate_First(
		java.util.Date assignmentDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f tool rel in the ordered set where assignmentDate = &#63;.
	*
	* @param assignmentDate the assignment date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f tool rel
	* @throws it.ethica.esf.NoSuchToolRelException if a matching e s f tool rel could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFToolRel findByAssignmentDate_Last(
		java.util.Date assignmentDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchToolRelException;

	/**
	* Returns the last e s f tool rel in the ordered set where assignmentDate = &#63;.
	*
	* @param assignmentDate the assignment date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f tool rel, or <code>null</code> if a matching e s f tool rel could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFToolRel fetchByAssignmentDate_Last(
		java.util.Date assignmentDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f tool rels before and after the current e s f tool rel in the ordered set where assignmentDate = &#63;.
	*
	* @param esfToolRelPK the primary key of the current e s f tool rel
	* @param assignmentDate the assignment date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f tool rel
	* @throws it.ethica.esf.NoSuchToolRelException if a e s f tool rel with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFToolRel[] findByAssignmentDate_PrevAndNext(
		it.ethica.esf.service.persistence.ESFToolRelPK esfToolRelPK,
		java.util.Date assignmentDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchToolRelException;

	/**
	* Removes all the e s f tool rels where assignmentDate = &#63; from the database.
	*
	* @param assignmentDate the assignment date
	* @throws SystemException if a system exception occurred
	*/
	public void removeByAssignmentDate(java.util.Date assignmentDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f tool rels where assignmentDate = &#63;.
	*
	* @param assignmentDate the assignment date
	* @return the number of matching e s f tool rels
	* @throws SystemException if a system exception occurred
	*/
	public int countByAssignmentDate(java.util.Date assignmentDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the e s f tool rel in the entity cache if it is enabled.
	*
	* @param esfToolRel the e s f tool rel
	*/
	public void cacheResult(it.ethica.esf.model.ESFToolRel esfToolRel);

	/**
	* Caches the e s f tool rels in the entity cache if it is enabled.
	*
	* @param esfToolRels the e s f tool rels
	*/
	public void cacheResult(
		java.util.List<it.ethica.esf.model.ESFToolRel> esfToolRels);

	/**
	* Creates a new e s f tool rel with the primary key. Does not add the e s f tool rel to the database.
	*
	* @param esfToolRelPK the primary key for the new e s f tool rel
	* @return the new e s f tool rel
	*/
	public it.ethica.esf.model.ESFToolRel create(
		it.ethica.esf.service.persistence.ESFToolRelPK esfToolRelPK);

	/**
	* Removes the e s f tool rel with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfToolRelPK the primary key of the e s f tool rel
	* @return the e s f tool rel that was removed
	* @throws it.ethica.esf.NoSuchToolRelException if a e s f tool rel with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFToolRel remove(
		it.ethica.esf.service.persistence.ESFToolRelPK esfToolRelPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchToolRelException;

	public it.ethica.esf.model.ESFToolRel updateImpl(
		it.ethica.esf.model.ESFToolRel esfToolRel)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f tool rel with the primary key or throws a {@link it.ethica.esf.NoSuchToolRelException} if it could not be found.
	*
	* @param esfToolRelPK the primary key of the e s f tool rel
	* @return the e s f tool rel
	* @throws it.ethica.esf.NoSuchToolRelException if a e s f tool rel with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFToolRel findByPrimaryKey(
		it.ethica.esf.service.persistence.ESFToolRelPK esfToolRelPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchToolRelException;

	/**
	* Returns the e s f tool rel with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param esfToolRelPK the primary key of the e s f tool rel
	* @return the e s f tool rel, or <code>null</code> if a e s f tool rel with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFToolRel fetchByPrimaryKey(
		it.ethica.esf.service.persistence.ESFToolRelPK esfToolRelPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f tool rels.
	*
	* @return the e s f tool rels
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFToolRel> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f tool rels.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFToolRelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f tool rels
	* @param end the upper bound of the range of e s f tool rels (not inclusive)
	* @return the range of e s f tool rels
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFToolRel> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f tool rels.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFToolRelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f tool rels
	* @param end the upper bound of the range of e s f tool rels (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of e s f tool rels
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFToolRel> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the e s f tool rels from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f tool rels.
	*
	* @return the number of e s f tool rels
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}