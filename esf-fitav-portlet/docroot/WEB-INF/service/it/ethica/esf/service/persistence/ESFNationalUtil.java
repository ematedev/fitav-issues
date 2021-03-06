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

import it.ethica.esf.model.ESFNational;

import java.util.List;

/**
 * The persistence utility for the e s f national service. This utility wraps {@link ESFNationalPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFNationalPersistence
 * @see ESFNationalPersistenceImpl
 * @generated
 */
public class ESFNationalUtil {
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
	public static void clearCache(ESFNational esfNational) {
		getPersistence().clearCache(esfNational);
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
	public static List<ESFNational> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ESFNational> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ESFNational> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ESFNational update(ESFNational esfNational)
		throws SystemException {
		return getPersistence().update(esfNational);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ESFNational update(ESFNational esfNational,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(esfNational, serviceContext);
	}

	/**
	* Returns all the e s f nationals where endDate &gt; &#63;.
	*
	* @param endDate the end date
	* @return the matching e s f nationals
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFNational> findByEndDate(
		java.util.Date endDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByEndDate(endDate);
	}

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
	public static java.util.List<it.ethica.esf.model.ESFNational> findByEndDate(
		java.util.Date endDate, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByEndDate(endDate, start, end);
	}

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
	public static java.util.List<it.ethica.esf.model.ESFNational> findByEndDate(
		java.util.Date endDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByEndDate(endDate, start, end, orderByComparator);
	}

	/**
	* Returns the first e s f national in the ordered set where endDate &gt; &#63;.
	*
	* @param endDate the end date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f national
	* @throws it.ethica.esf.NoSuchNationalException if a matching e s f national could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNational findByEndDate_First(
		java.util.Date endDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalException {
		return getPersistence().findByEndDate_First(endDate, orderByComparator);
	}

	/**
	* Returns the first e s f national in the ordered set where endDate &gt; &#63;.
	*
	* @param endDate the end date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f national, or <code>null</code> if a matching e s f national could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNational fetchByEndDate_First(
		java.util.Date endDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByEndDate_First(endDate, orderByComparator);
	}

	/**
	* Returns the last e s f national in the ordered set where endDate &gt; &#63;.
	*
	* @param endDate the end date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f national
	* @throws it.ethica.esf.NoSuchNationalException if a matching e s f national could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNational findByEndDate_Last(
		java.util.Date endDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalException {
		return getPersistence().findByEndDate_Last(endDate, orderByComparator);
	}

	/**
	* Returns the last e s f national in the ordered set where endDate &gt; &#63;.
	*
	* @param endDate the end date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f national, or <code>null</code> if a matching e s f national could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNational fetchByEndDate_Last(
		java.util.Date endDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByEndDate_Last(endDate, orderByComparator);
	}

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
	public static it.ethica.esf.model.ESFNational[] findByEndDate_PrevAndNext(
		long esfNationalId, java.util.Date endDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalException {
		return getPersistence()
				   .findByEndDate_PrevAndNext(esfNationalId, endDate,
			orderByComparator);
	}

	/**
	* Removes all the e s f nationals where endDate &gt; &#63; from the database.
	*
	* @param endDate the end date
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByEndDate(java.util.Date endDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByEndDate(endDate);
	}

	/**
	* Returns the number of e s f nationals where endDate &gt; &#63;.
	*
	* @param endDate the end date
	* @return the number of matching e s f nationals
	* @throws SystemException if a system exception occurred
	*/
	public static int countByEndDate(java.util.Date endDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByEndDate(endDate);
	}

	/**
	* Returns all the e s f nationals where endDate &gt; &#63; and esfSportTypeId = &#63;.
	*
	* @param endDate the end date
	* @param esfSportTypeId the esf sport type ID
	* @return the matching e s f nationals
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFNational> findByE_E(
		java.util.Date endDate, long esfSportTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByE_E(endDate, esfSportTypeId);
	}

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
	public static java.util.List<it.ethica.esf.model.ESFNational> findByE_E(
		java.util.Date endDate, long esfSportTypeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByE_E(endDate, esfSportTypeId, start, end);
	}

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
	public static java.util.List<it.ethica.esf.model.ESFNational> findByE_E(
		java.util.Date endDate, long esfSportTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByE_E(endDate, esfSportTypeId, start, end,
			orderByComparator);
	}

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
	public static it.ethica.esf.model.ESFNational findByE_E_First(
		java.util.Date endDate, long esfSportTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalException {
		return getPersistence()
				   .findByE_E_First(endDate, esfSportTypeId, orderByComparator);
	}

	/**
	* Returns the first e s f national in the ordered set where endDate &gt; &#63; and esfSportTypeId = &#63;.
	*
	* @param endDate the end date
	* @param esfSportTypeId the esf sport type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f national, or <code>null</code> if a matching e s f national could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNational fetchByE_E_First(
		java.util.Date endDate, long esfSportTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByE_E_First(endDate, esfSportTypeId, orderByComparator);
	}

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
	public static it.ethica.esf.model.ESFNational findByE_E_Last(
		java.util.Date endDate, long esfSportTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalException {
		return getPersistence()
				   .findByE_E_Last(endDate, esfSportTypeId, orderByComparator);
	}

	/**
	* Returns the last e s f national in the ordered set where endDate &gt; &#63; and esfSportTypeId = &#63;.
	*
	* @param endDate the end date
	* @param esfSportTypeId the esf sport type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f national, or <code>null</code> if a matching e s f national could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNational fetchByE_E_Last(
		java.util.Date endDate, long esfSportTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByE_E_Last(endDate, esfSportTypeId, orderByComparator);
	}

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
	public static it.ethica.esf.model.ESFNational[] findByE_E_PrevAndNext(
		long esfNationalId, java.util.Date endDate, long esfSportTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalException {
		return getPersistence()
				   .findByE_E_PrevAndNext(esfNationalId, endDate,
			esfSportTypeId, orderByComparator);
	}

	/**
	* Removes all the e s f nationals where endDate &gt; &#63; and esfSportTypeId = &#63; from the database.
	*
	* @param endDate the end date
	* @param esfSportTypeId the esf sport type ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByE_E(java.util.Date endDate, long esfSportTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByE_E(endDate, esfSportTypeId);
	}

	/**
	* Returns the number of e s f nationals where endDate &gt; &#63; and esfSportTypeId = &#63;.
	*
	* @param endDate the end date
	* @param esfSportTypeId the esf sport type ID
	* @return the number of matching e s f nationals
	* @throws SystemException if a system exception occurred
	*/
	public static int countByE_E(java.util.Date endDate, long esfSportTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByE_E(endDate, esfSportTypeId);
	}

	/**
	* Returns all the e s f nationals where endDate &gt; &#63; and esfUserId = &#63;.
	*
	* @param endDate the end date
	* @param esfUserId the esf user ID
	* @return the matching e s f nationals
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFNational> findByU_E(
		java.util.Date endDate, long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByU_E(endDate, esfUserId);
	}

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
	public static java.util.List<it.ethica.esf.model.ESFNational> findByU_E(
		java.util.Date endDate, long esfUserId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByU_E(endDate, esfUserId, start, end);
	}

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
	public static java.util.List<it.ethica.esf.model.ESFNational> findByU_E(
		java.util.Date endDate, long esfUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByU_E(endDate, esfUserId, start, end, orderByComparator);
	}

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
	public static it.ethica.esf.model.ESFNational findByU_E_First(
		java.util.Date endDate, long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalException {
		return getPersistence()
				   .findByU_E_First(endDate, esfUserId, orderByComparator);
	}

	/**
	* Returns the first e s f national in the ordered set where endDate &gt; &#63; and esfUserId = &#63;.
	*
	* @param endDate the end date
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f national, or <code>null</code> if a matching e s f national could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNational fetchByU_E_First(
		java.util.Date endDate, long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByU_E_First(endDate, esfUserId, orderByComparator);
	}

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
	public static it.ethica.esf.model.ESFNational findByU_E_Last(
		java.util.Date endDate, long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalException {
		return getPersistence()
				   .findByU_E_Last(endDate, esfUserId, orderByComparator);
	}

	/**
	* Returns the last e s f national in the ordered set where endDate &gt; &#63; and esfUserId = &#63;.
	*
	* @param endDate the end date
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f national, or <code>null</code> if a matching e s f national could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNational fetchByU_E_Last(
		java.util.Date endDate, long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByU_E_Last(endDate, esfUserId, orderByComparator);
	}

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
	public static it.ethica.esf.model.ESFNational[] findByU_E_PrevAndNext(
		long esfNationalId, java.util.Date endDate, long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalException {
		return getPersistence()
				   .findByU_E_PrevAndNext(esfNationalId, endDate, esfUserId,
			orderByComparator);
	}

	/**
	* Removes all the e s f nationals where endDate &gt; &#63; and esfUserId = &#63; from the database.
	*
	* @param endDate the end date
	* @param esfUserId the esf user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByU_E(java.util.Date endDate, long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByU_E(endDate, esfUserId);
	}

	/**
	* Returns the number of e s f nationals where endDate &gt; &#63; and esfUserId = &#63;.
	*
	* @param endDate the end date
	* @param esfUserId the esf user ID
	* @return the number of matching e s f nationals
	* @throws SystemException if a system exception occurred
	*/
	public static int countByU_E(java.util.Date endDate, long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByU_E(endDate, esfUserId);
	}

	/**
	* Returns all the e s f nationals where startDate &ge; &#63; and endDate &le; &#63; and esfSportTypeId = &#63;.
	*
	* @param startDate the start date
	* @param endDate the end date
	* @param esfSportTypeId the esf sport type ID
	* @return the matching e s f nationals
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFNational> findBybyStartDateEndDateTypeSportId(
		java.util.Date startDate, java.util.Date endDate, long esfSportTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBybyStartDateEndDateTypeSportId(startDate, endDate,
			esfSportTypeId);
	}

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
	public static java.util.List<it.ethica.esf.model.ESFNational> findBybyStartDateEndDateTypeSportId(
		java.util.Date startDate, java.util.Date endDate, long esfSportTypeId,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBybyStartDateEndDateTypeSportId(startDate, endDate,
			esfSportTypeId, start, end);
	}

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
	public static java.util.List<it.ethica.esf.model.ESFNational> findBybyStartDateEndDateTypeSportId(
		java.util.Date startDate, java.util.Date endDate, long esfSportTypeId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBybyStartDateEndDateTypeSportId(startDate, endDate,
			esfSportTypeId, start, end, orderByComparator);
	}

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
	public static it.ethica.esf.model.ESFNational findBybyStartDateEndDateTypeSportId_First(
		java.util.Date startDate, java.util.Date endDate, long esfSportTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalException {
		return getPersistence()
				   .findBybyStartDateEndDateTypeSportId_First(startDate,
			endDate, esfSportTypeId, orderByComparator);
	}

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
	public static it.ethica.esf.model.ESFNational fetchBybyStartDateEndDateTypeSportId_First(
		java.util.Date startDate, java.util.Date endDate, long esfSportTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBybyStartDateEndDateTypeSportId_First(startDate,
			endDate, esfSportTypeId, orderByComparator);
	}

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
	public static it.ethica.esf.model.ESFNational findBybyStartDateEndDateTypeSportId_Last(
		java.util.Date startDate, java.util.Date endDate, long esfSportTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalException {
		return getPersistence()
				   .findBybyStartDateEndDateTypeSportId_Last(startDate,
			endDate, esfSportTypeId, orderByComparator);
	}

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
	public static it.ethica.esf.model.ESFNational fetchBybyStartDateEndDateTypeSportId_Last(
		java.util.Date startDate, java.util.Date endDate, long esfSportTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBybyStartDateEndDateTypeSportId_Last(startDate,
			endDate, esfSportTypeId, orderByComparator);
	}

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
	public static it.ethica.esf.model.ESFNational[] findBybyStartDateEndDateTypeSportId_PrevAndNext(
		long esfNationalId, java.util.Date startDate, java.util.Date endDate,
		long esfSportTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalException {
		return getPersistence()
				   .findBybyStartDateEndDateTypeSportId_PrevAndNext(esfNationalId,
			startDate, endDate, esfSportTypeId, orderByComparator);
	}

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
	public static java.util.List<it.ethica.esf.model.ESFNational> findBybyStartDateEndDateTypeSportId(
		java.util.Date[] startDates, java.util.Date[] endDates,
		long esfSportTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBybyStartDateEndDateTypeSportId(startDates, endDates,
			esfSportTypeId);
	}

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
	public static java.util.List<it.ethica.esf.model.ESFNational> findBybyStartDateEndDateTypeSportId(
		java.util.Date[] startDates, java.util.Date[] endDates,
		long esfSportTypeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBybyStartDateEndDateTypeSportId(startDates, endDates,
			esfSportTypeId, start, end);
	}

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
	public static java.util.List<it.ethica.esf.model.ESFNational> findBybyStartDateEndDateTypeSportId(
		java.util.Date[] startDates, java.util.Date[] endDates,
		long esfSportTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBybyStartDateEndDateTypeSportId(startDates, endDates,
			esfSportTypeId, start, end, orderByComparator);
	}

	/**
	* Removes all the e s f nationals where startDate &ge; &#63; and endDate &le; &#63; and esfSportTypeId = &#63; from the database.
	*
	* @param startDate the start date
	* @param endDate the end date
	* @param esfSportTypeId the esf sport type ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBybyStartDateEndDateTypeSportId(
		java.util.Date startDate, java.util.Date endDate, long esfSportTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeBybyStartDateEndDateTypeSportId(startDate, endDate,
			esfSportTypeId);
	}

	/**
	* Returns the number of e s f nationals where startDate &ge; &#63; and endDate &le; &#63; and esfSportTypeId = &#63;.
	*
	* @param startDate the start date
	* @param endDate the end date
	* @param esfSportTypeId the esf sport type ID
	* @return the number of matching e s f nationals
	* @throws SystemException if a system exception occurred
	*/
	public static int countBybyStartDateEndDateTypeSportId(
		java.util.Date startDate, java.util.Date endDate, long esfSportTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countBybyStartDateEndDateTypeSportId(startDate, endDate,
			esfSportTypeId);
	}

	/**
	* Returns the number of e s f nationals where startDate &ge; all &#63; and endDate &le; all &#63; and esfSportTypeId = &#63;.
	*
	* @param startDates the start dates
	* @param endDates the end dates
	* @param esfSportTypeId the esf sport type ID
	* @return the number of matching e s f nationals
	* @throws SystemException if a system exception occurred
	*/
	public static int countBybyStartDateEndDateTypeSportId(
		java.util.Date[] startDates, java.util.Date[] endDates,
		long esfSportTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countBybyStartDateEndDateTypeSportId(startDates, endDates,
			esfSportTypeId);
	}

	/**
	* Caches the e s f national in the entity cache if it is enabled.
	*
	* @param esfNational the e s f national
	*/
	public static void cacheResult(it.ethica.esf.model.ESFNational esfNational) {
		getPersistence().cacheResult(esfNational);
	}

	/**
	* Caches the e s f nationals in the entity cache if it is enabled.
	*
	* @param esfNationals the e s f nationals
	*/
	public static void cacheResult(
		java.util.List<it.ethica.esf.model.ESFNational> esfNationals) {
		getPersistence().cacheResult(esfNationals);
	}

	/**
	* Creates a new e s f national with the primary key. Does not add the e s f national to the database.
	*
	* @param esfNationalId the primary key for the new e s f national
	* @return the new e s f national
	*/
	public static it.ethica.esf.model.ESFNational create(long esfNationalId) {
		return getPersistence().create(esfNationalId);
	}

	/**
	* Removes the e s f national with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfNationalId the primary key of the e s f national
	* @return the e s f national that was removed
	* @throws it.ethica.esf.NoSuchNationalException if a e s f national with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNational remove(long esfNationalId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalException {
		return getPersistence().remove(esfNationalId);
	}

	public static it.ethica.esf.model.ESFNational updateImpl(
		it.ethica.esf.model.ESFNational esfNational)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(esfNational);
	}

	/**
	* Returns the e s f national with the primary key or throws a {@link it.ethica.esf.NoSuchNationalException} if it could not be found.
	*
	* @param esfNationalId the primary key of the e s f national
	* @return the e s f national
	* @throws it.ethica.esf.NoSuchNationalException if a e s f national with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNational findByPrimaryKey(
		long esfNationalId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchNationalException {
		return getPersistence().findByPrimaryKey(esfNationalId);
	}

	/**
	* Returns the e s f national with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param esfNationalId the primary key of the e s f national
	* @return the e s f national, or <code>null</code> if a e s f national with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFNational fetchByPrimaryKey(
		long esfNationalId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(esfNationalId);
	}

	/**
	* Returns all the e s f nationals.
	*
	* @return the e s f nationals
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFNational> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<it.ethica.esf.model.ESFNational> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<it.ethica.esf.model.ESFNational> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the e s f nationals from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of e s f nationals.
	*
	* @return the number of e s f nationals
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ESFNationalPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ESFNationalPersistence)PortletBeanLocatorUtil.locate(it.ethica.esf.service.ClpSerializer.getServletContextName(),
					ESFNationalPersistence.class.getName());

			ReferenceRegistry.registerReference(ESFNationalUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ESFNationalPersistence persistence) {
	}

	private static ESFNationalPersistence _persistence;
}