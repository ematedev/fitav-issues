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

import com.ethica.esf.model.ESFOrder;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the e s f order service. This utility wraps {@link ESFOrderPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFOrderPersistence
 * @see ESFOrderPersistenceImpl
 * @generated
 */
public class ESFOrderUtil {
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
	public static void clearCache(ESFOrder esfOrder) {
		getPersistence().clearCache(esfOrder);
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
	public static List<ESFOrder> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ESFOrder> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ESFOrder> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ESFOrder update(ESFOrder esfOrder) throws SystemException {
		return getPersistence().update(esfOrder);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ESFOrder update(ESFOrder esfOrder,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(esfOrder, serviceContext);
	}

	/**
	* Returns the e s f order where code = &#63; or throws a {@link com.ethica.esf.NoSuchOrderException} if it could not be found.
	*
	* @param code the code
	* @return the matching e s f order
	* @throws com.ethica.esf.NoSuchOrderException if a matching e s f order could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ethica.esf.model.ESFOrder findByOrderCode(
		java.lang.String code)
		throws com.ethica.esf.NoSuchOrderException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByOrderCode(code);
	}

	/**
	* Returns the e s f order where code = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param code the code
	* @return the matching e s f order, or <code>null</code> if a matching e s f order could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ethica.esf.model.ESFOrder fetchByOrderCode(
		java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByOrderCode(code);
	}

	/**
	* Returns the e s f order where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param code the code
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching e s f order, or <code>null</code> if a matching e s f order could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ethica.esf.model.ESFOrder fetchByOrderCode(
		java.lang.String code, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByOrderCode(code, retrieveFromCache);
	}

	/**
	* Removes the e s f order where code = &#63; from the database.
	*
	* @param code the code
	* @return the e s f order that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.ethica.esf.model.ESFOrder removeByOrderCode(
		java.lang.String code)
		throws com.ethica.esf.NoSuchOrderException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByOrderCode(code);
	}

	/**
	* Returns the number of e s f orders where code = &#63;.
	*
	* @param code the code
	* @return the number of matching e s f orders
	* @throws SystemException if a system exception occurred
	*/
	public static int countByOrderCode(java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByOrderCode(code);
	}

	/**
	* Returns all the e s f orders where esfStockistId = &#63;.
	*
	* @param esfStockistId the esf stockist ID
	* @return the matching e s f orders
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ethica.esf.model.ESFOrder> findByStockist(
		long esfStockistId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStockist(esfStockistId);
	}

	/**
	* Returns a range of all the e s f orders where esfStockistId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ethica.esf.model.impl.ESFOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfStockistId the esf stockist ID
	* @param start the lower bound of the range of e s f orders
	* @param end the upper bound of the range of e s f orders (not inclusive)
	* @return the range of matching e s f orders
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ethica.esf.model.ESFOrder> findByStockist(
		long esfStockistId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStockist(esfStockistId, start, end);
	}

	/**
	* Returns an ordered range of all the e s f orders where esfStockistId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ethica.esf.model.impl.ESFOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfStockistId the esf stockist ID
	* @param start the lower bound of the range of e s f orders
	* @param end the upper bound of the range of e s f orders (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f orders
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ethica.esf.model.ESFOrder> findByStockist(
		long esfStockistId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStockist(esfStockistId, start, end, orderByComparator);
	}

	/**
	* Returns the first e s f order in the ordered set where esfStockistId = &#63;.
	*
	* @param esfStockistId the esf stockist ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f order
	* @throws com.ethica.esf.NoSuchOrderException if a matching e s f order could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ethica.esf.model.ESFOrder findByStockist_First(
		long esfStockistId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ethica.esf.NoSuchOrderException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStockist_First(esfStockistId, orderByComparator);
	}

	/**
	* Returns the first e s f order in the ordered set where esfStockistId = &#63;.
	*
	* @param esfStockistId the esf stockist ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f order, or <code>null</code> if a matching e s f order could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ethica.esf.model.ESFOrder fetchByStockist_First(
		long esfStockistId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByStockist_First(esfStockistId, orderByComparator);
	}

	/**
	* Returns the last e s f order in the ordered set where esfStockistId = &#63;.
	*
	* @param esfStockistId the esf stockist ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f order
	* @throws com.ethica.esf.NoSuchOrderException if a matching e s f order could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ethica.esf.model.ESFOrder findByStockist_Last(
		long esfStockistId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ethica.esf.NoSuchOrderException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStockist_Last(esfStockistId, orderByComparator);
	}

	/**
	* Returns the last e s f order in the ordered set where esfStockistId = &#63;.
	*
	* @param esfStockistId the esf stockist ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f order, or <code>null</code> if a matching e s f order could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ethica.esf.model.ESFOrder fetchByStockist_Last(
		long esfStockistId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByStockist_Last(esfStockistId, orderByComparator);
	}

	/**
	* Returns the e s f orders before and after the current e s f order in the ordered set where esfStockistId = &#63;.
	*
	* @param esfOrderId the primary key of the current e s f order
	* @param esfStockistId the esf stockist ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f order
	* @throws com.ethica.esf.NoSuchOrderException if a e s f order with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ethica.esf.model.ESFOrder[] findByStockist_PrevAndNext(
		long esfOrderId, long esfStockistId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ethica.esf.NoSuchOrderException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStockist_PrevAndNext(esfOrderId, esfStockistId,
			orderByComparator);
	}

	/**
	* Removes all the e s f orders where esfStockistId = &#63; from the database.
	*
	* @param esfStockistId the esf stockist ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByStockist(long esfStockistId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByStockist(esfStockistId);
	}

	/**
	* Returns the number of e s f orders where esfStockistId = &#63;.
	*
	* @param esfStockistId the esf stockist ID
	* @return the number of matching e s f orders
	* @throws SystemException if a system exception occurred
	*/
	public static int countByStockist(long esfStockistId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByStockist(esfStockistId);
	}

	/**
	* Returns all the e s f orders where esfArticleId = &#63;.
	*
	* @param esfArticleId the esf article ID
	* @return the matching e s f orders
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ethica.esf.model.ESFOrder> findByEsfArticle(
		long esfArticleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByEsfArticle(esfArticleId);
	}

	/**
	* Returns a range of all the e s f orders where esfArticleId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ethica.esf.model.impl.ESFOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfArticleId the esf article ID
	* @param start the lower bound of the range of e s f orders
	* @param end the upper bound of the range of e s f orders (not inclusive)
	* @return the range of matching e s f orders
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ethica.esf.model.ESFOrder> findByEsfArticle(
		long esfArticleId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByEsfArticle(esfArticleId, start, end);
	}

	/**
	* Returns an ordered range of all the e s f orders where esfArticleId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ethica.esf.model.impl.ESFOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfArticleId the esf article ID
	* @param start the lower bound of the range of e s f orders
	* @param end the upper bound of the range of e s f orders (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f orders
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ethica.esf.model.ESFOrder> findByEsfArticle(
		long esfArticleId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByEsfArticle(esfArticleId, start, end, orderByComparator);
	}

	/**
	* Returns the first e s f order in the ordered set where esfArticleId = &#63;.
	*
	* @param esfArticleId the esf article ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f order
	* @throws com.ethica.esf.NoSuchOrderException if a matching e s f order could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ethica.esf.model.ESFOrder findByEsfArticle_First(
		long esfArticleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ethica.esf.NoSuchOrderException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByEsfArticle_First(esfArticleId, orderByComparator);
	}

	/**
	* Returns the first e s f order in the ordered set where esfArticleId = &#63;.
	*
	* @param esfArticleId the esf article ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f order, or <code>null</code> if a matching e s f order could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ethica.esf.model.ESFOrder fetchByEsfArticle_First(
		long esfArticleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByEsfArticle_First(esfArticleId, orderByComparator);
	}

	/**
	* Returns the last e s f order in the ordered set where esfArticleId = &#63;.
	*
	* @param esfArticleId the esf article ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f order
	* @throws com.ethica.esf.NoSuchOrderException if a matching e s f order could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ethica.esf.model.ESFOrder findByEsfArticle_Last(
		long esfArticleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ethica.esf.NoSuchOrderException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByEsfArticle_Last(esfArticleId, orderByComparator);
	}

	/**
	* Returns the last e s f order in the ordered set where esfArticleId = &#63;.
	*
	* @param esfArticleId the esf article ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f order, or <code>null</code> if a matching e s f order could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ethica.esf.model.ESFOrder fetchByEsfArticle_Last(
		long esfArticleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByEsfArticle_Last(esfArticleId, orderByComparator);
	}

	/**
	* Returns the e s f orders before and after the current e s f order in the ordered set where esfArticleId = &#63;.
	*
	* @param esfOrderId the primary key of the current e s f order
	* @param esfArticleId the esf article ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f order
	* @throws com.ethica.esf.NoSuchOrderException if a e s f order with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ethica.esf.model.ESFOrder[] findByEsfArticle_PrevAndNext(
		long esfOrderId, long esfArticleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ethica.esf.NoSuchOrderException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByEsfArticle_PrevAndNext(esfOrderId, esfArticleId,
			orderByComparator);
	}

	/**
	* Removes all the e s f orders where esfArticleId = &#63; from the database.
	*
	* @param esfArticleId the esf article ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByEsfArticle(long esfArticleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByEsfArticle(esfArticleId);
	}

	/**
	* Returns the number of e s f orders where esfArticleId = &#63;.
	*
	* @param esfArticleId the esf article ID
	* @return the number of matching e s f orders
	* @throws SystemException if a system exception occurred
	*/
	public static int countByEsfArticle(long esfArticleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByEsfArticle(esfArticleId);
	}

	/**
	* Caches the e s f order in the entity cache if it is enabled.
	*
	* @param esfOrder the e s f order
	*/
	public static void cacheResult(com.ethica.esf.model.ESFOrder esfOrder) {
		getPersistence().cacheResult(esfOrder);
	}

	/**
	* Caches the e s f orders in the entity cache if it is enabled.
	*
	* @param esfOrders the e s f orders
	*/
	public static void cacheResult(
		java.util.List<com.ethica.esf.model.ESFOrder> esfOrders) {
		getPersistence().cacheResult(esfOrders);
	}

	/**
	* Creates a new e s f order with the primary key. Does not add the e s f order to the database.
	*
	* @param esfOrderId the primary key for the new e s f order
	* @return the new e s f order
	*/
	public static com.ethica.esf.model.ESFOrder create(long esfOrderId) {
		return getPersistence().create(esfOrderId);
	}

	/**
	* Removes the e s f order with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfOrderId the primary key of the e s f order
	* @return the e s f order that was removed
	* @throws com.ethica.esf.NoSuchOrderException if a e s f order with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ethica.esf.model.ESFOrder remove(long esfOrderId)
		throws com.ethica.esf.NoSuchOrderException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(esfOrderId);
	}

	public static com.ethica.esf.model.ESFOrder updateImpl(
		com.ethica.esf.model.ESFOrder esfOrder)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(esfOrder);
	}

	/**
	* Returns the e s f order with the primary key or throws a {@link com.ethica.esf.NoSuchOrderException} if it could not be found.
	*
	* @param esfOrderId the primary key of the e s f order
	* @return the e s f order
	* @throws com.ethica.esf.NoSuchOrderException if a e s f order with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ethica.esf.model.ESFOrder findByPrimaryKey(
		long esfOrderId)
		throws com.ethica.esf.NoSuchOrderException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(esfOrderId);
	}

	/**
	* Returns the e s f order with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param esfOrderId the primary key of the e s f order
	* @return the e s f order, or <code>null</code> if a e s f order with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ethica.esf.model.ESFOrder fetchByPrimaryKey(
		long esfOrderId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(esfOrderId);
	}

	/**
	* Returns all the e s f orders.
	*
	* @return the e s f orders
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ethica.esf.model.ESFOrder> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the e s f orders.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ethica.esf.model.impl.ESFOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f orders
	* @param end the upper bound of the range of e s f orders (not inclusive)
	* @return the range of e s f orders
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ethica.esf.model.ESFOrder> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the e s f orders.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ethica.esf.model.impl.ESFOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f orders
	* @param end the upper bound of the range of e s f orders (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of e s f orders
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ethica.esf.model.ESFOrder> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the e s f orders from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of e s f orders.
	*
	* @return the number of e s f orders
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ESFOrderPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ESFOrderPersistence)PortletBeanLocatorUtil.locate(com.ethica.esf.service.ClpSerializer.getServletContextName(),
					ESFOrderPersistence.class.getName());

			ReferenceRegistry.registerReference(ESFOrderUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ESFOrderPersistence persistence) {
	}

	private static ESFOrderPersistence _persistence;
}