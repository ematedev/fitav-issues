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

package it.ethica.esf.renewal.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import it.ethica.esf.renewal.model.ESFRenewalCompany;

/**
 * The persistence interface for the e s f renewal company service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFRenewalCompanyPersistenceImpl
 * @see ESFRenewalCompanyUtil
 * @generated
 */
public interface ESFRenewalCompanyPersistence extends BasePersistence<ESFRenewalCompany> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ESFRenewalCompanyUtil} to access the e s f renewal company persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the e s f renewal companies where status = &#63;.
	*
	* @param status the status
	* @return the matching e s f renewal companies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.renewal.model.ESFRenewalCompany> findByStatus(
		int status) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f renewal companies where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.renewal.model.impl.ESFRenewalCompanyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of e s f renewal companies
	* @param end the upper bound of the range of e s f renewal companies (not inclusive)
	* @return the range of matching e s f renewal companies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.renewal.model.ESFRenewalCompany> findByStatus(
		int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f renewal companies where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.renewal.model.impl.ESFRenewalCompanyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of e s f renewal companies
	* @param end the upper bound of the range of e s f renewal companies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f renewal companies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.renewal.model.ESFRenewalCompany> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f renewal company in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f renewal company
	* @throws it.ethica.esf.renewal.NoSuchESFRenewalCompanyException if a matching e s f renewal company could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.renewal.model.ESFRenewalCompany findByStatus_First(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.renewal.NoSuchESFRenewalCompanyException;

	/**
	* Returns the first e s f renewal company in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f renewal company, or <code>null</code> if a matching e s f renewal company could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.renewal.model.ESFRenewalCompany fetchByStatus_First(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f renewal company in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f renewal company
	* @throws it.ethica.esf.renewal.NoSuchESFRenewalCompanyException if a matching e s f renewal company could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.renewal.model.ESFRenewalCompany findByStatus_Last(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.renewal.NoSuchESFRenewalCompanyException;

	/**
	* Returns the last e s f renewal company in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f renewal company, or <code>null</code> if a matching e s f renewal company could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.renewal.model.ESFRenewalCompany fetchByStatus_Last(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f renewal companies before and after the current e s f renewal company in the ordered set where status = &#63;.
	*
	* @param esfRenewalCompanyId the primary key of the current e s f renewal company
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f renewal company
	* @throws it.ethica.esf.renewal.NoSuchESFRenewalCompanyException if a e s f renewal company with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.renewal.model.ESFRenewalCompany[] findByStatus_PrevAndNext(
		long esfRenewalCompanyId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.renewal.NoSuchESFRenewalCompanyException;

	/**
	* Removes all the e s f renewal companies where status = &#63; from the database.
	*
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByStatus(int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f renewal companies where status = &#63;.
	*
	* @param status the status
	* @return the number of matching e s f renewal companies
	* @throws SystemException if a system exception occurred
	*/
	public int countByStatus(int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f renewal companies where year = &#63;.
	*
	* @param year the year
	* @return the matching e s f renewal companies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.renewal.model.ESFRenewalCompany> findByYear(
		int year) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f renewal companies where year = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.renewal.model.impl.ESFRenewalCompanyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param year the year
	* @param start the lower bound of the range of e s f renewal companies
	* @param end the upper bound of the range of e s f renewal companies (not inclusive)
	* @return the range of matching e s f renewal companies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.renewal.model.ESFRenewalCompany> findByYear(
		int year, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f renewal companies where year = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.renewal.model.impl.ESFRenewalCompanyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param year the year
	* @param start the lower bound of the range of e s f renewal companies
	* @param end the upper bound of the range of e s f renewal companies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f renewal companies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.renewal.model.ESFRenewalCompany> findByYear(
		int year, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f renewal company in the ordered set where year = &#63;.
	*
	* @param year the year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f renewal company
	* @throws it.ethica.esf.renewal.NoSuchESFRenewalCompanyException if a matching e s f renewal company could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.renewal.model.ESFRenewalCompany findByYear_First(
		int year,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.renewal.NoSuchESFRenewalCompanyException;

	/**
	* Returns the first e s f renewal company in the ordered set where year = &#63;.
	*
	* @param year the year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f renewal company, or <code>null</code> if a matching e s f renewal company could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.renewal.model.ESFRenewalCompany fetchByYear_First(
		int year,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f renewal company in the ordered set where year = &#63;.
	*
	* @param year the year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f renewal company
	* @throws it.ethica.esf.renewal.NoSuchESFRenewalCompanyException if a matching e s f renewal company could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.renewal.model.ESFRenewalCompany findByYear_Last(
		int year,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.renewal.NoSuchESFRenewalCompanyException;

	/**
	* Returns the last e s f renewal company in the ordered set where year = &#63;.
	*
	* @param year the year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f renewal company, or <code>null</code> if a matching e s f renewal company could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.renewal.model.ESFRenewalCompany fetchByYear_Last(
		int year,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f renewal companies before and after the current e s f renewal company in the ordered set where year = &#63;.
	*
	* @param esfRenewalCompanyId the primary key of the current e s f renewal company
	* @param year the year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f renewal company
	* @throws it.ethica.esf.renewal.NoSuchESFRenewalCompanyException if a e s f renewal company with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.renewal.model.ESFRenewalCompany[] findByYear_PrevAndNext(
		long esfRenewalCompanyId, int year,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.renewal.NoSuchESFRenewalCompanyException;

	/**
	* Removes all the e s f renewal companies where year = &#63; from the database.
	*
	* @param year the year
	* @throws SystemException if a system exception occurred
	*/
	public void removeByYear(int year)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f renewal companies where year = &#63;.
	*
	* @param year the year
	* @return the number of matching e s f renewal companies
	* @throws SystemException if a system exception occurred
	*/
	public int countByYear(int year)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f renewal companies where paymentType = &#63;.
	*
	* @param paymentType the payment type
	* @return the matching e s f renewal companies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.renewal.model.ESFRenewalCompany> findByPaymentType(
		int paymentType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f renewal companies where paymentType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.renewal.model.impl.ESFRenewalCompanyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param paymentType the payment type
	* @param start the lower bound of the range of e s f renewal companies
	* @param end the upper bound of the range of e s f renewal companies (not inclusive)
	* @return the range of matching e s f renewal companies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.renewal.model.ESFRenewalCompany> findByPaymentType(
		int paymentType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f renewal companies where paymentType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.renewal.model.impl.ESFRenewalCompanyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param paymentType the payment type
	* @param start the lower bound of the range of e s f renewal companies
	* @param end the upper bound of the range of e s f renewal companies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f renewal companies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.renewal.model.ESFRenewalCompany> findByPaymentType(
		int paymentType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f renewal company in the ordered set where paymentType = &#63;.
	*
	* @param paymentType the payment type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f renewal company
	* @throws it.ethica.esf.renewal.NoSuchESFRenewalCompanyException if a matching e s f renewal company could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.renewal.model.ESFRenewalCompany findByPaymentType_First(
		int paymentType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.renewal.NoSuchESFRenewalCompanyException;

	/**
	* Returns the first e s f renewal company in the ordered set where paymentType = &#63;.
	*
	* @param paymentType the payment type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f renewal company, or <code>null</code> if a matching e s f renewal company could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.renewal.model.ESFRenewalCompany fetchByPaymentType_First(
		int paymentType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f renewal company in the ordered set where paymentType = &#63;.
	*
	* @param paymentType the payment type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f renewal company
	* @throws it.ethica.esf.renewal.NoSuchESFRenewalCompanyException if a matching e s f renewal company could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.renewal.model.ESFRenewalCompany findByPaymentType_Last(
		int paymentType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.renewal.NoSuchESFRenewalCompanyException;

	/**
	* Returns the last e s f renewal company in the ordered set where paymentType = &#63;.
	*
	* @param paymentType the payment type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f renewal company, or <code>null</code> if a matching e s f renewal company could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.renewal.model.ESFRenewalCompany fetchByPaymentType_Last(
		int paymentType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f renewal companies before and after the current e s f renewal company in the ordered set where paymentType = &#63;.
	*
	* @param esfRenewalCompanyId the primary key of the current e s f renewal company
	* @param paymentType the payment type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f renewal company
	* @throws it.ethica.esf.renewal.NoSuchESFRenewalCompanyException if a e s f renewal company with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.renewal.model.ESFRenewalCompany[] findByPaymentType_PrevAndNext(
		long esfRenewalCompanyId, int paymentType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.renewal.NoSuchESFRenewalCompanyException;

	/**
	* Removes all the e s f renewal companies where paymentType = &#63; from the database.
	*
	* @param paymentType the payment type
	* @throws SystemException if a system exception occurred
	*/
	public void removeByPaymentType(int paymentType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f renewal companies where paymentType = &#63;.
	*
	* @param paymentType the payment type
	* @return the number of matching e s f renewal companies
	* @throws SystemException if a system exception occurred
	*/
	public int countByPaymentType(int paymentType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f renewal companies where status = &#63; and year = &#63;.
	*
	* @param status the status
	* @param year the year
	* @return the matching e s f renewal companies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.renewal.model.ESFRenewalCompany> findByS_Y(
		int status, int year)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f renewal companies where status = &#63; and year = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.renewal.model.impl.ESFRenewalCompanyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param year the year
	* @param start the lower bound of the range of e s f renewal companies
	* @param end the upper bound of the range of e s f renewal companies (not inclusive)
	* @return the range of matching e s f renewal companies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.renewal.model.ESFRenewalCompany> findByS_Y(
		int status, int year, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f renewal companies where status = &#63; and year = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.renewal.model.impl.ESFRenewalCompanyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param year the year
	* @param start the lower bound of the range of e s f renewal companies
	* @param end the upper bound of the range of e s f renewal companies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f renewal companies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.renewal.model.ESFRenewalCompany> findByS_Y(
		int status, int year, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f renewal company in the ordered set where status = &#63; and year = &#63;.
	*
	* @param status the status
	* @param year the year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f renewal company
	* @throws it.ethica.esf.renewal.NoSuchESFRenewalCompanyException if a matching e s f renewal company could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.renewal.model.ESFRenewalCompany findByS_Y_First(
		int status, int year,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.renewal.NoSuchESFRenewalCompanyException;

	/**
	* Returns the first e s f renewal company in the ordered set where status = &#63; and year = &#63;.
	*
	* @param status the status
	* @param year the year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f renewal company, or <code>null</code> if a matching e s f renewal company could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.renewal.model.ESFRenewalCompany fetchByS_Y_First(
		int status, int year,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f renewal company in the ordered set where status = &#63; and year = &#63;.
	*
	* @param status the status
	* @param year the year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f renewal company
	* @throws it.ethica.esf.renewal.NoSuchESFRenewalCompanyException if a matching e s f renewal company could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.renewal.model.ESFRenewalCompany findByS_Y_Last(
		int status, int year,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.renewal.NoSuchESFRenewalCompanyException;

	/**
	* Returns the last e s f renewal company in the ordered set where status = &#63; and year = &#63;.
	*
	* @param status the status
	* @param year the year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f renewal company, or <code>null</code> if a matching e s f renewal company could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.renewal.model.ESFRenewalCompany fetchByS_Y_Last(
		int status, int year,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f renewal companies before and after the current e s f renewal company in the ordered set where status = &#63; and year = &#63;.
	*
	* @param esfRenewalCompanyId the primary key of the current e s f renewal company
	* @param status the status
	* @param year the year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f renewal company
	* @throws it.ethica.esf.renewal.NoSuchESFRenewalCompanyException if a e s f renewal company with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.renewal.model.ESFRenewalCompany[] findByS_Y_PrevAndNext(
		long esfRenewalCompanyId, int status, int year,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.renewal.NoSuchESFRenewalCompanyException;

	/**
	* Removes all the e s f renewal companies where status = &#63; and year = &#63; from the database.
	*
	* @param status the status
	* @param year the year
	* @throws SystemException if a system exception occurred
	*/
	public void removeByS_Y(int status, int year)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f renewal companies where status = &#63; and year = &#63;.
	*
	* @param status the status
	* @param year the year
	* @return the number of matching e s f renewal companies
	* @throws SystemException if a system exception occurred
	*/
	public int countByS_Y(int status, int year)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f renewal companies where paymentType = &#63; and year = &#63;.
	*
	* @param paymentType the payment type
	* @param year the year
	* @return the matching e s f renewal companies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.renewal.model.ESFRenewalCompany> findByP_Y(
		int paymentType, int year)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f renewal companies where paymentType = &#63; and year = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.renewal.model.impl.ESFRenewalCompanyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param paymentType the payment type
	* @param year the year
	* @param start the lower bound of the range of e s f renewal companies
	* @param end the upper bound of the range of e s f renewal companies (not inclusive)
	* @return the range of matching e s f renewal companies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.renewal.model.ESFRenewalCompany> findByP_Y(
		int paymentType, int year, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f renewal companies where paymentType = &#63; and year = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.renewal.model.impl.ESFRenewalCompanyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param paymentType the payment type
	* @param year the year
	* @param start the lower bound of the range of e s f renewal companies
	* @param end the upper bound of the range of e s f renewal companies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f renewal companies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.renewal.model.ESFRenewalCompany> findByP_Y(
		int paymentType, int year, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f renewal company in the ordered set where paymentType = &#63; and year = &#63;.
	*
	* @param paymentType the payment type
	* @param year the year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f renewal company
	* @throws it.ethica.esf.renewal.NoSuchESFRenewalCompanyException if a matching e s f renewal company could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.renewal.model.ESFRenewalCompany findByP_Y_First(
		int paymentType, int year,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.renewal.NoSuchESFRenewalCompanyException;

	/**
	* Returns the first e s f renewal company in the ordered set where paymentType = &#63; and year = &#63;.
	*
	* @param paymentType the payment type
	* @param year the year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f renewal company, or <code>null</code> if a matching e s f renewal company could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.renewal.model.ESFRenewalCompany fetchByP_Y_First(
		int paymentType, int year,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f renewal company in the ordered set where paymentType = &#63; and year = &#63;.
	*
	* @param paymentType the payment type
	* @param year the year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f renewal company
	* @throws it.ethica.esf.renewal.NoSuchESFRenewalCompanyException if a matching e s f renewal company could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.renewal.model.ESFRenewalCompany findByP_Y_Last(
		int paymentType, int year,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.renewal.NoSuchESFRenewalCompanyException;

	/**
	* Returns the last e s f renewal company in the ordered set where paymentType = &#63; and year = &#63;.
	*
	* @param paymentType the payment type
	* @param year the year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f renewal company, or <code>null</code> if a matching e s f renewal company could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.renewal.model.ESFRenewalCompany fetchByP_Y_Last(
		int paymentType, int year,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f renewal companies before and after the current e s f renewal company in the ordered set where paymentType = &#63; and year = &#63;.
	*
	* @param esfRenewalCompanyId the primary key of the current e s f renewal company
	* @param paymentType the payment type
	* @param year the year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f renewal company
	* @throws it.ethica.esf.renewal.NoSuchESFRenewalCompanyException if a e s f renewal company with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.renewal.model.ESFRenewalCompany[] findByP_Y_PrevAndNext(
		long esfRenewalCompanyId, int paymentType, int year,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.renewal.NoSuchESFRenewalCompanyException;

	/**
	* Removes all the e s f renewal companies where paymentType = &#63; and year = &#63; from the database.
	*
	* @param paymentType the payment type
	* @param year the year
	* @throws SystemException if a system exception occurred
	*/
	public void removeByP_Y(int paymentType, int year)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f renewal companies where paymentType = &#63; and year = &#63;.
	*
	* @param paymentType the payment type
	* @param year the year
	* @return the number of matching e s f renewal companies
	* @throws SystemException if a system exception occurred
	*/
	public int countByP_Y(int paymentType, int year)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f renewal companies where paymentType = &#63; and status = &#63;.
	*
	* @param paymentType the payment type
	* @param status the status
	* @return the matching e s f renewal companies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.renewal.model.ESFRenewalCompany> findByP_S(
		int paymentType, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f renewal companies where paymentType = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.renewal.model.impl.ESFRenewalCompanyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param paymentType the payment type
	* @param status the status
	* @param start the lower bound of the range of e s f renewal companies
	* @param end the upper bound of the range of e s f renewal companies (not inclusive)
	* @return the range of matching e s f renewal companies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.renewal.model.ESFRenewalCompany> findByP_S(
		int paymentType, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f renewal companies where paymentType = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.renewal.model.impl.ESFRenewalCompanyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param paymentType the payment type
	* @param status the status
	* @param start the lower bound of the range of e s f renewal companies
	* @param end the upper bound of the range of e s f renewal companies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f renewal companies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.renewal.model.ESFRenewalCompany> findByP_S(
		int paymentType, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f renewal company in the ordered set where paymentType = &#63; and status = &#63;.
	*
	* @param paymentType the payment type
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f renewal company
	* @throws it.ethica.esf.renewal.NoSuchESFRenewalCompanyException if a matching e s f renewal company could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.renewal.model.ESFRenewalCompany findByP_S_First(
		int paymentType, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.renewal.NoSuchESFRenewalCompanyException;

	/**
	* Returns the first e s f renewal company in the ordered set where paymentType = &#63; and status = &#63;.
	*
	* @param paymentType the payment type
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f renewal company, or <code>null</code> if a matching e s f renewal company could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.renewal.model.ESFRenewalCompany fetchByP_S_First(
		int paymentType, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f renewal company in the ordered set where paymentType = &#63; and status = &#63;.
	*
	* @param paymentType the payment type
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f renewal company
	* @throws it.ethica.esf.renewal.NoSuchESFRenewalCompanyException if a matching e s f renewal company could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.renewal.model.ESFRenewalCompany findByP_S_Last(
		int paymentType, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.renewal.NoSuchESFRenewalCompanyException;

	/**
	* Returns the last e s f renewal company in the ordered set where paymentType = &#63; and status = &#63;.
	*
	* @param paymentType the payment type
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f renewal company, or <code>null</code> if a matching e s f renewal company could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.renewal.model.ESFRenewalCompany fetchByP_S_Last(
		int paymentType, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f renewal companies before and after the current e s f renewal company in the ordered set where paymentType = &#63; and status = &#63;.
	*
	* @param esfRenewalCompanyId the primary key of the current e s f renewal company
	* @param paymentType the payment type
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f renewal company
	* @throws it.ethica.esf.renewal.NoSuchESFRenewalCompanyException if a e s f renewal company with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.renewal.model.ESFRenewalCompany[] findByP_S_PrevAndNext(
		long esfRenewalCompanyId, int paymentType, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.renewal.NoSuchESFRenewalCompanyException;

	/**
	* Removes all the e s f renewal companies where paymentType = &#63; and status = &#63; from the database.
	*
	* @param paymentType the payment type
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByP_S(int paymentType, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f renewal companies where paymentType = &#63; and status = &#63;.
	*
	* @param paymentType the payment type
	* @param status the status
	* @return the number of matching e s f renewal companies
	* @throws SystemException if a system exception occurred
	*/
	public int countByP_S(int paymentType, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f renewal company where esfOrganizationId = &#63; and year = &#63; or throws a {@link it.ethica.esf.renewal.NoSuchESFRenewalCompanyException} if it could not be found.
	*
	* @param esfOrganizationId the esf organization ID
	* @param year the year
	* @return the matching e s f renewal company
	* @throws it.ethica.esf.renewal.NoSuchESFRenewalCompanyException if a matching e s f renewal company could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.renewal.model.ESFRenewalCompany findByE_Y(
		long esfOrganizationId, int year)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.renewal.NoSuchESFRenewalCompanyException;

	/**
	* Returns the e s f renewal company where esfOrganizationId = &#63; and year = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param esfOrganizationId the esf organization ID
	* @param year the year
	* @return the matching e s f renewal company, or <code>null</code> if a matching e s f renewal company could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.renewal.model.ESFRenewalCompany fetchByE_Y(
		long esfOrganizationId, int year)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f renewal company where esfOrganizationId = &#63; and year = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param esfOrganizationId the esf organization ID
	* @param year the year
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching e s f renewal company, or <code>null</code> if a matching e s f renewal company could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.renewal.model.ESFRenewalCompany fetchByE_Y(
		long esfOrganizationId, int year, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the e s f renewal company where esfOrganizationId = &#63; and year = &#63; from the database.
	*
	* @param esfOrganizationId the esf organization ID
	* @param year the year
	* @return the e s f renewal company that was removed
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.renewal.model.ESFRenewalCompany removeByE_Y(
		long esfOrganizationId, int year)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.renewal.NoSuchESFRenewalCompanyException;

	/**
	* Returns the number of e s f renewal companies where esfOrganizationId = &#63; and year = &#63;.
	*
	* @param esfOrganizationId the esf organization ID
	* @param year the year
	* @return the number of matching e s f renewal companies
	* @throws SystemException if a system exception occurred
	*/
	public int countByE_Y(long esfOrganizationId, int year)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the e s f renewal company in the entity cache if it is enabled.
	*
	* @param esfRenewalCompany the e s f renewal company
	*/
	public void cacheResult(
		it.ethica.esf.renewal.model.ESFRenewalCompany esfRenewalCompany);

	/**
	* Caches the e s f renewal companies in the entity cache if it is enabled.
	*
	* @param esfRenewalCompanies the e s f renewal companies
	*/
	public void cacheResult(
		java.util.List<it.ethica.esf.renewal.model.ESFRenewalCompany> esfRenewalCompanies);

	/**
	* Creates a new e s f renewal company with the primary key. Does not add the e s f renewal company to the database.
	*
	* @param esfRenewalCompanyId the primary key for the new e s f renewal company
	* @return the new e s f renewal company
	*/
	public it.ethica.esf.renewal.model.ESFRenewalCompany create(
		long esfRenewalCompanyId);

	/**
	* Removes the e s f renewal company with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfRenewalCompanyId the primary key of the e s f renewal company
	* @return the e s f renewal company that was removed
	* @throws it.ethica.esf.renewal.NoSuchESFRenewalCompanyException if a e s f renewal company with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.renewal.model.ESFRenewalCompany remove(
		long esfRenewalCompanyId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.renewal.NoSuchESFRenewalCompanyException;

	public it.ethica.esf.renewal.model.ESFRenewalCompany updateImpl(
		it.ethica.esf.renewal.model.ESFRenewalCompany esfRenewalCompany)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f renewal company with the primary key or throws a {@link it.ethica.esf.renewal.NoSuchESFRenewalCompanyException} if it could not be found.
	*
	* @param esfRenewalCompanyId the primary key of the e s f renewal company
	* @return the e s f renewal company
	* @throws it.ethica.esf.renewal.NoSuchESFRenewalCompanyException if a e s f renewal company with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.renewal.model.ESFRenewalCompany findByPrimaryKey(
		long esfRenewalCompanyId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.renewal.NoSuchESFRenewalCompanyException;

	/**
	* Returns the e s f renewal company with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param esfRenewalCompanyId the primary key of the e s f renewal company
	* @return the e s f renewal company, or <code>null</code> if a e s f renewal company with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.renewal.model.ESFRenewalCompany fetchByPrimaryKey(
		long esfRenewalCompanyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f renewal companies.
	*
	* @return the e s f renewal companies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.renewal.model.ESFRenewalCompany> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f renewal companies.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.renewal.model.impl.ESFRenewalCompanyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f renewal companies
	* @param end the upper bound of the range of e s f renewal companies (not inclusive)
	* @return the range of e s f renewal companies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.renewal.model.ESFRenewalCompany> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f renewal companies.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.renewal.model.impl.ESFRenewalCompanyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f renewal companies
	* @param end the upper bound of the range of e s f renewal companies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of e s f renewal companies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.renewal.model.ESFRenewalCompany> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the e s f renewal companies from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f renewal companies.
	*
	* @return the number of e s f renewal companies
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}