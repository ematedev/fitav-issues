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

package com.ethica.esf.model.impl;

import com.ethica.esf.model.ESFArticle_ESFOrder;
import com.ethica.esf.service.ESFArticle_ESFOrderLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The extended model base implementation for the ESFArticle_ESFOrder service. Represents a row in the &quot;ESFArticle_ESFOrder&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ESFArticle_ESFOrderImpl}.
 * </p>
 *
 * @author Ethica
 * @see ESFArticle_ESFOrderImpl
 * @see com.ethica.esf.model.ESFArticle_ESFOrder
 * @generated
 */
public abstract class ESFArticle_ESFOrderBaseImpl
	extends ESFArticle_ESFOrderModelImpl implements ESFArticle_ESFOrder {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a e s f article_ e s f order model instance should use the {@link ESFArticle_ESFOrder} interface instead.
	 */
	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ESFArticle_ESFOrderLocalServiceUtil.addESFArticle_ESFOrder(this);
		}
		else {
			ESFArticle_ESFOrderLocalServiceUtil.updateESFArticle_ESFOrder(this);
		}
	}
}