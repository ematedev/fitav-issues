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

import it.ethica.esf.model.ESFUserCategory;

import java.util.List;

/**
 * The persistence utility for the e s f user category service. This utility wraps {@link ESFUserCategoryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFUserCategoryPersistence
 * @see ESFUserCategoryPersistenceImpl
 * @generated
 */
public class ESFUserCategoryUtil {
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
	public static void clearCache(ESFUserCategory esfUserCategory) {
		getPersistence().clearCache(esfUserCategory);
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
	public static List<ESFUserCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ESFUserCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ESFUserCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ESFUserCategory update(ESFUserCategory esfUserCategory)
		throws SystemException {
		return getPersistence().update(esfUserCategory);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ESFUserCategory update(ESFUserCategory esfUserCategory,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(esfUserCategory, serviceContext);
	}

	/**
	* Returns all the e s f user categories where esfCategoryId = &#63;.
	*
	* @param esfCategoryId the esf category ID
	* @return the matching e s f user categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFUserCategory> findByesfCategoryId(
		long esfCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByesfCategoryId(esfCategoryId);
	}

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
	public static java.util.List<it.ethica.esf.model.ESFUserCategory> findByesfCategoryId(
		long esfCategoryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByesfCategoryId(esfCategoryId, start, end);
	}

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
	public static java.util.List<it.ethica.esf.model.ESFUserCategory> findByesfCategoryId(
		long esfCategoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByesfCategoryId(esfCategoryId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first e s f user category in the ordered set where esfCategoryId = &#63;.
	*
	* @param esfCategoryId the esf category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f user category
	* @throws it.ethica.esf.NoSuchUserCategoryException if a matching e s f user category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUserCategory findByesfCategoryId_First(
		long esfCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserCategoryException {
		return getPersistence()
				   .findByesfCategoryId_First(esfCategoryId, orderByComparator);
	}

	/**
	* Returns the first e s f user category in the ordered set where esfCategoryId = &#63;.
	*
	* @param esfCategoryId the esf category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f user category, or <code>null</code> if a matching e s f user category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUserCategory fetchByesfCategoryId_First(
		long esfCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByesfCategoryId_First(esfCategoryId, orderByComparator);
	}

	/**
	* Returns the last e s f user category in the ordered set where esfCategoryId = &#63;.
	*
	* @param esfCategoryId the esf category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f user category
	* @throws it.ethica.esf.NoSuchUserCategoryException if a matching e s f user category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUserCategory findByesfCategoryId_Last(
		long esfCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserCategoryException {
		return getPersistence()
				   .findByesfCategoryId_Last(esfCategoryId, orderByComparator);
	}

	/**
	* Returns the last e s f user category in the ordered set where esfCategoryId = &#63;.
	*
	* @param esfCategoryId the esf category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f user category, or <code>null</code> if a matching e s f user category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUserCategory fetchByesfCategoryId_Last(
		long esfCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByesfCategoryId_Last(esfCategoryId, orderByComparator);
	}

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
	public static it.ethica.esf.model.ESFUserCategory[] findByesfCategoryId_PrevAndNext(
		long esfUserCategoryId, long esfCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserCategoryException {
		return getPersistence()
				   .findByesfCategoryId_PrevAndNext(esfUserCategoryId,
			esfCategoryId, orderByComparator);
	}

	/**
	* Removes all the e s f user categories where esfCategoryId = &#63; from the database.
	*
	* @param esfCategoryId the esf category ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByesfCategoryId(long esfCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByesfCategoryId(esfCategoryId);
	}

	/**
	* Returns the number of e s f user categories where esfCategoryId = &#63;.
	*
	* @param esfCategoryId the esf category ID
	* @return the number of matching e s f user categories
	* @throws SystemException if a system exception occurred
	*/
	public static int countByesfCategoryId(long esfCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByesfCategoryId(esfCategoryId);
	}

	/**
	* Caches the e s f user category in the entity cache if it is enabled.
	*
	* @param esfUserCategory the e s f user category
	*/
	public static void cacheResult(
		it.ethica.esf.model.ESFUserCategory esfUserCategory) {
		getPersistence().cacheResult(esfUserCategory);
	}

	/**
	* Caches the e s f user categories in the entity cache if it is enabled.
	*
	* @param esfUserCategories the e s f user categories
	*/
	public static void cacheResult(
		java.util.List<it.ethica.esf.model.ESFUserCategory> esfUserCategories) {
		getPersistence().cacheResult(esfUserCategories);
	}

	/**
	* Creates a new e s f user category with the primary key. Does not add the e s f user category to the database.
	*
	* @param esfUserCategoryId the primary key for the new e s f user category
	* @return the new e s f user category
	*/
	public static it.ethica.esf.model.ESFUserCategory create(
		long esfUserCategoryId) {
		return getPersistence().create(esfUserCategoryId);
	}

	/**
	* Removes the e s f user category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfUserCategoryId the primary key of the e s f user category
	* @return the e s f user category that was removed
	* @throws it.ethica.esf.NoSuchUserCategoryException if a e s f user category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUserCategory remove(
		long esfUserCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserCategoryException {
		return getPersistence().remove(esfUserCategoryId);
	}

	public static it.ethica.esf.model.ESFUserCategory updateImpl(
		it.ethica.esf.model.ESFUserCategory esfUserCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(esfUserCategory);
	}

	/**
	* Returns the e s f user category with the primary key or throws a {@link it.ethica.esf.NoSuchUserCategoryException} if it could not be found.
	*
	* @param esfUserCategoryId the primary key of the e s f user category
	* @return the e s f user category
	* @throws it.ethica.esf.NoSuchUserCategoryException if a e s f user category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUserCategory findByPrimaryKey(
		long esfUserCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchUserCategoryException {
		return getPersistence().findByPrimaryKey(esfUserCategoryId);
	}

	/**
	* Returns the e s f user category with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param esfUserCategoryId the primary key of the e s f user category
	* @return the e s f user category, or <code>null</code> if a e s f user category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFUserCategory fetchByPrimaryKey(
		long esfUserCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(esfUserCategoryId);
	}

	/**
	* Returns all the e s f user categories.
	*
	* @return the e s f user categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFUserCategory> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<it.ethica.esf.model.ESFUserCategory> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<it.ethica.esf.model.ESFUserCategory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the e s f user categories from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of e s f user categories.
	*
	* @return the number of e s f user categories
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ESFUserCategoryPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ESFUserCategoryPersistence)PortletBeanLocatorUtil.locate(it.ethica.esf.service.ClpSerializer.getServletContextName(),
					ESFUserCategoryPersistence.class.getName());

			ReferenceRegistry.registerReference(ESFUserCategoryUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ESFUserCategoryPersistence persistence) {
	}

	private static ESFUserCategoryPersistence _persistence;
}