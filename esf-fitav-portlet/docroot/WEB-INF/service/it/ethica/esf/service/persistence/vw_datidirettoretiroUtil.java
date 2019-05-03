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

import it.ethica.esf.model.vw_datidirettoretiro;

import java.util.List;

/**
 * The persistence utility for the vw_datidirettoretiro service. This utility wraps {@link vw_datidirettoretiroPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see vw_datidirettoretiroPersistence
 * @see vw_datidirettoretiroPersistenceImpl
 * @generated
 */
public class vw_datidirettoretiroUtil {
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
	public static void clearCache(vw_datidirettoretiro vw_datidirettoretiro) {
		getPersistence().clearCache(vw_datidirettoretiro);
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
	public static List<vw_datidirettoretiro> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<vw_datidirettoretiro> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<vw_datidirettoretiro> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static vw_datidirettoretiro update(
		vw_datidirettoretiro vw_datidirettoretiro) throws SystemException {
		return getPersistence().update(vw_datidirettoretiro);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static vw_datidirettoretiro update(
		vw_datidirettoretiro vw_datidirettoretiro, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(vw_datidirettoretiro, serviceContext);
	}

	/**
	* Caches the vw_datidirettoretiro in the entity cache if it is enabled.
	*
	* @param vw_datidirettoretiro the vw_datidirettoretiro
	*/
	public static void cacheResult(
		it.ethica.esf.model.vw_datidirettoretiro vw_datidirettoretiro) {
		getPersistence().cacheResult(vw_datidirettoretiro);
	}

	/**
	* Caches the vw_datidirettoretiros in the entity cache if it is enabled.
	*
	* @param vw_datidirettoretiros the vw_datidirettoretiros
	*/
	public static void cacheResult(
		java.util.List<it.ethica.esf.model.vw_datidirettoretiro> vw_datidirettoretiros) {
		getPersistence().cacheResult(vw_datidirettoretiros);
	}

	/**
	* Creates a new vw_datidirettoretiro with the primary key. Does not add the vw_datidirettoretiro to the database.
	*
	* @param vw_datidirettoretiroPK the primary key for the new vw_datidirettoretiro
	* @return the new vw_datidirettoretiro
	*/
	public static it.ethica.esf.model.vw_datidirettoretiro create(
		vw_datidirettoretiroPK vw_datidirettoretiroPK) {
		return getPersistence().create(vw_datidirettoretiroPK);
	}

	/**
	* Removes the vw_datidirettoretiro with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param vw_datidirettoretiroPK the primary key of the vw_datidirettoretiro
	* @return the vw_datidirettoretiro that was removed
	* @throws it.ethica.esf.NoSuchvw_datidirettoretiroException if a vw_datidirettoretiro with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.vw_datidirettoretiro remove(
		vw_datidirettoretiroPK vw_datidirettoretiroPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchvw_datidirettoretiroException {
		return getPersistence().remove(vw_datidirettoretiroPK);
	}

	public static it.ethica.esf.model.vw_datidirettoretiro updateImpl(
		it.ethica.esf.model.vw_datidirettoretiro vw_datidirettoretiro)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(vw_datidirettoretiro);
	}

	/**
	* Returns the vw_datidirettoretiro with the primary key or throws a {@link it.ethica.esf.NoSuchvw_datidirettoretiroException} if it could not be found.
	*
	* @param vw_datidirettoretiroPK the primary key of the vw_datidirettoretiro
	* @return the vw_datidirettoretiro
	* @throws it.ethica.esf.NoSuchvw_datidirettoretiroException if a vw_datidirettoretiro with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.vw_datidirettoretiro findByPrimaryKey(
		vw_datidirettoretiroPK vw_datidirettoretiroPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchvw_datidirettoretiroException {
		return getPersistence().findByPrimaryKey(vw_datidirettoretiroPK);
	}

	/**
	* Returns the vw_datidirettoretiro with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param vw_datidirettoretiroPK the primary key of the vw_datidirettoretiro
	* @return the vw_datidirettoretiro, or <code>null</code> if a vw_datidirettoretiro with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.vw_datidirettoretiro fetchByPrimaryKey(
		vw_datidirettoretiroPK vw_datidirettoretiroPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(vw_datidirettoretiroPK);
	}

	/**
	* Returns all the vw_datidirettoretiros.
	*
	* @return the vw_datidirettoretiros
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.vw_datidirettoretiro> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the vw_datidirettoretiros.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.vw_datidirettoretiroModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of vw_datidirettoretiros
	* @param end the upper bound of the range of vw_datidirettoretiros (not inclusive)
	* @return the range of vw_datidirettoretiros
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.vw_datidirettoretiro> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the vw_datidirettoretiros.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.vw_datidirettoretiroModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of vw_datidirettoretiros
	* @param end the upper bound of the range of vw_datidirettoretiros (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of vw_datidirettoretiros
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.vw_datidirettoretiro> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the vw_datidirettoretiros from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of vw_datidirettoretiros.
	*
	* @return the number of vw_datidirettoretiros
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static vw_datidirettoretiroPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (vw_datidirettoretiroPersistence)PortletBeanLocatorUtil.locate(it.ethica.esf.service.ClpSerializer.getServletContextName(),
					vw_datidirettoretiroPersistence.class.getName());

			ReferenceRegistry.registerReference(vw_datidirettoretiroUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(vw_datidirettoretiroPersistence persistence) {
	}

	private static vw_datidirettoretiroPersistence _persistence;
}