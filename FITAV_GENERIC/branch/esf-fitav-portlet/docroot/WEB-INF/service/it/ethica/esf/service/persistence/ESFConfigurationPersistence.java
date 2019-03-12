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

import it.ethica.esf.model.ESFConfiguration;

/**
 * The persistence interface for the e s f configuration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ethica
 * @see ESFConfigurationPersistenceImpl
 * @see ESFConfigurationUtil
 * @generated
 */
public interface ESFConfigurationPersistence extends BasePersistence<ESFConfiguration> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ESFConfigurationUtil} to access the e s f configuration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the e s f configurations where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching e s f configurations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFConfiguration> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.ethica.esf.model.ESFConfiguration> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.ethica.esf.model.ESFConfiguration> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e s f configuration in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f configuration
	* @throws it.ethica.esf.NoSuchConfigurationException if a matching e s f configuration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFConfiguration findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchConfigurationException;

	/**
	* Returns the first e s f configuration in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e s f configuration, or <code>null</code> if a matching e s f configuration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFConfiguration fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e s f configuration in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f configuration
	* @throws it.ethica.esf.NoSuchConfigurationException if a matching e s f configuration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFConfiguration findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchConfigurationException;

	/**
	* Returns the last e s f configuration in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e s f configuration, or <code>null</code> if a matching e s f configuration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFConfiguration fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public it.ethica.esf.model.ESFConfiguration[] findByGroupId_PrevAndNext(
		long esfConfigurationId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchConfigurationException;

	/**
	* Removes all the e s f configurations where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f configurations where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching e s f configurations
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f configuration where key = &#63; or throws a {@link it.ethica.esf.NoSuchConfigurationException} if it could not be found.
	*
	* @param key the key
	* @return the matching e s f configuration
	* @throws it.ethica.esf.NoSuchConfigurationException if a matching e s f configuration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFConfiguration findByESFKey(
		java.lang.String key)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchConfigurationException;

	/**
	* Returns the e s f configuration where key = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param key the key
	* @return the matching e s f configuration, or <code>null</code> if a matching e s f configuration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFConfiguration fetchByESFKey(
		java.lang.String key)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f configuration where key = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param key the key
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching e s f configuration, or <code>null</code> if a matching e s f configuration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFConfiguration fetchByESFKey(
		java.lang.String key, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the e s f configuration where key = &#63; from the database.
	*
	* @param key the key
	* @return the e s f configuration that was removed
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFConfiguration removeByESFKey(
		java.lang.String key)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchConfigurationException;

	/**
	* Returns the number of e s f configurations where key = &#63;.
	*
	* @param key the key
	* @return the number of matching e s f configurations
	* @throws SystemException if a system exception occurred
	*/
	public int countByESFKey(java.lang.String key)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the e s f configuration in the entity cache if it is enabled.
	*
	* @param esfConfiguration the e s f configuration
	*/
	public void cacheResult(
		it.ethica.esf.model.ESFConfiguration esfConfiguration);

	/**
	* Caches the e s f configurations in the entity cache if it is enabled.
	*
	* @param esfConfigurations the e s f configurations
	*/
	public void cacheResult(
		java.util.List<it.ethica.esf.model.ESFConfiguration> esfConfigurations);

	/**
	* Creates a new e s f configuration with the primary key. Does not add the e s f configuration to the database.
	*
	* @param esfConfigurationId the primary key for the new e s f configuration
	* @return the new e s f configuration
	*/
	public it.ethica.esf.model.ESFConfiguration create(long esfConfigurationId);

	/**
	* Removes the e s f configuration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfConfigurationId the primary key of the e s f configuration
	* @return the e s f configuration that was removed
	* @throws it.ethica.esf.NoSuchConfigurationException if a e s f configuration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFConfiguration remove(long esfConfigurationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchConfigurationException;

	public it.ethica.esf.model.ESFConfiguration updateImpl(
		it.ethica.esf.model.ESFConfiguration esfConfiguration)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e s f configuration with the primary key or throws a {@link it.ethica.esf.NoSuchConfigurationException} if it could not be found.
	*
	* @param esfConfigurationId the primary key of the e s f configuration
	* @return the e s f configuration
	* @throws it.ethica.esf.NoSuchConfigurationException if a e s f configuration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFConfiguration findByPrimaryKey(
		long esfConfigurationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchConfigurationException;

	/**
	* Returns the e s f configuration with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param esfConfigurationId the primary key of the e s f configuration
	* @return the e s f configuration, or <code>null</code> if a e s f configuration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.ethica.esf.model.ESFConfiguration fetchByPrimaryKey(
		long esfConfigurationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e s f configurations.
	*
	* @return the e s f configurations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.ethica.esf.model.ESFConfiguration> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.ethica.esf.model.ESFConfiguration> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.ethica.esf.model.ESFConfiguration> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the e s f configurations from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e s f configurations.
	*
	* @return the number of e s f configurations
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}