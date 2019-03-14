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
import it.ethica.esf.model.ESFFederalRole;
import it.ethica.esf.model.ESFFederalRoleESFSpecific;
import it.ethica.esf.model.ESFOrganization;
import it.ethica.esf.model.ESFSpecific;
import it.ethica.esf.model.ESFUser;
import it.ethica.esf.model.ESFUserESFFederalRole;
import it.ethica.esf.service.ESFFederalRoleESFSpecificLocalServiceUtil;
import it.ethica.esf.service.ESFFederalRoleLocalServiceUtil;
import it.ethica.esf.service.ESFOrganizationLocalServiceUtil;
import it.ethica.esf.service.ESFUserESFFederalRoleLocalServiceUtil;
import it.ethica.esf.service.ESFUserLocalServiceUtil;
import it.ethica.esf.service.base.ESFFederalRoleLocalServiceBaseImpl;
import it.ethica.esf.service.persistence.ESFUserESFFederalRolePK;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GroupThreadLocal;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.CompanyThreadLocal;
import com.liferay.portal.security.auth.PrincipalThreadLocal;
import com.liferay.portal.service.UserLocalServiceUtil;

/**
 * The implementation of the e s f federal role local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link it.ethica.esf.service.ESFFederalRoleLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Ethica
 * @see it.ethica.esf.service.base.ESFFederalRoleLocalServiceBaseImpl
 * @see it.ethica.esf.service.ESFFederalRoleLocalServiceUtil
 */
