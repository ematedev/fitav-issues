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

import it.ethica.esf.model.ESFShootingDirector;

import java.util.List;

/**
 * The persistence utility for the e s f shooting director service. This utility wraps {@link ESFShootingDirectorPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFShootingDirectorPersistence
 * @see ESFShootingDirectorPersistenceImpl
 * @generated
 */
public class ESFShootingDirectorUtil {
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
	public static void clearCache(ESFShootingDirector esfShootingDirector) {
		getPersistence().clearCache(esfShootingDirector);
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
	public static List<ESFShootingDirector> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ESFShootingDirector> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ESFShootingDirector> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ESFShootingDirector update(
		ESFShootingDirector esfShootingDirector) throws SystemException {
		return getPersistence().update(esfShootingDirector);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ESFShootingDirector update(
		ESFShootingDirector esfShootingDirector, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(esfShootingDirector, serviceContext);
	}

	/**
	* Returns all the e s f shooting directors where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @return the matching e s f shooting directors
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFShootingDirector> findBybyUserId(
		long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBybyUserId(esfUserId);
	}

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
	public static java.util.List<it.ethica.esf.model.ESFShootingDirector> findBybyUserId(
		long esfUserId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBybyUserId(esfUserId, start, end);
	}

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
	public static java.util.List<it.ethica.esf.model.ESFShootingDirector> findBybyUserId(
		long esfUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBybyUserId(esfUserId, start, end, orderByComparator);
	}

	/**
	* Returns the first e s f shooting director in the ordered set where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f shooting director
	* @throws it.ethica.esf.NoSuchShootingDirectorException if a matching e s f shooting director could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFShootingDirector findBybyUserId_First(
		long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchShootingDirectorException {
		return getPersistence()
				   .findBybyUserId_First(esfUserId, orderByComparator);
	}

	/**
	* Returns the first e s f shooting director in the ordered set where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f shooting director, or <code>null</code> if a matching e s f shooting director could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFShootingDirector fetchBybyUserId_First(
		long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBybyUserId_First(esfUserId, orderByComparator);
	}

	/**
	* Returns the last e s f shooting director in the ordered set where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f shooting director
	* @throws it.ethica.esf.NoSuchShootingDirectorException if a matching e s f shooting director could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFShootingDirector findBybyUserId_Last(
		long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchShootingDirectorException {
		return getPersistence().findBybyUserId_Last(esfUserId, orderByComparator);
	}

	/**
	* Returns the last e s f shooting director in the ordered set where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f shooting director, or <code>null</code> if a matching e s f shooting director could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFShootingDirector fetchBybyUserId_Last(
		long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBybyUserId_Last(esfUserId, orderByComparator);
	}

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
	public static it.ethica.esf.model.ESFShootingDirector[] findBybyUserId_PrevAndNext(
		long esfShootingDirectorId, long esfUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchShootingDirectorException {
		return getPersistence()
				   .findBybyUserId_PrevAndNext(esfShootingDirectorId,
			esfUserId, orderByComparator);
	}

	/**
	* Removes all the e s f shooting directors where esfUserId = &#63; from the database.
	*
	* @param esfUserId the esf user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBybyUserId(long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBybyUserId(esfUserId);
	}

	/**
	* Returns the number of e s f shooting directors where esfUserId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @return the number of matching e s f shooting directors
	* @throws SystemException if a system exception occurred
	*/
	public static int countBybyUserId(long esfUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBybyUserId(esfUserId);
	}

	/**
	* Returns all the e s f shooting directors where shootingDirectorQualificationId = &#63;.
	*
	* @param shootingDirectorQualificationId the shooting director qualification ID
	* @return the matching e s f shooting directors
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFShootingDirector> findBybyShootingDirectorQualificationId(
		long shootingDirectorQualificationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBybyShootingDirectorQualificationId(shootingDirectorQualificationId);
	}

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
	public static java.util.List<it.ethica.esf.model.ESFShootingDirector> findBybyShootingDirectorQualificationId(
		long shootingDirectorQualificationId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBybyShootingDirectorQualificationId(shootingDirectorQualificationId,
			start, end);
	}

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
	public static java.util.List<it.ethica.esf.model.ESFShootingDirector> findBybyShootingDirectorQualificationId(
		long shootingDirectorQualificationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBybyShootingDirectorQualificationId(shootingDirectorQualificationId,
			start, end, orderByComparator);
	}

	/**
	* Returns the first e s f shooting director in the ordered set where shootingDirectorQualificationId = &#63;.
	*
	* @param shootingDirectorQualificationId the shooting director qualification ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f shooting director
	* @throws it.ethica.esf.NoSuchShootingDirectorException if a matching e s f shooting director could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFShootingDirector findBybyShootingDirectorQualificationId_First(
		long shootingDirectorQualificationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchShootingDirectorException {
		return getPersistence()
				   .findBybyShootingDirectorQualificationId_First(shootingDirectorQualificationId,
			orderByComparator);
	}

	/**
	* Returns the first e s f shooting director in the ordered set where shootingDirectorQualificationId = &#63;.
	*
	* @param shootingDirectorQualificationId the shooting director qualification ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f shooting director, or <code>null</code> if a matching e s f shooting director could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFShootingDirector fetchBybyShootingDirectorQualificationId_First(
		long shootingDirectorQualificationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBybyShootingDirectorQualificationId_First(shootingDirectorQualificationId,
			orderByComparator);
	}

	/**
	* Returns the last e s f shooting director in the ordered set where shootingDirectorQualificationId = &#63;.
	*
	* @param shootingDirectorQualificationId the shooting director qualification ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f shooting director
	* @throws it.ethica.esf.NoSuchShootingDirectorException if a matching e s f shooting director could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFShootingDirector findBybyShootingDirectorQualificationId_Last(
		long shootingDirectorQualificationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchShootingDirectorException {
		return getPersistence()
				   .findBybyShootingDirectorQualificationId_Last(shootingDirectorQualificationId,
			orderByComparator);
	}

	/**
	* Returns the last e s f shooting director in the ordered set where shootingDirectorQualificationId = &#63;.
	*
	* @param shootingDirectorQualificationId the shooting director qualification ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f shooting director, or <code>null</code> if a matching e s f shooting director could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFShootingDirector fetchBybyShootingDirectorQualificationId_Last(
		long shootingDirectorQualificationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBybyShootingDirectorQualificationId_Last(shootingDirectorQualificationId,
			orderByComparator);
	}

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
	public static it.ethica.esf.model.ESFShootingDirector[] findBybyShootingDirectorQualificationId_PrevAndNext(
		long esfShootingDirectorId, long shootingDirectorQualificationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchShootingDirectorException {
		return getPersistence()
				   .findBybyShootingDirectorQualificationId_PrevAndNext(esfShootingDirectorId,
			shootingDirectorQualificationId, orderByComparator);
	}

	/**
	* Removes all the e s f shooting directors where shootingDirectorQualificationId = &#63; from the database.
	*
	* @param shootingDirectorQualificationId the shooting director qualification ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBybyShootingDirectorQualificationId(
		long shootingDirectorQualificationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeBybyShootingDirectorQualificationId(shootingDirectorQualificationId);
	}

	/**
	* Returns the number of e s f shooting directors where shootingDirectorQualificationId = &#63;.
	*
	* @param shootingDirectorQualificationId the shooting director qualification ID
	* @return the number of matching e s f shooting directors
	* @throws SystemException if a system exception occurred
	*/
	public static int countBybyShootingDirectorQualificationId(
		long shootingDirectorQualificationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countBybyShootingDirectorQualificationId(shootingDirectorQualificationId);
	}

	/**
	* Returns all the e s f shooting directors where sportTypeId = &#63;.
	*
	* @param sportTypeId the sport type ID
	* @return the matching e s f shooting directors
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFShootingDirector> findBybySportTypeId(
		long sportTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBybySportTypeId(sportTypeId);
	}

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
	public static java.util.List<it.ethica.esf.model.ESFShootingDirector> findBybySportTypeId(
		long sportTypeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBybySportTypeId(sportTypeId, start, end);
	}

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
	public static java.util.List<it.ethica.esf.model.ESFShootingDirector> findBybySportTypeId(
		long sportTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBybySportTypeId(sportTypeId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first e s f shooting director in the ordered set where sportTypeId = &#63;.
	*
	* @param sportTypeId the sport type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f shooting director
	* @throws it.ethica.esf.NoSuchShootingDirectorException if a matching e s f shooting director could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFShootingDirector findBybySportTypeId_First(
		long sportTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchShootingDirectorException {
		return getPersistence()
				   .findBybySportTypeId_First(sportTypeId, orderByComparator);
	}

	/**
	* Returns the first e s f shooting director in the ordered set where sportTypeId = &#63;.
	*
	* @param sportTypeId the sport type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f shooting director, or <code>null</code> if a matching e s f shooting director could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFShootingDirector fetchBybySportTypeId_First(
		long sportTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBybySportTypeId_First(sportTypeId, orderByComparator);
	}

	/**
	* Returns the last e s f shooting director in the ordered set where sportTypeId = &#63;.
	*
	* @param sportTypeId the sport type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f shooting director
	* @throws it.ethica.esf.NoSuchShootingDirectorException if a matching e s f shooting director could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFShootingDirector findBybySportTypeId_Last(
		long sportTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchShootingDirectorException {
		return getPersistence()
				   .findBybySportTypeId_Last(sportTypeId, orderByComparator);
	}

	/**
	* Returns the last e s f shooting director in the ordered set where sportTypeId = &#63;.
	*
	* @param sportTypeId the sport type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f shooting director, or <code>null</code> if a matching e s f shooting director could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFShootingDirector fetchBybySportTypeId_Last(
		long sportTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBybySportTypeId_Last(sportTypeId, orderByComparator);
	}

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
	public static it.ethica.esf.model.ESFShootingDirector[] findBybySportTypeId_PrevAndNext(
		long esfShootingDirectorId, long sportTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchShootingDirectorException {
		return getPersistence()
				   .findBybySportTypeId_PrevAndNext(esfShootingDirectorId,
			sportTypeId, orderByComparator);
	}

	/**
	* Removes all the e s f shooting directors where sportTypeId = &#63; from the database.
	*
	* @param sportTypeId the sport type ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBybySportTypeId(long sportTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBybySportTypeId(sportTypeId);
	}

	/**
	* Returns the number of e s f shooting directors where sportTypeId = &#63;.
	*
	* @param sportTypeId the sport type ID
	* @return the number of matching e s f shooting directors
	* @throws SystemException if a system exception occurred
	*/
	public static int countBybySportTypeId(long sportTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBybySportTypeId(sportTypeId);
	}

	/**
	* Returns all the e s f shooting directors where regionId = &#63;.
	*
	* @param regionId the region ID
	* @return the matching e s f shooting directors
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFShootingDirector> findBybyRegionId(
		java.lang.String regionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBybyRegionId(regionId);
	}

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
	public static java.util.List<it.ethica.esf.model.ESFShootingDirector> findBybyRegionId(
		java.lang.String regionId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBybyRegionId(regionId, start, end);
	}

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
	public static java.util.List<it.ethica.esf.model.ESFShootingDirector> findBybyRegionId(
		java.lang.String regionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBybyRegionId(regionId, start, end, orderByComparator);
	}

	/**
	* Returns the first e s f shooting director in the ordered set where regionId = &#63;.
	*
	* @param regionId the region ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f shooting director
	* @throws it.ethica.esf.NoSuchShootingDirectorException if a matching e s f shooting director could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFShootingDirector findBybyRegionId_First(
		java.lang.String regionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchShootingDirectorException {
		return getPersistence()
				   .findBybyRegionId_First(regionId, orderByComparator);
	}

	/**
	* Returns the first e s f shooting director in the ordered set where regionId = &#63;.
	*
	* @param regionId the region ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f shooting director, or <code>null</code> if a matching e s f shooting director could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFShootingDirector fetchBybyRegionId_First(
		java.lang.String regionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBybyRegionId_First(regionId, orderByComparator);
	}

	/**
	* Returns the last e s f shooting director in the ordered set where regionId = &#63;.
	*
	* @param regionId the region ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f shooting director
	* @throws it.ethica.esf.NoSuchShootingDirectorException if a matching e s f shooting director could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFShootingDirector findBybyRegionId_Last(
		java.lang.String regionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchShootingDirectorException {
		return getPersistence()
				   .findBybyRegionId_Last(regionId, orderByComparator);
	}

	/**
	* Returns the last e s f shooting director in the ordered set where regionId = &#63;.
	*
	* @param regionId the region ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f shooting director, or <code>null</code> if a matching e s f shooting director could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFShootingDirector fetchBybyRegionId_Last(
		java.lang.String regionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBybyRegionId_Last(regionId, orderByComparator);
	}

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
	public static it.ethica.esf.model.ESFShootingDirector[] findBybyRegionId_PrevAndNext(
		long esfShootingDirectorId, java.lang.String regionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchShootingDirectorException {
		return getPersistence()
				   .findBybyRegionId_PrevAndNext(esfShootingDirectorId,
			regionId, orderByComparator);
	}

	/**
	* Removes all the e s f shooting directors where regionId = &#63; from the database.
	*
	* @param regionId the region ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBybyRegionId(java.lang.String regionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBybyRegionId(regionId);
	}

	/**
	* Returns the number of e s f shooting directors where regionId = &#63;.
	*
	* @param regionId the region ID
	* @return the number of matching e s f shooting directors
	* @throws SystemException if a system exception occurred
	*/
	public static int countBybyRegionId(java.lang.String regionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBybyRegionId(regionId);
	}

	/**
	* Returns all the e s f shooting directors where provinceId = &#63;.
	*
	* @param provinceId the province ID
	* @return the matching e s f shooting directors
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFShootingDirector> findBybyProvinceId(
		java.lang.String provinceId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBybyProvinceId(provinceId);
	}

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
	public static java.util.List<it.ethica.esf.model.ESFShootingDirector> findBybyProvinceId(
		java.lang.String provinceId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBybyProvinceId(provinceId, start, end);
	}

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
	public static java.util.List<it.ethica.esf.model.ESFShootingDirector> findBybyProvinceId(
		java.lang.String provinceId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBybyProvinceId(provinceId, start, end, orderByComparator);
	}

	/**
	* Returns the first e s f shooting director in the ordered set where provinceId = &#63;.
	*
	* @param provinceId the province ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f shooting director
	* @throws it.ethica.esf.NoSuchShootingDirectorException if a matching e s f shooting director could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFShootingDirector findBybyProvinceId_First(
		java.lang.String provinceId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchShootingDirectorException {
		return getPersistence()
				   .findBybyProvinceId_First(provinceId, orderByComparator);
	}

	/**
	* Returns the first e s f shooting director in the ordered set where provinceId = &#63;.
	*
	* @param provinceId the province ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f shooting director, or <code>null</code> if a matching e s f shooting director could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFShootingDirector fetchBybyProvinceId_First(
		java.lang.String provinceId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBybyProvinceId_First(provinceId, orderByComparator);
	}

	/**
	* Returns the last e s f shooting director in the ordered set where provinceId = &#63;.
	*
	* @param provinceId the province ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f shooting director
	* @throws it.ethica.esf.NoSuchShootingDirectorException if a matching e s f shooting director could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFShootingDirector findBybyProvinceId_Last(
		java.lang.String provinceId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchShootingDirectorException {
		return getPersistence()
				   .findBybyProvinceId_Last(provinceId, orderByComparator);
	}

	/**
	* Returns the last e s f shooting director in the ordered set where provinceId = &#63;.
	*
	* @param provinceId the province ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f shooting director, or <code>null</code> if a matching e s f shooting director could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFShootingDirector fetchBybyProvinceId_Last(
		java.lang.String provinceId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBybyProvinceId_Last(provinceId, orderByComparator);
	}

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
	public static it.ethica.esf.model.ESFShootingDirector[] findBybyProvinceId_PrevAndNext(
		long esfShootingDirectorId, java.lang.String provinceId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchShootingDirectorException {
		return getPersistence()
				   .findBybyProvinceId_PrevAndNext(esfShootingDirectorId,
			provinceId, orderByComparator);
	}

	/**
	* Removes all the e s f shooting directors where provinceId = &#63; from the database.
	*
	* @param provinceId the province ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBybyProvinceId(java.lang.String provinceId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBybyProvinceId(provinceId);
	}

	/**
	* Returns the number of e s f shooting directors where provinceId = &#63;.
	*
	* @param provinceId the province ID
	* @return the number of matching e s f shooting directors
	* @throws SystemException if a system exception occurred
	*/
	public static int countBybyProvinceId(java.lang.String provinceId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBybyProvinceId(provinceId);
	}

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
	public static it.ethica.esf.model.ESFShootingDirector findBybyUserId_SDQId_STId(
		long esfUserId, long shootingDirectorQualificationId, long sportTypeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchShootingDirectorException {
		return getPersistence()
				   .findBybyUserId_SDQId_STId(esfUserId,
			shootingDirectorQualificationId, sportTypeId);
	}

	/**
	* Returns the e s f shooting director where esfUserId = &#63; and shootingDirectorQualificationId = &#63; and sportTypeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param esfUserId the esf user ID
	* @param shootingDirectorQualificationId the shooting director qualification ID
	* @param sportTypeId the sport type ID
	* @return the matching e s f shooting director, or <code>null</code> if a matching e s f shooting director could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFShootingDirector fetchBybyUserId_SDQId_STId(
		long esfUserId, long shootingDirectorQualificationId, long sportTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBybyUserId_SDQId_STId(esfUserId,
			shootingDirectorQualificationId, sportTypeId);
	}

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
	public static it.ethica.esf.model.ESFShootingDirector fetchBybyUserId_SDQId_STId(
		long esfUserId, long shootingDirectorQualificationId, long sportTypeId,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBybyUserId_SDQId_STId(esfUserId,
			shootingDirectorQualificationId, sportTypeId, retrieveFromCache);
	}

	/**
	* Removes the e s f shooting director where esfUserId = &#63; and shootingDirectorQualificationId = &#63; and sportTypeId = &#63; from the database.
	*
	* @param esfUserId the esf user ID
	* @param shootingDirectorQualificationId the shooting director qualification ID
	* @param sportTypeId the sport type ID
	* @return the e s f shooting director that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFShootingDirector removeBybyUserId_SDQId_STId(
		long esfUserId, long shootingDirectorQualificationId, long sportTypeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchShootingDirectorException {
		return getPersistence()
				   .removeBybyUserId_SDQId_STId(esfUserId,
			shootingDirectorQualificationId, sportTypeId);
	}

	/**
	* Returns the number of e s f shooting directors where esfUserId = &#63; and shootingDirectorQualificationId = &#63; and sportTypeId = &#63;.
	*
	* @param esfUserId the esf user ID
	* @param shootingDirectorQualificationId the shooting director qualification ID
	* @param sportTypeId the sport type ID
	* @return the number of matching e s f shooting directors
	* @throws SystemException if a system exception occurred
	*/
	public static int countBybyUserId_SDQId_STId(long esfUserId,
		long shootingDirectorQualificationId, long sportTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countBybyUserId_SDQId_STId(esfUserId,
			shootingDirectorQualificationId, sportTypeId);
	}

	/**
	* Caches the e s f shooting director in the entity cache if it is enabled.
	*
	* @param esfShootingDirector the e s f shooting director
	*/
	public static void cacheResult(
		it.ethica.esf.model.ESFShootingDirector esfShootingDirector) {
		getPersistence().cacheResult(esfShootingDirector);
	}

	/**
	* Caches the e s f shooting directors in the entity cache if it is enabled.
	*
	* @param esfShootingDirectors the e s f shooting directors
	*/
	public static void cacheResult(
		java.util.List<it.ethica.esf.model.ESFShootingDirector> esfShootingDirectors) {
		getPersistence().cacheResult(esfShootingDirectors);
	}

	/**
	* Creates a new e s f shooting director with the primary key. Does not add the e s f shooting director to the database.
	*
	* @param esfShootingDirectorId the primary key for the new e s f shooting director
	* @return the new e s f shooting director
	*/
	public static it.ethica.esf.model.ESFShootingDirector create(
		long esfShootingDirectorId) {
		return getPersistence().create(esfShootingDirectorId);
	}

	/**
	* Removes the e s f shooting director with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfShootingDirectorId the primary key of the e s f shooting director
	* @return the e s f shooting director that was removed
	* @throws it.ethica.esf.NoSuchShootingDirectorException if a e s f shooting director with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFShootingDirector remove(
		long esfShootingDirectorId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchShootingDirectorException {
		return getPersistence().remove(esfShootingDirectorId);
	}

	public static it.ethica.esf.model.ESFShootingDirector updateImpl(
		it.ethica.esf.model.ESFShootingDirector esfShootingDirector)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(esfShootingDirector);
	}

	/**
	* Returns the e s f shooting director with the primary key or throws a {@link it.ethica.esf.NoSuchShootingDirectorException} if it could not be found.
	*
	* @param esfShootingDirectorId the primary key of the e s f shooting director
	* @return the e s f shooting director
	* @throws it.ethica.esf.NoSuchShootingDirectorException if a e s f shooting director with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFShootingDirector findByPrimaryKey(
		long esfShootingDirectorId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchShootingDirectorException {
		return getPersistence().findByPrimaryKey(esfShootingDirectorId);
	}

	/**
	* Returns the e s f shooting director with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param esfShootingDirectorId the primary key of the e s f shooting director
	* @return the e s f shooting director, or <code>null</code> if a e s f shooting director with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFShootingDirector fetchByPrimaryKey(
		long esfShootingDirectorId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(esfShootingDirectorId);
	}

	/**
	* Returns all the e s f shooting directors.
	*
	* @return the e s f shooting directors
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFShootingDirector> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<it.ethica.esf.model.ESFShootingDirector> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<it.ethica.esf.model.ESFShootingDirector> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the e s f shooting directors from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of e s f shooting directors.
	*
	* @return the number of e s f shooting directors
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ESFShootingDirectorPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ESFShootingDirectorPersistence)PortletBeanLocatorUtil.locate(it.ethica.esf.service.ClpSerializer.getServletContextName(),
					ESFShootingDirectorPersistence.class.getName());

			ReferenceRegistry.registerReference(ESFShootingDirectorUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ESFShootingDirectorPersistence persistence) {
	}

	private static ESFShootingDirectorPersistence _persistence;
}