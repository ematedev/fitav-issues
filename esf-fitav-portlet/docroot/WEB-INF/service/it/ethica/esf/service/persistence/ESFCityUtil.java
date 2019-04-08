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

import it.ethica.esf.model.ESFCity;

import java.util.List;

/**
 * The persistence utility for the e s f city service. This utility wraps {@link ESFCityPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFCityPersistence
 * @see ESFCityPersistenceImpl
 * @generated
 */
public class ESFCityUtil {
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
	public static void clearCache(ESFCity esfCity) {
		getPersistence().clearCache(esfCity);
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
	public static List<ESFCity> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ESFCity> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ESFCity> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ESFCity update(ESFCity esfCity) throws SystemException {
		return getPersistence().update(esfCity);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ESFCity update(ESFCity esfCity, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(esfCity, serviceContext);
	}

	/**
	* Returns all the e s f cities where idCountry = &#63; and idRegion = &#63; and idProvince = &#63;.
	*
	* @param idCountry the id country
	* @param idRegion the id region
	* @param idProvince the id province
	* @return the matching e s f cities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFCity> findByC_R_P(
		java.lang.String idCountry, java.lang.String idRegion,
		java.lang.String idProvince)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_R_P(idCountry, idRegion, idProvince);
	}

	/**
	* Returns a range of all the e s f cities where idCountry = &#63; and idRegion = &#63; and idProvince = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFCityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param idCountry the id country
	* @param idRegion the id region
	* @param idProvince the id province
	* @param start the lower bound of the range of e s f cities
	* @param end the upper bound of the range of e s f cities (not inclusive)
	* @return the range of matching e s f cities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFCity> findByC_R_P(
		java.lang.String idCountry, java.lang.String idRegion,
		java.lang.String idProvince, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_R_P(idCountry, idRegion, idProvince, start, end);
	}

	/**
	* Returns an ordered range of all the e s f cities where idCountry = &#63; and idRegion = &#63; and idProvince = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFCityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param idCountry the id country
	* @param idRegion the id region
	* @param idProvince the id province
	* @param start the lower bound of the range of e s f cities
	* @param end the upper bound of the range of e s f cities (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f cities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFCity> findByC_R_P(
		java.lang.String idCountry, java.lang.String idRegion,
		java.lang.String idProvince, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_R_P(idCountry, idRegion, idProvince, start, end,
			orderByComparator);
	}

	/**
	* Returns the first e s f city in the ordered set where idCountry = &#63; and idRegion = &#63; and idProvince = &#63;.
	*
	* @param idCountry the id country
	* @param idRegion the id region
	* @param idProvince the id province
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f city
	* @throws it.ethica.esf.NoSuchCityException if a matching e s f city could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFCity findByC_R_P_First(
		java.lang.String idCountry, java.lang.String idRegion,
		java.lang.String idProvince,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchCityException {
		return getPersistence()
				   .findByC_R_P_First(idCountry, idRegion, idProvince,
			orderByComparator);
	}

	/**
	* Returns the first e s f city in the ordered set where idCountry = &#63; and idRegion = &#63; and idProvince = &#63;.
	*
	* @param idCountry the id country
	* @param idRegion the id region
	* @param idProvince the id province
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f city, or <code>null</code> if a matching e s f city could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFCity fetchByC_R_P_First(
		java.lang.String idCountry, java.lang.String idRegion,
		java.lang.String idProvince,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_R_P_First(idCountry, idRegion, idProvince,
			orderByComparator);
	}

	/**
	* Returns the last e s f city in the ordered set where idCountry = &#63; and idRegion = &#63; and idProvince = &#63;.
	*
	* @param idCountry the id country
	* @param idRegion the id region
	* @param idProvince the id province
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f city
	* @throws it.ethica.esf.NoSuchCityException if a matching e s f city could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFCity findByC_R_P_Last(
		java.lang.String idCountry, java.lang.String idRegion,
		java.lang.String idProvince,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchCityException {
		return getPersistence()
				   .findByC_R_P_Last(idCountry, idRegion, idProvince,
			orderByComparator);
	}

	/**
	* Returns the last e s f city in the ordered set where idCountry = &#63; and idRegion = &#63; and idProvince = &#63;.
	*
	* @param idCountry the id country
	* @param idRegion the id region
	* @param idProvince the id province
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f city, or <code>null</code> if a matching e s f city could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFCity fetchByC_R_P_Last(
		java.lang.String idCountry, java.lang.String idRegion,
		java.lang.String idProvince,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_R_P_Last(idCountry, idRegion, idProvince,
			orderByComparator);
	}

	/**
	* Returns the e s f cities before and after the current e s f city in the ordered set where idCountry = &#63; and idRegion = &#63; and idProvince = &#63;.
	*
	* @param esfCityPK the primary key of the current e s f city
	* @param idCountry the id country
	* @param idRegion the id region
	* @param idProvince the id province
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f city
	* @throws it.ethica.esf.NoSuchCityException if a e s f city with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFCity[] findByC_R_P_PrevAndNext(
		it.ethica.esf.service.persistence.ESFCityPK esfCityPK,
		java.lang.String idCountry, java.lang.String idRegion,
		java.lang.String idProvince,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchCityException {
		return getPersistence()
				   .findByC_R_P_PrevAndNext(esfCityPK, idCountry, idRegion,
			idProvince, orderByComparator);
	}

	/**
	* Removes all the e s f cities where idCountry = &#63; and idRegion = &#63; and idProvince = &#63; from the database.
	*
	* @param idCountry the id country
	* @param idRegion the id region
	* @param idProvince the id province
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByC_R_P(java.lang.String idCountry,
		java.lang.String idRegion, java.lang.String idProvince)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByC_R_P(idCountry, idRegion, idProvince);
	}

	/**
	* Returns the number of e s f cities where idCountry = &#63; and idRegion = &#63; and idProvince = &#63;.
	*
	* @param idCountry the id country
	* @param idRegion the id region
	* @param idProvince the id province
	* @return the number of matching e s f cities
	* @throws SystemException if a system exception occurred
	*/
	public static int countByC_R_P(java.lang.String idCountry,
		java.lang.String idRegion, java.lang.String idProvince)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByC_R_P(idCountry, idRegion, idProvince);
	}

	/**
	* Returns all the e s f cities where name = &#63;.
	*
	* @param name the name
	* @return the matching e s f cities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFCity> findByName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByName(name);
	}

	/**
	* Returns a range of all the e s f cities where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFCityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param name the name
	* @param start the lower bound of the range of e s f cities
	* @param end the upper bound of the range of e s f cities (not inclusive)
	* @return the range of matching e s f cities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFCity> findByName(
		java.lang.String name, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByName(name, start, end);
	}

	/**
	* Returns an ordered range of all the e s f cities where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFCityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param name the name
	* @param start the lower bound of the range of e s f cities
	* @param end the upper bound of the range of e s f cities (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f cities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFCity> findByName(
		java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByName(name, start, end, orderByComparator);
	}

	/**
	* Returns the first e s f city in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f city
	* @throws it.ethica.esf.NoSuchCityException if a matching e s f city could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFCity findByName_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchCityException {
		return getPersistence().findByName_First(name, orderByComparator);
	}

	/**
	* Returns the first e s f city in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f city, or <code>null</code> if a matching e s f city could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFCity fetchByName_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByName_First(name, orderByComparator);
	}

	/**
	* Returns the last e s f city in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f city
	* @throws it.ethica.esf.NoSuchCityException if a matching e s f city could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFCity findByName_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchCityException {
		return getPersistence().findByName_Last(name, orderByComparator);
	}

	/**
	* Returns the last e s f city in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f city, or <code>null</code> if a matching e s f city could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFCity fetchByName_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByName_Last(name, orderByComparator);
	}

	/**
	* Returns the e s f cities before and after the current e s f city in the ordered set where name = &#63;.
	*
	* @param esfCityPK the primary key of the current e s f city
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f city
	* @throws it.ethica.esf.NoSuchCityException if a e s f city with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFCity[] findByName_PrevAndNext(
		it.ethica.esf.service.persistence.ESFCityPK esfCityPK,
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchCityException {
		return getPersistence()
				   .findByName_PrevAndNext(esfCityPK, name, orderByComparator);
	}

	/**
	* Removes all the e s f cities where name = &#63; from the database.
	*
	* @param name the name
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByName(name);
	}

	/**
	* Returns the number of e s f cities where name = &#63;.
	*
	* @param name the name
	* @return the number of matching e s f cities
	* @throws SystemException if a system exception occurred
	*/
	public static int countByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByName(name);
	}

