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
 * Provides a wrapper for {@link VW_AzzurriService}.
 *
 * @author Ethica
 * @see VW_AzzurriService
 * @generated
 */
public class VW_AzzurriServiceWrapper implements VW_AzzurriService,
	ServiceWrapper<VW_AzzurriService> {
	public VW_AzzurriServiceWrapper(VW_AzzurriService vw_AzzurriService) {
		_vw_AzzurriService = vw_AzzurriService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _vw_AzzurriService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_vw_AzzurriService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _vw_AzzurriService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public VW_AzzurriService getWrappedVW_AzzurriService() {
		return _vw_AzzurriService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedVW_AzzurriService(VW_AzzurriService vw_AzzurriService) {
		_vw_AzzurriService = vw_AzzurriService;
	}

	@Override
	public VW_AzzurriService getWrappedService() {
		return _vw_AzzurriService;
	}

	@Override
	public void setWrappedService(VW_AzzurriService vw_AzzurriService) {
		_vw_AzzurriService = vw_AzzurriService;
	}

	private VW_AzzurriService _vw_AzzurriService;
}