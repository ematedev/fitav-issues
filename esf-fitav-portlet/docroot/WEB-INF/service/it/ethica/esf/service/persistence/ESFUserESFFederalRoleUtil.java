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

import it.ethica.esf.model.ESFUserESFFederalRole;

import java.util.List;

/**
 * The persistence utility for the e s f user e s f federal role service. This utility wraps {@link ESFUserESFFederalRolePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFUserESFFederalRolePersistence
 * @see ESFUserESFFederalRolePersistenceImpl
 * @generated
 */
public class ESFUserESFFederalRoleUtil {
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
	public static void clearCache(ESFUserESFFederalRole esfUserESFFederalRole) {
		getPersistence().clearCache(esfUserESFFederalRole);
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
	public static List<ESFUserESFFederalRole> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ESFUserESFFederalRole> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ESFUserESFFederalRole> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ESFUserESFFederalRole update(
		ESFUserESFFederalRole esfUserESFFederalRole) throws SystemException {
		return getPersistence().update(esfUserESFFederalRole);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ESFUserESFFederalRole update(
		ESFUserESFFederalRole esfUserESFFederalRole,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(esfUserESFFederalRole, serviceContext);
	}

	/**
	* Returns the e s f user e s f federal role where esfUserId = &#63; and esfFederalRoleId = &#63; and active = &#63; or throws a {@link it.ethica.esf.NoSuchUserESFFederalRoleException} if it could not be found.
	*
	* @param esfUserId the esf user ID
	* @param esfFederalRoleId the esf federal role ID
	* @param active the active
	* @return the matching e s f user e s f federal role
	* @throws it.ethica.esf.NoSuchUserESFFederalRoleException if a matching e s f user e s f federal role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUserESFFederalRole findByUserAndFederalRoleActive(
		long esfUserId, long esfFederalRoleId, boolean active)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserESFFederalRoleException {
		return getPersistence()
				   .findByUserAndFederalRoleActive(esfUserId, esfFederalRoleId,
			active);
	}

	/**
	* Returns the e s f user e s f federal role where esfUserId = &#63; and esfFederalRoleId = &#63; and active = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param esfUserId the esf user ID
	* @param esfFederalRoleId the esf federal role ID
	* @param active the active
	* @return the matching e s f user e s f federal role, or <code>null</code> if a matching e s f user e s f federal role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUserESFFederalRole fetchByUserAndFederalRoleActive(
		long esfUserId, long esfFederalRoleId, boolean active)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUserAndFederalRoleActive(esfUserId,
			esfFederalRoleId, active);
	}

	/**
	* Returns the e s f user e s f federal role where esfUserId = &#63; and esfFederalRoleId = &#63; and active = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param esfUserId the esf user ID
	* @param esfFederalRoleId the esf federal role ID
	* @param active the active
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching e s f user e s f federal role, or <code>null</code> if a matching e s f user e s f federal role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUserESFFederalRole fetchByUserAndFederalRoleActive(
		long esfUserId, long esfFederalRoleId, boolean active,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUserAndFederalRoleActive(esfUserId,
			esfFederalRoleId, active, retrieveFromCache);
	}

	/**
	* Removes the e s f user e s f federal role where esfUserId = &#63; and esfFederalRoleId = &#63; and active = &#63; from the database.
	*
	* @param esfUserId the esf user ID
	* @param esfFederalRoleId the esf federal role ID
	* @param active the active
	* @return the e s f user e s f federal role that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUserESFFederalRole removeByUserAndFederalRoleActive(
		long esfUserId, long esfFederalRoleId, boolean active)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserESFFederalRoleException {
		return getPersistence()
				   .removeByUserAndFederalRoleActive(esfUserId,
			esfFederalRoleId, active);
	}

	/**
	* Returns the number of e s f user e s f federal roles where esfUserId = &#63; and esfFederalRoleId = &#63; and active = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param esfFederalRoleId the esf federal role ID
	* @param active the active
	* @return the number of matching e s f user e s f federal roles
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserAndFederalRoleActive(long esfUserId,
		long esfFederalRoleId, boolean active)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByUserAndFederalRoleActive(esfUserId,
			esfFederalRoleId, active);
	}

	/**
	* Returns all the e s f user e s f federal roles where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @return the matching e s f user e s f federal roles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFUserESFFederalRole> findByUser(
		long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUser(esfUserId);
	}

	/**
	* Returns a range of all the e s f user e s f federal roles where esfUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserESFFederalRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfUserId the esf user ID
	* @param start the lower bound of the range of e s f user e s f federal roles
	* @param end the upper bound of the range of e s f user e s f federal roles (not inclusive)
	* @return the range of matching e s f user e s f federal roles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFUserESFFederalRole> findByUser(
		long esfUserId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUser(esfUserId, start, end);
	}

	/**
	* Returns an ordered range of all the e s f user e s f federal roles where esfUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserESFFederalRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfUserId the esf user ID
	* @param start the lower bound of the range of e s f user e s f federal roles
	* @param end the upper bound of the range of e s f user e s f federal roles (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f user e s f federal roles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFUserESFFederalRole> findByUser(
		long esfUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUser(esfUserId, start, end, orderByComparator);
	}

	/**
	* Returns the first e s f user e s f federal role in the ordered set where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f user e s f federal role
	* @throws it.ethica.esf.NoSuchUserESFFederalRoleException if a matching e s f user e s f federal role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUserESFFederalRole findByUser_First(
		long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserESFFederalRoleException {
		return getPersistence().findByUser_First(esfUserId, orderByComparator);
	}

	/**
	* Returns the first e s f user e s f federal role in the ordered set where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f user e s f federal role, or <code>null</code> if a matching e s f user e s f federal role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUserESFFederalRole fetchByUser_First(
		long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUser_First(esfUserId, orderByComparator);
	}

	/**
	* Returns the last e s f user e s f federal role in the ordered set where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f user e s f federal role
	* @throws it.ethica.esf.NoSuchUserESFFederalRoleException if a matching e s f user e s f federal role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUserESFFederalRole findByUser_Last(
		long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserESFFederalRoleException {
		return getPersistence().findByUser_Last(esfUserId, orderByComparator);
	}

	/**
	* Returns the last e s f user e s f federal role in the ordered set where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f user e s f federal role, or <code>null</code> if a matching e s f user e s f federal role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUserESFFederalRole fetchByUser_Last(
		long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUser_Last(esfUserId, orderByComparator);
	}

	/**
	* Returns the e s f user e s f federal roles before and after the current e s f user e s f federal role in the ordered set where esfUserId = &#63;.
	*
	* @param esfUserESFFederalRolePK the primary key of the current e s f user e s f federal role
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f user e s f federal role
	* @throws it.ethica.esf.NoSuchUserESFFederalRoleException if a e s f user e s f federal role with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUserESFFederalRole[] findByUser_PrevAndNext(
		it.ethica.esf.service.persistence.ESFUserESFFederalRolePK esfUserESFFederalRolePK,
		long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserESFFederalRoleException {
		return getPersistence()
				   .findByUser_PrevAndNext(esfUserESFFederalRolePK, esfUserId,
			orderByComparator);
	}

	/**
	* Removes all the e s f user e s f federal roles where esfUserId = &#63; from the database.
	*
	* @param esfUserId the esf user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUser(long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUser(esfUserId);
	}

	/**
	* Returns the number of e s f user e s f federal roles where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @return the number of matching e s f user e s f federal roles
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUser(long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUser(esfUserId);
	}

	/**
	* Returns all the e s f user e s f federal roles where esfUserId = &#63; and active = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param active the active
	* @return the matching e s f user e s f federal roles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFUserESFFederalRole> findByUserActive(
		long esfUserId, boolean active)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserActive(esfUserId, active);
	}

	/**
	* Returns a range of all the e s f user e s f federal roles where esfUserId = &#63; and active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserESFFederalRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfUserId the esf user ID
	* @param active the active
	* @param start the lower bound of the range of e s f user e s f federal roles
	* @param end the upper bound of the range of e s f user e s f federal roles (not inclusive)
	* @return the range of matching e s f user e s f federal roles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFUserESFFederalRole> findByUserActive(
		long esfUserId, boolean active, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserActive(esfUserId, active, start, end);
	}

	/**
	* Returns an ordered range of all the e s f user e s f federal roles where esfUserId = &#63; and active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserESFFederalRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfUserId the esf user ID
	* @param active the active
	* @param start the lower bound of the range of e s f user e s f federal roles
	* @param end the upper bound of the range of e s f user e s f federal roles (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f user e s f federal roles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFUserESFFederalRole> findByUserActive(
		long esfUserId, boolean active, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserActive(esfUserId, active, start, end,
			orderByComparator);
	}

	/**
	* Returns the first e s f user e s f federal role in the ordered set where esfUserId = &#63; and active = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f user e s f federal role
	* @throws it.ethica.esf.NoSuchUserESFFederalRoleException if a matching e s f user e s f federal role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUserESFFederalRole findByUserActive_First(
		long esfUserId, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserESFFederalRoleException {
		return getPersistence()
				   .findByUserActive_First(esfUserId, active, orderByComparator);
	}

	/**
	* Returns the first e s f user e s f federal role in the ordered set where esfUserId = &#63; and active = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f user e s f federal role, or <code>null</code> if a matching e s f user e s f federal role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUserESFFederalRole fetchByUserActive_First(
		long esfUserId, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUserActive_First(esfUserId, active, orderByComparator);
	}

	/**
	* Returns the last e s f user e s f federal role in the ordered set where esfUserId = &#63; and active = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f user e s f federal role
	* @throws it.ethica.esf.NoSuchUserESFFederalRoleException if a matching e s f user e s f federal role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUserESFFederalRole findByUserActive_Last(
		long esfUserId, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserESFFederalRoleException {
		return getPersistence()
				   .findByUserActive_Last(esfUserId, active, orderByComparator);
	}

	/**
	* Returns the last e s f user e s f federal role in the ordered set where esfUserId = &#63; and active = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f user e s f federal role, or <code>null</code> if a matching e s f user e s f federal role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUserESFFederalRole fetchByUserActive_Last(
		long esfUserId, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUserActive_Last(esfUserId, active, orderByComparator);
	}

	/**
	* Returns the e s f user e s f federal roles before and after the current e s f user e s f federal role in the ordered set where esfUserId = &#63; and active = &#63;.
	*
	* @param esfUserESFFederalRolePK the primary key of the current e s f user e s f federal role
	* @param esfUserId the esf user ID
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f user e s f federal role
	* @throws it.ethica.esf.NoSuchUserESFFederalRoleException if a e s f user e s f federal role with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUserESFFederalRole[] findByUserActive_PrevAndNext(
		it.ethica.esf.service.persistence.ESFUserESFFederalRolePK esfUserESFFederalRolePK,
		long esfUserId, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserESFFederalRoleException {
		return getPersistence()
				   .findByUserActive_PrevAndNext(esfUserESFFederalRolePK,
			esfUserId, active, orderByComparator);
	}

	/**
	* Removes all the e s f user e s f federal roles where esfUserId = &#63; and active = &#63; from the database.
	*
	* @param esfUserId the esf user ID
	* @param active the active
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUserActive(long esfUserId, boolean active)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUserActive(esfUserId, active);
	}

	/**
	* Returns the number of e s f user e s f federal roles where esfUserId = &#63; and active = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param active the active
	* @return the number of matching e s f user e s f federal roles
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserActive(long esfUserId, boolean active)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUserActive(esfUserId, active);
	}

	/**
	* Returns all the e s f user e s f federal roles where esfFederalRoleId = &#63;.
	*
	* @param esfFederalRoleId the esf federal role ID
	* @return the matching e s f user e s f federal roles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFUserESFFederalRole> findByFederalRole(
		long esfFederalRoleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByFederalRole(esfFederalRoleId);
	}

	/**
	* Returns a range of all the e s f user e s f federal roles where esfFederalRoleId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserESFFederalRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfFederalRoleId the esf federal role ID
	* @param start the lower bound of the range of e s f user e s f federal roles
	* @param end the upper bound of the range of e s f user e s f federal roles (not inclusive)
	* @return the range of matching e s f user e s f federal roles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFUserESFFederalRole> findByFederalRole(
		long esfFederalRoleId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByFederalRole(esfFederalRoleId, start, end);
	}

	/**
	* Returns an ordered range of all the e s f user e s f federal roles where esfFederalRoleId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserESFFederalRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfFederalRoleId the esf federal role ID
	* @param start the lower bound of the range of e s f user e s f federal roles
	* @param end the upper bound of the range of e s f user e s f federal roles (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f user e s f federal roles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFUserESFFederalRole> findByFederalRole(
		long esfFederalRoleId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByFederalRole(esfFederalRoleId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first e s f user e s f federal role in the ordered set where esfFederalRoleId = &#63;.
	*
	* @param esfFederalRoleId the esf federal role ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f user e s f federal role
	* @throws it.ethica.esf.NoSuchUserESFFederalRoleException if a matching e s f user e s f federal role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUserESFFederalRole findByFederalRole_First(
		long esfFederalRoleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserESFFederalRoleException {
		return getPersistence()
				   .findByFederalRole_First(esfFederalRoleId, orderByComparator);
	}

	/**
	* Returns the first e s f user e s f federal role in the ordered set where esfFederalRoleId = &#63;.
	*
	* @param esfFederalRoleId the esf federal role ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f user e s f federal role, or <code>null</code> if a matching e s f user e s f federal role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUserESFFederalRole fetchByFederalRole_First(
		long esfFederalRoleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByFederalRole_First(esfFederalRoleId, orderByComparator);
	}

	/**
	* Returns the last e s f user e s f federal role in the ordered set where esfFederalRoleId = &#63;.
	*
	* @param esfFederalRoleId the esf federal role ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f user e s f federal role
	* @throws it.ethica.esf.NoSuchUserESFFederalRoleException if a matching e s f user e s f federal role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUserESFFederalRole findByFederalRole_Last(
		long esfFederalRoleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserESFFederalRoleException {
		return getPersistence()
				   .findByFederalRole_Last(esfFederalRoleId, orderByComparator);
	}

	/**
	* Returns the last e s f user e s f federal role in the ordered set where esfFederalRoleId = &#63;.
	*
	* @param esfFederalRoleId the esf federal role ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f user e s f federal role, or <code>null</code> if a matching e s f user e s f federal role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUserESFFederalRole fetchByFederalRole_Last(
		long esfFederalRoleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByFederalRole_Last(esfFederalRoleId, orderByComparator);
	}

	/**
	* Returns the e s f user e s f federal roles before and after the current e s f user e s f federal role in the ordered set where esfFederalRoleId = &#63;.
	*
	* @param esfUserESFFederalRolePK the primary key of the current e s f user e s f federal role
	* @param esfFederalRoleId the esf federal role ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f user e s f federal role
	* @throws it.ethica.esf.NoSuchUserESFFederalRoleException if a e s f user e s f federal role with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUserESFFederalRole[] findByFederalRole_PrevAndNext(
		it.ethica.esf.service.persistence.ESFUserESFFederalRolePK esfUserESFFederalRolePK,
		long esfFederalRoleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserESFFederalRoleException {
		return getPersistence()
				   .findByFederalRole_PrevAndNext(esfUserESFFederalRolePK,
			esfFederalRoleId, orderByComparator);
	}

	/**
	* Removes all the e s f user e s f federal roles where esfFederalRoleId = &#63; from the database.
	*
	* @param esfFederalRoleId the esf federal role ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByFederalRole(long esfFederalRoleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByFederalRole(esfFederalRoleId);
	}

	/**
	* Returns the number of e s f user e s f federal roles where esfFederalRoleId = &#63;.
	*
	* @param esfFederalRoleId the esf federal role ID
	* @return the number of matching e s f user e s f federal roles
	* @throws SystemException if a system exception occurred
	*/
	public static int countByFederalRole(long esfFederalRoleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByFederalRole(esfFederalRoleId);
	}

	/**
	* Caches the e s f user e s f federal role in the entity cache if it is enabled.
	*
	* @param esfUserESFFederalRole the e s f user e s f federal role
	*/
	public static void cacheResult(
		it.ethica.esf.model.ESFUserESFFederalRole esfUserESFFederalRole) {
		getPersistence().cacheResult(esfUserESFFederalRole);
	}

	/**
	* Caches the e s f user e s f federal roles in the entity cache if it is enabled.
	*
	* @param esfUserESFFederalRoles the e s f user e s f federal roles
	*/
	public static void cacheResult(
		java.util.List<it.ethica.esf.model.ESFUserESFFederalRole> esfUserESFFederalRoles) {
		getPersistence().cacheResult(esfUserESFFederalRoles);
	}

	/**
	* Creates a new e s f user e s f federal role with the primary key. Does not add the e s f user e s f federal role to the database.
	*
	* @param esfUserESFFederalRolePK the primary key for the new e s f user e s f federal role
	* @return the new e s f user e s f federal role
	*/
	public static it.ethica.esf.model.ESFUserESFFederalRole create(
		it.ethica.esf.service.persistence.ESFUserESFFederalRolePK esfUserESFFederalRolePK) {
		return getPersistence().create(esfUserESFFederalRolePK);
	}

	/**
	* Removes the e s f user e s f federal role with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfUserESFFederalRolePK the primary key of the e s f user e s f federal role
	* @return the e s f user e s f federal role that was removed
	* @throws it.ethica.esf.NoSuchUserESFFederalRoleException if a e s f user e s f federal role with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUserESFFederalRole remove(
		it.ethica.esf.service.persistence.ESFUserESFFederalRolePK esfUserESFFederalRolePK)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserESFFederalRoleException {
		return getPersistence().remove(esfUserESFFederalRolePK);
	}

	public static it.ethica.esf.model.ESFUserESFFederalRole updateImpl(
		it.ethica.esf.model.ESFUserESFFederalRole esfUserESFFederalRole)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(esfUserESFFederalRole);
	}

	/**
	* Returns the e s f user e s f federal role with the primary key or throws a {@link it.ethica.esf.NoSuchUserESFFederalRoleException} if it could not be found.
	*
	* @param esfUserESFFederalRolePK the primary key of the e s f user e s f federal role
	* @return the e s f user e s f federal role
	* @throws it.ethica.esf.NoSuchUserESFFederalRoleException if a e s f user e s f federal role with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUserESFFederalRole findByPrimaryKey(
		it.ethica.esf.service.persistence.ESFUserESFFederalRolePK esfUserESFFederalRolePK)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserESFFederalRoleException {
		return getPersistence().findByPrimaryKey(esfUserESFFederalRolePK);
	}

	/**
	* Returns the e s f user e s f federal role with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param esfUserESFFederalRolePK the primary key of the e s f user e s f federal role
	* @return the e s f user e s f federal role, or <code>null</code> if a e s f user e s f federal role with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUserESFFederalRole fetchByPrimaryKey(
		it.ethica.esf.service.persistence.ESFUserESFFederalRolePK esfUserESFFederalRolePK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(esfUserESFFederalRolePK);
	}

	/**
	* Returns all the e s f user e s f federal roles.
	*
	* @return the e s f user e s f federal roles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFUserESFFederalRole> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the e s f user e s f federal roles.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserESFFederalRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f user e s f federal roles
	* @param end the upper bound of the range of e s f user e s f federal roles (not inclusive)
	* @return the range of e s f user e s f federal roles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFUserESFFederalRole> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the e s f user e s f federal roles.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserESFFederalRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f user e s f federal roles
	* @param end the upper bound of the range of e s f user e s f federal roles (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of e s f user e s f federal roles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFUserESFFederalRole> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the e s f user e s f federal roles from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of e s f user e s f federal roles.
	*
	* @return the number of e s f user e s f federal roles
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ESFUserESFFederalRolePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ESFUserESFFederalRolePersistence)PortletBeanLocatorUtil.locate(it.ethica.esf.service.ClpSerializer.getServletContextName(),
					ESFUserESFFederalRolePersistence.class.getName());

			ReferenceRegistry.registerReference(ESFUserESFFederalRoleUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ESFUserESFFederalRolePersistence persistence) {
	}

	private static ESFUserESFFederalRolePersistence _persistence;
}