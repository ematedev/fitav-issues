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
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;

import it.ethica.esf.model.ESFOrganizationType;
import it.ethica.esf.service.ESFTypeLocalServiceUtil;
import it.ethica.esf.service.base.ESFOrganizationTypeLocalServiceBaseImpl;

/**
 * The implementation of the e s f organization type local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link it.ethica.esf.service.ESFOrganizationTypeLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Ethica
 * @see it.ethica.esf.service.base.ESFOrganizationTypeLocalServiceBaseImpl
 * @see it.ethica.esf.service.ESFOrganizationTypeLocalServiceUtil
 */
public class ESFOrganizationTypeLocalServiceImpl
	extends ESFOrganizationTypeLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link it.ethica.esf.service.ESFOrganizationTypeLocalServiceUtil} to access the e s f organization type local service.
	 */
	
	public List<String> getOrganizationTypes(long esfOrganizationId) throws SystemException, PortalException {
		
		List<ESFOrganizationType> esfOrganizationTypes = esfOrganizationTypePersistence.findByESFOrganizationId(esfOrganizationId);
		List<String> esfOrganizationTypesName = new ArrayList<String>();
		
		for(ESFOrganizationType esfOrganizationType : esfOrganizationTypes) {
			esfOrganizationTypesName.add(ESFTypeLocalServiceUtil.getESFType(esfOrganizationType.getEsfTypeId()).getName());
		}
		
		return esfOrganizationTypesName;
	}
	
	public ESFOrganizationType addESFOrganizationType(long userId, long esfTypeId, long esfOrganizationId, ServiceContext serviceContext) throws PortalException, SystemException {
		
		long groupId = serviceContext.getScopeGroupId();
		
		User user = userPersistence.findByPrimaryKey(userId);
		
		Date now = new Date();
		
		long esfOrganizationTypeId = counterLocalService.increment();
		
		ESFOrganizationType esfOrganizationType = esfOrganizationTypePersistence.create(esfOrganizationTypeId);
		
		esfOrganizationType.setGroupId(groupId);
		esfOrganizationType.setCompanyId(user.getCompanyId());
		esfOrganizationType.setUserId(userId);
		esfOrganizationType.setUserName(user.getFullName());
		esfOrganizationType.setCreateDate(serviceContext.getCreateDate(now));
		esfOrganizationType.setModifiedDate(serviceContext.getModifiedDate(now));
		esfOrganizationType.setExpandoBridgeAttributes(serviceContext);
		
		esfOrganizationType.setEsfTypeId(esfTypeId);
		esfOrganizationType.setEsfOrganizationId(esfOrganizationId);
		
		esfOrganizationTypePersistence.update(esfOrganizationType);
		
		return esfOrganizationType;
	}
	
	public ESFOrganizationType deleteESFOrganizationType(long esfOrganizationTypeId, ServiceContext serviceContext) throws PortalException, SystemException {
		
		return deleteESFOrganizationType(esfOrganizationTypeId);
	}
	
	public ESFOrganizationType updateESFOrganizationType(long userId, long esfOrganizationTypeId, long esfTypeId, long esfOrganizationId, ServiceContext serviceContext) throws PortalException, SystemException {
		
		Date now = new Date();
		
		ESFOrganizationType esfOrganizationType = esfOrganizationTypePersistence.findByPrimaryKey(esfOrganizationTypeId);
		
		esfOrganizationType.setModifiedDate(serviceContext.getModifiedDate(now));
		
		esfOrganizationType.setEsfTypeId(esfTypeId);
		esfOrganizationType.setEsfOrganizationId(esfOrganizationId);
		
		esfOrganizationTypePersistence.update(esfOrganizationType);
		
		return esfOrganizationType;
	}
	
}