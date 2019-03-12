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

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import it.ethica.esf.NoSuchNationalDelegationException;
import it.ethica.esf.model.ESFCard;
import it.ethica.esf.model.ESFEntityState;
import it.ethica.esf.model.ESFNationalDelegation;
import it.ethica.esf.model.ESFSuspensiveShootingDirector;
import it.ethica.esf.portlet.ESFShootingDirectorPortlet;
import it.ethica.esf.service.ESFCardLocalServiceUtil;
import it.ethica.esf.service.ESFEntityStateLocalServiceUtil;
import it.ethica.esf.service.ESFNationalDelegationLocalServiceUtil;
import it.ethica.esf.service.base.ESFNationalDelegationLocalServiceBaseImpl;

/**
 * The implementation of the e s f national delegation local service. <p> All
 * custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link it.ethica.esf.service.ESFNationalDelegationLocalService} interface.
 * <p> This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM. </p>
 *
 * @author Ethica
 * @see it.ethica.esf.service.base.ESFNationalDelegationLocalServiceBaseImpl
 * @see it.ethica.esf.service.ESFNationalDelegationLocalServiceUtil
 */
public class ESFNationalDelegationLocalServiceImpl
	extends ESFNationalDelegationLocalServiceBaseImpl {
	
	/*
	 * NOTE FOR DEVELOPERS: Never reference this interface directly. Always use
	 * {@link it.ethica.esf.service.ESFNationalDelegationLocalServiceUtil} to
	 * access the e s f national delegation local service.
	 */
	
	public List<ESFNationalDelegation> getESFNationalDelegationByMatchId_PartecipantTypeId(
		long esfMatchId, long esfPartecipantTypeId)
		throws SystemException {
	
		return esfNationalDelegationPersistence.findByESFMatchESFPartecipantType(
			esfMatchId, esfPartecipantTypeId);
	}
	
	
	public List<ESFNationalDelegation> getESFNationalDelegationByMatchId_PartecipantTypeId_sportTypeId(
			long esfMatchId, long esfPartecipantTypeId, long sportTypeId)
			throws SystemException {
		
			return esfNationalDelegationPersistence.findByPartecipantType_MatchId_SportTypeId(
				 sportTypeId , esfMatchId , esfPartecipantTypeId);
	}
	
	public List<ESFNationalDelegation> getMatchId_SportTypeId_QualificationId(
		long esfMatchId, long sportTypeId , long esfQualicationId)
		throws SystemException {
	
		return esfNationalDelegationPersistence.findByMatchId_SportTypeId_QualificationId(
			esfMatchId, sportTypeId , esfQualicationId);
	}
	
	public ESFNationalDelegation getMatchId_UserId_SportTypeId_QualificationId(
		long esfMatchId, long UserId, long sportTypeId , long esfQualicationId)
		throws SystemException {
	
		try {
			return esfNationalDelegationPersistence.findByMatchId_UserId_SportTypeId_QualificationId(
				esfMatchId, UserId, sportTypeId , esfQualicationId);
		}
		catch (NoSuchNationalDelegationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public List<ESFNationalDelegation> getESFNationalDelegationByESFUserId_ESFMatchId(
		long esfUserId, long esfMatchId)
		throws SystemException {
	
		return esfNationalDelegationPersistence.findByESFMatch_U(
			esfUserId, esfMatchId);
	}
	
	public List<ESFNationalDelegation> getESFNationalDelegationByESFMatchId(long esfMatchId)
		throws SystemException {
	
		return esfNationalDelegationPersistence.findByESFMatch(esfMatchId);
	}
	
	public List<ESFNationalDelegation> getPartecipantType_EsfUserId(long esfUserId)
			throws SystemException {
		
			long partecipanType = 1;
			List<ESFNationalDelegation> delegations = new ArrayList<ESFNationalDelegation>();
			delegations = esfNationalDelegationPersistence.findByPartecipantType_EsfUserId(esfUserId, partecipanType);
			
			
			return delegations;
	}
	/*
	 * metodo per ricerca dei partecipante per user e tipo di partecipazione
	 * (non-Javadoc)
	 * @see it.ethica.esf.service.ESFNationalDelegationLocalService#getESFNationalDelegationByESFMatchIdNotShooter(long)
	 */
	public List<ESFNationalDelegation> findByPartecipantType_EsfUserId(long esfUserId, long partecipantType,
			int start, int end)throws SystemException {
				
	
					List<ESFNationalDelegation> delegations = new ArrayList<ESFNationalDelegation>();
					delegations = esfNationalDelegationPersistence.findByPartecipantType_EsfUserId(esfUserId, partecipantType, start, end);
					return delegations;
	}
	
	public int countPartecipantType_EsfUserId(long esfUserId, long partecipantType)throws SystemException {
			
			int tot = 0;
			List<ESFNationalDelegation> delegations = new ArrayList<ESFNationalDelegation>();
			delegations = esfNationalDelegationPersistence.findByPartecipantType_EsfUserId(esfUserId, partecipantType);
			tot = delegations.size();
			return tot;
	}
	
	
	public List<ESFNationalDelegation> getESFNationalDelegationByESFMatchIdNotShooter(long esfMatchId)
			throws SystemException {
				
				List<ESFNationalDelegation> esfNationalDelegationNotShooter = new ArrayList<ESFNationalDelegation>();
				List<ESFNationalDelegation> esfNationalDelegation =
					ESFNationalDelegationLocalServiceUtil.getESFNationalDelegationByESFMatchId(esfMatchId);
				
				for(ESFNationalDelegation s : esfNationalDelegation){
					if(s.getEsfPartecipantTypeId()!=1){
						esfNationalDelegationNotShooter.add(s);
					}
				}
		
		
			return esfNationalDelegationPersistence.findByESFMatch(esfMatchId);
	}
	
	public ESFNationalDelegation deleteESFNationalDelegation(
		long esfMatchId, long esfUserId)
		throws SystemException {
		
		if(Validator.isNotNull(getESFNationalDelegationByESFUserId_ESFMatchId(
			esfUserId, esfMatchId))){
			ESFNationalDelegation esfNationalDelegation =
								getESFNationalDelegationByESFUserId_ESFMatchId(
												esfUserId, esfMatchId).get(0);
			
			return esfNationalDelegationPersistence.remove(esfNationalDelegation);
		}	
		
		return null;
	}	
	
	public void changeCard(ActionRequest actionRequest, ActionResponse actionResponse) throws SystemException,
	PortletException, PortalException, ParseException
	{
		
		String operation= ParamUtil.getString(actionRequest, "typeOperation");
		long cardUserId = ParamUtil.getLong(actionRequest, "cardUserId");
		long esfMatchId = ParamUtil.getLong(actionRequest, "esfMatchId");
		long esfUserId = ParamUtil.getLong(actionRequest, "esfUserId");
		long esfOrganizationId =
			ParamUtil.getLong(actionRequest, "esfOrganizationId");
		ESFCard actualCardUser =  ESFCardLocalServiceUtil.fetchESFCard(cardUserId);
		Date data = new Date();
		long newCardId = ParamUtil.getLong(actionRequest,"esfCardId");
		ESFCard newCard = ESFCardLocalServiceUtil.fetchESFCard(newCardId);
		ESFEntityState ees = ESFEntityStateLocalServiceUtil
									.findESFEntityStateByC_PK_S("it.ethica.esf.model.ESFCard", actualCardUser.getEsfCardId(), 1);
		ees.setEndDate(data);
		ESFEntityStateLocalServiceUtil.updateESFEntityState(ees);
		newCard.setEsfUserId(esfUserId);
		ESFCardLocalServiceUtil.updateESFCard(newCard);
		
		if(!operation.equals("renewal")){
			ESFCard reloadCard = ESFCardLocalServiceUtil
						.createESFCard(CounterLocalServiceUtil.increment("it.ethica.esf.model.ESFCard"));
			reloadCard.setCode(actualCardUser.getCode());
			reloadCard.setCodeAlfa(actualCardUser.getCodeAlfa());
			reloadCard.setCodeNum(actualCardUser.getCodeNum());
			ESFCardLocalServiceUtil.updateESFCard(reloadCard);
		}
		
		
		actionRequest.setAttribute("esfMatchId", esfMatchId);
		actionRequest.setAttribute("esfUserId", esfUserId);
		actionRequest.setAttribute("organizationId", esfOrganizationId);
		
		actionResponse.setRenderParameter("mvcPath", 
				"/html/esfnationaldelegation/navigation/card.jsp");
		
		actionResponse.setRenderParameter("esfUserId", String.valueOf(esfUserId));
		actionResponse.setRenderParameter("esfMatchId", String.valueOf(esfMatchId));
		
	}
	
	/*
	 * ricerca la presenza di un utente in un match e il tipo di partecipazione
	 * 
	 */
	
	public boolean findConvocation(long matchId, long userId, int partecipantType)throws SystemException{
		
		boolean find = false;
		int total = 0;
		List<ESFNationalDelegation> partecipations = new ArrayList<ESFNationalDelegation>();
		
		partecipations = esfNationalDelegationPersistence.findByESFMatch_U_T(userId, matchId, partecipantType);
		
		total = partecipations.size();
		
		if(0 < total){
			find = true;
		}
		
		return find;
	}
	private static Log _log = LogFactoryUtil.getLog(ESFNationalDelegationLocalServiceImpl.class);
}