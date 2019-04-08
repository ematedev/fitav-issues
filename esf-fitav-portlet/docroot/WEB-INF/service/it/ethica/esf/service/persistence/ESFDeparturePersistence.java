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

package it.ethica.esf.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import it.ethica.esf.model.ESFDeparture;

/**
 * The persistence interface for the e s f departure service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFDeparturePersistenceImpl
 * @see ESFDepartureUtil
 * @generated
 */
public interface ESFDeparturePersistence extends BasePersistence<ESFDeparture> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ESFDepartureUtil} to access the e s f departure persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the e s f departures where esfMatchId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @return the matching e s f departures
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFDeparture> findByesfMatch(
		long esfMatchId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f departures where esfMatchId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFDepartureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfMatchId the esf match ID
	* @param start the lower bound of the range of e s f departures
	* @param end the upper bound of the range of e s f departures (not inclusive)
	* @return the range of matching e s f departures
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFDeparture> findByesfMatch(
		long esfMatchId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f departures where esfMatchId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFDepartureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfMatchId the esf match ID
	* @param start the lower bound of the range of e s f departures
	* @param end the upper bound of the range of e s f departures (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f departures
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFDeparture> findByesfMatch(
		long esfMatchId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f departure in the ordered set where esfMatchId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f departure
	* @throws it.ethica.esf.NoSuchDepartureException if a matching e s f departure could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFDeparture findByesfMatch_First(
		long esfMatchId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchDepartureException;

	/**
	* Returns the first e s f departure in the ordered set where esfMatchId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f departure, or <code>null</code> if a matching e s f departure could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFDeparture fetchByesfMatch_First(
		long esfMatchId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f departure in the ordered set where esfMatchId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f departure
	* @throws it.ethica.esf.NoSuchDepartureException if a matching e s f departure could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFDeparture findByesfMatch_Last(
		long esfMatchId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchDepartureException;

	/**
	* Returns the last e s f departure in the ordered set where esfMatchId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f departure, or <code>null</code> if a matching e s f departure could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFDeparture fetchByesfMatch_Last(
		long esfMatchId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f departures before and after the current e s f departure in the ordered set where esfMatchId = &#63;.
	*
	* @param esfDepartureId the primary key of the current e s f departure
	* @param esfMatchId the esf match ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f departure
	* @throws it.ethica.esf.NoSuchDepartureException if a e s f departure with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFDeparture[] findByesfMatch_PrevAndNext(
		long esfDepartureId, long esfMatchId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchDepartureException;

	/**
	* Removes all the e s f departures where esfMatchId = &#63; from the database.
	*
	* @param esfMatchId the esf match ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByesfMatch(long esfMatchId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f departures where esfMatchId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @return the number of matching e s f departures
	* @throws SystemException if a system exception occurred
	*/
	public int countByesfMatch(long esfMatchId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f departures where code = &#63;.
	*
	* @param code the code
	* @return the matching e s f departures
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFDeparture> findBycode(
		java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f departures where code = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFDepartureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param code the code
	* @param start the lower bound of the range of e s f departures
	* @param end the upper bound of the range of e s f departures (not inclusive)
	* @return the range of matching e s f departures
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFDeparture> findBycode(
		java.lang.String code, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f departures where code = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFDepartureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param code the code
	* @param start the lower bound of the range of e s f departures
	* @param end the upper bound of the range of e s f departures (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f departures
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFDeparture> findBycode(
		java.lang.String code, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f departure in the ordered set where code = &#63;.
	*
	* @param code the code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f departure
	* @throws it.ethica.esf.NoSuchDepartureException if a matching e s f departure could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFDeparture findBycode_First(
		java.lang.String code,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchDepartureException;

	/**
	* Returns the first e s f departure in the ordered set where code = &#63;.
	*
	* @param code the code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f departure, or <code>null</code> if a matching e s f departure could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFDeparture fetchBycode_First(
		java.lang.String code,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f departure in the ordered set where code = &#63;.
	*
	* @param code the code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f departure
	* @throws it.ethica.esf.NoSuchDepartureException if a matching e s f departure could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFDeparture findBycode_Last(
		java.lang.String code,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchDepartureException;

	/**
	* Returns the last e s f departure in the ordered set where code = &#63;.
	*
	* @param code the code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f departure, or <code>null</code> if a matching e s f departure could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFDeparture fetchBycode_Last(
		java.lang.String code,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f departures before and after the current e s f departure in the ordered set where code = &#63;.
	*
	* @param esfDepartureId the primary key of the current e s f departure
	* @param code the code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f departure
	* @throws it.ethica.esf.NoSuchDepartureException if a e s f departure with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFDeparture[] findBycode_PrevAndNext(
		long esfDepartureId, java.lang.String code,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchDepartureException;

	/**
	* Removes all the e s f departures where code = &#63; from the database.
	*
	* @param code the code
	* @throws SystemException if a system exception occurred
	*/
	public void removeBycode(java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f departures where code = &#63;.
	*
	* @param code the code
	* @return the number of matching e s f departures
	* @throws SystemException if a system exception occurred
	*/
	public int countBycode(java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f departures where esfMatchId = &#63; and code = &#63; and leaveDate = &#63; and leaveHour = &#63; and companyName = &#63; and departureFrom = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param code the code
	* @param leaveDate the leave date
	* @param leaveHour the leave hour
	* @param companyName the company name
	* @param departureFrom the departure from
	* @return the matching e s f departures
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFDeparture> findByesfMatchId_C_L_L_C_D(
		long esfMatchId, java.lang.String code, java.util.Date leaveDate,
		java.lang.String leaveHour, java.lang.String companyName,
		java.lang.String departureFrom)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f departures where esfMatchId = &#63; and code = &#63; and leaveDate = &#63; and leaveHour = &#63; and companyName = &#63; and departureFrom = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFDepartureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfMatchId the esf match ID
	* @param code the code
	* @param leaveDate the leave date
	* @param leaveHour the leave hour
	* @param companyName the company name
	* @param departureFrom the departure from
	* @param start the lower bound of the range of e s f departures
	* @param end the upper bound of the range of e s f departures (not inclusive)
	* @return the range of matching e s f departures
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFDeparture> findByesfMatchId_C_L_L_C_D(
		long esfMatchId, java.lang.String code, java.util.Date leaveDate,
		java.lang.String leaveHour, java.lang.String companyName,
		java.lang.String departureFrom, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f departures where esfMatchId = &#63; and code = &#63; and leaveDate = &#63; and leaveHour = &#63; and companyName = &#63; and departureFrom = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFDepartureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfMatchId the esf match ID
	* @param code the code
	* @param leaveDate the leave date
	* @param leaveHour the leave hour
	* @param companyName the company name
	* @param departureFrom the departure from
	* @param start the lower bound of the range of e s f departures
	* @param end the upper bound of the range of e s f departures (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f departures
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFDeparture> findByesfMatchId_C_L_L_C_D(
		long esfMatchId, java.lang.String code, java.util.Date leaveDate,
		java.lang.String leaveHour, java.lang.String companyName,
		java.lang.String departureFrom, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f departure in the ordered set where esfMatchId = &#63; and code = &#63; and leaveDate = &#63; and leaveHour = &#63; and companyName = &#63; and departureFrom = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param code the code
	* @param leaveDate the leave date
	* @param leaveHour the leave hour
	* @param companyName the company name
	* @param departureFrom the departure from
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f departure
	* @throws it.ethica.esf.NoSuchDepartureException if a matching e s f departure could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFDeparture findByesfMatchId_C_L_L_C_D_First(
		long esfMatchId, java.lang.String code, java.util.Date leaveDate,
		java.lang.String leaveHour, java.lang.String companyName,
		java.lang.String departureFrom,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchDepartureException;

	/**
	* Returns the first e s f departure in the ordered set where esfMatchId = &#63; and code = &#63; and leaveDate = &#63; and leaveHour = &#63; and companyName = &#63; and departureFrom = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param code the code
	* @param leaveDate the leave date
	* @param leaveHour the leave hour
	* @param companyName the company name
	* @param departureFrom the departure from
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f departure, or <code>null</code> if a matching e s f departure could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFDeparture fetchByesfMatchId_C_L_L_C_D_First(
		long esfMatchId, java.lang.String code, java.util.Date leaveDate,
		java.lang.String leaveHour, java.lang.String companyName,
		java.lang.String departureFrom,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f departure in the ordered set where esfMatchId = &#63; and code = &#63; and leaveDate = &#63; and leaveHour = &#63; and companyName = &#63; and departureFrom = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param code the code
	* @param leaveDate the leave date
	* @param leaveHour the leave hour
	* @param companyName the company name
	* @param departureFrom the departure from
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f departure
	* @throws it.ethica.esf.NoSuchDepartureException if a matching e s f departure could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFDeparture findByesfMatchId_C_L_L_C_D_Last(
		long esfMatchId, java.lang.String code, java.util.Date leaveDate,
		java.lang.String leaveHour, java.lang.String companyName,
		java.lang.String departureFrom,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchDepartureException;

	/**
	* Returns the last e s f departure in the ordered set where esfMatchId = &#63; and code = &#63; and leaveDate = &#63; and leaveHour = &#63; and companyName = &#63; and departureFrom = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param code the code
	* @param leaveDate the leave date
	* @param leaveHour the leave hour
	* @param companyName the company name
	* @param departureFrom the departure from
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f departure, or <code>null</code> if a matching e s f departure could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFDeparture fetchByesfMatchId_C_L_L_C_D_Last(
		long esfMatchId, java.lang.String code, java.util.Date leaveDate,
		java.lang.String leaveHour, java.lang.String companyName,
		java.lang.String departureFrom,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f departures before and after the current e s f departure in the ordered set where esfMatchId = &#63; and code = &#63; and leaveDate = &#63; and leaveHour = &#63; and companyName = &#63; and departureFrom = &#63;.
	*
	* @param esfDepartureId the primary key of the current e s f departure
	* @param esfMatchId the esf match ID
	* @param code the code
	* @param leaveDate the leave date
	* @param leaveHour the leave hour
	* @param companyName the company name
	* @param departureFrom the departure from
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f departure
	* @throws it.ethica.esf.NoSuchDepartureException if a e s f departure with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFDeparture[] findByesfMatchId_C_L_L_C_D_PrevAndNext(
		long esfDepartureId, long esfMatchId, java.lang.String code,
		java.util.Date leaveDate, java.lang.String leaveHour,
		java.lang.String companyName, java.lang.String departureFrom,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchDepartureException;

	/**
	* Removes all the e s f departures where esfMatchId = &#63; and code = &#63; and leaveDate = &#63; and leaveHour = &#63; and companyName = &#63; and departureFrom = &#63; from the database.
	*
	* @param esfMatchId the esf match ID
	* @param code the code
	* @param leaveDate the leave date
	* @param leaveHour the leave hour
	* @param companyName the company name
	* @param departureFrom the departure from
	* @throws SystemException if a system exception occurred
	*/
	public void removeByesfMatchId_C_L_L_C_D(long esfMatchId,
		java.lang.String code, java.util.Date leaveDate,
		java.lang.String leaveHour, java.lang.String companyName,
		java.lang.String departureFrom)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f departures where esfMatchId = &#63; and code = &#63; and leaveDate = &#63; and leaveHour = &#63; and companyName = &#63; and departureFrom = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param code the code
	* @param leaveDate the leave date
	* @param leaveHour the leave hour
	* @param companyName the company name
	* @param departureFrom the departure from
	* @return the number of matching e s f departures
	* @throws SystemException if a system exception occurred
	*/
	public int countByesfMatchId_C_L_L_C_D(long esfMatchId,
		java.lang.String code, java.util.Date leaveDate,
		java.lang.String leaveHour, java.lang.String companyName,
		java.lang.String departureFrom)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f departures where esfMatchId = &#63; and esfUserId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfUserId the esf user ID
	* @return the matching e s f departures
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFDeparture> findByesfMatchEsfUser(
		long esfMatchId, long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f departures where esfMatchId = &#63; and esfUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFDepartureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfMatchId the esf match ID
	* @param esfUserId the esf user ID
	* @param start the lower bound of the range of e s f departures
	* @param end the upper bound of the range of e s f departures (not inclusive)
	* @return the range of matching e s f departures
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFDeparture> findByesfMatchEsfUser(
		long esfMatchId, long esfUserId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f departures where esfMatchId = &#63; and esfUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFDepartureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfMatchId the esf match ID
	* @param esfUserId the esf user ID
	* @param start the lower bound of the range of e s f departures
	* @param end the upper bound of the range of e s f departures (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f departures
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFDeparture> findByesfMatchEsfUser(
		long esfMatchId, long esfUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f departure in the ordered set where esfMatchId = &#63; and esfUserId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f departure
	* @throws it.ethica.esf.NoSuchDepartureException if a matching e s f departure could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFDeparture findByesfMatchEsfUser_First(
		long esfMatchId, long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchDepartureException;

	/**
	* Returns the first e s f departure in the ordered set where esfMatchId = &#63; and esfUserId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f departure, or <code>null</code> if a matching e s f departure could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFDeparture fetchByesfMatchEsfUser_First(
		long esfMatchId, long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f departure in the ordered set where esfMatchId = &#63; and esfUserId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f departure
	* @throws it.ethica.esf.NoSuchDepartureException if a matching e s f departure could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFDeparture findByesfMatchEsfUser_Last(
		long esfMatchId, long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchDepartureException;

	/**
	* Returns the last e s f departure in the ordered set where esfMatchId = &#63; and esfUserId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f departure, or <code>null</code> if a matching e s f departure could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFDeparture fetchByesfMatchEsfUser_Last(
		long esfMatchId, long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f departures before and after the current e s f departure in the ordered set where esfMatchId = &#63; and esfUserId = &#63;.
	*
	* @param esfDepartureId the primary key of the current e s f departure
	* @param esfMatchId the esf match ID
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f departure
	* @throws it.ethica.esf.NoSuchDepartureException if a e s f departure with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFDeparture[] findByesfMatchEsfUser_PrevAndNext(
		long esfDepartureId, long esfMatchId, long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchDepartureException;

	/**
	* Removes all the e s f departures where esfMatchId = &#63; and esfUserId = &#63; from the database.
	*
	* @param esfMatchId the esf match ID
	* @param esfUserId the esf user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByesfMatchEsfUser(long esfMatchId, long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f departures where esfMatchId = &#63; and esfUserId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfUserId the esf user ID
	* @return the number of matching e s f departures
	* @throws SystemException if a system exception occurred
	*/
	public int countByesfMatchEsfUser(long esfMatchId, long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the e s f departure in the entity cache if it is enabled.
	*
	* @param esfDeparture the e s f departure
	*/
	public void cacheResult(it.ethica.esf.model.ESFDeparture esfDeparture);

	/**
	* Caches the e s f departures in the entity cache if it is enabled.
	*
	* @param esfDepartures the e s f departures
	*/
	public void cacheResult(
		java.util.List<it.ethica.esf.model.ESFDeparture> esfDepartures);

	/**
	* Creates a new e s f departure with the primary key. Does not add the e s f departure to the database.
	*
	* @param esfDepartureId the primary key for the new e s f departure
	* @return the new e s f departure
	*/
	public it.ethica.esf.model.ESFDeparture create(long esfDepartureId);

	/**
	* Removes the e s f departure with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfDepartureId the primary key of the e s f departure
	* @return the e s f departure that was removed
	* @throws it.ethica.esf.NoSuchDepartureException if a e s f departure with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFDeparture remove(long esfDepartureId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchDepartureException;

	public it.ethica.esf.model.ESFDeparture updateImpl(
		it.ethica.esf.model.ESFDeparture esfDeparture)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f departure with the primary key or throws a {@link it.ethica.esf.NoSuchDepartureException} if it could not be found.
	*
	* @param esfDepartureId the primary key of the e s f departure
	* @return the e s f departure
	* @throws it.ethica.esf.NoSuchDepartureException if a e s f departure with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFDeparture findByPrimaryKey(
		long esfDepartureId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchDepartureException;

	/**
	* Returns the e s f departure with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param esfDepartureId the primary key of the e s f departure
	* @return the e s f departure, or <code>null</code> if a e s f departure with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFDeparture fetchByPrimaryKey(
		long esfDepartureId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f departures.
	*
	* @return the e s f departures
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFDeparture> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f departures.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFDepartureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f departures
	* @param end the upper bound of the range of e s f departures (not inclusive)
	* @return the range of e s f departures
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFDeparture> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f departures.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFDepartureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f departures
	* @param end the upper bound of the range of e s f departures (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of e s f departures
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFDeparture> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the e s f departures from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f departures.
	*
	* @return the number of e s f departures
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}