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

import it.ethica.esf.model.ESFLentField;

import java.util.List;

/**
 * The persistence utility for the e s f lent field service. This utility wraps {@link ESFLentFieldPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFLentFieldPersistence
 * @see ESFLentFieldPersistenceImpl
 * @generated
 */
public class ESFLentFieldUtil {
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
	public static void clearCache(ESFLentField esfLentField) {
		getPersistence().clearCache(esfLentField);
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
	public static List<ESFLentField> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ESFLentField> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ESFLentField> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ESFLentField update(ESFLentField esfLentField)
		throws SystemException {
		return getPersistence().update(esfLentField);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ESFLentField update(ESFLentField esfLentField,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(esfLentField, serviceContext);
	}

	/**
	* Returns the e s f lent field where esfFieldId = &#63; and esfEntityStateId = &#63; or throws a {@link it.ethica.esf.NoSuchLentFieldException} if it could not be found.
	*
	* @param esfFieldId the esf field ID
	* @param esfEntityStateId the esf entity state ID
	* @return the matching e s f lent field
	* @throws it.ethica.esf.NoSuchLentFieldException if a matching e s f lent field could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFLentField findByF_S(long esfFieldId,
		long esfEntityStateId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchLentFieldException {
		return getPersistence().findByF_S(esfFieldId, esfEntityStateId);
	}

	/**
	* Returns the e s f lent field where esfFieldId = &#63; and esfEntityStateId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param esfFieldId the esf field ID
	* @param esfEntityStateId the esf entity state ID
	* @return the matching e s f lent field, or <code>null</code> if a matching e s f lent field could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFLentField fetchByF_S(long esfFieldId,
		long esfEntityStateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByF_S(esfFieldId, esfEntityStateId);
	}

	/**
	* Returns the e s f lent field where esfFieldId = &#63; and esfEntityStateId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param esfFieldId the esf field ID
	* @param esfEntityStateId the esf entity state ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching e s f lent field, or <code>null</code> if a matching e s f lent field could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFLentField fetchByF_S(long esfFieldId,
		long esfEntityStateId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByF_S(esfFieldId, esfEntityStateId, retrieveFromCache);
	}

	/**
	* Removes the e s f lent field where esfFieldId = &#63; and esfEntityStateId = &#63; from the database.
	*
	* @param esfFieldId the esf field ID
	* @param esfEntityStateId the esf entity state ID
	* @return the e s f lent field that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFLentField removeByF_S(
		long esfFieldId, long esfEntityStateId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchLentFieldException {
		return getPersistence().removeByF_S(esfFieldId, esfEntityStateId);
	}

	/**
	* Returns the number of e s f lent fields where esfFieldId = &#63; and esfEntityStateId = &#63;.
	*
	* @param esfFieldId the esf field ID
	* @param esfEntityStateId the esf entity state ID
	* @return the number of matching e s f lent fields
	* @throws SystemException if a system exception occurred
	*/
	public static int countByF_S(long esfFieldId, long esfEntityStateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByF_S(esfFieldId, esfEntityStateId);
	}

	/**
	* Caches the e s f lent field in the entity cache if it is enabled.
	*
	* @param esfLentField the e s f lent field
	*/
	public static void cacheResult(
		it.ethica.esf.model.ESFLentField esfLentField) {
		getPersistence().cacheResult(esfLentField);
	}

	/**
	* Caches the e s f lent fields in the entity cache if it is enabled.
	*
	* @param esfLentFields the e s f lent fields
	*/
	public static void cacheResult(
		java.util.List<it.ethica.esf.model.ESFLentField> esfLentFields) {
		getPersistence().cacheResult(esfLentFields);
	}

	/**
	* Creates a new e s f lent field with the primary key. Does not add the e s f lent field to the database.
	*
	* @param lentFieldId the primary key for the new e s f lent field
	* @return the new e s f lent field
	*/
	public static it.ethica.esf.model.ESFLentField create(long lentFieldId) {
		return getPersistence().create(lentFieldId);
	}

	/**
	* Removes the e s f lent field with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param lentFieldId the primary key of the e s f lent field
	* @return the e s f lent field that was removed
	* @throws it.ethica.esf.NoSuchLentFieldException if a e s f lent field with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFLentField remove(long lentFieldId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchLentFieldException {
		return getPersistence().remove(lentFieldId);
	}

	public static it.ethica.esf.model.ESFLentField updateImpl(
		it.ethica.esf.model.ESFLentField esfLentField)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(esfLentField);
	}

	/**
	* Returns the e s f lent field with the primary key or throws a {@link it.ethica.esf.NoSuchLentFieldException} if it could not be found.
	*
	* @param lentFieldId the primary key of the e s f lent field
	* @return the e s f lent field
	* @throws it.ethica.esf.NoSuchLentFieldException if a e s f lent field with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFLentField findByPrimaryKey(
		long lentFieldId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchLentFieldException {
		return getPersistence().findByPrimaryKey(lentFieldId);
	}

	/**
	* Returns the e s f lent field with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param lentFieldId the primary key of the e s f lent field
	* @return the e s f lent field, or <code>null</code> if a e s f lent field with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFLentField fetchByPrimaryKey(
		long lentFieldId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(lentFieldId);
	}

	/**
	* Returns all the e s f lent fields.
	*
	* @return the e s f lent fields
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFLentField> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the e s f lent fields.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFLentFieldModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f lent fields
	* @param end the upper bound of the range of e s f lent fields (not inclusive)
	* @return the range of e s f lent fields
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFLentField> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the e s f lent fields.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFLentFieldModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f lent fields
	* @param end the upper bound of the range of e s f lent fields (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of e s f lent fields
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFLentField> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the e s f lent fields from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of e s f lent fields.
	*
	* @return the number of e s f lent fields
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ESFLentFieldPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ESFLentFieldPersistence)PortletBeanLocatorUtil.locate(it.ethica.esf.service.ClpSerializer.getServletContextName(),
					ESFLentFieldPersistence.class.getName());

			ReferenceRegistry.registerReference(ESFLentFieldUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ESFLentFieldPersistence persistence) {
	}

	private static ESFLentFieldPersistence _persistence;
}