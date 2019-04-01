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

import com.ethica.esf.model.ESFArticle_ESFUser;
import com.ethica.esf.service.ESFArticle_ESFUserLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The extended model base implementation for the ESFArticle_ESFUser service. Represents a row in the &quot;ESFArticle_ESFUser&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ESFArticle_ESFUserImpl}.
 * </p>
 *
 * @author Ethica
 * @see ESFArticle_ESFUserImpl
 * @see com.ethica.esf.model.ESFArticle_ESFUser
 * @generated
 */
public abstract class ESFArticle_ESFUserBaseImpl
	extends ESFArticle_ESFUserModelImpl implements ESFArticle_ESFUser {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a e s f article_ e s f user model instance should use the {@link ESFArticle_ESFUser} interface instead.
	 */
	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ESFArticle_ESFUserLocalServiceUtil.addESFArticle_ESFUser(this);
		}
		else {
			ESFArticle_ESFUserLocalServiceUtil.updateESFArticle_ESFUser(this);
		}
	}
}