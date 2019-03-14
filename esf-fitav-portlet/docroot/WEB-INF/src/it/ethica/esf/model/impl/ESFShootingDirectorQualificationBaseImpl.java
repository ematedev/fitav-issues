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

package it.ethica.esf.model.impl;

import com.liferay.portal.kernel.exception.SystemException;

import it.ethica.esf.model.ESFShootingDirectorQualification;
import it.ethica.esf.service.ESFShootingDirectorQualificationLocalServiceUtil;

/**
 * The extended model base implementation for the ESFShootingDirectorQualification service. Represents a row in the &quot;ESFShootingDirectorQualification&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ESFShootingDirectorQualificationImpl}.
 * </p>
 *
 * @author Ethica
 * @see ESFShootingDirectorQualificationImpl
 * @see it.ethica.esf.model.ESFShootingDirectorQualification
 * @generated
 */
public abstract class ESFShootingDirectorQualificationBaseImpl
	extends ESFShootingDirectorQualificationModelImpl
	implements ESFShootingDirectorQualification {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a e s f shooting director qualification model instance should use the {@link ESFShootingDirectorQualification} interface instead.
	 */
	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ESFShootingDirectorQualificationLocalServiceUtil.addESFShootingDirectorQualification(this);
		}
		else {
			ESFShootingDirectorQualificationLocalServiceUtil.updateESFShootingDirectorQualification(this);
		}
	}
}