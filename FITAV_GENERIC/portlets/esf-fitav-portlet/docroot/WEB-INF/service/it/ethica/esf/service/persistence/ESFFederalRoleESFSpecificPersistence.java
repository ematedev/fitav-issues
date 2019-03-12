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

import it.ethica.esf.model.ESFFederalRoleESFSpecific;

/**
 * The persistence interface for the e s f federal role e s f specific service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFFederalRoleESFSpecificPersistenceImpl
 * @see ESFFederalRoleESFSpecificUtil
 * @generated
 */
public interface ESFFederalRoleESFSpecificPersistence extends BasePersistence<ESFFederalRoleESFSpecific> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ESFFederalRoleESFSpecificUtil} to access the e s f federal role e s f specific persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the e s f federal role e s f specifics where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching e s f federal role e s f specifics
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFFederalRoleESFSpecific> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f federal role e s f specifics where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFederalRoleESFSpecificModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of e s f federal role e s f specifics
	* @param end the upper bound of the range of e s f federal role e s f specifics (not inclusive)
	* @return the range of matching e s f federal role e s f specifics
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFFederalRoleESFSpecific> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f federal role e s f specifics where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFederalRoleESFSpecificModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of e s f federal role e s f specifics
	* @param end the upper bound of the range of e s f federal role e s f specifics (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f federal role e s f specifics
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFFederalRoleESFSpecific> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f federal role e s f specific in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f federal role e s f specific
	* @throws it.ethica.esf.NoSuchFederalRoleESFSpecificException if a matching e s f federal role e s f specific could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFFederalRoleESFSpecific findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFederalRoleESFSpecificException;

	/**
	* Returns the first e s f federal role e s f specific in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f federal role e s f specific, or <code>null</code> if a matching e s f federal role e s f specific could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFFederalRoleESFSpecific fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f federal role e s f specific in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f federal role e s f specific
	* @throws it.ethica.esf.NoSuchFederalRoleESFSpecificException if a matching e s f federal role e s f specific could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFFederalRoleESFSpecific findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFederalRoleESFSpecificException;

	/**
	* Returns the last e s f federal role e s f specific in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f federal role e s f specific, or <code>null</code> if a matching e s f federal role e s f specific could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFFederalRoleESFSpecific fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f federal role e s f specifics before and after the current e s f federal role e s f specific in the ordered set where uuid = &#63;.
	*
	* @param esfFederalRoleESFSpecificPK the primary key of the current e s f federal role e s f specific
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f federal role e s f specific
	* @throws it.ethica.esf.NoSuchFederalRoleESFSpecificException if a e s f federal role e s f specific with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFFederalRoleESFSpecific[] findByUuid_PrevAndNext(
		it.ethica.esf.service.persistence.ESFFederalRoleESFSpecificPK esfFederalRoleESFSpecificPK,
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFederalRoleESFSpecificException;

	/**
	* Removes all the e s f federal role e s f specifics where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f federal role e s f specifics where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching e s f federal role e s f specifics
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f federal role e s f specifics where esfSpecificId = &#63;.
	*
	* @param esfSpecificId the esf specific ID
	* @return the matching e s f federal role e s f specifics
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFFederalRoleESFSpecific> findBySpecific(
		long esfSpecificId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f federal role e s f specifics where esfSpecificId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFederalRoleESFSpecificModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfSpecificId the esf specific ID
	* @param start the lower bound of the range of e s f federal role e s f specifics
	* @param end the upper bound of the range of e s f federal role e s f specifics (not inclusive)
	* @return the range of matching e s f federal role e s f specifics
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFFederalRoleESFSpecific> findBySpecific(
		long esfSpecificId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f federal role e s f specifics where esfSpecificId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFederalRoleESFSpecificModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfSpecificId the esf specific ID
	* @param start the lower bound of the range of e s f federal role e s f specifics
	* @param end the upper bound of the range of e s f federal role e s f specifics (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f federal role e s f specifics
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFFederalRoleESFSpecific> findBySpecific(
		long esfSpecificId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f federal role e s f specific in the ordered set where esfSpecificId = &#63;.
	*
	* @param esfSpecificId the esf specific ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f federal role e s f specific
	* @throws it.ethica.esf.NoSuchFederalRoleESFSpecificException if a matching e s f federal role e s f specific could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFFederalRoleESFSpecific findBySpecific_First(
		long esfSpecificId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFederalRoleESFSpecificException;

	/**
	* Returns the first e s f federal role e s f specific in the ordered set where esfSpecificId = &#63;.
	*
	* @param esfSpecificId the esf specific ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f federal role e s f specific, or <code>null</code> if a matching e s f federal role e s f specific could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFFederalRoleESFSpecific fetchBySpecific_First(
		long esfSpecificId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f federal role e s f specific in the ordered set where esfSpecificId = &#63;.
	*
	* @param esfSpecificId the esf specific ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f federal role e s f specific
	* @throws it.ethica.esf.NoSuchFederalRoleESFSpecificException if a matching e s f federal role e s f specific could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFFederalRoleESFSpecific findBySpecific_Last(
		long esfSpecificId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFederalRoleESFSpecificException;

	/**
	* Returns the last e s f federal role e s f specific in the ordered set where esfSpecificId = &#63;.
	*
	* @param esfSpecificId the esf specific ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f federal role e s f specific, or <code>null</code> if a matching e s f federal role e s f specific could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFFederalRoleESFSpecific fetchBySpecific_Last(
		long esfSpecificId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f federal role e s f specifics before and after the current e s f federal role e s f specific in the ordered set where esfSpecificId = &#63;.
	*
	* @param esfFederalRoleESFSpecificPK the primary key of the current e s f federal role e s f specific
	* @param esfSpecificId the esf specific ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f federal role e s f specific
	* @throws it.ethica.esf.NoSuchFederalRoleESFSpecificException if a e s f federal role e s f specific with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFFederalRoleESFSpecific[] findBySpecific_PrevAndNext(
		it.ethica.esf.service.persistence.ESFFederalRoleESFSpecificPK esfFederalRoleESFSpecificPK,
		long esfSpecificId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFederalRoleESFSpecificException;

	/**
	* Removes all the e s f federal role e s f specifics where esfSpecificId = &#63; from the database.
	*
	* @param esfSpecificId the esf specific ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeBySpecific(long esfSpecificId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f federal role e s f specifics where esfSpecificId = &#63;.
	*
	* @param esfSpecificId the esf specific ID
	* @return the number of matching e s f federal role e s f specifics
	* @throws SystemException if a system exception occurred
	*/
	public int countBySpecific(long esfSpecificId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f federal role e s f specifics where esfFederalRoleId = &#63;.
	*
	* @param esfFederalRoleId the esf federal role ID
	* @return the matching e s f federal role e s f specifics
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFFederalRoleESFSpecific> findByFederalRole(
		long esfFederalRoleId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f federal role e s f specifics where esfFederalRoleId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFederalRoleESFSpecificModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfFederalRoleId the esf federal role ID
	* @param start the lower bound of the range of e s f federal role e s f specifics
	* @param end the upper bound of the range of e s f federal role e s f specifics (not inclusive)
	* @return the range of matching e s f federal role e s f specifics
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFFederalRoleESFSpecific> findByFederalRole(
		long esfFederalRoleId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f federal role e s f specifics where esfFederalRoleId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFederalRoleESFSpecificModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfFederalRoleId the esf federal role ID
	* @param start the lower bound of the range of e s f federal role e s f specifics
	* @param end the upper bound of the range of e s f federal role e s f specifics (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f federal role e s f specifics
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFFederalRoleESFSpecific> findByFederalRole(
		long esfFederalRoleId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f federal role e s f specific in the ordered set where esfFederalRoleId = &#63;.
	*
	* @param esfFederalRoleId the esf federal role ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f federal role e s f specific
	* @throws it.ethica.esf.NoSuchFederalRoleESFSpecificException if a matching e s f federal role e s f specific could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFFederalRoleESFSpecific findByFederalRole_First(
		long esfFederalRoleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFederalRoleESFSpecificException;

	/**
	* Returns the first e s f federal role e s f specific in the ordered set where esfFederalRoleId = &#63;.
	*
	* @param esfFederalRoleId the esf federal role ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f federal role e s f specific, or <code>null</code> if a matching e s f federal role e s f specific could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFFederalRoleESFSpecific fetchByFederalRole_First(
		long esfFederalRoleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f federal role e s f specific in the ordered set where esfFederalRoleId = &#63;.
	*
	* @param esfFederalRoleId the esf federal role ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f federal role e s f specific
	* @throws it.ethica.esf.NoSuchFederalRoleESFSpecificException if a matching e s f federal role e s f specific could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFFederalRoleESFSpecific findByFederalRole_Last(
		long esfFederalRoleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFederalRoleESFSpecificException;

	/**
	* Returns the last e s f federal role e s f specific in the ordered set where esfFederalRoleId = &#63;.
	*
	* @param esfFederalRoleId the esf federal role ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f federal role e s f specific, or <code>null</code> if a matching e s f federal role e s f specific could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFFederalRoleESFSpecific fetchByFederalRole_Last(
		long esfFederalRoleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f federal role e s f specifics before and after the current e s f federal role e s f specific in the ordered set where esfFederalRoleId = &#63;.
	*
	* @param esfFederalRoleESFSpecificPK the primary key of the current e s f federal role e s f specific
	* @param esfFederalRoleId the esf federal role ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f federal role e s f specific
	* @throws it.ethica.esf.NoSuchFederalRoleESFSpecificException if a e s f federal role e s f specific with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFFederalRoleESFSpecific[] findByFederalRole_PrevAndNext(
		it.ethica.esf.service.persistence.ESFFederalRoleESFSpecificPK esfFederalRoleESFSpecificPK,
		long esfFederalRoleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFederalRoleESFSpecificException;

	/**
	* Removes all the e s f federal role e s f specifics where esfFederalRoleId = &#63; from the database.
	*
	* @param esfFederalRoleId the esf federal role ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByFederalRole(long esfFederalRoleId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f federal role e s f specifics where esfFederalRoleId = &#63;.
	*
	* @param esfFederalRoleId the esf federal role ID
	* @return the number of matching e s f federal role e s f specifics
	* @throws SystemException if a system exception occurred
	*/
	public int countByFederalRole(long esfFederalRoleId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the e s f federal role e s f specific in the entity cache if it is enabled.
	*
	* @param esfFederalRoleESFSpecific the e s f federal role e s f specific
	*/
	public void cacheResult(
		it.ethica.esf.model.ESFFederalRoleESFSpecific esfFederalRoleESFSpecific);

	/**
	* Caches the e s f federal role e s f specifics in the entity cache if it is enabled.
	*
	* @param esfFederalRoleESFSpecifics the e s f federal role e s f specifics
	*/
	public void cacheResult(
		java.util.List<it.ethica.esf.model.ESFFederalRoleESFSpecific> esfFederalRoleESFSpecifics);

	/**
	* Creates a new e s f federal role e s f specific with the primary key. Does not add the e s f federal role e s f specific to the database.
	*
	* @param esfFederalRoleESFSpecificPK the primary key for the new e s f federal role e s f specific
	* @return the new e s f federal role e s f specific
	*/
	public it.ethica.esf.model.ESFFederalRoleESFSpecific create(
		it.ethica.esf.service.persistence.ESFFederalRoleESFSpecificPK esfFederalRoleESFSpecificPK);

	/**
	* Removes the e s f federal role e s f specific with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfFederalRoleESFSpecificPK the primary key of the e s f federal role e s f specific
	* @return the e s f federal role e s f specific that was removed
	* @throws it.ethica.esf.NoSuchFederalRoleESFSpecificException if a e s f federal role e s f specific with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFFederalRoleESFSpecific remove(
		it.ethica.esf.service.persistence.ESFFederalRoleESFSpecificPK esfFederalRoleESFSpecificPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFederalRoleESFSpecificException;

	public it.ethica.esf.model.ESFFederalRoleESFSpecific updateImpl(
		it.ethica.esf.model.ESFFederalRoleESFSpecific esfFederalRoleESFSpecific)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f federal role e s f specific with the primary key or throws a {@link it.ethica.esf.NoSuchFederalRoleESFSpecificException} if it could not be found.
	*
	* @param esfFederalRoleESFSpecificPK the primary key of the e s f federal role e s f specific
	* @return the e s f federal role e s f specific
	* @throws it.ethica.esf.NoSuchFederalRoleESFSpecificException if a e s f federal role e s f specific with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFFederalRoleESFSpecific findByPrimaryKey(
		it.ethica.esf.service.persistence.ESFFederalRoleESFSpecificPK esfFederalRoleESFSpecificPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFederalRoleESFSpecificException;

	/**
	* Returns the e s f federal role e s f specific with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param esfFederalRoleESFSpecificPK the primary key of the e s f federal role e s f specific
	* @return the e s f federal role e s f specific, or <code>null</code> if a e s f federal role e s f specific with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFFederalRoleESFSpecific fetchByPrimaryKey(
		it.ethica.esf.service.persistence.ESFFederalRoleESFSpecificPK esfFederalRoleESFSpecificPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f federal role e s f specifics.
	*
	* @return the e s f federal role e s f specifics
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFFederalRoleESFSpecific> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f federal role e s f specifics.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFederalRoleESFSpecificModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f federal role e s f specifics
	* @param end the upper bound of the range of e s f federal role e s f specifics (not inclusive)
	* @return the range of e s f federal role e s f specifics
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFFederalRoleESFSpecific> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f federal role e s f specifics.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFederalRoleESFSpecificModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f federal role e s f specifics
	* @param end the upper bound of the range of e s f federal role e s f specifics (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of e s f federal role e s f specifics
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFFederalRoleESFSpecific> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the e s f federal role e s f specifics from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f federal role e s f specifics.
	*
	* @return the number of e s f federal role e s f specifics
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}