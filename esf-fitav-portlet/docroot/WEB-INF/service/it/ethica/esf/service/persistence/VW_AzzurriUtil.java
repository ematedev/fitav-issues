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

import it.ethica.esf.model.VW_Azzurri;

import java.util.List;

/**
 * The persistence utility for the v w_ azzurri service. This utility wraps {@link VW_AzzurriPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see VW_AzzurriPersistence
 * @see VW_AzzurriPersistenceImpl
 * @generated
 */
public class VW_AzzurriUtil {
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
	public static void clearCache(VW_Azzurri vw_Azzurri) {
		getPersistence().clearCache(vw_Azzurri);
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
	public static List<VW_Azzurri> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<VW_Azzurri> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<VW_Azzurri> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static VW_Azzurri update(VW_Azzurri vw_Azzurri)
		throws SystemException {
		return getPersistence().update(vw_Azzurri);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static VW_Azzurri update(VW_Azzurri vw_Azzurri,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(vw_Azzurri, serviceContext);
	}

	/**
	* Caches the v w_ azzurri in the entity cache if it is enabled.
	*
	* @param vw_Azzurri the v w_ azzurri
	*/
	public static void cacheResult(it.ethica.esf.model.VW_Azzurri vw_Azzurri) {
		getPersistence().cacheResult(vw_Azzurri);
	}

	/**
	* Caches the v w_ azzurris in the entity cache if it is enabled.
	*
	* @param vw_Azzurris the v w_ azzurris
	*/
	public static void cacheResult(
		java.util.List<it.ethica.esf.model.VW_Azzurri> vw_Azzurris) {
		getPersistence().cacheResult(vw_Azzurris);
	}

	/**
	* Creates a new v w_ azzurri with the primary key. Does not add the v w_ azzurri to the database.
	*
	* @param vw_AzzurriPK the primary key for the new v w_ azzurri
	* @return the new v w_ azzurri
	*/
	public static it.ethica.esf.model.VW_Azzurri create(
		it.ethica.esf.service.persistence.VW_AzzurriPK vw_AzzurriPK) {
		return getPersistence().create(vw_AzzurriPK);
	}

	/**
	* Removes the v w_ azzurri with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param vw_AzzurriPK the primary key of the v w_ azzurri
	* @return the v w_ azzurri that was removed
	* @throws it.ethica.esf.NoSuchVW_AzzurriException if a v w_ azzurri with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.VW_Azzurri remove(
		it.ethica.esf.service.persistence.VW_AzzurriPK vw_AzzurriPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchVW_AzzurriException {
		return getPersistence().remove(vw_AzzurriPK);
	}

	public static it.ethica.esf.model.VW_Azzurri updateImpl(
		it.ethica.esf.model.VW_Azzurri vw_Azzurri)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(vw_Azzurri);
	}

	/**
	* Returns the v w_ azzurri with the primary key or throws a {@link it.ethica.esf.NoSuchVW_AzzurriException} if it could not be found.
	*
	* @param vw_AzzurriPK the primary key of the v w_ azzurri
	* @return the v w_ azzurri
	* @throws it.ethica.esf.NoSuchVW_AzzurriException if a v w_ azzurri with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.VW_Azzurri findByPrimaryKey(
		it.ethica.esf.service.persistence.VW_AzzurriPK vw_AzzurriPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchVW_AzzurriException {
		return getPersistence().findByPrimaryKey(vw_AzzurriPK);
	}

	/**
	* Returns the v w_ azzurri with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param vw_AzzurriPK the primary key of the v w_ azzurri
	* @return the v w_ azzurri, or <code>null</code> if a v w_ azzurri with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.VW_Azzurri fetchByPrimaryKey(
		it.ethica.esf.service.persistence.VW_AzzurriPK vw_AzzurriPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(vw_AzzurriPK);
	}

	/**
	* Returns all the v w_ azzurris.
	*
	* @return the v w_ azzurris
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.VW_Azzurri> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the v w_ azzurris.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.VW_AzzurriModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of v w_ azzurris
	* @param end the upper bound of the range of v w_ azzurris (not inclusive)
	* @return the range of v w_ azzurris
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.VW_Azzurri> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the v w_ azzurris.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.VW_AzzurriModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of v w_ azzurris
	* @param end the upper bound of the range of v w_ azzurris (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of v w_ azzurris
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.VW_Azzurri> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the v w_ azzurris from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of v w_ azzurris.
	*
	* @return the number of v w_ azzurris
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static VW_AzzurriPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (VW_AzzurriPersistence)PortletBeanLocatorUtil.locate(it.ethica.esf.service.ClpSerializer.getServletContextName(),
					VW_AzzurriPersistence.class.getName());

			ReferenceRegistry.registerReference(VW_AzzurriUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(VW_AzzurriPersistence persistence) {
	}

	private static VW_AzzurriPersistence _persistence;
}