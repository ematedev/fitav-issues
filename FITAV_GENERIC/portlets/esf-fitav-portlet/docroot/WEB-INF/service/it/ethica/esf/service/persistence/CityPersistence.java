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

import it.ethica.esf.model.City;

/**
 * The persistence interface for the city service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see CityPersistenceImpl
 * @see CityUtil
 * @generated
 */
public interface CityPersistence extends BasePersistence<City> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CityUtil} to access the city persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the cities where idCountry = &#63; and idRegion = &#63; and idProvince = &#63;.
	*
	* @param idCountry the id country
	* @param idRegion the id region
	* @param idProvince the id province
	* @return the matching cities
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.City> findByC_R_P(
		java.lang.String idCountry, java.lang.String idRegion,
		java.lang.String idProvince)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.ethica.esf.model.City> findByC_R_P(
		java.lang.String idCountry, java.lang.String idRegion,
		java.lang.String idProvince, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.ethica.esf.model.City> findByC_R_P(
		java.lang.String idCountry, java.lang.String idRegion,
		java.lang.String idProvince, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public it.ethica.esf.model.City findByC_R_P_First(
		java.lang.String idCountry, java.lang.String idRegion,
		java.lang.String idProvince,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchCityException;

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
	public it.ethica.esf.model.City fetchByC_R_P_First(
		java.lang.String idCountry, java.lang.String idRegion,
		java.lang.String idProvince,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public it.ethica.esf.model.City findByC_R_P_Last(
		java.lang.String idCountry, java.lang.String idRegion,
		java.lang.String idProvince,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchCityException;

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
	public it.ethica.esf.model.City fetchByC_R_P_Last(
		java.lang.String idCountry, java.lang.String idRegion,
		java.lang.String idProvince,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public it.ethica.esf.model.City[] findByC_R_P_PrevAndNext(
		it.ethica.esf.service.persistence.CityPK cityPK,
		java.lang.String idCountry, java.lang.String idRegion,
		java.lang.String idProvince,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchCityException;

	/**
	* Removes all the cities where idCountry = &#63; and idRegion = &#63; and idProvince = &#63; from the database.
	*
	* @param idCountry the id country
	* @param idRegion the id region
	* @param idProvince the id province
	* @throws SystemException if a system exception occurred
	*/
	public void removeByC_R_P(java.lang.String idCountry,
		java.lang.String idRegion, java.lang.String idProvince)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of cities where idCountry = &#63; and idRegion = &#63; and idProvince = &#63;.
	*
	* @param idCountry the id country
	* @param idRegion the id region
	* @param idProvince the id province
	* @return the number of matching cities
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_R_P(java.lang.String idCountry,
		java.lang.String idRegion, java.lang.String idProvince)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the city in the entity cache if it is enabled.
	*
	* @param city the city
	*/
	public void cacheResult(it.ethica.esf.model.City city);

	/**
	* Caches the cities in the entity cache if it is enabled.
	*
	* @param cities the cities
	*/
	public void cacheResult(java.util.List<it.ethica.esf.model.City> cities);

	/**
	* Creates a new city with the primary key. Does not add the city to the database.
	*
	* @param cityPK the primary key for the new city
	* @return the new city
	*/
	public it.ethica.esf.model.City create(
		it.ethica.esf.service.persistence.CityPK cityPK);

	/**
	* Removes the city with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param cityPK the primary key of the city
	* @return the city that was removed
	* @throws it.ethica.esf.NoSuchCityException if a city with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.City remove(
		it.ethica.esf.service.persistence.CityPK cityPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchCityException;

	public it.ethica.esf.model.City updateImpl(it.ethica.esf.model.City city)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the city with the primary key or throws a {@link it.ethica.esf.NoSuchCityException} if it could not be found.
	*
	* @param cityPK the primary key of the city
	* @return the city
	* @throws it.ethica.esf.NoSuchCityException if a city with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.City findByPrimaryKey(
		it.ethica.esf.service.persistence.CityPK cityPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchCityException;

	/**
	* Returns the city with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param cityPK the primary key of the city
	* @return the city, or <code>null</code> if a city with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.City fetchByPrimaryKey(
		it.ethica.esf.service.persistence.CityPK cityPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the cities.
	*
	* @return the cities
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.City> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.ethica.esf.model.City> findAll(int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.ethica.esf.model.City> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the cities from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of cities.
	*
	* @return the number of cities
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}