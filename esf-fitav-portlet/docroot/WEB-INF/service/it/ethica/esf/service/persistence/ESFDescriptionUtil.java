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

import it.ethica.esf.model.ESFDescription;

import java.util.List;

/**
 * The persistence utility for the e s f description service. This utility wraps {@link ESFDescriptionPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFDescriptionPersistence
 * @see ESFDescriptionPersistenceImpl
 * @generated
 */
public class ESFDescriptionUtil {
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
	public static void clearCache(ESFDescription esfDescription) {
		getPersistence().clearCache(esfDescription);
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
	public static List<ESFDescription> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ESFDescription> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ESFDescription> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ESFDescription update(ESFDescription esfDescription)
		throws SystemException {
		return getPersistence().update(esfDescription);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ESFDescription update(ESFDescription esfDescription,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(esfDescription, serviceContext);
	}

	/**
	* Returns all the e s f descriptions where isNational = &#63;.
	*
	* @param isNational the is national
	* @return the matching e s f descriptions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFDescription> findByIsNational(
		boolean isNational)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByIsNational(isNational);
	}

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
	public static java.util.List<it.ethica.esf.model.ESFDescription> findByIsNational(
		boolean isNational, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByIsNational(isNational, start, end);
	}

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
	public static java.util.List<it.ethica.esf.model.ESFDescription> findByIsNational(
		boolean isNational, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByIsNational(isNational, start, end, orderByComparator);
	}

	/**
	* Returns the first e s f description in the ordered set where isNational = &#63;.
	*
	* @param isNational the is national
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f description
	* @throws it.ethica.esf.NoSuchDescriptionException if a matching e s f description could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFDescription findByIsNational_First(
		boolean isNational,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchDescriptionException {
		return getPersistence()
				   .findByIsNational_First(isNational, orderByComparator);
	}

	/**
	* Returns the first e s f description in the ordered set where isNational = &#63;.
	*
	* @param isNational the is national
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f description, or <code>null</code> if a matching e s f description could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFDescription fetchByIsNational_First(
		boolean isNational,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByIsNational_First(isNational, orderByComparator);
	}

	/**
	* Returns the last e s f description in the ordered set where isNational = &#63;.
	*
	* @param isNational the is national
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f description
	* @throws it.ethica.esf.NoSuchDescriptionException if a matching e s f description could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFDescription findByIsNational_Last(
		boolean isNational,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchDescriptionException {
		return getPersistence()
				   .findByIsNational_Last(isNational, orderByComparator);
	}

	/**
	* Returns the last e s f description in the ordered set where isNational = &#63;.
	*
	* @param isNational the is national
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f description, or <code>null</code> if a matching e s f description could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFDescription fetchByIsNational_Last(
		boolean isNational,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByIsNational_Last(isNational, orderByComparator);
	}

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
	public static it.ethica.esf.model.ESFDescription[] findByIsNational_PrevAndNext(
		long esfDescriptionId, boolean isNational,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchDescriptionException {
		return getPersistence()
				   .findByIsNational_PrevAndNext(esfDescriptionId, isNational,
			orderByComparator);
	}

	/**
	* Removes all the e s f descriptions where isNational = &#63; from the database.
	*
	* @param isNational the is national
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByIsNational(boolean isNational)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByIsNational(isNational);
	}

	/**
	* Returns the number of e s f descriptions where isNational = &#63;.
	*
	* @param isNational the is national
	* @return the number of matching e s f descriptions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByIsNational(boolean isNational)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByIsNational(isNational);
	}

	/**
	* Caches the e s f description in the entity cache if it is enabled.
	*
	* @param esfDescription the e s f description
	*/
	public static void cacheResult(
		it.ethica.esf.model.ESFDescription esfDescription) {
		getPersistence().cacheResult(esfDescription);
	}

	/**
	* Caches the e s f descriptions in the entity cache if it is enabled.
	*
	* @param esfDescriptions the e s f descriptions
	*/
	public static void cacheResult(
		java.util.List<it.ethica.esf.model.ESFDescription> esfDescriptions) {
		getPersistence().cacheResult(esfDescriptions);
	}

	/**
	* Creates a new e s f description with the primary key. Does not add the e s f description to the database.
	*
	* @param esfDescriptionId the primary key for the new e s f description
	* @return the new e s f description
	*/
	public static it.ethica.esf.model.ESFDescription create(
		long esfDescriptionId) {
		return getPersistence().create(esfDescriptionId);
	}

	/**
	* Removes the e s f description with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfDescriptionId the primary key of the e s f description
	* @return the e s f description that was removed
	* @throws it.ethica.esf.NoSuchDescriptionException if a e s f description with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFDescription remove(
		long esfDescriptionId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchDescriptionException {
		return getPersistence().remove(esfDescriptionId);
	}

	public static it.ethica.esf.model.ESFDescription updateImpl(
		it.ethica.esf.model.ESFDescription esfDescription)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(esfDescription);
	}

	/**
	* Returns the e s f description with the primary key or throws a {@link it.ethica.esf.NoSuchDescriptionException} if it could not be found.
	*
	* @param esfDescriptionId the primary key of the e s f description
	* @return the e s f description
	* @throws it.ethica.esf.NoSuchDescriptionException if a e s f description with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFDescription findByPrimaryKey(
		long esfDescriptionId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchDescriptionException {
		return getPersistence().findByPrimaryKey(esfDescriptionId);
	}

	/**
	* Returns the e s f description with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param esfDescriptionId the primary key of the e s f description
	* @return the e s f description, or <code>null</code> if a e s f description with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFDescription fetchByPrimaryKey(
		long esfDescriptionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(esfDescriptionId);
	}

	/**
	* Returns all the e s f descriptions.
	*
	* @return the e s f descriptions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFDescription> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<it.ethica.esf.model.ESFDescription> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<it.ethica.esf.model.ESFDescription> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the e s f descriptions from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of e s f descriptions.
	*
	* @return the number of e s f descriptions
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ESFDescriptionPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ESFDescriptionPersistence)PortletBeanLocatorUtil.locate(it.ethica.esf.service.ClpSerializer.getServletContextName(),
					ESFDescriptionPersistence.class.getName());

			ReferenceRegistry.registerReference(ESFDescriptionUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ESFDescriptionPersistence persistence) {
	}

	private static ESFDescriptionPersistence _persistence;
}