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

import com.liferay.portal.service.persistence.BasePersistence;

import it.ethica.esf.model.ESFgunUser;

/**
 * The persistence interface for the e s fgun user service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFgunUserPersistenceImpl
 * @see ESFgunUserUtil
 * @generated
 */
public interface ESFgunUserPersistence extends BasePersistence<ESFgunUser> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ESFgunUserUtil} to access the e s fgun user persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the e s fgun users where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @return the matching e s fgun users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFgunUser> findBybyUserId(
		long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.ethica.esf.model.ESFgunUser> findBybyUserId(
		long esfUserId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.ethica.esf.model.ESFgunUser> findBybyUserId(
		long esfUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s fgun user in the ordered set where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s fgun user
	* @throws it.ethica.esf.NoSuchgunUserException if a matching e s fgun user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFgunUser findBybyUserId_First(long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchgunUserException;

	/**
	* Returns the first e s fgun user in the ordered set where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s fgun user, or <code>null</code> if a matching e s fgun user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFgunUser fetchBybyUserId_First(
		long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s fgun user in the ordered set where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s fgun user
	* @throws it.ethica.esf.NoSuchgunUserException if a matching e s fgun user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFgunUser findBybyUserId_Last(long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchgunUserException;

	/**
	* Returns the last e s fgun user in the ordered set where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s fgun user, or <code>null</code> if a matching e s fgun user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFgunUser fetchBybyUserId_Last(long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public it.ethica.esf.model.ESFgunUser[] findBybyUserId_PrevAndNext(
		long esfGunUserId, long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchgunUserException;

	/**
	* Removes all the e s fgun users where esfUserId = &#63; from the database.
	*
	* @param esfUserId the esf user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeBybyUserId(long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s fgun users where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @return the number of matching e s fgun users
	* @throws SystemException if a system exception occurred
	*/
	public int countBybyUserId(long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s fgun users where esfUserId = &#63; and code = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param code the code
	* @return the matching e s fgun users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFgunUser> findBybyU_C(
		long esfUserId, java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.ethica.esf.model.ESFgunUser> findBybyU_C(
		long esfUserId, java.lang.String code, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.ethica.esf.model.ESFgunUser> findBybyU_C(
		long esfUserId, java.lang.String code, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public it.ethica.esf.model.ESFgunUser findBybyU_C_First(long esfUserId,
		java.lang.String code,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchgunUserException;

	/**
	* Returns the first e s fgun user in the ordered set where esfUserId = &#63; and code = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param code the code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s fgun user, or <code>null</code> if a matching e s fgun user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFgunUser fetchBybyU_C_First(long esfUserId,
		java.lang.String code,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public it.ethica.esf.model.ESFgunUser findBybyU_C_Last(long esfUserId,
		java.lang.String code,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchgunUserException;

	/**
	* Returns the last e s fgun user in the ordered set where esfUserId = &#63; and code = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param code the code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s fgun user, or <code>null</code> if a matching e s fgun user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFgunUser fetchBybyU_C_Last(long esfUserId,
		java.lang.String code,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public it.ethica.esf.model.ESFgunUser[] findBybyU_C_PrevAndNext(
		long esfGunUserId, long esfUserId, java.lang.String code,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchgunUserException;

	/**
	* Removes all the e s fgun users where esfUserId = &#63; and code = &#63; from the database.
	*
	* @param esfUserId the esf user ID
	* @param code the code
	* @throws SystemException if a system exception occurred
	*/
	public void removeBybyU_C(long esfUserId, java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s fgun users where esfUserId = &#63; and code = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param code the code
	* @return the number of matching e s fgun users
	* @throws SystemException if a system exception occurred
	*/
	public int countBybyU_C(long esfUserId, java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s fgun users where esfUserId = &#63; and type = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param type the type
	* @return the matching e s fgun users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFgunUser> findBybyU_T(
		long esfUserId, int type)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.ethica.esf.model.ESFgunUser> findBybyU_T(
		long esfUserId, int type, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.ethica.esf.model.ESFgunUser> findBybyU_T(
		long esfUserId, int type, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public it.ethica.esf.model.ESFgunUser findBybyU_T_First(long esfUserId,
		int type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchgunUserException;

	/**
	* Returns the first e s fgun user in the ordered set where esfUserId = &#63; and type = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s fgun user, or <code>null</code> if a matching e s fgun user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFgunUser fetchBybyU_T_First(long esfUserId,
		int type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public it.ethica.esf.model.ESFgunUser findBybyU_T_Last(long esfUserId,
		int type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchgunUserException;

	/**
	* Returns the last e s fgun user in the ordered set where esfUserId = &#63; and type = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s fgun user, or <code>null</code> if a matching e s fgun user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFgunUser fetchBybyU_T_Last(long esfUserId,
		int type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public it.ethica.esf.model.ESFgunUser[] findBybyU_T_PrevAndNext(
		long esfGunUserId, long esfUserId, int type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchgunUserException;

	/**
	* Removes all the e s fgun users where esfUserId = &#63; and type = &#63; from the database.
	*
	* @param esfUserId the esf user ID
	* @param type the type
	* @throws SystemException if a system exception occurred
	*/
	public void removeBybyU_T(long esfUserId, int type)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s fgun users where esfUserId = &#63; and type = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param type the type
	* @return the number of matching e s fgun users
	* @throws SystemException if a system exception occurred
	*/
	public int countBybyU_T(long esfUserId, int type)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s fgun users where type = &#63;.
	*
	* @param type the type
	* @return the matching e s fgun users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFgunUser> findBybyT(int type)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.ethica.esf.model.ESFgunUser> findBybyT(int type,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.ethica.esf.model.ESFgunUser> findBybyT(int type,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s fgun user in the ordered set where type = &#63;.
	*
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s fgun user
	* @throws it.ethica.esf.NoSuchgunUserException if a matching e s fgun user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFgunUser findBybyT_First(int type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchgunUserException;

	/**
	* Returns the first e s fgun user in the ordered set where type = &#63;.
	*
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s fgun user, or <code>null</code> if a matching e s fgun user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFgunUser fetchBybyT_First(int type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s fgun user in the ordered set where type = &#63;.
	*
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s fgun user
	* @throws it.ethica.esf.NoSuchgunUserException if a matching e s fgun user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFgunUser findBybyT_Last(int type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchgunUserException;

	/**
	* Returns the last e s fgun user in the ordered set where type = &#63;.
	*
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s fgun user, or <code>null</code> if a matching e s fgun user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFgunUser fetchBybyT_Last(int type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public it.ethica.esf.model.ESFgunUser[] findBybyT_PrevAndNext(
		long esfGunUserId, int type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchgunUserException;

	/**
	* Removes all the e s fgun users where type = &#63; from the database.
	*
	* @param type the type
	* @throws SystemException if a system exception occurred
	*/
	public void removeBybyT(int type)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s fgun users where type = &#63;.
	*
	* @param type the type
	* @return the number of matching e s fgun users
	* @throws SystemException if a system exception occurred
	*/
	public int countBybyT(int type)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s fgun users where esfGunId = &#63;.
	*
	* @param esfGunId the esf gun ID
	* @return the matching e s fgun users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFgunUser> findBybyGunId(
		long esfGunId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.ethica.esf.model.ESFgunUser> findBybyGunId(
		long esfGunId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.ethica.esf.model.ESFgunUser> findBybyGunId(
		long esfGunId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s fgun user in the ordered set where esfGunId = &#63;.
	*
	* @param esfGunId the esf gun ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s fgun user
	* @throws it.ethica.esf.NoSuchgunUserException if a matching e s fgun user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFgunUser findBybyGunId_First(long esfGunId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchgunUserException;

	/**
	* Returns the first e s fgun user in the ordered set where esfGunId = &#63;.
	*
	* @param esfGunId the esf gun ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s fgun user, or <code>null</code> if a matching e s fgun user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFgunUser fetchBybyGunId_First(long esfGunId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s fgun user in the ordered set where esfGunId = &#63;.
	*
	* @param esfGunId the esf gun ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s fgun user
	* @throws it.ethica.esf.NoSuchgunUserException if a matching e s fgun user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFgunUser findBybyGunId_Last(long esfGunId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchgunUserException;

	/**
	* Returns the last e s fgun user in the ordered set where esfGunId = &#63;.
	*
	* @param esfGunId the esf gun ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s fgun user, or <code>null</code> if a matching e s fgun user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFgunUser fetchBybyGunId_Last(long esfGunId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public it.ethica.esf.model.ESFgunUser[] findBybyGunId_PrevAndNext(
		long esfGunUserId, long esfGunId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchgunUserException;

	/**
	* Removes all the e s fgun users where esfGunId = &#63; from the database.
	*
	* @param esfGunId the esf gun ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeBybyGunId(long esfGunId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s fgun users where esfGunId = &#63;.
	*
	* @param esfGunId the esf gun ID
	* @return the number of matching e s fgun users
	* @throws SystemException if a system exception occurred
	*/
	public int countBybyGunId(long esfGunId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s fgun users where code = &#63;.
	*
	* @param code the code
	* @return the matching e s fgun users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFgunUser> findByCode(
		java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.ethica.esf.model.ESFgunUser> findByCode(
		java.lang.String code, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.ethica.esf.model.ESFgunUser> findByCode(
		java.lang.String code, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s fgun user in the ordered set where code = &#63;.
	*
	* @param code the code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s fgun user
	* @throws it.ethica.esf.NoSuchgunUserException if a matching e s fgun user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFgunUser findByCode_First(
		java.lang.String code,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchgunUserException;

	/**
	* Returns the first e s fgun user in the ordered set where code = &#63;.
	*
	* @param code the code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s fgun user, or <code>null</code> if a matching e s fgun user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFgunUser fetchByCode_First(
		java.lang.String code,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s fgun user in the ordered set where code = &#63;.
	*
	* @param code the code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s fgun user
	* @throws it.ethica.esf.NoSuchgunUserException if a matching e s fgun user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFgunUser findByCode_Last(
		java.lang.String code,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchgunUserException;

	/**
	* Returns the last e s fgun user in the ordered set where code = &#63;.
	*
	* @param code the code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s fgun user, or <code>null</code> if a matching e s fgun user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFgunUser fetchByCode_Last(
		java.lang.String code,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public it.ethica.esf.model.ESFgunUser[] findByCode_PrevAndNext(
		long esfGunUserId, java.lang.String code,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchgunUserException;

	/**
	* Removes all the e s fgun users where code = &#63; from the database.
	*
	* @param code the code
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCode(java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s fgun users where code = &#63;.
	*
	* @param code the code
	* @return the number of matching e s fgun users
	* @throws SystemException if a system exception occurred
	*/
	public int countByCode(java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s fgun users where esfGunId = &#63; and type = &#63;.
	*
	* @param esfGunId the esf gun ID
	* @param type the type
	* @return the matching e s fgun users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFgunUser> findByGunId_Type(
		long esfGunId, int type)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.ethica.esf.model.ESFgunUser> findByGunId_Type(
		long esfGunId, int type, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.ethica.esf.model.ESFgunUser> findByGunId_Type(
		long esfGunId, int type, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public it.ethica.esf.model.ESFgunUser findByGunId_Type_First(
		long esfGunId, int type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchgunUserException;

	/**
	* Returns the first e s fgun user in the ordered set where esfGunId = &#63; and type = &#63;.
	*
	* @param esfGunId the esf gun ID
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s fgun user, or <code>null</code> if a matching e s fgun user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFgunUser fetchByGunId_Type_First(
		long esfGunId, int type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public it.ethica.esf.model.ESFgunUser findByGunId_Type_Last(long esfGunId,
		int type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchgunUserException;

	/**
	* Returns the last e s fgun user in the ordered set where esfGunId = &#63; and type = &#63;.
	*
	* @param esfGunId the esf gun ID
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s fgun user, or <code>null</code> if a matching e s fgun user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFgunUser fetchByGunId_Type_Last(
		long esfGunId, int type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public it.ethica.esf.model.ESFgunUser[] findByGunId_Type_PrevAndNext(
		long esfGunUserId, long esfGunId, int type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchgunUserException;

	/**
	* Removes all the e s fgun users where esfGunId = &#63; and type = &#63; from the database.
	*
	* @param esfGunId the esf gun ID
	* @param type the type
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGunId_Type(long esfGunId, int type)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s fgun users where esfGunId = &#63; and type = &#63;.
	*
	* @param esfGunId the esf gun ID
	* @param type the type
	* @return the number of matching e s fgun users
	* @throws SystemException if a system exception occurred
	*/
	public int countByGunId_Type(long esfGunId, int type)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the e s fgun user in the entity cache if it is enabled.
	*
	* @param esFgunUser the e s fgun user
	*/
	public void cacheResult(it.ethica.esf.model.ESFgunUser esFgunUser);

	/**
	* Caches the e s fgun users in the entity cache if it is enabled.
	*
	* @param esFgunUsers the e s fgun users
	*/
	public void cacheResult(
		java.util.List<it.ethica.esf.model.ESFgunUser> esFgunUsers);

	/**
	* Creates a new e s fgun user with the primary key. Does not add the e s fgun user to the database.
	*
	* @param esfGunUserId the primary key for the new e s fgun user
	* @return the new e s fgun user
	*/
	public it.ethica.esf.model.ESFgunUser create(long esfGunUserId);

	/**
	* Removes the e s fgun user with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfGunUserId the primary key of the e s fgun user
	* @return the e s fgun user that was removed
	* @throws it.ethica.esf.NoSuchgunUserException if a e s fgun user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFgunUser remove(long esfGunUserId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchgunUserException;

	public it.ethica.esf.model.ESFgunUser updateImpl(
		it.ethica.esf.model.ESFgunUser esFgunUser)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s fgun user with the primary key or throws a {@link it.ethica.esf.NoSuchgunUserException} if it could not be found.
	*
	* @param esfGunUserId the primary key of the e s fgun user
	* @return the e s fgun user
	* @throws it.ethica.esf.NoSuchgunUserException if a e s fgun user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFgunUser findByPrimaryKey(long esfGunUserId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchgunUserException;

	/**
	* Returns the e s fgun user with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param esfGunUserId the primary key of the e s fgun user
	* @return the e s fgun user, or <code>null</code> if a e s fgun user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFgunUser fetchByPrimaryKey(long esfGunUserId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s fgun users.
	*
	* @return the e s fgun users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFgunUser> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.ethica.esf.model.ESFgunUser> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.ethica.esf.model.ESFgunUser> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the e s fgun users from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s fgun users.
	*
	* @return the number of e s fgun users
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}