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

import com.ethica.esf.model.ESFArticle_ESFOrder;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the e s f article_ e s f order service. This utility wraps {@link ESFArticle_ESFOrderPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFArticle_ESFOrderPersistence
 * @see ESFArticle_ESFOrderPersistenceImpl
 * @generated
 */
public class ESFArticle_ESFOrderUtil {
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
	public static void clearCache(ESFArticle_ESFOrder esfArticle_ESFOrder) {
		getPersistence().clearCache(esfArticle_ESFOrder);
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
	public static List<ESFArticle_ESFOrder> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ESFArticle_ESFOrder> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ESFArticle_ESFOrder> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ESFArticle_ESFOrder update(
		ESFArticle_ESFOrder esfArticle_ESFOrder) throws SystemException {
		return getPersistence().update(esfArticle_ESFOrder);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ESFArticle_ESFOrder update(
		ESFArticle_ESFOrder esfArticle_ESFOrder, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(esfArticle_ESFOrder, serviceContext);
	}

	/**
	* Returns all the e s f article_ e s f orders where esfOrderId = &#63;.
	*
	* @param esfOrderId the esf order ID
	* @return the matching e s f article_ e s f orders
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ethica.esf.model.ESFArticle_ESFOrder> findByESFOrderId(
		long esfOrderId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByESFOrderId(esfOrderId);
	}

	/**
	* Returns a range of all the e s f article_ e s f orders where esfOrderId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ethica.esf.model.impl.ESFArticle_ESFOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfOrderId the esf order ID
	* @param start the lower bound of the range of e s f article_ e s f orders
	* @param end the upper bound of the range of e s f article_ e s f orders (not inclusive)
	* @return the range of matching e s f article_ e s f orders
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ethica.esf.model.ESFArticle_ESFOrder> findByESFOrderId(
		long esfOrderId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByESFOrderId(esfOrderId, start, end);
	}

	/**
	* Returns an ordered range of all the e s f article_ e s f orders where esfOrderId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ethica.esf.model.impl.ESFArticle_ESFOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfOrderId the esf order ID
	* @param start the lower bound of the range of e s f article_ e s f orders
	* @param end the upper bound of the range of e s f article_ e s f orders (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f article_ e s f orders
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ethica.esf.model.ESFArticle_ESFOrder> findByESFOrderId(
		long esfOrderId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByESFOrderId(esfOrderId, start, end, orderByComparator);
	}

	/**
	* Returns the first e s f article_ e s f order in the ordered set where esfOrderId = &#63;.
	*
	* @param esfOrderId the esf order ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f article_ e s f order
	* @throws com.ethica.esf.NoSuchArticle_ESFOrderException if a matching e s f article_ e s f order could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ethica.esf.model.ESFArticle_ESFOrder findByESFOrderId_First(
		long esfOrderId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ethica.esf.NoSuchArticle_ESFOrderException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByESFOrderId_First(esfOrderId, orderByComparator);
	}

	/**
	* Returns the first e s f article_ e s f order in the ordered set where esfOrderId = &#63;.
	*
	* @param esfOrderId the esf order ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f article_ e s f order, or <code>null</code> if a matching e s f article_ e s f order could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ethica.esf.model.ESFArticle_ESFOrder fetchByESFOrderId_First(
		long esfOrderId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByESFOrderId_First(esfOrderId, orderByComparator);
	}

	/**
	* Returns the last e s f article_ e s f order in the ordered set where esfOrderId = &#63;.
	*
	* @param esfOrderId the esf order ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f article_ e s f order
	* @throws com.ethica.esf.NoSuchArticle_ESFOrderException if a matching e s f article_ e s f order could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ethica.esf.model.ESFArticle_ESFOrder findByESFOrderId_Last(
		long esfOrderId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ethica.esf.NoSuchArticle_ESFOrderException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByESFOrderId_Last(esfOrderId, orderByComparator);
	}

	/**
	* Returns the last e s f article_ e s f order in the ordered set where esfOrderId = &#63;.
	*
	* @param esfOrderId the esf order ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f article_ e s f order, or <code>null</code> if a matching e s f article_ e s f order could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ethica.esf.model.ESFArticle_ESFOrder fetchByESFOrderId_Last(
		long esfOrderId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByESFOrderId_Last(esfOrderId, orderByComparator);
	}

	/**
	* Returns the e s f article_ e s f orders before and after the current e s f article_ e s f order in the ordered set where esfOrderId = &#63;.
	*
	* @param esfArticle_ESFOrderPK the primary key of the current e s f article_ e s f order
	* @param esfOrderId the esf order ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f article_ e s f order
	* @throws com.ethica.esf.NoSuchArticle_ESFOrderException if a e s f article_ e s f order with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ethica.esf.model.ESFArticle_ESFOrder[] findByESFOrderId_PrevAndNext(
		com.ethica.esf.service.persistence.ESFArticle_ESFOrderPK esfArticle_ESFOrderPK,
		long esfOrderId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ethica.esf.NoSuchArticle_ESFOrderException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByESFOrderId_PrevAndNext(esfArticle_ESFOrderPK,
			esfOrderId, orderByComparator);
	}

	/**
	* Removes all the e s f article_ e s f orders where esfOrderId = &#63; from the database.
	*
	* @param esfOrderId the esf order ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByESFOrderId(long esfOrderId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByESFOrderId(esfOrderId);
	}

	/**
	* Returns the number of e s f article_ e s f orders where esfOrderId = &#63;.
	*
	* @param esfOrderId the esf order ID
	* @return the number of matching e s f article_ e s f orders
	* @throws SystemException if a system exception occurred
	*/
	public static int countByESFOrderId(long esfOrderId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByESFOrderId(esfOrderId);
	}

	/**
	* Caches the e s f article_ e s f order in the entity cache if it is enabled.
	*
	* @param esfArticle_ESFOrder the e s f article_ e s f order
	*/
	public static void cacheResult(
		com.ethica.esf.model.ESFArticle_ESFOrder esfArticle_ESFOrder) {
		getPersistence().cacheResult(esfArticle_ESFOrder);
	}

	/**
	* Caches the e s f article_ e s f orders in the entity cache if it is enabled.
	*
	* @param esfArticle_ESFOrders the e s f article_ e s f orders
	*/
	public static void cacheResult(
		java.util.List<com.ethica.esf.model.ESFArticle_ESFOrder> esfArticle_ESFOrders) {
		getPersistence().cacheResult(esfArticle_ESFOrders);
	}

	/**
	* Creates a new e s f article_ e s f order with the primary key. Does not add the e s f article_ e s f order to the database.
	*
	* @param esfArticle_ESFOrderPK the primary key for the new e s f article_ e s f order
	* @return the new e s f article_ e s f order
	*/
	public static com.ethica.esf.model.ESFArticle_ESFOrder create(
		com.ethica.esf.service.persistence.ESFArticle_ESFOrderPK esfArticle_ESFOrderPK) {
		return getPersistence().create(esfArticle_ESFOrderPK);
	}

	/**
	* Removes the e s f article_ e s f order with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfArticle_ESFOrderPK the primary key of the e s f article_ e s f order
	* @return the e s f article_ e s f order that was removed
	* @throws com.ethica.esf.NoSuchArticle_ESFOrderException if a e s f article_ e s f order with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ethica.esf.model.ESFArticle_ESFOrder remove(
		com.ethica.esf.service.persistence.ESFArticle_ESFOrderPK esfArticle_ESFOrderPK)
		throws com.ethica.esf.NoSuchArticle_ESFOrderException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(esfArticle_ESFOrderPK);
	}

	public static com.ethica.esf.model.ESFArticle_ESFOrder updateImpl(
		com.ethica.esf.model.ESFArticle_ESFOrder esfArticle_ESFOrder)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(esfArticle_ESFOrder);
	}

	/**
	* Returns the e s f article_ e s f order with the primary key or throws a {@link com.ethica.esf.NoSuchArticle_ESFOrderException} if it could not be found.
	*
	* @param esfArticle_ESFOrderPK the primary key of the e s f article_ e s f order
	* @return the e s f article_ e s f order
	* @throws com.ethica.esf.NoSuchArticle_ESFOrderException if a e s f article_ e s f order with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ethica.esf.model.ESFArticle_ESFOrder findByPrimaryKey(
		com.ethica.esf.service.persistence.ESFArticle_ESFOrderPK esfArticle_ESFOrderPK)
		throws com.ethica.esf.NoSuchArticle_ESFOrderException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(esfArticle_ESFOrderPK);
	}

	/**
	* Returns the e s f article_ e s f order with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param esfArticle_ESFOrderPK the primary key of the e s f article_ e s f order
	* @return the e s f article_ e s f order, or <code>null</code> if a e s f article_ e s f order with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ethica.esf.model.ESFArticle_ESFOrder fetchByPrimaryKey(
		com.ethica.esf.service.persistence.ESFArticle_ESFOrderPK esfArticle_ESFOrderPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(esfArticle_ESFOrderPK);
	}

	/**
	* Returns all the e s f article_ e s f orders.
	*
	* @return the e s f article_ e s f orders
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ethica.esf.model.ESFArticle_ESFOrder> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the e s f article_ e s f orders.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ethica.esf.model.impl.ESFArticle_ESFOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f article_ e s f orders
	* @param end the upper bound of the range of e s f article_ e s f orders (not inclusive)
	* @return the range of e s f article_ e s f orders
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ethica.esf.model.ESFArticle_ESFOrder> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the e s f article_ e s f orders.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ethica.esf.model.impl.ESFArticle_ESFOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f article_ e s f orders
	* @param end the upper bound of the range of e s f article_ e s f orders (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of e s f article_ e s f orders
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ethica.esf.model.ESFArticle_ESFOrder> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the e s f article_ e s f orders from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of e s f article_ e s f orders.
	*
	* @return the number of e s f article_ e s f orders
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ESFArticle_ESFOrderPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ESFArticle_ESFOrderPersistence)PortletBeanLocatorUtil.locate(com.ethica.esf.service.ClpSerializer.getServletContextName(),
					ESFArticle_ESFOrderPersistence.class.getName());

			ReferenceRegistry.registerReference(ESFArticle_ESFOrderUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ESFArticle_ESFOrderPersistence persistence) {
	}

	private static ESFArticle_ESFOrderPersistence _persistence;
}