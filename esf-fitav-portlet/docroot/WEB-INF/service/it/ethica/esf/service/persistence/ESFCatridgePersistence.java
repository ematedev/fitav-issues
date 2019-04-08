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

import it.ethica.esf.model.ESFCatridge;

/**
 * The persistence interface for the e s f catridge service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFCatridgePersistenceImpl
 * @see ESFCatridgeUtil
 * @generated
 */
public interface ESFCatridgePersistence extends BasePersistence<ESFCatridge> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ESFCatridgeUtil} to access the e s f catridge persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the e s f catridges where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching e s f catridges
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFCatridge> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f catridges where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFCatridgeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of e s f catridges
	* @param end the upper bound of the range of e s f catridges (not inclusive)
	* @return the range of matching e s f catridges
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFCatridge> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f catridges where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFCatridgeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of e s f catridges
	* @param end the upper bound of the range of e s f catridges (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f catridges
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFCatridge> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f catridge in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f catridge
	* @throws it.ethica.esf.NoSuchCatridgeException if a matching e s f catridge could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFCatridge findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchCatridgeException;

	/**
	* Returns the first e s f catridge in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f catridge, or <code>null</code> if a matching e s f catridge could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFCatridge fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f catridge in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f catridge
	* @throws it.ethica.esf.NoSuchCatridgeException if a matching e s f catridge could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFCatridge findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchCatridgeException;

	/**
	* Returns the last e s f catridge in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f catridge, or <code>null</code> if a matching e s f catridge could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFCatridge fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f catridges before and after the current e s f catridge in the ordered set where uuid = &#63;.
	*
	* @param esfCatridgeId the primary key of the current e s f catridge
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f catridge
	* @throws it.ethica.esf.NoSuchCatridgeException if a e s f catridge with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFCatridge[] findByUuid_PrevAndNext(
		long esfCatridgeId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchCatridgeException;

	/**
	* Removes all the e s f catridges where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f catridges where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching e s f catridges
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f catridges where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @return the matching e s f catridges
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFCatridge> findByEsfUserId(
		long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f catridges where esfUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFCatridgeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfUserId the esf user ID
	* @param start the lower bound of the range of e s f catridges
	* @param end the upper bound of the range of e s f catridges (not inclusive)
	* @return the range of matching e s f catridges
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFCatridge> findByEsfUserId(
		long esfUserId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f catridges where esfUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFCatridgeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfUserId the esf user ID
	* @param start the lower bound of the range of e s f catridges
	* @param end the upper bound of the range of e s f catridges (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f catridges
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFCatridge> findByEsfUserId(
		long esfUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f catridge in the ordered set where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f catridge
	* @throws it.ethica.esf.NoSuchCatridgeException if a matching e s f catridge could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFCatridge findByEsfUserId_First(
		long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchCatridgeException;

	/**
	* Returns the first e s f catridge in the ordered set where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f catridge, or <code>null</code> if a matching e s f catridge could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFCatridge fetchByEsfUserId_First(
		long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f catridge in the ordered set where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f catridge
	* @throws it.ethica.esf.NoSuchCatridgeException if a matching e s f catridge could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFCatridge findByEsfUserId_Last(
		long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchCatridgeException;

	/**
	* Returns the last e s f catridge in the ordered set where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f catridge, or <code>null</code> if a matching e s f catridge could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFCatridge fetchByEsfUserId_Last(
		long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f catridges before and after the current e s f catridge in the ordered set where esfUserId = &#63;.
	*
	* @param esfCatridgeId the primary key of the current e s f catridge
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f catridge
	* @throws it.ethica.esf.NoSuchCatridgeException if a e s f catridge with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFCatridge[] findByEsfUserId_PrevAndNext(
		long esfCatridgeId, long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchCatridgeException;

	/**
	* Removes all the e s f catridges where esfUserId = &#63; from the database.
	*
	* @param esfUserId the esf user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByEsfUserId(long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f catridges where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @return the number of matching e s f catridges
	* @throws SystemException if a system exception occurred
	*/
	public int countByEsfUserId(long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f catridges where esfGunTypeId = &#63;.
	*
	* @param esfGunTypeId the esf gun type ID
	* @return the matching e s f catridges
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFCatridge> findByEsfGunTypeId(
		long esfGunTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f catridges where esfGunTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFCatridgeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfGunTypeId the esf gun type ID
	* @param start the lower bound of the range of e s f catridges
	* @param end the upper bound of the range of e s f catridges (not inclusive)
	* @return the range of matching e s f catridges
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFCatridge> findByEsfGunTypeId(
		long esfGunTypeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f catridges where esfGunTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFCatridgeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfGunTypeId the esf gun type ID
	* @param start the lower bound of the range of e s f catridges
	* @param end the upper bound of the range of e s f catridges (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f catridges
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFCatridge> findByEsfGunTypeId(
		long esfGunTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f catridge in the ordered set where esfGunTypeId = &#63;.
	*
	* @param esfGunTypeId the esf gun type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f catridge
	* @throws it.ethica.esf.NoSuchCatridgeException if a matching e s f catridge could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFCatridge findByEsfGunTypeId_First(
		long esfGunTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchCatridgeException;

	/**
	* Returns the first e s f catridge in the ordered set where esfGunTypeId = &#63;.
	*
	* @param esfGunTypeId the esf gun type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f catridge, or <code>null</code> if a matching e s f catridge could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFCatridge fetchByEsfGunTypeId_First(
		long esfGunTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f catridge in the ordered set where esfGunTypeId = &#63;.
	*
	* @param esfGunTypeId the esf gun type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f catridge
	* @throws it.ethica.esf.NoSuchCatridgeException if a matching e s f catridge could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFCatridge findByEsfGunTypeId_Last(
		long esfGunTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchCatridgeException;

	/**
	* Returns the last e s f catridge in the ordered set where esfGunTypeId = &#63;.
	*
	* @param esfGunTypeId the esf gun type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f catridge, or <code>null</code> if a matching e s f catridge could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFCatridge fetchByEsfGunTypeId_Last(
		long esfGunTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f catridges before and after the current e s f catridge in the ordered set where esfGunTypeId = &#63;.
	*
	* @param esfCatridgeId the primary key of the current e s f catridge
	* @param esfGunTypeId the esf gun type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f catridge
	* @throws it.ethica.esf.NoSuchCatridgeException if a e s f catridge with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFCatridge[] findByEsfGunTypeId_PrevAndNext(
		long esfCatridgeId, long esfGunTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchCatridgeException;

	/**
	* Removes all the e s f catridges where esfGunTypeId = &#63; from the database.
	*
	* @param esfGunTypeId the esf gun type ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByEsfGunTypeId(long esfGunTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f catridges where esfGunTypeId = &#63;.
	*
	* @param esfGunTypeId the esf gun type ID
	* @return the number of matching e s f catridges
	* @throws SystemException if a system exception occurred
	*/
	public int countByEsfGunTypeId(long esfGunTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the e s f catridge in the entity cache if it is enabled.
	*
	* @param esfCatridge the e s f catridge
	*/
	public void cacheResult(it.ethica.esf.model.ESFCatridge esfCatridge);

	/**
	* Caches the e s f catridges in the entity cache if it is enabled.
	*
	* @param esfCatridges the e s f catridges
	*/
	public void cacheResult(
		java.util.List<it.ethica.esf.model.ESFCatridge> esfCatridges);

	/**
	* Creates a new e s f catridge with the primary key. Does not add the e s f catridge to the database.
	*
	* @param esfCatridgeId the primary key for the new e s f catridge
	* @return the new e s f catridge
	*/
	public it.ethica.esf.model.ESFCatridge create(long esfCatridgeId);

	/**
	* Removes the e s f catridge with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfCatridgeId the primary key of the e s f catridge
	* @return the e s f catridge that was removed
	* @throws it.ethica.esf.NoSuchCatridgeException if a e s f catridge with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFCatridge remove(long esfCatridgeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchCatridgeException;

	public it.ethica.esf.model.ESFCatridge updateImpl(
		it.ethica.esf.model.ESFCatridge esfCatridge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f catridge with the primary key or throws a {@link it.ethica.esf.NoSuchCatridgeException} if it could not be found.
	*
	* @param esfCatridgeId the primary key of the e s f catridge
	* @return the e s f catridge
	* @throws it.ethica.esf.NoSuchCatridgeException if a e s f catridge with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFCatridge findByPrimaryKey(long esfCatridgeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchCatridgeException;

	/**
	* Returns the e s f catridge with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param esfCatridgeId the primary key of the e s f catridge
	* @return the e s f catridge, or <code>null</code> if a e s f catridge with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFCatridge fetchByPrimaryKey(long esfCatridgeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f catridges.
	*
	* @return the e s f catridges
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFCatridge> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f catridges.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFCatridgeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f catridges
	* @param end the upper bound of the range of e s f catridges (not inclusive)
	* @return the range of e s f catridges
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFCatridge> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f catridges.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFCatridgeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f catridges
	* @param end the upper bound of the range of e s f catridges (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of e s f catridges
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFCatridge> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the e s f catridges from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f catridges.
	*
	* @return the number of e s f catridges
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}