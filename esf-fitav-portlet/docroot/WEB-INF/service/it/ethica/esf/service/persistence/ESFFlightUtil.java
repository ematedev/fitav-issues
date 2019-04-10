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

import it.ethica.esf.model.ESFFlight;

import java.util.List;

/**
 * The persistence utility for the e s f flight service. This utility wraps {@link ESFFlightPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFFlightPersistence
 * @see ESFFlightPersistenceImpl
 * @generated
 */
public class ESFFlightUtil {
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
	public static void clearCache(ESFFlight esfFlight) {
		getPersistence().clearCache(esfFlight);
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
	public static List<ESFFlight> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ESFFlight> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ESFFlight> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ESFFlight update(ESFFlight esfFlight)
		throws SystemException {
		return getPersistence().update(esfFlight);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ESFFlight update(ESFFlight esfFlight,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(esfFlight, serviceContext);
	}

	/**
	* Returns all the e s f flights where esfMatchId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @return the matching e s f flights
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFFlight> findByesfMatch(
		long esfMatchId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByesfMatch(esfMatchId);
	}

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
	public static java.util.List<it.ethica.esf.model.ESFFlight> findByesfMatch(
		long esfMatchId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByesfMatch(esfMatchId, start, end);
	}

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
	public static java.util.List<it.ethica.esf.model.ESFFlight> findByesfMatch(
		long esfMatchId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByesfMatch(esfMatchId, start, end, orderByComparator);
	}

	/**
	* Returns the first e s f flight in the ordered set where esfMatchId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f flight
	* @throws it.ethica.esf.NoSuchFlightException if a matching e s f flight could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFFlight findByesfMatch_First(
		long esfMatchId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFlightException {
		return getPersistence()
				   .findByesfMatch_First(esfMatchId, orderByComparator);
	}

	/**
	* Returns the first e s f flight in the ordered set where esfMatchId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f flight, or <code>null</code> if a matching e s f flight could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFFlight fetchByesfMatch_First(
		long esfMatchId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByesfMatch_First(esfMatchId, orderByComparator);
	}

	/**
	* Returns the last e s f flight in the ordered set where esfMatchId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f flight
	* @throws it.ethica.esf.NoSuchFlightException if a matching e s f flight could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFFlight findByesfMatch_Last(
		long esfMatchId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFlightException {
		return getPersistence()
				   .findByesfMatch_Last(esfMatchId, orderByComparator);
	}

	/**
	* Returns the last e s f flight in the ordered set where esfMatchId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f flight, or <code>null</code> if a matching e s f flight could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFFlight fetchByesfMatch_Last(
		long esfMatchId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByesfMatch_Last(esfMatchId, orderByComparator);
	}

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
	public static it.ethica.esf.model.ESFFlight[] findByesfMatch_PrevAndNext(
		long esfFlightId, long esfMatchId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFlightException {
		return getPersistence()
				   .findByesfMatch_PrevAndNext(esfFlightId, esfMatchId,
			orderByComparator);
	}

	/**
	* Removes all the e s f flights where esfMatchId = &#63; from the database.
	*
	* @param esfMatchId the esf match ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByesfMatch(long esfMatchId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByesfMatch(esfMatchId);
	}

	/**
	* Returns the number of e s f flights where esfMatchId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @return the number of matching e s f flights
	* @throws SystemException if a system exception occurred
	*/
	public static int countByesfMatch(long esfMatchId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByesfMatch(esfMatchId);
	}

	/**
	* Returns all the e s f flights where flightCode = &#63;.
	*
	* @param flightCode the flight code
	* @return the matching e s f flights
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFFlight> findByflightCode(
		java.lang.String flightCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByflightCode(flightCode);
	}

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
	public static java.util.List<it.ethica.esf.model.ESFFlight> findByflightCode(
		java.lang.String flightCode, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByflightCode(flightCode, start, end);
	}

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
	public static java.util.List<it.ethica.esf.model.ESFFlight> findByflightCode(
		java.lang.String flightCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByflightCode(flightCode, start, end, orderByComparator);
	}

	/**
	* Returns the first e s f flight in the ordered set where flightCode = &#63;.
	*
	* @param flightCode the flight code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f flight
	* @throws it.ethica.esf.NoSuchFlightException if a matching e s f flight could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFFlight findByflightCode_First(
		java.lang.String flightCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFlightException {
		return getPersistence()
				   .findByflightCode_First(flightCode, orderByComparator);
	}

	/**
	* Returns the first e s f flight in the ordered set where flightCode = &#63;.
	*
	* @param flightCode the flight code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f flight, or <code>null</code> if a matching e s f flight could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFFlight fetchByflightCode_First(
		java.lang.String flightCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByflightCode_First(flightCode, orderByComparator);
	}

	/**
	* Returns the last e s f flight in the ordered set where flightCode = &#63;.
	*
	* @param flightCode the flight code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f flight
	* @throws it.ethica.esf.NoSuchFlightException if a matching e s f flight could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFFlight findByflightCode_Last(
		java.lang.String flightCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFlightException {
		return getPersistence()
				   .findByflightCode_Last(flightCode, orderByComparator);
	}

	/**
	* Returns the last e s f flight in the ordered set where flightCode = &#63;.
	*
	* @param flightCode the flight code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f flight, or <code>null</code> if a matching e s f flight could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFFlight fetchByflightCode_Last(
		java.lang.String flightCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByflightCode_Last(flightCode, orderByComparator);
	}

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
	public static it.ethica.esf.model.ESFFlight[] findByflightCode_PrevAndNext(
		long esfFlightId, java.lang.String flightCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFlightException {
		return getPersistence()
				   .findByflightCode_PrevAndNext(esfFlightId, flightCode,
			orderByComparator);
	}

	/**
	* Removes all the e s f flights where flightCode = &#63; from the database.
	*
	* @param flightCode the flight code
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByflightCode(java.lang.String flightCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByflightCode(flightCode);
	}

	/**
	* Returns the number of e s f flights where flightCode = &#63;.
	*
	* @param flightCode the flight code
	* @return the number of matching e s f flights
	* @throws SystemException if a system exception occurred
	*/
	public static int countByflightCode(java.lang.String flightCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByflightCode(flightCode);
	}

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
	public static java.util.List<it.ethica.esf.model.ESFFlight> findByesfMatchId_F_L_L_C_D(
		long esfMatchId, java.lang.String flightCode, java.util.Date leaveDate,
		java.lang.String leaveHour, java.lang.String companyName,
		java.lang.String departureAirport)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByesfMatchId_F_L_L_C_D(esfMatchId, flightCode,
			leaveDate, leaveHour, companyName, departureAirport);
	}

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
	public static java.util.List<it.ethica.esf.model.ESFFlight> findByesfMatchId_F_L_L_C_D(
		long esfMatchId, java.lang.String flightCode, java.util.Date leaveDate,
		java.lang.String leaveHour, java.lang.String companyName,
		java.lang.String departureAirport, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByesfMatchId_F_L_L_C_D(esfMatchId, flightCode,
			leaveDate, leaveHour, companyName, departureAirport, start, end);
	}

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
	public static java.util.List<it.ethica.esf.model.ESFFlight> findByesfMatchId_F_L_L_C_D(
		long esfMatchId, java.lang.String flightCode, java.util.Date leaveDate,
		java.lang.String leaveHour, java.lang.String companyName,
		java.lang.String departureAirport, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByesfMatchId_F_L_L_C_D(esfMatchId, flightCode,
			leaveDate, leaveHour, companyName, departureAirport, start, end,
			orderByComparator);
	}

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
	public static it.ethica.esf.model.ESFFlight findByesfMatchId_F_L_L_C_D_First(
		long esfMatchId, java.lang.String flightCode, java.util.Date leaveDate,
		java.lang.String leaveHour, java.lang.String companyName,
		java.lang.String departureAirport,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFlightException {
		return getPersistence()
				   .findByesfMatchId_F_L_L_C_D_First(esfMatchId, flightCode,
			leaveDate, leaveHour, companyName, departureAirport,
			orderByComparator);
	}

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
	public static it.ethica.esf.model.ESFFlight fetchByesfMatchId_F_L_L_C_D_First(
		long esfMatchId, java.lang.String flightCode, java.util.Date leaveDate,
		java.lang.String leaveHour, java.lang.String companyName,
		java.lang.String departureAirport,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByesfMatchId_F_L_L_C_D_First(esfMatchId, flightCode,
			leaveDate, leaveHour, companyName, departureAirport,
			orderByComparator);
	}

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
	public static it.ethica.esf.model.ESFFlight findByesfMatchId_F_L_L_C_D_Last(
		long esfMatchId, java.lang.String flightCode, java.util.Date leaveDate,
		java.lang.String leaveHour, java.lang.String companyName,
		java.lang.String departureAirport,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFlightException {
		return getPersistence()
				   .findByesfMatchId_F_L_L_C_D_Last(esfMatchId, flightCode,
			leaveDate, leaveHour, companyName, departureAirport,
			orderByComparator);
	}

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
	public static it.ethica.esf.model.ESFFlight fetchByesfMatchId_F_L_L_C_D_Last(
		long esfMatchId, java.lang.String flightCode, java.util.Date leaveDate,
		java.lang.String leaveHour, java.lang.String companyName,
		java.lang.String departureAirport,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByesfMatchId_F_L_L_C_D_Last(esfMatchId, flightCode,
			leaveDate, leaveHour, companyName, departureAirport,
			orderByComparator);
	}

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
	public static it.ethica.esf.model.ESFFlight[] findByesfMatchId_F_L_L_C_D_PrevAndNext(
		long esfFlightId, long esfMatchId, java.lang.String flightCode,
		java.util.Date leaveDate, java.lang.String leaveHour,
		java.lang.String companyName, java.lang.String departureAirport,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFlightException {
		return getPersistence()
				   .findByesfMatchId_F_L_L_C_D_PrevAndNext(esfFlightId,
			esfMatchId, flightCode, leaveDate, leaveHour, companyName,
			departureAirport, orderByComparator);
	}

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
	public static void removeByesfMatchId_F_L_L_C_D(long esfMatchId,
		java.lang.String flightCode, java.util.Date leaveDate,
		java.lang.String leaveHour, java.lang.String companyName,
		java.lang.String departureAirport)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByesfMatchId_F_L_L_C_D(esfMatchId, flightCode, leaveDate,
			leaveHour, companyName, departureAirport);
	}

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
	public static int countByesfMatchId_F_L_L_C_D(long esfMatchId,
		java.lang.String flightCode, java.util.Date leaveDate,
		java.lang.String leaveHour, java.lang.String companyName,
		java.lang.String departureAirport)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByesfMatchId_F_L_L_C_D(esfMatchId, flightCode,
			leaveDate, leaveHour, companyName, departureAirport);
	}

	/**
	* Returns all the e s f flights where esfMatchId = &#63; and esfUserId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfUserId the esf user ID
	* @return the matching e s f flights
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFFlight> findByesfMatchEsfUser(
		long esfMatchId, long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByesfMatchEsfUser(esfMatchId, esfUserId);
	}

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
	public static java.util.List<it.ethica.esf.model.ESFFlight> findByesfMatchEsfUser(
		long esfMatchId, long esfUserId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByesfMatchEsfUser(esfMatchId, esfUserId, start, end);
	}

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
	public static java.util.List<it.ethica.esf.model.ESFFlight> findByesfMatchEsfUser(
		long esfMatchId, long esfUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByesfMatchEsfUser(esfMatchId, esfUserId, start, end,
			orderByComparator);
	}

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
	public static it.ethica.esf.model.ESFFlight findByesfMatchEsfUser_First(
		long esfMatchId, long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFlightException {
		return getPersistence()
				   .findByesfMatchEsfUser_First(esfMatchId, esfUserId,
			orderByComparator);
	}

	/**
	* Returns the first e s f flight in the ordered set where esfMatchId = &#63; and esfUserId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f flight, or <code>null</code> if a matching e s f flight could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFFlight fetchByesfMatchEsfUser_First(
		long esfMatchId, long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByesfMatchEsfUser_First(esfMatchId, esfUserId,
			orderByComparator);
	}

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
	public static it.ethica.esf.model.ESFFlight findByesfMatchEsfUser_Last(
		long esfMatchId, long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFlightException {
		return getPersistence()
				   .findByesfMatchEsfUser_Last(esfMatchId, esfUserId,
			orderByComparator);
	}

	/**
	* Returns the last e s f flight in the ordered set where esfMatchId = &#63; and esfUserId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f flight, or <code>null</code> if a matching e s f flight could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFFlight fetchByesfMatchEsfUser_Last(
		long esfMatchId, long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByesfMatchEsfUser_Last(esfMatchId, esfUserId,
			orderByComparator);
	}

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
	public static it.ethica.esf.model.ESFFlight[] findByesfMatchEsfUser_PrevAndNext(
		long esfFlightId, long esfMatchId, long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFlightException {
		return getPersistence()
				   .findByesfMatchEsfUser_PrevAndNext(esfFlightId, esfMatchId,
			esfUserId, orderByComparator);
	}

	/**
	* Removes all the e s f flights where esfMatchId = &#63; and esfUserId = &#63; from the database.
	*
	* @param esfMatchId the esf match ID
	* @param esfUserId the esf user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByesfMatchEsfUser(long esfMatchId, long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByesfMatchEsfUser(esfMatchId, esfUserId);
	}

	/**
	* Returns the number of e s f flights where esfMatchId = &#63; and esfUserId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfUserId the esf user ID
	* @return the number of matching e s f flights
	* @throws SystemException if a system exception occurred
	*/
	public static int countByesfMatchEsfUser(long esfMatchId, long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByesfMatchEsfUser(esfMatchId, esfUserId);
	}

	/**
	* Caches the e s f flight in the entity cache if it is enabled.
	*
	* @param esfFlight the e s f flight
	*/
	public static void cacheResult(it.ethica.esf.model.ESFFlight esfFlight) {
		getPersistence().cacheResult(esfFlight);
	}

	/**
	* Caches the e s f flights in the entity cache if it is enabled.
	*
	* @param esfFlights the e s f flights
	*/
	public static void cacheResult(
		java.util.List<it.ethica.esf.model.ESFFlight> esfFlights) {
		getPersistence().cacheResult(esfFlights);
	}

	/**
	* Creates a new e s f flight with the primary key. Does not add the e s f flight to the database.
	*
	* @param esfFlightId the primary key for the new e s f flight
	* @return the new e s f flight
	*/
	public static it.ethica.esf.model.ESFFlight create(long esfFlightId) {
		return getPersistence().create(esfFlightId);
	}

	/**
	* Removes the e s f flight with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfFlightId the primary key of the e s f flight
	* @return the e s f flight that was removed
	* @throws it.ethica.esf.NoSuchFlightException if a e s f flight with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFFlight remove(long esfFlightId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFlightException {
		return getPersistence().remove(esfFlightId);
	}

	public static it.ethica.esf.model.ESFFlight updateImpl(
		it.ethica.esf.model.ESFFlight esfFlight)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(esfFlight);
	}

	/**
	* Returns the e s f flight with the primary key or throws a {@link it.ethica.esf.NoSuchFlightException} if it could not be found.
	*
	* @param esfFlightId the primary key of the e s f flight
	* @return the e s f flight
	* @throws it.ethica.esf.NoSuchFlightException if a e s f flight with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFFlight findByPrimaryKey(
		long esfFlightId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFlightException {
		return getPersistence().findByPrimaryKey(esfFlightId);
	}

	/**
	* Returns the e s f flight with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param esfFlightId the primary key of the e s f flight
	* @return the e s f flight, or <code>null</code> if a e s f flight with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFFlight fetchByPrimaryKey(
		long esfFlightId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(esfFlightId);
	}

	/**
	* Returns all the e s f flights.
	*
	* @return the e s f flights
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFFlight> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<it.ethica.esf.model.ESFFlight> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<it.ethica.esf.model.ESFFlight> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the e s f flights from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of e s f flights.
	*
	* @return the number of e s f flights
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ESFFlightPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ESFFlightPersistence)PortletBeanLocatorUtil.locate(it.ethica.esf.service.ClpSerializer.getServletContextName(),
					ESFFlightPersistence.class.getName());

			ReferenceRegistry.registerReference(ESFFlightUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ESFFlightPersistence persistence) {
	}

	private static ESFFlightPersistence _persistence;
}