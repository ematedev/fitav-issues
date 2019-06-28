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

import it.ethica.esf.model.ESFRadunoSottotipiRaduno;

/**
 * The persistence interface for the e s f raduno sottotipi raduno service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFRadunoSottotipiRadunoPersistenceImpl
 * @see ESFRadunoSottotipiRadunoUtil
 * @generated
 */
public interface ESFRadunoSottotipiRadunoPersistence extends BasePersistence<ESFRadunoSottotipiRaduno> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ESFRadunoSottotipiRadunoUtil} to access the e s f raduno sottotipi raduno persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the e s f raduno sottotipi radunos where id_esf_raduno = &#63;.
	*
	* @param id_esf_raduno the id_esf_raduno
	* @return the matching e s f raduno sottotipi radunos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFRadunoSottotipiRaduno> findByfindByIdEsfRaduno(
		long id_esf_raduno)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f raduno sottotipi radunos where id_esf_raduno = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFRadunoSottotipiRadunoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id_esf_raduno the id_esf_raduno
	* @param start the lower bound of the range of e s f raduno sottotipi radunos
	* @param end the upper bound of the range of e s f raduno sottotipi radunos (not inclusive)
	* @return the range of matching e s f raduno sottotipi radunos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFRadunoSottotipiRaduno> findByfindByIdEsfRaduno(
		long id_esf_raduno, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f raduno sottotipi radunos where id_esf_raduno = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFRadunoSottotipiRadunoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id_esf_raduno the id_esf_raduno
	* @param start the lower bound of the range of e s f raduno sottotipi radunos
	* @param end the upper bound of the range of e s f raduno sottotipi radunos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f raduno sottotipi radunos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFRadunoSottotipiRaduno> findByfindByIdEsfRaduno(
		long id_esf_raduno, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f raduno sottotipi raduno in the ordered set where id_esf_raduno = &#63;.
	*
	* @param id_esf_raduno the id_esf_raduno
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f raduno sottotipi raduno
	* @throws it.ethica.esf.NoSuchRadunoSottotipiRadunoException if a matching e s f raduno sottotipi raduno could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFRadunoSottotipiRaduno findByfindByIdEsfRaduno_First(
		long id_esf_raduno,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchRadunoSottotipiRadunoException;

	/**
	* Returns the first e s f raduno sottotipi raduno in the ordered set where id_esf_raduno = &#63;.
	*
	* @param id_esf_raduno the id_esf_raduno
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f raduno sottotipi raduno, or <code>null</code> if a matching e s f raduno sottotipi raduno could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFRadunoSottotipiRaduno fetchByfindByIdEsfRaduno_First(
		long id_esf_raduno,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f raduno sottotipi raduno in the ordered set where id_esf_raduno = &#63;.
	*
	* @param id_esf_raduno the id_esf_raduno
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f raduno sottotipi raduno
	* @throws it.ethica.esf.NoSuchRadunoSottotipiRadunoException if a matching e s f raduno sottotipi raduno could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFRadunoSottotipiRaduno findByfindByIdEsfRaduno_Last(
		long id_esf_raduno,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchRadunoSottotipiRadunoException;

	/**
	* Returns the last e s f raduno sottotipi raduno in the ordered set where id_esf_raduno = &#63;.
	*
	* @param id_esf_raduno the id_esf_raduno
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f raduno sottotipi raduno, or <code>null</code> if a matching e s f raduno sottotipi raduno could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFRadunoSottotipiRaduno fetchByfindByIdEsfRaduno_Last(
		long id_esf_raduno,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f raduno sottotipi radunos before and after the current e s f raduno sottotipi raduno in the ordered set where id_esf_raduno = &#63;.
	*
	* @param id_esf_raduno_sottotipi_raduno the primary key of the current e s f raduno sottotipi raduno
	* @param id_esf_raduno the id_esf_raduno
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f raduno sottotipi raduno
	* @throws it.ethica.esf.NoSuchRadunoSottotipiRadunoException if a e s f raduno sottotipi raduno with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFRadunoSottotipiRaduno[] findByfindByIdEsfRaduno_PrevAndNext(
		long id_esf_raduno_sottotipi_raduno, long id_esf_raduno,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchRadunoSottotipiRadunoException;

	/**
	* Removes all the e s f raduno sottotipi radunos where id_esf_raduno = &#63; from the database.
	*
	* @param id_esf_raduno the id_esf_raduno
	* @throws SystemException if a system exception occurred
	*/
	public void removeByfindByIdEsfRaduno(long id_esf_raduno)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f raduno sottotipi radunos where id_esf_raduno = &#63;.
	*
	* @param id_esf_raduno the id_esf_raduno
	* @return the number of matching e s f raduno sottotipi radunos
	* @throws SystemException if a system exception occurred
	*/
	public int countByfindByIdEsfRaduno(long id_esf_raduno)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the e s f raduno sottotipi raduno in the entity cache if it is enabled.
	*
	* @param esfRadunoSottotipiRaduno the e s f raduno sottotipi raduno
	*/
	public void cacheResult(
		it.ethica.esf.model.ESFRadunoSottotipiRaduno esfRadunoSottotipiRaduno);

	/**
	* Caches the e s f raduno sottotipi radunos in the entity cache if it is enabled.
	*
	* @param esfRadunoSottotipiRadunos the e s f raduno sottotipi radunos
	*/
	public void cacheResult(
		java.util.List<it.ethica.esf.model.ESFRadunoSottotipiRaduno> esfRadunoSottotipiRadunos);

	/**
	* Creates a new e s f raduno sottotipi raduno with the primary key. Does not add the e s f raduno sottotipi raduno to the database.
	*
	* @param id_esf_raduno_sottotipi_raduno the primary key for the new e s f raduno sottotipi raduno
	* @return the new e s f raduno sottotipi raduno
	*/
	public it.ethica.esf.model.ESFRadunoSottotipiRaduno create(
		long id_esf_raduno_sottotipi_raduno);

	/**
	* Removes the e s f raduno sottotipi raduno with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_esf_raduno_sottotipi_raduno the primary key of the e s f raduno sottotipi raduno
	* @return the e s f raduno sottotipi raduno that was removed
	* @throws it.ethica.esf.NoSuchRadunoSottotipiRadunoException if a e s f raduno sottotipi raduno with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFRadunoSottotipiRaduno remove(
		long id_esf_raduno_sottotipi_raduno)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchRadunoSottotipiRadunoException;

	public it.ethica.esf.model.ESFRadunoSottotipiRaduno updateImpl(
		it.ethica.esf.model.ESFRadunoSottotipiRaduno esfRadunoSottotipiRaduno)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f raduno sottotipi raduno with the primary key or throws a {@link it.ethica.esf.NoSuchRadunoSottotipiRadunoException} if it could not be found.
	*
	* @param id_esf_raduno_sottotipi_raduno the primary key of the e s f raduno sottotipi raduno
	* @return the e s f raduno sottotipi raduno
	* @throws it.ethica.esf.NoSuchRadunoSottotipiRadunoException if a e s f raduno sottotipi raduno with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFRadunoSottotipiRaduno findByPrimaryKey(
		long id_esf_raduno_sottotipi_raduno)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchRadunoSottotipiRadunoException;

	/**
	* Returns the e s f raduno sottotipi raduno with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id_esf_raduno_sottotipi_raduno the primary key of the e s f raduno sottotipi raduno
	* @return the e s f raduno sottotipi raduno, or <code>null</code> if a e s f raduno sottotipi raduno with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFRadunoSottotipiRaduno fetchByPrimaryKey(
		long id_esf_raduno_sottotipi_raduno)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f raduno sottotipi radunos.
	*
	* @return the e s f raduno sottotipi radunos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFRadunoSottotipiRaduno> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f raduno sottotipi radunos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFRadunoSottotipiRadunoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f raduno sottotipi radunos
	* @param end the upper bound of the range of e s f raduno sottotipi radunos (not inclusive)
	* @return the range of e s f raduno sottotipi radunos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFRadunoSottotipiRaduno> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f raduno sottotipi radunos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFRadunoSottotipiRadunoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f raduno sottotipi radunos
	* @param end the upper bound of the range of e s f raduno sottotipi radunos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of e s f raduno sottotipi radunos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFRadunoSottotipiRaduno> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the e s f raduno sottotipi radunos from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f raduno sottotipi radunos.
	*
	* @return the number of e s f raduno sottotipi radunos
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}