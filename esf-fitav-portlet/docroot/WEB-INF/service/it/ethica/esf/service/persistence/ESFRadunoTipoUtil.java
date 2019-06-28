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

import it.ethica.esf.model.ESFRadunoTipo;

import java.util.List;

/**
 * The persistence utility for the e s f raduno tipo service. This utility wraps {@link ESFRadunoTipoPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFRadunoTipoPersistence
 * @see ESFRadunoTipoPersistenceImpl
 * @generated
 */
public class ESFRadunoTipoUtil {
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
	public static void clearCache(ESFRadunoTipo esfRadunoTipo) {
		getPersistence().clearCache(esfRadunoTipo);
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
	public static List<ESFRadunoTipo> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ESFRadunoTipo> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ESFRadunoTipo> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ESFRadunoTipo update(ESFRadunoTipo esfRadunoTipo)
		throws SystemException {
		return getPersistence().update(esfRadunoTipo);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ESFRadunoTipo update(ESFRadunoTipo esfRadunoTipo,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(esfRadunoTipo, serviceContext);
	}

	/**
	* Caches the e s f raduno tipo in the entity cache if it is enabled.
	*
	* @param esfRadunoTipo the e s f raduno tipo
	*/
	public static void cacheResult(
		it.ethica.esf.model.ESFRadunoTipo esfRadunoTipo) {
		getPersistence().cacheResult(esfRadunoTipo);
	}

	/**
	* Caches the e s f raduno tipos in the entity cache if it is enabled.
	*
	* @param esfRadunoTipos the e s f raduno tipos
	*/
	public static void cacheResult(
		java.util.List<it.ethica.esf.model.ESFRadunoTipo> esfRadunoTipos) {
		getPersistence().cacheResult(esfRadunoTipos);
	}

	/**
	* Creates a new e s f raduno tipo with the primary key. Does not add the e s f raduno tipo to the database.
	*
	* @param id_esf_raduno_tipo the primary key for the new e s f raduno tipo
	* @return the new e s f raduno tipo
	*/
	public static it.ethica.esf.model.ESFRadunoTipo create(
		long id_esf_raduno_tipo) {
		return getPersistence().create(id_esf_raduno_tipo);
	}

	/**
	* Removes the e s f raduno tipo with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_esf_raduno_tipo the primary key of the e s f raduno tipo
	* @return the e s f raduno tipo that was removed
	* @throws it.ethica.esf.NoSuchRadunoTipoException if a e s f raduno tipo with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFRadunoTipo remove(
		long id_esf_raduno_tipo)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchRadunoTipoException {
		return getPersistence().remove(id_esf_raduno_tipo);
	}

	public static it.ethica.esf.model.ESFRadunoTipo updateImpl(
		it.ethica.esf.model.ESFRadunoTipo esfRadunoTipo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(esfRadunoTipo);
	}

	/**
	* Returns the e s f raduno tipo with the primary key or throws a {@link it.ethica.esf.NoSuchRadunoTipoException} if it could not be found.
	*
	* @param id_esf_raduno_tipo the primary key of the e s f raduno tipo
	* @return the e s f raduno tipo
	* @throws it.ethica.esf.NoSuchRadunoTipoException if a e s f raduno tipo with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFRadunoTipo findByPrimaryKey(
		long id_esf_raduno_tipo)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchRadunoTipoException {
		return getPersistence().findByPrimaryKey(id_esf_raduno_tipo);
	}

	/**
	* Returns the e s f raduno tipo with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id_esf_raduno_tipo the primary key of the e s f raduno tipo
	* @return the e s f raduno tipo, or <code>null</code> if a e s f raduno tipo with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFRadunoTipo fetchByPrimaryKey(
		long id_esf_raduno_tipo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id_esf_raduno_tipo);
	}

	/**
	* Returns all the e s f raduno tipos.
	*
	* @return the e s f raduno tipos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFRadunoTipo> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the e s f raduno tipos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFRadunoTipoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f raduno tipos
	* @param end the upper bound of the range of e s f raduno tipos (not inclusive)
	* @return the range of e s f raduno tipos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFRadunoTipo> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the e s f raduno tipos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFRadunoTipoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f raduno tipos
	* @param end the upper bound of the range of e s f raduno tipos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of e s f raduno tipos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFRadunoTipo> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the e s f raduno tipos from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of e s f raduno tipos.
	*
	* @return the number of e s f raduno tipos
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ESFRadunoTipoPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ESFRadunoTipoPersistence)PortletBeanLocatorUtil.locate(it.ethica.esf.service.ClpSerializer.getServletContextName(),
					ESFRadunoTipoPersistence.class.getName());

			ReferenceRegistry.registerReference(ESFRadunoTipoUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ESFRadunoTipoPersistence persistence) {
	}

	private static ESFRadunoTipoPersistence _persistence;
}