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

import it.ethica.esf.model.ESFPartecipantInfo;

/**
 * The persistence interface for the e s f partecipant info service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFPartecipantInfoPersistenceImpl
 * @see ESFPartecipantInfoUtil
 * @generated
 */
public interface ESFPartecipantInfoPersistence extends BasePersistence<ESFPartecipantInfo> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ESFPartecipantInfoUtil} to access the e s f partecipant info persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the e s f partecipant infos where firstName = &#63; and lastName = &#63; and protocol = &#63;.
	*
	* @param firstName the first name
	* @param lastName the last name
	* @param protocol the protocol
	* @return the matching e s f partecipant infos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFPartecipantInfo> findByFirstName_L_P(
		java.lang.String firstName, java.lang.String lastName, long protocol)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.ethica.esf.model.ESFPartecipantInfo> findByFirstName_L_P(
		java.lang.String firstName, java.lang.String lastName, long protocol,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.ethica.esf.model.ESFPartecipantInfo> findByFirstName_L_P(
		java.lang.String firstName, java.lang.String lastName, long protocol,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public it.ethica.esf.model.ESFPartecipantInfo findByFirstName_L_P_First(
		java.lang.String firstName, java.lang.String lastName, long protocol,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchPartecipantInfoException;

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
	public it.ethica.esf.model.ESFPartecipantInfo fetchByFirstName_L_P_First(
		java.lang.String firstName, java.lang.String lastName, long protocol,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public it.ethica.esf.model.ESFPartecipantInfo findByFirstName_L_P_Last(
		java.lang.String firstName, java.lang.String lastName, long protocol,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchPartecipantInfoException;

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
	public it.ethica.esf.model.ESFPartecipantInfo fetchByFirstName_L_P_Last(
		java.lang.String firstName, java.lang.String lastName, long protocol,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public it.ethica.esf.model.ESFPartecipantInfo[] findByFirstName_L_P_PrevAndNext(
		long esfPartecipantInfoId, java.lang.String firstName,
		java.lang.String lastName, long protocol,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchPartecipantInfoException;

	/**
	* Removes all the e s f partecipant infos where firstName = &#63; and lastName = &#63; and protocol = &#63; from the database.
	*
	* @param firstName the first name
	* @param lastName the last name
	* @param protocol the protocol
	* @throws SystemException if a system exception occurred
	*/
	public void removeByFirstName_L_P(java.lang.String firstName,
		java.lang.String lastName, long protocol)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f partecipant infos where firstName = &#63; and lastName = &#63; and protocol = &#63;.
	*
	* @param firstName the first name
	* @param lastName the last name
	* @param protocol the protocol
	* @return the number of matching e s f partecipant infos
	* @throws SystemException if a system exception occurred
	*/
	public int countByFirstName_L_P(java.lang.String firstName,
		java.lang.String lastName, long protocol)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the e s f partecipant info in the entity cache if it is enabled.
	*
	* @param esfPartecipantInfo the e s f partecipant info
	*/
	public void cacheResult(
		it.ethica.esf.model.ESFPartecipantInfo esfPartecipantInfo);

	/**
	* Caches the e s f partecipant infos in the entity cache if it is enabled.
	*
	* @param esfPartecipantInfos the e s f partecipant infos
	*/
	public void cacheResult(
		java.util.List<it.ethica.esf.model.ESFPartecipantInfo> esfPartecipantInfos);

	/**
	* Creates a new e s f partecipant info with the primary key. Does not add the e s f partecipant info to the database.
	*
	* @param esfPartecipantInfoId the primary key for the new e s f partecipant info
	* @return the new e s f partecipant info
	*/
	public it.ethica.esf.model.ESFPartecipantInfo create(
		long esfPartecipantInfoId);

	/**
	* Removes the e s f partecipant info with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfPartecipantInfoId the primary key of the e s f partecipant info
	* @return the e s f partecipant info that was removed
	* @throws it.ethica.esf.NoSuchPartecipantInfoException if a e s f partecipant info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFPartecipantInfo remove(
		long esfPartecipantInfoId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchPartecipantInfoException;

	public it.ethica.esf.model.ESFPartecipantInfo updateImpl(
		it.ethica.esf.model.ESFPartecipantInfo esfPartecipantInfo)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f partecipant info with the primary key or throws a {@link it.ethica.esf.NoSuchPartecipantInfoException} if it could not be found.
	*
	* @param esfPartecipantInfoId the primary key of the e s f partecipant info
	* @return the e s f partecipant info
	* @throws it.ethica.esf.NoSuchPartecipantInfoException if a e s f partecipant info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFPartecipantInfo findByPrimaryKey(
		long esfPartecipantInfoId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchPartecipantInfoException;

	/**
	* Returns the e s f partecipant info with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param esfPartecipantInfoId the primary key of the e s f partecipant info
	* @return the e s f partecipant info, or <code>null</code> if a e s f partecipant info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFPartecipantInfo fetchByPrimaryKey(
		long esfPartecipantInfoId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f partecipant infos.
	*
	* @return the e s f partecipant infos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFPartecipantInfo> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.ethica.esf.model.ESFPartecipantInfo> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.ethica.esf.model.ESFPartecipantInfo> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the e s f partecipant infos from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f partecipant infos.
	*
	* @return the number of e s f partecipant infos
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}