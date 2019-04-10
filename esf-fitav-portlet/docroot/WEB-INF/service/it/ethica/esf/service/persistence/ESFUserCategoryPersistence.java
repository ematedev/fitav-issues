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

import it.ethica.esf.model.ESFUserCategory;

/**
 * The persistence interface for the e s f user category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFUserCategoryPersistenceImpl
 * @see ESFUserCategoryUtil
 * @generated
 */
public interface ESFUserCategoryPersistence extends BasePersistence<ESFUserCategory> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ESFUserCategoryUtil} to access the e s f user category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the e s f user categories where esfCategoryId = &#63;.
	*
	* @param esfCategoryId the esf category ID
	* @return the matching e s f user categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFUserCategory> findByesfCategoryId(
		long esfCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f user categories where esfCategoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfCategoryId the esf category ID
	* @param start the lower bound of the range of e s f user categories
	* @param end the upper bound of the range of e s f user categories (not inclusive)
	* @return the range of matching e s f user categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFUserCategory> findByesfCategoryId(
		long esfCategoryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f user categories where esfCategoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfCategoryId the esf category ID
	* @param start the lower bound of the range of e s f user categories
	* @param end the upper bound of the range of e s f user categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f user categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFUserCategory> findByesfCategoryId(
		long esfCategoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f user category in the ordered set where esfCategoryId = &#63;.
	*
	* @param esfCategoryId the esf category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f user category
	* @throws it.ethica.esf.NoSuchUserCategoryException if a matching e s f user category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFUserCategory findByesfCategoryId_First(
		long esfCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserCategoryException;

	/**
	* Returns the first e s f user category in the ordered set where esfCategoryId = &#63;.
	*
	* @param esfCategoryId the esf category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f user category, or <code>null</code> if a matching e s f user category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFUserCategory fetchByesfCategoryId_First(
		long esfCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f user category in the ordered set where esfCategoryId = &#63;.
	*
	* @param esfCategoryId the esf category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f user category
	* @throws it.ethica.esf.NoSuchUserCategoryException if a matching e s f user category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFUserCategory findByesfCategoryId_Last(
		long esfCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserCategoryException;

	/**
	* Returns the last e s f user category in the ordered set where esfCategoryId = &#63;.
	*
	* @param esfCategoryId the esf category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f user category, or <code>null</code> if a matching e s f user category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFUserCategory fetchByesfCategoryId_Last(
		long esfCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f user categories before and after the current e s f user category in the ordered set where esfCategoryId = &#63;.
	*
	* @param esfUserCategoryId the primary key of the current e s f user category
	* @param esfCategoryId the esf category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f user category
	* @throws it.ethica.esf.NoSuchUserCategoryException if a e s f user category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFUserCategory[] findByesfCategoryId_PrevAndNext(
		long esfUserCategoryId, long esfCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserCategoryException;

	/**
	* Removes all the e s f user categories where esfCategoryId = &#63; from the database.
	*
	* @param esfCategoryId the esf category ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByesfCategoryId(long esfCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f user categories where esfCategoryId = &#63;.
	*
	* @param esfCategoryId the esf category ID
	* @return the number of matching e s f user categories
	* @throws SystemException if a system exception occurred
	*/
	public int countByesfCategoryId(long esfCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f user category where esfUserId = &#63; and esfCategoryId = &#63; and esfSportTypeId = &#63; or throws a {@link it.ethica.esf.NoSuchUserCategoryException} if it could not be found.
	*
	* @param esfUserId the esf user ID
	* @param esfCategoryId the esf category ID
	* @param esfSportTypeId the esf sport type ID
	* @return the matching e s f user category
	* @throws it.ethica.esf.NoSuchUserCategoryException if a matching e s f user category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFUserCategory findByU_C_S(long esfUserId,
		long esfCategoryId, long esfSportTypeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserCategoryException;

	/**
	* Returns the e s f user category where esfUserId = &#63; and esfCategoryId = &#63; and esfSportTypeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param esfUserId the esf user ID
	* @param esfCategoryId the esf category ID
	* @param esfSportTypeId the esf sport type ID
	* @return the matching e s f user category, or <code>null</code> if a matching e s f user category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFUserCategory fetchByU_C_S(long esfUserId,
		long esfCategoryId, long esfSportTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f user category where esfUserId = &#63; and esfCategoryId = &#63; and esfSportTypeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param esfUserId the esf user ID
	* @param esfCategoryId the esf category ID
	* @param esfSportTypeId the esf sport type ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching e s f user category, or <code>null</code> if a matching e s f user category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFUserCategory fetchByU_C_S(long esfUserId,
		long esfCategoryId, long esfSportTypeId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the e s f user category where esfUserId = &#63; and esfCategoryId = &#63; and esfSportTypeId = &#63; from the database.
	*
	* @param esfUserId the esf user ID
	* @param esfCategoryId the esf category ID
	* @param esfSportTypeId the esf sport type ID
	* @return the e s f user category that was removed
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFUserCategory removeByU_C_S(long esfUserId,
		long esfCategoryId, long esfSportTypeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserCategoryException;

	/**
	* Returns the number of e s f user categories where esfUserId = &#63; and esfCategoryId = &#63; and esfSportTypeId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param esfCategoryId the esf category ID
	* @param esfSportTypeId the esf sport type ID
	* @return the number of matching e s f user categories
	* @throws SystemException if a system exception occurred
	*/
	public int countByU_C_S(long esfUserId, long esfCategoryId,
		long esfSportTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the e s f user category in the entity cache if it is enabled.
	*
	* @param esfUserCategory the e s f user category
	*/
	public void cacheResult(it.ethica.esf.model.ESFUserCategory esfUserCategory);

	/**
	* Caches the e s f user categories in the entity cache if it is enabled.
	*
	* @param esfUserCategories the e s f user categories
	*/
	public void cacheResult(
		java.util.List<it.ethica.esf.model.ESFUserCategory> esfUserCategories);

	/**
	* Creates a new e s f user category with the primary key. Does not add the e s f user category to the database.
	*
	* @param esfUserCategoryId the primary key for the new e s f user category
	* @return the new e s f user category
	*/
	public it.ethica.esf.model.ESFUserCategory create(long esfUserCategoryId);

	/**
	* Removes the e s f user category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfUserCategoryId the primary key of the e s f user category
	* @return the e s f user category that was removed
	* @throws it.ethica.esf.NoSuchUserCategoryException if a e s f user category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFUserCategory remove(long esfUserCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserCategoryException;

	public it.ethica.esf.model.ESFUserCategory updateImpl(
		it.ethica.esf.model.ESFUserCategory esfUserCategory)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f user category with the primary key or throws a {@link it.ethica.esf.NoSuchUserCategoryException} if it could not be found.
	*
	* @param esfUserCategoryId the primary key of the e s f user category
	* @return the e s f user category
	* @throws it.ethica.esf.NoSuchUserCategoryException if a e s f user category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFUserCategory findByPrimaryKey(
		long esfUserCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserCategoryException;

	/**
	* Returns the e s f user category with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param esfUserCategoryId the primary key of the e s f user category
	* @return the e s f user category, or <code>null</code> if a e s f user category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFUserCategory fetchByPrimaryKey(
		long esfUserCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f user categories.
	*
	* @return the e s f user categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFUserCategory> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f user categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f user categories
	* @param end the upper bound of the range of e s f user categories (not inclusive)
	* @return the range of e s f user categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFUserCategory> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f user categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f user categories
	* @param end the upper bound of the range of e s f user categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of e s f user categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFUserCategory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the e s f user categories from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f user categories.
	*
	* @return the number of e s f user categories
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}