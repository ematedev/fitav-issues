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

import it.ethica.esf.model.Region;

import java.util.List;

/**
 * The persistence utility for the region service. This utility wraps {@link RegionPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see RegionPersistence
 * @see RegionPersistenceImpl
 * @generated
 */
public class RegionUtil {
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
	public static void clearCache(Region region) {
		getPersistence().clearCache(region);
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
	public static List<Region> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Region> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Region> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Region update(Region region) throws SystemException {
		return getPersistence().update(region);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Region update(Region region, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(region, serviceContext);
	}

	/**
	* Returns all the regions where idCountry = &#63;.
	*
	* @param idCountry the id country
	* @return the matching regions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.Region> findByCountry(
		java.lang.String idCountry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCountry(idCountry);
	}

	/**
	* Returns a range of all the regions where idCountry = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.RegionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param idCountry the id country
	* @param start the lower bound of the range of regions
	* @param end the upper bound of the range of regions (not inclusive)
	* @return the range of matching regions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.Region> findByCountry(
		java.lang.String idCountry, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCountry(idCountry, start, end);
	}

	/**
	* Returns an ordered range of all the regions where idCountry = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.RegionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param idCountry the id country
	* @param start the lower bound of the range of regions
	* @param end the upper bound of the range of regions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching regions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.Region> findByCountry(
		java.lang.String idCountry, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCountry(idCountry, start, end, orderByComparator);
	}

	/**
	* Returns the first region in the ordered set where idCountry = &#63;.
	*
	* @param idCountry the id country
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching region
	* @throws it.ethica.esf.NoSuchRegionException if a matching region could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.Region findByCountry_First(
		java.lang.String idCountry,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchRegionException {
		return getPersistence().findByCountry_First(idCountry, orderByComparator);
	}

	/**
	* Returns the first region in the ordered set where idCountry = &#63;.
	*
	* @param idCountry the id country
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching region, or <code>null</code> if a matching region could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.Region fetchByCountry_First(
		java.lang.String idCountry,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCountry_First(idCountry, orderByComparator);
	}

	/**
	* Returns the last region in the ordered set where idCountry = &#63;.
	*
	* @param idCountry the id country
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching region
	* @throws it.ethica.esf.NoSuchRegionException if a matching region could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.Region findByCountry_Last(
		java.lang.String idCountry,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchRegionException {
		return getPersistence().findByCountry_Last(idCountry, orderByComparator);
	}

	/**
	* Returns the last region in the ordered set where idCountry = &#63;.
	*
	* @param idCountry the id country
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching region, or <code>null</code> if a matching region could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.Region fetchByCountry_Last(
		java.lang.String idCountry,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCountry_Last(idCountry, orderByComparator);
	}

	/**
	* Returns the regions before and after the current region in the ordered set where idCountry = &#63;.
	*
	* @param regionPK the primary key of the current region
	* @param idCountry the id country
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next region
	* @throws it.ethica.esf.NoSuchRegionException if a region with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.Region[] findByCountry_PrevAndNext(
		it.ethica.esf.service.persistence.RegionPK regionPK,
		java.lang.String idCountry,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchRegionException {
		return getPersistence()
				   .findByCountry_PrevAndNext(regionPK, idCountry,
			orderByComparator);
	}

	/**
	* Removes all the regions where idCountry = &#63; from the database.
	*
	* @param idCountry the id country
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCountry(java.lang.String idCountry)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCountry(idCountry);
	}

	/**
	* Returns the number of regions where idCountry = &#63;.
	*
	* @param idCountry the id country
	* @return the number of matching regions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCountry(java.lang.String idCountry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCountry(idCountry);
	}

	/**
	* Caches the region in the entity cache if it is enabled.
	*
	* @param region the region
	*/
	public static void cacheResult(it.ethica.esf.model.Region region) {
		getPersistence().cacheResult(region);
	}

	/**
	* Caches the regions in the entity cache if it is enabled.
	*
	* @param regions the regions
	*/
	public static void cacheResult(
		java.util.List<it.ethica.esf.model.Region> regions) {
		getPersistence().cacheResult(regions);
	}

	/**
	* Creates a new region with the primary key. Does not add the region to the database.
	*
	* @param regionPK the primary key for the new region
	* @return the new region
	*/
	public static it.ethica.esf.model.Region create(
		it.ethica.esf.service.persistence.RegionPK regionPK) {
		return getPersistence().create(regionPK);
	}

	/**
	* Removes the region with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param regionPK the primary key of the region
	* @return the region that was removed
	* @throws it.ethica.esf.NoSuchRegionException if a region with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.Region remove(
		it.ethica.esf.service.persistence.RegionPK regionPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchRegionException {
		return getPersistence().remove(regionPK);
	}

	public static it.ethica.esf.model.Region updateImpl(
		it.ethica.esf.model.Region region)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(region);
	}

	/**
	* Returns the region with the primary key or throws a {@link it.ethica.esf.NoSuchRegionException} if it could not be found.
	*
	* @param regionPK the primary key of the region
	* @return the region
	* @throws it.ethica.esf.NoSuchRegionException if a region with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.Region findByPrimaryKey(
		it.ethica.esf.service.persistence.RegionPK regionPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchRegionException {
		return getPersistence().findByPrimaryKey(regionPK);
	}

	/**
	* Returns the region with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param regionPK the primary key of the region
	* @return the region, or <code>null</code> if a region with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.Region fetchByPrimaryKey(
		it.ethica.esf.service.persistence.RegionPK regionPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(regionPK);
	}

	/**
	* Returns all the regions.
	*
	* @return the regions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.Region> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the regions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.RegionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of regions
	* @param end the upper bound of the range of regions (not inclusive)
	* @return the range of regions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.Region> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the regions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.RegionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of regions
	* @param end the upper bound of the range of regions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of regions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.Region> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the regions from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of regions.
	*
	* @return the number of regions
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static RegionPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (RegionPersistence)PortletBeanLocatorUtil.locate(it.ethica.esf.service.ClpSerializer.getServletContextName(),
					RegionPersistence.class.getName());

			ReferenceRegistry.registerReference(RegionUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(RegionPersistence persistence) {
	}

	private static RegionPersistence _persistence;
}