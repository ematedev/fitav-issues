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

import it.ethica.esf.model.ESFResult;

import java.util.List;

/**
 * The persistence utility for the e s f result service. This utility wraps {@link ESFResultPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFResultPersistence
 * @see ESFResultPersistenceImpl
 * @generated
 */
public class ESFResultUtil {
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
	public static void clearCache(ESFResult esfResult) {
		getPersistence().clearCache(esfResult);
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
	public static List<ESFResult> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ESFResult> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ESFResult> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ESFResult update(ESFResult esfResult)
		throws SystemException {
		return getPersistence().update(esfResult);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ESFResult update(ESFResult esfResult,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(esfResult, serviceContext);
	}

	/**
	* Returns all the e s f results where esfMatchId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @return the matching e s f results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFResult> findByESFMatchId(
		long esfMatchId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByESFMatchId(esfMatchId);
	}

	/**
	* Returns a range of all the e s f results where esfMatchId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfMatchId the esf match ID
	* @param start the lower bound of the range of e s f results
	* @param end the upper bound of the range of e s f results (not inclusive)
	* @return the range of matching e s f results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFResult> findByESFMatchId(
		long esfMatchId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByESFMatchId(esfMatchId, start, end);
	}

	/**
	* Returns an ordered range of all the e s f results where esfMatchId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfMatchId the esf match ID
	* @param start the lower bound of the range of e s f results
	* @param end the upper bound of the range of e s f results (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFResult> findByESFMatchId(
		long esfMatchId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByESFMatchId(esfMatchId, start, end, orderByComparator);
	}

	/**
	* Returns the first e s f result in the ordered set where esfMatchId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f result
	* @throws it.ethica.esf.NoSuchResultException if a matching e s f result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFResult findByESFMatchId_First(
		long esfMatchId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchResultException {
		return getPersistence()
				   .findByESFMatchId_First(esfMatchId, orderByComparator);
	}

	/**
	* Returns the first e s f result in the ordered set where esfMatchId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f result, or <code>null</code> if a matching e s f result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFResult fetchByESFMatchId_First(
		long esfMatchId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByESFMatchId_First(esfMatchId, orderByComparator);
	}

	/**
	* Returns the last e s f result in the ordered set where esfMatchId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f result
	* @throws it.ethica.esf.NoSuchResultException if a matching e s f result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFResult findByESFMatchId_Last(
		long esfMatchId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchResultException {
		return getPersistence()
				   .findByESFMatchId_Last(esfMatchId, orderByComparator);
	}

	/**
	* Returns the last e s f result in the ordered set where esfMatchId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f result, or <code>null</code> if a matching e s f result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFResult fetchByESFMatchId_Last(
		long esfMatchId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByESFMatchId_Last(esfMatchId, orderByComparator);
	}

	/**
	* Returns the e s f results before and after the current e s f result in the ordered set where esfMatchId = &#63;.
	*
	* @param esfResultId the primary key of the current e s f result
	* @param esfMatchId the esf match ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f result
	* @throws it.ethica.esf.NoSuchResultException if a e s f result with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFResult[] findByESFMatchId_PrevAndNext(
		long esfResultId, long esfMatchId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchResultException {
		return getPersistence()
				   .findByESFMatchId_PrevAndNext(esfResultId, esfMatchId,
			orderByComparator);
	}

	/**
	* Removes all the e s f results where esfMatchId = &#63; from the database.
	*
	* @param esfMatchId the esf match ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByESFMatchId(long esfMatchId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByESFMatchId(esfMatchId);
	}

	/**
	* Returns the number of e s f results where esfMatchId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @return the number of matching e s f results
	* @throws SystemException if a system exception occurred
	*/
	public static int countByESFMatchId(long esfMatchId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByESFMatchId(esfMatchId);
	}

	/**
	* Returns all the e s f results where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @return the matching e s f results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFResult> findByESFShooterId(
		long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByESFShooterId(esfUserId);
	}

	/**
	* Returns a range of all the e s f results where esfUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfUserId the esf user ID
	* @param start the lower bound of the range of e s f results
	* @param end the upper bound of the range of e s f results (not inclusive)
	* @return the range of matching e s f results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFResult> findByESFShooterId(
		long esfUserId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByESFShooterId(esfUserId, start, end);
	}

	/**
	* Returns an ordered range of all the e s f results where esfUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfUserId the esf user ID
	* @param start the lower bound of the range of e s f results
	* @param end the upper bound of the range of e s f results (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFResult> findByESFShooterId(
		long esfUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByESFShooterId(esfUserId, start, end, orderByComparator);
	}

	/**
	* Returns the first e s f result in the ordered set where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f result
	* @throws it.ethica.esf.NoSuchResultException if a matching e s f result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFResult findByESFShooterId_First(
		long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchResultException {
		return getPersistence()
				   .findByESFShooterId_First(esfUserId, orderByComparator);
	}

	/**
	* Returns the first e s f result in the ordered set where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f result, or <code>null</code> if a matching e s f result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFResult fetchByESFShooterId_First(
		long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByESFShooterId_First(esfUserId, orderByComparator);
	}

	/**
	* Returns the last e s f result in the ordered set where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f result
	* @throws it.ethica.esf.NoSuchResultException if a matching e s f result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFResult findByESFShooterId_Last(
		long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchResultException {
		return getPersistence()
				   .findByESFShooterId_Last(esfUserId, orderByComparator);
	}

	/**
	* Returns the last e s f result in the ordered set where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f result, or <code>null</code> if a matching e s f result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFResult fetchByESFShooterId_Last(
		long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByESFShooterId_Last(esfUserId, orderByComparator);
	}

	/**
	* Returns the e s f results before and after the current e s f result in the ordered set where esfUserId = &#63;.
	*
	* @param esfResultId the primary key of the current e s f result
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f result
	* @throws it.ethica.esf.NoSuchResultException if a e s f result with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFResult[] findByESFShooterId_PrevAndNext(
		long esfResultId, long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchResultException {
		return getPersistence()
				   .findByESFShooterId_PrevAndNext(esfResultId, esfUserId,
			orderByComparator);
	}

	/**
	* Removes all the e s f results where esfUserId = &#63; from the database.
	*
	* @param esfUserId the esf user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByESFShooterId(long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByESFShooterId(esfUserId);
	}

	/**
	* Returns the number of e s f results where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @return the number of matching e s f results
	* @throws SystemException if a system exception occurred
	*/
	public static int countByESFShooterId(long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByESFShooterId(esfUserId);
	}

	/**
	* Returns all the e s f results where esfMatchId = &#63; and esfUserId = &#63; and esfMatchTypeId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfUserId the esf user ID
	* @param esfMatchTypeId the esf match type ID
	* @return the matching e s f results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFResult> findByESFMId_UId_STId(
		long esfMatchId, long esfUserId, long esfMatchTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByESFMId_UId_STId(esfMatchId, esfUserId, esfMatchTypeId);
	}

	/**
	* Returns a range of all the e s f results where esfMatchId = &#63; and esfUserId = &#63; and esfMatchTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfMatchId the esf match ID
	* @param esfUserId the esf user ID
	* @param esfMatchTypeId the esf match type ID
	* @param start the lower bound of the range of e s f results
	* @param end the upper bound of the range of e s f results (not inclusive)
	* @return the range of matching e s f results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFResult> findByESFMId_UId_STId(
		long esfMatchId, long esfUserId, long esfMatchTypeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByESFMId_UId_STId(esfMatchId, esfUserId,
			esfMatchTypeId, start, end);
	}

	/**
	* Returns an ordered range of all the e s f results where esfMatchId = &#63; and esfUserId = &#63; and esfMatchTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfMatchId the esf match ID
	* @param esfUserId the esf user ID
	* @param esfMatchTypeId the esf match type ID
	* @param start the lower bound of the range of e s f results
	* @param end the upper bound of the range of e s f results (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFResult> findByESFMId_UId_STId(
		long esfMatchId, long esfUserId, long esfMatchTypeId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByESFMId_UId_STId(esfMatchId, esfUserId,
			esfMatchTypeId, start, end, orderByComparator);
	}

	/**
	* Returns the first e s f result in the ordered set where esfMatchId = &#63; and esfUserId = &#63; and esfMatchTypeId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfUserId the esf user ID
	* @param esfMatchTypeId the esf match type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f result
	* @throws it.ethica.esf.NoSuchResultException if a matching e s f result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFResult findByESFMId_UId_STId_First(
		long esfMatchId, long esfUserId, long esfMatchTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchResultException {
		return getPersistence()
				   .findByESFMId_UId_STId_First(esfMatchId, esfUserId,
			esfMatchTypeId, orderByComparator);
	}

	/**
	* Returns the first e s f result in the ordered set where esfMatchId = &#63; and esfUserId = &#63; and esfMatchTypeId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfUserId the esf user ID
	* @param esfMatchTypeId the esf match type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f result, or <code>null</code> if a matching e s f result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFResult fetchByESFMId_UId_STId_First(
		long esfMatchId, long esfUserId, long esfMatchTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByESFMId_UId_STId_First(esfMatchId, esfUserId,
			esfMatchTypeId, orderByComparator);
	}

	/**
	* Returns the last e s f result in the ordered set where esfMatchId = &#63; and esfUserId = &#63; and esfMatchTypeId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfUserId the esf user ID
	* @param esfMatchTypeId the esf match type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f result
	* @throws it.ethica.esf.NoSuchResultException if a matching e s f result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFResult findByESFMId_UId_STId_Last(
		long esfMatchId, long esfUserId, long esfMatchTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchResultException {
		return getPersistence()
				   .findByESFMId_UId_STId_Last(esfMatchId, esfUserId,
			esfMatchTypeId, orderByComparator);
	}

	/**
	* Returns the last e s f result in the ordered set where esfMatchId = &#63; and esfUserId = &#63; and esfMatchTypeId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfUserId the esf user ID
	* @param esfMatchTypeId the esf match type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f result, or <code>null</code> if a matching e s f result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFResult fetchByESFMId_UId_STId_Last(
		long esfMatchId, long esfUserId, long esfMatchTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByESFMId_UId_STId_Last(esfMatchId, esfUserId,
			esfMatchTypeId, orderByComparator);
	}

	/**
	* Returns the e s f results before and after the current e s f result in the ordered set where esfMatchId = &#63; and esfUserId = &#63; and esfMatchTypeId = &#63;.
	*
	* @param esfResultId the primary key of the current e s f result
	* @param esfMatchId the esf match ID
	* @param esfUserId the esf user ID
	* @param esfMatchTypeId the esf match type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f result
	* @throws it.ethica.esf.NoSuchResultException if a e s f result with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFResult[] findByESFMId_UId_STId_PrevAndNext(
		long esfResultId, long esfMatchId, long esfUserId, long esfMatchTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchResultException {
		return getPersistence()
				   .findByESFMId_UId_STId_PrevAndNext(esfResultId, esfMatchId,
			esfUserId, esfMatchTypeId, orderByComparator);
	}

	/**
	* Removes all the e s f results where esfMatchId = &#63; and esfUserId = &#63; and esfMatchTypeId = &#63; from the database.
	*
	* @param esfMatchId the esf match ID
	* @param esfUserId the esf user ID
	* @param esfMatchTypeId the esf match type ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByESFMId_UId_STId(long esfMatchId, long esfUserId,
		long esfMatchTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByESFMId_UId_STId(esfMatchId, esfUserId, esfMatchTypeId);
	}

	/**
	* Returns the number of e s f results where esfMatchId = &#63; and esfUserId = &#63; and esfMatchTypeId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfUserId the esf user ID
	* @param esfMatchTypeId the esf match type ID
	* @return the number of matching e s f results
	* @throws SystemException if a system exception occurred
	*/
	public static int countByESFMId_UId_STId(long esfMatchId, long esfUserId,
		long esfMatchTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByESFMId_UId_STId(esfMatchId, esfUserId, esfMatchTypeId);
	}

	/**
	* Returns all the e s f results where esfMatchId = &#63; and esfUserId = &#63; and esfMatchTypeId = &#63; and resultClassTeam = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfUserId the esf user ID
	* @param esfMatchTypeId the esf match type ID
	* @param resultClassTeam the result class team
	* @return the matching e s f results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFResult> findByESFMId_UId_STId_Single(
		long esfMatchId, long esfUserId, long esfMatchTypeId,
		int resultClassTeam)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByESFMId_UId_STId_Single(esfMatchId, esfUserId,
			esfMatchTypeId, resultClassTeam);
	}

	/**
	* Returns a range of all the e s f results where esfMatchId = &#63; and esfUserId = &#63; and esfMatchTypeId = &#63; and resultClassTeam = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfMatchId the esf match ID
	* @param esfUserId the esf user ID
	* @param esfMatchTypeId the esf match type ID
	* @param resultClassTeam the result class team
	* @param start the lower bound of the range of e s f results
	* @param end the upper bound of the range of e s f results (not inclusive)
	* @return the range of matching e s f results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFResult> findByESFMId_UId_STId_Single(
		long esfMatchId, long esfUserId, long esfMatchTypeId,
		int resultClassTeam, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByESFMId_UId_STId_Single(esfMatchId, esfUserId,
			esfMatchTypeId, resultClassTeam, start, end);
	}

	/**
	* Returns an ordered range of all the e s f results where esfMatchId = &#63; and esfUserId = &#63; and esfMatchTypeId = &#63; and resultClassTeam = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfMatchId the esf match ID
	* @param esfUserId the esf user ID
	* @param esfMatchTypeId the esf match type ID
	* @param resultClassTeam the result class team
	* @param start the lower bound of the range of e s f results
	* @param end the upper bound of the range of e s f results (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFResult> findByESFMId_UId_STId_Single(
		long esfMatchId, long esfUserId, long esfMatchTypeId,
		int resultClassTeam, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByESFMId_UId_STId_Single(esfMatchId, esfUserId,
			esfMatchTypeId, resultClassTeam, start, end, orderByComparator);
	}

	/**
	* Returns the first e s f result in the ordered set where esfMatchId = &#63; and esfUserId = &#63; and esfMatchTypeId = &#63; and resultClassTeam = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfUserId the esf user ID
	* @param esfMatchTypeId the esf match type ID
	* @param resultClassTeam the result class team
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f result
	* @throws it.ethica.esf.NoSuchResultException if a matching e s f result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFResult findByESFMId_UId_STId_Single_First(
		long esfMatchId, long esfUserId, long esfMatchTypeId,
		int resultClassTeam,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchResultException {
		return getPersistence()
				   .findByESFMId_UId_STId_Single_First(esfMatchId, esfUserId,
			esfMatchTypeId, resultClassTeam, orderByComparator);
	}

	/**
	* Returns the first e s f result in the ordered set where esfMatchId = &#63; and esfUserId = &#63; and esfMatchTypeId = &#63; and resultClassTeam = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfUserId the esf user ID
	* @param esfMatchTypeId the esf match type ID
	* @param resultClassTeam the result class team
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f result, or <code>null</code> if a matching e s f result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFResult fetchByESFMId_UId_STId_Single_First(
		long esfMatchId, long esfUserId, long esfMatchTypeId,
		int resultClassTeam,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByESFMId_UId_STId_Single_First(esfMatchId, esfUserId,
			esfMatchTypeId, resultClassTeam, orderByComparator);
	}

	/**
	* Returns the last e s f result in the ordered set where esfMatchId = &#63; and esfUserId = &#63; and esfMatchTypeId = &#63; and resultClassTeam = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfUserId the esf user ID
	* @param esfMatchTypeId the esf match type ID
	* @param resultClassTeam the result class team
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f result
	* @throws it.ethica.esf.NoSuchResultException if a matching e s f result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFResult findByESFMId_UId_STId_Single_Last(
		long esfMatchId, long esfUserId, long esfMatchTypeId,
		int resultClassTeam,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchResultException {
		return getPersistence()
				   .findByESFMId_UId_STId_Single_Last(esfMatchId, esfUserId,
			esfMatchTypeId, resultClassTeam, orderByComparator);
	}

	/**
	* Returns the last e s f result in the ordered set where esfMatchId = &#63; and esfUserId = &#63; and esfMatchTypeId = &#63; and resultClassTeam = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfUserId the esf user ID
	* @param esfMatchTypeId the esf match type ID
	* @param resultClassTeam the result class team
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f result, or <code>null</code> if a matching e s f result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFResult fetchByESFMId_UId_STId_Single_Last(
		long esfMatchId, long esfUserId, long esfMatchTypeId,
		int resultClassTeam,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByESFMId_UId_STId_Single_Last(esfMatchId, esfUserId,
			esfMatchTypeId, resultClassTeam, orderByComparator);
	}

	/**
	* Returns the e s f results before and after the current e s f result in the ordered set where esfMatchId = &#63; and esfUserId = &#63; and esfMatchTypeId = &#63; and resultClassTeam = &#63;.
	*
	* @param esfResultId the primary key of the current e s f result
	* @param esfMatchId the esf match ID
	* @param esfUserId the esf user ID
	* @param esfMatchTypeId the esf match type ID
	* @param resultClassTeam the result class team
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f result
	* @throws it.ethica.esf.NoSuchResultException if a e s f result with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFResult[] findByESFMId_UId_STId_Single_PrevAndNext(
		long esfResultId, long esfMatchId, long esfUserId, long esfMatchTypeId,
		int resultClassTeam,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchResultException {
		return getPersistence()
				   .findByESFMId_UId_STId_Single_PrevAndNext(esfResultId,
			esfMatchId, esfUserId, esfMatchTypeId, resultClassTeam,
			orderByComparator);
	}

	/**
	* Removes all the e s f results where esfMatchId = &#63; and esfUserId = &#63; and esfMatchTypeId = &#63; and resultClassTeam = &#63; from the database.
	*
	* @param esfMatchId the esf match ID
	* @param esfUserId the esf user ID
	* @param esfMatchTypeId the esf match type ID
	* @param resultClassTeam the result class team
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByESFMId_UId_STId_Single(long esfMatchId,
		long esfUserId, long esfMatchTypeId, int resultClassTeam)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByESFMId_UId_STId_Single(esfMatchId, esfUserId,
			esfMatchTypeId, resultClassTeam);
	}

	/**
	* Returns the number of e s f results where esfMatchId = &#63; and esfUserId = &#63; and esfMatchTypeId = &#63; and resultClassTeam = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfUserId the esf user ID
	* @param esfMatchTypeId the esf match type ID
	* @param resultClassTeam the result class team
	* @return the number of matching e s f results
	* @throws SystemException if a system exception occurred
	*/
	public static int countByESFMId_UId_STId_Single(long esfMatchId,
		long esfUserId, long esfMatchTypeId, int resultClassTeam)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByESFMId_UId_STId_Single(esfMatchId, esfUserId,
			esfMatchTypeId, resultClassTeam);
	}

	/**
	* Returns all the e s f results where esfMatchId = &#63; and esfMatchTypeId = &#63; and shooterQualification = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfMatchTypeId the esf match type ID
	* @param shooterQualification the shooter qualification
	* @return the matching e s f results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFResult> findByESFMId_STId_SQId(
		long esfMatchId, long esfMatchTypeId, long shooterQualification)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByESFMId_STId_SQId(esfMatchId, esfMatchTypeId,
			shooterQualification);
	}

	/**
	* Returns a range of all the e s f results where esfMatchId = &#63; and esfMatchTypeId = &#63; and shooterQualification = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfMatchId the esf match ID
	* @param esfMatchTypeId the esf match type ID
	* @param shooterQualification the shooter qualification
	* @param start the lower bound of the range of e s f results
	* @param end the upper bound of the range of e s f results (not inclusive)
	* @return the range of matching e s f results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFResult> findByESFMId_STId_SQId(
		long esfMatchId, long esfMatchTypeId, long shooterQualification,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByESFMId_STId_SQId(esfMatchId, esfMatchTypeId,
			shooterQualification, start, end);
	}

	/**
	* Returns an ordered range of all the e s f results where esfMatchId = &#63; and esfMatchTypeId = &#63; and shooterQualification = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfMatchId the esf match ID
	* @param esfMatchTypeId the esf match type ID
	* @param shooterQualification the shooter qualification
	* @param start the lower bound of the range of e s f results
	* @param end the upper bound of the range of e s f results (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFResult> findByESFMId_STId_SQId(
		long esfMatchId, long esfMatchTypeId, long shooterQualification,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByESFMId_STId_SQId(esfMatchId, esfMatchTypeId,
			shooterQualification, start, end, orderByComparator);
	}

	/**
	* Returns the first e s f result in the ordered set where esfMatchId = &#63; and esfMatchTypeId = &#63; and shooterQualification = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfMatchTypeId the esf match type ID
	* @param shooterQualification the shooter qualification
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f result
	* @throws it.ethica.esf.NoSuchResultException if a matching e s f result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFResult findByESFMId_STId_SQId_First(
		long esfMatchId, long esfMatchTypeId, long shooterQualification,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchResultException {
		return getPersistence()
				   .findByESFMId_STId_SQId_First(esfMatchId, esfMatchTypeId,
			shooterQualification, orderByComparator);
	}

	/**
	* Returns the first e s f result in the ordered set where esfMatchId = &#63; and esfMatchTypeId = &#63; and shooterQualification = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfMatchTypeId the esf match type ID
	* @param shooterQualification the shooter qualification
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f result, or <code>null</code> if a matching e s f result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFResult fetchByESFMId_STId_SQId_First(
		long esfMatchId, long esfMatchTypeId, long shooterQualification,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByESFMId_STId_SQId_First(esfMatchId, esfMatchTypeId,
			shooterQualification, orderByComparator);
	}

	/**
	* Returns the last e s f result in the ordered set where esfMatchId = &#63; and esfMatchTypeId = &#63; and shooterQualification = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfMatchTypeId the esf match type ID
	* @param shooterQualification the shooter qualification
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f result
	* @throws it.ethica.esf.NoSuchResultException if a matching e s f result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFResult findByESFMId_STId_SQId_Last(
		long esfMatchId, long esfMatchTypeId, long shooterQualification,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchResultException {
		return getPersistence()
				   .findByESFMId_STId_SQId_Last(esfMatchId, esfMatchTypeId,
			shooterQualification, orderByComparator);
	}

	/**
	* Returns the last e s f result in the ordered set where esfMatchId = &#63; and esfMatchTypeId = &#63; and shooterQualification = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfMatchTypeId the esf match type ID
	* @param shooterQualification the shooter qualification
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f result, or <code>null</code> if a matching e s f result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFResult fetchByESFMId_STId_SQId_Last(
		long esfMatchId, long esfMatchTypeId, long shooterQualification,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByESFMId_STId_SQId_Last(esfMatchId, esfMatchTypeId,
			shooterQualification, orderByComparator);
	}

	/**
	* Returns the e s f results before and after the current e s f result in the ordered set where esfMatchId = &#63; and esfMatchTypeId = &#63; and shooterQualification = &#63;.
	*
	* @param esfResultId the primary key of the current e s f result
	* @param esfMatchId the esf match ID
	* @param esfMatchTypeId the esf match type ID
	* @param shooterQualification the shooter qualification
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f result
	* @throws it.ethica.esf.NoSuchResultException if a e s f result with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFResult[] findByESFMId_STId_SQId_PrevAndNext(
		long esfResultId, long esfMatchId, long esfMatchTypeId,
		long shooterQualification,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchResultException {
		return getPersistence()
				   .findByESFMId_STId_SQId_PrevAndNext(esfResultId, esfMatchId,
			esfMatchTypeId, shooterQualification, orderByComparator);
	}

	/**
	* Removes all the e s f results where esfMatchId = &#63; and esfMatchTypeId = &#63; and shooterQualification = &#63; from the database.
	*
	* @param esfMatchId the esf match ID
	* @param esfMatchTypeId the esf match type ID
	* @param shooterQualification the shooter qualification
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByESFMId_STId_SQId(long esfMatchId,
		long esfMatchTypeId, long shooterQualification)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByESFMId_STId_SQId(esfMatchId, esfMatchTypeId,
			shooterQualification);
	}

	/**
	* Returns the number of e s f results where esfMatchId = &#63; and esfMatchTypeId = &#63; and shooterQualification = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfMatchTypeId the esf match type ID
	* @param shooterQualification the shooter qualification
	* @return the number of matching e s f results
	* @throws SystemException if a system exception occurred
	*/
	public static int countByESFMId_STId_SQId(long esfMatchId,
		long esfMatchTypeId, long shooterQualification)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByESFMId_STId_SQId(esfMatchId, esfMatchTypeId,
			shooterQualification);
	}

