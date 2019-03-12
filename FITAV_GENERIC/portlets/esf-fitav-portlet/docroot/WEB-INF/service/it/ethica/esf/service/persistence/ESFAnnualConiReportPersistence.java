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

import com.liferay.portal.service.persistence.BasePersistence;

import it.ethica.esf.model.ESFAnnualConiReport;

/**
 * The persistence interface for the e s f annual coni report service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFAnnualConiReportPersistenceImpl
 * @see ESFAnnualConiReportUtil
 * @generated
 */
public interface ESFAnnualConiReportPersistence extends BasePersistence<ESFAnnualConiReport> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ESFAnnualConiReportUtil} to access the e s f annual coni report persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the e s f annual coni report where assId = &#63; and year = &#63; or throws a {@link it.ethica.esf.NoSuchAnnualConiReportException} if it could not be found.
	*
	* @param assId the ass ID
	* @param year the year
	* @return the matching e s f annual coni report
	* @throws it.ethica.esf.NoSuchAnnualConiReportException if a matching e s f annual coni report could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFAnnualConiReport findByAssYear(long assId,
		int year)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchAnnualConiReportException;

	/**
	* Returns the e s f annual coni report where assId = &#63; and year = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param assId the ass ID
	* @param year the year
	* @return the matching e s f annual coni report, or <code>null</code> if a matching e s f annual coni report could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFAnnualConiReport fetchByAssYear(long assId,
		int year) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f annual coni report where assId = &#63; and year = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param assId the ass ID
	* @param year the year
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching e s f annual coni report, or <code>null</code> if a matching e s f annual coni report could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFAnnualConiReport fetchByAssYear(long assId,
		int year, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the e s f annual coni report where assId = &#63; and year = &#63; from the database.
	*
	* @param assId the ass ID
	* @param year the year
	* @return the e s f annual coni report that was removed
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFAnnualConiReport removeByAssYear(long assId,
		int year)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchAnnualConiReportException;

	/**
	* Returns the number of e s f annual coni reports where assId = &#63; and year = &#63;.
	*
	* @param assId the ass ID
	* @param year the year
	* @return the number of matching e s f annual coni reports
	* @throws SystemException if a system exception occurred
	*/
	public int countByAssYear(long assId, int year)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the e s f annual coni report in the entity cache if it is enabled.
	*
	* @param esfAnnualConiReport the e s f annual coni report
	*/
	public void cacheResult(
		it.ethica.esf.model.ESFAnnualConiReport esfAnnualConiReport);

	/**
	* Caches the e s f annual coni reports in the entity cache if it is enabled.
	*
	* @param esfAnnualConiReports the e s f annual coni reports
	*/
	public void cacheResult(
		java.util.List<it.ethica.esf.model.ESFAnnualConiReport> esfAnnualConiReports);

	/**
	* Creates a new e s f annual coni report with the primary key. Does not add the e s f annual coni report to the database.
	*
	* @param annualConiReportId the primary key for the new e s f annual coni report
	* @return the new e s f annual coni report
	*/
	public it.ethica.esf.model.ESFAnnualConiReport create(
		long annualConiReportId);

	/**
	* Removes the e s f annual coni report with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param annualConiReportId the primary key of the e s f annual coni report
	* @return the e s f annual coni report that was removed
	* @throws it.ethica.esf.NoSuchAnnualConiReportException if a e s f annual coni report with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFAnnualConiReport remove(
		long annualConiReportId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchAnnualConiReportException;

	public it.ethica.esf.model.ESFAnnualConiReport updateImpl(
		it.ethica.esf.model.ESFAnnualConiReport esfAnnualConiReport)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f annual coni report with the primary key or throws a {@link it.ethica.esf.NoSuchAnnualConiReportException} if it could not be found.
	*
	* @param annualConiReportId the primary key of the e s f annual coni report
	* @return the e s f annual coni report
	* @throws it.ethica.esf.NoSuchAnnualConiReportException if a e s f annual coni report with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFAnnualConiReport findByPrimaryKey(
		long annualConiReportId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchAnnualConiReportException;

	/**
	* Returns the e s f annual coni report with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param annualConiReportId the primary key of the e s f annual coni report
	* @return the e s f annual coni report, or <code>null</code> if a e s f annual coni report with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFAnnualConiReport fetchByPrimaryKey(
		long annualConiReportId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f annual coni reports.
	*
	* @return the e s f annual coni reports
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFAnnualConiReport> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.ethica.esf.model.ESFAnnualConiReport> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.ethica.esf.model.ESFAnnualConiReport> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the e s f annual coni reports from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f annual coni reports.
	*
	* @return the number of e s f annual coni reports
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}