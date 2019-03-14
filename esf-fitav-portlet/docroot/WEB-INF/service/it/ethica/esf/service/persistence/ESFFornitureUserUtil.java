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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import it.ethica.esf.model.ESFFornitureUser;

import java.util.List;

/**
 * The persistence utility for the e s f forniture user service. This utility wraps {@link ESFFornitureUserPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFFornitureUserPersistence
 * @see ESFFornitureUserPersistenceImpl
 * @generated
 */
public class ESFFornitureUserUtil {
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
	public static void clearCache(ESFFornitureUser esfFornitureUser) {
		getPersistence().clearCache(esfFornitureUser);
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
	public static List<ESFFornitureUser> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ESFFornitureUser> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ESFFornitureUser> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ESFFornitureUser update(ESFFornitureUser esfFornitureUser)
		throws SystemException {
		return getPersistence().update(esfFornitureUser);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ESFFornitureUser update(ESFFornitureUser esfFornitureUser,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(esfFornitureUser, serviceContext);
	}

	/**
	* Caches the e s f forniture user in the entity cache if it is enabled.
	*
	* @param esfFornitureUser the e s f forniture user
	*/
	public static void cacheResult(
		it.ethica.esf.model.ESFFornitureUser esfFornitureUser) {
		getPersistence().cacheResult(esfFornitureUser);
	}

	/**
	* Caches the e s f forniture users in the entity cache if it is enabled.
	*
	* @param esfFornitureUsers the e s f forniture users
	*/
	public static void cacheResult(
		java.util.List<it.ethica.esf.model.ESFFornitureUser> esfFornitureUsers) {
		getPersistence().cacheResult(esfFornitureUsers);
	}

	/**
	* Creates a new e s f forniture user with the primary key. Does not add the e s f forniture user to the database.
	*
	* @param esfFornitureUserID the primary key for the new e s f forniture user
	* @return the new e s f forniture user
	*/
	public static it.ethica.esf.model.ESFFornitureUser create(
		long esfFornitureUserID) {
		return getPersistence().create(esfFornitureUserID);
	}

	/**
	* Removes the e s f forniture user with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfFornitureUserID the primary key of the e s f forniture user
	* @return the e s f forniture user that was removed
	* @throws it.ethica.esf.NoSuchFornitureUserException if a e s f forniture user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFFornitureUser remove(
		long esfFornitureUserID)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFornitureUserException {
		return getPersistence().remove(esfFornitureUserID);
	}

	public static it.ethica.esf.model.ESFFornitureUser updateImpl(
		it.ethica.esf.model.ESFFornitureUser esfFornitureUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(esfFornitureUser);
	}

	/**
	* Returns the e s f forniture user with the primary key or throws a {@link it.ethica.esf.NoSuchFornitureUserException} if it could not be found.
	*
	* @param esfFornitureUserID the primary key of the e s f forniture user
	* @return the e s f forniture user
	* @throws it.ethica.esf.NoSuchFornitureUserException if a e s f forniture user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFFornitureUser findByPrimaryKey(
		long esfFornitureUserID)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFornitureUserException {
		return getPersistence().findByPrimaryKey(esfFornitureUserID);
	}

	/**
	* Returns the e s f forniture user with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param esfFornitureUserID the primary key of the e s f forniture user
	* @return the e s f forniture user, or <code>null</code> if a e s f forniture user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFFornitureUser fetchByPrimaryKey(
		long esfFornitureUserID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(esfFornitureUserID);
	}

	/**
	* Returns all the e s f forniture users.
	*
	* @return the e s f forniture users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFFornitureUser> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<it.ethica.esf.model.ESFFornitureUser> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<it.ethica.esf.model.ESFFornitureUser> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the e s f forniture users from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of e s f forniture users.
	*
	* @return the number of e s f forniture users
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ESFFornitureUserPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ESFFornitureUserPersistence)PortletBeanLocatorUtil.locate(it.ethica.esf.service.ClpSerializer.getServletContextName(),
					ESFFornitureUserPersistence.class.getName());

			ReferenceRegistry.registerReference(ESFFornitureUserUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ESFFornitureUserPersistence persistence) {
	}

	private static ESFFornitureUserPersistence _persistence;
}