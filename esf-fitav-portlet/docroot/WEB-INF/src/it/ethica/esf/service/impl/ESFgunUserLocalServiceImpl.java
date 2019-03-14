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
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.ServiceContext;

import it.ethica.esf.model.ESFCane;
import it.ethica.esf.model.ESFCatridge;
import it.ethica.esf.model.ESFGun;
import it.ethica.esf.model.ESFgunUser;
import it.ethica.esf.model.impl.ESFCaneImpl;
import it.ethica.esf.model.impl.ESFCatridgeImpl;
import it.ethica.esf.model.impl.ESFGunImpl;
import it.ethica.esf.service.ESFCaneLocalServiceUtil;
import it.ethica.esf.service.ESFGunLocalServiceUtil;
import it.ethica.esf.service.ESFgunUserLocalServiceUtil;
import it.ethica.esf.service.base.ESFgunUserLocalServiceBaseImpl;
import it.ethica.esf.service.persistence.ESFgunUserFinderUtil;
import it.ethica.esf.service.persistence.ESFgunUserUtil;

/**
 * The implementation of the e s fgun user local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link it.ethica.esf.service.ESFgunUserLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Ethica
 * @see it.ethica.esf.service.base.ESFgunUserLocalServiceBaseImpl
 * @see it.ethica.esf.service.ESFgunUserLocalServiceUtil
 */
