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

import it.ethica.esf.model.ESFPartecipantInfo;

import java.util.List;

/**
 * The persistence utility for the e s f partecipant info service. This utility wraps {@link ESFPartecipantInfoPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFPartecipantInfoPersistence
 * @see ESFPartecipantInfoPersistenceImpl
 * @generated
 */
public class ESFPartecipantInfoUtil {
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
	public static void clearCache(ESFPartecipantInfo esfPartecipantInfo) {
		getPersistence().clearCache(esfPartecipantInfo);
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
	public static List<ESFPartecipantInfo> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ESFPartecipantInfo> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ESFPartecipantInfo> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ESFPartecipantInfo update(
		ESFPartecipantInfo esfPartecipantInfo) throws SystemException {
		return getPersistence().update(esfPartecipantInfo);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ESFPartecipantInfo update(
		ESFPartecipantInfo esfPartecipantInfo, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(esfPartecipantInfo, serviceContext);
	}

	/**
	* Returns all the e s f partecipant infos where firstName = &#63; and lastName = &#63; and protocol = &#63;.
	*
	* @param firstName the first name
	* @param lastName the last name
	* @param protocol the protocol
	* @return the matching e s f partecipant infos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFPartecipantInfo> findByFirstName_L_P(
		java.lang.String firstName, java.lang.String lastName, long protocol)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByFirstName_L_P(firstName, lastName, protocol);
	}

	/**
	* Returns a range of all the e s f partecipant infos where firstName = &#63; and lastName = &#63; and protocol = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFPartecipantInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param firstName the first name
	* @param lastName the last name
	* @param protocol the protocol
	* @param start the lower bound of the range of e s f partecipant infos
	* @param end the upper bound of the range of e s f partecipant infos (not inclusive)
	* @return the range of matching e s f partecipant infos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFPartecipantInfo> findByFirstName_L_P(
		java.lang.String firstName, java.lang.String lastName, long protocol,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByFirstName_L_P(firstName, lastName, protocol, start,
			end);
	}

	/**
	* Returns an ordered range of all the e s f partecipant infos where firstName = &#63; and lastName = &#63; and protocol = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFPartecipantInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param firstName the first name
	* @param lastName the last name
	* @param protocol the protocol
	* @param start the lower bound of the range of e s f partecipant infos
	* @param end the upper bound of the range of e s f partecipant infos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f partecipant infos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFPartecipantInfo> findByFirstName_L_P(
		java.lang.String firstName, java.lang.String lastName, long protocol,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByFirstName_L_P(firstName, lastName, protocol, start,
			end, orderByComparator);
	}

	/**
	* Returns the first e s f partecipant info in the ordered set where firstName = &#63; and lastName = &#63; and protocol = &#63;.
	*
	* @param firstName the first name
	* @param lastName the last name
	* @param protocol the protocol
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f partecipant info
	* @throws it.ethica.esf.NoSuchPartecipantInfoException if a matching e s f partecipant info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFPartecipantInfo findByFirstName_L_P_First(
		java.lang.String firstName, java.lang.String lastName, long protocol,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchPartecipantInfoException {
		return getPersistence()
				   .findByFirstName_L_P_First(firstName, lastName, protocol,
			orderByComparator);
	}

	/**
	* Returns the first e s f partecipant info in the ordered set where firstName = &#63; and lastName = &#63; and protocol = &#63;.
	*
	* @param firstName the first name
	* @param lastName the last name
	* @param protocol the protocol
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f partecipant info, or <code>null</code> if a matching e s f partecipant info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFPartecipantInfo fetchByFirstName_L_P_First(
		java.lang.String firstName, java.lang.String lastName, long protocol,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByFirstName_L_P_First(firstName, lastName, protocol,
			orderByComparator);
	}

	/**
	* Returns the last e s f partecipant info in the ordered set where firstName = &#63; and lastName = &#63; and protocol = &#63;.
	*
	* @param firstName the first name
	* @param lastName the last name
	* @param protocol the protocol
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f partecipant info
	* @throws it.ethica.esf.NoSuchPartecipantInfoException if a matching e s f partecipant info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFPartecipantInfo findByFirstName_L_P_Last(
		java.lang.String firstName, java.lang.String lastName, long protocol,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchPartecipantInfoException {
		return getPersistence()
				   .findByFirstName_L_P_Last(firstName, lastName, protocol,
			orderByComparator);
	}

	/**
	* Returns the last e s f partecipant info in the ordered set where firstName = &#63; and lastName = &#63; and protocol = &#63;.
	*
	* @param firstName the first name
	* @param lastName the last name
	* @param protocol the protocol
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f partecipant info, or <code>null</code> if a matching e s f partecipant info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFPartecipantInfo fetchByFirstName_L_P_Last(
		java.lang.String firstName, java.lang.String lastName, long protocol,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByFirstName_L_P_Last(firstName, lastName, protocol,
			orderByComparator);
	}

	/**
	* Returns the e s f partecipant infos before and after the current e s f partecipant info in the ordered set where firstName = &#63; and lastName = &#63; and protocol = &#63;.
	*
	* @param esfPartecipantInfoId the primary key of the current e s f partecipant info
	* @param firstName the first name
	* @param lastName the last name
	* @param protocol the protocol
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f partecipant info
	* @throws it.ethica.esf.NoSuchPartecipantInfoException if a e s f partecipant info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFPartecipantInfo[] findByFirstName_L_P_PrevAndNext(
		long esfPartecipantInfoId, java.lang.String firstName,
		java.lang.String lastName, long protocol,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchPartecipantInfoException {
		return getPersistence()
				   .findByFirstName_L_P_PrevAndNext(esfPartecipantInfoId,
			firstName, lastName, protocol, orderByComparator);
	}

	/**
	* Removes all the e s f partecipant infos where firstName = &#63; and lastName = &#63; and protocol = &#63; from the database.
	*
	* @param firstName the first name
	* @param lastName the last name
	* @param protocol the protocol
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByFirstName_L_P(java.lang.String firstName,
		java.lang.String lastName, long protocol)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByFirstName_L_P(firstName, lastName, protocol);
	}

	/**
	* Returns the number of e s f partecipant infos where firstName = &#63; and lastName = &#63; and protocol = &#63;.
	*
	* @param firstName the first name
	* @param lastName the last name
	* @param protocol the protocol
	* @return the number of matching e s f partecipant infos
	* @throws SystemException if a system exception occurred
	*/
	public static int countByFirstName_L_P(java.lang.String firstName,
		java.lang.String lastName, long protocol)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByFirstName_L_P(firstName, lastName, protocol);
	}

	/**
	* Caches the e s f partecipant info in the entity cache if it is enabled.
	*
	* @param esfPartecipantInfo the e s f partecipant info
	*/
	public static void cacheResult(
		it.ethica.esf.model.ESFPartecipantInfo esfPartecipantInfo) {
		getPersistence().cacheResult(esfPartecipantInfo);
	}

	/**
	* Caches the e s f partecipant infos in the entity cache if it is enabled.
	*
	* @param esfPartecipantInfos the e s f partecipant infos
	*/
	public static void cacheResult(
		java.util.List<it.ethica.esf.model.ESFPartecipantInfo> esfPartecipantInfos) {
		getPersistence().cacheResult(esfPartecipantInfos);
	}

	/**
	* Creates a new e s f partecipant info with the primary key. Does not add the e s f partecipant info to the database.
	*
	* @param esfPartecipantInfoId the primary key for the new e s f partecipant info
	* @return the new e s f partecipant info
	*/
	public static it.ethica.esf.model.ESFPartecipantInfo create(
		long esfPartecipantInfoId) {
		return getPersistence().create(esfPartecipantInfoId);
	}

	/**
	* Removes the e s f partecipant info with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfPartecipantInfoId the primary key of the e s f partecipant info
	* @return the e s f partecipant info that was removed
	* @throws it.ethica.esf.NoSuchPartecipantInfoException if a e s f partecipant info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFPartecipantInfo remove(
		long esfPartecipantInfoId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchPartecipantInfoException {
		return getPersistence().remove(esfPartecipantInfoId);
	}

	public static it.ethica.esf.model.ESFPartecipantInfo updateImpl(
		it.ethica.esf.model.ESFPartecipantInfo esfPartecipantInfo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(esfPartecipantInfo);
	}

	/**
	* Returns the e s f partecipant info with the primary key or throws a {@link it.ethica.esf.NoSuchPartecipantInfoException} if it could not be found.
	*
	* @param esfPartecipantInfoId the primary key of the e s f partecipant info
	* @return the e s f partecipant info
	* @throws it.ethica.esf.NoSuchPartecipantInfoException if a e s f partecipant info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFPartecipantInfo findByPrimaryKey(
		long esfPartecipantInfoId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchPartecipantInfoException {
		return getPersistence().findByPrimaryKey(esfPartecipantInfoId);
	}

	/**
	* Returns the e s f partecipant info with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param esfPartecipantInfoId the primary key of the e s f partecipant info
	* @return the e s f partecipant info, or <code>null</code> if a e s f partecipant info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFPartecipantInfo fetchByPrimaryKey(
		long esfPartecipantInfoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(esfPartecipantInfoId);
	}

	/**
	* Returns all the e s f partecipant infos.
	*
	* @return the e s f partecipant infos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFPartecipantInfo> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the e s f partecipant infos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFPartecipantInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f partecipant infos
	* @param end the upper bound of the range of e s f partecipant infos (not inclusive)
	* @return the range of e s f partecipant infos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFPartecipantInfo> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the e s f partecipant infos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFPartecipantInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f partecipant infos
	* @param end the upper bound of the range of e s f partecipant infos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of e s f partecipant infos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFPartecipantInfo> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the e s f partecipant infos from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of e s f partecipant infos.
	*
	* @return the number of e s f partecipant infos
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ESFPartecipantInfoPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ESFPartecipantInfoPersistence)PortletBeanLocatorUtil.locate(it.ethica.esf.service.ClpSerializer.getServletContextName(),
					ESFPartecipantInfoPersistence.class.getName());

			ReferenceRegistry.registerReference(ESFPartecipantInfoUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ESFPartecipantInfoPersistence persistence) {
	}

	private static ESFPartecipantInfoPersistence _persistence;
}