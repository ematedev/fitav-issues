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

import it.ethica.esf.model.ESFSuspensiveShootingDirector;

import java.util.List;

/**
 * The persistence utility for the e s f suspensive shooting director service. This utility wraps {@link ESFSuspensiveShootingDirectorPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFSuspensiveShootingDirectorPersistence
 * @see ESFSuspensiveShootingDirectorPersistenceImpl
 * @generated
 */
public class ESFSuspensiveShootingDirectorUtil {
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
	public static void clearCache(
		ESFSuspensiveShootingDirector esfSuspensiveShootingDirector) {
		getPersistence().clearCache(esfSuspensiveShootingDirector);
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
	public static List<ESFSuspensiveShootingDirector> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ESFSuspensiveShootingDirector> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ESFSuspensiveShootingDirector> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ESFSuspensiveShootingDirector update(
		ESFSuspensiveShootingDirector esfSuspensiveShootingDirector)
		throws SystemException {
		return getPersistence().update(esfSuspensiveShootingDirector);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ESFSuspensiveShootingDirector update(
		ESFSuspensiveShootingDirector esfSuspensiveShootingDirector,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence()
				   .update(esfSuspensiveShootingDirector, serviceContext);
	}

	/**
	* Returns all the e s f suspensive shooting directors where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @return the matching e s f suspensive shooting directors
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFSuspensiveShootingDirector> findBybyUserId(
		java.lang.Long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBybyUserId(esfUserId);
	}

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
	public static java.util.List<it.ethica.esf.model.ESFSuspensiveShootingDirector> findBybyUserId(
		java.lang.Long esfUserId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBybyUserId(esfUserId, start, end);
	}

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
	public static java.util.List<it.ethica.esf.model.ESFSuspensiveShootingDirector> findBybyUserId(
		java.lang.Long esfUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBybyUserId(esfUserId, start, end, orderByComparator);
	}

	/**
	* Returns the first e s f suspensive shooting director in the ordered set where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f suspensive shooting director
	* @throws it.ethica.esf.NoSuchSuspensiveShootingDirectorException if a matching e s f suspensive shooting director could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFSuspensiveShootingDirector findBybyUserId_First(
		java.lang.Long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchSuspensiveShootingDirectorException {
		return getPersistence()
				   .findBybyUserId_First(esfUserId, orderByComparator);
	}

	/**
	* Returns the first e s f suspensive shooting director in the ordered set where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f suspensive shooting director, or <code>null</code> if a matching e s f suspensive shooting director could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFSuspensiveShootingDirector fetchBybyUserId_First(
		java.lang.Long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBybyUserId_First(esfUserId, orderByComparator);
	}

	/**
	* Returns the last e s f suspensive shooting director in the ordered set where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f suspensive shooting director
	* @throws it.ethica.esf.NoSuchSuspensiveShootingDirectorException if a matching e s f suspensive shooting director could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFSuspensiveShootingDirector findBybyUserId_Last(
		java.lang.Long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchSuspensiveShootingDirectorException {
		return getPersistence().findBybyUserId_Last(esfUserId, orderByComparator);
	}

	/**
	* Returns the last e s f suspensive shooting director in the ordered set where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f suspensive shooting director, or <code>null</code> if a matching e s f suspensive shooting director could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFSuspensiveShootingDirector fetchBybyUserId_Last(
		java.lang.Long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBybyUserId_Last(esfUserId, orderByComparator);
	}

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
	public static it.ethica.esf.model.ESFSuspensiveShootingDirector[] findBybyUserId_PrevAndNext(
		long esfSuspensiveShooingDirectorId, java.lang.Long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchSuspensiveShootingDirectorException {
		return getPersistence()
				   .findBybyUserId_PrevAndNext(esfSuspensiveShooingDirectorId,
			esfUserId, orderByComparator);
	}

	/**
	* Removes all the e s f suspensive shooting directors where esfUserId = &#63; from the database.
	*
	* @param esfUserId the esf user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBybyUserId(java.lang.Long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBybyUserId(esfUserId);
	}

	/**
	* Returns the number of e s f suspensive shooting directors where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @return the number of matching e s f suspensive shooting directors
	* @throws SystemException if a system exception occurred
	*/
	public static int countBybyUserId(java.lang.Long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBybyUserId(esfUserId);
	}

	/**
	* Returns all the e s f suspensive shooting directors where esfEndData &gt; &#63; and esfUserId = &#63;.
	*
	* @param esfEndData the esf end data
	* @param esfUserId the esf user ID
	* @return the matching e s f suspensive shooting directors
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFSuspensiveShootingDirector> findByDate(
		java.util.Date esfEndData, java.lang.Long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDate(esfEndData, esfUserId);
	}

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
	public static java.util.List<it.ethica.esf.model.ESFSuspensiveShootingDirector> findByDate(
		java.util.Date esfEndData, java.lang.Long esfUserId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDate(esfEndData, esfUserId, start, end);
	}

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
	public static java.util.List<it.ethica.esf.model.ESFSuspensiveShootingDirector> findByDate(
		java.util.Date esfEndData, java.lang.Long esfUserId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDate(esfEndData, esfUserId, start, end,
			orderByComparator);
	}

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
	public static it.ethica.esf.model.ESFSuspensiveShootingDirector findByDate_First(
		java.util.Date esfEndData, java.lang.Long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchSuspensiveShootingDirectorException {
		return getPersistence()
				   .findByDate_First(esfEndData, esfUserId, orderByComparator);
	}

	/**
	* Returns the first e s f suspensive shooting director in the ordered set where esfEndData &gt; &#63; and esfUserId = &#63;.
	*
	* @param esfEndData the esf end data
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f suspensive shooting director, or <code>null</code> if a matching e s f suspensive shooting director could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFSuspensiveShootingDirector fetchByDate_First(
		java.util.Date esfEndData, java.lang.Long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByDate_First(esfEndData, esfUserId, orderByComparator);
	}

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
	public static it.ethica.esf.model.ESFSuspensiveShootingDirector findByDate_Last(
		java.util.Date esfEndData, java.lang.Long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchSuspensiveShootingDirectorException {
		return getPersistence()
				   .findByDate_Last(esfEndData, esfUserId, orderByComparator);
	}

	/**
	* Returns the last e s f suspensive shooting director in the ordered set where esfEndData &gt; &#63; and esfUserId = &#63;.
	*
	* @param esfEndData the esf end data
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f suspensive shooting director, or <code>null</code> if a matching e s f suspensive shooting director could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFSuspensiveShootingDirector fetchByDate_Last(
		java.util.Date esfEndData, java.lang.Long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByDate_Last(esfEndData, esfUserId, orderByComparator);
	}

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
	public static it.ethica.esf.model.ESFSuspensiveShootingDirector[] findByDate_PrevAndNext(
		long esfSuspensiveShooingDirectorId, java.util.Date esfEndData,
		java.lang.Long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchSuspensiveShootingDirectorException {
		return getPersistence()
				   .findByDate_PrevAndNext(esfSuspensiveShooingDirectorId,
			esfEndData, esfUserId, orderByComparator);
	}

	/**
	* Removes all the e s f suspensive shooting directors where esfEndData &gt; &#63; and esfUserId = &#63; from the database.
	*
	* @param esfEndData the esf end data
	* @param esfUserId the esf user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByDate(java.util.Date esfEndData,
		java.lang.Long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByDate(esfEndData, esfUserId);
	}

	/**
	* Returns the number of e s f suspensive shooting directors where esfEndData &gt; &#63; and esfUserId = &#63;.
	*
	* @param esfEndData the esf end data
	* @param esfUserId the esf user ID
	* @return the number of matching e s f suspensive shooting directors
	* @throws SystemException if a system exception occurred
	*/
	public static int countByDate(java.util.Date esfEndData,
		java.lang.Long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByDate(esfEndData, esfUserId);
	}

	/**
	* Caches the e s f suspensive shooting director in the entity cache if it is enabled.
	*
	* @param esfSuspensiveShootingDirector the e s f suspensive shooting director
	*/
	public static void cacheResult(
		it.ethica.esf.model.ESFSuspensiveShootingDirector esfSuspensiveShootingDirector) {
		getPersistence().cacheResult(esfSuspensiveShootingDirector);
	}

	/**
	* Caches the e s f suspensive shooting directors in the entity cache if it is enabled.
	*
	* @param esfSuspensiveShootingDirectors the e s f suspensive shooting directors
	*/
	public static void cacheResult(
		java.util.List<it.ethica.esf.model.ESFSuspensiveShootingDirector> esfSuspensiveShootingDirectors) {
		getPersistence().cacheResult(esfSuspensiveShootingDirectors);
	}

	/**
	* Creates a new e s f suspensive shooting director with the primary key. Does not add the e s f suspensive shooting director to the database.
	*
	* @param esfSuspensiveShooingDirectorId the primary key for the new e s f suspensive shooting director
	* @return the new e s f suspensive shooting director
	*/
	public static it.ethica.esf.model.ESFSuspensiveShootingDirector create(
		long esfSuspensiveShooingDirectorId) {
		return getPersistence().create(esfSuspensiveShooingDirectorId);
	}

	/**
	* Removes the e s f suspensive shooting director with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfSuspensiveShooingDirectorId the primary key of the e s f suspensive shooting director
	* @return the e s f suspensive shooting director that was removed
	* @throws it.ethica.esf.NoSuchSuspensiveShootingDirectorException if a e s f suspensive shooting director with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFSuspensiveShootingDirector remove(
		long esfSuspensiveShooingDirectorId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchSuspensiveShootingDirectorException {
		return getPersistence().remove(esfSuspensiveShooingDirectorId);
	}

	public static it.ethica.esf.model.ESFSuspensiveShootingDirector updateImpl(
		it.ethica.esf.model.ESFSuspensiveShootingDirector esfSuspensiveShootingDirector)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(esfSuspensiveShootingDirector);
	}

	/**
	* Returns the e s f suspensive shooting director with the primary key or throws a {@link it.ethica.esf.NoSuchSuspensiveShootingDirectorException} if it could not be found.
	*
	* @param esfSuspensiveShooingDirectorId the primary key of the e s f suspensive shooting director
	* @return the e s f suspensive shooting director
	* @throws it.ethica.esf.NoSuchSuspensiveShootingDirectorException if a e s f suspensive shooting director with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFSuspensiveShootingDirector findByPrimaryKey(
		long esfSuspensiveShooingDirectorId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchSuspensiveShootingDirectorException {
		return getPersistence().findByPrimaryKey(esfSuspensiveShooingDirectorId);
	}

	/**
	* Returns the e s f suspensive shooting director with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param esfSuspensiveShooingDirectorId the primary key of the e s f suspensive shooting director
	* @return the e s f suspensive shooting director, or <code>null</code> if a e s f suspensive shooting director with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFSuspensiveShootingDirector fetchByPrimaryKey(
		long esfSuspensiveShooingDirectorId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(esfSuspensiveShooingDirectorId);
	}

	/**
	* Returns all the e s f suspensive shooting directors.
	*
	* @return the e s f suspensive shooting directors
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFSuspensiveShootingDirector> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<it.ethica.esf.model.ESFSuspensiveShootingDirector> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<it.ethica.esf.model.ESFSuspensiveShootingDirector> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the e s f suspensive shooting directors from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of e s f suspensive shooting directors.
	*
	* @return the number of e s f suspensive shooting directors
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ESFSuspensiveShootingDirectorPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ESFSuspensiveShootingDirectorPersistence)PortletBeanLocatorUtil.locate(it.ethica.esf.service.ClpSerializer.getServletContextName(),
					ESFSuspensiveShootingDirectorPersistence.class.getName());

			ReferenceRegistry.registerReference(ESFSuspensiveShootingDirectorUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(
		ESFSuspensiveShootingDirectorPersistence persistence) {
	}

	private static ESFSuspensiveShootingDirectorPersistence _persistence;
}