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

import it.ethica.esf.model.ESFMatchType;

/**
 * The persistence interface for the e s f match type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFMatchTypePersistenceImpl
 * @see ESFMatchTypeUtil
 * @generated
 */
public interface ESFMatchTypePersistence extends BasePersistence<ESFMatchType> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ESFMatchTypeUtil} to access the e s f match type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the e s f match type where code = &#63; or throws a {@link it.ethica.esf.NoSuchMatchTypeException} if it could not be found.
	*
	* @param code the code
	* @return the matching e s f match type
	* @throws it.ethica.esf.NoSuchMatchTypeException if a matching e s f match type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFMatchType findByCode(java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchMatchTypeException;

	/**
	* Returns the e s f match type where code = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param code the code
	* @return the matching e s f match type, or <code>null</code> if a matching e s f match type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFMatchType fetchByCode(java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f match type where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param code the code
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching e s f match type, or <code>null</code> if a matching e s f match type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFMatchType fetchByCode(java.lang.String code,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the e s f match type where code = &#63; from the database.
	*
	* @param code the code
	* @return the e s f match type that was removed
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFMatchType removeByCode(java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchMatchTypeException;

	/**
	* Returns the number of e s f match types where code = &#63;.
	*
	* @param code the code
	* @return the number of matching e s f match types
	* @throws SystemException if a system exception occurred
	*/
	public int countByCode(java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f match types where isNational = &#63;.
	*
	* @param isNational the is national
	* @return the matching e s f match types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFMatchType> findByIsNational(
		boolean isNational)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f match types where isNational = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFMatchTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param isNational the is national
	* @param start the lower bound of the range of e s f match types
	* @param end the upper bound of the range of e s f match types (not inclusive)
	* @return the range of matching e s f match types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFMatchType> findByIsNational(
		boolean isNational, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f match types where isNational = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFMatchTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param isNational the is national
	* @param start the lower bound of the range of e s f match types
	* @param end the upper bound of the range of e s f match types (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f match types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFMatchType> findByIsNational(
		boolean isNational, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f match type in the ordered set where isNational = &#63;.
	*
	* @param isNational the is national
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f match type
	* @throws it.ethica.esf.NoSuchMatchTypeException if a matching e s f match type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFMatchType findByIsNational_First(
		boolean isNational,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchMatchTypeException;

	/**
	* Returns the first e s f match type in the ordered set where isNational = &#63;.
	*
	* @param isNational the is national
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f match type, or <code>null</code> if a matching e s f match type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFMatchType fetchByIsNational_First(
		boolean isNational,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f match type in the ordered set where isNational = &#63;.
	*
	* @param isNational the is national
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f match type
	* @throws it.ethica.esf.NoSuchMatchTypeException if a matching e s f match type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFMatchType findByIsNational_Last(
		boolean isNational,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchMatchTypeException;

	/**
	* Returns the last e s f match type in the ordered set where isNational = &#63;.
	*
	* @param isNational the is national
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f match type, or <code>null</code> if a matching e s f match type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFMatchType fetchByIsNational_Last(
		boolean isNational,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f match types before and after the current e s f match type in the ordered set where isNational = &#63;.
	*
	* @param esfMatchTypeId the primary key of the current e s f match type
	* @param isNational the is national
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f match type
	* @throws it.ethica.esf.NoSuchMatchTypeException if a e s f match type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFMatchType[] findByIsNational_PrevAndNext(
		long esfMatchTypeId, boolean isNational,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchMatchTypeException;

	/**
	* Removes all the e s f match types where isNational = &#63; from the database.
	*
	* @param isNational the is national
	* @throws SystemException if a system exception occurred
	*/
	public void removeByIsNational(boolean isNational)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f match types where isNational = &#63;.
	*
	* @param isNational the is national
	* @return the number of matching e s f match types
	* @throws SystemException if a system exception occurred
	*/
	public int countByIsNational(boolean isNational)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f match type where name = &#63; or throws a {@link it.ethica.esf.NoSuchMatchTypeException} if it could not be found.
	*
	* @param name the name
	* @return the matching e s f match type
	* @throws it.ethica.esf.NoSuchMatchTypeException if a matching e s f match type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFMatchType findByfindByDescription(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchMatchTypeException;

	/**
	* Returns the e s f match type where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param name the name
	* @return the matching e s f match type, or <code>null</code> if a matching e s f match type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFMatchType fetchByfindByDescription(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f match type where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param name the name
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching e s f match type, or <code>null</code> if a matching e s f match type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFMatchType fetchByfindByDescription(
		java.lang.String name, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the e s f match type where name = &#63; from the database.
	*
	* @param name the name
	* @return the e s f match type that was removed
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFMatchType removeByfindByDescription(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchMatchTypeException;

	/**
	* Returns the number of e s f match types where name = &#63;.
	*
	* @param name the name
	* @return the number of matching e s f match types
	* @throws SystemException if a system exception occurred
	*/
	public int countByfindByDescription(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the e s f match type in the entity cache if it is enabled.
	*
	* @param esfMatchType the e s f match type
	*/
	public void cacheResult(it.ethica.esf.model.ESFMatchType esfMatchType);

	/**
	* Caches the e s f match types in the entity cache if it is enabled.
	*
	* @param esfMatchTypes the e s f match types
	*/
	public void cacheResult(
		java.util.List<it.ethica.esf.model.ESFMatchType> esfMatchTypes);

	/**
	* Creates a new e s f match type with the primary key. Does not add the e s f match type to the database.
	*
	* @param esfMatchTypeId the primary key for the new e s f match type
	* @return the new e s f match type
	*/
	public it.ethica.esf.model.ESFMatchType create(long esfMatchTypeId);

	/**
	* Removes the e s f match type with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfMatchTypeId the primary key of the e s f match type
	* @return the e s f match type that was removed
	* @throws it.ethica.esf.NoSuchMatchTypeException if a e s f match type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFMatchType remove(long esfMatchTypeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchMatchTypeException;

	public it.ethica.esf.model.ESFMatchType updateImpl(
		it.ethica.esf.model.ESFMatchType esfMatchType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f match type with the primary key or throws a {@link it.ethica.esf.NoSuchMatchTypeException} if it could not be found.
	*
	* @param esfMatchTypeId the primary key of the e s f match type
	* @return the e s f match type
	* @throws it.ethica.esf.NoSuchMatchTypeException if a e s f match type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFMatchType findByPrimaryKey(
		long esfMatchTypeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchMatchTypeException;

	/**
	* Returns the e s f match type with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param esfMatchTypeId the primary key of the e s f match type
	* @return the e s f match type, or <code>null</code> if a e s f match type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFMatchType fetchByPrimaryKey(
		long esfMatchTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f match types.
	*
	* @return the e s f match types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFMatchType> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f match types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFMatchTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f match types
	* @param end the upper bound of the range of e s f match types (not inclusive)
	* @return the range of e s f match types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFMatchType> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f match types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFMatchTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f match types
	* @param end the upper bound of the range of e s f match types (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of e s f match types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFMatchType> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the e s f match types from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f match types.
	*
	* @return the number of e s f match types
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}