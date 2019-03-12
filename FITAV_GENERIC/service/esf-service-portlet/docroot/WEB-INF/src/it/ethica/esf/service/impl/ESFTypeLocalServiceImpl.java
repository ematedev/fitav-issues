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

import com.liferay.portal.NoSuchUserException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;

import it.ethica.esf.NoSuchTypeException;
import it.ethica.esf.model.ESFType;
import it.ethica.esf.service.base.ESFTypeLocalServiceBaseImpl;

/**
 * The implementation of the e s f type local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link it.ethica.esf.service.ESFTypeLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Ethica
 * @see it.ethica.esf.service.base.ESFTypeLocalServiceBaseImpl
 * @see it.ethica.esf.service.ESFTypeLocalServiceUtil
 */
public class ESFTypeLocalServiceImpl extends ESFTypeLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link it.ethica.esf.service.ESFTypeLocalServiceUtil} to access the e s f type local service.
	 */
	
	// Finder Methods
	public ESFType findByCode(String code) throws NoSuchTypeException, SystemException {
		
		return esfTypePersistence.findByCode(code);
	}
	
	public List<ESFType> findByName(String name) throws NoSuchTypeException, SystemException {
		
		return esfTypePersistence.findByName(name);
	}
	
	public List<ESFType> findByName(String name, int start, int end) throws NoSuchTypeException, SystemException {
		
		return esfTypePersistence.findByName(name, start, end);
	}
	
	public int countByName(String name) throws NoSuchTypeException, SystemException {
		
		return esfTypePersistence.countByName(name);
	}
	
	public List<ESFType> findByClassName(String className) throws NoSuchTypeException, SystemException {
		
		return esfTypePersistence.findByClassName(className);
	}
	
	public List<ESFType> findByClassName(String className, int start, int end) throws NoSuchTypeException, SystemException {
		
		return esfTypePersistence.findByClassName(className, start, end);
	}
	
	public int countByClassName(String className) throws NoSuchTypeException, SystemException {
		
		return esfTypePersistence.countByClassName(className);
	}
	
	public List<ESFType> findByStatus(String status) throws NoSuchTypeException, SystemException {
		
		return esfTypePersistence.findByStatus(status);
	}
	
	public List<ESFType> findByStatus(String status, int start, int end) throws NoSuchTypeException, SystemException {
		
		return esfTypePersistence.findByStatus(status, start, end);
	}
	
	public int countByStatus(String status) throws NoSuchTypeException, SystemException {
		
		return esfTypePersistence.countByClassName(status);
	}
	
	public List<ESFType> findByTypeParentId(long parentId) throws NoSuchTypeException, SystemException {
		
		return esfTypePersistence.findByTypeParentId(parentId);
	}
	
	public List<ESFType> findByTypeParentId(long parentId, int start, int end) throws NoSuchTypeException, SystemException {
		
		return esfTypePersistence.findByTypeParentId(parentId, start, end);
	}
	
	public int countByTypeParentId(long parentId) throws NoSuchTypeException, SystemException {
		
		return esfTypePersistence.countByTypeParentId(parentId);
	}
	
	// Other Methods
	public ESFType addESFType(long userId, String code, String name, String description, String className, String status, long typeParentId, ServiceContext serviceContext) throws NoSuchUserException, SystemException, SearchException {
		
		long groupId = serviceContext.getScopeGroupId();
		
		User user = userPersistence.findByPrimaryKey(userId);
		
		Date now = new Date();
		
		//validate(portalUserId); 
		
		long esfTypeId = counterLocalService.increment();
		
		ESFType esfType = esfTypePersistence.create(esfTypeId);
		
		esfType.setGroupId(groupId);
		esfType.setCompanyId(user.getCompanyId());
		esfType.setUserId(userId);
		esfType.setUserName(user.getFullName());
		esfType.setCreateDate(serviceContext.getCreateDate(now));
		esfType.setModifiedDate(serviceContext.getModifiedDate(now));
		esfType.setExpandoBridgeAttributes(serviceContext);
		esfType.setCode(code);
		esfType.setName(name);
		esfType.setDescription(description);
		esfType.setClassName(className);
		esfType.setStatus(status);
		esfType.setTypeParentId(typeParentId);
		
		esfTypePersistence.update(esfType);
		
		Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(ESFType.class);
		
		indexer.reindex(esfType);
		
		return esfType;
	}
	
	
	
	public ESFType deleteESFType(long esfTypeId, ServiceContext serviceContext) throws PortalException, SystemException {
		ESFType esfType = getESFType(esfTypeId);
		
		resourceLocalService.deleteResource(serviceContext.getCompanyId(), ESFType.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL, esfTypeId);
		
		esfType = deleteESFType(esfType);
		
		Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(ESFType.class);
		
		indexer.delete(esfType);
		
		return esfType;
	}
	
	public ESFType updateESFType(long userId, long esfTypeId, String code, String name, String description, String className, String status, long typeParentId, ServiceContext serviceContext) throws SystemException, PortalException {
		
		Date now = new Date();
		
		ESFType esfType = getESFType(esfTypeId);
		
		esfType.setModifiedDate(serviceContext.getModifiedDate(now));
		esfType.setCode(code);
		esfType.setName(name);
		esfType.setDescription(description);
		esfType.setClassName(className);
		esfType.setStatus(status);
		esfType.setTypeParentId(typeParentId);
		
		esfTypePersistence.update(esfType);
		
		Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(ESFType.class);
		
		indexer.reindex(esfType);
		
		return esfType;
	}
	
}