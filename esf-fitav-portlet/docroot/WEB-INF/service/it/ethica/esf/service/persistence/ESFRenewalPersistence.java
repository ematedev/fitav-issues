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

package it.ethica.esf.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import it.ethica.esf.model.ESFRenewal;

/**
 * The persistence interface for the e s f renewal service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFRenewalPersistenceImpl
 * @see ESFRenewalUtil
 * @generated
 */
public interface ESFRenewalPersistence extends BasePersistence<ESFRenewal> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ESFRenewalUtil} to access the e s f renewal persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the e s f renewals where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching e s f renewals
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFRenewal> findByESFRenewalUser(
		long userId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f renewals where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFRenewalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of e s f renewals
	* @param end the upper bound of the range of e s f renewals (not inclusive)
	* @return the range of matching e s f renewals
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFRenewal> findByESFRenewalUser(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f renewals where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFRenewalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of e s f renewals
	* @param end the upper bound of the range of e s f renewals (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f renewals
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFRenewal> findByESFRenewalUser(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f renewal in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f renewal
	* @throws it.ethica.esf.NoSuchRenewalException if a matching e s f renewal could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFRenewal findByESFRenewalUser_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchRenewalException;

	/**
	* Returns the first e s f renewal in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f renewal, or <code>null</code> if a matching e s f renewal could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFRenewal fetchByESFRenewalUser_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f renewal in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f renewal
	* @throws it.ethica.esf.NoSuchRenewalException if a matching e s f renewal could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFRenewal findByESFRenewalUser_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchRenewalException;

	/**
	* Returns the last e s f renewal in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f renewal, or <code>null</code> if a matching e s f renewal could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFRenewal fetchByESFRenewalUser_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f renewals before and after the current e s f renewal in the ordered set where userId = &#63;.
	*
	* @param esfRenewalId the primary key of the current e s f renewal
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f renewal
	* @throws it.ethica.esf.NoSuchRenewalException if a e s f renewal with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFRenewal[] findByESFRenewalUser_PrevAndNext(
		long esfRenewalId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchRenewalException;

	/**
	* Removes all the e s f renewals where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByESFRenewalUser(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f renewals where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching e s f renewals
	* @throws SystemException if a system exception occurred
	*/
	public int countByESFRenewalUser(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f renewals where organizationId = &#63; and isTotal = &#63;.
	*
	* @param organizationId the organization ID
	* @param isTotal the is total
	* @return the matching e s f renewals
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFRenewal> findByOrgId_IsTotal(
		long organizationId, boolean isTotal)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f renewals where organizationId = &#63; and isTotal = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFRenewalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param organizationId the organization ID
	* @param isTotal the is total
	* @param start the lower bound of the range of e s f renewals
	* @param end the upper bound of the range of e s f renewals (not inclusive)
	* @return the range of matching e s f renewals
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFRenewal> findByOrgId_IsTotal(
		long organizationId, boolean isTotal, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f renewals where organizationId = &#63; and isTotal = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFRenewalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param organizationId the organization ID
	* @param isTotal the is total
	* @param start the lower bound of the range of e s f renewals
	* @param end the upper bound of the range of e s f renewals (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f renewals
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFRenewal> findByOrgId_IsTotal(
		long organizationId, boolean isTotal, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f renewal in the ordered set where organizationId = &#63; and isTotal = &#63;.
	*
	* @param organizationId the organization ID
	* @param isTotal the is total
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f renewal
	* @throws it.ethica.esf.NoSuchRenewalException if a matching e s f renewal could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFRenewal findByOrgId_IsTotal_First(
		long organizationId, boolean isTotal,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchRenewalException;

	/**
	* Returns the first e s f renewal in the ordered set where organizationId = &#63; and isTotal = &#63;.
	*
	* @param organizationId the organization ID
	* @param isTotal the is total
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f renewal, or <code>null</code> if a matching e s f renewal could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFRenewal fetchByOrgId_IsTotal_First(
		long organizationId, boolean isTotal,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f renewal in the ordered set where organizationId = &#63; and isTotal = &#63;.
	*
	* @param organizationId the organization ID
	* @param isTotal the is total
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f renewal
	* @throws it.ethica.esf.NoSuchRenewalException if a matching e s f renewal could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFRenewal findByOrgId_IsTotal_Last(
		long organizationId, boolean isTotal,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchRenewalException;

	/**
	* Returns the last e s f renewal in the ordered set where organizationId = &#63; and isTotal = &#63;.
	*
	* @param organizationId the organization ID
	* @param isTotal the is total
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f renewal, or <code>null</code> if a matching e s f renewal could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFRenewal fetchByOrgId_IsTotal_Last(
		long organizationId, boolean isTotal,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f renewals before and after the current e s f renewal in the ordered set where organizationId = &#63; and isTotal = &#63;.
	*
	* @param esfRenewalId the primary key of the current e s f renewal
	* @param organizationId the organization ID
	* @param isTotal the is total
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f renewal
	* @throws it.ethica.esf.NoSuchRenewalException if a e s f renewal with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFRenewal[] findByOrgId_IsTotal_PrevAndNext(
		long esfRenewalId, long organizationId, boolean isTotal,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchRenewalException;

	/**
	* Removes all the e s f renewals where organizationId = &#63; and isTotal = &#63; from the database.
	*
	* @param organizationId the organization ID
	* @param isTotal the is total
	* @throws SystemException if a system exception occurred
	*/
	public void removeByOrgId_IsTotal(long organizationId, boolean isTotal)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f renewals where organizationId = &#63; and isTotal = &#63;.
	*
	* @param organizationId the organization ID
	* @param isTotal the is total
	* @return the number of matching e s f renewals
	* @throws SystemException if a system exception occurred
	*/
	public int countByOrgId_IsTotal(long organizationId, boolean isTotal)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f renewals where renewalFatherId = &#63;.
	*
	* @param renewalFatherId the renewal father ID
	* @return the matching e s f renewals
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFRenewal> findByRenewalFatherId(
		long renewalFatherId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f renewals where renewalFatherId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFRenewalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param renewalFatherId the renewal father ID
	* @param start the lower bound of the range of e s f renewals
	* @param end the upper bound of the range of e s f renewals (not inclusive)
	* @return the range of matching e s f renewals
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFRenewal> findByRenewalFatherId(
		long renewalFatherId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f renewals where renewalFatherId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFRenewalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param renewalFatherId the renewal father ID
	* @param start the lower bound of the range of e s f renewals
	* @param end the upper bound of the range of e s f renewals (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f renewals
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFRenewal> findByRenewalFatherId(
		long renewalFatherId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f renewal in the ordered set where renewalFatherId = &#63;.
	*
	* @param renewalFatherId the renewal father ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f renewal
	* @throws it.ethica.esf.NoSuchRenewalException if a matching e s f renewal could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFRenewal findByRenewalFatherId_First(
		long renewalFatherId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchRenewalException;

	/**
	* Returns the first e s f renewal in the ordered set where renewalFatherId = &#63;.
	*
	* @param renewalFatherId the renewal father ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f renewal, or <code>null</code> if a matching e s f renewal could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFRenewal fetchByRenewalFatherId_First(
		long renewalFatherId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f renewal in the ordered set where renewalFatherId = &#63;.
	*
	* @param renewalFatherId the renewal father ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f renewal
	* @throws it.ethica.esf.NoSuchRenewalException if a matching e s f renewal could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFRenewal findByRenewalFatherId_Last(
		long renewalFatherId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchRenewalException;

	/**
	* Returns the last e s f renewal in the ordered set where renewalFatherId = &#63;.
	*
	* @param renewalFatherId the renewal father ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f renewal, or <code>null</code> if a matching e s f renewal could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFRenewal fetchByRenewalFatherId_Last(
		long renewalFatherId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f renewals before and after the current e s f renewal in the ordered set where renewalFatherId = &#63;.
	*
	* @param esfRenewalId the primary key of the current e s f renewal
	* @param renewalFatherId the renewal father ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f renewal
	* @throws it.ethica.esf.NoSuchRenewalException if a e s f renewal with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFRenewal[] findByRenewalFatherId_PrevAndNext(
		long esfRenewalId, long renewalFatherId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchRenewalException;

	/**
	* Removes all the e s f renewals where renewalFatherId = &#63; from the database.
	*
	* @param renewalFatherId the renewal father ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByRenewalFatherId(long renewalFatherId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f renewals where renewalFatherId = &#63;.
	*
	* @param renewalFatherId the renewal father ID
	* @return the number of matching e s f renewals
	* @throws SystemException if a system exception occurred
	*/
	public int countByRenewalFatherId(long renewalFatherId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f renewals where paymentReason = &#63; and organizationId = &#63;.
	*
	* @param paymentReason the payment reason
	* @param organizationId the organization ID
	* @return the matching e s f renewals
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFRenewal> findByOrgId_Reason(
		java.lang.String paymentReason, long organizationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f renewals where paymentReason = &#63; and organizationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFRenewalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param paymentReason the payment reason
	* @param organizationId the organization ID
	* @param start the lower bound of the range of e s f renewals
	* @param end the upper bound of the range of e s f renewals (not inclusive)
	* @return the range of matching e s f renewals
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFRenewal> findByOrgId_Reason(
		java.lang.String paymentReason, long organizationId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f renewals where paymentReason = &#63; and organizationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFRenewalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param paymentReason the payment reason
	* @param organizationId the organization ID
	* @param start the lower bound of the range of e s f renewals
	* @param end the upper bound of the range of e s f renewals (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f renewals
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFRenewal> findByOrgId_Reason(
		java.lang.String paymentReason, long organizationId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f renewal in the ordered set where paymentReason = &#63; and organizationId = &#63;.
	*
	* @param paymentReason the payment reason
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f renewal
	* @throws it.ethica.esf.NoSuchRenewalException if a matching e s f renewal could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFRenewal findByOrgId_Reason_First(
		java.lang.String paymentReason, long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchRenewalException;

	/**
	* Returns the first e s f renewal in the ordered set where paymentReason = &#63; and organizationId = &#63;.
	*
	* @param paymentReason the payment reason
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f renewal, or <code>null</code> if a matching e s f renewal could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFRenewal fetchByOrgId_Reason_First(
		java.lang.String paymentReason, long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f renewal in the ordered set where paymentReason = &#63; and organizationId = &#63;.
	*
	* @param paymentReason the payment reason
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f renewal
	* @throws it.ethica.esf.NoSuchRenewalException if a matching e s f renewal could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFRenewal findByOrgId_Reason_Last(
		java.lang.String paymentReason, long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchRenewalException;

	/**
	* Returns the last e s f renewal in the ordered set where paymentReason = &#63; and organizationId = &#63;.
	*
	* @param paymentReason the payment reason
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f renewal, or <code>null</code> if a matching e s f renewal could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFRenewal fetchByOrgId_Reason_Last(
		java.lang.String paymentReason, long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f renewals before and after the current e s f renewal in the ordered set where paymentReason = &#63; and organizationId = &#63;.
	*
	* @param esfRenewalId the primary key of the current e s f renewal
	* @param paymentReason the payment reason
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f renewal
	* @throws it.ethica.esf.NoSuchRenewalException if a e s f renewal with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFRenewal[] findByOrgId_Reason_PrevAndNext(
		long esfRenewalId, java.lang.String paymentReason, long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchRenewalException;

	/**
	* Removes all the e s f renewals where paymentReason = &#63; and organizationId = &#63; from the database.
	*
	* @param paymentReason the payment reason
	* @param organizationId the organization ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByOrgId_Reason(java.lang.String paymentReason,
		long organizationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f renewals where paymentReason = &#63; and organizationId = &#63;.
	*
	* @param paymentReason the payment reason
	* @param organizationId the organization ID
	* @return the number of matching e s f renewals
	* @throws SystemException if a system exception occurred
	*/
	public int countByOrgId_Reason(java.lang.String paymentReason,
		long organizationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f renewals where paymentReason = &#63; and isTotal = &#63;.
	*
	* @param paymentReason the payment reason
	* @param isTotal the is total
	* @return the matching e s f renewals
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFRenewal> findByReason_IsTotal(
		java.lang.String paymentReason, boolean isTotal)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f renewals where paymentReason = &#63; and isTotal = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFRenewalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param paymentReason the payment reason
	* @param isTotal the is total
	* @param start the lower bound of the range of e s f renewals
	* @param end the upper bound of the range of e s f renewals (not inclusive)
	* @return the range of matching e s f renewals
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFRenewal> findByReason_IsTotal(
		java.lang.String paymentReason, boolean isTotal, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f renewals where paymentReason = &#63; and isTotal = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFRenewalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param paymentReason the payment reason
	* @param isTotal the is total
	* @param start the lower bound of the range of e s f renewals
	* @param end the upper bound of the range of e s f renewals (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f renewals
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFRenewal> findByReason_IsTotal(
		java.lang.String paymentReason, boolean isTotal, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f renewal in the ordered set where paymentReason = &#63; and isTotal = &#63;.
	*
	* @param paymentReason the payment reason
	* @param isTotal the is total
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f renewal
	* @throws it.ethica.esf.NoSuchRenewalException if a matching e s f renewal could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFRenewal findByReason_IsTotal_First(
		java.lang.String paymentReason, boolean isTotal,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchRenewalException;

	/**
	* Returns the first e s f renewal in the ordered set where paymentReason = &#63; and isTotal = &#63;.
	*
	* @param paymentReason the payment reason
	* @param isTotal the is total
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f renewal, or <code>null</code> if a matching e s f renewal could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFRenewal fetchByReason_IsTotal_First(
		java.lang.String paymentReason, boolean isTotal,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f renewal in the ordered set where paymentReason = &#63; and isTotal = &#63;.
	*
	* @param paymentReason the payment reason
	* @param isTotal the is total
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f renewal
	* @throws it.ethica.esf.NoSuchRenewalException if a matching e s f renewal could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFRenewal findByReason_IsTotal_Last(
		java.lang.String paymentReason, boolean isTotal,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchRenewalException;

	/**
	* Returns the last e s f renewal in the ordered set where paymentReason = &#63; and isTotal = &#63;.
	*
	* @param paymentReason the payment reason
	* @param isTotal the is total
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f renewal, or <code>null</code> if a matching e s f renewal could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFRenewal fetchByReason_IsTotal_Last(
		java.lang.String paymentReason, boolean isTotal,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f renewals before and after the current e s f renewal in the ordered set where paymentReason = &#63; and isTotal = &#63;.
	*
	* @param esfRenewalId the primary key of the current e s f renewal
	* @param paymentReason the payment reason
	* @param isTotal the is total
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f renewal
	* @throws it.ethica.esf.NoSuchRenewalException if a e s f renewal with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFRenewal[] findByReason_IsTotal_PrevAndNext(
		long esfRenewalId, java.lang.String paymentReason, boolean isTotal,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchRenewalException;

	/**
	* Removes all the e s f renewals where paymentReason = &#63; and isTotal = &#63; from the database.
	*
	* @param paymentReason the payment reason
	* @param isTotal the is total
	* @throws SystemException if a system exception occurred
	*/
	public void removeByReason_IsTotal(java.lang.String paymentReason,
		boolean isTotal)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f renewals where paymentReason = &#63; and isTotal = &#63;.
	*
	* @param paymentReason the payment reason
	* @param isTotal the is total
	* @return the number of matching e s f renewals
	* @throws SystemException if a system exception occurred
	*/
	public int countByReason_IsTotal(java.lang.String paymentReason,
		boolean isTotal)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f renewals where organizationId = &#63; and reportingYear = &#63;.
	*
	* @param organizationId the organization ID
	* @param reportingYear the reporting year
	* @return the matching e s f renewals
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFRenewal> findByOrg_Year(
		long organizationId, int reportingYear)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f renewals where organizationId = &#63; and reportingYear = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFRenewalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param organizationId the organization ID
	* @param reportingYear the reporting year
	* @param start the lower bound of the range of e s f renewals
	* @param end the upper bound of the range of e s f renewals (not inclusive)
	* @return the range of matching e s f renewals
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFRenewal> findByOrg_Year(
		long organizationId, int reportingYear, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f renewals where organizationId = &#63; and reportingYear = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFRenewalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param organizationId the organization ID
	* @param reportingYear the reporting year
	* @param start the lower bound of the range of e s f renewals
	* @param end the upper bound of the range of e s f renewals (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f renewals
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFRenewal> findByOrg_Year(
		long organizationId, int reportingYear, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f renewal in the ordered set where organizationId = &#63; and reportingYear = &#63;.
	*
	* @param organizationId the organization ID
	* @param reportingYear the reporting year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f renewal
	* @throws it.ethica.esf.NoSuchRenewalException if a matching e s f renewal could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFRenewal findByOrg_Year_First(
		long organizationId, int reportingYear,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchRenewalException;

	/**
	* Returns the first e s f renewal in the ordered set where organizationId = &#63; and reportingYear = &#63;.
	*
	* @param organizationId the organization ID
	* @param reportingYear the reporting year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f renewal, or <code>null</code> if a matching e s f renewal could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFRenewal fetchByOrg_Year_First(
		long organizationId, int reportingYear,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f renewal in the ordered set where organizationId = &#63; and reportingYear = &#63;.
	*
	* @param organizationId the organization ID
	* @param reportingYear the reporting year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f renewal
	* @throws it.ethica.esf.NoSuchRenewalException if a matching e s f renewal could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFRenewal findByOrg_Year_Last(
		long organizationId, int reportingYear,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchRenewalException;

	/**
	* Returns the last e s f renewal in the ordered set where organizationId = &#63; and reportingYear = &#63;.
	*
	* @param organizationId the organization ID
	* @param reportingYear the reporting year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f renewal, or <code>null</code> if a matching e s f renewal could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFRenewal fetchByOrg_Year_Last(
		long organizationId, int reportingYear,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f renewals before and after the current e s f renewal in the ordered set where organizationId = &#63; and reportingYear = &#63;.
	*
	* @param esfRenewalId the primary key of the current e s f renewal
	* @param organizationId the organization ID
	* @param reportingYear the reporting year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f renewal
	* @throws it.ethica.esf.NoSuchRenewalException if a e s f renewal with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFRenewal[] findByOrg_Year_PrevAndNext(
		long esfRenewalId, long organizationId, int reportingYear,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchRenewalException;

	/**
	* Removes all the e s f renewals where organizationId = &#63; and reportingYear = &#63; from the database.
	*
	* @param organizationId the organization ID
	* @param reportingYear the reporting year
	* @throws SystemException if a system exception occurred
	*/
	public void removeByOrg_Year(long organizationId, int reportingYear)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f renewals where organizationId = &#63; and reportingYear = &#63;.
	*
	* @param organizationId the organization ID
	* @param reportingYear the reporting year
	* @return the number of matching e s f renewals
	* @throws SystemException if a system exception occurred
	*/
	public int countByOrg_Year(long organizationId, int reportingYear)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f renewals where paymentReceived = &#63;.
	*
	* @param paymentReceived the payment received
	* @return the matching e s f renewals
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFRenewal> findByPaymentReceived(
		boolean paymentReceived)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f renewals where paymentReceived = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFRenewalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param paymentReceived the payment received
	* @param start the lower bound of the range of e s f renewals
	* @param end the upper bound of the range of e s f renewals (not inclusive)
	* @return the range of matching e s f renewals
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFRenewal> findByPaymentReceived(
		boolean paymentReceived, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f renewals where paymentReceived = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFRenewalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param paymentReceived the payment received
	* @param start the lower bound of the range of e s f renewals
	* @param end the upper bound of the range of e s f renewals (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f renewals
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFRenewal> findByPaymentReceived(
		boolean paymentReceived, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f renewal in the ordered set where paymentReceived = &#63;.
	*
	* @param paymentReceived the payment received
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f renewal
	* @throws it.ethica.esf.NoSuchRenewalException if a matching e s f renewal could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFRenewal findByPaymentReceived_First(
		boolean paymentReceived,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchRenewalException;

	/**
	* Returns the first e s f renewal in the ordered set where paymentReceived = &#63;.
	*
	* @param paymentReceived the payment received
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f renewal, or <code>null</code> if a matching e s f renewal could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFRenewal fetchByPaymentReceived_First(
		boolean paymentReceived,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f renewal in the ordered set where paymentReceived = &#63;.
	*
	* @param paymentReceived the payment received
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f renewal
	* @throws it.ethica.esf.NoSuchRenewalException if a matching e s f renewal could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFRenewal findByPaymentReceived_Last(
		boolean paymentReceived,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchRenewalException;

	/**
	* Returns the last e s f renewal in the ordered set where paymentReceived = &#63;.
	*
	* @param paymentReceived the payment received
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f renewal, or <code>null</code> if a matching e s f renewal could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFRenewal fetchByPaymentReceived_Last(
		boolean paymentReceived,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f renewals before and after the current e s f renewal in the ordered set where paymentReceived = &#63;.
	*
	* @param esfRenewalId the primary key of the current e s f renewal
	* @param paymentReceived the payment received
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f renewal
	* @throws it.ethica.esf.NoSuchRenewalException if a e s f renewal with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFRenewal[] findByPaymentReceived_PrevAndNext(
		long esfRenewalId, boolean paymentReceived,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchRenewalException;

	/**
	* Removes all the e s f renewals where paymentReceived = &#63; from the database.
	*
	* @param paymentReceived the payment received
	* @throws SystemException if a system exception occurred
	*/
	public void removeByPaymentReceived(boolean paymentReceived)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f renewals where paymentReceived = &#63;.
	*
	* @param paymentReceived the payment received
	* @return the number of matching e s f renewals
	* @throws SystemException if a system exception occurred
	*/
	public int countByPaymentReceived(boolean paymentReceived)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the e s f renewal in the entity cache if it is enabled.
	*
	* @param esfRenewal the e s f renewal
	*/
	public void cacheResult(it.ethica.esf.model.ESFRenewal esfRenewal);

	/**
	* Caches the e s f renewals in the entity cache if it is enabled.
	*
	* @param esfRenewals the e s f renewals
	*/
	public void cacheResult(
		java.util.List<it.ethica.esf.model.ESFRenewal> esfRenewals);

	/**
	* Creates a new e s f renewal with the primary key. Does not add the e s f renewal to the database.
	*
	* @param esfRenewalId the primary key for the new e s f renewal
	* @return the new e s f renewal
	*/
	public it.ethica.esf.model.ESFRenewal create(long esfRenewalId);

	/**
	* Removes the e s f renewal with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfRenewalId the primary key of the e s f renewal
	* @return the e s f renewal that was removed
	* @throws it.ethica.esf.NoSuchRenewalException if a e s f renewal with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFRenewal remove(long esfRenewalId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchRenewalException;

	public it.ethica.esf.model.ESFRenewal updateImpl(
		it.ethica.esf.model.ESFRenewal esfRenewal)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f renewal with the primary key or throws a {@link it.ethica.esf.NoSuchRenewalException} if it could not be found.
	*
	* @param esfRenewalId the primary key of the e s f renewal
	* @return the e s f renewal
	* @throws it.ethica.esf.NoSuchRenewalException if a e s f renewal with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFRenewal findByPrimaryKey(long esfRenewalId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchRenewalException;

	/**
	* Returns the e s f renewal with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param esfRenewalId the primary key of the e s f renewal
	* @return the e s f renewal, or <code>null</code> if a e s f renewal with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFRenewal fetchByPrimaryKey(long esfRenewalId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f renewals.
	*
	* @return the e s f renewals
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFRenewal> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f renewals.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFRenewalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f renewals
	* @param end the upper bound of the range of e s f renewals (not inclusive)
	* @return the range of e s f renewals
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFRenewal> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f renewals.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFRenewalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f renewals
	* @param end the upper bound of the range of e s f renewals (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of e s f renewals
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFRenewal> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the e s f renewals from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f renewals.
	*
	* @return the number of e s f renewals
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}