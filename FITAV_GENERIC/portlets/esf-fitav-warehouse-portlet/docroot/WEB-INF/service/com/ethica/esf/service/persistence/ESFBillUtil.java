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

import com.ethica.esf.model.ESFBill;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the e s f bill service. This utility wraps {@link ESFBillPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFBillPersistence
 * @see ESFBillPersistenceImpl
 * @generated
 */
public class ESFBillUtil {
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
	public static void clearCache(ESFBill esfBill) {
		getPersistence().clearCache(esfBill);
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
	public static List<ESFBill> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ESFBill> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ESFBill> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ESFBill update(ESFBill esfBill) throws SystemException {
		return getPersistence().update(esfBill);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ESFBill update(ESFBill esfBill, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(esfBill, serviceContext);
	}

	/**
	* Returns all the e s f bills where esfArticleId = &#63; and esfOrderId = &#63;.
	*
	* @param esfArticleId the esf article ID
	* @param esfOrderId the esf order ID
	* @return the matching e s f bills
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ethica.esf.model.ESFBill> findByEA_EO(
		long esfArticleId, long esfOrderId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByEA_EO(esfArticleId, esfOrderId);
	}

	/**
	* Returns a range of all the e s f bills where esfArticleId = &#63; and esfOrderId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ethica.esf.model.impl.ESFBillModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfArticleId the esf article ID
	* @param esfOrderId the esf order ID
	* @param start the lower bound of the range of e s f bills
	* @param end the upper bound of the range of e s f bills (not inclusive)
	* @return the range of matching e s f bills
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ethica.esf.model.ESFBill> findByEA_EO(
		long esfArticleId, long esfOrderId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByEA_EO(esfArticleId, esfOrderId, start, end);
	}

	/**
	* Returns an ordered range of all the e s f bills where esfArticleId = &#63; and esfOrderId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ethica.esf.model.impl.ESFBillModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfArticleId the esf article ID
	* @param esfOrderId the esf order ID
	* @param start the lower bound of the range of e s f bills
	* @param end the upper bound of the range of e s f bills (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f bills
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ethica.esf.model.ESFBill> findByEA_EO(
		long esfArticleId, long esfOrderId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByEA_EO(esfArticleId, esfOrderId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first e s f bill in the ordered set where esfArticleId = &#63; and esfOrderId = &#63;.
	*
	* @param esfArticleId the esf article ID
	* @param esfOrderId the esf order ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f bill
	* @throws com.ethica.esf.NoSuchBillException if a matching e s f bill could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ethica.esf.model.ESFBill findByEA_EO_First(
		long esfArticleId, long esfOrderId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ethica.esf.NoSuchBillException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByEA_EO_First(esfArticleId, esfOrderId,
			orderByComparator);
	}

	/**
	* Returns the first e s f bill in the ordered set where esfArticleId = &#63; and esfOrderId = &#63;.
	*
	* @param esfArticleId the esf article ID
	* @param esfOrderId the esf order ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f bill, or <code>null</code> if a matching e s f bill could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ethica.esf.model.ESFBill fetchByEA_EO_First(
		long esfArticleId, long esfOrderId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByEA_EO_First(esfArticleId, esfOrderId,
			orderByComparator);
	}

	/**
	* Returns the last e s f bill in the ordered set where esfArticleId = &#63; and esfOrderId = &#63;.
	*
	* @param esfArticleId the esf article ID
	* @param esfOrderId the esf order ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f bill
	* @throws com.ethica.esf.NoSuchBillException if a matching e s f bill could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ethica.esf.model.ESFBill findByEA_EO_Last(
		long esfArticleId, long esfOrderId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ethica.esf.NoSuchBillException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByEA_EO_Last(esfArticleId, esfOrderId, orderByComparator);
	}

	/**
	* Returns the last e s f bill in the ordered set where esfArticleId = &#63; and esfOrderId = &#63;.
	*
	* @param esfArticleId the esf article ID
	* @param esfOrderId the esf order ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f bill, or <code>null</code> if a matching e s f bill could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ethica.esf.model.ESFBill fetchByEA_EO_Last(
		long esfArticleId, long esfOrderId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByEA_EO_Last(esfArticleId, esfOrderId,
			orderByComparator);
	}

	/**
	* Returns the e s f bills before and after the current e s f bill in the ordered set where esfArticleId = &#63; and esfOrderId = &#63;.
	*
	* @param esfBillId the primary key of the current e s f bill
	* @param esfArticleId the esf article ID
	* @param esfOrderId the esf order ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f bill
	* @throws com.ethica.esf.NoSuchBillException if a e s f bill with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ethica.esf.model.ESFBill[] findByEA_EO_PrevAndNext(
		long esfBillId, long esfArticleId, long esfOrderId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ethica.esf.NoSuchBillException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByEA_EO_PrevAndNext(esfBillId, esfArticleId,
			esfOrderId, orderByComparator);
	}

	/**
	* Removes all the e s f bills where esfArticleId = &#63; and esfOrderId = &#63; from the database.
	*
	* @param esfArticleId the esf article ID
	* @param esfOrderId the esf order ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByEA_EO(long esfArticleId, long esfOrderId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByEA_EO(esfArticleId, esfOrderId);
	}

	/**
	* Returns the number of e s f bills where esfArticleId = &#63; and esfOrderId = &#63;.
	*
	* @param esfArticleId the esf article ID
	* @param esfOrderId the esf order ID
	* @return the number of matching e s f bills
	* @throws SystemException if a system exception occurred
	*/
	public static int countByEA_EO(long esfArticleId, long esfOrderId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByEA_EO(esfArticleId, esfOrderId);
	}

	/**
	* Caches the e s f bill in the entity cache if it is enabled.
	*
	* @param esfBill the e s f bill
	*/
	public static void cacheResult(com.ethica.esf.model.ESFBill esfBill) {
		getPersistence().cacheResult(esfBill);
	}

	/**
	* Caches the e s f bills in the entity cache if it is enabled.
	*
	* @param esfBills the e s f bills
	*/
	public static void cacheResult(
		java.util.List<com.ethica.esf.model.ESFBill> esfBills) {
		getPersistence().cacheResult(esfBills);
	}

	/**
	* Creates a new e s f bill with the primary key. Does not add the e s f bill to the database.
	*
	* @param esfBillId the primary key for the new e s f bill
	* @return the new e s f bill
	*/
	public static com.ethica.esf.model.ESFBill create(long esfBillId) {
		return getPersistence().create(esfBillId);
	}

	/**
	* Removes the e s f bill with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfBillId the primary key of the e s f bill
	* @return the e s f bill that was removed
	* @throws com.ethica.esf.NoSuchBillException if a e s f bill with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ethica.esf.model.ESFBill remove(long esfBillId)
		throws com.ethica.esf.NoSuchBillException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(esfBillId);
	}

	public static com.ethica.esf.model.ESFBill updateImpl(
		com.ethica.esf.model.ESFBill esfBill)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(esfBill);
	}

	/**
	* Returns the e s f bill with the primary key or throws a {@link com.ethica.esf.NoSuchBillException} if it could not be found.
	*
	* @param esfBillId the primary key of the e s f bill
	* @return the e s f bill
	* @throws com.ethica.esf.NoSuchBillException if a e s f bill with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ethica.esf.model.ESFBill findByPrimaryKey(long esfBillId)
		throws com.ethica.esf.NoSuchBillException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(esfBillId);
	}

	/**
	* Returns the e s f bill with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param esfBillId the primary key of the e s f bill
	* @return the e s f bill, or <code>null</code> if a e s f bill with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ethica.esf.model.ESFBill fetchByPrimaryKey(long esfBillId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(esfBillId);
	}

	/**
	* Returns all the e s f bills.
	*
	* @return the e s f bills
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ethica.esf.model.ESFBill> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the e s f bills.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ethica.esf.model.impl.ESFBillModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f bills
	* @param end the upper bound of the range of e s f bills (not inclusive)
	* @return the range of e s f bills
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ethica.esf.model.ESFBill> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the e s f bills.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ethica.esf.model.impl.ESFBillModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f bills
	* @param end the upper bound of the range of e s f bills (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of e s f bills
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ethica.esf.model.ESFBill> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the e s f bills from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of e s f bills.
	*
	* @return the number of e s f bills
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ESFBillPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ESFBillPersistence)PortletBeanLocatorUtil.locate(com.ethica.esf.service.ClpSerializer.getServletContextName(),
					ESFBillPersistence.class.getName());

			ReferenceRegistry.registerReference(ESFBillUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ESFBillPersistence persistence) {
	}

	private static ESFBillPersistence _persistence;
}