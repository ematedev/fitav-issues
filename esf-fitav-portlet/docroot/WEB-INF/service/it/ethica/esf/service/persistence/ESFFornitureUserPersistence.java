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

import it.ethica.esf.model.ESFFornitureUser;

/**
 * The persistence interface for the e s f forniture user service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFFornitureUserPersistenceImpl
 * @see ESFFornitureUserUtil
 * @generated
 */
public interface ESFFornitureUserPersistence extends BasePersistence<ESFFornitureUser> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ESFFornitureUserUtil} to access the e s f forniture user persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the e s f forniture user in the entity cache if it is enabled.
	*
	* @param esfFornitureUser the e s f forniture user
	*/
	public void cacheResult(
		it.ethica.esf.model.ESFFornitureUser esfFornitureUser);

	/**
	* Caches the e s f forniture users in the entity cache if it is enabled.
	*
	* @param esfFornitureUsers the e s f forniture users
	*/
	public void cacheResult(
		java.util.List<it.ethica.esf.model.ESFFornitureUser> esfFornitureUsers);

	/**
	* Creates a new e s f forniture user with the primary key. Does not add the e s f forniture user to the database.
	*
	* @param esfFornitureUserID the primary key for the new e s f forniture user
	* @return the new e s f forniture user
	*/
	public it.ethica.esf.model.ESFFornitureUser create(long esfFornitureUserID);

	/**
	* Removes the e s f forniture user with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfFornitureUserID the primary key of the e s f forniture user
	* @return the e s f forniture user that was removed
	* @throws it.ethica.esf.NoSuchFornitureUserException if a e s f forniture user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFFornitureUser remove(long esfFornitureUserID)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFornitureUserException;

	public it.ethica.esf.model.ESFFornitureUser updateImpl(
		it.ethica.esf.model.ESFFornitureUser esfFornitureUser)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f forniture user with the primary key or throws a {@link it.ethica.esf.NoSuchFornitureUserException} if it could not be found.
	*
	* @param esfFornitureUserID the primary key of the e s f forniture user
	* @return the e s f forniture user
	* @throws it.ethica.esf.NoSuchFornitureUserException if a e s f forniture user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFFornitureUser findByPrimaryKey(
		long esfFornitureUserID)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFornitureUserException;

	/**
	* Returns the e s f forniture user with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param esfFornitureUserID the primary key of the e s f forniture user
	* @return the e s f forniture user, or <code>null</code> if a e s f forniture user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFFornitureUser fetchByPrimaryKey(
		long esfFornitureUserID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f forniture users.
	*
	* @return the e s f forniture users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFFornitureUser> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f forniture users.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFornitureUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f forniture users
	* @param end the upper bound of the range of e s f forniture users (not inclusive)
	* @return the range of e s f forniture users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFFornitureUser> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f forniture users.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFornitureUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f forniture users
	* @param end the upper bound of the range of e s f forniture users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of e s f forniture users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFFornitureUser> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the e s f forniture users from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f forniture users.
	*
	* @return the number of e s f forniture users
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}