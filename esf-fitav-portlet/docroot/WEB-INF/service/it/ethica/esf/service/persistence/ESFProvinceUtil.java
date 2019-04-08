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

import it.ethica.esf.model.ESFProvince;

import java.util.List;

/**
 * The persistence utility for the e s f province service. This utility wraps {@link ESFProvincePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFProvincePersistence
 * @see ESFProvincePersistenceImpl
 * @generated
 */
public class ESFProvinceUtil {
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
	public static void clearCache(ESFProvince esfProvince) {
		getPersistence().clearCache(esfProvince);
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
	public static List<ESFProvince> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ESFProvince> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ESFProvince> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ESFProvince update(ESFProvince esfProvince)
		throws SystemException {
		return getPersistence().update(esfProvince);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ESFProvince update(ESFProvince esfProvince,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(esfProvince, serviceContext);
	}

	/**
	* Returns all the e s f provinces where idRegion = &#63; and idCountry = &#63;.
	*
	* @param idRegion the id region
	* @param idCountry the id country
	* @return the matching e s f provinces
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFProvince> findByC_R(
		java.lang.String idRegion, java.lang.String idCountry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_R(idRegion, idCountry);
	}

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
	public static java.util.List<it.ethica.esf.model.ESFProvince> findByC_R(
		java.lang.String idRegion, java.lang.String idCountry, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_R(idRegion, idCountry, start, end);
	}

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
	public static java.util.List<it.ethica.esf.model.ESFProvince> findByC_R(
		java.lang.String idRegion, java.lang.String idCountry, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_R(idRegion, idCountry, start, end, orderByComparator);
	}

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
	public static it.ethica.esf.model.ESFProvince findByC_R_First(
		java.lang.String idRegion, java.lang.String idCountry,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchProvinceException {
		return getPersistence()
				   .findByC_R_First(idRegion, idCountry, orderByComparator);
	}

	/**
	* Returns the first e s f province in the ordered set where idRegion = &#63; and idCountry = &#63;.
	*
	* @param idRegion the id region
	* @param idCountry the id country
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f province, or <code>null</code> if a matching e s f province could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFProvince fetchByC_R_First(
		java.lang.String idRegion, java.lang.String idCountry,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_R_First(idRegion, idCountry, orderByComparator);
	}

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
	public static it.ethica.esf.model.ESFProvince findByC_R_Last(
		java.lang.String idRegion, java.lang.String idCountry,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchProvinceException {
		return getPersistence()
				   .findByC_R_Last(idRegion, idCountry, orderByComparator);
	}

	/**
	* Returns the last e s f province in the ordered set where idRegion = &#63; and idCountry = &#63;.
	*
	* @param idRegion the id region
	* @param idCountry the id country
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f province, or <code>null</code> if a matching e s f province could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFProvince fetchByC_R_Last(
		java.lang.String idRegion, java.lang.String idCountry,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_R_Last(idRegion, idCountry, orderByComparator);
	}

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
	public static it.ethica.esf.model.ESFProvince[] findByC_R_PrevAndNext(
		it.ethica.esf.service.persistence.ESFProvincePK esfProvincePK,
		java.lang.String idRegion, java.lang.String idCountry,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchProvinceException {
		return getPersistence()
				   .findByC_R_PrevAndNext(esfProvincePK, idRegion, idCountry,
			orderByComparator);
	}

	/**
	* Removes all the e s f provinces where idRegion = &#63; and idCountry = &#63; from the database.
	*
	* @param idRegion the id region
	* @param idCountry the id country
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByC_R(java.lang.String idRegion,
		java.lang.String idCountry)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByC_R(idRegion, idCountry);
	}

	/**
	* Returns the number of e s f provinces where idRegion = &#63; and idCountry = &#63;.
	*
	* @param idRegion the id region
	* @param idCountry the id country
	* @return the number of matching e s f provinces
	* @throws SystemException if a system exception occurred
	*/
	public static int countByC_R(java.lang.String idRegion,
		java.lang.String idCountry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByC_R(idRegion, idCountry);
	}

	/**
	* Returns all the e s f provinces where idCountry LIKE &#63; and name LIKE &#63;.
	*
	* @param idCountry the id country
	* @param name the name
	* @return the matching e s f provinces
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFProvince> findByCountryProvinceName(
		java.lang.String idCountry, java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCountryProvinceName(idCountry, name);
	}

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
	public static java.util.List<it.ethica.esf.model.ESFProvince> findByCountryProvinceName(
		java.lang.String idCountry, java.lang.String name, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCountryProvinceName(idCountry, name, start, end);
	}

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
	public static java.util.List<it.ethica.esf.model.ESFProvince> findByCountryProvinceName(
		java.lang.String idCountry, java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCountryProvinceName(idCountry, name, start, end,
			orderByComparator);
	}

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
	public static it.ethica.esf.model.ESFProvince findByCountryProvinceName_First(
		java.lang.String idCountry, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchProvinceException {
		return getPersistence()
				   .findByCountryProvinceName_First(idCountry, name,
			orderByComparator);
	}

	/**
	* Returns the first e s f province in the ordered set where idCountry LIKE &#63; and name LIKE &#63;.
	*
	* @param idCountry the id country
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f province, or <code>null</code> if a matching e s f province could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFProvince fetchByCountryProvinceName_First(
		java.lang.String idCountry, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCountryProvinceName_First(idCountry, name,
			orderByComparator);
	}

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
	public static it.ethica.esf.model.ESFProvince findByCountryProvinceName_Last(
		java.lang.String idCountry, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchProvinceException {
		return getPersistence()
				   .findByCountryProvinceName_Last(idCountry, name,
			orderByComparator);
	}

	/**
	* Returns the last e s f province in the ordered set where idCountry LIKE &#63; and name LIKE &#63;.
	*
	* @param idCountry the id country
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f province, or <code>null</code> if a matching e s f province could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFProvince fetchByCountryProvinceName_Last(
		java.lang.String idCountry, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCountryProvinceName_Last(idCountry, name,
			orderByComparator);
	}

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
	public static it.ethica.esf.model.ESFProvince[] findByCountryProvinceName_PrevAndNext(
		it.ethica.esf.service.persistence.ESFProvincePK esfProvincePK,
		java.lang.String idCountry, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchProvinceException {
		return getPersistence()
				   .findByCountryProvinceName_PrevAndNext(esfProvincePK,
			idCountry, name, orderByComparator);
	}

	/**
	* Removes all the e s f provinces where idCountry LIKE &#63; and name LIKE &#63; from the database.
	*
	* @param idCountry the id country
	* @param name the name
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCountryProvinceName(java.lang.String idCountry,
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCountryProvinceName(idCountry, name);
	}

	/**
	* Returns the number of e s f provinces where idCountry LIKE &#63; and name LIKE &#63;.
	*
	* @param idCountry the id country
	* @param name the name
	* @return the number of matching e s f provinces
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCountryProvinceName(java.lang.String idCountry,
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCountryProvinceName(idCountry, name);
	}

	/**
	* Returns all the e s f provinces where idProvince = &#63;.
	*
	* @param idProvince the id province
	* @return the matching e s f provinces
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFProvince> findByProvinceId(
		java.lang.String idProvince)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByProvinceId(idProvince);
	}

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
	public static java.util.List<it.ethica.esf.model.ESFProvince> findByProvinceId(
		java.lang.String idProvince, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByProvinceId(idProvince, start, end);
	}

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
	public static java.util.List<it.ethica.esf.model.ESFProvince> findByProvinceId(
		java.lang.String idProvince, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByProvinceId(idProvince, start, end, orderByComparator);
	}

	/**
	* Returns the first e s f province in the ordered set where idProvince = &#63;.
	*
	* @param idProvince the id province
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f province
	* @throws it.ethica.esf.NoSuchProvinceException if a matching e s f province could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFProvince findByProvinceId_First(
		java.lang.String idProvince,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchProvinceException {
		return getPersistence()
				   .findByProvinceId_First(idProvince, orderByComparator);
	}

	/**
	* Returns the first e s f province in the ordered set where idProvince = &#63;.
	*
	* @param idProvince the id province
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f province, or <code>null</code> if a matching e s f province could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFProvince fetchByProvinceId_First(
		java.lang.String idProvince,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByProvinceId_First(idProvince, orderByComparator);
	}

	/**
	* Returns the last e s f province in the ordered set where idProvince = &#63;.
	*
	* @param idProvince the id province
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f province
	* @throws it.ethica.esf.NoSuchProvinceException if a matching e s f province could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFProvince findByProvinceId_Last(
		java.lang.String idProvince,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchProvinceException {
		return getPersistence()
				   .findByProvinceId_Last(idProvince, orderByComparator);
	}

	/**
	* Returns the last e s f province in the ordered set where idProvince = &#63;.
	*
	* @param idProvince the id province
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f province, or <code>null</code> if a matching e s f province could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFProvince fetchByProvinceId_Last(
		java.lang.String idProvince,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByProvinceId_Last(idProvince, orderByComparator);
	}

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
	public static it.ethica.esf.model.ESFProvince[] findByProvinceId_PrevAndNext(
		it.ethica.esf.service.persistence.ESFProvincePK esfProvincePK,
		java.lang.String idProvince,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchProvinceException {
		return getPersistence()
				   .findByProvinceId_PrevAndNext(esfProvincePK, idProvince,
			orderByComparator);
	}

	/**
	* Removes all the e s f provinces where idProvince = &#63; from the database.
	*
	* @param idProvince the id province
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByProvinceId(java.lang.String idProvince)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByProvinceId(idProvince);
	}

	/**
	* Returns the number of e s f provinces where idProvince = &#63;.
	*
	* @param idProvince the id province
	* @return the number of matching e s f provinces
	* @throws SystemException if a system exception occurred
	*/
	public static int countByProvinceId(java.lang.String idProvince)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByProvinceId(idProvince);
	}

	/**
	* Caches the e s f province in the entity cache if it is enabled.
	*
	* @param esfProvince the e s f province
	*/
	public static void cacheResult(it.ethica.esf.model.ESFProvince esfProvince) {
		getPersistence().cacheResult(esfProvince);
	}

	/**
	* Caches the e s f provinces in the entity cache if it is enabled.
	*
	* @param esfProvinces the e s f provinces
	*/
	public static void cacheResult(
		java.util.List<it.ethica.esf.model.ESFProvince> esfProvinces) {
		getPersistence().cacheResult(esfProvinces);
	}

	/**
	* Creates a new e s f province with the primary key. Does not add the e s f province to the database.
	*
	* @param esfProvincePK the primary key for the new e s f province
	* @return the new e s f province
	*/
	public static it.ethica.esf.model.ESFProvince create(
		it.ethica.esf.service.persistence.ESFProvincePK esfProvincePK) {
		return getPersistence().create(esfProvincePK);
	}

	/**
	* Removes the e s f province with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfProvincePK the primary key of the e s f province
	* @return the e s f province that was removed
	* @throws it.ethica.esf.NoSuchProvinceException if a e s f province with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFProvince remove(
		it.ethica.esf.service.persistence.ESFProvincePK esfProvincePK)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchProvinceException {
		return getPersistence().remove(esfProvincePK);
	}

	public static it.ethica.esf.model.ESFProvince updateImpl(
		it.ethica.esf.model.ESFProvince esfProvince)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(esfProvince);
	}

	/**
	* Returns the e s f province with the primary key or throws a {@link it.ethica.esf.NoSuchProvinceException} if it could not be found.
	*
	* @param esfProvincePK the primary key of the e s f province
	* @return the e s f province
	* @throws it.ethica.esf.NoSuchProvinceException if a e s f province with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFProvince findByPrimaryKey(
		it.ethica.esf.service.persistence.ESFProvincePK esfProvincePK)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchProvinceException {
		return getPersistence().findByPrimaryKey(esfProvincePK);
	}

	/**
	* Returns the e s f province with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param esfProvincePK the primary key of the e s f province
	* @return the e s f province, or <code>null</code> if a e s f province with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFProvince fetchByPrimaryKey(
		it.ethica.esf.service.persistence.ESFProvincePK esfProvincePK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(esfProvincePK);
	}

	/**
	* Returns all the e s f provinces.
	*
	* @return the e s f provinces
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFProvince> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<it.ethica.esf.model.ESFProvince> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<it.ethica.esf.model.ESFProvince> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the e s f provinces from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of e s f provinces.
	*
	* @return the number of e s f provinces
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ESFProvincePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ESFProvincePersistence)PortletBeanLocatorUtil.locate(it.ethica.esf.service.ClpSerializer.getServletContextName(),
					ESFProvincePersistence.class.getName());

			ReferenceRegistry.registerReference(ESFProvinceUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ESFProvincePersistence persistence) {
	}

	private static ESFProvincePersistence _persistence;
}