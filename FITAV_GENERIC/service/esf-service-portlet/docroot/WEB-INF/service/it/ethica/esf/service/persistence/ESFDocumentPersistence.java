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
	* Returns all the e s f documents where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching e s f documents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFDocument> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f documents where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of e s f documents
	* @param end the upper bound of the range of e s f documents (not inclusive)
	* @return the range of matching e s f documents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFDocument> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f documents where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of e s f documents
	* @param end the upper bound of the range of e s f documents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f documents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFDocument> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f document in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f document
	* @throws it.ethica.esf.NoSuchDocumentException if a matching e s f document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFDocument findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchDocumentException;

	/**
	* Returns the first e s f document in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f document, or <code>null</code> if a matching e s f document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFDocument fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f document in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f document
	* @throws it.ethica.esf.NoSuchDocumentException if a matching e s f document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFDocument findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchDocumentException;

	/**
	* Returns the last e s f document in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f document, or <code>null</code> if a matching e s f document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFDocument fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f documents before and after the current e s f document in the ordered set where uuid = &#63;.
	*
	* @param esfDocumentId the primary key of the current e s f document
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f document
	* @throws it.ethica.esf.NoSuchDocumentException if a e s f document with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFDocument[] findByUuid_PrevAndNext(
		long esfDocumentId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchDocumentException;

	/**
	* Removes all the e s f documents where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f documents where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching e s f documents
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f document where uuid = &#63; and groupId = &#63; or throws a {@link it.ethica.esf.NoSuchDocumentException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching e s f document
	* @throws it.ethica.esf.NoSuchDocumentException if a matching e s f document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFDocument findByUUID_G(java.lang.String uuid,
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchDocumentException;

	/**
	* Returns the e s f document where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching e s f document, or <code>null</code> if a matching e s f document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFDocument fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f document where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching e s f document, or <code>null</code> if a matching e s f document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFDocument fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the e s f document where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the e s f document that was removed
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFDocument removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchDocumentException;

	/**
	* Returns the number of e s f documents where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching e s f documents
	* @throws SystemException if a system exception occurred
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f documents where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching e s f documents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFDocument> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f documents where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of e s f documents
	* @param end the upper bound of the range of e s f documents (not inclusive)
	* @return the range of matching e s f documents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFDocument> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f documents where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of e s f documents
	* @param end the upper bound of the range of e s f documents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f documents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFDocument> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f document in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f document
	* @throws it.ethica.esf.NoSuchDocumentException if a matching e s f document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFDocument findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchDocumentException;

	/**
	* Returns the first e s f document in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f document, or <code>null</code> if a matching e s f document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFDocument fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f document in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f document
	* @throws it.ethica.esf.NoSuchDocumentException if a matching e s f document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFDocument findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchDocumentException;

	/**
	* Returns the last e s f document in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f document, or <code>null</code> if a matching e s f document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFDocument fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f documents before and after the current e s f document in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param esfDocumentId the primary key of the current e s f document
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f document
	* @throws it.ethica.esf.NoSuchDocumentException if a e s f document with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFDocument[] findByUuid_C_PrevAndNext(
		long esfDocumentId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchDocumentException;

	/**
	* Removes all the e s f documents where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f documents where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching e s f documents
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f documents where issuer = &#63;.
	*
	* @param issuer the issuer
	* @return the matching e s f documents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFDocument> findByIssuer(
		java.lang.String issuer)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f documents where issuer = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param issuer the issuer
	* @param start the lower bound of the range of e s f documents
	* @param end the upper bound of the range of e s f documents (not inclusive)
	* @return the range of matching e s f documents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFDocument> findByIssuer(
		java.lang.String issuer, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f documents where issuer = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param issuer the issuer
	* @param start the lower bound of the range of e s f documents
	* @param end the upper bound of the range of e s f documents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f documents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFDocument> findByIssuer(
		java.lang.String issuer, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f document in the ordered set where issuer = &#63;.
	*
	* @param issuer the issuer
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f document
	* @throws it.ethica.esf.NoSuchDocumentException if a matching e s f document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFDocument findByIssuer_First(
		java.lang.String issuer,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchDocumentException;

	/**
	* Returns the first e s f document in the ordered set where issuer = &#63;.
	*
	* @param issuer the issuer
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f document, or <code>null</code> if a matching e s f document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFDocument fetchByIssuer_First(
		java.lang.String issuer,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f document in the ordered set where issuer = &#63;.
	*
	* @param issuer the issuer
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f document
	* @throws it.ethica.esf.NoSuchDocumentException if a matching e s f document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFDocument findByIssuer_Last(
		java.lang.String issuer,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchDocumentException;

	/**
	* Returns the last e s f document in the ordered set where issuer = &#63;.
	*
	* @param issuer the issuer
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f document, or <code>null</code> if a matching e s f document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFDocument fetchByIssuer_Last(
		java.lang.String issuer,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f documents before and after the current e s f document in the ordered set where issuer = &#63;.
	*
	* @param esfDocumentId the primary key of the current e s f document
	* @param issuer the issuer
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f document
	* @throws it.ethica.esf.NoSuchDocumentException if a e s f document with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFDocument[] findByIssuer_PrevAndNext(
		long esfDocumentId, java.lang.String issuer,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchDocumentException;

	/**
	* Removes all the e s f documents where issuer = &#63; from the database.
	*
	* @param issuer the issuer
	* @throws SystemException if a system exception occurred
	*/
	public void removeByIssuer(java.lang.String issuer)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f documents where issuer = &#63;.
	*
	* @param issuer the issuer
	* @return the number of matching e s f documents
	* @throws SystemException if a system exception occurred
	*/
	public int countByIssuer(java.lang.String issuer)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f documents where locationReference = &#63;.
	*
	* @param locationReference the location reference
	* @return the matching e s f documents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFDocument> findByLocationReference(
		java.lang.String locationReference)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f documents where locationReference = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param locationReference the location reference
	* @param start the lower bound of the range of e s f documents
	* @param end the upper bound of the range of e s f documents (not inclusive)
	* @return the range of matching e s f documents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFDocument> findByLocationReference(
		java.lang.String locationReference, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f documents where locationReference = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param locationReference the location reference
	* @param start the lower bound of the range of e s f documents
	* @param end the upper bound of the range of e s f documents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f documents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFDocument> findByLocationReference(
		java.lang.String locationReference, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f document in the ordered set where locationReference = &#63;.
	*
	* @param locationReference the location reference
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f document
	* @throws it.ethica.esf.NoSuchDocumentException if a matching e s f document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFDocument findByLocationReference_First(
		java.lang.String locationReference,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchDocumentException;

	/**
	* Returns the first e s f document in the ordered set where locationReference = &#63;.
	*
	* @param locationReference the location reference
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f document, or <code>null</code> if a matching e s f document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFDocument fetchByLocationReference_First(
		java.lang.String locationReference,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f document in the ordered set where locationReference = &#63;.
	*
	* @param locationReference the location reference
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f document
	* @throws it.ethica.esf.NoSuchDocumentException if a matching e s f document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFDocument findByLocationReference_Last(
		java.lang.String locationReference,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchDocumentException;

	/**
	* Returns the last e s f document in the ordered set where locationReference = &#63;.
	*
	* @param locationReference the location reference
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f document, or <code>null</code> if a matching e s f document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFDocument fetchByLocationReference_Last(
		java.lang.String locationReference,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f documents before and after the current e s f document in the ordered set where locationReference = &#63;.
	*
	* @param esfDocumentId the primary key of the current e s f document
	* @param locationReference the location reference
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f document
	* @throws it.ethica.esf.NoSuchDocumentException if a e s f document with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFDocument[] findByLocationReference_PrevAndNext(
		long esfDocumentId, java.lang.String locationReference,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchDocumentException;

	/**
	* Removes all the e s f documents where locationReference = &#63; from the database.
	*
	* @param locationReference the location reference
	* @throws SystemException if a system exception occurred
	*/
	public void removeByLocationReference(java.lang.String locationReference)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f documents where locationReference = &#63;.
	*
	* @param locationReference the location reference
	* @return the number of matching e s f documents
	* @throws SystemException if a system exception occurred
	*/
	public int countByLocationReference(java.lang.String locationReference)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f documents where name = &#63;.
	*
	* @param name the name
	* @return the matching e s f documents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFDocument> findByName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f documents where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param name the name
	* @param start the lower bound of the range of e s f documents
	* @param end the upper bound of the range of e s f documents (not inclusive)
	* @return the range of matching e s f documents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFDocument> findByName(
		java.lang.String name, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f documents where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param name the name
	* @param start the lower bound of the range of e s f documents
	* @param end the upper bound of the range of e s f documents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f documents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFDocument> findByName(
		java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f document in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f document
	* @throws it.ethica.esf.NoSuchDocumentException if a matching e s f document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFDocument findByName_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchDocumentException;

	/**
	* Returns the first e s f document in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f document, or <code>null</code> if a matching e s f document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFDocument fetchByName_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f document in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f document
	* @throws it.ethica.esf.NoSuchDocumentException if a matching e s f document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFDocument findByName_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchDocumentException;

	/**
	* Returns the last e s f document in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f document, or <code>null</code> if a matching e s f document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFDocument fetchByName_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f documents before and after the current e s f document in the ordered set where name = &#63;.
	*
	* @param esfDocumentId the primary key of the current e s f document
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f document
	* @throws it.ethica.esf.NoSuchDocumentException if a e s f document with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFDocument[] findByName_PrevAndNext(
		long esfDocumentId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchDocumentException;

	/**
	* Removes all the e s f documents where name = &#63; from the database.
	*
	* @param name the name
	* @throws SystemException if a system exception occurred
	*/
	public void removeByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f documents where name = &#63;.
	*
	* @param name the name
	* @return the number of matching e s f documents
	* @throws SystemException if a system exception occurred
	*/
	public int countByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f documents where number = &#63;.
	*
	* @param number the number
	* @return the matching e s f documents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFDocument> findByNumber(
		long number) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f documents where number = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param number the number
	* @param start the lower bound of the range of e s f documents
	* @param end the upper bound of the range of e s f documents (not inclusive)
	* @return the range of matching e s f documents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFDocument> findByNumber(
		long number, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f documents where number = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param number the number
	* @param start the lower bound of the range of e s f documents
	* @param end the upper bound of the range of e s f documents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f documents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFDocument> findByNumber(
		long number, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f document in the ordered set where number = &#63;.
	*
	* @param number the number
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f document
	* @throws it.ethica.esf.NoSuchDocumentException if a matching e s f document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFDocument findByNumber_First(long number,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchDocumentException;

	/**
	* Returns the first e s f document in the ordered set where number = &#63;.
	*
	* @param number the number
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f document, or <code>null</code> if a matching e s f document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFDocument fetchByNumber_First(long number,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f document in the ordered set where number = &#63;.
	*
	* @param number the number
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f document
	* @throws it.ethica.esf.NoSuchDocumentException if a matching e s f document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFDocument findByNumber_Last(long number,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchDocumentException;

	/**
	* Returns the last e s f document in the ordered set where number = &#63;.
	*
	* @param number the number
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f document, or <code>null</code> if a matching e s f document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFDocument fetchByNumber_Last(long number,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f documents before and after the current e s f document in the ordered set where number = &#63;.
	*
	* @param esfDocumentId the primary key of the current e s f document
	* @param number the number
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f document
	* @throws it.ethica.esf.NoSuchDocumentException if a e s f document with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFDocument[] findByNumber_PrevAndNext(
		long esfDocumentId, long number,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchDocumentException;

	/**
	* Removes all the e s f documents where number = &#63; from the database.
	*
	* @param number the number
	* @throws SystemException if a system exception occurred
	*/
	public void removeByNumber(long number)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f documents where number = &#63;.
	*
	* @param number the number
	* @return the number of matching e s f documents
	* @throws SystemException if a system exception occurred
	*/
	public int countByNumber(long number)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f documents where ownerId = &#63; and ownerType = &#63;.
	*
	* @param ownerId the owner ID
	* @param ownerType the owner type
	* @return the matching e s f documents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFDocument> findByO_O(
		long ownerId, java.lang.String ownerType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f documents where ownerId = &#63; and ownerType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param ownerId the owner ID
	* @param ownerType the owner type
	* @param start the lower bound of the range of e s f documents
	* @param end the upper bound of the range of e s f documents (not inclusive)
	* @return the range of matching e s f documents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFDocument> findByO_O(
		long ownerId, java.lang.String ownerType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f documents where ownerId = &#63; and ownerType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param ownerId the owner ID
	* @param ownerType the owner type
	* @param start the lower bound of the range of e s f documents
	* @param end the upper bound of the range of e s f documents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f documents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFDocument> findByO_O(
		long ownerId, java.lang.String ownerType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f document in the ordered set where ownerId = &#63; and ownerType = &#63;.
	*
	* @param ownerId the owner ID
	* @param ownerType the owner type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f document
	* @throws it.ethica.esf.NoSuchDocumentException if a matching e s f document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFDocument findByO_O_First(long ownerId,
		java.lang.String ownerType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchDocumentException;

	/**
	* Returns the first e s f document in the ordered set where ownerId = &#63; and ownerType = &#63;.
	*
	* @param ownerId the owner ID
	* @param ownerType the owner type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f document, or <code>null</code> if a matching e s f document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFDocument fetchByO_O_First(long ownerId,
		java.lang.String ownerType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f document in the ordered set where ownerId = &#63; and ownerType = &#63;.
	*
	* @param ownerId the owner ID
	* @param ownerType the owner type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f document
	* @throws it.ethica.esf.NoSuchDocumentException if a matching e s f document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFDocument findByO_O_Last(long ownerId,
		java.lang.String ownerType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchDocumentException;

	/**
	* Returns the last e s f document in the ordered set where ownerId = &#63; and ownerType = &#63;.
	*
	* @param ownerId the owner ID
	* @param ownerType the owner type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f document, or <code>null</code> if a matching e s f document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFDocument fetchByO_O_Last(long ownerId,
		java.lang.String ownerType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f documents before and after the current e s f document in the ordered set where ownerId = &#63; and ownerType = &#63;.
	*
	* @param esfDocumentId the primary key of the current e s f document
	* @param ownerId the owner ID
	* @param ownerType the owner type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f document
	* @throws it.ethica.esf.NoSuchDocumentException if a e s f document with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFDocument[] findByO_O_PrevAndNext(
		long esfDocumentId, long ownerId, java.lang.String ownerType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchDocumentException;

	/**
	* Removes all the e s f documents where ownerId = &#63; and ownerType = &#63; from the database.
	*
	* @param ownerId the owner ID
	* @param ownerType the owner type
	* @throws SystemException if a system exception occurred
	*/
	public void removeByO_O(long ownerId, java.lang.String ownerType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f documents where ownerId = &#63; and ownerType = &#63;.
	*
	* @param ownerId the owner ID
	* @param ownerType the owner type
	* @return the number of matching e s f documents
	* @throws SystemException if a system exception occurred
	*/
	public int countByO_O(long ownerId, java.lang.String ownerType)
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