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

import it.ethica.esf.model.ESFStateAssEntity;

import java.util.List;

/**
 * The persistence utility for the e s f state ass entity service. This utility wraps {@link ESFStateAssEntityPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFStateAssEntityPersistence
 * @see ESFStateAssEntityPersistenceImpl
 * @generated
 */
public class ESFStateAssEntityUtil {
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
	public static void clearCache(ESFStateAssEntity esfStateAssEntity) {
		getPersistence().clearCache(esfStateAssEntity);
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
	public static List<ESFStateAssEntity> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ESFStateAssEntity> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ESFStateAssEntity> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ESFStateAssEntity update(ESFStateAssEntity esfStateAssEntity)
		throws SystemException {
		return getPersistence().update(esfStateAssEntity);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ESFStateAssEntity update(
		ESFStateAssEntity esfStateAssEntity, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(esfStateAssEntity, serviceContext);
	}

	/**
	* Returns all the e s f state ass entities where className = &#63;.
	*
	* @param className the class name
	* @return the matching e s f state ass entities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFStateAssEntity> findByClassName(
		java.lang.String className)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByClassName(className);
	}

	/**
	* Returns a range of all the e s f state ass entities where className = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFStateAssEntityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param className the class name
	* @param start the lower bound of the range of e s f state ass entities
	* @param end the upper bound of the range of e s f state ass entities (not inclusive)
	* @return the range of matching e s f state ass entities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFStateAssEntity> findByClassName(
		java.lang.String className, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByClassName(className, start, end);
	}

	/**
	* Returns an ordered range of all the e s f state ass entities where className = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFStateAssEntityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param className the class name
	* @param start the lower bound of the range of e s f state ass entities
	* @param end the upper bound of the range of e s f state ass entities (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f state ass entities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFStateAssEntity> findByClassName(
		java.lang.String className, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByClassName(className, start, end, orderByComparator);
	}

	/**
	* Returns the first e s f state ass entity in the ordered set where className = &#63;.
	*
	* @param className the class name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f state ass entity
	* @throws it.ethica.esf.NoSuchStateAssEntityException if a matching e s f state ass entity could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFStateAssEntity findByClassName_First(
		java.lang.String className,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchStateAssEntityException {
		return getPersistence()
				   .findByClassName_First(className, orderByComparator);
	}

	/**
	* Returns the first e s f state ass entity in the ordered set where className = &#63;.
	*
	* @param className the class name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f state ass entity, or <code>null</code> if a matching e s f state ass entity could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFStateAssEntity fetchByClassName_First(
		java.lang.String className,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByClassName_First(className, orderByComparator);
	}

	/**
	* Returns the last e s f state ass entity in the ordered set where className = &#63;.
	*
	* @param className the class name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f state ass entity
	* @throws it.ethica.esf.NoSuchStateAssEntityException if a matching e s f state ass entity could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFStateAssEntity findByClassName_Last(
		java.lang.String className,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchStateAssEntityException {
		return getPersistence()
				   .findByClassName_Last(className, orderByComparator);
	}

	/**
	* Returns the last e s f state ass entity in the ordered set where className = &#63;.
	*
	* @param className the class name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f state ass entity, or <code>null</code> if a matching e s f state ass entity could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFStateAssEntity fetchByClassName_Last(
		java.lang.String className,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByClassName_Last(className, orderByComparator);
	}

	/**
	* Returns the e s f state ass entities before and after the current e s f state ass entity in the ordered set where className = &#63;.
	*
	* @param esfStateAssEntityPK the primary key of the current e s f state ass entity
	* @param className the class name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f state ass entity
	* @throws it.ethica.esf.NoSuchStateAssEntityException if a e s f state ass entity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFStateAssEntity[] findByClassName_PrevAndNext(
		it.ethica.esf.service.persistence.ESFStateAssEntityPK esfStateAssEntityPK,
		java.lang.String className,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchStateAssEntityException {
		return getPersistence()
				   .findByClassName_PrevAndNext(esfStateAssEntityPK, className,
			orderByComparator);
	}

	/**
	* Removes all the e s f state ass entities where className = &#63; from the database.
	*
	* @param className the class name
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByClassName(java.lang.String className)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByClassName(className);
	}

	/**
	* Returns the number of e s f state ass entities where className = &#63;.
	*
	* @param className the class name
	* @return the number of matching e s f state ass entities
	* @throws SystemException if a system exception occurred
	*/
	public static int countByClassName(java.lang.String className)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByClassName(className);
	}

	/**
	* Returns all the e s f state ass entities where esfStateId = &#63;.
	*
	* @param esfStateId the esf state ID
	* @return the matching e s f state ass entities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFStateAssEntity> findByESFStateId(
		long esfStateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByESFStateId(esfStateId);
	}

	/**
	* Returns a range of all the e s f state ass entities where esfStateId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFStateAssEntityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfStateId the esf state ID
	* @param start the lower bound of the range of e s f state ass entities
	* @param end the upper bound of the range of e s f state ass entities (not inclusive)
	* @return the range of matching e s f state ass entities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFStateAssEntity> findByESFStateId(
		long esfStateId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByESFStateId(esfStateId, start, end);
	}

	/**
	* Returns an ordered range of all the e s f state ass entities where esfStateId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFStateAssEntityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfStateId the esf state ID
	* @param start the lower bound of the range of e s f state ass entities
	* @param end the upper bound of the range of e s f state ass entities (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f state ass entities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFStateAssEntity> findByESFStateId(
		long esfStateId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByESFStateId(esfStateId, start, end, orderByComparator);
	}

	/**
	* Returns the first e s f state ass entity in the ordered set where esfStateId = &#63;.
	*
	* @param esfStateId the esf state ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f state ass entity
	* @throws it.ethica.esf.NoSuchStateAssEntityException if a matching e s f state ass entity could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFStateAssEntity findByESFStateId_First(
		long esfStateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchStateAssEntityException {
		return getPersistence()
				   .findByESFStateId_First(esfStateId, orderByComparator);
	}

	/**
	* Returns the first e s f state ass entity in the ordered set where esfStateId = &#63;.
	*
	* @param esfStateId the esf state ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f state ass entity, or <code>null</code> if a matching e s f state ass entity could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFStateAssEntity fetchByESFStateId_First(
		long esfStateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByESFStateId_First(esfStateId, orderByComparator);
	}

	/**
	* Returns the last e s f state ass entity in the ordered set where esfStateId = &#63;.
	*
	* @param esfStateId the esf state ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f state ass entity
	* @throws it.ethica.esf.NoSuchStateAssEntityException if a matching e s f state ass entity could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFStateAssEntity findByESFStateId_Last(
		long esfStateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchStateAssEntityException {
		return getPersistence()
				   .findByESFStateId_Last(esfStateId, orderByComparator);
	}

	/**
	* Returns the last e s f state ass entity in the ordered set where esfStateId = &#63;.
	*
	* @param esfStateId the esf state ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f state ass entity, or <code>null</code> if a matching e s f state ass entity could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFStateAssEntity fetchByESFStateId_Last(
		long esfStateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByESFStateId_Last(esfStateId, orderByComparator);
	}

	/**
	* Returns the e s f state ass entities before and after the current e s f state ass entity in the ordered set where esfStateId = &#63;.
	*
	* @param esfStateAssEntityPK the primary key of the current e s f state ass entity
	* @param esfStateId the esf state ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f state ass entity
	* @throws it.ethica.esf.NoSuchStateAssEntityException if a e s f state ass entity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFStateAssEntity[] findByESFStateId_PrevAndNext(
		it.ethica.esf.service.persistence.ESFStateAssEntityPK esfStateAssEntityPK,
		long esfStateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchStateAssEntityException {
		return getPersistence()
				   .findByESFStateId_PrevAndNext(esfStateAssEntityPK,
			esfStateId, orderByComparator);
	}

	/**
	* Removes all the e s f state ass entities where esfStateId = &#63; from the database.
	*
	* @param esfStateId the esf state ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByESFStateId(long esfStateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByESFStateId(esfStateId);
	}

	/**
	* Returns the number of e s f state ass entities where esfStateId = &#63;.
	*
	* @param esfStateId the esf state ID
	* @return the number of matching e s f state ass entities
	* @throws SystemException if a system exception occurred
	*/
	public static int countByESFStateId(long esfStateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByESFStateId(esfStateId);
	}

	/**
	* Caches the e s f state ass entity in the entity cache if it is enabled.
	*
	* @param esfStateAssEntity the e s f state ass entity
	*/
	public static void cacheResult(
		it.ethica.esf.model.ESFStateAssEntity esfStateAssEntity) {
		getPersistence().cacheResult(esfStateAssEntity);
	}

	/**
	* Caches the e s f state ass entities in the entity cache if it is enabled.
	*
	* @param esfStateAssEntities the e s f state ass entities
	*/
	public static void cacheResult(
		java.util.List<it.ethica.esf.model.ESFStateAssEntity> esfStateAssEntities) {
		getPersistence().cacheResult(esfStateAssEntities);
	}

	/**
	* Creates a new e s f state ass entity with the primary key. Does not add the e s f state ass entity to the database.
	*
	* @param esfStateAssEntityPK the primary key for the new e s f state ass entity
	* @return the new e s f state ass entity
	*/
	public static it.ethica.esf.model.ESFStateAssEntity create(
		it.ethica.esf.service.persistence.ESFStateAssEntityPK esfStateAssEntityPK) {
		return getPersistence().create(esfStateAssEntityPK);
	}

	/**
	* Removes the e s f state ass entity with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfStateAssEntityPK the primary key of the e s f state ass entity
	* @return the e s f state ass entity that was removed
	* @throws it.ethica.esf.NoSuchStateAssEntityException if a e s f state ass entity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFStateAssEntity remove(
		it.ethica.esf.service.persistence.ESFStateAssEntityPK esfStateAssEntityPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchStateAssEntityException {
		return getPersistence().remove(esfStateAssEntityPK);
	}

	public static it.ethica.esf.model.ESFStateAssEntity updateImpl(
		it.ethica.esf.model.ESFStateAssEntity esfStateAssEntity)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(esfStateAssEntity);
	}

	/**
	* Returns the e s f state ass entity with the primary key or throws a {@link it.ethica.esf.NoSuchStateAssEntityException} if it could not be found.
	*
	* @param esfStateAssEntityPK the primary key of the e s f state ass entity
	* @return the e s f state ass entity
	* @throws it.ethica.esf.NoSuchStateAssEntityException if a e s f state ass entity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFStateAssEntity findByPrimaryKey(
		it.ethica.esf.service.persistence.ESFStateAssEntityPK esfStateAssEntityPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchStateAssEntityException {
		return getPersistence().findByPrimaryKey(esfStateAssEntityPK);
	}

	/**
	* Returns the e s f state ass entity with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param esfStateAssEntityPK the primary key of the e s f state ass entity
	* @return the e s f state ass entity, or <code>null</code> if a e s f state ass entity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFStateAssEntity fetchByPrimaryKey(
		it.ethica.esf.service.persistence.ESFStateAssEntityPK esfStateAssEntityPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(esfStateAssEntityPK);
	}

	/**
	* Returns all the e s f state ass entities.
	*
	* @return the e s f state ass entities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFStateAssEntity> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the e s f state ass entities.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFStateAssEntityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f state ass entities
	* @param end the upper bound of the range of e s f state ass entities (not inclusive)
	* @return the range of e s f state ass entities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFStateAssEntity> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the e s f state ass entities.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFStateAssEntityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f state ass entities
	* @param end the upper bound of the range of e s f state ass entities (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of e s f state ass entities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFStateAssEntity> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the e s f state ass entities from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of e s f state ass entities.
	*
	* @return the number of e s f state ass entities
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ESFStateAssEntityPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ESFStateAssEntityPersistence)PortletBeanLocatorUtil.locate(it.ethica.esf.service.ClpSerializer.getServletContextName(),
					ESFStateAssEntityPersistence.class.getName());

			ReferenceRegistry.registerReference(ESFStateAssEntityUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ESFStateAssEntityPersistence persistence) {
	}

	private static ESFStateAssEntityPersistence _persistence;
}