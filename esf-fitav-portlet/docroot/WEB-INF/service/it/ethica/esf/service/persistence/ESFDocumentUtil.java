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

import it.ethica.esf.model.ESFDocument;

import java.util.List;

/**
 * The persistence utility for the e s f document service. This utility wraps {@link ESFDocumentPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFDocumentPersistence
 * @see ESFDocumentPersistenceImpl
 * @generated
 */
public class ESFDocumentUtil {
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
	public static void clearCache(ESFDocument esfDocument) {
		getPersistence().clearCache(esfDocument);
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
	public static List<ESFDocument> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ESFDocument> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ESFDocument> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ESFDocument update(ESFDocument esfDocument)
		throws SystemException {
		return getPersistence().update(esfDocument);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ESFDocument update(ESFDocument esfDocument,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(esfDocument, serviceContext);
	}

	/**
	* Returns all the e s f documents where code = &#63;.
	*
	* @param code the code
	* @return the matching e s f documents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFDocument> findByCode(
		java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCode(code);
	}

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
	public static java.util.List<it.ethica.esf.model.ESFDocument> findByCode(
		java.lang.String code, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCode(code, start, end);
	}

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
	public static java.util.List<it.ethica.esf.model.ESFDocument> findByCode(
		java.lang.String code, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCode(code, start, end, orderByComparator);
	}

	/**
	* Returns the first e s f document in the ordered set where code = &#63;.
	*
	* @param code the code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f document
	* @throws it.ethica.esf.NoSuchDocumentException if a matching e s f document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFDocument findByCode_First(
		java.lang.String code,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchDocumentException {
		return getPersistence().findByCode_First(code, orderByComparator);
	}

	/**
	* Returns the first e s f document in the ordered set where code = &#63;.
	*
	* @param code the code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f document, or <code>null</code> if a matching e s f document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFDocument fetchByCode_First(
		java.lang.String code,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCode_First(code, orderByComparator);
	}

	/**
	* Returns the last e s f document in the ordered set where code = &#63;.
	*
	* @param code the code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f document
	* @throws it.ethica.esf.NoSuchDocumentException if a matching e s f document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFDocument findByCode_Last(
		java.lang.String code,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchDocumentException {
		return getPersistence().findByCode_Last(code, orderByComparator);
	}

	/**
	* Returns the last e s f document in the ordered set where code = &#63;.
	*
	* @param code the code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f document, or <code>null</code> if a matching e s f document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFDocument fetchByCode_Last(
		java.lang.String code,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCode_Last(code, orderByComparator);
	}

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
	public static it.ethica.esf.model.ESFDocument[] findByCode_PrevAndNext(
		long esfDocumentId, java.lang.String code,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchDocumentException {
		return getPersistence()
				   .findByCode_PrevAndNext(esfDocumentId, code,
			orderByComparator);
	}

	/**
	* Removes all the e s f documents where code = &#63; from the database.
	*
	* @param code the code
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCode(java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCode(code);
	}

	/**
	* Returns the number of e s f documents where code = &#63;.
	*
	* @param code the code
	* @return the number of matching e s f documents
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCode(java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCode(code);
	}

	/**
	* Returns all the e s f documents where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @return the matching e s f documents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFDocument> findByesfUserId(
		long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByesfUserId(esfUserId);
	}

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
	public static java.util.List<it.ethica.esf.model.ESFDocument> findByesfUserId(
		long esfUserId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByesfUserId(esfUserId, start, end);
	}

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
	public static java.util.List<it.ethica.esf.model.ESFDocument> findByesfUserId(
		long esfUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByesfUserId(esfUserId, start, end, orderByComparator);
	}

	/**
	* Returns the first e s f document in the ordered set where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f document
	* @throws it.ethica.esf.NoSuchDocumentException if a matching e s f document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFDocument findByesfUserId_First(
		long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchDocumentException {
		return getPersistence()
				   .findByesfUserId_First(esfUserId, orderByComparator);
	}

	/**
	* Returns the first e s f document in the ordered set where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f document, or <code>null</code> if a matching e s f document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFDocument fetchByesfUserId_First(
		long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByesfUserId_First(esfUserId, orderByComparator);
	}

	/**
	* Returns the last e s f document in the ordered set where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f document
	* @throws it.ethica.esf.NoSuchDocumentException if a matching e s f document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFDocument findByesfUserId_Last(
		long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchDocumentException {
		return getPersistence()
				   .findByesfUserId_Last(esfUserId, orderByComparator);
	}

	/**
	* Returns the last e s f document in the ordered set where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f document, or <code>null</code> if a matching e s f document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFDocument fetchByesfUserId_Last(
		long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByesfUserId_Last(esfUserId, orderByComparator);
	}

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
	public static it.ethica.esf.model.ESFDocument[] findByesfUserId_PrevAndNext(
		long esfDocumentId, long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchDocumentException {
		return getPersistence()
				   .findByesfUserId_PrevAndNext(esfDocumentId, esfUserId,
			orderByComparator);
	}

	/**
	* Removes all the e s f documents where esfUserId = &#63; from the database.
	*
	* @param esfUserId the esf user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByesfUserId(long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByesfUserId(esfUserId);
	}

	/**
	* Returns the number of e s f documents where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @return the number of matching e s f documents
	* @throws SystemException if a system exception occurred
	*/
	public static int countByesfUserId(long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByesfUserId(esfUserId);
	}

	/**
	* Returns all the e s f documents where type = &#63; and esfUserId = &#63;.
	*
	* @param type the type
	* @param esfUserId the esf user ID
	* @return the matching e s f documents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFDocument> findByT_U(
		java.lang.String type, long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByT_U(type, esfUserId);
	}

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
	public static java.util.List<it.ethica.esf.model.ESFDocument> findByT_U(
		java.lang.String type, long esfUserId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByT_U(type, esfUserId, start, end);
	}

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
	public static java.util.List<it.ethica.esf.model.ESFDocument> findByT_U(
		java.lang.String type, long esfUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByT_U(type, esfUserId, start, end, orderByComparator);
	}

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
	public static it.ethica.esf.model.ESFDocument findByT_U_First(
		java.lang.String type, long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchDocumentException {
		return getPersistence()
				   .findByT_U_First(type, esfUserId, orderByComparator);
	}

	/**
	* Returns the first e s f document in the ordered set where type = &#63; and esfUserId = &#63;.
	*
	* @param type the type
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f document, or <code>null</code> if a matching e s f document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFDocument fetchByT_U_First(
		java.lang.String type, long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByT_U_First(type, esfUserId, orderByComparator);
	}

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
	public static it.ethica.esf.model.ESFDocument findByT_U_Last(
		java.lang.String type, long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchDocumentException {
		return getPersistence()
				   .findByT_U_Last(type, esfUserId, orderByComparator);
	}

	/**
	* Returns the last e s f document in the ordered set where type = &#63; and esfUserId = &#63;.
	*
	* @param type the type
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f document, or <code>null</code> if a matching e s f document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFDocument fetchByT_U_Last(
		java.lang.String type, long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByT_U_Last(type, esfUserId, orderByComparator);
	}

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
	public static it.ethica.esf.model.ESFDocument[] findByT_U_PrevAndNext(
		long esfDocumentId, java.lang.String type, long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchDocumentException {
		return getPersistence()
				   .findByT_U_PrevAndNext(esfDocumentId, type, esfUserId,
			orderByComparator);
	}

	/**
	* Removes all the e s f documents where type = &#63; and esfUserId = &#63; from the database.
	*
	* @param type the type
	* @param esfUserId the esf user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByT_U(java.lang.String type, long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByT_U(type, esfUserId);
	}

	/**
	* Returns the number of e s f documents where type = &#63; and esfUserId = &#63;.
	*
	* @param type the type
	* @param esfUserId the esf user ID
	* @return the number of matching e s f documents
	* @throws SystemException if a system exception occurred
	*/
	public static int countByT_U(java.lang.String type, long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByT_U(type, esfUserId);
	}

	/**
	* Returns all the e s f documents where esfUserId = &#63; and expirationDate = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param expirationDate the expiration date
	* @return the matching e s f documents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFDocument> findByU_ED(
		long esfUserId, java.util.Date expirationDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByU_ED(esfUserId, expirationDate);
	}

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
	public static java.util.List<it.ethica.esf.model.ESFDocument> findByU_ED(
		long esfUserId, java.util.Date expirationDate, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByU_ED(esfUserId, expirationDate, start, end);
	}

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
	public static java.util.List<it.ethica.esf.model.ESFDocument> findByU_ED(
		long esfUserId, java.util.Date expirationDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByU_ED(esfUserId, expirationDate, start, end,
			orderByComparator);
	}

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
	public static it.ethica.esf.model.ESFDocument findByU_ED_First(
		long esfUserId, java.util.Date expirationDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchDocumentException {
		return getPersistence()
				   .findByU_ED_First(esfUserId, expirationDate,
			orderByComparator);
	}

	/**
	* Returns the first e s f document in the ordered set where esfUserId = &#63; and expirationDate = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param expirationDate the expiration date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f document, or <code>null</code> if a matching e s f document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFDocument fetchByU_ED_First(
		long esfUserId, java.util.Date expirationDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByU_ED_First(esfUserId, expirationDate,
			orderByComparator);
	}

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
	public static it.ethica.esf.model.ESFDocument findByU_ED_Last(
		long esfUserId, java.util.Date expirationDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchDocumentException {
		return getPersistence()
				   .findByU_ED_Last(esfUserId, expirationDate, orderByComparator);
	}

	/**
	* Returns the last e s f document in the ordered set where esfUserId = &#63; and expirationDate = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param expirationDate the expiration date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f document, or <code>null</code> if a matching e s f document could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFDocument fetchByU_ED_Last(
		long esfUserId, java.util.Date expirationDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByU_ED_Last(esfUserId, expirationDate,
			orderByComparator);
	}

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
	public static it.ethica.esf.model.ESFDocument[] findByU_ED_PrevAndNext(
		long esfDocumentId, long esfUserId, java.util.Date expirationDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchDocumentException {
		return getPersistence()
				   .findByU_ED_PrevAndNext(esfDocumentId, esfUserId,
			expirationDate, orderByComparator);
	}

	/**
	* Removes all the e s f documents where esfUserId = &#63; and expirationDate = &#63; from the database.
	*
	* @param esfUserId the esf user ID
	* @param expirationDate the expiration date
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByU_ED(long esfUserId,
		java.util.Date expirationDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByU_ED(esfUserId, expirationDate);
	}

	/**
	* Returns the number of e s f documents where esfUserId = &#63; and expirationDate = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param expirationDate the expiration date
	* @return the number of matching e s f documents
	* @throws SystemException if a system exception occurred
	*/
	public static int countByU_ED(long esfUserId, java.util.Date expirationDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByU_ED(esfUserId, expirationDate);
	}

	/**
	* Caches the e s f document in the entity cache if it is enabled.
	*
	* @param esfDocument the e s f document
	*/
	public static void cacheResult(it.ethica.esf.model.ESFDocument esfDocument) {
		getPersistence().cacheResult(esfDocument);
	}

	/**
	* Caches the e s f documents in the entity cache if it is enabled.
	*
	* @param esfDocuments the e s f documents
	*/
	public static void cacheResult(
		java.util.List<it.ethica.esf.model.ESFDocument> esfDocuments) {
		getPersistence().cacheResult(esfDocuments);
	}

	/**
	* Creates a new e s f document with the primary key. Does not add the e s f document to the database.
	*
	* @param esfDocumentId the primary key for the new e s f document
	* @return the new e s f document
	*/
	public static it.ethica.esf.model.ESFDocument create(long esfDocumentId) {
		return getPersistence().create(esfDocumentId);
	}

	/**
	* Removes the e s f document with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfDocumentId the primary key of the e s f document
	* @return the e s f document that was removed
	* @throws it.ethica.esf.NoSuchDocumentException if a e s f document with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFDocument remove(long esfDocumentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchDocumentException {
		return getPersistence().remove(esfDocumentId);
	}

	public static it.ethica.esf.model.ESFDocument updateImpl(
		it.ethica.esf.model.ESFDocument esfDocument)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(esfDocument);
	}

	/**
	* Returns the e s f document with the primary key or throws a {@link it.ethica.esf.NoSuchDocumentException} if it could not be found.
	*
	* @param esfDocumentId the primary key of the e s f document
	* @return the e s f document
	* @throws it.ethica.esf.NoSuchDocumentException if a e s f document with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFDocument findByPrimaryKey(
		long esfDocumentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchDocumentException {
		return getPersistence().findByPrimaryKey(esfDocumentId);
	}

	/**
	* Returns the e s f document with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param esfDocumentId the primary key of the e s f document
	* @return the e s f document, or <code>null</code> if a e s f document with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFDocument fetchByPrimaryKey(
		long esfDocumentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(esfDocumentId);
	}

	/**
	* Returns all the e s f documents.
	*
	* @return the e s f documents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFDocument> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<it.ethica.esf.model.ESFDocument> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<it.ethica.esf.model.ESFDocument> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the e s f documents from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of e s f documents.
	*
	* @return the number of e s f documents
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ESFDocumentPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ESFDocumentPersistence)PortletBeanLocatorUtil.locate(it.ethica.esf.service.ClpSerializer.getServletContextName(),
					ESFDocumentPersistence.class.getName());

			ReferenceRegistry.registerReference(ESFDocumentUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ESFDocumentPersistence persistence) {
	}

	private static ESFDocumentPersistence _persistence;
}