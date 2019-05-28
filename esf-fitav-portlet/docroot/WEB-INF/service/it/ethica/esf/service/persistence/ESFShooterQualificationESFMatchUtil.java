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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import it.ethica.esf.model.ESFShooterQualificationESFMatch;

import java.util.List;

/**
 * The persistence utility for the e s f shooter qualification e s f match service. This utility wraps {@link ESFShooterQualificationESFMatchPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFShooterQualificationESFMatchPersistence
 * @see ESFShooterQualificationESFMatchPersistenceImpl
 * @generated
 */
public class ESFShooterQualificationESFMatchUtil {
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
	public static void clearCache(
		ESFShooterQualificationESFMatch esfShooterQualificationESFMatch) {
		getPersistence().clearCache(esfShooterQualificationESFMatch);
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
	public static List<ESFShooterQualificationESFMatch> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ESFShooterQualificationESFMatch> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ESFShooterQualificationESFMatch> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ESFShooterQualificationESFMatch update(
		ESFShooterQualificationESFMatch esfShooterQualificationESFMatch)
		throws SystemException {
		return getPersistence().update(esfShooterQualificationESFMatch);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ESFShooterQualificationESFMatch update(
		ESFShooterQualificationESFMatch esfShooterQualificationESFMatch,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence()
				   .update(esfShooterQualificationESFMatch, serviceContext);
	}

	/**
	* Returns all the e s f shooter qualification e s f matchs where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching e s f shooter qualification e s f matchs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFShooterQualificationESFMatch> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the e s f shooter qualification e s f matchs where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShooterQualificationESFMatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of e s f shooter qualification e s f matchs
	* @param end the upper bound of the range of e s f shooter qualification e s f matchs (not inclusive)
	* @return the range of matching e s f shooter qualification e s f matchs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFShooterQualificationESFMatch> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the e s f shooter qualification e s f matchs where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShooterQualificationESFMatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of e s f shooter qualification e s f matchs
	* @param end the upper bound of the range of e s f shooter qualification e s f matchs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f shooter qualification e s f matchs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFShooterQualificationESFMatch> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns the first e s f shooter qualification e s f match in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f shooter qualification e s f match
	* @throws it.ethica.esf.NoSuchShooterQualificationESFMatchException if a matching e s f shooter qualification e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFShooterQualificationESFMatch findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchShooterQualificationESFMatchException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first e s f shooter qualification e s f match in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f shooter qualification e s f match, or <code>null</code> if a matching e s f shooter qualification e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFShooterQualificationESFMatch fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last e s f shooter qualification e s f match in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f shooter qualification e s f match
	* @throws it.ethica.esf.NoSuchShooterQualificationESFMatchException if a matching e s f shooter qualification e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFShooterQualificationESFMatch findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchShooterQualificationESFMatchException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last e s f shooter qualification e s f match in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f shooter qualification e s f match, or <code>null</code> if a matching e s f shooter qualification e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFShooterQualificationESFMatch fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the e s f shooter qualification e s f matchs before and after the current e s f shooter qualification e s f match in the ordered set where uuid = &#63;.
	*
	* @param esfShooterQualificationESFMatchPK the primary key of the current e s f shooter qualification e s f match
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f shooter qualification e s f match
	* @throws it.ethica.esf.NoSuchShooterQualificationESFMatchException if a e s f shooter qualification e s f match with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFShooterQualificationESFMatch[] findByUuid_PrevAndNext(
		ESFShooterQualificationESFMatchPK esfShooterQualificationESFMatchPK,
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchShooterQualificationESFMatchException {
		return getPersistence()
				   .findByUuid_PrevAndNext(esfShooterQualificationESFMatchPK,
			uuid, orderByComparator);
	}

	/**
	* Removes all the e s f shooter qualification e s f matchs where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of e s f shooter qualification e s f matchs where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching e s f shooter qualification e s f matchs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the e s f shooter qualification e s f match where uuid = &#63; and groupId = &#63; or throws a {@link it.ethica.esf.NoSuchShooterQualificationESFMatchException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching e s f shooter qualification e s f match
	* @throws it.ethica.esf.NoSuchShooterQualificationESFMatchException if a matching e s f shooter qualification e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFShooterQualificationESFMatch findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchShooterQualificationESFMatchException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the e s f shooter qualification e s f match where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching e s f shooter qualification e s f match, or <code>null</code> if a matching e s f shooter qualification e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFShooterQualificationESFMatch fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the e s f shooter qualification e s f match where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching e s f shooter qualification e s f match, or <code>null</code> if a matching e s f shooter qualification e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFShooterQualificationESFMatch fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the e s f shooter qualification e s f match where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the e s f shooter qualification e s f match that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFShooterQualificationESFMatch removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchShooterQualificationESFMatchException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of e s f shooter qualification e s f matchs where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching e s f shooter qualification e s f matchs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the e s f shooter qualification e s f matchs where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching e s f shooter qualification e s f matchs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFShooterQualificationESFMatch> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the e s f shooter qualification e s f matchs where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShooterQualificationESFMatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of e s f shooter qualification e s f matchs
	* @param end the upper bound of the range of e s f shooter qualification e s f matchs (not inclusive)
	* @return the range of matching e s f shooter qualification e s f matchs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFShooterQualificationESFMatch> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the e s f shooter qualification e s f matchs where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShooterQualificationESFMatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of e s f shooter qualification e s f matchs
	* @param end the upper bound of the range of e s f shooter qualification e s f matchs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f shooter qualification e s f matchs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFShooterQualificationESFMatch> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first e s f shooter qualification e s f match in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f shooter qualification e s f match
	* @throws it.ethica.esf.NoSuchShooterQualificationESFMatchException if a matching e s f shooter qualification e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFShooterQualificationESFMatch findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchShooterQualificationESFMatchException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first e s f shooter qualification e s f match in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f shooter qualification e s f match, or <code>null</code> if a matching e s f shooter qualification e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFShooterQualificationESFMatch fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last e s f shooter qualification e s f match in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f shooter qualification e s f match
	* @throws it.ethica.esf.NoSuchShooterQualificationESFMatchException if a matching e s f shooter qualification e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFShooterQualificationESFMatch findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchShooterQualificationESFMatchException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last e s f shooter qualification e s f match in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f shooter qualification e s f match, or <code>null</code> if a matching e s f shooter qualification e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFShooterQualificationESFMatch fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the e s f shooter qualification e s f matchs before and after the current e s f shooter qualification e s f match in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param esfShooterQualificationESFMatchPK the primary key of the current e s f shooter qualification e s f match
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f shooter qualification e s f match
	* @throws it.ethica.esf.NoSuchShooterQualificationESFMatchException if a e s f shooter qualification e s f match with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFShooterQualificationESFMatch[] findByUuid_C_PrevAndNext(
		ESFShooterQualificationESFMatchPK esfShooterQualificationESFMatchPK,
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchShooterQualificationESFMatchException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(esfShooterQualificationESFMatchPK,
			uuid, companyId, orderByComparator);
	}

	/**
	* Removes all the e s f shooter qualification e s f matchs where uuid = &#63; and companyId = &#63; from the database.
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
	* Returns the number of e s f shooter qualification e s f matchs where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching e s f shooter qualification e s f matchs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the e s f shooter qualification e s f matchs where esfMatchId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @return the matching e s f shooter qualification e s f matchs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFShooterQualificationESFMatch> findByESFMatch(
		long esfMatchId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByESFMatch(esfMatchId);
	}

	/**
	* Returns a range of all the e s f shooter qualification e s f matchs where esfMatchId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShooterQualificationESFMatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfMatchId the esf match ID
	* @param start the lower bound of the range of e s f shooter qualification e s f matchs
	* @param end the upper bound of the range of e s f shooter qualification e s f matchs (not inclusive)
	* @return the range of matching e s f shooter qualification e s f matchs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFShooterQualificationESFMatch> findByESFMatch(
		long esfMatchId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByESFMatch(esfMatchId, start, end);
	}

	/**
	* Returns an ordered range of all the e s f shooter qualification e s f matchs where esfMatchId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShooterQualificationESFMatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfMatchId the esf match ID
	* @param start the lower bound of the range of e s f shooter qualification e s f matchs
	* @param end the upper bound of the range of e s f shooter qualification e s f matchs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f shooter qualification e s f matchs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFShooterQualificationESFMatch> findByESFMatch(
		long esfMatchId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByESFMatch(esfMatchId, start, end, orderByComparator);
	}

	/**
	* Returns the first e s f shooter qualification e s f match in the ordered set where esfMatchId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f shooter qualification e s f match
	* @throws it.ethica.esf.NoSuchShooterQualificationESFMatchException if a matching e s f shooter qualification e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFShooterQualificationESFMatch findByESFMatch_First(
		long esfMatchId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchShooterQualificationESFMatchException {
		return getPersistence()
				   .findByESFMatch_First(esfMatchId, orderByComparator);
	}

	/**
	* Returns the first e s f shooter qualification e s f match in the ordered set where esfMatchId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f shooter qualification e s f match, or <code>null</code> if a matching e s f shooter qualification e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFShooterQualificationESFMatch fetchByESFMatch_First(
		long esfMatchId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByESFMatch_First(esfMatchId, orderByComparator);
	}

	/**
	* Returns the last e s f shooter qualification e s f match in the ordered set where esfMatchId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f shooter qualification e s f match
	* @throws it.ethica.esf.NoSuchShooterQualificationESFMatchException if a matching e s f shooter qualification e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFShooterQualificationESFMatch findByESFMatch_Last(
		long esfMatchId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchShooterQualificationESFMatchException {
		return getPersistence()
				   .findByESFMatch_Last(esfMatchId, orderByComparator);
	}

	/**
	* Returns the last e s f shooter qualification e s f match in the ordered set where esfMatchId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f shooter qualification e s f match, or <code>null</code> if a matching e s f shooter qualification e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFShooterQualificationESFMatch fetchByESFMatch_Last(
		long esfMatchId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByESFMatch_Last(esfMatchId, orderByComparator);
	}

	/**
	* Returns the e s f shooter qualification e s f matchs before and after the current e s f shooter qualification e s f match in the ordered set where esfMatchId = &#63;.
	*
	* @param esfShooterQualificationESFMatchPK the primary key of the current e s f shooter qualification e s f match
	* @param esfMatchId the esf match ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f shooter qualification e s f match
	* @throws it.ethica.esf.NoSuchShooterQualificationESFMatchException if a e s f shooter qualification e s f match with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFShooterQualificationESFMatch[] findByESFMatch_PrevAndNext(
		ESFShooterQualificationESFMatchPK esfShooterQualificationESFMatchPK,
		long esfMatchId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchShooterQualificationESFMatchException {
		return getPersistence()
				   .findByESFMatch_PrevAndNext(esfShooterQualificationESFMatchPK,
			esfMatchId, orderByComparator);
	}

	/**
	* Removes all the e s f shooter qualification e s f matchs where esfMatchId = &#63; from the database.
	*
	* @param esfMatchId the esf match ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByESFMatch(long esfMatchId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByESFMatch(esfMatchId);
	}

	/**
	* Returns the number of e s f shooter qualification e s f matchs where esfMatchId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @return the number of matching e s f shooter qualification e s f matchs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByESFMatch(long esfMatchId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByESFMatch(esfMatchId);
	}

	/**
	* Caches the e s f shooter qualification e s f match in the entity cache if it is enabled.
	*
	* @param esfShooterQualificationESFMatch the e s f shooter qualification e s f match
	*/
	public static void cacheResult(
		it.ethica.esf.model.ESFShooterQualificationESFMatch esfShooterQualificationESFMatch) {
		getPersistence().cacheResult(esfShooterQualificationESFMatch);
	}

	/**
	* Caches the e s f shooter qualification e s f matchs in the entity cache if it is enabled.
	*
	* @param esfShooterQualificationESFMatchs the e s f shooter qualification e s f matchs
	*/
	public static void cacheResult(
		java.util.List<it.ethica.esf.model.ESFShooterQualificationESFMatch> esfShooterQualificationESFMatchs) {
		getPersistence().cacheResult(esfShooterQualificationESFMatchs);
	}

	/**
	* Creates a new e s f shooter qualification e s f match with the primary key. Does not add the e s f shooter qualification e s f match to the database.
	*
	* @param esfShooterQualificationESFMatchPK the primary key for the new e s f shooter qualification e s f match
	* @return the new e s f shooter qualification e s f match
	*/
	public static it.ethica.esf.model.ESFShooterQualificationESFMatch create(
		ESFShooterQualificationESFMatchPK esfShooterQualificationESFMatchPK) {
		return getPersistence().create(esfShooterQualificationESFMatchPK);
	}

	/**
	* Removes the e s f shooter qualification e s f match with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfShooterQualificationESFMatchPK the primary key of the e s f shooter qualification e s f match
	* @return the e s f shooter qualification e s f match that was removed
	* @throws it.ethica.esf.NoSuchShooterQualificationESFMatchException if a e s f shooter qualification e s f match with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFShooterQualificationESFMatch remove(
		ESFShooterQualificationESFMatchPK esfShooterQualificationESFMatchPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchShooterQualificationESFMatchException {
		return getPersistence().remove(esfShooterQualificationESFMatchPK);
	}

	public static it.ethica.esf.model.ESFShooterQualificationESFMatch updateImpl(
		it.ethica.esf.model.ESFShooterQualificationESFMatch esfShooterQualificationESFMatch)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(esfShooterQualificationESFMatch);
	}

	/**
	* Returns the e s f shooter qualification e s f match with the primary key or throws a {@link it.ethica.esf.NoSuchShooterQualificationESFMatchException} if it could not be found.
	*
	* @param esfShooterQualificationESFMatchPK the primary key of the e s f shooter qualification e s f match
	* @return the e s f shooter qualification e s f match
	* @throws it.ethica.esf.NoSuchShooterQualificationESFMatchException if a e s f shooter qualification e s f match with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFShooterQualificationESFMatch findByPrimaryKey(
		ESFShooterQualificationESFMatchPK esfShooterQualificationESFMatchPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchShooterQualificationESFMatchException {
		return getPersistence()
				   .findByPrimaryKey(esfShooterQualificationESFMatchPK);
	}

	/**
	* Returns the e s f shooter qualification e s f match with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param esfShooterQualificationESFMatchPK the primary key of the e s f shooter qualification e s f match
	* @return the e s f shooter qualification e s f match, or <code>null</code> if a e s f shooter qualification e s f match with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFShooterQualificationESFMatch fetchByPrimaryKey(
		ESFShooterQualificationESFMatchPK esfShooterQualificationESFMatchPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPrimaryKey(esfShooterQualificationESFMatchPK);
	}

	/**
	* Returns all the e s f shooter qualification e s f matchs.
	*
	* @return the e s f shooter qualification e s f matchs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFShooterQualificationESFMatch> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the e s f shooter qualification e s f matchs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShooterQualificationESFMatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f shooter qualification e s f matchs
	* @param end the upper bound of the range of e s f shooter qualification e s f matchs (not inclusive)
	* @return the range of e s f shooter qualification e s f matchs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFShooterQualificationESFMatch> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the e s f shooter qualification e s f matchs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShooterQualificationESFMatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f shooter qualification e s f matchs
	* @param end the upper bound of the range of e s f shooter qualification e s f matchs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of e s f shooter qualification e s f matchs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFShooterQualificationESFMatch> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the e s f shooter qualification e s f matchs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of e s f shooter qualification e s f matchs.
	*
	* @return the number of e s f shooter qualification e s f matchs
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ESFShooterQualificationESFMatchPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ESFShooterQualificationESFMatchPersistence)PortletBeanLocatorUtil.locate(it.ethica.esf.service.ClpSerializer.getServletContextName(),
					ESFShooterQualificationESFMatchPersistence.class.getName());

			ReferenceRegistry.registerReference(ESFShooterQualificationESFMatchUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(
		ESFShooterQualificationESFMatchPersistence persistence) {
	}

	private static ESFShooterQualificationESFMatchPersistence _persistence;
}