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

import it.ethica.esf.model.ESFForniture;

import java.util.List;

/**
 * The persistence utility for the e s f forniture service. This utility wraps {@link ESFForniturePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFForniturePersistence
 * @see ESFForniturePersistenceImpl
 * @generated
 */
public class ESFFornitureUtil {
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
	public static void clearCache(ESFForniture esfForniture) {
		getPersistence().clearCache(esfForniture);
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
	public static List<ESFForniture> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ESFForniture> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ESFForniture> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ESFForniture update(ESFForniture esfForniture)
		throws SystemException {
		return getPersistence().update(esfForniture);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ESFForniture update(ESFForniture esfForniture,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(esfForniture, serviceContext);
	}

	/**
	* Returns all the e s f fornitures where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching e s f fornitures
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFForniture> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the e s f fornitures where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFornitureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of e s f fornitures
	* @param end the upper bound of the range of e s f fornitures (not inclusive)
	* @return the range of matching e s f fornitures
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFForniture> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the e s f fornitures where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFornitureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of e s f fornitures
	* @param end the upper bound of the range of e s f fornitures (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f fornitures
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFForniture> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns the first e s f forniture in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f forniture
	* @throws it.ethica.esf.NoSuchFornitureException if a matching e s f forniture could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFForniture findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFornitureException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first e s f forniture in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f forniture, or <code>null</code> if a matching e s f forniture could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFForniture fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last e s f forniture in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f forniture
	* @throws it.ethica.esf.NoSuchFornitureException if a matching e s f forniture could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFForniture findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFornitureException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last e s f forniture in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f forniture, or <code>null</code> if a matching e s f forniture could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFForniture fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the e s f fornitures before and after the current e s f forniture in the ordered set where uuid = &#63;.
	*
	* @param esfFornitureId the primary key of the current e s f forniture
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f forniture
	* @throws it.ethica.esf.NoSuchFornitureException if a e s f forniture with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFForniture[] findByUuid_PrevAndNext(
		long esfFornitureId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFornitureException {
		return getPersistence()
				   .findByUuid_PrevAndNext(esfFornitureId, uuid,
			orderByComparator);
	}

	/**
	* Removes all the e s f fornitures where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of e s f fornitures where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching e s f fornitures
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the e s f forniture where uuid = &#63; and groupId = &#63; or throws a {@link it.ethica.esf.NoSuchFornitureException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching e s f forniture
	* @throws it.ethica.esf.NoSuchFornitureException if a matching e s f forniture could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFForniture findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFornitureException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the e s f forniture where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching e s f forniture, or <code>null</code> if a matching e s f forniture could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFForniture fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the e s f forniture where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching e s f forniture, or <code>null</code> if a matching e s f forniture could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFForniture fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the e s f forniture where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the e s f forniture that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFForniture removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFornitureException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of e s f fornitures where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching e s f fornitures
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the e s f fornitures where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching e s f fornitures
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFForniture> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the e s f fornitures where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFornitureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of e s f fornitures
	* @param end the upper bound of the range of e s f fornitures (not inclusive)
	* @return the range of matching e s f fornitures
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFForniture> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the e s f fornitures where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFornitureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of e s f fornitures
	* @param end the upper bound of the range of e s f fornitures (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f fornitures
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFForniture> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first e s f forniture in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f forniture
	* @throws it.ethica.esf.NoSuchFornitureException if a matching e s f forniture could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFForniture findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFornitureException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first e s f forniture in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f forniture, or <code>null</code> if a matching e s f forniture could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFForniture fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last e s f forniture in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f forniture
	* @throws it.ethica.esf.NoSuchFornitureException if a matching e s f forniture could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFForniture findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFornitureException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last e s f forniture in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f forniture, or <code>null</code> if a matching e s f forniture could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFForniture fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the e s f fornitures before and after the current e s f forniture in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param esfFornitureId the primary key of the current e s f forniture
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f forniture
	* @throws it.ethica.esf.NoSuchFornitureException if a e s f forniture with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFForniture[] findByUuid_C_PrevAndNext(
		long esfFornitureId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFornitureException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(esfFornitureId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the e s f fornitures where uuid = &#63; and companyId = &#63; from the database.
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
	* Returns the number of e s f fornitures where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching e s f fornitures
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the e s f fornitures where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching e s f fornitures
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFForniture> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	* Returns a range of all the e s f fornitures where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFornitureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of e s f fornitures
	* @param end the upper bound of the range of e s f fornitures (not inclusive)
	* @return the range of matching e s f fornitures
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFForniture> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the e s f fornitures where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFornitureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of e s f fornitures
	* @param end the upper bound of the range of e s f fornitures (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f fornitures
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFForniture> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first e s f forniture in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f forniture
	* @throws it.ethica.esf.NoSuchFornitureException if a matching e s f forniture could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFForniture findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFornitureException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the first e s f forniture in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f forniture, or <code>null</code> if a matching e s f forniture could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFForniture fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the last e s f forniture in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f forniture
	* @throws it.ethica.esf.NoSuchFornitureException if a matching e s f forniture could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFForniture findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFornitureException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last e s f forniture in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f forniture, or <code>null</code> if a matching e s f forniture could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFForniture fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the e s f fornitures before and after the current e s f forniture in the ordered set where groupId = &#63;.
	*
	* @param esfFornitureId the primary key of the current e s f forniture
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f forniture
	* @throws it.ethica.esf.NoSuchFornitureException if a e s f forniture with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFForniture[] findByGroupId_PrevAndNext(
		long esfFornitureId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFornitureException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(esfFornitureId, groupId,
			orderByComparator);
	}

	/**
	* Removes all the e s f fornitures where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Returns the number of e s f fornitures where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching e s f fornitures
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Returns the e s f forniture where code = &#63; or throws a {@link it.ethica.esf.NoSuchFornitureException} if it could not be found.
	*
	* @param code the code
	* @return the matching e s f forniture
	* @throws it.ethica.esf.NoSuchFornitureException if a matching e s f forniture could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFForniture findByCode(
		java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFornitureException {
		return getPersistence().findByCode(code);
	}

	/**
	* Returns the e s f forniture where code = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param code the code
	* @return the matching e s f forniture, or <code>null</code> if a matching e s f forniture could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFForniture fetchByCode(
		java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCode(code);
	}

	/**
	* Returns the e s f forniture where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param code the code
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching e s f forniture, or <code>null</code> if a matching e s f forniture could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFForniture fetchByCode(
		java.lang.String code, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCode(code, retrieveFromCache);
	}

	/**
	* Removes the e s f forniture where code = &#63; from the database.
	*
	* @param code the code
	* @return the e s f forniture that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFForniture removeByCode(
		java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFornitureException {
		return getPersistence().removeByCode(code);
	}

	/**
	* Returns the number of e s f fornitures where code = &#63;.
	*
	* @param code the code
	* @return the number of matching e s f fornitures
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCode(java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCode(code);
	}

	/**
	* Returns all the e s f fornitures where name = &#63;.
	*
	* @param name the name
	* @return the matching e s f fornitures
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFForniture> findByName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByName(name);
	}

	/**
	* Returns a range of all the e s f fornitures where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFornitureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param name the name
	* @param start the lower bound of the range of e s f fornitures
	* @param end the upper bound of the range of e s f fornitures (not inclusive)
	* @return the range of matching e s f fornitures
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFForniture> findByName(
		java.lang.String name, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByName(name, start, end);
	}

	/**
	* Returns an ordered range of all the e s f fornitures where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFornitureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param name the name
	* @param start the lower bound of the range of e s f fornitures
	* @param end the upper bound of the range of e s f fornitures (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f fornitures
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFForniture> findByName(
		java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByName(name, start, end, orderByComparator);
	}

	/**
	* Returns the first e s f forniture in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f forniture
	* @throws it.ethica.esf.NoSuchFornitureException if a matching e s f forniture could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFForniture findByName_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFornitureException {
		return getPersistence().findByName_First(name, orderByComparator);
	}

	/**
	* Returns the first e s f forniture in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f forniture, or <code>null</code> if a matching e s f forniture could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFForniture fetchByName_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByName_First(name, orderByComparator);
	}

	/**
	* Returns the last e s f forniture in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f forniture
	* @throws it.ethica.esf.NoSuchFornitureException if a matching e s f forniture could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFForniture findByName_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFornitureException {
		return getPersistence().findByName_Last(name, orderByComparator);
	}

	/**
	* Returns the last e s f forniture in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f forniture, or <code>null</code> if a matching e s f forniture could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFForniture fetchByName_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByName_Last(name, orderByComparator);
	}

	/**
	* Returns the e s f fornitures before and after the current e s f forniture in the ordered set where name = &#63;.
	*
	* @param esfFornitureId the primary key of the current e s f forniture
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f forniture
	* @throws it.ethica.esf.NoSuchFornitureException if a e s f forniture with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFForniture[] findByName_PrevAndNext(
		long esfFornitureId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFornitureException {
		return getPersistence()
				   .findByName_PrevAndNext(esfFornitureId, name,
			orderByComparator);
	}

	/**
	* Removes all the e s f fornitures where name = &#63; from the database.
	*
	* @param name the name
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByName(name);
	}

	/**
	* Returns the number of e s f fornitures where name = &#63;.
	*
	* @param name the name
	* @return the number of matching e s f fornitures
	* @throws SystemException if a system exception occurred
	*/
	public static int countByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByName(name);
	}

	/**
	* Returns the e s f forniture where description = &#63; or throws a {@link it.ethica.esf.NoSuchFornitureException} if it could not be found.
	*
	* @param description the description
	* @return the matching e s f forniture
	* @throws it.ethica.esf.NoSuchFornitureException if a matching e s f forniture could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFForniture findByDescription(
		java.lang.String description)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFornitureException {
		return getPersistence().findByDescription(description);
	}

	/**
	* Returns the e s f forniture where description = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param description the description
	* @return the matching e s f forniture, or <code>null</code> if a matching e s f forniture could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFForniture fetchByDescription(
		java.lang.String description)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByDescription(description);
	}

	/**
	* Returns the e s f forniture where description = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param description the description
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching e s f forniture, or <code>null</code> if a matching e s f forniture could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFForniture fetchByDescription(
		java.lang.String description, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByDescription(description, retrieveFromCache);
	}

	/**
	* Removes the e s f forniture where description = &#63; from the database.
	*
	* @param description the description
	* @return the e s f forniture that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFForniture removeByDescription(
		java.lang.String description)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFornitureException {
		return getPersistence().removeByDescription(description);
	}

	/**
	* Returns the number of e s f fornitures where description = &#63;.
	*
	* @param description the description
	* @return the number of matching e s f fornitures
	* @throws SystemException if a system exception occurred
	*/
	public static int countByDescription(java.lang.String description)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByDescription(description);
	}

