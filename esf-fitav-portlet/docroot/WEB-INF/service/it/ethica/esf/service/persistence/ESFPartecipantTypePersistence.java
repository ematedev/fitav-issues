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

import it.ethica.esf.model.ESFPartecipantType;

/**
 * The persistence interface for the e s f partecipant type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFPartecipantTypePersistenceImpl
 * @see ESFPartecipantTypeUtil
 * @generated
 */
public interface ESFPartecipantTypePersistence extends BasePersistence<ESFPartecipantType> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ESFPartecipantTypeUtil} to access the e s f partecipant type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the e s f partecipant types where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching e s f partecipant types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFPartecipantType> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f partecipant types where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFPartecipantTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of e s f partecipant types
	* @param end the upper bound of the range of e s f partecipant types (not inclusive)
	* @return the range of matching e s f partecipant types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFPartecipantType> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f partecipant types where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFPartecipantTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of e s f partecipant types
	* @param end the upper bound of the range of e s f partecipant types (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f partecipant types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFPartecipantType> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f partecipant type in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f partecipant type
	* @throws it.ethica.esf.NoSuchPartecipantTypeException if a matching e s f partecipant type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFPartecipantType findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchPartecipantTypeException;

	/**
	* Returns the first e s f partecipant type in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f partecipant type, or <code>null</code> if a matching e s f partecipant type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFPartecipantType fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f partecipant type in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f partecipant type
	* @throws it.ethica.esf.NoSuchPartecipantTypeException if a matching e s f partecipant type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFPartecipantType findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchPartecipantTypeException;

	/**
	* Returns the last e s f partecipant type in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f partecipant type, or <code>null</code> if a matching e s f partecipant type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFPartecipantType fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f partecipant types before and after the current e s f partecipant type in the ordered set where uuid = &#63;.
	*
	* @param esfPartecipantTypeId the primary key of the current e s f partecipant type
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f partecipant type
	* @throws it.ethica.esf.NoSuchPartecipantTypeException if a e s f partecipant type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFPartecipantType[] findByUuid_PrevAndNext(
		long esfPartecipantTypeId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchPartecipantTypeException;

	/**
	* Removes all the e s f partecipant types where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f partecipant types where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching e s f partecipant types
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the e s f partecipant type in the entity cache if it is enabled.
	*
	* @param esfPartecipantType the e s f partecipant type
	*/
	public void cacheResult(
		it.ethica.esf.model.ESFPartecipantType esfPartecipantType);

	/**
	* Caches the e s f partecipant types in the entity cache if it is enabled.
	*
	* @param esfPartecipantTypes the e s f partecipant types
	*/
	public void cacheResult(
		java.util.List<it.ethica.esf.model.ESFPartecipantType> esfPartecipantTypes);

	/**
	* Creates a new e s f partecipant type with the primary key. Does not add the e s f partecipant type to the database.
	*
	* @param esfPartecipantTypeId the primary key for the new e s f partecipant type
	* @return the new e s f partecipant type
	*/
	public it.ethica.esf.model.ESFPartecipantType create(
		long esfPartecipantTypeId);

	/**
	* Removes the e s f partecipant type with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfPartecipantTypeId the primary key of the e s f partecipant type
	* @return the e s f partecipant type that was removed
	* @throws it.ethica.esf.NoSuchPartecipantTypeException if a e s f partecipant type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFPartecipantType remove(
		long esfPartecipantTypeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchPartecipantTypeException;

	public it.ethica.esf.model.ESFPartecipantType updateImpl(
		it.ethica.esf.model.ESFPartecipantType esfPartecipantType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f partecipant type with the primary key or throws a {@link it.ethica.esf.NoSuchPartecipantTypeException} if it could not be found.
	*
	* @param esfPartecipantTypeId the primary key of the e s f partecipant type
	* @return the e s f partecipant type
	* @throws it.ethica.esf.NoSuchPartecipantTypeException if a e s f partecipant type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFPartecipantType findByPrimaryKey(
		long esfPartecipantTypeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchPartecipantTypeException;

	/**
	* Returns the e s f partecipant type with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param esfPartecipantTypeId the primary key of the e s f partecipant type
	* @return the e s f partecipant type, or <code>null</code> if a e s f partecipant type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFPartecipantType fetchByPrimaryKey(
		long esfPartecipantTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f partecipant types.
	*
	* @return the e s f partecipant types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFPartecipantType> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f partecipant types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFPartecipantTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f partecipant types
	* @param end the upper bound of the range of e s f partecipant types (not inclusive)
	* @return the range of e s f partecipant types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFPartecipantType> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f partecipant types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFPartecipantTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f partecipant types
	* @param end the upper bound of the range of e s f partecipant types (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of e s f partecipant types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFPartecipantType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the e s f partecipant types from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f partecipant types.
	*
	* @return the number of e s f partecipant types
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}