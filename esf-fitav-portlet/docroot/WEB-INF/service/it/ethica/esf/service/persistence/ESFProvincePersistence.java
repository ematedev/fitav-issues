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

import it.ethica.esf.model.ESFProvince;

/**
 * The persistence interface for the e s f province service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFProvincePersistenceImpl
 * @see ESFProvinceUtil
 * @generated
 */
public interface ESFProvincePersistence extends BasePersistence<ESFProvince> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ESFProvinceUtil} to access the e s f province persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the e s f provinces where idRegion = &#63; and idCountry = &#63;.
	*
	* @param idRegion the id region
	* @param idCountry the id country
	* @return the matching e s f provinces
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFProvince> findByC_R(
		java.lang.String idRegion, java.lang.String idCountry)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f provinces where idRegion = &#63; and idCountry = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFProvinceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param idRegion the id region
	* @param idCountry the id country
	* @param start the lower bound of the range of e s f provinces
	* @param end the upper bound of the range of e s f provinces (not inclusive)
	* @return the range of matching e s f provinces
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFProvince> findByC_R(
		java.lang.String idRegion, java.lang.String idCountry, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f provinces where idRegion = &#63; and idCountry = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFProvinceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param idRegion the id region
	* @param idCountry the id country
	* @param start the lower bound of the range of e s f provinces
	* @param end the upper bound of the range of e s f provinces (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f provinces
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFProvince> findByC_R(
		java.lang.String idRegion, java.lang.String idCountry, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f province in the ordered set where idRegion = &#63; and idCountry = &#63;.
	*
	* @param idRegion the id region
	* @param idCountry the id country
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f province
	* @throws it.ethica.esf.NoSuchProvinceException if a matching e s f province could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFProvince findByC_R_First(
		java.lang.String idRegion, java.lang.String idCountry,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchProvinceException;

	/**
	* Returns the first e s f province in the ordered set where idRegion = &#63; and idCountry = &#63;.
	*
	* @param idRegion the id region
	* @param idCountry the id country
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f province, or <code>null</code> if a matching e s f province could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFProvince fetchByC_R_First(
		java.lang.String idRegion, java.lang.String idCountry,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f province in the ordered set where idRegion = &#63; and idCountry = &#63;.
	*
	* @param idRegion the id region
	* @param idCountry the id country
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f province
	* @throws it.ethica.esf.NoSuchProvinceException if a matching e s f province could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFProvince findByC_R_Last(
		java.lang.String idRegion, java.lang.String idCountry,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchProvinceException;

	/**
	* Returns the last e s f province in the ordered set where idRegion = &#63; and idCountry = &#63;.
	*
	* @param idRegion the id region
	* @param idCountry the id country
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f province, or <code>null</code> if a matching e s f province could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFProvince fetchByC_R_Last(
		java.lang.String idRegion, java.lang.String idCountry,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f provinces before and after the current e s f province in the ordered set where idRegion = &#63; and idCountry = &#63;.
	*
	* @param esfProvincePK the primary key of the current e s f province
	* @param idRegion the id region
	* @param idCountry the id country
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f province
	* @throws it.ethica.esf.NoSuchProvinceException if a e s f province with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFProvince[] findByC_R_PrevAndNext(
		it.ethica.esf.service.persistence.ESFProvincePK esfProvincePK,
		java.lang.String idRegion, java.lang.String idCountry,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchProvinceException;

	/**
	* Removes all the e s f provinces where idRegion = &#63; and idCountry = &#63; from the database.
	*
	* @param idRegion the id region
	* @param idCountry the id country
	* @throws SystemException if a system exception occurred
	*/
	public void removeByC_R(java.lang.String idRegion,
		java.lang.String idCountry)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f provinces where idRegion = &#63; and idCountry = &#63;.
	*
	* @param idRegion the id region
	* @param idCountry the id country
	* @return the number of matching e s f provinces
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_R(java.lang.String idRegion, java.lang.String idCountry)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f provinces where idCountry LIKE &#63; and name LIKE &#63;.
	*
	* @param idCountry the id country
	* @param name the name
	* @return the matching e s f provinces
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFProvince> findByCountryProvinceName(
		java.lang.String idCountry, java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f provinces where idCountry LIKE &#63; and name LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFProvinceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param idCountry the id country
	* @param name the name
	* @param start the lower bound of the range of e s f provinces
	* @param end the upper bound of the range of e s f provinces (not inclusive)
	* @return the range of matching e s f provinces
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFProvince> findByCountryProvinceName(
		java.lang.String idCountry, java.lang.String name, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f provinces where idCountry LIKE &#63; and name LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFProvinceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param idCountry the id country
	* @param name the name
	* @param start the lower bound of the range of e s f provinces
	* @param end the upper bound of the range of e s f provinces (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f provinces
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFProvince> findByCountryProvinceName(
		java.lang.String idCountry, java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f province in the ordered set where idCountry LIKE &#63; and name LIKE &#63;.
	*
	* @param idCountry the id country
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f province
	* @throws it.ethica.esf.NoSuchProvinceException if a matching e s f province could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFProvince findByCountryProvinceName_First(
		java.lang.String idCountry, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchProvinceException;

	/**
	* Returns the first e s f province in the ordered set where idCountry LIKE &#63; and name LIKE &#63;.
	*
	* @param idCountry the id country
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f province, or <code>null</code> if a matching e s f province could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFProvince fetchByCountryProvinceName_First(
		java.lang.String idCountry, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f province in the ordered set where idCountry LIKE &#63; and name LIKE &#63;.
	*
	* @param idCountry the id country
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f province
	* @throws it.ethica.esf.NoSuchProvinceException if a matching e s f province could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFProvince findByCountryProvinceName_Last(
		java.lang.String idCountry, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchProvinceException;

	/**
	* Returns the last e s f province in the ordered set where idCountry LIKE &#63; and name LIKE &#63;.
	*
	* @param idCountry the id country
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f province, or <code>null</code> if a matching e s f province could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFProvince fetchByCountryProvinceName_Last(
		java.lang.String idCountry, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f provinces before and after the current e s f province in the ordered set where idCountry LIKE &#63; and name LIKE &#63;.
	*
	* @param esfProvincePK the primary key of the current e s f province
	* @param idCountry the id country
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f province
	* @throws it.ethica.esf.NoSuchProvinceException if a e s f province with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFProvince[] findByCountryProvinceName_PrevAndNext(
		it.ethica.esf.service.persistence.ESFProvincePK esfProvincePK,
		java.lang.String idCountry, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchProvinceException;

	/**
	* Removes all the e s f provinces where idCountry LIKE &#63; and name LIKE &#63; from the database.
	*
	* @param idCountry the id country
	* @param name the name
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCountryProvinceName(java.lang.String idCountry,
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f provinces where idCountry LIKE &#63; and name LIKE &#63;.
	*
	* @param idCountry the id country
	* @param name the name
	* @return the number of matching e s f provinces
	* @throws SystemException if a system exception occurred
	*/
	public int countByCountryProvinceName(java.lang.String idCountry,
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f provinces where idProvince = &#63;.
	*
	* @param idProvince the id province
	* @return the matching e s f provinces
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFProvince> findByProvinceId(
		java.lang.String idProvince)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f provinces where idProvince = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFProvinceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param idProvince the id province
	* @param start the lower bound of the range of e s f provinces
	* @param end the upper bound of the range of e s f provinces (not inclusive)
	* @return the range of matching e s f provinces
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFProvince> findByProvinceId(
		java.lang.String idProvince, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f provinces where idProvince = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFProvinceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param idProvince the id province
	* @param start the lower bound of the range of e s f provinces
	* @param end the upper bound of the range of e s f provinces (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f provinces
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFProvince> findByProvinceId(
		java.lang.String idProvince, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f province in the ordered set where idProvince = &#63;.
	*
	* @param idProvince the id province
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f province
	* @throws it.ethica.esf.NoSuchProvinceException if a matching e s f province could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFProvince findByProvinceId_First(
		java.lang.String idProvince,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchProvinceException;

	/**
	* Returns the first e s f province in the ordered set where idProvince = &#63;.
	*
	* @param idProvince the id province
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f province, or <code>null</code> if a matching e s f province could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFProvince fetchByProvinceId_First(
		java.lang.String idProvince,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f province in the ordered set where idProvince = &#63;.
	*
	* @param idProvince the id province
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f province
	* @throws it.ethica.esf.NoSuchProvinceException if a matching e s f province could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFProvince findByProvinceId_Last(
		java.lang.String idProvince,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchProvinceException;

	/**
	* Returns the last e s f province in the ordered set where idProvince = &#63;.
	*
	* @param idProvince the id province
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f province, or <code>null</code> if a matching e s f province could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFProvince fetchByProvinceId_Last(
		java.lang.String idProvince,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f provinces before and after the current e s f province in the ordered set where idProvince = &#63;.
	*
	* @param esfProvincePK the primary key of the current e s f province
	* @param idProvince the id province
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f province
	* @throws it.ethica.esf.NoSuchProvinceException if a e s f province with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFProvince[] findByProvinceId_PrevAndNext(
		it.ethica.esf.service.persistence.ESFProvincePK esfProvincePK,
		java.lang.String idProvince,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchProvinceException;

	/**
	* Removes all the e s f provinces where idProvince = &#63; from the database.
	*
	* @param idProvince the id province
	* @throws SystemException if a system exception occurred
	*/
	public void removeByProvinceId(java.lang.String idProvince)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f provinces where idProvince = &#63;.
	*
	* @param idProvince the id province
	* @return the number of matching e s f provinces
	* @throws SystemException if a system exception occurred
	*/
	public int countByProvinceId(java.lang.String idProvince)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the e s f province in the entity cache if it is enabled.
	*
	* @param esfProvince the e s f province
	*/
	public void cacheResult(it.ethica.esf.model.ESFProvince esfProvince);

	/**
	* Caches the e s f provinces in the entity cache if it is enabled.
	*
	* @param esfProvinces the e s f provinces
	*/
	public void cacheResult(
		java.util.List<it.ethica.esf.model.ESFProvince> esfProvinces);

	/**
	* Creates a new e s f province with the primary key. Does not add the e s f province to the database.
	*
	* @param esfProvincePK the primary key for the new e s f province
	* @return the new e s f province
	*/
	public it.ethica.esf.model.ESFProvince create(
		it.ethica.esf.service.persistence.ESFProvincePK esfProvincePK);

	/**
	* Removes the e s f province with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfProvincePK the primary key of the e s f province
	* @return the e s f province that was removed
	* @throws it.ethica.esf.NoSuchProvinceException if a e s f province with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFProvince remove(
		it.ethica.esf.service.persistence.ESFProvincePK esfProvincePK)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchProvinceException;

	public it.ethica.esf.model.ESFProvince updateImpl(
		it.ethica.esf.model.ESFProvince esfProvince)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f province with the primary key or throws a {@link it.ethica.esf.NoSuchProvinceException} if it could not be found.
	*
	* @param esfProvincePK the primary key of the e s f province
	* @return the e s f province
	* @throws it.ethica.esf.NoSuchProvinceException if a e s f province with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFProvince findByPrimaryKey(
		it.ethica.esf.service.persistence.ESFProvincePK esfProvincePK)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchProvinceException;

	/**
	* Returns the e s f province with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param esfProvincePK the primary key of the e s f province
	* @return the e s f province, or <code>null</code> if a e s f province with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFProvince fetchByPrimaryKey(
		it.ethica.esf.service.persistence.ESFProvincePK esfProvincePK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f provinces.
	*
	* @return the e s f provinces
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFProvince> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f provinces.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFProvinceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f provinces
	* @param end the upper bound of the range of e s f provinces (not inclusive)
	* @return the range of e s f provinces
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFProvince> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f provinces.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFProvinceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f provinces
	* @param end the upper bound of the range of e s f provinces (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of e s f provinces
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFProvince> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the e s f provinces from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f provinces.
	*
	* @return the number of e s f provinces
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}