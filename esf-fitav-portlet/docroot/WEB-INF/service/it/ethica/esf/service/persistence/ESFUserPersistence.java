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

import it.ethica.esf.model.ESFUser;

/**
 * The persistence interface for the e s f user service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFUserPersistenceImpl
 * @see ESFUserUtil
 * @generated
 */
public interface ESFUserPersistence extends BasePersistence<ESFUser> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ESFUserUtil} to access the e s f user persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the e s f users where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching e s f users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFUser> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.ethica.esf.model.ESFUser> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.ethica.esf.model.ESFUser> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f user in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f user
	* @throws it.ethica.esf.NoSuchUserException if a matching e s f user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFUser findByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserException;

	/**
	* Returns the first e s f user in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f user, or <code>null</code> if a matching e s f user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFUser fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f user in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f user
	* @throws it.ethica.esf.NoSuchUserException if a matching e s f user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFUser findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserException;

	/**
	* Returns the last e s f user in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f user, or <code>null</code> if a matching e s f user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFUser fetchByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public it.ethica.esf.model.ESFUser[] findByUuid_PrevAndNext(
		long esfUserId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserException;

	/**
	* Returns all the e s f users that the user has permission to view where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching e s f users that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFUser> filterFindByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.ethica.esf.model.ESFUser> filterFindByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.ethica.esf.model.ESFUser> filterFindByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public it.ethica.esf.model.ESFUser[] filterFindByUuid_PrevAndNext(
		long esfUserId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserException;

	/**
	* Removes all the e s f users where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f users where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching e s f users
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f users that the user has permission to view where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching e s f users that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f user where code = &#63; or throws a {@link it.ethica.esf.NoSuchUserException} if it could not be found.
	*
	* @param code the code
	* @return the matching e s f user
	* @throws it.ethica.esf.NoSuchUserException if a matching e s f user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFUser findByCode(java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserException;

	/**
	* Returns the e s f user where code = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param code the code
	* @return the matching e s f user, or <code>null</code> if a matching e s f user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFUser fetchByCode(java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f user where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param code the code
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching e s f user, or <code>null</code> if a matching e s f user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFUser fetchByCode(java.lang.String code,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the e s f user where code = &#63; from the database.
	*
	* @param code the code
	* @return the e s f user that was removed
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFUser removeByCode(java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserException;

	/**
	* Returns the number of e s f users where code = &#63;.
	*
	* @param code the code
	* @return the number of matching e s f users
	* @throws SystemException if a system exception occurred
	*/
	public int countByCode(java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f user where fiscalCode = &#63; or throws a {@link it.ethica.esf.NoSuchUserException} if it could not be found.
	*
	* @param fiscalCode the fiscal code
	* @return the matching e s f user
	* @throws it.ethica.esf.NoSuchUserException if a matching e s f user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFUser findByFiscalCode(
		java.lang.String fiscalCode)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserException;

	/**
	* Returns the e s f user where fiscalCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param fiscalCode the fiscal code
	* @return the matching e s f user, or <code>null</code> if a matching e s f user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFUser fetchByFiscalCode(
		java.lang.String fiscalCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f user where fiscalCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param fiscalCode the fiscal code
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching e s f user, or <code>null</code> if a matching e s f user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFUser fetchByFiscalCode(
		java.lang.String fiscalCode, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the e s f user where fiscalCode = &#63; from the database.
	*
	* @param fiscalCode the fiscal code
	* @return the e s f user that was removed
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFUser removeByFiscalCode(
		java.lang.String fiscalCode)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserException;

	/**
	* Returns the number of e s f users where fiscalCode = &#63;.
	*
	* @param fiscalCode the fiscal code
	* @return the number of matching e s f users
	* @throws SystemException if a system exception occurred
	*/
	public int countByFiscalCode(java.lang.String fiscalCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f user where esfUserId = &#63; or throws a {@link it.ethica.esf.NoSuchUserException} if it could not be found.
	*
	* @param esfUserId the esf user ID
	* @return the matching e s f user
	* @throws it.ethica.esf.NoSuchUserException if a matching e s f user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFUser findByUserdId(long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserException;

	/**
	* Returns the e s f user where esfUserId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param esfUserId the esf user ID
	* @return the matching e s f user, or <code>null</code> if a matching e s f user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFUser fetchByUserdId(long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f user where esfUserId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param esfUserId the esf user ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching e s f user, or <code>null</code> if a matching e s f user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFUser fetchByUserdId(long esfUserId,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the e s f user where esfUserId = &#63; from the database.
	*
	* @param esfUserId the esf user ID
	* @return the e s f user that was removed
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFUser removeByUserdId(long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserException;

	/**
	* Returns the number of e s f users where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @return the number of matching e s f users
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserdId(long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f user where codeUser = &#63; or throws a {@link it.ethica.esf.NoSuchUserException} if it could not be found.
	*
	* @param codeUser the code user
	* @return the matching e s f user
	* @throws it.ethica.esf.NoSuchUserException if a matching e s f user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFUser findByCodeUser(long codeUser)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserException;

	/**
	* Returns the e s f user where codeUser = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param codeUser the code user
	* @return the matching e s f user, or <code>null</code> if a matching e s f user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFUser fetchByCodeUser(long codeUser)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f user where codeUser = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param codeUser the code user
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching e s f user, or <code>null</code> if a matching e s f user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFUser fetchByCodeUser(long codeUser,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the e s f user where codeUser = &#63; from the database.
	*
	* @param codeUser the code user
	* @return the e s f user that was removed
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFUser removeByCodeUser(long codeUser)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserException;

	/**
	* Returns the number of e s f users where codeUser = &#63;.
	*
	* @param codeUser the code user
	* @return the number of matching e s f users
	* @throws SystemException if a system exception occurred
	*/
	public int countByCodeUser(long codeUser)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f user where codeUser = &#63; or throws a {@link it.ethica.esf.NoSuchUserException} if it could not be found.
	*
	* @param codeUser the code user
	* @return the matching e s f user
	* @throws it.ethica.esf.NoSuchUserException if a matching e s f user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFUser findByCodeUser2(long codeUser)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserException;

	/**
	* Returns the e s f user where codeUser = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param codeUser the code user
	* @return the matching e s f user, or <code>null</code> if a matching e s f user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFUser fetchByCodeUser2(long codeUser)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f user where codeUser = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param codeUser the code user
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching e s f user, or <code>null</code> if a matching e s f user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFUser fetchByCodeUser2(long codeUser,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the e s f user where codeUser = &#63; from the database.
	*
	* @param codeUser the code user
	* @return the e s f user that was removed
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFUser removeByCodeUser2(long codeUser)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserException;

	/**
	* Returns the number of e s f users where codeUser = &#63;.
	*
	* @param codeUser the code user
	* @return the number of matching e s f users
	* @throws SystemException if a system exception occurred
	*/
	public int countByCodeUser2(long codeUser)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the e s f user in the entity cache if it is enabled.
	*
	* @param esfUser the e s f user
	*/
	public void cacheResult(it.ethica.esf.model.ESFUser esfUser);

	/**
	* Caches the e s f users in the entity cache if it is enabled.
	*
	* @param esfUsers the e s f users
	*/
	public void cacheResult(
		java.util.List<it.ethica.esf.model.ESFUser> esfUsers);

	/**
	* Creates a new e s f user with the primary key. Does not add the e s f user to the database.
	*
	* @param esfUserId the primary key for the new e s f user
	* @return the new e s f user
	*/
	public it.ethica.esf.model.ESFUser create(long esfUserId);

	/**
	* Removes the e s f user with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfUserId the primary key of the e s f user
	* @return the e s f user that was removed
	* @throws it.ethica.esf.NoSuchUserException if a e s f user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFUser remove(long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserException;

	public it.ethica.esf.model.ESFUser updateImpl(
		it.ethica.esf.model.ESFUser esfUser)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f user with the primary key or throws a {@link it.ethica.esf.NoSuchUserException} if it could not be found.
	*
	* @param esfUserId the primary key of the e s f user
	* @return the e s f user
	* @throws it.ethica.esf.NoSuchUserException if a e s f user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFUser findByPrimaryKey(long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserException;

	/**
	* Returns the e s f user with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param esfUserId the primary key of the e s f user
	* @return the e s f user, or <code>null</code> if a e s f user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFUser fetchByPrimaryKey(long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f users.
	*
	* @return the e s f users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFUser> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.ethica.esf.model.ESFUser> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.ethica.esf.model.ESFUser> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the e s f users from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f users.
	*
	* @return the number of e s f users
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}