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

import it.ethica.esf.model.ESFNationalDelegation;

import java.util.List;

/**
 * The persistence utility for the e s f national delegation service. This utility wraps {@link ESFNationalDelegationPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFNationalDelegationPersistence
 * @see ESFNationalDelegationPersistenceImpl
 * @generated
 */
public class ESFNationalDelegationUtil {
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
	public static void clearCache(ESFNationalDelegation esfNationalDelegation) {
		getPersistence().clearCache(esfNationalDelegation);
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
	public static List<ESFNationalDelegation> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ESFNationalDelegation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ESFNationalDelegation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ESFNationalDelegation update(
		ESFNationalDelegation esfNationalDelegation) throws SystemException {
		return getPersistence().update(esfNationalDelegation);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ESFNationalDelegation update(
		ESFNationalDelegation esfNationalDelegation,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(esfNationalDelegation, serviceContext);
	}

	/**
	* Returns all the e s f national delegations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching e s f national delegations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFNationalDelegation> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the e s f national delegations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalDelegationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of e s f national delegations
	* @param end the upper bound of the range of e s f national delegations (not inclusive)
	* @return the range of matching e s f national delegations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFNationalDelegation> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the e s f national delegations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalDelegationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of e s f national delegations
	* @param end the upper bound of the range of e s f national delegations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f national delegations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFNationalDelegation> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns the first e s f national delegation in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f national delegation
	* @throws it.ethica.esf.NoSuchNationalDelegationException if a matching e s f national delegation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNationalDelegation findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalDelegationException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first e s f national delegation in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f national delegation, or <code>null</code> if a matching e s f national delegation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNationalDelegation fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last e s f national delegation in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f national delegation
	* @throws it.ethica.esf.NoSuchNationalDelegationException if a matching e s f national delegation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNationalDelegation findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalDelegationException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last e s f national delegation in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f national delegation, or <code>null</code> if a matching e s f national delegation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNationalDelegation fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the e s f national delegations before and after the current e s f national delegation in the ordered set where uuid = &#63;.
	*
	* @param esfNationalDelgationId the primary key of the current e s f national delegation
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f national delegation
	* @throws it.ethica.esf.NoSuchNationalDelegationException if a e s f national delegation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNationalDelegation[] findByUuid_PrevAndNext(
		long esfNationalDelgationId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalDelegationException {
		return getPersistence()
				   .findByUuid_PrevAndNext(esfNationalDelgationId, uuid,
			orderByComparator);
	}

	/**
	* Removes all the e s f national delegations where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of e s f national delegations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching e s f national delegations
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the e s f national delegation where uuid = &#63; and groupId = &#63; or throws a {@link it.ethica.esf.NoSuchNationalDelegationException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching e s f national delegation
	* @throws it.ethica.esf.NoSuchNationalDelegationException if a matching e s f national delegation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNationalDelegation findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalDelegationException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the e s f national delegation where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching e s f national delegation, or <code>null</code> if a matching e s f national delegation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNationalDelegation fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the e s f national delegation where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching e s f national delegation, or <code>null</code> if a matching e s f national delegation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNationalDelegation fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the e s f national delegation where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the e s f national delegation that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNationalDelegation removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalDelegationException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of e s f national delegations where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching e s f national delegations
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the e s f national delegations where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching e s f national delegations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFNationalDelegation> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the e s f national delegations where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalDelegationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of e s f national delegations
	* @param end the upper bound of the range of e s f national delegations (not inclusive)
	* @return the range of matching e s f national delegations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFNationalDelegation> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the e s f national delegations where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalDelegationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of e s f national delegations
	* @param end the upper bound of the range of e s f national delegations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f national delegations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFNationalDelegation> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first e s f national delegation in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f national delegation
	* @throws it.ethica.esf.NoSuchNationalDelegationException if a matching e s f national delegation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNationalDelegation findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalDelegationException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first e s f national delegation in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f national delegation, or <code>null</code> if a matching e s f national delegation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNationalDelegation fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last e s f national delegation in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f national delegation
	* @throws it.ethica.esf.NoSuchNationalDelegationException if a matching e s f national delegation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNationalDelegation findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalDelegationException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last e s f national delegation in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f national delegation, or <code>null</code> if a matching e s f national delegation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNationalDelegation fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the e s f national delegations before and after the current e s f national delegation in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param esfNationalDelgationId the primary key of the current e s f national delegation
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f national delegation
	* @throws it.ethica.esf.NoSuchNationalDelegationException if a e s f national delegation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNationalDelegation[] findByUuid_C_PrevAndNext(
		long esfNationalDelgationId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalDelegationException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(esfNationalDelgationId, uuid,
			companyId, orderByComparator);
	}

	/**
	* Removes all the e s f national delegations where uuid = &#63; and companyId = &#63; from the database.
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
	* Returns the number of e s f national delegations where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching e s f national delegations
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the e s f national delegations where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @return the matching e s f national delegations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFNationalDelegation> findByESFUser(
		long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByESFUser(esfUserId);
	}

	/**
	* Returns a range of all the e s f national delegations where esfUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalDelegationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfUserId the esf user ID
	* @param start the lower bound of the range of e s f national delegations
	* @param end the upper bound of the range of e s f national delegations (not inclusive)
	* @return the range of matching e s f national delegations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFNationalDelegation> findByESFUser(
		long esfUserId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByESFUser(esfUserId, start, end);
	}

	/**
	* Returns an ordered range of all the e s f national delegations where esfUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalDelegationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfUserId the esf user ID
	* @param start the lower bound of the range of e s f national delegations
	* @param end the upper bound of the range of e s f national delegations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f national delegations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFNationalDelegation> findByESFUser(
		long esfUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByESFUser(esfUserId, start, end, orderByComparator);
	}

	/**
	* Returns the first e s f national delegation in the ordered set where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f national delegation
	* @throws it.ethica.esf.NoSuchNationalDelegationException if a matching e s f national delegation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNationalDelegation findByESFUser_First(
		long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalDelegationException {
		return getPersistence().findByESFUser_First(esfUserId, orderByComparator);
	}

	/**
	* Returns the first e s f national delegation in the ordered set where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f national delegation, or <code>null</code> if a matching e s f national delegation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNationalDelegation fetchByESFUser_First(
		long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByESFUser_First(esfUserId, orderByComparator);
	}

	/**
	* Returns the last e s f national delegation in the ordered set where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f national delegation
	* @throws it.ethica.esf.NoSuchNationalDelegationException if a matching e s f national delegation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNationalDelegation findByESFUser_Last(
		long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalDelegationException {
		return getPersistence().findByESFUser_Last(esfUserId, orderByComparator);
	}

	/**
	* Returns the last e s f national delegation in the ordered set where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f national delegation, or <code>null</code> if a matching e s f national delegation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNationalDelegation fetchByESFUser_Last(
		long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByESFUser_Last(esfUserId, orderByComparator);
	}

	/**
	* Returns the e s f national delegations before and after the current e s f national delegation in the ordered set where esfUserId = &#63;.
	*
	* @param esfNationalDelgationId the primary key of the current e s f national delegation
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f national delegation
	* @throws it.ethica.esf.NoSuchNationalDelegationException if a e s f national delegation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNationalDelegation[] findByESFUser_PrevAndNext(
		long esfNationalDelgationId, long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalDelegationException {
		return getPersistence()
				   .findByESFUser_PrevAndNext(esfNationalDelgationId,
			esfUserId, orderByComparator);
	}

	/**
	* Removes all the e s f national delegations where esfUserId = &#63; from the database.
	*
	* @param esfUserId the esf user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByESFUser(long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByESFUser(esfUserId);
	}

	/**
	* Returns the number of e s f national delegations where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @return the number of matching e s f national delegations
	* @throws SystemException if a system exception occurred
	*/
	public static int countByESFUser(long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByESFUser(esfUserId);
	}

	/**
	* Returns all the e s f national delegations where esfUserId = &#63; and leaveDate &gt; &#63;.
	*
	* @param esfUserId the esf user ID
	* @param leaveDate the leave date
	* @return the matching e s f national delegations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFNationalDelegation> findByU_L(
		long esfUserId, java.util.Date leaveDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByU_L(esfUserId, leaveDate);
	}

	/**
	* Returns a range of all the e s f national delegations where esfUserId = &#63; and leaveDate &gt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalDelegationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfUserId the esf user ID
	* @param leaveDate the leave date
	* @param start the lower bound of the range of e s f national delegations
	* @param end the upper bound of the range of e s f national delegations (not inclusive)
	* @return the range of matching e s f national delegations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFNationalDelegation> findByU_L(
		long esfUserId, java.util.Date leaveDate, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByU_L(esfUserId, leaveDate, start, end);
	}

	/**
	* Returns an ordered range of all the e s f national delegations where esfUserId = &#63; and leaveDate &gt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalDelegationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfUserId the esf user ID
	* @param leaveDate the leave date
	* @param start the lower bound of the range of e s f national delegations
	* @param end the upper bound of the range of e s f national delegations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f national delegations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFNationalDelegation> findByU_L(
		long esfUserId, java.util.Date leaveDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByU_L(esfUserId, leaveDate, start, end,
			orderByComparator);
	}

	/**
	* Returns the first e s f national delegation in the ordered set where esfUserId = &#63; and leaveDate &gt; &#63;.
	*
	* @param esfUserId the esf user ID
	* @param leaveDate the leave date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f national delegation
	* @throws it.ethica.esf.NoSuchNationalDelegationException if a matching e s f national delegation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNationalDelegation findByU_L_First(
		long esfUserId, java.util.Date leaveDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalDelegationException {
		return getPersistence()
				   .findByU_L_First(esfUserId, leaveDate, orderByComparator);
	}

	/**
	* Returns the first e s f national delegation in the ordered set where esfUserId = &#63; and leaveDate &gt; &#63;.
	*
	* @param esfUserId the esf user ID
	* @param leaveDate the leave date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f national delegation, or <code>null</code> if a matching e s f national delegation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNationalDelegation fetchByU_L_First(
		long esfUserId, java.util.Date leaveDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByU_L_First(esfUserId, leaveDate, orderByComparator);
	}

	/**
	* Returns the last e s f national delegation in the ordered set where esfUserId = &#63; and leaveDate &gt; &#63;.
	*
	* @param esfUserId the esf user ID
	* @param leaveDate the leave date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f national delegation
	* @throws it.ethica.esf.NoSuchNationalDelegationException if a matching e s f national delegation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNationalDelegation findByU_L_Last(
		long esfUserId, java.util.Date leaveDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalDelegationException {
		return getPersistence()
				   .findByU_L_Last(esfUserId, leaveDate, orderByComparator);
	}

	/**
	* Returns the last e s f national delegation in the ordered set where esfUserId = &#63; and leaveDate &gt; &#63;.
	*
	* @param esfUserId the esf user ID
	* @param leaveDate the leave date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f national delegation, or <code>null</code> if a matching e s f national delegation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNationalDelegation fetchByU_L_Last(
		long esfUserId, java.util.Date leaveDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByU_L_Last(esfUserId, leaveDate, orderByComparator);
	}

	/**
	* Returns the e s f national delegations before and after the current e s f national delegation in the ordered set where esfUserId = &#63; and leaveDate &gt; &#63;.
	*
	* @param esfNationalDelgationId the primary key of the current e s f national delegation
	* @param esfUserId the esf user ID
	* @param leaveDate the leave date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f national delegation
	* @throws it.ethica.esf.NoSuchNationalDelegationException if a e s f national delegation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNationalDelegation[] findByU_L_PrevAndNext(
		long esfNationalDelgationId, long esfUserId, java.util.Date leaveDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalDelegationException {
		return getPersistence()
				   .findByU_L_PrevAndNext(esfNationalDelgationId, esfUserId,
			leaveDate, orderByComparator);
	}

	/**
	* Removes all the e s f national delegations where esfUserId = &#63; and leaveDate &gt; &#63; from the database.
	*
	* @param esfUserId the esf user ID
	* @param leaveDate the leave date
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByU_L(long esfUserId, java.util.Date leaveDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByU_L(esfUserId, leaveDate);
	}

	/**
	* Returns the number of e s f national delegations where esfUserId = &#63; and leaveDate &gt; &#63;.
	*
	* @param esfUserId the esf user ID
	* @param leaveDate the leave date
	* @return the number of matching e s f national delegations
	* @throws SystemException if a system exception occurred
	*/
	public static int countByU_L(long esfUserId, java.util.Date leaveDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByU_L(esfUserId, leaveDate);
	}

	/**
	* Returns all the e s f national delegations where esfMatchId = &#63; and esfPartecipantTypeId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfPartecipantTypeId the esf partecipant type ID
	* @return the matching e s f national delegations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFNationalDelegation> findByESFMatchESFPartecipantType(
		long esfMatchId, long esfPartecipantTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByESFMatchESFPartecipantType(esfMatchId,
			esfPartecipantTypeId);
	}

	/**
	* Returns a range of all the e s f national delegations where esfMatchId = &#63; and esfPartecipantTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalDelegationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfMatchId the esf match ID
	* @param esfPartecipantTypeId the esf partecipant type ID
	* @param start the lower bound of the range of e s f national delegations
	* @param end the upper bound of the range of e s f national delegations (not inclusive)
	* @return the range of matching e s f national delegations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFNationalDelegation> findByESFMatchESFPartecipantType(
		long esfMatchId, long esfPartecipantTypeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByESFMatchESFPartecipantType(esfMatchId,
			esfPartecipantTypeId, start, end);
	}

	/**
	* Returns an ordered range of all the e s f national delegations where esfMatchId = &#63; and esfPartecipantTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalDelegationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfMatchId the esf match ID
	* @param esfPartecipantTypeId the esf partecipant type ID
	* @param start the lower bound of the range of e s f national delegations
	* @param end the upper bound of the range of e s f national delegations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f national delegations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFNationalDelegation> findByESFMatchESFPartecipantType(
		long esfMatchId, long esfPartecipantTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByESFMatchESFPartecipantType(esfMatchId,
			esfPartecipantTypeId, start, end, orderByComparator);
	}

	/**
	* Returns the first e s f national delegation in the ordered set where esfMatchId = &#63; and esfPartecipantTypeId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfPartecipantTypeId the esf partecipant type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f national delegation
	* @throws it.ethica.esf.NoSuchNationalDelegationException if a matching e s f national delegation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNationalDelegation findByESFMatchESFPartecipantType_First(
		long esfMatchId, long esfPartecipantTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalDelegationException {
		return getPersistence()
				   .findByESFMatchESFPartecipantType_First(esfMatchId,
			esfPartecipantTypeId, orderByComparator);
	}

	/**
	* Returns the first e s f national delegation in the ordered set where esfMatchId = &#63; and esfPartecipantTypeId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfPartecipantTypeId the esf partecipant type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f national delegation, or <code>null</code> if a matching e s f national delegation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNationalDelegation fetchByESFMatchESFPartecipantType_First(
		long esfMatchId, long esfPartecipantTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByESFMatchESFPartecipantType_First(esfMatchId,
			esfPartecipantTypeId, orderByComparator);
	}

	/**
	* Returns the last e s f national delegation in the ordered set where esfMatchId = &#63; and esfPartecipantTypeId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfPartecipantTypeId the esf partecipant type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f national delegation
	* @throws it.ethica.esf.NoSuchNationalDelegationException if a matching e s f national delegation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNationalDelegation findByESFMatchESFPartecipantType_Last(
		long esfMatchId, long esfPartecipantTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalDelegationException {
		return getPersistence()
				   .findByESFMatchESFPartecipantType_Last(esfMatchId,
			esfPartecipantTypeId, orderByComparator);
	}

	/**
	* Returns the last e s f national delegation in the ordered set where esfMatchId = &#63; and esfPartecipantTypeId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfPartecipantTypeId the esf partecipant type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f national delegation, or <code>null</code> if a matching e s f national delegation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNationalDelegation fetchByESFMatchESFPartecipantType_Last(
		long esfMatchId, long esfPartecipantTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByESFMatchESFPartecipantType_Last(esfMatchId,
			esfPartecipantTypeId, orderByComparator);
	}

	/**
	* Returns the e s f national delegations before and after the current e s f national delegation in the ordered set where esfMatchId = &#63; and esfPartecipantTypeId = &#63;.
	*
	* @param esfNationalDelgationId the primary key of the current e s f national delegation
	* @param esfMatchId the esf match ID
	* @param esfPartecipantTypeId the esf partecipant type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f national delegation
	* @throws it.ethica.esf.NoSuchNationalDelegationException if a e s f national delegation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNationalDelegation[] findByESFMatchESFPartecipantType_PrevAndNext(
		long esfNationalDelgationId, long esfMatchId,
		long esfPartecipantTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalDelegationException {
		return getPersistence()
				   .findByESFMatchESFPartecipantType_PrevAndNext(esfNationalDelgationId,
			esfMatchId, esfPartecipantTypeId, orderByComparator);
	}

	/**
	* Removes all the e s f national delegations where esfMatchId = &#63; and esfPartecipantTypeId = &#63; from the database.
	*
	* @param esfMatchId the esf match ID
	* @param esfPartecipantTypeId the esf partecipant type ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByESFMatchESFPartecipantType(long esfMatchId,
		long esfPartecipantTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByESFMatchESFPartecipantType(esfMatchId, esfPartecipantTypeId);
	}

	/**
	* Returns the number of e s f national delegations where esfMatchId = &#63; and esfPartecipantTypeId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfPartecipantTypeId the esf partecipant type ID
	* @return the number of matching e s f national delegations
	* @throws SystemException if a system exception occurred
	*/
	public static int countByESFMatchESFPartecipantType(long esfMatchId,
		long esfPartecipantTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByESFMatchESFPartecipantType(esfMatchId,
			esfPartecipantTypeId);
	}

	/**
	* Returns all the e s f national delegations where esfUserId = &#63; and esfMatchId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param esfMatchId the esf match ID
	* @return the matching e s f national delegations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFNationalDelegation> findByESFMatch_U(
		long esfUserId, long esfMatchId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByESFMatch_U(esfUserId, esfMatchId);
	}

	/**
	* Returns a range of all the e s f national delegations where esfUserId = &#63; and esfMatchId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalDelegationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfUserId the esf user ID
	* @param esfMatchId the esf match ID
	* @param start the lower bound of the range of e s f national delegations
	* @param end the upper bound of the range of e s f national delegations (not inclusive)
	* @return the range of matching e s f national delegations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFNationalDelegation> findByESFMatch_U(
		long esfUserId, long esfMatchId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByESFMatch_U(esfUserId, esfMatchId, start, end);
	}

	/**
	* Returns an ordered range of all the e s f national delegations where esfUserId = &#63; and esfMatchId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalDelegationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfUserId the esf user ID
	* @param esfMatchId the esf match ID
	* @param start the lower bound of the range of e s f national delegations
	* @param end the upper bound of the range of e s f national delegations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f national delegations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFNationalDelegation> findByESFMatch_U(
		long esfUserId, long esfMatchId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByESFMatch_U(esfUserId, esfMatchId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first e s f national delegation in the ordered set where esfUserId = &#63; and esfMatchId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param esfMatchId the esf match ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f national delegation
	* @throws it.ethica.esf.NoSuchNationalDelegationException if a matching e s f national delegation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNationalDelegation findByESFMatch_U_First(
		long esfUserId, long esfMatchId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalDelegationException {
		return getPersistence()
				   .findByESFMatch_U_First(esfUserId, esfMatchId,
			orderByComparator);
	}

	/**
	* Returns the first e s f national delegation in the ordered set where esfUserId = &#63; and esfMatchId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param esfMatchId the esf match ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f national delegation, or <code>null</code> if a matching e s f national delegation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNationalDelegation fetchByESFMatch_U_First(
		long esfUserId, long esfMatchId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByESFMatch_U_First(esfUserId, esfMatchId,
			orderByComparator);
	}

	/**
	* Returns the last e s f national delegation in the ordered set where esfUserId = &#63; and esfMatchId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param esfMatchId the esf match ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f national delegation
	* @throws it.ethica.esf.NoSuchNationalDelegationException if a matching e s f national delegation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNationalDelegation findByESFMatch_U_Last(
		long esfUserId, long esfMatchId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalDelegationException {
		return getPersistence()
				   .findByESFMatch_U_Last(esfUserId, esfMatchId,
			orderByComparator);
	}

	/**
	* Returns the last e s f national delegation in the ordered set where esfUserId = &#63; and esfMatchId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param esfMatchId the esf match ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f national delegation, or <code>null</code> if a matching e s f national delegation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNationalDelegation fetchByESFMatch_U_Last(
		long esfUserId, long esfMatchId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByESFMatch_U_Last(esfUserId, esfMatchId,
			orderByComparator);
	}

	/**
	* Returns the e s f national delegations before and after the current e s f national delegation in the ordered set where esfUserId = &#63; and esfMatchId = &#63;.
	*
	* @param esfNationalDelgationId the primary key of the current e s f national delegation
	* @param esfUserId the esf user ID
	* @param esfMatchId the esf match ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f national delegation
	* @throws it.ethica.esf.NoSuchNationalDelegationException if a e s f national delegation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNationalDelegation[] findByESFMatch_U_PrevAndNext(
		long esfNationalDelgationId, long esfUserId, long esfMatchId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalDelegationException {
		return getPersistence()
				   .findByESFMatch_U_PrevAndNext(esfNationalDelgationId,
			esfUserId, esfMatchId, orderByComparator);
	}

	/**
	* Removes all the e s f national delegations where esfUserId = &#63; and esfMatchId = &#63; from the database.
	*
	* @param esfUserId the esf user ID
	* @param esfMatchId the esf match ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByESFMatch_U(long esfUserId, long esfMatchId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByESFMatch_U(esfUserId, esfMatchId);
	}

	/**
	* Returns the number of e s f national delegations where esfUserId = &#63; and esfMatchId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param esfMatchId the esf match ID
	* @return the number of matching e s f national delegations
	* @throws SystemException if a system exception occurred
	*/
	public static int countByESFMatch_U(long esfUserId, long esfMatchId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByESFMatch_U(esfUserId, esfMatchId);
	}

	/**
	* Returns all the e s f national delegations where esfUserId = &#63; and esfMatchId = &#63; and esfPartecipantTypeId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param esfMatchId the esf match ID
	* @param esfPartecipantTypeId the esf partecipant type ID
	* @return the matching e s f national delegations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFNationalDelegation> findByESFMatch_U_T(
		long esfUserId, long esfMatchId, long esfPartecipantTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByESFMatch_U_T(esfUserId, esfMatchId,
			esfPartecipantTypeId);
	}

	/**
	* Returns a range of all the e s f national delegations where esfUserId = &#63; and esfMatchId = &#63; and esfPartecipantTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalDelegationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfUserId the esf user ID
	* @param esfMatchId the esf match ID
	* @param esfPartecipantTypeId the esf partecipant type ID
	* @param start the lower bound of the range of e s f national delegations
	* @param end the upper bound of the range of e s f national delegations (not inclusive)
	* @return the range of matching e s f national delegations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFNationalDelegation> findByESFMatch_U_T(
		long esfUserId, long esfMatchId, long esfPartecipantTypeId, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByESFMatch_U_T(esfUserId, esfMatchId,
			esfPartecipantTypeId, start, end);
	}

	/**
	* Returns an ordered range of all the e s f national delegations where esfUserId = &#63; and esfMatchId = &#63; and esfPartecipantTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalDelegationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfUserId the esf user ID
	* @param esfMatchId the esf match ID
	* @param esfPartecipantTypeId the esf partecipant type ID
	* @param start the lower bound of the range of e s f national delegations
	* @param end the upper bound of the range of e s f national delegations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f national delegations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFNationalDelegation> findByESFMatch_U_T(
		long esfUserId, long esfMatchId, long esfPartecipantTypeId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByESFMatch_U_T(esfUserId, esfMatchId,
			esfPartecipantTypeId, start, end, orderByComparator);
	}

	/**
	* Returns the first e s f national delegation in the ordered set where esfUserId = &#63; and esfMatchId = &#63; and esfPartecipantTypeId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param esfMatchId the esf match ID
	* @param esfPartecipantTypeId the esf partecipant type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f national delegation
	* @throws it.ethica.esf.NoSuchNationalDelegationException if a matching e s f national delegation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNationalDelegation findByESFMatch_U_T_First(
		long esfUserId, long esfMatchId, long esfPartecipantTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalDelegationException {
		return getPersistence()
				   .findByESFMatch_U_T_First(esfUserId, esfMatchId,
			esfPartecipantTypeId, orderByComparator);
	}

	/**
	* Returns the first e s f national delegation in the ordered set where esfUserId = &#63; and esfMatchId = &#63; and esfPartecipantTypeId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param esfMatchId the esf match ID
	* @param esfPartecipantTypeId the esf partecipant type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f national delegation, or <code>null</code> if a matching e s f national delegation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNationalDelegation fetchByESFMatch_U_T_First(
		long esfUserId, long esfMatchId, long esfPartecipantTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByESFMatch_U_T_First(esfUserId, esfMatchId,
			esfPartecipantTypeId, orderByComparator);
	}

	/**
	* Returns the last e s f national delegation in the ordered set where esfUserId = &#63; and esfMatchId = &#63; and esfPartecipantTypeId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param esfMatchId the esf match ID
	* @param esfPartecipantTypeId the esf partecipant type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f national delegation
	* @throws it.ethica.esf.NoSuchNationalDelegationException if a matching e s f national delegation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNationalDelegation findByESFMatch_U_T_Last(
		long esfUserId, long esfMatchId, long esfPartecipantTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalDelegationException {
		return getPersistence()
				   .findByESFMatch_U_T_Last(esfUserId, esfMatchId,
			esfPartecipantTypeId, orderByComparator);
	}

	/**
	* Returns the last e s f national delegation in the ordered set where esfUserId = &#63; and esfMatchId = &#63; and esfPartecipantTypeId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param esfMatchId the esf match ID
	* @param esfPartecipantTypeId the esf partecipant type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f national delegation, or <code>null</code> if a matching e s f national delegation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNationalDelegation fetchByESFMatch_U_T_Last(
		long esfUserId, long esfMatchId, long esfPartecipantTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByESFMatch_U_T_Last(esfUserId, esfMatchId,
			esfPartecipantTypeId, orderByComparator);
	}

	/**
	* Returns the e s f national delegations before and after the current e s f national delegation in the ordered set where esfUserId = &#63; and esfMatchId = &#63; and esfPartecipantTypeId = &#63;.
	*
	* @param esfNationalDelgationId the primary key of the current e s f national delegation
	* @param esfUserId the esf user ID
	* @param esfMatchId the esf match ID
	* @param esfPartecipantTypeId the esf partecipant type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f national delegation
	* @throws it.ethica.esf.NoSuchNationalDelegationException if a e s f national delegation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNationalDelegation[] findByESFMatch_U_T_PrevAndNext(
		long esfNationalDelgationId, long esfUserId, long esfMatchId,
		long esfPartecipantTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalDelegationException {
		return getPersistence()
				   .findByESFMatch_U_T_PrevAndNext(esfNationalDelgationId,
			esfUserId, esfMatchId, esfPartecipantTypeId, orderByComparator);
	}

	/**
	* Removes all the e s f national delegations where esfUserId = &#63; and esfMatchId = &#63; and esfPartecipantTypeId = &#63; from the database.
	*
	* @param esfUserId the esf user ID
	* @param esfMatchId the esf match ID
	* @param esfPartecipantTypeId the esf partecipant type ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByESFMatch_U_T(long esfUserId, long esfMatchId,
		long esfPartecipantTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByESFMatch_U_T(esfUserId, esfMatchId, esfPartecipantTypeId);
	}

	/**
	* Returns the number of e s f national delegations where esfUserId = &#63; and esfMatchId = &#63; and esfPartecipantTypeId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param esfMatchId the esf match ID
	* @param esfPartecipantTypeId the esf partecipant type ID
	* @return the number of matching e s f national delegations
	* @throws SystemException if a system exception occurred
	*/
	public static int countByESFMatch_U_T(long esfUserId, long esfMatchId,
		long esfPartecipantTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByESFMatch_U_T(esfUserId, esfMatchId,
			esfPartecipantTypeId);
	}

	/**
	* Returns all the e s f national delegations where esfMatchId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @return the matching e s f national delegations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFNationalDelegation> findByESFMatch(
		long esfMatchId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByESFMatch(esfMatchId);
	}

	/**
	* Returns a range of all the e s f national delegations where esfMatchId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalDelegationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfMatchId the esf match ID
	* @param start the lower bound of the range of e s f national delegations
	* @param end the upper bound of the range of e s f national delegations (not inclusive)
	* @return the range of matching e s f national delegations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFNationalDelegation> findByESFMatch(
		long esfMatchId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByESFMatch(esfMatchId, start, end);
	}

	/**
	* Returns an ordered range of all the e s f national delegations where esfMatchId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalDelegationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfMatchId the esf match ID
	* @param start the lower bound of the range of e s f national delegations
	* @param end the upper bound of the range of e s f national delegations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f national delegations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFNationalDelegation> findByESFMatch(
		long esfMatchId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByESFMatch(esfMatchId, start, end, orderByComparator);
	}

	/**
	* Returns the first e s f national delegation in the ordered set where esfMatchId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f national delegation
	* @throws it.ethica.esf.NoSuchNationalDelegationException if a matching e s f national delegation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNationalDelegation findByESFMatch_First(
		long esfMatchId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalDelegationException {
		return getPersistence()
				   .findByESFMatch_First(esfMatchId, orderByComparator);
	}

	/**
	* Returns the first e s f national delegation in the ordered set where esfMatchId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f national delegation, or <code>null</code> if a matching e s f national delegation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNationalDelegation fetchByESFMatch_First(
		long esfMatchId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByESFMatch_First(esfMatchId, orderByComparator);
	}

	/**
	* Returns the last e s f national delegation in the ordered set where esfMatchId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f national delegation
	* @throws it.ethica.esf.NoSuchNationalDelegationException if a matching e s f national delegation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNationalDelegation findByESFMatch_Last(
		long esfMatchId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalDelegationException {
		return getPersistence()
				   .findByESFMatch_Last(esfMatchId, orderByComparator);
	}

	/**
	* Returns the last e s f national delegation in the ordered set where esfMatchId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f national delegation, or <code>null</code> if a matching e s f national delegation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNationalDelegation fetchByESFMatch_Last(
		long esfMatchId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByESFMatch_Last(esfMatchId, orderByComparator);
	}

	/**
	* Returns the e s f national delegations before and after the current e s f national delegation in the ordered set where esfMatchId = &#63;.
	*
	* @param esfNationalDelgationId the primary key of the current e s f national delegation
	* @param esfMatchId the esf match ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f national delegation
	* @throws it.ethica.esf.NoSuchNationalDelegationException if a e s f national delegation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNationalDelegation[] findByESFMatch_PrevAndNext(
		long esfNationalDelgationId, long esfMatchId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalDelegationException {
		return getPersistence()
				   .findByESFMatch_PrevAndNext(esfNationalDelgationId,
			esfMatchId, orderByComparator);
	}

	/**
	* Removes all the e s f national delegations where esfMatchId = &#63; from the database.
	*
	* @param esfMatchId the esf match ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByESFMatch(long esfMatchId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByESFMatch(esfMatchId);
	}

	/**
	* Returns the number of e s f national delegations where esfMatchId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @return the number of matching e s f national delegations
	* @throws SystemException if a system exception occurred
	*/
	public static int countByESFMatch(long esfMatchId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByESFMatch(esfMatchId);
	}

	/**
	* Returns all the e s f national delegations where esfUserId = &#63; and esfPartecipantTypeId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param esfPartecipantTypeId the esf partecipant type ID
	* @return the matching e s f national delegations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFNationalDelegation> findByPartecipantType_EsfUserId(
		long esfUserId, long esfPartecipantTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPartecipantType_EsfUserId(esfUserId,
			esfPartecipantTypeId);
	}

	/**
	* Returns a range of all the e s f national delegations where esfUserId = &#63; and esfPartecipantTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalDelegationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfUserId the esf user ID
	* @param esfPartecipantTypeId the esf partecipant type ID
	* @param start the lower bound of the range of e s f national delegations
	* @param end the upper bound of the range of e s f national delegations (not inclusive)
	* @return the range of matching e s f national delegations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFNationalDelegation> findByPartecipantType_EsfUserId(
		long esfUserId, long esfPartecipantTypeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPartecipantType_EsfUserId(esfUserId,
			esfPartecipantTypeId, start, end);
	}

	/**
	* Returns an ordered range of all the e s f national delegations where esfUserId = &#63; and esfPartecipantTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalDelegationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfUserId the esf user ID
	* @param esfPartecipantTypeId the esf partecipant type ID
	* @param start the lower bound of the range of e s f national delegations
	* @param end the upper bound of the range of e s f national delegations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f national delegations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFNationalDelegation> findByPartecipantType_EsfUserId(
		long esfUserId, long esfPartecipantTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPartecipantType_EsfUserId(esfUserId,
			esfPartecipantTypeId, start, end, orderByComparator);
	}

	/**
	* Returns the first e s f national delegation in the ordered set where esfUserId = &#63; and esfPartecipantTypeId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param esfPartecipantTypeId the esf partecipant type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f national delegation
	* @throws it.ethica.esf.NoSuchNationalDelegationException if a matching e s f national delegation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNationalDelegation findByPartecipantType_EsfUserId_First(
		long esfUserId, long esfPartecipantTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalDelegationException {
		return getPersistence()
				   .findByPartecipantType_EsfUserId_First(esfUserId,
			esfPartecipantTypeId, orderByComparator);
	}

	/**
	* Returns the first e s f national delegation in the ordered set where esfUserId = &#63; and esfPartecipantTypeId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param esfPartecipantTypeId the esf partecipant type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f national delegation, or <code>null</code> if a matching e s f national delegation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNationalDelegation fetchByPartecipantType_EsfUserId_First(
		long esfUserId, long esfPartecipantTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPartecipantType_EsfUserId_First(esfUserId,
			esfPartecipantTypeId, orderByComparator);
	}

	/**
	* Returns the last e s f national delegation in the ordered set where esfUserId = &#63; and esfPartecipantTypeId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param esfPartecipantTypeId the esf partecipant type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f national delegation
	* @throws it.ethica.esf.NoSuchNationalDelegationException if a matching e s f national delegation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNationalDelegation findByPartecipantType_EsfUserId_Last(
		long esfUserId, long esfPartecipantTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalDelegationException {
		return getPersistence()
				   .findByPartecipantType_EsfUserId_Last(esfUserId,
			esfPartecipantTypeId, orderByComparator);
	}

	/**
	* Returns the last e s f national delegation in the ordered set where esfUserId = &#63; and esfPartecipantTypeId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param esfPartecipantTypeId the esf partecipant type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f national delegation, or <code>null</code> if a matching e s f national delegation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNationalDelegation fetchByPartecipantType_EsfUserId_Last(
		long esfUserId, long esfPartecipantTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPartecipantType_EsfUserId_Last(esfUserId,
			esfPartecipantTypeId, orderByComparator);
	}

	/**
	* Returns the e s f national delegations before and after the current e s f national delegation in the ordered set where esfUserId = &#63; and esfPartecipantTypeId = &#63;.
	*
	* @param esfNationalDelgationId the primary key of the current e s f national delegation
	* @param esfUserId the esf user ID
	* @param esfPartecipantTypeId the esf partecipant type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f national delegation
	* @throws it.ethica.esf.NoSuchNationalDelegationException if a e s f national delegation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNationalDelegation[] findByPartecipantType_EsfUserId_PrevAndNext(
		long esfNationalDelgationId, long esfUserId, long esfPartecipantTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalDelegationException {
		return getPersistence()
				   .findByPartecipantType_EsfUserId_PrevAndNext(esfNationalDelgationId,
			esfUserId, esfPartecipantTypeId, orderByComparator);
	}

	/**
	* Removes all the e s f national delegations where esfUserId = &#63; and esfPartecipantTypeId = &#63; from the database.
	*
	* @param esfUserId the esf user ID
	* @param esfPartecipantTypeId the esf partecipant type ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByPartecipantType_EsfUserId(long esfUserId,
		long esfPartecipantTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByPartecipantType_EsfUserId(esfUserId, esfPartecipantTypeId);
	}

	/**
	* Returns the number of e s f national delegations where esfUserId = &#63; and esfPartecipantTypeId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param esfPartecipantTypeId the esf partecipant type ID
	* @return the number of matching e s f national delegations
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPartecipantType_EsfUserId(long esfUserId,
		long esfPartecipantTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByPartecipantType_EsfUserId(esfUserId,
			esfPartecipantTypeId);
	}

	/**
	* Returns all the e s f national delegations where esfSportTypeId = &#63; and esfMatchId = &#63; and esfPartecipantTypeId = &#63;.
	*
	* @param esfSportTypeId the esf sport type ID
	* @param esfMatchId the esf match ID
	* @param esfPartecipantTypeId the esf partecipant type ID
	* @return the matching e s f national delegations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFNationalDelegation> findByPartecipantType_MatchId_SportTypeId(
		long esfSportTypeId, long esfMatchId, long esfPartecipantTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPartecipantType_MatchId_SportTypeId(esfSportTypeId,
			esfMatchId, esfPartecipantTypeId);
	}

	/**
	* Returns a range of all the e s f national delegations where esfSportTypeId = &#63; and esfMatchId = &#63; and esfPartecipantTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalDelegationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfSportTypeId the esf sport type ID
	* @param esfMatchId the esf match ID
	* @param esfPartecipantTypeId the esf partecipant type ID
	* @param start the lower bound of the range of e s f national delegations
	* @param end the upper bound of the range of e s f national delegations (not inclusive)
	* @return the range of matching e s f national delegations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFNationalDelegation> findByPartecipantType_MatchId_SportTypeId(
		long esfSportTypeId, long esfMatchId, long esfPartecipantTypeId,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPartecipantType_MatchId_SportTypeId(esfSportTypeId,
			esfMatchId, esfPartecipantTypeId, start, end);
	}

	/**
	* Returns an ordered range of all the e s f national delegations where esfSportTypeId = &#63; and esfMatchId = &#63; and esfPartecipantTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalDelegationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfSportTypeId the esf sport type ID
	* @param esfMatchId the esf match ID
	* @param esfPartecipantTypeId the esf partecipant type ID
	* @param start the lower bound of the range of e s f national delegations
	* @param end the upper bound of the range of e s f national delegations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f national delegations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFNationalDelegation> findByPartecipantType_MatchId_SportTypeId(
		long esfSportTypeId, long esfMatchId, long esfPartecipantTypeId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPartecipantType_MatchId_SportTypeId(esfSportTypeId,
			esfMatchId, esfPartecipantTypeId, start, end, orderByComparator);
	}

	/**
	* Returns the first e s f national delegation in the ordered set where esfSportTypeId = &#63; and esfMatchId = &#63; and esfPartecipantTypeId = &#63;.
	*
	* @param esfSportTypeId the esf sport type ID
	* @param esfMatchId the esf match ID
	* @param esfPartecipantTypeId the esf partecipant type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f national delegation
	* @throws it.ethica.esf.NoSuchNationalDelegationException if a matching e s f national delegation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNationalDelegation findByPartecipantType_MatchId_SportTypeId_First(
		long esfSportTypeId, long esfMatchId, long esfPartecipantTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalDelegationException {
		return getPersistence()
				   .findByPartecipantType_MatchId_SportTypeId_First(esfSportTypeId,
			esfMatchId, esfPartecipantTypeId, orderByComparator);
	}

	/**
	* Returns the first e s f national delegation in the ordered set where esfSportTypeId = &#63; and esfMatchId = &#63; and esfPartecipantTypeId = &#63;.
	*
	* @param esfSportTypeId the esf sport type ID
	* @param esfMatchId the esf match ID
	* @param esfPartecipantTypeId the esf partecipant type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f national delegation, or <code>null</code> if a matching e s f national delegation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNationalDelegation fetchByPartecipantType_MatchId_SportTypeId_First(
		long esfSportTypeId, long esfMatchId, long esfPartecipantTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPartecipantType_MatchId_SportTypeId_First(esfSportTypeId,
			esfMatchId, esfPartecipantTypeId, orderByComparator);
	}

	/**
	* Returns the last e s f national delegation in the ordered set where esfSportTypeId = &#63; and esfMatchId = &#63; and esfPartecipantTypeId = &#63;.
	*
	* @param esfSportTypeId the esf sport type ID
	* @param esfMatchId the esf match ID
	* @param esfPartecipantTypeId the esf partecipant type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f national delegation
	* @throws it.ethica.esf.NoSuchNationalDelegationException if a matching e s f national delegation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNationalDelegation findByPartecipantType_MatchId_SportTypeId_Last(
		long esfSportTypeId, long esfMatchId, long esfPartecipantTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalDelegationException {
		return getPersistence()
				   .findByPartecipantType_MatchId_SportTypeId_Last(esfSportTypeId,
			esfMatchId, esfPartecipantTypeId, orderByComparator);
	}

	/**
	* Returns the last e s f national delegation in the ordered set where esfSportTypeId = &#63; and esfMatchId = &#63; and esfPartecipantTypeId = &#63;.
	*
	* @param esfSportTypeId the esf sport type ID
	* @param esfMatchId the esf match ID
	* @param esfPartecipantTypeId the esf partecipant type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f national delegation, or <code>null</code> if a matching e s f national delegation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNationalDelegation fetchByPartecipantType_MatchId_SportTypeId_Last(
		long esfSportTypeId, long esfMatchId, long esfPartecipantTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPartecipantType_MatchId_SportTypeId_Last(esfSportTypeId,
			esfMatchId, esfPartecipantTypeId, orderByComparator);
	}

	/**
	* Returns the e s f national delegations before and after the current e s f national delegation in the ordered set where esfSportTypeId = &#63; and esfMatchId = &#63; and esfPartecipantTypeId = &#63;.
	*
	* @param esfNationalDelgationId the primary key of the current e s f national delegation
	* @param esfSportTypeId the esf sport type ID
	* @param esfMatchId the esf match ID
	* @param esfPartecipantTypeId the esf partecipant type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f national delegation
	* @throws it.ethica.esf.NoSuchNationalDelegationException if a e s f national delegation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNationalDelegation[] findByPartecipantType_MatchId_SportTypeId_PrevAndNext(
		long esfNationalDelgationId, long esfSportTypeId, long esfMatchId,
		long esfPartecipantTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalDelegationException {
		return getPersistence()
				   .findByPartecipantType_MatchId_SportTypeId_PrevAndNext(esfNationalDelgationId,
			esfSportTypeId, esfMatchId, esfPartecipantTypeId, orderByComparator);
	}

	/**
	* Removes all the e s f national delegations where esfSportTypeId = &#63; and esfMatchId = &#63; and esfPartecipantTypeId = &#63; from the database.
	*
	* @param esfSportTypeId the esf sport type ID
	* @param esfMatchId the esf match ID
	* @param esfPartecipantTypeId the esf partecipant type ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByPartecipantType_MatchId_SportTypeId(
		long esfSportTypeId, long esfMatchId, long esfPartecipantTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByPartecipantType_MatchId_SportTypeId(esfSportTypeId,
			esfMatchId, esfPartecipantTypeId);
	}

	/**
	* Returns the number of e s f national delegations where esfSportTypeId = &#63; and esfMatchId = &#63; and esfPartecipantTypeId = &#63;.
	*
	* @param esfSportTypeId the esf sport type ID
	* @param esfMatchId the esf match ID
	* @param esfPartecipantTypeId the esf partecipant type ID
	* @return the number of matching e s f national delegations
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPartecipantType_MatchId_SportTypeId(
		long esfSportTypeId, long esfMatchId, long esfPartecipantTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByPartecipantType_MatchId_SportTypeId(esfSportTypeId,
			esfMatchId, esfPartecipantTypeId);
	}

	/**
	* Returns all the e s f national delegations where esfMatchId = &#63; and esfSportTypeId = &#63; and esfShooterQualificationId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfSportTypeId the esf sport type ID
	* @param esfShooterQualificationId the esf shooter qualification ID
	* @return the matching e s f national delegations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFNationalDelegation> findByMatchId_SportTypeId_QualificationId(
		long esfMatchId, long esfSportTypeId, long esfShooterQualificationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMatchId_SportTypeId_QualificationId(esfMatchId,
			esfSportTypeId, esfShooterQualificationId);
	}

	/**
	* Returns a range of all the e s f national delegations where esfMatchId = &#63; and esfSportTypeId = &#63; and esfShooterQualificationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalDelegationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfMatchId the esf match ID
	* @param esfSportTypeId the esf sport type ID
	* @param esfShooterQualificationId the esf shooter qualification ID
	* @param start the lower bound of the range of e s f national delegations
	* @param end the upper bound of the range of e s f national delegations (not inclusive)
	* @return the range of matching e s f national delegations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFNationalDelegation> findByMatchId_SportTypeId_QualificationId(
		long esfMatchId, long esfSportTypeId, long esfShooterQualificationId,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMatchId_SportTypeId_QualificationId(esfMatchId,
			esfSportTypeId, esfShooterQualificationId, start, end);
	}

	/**
	* Returns an ordered range of all the e s f national delegations where esfMatchId = &#63; and esfSportTypeId = &#63; and esfShooterQualificationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalDelegationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfMatchId the esf match ID
	* @param esfSportTypeId the esf sport type ID
	* @param esfShooterQualificationId the esf shooter qualification ID
	* @param start the lower bound of the range of e s f national delegations
	* @param end the upper bound of the range of e s f national delegations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f national delegations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFNationalDelegation> findByMatchId_SportTypeId_QualificationId(
		long esfMatchId, long esfSportTypeId, long esfShooterQualificationId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMatchId_SportTypeId_QualificationId(esfMatchId,
			esfSportTypeId, esfShooterQualificationId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first e s f national delegation in the ordered set where esfMatchId = &#63; and esfSportTypeId = &#63; and esfShooterQualificationId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfSportTypeId the esf sport type ID
	* @param esfShooterQualificationId the esf shooter qualification ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f national delegation
	* @throws it.ethica.esf.NoSuchNationalDelegationException if a matching e s f national delegation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNationalDelegation findByMatchId_SportTypeId_QualificationId_First(
		long esfMatchId, long esfSportTypeId, long esfShooterQualificationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalDelegationException {
		return getPersistence()
				   .findByMatchId_SportTypeId_QualificationId_First(esfMatchId,
			esfSportTypeId, esfShooterQualificationId, orderByComparator);
	}

	/**
	* Returns the first e s f national delegation in the ordered set where esfMatchId = &#63; and esfSportTypeId = &#63; and esfShooterQualificationId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfSportTypeId the esf sport type ID
	* @param esfShooterQualificationId the esf shooter qualification ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f national delegation, or <code>null</code> if a matching e s f national delegation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNationalDelegation fetchByMatchId_SportTypeId_QualificationId_First(
		long esfMatchId, long esfSportTypeId, long esfShooterQualificationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByMatchId_SportTypeId_QualificationId_First(esfMatchId,
			esfSportTypeId, esfShooterQualificationId, orderByComparator);
	}

	/**
	* Returns the last e s f national delegation in the ordered set where esfMatchId = &#63; and esfSportTypeId = &#63; and esfShooterQualificationId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfSportTypeId the esf sport type ID
	* @param esfShooterQualificationId the esf shooter qualification ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f national delegation
	* @throws it.ethica.esf.NoSuchNationalDelegationException if a matching e s f national delegation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNationalDelegation findByMatchId_SportTypeId_QualificationId_Last(
		long esfMatchId, long esfSportTypeId, long esfShooterQualificationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalDelegationException {
		return getPersistence()
				   .findByMatchId_SportTypeId_QualificationId_Last(esfMatchId,
			esfSportTypeId, esfShooterQualificationId, orderByComparator);
	}

	/**
	* Returns the last e s f national delegation in the ordered set where esfMatchId = &#63; and esfSportTypeId = &#63; and esfShooterQualificationId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfSportTypeId the esf sport type ID
	* @param esfShooterQualificationId the esf shooter qualification ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f national delegation, or <code>null</code> if a matching e s f national delegation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNationalDelegation fetchByMatchId_SportTypeId_QualificationId_Last(
		long esfMatchId, long esfSportTypeId, long esfShooterQualificationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByMatchId_SportTypeId_QualificationId_Last(esfMatchId,
			esfSportTypeId, esfShooterQualificationId, orderByComparator);
	}

	/**
	* Returns the e s f national delegations before and after the current e s f national delegation in the ordered set where esfMatchId = &#63; and esfSportTypeId = &#63; and esfShooterQualificationId = &#63;.
	*
	* @param esfNationalDelgationId the primary key of the current e s f national delegation
	* @param esfMatchId the esf match ID
	* @param esfSportTypeId the esf sport type ID
	* @param esfShooterQualificationId the esf shooter qualification ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f national delegation
	* @throws it.ethica.esf.NoSuchNationalDelegationException if a e s f national delegation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNationalDelegation[] findByMatchId_SportTypeId_QualificationId_PrevAndNext(
		long esfNationalDelgationId, long esfMatchId, long esfSportTypeId,
		long esfShooterQualificationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalDelegationException {
		return getPersistence()
				   .findByMatchId_SportTypeId_QualificationId_PrevAndNext(esfNationalDelgationId,
			esfMatchId, esfSportTypeId, esfShooterQualificationId,
			orderByComparator);
	}

	/**
	* Removes all the e s f national delegations where esfMatchId = &#63; and esfSportTypeId = &#63; and esfShooterQualificationId = &#63; from the database.
	*
	* @param esfMatchId the esf match ID
	* @param esfSportTypeId the esf sport type ID
	* @param esfShooterQualificationId the esf shooter qualification ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByMatchId_SportTypeId_QualificationId(
		long esfMatchId, long esfSportTypeId, long esfShooterQualificationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByMatchId_SportTypeId_QualificationId(esfMatchId,
			esfSportTypeId, esfShooterQualificationId);
	}

	/**
	* Returns the number of e s f national delegations where esfMatchId = &#63; and esfSportTypeId = &#63; and esfShooterQualificationId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfSportTypeId the esf sport type ID
	* @param esfShooterQualificationId the esf shooter qualification ID
	* @return the number of matching e s f national delegations
	* @throws SystemException if a system exception occurred
	*/
	public static int countByMatchId_SportTypeId_QualificationId(
		long esfMatchId, long esfSportTypeId, long esfShooterQualificationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByMatchId_SportTypeId_QualificationId(esfMatchId,
			esfSportTypeId, esfShooterQualificationId);
	}

	/**
	* Returns the e s f national delegation where esfMatchId = &#63; and esfUserId = &#63; and esfSportTypeId = &#63; and esfShooterQualificationId = &#63; or throws a {@link it.ethica.esf.NoSuchNationalDelegationException} if it could not be found.
	*
	* @param esfMatchId the esf match ID
	* @param esfUserId the esf user ID
	* @param esfSportTypeId the esf sport type ID
	* @param esfShooterQualificationId the esf shooter qualification ID
	* @return the matching e s f national delegation
	* @throws it.ethica.esf.NoSuchNationalDelegationException if a matching e s f national delegation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNationalDelegation findByMatchId_UserId_SportTypeId_QualificationId(
		long esfMatchId, long esfUserId, long esfSportTypeId,
		long esfShooterQualificationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalDelegationException {
		return getPersistence()
				   .findByMatchId_UserId_SportTypeId_QualificationId(esfMatchId,
			esfUserId, esfSportTypeId, esfShooterQualificationId);
	}

	/**
	* Returns the e s f national delegation where esfMatchId = &#63; and esfUserId = &#63; and esfSportTypeId = &#63; and esfShooterQualificationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param esfMatchId the esf match ID
	* @param esfUserId the esf user ID
	* @param esfSportTypeId the esf sport type ID
	* @param esfShooterQualificationId the esf shooter qualification ID
	* @return the matching e s f national delegation, or <code>null</code> if a matching e s f national delegation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNationalDelegation fetchByMatchId_UserId_SportTypeId_QualificationId(
		long esfMatchId, long esfUserId, long esfSportTypeId,
		long esfShooterQualificationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByMatchId_UserId_SportTypeId_QualificationId(esfMatchId,
			esfUserId, esfSportTypeId, esfShooterQualificationId);
	}

	/**
	* Returns the e s f national delegation where esfMatchId = &#63; and esfUserId = &#63; and esfSportTypeId = &#63; and esfShooterQualificationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param esfMatchId the esf match ID
	* @param esfUserId the esf user ID
	* @param esfSportTypeId the esf sport type ID
	* @param esfShooterQualificationId the esf shooter qualification ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching e s f national delegation, or <code>null</code> if a matching e s f national delegation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNationalDelegation fetchByMatchId_UserId_SportTypeId_QualificationId(
		long esfMatchId, long esfUserId, long esfSportTypeId,
		long esfShooterQualificationId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByMatchId_UserId_SportTypeId_QualificationId(esfMatchId,
			esfUserId, esfSportTypeId, esfShooterQualificationId,
			retrieveFromCache);
	}

	/**
	* Removes the e s f national delegation where esfMatchId = &#63; and esfUserId = &#63; and esfSportTypeId = &#63; and esfShooterQualificationId = &#63; from the database.
	*
	* @param esfMatchId the esf match ID
	* @param esfUserId the esf user ID
	* @param esfSportTypeId the esf sport type ID
	* @param esfShooterQualificationId the esf shooter qualification ID
	* @return the e s f national delegation that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNationalDelegation removeByMatchId_UserId_SportTypeId_QualificationId(
		long esfMatchId, long esfUserId, long esfSportTypeId,
		long esfShooterQualificationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalDelegationException {
		return getPersistence()
				   .removeByMatchId_UserId_SportTypeId_QualificationId(esfMatchId,
			esfUserId, esfSportTypeId, esfShooterQualificationId);
	}

	/**
	* Returns the number of e s f national delegations where esfMatchId = &#63; and esfUserId = &#63; and esfSportTypeId = &#63; and esfShooterQualificationId = &#63;.
	*
	* @param esfMatchId the esf match ID
	* @param esfUserId the esf user ID
	* @param esfSportTypeId the esf sport type ID
	* @param esfShooterQualificationId the esf shooter qualification ID
	* @return the number of matching e s f national delegations
	* @throws SystemException if a system exception occurred
	*/
	public static int countByMatchId_UserId_SportTypeId_QualificationId(
		long esfMatchId, long esfUserId, long esfSportTypeId,
		long esfShooterQualificationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByMatchId_UserId_SportTypeId_QualificationId(esfMatchId,
			esfUserId, esfSportTypeId, esfShooterQualificationId);
	}

	/**
	* Caches the e s f national delegation in the entity cache if it is enabled.
	*
	* @param esfNationalDelegation the e s f national delegation
	*/
	public static void cacheResult(
		it.ethica.esf.model.ESFNationalDelegation esfNationalDelegation) {
		getPersistence().cacheResult(esfNationalDelegation);
	}

	/**
	* Caches the e s f national delegations in the entity cache if it is enabled.
	*
	* @param esfNationalDelegations the e s f national delegations
	*/
	public static void cacheResult(
		java.util.List<it.ethica.esf.model.ESFNationalDelegation> esfNationalDelegations) {
		getPersistence().cacheResult(esfNationalDelegations);
	}

	/**
	* Creates a new e s f national delegation with the primary key. Does not add the e s f national delegation to the database.
	*
	* @param esfNationalDelgationId the primary key for the new e s f national delegation
	* @return the new e s f national delegation
	*/
	public static it.ethica.esf.model.ESFNationalDelegation create(
		long esfNationalDelgationId) {
		return getPersistence().create(esfNationalDelgationId);
	}

	/**
	* Removes the e s f national delegation with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfNationalDelgationId the primary key of the e s f national delegation
	* @return the e s f national delegation that was removed
	* @throws it.ethica.esf.NoSuchNationalDelegationException if a e s f national delegation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNationalDelegation remove(
		long esfNationalDelgationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalDelegationException {
		return getPersistence().remove(esfNationalDelgationId);
	}

	public static it.ethica.esf.model.ESFNationalDelegation updateImpl(
		it.ethica.esf.model.ESFNationalDelegation esfNationalDelegation)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(esfNationalDelegation);
	}

	/**
	* Returns the e s f national delegation with the primary key or throws a {@link it.ethica.esf.NoSuchNationalDelegationException} if it could not be found.
	*
	* @param esfNationalDelgationId the primary key of the e s f national delegation
	* @return the e s f national delegation
	* @throws it.ethica.esf.NoSuchNationalDelegationException if a e s f national delegation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNationalDelegation findByPrimaryKey(
		long esfNationalDelgationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalDelegationException {
		return getPersistence().findByPrimaryKey(esfNationalDelgationId);
	}

	/**
	* Returns the e s f national delegation with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param esfNationalDelgationId the primary key of the e s f national delegation
	* @return the e s f national delegation, or <code>null</code> if a e s f national delegation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNationalDelegation fetchByPrimaryKey(
		long esfNationalDelgationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(esfNationalDelgationId);
	}

	/**
	* Returns all the e s f national delegations.
	*
	* @return the e s f national delegations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFNationalDelegation> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the e s f national delegations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalDelegationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f national delegations
	* @param end the upper bound of the range of e s f national delegations (not inclusive)
	* @return the range of e s f national delegations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFNationalDelegation> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the e s f national delegations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalDelegationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f national delegations
	* @param end the upper bound of the range of e s f national delegations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of e s f national delegations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFNationalDelegation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the e s f national delegations from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of e s f national delegations.
	*
	* @return the number of e s f national delegations
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ESFNationalDelegationPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ESFNationalDelegationPersistence)PortletBeanLocatorUtil.locate(it.ethica.esf.service.ClpSerializer.getServletContextName(),
					ESFNationalDelegationPersistence.class.getName());

			ReferenceRegistry.registerReference(ESFNationalDelegationUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ESFNationalDelegationPersistence persistence) {
	}

	private static ESFNationalDelegationPersistence _persistence;
}