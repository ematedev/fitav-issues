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

import it.ethica.esf.model.ESFOrganization_Reengineered;

import java.util.List;

/**
 * The persistence utility for the e s f organization_ reengineered service. This utility wraps {@link ESFOrganization_ReengineeredPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFOrganization_ReengineeredPersistence
 * @see ESFOrganization_ReengineeredPersistenceImpl
 * @generated
 */
public class ESFOrganization_ReengineeredUtil {
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
		ESFOrganization_Reengineered esfOrganization_Reengineered) {
		getPersistence().clearCache(esfOrganization_Reengineered);
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
	public static List<ESFOrganization_Reengineered> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ESFOrganization_Reengineered> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ESFOrganization_Reengineered> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ESFOrganization_Reengineered update(
		ESFOrganization_Reengineered esfOrganization_Reengineered)
		throws SystemException {
		return getPersistence().update(esfOrganization_Reengineered);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ESFOrganization_Reengineered update(
		ESFOrganization_Reengineered esfOrganization_Reengineered,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence()
				   .update(esfOrganization_Reengineered, serviceContext);
	}

	/**
	* Returns all the e s f organization_ reengineereds where type_ = &#63;.
	*
	* @param type_ the type_
	* @return the matching e s f organization_ reengineereds
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFOrganization_Reengineered> findByFindOrganizationByType(
		int type_) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByFindOrganizationByType(type_);
	}

	/**
	* Returns a range of all the e s f organization_ reengineereds where type_ = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFOrganization_ReengineeredModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param type_ the type_
	* @param start the lower bound of the range of e s f organization_ reengineereds
	* @param end the upper bound of the range of e s f organization_ reengineereds (not inclusive)
	* @return the range of matching e s f organization_ reengineereds
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFOrganization_Reengineered> findByFindOrganizationByType(
		int type_, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByFindOrganizationByType(type_, start, end);
	}

	/**
	* Returns an ordered range of all the e s f organization_ reengineereds where type_ = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFOrganization_ReengineeredModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param type_ the type_
	* @param start the lower bound of the range of e s f organization_ reengineereds
	* @param end the upper bound of the range of e s f organization_ reengineereds (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f organization_ reengineereds
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFOrganization_Reengineered> findByFindOrganizationByType(
		int type_, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByFindOrganizationByType(type_, start, end,
			orderByComparator);
	}

	/**
	* Returns the first e s f organization_ reengineered in the ordered set where type_ = &#63;.
	*
	* @param type_ the type_
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f organization_ reengineered
	* @throws it.ethica.esf.NoSuchOrganization_ReengineeredException if a matching e s f organization_ reengineered could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFOrganization_Reengineered findByFindOrganizationByType_First(
		int type_,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchOrganization_ReengineeredException {
		return getPersistence()
				   .findByFindOrganizationByType_First(type_, orderByComparator);
	}

	/**
	* Returns the first e s f organization_ reengineered in the ordered set where type_ = &#63;.
	*
	* @param type_ the type_
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f organization_ reengineered, or <code>null</code> if a matching e s f organization_ reengineered could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFOrganization_Reengineered fetchByFindOrganizationByType_First(
		int type_,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByFindOrganizationByType_First(type_, orderByComparator);
	}

	/**
	* Returns the last e s f organization_ reengineered in the ordered set where type_ = &#63;.
	*
	* @param type_ the type_
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f organization_ reengineered
	* @throws it.ethica.esf.NoSuchOrganization_ReengineeredException if a matching e s f organization_ reengineered could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFOrganization_Reengineered findByFindOrganizationByType_Last(
		int type_,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchOrganization_ReengineeredException {
		return getPersistence()
				   .findByFindOrganizationByType_Last(type_, orderByComparator);
	}

	/**
	* Returns the last e s f organization_ reengineered in the ordered set where type_ = &#63;.
	*
	* @param type_ the type_
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f organization_ reengineered, or <code>null</code> if a matching e s f organization_ reengineered could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFOrganization_Reengineered fetchByFindOrganizationByType_Last(
		int type_,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByFindOrganizationByType_Last(type_, orderByComparator);
	}

	/**
	* Returns the e s f organization_ reengineereds before and after the current e s f organization_ reengineered in the ordered set where type_ = &#63;.
	*
	* @param esfOrganizationId the primary key of the current e s f organization_ reengineered
	* @param type_ the type_
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f organization_ reengineered
	* @throws it.ethica.esf.NoSuchOrganization_ReengineeredException if a e s f organization_ reengineered with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFOrganization_Reengineered[] findByFindOrganizationByType_PrevAndNext(
		long esfOrganizationId, int type_,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchOrganization_ReengineeredException {
		return getPersistence()
				   .findByFindOrganizationByType_PrevAndNext(esfOrganizationId,
			type_, orderByComparator);
	}

	/**
	* Removes all the e s f organization_ reengineereds where type_ = &#63; from the database.
	*
	* @param type_ the type_
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByFindOrganizationByType(int type_)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByFindOrganizationByType(type_);
	}

	/**
	* Returns the number of e s f organization_ reengineereds where type_ = &#63;.
	*
	* @param type_ the type_
	* @return the number of matching e s f organization_ reengineereds
	* @throws SystemException if a system exception occurred
	*/
	public static int countByFindOrganizationByType(int type_)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByFindOrganizationByType(type_);
	}

	/**
	* Caches the e s f organization_ reengineered in the entity cache if it is enabled.
	*
	* @param esfOrganization_Reengineered the e s f organization_ reengineered
	*/
	public static void cacheResult(
		it.ethica.esf.model.ESFOrganization_Reengineered esfOrganization_Reengineered) {
		getPersistence().cacheResult(esfOrganization_Reengineered);
	}

	/**
	* Caches the e s f organization_ reengineereds in the entity cache if it is enabled.
	*
	* @param esfOrganization_Reengineereds the e s f organization_ reengineereds
	*/
	public static void cacheResult(
		java.util.List<it.ethica.esf.model.ESFOrganization_Reengineered> esfOrganization_Reengineereds) {
		getPersistence().cacheResult(esfOrganization_Reengineereds);
	}

	/**
	* Creates a new e s f organization_ reengineered with the primary key. Does not add the e s f organization_ reengineered to the database.
	*
	* @param esfOrganizationId the primary key for the new e s f organization_ reengineered
	* @return the new e s f organization_ reengineered
	*/
	public static it.ethica.esf.model.ESFOrganization_Reengineered create(
		long esfOrganizationId) {
		return getPersistence().create(esfOrganizationId);
	}

	/**
	* Removes the e s f organization_ reengineered with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfOrganizationId the primary key of the e s f organization_ reengineered
	* @return the e s f organization_ reengineered that was removed
	* @throws it.ethica.esf.NoSuchOrganization_ReengineeredException if a e s f organization_ reengineered with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFOrganization_Reengineered remove(
		long esfOrganizationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchOrganization_ReengineeredException {
		return getPersistence().remove(esfOrganizationId);
	}

	public static it.ethica.esf.model.ESFOrganization_Reengineered updateImpl(
		it.ethica.esf.model.ESFOrganization_Reengineered esfOrganization_Reengineered)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(esfOrganization_Reengineered);
	}

	/**
	* Returns the e s f organization_ reengineered with the primary key or throws a {@link it.ethica.esf.NoSuchOrganization_ReengineeredException} if it could not be found.
	*
	* @param esfOrganizationId the primary key of the e s f organization_ reengineered
	* @return the e s f organization_ reengineered
	* @throws it.ethica.esf.NoSuchOrganization_ReengineeredException if a e s f organization_ reengineered with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFOrganization_Reengineered findByPrimaryKey(
		long esfOrganizationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchOrganization_ReengineeredException {
		return getPersistence().findByPrimaryKey(esfOrganizationId);
	}

	/**
	* Returns the e s f organization_ reengineered with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param esfOrganizationId the primary key of the e s f organization_ reengineered
	* @return the e s f organization_ reengineered, or <code>null</code> if a e s f organization_ reengineered with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFOrganization_Reengineered fetchByPrimaryKey(
		long esfOrganizationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(esfOrganizationId);
	}

	/**
	* Returns all the e s f organization_ reengineereds.
	*
	* @return the e s f organization_ reengineereds
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFOrganization_Reengineered> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the e s f organization_ reengineereds.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFOrganization_ReengineeredModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f organization_ reengineereds
	* @param end the upper bound of the range of e s f organization_ reengineereds (not inclusive)
	* @return the range of e s f organization_ reengineereds
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFOrganization_Reengineered> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the e s f organization_ reengineereds.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFOrganization_ReengineeredModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f organization_ reengineereds
	* @param end the upper bound of the range of e s f organization_ reengineereds (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of e s f organization_ reengineereds
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFOrganization_Reengineered> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the e s f organization_ reengineereds from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of e s f organization_ reengineereds.
	*
	* @return the number of e s f organization_ reengineereds
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ESFOrganization_ReengineeredPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ESFOrganization_ReengineeredPersistence)PortletBeanLocatorUtil.locate(it.ethica.esf.service.ClpSerializer.getServletContextName(),
					ESFOrganization_ReengineeredPersistence.class.getName());

			ReferenceRegistry.registerReference(ESFOrganization_ReengineeredUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(
		ESFOrganization_ReengineeredPersistence persistence) {
	}

	private static ESFOrganization_ReengineeredPersistence _persistence;
}