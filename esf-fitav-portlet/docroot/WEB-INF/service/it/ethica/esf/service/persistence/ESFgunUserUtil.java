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

import it.ethica.esf.model.ESFgunUser;

import java.util.List;

/**
 * The persistence utility for the e s fgun user service. This utility wraps {@link ESFgunUserPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFgunUserPersistence
 * @see ESFgunUserPersistenceImpl
 * @generated
 */
public class ESFgunUserUtil {
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
	public static void clearCache(ESFgunUser esFgunUser) {
		getPersistence().clearCache(esFgunUser);
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
	public static List<ESFgunUser> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ESFgunUser> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ESFgunUser> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ESFgunUser update(ESFgunUser esFgunUser)
		throws SystemException {
		return getPersistence().update(esFgunUser);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ESFgunUser update(ESFgunUser esFgunUser,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(esFgunUser, serviceContext);
	}

	/**
	* Returns all the e s fgun users where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @return the matching e s fgun users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFgunUser> findBybyUserId(
		long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBybyUserId(esfUserId);
	}

	/**
	* Returns a range of all the e s fgun users where esfUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFgunUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfUserId the esf user ID
	* @param start the lower bound of the range of e s fgun users
	* @param end the upper bound of the range of e s fgun users (not inclusive)
	* @return the range of matching e s fgun users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFgunUser> findBybyUserId(
		long esfUserId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBybyUserId(esfUserId, start, end);
	}

	/**
	* Returns an ordered range of all the e s fgun users where esfUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFgunUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfUserId the esf user ID
	* @param start the lower bound of the range of e s fgun users
	* @param end the upper bound of the range of e s fgun users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s fgun users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFgunUser> findBybyUserId(
		long esfUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBybyUserId(esfUserId, start, end, orderByComparator);
	}

	/**
	* Returns the first e s fgun user in the ordered set where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s fgun user
	* @throws it.ethica.esf.NoSuchgunUserException if a matching e s fgun user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFgunUser findBybyUserId_First(
		long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchgunUserException {
		return getPersistence()
				   .findBybyUserId_First(esfUserId, orderByComparator);
	}

	/**
	* Returns the first e s fgun user in the ordered set where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s fgun user, or <code>null</code> if a matching e s fgun user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFgunUser fetchBybyUserId_First(
		long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBybyUserId_First(esfUserId, orderByComparator);
	}

	/**
	* Returns the last e s fgun user in the ordered set where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s fgun user
	* @throws it.ethica.esf.NoSuchgunUserException if a matching e s fgun user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFgunUser findBybyUserId_Last(
		long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchgunUserException {
		return getPersistence().findBybyUserId_Last(esfUserId, orderByComparator);
	}

	/**
	* Returns the last e s fgun user in the ordered set where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s fgun user, or <code>null</code> if a matching e s fgun user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFgunUser fetchBybyUserId_Last(
		long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBybyUserId_Last(esfUserId, orderByComparator);
	}

	/**
	* Returns the e s fgun users before and after the current e s fgun user in the ordered set where esfUserId = &#63;.
	*
	* @param esfGunUserId the primary key of the current e s fgun user
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s fgun user
	* @throws it.ethica.esf.NoSuchgunUserException if a e s fgun user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFgunUser[] findBybyUserId_PrevAndNext(
		long esfGunUserId, long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchgunUserException {
		return getPersistence()
				   .findBybyUserId_PrevAndNext(esfGunUserId, esfUserId,
			orderByComparator);
	}

	/**
	* Removes all the e s fgun users where esfUserId = &#63; from the database.
	*
	* @param esfUserId the esf user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBybyUserId(long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBybyUserId(esfUserId);
	}

	/**
	* Returns the number of e s fgun users where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @return the number of matching e s fgun users
	* @throws SystemException if a system exception occurred
	*/
	public static int countBybyUserId(long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBybyUserId(esfUserId);
	}

	/**
	* Returns all the e s fgun users where esfUserId = &#63; and code = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param code the code
	* @return the matching e s fgun users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFgunUser> findBybyU_C(
		long esfUserId, java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBybyU_C(esfUserId, code);
	}

	/**
	* Returns a range of all the e s fgun users where esfUserId = &#63; and code = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFgunUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfUserId the esf user ID
	* @param code the code
	* @param start the lower bound of the range of e s fgun users
	* @param end the upper bound of the range of e s fgun users (not inclusive)
	* @return the range of matching e s fgun users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFgunUser> findBybyU_C(
		long esfUserId, java.lang.String code, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBybyU_C(esfUserId, code, start, end);
	}

	/**
	* Returns an ordered range of all the e s fgun users where esfUserId = &#63; and code = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFgunUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfUserId the esf user ID
	* @param code the code
	* @param start the lower bound of the range of e s fgun users
	* @param end the upper bound of the range of e s fgun users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s fgun users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFgunUser> findBybyU_C(
		long esfUserId, java.lang.String code, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBybyU_C(esfUserId, code, start, end, orderByComparator);
	}

	/**
	* Returns the first e s fgun user in the ordered set where esfUserId = &#63; and code = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param code the code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s fgun user
	* @throws it.ethica.esf.NoSuchgunUserException if a matching e s fgun user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFgunUser findBybyU_C_First(
		long esfUserId, java.lang.String code,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchgunUserException {
		return getPersistence()
				   .findBybyU_C_First(esfUserId, code, orderByComparator);
	}

	/**
	* Returns the first e s fgun user in the ordered set where esfUserId = &#63; and code = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param code the code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s fgun user, or <code>null</code> if a matching e s fgun user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFgunUser fetchBybyU_C_First(
		long esfUserId, java.lang.String code,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBybyU_C_First(esfUserId, code, orderByComparator);
	}

	/**
	* Returns the last e s fgun user in the ordered set where esfUserId = &#63; and code = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param code the code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s fgun user
	* @throws it.ethica.esf.NoSuchgunUserException if a matching e s fgun user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFgunUser findBybyU_C_Last(
		long esfUserId, java.lang.String code,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchgunUserException {
		return getPersistence()
				   .findBybyU_C_Last(esfUserId, code, orderByComparator);
	}

	/**
	* Returns the last e s fgun user in the ordered set where esfUserId = &#63; and code = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param code the code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s fgun user, or <code>null</code> if a matching e s fgun user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFgunUser fetchBybyU_C_Last(
		long esfUserId, java.lang.String code,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBybyU_C_Last(esfUserId, code, orderByComparator);
	}

	/**
	* Returns the e s fgun users before and after the current e s fgun user in the ordered set where esfUserId = &#63; and code = &#63;.
	*
	* @param esfGunUserId the primary key of the current e s fgun user
	* @param esfUserId the esf user ID
	* @param code the code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s fgun user
	* @throws it.ethica.esf.NoSuchgunUserException if a e s fgun user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFgunUser[] findBybyU_C_PrevAndNext(
		long esfGunUserId, long esfUserId, java.lang.String code,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchgunUserException {
		return getPersistence()
				   .findBybyU_C_PrevAndNext(esfGunUserId, esfUserId, code,
			orderByComparator);
	}

	/**
	* Removes all the e s fgun users where esfUserId = &#63; and code = &#63; from the database.
	*
	* @param esfUserId the esf user ID
	* @param code the code
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBybyU_C(long esfUserId, java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBybyU_C(esfUserId, code);
	}

	/**
	* Returns the number of e s fgun users where esfUserId = &#63; and code = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param code the code
	* @return the number of matching e s fgun users
	* @throws SystemException if a system exception occurred
	*/
	public static int countBybyU_C(long esfUserId, java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBybyU_C(esfUserId, code);
	}

	/**
	* Returns all the e s fgun users where esfUserId = &#63; and type = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param type the type
	* @return the matching e s fgun users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFgunUser> findBybyU_T(
		long esfUserId, int type)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBybyU_T(esfUserId, type);
	}

	/**
	* Returns a range of all the e s fgun users where esfUserId = &#63; and type = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFgunUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfUserId the esf user ID
	* @param type the type
	* @param start the lower bound of the range of e s fgun users
	* @param end the upper bound of the range of e s fgun users (not inclusive)
	* @return the range of matching e s fgun users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFgunUser> findBybyU_T(
		long esfUserId, int type, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBybyU_T(esfUserId, type, start, end);
	}

	/**
	* Returns an ordered range of all the e s fgun users where esfUserId = &#63; and type = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFgunUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfUserId the esf user ID
	* @param type the type
	* @param start the lower bound of the range of e s fgun users
	* @param end the upper bound of the range of e s fgun users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s fgun users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFgunUser> findBybyU_T(
		long esfUserId, int type, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBybyU_T(esfUserId, type, start, end, orderByComparator);
	}

	/**
	* Returns the first e s fgun user in the ordered set where esfUserId = &#63; and type = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s fgun user
	* @throws it.ethica.esf.NoSuchgunUserException if a matching e s fgun user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFgunUser findBybyU_T_First(
		long esfUserId, int type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchgunUserException {
		return getPersistence()
				   .findBybyU_T_First(esfUserId, type, orderByComparator);
	}

	/**
	* Returns the first e s fgun user in the ordered set where esfUserId = &#63; and type = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s fgun user, or <code>null</code> if a matching e s fgun user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFgunUser fetchBybyU_T_First(
		long esfUserId, int type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBybyU_T_First(esfUserId, type, orderByComparator);
	}

	/**
	* Returns the last e s fgun user in the ordered set where esfUserId = &#63; and type = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s fgun user
	* @throws it.ethica.esf.NoSuchgunUserException if a matching e s fgun user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFgunUser findBybyU_T_Last(
		long esfUserId, int type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchgunUserException {
		return getPersistence()
				   .findBybyU_T_Last(esfUserId, type, orderByComparator);
	}

	/**
	* Returns the last e s fgun user in the ordered set where esfUserId = &#63; and type = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s fgun user, or <code>null</code> if a matching e s fgun user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFgunUser fetchBybyU_T_Last(
		long esfUserId, int type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBybyU_T_Last(esfUserId, type, orderByComparator);
	}

	/**
	* Returns the e s fgun users before and after the current e s fgun user in the ordered set where esfUserId = &#63; and type = &#63;.
	*
	* @param esfGunUserId the primary key of the current e s fgun user
	* @param esfUserId the esf user ID
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s fgun user
	* @throws it.ethica.esf.NoSuchgunUserException if a e s fgun user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFgunUser[] findBybyU_T_PrevAndNext(
		long esfGunUserId, long esfUserId, int type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchgunUserException {
		return getPersistence()
				   .findBybyU_T_PrevAndNext(esfGunUserId, esfUserId, type,
			orderByComparator);
	}

	/**
	* Removes all the e s fgun users where esfUserId = &#63; and type = &#63; from the database.
	*
	* @param esfUserId the esf user ID
	* @param type the type
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBybyU_T(long esfUserId, int type)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBybyU_T(esfUserId, type);
	}

	/**
	* Returns the number of e s fgun users where esfUserId = &#63; and type = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param type the type
	* @return the number of matching e s fgun users
	* @throws SystemException if a system exception occurred
	*/
	public static int countBybyU_T(long esfUserId, int type)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBybyU_T(esfUserId, type);
	}

	/**
	* Returns all the e s fgun users where type = &#63;.
	*
	* @param type the type
	* @return the matching e s fgun users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFgunUser> findBybyT(
		int type) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBybyT(type);
	}

	/**
	* Returns a range of all the e s fgun users where type = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFgunUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param type the type
	* @param start the lower bound of the range of e s fgun users
	* @param end the upper bound of the range of e s fgun users (not inclusive)
	* @return the range of matching e s fgun users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFgunUser> findBybyT(
		int type, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBybyT(type, start, end);
	}

	/**
	* Returns an ordered range of all the e s fgun users where type = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFgunUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param type the type
	* @param start the lower bound of the range of e s fgun users
	* @param end the upper bound of the range of e s fgun users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s fgun users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFgunUser> findBybyT(
		int type, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBybyT(type, start, end, orderByComparator);
	}

	/**
	* Returns the first e s fgun user in the ordered set where type = &#63;.
	*
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s fgun user
	* @throws it.ethica.esf.NoSuchgunUserException if a matching e s fgun user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFgunUser findBybyT_First(int type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchgunUserException {
		return getPersistence().findBybyT_First(type, orderByComparator);
	}

	/**
	* Returns the first e s fgun user in the ordered set where type = &#63;.
	*
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s fgun user, or <code>null</code> if a matching e s fgun user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFgunUser fetchBybyT_First(int type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchBybyT_First(type, orderByComparator);
	}

	/**
	* Returns the last e s fgun user in the ordered set where type = &#63;.
	*
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s fgun user
	* @throws it.ethica.esf.NoSuchgunUserException if a matching e s fgun user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFgunUser findBybyT_Last(int type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchgunUserException {
		return getPersistence().findBybyT_Last(type, orderByComparator);
	}

	/**
	* Returns the last e s fgun user in the ordered set where type = &#63;.
	*
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s fgun user, or <code>null</code> if a matching e s fgun user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFgunUser fetchBybyT_Last(int type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchBybyT_Last(type, orderByComparator);
	}

	/**
	* Returns the e s fgun users before and after the current e s fgun user in the ordered set where type = &#63;.
	*
	* @param esfGunUserId the primary key of the current e s fgun user
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s fgun user
	* @throws it.ethica.esf.NoSuchgunUserException if a e s fgun user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFgunUser[] findBybyT_PrevAndNext(
		long esfGunUserId, int type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchgunUserException {
		return getPersistence()
				   .findBybyT_PrevAndNext(esfGunUserId, type, orderByComparator);
	}

	/**
	* Removes all the e s fgun users where type = &#63; from the database.
	*
	* @param type the type
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBybyT(int type)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBybyT(type);
	}

	/**
	* Returns the number of e s fgun users where type = &#63;.
	*
	* @param type the type
	* @return the number of matching e s fgun users
	* @throws SystemException if a system exception occurred
	*/
	public static int countBybyT(int type)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBybyT(type);
	}

