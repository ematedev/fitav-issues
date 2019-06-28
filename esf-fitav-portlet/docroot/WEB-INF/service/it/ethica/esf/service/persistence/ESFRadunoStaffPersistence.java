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

import it.ethica.esf.model.ESFRadunoStaff;

/**
 * The persistence interface for the e s f raduno staff service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFRadunoStaffPersistenceImpl
 * @see ESFRadunoStaffUtil
 * @generated
 */
public interface ESFRadunoStaffPersistence extends BasePersistence<ESFRadunoStaff> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ESFRadunoStaffUtil} to access the e s f raduno staff persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the e s f raduno staff where id_esf_raduno = &#63; and userId = &#63; or throws a {@link it.ethica.esf.NoSuchRadunoStaffException} if it could not be found.
	*
	* @param id_esf_raduno the id_esf_raduno
	* @param userId the user ID
	* @return the matching e s f raduno staff
	* @throws it.ethica.esf.NoSuchRadunoStaffException if a matching e s f raduno staff could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFRadunoStaff findByfindRadunoStaff(
		long id_esf_raduno, long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchRadunoStaffException;

	/**
	* Returns the e s f raduno staff where id_esf_raduno = &#63; and userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param id_esf_raduno the id_esf_raduno
	* @param userId the user ID
	* @return the matching e s f raduno staff, or <code>null</code> if a matching e s f raduno staff could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFRadunoStaff fetchByfindRadunoStaff(
		long id_esf_raduno, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f raduno staff where id_esf_raduno = &#63; and userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param id_esf_raduno the id_esf_raduno
	* @param userId the user ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching e s f raduno staff, or <code>null</code> if a matching e s f raduno staff could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFRadunoStaff fetchByfindRadunoStaff(
		long id_esf_raduno, long userId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the e s f raduno staff where id_esf_raduno = &#63; and userId = &#63; from the database.
	*
	* @param id_esf_raduno the id_esf_raduno
	* @param userId the user ID
	* @return the e s f raduno staff that was removed
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFRadunoStaff removeByfindRadunoStaff(
		long id_esf_raduno, long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchRadunoStaffException;

	/**
	* Returns the number of e s f raduno staffs where id_esf_raduno = &#63; and userId = &#63;.
	*
	* @param id_esf_raduno the id_esf_raduno
	* @param userId the user ID
	* @return the number of matching e s f raduno staffs
	* @throws SystemException if a system exception occurred
	*/
	public int countByfindRadunoStaff(long id_esf_raduno, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f raduno staffs where id_esf_raduno = &#63;.
	*
	* @param id_esf_raduno the id_esf_raduno
	* @return the matching e s f raduno staffs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFRadunoStaff> findByfindByIdRaduno(
		long id_esf_raduno)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f raduno staffs where id_esf_raduno = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFRadunoStaffModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id_esf_raduno the id_esf_raduno
	* @param start the lower bound of the range of e s f raduno staffs
	* @param end the upper bound of the range of e s f raduno staffs (not inclusive)
	* @return the range of matching e s f raduno staffs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFRadunoStaff> findByfindByIdRaduno(
		long id_esf_raduno, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f raduno staffs where id_esf_raduno = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFRadunoStaffModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id_esf_raduno the id_esf_raduno
	* @param start the lower bound of the range of e s f raduno staffs
	* @param end the upper bound of the range of e s f raduno staffs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f raduno staffs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFRadunoStaff> findByfindByIdRaduno(
		long id_esf_raduno, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f raduno staff in the ordered set where id_esf_raduno = &#63;.
	*
	* @param id_esf_raduno the id_esf_raduno
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f raduno staff
	* @throws it.ethica.esf.NoSuchRadunoStaffException if a matching e s f raduno staff could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFRadunoStaff findByfindByIdRaduno_First(
		long id_esf_raduno,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchRadunoStaffException;

	/**
	* Returns the first e s f raduno staff in the ordered set where id_esf_raduno = &#63;.
	*
	* @param id_esf_raduno the id_esf_raduno
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f raduno staff, or <code>null</code> if a matching e s f raduno staff could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFRadunoStaff fetchByfindByIdRaduno_First(
		long id_esf_raduno,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f raduno staff in the ordered set where id_esf_raduno = &#63;.
	*
	* @param id_esf_raduno the id_esf_raduno
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f raduno staff
	* @throws it.ethica.esf.NoSuchRadunoStaffException if a matching e s f raduno staff could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFRadunoStaff findByfindByIdRaduno_Last(
		long id_esf_raduno,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchRadunoStaffException;

	/**
	* Returns the last e s f raduno staff in the ordered set where id_esf_raduno = &#63;.
	*
	* @param id_esf_raduno the id_esf_raduno
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f raduno staff, or <code>null</code> if a matching e s f raduno staff could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFRadunoStaff fetchByfindByIdRaduno_Last(
		long id_esf_raduno,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f raduno staffs before and after the current e s f raduno staff in the ordered set where id_esf_raduno = &#63;.
	*
	* @param esfRadunoStaffPK the primary key of the current e s f raduno staff
	* @param id_esf_raduno the id_esf_raduno
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f raduno staff
	* @throws it.ethica.esf.NoSuchRadunoStaffException if a e s f raduno staff with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFRadunoStaff[] findByfindByIdRaduno_PrevAndNext(
		it.ethica.esf.service.persistence.ESFRadunoStaffPK esfRadunoStaffPK,
		long id_esf_raduno,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchRadunoStaffException;

	/**
	* Removes all the e s f raduno staffs where id_esf_raduno = &#63; from the database.
	*
	* @param id_esf_raduno the id_esf_raduno
	* @throws SystemException if a system exception occurred
	*/
	public void removeByfindByIdRaduno(long id_esf_raduno)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f raduno staffs where id_esf_raduno = &#63;.
	*
	* @param id_esf_raduno the id_esf_raduno
	* @return the number of matching e s f raduno staffs
	* @throws SystemException if a system exception occurred
	*/
	public int countByfindByIdRaduno(long id_esf_raduno)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the e s f raduno staff in the entity cache if it is enabled.
	*
	* @param esfRadunoStaff the e s f raduno staff
	*/
	public void cacheResult(it.ethica.esf.model.ESFRadunoStaff esfRadunoStaff);

	/**
	* Caches the e s f raduno staffs in the entity cache if it is enabled.
	*
	* @param esfRadunoStaffs the e s f raduno staffs
	*/
	public void cacheResult(
		java.util.List<it.ethica.esf.model.ESFRadunoStaff> esfRadunoStaffs);

	/**
	* Creates a new e s f raduno staff with the primary key. Does not add the e s f raduno staff to the database.
	*
	* @param esfRadunoStaffPK the primary key for the new e s f raduno staff
	* @return the new e s f raduno staff
	*/
	public it.ethica.esf.model.ESFRadunoStaff create(
		it.ethica.esf.service.persistence.ESFRadunoStaffPK esfRadunoStaffPK);

	/**
	* Removes the e s f raduno staff with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfRadunoStaffPK the primary key of the e s f raduno staff
	* @return the e s f raduno staff that was removed
	* @throws it.ethica.esf.NoSuchRadunoStaffException if a e s f raduno staff with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFRadunoStaff remove(
		it.ethica.esf.service.persistence.ESFRadunoStaffPK esfRadunoStaffPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchRadunoStaffException;

	public it.ethica.esf.model.ESFRadunoStaff updateImpl(
		it.ethica.esf.model.ESFRadunoStaff esfRadunoStaff)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f raduno staff with the primary key or throws a {@link it.ethica.esf.NoSuchRadunoStaffException} if it could not be found.
	*
	* @param esfRadunoStaffPK the primary key of the e s f raduno staff
	* @return the e s f raduno staff
	* @throws it.ethica.esf.NoSuchRadunoStaffException if a e s f raduno staff with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFRadunoStaff findByPrimaryKey(
		it.ethica.esf.service.persistence.ESFRadunoStaffPK esfRadunoStaffPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchRadunoStaffException;

	/**
	* Returns the e s f raduno staff with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param esfRadunoStaffPK the primary key of the e s f raduno staff
	* @return the e s f raduno staff, or <code>null</code> if a e s f raduno staff with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFRadunoStaff fetchByPrimaryKey(
		it.ethica.esf.service.persistence.ESFRadunoStaffPK esfRadunoStaffPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f raduno staffs.
	*
	* @return the e s f raduno staffs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFRadunoStaff> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f raduno staffs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFRadunoStaffModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f raduno staffs
	* @param end the upper bound of the range of e s f raduno staffs (not inclusive)
	* @return the range of e s f raduno staffs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFRadunoStaff> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f raduno staffs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFRadunoStaffModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f raduno staffs
	* @param end the upper bound of the range of e s f raduno staffs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of e s f raduno staffs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFRadunoStaff> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the e s f raduno staffs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f raduno staffs.
	*
	* @return the number of e s f raduno staffs
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}