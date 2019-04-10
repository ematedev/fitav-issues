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

import it.ethica.esf.model.ESFTool;

import java.util.List;

/**
 * The persistence utility for the e s f tool service. This utility wraps {@link ESFToolPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFToolPersistence
 * @see ESFToolPersistenceImpl
 * @generated
 */
public class ESFToolUtil {
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
	public static void clearCache(ESFTool esfTool) {
		getPersistence().clearCache(esfTool);
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
	public static List<ESFTool> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ESFTool> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ESFTool> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ESFTool update(ESFTool esfTool) throws SystemException {
		return getPersistence().update(esfTool);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ESFTool update(ESFTool esfTool, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(esfTool, serviceContext);
	}

	/**
	* Returns all the e s f tools where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching e s f tools
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFTool> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the e s f tools where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFToolModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of e s f tools
	* @param end the upper bound of the range of e s f tools (not inclusive)
	* @return the range of matching e s f tools
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFTool> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the e s f tools where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFToolModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of e s f tools
	* @param end the upper bound of the range of e s f tools (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f tools
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFTool> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns the first e s f tool in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f tool
	* @throws it.ethica.esf.NoSuchToolException if a matching e s f tool could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFTool findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchToolException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first e s f tool in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f tool, or <code>null</code> if a matching e s f tool could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFTool fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last e s f tool in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f tool
	* @throws it.ethica.esf.NoSuchToolException if a matching e s f tool could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFTool findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchToolException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last e s f tool in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f tool, or <code>null</code> if a matching e s f tool could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFTool fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the e s f tools before and after the current e s f tool in the ordered set where uuid = &#63;.
	*
	* @param esfToolId the primary key of the current e s f tool
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f tool
	* @throws it.ethica.esf.NoSuchToolException if a e s f tool with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFTool[] findByUuid_PrevAndNext(
		long esfToolId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchToolException {
		return getPersistence()
				   .findByUuid_PrevAndNext(esfToolId, uuid, orderByComparator);
	}

	/**
	* Removes all the e s f tools where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of e s f tools where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching e s f tools
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the e s f tool where uuid = &#63; and groupId = &#63; or throws a {@link it.ethica.esf.NoSuchToolException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching e s f tool
	* @throws it.ethica.esf.NoSuchToolException if a matching e s f tool could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFTool findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchToolException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the e s f tool where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching e s f tool, or <code>null</code> if a matching e s f tool could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFTool fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the e s f tool where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching e s f tool, or <code>null</code> if a matching e s f tool could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFTool fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the e s f tool where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the e s f tool that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFTool removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchToolException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of e s f tools where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching e s f tools
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the e s f tools where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching e s f tools
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFTool> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the e s f tools where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFToolModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of e s f tools
	* @param end the upper bound of the range of e s f tools (not inclusive)
	* @return the range of matching e s f tools
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFTool> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the e s f tools where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFToolModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of e s f tools
	* @param end the upper bound of the range of e s f tools (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f tools
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFTool> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first e s f tool in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f tool
	* @throws it.ethica.esf.NoSuchToolException if a matching e s f tool could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFTool findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchToolException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first e s f tool in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f tool, or <code>null</code> if a matching e s f tool could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFTool fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last e s f tool in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f tool
	* @throws it.ethica.esf.NoSuchToolException if a matching e s f tool could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFTool findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchToolException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last e s f tool in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f tool, or <code>null</code> if a matching e s f tool could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFTool fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the e s f tools before and after the current e s f tool in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param esfToolId the primary key of the current e s f tool
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f tool
	* @throws it.ethica.esf.NoSuchToolException if a e s f tool with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFTool[] findByUuid_C_PrevAndNext(
		long esfToolId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchToolException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(esfToolId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the e s f tools where uuid = &#63; and companyId = &#63; from the database.
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
	* Returns the number of e s f tools where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching e s f tools
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the e s f tools where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching e s f tools
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFTool> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	* Returns a range of all the e s f tools where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFToolModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of e s f tools
	* @param end the upper bound of the range of e s f tools (not inclusive)
	* @return the range of matching e s f tools
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFTool> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the e s f tools where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFToolModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of e s f tools
	* @param end the upper bound of the range of e s f tools (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f tools
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFTool> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first e s f tool in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f tool
	* @throws it.ethica.esf.NoSuchToolException if a matching e s f tool could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFTool findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchToolException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the first e s f tool in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f tool, or <code>null</code> if a matching e s f tool could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFTool fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the last e s f tool in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f tool
	* @throws it.ethica.esf.NoSuchToolException if a matching e s f tool could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFTool findByGroupId_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchToolException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last e s f tool in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f tool, or <code>null</code> if a matching e s f tool could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFTool fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the e s f tools before and after the current e s f tool in the ordered set where groupId = &#63;.
	*
	* @param esfToolId the primary key of the current e s f tool
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f tool
	* @throws it.ethica.esf.NoSuchToolException if a e s f tool with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFTool[] findByGroupId_PrevAndNext(
		long esfToolId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchToolException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(esfToolId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the e s f tools that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching e s f tools that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFTool> filterFindByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroupId(groupId);
	}

	/**
	* Returns a range of all the e s f tools that the user has permission to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFToolModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of e s f tools
	* @param end the upper bound of the range of e s f tools (not inclusive)
	* @return the range of matching e s f tools that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFTool> filterFindByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroupId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the e s f tools that the user has permissions to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFToolModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of e s f tools
	* @param end the upper bound of the range of e s f tools (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f tools that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFTool> filterFindByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the e s f tools before and after the current e s f tool in the ordered set of e s f tools that the user has permission to view where groupId = &#63;.
	*
	* @param esfToolId the primary key of the current e s f tool
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f tool
	* @throws it.ethica.esf.NoSuchToolException if a e s f tool with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFTool[] filterFindByGroupId_PrevAndNext(
		long esfToolId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchToolException {
		return getPersistence()
				   .filterFindByGroupId_PrevAndNext(esfToolId, groupId,
			orderByComparator);
	}

	/**
	* Removes all the e s f tools where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Returns the number of e s f tools where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching e s f tools
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Returns the number of e s f tools that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching e s f tools that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByGroupId(groupId);
	}

	/**
	* Returns the e s f tool where code = &#63; or throws a {@link it.ethica.esf.NoSuchToolException} if it could not be found.
	*
	* @param code the code
	* @return the matching e s f tool
	* @throws it.ethica.esf.NoSuchToolException if a matching e s f tool could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFTool findByCode(java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchToolException {
		return getPersistence().findByCode(code);
	}

	/**
	* Returns the e s f tool where code = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param code the code
	* @return the matching e s f tool, or <code>null</code> if a matching e s f tool could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFTool fetchByCode(java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCode(code);
	}

	/**
	* Returns the e s f tool where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param code the code
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching e s f tool, or <code>null</code> if a matching e s f tool could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFTool fetchByCode(
		java.lang.String code, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCode(code, retrieveFromCache);
	}

	/**
	* Removes the e s f tool where code = &#63; from the database.
	*
	* @param code the code
	* @return the e s f tool that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFTool removeByCode(
		java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchToolException {
		return getPersistence().removeByCode(code);
	}

	/**
	* Returns the number of e s f tools where code = &#63;.
	*
	* @param code the code
	* @return the number of matching e s f tools
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCode(java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCode(code);
	}

	/**
	* Returns the e s f tool where name = &#63; or throws a {@link it.ethica.esf.NoSuchToolException} if it could not be found.
	*
	* @param name the name
	* @return the matching e s f tool
	* @throws it.ethica.esf.NoSuchToolException if a matching e s f tool could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFTool findByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchToolException {
		return getPersistence().findByName(name);
	}

	/**
	* Returns the e s f tool where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param name the name
	* @return the matching e s f tool, or <code>null</code> if a matching e s f tool could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFTool fetchByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByName(name);
	}

	/**
	* Returns the e s f tool where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param name the name
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching e s f tool, or <code>null</code> if a matching e s f tool could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFTool fetchByName(
		java.lang.String name, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByName(name, retrieveFromCache);
	}

	/**
	* Removes the e s f tool where name = &#63; from the database.
	*
	* @param name the name
	* @return the e s f tool that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFTool removeByName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchToolException {
		return getPersistence().removeByName(name);
	}

	/**
	* Returns the number of e s f tools where name = &#63;.
	*
	* @param name the name
	* @return the number of matching e s f tools
	* @throws SystemException if a system exception occurred
	*/
	public static int countByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByName(name);
	}

	/**
	* Returns the e s f tool where description = &#63; or throws a {@link it.ethica.esf.NoSuchToolException} if it could not be found.
	*
	* @param description the description
	* @return the matching e s f tool
	* @throws it.ethica.esf.NoSuchToolException if a matching e s f tool could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFTool findByDescritpion(
		java.lang.String description)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchToolException {
		return getPersistence().findByDescritpion(description);
	}

	/**
	* Returns the e s f tool where description = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param description the description
	* @return the matching e s f tool, or <code>null</code> if a matching e s f tool could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFTool fetchByDescritpion(
		java.lang.String description)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByDescritpion(description);
	}

	/**
	* Returns the e s f tool where description = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param description the description
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching e s f tool, or <code>null</code> if a matching e s f tool could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFTool fetchByDescritpion(
		java.lang.String description, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByDescritpion(description, retrieveFromCache);
	}

	/**
	* Removes the e s f tool where description = &#63; from the database.
	*
	* @param description the description
	* @return the e s f tool that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFTool removeByDescritpion(
		java.lang.String description)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchToolException {
		return getPersistence().removeByDescritpion(description);
	}

	/**
	* Returns the number of e s f tools where description = &#63;.
	*
	* @param description the description
	* @return the number of matching e s f tools
	* @throws SystemException if a system exception occurred
	*/
	public static int countByDescritpion(java.lang.String description)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByDescritpion(description);
	}

