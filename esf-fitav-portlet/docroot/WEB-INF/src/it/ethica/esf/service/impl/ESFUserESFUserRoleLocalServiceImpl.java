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
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Organization;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.RoleConstants;
import com.liferay.portal.service.OrganizationLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserGroupRoleLocalServiceUtil;

import it.ethica.esf.NoSuchUserESFUserRoleException;
import it.ethica.esf.model.ESFNationalDelegation;
import it.ethica.esf.model.ESFPartecipant;
import it.ethica.esf.model.ESFUserESFUserRole;
import it.ethica.esf.model.ESFUserRole;
import it.ethica.esf.service.ESFNationalDelegationLocalServiceUtil;
import it.ethica.esf.service.ESFOrganizationLocalServiceUtil;
import it.ethica.esf.service.ESFPartecipantLocalServiceUtil;
import it.ethica.esf.service.ESFUserESFUserRoleLocalServiceUtil;
import it.ethica.esf.service.ESFUserRoleLocalServiceUtil;
import it.ethica.esf.service.base.ESFUserESFUserRoleLocalServiceBaseImpl;
import it.ethica.esf.service.persistence.ESFUserESFUserRoleFinderUtil;
import it.ethica.esf.service.persistence.ESFUserESFUserRolePK;
import it.ethica.esf.util.ESFKeys;

/**
 * 
 * The implementation of the e s f user e s f user role local service. <p> All
 * custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link it.ethica.esf.service.ESFUserESFUserRoleLocalService} interface. <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM. </p>
 *
 * @author Ethica
 * @see it.ethica.esf.service.base.ESFUserESFUserRoleLocalServiceBaseImpl
 * @see it.ethica.esf.service.ESFUserESFUserRoleLocalServiceUtil
 */
