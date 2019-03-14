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

import it.ethica.esf.model.ESFSuspensiveShootingDirector;

/**
 * The persistence interface for the e s f suspensive shooting director service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFSuspensiveShootingDirectorPersistenceImpl
 * @see ESFSuspensiveShootingDirectorUtil
 * @generated
 */
public interface ESFSuspensiveShootingDirectorPersistence
	extends BasePersistence<ESFSuspensiveShootingDirector> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ESFSuspensiveShootingDirectorUtil} to access the e s f suspensive shooting director persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the e s f suspensive shooting directors where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @return the matching e s f suspensive shooting directors
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFSuspensiveShootingDirector> findBybyUserId(
		java.lang.Long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f suspensive shooting directors where esfUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFSuspensiveShootingDirectorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfUserId the esf user ID
	* @param start the lower bound of the range of e s f suspensive shooting directors
	* @param end the upper bound of the range of e s f suspensive shooting directors (not inclusive)
	* @return the range of matching e s f suspensive shooting directors
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFSuspensiveShootingDirector> findBybyUserId(
		java.lang.Long esfUserId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f suspensive shooting directors where esfUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFSuspensiveShootingDirectorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfUserId the esf user ID
	* @param start the lower bound of the range of e s f suspensive shooting directors
	* @param end the upper bound of the range of e s f suspensive shooting directors (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f suspensive shooting directors
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFSuspensiveShootingDirector> findBybyUserId(
		java.lang.Long esfUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f suspensive shooting director in the ordered set where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f suspensive shooting director
	* @throws it.ethica.esf.NoSuchSuspensiveShootingDirectorException if a matching e s f suspensive shooting director could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFSuspensiveShootingDirector findBybyUserId_First(
		java.lang.Long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchSuspensiveShootingDirectorException;

	/**
	* Returns the first e s f suspensive shooting director in the ordered set where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f suspensive shooting director, or <code>null</code> if a matching e s f suspensive shooting director could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFSuspensiveShootingDirector fetchBybyUserId_First(
		java.lang.Long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f suspensive shooting director in the ordered set where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f suspensive shooting director
	* @throws it.ethica.esf.NoSuchSuspensiveShootingDirectorException if a matching e s f suspensive shooting director could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFSuspensiveShootingDirector findBybyUserId_Last(
		java.lang.Long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchSuspensiveShootingDirectorException;

	/**
	* Returns the last e s f suspensive shooting director in the ordered set where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f suspensive shooting director, or <code>null</code> if a matching e s f suspensive shooting director could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFSuspensiveShootingDirector fetchBybyUserId_Last(
		java.lang.Long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f suspensive shooting directors before and after the current e s f suspensive shooting director in the ordered set where esfUserId = &#63;.
	*
	* @param esfSuspensiveShooingDirectorId the primary key of the current e s f suspensive shooting director
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f suspensive shooting director
	* @throws it.ethica.esf.NoSuchSuspensiveShootingDirectorException if a e s f suspensive shooting director with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFSuspensiveShootingDirector[] findBybyUserId_PrevAndNext(
		long esfSuspensiveShooingDirectorId, java.lang.Long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchSuspensiveShootingDirectorException;

	/**
	* Removes all the e s f suspensive shooting directors where esfUserId = &#63; from the database.
	*
	* @param esfUserId the esf user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeBybyUserId(java.lang.Long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f suspensive shooting directors where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @return the number of matching e s f suspensive shooting directors
	* @throws SystemException if a system exception occurred
	*/
	public int countBybyUserId(java.lang.Long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f suspensive shooting directors where esfEndData &gt; &#63; and esfUserId = &#63;.
	*
	* @param esfEndData the esf end data
	* @param esfUserId the esf user ID
	* @return the matching e s f suspensive shooting directors
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFSuspensiveShootingDirector> findByDate(
		java.util.Date esfEndData, java.lang.Long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f suspensive shooting directors where esfEndData &gt; &#63; and esfUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFSuspensiveShootingDirectorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfEndData the esf end data
	* @param esfUserId the esf user ID
	* @param start the lower bound of the range of e s f suspensive shooting directors
	* @param end the upper bound of the range of e s f suspensive shooting directors (not inclusive)
	* @return the range of matching e s f suspensive shooting directors
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFSuspensiveShootingDirector> findByDate(
		java.util.Date esfEndData, java.lang.Long esfUserId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f suspensive shooting directors where esfEndData &gt; &#63; and esfUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFSuspensiveShootingDirectorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfEndData the esf end data
	* @param esfUserId the esf user ID
	* @param start the lower bound of the range of e s f suspensive shooting directors
	* @param end the upper bound of the range of e s f suspensive shooting directors (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f suspensive shooting directors
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFSuspensiveShootingDirector> findByDate(
		java.util.Date esfEndData, java.lang.Long esfUserId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f suspensive shooting director in the ordered set where esfEndData &gt; &#63; and esfUserId = &#63;.
	*
	* @param esfEndData the esf end data
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f suspensive shooting director
	* @throws it.ethica.esf.NoSuchSuspensiveShootingDirectorException if a matching e s f suspensive shooting director could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFSuspensiveShootingDirector findByDate_First(
		java.util.Date esfEndData, java.lang.Long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchSuspensiveShootingDirectorException;

	/**
	* Returns the first e s f suspensive shooting director in the ordered set where esfEndData &gt; &#63; and esfUserId = &#63;.
	*
	* @param esfEndData the esf end data
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f suspensive shooting director, or <code>null</code> if a matching e s f suspensive shooting director could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFSuspensiveShootingDirector fetchByDate_First(
		java.util.Date esfEndData, java.lang.Long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f suspensive shooting director in the ordered set where esfEndData &gt; &#63; and esfUserId = &#63;.
	*
	* @param esfEndData the esf end data
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f suspensive shooting director
	* @throws it.ethica.esf.NoSuchSuspensiveShootingDirectorException if a matching e s f suspensive shooting director could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFSuspensiveShootingDirector findByDate_Last(
		java.util.Date esfEndData, java.lang.Long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchSuspensiveShootingDirectorException;

	/**
	* Returns the last e s f suspensive shooting director in the ordered set where esfEndData &gt; &#63; and esfUserId = &#63;.
	*
	* @param esfEndData the esf end data
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f suspensive shooting director, or <code>null</code> if a matching e s f suspensive shooting director could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFSuspensiveShootingDirector fetchByDate_Last(
		java.util.Date esfEndData, java.lang.Long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f suspensive shooting directors before and after the current e s f suspensive shooting director in the ordered set where esfEndData &gt; &#63; and esfUserId = &#63;.
	*
	* @param esfSuspensiveShooingDirectorId the primary key of the current e s f suspensive shooting director
	* @param esfEndData the esf end data
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f suspensive shooting director
	* @throws it.ethica.esf.NoSuchSuspensiveShootingDirectorException if a e s f suspensive shooting director with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFSuspensiveShootingDirector[] findByDate_PrevAndNext(
		long esfSuspensiveShooingDirectorId, java.util.Date esfEndData,
		java.lang.Long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchSuspensiveShootingDirectorException;

	/**
	* Removes all the e s f suspensive shooting directors where esfEndData &gt; &#63; and esfUserId = &#63; from the database.
	*
	* @param esfEndData the esf end data
	* @param esfUserId the esf user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByDate(java.util.Date esfEndData, java.lang.Long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f suspensive shooting directors where esfEndData &gt; &#63; and esfUserId = &#63;.
	*
	* @param esfEndData the esf end data
	* @param esfUserId the esf user ID
	* @return the number of matching e s f suspensive shooting directors
	* @throws SystemException if a system exception occurred
	*/
	public int countByDate(java.util.Date esfEndData, java.lang.Long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the e s f suspensive shooting director in the entity cache if it is enabled.
	*
	* @param esfSuspensiveShootingDirector the e s f suspensive shooting director
	*/
	public void cacheResult(
		it.ethica.esf.model.ESFSuspensiveShootingDirector esfSuspensiveShootingDirector);

	/**
	* Caches the e s f suspensive shooting directors in the entity cache if it is enabled.
	*
	* @param esfSuspensiveShootingDirectors the e s f suspensive shooting directors
	*/
	public void cacheResult(
		java.util.List<it.ethica.esf.model.ESFSuspensiveShootingDirector> esfSuspensiveShootingDirectors);

	/**
	* Creates a new e s f suspensive shooting director with the primary key. Does not add the e s f suspensive shooting director to the database.
	*
	* @param esfSuspensiveShooingDirectorId the primary key for the new e s f suspensive shooting director
	* @return the new e s f suspensive shooting director
	*/
	public it.ethica.esf.model.ESFSuspensiveShootingDirector create(
		long esfSuspensiveShooingDirectorId);

	/**
	* Removes the e s f suspensive shooting director with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfSuspensiveShooingDirectorId the primary key of the e s f suspensive shooting director
	* @return the e s f suspensive shooting director that was removed
	* @throws it.ethica.esf.NoSuchSuspensiveShootingDirectorException if a e s f suspensive shooting director with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFSuspensiveShootingDirector remove(
		long esfSuspensiveShooingDirectorId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchSuspensiveShootingDirectorException;

	public it.ethica.esf.model.ESFSuspensiveShootingDirector updateImpl(
		it.ethica.esf.model.ESFSuspensiveShootingDirector esfSuspensiveShootingDirector)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f suspensive shooting director with the primary key or throws a {@link it.ethica.esf.NoSuchSuspensiveShootingDirectorException} if it could not be found.
	*
	* @param esfSuspensiveShooingDirectorId the primary key of the e s f suspensive shooting director
	* @return the e s f suspensive shooting director
	* @throws it.ethica.esf.NoSuchSuspensiveShootingDirectorException if a e s f suspensive shooting director with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFSuspensiveShootingDirector findByPrimaryKey(
		long esfSuspensiveShooingDirectorId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchSuspensiveShootingDirectorException;

	/**
	* Returns the e s f suspensive shooting director with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param esfSuspensiveShooingDirectorId the primary key of the e s f suspensive shooting director
	* @return the e s f suspensive shooting director, or <code>null</code> if a e s f suspensive shooting director with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFSuspensiveShootingDirector fetchByPrimaryKey(
		long esfSuspensiveShooingDirectorId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f suspensive shooting directors.
	*
	* @return the e s f suspensive shooting directors
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFSuspensiveShootingDirector> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f suspensive shooting directors.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFSuspensiveShootingDirectorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f suspensive shooting directors
	* @param end the upper bound of the range of e s f suspensive shooting directors (not inclusive)
	* @return the range of e s f suspensive shooting directors
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFSuspensiveShootingDirector> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f suspensive shooting directors.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFSuspensiveShootingDirectorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f suspensive shooting directors
	* @param end the upper bound of the range of e s f suspensive shooting directors (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of e s f suspensive shooting directors
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFSuspensiveShootingDirector> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the e s f suspensive shooting directors from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f suspensive shooting directors.
	*
	* @return the number of e s f suspensive shooting directors
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}