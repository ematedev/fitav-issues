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

package com.ethica.esf.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.ServiceContext;

import com.ethica.esf.model.ESFArticleType;
import com.ethica.esf.service.base.ESFArticleTypeLocalServiceBaseImpl;

import java.util.List;

/**
 * The implementation of the e s f article type local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link it.ethica.esf.service.ESFArticleTypeLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Ethica
 * @see it.ethica.esf.service.base.ESFArticleTypeLocalServiceBaseImpl
 * @see it.ethica.esf.service.ESFArticleTypeLocalServiceUtil
 */
public class ESFArticleTypeLocalServiceImpl extends
		ESFArticleTypeLocalServiceBaseImpl {
	public ESFArticleType addESFArticleType(String description, String area,
			String department, ServiceContext serviceContext)
			throws PortalException, SystemException {

		long esfArticleTypeId = counterLocalService.increment();
		ESFArticleType esfArticleType = esfArticleTypePersistence
				.create(esfArticleTypeId);
		esfArticleType.setDescription(description);
		esfArticleType.setArea(area);
		esfArticleType.setDepartment(department);
		esfArticleType.setExpandoBridgeAttributes(serviceContext);

		esfArticleTypePersistence.update(esfArticleType);

		return esfArticleType;
	}

	public ESFArticleType checkDescription(String description,
			ServiceContext serviceContext) throws PortalException,
			SystemException {

		if (Validator.isNotNull(description) && !Validator.isBlank(description)) {
			return esfArticleTypePersistence
					.fetchByArticleTypeDescription(description);
		}

		return null;
	}

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use
	 * {@link it.ethica.esf.service.ESFArticleTypeLocalServiceUtil} to access
	 * the e s f article type local service.
	 */
	public List<ESFArticleType> getESFArticleTypes() throws SystemException {

		return esfArticleTypePersistence.findAll();
	}

	public ESFArticleType updateESFArticleType(long esfArticleTypeId,
			String description, String area, String department,
			ServiceContext serviceContext) throws PortalException,
			SystemException {

		ESFArticleType esfArticleType = getESFArticleType(esfArticleTypeId);

		esfArticleType.setDescription(description);
		esfArticleType.setArea(area);
		esfArticleType.setDepartment(department);
		esfArticleType.setExpandoBridgeAttributes(serviceContext);

		esfArticleTypePersistence.update(esfArticleType);

		return esfArticleType;
	}

}