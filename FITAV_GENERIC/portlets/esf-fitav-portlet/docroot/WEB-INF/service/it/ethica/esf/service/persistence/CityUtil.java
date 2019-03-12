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

import it.ethica.esf.model.City;

import java.util.List;

/**
 * The persistence utility for the city service. This utility wraps {@link CityPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see CityPersistence
 * @see CityPersistenceImpl
 * @generated
 */
public class CityUtil {
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
	public static void clearCache(City city) {
		getPersistence().clearCache(city);
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
	public static List<City> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<City> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<City> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static City update(City city) throws SystemException {
		return getPersistence().update(city);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static City update(City city, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(city, serviceContext);
	}

	/**
	* Returns all the cities where idCountry = &#63; and idRegion = &#63; and idProvince = &#63;.
	*
	* @param idCountry the id country
	* @param idRegion the id region
	* @param idProvince the id province
	* @return the matching cities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.City> findByC_R_P(
		java.lang.String idCountry, java.lang.String idRegion,
		java.lang.String idProvince)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_R_P(idCountry, idRegion, idProvince);
	}

	/**
	* Returns a range of all the cities where idCountry = &#63; and idRegion = &#63; and idProvince = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.CityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param idCountry the id country
	* @param idRegion the id region
	* @param idProvince the id province
	* @param start the lower bound of the range of cities
	* @param end the upper bound of the range of cities (not inclusive)
	* @return the range of matching cities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.City> findByC_R_P(
		java.lang.String idCountry, java.lang.String idRegion,
		java.lang.String idProvince, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_R_P(idCountry, idRegion, idProvince, start, end);
	}

	/**
	* Returns an ordered range of all the cities where idCountry = &#63; and idRegion = &#63; and idProvince = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.CityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param idCountry the id country
	* @param idRegion the id region
	* @param idProvince the id province
	* @param start the lower bound of the range of cities
	* @param end the upper bound of the range of cities (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching cities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.City> findByC_R_P(
		java.lang.String idCountry, java.lang.String idRegion,
		java.lang.String idProvince, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_R_P(idCountry, idRegion, idProvince, start, end,
			orderByComparator);
	}

	/**
	* Returns the first city in the ordered set where idCountry = &#63; and idRegion = &#63; and idProvince = &#63;.
	*
	* @param idCountry the id country
	* @param idRegion the id region
	* @param idProvince the id province
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching city
	* @throws it.ethica.esf.NoSuchCityException if a matching city could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.City findByC_R_P_First(
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
	* Returns the first city in the ordered set where idCountry = &#63; and idRegion = &#63; and idProvince = &#63;.
	*
	* @param idCountry the id country
	* @param idRegion the id region
	* @param idProvince the id province
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching city, or <code>null</code> if a matching city could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.City fetchByC_R_P_First(
		java.lang.String idCountry, java.lang.String idRegion,
		java.lang.String idProvince,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_R_P_First(idCountry, idRegion, idProvince,
			orderByComparator);
	}

	/**
	* Returns the last city in the ordered set where idCountry = &#63; and idRegion = &#63; and idProvince = &#63;.
	*
	* @param idCountry the id country
	* @param idRegion the id region
	* @param idProvince the id province
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching city
	* @throws it.ethica.esf.NoSuchCityException if a matching city could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.City findByC_R_P_Last(
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
	* Returns the last city in the ordered set where idCountry = &#63; and idRegion = &#63; and idProvince = &#63;.
	*
	* @param idCountry the id country
	* @param idRegion the id region
	* @param idProvince the id province
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching city, or <code>null</code> if a matching city could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.City fetchByC_R_P_Last(
		java.lang.String idCountry, java.lang.String idRegion,
		java.lang.String idProvince,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_R_P_Last(idCountry, idRegion, idProvince,
			orderByComparator);
	}

	/**
	* Returns the cities before and after the current city in the ordered set where idCountry = &#63; and idRegion = &#63; and idProvince = &#63;.
	*
	* @param cityPK the primary key of the current city
	* @param idCountry the id country
	* @param idRegion the id region
	* @param idProvince the id province
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next city
	* @throws it.ethica.esf.NoSuchCityException if a city with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.City[] findByC_R_P_PrevAndNext(
		it.ethica.esf.service.persistence.CityPK cityPK,
		java.lang.String idCountry, java.lang.String idRegion,
		java.lang.String idProvince,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchCityException {
		return getPersistence()
				   .findByC_R_P_PrevAndNext(cityPK, idCountry, idRegion,
			idProvince, orderByComparator);
	}

	/**
	* Removes all the cities where idCountry = &#63; and idRegion = &#63; and idProvince = &#63; from the database.
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
	* Returns the number of cities where idCountry = &#63; and idRegion = &#63; and idProvince = &#63;.
	*
	* @param idCountry the id country
	* @param idRegion the id region
	* @param idProvince the id province
	* @return the number of matching cities
	* @throws SystemException if a system exception occurred
	*/
	public static int countByC_R_P(java.lang.String idCountry,
		java.lang.String idRegion, java.lang.String idProvince)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByC_R_P(idCountry, idRegion, idProvince);
	}

	/**
	* Caches the city in the entity cache if it is enabled.
	*
	* @param city the city
	*/
	public static void cacheResult(it.ethica.esf.model.City city) {
		getPersistence().cacheResult(city);
	}

	/**
	* Caches the cities in the entity cache if it is enabled.
	*
	* @param cities the cities
	*/
	public static void cacheResult(
		java.util.List<it.ethica.esf.model.City> cities) {
		getPersistence().cacheResult(cities);
	}

	/**
	* Creates a new city with the primary key. Does not add the city to the database.
	*
	* @param cityPK the primary key for the new city
	* @return the new city
	*/
	public static it.ethica.esf.model.City create(
		it.ethica.esf.service.persistence.CityPK cityPK) {
		return getPersistence().create(cityPK);
	}

	/**
	* Removes the city with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param cityPK the primary key of the city
	* @return the city that was removed
	* @throws it.ethica.esf.NoSuchCityException if a city with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.City remove(
		it.ethica.esf.service.persistence.CityPK cityPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchCityException {
		return getPersistence().remove(cityPK);
	}

	public static it.ethica.esf.model.City updateImpl(
		it.ethica.esf.model.City city)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(city);
	}

	/**
	* Returns the city with the primary key or throws a {@link it.ethica.esf.NoSuchCityException} if it could not be found.
	*
	* @param cityPK the primary key of the city
	* @return the city
	* @throws it.ethica.esf.NoSuchCityException if a city with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.City findByPrimaryKey(
		it.ethica.esf.service.persistence.CityPK cityPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchCityException {
		return getPersistence().findByPrimaryKey(cityPK);
	}

	/**
	* Returns the city with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param cityPK the primary key of the city
	* @return the city, or <code>null</code> if a city with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.City fetchByPrimaryKey(
		it.ethica.esf.service.persistence.CityPK cityPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(cityPK);
	}

	/**
	* Returns all the cities.
	*
	* @return the cities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.City> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the cities.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.CityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of cities
	* @param end the upper bound of the range of cities (not inclusive)
	* @return the range of cities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.City> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the cities.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.CityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of cities
	* @param end the upper bound of the range of cities (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of cities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.City> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the cities from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of cities.
	*
	* @return the number of cities
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static CityPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (CityPersistence)PortletBeanLocatorUtil.locate(it.ethica.esf.service.ClpSerializer.getServletContextName(),
					CityPersistence.class.getName());

			ReferenceRegistry.registerReference(CityUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(CityPersistence persistence) {
	}

	private static CityPersistence _persistence;
}