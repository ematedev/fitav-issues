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

import it.ethica.esf.model.ESFLentField;

/**
 * The persistence interface for the e s f lent field service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFLentFieldPersistenceImpl
 * @see ESFLentFieldUtil
 * @generated
 */
public interface ESFLentFieldPersistence extends BasePersistence<ESFLentField> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ESFLentFieldUtil} to access the e s f lent field persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the e s f lent field where esfFieldId = &#63; and esfEntityStateId = &#63; or throws a {@link it.ethica.esf.NoSuchLentFieldException} if it could not be found.
	*
	* @param esfFieldId the esf field ID
	* @param esfEntityStateId the esf entity state ID
	* @return the matching e s f lent field
	* @throws it.ethica.esf.NoSuchLentFieldException if a matching e s f lent field could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFLentField findByF_S(long esfFieldId,
		long esfEntityStateId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchLentFieldException;

	/**
	* Returns the e s f lent field where esfFieldId = &#63; and esfEntityStateId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param esfFieldId the esf field ID
	* @param esfEntityStateId the esf entity state ID
	* @return the matching e s f lent field, or <code>null</code> if a matching e s f lent field could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFLentField fetchByF_S(long esfFieldId,
		long esfEntityStateId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f lent field where esfFieldId = &#63; and esfEntityStateId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param esfFieldId the esf field ID
	* @param esfEntityStateId the esf entity state ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching e s f lent field, or <code>null</code> if a matching e s f lent field could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFLentField fetchByF_S(long esfFieldId,
		long esfEntityStateId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the e s f lent field where esfFieldId = &#63; and esfEntityStateId = &#63; from the database.
	*
	* @param esfFieldId the esf field ID
	* @param esfEntityStateId the esf entity state ID
	* @return the e s f lent field that was removed
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFLentField removeByF_S(long esfFieldId,
		long esfEntityStateId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchLentFieldException;

	/**
	* Returns the number of e s f lent fields where esfFieldId = &#63; and esfEntityStateId = &#63;.
	*
	* @param esfFieldId the esf field ID
	* @param esfEntityStateId the esf entity state ID
	* @return the number of matching e s f lent fields
	* @throws SystemException if a system exception occurred
	*/
	public int countByF_S(long esfFieldId, long esfEntityStateId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the e s f lent field in the entity cache if it is enabled.
	*
	* @param esfLentField the e s f lent field
	*/
	public void cacheResult(it.ethica.esf.model.ESFLentField esfLentField);

	/**
	* Caches the e s f lent fields in the entity cache if it is enabled.
	*
	* @param esfLentFields the e s f lent fields
	*/
	public void cacheResult(
		java.util.List<it.ethica.esf.model.ESFLentField> esfLentFields);

	/**
	* Creates a new e s f lent field with the primary key. Does not add the e s f lent field to the database.
	*
	* @param lentFieldId the primary key for the new e s f lent field
	* @return the new e s f lent field
	*/
	public it.ethica.esf.model.ESFLentField create(long lentFieldId);

	/**
	* Removes the e s f lent field with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param lentFieldId the primary key of the e s f lent field
	* @return the e s f lent field that was removed
	* @throws it.ethica.esf.NoSuchLentFieldException if a e s f lent field with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFLentField remove(long lentFieldId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchLentFieldException;

	public it.ethica.esf.model.ESFLentField updateImpl(
		it.ethica.esf.model.ESFLentField esfLentField)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f lent field with the primary key or throws a {@link it.ethica.esf.NoSuchLentFieldException} if it could not be found.
	*
	* @param lentFieldId the primary key of the e s f lent field
	* @return the e s f lent field
	* @throws it.ethica.esf.NoSuchLentFieldException if a e s f lent field with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFLentField findByPrimaryKey(long lentFieldId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchLentFieldException;

	/**
	* Returns the e s f lent field with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param lentFieldId the primary key of the e s f lent field
	* @return the e s f lent field, or <code>null</code> if a e s f lent field with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFLentField fetchByPrimaryKey(long lentFieldId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f lent fields.
	*
	* @return the e s f lent fields
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFLentField> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.ethica.esf.model.ESFLentField> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.ethica.esf.model.ESFLentField> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the e s f lent fields from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f lent fields.
	*
	* @return the number of e s f lent fields
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}