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

import com.ethica.esf.model.ESFArticleDelivered;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the e s f article delivered service. This utility wraps {@link ESFArticleDeliveredPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFArticleDeliveredPersistence
 * @see ESFArticleDeliveredPersistenceImpl
 * @generated
 */
public class ESFArticleDeliveredUtil {
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
	public static void clearCache(ESFArticleDelivered esfArticleDelivered) {
		getPersistence().clearCache(esfArticleDelivered);
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
	public static List<ESFArticleDelivered> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ESFArticleDelivered> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ESFArticleDelivered> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ESFArticleDelivered update(
		ESFArticleDelivered esfArticleDelivered) throws SystemException {
		return getPersistence().update(esfArticleDelivered);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ESFArticleDelivered update(
		ESFArticleDelivered esfArticleDelivered, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(esfArticleDelivered, serviceContext);
	}

	/**
	* Returns all the e s f article delivereds where esfArticleId = &#63;.
	*
	* @param esfArticleId the esf article ID
	* @return the matching e s f article delivereds
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ethica.esf.model.ESFArticleDelivered> findByEsfArticleId(
		long esfArticleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByEsfArticleId(esfArticleId);
	}

	/**
	* Returns a range of all the e s f article delivereds where esfArticleId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ethica.esf.model.impl.ESFArticleDeliveredModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfArticleId the esf article ID
	* @param start the lower bound of the range of e s f article delivereds
	* @param end the upper bound of the range of e s f article delivereds (not inclusive)
	* @return the range of matching e s f article delivereds
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ethica.esf.model.ESFArticleDelivered> findByEsfArticleId(
		long esfArticleId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByEsfArticleId(esfArticleId, start, end);
	}

	/**
	* Returns an ordered range of all the e s f article delivereds where esfArticleId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ethica.esf.model.impl.ESFArticleDeliveredModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfArticleId the esf article ID
	* @param start the lower bound of the range of e s f article delivereds
	* @param end the upper bound of the range of e s f article delivereds (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f article delivereds
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ethica.esf.model.ESFArticleDelivered> findByEsfArticleId(
		long esfArticleId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByEsfArticleId(esfArticleId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first e s f article delivered in the ordered set where esfArticleId = &#63;.
	*
	* @param esfArticleId the esf article ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f article delivered
	* @throws com.ethica.esf.NoSuchArticleDeliveredException if a matching e s f article delivered could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ethica.esf.model.ESFArticleDelivered findByEsfArticleId_First(
		long esfArticleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ethica.esf.NoSuchArticleDeliveredException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByEsfArticleId_First(esfArticleId, orderByComparator);
	}

	/**
	* Returns the first e s f article delivered in the ordered set where esfArticleId = &#63;.
	*
	* @param esfArticleId the esf article ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f article delivered, or <code>null</code> if a matching e s f article delivered could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ethica.esf.model.ESFArticleDelivered fetchByEsfArticleId_First(
		long esfArticleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByEsfArticleId_First(esfArticleId, orderByComparator);
	}

	/**
	* Returns the last e s f article delivered in the ordered set where esfArticleId = &#63;.
	*
	* @param esfArticleId the esf article ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f article delivered
	* @throws com.ethica.esf.NoSuchArticleDeliveredException if a matching e s f article delivered could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ethica.esf.model.ESFArticleDelivered findByEsfArticleId_Last(
		long esfArticleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ethica.esf.NoSuchArticleDeliveredException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByEsfArticleId_Last(esfArticleId, orderByComparator);
	}

	/**
	* Returns the last e s f article delivered in the ordered set where esfArticleId = &#63;.
	*
	* @param esfArticleId the esf article ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f article delivered, or <code>null</code> if a matching e s f article delivered could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ethica.esf.model.ESFArticleDelivered fetchByEsfArticleId_Last(
		long esfArticleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByEsfArticleId_Last(esfArticleId, orderByComparator);
	}

	/**
	* Returns the e s f article delivereds before and after the current e s f article delivered in the ordered set where esfArticleId = &#63;.
	*
	* @param esfArticleDeliveredId the primary key of the current e s f article delivered
	* @param esfArticleId the esf article ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f article delivered
	* @throws com.ethica.esf.NoSuchArticleDeliveredException if a e s f article delivered with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ethica.esf.model.ESFArticleDelivered[] findByEsfArticleId_PrevAndNext(
		long esfArticleDeliveredId, long esfArticleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ethica.esf.NoSuchArticleDeliveredException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByEsfArticleId_PrevAndNext(esfArticleDeliveredId,
			esfArticleId, orderByComparator);
	}

	/**
	* Removes all the e s f article delivereds where esfArticleId = &#63; from the database.
	*
	* @param esfArticleId the esf article ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByEsfArticleId(long esfArticleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByEsfArticleId(esfArticleId);
	}

	/**
	* Returns the number of e s f article delivereds where esfArticleId = &#63;.
	*
	* @param esfArticleId the esf article ID
	* @return the number of matching e s f article delivereds
	* @throws SystemException if a system exception occurred
	*/
	public static int countByEsfArticleId(long esfArticleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByEsfArticleId(esfArticleId);
	}

	/**
	* Returns all the e s f article delivereds where esfShooterId = &#63;.
	*
	* @param esfShooterId the esf shooter ID
	* @return the matching e s f article delivereds
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ethica.esf.model.ESFArticleDelivered> findByEsfShooterId(
		long esfShooterId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByEsfShooterId(esfShooterId);
	}

	/**
	* Returns a range of all the e s f article delivereds where esfShooterId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ethica.esf.model.impl.ESFArticleDeliveredModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfShooterId the esf shooter ID
	* @param start the lower bound of the range of e s f article delivereds
	* @param end the upper bound of the range of e s f article delivereds (not inclusive)
	* @return the range of matching e s f article delivereds
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ethica.esf.model.ESFArticleDelivered> findByEsfShooterId(
		long esfShooterId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByEsfShooterId(esfShooterId, start, end);
	}

	/**
	* Returns an ordered range of all the e s f article delivereds where esfShooterId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ethica.esf.model.impl.ESFArticleDeliveredModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfShooterId the esf shooter ID
	* @param start the lower bound of the range of e s f article delivereds
	* @param end the upper bound of the range of e s f article delivereds (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f article delivereds
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ethica.esf.model.ESFArticleDelivered> findByEsfShooterId(
		long esfShooterId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByEsfShooterId(esfShooterId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first e s f article delivered in the ordered set where esfShooterId = &#63;.
	*
	* @param esfShooterId the esf shooter ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f article delivered
	* @throws com.ethica.esf.NoSuchArticleDeliveredException if a matching e s f article delivered could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ethica.esf.model.ESFArticleDelivered findByEsfShooterId_First(
		long esfShooterId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ethica.esf.NoSuchArticleDeliveredException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByEsfShooterId_First(esfShooterId, orderByComparator);
	}

	/**
	* Returns the first e s f article delivered in the ordered set where esfShooterId = &#63;.
	*
	* @param esfShooterId the esf shooter ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f article delivered, or <code>null</code> if a matching e s f article delivered could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ethica.esf.model.ESFArticleDelivered fetchByEsfShooterId_First(
		long esfShooterId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByEsfShooterId_First(esfShooterId, orderByComparator);
	}

	/**
	* Returns the last e s f article delivered in the ordered set where esfShooterId = &#63;.
	*
	* @param esfShooterId the esf shooter ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f article delivered
	* @throws com.ethica.esf.NoSuchArticleDeliveredException if a matching e s f article delivered could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ethica.esf.model.ESFArticleDelivered findByEsfShooterId_Last(
		long esfShooterId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ethica.esf.NoSuchArticleDeliveredException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByEsfShooterId_Last(esfShooterId, orderByComparator);
	}

	/**
	* Returns the last e s f article delivered in the ordered set where esfShooterId = &#63;.
	*
	* @param esfShooterId the esf shooter ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f article delivered, or <code>null</code> if a matching e s f article delivered could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ethica.esf.model.ESFArticleDelivered fetchByEsfShooterId_Last(
		long esfShooterId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByEsfShooterId_Last(esfShooterId, orderByComparator);
	}

	/**
	* Returns the e s f article delivereds before and after the current e s f article delivered in the ordered set where esfShooterId = &#63;.
	*
	* @param esfArticleDeliveredId the primary key of the current e s f article delivered
	* @param esfShooterId the esf shooter ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f article delivered
	* @throws com.ethica.esf.NoSuchArticleDeliveredException if a e s f article delivered with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ethica.esf.model.ESFArticleDelivered[] findByEsfShooterId_PrevAndNext(
		long esfArticleDeliveredId, long esfShooterId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ethica.esf.NoSuchArticleDeliveredException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByEsfShooterId_PrevAndNext(esfArticleDeliveredId,
			esfShooterId, orderByComparator);
	}

	/**
	* Removes all the e s f article delivereds where esfShooterId = &#63; from the database.
	*
	* @param esfShooterId the esf shooter ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByEsfShooterId(long esfShooterId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByEsfShooterId(esfShooterId);
	}

	/**
	* Returns the number of e s f article delivereds where esfShooterId = &#63;.
	*
	* @param esfShooterId the esf shooter ID
	* @return the number of matching e s f article delivereds
	* @throws SystemException if a system exception occurred
	*/
	public static int countByEsfShooterId(long esfShooterId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByEsfShooterId(esfShooterId);
	}

	/**
	* Caches the e s f article delivered in the entity cache if it is enabled.
	*
	* @param esfArticleDelivered the e s f article delivered
	*/
	public static void cacheResult(
		com.ethica.esf.model.ESFArticleDelivered esfArticleDelivered) {
		getPersistence().cacheResult(esfArticleDelivered);
	}

	/**
	* Caches the e s f article delivereds in the entity cache if it is enabled.
	*
	* @param esfArticleDelivereds the e s f article delivereds
	*/
	public static void cacheResult(
		java.util.List<com.ethica.esf.model.ESFArticleDelivered> esfArticleDelivereds) {
		getPersistence().cacheResult(esfArticleDelivereds);
	}

	/**
	* Creates a new e s f article delivered with the primary key. Does not add the e s f article delivered to the database.
	*
	* @param esfArticleDeliveredId the primary key for the new e s f article delivered
	* @return the new e s f article delivered
	*/
	public static com.ethica.esf.model.ESFArticleDelivered create(
		long esfArticleDeliveredId) {
		return getPersistence().create(esfArticleDeliveredId);
	}

	/**
	* Removes the e s f article delivered with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfArticleDeliveredId the primary key of the e s f article delivered
	* @return the e s f article delivered that was removed
	* @throws com.ethica.esf.NoSuchArticleDeliveredException if a e s f article delivered with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ethica.esf.model.ESFArticleDelivered remove(
		long esfArticleDeliveredId)
		throws com.ethica.esf.NoSuchArticleDeliveredException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(esfArticleDeliveredId);
	}

	public static com.ethica.esf.model.ESFArticleDelivered updateImpl(
		com.ethica.esf.model.ESFArticleDelivered esfArticleDelivered)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(esfArticleDelivered);
	}

	/**
	* Returns the e s f article delivered with the primary key or throws a {@link com.ethica.esf.NoSuchArticleDeliveredException} if it could not be found.
	*
	* @param esfArticleDeliveredId the primary key of the e s f article delivered
	* @return the e s f article delivered
	* @throws com.ethica.esf.NoSuchArticleDeliveredException if a e s f article delivered with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ethica.esf.model.ESFArticleDelivered findByPrimaryKey(
		long esfArticleDeliveredId)
		throws com.ethica.esf.NoSuchArticleDeliveredException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(esfArticleDeliveredId);
	}

	/**
	* Returns the e s f article delivered with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param esfArticleDeliveredId the primary key of the e s f article delivered
	* @return the e s f article delivered, or <code>null</code> if a e s f article delivered with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ethica.esf.model.ESFArticleDelivered fetchByPrimaryKey(
		long esfArticleDeliveredId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(esfArticleDeliveredId);
	}

	/**
	* Returns all the e s f article delivereds.
	*
	* @return the e s f article delivereds
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ethica.esf.model.ESFArticleDelivered> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the e s f article delivereds.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ethica.esf.model.impl.ESFArticleDeliveredModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f article delivereds
	* @param end the upper bound of the range of e s f article delivereds (not inclusive)
	* @return the range of e s f article delivereds
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ethica.esf.model.ESFArticleDelivered> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the e s f article delivereds.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ethica.esf.model.impl.ESFArticleDeliveredModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f article delivereds
	* @param end the upper bound of the range of e s f article delivereds (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of e s f article delivereds
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ethica.esf.model.ESFArticleDelivered> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the e s f article delivereds from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of e s f article delivereds.
	*
	* @return the number of e s f article delivereds
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ESFArticleDeliveredPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ESFArticleDeliveredPersistence)PortletBeanLocatorUtil.locate(com.ethica.esf.service.ClpSerializer.getServletContextName(),
					ESFArticleDeliveredPersistence.class.getName());

			ReferenceRegistry.registerReference(ESFArticleDeliveredUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ESFArticleDeliveredPersistence persistence) {
	}

	private static ESFArticleDeliveredPersistence _persistence;
}