	/**
	* Returns all the e s fgun users where esfGunId = &#63;.
	*
	* @param esfGunId the esf gun ID
	* @return the matching e s fgun users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFgunUser> findBybyGunId(
		long esfGunId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBybyGunId(esfGunId);
	}

	/**
	* Returns a range of all the e s fgun users where esfGunId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFgunUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfGunId the esf gun ID
	* @param start the lower bound of the range of e s fgun users
	* @param end the upper bound of the range of e s fgun users (not inclusive)
	* @return the range of matching e s fgun users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFgunUser> findBybyGunId(
		long esfGunId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBybyGunId(esfGunId, start, end);
	}

	/**
	* Returns an ordered range of all the e s fgun users where esfGunId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFgunUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfGunId the esf gun ID
	* @param start the lower bound of the range of e s fgun users
	* @param end the upper bound of the range of e s fgun users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s fgun users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFgunUser> findBybyGunId(
		long esfGunId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBybyGunId(esfGunId, start, end, orderByComparator);
	}

	/**
	* Returns the first e s fgun user in the ordered set where esfGunId = &#63;.
	*
	* @param esfGunId the esf gun ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s fgun user
	* @throws it.ethica.esf.NoSuchgunUserException if a matching e s fgun user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFgunUser findBybyGunId_First(
		long esfGunId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchgunUserException {
		return getPersistence().findBybyGunId_First(esfGunId, orderByComparator);
	}

	/**
	* Returns the first e s fgun user in the ordered set where esfGunId = &#63;.
	*
	* @param esfGunId the esf gun ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s fgun user, or <code>null</code> if a matching e s fgun user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFgunUser fetchBybyGunId_First(
		long esfGunId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchBybyGunId_First(esfGunId, orderByComparator);
	}

	/**
	* Returns the last e s fgun user in the ordered set where esfGunId = &#63;.
	*
	* @param esfGunId the esf gun ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s fgun user
	* @throws it.ethica.esf.NoSuchgunUserException if a matching e s fgun user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFgunUser findBybyGunId_Last(
		long esfGunId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchgunUserException {
		return getPersistence().findBybyGunId_Last(esfGunId, orderByComparator);
	}

	/**
	* Returns the last e s fgun user in the ordered set where esfGunId = &#63;.
	*
	* @param esfGunId the esf gun ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s fgun user, or <code>null</code> if a matching e s fgun user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFgunUser fetchBybyGunId_Last(
		long esfGunId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchBybyGunId_Last(esfGunId, orderByComparator);
	}

	/**
	* Returns the e s fgun users before and after the current e s fgun user in the ordered set where esfGunId = &#63;.
	*
	* @param esfGunUserId the primary key of the current e s fgun user
	* @param esfGunId the esf gun ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s fgun user
	* @throws it.ethica.esf.NoSuchgunUserException if a e s fgun user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFgunUser[] findBybyGunId_PrevAndNext(
		long esfGunUserId, long esfGunId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchgunUserException {
		return getPersistence()
				   .findBybyGunId_PrevAndNext(esfGunUserId, esfGunId,
			orderByComparator);
	}

	/**
	* Removes all the e s fgun users where esfGunId = &#63; from the database.
	*
	* @param esfGunId the esf gun ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBybyGunId(long esfGunId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBybyGunId(esfGunId);
	}

	/**
	* Returns the number of e s fgun users where esfGunId = &#63;.
	*
	* @param esfGunId the esf gun ID
	* @return the number of matching e s fgun users
	* @throws SystemException if a system exception occurred
	*/
	public static int countBybyGunId(long esfGunId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBybyGunId(esfGunId);
	}

