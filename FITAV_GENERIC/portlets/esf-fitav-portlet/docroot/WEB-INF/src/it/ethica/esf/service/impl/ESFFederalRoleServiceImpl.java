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

import it.ethica.esf.model.ESFFederalRole;
import it.ethica.esf.model.ESFFederalRoleESFSpecific;
import it.ethica.esf.model.ESFSpecific;
import it.ethica.esf.service.ESFFederalRoleESFSpecificLocalServiceUtil;
import it.ethica.esf.service.base.ESFFederalRoleServiceBaseImpl;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GroupThreadLocal;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.ActionKeys;

/**
 * The implementation of the e s f federal role remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link it.ethica.esf.service.ESFFederalRoleService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Ethica
 * @see it.ethica.esf.service.base.ESFFederalRoleServiceBaseImpl
 * @see it.ethica.esf.service.ESFFederalRoleServiceUtil
 */
public class ESFFederalRoleServiceImpl extends ESFFederalRoleServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link it.ethica.esf.service.ESFFederalRoleServiceUtil} to access the e s f federal role remote service.
	 */
	
	public ESFFederalRole updateEsfFederalRole(
			long esfFederalRoleId, 
			String name, 
			String description,
			boolean regional,
			boolean provincial) throws SystemException, PrincipalException{
		if(getPermissionChecker().hasPermission(
				GroupThreadLocal.getGroupId(), 
				ESFFederalRole.class.getName(), 
				esfFederalRoleId, 
				ActionKeys.UPDATE)){
			return esfFederalRoleLocalService.updateEsfFederalRole(esfFederalRoleId, name, description, regional, provincial);
		}else{
			return null;
		}
	}

	public List<ESFSpecific> getFederalRoleSpecifics(long esfFederalRoleId){
		return esfFederalRoleLocalService.getFederalRoleSpecifics(esfFederalRoleId);
	}
	
	public List<ESFFederalRole> findByCode(String name){
		return esfFederalRoleLocalService.findByCode(name);
	}
}