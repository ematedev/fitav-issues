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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import it.ethica.esf.model.ESFMatchResult;

import java.util.List;

/**
 * The persistence utility for the e s f match result service. This utility wraps {@link ESFMatchResultPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFMatchResultPersistence
 * @see ESFMatchResultPersistenceImpl
 * @generated
 */
public class ESFMatchResultUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(ESFMatchResult esfMatchResult) {
		getPersistence().clearCache(esfMatchResult);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ESFMatchResult> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ESFMatchResult> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ESFMatchResult> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ESFMatchResult update(ESFMatchResult esfMatchResult)
		throws SystemException {
		return getPersistence().update(esfMatchResult);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ESFMatchResult update(ESFMatchResult esfMatchResult,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(esfMatchResult, serviceContext);
	}

	/**
	* Returns all the e s f match results where esfMatchId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @return the matching e s f match results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFMatchResult> findByEsfMatchId(
		long esfMatchId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByEsfMatchId(esfMatchId);
	}

	/**
	* Returns a range of all the e s f match results where esfMatchId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFMatchResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfMatchId the esf match ID
	* @param start the lower bound of the range of e s f match results
	* @param end the upper bound of the range of e s f match results (not inclusive)
	* @return the range of matching e s f match results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFMatchResult> findByEsfMatchId(
		long esfMatchId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByEsfMatchId(esfMatchId, start, end);
	}

	/**
	* Returns an ordered range of all the e s f match results where esfMatchId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFMatchResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfMatchId the esf match ID
	* @param start the lower bound of the range of e s f match results
	* @param end the upper bound of the range of e s f match results (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f match results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFMatchResult> findByEsfMatchId(
		long esfMatchId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByEsfMatchId(esfMatchId, start, end, orderByComparator);
	}

	/**
	* Returns the first e s f match result in the ordered set where esfMatchId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f match result
	* @throws it.ethica.esf.NoSuchMatchResultException if a matching e s f match result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFMatchResult findByEsfMatchId_First(
		long esfMatchId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchMatchResultException {
		return getPersistence()
				   .findByEsfMatchId_First(esfMatchId, orderByComparator);
	}

	/**
	* Returns the first e s f match result in the ordered set where esfMatchId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f match result, or <code>null</code> if a matching e s f match result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFMatchResult fetchByEsfMatchId_First(
		long esfMatchId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByEsfMatchId_First(esfMatchId, orderByComparator);
	}

	/**
	* Returns the last e s f match result in the ordered set where esfMatchId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f match result
	* @throws it.ethica.esf.NoSuchMatchResultException if a matching e s f match result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFMatchResult findByEsfMatchId_Last(
		long esfMatchId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchMatchResultException {
		return getPersistence()
				   .findByEsfMatchId_Last(esfMatchId, orderByComparator);
	}

	/**
	* Returns the last e s f match result in the ordered set where esfMatchId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f match result, or <code>null</code> if a matching e s f match result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFMatchResult fetchByEsfMatchId_Last(
		long esfMatchId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByEsfMatchId_Last(esfMatchId, orderByComparator);
	}

	/**
	* Returns the e s f match results before and after the current e s f match result in the ordered set where esfMatchId = &#63;.
	*
	* @param esfMatchResultId the primary key of the current e s f match result
	* @param esfMatchId the esf match ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f match result
	* @throws it.ethica.esf.NoSuchMatchResultException if a e s f match result with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFMatchResult[] findByEsfMatchId_PrevAndNext(
		long esfMatchResultId, long esfMatchId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchMatchResultException {
		return getPersistence()
				   .findByEsfMatchId_PrevAndNext(esfMatchResultId, esfMatchId,
			orderByComparator);
	}

	/**
	* Removes all the e s f match results where esfMatchId = &#63; from the database.
	*
	* @param esfMatchId the esf match ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByEsfMatchId(long esfMatchId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByEsfMatchId(esfMatchId);
	}

	/**
	* Returns the number of e s f match results where esfMatchId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @return the number of matching e s f match results
	* @throws SystemException if a system exception occurred
	*/
	public static int countByEsfMatchId(long esfMatchId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByEsfMatchId(esfMatchId);
	}

	/**
	* Returns all the e s f match results where esfPartecipantId = &#63;.
	*
	* @param esfPartecipantId the esf partecipant ID
	* @return the matching e s f match results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFMatchResult> findByResultUserId(
		long esfPartecipantId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByResultUserId(esfPartecipantId);
	}

	/**
	* Returns a range of all the e s f match results where esfPartecipantId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFMatchResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfPartecipantId the esf partecipant ID
	* @param start the lower bound of the range of e s f match results
	* @param end the upper bound of the range of e s f match results (not inclusive)
	* @return the range of matching e s f match results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFMatchResult> findByResultUserId(
		long esfPartecipantId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByResultUserId(esfPartecipantId, start, end);
	}

	/**
	* Returns an ordered range of all the e s f match results where esfPartecipantId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFMatchResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfPartecipantId the esf partecipant ID
	* @param start the lower bound of the range of e s f match results
	* @param end the upper bound of the range of e s f match results (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f match results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFMatchResult> findByResultUserId(
		long esfPartecipantId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByResultUserId(esfPartecipantId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first e s f match result in the ordered set where esfPartecipantId = &#63;.
	*
	* @param esfPartecipantId the esf partecipant ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f match result
	* @throws it.ethica.esf.NoSuchMatchResultException if a matching e s f match result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFMatchResult findByResultUserId_First(
		long esfPartecipantId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchMatchResultException {
		return getPersistence()
				   .findByResultUserId_First(esfPartecipantId, orderByComparator);
	}

	/**
	* Returns the first e s f match result in the ordered set where esfPartecipantId = &#63;.
	*
	* @param esfPartecipantId the esf partecipant ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f match result, or <code>null</code> if a matching e s f match result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFMatchResult fetchByResultUserId_First(
		long esfPartecipantId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByResultUserId_First(esfPartecipantId,
			orderByComparator);
	}

	/**
	* Returns the last e s f match result in the ordered set where esfPartecipantId = &#63;.
	*
	* @param esfPartecipantId the esf partecipant ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f match result
	* @throws it.ethica.esf.NoSuchMatchResultException if a matching e s f match result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFMatchResult findByResultUserId_Last(
		long esfPartecipantId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchMatchResultException {
		return getPersistence()
				   .findByResultUserId_Last(esfPartecipantId, orderByComparator);
	}

	/**
	* Returns the last e s f match result in the ordered set where esfPartecipantId = &#63;.
	*
	* @param esfPartecipantId the esf partecipant ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f match result, or <code>null</code> if a matching e s f match result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFMatchResult fetchByResultUserId_Last(
		long esfPartecipantId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByResultUserId_Last(esfPartecipantId, orderByComparator);
	}

	/**
	* Returns the e s f match results before and after the current e s f match result in the ordered set where esfPartecipantId = &#63;.
	*
	* @param esfMatchResultId the primary key of the current e s f match result
	* @param esfPartecipantId the esf partecipant ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f match result
	* @throws it.ethica.esf.NoSuchMatchResultException if a e s f match result with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFMatchResult[] findByResultUserId_PrevAndNext(
		long esfMatchResultId, long esfPartecipantId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchMatchResultException {
		return getPersistence()
				   .findByResultUserId_PrevAndNext(esfMatchResultId,
			esfPartecipantId, orderByComparator);
	}

	/**
	* Removes all the e s f match results where esfPartecipantId = &#63; from the database.
	*
	* @param esfPartecipantId the esf partecipant ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByResultUserId(long esfPartecipantId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByResultUserId(esfPartecipantId);
	}

	/**
	* Returns the number of e s f match results where esfPartecipantId = &#63;.
	*
	* @param esfPartecipantId the esf partecipant ID
	* @return the number of matching e s f match results
	* @throws SystemException if a system exception occurred
	*/
	public static int countByResultUserId(long esfPartecipantId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByResultUserId(esfPartecipantId);
	}

	/**
	* Returns all the e s f match results where esfPartecipantId = &#63; and esfMatchId = &#63;.
	*
	* @param esfPartecipantId the esf partecipant ID
	* @param esfMatchId the esf match ID
	* @return the matching e s f match results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFMatchResult> findBymatchId_PartecipantId(
		long esfPartecipantId, long esfMatchId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBymatchId_PartecipantId(esfPartecipantId, esfMatchId);
	}

	/**
	* Returns a range of all the e s f match results where esfPartecipantId = &#63; and esfMatchId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFMatchResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfPartecipantId the esf partecipant ID
	* @param esfMatchId the esf match ID
	* @param start the lower bound of the range of e s f match results
	* @param end the upper bound of the range of e s f match results (not inclusive)
	* @return the range of matching e s f match results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFMatchResult> findBymatchId_PartecipantId(
		long esfPartecipantId, long esfMatchId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBymatchId_PartecipantId(esfPartecipantId, esfMatchId,
			start, end);
	}

	/**
	* Returns an ordered range of all the e s f match results where esfPartecipantId = &#63; and esfMatchId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFMatchResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfPartecipantId the esf partecipant ID
	* @param esfMatchId the esf match ID
	* @param start the lower bound of the range of e s f match results
	* @param end the upper bound of the range of e s f match results (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f match results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFMatchResult> findBymatchId_PartecipantId(
		long esfPartecipantId, long esfMatchId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBymatchId_PartecipantId(esfPartecipantId, esfMatchId,
			start, end, orderByComparator);
	}

	/**
	* Returns the first e s f match result in the ordered set where esfPartecipantId = &#63; and esfMatchId = &#63;.
	*
	* @param esfPartecipantId the esf partecipant ID
	* @param esfMatchId the esf match ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f match result
	* @throws it.ethica.esf.NoSuchMatchResultException if a matching e s f match result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFMatchResult findBymatchId_PartecipantId_First(
		long esfPartecipantId, long esfMatchId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchMatchResultException {
		return getPersistence()
				   .findBymatchId_PartecipantId_First(esfPartecipantId,
			esfMatchId, orderByComparator);
	}

	/**
	* Returns the first e s f match result in the ordered set where esfPartecipantId = &#63; and esfMatchId = &#63;.
	*
	* @param esfPartecipantId the esf partecipant ID
	* @param esfMatchId the esf match ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f match result, or <code>null</code> if a matching e s f match result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFMatchResult fetchBymatchId_PartecipantId_First(
		long esfPartecipantId, long esfMatchId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBymatchId_PartecipantId_First(esfPartecipantId,
			esfMatchId, orderByComparator);
	}

	/**
	* Returns the last e s f match result in the ordered set where esfPartecipantId = &#63; and esfMatchId = &#63;.
	*
	* @param esfPartecipantId the esf partecipant ID
	* @param esfMatchId the esf match ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f match result
	* @throws it.ethica.esf.NoSuchMatchResultException if a matching e s f match result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFMatchResult findBymatchId_PartecipantId_Last(
		long esfPartecipantId, long esfMatchId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchMatchResultException {
		return getPersistence()
				   .findBymatchId_PartecipantId_Last(esfPartecipantId,
			esfMatchId, orderByComparator);
	}

	/**
	* Returns the last e s f match result in the ordered set where esfPartecipantId = &#63; and esfMatchId = &#63;.
	*
	* @param esfPartecipantId the esf partecipant ID
	* @param esfMatchId the esf match ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f match result, or <code>null</code> if a matching e s f match result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFMatchResult fetchBymatchId_PartecipantId_Last(
		long esfPartecipantId, long esfMatchId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBymatchId_PartecipantId_Last(esfPartecipantId,
			esfMatchId, orderByComparator);
	}

	/**
	* Returns the e s f match results before and after the current e s f match result in the ordered set where esfPartecipantId = &#63; and esfMatchId = &#63;.
	*
	* @param esfMatchResultId the primary key of the current e s f match result
	* @param esfPartecipantId the esf partecipant ID
	* @param esfMatchId the esf match ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f match result
	* @throws it.ethica.esf.NoSuchMatchResultException if a e s f match result with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFMatchResult[] findBymatchId_PartecipantId_PrevAndNext(
		long esfMatchResultId, long esfPartecipantId, long esfMatchId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchMatchResultException {
		return getPersistence()
				   .findBymatchId_PartecipantId_PrevAndNext(esfMatchResultId,
			esfPartecipantId, esfMatchId, orderByComparator);
	}

	/**
	* Removes all the e s f match results where esfPartecipantId = &#63; and esfMatchId = &#63; from the database.
	*
	* @param esfPartecipantId the esf partecipant ID
	* @param esfMatchId the esf match ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBymatchId_PartecipantId(long esfPartecipantId,
		long esfMatchId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeBymatchId_PartecipantId(esfPartecipantId, esfMatchId);
	}

	/**
	* Returns the number of e s f match results where esfPartecipantId = &#63; and esfMatchId = &#63;.
	*
	* @param esfPartecipantId the esf partecipant ID
	* @param esfMatchId the esf match ID
	* @return the number of matching e s f match results
	* @throws SystemException if a system exception occurred
	*/
	public static int countBymatchId_PartecipantId(long esfPartecipantId,
		long esfMatchId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countBymatchId_PartecipantId(esfPartecipantId, esfMatchId);
	}

	/**
	* Caches the e s f match result in the entity cache if it is enabled.
	*
	* @param esfMatchResult the e s f match result
	*/
	public static void cacheResult(
		it.ethica.esf.model.ESFMatchResult esfMatchResult) {
		getPersistence().cacheResult(esfMatchResult);
	}

	/**
	* Caches the e s f match results in the entity cache if it is enabled.
	*
	* @param esfMatchResults the e s f match results
	*/
	public static void cacheResult(
		java.util.List<it.ethica.esf.model.ESFMatchResult> esfMatchResults) {
		getPersistence().cacheResult(esfMatchResults);
	}

	/**
	* Creates a new e s f match result with the primary key. Does not add the e s f match result to the database.
	*
	* @param esfMatchResultId the primary key for the new e s f match result
	* @return the new e s f match result
	*/
	public static it.ethica.esf.model.ESFMatchResult create(
		long esfMatchResultId) {
		return getPersistence().create(esfMatchResultId);
	}

	/**
	* Removes the e s f match result with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfMatchResultId the primary key of the e s f match result
	* @return the e s f match result that was removed
	* @throws it.ethica.esf.NoSuchMatchResultException if a e s f match result with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFMatchResult remove(
		long esfMatchResultId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchMatchResultException {
		return getPersistence().remove(esfMatchResultId);
	}

	public static it.ethica.esf.model.ESFMatchResult updateImpl(
		it.ethica.esf.model.ESFMatchResult esfMatchResult)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(esfMatchResult);
	}

	/**
	* Returns the e s f match result with the primary key or throws a {@link it.ethica.esf.NoSuchMatchResultException} if it could not be found.
	*
	* @param esfMatchResultId the primary key of the e s f match result
	* @return the e s f match result
	* @throws it.ethica.esf.NoSuchMatchResultException if a e s f match result with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFMatchResult findByPrimaryKey(
		long esfMatchResultId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchMatchResultException {
		return getPersistence().findByPrimaryKey(esfMatchResultId);
	}

	/**
	* Returns the e s f match result with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param esfMatchResultId the primary key of the e s f match result
	* @return the e s f match result, or <code>null</code> if a e s f match result with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFMatchResult fetchByPrimaryKey(
		long esfMatchResultId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(esfMatchResultId);
	}

	/**
	* Returns all the e s f match results.
	*
	* @return the e s f match results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFMatchResult> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the e s f match results.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFMatchResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f match results
	* @param end the upper bound of the range of e s f match results (not inclusive)
	* @return the range of e s f match results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFMatchResult> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the e s f match results.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFMatchResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f match results
	* @param end the upper bound of the range of e s f match results (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of e s f match results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFMatchResult> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the e s f match results from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of e s f match results.
	*
	* @return the number of e s f match results
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ESFMatchResultPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ESFMatchResultPersistence)PortletBeanLocatorUtil.locate(it.ethica.esf.service.ClpSerializer.getServletContextName(),
					ESFMatchResultPersistence.class.getName());

			ReferenceRegistry.registerReference(ESFMatchResultUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ESFMatchResultPersistence persistence) {
	}

	private static ESFMatchResultPersistence _persistence;
}