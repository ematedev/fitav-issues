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

import it.ethica.esf.model.Province;

/**
 * The persistence interface for the province service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ProvincePersistenceImpl
 * @see ProvinceUtil
 * @generated
 */
public interface ProvincePersistence extends BasePersistence<Province> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProvinceUtil} to access the province persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the provinces where idRegion = &#63; and idCountry = &#63;.
	*
	* @param idRegion the id region
	* @param idCountry the id country
	* @return the matching provinces
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.Province> findByC_R(
		java.lang.String idRegion, java.lang.String idCountry)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the provinces where idRegion = &#63; and idCountry = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ProvinceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param idRegion the id region
	* @param idCountry the id country
	* @param start the lower bound of the range of provinces
	* @param end the upper bound of the range of provinces (not inclusive)
	* @return the range of matching provinces
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.Province> findByC_R(
		java.lang.String idRegion, java.lang.String idCountry, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the provinces where idRegion = &#63; and idCountry = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ProvinceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param idRegion the id region
	* @param idCountry the id country
	* @param start the lower bound of the range of provinces
	* @param end the upper bound of the range of provinces (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching provinces
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.Province> findByC_R(
		java.lang.String idRegion, java.lang.String idCountry, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first province in the ordered set where idRegion = &#63; and idCountry = &#63;.
	*
	* @param idRegion the id region
	* @param idCountry the id country
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching province
	* @throws it.ethica.esf.NoSuchProvinceException if a matching province could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.Province findByC_R_First(
		java.lang.String idRegion, java.lang.String idCountry,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchProvinceException;

	/**
	* Returns the first province in the ordered set where idRegion = &#63; and idCountry = &#63;.
	*
	* @param idRegion the id region
	* @param idCountry the id country
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching province, or <code>null</code> if a matching province could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.Province fetchByC_R_First(
		java.lang.String idRegion, java.lang.String idCountry,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last province in the ordered set where idRegion = &#63; and idCountry = &#63;.
	*
	* @param idRegion the id region
	* @param idCountry the id country
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching province
	* @throws it.ethica.esf.NoSuchProvinceException if a matching province could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.Province findByC_R_Last(
		java.lang.String idRegion, java.lang.String idCountry,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchProvinceException;

	/**
	* Returns the last province in the ordered set where idRegion = &#63; and idCountry = &#63;.
	*
	* @param idRegion the id region
	* @param idCountry the id country
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching province, or <code>null</code> if a matching province could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.Province fetchByC_R_Last(
		java.lang.String idRegion, java.lang.String idCountry,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the provinces before and after the current province in the ordered set where idRegion = &#63; and idCountry = &#63;.
	*
	* @param provincePK the primary key of the current province
	* @param idRegion the id region
	* @param idCountry the id country
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next province
	* @throws it.ethica.esf.NoSuchProvinceException if a province with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.Province[] findByC_R_PrevAndNext(
		it.ethica.esf.service.persistence.ProvincePK provincePK,
		java.lang.String idRegion, java.lang.String idCountry,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchProvinceException;

	/**
	* Removes all the provinces where idRegion = &#63; and idCountry = &#63; from the database.
	*
	* @param idRegion the id region
	* @param idCountry the id country
	* @throws SystemException if a system exception occurred
	*/
	public void removeByC_R(java.lang.String idRegion,
		java.lang.String idCountry)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of provinces where idRegion = &#63; and idCountry = &#63;.
	*
	* @param idRegion the id region
	* @param idCountry the id country
	* @return the number of matching provinces
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_R(java.lang.String idRegion, java.lang.String idCountry)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the province in the entity cache if it is enabled.
	*
	* @param province the province
	*/
	public void cacheResult(it.ethica.esf.model.Province province);

	/**
	* Caches the provinces in the entity cache if it is enabled.
	*
	* @param provinces the provinces
	*/
	public void cacheResult(
		java.util.List<it.ethica.esf.model.Province> provinces);

	/**
	* Creates a new province with the primary key. Does not add the province to the database.
	*
	* @param provincePK the primary key for the new province
	* @return the new province
	*/
	public it.ethica.esf.model.Province create(
		it.ethica.esf.service.persistence.ProvincePK provincePK);

	/**
	* Removes the province with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param provincePK the primary key of the province
	* @return the province that was removed
	* @throws it.ethica.esf.NoSuchProvinceException if a province with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.Province remove(
		it.ethica.esf.service.persistence.ProvincePK provincePK)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchProvinceException;

	public it.ethica.esf.model.Province updateImpl(
		it.ethica.esf.model.Province province)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the province with the primary key or throws a {@link it.ethica.esf.NoSuchProvinceException} if it could not be found.
	*
	* @param provincePK the primary key of the province
	* @return the province
	* @throws it.ethica.esf.NoSuchProvinceException if a province with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.Province findByPrimaryKey(
		it.ethica.esf.service.persistence.ProvincePK provincePK)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchProvinceException;

	/**
	* Returns the province with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param provincePK the primary key of the province
	* @return the province, or <code>null</code> if a province with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.Province fetchByPrimaryKey(
		it.ethica.esf.service.persistence.ProvincePK provincePK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the provinces.
	*
	* @return the provinces
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.Province> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the provinces.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ProvinceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of provinces
	* @param end the upper bound of the range of provinces (not inclusive)
	* @return the range of provinces
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.Province> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the provinces.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ProvinceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of provinces
	* @param end the upper bound of the range of provinces (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of provinces
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.Province> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the provinces from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of provinces.
	*
	* @return the number of provinces
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}