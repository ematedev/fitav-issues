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

import it.ethica.esf.model.ESFShootingDirectorQualification;

import java.util.List;

/**
 * The persistence utility for the e s f shooting director qualification service. This utility wraps {@link ESFShootingDirectorQualificationPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFShootingDirectorQualificationPersistence
 * @see ESFShootingDirectorQualificationPersistenceImpl
 * @generated
 */
public class ESFShootingDirectorQualificationUtil {
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
		ESFShootingDirectorQualification esfShootingDirectorQualification) {
		getPersistence().clearCache(esfShootingDirectorQualification);
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
	public static List<ESFShootingDirectorQualification> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ESFShootingDirectorQualification> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ESFShootingDirectorQualification> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ESFShootingDirectorQualification update(
		ESFShootingDirectorQualification esfShootingDirectorQualification)
		throws SystemException {
		return getPersistence().update(esfShootingDirectorQualification);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ESFShootingDirectorQualification update(
		ESFShootingDirectorQualification esfShootingDirectorQualification,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence()
				   .update(esfShootingDirectorQualification, serviceContext);
	}

	/**
	* Caches the e s f shooting director qualification in the entity cache if it is enabled.
	*
	* @param esfShootingDirectorQualification the e s f shooting director qualification
	*/
	public static void cacheResult(
		it.ethica.esf.model.ESFShootingDirectorQualification esfShootingDirectorQualification) {
		getPersistence().cacheResult(esfShootingDirectorQualification);
	}

	/**
	* Caches the e s f shooting director qualifications in the entity cache if it is enabled.
	*
	* @param esfShootingDirectorQualifications the e s f shooting director qualifications
	*/
	public static void cacheResult(
		java.util.List<it.ethica.esf.model.ESFShootingDirectorQualification> esfShootingDirectorQualifications) {
		getPersistence().cacheResult(esfShootingDirectorQualifications);
	}

	/**
	* Creates a new e s f shooting director qualification with the primary key. Does not add the e s f shooting director qualification to the database.
	*
	* @param esfShootingDirectorQualificationId the primary key for the new e s f shooting director qualification
	* @return the new e s f shooting director qualification
	*/
	public static it.ethica.esf.model.ESFShootingDirectorQualification create(
		long esfShootingDirectorQualificationId) {
		return getPersistence().create(esfShootingDirectorQualificationId);
	}

	/**
	* Removes the e s f shooting director qualification with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfShootingDirectorQualificationId the primary key of the e s f shooting director qualification
	* @return the e s f shooting director qualification that was removed
	* @throws it.ethica.esf.NoSuchShootingDirectorQualificationException if a e s f shooting director qualification with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFShootingDirectorQualification remove(
		long esfShootingDirectorQualificationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchShootingDirectorQualificationException {
		return getPersistence().remove(esfShootingDirectorQualificationId);
	}

	public static it.ethica.esf.model.ESFShootingDirectorQualification updateImpl(
		it.ethica.esf.model.ESFShootingDirectorQualification esfShootingDirectorQualification)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(esfShootingDirectorQualification);
	}

	/**
	* Returns the e s f shooting director qualification with the primary key or throws a {@link it.ethica.esf.NoSuchShootingDirectorQualificationException} if it could not be found.
	*
	* @param esfShootingDirectorQualificationId the primary key of the e s f shooting director qualification
	* @return the e s f shooting director qualification
	* @throws it.ethica.esf.NoSuchShootingDirectorQualificationException if a e s f shooting director qualification with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFShootingDirectorQualification findByPrimaryKey(
		long esfShootingDirectorQualificationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchShootingDirectorQualificationException {
		return getPersistence()
				   .findByPrimaryKey(esfShootingDirectorQualificationId);
	}

	/**
	* Returns the e s f shooting director qualification with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param esfShootingDirectorQualificationId the primary key of the e s f shooting director qualification
	* @return the e s f shooting director qualification, or <code>null</code> if a e s f shooting director qualification with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFShootingDirectorQualification fetchByPrimaryKey(
		long esfShootingDirectorQualificationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPrimaryKey(esfShootingDirectorQualificationId);
	}

	/**
	* Returns all the e s f shooting director qualifications.
	*
	* @return the e s f shooting director qualifications
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFShootingDirectorQualification> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the e s f shooting director qualifications.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShootingDirectorQualificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f shooting director qualifications
	* @param end the upper bound of the range of e s f shooting director qualifications (not inclusive)
	* @return the range of e s f shooting director qualifications
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFShootingDirectorQualification> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the e s f shooting director qualifications.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShootingDirectorQualificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f shooting director qualifications
	* @param end the upper bound of the range of e s f shooting director qualifications (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of e s f shooting director qualifications
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFShootingDirectorQualification> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the e s f shooting director qualifications from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of e s f shooting director qualifications.
	*
	* @return the number of e s f shooting director qualifications
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ESFShootingDirectorQualificationPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ESFShootingDirectorQualificationPersistence)PortletBeanLocatorUtil.locate(it.ethica.esf.service.ClpSerializer.getServletContextName(),
					ESFShootingDirectorQualificationPersistence.class.getName());

			ReferenceRegistry.registerReference(ESFShootingDirectorQualificationUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(
		ESFShootingDirectorQualificationPersistence persistence) {
	}

	private static ESFShootingDirectorQualificationPersistence _persistence;
}