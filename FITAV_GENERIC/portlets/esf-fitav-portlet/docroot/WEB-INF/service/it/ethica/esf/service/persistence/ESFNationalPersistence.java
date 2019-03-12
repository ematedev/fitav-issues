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

import it.ethica.esf.model.ESFNational;

/**
 * The persistence interface for the e s f national service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFNationalPersistenceImpl
 * @see ESFNationalUtil
 * @generated
 */
public interface ESFNationalPersistence extends BasePersistence<ESFNational> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ESFNationalUtil} to access the e s f national persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the e s f nationals where endDate &gt; &#63;.
	*
	* @param endDate the end date
	* @return the matching e s f nationals
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFNational> findByEndDate(
		java.util.Date endDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f nationals where endDate &gt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param endDate the end date
	* @param start the lower bound of the range of e s f nationals
	* @param end the upper bound of the range of e s f nationals (not inclusive)
	* @return the range of matching e s f nationals
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFNational> findByEndDate(
		java.util.Date endDate, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f nationals where endDate &gt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param endDate the end date
	* @param start the lower bound of the range of e s f nationals
	* @param end the upper bound of the range of e s f nationals (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f nationals
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFNational> findByEndDate(
		java.util.Date endDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f national in the ordered set where endDate &gt; &#63;.
	*
	* @param endDate the end date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f national
	* @throws it.ethica.esf.NoSuchNationalException if a matching e s f national could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFNational findByEndDate_First(
		java.util.Date endDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalException;

	/**
	* Returns the first e s f national in the ordered set where endDate &gt; &#63;.
	*
	* @param endDate the end date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f national, or <code>null</code> if a matching e s f national could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFNational fetchByEndDate_First(
		java.util.Date endDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f national in the ordered set where endDate &gt; &#63;.
	*
	* @param endDate the end date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f national
	* @throws it.ethica.esf.NoSuchNationalException if a matching e s f national could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFNational findByEndDate_Last(
		java.util.Date endDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalException;

	/**
	* Returns the last e s f national in the ordered set where endDate &gt; &#63;.
	*
	* @param endDate the end date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f national, or <code>null</code> if a matching e s f national could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFNational fetchByEndDate_Last(
		java.util.Date endDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f nationals before and after the current e s f national in the ordered set where endDate &gt; &#63;.
	*
	* @param esfNationalId the primary key of the current e s f national
	* @param endDate the end date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f national
	* @throws it.ethica.esf.NoSuchNationalException if a e s f national with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFNational[] findByEndDate_PrevAndNext(
		long esfNationalId, java.util.Date endDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalException;

	/**
	* Removes all the e s f nationals where endDate &gt; &#63; from the database.
	*
	* @param endDate the end date
	* @throws SystemException if a system exception occurred
	*/
	public void removeByEndDate(java.util.Date endDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f nationals where endDate &gt; &#63;.
	*
	* @param endDate the end date
	* @return the number of matching e s f nationals
	* @throws SystemException if a system exception occurred
	*/
	public int countByEndDate(java.util.Date endDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f nationals where endDate &gt; &#63; and esfSportTypeId = &#63;.
	*
	* @param endDate the end date
	* @param esfSportTypeId the esf sport type ID
	* @return the matching e s f nationals
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFNational> findByE_E(
		java.util.Date endDate, long esfSportTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f nationals where endDate &gt; &#63; and esfSportTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param endDate the end date
	* @param esfSportTypeId the esf sport type ID
	* @param start the lower bound of the range of e s f nationals
	* @param end the upper bound of the range of e s f nationals (not inclusive)
	* @return the range of matching e s f nationals
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFNational> findByE_E(
		java.util.Date endDate, long esfSportTypeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f nationals where endDate &gt; &#63; and esfSportTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param endDate the end date
	* @param esfSportTypeId the esf sport type ID
	* @param start the lower bound of the range of e s f nationals
	* @param end the upper bound of the range of e s f nationals (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f nationals
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFNational> findByE_E(
		java.util.Date endDate, long esfSportTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f national in the ordered set where endDate &gt; &#63; and esfSportTypeId = &#63;.
	*
	* @param endDate the end date
	* @param esfSportTypeId the esf sport type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f national
	* @throws it.ethica.esf.NoSuchNationalException if a matching e s f national could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFNational findByE_E_First(
		java.util.Date endDate, long esfSportTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalException;

	/**
	* Returns the first e s f national in the ordered set where endDate &gt; &#63; and esfSportTypeId = &#63;.
	*
	* @param endDate the end date
	* @param esfSportTypeId the esf sport type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f national, or <code>null</code> if a matching e s f national could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFNational fetchByE_E_First(
		java.util.Date endDate, long esfSportTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f national in the ordered set where endDate &gt; &#63; and esfSportTypeId = &#63;.
	*
	* @param endDate the end date
	* @param esfSportTypeId the esf sport type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f national
	* @throws it.ethica.esf.NoSuchNationalException if a matching e s f national could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFNational findByE_E_Last(
		java.util.Date endDate, long esfSportTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalException;

	/**
	* Returns the last e s f national in the ordered set where endDate &gt; &#63; and esfSportTypeId = &#63;.
	*
	* @param endDate the end date
	* @param esfSportTypeId the esf sport type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f national, or <code>null</code> if a matching e s f national could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFNational fetchByE_E_Last(
		java.util.Date endDate, long esfSportTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f nationals before and after the current e s f national in the ordered set where endDate &gt; &#63; and esfSportTypeId = &#63;.
	*
	* @param esfNationalId the primary key of the current e s f national
	* @param endDate the end date
	* @param esfSportTypeId the esf sport type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f national
	* @throws it.ethica.esf.NoSuchNationalException if a e s f national with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFNational[] findByE_E_PrevAndNext(
		long esfNationalId, java.util.Date endDate, long esfSportTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalException;

	/**
	* Removes all the e s f nationals where endDate &gt; &#63; and esfSportTypeId = &#63; from the database.
	*
	* @param endDate the end date
	* @param esfSportTypeId the esf sport type ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByE_E(java.util.Date endDate, long esfSportTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f nationals where endDate &gt; &#63; and esfSportTypeId = &#63;.
	*
	* @param endDate the end date
	* @param esfSportTypeId the esf sport type ID
	* @return the number of matching e s f nationals
	* @throws SystemException if a system exception occurred
	*/
	public int countByE_E(java.util.Date endDate, long esfSportTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f nationals where endDate &gt; &#63; and esfUserId = &#63;.
	*
	* @param endDate the end date
	* @param esfUserId the esf user ID
	* @return the matching e s f nationals
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFNational> findByU_E(
		java.util.Date endDate, long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f nationals where endDate &gt; &#63; and esfUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param endDate the end date
	* @param esfUserId the esf user ID
	* @param start the lower bound of the range of e s f nationals
	* @param end the upper bound of the range of e s f nationals (not inclusive)
	* @return the range of matching e s f nationals
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFNational> findByU_E(
		java.util.Date endDate, long esfUserId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f nationals where endDate &gt; &#63; and esfUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param endDate the end date
	* @param esfUserId the esf user ID
	* @param start the lower bound of the range of e s f nationals
	* @param end the upper bound of the range of e s f nationals (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f nationals
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFNational> findByU_E(
		java.util.Date endDate, long esfUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f national in the ordered set where endDate &gt; &#63; and esfUserId = &#63;.
	*
	* @param endDate the end date
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f national
	* @throws it.ethica.esf.NoSuchNationalException if a matching e s f national could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFNational findByU_E_First(
		java.util.Date endDate, long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalException;

	/**
	* Returns the first e s f national in the ordered set where endDate &gt; &#63; and esfUserId = &#63;.
	*
	* @param endDate the end date
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f national, or <code>null</code> if a matching e s f national could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFNational fetchByU_E_First(
		java.util.Date endDate, long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f national in the ordered set where endDate &gt; &#63; and esfUserId = &#63;.
	*
	* @param endDate the end date
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f national
	* @throws it.ethica.esf.NoSuchNationalException if a matching e s f national could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFNational findByU_E_Last(
		java.util.Date endDate, long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalException;

	/**
	* Returns the last e s f national in the ordered set where endDate &gt; &#63; and esfUserId = &#63;.
	*
	* @param endDate the end date
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f national, or <code>null</code> if a matching e s f national could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFNational fetchByU_E_Last(
		java.util.Date endDate, long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f nationals before and after the current e s f national in the ordered set where endDate &gt; &#63; and esfUserId = &#63;.
	*
	* @param esfNationalId the primary key of the current e s f national
	* @param endDate the end date
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f national
	* @throws it.ethica.esf.NoSuchNationalException if a e s f national with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFNational[] findByU_E_PrevAndNext(
		long esfNationalId, java.util.Date endDate, long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalException;

	/**
	* Removes all the e s f nationals where endDate &gt; &#63; and esfUserId = &#63; from the database.
	*
	* @param endDate the end date
	* @param esfUserId the esf user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByU_E(java.util.Date endDate, long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f nationals where endDate &gt; &#63; and esfUserId = &#63;.
	*
	* @param endDate the end date
	* @param esfUserId the esf user ID
	* @return the number of matching e s f nationals
	* @throws SystemException if a system exception occurred
	*/
	public int countByU_E(java.util.Date endDate, long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f nationals where startDate &ge; &#63; and endDate &le; &#63; and esfSportTypeId = &#63;.
	*
	* @param startDate the start date
	* @param endDate the end date
	* @param esfSportTypeId the esf sport type ID
	* @return the matching e s f nationals
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFNational> findBybyStartDateEndDateTypeSportId(
		java.util.Date startDate, java.util.Date endDate, long esfSportTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f nationals where startDate &ge; &#63; and endDate &le; &#63; and esfSportTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param startDate the start date
	* @param endDate the end date
	* @param esfSportTypeId the esf sport type ID
	* @param start the lower bound of the range of e s f nationals
	* @param end the upper bound of the range of e s f nationals (not inclusive)
	* @return the range of matching e s f nationals
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFNational> findBybyStartDateEndDateTypeSportId(
		java.util.Date startDate, java.util.Date endDate, long esfSportTypeId,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f nationals where startDate &ge; &#63; and endDate &le; &#63; and esfSportTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param startDate the start date
	* @param endDate the end date
	* @param esfSportTypeId the esf sport type ID
	* @param start the lower bound of the range of e s f nationals
	* @param end the upper bound of the range of e s f nationals (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f nationals
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFNational> findBybyStartDateEndDateTypeSportId(
		java.util.Date startDate, java.util.Date endDate, long esfSportTypeId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f national in the ordered set where startDate &ge; &#63; and endDate &le; &#63; and esfSportTypeId = &#63;.
	*
	* @param startDate the start date
	* @param endDate the end date
	* @param esfSportTypeId the esf sport type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f national
	* @throws it.ethica.esf.NoSuchNationalException if a matching e s f national could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFNational findBybyStartDateEndDateTypeSportId_First(
		java.util.Date startDate, java.util.Date endDate, long esfSportTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalException;

	/**
	* Returns the first e s f national in the ordered set where startDate &ge; &#63; and endDate &le; &#63; and esfSportTypeId = &#63;.
	*
	* @param startDate the start date
	* @param endDate the end date
	* @param esfSportTypeId the esf sport type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f national, or <code>null</code> if a matching e s f national could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFNational fetchBybyStartDateEndDateTypeSportId_First(
		java.util.Date startDate, java.util.Date endDate, long esfSportTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f national in the ordered set where startDate &ge; &#63; and endDate &le; &#63; and esfSportTypeId = &#63;.
	*
	* @param startDate the start date
	* @param endDate the end date
	* @param esfSportTypeId the esf sport type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f national
	* @throws it.ethica.esf.NoSuchNationalException if a matching e s f national could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFNational findBybyStartDateEndDateTypeSportId_Last(
		java.util.Date startDate, java.util.Date endDate, long esfSportTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalException;

	/**
	* Returns the last e s f national in the ordered set where startDate &ge; &#63; and endDate &le; &#63; and esfSportTypeId = &#63;.
	*
	* @param startDate the start date
	* @param endDate the end date
	* @param esfSportTypeId the esf sport type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f national, or <code>null</code> if a matching e s f national could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFNational fetchBybyStartDateEndDateTypeSportId_Last(
		java.util.Date startDate, java.util.Date endDate, long esfSportTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f nationals before and after the current e s f national in the ordered set where startDate &ge; &#63; and endDate &le; &#63; and esfSportTypeId = &#63;.
	*
	* @param esfNationalId the primary key of the current e s f national
	* @param startDate the start date
	* @param endDate the end date
	* @param esfSportTypeId the esf sport type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f national
	* @throws it.ethica.esf.NoSuchNationalException if a e s f national with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFNational[] findBybyStartDateEndDateTypeSportId_PrevAndNext(
		long esfNationalId, java.util.Date startDate, java.util.Date endDate,
		long esfSportTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalException;

	/**
	* Returns all the e s f nationals where startDate &ge; all &#63; and endDate &le; all &#63; and esfSportTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param startDates the start dates
	* @param endDates the end dates
	* @param esfSportTypeId the esf sport type ID
	* @return the matching e s f nationals
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFNational> findBybyStartDateEndDateTypeSportId(
		java.util.Date[] startDates, java.util.Date[] endDates,
		long esfSportTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f nationals where startDate &ge; all &#63; and endDate &le; all &#63; and esfSportTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param startDates the start dates
	* @param endDates the end dates
	* @param esfSportTypeId the esf sport type ID
	* @param start the lower bound of the range of e s f nationals
	* @param end the upper bound of the range of e s f nationals (not inclusive)
	* @return the range of matching e s f nationals
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFNational> findBybyStartDateEndDateTypeSportId(
		java.util.Date[] startDates, java.util.Date[] endDates,
		long esfSportTypeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f nationals where startDate &ge; all &#63; and endDate &le; all &#63; and esfSportTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param startDates the start dates
	* @param endDates the end dates
	* @param esfSportTypeId the esf sport type ID
	* @param start the lower bound of the range of e s f nationals
	* @param end the upper bound of the range of e s f nationals (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f nationals
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFNational> findBybyStartDateEndDateTypeSportId(
		java.util.Date[] startDates, java.util.Date[] endDates,
		long esfSportTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the e s f nationals where startDate &ge; &#63; and endDate &le; &#63; and esfSportTypeId = &#63; from the database.
	*
	* @param startDate the start date
	* @param endDate the end date
	* @param esfSportTypeId the esf sport type ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeBybyStartDateEndDateTypeSportId(
		java.util.Date startDate, java.util.Date endDate, long esfSportTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f nationals where startDate &ge; &#63; and endDate &le; &#63; and esfSportTypeId = &#63;.
	*
	* @param startDate the start date
	* @param endDate the end date
	* @param esfSportTypeId the esf sport type ID
	* @return the number of matching e s f nationals
	* @throws SystemException if a system exception occurred
	*/
	public int countBybyStartDateEndDateTypeSportId(java.util.Date startDate,
		java.util.Date endDate, long esfSportTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f nationals where startDate &ge; all &#63; and endDate &le; all &#63; and esfSportTypeId = &#63;.
	*
	* @param startDates the start dates
	* @param endDates the end dates
	* @param esfSportTypeId the esf sport type ID
	* @return the number of matching e s f nationals
	* @throws SystemException if a system exception occurred
	*/
	public int countBybyStartDateEndDateTypeSportId(
		java.util.Date[] startDates, java.util.Date[] endDates,
		long esfSportTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the e s f national in the entity cache if it is enabled.
	*
	* @param esfNational the e s f national
	*/
	public void cacheResult(it.ethica.esf.model.ESFNational esfNational);

	/**
	* Caches the e s f nationals in the entity cache if it is enabled.
	*
	* @param esfNationals the e s f nationals
	*/
	public void cacheResult(
		java.util.List<it.ethica.esf.model.ESFNational> esfNationals);

	/**
	* Creates a new e s f national with the primary key. Does not add the e s f national to the database.
	*
	* @param esfNationalId the primary key for the new e s f national
	* @return the new e s f national
	*/
	public it.ethica.esf.model.ESFNational create(long esfNationalId);

	/**
	* Removes the e s f national with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfNationalId the primary key of the e s f national
	* @return the e s f national that was removed
	* @throws it.ethica.esf.NoSuchNationalException if a e s f national with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFNational remove(long esfNationalId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalException;

	public it.ethica.esf.model.ESFNational updateImpl(
		it.ethica.esf.model.ESFNational esfNational)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f national with the primary key or throws a {@link it.ethica.esf.NoSuchNationalException} if it could not be found.
	*
	* @param esfNationalId the primary key of the e s f national
	* @return the e s f national
	* @throws it.ethica.esf.NoSuchNationalException if a e s f national with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFNational findByPrimaryKey(long esfNationalId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalException;

	/**
	* Returns the e s f national with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param esfNationalId the primary key of the e s f national
	* @return the e s f national, or <code>null</code> if a e s f national with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFNational fetchByPrimaryKey(long esfNationalId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f nationals.
	*
	* @return the e s f nationals
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFNational> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the e s f nationals.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f nationals
	* @param end the upper bound of the range of e s f nationals (not inclusive)
	* @return the range of e s f nationals
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFNational> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the e s f nationals.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFNationalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f nationals
	* @param end the upper bound of the range of e s f nationals (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of e s f nationals
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFNational> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the e s f nationals from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f nationals.
	*
	* @return the number of e s f nationals
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}