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

package com.ethica.esf.service.persistence;

import com.ethica.esf.model.ESFArticle_ESFUser;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the e s f article_ e s f user service. This utility wraps {@link ESFArticle_ESFUserPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFArticle_ESFUserPersistence
 * @see ESFArticle_ESFUserPersistenceImpl
 * @generated
 */
public class ESFArticle_ESFUserUtil {
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
	public static void clearCache(ESFArticle_ESFUser esfArticle_ESFUser) {
		getPersistence().clearCache(esfArticle_ESFUser);
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
	public static List<ESFArticle_ESFUser> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ESFArticle_ESFUser> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ESFArticle_ESFUser> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ESFArticle_ESFUser update(
		ESFArticle_ESFUser esfArticle_ESFUser) throws SystemException {
		return getPersistence().update(esfArticle_ESFUser);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ESFArticle_ESFUser update(
		ESFArticle_ESFUser esfArticle_ESFUser, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(esfArticle_ESFUser, serviceContext);
	}

	/**
	* Returns all the e s f article_ e s f users where esfArticleId = &#63;.
	*
	* @param esfArticleId the esf article ID
	* @return the matching e s f article_ e s f users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ethica.esf.model.ESFArticle_ESFUser> findByESFArticleId(
		long esfArticleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByESFArticleId(esfArticleId);
	}

	/**
	* Returns a range of all the e s f article_ e s f users where esfArticleId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ethica.esf.model.impl.ESFArticle_ESFUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfArticleId the esf article ID
	* @param start the lower bound of the range of e s f article_ e s f users
	* @param end the upper bound of the range of e s f article_ e s f users (not inclusive)
	* @return the range of matching e s f article_ e s f users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ethica.esf.model.ESFArticle_ESFUser> findByESFArticleId(
		long esfArticleId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByESFArticleId(esfArticleId, start, end);
	}

	/**
	* Returns an ordered range of all the e s f article_ e s f users where esfArticleId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ethica.esf.model.impl.ESFArticle_ESFUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfArticleId the esf article ID
	* @param start the lower bound of the range of e s f article_ e s f users
	* @param end the upper bound of the range of e s f article_ e s f users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f article_ e s f users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ethica.esf.model.ESFArticle_ESFUser> findByESFArticleId(
		long esfArticleId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByESFArticleId(esfArticleId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first e s f article_ e s f user in the ordered set where esfArticleId = &#63;.
	*
	* @param esfArticleId the esf article ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f article_ e s f user
	* @throws com.ethica.esf.NoSuchArticle_ESFUserException if a matching e s f article_ e s f user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ethica.esf.model.ESFArticle_ESFUser findByESFArticleId_First(
		long esfArticleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ethica.esf.NoSuchArticle_ESFUserException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByESFArticleId_First(esfArticleId, orderByComparator);
	}

	/**
	* Returns the first e s f article_ e s f user in the ordered set where esfArticleId = &#63;.
	*
	* @param esfArticleId the esf article ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f article_ e s f user, or <code>null</code> if a matching e s f article_ e s f user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ethica.esf.model.ESFArticle_ESFUser fetchByESFArticleId_First(
		long esfArticleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByESFArticleId_First(esfArticleId, orderByComparator);
	}

	/**
	* Returns the last e s f article_ e s f user in the ordered set where esfArticleId = &#63;.
	*
	* @param esfArticleId the esf article ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f article_ e s f user
	* @throws com.ethica.esf.NoSuchArticle_ESFUserException if a matching e s f article_ e s f user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ethica.esf.model.ESFArticle_ESFUser findByESFArticleId_Last(
		long esfArticleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ethica.esf.NoSuchArticle_ESFUserException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByESFArticleId_Last(esfArticleId, orderByComparator);
	}

	/**
	* Returns the last e s f article_ e s f user in the ordered set where esfArticleId = &#63;.
	*
	* @param esfArticleId the esf article ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f article_ e s f user, or <code>null</code> if a matching e s f article_ e s f user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ethica.esf.model.ESFArticle_ESFUser fetchByESFArticleId_Last(
		long esfArticleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByESFArticleId_Last(esfArticleId, orderByComparator);
	}

	/**
	* Returns the e s f article_ e s f users before and after the current e s f article_ e s f user in the ordered set where esfArticleId = &#63;.
	*
	* @param esfArticle_ESFUserPK the primary key of the current e s f article_ e s f user
	* @param esfArticleId the esf article ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f article_ e s f user
	* @throws com.ethica.esf.NoSuchArticle_ESFUserException if a e s f article_ e s f user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ethica.esf.model.ESFArticle_ESFUser[] findByESFArticleId_PrevAndNext(
		com.ethica.esf.service.persistence.ESFArticle_ESFUserPK esfArticle_ESFUserPK,
		long esfArticleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ethica.esf.NoSuchArticle_ESFUserException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByESFArticleId_PrevAndNext(esfArticle_ESFUserPK,
			esfArticleId, orderByComparator);
	}

	/**
	* Removes all the e s f article_ e s f users where esfArticleId = &#63; from the database.
	*
	* @param esfArticleId the esf article ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByESFArticleId(long esfArticleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByESFArticleId(esfArticleId);
	}

	/**
	* Returns the number of e s f article_ e s f users where esfArticleId = &#63;.
	*
	* @param esfArticleId the esf article ID
	* @return the number of matching e s f article_ e s f users
	* @throws SystemException if a system exception occurred
	*/
	public static int countByESFArticleId(long esfArticleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByESFArticleId(esfArticleId);
	}

	/**
	* Caches the e s f article_ e s f user in the entity cache if it is enabled.
	*
	* @param esfArticle_ESFUser the e s f article_ e s f user
	*/
	public static void cacheResult(
		com.ethica.esf.model.ESFArticle_ESFUser esfArticle_ESFUser) {
		getPersistence().cacheResult(esfArticle_ESFUser);
	}

	/**
	* Caches the e s f article_ e s f users in the entity cache if it is enabled.
	*
	* @param esfArticle_ESFUsers the e s f article_ e s f users
	*/
	public static void cacheResult(
		java.util.List<com.ethica.esf.model.ESFArticle_ESFUser> esfArticle_ESFUsers) {
		getPersistence().cacheResult(esfArticle_ESFUsers);
	}

	/**
	* Creates a new e s f article_ e s f user with the primary key. Does not add the e s f article_ e s f user to the database.
	*
	* @param esfArticle_ESFUserPK the primary key for the new e s f article_ e s f user
	* @return the new e s f article_ e s f user
	*/
	public static com.ethica.esf.model.ESFArticle_ESFUser create(
		com.ethica.esf.service.persistence.ESFArticle_ESFUserPK esfArticle_ESFUserPK) {
		return getPersistence().create(esfArticle_ESFUserPK);
	}

	/**
	* Removes the e s f article_ e s f user with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfArticle_ESFUserPK the primary key of the e s f article_ e s f user
	* @return the e s f article_ e s f user that was removed
	* @throws com.ethica.esf.NoSuchArticle_ESFUserException if a e s f article_ e s f user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ethica.esf.model.ESFArticle_ESFUser remove(
		com.ethica.esf.service.persistence.ESFArticle_ESFUserPK esfArticle_ESFUserPK)
		throws com.ethica.esf.NoSuchArticle_ESFUserException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(esfArticle_ESFUserPK);
	}

	public static com.ethica.esf.model.ESFArticle_ESFUser updateImpl(
		com.ethica.esf.model.ESFArticle_ESFUser esfArticle_ESFUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(esfArticle_ESFUser);
	}

	/**
	* Returns the e s f article_ e s f user with the primary key or throws a {@link com.ethica.esf.NoSuchArticle_ESFUserException} if it could not be found.
	*
	* @param esfArticle_ESFUserPK the primary key of the e s f article_ e s f user
	* @return the e s f article_ e s f user
	* @throws com.ethica.esf.NoSuchArticle_ESFUserException if a e s f article_ e s f user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ethica.esf.model.ESFArticle_ESFUser findByPrimaryKey(
		com.ethica.esf.service.persistence.ESFArticle_ESFUserPK esfArticle_ESFUserPK)
		throws com.ethica.esf.NoSuchArticle_ESFUserException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(esfArticle_ESFUserPK);
	}

	/**
	* Returns the e s f article_ e s f user with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param esfArticle_ESFUserPK the primary key of the e s f article_ e s f user
	* @return the e s f article_ e s f user, or <code>null</code> if a e s f article_ e s f user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ethica.esf.model.ESFArticle_ESFUser fetchByPrimaryKey(
		com.ethica.esf.service.persistence.ESFArticle_ESFUserPK esfArticle_ESFUserPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(esfArticle_ESFUserPK);
	}

	/**
	* Returns all the e s f article_ e s f users.
	*
	* @return the e s f article_ e s f users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ethica.esf.model.ESFArticle_ESFUser> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the e s f article_ e s f users.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ethica.esf.model.impl.ESFArticle_ESFUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f article_ e s f users
	* @param end the upper bound of the range of e s f article_ e s f users (not inclusive)
	* @return the range of e s f article_ e s f users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ethica.esf.model.ESFArticle_ESFUser> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the e s f article_ e s f users.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ethica.esf.model.impl.ESFArticle_ESFUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f article_ e s f users
	* @param end the upper bound of the range of e s f article_ e s f users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of e s f article_ e s f users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ethica.esf.model.ESFArticle_ESFUser> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the e s f article_ e s f users from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of e s f article_ e s f users.
	*
	* @return the number of e s f article_ e s f users
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ESFArticle_ESFUserPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ESFArticle_ESFUserPersistence)PortletBeanLocatorUtil.locate(com.ethica.esf.service.ClpSerializer.getServletContextName(),
					ESFArticle_ESFUserPersistence.class.getName());

			ReferenceRegistry.registerReference(ESFArticle_ESFUserUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ESFArticle_ESFUserPersistence persistence) {
	}

	private static ESFArticle_ESFUserPersistence _persistence;
}