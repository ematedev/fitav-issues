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

import com.ethica.esf.model.ESFArticleDelivered;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the e s f article delivered service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFArticleDeliveredPersistenceImpl
 * @see ESFArticleDeliveredUtil
 * @generated
 */
public interface ESFArticleDeliveredPersistence extends BasePersistence<ESFArticleDelivered> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ESFArticleDeliveredUtil} to access the e s f article delivered persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the e s f article delivereds where esfArticleId = &#63;.
	*
	* @param esfArticleId the esf article ID
	* @return the matching e s f article delivereds
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ethica.esf.model.ESFArticleDelivered> findByEsfArticleId(
		long esfArticleId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f article delivereds where esfArticleId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ethica.esf.model.impl.ESFArticleDeliveredModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfArticleId the esf article ID
	* @param start the lower bound of the range of e s f article delivereds
	* @param end the upper bound of the range of e s f article delivereds (not inclusive)
	* @return the range of matching e s f article delivereds
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ethica.esf.model.ESFArticleDelivered> findByEsfArticleId(
		long esfArticleId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f article delivereds where esfArticleId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ethica.esf.model.impl.ESFArticleDeliveredModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfArticleId the esf article ID
	* @param start the lower bound of the range of e s f article delivereds
	* @param end the upper bound of the range of e s f article delivereds (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f article delivereds
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ethica.esf.model.ESFArticleDelivered> findByEsfArticleId(
		long esfArticleId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f article delivered in the ordered set where esfArticleId = &#63;.
	*
	* @param esfArticleId the esf article ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f article delivered
	* @throws com.ethica.esf.NoSuchArticleDeliveredException if a matching e s f article delivered could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ethica.esf.model.ESFArticleDelivered findByEsfArticleId_First(
		long esfArticleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ethica.esf.NoSuchArticleDeliveredException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f article delivered in the ordered set where esfArticleId = &#63;.
	*
	* @param esfArticleId the esf article ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f article delivered, or <code>null</code> if a matching e s f article delivered could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ethica.esf.model.ESFArticleDelivered fetchByEsfArticleId_First(
		long esfArticleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f article delivered in the ordered set where esfArticleId = &#63;.
	*
	* @param esfArticleId the esf article ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f article delivered
	* @throws com.ethica.esf.NoSuchArticleDeliveredException if a matching e s f article delivered could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ethica.esf.model.ESFArticleDelivered findByEsfArticleId_Last(
		long esfArticleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ethica.esf.NoSuchArticleDeliveredException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f article delivered in the ordered set where esfArticleId = &#63;.
	*
	* @param esfArticleId the esf article ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f article delivered, or <code>null</code> if a matching e s f article delivered could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ethica.esf.model.ESFArticleDelivered fetchByEsfArticleId_Last(
		long esfArticleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f article delivereds before and after the current e s f article delivered in the ordered set where esfArticleId = &#63;.
	*
	* @param esfArticleDeliveredId the primary key of the current e s f article delivered
	* @param esfArticleId the esf article ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f article delivered
	* @throws com.ethica.esf.NoSuchArticleDeliveredException if a e s f article delivered with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ethica.esf.model.ESFArticleDelivered[] findByEsfArticleId_PrevAndNext(
		long esfArticleDeliveredId, long esfArticleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ethica.esf.NoSuchArticleDeliveredException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the e s f article delivereds where esfArticleId = &#63; from the database.
	*
	* @param esfArticleId the esf article ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByEsfArticleId(long esfArticleId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f article delivereds where esfArticleId = &#63;.
	*
	* @param esfArticleId the esf article ID
	* @return the number of matching e s f article delivereds
	* @throws SystemException if a system exception occurred
	*/
	public int countByEsfArticleId(long esfArticleId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f article delivereds where esfShooterId = &#63;.
	*
	* @param esfShooterId the esf shooter ID
	* @return the matching e s f article delivereds
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ethica.esf.model.ESFArticleDelivered> findByEsfShooterId(
		long esfShooterId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f article delivereds where esfShooterId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ethica.esf.model.impl.ESFArticleDeliveredModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfShooterId the esf shooter ID
	* @param start the lower bound of the range of e s f article delivereds
	* @param end the upper bound of the range of e s f article delivereds (not inclusive)
	* @return the range of matching e s f article delivereds
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ethica.esf.model.ESFArticleDelivered> findByEsfShooterId(
		long esfShooterId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f article delivereds where esfShooterId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ethica.esf.model.impl.ESFArticleDeliveredModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfShooterId the esf shooter ID
	* @param start the lower bound of the range of e s f article delivereds
	* @param end the upper bound of the range of e s f article delivereds (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f article delivereds
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ethica.esf.model.ESFArticleDelivered> findByEsfShooterId(
		long esfShooterId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f article delivered in the ordered set where esfShooterId = &#63;.
	*
	* @param esfShooterId the esf shooter ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f article delivered
	* @throws com.ethica.esf.NoSuchArticleDeliveredException if a matching e s f article delivered could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ethica.esf.model.ESFArticleDelivered findByEsfShooterId_First(
		long esfShooterId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ethica.esf.NoSuchArticleDeliveredException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f article delivered in the ordered set where esfShooterId = &#63;.
	*
	* @param esfShooterId the esf shooter ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f article delivered, or <code>null</code> if a matching e s f article delivered could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ethica.esf.model.ESFArticleDelivered fetchByEsfShooterId_First(
		long esfShooterId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f article delivered in the ordered set where esfShooterId = &#63;.
	*
	* @param esfShooterId the esf shooter ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f article delivered
	* @throws com.ethica.esf.NoSuchArticleDeliveredException if a matching e s f article delivered could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ethica.esf.model.ESFArticleDelivered findByEsfShooterId_Last(
		long esfShooterId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ethica.esf.NoSuchArticleDeliveredException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f article delivered in the ordered set where esfShooterId = &#63;.
	*
	* @param esfShooterId the esf shooter ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f article delivered, or <code>null</code> if a matching e s f article delivered could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ethica.esf.model.ESFArticleDelivered fetchByEsfShooterId_Last(
		long esfShooterId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f article delivereds before and after the current e s f article delivered in the ordered set where esfShooterId = &#63;.
	*
	* @param esfArticleDeliveredId the primary key of the current e s f article delivered
	* @param esfShooterId the esf shooter ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f article delivered
	* @throws com.ethica.esf.NoSuchArticleDeliveredException if a e s f article delivered with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ethica.esf.model.ESFArticleDelivered[] findByEsfShooterId_PrevAndNext(
		long esfArticleDeliveredId, long esfShooterId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ethica.esf.NoSuchArticleDeliveredException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the e s f article delivereds where esfShooterId = &#63; from the database.
	*
	* @param esfShooterId the esf shooter ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByEsfShooterId(long esfShooterId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f article delivereds where esfShooterId = &#63;.
	*
	* @param esfShooterId the esf shooter ID
	* @return the number of matching e s f article delivereds
	* @throws SystemException if a system exception occurred
	*/
	public int countByEsfShooterId(long esfShooterId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the e s f article delivered in the entity cache if it is enabled.
	*
	* @param esfArticleDelivered the e s f article delivered
	*/
	public void cacheResult(
		com.ethica.esf.model.ESFArticleDelivered esfArticleDelivered);

	/**
	* Caches the e s f article delivereds in the entity cache if it is enabled.
	*
	* @param esfArticleDelivereds the e s f article delivereds
	*/
	public void cacheResult(
		java.util.List<com.ethica.esf.model.ESFArticleDelivered> esfArticleDelivereds);

	/**
	* Creates a new e s f article delivered with the primary key. Does not add the e s f article delivered to the database.
	*
	* @param esfArticleDeliveredId the primary key for the new e s f article delivered
	* @return the new e s f article delivered
	*/
	public com.ethica.esf.model.ESFArticleDelivered create(
		long esfArticleDeliveredId);

	/**
	* Removes the e s f article delivered with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfArticleDeliveredId the primary key of the e s f article delivered
	* @return the e s f article delivered that was removed
	* @throws com.ethica.esf.NoSuchArticleDeliveredException if a e s f article delivered with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ethica.esf.model.ESFArticleDelivered remove(
		long esfArticleDeliveredId)
		throws com.ethica.esf.NoSuchArticleDeliveredException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.ethica.esf.model.ESFArticleDelivered updateImpl(
		com.ethica.esf.model.ESFArticleDelivered esfArticleDelivered)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f article delivered with the primary key or throws a {@link com.ethica.esf.NoSuchArticleDeliveredException} if it could not be found.
	*
	* @param esfArticleDeliveredId the primary key of the e s f article delivered
	* @return the e s f article delivered
	* @throws com.ethica.esf.NoSuchArticleDeliveredException if a e s f article delivered with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ethica.esf.model.ESFArticleDelivered findByPrimaryKey(
		long esfArticleDeliveredId)
		throws com.ethica.esf.NoSuchArticleDeliveredException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f article delivered with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param esfArticleDeliveredId the primary key of the e s f article delivered
	* @return the e s f article delivered, or <code>null</code> if a e s f article delivered with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ethica.esf.model.ESFArticleDelivered fetchByPrimaryKey(
		long esfArticleDeliveredId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f article delivereds.
	*
	* @return the e s f article delivereds
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ethica.esf.model.ESFArticleDelivered> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f article delivereds.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ethica.esf.model.impl.ESFArticleDeliveredModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f article delivereds
	* @param end the upper bound of the range of e s f article delivereds (not inclusive)
	* @return the range of e s f article delivereds
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ethica.esf.model.ESFArticleDelivered> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f article delivereds.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ethica.esf.model.impl.ESFArticleDeliveredModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f article delivereds
	* @param end the upper bound of the range of e s f article delivereds (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of e s f article delivereds
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ethica.esf.model.ESFArticleDelivered> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the e s f article delivereds from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f article delivereds.
	*
	* @return the number of e s f article delivereds
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}