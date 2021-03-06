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

import it.ethica.esf.model.ESFFieldESFSportType;

/**
 * The persistence interface for the e s f field e s f sport type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFFieldESFSportTypePersistenceImpl
 * @see ESFFieldESFSportTypeUtil
 * @generated
 */
public interface ESFFieldESFSportTypePersistence extends BasePersistence<ESFFieldESFSportType> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ESFFieldESFSportTypeUtil} to access the e s f field e s f sport type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the e s f field e s f sport types where esfFieldId = &#63;.
	*
	* @param esfFieldId the esf field ID
	* @return the matching e s f field e s f sport types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFFieldESFSportType> findByesfFieldId(
		long esfFieldId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f field e s f sport types where esfFieldId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFieldESFSportTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfFieldId the esf field ID
	* @param start the lower bound of the range of e s f field e s f sport types
	* @param end the upper bound of the range of e s f field e s f sport types (not inclusive)
	* @return the range of matching e s f field e s f sport types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFFieldESFSportType> findByesfFieldId(
		long esfFieldId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f field e s f sport types where esfFieldId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFieldESFSportTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfFieldId the esf field ID
	* @param start the lower bound of the range of e s f field e s f sport types
	* @param end the upper bound of the range of e s f field e s f sport types (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f field e s f sport types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFFieldESFSportType> findByesfFieldId(
		long esfFieldId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f field e s f sport type in the ordered set where esfFieldId = &#63;.
	*
	* @param esfFieldId the esf field ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f field e s f sport type
	* @throws it.ethica.esf.NoSuchFieldESFSportTypeException if a matching e s f field e s f sport type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFFieldESFSportType findByesfFieldId_First(
		long esfFieldId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFieldESFSportTypeException;

	/**
	* Returns the first e s f field e s f sport type in the ordered set where esfFieldId = &#63;.
	*
	* @param esfFieldId the esf field ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f field e s f sport type, or <code>null</code> if a matching e s f field e s f sport type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFFieldESFSportType fetchByesfFieldId_First(
		long esfFieldId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f field e s f sport type in the ordered set where esfFieldId = &#63;.
	*
	* @param esfFieldId the esf field ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f field e s f sport type
	* @throws it.ethica.esf.NoSuchFieldESFSportTypeException if a matching e s f field e s f sport type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFFieldESFSportType findByesfFieldId_Last(
		long esfFieldId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFieldESFSportTypeException;

	/**
	* Returns the last e s f field e s f sport type in the ordered set where esfFieldId = &#63;.
	*
	* @param esfFieldId the esf field ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f field e s f sport type, or <code>null</code> if a matching e s f field e s f sport type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFFieldESFSportType fetchByesfFieldId_Last(
		long esfFieldId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f field e s f sport types before and after the current e s f field e s f sport type in the ordered set where esfFieldId = &#63;.
	*
	* @param esfFieldESFSportTypePK the primary key of the current e s f field e s f sport type
	* @param esfFieldId the esf field ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f field e s f sport type
	* @throws it.ethica.esf.NoSuchFieldESFSportTypeException if a e s f field e s f sport type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFFieldESFSportType[] findByesfFieldId_PrevAndNext(
		it.ethica.esf.service.persistence.ESFFieldESFSportTypePK esfFieldESFSportTypePK,
		long esfFieldId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFieldESFSportTypeException;

	/**
	* Removes all the e s f field e s f sport types where esfFieldId = &#63; from the database.
	*
	* @param esfFieldId the esf field ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByesfFieldId(long esfFieldId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f field e s f sport types where esfFieldId = &#63;.
	*
	* @param esfFieldId the esf field ID
	* @return the number of matching e s f field e s f sport types
	* @throws SystemException if a system exception occurred
	*/
	public int countByesfFieldId(long esfFieldId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f field e s f sport types where esfSportTypeId = &#63;.
	*
	* @param esfSportTypeId the esf sport type ID
	* @return the matching e s f field e s f sport types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFFieldESFSportType> findByesfSportTypeId(
		long esfSportTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f field e s f sport types where esfSportTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFieldESFSportTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfSportTypeId the esf sport type ID
	* @param start the lower bound of the range of e s f field e s f sport types
	* @param end the upper bound of the range of e s f field e s f sport types (not inclusive)
	* @return the range of matching e s f field e s f sport types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFFieldESFSportType> findByesfSportTypeId(
		long esfSportTypeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f field e s f sport types where esfSportTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFieldESFSportTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfSportTypeId the esf sport type ID
	* @param start the lower bound of the range of e s f field e s f sport types
	* @param end the upper bound of the range of e s f field e s f sport types (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f field e s f sport types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFFieldESFSportType> findByesfSportTypeId(
		long esfSportTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f field e s f sport type in the ordered set where esfSportTypeId = &#63;.
	*
	* @param esfSportTypeId the esf sport type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f field e s f sport type
	* @throws it.ethica.esf.NoSuchFieldESFSportTypeException if a matching e s f field e s f sport type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFFieldESFSportType findByesfSportTypeId_First(
		long esfSportTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFieldESFSportTypeException;

	/**
	* Returns the first e s f field e s f sport type in the ordered set where esfSportTypeId = &#63;.
	*
	* @param esfSportTypeId the esf sport type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f field e s f sport type, or <code>null</code> if a matching e s f field e s f sport type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFFieldESFSportType fetchByesfSportTypeId_First(
		long esfSportTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f field e s f sport type in the ordered set where esfSportTypeId = &#63;.
	*
	* @param esfSportTypeId the esf sport type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f field e s f sport type
	* @throws it.ethica.esf.NoSuchFieldESFSportTypeException if a matching e s f field e s f sport type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFFieldESFSportType findByesfSportTypeId_Last(
		long esfSportTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFieldESFSportTypeException;

	/**
	* Returns the last e s f field e s f sport type in the ordered set where esfSportTypeId = &#63;.
	*
	* @param esfSportTypeId the esf sport type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f field e s f sport type, or <code>null</code> if a matching e s f field e s f sport type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFFieldESFSportType fetchByesfSportTypeId_Last(
		long esfSportTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f field e s f sport types before and after the current e s f field e s f sport type in the ordered set where esfSportTypeId = &#63;.
	*
	* @param esfFieldESFSportTypePK the primary key of the current e s f field e s f sport type
	* @param esfSportTypeId the esf sport type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f field e s f sport type
	* @throws it.ethica.esf.NoSuchFieldESFSportTypeException if a e s f field e s f sport type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFFieldESFSportType[] findByesfSportTypeId_PrevAndNext(
		it.ethica.esf.service.persistence.ESFFieldESFSportTypePK esfFieldESFSportTypePK,
		long esfSportTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFieldESFSportTypeException;

	/**
	* Removes all the e s f field e s f sport types where esfSportTypeId = &#63; from the database.
	*
	* @param esfSportTypeId the esf sport type ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByesfSportTypeId(long esfSportTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f field e s f sport types where esfSportTypeId = &#63;.
	*
	* @param esfSportTypeId the esf sport type ID
	* @return the number of matching e s f field e s f sport types
	* @throws SystemException if a system exception occurred
	*/
	public int countByesfSportTypeId(long esfSportTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the e s f field e s f sport type in the entity cache if it is enabled.
	*
	* @param esfFieldESFSportType the e s f field e s f sport type
	*/
	public void cacheResult(
		it.ethica.esf.model.ESFFieldESFSportType esfFieldESFSportType);

	/**
	* Caches the e s f field e s f sport types in the entity cache if it is enabled.
	*
	* @param esfFieldESFSportTypes the e s f field e s f sport types
	*/
	public void cacheResult(
		java.util.List<it.ethica.esf.model.ESFFieldESFSportType> esfFieldESFSportTypes);

	/**
	* Creates a new e s f field e s f sport type with the primary key. Does not add the e s f field e s f sport type to the database.
	*
	* @param esfFieldESFSportTypePK the primary key for the new e s f field e s f sport type
	* @return the new e s f field e s f sport type
	*/
	public it.ethica.esf.model.ESFFieldESFSportType create(
		it.ethica.esf.service.persistence.ESFFieldESFSportTypePK esfFieldESFSportTypePK);

	/**
	* Removes the e s f field e s f sport type with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfFieldESFSportTypePK the primary key of the e s f field e s f sport type
	* @return the e s f field e s f sport type that was removed
	* @throws it.ethica.esf.NoSuchFieldESFSportTypeException if a e s f field e s f sport type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFFieldESFSportType remove(
		it.ethica.esf.service.persistence.ESFFieldESFSportTypePK esfFieldESFSportTypePK)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFieldESFSportTypeException;

	public it.ethica.esf.model.ESFFieldESFSportType updateImpl(
		it.ethica.esf.model.ESFFieldESFSportType esfFieldESFSportType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f field e s f sport type with the primary key or throws a {@link it.ethica.esf.NoSuchFieldESFSportTypeException} if it could not be found.
	*
	* @param esfFieldESFSportTypePK the primary key of the e s f field e s f sport type
	* @return the e s f field e s f sport type
	* @throws it.ethica.esf.NoSuchFieldESFSportTypeException if a e s f field e s f sport type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFFieldESFSportType findByPrimaryKey(
		it.ethica.esf.service.persistence.ESFFieldESFSportTypePK esfFieldESFSportTypePK)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFieldESFSportTypeException;

	/**
	* Returns the e s f field e s f sport type with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param esfFieldESFSportTypePK the primary key of the e s f field e s f sport type
	* @return the e s f field e s f sport type, or <code>null</code> if a e s f field e s f sport type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFFieldESFSportType fetchByPrimaryKey(
		it.ethica.esf.service.persistence.ESFFieldESFSportTypePK esfFieldESFSportTypePK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f field e s f sport types.
	*
	* @return the e s f field e s f sport types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFFieldESFSportType> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f field e s f sport types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFieldESFSportTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f field e s f sport types
	* @param end the upper bound of the range of e s f field e s f sport types (not inclusive)
	* @return the range of e s f field e s f sport types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFFieldESFSportType> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f field e s f sport types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFieldESFSportTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f field e s f sport types
	* @param end the upper bound of the range of e s f field e s f sport types (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of e s f field e s f sport types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFFieldESFSportType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the e s f field e s f sport types from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f field e s f sport types.
	*
	* @return the number of e s f field e s f sport types
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}