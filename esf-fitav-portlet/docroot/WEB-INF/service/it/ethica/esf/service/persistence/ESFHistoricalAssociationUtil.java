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

import it.ethica.esf.model.ESFHistoricalAssociation;

import java.util.List;

/**
 * The persistence utility for the e s f historical association service. This utility wraps {@link ESFHistoricalAssociationPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFHistoricalAssociationPersistence
 * @see ESFHistoricalAssociationPersistenceImpl
 * @generated
 */
public class ESFHistoricalAssociationUtil {
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
		ESFHistoricalAssociation esfHistoricalAssociation) {
		getPersistence().clearCache(esfHistoricalAssociation);
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
	public static List<ESFHistoricalAssociation> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ESFHistoricalAssociation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ESFHistoricalAssociation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ESFHistoricalAssociation update(
		ESFHistoricalAssociation esfHistoricalAssociation)
		throws SystemException {
		return getPersistence().update(esfHistoricalAssociation);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ESFHistoricalAssociation update(
		ESFHistoricalAssociation esfHistoricalAssociation,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(esfHistoricalAssociation, serviceContext);
	}

	/**
	* Returns all the e s f historical associations where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @return the matching e s f historical associations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFHistoricalAssociation> findByOrg_Date(
		long organizationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByOrg_Date(organizationId);
	}

	/**
	* Returns a range of all the e s f historical associations where organizationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFHistoricalAssociationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param organizationId the organization ID
	* @param start the lower bound of the range of e s f historical associations
	* @param end the upper bound of the range of e s f historical associations (not inclusive)
	* @return the range of matching e s f historical associations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFHistoricalAssociation> findByOrg_Date(
		long organizationId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByOrg_Date(organizationId, start, end);
	}

	/**
	* Returns an ordered range of all the e s f historical associations where organizationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFHistoricalAssociationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param organizationId the organization ID
	* @param start the lower bound of the range of e s f historical associations
	* @param end the upper bound of the range of e s f historical associations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f historical associations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFHistoricalAssociation> findByOrg_Date(
		long organizationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOrg_Date(organizationId, start, end, orderByComparator);
	}

	/**
	* Returns the first e s f historical association in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f historical association
	* @throws it.ethica.esf.NoSuchHistoricalAssociationException if a matching e s f historical association could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFHistoricalAssociation findByOrg_Date_First(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchHistoricalAssociationException {
		return getPersistence()
				   .findByOrg_Date_First(organizationId, orderByComparator);
	}

	/**
	* Returns the first e s f historical association in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f historical association, or <code>null</code> if a matching e s f historical association could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFHistoricalAssociation fetchByOrg_Date_First(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByOrg_Date_First(organizationId, orderByComparator);
	}

	/**
	* Returns the last e s f historical association in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f historical association
	* @throws it.ethica.esf.NoSuchHistoricalAssociationException if a matching e s f historical association could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFHistoricalAssociation findByOrg_Date_Last(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchHistoricalAssociationException {
		return getPersistence()
				   .findByOrg_Date_Last(organizationId, orderByComparator);
	}

	/**
	* Returns the last e s f historical association in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f historical association, or <code>null</code> if a matching e s f historical association could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFHistoricalAssociation fetchByOrg_Date_Last(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByOrg_Date_Last(organizationId, orderByComparator);
	}

	/**
	* Returns the e s f historical associations before and after the current e s f historical association in the ordered set where organizationId = &#63;.
	*
	* @param idHistoricalAssociation the primary key of the current e s f historical association
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f historical association
	* @throws it.ethica.esf.NoSuchHistoricalAssociationException if a e s f historical association with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFHistoricalAssociation[] findByOrg_Date_PrevAndNext(
		long idHistoricalAssociation, long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchHistoricalAssociationException {
		return getPersistence()
				   .findByOrg_Date_PrevAndNext(idHistoricalAssociation,
			organizationId, orderByComparator);
	}

	/**
	* Removes all the e s f historical associations where organizationId = &#63; from the database.
	*
	* @param organizationId the organization ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByOrg_Date(long organizationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByOrg_Date(organizationId);
	}

	/**
	* Returns the number of e s f historical associations where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @return the number of matching e s f historical associations
	* @throws SystemException if a system exception occurred
	*/
	public static int countByOrg_Date(long organizationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByOrg_Date(organizationId);
	}

	/**
	* Caches the e s f historical association in the entity cache if it is enabled.
	*
	* @param esfHistoricalAssociation the e s f historical association
	*/
	public static void cacheResult(
		it.ethica.esf.model.ESFHistoricalAssociation esfHistoricalAssociation) {
		getPersistence().cacheResult(esfHistoricalAssociation);
	}

	/**
	* Caches the e s f historical associations in the entity cache if it is enabled.
	*
	* @param esfHistoricalAssociations the e s f historical associations
	*/
	public static void cacheResult(
		java.util.List<it.ethica.esf.model.ESFHistoricalAssociation> esfHistoricalAssociations) {
		getPersistence().cacheResult(esfHistoricalAssociations);
	}

	/**
	* Creates a new e s f historical association with the primary key. Does not add the e s f historical association to the database.
	*
	* @param idHistoricalAssociation the primary key for the new e s f historical association
	* @return the new e s f historical association
	*/
	public static it.ethica.esf.model.ESFHistoricalAssociation create(
		long idHistoricalAssociation) {
		return getPersistence().create(idHistoricalAssociation);
	}

	/**
	* Removes the e s f historical association with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param idHistoricalAssociation the primary key of the e s f historical association
	* @return the e s f historical association that was removed
	* @throws it.ethica.esf.NoSuchHistoricalAssociationException if a e s f historical association with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFHistoricalAssociation remove(
		long idHistoricalAssociation)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchHistoricalAssociationException {
		return getPersistence().remove(idHistoricalAssociation);
	}

	public static it.ethica.esf.model.ESFHistoricalAssociation updateImpl(
		it.ethica.esf.model.ESFHistoricalAssociation esfHistoricalAssociation)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(esfHistoricalAssociation);
	}

	/**
	* Returns the e s f historical association with the primary key or throws a {@link it.ethica.esf.NoSuchHistoricalAssociationException} if it could not be found.
	*
	* @param idHistoricalAssociation the primary key of the e s f historical association
	* @return the e s f historical association
	* @throws it.ethica.esf.NoSuchHistoricalAssociationException if a e s f historical association with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFHistoricalAssociation findByPrimaryKey(
		long idHistoricalAssociation)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchHistoricalAssociationException {
		return getPersistence().findByPrimaryKey(idHistoricalAssociation);
	}

	/**
	* Returns the e s f historical association with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param idHistoricalAssociation the primary key of the e s f historical association
	* @return the e s f historical association, or <code>null</code> if a e s f historical association with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFHistoricalAssociation fetchByPrimaryKey(
		long idHistoricalAssociation)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(idHistoricalAssociation);
	}

	/**
	* Returns all the e s f historical associations.
	*
	* @return the e s f historical associations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFHistoricalAssociation> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the e s f historical associations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFHistoricalAssociationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f historical associations
	* @param end the upper bound of the range of e s f historical associations (not inclusive)
	* @return the range of e s f historical associations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFHistoricalAssociation> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the e s f historical associations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFHistoricalAssociationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f historical associations
	* @param end the upper bound of the range of e s f historical associations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of e s f historical associations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFHistoricalAssociation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the e s f historical associations from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of e s f historical associations.
	*
	* @return the number of e s f historical associations
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ESFHistoricalAssociationPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ESFHistoricalAssociationPersistence)PortletBeanLocatorUtil.locate(it.ethica.esf.service.ClpSerializer.getServletContextName(),
					ESFHistoricalAssociationPersistence.class.getName());

			ReferenceRegistry.registerReference(ESFHistoricalAssociationUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ESFHistoricalAssociationPersistence persistence) {
	}

	private static ESFHistoricalAssociationPersistence _persistence;
}