/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

import it.ethica.esf.model.ESFElectronic;

import java.util.List;

/**
 * The persistence utility for the e s f electronic service. This utility wraps {@link ESFElectronicPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFElectronicPersistence
 * @see ESFElectronicPersistenceImpl
 * @generated
 */
public class ESFElectronicUtil {
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
	public static void clearCache(ESFElectronic esfElectronic) {
		getPersistence().clearCache(esfElectronic);
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
	public static List<ESFElectronic> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ESFElectronic> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ESFElectronic> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ESFElectronic update(ESFElectronic esfElectronic)
		throws SystemException {
		return getPersistence().update(esfElectronic);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ESFElectronic update(ESFElectronic esfElectronic,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(esfElectronic, serviceContext);
	}

	/**
	* Caches the e s f electronic in the entity cache if it is enabled.
	*
	* @param esfElectronic the e s f electronic
	*/
	public static void cacheResult(
		it.ethica.esf.model.ESFElectronic esfElectronic) {
		getPersistence().cacheResult(esfElectronic);
	}

	/**
	* Caches the e s f electronics in the entity cache if it is enabled.
	*
	* @param esfElectronics the e s f electronics
	*/
	public static void cacheResult(
		java.util.List<it.ethica.esf.model.ESFElectronic> esfElectronics) {
		getPersistence().cacheResult(esfElectronics);
	}

	/**
	* Creates a new e s f electronic with the primary key. Does not add the e s f electronic to the database.
	*
	* @param electronicId the primary key for the new e s f electronic
	* @return the new e s f electronic
	*/
	public static it.ethica.esf.model.ESFElectronic create(long electronicId) {
		return getPersistence().create(electronicId);
	}

	/**
	* Removes the e s f electronic with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param electronicId the primary key of the e s f electronic
	* @return the e s f electronic that was removed
	* @throws it.ethica.esf.NoSuchElectronicException if a e s f electronic with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFElectronic remove(long electronicId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchElectronicException {
		return getPersistence().remove(electronicId);
	}

	public static it.ethica.esf.model.ESFElectronic updateImpl(
		it.ethica.esf.model.ESFElectronic esfElectronic)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(esfElectronic);
	}

	/**
	* Returns the e s f electronic with the primary key or throws a {@link it.ethica.esf.NoSuchElectronicException} if it could not be found.
	*
	* @param electronicId the primary key of the e s f electronic
	* @return the e s f electronic
	* @throws it.ethica.esf.NoSuchElectronicException if a e s f electronic with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFElectronic findByPrimaryKey(
		long electronicId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchElectronicException {
		return getPersistence().findByPrimaryKey(electronicId);
	}

	/**
	* Returns the e s f electronic with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param electronicId the primary key of the e s f electronic
	* @return the e s f electronic, or <code>null</code> if a e s f electronic with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFElectronic fetchByPrimaryKey(
		long electronicId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(electronicId);
	}

	/**
	* Returns all the e s f electronics.
	*
	* @return the e s f electronics
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFElectronic> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the e s f electronics.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFElectronicModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f electronics
	* @param end the upper bound of the range of e s f electronics (not inclusive)
	* @return the range of e s f electronics
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFElectronic> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the e s f electronics.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFElectronicModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f electronics
	* @param end the upper bound of the range of e s f electronics (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of e s f electronics
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFElectronic> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the e s f electronics from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of e s f electronics.
	*
	* @return the number of e s f electronics
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ESFElectronicPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ESFElectronicPersistence)PortletBeanLocatorUtil.locate(it.ethica.esf.service.ClpSerializer.getServletContextName(),
					ESFElectronicPersistence.class.getName());

			ReferenceRegistry.registerReference(ESFElectronicUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ESFElectronicPersistence persistence) {
	}

	private static ESFElectronicPersistence _persistence;
}