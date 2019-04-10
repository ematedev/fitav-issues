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

import it.ethica.esf.model.ESFFlight;

/**
 * The persistence interface for the e s f flight service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFFlightPersistenceImpl
 * @see ESFFlightUtil
 * @generated
 */
public interface ESFFlightPersistence extends BasePersistence<ESFFlight> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ESFFlightUtil} to access the e s f flight persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the e s f flights where esfMatchId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @return the matching e s f flights
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFFlight> findByesfMatch(
		long esfMatchId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f flights where esfMatchId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFlightModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfMatchId the esf match ID
	* @param start the lower bound of the range of e s f flights
	* @param end the upper bound of the range of e s f flights (not inclusive)
	* @return the range of matching e s f flights
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFFlight> findByesfMatch(
		long esfMatchId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f flights where esfMatchId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFlightModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfMatchId the esf match ID
	* @param start the lower bound of the range of e s f flights
	* @param end the upper bound of the range of e s f flights (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f flights
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFFlight> findByesfMatch(
		long esfMatchId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f flight in the ordered set where esfMatchId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f flight
	* @throws it.ethica.esf.NoSuchFlightException if a matching e s f flight could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFFlight findByesfMatch_First(long esfMatchId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFlightException;

	/**
	* Returns the first e s f flight in the ordered set where esfMatchId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f flight, or <code>null</code> if a matching e s f flight could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFFlight fetchByesfMatch_First(
		long esfMatchId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f flight in the ordered set where esfMatchId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f flight
	* @throws it.ethica.esf.NoSuchFlightException if a matching e s f flight could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFFlight findByesfMatch_Last(long esfMatchId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFlightException;

	/**
	* Returns the last e s f flight in the ordered set where esfMatchId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f flight, or <code>null</code> if a matching e s f flight could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFFlight fetchByesfMatch_Last(long esfMatchId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f flights before and after the current e s f flight in the ordered set where esfMatchId = &#63;.
	*
	* @param esfFlightId the primary key of the current e s f flight
	* @param esfMatchId the esf match ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f flight
	* @throws it.ethica.esf.NoSuchFlightException if a e s f flight with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFFlight[] findByesfMatch_PrevAndNext(
		long esfFlightId, long esfMatchId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFlightException;

	/**
	* Removes all the e s f flights where esfMatchId = &#63; from the database.
	*
	* @param esfMatchId the esf match ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByesfMatch(long esfMatchId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f flights where esfMatchId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @return the number of matching e s f flights
	* @throws SystemException if a system exception occurred
	*/
	public int countByesfMatch(long esfMatchId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f flights where flightCode = &#63;.
	*
	* @param flightCode the flight code
	* @return the matching e s f flights
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFFlight> findByflightCode(
		java.lang.String flightCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f flights where flightCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFlightModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param flightCode the flight code
	* @param start the lower bound of the range of e s f flights
	* @param end the upper bound of the range of e s f flights (not inclusive)
	* @return the range of matching e s f flights
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFFlight> findByflightCode(
		java.lang.String flightCode, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f flights where flightCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFlightModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param flightCode the flight code
	* @param start the lower bound of the range of e s f flights
	* @param end the upper bound of the range of e s f flights (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f flights
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFFlight> findByflightCode(
		java.lang.String flightCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f flight in the ordered set where flightCode = &#63;.
	*
	* @param flightCode the flight code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f flight
	* @throws it.ethica.esf.NoSuchFlightException if a matching e s f flight could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFFlight findByflightCode_First(
		java.lang.String flightCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFlightException;

	/**
	* Returns the first e s f flight in the ordered set where flightCode = &#63;.
	*
	* @param flightCode the flight code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f flight, or <code>null</code> if a matching e s f flight could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFFlight fetchByflightCode_First(
		java.lang.String flightCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f flight in the ordered set where flightCode = &#63;.
	*
	* @param flightCode the flight code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f flight
	* @throws it.ethica.esf.NoSuchFlightException if a matching e s f flight could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFFlight findByflightCode_Last(
		java.lang.String flightCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFlightException;

	/**
	* Returns the last e s f flight in the ordered set where flightCode = &#63;.
	*
	* @param flightCode the flight code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f flight, or <code>null</code> if a matching e s f flight could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFFlight fetchByflightCode_Last(
		java.lang.String flightCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f flights before and after the current e s f flight in the ordered set where flightCode = &#63;.
	*
	* @param esfFlightId the primary key of the current e s f flight
	* @param flightCode the flight code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f flight
	* @throws it.ethica.esf.NoSuchFlightException if a e s f flight with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFFlight[] findByflightCode_PrevAndNext(
		long esfFlightId, java.lang.String flightCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFlightException;

	/**
	* Removes all the e s f flights where flightCode = &#63; from the database.
	*
	* @param flightCode the flight code
	* @throws SystemException if a system exception occurred
	*/
	public void removeByflightCode(java.lang.String flightCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f flights where flightCode = &#63;.
	*
	* @param flightCode the flight code
	* @return the number of matching e s f flights
	* @throws SystemException if a system exception occurred
	*/
	public int countByflightCode(java.lang.String flightCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f flights where esfMatchId = &#63; and flightCode = &#63; and leaveDate = &#63; and leaveHour = &#63; and companyName = &#63; and departureAirport = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param flightCode the flight code
	* @param leaveDate the leave date
	* @param leaveHour the leave hour
	* @param companyName the company name
	* @param departureAirport the departure airport
	* @return the matching e s f flights
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFFlight> findByesfMatchId_F_L_L_C_D(
		long esfMatchId, java.lang.String flightCode, java.util.Date leaveDate,
		java.lang.String leaveHour, java.lang.String companyName,
		java.lang.String departureAirport)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f flights where esfMatchId = &#63; and flightCode = &#63; and leaveDate = &#63; and leaveHour = &#63; and companyName = &#63; and departureAirport = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFlightModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfMatchId the esf match ID
	* @param flightCode the flight code
	* @param leaveDate the leave date
	* @param leaveHour the leave hour
	* @param companyName the company name
	* @param departureAirport the departure airport
	* @param start the lower bound of the range of e s f flights
	* @param end the upper bound of the range of e s f flights (not inclusive)
	* @return the range of matching e s f flights
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFFlight> findByesfMatchId_F_L_L_C_D(
		long esfMatchId, java.lang.String flightCode, java.util.Date leaveDate,
		java.lang.String leaveHour, java.lang.String companyName,
		java.lang.String departureAirport, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f flights where esfMatchId = &#63; and flightCode = &#63; and leaveDate = &#63; and leaveHour = &#63; and companyName = &#63; and departureAirport = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFlightModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfMatchId the esf match ID
	* @param flightCode the flight code
	* @param leaveDate the leave date
	* @param leaveHour the leave hour
	* @param companyName the company name
	* @param departureAirport the departure airport
	* @param start the lower bound of the range of e s f flights
	* @param end the upper bound of the range of e s f flights (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f flights
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFFlight> findByesfMatchId_F_L_L_C_D(
		long esfMatchId, java.lang.String flightCode, java.util.Date leaveDate,
		java.lang.String leaveHour, java.lang.String companyName,
		java.lang.String departureAirport, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f flight in the ordered set where esfMatchId = &#63; and flightCode = &#63; and leaveDate = &#63; and leaveHour = &#63; and companyName = &#63; and departureAirport = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param flightCode the flight code
	* @param leaveDate the leave date
	* @param leaveHour the leave hour
	* @param companyName the company name
	* @param departureAirport the departure airport
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f flight
	* @throws it.ethica.esf.NoSuchFlightException if a matching e s f flight could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFFlight findByesfMatchId_F_L_L_C_D_First(
		long esfMatchId, java.lang.String flightCode, java.util.Date leaveDate,
		java.lang.String leaveHour, java.lang.String companyName,
		java.lang.String departureAirport,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFlightException;

	/**
	* Returns the first e s f flight in the ordered set where esfMatchId = &#63; and flightCode = &#63; and leaveDate = &#63; and leaveHour = &#63; and companyName = &#63; and departureAirport = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param flightCode the flight code
	* @param leaveDate the leave date
	* @param leaveHour the leave hour
	* @param companyName the company name
	* @param departureAirport the departure airport
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f flight, or <code>null</code> if a matching e s f flight could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFFlight fetchByesfMatchId_F_L_L_C_D_First(
		long esfMatchId, java.lang.String flightCode, java.util.Date leaveDate,
		java.lang.String leaveHour, java.lang.String companyName,
		java.lang.String departureAirport,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f flight in the ordered set where esfMatchId = &#63; and flightCode = &#63; and leaveDate = &#63; and leaveHour = &#63; and companyName = &#63; and departureAirport = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param flightCode the flight code
	* @param leaveDate the leave date
	* @param leaveHour the leave hour
	* @param companyName the company name
	* @param departureAirport the departure airport
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f flight
	* @throws it.ethica.esf.NoSuchFlightException if a matching e s f flight could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFFlight findByesfMatchId_F_L_L_C_D_Last(
		long esfMatchId, java.lang.String flightCode, java.util.Date leaveDate,
		java.lang.String leaveHour, java.lang.String companyName,
		java.lang.String departureAirport,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFlightException;

	/**
	* Returns the last e s f flight in the ordered set where esfMatchId = &#63; and flightCode = &#63; and leaveDate = &#63; and leaveHour = &#63; and companyName = &#63; and departureAirport = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param flightCode the flight code
	* @param leaveDate the leave date
	* @param leaveHour the leave hour
	* @param companyName the company name
	* @param departureAirport the departure airport
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f flight, or <code>null</code> if a matching e s f flight could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFFlight fetchByesfMatchId_F_L_L_C_D_Last(
		long esfMatchId, java.lang.String flightCode, java.util.Date leaveDate,
		java.lang.String leaveHour, java.lang.String companyName,
		java.lang.String departureAirport,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f flights before and after the current e s f flight in the ordered set where esfMatchId = &#63; and flightCode = &#63; and leaveDate = &#63; and leaveHour = &#63; and companyName = &#63; and departureAirport = &#63;.
	*
	* @param esfFlightId the primary key of the current e s f flight
	* @param esfMatchId the esf match ID
	* @param flightCode the flight code
	* @param leaveDate the leave date
	* @param leaveHour the leave hour
	* @param companyName the company name
	* @param departureAirport the departure airport
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f flight
	* @throws it.ethica.esf.NoSuchFlightException if a e s f flight with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFFlight[] findByesfMatchId_F_L_L_C_D_PrevAndNext(
		long esfFlightId, long esfMatchId, java.lang.String flightCode,
		java.util.Date leaveDate, java.lang.String leaveHour,
		java.lang.String companyName, java.lang.String departureAirport,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFlightException;

	/**
	* Removes all the e s f flights where esfMatchId = &#63; and flightCode = &#63; and leaveDate = &#63; and leaveHour = &#63; and companyName = &#63; and departureAirport = &#63; from the database.
	*
	* @param esfMatchId the esf match ID
	* @param flightCode the flight code
	* @param leaveDate the leave date
	* @param leaveHour the leave hour
	* @param companyName the company name
	* @param departureAirport the departure airport
	* @throws SystemException if a system exception occurred
	*/
	public void removeByesfMatchId_F_L_L_C_D(long esfMatchId,
		java.lang.String flightCode, java.util.Date leaveDate,
		java.lang.String leaveHour, java.lang.String companyName,
		java.lang.String departureAirport)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f flights where esfMatchId = &#63; and flightCode = &#63; and leaveDate = &#63; and leaveHour = &#63; and companyName = &#63; and departureAirport = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param flightCode the flight code
	* @param leaveDate the leave date
	* @param leaveHour the leave hour
	* @param companyName the company name
	* @param departureAirport the departure airport
	* @return the number of matching e s f flights
	* @throws SystemException if a system exception occurred
	*/
	public int countByesfMatchId_F_L_L_C_D(long esfMatchId,
		java.lang.String flightCode, java.util.Date leaveDate,
		java.lang.String leaveHour, java.lang.String companyName,
		java.lang.String departureAirport)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f flights where esfMatchId = &#63; and esfUserId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfUserId the esf user ID
	* @return the matching e s f flights
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFFlight> findByesfMatchEsfUser(
		long esfMatchId, long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f flights where esfMatchId = &#63; and esfUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFlightModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfMatchId the esf match ID
	* @param esfUserId the esf user ID
	* @param start the lower bound of the range of e s f flights
	* @param end the upper bound of the range of e s f flights (not inclusive)
	* @return the range of matching e s f flights
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFFlight> findByesfMatchEsfUser(
		long esfMatchId, long esfUserId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f flights where esfMatchId = &#63; and esfUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFlightModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfMatchId the esf match ID
	* @param esfUserId the esf user ID
	* @param start the lower bound of the range of e s f flights
	* @param end the upper bound of the range of e s f flights (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f flights
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFFlight> findByesfMatchEsfUser(
		long esfMatchId, long esfUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f flight in the ordered set where esfMatchId = &#63; and esfUserId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f flight
	* @throws it.ethica.esf.NoSuchFlightException if a matching e s f flight could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFFlight findByesfMatchEsfUser_First(
		long esfMatchId, long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFlightException;

	/**
	* Returns the first e s f flight in the ordered set where esfMatchId = &#63; and esfUserId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f flight, or <code>null</code> if a matching e s f flight could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFFlight fetchByesfMatchEsfUser_First(
		long esfMatchId, long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f flight in the ordered set where esfMatchId = &#63; and esfUserId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f flight
	* @throws it.ethica.esf.NoSuchFlightException if a matching e s f flight could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFFlight findByesfMatchEsfUser_Last(
		long esfMatchId, long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFlightException;

	/**
	* Returns the last e s f flight in the ordered set where esfMatchId = &#63; and esfUserId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f flight, or <code>null</code> if a matching e s f flight could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFFlight fetchByesfMatchEsfUser_Last(
		long esfMatchId, long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f flights before and after the current e s f flight in the ordered set where esfMatchId = &#63; and esfUserId = &#63;.
	*
	* @param esfFlightId the primary key of the current e s f flight
	* @param esfMatchId the esf match ID
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f flight
	* @throws it.ethica.esf.NoSuchFlightException if a e s f flight with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFFlight[] findByesfMatchEsfUser_PrevAndNext(
		long esfFlightId, long esfMatchId, long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFlightException;

	/**
	* Removes all the e s f flights where esfMatchId = &#63; and esfUserId = &#63; from the database.
	*
	* @param esfMatchId the esf match ID
	* @param esfUserId the esf user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByesfMatchEsfUser(long esfMatchId, long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f flights where esfMatchId = &#63; and esfUserId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfUserId the esf user ID
	* @return the number of matching e s f flights
	* @throws SystemException if a system exception occurred
	*/
	public int countByesfMatchEsfUser(long esfMatchId, long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the e s f flight in the entity cache if it is enabled.
	*
	* @param esfFlight the e s f flight
	*/
	public void cacheResult(it.ethica.esf.model.ESFFlight esfFlight);

	/**
	* Caches the e s f flights in the entity cache if it is enabled.
	*
	* @param esfFlights the e s f flights
	*/
	public void cacheResult(
		java.util.List<it.ethica.esf.model.ESFFlight> esfFlights);

	/**
	* Creates a new e s f flight with the primary key. Does not add the e s f flight to the database.
	*
	* @param esfFlightId the primary key for the new e s f flight
	* @return the new e s f flight
	*/
	public it.ethica.esf.model.ESFFlight create(long esfFlightId);

	/**
	* Removes the e s f flight with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfFlightId the primary key of the e s f flight
	* @return the e s f flight that was removed
	* @throws it.ethica.esf.NoSuchFlightException if a e s f flight with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFFlight remove(long esfFlightId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFlightException;

	public it.ethica.esf.model.ESFFlight updateImpl(
		it.ethica.esf.model.ESFFlight esfFlight)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f flight with the primary key or throws a {@link it.ethica.esf.NoSuchFlightException} if it could not be found.
	*
	* @param esfFlightId the primary key of the e s f flight
	* @return the e s f flight
	* @throws it.ethica.esf.NoSuchFlightException if a e s f flight with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFFlight findByPrimaryKey(long esfFlightId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFlightException;

	/**
	* Returns the e s f flight with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param esfFlightId the primary key of the e s f flight
	* @return the e s f flight, or <code>null</code> if a e s f flight with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFFlight fetchByPrimaryKey(long esfFlightId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f flights.
	*
	* @return the e s f flights
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFFlight> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f flights.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFlightModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f flights
	* @param end the upper bound of the range of e s f flights (not inclusive)
	* @return the range of e s f flights
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFFlight> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f flights.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFlightModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f flights
	* @param end the upper bound of the range of e s f flights (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of e s f flights
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFFlight> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the e s f flights from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f flights.
	*
	* @return the number of e s f flights
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}