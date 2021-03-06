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

import it.ethica.esf.model.ESFAnnualFreeCard;

/**
 * The persistence interface for the e s f annual free card service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFAnnualFreeCardPersistenceImpl
 * @see ESFAnnualFreeCardUtil
 * @generated
 */
public interface ESFAnnualFreeCardPersistence extends BasePersistence<ESFAnnualFreeCard> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ESFAnnualFreeCardUtil} to access the e s f annual free card persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the e s f annual free cards where code = &#63;.
	*
	* @param code the code
	* @return the matching e s f annual free cards
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFAnnualFreeCard> findBycode(
		java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f annual free cards where code = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFAnnualFreeCardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param code the code
	* @param start the lower bound of the range of e s f annual free cards
	* @param end the upper bound of the range of e s f annual free cards (not inclusive)
	* @return the range of matching e s f annual free cards
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFAnnualFreeCard> findBycode(
		java.lang.String code, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f annual free cards where code = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFAnnualFreeCardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param code the code
	* @param start the lower bound of the range of e s f annual free cards
	* @param end the upper bound of the range of e s f annual free cards (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f annual free cards
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFAnnualFreeCard> findBycode(
		java.lang.String code, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f annual free card in the ordered set where code = &#63;.
	*
	* @param code the code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f annual free card
	* @throws it.ethica.esf.NoSuchAnnualFreeCardException if a matching e s f annual free card could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFAnnualFreeCard findBycode_First(
		java.lang.String code,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchAnnualFreeCardException;

	/**
	* Returns the first e s f annual free card in the ordered set where code = &#63;.
	*
	* @param code the code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f annual free card, or <code>null</code> if a matching e s f annual free card could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFAnnualFreeCard fetchBycode_First(
		java.lang.String code,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f annual free card in the ordered set where code = &#63;.
	*
	* @param code the code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f annual free card
	* @throws it.ethica.esf.NoSuchAnnualFreeCardException if a matching e s f annual free card could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFAnnualFreeCard findBycode_Last(
		java.lang.String code,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchAnnualFreeCardException;

	/**
	* Returns the last e s f annual free card in the ordered set where code = &#63;.
	*
	* @param code the code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f annual free card, or <code>null</code> if a matching e s f annual free card could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFAnnualFreeCard fetchBycode_Last(
		java.lang.String code,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f annual free cards before and after the current e s f annual free card in the ordered set where code = &#63;.
	*
	* @param annualFreeCardId the primary key of the current e s f annual free card
	* @param code the code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f annual free card
	* @throws it.ethica.esf.NoSuchAnnualFreeCardException if a e s f annual free card with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFAnnualFreeCard[] findBycode_PrevAndNext(
		long annualFreeCardId, java.lang.String code,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchAnnualFreeCardException;

	/**
	* Removes all the e s f annual free cards where code = &#63; from the database.
	*
	* @param code the code
	* @throws SystemException if a system exception occurred
	*/
	public void removeBycode(java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f annual free cards where code = &#63;.
	*
	* @param code the code
	* @return the number of matching e s f annual free cards
	* @throws SystemException if a system exception occurred
	*/
	public int countBycode(java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the e s f annual free card in the entity cache if it is enabled.
	*
	* @param esfAnnualFreeCard the e s f annual free card
	*/
	public void cacheResult(
		it.ethica.esf.model.ESFAnnualFreeCard esfAnnualFreeCard);

	/**
	* Caches the e s f annual free cards in the entity cache if it is enabled.
	*
	* @param esfAnnualFreeCards the e s f annual free cards
	*/
	public void cacheResult(
		java.util.List<it.ethica.esf.model.ESFAnnualFreeCard> esfAnnualFreeCards);

	/**
	* Creates a new e s f annual free card with the primary key. Does not add the e s f annual free card to the database.
	*
	* @param annualFreeCardId the primary key for the new e s f annual free card
	* @return the new e s f annual free card
	*/
	public it.ethica.esf.model.ESFAnnualFreeCard create(long annualFreeCardId);

	/**
	* Removes the e s f annual free card with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param annualFreeCardId the primary key of the e s f annual free card
	* @return the e s f annual free card that was removed
	* @throws it.ethica.esf.NoSuchAnnualFreeCardException if a e s f annual free card with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFAnnualFreeCard remove(long annualFreeCardId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchAnnualFreeCardException;

	public it.ethica.esf.model.ESFAnnualFreeCard updateImpl(
		it.ethica.esf.model.ESFAnnualFreeCard esfAnnualFreeCard)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f annual free card with the primary key or throws a {@link it.ethica.esf.NoSuchAnnualFreeCardException} if it could not be found.
	*
	* @param annualFreeCardId the primary key of the e s f annual free card
	* @return the e s f annual free card
	* @throws it.ethica.esf.NoSuchAnnualFreeCardException if a e s f annual free card with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFAnnualFreeCard findByPrimaryKey(
		long annualFreeCardId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchAnnualFreeCardException;

	/**
	* Returns the e s f annual free card with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param annualFreeCardId the primary key of the e s f annual free card
	* @return the e s f annual free card, or <code>null</code> if a e s f annual free card with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFAnnualFreeCard fetchByPrimaryKey(
		long annualFreeCardId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f annual free cards.
	*
	* @return the e s f annual free cards
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFAnnualFreeCard> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f annual free cards.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFAnnualFreeCardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f annual free cards
	* @param end the upper bound of the range of e s f annual free cards (not inclusive)
	* @return the range of e s f annual free cards
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFAnnualFreeCard> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f annual free cards.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFAnnualFreeCardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f annual free cards
	* @param end the upper bound of the range of e s f annual free cards (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of e s f annual free cards
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFAnnualFreeCard> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the e s f annual free cards from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f annual free cards.
	*
	* @return the number of e s f annual free cards
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}