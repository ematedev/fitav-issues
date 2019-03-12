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

import it.ethica.esf.model.ESFShootingDirector;

/**
 * The persistence interface for the e s f shooting director service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFShootingDirectorPersistenceImpl
 * @see ESFShootingDirectorUtil
 * @generated
 */
public interface ESFShootingDirectorPersistence extends BasePersistence<ESFShootingDirector> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ESFShootingDirectorUtil} to access the e s f shooting director persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the e s f shooting directors where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @return the matching e s f shooting directors
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFShootingDirector> findBybyUserId(
		java.lang.Long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f shooting directors where esfUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShootingDirectorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfUserId the esf user ID
	* @param start the lower bound of the range of e s f shooting directors
	* @param end the upper bound of the range of e s f shooting directors (not inclusive)
	* @return the range of matching e s f shooting directors
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFShootingDirector> findBybyUserId(
		java.lang.Long esfUserId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f shooting directors where esfUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShootingDirectorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param esfUserId the esf user ID
	* @param start the lower bound of the range of e s f shooting directors
	* @param end the upper bound of the range of e s f shooting directors (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f shooting directors
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFShootingDirector> findBybyUserId(
		java.lang.Long esfUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f shooting director in the ordered set where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f shooting director
	* @throws it.ethica.esf.NoSuchShootingDirectorException if a matching e s f shooting director could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFShootingDirector findBybyUserId_First(
		java.lang.Long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchShootingDirectorException;

	/**
	* Returns the first e s f shooting director in the ordered set where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f shooting director, or <code>null</code> if a matching e s f shooting director could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFShootingDirector fetchBybyUserId_First(
		java.lang.Long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f shooting director in the ordered set where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f shooting director
	* @throws it.ethica.esf.NoSuchShootingDirectorException if a matching e s f shooting director could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFShootingDirector findBybyUserId_Last(
		java.lang.Long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchShootingDirectorException;

	/**
	* Returns the last e s f shooting director in the ordered set where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f shooting director, or <code>null</code> if a matching e s f shooting director could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFShootingDirector fetchBybyUserId_Last(
		java.lang.Long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f shooting directors before and after the current e s f shooting director in the ordered set where esfUserId = &#63;.
	*
	* @param esfShootingDirectorId the primary key of the current e s f shooting director
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f shooting director
	* @throws it.ethica.esf.NoSuchShootingDirectorException if a e s f shooting director with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFShootingDirector[] findBybyUserId_PrevAndNext(
		long esfShootingDirectorId, java.lang.Long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchShootingDirectorException;

	/**
	* Removes all the e s f shooting directors where esfUserId = &#63; from the database.
	*
	* @param esfUserId the esf user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeBybyUserId(java.lang.Long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f shooting directors where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @return the number of matching e s f shooting directors
	* @throws SystemException if a system exception occurred
	*/
	public int countBybyUserId(java.lang.Long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f shooting directors where shootingDirectorQualificationId = &#63;.
	*
	* @param shootingDirectorQualificationId the shooting director qualification ID
	* @return the matching e s f shooting directors
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFShootingDirector> findBybyShootingDirectorQualificationId(
		java.lang.Long shootingDirectorQualificationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f shooting directors where shootingDirectorQualificationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShootingDirectorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param shootingDirectorQualificationId the shooting director qualification ID
	* @param start the lower bound of the range of e s f shooting directors
	* @param end the upper bound of the range of e s f shooting directors (not inclusive)
	* @return the range of matching e s f shooting directors
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFShootingDirector> findBybyShootingDirectorQualificationId(
		java.lang.Long shootingDirectorQualificationId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f shooting directors where shootingDirectorQualificationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShootingDirectorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param shootingDirectorQualificationId the shooting director qualification ID
	* @param start the lower bound of the range of e s f shooting directors
	* @param end the upper bound of the range of e s f shooting directors (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f shooting directors
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFShootingDirector> findBybyShootingDirectorQualificationId(
		java.lang.Long shootingDirectorQualificationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f shooting director in the ordered set where shootingDirectorQualificationId = &#63;.
	*
	* @param shootingDirectorQualificationId the shooting director qualification ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f shooting director
	* @throws it.ethica.esf.NoSuchShootingDirectorException if a matching e s f shooting director could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFShootingDirector findBybyShootingDirectorQualificationId_First(
		java.lang.Long shootingDirectorQualificationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchShootingDirectorException;

	/**
	* Returns the first e s f shooting director in the ordered set where shootingDirectorQualificationId = &#63;.
	*
	* @param shootingDirectorQualificationId the shooting director qualification ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f shooting director, or <code>null</code> if a matching e s f shooting director could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFShootingDirector fetchBybyShootingDirectorQualificationId_First(
		java.lang.Long shootingDirectorQualificationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f shooting director in the ordered set where shootingDirectorQualificationId = &#63;.
	*
	* @param shootingDirectorQualificationId the shooting director qualification ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f shooting director
	* @throws it.ethica.esf.NoSuchShootingDirectorException if a matching e s f shooting director could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFShootingDirector findBybyShootingDirectorQualificationId_Last(
		java.lang.Long shootingDirectorQualificationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchShootingDirectorException;

	/**
	* Returns the last e s f shooting director in the ordered set where shootingDirectorQualificationId = &#63;.
	*
	* @param shootingDirectorQualificationId the shooting director qualification ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f shooting director, or <code>null</code> if a matching e s f shooting director could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFShootingDirector fetchBybyShootingDirectorQualificationId_Last(
		java.lang.Long shootingDirectorQualificationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f shooting directors before and after the current e s f shooting director in the ordered set where shootingDirectorQualificationId = &#63;.
	*
	* @param esfShootingDirectorId the primary key of the current e s f shooting director
	* @param shootingDirectorQualificationId the shooting director qualification ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f shooting director
	* @throws it.ethica.esf.NoSuchShootingDirectorException if a e s f shooting director with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFShootingDirector[] findBybyShootingDirectorQualificationId_PrevAndNext(
		long esfShootingDirectorId,
		java.lang.Long shootingDirectorQualificationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchShootingDirectorException;

	/**
	* Removes all the e s f shooting directors where shootingDirectorQualificationId = &#63; from the database.
	*
	* @param shootingDirectorQualificationId the shooting director qualification ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeBybyShootingDirectorQualificationId(
		java.lang.Long shootingDirectorQualificationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f shooting directors where shootingDirectorQualificationId = &#63;.
	*
	* @param shootingDirectorQualificationId the shooting director qualification ID
	* @return the number of matching e s f shooting directors
	* @throws SystemException if a system exception occurred
	*/
	public int countBybyShootingDirectorQualificationId(
		java.lang.Long shootingDirectorQualificationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f shooting directors where sportTypeId = &#63;.
	*
	* @param sportTypeId the sport type ID
	* @return the matching e s f shooting directors
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFShootingDirector> findBybySportTypeId(
		java.lang.Long sportTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f shooting directors where sportTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShootingDirectorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param sportTypeId the sport type ID
	* @param start the lower bound of the range of e s f shooting directors
	* @param end the upper bound of the range of e s f shooting directors (not inclusive)
	* @return the range of matching e s f shooting directors
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFShootingDirector> findBybySportTypeId(
		java.lang.Long sportTypeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f shooting directors where sportTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShootingDirectorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param sportTypeId the sport type ID
	* @param start the lower bound of the range of e s f shooting directors
	* @param end the upper bound of the range of e s f shooting directors (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f shooting directors
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFShootingDirector> findBybySportTypeId(
		java.lang.Long sportTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f shooting director in the ordered set where sportTypeId = &#63;.
	*
	* @param sportTypeId the sport type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f shooting director
	* @throws it.ethica.esf.NoSuchShootingDirectorException if a matching e s f shooting director could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFShootingDirector findBybySportTypeId_First(
		java.lang.Long sportTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchShootingDirectorException;

	/**
	* Returns the first e s f shooting director in the ordered set where sportTypeId = &#63;.
	*
	* @param sportTypeId the sport type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f shooting director, or <code>null</code> if a matching e s f shooting director could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFShootingDirector fetchBybySportTypeId_First(
		java.lang.Long sportTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f shooting director in the ordered set where sportTypeId = &#63;.
	*
	* @param sportTypeId the sport type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f shooting director
	* @throws it.ethica.esf.NoSuchShootingDirectorException if a matching e s f shooting director could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFShootingDirector findBybySportTypeId_Last(
		java.lang.Long sportTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchShootingDirectorException;

	/**
	* Returns the last e s f shooting director in the ordered set where sportTypeId = &#63;.
	*
	* @param sportTypeId the sport type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f shooting director, or <code>null</code> if a matching e s f shooting director could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFShootingDirector fetchBybySportTypeId_Last(
		java.lang.Long sportTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f shooting directors before and after the current e s f shooting director in the ordered set where sportTypeId = &#63;.
	*
	* @param esfShootingDirectorId the primary key of the current e s f shooting director
	* @param sportTypeId the sport type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f shooting director
	* @throws it.ethica.esf.NoSuchShootingDirectorException if a e s f shooting director with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFShootingDirector[] findBybySportTypeId_PrevAndNext(
		long esfShootingDirectorId, java.lang.Long sportTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchShootingDirectorException;

	/**
	* Removes all the e s f shooting directors where sportTypeId = &#63; from the database.
	*
	* @param sportTypeId the sport type ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeBybySportTypeId(java.lang.Long sportTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f shooting directors where sportTypeId = &#63;.
	*
	* @param sportTypeId the sport type ID
	* @return the number of matching e s f shooting directors
	* @throws SystemException if a system exception occurred
	*/
	public int countBybySportTypeId(java.lang.Long sportTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f shooting directors where regionId = &#63;.
	*
	* @param regionId the region ID
	* @return the matching e s f shooting directors
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFShootingDirector> findBybyRegionId(
		java.lang.String regionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f shooting directors where regionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShootingDirectorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param regionId the region ID
	* @param start the lower bound of the range of e s f shooting directors
	* @param end the upper bound of the range of e s f shooting directors (not inclusive)
	* @return the range of matching e s f shooting directors
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFShootingDirector> findBybyRegionId(
		java.lang.String regionId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f shooting directors where regionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShootingDirectorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param regionId the region ID
	* @param start the lower bound of the range of e s f shooting directors
	* @param end the upper bound of the range of e s f shooting directors (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f shooting directors
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFShootingDirector> findBybyRegionId(
		java.lang.String regionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f shooting director in the ordered set where regionId = &#63;.
	*
	* @param regionId the region ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f shooting director
	* @throws it.ethica.esf.NoSuchShootingDirectorException if a matching e s f shooting director could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFShootingDirector findBybyRegionId_First(
		java.lang.String regionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchShootingDirectorException;

	/**
	* Returns the first e s f shooting director in the ordered set where regionId = &#63;.
	*
	* @param regionId the region ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f shooting director, or <code>null</code> if a matching e s f shooting director could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFShootingDirector fetchBybyRegionId_First(
		java.lang.String regionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f shooting director in the ordered set where regionId = &#63;.
	*
	* @param regionId the region ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f shooting director
	* @throws it.ethica.esf.NoSuchShootingDirectorException if a matching e s f shooting director could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFShootingDirector findBybyRegionId_Last(
		java.lang.String regionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchShootingDirectorException;

	/**
	* Returns the last e s f shooting director in the ordered set where regionId = &#63;.
	*
	* @param regionId the region ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f shooting director, or <code>null</code> if a matching e s f shooting director could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFShootingDirector fetchBybyRegionId_Last(
		java.lang.String regionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f shooting directors before and after the current e s f shooting director in the ordered set where regionId = &#63;.
	*
	* @param esfShootingDirectorId the primary key of the current e s f shooting director
	* @param regionId the region ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f shooting director
	* @throws it.ethica.esf.NoSuchShootingDirectorException if a e s f shooting director with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFShootingDirector[] findBybyRegionId_PrevAndNext(
		long esfShootingDirectorId, java.lang.String regionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchShootingDirectorException;

	/**
	* Removes all the e s f shooting directors where regionId = &#63; from the database.
	*
	* @param regionId the region ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeBybyRegionId(java.lang.String regionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f shooting directors where regionId = &#63;.
	*
	* @param regionId the region ID
	* @return the number of matching e s f shooting directors
	* @throws SystemException if a system exception occurred
	*/
	public int countBybyRegionId(java.lang.String regionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f shooting directors where provinceId = &#63;.
	*
	* @param provinceId the province ID
	* @return the matching e s f shooting directors
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFShootingDirector> findBybyProvinceId(
		java.lang.String provinceId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f shooting directors where provinceId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShootingDirectorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param provinceId the province ID
	* @param start the lower bound of the range of e s f shooting directors
	* @param end the upper bound of the range of e s f shooting directors (not inclusive)
	* @return the range of matching e s f shooting directors
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFShootingDirector> findBybyProvinceId(
		java.lang.String provinceId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f shooting directors where provinceId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShootingDirectorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param provinceId the province ID
	* @param start the lower bound of the range of e s f shooting directors
	* @param end the upper bound of the range of e s f shooting directors (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f shooting directors
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFShootingDirector> findBybyProvinceId(
		java.lang.String provinceId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f shooting director in the ordered set where provinceId = &#63;.
	*
	* @param provinceId the province ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f shooting director
	* @throws it.ethica.esf.NoSuchShootingDirectorException if a matching e s f shooting director could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFShootingDirector findBybyProvinceId_First(
		java.lang.String provinceId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchShootingDirectorException;

	/**
	* Returns the first e s f shooting director in the ordered set where provinceId = &#63;.
	*
	* @param provinceId the province ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f shooting director, or <code>null</code> if a matching e s f shooting director could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFShootingDirector fetchBybyProvinceId_First(
		java.lang.String provinceId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f shooting director in the ordered set where provinceId = &#63;.
	*
	* @param provinceId the province ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f shooting director
	* @throws it.ethica.esf.NoSuchShootingDirectorException if a matching e s f shooting director could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFShootingDirector findBybyProvinceId_Last(
		java.lang.String provinceId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchShootingDirectorException;

	/**
	* Returns the last e s f shooting director in the ordered set where provinceId = &#63;.
	*
	* @param provinceId the province ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f shooting director, or <code>null</code> if a matching e s f shooting director could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFShootingDirector fetchBybyProvinceId_Last(
		java.lang.String provinceId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f shooting directors before and after the current e s f shooting director in the ordered set where provinceId = &#63;.
	*
	* @param esfShootingDirectorId the primary key of the current e s f shooting director
	* @param provinceId the province ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f shooting director
	* @throws it.ethica.esf.NoSuchShootingDirectorException if a e s f shooting director with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFShootingDirector[] findBybyProvinceId_PrevAndNext(
		long esfShootingDirectorId, java.lang.String provinceId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchShootingDirectorException;

	/**
	* Removes all the e s f shooting directors where provinceId = &#63; from the database.
	*
	* @param provinceId the province ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeBybyProvinceId(java.lang.String provinceId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f shooting directors where provinceId = &#63;.
	*
	* @param provinceId the province ID
	* @return the number of matching e s f shooting directors
	* @throws SystemException if a system exception occurred
	*/
	public int countBybyProvinceId(java.lang.String provinceId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f shooting director where esfUserId = &#63; and shootingDirectorQualificationId = &#63; and sportTypeId = &#63; or throws a {@link it.ethica.esf.NoSuchShootingDirectorException} if it could not be found.
	*
	* @param esfUserId the esf user ID
	* @param shootingDirectorQualificationId the shooting director qualification ID
	* @param sportTypeId the sport type ID
	* @return the matching e s f shooting director
	* @throws it.ethica.esf.NoSuchShootingDirectorException if a matching e s f shooting director could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFShootingDirector findBybyUserId_SDQId_STId(
		java.lang.Long esfUserId,
		java.lang.Long shootingDirectorQualificationId,
		java.lang.Long sportTypeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchShootingDirectorException;

	/**
	* Returns the e s f shooting director where esfUserId = &#63; and shootingDirectorQualificationId = &#63; and sportTypeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param esfUserId the esf user ID
	* @param shootingDirectorQualificationId the shooting director qualification ID
	* @param sportTypeId the sport type ID
	* @return the matching e s f shooting director, or <code>null</code> if a matching e s f shooting director could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFShootingDirector fetchBybyUserId_SDQId_STId(
		java.lang.Long esfUserId,
		java.lang.Long shootingDirectorQualificationId,
		java.lang.Long sportTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f shooting director where esfUserId = &#63; and shootingDirectorQualificationId = &#63; and sportTypeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param esfUserId the esf user ID
	* @param shootingDirectorQualificationId the shooting director qualification ID
	* @param sportTypeId the sport type ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching e s f shooting director, or <code>null</code> if a matching e s f shooting director could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFShootingDirector fetchBybyUserId_SDQId_STId(
		java.lang.Long esfUserId,
		java.lang.Long shootingDirectorQualificationId,
		java.lang.Long sportTypeId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the e s f shooting director where esfUserId = &#63; and shootingDirectorQualificationId = &#63; and sportTypeId = &#63; from the database.
	*
	* @param esfUserId the esf user ID
	* @param shootingDirectorQualificationId the shooting director qualification ID
	* @param sportTypeId the sport type ID
	* @return the e s f shooting director that was removed
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFShootingDirector removeBybyUserId_SDQId_STId(
		java.lang.Long esfUserId,
		java.lang.Long shootingDirectorQualificationId,
		java.lang.Long sportTypeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchShootingDirectorException;

	/**
	* Returns the number of e s f shooting directors where esfUserId = &#63; and shootingDirectorQualificationId = &#63; and sportTypeId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param shootingDirectorQualificationId the shooting director qualification ID
	* @param sportTypeId the sport type ID
	* @return the number of matching e s f shooting directors
	* @throws SystemException if a system exception occurred
	*/
	public int countBybyUserId_SDQId_STId(java.lang.Long esfUserId,
		java.lang.Long shootingDirectorQualificationId,
		java.lang.Long sportTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the e s f shooting director in the entity cache if it is enabled.
	*
	* @param esfShootingDirector the e s f shooting director
	*/
	public void cacheResult(
		it.ethica.esf.model.ESFShootingDirector esfShootingDirector);

	/**
	* Caches the e s f shooting directors in the entity cache if it is enabled.
	*
	* @param esfShootingDirectors the e s f shooting directors
	*/
	public void cacheResult(
		java.util.List<it.ethica.esf.model.ESFShootingDirector> esfShootingDirectors);

	/**
	* Creates a new e s f shooting director with the primary key. Does not add the e s f shooting director to the database.
	*
	* @param esfShootingDirectorId the primary key for the new e s f shooting director
	* @return the new e s f shooting director
	*/
	public it.ethica.esf.model.ESFShootingDirector create(
		long esfShootingDirectorId);

	/**
	* Removes the e s f shooting director with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfShootingDirectorId the primary key of the e s f shooting director
	* @return the e s f shooting director that was removed
	* @throws it.ethica.esf.NoSuchShootingDirectorException if a e s f shooting director with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFShootingDirector remove(
		long esfShootingDirectorId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchShootingDirectorException;

	public it.ethica.esf.model.ESFShootingDirector updateImpl(
		it.ethica.esf.model.ESFShootingDirector esfShootingDirector)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f shooting director with the primary key or throws a {@link it.ethica.esf.NoSuchShootingDirectorException} if it could not be found.
	*
	* @param esfShootingDirectorId the primary key of the e s f shooting director
	* @return the e s f shooting director
	* @throws it.ethica.esf.NoSuchShootingDirectorException if a e s f shooting director with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFShootingDirector findByPrimaryKey(
		long esfShootingDirectorId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchShootingDirectorException;

	/**
	* Returns the e s f shooting director with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param esfShootingDirectorId the primary key of the e s f shooting director
	* @return the e s f shooting director, or <code>null</code> if a e s f shooting director with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFShootingDirector fetchByPrimaryKey(
		long esfShootingDirectorId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f shooting directors.
	*
	* @return the e s f shooting directors
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFShootingDirector> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f shooting directors.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShootingDirectorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f shooting directors
	* @param end the upper bound of the range of e s f shooting directors (not inclusive)
	* @return the range of e s f shooting directors
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFShootingDirector> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f shooting directors.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShootingDirectorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f shooting directors
	* @param end the upper bound of the range of e s f shooting directors (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of e s f shooting directors
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFShootingDirector> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the e s f shooting directors from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f shooting directors.
	*
	* @return the number of e s f shooting directors
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}