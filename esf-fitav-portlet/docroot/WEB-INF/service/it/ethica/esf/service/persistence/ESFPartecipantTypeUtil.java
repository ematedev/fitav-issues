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

import it.ethica.esf.model.ESFPartecipantType;

import java.util.List;

/**
 * The persistence utility for the e s f partecipant type service. This utility wraps {@link ESFPartecipantTypePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFPartecipantTypePersistence
 * @see ESFPartecipantTypePersistenceImpl
 * @generated
 */
public class ESFPartecipantTypeUtil {
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
	public static void clearCache(ESFPartecipantType esfPartecipantType) {
		getPersistence().clearCache(esfPartecipantType);
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
	public static List<ESFPartecipantType> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ESFPartecipantType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ESFPartecipantType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ESFPartecipantType update(
		ESFPartecipantType esfPartecipantType) throws SystemException {
		return getPersistence().update(esfPartecipantType);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ESFPartecipantType update(
		ESFPartecipantType esfPartecipantType, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(esfPartecipantType, serviceContext);
	}

	/**
	* Caches the e s f partecipant type in the entity cache if it is enabled.
	*
	* @param esfPartecipantType the e s f partecipant type
	*/
	public static void cacheResult(
		it.ethica.esf.model.ESFPartecipantType esfPartecipantType) {
		getPersistence().cacheResult(esfPartecipantType);
	}

	/**
	* Caches the e s f partecipant types in the entity cache if it is enabled.
	*
	* @param esfPartecipantTypes the e s f partecipant types
	*/
	public static void cacheResult(
		java.util.List<it.ethica.esf.model.ESFPartecipantType> esfPartecipantTypes) {
		getPersistence().cacheResult(esfPartecipantTypes);
	}

	/**
	* Creates a new e s f partecipant type with the primary key. Does not add the e s f partecipant type to the database.
	*
	* @param esfPartecipantTypeId the primary key for the new e s f partecipant type
	* @return the new e s f partecipant type
	*/
	public static it.ethica.esf.model.ESFPartecipantType create(
		long esfPartecipantTypeId) {
		return getPersistence().create(esfPartecipantTypeId);
	}

	/**
	* Removes the e s f partecipant type with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfPartecipantTypeId the primary key of the e s f partecipant type
	* @return the e s f partecipant type that was removed
	* @throws it.ethica.esf.NoSuchPartecipantTypeException if a e s f partecipant type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFPartecipantType remove(
		long esfPartecipantTypeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchPartecipantTypeException {
		return getPersistence().remove(esfPartecipantTypeId);
	}

	public static it.ethica.esf.model.ESFPartecipantType updateImpl(
		it.ethica.esf.model.ESFPartecipantType esfPartecipantType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(esfPartecipantType);
	}

	/**
	* Returns the e s f partecipant type with the primary key or throws a {@link it.ethica.esf.NoSuchPartecipantTypeException} if it could not be found.
	*
	* @param esfPartecipantTypeId the primary key of the e s f partecipant type
	* @return the e s f partecipant type
	* @throws it.ethica.esf.NoSuchPartecipantTypeException if a e s f partecipant type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFPartecipantType findByPrimaryKey(
		long esfPartecipantTypeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchPartecipantTypeException {
		return getPersistence().findByPrimaryKey(esfPartecipantTypeId);
	}

	/**
	* Returns the e s f partecipant type with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param esfPartecipantTypeId the primary key of the e s f partecipant type
	* @return the e s f partecipant type, or <code>null</code> if a e s f partecipant type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFPartecipantType fetchByPrimaryKey(
		long esfPartecipantTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(esfPartecipantTypeId);
	}

	/**
	* Returns all the e s f partecipant types.
	*
	* @return the e s f partecipant types
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFPartecipantType> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the e s f partecipant types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFPartecipantTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f partecipant types
	* @param end the upper bound of the range of e s f partecipant types (not inclusive)
	* @return the range of e s f partecipant types
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFPartecipantType> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the e s f partecipant types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFPartecipantTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f partecipant types
	* @param end the upper bound of the range of e s f partecipant types (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of e s f partecipant types
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFPartecipantType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the e s f partecipant types from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of e s f partecipant types.
	*
	* @return the number of e s f partecipant types
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ESFPartecipantTypePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ESFPartecipantTypePersistence)PortletBeanLocatorUtil.locate(it.ethica.esf.service.ClpSerializer.getServletContextName(),
					ESFPartecipantTypePersistence.class.getName());

			ReferenceRegistry.registerReference(ESFPartecipantTypeUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ESFPartecipantTypePersistence persistence) {
	}

	private static ESFPartecipantTypePersistence _persistence;
}