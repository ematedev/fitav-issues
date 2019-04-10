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

import it.ethica.esf.model.Province;

import java.util.List;

/**
 * The persistence utility for the province service. This utility wraps {@link ProvincePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ProvincePersistence
 * @see ProvincePersistenceImpl
 * @generated
 */
public class ProvinceUtil {
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
	public static void clearCache(Province province) {
		getPersistence().clearCache(province);
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
	public static List<Province> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Province> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Province> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Province update(Province province) throws SystemException {
		return getPersistence().update(province);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Province update(Province province,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(province, serviceContext);
	}

	/**
	* Returns all the provinces where idRegion = &#63; and idCountry = &#63;.
	*
	* @param idRegion the id region
	* @param idCountry the id country
	* @return the matching provinces
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.Province> findByC_R(
		java.lang.String idRegion, java.lang.String idCountry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_R(idRegion, idCountry);
	}

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
	public static java.util.List<it.ethica.esf.model.Province> findByC_R(
		java.lang.String idRegion, java.lang.String idCountry, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_R(idRegion, idCountry, start, end);
	}

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
	public static java.util.List<it.ethica.esf.model.Province> findByC_R(
		java.lang.String idRegion, java.lang.String idCountry, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_R(idRegion, idCountry, start, end, orderByComparator);
	}

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
	public static it.ethica.esf.model.Province findByC_R_First(
		java.lang.String idRegion, java.lang.String idCountry,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchProvinceException {
		return getPersistence()
				   .findByC_R_First(idRegion, idCountry, orderByComparator);
	}

	/**
	* Returns the first province in the ordered set where idRegion = &#63; and idCountry = &#63;.
	*
	* @param idRegion the id region
	* @param idCountry the id country
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching province, or <code>null</code> if a matching province could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.Province fetchByC_R_First(
		java.lang.String idRegion, java.lang.String idCountry,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_R_First(idRegion, idCountry, orderByComparator);
	}

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
	public static it.ethica.esf.model.Province findByC_R_Last(
		java.lang.String idRegion, java.lang.String idCountry,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchProvinceException {
		return getPersistence()
				   .findByC_R_Last(idRegion, idCountry, orderByComparator);
	}

	/**
	* Returns the last province in the ordered set where idRegion = &#63; and idCountry = &#63;.
	*
	* @param idRegion the id region
	* @param idCountry the id country
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching province, or <code>null</code> if a matching province could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.Province fetchByC_R_Last(
		java.lang.String idRegion, java.lang.String idCountry,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_R_Last(idRegion, idCountry, orderByComparator);
	}

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
	public static it.ethica.esf.model.Province[] findByC_R_PrevAndNext(
		it.ethica.esf.service.persistence.ProvincePK provincePK,
		java.lang.String idRegion, java.lang.String idCountry,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchProvinceException {
		return getPersistence()
				   .findByC_R_PrevAndNext(provincePK, idRegion, idCountry,
			orderByComparator);
	}

	/**
	* Removes all the provinces where idRegion = &#63; and idCountry = &#63; from the database.
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
	* Returns the number of provinces where idRegion = &#63; and idCountry = &#63;.
	*
	* @param idRegion the id region
	* @param idCountry the id country
	* @return the number of matching provinces
	* @throws SystemException if a system exception occurred
	*/
	public static int countByC_R(java.lang.String idRegion,
		java.lang.String idCountry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByC_R(idRegion, idCountry);
	}

	/**
	* Caches the province in the entity cache if it is enabled.
	*
	* @param province the province
	*/
	public static void cacheResult(it.ethica.esf.model.Province province) {
		getPersistence().cacheResult(province);
	}

	/**
	* Caches the provinces in the entity cache if it is enabled.
	*
	* @param provinces the provinces
	*/
	public static void cacheResult(
		java.util.List<it.ethica.esf.model.Province> provinces) {
		getPersistence().cacheResult(provinces);
	}

	/**
	* Creates a new province with the primary key. Does not add the province to the database.
	*
	* @param provincePK the primary key for the new province
	* @return the new province
	*/
	public static it.ethica.esf.model.Province create(
		it.ethica.esf.service.persistence.ProvincePK provincePK) {
		return getPersistence().create(provincePK);
	}

	/**
	* Removes the province with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param provincePK the primary key of the province
	* @return the province that was removed
	* @throws it.ethica.esf.NoSuchProvinceException if a province with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.Province remove(
		it.ethica.esf.service.persistence.ProvincePK provincePK)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchProvinceException {
		return getPersistence().remove(provincePK);
	}

	public static it.ethica.esf.model.Province updateImpl(
		it.ethica.esf.model.Province province)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(province);
	}

	/**
	* Returns the province with the primary key or throws a {@link it.ethica.esf.NoSuchProvinceException} if it could not be found.
	*
	* @param provincePK the primary key of the province
	* @return the province
	* @throws it.ethica.esf.NoSuchProvinceException if a province with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.Province findByPrimaryKey(
		it.ethica.esf.service.persistence.ProvincePK provincePK)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchProvinceException {
		return getPersistence().findByPrimaryKey(provincePK);
	}

	/**
	* Returns the province with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param provincePK the primary key of the province
	* @return the province, or <code>null</code> if a province with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.Province fetchByPrimaryKey(
		it.ethica.esf.service.persistence.ProvincePK provincePK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(provincePK);
	}

	/**
	* Returns all the provinces.
	*
	* @return the provinces
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.Province> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<it.ethica.esf.model.Province> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<it.ethica.esf.model.Province> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the provinces from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of provinces.
	*
	* @return the number of provinces
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ProvincePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ProvincePersistence)PortletBeanLocatorUtil.locate(it.ethica.esf.service.ClpSerializer.getServletContextName(),
					ProvincePersistence.class.getName());

			ReferenceRegistry.registerReference(ProvinceUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ProvincePersistence persistence) {
	}

	private static ProvincePersistence _persistence;
}