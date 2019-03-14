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

import it.ethica.esf.model.ESFOrganization;

import java.util.List;

/**
 * The persistence utility for the e s f organization service. This utility wraps {@link ESFOrganizationPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFOrganizationPersistence
 * @see ESFOrganizationPersistenceImpl
 * @generated
 */
public class ESFOrganizationUtil {
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
	public static void clearCache(ESFOrganization esfOrganization) {
		getPersistence().clearCache(esfOrganization);
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
	public static List<ESFOrganization> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ESFOrganization> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ESFOrganization> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ESFOrganization update(ESFOrganization esfOrganization)
		throws SystemException {
		return getPersistence().update(esfOrganization);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ESFOrganization update(ESFOrganization esfOrganization,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(esfOrganization, serviceContext);
	}

	/**
	* Returns all the e s f organizations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching e s f organizations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFOrganization> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the e s f organizations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFOrganizationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of e s f organizations
	* @param end the upper bound of the range of e s f organizations (not inclusive)
	* @return the range of matching e s f organizations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFOrganization> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the e s f organizations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFOrganizationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of e s f organizations
	* @param end the upper bound of the range of e s f organizations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f organizations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFOrganization> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns the first e s f organization in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f organization
	* @throws it.ethica.esf.NoSuchOrganizationException if a matching e s f organization could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFOrganization findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchOrganizationException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first e s f organization in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f organization, or <code>null</code> if a matching e s f organization could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFOrganization fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last e s f organization in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f organization
	* @throws it.ethica.esf.NoSuchOrganizationException if a matching e s f organization could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFOrganization findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchOrganizationException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last e s f organization in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f organization, or <code>null</code> if a matching e s f organization could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFOrganization fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the e s f organizations before and after the current e s f organization in the ordered set where uuid = &#63;.
	*
	* @param esfOrganizationId the primary key of the current e s f organization
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f organization
	* @throws it.ethica.esf.NoSuchOrganizationException if a e s f organization with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFOrganization[] findByUuid_PrevAndNext(
		long esfOrganizationId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchOrganizationException {
		return getPersistence()
				   .findByUuid_PrevAndNext(esfOrganizationId, uuid,
			orderByComparator);
	}

	/**
	* Removes all the e s f organizations where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of e s f organizations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching e s f organizations
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the e s f organization where uuid = &#63; and groupId = &#63; or throws a {@link it.ethica.esf.NoSuchOrganizationException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching e s f organization
	* @throws it.ethica.esf.NoSuchOrganizationException if a matching e s f organization could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFOrganization findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchOrganizationException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the e s f organization where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching e s f organization, or <code>null</code> if a matching e s f organization could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFOrganization fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the e s f organization where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching e s f organization, or <code>null</code> if a matching e s f organization could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFOrganization fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the e s f organization where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the e s f organization that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFOrganization removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchOrganizationException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of e s f organizations where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching e s f organizations
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the e s f organizations where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching e s f organizations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFOrganization> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	* Returns a range of all the e s f organizations where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFOrganizationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of e s f organizations
	* @param end the upper bound of the range of e s f organizations (not inclusive)
	* @return the range of matching e s f organizations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFOrganization> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the e s f organizations where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFOrganizationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of e s f organizations
	* @param end the upper bound of the range of e s f organizations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f organizations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFOrganization> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first e s f organization in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f organization
	* @throws it.ethica.esf.NoSuchOrganizationException if a matching e s f organization could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFOrganization findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchOrganizationException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the first e s f organization in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f organization, or <code>null</code> if a matching e s f organization could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFOrganization fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the last e s f organization in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f organization
	* @throws it.ethica.esf.NoSuchOrganizationException if a matching e s f organization could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFOrganization findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchOrganizationException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last e s f organization in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f organization, or <code>null</code> if a matching e s f organization could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFOrganization fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the e s f organizations before and after the current e s f organization in the ordered set where groupId = &#63;.
	*
	* @param esfOrganizationId the primary key of the current e s f organization
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f organization
	* @throws it.ethica.esf.NoSuchOrganizationException if a e s f organization with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFOrganization[] findByGroupId_PrevAndNext(
		long esfOrganizationId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchOrganizationException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(esfOrganizationId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the e s f organizations that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching e s f organizations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFOrganization> filterFindByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroupId(groupId);
	}

	/**
	* Returns a range of all the e s f organizations that the user has permission to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFOrganizationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of e s f organizations
	* @param end the upper bound of the range of e s f organizations (not inclusive)
	* @return the range of matching e s f organizations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFOrganization> filterFindByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroupId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the e s f organizations that the user has permissions to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFOrganizationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of e s f organizations
	* @param end the upper bound of the range of e s f organizations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f organizations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFOrganization> filterFindByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the e s f organizations before and after the current e s f organization in the ordered set of e s f organizations that the user has permission to view where groupId = &#63;.
	*
	* @param esfOrganizationId the primary key of the current e s f organization
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f organization
	* @throws it.ethica.esf.NoSuchOrganizationException if a e s f organization with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFOrganization[] filterFindByGroupId_PrevAndNext(
		long esfOrganizationId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchOrganizationException {
		return getPersistence()
				   .filterFindByGroupId_PrevAndNext(esfOrganizationId, groupId,
			orderByComparator);
	}

	/**
	* Removes all the e s f organizations where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Returns the number of e s f organizations where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching e s f organizations
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Returns the number of e s f organizations that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching e s f organizations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByGroupId(groupId);
	}

	/**
	* Returns the e s f organization where code = &#63; or throws a {@link it.ethica.esf.NoSuchOrganizationException} if it could not be found.
	*
	* @param code the code
	* @return the matching e s f organization
	* @throws it.ethica.esf.NoSuchOrganizationException if a matching e s f organization could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFOrganization findByG_C(
		java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchOrganizationException {
		return getPersistence().findByG_C(code);
	}

	/**
	* Returns the e s f organization where code = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param code the code
	* @return the matching e s f organization, or <code>null</code> if a matching e s f organization could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFOrganization fetchByG_C(
		java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByG_C(code);
	}

	/**
	* Returns the e s f organization where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param code the code
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching e s f organization, or <code>null</code> if a matching e s f organization could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFOrganization fetchByG_C(
		java.lang.String code, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByG_C(code, retrieveFromCache);
	}

	/**
	* Removes the e s f organization where code = &#63; from the database.
	*
	* @param code the code
	* @return the e s f organization that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFOrganization removeByG_C(
		java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchOrganizationException {
		return getPersistence().removeByG_C(code);
	}

	/**
	* Returns the number of e s f organizations where code = &#63;.
	*
	* @param code the code
	* @return the number of matching e s f organizations
	* @throws SystemException if a system exception occurred
	*/
	public static int countByG_C(java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByG_C(code);
	}

	/**
	* Returns the e s f organization where vat = &#63; or throws a {@link it.ethica.esf.NoSuchOrganizationException} if it could not be found.
	*
	* @param vat the vat
	* @return the matching e s f organization
	* @throws it.ethica.esf.NoSuchOrganizationException if a matching e s f organization could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFOrganization findByG_V(
		java.lang.String vat)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchOrganizationException {
		return getPersistence().findByG_V(vat);
	}

	/**
	* Returns the e s f organization where vat = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param vat the vat
	* @return the matching e s f organization, or <code>null</code> if a matching e s f organization could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFOrganization fetchByG_V(
		java.lang.String vat)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByG_V(vat);
	}

	/**
	* Returns the e s f organization where vat = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param vat the vat
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching e s f organization, or <code>null</code> if a matching e s f organization could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFOrganization fetchByG_V(
		java.lang.String vat, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByG_V(vat, retrieveFromCache);
	}

	/**
	* Removes the e s f organization where vat = &#63; from the database.
	*
	* @param vat the vat
	* @return the e s f organization that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFOrganization removeByG_V(
		java.lang.String vat)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchOrganizationException {
		return getPersistence().removeByG_V(vat);
	}

	/**
	* Returns the number of e s f organizations where vat = &#63;.
	*
	* @param vat the vat
	* @return the number of matching e s f organizations
	* @throws SystemException if a system exception occurred
	*/
	public static int countByG_V(java.lang.String vat)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByG_V(vat);
	}

	/**
	* Returns the e s f organization where fiscalCode = &#63; or throws a {@link it.ethica.esf.NoSuchOrganizationException} if it could not be found.
	*
	* @param fiscalCode the fiscal code
	* @return the matching e s f organization
	* @throws it.ethica.esf.NoSuchOrganizationException if a matching e s f organization could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFOrganization findByG_F(
		java.lang.String fiscalCode)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchOrganizationException {
		return getPersistence().findByG_F(fiscalCode);
	}

	/**
	* Returns the e s f organization where fiscalCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param fiscalCode the fiscal code
	* @return the matching e s f organization, or <code>null</code> if a matching e s f organization could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFOrganization fetchByG_F(
		java.lang.String fiscalCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByG_F(fiscalCode);
	}

	/**
	* Returns the e s f organization where fiscalCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param fiscalCode the fiscal code
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching e s f organization, or <code>null</code> if a matching e s f organization could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFOrganization fetchByG_F(
		java.lang.String fiscalCode, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByG_F(fiscalCode, retrieveFromCache);
	}

	/**
	* Removes the e s f organization where fiscalCode = &#63; from the database.
	*
	* @param fiscalCode the fiscal code
	* @return the e s f organization that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFOrganization removeByG_F(
		java.lang.String fiscalCode)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchOrganizationException {
		return getPersistence().removeByG_F(fiscalCode);
	}

	/**
	* Returns the number of e s f organizations where fiscalCode = &#63;.
	*
	* @param fiscalCode the fiscal code
	* @return the number of matching e s f organizations
	* @throws SystemException if a system exception occurred
	*/
	public static int countByG_F(java.lang.String fiscalCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByG_F(fiscalCode);
	}

	/**
	* Caches the e s f organization in the entity cache if it is enabled.
	*
	* @param esfOrganization the e s f organization
	*/
	public static void cacheResult(
		it.ethica.esf.model.ESFOrganization esfOrganization) {
		getPersistence().cacheResult(esfOrganization);
	}

	/**
	* Caches the e s f organizations in the entity cache if it is enabled.
	*
	* @param esfOrganizations the e s f organizations
	*/
	public static void cacheResult(
		java.util.List<it.ethica.esf.model.ESFOrganization> esfOrganizations) {
		getPersistence().cacheResult(esfOrganizations);
	}

	/**
	* Creates a new e s f organization with the primary key. Does not add the e s f organization to the database.
	*
	* @param esfOrganizationId the primary key for the new e s f organization
	* @return the new e s f organization
	*/
	public static it.ethica.esf.model.ESFOrganization create(
		long esfOrganizationId) {
		return getPersistence().create(esfOrganizationId);
	}

	/**
	* Removes the e s f organization with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfOrganizationId the primary key of the e s f organization
	* @return the e s f organization that was removed
	* @throws it.ethica.esf.NoSuchOrganizationException if a e s f organization with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFOrganization remove(
		long esfOrganizationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchOrganizationException {
		return getPersistence().remove(esfOrganizationId);
	}

	public static it.ethica.esf.model.ESFOrganization updateImpl(
		it.ethica.esf.model.ESFOrganization esfOrganization)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(esfOrganization);
	}

	/**
	* Returns the e s f organization with the primary key or throws a {@link it.ethica.esf.NoSuchOrganizationException} if it could not be found.
	*
	* @param esfOrganizationId the primary key of the e s f organization
	* @return the e s f organization
	* @throws it.ethica.esf.NoSuchOrganizationException if a e s f organization with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFOrganization findByPrimaryKey(
		long esfOrganizationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchOrganizationException {
		return getPersistence().findByPrimaryKey(esfOrganizationId);
	}

	/**
	* Returns the e s f organization with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param esfOrganizationId the primary key of the e s f organization
	* @return the e s f organization, or <code>null</code> if a e s f organization with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFOrganization fetchByPrimaryKey(
		long esfOrganizationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(esfOrganizationId);
	}

	/**
	* Returns all the e s f organizations.
	*
	* @return the e s f organizations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFOrganization> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the e s f organizations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFOrganizationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f organizations
	* @param end the upper bound of the range of e s f organizations (not inclusive)
	* @return the range of e s f organizations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFOrganization> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the e s f organizations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFOrganizationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f organizations
	* @param end the upper bound of the range of e s f organizations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of e s f organizations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFOrganization> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the e s f organizations from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of e s f organizations.
	*
	* @return the number of e s f organizations
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ESFOrganizationPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ESFOrganizationPersistence)PortletBeanLocatorUtil.locate(it.ethica.esf.service.ClpSerializer.getServletContextName(),
					ESFOrganizationPersistence.class.getName());

			ReferenceRegistry.registerReference(ESFOrganizationUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ESFOrganizationPersistence persistence) {
	}

	private static ESFOrganizationPersistence _persistence;
}