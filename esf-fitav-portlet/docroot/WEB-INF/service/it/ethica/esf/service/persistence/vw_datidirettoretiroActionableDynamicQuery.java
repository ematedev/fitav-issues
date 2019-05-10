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

package it.ethica.esf.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import it.ethica.esf.model.vw_datidirettoretiro;
import it.ethica.esf.service.vw_datidirettoretiroLocalServiceUtil;

/**
 * @author Ethica
 * @generated
 */
public abstract class vw_datidirettoretiroActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public vw_datidirettoretiroActionableDynamicQuery()
		throws SystemException {
		setBaseLocalService(vw_datidirettoretiroLocalServiceUtil.getService());
		setClass(vw_datidirettoretiro.class);

		setClassLoader(it.ethica.esf.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("primaryKey.esfshootingdirectorid");
	}
}