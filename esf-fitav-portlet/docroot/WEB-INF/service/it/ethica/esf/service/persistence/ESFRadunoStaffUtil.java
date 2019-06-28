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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import it.ethica.esf.model.ESFRadunoStaff;

import java.util.List;

/**
 * The persistence utility for the e s f raduno staff service. This utility wraps {@link ESFRadunoStaffPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFRadunoStaffPersistence
 * @see ESFRadunoStaffPersistenceImpl
 * @generated
 */
public class ESFRadunoStaffUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(ESFRadunoStaff esfRadunoStaff) {
		getPersistence().clearCache(esfRadunoStaff);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ESFRadunoStaff> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ESFRadunoStaff> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ESFRadunoStaff> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ESFRadunoStaff update(ESFRadunoStaff esfRadunoStaff)
		throws SystemException {
		return getPersistence().update(esfRadunoStaff);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ESFRadunoStaff update(ESFRadunoStaff esfRadunoStaff,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(esfRadunoStaff, serviceContext);
	}

	/**
	* Returns the e s f raduno staff where id_esf_raduno = &#63; and userId = &#63; or throws a {@link it.ethica.esf.NoSuchRadunoStaffException} if it could not be found.
	*
	* @param id_esf_raduno the id_esf_raduno
	* @param userId the user ID
	* @return the matching e s f raduno staff
	* @throws it.ethica.esf.NoSuchRadunoStaffException if a matching e s f raduno staff could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFRadunoStaff findByfindRadunoStaff(
		long id_esf_raduno, long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchRadunoStaffException {
		return getPersistence().findByfindRadunoStaff(id_esf_raduno, userId);
	}

	/**
	* Returns the e s f raduno staff where id_esf_raduno = &#63; and userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param id_esf_raduno the id_esf_raduno
	* @param userId the user ID
	* @return the matching e s f raduno staff, or <code>null</code> if a matching e s f raduno staff could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFRadunoStaff fetchByfindRadunoStaff(
		long id_esf_raduno, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByfindRadunoStaff(id_esf_raduno, userId);
	}

	/**
	* Returns the e s f raduno staff where id_esf_raduno = &#63; and userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param id_esf_raduno the id_esf_raduno
	* @param userId the user ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching e s f raduno staff, or <code>null</code> if a matching e s f raduno staff could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFRadunoStaff fetchByfindRadunoStaff(
		long id_esf_raduno, long userId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByfindRadunoStaff(id_esf_raduno, userId,
			retrieveFromCache);
	}

	/**
	* Removes the e s f raduno staff where id_esf_raduno = &#63; and userId = &#63; from the database.
	*
	* @param id_esf_raduno the id_esf_raduno
	* @param userId the user ID
	* @return the e s f raduno staff that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFRadunoStaff removeByfindRadunoStaff(
		long id_esf_raduno, long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchRadunoStaffException {
		return getPersistence().removeByfindRadunoStaff(id_esf_raduno, userId);
	}

	/**
	* Returns the number of e s f raduno staffs where id_esf_raduno = &#63; and userId = &#63;.
	*
	* @param id_esf_raduno the id_esf_raduno
	* @param userId the user ID
	* @return the number of matching e s f raduno staffs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByfindRadunoStaff(long id_esf_raduno, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByfindRadunoStaff(id_esf_raduno, userId);
	}

	/**
	* Returns all the e s f raduno staffs where id_esf_raduno = &#63;.
	*
	* @param id_esf_raduno the id_esf_raduno
	* @return the matching e s f raduno staffs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFRadunoStaff> findByfindByIdRaduno(
		long id_esf_raduno)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByfindByIdRaduno(id_esf_raduno);
	}

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
	public static java.util.List<it.ethica.esf.model.ESFRadunoStaff> findByfindByIdRaduno(
		long id_esf_raduno, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByfindByIdRaduno(id_esf_raduno, start, end);
	}

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
	public static java.util.List<it.ethica.esf.model.ESFRadunoStaff> findByfindByIdRaduno(
		long id_esf_raduno, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByfindByIdRaduno(id_esf_raduno, start, end,
			orderByComparator);
	}

	/**
	* Returns the first e s f raduno staff in the ordered set where id_esf_raduno = &#63;.
	*
	* @param id_esf_raduno the id_esf_raduno
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f raduno staff
	* @throws it.ethica.esf.NoSuchRadunoStaffException if a matching e s f raduno staff could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFRadunoStaff findByfindByIdRaduno_First(
		long id_esf_raduno,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchRadunoStaffException {
		return getPersistence()
				   .findByfindByIdRaduno_First(id_esf_raduno, orderByComparator);
	}

	/**
	* Returns the first e s f raduno staff in the ordered set where id_esf_raduno = &#63;.
	*
	* @param id_esf_raduno the id_esf_raduno
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f raduno staff, or <code>null</code> if a matching e s f raduno staff could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFRadunoStaff fetchByfindByIdRaduno_First(
		long id_esf_raduno,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByfindByIdRaduno_First(id_esf_raduno, orderByComparator);
	}

	/**
	* Returns the last e s f raduno staff in the ordered set where id_esf_raduno = &#63;.
	*
	* @param id_esf_raduno the id_esf_raduno
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f raduno staff
	* @throws it.ethica.esf.NoSuchRadunoStaffException if a matching e s f raduno staff could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFRadunoStaff findByfindByIdRaduno_Last(
		long id_esf_raduno,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchRadunoStaffException {
		return getPersistence()
				   .findByfindByIdRaduno_Last(id_esf_raduno, orderByComparator);
	}

	/**
	* Returns the last e s f raduno staff in the ordered set where id_esf_raduno = &#63;.
	*
	* @param id_esf_raduno the id_esf_raduno
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f raduno staff, or <code>null</code> if a matching e s f raduno staff could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFRadunoStaff fetchByfindByIdRaduno_Last(
		long id_esf_raduno,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByfindByIdRaduno_Last(id_esf_raduno, orderByComparator);
	}

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
	public static it.ethica.esf.model.ESFRadunoStaff[] findByfindByIdRaduno_PrevAndNext(
		it.ethica.esf.service.persistence.ESFRadunoStaffPK esfRadunoStaffPK,
		long id_esf_raduno,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchRadunoStaffException {
		return getPersistence()
				   .findByfindByIdRaduno_PrevAndNext(esfRadunoStaffPK,
			id_esf_raduno, orderByComparator);
	}

	/**
	* Removes all the e s f raduno staffs where id_esf_raduno = &#63; from the database.
	*
	* @param id_esf_raduno the id_esf_raduno
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByfindByIdRaduno(long id_esf_raduno)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByfindByIdRaduno(id_esf_raduno);
	}

	/**
	* Returns the number of e s f raduno staffs where id_esf_raduno = &#63;.
	*
	* @param id_esf_raduno the id_esf_raduno
	* @return the number of matching e s f raduno staffs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByfindByIdRaduno(long id_esf_raduno)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByfindByIdRaduno(id_esf_raduno);
	}

	/**
	* Caches the e s f raduno staff in the entity cache if it is enabled.
	*
	* @param esfRadunoStaff the e s f raduno staff
	*/
	public static void cacheResult(
		it.ethica.esf.model.ESFRadunoStaff esfRadunoStaff) {
		getPersistence().cacheResult(esfRadunoStaff);
	}

	/**
	* Caches the e s f raduno staffs in the entity cache if it is enabled.
	*
	* @param esfRadunoStaffs the e s f raduno staffs
	*/
	public static void cacheResult(
		java.util.List<it.ethica.esf.model.ESFRadunoStaff> esfRadunoStaffs) {
		getPersistence().cacheResult(esfRadunoStaffs);
	}

	/**
	* Creates a new e s f raduno staff with the primary key. Does not add the e s f raduno staff to the database.
	*
	* @param esfRadunoStaffPK the primary key for the new e s f raduno staff
	* @return the new e s f raduno staff
	*/
	public static it.ethica.esf.model.ESFRadunoStaff create(
		it.ethica.esf.service.persistence.ESFRadunoStaffPK esfRadunoStaffPK) {
		return getPersistence().create(esfRadunoStaffPK);
	}

	/**
	* Removes the e s f raduno staff with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfRadunoStaffPK the primary key of the e s f raduno staff
	* @return the e s f raduno staff that was removed
	* @throws it.ethica.esf.NoSuchRadunoStaffException if a e s f raduno staff with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFRadunoStaff remove(
		it.ethica.esf.service.persistence.ESFRadunoStaffPK esfRadunoStaffPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchRadunoStaffException {
		return getPersistence().remove(esfRadunoStaffPK);
	}

	public static it.ethica.esf.model.ESFRadunoStaff updateImpl(
		it.ethica.esf.model.ESFRadunoStaff esfRadunoStaff)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(esfRadunoStaff);
	}

	/**
	* Returns the e s f raduno staff with the primary key or throws a {@link it.ethica.esf.NoSuchRadunoStaffException} if it could not be found.
	*
	* @param esfRadunoStaffPK the primary key of the e s f raduno staff
	* @return the e s f raduno staff
	* @throws it.ethica.esf.NoSuchRadunoStaffException if a e s f raduno staff with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFRadunoStaff findByPrimaryKey(
		it.ethica.esf.service.persistence.ESFRadunoStaffPK esfRadunoStaffPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchRadunoStaffException {
		return getPersistence().findByPrimaryKey(esfRadunoStaffPK);
	}

	/**
	* Returns the e s f raduno staff with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param esfRadunoStaffPK the primary key of the e s f raduno staff
	* @return the e s f raduno staff, or <code>null</code> if a e s f raduno staff with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFRadunoStaff fetchByPrimaryKey(
		it.ethica.esf.service.persistence.ESFRadunoStaffPK esfRadunoStaffPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(esfRadunoStaffPK);
	}

	/**
	* Returns all the e s f raduno staffs.
	*
	* @return the e s f raduno staffs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFRadunoStaff> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<it.ethica.esf.model.ESFRadunoStaff> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<it.ethica.esf.model.ESFRadunoStaff> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the e s f raduno staffs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of e s f raduno staffs.
	*
	* @return the number of e s f raduno staffs
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ESFRadunoStaffPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ESFRadunoStaffPersistence)PortletBeanLocatorUtil.locate(it.ethica.esf.service.ClpSerializer.getServletContextName(),
					ESFRadunoStaffPersistence.class.getName());

			ReferenceRegistry.registerReference(ESFRadunoStaffUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ESFRadunoStaffPersistence persistence) {
	}

	private static ESFRadunoStaffPersistence _persistence;
}