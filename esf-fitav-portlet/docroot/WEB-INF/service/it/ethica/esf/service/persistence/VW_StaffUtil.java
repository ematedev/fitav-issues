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

import it.ethica.esf.model.VW_Staff;

import java.util.List;

/**
 * The persistence utility for the v w_ staff service. This utility wraps {@link VW_StaffPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see VW_StaffPersistence
 * @see VW_StaffPersistenceImpl
 * @generated
 */
public class VW_StaffUtil {
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
	public static void clearCache(VW_Staff vw_Staff) {
		getPersistence().clearCache(vw_Staff);
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
	public static List<VW_Staff> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<VW_Staff> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<VW_Staff> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static VW_Staff update(VW_Staff vw_Staff) throws SystemException {
		return getPersistence().update(vw_Staff);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static VW_Staff update(VW_Staff vw_Staff,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(vw_Staff, serviceContext);
	}

	/**
	* Caches the v w_ staff in the entity cache if it is enabled.
	*
	* @param vw_Staff the v w_ staff
	*/
	public static void cacheResult(it.ethica.esf.model.VW_Staff vw_Staff) {
		getPersistence().cacheResult(vw_Staff);
	}

	/**
	* Caches the v w_ staffs in the entity cache if it is enabled.
	*
	* @param vw_Staffs the v w_ staffs
	*/
	public static void cacheResult(
		java.util.List<it.ethica.esf.model.VW_Staff> vw_Staffs) {
		getPersistence().cacheResult(vw_Staffs);
	}

	/**
	* Creates a new v w_ staff with the primary key. Does not add the v w_ staff to the database.
	*
	* @param vw_StaffPK the primary key for the new v w_ staff
	* @return the new v w_ staff
	*/
	public static it.ethica.esf.model.VW_Staff create(
		it.ethica.esf.service.persistence.VW_StaffPK vw_StaffPK) {
		return getPersistence().create(vw_StaffPK);
	}

	/**
	* Removes the v w_ staff with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param vw_StaffPK the primary key of the v w_ staff
	* @return the v w_ staff that was removed
	* @throws it.ethica.esf.NoSuchVW_StaffException if a v w_ staff with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.VW_Staff remove(
		it.ethica.esf.service.persistence.VW_StaffPK vw_StaffPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchVW_StaffException {
		return getPersistence().remove(vw_StaffPK);
	}

	public static it.ethica.esf.model.VW_Staff updateImpl(
		it.ethica.esf.model.VW_Staff vw_Staff)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(vw_Staff);
	}

	/**
	* Returns the v w_ staff with the primary key or throws a {@link it.ethica.esf.NoSuchVW_StaffException} if it could not be found.
	*
	* @param vw_StaffPK the primary key of the v w_ staff
	* @return the v w_ staff
	* @throws it.ethica.esf.NoSuchVW_StaffException if a v w_ staff with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.VW_Staff findByPrimaryKey(
		it.ethica.esf.service.persistence.VW_StaffPK vw_StaffPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchVW_StaffException {
		return getPersistence().findByPrimaryKey(vw_StaffPK);
	}

	/**
	* Returns the v w_ staff with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param vw_StaffPK the primary key of the v w_ staff
	* @return the v w_ staff, or <code>null</code> if a v w_ staff with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.VW_Staff fetchByPrimaryKey(
		it.ethica.esf.service.persistence.VW_StaffPK vw_StaffPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(vw_StaffPK);
	}

	/**
	* Returns all the v w_ staffs.
	*
	* @return the v w_ staffs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.VW_Staff> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the v w_ staffs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.VW_StaffModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of v w_ staffs
	* @param end the upper bound of the range of v w_ staffs (not inclusive)
	* @return the range of v w_ staffs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.VW_Staff> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the v w_ staffs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.VW_StaffModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of v w_ staffs
	* @param end the upper bound of the range of v w_ staffs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of v w_ staffs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.VW_Staff> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the v w_ staffs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of v w_ staffs.
	*
	* @return the number of v w_ staffs
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static VW_StaffPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (VW_StaffPersistence)PortletBeanLocatorUtil.locate(it.ethica.esf.service.ClpSerializer.getServletContextName(),
					VW_StaffPersistence.class.getName());

			ReferenceRegistry.registerReference(VW_StaffUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(VW_StaffPersistence persistence) {
	}

	private static VW_StaffPersistence _persistence;
}