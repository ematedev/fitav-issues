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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import it.ethica.esf.model.ESFDeparture;

import java.util.List;

/**
 * The persistence utility for the e s f departure service. This utility wraps {@link ESFDeparturePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFDeparturePersistence
 * @see ESFDeparturePersistenceImpl
 * @generated
 */
public class ESFDepartureUtil {
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
	public static void clearCache(ESFDeparture esfDeparture) {
		getPersistence().clearCache(esfDeparture);
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
	public static List<ESFDeparture> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ESFDeparture> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ESFDeparture> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ESFDeparture update(ESFDeparture esfDeparture)
		throws SystemException {
		return getPersistence().update(esfDeparture);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ESFDeparture update(ESFDeparture esfDeparture,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(esfDeparture, serviceContext);
	}

	/**
	* Returns all the e s f departures where esfMatchId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @return the matching e s f departures
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFDeparture> findByesfMatch(
		long esfMatchId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByesfMatch(esfMatchId);
	}

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
	public static java.util.List<it.ethica.esf.model.ESFDeparture> findByesfMatch(
		long esfMatchId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByesfMatch(esfMatchId, start, end);
	}

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
	public static java.util.List<it.ethica.esf.model.ESFDeparture> findByesfMatch(
		long esfMatchId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByesfMatch(esfMatchId, start, end, orderByComparator);
	}

	/**
	* Returns the first e s f departure in the ordered set where esfMatchId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f departure
	* @throws it.ethica.esf.NoSuchDepartureException if a matching e s f departure could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFDeparture findByesfMatch_First(
		long esfMatchId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchDepartureException {
		return getPersistence()
				   .findByesfMatch_First(esfMatchId, orderByComparator);
	}

	/**
	* Returns the first e s f departure in the ordered set where esfMatchId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f departure, or <code>null</code> if a matching e s f departure could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFDeparture fetchByesfMatch_First(
		long esfMatchId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByesfMatch_First(esfMatchId, orderByComparator);
	}

	/**
	* Returns the last e s f departure in the ordered set where esfMatchId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f departure
	* @throws it.ethica.esf.NoSuchDepartureException if a matching e s f departure could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFDeparture findByesfMatch_Last(
		long esfMatchId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchDepartureException {
		return getPersistence()
				   .findByesfMatch_Last(esfMatchId, orderByComparator);
	}

	/**
	* Returns the last e s f departure in the ordered set where esfMatchId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f departure, or <code>null</code> if a matching e s f departure could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFDeparture fetchByesfMatch_Last(
		long esfMatchId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByesfMatch_Last(esfMatchId, orderByComparator);
	}

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
	public static it.ethica.esf.model.ESFDeparture[] findByesfMatch_PrevAndNext(
		long esfDepartureId, long esfMatchId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchDepartureException {
		return getPersistence()
				   .findByesfMatch_PrevAndNext(esfDepartureId, esfMatchId,
			orderByComparator);
	}

	/**
	* Removes all the e s f departures where esfMatchId = &#63; from the database.
	*
	* @param esfMatchId the esf match ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByesfMatch(long esfMatchId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByesfMatch(esfMatchId);
	}

	/**
	* Returns the number of e s f departures where esfMatchId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @return the number of matching e s f departures
	* @throws SystemException if a system exception occurred
	*/
	public static int countByesfMatch(long esfMatchId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByesfMatch(esfMatchId);
	}

	/**
	* Returns all the e s f departures where code = &#63;.
	*
	* @param code the code
	* @return the matching e s f departures
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFDeparture> findBycode(
		java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBycode(code);
	}

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
	public static java.util.List<it.ethica.esf.model.ESFDeparture> findBycode(
		java.lang.String code, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBycode(code, start, end);
	}

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
	public static java.util.List<it.ethica.esf.model.ESFDeparture> findBycode(
		java.lang.String code, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBycode(code, start, end, orderByComparator);
	}

	/**
	* Returns the first e s f departure in the ordered set where code = &#63;.
	*
	* @param code the code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f departure
	* @throws it.ethica.esf.NoSuchDepartureException if a matching e s f departure could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFDeparture findBycode_First(
		java.lang.String code,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchDepartureException {
		return getPersistence().findBycode_First(code, orderByComparator);
	}

	/**
	* Returns the first e s f departure in the ordered set where code = &#63;.
	*
	* @param code the code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f departure, or <code>null</code> if a matching e s f departure could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFDeparture fetchBycode_First(
		java.lang.String code,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchBycode_First(code, orderByComparator);
	}

	/**
	* Returns the last e s f departure in the ordered set where code = &#63;.
	*
	* @param code the code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f departure
	* @throws it.ethica.esf.NoSuchDepartureException if a matching e s f departure could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFDeparture findBycode_Last(
		java.lang.String code,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchDepartureException {
		return getPersistence().findBycode_Last(code, orderByComparator);
	}

	/**
	* Returns the last e s f departure in the ordered set where code = &#63;.
	*
	* @param code the code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f departure, or <code>null</code> if a matching e s f departure could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFDeparture fetchBycode_Last(
		java.lang.String code,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchBycode_Last(code, orderByComparator);
	}

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
	public static it.ethica.esf.model.ESFDeparture[] findBycode_PrevAndNext(
		long esfDepartureId, java.lang.String code,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchDepartureException {
		return getPersistence()
				   .findBycode_PrevAndNext(esfDepartureId, code,
			orderByComparator);
	}

	/**
	* Removes all the e s f departures where code = &#63; from the database.
	*
	* @param code the code
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBycode(java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBycode(code);
	}

	/**
	* Returns the number of e s f departures where code = &#63;.
	*
	* @param code the code
	* @return the number of matching e s f departures
	* @throws SystemException if a system exception occurred
	*/
	public static int countBycode(java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBycode(code);
	}

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
	public static java.util.List<it.ethica.esf.model.ESFDeparture> findByesfMatchId_C_L_L_C_D(
		long esfMatchId, java.lang.String code, java.util.Date leaveDate,
		java.lang.String leaveHour, java.lang.String companyName,
		java.lang.String departureFrom)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByesfMatchId_C_L_L_C_D(esfMatchId, code, leaveDate,
			leaveHour, companyName, departureFrom);
	}

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
	public static java.util.List<it.ethica.esf.model.ESFDeparture> findByesfMatchId_C_L_L_C_D(
		long esfMatchId, java.lang.String code, java.util.Date leaveDate,
		java.lang.String leaveHour, java.lang.String companyName,
		java.lang.String departureFrom, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByesfMatchId_C_L_L_C_D(esfMatchId, code, leaveDate,
			leaveHour, companyName, departureFrom, start, end);
	}

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
	public static java.util.List<it.ethica.esf.model.ESFDeparture> findByesfMatchId_C_L_L_C_D(
		long esfMatchId, java.lang.String code, java.util.Date leaveDate,
		java.lang.String leaveHour, java.lang.String companyName,
		java.lang.String departureFrom, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByesfMatchId_C_L_L_C_D(esfMatchId, code, leaveDate,
			leaveHour, companyName, departureFrom, start, end, orderByComparator);
	}

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
	public static it.ethica.esf.model.ESFDeparture findByesfMatchId_C_L_L_C_D_First(
		long esfMatchId, java.lang.String code, java.util.Date leaveDate,
		java.lang.String leaveHour, java.lang.String companyName,
		java.lang.String departureFrom,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchDepartureException {
		return getPersistence()
				   .findByesfMatchId_C_L_L_C_D_First(esfMatchId, code,
			leaveDate, leaveHour, companyName, departureFrom, orderByComparator);
	}

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
	public static it.ethica.esf.model.ESFDeparture fetchByesfMatchId_C_L_L_C_D_First(
		long esfMatchId, java.lang.String code, java.util.Date leaveDate,
		java.lang.String leaveHour, java.lang.String companyName,
		java.lang.String departureFrom,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByesfMatchId_C_L_L_C_D_First(esfMatchId, code,
			leaveDate, leaveHour, companyName, departureFrom, orderByComparator);
	}

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
	public static it.ethica.esf.model.ESFDeparture findByesfMatchId_C_L_L_C_D_Last(
		long esfMatchId, java.lang.String code, java.util.Date leaveDate,
		java.lang.String leaveHour, java.lang.String companyName,
		java.lang.String departureFrom,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchDepartureException {
		return getPersistence()
				   .findByesfMatchId_C_L_L_C_D_Last(esfMatchId, code,
			leaveDate, leaveHour, companyName, departureFrom, orderByComparator);
	}

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
	public static it.ethica.esf.model.ESFDeparture fetchByesfMatchId_C_L_L_C_D_Last(
		long esfMatchId, java.lang.String code, java.util.Date leaveDate,
		java.lang.String leaveHour, java.lang.String companyName,
		java.lang.String departureFrom,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByesfMatchId_C_L_L_C_D_Last(esfMatchId, code,
			leaveDate, leaveHour, companyName, departureFrom, orderByComparator);
	}

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
	public static it.ethica.esf.model.ESFDeparture[] findByesfMatchId_C_L_L_C_D_PrevAndNext(
		long esfDepartureId, long esfMatchId, java.lang.String code,
		java.util.Date leaveDate, java.lang.String leaveHour,
		java.lang.String companyName, java.lang.String departureFrom,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchDepartureException {
		return getPersistence()
				   .findByesfMatchId_C_L_L_C_D_PrevAndNext(esfDepartureId,
			esfMatchId, code, leaveDate, leaveHour, companyName, departureFrom,
			orderByComparator);
	}

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
	public static void removeByesfMatchId_C_L_L_C_D(long esfMatchId,
		java.lang.String code, java.util.Date leaveDate,
		java.lang.String leaveHour, java.lang.String companyName,
		java.lang.String departureFrom)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByesfMatchId_C_L_L_C_D(esfMatchId, code, leaveDate,
			leaveHour, companyName, departureFrom);
	}

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
	public static int countByesfMatchId_C_L_L_C_D(long esfMatchId,
		java.lang.String code, java.util.Date leaveDate,
		java.lang.String leaveHour, java.lang.String companyName,
		java.lang.String departureFrom)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByesfMatchId_C_L_L_C_D(esfMatchId, code, leaveDate,
			leaveHour, companyName, departureFrom);
	}

	/**
	* Returns all the e s f departures where esfMatchId = &#63; and esfUserId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfUserId the esf user ID
	* @return the matching e s f departures
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFDeparture> findByesfMatchEsfUser(
		long esfMatchId, long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByesfMatchEsfUser(esfMatchId, esfUserId);
	}

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
	public static java.util.List<it.ethica.esf.model.ESFDeparture> findByesfMatchEsfUser(
		long esfMatchId, long esfUserId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByesfMatchEsfUser(esfMatchId, esfUserId, start, end);
	}

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
	public static java.util.List<it.ethica.esf.model.ESFDeparture> findByesfMatchEsfUser(
		long esfMatchId, long esfUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByesfMatchEsfUser(esfMatchId, esfUserId, start, end,
			orderByComparator);
	}

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
	public static it.ethica.esf.model.ESFDeparture findByesfMatchEsfUser_First(
		long esfMatchId, long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchDepartureException {
		return getPersistence()
				   .findByesfMatchEsfUser_First(esfMatchId, esfUserId,
			orderByComparator);
	}

	/**
	* Returns the first e s f departure in the ordered set where esfMatchId = &#63; and esfUserId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f departure, or <code>null</code> if a matching e s f departure could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFDeparture fetchByesfMatchEsfUser_First(
		long esfMatchId, long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByesfMatchEsfUser_First(esfMatchId, esfUserId,
			orderByComparator);
	}

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
	public static it.ethica.esf.model.ESFDeparture findByesfMatchEsfUser_Last(
		long esfMatchId, long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchDepartureException {
		return getPersistence()
				   .findByesfMatchEsfUser_Last(esfMatchId, esfUserId,
			orderByComparator);
	}

	/**
	* Returns the last e s f departure in the ordered set where esfMatchId = &#63; and esfUserId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f departure, or <code>null</code> if a matching e s f departure could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFDeparture fetchByesfMatchEsfUser_Last(
		long esfMatchId, long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByesfMatchEsfUser_Last(esfMatchId, esfUserId,
			orderByComparator);
	}

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
	public static it.ethica.esf.model.ESFDeparture[] findByesfMatchEsfUser_PrevAndNext(
		long esfDepartureId, long esfMatchId, long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchDepartureException {
		return getPersistence()
				   .findByesfMatchEsfUser_PrevAndNext(esfDepartureId,
			esfMatchId, esfUserId, orderByComparator);
	}

	/**
	* Removes all the e s f departures where esfMatchId = &#63; and esfUserId = &#63; from the database.
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
	* Returns the number of e s f departures where esfMatchId = &#63; and esfUserId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfUserId the esf user ID
	* @return the number of matching e s f departures
	* @throws SystemException if a system exception occurred
	*/
	public static int countByesfMatchEsfUser(long esfMatchId, long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByesfMatchEsfUser(esfMatchId, esfUserId);
	}

	/**
	* Caches the e s f departure in the entity cache if it is enabled.
	*
	* @param esfDeparture the e s f departure
	*/
	public static void cacheResult(
		it.ethica.esf.model.ESFDeparture esfDeparture) {
		getPersistence().cacheResult(esfDeparture);
	}

	/**
	* Caches the e s f departures in the entity cache if it is enabled.
	*
	* @param esfDepartures the e s f departures
	*/
	public static void cacheResult(
		java.util.List<it.ethica.esf.model.ESFDeparture> esfDepartures) {
		getPersistence().cacheResult(esfDepartures);
	}

	/**
	* Creates a new e s f departure with the primary key. Does not add the e s f departure to the database.
	*
	* @param esfDepartureId the primary key for the new e s f departure
	* @return the new e s f departure
	*/
	public static it.ethica.esf.model.ESFDeparture create(long esfDepartureId) {
		return getPersistence().create(esfDepartureId);
	}

	/**
	* Removes the e s f departure with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfDepartureId the primary key of the e s f departure
	* @return the e s f departure that was removed
	* @throws it.ethica.esf.NoSuchDepartureException if a e s f departure with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFDeparture remove(long esfDepartureId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchDepartureException {
		return getPersistence().remove(esfDepartureId);
	}

	public static it.ethica.esf.model.ESFDeparture updateImpl(
		it.ethica.esf.model.ESFDeparture esfDeparture)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(esfDeparture);
	}

	/**
	* Returns the e s f departure with the primary key or throws a {@link it.ethica.esf.NoSuchDepartureException} if it could not be found.
	*
	* @param esfDepartureId the primary key of the e s f departure
	* @return the e s f departure
	* @throws it.ethica.esf.NoSuchDepartureException if a e s f departure with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFDeparture findByPrimaryKey(
		long esfDepartureId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchDepartureException {
		return getPersistence().findByPrimaryKey(esfDepartureId);
	}

	/**
	* Returns the e s f departure with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param esfDepartureId the primary key of the e s f departure
	* @return the e s f departure, or <code>null</code> if a e s f departure with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFDeparture fetchByPrimaryKey(
		long esfDepartureId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(esfDepartureId);
	}

	/**
	* Returns all the e s f departures.
	*
	* @return the e s f departures
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFDeparture> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<it.ethica.esf.model.ESFDeparture> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<it.ethica.esf.model.ESFDeparture> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the e s f departures from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of e s f departures.
	*
	* @return the number of e s f departures
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ESFDeparturePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ESFDeparturePersistence)PortletBeanLocatorUtil.locate(it.ethica.esf.service.ClpSerializer.getServletContextName(),
					ESFDeparturePersistence.class.getName());

			ReferenceRegistry.registerReference(ESFDepartureUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ESFDeparturePersistence persistence) {
	}

	private static ESFDeparturePersistence _persistence;
}