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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import it.ethica.esf.renewal.model.ESFRenewalCompany;

import java.util.List;

/**
 * The persistence utility for the e s f renewal company service. This utility wraps {@link ESFRenewalCompanyPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFRenewalCompanyPersistence
 * @see ESFRenewalCompanyPersistenceImpl
 * @generated
 */
public class ESFRenewalCompanyUtil {
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
	public static void clearCache(ESFRenewalCompany esfRenewalCompany) {
		getPersistence().clearCache(esfRenewalCompany);
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
	public static List<ESFRenewalCompany> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ESFRenewalCompany> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ESFRenewalCompany> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ESFRenewalCompany update(ESFRenewalCompany esfRenewalCompany)
		throws SystemException {
		return getPersistence().update(esfRenewalCompany);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ESFRenewalCompany update(
		ESFRenewalCompany esfRenewalCompany, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(esfRenewalCompany, serviceContext);
	}

	/**
	* Returns all the e s f renewal companies where status = &#63;.
	*
	* @param status the status
	* @return the matching e s f renewal companies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.renewal.model.ESFRenewalCompany> findByStatus(
		int status) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStatus(status);
	}

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
	public static java.util.List<it.ethica.esf.renewal.model.ESFRenewalCompany> findByStatus(
		int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStatus(status, start, end);
	}

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
	public static java.util.List<it.ethica.esf.renewal.model.ESFRenewalCompany> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStatus(status, start, end, orderByComparator);
	}

	/**
	* Returns the first e s f renewal company in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f renewal company
	* @throws it.ethica.esf.renewal.NoSuchESFRenewalCompanyException if a matching e s f renewal company could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.renewal.model.ESFRenewalCompany findByStatus_First(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.renewal.NoSuchESFRenewalCompanyException {
		return getPersistence().findByStatus_First(status, orderByComparator);
	}

	/**
	* Returns the first e s f renewal company in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f renewal company, or <code>null</code> if a matching e s f renewal company could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.renewal.model.ESFRenewalCompany fetchByStatus_First(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByStatus_First(status, orderByComparator);
	}

	/**
	* Returns the last e s f renewal company in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f renewal company
	* @throws it.ethica.esf.renewal.NoSuchESFRenewalCompanyException if a matching e s f renewal company could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.renewal.model.ESFRenewalCompany findByStatus_Last(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.renewal.NoSuchESFRenewalCompanyException {
		return getPersistence().findByStatus_Last(status, orderByComparator);
	}

	/**
	* Returns the last e s f renewal company in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f renewal company, or <code>null</code> if a matching e s f renewal company could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.renewal.model.ESFRenewalCompany fetchByStatus_Last(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByStatus_Last(status, orderByComparator);
	}

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
	public static it.ethica.esf.renewal.model.ESFRenewalCompany[] findByStatus_PrevAndNext(
		long esfRenewalCompanyId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.renewal.NoSuchESFRenewalCompanyException {
		return getPersistence()
				   .findByStatus_PrevAndNext(esfRenewalCompanyId, status,
			orderByComparator);
	}

	/**
	* Removes all the e s f renewal companies where status = &#63; from the database.
	*
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByStatus(int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByStatus(status);
	}

	/**
	* Returns the number of e s f renewal companies where status = &#63;.
	*
	* @param status the status
	* @return the number of matching e s f renewal companies
	* @throws SystemException if a system exception occurred
	*/
	public static int countByStatus(int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByStatus(status);
	}

	/**
	* Returns all the e s f renewal companies where year = &#63;.
	*
	* @param year the year
	* @return the matching e s f renewal companies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.renewal.model.ESFRenewalCompany> findByYear(
		int year) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByYear(year);
	}

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
	public static java.util.List<it.ethica.esf.renewal.model.ESFRenewalCompany> findByYear(
		int year, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByYear(year, start, end);
	}

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
	public static java.util.List<it.ethica.esf.renewal.model.ESFRenewalCompany> findByYear(
		int year, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByYear(year, start, end, orderByComparator);
	}

	/**
	* Returns the first e s f renewal company in the ordered set where year = &#63;.
	*
	* @param year the year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f renewal company
	* @throws it.ethica.esf.renewal.NoSuchESFRenewalCompanyException if a matching e s f renewal company could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.renewal.model.ESFRenewalCompany findByYear_First(
		int year,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.renewal.NoSuchESFRenewalCompanyException {
		return getPersistence().findByYear_First(year, orderByComparator);
	}

	/**
	* Returns the first e s f renewal company in the ordered set where year = &#63;.
	*
	* @param year the year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f renewal company, or <code>null</code> if a matching e s f renewal company could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.renewal.model.ESFRenewalCompany fetchByYear_First(
		int year,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByYear_First(year, orderByComparator);
	}

	/**
	* Returns the last e s f renewal company in the ordered set where year = &#63;.
	*
	* @param year the year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f renewal company
	* @throws it.ethica.esf.renewal.NoSuchESFRenewalCompanyException if a matching e s f renewal company could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.renewal.model.ESFRenewalCompany findByYear_Last(
		int year,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.renewal.NoSuchESFRenewalCompanyException {
		return getPersistence().findByYear_Last(year, orderByComparator);
	}

	/**
	* Returns the last e s f renewal company in the ordered set where year = &#63;.
	*
	* @param year the year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f renewal company, or <code>null</code> if a matching e s f renewal company could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.renewal.model.ESFRenewalCompany fetchByYear_Last(
		int year,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByYear_Last(year, orderByComparator);
	}

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
	public static it.ethica.esf.renewal.model.ESFRenewalCompany[] findByYear_PrevAndNext(
		long esfRenewalCompanyId, int year,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.renewal.NoSuchESFRenewalCompanyException {
		return getPersistence()
				   .findByYear_PrevAndNext(esfRenewalCompanyId, year,
			orderByComparator);
	}

	/**
	* Removes all the e s f renewal companies where year = &#63; from the database.
	*
	* @param year the year
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByYear(int year)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByYear(year);
	}

	/**
	* Returns the number of e s f renewal companies where year = &#63;.
	*
	* @param year the year
	* @return the number of matching e s f renewal companies
	* @throws SystemException if a system exception occurred
	*/
	public static int countByYear(int year)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByYear(year);
	}

	/**
	* Returns all the e s f renewal companies where paymentType = &#63;.
	*
	* @param paymentType the payment type
	* @return the matching e s f renewal companies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.renewal.model.ESFRenewalCompany> findByPaymentType(
		int paymentType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPaymentType(paymentType);
	}

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
	public static java.util.List<it.ethica.esf.renewal.model.ESFRenewalCompany> findByPaymentType(
		int paymentType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPaymentType(paymentType, start, end);
	}

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
	public static java.util.List<it.ethica.esf.renewal.model.ESFRenewalCompany> findByPaymentType(
		int paymentType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPaymentType(paymentType, start, end, orderByComparator);
	}

	/**
	* Returns the first e s f renewal company in the ordered set where paymentType = &#63;.
	*
	* @param paymentType the payment type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f renewal company
	* @throws it.ethica.esf.renewal.NoSuchESFRenewalCompanyException if a matching e s f renewal company could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.renewal.model.ESFRenewalCompany findByPaymentType_First(
		int paymentType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.renewal.NoSuchESFRenewalCompanyException {
		return getPersistence()
				   .findByPaymentType_First(paymentType, orderByComparator);
	}

	/**
	* Returns the first e s f renewal company in the ordered set where paymentType = &#63;.
	*
	* @param paymentType the payment type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f renewal company, or <code>null</code> if a matching e s f renewal company could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.renewal.model.ESFRenewalCompany fetchByPaymentType_First(
		int paymentType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPaymentType_First(paymentType, orderByComparator);
	}

	/**
	* Returns the last e s f renewal company in the ordered set where paymentType = &#63;.
	*
	* @param paymentType the payment type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f renewal company
	* @throws it.ethica.esf.renewal.NoSuchESFRenewalCompanyException if a matching e s f renewal company could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.renewal.model.ESFRenewalCompany findByPaymentType_Last(
		int paymentType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.renewal.NoSuchESFRenewalCompanyException {
		return getPersistence()
				   .findByPaymentType_Last(paymentType, orderByComparator);
	}

	/**
	* Returns the last e s f renewal company in the ordered set where paymentType = &#63;.
	*
	* @param paymentType the payment type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f renewal company, or <code>null</code> if a matching e s f renewal company could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.renewal.model.ESFRenewalCompany fetchByPaymentType_Last(
		int paymentType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPaymentType_Last(paymentType, orderByComparator);
	}

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
	public static it.ethica.esf.renewal.model.ESFRenewalCompany[] findByPaymentType_PrevAndNext(
		long esfRenewalCompanyId, int paymentType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.renewal.NoSuchESFRenewalCompanyException {
		return getPersistence()
				   .findByPaymentType_PrevAndNext(esfRenewalCompanyId,
			paymentType, orderByComparator);
	}

	/**
	* Removes all the e s f renewal companies where paymentType = &#63; from the database.
	*
	* @param paymentType the payment type
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByPaymentType(int paymentType)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByPaymentType(paymentType);
	}

	/**
	* Returns the number of e s f renewal companies where paymentType = &#63;.
	*
	* @param paymentType the payment type
	* @return the number of matching e s f renewal companies
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPaymentType(int paymentType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByPaymentType(paymentType);
	}

	/**
	* Returns all the e s f renewal companies where status = &#63; and year = &#63;.
	*
	* @param status the status
	* @param year the year
	* @return the matching e s f renewal companies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.renewal.model.ESFRenewalCompany> findByS_Y(
		int status, int year)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByS_Y(status, year);
	}

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
	public static java.util.List<it.ethica.esf.renewal.model.ESFRenewalCompany> findByS_Y(
		int status, int year, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByS_Y(status, year, start, end);
	}

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
	public static java.util.List<it.ethica.esf.renewal.model.ESFRenewalCompany> findByS_Y(
		int status, int year, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByS_Y(status, year, start, end, orderByComparator);
	}

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
	public static it.ethica.esf.renewal.model.ESFRenewalCompany findByS_Y_First(
		int status, int year,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.renewal.NoSuchESFRenewalCompanyException {
		return getPersistence().findByS_Y_First(status, year, orderByComparator);
	}

	/**
	* Returns the first e s f renewal company in the ordered set where status = &#63; and year = &#63;.
	*
	* @param status the status
	* @param year the year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f renewal company, or <code>null</code> if a matching e s f renewal company could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.renewal.model.ESFRenewalCompany fetchByS_Y_First(
		int status, int year,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByS_Y_First(status, year, orderByComparator);
	}

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
	public static it.ethica.esf.renewal.model.ESFRenewalCompany findByS_Y_Last(
		int status, int year,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.renewal.NoSuchESFRenewalCompanyException {
		return getPersistence().findByS_Y_Last(status, year, orderByComparator);
	}

	/**
	* Returns the last e s f renewal company in the ordered set where status = &#63; and year = &#63;.
	*
	* @param status the status
	* @param year the year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f renewal company, or <code>null</code> if a matching e s f renewal company could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.renewal.model.ESFRenewalCompany fetchByS_Y_Last(
		int status, int year,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByS_Y_Last(status, year, orderByComparator);
	}

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
	public static it.ethica.esf.renewal.model.ESFRenewalCompany[] findByS_Y_PrevAndNext(
		long esfRenewalCompanyId, int status, int year,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.renewal.NoSuchESFRenewalCompanyException {
		return getPersistence()
				   .findByS_Y_PrevAndNext(esfRenewalCompanyId, status, year,
			orderByComparator);
	}

	/**
	* Removes all the e s f renewal companies where status = &#63; and year = &#63; from the database.
	*
	* @param status the status
	* @param year the year
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByS_Y(int status, int year)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByS_Y(status, year);
	}

	/**
	* Returns the number of e s f renewal companies where status = &#63; and year = &#63;.
	*
	* @param status the status
	* @param year the year
	* @return the number of matching e s f renewal companies
	* @throws SystemException if a system exception occurred
	*/
	public static int countByS_Y(int status, int year)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByS_Y(status, year);
	}

