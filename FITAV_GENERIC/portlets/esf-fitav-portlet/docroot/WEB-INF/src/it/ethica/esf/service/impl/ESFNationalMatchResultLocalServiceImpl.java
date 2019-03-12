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

import it.ethica.esf.NoSuchNationalMatchResultException;
import it.ethica.esf.model.ESFNationalMatchResult;
import it.ethica.esf.service.ESFNationalMatchResultLocalServiceUtil;
import it.ethica.esf.service.base.ESFNationalMatchResultLocalServiceBaseImpl;

/**
 * The implementation of the e s f national match result local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link it.ethica.esf.service.ESFNationalMatchResultLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Ethica
 * @see it.ethica.esf.service.base.ESFNationalMatchResultLocalServiceBaseImpl
 * @see it.ethica.esf.service.ESFNationalMatchResultLocalServiceUtil
 */
public class ESFNationalMatchResultLocalServiceImpl
	extends ESFNationalMatchResultLocalServiceBaseImpl {

	public List<ESFNationalMatchResult> getESFNationalMatchResultsByESFMatchId(
			long esfMatchId){

		List<ESFNationalMatchResult> esfNationalMatchResult = null;
		try {

			DynamicQuery esfResultQuery =
				DynamicQueryFactoryUtil.forClass(
					ESFNationalMatchResult.class, "esfResultQuery",
					PortletClassLoaderUtil.getClassLoader());
			
			if (Validator.isNotNull(esfMatchId)) {
				esfResultQuery.add(PropertyFactoryUtil.forName("esfResultQuery.esfMatchId").eq(
					esfMatchId));
			}

			esfNationalMatchResult = ESFNationalMatchResultLocalServiceUtil.
														dynamicQuery(esfResultQuery);
		}
		catch (Exception e) {
			e.getMessage();
		}
		
		return esfNationalMatchResult;
	}

	public ESFNationalMatchResult getESFNationalMatchResultByESFMatchId_ESFUserId(
			long esfMatchId, long esfUserId) {
		List<ESFNationalMatchResult> esfNationalMatchResult = null;
		try {

			DynamicQuery esfResultQuery =
				DynamicQueryFactoryUtil.forClass(
					ESFNationalMatchResult.class, "esfResultQuery",
					PortletClassLoaderUtil.getClassLoader());
			
			if (Validator.isNotNull(esfMatchId)) {
				esfResultQuery.add(PropertyFactoryUtil.forName("esfResultQuery.esfMatchId").eq(
					esfMatchId));
			}
			
			if (Validator.isNotNull(esfUserId)) {
				esfResultQuery.add(PropertyFactoryUtil.forName("esfResultQuery.esfUserId").eq(
					esfUserId));
			}

			esfNationalMatchResult = ESFNationalMatchResultLocalServiceUtil
				.dynamicQuery(esfResultQuery);
		}
		catch (Exception e) {
			e.getMessage();
		}
		
		if(Validator.isNotNull(esfNationalMatchResult) && !esfNationalMatchResult.isEmpty()){
			return esfNationalMatchResult.get(0);
		}
		else{
			return null;
		}
	}
	
	public ESFNationalMatchResult getESFNationalMatchResultByESFMatchId_ESFUserId_SportTypeId(
			long esfMatchId, long esfUserId,long sportTypeId) {
		List<ESFNationalMatchResult> esfNationalMatchResult = null;
		try {

			DynamicQuery esfResultQuery =
				DynamicQueryFactoryUtil.forClass(
					ESFNationalMatchResult.class, "esfResultQuery",
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
				esfResultQuery.add(PropertyFactoryUtil.forName("esfResultQuery.esfSportTypeId").eq(
						sportTypeId));
			}
			esfNationalMatchResult = ESFNationalMatchResultLocalServiceUtil
				.dynamicQuery(esfResultQuery);
		}
		catch (Exception e) {
			e.getMessage();
		}
		
		if(Validator.isNotNull(esfNationalMatchResult) && !esfNationalMatchResult.isEmpty()){
			return esfNationalMatchResult.get(0);
		}
		else{
			return null;
		}
	}
	
	
	public List<ESFNationalMatchResult> getESFMatchByEsfMatchResultUserId (long esfUserId){
		List<ESFNationalMatchResult> esfMatchResults = new ArrayList<ESFNationalMatchResult>();
		try {
			esfMatchResults = esfNationalMatchResultPersistence.findByESFUserId(esfUserId);
		}
		catch (Exception e){
			System.out.println (e.toString());
		}
		return esfMatchResults;
	}
	
	public List<ESFNationalMatchResult> getESFMatchByEsfMatchId_ESFQualificationId_ESFSportTypeId(long matchId, long qualificationId,long sportTypeId) throws SystemException{
		return esfNationalMatchResultPersistence.findByESFMatchId_QualificationId_ESFSportTypeId(matchId, qualificationId ,sportTypeId);
	}
	
	public List<ESFNationalMatchResult> getESFMatchByEsfMatchId_ESFSportTypeId(long matchId, long sportTypeId) throws SystemException{
		return esfNationalMatchResultPersistence.findByESFMatchId_ESFSportTypeId(matchId, sportTypeId);
	}
	@Override
	public List<ESFNationalMatchResult> getExternalShooter(long esfMatchId) throws SystemException {
		return esfNationalMatchResultPersistence.findByESFMatchId_ExternalShooter(esfMatchId, true);
	}

	public List<ESFNationalMatchResult> getExternalShooterSportType(long esfMatchId,long sportTypeid) throws SystemException {
		return esfNationalMatchResultPersistence.findByESFMatchId_ExternalShooter_ESFSportTypeId(esfMatchId, true, sportTypeid);
	} 
	
	public List<ESFNationalMatchResult> getNMRByMatchId_UserId(long esfMatchId,long userId) throws SystemException {
		return esfNationalMatchResultPersistence.findBymatchId_userId(esfMatchId, userId);
	} 
	
	public ESFNationalMatchResult getESFNationalMatchByEsFMatchId(long esfMatchId) 
			throws NoSuchNationalMatchResultException, com.liferay.portal.kernel.exception.SystemException{
		return esfNationalMatchResultPersistence.findByESFMatchId(esfMatchId);
	}

}