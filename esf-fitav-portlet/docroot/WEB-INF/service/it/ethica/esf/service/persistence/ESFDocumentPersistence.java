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

import it.ethica.esf.model.ESFDocument;

/**
 * The persistence interface for the e s f document service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFDocumentPersistenceImpl
 * @see ESFDocumentUtil
 * @generated
 */
public interface ESFDocumentPersistence extends BasePersistence<ESFDocument> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ESFDocumentUtil} to access the e s f document persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the e s f documents where code = &#63;.
	*
	* @param code the code
	* @return the matching e s f documents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFDocument> findByCode(
		java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f documents where code = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param code the code
	* @param start the lower bound of the range of e s f documents
	* @param end the upper bound of the range of e s f documents (not inclusive)
	* @return the range of matching e s f documents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFDocument> findByCode(
		java.lang.String code, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f documents where code = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param code the code
	* @param start the lower bound of the range of e s f documents
	* @param end the upper bound of the range of e s f documents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f documents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFDocument> findByCode(
		java.lang.String code, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f document in the ordered set where code = &#63;.
	*
	* @param code the code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f document
	* @throws it.ethica.esf.NoSuchDocumentException if a matching e s f document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFDocument findByCode_First(
		java.lang.String code,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchDocumentException;

	/**
	* Returns the first e s f document in the ordered set where code = &#63;.
	*
	* @param code the code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f document, or <code>null</code> if a matching e s f document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFDocument fetchByCode_First(
		java.lang.String code,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f document in the ordered set where code = &#63;.
	*
	* @param code the code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f document
	* @throws it.ethica.esf.NoSuchDocumentException if a matching e s f document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFDocument findByCode_Last(
		java.lang.String code,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchDocumentException;

	/**
	* Returns the last e s f document in the ordered set where code = &#63;.
	*
	* @param code the code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f document, or <code>null</code> if a matching e s f document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFDocument fetchByCode_Last(
		java.lang.String code,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f documents before and after the current e s f document in the ordered set where code = &#63;.
	*
	* @param esfDocumentId the primary key of the current e s f document
	* @param code the code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f document
	* @throws it.ethica.esf.NoSuchDocumentException if a e s f document with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFDocument[] findByCode_PrevAndNext(
		long esfDocumentId, java.lang.String code,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchDocumentException;

	/**
	* Removes all the e s f documents where code = &#63; from the database.
	*
	* @param code the code
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCode(java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f documents where code = &#63;.
	*
	* @param code the code
	* @return the number of matching e s f documents
	* @throws SystemException if a system exception occurred
	*/
	public int countByCode(java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f documents where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @return the matching e s f documents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFDocument> findByesfUserId(
		long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f documents where esfUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfUserId the esf user ID
	* @param start the lower bound of the range of e s f documents
	* @param end the upper bound of the range of e s f documents (not inclusive)
	* @return the range of matching e s f documents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFDocument> findByesfUserId(
		long esfUserId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f documents where esfUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfUserId the esf user ID
	* @param start the lower bound of the range of e s f documents
	* @param end the upper bound of the range of e s f documents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f documents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFDocument> findByesfUserId(
		long esfUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f document in the ordered set where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f document
	* @throws it.ethica.esf.NoSuchDocumentException if a matching e s f document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFDocument findByesfUserId_First(
		long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchDocumentException;

	/**
	* Returns the first e s f document in the ordered set where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f document, or <code>null</code> if a matching e s f document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFDocument fetchByesfUserId_First(
		long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f document in the ordered set where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f document
	* @throws it.ethica.esf.NoSuchDocumentException if a matching e s f document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFDocument findByesfUserId_Last(
		long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchDocumentException;

	/**
	* Returns the last e s f document in the ordered set where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f document, or <code>null</code> if a matching e s f document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFDocument fetchByesfUserId_Last(
		long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f documents before and after the current e s f document in the ordered set where esfUserId = &#63;.
	*
	* @param esfDocumentId the primary key of the current e s f document
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f document
	* @throws it.ethica.esf.NoSuchDocumentException if a e s f document with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFDocument[] findByesfUserId_PrevAndNext(
		long esfDocumentId, long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchDocumentException;

	/**
	* Removes all the e s f documents where esfUserId = &#63; from the database.
	*
	* @param esfUserId the esf user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByesfUserId(long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f documents where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @return the number of matching e s f documents
	* @throws SystemException if a system exception occurred
	*/
	public int countByesfUserId(long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f documents where type = &#63; and esfUserId = &#63;.
	*
	* @param type the type
	* @param esfUserId the esf user ID
	* @return the matching e s f documents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFDocument> findByT_U(
		java.lang.String type, long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f documents where type = &#63; and esfUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param type the type
	* @param esfUserId the esf user ID
	* @param start the lower bound of the range of e s f documents
	* @param end the upper bound of the range of e s f documents (not inclusive)
	* @return the range of matching e s f documents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFDocument> findByT_U(
		java.lang.String type, long esfUserId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f documents where type = &#63; and esfUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param type the type
	* @param esfUserId the esf user ID
	* @param start the lower bound of the range of e s f documents
	* @param end the upper bound of the range of e s f documents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f documents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFDocument> findByT_U(
		java.lang.String type, long esfUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f document in the ordered set where type = &#63; and esfUserId = &#63;.
	*
	* @param type the type
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f document
	* @throws it.ethica.esf.NoSuchDocumentException if a matching e s f document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFDocument findByT_U_First(
		java.lang.String type, long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchDocumentException;

	/**
	* Returns the first e s f document in the ordered set where type = &#63; and esfUserId = &#63;.
	*
	* @param type the type
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f document, or <code>null</code> if a matching e s f document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFDocument fetchByT_U_First(
		java.lang.String type, long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f document in the ordered set where type = &#63; and esfUserId = &#63;.
	*
	* @param type the type
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f document
	* @throws it.ethica.esf.NoSuchDocumentException if a matching e s f document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFDocument findByT_U_Last(
		java.lang.String type, long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchDocumentException;

	/**
	* Returns the last e s f document in the ordered set where type = &#63; and esfUserId = &#63;.
	*
	* @param type the type
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f document, or <code>null</code> if a matching e s f document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFDocument fetchByT_U_Last(
		java.lang.String type, long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f documents before and after the current e s f document in the ordered set where type = &#63; and esfUserId = &#63;.
	*
	* @param esfDocumentId the primary key of the current e s f document
	* @param type the type
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f document
	* @throws it.ethica.esf.NoSuchDocumentException if a e s f document with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFDocument[] findByT_U_PrevAndNext(
		long esfDocumentId, java.lang.String type, long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchDocumentException;

	/**
	* Removes all the e s f documents where type = &#63; and esfUserId = &#63; from the database.
	*
	* @param type the type
	* @param esfUserId the esf user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByT_U(java.lang.String type, long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f documents where type = &#63; and esfUserId = &#63;.
	*
	* @param type the type
	* @param esfUserId the esf user ID
	* @return the number of matching e s f documents
	* @throws SystemException if a system exception occurred
	*/
	public int countByT_U(java.lang.String type, long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f documents where esfUserId = &#63; and expirationDate = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param expirationDate the expiration date
	* @return the matching e s f documents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFDocument> findByU_ED(
		long esfUserId, java.util.Date expirationDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f documents where esfUserId = &#63; and expirationDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfUserId the esf user ID
	* @param expirationDate the expiration date
	* @param start the lower bound of the range of e s f documents
	* @param end the upper bound of the range of e s f documents (not inclusive)
	* @return the range of matching e s f documents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFDocument> findByU_ED(
		long esfUserId, java.util.Date expirationDate, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f documents where esfUserId = &#63; and expirationDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfUserId the esf user ID
	* @param expirationDate the expiration date
	* @param start the lower bound of the range of e s f documents
	* @param end the upper bound of the range of e s f documents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f documents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFDocument> findByU_ED(
		long esfUserId, java.util.Date expirationDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f document in the ordered set where esfUserId = &#63; and expirationDate = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param expirationDate the expiration date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f document
	* @throws it.ethica.esf.NoSuchDocumentException if a matching e s f document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFDocument findByU_ED_First(long esfUserId,
		java.util.Date expirationDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchDocumentException;

	/**
	* Returns the first e s f document in the ordered set where esfUserId = &#63; and expirationDate = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param expirationDate the expiration date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f document, or <code>null</code> if a matching e s f document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFDocument fetchByU_ED_First(long esfUserId,
		java.util.Date expirationDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f document in the ordered set where esfUserId = &#63; and expirationDate = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param expirationDate the expiration date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f document
	* @throws it.ethica.esf.NoSuchDocumentException if a matching e s f document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFDocument findByU_ED_Last(long esfUserId,
		java.util.Date expirationDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchDocumentException;

	/**
	* Returns the last e s f document in the ordered set where esfUserId = &#63; and expirationDate = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param expirationDate the expiration date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f document, or <code>null</code> if a matching e s f document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFDocument fetchByU_ED_Last(long esfUserId,
		java.util.Date expirationDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f documents before and after the current e s f document in the ordered set where esfUserId = &#63; and expirationDate = &#63;.
	*
	* @param esfDocumentId the primary key of the current e s f document
	* @param esfUserId the esf user ID
	* @param expirationDate the expiration date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f document
	* @throws it.ethica.esf.NoSuchDocumentException if a e s f document with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFDocument[] findByU_ED_PrevAndNext(
		long esfDocumentId, long esfUserId, java.util.Date expirationDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchDocumentException;

	/**
	* Removes all the e s f documents where esfUserId = &#63; and expirationDate = &#63; from the database.
	*
	* @param esfUserId the esf user ID
	* @param expirationDate the expiration date
	* @throws SystemException if a system exception occurred
	*/
	public void removeByU_ED(long esfUserId, java.util.Date expirationDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f documents where esfUserId = &#63; and expirationDate = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param expirationDate the expiration date
	* @return the number of matching e s f documents
	* @throws SystemException if a system exception occurred
	*/
	public int countByU_ED(long esfUserId, java.util.Date expirationDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f documents where esfDocumentTypeId = &#63;.
	*
	* @param esfDocumentTypeId the esf document type ID
	* @return the matching e s f documents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFDocument> findByEsfDocumentTypeId(
		long esfDocumentTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f documents where esfDocumentTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfDocumentTypeId the esf document type ID
	* @param start the lower bound of the range of e s f documents
	* @param end the upper bound of the range of e s f documents (not inclusive)
	* @return the range of matching e s f documents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFDocument> findByEsfDocumentTypeId(
		long esfDocumentTypeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f documents where esfDocumentTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfDocumentTypeId the esf document type ID
	* @param start the lower bound of the range of e s f documents
	* @param end the upper bound of the range of e s f documents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f documents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFDocument> findByEsfDocumentTypeId(
		long esfDocumentTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f document in the ordered set where esfDocumentTypeId = &#63;.
	*
	* @param esfDocumentTypeId the esf document type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f document
	* @throws it.ethica.esf.NoSuchDocumentException if a matching e s f document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFDocument findByEsfDocumentTypeId_First(
		long esfDocumentTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchDocumentException;

	/**
	* Returns the first e s f document in the ordered set where esfDocumentTypeId = &#63;.
	*
	* @param esfDocumentTypeId the esf document type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f document, or <code>null</code> if a matching e s f document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFDocument fetchByEsfDocumentTypeId_First(
		long esfDocumentTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f document in the ordered set where esfDocumentTypeId = &#63;.
	*
	* @param esfDocumentTypeId the esf document type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f document
	* @throws it.ethica.esf.NoSuchDocumentException if a matching e s f document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFDocument findByEsfDocumentTypeId_Last(
		long esfDocumentTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchDocumentException;

	/**
	* Returns the last e s f document in the ordered set where esfDocumentTypeId = &#63;.
	*
	* @param esfDocumentTypeId the esf document type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f document, or <code>null</code> if a matching e s f document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFDocument fetchByEsfDocumentTypeId_Last(
		long esfDocumentTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f documents before and after the current e s f document in the ordered set where esfDocumentTypeId = &#63;.
	*
	* @param esfDocumentId the primary key of the current e s f document
	* @param esfDocumentTypeId the esf document type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f document
	* @throws it.ethica.esf.NoSuchDocumentException if a e s f document with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFDocument[] findByEsfDocumentTypeId_PrevAndNext(
		long esfDocumentId, long esfDocumentTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchDocumentException;

	/**
	* Removes all the e s f documents where esfDocumentTypeId = &#63; from the database.
	*
	* @param esfDocumentTypeId the esf document type ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByEsfDocumentTypeId(long esfDocumentTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f documents where esfDocumentTypeId = &#63;.
	*
	* @param esfDocumentTypeId the esf document type ID
	* @return the number of matching e s f documents
	* @throws SystemException if a system exception occurred
	*/
	public int countByEsfDocumentTypeId(long esfDocumentTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f documents where esfPublicAuthorityId = &#63;.
	*
	* @param esfPublicAuthorityId the esf public authority ID
	* @return the matching e s f documents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFDocument> findByEsfPublicAuthorityId(
		long esfPublicAuthorityId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f documents where esfPublicAuthorityId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfPublicAuthorityId the esf public authority ID
	* @param start the lower bound of the range of e s f documents
	* @param end the upper bound of the range of e s f documents (not inclusive)
	* @return the range of matching e s f documents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFDocument> findByEsfPublicAuthorityId(
		long esfPublicAuthorityId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f documents where esfPublicAuthorityId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfPublicAuthorityId the esf public authority ID
	* @param start the lower bound of the range of e s f documents
	* @param end the upper bound of the range of e s f documents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f documents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFDocument> findByEsfPublicAuthorityId(
		long esfPublicAuthorityId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f document in the ordered set where esfPublicAuthorityId = &#63;.
	*
	* @param esfPublicAuthorityId the esf public authority ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f document
	* @throws it.ethica.esf.NoSuchDocumentException if a matching e s f document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFDocument findByEsfPublicAuthorityId_First(
		long esfPublicAuthorityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchDocumentException;

	/**
	* Returns the first e s f document in the ordered set where esfPublicAuthorityId = &#63;.
	*
	* @param esfPublicAuthorityId the esf public authority ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f document, or <code>null</code> if a matching e s f document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFDocument fetchByEsfPublicAuthorityId_First(
		long esfPublicAuthorityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f document in the ordered set where esfPublicAuthorityId = &#63;.
	*
	* @param esfPublicAuthorityId the esf public authority ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f document
	* @throws it.ethica.esf.NoSuchDocumentException if a matching e s f document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFDocument findByEsfPublicAuthorityId_Last(
		long esfPublicAuthorityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchDocumentException;

	/**
	* Returns the last e s f document in the ordered set where esfPublicAuthorityId = &#63;.
	*
	* @param esfPublicAuthorityId the esf public authority ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f document, or <code>null</code> if a matching e s f document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFDocument fetchByEsfPublicAuthorityId_Last(
		long esfPublicAuthorityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f documents before and after the current e s f document in the ordered set where esfPublicAuthorityId = &#63;.
	*
	* @param esfDocumentId the primary key of the current e s f document
	* @param esfPublicAuthorityId the esf public authority ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f document
	* @throws it.ethica.esf.NoSuchDocumentException if a e s f document with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFDocument[] findByEsfPublicAuthorityId_PrevAndNext(
		long esfDocumentId, long esfPublicAuthorityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchDocumentException;

	/**
	* Removes all the e s f documents where esfPublicAuthorityId = &#63; from the database.
	*
	* @param esfPublicAuthorityId the esf public authority ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByEsfPublicAuthorityId(long esfPublicAuthorityId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f documents where esfPublicAuthorityId = &#63;.
	*
	* @param esfPublicAuthorityId the esf public authority ID
	* @return the number of matching e s f documents
	* @throws SystemException if a system exception occurred
	*/
	public int countByEsfPublicAuthorityId(long esfPublicAuthorityId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the e s f document in the entity cache if it is enabled.
	*
	* @param esfDocument the e s f document
	*/
	public void cacheResult(it.ethica.esf.model.ESFDocument esfDocument);

	/**
	* Caches the e s f documents in the entity cache if it is enabled.
	*
	* @param esfDocuments the e s f documents
	*/
	public void cacheResult(
		java.util.List<it.ethica.esf.model.ESFDocument> esfDocuments);

	/**
	* Creates a new e s f document with the primary key. Does not add the e s f document to the database.
	*
	* @param esfDocumentId the primary key for the new e s f document
	* @return the new e s f document
	*/
	public it.ethica.esf.model.ESFDocument create(long esfDocumentId);

	/**
	* Removes the e s f document with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfDocumentId the primary key of the e s f document
	* @return the e s f document that was removed
	* @throws it.ethica.esf.NoSuchDocumentException if a e s f document with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFDocument remove(long esfDocumentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchDocumentException;

	public it.ethica.esf.model.ESFDocument updateImpl(
		it.ethica.esf.model.ESFDocument esfDocument)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f document with the primary key or throws a {@link it.ethica.esf.NoSuchDocumentException} if it could not be found.
	*
	* @param esfDocumentId the primary key of the e s f document
	* @return the e s f document
	* @throws it.ethica.esf.NoSuchDocumentException if a e s f document with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFDocument findByPrimaryKey(long esfDocumentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchDocumentException;

	/**
	* Returns the e s f document with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param esfDocumentId the primary key of the e s f document
	* @return the e s f document, or <code>null</code> if a e s f document with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFDocument fetchByPrimaryKey(long esfDocumentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f documents.
	*
	* @return the e s f documents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFDocument> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f documents.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f documents
	* @param end the upper bound of the range of e s f documents (not inclusive)
	* @return the range of e s f documents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFDocument> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f documents.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f documents
	* @param end the upper bound of the range of e s f documents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of e s f documents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFDocument> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the e s f documents from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f documents.
	*
	* @return the number of e s f documents
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}