	/**
	* Returns all the e s fgun users where code = &#63;.
	*
	* @param code the code
	* @return the matching e s fgun users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFgunUser> findByCode(
		java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCode(code);
	}

	/**
	* Returns a range of all the e s fgun users where code = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFgunUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param code the code
	* @param start the lower bound of the range of e s fgun users
	* @param end the upper bound of the range of e s fgun users (not inclusive)
	* @return the range of matching e s fgun users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFgunUser> findByCode(
		java.lang.String code, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCode(code, start, end);
	}

	/**
	* Returns an ordered range of all the e s fgun users where code = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFgunUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param code the code
	* @param start the lower bound of the range of e s fgun users
	* @param end the upper bound of the range of e s fgun users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s fgun users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFgunUser> findByCode(
		java.lang.String code, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCode(code, start, end, orderByComparator);
	}

	/**
	* Returns the first e s fgun user in the ordered set where code = &#63;.
	*
	* @param code the code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s fgun user
	* @throws it.ethica.esf.NoSuchgunUserException if a matching e s fgun user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFgunUser findByCode_First(
		java.lang.String code,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchgunUserException {
		return getPersistence().findByCode_First(code, orderByComparator);
	}

	/**
	* Returns the first e s fgun user in the ordered set where code = &#63;.
	*
	* @param code the code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s fgun user, or <code>null</code> if a matching e s fgun user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFgunUser fetchByCode_First(
		java.lang.String code,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCode_First(code, orderByComparator);
	}

	/**
	* Returns the last e s fgun user in the ordered set where code = &#63;.
	*
	* @param code the code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s fgun user
	* @throws it.ethica.esf.NoSuchgunUserException if a matching e s fgun user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFgunUser findByCode_Last(
		java.lang.String code,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchgunUserException {
		return getPersistence().findByCode_Last(code, orderByComparator);
	}

	/**
	* Returns the last e s fgun user in the ordered set where code = &#63;.
	*
	* @param code the code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s fgun user, or <code>null</code> if a matching e s fgun user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFgunUser fetchByCode_Last(
		java.lang.String code,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCode_Last(code, orderByComparator);
	}

	/**
	* Returns the e s fgun users before and after the current e s fgun user in the ordered set where code = &#63;.
	*
	* @param esfGunUserId the primary key of the current e s fgun user
	* @param code the code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s fgun user
	* @throws it.ethica.esf.NoSuchgunUserException if a e s fgun user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFgunUser[] findByCode_PrevAndNext(
		long esfGunUserId, java.lang.String code,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchgunUserException {
		return getPersistence()
				   .findByCode_PrevAndNext(esfGunUserId, code, orderByComparator);
	}

	/**
	* Removes all the e s fgun users where code = &#63; from the database.
	*
	* @param code the code
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCode(java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCode(code);
	}

	/**
	* Returns the number of e s fgun users where code = &#63;.
	*
	* @param code the code
	* @return the number of matching e s fgun users
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCode(java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCode(code);
	}

	/**
	* Returns all the e s fgun users where esfGunId = &#63; and type = &#63;.
	*
	* @param esfGunId the esf gun ID
	* @param type the type
	* @return the matching e s fgun users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFgunUser> findByGunId_Type(
		long esfGunId, int type)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGunId_Type(esfGunId, type);
	}

	/**
	* Returns a range of all the e s fgun users where esfGunId = &#63; and type = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFgunUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfGunId the esf gun ID
	* @param type the type
	* @param start the lower bound of the range of e s fgun users
	* @param end the upper bound of the range of e s fgun users (not inclusive)
	* @return the range of matching e s fgun users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFgunUser> findByGunId_Type(
		long esfGunId, int type, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGunId_Type(esfGunId, type, start, end);
	}

	/**
	* Returns an ordered range of all the e s fgun users where esfGunId = &#63; and type = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFgunUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfGunId the esf gun ID
	* @param type the type
	* @param start the lower bound of the range of e s fgun users
	* @param end the upper bound of the range of e s fgun users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s fgun users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFgunUser> findByGunId_Type(
		long esfGunId, int type, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGunId_Type(esfGunId, type, start, end,
			orderByComparator);
	}

	/**
	* Returns the first e s fgun user in the ordered set where esfGunId = &#63; and type = &#63;.
	*
	* @param esfGunId the esf gun ID
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s fgun user
	* @throws it.ethica.esf.NoSuchgunUserException if a matching e s fgun user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFgunUser findByGunId_Type_First(
		long esfGunId, int type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchgunUserException {
		return getPersistence()
				   .findByGunId_Type_First(esfGunId, type, orderByComparator);
	}

	/**
	* Returns the first e s fgun user in the ordered set where esfGunId = &#63; and type = &#63;.
	*
	* @param esfGunId the esf gun ID
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s fgun user, or <code>null</code> if a matching e s fgun user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFgunUser fetchByGunId_Type_First(
		long esfGunId, int type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByGunId_Type_First(esfGunId, type, orderByComparator);
	}

	/**
	* Returns the last e s fgun user in the ordered set where esfGunId = &#63; and type = &#63;.
	*
	* @param esfGunId the esf gun ID
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s fgun user
	* @throws it.ethica.esf.NoSuchgunUserException if a matching e s fgun user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFgunUser findByGunId_Type_Last(
		long esfGunId, int type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchgunUserException {
		return getPersistence()
				   .findByGunId_Type_Last(esfGunId, type, orderByComparator);
	}

	/**
	* Returns the last e s fgun user in the ordered set where esfGunId = &#63; and type = &#63;.
	*
	* @param esfGunId the esf gun ID
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s fgun user, or <code>null</code> if a matching e s fgun user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFgunUser fetchByGunId_Type_Last(
		long esfGunId, int type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByGunId_Type_Last(esfGunId, type, orderByComparator);
	}

	/**
	* Returns the e s fgun users before and after the current e s fgun user in the ordered set where esfGunId = &#63; and type = &#63;.
	*
	* @param esfGunUserId the primary key of the current e s fgun user
	* @param esfGunId the esf gun ID
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s fgun user
	* @throws it.ethica.esf.NoSuchgunUserException if a e s fgun user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFgunUser[] findByGunId_Type_PrevAndNext(
		long esfGunUserId, long esfGunId, int type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchgunUserException {
		return getPersistence()
				   .findByGunId_Type_PrevAndNext(esfGunUserId, esfGunId, type,
			orderByComparator);
	}

	/**
	* Removes all the e s fgun users where esfGunId = &#63; and type = &#63; from the database.
	*
	* @param esfGunId the esf gun ID
	* @param type the type
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGunId_Type(long esfGunId, int type)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGunId_Type(esfGunId, type);
	}

	/**
	* Returns the number of e s fgun users where esfGunId = &#63; and type = &#63;.
	*
	* @param esfGunId the esf gun ID
	* @param type the type
	* @return the number of matching e s fgun users
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGunId_Type(long esfGunId, int type)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGunId_Type(esfGunId, type);
	}

	/**
	* Caches the e s fgun user in the entity cache if it is enabled.
	*
	* @param esFgunUser the e s fgun user
	*/
	public static void cacheResult(it.ethica.esf.model.ESFgunUser esFgunUser) {
		getPersistence().cacheResult(esFgunUser);
	}