	/**
	* Returns all the e s f tools where type = &#63;.
	*
	* @param type the type
	* @return the matching e s f tools
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFTool> findByType(
		java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByType(type);
	}

	/**
	* Returns a range of all the e s f tools where type = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFToolModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param type the type
	* @param start the lower bound of the range of e s f tools
	* @param end the upper bound of the range of e s f tools (not inclusive)
	* @return the range of matching e s f tools
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFTool> findByType(
		java.lang.String type, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByType(type, start, end);
	}

	/**
	* Returns an ordered range of all the e s f tools where type = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFToolModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param type the type
	* @param start the lower bound of the range of e s f tools
	* @param end the upper bound of the range of e s f tools (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f tools
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFTool> findByType(
		java.lang.String type, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByType(type, start, end, orderByComparator);
	}

	/**
	* Returns the first e s f tool in the ordered set where type = &#63;.
	*
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f tool
	* @throws it.ethica.esf.NoSuchToolException if a matching e s f tool could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFTool findByType_First(
		java.lang.String type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchToolException {
		return getPersistence().findByType_First(type, orderByComparator);
	}

	/**
	* Returns the first e s f tool in the ordered set where type = &#63;.
	*
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f tool, or <code>null</code> if a matching e s f tool could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFTool fetchByType_First(
		java.lang.String type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByType_First(type, orderByComparator);
	}

	/**
	* Returns the last e s f tool in the ordered set where type = &#63;.
	*
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f tool
	* @throws it.ethica.esf.NoSuchToolException if a matching e s f tool could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFTool findByType_Last(
		java.lang.String type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchToolException {
		return getPersistence().findByType_Last(type, orderByComparator);
	}

	/**
	* Returns the last e s f tool in the ordered set where type = &#63;.
	*
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f tool, or <code>null</code> if a matching e s f tool could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFTool fetchByType_Last(
		java.lang.String type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByType_Last(type, orderByComparator);
	}

	/**
	* Returns the e s f tools before and after the current e s f tool in the ordered set where type = &#63;.
	*
	* @param esfToolId the primary key of the current e s f tool
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f tool
	* @throws it.ethica.esf.NoSuchToolException if a e s f tool with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFTool[] findByType_PrevAndNext(
		long esfToolId, java.lang.String type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchToolException {
		return getPersistence()
				   .findByType_PrevAndNext(esfToolId, type, orderByComparator);
	}

	/**
	* Removes all the e s f tools where type = &#63; from the database.
	*
	* @param type the type
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByType(java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByType(type);
	}

	/**
	* Returns the number of e s f tools where type = &#63;.
	*
	* @param type the type
	* @return the number of matching e s f tools
	* @throws SystemException if a system exception occurred
	*/
	public static int countByType(java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByType(type);
	}

