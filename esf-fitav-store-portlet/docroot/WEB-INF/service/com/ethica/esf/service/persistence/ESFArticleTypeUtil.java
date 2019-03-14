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

package com.ethica.esf.service.persistence;

import com.ethica.esf.model.ESFArticleType;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the e s f article type service. This utility wraps {@link ESFArticleTypePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFArticleTypePersistence
 * @see ESFArticleTypePersistenceImpl
 * @generated
 */
public class ESFArticleTypeUtil {
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
	public static void clearCache(ESFArticleType esfArticleType) {
		getPersistence().clearCache(esfArticleType);
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
	public static List<ESFArticleType> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ESFArticleType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ESFArticleType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ESFArticleType update(ESFArticleType esfArticleType)
		throws SystemException {
		return getPersistence().update(esfArticleType);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ESFArticleType update(ESFArticleType esfArticleType,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(esfArticleType, serviceContext);
	}

	/**
	* Returns the e s f article type where description = &#63; or throws a {@link com.ethica.esf.NoSuchArticleTypeException} if it could not be found.
	*
	* @param description the description
	* @return the matching e s f article type
	* @throws com.ethica.esf.NoSuchArticleTypeException if a matching e s f article type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ethica.esf.model.ESFArticleType findByArticleTypeDescription(
		java.lang.String description)
		throws com.ethica.esf.NoSuchArticleTypeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByArticleTypeDescription(description);
	}

	/**
	* Returns the e s f article type where description = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param description the description
	* @return the matching e s f article type, or <code>null</code> if a matching e s f article type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ethica.esf.model.ESFArticleType fetchByArticleTypeDescription(
		java.lang.String description)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByArticleTypeDescription(description);
	}

	/**
	* Returns the e s f article type where description = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param description the description
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching e s f article type, or <code>null</code> if a matching e s f article type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ethica.esf.model.ESFArticleType fetchByArticleTypeDescription(
		java.lang.String description, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByArticleTypeDescription(description, retrieveFromCache);
	}

	/**
	* Removes the e s f article type where description = &#63; from the database.
	*
	* @param description the description
	* @return the e s f article type that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.ethica.esf.model.ESFArticleType removeByArticleTypeDescription(
		java.lang.String description)
		throws com.ethica.esf.NoSuchArticleTypeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByArticleTypeDescription(description);
	}

	/**
	* Returns the number of e s f article types where description = &#63;.
	*
	* @param description the description
	* @return the number of matching e s f article types
	* @throws SystemException if a system exception occurred
	*/
	public static int countByArticleTypeDescription(
		java.lang.String description)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByArticleTypeDescription(description);
	}

	/**
	* Returns all the e s f article types where esfArticleTypeId = &#63;.
	*
	* @param esfArticleTypeId the esf article type ID
	* @return the matching e s f article types
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ethica.esf.model.ESFArticleType> findByArticleTypeId(
		long esfArticleTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByArticleTypeId(esfArticleTypeId);
	}

	/**
	* Returns a range of all the e s f article types where esfArticleTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ethica.esf.model.impl.ESFArticleTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfArticleTypeId the esf article type ID
	* @param start the lower bound of the range of e s f article types
	* @param end the upper bound of the range of e s f article types (not inclusive)
	* @return the range of matching e s f article types
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ethica.esf.model.ESFArticleType> findByArticleTypeId(
		long esfArticleTypeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByArticleTypeId(esfArticleTypeId, start, end);
	}

	/**
	* Returns an ordered range of all the e s f article types where esfArticleTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ethica.esf.model.impl.ESFArticleTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfArticleTypeId the esf article type ID
	* @param start the lower bound of the range of e s f article types
	* @param end the upper bound of the range of e s f article types (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f article types
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ethica.esf.model.ESFArticleType> findByArticleTypeId(
		long esfArticleTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByArticleTypeId(esfArticleTypeId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first e s f article type in the ordered set where esfArticleTypeId = &#63;.
	*
	* @param esfArticleTypeId the esf article type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f article type
	* @throws com.ethica.esf.NoSuchArticleTypeException if a matching e s f article type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ethica.esf.model.ESFArticleType findByArticleTypeId_First(
		long esfArticleTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ethica.esf.NoSuchArticleTypeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByArticleTypeId_First(esfArticleTypeId,
			orderByComparator);
	}

	/**
	* Returns the first e s f article type in the ordered set where esfArticleTypeId = &#63;.
	*
	* @param esfArticleTypeId the esf article type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f article type, or <code>null</code> if a matching e s f article type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ethica.esf.model.ESFArticleType fetchByArticleTypeId_First(
		long esfArticleTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByArticleTypeId_First(esfArticleTypeId,
			orderByComparator);
	}

	/**
	* Returns the last e s f article type in the ordered set where esfArticleTypeId = &#63;.
	*
	* @param esfArticleTypeId the esf article type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f article type
	* @throws com.ethica.esf.NoSuchArticleTypeException if a matching e s f article type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ethica.esf.model.ESFArticleType findByArticleTypeId_Last(
		long esfArticleTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ethica.esf.NoSuchArticleTypeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByArticleTypeId_Last(esfArticleTypeId, orderByComparator);
	}

	/**
	* Returns the last e s f article type in the ordered set where esfArticleTypeId = &#63;.
	*
	* @param esfArticleTypeId the esf article type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f article type, or <code>null</code> if a matching e s f article type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ethica.esf.model.ESFArticleType fetchByArticleTypeId_Last(
		long esfArticleTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByArticleTypeId_Last(esfArticleTypeId,
			orderByComparator);
	}

	/**
	* Removes all the e s f article types where esfArticleTypeId = &#63; from the database.
	*
	* @param esfArticleTypeId the esf article type ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByArticleTypeId(long esfArticleTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByArticleTypeId(esfArticleTypeId);
	}

	/**
	* Returns the number of e s f article types where esfArticleTypeId = &#63;.
	*
	* @param esfArticleTypeId the esf article type ID
	* @return the number of matching e s f article types
	* @throws SystemException if a system exception occurred
	*/
	public static int countByArticleTypeId(long esfArticleTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByArticleTypeId(esfArticleTypeId);
	}

	/**
	* Caches the e s f article type in the entity cache if it is enabled.
	*
	* @param esfArticleType the e s f article type
	*/
	public static void cacheResult(
		com.ethica.esf.model.ESFArticleType esfArticleType) {
		getPersistence().cacheResult(esfArticleType);
	}

	/**
	* Caches the e s f article types in the entity cache if it is enabled.
	*
	* @param esfArticleTypes the e s f article types
	*/
	public static void cacheResult(
		java.util.List<com.ethica.esf.model.ESFArticleType> esfArticleTypes) {
		getPersistence().cacheResult(esfArticleTypes);
	}

	/**
	* Creates a new e s f article type with the primary key. Does not add the e s f article type to the database.
	*
	* @param esfArticleTypeId the primary key for the new e s f article type
	* @return the new e s f article type
	*/
	public static com.ethica.esf.model.ESFArticleType create(
		long esfArticleTypeId) {
		return getPersistence().create(esfArticleTypeId);
	}

	/**
	* Removes the e s f article type with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfArticleTypeId the primary key of the e s f article type
	* @return the e s f article type that was removed
	* @throws com.ethica.esf.NoSuchArticleTypeException if a e s f article type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ethica.esf.model.ESFArticleType remove(
		long esfArticleTypeId)
		throws com.ethica.esf.NoSuchArticleTypeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(esfArticleTypeId);
	}

	public static com.ethica.esf.model.ESFArticleType updateImpl(
		com.ethica.esf.model.ESFArticleType esfArticleType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(esfArticleType);
	}

	/**
	* Returns the e s f article type with the primary key or throws a {@link com.ethica.esf.NoSuchArticleTypeException} if it could not be found.
	*
	* @param esfArticleTypeId the primary key of the e s f article type
	* @return the e s f article type
	* @throws com.ethica.esf.NoSuchArticleTypeException if a e s f article type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ethica.esf.model.ESFArticleType findByPrimaryKey(
		long esfArticleTypeId)
		throws com.ethica.esf.NoSuchArticleTypeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(esfArticleTypeId);
	}

	/**
	* Returns the e s f article type with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param esfArticleTypeId the primary key of the e s f article type
	* @return the e s f article type, or <code>null</code> if a e s f article type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ethica.esf.model.ESFArticleType fetchByPrimaryKey(
		long esfArticleTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(esfArticleTypeId);
	}

	/**
	* Returns all the e s f article types.
	*
	* @return the e s f article types
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ethica.esf.model.ESFArticleType> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the e s f article types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ethica.esf.model.impl.ESFArticleTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f article types
	* @param end the upper bound of the range of e s f article types (not inclusive)
	* @return the range of e s f article types
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ethica.esf.model.ESFArticleType> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the e s f article types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ethica.esf.model.impl.ESFArticleTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f article types
	* @param end the upper bound of the range of e s f article types (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of e s f article types
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ethica.esf.model.ESFArticleType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the e s f article types from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of e s f article types.
	*
	* @return the number of e s f article types
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ESFArticleTypePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ESFArticleTypePersistence)PortletBeanLocatorUtil.locate(com.ethica.esf.service.ClpSerializer.getServletContextName(),
					ESFArticleTypePersistence.class.getName());

			ReferenceRegistry.registerReference(ESFArticleTypeUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ESFArticleTypePersistence persistence) {
	}

	private static ESFArticleTypePersistence _persistence;
}