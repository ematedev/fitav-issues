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

import it.ethica.esf.model.ESFEntityState;

import java.util.List;

/**
 * The persistence utility for the e s f entity state service. This utility wraps {@link ESFEntityStatePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFEntityStatePersistence
 * @see ESFEntityStatePersistenceImpl
 * @generated
 */
public class ESFEntityStateUtil {
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
	public static void clearCache(ESFEntityState esfEntityState) {
		getPersistence().clearCache(esfEntityState);
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
	public static List<ESFEntityState> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ESFEntityState> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ESFEntityState> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ESFEntityState update(ESFEntityState esfEntityState)
		throws SystemException {
		return getPersistence().update(esfEntityState);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ESFEntityState update(ESFEntityState esfEntityState,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(esfEntityState, serviceContext);
	}

	/**
	* Returns the e s f entity state where className = &#63; and classPK = &#63; or throws a {@link it.ethica.esf.NoSuchEntityStateException} if it could not be found.
	*
	* @param className the class name
	* @param classPK the class p k
	* @return the matching e s f entity state
	* @throws it.ethica.esf.NoSuchEntityStateException if a matching e s f entity state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFEntityState findByESFEntityStateC_PK(
		java.lang.String className, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchEntityStateException {
		return getPersistence().findByESFEntityStateC_PK(className, classPK);
	}

	/**
	* Returns the e s f entity state where className = &#63; and classPK = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param className the class name
	* @param classPK the class p k
	* @return the matching e s f entity state, or <code>null</code> if a matching e s f entity state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFEntityState fetchByESFEntityStateC_PK(
		java.lang.String className, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByESFEntityStateC_PK(className, classPK);
	}

	/**
	* Returns the e s f entity state where className = &#63; and classPK = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching e s f entity state, or <code>null</code> if a matching e s f entity state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFEntityState fetchByESFEntityStateC_PK(
		java.lang.String className, long classPK, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByESFEntityStateC_PK(className, classPK,
			retrieveFromCache);
	}

	/**
	* Removes the e s f entity state where className = &#63; and classPK = &#63; from the database.
	*
	* @param className the class name
	* @param classPK the class p k
	* @return the e s f entity state that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFEntityState removeByESFEntityStateC_PK(
		java.lang.String className, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchEntityStateException {
		return getPersistence().removeByESFEntityStateC_PK(className, classPK);
	}

	/**
	* Returns the number of e s f entity states where className = &#63; and classPK = &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @return the number of matching e s f entity states
	* @throws SystemException if a system exception occurred
	*/
	public static int countByESFEntityStateC_PK(java.lang.String className,
		long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByESFEntityStateC_PK(className, classPK);
	}

	/**
	* Returns the e s f entity state where className = &#63; and classPK = &#63; and esfStateId = &#63; or throws a {@link it.ethica.esf.NoSuchEntityStateException} if it could not be found.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param esfStateId the esf state ID
	* @return the matching e s f entity state
	* @throws it.ethica.esf.NoSuchEntityStateException if a matching e s f entity state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFEntityState findByESFEntityStateC_PK_S(
		java.lang.String className, long classPK, long esfStateId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchEntityStateException {
		return getPersistence()
				   .findByESFEntityStateC_PK_S(className, classPK, esfStateId);
	}

	/**
	* Returns the e s f entity state where className = &#63; and classPK = &#63; and esfStateId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param esfStateId the esf state ID
	* @return the matching e s f entity state, or <code>null</code> if a matching e s f entity state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFEntityState fetchByESFEntityStateC_PK_S(
		java.lang.String className, long classPK, long esfStateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByESFEntityStateC_PK_S(className, classPK, esfStateId);
	}

	/**
	* Returns the e s f entity state where className = &#63; and classPK = &#63; and esfStateId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param esfStateId the esf state ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching e s f entity state, or <code>null</code> if a matching e s f entity state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFEntityState fetchByESFEntityStateC_PK_S(
		java.lang.String className, long classPK, long esfStateId,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByESFEntityStateC_PK_S(className, classPK, esfStateId,
			retrieveFromCache);
	}

	/**
	* Removes the e s f entity state where className = &#63; and classPK = &#63; and esfStateId = &#63; from the database.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param esfStateId the esf state ID
	* @return the e s f entity state that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFEntityState removeByESFEntityStateC_PK_S(
		java.lang.String className, long classPK, long esfStateId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchEntityStateException {
		return getPersistence()
				   .removeByESFEntityStateC_PK_S(className, classPK, esfStateId);
	}

	/**
	* Returns the number of e s f entity states where className = &#63; and classPK = &#63; and esfStateId = &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param esfStateId the esf state ID
	* @return the number of matching e s f entity states
	* @throws SystemException if a system exception occurred
	*/
	public static int countByESFEntityStateC_PK_S(java.lang.String className,
		long classPK, long esfStateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByESFEntityStateC_PK_S(className, classPK, esfStateId);
	}

	/**
	* Returns all the e s f entity states where className = &#63; and esfStateId = &#63;.
	*
	* @param className the class name
	* @param esfStateId the esf state ID
	* @return the matching e s f entity states
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFEntityState> findByESFEntityStateC_S(
		java.lang.String className, long esfStateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByESFEntityStateC_S(className, esfStateId);
	}

	/**
	* Returns a range of all the e s f entity states where className = &#63; and esfStateId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFEntityStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param className the class name
	* @param esfStateId the esf state ID
	* @param start the lower bound of the range of e s f entity states
	* @param end the upper bound of the range of e s f entity states (not inclusive)
	* @return the range of matching e s f entity states
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFEntityState> findByESFEntityStateC_S(
		java.lang.String className, long esfStateId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByESFEntityStateC_S(className, esfStateId, start, end);
	}

	/**
	* Returns an ordered range of all the e s f entity states where className = &#63; and esfStateId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFEntityStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param className the class name
	* @param esfStateId the esf state ID
	* @param start the lower bound of the range of e s f entity states
	* @param end the upper bound of the range of e s f entity states (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f entity states
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFEntityState> findByESFEntityStateC_S(
		java.lang.String className, long esfStateId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByESFEntityStateC_S(className, esfStateId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first e s f entity state in the ordered set where className = &#63; and esfStateId = &#63;.
	*
	* @param className the class name
	* @param esfStateId the esf state ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f entity state
	* @throws it.ethica.esf.NoSuchEntityStateException if a matching e s f entity state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFEntityState findByESFEntityStateC_S_First(
		java.lang.String className, long esfStateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchEntityStateException {
		return getPersistence()
				   .findByESFEntityStateC_S_First(className, esfStateId,
			orderByComparator);
	}

	/**
	* Returns the first e s f entity state in the ordered set where className = &#63; and esfStateId = &#63;.
	*
	* @param className the class name
	* @param esfStateId the esf state ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f entity state, or <code>null</code> if a matching e s f entity state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFEntityState fetchByESFEntityStateC_S_First(
		java.lang.String className, long esfStateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByESFEntityStateC_S_First(className, esfStateId,
			orderByComparator);
	}

	/**
	* Returns the last e s f entity state in the ordered set where className = &#63; and esfStateId = &#63;.
	*
	* @param className the class name
	* @param esfStateId the esf state ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f entity state
	* @throws it.ethica.esf.NoSuchEntityStateException if a matching e s f entity state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFEntityState findByESFEntityStateC_S_Last(
		java.lang.String className, long esfStateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchEntityStateException {
		return getPersistence()
				   .findByESFEntityStateC_S_Last(className, esfStateId,
			orderByComparator);
	}

	/**
	* Returns the last e s f entity state in the ordered set where className = &#63; and esfStateId = &#63;.
	*
	* @param className the class name
	* @param esfStateId the esf state ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f entity state, or <code>null</code> if a matching e s f entity state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFEntityState fetchByESFEntityStateC_S_Last(
		java.lang.String className, long esfStateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByESFEntityStateC_S_Last(className, esfStateId,
			orderByComparator);
	}

	/**
	* Returns the e s f entity states before and after the current e s f entity state in the ordered set where className = &#63; and esfStateId = &#63;.
	*
	* @param esfEntityStateId the primary key of the current e s f entity state
	* @param className the class name
	* @param esfStateId the esf state ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f entity state
	* @throws it.ethica.esf.NoSuchEntityStateException if a e s f entity state with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFEntityState[] findByESFEntityStateC_S_PrevAndNext(
		long esfEntityStateId, java.lang.String className, long esfStateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchEntityStateException {
		return getPersistence()
				   .findByESFEntityStateC_S_PrevAndNext(esfEntityStateId,
			className, esfStateId, orderByComparator);
	}

	/**
	* Removes all the e s f entity states where className = &#63; and esfStateId = &#63; from the database.
	*
	* @param className the class name
	* @param esfStateId the esf state ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByESFEntityStateC_S(java.lang.String className,
		long esfStateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByESFEntityStateC_S(className, esfStateId);
	}

	/**
	* Returns the number of e s f entity states where className = &#63; and esfStateId = &#63;.
	*
	* @param className the class name
	* @param esfStateId the esf state ID
	* @return the number of matching e s f entity states
	* @throws SystemException if a system exception occurred
	*/
	public static int countByESFEntityStateC_S(java.lang.String className,
		long esfStateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByESFEntityStateC_S(className, esfStateId);
	}

	/**
	* Returns all the e s f entity states where className = &#63; and classPK = &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @return the matching e s f entity states
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFEntityState> findByESFEntityStateCName_CPk(
		java.lang.String className, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByESFEntityStateCName_CPk(className, classPK);
	}

	/**
	* Returns a range of all the e s f entity states where className = &#63; and classPK = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFEntityStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param className the class name
	* @param classPK the class p k
	* @param start the lower bound of the range of e s f entity states
	* @param end the upper bound of the range of e s f entity states (not inclusive)
	* @return the range of matching e s f entity states
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFEntityState> findByESFEntityStateCName_CPk(
		java.lang.String className, long classPK, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByESFEntityStateCName_CPk(className, classPK, start, end);
	}

	/**
	* Returns an ordered range of all the e s f entity states where className = &#63; and classPK = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFEntityStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param className the class name
	* @param classPK the class p k
	* @param start the lower bound of the range of e s f entity states
	* @param end the upper bound of the range of e s f entity states (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f entity states
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFEntityState> findByESFEntityStateCName_CPk(
		java.lang.String className, long classPK, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByESFEntityStateCName_CPk(className, classPK, start,
			end, orderByComparator);
	}

	/**
	* Returns the first e s f entity state in the ordered set where className = &#63; and classPK = &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f entity state
	* @throws it.ethica.esf.NoSuchEntityStateException if a matching e s f entity state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFEntityState findByESFEntityStateCName_CPk_First(
		java.lang.String className, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchEntityStateException {
		return getPersistence()
				   .findByESFEntityStateCName_CPk_First(className, classPK,
			orderByComparator);
	}

	/**
	* Returns the first e s f entity state in the ordered set where className = &#63; and classPK = &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f entity state, or <code>null</code> if a matching e s f entity state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFEntityState fetchByESFEntityStateCName_CPk_First(
		java.lang.String className, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByESFEntityStateCName_CPk_First(className, classPK,
			orderByComparator);
	}

	/**
	* Returns the last e s f entity state in the ordered set where className = &#63; and classPK = &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f entity state
	* @throws it.ethica.esf.NoSuchEntityStateException if a matching e s f entity state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFEntityState findByESFEntityStateCName_CPk_Last(
		java.lang.String className, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchEntityStateException {
		return getPersistence()
				   .findByESFEntityStateCName_CPk_Last(className, classPK,
			orderByComparator);
	}

	/**
	* Returns the last e s f entity state in the ordered set where className = &#63; and classPK = &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f entity state, or <code>null</code> if a matching e s f entity state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFEntityState fetchByESFEntityStateCName_CPk_Last(
		java.lang.String className, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByESFEntityStateCName_CPk_Last(className, classPK,
			orderByComparator);
	}

	/**
	* Returns the e s f entity states before and after the current e s f entity state in the ordered set where className = &#63; and classPK = &#63;.
	*
	* @param esfEntityStateId the primary key of the current e s f entity state
	* @param className the class name
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f entity state
	* @throws it.ethica.esf.NoSuchEntityStateException if a e s f entity state with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFEntityState[] findByESFEntityStateCName_CPk_PrevAndNext(
		long esfEntityStateId, java.lang.String className, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchEntityStateException {
		return getPersistence()
				   .findByESFEntityStateCName_CPk_PrevAndNext(esfEntityStateId,
			className, classPK, orderByComparator);
	}

	/**
	* Removes all the e s f entity states where className = &#63; and classPK = &#63; from the database.
	*
	* @param className the class name
	* @param classPK the class p k
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByESFEntityStateCName_CPk(
		java.lang.String className, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByESFEntityStateCName_CPk(className, classPK);
	}

	/**
	* Returns the number of e s f entity states where className = &#63; and classPK = &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @return the number of matching e s f entity states
	* @throws SystemException if a system exception occurred
	*/
	public static int countByESFEntityStateCName_CPk(
		java.lang.String className, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByESFEntityStateCName_CPk(className, classPK);
	}

	/**
	* Returns all the e s f entity states where className = &#63;.
	*
	* @param className the class name
	* @return the matching e s f entity states
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFEntityState> findByESFEntityStateCN(
		java.lang.String className)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByESFEntityStateCN(className);
	}

	/**
	* Returns a range of all the e s f entity states where className = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFEntityStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param className the class name
	* @param start the lower bound of the range of e s f entity states
	* @param end the upper bound of the range of e s f entity states (not inclusive)
	* @return the range of matching e s f entity states
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFEntityState> findByESFEntityStateCN(
		java.lang.String className, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByESFEntityStateCN(className, start, end);
	}

	/**
	* Returns an ordered range of all the e s f entity states where className = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFEntityStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param className the class name
	* @param start the lower bound of the range of e s f entity states
	* @param end the upper bound of the range of e s f entity states (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f entity states
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFEntityState> findByESFEntityStateCN(
		java.lang.String className, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByESFEntityStateCN(className, start, end,
			orderByComparator);
	}

	/**
	* Returns the first e s f entity state in the ordered set where className = &#63;.
	*
	* @param className the class name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f entity state
	* @throws it.ethica.esf.NoSuchEntityStateException if a matching e s f entity state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFEntityState findByESFEntityStateCN_First(
		java.lang.String className,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchEntityStateException {
		return getPersistence()
				   .findByESFEntityStateCN_First(className, orderByComparator);
	}

	/**
	* Returns the first e s f entity state in the ordered set where className = &#63;.
	*
	* @param className the class name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f entity state, or <code>null</code> if a matching e s f entity state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFEntityState fetchByESFEntityStateCN_First(
		java.lang.String className,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByESFEntityStateCN_First(className, orderByComparator);
	}

	/**
	* Returns the last e s f entity state in the ordered set where className = &#63;.
	*
	* @param className the class name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f entity state
	* @throws it.ethica.esf.NoSuchEntityStateException if a matching e s f entity state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFEntityState findByESFEntityStateCN_Last(
		java.lang.String className,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchEntityStateException {
		return getPersistence()
				   .findByESFEntityStateCN_Last(className, orderByComparator);
	}

	/**
	* Returns the last e s f entity state in the ordered set where className = &#63;.
	*
	* @param className the class name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f entity state, or <code>null</code> if a matching e s f entity state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFEntityState fetchByESFEntityStateCN_Last(
		java.lang.String className,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByESFEntityStateCN_Last(className, orderByComparator);
	}

	/**
	* Returns the e s f entity states before and after the current e s f entity state in the ordered set where className = &#63;.
	*
	* @param esfEntityStateId the primary key of the current e s f entity state
	* @param className the class name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f entity state
	* @throws it.ethica.esf.NoSuchEntityStateException if a e s f entity state with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFEntityState[] findByESFEntityStateCN_PrevAndNext(
		long esfEntityStateId, java.lang.String className,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchEntityStateException {
		return getPersistence()
				   .findByESFEntityStateCN_PrevAndNext(esfEntityStateId,
			className, orderByComparator);
	}

	/**
	* Removes all the e s f entity states where className = &#63; from the database.
	*
	* @param className the class name
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByESFEntityStateCN(java.lang.String className)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByESFEntityStateCN(className);
	}

	/**
	* Returns the number of e s f entity states where className = &#63;.
	*
	* @param className the class name
	* @return the number of matching e s f entity states
	* @throws SystemException if a system exception occurred
	*/
	public static int countByESFEntityStateCN(java.lang.String className)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByESFEntityStateCN(className);
	}

	/**
	* Returns the e s f entity state where className = &#63; and classPK = &#63; or throws a {@link it.ethica.esf.NoSuchEntityStateException} if it could not be found.
	*
	* @param className the class name
	* @param classPK the class p k
	* @return the matching e s f entity state
	* @throws it.ethica.esf.NoSuchEntityStateException if a matching e s f entity state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFEntityState findByAllESFEntityStateClassName_ClassPK(
		java.lang.String className, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchEntityStateException {
		return getPersistence()
				   .findByAllESFEntityStateClassName_ClassPK(className, classPK);
	}

	/**
	* Returns the e s f entity state where className = &#63; and classPK = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param className the class name
	* @param classPK the class p k
	* @return the matching e s f entity state, or <code>null</code> if a matching e s f entity state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFEntityState fetchByAllESFEntityStateClassName_ClassPK(
		java.lang.String className, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByAllESFEntityStateClassName_ClassPK(className, classPK);
	}

	/**
	* Returns the e s f entity state where className = &#63; and classPK = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching e s f entity state, or <code>null</code> if a matching e s f entity state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFEntityState fetchByAllESFEntityStateClassName_ClassPK(
		java.lang.String className, long classPK, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByAllESFEntityStateClassName_ClassPK(className,
			classPK, retrieveFromCache);
	}

	/**
	* Removes the e s f entity state where className = &#63; and classPK = &#63; from the database.
	*
	* @param className the class name
	* @param classPK the class p k
	* @return the e s f entity state that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFEntityState removeByAllESFEntityStateClassName_ClassPK(
		java.lang.String className, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchEntityStateException {
		return getPersistence()
				   .removeByAllESFEntityStateClassName_ClassPK(className,
			classPK);
	}

	/**
	* Returns the number of e s f entity states where className = &#63; and classPK = &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @return the number of matching e s f entity states
	* @throws SystemException if a system exception occurred
	*/
	public static int countByAllESFEntityStateClassName_ClassPK(
		java.lang.String className, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByAllESFEntityStateClassName_ClassPK(className, classPK);
	}

	/**
	* Caches the e s f entity state in the entity cache if it is enabled.
	*
	* @param esfEntityState the e s f entity state
	*/
	public static void cacheResult(
		it.ethica.esf.model.ESFEntityState esfEntityState) {
		getPersistence().cacheResult(esfEntityState);
	}

	/**
	* Caches the e s f entity states in the entity cache if it is enabled.
	*
	* @param esfEntityStates the e s f entity states
	*/
	public static void cacheResult(
		java.util.List<it.ethica.esf.model.ESFEntityState> esfEntityStates) {
		getPersistence().cacheResult(esfEntityStates);
	}

	/**
	* Creates a new e s f entity state with the primary key. Does not add the e s f entity state to the database.
	*
	* @param esfEntityStateId the primary key for the new e s f entity state
	* @return the new e s f entity state
	*/
	public static it.ethica.esf.model.ESFEntityState create(
		long esfEntityStateId) {
		return getPersistence().create(esfEntityStateId);
	}

	/**
	* Removes the e s f entity state with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfEntityStateId the primary key of the e s f entity state
	* @return the e s f entity state that was removed
	* @throws it.ethica.esf.NoSuchEntityStateException if a e s f entity state with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFEntityState remove(
		long esfEntityStateId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchEntityStateException {
		return getPersistence().remove(esfEntityStateId);
	}

	public static it.ethica.esf.model.ESFEntityState updateImpl(
		it.ethica.esf.model.ESFEntityState esfEntityState)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(esfEntityState);
	}

	/**
	* Returns the e s f entity state with the primary key or throws a {@link it.ethica.esf.NoSuchEntityStateException} if it could not be found.
	*
	* @param esfEntityStateId the primary key of the e s f entity state
	* @return the e s f entity state
	* @throws it.ethica.esf.NoSuchEntityStateException if a e s f entity state with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFEntityState findByPrimaryKey(
		long esfEntityStateId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchEntityStateException {
		return getPersistence().findByPrimaryKey(esfEntityStateId);
	}

	/**
	* Returns the e s f entity state with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param esfEntityStateId the primary key of the e s f entity state
	* @return the e s f entity state, or <code>null</code> if a e s f entity state with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFEntityState fetchByPrimaryKey(
		long esfEntityStateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(esfEntityStateId);
	}

	/**
	* Returns all the e s f entity states.
	*
	* @return the e s f entity states
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFEntityState> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the e s f entity states.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFEntityStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f entity states
	* @param end the upper bound of the range of e s f entity states (not inclusive)
	* @return the range of e s f entity states
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFEntityState> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the e s f entity states.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFEntityStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f entity states
	* @param end the upper bound of the range of e s f entity states (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of e s f entity states
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFEntityState> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the e s f entity states from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of e s f entity states.
	*
	* @return the number of e s f entity states
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ESFEntityStatePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ESFEntityStatePersistence)PortletBeanLocatorUtil.locate(it.ethica.esf.service.ClpSerializer.getServletContextName(),
					ESFEntityStatePersistence.class.getName());

			ReferenceRegistry.registerReference(ESFEntityStateUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ESFEntityStatePersistence persistence) {
	}

	private static ESFEntityStatePersistence _persistence;
}