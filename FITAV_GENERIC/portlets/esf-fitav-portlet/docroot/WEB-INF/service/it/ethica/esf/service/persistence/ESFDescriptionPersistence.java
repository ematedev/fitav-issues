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

import it.ethica.esf.model.ESFDescription;

/**
 * The persistence interface for the e s f description service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFDescriptionPersistenceImpl
 * @see ESFDescriptionUtil
 * @generated
 */
public interface ESFDescriptionPersistence extends BasePersistence<ESFDescription> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ESFDescriptionUtil} to access the e s f description persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the e s f descriptions where isNational = &#63;.
	*
	* @param isNational the is national
	* @return the matching e s f descriptions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFDescription> findByIsNational(
		boolean isNational)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f descriptions where isNational = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFDescriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param isNational the is national
	* @param start the lower bound of the range of e s f descriptions
	* @param end the upper bound of the range of e s f descriptions (not inclusive)
	* @return the range of matching e s f descriptions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFDescription> findByIsNational(
		boolean isNational, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f descriptions where isNational = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFDescriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param isNational the is national
	* @param start the lower bound of the range of e s f descriptions
	* @param end the upper bound of the range of e s f descriptions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f descriptions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFDescription> findByIsNational(
		boolean isNational, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f description in the ordered set where isNational = &#63;.
	*
	* @param isNational the is national
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f description
	* @throws it.ethica.esf.NoSuchDescriptionException if a matching e s f description could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFDescription findByIsNational_First(
		boolean isNational,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchDescriptionException;

	/**
	* Returns the first e s f description in the ordered set where isNational = &#63;.
	*
	* @param isNational the is national
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f description, or <code>null</code> if a matching e s f description could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFDescription fetchByIsNational_First(
		boolean isNational,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f description in the ordered set where isNational = &#63;.
	*
	* @param isNational the is national
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f description
	* @throws it.ethica.esf.NoSuchDescriptionException if a matching e s f description could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFDescription findByIsNational_Last(
		boolean isNational,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchDescriptionException;

	/**
	* Returns the last e s f description in the ordered set where isNational = &#63;.
	*
	* @param isNational the is national
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f description, or <code>null</code> if a matching e s f description could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFDescription fetchByIsNational_Last(
		boolean isNational,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f descriptions before and after the current e s f description in the ordered set where isNational = &#63;.
	*
	* @param esfDescriptionId the primary key of the current e s f description
	* @param isNational the is national
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f description
	* @throws it.ethica.esf.NoSuchDescriptionException if a e s f description with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFDescription[] findByIsNational_PrevAndNext(
		long esfDescriptionId, boolean isNational,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchDescriptionException;

	/**
	* Removes all the e s f descriptions where isNational = &#63; from the database.
	*
	* @param isNational the is national
	* @throws SystemException if a system exception occurred
	*/
	public void removeByIsNational(boolean isNational)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f descriptions where isNational = &#63;.
	*
	* @param isNational the is national
	* @return the number of matching e s f descriptions
	* @throws SystemException if a system exception occurred
	*/
	public int countByIsNational(boolean isNational)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the e s f description in the entity cache if it is enabled.
	*
	* @param esfDescription the e s f description
	*/
	public void cacheResult(it.ethica.esf.model.ESFDescription esfDescription);

	/**
	* Caches the e s f descriptions in the entity cache if it is enabled.
	*
	* @param esfDescriptions the e s f descriptions
	*/
	public void cacheResult(
		java.util.List<it.ethica.esf.model.ESFDescription> esfDescriptions);

	/**
	* Creates a new e s f description with the primary key. Does not add the e s f description to the database.
	*
	* @param esfDescriptionId the primary key for the new e s f description
	* @return the new e s f description
	*/
	public it.ethica.esf.model.ESFDescription create(long esfDescriptionId);

	/**
	* Removes the e s f description with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfDescriptionId the primary key of the e s f description
	* @return the e s f description that was removed
	* @throws it.ethica.esf.NoSuchDescriptionException if a e s f description with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFDescription remove(long esfDescriptionId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchDescriptionException;

	public it.ethica.esf.model.ESFDescription updateImpl(
		it.ethica.esf.model.ESFDescription esfDescription)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f description with the primary key or throws a {@link it.ethica.esf.NoSuchDescriptionException} if it could not be found.
	*
	* @param esfDescriptionId the primary key of the e s f description
	* @return the e s f description
	* @throws it.ethica.esf.NoSuchDescriptionException if a e s f description with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFDescription findByPrimaryKey(
		long esfDescriptionId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchDescriptionException;

	/**
	* Returns the e s f description with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param esfDescriptionId the primary key of the e s f description
	* @return the e s f description, or <code>null</code> if a e s f description with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFDescription fetchByPrimaryKey(
		long esfDescriptionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f descriptions.
	*
	* @return the e s f descriptions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFDescription> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f descriptions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFDescriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f descriptions
	* @param end the upper bound of the range of e s f descriptions (not inclusive)
	* @return the range of e s f descriptions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFDescription> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f descriptions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFDescriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f descriptions
	* @param end the upper bound of the range of e s f descriptions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of e s f descriptions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFDescription> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the e s f descriptions from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f descriptions.
	*
	* @return the number of e s f descriptions
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}