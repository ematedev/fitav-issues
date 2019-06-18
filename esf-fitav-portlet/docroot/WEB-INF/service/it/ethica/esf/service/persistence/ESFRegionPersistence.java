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

import it.ethica.esf.model.ESFRegion;

/**
 * The persistence interface for the e s f region service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFRegionPersistenceImpl
 * @see ESFRegionUtil
 * @generated
 */
public interface ESFRegionPersistence extends BasePersistence<ESFRegion> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ESFRegionUtil} to access the e s f region persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the e s f regions where idCountry = &#63;.
	*
	* @param idCountry the id country
	* @return the matching e s f regions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFRegion> findByCountry(
		java.lang.String idCountry)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f regions where idCountry = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFRegionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param idCountry the id country
	* @param start the lower bound of the range of e s f regions
	* @param end the upper bound of the range of e s f regions (not inclusive)
	* @return the range of matching e s f regions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFRegion> findByCountry(
		java.lang.String idCountry, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f regions where idCountry = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFRegionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param idCountry the id country
	* @param start the lower bound of the range of e s f regions
	* @param end the upper bound of the range of e s f regions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f regions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFRegion> findByCountry(
		java.lang.String idCountry, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f region in the ordered set where idCountry = &#63;.
	*
	* @param idCountry the id country
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f region
	* @throws it.ethica.esf.NoSuchRegionException if a matching e s f region could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFRegion findByCountry_First(
		java.lang.String idCountry,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchRegionException;

	/**
	* Returns the first e s f region in the ordered set where idCountry = &#63;.
	*
	* @param idCountry the id country
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f region, or <code>null</code> if a matching e s f region could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFRegion fetchByCountry_First(
		java.lang.String idCountry,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f region in the ordered set where idCountry = &#63;.
	*
	* @param idCountry the id country
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f region
	* @throws it.ethica.esf.NoSuchRegionException if a matching e s f region could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFRegion findByCountry_Last(
		java.lang.String idCountry,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchRegionException;

	/**
	* Returns the last e s f region in the ordered set where idCountry = &#63;.
	*
	* @param idCountry the id country
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f region, or <code>null</code> if a matching e s f region could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFRegion fetchByCountry_Last(
		java.lang.String idCountry,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f regions before and after the current e s f region in the ordered set where idCountry = &#63;.
	*
	* @param esfRegionPK the primary key of the current e s f region
	* @param idCountry the id country
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f region
	* @throws it.ethica.esf.NoSuchRegionException if a e s f region with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFRegion[] findByCountry_PrevAndNext(
		it.ethica.esf.service.persistence.ESFRegionPK esfRegionPK,
		java.lang.String idCountry,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchRegionException;

	/**
	* Removes all the e s f regions where idCountry = &#63; from the database.
	*
	* @param idCountry the id country
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCountry(java.lang.String idCountry)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f regions where idCountry = &#63;.
	*
	* @param idCountry the id country
	* @return the number of matching e s f regions
	* @throws SystemException if a system exception occurred
	*/
	public int countByCountry(java.lang.String idCountry)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the e s f region in the entity cache if it is enabled.
	*
	* @param esfRegion the e s f region
	*/
	public void cacheResult(it.ethica.esf.model.ESFRegion esfRegion);

	/**
	* Caches the e s f regions in the entity cache if it is enabled.
	*
	* @param esfRegions the e s f regions
	*/
	public void cacheResult(
		java.util.List<it.ethica.esf.model.ESFRegion> esfRegions);

	/**
	* Creates a new e s f region with the primary key. Does not add the e s f region to the database.
	*
	* @param esfRegionPK the primary key for the new e s f region
	* @return the new e s f region
	*/
	public it.ethica.esf.model.ESFRegion create(
		it.ethica.esf.service.persistence.ESFRegionPK esfRegionPK);

	/**
	* Removes the e s f region with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfRegionPK the primary key of the e s f region
	* @return the e s f region that was removed
	* @throws it.ethica.esf.NoSuchRegionException if a e s f region with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFRegion remove(
		it.ethica.esf.service.persistence.ESFRegionPK esfRegionPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchRegionException;

	public it.ethica.esf.model.ESFRegion updateImpl(
		it.ethica.esf.model.ESFRegion esfRegion)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f region with the primary key or throws a {@link it.ethica.esf.NoSuchRegionException} if it could not be found.
	*
	* @param esfRegionPK the primary key of the e s f region
	* @return the e s f region
	* @throws it.ethica.esf.NoSuchRegionException if a e s f region with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFRegion findByPrimaryKey(
		it.ethica.esf.service.persistence.ESFRegionPK esfRegionPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchRegionException;

	/**
	* Returns the e s f region with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param esfRegionPK the primary key of the e s f region
	* @return the e s f region, or <code>null</code> if a e s f region with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFRegion fetchByPrimaryKey(
		it.ethica.esf.service.persistence.ESFRegionPK esfRegionPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f regions.
	*
	* @return the e s f regions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFRegion> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f regions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFRegionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f regions
	* @param end the upper bound of the range of e s f regions (not inclusive)
	* @return the range of e s f regions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFRegion> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f regions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFRegionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f regions
	* @param end the upper bound of the range of e s f regions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of e s f regions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFRegion> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the e s f regions from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f regions.
	*
	* @return the number of e s f regions
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}