	/**
	* Returns all the e s f fornitures where type = &#63;.
	*
	* @param type the type
	* @return the matching e s f fornitures
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFForniture> findByType(
		long type) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByType(type);
	}

	/**
	* Returns a range of all the e s f fornitures where type = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFornitureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param type the type
	* @param start the lower bound of the range of e s f fornitures
	* @param end the upper bound of the range of e s f fornitures (not inclusive)
	* @return the range of matching e s f fornitures
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFForniture> findByType(
		long type, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByType(type, start, end);
	}

	/**
	* Returns an ordered range of all the e s f fornitures where type = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFornitureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param type the type
	* @param start the lower bound of the range of e s f fornitures
	* @param end the upper bound of the range of e s f fornitures (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f fornitures
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFForniture> findByType(
		long type, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByType(type, start, end, orderByComparator);
	}

	/**
	* Returns the first e s f forniture in the ordered set where type = &#63;.
	*
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f forniture
	* @throws it.ethica.esf.NoSuchFornitureException if a matching e s f forniture could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFForniture findByType_First(long type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFornitureException {
		return getPersistence().findByType_First(type, orderByComparator);
	}

	/**
	* Returns the first e s f forniture in the ordered set where type = &#63;.
	*
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f forniture, or <code>null</code> if a matching e s f forniture could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFForniture fetchByType_First(
		long type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByType_First(type, orderByComparator);
	}

	/**
	* Returns the last e s f forniture in the ordered set where type = &#63;.
	*
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f forniture
	* @throws it.ethica.esf.NoSuchFornitureException if a matching e s f forniture could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFForniture findByType_Last(long type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFornitureException {
		return getPersistence().findByType_Last(type, orderByComparator);
	}

	/**
	* Returns the last e s f forniture in the ordered set where type = &#63;.
	*
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f forniture, or <code>null</code> if a matching e s f forniture could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFForniture fetchByType_Last(long type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByType_Last(type, orderByComparator);
	}

	/**
	* Returns the e s f fornitures before and after the current e s f forniture in the ordered set where type = &#63;.
	*
	* @param esfFornitureId the primary key of the current e s f forniture
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f forniture
	* @throws it.ethica.esf.NoSuchFornitureException if a e s f forniture with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFForniture[] findByType_PrevAndNext(
		long esfFornitureId, long type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFornitureException {
		return getPersistence()
				   .findByType_PrevAndNext(esfFornitureId, type,
			orderByComparator);
	}

	/**
	* Removes all the e s f fornitures where type = &#63; from the database.
	*
	* @param type the type
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByType(long type)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByType(type);
	}

	/**
	* Returns the number of e s f fornitures where type = &#63;.
	*
	* @param type the type
	* @return the number of matching e s f fornitures
	* @throws SystemException if a system exception occurred
	*/
	public static int countByType(long type)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByType(type);
	}

	/**
	* Returns all the e s f fornitures where insertDate = &#63;.
	*
	* @param insertDate the insert date
	* @return the matching e s f fornitures
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFForniture> findByInsertDate(
		java.util.Date insertDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByInsertDate(insertDate);
	}

	/**
	* Returns a range of all the e s f fornitures where insertDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFornitureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param insertDate the insert date
	* @param start the lower bound of the range of e s f fornitures
	* @param end the upper bound of the range of e s f fornitures (not inclusive)
	* @return the range of matching e s f fornitures
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFForniture> findByInsertDate(
		java.util.Date insertDate, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByInsertDate(insertDate, start, end);
	}

	/**
	* Returns an ordered range of all the e s f fornitures where insertDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFornitureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param insertDate the insert date
	* @param start the lower bound of the range of e s f fornitures
	* @param end the upper bound of the range of e s f fornitures (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f fornitures
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFForniture> findByInsertDate(
		java.util.Date insertDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByInsertDate(insertDate, start, end, orderByComparator);
	}

	/**
	* Returns the first e s f forniture in the ordered set where insertDate = &#63;.
	*
	* @param insertDate the insert date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f forniture
	* @throws it.ethica.esf.NoSuchFornitureException if a matching e s f forniture could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFForniture findByInsertDate_First(
		java.util.Date insertDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFornitureException {
		return getPersistence()
				   .findByInsertDate_First(insertDate, orderByComparator);
	}

	/**
	* Returns the first e s f forniture in the ordered set where insertDate = &#63;.
	*
	* @param insertDate the insert date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f forniture, or <code>null</code> if a matching e s f forniture could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFForniture fetchByInsertDate_First(
		java.util.Date insertDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByInsertDate_First(insertDate, orderByComparator);
	}

	/**
	* Returns the last e s f forniture in the ordered set where insertDate = &#63;.
	*
	* @param insertDate the insert date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f forniture
	* @throws it.ethica.esf.NoSuchFornitureException if a matching e s f forniture could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFForniture findByInsertDate_Last(
		java.util.Date insertDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFornitureException {
		return getPersistence()
				   .findByInsertDate_Last(insertDate, orderByComparator);
	}

	/**
	* Returns the last e s f forniture in the ordered set where insertDate = &#63;.
	*
	* @param insertDate the insert date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f forniture, or <code>null</code> if a matching e s f forniture could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFForniture fetchByInsertDate_Last(
		java.util.Date insertDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByInsertDate_Last(insertDate, orderByComparator);
	}

	/**
	* Returns the e s f fornitures before and after the current e s f forniture in the ordered set where insertDate = &#63;.
	*
	* @param esfFornitureId the primary key of the current e s f forniture
	* @param insertDate the insert date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f forniture
	* @throws it.ethica.esf.NoSuchFornitureException if a e s f forniture with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFForniture[] findByInsertDate_PrevAndNext(
		long esfFornitureId, java.util.Date insertDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFornitureException {
		return getPersistence()
				   .findByInsertDate_PrevAndNext(esfFornitureId, insertDate,
			orderByComparator);
	}

	/**
	* Removes all the e s f fornitures where insertDate = &#63; from the database.
	*
	* @param insertDate the insert date
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByInsertDate(java.util.Date insertDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByInsertDate(insertDate);
	}

	/**
	* Returns the number of e s f fornitures where insertDate = &#63;.
	*
	* @param insertDate the insert date
	* @return the number of matching e s f fornitures
	* @throws SystemException if a system exception occurred
	*/
	public static int countByInsertDate(java.util.Date insertDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByInsertDate(insertDate);
	}

	/**
	* Returns all the e s f fornitures where numberFornitures = &#63;.
	*
	* @param numberFornitures the number fornitures
	* @return the matching e s f fornitures
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFForniture> findByNumberFornitures(
		long numberFornitures)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByNumberFornitures(numberFornitures);
	}

	/**
	* Returns a range of all the e s f fornitures where numberFornitures = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFornitureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param numberFornitures the number fornitures
	* @param start the lower bound of the range of e s f fornitures
	* @param end the upper bound of the range of e s f fornitures (not inclusive)
	* @return the range of matching e s f fornitures
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFForniture> findByNumberFornitures(
		long numberFornitures, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByNumberFornitures(numberFornitures, start, end);
	}

	/**
	* Returns an ordered range of all the e s f fornitures where numberFornitures = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFornitureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param numberFornitures the number fornitures
	* @param start the lower bound of the range of e s f fornitures
	* @param end the upper bound of the range of e s f fornitures (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f fornitures
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFForniture> findByNumberFornitures(
		long numberFornitures, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByNumberFornitures(numberFornitures, start, end,
			orderByComparator);
	}

	/**
	* Returns the first e s f forniture in the ordered set where numberFornitures = &#63;.
	*
	* @param numberFornitures the number fornitures
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f forniture
	* @throws it.ethica.esf.NoSuchFornitureException if a matching e s f forniture could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFForniture findByNumberFornitures_First(
		long numberFornitures,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFornitureException {
		return getPersistence()
				   .findByNumberFornitures_First(numberFornitures,
			orderByComparator);
	}

	/**
	* Returns the first e s f forniture in the ordered set where numberFornitures = &#63;.
	*
	* @param numberFornitures the number fornitures
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f forniture, or <code>null</code> if a matching e s f forniture could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFForniture fetchByNumberFornitures_First(
		long numberFornitures,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByNumberFornitures_First(numberFornitures,
			orderByComparator);
	}

	/**
	* Returns the last e s f forniture in the ordered set where numberFornitures = &#63;.
	*
	* @param numberFornitures the number fornitures
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f forniture
	* @throws it.ethica.esf.NoSuchFornitureException if a matching e s f forniture could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFForniture findByNumberFornitures_Last(
		long numberFornitures,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFornitureException {
		return getPersistence()
				   .findByNumberFornitures_Last(numberFornitures,
			orderByComparator);
	}

	/**
	* Returns the last e s f forniture in the ordered set where numberFornitures = &#63;.
	*
	* @param numberFornitures the number fornitures
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f forniture, or <code>null</code> if a matching e s f forniture could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFForniture fetchByNumberFornitures_Last(
		long numberFornitures,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByNumberFornitures_Last(numberFornitures,
			orderByComparator);
	}

	/**
	* Returns the e s f fornitures before and after the current e s f forniture in the ordered set where numberFornitures = &#63;.
	*
	* @param esfFornitureId the primary key of the current e s f forniture
	* @param numberFornitures the number fornitures
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f forniture
	* @throws it.ethica.esf.NoSuchFornitureException if a e s f forniture with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFForniture[] findByNumberFornitures_PrevAndNext(
		long esfFornitureId, long numberFornitures,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFornitureException {
		return getPersistence()
				   .findByNumberFornitures_PrevAndNext(esfFornitureId,
			numberFornitures, orderByComparator);
	}

	/**
	* Removes all the e s f fornitures where numberFornitures = &#63; from the database.
	*
	* @param numberFornitures the number fornitures
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByNumberFornitures(long numberFornitures)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByNumberFornitures(numberFornitures);
	}

	/**
	* Returns the number of e s f fornitures where numberFornitures = &#63;.
	*
	* @param numberFornitures the number fornitures
	* @return the number of matching e s f fornitures
	* @throws SystemException if a system exception occurred
	*/
	public static int countByNumberFornitures(long numberFornitures)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByNumberFornitures(numberFornitures);
	}

	/**
	* Returns all the e s f fornitures where esfFornitureId = &#63; and groupId = &#63;.
	*
	* @param esfFornitureId the esf forniture ID
	* @param groupId the group ID
	* @return the matching e s f fornitures
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFForniture> findByT_G(
		long esfFornitureId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByT_G(esfFornitureId, groupId);
	}

	/**
	* Returns a range of all the e s f fornitures where esfFornitureId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFornitureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfFornitureId the esf forniture ID
	* @param groupId the group ID
	* @param start the lower bound of the range of e s f fornitures
	* @param end the upper bound of the range of e s f fornitures (not inclusive)
	* @return the range of matching e s f fornitures
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFForniture> findByT_G(
		long esfFornitureId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByT_G(esfFornitureId, groupId, start, end);
	}

	/**
	* Returns an ordered range of all the e s f fornitures where esfFornitureId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFornitureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfFornitureId the esf forniture ID
	* @param groupId the group ID
	* @param start the lower bound of the range of e s f fornitures
	* @param end the upper bound of the range of e s f fornitures (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f fornitures
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFForniture> findByT_G(
		long esfFornitureId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByT_G(esfFornitureId, groupId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first e s f forniture in the ordered set where esfFornitureId = &#63; and groupId = &#63;.
	*
	* @param esfFornitureId the esf forniture ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f forniture
	* @throws it.ethica.esf.NoSuchFornitureException if a matching e s f forniture could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFForniture findByT_G_First(
		long esfFornitureId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFornitureException {
		return getPersistence()
				   .findByT_G_First(esfFornitureId, groupId, orderByComparator);
	}

	/**
	* Returns the first e s f forniture in the ordered set where esfFornitureId = &#63; and groupId = &#63;.
	*
	* @param esfFornitureId the esf forniture ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f forniture, or <code>null</code> if a matching e s f forniture could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFForniture fetchByT_G_First(
		long esfFornitureId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByT_G_First(esfFornitureId, groupId, orderByComparator);
	}

	/**
	* Returns the last e s f forniture in the ordered set where esfFornitureId = &#63; and groupId = &#63;.
	*
	* @param esfFornitureId the esf forniture ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f forniture
	* @throws it.ethica.esf.NoSuchFornitureException if a matching e s f forniture could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFForniture findByT_G_Last(
		long esfFornitureId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFornitureException {
		return getPersistence()
				   .findByT_G_Last(esfFornitureId, groupId, orderByComparator);
	}

	/**
	* Returns the last e s f forniture in the ordered set where esfFornitureId = &#63; and groupId = &#63;.
	*
	* @param esfFornitureId the esf forniture ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f forniture, or <code>null</code> if a matching e s f forniture could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFForniture fetchByT_G_Last(
		long esfFornitureId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByT_G_Last(esfFornitureId, groupId, orderByComparator);
	}

	/**
	* Removes all the e s f fornitures where esfFornitureId = &#63; and groupId = &#63; from the database.
	*
	* @param esfFornitureId the esf forniture ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByT_G(long esfFornitureId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByT_G(esfFornitureId, groupId);
	}

	/**
	* Returns the number of e s f fornitures where esfFornitureId = &#63; and groupId = &#63;.
	*
	* @param esfFornitureId the esf forniture ID
	* @param groupId the group ID
	* @return the number of matching e s f fornitures
	* @throws SystemException if a system exception occurred
	*/
	public static int countByT_G(long esfFornitureId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByT_G(esfFornitureId, groupId);
	}

	/**
	* Caches the e s f forniture in the entity cache if it is enabled.
	*
	* @param esfForniture the e s f forniture
	*/
	public static void cacheResult(
		it.ethica.esf.model.ESFForniture esfForniture) {
		getPersistence().cacheResult(esfForniture);
	}

	/**
	* Caches the e s f fornitures in the entity cache if it is enabled.
	*
	* @param esfFornitures the e s f fornitures
	*/
	public static void cacheResult(
		java.util.List<it.ethica.esf.model.ESFForniture> esfFornitures) {
		getPersistence().cacheResult(esfFornitures);
	}

	/**
	* Creates a new e s f forniture with the primary key. Does not add the e s f forniture to the database.
	*
	* @param esfFornitureId the primary key for the new e s f forniture
	* @return the new e s f forniture
	*/
	public static it.ethica.esf.model.ESFForniture create(long esfFornitureId) {
		return getPersistence().create(esfFornitureId);
	}

	/**
	* Removes the e s f forniture with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfFornitureId the primary key of the e s f forniture
	* @return the e s f forniture that was removed
	* @throws it.ethica.esf.NoSuchFornitureException if a e s f forniture with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFForniture remove(long esfFornitureId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFornitureException {
		return getPersistence().remove(esfFornitureId);
	}

	public static it.ethica.esf.model.ESFForniture updateImpl(
		it.ethica.esf.model.ESFForniture esfForniture)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(esfForniture);
	}

	/**
	* Returns the e s f forniture with the primary key or throws a {@link it.ethica.esf.NoSuchFornitureException} if it could not be found.
	*
	* @param esfFornitureId the primary key of the e s f forniture
	* @return the e s f forniture
	* @throws it.ethica.esf.NoSuchFornitureException if a e s f forniture with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFForniture findByPrimaryKey(
		long esfFornitureId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchFornitureException {
		return getPersistence().findByPrimaryKey(esfFornitureId);
	}

	/**
	* Returns the e s f forniture with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param esfFornitureId the primary key of the e s f forniture
	* @return the e s f forniture, or <code>null</code> if a e s f forniture with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFForniture fetchByPrimaryKey(
		long esfFornitureId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(esfFornitureId);
	}

	/**
	* Returns all the e s f fornitures.
	*
	* @return the e s f fornitures
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFForniture> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the e s f fornitures.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFornitureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f fornitures
	* @param end the upper bound of the range of e s f fornitures (not inclusive)
	* @return the range of e s f fornitures
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFForniture> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the e s f fornitures.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFFornitureModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f fornitures
	* @param end the upper bound of the range of e s f fornitures (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of e s f fornitures
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFForniture> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the e s f fornitures from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of e s f fornitures.
	*
	* @return the number of e s f fornitures
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ESFForniturePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ESFForniturePersistence)PortletBeanLocatorUtil.locate(it.ethica.esf.service.ClpSerializer.getServletContextName(),
					ESFForniturePersistence.class.getName());

			ReferenceRegistry.registerReference(ESFFornitureUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ESFForniturePersistence persistence) {
	}

	private static ESFForniturePersistence _persistence;
}