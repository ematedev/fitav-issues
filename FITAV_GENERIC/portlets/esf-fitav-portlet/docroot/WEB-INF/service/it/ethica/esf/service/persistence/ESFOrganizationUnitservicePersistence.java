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

import it.ethica.esf.model.ESFOrganizationUnitservice;

/**
 * The persistence interface for the e s f organization unitservice service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFOrganizationUnitservicePersistenceImpl
 * @see ESFOrganizationUnitserviceUtil
 * @generated
 */
public interface ESFOrganizationUnitservicePersistence extends BasePersistence<ESFOrganizationUnitservice> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ESFOrganizationUnitserviceUtil} to access the e s f organization unitservice persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the e s f organization unitservices where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching e s f organization unitservices
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFOrganizationUnitservice> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f organization unitservices where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFOrganizationUnitserviceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of e s f organization unitservices
	* @param end the upper bound of the range of e s f organization unitservices (not inclusive)
	* @return the range of matching e s f organization unitservices
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFOrganizationUnitservice> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f organization unitservices where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFOrganizationUnitserviceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of e s f organization unitservices
	* @param end the upper bound of the range of e s f organization unitservices (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f organization unitservices
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFOrganizationUnitservice> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f organization unitservice in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f organization unitservice
	* @throws it.ethica.esf.NoSuchOrganizationUnitserviceException if a matching e s f organization unitservice could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFOrganizationUnitservice findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchOrganizationUnitserviceException;

	/**
	* Returns the first e s f organization unitservice in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f organization unitservice, or <code>null</code> if a matching e s f organization unitservice could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFOrganizationUnitservice fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f organization unitservice in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f organization unitservice
	* @throws it.ethica.esf.NoSuchOrganizationUnitserviceException if a matching e s f organization unitservice could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFOrganizationUnitservice findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchOrganizationUnitserviceException;

	/**
	* Returns the last e s f organization unitservice in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f organization unitservice, or <code>null</code> if a matching e s f organization unitservice could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFOrganizationUnitservice fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f organization unitservices before and after the current e s f organization unitservice in the ordered set where uuid = &#63;.
	*
	* @param esfOrganizationUnitserviceId the primary key of the current e s f organization unitservice
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f organization unitservice
	* @throws it.ethica.esf.NoSuchOrganizationUnitserviceException if a e s f organization unitservice with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFOrganizationUnitservice[] findByUuid_PrevAndNext(
		long esfOrganizationUnitserviceId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchOrganizationUnitserviceException;

	/**
	* Removes all the e s f organization unitservices where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f organization unitservices where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching e s f organization unitservices
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f organization unitservice where uuid = &#63; and groupId = &#63; or throws a {@link it.ethica.esf.NoSuchOrganizationUnitserviceException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching e s f organization unitservice
	* @throws it.ethica.esf.NoSuchOrganizationUnitserviceException if a matching e s f organization unitservice could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFOrganizationUnitservice findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchOrganizationUnitserviceException;

	/**
	* Returns the e s f organization unitservice where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching e s f organization unitservice, or <code>null</code> if a matching e s f organization unitservice could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFOrganizationUnitservice fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f organization unitservice where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching e s f organization unitservice, or <code>null</code> if a matching e s f organization unitservice could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFOrganizationUnitservice fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the e s f organization unitservice where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the e s f organization unitservice that was removed
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFOrganizationUnitservice removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchOrganizationUnitserviceException;

	/**
	* Returns the number of e s f organization unitservices where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching e s f organization unitservices
	* @throws SystemException if a system exception occurred
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f organization unitservices where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching e s f organization unitservices
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFOrganizationUnitservice> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f organization unitservices where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFOrganizationUnitserviceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of e s f organization unitservices
	* @param end the upper bound of the range of e s f organization unitservices (not inclusive)
	* @return the range of matching e s f organization unitservices
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFOrganizationUnitservice> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f organization unitservices where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFOrganizationUnitserviceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of e s f organization unitservices
	* @param end the upper bound of the range of e s f organization unitservices (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f organization unitservices
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFOrganizationUnitservice> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f organization unitservice in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f organization unitservice
	* @throws it.ethica.esf.NoSuchOrganizationUnitserviceException if a matching e s f organization unitservice could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFOrganizationUnitservice findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchOrganizationUnitserviceException;

	/**
	* Returns the first e s f organization unitservice in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f organization unitservice, or <code>null</code> if a matching e s f organization unitservice could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFOrganizationUnitservice fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f organization unitservice in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f organization unitservice
	* @throws it.ethica.esf.NoSuchOrganizationUnitserviceException if a matching e s f organization unitservice could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFOrganizationUnitservice findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchOrganizationUnitserviceException;

	/**
	* Returns the last e s f organization unitservice in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f organization unitservice, or <code>null</code> if a matching e s f organization unitservice could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFOrganizationUnitservice fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f organization unitservices before and after the current e s f organization unitservice in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param esfOrganizationUnitserviceId the primary key of the current e s f organization unitservice
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f organization unitservice
	* @throws it.ethica.esf.NoSuchOrganizationUnitserviceException if a e s f organization unitservice with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFOrganizationUnitservice[] findByUuid_C_PrevAndNext(
		long esfOrganizationUnitserviceId, java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchOrganizationUnitserviceException;

	/**
	* Removes all the e s f organization unitservices where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f organization unitservices where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching e s f organization unitservices
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f organization unitservices where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching e s f organization unitservices
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFOrganizationUnitservice> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f organization unitservices where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFOrganizationUnitserviceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of e s f organization unitservices
	* @param end the upper bound of the range of e s f organization unitservices (not inclusive)
	* @return the range of matching e s f organization unitservices
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFOrganizationUnitservice> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f organization unitservices where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFOrganizationUnitserviceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of e s f organization unitservices
	* @param end the upper bound of the range of e s f organization unitservices (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f organization unitservices
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFOrganizationUnitservice> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f organization unitservice in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f organization unitservice
	* @throws it.ethica.esf.NoSuchOrganizationUnitserviceException if a matching e s f organization unitservice could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFOrganizationUnitservice findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchOrganizationUnitserviceException;

	/**
	* Returns the first e s f organization unitservice in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f organization unitservice, or <code>null</code> if a matching e s f organization unitservice could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFOrganizationUnitservice fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f organization unitservice in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f organization unitservice
	* @throws it.ethica.esf.NoSuchOrganizationUnitserviceException if a matching e s f organization unitservice could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFOrganizationUnitservice findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchOrganizationUnitserviceException;

	/**
	* Returns the last e s f organization unitservice in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f organization unitservice, or <code>null</code> if a matching e s f organization unitservice could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFOrganizationUnitservice fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f organization unitservices before and after the current e s f organization unitservice in the ordered set where groupId = &#63;.
	*
	* @param esfOrganizationUnitserviceId the primary key of the current e s f organization unitservice
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f organization unitservice
	* @throws it.ethica.esf.NoSuchOrganizationUnitserviceException if a e s f organization unitservice with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFOrganizationUnitservice[] findByGroupId_PrevAndNext(
		long esfOrganizationUnitserviceId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchOrganizationUnitserviceException;

	/**
	* Returns all the e s f organization unitservices that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching e s f organization unitservices that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFOrganizationUnitservice> filterFindByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f organization unitservices that the user has permission to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFOrganizationUnitserviceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of e s f organization unitservices
	* @param end the upper bound of the range of e s f organization unitservices (not inclusive)
	* @return the range of matching e s f organization unitservices that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFOrganizationUnitservice> filterFindByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f organization unitservices that the user has permissions to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFOrganizationUnitserviceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of e s f organization unitservices
	* @param end the upper bound of the range of e s f organization unitservices (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f organization unitservices that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFOrganizationUnitservice> filterFindByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f organization unitservices before and after the current e s f organization unitservice in the ordered set of e s f organization unitservices that the user has permission to view where groupId = &#63;.
	*
	* @param esfOrganizationUnitserviceId the primary key of the current e s f organization unitservice
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f organization unitservice
	* @throws it.ethica.esf.NoSuchOrganizationUnitserviceException if a e s f organization unitservice with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFOrganizationUnitservice[] filterFindByGroupId_PrevAndNext(
		long esfOrganizationUnitserviceId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchOrganizationUnitserviceException;

	/**
	* Removes all the e s f organization unitservices where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f organization unitservices where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching e s f organization unitservices
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f organization unitservices that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching e s f organization unitservices that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f organization unitservices where esfOrganizationId = &#63;.
	*
	* @param esfOrganizationId the esf organization ID
	* @return the matching e s f organization unitservices
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFOrganizationUnitservice> findByEsfOrganizationId(
		long esfOrganizationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f organization unitservices where esfOrganizationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFOrganizationUnitserviceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfOrganizationId the esf organization ID
	* @param start the lower bound of the range of e s f organization unitservices
	* @param end the upper bound of the range of e s f organization unitservices (not inclusive)
	* @return the range of matching e s f organization unitservices
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFOrganizationUnitservice> findByEsfOrganizationId(
		long esfOrganizationId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f organization unitservices where esfOrganizationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFOrganizationUnitserviceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfOrganizationId the esf organization ID
	* @param start the lower bound of the range of e s f organization unitservices
	* @param end the upper bound of the range of e s f organization unitservices (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f organization unitservices
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFOrganizationUnitservice> findByEsfOrganizationId(
		long esfOrganizationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f organization unitservice in the ordered set where esfOrganizationId = &#63;.
	*
	* @param esfOrganizationId the esf organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f organization unitservice
	* @throws it.ethica.esf.NoSuchOrganizationUnitserviceException if a matching e s f organization unitservice could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFOrganizationUnitservice findByEsfOrganizationId_First(
		long esfOrganizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchOrganizationUnitserviceException;

	/**
	* Returns the first e s f organization unitservice in the ordered set where esfOrganizationId = &#63;.
	*
	* @param esfOrganizationId the esf organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f organization unitservice, or <code>null</code> if a matching e s f organization unitservice could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFOrganizationUnitservice fetchByEsfOrganizationId_First(
		long esfOrganizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f organization unitservice in the ordered set where esfOrganizationId = &#63;.
	*
	* @param esfOrganizationId the esf organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f organization unitservice
	* @throws it.ethica.esf.NoSuchOrganizationUnitserviceException if a matching e s f organization unitservice could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFOrganizationUnitservice findByEsfOrganizationId_Last(
		long esfOrganizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchOrganizationUnitserviceException;

	/**
	* Returns the last e s f organization unitservice in the ordered set where esfOrganizationId = &#63;.
	*
	* @param esfOrganizationId the esf organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f organization unitservice, or <code>null</code> if a matching e s f organization unitservice could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFOrganizationUnitservice fetchByEsfOrganizationId_Last(
		long esfOrganizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f organization unitservices before and after the current e s f organization unitservice in the ordered set where esfOrganizationId = &#63;.
	*
	* @param esfOrganizationUnitserviceId the primary key of the current e s f organization unitservice
	* @param esfOrganizationId the esf organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f organization unitservice
	* @throws it.ethica.esf.NoSuchOrganizationUnitserviceException if a e s f organization unitservice with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFOrganizationUnitservice[] findByEsfOrganizationId_PrevAndNext(
		long esfOrganizationUnitserviceId, long esfOrganizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchOrganizationUnitserviceException;

	/**
	* Removes all the e s f organization unitservices where esfOrganizationId = &#63; from the database.
	*
	* @param esfOrganizationId the esf organization ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByEsfOrganizationId(long esfOrganizationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f organization unitservices where esfOrganizationId = &#63;.
	*
	* @param esfOrganizationId the esf organization ID
	* @return the number of matching e s f organization unitservices
	* @throws SystemException if a system exception occurred
	*/
	public int countByEsfOrganizationId(long esfOrganizationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f organization unitservices where esfUnitserviceId = &#63;.
	*
	* @param esfUnitserviceId the esf unitservice ID
	* @return the matching e s f organization unitservices
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFOrganizationUnitservice> findByEsfUnitserviceId(
		long esfUnitserviceId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f organization unitservices where esfUnitserviceId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFOrganizationUnitserviceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfUnitserviceId the esf unitservice ID
	* @param start the lower bound of the range of e s f organization unitservices
	* @param end the upper bound of the range of e s f organization unitservices (not inclusive)
	* @return the range of matching e s f organization unitservices
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFOrganizationUnitservice> findByEsfUnitserviceId(
		long esfUnitserviceId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f organization unitservices where esfUnitserviceId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFOrganizationUnitserviceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfUnitserviceId the esf unitservice ID
	* @param start the lower bound of the range of e s f organization unitservices
	* @param end the upper bound of the range of e s f organization unitservices (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f organization unitservices
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFOrganizationUnitservice> findByEsfUnitserviceId(
		long esfUnitserviceId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f organization unitservice in the ordered set where esfUnitserviceId = &#63;.
	*
	* @param esfUnitserviceId the esf unitservice ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f organization unitservice
	* @throws it.ethica.esf.NoSuchOrganizationUnitserviceException if a matching e s f organization unitservice could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFOrganizationUnitservice findByEsfUnitserviceId_First(
		long esfUnitserviceId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchOrganizationUnitserviceException;

	/**
	* Returns the first e s f organization unitservice in the ordered set where esfUnitserviceId = &#63;.
	*
	* @param esfUnitserviceId the esf unitservice ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f organization unitservice, or <code>null</code> if a matching e s f organization unitservice could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFOrganizationUnitservice fetchByEsfUnitserviceId_First(
		long esfUnitserviceId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f organization unitservice in the ordered set where esfUnitserviceId = &#63;.
	*
	* @param esfUnitserviceId the esf unitservice ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f organization unitservice
	* @throws it.ethica.esf.NoSuchOrganizationUnitserviceException if a matching e s f organization unitservice could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFOrganizationUnitservice findByEsfUnitserviceId_Last(
		long esfUnitserviceId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchOrganizationUnitserviceException;

	/**
	* Returns the last e s f organization unitservice in the ordered set where esfUnitserviceId = &#63;.
	*
	* @param esfUnitserviceId the esf unitservice ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f organization unitservice, or <code>null</code> if a matching e s f organization unitservice could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFOrganizationUnitservice fetchByEsfUnitserviceId_Last(
		long esfUnitserviceId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f organization unitservices before and after the current e s f organization unitservice in the ordered set where esfUnitserviceId = &#63;.
	*
	* @param esfOrganizationUnitserviceId the primary key of the current e s f organization unitservice
	* @param esfUnitserviceId the esf unitservice ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f organization unitservice
	* @throws it.ethica.esf.NoSuchOrganizationUnitserviceException if a e s f organization unitservice with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFOrganizationUnitservice[] findByEsfUnitserviceId_PrevAndNext(
		long esfOrganizationUnitserviceId, long esfUnitserviceId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchOrganizationUnitserviceException;

	/**
	* Removes all the e s f organization unitservices where esfUnitserviceId = &#63; from the database.
	*
	* @param esfUnitserviceId the esf unitservice ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByEsfUnitserviceId(long esfUnitserviceId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f organization unitservices where esfUnitserviceId = &#63;.
	*
	* @param esfUnitserviceId the esf unitservice ID
	* @return the number of matching e s f organization unitservices
	* @throws SystemException if a system exception occurred
	*/
	public int countByEsfUnitserviceId(long esfUnitserviceId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the e s f organization unitservice in the entity cache if it is enabled.
	*
	* @param esfOrganizationUnitservice the e s f organization unitservice
	*/
	public void cacheResult(
		it.ethica.esf.model.ESFOrganizationUnitservice esfOrganizationUnitservice);

	/**
	* Caches the e s f organization unitservices in the entity cache if it is enabled.
	*
	* @param esfOrganizationUnitservices the e s f organization unitservices
	*/
	public void cacheResult(
		java.util.List<it.ethica.esf.model.ESFOrganizationUnitservice> esfOrganizationUnitservices);

	/**
	* Creates a new e s f organization unitservice with the primary key. Does not add the e s f organization unitservice to the database.
	*
	* @param esfOrganizationUnitserviceId the primary key for the new e s f organization unitservice
	* @return the new e s f organization unitservice
	*/
	public it.ethica.esf.model.ESFOrganizationUnitservice create(
		long esfOrganizationUnitserviceId);

	/**
	* Removes the e s f organization unitservice with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfOrganizationUnitserviceId the primary key of the e s f organization unitservice
	* @return the e s f organization unitservice that was removed
	* @throws it.ethica.esf.NoSuchOrganizationUnitserviceException if a e s f organization unitservice with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFOrganizationUnitservice remove(
		long esfOrganizationUnitserviceId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchOrganizationUnitserviceException;

	public it.ethica.esf.model.ESFOrganizationUnitservice updateImpl(
		it.ethica.esf.model.ESFOrganizationUnitservice esfOrganizationUnitservice)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f organization unitservice with the primary key or throws a {@link it.ethica.esf.NoSuchOrganizationUnitserviceException} if it could not be found.
	*
	* @param esfOrganizationUnitserviceId the primary key of the e s f organization unitservice
	* @return the e s f organization unitservice
	* @throws it.ethica.esf.NoSuchOrganizationUnitserviceException if a e s f organization unitservice with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFOrganizationUnitservice findByPrimaryKey(
		long esfOrganizationUnitserviceId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchOrganizationUnitserviceException;

	/**
	* Returns the e s f organization unitservice with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param esfOrganizationUnitserviceId the primary key of the e s f organization unitservice
	* @return the e s f organization unitservice, or <code>null</code> if a e s f organization unitservice with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFOrganizationUnitservice fetchByPrimaryKey(
		long esfOrganizationUnitserviceId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f organization unitservices.
	*
	* @return the e s f organization unitservices
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFOrganizationUnitservice> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f organization unitservices.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFOrganizationUnitserviceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f organization unitservices
	* @param end the upper bound of the range of e s f organization unitservices (not inclusive)
	* @return the range of e s f organization unitservices
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFOrganizationUnitservice> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f organization unitservices.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFOrganizationUnitserviceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f organization unitservices
	* @param end the upper bound of the range of e s f organization unitservices (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of e s f organization unitservices
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFOrganizationUnitservice> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the e s f organization unitservices from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f organization unitservices.
	*
	* @return the number of e s f organization unitservices
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}