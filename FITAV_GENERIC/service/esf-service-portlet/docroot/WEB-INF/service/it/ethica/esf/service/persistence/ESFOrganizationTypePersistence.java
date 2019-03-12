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

import com.liferay.portal.service.persistence.BasePersistence;

import it.ethica.esf.model.ESFOrganizationType;

/**
 * The persistence interface for the e s f organization type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFOrganizationTypePersistenceImpl
 * @see ESFOrganizationTypeUtil
 * @generated
 */
public interface ESFOrganizationTypePersistence extends BasePersistence<ESFOrganizationType> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ESFOrganizationTypeUtil} to access the e s f organization type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the e s f organization types where esfOrganizationId = &#63;.
	*
	* @param esfOrganizationId the esf organization ID
	* @return the matching e s f organization types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFOrganizationType> findByESFOrganizationId(
		long esfOrganizationId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.ethica.esf.model.ESFOrganizationType> findByESFOrganizationId(
		long esfOrganizationId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.ethica.esf.model.ESFOrganizationType> findByESFOrganizationId(
		long esfOrganizationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f organization type in the ordered set where esfOrganizationId = &#63;.
	*
	* @param esfOrganizationId the esf organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f organization type
	* @throws it.ethica.esf.NoSuchOrganizationTypeException if a matching e s f organization type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFOrganizationType findByESFOrganizationId_First(
		long esfOrganizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchOrganizationTypeException;

	/**
	* Returns the first e s f organization type in the ordered set where esfOrganizationId = &#63;.
	*
	* @param esfOrganizationId the esf organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f organization type, or <code>null</code> if a matching e s f organization type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFOrganizationType fetchByESFOrganizationId_First(
		long esfOrganizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f organization type in the ordered set where esfOrganizationId = &#63;.
	*
	* @param esfOrganizationId the esf organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f organization type
	* @throws it.ethica.esf.NoSuchOrganizationTypeException if a matching e s f organization type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFOrganizationType findByESFOrganizationId_Last(
		long esfOrganizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchOrganizationTypeException;

	/**
	* Returns the last e s f organization type in the ordered set where esfOrganizationId = &#63;.
	*
	* @param esfOrganizationId the esf organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f organization type, or <code>null</code> if a matching e s f organization type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFOrganizationType fetchByESFOrganizationId_Last(
		long esfOrganizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public it.ethica.esf.model.ESFOrganizationType[] findByESFOrganizationId_PrevAndNext(
		long esfOrganizationTypeId, long esfOrganizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchOrganizationTypeException;

	/**
	* Removes all the e s f organization types where esfOrganizationId = &#63; from the database.
	*
	* @param esfOrganizationId the esf organization ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByESFOrganizationId(long esfOrganizationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f organization types where esfOrganizationId = &#63;.
	*
	* @param esfOrganizationId the esf organization ID
	* @return the number of matching e s f organization types
	* @throws SystemException if a system exception occurred
	*/
	public int countByESFOrganizationId(long esfOrganizationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f organization types where esfTypeId = &#63;.
	*
	* @param esfTypeId the esf type ID
	* @return the matching e s f organization types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFOrganizationType> findByESFTypeId(
		long esfTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.ethica.esf.model.ESFOrganizationType> findByESFTypeId(
		long esfTypeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.ethica.esf.model.ESFOrganizationType> findByESFTypeId(
		long esfTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f organization type in the ordered set where esfTypeId = &#63;.
	*
	* @param esfTypeId the esf type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f organization type
	* @throws it.ethica.esf.NoSuchOrganizationTypeException if a matching e s f organization type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFOrganizationType findByESFTypeId_First(
		long esfTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchOrganizationTypeException;

	/**
	* Returns the first e s f organization type in the ordered set where esfTypeId = &#63;.
	*
	* @param esfTypeId the esf type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f organization type, or <code>null</code> if a matching e s f organization type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFOrganizationType fetchByESFTypeId_First(
		long esfTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f organization type in the ordered set where esfTypeId = &#63;.
	*
	* @param esfTypeId the esf type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f organization type
	* @throws it.ethica.esf.NoSuchOrganizationTypeException if a matching e s f organization type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFOrganizationType findByESFTypeId_Last(
		long esfTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchOrganizationTypeException;

	/**
	* Returns the last e s f organization type in the ordered set where esfTypeId = &#63;.
	*
	* @param esfTypeId the esf type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f organization type, or <code>null</code> if a matching e s f organization type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFOrganizationType fetchByESFTypeId_Last(
		long esfTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public it.ethica.esf.model.ESFOrganizationType[] findByESFTypeId_PrevAndNext(
		long esfOrganizationTypeId, long esfTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchOrganizationTypeException;

	/**
	* Removes all the e s f organization types where esfTypeId = &#63; from the database.
	*
	* @param esfTypeId the esf type ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByESFTypeId(long esfTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f organization types where esfTypeId = &#63;.
	*
	* @param esfTypeId the esf type ID
	* @return the number of matching e s f organization types
	* @throws SystemException if a system exception occurred
	*/
	public int countByESFTypeId(long esfTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the e s f organization type in the entity cache if it is enabled.
	*
	* @param esfOrganizationType the e s f organization type
	*/
	public void cacheResult(
		it.ethica.esf.model.ESFOrganizationType esfOrganizationType);

	/**
	* Caches the e s f organization types in the entity cache if it is enabled.
	*
	* @param esfOrganizationTypes the e s f organization types
	*/
	public void cacheResult(
		java.util.List<it.ethica.esf.model.ESFOrganizationType> esfOrganizationTypes);

	/**
	* Creates a new e s f organization type with the primary key. Does not add the e s f organization type to the database.
	*
	* @param esfOrganizationTypeId the primary key for the new e s f organization type
	* @return the new e s f organization type
	*/
	public it.ethica.esf.model.ESFOrganizationType create(
		long esfOrganizationTypeId);

	/**
	* Removes the e s f organization type with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfOrganizationTypeId the primary key of the e s f organization type
	* @return the e s f organization type that was removed
	* @throws it.ethica.esf.NoSuchOrganizationTypeException if a e s f organization type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFOrganizationType remove(
		long esfOrganizationTypeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchOrganizationTypeException;

	public it.ethica.esf.model.ESFOrganizationType updateImpl(
		it.ethica.esf.model.ESFOrganizationType esfOrganizationType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f organization type with the primary key or throws a {@link it.ethica.esf.NoSuchOrganizationTypeException} if it could not be found.
	*
	* @param esfOrganizationTypeId the primary key of the e s f organization type
	* @return the e s f organization type
	* @throws it.ethica.esf.NoSuchOrganizationTypeException if a e s f organization type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFOrganizationType findByPrimaryKey(
		long esfOrganizationTypeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchOrganizationTypeException;

	/**
	* Returns the e s f organization type with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param esfOrganizationTypeId the primary key of the e s f organization type
	* @return the e s f organization type, or <code>null</code> if a e s f organization type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFOrganizationType fetchByPrimaryKey(
		long esfOrganizationTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f organization types.
	*
	* @return the e s f organization types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFOrganizationType> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.ethica.esf.model.ESFOrganizationType> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.ethica.esf.model.ESFOrganizationType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the e s f organization types from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f organization types.
	*
	* @return the number of e s f organization types
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}