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

import it.ethica.esf.ESFDocumentNumberException;
import it.ethica.esf.model.ESFDocument;
import it.ethica.esf.service.base.ESFDocumentLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;

/**
 * The implementation of the e s f document local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link it.ethica.esf.service.ESFDocumentLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Ethica
 * @see it.ethica.esf.service.base.ESFDocumentLocalServiceBaseImpl
 * @see it.ethica.esf.service.ESFDocumentLocalServiceUtil
 */
public class ESFDocumentLocalServiceImpl extends ESFDocumentLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link it.ethica.esf.service.ESFDocumentLocalServiceUtil} to access the e s f document local service.
	 */
	
	//Finder Methods
	public List<ESFDocument> findByIssuer(String issuer) throws SystemException {
		return esfDocumentPersistence.findByIssuer(issuer);
	}
	
	public List<ESFDocument> findByIssuer(String issuer, int start, int end) throws SystemException {
		return esfDocumentPersistence.findByIssuer(issuer, start, end);
	}
	
	public int countByIssuer(String issuer) throws SystemException {
		return esfDocumentPersistence.countByIssuer(issuer);
	}
	
	public List<ESFDocument> findByLocationReference(String locationReference) throws SystemException {
		return esfDocumentPersistence.findByLocationReference(locationReference);
	}
	
	public List<ESFDocument> findByLocationReference(String locationReference, int start, int end) throws SystemException {
		return esfDocumentPersistence.findByLocationReference(locationReference, start, end);
	}
	
	public int countByLocationReference(String locationReference) throws SystemException {
		return esfDocumentPersistence.countByLocationReference(locationReference);
	}
	
	public List<ESFDocument> findByName(String name) throws SystemException {
		return esfDocumentPersistence.findByName(name);
	}
	
	public List<ESFDocument> findByName(String name, int start, int end) throws SystemException {
		return esfDocumentPersistence.findByName(name, start, end);
	}
	
	public int countByName(String name) throws SystemException {
		return esfDocumentPersistence.countByName(name);
	}
	
	public List<ESFDocument> findByNumber(long number) throws SystemException {
		return esfDocumentPersistence.findByNumber(number);
	}
	
	public List<ESFDocument> findByNumber(long number, int start, int end) throws SystemException {
		return esfDocumentPersistence.findByNumber(number, start, end);
	}
	
	public int countByNumber(long number) throws SystemException {
		return esfDocumentPersistence.countByNumber(number);
	}	
	
	public List<ESFDocument> findByO_O(long ownerId, String ownerType) throws SystemException {
		return esfDocumentPersistence.findByO_O(ownerId, ownerType);
	}
	
	public List<ESFDocument> findByO_O(long ownerId, String ownerType, int start, int end) throws SystemException {
		return esfDocumentPersistence.findByO_O(ownerId, ownerType, start, end);
	}
	
	public int countByO_O(long ownerId, String ownerType) throws SystemException {
		return esfDocumentPersistence.countByO_O(ownerId, ownerType);
	}
	
	public ESFDocument addESFDocument(long userId, long ownerId,
			String ownerType, String type, String name, long number,
			Date releaseDate, Date expireDate, String issuer, String contents,
			String locationReference, ServiceContext serviceContext)
			throws SystemException, PortalException {
		long groupId = serviceContext.getScopeGroupId();
		
		User user = userPersistence.findByPrimaryKey(userId);
		
		Date now = new Date();
		
		validate(number);
		
		long esfDocumentId = counterLocalService.increment();
		
		ESFDocument esfDocument = esfDocumentPersistence.create(esfDocumentId);
		
		esfDocument.setUuid(serviceContext.getUuid());
		esfDocument.setGroupId(groupId);
		esfDocument.setCompanyId(user.getCompanyId());
		esfDocument.setUserId(userId);
		esfDocument.setUserName(user.getFullName());
		esfDocument.setCreateDate(serviceContext.getCreateDate(now));
		esfDocument.setModifiedDate(serviceContext.getModifiedDate(now));
		esfDocument.setOwnerId(ownerId);
		esfDocument.setOwnerType(ownerType);		
		esfDocument.setName(name);
		esfDocument.setNumber(number);
		esfDocument.setReleaseDate(releaseDate);
		esfDocument.setExpireDate(expireDate);
		esfDocument.setIssuer(issuer);
		esfDocument.setContents(contents);
		esfDocument.setLocationReference(locationReference);
		
		esfDocumentPersistence.update(esfDocument);
		
//		resourceLocalService.addResources(user.getCompanyId(), groupId, userId, ESFDocument.class.getName(), esfDocumentId, false, true, true);
		
		Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(ESFDocument.class);
		
		indexer.reindex(esfDocument);
		
		return esfDocument;
	}
	
	public ESFDocument deleteESFDocument(long esfDocumentId, ServiceContext serviceContext) throws SystemException, PortalException {
		ESFDocument esfDocument = getESFDocument(esfDocumentId);
		
//		resourceLocalService.deleteResource(serviceContext.getCompanyId(), ESFDocument.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL, esfDocumentId);
		
		esfDocument = deleteESFDocument(esfDocument);
		
		Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(ESFDocument.class);
		
		indexer.delete(esfDocument);
		
		return esfDocument;
	}
	
	public ESFDocument updateESFDocument(long userId, long esfDocumentId, long ownerId,
			String ownerType, String type, String name, long number,
			Date releaseDate, Date expireDate, String issuer, String contents,
			String locationReference, ServiceContext serviceContext)
			throws SystemException, PortalException {
		long groupId = serviceContext.getScopeGroupId();
		
		User user = userPersistence.findByPrimaryKey(userId);
		
		Date now = new Date();
		
		validate(number);
		
		ESFDocument esfDocument = getESFDocument(esfDocumentId);
		
		esfDocument.setUuid(serviceContext.getUuid());
		esfDocument.setGroupId(groupId);
		esfDocument.setCompanyId(user.getCompanyId());
		esfDocument.setUserId(userId);
		esfDocument.setUserName(user.getFullName());
		esfDocument.setCreateDate(serviceContext.getCreateDate(now));
		esfDocument.setModifiedDate(serviceContext.getModifiedDate(now));
		esfDocument.setOwnerId(ownerId);
		esfDocument.setOwnerType(ownerType);
		esfDocument.setName(name);
		esfDocument.setNumber(number);
		esfDocument.setReleaseDate(releaseDate);
		esfDocument.setExpireDate(expireDate);
		esfDocument.setIssuer(issuer);
		esfDocument.setContents(contents);
		esfDocument.setLocationReference(locationReference);
		
		esfDocumentPersistence.update(esfDocument);
		
//		resourceLocalService.updateResources(user.getCompanyId(), groupId, ESFDocument.class.getName(), esfDocumentId, serviceContext.getGroupPermissions(), serviceContext.getGroupPermissions());
		
		Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(ESFDocument.class);
		
		indexer.reindex(esfDocument);
		
		return esfDocument;
	}
	
	protected void validate (long number) throws PortalException, SystemException {
		if(Validator.isNull(number)) {
			throw new ESFDocumentNumberException();
		}
	}
}