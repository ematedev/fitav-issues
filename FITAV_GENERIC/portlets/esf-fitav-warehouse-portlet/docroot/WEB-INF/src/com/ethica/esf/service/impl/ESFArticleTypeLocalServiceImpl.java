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

import com.ethica.esf.model.ESFArticleType;
import com.ethica.esf.service.base.ESFArticleTypeLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the e s f article type local service. <p> All custom
 * service methods should be put in this class. Whenever methods are added,
 * rerun ServiceBuilder to copy their definitions into the
 * {@link com.ethica.esf.service.ESFArticleTypeLocalService} interface. <p> This
 * is a local service. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM. </p>
 *
 * @author Ethica
 * @see com.ethica.esf.service.base.ESFArticleTypeLocalServiceBaseImpl
 * @see com.ethica.esf.service.ESFArticleTypeLocalServiceUtil
 */
public class ESFArticleTypeLocalServiceImpl
	extends ESFArticleTypeLocalServiceBaseImpl {

	@Override
	public ESFArticleType addESFArticleType(
		String description, String area, String department)
		throws PortalException, SystemException {

		long esfArticleTypeId = counterLocalService.increment();
		ESFArticleType esfArticleType =
			esfArticleTypePersistence.create(esfArticleTypeId);
		esfArticleType.setDescription(description);
		esfArticleType.setArea(area);
		esfArticleType.setDepartment(department);

		esfArticleTypePersistence.update(esfArticleType);

		return esfArticleType;
	}

	@Override
	public ESFArticleType updateESFArticleType(
		long esfArticleTypeId, String description, String area,
		String department)
		throws PortalException, SystemException {

		ESFArticleType esfArticleType =
			esfArticleTypePersistence.fetchByPrimaryKey(esfArticleTypeId);
		esfArticleType.setDescription(description);
		esfArticleType.setArea(area);
		esfArticleType.setDepartment(department);

		esfArticleTypePersistence.update(esfArticleType);

		return esfArticleType;
	}
}
