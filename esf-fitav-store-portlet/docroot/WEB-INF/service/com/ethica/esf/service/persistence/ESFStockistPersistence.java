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

package com.ethica.esf.service.persistence;

import com.ethica.esf.model.ESFStockist;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the e s f stockist service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFStockistPersistenceImpl
 * @see ESFStockistUtil
 * @generated
 */
public interface ESFStockistPersistence extends BasePersistence<ESFStockist> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ESFStockistUtil} to access the e s f stockist persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the e s f stockist where name = &#63; or throws a {@link com.ethica.esf.NoSuchStockistException} if it could not be found.
	*
	* @param name the name
	* @return the matching e s f stockist
	* @throws com.ethica.esf.NoSuchStockistException if a matching e s f stockist could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ethica.esf.model.ESFStockist findByStockistName(
		java.lang.String name)
		throws com.ethica.esf.NoSuchStockistException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f stockist where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param name the name
	* @return the matching e s f stockist, or <code>null</code> if a matching e s f stockist could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ethica.esf.model.ESFStockist fetchByStockistName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f stockist where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param name the name
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching e s f stockist, or <code>null</code> if a matching e s f stockist could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ethica.esf.model.ESFStockist fetchByStockistName(
		java.lang.String name, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the e s f stockist where name = &#63; from the database.
	*
	* @param name the name
	* @return the e s f stockist that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.ethica.esf.model.ESFStockist removeByStockistName(
		java.lang.String name)
		throws com.ethica.esf.NoSuchStockistException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f stockists where name = &#63;.
	*
	* @param name the name
	* @return the number of matching e s f stockists
	* @throws SystemException if a system exception occurred
	*/
	public int countByStockistName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f stockists where esfStockistId = &#63;.
	*
	* @param esfStockistId the esf stockist ID
	* @return the matching e s f stockists
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ethica.esf.model.ESFStockist> findByStockistId(
		long esfStockistId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f stockists where esfStockistId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ethica.esf.model.impl.ESFStockistModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfStockistId the esf stockist ID
	* @param start the lower bound of the range of e s f stockists
	* @param end the upper bound of the range of e s f stockists (not inclusive)
	* @return the range of matching e s f stockists
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ethica.esf.model.ESFStockist> findByStockistId(
		long esfStockistId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f stockists where esfStockistId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ethica.esf.model.impl.ESFStockistModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfStockistId the esf stockist ID
	* @param start the lower bound of the range of e s f stockists
	* @param end the upper bound of the range of e s f stockists (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f stockists
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ethica.esf.model.ESFStockist> findByStockistId(
		long esfStockistId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f stockist in the ordered set where esfStockistId = &#63;.
	*
	* @param esfStockistId the esf stockist ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f stockist
	* @throws com.ethica.esf.NoSuchStockistException if a matching e s f stockist could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ethica.esf.model.ESFStockist findByStockistId_First(
		long esfStockistId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ethica.esf.NoSuchStockistException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f stockist in the ordered set where esfStockistId = &#63;.
	*
	* @param esfStockistId the esf stockist ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f stockist, or <code>null</code> if a matching e s f stockist could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ethica.esf.model.ESFStockist fetchByStockistId_First(
		long esfStockistId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f stockist in the ordered set where esfStockistId = &#63;.
	*
	* @param esfStockistId the esf stockist ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f stockist
	* @throws com.ethica.esf.NoSuchStockistException if a matching e s f stockist could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ethica.esf.model.ESFStockist findByStockistId_Last(
		long esfStockistId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ethica.esf.NoSuchStockistException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f stockist in the ordered set where esfStockistId = &#63;.
	*
	* @param esfStockistId the esf stockist ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f stockist, or <code>null</code> if a matching e s f stockist could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ethica.esf.model.ESFStockist fetchByStockistId_Last(
		long esfStockistId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the e s f stockists where esfStockistId = &#63; from the database.
	*
	* @param esfStockistId the esf stockist ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByStockistId(long esfStockistId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f stockists where esfStockistId = &#63;.
	*
	* @param esfStockistId the esf stockist ID
	* @return the number of matching e s f stockists
	* @throws SystemException if a system exception occurred
	*/
	public int countByStockistId(long esfStockistId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the e s f stockist in the entity cache if it is enabled.
	*
	* @param esfStockist the e s f stockist
	*/
	public void cacheResult(com.ethica.esf.model.ESFStockist esfStockist);

	/**
	* Caches the e s f stockists in the entity cache if it is enabled.
	*
	* @param esfStockists the e s f stockists
	*/
	public void cacheResult(
		java.util.List<com.ethica.esf.model.ESFStockist> esfStockists);

	/**
	* Creates a new e s f stockist with the primary key. Does not add the e s f stockist to the database.
	*
	* @param esfStockistId the primary key for the new e s f stockist
	* @return the new e s f stockist
	*/
	public com.ethica.esf.model.ESFStockist create(long esfStockistId);

	/**
	* Removes the e s f stockist with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfStockistId the primary key of the e s f stockist
	* @return the e s f stockist that was removed
	* @throws com.ethica.esf.NoSuchStockistException if a e s f stockist with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ethica.esf.model.ESFStockist remove(long esfStockistId)
		throws com.ethica.esf.NoSuchStockistException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.ethica.esf.model.ESFStockist updateImpl(
		com.ethica.esf.model.ESFStockist esfStockist)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f stockist with the primary key or throws a {@link com.ethica.esf.NoSuchStockistException} if it could not be found.
	*
	* @param esfStockistId the primary key of the e s f stockist
	* @return the e s f stockist
	* @throws com.ethica.esf.NoSuchStockistException if a e s f stockist with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ethica.esf.model.ESFStockist findByPrimaryKey(long esfStockistId)
		throws com.ethica.esf.NoSuchStockistException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f stockist with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param esfStockistId the primary key of the e s f stockist
	* @return the e s f stockist, or <code>null</code> if a e s f stockist with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ethica.esf.model.ESFStockist fetchByPrimaryKey(
		long esfStockistId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f stockists.
	*
	* @return the e s f stockists
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ethica.esf.model.ESFStockist> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f stockists.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ethica.esf.model.impl.ESFStockistModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f stockists
	* @param end the upper bound of the range of e s f stockists (not inclusive)
	* @return the range of e s f stockists
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ethica.esf.model.ESFStockist> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f stockists.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ethica.esf.model.impl.ESFStockistModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f stockists
	* @param end the upper bound of the range of e s f stockists (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of e s f stockists
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ethica.esf.model.ESFStockist> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the e s f stockists from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f stockists.
	*
	* @return the number of e s f stockists
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}