	/**
	* Returns all the e s f renewal companies where paymentType = &#63; and year = &#63;.
	*
	* @param paymentType the payment type
	* @param year the year
	* @return the matching e s f renewal companies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.renewal.model.ESFRenewalCompany> findByP_Y(
		int paymentType, int year)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByP_Y(paymentType, year);
	}

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
	public static java.util.List<it.ethica.esf.renewal.model.ESFRenewalCompany> findByP_Y(
		int paymentType, int year, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByP_Y(paymentType, year, start, end);
	}

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
	public static java.util.List<it.ethica.esf.renewal.model.ESFRenewalCompany> findByP_Y(
		int paymentType, int year, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByP_Y(paymentType, year, start, end, orderByComparator);
	}

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
	public static it.ethica.esf.renewal.model.ESFRenewalCompany findByP_Y_First(
		int paymentType, int year,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.renewal.NoSuchESFRenewalCompanyException {
		return getPersistence()
				   .findByP_Y_First(paymentType, year, orderByComparator);
	}

	/**
	* Returns the first e s f renewal company in the ordered set where paymentType = &#63; and year = &#63;.
	*
	* @param paymentType the payment type
	* @param year the year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f renewal company, or <code>null</code> if a matching e s f renewal company could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.renewal.model.ESFRenewalCompany fetchByP_Y_First(
		int paymentType, int year,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByP_Y_First(paymentType, year, orderByComparator);
	}

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
	public static it.ethica.esf.renewal.model.ESFRenewalCompany findByP_Y_Last(
		int paymentType, int year,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.renewal.NoSuchESFRenewalCompanyException {
		return getPersistence()
				   .findByP_Y_Last(paymentType, year, orderByComparator);
	}

	/**
	* Returns the last e s f renewal company in the ordered set where paymentType = &#63; and year = &#63;.
	*
	* @param paymentType the payment type
	* @param year the year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f renewal company, or <code>null</code> if a matching e s f renewal company could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.renewal.model.ESFRenewalCompany fetchByP_Y_Last(
		int paymentType, int year,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByP_Y_Last(paymentType, year, orderByComparator);
	}

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
	public static it.ethica.esf.renewal.model.ESFRenewalCompany[] findByP_Y_PrevAndNext(
		long esfRenewalCompanyId, int paymentType, int year,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.renewal.NoSuchESFRenewalCompanyException {
		return getPersistence()
				   .findByP_Y_PrevAndNext(esfRenewalCompanyId, paymentType,
			year, orderByComparator);
	}

	/**
	* Removes all the e s f renewal companies where paymentType = &#63; and year = &#63; from the database.
	*
	* @param paymentType the payment type
	* @param year the year
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByP_Y(int paymentType, int year)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByP_Y(paymentType, year);
	}

	/**
	* Returns the number of e s f renewal companies where paymentType = &#63; and year = &#63;.
	*
	* @param paymentType the payment type
	* @param year the year
	* @return the number of matching e s f renewal companies
	* @throws SystemException if a system exception occurred
	*/
	public static int countByP_Y(int paymentType, int year)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByP_Y(paymentType, year);
	}

	/**
	* Returns all the e s f renewal companies where paymentType = &#63; and status = &#63;.
	*
	* @param paymentType the payment type
	* @param status the status
	* @return the matching e s f renewal companies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.renewal.model.ESFRenewalCompany> findByP_S(
		int paymentType, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByP_S(paymentType, status);
	}

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
	public static java.util.List<it.ethica.esf.renewal.model.ESFRenewalCompany> findByP_S(
		int paymentType, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByP_S(paymentType, status, start, end);
	}

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
	public static java.util.List<it.ethica.esf.renewal.model.ESFRenewalCompany> findByP_S(
		int paymentType, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByP_S(paymentType, status, start, end, orderByComparator);
	}

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
	public static it.ethica.esf.renewal.model.ESFRenewalCompany findByP_S_First(
		int paymentType, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.renewal.NoSuchESFRenewalCompanyException {
		return getPersistence()
				   .findByP_S_First(paymentType, status, orderByComparator);
	}

	/**
	* Returns the first e s f renewal company in the ordered set where paymentType = &#63; and status = &#63;.
	*
	* @param paymentType the payment type
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f renewal company, or <code>null</code> if a matching e s f renewal company could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.renewal.model.ESFRenewalCompany fetchByP_S_First(
		int paymentType, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByP_S_First(paymentType, status, orderByComparator);
	}

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
	public static it.ethica.esf.renewal.model.ESFRenewalCompany findByP_S_Last(
		int paymentType, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.renewal.NoSuchESFRenewalCompanyException {
		return getPersistence()
				   .findByP_S_Last(paymentType, status, orderByComparator);
	}

	/**
	* Returns the last e s f renewal company in the ordered set where paymentType = &#63; and status = &#63;.
	*
	* @param paymentType the payment type
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f renewal company, or <code>null</code> if a matching e s f renewal company could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.renewal.model.ESFRenewalCompany fetchByP_S_Last(
		int paymentType, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByP_S_Last(paymentType, status, orderByComparator);
	}

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
	public static it.ethica.esf.renewal.model.ESFRenewalCompany[] findByP_S_PrevAndNext(
		long esfRenewalCompanyId, int paymentType, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.renewal.NoSuchESFRenewalCompanyException {
		return getPersistence()
				   .findByP_S_PrevAndNext(esfRenewalCompanyId, paymentType,
			status, orderByComparator);
	}

	/**
	* Removes all the e s f renewal companies where paymentType = &#63; and status = &#63; from the database.
	*
	* @param paymentType the payment type
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByP_S(int paymentType, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByP_S(paymentType, status);
	}

	/**
	* Returns the number of e s f renewal companies where paymentType = &#63; and status = &#63;.
	*
	* @param paymentType the payment type
	* @param status the status
	* @return the number of matching e s f renewal companies
	* @throws SystemException if a system exception occurred
	*/
	public static int countByP_S(int paymentType, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByP_S(paymentType, status);
	}

	/**
	* Returns the e s f renewal company where esfOrganizationId = &#63; and year = &#63; or throws a {@link it.ethica.esf.renewal.NoSuchESFRenewalCompanyException} if it could not be found.
	*
	* @param esfOrganizationId the esf organization ID
	* @param year the year
	* @return the matching e s f renewal company
	* @throws it.ethica.esf.renewal.NoSuchESFRenewalCompanyException if a matching e s f renewal company could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.renewal.model.ESFRenewalCompany findByE_Y(
		long esfOrganizationId, int year)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.renewal.NoSuchESFRenewalCompanyException {
		return getPersistence().findByE_Y(esfOrganizationId, year);
	}

	/**
	* Returns the e s f renewal company where esfOrganizationId = &#63; and year = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param esfOrganizationId the esf organization ID
	* @param year the year
	* @return the matching e s f renewal company, or <code>null</code> if a matching e s f renewal company could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.renewal.model.ESFRenewalCompany fetchByE_Y(
		long esfOrganizationId, int year)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByE_Y(esfOrganizationId, year);
	}

	/**
	* Returns the e s f renewal company where esfOrganizationId = &#63; and year = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param esfOrganizationId the esf organization ID
	* @param year the year
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching e s f renewal company, or <code>null</code> if a matching e s f renewal company could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.renewal.model.ESFRenewalCompany fetchByE_Y(
		long esfOrganizationId, int year, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByE_Y(esfOrganizationId, year, retrieveFromCache);
	}

	/**
	* Removes the e s f renewal company where esfOrganizationId = &#63; and year = &#63; from the database.
	*
	* @param esfOrganizationId the esf organization ID
	* @param year the year
	* @return the e s f renewal company that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.renewal.model.ESFRenewalCompany removeByE_Y(
		long esfOrganizationId, int year)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.renewal.NoSuchESFRenewalCompanyException {
		return getPersistence().removeByE_Y(esfOrganizationId, year);
	}

	/**
	* Returns the number of e s f renewal companies where esfOrganizationId = &#63; and year = &#63;.
	*
	* @param esfOrganizationId the esf organization ID
	* @param year the year
	* @return the number of matching e s f renewal companies
	* @throws SystemException if a system exception occurred
	*/
	public static int countByE_Y(long esfOrganizationId, int year)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByE_Y(esfOrganizationId, year);
	}

	/**
	* Caches the e s f renewal company in the entity cache if it is enabled.
	*
	* @param esfRenewalCompany the e s f renewal company
	*/
	public static void cacheResult(
		it.ethica.esf.renewal.model.ESFRenewalCompany esfRenewalCompany) {
		getPersistence().cacheResult(esfRenewalCompany);
	}

	/**
	* Caches the e s f renewal companies in the entity cache if it is enabled.
	*
	* @param esfRenewalCompanies the e s f renewal companies
	*/
	public static void cacheResult(
		java.util.List<it.ethica.esf.renewal.model.ESFRenewalCompany> esfRenewalCompanies) {
		getPersistence().cacheResult(esfRenewalCompanies);
	}

	/**
	* Creates a new e s f renewal company with the primary key. Does not add the e s f renewal company to the database.
	*
	* @param esfRenewalCompanyId the primary key for the new e s f renewal company
	* @return the new e s f renewal company
	*/
	public static it.ethica.esf.renewal.model.ESFRenewalCompany create(
		long esfRenewalCompanyId) {
		return getPersistence().create(esfRenewalCompanyId);
	}

	/**
	* Removes the e s f renewal company with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfRenewalCompanyId the primary key of the e s f renewal company
	* @return the e s f renewal company that was removed
	* @throws it.ethica.esf.renewal.NoSuchESFRenewalCompanyException if a e s f renewal company with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.renewal.model.ESFRenewalCompany remove(
		long esfRenewalCompanyId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.renewal.NoSuchESFRenewalCompanyException {
		return getPersistence().remove(esfRenewalCompanyId);
	}

	public static it.ethica.esf.renewal.model.ESFRenewalCompany updateImpl(
		it.ethica.esf.renewal.model.ESFRenewalCompany esfRenewalCompany)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(esfRenewalCompany);
	}

	/**
	* Returns the e s f renewal company with the primary key or throws a {@link it.ethica.esf.renewal.NoSuchESFRenewalCompanyException} if it could not be found.
	*
	* @param esfRenewalCompanyId the primary key of the e s f renewal company
	* @return the e s f renewal company
	* @throws it.ethica.esf.renewal.NoSuchESFRenewalCompanyException if a e s f renewal company with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.renewal.model.ESFRenewalCompany findByPrimaryKey(
		long esfRenewalCompanyId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.renewal.NoSuchESFRenewalCompanyException {
		return getPersistence().findByPrimaryKey(esfRenewalCompanyId);
	}

	/**
	* Returns the e s f renewal company with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param esfRenewalCompanyId the primary key of the e s f renewal company
	* @return the e s f renewal company, or <code>null</code> if a e s f renewal company with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.renewal.model.ESFRenewalCompany fetchByPrimaryKey(
		long esfRenewalCompanyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(esfRenewalCompanyId);
	}

	/**
	* Returns all the e s f renewal companies.
	*
	* @return the e s f renewal companies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.renewal.model.ESFRenewalCompany> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<it.ethica.esf.renewal.model.ESFRenewalCompany> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<it.ethica.esf.renewal.model.ESFRenewalCompany> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the e s f renewal companies from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of e s f renewal companies.
	*
	* @return the number of e s f renewal companies
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ESFRenewalCompanyPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ESFRenewalCompanyPersistence)PortletBeanLocatorUtil.locate(it.ethica.esf.renewal.service.ClpSerializer.getServletContextName(),
					ESFRenewalCompanyPersistence.class.getName());

			ReferenceRegistry.registerReference(ESFRenewalCompanyUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ESFRenewalCompanyPersistence persistence) {
	}

	private static ESFRenewalCompanyPersistence _persistence;
}