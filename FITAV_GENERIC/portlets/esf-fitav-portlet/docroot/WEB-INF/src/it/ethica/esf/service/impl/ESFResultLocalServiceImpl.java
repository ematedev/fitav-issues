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

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.kernel.util.Validator;

import it.ethica.esf.model.ESFNationalMatchResult;
import it.ethica.esf.model.ESFResult;
import it.ethica.esf.service.ESFNationalMatchResultLocalServiceUtil;
import it.ethica.esf.service.ESFResultLocalServiceUtil;
import it.ethica.esf.service.base.ESFResultLocalServiceBaseImpl;
import it.ethica.esf.service.persistence.ESFResultFinderUtil;

/**
 * The implementation of the e s f result local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link it.ethica.esf.service.ESFResultLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Ethica
 * @see it.ethica.esf.service.base.ESFResultLocalServiceBaseImpl
 * @see it.ethica.esf.service.ESFResultLocalServiceUtil
 */
public class ESFResultLocalServiceImpl extends ESFResultLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link it.ethica.esf.service.ESFResultLocalServiceUtil} to access the e s f result local service.
	 */
	
	public boolean inserted(long matchId)
				throws SystemException {
		
		boolean inserted = false;
		List<ESFResult> results = new ArrayList<ESFResult>();
		
		results = esfResultPersistence.findByESFMatchId(matchId);
		
		if(0 < results.size()){
			inserted = true;
		}
		
		
		return inserted;
	}
	
	public List<ESFResult> findByESFMatchid(long esfMatchid)
					throws SystemException {
		List<ESFResult> results = new ArrayList<ESFResult>();
		
		results = esfResultPersistence.findByESFMatchId(esfMatchid);
		
		return results;
	}
	
	public List<ESFResult> findByESFShooterId(long esfShooterId)
					throws SystemException {
		List<ESFResult> results = new ArrayList<ESFResult>();
		
		results = esfResultPersistence.findByESFShooterId(esfShooterId);
		
		return results;
	}
	
	public List<ESFResult> findByESFMId_UId_STId(long esfMatchid, long esfUserId, long sportTypeId)
					throws SystemException {
		List<ESFResult> results = new ArrayList<ESFResult>();
		
		results = esfResultPersistence.findByESFMId_UId_STId(esfMatchid, esfUserId, sportTypeId);
		
		return results;
	}
	
	public List<ESFResult> findESFMId_UId_STId_Single(long esfMatchid, long esfUserId, long sportTypeId)
					throws SystemException {
		List<ESFResult> results = new ArrayList<ESFResult>();
		
		results = esfResultPersistence.findByESFMId_UId_STId_Single(esfMatchid, esfUserId, sportTypeId,0);
		
		return results;
	}
	
	public List<ESFResult> findByESFMId_STId_SQId(long esfMatchid,  long sportTypeId, long qualificationId)
					throws SystemException {
		List<ESFResult> results = new ArrayList<ESFResult>();
		
		results = esfResultPersistence.findByESFMId_STId_SQId(esfMatchid, sportTypeId, qualificationId);
		
		return results;
	}
	
	public List<ESFResult> findByESFMId_STId_SQId_TEAM(long esfMatchid,  long sportTypeId, long qualificationId)
					throws SystemException {
		List<ESFResult> results = new ArrayList<ESFResult>();
		
		results = esfResultPersistence.findByESFMId_STId_SQId_ResultClassTeam(esfMatchid, sportTypeId, qualificationId);
		
		return results;
	}
	
	public List<ESFResult> findByESFMId_STId_SQId_Single(long esfMatchid,  long sportTypeId, long qualificationId)
					throws SystemException {
		List<ESFResult> results = new ArrayList<ESFResult>();
		
		results = esfResultPersistence.findByESFMId_STId_SQId_Single(esfMatchid, sportTypeId, qualificationId);
		
		return results;
	}
	
	public List<String> findDescRanking(long esfMatchid)
					throws SystemException {
		List<String> descRanking = new ArrayList<String>();
		
		descRanking = ESFResultFinderUtil.findDescRanking(esfMatchid);
		return descRanking;
	}
	
	public List<ESFResult> findByESFMatchidDescRanking(long esfMatchid, String descRanking)
					throws SystemException {
		List<ESFResult> results = new ArrayList<ESFResult>();
		
		results = ESFResultFinderUtil.findResultByMatchIdDescRanking(esfMatchid, descRanking);
		
		return results;
	}
	
	public ESFResult getESFResultByESFMatchId_ESFUserId_SportTypeId(
		long esfMatchId, long esfUserId,long sportTypeId) {
		List<ESFResult> ESFResult = null;
		try {
	
			DynamicQuery esfResultQuery =
				DynamicQueryFactoryUtil.forClass(
					ESFResult.class, "esfResultQuery",
					PortletClassLoaderUtil.getClassLoader());
			
			if (Validator.isNotNull(esfMatchId)) {
				esfResultQuery.add(PropertyFactoryUtil.forName("esfResultQuery.esfMatchId").eq(
					esfMatchId));
			}
			
			if (Validator.isNotNull(esfUserId)) {
				esfResultQuery.add(PropertyFactoryUtil.forName("esfResultQuery.esfUserId").eq(
					esfUserId));
			}
			if(Validator.isNotNull(sportTypeId)){
				esfResultQuery.add(PropertyFactoryUtil.forName("esfResultQuery.esfMatchTypeId").eq(
						sportTypeId));
			}
			ESFResult = ESFResultLocalServiceUtil
				.dynamicQuery(esfResultQuery);
			}
		catch (Exception e) {
			e.getMessage();
		}
			
		if(Validator.isNotNull(ESFResult) && !ESFResult.isEmpty()){
			return ESFResult.get(0);
		}
		else{
			return null;
		}
	}
	
	public ESFResult getESFResultByESFMatchId_ESFUserId_SportTypeId_Sigle(
		long esfMatchId, long esfUserId,long sportTypeId) {
		List<ESFResult> ESFResult = null;
		try {
	
			DynamicQuery esfResultQuery =
				DynamicQueryFactoryUtil.forClass(
					ESFResult.class, "esfResultQuery",
					PortletClassLoaderUtil.getClassLoader());
			
			if (Validator.isNotNull(esfMatchId)) {
				esfResultQuery.add(PropertyFactoryUtil.forName("esfResultQuery.esfMatchId").eq(
					esfMatchId));
			}
			
			if (Validator.isNotNull(esfUserId)) {
				esfResultQuery.add(PropertyFactoryUtil.forName("esfResultQuery.esfUserId").eq(
					esfUserId));
			}
			if(Validator.isNotNull(sportTypeId)){
				esfResultQuery.add(PropertyFactoryUtil.forName("esfResultQuery.esfMatchTypeId").eq(
						sportTypeId));
			}
			
			esfResultQuery.add(PropertyFactoryUtil.forName("esfResultQuery.resultClassTeam").eq(
				0));
			
			ESFResult = ESFResultLocalServiceUtil
				.dynamicQuery(esfResultQuery);
			}
		catch (Exception e) {
			e.getMessage();
		}
			
		if(Validator.isNotNull(ESFResult) && !ESFResult.isEmpty()){
			return ESFResult.get(0);
		}
		else{
			return null;
		}
	}
	
	public ESFResult getESFResultByESFMatchId_ESFUserId_SportTypeId_QualificationId_Team(
		long esfMatchId, long esfUserId,long sportTypeId, long qualificationId) {
		List<ESFResult> ESFResult = null;
		try {
	
			DynamicQuery esfResultQuery =
				DynamicQueryFactoryUtil.forClass(
					ESFResult.class, "esfResultQuery",
					PortletClassLoaderUtil.getClassLoader());
			
			if (Validator.isNotNull(esfMatchId)) {
				esfResultQuery.add(PropertyFactoryUtil.forName("esfResultQuery.esfMatchId").eq(
					esfMatchId));
			}
			
			if (Validator.isNotNull(esfUserId)) {
				esfResultQuery.add(PropertyFactoryUtil.forName("esfResultQuery.esfUserId").eq(
					esfUserId));
			}
			if(Validator.isNotNull(sportTypeId)){
				esfResultQuery.add(PropertyFactoryUtil.forName("esfResultQuery.esfMatchTypeId").eq(
						sportTypeId));
			}
			if(Validator.isNotNull(sportTypeId)){
				esfResultQuery.add(PropertyFactoryUtil.forName("esfResultQuery.shooterQualification").eq(
					qualificationId));
			}
			esfResultQuery.add(PropertyFactoryUtil.forName("esfResultQuery.resultClassTeam").ne(
				0));
			
			ESFResult = ESFResultLocalServiceUtil
				.dynamicQuery(esfResultQuery);
			}
		catch (Exception e) {
			e.getMessage();
		}
			
		if(Validator.isNotNull(ESFResult) && !ESFResult.isEmpty()){
			return ESFResult.get(0);
		}
		else{
			return null;
		}
	}
	
}