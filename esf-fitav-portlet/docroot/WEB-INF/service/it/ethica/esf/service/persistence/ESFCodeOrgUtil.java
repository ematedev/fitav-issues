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

import it.ethica.esf.model.ESFCodeOrg;

import java.util.List;

/**
 * The persistence utility for the e s f code org service. This utility wraps {@link ESFCodeOrgPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFCodeOrgPersistence
 * @see ESFCodeOrgPersistenceImpl
 * @generated
 */
public class ESFCodeOrgUtil {
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
	public static void clearCache(ESFCodeOrg esfCodeOrg) {
		getPersistence().clearCache(esfCodeOrg);
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
	public static List<ESFCodeOrg> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ESFCodeOrg> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ESFCodeOrg> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ESFCodeOrg update(ESFCodeOrg esfCodeOrg)
		throws SystemException {
		return getPersistence().update(esfCodeOrg);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ESFCodeOrg update(ESFCodeOrg esfCodeOrg,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(esfCodeOrg, serviceContext);
	}

	/**
	* Returns all the e s f code orgs where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching e s f code orgs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFCodeOrg> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the e s f code orgs where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFCodeOrgModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of e s f code orgs
	* @param end the upper bound of the range of e s f code orgs (not inclusive)
	* @return the range of matching e s f code orgs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFCodeOrg> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the e s f code orgs where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFCodeOrgModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of e s f code orgs
	* @param end the upper bound of the range of e s f code orgs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f code orgs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFCodeOrg> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns the first e s f code org in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f code org
	* @throws it.ethica.esf.NoSuchCodeOrgException if a matching e s f code org could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFCodeOrg findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchCodeOrgException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first e s f code org in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f code org, or <code>null</code> if a matching e s f code org could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFCodeOrg fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last e s f code org in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f code org
	* @throws it.ethica.esf.NoSuchCodeOrgException if a matching e s f code org could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFCodeOrg findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchCodeOrgException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last e s f code org in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f code org, or <code>null</code> if a matching e s f code org could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFCodeOrg fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the e s f code orgs before and after the current e s f code org in the ordered set where uuid = &#63;.
	*
	* @param esfCodeOrgId the primary key of the current e s f code org
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f code org
	* @throws it.ethica.esf.NoSuchCodeOrgException if a e s f code org with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFCodeOrg[] findByUuid_PrevAndNext(
		long esfCodeOrgId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchCodeOrgException {
		return getPersistence()
				   .findByUuid_PrevAndNext(esfCodeOrgId, uuid, orderByComparator);
	}

	/**
	* Removes all the e s f code orgs where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of e s f code orgs where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching e s f code orgs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the e s f code org where className = &#63; and code = &#63; or throws a {@link it.ethica.esf.NoSuchCodeOrgException} if it could not be found.
	*
	* @param className the class name
	* @param code the code
	* @return the matching e s f code org
	* @throws it.ethica.esf.NoSuchCodeOrgException if a matching e s f code org could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFCodeOrg findByN_C(
		java.lang.String className, java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchCodeOrgException {
		return getPersistence().findByN_C(className, code);
	}

	/**
	* Returns the e s f code org where className = &#63; and code = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param className the class name
	* @param code the code
	* @return the matching e s f code org, or <code>null</code> if a matching e s f code org could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFCodeOrg fetchByN_C(
		java.lang.String className, java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByN_C(className, code);
	}

	/**
	* Returns the e s f code org where className = &#63; and code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param className the class name
	* @param code the code
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching e s f code org, or <code>null</code> if a matching e s f code org could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFCodeOrg fetchByN_C(
		java.lang.String className, java.lang.String code,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByN_C(className, code, retrieveFromCache);
	}

	/**
	* Removes the e s f code org where className = &#63; and code = &#63; from the database.
	*
	* @param className the class name
	* @param code the code
	* @return the e s f code org that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFCodeOrg removeByN_C(
		java.lang.String className, java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchCodeOrgException {
		return getPersistence().removeByN_C(className, code);
	}

	/**
	* Returns the number of e s f code orgs where className = &#63; and code = &#63;.
	*
	* @param className the class name
	* @param code the code
	* @return the number of matching e s f code orgs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByN_C(java.lang.String className,
		java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByN_C(className, code);
	}

	/**
	* Caches the e s f code org in the entity cache if it is enabled.
	*
	* @param esfCodeOrg the e s f code org
	*/
	public static void cacheResult(it.ethica.esf.model.ESFCodeOrg esfCodeOrg) {
		getPersistence().cacheResult(esfCodeOrg);
	}

	/**
	* Caches the e s f code orgs in the entity cache if it is enabled.
	*
	* @param esfCodeOrgs the e s f code orgs
	*/
	public static void cacheResult(
		java.util.List<it.ethica.esf.model.ESFCodeOrg> esfCodeOrgs) {
		getPersistence().cacheResult(esfCodeOrgs);
	}

	/**
	* Creates a new e s f code org with the primary key. Does not add the e s f code org to the database.
	*
	* @param esfCodeOrgId the primary key for the new e s f code org
	* @return the new e s f code org
	*/
	public static it.ethica.esf.model.ESFCodeOrg create(long esfCodeOrgId) {
		return getPersistence().create(esfCodeOrgId);
	}

	/**
	* Removes the e s f code org with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfCodeOrgId the primary key of the e s f code org
	* @return the e s f code org that was removed
	* @throws it.ethica.esf.NoSuchCodeOrgException if a e s f code org with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFCodeOrg remove(long esfCodeOrgId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchCodeOrgException {
		return getPersistence().remove(esfCodeOrgId);
	}

	public static it.ethica.esf.model.ESFCodeOrg updateImpl(
		it.ethica.esf.model.ESFCodeOrg esfCodeOrg)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(esfCodeOrg);
	}

	/**
	* Returns the e s f code org with the primary key or throws a {@link it.ethica.esf.NoSuchCodeOrgException} if it could not be found.
	*
	* @param esfCodeOrgId the primary key of the e s f code org
	* @return the e s f code org
	* @throws it.ethica.esf.NoSuchCodeOrgException if a e s f code org with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFCodeOrg findByPrimaryKey(
		long esfCodeOrgId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchCodeOrgException {
		return getPersistence().findByPrimaryKey(esfCodeOrgId);
	}

	/**
	* Returns the e s f code org with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param esfCodeOrgId the primary key of the e s f code org
	* @return the e s f code org, or <code>null</code> if a e s f code org with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFCodeOrg fetchByPrimaryKey(
		long esfCodeOrgId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(esfCodeOrgId);
	}

	/**
	* Returns all the e s f code orgs.
	*
	* @return the e s f code orgs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFCodeOrg> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the e s f code orgs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFCodeOrgModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f code orgs
	* @param end the upper bound of the range of e s f code orgs (not inclusive)
	* @return the range of e s f code orgs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFCodeOrg> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the e s f code orgs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFCodeOrgModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f code orgs
	* @param end the upper bound of the range of e s f code orgs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of e s f code orgs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFCodeOrg> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the e s f code orgs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of e s f code orgs.
	*
	* @return the number of e s f code orgs
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ESFCodeOrgPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ESFCodeOrgPersistence)PortletBeanLocatorUtil.locate(it.ethica.esf.service.ClpSerializer.getServletContextName(),
					ESFCodeOrgPersistence.class.getName());

			ReferenceRegistry.registerReference(ESFCodeOrgUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ESFCodeOrgPersistence persistence) {
	}

	private static ESFCodeOrgPersistence _persistence;
}