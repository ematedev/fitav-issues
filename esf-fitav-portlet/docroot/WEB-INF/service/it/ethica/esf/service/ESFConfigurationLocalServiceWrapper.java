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

package it.ethica.esf.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ESFConfigurationLocalService}.
 *
 * @author Ethica
 * @see ESFConfigurationLocalService
 * @generated
 */
public class ESFConfigurationLocalServiceWrapper
	implements ESFConfigurationLocalService,
		ServiceWrapper<ESFConfigurationLocalService> {
	public ESFConfigurationLocalServiceWrapper(
		ESFConfigurationLocalService esfConfigurationLocalService) {
		_esfConfigurationLocalService = esfConfigurationLocalService;
	}

	/**
	* Adds the e s f configuration to the database. Also notifies the appropriate model listeners.
	*
	* @param esfConfiguration the e s f configuration
	* @return the e s f configuration that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFConfiguration addESFConfiguration(
		it.ethica.esf.model.ESFConfiguration esfConfiguration)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfConfigurationLocalService.addESFConfiguration(esfConfiguration);
	}

	/**
	* Creates a new e s f configuration with the primary key. Does not add the e s f configuration to the database.
	*
	* @param esfConfigurationId the primary key for the new e s f configuration
	* @return the new e s f configuration
	*/
	@Override
	public it.ethica.esf.model.ESFConfiguration createESFConfiguration(
		long esfConfigurationId) {
		return _esfConfigurationLocalService.createESFConfiguration(esfConfigurationId);
	}

	/**
	* Deletes the e s f configuration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfConfigurationId the primary key of the e s f configuration
	* @return the e s f configuration that was removed
	* @throws PortalException if a e s f configuration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFConfiguration deleteESFConfiguration(
		long esfConfigurationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfConfigurationLocalService.deleteESFConfiguration(esfConfigurationId);
	}

	/**
	* Deletes the e s f configuration from the database. Also notifies the appropriate model listeners.
	*
	* @param esfConfiguration the e s f configuration
	* @return the e s f configuration that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFConfiguration deleteESFConfiguration(
		it.ethica.esf.model.ESFConfiguration esfConfiguration)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfConfigurationLocalService.deleteESFConfiguration(esfConfiguration);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _esfConfigurationLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfConfigurationLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFConfigurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _esfConfigurationLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFConfigurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfConfigurationLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfConfigurationLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfConfigurationLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public it.ethica.esf.model.ESFConfiguration fetchESFConfiguration(
		long esfConfigurationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfConfigurationLocalService.fetchESFConfiguration(esfConfigurationId);
	}

	/**
	* Returns the e s f configuration with the primary key.
	*
	* @param esfConfigurationId the primary key of the e s f configuration
	* @return the e s f configuration
	* @throws PortalException if a e s f configuration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFConfiguration getESFConfiguration(
		long esfConfigurationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfConfigurationLocalService.getESFConfiguration(esfConfigurationId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfConfigurationLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<it.ethica.esf.model.ESFConfiguration> getESFConfigurations(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfConfigurationLocalService.getESFConfigurations(start, end);
	}

	/**
	* Returns the number of e s f configurations.
	*
	* @return the number of e s f configurations
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getESFConfigurationsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfConfigurationLocalService.getESFConfigurationsCount();
	}

	/**
	* Updates the e s f configuration in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param esfConfiguration the e s f configuration
	* @return the e s f configuration that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFConfiguration updateESFConfiguration(
		it.ethica.esf.model.ESFConfiguration esfConfiguration)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfConfigurationLocalService.updateESFConfiguration(esfConfiguration);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _esfConfigurationLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_esfConfigurationLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _esfConfigurationLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFConfiguration> getAllEsfConfigurations()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfConfigurationLocalService.getAllEsfConfigurations();
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFConfiguration> getAllEsfConfigurations(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfConfigurationLocalService.getAllEsfConfigurations(start, end);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFConfiguration> getAllEsfConfigurations(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfConfigurationLocalService.getAllEsfConfigurations(groupId);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFConfiguration> getAllEsfConfigurations(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfConfigurationLocalService.getAllEsfConfigurations(groupId,
			start, end);
	}

	@Override
	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfConfigurationLocalService.countByGroupId(groupId);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFConfiguration> findESFConfigurationTypeByKey(
		java.lang.String key)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfConfigurationLocalService.findESFConfigurationTypeByKey(key);
	}

	@Override
	public it.ethica.esf.model.ESFConfiguration addESFConfiguration(
		long userId, java.lang.String key, java.lang.String value,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfConfigurationLocalService.addESFConfiguration(userId, key,
			value, serviceContext);
	}

	@Override
	public it.ethica.esf.model.ESFConfiguration updateESFConfiguration(
		long userId, long esfConfigurationId, java.lang.String value,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfConfigurationLocalService.updateESFConfiguration(userId,
			esfConfigurationId, value, serviceContext);
	}

	@Override
	public it.ethica.esf.model.ESFConfiguration deleteESFConfiguration(
		long esfConfigurationId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfConfigurationLocalService.deleteESFConfiguration(esfConfigurationId,
			serviceContext);
	}

	@Override
	public java.util.HashMap<java.lang.String, java.lang.Integer> findAgeByName()
		throws java.lang.Exception {
		return _esfConfigurationLocalService.findAgeByName();
	}

	@Override
	public java.util.HashMap<java.lang.String, java.lang.Integer> findAgeYouthShooter(
		java.lang.String youthS) throws java.lang.Exception {
		return _esfConfigurationLocalService.findAgeYouthShooter(youthS);
	}

	@Override
	public it.ethica.esf.model.ESFConfiguration getESFConfigurationByESFKey(
		java.lang.String key)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchConfigurationException {
		return _esfConfigurationLocalService.getESFConfigurationByESFKey(key);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ESFConfigurationLocalService getWrappedESFConfigurationLocalService() {
		return _esfConfigurationLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedESFConfigurationLocalService(
		ESFConfigurationLocalService esfConfigurationLocalService) {
		_esfConfigurationLocalService = esfConfigurationLocalService;
	}

	@Override
	public ESFConfigurationLocalService getWrappedService() {
		return _esfConfigurationLocalService;
	}

	@Override
	public void setWrappedService(
		ESFConfigurationLocalService esfConfigurationLocalService) {
		_esfConfigurationLocalService = esfConfigurationLocalService;
	}

	private ESFConfigurationLocalService _esfConfigurationLocalService;
}