	/**
	* Returns all the e s f tools where esfToolId = &#63; and groupId = &#63;.
	*
	* @param esfToolId the esf tool ID
	* @param groupId the group ID
	* @return the matching e s f tools
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFTool> findByT_G(
		long esfToolId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByT_G(esfToolId, groupId);
	}

	/**
	* Returns a range of all the e s f tools where esfToolId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFToolModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfToolId the esf tool ID
	* @param groupId the group ID
	* @param start the lower bound of the range of e s f tools
	* @param end the upper bound of the range of e s f tools (not inclusive)
	* @return the range of matching e s f tools
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFTool> findByT_G(
		long esfToolId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByT_G(esfToolId, groupId, start, end);
	}

	/**
	* Returns an ordered range of all the e s f tools where esfToolId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFToolModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfToolId the esf tool ID
	* @param groupId the group ID
	* @param start the lower bound of the range of e s f tools
	* @param end the upper bound of the range of e s f tools (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f tools
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFTool> findByT_G(
		long esfToolId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByT_G(esfToolId, groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first e s f tool in the ordered set where esfToolId = &#63; and groupId = &#63;.
	*
	* @param esfToolId the esf tool ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f tool
	* @throws it.ethica.esf.NoSuchToolException if a matching e s f tool could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFTool findByT_G_First(long esfToolId,
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchToolException {
		return getPersistence()
				   .findByT_G_First(esfToolId, groupId, orderByComparator);
	}

	/**
	* Returns the first e s f tool in the ordered set where esfToolId = &#63; and groupId = &#63;.
	*
	* @param esfToolId the esf tool ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f tool, or <code>null</code> if a matching e s f tool could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFTool fetchByT_G_First(long esfToolId,
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByT_G_First(esfToolId, groupId, orderByComparator);
	}

	/**
	* Returns the last e s f tool in the ordered set where esfToolId = &#63; and groupId = &#63;.
	*
	* @param esfToolId the esf tool ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f tool
	* @throws it.ethica.esf.NoSuchToolException if a matching e s f tool could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFTool findByT_G_Last(long esfToolId,
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchToolException {
		return getPersistence()
				   .findByT_G_Last(esfToolId, groupId, orderByComparator);
	}

	/**
	* Returns the last e s f tool in the ordered set where esfToolId = &#63; and groupId = &#63;.
	*
	* @param esfToolId the esf tool ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f tool, or <code>null</code> if a matching e s f tool could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFTool fetchByT_G_Last(long esfToolId,
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByT_G_Last(esfToolId, groupId, orderByComparator);
	}

	/**
	* Returns all the e s f tools that the user has permission to view where esfToolId = &#63; and groupId = &#63;.
	*
	* @param esfToolId the esf tool ID
	* @param groupId the group ID
	* @return the matching e s f tools that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFTool> filterFindByT_G(
		long esfToolId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByT_G(esfToolId, groupId);
	}

	/**
	* Returns a range of all the e s f tools that the user has permission to view where esfToolId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFToolModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfToolId the esf tool ID
	* @param groupId the group ID
	* @param start the lower bound of the range of e s f tools
	* @param end the upper bound of the range of e s f tools (not inclusive)
	* @return the range of matching e s f tools that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFTool> filterFindByT_G(
		long esfToolId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByT_G(esfToolId, groupId, start, end);
	}

	/**
	* Returns an ordered range of all the e s f tools that the user has permissions to view where esfToolId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFToolModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfToolId the esf tool ID
	* @param groupId the group ID
	* @param start the lower bound of the range of e s f tools
	* @param end the upper bound of the range of e s f tools (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f tools that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFTool> filterFindByT_G(
		long esfToolId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByT_G(esfToolId, groupId, start, end,
			orderByComparator);
	}

	/**
	* Removes all the e s f tools where esfToolId = &#63; and groupId = &#63; from the database.
	*
	* @param esfToolId the esf tool ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByT_G(long esfToolId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByT_G(esfToolId, groupId);
	}

	/**
	* Returns the number of e s f tools where esfToolId = &#63; and groupId = &#63;.
	*
	* @param esfToolId the esf tool ID
	* @param groupId the group ID
	* @return the number of matching e s f tools
	* @throws SystemException if a system exception occurred
	*/
	public static int countByT_G(long esfToolId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByT_G(esfToolId, groupId);
	}

