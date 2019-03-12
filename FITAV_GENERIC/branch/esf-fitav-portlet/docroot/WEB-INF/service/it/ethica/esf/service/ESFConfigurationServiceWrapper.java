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
 * Provides a wrapper for {@link ESFConfigurationService}.
 *
 * @author Ethica
 * @see ESFConfigurationService
 * @generated
 */
public class ESFConfigurationServiceWrapper implements ESFConfigurationService,
	ServiceWrapper<ESFConfigurationService> {
	public ESFConfigurationServiceWrapper(
		ESFConfigurationService esfConfigurationService) {
		_esfConfigurationService = esfConfigurationService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _esfConfigurationService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_esfConfigurationService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _esfConfigurationService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFConfiguration> getAllEsfConfigurations()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfConfigurationService.getAllEsfConfigurations();
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFConfiguration> getAllEsfConfigurations(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfConfigurationService.getAllEsfConfigurations(start, end);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFConfiguration> getAllEsfConfigurations(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfConfigurationService.getAllEsfConfigurations(groupId);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFConfiguration> getAllEsfConfigurations(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfConfigurationService.getAllEsfConfigurations(groupId, start,
			end);
	}

	@Override
	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfConfigurationService.countByGroupId(groupId);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFConfiguration> findESFFornitureTypeByDescription(
		java.lang.String description)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfConfigurationService.findESFFornitureTypeByDescription(description);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ESFConfigurationService getWrappedESFConfigurationService() {
		return _esfConfigurationService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedESFConfigurationService(
		ESFConfigurationService esfConfigurationService) {
		_esfConfigurationService = esfConfigurationService;
	}

	@Override
	public ESFConfigurationService getWrappedService() {
		return _esfConfigurationService;
	}

	@Override
	public void setWrappedService(
		ESFConfigurationService esfConfigurationService) {
		_esfConfigurationService = esfConfigurationService;
	}

	private ESFConfigurationService _esfConfigurationService;
}