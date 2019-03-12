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

package it.ethica.esf.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for ESFConfiguration. This utility wraps
 * {@link it.ethica.esf.service.impl.ESFConfigurationLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Ethica
 * @see ESFConfigurationLocalService
 * @see it.ethica.esf.service.base.ESFConfigurationLocalServiceBaseImpl
 * @see it.ethica.esf.service.impl.ESFConfigurationLocalServiceImpl
 * @generated
 */
public class ESFConfigurationLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link it.ethica.esf.service.impl.ESFConfigurationLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the e s f configuration to the database. Also notifies the appropriate model listeners.
	*
	* @param esfConfiguration the e s f configuration
	* @return the e s f configuration that was added
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFConfiguration addESFConfiguration(
		it.ethica.esf.model.ESFConfiguration esfConfiguration)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addESFConfiguration(esfConfiguration);
	}

	/**
	* Creates a new e s f configuration with the primary key. Does not add the e s f configuration to the database.
	*
	* @param esfConfigurationId the primary key for the new e s f configuration
	* @return the new e s f configuration
	*/
	public static it.ethica.esf.model.ESFConfiguration createESFConfiguration(
		long esfConfigurationId) {
		return getService().createESFConfiguration(esfConfigurationId);
	}

	/**
	* Deletes the e s f configuration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfConfigurationId the primary key of the e s f configuration
	* @return the e s f configuration that was removed
	* @throws PortalException if a e s f configuration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFConfiguration deleteESFConfiguration(
		long esfConfigurationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteESFConfiguration(esfConfigurationId);
	}

	/**
	* Deletes the e s f configuration from the database. Also notifies the appropriate model listeners.
	*
	* @param esfConfiguration the e s f configuration
	* @return the e s f configuration that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFConfiguration deleteESFConfiguration(
		it.ethica.esf.model.ESFConfiguration esfConfiguration)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteESFConfiguration(esfConfiguration);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static it.ethica.esf.model.ESFConfiguration fetchESFConfiguration(
		long esfConfigurationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchESFConfiguration(esfConfigurationId);
	}

	/**
	* Returns the e s f configuration with the primary key.
	*
	* @param esfConfigurationId the primary key of the e s f configuration
	* @return the e s f configuration
	* @throws PortalException if a e s f configuration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFConfiguration getESFConfiguration(
		long esfConfigurationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFConfiguration(esfConfigurationId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<it.ethica.esf.model.ESFConfiguration> getESFConfigurations(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFConfigurations(start, end);
	}

	/**
	* Returns the number of e s f configurations.
	*
	* @return the number of e s f configurations
	* @throws SystemException if a system exception occurred
	*/
	public static int getESFConfigurationsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFConfigurationsCount();
	}

	/**
	* Updates the e s f configuration in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param esfConfiguration the e s f configuration
	* @return the e s f configuration that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFConfiguration updateESFConfiguration(
		it.ethica.esf.model.ESFConfiguration esfConfiguration)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateESFConfiguration(esfConfiguration);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static java.util.List<it.ethica.esf.model.ESFConfiguration> getAllEsfConfigurations()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAllEsfConfigurations();
	}

	public static java.util.List<it.ethica.esf.model.ESFConfiguration> getAllEsfConfigurations(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAllEsfConfigurations(start, end);
	}

	public static java.util.List<it.ethica.esf.model.ESFConfiguration> getAllEsfConfigurations(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAllEsfConfigurations(groupId);
	}

	public static java.util.List<it.ethica.esf.model.ESFConfiguration> getAllEsfConfigurations(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAllEsfConfigurations(groupId, start, end);
	}

	public static int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByGroupId(groupId);
	}

	public static java.util.List<it.ethica.esf.model.ESFConfiguration> findESFConfigurationTypeByKey(
		java.lang.String key)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().findESFConfigurationTypeByKey(key);
	}

	public static it.ethica.esf.model.ESFConfiguration addESFConfiguration(
		long userId, java.lang.String key, java.lang.String value,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addESFConfiguration(userId, key, value, serviceContext);
	}

	public static it.ethica.esf.model.ESFConfiguration updateESFConfiguration(
		long userId, long esfConfigurationId, java.lang.String value,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateESFConfiguration(userId, esfConfigurationId, value,
			serviceContext);
	}

	public static it.ethica.esf.model.ESFConfiguration deleteESFConfiguration(
		long esfConfigurationId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .deleteESFConfiguration(esfConfigurationId, serviceContext);
	}

	public static java.util.HashMap<java.lang.String, java.lang.Integer> findAgeByName()
		throws java.lang.Exception {
		return getService().findAgeByName();
	}

	public static it.ethica.esf.model.ESFConfiguration getESFConfigurationByESFKey(
		java.lang.String key)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.ethica.esf.NoSuchConfigurationException {
		return getService().getESFConfigurationByESFKey(key);
	}

	public static void clearService() {
		_service = null;
	}

	public static ESFConfigurationLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ESFConfigurationLocalService.class.getName());

			if (invokableLocalService instanceof ESFConfigurationLocalService) {
				_service = (ESFConfigurationLocalService)invokableLocalService;
			}
			else {
				_service = new ESFConfigurationLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(ESFConfigurationLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(ESFConfigurationLocalService service) {
	}

	private static ESFConfigurationLocalService _service;
}