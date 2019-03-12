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
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service utility for ESFConfiguration. This utility wraps
 * {@link it.ethica.esf.service.impl.ESFConfigurationServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Ethica
 * @see ESFConfigurationService
 * @see it.ethica.esf.service.base.ESFConfigurationServiceBaseImpl
 * @see it.ethica.esf.service.impl.ESFConfigurationServiceImpl
 * @generated
 */
public class ESFConfigurationServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link it.ethica.esf.service.impl.ESFConfigurationServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

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

	public static java.util.List<it.ethica.esf.model.ESFConfiguration> findESFFornitureTypeByDescription(
		java.lang.String description)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().findESFFornitureTypeByDescription(description);
	}

	public static void clearService() {
		_service = null;
	}

	public static ESFConfigurationService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ESFConfigurationService.class.getName());

			if (invokableService instanceof ESFConfigurationService) {
				_service = (ESFConfigurationService)invokableService;
			}
			else {
				_service = new ESFConfigurationServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(ESFConfigurationServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(ESFConfigurationService service) {
	}

	private static ESFConfigurationService _service;
}