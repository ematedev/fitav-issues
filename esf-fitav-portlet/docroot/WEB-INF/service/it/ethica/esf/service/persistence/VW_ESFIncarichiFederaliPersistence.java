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

import it.ethica.esf.model.VW_ESFIncarichiFederali;

/**
 * The persistence interface for the v w_ e s f incarichi federali service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see VW_ESFIncarichiFederaliPersistenceImpl
 * @see VW_ESFIncarichiFederaliUtil
 * @generated
 */
public interface VW_ESFIncarichiFederaliPersistence extends BasePersistence<VW_ESFIncarichiFederali> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link VW_ESFIncarichiFederaliUtil} to access the v w_ e s f incarichi federali persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the v w_ e s f incarichi federalis where active_ = &#63; and esfUserId = &#63;.
	*
	* @param active_ the active_
	* @param esfUserId the esf user ID
	* @return the matching v w_ e s f incarichi federalis
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.VW_ESFIncarichiFederali> findBylistaIncarichi(
		boolean active_, long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the v w_ e s f incarichi federalis where active_ = &#63; and esfUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.VW_ESFIncarichiFederaliModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param active_ the active_
	* @param esfUserId the esf user ID
	* @param start the lower bound of the range of v w_ e s f incarichi federalis
	* @param end the upper bound of the range of v w_ e s f incarichi federalis (not inclusive)
	* @return the range of matching v w_ e s f incarichi federalis
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.VW_ESFIncarichiFederali> findBylistaIncarichi(
		boolean active_, long esfUserId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the v w_ e s f incarichi federalis where active_ = &#63; and esfUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.VW_ESFIncarichiFederaliModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param active_ the active_
	* @param esfUserId the esf user ID
	* @param start the lower bound of the range of v w_ e s f incarichi federalis
	* @param end the upper bound of the range of v w_ e s f incarichi federalis (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching v w_ e s f incarichi federalis
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.VW_ESFIncarichiFederali> findBylistaIncarichi(
		boolean active_, long esfUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first v w_ e s f incarichi federali in the ordered set where active_ = &#63; and esfUserId = &#63;.
	*
	* @param active_ the active_
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v w_ e s f incarichi federali
	* @throws it.ethica.esf.NoSuchVW_ESFIncarichiFederaliException if a matching v w_ e s f incarichi federali could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.VW_ESFIncarichiFederali findBylistaIncarichi_First(
		boolean active_, long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchVW_ESFIncarichiFederaliException;

	/**
	* Returns the first v w_ e s f incarichi federali in the ordered set where active_ = &#63; and esfUserId = &#63;.
	*
	* @param active_ the active_
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v w_ e s f incarichi federali, or <code>null</code> if a matching v w_ e s f incarichi federali could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.VW_ESFIncarichiFederali fetchBylistaIncarichi_First(
		boolean active_, long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last v w_ e s f incarichi federali in the ordered set where active_ = &#63; and esfUserId = &#63;.
	*
	* @param active_ the active_
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v w_ e s f incarichi federali
	* @throws it.ethica.esf.NoSuchVW_ESFIncarichiFederaliException if a matching v w_ e s f incarichi federali could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.VW_ESFIncarichiFederali findBylistaIncarichi_Last(
		boolean active_, long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchVW_ESFIncarichiFederaliException;

	/**
	* Returns the last v w_ e s f incarichi federali in the ordered set where active_ = &#63; and esfUserId = &#63;.
	*
	* @param active_ the active_
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v w_ e s f incarichi federali, or <code>null</code> if a matching v w_ e s f incarichi federali could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.VW_ESFIncarichiFederali fetchBylistaIncarichi_Last(
		boolean active_, long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the v w_ e s f incarichi federalis before and after the current v w_ e s f incarichi federali in the ordered set where active_ = &#63; and esfUserId = &#63;.
	*
	* @param vw_esfIncarichiFederaliPK the primary key of the current v w_ e s f incarichi federali
	* @param active_ the active_
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next v w_ e s f incarichi federali
	* @throws it.ethica.esf.NoSuchVW_ESFIncarichiFederaliException if a v w_ e s f incarichi federali with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.VW_ESFIncarichiFederali[] findBylistaIncarichi_PrevAndNext(
		it.ethica.esf.service.persistence.VW_ESFIncarichiFederaliPK vw_esfIncarichiFederaliPK,
		boolean active_, long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchVW_ESFIncarichiFederaliException;

	/**
	* Removes all the v w_ e s f incarichi federalis where active_ = &#63; and esfUserId = &#63; from the database.
	*
	* @param active_ the active_
	* @param esfUserId the esf user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeBylistaIncarichi(boolean active_, long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of v w_ e s f incarichi federalis where active_ = &#63; and esfUserId = &#63;.
	*
	* @param active_ the active_
	* @param esfUserId the esf user ID
	* @return the number of matching v w_ e s f incarichi federalis
	* @throws SystemException if a system exception occurred
	*/
	public int countBylistaIncarichi(boolean active_, long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the v w_ e s f incarichi federali in the entity cache if it is enabled.
	*
	* @param vw_esfIncarichiFederali the v w_ e s f incarichi federali
	*/
	public void cacheResult(
		it.ethica.esf.model.VW_ESFIncarichiFederali vw_esfIncarichiFederali);

	/**
	* Caches the v w_ e s f incarichi federalis in the entity cache if it is enabled.
	*
	* @param vw_esfIncarichiFederalis the v w_ e s f incarichi federalis
	*/
	public void cacheResult(
		java.util.List<it.ethica.esf.model.VW_ESFIncarichiFederali> vw_esfIncarichiFederalis);

	/**
	* Creates a new v w_ e s f incarichi federali with the primary key. Does not add the v w_ e s f incarichi federali to the database.
	*
	* @param vw_esfIncarichiFederaliPK the primary key for the new v w_ e s f incarichi federali
	* @return the new v w_ e s f incarichi federali
	*/
	public it.ethica.esf.model.VW_ESFIncarichiFederali create(
		it.ethica.esf.service.persistence.VW_ESFIncarichiFederaliPK vw_esfIncarichiFederaliPK);

	/**
	* Removes the v w_ e s f incarichi federali with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param vw_esfIncarichiFederaliPK the primary key of the v w_ e s f incarichi federali
	* @return the v w_ e s f incarichi federali that was removed
	* @throws it.ethica.esf.NoSuchVW_ESFIncarichiFederaliException if a v w_ e s f incarichi federali with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.VW_ESFIncarichiFederali remove(
		it.ethica.esf.service.persistence.VW_ESFIncarichiFederaliPK vw_esfIncarichiFederaliPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchVW_ESFIncarichiFederaliException;

	public it.ethica.esf.model.VW_ESFIncarichiFederali updateImpl(
		it.ethica.esf.model.VW_ESFIncarichiFederali vw_esfIncarichiFederali)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the v w_ e s f incarichi federali with the primary key or throws a {@link it.ethica.esf.NoSuchVW_ESFIncarichiFederaliException} if it could not be found.
	*
	* @param vw_esfIncarichiFederaliPK the primary key of the v w_ e s f incarichi federali
	* @return the v w_ e s f incarichi federali
	* @throws it.ethica.esf.NoSuchVW_ESFIncarichiFederaliException if a v w_ e s f incarichi federali with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.VW_ESFIncarichiFederali findByPrimaryKey(
		it.ethica.esf.service.persistence.VW_ESFIncarichiFederaliPK vw_esfIncarichiFederaliPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchVW_ESFIncarichiFederaliException;

	/**
	* Returns the v w_ e s f incarichi federali with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param vw_esfIncarichiFederaliPK the primary key of the v w_ e s f incarichi federali
	* @return the v w_ e s f incarichi federali, or <code>null</code> if a v w_ e s f incarichi federali with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.VW_ESFIncarichiFederali fetchByPrimaryKey(
		it.ethica.esf.service.persistence.VW_ESFIncarichiFederaliPK vw_esfIncarichiFederaliPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the v w_ e s f incarichi federalis.
	*
	* @return the v w_ e s f incarichi federalis
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.VW_ESFIncarichiFederali> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the v w_ e s f incarichi federalis.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.VW_ESFIncarichiFederaliModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of v w_ e s f incarichi federalis
	* @param end the upper bound of the range of v w_ e s f incarichi federalis (not inclusive)
	* @return the range of v w_ e s f incarichi federalis
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.VW_ESFIncarichiFederali> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the v w_ e s f incarichi federalis.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.VW_ESFIncarichiFederaliModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of v w_ e s f incarichi federalis
	* @param end the upper bound of the range of v w_ e s f incarichi federalis (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of v w_ e s f incarichi federalis
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.VW_ESFIncarichiFederali> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the v w_ e s f incarichi federalis from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of v w_ e s f incarichi federalis.
	*
	* @return the number of v w_ e s f incarichi federalis
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}