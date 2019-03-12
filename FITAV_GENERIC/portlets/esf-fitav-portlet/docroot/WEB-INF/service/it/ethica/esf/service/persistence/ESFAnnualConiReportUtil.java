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

import it.ethica.esf.model.ESFAnnualConiReport;

import java.util.List;

/**
 * The persistence utility for the e s f annual coni report service. This utility wraps {@link ESFAnnualConiReportPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFAnnualConiReportPersistence
 * @see ESFAnnualConiReportPersistenceImpl
 * @generated
 */
public class ESFAnnualConiReportUtil {
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
	public static void clearCache(ESFAnnualConiReport esfAnnualConiReport) {
		getPersistence().clearCache(esfAnnualConiReport);
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
	public static List<ESFAnnualConiReport> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ESFAnnualConiReport> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ESFAnnualConiReport> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ESFAnnualConiReport update(
		ESFAnnualConiReport esfAnnualConiReport) throws SystemException {
		return getPersistence().update(esfAnnualConiReport);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ESFAnnualConiReport update(
		ESFAnnualConiReport esfAnnualConiReport, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(esfAnnualConiReport, serviceContext);
	}

	/**
	* Returns the e s f annual coni report where assId = &#63; and year = &#63; or throws a {@link it.ethica.esf.NoSuchAnnualConiReportException} if it could not be found.
	*
	* @param assId the ass ID
	* @param year the year
	* @return the matching e s f annual coni report
	* @throws it.ethica.esf.NoSuchAnnualConiReportException if a matching e s f annual coni report could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFAnnualConiReport findByAssYear(
		long assId, int year)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchAnnualConiReportException {
		return getPersistence().findByAssYear(assId, year);
	}

	/**
	* Returns the e s f annual coni report where assId = &#63; and year = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param assId the ass ID
	* @param year the year
	* @return the matching e s f annual coni report, or <code>null</code> if a matching e s f annual coni report could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFAnnualConiReport fetchByAssYear(
		long assId, int year)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByAssYear(assId, year);
	}

	/**
	* Returns the e s f annual coni report where assId = &#63; and year = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param assId the ass ID
	* @param year the year
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching e s f annual coni report, or <code>null</code> if a matching e s f annual coni report could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFAnnualConiReport fetchByAssYear(
		long assId, int year, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByAssYear(assId, year, retrieveFromCache);
	}

	/**
	* Removes the e s f annual coni report where assId = &#63; and year = &#63; from the database.
	*
	* @param assId the ass ID
	* @param year the year
	* @return the e s f annual coni report that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFAnnualConiReport removeByAssYear(
		long assId, int year)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchAnnualConiReportException {
		return getPersistence().removeByAssYear(assId, year);
	}

	/**
	* Returns the number of e s f annual coni reports where assId = &#63; and year = &#63;.
	*
	* @param assId the ass ID
	* @param year the year
	* @return the number of matching e s f annual coni reports
	* @throws SystemException if a system exception occurred
	*/
	public static int countByAssYear(long assId, int year)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByAssYear(assId, year);
	}

	/**
	* Caches the e s f annual coni report in the entity cache if it is enabled.
	*
	* @param esfAnnualConiReport the e s f annual coni report
	*/
	public static void cacheResult(
		it.ethica.esf.model.ESFAnnualConiReport esfAnnualConiReport) {
		getPersistence().cacheResult(esfAnnualConiReport);
	}

	/**
	* Caches the e s f annual coni reports in the entity cache if it is enabled.
	*
	* @param esfAnnualConiReports the e s f annual coni reports
	*/
	public static void cacheResult(
		java.util.List<it.ethica.esf.model.ESFAnnualConiReport> esfAnnualConiReports) {
		getPersistence().cacheResult(esfAnnualConiReports);
	}

	/**
	* Creates a new e s f annual coni report with the primary key. Does not add the e s f annual coni report to the database.
	*
	* @param annualConiReportId the primary key for the new e s f annual coni report
	* @return the new e s f annual coni report
	*/
	public static it.ethica.esf.model.ESFAnnualConiReport create(
		long annualConiReportId) {
		return getPersistence().create(annualConiReportId);
	}

	/**
	* Removes the e s f annual coni report with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param annualConiReportId the primary key of the e s f annual coni report
	* @return the e s f annual coni report that was removed
	* @throws it.ethica.esf.NoSuchAnnualConiReportException if a e s f annual coni report with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFAnnualConiReport remove(
		long annualConiReportId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchAnnualConiReportException {
		return getPersistence().remove(annualConiReportId);
	}

	public static it.ethica.esf.model.ESFAnnualConiReport updateImpl(
		it.ethica.esf.model.ESFAnnualConiReport esfAnnualConiReport)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(esfAnnualConiReport);
	}

	/**
	* Returns the e s f annual coni report with the primary key or throws a {@link it.ethica.esf.NoSuchAnnualConiReportException} if it could not be found.
	*
	* @param annualConiReportId the primary key of the e s f annual coni report
	* @return the e s f annual coni report
	* @throws it.ethica.esf.NoSuchAnnualConiReportException if a e s f annual coni report with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFAnnualConiReport findByPrimaryKey(
		long annualConiReportId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchAnnualConiReportException {
		return getPersistence().findByPrimaryKey(annualConiReportId);
	}

	/**
	* Returns the e s f annual coni report with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param annualConiReportId the primary key of the e s f annual coni report
	* @return the e s f annual coni report, or <code>null</code> if a e s f annual coni report with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFAnnualConiReport fetchByPrimaryKey(
		long annualConiReportId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(annualConiReportId);
	}

	/**
	* Returns all the e s f annual coni reports.
	*
	* @return the e s f annual coni reports
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFAnnualConiReport> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the e s f annual coni reports.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFAnnualConiReportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f annual coni reports
	* @param end the upper bound of the range of e s f annual coni reports (not inclusive)
	* @return the range of e s f annual coni reports
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFAnnualConiReport> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the e s f annual coni reports.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFAnnualConiReportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f annual coni reports
	* @param end the upper bound of the range of e s f annual coni reports (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of e s f annual coni reports
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFAnnualConiReport> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the e s f annual coni reports from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of e s f annual coni reports.
	*
	* @return the number of e s f annual coni reports
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ESFAnnualConiReportPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ESFAnnualConiReportPersistence)PortletBeanLocatorUtil.locate(it.ethica.esf.service.ClpSerializer.getServletContextName(),
					ESFAnnualConiReportPersistence.class.getName());

			ReferenceRegistry.registerReference(ESFAnnualConiReportUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ESFAnnualConiReportPersistence persistence) {
	}

	private static ESFAnnualConiReportPersistence _persistence;
}