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

import it.ethica.esf.model.VW_ESFIncarichiFederali;

import java.util.List;

/**
 * The persistence utility for the v w_ e s f incarichi federali service. This utility wraps {@link VW_ESFIncarichiFederaliPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see VW_ESFIncarichiFederaliPersistence
 * @see VW_ESFIncarichiFederaliPersistenceImpl
 * @generated
 */
public class VW_ESFIncarichiFederaliUtil {
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
	public static void clearCache(
		VW_ESFIncarichiFederali vw_esfIncarichiFederali) {
		getPersistence().clearCache(vw_esfIncarichiFederali);
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
	public static List<VW_ESFIncarichiFederali> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<VW_ESFIncarichiFederali> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<VW_ESFIncarichiFederali> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static VW_ESFIncarichiFederali update(
		VW_ESFIncarichiFederali vw_esfIncarichiFederali)
		throws SystemException {
		return getPersistence().update(vw_esfIncarichiFederali);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static VW_ESFIncarichiFederali update(
		VW_ESFIncarichiFederali vw_esfIncarichiFederali,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(vw_esfIncarichiFederali, serviceContext);
	}

	/**
	* Returns all the v w_ e s f incarichi federalis where active_ = &#63; and esfUserId = &#63;.
	*
	* @param active_ the active_
	* @param esfUserId the esf user ID
	* @return the matching v w_ e s f incarichi federalis
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.VW_ESFIncarichiFederali> findBylistaIncarichi(
		boolean active_, long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBylistaIncarichi(active_, esfUserId);
	}

	/**
	* Returns a range of all the v w_ e s f incarichi federalis where active_ = &#63; and esfUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.VW_ESFIncarichiFederaliModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param active_ the active_
	* @param esfUserId the esf user ID
	* @param start the lower bound of the range of v w_ e s f incarichi federalis
	* @param end the upper bound of the range of v w_ e s f incarichi federalis (not inclusive)
	* @return the range of matching v w_ e s f incarichi federalis
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.VW_ESFIncarichiFederali> findBylistaIncarichi(
		boolean active_, long esfUserId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBylistaIncarichi(active_, esfUserId, start, end);
	}

	/**
	* Returns an ordered range of all the v w_ e s f incarichi federalis where active_ = &#63; and esfUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.VW_ESFIncarichiFederaliModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param active_ the active_
	* @param esfUserId the esf user ID
	* @param start the lower bound of the range of v w_ e s f incarichi federalis
	* @param end the upper bound of the range of v w_ e s f incarichi federalis (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching v w_ e s f incarichi federalis
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.VW_ESFIncarichiFederali> findBylistaIncarichi(
		boolean active_, long esfUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBylistaIncarichi(active_, esfUserId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first v w_ e s f incarichi federali in the ordered set where active_ = &#63; and esfUserId = &#63;.
	*
	* @param active_ the active_
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v w_ e s f incarichi federali
	* @throws it.ethica.esf.NoSuchVW_ESFIncarichiFederaliException if a matching v w_ e s f incarichi federali could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.VW_ESFIncarichiFederali findBylistaIncarichi_First(
		boolean active_, long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchVW_ESFIncarichiFederaliException {
		return getPersistence()
				   .findBylistaIncarichi_First(active_, esfUserId,
			orderByComparator);
	}

	/**
	* Returns the first v w_ e s f incarichi federali in the ordered set where active_ = &#63; and esfUserId = &#63;.
	*
	* @param active_ the active_
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v w_ e s f incarichi federali, or <code>null</code> if a matching v w_ e s f incarichi federali could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.VW_ESFIncarichiFederali fetchBylistaIncarichi_First(
		boolean active_, long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBylistaIncarichi_First(active_, esfUserId,
			orderByComparator);
	}

	/**
	* Returns the last v w_ e s f incarichi federali in the ordered set where active_ = &#63; and esfUserId = &#63;.
	*
	* @param active_ the active_
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v w_ e s f incarichi federali
	* @throws it.ethica.esf.NoSuchVW_ESFIncarichiFederaliException if a matching v w_ e s f incarichi federali could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.VW_ESFIncarichiFederali findBylistaIncarichi_Last(
		boolean active_, long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchVW_ESFIncarichiFederaliException {
		return getPersistence()
				   .findBylistaIncarichi_Last(active_, esfUserId,
			orderByComparator);
	}

	/**
	* Returns the last v w_ e s f incarichi federali in the ordered set where active_ = &#63; and esfUserId = &#63;.
	*
	* @param active_ the active_
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v w_ e s f incarichi federali, or <code>null</code> if a matching v w_ e s f incarichi federali could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.VW_ESFIncarichiFederali fetchBylistaIncarichi_Last(
		boolean active_, long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBylistaIncarichi_Last(active_, esfUserId,
			orderByComparator);
	}

	/**
	* Returns the v w_ e s f incarichi federalis before and after the current v w_ e s f incarichi federali in the ordered set where active_ = &#63; and esfUserId = &#63;.
	*
	* @param vw_esfIncarichiFederaliPK the primary key of the current v w_ e s f incarichi federali
	* @param active_ the active_
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next v w_ e s f incarichi federali
	* @throws it.ethica.esf.NoSuchVW_ESFIncarichiFederaliException if a v w_ e s f incarichi federali with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.VW_ESFIncarichiFederali[] findBylistaIncarichi_PrevAndNext(
		VW_ESFIncarichiFederaliPK vw_esfIncarichiFederaliPK, boolean active_,
		long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchVW_ESFIncarichiFederaliException {
		return getPersistence()
				   .findBylistaIncarichi_PrevAndNext(vw_esfIncarichiFederaliPK,
			active_, esfUserId, orderByComparator);
	}

	/**
	* Removes all the v w_ e s f incarichi federalis where active_ = &#63; and esfUserId = &#63; from the database.
	*
	* @param active_ the active_
	* @param esfUserId the esf user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBylistaIncarichi(boolean active_, long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBylistaIncarichi(active_, esfUserId);
	}

	/**
	* Returns the number of v w_ e s f incarichi federalis where active_ = &#63; and esfUserId = &#63;.
	*
	* @param active_ the active_
	* @param esfUserId the esf user ID
	* @return the number of matching v w_ e s f incarichi federalis
	* @throws SystemException if a system exception occurred
	*/
	public static int countBylistaIncarichi(boolean active_, long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBylistaIncarichi(active_, esfUserId);
	}

	/**
	* Caches the v w_ e s f incarichi federali in the entity cache if it is enabled.
	*
	* @param vw_esfIncarichiFederali the v w_ e s f incarichi federali
	*/
	public static void cacheResult(
		it.ethica.esf.model.VW_ESFIncarichiFederali vw_esfIncarichiFederali) {
		getPersistence().cacheResult(vw_esfIncarichiFederali);
	}

	/**
	* Caches the v w_ e s f incarichi federalis in the entity cache if it is enabled.
	*
	* @param vw_esfIncarichiFederalis the v w_ e s f incarichi federalis
	*/
	public static void cacheResult(
		java.util.List<it.ethica.esf.model.VW_ESFIncarichiFederali> vw_esfIncarichiFederalis) {
		getPersistence().cacheResult(vw_esfIncarichiFederalis);
	}

	/**
	* Creates a new v w_ e s f incarichi federali with the primary key. Does not add the v w_ e s f incarichi federali to the database.
	*
	* @param vw_esfIncarichiFederaliPK the primary key for the new v w_ e s f incarichi federali
	* @return the new v w_ e s f incarichi federali
	*/
	public static it.ethica.esf.model.VW_ESFIncarichiFederali create(
		VW_ESFIncarichiFederaliPK vw_esfIncarichiFederaliPK) {
		return getPersistence().create(vw_esfIncarichiFederaliPK);
	}

	/**
	* Removes the v w_ e s f incarichi federali with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param vw_esfIncarichiFederaliPK the primary key of the v w_ e s f incarichi federali
	* @return the v w_ e s f incarichi federali that was removed
	* @throws it.ethica.esf.NoSuchVW_ESFIncarichiFederaliException if a v w_ e s f incarichi federali with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.VW_ESFIncarichiFederali remove(
		VW_ESFIncarichiFederaliPK vw_esfIncarichiFederaliPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchVW_ESFIncarichiFederaliException {
		return getPersistence().remove(vw_esfIncarichiFederaliPK);
	}

	public static it.ethica.esf.model.VW_ESFIncarichiFederali updateImpl(
		it.ethica.esf.model.VW_ESFIncarichiFederali vw_esfIncarichiFederali)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(vw_esfIncarichiFederali);
	}

	/**
	* Returns the v w_ e s f incarichi federali with the primary key or throws a {@link it.ethica.esf.NoSuchVW_ESFIncarichiFederaliException} if it could not be found.
	*
	* @param vw_esfIncarichiFederaliPK the primary key of the v w_ e s f incarichi federali
	* @return the v w_ e s f incarichi federali
	* @throws it.ethica.esf.NoSuchVW_ESFIncarichiFederaliException if a v w_ e s f incarichi federali with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.VW_ESFIncarichiFederali findByPrimaryKey(
		VW_ESFIncarichiFederaliPK vw_esfIncarichiFederaliPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchVW_ESFIncarichiFederaliException {
		return getPersistence().findByPrimaryKey(vw_esfIncarichiFederaliPK);
	}

	/**
	* Returns the v w_ e s f incarichi federali with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param vw_esfIncarichiFederaliPK the primary key of the v w_ e s f incarichi federali
	* @return the v w_ e s f incarichi federali, or <code>null</code> if a v w_ e s f incarichi federali with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.VW_ESFIncarichiFederali fetchByPrimaryKey(
		VW_ESFIncarichiFederaliPK vw_esfIncarichiFederaliPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(vw_esfIncarichiFederaliPK);
	}

	/**
	* Returns all the v w_ e s f incarichi federalis.
	*
	* @return the v w_ e s f incarichi federalis
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.VW_ESFIncarichiFederali> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the v w_ e s f incarichi federalis.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.VW_ESFIncarichiFederaliModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of v w_ e s f incarichi federalis
	* @param end the upper bound of the range of v w_ e s f incarichi federalis (not inclusive)
	* @return the range of v w_ e s f incarichi federalis
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.VW_ESFIncarichiFederali> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the v w_ e s f incarichi federalis.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.VW_ESFIncarichiFederaliModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of v w_ e s f incarichi federalis
	* @param end the upper bound of the range of v w_ e s f incarichi federalis (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of v w_ e s f incarichi federalis
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.VW_ESFIncarichiFederali> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the v w_ e s f incarichi federalis from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of v w_ e s f incarichi federalis.
	*
	* @return the number of v w_ e s f incarichi federalis
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static VW_ESFIncarichiFederaliPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (VW_ESFIncarichiFederaliPersistence)PortletBeanLocatorUtil.locate(it.ethica.esf.service.ClpSerializer.getServletContextName(),
					VW_ESFIncarichiFederaliPersistence.class.getName());

			ReferenceRegistry.registerReference(VW_ESFIncarichiFederaliUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(VW_ESFIncarichiFederaliPersistence persistence) {
	}

	private static VW_ESFIncarichiFederaliPersistence _persistence;
}