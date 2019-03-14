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

import it.ethica.esf.model.ESFSuspensiveCode;

import java.util.List;

/**
 * The persistence utility for the e s f suspensive code service. This utility wraps {@link ESFSuspensiveCodePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFSuspensiveCodePersistence
 * @see ESFSuspensiveCodePersistenceImpl
 * @generated
 */
public class ESFSuspensiveCodeUtil {
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
	public static void clearCache(ESFSuspensiveCode esfSuspensiveCode) {
		getPersistence().clearCache(esfSuspensiveCode);
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
	public static List<ESFSuspensiveCode> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ESFSuspensiveCode> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ESFSuspensiveCode> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ESFSuspensiveCode update(ESFSuspensiveCode esfSuspensiveCode)
		throws SystemException {
		return getPersistence().update(esfSuspensiveCode);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ESFSuspensiveCode update(
		ESFSuspensiveCode esfSuspensiveCode, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(esfSuspensiveCode, serviceContext);
	}

	/**
	* Caches the e s f suspensive code in the entity cache if it is enabled.
	*
	* @param esfSuspensiveCode the e s f suspensive code
	*/
	public static void cacheResult(
		it.ethica.esf.model.ESFSuspensiveCode esfSuspensiveCode) {
		getPersistence().cacheResult(esfSuspensiveCode);
	}

	/**
	* Caches the e s f suspensive codes in the entity cache if it is enabled.
	*
	* @param esfSuspensiveCodes the e s f suspensive codes
	*/
	public static void cacheResult(
		java.util.List<it.ethica.esf.model.ESFSuspensiveCode> esfSuspensiveCodes) {
		getPersistence().cacheResult(esfSuspensiveCodes);
	}

	/**
	* Creates a new e s f suspensive code with the primary key. Does not add the e s f suspensive code to the database.
	*
	* @param esfSuspensiveCodeId the primary key for the new e s f suspensive code
	* @return the new e s f suspensive code
	*/
	public static it.ethica.esf.model.ESFSuspensiveCode create(
		long esfSuspensiveCodeId) {
		return getPersistence().create(esfSuspensiveCodeId);
	}

	/**
	* Removes the e s f suspensive code with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfSuspensiveCodeId the primary key of the e s f suspensive code
	* @return the e s f suspensive code that was removed
	* @throws it.ethica.esf.NoSuchSuspensiveCodeException if a e s f suspensive code with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFSuspensiveCode remove(
		long esfSuspensiveCodeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchSuspensiveCodeException {
		return getPersistence().remove(esfSuspensiveCodeId);
	}

	public static it.ethica.esf.model.ESFSuspensiveCode updateImpl(
		it.ethica.esf.model.ESFSuspensiveCode esfSuspensiveCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(esfSuspensiveCode);
	}

	/**
	* Returns the e s f suspensive code with the primary key or throws a {@link it.ethica.esf.NoSuchSuspensiveCodeException} if it could not be found.
	*
	* @param esfSuspensiveCodeId the primary key of the e s f suspensive code
	* @return the e s f suspensive code
	* @throws it.ethica.esf.NoSuchSuspensiveCodeException if a e s f suspensive code with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFSuspensiveCode findByPrimaryKey(
		long esfSuspensiveCodeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchSuspensiveCodeException {
		return getPersistence().findByPrimaryKey(esfSuspensiveCodeId);
	}

	/**
	* Returns the e s f suspensive code with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param esfSuspensiveCodeId the primary key of the e s f suspensive code
	* @return the e s f suspensive code, or <code>null</code> if a e s f suspensive code with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFSuspensiveCode fetchByPrimaryKey(
		long esfSuspensiveCodeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(esfSuspensiveCodeId);
	}

	/**
	* Returns all the e s f suspensive codes.
	*
	* @return the e s f suspensive codes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFSuspensiveCode> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the e s f suspensive codes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFSuspensiveCodeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f suspensive codes
	* @param end the upper bound of the range of e s f suspensive codes (not inclusive)
	* @return the range of e s f suspensive codes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFSuspensiveCode> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the e s f suspensive codes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFSuspensiveCodeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f suspensive codes
	* @param end the upper bound of the range of e s f suspensive codes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of e s f suspensive codes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFSuspensiveCode> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the e s f suspensive codes from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of e s f suspensive codes.
	*
	* @return the number of e s f suspensive codes
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ESFSuspensiveCodePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ESFSuspensiveCodePersistence)PortletBeanLocatorUtil.locate(it.ethica.esf.service.ClpSerializer.getServletContextName(),
					ESFSuspensiveCodePersistence.class.getName());

			ReferenceRegistry.registerReference(ESFSuspensiveCodeUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ESFSuspensiveCodePersistence persistence) {
	}

	private static ESFSuspensiveCodePersistence _persistence;
}