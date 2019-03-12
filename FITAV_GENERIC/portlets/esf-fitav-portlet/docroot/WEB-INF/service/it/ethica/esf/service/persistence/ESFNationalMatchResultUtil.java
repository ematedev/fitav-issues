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

import it.ethica.esf.model.ESFNationalMatchResult;

import java.util.List;

/**
 * The persistence utility for the e s f national match result service. This utility wraps {@link ESFNationalMatchResultPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFNationalMatchResultPersistence
 * @see ESFNationalMatchResultPersistenceImpl
 * @generated
 */
public class ESFNationalMatchResultUtil {
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
	public static void clearCache(ESFNationalMatchResult esfNationalMatchResult) {
		getPersistence().clearCache(esfNationalMatchResult);
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
	public static List<ESFNationalMatchResult> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ESFNationalMatchResult> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ESFNationalMatchResult> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ESFNationalMatchResult update(
		ESFNationalMatchResult esfNationalMatchResult)
		throws SystemException {
		return getPersistence().update(esfNationalMatchResult);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ESFNationalMatchResult update(
		ESFNationalMatchResult esfNationalMatchResult,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(esfNationalMatchResult, serviceContext);
	}

	/**
	* Returns all the e s f national match results where esfMatchId = &#63; and esfUserId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfUserId the esf user ID
	* @return the matching e s f national match results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFNationalMatchResult> findByESFMatchId_ESFUserId(
		long esfMatchId, long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByESFMatchId_ESFUserId(esfMatchId, esfUserId);
	}

	/**
	* Returns a range of all the e s f national match results where esfMatchId = &#63; and esfUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalMatchResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfMatchId the esf match ID
	* @param esfUserId the esf user ID
	* @param start the lower bound of the range of e s f national match results
	* @param end the upper bound of the range of e s f national match results (not inclusive)
	* @return the range of matching e s f national match results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFNationalMatchResult> findByESFMatchId_ESFUserId(
		long esfMatchId, long esfUserId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByESFMatchId_ESFUserId(esfMatchId, esfUserId, start, end);
	}

	/**
	* Returns an ordered range of all the e s f national match results where esfMatchId = &#63; and esfUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalMatchResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfMatchId the esf match ID
	* @param esfUserId the esf user ID
	* @param start the lower bound of the range of e s f national match results
	* @param end the upper bound of the range of e s f national match results (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f national match results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFNationalMatchResult> findByESFMatchId_ESFUserId(
		long esfMatchId, long esfUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByESFMatchId_ESFUserId(esfMatchId, esfUserId, start,
			end, orderByComparator);
	}

	/**
	* Returns the first e s f national match result in the ordered set where esfMatchId = &#63; and esfUserId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f national match result
	* @throws it.ethica.esf.NoSuchNationalMatchResultException if a matching e s f national match result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNationalMatchResult findByESFMatchId_ESFUserId_First(
		long esfMatchId, long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalMatchResultException {
		return getPersistence()
				   .findByESFMatchId_ESFUserId_First(esfMatchId, esfUserId,
			orderByComparator);
	}

	/**
	* Returns the first e s f national match result in the ordered set where esfMatchId = &#63; and esfUserId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f national match result, or <code>null</code> if a matching e s f national match result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNationalMatchResult fetchByESFMatchId_ESFUserId_First(
		long esfMatchId, long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByESFMatchId_ESFUserId_First(esfMatchId, esfUserId,
			orderByComparator);
	}

	/**
	* Returns the last e s f national match result in the ordered set where esfMatchId = &#63; and esfUserId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f national match result
	* @throws it.ethica.esf.NoSuchNationalMatchResultException if a matching e s f national match result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNationalMatchResult findByESFMatchId_ESFUserId_Last(
		long esfMatchId, long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalMatchResultException {
		return getPersistence()
				   .findByESFMatchId_ESFUserId_Last(esfMatchId, esfUserId,
			orderByComparator);
	}

	/**
	* Returns the last e s f national match result in the ordered set where esfMatchId = &#63; and esfUserId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f national match result, or <code>null</code> if a matching e s f national match result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNationalMatchResult fetchByESFMatchId_ESFUserId_Last(
		long esfMatchId, long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByESFMatchId_ESFUserId_Last(esfMatchId, esfUserId,
			orderByComparator);
	}

	/**
	* Returns the e s f national match results before and after the current e s f national match result in the ordered set where esfMatchId = &#63; and esfUserId = &#63;.
	*
	* @param esfNationalMatchResultId the primary key of the current e s f national match result
	* @param esfMatchId the esf match ID
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f national match result
	* @throws it.ethica.esf.NoSuchNationalMatchResultException if a e s f national match result with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNationalMatchResult[] findByESFMatchId_ESFUserId_PrevAndNext(
		long esfNationalMatchResultId, long esfMatchId, long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalMatchResultException {
		return getPersistence()
				   .findByESFMatchId_ESFUserId_PrevAndNext(esfNationalMatchResultId,
			esfMatchId, esfUserId, orderByComparator);
	}

	/**
	* Removes all the e s f national match results where esfMatchId = &#63; and esfUserId = &#63; from the database.
	*
	* @param esfMatchId the esf match ID
	* @param esfUserId the esf user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByESFMatchId_ESFUserId(long esfMatchId,
		long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByESFMatchId_ESFUserId(esfMatchId, esfUserId);
	}

	/**
	* Returns the number of e s f national match results where esfMatchId = &#63; and esfUserId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfUserId the esf user ID
	* @return the number of matching e s f national match results
	* @throws SystemException if a system exception occurred
	*/
	public static int countByESFMatchId_ESFUserId(long esfMatchId,
		long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByESFMatchId_ESFUserId(esfMatchId, esfUserId);
	}

	/**
	* Returns all the e s f national match results where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @return the matching e s f national match results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFNationalMatchResult> findByESFUserId(
		long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByESFUserId(esfUserId);
	}

	/**
	* Returns a range of all the e s f national match results where esfUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalMatchResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfUserId the esf user ID
	* @param start the lower bound of the range of e s f national match results
	* @param end the upper bound of the range of e s f national match results (not inclusive)
	* @return the range of matching e s f national match results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFNationalMatchResult> findByESFUserId(
		long esfUserId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByESFUserId(esfUserId, start, end);
	}

	/**
	* Returns an ordered range of all the e s f national match results where esfUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalMatchResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfUserId the esf user ID
	* @param start the lower bound of the range of e s f national match results
	* @param end the upper bound of the range of e s f national match results (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f national match results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFNationalMatchResult> findByESFUserId(
		long esfUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByESFUserId(esfUserId, start, end, orderByComparator);
	}

	/**
	* Returns the first e s f national match result in the ordered set where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f national match result
	* @throws it.ethica.esf.NoSuchNationalMatchResultException if a matching e s f national match result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNationalMatchResult findByESFUserId_First(
		long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalMatchResultException {
		return getPersistence()
				   .findByESFUserId_First(esfUserId, orderByComparator);
	}

	/**
	* Returns the first e s f national match result in the ordered set where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f national match result, or <code>null</code> if a matching e s f national match result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNationalMatchResult fetchByESFUserId_First(
		long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByESFUserId_First(esfUserId, orderByComparator);
	}

	/**
	* Returns the last e s f national match result in the ordered set where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f national match result
	* @throws it.ethica.esf.NoSuchNationalMatchResultException if a matching e s f national match result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNationalMatchResult findByESFUserId_Last(
		long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalMatchResultException {
		return getPersistence()
				   .findByESFUserId_Last(esfUserId, orderByComparator);
	}

	/**
	* Returns the last e s f national match result in the ordered set where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f national match result, or <code>null</code> if a matching e s f national match result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNationalMatchResult fetchByESFUserId_Last(
		long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByESFUserId_Last(esfUserId, orderByComparator);
	}

	/**
	* Returns the e s f national match results before and after the current e s f national match result in the ordered set where esfUserId = &#63;.
	*
	* @param esfNationalMatchResultId the primary key of the current e s f national match result
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f national match result
	* @throws it.ethica.esf.NoSuchNationalMatchResultException if a e s f national match result with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNationalMatchResult[] findByESFUserId_PrevAndNext(
		long esfNationalMatchResultId, long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalMatchResultException {
		return getPersistence()
				   .findByESFUserId_PrevAndNext(esfNationalMatchResultId,
			esfUserId, orderByComparator);
	}

	/**
	* Removes all the e s f national match results where esfUserId = &#63; from the database.
	*
	* @param esfUserId the esf user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByESFUserId(long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByESFUserId(esfUserId);
	}

	/**
	* Returns the number of e s f national match results where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @return the number of matching e s f national match results
	* @throws SystemException if a system exception occurred
	*/
	public static int countByESFUserId(long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByESFUserId(esfUserId);
	}

	/**
	* Returns the e s f national match result where esfMatchId = &#63; or throws a {@link it.ethica.esf.NoSuchNationalMatchResultException} if it could not be found.
	*
	* @param esfMatchId the esf match ID
	* @return the matching e s f national match result
	* @throws it.ethica.esf.NoSuchNationalMatchResultException if a matching e s f national match result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNationalMatchResult findByESFMatchId(
		long esfMatchId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalMatchResultException {
		return getPersistence().findByESFMatchId(esfMatchId);
	}

	/**
	* Returns the e s f national match result where esfMatchId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param esfMatchId the esf match ID
	* @return the matching e s f national match result, or <code>null</code> if a matching e s f national match result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNationalMatchResult fetchByESFMatchId(
		long esfMatchId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByESFMatchId(esfMatchId);
	}

	/**
	* Returns the e s f national match result where esfMatchId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param esfMatchId the esf match ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching e s f national match result, or <code>null</code> if a matching e s f national match result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNationalMatchResult fetchByESFMatchId(
		long esfMatchId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByESFMatchId(esfMatchId, retrieveFromCache);
	}

	/**
	* Removes the e s f national match result where esfMatchId = &#63; from the database.
	*
	* @param esfMatchId the esf match ID
	* @return the e s f national match result that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNationalMatchResult removeByESFMatchId(
		long esfMatchId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalMatchResultException {
		return getPersistence().removeByESFMatchId(esfMatchId);
	}

	/**
	* Returns the number of e s f national match results where esfMatchId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @return the number of matching e s f national match results
	* @throws SystemException if a system exception occurred
	*/
	public static int countByESFMatchId(long esfMatchId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByESFMatchId(esfMatchId);
	}

	/**
	* Returns all the e s f national match results where esfMatchId = &#63; and externalShooter = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param externalShooter the external shooter
	* @return the matching e s f national match results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFNationalMatchResult> findByESFMatchId_ExternalShooter(
		long esfMatchId, boolean externalShooter)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByESFMatchId_ExternalShooter(esfMatchId, externalShooter);
	}

	/**
	* Returns a range of all the e s f national match results where esfMatchId = &#63; and externalShooter = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalMatchResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfMatchId the esf match ID
	* @param externalShooter the external shooter
	* @param start the lower bound of the range of e s f national match results
	* @param end the upper bound of the range of e s f national match results (not inclusive)
	* @return the range of matching e s f national match results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFNationalMatchResult> findByESFMatchId_ExternalShooter(
		long esfMatchId, boolean externalShooter, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByESFMatchId_ExternalShooter(esfMatchId,
			externalShooter, start, end);
	}

	/**
	* Returns an ordered range of all the e s f national match results where esfMatchId = &#63; and externalShooter = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalMatchResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfMatchId the esf match ID
	* @param externalShooter the external shooter
	* @param start the lower bound of the range of e s f national match results
	* @param end the upper bound of the range of e s f national match results (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f national match results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFNationalMatchResult> findByESFMatchId_ExternalShooter(
		long esfMatchId, boolean externalShooter, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByESFMatchId_ExternalShooter(esfMatchId,
			externalShooter, start, end, orderByComparator);
	}

	/**
	* Returns the first e s f national match result in the ordered set where esfMatchId = &#63; and externalShooter = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param externalShooter the external shooter
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f national match result
	* @throws it.ethica.esf.NoSuchNationalMatchResultException if a matching e s f national match result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNationalMatchResult findByESFMatchId_ExternalShooter_First(
		long esfMatchId, boolean externalShooter,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalMatchResultException {
		return getPersistence()
				   .findByESFMatchId_ExternalShooter_First(esfMatchId,
			externalShooter, orderByComparator);
	}

	/**
	* Returns the first e s f national match result in the ordered set where esfMatchId = &#63; and externalShooter = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param externalShooter the external shooter
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f national match result, or <code>null</code> if a matching e s f national match result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNationalMatchResult fetchByESFMatchId_ExternalShooter_First(
		long esfMatchId, boolean externalShooter,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByESFMatchId_ExternalShooter_First(esfMatchId,
			externalShooter, orderByComparator);
	}

	/**
	* Returns the last e s f national match result in the ordered set where esfMatchId = &#63; and externalShooter = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param externalShooter the external shooter
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f national match result
	* @throws it.ethica.esf.NoSuchNationalMatchResultException if a matching e s f national match result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNationalMatchResult findByESFMatchId_ExternalShooter_Last(
		long esfMatchId, boolean externalShooter,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalMatchResultException {
		return getPersistence()
				   .findByESFMatchId_ExternalShooter_Last(esfMatchId,
			externalShooter, orderByComparator);
	}

	/**
	* Returns the last e s f national match result in the ordered set where esfMatchId = &#63; and externalShooter = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param externalShooter the external shooter
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f national match result, or <code>null</code> if a matching e s f national match result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNationalMatchResult fetchByESFMatchId_ExternalShooter_Last(
		long esfMatchId, boolean externalShooter,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByESFMatchId_ExternalShooter_Last(esfMatchId,
			externalShooter, orderByComparator);
	}

	/**
	* Returns the e s f national match results before and after the current e s f national match result in the ordered set where esfMatchId = &#63; and externalShooter = &#63;.
	*
	* @param esfNationalMatchResultId the primary key of the current e s f national match result
	* @param esfMatchId the esf match ID
	* @param externalShooter the external shooter
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f national match result
	* @throws it.ethica.esf.NoSuchNationalMatchResultException if a e s f national match result with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNationalMatchResult[] findByESFMatchId_ExternalShooter_PrevAndNext(
		long esfNationalMatchResultId, long esfMatchId,
		boolean externalShooter,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalMatchResultException {
		return getPersistence()
				   .findByESFMatchId_ExternalShooter_PrevAndNext(esfNationalMatchResultId,
			esfMatchId, externalShooter, orderByComparator);
	}

	/**
	* Removes all the e s f national match results where esfMatchId = &#63; and externalShooter = &#63; from the database.
	*
	* @param esfMatchId the esf match ID
	* @param externalShooter the external shooter
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByESFMatchId_ExternalShooter(long esfMatchId,
		boolean externalShooter)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByESFMatchId_ExternalShooter(esfMatchId, externalShooter);
	}

	/**
	* Returns the number of e s f national match results where esfMatchId = &#63; and externalShooter = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param externalShooter the external shooter
	* @return the number of matching e s f national match results
	* @throws SystemException if a system exception occurred
	*/
	public static int countByESFMatchId_ExternalShooter(long esfMatchId,
		boolean externalShooter)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByESFMatchId_ExternalShooter(esfMatchId,
			externalShooter);
	}

	/**
	* Returns all the e s f national match results where esfMatchId = &#63; and esfSportTypeId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfSportTypeId the esf sport type ID
	* @return the matching e s f national match results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFNationalMatchResult> findByESFMatchId_ESFSportTypeId(
		long esfMatchId, long esfSportTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByESFMatchId_ESFSportTypeId(esfMatchId, esfSportTypeId);
	}

	/**
	* Returns a range of all the e s f national match results where esfMatchId = &#63; and esfSportTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalMatchResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfMatchId the esf match ID
	* @param esfSportTypeId the esf sport type ID
	* @param start the lower bound of the range of e s f national match results
	* @param end the upper bound of the range of e s f national match results (not inclusive)
	* @return the range of matching e s f national match results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFNationalMatchResult> findByESFMatchId_ESFSportTypeId(
		long esfMatchId, long esfSportTypeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByESFMatchId_ESFSportTypeId(esfMatchId, esfSportTypeId,
			start, end);
	}

	/**
	* Returns an ordered range of all the e s f national match results where esfMatchId = &#63; and esfSportTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalMatchResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfMatchId the esf match ID
	* @param esfSportTypeId the esf sport type ID
	* @param start the lower bound of the range of e s f national match results
	* @param end the upper bound of the range of e s f national match results (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f national match results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFNationalMatchResult> findByESFMatchId_ESFSportTypeId(
		long esfMatchId, long esfSportTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByESFMatchId_ESFSportTypeId(esfMatchId, esfSportTypeId,
			start, end, orderByComparator);
	}

	/**
	* Returns the first e s f national match result in the ordered set where esfMatchId = &#63; and esfSportTypeId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfSportTypeId the esf sport type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f national match result
	* @throws it.ethica.esf.NoSuchNationalMatchResultException if a matching e s f national match result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNationalMatchResult findByESFMatchId_ESFSportTypeId_First(
		long esfMatchId, long esfSportTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalMatchResultException {
		return getPersistence()
				   .findByESFMatchId_ESFSportTypeId_First(esfMatchId,
			esfSportTypeId, orderByComparator);
	}

	/**
	* Returns the first e s f national match result in the ordered set where esfMatchId = &#63; and esfSportTypeId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfSportTypeId the esf sport type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f national match result, or <code>null</code> if a matching e s f national match result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNationalMatchResult fetchByESFMatchId_ESFSportTypeId_First(
		long esfMatchId, long esfSportTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByESFMatchId_ESFSportTypeId_First(esfMatchId,
			esfSportTypeId, orderByComparator);
	}

	/**
	* Returns the last e s f national match result in the ordered set where esfMatchId = &#63; and esfSportTypeId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfSportTypeId the esf sport type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f national match result
	* @throws it.ethica.esf.NoSuchNationalMatchResultException if a matching e s f national match result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNationalMatchResult findByESFMatchId_ESFSportTypeId_Last(
		long esfMatchId, long esfSportTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalMatchResultException {
		return getPersistence()
				   .findByESFMatchId_ESFSportTypeId_Last(esfMatchId,
			esfSportTypeId, orderByComparator);
	}

	/**
	* Returns the last e s f national match result in the ordered set where esfMatchId = &#63; and esfSportTypeId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfSportTypeId the esf sport type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f national match result, or <code>null</code> if a matching e s f national match result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNationalMatchResult fetchByESFMatchId_ESFSportTypeId_Last(
		long esfMatchId, long esfSportTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByESFMatchId_ESFSportTypeId_Last(esfMatchId,
			esfSportTypeId, orderByComparator);
	}

	/**
	* Returns the e s f national match results before and after the current e s f national match result in the ordered set where esfMatchId = &#63; and esfSportTypeId = &#63;.
	*
	* @param esfNationalMatchResultId the primary key of the current e s f national match result
	* @param esfMatchId the esf match ID
	* @param esfSportTypeId the esf sport type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f national match result
	* @throws it.ethica.esf.NoSuchNationalMatchResultException if a e s f national match result with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNationalMatchResult[] findByESFMatchId_ESFSportTypeId_PrevAndNext(
		long esfNationalMatchResultId, long esfMatchId, long esfSportTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalMatchResultException {
		return getPersistence()
				   .findByESFMatchId_ESFSportTypeId_PrevAndNext(esfNationalMatchResultId,
			esfMatchId, esfSportTypeId, orderByComparator);
	}

	/**
	* Removes all the e s f national match results where esfMatchId = &#63; and esfSportTypeId = &#63; from the database.
	*
	* @param esfMatchId the esf match ID
	* @param esfSportTypeId the esf sport type ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByESFMatchId_ESFSportTypeId(long esfMatchId,
		long esfSportTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByESFMatchId_ESFSportTypeId(esfMatchId, esfSportTypeId);
	}

	/**
	* Returns the number of e s f national match results where esfMatchId = &#63; and esfSportTypeId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfSportTypeId the esf sport type ID
	* @return the number of matching e s f national match results
	* @throws SystemException if a system exception occurred
	*/
	public static int countByESFMatchId_ESFSportTypeId(long esfMatchId,
		long esfSportTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByESFMatchId_ESFSportTypeId(esfMatchId, esfSportTypeId);
	}

	/**
	* Returns all the e s f national match results where esfMatchId = &#63; and esfUserId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfUserId the esf user ID
	* @return the matching e s f national match results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFNationalMatchResult> findBymatchId_userId(
		long esfMatchId, long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBymatchId_userId(esfMatchId, esfUserId);
	}

	/**
	* Returns a range of all the e s f national match results where esfMatchId = &#63; and esfUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalMatchResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfMatchId the esf match ID
	* @param esfUserId the esf user ID
	* @param start the lower bound of the range of e s f national match results
	* @param end the upper bound of the range of e s f national match results (not inclusive)
	* @return the range of matching e s f national match results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFNationalMatchResult> findBymatchId_userId(
		long esfMatchId, long esfUserId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBymatchId_userId(esfMatchId, esfUserId, start, end);
	}

	/**
	* Returns an ordered range of all the e s f national match results where esfMatchId = &#63; and esfUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalMatchResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfMatchId the esf match ID
	* @param esfUserId the esf user ID
	* @param start the lower bound of the range of e s f national match results
	* @param end the upper bound of the range of e s f national match results (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f national match results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFNationalMatchResult> findBymatchId_userId(
		long esfMatchId, long esfUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBymatchId_userId(esfMatchId, esfUserId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first e s f national match result in the ordered set where esfMatchId = &#63; and esfUserId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f national match result
	* @throws it.ethica.esf.NoSuchNationalMatchResultException if a matching e s f national match result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNationalMatchResult findBymatchId_userId_First(
		long esfMatchId, long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalMatchResultException {
		return getPersistence()
				   .findBymatchId_userId_First(esfMatchId, esfUserId,
			orderByComparator);
	}

	/**
	* Returns the first e s f national match result in the ordered set where esfMatchId = &#63; and esfUserId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f national match result, or <code>null</code> if a matching e s f national match result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNationalMatchResult fetchBymatchId_userId_First(
		long esfMatchId, long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBymatchId_userId_First(esfMatchId, esfUserId,
			orderByComparator);
	}

	/**
	* Returns the last e s f national match result in the ordered set where esfMatchId = &#63; and esfUserId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f national match result
	* @throws it.ethica.esf.NoSuchNationalMatchResultException if a matching e s f national match result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNationalMatchResult findBymatchId_userId_Last(
		long esfMatchId, long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalMatchResultException {
		return getPersistence()
				   .findBymatchId_userId_Last(esfMatchId, esfUserId,
			orderByComparator);
	}

	/**
	* Returns the last e s f national match result in the ordered set where esfMatchId = &#63; and esfUserId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f national match result, or <code>null</code> if a matching e s f national match result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNationalMatchResult fetchBymatchId_userId_Last(
		long esfMatchId, long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBymatchId_userId_Last(esfMatchId, esfUserId,
			orderByComparator);
	}

	/**
	* Returns the e s f national match results before and after the current e s f national match result in the ordered set where esfMatchId = &#63; and esfUserId = &#63;.
	*
	* @param esfNationalMatchResultId the primary key of the current e s f national match result
	* @param esfMatchId the esf match ID
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f national match result
	* @throws it.ethica.esf.NoSuchNationalMatchResultException if a e s f national match result with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNationalMatchResult[] findBymatchId_userId_PrevAndNext(
		long esfNationalMatchResultId, long esfMatchId, long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalMatchResultException {
		return getPersistence()
				   .findBymatchId_userId_PrevAndNext(esfNationalMatchResultId,
			esfMatchId, esfUserId, orderByComparator);
	}

	/**
	* Removes all the e s f national match results where esfMatchId = &#63; and esfUserId = &#63; from the database.
	*
	* @param esfMatchId the esf match ID
	* @param esfUserId the esf user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBymatchId_userId(long esfMatchId, long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBymatchId_userId(esfMatchId, esfUserId);
	}

	/**
	* Returns the number of e s f national match results where esfMatchId = &#63; and esfUserId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfUserId the esf user ID
	* @return the number of matching e s f national match results
	* @throws SystemException if a system exception occurred
	*/
	public static int countBymatchId_userId(long esfMatchId, long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBymatchId_userId(esfMatchId, esfUserId);
	}

	/**
	* Returns all the e s f national match results where esfMatchId = &#63; and externalShooter = &#63; and esfSportTypeId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param externalShooter the external shooter
	* @param esfSportTypeId the esf sport type ID
	* @return the matching e s f national match results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFNationalMatchResult> findByESFMatchId_ExternalShooter_ESFSportTypeId(
		long esfMatchId, boolean externalShooter, long esfSportTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByESFMatchId_ExternalShooter_ESFSportTypeId(esfMatchId,
			externalShooter, esfSportTypeId);
	}

	/**
	* Returns a range of all the e s f national match results where esfMatchId = &#63; and externalShooter = &#63; and esfSportTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalMatchResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfMatchId the esf match ID
	* @param externalShooter the external shooter
	* @param esfSportTypeId the esf sport type ID
	* @param start the lower bound of the range of e s f national match results
	* @param end the upper bound of the range of e s f national match results (not inclusive)
	* @return the range of matching e s f national match results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFNationalMatchResult> findByESFMatchId_ExternalShooter_ESFSportTypeId(
		long esfMatchId, boolean externalShooter, long esfSportTypeId,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByESFMatchId_ExternalShooter_ESFSportTypeId(esfMatchId,
			externalShooter, esfSportTypeId, start, end);
	}

	/**
	* Returns an ordered range of all the e s f national match results where esfMatchId = &#63; and externalShooter = &#63; and esfSportTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalMatchResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfMatchId the esf match ID
	* @param externalShooter the external shooter
	* @param esfSportTypeId the esf sport type ID
	* @param start the lower bound of the range of e s f national match results
	* @param end the upper bound of the range of e s f national match results (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f national match results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFNationalMatchResult> findByESFMatchId_ExternalShooter_ESFSportTypeId(
		long esfMatchId, boolean externalShooter, long esfSportTypeId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByESFMatchId_ExternalShooter_ESFSportTypeId(esfMatchId,
			externalShooter, esfSportTypeId, start, end, orderByComparator);
	}

	/**
	* Returns the first e s f national match result in the ordered set where esfMatchId = &#63; and externalShooter = &#63; and esfSportTypeId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param externalShooter the external shooter
	* @param esfSportTypeId the esf sport type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f national match result
	* @throws it.ethica.esf.NoSuchNationalMatchResultException if a matching e s f national match result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNationalMatchResult findByESFMatchId_ExternalShooter_ESFSportTypeId_First(
		long esfMatchId, boolean externalShooter, long esfSportTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalMatchResultException {
		return getPersistence()
				   .findByESFMatchId_ExternalShooter_ESFSportTypeId_First(esfMatchId,
			externalShooter, esfSportTypeId, orderByComparator);
	}

	/**
	* Returns the first e s f national match result in the ordered set where esfMatchId = &#63; and externalShooter = &#63; and esfSportTypeId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param externalShooter the external shooter
	* @param esfSportTypeId the esf sport type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f national match result, or <code>null</code> if a matching e s f national match result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNationalMatchResult fetchByESFMatchId_ExternalShooter_ESFSportTypeId_First(
		long esfMatchId, boolean externalShooter, long esfSportTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByESFMatchId_ExternalShooter_ESFSportTypeId_First(esfMatchId,
			externalShooter, esfSportTypeId, orderByComparator);
	}

	/**
	* Returns the last e s f national match result in the ordered set where esfMatchId = &#63; and externalShooter = &#63; and esfSportTypeId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param externalShooter the external shooter
	* @param esfSportTypeId the esf sport type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f national match result
	* @throws it.ethica.esf.NoSuchNationalMatchResultException if a matching e s f national match result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNationalMatchResult findByESFMatchId_ExternalShooter_ESFSportTypeId_Last(
		long esfMatchId, boolean externalShooter, long esfSportTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalMatchResultException {
		return getPersistence()
				   .findByESFMatchId_ExternalShooter_ESFSportTypeId_Last(esfMatchId,
			externalShooter, esfSportTypeId, orderByComparator);
	}

	/**
	* Returns the last e s f national match result in the ordered set where esfMatchId = &#63; and externalShooter = &#63; and esfSportTypeId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param externalShooter the external shooter
	* @param esfSportTypeId the esf sport type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f national match result, or <code>null</code> if a matching e s f national match result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNationalMatchResult fetchByESFMatchId_ExternalShooter_ESFSportTypeId_Last(
		long esfMatchId, boolean externalShooter, long esfSportTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByESFMatchId_ExternalShooter_ESFSportTypeId_Last(esfMatchId,
			externalShooter, esfSportTypeId, orderByComparator);
	}

	/**
	* Returns the e s f national match results before and after the current e s f national match result in the ordered set where esfMatchId = &#63; and externalShooter = &#63; and esfSportTypeId = &#63;.
	*
	* @param esfNationalMatchResultId the primary key of the current e s f national match result
	* @param esfMatchId the esf match ID
	* @param externalShooter the external shooter
	* @param esfSportTypeId the esf sport type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f national match result
	* @throws it.ethica.esf.NoSuchNationalMatchResultException if a e s f national match result with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNationalMatchResult[] findByESFMatchId_ExternalShooter_ESFSportTypeId_PrevAndNext(
		long esfNationalMatchResultId, long esfMatchId,
		boolean externalShooter, long esfSportTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalMatchResultException {
		return getPersistence()
				   .findByESFMatchId_ExternalShooter_ESFSportTypeId_PrevAndNext(esfNationalMatchResultId,
			esfMatchId, externalShooter, esfSportTypeId, orderByComparator);
	}

	/**
	* Removes all the e s f national match results where esfMatchId = &#63; and externalShooter = &#63; and esfSportTypeId = &#63; from the database.
	*
	* @param esfMatchId the esf match ID
	* @param externalShooter the external shooter
	* @param esfSportTypeId the esf sport type ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByESFMatchId_ExternalShooter_ESFSportTypeId(
		long esfMatchId, boolean externalShooter, long esfSportTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByESFMatchId_ExternalShooter_ESFSportTypeId(esfMatchId,
			externalShooter, esfSportTypeId);
	}

	/**
	* Returns the number of e s f national match results where esfMatchId = &#63; and externalShooter = &#63; and esfSportTypeId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param externalShooter the external shooter
	* @param esfSportTypeId the esf sport type ID
	* @return the number of matching e s f national match results
	* @throws SystemException if a system exception occurred
	*/
	public static int countByESFMatchId_ExternalShooter_ESFSportTypeId(
		long esfMatchId, boolean externalShooter, long esfSportTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByESFMatchId_ExternalShooter_ESFSportTypeId(esfMatchId,
			externalShooter, esfSportTypeId);
	}

	/**
	* Returns all the e s f national match results where esfMatchId = &#63; and esfUserQualification = &#63; and esfSportTypeId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfUserQualification the esf user qualification
	* @param esfSportTypeId the esf sport type ID
	* @return the matching e s f national match results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFNationalMatchResult> findByESFMatchId_QualificationId_ESFSportTypeId(
		long esfMatchId, long esfUserQualification, long esfSportTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByESFMatchId_QualificationId_ESFSportTypeId(esfMatchId,
			esfUserQualification, esfSportTypeId);
	}

	/**
	* Returns a range of all the e s f national match results where esfMatchId = &#63; and esfUserQualification = &#63; and esfSportTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalMatchResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfMatchId the esf match ID
	* @param esfUserQualification the esf user qualification
	* @param esfSportTypeId the esf sport type ID
	* @param start the lower bound of the range of e s f national match results
	* @param end the upper bound of the range of e s f national match results (not inclusive)
	* @return the range of matching e s f national match results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFNationalMatchResult> findByESFMatchId_QualificationId_ESFSportTypeId(
		long esfMatchId, long esfUserQualification, long esfSportTypeId,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByESFMatchId_QualificationId_ESFSportTypeId(esfMatchId,
			esfUserQualification, esfSportTypeId, start, end);
	}

	/**
	* Returns an ordered range of all the e s f national match results where esfMatchId = &#63; and esfUserQualification = &#63; and esfSportTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalMatchResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfMatchId the esf match ID
	* @param esfUserQualification the esf user qualification
	* @param esfSportTypeId the esf sport type ID
	* @param start the lower bound of the range of e s f national match results
	* @param end the upper bound of the range of e s f national match results (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f national match results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFNationalMatchResult> findByESFMatchId_QualificationId_ESFSportTypeId(
		long esfMatchId, long esfUserQualification, long esfSportTypeId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByESFMatchId_QualificationId_ESFSportTypeId(esfMatchId,
			esfUserQualification, esfSportTypeId, start, end, orderByComparator);
	}

	/**
	* Returns the first e s f national match result in the ordered set where esfMatchId = &#63; and esfUserQualification = &#63; and esfSportTypeId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfUserQualification the esf user qualification
	* @param esfSportTypeId the esf sport type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f national match result
	* @throws it.ethica.esf.NoSuchNationalMatchResultException if a matching e s f national match result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNationalMatchResult findByESFMatchId_QualificationId_ESFSportTypeId_First(
		long esfMatchId, long esfUserQualification, long esfSportTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalMatchResultException {
		return getPersistence()
				   .findByESFMatchId_QualificationId_ESFSportTypeId_First(esfMatchId,
			esfUserQualification, esfSportTypeId, orderByComparator);
	}

	/**
	* Returns the first e s f national match result in the ordered set where esfMatchId = &#63; and esfUserQualification = &#63; and esfSportTypeId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfUserQualification the esf user qualification
	* @param esfSportTypeId the esf sport type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f national match result, or <code>null</code> if a matching e s f national match result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNationalMatchResult fetchByESFMatchId_QualificationId_ESFSportTypeId_First(
		long esfMatchId, long esfUserQualification, long esfSportTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByESFMatchId_QualificationId_ESFSportTypeId_First(esfMatchId,
			esfUserQualification, esfSportTypeId, orderByComparator);
	}

	/**
	* Returns the last e s f national match result in the ordered set where esfMatchId = &#63; and esfUserQualification = &#63; and esfSportTypeId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfUserQualification the esf user qualification
	* @param esfSportTypeId the esf sport type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f national match result
	* @throws it.ethica.esf.NoSuchNationalMatchResultException if a matching e s f national match result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNationalMatchResult findByESFMatchId_QualificationId_ESFSportTypeId_Last(
		long esfMatchId, long esfUserQualification, long esfSportTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalMatchResultException {
		return getPersistence()
				   .findByESFMatchId_QualificationId_ESFSportTypeId_Last(esfMatchId,
			esfUserQualification, esfSportTypeId, orderByComparator);
	}

	/**
	* Returns the last e s f national match result in the ordered set where esfMatchId = &#63; and esfUserQualification = &#63; and esfSportTypeId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfUserQualification the esf user qualification
	* @param esfSportTypeId the esf sport type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f national match result, or <code>null</code> if a matching e s f national match result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNationalMatchResult fetchByESFMatchId_QualificationId_ESFSportTypeId_Last(
		long esfMatchId, long esfUserQualification, long esfSportTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByESFMatchId_QualificationId_ESFSportTypeId_Last(esfMatchId,
			esfUserQualification, esfSportTypeId, orderByComparator);
	}

	/**
	* Returns the e s f national match results before and after the current e s f national match result in the ordered set where esfMatchId = &#63; and esfUserQualification = &#63; and esfSportTypeId = &#63;.
	*
	* @param esfNationalMatchResultId the primary key of the current e s f national match result
	* @param esfMatchId the esf match ID
	* @param esfUserQualification the esf user qualification
	* @param esfSportTypeId the esf sport type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f national match result
	* @throws it.ethica.esf.NoSuchNationalMatchResultException if a e s f national match result with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNationalMatchResult[] findByESFMatchId_QualificationId_ESFSportTypeId_PrevAndNext(
		long esfNationalMatchResultId, long esfMatchId,
		long esfUserQualification, long esfSportTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalMatchResultException {
		return getPersistence()
				   .findByESFMatchId_QualificationId_ESFSportTypeId_PrevAndNext(esfNationalMatchResultId,
			esfMatchId, esfUserQualification, esfSportTypeId, orderByComparator);
	}

	/**
	* Removes all the e s f national match results where esfMatchId = &#63; and esfUserQualification = &#63; and esfSportTypeId = &#63; from the database.
	*
	* @param esfMatchId the esf match ID
	* @param esfUserQualification the esf user qualification
	* @param esfSportTypeId the esf sport type ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByESFMatchId_QualificationId_ESFSportTypeId(
		long esfMatchId, long esfUserQualification, long esfSportTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByESFMatchId_QualificationId_ESFSportTypeId(esfMatchId,
			esfUserQualification, esfSportTypeId);
	}

	/**
	* Returns the number of e s f national match results where esfMatchId = &#63; and esfUserQualification = &#63; and esfSportTypeId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfUserQualification the esf user qualification
	* @param esfSportTypeId the esf sport type ID
	* @return the number of matching e s f national match results
	* @throws SystemException if a system exception occurred
	*/
	public static int countByESFMatchId_QualificationId_ESFSportTypeId(
		long esfMatchId, long esfUserQualification, long esfSportTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByESFMatchId_QualificationId_ESFSportTypeId(esfMatchId,
			esfUserQualification, esfSportTypeId);
	}

	/**
	* Caches the e s f national match result in the entity cache if it is enabled.
	*
	* @param esfNationalMatchResult the e s f national match result
	*/
	public static void cacheResult(
		it.ethica.esf.model.ESFNationalMatchResult esfNationalMatchResult) {
		getPersistence().cacheResult(esfNationalMatchResult);
	}

	/**
	* Caches the e s f national match results in the entity cache if it is enabled.
	*
	* @param esfNationalMatchResults the e s f national match results
	*/
	public static void cacheResult(
		java.util.List<it.ethica.esf.model.ESFNationalMatchResult> esfNationalMatchResults) {
		getPersistence().cacheResult(esfNationalMatchResults);
	}

	/**
	* Creates a new e s f national match result with the primary key. Does not add the e s f national match result to the database.
	*
	* @param esfNationalMatchResultId the primary key for the new e s f national match result
	* @return the new e s f national match result
	*/
	public static it.ethica.esf.model.ESFNationalMatchResult create(
		long esfNationalMatchResultId) {
		return getPersistence().create(esfNationalMatchResultId);
	}

	/**
	* Removes the e s f national match result with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfNationalMatchResultId the primary key of the e s f national match result
	* @return the e s f national match result that was removed
	* @throws it.ethica.esf.NoSuchNationalMatchResultException if a e s f national match result with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNationalMatchResult remove(
		long esfNationalMatchResultId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalMatchResultException {
		return getPersistence().remove(esfNationalMatchResultId);
	}

	public static it.ethica.esf.model.ESFNationalMatchResult updateImpl(
		it.ethica.esf.model.ESFNationalMatchResult esfNationalMatchResult)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(esfNationalMatchResult);
	}

	/**
	* Returns the e s f national match result with the primary key or throws a {@link it.ethica.esf.NoSuchNationalMatchResultException} if it could not be found.
	*
	* @param esfNationalMatchResultId the primary key of the e s f national match result
	* @return the e s f national match result
	* @throws it.ethica.esf.NoSuchNationalMatchResultException if a e s f national match result with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNationalMatchResult findByPrimaryKey(
		long esfNationalMatchResultId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalMatchResultException {
		return getPersistence().findByPrimaryKey(esfNationalMatchResultId);
	}

	/**
	* Returns the e s f national match result with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param esfNationalMatchResultId the primary key of the e s f national match result
	* @return the e s f national match result, or <code>null</code> if a e s f national match result with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNationalMatchResult fetchByPrimaryKey(
		long esfNationalMatchResultId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(esfNationalMatchResultId);
	}

	/**
	* Returns all the e s f national match results.
	*
	* @return the e s f national match results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFNationalMatchResult> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the e s f national match results.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalMatchResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f national match results
	* @param end the upper bound of the range of e s f national match results (not inclusive)
	* @return the range of e s f national match results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFNationalMatchResult> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the e s f national match results.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalMatchResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f national match results
	* @param end the upper bound of the range of e s f national match results (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of e s f national match results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFNationalMatchResult> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the e s f national match results from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of e s f national match results.
	*
	* @return the number of e s f national match results
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ESFNationalMatchResultPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ESFNationalMatchResultPersistence)PortletBeanLocatorUtil.locate(it.ethica.esf.service.ClpSerializer.getServletContextName(),
					ESFNationalMatchResultPersistence.class.getName());

			ReferenceRegistry.registerReference(ESFNationalMatchResultUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ESFNationalMatchResultPersistence persistence) {
	}

	private static ESFNationalMatchResultPersistence _persistence;
}