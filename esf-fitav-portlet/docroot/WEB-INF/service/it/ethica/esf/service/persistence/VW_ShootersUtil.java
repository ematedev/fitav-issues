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

import it.ethica.esf.model.VW_Shooters;

import java.util.List;

/**
 * The persistence utility for the v w_ shooters service. This utility wraps {@link VW_ShootersPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see VW_ShootersPersistence
 * @see VW_ShootersPersistenceImpl
 * @generated
 */
public class VW_ShootersUtil {
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
	public static void clearCache(VW_Shooters vw_Shooters) {
		getPersistence().clearCache(vw_Shooters);
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
	public static List<VW_Shooters> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<VW_Shooters> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<VW_Shooters> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static VW_Shooters update(VW_Shooters vw_Shooters)
		throws SystemException {
		return getPersistence().update(vw_Shooters);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static VW_Shooters update(VW_Shooters vw_Shooters,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(vw_Shooters, serviceContext);
	}

	/**
	* Returns the v w_ shooters where userId = &#63; or throws a {@link it.ethica.esf.NoSuchVW_ShootersException} if it could not be found.
	*
	* @param userId the user ID
	* @return the matching v w_ shooters
	* @throws it.ethica.esf.NoSuchVW_ShootersException if a matching v w_ shooters could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.VW_Shooters findByfindByUserId(
		long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchVW_ShootersException {
		return getPersistence().findByfindByUserId(userId);
	}

	/**
	* Returns the v w_ shooters where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userId the user ID
	* @return the matching v w_ shooters, or <code>null</code> if a matching v w_ shooters could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.VW_Shooters fetchByfindByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByfindByUserId(userId);
	}

	/**
	* Returns the v w_ shooters where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userId the user ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching v w_ shooters, or <code>null</code> if a matching v w_ shooters could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.VW_Shooters fetchByfindByUserId(
		long userId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByfindByUserId(userId, retrieveFromCache);
	}

	/**
	* Removes the v w_ shooters where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @return the v w_ shooters that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.VW_Shooters removeByfindByUserId(
		long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchVW_ShootersException {
		return getPersistence().removeByfindByUserId(userId);
	}

	/**
	* Returns the number of v w_ shooterses where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching v w_ shooterses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByfindByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByfindByUserId(userId);
	}

	/**
	* Caches the v w_ shooters in the entity cache if it is enabled.
	*
	* @param vw_Shooters the v w_ shooters
	*/
	public static void cacheResult(it.ethica.esf.model.VW_Shooters vw_Shooters) {
		getPersistence().cacheResult(vw_Shooters);
	}

	/**
	* Caches the v w_ shooterses in the entity cache if it is enabled.
	*
	* @param vw_Shooterses the v w_ shooterses
	*/
	public static void cacheResult(
		java.util.List<it.ethica.esf.model.VW_Shooters> vw_Shooterses) {
		getPersistence().cacheResult(vw_Shooterses);
	}

	/**
	* Creates a new v w_ shooters with the primary key. Does not add the v w_ shooters to the database.
	*
	* @param vw_ShootersPK the primary key for the new v w_ shooters
	* @return the new v w_ shooters
	*/
	public static it.ethica.esf.model.VW_Shooters create(
		it.ethica.esf.service.persistence.VW_ShootersPK vw_ShootersPK) {
		return getPersistence().create(vw_ShootersPK);
	}

	/**
	* Removes the v w_ shooters with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param vw_ShootersPK the primary key of the v w_ shooters
	* @return the v w_ shooters that was removed
	* @throws it.ethica.esf.NoSuchVW_ShootersException if a v w_ shooters with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.VW_Shooters remove(
		it.ethica.esf.service.persistence.VW_ShootersPK vw_ShootersPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchVW_ShootersException {
		return getPersistence().remove(vw_ShootersPK);
	}

	public static it.ethica.esf.model.VW_Shooters updateImpl(
		it.ethica.esf.model.VW_Shooters vw_Shooters)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(vw_Shooters);
	}

	/**
	* Returns the v w_ shooters with the primary key or throws a {@link it.ethica.esf.NoSuchVW_ShootersException} if it could not be found.
	*
	* @param vw_ShootersPK the primary key of the v w_ shooters
	* @return the v w_ shooters
	* @throws it.ethica.esf.NoSuchVW_ShootersException if a v w_ shooters with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.VW_Shooters findByPrimaryKey(
		it.ethica.esf.service.persistence.VW_ShootersPK vw_ShootersPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchVW_ShootersException {
		return getPersistence().findByPrimaryKey(vw_ShootersPK);
	}

	/**
	* Returns the v w_ shooters with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param vw_ShootersPK the primary key of the v w_ shooters
	* @return the v w_ shooters, or <code>null</code> if a v w_ shooters with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.VW_Shooters fetchByPrimaryKey(
		it.ethica.esf.service.persistence.VW_ShootersPK vw_ShootersPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(vw_ShootersPK);
	}

	/**
	* Returns all the v w_ shooterses.
	*
	* @return the v w_ shooterses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.VW_Shooters> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the v w_ shooterses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.VW_ShootersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of v w_ shooterses
	* @param end the upper bound of the range of v w_ shooterses (not inclusive)
	* @return the range of v w_ shooterses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.VW_Shooters> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the v w_ shooterses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.VW_ShootersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of v w_ shooterses
	* @param end the upper bound of the range of v w_ shooterses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of v w_ shooterses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.VW_Shooters> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the v w_ shooterses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of v w_ shooterses.
	*
	* @return the number of v w_ shooterses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static VW_ShootersPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (VW_ShootersPersistence)PortletBeanLocatorUtil.locate(it.ethica.esf.service.ClpSerializer.getServletContextName(),
					VW_ShootersPersistence.class.getName());

			ReferenceRegistry.registerReference(VW_ShootersUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(VW_ShootersPersistence persistence) {
	}

	private static VW_ShootersPersistence _persistence;
}