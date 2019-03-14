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
import com.liferay.portal.service.UserLocalServiceUtil;
import it.ethica.esf.ESFGunKindNameException;
import it.ethica.esf.model.ESFGunKind;
import it.ethica.esf.service.base.ESFGunKindLocalServiceBaseImpl;

/**
 * The implementation of the e s f gun kind local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link it.ethica.esf.service.ESFGunKindLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Ethica
 * @see it.ethica.esf.service.base.ESFGunKindLocalServiceBaseImpl
 * @see it.ethica.esf.service.ESFGunKindLocalServiceUtil
 */
public class ESFGunKindLocalServiceImpl extends ESFGunKindLocalServiceBaseImpl {
	
	public List<ESFGunKind> getESFGunKinds() throws SystemException {
		return esfGunKindPersistence.findAll();
	}

	public List<ESFGunKind> getESFGunKinds(int start, int end)
			throws SystemException {
		return esfGunKindPersistence.findAll(start, end);
	}

	public List<ESFGunKind> getESFGunKindsByESFGunType(long esfGunTypeId)
			throws SystemException {
		return esfGunKindPersistence.findByEsfGunTypeId(esfGunTypeId);
	}

	public List<ESFGunKind> getESFGunKindsByESFGunType(long esfGunTypeId,
			int start, int end)
				throws SystemException {
		return esfGunKindPersistence.findByEsfGunTypeId(esfGunTypeId,
				start, end);
	}

	public int getESFGunKindCountByESFGunType(long esfGunTypeId)
			throws SystemException {
		return esfGunKindPersistence.findByEsfGunTypeId(esfGunTypeId).size();
	}

	public ESFGunKind addESFGunKind(long userId, String name,
			String description, long esfGunTypeId,
			ServiceContext serviceContext)
				throws SystemException, PortalException {

		long groupId = serviceContext.getScopeGroupId();

		User user = userPersistence.findByPrimaryKey(userId);

		Date now = new Date();

		validate(name);

		long esfGunKindId = counterLocalService.increment();

		ESFGunKind esfGunKind = esfGunKindPersistence.create(esfGunKindId);

		esfGunKind.setUserId(userId);
		esfGunKind.setGroupId(groupId);
		esfGunKind.setCompanyId(user.getCompanyId());
		esfGunKind.setUserName(user.getFullName());
		esfGunKind.setCreateDate(serviceContext.getCreateDate(now));
		esfGunKind.setModifiedDate(serviceContext.getModifiedDate(now));
		esfGunKind.setName(name);
		esfGunKind.setDescription(description);
		esfGunKind.setEsfGunTypeId(esfGunTypeId);
		esfGunKind.setExpandoBridgeAttributes(serviceContext);
		
		esfGunKindPersistence.update(esfGunKind);

		resourceLocalService.addResources(user.getCompanyId(), groupId, userId,
				ESFGunKind.class.getName(), esfGunKindId, false, true, true);

		return esfGunKind;

	}

	public ESFGunKind updateESFGunKind(long userId, long esfGunKindId,
			String name, String description, long esfGunTypeId,
			ServiceContext serviceContext)
					throws PortalException, SystemException {

		Date now = new Date();

		validate(name);

		ESFGunKind esfGunKind = getESFGunKind(esfGunKindId);
		
		User user = UserLocalServiceUtil.getUser(userId);

		esfGunKind.setUserId(userId);
		esfGunKind.setUserName(user.getFullName());
		esfGunKind.setModifiedDate(serviceContext.getModifiedDate(now));
		esfGunKind.setName(name);
		esfGunKind.setDescription(description);
		esfGunKind.setEsfGunTypeId(esfGunTypeId);
		esfGunKind.setExpandoBridgeAttributes(serviceContext);

		esfGunKindPersistence.update(esfGunKind);

		resourceLocalService.updateResources(serviceContext.getCompanyId(),
				serviceContext.getScopeGroupId(), name, esfGunKindId,
				serviceContext.getGroupPermissions(),
				serviceContext.getGuestPermissions());

		return esfGunKind;
	}

	public ESFGunKind deleteESFGunKind(long esfGunKindId,
			ServiceContext serviceContext) throws PortalException,
			SystemException {

		ESFGunKind esfGunKind = getESFGunKind(esfGunKindId);

		resourceLocalService.deleteResource(serviceContext.getCompanyId(),
				ESFGunKind.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL,
				esfGunKindId);

		esfGunKind = deleteESFGunKind(esfGunKindId);

		return esfGunKind;
	}

	protected void validate(String name) throws PortalException {
		if (Validator.isNull(name)) {
			throw new ESFGunKindNameException();
		}
	}
}