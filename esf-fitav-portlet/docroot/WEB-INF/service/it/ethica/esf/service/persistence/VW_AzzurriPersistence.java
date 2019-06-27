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

import it.ethica.esf.model.VW_Azzurri;

/**
 * The persistence interface for the v w_ azzurri service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see VW_AzzurriPersistenceImpl
 * @see VW_AzzurriUtil
 * @generated
 */
public interface VW_AzzurriPersistence extends BasePersistence<VW_Azzurri> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link VW_AzzurriUtil} to access the v w_ azzurri persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the v w_ azzurri where esfNationalId = &#63; or throws a {@link it.ethica.esf.NoSuchVW_AzzurriException} if it could not be found.
	*
	* @param esfNationalId the esf national ID
	* @return the matching v w_ azzurri
	* @throws it.ethica.esf.NoSuchVW_AzzurriException if a matching v w_ azzurri could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.VW_Azzurri findByfindByUserId(long esfNationalId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchVW_AzzurriException;

	/**
	* Returns the v w_ azzurri where esfNationalId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param esfNationalId the esf national ID
	* @return the matching v w_ azzurri, or <code>null</code> if a matching v w_ azzurri could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.VW_Azzurri fetchByfindByUserId(
		long esfNationalId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the v w_ azzurri where esfNationalId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param esfNationalId the esf national ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching v w_ azzurri, or <code>null</code> if a matching v w_ azzurri could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.VW_Azzurri fetchByfindByUserId(
		long esfNationalId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the v w_ azzurri where esfNationalId = &#63; from the database.
	*
	* @param esfNationalId the esf national ID
	* @return the v w_ azzurri that was removed
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.VW_Azzurri removeByfindByUserId(
		long esfNationalId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchVW_AzzurriException;

	/**
	* Returns the number of v w_ azzurris where esfNationalId = &#63;.
	*
	* @param esfNationalId the esf national ID
	* @return the number of matching v w_ azzurris
	* @throws SystemException if a system exception occurred
	*/
	public int countByfindByUserId(long esfNationalId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the v w_ azzurri in the entity cache if it is enabled.
	*
	* @param vw_Azzurri the v w_ azzurri
	*/
	public void cacheResult(it.ethica.esf.model.VW_Azzurri vw_Azzurri);

	/**
	* Caches the v w_ azzurris in the entity cache if it is enabled.
	*
	* @param vw_Azzurris the v w_ azzurris
	*/
	public void cacheResult(
		java.util.List<it.ethica.esf.model.VW_Azzurri> vw_Azzurris);

	/**
	* Creates a new v w_ azzurri with the primary key. Does not add the v w_ azzurri to the database.
	*
	* @param vw_AzzurriPK the primary key for the new v w_ azzurri
	* @return the new v w_ azzurri
	*/
	public it.ethica.esf.model.VW_Azzurri create(
		it.ethica.esf.service.persistence.VW_AzzurriPK vw_AzzurriPK);

	/**
	* Removes the v w_ azzurri with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param vw_AzzurriPK the primary key of the v w_ azzurri
	* @return the v w_ azzurri that was removed
	* @throws it.ethica.esf.NoSuchVW_AzzurriException if a v w_ azzurri with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.VW_Azzurri remove(
		it.ethica.esf.service.persistence.VW_AzzurriPK vw_AzzurriPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchVW_AzzurriException;

	public it.ethica.esf.model.VW_Azzurri updateImpl(
		it.ethica.esf.model.VW_Azzurri vw_Azzurri)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the v w_ azzurri with the primary key or throws a {@link it.ethica.esf.NoSuchVW_AzzurriException} if it could not be found.
	*
	* @param vw_AzzurriPK the primary key of the v w_ azzurri
	* @return the v w_ azzurri
	* @throws it.ethica.esf.NoSuchVW_AzzurriException if a v w_ azzurri with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.VW_Azzurri findByPrimaryKey(
		it.ethica.esf.service.persistence.VW_AzzurriPK vw_AzzurriPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchVW_AzzurriException;

	/**
	* Returns the v w_ azzurri with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param vw_AzzurriPK the primary key of the v w_ azzurri
	* @return the v w_ azzurri, or <code>null</code> if a v w_ azzurri with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.VW_Azzurri fetchByPrimaryKey(
		it.ethica.esf.service.persistence.VW_AzzurriPK vw_AzzurriPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the v w_ azzurris.
	*
	* @return the v w_ azzurris
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.VW_Azzurri> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the v w_ azzurris.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.VW_AzzurriModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of v w_ azzurris
	* @param end the upper bound of the range of v w_ azzurris (not inclusive)
	* @return the range of v w_ azzurris
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.VW_Azzurri> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the v w_ azzurris.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.VW_AzzurriModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of v w_ azzurris
	* @param end the upper bound of the range of v w_ azzurris (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of v w_ azzurris
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.VW_Azzurri> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the v w_ azzurris from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of v w_ azzurris.
	*
	* @return the number of v w_ azzurris
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}