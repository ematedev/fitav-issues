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

import it.ethica.esf.model.VW_ESFListaIncarichi;

/**
 * The persistence interface for the v w_ e s f lista incarichi service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see VW_ESFListaIncarichiPersistenceImpl
 * @see VW_ESFListaIncarichiUtil
 * @generated
 */
public interface VW_ESFListaIncarichiPersistence extends BasePersistence<VW_ESFListaIncarichi> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link VW_ESFListaIncarichiUtil} to access the v w_ e s f lista incarichi persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the v w_ e s f lista incarichis where esfOrganizationId = &#63;.
	*
	* @param esfOrganizationId the esf organization ID
	* @return the matching v w_ e s f lista incarichis
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.VW_ESFListaIncarichi> findByorganizzazione(
		long esfOrganizationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the v w_ e s f lista incarichis where esfOrganizationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.VW_ESFListaIncarichiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfOrganizationId the esf organization ID
	* @param start the lower bound of the range of v w_ e s f lista incarichis
	* @param end the upper bound of the range of v w_ e s f lista incarichis (not inclusive)
	* @return the range of matching v w_ e s f lista incarichis
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.VW_ESFListaIncarichi> findByorganizzazione(
		long esfOrganizationId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the v w_ e s f lista incarichis where esfOrganizationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.VW_ESFListaIncarichiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfOrganizationId the esf organization ID
	* @param start the lower bound of the range of v w_ e s f lista incarichis
	* @param end the upper bound of the range of v w_ e s f lista incarichis (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching v w_ e s f lista incarichis
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.VW_ESFListaIncarichi> findByorganizzazione(
		long esfOrganizationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first v w_ e s f lista incarichi in the ordered set where esfOrganizationId = &#63;.
	*
	* @param esfOrganizationId the esf organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v w_ e s f lista incarichi
	* @throws it.ethica.esf.NoSuchVW_ESFListaIncarichiException if a matching v w_ e s f lista incarichi could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.VW_ESFListaIncarichi findByorganizzazione_First(
		long esfOrganizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchVW_ESFListaIncarichiException;

	/**
	* Returns the first v w_ e s f lista incarichi in the ordered set where esfOrganizationId = &#63;.
	*
	* @param esfOrganizationId the esf organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v w_ e s f lista incarichi, or <code>null</code> if a matching v w_ e s f lista incarichi could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.VW_ESFListaIncarichi fetchByorganizzazione_First(
		long esfOrganizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last v w_ e s f lista incarichi in the ordered set where esfOrganizationId = &#63;.
	*
	* @param esfOrganizationId the esf organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v w_ e s f lista incarichi
	* @throws it.ethica.esf.NoSuchVW_ESFListaIncarichiException if a matching v w_ e s f lista incarichi could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.VW_ESFListaIncarichi findByorganizzazione_Last(
		long esfOrganizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchVW_ESFListaIncarichiException;

	/**
	* Returns the last v w_ e s f lista incarichi in the ordered set where esfOrganizationId = &#63;.
	*
	* @param esfOrganizationId the esf organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v w_ e s f lista incarichi, or <code>null</code> if a matching v w_ e s f lista incarichi could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.VW_ESFListaIncarichi fetchByorganizzazione_Last(
		long esfOrganizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the v w_ e s f lista incarichis before and after the current v w_ e s f lista incarichi in the ordered set where esfOrganizationId = &#63;.
	*
	* @param vw_esfListaIncarichiPK the primary key of the current v w_ e s f lista incarichi
	* @param esfOrganizationId the esf organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next v w_ e s f lista incarichi
	* @throws it.ethica.esf.NoSuchVW_ESFListaIncarichiException if a v w_ e s f lista incarichi with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.VW_ESFListaIncarichi[] findByorganizzazione_PrevAndNext(
		VW_ESFListaIncarichiPK vw_esfListaIncarichiPK, long esfOrganizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchVW_ESFListaIncarichiException;

	/**
	* Removes all the v w_ e s f lista incarichis where esfOrganizationId = &#63; from the database.
	*
	* @param esfOrganizationId the esf organization ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByorganizzazione(long esfOrganizationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of v w_ e s f lista incarichis where esfOrganizationId = &#63;.
	*
	* @param esfOrganizationId the esf organization ID
	* @return the number of matching v w_ e s f lista incarichis
	* @throws SystemException if a system exception occurred
	*/
	public int countByorganizzazione(long esfOrganizationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the v w_ e s f lista incarichi in the entity cache if it is enabled.
	*
	* @param vw_esfListaIncarichi the v w_ e s f lista incarichi
	*/
	public void cacheResult(
		it.ethica.esf.model.VW_ESFListaIncarichi vw_esfListaIncarichi);

	/**
	* Caches the v w_ e s f lista incarichis in the entity cache if it is enabled.
	*
	* @param vw_esfListaIncarichis the v w_ e s f lista incarichis
	*/
	public void cacheResult(
		java.util.List<it.ethica.esf.model.VW_ESFListaIncarichi> vw_esfListaIncarichis);

	/**
	* Creates a new v w_ e s f lista incarichi with the primary key. Does not add the v w_ e s f lista incarichi to the database.
	*
	* @param vw_esfListaIncarichiPK the primary key for the new v w_ e s f lista incarichi
	* @return the new v w_ e s f lista incarichi
	*/
	public it.ethica.esf.model.VW_ESFListaIncarichi create(
		VW_ESFListaIncarichiPK vw_esfListaIncarichiPK);

	/**
	* Removes the v w_ e s f lista incarichi with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param vw_esfListaIncarichiPK the primary key of the v w_ e s f lista incarichi
	* @return the v w_ e s f lista incarichi that was removed
	* @throws it.ethica.esf.NoSuchVW_ESFListaIncarichiException if a v w_ e s f lista incarichi with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.VW_ESFListaIncarichi remove(
		VW_ESFListaIncarichiPK vw_esfListaIncarichiPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchVW_ESFListaIncarichiException;

	public it.ethica.esf.model.VW_ESFListaIncarichi updateImpl(
		it.ethica.esf.model.VW_ESFListaIncarichi vw_esfListaIncarichi)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the v w_ e s f lista incarichi with the primary key or throws a {@link it.ethica.esf.NoSuchVW_ESFListaIncarichiException} if it could not be found.
	*
	* @param vw_esfListaIncarichiPK the primary key of the v w_ e s f lista incarichi
	* @return the v w_ e s f lista incarichi
	* @throws it.ethica.esf.NoSuchVW_ESFListaIncarichiException if a v w_ e s f lista incarichi with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.VW_ESFListaIncarichi findByPrimaryKey(
		VW_ESFListaIncarichiPK vw_esfListaIncarichiPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchVW_ESFListaIncarichiException;

	/**
	* Returns the v w_ e s f lista incarichi with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param vw_esfListaIncarichiPK the primary key of the v w_ e s f lista incarichi
	* @return the v w_ e s f lista incarichi, or <code>null</code> if a v w_ e s f lista incarichi with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.VW_ESFListaIncarichi fetchByPrimaryKey(
		VW_ESFListaIncarichiPK vw_esfListaIncarichiPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the v w_ e s f lista incarichis.
	*
	* @return the v w_ e s f lista incarichis
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.VW_ESFListaIncarichi> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the v w_ e s f lista incarichis.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.VW_ESFListaIncarichiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of v w_ e s f lista incarichis
	* @param end the upper bound of the range of v w_ e s f lista incarichis (not inclusive)
	* @return the range of v w_ e s f lista incarichis
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.VW_ESFListaIncarichi> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the v w_ e s f lista incarichis.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.VW_ESFListaIncarichiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of v w_ e s f lista incarichis
	* @param end the upper bound of the range of v w_ e s f lista incarichis (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of v w_ e s f lista incarichis
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.VW_ESFListaIncarichi> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the v w_ e s f lista incarichis from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of v w_ e s f lista incarichis.
	*
	* @return the number of v w_ e s f lista incarichis
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}