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

import it.ethica.esf.model.ESFUser;

import java.util.List;

/**
 * The persistence utility for the e s f user service. This utility wraps {@link ESFUserPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFUserPersistence
 * @see ESFUserPersistenceImpl
 * @generated
 */
public class ESFUserUtil {
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
	public static void clearCache(ESFUser esfUser) {
		getPersistence().clearCache(esfUser);
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
	public static List<ESFUser> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ESFUser> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ESFUser> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ESFUser update(ESFUser esfUser) throws SystemException {
		return getPersistence().update(esfUser);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ESFUser update(ESFUser esfUser, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(esfUser, serviceContext);
	}

	/**
	* Returns all the e s f users where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching e s f users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFUser> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the e s f users where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of e s f users
	* @param end the upper bound of the range of e s f users (not inclusive)
	* @return the range of matching e s f users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFUser> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the e s f users where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of e s f users
	* @param end the upper bound of the range of e s f users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFUser> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns the first e s f user in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f user
	* @throws it.ethica.esf.NoSuchUserException if a matching e s f user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUser findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first e s f user in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f user, or <code>null</code> if a matching e s f user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUser fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last e s f user in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f user
	* @throws it.ethica.esf.NoSuchUserException if a matching e s f user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUser findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last e s f user in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f user, or <code>null</code> if a matching e s f user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUser fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the e s f users before and after the current e s f user in the ordered set where uuid = &#63;.
	*
	* @param esfUserId the primary key of the current e s f user
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f user
	* @throws it.ethica.esf.NoSuchUserException if a e s f user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUser[] findByUuid_PrevAndNext(
		long esfUserId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserException {
		return getPersistence()
				   .findByUuid_PrevAndNext(esfUserId, uuid, orderByComparator);
	}

	/**
	* Returns all the e s f users that the user has permission to view where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching e s f users that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFUser> filterFindByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByUuid(uuid);
	}

	/**
	* Returns a range of all the e s f users that the user has permission to view where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of e s f users
	* @param end the upper bound of the range of e s f users (not inclusive)
	* @return the range of matching e s f users that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFUser> filterFindByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the e s f users that the user has permissions to view where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of e s f users
	* @param end the upper bound of the range of e s f users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f users that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFUser> filterFindByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns the e s f users before and after the current e s f user in the ordered set of e s f users that the user has permission to view where uuid = &#63;.
	*
	* @param esfUserId the primary key of the current e s f user
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f user
	* @throws it.ethica.esf.NoSuchUserException if a e s f user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUser[] filterFindByUuid_PrevAndNext(
		long esfUserId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserException {
		return getPersistence()
				   .filterFindByUuid_PrevAndNext(esfUserId, uuid,
			orderByComparator);
	}

	/**
	* Removes all the e s f users where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of e s f users where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching e s f users
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the number of e s f users that the user has permission to view where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching e s f users that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByUuid(uuid);
	}

	/**
	* Returns the e s f user where code = &#63; or throws a {@link it.ethica.esf.NoSuchUserException} if it could not be found.
	*
	* @param code the code
	* @return the matching e s f user
	* @throws it.ethica.esf.NoSuchUserException if a matching e s f user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUser findByCode(java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserException {
		return getPersistence().findByCode(code);
	}

	/**
	* Returns the e s f user where code = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param code the code
	* @return the matching e s f user, or <code>null</code> if a matching e s f user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUser fetchByCode(java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCode(code);
	}

	/**
	* Returns the e s f user where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param code the code
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching e s f user, or <code>null</code> if a matching e s f user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUser fetchByCode(
		java.lang.String code, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCode(code, retrieveFromCache);
	}

	/**
	* Removes the e s f user where code = &#63; from the database.
	*
	* @param code the code
	* @return the e s f user that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUser removeByCode(
		java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserException {
		return getPersistence().removeByCode(code);
	}

	/**
	* Returns the number of e s f users where code = &#63;.
	*
	* @param code the code
	* @return the number of matching e s f users
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCode(java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCode(code);
	}

	/**
	* Returns the e s f user where fiscalCode = &#63; or throws a {@link it.ethica.esf.NoSuchUserException} if it could not be found.
	*
	* @param fiscalCode the fiscal code
	* @return the matching e s f user
	* @throws it.ethica.esf.NoSuchUserException if a matching e s f user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUser findByFiscalCode(
		java.lang.String fiscalCode)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserException {
		return getPersistence().findByFiscalCode(fiscalCode);
	}

	/**
	* Returns the e s f user where fiscalCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param fiscalCode the fiscal code
	* @return the matching e s f user, or <code>null</code> if a matching e s f user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUser fetchByFiscalCode(
		java.lang.String fiscalCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByFiscalCode(fiscalCode);
	}

	/**
	* Returns the e s f user where fiscalCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param fiscalCode the fiscal code
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching e s f user, or <code>null</code> if a matching e s f user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUser fetchByFiscalCode(
		java.lang.String fiscalCode, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByFiscalCode(fiscalCode, retrieveFromCache);
	}

	/**
	* Removes the e s f user where fiscalCode = &#63; from the database.
	*
	* @param fiscalCode the fiscal code
	* @return the e s f user that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUser removeByFiscalCode(
		java.lang.String fiscalCode)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserException {
		return getPersistence().removeByFiscalCode(fiscalCode);
	}

	/**
	* Returns the number of e s f users where fiscalCode = &#63;.
	*
	* @param fiscalCode the fiscal code
	* @return the number of matching e s f users
	* @throws SystemException if a system exception occurred
	*/
	public static int countByFiscalCode(java.lang.String fiscalCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByFiscalCode(fiscalCode);
	}

	/**
	* Returns the e s f user where esfUserId = &#63; or throws a {@link it.ethica.esf.NoSuchUserException} if it could not be found.
	*
	* @param esfUserId the esf user ID
	* @return the matching e s f user
	* @throws it.ethica.esf.NoSuchUserException if a matching e s f user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUser findByUserdId(long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserException {
		return getPersistence().findByUserdId(esfUserId);
	}

	/**
	* Returns the e s f user where esfUserId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param esfUserId the esf user ID
	* @return the matching e s f user, or <code>null</code> if a matching e s f user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUser fetchByUserdId(long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUserdId(esfUserId);
	}

	/**
	* Returns the e s f user where esfUserId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param esfUserId the esf user ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching e s f user, or <code>null</code> if a matching e s f user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUser fetchByUserdId(long esfUserId,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUserdId(esfUserId, retrieveFromCache);
	}

	/**
	* Removes the e s f user where esfUserId = &#63; from the database.
	*
	* @param esfUserId the esf user ID
	* @return the e s f user that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUser removeByUserdId(long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserException {
		return getPersistence().removeByUserdId(esfUserId);
	}

	/**
	* Returns the number of e s f users where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @return the number of matching e s f users
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserdId(long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUserdId(esfUserId);
	}

	/**
	* Returns the e s f user where codeUser = &#63; or throws a {@link it.ethica.esf.NoSuchUserException} if it could not be found.
	*
	* @param codeUser the code user
	* @return the matching e s f user
	* @throws it.ethica.esf.NoSuchUserException if a matching e s f user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUser findByCodeUser(long codeUser)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserException {
		return getPersistence().findByCodeUser(codeUser);
	}

	/**
	* Returns the e s f user where codeUser = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param codeUser the code user
	* @return the matching e s f user, or <code>null</code> if a matching e s f user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUser fetchByCodeUser(long codeUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCodeUser(codeUser);
	}

	/**
	* Returns the e s f user where codeUser = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param codeUser the code user
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching e s f user, or <code>null</code> if a matching e s f user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUser fetchByCodeUser(long codeUser,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCodeUser(codeUser, retrieveFromCache);
	}

	/**
	* Removes the e s f user where codeUser = &#63; from the database.
	*
	* @param codeUser the code user
	* @return the e s f user that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUser removeByCodeUser(long codeUser)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserException {
		return getPersistence().removeByCodeUser(codeUser);
	}

	/**
	* Returns the number of e s f users where codeUser = &#63;.
	*
	* @param codeUser the code user
	* @return the number of matching e s f users
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCodeUser(long codeUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCodeUser(codeUser);
	}

	/**
	* Caches the e s f user in the entity cache if it is enabled.
	*
	* @param esfUser the e s f user
	*/
	public static void cacheResult(it.ethica.esf.model.ESFUser esfUser) {
		getPersistence().cacheResult(esfUser);
	}

	/**
	* Caches the e s f users in the entity cache if it is enabled.
	*
	* @param esfUsers the e s f users
	*/
	public static void cacheResult(
		java.util.List<it.ethica.esf.model.ESFUser> esfUsers) {
		getPersistence().cacheResult(esfUsers);
	}

	/**
	* Creates a new e s f user with the primary key. Does not add the e s f user to the database.
	*
	* @param esfUserId the primary key for the new e s f user
	* @return the new e s f user
	*/
	public static it.ethica.esf.model.ESFUser create(long esfUserId) {
		return getPersistence().create(esfUserId);
	}

	/**
	* Removes the e s f user with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfUserId the primary key of the e s f user
	* @return the e s f user that was removed
	* @throws it.ethica.esf.NoSuchUserException if a e s f user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUser remove(long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserException {
		return getPersistence().remove(esfUserId);
	}

	public static it.ethica.esf.model.ESFUser updateImpl(
		it.ethica.esf.model.ESFUser esfUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(esfUser);
	}

	/**
	* Returns the e s f user with the primary key or throws a {@link it.ethica.esf.NoSuchUserException} if it could not be found.
	*
	* @param esfUserId the primary key of the e s f user
	* @return the e s f user
	* @throws it.ethica.esf.NoSuchUserException if a e s f user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUser findByPrimaryKey(long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserException {
		return getPersistence().findByPrimaryKey(esfUserId);
	}

	/**
	* Returns the e s f user with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param esfUserId the primary key of the e s f user
	* @return the e s f user, or <code>null</code> if a e s f user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUser fetchByPrimaryKey(long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(esfUserId);
	}

	/**
	* Returns all the e s f users.
	*
	* @return the e s f users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFUser> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the e s f users.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f users
	* @param end the upper bound of the range of e s f users (not inclusive)
	* @return the range of e s f users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFUser> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the e s f users.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f users
	* @param end the upper bound of the range of e s f users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of e s f users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFUser> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the e s f users from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of e s f users.
	*
	* @return the number of e s f users
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ESFUserPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ESFUserPersistence)PortletBeanLocatorUtil.locate(it.ethica.esf.service.ClpSerializer.getServletContextName(),
					ESFUserPersistence.class.getName());

			ReferenceRegistry.registerReference(ESFUserUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ESFUserPersistence persistence) {
	}

	private static ESFUserPersistence _persistence;
}