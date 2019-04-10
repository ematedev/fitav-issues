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

import com.liferay.portal.service.persistence.BasePersistence;

import it.ethica.esf.model.ESFEntityState;

/**
 * The persistence interface for the e s f entity state service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFEntityStatePersistenceImpl
 * @see ESFEntityStateUtil
 * @generated
 */
public interface ESFEntityStatePersistence extends BasePersistence<ESFEntityState> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ESFEntityStateUtil} to access the e s f entity state persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the e s f entity state where className = &#63; and classPK = &#63; or throws a {@link it.ethica.esf.NoSuchEntityStateException} if it could not be found.
	*
	* @param className the class name
	* @param classPK the class p k
	* @return the matching e s f entity state
	* @throws it.ethica.esf.NoSuchEntityStateException if a matching e s f entity state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFEntityState findByESFEntityStateC_PK(
		java.lang.String className, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchEntityStateException;

	/**
	* Returns the e s f entity state where className = &#63; and classPK = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param className the class name
	* @param classPK the class p k
	* @return the matching e s f entity state, or <code>null</code> if a matching e s f entity state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFEntityState fetchByESFEntityStateC_PK(
		java.lang.String className, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f entity state where className = &#63; and classPK = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching e s f entity state, or <code>null</code> if a matching e s f entity state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFEntityState fetchByESFEntityStateC_PK(
		java.lang.String className, long classPK, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the e s f entity state where className = &#63; and classPK = &#63; from the database.
	*
	* @param className the class name
	* @param classPK the class p k
	* @return the e s f entity state that was removed
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFEntityState removeByESFEntityStateC_PK(
		java.lang.String className, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchEntityStateException;

	/**
	* Returns the number of e s f entity states where className = &#63; and classPK = &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @return the number of matching e s f entity states
	* @throws SystemException if a system exception occurred
	*/
	public int countByESFEntityStateC_PK(java.lang.String className,
		long classPK)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public it.ethica.esf.model.ESFEntityState findByESFEntityStateC_PK_S(
		java.lang.String className, long classPK, long esfStateId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchEntityStateException;

	/**
	* Returns the e s f entity state where className = &#63; and classPK = &#63; and esfStateId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param esfStateId the esf state ID
	* @return the matching e s f entity state, or <code>null</code> if a matching e s f entity state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFEntityState fetchByESFEntityStateC_PK_S(
		java.lang.String className, long classPK, long esfStateId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public it.ethica.esf.model.ESFEntityState fetchByESFEntityStateC_PK_S(
		java.lang.String className, long classPK, long esfStateId,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the e s f entity state where className = &#63; and classPK = &#63; and esfStateId = &#63; from the database.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param esfStateId the esf state ID
	* @return the e s f entity state that was removed
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFEntityState removeByESFEntityStateC_PK_S(
		java.lang.String className, long classPK, long esfStateId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchEntityStateException;

	/**
	* Returns the number of e s f entity states where className = &#63; and classPK = &#63; and esfStateId = &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param esfStateId the esf state ID
	* @return the number of matching e s f entity states
	* @throws SystemException if a system exception occurred
	*/
	public int countByESFEntityStateC_PK_S(java.lang.String className,
		long classPK, long esfStateId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f entity states where className = &#63; and esfStateId = &#63;.
	*
	* @param className the class name
	* @param esfStateId the esf state ID
	* @return the matching e s f entity states
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFEntityState> findByESFEntityStateC_S(
		java.lang.String className, long esfStateId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.ethica.esf.model.ESFEntityState> findByESFEntityStateC_S(
		java.lang.String className, long esfStateId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.ethica.esf.model.ESFEntityState> findByESFEntityStateC_S(
		java.lang.String className, long esfStateId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public it.ethica.esf.model.ESFEntityState findByESFEntityStateC_S_First(
		java.lang.String className, long esfStateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchEntityStateException;

	/**
	* Returns the first e s f entity state in the ordered set where className = &#63; and esfStateId = &#63;.
	*
	* @param className the class name
	* @param esfStateId the esf state ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f entity state, or <code>null</code> if a matching e s f entity state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFEntityState fetchByESFEntityStateC_S_First(
		java.lang.String className, long esfStateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public it.ethica.esf.model.ESFEntityState findByESFEntityStateC_S_Last(
		java.lang.String className, long esfStateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchEntityStateException;

	/**
	* Returns the last e s f entity state in the ordered set where className = &#63; and esfStateId = &#63;.
	*
	* @param className the class name
	* @param esfStateId the esf state ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f entity state, or <code>null</code> if a matching e s f entity state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFEntityState fetchByESFEntityStateC_S_Last(
		java.lang.String className, long esfStateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public it.ethica.esf.model.ESFEntityState[] findByESFEntityStateC_S_PrevAndNext(
		long esfEntityStateId, java.lang.String className, long esfStateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchEntityStateException;

	/**
	* Removes all the e s f entity states where className = &#63; and esfStateId = &#63; from the database.
	*
	* @param className the class name
	* @param esfStateId the esf state ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByESFEntityStateC_S(java.lang.String className,
		long esfStateId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f entity states where className = &#63; and esfStateId = &#63;.
	*
	* @param className the class name
	* @param esfStateId the esf state ID
	* @return the number of matching e s f entity states
	* @throws SystemException if a system exception occurred
	*/
	public int countByESFEntityStateC_S(java.lang.String className,
		long esfStateId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f entity states where className = &#63; and classPK = &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @return the matching e s f entity states
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFEntityState> findByESFEntityStateCName_CPk(
		java.lang.String className, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.ethica.esf.model.ESFEntityState> findByESFEntityStateCName_CPk(
		java.lang.String className, long classPK, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.ethica.esf.model.ESFEntityState> findByESFEntityStateCName_CPk(
		java.lang.String className, long classPK, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public it.ethica.esf.model.ESFEntityState findByESFEntityStateCName_CPk_First(
		java.lang.String className, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchEntityStateException;

	/**
	* Returns the first e s f entity state in the ordered set where className = &#63; and classPK = &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f entity state, or <code>null</code> if a matching e s f entity state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFEntityState fetchByESFEntityStateCName_CPk_First(
		java.lang.String className, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public it.ethica.esf.model.ESFEntityState findByESFEntityStateCName_CPk_Last(
		java.lang.String className, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchEntityStateException;

	/**
	* Returns the last e s f entity state in the ordered set where className = &#63; and classPK = &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f entity state, or <code>null</code> if a matching e s f entity state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFEntityState fetchByESFEntityStateCName_CPk_Last(
		java.lang.String className, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public it.ethica.esf.model.ESFEntityState[] findByESFEntityStateCName_CPk_PrevAndNext(
		long esfEntityStateId, java.lang.String className, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchEntityStateException;

	/**
	* Removes all the e s f entity states where className = &#63; and classPK = &#63; from the database.
	*
	* @param className the class name
	* @param classPK the class p k
	* @throws SystemException if a system exception occurred
	*/
	public void removeByESFEntityStateCName_CPk(java.lang.String className,
		long classPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f entity states where className = &#63; and classPK = &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @return the number of matching e s f entity states
	* @throws SystemException if a system exception occurred
	*/
	public int countByESFEntityStateCName_CPk(java.lang.String className,
		long classPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f entity states where className = &#63;.
	*
	* @param className the class name
	* @return the matching e s f entity states
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFEntityState> findByESFEntityStateCN(
		java.lang.String className)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.ethica.esf.model.ESFEntityState> findByESFEntityStateCN(
		java.lang.String className, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.ethica.esf.model.ESFEntityState> findByESFEntityStateCN(
		java.lang.String className, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f entity state in the ordered set where className = &#63;.
	*
	* @param className the class name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f entity state
	* @throws it.ethica.esf.NoSuchEntityStateException if a matching e s f entity state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFEntityState findByESFEntityStateCN_First(
		java.lang.String className,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchEntityStateException;

	/**
	* Returns the first e s f entity state in the ordered set where className = &#63;.
	*
	* @param className the class name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f entity state, or <code>null</code> if a matching e s f entity state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFEntityState fetchByESFEntityStateCN_First(
		java.lang.String className,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f entity state in the ordered set where className = &#63;.
	*
	* @param className the class name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f entity state
	* @throws it.ethica.esf.NoSuchEntityStateException if a matching e s f entity state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFEntityState findByESFEntityStateCN_Last(
		java.lang.String className,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchEntityStateException;

	/**
	* Returns the last e s f entity state in the ordered set where className = &#63;.
	*
	* @param className the class name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f entity state, or <code>null</code> if a matching e s f entity state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFEntityState fetchByESFEntityStateCN_Last(
		java.lang.String className,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public it.ethica.esf.model.ESFEntityState[] findByESFEntityStateCN_PrevAndNext(
		long esfEntityStateId, java.lang.String className,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchEntityStateException;

	/**
	* Removes all the e s f entity states where className = &#63; from the database.
	*
	* @param className the class name
	* @throws SystemException if a system exception occurred
	*/
	public void removeByESFEntityStateCN(java.lang.String className)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f entity states where className = &#63;.
	*
	* @param className the class name
	* @return the number of matching e s f entity states
	* @throws SystemException if a system exception occurred
	*/
	public int countByESFEntityStateCN(java.lang.String className)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f entity state where className = &#63; and classPK = &#63; or throws a {@link it.ethica.esf.NoSuchEntityStateException} if it could not be found.
	*
	* @param className the class name
	* @param classPK the class p k
	* @return the matching e s f entity state
	* @throws it.ethica.esf.NoSuchEntityStateException if a matching e s f entity state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFEntityState findByAllESFEntityStateClassName_ClassPK(
		java.lang.String className, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchEntityStateException;

	/**
	* Returns the e s f entity state where className = &#63; and classPK = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param className the class name
	* @param classPK the class p k
	* @return the matching e s f entity state, or <code>null</code> if a matching e s f entity state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFEntityState fetchByAllESFEntityStateClassName_ClassPK(
		java.lang.String className, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f entity state where className = &#63; and classPK = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching e s f entity state, or <code>null</code> if a matching e s f entity state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFEntityState fetchByAllESFEntityStateClassName_ClassPK(
		java.lang.String className, long classPK, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the e s f entity state where className = &#63; and classPK = &#63; from the database.
	*
	* @param className the class name
	* @param classPK the class p k
	* @return the e s f entity state that was removed
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFEntityState removeByAllESFEntityStateClassName_ClassPK(
		java.lang.String className, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchEntityStateException;

	/**
	* Returns the number of e s f entity states where className = &#63; and classPK = &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @return the number of matching e s f entity states
	* @throws SystemException if a system exception occurred
	*/
	public int countByAllESFEntityStateClassName_ClassPK(
		java.lang.String className, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the e s f entity state in the entity cache if it is enabled.
	*
	* @param esfEntityState the e s f entity state
	*/
	public void cacheResult(it.ethica.esf.model.ESFEntityState esfEntityState);

	/**
	* Caches the e s f entity states in the entity cache if it is enabled.
	*
	* @param esfEntityStates the e s f entity states
	*/
	public void cacheResult(
		java.util.List<it.ethica.esf.model.ESFEntityState> esfEntityStates);

	/**
	* Creates a new e s f entity state with the primary key. Does not add the e s f entity state to the database.
	*
	* @param esfEntityStateId the primary key for the new e s f entity state
	* @return the new e s f entity state
	*/
	public it.ethica.esf.model.ESFEntityState create(long esfEntityStateId);

	/**
	* Removes the e s f entity state with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfEntityStateId the primary key of the e s f entity state
	* @return the e s f entity state that was removed
	* @throws it.ethica.esf.NoSuchEntityStateException if a e s f entity state with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFEntityState remove(long esfEntityStateId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchEntityStateException;

	public it.ethica.esf.model.ESFEntityState updateImpl(
		it.ethica.esf.model.ESFEntityState esfEntityState)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f entity state with the primary key or throws a {@link it.ethica.esf.NoSuchEntityStateException} if it could not be found.
	*
	* @param esfEntityStateId the primary key of the e s f entity state
	* @return the e s f entity state
	* @throws it.ethica.esf.NoSuchEntityStateException if a e s f entity state with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFEntityState findByPrimaryKey(
		long esfEntityStateId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchEntityStateException;

	/**
	* Returns the e s f entity state with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param esfEntityStateId the primary key of the e s f entity state
	* @return the e s f entity state, or <code>null</code> if a e s f entity state with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFEntityState fetchByPrimaryKey(
		long esfEntityStateId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f entity states.
	*
	* @return the e s f entity states
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFEntityState> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.ethica.esf.model.ESFEntityState> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.ethica.esf.model.ESFEntityState> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the e s f entity states from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f entity states.
	*
	* @return the number of e s f entity states
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}