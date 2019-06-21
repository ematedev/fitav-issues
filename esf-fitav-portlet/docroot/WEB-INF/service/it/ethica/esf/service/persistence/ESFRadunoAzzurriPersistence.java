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

import it.ethica.esf.model.ESFRadunoAzzurri;

/**
 * The persistence interface for the e s f raduno azzurri service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFRadunoAzzurriPersistenceImpl
 * @see ESFRadunoAzzurriUtil
 * @generated
 */
public interface ESFRadunoAzzurriPersistence extends BasePersistence<ESFRadunoAzzurri> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ESFRadunoAzzurriUtil} to access the e s f raduno azzurri persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the e s f raduno azzurri where id_esf_raduno = &#63; and esfNationalId = &#63; or throws a {@link it.ethica.esf.NoSuchRadunoAzzurriException} if it could not be found.
	*
	* @param id_esf_raduno the id_esf_raduno
	* @param esfNationalId the esf national ID
	* @return the matching e s f raduno azzurri
	* @throws it.ethica.esf.NoSuchRadunoAzzurriException if a matching e s f raduno azzurri could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFRadunoAzzurri findByfindRadunoAzzurri(
		long id_esf_raduno, long esfNationalId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchRadunoAzzurriException;

	/**
	* Returns the e s f raduno azzurri where id_esf_raduno = &#63; and esfNationalId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param id_esf_raduno the id_esf_raduno
	* @param esfNationalId the esf national ID
	* @return the matching e s f raduno azzurri, or <code>null</code> if a matching e s f raduno azzurri could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFRadunoAzzurri fetchByfindRadunoAzzurri(
		long id_esf_raduno, long esfNationalId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f raduno azzurri where id_esf_raduno = &#63; and esfNationalId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param id_esf_raduno the id_esf_raduno
	* @param esfNationalId the esf national ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching e s f raduno azzurri, or <code>null</code> if a matching e s f raduno azzurri could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFRadunoAzzurri fetchByfindRadunoAzzurri(
		long id_esf_raduno, long esfNationalId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the e s f raduno azzurri where id_esf_raduno = &#63; and esfNationalId = &#63; from the database.
	*
	* @param id_esf_raduno the id_esf_raduno
	* @param esfNationalId the esf national ID
	* @return the e s f raduno azzurri that was removed
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFRadunoAzzurri removeByfindRadunoAzzurri(
		long id_esf_raduno, long esfNationalId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchRadunoAzzurriException;

	/**
	* Returns the number of e s f raduno azzurris where id_esf_raduno = &#63; and esfNationalId = &#63;.
	*
	* @param id_esf_raduno the id_esf_raduno
	* @param esfNationalId the esf national ID
	* @return the number of matching e s f raduno azzurris
	* @throws SystemException if a system exception occurred
	*/
	public int countByfindRadunoAzzurri(long id_esf_raduno, long esfNationalId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f raduno azzurris where id_esf_raduno = &#63;.
	*
	* @param id_esf_raduno the id_esf_raduno
	* @return the matching e s f raduno azzurris
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFRadunoAzzurri> findByfindByIdRaduno(
		long id_esf_raduno)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f raduno azzurris where id_esf_raduno = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFRadunoAzzurriModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id_esf_raduno the id_esf_raduno
	* @param start the lower bound of the range of e s f raduno azzurris
	* @param end the upper bound of the range of e s f raduno azzurris (not inclusive)
	* @return the range of matching e s f raduno azzurris
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFRadunoAzzurri> findByfindByIdRaduno(
		long id_esf_raduno, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f raduno azzurris where id_esf_raduno = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFRadunoAzzurriModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id_esf_raduno the id_esf_raduno
	* @param start the lower bound of the range of e s f raduno azzurris
	* @param end the upper bound of the range of e s f raduno azzurris (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f raduno azzurris
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFRadunoAzzurri> findByfindByIdRaduno(
		long id_esf_raduno, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f raduno azzurri in the ordered set where id_esf_raduno = &#63;.
	*
	* @param id_esf_raduno the id_esf_raduno
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f raduno azzurri
	* @throws it.ethica.esf.NoSuchRadunoAzzurriException if a matching e s f raduno azzurri could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFRadunoAzzurri findByfindByIdRaduno_First(
		long id_esf_raduno,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchRadunoAzzurriException;

	/**
	* Returns the first e s f raduno azzurri in the ordered set where id_esf_raduno = &#63;.
	*
	* @param id_esf_raduno the id_esf_raduno
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f raduno azzurri, or <code>null</code> if a matching e s f raduno azzurri could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFRadunoAzzurri fetchByfindByIdRaduno_First(
		long id_esf_raduno,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f raduno azzurri in the ordered set where id_esf_raduno = &#63;.
	*
	* @param id_esf_raduno the id_esf_raduno
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f raduno azzurri
	* @throws it.ethica.esf.NoSuchRadunoAzzurriException if a matching e s f raduno azzurri could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFRadunoAzzurri findByfindByIdRaduno_Last(
		long id_esf_raduno,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchRadunoAzzurriException;

	/**
	* Returns the last e s f raduno azzurri in the ordered set where id_esf_raduno = &#63;.
	*
	* @param id_esf_raduno the id_esf_raduno
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f raduno azzurri, or <code>null</code> if a matching e s f raduno azzurri could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFRadunoAzzurri fetchByfindByIdRaduno_Last(
		long id_esf_raduno,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f raduno azzurris before and after the current e s f raduno azzurri in the ordered set where id_esf_raduno = &#63;.
	*
	* @param esfRadunoAzzurriPK the primary key of the current e s f raduno azzurri
	* @param id_esf_raduno the id_esf_raduno
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f raduno azzurri
	* @throws it.ethica.esf.NoSuchRadunoAzzurriException if a e s f raduno azzurri with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFRadunoAzzurri[] findByfindByIdRaduno_PrevAndNext(
		it.ethica.esf.service.persistence.ESFRadunoAzzurriPK esfRadunoAzzurriPK,
		long id_esf_raduno,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchRadunoAzzurriException;

	/**
	* Removes all the e s f raduno azzurris where id_esf_raduno = &#63; from the database.
	*
	* @param id_esf_raduno the id_esf_raduno
	* @throws SystemException if a system exception occurred
	*/
	public void removeByfindByIdRaduno(long id_esf_raduno)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f raduno azzurris where id_esf_raduno = &#63;.
	*
	* @param id_esf_raduno the id_esf_raduno
	* @return the number of matching e s f raduno azzurris
	* @throws SystemException if a system exception occurred
	*/
	public int countByfindByIdRaduno(long id_esf_raduno)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the e s f raduno azzurri in the entity cache if it is enabled.
	*
	* @param esfRadunoAzzurri the e s f raduno azzurri
	*/
	public void cacheResult(
		it.ethica.esf.model.ESFRadunoAzzurri esfRadunoAzzurri);

	/**
	* Caches the e s f raduno azzurris in the entity cache if it is enabled.
	*
	* @param esfRadunoAzzurris the e s f raduno azzurris
	*/
	public void cacheResult(
		java.util.List<it.ethica.esf.model.ESFRadunoAzzurri> esfRadunoAzzurris);

	/**
	* Creates a new e s f raduno azzurri with the primary key. Does not add the e s f raduno azzurri to the database.
	*
	* @param esfRadunoAzzurriPK the primary key for the new e s f raduno azzurri
	* @return the new e s f raduno azzurri
	*/
	public it.ethica.esf.model.ESFRadunoAzzurri create(
		it.ethica.esf.service.persistence.ESFRadunoAzzurriPK esfRadunoAzzurriPK);

	/**
	* Removes the e s f raduno azzurri with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfRadunoAzzurriPK the primary key of the e s f raduno azzurri
	* @return the e s f raduno azzurri that was removed
	* @throws it.ethica.esf.NoSuchRadunoAzzurriException if a e s f raduno azzurri with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFRadunoAzzurri remove(
		it.ethica.esf.service.persistence.ESFRadunoAzzurriPK esfRadunoAzzurriPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchRadunoAzzurriException;

	public it.ethica.esf.model.ESFRadunoAzzurri updateImpl(
		it.ethica.esf.model.ESFRadunoAzzurri esfRadunoAzzurri)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f raduno azzurri with the primary key or throws a {@link it.ethica.esf.NoSuchRadunoAzzurriException} if it could not be found.
	*
	* @param esfRadunoAzzurriPK the primary key of the e s f raduno azzurri
	* @return the e s f raduno azzurri
	* @throws it.ethica.esf.NoSuchRadunoAzzurriException if a e s f raduno azzurri with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFRadunoAzzurri findByPrimaryKey(
		it.ethica.esf.service.persistence.ESFRadunoAzzurriPK esfRadunoAzzurriPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchRadunoAzzurriException;

	/**
	* Returns the e s f raduno azzurri with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param esfRadunoAzzurriPK the primary key of the e s f raduno azzurri
	* @return the e s f raduno azzurri, or <code>null</code> if a e s f raduno azzurri with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFRadunoAzzurri fetchByPrimaryKey(
		it.ethica.esf.service.persistence.ESFRadunoAzzurriPK esfRadunoAzzurriPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f raduno azzurris.
	*
	* @return the e s f raduno azzurris
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFRadunoAzzurri> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f raduno azzurris.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFRadunoAzzurriModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f raduno azzurris
	* @param end the upper bound of the range of e s f raduno azzurris (not inclusive)
	* @return the range of e s f raduno azzurris
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFRadunoAzzurri> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f raduno azzurris.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFRadunoAzzurriModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f raduno azzurris
	* @param end the upper bound of the range of e s f raduno azzurris (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of e s f raduno azzurris
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFRadunoAzzurri> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the e s f raduno azzurris from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f raduno azzurris.
	*
	* @return the number of e s f raduno azzurris
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}