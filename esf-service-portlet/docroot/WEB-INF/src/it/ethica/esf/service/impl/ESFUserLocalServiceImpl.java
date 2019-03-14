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

import it.ethica.esf.ESFUserPortalUserException;
import it.ethica.esf.model.ESFDocument;
import it.ethica.esf.model.ESFUser;
import it.ethica.esf.service.base.ESFUserLocalServiceBaseImpl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import com.liferay.portal.NoSuchUserException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Contact;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ContactLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;

/**
 * The implementation of the e s f user local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link it.ethica.esf.service.ESFUserLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Ethica
 * @see it.ethica.esf.service.base.ESFUserLocalServiceBaseImpl
 * @see it.ethica.esf.service.ESFUserLocalServiceUtil
 */
public class ESFUserLocalServiceImpl extends ESFUserLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link it.ethica.esf.service.ESFUserLocalServiceUtil} to access the e s f user local service.
	 */
	
	// Finder Methods
	public List<ESFUser> findByPortalUserId(long portalUserId) throws SystemException {
		return esfUserPersistence.findByPortalUserId(portalUserId);
	}
	
	public List<ESFUser> findByPortalUserId(long portalUserId, int start, int end) throws SystemException {
		return esfUserPersistence.findByPortalUserId(portalUserId, start, end);
	}
	
	public int countByPortalUserId(long portalUserId) throws SystemException {
		return esfUserPersistence.countByPortalUserId(portalUserId);
	}
	
	//Other Methods
	public ESFUser addESFUser(long userId, String screenName, String emailAddress, long facebookId, Locale locale, String firstName, String middleName, String lastName, int prefixId, int suffixId, boolean male, int birthdayMonth, int birthdayDay, int birthdayYear, String jobTitle, ServiceContext portalUserServiceContext, ServiceContext esfUserServiceContext) throws SystemException, PortalException {
		User user = userPersistence.findByPrimaryKey(userId);
		User portalUser = null;
		try {
			portalUser = UserLocalServiceUtil.addUser(user.getUserId(), user.getCompanyId(), true, "", "", false, screenName, emailAddress, facebookId, "", locale, firstName, middleName, lastName, prefixId, suffixId, male, birthdayMonth, birthdayDay, birthdayYear, jobTitle, new long[0], new long[0], new long[0], new long[0], false, portalUserServiceContext);
		} catch(Exception ex){
			return null;
		}
		long portalUserId = portalUser.getUserId();
		return addESFUser(userId, portalUserId, esfUserServiceContext);
	}
	
	public ESFUser addESFUser(long userId, long portalUserId, ServiceContext serviceContext) throws SystemException, PortalException {
		
		long groupId = serviceContext.getScopeGroupId();
		
		User user = userPersistence.findByPrimaryKey(userId);
		
		Date now = new Date();
		
		validate(portalUserId); 
		
		long esfUserId = counterLocalService.increment();
		
		ESFUser esfUser = esfUserPersistence.create(esfUserId);
		
		esfUser.setUuid(serviceContext.getUuid());
		esfUser.setGroupId(groupId);
		esfUser.setCompanyId(user.getCompanyId());
		esfUser.setUserId(userId);
		esfUser.setUserName(user.getFullName());
		esfUser.setCreateDate(serviceContext.getCreateDate(now));
		esfUser.setModifiedDate(serviceContext.getModifiedDate(now));
		esfUser.setExpandoBridgeAttributes(serviceContext);
		esfUser.setPortalUserId(portalUserId);
		
		esfUserPersistence.update(esfUser);
		
		resourceLocalService.addResources(user.getCompanyId(), groupId, userId, ESFUser.class.getName(), esfUserId, false, true, true);
		
		Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(ESFUser.class);
		
		indexer.reindex(esfUser);
		
		return esfUser;
	}
	
	public ESFUser deleteESFUser(long esfUserId, long portalUserId, ServiceContext serviceContext) throws PortalException, SystemException {
		ESFUser esfUser = getESFUser(esfUserId);
		User portalUser = userPersistence.findByPrimaryKey(portalUserId);
		
		resourceLocalService.deleteResource(serviceContext.getCompanyId(), ESFUser.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL, esfUserId);
		
		esfUser = deleteESFUser(esfUser);
		
		userLocalService.deleteUser(portalUser);
		
		Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(ESFDocument.class);
		
		indexer.delete(esfUser);
		
		return esfUser;
	}
	
	public ESFUser deleteESFUser(long esfUserId, ServiceContext serviceContext) throws PortalException, SystemException {
		ESFUser esfUser = getESFUser(esfUserId);
		
		resourceLocalService.deleteResource(serviceContext.getCompanyId(), ESFUser.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL, esfUserId);
		
		esfUser = deleteESFUser(esfUser);
		
		Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(ESFDocument.class);
		
		indexer.delete(esfUser);
		
		return esfUser;
	}
	
	public ESFUser updateESFUser(long userId, long esfUserId, String emailAddress, String firstName, String lastName, boolean male, int birthdayMonth, int birthdayDay, int birthdayYear, ServiceContext serviceContext) throws SystemException, PortalException {
		ESFUser esfUser = esfUserPersistence.findByPrimaryKey(esfUserId);
		long portalUserId = esfUser.getPortalUserId();
		
		User portalUser = userPersistence.findByPrimaryKey(portalUserId);
		Contact portalUserContact = portalUser.getContact();
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(Calendar.DAY_OF_MONTH, birthdayDay);
		calendar.set(Calendar.MONTH, birthdayMonth);
		calendar.set(Calendar.YEAR, birthdayYear);
		Date portalUserBirthday = calendar.getTime();
		
		portalUser.setEmailAddress(emailAddress);
		portalUser.setFirstName(firstName);
		portalUser.setLastName(lastName);
		portalUserContact.setMale(male);
		portalUserContact.setBirthday(portalUserBirthday);
		
		userLocalService.updateUser(portalUser);
		ContactLocalServiceUtil.updateContact(portalUserContact);
		
		return updateESFUser(userId, esfUserId, portalUserId, serviceContext);
	}
	
	public ESFUser updateESFUser(long userId, long esfUserId, long portalUserId, ServiceContext serviceContext) throws SystemException, PortalException {
		long groupId = serviceContext.getScopeGroupId();
		
		User user = userPersistence.findByPrimaryKey(userId);
		
		Date now = new Date();
		
		validate(portalUserId);
		
		ESFUser esfUser = getESFUser(esfUserId);
		
		esfUser.setUuid(serviceContext.getUuid());
		esfUser.setGroupId(groupId);
		esfUser.setCompanyId(user.getCompanyId());
		esfUser.setUserId(userId);
		esfUser.setUserName(user.getFullName());
		esfUser.setCreateDate(serviceContext.getCreateDate(now));
		esfUser.setModifiedDate(serviceContext.getModifiedDate(now));
		esfUser.setExpandoBridgeAttributes(serviceContext);
		esfUser.setPortalUserId(portalUserId);
		
		esfUserPersistence.update(esfUser);
		
		resourceLocalService.updateResources(user.getCompanyId(), groupId, ESFUser.class.getName(), esfUserId, serviceContext.getGroupPermissions(), serviceContext.getGroupPermissions());
		
		Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(ESFDocument.class);
		
		indexer.reindex(esfUser);
		
		return esfUser;
	}
	
	protected void validate (long portalUserId) throws PortalException, SystemException {
		if(Validator.isNull(portalUserId) || portalUserId <= 0) {
			try{
				userPersistence.findByPrimaryKey(portalUserId);
			} catch(NoSuchUserException ex) {
				throw new ESFUserPortalUserException();
			}
		}
	}
}