	/**
	* Returns the number of e s f tools that the user has permission to view where esfToolId = &#63; and groupId = &#63;.
	*
	* @param esfToolId the esf tool ID
	* @param groupId the group ID
	* @return the number of matching e s f tools that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByT_G(long esfToolId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByT_G(esfToolId, groupId);
	}

	/**
	* Caches the e s f tool in the entity cache if it is enabled.
	*
	* @param esfTool the e s f tool
	*/
	public static void cacheResult(it.ethica.esf.model.ESFTool esfTool) {
		getPersistence().cacheResult(esfTool);
	}

	/**
	* Caches the e s f tools in the entity cache if it is enabled.
	*
	* @param esfTools the e s f tools
	*/
	public static void cacheResult(
		java.util.List<it.ethica.esf.model.ESFTool> esfTools) {
		getPersistence().cacheResult(esfTools);
	}

	/**
	* Creates a new e s f tool with the primary key. Does not add the e s f tool to the database.
	*
	* @param esfToolId the primary key for the new e s f tool
	* @return the new e s f tool
	*/
	public static it.ethica.esf.model.ESFTool create(long esfToolId) {
		return getPersistence().create(esfToolId);
	}

	/**
	* Removes the e s f tool with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfToolId the primary key of the e s f tool
	* @return the e s f tool that was removed
	* @throws it.ethica.esf.NoSuchToolException if a e s f tool with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFTool remove(long esfToolId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchToolException {
		return getPersistence().remove(esfToolId);
	}

	public static it.ethica.esf.model.ESFTool updateImpl(
		it.ethica.esf.model.ESFTool esfTool)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(esfTool);
	}

	/**
	* Returns the e s f tool with the primary key or throws a {@link it.ethica.esf.NoSuchToolException} if it could not be found.
	*
	* @param esfToolId the primary key of the e s f tool
	* @return the e s f tool
	* @throws it.ethica.esf.NoSuchToolException if a e s f tool with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFTool findByPrimaryKey(long esfToolId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchToolException {
		return getPersistence().findByPrimaryKey(esfToolId);
	}

	/**
	* Returns the e s f tool with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param esfToolId the primary key of the e s f tool
	* @return the e s f tool, or <code>null</code> if a e s f tool with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFTool fetchByPrimaryKey(long esfToolId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(esfToolId);
	}

	/**
	* Returns all the e s f tools.
	*
	* @return the e s f tools
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFTool> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the e s f tools.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFToolModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f tools
	* @param end the upper bound of the range of e s f tools (not inclusive)
	* @return the range of e s f tools
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFTool> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the e s f tools.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFToolModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f tools
	* @param end the upper bound of the range of e s f tools (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of e s f tools
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFTool> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the e s f tools from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of e s f tools.
	*
	* @return the number of e s f tools
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ESFToolPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ESFToolPersistence)PortletBeanLocatorUtil.locate(it.ethica.esf.service.ClpSerializer.getServletContextName(),
					ESFToolPersistence.class.getName());

			ReferenceRegistry.registerReference(ESFToolUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ESFToolPersistence persistence) {
	}

	private static ESFToolPersistence _persistence;
}