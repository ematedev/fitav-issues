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

import it.ethica.esf.model.ESFConfiguration;

import java.util.List;

/**
 * The persistence utility for the e s f configuration service. This utility wraps {@link ESFConfigurationPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFConfigurationPersistence
 * @see ESFConfigurationPersistenceImpl
 * @generated
 */
public class ESFConfigurationUtil {
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
	public static void clearCache(ESFConfiguration esfConfiguration) {
		getPersistence().clearCache(esfConfiguration);
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
	public static List<ESFConfiguration> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ESFConfiguration> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ESFConfiguration> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ESFConfiguration update(ESFConfiguration esfConfiguration)
		throws SystemException {
		return getPersistence().update(esfConfiguration);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ESFConfiguration update(ESFConfiguration esfConfiguration,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(esfConfiguration, serviceContext);
	}

	/**
	* Returns all the e s f configurations where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching e s f configurations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFConfiguration> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	* Returns a range of all the e s f configurations where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFConfigurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of e s f configurations
	* @param end the upper bound of the range of e s f configurations (not inclusive)
	* @return the range of matching e s f configurations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFConfiguration> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the e s f configurations where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFConfigurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of e s f configurations
	* @param end the upper bound of the range of e s f configurations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e s f configurations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFConfiguration> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first e s f configuration in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f configuration
	* @throws it.ethica.esf.NoSuchConfigurationException if a matching e s f configuration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFConfiguration findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchConfigurationException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the first e s f configuration in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f configuration, or <code>null</code> if a matching e s f configuration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFConfiguration fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the last e s f configuration in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f configuration
	* @throws it.ethica.esf.NoSuchConfigurationException if a matching e s f configuration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFConfiguration findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchConfigurationException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last e s f configuration in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f configuration, or <code>null</code> if a matching e s f configuration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFConfiguration fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the e s f configurations before and after the current e s f configuration in the ordered set where groupId = &#63;.
	*
	* @param esfConfigurationId the primary key of the current e s f configuration
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e s f configuration
	* @throws it.ethica.esf.NoSuchConfigurationException if a e s f configuration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFConfiguration[] findByGroupId_PrevAndNext(
		long esfConfigurationId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchConfigurationException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(esfConfigurationId, groupId,
			orderByComparator);
	}

	/**
	* Removes all the e s f configurations where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Returns the number of e s f configurations where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching e s f configurations
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Returns the e s f configuration where key = &#63; or throws a {@link it.ethica.esf.NoSuchConfigurationException} if it could not be found.
	*
	* @param key the key
	* @return the matching e s f configuration
	* @throws it.ethica.esf.NoSuchConfigurationException if a matching e s f configuration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFConfiguration findByESFKey(
		java.lang.String key)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchConfigurationException {
		return getPersistence().findByESFKey(key);
	}

	/**
	* Returns the e s f configuration where key = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param key the key
	* @return the matching e s f configuration, or <code>null</code> if a matching e s f configuration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFConfiguration fetchByESFKey(
		java.lang.String key)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByESFKey(key);
	}

	/**
	* Returns the e s f configuration where key = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param key the key
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching e s f configuration, or <code>null</code> if a matching e s f configuration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFConfiguration fetchByESFKey(
		java.lang.String key, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByESFKey(key, retrieveFromCache);
	}

	/**
	* Removes the e s f configuration where key = &#63; from the database.
	*
	* @param key the key
	* @return the e s f configuration that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFConfiguration removeByESFKey(
		java.lang.String key)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchConfigurationException {
		return getPersistence().removeByESFKey(key);
	}

	/**
	* Returns the number of e s f configurations where key = &#63;.
	*
	* @param key the key
	* @return the number of matching e s f configurations
	* @throws SystemException if a system exception occurred
	*/
	public static int countByESFKey(java.lang.String key)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByESFKey(key);
	}

	/**
	* Caches the e s f configuration in the entity cache if it is enabled.
	*
	* @param esfConfiguration the e s f configuration
	*/
	public static void cacheResult(
		it.ethica.esf.model.ESFConfiguration esfConfiguration) {
		getPersistence().cacheResult(esfConfiguration);
	}

	/**
	* Caches the e s f configurations in the entity cache if it is enabled.
	*
	* @param esfConfigurations the e s f configurations
	*/
	public static void cacheResult(
		java.util.List<it.ethica.esf.model.ESFConfiguration> esfConfigurations) {
		getPersistence().cacheResult(esfConfigurations);
	}

	/**
	* Creates a new e s f configuration with the primary key. Does not add the e s f configuration to the database.
	*
	* @param esfConfigurationId the primary key for the new e s f configuration
	* @return the new e s f configuration
	*/
	public static it.ethica.esf.model.ESFConfiguration create(
		long esfConfigurationId) {
		return getPersistence().create(esfConfigurationId);
	}

	/**
	* Removes the e s f configuration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfConfigurationId the primary key of the e s f configuration
	* @return the e s f configuration that was removed
	* @throws it.ethica.esf.NoSuchConfigurationException if a e s f configuration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFConfiguration remove(
		long esfConfigurationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchConfigurationException {
		return getPersistence().remove(esfConfigurationId);
	}

	public static it.ethica.esf.model.ESFConfiguration updateImpl(
		it.ethica.esf.model.ESFConfiguration esfConfiguration)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(esfConfiguration);
	}

	/**
	* Returns the e s f configuration with the primary key or throws a {@link it.ethica.esf.NoSuchConfigurationException} if it could not be found.
	*
	* @param esfConfigurationId the primary key of the e s f configuration
	* @return the e s f configuration
	* @throws it.ethica.esf.NoSuchConfigurationException if a e s f configuration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFConfiguration findByPrimaryKey(
		long esfConfigurationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchConfigurationException {
		return getPersistence().findByPrimaryKey(esfConfigurationId);
	}

	/**
	* Returns the e s f configuration with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param esfConfigurationId the primary key of the e s f configuration
	* @return the e s f configuration, or <code>null</code> if a e s f configuration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFConfiguration fetchByPrimaryKey(
		long esfConfigurationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(esfConfigurationId);
	}

	/**
	* Returns all the e s f configurations.
	*
	* @return the e s f configurations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFConfiguration> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the e s f configurations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFConfigurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f configurations
	* @param end the upper bound of the range of e s f configurations (not inclusive)
	* @return the range of e s f configurations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFConfiguration> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the e s f configurations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFConfigurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f configurations
	* @param end the upper bound of the range of e s f configurations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of e s f configurations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFConfiguration> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the e s f configurations from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of e s f configurations.
	*
	* @return the number of e s f configurations
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ESFConfigurationPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ESFConfigurationPersistence)PortletBeanLocatorUtil.locate(it.ethica.esf.service.ClpSerializer.getServletContextName(),
					ESFConfigurationPersistence.class.getName());

			ReferenceRegistry.registerReference(ESFConfigurationUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ESFConfigurationPersistence persistence) {
	}

	private static ESFConfigurationPersistence _persistence;
}