	/**
	* Returns all the e s f results where esfMatchId = &#63; and esfMatchTypeId = &#63; and shooterQualification = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfMatchTypeId the esf match type ID
	* @param shooterQualification the shooter qualification
	* @return the matching e s f results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFResult> findByESFMId_STId_SQId_ResultClassTeam(
		long esfMatchId, long esfMatchTypeId, long shooterQualification)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByESFMId_STId_SQId_ResultClassTeam(esfMatchId,
			esfMatchTypeId, shooterQualification);
	}

	/**
	* Returns a range of all the e s f results where esfMatchId = &#63; and esfMatchTypeId = &#63; and shooterQualification = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfMatchId the esf match ID
	* @param esfMatchTypeId the esf match type ID
	* @param shooterQualification the shooter qualification
	* @param start the lower bound of the range of e s f results
	* @param end the upper bound of the range of e s f results (not inclusive)
	* @return the range of matching e s f results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFResult> findByESFMId_STId_SQId_ResultClassTeam(
		long esfMatchId, long esfMatchTypeId, long shooterQualification,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByESFMId_STId_SQId_ResultClassTeam(esfMatchId,
			esfMatchTypeId, shooterQualification, start, end);
	}

	/**
	* Returns an ordered range of all the e s f results where esfMatchId = &#63; and esfMatchTypeId = &#63; and shooterQualification = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfMatchId the esf match ID
	* @param esfMatchTypeId the esf match type ID
	* @param shooterQualification the shooter qualification
	* @param start the lower bound of the range of e s f results
	* @param end the upper bound of the range of e s f results (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFResult> findByESFMId_STId_SQId_ResultClassTeam(
		long esfMatchId, long esfMatchTypeId, long shooterQualification,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByESFMId_STId_SQId_ResultClassTeam(esfMatchId,
			esfMatchTypeId, shooterQualification, start, end, orderByComparator);
	}

	/**
	* Returns the first e s f result in the ordered set where esfMatchId = &#63; and esfMatchTypeId = &#63; and shooterQualification = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfMatchTypeId the esf match type ID
	* @param shooterQualification the shooter qualification
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f result
	* @throws it.ethica.esf.NoSuchResultException if a matching e s f result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFResult findByESFMId_STId_SQId_ResultClassTeam_First(
		long esfMatchId, long esfMatchTypeId, long shooterQualification,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchResultException {
		return getPersistence()
				   .findByESFMId_STId_SQId_ResultClassTeam_First(esfMatchId,
			esfMatchTypeId, shooterQualification, orderByComparator);
	}

	/**
	* Returns the first e s f result in the ordered set where esfMatchId = &#63; and esfMatchTypeId = &#63; and shooterQualification = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfMatchTypeId the esf match type ID
	* @param shooterQualification the shooter qualification
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f result, or <code>null</code> if a matching e s f result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFResult fetchByESFMId_STId_SQId_ResultClassTeam_First(
		long esfMatchId, long esfMatchTypeId, long shooterQualification,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByESFMId_STId_SQId_ResultClassTeam_First(esfMatchId,
			esfMatchTypeId, shooterQualification, orderByComparator);
	}

	/**
	* Returns the last e s f result in the ordered set where esfMatchId = &#63; and esfMatchTypeId = &#63; and shooterQualification = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfMatchTypeId the esf match type ID
	* @param shooterQualification the shooter qualification
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f result
	* @throws it.ethica.esf.NoSuchResultException if a matching e s f result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFResult findByESFMId_STId_SQId_ResultClassTeam_Last(
		long esfMatchId, long esfMatchTypeId, long shooterQualification,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchResultException {
		return getPersistence()
				   .findByESFMId_STId_SQId_ResultClassTeam_Last(esfMatchId,
			esfMatchTypeId, shooterQualification, orderByComparator);
	}

	/**
	* Returns the last e s f result in the ordered set where esfMatchId = &#63; and esfMatchTypeId = &#63; and shooterQualification = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfMatchTypeId the esf match type ID
	* @param shooterQualification the shooter qualification
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f result, or <code>null</code> if a matching e s f result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFResult fetchByESFMId_STId_SQId_ResultClassTeam_Last(
		long esfMatchId, long esfMatchTypeId, long shooterQualification,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByESFMId_STId_SQId_ResultClassTeam_Last(esfMatchId,
			esfMatchTypeId, shooterQualification, orderByComparator);
	}

	/**
	* Returns the e s f results before and after the current e s f result in the ordered set where esfMatchId = &#63; and esfMatchTypeId = &#63; and shooterQualification = &#63;.
	*
	* @param esfResultId the primary key of the current e s f result
	* @param esfMatchId the esf match ID
	* @param esfMatchTypeId the esf match type ID
	* @param shooterQualification the shooter qualification
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f result
	* @throws it.ethica.esf.NoSuchResultException if a e s f result with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFResult[] findByESFMId_STId_SQId_ResultClassTeam_PrevAndNext(
		long esfResultId, long esfMatchId, long esfMatchTypeId,
		long shooterQualification,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchResultException {
		return getPersistence()
				   .findByESFMId_STId_SQId_ResultClassTeam_PrevAndNext(esfResultId,
			esfMatchId, esfMatchTypeId, shooterQualification, orderByComparator);
	}

	/**
	* Removes all the e s f results where esfMatchId = &#63; and esfMatchTypeId = &#63; and shooterQualification = &#63; from the database.
	*
	* @param esfMatchId the esf match ID
	* @param esfMatchTypeId the esf match type ID
	* @param shooterQualification the shooter qualification
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByESFMId_STId_SQId_ResultClassTeam(
		long esfMatchId, long esfMatchTypeId, long shooterQualification)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByESFMId_STId_SQId_ResultClassTeam(esfMatchId,
			esfMatchTypeId, shooterQualification);
	}

	/**
	* Returns the number of e s f results where esfMatchId = &#63; and esfMatchTypeId = &#63; and shooterQualification = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfMatchTypeId the esf match type ID
	* @param shooterQualification the shooter qualification
	* @return the number of matching e s f results
	* @throws SystemException if a system exception occurred
	*/
	public static int countByESFMId_STId_SQId_ResultClassTeam(long esfMatchId,
		long esfMatchTypeId, long shooterQualification)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByESFMId_STId_SQId_ResultClassTeam(esfMatchId,
			esfMatchTypeId, shooterQualification);
	}

	/**
	* Returns all the e s f results where esfMatchId = &#63; and esfMatchTypeId = &#63; and shooterQualification = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfMatchTypeId the esf match type ID
	* @param shooterQualification the shooter qualification
	* @return the matching e s f results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFResult> findByESFMId_STId_SQId_Single(
		long esfMatchId, long esfMatchTypeId, long shooterQualification)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByESFMId_STId_SQId_Single(esfMatchId, esfMatchTypeId,
			shooterQualification);
	}

	/**
	* Returns a range of all the e s f results where esfMatchId = &#63; and esfMatchTypeId = &#63; and shooterQualification = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfMatchId the esf match ID
	* @param esfMatchTypeId the esf match type ID
	* @param shooterQualification the shooter qualification
	* @param start the lower bound of the range of e s f results
	* @param end the upper bound of the range of e s f results (not inclusive)
	* @return the range of matching e s f results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFResult> findByESFMId_STId_SQId_Single(
		long esfMatchId, long esfMatchTypeId, long shooterQualification,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByESFMId_STId_SQId_Single(esfMatchId, esfMatchTypeId,
			shooterQualification, start, end);
	}

	/**
	* Returns an ordered range of all the e s f results where esfMatchId = &#63; and esfMatchTypeId = &#63; and shooterQualification = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfMatchId the esf match ID
	* @param esfMatchTypeId the esf match type ID
	* @param shooterQualification the shooter qualification
	* @param start the lower bound of the range of e s f results
	* @param end the upper bound of the range of e s f results (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFResult> findByESFMId_STId_SQId_Single(
		long esfMatchId, long esfMatchTypeId, long shooterQualification,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByESFMId_STId_SQId_Single(esfMatchId, esfMatchTypeId,
			shooterQualification, start, end, orderByComparator);
	}

	/**
	* Returns the first e s f result in the ordered set where esfMatchId = &#63; and esfMatchTypeId = &#63; and shooterQualification = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfMatchTypeId the esf match type ID
	* @param shooterQualification the shooter qualification
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f result
	* @throws it.ethica.esf.NoSuchResultException if a matching e s f result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFResult findByESFMId_STId_SQId_Single_First(
		long esfMatchId, long esfMatchTypeId, long shooterQualification,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchResultException {
		return getPersistence()
				   .findByESFMId_STId_SQId_Single_First(esfMatchId,
			esfMatchTypeId, shooterQualification, orderByComparator);
	}

	/**
	* Returns the first e s f result in the ordered set where esfMatchId = &#63; and esfMatchTypeId = &#63; and shooterQualification = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfMatchTypeId the esf match type ID
	* @param shooterQualification the shooter qualification
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f result, or <code>null</code> if a matching e s f result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFResult fetchByESFMId_STId_SQId_Single_First(
		long esfMatchId, long esfMatchTypeId, long shooterQualification,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByESFMId_STId_SQId_Single_First(esfMatchId,
			esfMatchTypeId, shooterQualification, orderByComparator);
	}

	/**
	* Returns the last e s f result in the ordered set where esfMatchId = &#63; and esfMatchTypeId = &#63; and shooterQualification = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfMatchTypeId the esf match type ID
	* @param shooterQualification the shooter qualification
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f result
	* @throws it.ethica.esf.NoSuchResultException if a matching e s f result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFResult findByESFMId_STId_SQId_Single_Last(
		long esfMatchId, long esfMatchTypeId, long shooterQualification,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchResultException {
		return getPersistence()
				   .findByESFMId_STId_SQId_Single_Last(esfMatchId,
			esfMatchTypeId, shooterQualification, orderByComparator);
	}

	/**
	* Returns the last e s f result in the ordered set where esfMatchId = &#63; and esfMatchTypeId = &#63; and shooterQualification = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfMatchTypeId the esf match type ID
	* @param shooterQualification the shooter qualification
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f result, or <code>null</code> if a matching e s f result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFResult fetchByESFMId_STId_SQId_Single_Last(
		long esfMatchId, long esfMatchTypeId, long shooterQualification,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByESFMId_STId_SQId_Single_Last(esfMatchId,
			esfMatchTypeId, shooterQualification, orderByComparator);
	}

	/**
	* Returns the e s f results before and after the current e s f result in the ordered set where esfMatchId = &#63; and esfMatchTypeId = &#63; and shooterQualification = &#63;.
	*
	* @param esfResultId the primary key of the current e s f result
	* @param esfMatchId the esf match ID
	* @param esfMatchTypeId the esf match type ID
	* @param shooterQualification the shooter qualification
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f result
	* @throws it.ethica.esf.NoSuchResultException if a e s f result with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFResult[] findByESFMId_STId_SQId_Single_PrevAndNext(
		long esfResultId, long esfMatchId, long esfMatchTypeId,
		long shooterQualification,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchResultException {
		return getPersistence()
				   .findByESFMId_STId_SQId_Single_PrevAndNext(esfResultId,
			esfMatchId, esfMatchTypeId, shooterQualification, orderByComparator);
	}

	/**
	* Removes all the e s f results where esfMatchId = &#63; and esfMatchTypeId = &#63; and shooterQualification = &#63; from the database.
	*
	* @param esfMatchId the esf match ID
	* @param esfMatchTypeId the esf match type ID
	* @param shooterQualification the shooter qualification
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByESFMId_STId_SQId_Single(long esfMatchId,
		long esfMatchTypeId, long shooterQualification)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByESFMId_STId_SQId_Single(esfMatchId, esfMatchTypeId,
			shooterQualification);
	}

	/**
	* Returns the number of e s f results where esfMatchId = &#63; and esfMatchTypeId = &#63; and shooterQualification = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfMatchTypeId the esf match type ID
	* @param shooterQualification the shooter qualification
	* @return the number of matching e s f results
	* @throws SystemException if a system exception occurred
	*/
	public static int countByESFMId_STId_SQId_Single(long esfMatchId,
		long esfMatchTypeId, long shooterQualification)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByESFMId_STId_SQId_Single(esfMatchId, esfMatchTypeId,
			shooterQualification);
	}

	/**
	* Caches the e s f result in the entity cache if it is enabled.
	*
	* @param esfResult the e s f result
	*/
	public static void cacheResult(it.ethica.esf.model.ESFResult esfResult) {
		getPersistence().cacheResult(esfResult);
	}

	/**
	* Caches the e s f results in the entity cache if it is enabled.
	*
	* @param esfResults the e s f results
	*/
	public static void cacheResult(
		java.util.List<it.ethica.esf.model.ESFResult> esfResults) {
		getPersistence().cacheResult(esfResults);
	}

	/**
	* Creates a new e s f result with the primary key. Does not add the e s f result to the database.
	*
	* @param esfResultId the primary key for the new e s f result
	* @return the new e s f result
	*/
	public static it.ethica.esf.model.ESFResult create(long esfResultId) {
		return getPersistence().create(esfResultId);
	}

	/**
	* Removes the e s f result with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfResultId the primary key of the e s f result
	* @return the e s f result that was removed
	* @throws it.ethica.esf.NoSuchResultException if a e s f result with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFResult remove(long esfResultId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchResultException {
		return getPersistence().remove(esfResultId);
	}

	public static it.ethica.esf.model.ESFResult updateImpl(
		it.ethica.esf.model.ESFResult esfResult)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(esfResult);
	}

	/**
	* Returns the e s f result with the primary key or throws a {@link it.ethica.esf.NoSuchResultException} if it could not be found.
	*
	* @param esfResultId the primary key of the e s f result
	* @return the e s f result
	* @throws it.ethica.esf.NoSuchResultException if a e s f result with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFResult findByPrimaryKey(
		long esfResultId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchResultException {
		return getPersistence().findByPrimaryKey(esfResultId);
	}

	/**
	* Returns the e s f result with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param esfResultId the primary key of the e s f result
	* @return the e s f result, or <code>null</code> if a e s f result with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFResult fetchByPrimaryKey(
		long esfResultId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(esfResultId);
	}

	/**
	* Returns all the e s f results.
	*
	* @return the e s f results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFResult> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the e s f results.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f results
	* @param end the upper bound of the range of e s f results (not inclusive)
	* @return the range of e s f results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFResult> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the e s f results.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f results
	* @param end the upper bound of the range of e s f results (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of e s f results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFResult> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the e s f results from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of e s f results.
	*
	* @return the number of e s f results
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ESFResultPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ESFResultPersistence)PortletBeanLocatorUtil.locate(it.ethica.esf.service.ClpSerializer.getServletContextName(),
					ESFResultPersistence.class.getName());

			ReferenceRegistry.registerReference(ESFResultUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ESFResultPersistence persistence) {
	}

	private static ESFResultPersistence _persistence;
}