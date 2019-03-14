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

import it.ethica.esf.model.ESFDocumentType;

/**
 * The persistence interface for the e s f document type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFDocumentTypePersistenceImpl
 * @see ESFDocumentTypeUtil
 * @generated
 */
public interface ESFDocumentTypePersistence extends BasePersistence<ESFDocumentType> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ESFDocumentTypeUtil} to access the e s f document type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the e s f document type in the entity cache if it is enabled.
	*
	* @param esfDocumentType the e s f document type
	*/
	public void cacheResult(it.ethica.esf.model.ESFDocumentType esfDocumentType);

	/**
	* Caches the e s f document types in the entity cache if it is enabled.
	*
	* @param esfDocumentTypes the e s f document types
	*/
	public void cacheResult(
		java.util.List<it.ethica.esf.model.ESFDocumentType> esfDocumentTypes);

	/**
	* Creates a new e s f document type with the primary key. Does not add the e s f document type to the database.
	*
	* @param esfDocumentTypeId the primary key for the new e s f document type
	* @return the new e s f document type
	*/
	public it.ethica.esf.model.ESFDocumentType create(long esfDocumentTypeId);

	/**
	* Removes the e s f document type with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfDocumentTypeId the primary key of the e s f document type
	* @return the e s f document type that was removed
	* @throws it.ethica.esf.NoSuchDocumentTypeException if a e s f document type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFDocumentType remove(long esfDocumentTypeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchDocumentTypeException;

	public it.ethica.esf.model.ESFDocumentType updateImpl(
		it.ethica.esf.model.ESFDocumentType esfDocumentType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f document type with the primary key or throws a {@link it.ethica.esf.NoSuchDocumentTypeException} if it could not be found.
	*
	* @param esfDocumentTypeId the primary key of the e s f document type
	* @return the e s f document type
	* @throws it.ethica.esf.NoSuchDocumentTypeException if a e s f document type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFDocumentType findByPrimaryKey(
		long esfDocumentTypeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchDocumentTypeException;

	/**
	* Returns the e s f document type with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param esfDocumentTypeId the primary key of the e s f document type
	* @return the e s f document type, or <code>null</code> if a e s f document type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFDocumentType fetchByPrimaryKey(
		long esfDocumentTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f document types.
	*
	* @return the e s f document types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFDocumentType> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.ethica.esf.model.ESFDocumentType> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.ethica.esf.model.ESFDocumentType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the e s f document types from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f document types.
	*
	* @return the number of e s f document types
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}