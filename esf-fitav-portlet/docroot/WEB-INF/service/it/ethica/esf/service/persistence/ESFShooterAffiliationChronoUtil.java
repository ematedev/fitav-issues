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

import it.ethica.esf.model.ESFShooterAffiliationChrono;

import java.util.List;

/**
 * The persistence utility for the e s f shooter affiliation chrono service. This utility wraps {@link ESFShooterAffiliationChronoPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFShooterAffiliationChronoPersistence
 * @see ESFShooterAffiliationChronoPersistenceImpl
 * @generated
 */
public class ESFShooterAffiliationChronoUtil {
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
	public static void clearCache(
		ESFShooterAffiliationChrono esfShooterAffiliationChrono) {
		getPersistence().clearCache(esfShooterAffiliationChrono);
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
	public static List<ESFShooterAffiliationChrono> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ESFShooterAffiliationChrono> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ESFShooterAffiliationChrono> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ESFShooterAffiliationChrono update(
		ESFShooterAffiliationChrono esfShooterAffiliationChrono)
		throws SystemException {
		return getPersistence().update(esfShooterAffiliationChrono);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ESFShooterAffiliationChrono update(
		ESFShooterAffiliationChrono esfShooterAffiliationChrono,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence()
				   .update(esfShooterAffiliationChrono, serviceContext);
	}

	/**
	* Returns all the e s f shooter affiliation chronos where esfuserId = &#63; and year = &#63;.
	*
	* @param esfuserId the esfuser ID
	* @param year the year
	* @return the matching e s f shooter affiliation chronos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFShooterAffiliationChrono> findByUserIdYear(
		long esfuserId, int year)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserIdYear(esfuserId, year);
	}

	/**
	* Returns a range of all the e s f shooter affiliation chronos where esfuserId = &#63; and year = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShooterAffiliationChronoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfuserId the esfuser ID
	* @param year the year
	* @param start the lower bound of the range of e s f shooter affiliation chronos
	* @param end the upper bound of the range of e s f shooter affiliation chronos (not inclusive)
	* @return the range of matching e s f shooter affiliation chronos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFShooterAffiliationChrono> findByUserIdYear(
		long esfuserId, int year, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserIdYear(esfuserId, year, start, end);
	}

	/**
	* Returns an ordered range of all the e s f shooter affiliation chronos where esfuserId = &#63; and year = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShooterAffiliationChronoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfuserId the esfuser ID
	* @param year the year
	* @param start the lower bound of the range of e s f shooter affiliation chronos
	* @param end the upper bound of the range of e s f shooter affiliation chronos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f shooter affiliation chronos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFShooterAffiliationChrono> findByUserIdYear(
		long esfuserId, int year, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserIdYear(esfuserId, year, start, end,
			orderByComparator);
	}

	/**
	* Returns the first e s f shooter affiliation chrono in the ordered set where esfuserId = &#63; and year = &#63;.
	*
	* @param esfuserId the esfuser ID
	* @param year the year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f shooter affiliation chrono
	* @throws it.ethica.esf.NoSuchShooterAffiliationChronoException if a matching e s f shooter affiliation chrono could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFShooterAffiliationChrono findByUserIdYear_First(
		long esfuserId, int year,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchShooterAffiliationChronoException {
		return getPersistence()
				   .findByUserIdYear_First(esfuserId, year, orderByComparator);
	}

	/**
	* Returns the first e s f shooter affiliation chrono in the ordered set where esfuserId = &#63; and year = &#63;.
	*
	* @param esfuserId the esfuser ID
	* @param year the year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f shooter affiliation chrono, or <code>null</code> if a matching e s f shooter affiliation chrono could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFShooterAffiliationChrono fetchByUserIdYear_First(
		long esfuserId, int year,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUserIdYear_First(esfuserId, year, orderByComparator);
	}

	/**
	* Returns the last e s f shooter affiliation chrono in the ordered set where esfuserId = &#63; and year = &#63;.
	*
	* @param esfuserId the esfuser ID
	* @param year the year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f shooter affiliation chrono
	* @throws it.ethica.esf.NoSuchShooterAffiliationChronoException if a matching e s f shooter affiliation chrono could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFShooterAffiliationChrono findByUserIdYear_Last(
		long esfuserId, int year,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchShooterAffiliationChronoException {
		return getPersistence()
				   .findByUserIdYear_Last(esfuserId, year, orderByComparator);
	}

	/**
	* Returns the last e s f shooter affiliation chrono in the ordered set where esfuserId = &#63; and year = &#63;.
	*
	* @param esfuserId the esfuser ID
	* @param year the year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f shooter affiliation chrono, or <code>null</code> if a matching e s f shooter affiliation chrono could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFShooterAffiliationChrono fetchByUserIdYear_Last(
		long esfuserId, int year,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUserIdYear_Last(esfuserId, year, orderByComparator);
	}

	/**
	* Returns the e s f shooter affiliation chronos before and after the current e s f shooter affiliation chrono in the ordered set where esfuserId = &#63; and year = &#63;.
	*
	* @param esfShooterAffiliationChronoId the primary key of the current e s f shooter affiliation chrono
	* @param esfuserId the esfuser ID
	* @param year the year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f shooter affiliation chrono
	* @throws it.ethica.esf.NoSuchShooterAffiliationChronoException if a e s f shooter affiliation chrono with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFShooterAffiliationChrono[] findByUserIdYear_PrevAndNext(
		long esfShooterAffiliationChronoId, long esfuserId, int year,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchShooterAffiliationChronoException {
		return getPersistence()
				   .findByUserIdYear_PrevAndNext(esfShooterAffiliationChronoId,
			esfuserId, year, orderByComparator);
	}

	/**
	* Removes all the e s f shooter affiliation chronos where esfuserId = &#63; and year = &#63; from the database.
	*
	* @param esfuserId the esfuser ID
	* @param year the year
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUserIdYear(long esfuserId, int year)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUserIdYear(esfuserId, year);
	}

	/**
	* Returns the number of e s f shooter affiliation chronos where esfuserId = &#63; and year = &#63;.
	*
	* @param esfuserId the esfuser ID
	* @param year the year
	* @return the number of matching e s f shooter affiliation chronos
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserIdYear(long esfuserId, int year)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUserIdYear(esfuserId, year);
	}

	/**
	* Returns all the e s f shooter affiliation chronos where card = &#63; and year = &#63;.
	*
	* @param card the card
	* @param year the year
	* @return the matching e s f shooter affiliation chronos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFShooterAffiliationChrono> findByCardYear(
		java.lang.String card, int year)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCardYear(card, year);
	}

	/**
	* Returns a range of all the e s f shooter affiliation chronos where card = &#63; and year = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShooterAffiliationChronoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param card the card
	* @param year the year
	* @param start the lower bound of the range of e s f shooter affiliation chronos
	* @param end the upper bound of the range of e s f shooter affiliation chronos (not inclusive)
	* @return the range of matching e s f shooter affiliation chronos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFShooterAffiliationChrono> findByCardYear(
		java.lang.String card, int year, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCardYear(card, year, start, end);
	}

	/**
	* Returns an ordered range of all the e s f shooter affiliation chronos where card = &#63; and year = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShooterAffiliationChronoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param card the card
	* @param year the year
	* @param start the lower bound of the range of e s f shooter affiliation chronos
	* @param end the upper bound of the range of e s f shooter affiliation chronos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f shooter affiliation chronos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFShooterAffiliationChrono> findByCardYear(
		java.lang.String card, int year, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCardYear(card, year, start, end, orderByComparator);
	}

	/**
	* Returns the first e s f shooter affiliation chrono in the ordered set where card = &#63; and year = &#63;.
	*
	* @param card the card
	* @param year the year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f shooter affiliation chrono
	* @throws it.ethica.esf.NoSuchShooterAffiliationChronoException if a matching e s f shooter affiliation chrono could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFShooterAffiliationChrono findByCardYear_First(
		java.lang.String card, int year,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchShooterAffiliationChronoException {
		return getPersistence()
				   .findByCardYear_First(card, year, orderByComparator);
	}

	/**
	* Returns the first e s f shooter affiliation chrono in the ordered set where card = &#63; and year = &#63;.
	*
	* @param card the card
	* @param year the year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f shooter affiliation chrono, or <code>null</code> if a matching e s f shooter affiliation chrono could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFShooterAffiliationChrono fetchByCardYear_First(
		java.lang.String card, int year,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCardYear_First(card, year, orderByComparator);
	}

	/**
	* Returns the last e s f shooter affiliation chrono in the ordered set where card = &#63; and year = &#63;.
	*
	* @param card the card
	* @param year the year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f shooter affiliation chrono
	* @throws it.ethica.esf.NoSuchShooterAffiliationChronoException if a matching e s f shooter affiliation chrono could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFShooterAffiliationChrono findByCardYear_Last(
		java.lang.String card, int year,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchShooterAffiliationChronoException {
		return getPersistence()
				   .findByCardYear_Last(card, year, orderByComparator);
	}

	/**
	* Returns the last e s f shooter affiliation chrono in the ordered set where card = &#63; and year = &#63;.
	*
	* @param card the card
	* @param year the year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f shooter affiliation chrono, or <code>null</code> if a matching e s f shooter affiliation chrono could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFShooterAffiliationChrono fetchByCardYear_Last(
		java.lang.String card, int year,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCardYear_Last(card, year, orderByComparator);
	}

	/**
	* Returns the e s f shooter affiliation chronos before and after the current e s f shooter affiliation chrono in the ordered set where card = &#63; and year = &#63;.
	*
	* @param esfShooterAffiliationChronoId the primary key of the current e s f shooter affiliation chrono
	* @param card the card
	* @param year the year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f shooter affiliation chrono
	* @throws it.ethica.esf.NoSuchShooterAffiliationChronoException if a e s f shooter affiliation chrono with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFShooterAffiliationChrono[] findByCardYear_PrevAndNext(
		long esfShooterAffiliationChronoId, java.lang.String card, int year,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchShooterAffiliationChronoException {
		return getPersistence()
				   .findByCardYear_PrevAndNext(esfShooterAffiliationChronoId,
			card, year, orderByComparator);
	}

	/**
	* Removes all the e s f shooter affiliation chronos where card = &#63; and year = &#63; from the database.
	*
	* @param card the card
	* @param year the year
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCardYear(java.lang.String card, int year)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCardYear(card, year);
	}

	/**
	* Returns the number of e s f shooter affiliation chronos where card = &#63; and year = &#63;.
	*
	* @param card the card
	* @param year the year
	* @return the number of matching e s f shooter affiliation chronos
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCardYear(java.lang.String card, int year)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCardYear(card, year);
	}

	/**
	* Returns all the e s f shooter affiliation chronos where affiliationDate = &#63;.
	*
	* @param affiliationDate the affiliation date
	* @return the matching e s f shooter affiliation chronos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFShooterAffiliationChrono> findByDate(
		java.util.Date affiliationDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDate(affiliationDate);
	}

	/**
	* Returns a range of all the e s f shooter affiliation chronos where affiliationDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShooterAffiliationChronoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param affiliationDate the affiliation date
	* @param start the lower bound of the range of e s f shooter affiliation chronos
	* @param end the upper bound of the range of e s f shooter affiliation chronos (not inclusive)
	* @return the range of matching e s f shooter affiliation chronos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFShooterAffiliationChrono> findByDate(
		java.util.Date affiliationDate, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDate(affiliationDate, start, end);
	}

	/**
	* Returns an ordered range of all the e s f shooter affiliation chronos where affiliationDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShooterAffiliationChronoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param affiliationDate the affiliation date
	* @param start the lower bound of the range of e s f shooter affiliation chronos
	* @param end the upper bound of the range of e s f shooter affiliation chronos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f shooter affiliation chronos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFShooterAffiliationChrono> findByDate(
		java.util.Date affiliationDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDate(affiliationDate, start, end, orderByComparator);
	}

	/**
	* Returns the first e s f shooter affiliation chrono in the ordered set where affiliationDate = &#63;.
	*
	* @param affiliationDate the affiliation date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f shooter affiliation chrono
	* @throws it.ethica.esf.NoSuchShooterAffiliationChronoException if a matching e s f shooter affiliation chrono could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFShooterAffiliationChrono findByDate_First(
		java.util.Date affiliationDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchShooterAffiliationChronoException {
		return getPersistence()
				   .findByDate_First(affiliationDate, orderByComparator);
	}

	/**
	* Returns the first e s f shooter affiliation chrono in the ordered set where affiliationDate = &#63;.
	*
	* @param affiliationDate the affiliation date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f shooter affiliation chrono, or <code>null</code> if a matching e s f shooter affiliation chrono could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFShooterAffiliationChrono fetchByDate_First(
		java.util.Date affiliationDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByDate_First(affiliationDate, orderByComparator);
	}

	/**
	* Returns the last e s f shooter affiliation chrono in the ordered set where affiliationDate = &#63;.
	*
	* @param affiliationDate the affiliation date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f shooter affiliation chrono
	* @throws it.ethica.esf.NoSuchShooterAffiliationChronoException if a matching e s f shooter affiliation chrono could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFShooterAffiliationChrono findByDate_Last(
		java.util.Date affiliationDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchShooterAffiliationChronoException {
		return getPersistence()
				   .findByDate_Last(affiliationDate, orderByComparator);
	}

	/**
	* Returns the last e s f shooter affiliation chrono in the ordered set where affiliationDate = &#63;.
	*
	* @param affiliationDate the affiliation date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f shooter affiliation chrono, or <code>null</code> if a matching e s f shooter affiliation chrono could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFShooterAffiliationChrono fetchByDate_Last(
		java.util.Date affiliationDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByDate_Last(affiliationDate, orderByComparator);
	}

	/**
	* Returns the e s f shooter affiliation chronos before and after the current e s f shooter affiliation chrono in the ordered set where affiliationDate = &#63;.
	*
	* @param esfShooterAffiliationChronoId the primary key of the current e s f shooter affiliation chrono
	* @param affiliationDate the affiliation date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f shooter affiliation chrono
	* @throws it.ethica.esf.NoSuchShooterAffiliationChronoException if a e s f shooter affiliation chrono with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFShooterAffiliationChrono[] findByDate_PrevAndNext(
		long esfShooterAffiliationChronoId, java.util.Date affiliationDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchShooterAffiliationChronoException {
		return getPersistence()
				   .findByDate_PrevAndNext(esfShooterAffiliationChronoId,
			affiliationDate, orderByComparator);
	}

	/**
	* Removes all the e s f shooter affiliation chronos where affiliationDate = &#63; from the database.
	*
	* @param affiliationDate the affiliation date
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByDate(java.util.Date affiliationDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByDate(affiliationDate);
	}

	/**
	* Returns the number of e s f shooter affiliation chronos where affiliationDate = &#63;.
	*
	* @param affiliationDate the affiliation date
	* @return the number of matching e s f shooter affiliation chronos
	* @throws SystemException if a system exception occurred
	*/
	public static int countByDate(java.util.Date affiliationDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByDate(affiliationDate);
	}

	/**
	* Caches the e s f shooter affiliation chrono in the entity cache if it is enabled.
	*
	* @param esfShooterAffiliationChrono the e s f shooter affiliation chrono
	*/
	public static void cacheResult(
		it.ethica.esf.model.ESFShooterAffiliationChrono esfShooterAffiliationChrono) {
		getPersistence().cacheResult(esfShooterAffiliationChrono);
	}

	/**
	* Caches the e s f shooter affiliation chronos in the entity cache if it is enabled.
	*
	* @param esfShooterAffiliationChronos the e s f shooter affiliation chronos
	*/
	public static void cacheResult(
		java.util.List<it.ethica.esf.model.ESFShooterAffiliationChrono> esfShooterAffiliationChronos) {
		getPersistence().cacheResult(esfShooterAffiliationChronos);
	}

	/**
	* Creates a new e s f shooter affiliation chrono with the primary key. Does not add the e s f shooter affiliation chrono to the database.
	*
	* @param esfShooterAffiliationChronoId the primary key for the new e s f shooter affiliation chrono
	* @return the new e s f shooter affiliation chrono
	*/
	public static it.ethica.esf.model.ESFShooterAffiliationChrono create(
		long esfShooterAffiliationChronoId) {
		return getPersistence().create(esfShooterAffiliationChronoId);
	}

	/**
	* Removes the e s f shooter affiliation chrono with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfShooterAffiliationChronoId the primary key of the e s f shooter affiliation chrono
	* @return the e s f shooter affiliation chrono that was removed
	* @throws it.ethica.esf.NoSuchShooterAffiliationChronoException if a e s f shooter affiliation chrono with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFShooterAffiliationChrono remove(
		long esfShooterAffiliationChronoId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchShooterAffiliationChronoException {
		return getPersistence().remove(esfShooterAffiliationChronoId);
	}

	public static it.ethica.esf.model.ESFShooterAffiliationChrono updateImpl(
		it.ethica.esf.model.ESFShooterAffiliationChrono esfShooterAffiliationChrono)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(esfShooterAffiliationChrono);
	}

	/**
	* Returns the e s f shooter affiliation chrono with the primary key or throws a {@link it.ethica.esf.NoSuchShooterAffiliationChronoException} if it could not be found.
	*
	* @param esfShooterAffiliationChronoId the primary key of the e s f shooter affiliation chrono
	* @return the e s f shooter affiliation chrono
	* @throws it.ethica.esf.NoSuchShooterAffiliationChronoException if a e s f shooter affiliation chrono with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFShooterAffiliationChrono findByPrimaryKey(
		long esfShooterAffiliationChronoId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchShooterAffiliationChronoException {
		return getPersistence().findByPrimaryKey(esfShooterAffiliationChronoId);
	}

	/**
	* Returns the e s f shooter affiliation chrono with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param esfShooterAffiliationChronoId the primary key of the e s f shooter affiliation chrono
	* @return the e s f shooter affiliation chrono, or <code>null</code> if a e s f shooter affiliation chrono with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFShooterAffiliationChrono fetchByPrimaryKey(
		long esfShooterAffiliationChronoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(esfShooterAffiliationChronoId);
	}

	/**
	* Returns all the e s f shooter affiliation chronos.
	*
	* @return the e s f shooter affiliation chronos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFShooterAffiliationChrono> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the e s f shooter affiliation chronos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShooterAffiliationChronoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f shooter affiliation chronos
	* @param end the upper bound of the range of e s f shooter affiliation chronos (not inclusive)
	* @return the range of e s f shooter affiliation chronos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFShooterAffiliationChrono> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the e s f shooter affiliation chronos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShooterAffiliationChronoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f shooter affiliation chronos
	* @param end the upper bound of the range of e s f shooter affiliation chronos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of e s f shooter affiliation chronos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFShooterAffiliationChrono> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the e s f shooter affiliation chronos from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of e s f shooter affiliation chronos.
	*
	* @return the number of e s f shooter affiliation chronos
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ESFShooterAffiliationChronoPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ESFShooterAffiliationChronoPersistence)PortletBeanLocatorUtil.locate(it.ethica.esf.service.ClpSerializer.getServletContextName(),
					ESFShooterAffiliationChronoPersistence.class.getName());

			ReferenceRegistry.registerReference(ESFShooterAffiliationChronoUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(
		ESFShooterAffiliationChronoPersistence persistence) {
	}

	private static ESFShooterAffiliationChronoPersistence _persistence;
}