public class ESFUserESFUserRoleLocalServiceImpl
	extends ESFUserESFUserRoleLocalServiceBaseImpl {

	public List<ESFUserESFUserRole> findESFUserESFRolesByEsfUserRoleId(
		long esfUserRoleId)
		throws NoSuchUserESFUserRoleException, SystemException {

		List<ESFUserESFUserRole> esfUserESFUserRoles =
			esfUserESFUserRolePersistence.findByESFU_ED(esfUserRoleId);

		return esfUserESFUserRoles;
	}
	
	public List<ESFUserESFUserRole> findESFUserESFRolesByEsfOrganizzationId(
		long esfOrganizationId)
		throws NoSuchUserESFUserRoleException, SystemException {

		List<ESFUserESFUserRole> esfUserESFUserRoles =
			esfUserESFUserRolePersistence.findByESFOrganizationId(esfOrganizationId);

		return esfUserESFUserRoles;
	}
	//trova tutti i ruoli
	public List<ESFUserESFUserRole> findESFUserESFRolesAll()
			throws NoSuchUserESFUserRoleException, SystemException {

			List<ESFUserESFUserRole> esfUserESFUserRoles =
				esfUserESFUserRolePersistence.findAll();

			return esfUserESFUserRoles;
		}
	
	
	public ESFUserESFUserRole findESFUserESFRoleByPrimaryKey(
		long esfUserId, long esfUserRoleId, long esfOrganizationId,
		Date startDate)
		throws NoSuchUserESFUserRoleException, SystemException {

		ESFUserESFUserRole esfUserESFUserRole = null;
		ESFUserESFUserRolePK esfUserESFUserRolePK = new ESFUserESFUserRolePK();
		esfUserESFUserRolePK.setEsfUserId(esfUserId);
		esfUserESFUserRolePK.setEsfUserRoleId(esfUserRoleId);
		esfUserESFUserRolePK.setEsfOrganizationId(esfOrganizationId);
		esfUserESFUserRolePK.setStartDate(startDate);
		esfUserESFUserRole =
			esfUserESFUserRolePersistence.fetchByPrimaryKey(esfUserESFUserRolePK);
		return esfUserESFUserRole;
	}

	public ESFUserESFUserRole findESFUserESFRoleByU_R_O(
		long esfUserId, long esfUserRoleId, long esfOrganizationId)
		throws NoSuchUserESFUserRoleException, SystemException {

		ESFUserESFUserRole esfUserESFUserRole =
			esfUserESFUserRolePersistence.fetchByESFU_R_O(
				esfUserRoleId, esfUserId, esfOrganizationId);

		return esfUserESFUserRole;
	}

	public List<ESFUserESFUserRole> findESFUserESFRoleByO_R(
		long esfOrganizationId, long esfUserRoleId)
		throws NoSuchUserESFUserRoleException, SystemException {

		List<ESFUserESFUserRole> esfUserESFUserRoles =
			esfUserESFUserRolePersistence.findByESFO_R(
				esfOrganizationId, esfUserRoleId);

		return esfUserESFUserRoles;
	}
	

	public List<ESFUserESFUserRole> getAllESFUserESFUserRoleByESFUserId(
		long esfUserId, int start, int end) {

		List<ESFUserESFUserRole> esfUserESFUserRoles;
		try {
			esfUserESFUserRoles =
				esfUserESFUserRolePersistence.findByESFUserId(
					esfUserId, start, end);
		}
		catch (SystemException e) {
			return null;
		}
		return esfUserESFUserRoles;
	}

	public List<ESFUserESFUserRole> getESFUserESFUserRoleByESFUserId_ED(
		long esfUserId) {

		List<ESFUserESFUserRole> esfUserESFUserRoles;
		try {
			esfUserESFUserRoles =
				esfUserESFUserRolePersistence.findByESFUserId_ED(esfUserId);
		}
		catch (SystemException e) {
			return null;
		}
		return esfUserESFUserRoles;
	}
	
	
	public List<ESFUserESFUserRole> getESFUserESFUserRoleByOrganizationId(
			long organizationId) throws SystemException {
		
		List<ESFUserESFUserRole> esfUserESFUserRoles =
				esfUserESFUserRolePersistence.findByESFOrganizationId(organizationId);
		
		List<ESFUserESFUserRole> esfUserESFUserRoleAssigned = null;
		int type = ESFKeys.ESFUserRoleMatch.TYPE;
		List<Role> roles = RoleLocalServiceUtil.getTypeRoles(type);
		List<Long> idRoles = new ArrayList<Long>();

		
		for(Role r : roles){
			if((ESFKeys.ESFUserRoleMatch.COACH.equalsIgnoreCase(r.getName())) ||
					(ESFKeys.ESFUserRoleMatch.DOCTOR.equalsIgnoreCase(r.getName())) ||
							(ESFKeys.ESFUserRoleMatch.REFEREE.equalsIgnoreCase(r.getName())) ||
									(ESFKeys.ESFUserRoleMatch.STAFF.equalsIgnoreCase(r.getName()))){
				idRoles.add(r.getRoleId());
			}
		}
		
		for(ESFUserESFUserRole esfUserESFUserRole : esfUserESFUserRoles){
			if(idRoles.contains( esfUserESFUserRole.getEsfUserRoleId())){
				esfUserESFUserRoleAssigned.add(esfUserESFUserRole);
			}
		}

		return esfUserESFUserRoleAssigned;
	}
	
	public List<ESFUserESFUserRole> getESFUserESFUserRoleByOrganizationId(
			long organizationId, int start, int end) throws SystemException {
		
		List<ESFUserESFUserRole> esfUserESFUserRoles =
				esfUserESFUserRolePersistence.findByESFOrganizationId(organizationId);
		
		List<ESFUserESFUserRole> esfUserESFUserRoleT =  new ArrayList<ESFUserESFUserRole>();
		
		int type = ESFKeys.ESFUserRoleMatch.TYPE;
		List<Role> roles = RoleLocalServiceUtil.getTypeRoles(type);
		List<Long> idRoles = new ArrayList<Long>();

		
		for(Role r : roles){
			if((ESFKeys.ESFUserRoleMatch.COACH.equalsIgnoreCase(r.getName())) ||
					(ESFKeys.ESFUserRoleMatch.DOCTOR.equalsIgnoreCase(r.getName())) ||
							(ESFKeys.ESFUserRoleMatch.REFEREE.equalsIgnoreCase(r.getName())) ||
									(ESFKeys.ESFUserRoleMatch.STAFF.equalsIgnoreCase(r.getName()))){
				idRoles.add(r.getRoleId());
			}
		}
		
		for(ESFUserESFUserRole esfUserESFUserRole : esfUserESFUserRoles){
			if(idRoles.contains( esfUserESFUserRole.getEsfUserRoleId())){
				esfUserESFUserRoleT.add(esfUserESFUserRole);
			}
		}
		
		List<ESFUserESFUserRole> esfUserESFUserRoleAssigned = new ArrayList<ESFUserESFUserRole>();
		
		
		for(  ; start<end && start<esfUserESFUserRoleT.size() ; start++)
			esfUserESFUserRoleAssigned.add(esfUserESFUserRoleT.get(start));
			
		return esfUserESFUserRoleAssigned;
	}
	
	public List<ESFUserESFUserRole> getESFUserESFUserRoleAllStaff(long esfMatchId)
			throws SystemException {
		
		List<ESFUserESFUserRole> esfUserESFUserRoles =
				esfUserESFUserRolePersistence.findAll();
		
		List<ESFUserESFUserRole> esfUserESFUserRoleAssigned = new ArrayList<ESFUserESFUserRole>();
		List<ESFUserESFUserRole> esfUserESFUserRoleAssign = new ArrayList<ESFUserESFUserRole>();
		List<ESFUserESFUserRole> esfStaff = new ArrayList<ESFUserESFUserRole>();
		List<Long> esfUserESFUserRoleAssignId = new ArrayList<Long>();
		List<ESFPartecipant> esfPartecipant = new ArrayList<ESFPartecipant>();
		List<Long> esfPartecipantId = new ArrayList<Long>();
		
		int type = ESFKeys.ESFUserRoleMatch.TYPE;
		List<Role> roles = RoleLocalServiceUtil.getTypeRoles(type);
		List<Long> idRoles = new ArrayList<Long>();

		
		for(Role r : roles){
			if((ESFKeys.ESFUserRoleMatch.COACH.equalsIgnoreCase(r.getName())) ||
					(ESFKeys.ESFUserRoleMatch.DOCTOR.equalsIgnoreCase(r.getName())) ||
							(ESFKeys.ESFUserRoleMatch.REFEREE.equalsIgnoreCase(r.getName())) ||
									(ESFKeys.ESFUserRoleMatch.STAFF.equalsIgnoreCase(r.getName()))){
				idRoles.add(r.getRoleId());
			}
		}
		
		for(ESFUserESFUserRole esfUserESFUserRole : esfUserESFUserRoles){
			if(idRoles.contains( esfUserESFUserRole.getEsfUserRoleId())){
				esfUserESFUserRoleAssign.add(esfUserESFUserRole);
			}
		}
		for(ESFUserESFUserRole esfUserESFUserRole : esfUserESFUserRoleAssign){
			boolean trovato=false;
			for(int i = 0 ; i<esfUserESFUserRoleAssignId.size() && !trovato; i++){
				if(esfUserESFUserRoleAssignId.contains(esfUserESFUserRole.getEsfUserId())){
					trovato=true;
					
				}
			}
			if(!trovato){
				esfUserESFUserRoleAssigned.add(esfUserESFUserRole);
				esfUserESFUserRoleAssignId.add(esfUserESFUserRole.getEsfUserId());
			}
		}
		
		esfPartecipant = ESFPartecipantLocalServiceUtil.
				getESFPartecipantsByESFMatchId(esfMatchId);
		
		for(ESFPartecipant u : esfPartecipant ){
			if(u.getEsfPartecipantTypeId() != 1){
				esfPartecipantId.add(u.getEsfUserId());
			}
		}
	
		for(ESFUserESFUserRole esfUserESFUserRole : esfUserESFUserRoleAssigned){
			
			if(!esfPartecipantId.contains(esfUserESFUserRole.getEsfUserId())){
				esfStaff.add(esfUserESFUserRole);
			}
		}
		return esfStaff;
	}
	
	public List<ESFUserESFUserRole> getESFUserESFUserRoleAllStaff(long esfMatchId, int start, int end) 
			throws SystemException {
		
		List<ESFUserESFUserRole> esfUserESFUserRoles =
				esfUserESFUserRolePersistence.findAll();
		
		
		List<ESFUserESFUserRole> esfUserESFUserRoleAssigned = new ArrayList<ESFUserESFUserRole>();
		List<ESFUserESFUserRole> esfUserESFUserRoleAssign = new ArrayList<ESFUserESFUserRole>();
		List<ESFUserESFUserRole> esfStaff = new ArrayList<ESFUserESFUserRole>();
		List<Long> esfUserESFUserRoleAssignId = new ArrayList<Long>();
		List<ESFPartecipant> esfPartecipant = new ArrayList<ESFPartecipant>();
		List<Long> esfPartecipantId = new ArrayList<Long>();
		
		int type = ESFKeys.ESFUserRoleMatch.TYPE;
		List<Role> roles = RoleLocalServiceUtil.getTypeRoles(type);
		List<Long> idRoles = new ArrayList<Long>();

		
		for(Role r : roles){
			if((ESFKeys.ESFUserRoleMatch.COACH.equalsIgnoreCase(r.getName())) ||
					(ESFKeys.ESFUserRoleMatch.DOCTOR.equalsIgnoreCase(r.getName())) ||
							(ESFKeys.ESFUserRoleMatch.REFEREE.equalsIgnoreCase(r.getName())) ||
									(ESFKeys.ESFUserRoleMatch.STAFF.equalsIgnoreCase(r.getName()))){
				idRoles.add(r.getRoleId());
			}
		}
		
		for(ESFUserESFUserRole esfUserESFUserRole : esfUserESFUserRoles){
			if(idRoles.contains( esfUserESFUserRole.getEsfUserRoleId())){
				esfUserESFUserRoleAssign.add(esfUserESFUserRole);
			}
		}
		
		for(ESFUserESFUserRole esfUserESFUserRole : esfUserESFUserRoleAssign){
			boolean trovato=false;
			for(int i = 0 ; i<esfUserESFUserRoleAssignId.size() && !trovato; i++){
				if(esfUserESFUserRoleAssignId.contains(esfUserESFUserRole.getEsfUserId())){
					trovato=true;
					
				}
			}
			if(!trovato){
				esfUserESFUserRoleAssigned.add(esfUserESFUserRole);
				esfUserESFUserRoleAssignId.add(esfUserESFUserRole.getEsfUserId());
			}
		}
		
		esfPartecipant = ESFPartecipantLocalServiceUtil.
				getESFPartecipantsByESFMatchId(esfMatchId);
		
		for(ESFPartecipant u : esfPartecipant ){
			if(u.getEsfPartecipantTypeId() != 1){
				esfPartecipantId.add(u.getEsfUserId());
			}
		}
		for(ESFUserESFUserRole esfUserESFUserRole : esfUserESFUserRoleAssigned){
			if(!esfPartecipantId.contains(esfUserESFUserRole.getEsfUserId())){
				esfStaff.add(esfUserESFUserRole);
			}
		}
		List<ESFUserESFUserRole> esfUserESFUserRoleT =  new ArrayList<ESFUserESFUserRole>();
		
		for(  ; start<end && start<esfUserESFUserRoleT.size() ; start++)
			esfStaff.add(esfUserESFUserRoleT.get(start));

		return esfStaff;
	}
	
	public List<ESFUserESFUserRole> getESFUserESFUserRoleAllNationalStaff(long esfMatchId, int start, int end) 
			throws SystemException {
		
		List<ESFUserESFUserRole> esfUserESFUserRoles =
				esfUserESFUserRolePersistence.findAll();
		
		
		List<ESFUserESFUserRole> esfUserESFUserRoleAssigned = new ArrayList<ESFUserESFUserRole>();
		List<ESFUserESFUserRole> esfUserESFUserRoleAssign = new ArrayList<ESFUserESFUserRole>();
		List<ESFUserESFUserRole> esfStaff = new ArrayList<ESFUserESFUserRole>();
		List<Long> esfUserESFUserRoleAssignId = new ArrayList<Long>();
		List<ESFNationalDelegation> esfPartecipant = new ArrayList<ESFNationalDelegation>();
		List<ESFPartecipant> esfPartecipantStaff = new ArrayList<ESFPartecipant>();
		List<Long> esfPartecipantId = new ArrayList<Long>();
		
		int type = ESFKeys.ESFUserRoleMatch.TYPE;
		List<Role> roles = RoleLocalServiceUtil.getTypeRoles(type);
		List<Long> idRoles = new ArrayList<Long>();

		
		for(Role r : roles){
			if((ESFKeys.ESFUserRoleMatch.COACH.equalsIgnoreCase(r.getName())) ||
					(ESFKeys.ESFUserRoleMatch.DOCTOR.equalsIgnoreCase(r.getName())) ||
							(ESFKeys.ESFUserRoleMatch.REFEREE.equalsIgnoreCase(r.getName())) ||
									(ESFKeys.ESFUserRoleMatch.STAFF.equalsIgnoreCase(r.getName()))){
				idRoles.add(r.getRoleId());
			}
		}
		
		for(ESFUserESFUserRole esfUserESFUserRole : esfUserESFUserRoles){
			if(idRoles.contains( esfUserESFUserRole.getEsfUserRoleId())){
				esfUserESFUserRoleAssign.add(esfUserESFUserRole);
			}
		}
		
		for(ESFUserESFUserRole esfUserESFUserRole : esfUserESFUserRoleAssign){
			boolean trovato=false;
			for(int i = 0 ; i<esfUserESFUserRoleAssignId.size() && !trovato; i++){
				if(esfUserESFUserRoleAssignId.contains(esfUserESFUserRole.getEsfUserId())){
					trovato=true;
					
				}
			}
			if(!trovato){
				esfUserESFUserRoleAssigned.add(esfUserESFUserRole);
				esfUserESFUserRoleAssignId.add(esfUserESFUserRole.getEsfUserId());
			}
		}
		
		esfPartecipant = ESFNationalDelegationLocalServiceUtil.getESFNationalDelegationByESFMatchId(esfMatchId);
		for(ESFNationalDelegation u : esfPartecipant ){
			if(u.getEsfPartecipantTypeId() != 1){
				esfPartecipantId.add(u.getEsfUserId());
			}
		}
		for(ESFUserESFUserRole esfUserESFUserRole : esfUserESFUserRoleAssigned){
			if(!esfPartecipantId.contains(esfUserESFUserRole.getEsfUserId())){
				esfStaff.add(esfUserESFUserRole);
			}
		}
		List<ESFUserESFUserRole> esfUserESFUserRoleT =  new ArrayList<ESFUserESFUserRole>();
		
		for(  ; start<end && start<esfUserESFUserRoleT.size() ; start++)
			esfStaff.add(esfUserESFUserRoleT.get(start));

		return esfStaff;
	}
	
	
	
	
	
	public List<ESFUserESFUserRole>  getESFUserESFUserRoleAllNationalStaff(long esfMatchId)
			throws SystemException {
		
		List<ESFUserESFUserRole> esfUserESFUserRoles =
				esfUserESFUserRolePersistence.findAll();
		
		List<ESFUserESFUserRole> esfUserESFUserRoleAssigned = new ArrayList<ESFUserESFUserRole>();
		List<ESFUserESFUserRole> esfUserESFUserRoleAssign = new ArrayList<ESFUserESFUserRole>();
		List<ESFUserESFUserRole> esfStaff = new ArrayList<ESFUserESFUserRole>();
		List<Long> esfUserESFUserRoleAssignId = new ArrayList<Long>();
		List<ESFNationalDelegation> esfPartecipant = new ArrayList<ESFNationalDelegation>();
		List<ESFPartecipant> esfPartecipantStaff = new ArrayList<ESFPartecipant>();
		List<Long> esfPartecipantId = new ArrayList<Long>();
		
		int type = ESFKeys.ESFUserRoleMatch.TYPE;
		List<Role> roles = RoleLocalServiceUtil.getTypeRoles(type);
		List<Long> idRoles = new ArrayList<Long>();

		
		for(Role r : roles){
			if((ESFKeys.ESFUserRoleMatch.COACH.equalsIgnoreCase(r.getName())) ||
					(ESFKeys.ESFUserRoleMatch.DOCTOR.equalsIgnoreCase(r.getName())) ||
							(ESFKeys.ESFUserRoleMatch.REFEREE.equalsIgnoreCase(r.getName())) ||
									(ESFKeys.ESFUserRoleMatch.STAFF.equalsIgnoreCase(r.getName()))){
				idRoles.add(r.getRoleId());
			}
		}
		
		for(ESFUserESFUserRole esfUserESFUserRole : esfUserESFUserRoles){
			if(idRoles.contains( esfUserESFUserRole.getEsfUserRoleId())){
				esfUserESFUserRoleAssign.add(esfUserESFUserRole);
			}
		}
		
			for(ESFUserESFUserRole esfUserESFUserRole : esfUserESFUserRoleAssign){
				boolean trovato=false;
				for(int i = 0 ; i<esfUserESFUserRoleAssignId.size() && !trovato; i++){
					if(esfUserESFUserRoleAssignId.contains(esfUserESFUserRole.getEsfUserId())){
						trovato=true;
						
					}
				}
				if(!trovato){
					esfUserESFUserRoleAssigned.add(esfUserESFUserRole);
					esfUserESFUserRoleAssignId.add(esfUserESFUserRole.getEsfUserId());
				}
			}	
		
			for(ESFUserESFUserRole esfUserESFUserRole : esfUserESFUserRoleAssign){
				boolean trovato=false;
				for(int i = 0 ; i<esfUserESFUserRoleAssignId.size() && !trovato; i++){
					if(esfUserESFUserRoleAssignId.contains(esfUserESFUserRole.getEsfUserId())){
						trovato=true;
						
					}
				}
				if(!trovato){
					esfUserESFUserRoleAssigned.add(esfUserESFUserRole);
					esfUserESFUserRoleAssignId.add(esfUserESFUserRole.getEsfUserId());
				}
			}
		
		
		esfPartecipant = ESFNationalDelegationLocalServiceUtil.getESFNationalDelegationByESFMatchId(esfMatchId);

			for(ESFNationalDelegation u : esfPartecipant ){
				if(u.getEsfPartecipantTypeId() != 1){
					esfPartecipantId.add(u.getEsfUserId());
				}
			}
		

			for(ESFUserESFUserRole esfUserESFUserRole : esfUserESFUserRoleAssigned){
				
				if(!esfPartecipantId.contains(esfUserESFUserRole.getEsfUserId())){
					esfStaff.add(esfUserESFUserRole);
				}
			}
		
		return esfStaff;
	}
	
	
	
	public List<ESFUserESFUserRole> getESFUserESFUserRoleStaff(long esfMatchId, int start, int end) 
			throws SystemException {
		
		List<ESFUserESFUserRole> esfUserESFUserRoles =
				esfUserESFUserRolePersistence.findAll();
		
		
		List<ESFUserESFUserRole> esfUserESFUserRoleAssigned = new ArrayList<ESFUserESFUserRole>();
		List<ESFUserESFUserRole> esfUserESFUserRoleAssign = new ArrayList<ESFUserESFUserRole>();
		List<ESFUserESFUserRole> esfStaff = new ArrayList<ESFUserESFUserRole>();
		List<Long> esfUserESFUserRoleAssignId = new ArrayList<Long>();
		List<ESFNationalDelegation> esfPartecipant = new ArrayList<ESFNationalDelegation>();
		List<ESFPartecipant> esfPartecipantStaff = new ArrayList<ESFPartecipant>();
		List<Long> esfPartecipantId = new ArrayList<Long>();
		
		int type = ESFKeys.ESFUserRoleMatch.TYPE;
		List<Role> roles = RoleLocalServiceUtil.getTypeRoles(type);
		List<Long> idRoles = new ArrayList<Long>();

		
		for(Role r : roles){
			if((ESFKeys.ESFUserRoleMatch.COACH.equalsIgnoreCase(r.getName())) ||
					(ESFKeys.ESFUserRoleMatch.DOCTOR.equalsIgnoreCase(r.getName())) ||
							(ESFKeys.ESFUserRoleMatch.REFEREE.equalsIgnoreCase(r.getName())) ||
									(ESFKeys.ESFUserRoleMatch.STAFF.equalsIgnoreCase(r.getName()))){
				idRoles.add(r.getRoleId());
			}
		}
		
		for(ESFUserESFUserRole esfUserESFUserRole : esfUserESFUserRoles){
			if(idRoles.contains( esfUserESFUserRole.getEsfUserRoleId())){
				esfUserESFUserRoleAssign.add(esfUserESFUserRole);
			}
		}
		for(ESFUserESFUserRole esfUserESFUserRole : esfUserESFUserRoleAssign){
			boolean trovato=false;
			for(int i = 0 ; i<esfUserESFUserRoleAssignId.size() && !trovato; i++){
				if(esfUserESFUserRoleAssignId.contains(esfUserESFUserRole.getEsfUserId())){
					trovato=true;
					
				}
			}
			if(!trovato){
				esfUserESFUserRoleAssigned.add(esfUserESFUserRole);
				esfUserESFUserRoleAssignId.add(esfUserESFUserRole.getEsfUserId());
			}
		}
		
		esfPartecipantStaff = ESFPartecipantLocalServiceUtil.getESFPartecipantsByESFMatchId(esfMatchId);
		for(ESFPartecipant p : esfPartecipantStaff ){
			if(p.getEsfPartecipantTypeId() != 1){
				esfPartecipantId.add(p.getEsfUserId());
			}
		}
		
		for(ESFUserESFUserRole esfUserESFUserRole : esfUserESFUserRoleAssigned){
			if(!esfPartecipantId.contains(esfUserESFUserRole.getEsfUserId())){
				esfStaff.add(esfUserESFUserRole);
			}
		}
		List<ESFUserESFUserRole> esfUserESFUserRoleT =  new ArrayList<ESFUserESFUserRole>();
		
		for(  ; start<end && start<esfUserESFUserRoleT.size() ; start++)
			esfStaff.add(esfUserESFUserRoleT.get(start));

		return esfStaff;
	}
	
	
	
	
	
	public List<ESFUserESFUserRole>  getESFUserESFUserRoleStaff(long esfMatchId)
			throws SystemException {
		
		List<ESFUserESFUserRole> esfUserESFUserRoles =
				esfUserESFUserRolePersistence.findAll();
		
		List<ESFUserESFUserRole> esfUserESFUserRoleAssigned = new ArrayList<ESFUserESFUserRole>();
		List<ESFUserESFUserRole> esfUserESFUserRoleAssign = new ArrayList<ESFUserESFUserRole>();
		List<ESFUserESFUserRole> esfStaff = new ArrayList<ESFUserESFUserRole>();
		List<Long> esfUserESFUserRoleAssignId = new ArrayList<Long>();
		List<ESFNationalDelegation> esfPartecipant = new ArrayList<ESFNationalDelegation>();
		List<ESFPartecipant> esfPartecipantStaff = new ArrayList<ESFPartecipant>();
		List<Long> esfPartecipantId = new ArrayList<Long>();
		
		int type = ESFKeys.ESFUserRoleMatch.TYPE;
		List<Role> roles = RoleLocalServiceUtil.getTypeRoles(type);
		List<Long> idRoles = new ArrayList<Long>();

		
		for(Role r : roles){
			if((ESFKeys.ESFUserRoleMatch.COACH.equalsIgnoreCase(r.getName())) ||
					(ESFKeys.ESFUserRoleMatch.DOCTOR.equalsIgnoreCase(r.getName())) ||
							(ESFKeys.ESFUserRoleMatch.REFEREE.equalsIgnoreCase(r.getName())) ||
									(ESFKeys.ESFUserRoleMatch.STAFF.equalsIgnoreCase(r.getName()))){
				idRoles.add(r.getRoleId());
			}
		}
		
		for(ESFUserESFUserRole esfUserESFUserRole : esfUserESFUserRoles){
			if(idRoles.contains( esfUserESFUserRole.getEsfUserRoleId())){
				esfUserESFUserRoleAssign.add(esfUserESFUserRole);
			}
		}
		
			for(ESFUserESFUserRole esfUserESFUserRole : esfUserESFUserRoleAssign){
				boolean trovato=false;
				for(int i = 0 ; i<esfUserESFUserRoleAssignId.size() && !trovato; i++){
					if(esfUserESFUserRoleAssignId.contains(esfUserESFUserRole.getEsfUserId())){
						trovato=true;
						
					}
				}
				if(!trovato){
					esfUserESFUserRoleAssigned.add(esfUserESFUserRole);
					esfUserESFUserRoleAssignId.add(esfUserESFUserRole.getEsfUserId());
				}
			}	
		
			for(ESFUserESFUserRole esfUserESFUserRole : esfUserESFUserRoleAssign){
				boolean trovato=false;
				for(int i = 0 ; i<esfUserESFUserRoleAssignId.size() && !trovato; i++){
					if(esfUserESFUserRoleAssignId.contains(esfUserESFUserRole.getEsfUserId())){
						trovato=true;
						
					}
				}
				if(!trovato){
					esfUserESFUserRoleAssigned.add(esfUserESFUserRole);
					esfUserESFUserRoleAssignId.add(esfUserESFUserRole.getEsfUserId());
				}
			}

			esfPartecipantStaff = ESFPartecipantLocalServiceUtil.getESFPartecipantsByESFMatchId(esfMatchId);
			for(ESFPartecipant p : esfPartecipantStaff ){
				if(p.getEsfPartecipantTypeId() != 1){
					esfPartecipantId.add(p.getEsfUserId());
				}
			}

			for(ESFUserESFUserRole esfUserESFUserRole : esfUserESFUserRoleAssigned){
				
				if(!esfPartecipantId.contains(esfUserESFUserRole.getEsfUserId())){
					esfStaff.add(esfUserESFUserRole);
				}
			}
		
		return esfStaff;
	}
	
	
	public int getAllESFUserESFUserRoleCountByESFUserId(long esfUserId) {

		List<ESFUserESFUserRole> esfUserESFUserRoles;
		try {
			esfUserESFUserRoles =
				esfUserESFUserRolePersistence.findByESFUserId(esfUserId);
		}
		catch (SystemException e) {
			return 0;
		}

		return esfUserESFUserRoles.size();
	}

	public ESFUserESFUserRole addESFUserESFRole(
		long esfUserId, long esfUserRoleId, long esfOrganizationId,
		Date startDate)
		throws SystemException {

		ESFUserESFUserRolePK esfUserESFUserRolePK = new ESFUserESFUserRolePK();
		esfUserESFUserRolePK.setEsfUserId(esfUserId);
		esfUserESFUserRolePK.setEsfUserRoleId(esfUserRoleId);
		esfUserESFUserRolePK.setEsfOrganizationId(esfOrganizationId);
		esfUserESFUserRolePK.setStartDate(startDate);
		ESFUserESFUserRole esfUserESFUserRole =
			esfUserESFUserRolePersistence.create(esfUserESFUserRolePK);

		esfUserESFUserRole.setEndDate(null);

		esfUserESFUserRolePersistence.update(esfUserESFUserRole);

		RoleLocalServiceUtil.addUserRole(esfUserId, esfUserRoleId);

		ESFUserRole esfUserRole =
			esfUserRoleLocalService.fetchESFUserRole(esfUserRoleId);

		Organization organization =
			OrganizationLocalServiceUtil.fetchOrganization(esfOrganizationId);

		if (esfUserRole.isIsOrgAdmin()) {

			List<Role> roles =
				RoleLocalServiceUtil.getRoles(
					RoleConstants.TYPE_ORGANIZATION, StringPool.BLANK);

			for (Role role : roles) {

				if (role.getName().equals(
					RoleConstants.ORGANIZATION_ADMINISTRATOR)) {

					long[] roleIds = {
						role.getRoleId()
					};

					UserGroupRoleLocalServiceUtil.addUserGroupRoles(
						esfUserId, organization.getGroup().getGroupId(),
						roleIds);
				}
			}
		}

		return esfUserESFUserRole;
	}

	
	public ESFUserESFUserRole addESFUserESFRoleMigr(
			long esfUserId, long esfUserRoleId, long esfOrganizationId,
			Date startDate, Date endDate)
			throws SystemException {

			ESFUserESFUserRolePK esfUserESFUserRolePK = new ESFUserESFUserRolePK();
			esfUserESFUserRolePK.setEsfUserId(esfUserId);
			esfUserESFUserRolePK.setEsfUserRoleId(esfUserRoleId);
			esfUserESFUserRolePK.setEsfOrganizationId(esfOrganizationId);
			esfUserESFUserRolePK.setStartDate(startDate);
			ESFUserESFUserRole esfUserESFUserRole =
				esfUserESFUserRolePersistence.create(esfUserESFUserRolePK);

			esfUserESFUserRole.setEndDate(endDate);

			esfUserESFUserRolePersistence.update(esfUserESFUserRole);

			RoleLocalServiceUtil.addUserRole(esfUserId, esfUserRoleId);

			ESFUserRole esfUserRole =
				esfUserRoleLocalService.fetchESFUserRole(esfUserRoleId);

			Organization organization =
				OrganizationLocalServiceUtil.fetchOrganization(esfOrganizationId);

			if (esfUserRole.isIsOrgAdmin()) {

				List<Role> roles =
					RoleLocalServiceUtil.getRoles(
						RoleConstants.TYPE_ORGANIZATION, StringPool.BLANK);

				for (Role role : roles) {

					if (role.getName().equals(
						RoleConstants.ORGANIZATION_ADMINISTRATOR)) {

						long[] roleIds = {
							role.getRoleId()
						};

						UserGroupRoleLocalServiceUtil.addUserGroupRoles(
							esfUserId, organization.getGroup().getGroupId(),
							roleIds);
					}
				}
			}

			return esfUserESFUserRole;
		}
	
	public ESFUserESFUserRole updateESFUserESFRole(
		long esfUserId, long esfUserRoleId, long esfOrganizationId,
		Date endDate, ServiceContext serviceContext)
		throws SystemException, PortalException {

		ESFUserESFUserRole esfUserESFUserRole =
			esfUserESFUserRolePersistence.fetchByESFU_R_O(
				esfUserRoleId, esfUserId, esfOrganizationId);

		esfUserESFUserRole.setEndDate(endDate);

		esfUserESFUserRolePersistence.update(esfUserESFUserRole);

		RoleLocalServiceUtil.deleteUserRole(esfUserId, esfUserRoleId);

		if (endDate != null) {

			ESFUserRole esfUserRole =
				esfUserRoleLocalService.fetchESFUserRole(esfUserRoleId);

			Organization organization =
				OrganizationLocalServiceUtil.fetchOrganization(esfOrganizationId);

			if (esfUserRole.isIsOrgAdmin()) {

				List<Role> roles =
					RoleLocalServiceUtil.getRoles(
						RoleConstants.TYPE_ORGANIZATION, StringPool.BLANK);

				for (Role role : roles) {

					if (role.getName().equals(
						RoleConstants.ORGANIZATION_ADMINISTRATOR)) {

						long[] roleIds = {
							role.getRoleId()
						};

						UserGroupRoleLocalServiceUtil.deleteUserGroupRoles(
							esfUserId, organization.getGroup().getGroupId(),
							roleIds);
					}
				}
			}
		}

		// Disabilitazione di una societ� se non presente nessun ruolo DBO

		int type = (int) ESFKeys.ESFOrganizationTypeId.ASSOCIATION;

		List<ESFUserRole> esfUserRoles =
			ESFUserRoleLocalServiceUtil.getEsfUserRoleByT_S_BDO_OrgId(
				type, ESFKeys.ESFStateType.ENABLE, true, esfOrganizationId);

		if (esfUserRoles.isEmpty()) {

			ESFOrganizationLocalServiceUtil.updateOnlyESFOrganitazionState(
				esfOrganizationId, serviceContext);

		}

		return esfUserESFUserRole;
	}

	/**
	 * Trova tutti gli ESFUserRole sulla base dei seguenti parametri: -
	 * esfUserRoleId, - WHERE CONDITION (endDate IS Null)
	 * 
	 * @param esfUserRoleId
	 * @return
	 * @throws SystemException
	 */
	public List<ESFUserESFUserRole> getESFUSerRoleByR_ED(long esfUserRoleId)
		throws SystemException {

		return esfUserESFUserRolePersistence.findByESFU_ED(esfUserRoleId);
	}
	
	public List<ESFUserESFUserRole> findbyBDOUserRolenoEnd(long roleId, long organizationId)
			throws SystemException, NoSuchUserESFUserRoleException {
		
		List<ESFUserESFUserRole> userRole = new ArrayList<ESFUserESFUserRole>();
		List<ESFUserESFUserRole> orgRole = new ArrayList<ESFUserESFUserRole>();
		orgRole = ESFUserESFUserRoleLocalServiceUtil.findESFUserESFRoleByO_R(organizationId, roleId);
		
		for(ESFUserESFUserRole u : orgRole){
			if(Validator.isNull(u.getEndDate())){
				userRole.add(u);
			}
		}
		
		return userRole;
	}
	
	public List<ESFUserESFUserRole> findbyBDORole(long organizationId)
			throws SystemException, NoSuchUserESFUserRoleException {
		
		List<ESFUserESFUserRole> userRole = new ArrayList<ESFUserESFUserRole>();
		List<ESFUserESFUserRole> userRoleTot = new ArrayList<ESFUserESFUserRole>();
		List<ESFUserESFUserRole> userRoleOrg = new ArrayList<ESFUserESFUserRole>();
		List<ESFUserRole> role = new ArrayList<ESFUserRole>();
		List<Long> roleId = new ArrayList<Long>();
		
		
		DynamicQuery roleQuery =
				DynamicQueryFactoryUtil.forClass(
					ESFUserRole.class, "roleQuery",
					PortletClassLoaderUtil.getClassLoader());
		
		roleQuery.add(PropertyFactoryUtil.forName("type").eq(3));
		
		role = ESFUserRoleLocalServiceUtil.dynamicQuery(roleQuery);
		
		
		for(ESFUserRole u : role){
			roleId.add(u.getEsfUserRoleId());
			
		}
		
		userRoleTot = ESFUserESFUserRoleLocalServiceUtil.findESFUserESFRolesAll();
		
		for(ESFUserESFUserRole org : userRoleTot){
			if(org.getEsfOrganizationId() == organizationId){
				userRoleOrg.add(org);
			}
		}
		
		for(ESFUserESFUserRole userroleid : userRoleTot){
			if(roleId.contains(userroleid.getEsfUserRoleId()) && userroleid.getEsfOrganizationId() == organizationId
					&& Validator.isNotNull(userroleid.getEndDate())){
				userRole.add(userroleid);
			}
		}
		
		return userRole;
	}
	
	public List<ESFUserESFUserRole> findStaffRole(long userId)
			throws SystemException, PortalException {
		List<ESFUserESFUserRole> userRoles = new ArrayList<ESFUserESFUserRole>();
		userRoles = ESFUserESFUserRoleFinderUtil.findStaffRole(userId);
		
		return userRoles ;
	}
	public List<ESFUserESFUserRole> findESFUserESFRoleByO_R_D_NOL(long esfOrganizationId,long esfUserId,java.sql.Date date)
		throws SystemException, PortalException {
			List<ESFUserESFUserRole> userRoles = new ArrayList<ESFUserESFUserRole>();
			userRoles = ESFUserESFUserRoleFinderUtil.findESFUserESFRoleByO_R_D_NOL(esfOrganizationId,esfUserId,date);
			
			return userRoles ;
	}
	
	
	private static Log _log =
			LogFactoryUtil.getLog(ESFUserESFUserRoleLocalServiceImpl.class);
}
