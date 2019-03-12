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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the e s f order service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFOrderPersistenceImpl
 * @see ESFOrderUtil
 * @generated
 */
public interface ESFOrderPersistence extends BasePersistence<ESFOrder> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ESFOrderUtil} to access the e s f order persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the e s f order where code = &#63; or throws a {@link com.ethica.esf.NoSuchOrderException} if it could not be found.
	*
	* @param code the code
	* @return the matching e s f order
	* @throws com.ethica.esf.NoSuchOrderException if a matching e s f order could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ethica.esf.model.ESFOrder findByOrderCode(java.lang.String code)
		throws com.ethica.esf.NoSuchOrderException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f order where code = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param code the code
	* @return the matching e s f order, or <code>null</code> if a matching e s f order could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ethica.esf.model.ESFOrder fetchByOrderCode(java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f order where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param code the code
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching e s f order, or <code>null</code> if a matching e s f order could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ethica.esf.model.ESFOrder fetchByOrderCode(
		java.lang.String code, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the e s f order where code = &#63; from the database.
	*
	* @param code the code
	* @return the e s f order that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.ethica.esf.model.ESFOrder removeByOrderCode(
		java.lang.String code)
		throws com.ethica.esf.NoSuchOrderException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f orders where code = &#63;.
	*
	* @param code the code
	* @return the number of matching e s f orders
	* @throws SystemException if a system exception occurred
	*/
	public int countByOrderCode(java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f orders where esfStockistId = &#63;.
	*
	* @param esfStockistId the esf stockist ID
	* @return the matching e s f orders
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ethica.esf.model.ESFOrder> findByStockist(
		long esfStockistId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.ethica.esf.model.ESFOrder> findByStockist(
		long esfStockistId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.ethica.esf.model.ESFOrder> findByStockist(
		long esfStockistId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f order in the ordered set where esfStockistId = &#63;.
	*
	* @param esfStockistId the esf stockist ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f order
	* @throws com.ethica.esf.NoSuchOrderException if a matching e s f order could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ethica.esf.model.ESFOrder findByStockist_First(
		long esfStockistId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ethica.esf.NoSuchOrderException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f order in the ordered set where esfStockistId = &#63;.
	*
	* @param esfStockistId the esf stockist ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f order, or <code>null</code> if a matching e s f order could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ethica.esf.model.ESFOrder fetchByStockist_First(
		long esfStockistId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f order in the ordered set where esfStockistId = &#63;.
	*
	* @param esfStockistId the esf stockist ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f order
	* @throws com.ethica.esf.NoSuchOrderException if a matching e s f order could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ethica.esf.model.ESFOrder findByStockist_Last(
		long esfStockistId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ethica.esf.NoSuchOrderException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f order in the ordered set where esfStockistId = &#63;.
	*
	* @param esfStockistId the esf stockist ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f order, or <code>null</code> if a matching e s f order could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ethica.esf.model.ESFOrder fetchByStockist_Last(
		long esfStockistId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.ethica.esf.model.ESFOrder[] findByStockist_PrevAndNext(
		long esfOrderId, long esfStockistId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ethica.esf.NoSuchOrderException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the e s f orders where esfStockistId = &#63; from the database.
	*
	* @param esfStockistId the esf stockist ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByStockist(long esfStockistId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f orders where esfStockistId = &#63;.
	*
	* @param esfStockistId the esf stockist ID
	* @return the number of matching e s f orders
	* @throws SystemException if a system exception occurred
	*/
	public int countByStockist(long esfStockistId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f orders where esfArticleId = &#63;.
	*
	* @param esfArticleId the esf article ID
	* @return the matching e s f orders
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ethica.esf.model.ESFOrder> findByEsfArticle(
		long esfArticleId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.ethica.esf.model.ESFOrder> findByEsfArticle(
		long esfArticleId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.ethica.esf.model.ESFOrder> findByEsfArticle(
		long esfArticleId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f order in the ordered set where esfArticleId = &#63;.
	*
	* @param esfArticleId the esf article ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f order
	* @throws com.ethica.esf.NoSuchOrderException if a matching e s f order could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ethica.esf.model.ESFOrder findByEsfArticle_First(
		long esfArticleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ethica.esf.NoSuchOrderException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f order in the ordered set where esfArticleId = &#63;.
	*
	* @param esfArticleId the esf article ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f order, or <code>null</code> if a matching e s f order could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ethica.esf.model.ESFOrder fetchByEsfArticle_First(
		long esfArticleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f order in the ordered set where esfArticleId = &#63;.
	*
	* @param esfArticleId the esf article ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f order
	* @throws com.ethica.esf.NoSuchOrderException if a matching e s f order could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ethica.esf.model.ESFOrder findByEsfArticle_Last(
		long esfArticleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ethica.esf.NoSuchOrderException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f order in the ordered set where esfArticleId = &#63;.
	*
	* @param esfArticleId the esf article ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f order, or <code>null</code> if a matching e s f order could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ethica.esf.model.ESFOrder fetchByEsfArticle_Last(
		long esfArticleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.ethica.esf.model.ESFOrder[] findByEsfArticle_PrevAndNext(
		long esfOrderId, long esfArticleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ethica.esf.NoSuchOrderException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the e s f orders where esfArticleId = &#63; from the database.
	*
	* @param esfArticleId the esf article ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByEsfArticle(long esfArticleId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f orders where esfArticleId = &#63;.
	*
	* @param esfArticleId the esf article ID
	* @return the number of matching e s f orders
	* @throws SystemException if a system exception occurred
	*/
	public int countByEsfArticle(long esfArticleId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the e s f order in the entity cache if it is enabled.
	*
	* @param esfOrder the e s f order
	*/
	public void cacheResult(com.ethica.esf.model.ESFOrder esfOrder);

	/**
	* Caches the e s f orders in the entity cache if it is enabled.
	*
	* @param esfOrders the e s f orders
	*/
	public void cacheResult(
		java.util.List<com.ethica.esf.model.ESFOrder> esfOrders);

	/**
	* Creates a new e s f order with the primary key. Does not add the e s f order to the database.
	*
	* @param esfOrderId the primary key for the new e s f order
	* @return the new e s f order
	*/
	public com.ethica.esf.model.ESFOrder create(long esfOrderId);

	/**
	* Removes the e s f order with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfOrderId the primary key of the e s f order
	* @return the e s f order that was removed
	* @throws com.ethica.esf.NoSuchOrderException if a e s f order with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ethica.esf.model.ESFOrder remove(long esfOrderId)
		throws com.ethica.esf.NoSuchOrderException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.ethica.esf.model.ESFOrder updateImpl(
		com.ethica.esf.model.ESFOrder esfOrder)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f order with the primary key or throws a {@link com.ethica.esf.NoSuchOrderException} if it could not be found.
	*
	* @param esfOrderId the primary key of the e s f order
	* @return the e s f order
	* @throws com.ethica.esf.NoSuchOrderException if a e s f order with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ethica.esf.model.ESFOrder findByPrimaryKey(long esfOrderId)
		throws com.ethica.esf.NoSuchOrderException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f order with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param esfOrderId the primary key of the e s f order
	* @return the e s f order, or <code>null</code> if a e s f order with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ethica.esf.model.ESFOrder fetchByPrimaryKey(long esfOrderId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f orders.
	*
	* @return the e s f orders
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ethica.esf.model.ESFOrder> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.ethica.esf.model.ESFOrder> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.ethica.esf.model.ESFOrder> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the e s f orders from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f orders.
	*
	* @return the number of e s f orders
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}