public class ESFFederalRoleLocalServiceImpl
	extends ESFFederalRoleLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link it.ethica.esf.service.ESFFederalRoleLocalServiceUtil} to access the e s f federal role local service.
	 */
	public List<ESFFederalRole> findByESFUser(long userId) throws PortalException, SystemException{
		List<ESFFederalRole> list = new ArrayList<ESFFederalRole>();
		List<ESFUserESFFederalRole> userAssociations =  ESFUserESFFederalRoleLocalServiceUtil.findByEsfUserId(userId);
		for(ESFUserESFFederalRole userAssociation : userAssociations){
			list.add(ESFFederalRoleLocalServiceUtil.getESFFederalRole(userAssociation.getEsfUserId()));
		}
		return list;
	}
	
	public List<ESFUser> findByESFFederalRole(long esfFederalRoleId) throws PortalException, SystemException{
		List<ESFUser> list = new ArrayList<ESFUser>();
		List<ESFUserESFFederalRole> userAssociations =  ESFUserESFFederalRoleLocalServiceUtil.findByEsfFederalRoleId(esfFederalRoleId);
		for(ESFUserESFFederalRole userAssociation : userAssociations){
			list.add(ESFUserLocalServiceUtil.getESFUser(userAssociation.getEsfUserId()));
		}
		return list;
	}

	public ESFFederalRole updateEsfFederalRole(
			long esfFederalRoleId, 
			String code, 
			String description,
			boolean regional,
			boolean provincial) throws SystemException{
		ESFFederalRole federalRole = null;
		if(esfFederalRoleId > 0){
			federalRole = esfFederalRolePersistence.fetchByPrimaryKey(esfFederalRoleId);
		}else{
			federalRole = esfFederalRolePersistence.create(CounterLocalServiceUtil.increment());
		}
		User user = userPersistence.fetchByPrimaryKey(PrincipalThreadLocal.getUserId());
		federalRole.setCompanyId(CompanyThreadLocal.getCompanyId());
		federalRole.setCreateDate(Calendar.getInstance().getTime());
		federalRole.setDescription(description);
		federalRole.setRegional(regional);
		federalRole.setProvincial(provincial);
		federalRole.setGroupId(GroupThreadLocal.getGroupId());
		federalRole.setCode(code);
		federalRole.setUserId(user.getUserId());
		federalRole.setUserName(user.getFullName());
		federalRole.setUserUuid(user.getUuid());
		esfFederalRolePersistence.update(federalRole);
		return federalRole;
	}
	
	public List<ESFFederalRole> findByCode(String code){
		return esfFederalRoleFinder.findByCode(code);
	}
	
	public void associateEsfUser(long esfUserId, long esfFederalRoleId, long startDate, long esfSpecificId, String notes) throws SystemException{
		if(esfUserId > 0 && esfFederalRoleId > 0){
			ESFUserESFFederalRolePK pk = new ESFUserESFFederalRolePK();
			pk.setEsfFederalRoleId(esfFederalRoleId);
			pk.setEsfUserId(esfUserId);
			pk.setStartDate(startDate);
			User user = UserLocalServiceUtil.fetchUser(esfUserId);
//			ESFOrganization esfOrganization = ESFOrganizationLocalServiceUtil.fetchESFOrganization(user.getOrganizationId());
			
			ESFUserESFFederalRole association = ESFUserESFFederalRoleLocalServiceUtil.fetchESFUserESFFederalRole(pk);
			if(association != null){
				return;
			}else{
				association = ESFUserESFFederalRoleLocalServiceUtil.createESFUserESFFederalRole(pk);
				association.setActive(Boolean.TRUE);
				association.setStartDate(Calendar.getInstance().getTimeInMillis());
				association.setModifiedDate(Calendar.getInstance().getTime());
				association.setEsfSpecificId(esfSpecificId);
				association.setNotes(notes);
//				association.setRegionId(String.valueOf(esfOrganization.getRegionCode()));
				ESFUserESFFederalRoleLocalServiceUtil.updateESFUserESFFederalRole(association);
			}
		}
	}

	public void deAssociateEsfUser(long esfUserId, long esfFederalRoleId) throws SystemException{
		ESFUserESFFederalRole association;
		try {
			association = ESFUserESFFederalRoleLocalServiceUtil.findByEsfUserIdAndEsfFederalRoleIdActive(esfUserId, esfFederalRoleId, Boolean.TRUE);
			if(association != null){
				association.setActive(Boolean.FALSE);
				association.setEndDate(Calendar.getInstance().getTime());
				association.setModifiedDate(Calendar.getInstance().getTime());
				esfUserESFFederalRolePersistence.update(association);
			}
		} catch (NoSuchUserESFFederalRoleException e) {
			_log.warn(e.getMessage());
		} 
	}

	public ESFUserESFFederalRole getAssociation(long esfUserId, long esfFederalRoleId, long startDate){
		ESFUserESFFederalRolePK pk = new ESFUserESFFederalRolePK();
		pk.setEsfFederalRoleId(esfFederalRoleId);
		pk.setEsfUserId(esfUserId);
		pk.setStartDate(startDate);
		ESFUserESFFederalRole association = null;
		try {
			association = ESFUserESFFederalRoleLocalServiceUtil.fetchESFUserESFFederalRole(pk);
		} catch (SystemException e) {
			_log.fatal(e.getMessage());
		}
		return association;
	}

	public Date getActiveAssociationDate(long esfUserId, long esfFederalRoleId){
		Date date = null;
		ESFUserESFFederalRole association = null;
		try {
			association = ESFUserESFFederalRoleLocalServiceUtil.findByEsfUserIdAndEsfFederalRoleIdActive(esfUserId, esfFederalRoleId, Boolean.TRUE);
			date = new Date(association.getStartDate());
		} catch (SystemException e) {
			_log.fatal(e.getMessage());
		} catch (NoSuchUserESFFederalRoleException e) {
			_log.warn(e.getMessage());
		}
		return date;
	}

	public List<ESFUserESFFederalRole> getAssociationsByEsfUser(long esfUserId){
		List<ESFUserESFFederalRole> associations = new ArrayList<ESFUserESFFederalRole>();
		try {
			associations = ESFUserESFFederalRoleLocalServiceUtil.findByEsfUserId(esfUserId);
		} catch (SystemException e) {
			_log.error(e.getMessage());
		}
		return associations;
	}

	public List<ESFUserESFFederalRole> getAssociationsByEsfUserActive(long esfUserId, boolean active){
		List<ESFUserESFFederalRole> associations = new ArrayList<ESFUserESFFederalRole>();
		try {
			associations = ESFUserESFFederalRoleLocalServiceUtil.findByEsfUserIdAndActive(esfUserId, active);
		} catch (SystemException e) {
			_log.error(e.getMessage());
		}
		return associations;
	}

	public boolean isAssociated(long esfUserId, long esfFederalRoleId){
		ESFUserESFFederalRole association = null;
		boolean result = Boolean.FALSE;
		try {
			association = ESFUserESFFederalRoleLocalServiceUtil.findByEsfUserIdAndEsfFederalRoleIdActive(esfUserId, esfFederalRoleId, Boolean.TRUE);
			if(association != null && association.isActive()){
				result = Boolean.TRUE;
			}
		} catch (SystemException e) {
			_log.fatal(e.getMessage());
		} catch (NoSuchUserESFFederalRoleException e) {
			_log.warn(e.getMessage());
		}
		return result;
	}

	public void cleanEsfUserAssociation(long esfUserId){
		List<ESFUserESFFederalRole> associations = new ArrayList<ESFUserESFFederalRole>();
		try {
			associations = ESFUserESFFederalRoleLocalServiceUtil.findByEsfUserId(esfUserId);
			for(ESFUserESFFederalRole association : associations){
				ESFUserESFFederalRoleLocalServiceUtil.deleteESFUserESFFederalRole(association);
			}
		} catch (SystemException e) {
			_log.fatal(e.getMessage());
		}
	}

	public void cleanEsfFederalRoleAssociation(long esfFederalRoleId){
		List<ESFUserESFFederalRole> associations = new ArrayList<ESFUserESFFederalRole>();
		try {
			associations = ESFUserESFFederalRoleLocalServiceUtil.findByEsfFederalRoleId(esfFederalRoleId);
			for(ESFUserESFFederalRole association : associations){
				ESFUserESFFederalRoleLocalServiceUtil.deleteESFUserESFFederalRole(association);
			}
		} catch (SystemException e) {
			_log.fatal(e.getMessage());
		}
	}

	public List<ESFSpecific> getFederalRoleSpecifics(long esfFederalRoleId){
		List<ESFSpecific> list = new ArrayList<ESFSpecific>();
		List<ESFFederalRoleESFSpecific> associations = ESFFederalRoleESFSpecificLocalServiceUtil.findByESFFederalRoleId(esfFederalRoleId);
		for(ESFFederalRoleESFSpecific ass : associations) {
			try {
				list.add(esfSpecificPersistence.fetchByPrimaryKey(ass.getEsfSpecificId()));
			} catch (SystemException e) {
				_log.error(e.getMessage());
			}
		}
		return list;
	}
	
	Log _log = LogFactoryUtil.getLog(ESFFederalRoleLocalServiceImpl.class.getName());
}