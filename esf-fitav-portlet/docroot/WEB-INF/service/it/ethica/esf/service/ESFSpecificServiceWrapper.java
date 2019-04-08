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
 * Provides a wrapper for {@link ESFSpecificService}.
 *
 * @author Ethica
 * @see ESFSpecificService
 * @generated
 */
public class ESFSpecificServiceWrapper implements ESFSpecificService,
	ServiceWrapper<ESFSpecificService> {
	public ESFSpecificServiceWrapper(ESFSpecificService esfSpecificService) {
		_esfSpecificService = esfSpecificService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _esfSpecificService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_esfSpecificService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _esfSpecificService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ESFSpecificService getWrappedESFSpecificService() {
		return _esfSpecificService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedESFSpecificService(
		ESFSpecificService esfSpecificService) {
		_esfSpecificService = esfSpecificService;
	}

	@Override
	public ESFSpecificService getWrappedService() {
		return _esfSpecificService;
	}

	@Override
	public void setWrappedService(ESFSpecificService esfSpecificService) {
		_esfSpecificService = esfSpecificService;
	}

	private ESFSpecificService _esfSpecificService;
}