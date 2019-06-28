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

import it.ethica.esf.model.EsfRadunoShooters;

import java.util.List;

/**
 * The persistence utility for the esf raduno shooters service. This utility wraps {@link EsfRadunoShootersPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see EsfRadunoShootersPersistence
 * @see EsfRadunoShootersPersistenceImpl
 * @generated
 */
public class EsfRadunoShootersUtil {
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
	public static void clearCache(EsfRadunoShooters esfRadunoShooters) {
		getPersistence().clearCache(esfRadunoShooters);
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
	public static List<EsfRadunoShooters> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EsfRadunoShooters> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EsfRadunoShooters> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static EsfRadunoShooters update(EsfRadunoShooters esfRadunoShooters)
		throws SystemException {
		return getPersistence().update(esfRadunoShooters);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static EsfRadunoShooters update(
		EsfRadunoShooters esfRadunoShooters, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(esfRadunoShooters, serviceContext);
	}

	/**
	* Returns the esf raduno shooters where id_esf_raduno = &#63; and userId = &#63; or throws a {@link it.ethica.esf.NoSuchEsfRadunoShootersException} if it could not be found.
	*
	* @param id_esf_raduno the id_esf_raduno
	* @param userId the user ID
	* @return the matching esf raduno shooters
	* @throws it.ethica.esf.NoSuchEsfRadunoShootersException if a matching esf raduno shooters could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.EsfRadunoShooters findByfindRadunoShooters(
		long id_esf_raduno, long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchEsfRadunoShootersException {
		return getPersistence().findByfindRadunoShooters(id_esf_raduno, userId);
	}

	/**
	* Returns the esf raduno shooters where id_esf_raduno = &#63; and userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param id_esf_raduno the id_esf_raduno
	* @param userId the user ID
	* @return the matching esf raduno shooters, or <code>null</code> if a matching esf raduno shooters could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.EsfRadunoShooters fetchByfindRadunoShooters(
		long id_esf_raduno, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByfindRadunoShooters(id_esf_raduno, userId);
	}

	/**
	* Returns the esf raduno shooters where id_esf_raduno = &#63; and userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param id_esf_raduno the id_esf_raduno
	* @param userId the user ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching esf raduno shooters, or <code>null</code> if a matching esf raduno shooters could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.EsfRadunoShooters fetchByfindRadunoShooters(
		long id_esf_raduno, long userId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByfindRadunoShooters(id_esf_raduno, userId,
			retrieveFromCache);
	}

	/**
	* Removes the esf raduno shooters where id_esf_raduno = &#63; and userId = &#63; from the database.
	*
	* @param id_esf_raduno the id_esf_raduno
	* @param userId the user ID
	* @return the esf raduno shooters that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.EsfRadunoShooters removeByfindRadunoShooters(
		long id_esf_raduno, long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchEsfRadunoShootersException {
		return getPersistence().removeByfindRadunoShooters(id_esf_raduno, userId);
	}

	/**
	* Returns the number of esf raduno shooterses where id_esf_raduno = &#63; and userId = &#63;.
	*
	* @param id_esf_raduno the id_esf_raduno
	* @param userId the user ID
	* @return the number of matching esf raduno shooterses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByfindRadunoShooters(long id_esf_raduno, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByfindRadunoShooters(id_esf_raduno, userId);
	}

	/**
	* Returns all the esf raduno shooterses where id_esf_raduno = &#63;.
	*
	* @param id_esf_raduno the id_esf_raduno
	* @return the matching esf raduno shooterses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.EsfRadunoShooters> findByfindByRaduno(
		long id_esf_raduno)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByfindByRaduno(id_esf_raduno);
	}

	/**
	* Returns a range of all the esf raduno shooterses where id_esf_raduno = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.EsfRadunoShootersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id_esf_raduno the id_esf_raduno
	* @param start the lower bound of the range of esf raduno shooterses
	* @param end the upper bound of the range of esf raduno shooterses (not inclusive)
	* @return the range of matching esf raduno shooterses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.EsfRadunoShooters> findByfindByRaduno(
		long id_esf_raduno, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByfindByRaduno(id_esf_raduno, start, end);
	}

	/**
	* Returns an ordered range of all the esf raduno shooterses where id_esf_raduno = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.EsfRadunoShootersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id_esf_raduno the id_esf_raduno
	* @param start the lower bound of the range of esf raduno shooterses
	* @param end the upper bound of the range of esf raduno shooterses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching esf raduno shooterses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.EsfRadunoShooters> findByfindByRaduno(
		long id_esf_raduno, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByfindByRaduno(id_esf_raduno, start, end,
			orderByComparator);
	}

	/**
	* Returns the first esf raduno shooters in the ordered set where id_esf_raduno = &#63;.
	*
	* @param id_esf_raduno the id_esf_raduno
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching esf raduno shooters
	* @throws it.ethica.esf.NoSuchEsfRadunoShootersException if a matching esf raduno shooters could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.EsfRadunoShooters findByfindByRaduno_First(
		long id_esf_raduno,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchEsfRadunoShootersException {
		return getPersistence()
				   .findByfindByRaduno_First(id_esf_raduno, orderByComparator);
	}

	/**
	* Returns the first esf raduno shooters in the ordered set where id_esf_raduno = &#63;.
	*
	* @param id_esf_raduno the id_esf_raduno
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching esf raduno shooters, or <code>null</code> if a matching esf raduno shooters could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.EsfRadunoShooters fetchByfindByRaduno_First(
		long id_esf_raduno,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByfindByRaduno_First(id_esf_raduno, orderByComparator);
	}

	/**
	* Returns the last esf raduno shooters in the ordered set where id_esf_raduno = &#63;.
	*
	* @param id_esf_raduno the id_esf_raduno
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching esf raduno shooters
	* @throws it.ethica.esf.NoSuchEsfRadunoShootersException if a matching esf raduno shooters could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.EsfRadunoShooters findByfindByRaduno_Last(
		long id_esf_raduno,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchEsfRadunoShootersException {
		return getPersistence()
				   .findByfindByRaduno_Last(id_esf_raduno, orderByComparator);
	}

	/**
	* Returns the last esf raduno shooters in the ordered set where id_esf_raduno = &#63;.
	*
	* @param id_esf_raduno the id_esf_raduno
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching esf raduno shooters, or <code>null</code> if a matching esf raduno shooters could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.EsfRadunoShooters fetchByfindByRaduno_Last(
		long id_esf_raduno,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByfindByRaduno_Last(id_esf_raduno, orderByComparator);
	}

	/**
	* Returns the esf raduno shooterses before and after the current esf raduno shooters in the ordered set where id_esf_raduno = &#63;.
	*
	* @param esfRadunoShootersPK the primary key of the current esf raduno shooters
	* @param id_esf_raduno the id_esf_raduno
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next esf raduno shooters
	* @throws it.ethica.esf.NoSuchEsfRadunoShootersException if a esf raduno shooters with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.EsfRadunoShooters[] findByfindByRaduno_PrevAndNext(
		it.ethica.esf.service.persistence.EsfRadunoShootersPK esfRadunoShootersPK,
		long id_esf_raduno,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchEsfRadunoShootersException {
		return getPersistence()
				   .findByfindByRaduno_PrevAndNext(esfRadunoShootersPK,
			id_esf_raduno, orderByComparator);
	}

	/**
	* Removes all the esf raduno shooterses where id_esf_raduno = &#63; from the database.
	*
	* @param id_esf_raduno the id_esf_raduno
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByfindByRaduno(long id_esf_raduno)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByfindByRaduno(id_esf_raduno);
	}

	/**
	* Returns the number of esf raduno shooterses where id_esf_raduno = &#63;.
	*
	* @param id_esf_raduno the id_esf_raduno
	* @return the number of matching esf raduno shooterses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByfindByRaduno(long id_esf_raduno)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByfindByRaduno(id_esf_raduno);
	}

	/**
	* Caches the esf raduno shooters in the entity cache if it is enabled.
	*
	* @param esfRadunoShooters the esf raduno shooters
	*/
	public static void cacheResult(
		it.ethica.esf.model.EsfRadunoShooters esfRadunoShooters) {
		getPersistence().cacheResult(esfRadunoShooters);
	}

	/**
	* Caches the esf raduno shooterses in the entity cache if it is enabled.
	*
	* @param esfRadunoShooterses the esf raduno shooterses
	*/
	public static void cacheResult(
		java.util.List<it.ethica.esf.model.EsfRadunoShooters> esfRadunoShooterses) {
		getPersistence().cacheResult(esfRadunoShooterses);
	}

	/**
	* Creates a new esf raduno shooters with the primary key. Does not add the esf raduno shooters to the database.
	*
	* @param esfRadunoShootersPK the primary key for the new esf raduno shooters
	* @return the new esf raduno shooters
	*/
	public static it.ethica.esf.model.EsfRadunoShooters create(
		it.ethica.esf.service.persistence.EsfRadunoShootersPK esfRadunoShootersPK) {
		return getPersistence().create(esfRadunoShootersPK);
	}

	/**
	* Removes the esf raduno shooters with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfRadunoShootersPK the primary key of the esf raduno shooters
	* @return the esf raduno shooters that was removed
	* @throws it.ethica.esf.NoSuchEsfRadunoShootersException if a esf raduno shooters with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.EsfRadunoShooters remove(
		it.ethica.esf.service.persistence.EsfRadunoShootersPK esfRadunoShootersPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchEsfRadunoShootersException {
		return getPersistence().remove(esfRadunoShootersPK);
	}

	public static it.ethica.esf.model.EsfRadunoShooters updateImpl(
		it.ethica.esf.model.EsfRadunoShooters esfRadunoShooters)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(esfRadunoShooters);
	}

	/**
	* Returns the esf raduno shooters with the primary key or throws a {@link it.ethica.esf.NoSuchEsfRadunoShootersException} if it could not be found.
	*
	* @param esfRadunoShootersPK the primary key of the esf raduno shooters
	* @return the esf raduno shooters
	* @throws it.ethica.esf.NoSuchEsfRadunoShootersException if a esf raduno shooters with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.EsfRadunoShooters findByPrimaryKey(
		it.ethica.esf.service.persistence.EsfRadunoShootersPK esfRadunoShootersPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchEsfRadunoShootersException {
		return getPersistence().findByPrimaryKey(esfRadunoShootersPK);
	}

	/**
	* Returns the esf raduno shooters with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param esfRadunoShootersPK the primary key of the esf raduno shooters
	* @return the esf raduno shooters, or <code>null</code> if a esf raduno shooters with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.EsfRadunoShooters fetchByPrimaryKey(
		it.ethica.esf.service.persistence.EsfRadunoShootersPK esfRadunoShootersPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(esfRadunoShootersPK);
	}

	/**
	* Returns all the esf raduno shooterses.
	*
	* @return the esf raduno shooterses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.EsfRadunoShooters> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the esf raduno shooterses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.EsfRadunoShootersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of esf raduno shooterses
	* @param end the upper bound of the range of esf raduno shooterses (not inclusive)
	* @return the range of esf raduno shooterses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.EsfRadunoShooters> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the esf raduno shooterses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.EsfRadunoShootersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of esf raduno shooterses
	* @param end the upper bound of the range of esf raduno shooterses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of esf raduno shooterses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.EsfRadunoShooters> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the esf raduno shooterses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of esf raduno shooterses.
	*
	* @return the number of esf raduno shooterses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static EsfRadunoShootersPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (EsfRadunoShootersPersistence)PortletBeanLocatorUtil.locate(it.ethica.esf.service.ClpSerializer.getServletContextName(),
					EsfRadunoShootersPersistence.class.getName());

			ReferenceRegistry.registerReference(EsfRadunoShootersUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(EsfRadunoShootersPersistence persistence) {
	}

	private static EsfRadunoShootersPersistence _persistence;
}