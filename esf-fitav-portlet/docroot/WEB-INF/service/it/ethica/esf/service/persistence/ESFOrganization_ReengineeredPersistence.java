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

import it.ethica.esf.model.ESFOrganization_Reengineered;

/**
 * The persistence interface for the e s f organization_ reengineered service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFOrganization_ReengineeredPersistenceImpl
 * @see ESFOrganization_ReengineeredUtil
 * @generated
 */
public interface ESFOrganization_ReengineeredPersistence extends BasePersistence<ESFOrganization_Reengineered> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ESFOrganization_ReengineeredUtil} to access the e s f organization_ reengineered persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the e s f organization_ reengineereds where type_ = &#63;.
	*
	* @param type_ the type_
	* @return the matching e s f organization_ reengineereds
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFOrganization_Reengineered> findByFindOrganizationByType(
		int type_) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f organization_ reengineereds where type_ = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFOrganization_ReengineeredModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param type_ the type_
	* @param start the lower bound of the range of e s f organization_ reengineereds
	* @param end the upper bound of the range of e s f organization_ reengineereds (not inclusive)
	* @return the range of matching e s f organization_ reengineereds
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFOrganization_Reengineered> findByFindOrganizationByType(
		int type_, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f organization_ reengineereds where type_ = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFOrganization_ReengineeredModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param type_ the type_
	* @param start the lower bound of the range of e s f organization_ reengineereds
	* @param end the upper bound of the range of e s f organization_ reengineereds (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f organization_ reengineereds
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFOrganization_Reengineered> findByFindOrganizationByType(
		int type_, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f organization_ reengineered in the ordered set where type_ = &#63;.
	*
	* @param type_ the type_
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f organization_ reengineered
	* @throws it.ethica.esf.NoSuchOrganization_ReengineeredException if a matching e s f organization_ reengineered could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFOrganization_Reengineered findByFindOrganizationByType_First(
		int type_,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchOrganization_ReengineeredException;

	/**
	* Returns the first e s f organization_ reengineered in the ordered set where type_ = &#63;.
	*
	* @param type_ the type_
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f organization_ reengineered, or <code>null</code> if a matching e s f organization_ reengineered could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFOrganization_Reengineered fetchByFindOrganizationByType_First(
		int type_,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f organization_ reengineered in the ordered set where type_ = &#63;.
	*
	* @param type_ the type_
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f organization_ reengineered
	* @throws it.ethica.esf.NoSuchOrganization_ReengineeredException if a matching e s f organization_ reengineered could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFOrganization_Reengineered findByFindOrganizationByType_Last(
		int type_,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchOrganization_ReengineeredException;

	/**
	* Returns the last e s f organization_ reengineered in the ordered set where type_ = &#63;.
	*
	* @param type_ the type_
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f organization_ reengineered, or <code>null</code> if a matching e s f organization_ reengineered could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFOrganization_Reengineered fetchByFindOrganizationByType_Last(
		int type_,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f organization_ reengineereds before and after the current e s f organization_ reengineered in the ordered set where type_ = &#63;.
	*
	* @param esfOrganizationId the primary key of the current e s f organization_ reengineered
	* @param type_ the type_
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f organization_ reengineered
	* @throws it.ethica.esf.NoSuchOrganization_ReengineeredException if a e s f organization_ reengineered with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFOrganization_Reengineered[] findByFindOrganizationByType_PrevAndNext(
		long esfOrganizationId, int type_,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchOrganization_ReengineeredException;

	/**
	* Removes all the e s f organization_ reengineereds where type_ = &#63; from the database.
	*
	* @param type_ the type_
	* @throws SystemException if a system exception occurred
	*/
	public void removeByFindOrganizationByType(int type_)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f organization_ reengineereds where type_ = &#63;.
	*
	* @param type_ the type_
	* @return the number of matching e s f organization_ reengineereds
	* @throws SystemException if a system exception occurred
	*/
	public int countByFindOrganizationByType(int type_)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the e s f organization_ reengineered in the entity cache if it is enabled.
	*
	* @param esfOrganization_Reengineered the e s f organization_ reengineered
	*/
	public void cacheResult(
		it.ethica.esf.model.ESFOrganization_Reengineered esfOrganization_Reengineered);

	/**
	* Caches the e s f organization_ reengineereds in the entity cache if it is enabled.
	*
	* @param esfOrganization_Reengineereds the e s f organization_ reengineereds
	*/
	public void cacheResult(
		java.util.List<it.ethica.esf.model.ESFOrganization_Reengineered> esfOrganization_Reengineereds);

	/**
	* Creates a new e s f organization_ reengineered with the primary key. Does not add the e s f organization_ reengineered to the database.
	*
	* @param esfOrganizationId the primary key for the new e s f organization_ reengineered
	* @return the new e s f organization_ reengineered
	*/
	public it.ethica.esf.model.ESFOrganization_Reengineered create(
		long esfOrganizationId);

	/**
	* Removes the e s f organization_ reengineered with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfOrganizationId the primary key of the e s f organization_ reengineered
	* @return the e s f organization_ reengineered that was removed
	* @throws it.ethica.esf.NoSuchOrganization_ReengineeredException if a e s f organization_ reengineered with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFOrganization_Reengineered remove(
		long esfOrganizationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchOrganization_ReengineeredException;

	public it.ethica.esf.model.ESFOrganization_Reengineered updateImpl(
		it.ethica.esf.model.ESFOrganization_Reengineered esfOrganization_Reengineered)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f organization_ reengineered with the primary key or throws a {@link it.ethica.esf.NoSuchOrganization_ReengineeredException} if it could not be found.
	*
	* @param esfOrganizationId the primary key of the e s f organization_ reengineered
	* @return the e s f organization_ reengineered
	* @throws it.ethica.esf.NoSuchOrganization_ReengineeredException if a e s f organization_ reengineered with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFOrganization_Reengineered findByPrimaryKey(
		long esfOrganizationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchOrganization_ReengineeredException;

	/**
	* Returns the e s f organization_ reengineered with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param esfOrganizationId the primary key of the e s f organization_ reengineered
	* @return the e s f organization_ reengineered, or <code>null</code> if a e s f organization_ reengineered with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFOrganization_Reengineered fetchByPrimaryKey(
		long esfOrganizationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f organization_ reengineereds.
	*
	* @return the e s f organization_ reengineereds
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFOrganization_Reengineered> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f organization_ reengineereds.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFOrganization_ReengineeredModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f organization_ reengineereds
	* @param end the upper bound of the range of e s f organization_ reengineereds (not inclusive)
	* @return the range of e s f organization_ reengineereds
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFOrganization_Reengineered> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f organization_ reengineereds.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFOrganization_ReengineeredModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f organization_ reengineereds
	* @param end the upper bound of the range of e s f organization_ reengineereds (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of e s f organization_ reengineereds
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFOrganization_Reengineered> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the e s f organization_ reengineereds from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f organization_ reengineereds.
	*
	* @return the number of e s f organization_ reengineereds
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}