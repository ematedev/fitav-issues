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
 * Provides the remote service utility for ESFFederalRole. This utility wraps
 * {@link it.ethica.esf.service.impl.ESFFederalRoleServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Ethica
 * @see ESFFederalRoleService
 * @see it.ethica.esf.service.base.ESFFederalRoleServiceBaseImpl
 * @see it.ethica.esf.service.impl.ESFFederalRoleServiceImpl
 * @generated
 */
public class ESFFederalRoleServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link it.ethica.esf.service.impl.ESFFederalRoleServiceImpl} and rerun ServiceBuilder to regenerate this class.
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

	public static it.ethica.esf.model.ESFFederalRole updateEsfFederalRole(
		long esfFederalRoleId, java.lang.String name,
		java.lang.String description, boolean regional, boolean provincial)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.security.auth.PrincipalException {
		return getService()
				   .updateEsfFederalRole(esfFederalRoleId, name, description,
			regional, provincial);
	}

	public static java.util.List<it.ethica.esf.model.ESFSpecific> getFederalRoleSpecifics(
		long esfFederalRoleId) {
		return getService().getFederalRoleSpecifics(esfFederalRoleId);
	}

	public static java.util.List<it.ethica.esf.model.ESFFederalRole> findByCode(
		java.lang.String name) {
		return getService().findByCode(name);
	}

	public static void clearService() {
		_service = null;
	}

	public static ESFFederalRoleService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ESFFederalRoleService.class.getName());

			if (invokableService instanceof ESFFederalRoleService) {
				_service = (ESFFederalRoleService)invokableService;
			}
			else {
				_service = new ESFFederalRoleServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(ESFFederalRoleServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(ESFFederalRoleService service) {
	}

	private static ESFFederalRoleService _service;
}