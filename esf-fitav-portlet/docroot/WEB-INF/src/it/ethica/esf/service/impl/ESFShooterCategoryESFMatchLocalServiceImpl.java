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

package it.ethica.esf.service.impl;

import com.liferay.portal.kernel.exception.SystemException;

import it.ethica.esf.service.base.ESFShooterCategoryESFMatchLocalServiceBaseImpl;

/**
 * The implementation of the e s f shooter category e s f match local service.
 * <p> All custom service methods should be put in this class. Whenever methods
 * are added, rerun ServiceBuilder to copy their definitions into the
 * {@link it.ethica.esf.service.ESFShooterCategoryESFMatchLocalService}
 * interface. <p> This is a local service. Methods of this service will not have
 * security checks based on the propagated JAAS credentials because this service
 * can only be accessed from within the same VM. </p>
 *
 * @author Ethica
 * @see it.ethica.esf.service.base.ESFShooterCategoryESFMatchLocalServiceBaseImpl
 * @see it.ethica.esf.service.ESFShooterCategoryESFMatchLocalServiceUtil
 */
public class ESFShooterCategoryESFMatchLocalServiceImpl
	extends ESFShooterCategoryESFMatchLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS: Never reference this interface directly. Always use
	 * {@link it.ethica.esf.service.ESFShooterCategoryESFMatchLocalServiceUtil}
	 * to access the e s f shooter category e s f match local service.
	 */

	public void deleteESFShooterCategoryByESFMatchId(long esfMatchId)
		throws SystemException {

		esfShooterCategoryESFMatchPersistence.removeByESFMatch(esfMatchId);
	}
}