	/**
	* Caches the e s fgun users in the entity cache if it is enabled.
	*
	* @param esFgunUsers the e s fgun users
	*/
	public static void cacheResult(
		java.util.List<it.ethica.esf.model.ESFgunUser> esFgunUsers) {
		getPersistence().cacheResult(esFgunUsers);
	}

	/**
	* Creates a new e s fgun user with the primary key. Does not add the e s fgun user to the database.
	*
	* @param esfGunUserId the primary key for the new e s fgun user
	* @return the new e s fgun user
	*/
	public static it.ethica.esf.model.ESFgunUser create(long esfGunUserId) {
		return getPersistence().create(esfGunUserId);
	}

	/**
	* Removes the e s fgun user with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfGunUserId the primary key of the e s fgun user
	* @return the e s fgun user that was removed
	* @throws it.ethica.esf.NoSuchgunUserException if a e s fgun user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFgunUser remove(long esfGunUserId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchgunUserException {
		return getPersistence().remove(esfGunUserId);
	}

	public static it.ethica.esf.model.ESFgunUser updateImpl(
		it.ethica.esf.model.ESFgunUser esFgunUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(esFgunUser);
	}

	/**
	* Returns the e s fgun user with the primary key or throws a {@link it.ethica.esf.NoSuchgunUserException} if it could not be found.
	*
	* @param esfGunUserId the primary key of the e s fgun user
	* @return the e s fgun user
	* @throws it.ethica.esf.NoSuchgunUserException if a e s fgun user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFgunUser findByPrimaryKey(
		long esfGunUserId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchgunUserException {
		return getPersistence().findByPrimaryKey(esfGunUserId);
	}

	/**
	* Returns the e s fgun user with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param esfGunUserId the primary key of the e s fgun user
	* @return the e s fgun user, or <code>null</code> if a e s fgun user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFgunUser fetchByPrimaryKey(
		long esfGunUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(esfGunUserId);
	}

	/**
	* Returns all the e s fgun users.
	*
	* @return the e s fgun users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFgunUser> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the e s fgun users.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFgunUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s fgun users
	* @param end the upper bound of the range of e s fgun users (not inclusive)
	* @return the range of e s fgun users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFgunUser> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the e s fgun users.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFgunUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s fgun users
	* @param end the upper bound of the range of e s fgun users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of e s fgun users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFgunUser> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the e s fgun users from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of e s fgun users.
	*
	* @return the number of e s fgun users
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ESFgunUserPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ESFgunUserPersistence)PortletBeanLocatorUtil.locate(it.ethica.esf.service.ClpSerializer.getServletContextName(),
					ESFgunUserPersistence.class.getName());

			ReferenceRegistry.registerReference(ESFgunUserUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ESFgunUserPersistence persistence) {
	}

	private static ESFgunUserPersistence _persistence;
}