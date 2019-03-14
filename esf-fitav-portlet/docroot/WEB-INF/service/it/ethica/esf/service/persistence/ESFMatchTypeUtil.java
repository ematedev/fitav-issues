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

import it.ethica.esf.model.ESFMatchType;

import java.util.List;

/**
 * The persistence utility for the e s f match type service. This utility wraps {@link ESFMatchTypePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFMatchTypePersistence
 * @see ESFMatchTypePersistenceImpl
 * @generated
 */
public class ESFMatchTypeUtil {
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
	public static void clearCache(ESFMatchType esfMatchType) {
		getPersistence().clearCache(esfMatchType);
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
	public static List<ESFMatchType> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ESFMatchType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ESFMatchType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ESFMatchType update(ESFMatchType esfMatchType)
		throws SystemException {
		return getPersistence().update(esfMatchType);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ESFMatchType update(ESFMatchType esfMatchType,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(esfMatchType, serviceContext);
	}

	/**
	* Returns the e s f match type where code = &#63; or throws a {@link it.ethica.esf.NoSuchMatchTypeException} if it could not be found.
	*
	* @param code the code
	* @return the matching e s f match type
	* @throws it.ethica.esf.NoSuchMatchTypeException if a matching e s f match type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFMatchType findByCode(
		java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchMatchTypeException {
		return getPersistence().findByCode(code);
	}

	/**
	* Returns the e s f match type where code = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param code the code
	* @return the matching e s f match type, or <code>null</code> if a matching e s f match type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFMatchType fetchByCode(
		java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCode(code);
	}

	/**
	* Returns the e s f match type where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param code the code
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching e s f match type, or <code>null</code> if a matching e s f match type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFMatchType fetchByCode(
		java.lang.String code, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCode(code, retrieveFromCache);
	}

	/**
	* Removes the e s f match type where code = &#63; from the database.
	*
	* @param code the code
	* @return the e s f match type that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFMatchType removeByCode(
		java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchMatchTypeException {
		return getPersistence().removeByCode(code);
	}

	/**
	* Returns the number of e s f match types where code = &#63;.
	*
	* @param code the code
	* @return the number of matching e s f match types
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCode(java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCode(code);
	}

	/**
	* Returns all the e s f match types where isNational = &#63;.
	*
	* @param isNational the is national
	* @return the matching e s f match types
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFMatchType> findByIsNational(
		boolean isNational)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByIsNational(isNational);
	}

	/**
	* Returns a range of all the e s f match types where isNational = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFMatchTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param isNational the is national
	* @param start the lower bound of the range of e s f match types
	* @param end the upper bound of the range of e s f match types (not inclusive)
	* @return the range of matching e s f match types
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFMatchType> findByIsNational(
		boolean isNational, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByIsNational(isNational, start, end);
	}

	/**
	* Returns an ordered range of all the e s f match types where isNational = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFMatchTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param isNational the is national
	* @param start the lower bound of the range of e s f match types
	* @param end the upper bound of the range of e s f match types (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f match types
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFMatchType> findByIsNational(
		boolean isNational, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByIsNational(isNational, start, end, orderByComparator);
	}

	/**
	* Returns the first e s f match type in the ordered set where isNational = &#63;.
	*
	* @param isNational the is national
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f match type
	* @throws it.ethica.esf.NoSuchMatchTypeException if a matching e s f match type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFMatchType findByIsNational_First(
		boolean isNational,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchMatchTypeException {
		return getPersistence()
				   .findByIsNational_First(isNational, orderByComparator);
	}

	/**
	* Returns the first e s f match type in the ordered set where isNational = &#63;.
	*
	* @param isNational the is national
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f match type, or <code>null</code> if a matching e s f match type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFMatchType fetchByIsNational_First(
		boolean isNational,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByIsNational_First(isNational, orderByComparator);
	}

	/**
	* Returns the last e s f match type in the ordered set where isNational = &#63;.
	*
	* @param isNational the is national
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f match type
	* @throws it.ethica.esf.NoSuchMatchTypeException if a matching e s f match type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFMatchType findByIsNational_Last(
		boolean isNational,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchMatchTypeException {
		return getPersistence()
				   .findByIsNational_Last(isNational, orderByComparator);
	}

	/**
	* Returns the last e s f match type in the ordered set where isNational = &#63;.
	*
	* @param isNational the is national
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f match type, or <code>null</code> if a matching e s f match type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFMatchType fetchByIsNational_Last(
		boolean isNational,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByIsNational_Last(isNational, orderByComparator);
	}

	/**
	* Returns the e s f match types before and after the current e s f match type in the ordered set where isNational = &#63;.
	*
	* @param esfMatchTypeId the primary key of the current e s f match type
	* @param isNational the is national
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f match type
	* @throws it.ethica.esf.NoSuchMatchTypeException if a e s f match type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFMatchType[] findByIsNational_PrevAndNext(
		long esfMatchTypeId, boolean isNational,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchMatchTypeException {
		return getPersistence()
				   .findByIsNational_PrevAndNext(esfMatchTypeId, isNational,
			orderByComparator);
	}

	/**
	* Removes all the e s f match types where isNational = &#63; from the database.
	*
	* @param isNational the is national
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByIsNational(boolean isNational)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByIsNational(isNational);
	}

	/**
	* Returns the number of e s f match types where isNational = &#63;.
	*
	* @param isNational the is national
	* @return the number of matching e s f match types
	* @throws SystemException if a system exception occurred
	*/
	public static int countByIsNational(boolean isNational)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByIsNational(isNational);
	}

	/**
	* Returns the e s f match type where name = &#63; or throws a {@link it.ethica.esf.NoSuchMatchTypeException} if it could not be found.
	*
	* @param name the name
	* @return the matching e s f match type
	* @throws it.ethica.esf.NoSuchMatchTypeException if a matching e s f match type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFMatchType findByfindByDescription(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchMatchTypeException {
		return getPersistence().findByfindByDescription(name);
	}

	/**
	* Returns the e s f match type where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param name the name
	* @return the matching e s f match type, or <code>null</code> if a matching e s f match type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFMatchType fetchByfindByDescription(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByfindByDescription(name);
	}

	/**
	* Returns the e s f match type where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param name the name
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching e s f match type, or <code>null</code> if a matching e s f match type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFMatchType fetchByfindByDescription(
		java.lang.String name, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByfindByDescription(name, retrieveFromCache);
	}

	/**
	* Removes the e s f match type where name = &#63; from the database.
	*
	* @param name the name
	* @return the e s f match type that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFMatchType removeByfindByDescription(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchMatchTypeException {
		return getPersistence().removeByfindByDescription(name);
	}

	/**
	* Returns the number of e s f match types where name = &#63;.
	*
	* @param name the name
	* @return the number of matching e s f match types
	* @throws SystemException if a system exception occurred
	*/
	public static int countByfindByDescription(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByfindByDescription(name);
	}

	/**
	* Caches the e s f match type in the entity cache if it is enabled.
	*
	* @param esfMatchType the e s f match type
	*/
	public static void cacheResult(
		it.ethica.esf.model.ESFMatchType esfMatchType) {
		getPersistence().cacheResult(esfMatchType);
	}

	/**
	* Caches the e s f match types in the entity cache if it is enabled.
	*
	* @param esfMatchTypes the e s f match types
	*/
	public static void cacheResult(
		java.util.List<it.ethica.esf.model.ESFMatchType> esfMatchTypes) {
		getPersistence().cacheResult(esfMatchTypes);
	}

	/**
	* Creates a new e s f match type with the primary key. Does not add the e s f match type to the database.
	*
	* @param esfMatchTypeId the primary key for the new e s f match type
	* @return the new e s f match type
	*/
	public static it.ethica.esf.model.ESFMatchType create(long esfMatchTypeId) {
		return getPersistence().create(esfMatchTypeId);
	}

	/**
	* Removes the e s f match type with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfMatchTypeId the primary key of the e s f match type
	* @return the e s f match type that was removed
	* @throws it.ethica.esf.NoSuchMatchTypeException if a e s f match type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFMatchType remove(long esfMatchTypeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchMatchTypeException {
		return getPersistence().remove(esfMatchTypeId);
	}

	public static it.ethica.esf.model.ESFMatchType updateImpl(
		it.ethica.esf.model.ESFMatchType esfMatchType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(esfMatchType);
	}

	/**
	* Returns the e s f match type with the primary key or throws a {@link it.ethica.esf.NoSuchMatchTypeException} if it could not be found.
	*
	* @param esfMatchTypeId the primary key of the e s f match type
	* @return the e s f match type
	* @throws it.ethica.esf.NoSuchMatchTypeException if a e s f match type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFMatchType findByPrimaryKey(
		long esfMatchTypeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchMatchTypeException {
		return getPersistence().findByPrimaryKey(esfMatchTypeId);
	}

	/**
	* Returns the e s f match type with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param esfMatchTypeId the primary key of the e s f match type
	* @return the e s f match type, or <code>null</code> if a e s f match type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFMatchType fetchByPrimaryKey(
		long esfMatchTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(esfMatchTypeId);
	}

	/**
	* Returns all the e s f match types.
	*
	* @return the e s f match types
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFMatchType> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the e s f match types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFMatchTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f match types
	* @param end the upper bound of the range of e s f match types (not inclusive)
	* @return the range of e s f match types
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFMatchType> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the e s f match types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFMatchTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f match types
	* @param end the upper bound of the range of e s f match types (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of e s f match types
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFMatchType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the e s f match types from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of e s f match types.
	*
	* @return the number of e s f match types
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ESFMatchTypePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ESFMatchTypePersistence)PortletBeanLocatorUtil.locate(it.ethica.esf.service.ClpSerializer.getServletContextName(),
					ESFMatchTypePersistence.class.getName());

			ReferenceRegistry.registerReference(ESFMatchTypeUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ESFMatchTypePersistence persistence) {
	}

	private static ESFMatchTypePersistence _persistence;
}