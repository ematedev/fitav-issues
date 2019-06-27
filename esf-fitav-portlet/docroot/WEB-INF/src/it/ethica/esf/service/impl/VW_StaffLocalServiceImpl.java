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

package it.ethica.esf.service.impl;

import com.liferay.portal.kernel.exception.SystemException;

import it.ethica.esf.NoSuchVW_ShootersException;
import it.ethica.esf.NoSuchVW_StaffException;
import it.ethica.esf.model.VW_Shooters;
import it.ethica.esf.model.VW_Staff;
import it.ethica.esf.service.base.VW_StaffLocalServiceBaseImpl;

/**
 * The implementation of the v w_ staff local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link it.ethica.esf.service.VW_StaffLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Ethica
 * @see it.ethica.esf.service.base.VW_StaffLocalServiceBaseImpl
 * @see it.ethica.esf.service.VW_StaffLocalServiceUtil
 */
public class VW_StaffLocalServiceImpl extends VW_StaffLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link it.ethica.esf.service.VW_StaffLocalServiceUtil} to access the v w_ staff local service.
	 */
	
	public VW_Staff cercaStaff(long userId) throws NoSuchVW_StaffException, SystemException{
		VW_Staff staff = null;
		
		staff = vw_StaffPersistence.findByfindByUserId(userId);
		return staff;
		}
	
}