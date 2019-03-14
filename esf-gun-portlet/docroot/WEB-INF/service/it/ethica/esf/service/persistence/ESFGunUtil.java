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

import it.ethica.esf.model.ESFGun;

import java.util.List;

/**
 * The persistence utility for the e s f gun service. This utility wraps {@link ESFGunPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFGunPersistence
 * @see ESFGunPersistenceImpl
 * @generated
 */
public class ESFGunUtil {
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
	public static void clearCache(ESFGun esfGun) {
		getPersistence().clearCache(esfGun);
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
	public static List<ESFGun> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ESFGun> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ESFGun> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ESFGun update(ESFGun esfGun) throws SystemException {
		return getPersistence().update(esfGun);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ESFGun update(ESFGun esfGun, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(esfGun, serviceContext);
	}

	/**
	* Returns all the e s f guns where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching e s f guns
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFGun> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the e s f guns where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFGunModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of e s f guns
	* @param end the upper bound of the range of e s f guns (not inclusive)
	* @return the range of matching e s f guns
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFGun> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the e s f guns where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFGunModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of e s f guns
	* @param end the upper bound of the range of e s f guns (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f guns
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFGun> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns the first e s f gun in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f gun
	* @throws it.ethica.esf.NoSuchGunException if a matching e s f gun could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFGun findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchGunException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first e s f gun in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f gun, or <code>null</code> if a matching e s f gun could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFGun fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last e s f gun in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f gun
	* @throws it.ethica.esf.NoSuchGunException if a matching e s f gun could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFGun findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchGunException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last e s f gun in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f gun, or <code>null</code> if a matching e s f gun could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFGun fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the e s f guns before and after the current e s f gun in the ordered set where uuid = &#63;.
	*
	* @param esfGunId the primary key of the current e s f gun
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f gun
	* @throws it.ethica.esf.NoSuchGunException if a e s f gun with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFGun[] findByUuid_PrevAndNext(
		long esfGunId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchGunException {
		return getPersistence()
				   .findByUuid_PrevAndNext(esfGunId, uuid, orderByComparator);
	}

	/**
	* Removes all the e s f guns where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of e s f guns where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching e s f guns
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the e s f gun where uuid = &#63; and groupId = &#63; or throws a {@link it.ethica.esf.NoSuchGunException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching e s f gun
	* @throws it.ethica.esf.NoSuchGunException if a matching e s f gun could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFGun findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchGunException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the e s f gun where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching e s f gun, or <code>null</code> if a matching e s f gun could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFGun fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the e s f gun where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching e s f gun, or <code>null</code> if a matching e s f gun could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFGun fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the e s f gun where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the e s f gun that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFGun removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchGunException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of e s f guns where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching e s f guns
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the e s f guns where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching e s f guns
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFGun> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the e s f guns where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFGunModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of e s f guns
	* @param end the upper bound of the range of e s f guns (not inclusive)
	* @return the range of matching e s f guns
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFGun> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the e s f guns where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFGunModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of e s f guns
	* @param end the upper bound of the range of e s f guns (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f guns
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFGun> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first e s f gun in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f gun
	* @throws it.ethica.esf.NoSuchGunException if a matching e s f gun could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFGun findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchGunException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first e s f gun in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f gun, or <code>null</code> if a matching e s f gun could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFGun fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last e s f gun in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f gun
	* @throws it.ethica.esf.NoSuchGunException if a matching e s f gun could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFGun findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchGunException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last e s f gun in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f gun, or <code>null</code> if a matching e s f gun could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFGun fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the e s f guns before and after the current e s f gun in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param esfGunId the primary key of the current e s f gun
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f gun
	* @throws it.ethica.esf.NoSuchGunException if a e s f gun with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFGun[] findByUuid_C_PrevAndNext(
		long esfGunId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchGunException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(esfGunId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the e s f guns where uuid = &#63; and companyId = &#63; from the database.
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
	* Returns the number of e s f guns where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching e s f guns
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the e s f guns where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @return the matching e s f guns
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFGun> findByEsfUserId(
		long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByEsfUserId(esfUserId);
	}

	/**
	* Returns a range of all the e s f guns where esfUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFGunModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfUserId the esf user ID
	* @param start the lower bound of the range of e s f guns
	* @param end the upper bound of the range of e s f guns (not inclusive)
	* @return the range of matching e s f guns
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFGun> findByEsfUserId(
		long esfUserId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByEsfUserId(esfUserId, start, end);
	}

	/**
	* Returns an ordered range of all the e s f guns where esfUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFGunModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfUserId the esf user ID
	* @param start the lower bound of the range of e s f guns
	* @param end the upper bound of the range of e s f guns (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f guns
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFGun> findByEsfUserId(
		long esfUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByEsfUserId(esfUserId, start, end, orderByComparator);
	}

	/**
	* Returns the first e s f gun in the ordered set where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f gun
	* @throws it.ethica.esf.NoSuchGunException if a matching e s f gun could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFGun findByEsfUserId_First(
		long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchGunException {
		return getPersistence()
				   .findByEsfUserId_First(esfUserId, orderByComparator);
	}

	/**
	* Returns the first e s f gun in the ordered set where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f gun, or <code>null</code> if a matching e s f gun could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFGun fetchByEsfUserId_First(
		long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByEsfUserId_First(esfUserId, orderByComparator);
	}

	/**
	* Returns the last e s f gun in the ordered set where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f gun
	* @throws it.ethica.esf.NoSuchGunException if a matching e s f gun could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFGun findByEsfUserId_Last(
		long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchGunException {
		return getPersistence()
				   .findByEsfUserId_Last(esfUserId, orderByComparator);
	}

	/**
	* Returns the last e s f gun in the ordered set where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f gun, or <code>null</code> if a matching e s f gun could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFGun fetchByEsfUserId_Last(
		long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByEsfUserId_Last(esfUserId, orderByComparator);
	}

	/**
	* Returns the e s f guns before and after the current e s f gun in the ordered set where esfUserId = &#63;.
	*
	* @param esfGunId the primary key of the current e s f gun
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f gun
	* @throws it.ethica.esf.NoSuchGunException if a e s f gun with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFGun[] findByEsfUserId_PrevAndNext(
		long esfGunId, long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchGunException {
		return getPersistence()
				   .findByEsfUserId_PrevAndNext(esfGunId, esfUserId,
			orderByComparator);
	}

	/**
	* Removes all the e s f guns where esfUserId = &#63; from the database.
	*
	* @param esfUserId the esf user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByEsfUserId(long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByEsfUserId(esfUserId);
	}

	/**
	* Returns the number of e s f guns where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @return the number of matching e s f guns
	* @throws SystemException if a system exception occurred
	*/
	public static int countByEsfUserId(long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByEsfUserId(esfUserId);
	}

	/**
	* Returns all the e s f guns where esfOrganizationId = &#63;.
	*
	* @param esfOrganizationId the esf organization ID
	* @return the matching e s f guns
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFGun> findByEsfOrganizationId(
		long esfOrganizationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByEsfOrganizationId(esfOrganizationId);
	}

	/**
	* Returns a range of all the e s f guns where esfOrganizationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFGunModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfOrganizationId the esf organization ID
	* @param start the lower bound of the range of e s f guns
	* @param end the upper bound of the range of e s f guns (not inclusive)
	* @return the range of matching e s f guns
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFGun> findByEsfOrganizationId(
		long esfOrganizationId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByEsfOrganizationId(esfOrganizationId, start, end);
	}

	/**
	* Returns an ordered range of all the e s f guns where esfOrganizationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFGunModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfOrganizationId the esf organization ID
	* @param start the lower bound of the range of e s f guns
	* @param end the upper bound of the range of e s f guns (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f guns
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFGun> findByEsfOrganizationId(
		long esfOrganizationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByEsfOrganizationId(esfOrganizationId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first e s f gun in the ordered set where esfOrganizationId = &#63;.
	*
	* @param esfOrganizationId the esf organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f gun
	* @throws it.ethica.esf.NoSuchGunException if a matching e s f gun could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFGun findByEsfOrganizationId_First(
		long esfOrganizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchGunException {
		return getPersistence()
				   .findByEsfOrganizationId_First(esfOrganizationId,
			orderByComparator);
	}

	/**
	* Returns the first e s f gun in the ordered set where esfOrganizationId = &#63;.
	*
	* @param esfOrganizationId the esf organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f gun, or <code>null</code> if a matching e s f gun could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFGun fetchByEsfOrganizationId_First(
		long esfOrganizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByEsfOrganizationId_First(esfOrganizationId,
			orderByComparator);
	}

	/**
	* Returns the last e s f gun in the ordered set where esfOrganizationId = &#63;.
	*
	* @param esfOrganizationId the esf organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f gun
	* @throws it.ethica.esf.NoSuchGunException if a matching e s f gun could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFGun findByEsfOrganizationId_Last(
		long esfOrganizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchGunException {
		return getPersistence()
				   .findByEsfOrganizationId_Last(esfOrganizationId,
			orderByComparator);
	}

	/**
	* Returns the last e s f gun in the ordered set where esfOrganizationId = &#63;.
	*
	* @param esfOrganizationId the esf organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f gun, or <code>null</code> if a matching e s f gun could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFGun fetchByEsfOrganizationId_Last(
		long esfOrganizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByEsfOrganizationId_Last(esfOrganizationId,
			orderByComparator);
	}

	/**
	* Returns the e s f guns before and after the current e s f gun in the ordered set where esfOrganizationId = &#63;.
	*
	* @param esfGunId the primary key of the current e s f gun
	* @param esfOrganizationId the esf organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f gun
	* @throws it.ethica.esf.NoSuchGunException if a e s f gun with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFGun[] findByEsfOrganizationId_PrevAndNext(
		long esfGunId, long esfOrganizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchGunException {
		return getPersistence()
				   .findByEsfOrganizationId_PrevAndNext(esfGunId,
			esfOrganizationId, orderByComparator);
	}

	/**
	* Removes all the e s f guns where esfOrganizationId = &#63; from the database.
	*
	* @param esfOrganizationId the esf organization ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByEsfOrganizationId(long esfOrganizationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByEsfOrganizationId(esfOrganizationId);
	}

	/**
	* Returns the number of e s f guns where esfOrganizationId = &#63;.
	*
	* @param esfOrganizationId the esf organization ID
	* @return the number of matching e s f guns
	* @throws SystemException if a system exception occurred
	*/
	public static int countByEsfOrganizationId(long esfOrganizationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByEsfOrganizationId(esfOrganizationId);
	}

	/**
	* Returns all the e s f guns where esfGunKindId = &#63;.
	*
	* @param esfGunKindId the esf gun kind ID
	* @return the matching e s f guns
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFGun> findByEsfGunKindId(
		long esfGunKindId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByEsfGunKindId(esfGunKindId);
	}

	/**
	* Returns a range of all the e s f guns where esfGunKindId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFGunModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfGunKindId the esf gun kind ID
	* @param start the lower bound of the range of e s f guns
	* @param end the upper bound of the range of e s f guns (not inclusive)
	* @return the range of matching e s f guns
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFGun> findByEsfGunKindId(
		long esfGunKindId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByEsfGunKindId(esfGunKindId, start, end);
	}

	/**
	* Returns an ordered range of all the e s f guns where esfGunKindId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFGunModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfGunKindId the esf gun kind ID
	* @param start the lower bound of the range of e s f guns
	* @param end the upper bound of the range of e s f guns (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f guns
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFGun> findByEsfGunKindId(
		long esfGunKindId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByEsfGunKindId(esfGunKindId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first e s f gun in the ordered set where esfGunKindId = &#63;.
	*
	* @param esfGunKindId the esf gun kind ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f gun
	* @throws it.ethica.esf.NoSuchGunException if a matching e s f gun could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFGun findByEsfGunKindId_First(
		long esfGunKindId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchGunException {
		return getPersistence()
				   .findByEsfGunKindId_First(esfGunKindId, orderByComparator);
	}

	/**
	* Returns the first e s f gun in the ordered set where esfGunKindId = &#63;.
	*
	* @param esfGunKindId the esf gun kind ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f gun, or <code>null</code> if a matching e s f gun could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFGun fetchByEsfGunKindId_First(
		long esfGunKindId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByEsfGunKindId_First(esfGunKindId, orderByComparator);
	}

	/**
	* Returns the last e s f gun in the ordered set where esfGunKindId = &#63;.
	*
	* @param esfGunKindId the esf gun kind ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f gun
	* @throws it.ethica.esf.NoSuchGunException if a matching e s f gun could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFGun findByEsfGunKindId_Last(
		long esfGunKindId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchGunException {
		return getPersistence()
				   .findByEsfGunKindId_Last(esfGunKindId, orderByComparator);
	}

	/**
	* Returns the last e s f gun in the ordered set where esfGunKindId = &#63;.
	*
	* @param esfGunKindId the esf gun kind ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f gun, or <code>null</code> if a matching e s f gun could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFGun fetchByEsfGunKindId_Last(
		long esfGunKindId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByEsfGunKindId_Last(esfGunKindId, orderByComparator);
	}

	/**
	* Returns the e s f guns before and after the current e s f gun in the ordered set where esfGunKindId = &#63;.
	*
	* @param esfGunId the primary key of the current e s f gun
	* @param esfGunKindId the esf gun kind ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f gun
	* @throws it.ethica.esf.NoSuchGunException if a e s f gun with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFGun[] findByEsfGunKindId_PrevAndNext(
		long esfGunId, long esfGunKindId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchGunException {
		return getPersistence()
				   .findByEsfGunKindId_PrevAndNext(esfGunId, esfGunKindId,
			orderByComparator);
	}

	/**
	* Removes all the e s f guns where esfGunKindId = &#63; from the database.
	*
	* @param esfGunKindId the esf gun kind ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByEsfGunKindId(long esfGunKindId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByEsfGunKindId(esfGunKindId);
	}

	/**
	* Returns the number of e s f guns where esfGunKindId = &#63;.
	*
	* @param esfGunKindId the esf gun kind ID
	* @return the number of matching e s f guns
	* @throws SystemException if a system exception occurred
	*/
	public static int countByEsfGunKindId(long esfGunKindId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByEsfGunKindId(esfGunKindId);
	}

	/**
	* Caches the e s f gun in the entity cache if it is enabled.
	*
	* @param esfGun the e s f gun
	*/
	public static void cacheResult(it.ethica.esf.model.ESFGun esfGun) {
		getPersistence().cacheResult(esfGun);
	}

	/**
	* Caches the e s f guns in the entity cache if it is enabled.
	*
	* @param esfGuns the e s f guns
	*/
	public static void cacheResult(
		java.util.List<it.ethica.esf.model.ESFGun> esfGuns) {
		getPersistence().cacheResult(esfGuns);
	}

	/**
	* Creates a new e s f gun with the primary key. Does not add the e s f gun to the database.
	*
	* @param esfGunId the primary key for the new e s f gun
	* @return the new e s f gun
	*/
	public static it.ethica.esf.model.ESFGun create(long esfGunId) {
		return getPersistence().create(esfGunId);
	}

	/**
	* Removes the e s f gun with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfGunId the primary key of the e s f gun
	* @return the e s f gun that was removed
	* @throws it.ethica.esf.NoSuchGunException if a e s f gun with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFGun remove(long esfGunId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchGunException {
		return getPersistence().remove(esfGunId);
	}

	public static it.ethica.esf.model.ESFGun updateImpl(
		it.ethica.esf.model.ESFGun esfGun)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(esfGun);
	}

	/**
	* Returns the e s f gun with the primary key or throws a {@link it.ethica.esf.NoSuchGunException} if it could not be found.
	*
	* @param esfGunId the primary key of the e s f gun
	* @return the e s f gun
	* @throws it.ethica.esf.NoSuchGunException if a e s f gun with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFGun findByPrimaryKey(long esfGunId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchGunException {
		return getPersistence().findByPrimaryKey(esfGunId);
	}

	/**
	* Returns the e s f gun with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param esfGunId the primary key of the e s f gun
	* @return the e s f gun, or <code>null</code> if a e s f gun with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFGun fetchByPrimaryKey(long esfGunId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(esfGunId);
	}

	/**
	* Returns all the e s f guns.
	*
	* @return the e s f guns
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFGun> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the e s f guns.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFGunModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f guns
	* @param end the upper bound of the range of e s f guns (not inclusive)
	* @return the range of e s f guns
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFGun> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the e s f guns.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFGunModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f guns
	* @param end the upper bound of the range of e s f guns (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of e s f guns
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFGun> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the e s f guns from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of e s f guns.
	*
	* @return the number of e s f guns
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ESFGunPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ESFGunPersistence)PortletBeanLocatorUtil.locate(it.ethica.esf.service.ClpSerializer.getServletContextName(),
					ESFGunPersistence.class.getName());

			ReferenceRegistry.registerReference(ESFGunUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ESFGunPersistence persistence) {
	}

	private static ESFGunPersistence _persistence;
}