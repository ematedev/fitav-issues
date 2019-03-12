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

import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;

import it.ethica.esf.ESFUserRoleNameException;
import it.ethica.esf.model.ESFUserRole;
import it.ethica.esf.service.base.ESFUserRoleLocalServiceBaseImpl;

/**
 * The implementation of the e s f user role local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link it.ethica.esf.service.ESFUserRoleLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Ethica
 * @see it.ethica.esf.service.base.ESFUserRoleLocalServiceBaseImpl
 * @see it.ethica.esf.service.ESFUserRoleLocalServiceUtil
 */
public class ESFUserRoleLocalServiceImpl extends ESFUserRoleLocalServiceBaseImpl {

	public List<ESFUserRole> getAllEsfUserRole() throws SystemException {
		return esfUserRolePersistence.findAll();
	}

	public int getAllEsfUserRoleCount() throws SystemException {
		return esfUserRolePersistence.countAll();
	}
	
	public ESFUserRole addESFUserRole(long userId, String name,
			String description, boolean isBDO, boolean isLEA,
			ServiceContext esfUserRoleServiceContext)
					throws PortalException, SystemException {

		User user = userPersistence.findByPrimaryKey(userId);

		Date now = new Date();

		long groupId = esfUserRoleServiceContext.getScopeGroupId();

		validate(name);

		long esfUserRoleId = counterLocalService.increment();

		ESFUserRole esfUserRole = esfUserRolePersistence.create(esfUserRoleId);
		
		esfUserRole.setCompanyId(esfUserRoleServiceContext.getCompanyId());
		esfUserRole.setGroupId(esfUserRoleServiceContext.getScopeGroupId());
		esfUserRole.setUserId(userId);
		esfUserRole.setUserName(user.getScreenName());
		esfUserRole.setCreateDate(now);
		esfUserRole.setModifiedDate(now);
		esfUserRole.setUuid(esfUserRoleServiceContext.getUuid());
		esfUserRole.setExpandoBridgeAttributes(esfUserRoleServiceContext);
		esfUserRole.setName(name);
		esfUserRole.setDescription(description);
		esfUserRole.setIsBDO(isBDO);
		esfUserRole.setIsLEA(isLEA);

		esfUserRolePersistence.update(esfUserRole);

		resourceLocalService.addResources(
			user.getCompanyId(), groupId, userId, ESFUserRole.class.getName(),
			esfUserRoleId, false, true, true);

		return esfUserRole;
	}

	public ESFUserRole deleteESFUserRole(long esfUserRoleId,
			ServiceContext serviceContext)
					throws PortalException, SystemException {

		ESFUserRole esfUserRole = getESFUserRole(esfUserRoleId);

		resourceLocalService.deleteResource(
			serviceContext.getCompanyId(), ESFUserRole.class.getName(),
			ResourceConstants.SCOPE_INDIVIDUAL, esfUserRoleId);

		esfUserRole = deleteESFUserRole(esfUserRole);

		return esfUserRole;
	}

	public ESFUserRole updateESFUserRole(long userId, long esfUserRoleId,
			String name, String description, boolean isBDO, boolean isLEA,
			ServiceContext esfUserRoleServiceContext)
					throws SystemException, PortalException {

		User user = userPersistence.findByPrimaryKey(userId);

		Date now = new Date();

		long groupId = esfUserRoleServiceContext.getScopeGroupId();

		validate(name);

		ESFUserRole esfUserRole = getESFUserRole(esfUserRoleId);

		esfUserRole.setUserId(userId);
		esfUserRole.setUserName(user.getScreenName());
		esfUserRole.setModifiedDate(now);
		esfUserRole.setExpandoBridgeAttributes(esfUserRoleServiceContext);
		esfUserRole.setName(name);
		esfUserRole.setDescription(description);
		esfUserRole.setIsBDO(isBDO);
		esfUserRole.setIsLEA(isLEA);

		esfUserRolePersistence.update(esfUserRole);

		resourceLocalService.updateResources(
			user.getCompanyId(), groupId, ESFUserRole.class.getName(),
			esfUserRoleId, esfUserRoleServiceContext.getGroupPermissions(),
			esfUserRoleServiceContext.getGroupPermissions());

		return esfUserRole;
	}

	protected void validate(String name) throws PortalException {
		if (Validator.isNull(name)) {
			throw new ESFUserRoleNameException();
		}
	}
}