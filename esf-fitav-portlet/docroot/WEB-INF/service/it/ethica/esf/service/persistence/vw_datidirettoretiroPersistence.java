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

import it.ethica.esf.model.vw_datidirettoretiro;

/**
 * The persistence interface for the vw_datidirettoretiro service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see vw_datidirettoretiroPersistenceImpl
 * @see vw_datidirettoretiroUtil
 * @generated
 */
public interface vw_datidirettoretiroPersistence extends BasePersistence<vw_datidirettoretiro> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link vw_datidirettoretiroUtil} to access the vw_datidirettoretiro persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the vw_datidirettoretiro in the entity cache if it is enabled.
	*
	* @param vw_datidirettoretiro the vw_datidirettoretiro
	*/
	public void cacheResult(
		it.ethica.esf.model.vw_datidirettoretiro vw_datidirettoretiro);

	/**
	* Caches the vw_datidirettoretiros in the entity cache if it is enabled.
	*
	* @param vw_datidirettoretiros the vw_datidirettoretiros
	*/
	public void cacheResult(
		java.util.List<it.ethica.esf.model.vw_datidirettoretiro> vw_datidirettoretiros);

	/**
	* Creates a new vw_datidirettoretiro with the primary key. Does not add the vw_datidirettoretiro to the database.
	*
	* @param vw_datidirettoretiroPK the primary key for the new vw_datidirettoretiro
	* @return the new vw_datidirettoretiro
	*/
	public it.ethica.esf.model.vw_datidirettoretiro create(
		vw_datidirettoretiroPK vw_datidirettoretiroPK);

	/**
	* Removes the vw_datidirettoretiro with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param vw_datidirettoretiroPK the primary key of the vw_datidirettoretiro
	* @return the vw_datidirettoretiro that was removed
	* @throws it.ethica.esf.NoSuchvw_datidirettoretiroException if a vw_datidirettoretiro with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.vw_datidirettoretiro remove(
		vw_datidirettoretiroPK vw_datidirettoretiroPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchvw_datidirettoretiroException;

	public it.ethica.esf.model.vw_datidirettoretiro updateImpl(
		it.ethica.esf.model.vw_datidirettoretiro vw_datidirettoretiro)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the vw_datidirettoretiro with the primary key or throws a {@link it.ethica.esf.NoSuchvw_datidirettoretiroException} if it could not be found.
	*
	* @param vw_datidirettoretiroPK the primary key of the vw_datidirettoretiro
	* @return the vw_datidirettoretiro
	* @throws it.ethica.esf.NoSuchvw_datidirettoretiroException if a vw_datidirettoretiro with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.vw_datidirettoretiro findByPrimaryKey(
		vw_datidirettoretiroPK vw_datidirettoretiroPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchvw_datidirettoretiroException;

	/**
	* Returns the vw_datidirettoretiro with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param vw_datidirettoretiroPK the primary key of the vw_datidirettoretiro
	* @return the vw_datidirettoretiro, or <code>null</code> if a vw_datidirettoretiro with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.vw_datidirettoretiro fetchByPrimaryKey(
		vw_datidirettoretiroPK vw_datidirettoretiroPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the vw_datidirettoretiros.
	*
	* @return the vw_datidirettoretiros
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.vw_datidirettoretiro> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the vw_datidirettoretiros.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.vw_datidirettoretiroModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of vw_datidirettoretiros
	* @param end the upper bound of the range of vw_datidirettoretiros (not inclusive)
	* @return the range of vw_datidirettoretiros
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.vw_datidirettoretiro> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the vw_datidirettoretiros.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.vw_datidirettoretiroModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of vw_datidirettoretiros
	* @param end the upper bound of the range of vw_datidirettoretiros (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of vw_datidirettoretiros
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.vw_datidirettoretiro> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the vw_datidirettoretiros from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of vw_datidirettoretiros.
	*
	* @return the number of vw_datidirettoretiros
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}