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

import it.ethica.esf.model.ESFPartecipant;

import java.util.List;

/**
 * The persistence utility for the e s f partecipant service. This utility wraps {@link ESFPartecipantPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFPartecipantPersistence
 * @see ESFPartecipantPersistenceImpl
 * @generated
 */
public class ESFPartecipantUtil {
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
	public static void clearCache(ESFPartecipant esfPartecipant) {
		getPersistence().clearCache(esfPartecipant);
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
	public static List<ESFPartecipant> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ESFPartecipant> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ESFPartecipant> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ESFPartecipant update(ESFPartecipant esfPartecipant)
		throws SystemException {
		return getPersistence().update(esfPartecipant);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ESFPartecipant update(ESFPartecipant esfPartecipant,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(esfPartecipant, serviceContext);
	}

	/**
	* Returns all the e s f partecipants where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching e s f partecipants
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFPartecipant> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the e s f partecipants where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFPartecipantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of e s f partecipants
	* @param end the upper bound of the range of e s f partecipants (not inclusive)
	* @return the range of matching e s f partecipants
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFPartecipant> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the e s f partecipants where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFPartecipantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of e s f partecipants
	* @param end the upper bound of the range of e s f partecipants (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f partecipants
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFPartecipant> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns the first e s f partecipant in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f partecipant
	* @throws it.ethica.esf.NoSuchPartecipantException if a matching e s f partecipant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFPartecipant findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchPartecipantException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first e s f partecipant in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f partecipant, or <code>null</code> if a matching e s f partecipant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFPartecipant fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last e s f partecipant in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f partecipant
	* @throws it.ethica.esf.NoSuchPartecipantException if a matching e s f partecipant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFPartecipant findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchPartecipantException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last e s f partecipant in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f partecipant, or <code>null</code> if a matching e s f partecipant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFPartecipant fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the e s f partecipants before and after the current e s f partecipant in the ordered set where uuid = &#63;.
	*
	* @param esfPartecipantId the primary key of the current e s f partecipant
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f partecipant
	* @throws it.ethica.esf.NoSuchPartecipantException if a e s f partecipant with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFPartecipant[] findByUuid_PrevAndNext(
		long esfPartecipantId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchPartecipantException {
		return getPersistence()
				   .findByUuid_PrevAndNext(esfPartecipantId, uuid,
			orderByComparator);
	}

	/**
	* Removes all the e s f partecipants where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of e s f partecipants where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching e s f partecipants
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the e s f partecipant where uuid = &#63; and groupId = &#63; or throws a {@link it.ethica.esf.NoSuchPartecipantException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching e s f partecipant
	* @throws it.ethica.esf.NoSuchPartecipantException if a matching e s f partecipant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFPartecipant findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchPartecipantException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the e s f partecipant where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching e s f partecipant, or <code>null</code> if a matching e s f partecipant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFPartecipant fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the e s f partecipant where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching e s f partecipant, or <code>null</code> if a matching e s f partecipant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFPartecipant fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the e s f partecipant where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the e s f partecipant that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFPartecipant removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchPartecipantException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of e s f partecipants where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching e s f partecipants
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the e s f partecipants where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching e s f partecipants
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFPartecipant> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the e s f partecipants where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFPartecipantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of e s f partecipants
	* @param end the upper bound of the range of e s f partecipants (not inclusive)
	* @return the range of matching e s f partecipants
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFPartecipant> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the e s f partecipants where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFPartecipantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of e s f partecipants
	* @param end the upper bound of the range of e s f partecipants (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f partecipants
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFPartecipant> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first e s f partecipant in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f partecipant
	* @throws it.ethica.esf.NoSuchPartecipantException if a matching e s f partecipant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFPartecipant findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchPartecipantException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first e s f partecipant in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f partecipant, or <code>null</code> if a matching e s f partecipant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFPartecipant fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last e s f partecipant in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f partecipant
	* @throws it.ethica.esf.NoSuchPartecipantException if a matching e s f partecipant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFPartecipant findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchPartecipantException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last e s f partecipant in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f partecipant, or <code>null</code> if a matching e s f partecipant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFPartecipant fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the e s f partecipants before and after the current e s f partecipant in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param esfPartecipantId the primary key of the current e s f partecipant
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f partecipant
	* @throws it.ethica.esf.NoSuchPartecipantException if a e s f partecipant with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFPartecipant[] findByUuid_C_PrevAndNext(
		long esfPartecipantId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchPartecipantException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(esfPartecipantId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the e s f partecipants where uuid = &#63; and companyId = &#63; from the database.
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
	* Returns the number of e s f partecipants where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching e s f partecipants
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the e s f partecipants where esfMatchId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @return the matching e s f partecipants
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFPartecipant> findByMatch(
		long esfMatchId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByMatch(esfMatchId);
	}

	/**
	* Returns a range of all the e s f partecipants where esfMatchId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFPartecipantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfMatchId the esf match ID
	* @param start the lower bound of the range of e s f partecipants
	* @param end the upper bound of the range of e s f partecipants (not inclusive)
	* @return the range of matching e s f partecipants
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFPartecipant> findByMatch(
		long esfMatchId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByMatch(esfMatchId, start, end);
	}

	/**
	* Returns an ordered range of all the e s f partecipants where esfMatchId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFPartecipantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfMatchId the esf match ID
	* @param start the lower bound of the range of e s f partecipants
	* @param end the upper bound of the range of e s f partecipants (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f partecipants
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFPartecipant> findByMatch(
		long esfMatchId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMatch(esfMatchId, start, end, orderByComparator);
	}

	/**
	* Returns the first e s f partecipant in the ordered set where esfMatchId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f partecipant
	* @throws it.ethica.esf.NoSuchPartecipantException if a matching e s f partecipant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFPartecipant findByMatch_First(
		long esfMatchId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchPartecipantException {
		return getPersistence().findByMatch_First(esfMatchId, orderByComparator);
	}

	/**
	* Returns the first e s f partecipant in the ordered set where esfMatchId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f partecipant, or <code>null</code> if a matching e s f partecipant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFPartecipant fetchByMatch_First(
		long esfMatchId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByMatch_First(esfMatchId, orderByComparator);
	}

	/**
	* Returns the last e s f partecipant in the ordered set where esfMatchId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f partecipant
	* @throws it.ethica.esf.NoSuchPartecipantException if a matching e s f partecipant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFPartecipant findByMatch_Last(
		long esfMatchId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchPartecipantException {
		return getPersistence().findByMatch_Last(esfMatchId, orderByComparator);
	}

	/**
	* Returns the last e s f partecipant in the ordered set where esfMatchId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f partecipant, or <code>null</code> if a matching e s f partecipant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFPartecipant fetchByMatch_Last(
		long esfMatchId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByMatch_Last(esfMatchId, orderByComparator);
	}

	/**
	* Returns the e s f partecipants before and after the current e s f partecipant in the ordered set where esfMatchId = &#63;.
	*
	* @param esfPartecipantId the primary key of the current e s f partecipant
	* @param esfMatchId the esf match ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f partecipant
	* @throws it.ethica.esf.NoSuchPartecipantException if a e s f partecipant with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFPartecipant[] findByMatch_PrevAndNext(
		long esfPartecipantId, long esfMatchId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchPartecipantException {
		return getPersistence()
				   .findByMatch_PrevAndNext(esfPartecipantId, esfMatchId,
			orderByComparator);
	}

	/**
	* Removes all the e s f partecipants where esfMatchId = &#63; from the database.
	*
	* @param esfMatchId the esf match ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByMatch(long esfMatchId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByMatch(esfMatchId);
	}

	/**
	* Returns the number of e s f partecipants where esfMatchId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @return the number of matching e s f partecipants
	* @throws SystemException if a system exception occurred
	*/
	public static int countByMatch(long esfMatchId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByMatch(esfMatchId);
	}

	/**
	* Returns all the e s f partecipants where esfMatchId = &#63; and esfPartecipantTypeId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfPartecipantTypeId the esf partecipant type ID
	* @return the matching e s f partecipants
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFPartecipant> findByM_T(
		long esfMatchId, long esfPartecipantTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByM_T(esfMatchId, esfPartecipantTypeId);
	}

	/**
	* Returns a range of all the e s f partecipants where esfMatchId = &#63; and esfPartecipantTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFPartecipantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfMatchId the esf match ID
	* @param esfPartecipantTypeId the esf partecipant type ID
	* @param start the lower bound of the range of e s f partecipants
	* @param end the upper bound of the range of e s f partecipants (not inclusive)
	* @return the range of matching e s f partecipants
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFPartecipant> findByM_T(
		long esfMatchId, long esfPartecipantTypeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByM_T(esfMatchId, esfPartecipantTypeId, start, end);
	}

	/**
	* Returns an ordered range of all the e s f partecipants where esfMatchId = &#63; and esfPartecipantTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFPartecipantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfMatchId the esf match ID
	* @param esfPartecipantTypeId the esf partecipant type ID
	* @param start the lower bound of the range of e s f partecipants
	* @param end the upper bound of the range of e s f partecipants (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f partecipants
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFPartecipant> findByM_T(
		long esfMatchId, long esfPartecipantTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByM_T(esfMatchId, esfPartecipantTypeId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first e s f partecipant in the ordered set where esfMatchId = &#63; and esfPartecipantTypeId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfPartecipantTypeId the esf partecipant type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f partecipant
	* @throws it.ethica.esf.NoSuchPartecipantException if a matching e s f partecipant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFPartecipant findByM_T_First(
		long esfMatchId, long esfPartecipantTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchPartecipantException {
		return getPersistence()
				   .findByM_T_First(esfMatchId, esfPartecipantTypeId,
			orderByComparator);
	}

	/**
	* Returns the first e s f partecipant in the ordered set where esfMatchId = &#63; and esfPartecipantTypeId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfPartecipantTypeId the esf partecipant type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f partecipant, or <code>null</code> if a matching e s f partecipant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFPartecipant fetchByM_T_First(
		long esfMatchId, long esfPartecipantTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByM_T_First(esfMatchId, esfPartecipantTypeId,
			orderByComparator);
	}

	/**
	* Returns the last e s f partecipant in the ordered set where esfMatchId = &#63; and esfPartecipantTypeId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfPartecipantTypeId the esf partecipant type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f partecipant
	* @throws it.ethica.esf.NoSuchPartecipantException if a matching e s f partecipant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFPartecipant findByM_T_Last(
		long esfMatchId, long esfPartecipantTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchPartecipantException {
		return getPersistence()
				   .findByM_T_Last(esfMatchId, esfPartecipantTypeId,
			orderByComparator);
	}

	/**
	* Returns the last e s f partecipant in the ordered set where esfMatchId = &#63; and esfPartecipantTypeId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfPartecipantTypeId the esf partecipant type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f partecipant, or <code>null</code> if a matching e s f partecipant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFPartecipant fetchByM_T_Last(
		long esfMatchId, long esfPartecipantTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByM_T_Last(esfMatchId, esfPartecipantTypeId,
			orderByComparator);
	}

	/**
	* Returns the e s f partecipants before and after the current e s f partecipant in the ordered set where esfMatchId = &#63; and esfPartecipantTypeId = &#63;.
	*
	* @param esfPartecipantId the primary key of the current e s f partecipant
	* @param esfMatchId the esf match ID
	* @param esfPartecipantTypeId the esf partecipant type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f partecipant
	* @throws it.ethica.esf.NoSuchPartecipantException if a e s f partecipant with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFPartecipant[] findByM_T_PrevAndNext(
		long esfPartecipantId, long esfMatchId, long esfPartecipantTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchPartecipantException {
		return getPersistence()
				   .findByM_T_PrevAndNext(esfPartecipantId, esfMatchId,
			esfPartecipantTypeId, orderByComparator);
	}

	/**
	* Removes all the e s f partecipants where esfMatchId = &#63; and esfPartecipantTypeId = &#63; from the database.
	*
	* @param esfMatchId the esf match ID
	* @param esfPartecipantTypeId the esf partecipant type ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByM_T(long esfMatchId, long esfPartecipantTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByM_T(esfMatchId, esfPartecipantTypeId);
	}

	/**
	* Returns the number of e s f partecipants where esfMatchId = &#63; and esfPartecipantTypeId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfPartecipantTypeId the esf partecipant type ID
	* @return the number of matching e s f partecipants
	* @throws SystemException if a system exception occurred
	*/
	public static int countByM_T(long esfMatchId, long esfPartecipantTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByM_T(esfMatchId, esfPartecipantTypeId);
	}

	/**
	* Returns the e s f partecipant where esfUserId = &#63; and esfMatchId = &#63; and esfPartecipantTypeId = &#63; or throws a {@link it.ethica.esf.NoSuchPartecipantException} if it could not be found.
	*
	* @param esfUserId the esf user ID
	* @param esfMatchId the esf match ID
	* @param esfPartecipantTypeId the esf partecipant type ID
	* @return the matching e s f partecipant
	* @throws it.ethica.esf.NoSuchPartecipantException if a matching e s f partecipant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFPartecipant findByU_M_T(
		long esfUserId, long esfMatchId, long esfPartecipantTypeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchPartecipantException {
		return getPersistence()
				   .findByU_M_T(esfUserId, esfMatchId, esfPartecipantTypeId);
	}

	/**
	* Returns the e s f partecipant where esfUserId = &#63; and esfMatchId = &#63; and esfPartecipantTypeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param esfUserId the esf user ID
	* @param esfMatchId the esf match ID
	* @param esfPartecipantTypeId the esf partecipant type ID
	* @return the matching e s f partecipant, or <code>null</code> if a matching e s f partecipant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFPartecipant fetchByU_M_T(
		long esfUserId, long esfMatchId, long esfPartecipantTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByU_M_T(esfUserId, esfMatchId, esfPartecipantTypeId);
	}

	/**
	* Returns the e s f partecipant where esfUserId = &#63; and esfMatchId = &#63; and esfPartecipantTypeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param esfUserId the esf user ID
	* @param esfMatchId the esf match ID
	* @param esfPartecipantTypeId the esf partecipant type ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching e s f partecipant, or <code>null</code> if a matching e s f partecipant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFPartecipant fetchByU_M_T(
		long esfUserId, long esfMatchId, long esfPartecipantTypeId,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByU_M_T(esfUserId, esfMatchId, esfPartecipantTypeId,
			retrieveFromCache);
	}

	/**
	* Removes the e s f partecipant where esfUserId = &#63; and esfMatchId = &#63; and esfPartecipantTypeId = &#63; from the database.
	*
	* @param esfUserId the esf user ID
	* @param esfMatchId the esf match ID
	* @param esfPartecipantTypeId the esf partecipant type ID
	* @return the e s f partecipant that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFPartecipant removeByU_M_T(
		long esfUserId, long esfMatchId, long esfPartecipantTypeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchPartecipantException {
		return getPersistence()
				   .removeByU_M_T(esfUserId, esfMatchId, esfPartecipantTypeId);
	}

	/**
	* Returns the number of e s f partecipants where esfUserId = &#63; and esfMatchId = &#63; and esfPartecipantTypeId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param esfMatchId the esf match ID
	* @param esfPartecipantTypeId the esf partecipant type ID
	* @return the number of matching e s f partecipants
	* @throws SystemException if a system exception occurred
	*/
	public static int countByU_M_T(long esfUserId, long esfMatchId,
		long esfPartecipantTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByU_M_T(esfUserId, esfMatchId, esfPartecipantTypeId);
	}

	/**
	* Returns the e s f partecipant where userId = &#63; or throws a {@link it.ethica.esf.NoSuchPartecipantException} if it could not be found.
	*
	* @param userId the user ID
	* @return the matching e s f partecipant
	* @throws it.ethica.esf.NoSuchPartecipantException if a matching e s f partecipant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFPartecipant findByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchPartecipantException {
		return getPersistence().findByUserId(userId);
	}

	/**
	* Returns the e s f partecipant where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userId the user ID
	* @return the matching e s f partecipant, or <code>null</code> if a matching e s f partecipant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFPartecipant fetchByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUserId(userId);
	}

	/**
	* Returns the e s f partecipant where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userId the user ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching e s f partecipant, or <code>null</code> if a matching e s f partecipant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFPartecipant fetchByUserId(
		long userId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUserId(userId, retrieveFromCache);
	}

	/**
	* Removes the e s f partecipant where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @return the e s f partecipant that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFPartecipant removeByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchPartecipantException {
		return getPersistence().removeByUserId(userId);
	}

	/**
	* Returns the number of e s f partecipants where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching e s f partecipants
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUserId(userId);
	}

	/**
	* Caches the e s f partecipant in the entity cache if it is enabled.
	*
	* @param esfPartecipant the e s f partecipant
	*/
	public static void cacheResult(
		it.ethica.esf.model.ESFPartecipant esfPartecipant) {
		getPersistence().cacheResult(esfPartecipant);
	}

	/**
	* Caches the e s f partecipants in the entity cache if it is enabled.
	*
	* @param esfPartecipants the e s f partecipants
	*/
	public static void cacheResult(
		java.util.List<it.ethica.esf.model.ESFPartecipant> esfPartecipants) {
		getPersistence().cacheResult(esfPartecipants);
	}

	/**
	* Creates a new e s f partecipant with the primary key. Does not add the e s f partecipant to the database.
	*
	* @param esfPartecipantId the primary key for the new e s f partecipant
	* @return the new e s f partecipant
	*/
	public static it.ethica.esf.model.ESFPartecipant create(
		long esfPartecipantId) {
		return getPersistence().create(esfPartecipantId);
	}

	/**
	* Removes the e s f partecipant with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfPartecipantId the primary key of the e s f partecipant
	* @return the e s f partecipant that was removed
	* @throws it.ethica.esf.NoSuchPartecipantException if a e s f partecipant with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFPartecipant remove(
		long esfPartecipantId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchPartecipantException {
		return getPersistence().remove(esfPartecipantId);
	}

	public static it.ethica.esf.model.ESFPartecipant updateImpl(
		it.ethica.esf.model.ESFPartecipant esfPartecipant)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(esfPartecipant);
	}

	/**
	* Returns the e s f partecipant with the primary key or throws a {@link it.ethica.esf.NoSuchPartecipantException} if it could not be found.
	*
	* @param esfPartecipantId the primary key of the e s f partecipant
	* @return the e s f partecipant
	* @throws it.ethica.esf.NoSuchPartecipantException if a e s f partecipant with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFPartecipant findByPrimaryKey(
		long esfPartecipantId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchPartecipantException {
		return getPersistence().findByPrimaryKey(esfPartecipantId);
	}

	/**
	* Returns the e s f partecipant with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param esfPartecipantId the primary key of the e s f partecipant
	* @return the e s f partecipant, or <code>null</code> if a e s f partecipant with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFPartecipant fetchByPrimaryKey(
		long esfPartecipantId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(esfPartecipantId);
	}

	/**
	* Returns all the e s f partecipants.
	*
	* @return the e s f partecipants
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFPartecipant> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the e s f partecipants.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFPartecipantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f partecipants
	* @param end the upper bound of the range of e s f partecipants (not inclusive)
	* @return the range of e s f partecipants
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFPartecipant> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the e s f partecipants.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFPartecipantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f partecipants
	* @param end the upper bound of the range of e s f partecipants (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of e s f partecipants
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFPartecipant> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the e s f partecipants from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of e s f partecipants.
	*
	* @return the number of e s f partecipants
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ESFPartecipantPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ESFPartecipantPersistence)PortletBeanLocatorUtil.locate(it.ethica.esf.service.ClpSerializer.getServletContextName(),
					ESFPartecipantPersistence.class.getName());

			ReferenceRegistry.registerReference(ESFPartecipantUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ESFPartecipantPersistence persistence) {
	}

	private static ESFPartecipantPersistence _persistence;
}