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

import it.ethica.esf.NoSuchUserESFFederalRoleException;
import it.ethica.esf.model.ESFUser;
import it.ethica.esf.model.ESFUserESFFederalRole;
import it.ethica.esf.service.base.ESFUserESFFederalRoleLocalServiceBaseImpl;

import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the e s f user e s f federal role local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link it.ethica.esf.service.ESFUserESFFederalRoleLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Ethica
 * @see it.ethica.esf.service.base.ESFUserESFFederalRoleLocalServiceBaseImpl
 * @see it.ethica.esf.service.ESFUserESFFederalRoleLocalServiceUtil
 */
public class ESFUserESFFederalRoleLocalServiceImpl
	extends ESFUserESFFederalRoleLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link it.ethica.esf.service.ESFUserESFFederalRoleLocalServiceUtil} to access the e s f user e s f federal role local service.
	 */
	public List<ESFUserESFFederalRole> findByEsfFederalRoleId(long esfFederalRoleId) throws SystemException{
		return esfUserESFFederalRolePersistence.findByFederalRole(esfFederalRoleId);
	}
	public List<ESFUserESFFederalRole> findByEsfUserId(long esfUserId) throws SystemException{
		return esfUserESFFederalRolePersistence.findByUser(esfUserId);
	}
	public List<ESFUserESFFederalRole> findByEsfUserIdAndActive(long esfUserId, boolean active) throws SystemException{
		return esfUserESFFederalRolePersistence.findByUserActive(esfUserId, active);
	}
	public ESFUserESFFederalRole findByEsfUserIdAndEsfFederalRoleIdActive(long esfUserId, long esfFederalRoleId, boolean active) throws SystemException, NoSuchUserESFFederalRoleException{
		return esfUserESFFederalRolePersistence.findByUserAndFederalRoleActive(esfUserId, esfFederalRoleId, Boolean.TRUE);
	}

}