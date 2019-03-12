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

import it.ethica.esf.model.ESFMatch;

import java.util.List;

/**
 * The persistence utility for the e s f match service. This utility wraps {@link ESFMatchPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFMatchPersistence
 * @see ESFMatchPersistenceImpl
 * @generated
 */
public class ESFMatchUtil {
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
	public static void clearCache(ESFMatch esfMatch) {
		getPersistence().clearCache(esfMatch);
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
	public static List<ESFMatch> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ESFMatch> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ESFMatch> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ESFMatch update(ESFMatch esfMatch) throws SystemException {
		return getPersistence().update(esfMatch);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ESFMatch update(ESFMatch esfMatch,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(esfMatch, serviceContext);
	}

	/**
	* Returns all the e s f matchs where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching e s f matchs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFMatch> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the e s f matchs where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFMatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of e s f matchs
	* @param end the upper bound of the range of e s f matchs (not inclusive)
	* @return the range of matching e s f matchs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFMatch> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the e s f matchs where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFMatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of e s f matchs
	* @param end the upper bound of the range of e s f matchs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f matchs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFMatch> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns the first e s f match in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f match
	* @throws it.ethica.esf.NoSuchMatchException if a matching e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFMatch findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchMatchException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first e s f match in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f match, or <code>null</code> if a matching e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFMatch fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last e s f match in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f match
	* @throws it.ethica.esf.NoSuchMatchException if a matching e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFMatch findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchMatchException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last e s f match in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f match, or <code>null</code> if a matching e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFMatch fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the e s f matchs before and after the current e s f match in the ordered set where uuid = &#63;.
	*
	* @param esfMatchId the primary key of the current e s f match
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f match
	* @throws it.ethica.esf.NoSuchMatchException if a e s f match with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFMatch[] findByUuid_PrevAndNext(
		long esfMatchId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchMatchException {
		return getPersistence()
				   .findByUuid_PrevAndNext(esfMatchId, uuid, orderByComparator);
	}

	/**
	* Removes all the e s f matchs where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of e s f matchs where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching e s f matchs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the e s f match where uuid = &#63; and groupId = &#63; or throws a {@link it.ethica.esf.NoSuchMatchException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching e s f match
	* @throws it.ethica.esf.NoSuchMatchException if a matching e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFMatch findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchMatchException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the e s f match where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching e s f match, or <code>null</code> if a matching e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFMatch fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the e s f match where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching e s f match, or <code>null</code> if a matching e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFMatch fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the e s f match where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the e s f match that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFMatch removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchMatchException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of e s f matchs where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching e s f matchs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the e s f matchs where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching e s f matchs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFMatch> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the e s f matchs where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFMatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of e s f matchs
	* @param end the upper bound of the range of e s f matchs (not inclusive)
	* @return the range of matching e s f matchs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFMatch> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the e s f matchs where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFMatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of e s f matchs
	* @param end the upper bound of the range of e s f matchs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f matchs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFMatch> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first e s f match in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f match
	* @throws it.ethica.esf.NoSuchMatchException if a matching e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFMatch findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchMatchException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first e s f match in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f match, or <code>null</code> if a matching e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFMatch fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last e s f match in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f match
	* @throws it.ethica.esf.NoSuchMatchException if a matching e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFMatch findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchMatchException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last e s f match in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f match, or <code>null</code> if a matching e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFMatch fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the e s f matchs before and after the current e s f match in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param esfMatchId the primary key of the current e s f match
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f match
	* @throws it.ethica.esf.NoSuchMatchException if a e s f match with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFMatch[] findByUuid_C_PrevAndNext(
		long esfMatchId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchMatchException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(esfMatchId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the e s f matchs where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of e s f matchs where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching e s f matchs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the e s f matchs where esfMatchTypeId = &#63;.
	*
	* @param esfMatchTypeId the esf match type ID
	* @return the matching e s f matchs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFMatch> findByMatchTypeId(
		long esfMatchTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByMatchTypeId(esfMatchTypeId);
	}

	/**
	* Returns a range of all the e s f matchs where esfMatchTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFMatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfMatchTypeId the esf match type ID
	* @param start the lower bound of the range of e s f matchs
	* @param end the upper bound of the range of e s f matchs (not inclusive)
	* @return the range of matching e s f matchs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFMatch> findByMatchTypeId(
		long esfMatchTypeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByMatchTypeId(esfMatchTypeId, start, end);
	}

	/**
	* Returns an ordered range of all the e s f matchs where esfMatchTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFMatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfMatchTypeId the esf match type ID
	* @param start the lower bound of the range of e s f matchs
	* @param end the upper bound of the range of e s f matchs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f matchs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFMatch> findByMatchTypeId(
		long esfMatchTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMatchTypeId(esfMatchTypeId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first e s f match in the ordered set where esfMatchTypeId = &#63;.
	*
	* @param esfMatchTypeId the esf match type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f match
	* @throws it.ethica.esf.NoSuchMatchException if a matching e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFMatch findByMatchTypeId_First(
		long esfMatchTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchMatchException {
		return getPersistence()
				   .findByMatchTypeId_First(esfMatchTypeId, orderByComparator);
	}

	/**
	* Returns the first e s f match in the ordered set where esfMatchTypeId = &#63;.
	*
	* @param esfMatchTypeId the esf match type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f match, or <code>null</code> if a matching e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFMatch fetchByMatchTypeId_First(
		long esfMatchTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByMatchTypeId_First(esfMatchTypeId, orderByComparator);
	}

	/**
	* Returns the last e s f match in the ordered set where esfMatchTypeId = &#63;.
	*
	* @param esfMatchTypeId the esf match type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f match
	* @throws it.ethica.esf.NoSuchMatchException if a matching e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFMatch findByMatchTypeId_Last(
		long esfMatchTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchMatchException {
		return getPersistence()
				   .findByMatchTypeId_Last(esfMatchTypeId, orderByComparator);
	}

	/**
	* Returns the last e s f match in the ordered set where esfMatchTypeId = &#63;.
	*
	* @param esfMatchTypeId the esf match type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f match, or <code>null</code> if a matching e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFMatch fetchByMatchTypeId_Last(
		long esfMatchTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByMatchTypeId_Last(esfMatchTypeId, orderByComparator);
	}

	/**
	* Returns the e s f matchs before and after the current e s f match in the ordered set where esfMatchTypeId = &#63;.
	*
	* @param esfMatchId the primary key of the current e s f match
	* @param esfMatchTypeId the esf match type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f match
	* @throws it.ethica.esf.NoSuchMatchException if a e s f match with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFMatch[] findByMatchTypeId_PrevAndNext(
		long esfMatchId, long esfMatchTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchMatchException {
		return getPersistence()
				   .findByMatchTypeId_PrevAndNext(esfMatchId, esfMatchTypeId,
			orderByComparator);
	}

	/**
	* Removes all the e s f matchs where esfMatchTypeId = &#63; from the database.
	*
	* @param esfMatchTypeId the esf match type ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByMatchTypeId(long esfMatchTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByMatchTypeId(esfMatchTypeId);
	}

	/**
	* Returns the number of e s f matchs where esfMatchTypeId = &#63;.
	*
	* @param esfMatchTypeId the esf match type ID
	* @return the number of matching e s f matchs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByMatchTypeId(long esfMatchTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByMatchTypeId(esfMatchTypeId);
	}

	/**
	* Returns the e s f match where startDate = &#63; and esfMatchTypeId = &#63; and esfAssociationId = &#63; and description = &#63; and isNational = &#63; or throws a {@link it.ethica.esf.NoSuchMatchException} if it could not be found.
	*
	* @param startDate the start date
	* @param esfMatchTypeId the esf match type ID
	* @param esfAssociationId the esf association ID
	* @param description the description
	* @param isNational the is national
	* @return the matching e s f match
	* @throws it.ethica.esf.NoSuchMatchException if a matching e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFMatch findByMatchStartDate_T_A_D_N(
		java.util.Date startDate, long esfMatchTypeId, long esfAssociationId,
		long description, boolean isNational)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchMatchException {
		return getPersistence()
				   .findByMatchStartDate_T_A_D_N(startDate, esfMatchTypeId,
			esfAssociationId, description, isNational);
	}

	/**
	* Returns the e s f match where startDate = &#63; and esfMatchTypeId = &#63; and esfAssociationId = &#63; and description = &#63; and isNational = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param startDate the start date
	* @param esfMatchTypeId the esf match type ID
	* @param esfAssociationId the esf association ID
	* @param description the description
	* @param isNational the is national
	* @return the matching e s f match, or <code>null</code> if a matching e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFMatch fetchByMatchStartDate_T_A_D_N(
		java.util.Date startDate, long esfMatchTypeId, long esfAssociationId,
		long description, boolean isNational)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByMatchStartDate_T_A_D_N(startDate, esfMatchTypeId,
			esfAssociationId, description, isNational);
	}

	/**
	* Returns the e s f match where startDate = &#63; and esfMatchTypeId = &#63; and esfAssociationId = &#63; and description = &#63; and isNational = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param startDate the start date
	* @param esfMatchTypeId the esf match type ID
	* @param esfAssociationId the esf association ID
	* @param description the description
	* @param isNational the is national
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching e s f match, or <code>null</code> if a matching e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFMatch fetchByMatchStartDate_T_A_D_N(
		java.util.Date startDate, long esfMatchTypeId, long esfAssociationId,
		long description, boolean isNational, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByMatchStartDate_T_A_D_N(startDate, esfMatchTypeId,
			esfAssociationId, description, isNational, retrieveFromCache);
	}

	/**
	* Removes the e s f match where startDate = &#63; and esfMatchTypeId = &#63; and esfAssociationId = &#63; and description = &#63; and isNational = &#63; from the database.
	*
	* @param startDate the start date
	* @param esfMatchTypeId the esf match type ID
	* @param esfAssociationId the esf association ID
	* @param description the description
	* @param isNational the is national
	* @return the e s f match that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFMatch removeByMatchStartDate_T_A_D_N(
		java.util.Date startDate, long esfMatchTypeId, long esfAssociationId,
		long description, boolean isNational)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchMatchException {
		return getPersistence()
				   .removeByMatchStartDate_T_A_D_N(startDate, esfMatchTypeId,
			esfAssociationId, description, isNational);
	}

	/**
	* Returns the number of e s f matchs where startDate = &#63; and esfMatchTypeId = &#63; and esfAssociationId = &#63; and description = &#63; and isNational = &#63;.
	*
	* @param startDate the start date
	* @param esfMatchTypeId the esf match type ID
	* @param esfAssociationId the esf association ID
	* @param description the description
	* @param isNational the is national
	* @return the number of matching e s f matchs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByMatchStartDate_T_A_D_N(java.util.Date startDate,
		long esfMatchTypeId, long esfAssociationId, long description,
		boolean isNational)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByMatchStartDate_T_A_D_N(startDate, esfMatchTypeId,
			esfAssociationId, description, isNational);
	}

	/**
	* Returns all the e s f matchs where userId = &#63; and isNational = &#63;.
	*
	* @param userId the user ID
	* @param isNational the is national
	* @return the matching e s f matchs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFMatch> findByUserId_IsNat(
		long userId, boolean isNational)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId_IsNat(userId, isNational);
	}

	/**
	* Returns a range of all the e s f matchs where userId = &#63; and isNational = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFMatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param isNational the is national
	* @param start the lower bound of the range of e s f matchs
	* @param end the upper bound of the range of e s f matchs (not inclusive)
	* @return the range of matching e s f matchs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFMatch> findByUserId_IsNat(
		long userId, boolean isNational, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserId_IsNat(userId, isNational, start, end);
	}

	/**
	* Returns an ordered range of all the e s f matchs where userId = &#63; and isNational = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFMatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param isNational the is national
	* @param start the lower bound of the range of e s f matchs
	* @param end the upper bound of the range of e s f matchs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f matchs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFMatch> findByUserId_IsNat(
		long userId, boolean isNational, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserId_IsNat(userId, isNational, start, end,
			orderByComparator);
	}

	/**
	* Returns the first e s f match in the ordered set where userId = &#63; and isNational = &#63;.
	*
	* @param userId the user ID
	* @param isNational the is national
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f match
	* @throws it.ethica.esf.NoSuchMatchException if a matching e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFMatch findByUserId_IsNat_First(
		long userId, boolean isNational,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchMatchException {
		return getPersistence()
				   .findByUserId_IsNat_First(userId, isNational,
			orderByComparator);
	}

	/**
	* Returns the first e s f match in the ordered set where userId = &#63; and isNational = &#63;.
	*
	* @param userId the user ID
	* @param isNational the is national
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f match, or <code>null</code> if a matching e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFMatch fetchByUserId_IsNat_First(
		long userId, boolean isNational,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUserId_IsNat_First(userId, isNational,
			orderByComparator);
	}

	/**
	* Returns the last e s f match in the ordered set where userId = &#63; and isNational = &#63;.
	*
	* @param userId the user ID
	* @param isNational the is national
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f match
	* @throws it.ethica.esf.NoSuchMatchException if a matching e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFMatch findByUserId_IsNat_Last(
		long userId, boolean isNational,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchMatchException {
		return getPersistence()
				   .findByUserId_IsNat_Last(userId, isNational,
			orderByComparator);
	}

	/**
	* Returns the last e s f match in the ordered set where userId = &#63; and isNational = &#63;.
	*
	* @param userId the user ID
	* @param isNational the is national
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f match, or <code>null</code> if a matching e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFMatch fetchByUserId_IsNat_Last(
		long userId, boolean isNational,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUserId_IsNat_Last(userId, isNational,
			orderByComparator);
	}

	/**
	* Returns the e s f matchs before and after the current e s f match in the ordered set where userId = &#63; and isNational = &#63;.
	*
	* @param esfMatchId the primary key of the current e s f match
	* @param userId the user ID
	* @param isNational the is national
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f match
	* @throws it.ethica.esf.NoSuchMatchException if a e s f match with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFMatch[] findByUserId_IsNat_PrevAndNext(
		long esfMatchId, long userId, boolean isNational,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchMatchException {
		return getPersistence()
				   .findByUserId_IsNat_PrevAndNext(esfMatchId, userId,
			isNational, orderByComparator);
	}

	/**
	* Removes all the e s f matchs where userId = &#63; and isNational = &#63; from the database.
	*
	* @param userId the user ID
	* @param isNational the is national
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUserId_IsNat(long userId, boolean isNational)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUserId_IsNat(userId, isNational);
	}

	/**
	* Returns the number of e s f matchs where userId = &#63; and isNational = &#63;.
	*
	* @param userId the user ID
	* @param isNational the is national
	* @return the number of matching e s f matchs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserId_IsNat(long userId, boolean isNational)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUserId_IsNat(userId, isNational);
	}

	/**
	* Returns all the e s f matchs where userId = &#63; and isNational = &#63; and esfAssociationId = &#63; and startDate = &#63; and description = &#63; and esfSportTypeId = &#63;.
	*
	* @param userId the user ID
	* @param isNational the is national
	* @param esfAssociationId the esf association ID
	* @param startDate the start date
	* @param description the description
	* @param esfSportTypeId the esf sport type ID
	* @return the matching e s f matchs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFMatch> findBymyMatch(
		long userId, boolean isNational, long esfAssociationId,
		java.util.Date startDate, long description, long esfSportTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBymyMatch(userId, isNational, esfAssociationId,
			startDate, description, esfSportTypeId);
	}

	/**
	* Returns a range of all the e s f matchs where userId = &#63; and isNational = &#63; and esfAssociationId = &#63; and startDate = &#63; and description = &#63; and esfSportTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFMatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param isNational the is national
	* @param esfAssociationId the esf association ID
	* @param startDate the start date
	* @param description the description
	* @param esfSportTypeId the esf sport type ID
	* @param start the lower bound of the range of e s f matchs
	* @param end the upper bound of the range of e s f matchs (not inclusive)
	* @return the range of matching e s f matchs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFMatch> findBymyMatch(
		long userId, boolean isNational, long esfAssociationId,
		java.util.Date startDate, long description, long esfSportTypeId,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBymyMatch(userId, isNational, esfAssociationId,
			startDate, description, esfSportTypeId, start, end);
	}

	/**
	* Returns an ordered range of all the e s f matchs where userId = &#63; and isNational = &#63; and esfAssociationId = &#63; and startDate = &#63; and description = &#63; and esfSportTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFMatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param isNational the is national
	* @param esfAssociationId the esf association ID
	* @param startDate the start date
	* @param description the description
	* @param esfSportTypeId the esf sport type ID
	* @param start the lower bound of the range of e s f matchs
	* @param end the upper bound of the range of e s f matchs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f matchs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFMatch> findBymyMatch(
		long userId, boolean isNational, long esfAssociationId,
		java.util.Date startDate, long description, long esfSportTypeId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBymyMatch(userId, isNational, esfAssociationId,
			startDate, description, esfSportTypeId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first e s f match in the ordered set where userId = &#63; and isNational = &#63; and esfAssociationId = &#63; and startDate = &#63; and description = &#63; and esfSportTypeId = &#63;.
	*
	* @param userId the user ID
	* @param isNational the is national
	* @param esfAssociationId the esf association ID
	* @param startDate the start date
	* @param description the description
	* @param esfSportTypeId the esf sport type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f match
	* @throws it.ethica.esf.NoSuchMatchException if a matching e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFMatch findBymyMatch_First(
		long userId, boolean isNational, long esfAssociationId,
		java.util.Date startDate, long description, long esfSportTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchMatchException {
		return getPersistence()
				   .findBymyMatch_First(userId, isNational, esfAssociationId,
			startDate, description, esfSportTypeId, orderByComparator);
	}

	/**
	* Returns the first e s f match in the ordered set where userId = &#63; and isNational = &#63; and esfAssociationId = &#63; and startDate = &#63; and description = &#63; and esfSportTypeId = &#63;.
	*
	* @param userId the user ID
	* @param isNational the is national
	* @param esfAssociationId the esf association ID
	* @param startDate the start date
	* @param description the description
	* @param esfSportTypeId the esf sport type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f match, or <code>null</code> if a matching e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFMatch fetchBymyMatch_First(
		long userId, boolean isNational, long esfAssociationId,
		java.util.Date startDate, long description, long esfSportTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBymyMatch_First(userId, isNational, esfAssociationId,
			startDate, description, esfSportTypeId, orderByComparator);
	}

	/**
	* Returns the last e s f match in the ordered set where userId = &#63; and isNational = &#63; and esfAssociationId = &#63; and startDate = &#63; and description = &#63; and esfSportTypeId = &#63;.
	*
	* @param userId the user ID
	* @param isNational the is national
	* @param esfAssociationId the esf association ID
	* @param startDate the start date
	* @param description the description
	* @param esfSportTypeId the esf sport type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f match
	* @throws it.ethica.esf.NoSuchMatchException if a matching e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFMatch findBymyMatch_Last(long userId,
		boolean isNational, long esfAssociationId, java.util.Date startDate,
		long description, long esfSportTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchMatchException {
		return getPersistence()
				   .findBymyMatch_Last(userId, isNational, esfAssociationId,
			startDate, description, esfSportTypeId, orderByComparator);
	}

	/**
	* Returns the last e s f match in the ordered set where userId = &#63; and isNational = &#63; and esfAssociationId = &#63; and startDate = &#63; and description = &#63; and esfSportTypeId = &#63;.
	*
	* @param userId the user ID
	* @param isNational the is national
	* @param esfAssociationId the esf association ID
	* @param startDate the start date
	* @param description the description
	* @param esfSportTypeId the esf sport type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f match, or <code>null</code> if a matching e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFMatch fetchBymyMatch_Last(
		long userId, boolean isNational, long esfAssociationId,
		java.util.Date startDate, long description, long esfSportTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBymyMatch_Last(userId, isNational, esfAssociationId,
			startDate, description, esfSportTypeId, orderByComparator);
	}

	/**
	* Returns the e s f matchs before and after the current e s f match in the ordered set where userId = &#63; and isNational = &#63; and esfAssociationId = &#63; and startDate = &#63; and description = &#63; and esfSportTypeId = &#63;.
	*
	* @param esfMatchId the primary key of the current e s f match
	* @param userId the user ID
	* @param isNational the is national
	* @param esfAssociationId the esf association ID
	* @param startDate the start date
	* @param description the description
	* @param esfSportTypeId the esf sport type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f match
	* @throws it.ethica.esf.NoSuchMatchException if a e s f match with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFMatch[] findBymyMatch_PrevAndNext(
		long esfMatchId, long userId, boolean isNational,
		long esfAssociationId, java.util.Date startDate, long description,
		long esfSportTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchMatchException {
		return getPersistence()
				   .findBymyMatch_PrevAndNext(esfMatchId, userId, isNational,
			esfAssociationId, startDate, description, esfSportTypeId,
			orderByComparator);
	}

	/**
	* Removes all the e s f matchs where userId = &#63; and isNational = &#63; and esfAssociationId = &#63; and startDate = &#63; and description = &#63; and esfSportTypeId = &#63; from the database.
	*
	* @param userId the user ID
	* @param isNational the is national
	* @param esfAssociationId the esf association ID
	* @param startDate the start date
	* @param description the description
	* @param esfSportTypeId the esf sport type ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBymyMatch(long userId, boolean isNational,
		long esfAssociationId, java.util.Date startDate, long description,
		long esfSportTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeBymyMatch(userId, isNational, esfAssociationId, startDate,
			description, esfSportTypeId);
	}

	/**
	* Returns the number of e s f matchs where userId = &#63; and isNational = &#63; and esfAssociationId = &#63; and startDate = &#63; and description = &#63; and esfSportTypeId = &#63;.
	*
	* @param userId the user ID
	* @param isNational the is national
	* @param esfAssociationId the esf association ID
	* @param startDate the start date
	* @param description the description
	* @param esfSportTypeId the esf sport type ID
	* @return the number of matching e s f matchs
	* @throws SystemException if a system exception occurred
	*/
	public static int countBymyMatch(long userId, boolean isNational,
		long esfAssociationId, java.util.Date startDate, long description,
		long esfSportTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countBymyMatch(userId, isNational, esfAssociationId,
			startDate, description, esfSportTypeId);
	}

	/**
	* Returns all the e s f matchs where eventType = &#63;.
	*
	* @param eventType the event type
	* @return the matching e s f matchs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFMatch> findByEventType(
		java.lang.String eventType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByEventType(eventType);
	}

	/**
	* Returns a range of all the e s f matchs where eventType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFMatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param eventType the event type
	* @param start the lower bound of the range of e s f matchs
	* @param end the upper bound of the range of e s f matchs (not inclusive)
	* @return the range of matching e s f matchs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFMatch> findByEventType(
		java.lang.String eventType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByEventType(eventType, start, end);
	}

	/**
	* Returns an ordered range of all the e s f matchs where eventType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFMatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param eventType the event type
	* @param start the lower bound of the range of e s f matchs
	* @param end the upper bound of the range of e s f matchs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f matchs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFMatch> findByEventType(
		java.lang.String eventType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByEventType(eventType, start, end, orderByComparator);
	}

	/**
	* Returns the first e s f match in the ordered set where eventType = &#63;.
	*
	* @param eventType the event type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f match
	* @throws it.ethica.esf.NoSuchMatchException if a matching e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFMatch findByEventType_First(
		java.lang.String eventType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchMatchException {
		return getPersistence()
				   .findByEventType_First(eventType, orderByComparator);
	}

	/**
	* Returns the first e s f match in the ordered set where eventType = &#63;.
	*
	* @param eventType the event type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f match, or <code>null</code> if a matching e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFMatch fetchByEventType_First(
		java.lang.String eventType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByEventType_First(eventType, orderByComparator);
	}

	/**
	* Returns the last e s f match in the ordered set where eventType = &#63;.
	*
	* @param eventType the event type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f match
	* @throws it.ethica.esf.NoSuchMatchException if a matching e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFMatch findByEventType_Last(
		java.lang.String eventType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchMatchException {
		return getPersistence()
				   .findByEventType_Last(eventType, orderByComparator);
	}

	/**
	* Returns the last e s f match in the ordered set where eventType = &#63;.
	*
	* @param eventType the event type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f match, or <code>null</code> if a matching e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFMatch fetchByEventType_Last(
		java.lang.String eventType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByEventType_Last(eventType, orderByComparator);
	}

	/**
	* Returns the e s f matchs before and after the current e s f match in the ordered set where eventType = &#63;.
	*
	* @param esfMatchId the primary key of the current e s f match
	* @param eventType the event type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f match
	* @throws it.ethica.esf.NoSuchMatchException if a e s f match with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFMatch[] findByEventType_PrevAndNext(
		long esfMatchId, java.lang.String eventType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchMatchException {
		return getPersistence()
				   .findByEventType_PrevAndNext(esfMatchId, eventType,
			orderByComparator);
	}

	/**
	* Removes all the e s f matchs where eventType = &#63; from the database.
	*
	* @param eventType the event type
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByEventType(java.lang.String eventType)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByEventType(eventType);
	}

	/**
	* Returns the number of e s f matchs where eventType = &#63;.
	*
	* @param eventType the event type
	* @return the number of matching e s f matchs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByEventType(java.lang.String eventType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByEventType(eventType);
	}

	/**
	* Returns all the e s f matchs where isChangeCategoryMatch = &#63;.
	*
	* @param isChangeCategoryMatch the is change category match
	* @return the matching e s f matchs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFMatch> findByIsChangeCategory(
		boolean isChangeCategoryMatch)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByIsChangeCategory(isChangeCategoryMatch);
	}

	/**
	* Returns a range of all the e s f matchs where isChangeCategoryMatch = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFMatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param isChangeCategoryMatch the is change category match
	* @param start the lower bound of the range of e s f matchs
	* @param end the upper bound of the range of e s f matchs (not inclusive)
	* @return the range of matching e s f matchs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFMatch> findByIsChangeCategory(
		boolean isChangeCategoryMatch, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByIsChangeCategory(isChangeCategoryMatch, start, end);
	}

	/**
	* Returns an ordered range of all the e s f matchs where isChangeCategoryMatch = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFMatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param isChangeCategoryMatch the is change category match
	* @param start the lower bound of the range of e s f matchs
	* @param end the upper bound of the range of e s f matchs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f matchs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFMatch> findByIsChangeCategory(
		boolean isChangeCategoryMatch, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByIsChangeCategory(isChangeCategoryMatch, start, end,
			orderByComparator);
	}

	/**
	* Returns the first e s f match in the ordered set where isChangeCategoryMatch = &#63;.
	*
	* @param isChangeCategoryMatch the is change category match
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f match
	* @throws it.ethica.esf.NoSuchMatchException if a matching e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFMatch findByIsChangeCategory_First(
		boolean isChangeCategoryMatch,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchMatchException {
		return getPersistence()
				   .findByIsChangeCategory_First(isChangeCategoryMatch,
			orderByComparator);
	}

	/**
	* Returns the first e s f match in the ordered set where isChangeCategoryMatch = &#63;.
	*
	* @param isChangeCategoryMatch the is change category match
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f match, or <code>null</code> if a matching e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFMatch fetchByIsChangeCategory_First(
		boolean isChangeCategoryMatch,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByIsChangeCategory_First(isChangeCategoryMatch,
			orderByComparator);
	}

	/**
	* Returns the last e s f match in the ordered set where isChangeCategoryMatch = &#63;.
	*
	* @param isChangeCategoryMatch the is change category match
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f match
	* @throws it.ethica.esf.NoSuchMatchException if a matching e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFMatch findByIsChangeCategory_Last(
		boolean isChangeCategoryMatch,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchMatchException {
		return getPersistence()
				   .findByIsChangeCategory_Last(isChangeCategoryMatch,
			orderByComparator);
	}

	/**
	* Returns the last e s f match in the ordered set where isChangeCategoryMatch = &#63;.
	*
	* @param isChangeCategoryMatch the is change category match
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f match, or <code>null</code> if a matching e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFMatch fetchByIsChangeCategory_Last(
		boolean isChangeCategoryMatch,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByIsChangeCategory_Last(isChangeCategoryMatch,
			orderByComparator);
	}

	/**
	* Returns the e s f matchs before and after the current e s f match in the ordered set where isChangeCategoryMatch = &#63;.
	*
	* @param esfMatchId the primary key of the current e s f match
	* @param isChangeCategoryMatch the is change category match
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f match
	* @throws it.ethica.esf.NoSuchMatchException if a e s f match with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFMatch[] findByIsChangeCategory_PrevAndNext(
		long esfMatchId, boolean isChangeCategoryMatch,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchMatchException {
		return getPersistence()
				   .findByIsChangeCategory_PrevAndNext(esfMatchId,
			isChangeCategoryMatch, orderByComparator);
	}

	/**
	* Removes all the e s f matchs where isChangeCategoryMatch = &#63; from the database.
	*
	* @param isChangeCategoryMatch the is change category match
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByIsChangeCategory(boolean isChangeCategoryMatch)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByIsChangeCategory(isChangeCategoryMatch);
	}

	/**
	* Returns the number of e s f matchs where isChangeCategoryMatch = &#63;.
	*
	* @param isChangeCategoryMatch the is change category match
	* @return the number of matching e s f matchs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByIsChangeCategory(boolean isChangeCategoryMatch)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByIsChangeCategory(isChangeCategoryMatch);
	}

	/**
	* Returns all the e s f matchs where description = &#63;.
	*
	* @param description the description
	* @return the matching e s f matchs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFMatch> findByDescription(
		long description)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDescription(description);
	}

	/**
	* Returns a range of all the e s f matchs where description = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFMatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param description the description
	* @param start the lower bound of the range of e s f matchs
	* @param end the upper bound of the range of e s f matchs (not inclusive)
	* @return the range of matching e s f matchs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFMatch> findByDescription(
		long description, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDescription(description, start, end);
	}

	/**
	* Returns an ordered range of all the e s f matchs where description = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFMatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param description the description
	* @param start the lower bound of the range of e s f matchs
	* @param end the upper bound of the range of e s f matchs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f matchs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFMatch> findByDescription(
		long description, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDescription(description, start, end, orderByComparator);
	}

	/**
	* Returns the first e s f match in the ordered set where description = &#63;.
	*
	* @param description the description
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f match
	* @throws it.ethica.esf.NoSuchMatchException if a matching e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFMatch findByDescription_First(
		long description,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchMatchException {
		return getPersistence()
				   .findByDescription_First(description, orderByComparator);
	}

	/**
	* Returns the first e s f match in the ordered set where description = &#63;.
	*
	* @param description the description
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f match, or <code>null</code> if a matching e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFMatch fetchByDescription_First(
		long description,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByDescription_First(description, orderByComparator);
	}

	/**
	* Returns the last e s f match in the ordered set where description = &#63;.
	*
	* @param description the description
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f match
	* @throws it.ethica.esf.NoSuchMatchException if a matching e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFMatch findByDescription_Last(
		long description,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchMatchException {
		return getPersistence()
				   .findByDescription_Last(description, orderByComparator);
	}

	/**
	* Returns the last e s f match in the ordered set where description = &#63;.
	*
	* @param description the description
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f match, or <code>null</code> if a matching e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFMatch fetchByDescription_Last(
		long description,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByDescription_Last(description, orderByComparator);
	}

	/**
	* Returns the e s f matchs before and after the current e s f match in the ordered set where description = &#63;.
	*
	* @param esfMatchId the primary key of the current e s f match
	* @param description the description
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f match
	* @throws it.ethica.esf.NoSuchMatchException if a e s f match with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFMatch[] findByDescription_PrevAndNext(
		long esfMatchId, long description,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchMatchException {
		return getPersistence()
				   .findByDescription_PrevAndNext(esfMatchId, description,
			orderByComparator);
	}

	/**
	* Removes all the e s f matchs where description = &#63; from the database.
	*
	* @param description the description
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByDescription(long description)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByDescription(description);
	}

	/**
	* Returns the number of e s f matchs where description = &#63;.
	*
	* @param description the description
	* @return the number of matching e s f matchs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByDescription(long description)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByDescription(description);
	}

	/**
	* Returns the e s f match where code = &#63; or throws a {@link it.ethica.esf.NoSuchMatchException} if it could not be found.
	*
	* @param code the code
	* @return the matching e s f match
	* @throws it.ethica.esf.NoSuchMatchException if a matching e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFMatch findByCode(java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchMatchException {
		return getPersistence().findByCode(code);
	}

	/**
	* Returns the e s f match where code = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param code the code
	* @return the matching e s f match, or <code>null</code> if a matching e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFMatch fetchByCode(
		java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCode(code);
	}

	/**
	* Returns the e s f match where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param code the code
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching e s f match, or <code>null</code> if a matching e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFMatch fetchByCode(
		java.lang.String code, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCode(code, retrieveFromCache);
	}

	/**
	* Removes the e s f match where code = &#63; from the database.
	*
	* @param code the code
	* @return the e s f match that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFMatch removeByCode(
		java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchMatchException {
		return getPersistence().removeByCode(code);
	}

	/**
	* Returns the number of e s f matchs where code = &#63;.
	*
	* @param code the code
	* @return the number of matching e s f matchs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCode(java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCode(code);
	}

	/**
	* Returns all the e s f matchs where startDate &gt; &#63; and isNational = &#63; and code LIKE &#63;.
	*
	* @param startDate the start date
	* @param isNational the is national
	* @param code the code
	* @return the matching e s f matchs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFMatch> findByDate_Code(
		java.util.Date startDate, boolean isNational, java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDate_Code(startDate, isNational, code);
	}

	/**
	* Returns a range of all the e s f matchs where startDate &gt; &#63; and isNational = &#63; and code LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFMatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param startDate the start date
	* @param isNational the is national
	* @param code the code
	* @param start the lower bound of the range of e s f matchs
	* @param end the upper bound of the range of e s f matchs (not inclusive)
	* @return the range of matching e s f matchs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFMatch> findByDate_Code(
		java.util.Date startDate, boolean isNational, java.lang.String code,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDate_Code(startDate, isNational, code, start, end);
	}

	/**
	* Returns an ordered range of all the e s f matchs where startDate &gt; &#63; and isNational = &#63; and code LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFMatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param startDate the start date
	* @param isNational the is national
	* @param code the code
	* @param start the lower bound of the range of e s f matchs
	* @param end the upper bound of the range of e s f matchs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f matchs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFMatch> findByDate_Code(
		java.util.Date startDate, boolean isNational, java.lang.String code,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDate_Code(startDate, isNational, code, start, end,
			orderByComparator);
	}

	/**
	* Returns the first e s f match in the ordered set where startDate &gt; &#63; and isNational = &#63; and code LIKE &#63;.
	*
	* @param startDate the start date
	* @param isNational the is national
	* @param code the code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f match
	* @throws it.ethica.esf.NoSuchMatchException if a matching e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFMatch findByDate_Code_First(
		java.util.Date startDate, boolean isNational, java.lang.String code,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchMatchException {
		return getPersistence()
				   .findByDate_Code_First(startDate, isNational, code,
			orderByComparator);
	}

	/**
	* Returns the first e s f match in the ordered set where startDate &gt; &#63; and isNational = &#63; and code LIKE &#63;.
	*
	* @param startDate the start date
	* @param isNational the is national
	* @param code the code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f match, or <code>null</code> if a matching e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFMatch fetchByDate_Code_First(
		java.util.Date startDate, boolean isNational, java.lang.String code,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByDate_Code_First(startDate, isNational, code,
			orderByComparator);
	}

	/**
	* Returns the last e s f match in the ordered set where startDate &gt; &#63; and isNational = &#63; and code LIKE &#63;.
	*
	* @param startDate the start date
	* @param isNational the is national
	* @param code the code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f match
	* @throws it.ethica.esf.NoSuchMatchException if a matching e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFMatch findByDate_Code_Last(
		java.util.Date startDate, boolean isNational, java.lang.String code,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchMatchException {
		return getPersistence()
				   .findByDate_Code_Last(startDate, isNational, code,
			orderByComparator);
	}

	/**
	* Returns the last e s f match in the ordered set where startDate &gt; &#63; and isNational = &#63; and code LIKE &#63;.
	*
	* @param startDate the start date
	* @param isNational the is national
	* @param code the code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f match, or <code>null</code> if a matching e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFMatch fetchByDate_Code_Last(
		java.util.Date startDate, boolean isNational, java.lang.String code,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByDate_Code_Last(startDate, isNational, code,
			orderByComparator);
	}

	/**
	* Returns the e s f matchs before and after the current e s f match in the ordered set where startDate &gt; &#63; and isNational = &#63; and code LIKE &#63;.
	*
	* @param esfMatchId the primary key of the current e s f match
	* @param startDate the start date
	* @param isNational the is national
	* @param code the code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f match
	* @throws it.ethica.esf.NoSuchMatchException if a e s f match with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFMatch[] findByDate_Code_PrevAndNext(
		long esfMatchId, java.util.Date startDate, boolean isNational,
		java.lang.String code,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchMatchException {
		return getPersistence()
				   .findByDate_Code_PrevAndNext(esfMatchId, startDate,
			isNational, code, orderByComparator);
	}

	/**
	* Removes all the e s f matchs where startDate &gt; &#63; and isNational = &#63; and code LIKE &#63; from the database.
	*
	* @param startDate the start date
	* @param isNational the is national
	* @param code the code
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByDate_Code(java.util.Date startDate,
		boolean isNational, java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByDate_Code(startDate, isNational, code);
	}

	/**
	* Returns the number of e s f matchs where startDate &gt; &#63; and isNational = &#63; and code LIKE &#63;.
	*
	* @param startDate the start date
	* @param isNational the is national
	* @param code the code
	* @return the number of matching e s f matchs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByDate_Code(java.util.Date startDate,
		boolean isNational, java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByDate_Code(startDate, isNational, code);
	}

	/**
	* Caches the e s f match in the entity cache if it is enabled.
	*
	* @param esfMatch the e s f match
	*/
	public static void cacheResult(it.ethica.esf.model.ESFMatch esfMatch) {
		getPersistence().cacheResult(esfMatch);
	}

	/**
	* Caches the e s f matchs in the entity cache if it is enabled.
	*
	* @param esfMatchs the e s f matchs
	*/
	public static void cacheResult(
		java.util.List<it.ethica.esf.model.ESFMatch> esfMatchs) {
		getPersistence().cacheResult(esfMatchs);
	}

	/**
	* Creates a new e s f match with the primary key. Does not add the e s f match to the database.
	*
	* @param esfMatchId the primary key for the new e s f match
	* @return the new e s f match
	*/
	public static it.ethica.esf.model.ESFMatch create(long esfMatchId) {
		return getPersistence().create(esfMatchId);
	}

	/**
	* Removes the e s f match with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfMatchId the primary key of the e s f match
	* @return the e s f match that was removed
	* @throws it.ethica.esf.NoSuchMatchException if a e s f match with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFMatch remove(long esfMatchId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchMatchException {
		return getPersistence().remove(esfMatchId);
	}

	public static it.ethica.esf.model.ESFMatch updateImpl(
		it.ethica.esf.model.ESFMatch esfMatch)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(esfMatch);
	}

	/**
	* Returns the e s f match with the primary key or throws a {@link it.ethica.esf.NoSuchMatchException} if it could not be found.
	*
	* @param esfMatchId the primary key of the e s f match
	* @return the e s f match
	* @throws it.ethica.esf.NoSuchMatchException if a e s f match with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFMatch findByPrimaryKey(long esfMatchId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchMatchException {
		return getPersistence().findByPrimaryKey(esfMatchId);
	}

	/**
	* Returns the e s f match with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param esfMatchId the primary key of the e s f match
	* @return the e s f match, or <code>null</code> if a e s f match with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFMatch fetchByPrimaryKey(
		long esfMatchId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(esfMatchId);
	}

	/**
	* Returns all the e s f matchs.
	*
	* @return the e s f matchs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFMatch> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the e s f matchs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFMatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f matchs
	* @param end the upper bound of the range of e s f matchs (not inclusive)
	* @return the range of e s f matchs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFMatch> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the e s f matchs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFMatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f matchs
	* @param end the upper bound of the range of e s f matchs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of e s f matchs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFMatch> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the e s f matchs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of e s f matchs.
	*
	* @return the number of e s f matchs
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ESFMatchPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ESFMatchPersistence)PortletBeanLocatorUtil.locate(it.ethica.esf.service.ClpSerializer.getServletContextName(),
					ESFMatchPersistence.class.getName());

			ReferenceRegistry.registerReference(ESFMatchUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ESFMatchPersistence persistence) {
	}

	private static ESFMatchPersistence _persistence;
}