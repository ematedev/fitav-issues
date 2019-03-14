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

import it.ethica.esf.model.ESFEntityState;

/**
 * The persistence interface for the e s f entity state service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFEntityStatePersistenceImpl
 * @see ESFEntityStateUtil
 * @generated
 */
public interface ESFEntityStatePersistence extends BasePersistence<ESFEntityState> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ESFEntityStateUtil} to access the e s f entity state persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the e s f entity states where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching e s f entity states
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFEntityState> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f entity states where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFEntityStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of e s f entity states
	* @param end the upper bound of the range of e s f entity states (not inclusive)
	* @return the range of matching e s f entity states
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFEntityState> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f entity states where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFEntityStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of e s f entity states
	* @param end the upper bound of the range of e s f entity states (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f entity states
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFEntityState> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f entity state in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f entity state
	* @throws it.ethica.esf.NoSuchEntityStateException if a matching e s f entity state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFEntityState findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchEntityStateException;

	/**
	* Returns the first e s f entity state in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f entity state, or <code>null</code> if a matching e s f entity state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFEntityState fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f entity state in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f entity state
	* @throws it.ethica.esf.NoSuchEntityStateException if a matching e s f entity state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFEntityState findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchEntityStateException;

	/**
	* Returns the last e s f entity state in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f entity state, or <code>null</code> if a matching e s f entity state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFEntityState fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f entity states before and after the current e s f entity state in the ordered set where uuid = &#63;.
	*
	* @param esfEntityStatePK the primary key of the current e s f entity state
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f entity state
	* @throws it.ethica.esf.NoSuchEntityStateException if a e s f entity state with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFEntityState[] findByUuid_PrevAndNext(
		it.ethica.esf.service.persistence.ESFEntityStatePK esfEntityStatePK,
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchEntityStateException;

	/**
	* Removes all the e s f entity states where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f entity states where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching e s f entity states
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f entity state where uuid = &#63; and groupId = &#63; or throws a {@link it.ethica.esf.NoSuchEntityStateException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching e s f entity state
	* @throws it.ethica.esf.NoSuchEntityStateException if a matching e s f entity state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFEntityState findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchEntityStateException;

	/**
	* Returns the e s f entity state where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching e s f entity state, or <code>null</code> if a matching e s f entity state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFEntityState fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f entity state where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching e s f entity state, or <code>null</code> if a matching e s f entity state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFEntityState fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the e s f entity state where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the e s f entity state that was removed
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFEntityState removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchEntityStateException;

	/**
	* Returns the number of e s f entity states where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching e s f entity states
	* @throws SystemException if a system exception occurred
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f entity states where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching e s f entity states
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFEntityState> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f entity states where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFEntityStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of e s f entity states
	* @param end the upper bound of the range of e s f entity states (not inclusive)
	* @return the range of matching e s f entity states
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFEntityState> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f entity states where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFEntityStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of e s f entity states
	* @param end the upper bound of the range of e s f entity states (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f entity states
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFEntityState> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f entity state in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f entity state
	* @throws it.ethica.esf.NoSuchEntityStateException if a matching e s f entity state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFEntityState findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchEntityStateException;

	/**
	* Returns the first e s f entity state in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f entity state, or <code>null</code> if a matching e s f entity state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFEntityState fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f entity state in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f entity state
	* @throws it.ethica.esf.NoSuchEntityStateException if a matching e s f entity state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFEntityState findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchEntityStateException;

	/**
	* Returns the last e s f entity state in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f entity state, or <code>null</code> if a matching e s f entity state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFEntityState fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f entity states before and after the current e s f entity state in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param esfEntityStatePK the primary key of the current e s f entity state
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f entity state
	* @throws it.ethica.esf.NoSuchEntityStateException if a e s f entity state with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFEntityState[] findByUuid_C_PrevAndNext(
		it.ethica.esf.service.persistence.ESFEntityStatePK esfEntityStatePK,
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchEntityStateException;

	/**
	* Removes all the e s f entity states where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f entity states where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching e s f entity states
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f entity states where classPk = &#63; and className = &#63;.
	*
	* @param classPk the class pk
	* @param className the class name
	* @return the matching e s f entity states
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFEntityState> findByfindByC_C(
		long classPk, java.lang.String className)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f entity states where classPk = &#63; and className = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFEntityStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param classPk the class pk
	* @param className the class name
	* @param start the lower bound of the range of e s f entity states
	* @param end the upper bound of the range of e s f entity states (not inclusive)
	* @return the range of matching e s f entity states
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFEntityState> findByfindByC_C(
		long classPk, java.lang.String className, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f entity states where classPk = &#63; and className = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFEntityStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param classPk the class pk
	* @param className the class name
	* @param start the lower bound of the range of e s f entity states
	* @param end the upper bound of the range of e s f entity states (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f entity states
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFEntityState> findByfindByC_C(
		long classPk, java.lang.String className, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f entity state in the ordered set where classPk = &#63; and className = &#63;.
	*
	* @param classPk the class pk
	* @param className the class name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f entity state
	* @throws it.ethica.esf.NoSuchEntityStateException if a matching e s f entity state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFEntityState findByfindByC_C_First(
		long classPk, java.lang.String className,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchEntityStateException;

	/**
	* Returns the first e s f entity state in the ordered set where classPk = &#63; and className = &#63;.
	*
	* @param classPk the class pk
	* @param className the class name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f entity state, or <code>null</code> if a matching e s f entity state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFEntityState fetchByfindByC_C_First(
		long classPk, java.lang.String className,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f entity state in the ordered set where classPk = &#63; and className = &#63;.
	*
	* @param classPk the class pk
	* @param className the class name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f entity state
	* @throws it.ethica.esf.NoSuchEntityStateException if a matching e s f entity state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFEntityState findByfindByC_C_Last(
		long classPk, java.lang.String className,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchEntityStateException;

	/**
	* Returns the last e s f entity state in the ordered set where classPk = &#63; and className = &#63;.
	*
	* @param classPk the class pk
	* @param className the class name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f entity state, or <code>null</code> if a matching e s f entity state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFEntityState fetchByfindByC_C_Last(
		long classPk, java.lang.String className,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f entity states before and after the current e s f entity state in the ordered set where classPk = &#63; and className = &#63;.
	*
	* @param esfEntityStatePK the primary key of the current e s f entity state
	* @param classPk the class pk
	* @param className the class name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f entity state
	* @throws it.ethica.esf.NoSuchEntityStateException if a e s f entity state with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFEntityState[] findByfindByC_C_PrevAndNext(
		it.ethica.esf.service.persistence.ESFEntityStatePK esfEntityStatePK,
		long classPk, java.lang.String className,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchEntityStateException;

	/**
	* Removes all the e s f entity states where classPk = &#63; and className = &#63; from the database.
	*
	* @param classPk the class pk
	* @param className the class name
	* @throws SystemException if a system exception occurred
	*/
	public void removeByfindByC_C(long classPk, java.lang.String className)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f entity states where classPk = &#63; and className = &#63;.
	*
	* @param classPk the class pk
	* @param className the class name
	* @return the number of matching e s f entity states
	* @throws SystemException if a system exception occurred
	*/
	public int countByfindByC_C(long classPk, java.lang.String className)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the e s f entity state in the entity cache if it is enabled.
	*
	* @param esfEntityState the e s f entity state
	*/
	public void cacheResult(it.ethica.esf.model.ESFEntityState esfEntityState);

	/**
	* Caches the e s f entity states in the entity cache if it is enabled.
	*
	* @param esfEntityStates the e s f entity states
	*/
	public void cacheResult(
		java.util.List<it.ethica.esf.model.ESFEntityState> esfEntityStates);

	/**
	* Creates a new e s f entity state with the primary key. Does not add the e s f entity state to the database.
	*
	* @param esfEntityStatePK the primary key for the new e s f entity state
	* @return the new e s f entity state
	*/
	public it.ethica.esf.model.ESFEntityState create(
		it.ethica.esf.service.persistence.ESFEntityStatePK esfEntityStatePK);

	/**
	* Removes the e s f entity state with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfEntityStatePK the primary key of the e s f entity state
	* @return the e s f entity state that was removed
	* @throws it.ethica.esf.NoSuchEntityStateException if a e s f entity state with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFEntityState remove(
		it.ethica.esf.service.persistence.ESFEntityStatePK esfEntityStatePK)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchEntityStateException;

	public it.ethica.esf.model.ESFEntityState updateImpl(
		it.ethica.esf.model.ESFEntityState esfEntityState)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f entity state with the primary key or throws a {@link it.ethica.esf.NoSuchEntityStateException} if it could not be found.
	*
	* @param esfEntityStatePK the primary key of the e s f entity state
	* @return the e s f entity state
	* @throws it.ethica.esf.NoSuchEntityStateException if a e s f entity state with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFEntityState findByPrimaryKey(
		it.ethica.esf.service.persistence.ESFEntityStatePK esfEntityStatePK)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchEntityStateException;

	/**
	* Returns the e s f entity state with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param esfEntityStatePK the primary key of the e s f entity state
	* @return the e s f entity state, or <code>null</code> if a e s f entity state with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFEntityState fetchByPrimaryKey(
		it.ethica.esf.service.persistence.ESFEntityStatePK esfEntityStatePK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f entity states.
	*
	* @return the e s f entity states
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFEntityState> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f entity states.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFEntityStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f entity states
	* @param end the upper bound of the range of e s f entity states (not inclusive)
	* @return the range of e s f entity states
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFEntityState> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f entity states.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFEntityStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f entity states
	* @param end the upper bound of the range of e s f entity states (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of e s f entity states
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFEntityState> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the e s f entity states from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f entity states.
	*
	* @return the number of e s f entity states
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}