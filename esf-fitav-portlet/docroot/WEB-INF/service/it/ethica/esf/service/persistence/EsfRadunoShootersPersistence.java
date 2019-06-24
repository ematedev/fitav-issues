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

import it.ethica.esf.model.EsfRadunoShooters;

/**
 * The persistence interface for the esf raduno shooters service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see EsfRadunoShootersPersistenceImpl
 * @see EsfRadunoShootersUtil
 * @generated
 */
public interface EsfRadunoShootersPersistence extends BasePersistence<EsfRadunoShooters> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EsfRadunoShootersUtil} to access the esf raduno shooters persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the esf raduno shooters where id_esf_raduno = &#63; and userId = &#63; or throws a {@link it.ethica.esf.NoSuchEsfRadunoShootersException} if it could not be found.
	*
	* @param id_esf_raduno the id_esf_raduno
	* @param userId the user ID
	* @return the matching esf raduno shooters
	* @throws it.ethica.esf.NoSuchEsfRadunoShootersException if a matching esf raduno shooters could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.EsfRadunoShooters findByfindRadunoShooters(
		long id_esf_raduno, long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchEsfRadunoShootersException;

	/**
	* Returns the esf raduno shooters where id_esf_raduno = &#63; and userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param id_esf_raduno the id_esf_raduno
	* @param userId the user ID
	* @return the matching esf raduno shooters, or <code>null</code> if a matching esf raduno shooters could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.EsfRadunoShooters fetchByfindRadunoShooters(
		long id_esf_raduno, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the esf raduno shooters where id_esf_raduno = &#63; and userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param id_esf_raduno the id_esf_raduno
	* @param userId the user ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching esf raduno shooters, or <code>null</code> if a matching esf raduno shooters could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.EsfRadunoShooters fetchByfindRadunoShooters(
		long id_esf_raduno, long userId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the esf raduno shooters where id_esf_raduno = &#63; and userId = &#63; from the database.
	*
	* @param id_esf_raduno the id_esf_raduno
	* @param userId the user ID
	* @return the esf raduno shooters that was removed
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.EsfRadunoShooters removeByfindRadunoShooters(
		long id_esf_raduno, long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchEsfRadunoShootersException;

	/**
	* Returns the number of esf raduno shooterses where id_esf_raduno = &#63; and userId = &#63;.
	*
	* @param id_esf_raduno the id_esf_raduno
	* @param userId the user ID
	* @return the number of matching esf raduno shooterses
	* @throws SystemException if a system exception occurred
	*/
	public int countByfindRadunoShooters(long id_esf_raduno, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the esf raduno shooterses where id_esf_raduno = &#63;.
	*
	* @param id_esf_raduno the id_esf_raduno
	* @return the matching esf raduno shooterses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.EsfRadunoShooters> findByfindByRaduno(
		long id_esf_raduno)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.ethica.esf.model.EsfRadunoShooters> findByfindByRaduno(
		long id_esf_raduno, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.ethica.esf.model.EsfRadunoShooters> findByfindByRaduno(
		long id_esf_raduno, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first esf raduno shooters in the ordered set where id_esf_raduno = &#63;.
	*
	* @param id_esf_raduno the id_esf_raduno
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching esf raduno shooters
	* @throws it.ethica.esf.NoSuchEsfRadunoShootersException if a matching esf raduno shooters could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.EsfRadunoShooters findByfindByRaduno_First(
		long id_esf_raduno,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchEsfRadunoShootersException;

	/**
	* Returns the first esf raduno shooters in the ordered set where id_esf_raduno = &#63;.
	*
	* @param id_esf_raduno the id_esf_raduno
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching esf raduno shooters, or <code>null</code> if a matching esf raduno shooters could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.EsfRadunoShooters fetchByfindByRaduno_First(
		long id_esf_raduno,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last esf raduno shooters in the ordered set where id_esf_raduno = &#63;.
	*
	* @param id_esf_raduno the id_esf_raduno
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching esf raduno shooters
	* @throws it.ethica.esf.NoSuchEsfRadunoShootersException if a matching esf raduno shooters could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.EsfRadunoShooters findByfindByRaduno_Last(
		long id_esf_raduno,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchEsfRadunoShootersException;

	/**
	* Returns the last esf raduno shooters in the ordered set where id_esf_raduno = &#63;.
	*
	* @param id_esf_raduno the id_esf_raduno
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching esf raduno shooters, or <code>null</code> if a matching esf raduno shooters could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.EsfRadunoShooters fetchByfindByRaduno_Last(
		long id_esf_raduno,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public it.ethica.esf.model.EsfRadunoShooters[] findByfindByRaduno_PrevAndNext(
		it.ethica.esf.service.persistence.EsfRadunoShootersPK esfRadunoShootersPK,
		long id_esf_raduno,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchEsfRadunoShootersException;

	/**
	* Removes all the esf raduno shooterses where id_esf_raduno = &#63; from the database.
	*
	* @param id_esf_raduno the id_esf_raduno
	* @throws SystemException if a system exception occurred
	*/
	public void removeByfindByRaduno(long id_esf_raduno)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of esf raduno shooterses where id_esf_raduno = &#63;.
	*
	* @param id_esf_raduno the id_esf_raduno
	* @return the number of matching esf raduno shooterses
	* @throws SystemException if a system exception occurred
	*/
	public int countByfindByRaduno(long id_esf_raduno)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the esf raduno shooters in the entity cache if it is enabled.
	*
	* @param esfRadunoShooters the esf raduno shooters
	*/
	public void cacheResult(
		it.ethica.esf.model.EsfRadunoShooters esfRadunoShooters);

	/**
	* Caches the esf raduno shooterses in the entity cache if it is enabled.
	*
	* @param esfRadunoShooterses the esf raduno shooterses
	*/
	public void cacheResult(
		java.util.List<it.ethica.esf.model.EsfRadunoShooters> esfRadunoShooterses);

	/**
	* Creates a new esf raduno shooters with the primary key. Does not add the esf raduno shooters to the database.
	*
	* @param esfRadunoShootersPK the primary key for the new esf raduno shooters
	* @return the new esf raduno shooters
	*/
	public it.ethica.esf.model.EsfRadunoShooters create(
		it.ethica.esf.service.persistence.EsfRadunoShootersPK esfRadunoShootersPK);

	/**
	* Removes the esf raduno shooters with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfRadunoShootersPK the primary key of the esf raduno shooters
	* @return the esf raduno shooters that was removed
	* @throws it.ethica.esf.NoSuchEsfRadunoShootersException if a esf raduno shooters with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.EsfRadunoShooters remove(
		it.ethica.esf.service.persistence.EsfRadunoShootersPK esfRadunoShootersPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchEsfRadunoShootersException;

	public it.ethica.esf.model.EsfRadunoShooters updateImpl(
		it.ethica.esf.model.EsfRadunoShooters esfRadunoShooters)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the esf raduno shooters with the primary key or throws a {@link it.ethica.esf.NoSuchEsfRadunoShootersException} if it could not be found.
	*
	* @param esfRadunoShootersPK the primary key of the esf raduno shooters
	* @return the esf raduno shooters
	* @throws it.ethica.esf.NoSuchEsfRadunoShootersException if a esf raduno shooters with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.EsfRadunoShooters findByPrimaryKey(
		it.ethica.esf.service.persistence.EsfRadunoShootersPK esfRadunoShootersPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchEsfRadunoShootersException;

	/**
	* Returns the esf raduno shooters with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param esfRadunoShootersPK the primary key of the esf raduno shooters
	* @return the esf raduno shooters, or <code>null</code> if a esf raduno shooters with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.EsfRadunoShooters fetchByPrimaryKey(
		it.ethica.esf.service.persistence.EsfRadunoShootersPK esfRadunoShootersPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the esf raduno shooterses.
	*
	* @return the esf raduno shooterses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.EsfRadunoShooters> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.ethica.esf.model.EsfRadunoShooters> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.ethica.esf.model.EsfRadunoShooters> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the esf raduno shooterses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of esf raduno shooterses.
	*
	* @return the number of esf raduno shooterses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}