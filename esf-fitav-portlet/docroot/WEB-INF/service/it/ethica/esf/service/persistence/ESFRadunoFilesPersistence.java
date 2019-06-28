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

import it.ethica.esf.model.ESFRadunoFiles;

/**
 * The persistence interface for the e s f raduno files service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFRadunoFilesPersistenceImpl
 * @see ESFRadunoFilesUtil
 * @generated
 */
public interface ESFRadunoFilesPersistence extends BasePersistence<ESFRadunoFiles> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ESFRadunoFilesUtil} to access the e s f raduno files persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the e s f raduno fileses where id_esf_raduno = &#63;.
	*
	* @param id_esf_raduno the id_esf_raduno
	* @return the matching e s f raduno fileses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFRadunoFiles> findByfindByRaduno(
		long id_esf_raduno)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f raduno fileses where id_esf_raduno = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFRadunoFilesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id_esf_raduno the id_esf_raduno
	* @param start the lower bound of the range of e s f raduno fileses
	* @param end the upper bound of the range of e s f raduno fileses (not inclusive)
	* @return the range of matching e s f raduno fileses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFRadunoFiles> findByfindByRaduno(
		long id_esf_raduno, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f raduno fileses where id_esf_raduno = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFRadunoFilesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id_esf_raduno the id_esf_raduno
	* @param start the lower bound of the range of e s f raduno fileses
	* @param end the upper bound of the range of e s f raduno fileses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f raduno fileses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFRadunoFiles> findByfindByRaduno(
		long id_esf_raduno, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f raduno files in the ordered set where id_esf_raduno = &#63;.
	*
	* @param id_esf_raduno the id_esf_raduno
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f raduno files
	* @throws it.ethica.esf.NoSuchRadunoFilesException if a matching e s f raduno files could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFRadunoFiles findByfindByRaduno_First(
		long id_esf_raduno,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchRadunoFilesException;

	/**
	* Returns the first e s f raduno files in the ordered set where id_esf_raduno = &#63;.
	*
	* @param id_esf_raduno the id_esf_raduno
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f raduno files, or <code>null</code> if a matching e s f raduno files could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFRadunoFiles fetchByfindByRaduno_First(
		long id_esf_raduno,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f raduno files in the ordered set where id_esf_raduno = &#63;.
	*
	* @param id_esf_raduno the id_esf_raduno
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f raduno files
	* @throws it.ethica.esf.NoSuchRadunoFilesException if a matching e s f raduno files could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFRadunoFiles findByfindByRaduno_Last(
		long id_esf_raduno,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchRadunoFilesException;

	/**
	* Returns the last e s f raduno files in the ordered set where id_esf_raduno = &#63;.
	*
	* @param id_esf_raduno the id_esf_raduno
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f raduno files, or <code>null</code> if a matching e s f raduno files could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFRadunoFiles fetchByfindByRaduno_Last(
		long id_esf_raduno,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f raduno fileses before and after the current e s f raduno files in the ordered set where id_esf_raduno = &#63;.
	*
	* @param id_esf_raduno_files the primary key of the current e s f raduno files
	* @param id_esf_raduno the id_esf_raduno
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f raduno files
	* @throws it.ethica.esf.NoSuchRadunoFilesException if a e s f raduno files with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFRadunoFiles[] findByfindByRaduno_PrevAndNext(
		long id_esf_raduno_files, long id_esf_raduno,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchRadunoFilesException;

	/**
	* Removes all the e s f raduno fileses where id_esf_raduno = &#63; from the database.
	*
	* @param id_esf_raduno the id_esf_raduno
	* @throws SystemException if a system exception occurred
	*/
	public void removeByfindByRaduno(long id_esf_raduno)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f raduno fileses where id_esf_raduno = &#63;.
	*
	* @param id_esf_raduno the id_esf_raduno
	* @return the number of matching e s f raduno fileses
	* @throws SystemException if a system exception occurred
	*/
	public int countByfindByRaduno(long id_esf_raduno)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the e s f raduno files in the entity cache if it is enabled.
	*
	* @param esfRadunoFiles the e s f raduno files
	*/
	public void cacheResult(it.ethica.esf.model.ESFRadunoFiles esfRadunoFiles);

	/**
	* Caches the e s f raduno fileses in the entity cache if it is enabled.
	*
	* @param esfRadunoFileses the e s f raduno fileses
	*/
	public void cacheResult(
		java.util.List<it.ethica.esf.model.ESFRadunoFiles> esfRadunoFileses);

	/**
	* Creates a new e s f raduno files with the primary key. Does not add the e s f raduno files to the database.
	*
	* @param id_esf_raduno_files the primary key for the new e s f raduno files
	* @return the new e s f raduno files
	*/
	public it.ethica.esf.model.ESFRadunoFiles create(long id_esf_raduno_files);

	/**
	* Removes the e s f raduno files with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_esf_raduno_files the primary key of the e s f raduno files
	* @return the e s f raduno files that was removed
	* @throws it.ethica.esf.NoSuchRadunoFilesException if a e s f raduno files with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFRadunoFiles remove(long id_esf_raduno_files)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchRadunoFilesException;

	public it.ethica.esf.model.ESFRadunoFiles updateImpl(
		it.ethica.esf.model.ESFRadunoFiles esfRadunoFiles)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f raduno files with the primary key or throws a {@link it.ethica.esf.NoSuchRadunoFilesException} if it could not be found.
	*
	* @param id_esf_raduno_files the primary key of the e s f raduno files
	* @return the e s f raduno files
	* @throws it.ethica.esf.NoSuchRadunoFilesException if a e s f raduno files with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFRadunoFiles findByPrimaryKey(
		long id_esf_raduno_files)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchRadunoFilesException;

	/**
	* Returns the e s f raduno files with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id_esf_raduno_files the primary key of the e s f raduno files
	* @return the e s f raduno files, or <code>null</code> if a e s f raduno files with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFRadunoFiles fetchByPrimaryKey(
		long id_esf_raduno_files)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f raduno fileses.
	*
	* @return the e s f raduno fileses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFRadunoFiles> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f raduno fileses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFRadunoFilesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f raduno fileses
	* @param end the upper bound of the range of e s f raduno fileses (not inclusive)
	* @return the range of e s f raduno fileses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFRadunoFiles> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f raduno fileses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFRadunoFilesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f raduno fileses
	* @param end the upper bound of the range of e s f raduno fileses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of e s f raduno fileses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFRadunoFiles> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the e s f raduno fileses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f raduno fileses.
	*
	* @return the number of e s f raduno fileses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}