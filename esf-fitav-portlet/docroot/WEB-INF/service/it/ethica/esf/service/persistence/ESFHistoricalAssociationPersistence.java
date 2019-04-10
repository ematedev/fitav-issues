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

import it.ethica.esf.model.ESFHistoricalAssociation;

/**
 * The persistence interface for the e s f historical association service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFHistoricalAssociationPersistenceImpl
 * @see ESFHistoricalAssociationUtil
 * @generated
 */
public interface ESFHistoricalAssociationPersistence extends BasePersistence<ESFHistoricalAssociation> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ESFHistoricalAssociationUtil} to access the e s f historical association persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the e s f historical associations where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @return the matching e s f historical associations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFHistoricalAssociation> findByOrg_Date(
		long organizationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f historical associations where organizationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFHistoricalAssociationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param organizationId the organization ID
	* @param start the lower bound of the range of e s f historical associations
	* @param end the upper bound of the range of e s f historical associations (not inclusive)
	* @return the range of matching e s f historical associations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFHistoricalAssociation> findByOrg_Date(
		long organizationId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f historical associations where organizationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFHistoricalAssociationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param organizationId the organization ID
	* @param start the lower bound of the range of e s f historical associations
	* @param end the upper bound of the range of e s f historical associations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f historical associations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFHistoricalAssociation> findByOrg_Date(
		long organizationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f historical association in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f historical association
	* @throws it.ethica.esf.NoSuchHistoricalAssociationException if a matching e s f historical association could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFHistoricalAssociation findByOrg_Date_First(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchHistoricalAssociationException;

	/**
	* Returns the first e s f historical association in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f historical association, or <code>null</code> if a matching e s f historical association could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFHistoricalAssociation fetchByOrg_Date_First(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f historical association in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f historical association
	* @throws it.ethica.esf.NoSuchHistoricalAssociationException if a matching e s f historical association could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFHistoricalAssociation findByOrg_Date_Last(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchHistoricalAssociationException;

	/**
	* Returns the last e s f historical association in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f historical association, or <code>null</code> if a matching e s f historical association could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFHistoricalAssociation fetchByOrg_Date_Last(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f historical associations before and after the current e s f historical association in the ordered set where organizationId = &#63;.
	*
	* @param idHistoricalAssociation the primary key of the current e s f historical association
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f historical association
	* @throws it.ethica.esf.NoSuchHistoricalAssociationException if a e s f historical association with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFHistoricalAssociation[] findByOrg_Date_PrevAndNext(
		long idHistoricalAssociation, long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchHistoricalAssociationException;

	/**
	* Removes all the e s f historical associations where organizationId = &#63; from the database.
	*
	* @param organizationId the organization ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByOrg_Date(long organizationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f historical associations where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @return the number of matching e s f historical associations
	* @throws SystemException if a system exception occurred
	*/
	public int countByOrg_Date(long organizationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the e s f historical association in the entity cache if it is enabled.
	*
	* @param esfHistoricalAssociation the e s f historical association
	*/
	public void cacheResult(
		it.ethica.esf.model.ESFHistoricalAssociation esfHistoricalAssociation);

	/**
	* Caches the e s f historical associations in the entity cache if it is enabled.
	*
	* @param esfHistoricalAssociations the e s f historical associations
	*/
	public void cacheResult(
		java.util.List<it.ethica.esf.model.ESFHistoricalAssociation> esfHistoricalAssociations);

	/**
	* Creates a new e s f historical association with the primary key. Does not add the e s f historical association to the database.
	*
	* @param idHistoricalAssociation the primary key for the new e s f historical association
	* @return the new e s f historical association
	*/
	public it.ethica.esf.model.ESFHistoricalAssociation create(
		long idHistoricalAssociation);

	/**
	* Removes the e s f historical association with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param idHistoricalAssociation the primary key of the e s f historical association
	* @return the e s f historical association that was removed
	* @throws it.ethica.esf.NoSuchHistoricalAssociationException if a e s f historical association with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFHistoricalAssociation remove(
		long idHistoricalAssociation)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchHistoricalAssociationException;

	public it.ethica.esf.model.ESFHistoricalAssociation updateImpl(
		it.ethica.esf.model.ESFHistoricalAssociation esfHistoricalAssociation)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f historical association with the primary key or throws a {@link it.ethica.esf.NoSuchHistoricalAssociationException} if it could not be found.
	*
	* @param idHistoricalAssociation the primary key of the e s f historical association
	* @return the e s f historical association
	* @throws it.ethica.esf.NoSuchHistoricalAssociationException if a e s f historical association with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFHistoricalAssociation findByPrimaryKey(
		long idHistoricalAssociation)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchHistoricalAssociationException;

	/**
	* Returns the e s f historical association with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param idHistoricalAssociation the primary key of the e s f historical association
	* @return the e s f historical association, or <code>null</code> if a e s f historical association with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFHistoricalAssociation fetchByPrimaryKey(
		long idHistoricalAssociation)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f historical associations.
	*
	* @return the e s f historical associations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFHistoricalAssociation> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f historical associations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFHistoricalAssociationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f historical associations
	* @param end the upper bound of the range of e s f historical associations (not inclusive)
	* @return the range of e s f historical associations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFHistoricalAssociation> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f historical associations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFHistoricalAssociationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f historical associations
	* @param end the upper bound of the range of e s f historical associations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of e s f historical associations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFHistoricalAssociation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the e s f historical associations from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f historical associations.
	*
	* @return the number of e s f historical associations
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}