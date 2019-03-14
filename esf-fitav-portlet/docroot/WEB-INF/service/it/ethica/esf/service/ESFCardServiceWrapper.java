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
 * Provides a wrapper for {@link ESFCardService}.
 *
 * @author Ethica
 * @see ESFCardService
 * @generated
 */
public class ESFCardServiceWrapper implements ESFCardService,
	ServiceWrapper<ESFCardService> {
	public ESFCardServiceWrapper(ESFCardService esfCardService) {
		_esfCardService = esfCardService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _esfCardService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_esfCardService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _esfCardService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFCard> findByUserId(long userId) {
		return _esfCardService.findByUserId(userId);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFCard> findCurrentByUserId(
		long userId) {
		return _esfCardService.findCurrentByUserId(userId);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFCard> findHistoryByUserId(
		long userId) {
		return _esfCardService.findHistoryByUserId(userId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ESFCardService getWrappedESFCardService() {
		return _esfCardService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedESFCardService(ESFCardService esfCardService) {
		_esfCardService = esfCardService;
	}

	@Override
	public ESFCardService getWrappedService() {
		return _esfCardService;
	}

	@Override
	public void setWrappedService(ESFCardService esfCardService) {
		_esfCardService = esfCardService;
	}

	private ESFCardService _esfCardService;
}