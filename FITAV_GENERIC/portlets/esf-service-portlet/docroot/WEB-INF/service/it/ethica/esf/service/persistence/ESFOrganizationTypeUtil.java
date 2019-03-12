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

import it.ethica.esf.model.ESFOrganizationType;

import java.util.List;

/**
 * The persistence utility for the e s f organization type service. This utility wraps {@link ESFOrganizationTypePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFOrganizationTypePersistence
 * @see ESFOrganizationTypePersistenceImpl
 * @generated
 */
public class ESFOrganizationTypeUtil {
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
	public static void clearCache(ESFOrganizationType esfOrganizationType) {
		getPersistence().clearCache(esfOrganizationType);
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
	public static List<ESFOrganizationType> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ESFOrganizationType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ESFOrganizationType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ESFOrganizationType update(
		ESFOrganizationType esfOrganizationType) throws SystemException {
		return getPersistence().update(esfOrganizationType);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ESFOrganizationType update(
		ESFOrganizationType esfOrganizationType, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(esfOrganizationType, serviceContext);
	}

	/**
	* Returns all the e s f organization types where esfOrganizationId = &#63;.
	*
	* @param esfOrganizationId the esf organization ID
	* @return the matching e s f organization types
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFOrganizationType> findByESFOrganizationId(
		long esfOrganizationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByESFOrganizationId(esfOrganizationId);
	}

	/**
	* Returns a range of all the e s f organization types where esfOrganizationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFOrganizationTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfOrganizationId the esf organization ID
	* @param start the lower bound of the range of e s f organization types
	* @param end the upper bound of the range of e s f organization types (not inclusive)
	* @return the range of matching e s f organization types
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFOrganizationType> findByESFOrganizationId(
		long esfOrganizationId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByESFOrganizationId(esfOrganizationId, start, end);
	}

	/**
	* Returns an ordered range of all the e s f organization types where esfOrganizationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFOrganizationTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfOrganizationId the esf organization ID
	* @param start the lower bound of the range of e s f organization types
	* @param end the upper bound of the range of e s f organization types (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f organization types
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFOrganizationType> findByESFOrganizationId(
		long esfOrganizationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByESFOrganizationId(esfOrganizationId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first e s f organization type in the ordered set where esfOrganizationId = &#63;.
	*
	* @param esfOrganizationId the esf organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f organization type
	* @throws it.ethica.esf.NoSuchOrganizationTypeException if a matching e s f organization type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFOrganizationType findByESFOrganizationId_First(
		long esfOrganizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchOrganizationTypeException {
		return getPersistence()
				   .findByESFOrganizationId_First(esfOrganizationId,
			orderByComparator);
	}

	/**
	* Returns the first e s f organization type in the ordered set where esfOrganizationId = &#63;.
	*
	* @param esfOrganizationId the esf organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f organization type, or <code>null</code> if a matching e s f organization type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFOrganizationType fetchByESFOrganizationId_First(
		long esfOrganizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByESFOrganizationId_First(esfOrganizationId,
			orderByComparator);
	}

	/**
	* Returns the last e s f organization type in the ordered set where esfOrganizationId = &#63;.
	*
	* @param esfOrganizationId the esf organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f organization type
	* @throws it.ethica.esf.NoSuchOrganizationTypeException if a matching e s f organization type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFOrganizationType findByESFOrganizationId_Last(
		long esfOrganizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchOrganizationTypeException {
		return getPersistence()
				   .findByESFOrganizationId_Last(esfOrganizationId,
			orderByComparator);
	}

	/**
	* Returns the last e s f organization type in the ordered set where esfOrganizationId = &#63;.
	*
	* @param esfOrganizationId the esf organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f organization type, or <code>null</code> if a matching e s f organization type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFOrganizationType fetchByESFOrganizationId_Last(
		long esfOrganizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByESFOrganizationId_Last(esfOrganizationId,
			orderByComparator);
	}

	/**
	* Returns the e s f organization types before and after the current e s f organization type in the ordered set where esfOrganizationId = &#63;.
	*
	* @param esfOrganizationTypeId the primary key of the current e s f organization type
	* @param esfOrganizationId the esf organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f organization type
	* @throws it.ethica.esf.NoSuchOrganizationTypeException if a e s f organization type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFOrganizationType[] findByESFOrganizationId_PrevAndNext(
		long esfOrganizationTypeId, long esfOrganizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchOrganizationTypeException {
		return getPersistence()
				   .findByESFOrganizationId_PrevAndNext(esfOrganizationTypeId,
			esfOrganizationId, orderByComparator);
	}

	/**
	* Removes all the e s f organization types where esfOrganizationId = &#63; from the database.
	*
	* @param esfOrganizationId the esf organization ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByESFOrganizationId(long esfOrganizationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByESFOrganizationId(esfOrganizationId);
	}

	/**
	* Returns the number of e s f organization types where esfOrganizationId = &#63;.
	*
	* @param esfOrganizationId the esf organization ID
	* @return the number of matching e s f organization types
	* @throws SystemException if a system exception occurred
	*/
	public static int countByESFOrganizationId(long esfOrganizationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByESFOrganizationId(esfOrganizationId);
	}

	/**
	* Returns all the e s f organization types where esfTypeId = &#63;.
	*
	* @param esfTypeId the esf type ID
	* @return the matching e s f organization types
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFOrganizationType> findByESFTypeId(
		long esfTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByESFTypeId(esfTypeId);
	}

	/**
	* Returns a range of all the e s f organization types where esfTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFOrganizationTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfTypeId the esf type ID
	* @param start the lower bound of the range of e s f organization types
	* @param end the upper bound of the range of e s f organization types (not inclusive)
	* @return the range of matching e s f organization types
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFOrganizationType> findByESFTypeId(
		long esfTypeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByESFTypeId(esfTypeId, start, end);
	}

	/**
	* Returns an ordered range of all the e s f organization types where esfTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFOrganizationTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfTypeId the esf type ID
	* @param start the lower bound of the range of e s f organization types
	* @param end the upper bound of the range of e s f organization types (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f organization types
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFOrganizationType> findByESFTypeId(
		long esfTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByESFTypeId(esfTypeId, start, end, orderByComparator);
	}

	/**
	* Returns the first e s f organization type in the ordered set where esfTypeId = &#63;.
	*
	* @param esfTypeId the esf type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f organization type
	* @throws it.ethica.esf.NoSuchOrganizationTypeException if a matching e s f organization type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFOrganizationType findByESFTypeId_First(
		long esfTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchOrganizationTypeException {
		return getPersistence()
				   .findByESFTypeId_First(esfTypeId, orderByComparator);
	}

	/**
	* Returns the first e s f organization type in the ordered set where esfTypeId = &#63;.
	*
	* @param esfTypeId the esf type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f organization type, or <code>null</code> if a matching e s f organization type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFOrganizationType fetchByESFTypeId_First(
		long esfTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByESFTypeId_First(esfTypeId, orderByComparator);
	}

	/**
	* Returns the last e s f organization type in the ordered set where esfTypeId = &#63;.
	*
	* @param esfTypeId the esf type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f organization type
	* @throws it.ethica.esf.NoSuchOrganizationTypeException if a matching e s f organization type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFOrganizationType findByESFTypeId_Last(
		long esfTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchOrganizationTypeException {
		return getPersistence()
				   .findByESFTypeId_Last(esfTypeId, orderByComparator);
	}

	/**
	* Returns the last e s f organization type in the ordered set where esfTypeId = &#63;.
	*
	* @param esfTypeId the esf type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f organization type, or <code>null</code> if a matching e s f organization type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFOrganizationType fetchByESFTypeId_Last(
		long esfTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByESFTypeId_Last(esfTypeId, orderByComparator);
	}

	/**
	* Returns the e s f organization types before and after the current e s f organization type in the ordered set where esfTypeId = &#63;.
	*
	* @param esfOrganizationTypeId the primary key of the current e s f organization type
	* @param esfTypeId the esf type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f organization type
	* @throws it.ethica.esf.NoSuchOrganizationTypeException if a e s f organization type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFOrganizationType[] findByESFTypeId_PrevAndNext(
		long esfOrganizationTypeId, long esfTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchOrganizationTypeException {
		return getPersistence()
				   .findByESFTypeId_PrevAndNext(esfOrganizationTypeId,
			esfTypeId, orderByComparator);
	}

	/**
	* Removes all the e s f organization types where esfTypeId = &#63; from the database.
	*
	* @param esfTypeId the esf type ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByESFTypeId(long esfTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByESFTypeId(esfTypeId);
	}

	/**
	* Returns the number of e s f organization types where esfTypeId = &#63;.
	*
	* @param esfTypeId the esf type ID
	* @return the number of matching e s f organization types
	* @throws SystemException if a system exception occurred
	*/
	public static int countByESFTypeId(long esfTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByESFTypeId(esfTypeId);
	}

	/**
	* Caches the e s f organization type in the entity cache if it is enabled.
	*
	* @param esfOrganizationType the e s f organization type
	*/
	public static void cacheResult(
		it.ethica.esf.model.ESFOrganizationType esfOrganizationType) {
		getPersistence().cacheResult(esfOrganizationType);
	}

	/**
	* Caches the e s f organization types in the entity cache if it is enabled.
	*
	* @param esfOrganizationTypes the e s f organization types
	*/
	public static void cacheResult(
		java.util.List<it.ethica.esf.model.ESFOrganizationType> esfOrganizationTypes) {
		getPersistence().cacheResult(esfOrganizationTypes);
	}

	/**
	* Creates a new e s f organization type with the primary key. Does not add the e s f organization type to the database.
	*
	* @param esfOrganizationTypeId the primary key for the new e s f organization type
	* @return the new e s f organization type
	*/
	public static it.ethica.esf.model.ESFOrganizationType create(
		long esfOrganizationTypeId) {
		return getPersistence().create(esfOrganizationTypeId);
	}

	/**
	* Removes the e s f organization type with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfOrganizationTypeId the primary key of the e s f organization type
	* @return the e s f organization type that was removed
	* @throws it.ethica.esf.NoSuchOrganizationTypeException if a e s f organization type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFOrganizationType remove(
		long esfOrganizationTypeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchOrganizationTypeException {
		return getPersistence().remove(esfOrganizationTypeId);
	}

	public static it.ethica.esf.model.ESFOrganizationType updateImpl(
		it.ethica.esf.model.ESFOrganizationType esfOrganizationType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(esfOrganizationType);
	}

	/**
	* Returns the e s f organization type with the primary key or throws a {@link it.ethica.esf.NoSuchOrganizationTypeException} if it could not be found.
	*
	* @param esfOrganizationTypeId the primary key of the e s f organization type
	* @return the e s f organization type
	* @throws it.ethica.esf.NoSuchOrganizationTypeException if a e s f organization type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFOrganizationType findByPrimaryKey(
		long esfOrganizationTypeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchOrganizationTypeException {
		return getPersistence().findByPrimaryKey(esfOrganizationTypeId);
	}

	/**
	* Returns the e s f organization type with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param esfOrganizationTypeId the primary key of the e s f organization type
	* @return the e s f organization type, or <code>null</code> if a e s f organization type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFOrganizationType fetchByPrimaryKey(
		long esfOrganizationTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(esfOrganizationTypeId);
	}

	/**
	* Returns all the e s f organization types.
	*
	* @return the e s f organization types
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFOrganizationType> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the e s f organization types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFOrganizationTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f organization types
	* @param end the upper bound of the range of e s f organization types (not inclusive)
	* @return the range of e s f organization types
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFOrganizationType> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the e s f organization types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFOrganizationTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f organization types
	* @param end the upper bound of the range of e s f organization types (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of e s f organization types
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFOrganizationType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the e s f organization types from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of e s f organization types.
	*
	* @return the number of e s f organization types
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ESFOrganizationTypePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ESFOrganizationTypePersistence)PortletBeanLocatorUtil.locate(it.ethica.esf.service.ClpSerializer.getServletContextName(),
					ESFOrganizationTypePersistence.class.getName());

			ReferenceRegistry.registerReference(ESFOrganizationTypeUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ESFOrganizationTypePersistence persistence) {
	}

	private static ESFOrganizationTypePersistence _persistence;
}