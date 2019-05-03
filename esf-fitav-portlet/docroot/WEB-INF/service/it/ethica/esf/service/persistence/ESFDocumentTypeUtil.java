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

import it.ethica.esf.model.ESFDocumentType;

import java.util.List;

/**
 * The persistence utility for the e s f document type service. This utility wraps {@link ESFDocumentTypePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFDocumentTypePersistence
 * @see ESFDocumentTypePersistenceImpl
 * @generated
 */
public class ESFDocumentTypeUtil {
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
	public static void clearCache(ESFDocumentType esfDocumentType) {
		getPersistence().clearCache(esfDocumentType);
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
	public static List<ESFDocumentType> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ESFDocumentType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ESFDocumentType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ESFDocumentType update(ESFDocumentType esfDocumentType)
		throws SystemException {
		return getPersistence().update(esfDocumentType);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ESFDocumentType update(ESFDocumentType esfDocumentType,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(esfDocumentType, serviceContext);
	}

	/**
	* Caches the e s f document type in the entity cache if it is enabled.
	*
	* @param esfDocumentType the e s f document type
	*/
	public static void cacheResult(
		it.ethica.esf.model.ESFDocumentType esfDocumentType) {
		getPersistence().cacheResult(esfDocumentType);
	}

	/**
	* Caches the e s f document types in the entity cache if it is enabled.
	*
	* @param esfDocumentTypes the e s f document types
	*/
	public static void cacheResult(
		java.util.List<it.ethica.esf.model.ESFDocumentType> esfDocumentTypes) {
		getPersistence().cacheResult(esfDocumentTypes);
	}

	/**
	* Creates a new e s f document type with the primary key. Does not add the e s f document type to the database.
	*
	* @param esfDocumentTypeId the primary key for the new e s f document type
	* @return the new e s f document type
	*/
	public static it.ethica.esf.model.ESFDocumentType create(
		long esfDocumentTypeId) {
		return getPersistence().create(esfDocumentTypeId);
	}

	/**
	* Removes the e s f document type with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfDocumentTypeId the primary key of the e s f document type
	* @return the e s f document type that was removed
	* @throws it.ethica.esf.NoSuchDocumentTypeException if a e s f document type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFDocumentType remove(
		long esfDocumentTypeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchDocumentTypeException {
		return getPersistence().remove(esfDocumentTypeId);
	}

	public static it.ethica.esf.model.ESFDocumentType updateImpl(
		it.ethica.esf.model.ESFDocumentType esfDocumentType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(esfDocumentType);
	}

	/**
	* Returns the e s f document type with the primary key or throws a {@link it.ethica.esf.NoSuchDocumentTypeException} if it could not be found.
	*
	* @param esfDocumentTypeId the primary key of the e s f document type
	* @return the e s f document type
	* @throws it.ethica.esf.NoSuchDocumentTypeException if a e s f document type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFDocumentType findByPrimaryKey(
		long esfDocumentTypeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchDocumentTypeException {
		return getPersistence().findByPrimaryKey(esfDocumentTypeId);
	}

	/**
	* Returns the e s f document type with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param esfDocumentTypeId the primary key of the e s f document type
	* @return the e s f document type, or <code>null</code> if a e s f document type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFDocumentType fetchByPrimaryKey(
		long esfDocumentTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(esfDocumentTypeId);
	}

	/**
	* Returns all the e s f document types.
	*
	* @return the e s f document types
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFDocumentType> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the e s f document types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFDocumentTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f document types
	* @param end the upper bound of the range of e s f document types (not inclusive)
	* @return the range of e s f document types
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFDocumentType> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the e s f document types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFDocumentTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f document types
	* @param end the upper bound of the range of e s f document types (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of e s f document types
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFDocumentType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the e s f document types from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of e s f document types.
	*
	* @return the number of e s f document types
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ESFDocumentTypePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ESFDocumentTypePersistence)PortletBeanLocatorUtil.locate(it.ethica.esf.service.ClpSerializer.getServletContextName(),
					ESFDocumentTypePersistence.class.getName());

			ReferenceRegistry.registerReference(ESFDocumentTypeUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ESFDocumentTypePersistence persistence) {
	}

	private static ESFDocumentTypePersistence _persistence;
}