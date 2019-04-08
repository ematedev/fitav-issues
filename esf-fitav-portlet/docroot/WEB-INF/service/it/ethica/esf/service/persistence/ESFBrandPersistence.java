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

import it.ethica.esf.model.ESFBrand;

/**
 * The persistence interface for the e s f brand service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFBrandPersistenceImpl
 * @see ESFBrandUtil
 * @generated
 */
public interface ESFBrandPersistence extends BasePersistence<ESFBrand> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ESFBrandUtil} to access the e s f brand persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the e s f brand in the entity cache if it is enabled.
	*
	* @param esfBrand the e s f brand
	*/
	public void cacheResult(it.ethica.esf.model.ESFBrand esfBrand);

	/**
	* Caches the e s f brands in the entity cache if it is enabled.
	*
	* @param esfBrands the e s f brands
	*/
	public void cacheResult(
		java.util.List<it.ethica.esf.model.ESFBrand> esfBrands);

	/**
	* Creates a new e s f brand with the primary key. Does not add the e s f brand to the database.
	*
	* @param brandId the primary key for the new e s f brand
	* @return the new e s f brand
	*/
	public it.ethica.esf.model.ESFBrand create(long brandId);

	/**
	* Removes the e s f brand with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param brandId the primary key of the e s f brand
	* @return the e s f brand that was removed
	* @throws it.ethica.esf.NoSuchBrandException if a e s f brand with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFBrand remove(long brandId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchBrandException;

	public it.ethica.esf.model.ESFBrand updateImpl(
		it.ethica.esf.model.ESFBrand esfBrand)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f brand with the primary key or throws a {@link it.ethica.esf.NoSuchBrandException} if it could not be found.
	*
	* @param brandId the primary key of the e s f brand
	* @return the e s f brand
	* @throws it.ethica.esf.NoSuchBrandException if a e s f brand with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFBrand findByPrimaryKey(long brandId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchBrandException;

	/**
	* Returns the e s f brand with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param brandId the primary key of the e s f brand
	* @return the e s f brand, or <code>null</code> if a e s f brand with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFBrand fetchByPrimaryKey(long brandId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f brands.
	*
	* @return the e s f brands
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFBrand> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f brands.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFBrandModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f brands
	* @param end the upper bound of the range of e s f brands (not inclusive)
	* @return the range of e s f brands
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFBrand> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f brands.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFBrandModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f brands
	* @param end the upper bound of the range of e s f brands (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of e s f brands
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFBrand> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the e s f brands from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f brands.
	*
	* @return the number of e s f brands
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}