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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;

import it.ethica.esf.ESFGunTypeNameException;
import it.ethica.esf.NoSuchGunTypeException;
import it.ethica.esf.model.ESFGunType;
import it.ethica.esf.service.ESFGunTypeLocalServiceUtil;
import it.ethica.esf.service.base.ESFGunTypeLocalServiceBaseImpl;

/**
 * The implementation of the e s f gun type local service. <p> All custom
 * service methods should be put in this class. Whenever methods are added,
 * rerun ServiceBuilder to copy their definitions into the
 * {@link it.ethica.esf.service.ESFGunTypeLocalService} interface. <p> This is a
 * local service. Methods of this service will not have security checks based on
 * the propagated JAAS credentials because this service can only be accessed
 * from within the same VM. </p>
 *
 * @author Ethica
 * @see it.ethica.esf.service.base.ESFGunTypeLocalServiceBaseImpl
 * @see it.ethica.esf.service.ESFGunTypeLocalServiceUtil
 */
public class ESFGunTypeLocalServiceImpl extends ESFGunTypeLocalServiceBaseImpl {

	public List<ESFGunType> getESFGunTypes()
		throws SystemException {

		return esfGunTypePersistence.findAll();
	}
	
	public List<ESFGunType> getisCatridgeProductor(boolean isCatridgeProductor)
			throws SystemException, NoSuchGunTypeException {
			
			List<ESFGunType> gunTypes = new ArrayList<ESFGunType>();
			List<ESFGunType> gunTypesisCatridgeProductor = new ArrayList<ESFGunType>();
			
			gunTypes = ESFGunTypeLocalServiceUtil.getESFGunTypes();
			
			for(ESFGunType gunType : gunTypes){
				if(isCatridgeProductor == gunType.getIsCatridgeProductor()){
					gunTypesisCatridgeProductor.add(gunType);
				}
			}
			

			return gunTypesisCatridgeProductor;
		}

	public List<ESFGunType> getESFGunTypes(int start, int end)
		throws SystemException {

		return esfGunTypePersistence.findAll(start, end);
	}

	public ESFGunType addESFGunType(
		long userId, String name, String description, boolean isCatridgeProductor,
		ServiceContext serviceContext)
		throws SystemException, PortalException {

		long groupId = serviceContext.getScopeGroupId();

		User user = userPersistence.findByPrimaryKey(userId);

		Date now = new Date();

		validate(name);

		long esfGunTypeId = counterLocalService.increment();

		ESFGunType esfGunType = esfGunTypePersistence.create(esfGunTypeId);

		esfGunType.setUserId(userId);
		esfGunType.setGroupId(groupId);
		esfGunType.setCompanyId(user.getCompanyId());
		esfGunType.setUserName(user.getFullName());
		esfGunType.setCreateDate(serviceContext.getCreateDate(now));
		esfGunType.setModifiedDate(serviceContext.getModifiedDate(now));
		esfGunType.setName(name);
		esfGunType.setDescription(description);
		esfGunType.setIsCatridgeProductor(isCatridgeProductor);
		esfGunType.setExpandoBridgeAttributes(serviceContext);

		esfGunTypePersistence.update(esfGunType);

		resourceLocalService.addResources(
			user.getCompanyId(), groupId, userId, ESFGunType.class.getName(),
			esfGunTypeId, false, true, true);

		return esfGunType;

	}

	public ESFGunType updateESFGunType(
		long userId, long esfGunTypeId, String name, String description, boolean isCatridgeProductor,
		ServiceContext serviceContext)
		throws PortalException, SystemException {

		Date now = new Date();

		validate(name);

		ESFGunType esfGunType = getESFGunType(esfGunTypeId);

		User user = UserLocalServiceUtil.getUser(userId);

		esfGunType.setUserId(userId);
		esfGunType.setUserName(user.getFullName());
		esfGunType.setModifiedDate(serviceContext.getModifiedDate(now));
		esfGunType.setName(name);
		esfGunType.setDescription(description);
		esfGunType.setIsCatridgeProductor(isCatridgeProductor);
		esfGunType.setExpandoBridgeAttributes(serviceContext);

		esfGunTypePersistence.update(esfGunType);

		resourceLocalService.updateResources(
			serviceContext.getCompanyId(), serviceContext.getScopeGroupId(),
			name, esfGunTypeId, serviceContext.getGroupPermissions(),
			serviceContext.getGuestPermissions());

		return esfGunType;
	}

	public ESFGunType deleteESFGunType(
		long esfGunTypeId, ServiceContext serviceContext)
		throws PortalException, SystemException {

		ESFGunType esfGunType = getESFGunType(esfGunTypeId);

		resourceLocalService.deleteResource(
			serviceContext.getCompanyId(), ESFGunType.class.getName(),
			ResourceConstants.SCOPE_INDIVIDUAL, esfGunTypeId);

		esfGunType = deleteESFGunType(esfGunTypeId);

		return esfGunType;
	}

	public ESFGunType checkNome(String name, ServiceContext serviceContext)
		throws PortalException, SystemException {

		if (Validator.isNotNull(name) && !Validator.isBlank(name)) {
			return esfGunTypePersistence.fetchByname(name);
		}

		return null;
	}

	protected void validate(String name)
		throws PortalException {

		if (Validator.isNull(name)) {
			throw new ESFGunTypeNameException();
		}
	}
}
