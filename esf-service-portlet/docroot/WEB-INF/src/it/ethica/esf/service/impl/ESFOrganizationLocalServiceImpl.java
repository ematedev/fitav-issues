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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.Organization;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.OrganizationLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;

import it.ethica.esf.model.ESFOrganization;
import it.ethica.esf.service.base.ESFOrganizationLocalServiceBaseImpl;

/**
 * The implementation of the e s f organization local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link it.ethica.esf.service.ESFOrganizationLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Ethica
 * @see it.ethica.esf.service.base.ESFOrganizationLocalServiceBaseImpl
 * @see it.ethica.esf.service.ESFOrganizationLocalServiceUtil
 */
public class ESFOrganizationLocalServiceImpl
	extends ESFOrganizationLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link it.ethica.esf.service.ESFOrganizationLocalServiceUtil} to access the e s f organization local service.
	 */
	//Other Methods
	public ESFOrganization addESFOrganization(long userId, String name, ServiceContext esfOrgServiceContext, ServiceContext portalOrgServiceContext) throws PortalException, SystemException{
		
		Organization organization = OrganizationLocalServiceUtil.addOrganization(userId, 0, name, "regular-organization", 0, 0, 12017, "", false, portalOrgServiceContext);
		
		long portalOrganizationId = organization.getOrganizationId();
		
		return addESFOrganization(userId, portalOrganizationId, portalOrgServiceContext);
		
	}
	
	private ESFOrganization addESFOrganization(long userId, long portalOrganizationId, ServiceContext serviceContext) throws SystemException, PortalException {
		
		long groupId = serviceContext.getScopeGroupId();
		
		User user = userPersistence.findByPrimaryKey(userId);
		
		Date now = new Date();
		
		//validate(portalOrganizationId); 
		
		long esfOrganizationId = counterLocalService.increment();
		
		ESFOrganization esfOrganization = esfOrganizationPersistence.create(esfOrganizationId);
		
		esfOrganization.setUuid(serviceContext.getUuid());
		esfOrganization.setGroupId(groupId);
		esfOrganization.setCompanyId(user.getCompanyId());
		esfOrganization.setUserId(userId);
		esfOrganization.setUserName(user.getFullName());
		esfOrganization.setCreateDate(serviceContext.getCreateDate(now));
		esfOrganization.setModifiedDate(serviceContext.getModifiedDate(now));
		esfOrganization.setExpandoBridgeAttributes(serviceContext);
		esfOrganization.setPortalOrganizationId(portalOrganizationId);
		
		esfOrganizationPersistence.update(esfOrganization);
		
		resourceLocalService.addResources(user.getCompanyId(), groupId, userId, ESFOrganization.class.getName(), esfOrganizationId, false, true, true);
		
//		Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(ESFOrganization.class);
//		
//		indexer.reindex(esfOrganization);
		
		return esfOrganization;
	}
	
	public ESFOrganization deleteESFOrganization(long esfOrganizationId, ServiceContext serviceContext) throws PortalException, SystemException {
		
		long portalOrganizationId = getESFOrganization(esfOrganizationId).getPortalOrganizationId();
		
		return deleteESFOrganization(esfOrganizationId, portalOrganizationId, serviceContext);
	}
	
	private ESFOrganization deleteESFOrganization(long esfOrganizationId, long portalOrganizationId, ServiceContext serviceContext) throws PortalException, SystemException {
		
		ESFOrganization esfOrganization = getESFOrganization(esfOrganizationId);
		
		Organization portalOrganization = organizationPersistence.findByPrimaryKey(portalOrganizationId);
		
		resourceLocalService.deleteResource(serviceContext.getCompanyId(), ESFOrganization.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL, esfOrganizationId);
		
		esfOrganization = deleteESFOrganization(esfOrganizationId);
		
		organizationLocalService.deleteOrganization(portalOrganization);
		
//		Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(ESFDocument.class);
//		
//		indexer.delete(esfUser);
		
		return esfOrganization;
	}
	
	public ESFOrganization updateESFOrganization(long userId, long esfOrganizationId, String name, ServiceContext serviceContext) throws PortalException, SystemException{
		
		ESFOrganization esfOrganization = esfOrganizationPersistence.findByPrimaryKey(esfOrganizationId);
		
		long portalOrganizationId = esfOrganization.getPortalOrganizationId();
		
		Organization portalOrganization = organizationPersistence.findByPrimaryKey(portalOrganizationId);
		
		portalOrganization.setName(name);
		
		organizationLocalService.updateOrganization(portalOrganization);
		
		return updateESFOrganization(userId, esfOrganizationId, portalOrganizationId, serviceContext);
	}
	
	private ESFOrganization updateESFOrganization(long userId, long esfOrganizationId, long portalOrganizationId, ServiceContext serviceContext) throws SystemException, PortalException {
		
		long groupId = serviceContext.getScopeGroupId();
		
		User user = userPersistence.findByPrimaryKey(userId);
		
		Date now = new Date();
		
		//validate(portalOrganizationId); 
		
		ESFOrganization esfOrganization = esfOrganizationPersistence.findByPrimaryKey(esfOrganizationId);
		
		esfOrganization.setModifiedDate(serviceContext.getModifiedDate(now));
		
		esfOrganizationPersistence.update(esfOrganization);
		
		resourceLocalService.updateResources(user.getCompanyId(), groupId, ESFOrganization.class.getName(), esfOrganizationId, serviceContext.getGroupPermissions(), serviceContext.getGroupPermissions());
		
//		Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(ESFOrganization.class);
//		
//		indexer.reindex(esfOrganization);
		
		return esfOrganization;
	}
}