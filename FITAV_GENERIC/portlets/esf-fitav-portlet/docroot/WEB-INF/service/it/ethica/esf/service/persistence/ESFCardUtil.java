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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import it.ethica.esf.model.ESFCard;

import java.util.List;

/**
 * The persistence utility for the e s f card service. This utility wraps {@link ESFCardPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFCardPersistence
 * @see ESFCardPersistenceImpl
 * @generated
 */
public class ESFCardUtil {
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
	public static void clearCache(ESFCard esfCard) {
		getPersistence().clearCache(esfCard);
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
	public static List<ESFCard> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ESFCard> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ESFCard> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ESFCard update(ESFCard esfCard) throws SystemException {
		return getPersistence().update(esfCard);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ESFCard update(ESFCard esfCard, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(esfCard, serviceContext);
	}

	/**
	* Returns all the e s f cards where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching e s f cards
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFCard> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the e s f cards where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFCardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of e s f cards
	* @param end the upper bound of the range of e s f cards (not inclusive)
	* @return the range of matching e s f cards
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFCard> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the e s f cards where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFCardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of e s f cards
	* @param end the upper bound of the range of e s f cards (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f cards
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFCard> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns the first e s f card in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f card
	* @throws it.ethica.esf.NoSuchCardException if a matching e s f card could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFCard findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchCardException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first e s f card in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f card, or <code>null</code> if a matching e s f card could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFCard fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last e s f card in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f card
	* @throws it.ethica.esf.NoSuchCardException if a matching e s f card could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFCard findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchCardException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last e s f card in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f card, or <code>null</code> if a matching e s f card could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFCard fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the e s f cards before and after the current e s f card in the ordered set where uuid = &#63;.
	*
	* @param esfCardId the primary key of the current e s f card
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f card
	* @throws it.ethica.esf.NoSuchCardException if a e s f card with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFCard[] findByUuid_PrevAndNext(
		long esfCardId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchCardException {
		return getPersistence()
				   .findByUuid_PrevAndNext(esfCardId, uuid, orderByComparator);
	}

	/**
	* Removes all the e s f cards where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of e s f cards where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching e s f cards
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the e s f card where uuid = &#63; and groupId = &#63; or throws a {@link it.ethica.esf.NoSuchCardException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching e s f card
	* @throws it.ethica.esf.NoSuchCardException if a matching e s f card could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFCard findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchCardException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the e s f card where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching e s f card, or <code>null</code> if a matching e s f card could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFCard fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the e s f card where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching e s f card, or <code>null</code> if a matching e s f card could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFCard fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the e s f card where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the e s f card that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFCard removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchCardException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of e s f cards where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching e s f cards
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the e s f cards where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching e s f cards
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFCard> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the e s f cards where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFCardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of e s f cards
	* @param end the upper bound of the range of e s f cards (not inclusive)
	* @return the range of matching e s f cards
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFCard> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the e s f cards where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFCardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of e s f cards
	* @param end the upper bound of the range of e s f cards (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f cards
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFCard> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first e s f card in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f card
	* @throws it.ethica.esf.NoSuchCardException if a matching e s f card could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFCard findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchCardException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first e s f card in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f card, or <code>null</code> if a matching e s f card could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFCard fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last e s f card in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f card
	* @throws it.ethica.esf.NoSuchCardException if a matching e s f card could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFCard findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchCardException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last e s f card in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f card, or <code>null</code> if a matching e s f card could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFCard fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the e s f cards before and after the current e s f card in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param esfCardId the primary key of the current e s f card
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f card
	* @throws it.ethica.esf.NoSuchCardException if a e s f card with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFCard[] findByUuid_C_PrevAndNext(
		long esfCardId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchCardException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(esfCardId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the e s f cards where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of e s f cards where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching e s f cards
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the e s f cards where codeAlfa = &#63;.
	*
	* @param codeAlfa the code alfa
	* @return the matching e s f cards
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFCard> findByCodeAlfa(
		java.lang.String codeAlfa)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCodeAlfa(codeAlfa);
	}

	/**
	* Returns a range of all the e s f cards where codeAlfa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFCardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param codeAlfa the code alfa
	* @param start the lower bound of the range of e s f cards
	* @param end the upper bound of the range of e s f cards (not inclusive)
	* @return the range of matching e s f cards
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFCard> findByCodeAlfa(
		java.lang.String codeAlfa, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCodeAlfa(codeAlfa, start, end);
	}

	/**
	* Returns an ordered range of all the e s f cards where codeAlfa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFCardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param codeAlfa the code alfa
	* @param start the lower bound of the range of e s f cards
	* @param end the upper bound of the range of e s f cards (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f cards
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFCard> findByCodeAlfa(
		java.lang.String codeAlfa, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCodeAlfa(codeAlfa, start, end, orderByComparator);
	}

	/**
	* Returns the first e s f card in the ordered set where codeAlfa = &#63;.
	*
	* @param codeAlfa the code alfa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f card
	* @throws it.ethica.esf.NoSuchCardException if a matching e s f card could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFCard findByCodeAlfa_First(
		java.lang.String codeAlfa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchCardException {
		return getPersistence().findByCodeAlfa_First(codeAlfa, orderByComparator);
	}

	/**
	* Returns the first e s f card in the ordered set where codeAlfa = &#63;.
	*
	* @param codeAlfa the code alfa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f card, or <code>null</code> if a matching e s f card could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFCard fetchByCodeAlfa_First(
		java.lang.String codeAlfa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCodeAlfa_First(codeAlfa, orderByComparator);
	}

	/**
	* Returns the last e s f card in the ordered set where codeAlfa = &#63;.
	*
	* @param codeAlfa the code alfa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f card
	* @throws it.ethica.esf.NoSuchCardException if a matching e s f card could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFCard findByCodeAlfa_Last(
		java.lang.String codeAlfa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchCardException {
		return getPersistence().findByCodeAlfa_Last(codeAlfa, orderByComparator);
	}

	/**
	* Returns the last e s f card in the ordered set where codeAlfa = &#63;.
	*
	* @param codeAlfa the code alfa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f card, or <code>null</code> if a matching e s f card could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFCard fetchByCodeAlfa_Last(
		java.lang.String codeAlfa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCodeAlfa_Last(codeAlfa, orderByComparator);
	}

	/**
	* Returns the e s f cards before and after the current e s f card in the ordered set where codeAlfa = &#63;.
	*
	* @param esfCardId the primary key of the current e s f card
	* @param codeAlfa the code alfa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f card
	* @throws it.ethica.esf.NoSuchCardException if a e s f card with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFCard[] findByCodeAlfa_PrevAndNext(
		long esfCardId, java.lang.String codeAlfa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchCardException {
		return getPersistence()
				   .findByCodeAlfa_PrevAndNext(esfCardId, codeAlfa,
			orderByComparator);
	}

	/**
	* Removes all the e s f cards where codeAlfa = &#63; from the database.
	*
	* @param codeAlfa the code alfa
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCodeAlfa(java.lang.String codeAlfa)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCodeAlfa(codeAlfa);
	}

	/**
	* Returns the number of e s f cards where codeAlfa = &#63;.
	*
	* @param codeAlfa the code alfa
	* @return the number of matching e s f cards
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCodeAlfa(java.lang.String codeAlfa)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCodeAlfa(codeAlfa);
	}

	/**
	* Returns all the e s f cards where code = &#63;.
	*
	* @param code the code
	* @return the matching e s f cards
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFCard> findByCode(
		java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCode(code);
	}

	/**
	* Returns a range of all the e s f cards where code = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFCardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param code the code
	* @param start the lower bound of the range of e s f cards
	* @param end the upper bound of the range of e s f cards (not inclusive)
	* @return the range of matching e s f cards
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFCard> findByCode(
		java.lang.String code, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCode(code, start, end);
	}

	/**
	* Returns an ordered range of all the e s f cards where code = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFCardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param code the code
	* @param start the lower bound of the range of e s f cards
	* @param end the upper bound of the range of e s f cards (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f cards
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFCard> findByCode(
		java.lang.String code, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCode(code, start, end, orderByComparator);
	}

	/**
	* Returns the first e s f card in the ordered set where code = &#63;.
	*
	* @param code the code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f card
	* @throws it.ethica.esf.NoSuchCardException if a matching e s f card could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFCard findByCode_First(
		java.lang.String code,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchCardException {
		return getPersistence().findByCode_First(code, orderByComparator);
	}

	/**
	* Returns the first e s f card in the ordered set where code = &#63;.
	*
	* @param code the code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f card, or <code>null</code> if a matching e s f card could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFCard fetchByCode_First(
		java.lang.String code,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCode_First(code, orderByComparator);
	}

	/**
	* Returns the last e s f card in the ordered set where code = &#63;.
	*
	* @param code the code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f card
	* @throws it.ethica.esf.NoSuchCardException if a matching e s f card could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFCard findByCode_Last(
		java.lang.String code,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchCardException {
		return getPersistence().findByCode_Last(code, orderByComparator);
	}

	/**
	* Returns the last e s f card in the ordered set where code = &#63;.
	*
	* @param code the code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f card, or <code>null</code> if a matching e s f card could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFCard fetchByCode_Last(
		java.lang.String code,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCode_Last(code, orderByComparator);
	}

	/**
	* Returns the e s f cards before and after the current e s f card in the ordered set where code = &#63;.
	*
	* @param esfCardId the primary key of the current e s f card
	* @param code the code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f card
	* @throws it.ethica.esf.NoSuchCardException if a e s f card with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFCard[] findByCode_PrevAndNext(
		long esfCardId, java.lang.String code,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchCardException {
		return getPersistence()
				   .findByCode_PrevAndNext(esfCardId, code, orderByComparator);
	}

	/**
	* Removes all the e s f cards where code = &#63; from the database.
	*
	* @param code the code
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCode(java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCode(code);
	}

	/**
	* Returns the number of e s f cards where code = &#63;.
	*
	* @param code the code
	* @return the number of matching e s f cards
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCode(java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCode(code);
	}

	/**
	* Returns all the e s f cards where esfOrganizationId = &#63;.
	*
	* @param esfOrganizationId the esf organization ID
	* @return the matching e s f cards
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFCard> findByOrganizationId(
		long esfOrganizationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByOrganizationId(esfOrganizationId);
	}

	/**
	* Returns a range of all the e s f cards where esfOrganizationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFCardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfOrganizationId the esf organization ID
	* @param start the lower bound of the range of e s f cards
	* @param end the upper bound of the range of e s f cards (not inclusive)
	* @return the range of matching e s f cards
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFCard> findByOrganizationId(
		long esfOrganizationId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOrganizationId(esfOrganizationId, start, end);
	}

	/**
	* Returns an ordered range of all the e s f cards where esfOrganizationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFCardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfOrganizationId the esf organization ID
	* @param start the lower bound of the range of e s f cards
	* @param end the upper bound of the range of e s f cards (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f cards
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFCard> findByOrganizationId(
		long esfOrganizationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOrganizationId(esfOrganizationId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first e s f card in the ordered set where esfOrganizationId = &#63;.
	*
	* @param esfOrganizationId the esf organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f card
	* @throws it.ethica.esf.NoSuchCardException if a matching e s f card could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFCard findByOrganizationId_First(
		long esfOrganizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchCardException {
		return getPersistence()
				   .findByOrganizationId_First(esfOrganizationId,
			orderByComparator);
	}

	/**
	* Returns the first e s f card in the ordered set where esfOrganizationId = &#63;.
	*
	* @param esfOrganizationId the esf organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f card, or <code>null</code> if a matching e s f card could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFCard fetchByOrganizationId_First(
		long esfOrganizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByOrganizationId_First(esfOrganizationId,
			orderByComparator);
	}

	/**
	* Returns the last e s f card in the ordered set where esfOrganizationId = &#63;.
	*
	* @param esfOrganizationId the esf organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f card
	* @throws it.ethica.esf.NoSuchCardException if a matching e s f card could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFCard findByOrganizationId_Last(
		long esfOrganizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchCardException {
		return getPersistence()
				   .findByOrganizationId_Last(esfOrganizationId,
			orderByComparator);
	}

	/**
	* Returns the last e s f card in the ordered set where esfOrganizationId = &#63;.
	*
	* @param esfOrganizationId the esf organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f card, or <code>null</code> if a matching e s f card could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFCard fetchByOrganizationId_Last(
		long esfOrganizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByOrganizationId_Last(esfOrganizationId,
			orderByComparator);
	}

	/**
	* Returns the e s f cards before and after the current e s f card in the ordered set where esfOrganizationId = &#63;.
	*
	* @param esfCardId the primary key of the current e s f card
	* @param esfOrganizationId the esf organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f card
	* @throws it.ethica.esf.NoSuchCardException if a e s f card with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFCard[] findByOrganizationId_PrevAndNext(
		long esfCardId, long esfOrganizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchCardException {
		return getPersistence()
				   .findByOrganizationId_PrevAndNext(esfCardId,
			esfOrganizationId, orderByComparator);
	}

	/**
	* Removes all the e s f cards where esfOrganizationId = &#63; from the database.
	*
	* @param esfOrganizationId the esf organization ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByOrganizationId(long esfOrganizationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByOrganizationId(esfOrganizationId);
	}

	/**
	* Returns the number of e s f cards where esfOrganizationId = &#63;.
	*
	* @param esfOrganizationId the esf organization ID
	* @return the number of matching e s f cards
	* @throws SystemException if a system exception occurred
	*/
	public static int countByOrganizationId(long esfOrganizationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByOrganizationId(esfOrganizationId);
	}

	/**
	* Returns all the e s f cards where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @return the matching e s f cards
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFCard> findByUserId(
		long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId(esfUserId);
	}

	/**
	* Returns a range of all the e s f cards where esfUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFCardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfUserId the esf user ID
	* @param start the lower bound of the range of e s f cards
	* @param end the upper bound of the range of e s f cards (not inclusive)
	* @return the range of matching e s f cards
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFCard> findByUserId(
		long esfUserId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId(esfUserId, start, end);
	}

	/**
	* Returns an ordered range of all the e s f cards where esfUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFCardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfUserId the esf user ID
	* @param start the lower bound of the range of e s f cards
	* @param end the upper bound of the range of e s f cards (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f cards
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFCard> findByUserId(
		long esfUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserId(esfUserId, start, end, orderByComparator);
	}

	/**
	* Returns the first e s f card in the ordered set where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f card
	* @throws it.ethica.esf.NoSuchCardException if a matching e s f card could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFCard findByUserId_First(
		long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchCardException {
		return getPersistence().findByUserId_First(esfUserId, orderByComparator);
	}

	/**
	* Returns the first e s f card in the ordered set where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f card, or <code>null</code> if a matching e s f card could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFCard fetchByUserId_First(
		long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUserId_First(esfUserId, orderByComparator);
	}

	/**
	* Returns the last e s f card in the ordered set where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f card
	* @throws it.ethica.esf.NoSuchCardException if a matching e s f card could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFCard findByUserId_Last(
		long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchCardException {
		return getPersistence().findByUserId_Last(esfUserId, orderByComparator);
	}

	/**
	* Returns the last e s f card in the ordered set where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f card, or <code>null</code> if a matching e s f card could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFCard fetchByUserId_Last(
		long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUserId_Last(esfUserId, orderByComparator);
	}

	/**
	* Returns the e s f cards before and after the current e s f card in the ordered set where esfUserId = &#63;.
	*
	* @param esfCardId the primary key of the current e s f card
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f card
	* @throws it.ethica.esf.NoSuchCardException if a e s f card with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFCard[] findByUserId_PrevAndNext(
		long esfCardId, long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchCardException {
		return getPersistence()
				   .findByUserId_PrevAndNext(esfCardId, esfUserId,
			orderByComparator);
	}

	/**
	* Removes all the e s f cards where esfUserId = &#63; from the database.
	*
	* @param esfUserId the esf user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUserId(long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUserId(esfUserId);
	}

	/**
	* Returns the number of e s f cards where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @return the number of matching e s f cards
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserId(long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUserId(esfUserId);
	}

	/**
	* Returns all the e s f cards where oldCode = &#63;.
	*
	* @param oldCode the old code
	* @return the matching e s f cards
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFCard> findByOldCode(
		java.lang.String oldCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByOldCode(oldCode);
	}

	/**
	* Returns a range of all the e s f cards where oldCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFCardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param oldCode the old code
	* @param start the lower bound of the range of e s f cards
	* @param end the upper bound of the range of e s f cards (not inclusive)
	* @return the range of matching e s f cards
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFCard> findByOldCode(
		java.lang.String oldCode, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByOldCode(oldCode, start, end);
	}

	/**
	* Returns an ordered range of all the e s f cards where oldCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFCardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param oldCode the old code
	* @param start the lower bound of the range of e s f cards
	* @param end the upper bound of the range of e s f cards (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f cards
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFCard> findByOldCode(
		java.lang.String oldCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOldCode(oldCode, start, end, orderByComparator);
	}

	/**
	* Returns the first e s f card in the ordered set where oldCode = &#63;.
	*
	* @param oldCode the old code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f card
	* @throws it.ethica.esf.NoSuchCardException if a matching e s f card could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFCard findByOldCode_First(
		java.lang.String oldCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchCardException {
		return getPersistence().findByOldCode_First(oldCode, orderByComparator);
	}

	/**
	* Returns the first e s f card in the ordered set where oldCode = &#63;.
	*
	* @param oldCode the old code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f card, or <code>null</code> if a matching e s f card could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFCard fetchByOldCode_First(
		java.lang.String oldCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByOldCode_First(oldCode, orderByComparator);
	}

	/**
	* Returns the last e s f card in the ordered set where oldCode = &#63;.
	*
	* @param oldCode the old code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f card
	* @throws it.ethica.esf.NoSuchCardException if a matching e s f card could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFCard findByOldCode_Last(
		java.lang.String oldCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchCardException {
		return getPersistence().findByOldCode_Last(oldCode, orderByComparator);
	}

	/**
	* Returns the last e s f card in the ordered set where oldCode = &#63;.
	*
	* @param oldCode the old code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f card, or <code>null</code> if a matching e s f card could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFCard fetchByOldCode_Last(
		java.lang.String oldCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByOldCode_Last(oldCode, orderByComparator);
	}

	/**
	* Returns the e s f cards before and after the current e s f card in the ordered set where oldCode = &#63;.
	*
	* @param esfCardId the primary key of the current e s f card
	* @param oldCode the old code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f card
	* @throws it.ethica.esf.NoSuchCardException if a e s f card with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFCard[] findByOldCode_PrevAndNext(
		long esfCardId, java.lang.String oldCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchCardException {
		return getPersistence()
				   .findByOldCode_PrevAndNext(esfCardId, oldCode,
			orderByComparator);
	}

	/**
	* Removes all the e s f cards where oldCode = &#63; from the database.
	*
	* @param oldCode the old code
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByOldCode(java.lang.String oldCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByOldCode(oldCode);
	}

	/**
	* Returns the number of e s f cards where oldCode = &#63;.
	*
	* @param oldCode the old code
	* @return the number of matching e s f cards
	* @throws SystemException if a system exception occurred
	*/
	public static int countByOldCode(java.lang.String oldCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByOldCode(oldCode);
	}

	/**
	* Returns all the e s f cards where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @return the matching e s f cards
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFCard> findByEsfUser(
		long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByEsfUser(esfUserId);
	}

	/**
	* Returns a range of all the e s f cards where esfUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFCardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfUserId the esf user ID
	* @param start the lower bound of the range of e s f cards
	* @param end the upper bound of the range of e s f cards (not inclusive)
	* @return the range of matching e s f cards
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFCard> findByEsfUser(
		long esfUserId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByEsfUser(esfUserId, start, end);
	}

	/**
	* Returns an ordered range of all the e s f cards where esfUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFCardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfUserId the esf user ID
	* @param start the lower bound of the range of e s f cards
	* @param end the upper bound of the range of e s f cards (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f cards
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFCard> findByEsfUser(
		long esfUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByEsfUser(esfUserId, start, end, orderByComparator);
	}

	/**
	* Returns the first e s f card in the ordered set where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f card
	* @throws it.ethica.esf.NoSuchCardException if a matching e s f card could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFCard findByEsfUser_First(
		long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchCardException {
		return getPersistence().findByEsfUser_First(esfUserId, orderByComparator);
	}

	/**
	* Returns the first e s f card in the ordered set where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f card, or <code>null</code> if a matching e s f card could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFCard fetchByEsfUser_First(
		long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByEsfUser_First(esfUserId, orderByComparator);
	}

	/**
	* Returns the last e s f card in the ordered set where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f card
	* @throws it.ethica.esf.NoSuchCardException if a matching e s f card could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFCard findByEsfUser_Last(
		long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchCardException {
		return getPersistence().findByEsfUser_Last(esfUserId, orderByComparator);
	}

	/**
	* Returns the last e s f card in the ordered set where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f card, or <code>null</code> if a matching e s f card could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFCard fetchByEsfUser_Last(
		long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByEsfUser_Last(esfUserId, orderByComparator);
	}

	/**
	* Returns the e s f cards before and after the current e s f card in the ordered set where esfUserId = &#63;.
	*
	* @param esfCardId the primary key of the current e s f card
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f card
	* @throws it.ethica.esf.NoSuchCardException if a e s f card with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFCard[] findByEsfUser_PrevAndNext(
		long esfCardId, long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchCardException {
		return getPersistence()
				   .findByEsfUser_PrevAndNext(esfCardId, esfUserId,
			orderByComparator);
	}

	/**
	* Removes all the e s f cards where esfUserId = &#63; from the database.
	*
	* @param esfUserId the esf user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByEsfUser(long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByEsfUser(esfUserId);
	}

	/**
	* Returns the number of e s f cards where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @return the number of matching e s f cards
	* @throws SystemException if a system exception occurred
	*/
	public static int countByEsfUser(long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByEsfUser(esfUserId);
	}

	/**
	* Caches the e s f card in the entity cache if it is enabled.
	*
	* @param esfCard the e s f card
	*/
	public static void cacheResult(it.ethica.esf.model.ESFCard esfCard) {
		getPersistence().cacheResult(esfCard);
	}

	/**
	* Caches the e s f cards in the entity cache if it is enabled.
	*
	* @param esfCards the e s f cards
	*/
	public static void cacheResult(
		java.util.List<it.ethica.esf.model.ESFCard> esfCards) {
		getPersistence().cacheResult(esfCards);
	}

	/**
	* Creates a new e s f card with the primary key. Does not add the e s f card to the database.
	*
	* @param esfCardId the primary key for the new e s f card
	* @return the new e s f card
	*/
	public static it.ethica.esf.model.ESFCard create(long esfCardId) {
		return getPersistence().create(esfCardId);
	}

	/**
	* Removes the e s f card with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfCardId the primary key of the e s f card
	* @return the e s f card that was removed
	* @throws it.ethica.esf.NoSuchCardException if a e s f card with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFCard remove(long esfCardId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchCardException {
		return getPersistence().remove(esfCardId);
	}

	public static it.ethica.esf.model.ESFCard updateImpl(
		it.ethica.esf.model.ESFCard esfCard)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(esfCard);
	}

	/**
	* Returns the e s f card with the primary key or throws a {@link it.ethica.esf.NoSuchCardException} if it could not be found.
	*
	* @param esfCardId the primary key of the e s f card
	* @return the e s f card
	* @throws it.ethica.esf.NoSuchCardException if a e s f card with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFCard findByPrimaryKey(long esfCardId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchCardException {
		return getPersistence().findByPrimaryKey(esfCardId);
	}

	/**
	* Returns the e s f card with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param esfCardId the primary key of the e s f card
	* @return the e s f card, or <code>null</code> if a e s f card with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFCard fetchByPrimaryKey(long esfCardId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(esfCardId);
	}

	/**
	* Returns all the e s f cards.
	*
	* @return the e s f cards
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFCard> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the e s f cards.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFCardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f cards
	* @param end the upper bound of the range of e s f cards (not inclusive)
	* @return the range of e s f cards
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFCard> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the e s f cards.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFCardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f cards
	* @param end the upper bound of the range of e s f cards (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of e s f cards
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFCard> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the e s f cards from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of e s f cards.
	*
	* @return the number of e s f cards
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ESFCardPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ESFCardPersistence)PortletBeanLocatorUtil.locate(it.ethica.esf.service.ClpSerializer.getServletContextName(),
					ESFCardPersistence.class.getName());

			ReferenceRegistry.registerReference(ESFCardUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ESFCardPersistence persistence) {
	}

	private static ESFCardPersistence _persistence;
}