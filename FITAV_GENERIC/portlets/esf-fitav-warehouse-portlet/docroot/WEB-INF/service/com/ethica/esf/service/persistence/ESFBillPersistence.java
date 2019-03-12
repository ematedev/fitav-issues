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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the e s f bill service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFBillPersistenceImpl
 * @see ESFBillUtil
 * @generated
 */
public interface ESFBillPersistence extends BasePersistence<ESFBill> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ESFBillUtil} to access the e s f bill persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the e s f bills where esfArticleId = &#63; and esfOrderId = &#63;.
	*
	* @param esfArticleId the esf article ID
	* @param esfOrderId the esf order ID
	* @return the matching e s f bills
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ethica.esf.model.ESFBill> findByEA_EO(
		long esfArticleId, long esfOrderId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.ethica.esf.model.ESFBill> findByEA_EO(
		long esfArticleId, long esfOrderId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.ethica.esf.model.ESFBill> findByEA_EO(
		long esfArticleId, long esfOrderId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.ethica.esf.model.ESFBill findByEA_EO_First(long esfArticleId,
		long esfOrderId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ethica.esf.NoSuchBillException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f bill in the ordered set where esfArticleId = &#63; and esfOrderId = &#63;.
	*
	* @param esfArticleId the esf article ID
	* @param esfOrderId the esf order ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f bill, or <code>null</code> if a matching e s f bill could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ethica.esf.model.ESFBill fetchByEA_EO_First(long esfArticleId,
		long esfOrderId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.ethica.esf.model.ESFBill findByEA_EO_Last(long esfArticleId,
		long esfOrderId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ethica.esf.NoSuchBillException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f bill in the ordered set where esfArticleId = &#63; and esfOrderId = &#63;.
	*
	* @param esfArticleId the esf article ID
	* @param esfOrderId the esf order ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f bill, or <code>null</code> if a matching e s f bill could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ethica.esf.model.ESFBill fetchByEA_EO_Last(long esfArticleId,
		long esfOrderId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.ethica.esf.model.ESFBill[] findByEA_EO_PrevAndNext(
		long esfBillId, long esfArticleId, long esfOrderId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ethica.esf.NoSuchBillException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the e s f bills where esfArticleId = &#63; and esfOrderId = &#63; from the database.
	*
	* @param esfArticleId the esf article ID
	* @param esfOrderId the esf order ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByEA_EO(long esfArticleId, long esfOrderId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f bills where esfArticleId = &#63; and esfOrderId = &#63;.
	*
	* @param esfArticleId the esf article ID
	* @param esfOrderId the esf order ID
	* @return the number of matching e s f bills
	* @throws SystemException if a system exception occurred
	*/
	public int countByEA_EO(long esfArticleId, long esfOrderId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the e s f bill in the entity cache if it is enabled.
	*
	* @param esfBill the e s f bill
	*/
	public void cacheResult(com.ethica.esf.model.ESFBill esfBill);

	/**
	* Caches the e s f bills in the entity cache if it is enabled.
	*
	* @param esfBills the e s f bills
	*/
	public void cacheResult(
		java.util.List<com.ethica.esf.model.ESFBill> esfBills);

	/**
	* Creates a new e s f bill with the primary key. Does not add the e s f bill to the database.
	*
	* @param esfBillId the primary key for the new e s f bill
	* @return the new e s f bill
	*/
	public com.ethica.esf.model.ESFBill create(long esfBillId);

	/**
	* Removes the e s f bill with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfBillId the primary key of the e s f bill
	* @return the e s f bill that was removed
	* @throws com.ethica.esf.NoSuchBillException if a e s f bill with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ethica.esf.model.ESFBill remove(long esfBillId)
		throws com.ethica.esf.NoSuchBillException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.ethica.esf.model.ESFBill updateImpl(
		com.ethica.esf.model.ESFBill esfBill)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f bill with the primary key or throws a {@link com.ethica.esf.NoSuchBillException} if it could not be found.
	*
	* @param esfBillId the primary key of the e s f bill
	* @return the e s f bill
	* @throws com.ethica.esf.NoSuchBillException if a e s f bill with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ethica.esf.model.ESFBill findByPrimaryKey(long esfBillId)
		throws com.ethica.esf.NoSuchBillException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f bill with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param esfBillId the primary key of the e s f bill
	* @return the e s f bill, or <code>null</code> if a e s f bill with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ethica.esf.model.ESFBill fetchByPrimaryKey(long esfBillId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f bills.
	*
	* @return the e s f bills
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ethica.esf.model.ESFBill> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.ethica.esf.model.ESFBill> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.ethica.esf.model.ESFBill> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the e s f bills from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f bills.
	*
	* @return the number of e s f bills
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}