	/**
	* Caches the e s f city in the entity cache if it is enabled.
	*
	* @param esfCity the e s f city
	*/
	public static void cacheResult(it.ethica.esf.model.ESFCity esfCity) {
		getPersistence().cacheResult(esfCity);
	}

	/**
	* Caches the e s f cities in the entity cache if it is enabled.
	*
	* @param esfCities the e s f cities
	*/
	public static void cacheResult(
		java.util.List<it.ethica.esf.model.ESFCity> esfCities) {
		getPersistence().cacheResult(esfCities);
	}

	/**
	* Creates a new e s f city with the primary key. Does not add the e s f city to the database.
	*
	* @param esfCityPK the primary key for the new e s f city
	* @return the new e s f city
	*/
	public static it.ethica.esf.model.ESFCity create(
		it.ethica.esf.service.persistence.ESFCityPK esfCityPK) {
		return getPersistence().create(esfCityPK);
	}

	/**
	* Removes the e s f city with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfCityPK the primary key of the e s f city
	* @return the e s f city that was removed
	* @throws it.ethica.esf.NoSuchCityException if a e s f city with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFCity remove(
		it.ethica.esf.service.persistence.ESFCityPK esfCityPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchCityException {
		return getPersistence().remove(esfCityPK);
	}

	public static it.ethica.esf.model.ESFCity updateImpl(
		it.ethica.esf.model.ESFCity esfCity)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(esfCity);
	}

	/**
	* Returns the e s f city with the primary key or throws a {@link it.ethica.esf.NoSuchCityException} if it could not be found.
	*
	* @param esfCityPK the primary key of the e s f city
	* @return the e s f city
	* @throws it.ethica.esf.NoSuchCityException if a e s f city with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFCity findByPrimaryKey(
		it.ethica.esf.service.persistence.ESFCityPK esfCityPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchCityException {
		return getPersistence().findByPrimaryKey(esfCityPK);
	}

	/**
	* Returns the e s f city with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param esfCityPK the primary key of the e s f city
	* @return the e s f city, or <code>null</code> if a e s f city with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFCity fetchByPrimaryKey(
		it.ethica.esf.service.persistence.ESFCityPK esfCityPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(esfCityPK);
	}

	/**
	* Returns all the e s f cities.
	*
	* @return the e s f cities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFCity> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the e s f cities.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFCityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f cities
	* @param end the upper bound of the range of e s f cities (not inclusive)
	* @return the range of e s f cities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFCity> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the e s f cities.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFCityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f cities
	* @param end the upper bound of the range of e s f cities (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of e s f cities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFCity> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the e s f cities from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of e s f cities.
	*
	* @return the number of e s f cities
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ESFCityPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ESFCityPersistence)PortletBeanLocatorUtil.locate(it.ethica.esf.service.ClpSerializer.getServletContextName(),
					ESFCityPersistence.class.getName());

			ReferenceRegistry.registerReference(ESFCityUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ESFCityPersistence persistence) {
	}

	private static ESFCityPersistence _persistence;
}