public class ESFgunUserLocalServiceImpl extends ESFgunUserLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link it.ethica.esf.service.ESFgunUserLocalServiceUtil} to access the e s fgun user local service.
	 */
	
	public ESFgunUser addESFGunUser(long esfGunId, long esfUserId, String code ,
			boolean isFavoriteGun, int type, String note, long esfGunTypeId,
			long esfGunKindId, int typeId, String esfMeasures, long esfCaliber,
			ServiceContext serviceContext)
					throws SystemException, PortalException{
		
		long esfGunUserId = counterLocalService.increment();
		ESFgunUser esfGunUser = esFgunUserPersistence.create(esfGunUserId);
		
		esfGunUser.setEsfGunId(esfGunId);
		esfGunUser.setEsfUserId(esfUserId);
		esfGunUser.setCode(code);
		esfGunUser.setIsFavorite(isFavoriteGun);
		esfGunUser.setType(type);
		esfGunUser.setNote(note);
		esfGunUser.setEsfGunnTypeId(esfGunTypeId);
		esfGunUser.setEsfGunKindId(esfGunKindId);
		esfGunUser.setTypeId(typeId);
		esfGunUser.setEsfMeasures(esfMeasures);
		esfGunUser.setEsfCaliber(String.valueOf(esfCaliber));
		
		esFgunUserPersistence.update(esfGunUser);
		
		return esfGunUser;
	}
	
	public List<ESFgunUser> getESFGunByLikeC_K_T( String code, long kind, int type, int start, int end)
			throws SystemException {
		List<ESFgunUser> esfgunsByCodes = new ArrayList<ESFgunUser>();
		List<ESFgunUser> esfguns = new ArrayList<ESFgunUser>();
		List<ESFgunUser> esfgunsReturn = new ArrayList<ESFgunUser>();
		ESFGun gun = new ESFGunImpl();
		ESFCane cane = new ESFCaneImpl();
		
		int total = ESFgunUserLocalServiceUtil.getESFgunUsersCount();
		
		if(0==kind){
			
			if("".equals(code)){
				
				esfgunsByCodes = ESFgunUserLocalServiceUtil.getESFgunUsers(0, total);
				
				for(ESFgunUser gunByCode : esfgunsByCodes ){
					
					if(type == gunByCode.getType()){
						esfguns.add(gunByCode);
					}else if(type == gunByCode.getType()){
						esfguns.add(gunByCode);
					}
				}
				
			}else{
				
				esfgunsByCodes = ESFgunUserLocalServiceUtil.findbyCode(code);
				
					for(ESFgunUser gunByCode : esfgunsByCodes ){
						
						if(type == gunByCode.getType()){
							esfguns.add(gunByCode);
						}else if(type == gunByCode.getType()){
							esfguns.add(gunByCode);
						}
				}
				
			}
			
		}else{
			if("".equals(code)){
				esfgunsByCodes = ESFgunUserLocalServiceUtil.getESFgunUsers(0, total);
				
			}else{
				esfgunsByCodes = ESFgunUserLocalServiceUtil.findbyCode(code);
			}
			
			for(ESFgunUser gunByCode : esfgunsByCodes){
				
				if(1 == gunByCode.getType()){
					
					gun = ESFGunLocalServiceUtil.fetchESFGun(gunByCode.getEsfGunId());
					
					if(Validator.isNotNull(gun) && kind == gun.getEsfGunKindId()){
						esfguns.add(gunByCode);
					}
					
				}else if(2 == gunByCode.getType()){
					
					cane = ESFCaneLocalServiceUtil.fetchESFCane(gunByCode.getEsfGunId());
					
					if(Validator.isNotNull(cane) && kind == cane.getEsfGunKindId()){
						esfguns.add(gunByCode);
					}
					
				}/*else{
					
					catdrige = ESFCatridgeLocalServiceUtil.fetchESFCatridge(gunByCode.getEsfGunId());
					
					if(Validator.isNotNull(catdrige) && kind == catdrige.getEsfGunKindId()){
						esfguns.add(gunByCode);
					}
				}*/
	
			}
		}
		
		if(end > esfguns.size()){
			end = esfguns.size();
		}
		esfgunsReturn = esfguns.subList(start, end);
		
		return esfgunsReturn;
	}
	
	public int countESFGunByLikeC_K_T( String code, long kind, int type)
			throws SystemException {
		List<ESFgunUser> esfgunsByCodes = new ArrayList<ESFgunUser>();
		List<ESFgunUser> esfguns = new ArrayList<ESFgunUser>();
		ESFGun gun = new ESFGunImpl();
		ESFCane cane = new ESFCaneImpl();
		ESFCatridge catdrige = new ESFCatridgeImpl();
		int tot = 0;
		int total = ESFgunUserLocalServiceUtil.getESFgunUsersCount();
		
		if(0==kind){
			
			if("".equals(code)){
				
				esfgunsByCodes = ESFgunUserLocalServiceUtil.getESFgunUsers(0, total);
				
				for(ESFgunUser gunByCode : esfgunsByCodes ){
					
					if(type == gunByCode.getType()){
						esfguns.add(gunByCode);
					}else if(type == gunByCode.getType()){
						esfguns.add(gunByCode);
					}
				}
				
			}else{
				
				esfgunsByCodes = ESFgunUserLocalServiceUtil.findbyCode(code);
				
					for(ESFgunUser gunByCode : esfgunsByCodes ){
						
						if(type == gunByCode.getType()){
							esfguns.add(gunByCode);
						}else if(type == gunByCode.getType()){
							esfguns.add(gunByCode);
						}
				}
				
			}
			
		}else{
			if("".equals(code)){
				esfgunsByCodes = ESFgunUserLocalServiceUtil.getESFgunUsers(0, total);
				
			}else{
				esfgunsByCodes = ESFgunUserLocalServiceUtil.findbyCode(code);
			}
			
			for(ESFgunUser gunByCode : esfgunsByCodes){
				
				if(1 == gunByCode.getType()){
					
					gun = ESFGunLocalServiceUtil.fetchESFGun(gunByCode.getEsfGunId());
					
					if(Validator.isNotNull(gun) && kind == gun.getEsfGunKindId()){
						esfguns.add(gunByCode);
					}
					
				}else if(2 == gunByCode.getType()){
					
					cane = ESFCaneLocalServiceUtil.fetchESFCane(gunByCode.getEsfGunId());
					
					if(Validator.isNotNull(cane) && kind == cane.getEsfGunKindId()){
						esfguns.add(gunByCode);
					}
					
				}
	
			}
		}
		tot = esfguns.size();
		
		return tot;
	}
	
	
	
	public List<ESFgunUser> getESFGunByLikeS_T( long esfShooterId,int type, int start, int end)
			throws SystemException {
		List<ESFgunUser> esfguns = new ArrayList<ESFgunUser>();
		List<ESFgunUser> esfgunsReturn = new ArrayList<ESFgunUser>();
		esfguns = ESFgunUserUtil.findBybyU_T(esfShooterId, type);
		
		if(end > esfguns.size()){
			end = esfguns.size();
		}
		esfgunsReturn = esfguns.subList(start, end);
		
		return esfgunsReturn;
	}
	
	public int countESFGunByLikeS_T( long esfShooterId,int type)
			throws SystemException {
		List<ESFgunUser> esfguns = new ArrayList<ESFgunUser>();
		int tot = 0;
		esfguns = ESFgunUserUtil.findBybyU_T(esfShooterId, type);
		
		tot = esfguns.size();
		
		return tot;
	}
	
	public List<ESFgunUser> getESFGunByT(int type, int start, int end)
			throws SystemException {
		List<ESFgunUser> esfguns = new ArrayList<ESFgunUser>();
		
		esfguns = ESFgunUserUtil.findBybyT(type);
		if(end > esfguns.size()){
			end = esfguns.size();
		}
		
		return esfguns.subList(start, end);
	}
	
	public int countESFGunByT(int type)
			throws SystemException {
		List<ESFgunUser> esfguns = new ArrayList<ESFgunUser>();
		int tot = 0;
		esfguns = ESFgunUserUtil.findBybyT(type);
		
		tot = esfguns.size();
		
		return tot;
	}
	
	public List<ESFgunUser> findbyESFGunId( long esfGunId)
			throws SystemException {
		List<ESFgunUser> esfguns = new ArrayList<ESFgunUser>();
		esfguns = ESFgunUserUtil.findBybyGunId(esfGunId);
		return esfguns;
	}
	
	public List<ESFgunUser> findbyESFGunId_Type( long esfGunId, int type)
			throws SystemException {
		List<ESFgunUser> esfguns = new ArrayList<ESFgunUser>();
		esfguns =  ESFgunUserUtil.findByGunId_Type(esfGunId, type);
		return esfguns;
	}
	
	public List<ESFgunUser> findbyCode( String code)
			throws SystemException {
		List<ESFgunUser> esfguns = new ArrayList<ESFgunUser>();
		esfguns = ESFgunUserUtil.findByCode(code);
		return esfguns;
	}
	public List<ESFgunUser> findbyGunId_Type(long gunId, int type, int start, int end)
			throws SystemException {
		
		List<ESFgunUser> esfguns = new ArrayList<ESFgunUser>();
		esfguns = ESFgunUserUtil.findByGunId_Type(gunId, type);
		
		if(end > esfguns.size()){
			end = esfguns.size();
		}
		
		return esfguns.subList(start, end);
	}
	public int countbyGunId_Type(long gunId, int type)
			throws SystemException {
		int tot = 0;
		List<ESFgunUser> esfguns = new ArrayList<ESFgunUser>();
		
		esfguns = ESFgunUserUtil.findByGunId_Type(gunId, type);
		
		tot = esfguns.size();
				
		return tot;
	}
	
	public List<ESFgunUser> findbyKind_Shooter(String name, String lastName,
			long kindId, int start, int end)
			throws SystemException {
		List<ESFgunUser> gunUsers = new ArrayList<ESFgunUser>();
		
		gunUsers = ESFgunUserFinderUtil.findRifleByKind_Shooter(name, lastName, kindId, start, end);
		
		return gunUsers;
	}	
	
	public List<ESFgunUser> findCanebyKind_Shooter(String name, String lastName,
			long kindId, int start, int end)
			throws SystemException {
		List<ESFgunUser> gunUsers = new ArrayList<ESFgunUser>();
		
		gunUsers = ESFgunUserFinderUtil.findCaneByKind_Shooter(name, lastName, kindId, start, end);
		
		return gunUsers;
	}	
	
	private static Log _log = LogFactoryUtil.getLog(ESFgunUserLocalServiceImpl.class);
}