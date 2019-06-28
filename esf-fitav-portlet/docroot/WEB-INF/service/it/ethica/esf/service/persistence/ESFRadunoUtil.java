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

import it.ethica.esf.model.ESFRaduno;

import java.util.List;

/**
 * The persistence utility for the e s f raduno service. This utility wraps {@link ESFRadunoPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFRadunoPersistence
 * @see ESFRadunoPersistenceImpl
 * @generated
 */
public class ESFRadunoUtil {
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
	public static void clearCache(ESFRaduno esfRaduno) {
		getPersistence().clearCache(esfRaduno);
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
	public static List<ESFRaduno> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ESFRaduno> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ESFRaduno> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ESFRaduno update(ESFRaduno esfRaduno)
		throws SystemException {
		return getPersistence().update(esfRaduno);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ESFRaduno update(ESFRaduno esfRaduno,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(esfRaduno, serviceContext);
	}

	/**
	* Caches the e s f raduno in the entity cache if it is enabled.
	*
	* @param esfRaduno the e s f raduno
	*/
	public static void cacheResult(it.ethica.esf.model.ESFRaduno esfRaduno) {
		getPersistence().cacheResult(esfRaduno);
	}

	/**
	* Caches the e s f radunos in the entity cache if it is enabled.
	*
	* @param esfRadunos the e s f radunos
	*/
	public static void cacheResult(
		java.util.List<it.ethica.esf.model.ESFRaduno> esfRadunos) {
		getPersistence().cacheResult(esfRadunos);
	}

	/**
	* Creates a new e s f raduno with the primary key. Does not add the e s f raduno to the database.
	*
	* @param id_esf_raduno the primary key for the new e s f raduno
	* @return the new e s f raduno
	*/
	public static it.ethica.esf.model.ESFRaduno create(long id_esf_raduno) {
		return getPersistence().create(id_esf_raduno);
	}

	/**
	* Removes the e s f raduno with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_esf_raduno the primary key of the e s f raduno
	* @return the e s f raduno that was removed
	* @throws it.ethica.esf.NoSuchRadunoException if a e s f raduno with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFRaduno remove(long id_esf_raduno)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchRadunoException {
		return getPersistence().remove(id_esf_raduno);
	}

	public static it.ethica.esf.model.ESFRaduno updateImpl(
		it.ethica.esf.model.ESFRaduno esfRaduno)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(esfRaduno);
	}

	/**
	* Returns the e s f raduno with the primary key or throws a {@link it.ethica.esf.NoSuchRadunoException} if it could not be found.
	*
	* @param id_esf_raduno the primary key of the e s f raduno
	* @return the e s f raduno
	* @throws it.ethica.esf.NoSuchRadunoException if a e s f raduno with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFRaduno findByPrimaryKey(
		long id_esf_raduno)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchRadunoException {
		return getPersistence().findByPrimaryKey(id_esf_raduno);
	}

	/**
	* Returns the e s f raduno with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id_esf_raduno the primary key of the e s f raduno
	* @return the e s f raduno, or <code>null</code> if a e s f raduno with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFRaduno fetchByPrimaryKey(
		long id_esf_raduno)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id_esf_raduno);
	}

	/**
	* Returns all the e s f radunos.
	*
	* @return the e s f radunos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFRaduno> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the e s f radunos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFRadunoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f radunos
	* @param end the upper bound of the range of e s f radunos (not inclusive)
	* @return the range of e s f radunos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFRaduno> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the e s f radunos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFRadunoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f radunos
	* @param end the upper bound of the range of e s f radunos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of e s f radunos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFRaduno> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the e s f radunos from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of e s f radunos.
	*
	* @return the number of e s f radunos
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ESFRadunoPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ESFRadunoPersistence)PortletBeanLocatorUtil.locate(it.ethica.esf.service.ClpSerializer.getServletContextName(),
					ESFRadunoPersistence.class.getName());

			ReferenceRegistry.registerReference(ESFRadunoUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ESFRadunoPersistence persistence) {
	}

	private static ESFRadunoPersistence _persistence;
}