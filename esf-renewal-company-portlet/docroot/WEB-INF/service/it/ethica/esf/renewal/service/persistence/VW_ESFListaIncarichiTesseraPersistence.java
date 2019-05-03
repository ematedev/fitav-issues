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

package it.ethica.esf.renewal.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import it.ethica.esf.renewal.model.VW_ESFListaIncarichiTessera;

/**
 * The persistence interface for the v w_ e s f lista incarichi tessera service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see VW_ESFListaIncarichiTesseraPersistenceImpl
 * @see VW_ESFListaIncarichiTesseraUtil
 * @generated
 */
public interface VW_ESFListaIncarichiTesseraPersistence extends BasePersistence<VW_ESFListaIncarichiTessera> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link VW_ESFListaIncarichiTesseraUtil} to access the v w_ e s f lista incarichi tessera persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the v w_ e s f lista incarichi tesseras where esfOrganizationId = &#63;.
	*
	* @param esfOrganizationId the esf organization ID
	* @return the matching v w_ e s f lista incarichi tesseras
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.renewal.model.VW_ESFListaIncarichiTessera> findByorganizzazione(
		long esfOrganizationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the v w_ e s f lista incarichi tesseras where esfOrganizationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.renewal.model.impl.VW_ESFListaIncarichiTesseraModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfOrganizationId the esf organization ID
	* @param start the lower bound of the range of v w_ e s f lista incarichi tesseras
	* @param end the upper bound of the range of v w_ e s f lista incarichi tesseras (not inclusive)
	* @return the range of matching v w_ e s f lista incarichi tesseras
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.renewal.model.VW_ESFListaIncarichiTessera> findByorganizzazione(
		long esfOrganizationId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the v w_ e s f lista incarichi tesseras where esfOrganizationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.renewal.model.impl.VW_ESFListaIncarichiTesseraModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfOrganizationId the esf organization ID
	* @param start the lower bound of the range of v w_ e s f lista incarichi tesseras
	* @param end the upper bound of the range of v w_ e s f lista incarichi tesseras (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching v w_ e s f lista incarichi tesseras
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.renewal.model.VW_ESFListaIncarichiTessera> findByorganizzazione(
		long esfOrganizationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first v w_ e s f lista incarichi tessera in the ordered set where esfOrganizationId = &#63;.
	*
	* @param esfOrganizationId the esf organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v w_ e s f lista incarichi tessera
	* @throws it.ethica.esf.renewal.NoSuchVW_ESFListaIncarichiTesseraException if a matching v w_ e s f lista incarichi tessera could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.renewal.model.VW_ESFListaIncarichiTessera findByorganizzazione_First(
		long esfOrganizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.renewal.NoSuchVW_ESFListaIncarichiTesseraException;

	/**
	* Returns the first v w_ e s f lista incarichi tessera in the ordered set where esfOrganizationId = &#63;.
	*
	* @param esfOrganizationId the esf organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v w_ e s f lista incarichi tessera, or <code>null</code> if a matching v w_ e s f lista incarichi tessera could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.renewal.model.VW_ESFListaIncarichiTessera fetchByorganizzazione_First(
		long esfOrganizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last v w_ e s f lista incarichi tessera in the ordered set where esfOrganizationId = &#63;.
	*
	* @param esfOrganizationId the esf organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v w_ e s f lista incarichi tessera
	* @throws it.ethica.esf.renewal.NoSuchVW_ESFListaIncarichiTesseraException if a matching v w_ e s f lista incarichi tessera could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.renewal.model.VW_ESFListaIncarichiTessera findByorganizzazione_Last(
		long esfOrganizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.renewal.NoSuchVW_ESFListaIncarichiTesseraException;

	/**
	* Returns the last v w_ e s f lista incarichi tessera in the ordered set where esfOrganizationId = &#63;.
	*
	* @param esfOrganizationId the esf organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v w_ e s f lista incarichi tessera, or <code>null</code> if a matching v w_ e s f lista incarichi tessera could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.renewal.model.VW_ESFListaIncarichiTessera fetchByorganizzazione_Last(
		long esfOrganizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the v w_ e s f lista incarichi tesseras before and after the current v w_ e s f lista incarichi tessera in the ordered set where esfOrganizationId = &#63;.
	*
	* @param vw_esfListaIncarichiTesseraPK the primary key of the current v w_ e s f lista incarichi tessera
	* @param esfOrganizationId the esf organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next v w_ e s f lista incarichi tessera
	* @throws it.ethica.esf.renewal.NoSuchVW_ESFListaIncarichiTesseraException if a v w_ e s f lista incarichi tessera with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.renewal.model.VW_ESFListaIncarichiTessera[] findByorganizzazione_PrevAndNext(
		it.ethica.esf.renewal.service.persistence.VW_ESFListaIncarichiTesseraPK vw_esfListaIncarichiTesseraPK,
		long esfOrganizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.renewal.NoSuchVW_ESFListaIncarichiTesseraException;

	/**
	* Removes all the v w_ e s f lista incarichi tesseras where esfOrganizationId = &#63; from the database.
	*
	* @param esfOrganizationId the esf organization ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByorganizzazione(long esfOrganizationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of v w_ e s f lista incarichi tesseras where esfOrganizationId = &#63;.
	*
	* @param esfOrganizationId the esf organization ID
	* @return the number of matching v w_ e s f lista incarichi tesseras
	* @throws SystemException if a system exception occurred
	*/
	public int countByorganizzazione(long esfOrganizationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the v w_ e s f lista incarichi tessera in the entity cache if it is enabled.
	*
	* @param vw_esfListaIncarichiTessera the v w_ e s f lista incarichi tessera
	*/
	public void cacheResult(
		it.ethica.esf.renewal.model.VW_ESFListaIncarichiTessera vw_esfListaIncarichiTessera);

	/**
	* Caches the v w_ e s f lista incarichi tesseras in the entity cache if it is enabled.
	*
	* @param vw_esfListaIncarichiTesseras the v w_ e s f lista incarichi tesseras
	*/
	public void cacheResult(
		java.util.List<it.ethica.esf.renewal.model.VW_ESFListaIncarichiTessera> vw_esfListaIncarichiTesseras);

	/**
	* Creates a new v w_ e s f lista incarichi tessera with the primary key. Does not add the v w_ e s f lista incarichi tessera to the database.
	*
	* @param vw_esfListaIncarichiTesseraPK the primary key for the new v w_ e s f lista incarichi tessera
	* @return the new v w_ e s f lista incarichi tessera
	*/
	public it.ethica.esf.renewal.model.VW_ESFListaIncarichiTessera create(
		it.ethica.esf.renewal.service.persistence.VW_ESFListaIncarichiTesseraPK vw_esfListaIncarichiTesseraPK);

	/**
	* Removes the v w_ e s f lista incarichi tessera with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param vw_esfListaIncarichiTesseraPK the primary key of the v w_ e s f lista incarichi tessera
	* @return the v w_ e s f lista incarichi tessera that was removed
	* @throws it.ethica.esf.renewal.NoSuchVW_ESFListaIncarichiTesseraException if a v w_ e s f lista incarichi tessera with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.renewal.model.VW_ESFListaIncarichiTessera remove(
		it.ethica.esf.renewal.service.persistence.VW_ESFListaIncarichiTesseraPK vw_esfListaIncarichiTesseraPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.renewal.NoSuchVW_ESFListaIncarichiTesseraException;

	public it.ethica.esf.renewal.model.VW_ESFListaIncarichiTessera updateImpl(
		it.ethica.esf.renewal.model.VW_ESFListaIncarichiTessera vw_esfListaIncarichiTessera)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the v w_ e s f lista incarichi tessera with the primary key or throws a {@link it.ethica.esf.renewal.NoSuchVW_ESFListaIncarichiTesseraException} if it could not be found.
	*
	* @param vw_esfListaIncarichiTesseraPK the primary key of the v w_ e s f lista incarichi tessera
	* @return the v w_ e s f lista incarichi tessera
	* @throws it.ethica.esf.renewal.NoSuchVW_ESFListaIncarichiTesseraException if a v w_ e s f lista incarichi tessera with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.renewal.model.VW_ESFListaIncarichiTessera findByPrimaryKey(
		it.ethica.esf.renewal.service.persistence.VW_ESFListaIncarichiTesseraPK vw_esfListaIncarichiTesseraPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.renewal.NoSuchVW_ESFListaIncarichiTesseraException;

	/**
	* Returns the v w_ e s f lista incarichi tessera with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param vw_esfListaIncarichiTesseraPK the primary key of the v w_ e s f lista incarichi tessera
	* @return the v w_ e s f lista incarichi tessera, or <code>null</code> if a v w_ e s f lista incarichi tessera with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.renewal.model.VW_ESFListaIncarichiTessera fetchByPrimaryKey(
		it.ethica.esf.renewal.service.persistence.VW_ESFListaIncarichiTesseraPK vw_esfListaIncarichiTesseraPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the v w_ e s f lista incarichi tesseras.
	*
	* @return the v w_ e s f lista incarichi tesseras
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.renewal.model.VW_ESFListaIncarichiTessera> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the v w_ e s f lista incarichi tesseras.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.renewal.model.impl.VW_ESFListaIncarichiTesseraModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of v w_ e s f lista incarichi tesseras
	* @param end the upper bound of the range of v w_ e s f lista incarichi tesseras (not inclusive)
	* @return the range of v w_ e s f lista incarichi tesseras
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.renewal.model.VW_ESFListaIncarichiTessera> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the v w_ e s f lista incarichi tesseras.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.renewal.model.impl.VW_ESFListaIncarichiTesseraModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of v w_ e s f lista incarichi tesseras
	* @param end the upper bound of the range of v w_ e s f lista incarichi tesseras (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of v w_ e s f lista incarichi tesseras
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.renewal.model.VW_ESFListaIncarichiTessera> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the v w_ e s f lista incarichi tesseras from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of v w_ e s f lista incarichi tesseras.
	*
	* @return the number of v w_ e s f lista incarichi tesseras
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}