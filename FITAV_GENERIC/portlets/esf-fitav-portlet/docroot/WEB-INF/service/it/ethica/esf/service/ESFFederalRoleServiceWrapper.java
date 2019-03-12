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

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ESFFederalRoleService}.
 *
 * @author Ethica
 * @see ESFFederalRoleService
 * @generated
 */
public class ESFFederalRoleServiceWrapper implements ESFFederalRoleService,
	ServiceWrapper<ESFFederalRoleService> {
	public ESFFederalRoleServiceWrapper(
		ESFFederalRoleService esfFederalRoleService) {
		_esfFederalRoleService = esfFederalRoleService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _esfFederalRoleService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_esfFederalRoleService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _esfFederalRoleService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public it.ethica.esf.model.ESFFederalRole updateEsfFederalRole(
		long esfFederalRoleId, java.lang.String name,
		java.lang.String description, boolean regional, boolean provincial)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.security.auth.PrincipalException {
		return _esfFederalRoleService.updateEsfFederalRole(esfFederalRoleId,
			name, description, regional, provincial);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFSpecific> getFederalRoleSpecifics(
		long esfFederalRoleId) {
		return _esfFederalRoleService.getFederalRoleSpecifics(esfFederalRoleId);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFFederalRole> findByCode(
		java.lang.String name) {
		return _esfFederalRoleService.findByCode(name);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ESFFederalRoleService getWrappedESFFederalRoleService() {
		return _esfFederalRoleService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedESFFederalRoleService(
		ESFFederalRoleService esfFederalRoleService) {
		_esfFederalRoleService = esfFederalRoleService;
	}

	@Override
	public ESFFederalRoleService getWrappedService() {
		return _esfFederalRoleService;
	}

	@Override
	public void setWrappedService(ESFFederalRoleService esfFederalRoleService) {
		_esfFederalRoleService = esfFederalRoleService;
	}

	private ESFFederalRoleService _esfFederalRoleService;
}