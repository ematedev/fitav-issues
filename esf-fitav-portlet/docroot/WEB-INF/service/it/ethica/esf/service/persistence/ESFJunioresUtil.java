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

import it.ethica.esf.model.ESFJuniores;

import java.util.List;

/**
 * The persistence utility for the e s f juniores service. This utility wraps {@link ESFJunioresPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFJunioresPersistence
 * @see ESFJunioresPersistenceImpl
 * @generated
 */
public class ESFJunioresUtil {
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
	public static void clearCache(ESFJuniores esfJuniores) {
		getPersistence().clearCache(esfJuniores);
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
	public static List<ESFJuniores> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ESFJuniores> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ESFJuniores> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ESFJuniores update(ESFJuniores esfJuniores)
		throws SystemException {
		return getPersistence().update(esfJuniores);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ESFJuniores update(ESFJuniores esfJuniores,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(esfJuniores, serviceContext);
	}

	/**
	* Caches the e s f juniores in the entity cache if it is enabled.
	*
	* @param esfJuniores the e s f juniores
	*/
	public static void cacheResult(it.ethica.esf.model.ESFJuniores esfJuniores) {
		getPersistence().cacheResult(esfJuniores);
	}

	/**
	* Caches the e s f junioreses in the entity cache if it is enabled.
	*
	* @param esfJunioreses the e s f junioreses
	*/
	public static void cacheResult(
		java.util.List<it.ethica.esf.model.ESFJuniores> esfJunioreses) {
		getPersistence().cacheResult(esfJunioreses);
	}

	/**
	* Creates a new e s f juniores with the primary key. Does not add the e s f juniores to the database.
	*
	* @param ESFUserId the primary key for the new e s f juniores
	* @return the new e s f juniores
	*/
	public static it.ethica.esf.model.ESFJuniores create(long ESFUserId) {
		return getPersistence().create(ESFUserId);
	}

	/**
	* Removes the e s f juniores with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ESFUserId the primary key of the e s f juniores
	* @return the e s f juniores that was removed
	* @throws it.ethica.esf.NoSuchJunioresException if a e s f juniores with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFJuniores remove(long ESFUserId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchJunioresException {
		return getPersistence().remove(ESFUserId);
	}

	public static it.ethica.esf.model.ESFJuniores updateImpl(
		it.ethica.esf.model.ESFJuniores esfJuniores)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(esfJuniores);
	}

	/**
	* Returns the e s f juniores with the primary key or throws a {@link it.ethica.esf.NoSuchJunioresException} if it could not be found.
	*
	* @param ESFUserId the primary key of the e s f juniores
	* @return the e s f juniores
	* @throws it.ethica.esf.NoSuchJunioresException if a e s f juniores with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFJuniores findByPrimaryKey(
		long ESFUserId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchJunioresException {
		return getPersistence().findByPrimaryKey(ESFUserId);
	}

	/**
	* Returns the e s f juniores with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param ESFUserId the primary key of the e s f juniores
	* @return the e s f juniores, or <code>null</code> if a e s f juniores with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFJuniores fetchByPrimaryKey(
		long ESFUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(ESFUserId);
	}

	/**
	* Returns all the e s f junioreses.
	*
	* @return the e s f junioreses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFJuniores> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the e s f junioreses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFJunioresModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f junioreses
	* @param end the upper bound of the range of e s f junioreses (not inclusive)
	* @return the range of e s f junioreses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFJuniores> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the e s f junioreses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFJunioresModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f junioreses
	* @param end the upper bound of the range of e s f junioreses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of e s f junioreses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFJuniores> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the e s f junioreses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of e s f junioreses.
	*
	* @return the number of e s f junioreses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ESFJunioresPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ESFJunioresPersistence)PortletBeanLocatorUtil.locate(it.ethica.esf.service.ClpSerializer.getServletContextName(),
					ESFJunioresPersistence.class.getName());

			ReferenceRegistry.registerReference(ESFJunioresUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ESFJunioresPersistence persistence) {
	}

	private static ESFJunioresPersistence _persistence;
}