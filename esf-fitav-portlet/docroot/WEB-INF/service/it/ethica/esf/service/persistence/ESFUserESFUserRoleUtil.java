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

import it.ethica.esf.model.ESFUserESFUserRole;

import java.util.List;

/**
 * The persistence utility for the e s f user e s f user role service. This utility wraps {@link ESFUserESFUserRolePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFUserESFUserRolePersistence
 * @see ESFUserESFUserRolePersistenceImpl
 * @generated
 */
public class ESFUserESFUserRoleUtil {
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
	public static void clearCache(ESFUserESFUserRole esfUserESFUserRole) {
		getPersistence().clearCache(esfUserESFUserRole);
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
	public static List<ESFUserESFUserRole> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ESFUserESFUserRole> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ESFUserESFUserRole> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ESFUserESFUserRole update(
		ESFUserESFUserRole esfUserESFUserRole) throws SystemException {
		return getPersistence().update(esfUserESFUserRole);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ESFUserESFUserRole update(
		ESFUserESFUserRole esfUserESFUserRole, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(esfUserESFUserRole, serviceContext);
	}

	/**
	* Returns all the e s f user e s f user roles where esfUserRoleId = &#63;.
	*
	* @param esfUserRoleId the esf user role ID
	* @return the matching e s f user e s f user roles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFUserESFUserRole> findByESFUserRoleId(
		long esfUserRoleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByESFUserRoleId(esfUserRoleId);
	}

	/**
	* Returns a range of all the e s f user e s f user roles where esfUserRoleId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserESFUserRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfUserRoleId the esf user role ID
	* @param start the lower bound of the range of e s f user e s f user roles
	* @param end the upper bound of the range of e s f user e s f user roles (not inclusive)
	* @return the range of matching e s f user e s f user roles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFUserESFUserRole> findByESFUserRoleId(
		long esfUserRoleId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByESFUserRoleId(esfUserRoleId, start, end);
	}

	/**
	* Returns an ordered range of all the e s f user e s f user roles where esfUserRoleId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserESFUserRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfUserRoleId the esf user role ID
	* @param start the lower bound of the range of e s f user e s f user roles
	* @param end the upper bound of the range of e s f user e s f user roles (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f user e s f user roles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFUserESFUserRole> findByESFUserRoleId(
		long esfUserRoleId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByESFUserRoleId(esfUserRoleId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first e s f user e s f user role in the ordered set where esfUserRoleId = &#63;.
	*
	* @param esfUserRoleId the esf user role ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f user e s f user role
	* @throws it.ethica.esf.NoSuchUserESFUserRoleException if a matching e s f user e s f user role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUserESFUserRole findByESFUserRoleId_First(
		long esfUserRoleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserESFUserRoleException {
		return getPersistence()
				   .findByESFUserRoleId_First(esfUserRoleId, orderByComparator);
	}

	/**
	* Returns the first e s f user e s f user role in the ordered set where esfUserRoleId = &#63;.
	*
	* @param esfUserRoleId the esf user role ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f user e s f user role, or <code>null</code> if a matching e s f user e s f user role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUserESFUserRole fetchByESFUserRoleId_First(
		long esfUserRoleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByESFUserRoleId_First(esfUserRoleId, orderByComparator);
	}

	/**
	* Returns the last e s f user e s f user role in the ordered set where esfUserRoleId = &#63;.
	*
	* @param esfUserRoleId the esf user role ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f user e s f user role
	* @throws it.ethica.esf.NoSuchUserESFUserRoleException if a matching e s f user e s f user role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUserESFUserRole findByESFUserRoleId_Last(
		long esfUserRoleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserESFUserRoleException {
		return getPersistence()
				   .findByESFUserRoleId_Last(esfUserRoleId, orderByComparator);
	}

	/**
	* Returns the last e s f user e s f user role in the ordered set where esfUserRoleId = &#63;.
	*
	* @param esfUserRoleId the esf user role ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f user e s f user role, or <code>null</code> if a matching e s f user e s f user role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUserESFUserRole fetchByESFUserRoleId_Last(
		long esfUserRoleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByESFUserRoleId_Last(esfUserRoleId, orderByComparator);
	}

	/**
	* Returns the e s f user e s f user roles before and after the current e s f user e s f user role in the ordered set where esfUserRoleId = &#63;.
	*
	* @param esfUserESFUserRolePK the primary key of the current e s f user e s f user role
	* @param esfUserRoleId the esf user role ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f user e s f user role
	* @throws it.ethica.esf.NoSuchUserESFUserRoleException if a e s f user e s f user role with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUserESFUserRole[] findByESFUserRoleId_PrevAndNext(
		ESFUserESFUserRolePK esfUserESFUserRolePK, long esfUserRoleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserESFUserRoleException {
		return getPersistence()
				   .findByESFUserRoleId_PrevAndNext(esfUserESFUserRolePK,
			esfUserRoleId, orderByComparator);
	}

	/**
	* Removes all the e s f user e s f user roles where esfUserRoleId = &#63; from the database.
	*
	* @param esfUserRoleId the esf user role ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByESFUserRoleId(long esfUserRoleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByESFUserRoleId(esfUserRoleId);
	}

	/**
	* Returns the number of e s f user e s f user roles where esfUserRoleId = &#63;.
	*
	* @param esfUserRoleId the esf user role ID
	* @return the number of matching e s f user e s f user roles
	* @throws SystemException if a system exception occurred
	*/
	public static int countByESFUserRoleId(long esfUserRoleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByESFUserRoleId(esfUserRoleId);
	}

	/**
	* Returns all the e s f user e s f user roles where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @return the matching e s f user e s f user roles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFUserESFUserRole> findByESFUserId(
		long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByESFUserId(esfUserId);
	}

	/**
	* Returns a range of all the e s f user e s f user roles where esfUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserESFUserRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfUserId the esf user ID
	* @param start the lower bound of the range of e s f user e s f user roles
	* @param end the upper bound of the range of e s f user e s f user roles (not inclusive)
	* @return the range of matching e s f user e s f user roles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFUserESFUserRole> findByESFUserId(
		long esfUserId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByESFUserId(esfUserId, start, end);
	}

	/**
	* Returns an ordered range of all the e s f user e s f user roles where esfUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserESFUserRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfUserId the esf user ID
	* @param start the lower bound of the range of e s f user e s f user roles
	* @param end the upper bound of the range of e s f user e s f user roles (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f user e s f user roles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFUserESFUserRole> findByESFUserId(
		long esfUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByESFUserId(esfUserId, start, end, orderByComparator);
	}

	/**
	* Returns the first e s f user e s f user role in the ordered set where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f user e s f user role
	* @throws it.ethica.esf.NoSuchUserESFUserRoleException if a matching e s f user e s f user role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUserESFUserRole findByESFUserId_First(
		long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserESFUserRoleException {
		return getPersistence()
				   .findByESFUserId_First(esfUserId, orderByComparator);
	}

	/**
	* Returns the first e s f user e s f user role in the ordered set where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f user e s f user role, or <code>null</code> if a matching e s f user e s f user role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUserESFUserRole fetchByESFUserId_First(
		long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByESFUserId_First(esfUserId, orderByComparator);
	}

	/**
	* Returns the last e s f user e s f user role in the ordered set where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f user e s f user role
	* @throws it.ethica.esf.NoSuchUserESFUserRoleException if a matching e s f user e s f user role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUserESFUserRole findByESFUserId_Last(
		long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserESFUserRoleException {
		return getPersistence()
				   .findByESFUserId_Last(esfUserId, orderByComparator);
	}

	/**
	* Returns the last e s f user e s f user role in the ordered set where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f user e s f user role, or <code>null</code> if a matching e s f user e s f user role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUserESFUserRole fetchByESFUserId_Last(
		long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByESFUserId_Last(esfUserId, orderByComparator);
	}

	/**
	* Returns the e s f user e s f user roles before and after the current e s f user e s f user role in the ordered set where esfUserId = &#63;.
	*
	* @param esfUserESFUserRolePK the primary key of the current e s f user e s f user role
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f user e s f user role
	* @throws it.ethica.esf.NoSuchUserESFUserRoleException if a e s f user e s f user role with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUserESFUserRole[] findByESFUserId_PrevAndNext(
		ESFUserESFUserRolePK esfUserESFUserRolePK, long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserESFUserRoleException {
		return getPersistence()
				   .findByESFUserId_PrevAndNext(esfUserESFUserRolePK,
			esfUserId, orderByComparator);
	}

	/**
	* Removes all the e s f user e s f user roles where esfUserId = &#63; from the database.
	*
	* @param esfUserId the esf user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByESFUserId(long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByESFUserId(esfUserId);
	}

	/**
	* Returns the number of e s f user e s f user roles where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @return the number of matching e s f user e s f user roles
	* @throws SystemException if a system exception occurred
	*/
	public static int countByESFUserId(long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByESFUserId(esfUserId);
	}

	/**
	* Returns all the e s f user e s f user roles where esfUserRoleId = &#63; and esfUserId = &#63; and endDate = &#63;.
	*
	* @param esfUserRoleId the esf user role ID
	* @param esfUserId the esf user ID
	* @param endDate the end date
	* @return the matching e s f user e s f user roles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFUserESFUserRole> findByESFUserRole(
		long esfUserRoleId, long esfUserId, java.util.Date endDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByESFUserRole(esfUserRoleId, esfUserId, endDate);
	}

	/**
	* Returns a range of all the e s f user e s f user roles where esfUserRoleId = &#63; and esfUserId = &#63; and endDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserESFUserRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfUserRoleId the esf user role ID
	* @param esfUserId the esf user ID
	* @param endDate the end date
	* @param start the lower bound of the range of e s f user e s f user roles
	* @param end the upper bound of the range of e s f user e s f user roles (not inclusive)
	* @return the range of matching e s f user e s f user roles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFUserESFUserRole> findByESFUserRole(
		long esfUserRoleId, long esfUserId, java.util.Date endDate, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByESFUserRole(esfUserRoleId, esfUserId, endDate, start,
			end);
	}

	/**
	* Returns an ordered range of all the e s f user e s f user roles where esfUserRoleId = &#63; and esfUserId = &#63; and endDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserESFUserRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfUserRoleId the esf user role ID
	* @param esfUserId the esf user ID
	* @param endDate the end date
	* @param start the lower bound of the range of e s f user e s f user roles
	* @param end the upper bound of the range of e s f user e s f user roles (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f user e s f user roles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFUserESFUserRole> findByESFUserRole(
		long esfUserRoleId, long esfUserId, java.util.Date endDate, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByESFUserRole(esfUserRoleId, esfUserId, endDate, start,
			end, orderByComparator);
	}

	/**
	* Returns the first e s f user e s f user role in the ordered set where esfUserRoleId = &#63; and esfUserId = &#63; and endDate = &#63;.
	*
	* @param esfUserRoleId the esf user role ID
	* @param esfUserId the esf user ID
	* @param endDate the end date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f user e s f user role
	* @throws it.ethica.esf.NoSuchUserESFUserRoleException if a matching e s f user e s f user role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUserESFUserRole findByESFUserRole_First(
		long esfUserRoleId, long esfUserId, java.util.Date endDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserESFUserRoleException {
		return getPersistence()
				   .findByESFUserRole_First(esfUserRoleId, esfUserId, endDate,
			orderByComparator);
	}

	/**
	* Returns the first e s f user e s f user role in the ordered set where esfUserRoleId = &#63; and esfUserId = &#63; and endDate = &#63;.
	*
	* @param esfUserRoleId the esf user role ID
	* @param esfUserId the esf user ID
	* @param endDate the end date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f user e s f user role, or <code>null</code> if a matching e s f user e s f user role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUserESFUserRole fetchByESFUserRole_First(
		long esfUserRoleId, long esfUserId, java.util.Date endDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByESFUserRole_First(esfUserRoleId, esfUserId, endDate,
			orderByComparator);
	}

	/**
	* Returns the last e s f user e s f user role in the ordered set where esfUserRoleId = &#63; and esfUserId = &#63; and endDate = &#63;.
	*
	* @param esfUserRoleId the esf user role ID
	* @param esfUserId the esf user ID
	* @param endDate the end date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f user e s f user role
	* @throws it.ethica.esf.NoSuchUserESFUserRoleException if a matching e s f user e s f user role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUserESFUserRole findByESFUserRole_Last(
		long esfUserRoleId, long esfUserId, java.util.Date endDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserESFUserRoleException {
		return getPersistence()
				   .findByESFUserRole_Last(esfUserRoleId, esfUserId, endDate,
			orderByComparator);
	}

	/**
	* Returns the last e s f user e s f user role in the ordered set where esfUserRoleId = &#63; and esfUserId = &#63; and endDate = &#63;.
	*
	* @param esfUserRoleId the esf user role ID
	* @param esfUserId the esf user ID
	* @param endDate the end date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f user e s f user role, or <code>null</code> if a matching e s f user e s f user role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUserESFUserRole fetchByESFUserRole_Last(
		long esfUserRoleId, long esfUserId, java.util.Date endDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByESFUserRole_Last(esfUserRoleId, esfUserId, endDate,
			orderByComparator);
	}

	/**
	* Returns the e s f user e s f user roles before and after the current e s f user e s f user role in the ordered set where esfUserRoleId = &#63; and esfUserId = &#63; and endDate = &#63;.
	*
	* @param esfUserESFUserRolePK the primary key of the current e s f user e s f user role
	* @param esfUserRoleId the esf user role ID
	* @param esfUserId the esf user ID
	* @param endDate the end date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f user e s f user role
	* @throws it.ethica.esf.NoSuchUserESFUserRoleException if a e s f user e s f user role with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUserESFUserRole[] findByESFUserRole_PrevAndNext(
		ESFUserESFUserRolePK esfUserESFUserRolePK, long esfUserRoleId,
		long esfUserId, java.util.Date endDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserESFUserRoleException {
		return getPersistence()
				   .findByESFUserRole_PrevAndNext(esfUserESFUserRolePK,
			esfUserRoleId, esfUserId, endDate, orderByComparator);
	}

	/**
	* Removes all the e s f user e s f user roles where esfUserRoleId = &#63; and esfUserId = &#63; and endDate = &#63; from the database.
	*
	* @param esfUserRoleId the esf user role ID
	* @param esfUserId the esf user ID
	* @param endDate the end date
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByESFUserRole(long esfUserRoleId, long esfUserId,
		java.util.Date endDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByESFUserRole(esfUserRoleId, esfUserId, endDate);
	}

	/**
	* Returns the number of e s f user e s f user roles where esfUserRoleId = &#63; and esfUserId = &#63; and endDate = &#63;.
	*
	* @param esfUserRoleId the esf user role ID
	* @param esfUserId the esf user ID
	* @param endDate the end date
	* @return the number of matching e s f user e s f user roles
	* @throws SystemException if a system exception occurred
	*/
	public static int countByESFUserRole(long esfUserRoleId, long esfUserId,
		java.util.Date endDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByESFUserRole(esfUserRoleId, esfUserId, endDate);
	}

	/**
	* Returns the e s f user e s f user role where esfUserRoleId = &#63; and esfUserId = &#63; or throws a {@link it.ethica.esf.NoSuchUserESFUserRoleException} if it could not be found.
	*
	* @param esfUserRoleId the esf user role ID
	* @param esfUserId the esf user ID
	* @return the matching e s f user e s f user role
	* @throws it.ethica.esf.NoSuchUserESFUserRoleException if a matching e s f user e s f user role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUserESFUserRole findByESFU_R(
		long esfUserRoleId, long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserESFUserRoleException {
		return getPersistence().findByESFU_R(esfUserRoleId, esfUserId);
	}

	/**
	* Returns the e s f user e s f user role where esfUserRoleId = &#63; and esfUserId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param esfUserRoleId the esf user role ID
	* @param esfUserId the esf user ID
	* @return the matching e s f user e s f user role, or <code>null</code> if a matching e s f user e s f user role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUserESFUserRole fetchByESFU_R(
		long esfUserRoleId, long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByESFU_R(esfUserRoleId, esfUserId);
	}

	/**
	* Returns the e s f user e s f user role where esfUserRoleId = &#63; and esfUserId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param esfUserRoleId the esf user role ID
	* @param esfUserId the esf user ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching e s f user e s f user role, or <code>null</code> if a matching e s f user e s f user role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUserESFUserRole fetchByESFU_R(
		long esfUserRoleId, long esfUserId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByESFU_R(esfUserRoleId, esfUserId, retrieveFromCache);
	}

	/**
	* Removes the e s f user e s f user role where esfUserRoleId = &#63; and esfUserId = &#63; from the database.
	*
	* @param esfUserRoleId the esf user role ID
	* @param esfUserId the esf user ID
	* @return the e s f user e s f user role that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUserESFUserRole removeByESFU_R(
		long esfUserRoleId, long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserESFUserRoleException {
		return getPersistence().removeByESFU_R(esfUserRoleId, esfUserId);
	}

	/**
	* Returns the number of e s f user e s f user roles where esfUserRoleId = &#63; and esfUserId = &#63;.
	*
	* @param esfUserRoleId the esf user role ID
	* @param esfUserId the esf user ID
	* @return the number of matching e s f user e s f user roles
	* @throws SystemException if a system exception occurred
	*/
	public static int countByESFU_R(long esfUserRoleId, long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByESFU_R(esfUserRoleId, esfUserId);
	}

	/**
	* Returns all the e s f user e s f user roles where esfUserRoleId = &#63;.
	*
	* @param esfUserRoleId the esf user role ID
	* @return the matching e s f user e s f user roles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFUserESFUserRole> findByESFU_ED(
		long esfUserRoleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByESFU_ED(esfUserRoleId);
	}

	/**
	* Returns a range of all the e s f user e s f user roles where esfUserRoleId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserESFUserRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfUserRoleId the esf user role ID
	* @param start the lower bound of the range of e s f user e s f user roles
	* @param end the upper bound of the range of e s f user e s f user roles (not inclusive)
	* @return the range of matching e s f user e s f user roles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFUserESFUserRole> findByESFU_ED(
		long esfUserRoleId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByESFU_ED(esfUserRoleId, start, end);
	}

	/**
	* Returns an ordered range of all the e s f user e s f user roles where esfUserRoleId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserESFUserRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfUserRoleId the esf user role ID
	* @param start the lower bound of the range of e s f user e s f user roles
	* @param end the upper bound of the range of e s f user e s f user roles (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f user e s f user roles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFUserESFUserRole> findByESFU_ED(
		long esfUserRoleId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByESFU_ED(esfUserRoleId, start, end, orderByComparator);
	}

	/**
	* Returns the first e s f user e s f user role in the ordered set where esfUserRoleId = &#63;.
	*
	* @param esfUserRoleId the esf user role ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f user e s f user role
	* @throws it.ethica.esf.NoSuchUserESFUserRoleException if a matching e s f user e s f user role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUserESFUserRole findByESFU_ED_First(
		long esfUserRoleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserESFUserRoleException {
		return getPersistence()
				   .findByESFU_ED_First(esfUserRoleId, orderByComparator);
	}

	/**
	* Returns the first e s f user e s f user role in the ordered set where esfUserRoleId = &#63;.
	*
	* @param esfUserRoleId the esf user role ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f user e s f user role, or <code>null</code> if a matching e s f user e s f user role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUserESFUserRole fetchByESFU_ED_First(
		long esfUserRoleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByESFU_ED_First(esfUserRoleId, orderByComparator);
	}

	/**
	* Returns the last e s f user e s f user role in the ordered set where esfUserRoleId = &#63;.
	*
	* @param esfUserRoleId the esf user role ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f user e s f user role
	* @throws it.ethica.esf.NoSuchUserESFUserRoleException if a matching e s f user e s f user role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUserESFUserRole findByESFU_ED_Last(
		long esfUserRoleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserESFUserRoleException {
		return getPersistence()
				   .findByESFU_ED_Last(esfUserRoleId, orderByComparator);
	}

	/**
	* Returns the last e s f user e s f user role in the ordered set where esfUserRoleId = &#63;.
	*
	* @param esfUserRoleId the esf user role ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f user e s f user role, or <code>null</code> if a matching e s f user e s f user role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUserESFUserRole fetchByESFU_ED_Last(
		long esfUserRoleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByESFU_ED_Last(esfUserRoleId, orderByComparator);
	}

	/**
	* Returns the e s f user e s f user roles before and after the current e s f user e s f user role in the ordered set where esfUserRoleId = &#63;.
	*
	* @param esfUserESFUserRolePK the primary key of the current e s f user e s f user role
	* @param esfUserRoleId the esf user role ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f user e s f user role
	* @throws it.ethica.esf.NoSuchUserESFUserRoleException if a e s f user e s f user role with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUserESFUserRole[] findByESFU_ED_PrevAndNext(
		ESFUserESFUserRolePK esfUserESFUserRolePK, long esfUserRoleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserESFUserRoleException {
		return getPersistence()
				   .findByESFU_ED_PrevAndNext(esfUserESFUserRolePK,
			esfUserRoleId, orderByComparator);
	}

	/**
	* Removes all the e s f user e s f user roles where esfUserRoleId = &#63; from the database.
	*
	* @param esfUserRoleId the esf user role ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByESFU_ED(long esfUserRoleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByESFU_ED(esfUserRoleId);
	}

	/**
	* Returns the number of e s f user e s f user roles where esfUserRoleId = &#63;.
	*
	* @param esfUserRoleId the esf user role ID
	* @return the number of matching e s f user e s f user roles
	* @throws SystemException if a system exception occurred
	*/
	public static int countByESFU_ED(long esfUserRoleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByESFU_ED(esfUserRoleId);
	}

	/**
	* Returns all the e s f user e s f user roles where esfOrganizationId = &#63; and esfUserRoleId = &#63;.
	*
	* @param esfOrganizationId the esf organization ID
	* @param esfUserRoleId the esf user role ID
	* @return the matching e s f user e s f user roles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFUserESFUserRole> findByESFO_R(
		long esfOrganizationId, long esfUserRoleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByESFO_R(esfOrganizationId, esfUserRoleId);
	}

	/**
	* Returns a range of all the e s f user e s f user roles where esfOrganizationId = &#63; and esfUserRoleId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserESFUserRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfOrganizationId the esf organization ID
	* @param esfUserRoleId the esf user role ID
	* @param start the lower bound of the range of e s f user e s f user roles
	* @param end the upper bound of the range of e s f user e s f user roles (not inclusive)
	* @return the range of matching e s f user e s f user roles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFUserESFUserRole> findByESFO_R(
		long esfOrganizationId, long esfUserRoleId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByESFO_R(esfOrganizationId, esfUserRoleId, start, end);
	}

	/**
	* Returns an ordered range of all the e s f user e s f user roles where esfOrganizationId = &#63; and esfUserRoleId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserESFUserRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfOrganizationId the esf organization ID
	* @param esfUserRoleId the esf user role ID
	* @param start the lower bound of the range of e s f user e s f user roles
	* @param end the upper bound of the range of e s f user e s f user roles (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f user e s f user roles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFUserESFUserRole> findByESFO_R(
		long esfOrganizationId, long esfUserRoleId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByESFO_R(esfOrganizationId, esfUserRoleId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first e s f user e s f user role in the ordered set where esfOrganizationId = &#63; and esfUserRoleId = &#63;.
	*
	* @param esfOrganizationId the esf organization ID
	* @param esfUserRoleId the esf user role ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f user e s f user role
	* @throws it.ethica.esf.NoSuchUserESFUserRoleException if a matching e s f user e s f user role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUserESFUserRole findByESFO_R_First(
		long esfOrganizationId, long esfUserRoleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserESFUserRoleException {
		return getPersistence()
				   .findByESFO_R_First(esfOrganizationId, esfUserRoleId,
			orderByComparator);
	}

	/**
	* Returns the first e s f user e s f user role in the ordered set where esfOrganizationId = &#63; and esfUserRoleId = &#63;.
	*
	* @param esfOrganizationId the esf organization ID
	* @param esfUserRoleId the esf user role ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f user e s f user role, or <code>null</code> if a matching e s f user e s f user role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUserESFUserRole fetchByESFO_R_First(
		long esfOrganizationId, long esfUserRoleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByESFO_R_First(esfOrganizationId, esfUserRoleId,
			orderByComparator);
	}

	/**
	* Returns the last e s f user e s f user role in the ordered set where esfOrganizationId = &#63; and esfUserRoleId = &#63;.
	*
	* @param esfOrganizationId the esf organization ID
	* @param esfUserRoleId the esf user role ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f user e s f user role
	* @throws it.ethica.esf.NoSuchUserESFUserRoleException if a matching e s f user e s f user role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUserESFUserRole findByESFO_R_Last(
		long esfOrganizationId, long esfUserRoleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserESFUserRoleException {
		return getPersistence()
				   .findByESFO_R_Last(esfOrganizationId, esfUserRoleId,
			orderByComparator);
	}

	/**
	* Returns the last e s f user e s f user role in the ordered set where esfOrganizationId = &#63; and esfUserRoleId = &#63;.
	*
	* @param esfOrganizationId the esf organization ID
	* @param esfUserRoleId the esf user role ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f user e s f user role, or <code>null</code> if a matching e s f user e s f user role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUserESFUserRole fetchByESFO_R_Last(
		long esfOrganizationId, long esfUserRoleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByESFO_R_Last(esfOrganizationId, esfUserRoleId,
			orderByComparator);
	}

	/**
	* Returns the e s f user e s f user roles before and after the current e s f user e s f user role in the ordered set where esfOrganizationId = &#63; and esfUserRoleId = &#63;.
	*
	* @param esfUserESFUserRolePK the primary key of the current e s f user e s f user role
	* @param esfOrganizationId the esf organization ID
	* @param esfUserRoleId the esf user role ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f user e s f user role
	* @throws it.ethica.esf.NoSuchUserESFUserRoleException if a e s f user e s f user role with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUserESFUserRole[] findByESFO_R_PrevAndNext(
		ESFUserESFUserRolePK esfUserESFUserRolePK, long esfOrganizationId,
		long esfUserRoleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserESFUserRoleException {
		return getPersistence()
				   .findByESFO_R_PrevAndNext(esfUserESFUserRolePK,
			esfOrganizationId, esfUserRoleId, orderByComparator);
	}

	/**
	* Removes all the e s f user e s f user roles where esfOrganizationId = &#63; and esfUserRoleId = &#63; from the database.
	*
	* @param esfOrganizationId the esf organization ID
	* @param esfUserRoleId the esf user role ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByESFO_R(long esfOrganizationId, long esfUserRoleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByESFO_R(esfOrganizationId, esfUserRoleId);
	}

	/**
	* Returns the number of e s f user e s f user roles where esfOrganizationId = &#63; and esfUserRoleId = &#63;.
	*
	* @param esfOrganizationId the esf organization ID
	* @param esfUserRoleId the esf user role ID
	* @return the number of matching e s f user e s f user roles
	* @throws SystemException if a system exception occurred
	*/
	public static int countByESFO_R(long esfOrganizationId, long esfUserRoleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByESFO_R(esfOrganizationId, esfUserRoleId);
	}

	/**
	* Returns the e s f user e s f user role where esfUserRoleId = &#63; and esfUserId = &#63; and esfOrganizationId = &#63; or throws a {@link it.ethica.esf.NoSuchUserESFUserRoleException} if it could not be found.
	*
	* @param esfUserRoleId the esf user role ID
	* @param esfUserId the esf user ID
	* @param esfOrganizationId the esf organization ID
	* @return the matching e s f user e s f user role
	* @throws it.ethica.esf.NoSuchUserESFUserRoleException if a matching e s f user e s f user role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUserESFUserRole findByESFU_R_O(
		long esfUserRoleId, long esfUserId, long esfOrganizationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserESFUserRoleException {
		return getPersistence()
				   .findByESFU_R_O(esfUserRoleId, esfUserId, esfOrganizationId);
	}

	/**
	* Returns the e s f user e s f user role where esfUserRoleId = &#63; and esfUserId = &#63; and esfOrganizationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param esfUserRoleId the esf user role ID
	* @param esfUserId the esf user ID
	* @param esfOrganizationId the esf organization ID
	* @return the matching e s f user e s f user role, or <code>null</code> if a matching e s f user e s f user role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUserESFUserRole fetchByESFU_R_O(
		long esfUserRoleId, long esfUserId, long esfOrganizationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByESFU_R_O(esfUserRoleId, esfUserId, esfOrganizationId);
	}

	/**
	* Returns the e s f user e s f user role where esfUserRoleId = &#63; and esfUserId = &#63; and esfOrganizationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param esfUserRoleId the esf user role ID
	* @param esfUserId the esf user ID
	* @param esfOrganizationId the esf organization ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching e s f user e s f user role, or <code>null</code> if a matching e s f user e s f user role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUserESFUserRole fetchByESFU_R_O(
		long esfUserRoleId, long esfUserId, long esfOrganizationId,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByESFU_R_O(esfUserRoleId, esfUserId,
			esfOrganizationId, retrieveFromCache);
	}

	/**
	* Removes the e s f user e s f user role where esfUserRoleId = &#63; and esfUserId = &#63; and esfOrganizationId = &#63; from the database.
	*
	* @param esfUserRoleId the esf user role ID
	* @param esfUserId the esf user ID
	* @param esfOrganizationId the esf organization ID
	* @return the e s f user e s f user role that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUserESFUserRole removeByESFU_R_O(
		long esfUserRoleId, long esfUserId, long esfOrganizationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserESFUserRoleException {
		return getPersistence()
				   .removeByESFU_R_O(esfUserRoleId, esfUserId, esfOrganizationId);
	}

	/**
	* Returns the number of e s f user e s f user roles where esfUserRoleId = &#63; and esfUserId = &#63; and esfOrganizationId = &#63;.
	*
	* @param esfUserRoleId the esf user role ID
	* @param esfUserId the esf user ID
	* @param esfOrganizationId the esf organization ID
	* @return the number of matching e s f user e s f user roles
	* @throws SystemException if a system exception occurred
	*/
	public static int countByESFU_R_O(long esfUserRoleId, long esfUserId,
		long esfOrganizationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByESFU_R_O(esfUserRoleId, esfUserId, esfOrganizationId);
	}

	/**
	* Returns all the e s f user e s f user roles where esfOrganizationId = &#63;.
	*
	* @param esfOrganizationId the esf organization ID
	* @return the matching e s f user e s f user roles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFUserESFUserRole> findByESFOrganizationId(
		long esfOrganizationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByESFOrganizationId(esfOrganizationId);
	}

	/**
	* Returns a range of all the e s f user e s f user roles where esfOrganizationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserESFUserRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfOrganizationId the esf organization ID
	* @param start the lower bound of the range of e s f user e s f user roles
	* @param end the upper bound of the range of e s f user e s f user roles (not inclusive)
	* @return the range of matching e s f user e s f user roles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFUserESFUserRole> findByESFOrganizationId(
		long esfOrganizationId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByESFOrganizationId(esfOrganizationId, start, end);
	}

	/**
	* Returns an ordered range of all the e s f user e s f user roles where esfOrganizationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserESFUserRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfOrganizationId the esf organization ID
	* @param start the lower bound of the range of e s f user e s f user roles
	* @param end the upper bound of the range of e s f user e s f user roles (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f user e s f user roles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFUserESFUserRole> findByESFOrganizationId(
		long esfOrganizationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByESFOrganizationId(esfOrganizationId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first e s f user e s f user role in the ordered set where esfOrganizationId = &#63;.
	*
	* @param esfOrganizationId the esf organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f user e s f user role
	* @throws it.ethica.esf.NoSuchUserESFUserRoleException if a matching e s f user e s f user role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUserESFUserRole findByESFOrganizationId_First(
		long esfOrganizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserESFUserRoleException {
		return getPersistence()
				   .findByESFOrganizationId_First(esfOrganizationId,
			orderByComparator);
	}

	/**
	* Returns the first e s f user e s f user role in the ordered set where esfOrganizationId = &#63;.
	*
	* @param esfOrganizationId the esf organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f user e s f user role, or <code>null</code> if a matching e s f user e s f user role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUserESFUserRole fetchByESFOrganizationId_First(
		long esfOrganizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByESFOrganizationId_First(esfOrganizationId,
			orderByComparator);
	}

	/**
	* Returns the last e s f user e s f user role in the ordered set where esfOrganizationId = &#63;.
	*
	* @param esfOrganizationId the esf organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f user e s f user role
	* @throws it.ethica.esf.NoSuchUserESFUserRoleException if a matching e s f user e s f user role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUserESFUserRole findByESFOrganizationId_Last(
		long esfOrganizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserESFUserRoleException {
		return getPersistence()
				   .findByESFOrganizationId_Last(esfOrganizationId,
			orderByComparator);
	}

	/**
	* Returns the last e s f user e s f user role in the ordered set where esfOrganizationId = &#63;.
	*
	* @param esfOrganizationId the esf organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f user e s f user role, or <code>null</code> if a matching e s f user e s f user role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUserESFUserRole fetchByESFOrganizationId_Last(
		long esfOrganizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByESFOrganizationId_Last(esfOrganizationId,
			orderByComparator);
	}

	/**
	* Returns the e s f user e s f user roles before and after the current e s f user e s f user role in the ordered set where esfOrganizationId = &#63;.
	*
	* @param esfUserESFUserRolePK the primary key of the current e s f user e s f user role
	* @param esfOrganizationId the esf organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f user e s f user role
	* @throws it.ethica.esf.NoSuchUserESFUserRoleException if a e s f user e s f user role with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUserESFUserRole[] findByESFOrganizationId_PrevAndNext(
		ESFUserESFUserRolePK esfUserESFUserRolePK, long esfOrganizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserESFUserRoleException {
		return getPersistence()
				   .findByESFOrganizationId_PrevAndNext(esfUserESFUserRolePK,
			esfOrganizationId, orderByComparator);
	}

	/**
	* Removes all the e s f user e s f user roles where esfOrganizationId = &#63; from the database.
	*
	* @param esfOrganizationId the esf organization ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByESFOrganizationId(long esfOrganizationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByESFOrganizationId(esfOrganizationId);
	}

	/**
	* Returns the number of e s f user e s f user roles where esfOrganizationId = &#63;.
	*
	* @param esfOrganizationId the esf organization ID
	* @return the number of matching e s f user e s f user roles
	* @throws SystemException if a system exception occurred
	*/
	public static int countByESFOrganizationId(long esfOrganizationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByESFOrganizationId(esfOrganizationId);
	}

	/**
	* Returns all the e s f user e s f user roles where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @return the matching e s f user e s f user roles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFUserESFUserRole> findByESFUserId_ED(
		long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByESFUserId_ED(esfUserId);
	}

	/**
	* Returns a range of all the e s f user e s f user roles where esfUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserESFUserRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfUserId the esf user ID
	* @param start the lower bound of the range of e s f user e s f user roles
	* @param end the upper bound of the range of e s f user e s f user roles (not inclusive)
	* @return the range of matching e s f user e s f user roles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFUserESFUserRole> findByESFUserId_ED(
		long esfUserId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByESFUserId_ED(esfUserId, start, end);
	}

	/**
	* Returns an ordered range of all the e s f user e s f user roles where esfUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserESFUserRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfUserId the esf user ID
	* @param start the lower bound of the range of e s f user e s f user roles
	* @param end the upper bound of the range of e s f user e s f user roles (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f user e s f user roles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFUserESFUserRole> findByESFUserId_ED(
		long esfUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByESFUserId_ED(esfUserId, start, end, orderByComparator);
	}

	/**
	* Returns the first e s f user e s f user role in the ordered set where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f user e s f user role
	* @throws it.ethica.esf.NoSuchUserESFUserRoleException if a matching e s f user e s f user role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUserESFUserRole findByESFUserId_ED_First(
		long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserESFUserRoleException {
		return getPersistence()
				   .findByESFUserId_ED_First(esfUserId, orderByComparator);
	}

	/**
	* Returns the first e s f user e s f user role in the ordered set where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f user e s f user role, or <code>null</code> if a matching e s f user e s f user role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUserESFUserRole fetchByESFUserId_ED_First(
		long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByESFUserId_ED_First(esfUserId, orderByComparator);
	}

	/**
	* Returns the last e s f user e s f user role in the ordered set where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f user e s f user role
	* @throws it.ethica.esf.NoSuchUserESFUserRoleException if a matching e s f user e s f user role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUserESFUserRole findByESFUserId_ED_Last(
		long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserESFUserRoleException {
		return getPersistence()
				   .findByESFUserId_ED_Last(esfUserId, orderByComparator);
	}

	/**
	* Returns the last e s f user e s f user role in the ordered set where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f user e s f user role, or <code>null</code> if a matching e s f user e s f user role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUserESFUserRole fetchByESFUserId_ED_Last(
		long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByESFUserId_ED_Last(esfUserId, orderByComparator);
	}

	/**
	* Returns the e s f user e s f user roles before and after the current e s f user e s f user role in the ordered set where esfUserId = &#63;.
	*
	* @param esfUserESFUserRolePK the primary key of the current e s f user e s f user role
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f user e s f user role
	* @throws it.ethica.esf.NoSuchUserESFUserRoleException if a e s f user e s f user role with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUserESFUserRole[] findByESFUserId_ED_PrevAndNext(
		ESFUserESFUserRolePK esfUserESFUserRolePK, long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserESFUserRoleException {
		return getPersistence()
				   .findByESFUserId_ED_PrevAndNext(esfUserESFUserRolePK,
			esfUserId, orderByComparator);
	}

	/**
	* Removes all the e s f user e s f user roles where esfUserId = &#63; from the database.
	*
	* @param esfUserId the esf user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByESFUserId_ED(long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByESFUserId_ED(esfUserId);
	}

	/**
	* Returns the number of e s f user e s f user roles where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @return the number of matching e s f user e s f user roles
	* @throws SystemException if a system exception occurred
	*/
	public static int countByESFUserId_ED(long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByESFUserId_ED(esfUserId);
	}

	/**
	* Returns all the e s f user e s f user roles where esfOrganizationId = &#63; and esfUserRoleId = &#63;.
	*
	* @param esfOrganizationId the esf organization ID
	* @param esfUserRoleId the esf user role ID
	* @return the matching e s f user e s f user roles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFUserESFUserRole> findByESFO_R_YEAR(
		long esfOrganizationId, long esfUserRoleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByESFO_R_YEAR(esfOrganizationId, esfUserRoleId);
	}

	/**
	* Returns a range of all the e s f user e s f user roles where esfOrganizationId = &#63; and esfUserRoleId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserESFUserRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfOrganizationId the esf organization ID
	* @param esfUserRoleId the esf user role ID
	* @param start the lower bound of the range of e s f user e s f user roles
	* @param end the upper bound of the range of e s f user e s f user roles (not inclusive)
	* @return the range of matching e s f user e s f user roles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFUserESFUserRole> findByESFO_R_YEAR(
		long esfOrganizationId, long esfUserRoleId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByESFO_R_YEAR(esfOrganizationId, esfUserRoleId, start,
			end);
	}

	/**
	* Returns an ordered range of all the e s f user e s f user roles where esfOrganizationId = &#63; and esfUserRoleId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserESFUserRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfOrganizationId the esf organization ID
	* @param esfUserRoleId the esf user role ID
	* @param start the lower bound of the range of e s f user e s f user roles
	* @param end the upper bound of the range of e s f user e s f user roles (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f user e s f user roles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFUserESFUserRole> findByESFO_R_YEAR(
		long esfOrganizationId, long esfUserRoleId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByESFO_R_YEAR(esfOrganizationId, esfUserRoleId, start,
			end, orderByComparator);
	}

	/**
	* Returns the first e s f user e s f user role in the ordered set where esfOrganizationId = &#63; and esfUserRoleId = &#63;.
	*
	* @param esfOrganizationId the esf organization ID
	* @param esfUserRoleId the esf user role ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f user e s f user role
	* @throws it.ethica.esf.NoSuchUserESFUserRoleException if a matching e s f user e s f user role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUserESFUserRole findByESFO_R_YEAR_First(
		long esfOrganizationId, long esfUserRoleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserESFUserRoleException {
		return getPersistence()
				   .findByESFO_R_YEAR_First(esfOrganizationId, esfUserRoleId,
			orderByComparator);
	}

	/**
	* Returns the first e s f user e s f user role in the ordered set where esfOrganizationId = &#63; and esfUserRoleId = &#63;.
	*
	* @param esfOrganizationId the esf organization ID
	* @param esfUserRoleId the esf user role ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f user e s f user role, or <code>null</code> if a matching e s f user e s f user role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUserESFUserRole fetchByESFO_R_YEAR_First(
		long esfOrganizationId, long esfUserRoleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByESFO_R_YEAR_First(esfOrganizationId, esfUserRoleId,
			orderByComparator);
	}

	/**
	* Returns the last e s f user e s f user role in the ordered set where esfOrganizationId = &#63; and esfUserRoleId = &#63;.
	*
	* @param esfOrganizationId the esf organization ID
	* @param esfUserRoleId the esf user role ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f user e s f user role
	* @throws it.ethica.esf.NoSuchUserESFUserRoleException if a matching e s f user e s f user role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUserESFUserRole findByESFO_R_YEAR_Last(
		long esfOrganizationId, long esfUserRoleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserESFUserRoleException {
		return getPersistence()
				   .findByESFO_R_YEAR_Last(esfOrganizationId, esfUserRoleId,
			orderByComparator);
	}

	/**
	* Returns the last e s f user e s f user role in the ordered set where esfOrganizationId = &#63; and esfUserRoleId = &#63;.
	*
	* @param esfOrganizationId the esf organization ID
	* @param esfUserRoleId the esf user role ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f user e s f user role, or <code>null</code> if a matching e s f user e s f user role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUserESFUserRole fetchByESFO_R_YEAR_Last(
		long esfOrganizationId, long esfUserRoleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByESFO_R_YEAR_Last(esfOrganizationId, esfUserRoleId,
			orderByComparator);
	}

	/**
	* Returns the e s f user e s f user roles before and after the current e s f user e s f user role in the ordered set where esfOrganizationId = &#63; and esfUserRoleId = &#63;.
	*
	* @param esfUserESFUserRolePK the primary key of the current e s f user e s f user role
	* @param esfOrganizationId the esf organization ID
	* @param esfUserRoleId the esf user role ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f user e s f user role
	* @throws it.ethica.esf.NoSuchUserESFUserRoleException if a e s f user e s f user role with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUserESFUserRole[] findByESFO_R_YEAR_PrevAndNext(
		ESFUserESFUserRolePK esfUserESFUserRolePK, long esfOrganizationId,
		long esfUserRoleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserESFUserRoleException {
		return getPersistence()
				   .findByESFO_R_YEAR_PrevAndNext(esfUserESFUserRolePK,
			esfOrganizationId, esfUserRoleId, orderByComparator);
	}

	/**
	* Removes all the e s f user e s f user roles where esfOrganizationId = &#63; and esfUserRoleId = &#63; from the database.
	*
	* @param esfOrganizationId the esf organization ID
	* @param esfUserRoleId the esf user role ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByESFO_R_YEAR(long esfOrganizationId,
		long esfUserRoleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByESFO_R_YEAR(esfOrganizationId, esfUserRoleId);
	}

	/**
	* Returns the number of e s f user e s f user roles where esfOrganizationId = &#63; and esfUserRoleId = &#63;.
	*
	* @param esfOrganizationId the esf organization ID
	* @param esfUserRoleId the esf user role ID
	* @return the number of matching e s f user e s f user roles
	* @throws SystemException if a system exception occurred
	*/
	public static int countByESFO_R_YEAR(long esfOrganizationId,
		long esfUserRoleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByESFO_R_YEAR(esfOrganizationId, esfUserRoleId);
	}

	/**
	* Caches the e s f user e s f user role in the entity cache if it is enabled.
	*
	* @param esfUserESFUserRole the e s f user e s f user role
	*/
	public static void cacheResult(
		it.ethica.esf.model.ESFUserESFUserRole esfUserESFUserRole) {
		getPersistence().cacheResult(esfUserESFUserRole);
	}

	/**
	* Caches the e s f user e s f user roles in the entity cache if it is enabled.
	*
	* @param esfUserESFUserRoles the e s f user e s f user roles
	*/
	public static void cacheResult(
		java.util.List<it.ethica.esf.model.ESFUserESFUserRole> esfUserESFUserRoles) {
		getPersistence().cacheResult(esfUserESFUserRoles);
	}

	/**
	* Creates a new e s f user e s f user role with the primary key. Does not add the e s f user e s f user role to the database.
	*
	* @param esfUserESFUserRolePK the primary key for the new e s f user e s f user role
	* @return the new e s f user e s f user role
	*/
	public static it.ethica.esf.model.ESFUserESFUserRole create(
		ESFUserESFUserRolePK esfUserESFUserRolePK) {
		return getPersistence().create(esfUserESFUserRolePK);
	}

	/**
	* Removes the e s f user e s f user role with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfUserESFUserRolePK the primary key of the e s f user e s f user role
	* @return the e s f user e s f user role that was removed
	* @throws it.ethica.esf.NoSuchUserESFUserRoleException if a e s f user e s f user role with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUserESFUserRole remove(
		ESFUserESFUserRolePK esfUserESFUserRolePK)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserESFUserRoleException {
		return getPersistence().remove(esfUserESFUserRolePK);
	}

	public static it.ethica.esf.model.ESFUserESFUserRole updateImpl(
		it.ethica.esf.model.ESFUserESFUserRole esfUserESFUserRole)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(esfUserESFUserRole);
	}

	/**
	* Returns the e s f user e s f user role with the primary key or throws a {@link it.ethica.esf.NoSuchUserESFUserRoleException} if it could not be found.
	*
	* @param esfUserESFUserRolePK the primary key of the e s f user e s f user role
	* @return the e s f user e s f user role
	* @throws it.ethica.esf.NoSuchUserESFUserRoleException if a e s f user e s f user role with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUserESFUserRole findByPrimaryKey(
		ESFUserESFUserRolePK esfUserESFUserRolePK)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserESFUserRoleException {
		return getPersistence().findByPrimaryKey(esfUserESFUserRolePK);
	}

	/**
	* Returns the e s f user e s f user role with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param esfUserESFUserRolePK the primary key of the e s f user e s f user role
	* @return the e s f user e s f user role, or <code>null</code> if a e s f user e s f user role with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUserESFUserRole fetchByPrimaryKey(
		ESFUserESFUserRolePK esfUserESFUserRolePK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(esfUserESFUserRolePK);
	}

	/**
	* Returns all the e s f user e s f user roles.
	*
	* @return the e s f user e s f user roles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFUserESFUserRole> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the e s f user e s f user roles.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserESFUserRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f user e s f user roles
	* @param end the upper bound of the range of e s f user e s f user roles (not inclusive)
	* @return the range of e s f user e s f user roles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFUserESFUserRole> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the e s f user e s f user roles.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserESFUserRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f user e s f user roles
	* @param end the upper bound of the range of e s f user e s f user roles (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of e s f user e s f user roles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFUserESFUserRole> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the e s f user e s f user roles from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of e s f user e s f user roles.
	*
	* @return the number of e s f user e s f user roles
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ESFUserESFUserRolePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ESFUserESFUserRolePersistence)PortletBeanLocatorUtil.locate(it.ethica.esf.service.ClpSerializer.getServletContextName(),
					ESFUserESFUserRolePersistence.class.getName());

			ReferenceRegistry.registerReference(ESFUserESFUserRoleUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ESFUserESFUserRolePersistence persistence) {
	}

	private static ESFUserESFUserRolePersistence _persistence;
}