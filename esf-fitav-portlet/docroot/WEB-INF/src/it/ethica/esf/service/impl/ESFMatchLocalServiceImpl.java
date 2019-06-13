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
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.model.AssetLinkConstants;

import it.ethica.esf.NoSuchMatchException;
import it.ethica.esf.model.ESFEntityState;
import it.ethica.esf.model.ESFMatch;
import it.ethica.esf.model.ESFNationalDelegation;
import it.ethica.esf.model.ESFNationalMatchResult;
import it.ethica.esf.model.ESFOrganization;
import it.ethica.esf.model.ESFShooterCategoryESFMatch;
import it.ethica.esf.model.ESFShooterQualificationESFMatch;
import it.ethica.esf.model.impl.ESFMatchImpl;
import it.ethica.esf.model.impl.ESFMatchModelImpl;
import it.ethica.esf.portlet.utility.MatchComparator;
import it.ethica.esf.portlet.utility.MatchYearOrderByComparator;
import it.ethica.esf.service.ESFEntityStateLocalServiceUtil;
import it.ethica.esf.service.ESFMatchLocalServiceUtil;
import it.ethica.esf.service.ESFNationalDelegationLocalServiceUtil;
import it.ethica.esf.service.ESFOrganizationLocalServiceUtil;
import it.ethica.esf.service.ESFShooterCategoryESFMatchLocalServiceUtil;
import it.ethica.esf.service.ESFShooterQualificationESFMatchLocalServiceUtil;
import it.ethica.esf.service.base.ESFMatchLocalServiceBaseImpl;
import it.ethica.esf.service.persistence.ESFMatchFinderUtil;
import it.ethica.esf.service.persistence.ESFShooterCategoryESFMatchPK;
import it.ethica.esf.service.persistence.ESFShooterQualificationESFMatchPK;
import it.ethica.esf.util.ESFKeys;
import it.ethica.esf.util.GenericUtility;

/**
 * The implementation of the e s f match local service.
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link it.ethica.esf.service.ESFMatchLocalService} interface.
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Ethica
 * @see it.ethica.esf.service.base.ESFMatchLocalServiceBaseImpl
 * @see it.ethica.esf.service.ESFMatchLocalServiceUtil
 */
public class ESFMatchLocalServiceImpl extends ESFMatchLocalServiceBaseImpl {

	private static Log _log = LogFactoryUtil
			.getLog(ESFMatchLocalServiceImpl.class);
	
	public List<ESFMatch>findESFMatchesByYearIsNational(int year,
															boolean isNational){
		
		List<ESFMatch> resultList = new ArrayList<ESFMatch>();
		List<ESFMatch> allMathces = ESFMatchLocalServiceUtil.
										findESFMatchsByStateIsNational(
												ESFKeys.ESFStateType.ENABLE, 
																	isNational);
		for(ESFMatch m : allMathces){
			if((m.getStartDate().getYear()+1900) == year){
				resultList.add(m);
			}
		}
		
		return resultList;
	}
	
	public List<ESFMatch> findESFMatchsByStateIsNational_C_S_M_C_O(int state, boolean isNational, 
		String code, Date startDate, long esfMatchType, long country, String eventType/*, boolean isOlimpicQualification*/){
	
		List<ESFMatch> esfMatchs = new ArrayList<ESFMatch>();

		try {

			List<ESFMatch> activeNationalMatches = 
							findESFMatchsByStateIsNational(state, isNational) ;
			
			if (activeNationalMatches == null || activeNationalMatches.size() <= 0)
				return esfMatchs;

			long[] classPKs = new long[activeNationalMatches.size()];

			int i = 0;

			for (ESFMatch m : activeNationalMatches) {
				classPKs[i] = m.getEsfMatchId();
				i++;
			}

			DynamicQuery matchQuery = DynamicQueryFactoryUtil.forClass(
					ESFMatch.class, "matchQuery",
					PortletClassLoaderUtil.getClassLoader());
			
			if(Validator.isNotNull(code)){
				matchQuery.add(PropertyFactoryUtil.forName("matchQuery.code")
					.like(code  + StringPool.PERCENT));
			}
			
			if(Validator.isNotNull(eventType)){
				matchQuery.add(PropertyFactoryUtil.forName("matchQuery.eventType")
					.like(eventType  + StringPool.PERCENT));
			}
			
			if(Validator.isNotNull(startDate)){
				matchQuery.add(PropertyFactoryUtil.forName("matchQuery.startDate")
					.ge(startDate));
			}
			
			if(Validator.isNotNull(esfMatchType) && esfMatchType > 0){
				matchQuery.add(PropertyFactoryUtil.forName("matchQuery.esfMatchTypeId")
					.eq(esfMatchType));
			}
			if(Validator.isNotNull(country) && country > 0){
				matchQuery.add(PropertyFactoryUtil.forName("matchQuery.countryId")
					.eq(country));
			}
			
				matchQuery.add(PropertyFactoryUtil.forName("matchQuery.esfMatchId")
									.in(classPKs));
			esfMatchs = ESFMatchLocalServiceUtil.dynamicQuery(matchQuery);

		} catch (Exception e) {
				e.getMessage();
		}
		return esfMatchs;

		
	}
	
	public List<ESFMatch> findESFMatchsByStateIsNational_C_S_M_C_O(int state, boolean isNational, 
		String code, Date startDate, long esfMatchType, long country, String eventType,
		int start, int end){
		
		List<ESFMatch> esfMatchs = new ArrayList<ESFMatch>();

		try {

			List<ESFMatch> activeNationalMatches = 
							findESFMatchsByStateIsNational(state, isNational, start, end) ;
			
			if (activeNationalMatches == null || activeNationalMatches.size() <= 0)
				return esfMatchs;

			long[] classPKs = new long[activeNationalMatches.size()];

			int i = 0;

			for (ESFMatch m : activeNationalMatches) {
				classPKs[i] = m.getEsfMatchId();
				i++;
			}

			DynamicQuery matchQuery = DynamicQueryFactoryUtil.forClass(
					ESFMatch.class, "matchQuery",
					PortletClassLoaderUtil.getClassLoader());
			
			if(Validator.isNotNull(code)){
				matchQuery.add(PropertyFactoryUtil.forName("matchQuery.code")
					.like(code  + StringPool.PERCENT));
			}
			
			if(Validator.isNotNull(eventType)){
				matchQuery.add(PropertyFactoryUtil.forName("matchQuery.eventType")
					.like(eventType  + StringPool.PERCENT));
			}
			
			if(Validator.isNotNull(startDate)){
				matchQuery.add(PropertyFactoryUtil.forName("matchQuery.startDate")
					.ge(startDate));
			}
			
			if(Validator.isNotNull(esfMatchType)){
				matchQuery.add(PropertyFactoryUtil.forName("matchQuery.esfMatchTypeId")
					.eq(esfMatchType));
			}
			if(Validator.isNotNull(country)){
				matchQuery.add(PropertyFactoryUtil.forName("matchQuery.countryId")
					.eq(country));
			}
			
				matchQuery.add(PropertyFactoryUtil.forName("matchQuery.esfMatchId")
						.in(classPKs));

			esfMatchs = ESFMatchLocalServiceUtil.dynamicQuery(matchQuery, start, end);

		} catch (Exception e) {
				e.getMessage();
		}
		return esfMatchs;	
	}
	
	
	public List<ESFMatch> findESFMatchsByStateIsNational_C_S_M_C_A(int state, boolean isNational, 
		String code, Date startDate, long esfMatchType, long assotiationName){
	
		List<ESFMatch> esfMatchs = new ArrayList<ESFMatch>();

		try {

			List<ESFMatch> activeNationalMatches = 
							findESFMatchsByStateIsNational(state, isNational) ;
			
			if (activeNationalMatches == null || activeNationalMatches.size() <= 0)
				return esfMatchs;

			long[] classPKs = new long[activeNationalMatches.size()];

			int i = 0;

			for (ESFMatch m : activeNationalMatches) {
				classPKs[i] = m.getEsfMatchId();
				i++;
			}
			DynamicQuery matchQuery = DynamicQueryFactoryUtil.forClass(
					ESFMatch.class, "matchQuery",
					PortletClassLoaderUtil.getClassLoader());
			
			if(Validator.isNotNull(code)){
				matchQuery.add(PropertyFactoryUtil.forName("matchQuery.code")
					.like(code  + StringPool.PERCENT));
			}
			
			if(Validator.isNotNull(startDate)){
				matchQuery.add(PropertyFactoryUtil.forName("matchQuery.startDate")
					.ge(startDate));
			}
			
			if(Validator.isNotNull(esfMatchType) && esfMatchType > 0){
				matchQuery.add(PropertyFactoryUtil.forName("matchQuery.esfMatchTypeId")
					.eq(esfMatchType));
			}
			if(Validator.isNotNull(assotiationName) && assotiationName > 0){
				matchQuery.add(PropertyFactoryUtil.forName("matchQuery.esfAssociationId")
					.eq(assotiationName));
			}
			
				matchQuery.add(PropertyFactoryUtil.forName("matchQuery.esfMatchId")
									.in(classPKs));
			esfMatchs = ESFMatchLocalServiceUtil.dynamicQuery(matchQuery);
			
		} catch (Exception e) {
				e.printStackTrace();
		}
		
		return esfMatchs;
		
	}
	
	public List<ESFMatch> findESFMatchsByStateIsNational_C_S_M_C_A(int state, boolean isNational, 
		String code, Date startDate, long esfMatchType, long assotiationName,
		int start, int end){
		
		List<ESFMatch> esfMatchs = new ArrayList<ESFMatch>();

		try {
			List<ESFMatch> activeNationalMatches = 
							findESFMatchsByStateIsNational(state, isNational) ;
			if (activeNationalMatches == null || activeNationalMatches.size() <= 0)
				return esfMatchs;
			
			long[] classPKs = new long[activeNationalMatches.size()];

			int i = 0;

			for (ESFMatch m : activeNationalMatches) {
				classPKs[i] = m.getEsfMatchId();
				i++;
			}

			DynamicQuery matchQuery = DynamicQueryFactoryUtil.forClass(
					ESFMatch.class, "matchQuery",
					PortletClassLoaderUtil.getClassLoader());
			
			if(Validator.isNotNull(code)){
				matchQuery.add(PropertyFactoryUtil.forName("matchQuery.code")
					.like(code  + StringPool.PERCENT));
			}
			
			if(Validator.isNotNull(startDate)){
				matchQuery.add(PropertyFactoryUtil.forName("matchQuery.startDate")
					.ge(startDate));
			}
			
			if(Validator.isNotNull(esfMatchType)){
				matchQuery.add(PropertyFactoryUtil.forName("matchQuery.esfMatchTypeId")
					.eq(esfMatchType));
			}
			if(Validator.isNotNull(assotiationName)){
				matchQuery.add(PropertyFactoryUtil.forName("matchQuery.esfAssociationId")
					.eq(assotiationName));
			}
			
				matchQuery.add(PropertyFactoryUtil.forName("matchQuery.esfMatchId")
						.in(classPKs));
			esfMatchs = ESFMatchLocalServiceUtil.dynamicQuery(matchQuery, start, end);

		} catch (Exception e) {
				e.printStackTrace();
		}
		return esfMatchs;	
	}
	
	
	public List<ESFMatch> findESFMatchsByStateIsNational_C_S_M_C_I(int state, boolean isNational, 
			String code, Date startDate, long esfMatchType, long assotiationId){
		
			List<ESFMatch> esfMatchs = new ArrayList<ESFMatch>();

			try {

				List<ESFMatch> activeNationalMatches = 
								findESFMatchsByStateIsNational(state, isNational) ;
				
				if (activeNationalMatches == null || activeNationalMatches.size() <= 0)
					return esfMatchs;

				long[] classPKs = new long[activeNationalMatches.size()];

				int i = 0;

				for (ESFMatch m : activeNationalMatches) {
					classPKs[i] = m.getEsfMatchId();
					i++;
				}

				DynamicQuery matchQuery = DynamicQueryFactoryUtil.forClass(
						ESFMatch.class, "matchQuery",
						PortletClassLoaderUtil.getClassLoader());
				
				if(Validator.isNotNull(code)){
					matchQuery.add(PropertyFactoryUtil.forName("matchQuery.code")
						.like(code  + StringPool.PERCENT));
				}
				
				if(Validator.isNotNull(startDate)){
					matchQuery.add(PropertyFactoryUtil.forName("matchQuery.startDate")
						.ge(startDate));
				}
				
				if(Validator.isNotNull(esfMatchType) && esfMatchType > 0){
					matchQuery.add(PropertyFactoryUtil.forName("matchQuery.esfMatchTypeId")
						.eq(esfMatchType));
				}
				if(Validator.isNotNull(assotiationId) && assotiationId > 0){
					matchQuery.add(PropertyFactoryUtil.forName("matchQuery.esfAssociationId")
						.eq(assotiationId));
				}
				
					matchQuery.add(PropertyFactoryUtil.forName("matchQuery.esfMatchId")
										.in(classPKs));
				esfMatchs = ESFMatchLocalServiceUtil.dynamicQuery(matchQuery);

			} catch (Exception e) {
					e.getMessage();
			}
			return esfMatchs;
	}
	
	public List<ESFMatch> findESFMatchsByStateIsNational_C_S_M_C_I(int state, boolean isNational, 
			String code, Date startDate, long esfMatchType, long assotiationId,
			int start, int end){
			
			List<ESFMatch> esfMatchs = new ArrayList<ESFMatch>();

			try {

				List<ESFMatch> activeNationalMatches = 
								findESFMatchsByStateIsNational(state, isNational, start, end) ;
				
				if (activeNationalMatches == null || activeNationalMatches.size() <= 0)
					return esfMatchs;

				long[] classPKs = new long[activeNationalMatches.size()];

				int i = 0;

				for (ESFMatch m : activeNationalMatches) {
					classPKs[i] = m.getEsfMatchId();
					i++;
				}

				DynamicQuery matchQuery = DynamicQueryFactoryUtil.forClass(
						ESFMatch.class, "matchQuery",
						PortletClassLoaderUtil.getClassLoader());
				
				if(Validator.isNotNull(code)){
					matchQuery.add(PropertyFactoryUtil.forName("matchQuery.code")
						.like(code  + StringPool.PERCENT));
				}
				
				if(Validator.isNotNull(startDate)){
					matchQuery.add(PropertyFactoryUtil.forName("matchQuery.startDate")
						.ge(startDate));
				}
				
				if(Validator.isNotNull(esfMatchType)){
					matchQuery.add(PropertyFactoryUtil.forName("matchQuery.esfMatchTypeId")
						.eq(esfMatchType));
				}
				if(Validator.isNotNull(assotiationId)){
					matchQuery.add(PropertyFactoryUtil.forName("matchQuery.esfAssociationId")
						.eq(assotiationId));
				}
				
					matchQuery.add(PropertyFactoryUtil.forName("matchQuery.esfMatchId")
							.in(classPKs));

				esfMatchs = ESFMatchLocalServiceUtil.dynamicQuery(matchQuery, start, end);
				
			} catch (Exception e) {
					e.getMessage();
			}
			return esfMatchs;	
		}

	/**
	 * Cerca tutti I match sulla base dello stato [attivo o disattivo]
	 */
	public List<ESFMatch> findESFMatchsByStateIsNational(int state,
			boolean isNational) {

		List<ESFMatch> esfMatchs = new ArrayList<ESFMatch>();

		try {

			List<ESFEntityState> entityStates = ESFEntityStateLocalServiceUtil
					.findESFEntityStateByC_S(ESFMatch.class.getName(), state);

			if (entityStates == null || entityStates.size() <= 0)
				return esfMatchs;

			long[] classPKs = new long[entityStates.size()];

			int i = 0;

			for (ESFEntityState entityState : entityStates) {
				classPKs[i] = entityState.getClassPK();
				i++;
			}

			DynamicQuery matchQuery = DynamicQueryFactoryUtil.forClass(
					ESFMatch.class, "matchQuery",
					PortletClassLoaderUtil.getClassLoader());

			matchQuery.add(PropertyFactoryUtil.forName("matchQuery.isNational")
					.eq(isNational));
			matchQuery.add(PropertyFactoryUtil.forName("matchQuery.esfMatchId")
					.in(classPKs));

			esfMatchs = ESFMatchLocalServiceUtil.dynamicQuery(matchQuery);
		} catch (Exception e) {

		}
		return esfMatchs;
	}
	
	/**
	 * Cerca tutti I match sulla base dello stato [attivo o disattivo]
	 */
	public List<ESFMatch> findESFMatchsByStateIsNational(int state,
			boolean isNational, int start, int end) {

		List<ESFMatch> esfMatchs = new ArrayList<ESFMatch>();

		try {

			List<ESFEntityState> entityStates = ESFEntityStateLocalServiceUtil
					.findESFEntityStateByC_S(ESFMatch.class.getName(), state);

			if (entityStates == null || entityStates.size() <= 0)
				return esfMatchs;

			long[] classPKs = new long[entityStates.size()];

			int i = 0;

			for (ESFEntityState entityState : entityStates) {
				classPKs[i] = entityState.getClassPK();
				i++;
			}

			DynamicQuery matchQuery = DynamicQueryFactoryUtil.forClass(
					ESFMatch.class, "matchQuery",
					PortletClassLoaderUtil.getClassLoader());

			matchQuery.add(PropertyFactoryUtil.forName("matchQuery.isNational")
					.eq(isNational));
			matchQuery.add(PropertyFactoryUtil.forName("matchQuery.esfMatchId")
					.in(classPKs));

			esfMatchs = ESFMatchLocalServiceUtil.dynamicQuery(matchQuery,
					start, end);
		} catch (Exception e) {

		}
		return esfMatchs;
	}

	
	/**
	 * Cerca tutti I match sulla base dell'ornanizationId e dello stato [attivo
	 * o disattivo]
	 */
	public List<ESFMatch> findESFMatchsByO_S_N(long esfOrganizationId,
			int state, boolean isNational, int start, int end) {
		
		List<ESFMatch> esfMatchs = new ArrayList<ESFMatch>();

		try {

			List<ESFEntityState> entityStates = ESFEntityStateLocalServiceUtil
					.findESFEntityStateByC_S(ESFMatch.class.getName(), state);

			if (entityStates == null || entityStates.size() <= 0)
				return esfMatchs;

			long[] classPKs = new long[entityStates.size()];

			int i = 0;

			for (ESFEntityState entityState : entityStates) {
				classPKs[i] = entityState.getClassPK();
				i++;
			}

			List<ESFOrganization> orgIds = ESFOrganizationLocalServiceUtil
					.findAllLeafOrganizations(esfOrganizationId);
			long[] orgIdsPKs = new long[orgIds.size()];
			i = 0;

			for (ESFOrganization orgId : orgIds) {
				orgIdsPKs[i] = orgId.getEsfOrganizationId();
				i++;
			}

			DynamicQuery matchQuery = DynamicQueryFactoryUtil.forClass(
					ESFMatch.class, "matchQuery",
					PortletClassLoaderUtil.getClassLoader());

			matchQuery.add(PropertyFactoryUtil.forName(
					"matchQuery.esfAssociationId").in(orgIdsPKs));
			matchQuery.add(PropertyFactoryUtil.forName("isNational").eq(
					new Boolean(isNational)));
			matchQuery.add(PropertyFactoryUtil.forName("matchQuery.esfMatchId")
					.in(classPKs));
			esfMatchs = ESFMatchLocalServiceUtil.dynamicQuery(matchQuery,
					start, end);
		} catch (Exception e) {

		}
		return esfMatchs;
	}
	
	//ricerca match validi per cambio categoria  in base allo sportype  eall'anno 
	public List<ESFMatch> findbyIsChangeCategoryYear(boolean IsChangeCategory, long sportType, int year)
			throws SystemException {

		List<ESFMatch> matchs = new ArrayList<ESFMatch>();
		List<ESFMatch> esfMatchs = null;
		Date matchData = new Date();
		
		
		esfMatchs = esfMatchPersistence. findByIsChangeCategory(IsChangeCategory);
		
		if(sportType != 0){
			for(ESFMatch esfMatch : esfMatchs){
				
				matchData=esfMatch.getStartDate();
				String yearStr = matchData.toString();
				String currYear = yearStr.substring(0, 4);

				int currentYear = Integer.valueOf(currYear);
				
				
				if((esfMatch.getEsfSportTypeId() == sportType) &&
						(currentYear == year)){
					matchs.add(esfMatch);
				}
			}
		}else {
			for(ESFMatch esfMatch : esfMatchs){
				
				matchData=esfMatch.getStartDate();
				String yearStr = matchData.toString();
				String currYear = yearStr.substring(0, 4);

				int currentYear = Integer.valueOf(currYear);
				
				if(currentYear == year){
					matchs.add(esfMatch);
				}
			}
		}
		
		return matchs;
	}
	
	//ricerca dei match per specialità anno, descrizione
	public List<ESFMatch> findbyIsChangeCategoryYearDescription(boolean IsChangeCategory, long sportType, int year, Long description)
				throws SystemException {

			List<ESFMatch> matchs = new ArrayList<ESFMatch>();
			List<ESFMatch> esfMatchs = null;
			Date matchData = new Date();
			
			
			esfMatchs = esfMatchPersistence. findByIsChangeCategory(IsChangeCategory);

				for(ESFMatch esfMatch : esfMatchs){
					
					matchData=esfMatch.getStartDate();
					String yearStr = matchData.toString();
					String currYear = yearStr.substring(0, 4);

					int currentYear = Integer.valueOf(currYear);
					
					
					if((esfMatch.getEsfSportTypeId() == sportType) &&
							(currentYear == year) && esfMatch.getDescription() == description){
						matchs.add(esfMatch);
					}
				}
			
			
			return matchs;
		}

	/*
	 * Trova tutte le gare in base alla data, tipo di gara, associazione, e
	 * descrizione
	 */
	public List<ESFMatch> getESFMatchesByMatchStartDate_T_A_D_N(Date startDate,
			long matchType, long associationId, long descriptionId,
			boolean isNational) {

		List<ESFMatch> esfMatches = null;
		try {

			DynamicQuery matchesQuery = DynamicQueryFactoryUtil.forClass(
					ESFMatch.class, "matchesQuery",
					PortletClassLoaderUtil.getClassLoader());
			if (associationId > 0) {
				matchesQuery.add(PropertyFactoryUtil.forName(
						"matchesQuery.esfAssociationId").eq(associationId));
			}
			if (descriptionId > 0) {
				matchesQuery.add(PropertyFactoryUtil.forName(
						"matchesQuery.description").eq(descriptionId));
			}
			if (matchType > 0) {
				matchesQuery.add(PropertyFactoryUtil.forName(
						"matchesQuery.esfMatchTypeId").eq(matchType));
			}
			if (startDate != null) {
				matchesQuery.add(PropertyFactoryUtil.forName(
						"matchesQuery.startDate").ge(startDate));
			}
			matchesQuery.add(PropertyFactoryUtil.forName(
					"matchesQuery.isNational").eq(isNational));

			esfMatches = ESFMatchLocalServiceUtil.dynamicQuery(matchesQuery);

		} catch (Exception e) {
			e.getMessage();
		}

		return esfMatches;
	}

	public List<ESFMatch> findMyMatches(long userId,
			boolean isNational, long organizationId, Date startDate,
			long descriptionId, long SportTypeId) throws Exception {
		List<ESFMatch> esfMatches = null;
		try {

			DynamicQuery matchesQuery = DynamicQueryFactoryUtil.forClass(
					ESFMatch.class, "matchesQuery",
					PortletClassLoaderUtil.getClassLoader());

			if (userId > 0) {
				matchesQuery.add(PropertyFactoryUtil.forName(
						"matchesQuery.userId").eq(userId));
			}

			matchesQuery.add(PropertyFactoryUtil.forName(
					"matchesQuery.isNational").eq(isNational));

			if (organizationId > 0) {
				matchesQuery.add(PropertyFactoryUtil.forName(
						"matchesQuery.organizationId").eq(organizationId));
			}

			if (startDate != null) {
				matchesQuery.add(PropertyFactoryUtil.forName(
						"matchesQuery.startDate").ge(startDate));
			}

			if (descriptionId > 0) {
				matchesQuery.add(PropertyFactoryUtil.forName(
						"matchesQuery.description").eq(descriptionId));
			}

			if (SportTypeId > 0) {
				matchesQuery.add(PropertyFactoryUtil.forName(
						"matchesQuery.esfSportTypeId").eq(SportTypeId));
			}

			esfMatches = ESFMatchLocalServiceUtil.dynamicQuery(matchesQuery);

		} catch (Exception e) {
			e.getMessage();
		}

		return esfMatches;
	}
	public List<ESFMatch> findByUI_iN_OI_sD_dId_STId(long userId,
			boolean isNational, long organizationId, Date startDate,
			long descriptionId, long SportTypeId, int start, int end) 
				throws Exception{
		List<ESFMatch> esfMatches = null;
		try {

			DynamicQuery matchesQuery = DynamicQueryFactoryUtil.forClass(
					ESFMatch.class, "matchesQuery",
					PortletClassLoaderUtil.getClassLoader());

			if (userId > 0) {
				matchesQuery.add(PropertyFactoryUtil.forName(
						"matchesQuery.userId").eq(userId));
			}

			matchesQuery.add(PropertyFactoryUtil.forName(
					"matchesQuery.isNational").eq(isNational));

			if (organizationId > 0) {
				matchesQuery.add(PropertyFactoryUtil.forName(
						"matchesQuery.organizationId").eq(organizationId));
			}

			if (startDate != null) {
				matchesQuery.add(PropertyFactoryUtil.forName(
						"matchesQuery.startDate").ge(startDate));
			}

			if (descriptionId > 0) {
				matchesQuery.add(PropertyFactoryUtil.forName(
						"matchesQuery.description").eq(descriptionId));
			}

			if (SportTypeId > 0) {
				matchesQuery.add(PropertyFactoryUtil.forName(
						"matchesQuery.esfSportTypeId").eq(SportTypeId));
			}

			esfMatches=ESFMatchLocalServiceUtil.dynamicQuery(matchesQuery,
						start, end);

		} catch (Exception e) {
			e.getMessage();
		}

		return esfMatches;
	}

	/**
	 * Cerca tutti I match sulla base dell'ornanizationId e dello stato [attivo
	 * o disattivo]
	 */
	public List<ESFMatch> findESFMatchsByO_S_N(long esfOrganizationId,
			int state, boolean isNational) {
		
		List<ESFMatch> esfMatchs = new ArrayList<ESFMatch>();
		try {

			List<ESFEntityState> entityStates = ESFEntityStateLocalServiceUtil
					.findESFEntityStateByC_S(ESFMatch.class.getName(), state);

			if (entityStates == null || entityStates.size() <= 0)
				return esfMatchs;

			long[] classPKs = new long[entityStates.size()];

			int i = 0;

			for (ESFEntityState entityState : entityStates) {
				classPKs[i] = entityState.getClassPK();
				i++;
			}

			List<ESFOrganization> orgIds = ESFOrganizationLocalServiceUtil
					.findAllLeafOrganizations(esfOrganizationId);
			long[] orgIdsPKs = new long[orgIds.size()];
			i = 0;

			for (ESFOrganization orgId : orgIds) {
				orgIdsPKs[i] = orgId.getEsfOrganizationId();
				i++;
			}

			DynamicQuery matchQuery = DynamicQueryFactoryUtil.forClass(
					ESFMatch.class, "matchQuery",
					PortletClassLoaderUtil.getClassLoader());

			matchQuery.add(PropertyFactoryUtil.forName(
					"matchQuery.esfAssociationId").in(orgIdsPKs));
			matchQuery.add(PropertyFactoryUtil.forName("isNational").eq(
					new Boolean(isNational)));
			matchQuery.add(PropertyFactoryUtil.forName("matchQuery.esfMatchId")
					.in(classPKs));

			esfMatchs = ESFMatchLocalServiceUtil.dynamicQuery(matchQuery);

		} catch (Exception e) {

		}
		return esfMatchs;
	}

	public List<ESFMatch> findbyUserId_IsNational(long userId,
			boolean isNational) throws SystemException {
		List<ESFMatch> esfMatchs = null;
		esfMatchs = esfMatchPersistence.findByUserId_IsNat(userId, isNational);
		return esfMatchs;
	}
	
	public List<ESFMatch> findbyIsChangeCategory(boolean IsChangeCategory, long sportType)
			throws SystemException {

		List<ESFMatch> matchs = new ArrayList<ESFMatch>();
		List<ESFMatch> esfMatchs = null;

		esfMatchs = esfMatchPersistence. findByIsChangeCategory(IsChangeCategory);
			
		if(sportType != 0){
			
			for(ESFMatch esfMatch : esfMatchs){
				if( Long.valueOf(esfMatch.getEsfSportTypeId()).equals(Long.valueOf(sportType))){
					matchs.add(esfMatch);
				}
			}
			
		}else{
			matchs = esfMatchs;
		}
		return matchs;
	}
	

	public List<ESFMatch> findbyUserId_IsNational(long userId,
			boolean isNational, int start, int end) throws SystemException {
		List<ESFMatch> esfMatchs = null;
		esfMatchs = esfMatchPersistence.findByUserId_IsNat(userId, isNational,
				start, end);
		return esfMatchs;
	}

	public List<ESFMatch> findbyMatchType(long esfMatchTypeId)
			throws SystemException {

		List<ESFMatch> esfMatchs = null;
		esfMatchs = esfMatchPersistence.findByMatchTypeId(esfMatchTypeId);
		return esfMatchs;
	}
	



	public ESFMatch addOrUpdateESFMatch(long userId, long esfMatchId,
			long esfAssociationId, String code, Date startDate, Date endDate,
			String startHour, long description, String note, boolean isDraft,
			int numFields, long esfSportTypeId, int numDisk, int numDiskTeam,
			boolean isIndividualMatch, boolean isTeamMatch,
			boolean isJuniorMatch, long esfMatchTypeId, boolean isChangeCategoryMatch,
			long[] esfShooterCategoryIds, long[] esfShooterQualificationIds,
			long esfCountryId, String site, boolean isNational,
			ESFEntityState esfEntityState, ServiceContext serviceContext)
			throws SystemException, PortalException {

		User operator = userPersistence.findByPrimaryKey(userId);
		long groupId = serviceContext.getScopeGroupId();
		ESFMatch lastCodeMatch = null;
		Date now = new Date();
		int year = 0;
		int seq = 0;
		ESFMatch esfMatch = null;
		String lastCode = null;
		String newCode = null;
		if (esfMatchId == 0) {
			esfMatchId = counterLocalService.increment();
			esfMatch = esfMatchPersistence.create(esfMatchId);
		} else {
			esfMatch = ESFMatchLocalServiceUtil.fetchESFMatch(esfMatchId);
		}
		if (esfMatch != null) {
			if(code==null || code.trim().isEmpty()){
				//Genero il codice
				year = Calendar.getInstance().get(Calendar.YEAR);
				_log.debug("Verifico il codice dell'ultimo match dell'anno corrente: "+year);
				try {
					lastCodeMatch = this.esfMatchPersistence
							.findByMatchYear_Last(year, 
									OrderByComparatorFactoryUtil
									.create(ESFMatchModelImpl.TABLE_NAME, "matchYearSeq", true));
				} catch (NoSuchMatchException e) {
					lastCodeMatch = null;
					_log.debug("Nessun match per l'anno corrente trovato", e);
				}
				_log.debug("Calcolo il codice da assegnare al match rispetto al vecchio");
				
				if(lastCodeMatch!=null){
					//Se esiste un match di quest'anno
					seq = lastCodeMatch.getMatchYearSeq();
				}else{
					//Altrimenti creo un codice fittizio con anno e 4 zeri finali
					seq = 0;
				}
				lastCode = String.valueOf(year)
						.concat(GenericUtility.getZeroPaddedString(String.valueOf(seq), 4));
				seq++;
				_log.debug("Ultimo codice  dell'anno: "+lastCode);
				newCode = String.valueOf(year)
						.concat(GenericUtility.getZeroPaddedString(String.valueOf(seq), 4));
				_log.debug("Codice ricalcolato: "+newCode);
			}else{
				//Nel caso in cui arriva un codice allora è un update ed il codice non deve cambiare
				newCode = code;
				year = esfMatch.getMatchYear();
				seq = esfMatch.getMatchYearSeq();
			}
			esfMatch.setUserId(userId);
			esfMatch.setGroupId(groupId);
			esfMatch.setCompanyId(operator.getCompanyId());
			esfMatch.setUserName(operator.getFullName());
			esfMatch.setCreateDate(serviceContext.getCreateDate(now));
			esfMatch.setModifiedDate(serviceContext.getModifiedDate(now));
			esfMatch.setExpandoBridgeAttributes(serviceContext);
			esfMatch.setEsfAssociationId(esfAssociationId);
			esfMatch.setCode(newCode);
			esfMatch.setMatchYear(year);
			esfMatch.setMatchYearSeq(seq);
			esfMatch.setStartDate(startDate);
			esfMatch.setEndDate(endDate);
			esfMatch.setStartHour(startHour);
			esfMatch.setDescription(description);
			esfMatch.setNotes(note);
			esfMatch.setIsDraft(isDraft);
			esfMatch.setNumFields(numFields);
			esfMatch.setEsfSportTypeId(esfSportTypeId);
			esfMatch.setNumDisk(numDisk);
			esfMatch.setNumDiskTeam(numDiskTeam);
			esfMatch.setIsChangeCategoryMatch(isChangeCategoryMatch);
			esfMatch.setIsIndividualMatch(isIndividualMatch);
			esfMatch.setIsTeamMatch(isTeamMatch);
			esfMatch.setIsJuniorMatch(isJuniorMatch);
			esfMatch.setEsfMatchTypeId(esfMatchTypeId);
			esfMatch.setCountryId(esfCountryId);
			esfMatch.setSite(site);
			esfMatch.setIsNational(isNational);
			_log.debug("Salvataggio ESFMatch con codice: "+esfMatch.getCode());
			esfMatch = this.trySave(esfMatch, 0);
			_log.debug("Salvataggio ESFMatch con codice: "+esfMatch.getCode()+" - TERMINATO");
			_log.debug("Add ESFEntityState: "+esfMatch.getCode());
			ESFEntityStateLocalServiceUtil.addEntityState(
					serviceContext.getUserId(), ESFMatch.class.getName(),
					esfMatchId, esfEntityState.getEsfStateId(), serviceContext);
			_log.debug("Add ESFEntityState: "+esfMatch.getCode()+" - TERMINATO");
			
			if (esfShooterCategoryIds != null) {
				_log.debug("Operazioni su ESFShooterCategoryESFMatch: "+esfMatch.getCode());
				ESFShooterCategoryESFMatchLocalServiceUtil
						.deleteESFShooterCategoryByESFMatchId(esfMatchId);
				for (long esfShooterCategoryId : esfShooterCategoryIds) {

					ESFShooterCategoryESFMatchPK scmPK = new ESFShooterCategoryESFMatchPK(
							esfShooterCategoryId, esfMatchId);

					ESFShooterCategoryESFMatch scm = ESFShooterCategoryESFMatchLocalServiceUtil
							.createESFShooterCategoryESFMatch(scmPK);

					scm.setCompanyId(operator.getCompanyId());
					scm.setCreateDate(serviceContext.getCreateDate(now));
					scm.setModifiedDate(serviceContext.getModifiedDate(now));
					scm.setGroupId(groupId);
					scm.setUserId(userId);
					scm.setUserName(operator.getFullName());

					ESFShooterCategoryESFMatchLocalServiceUtil
							.updateESFShooterCategoryESFMatch(scm);
				}
			}

			if (esfShooterQualificationIds != null) {
				_log.debug("Operazioni su ESFShooterQualification: "+esfMatch.getCode());
				ESFShooterQualificationESFMatchLocalServiceUtil
						.deleteESFShooterQualificationESFMatchId(esfMatchId);

				for (long esfShooterQualificationId : esfShooterQualificationIds) {

					ESFShooterQualificationESFMatchPK sqmPK = new ESFShooterQualificationESFMatchPK(
							esfShooterQualificationId, esfMatchId);

					ESFShooterQualificationESFMatch sqm = ESFShooterQualificationESFMatchLocalServiceUtil
							.createESFShooterQualificationESFMatch(sqmPK);

					sqm.setCompanyId(operator.getCompanyId());
					sqm.setCreateDate(serviceContext.getCreateDate(now));
					sqm.setModifiedDate(serviceContext.getModifiedDate(now));
					sqm.setGroupId(groupId);
					sqm.setUserId(userId);
					sqm.setUserName(operator.getFullName());

					ESFShooterQualificationESFMatchLocalServiceUtil
							.updateESFShooterQualificationESFMatch(sqm);
				}
			}
			_log.debug("AssetEntry: "+esfMatch.getCode());
			/*	resourceLocalService.addResources(esfMatch.getCompanyId(), groupId,
					userId, ESFMatch.class.getName(), esfMatchId, false, true,
					true);*/

			AssetEntry assetEntry = assetEntryLocalService.updateEntry(userId,
					groupId, esfMatch.getCreateDate(),
					esfMatch.getModifiedDate(), ESFMatch.class.getName(),
					esfMatchId, esfMatch.getUuid(), 0,
					serviceContext.getAssetCategoryIds(),
					serviceContext.getAssetTagNames(), true, null, null, null,
					ContentTypes.TEXT_HTML, esfMatch.getStartHour(), null,
					null, null, null, 0, 0, null, false);

			assetLinkLocalService.updateLinks(userId, assetEntry.getEntryId(),
					serviceContext.getAssetLinkEntryIds(),
					AssetLinkConstants.TYPE_RELATED);
			_log.debug("Operazioni terminate: "+esfMatch.getCode());
		}
		return esfMatch;
	}
	
	private ESFMatch trySave(ESFMatch match, int tryCount) throws SystemException{
		ESFMatch result = null;
		int thisTryCount = tryCount +1;
		int nextSeq = match.getMatchYearSeq()+1;
		String nextCode = null;
		nextCode = String.valueOf(match.getMatchYear())
				.concat(GenericUtility.getZeroPaddedString(String.valueOf(nextSeq), 4));
		if(tryCount<10){	//Ritendo il salvataggio fino ad un massimo di 10 volte
			try {
				result = esfMatchPersistence.update(match);
			} catch (Exception e) {
				_log.error("Salvataggio fallito, "
						+ "tryCount: "+tryCount+" - "
						+ "Year: "+match.getMatchYear()+" - "
						+ "Seq: "+match.getMatchYearSeq(), e);
				//Aggiorno la sequence ed il codice e ritento il salvataggio
				match.setMatchYearSeq(nextSeq);
				match.setCode(nextCode);
				this.trySave(match, thisTryCount);
			}
		}else{
			//Dopo 10 tentativi annullo il salvataggio lanciando un eccezione
			throw new SystemException("Impossibile salvare il match");	
		}
		return result;
	}

	public ESFMatch addOrUpdateESFMatch(long userId, long esfMatchId,
		long esfAssociationId, String code, Date startDate, Date endDate,
		String startHour, long description, String note, boolean isDraft,
		int numFields, long esfSportTypeId, int numDisk, int numDiskTeam,
		boolean isIndividualMatch, boolean isTeamMatch,
		boolean isJuniorMatch, long esfMatchTypeId,  boolean isChangeCategoryMatch,
		long[] esfShooterCategoryIds, long[] esfShooterQualificationIds,
		long esfCountryId, String site, boolean isNational, boolean isOlimpicQualificationMatch,
		ESFEntityState esfEntityState, ServiceContext serviceContext, String 
		notNationalAssotiation, String eventType, String esfNationalSportTypeidString) throws SystemException, PortalException {

		User operator = userPersistence.findByPrimaryKey(userId);

	long groupId = serviceContext.getScopeGroupId();

	Date now = new Date();

	ESFMatch esfMatch = null;
	
	if (esfMatchId == 0) {
		esfMatchId = counterLocalService.increment();
		esfMatch = esfMatchPersistence.create(esfMatchId);

	} else {
		esfMatch = ESFMatchLocalServiceUtil.fetchESFMatch(esfMatchId);

	}
	
	if (esfMatch != null) {

		esfMatch.setIsOlimpicQualificationMatch(isOlimpicQualificationMatch);
		esfMatch.setNotNationalAssotiation(notNationalAssotiation);
		esfMatch.setUserId(userId);
		esfMatch.setGroupId(groupId);
		esfMatch.setCompanyId(operator.getCompanyId());
		esfMatch.setUserName(operator.getFullName());
		esfMatch.setCreateDate(serviceContext.getCreateDate(now));
		esfMatch.setModifiedDate(serviceContext.getModifiedDate(now));
		esfMatch.setExpandoBridgeAttributes(serviceContext);
		esfMatch.setEsfAssociationId(esfAssociationId);
		esfMatch.setCode(code);
		esfMatch.setStartDate(startDate);
		esfMatch.setEndDate(endDate);
		esfMatch.setStartHour(startHour);
		esfMatch.setDescription(description);
		esfMatch.setNotes(note);
		esfMatch.setIsDraft(isDraft);
		esfMatch.setNumFields(numFields);
		esfMatch.setEsfSportTypeId(esfSportTypeId);
		esfMatch.setNumDisk(numDisk);
		esfMatch.setNumDiskTeam(numDiskTeam);
		esfMatch.setIsChangeCategoryMatch(isChangeCategoryMatch);
		esfMatch.setIsIndividualMatch(isIndividualMatch);
		esfMatch.setIsTeamMatch(isTeamMatch);
		esfMatch.setIsJuniorMatch(isJuniorMatch);
		esfMatch.setEsfMatchTypeId(esfMatchTypeId);
		esfMatch.setCountryId(esfCountryId);
		esfMatch.setSite(site);
		esfMatch.setIsNational(isNational);
		esfMatch.setEventType(eventType);
		esfMatch.setEsfNationalSportTypeId(esfNationalSportTypeidString);
		// esfMatch.setIsFinal(isFinal);
		// esfMatch.setEsfTorunamentId(esfTorunamentId);

		esfMatch = esfMatchPersistence.update(esfMatch);

		ESFEntityStateLocalServiceUtil.addEntityState(
				serviceContext.getUserId(), ESFMatch.class.getName(),
				esfMatchId, esfEntityState.getEsfStateId(), serviceContext);

		if (esfShooterCategoryIds != null) {
			ESFShooterCategoryESFMatchLocalServiceUtil
					.deleteESFShooterCategoryByESFMatchId(esfMatchId);
			for (long esfShooterCategoryId : esfShooterCategoryIds) {

				ESFShooterCategoryESFMatchPK scmPK = new ESFShooterCategoryESFMatchPK(
						esfShooterCategoryId, esfMatchId);

				ESFShooterCategoryESFMatch scm = ESFShooterCategoryESFMatchLocalServiceUtil
						.createESFShooterCategoryESFMatch(scmPK);

				scm.setCompanyId(operator.getCompanyId());
				scm.setCreateDate(serviceContext.getCreateDate(now));
				scm.setModifiedDate(serviceContext.getModifiedDate(now));
				scm.setGroupId(groupId);
				scm.setUserId(userId);
				scm.setUserName(operator.getFullName());

				ESFShooterCategoryESFMatchLocalServiceUtil
						.updateESFShooterCategoryESFMatch(scm);
			}
		}

		if (esfShooterQualificationIds != null) {
			ESFShooterQualificationESFMatchLocalServiceUtil
					.deleteESFShooterQualificationESFMatchId(esfMatchId);

			for (long esfShooterQualificationId : esfShooterQualificationIds) {

				ESFShooterQualificationESFMatchPK sqmPK = new ESFShooterQualificationESFMatchPK(
						esfShooterQualificationId, esfMatchId);

				ESFShooterQualificationESFMatch sqm = ESFShooterQualificationESFMatchLocalServiceUtil
						.createESFShooterQualificationESFMatch(sqmPK);

				sqm.setCompanyId(operator.getCompanyId());
				sqm.setCreateDate(serviceContext.getCreateDate(now));
				sqm.setModifiedDate(serviceContext.getModifiedDate(now));
				sqm.setGroupId(groupId);
				sqm.setUserId(userId);
				sqm.setUserName(operator.getFullName());

				ESFShooterQualificationESFMatchLocalServiceUtil
						.updateESFShooterQualificationESFMatch(sqm);
			}
		}
		
		/*resourceLocalService.addResources(esfMatch.getCompanyId(), groupId,
				userId, ESFMatch.class.getName(), esfMatchId, false, true,
				true);*/
		
		AssetEntry assetEntry = assetEntryLocalService.updateEntry(userId,
				groupId, esfMatch.getCreateDate(),
				esfMatch.getModifiedDate(), ESFMatch.class.getName(),
				esfMatchId, esfMatch.getUuid(), 0,
				serviceContext.getAssetCategoryIds(),
				serviceContext.getAssetTagNames(), true, null, null, null,
				ContentTypes.TEXT_HTML, esfMatch.getStartHour(), null,
				null, null, null, 0, 0, null, false);

		assetLinkLocalService.updateLinks(userId, assetEntry.getEntryId(),
				serviceContext.getAssetLinkEntryIds(),
				AssetLinkConstants.TYPE_RELATED);

	}
	return esfMatch;
}

	
	/*
	 * 
	 *E' stato aggiunto un nuovo parametro(isOlimpicQualificationMatch) che riguarda solo i NationalMatch 
	 *
	 * */
	
	public ESFMatch addOrUpdateESFMatch(long userId, long esfMatchId,
		long esfAssociationId, String code, Date startDate, Date endDate,
		String startHour, long description, String note, boolean isDraft,
		int numFields, long esfSportTypeId, int numDisk, int numDiskTeam,
		boolean isIndividualMatch, boolean isTeamMatch,
		boolean isJuniorMatch, long esfMatchTypeId,  boolean isChangeCategoryMatch,
		long[] esfShooterCategoryIds, long[] esfShooterQualificationIds,
		long esfCountryId, String site, boolean isNational, 
		boolean isOlimpicQualificationMatch, ESFEntityState esfEntityState, 
		ServiceContext serviceContext)
		throws SystemException, PortalException {

	User operator = userPersistence.findByPrimaryKey(userId);

	long groupId = serviceContext.getScopeGroupId();

	Date now = new Date();

	ESFMatch esfMatch = null;
	if (esfMatchId == 0) {
		esfMatchId = counterLocalService.increment();
		esfMatch = esfMatchPersistence.create(esfMatchId);
	} else {
		esfMatch = ESFMatchLocalServiceUtil.fetchESFMatch(esfMatchId);
	}
	if (esfMatch != null) {
		esfMatch.setUserId(userId);
		esfMatch.setGroupId(groupId);
		esfMatch.setCompanyId(operator.getCompanyId());
		esfMatch.setUserName(operator.getFullName());
		esfMatch.setCreateDate(serviceContext.getCreateDate(now));
		esfMatch.setModifiedDate(serviceContext.getModifiedDate(now));
		esfMatch.setExpandoBridgeAttributes(serviceContext);
		esfMatch.setEsfAssociationId(esfAssociationId);
		esfMatch.setCode(code);
		esfMatch.setStartDate(startDate);
		esfMatch.setEndDate(endDate);
		esfMatch.setStartHour(startHour);
		esfMatch.setDescription(description);
		esfMatch.setNotes(note);
		esfMatch.setIsDraft(isDraft);
		esfMatch.setNumFields(numFields);
		esfMatch.setEsfSportTypeId(esfSportTypeId);
		esfMatch.setNumDisk(numDisk);
		esfMatch.setNumDiskTeam(numDiskTeam);
		esfMatch.setIsChangeCategoryMatch(isChangeCategoryMatch);
		esfMatch.setIsIndividualMatch(isIndividualMatch);
		esfMatch.setIsTeamMatch(isTeamMatch);
		esfMatch.setIsJuniorMatch(isJuniorMatch);
		esfMatch.setEsfMatchTypeId(esfMatchTypeId);
		esfMatch.setCountryId(esfCountryId);
		esfMatch.setSite(site);
		esfMatch.setIsNational(isNational);
		// esfMatch.setIsFinal(isFinal);
		// esfMatch.setEsfTorunamentId(esfTorunamentId);
		esfMatch.setIsOlimpicQualificationMatch(isOlimpicQualificationMatch);
		
		esfMatch = esfMatchPersistence.update(esfMatch);

		ESFEntityStateLocalServiceUtil.addEntityState(
				serviceContext.getUserId(), ESFMatch.class.getName(),
				esfMatchId, esfEntityState.getEsfStateId(), serviceContext);

		if (esfShooterCategoryIds != null) {
			ESFShooterCategoryESFMatchLocalServiceUtil
					.deleteESFShooterCategoryByESFMatchId(esfMatchId);
			for (long esfShooterCategoryId : esfShooterCategoryIds) {

				ESFShooterCategoryESFMatchPK scmPK = new ESFShooterCategoryESFMatchPK(
						esfShooterCategoryId, esfMatchId);

				ESFShooterCategoryESFMatch scm = ESFShooterCategoryESFMatchLocalServiceUtil
						.createESFShooterCategoryESFMatch(scmPK);

				scm.setCompanyId(operator.getCompanyId());
				scm.setCreateDate(serviceContext.getCreateDate(now));
				scm.setModifiedDate(serviceContext.getModifiedDate(now));
				scm.setGroupId(groupId);
				scm.setUserId(userId);
				scm.setUserName(operator.getFullName());

				ESFShooterCategoryESFMatchLocalServiceUtil
						.updateESFShooterCategoryESFMatch(scm);
			}
		}

		if (esfShooterQualificationIds != null) {
			ESFShooterQualificationESFMatchLocalServiceUtil
					.deleteESFShooterQualificationESFMatchId(esfMatchId);

			for (long esfShooterQualificationId : esfShooterQualificationIds) {

				ESFShooterQualificationESFMatchPK sqmPK = new ESFShooterQualificationESFMatchPK(
						esfShooterQualificationId, esfMatchId);

				ESFShooterQualificationESFMatch sqm = ESFShooterQualificationESFMatchLocalServiceUtil
						.createESFShooterQualificationESFMatch(sqmPK);

				sqm.setCompanyId(operator.getCompanyId());
				sqm.setCreateDate(serviceContext.getCreateDate(now));
				sqm.setModifiedDate(serviceContext.getModifiedDate(now));
				sqm.setGroupId(groupId);
				sqm.setUserId(userId);
				sqm.setUserName(operator.getFullName());

				ESFShooterQualificationESFMatchLocalServiceUtil
						.updateESFShooterQualificationESFMatch(sqm);
			}
		}

		resourceLocalService.addResources(esfMatch.getCompanyId(), groupId,
				userId, ESFMatch.class.getName(), esfMatchId, false, true,
				true);

		AssetEntry assetEntry = assetEntryLocalService.updateEntry(userId,
				groupId, esfMatch.getCreateDate(),
				esfMatch.getModifiedDate(), ESFMatch.class.getName(),
				esfMatchId, esfMatch.getUuid(), 0,
				serviceContext.getAssetCategoryIds(),
				serviceContext.getAssetTagNames(), true, null, null, null,
				ContentTypes.TEXT_HTML, esfMatch.getStartHour(), null,
				null, null, null, 0, 0, null, false);

		assetLinkLocalService.updateLinks(userId, assetEntry.getEntryId(),
				serviceContext.getAssetLinkEntryIds(),
				AssetLinkConstants.TYPE_RELATED);

	}
	return esfMatch;
}

	public ESFMatch deleteESFMatch(long esfMatchId,
			ServiceContext serviceContext) throws PortalException,
			SystemException {

		ESFMatch esfMatch = getESFMatch(esfMatchId);

		resourceLocalService.deleteResource(serviceContext.getCompanyId(),
				ESFMatch.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL,
				esfMatchId);

		esfMatch = deleteESFMatch(esfMatch);

		return esfMatch;
	}


	@Override
	public List<ESFMatch> findbyeventType(String eventType)
			throws SystemException {
		List<ESFMatch> esfMatchs = null;
		esfMatchs = esfMatchPersistence.findByEventType(eventType);
		return esfMatchs;
	}
	
	
	public List<ESFMatch> findByDescription(long description)
			throws SystemException{
		return esfMatchPersistence.findByDescription(description);
	}
	
	public List<ESFMatch> findDelegationActiveMatch(long esfUserId)
			throws SystemException{
		return ESFMatchFinderUtil.findDelegationActiveMatch(esfUserId);
	}
	
	public List<ESFMatch> findUnfinishedMatch_UserId(long esfUserId)
			throws SystemException{
		
		List<ESFMatch> matchs = new ArrayList<ESFMatch>();
		List<ESFNationalDelegation> delegations = new ArrayList<ESFNationalDelegation>();
		ESFMatch match = new ESFMatchImpl();
		
		Date now = new Date();
		Date matchDate = new Date();
		
		delegations = ESFNationalDelegationLocalServiceUtil.getPartecipantType_EsfUserId(esfUserId);
		for(ESFNationalDelegation del : delegations){
			match = ESFMatchLocalServiceUtil.fetchESFMatch(del.getEsfMatchId());
			matchDate = match.getEndDate();
			if(matchDate.compareTo(now)>0){
				matchs.add(match);
			}
		}
		
		return matchs;
	}
	
	public List<ESFMatch> getAllEsfMatchByResults(List<ESFNationalMatchResult> results) throws SystemException{
		List <ESFMatch> matches = new ArrayList<ESFMatch>();
		long [] idM = new long [results.size()];
		int i=0;
		for (ESFNationalMatchResult res : results){
			idM[i]=res.getEsfMatchId();
			i++;
		}
		try {
		DynamicQuery matchQuery = DynamicQueryFactoryUtil.forClass(
				ESFMatch.class, "matchQuery",
				PortletClassLoaderUtil.getClassLoader());
		
		
		
		matchQuery.add(PropertyFactoryUtil.forName(
				"matchQuery.esfMatchId").in(idM));
		
		matchQuery.addOrder(OrderFactoryUtil.desc("matchQuery.startDate"));

		matches = ESFMatchLocalServiceUtil.dynamicQuery(matchQuery);
		}
		catch (Exception e){
			
		}
		
		return matches;
	}
	public ESFMatch addOrUpdateOldESFMatch(long userId, long esfMatchId,
		long esfAssociationId, String code, Date startDate, Date endDate,
		String startHour, long description, String note, boolean isDraft,
		int numFields, long esfSportTypeId, int numDisk, int numDiskTeam,
		boolean isIndividualMatch, boolean isTeamMatch,
		boolean isJuniorMatch, long esfMatchTypeId, boolean isChangeCategoryMatch,
		long[] esfShooterCategoryIds, long[] esfShooterQualificationIds,
		long esfCountryId, String site, boolean isNational,
		ESFEntityState esfEntityState, ServiceContext serviceContext,String oldCode)
		throws SystemException, PortalException {

	User operator = userPersistence.findByPrimaryKey(userId);

	long groupId = serviceContext.getScopeGroupId();

	Date now = new Date();

	ESFMatch esfMatch = null;
	if (esfMatchId == 0) {
		esfMatchId = counterLocalService.increment();
		esfMatch = esfMatchPersistence.create(esfMatchId);
	} else {
		esfMatch = ESFMatchLocalServiceUtil.fetchESFMatch(esfMatchId);
	}
	if (esfMatch != null) {
		esfMatch.setUserId(userId);
		esfMatch.setGroupId(groupId);
		esfMatch.setOldCode(oldCode);
		esfMatch.setCompanyId(operator.getCompanyId());
		esfMatch.setUserName(operator.getFullName());
		esfMatch.setCreateDate(serviceContext.getCreateDate(now));
		esfMatch.setModifiedDate(serviceContext.getModifiedDate(now));
		esfMatch.setExpandoBridgeAttributes(serviceContext);
		esfMatch.setEsfAssociationId(esfAssociationId);
		esfMatch.setCode(code);
		esfMatch.setStartDate(startDate);
		esfMatch.setEndDate(endDate);
		esfMatch.setStartHour(startHour);
		esfMatch.setDescription(description);
		esfMatch.setNotes(note);
		esfMatch.setIsDraft(isDraft);
		esfMatch.setNumFields(numFields);
		esfMatch.setEsfSportTypeId(esfSportTypeId);
		esfMatch.setNumDisk(numDisk);
		esfMatch.setNumDiskTeam(numDiskTeam);
		esfMatch.setIsChangeCategoryMatch(isChangeCategoryMatch);
		esfMatch.setIsIndividualMatch(isIndividualMatch);
		esfMatch.setIsTeamMatch(isTeamMatch);
		esfMatch.setIsJuniorMatch(isJuniorMatch);
		esfMatch.setEsfMatchTypeId(esfMatchTypeId);
		esfMatch.setCountryId(esfCountryId);
		esfMatch.setSite(site);
		esfMatch.setIsNational(isNational);

		esfMatch = esfMatchPersistence.update(esfMatch);

		ESFEntityStateLocalServiceUtil.addEntityState(
				serviceContext.getUserId(), ESFMatch.class.getName(),
				esfMatchId, esfEntityState.getEsfStateId(), serviceContext);

		if (esfShooterCategoryIds != null) {
			ESFShooterCategoryESFMatchLocalServiceUtil
					.deleteESFShooterCategoryByESFMatchId(esfMatchId);
			for (long esfShooterCategoryId : esfShooterCategoryIds) {

				ESFShooterCategoryESFMatchPK scmPK = new ESFShooterCategoryESFMatchPK(
						esfShooterCategoryId, esfMatchId);

				ESFShooterCategoryESFMatch scm = ESFShooterCategoryESFMatchLocalServiceUtil
						.createESFShooterCategoryESFMatch(scmPK);

				scm.setCompanyId(operator.getCompanyId());
				scm.setCreateDate(serviceContext.getCreateDate(now));
				scm.setModifiedDate(serviceContext.getModifiedDate(now));
				scm.setGroupId(groupId);
				scm.setUserId(userId);
				scm.setUserName(operator.getFullName());

				ESFShooterCategoryESFMatchLocalServiceUtil
						.updateESFShooterCategoryESFMatch(scm);
			}
		}

		if (esfShooterQualificationIds != null) {
			ESFShooterQualificationESFMatchLocalServiceUtil
					.deleteESFShooterQualificationESFMatchId(esfMatchId);

			for (long esfShooterQualificationId : esfShooterQualificationIds) {

				ESFShooterQualificationESFMatchPK sqmPK = new ESFShooterQualificationESFMatchPK(
						esfShooterQualificationId, esfMatchId);

				ESFShooterQualificationESFMatch sqm = ESFShooterQualificationESFMatchLocalServiceUtil
						.createESFShooterQualificationESFMatch(sqmPK);

				sqm.setCompanyId(operator.getCompanyId());
				sqm.setCreateDate(serviceContext.getCreateDate(now));
				sqm.setModifiedDate(serviceContext.getModifiedDate(now));
				sqm.setGroupId(groupId);
				sqm.setUserId(userId);
				sqm.setUserName(operator.getFullName());

				ESFShooterQualificationESFMatchLocalServiceUtil
						.updateESFShooterQualificationESFMatch(sqm);
			}
		}

		/*	resourceLocalService.addResources(esfMatch.getCompanyId(), groupId,
				userId, ESFMatch.class.getName(), esfMatchId, false, true,
				true);*/

		AssetEntry assetEntry = assetEntryLocalService.updateEntry(userId,
				groupId, esfMatch.getCreateDate(),
				esfMatch.getModifiedDate(), ESFMatch.class.getName(),
				esfMatchId, esfMatch.getUuid(), 0,
				serviceContext.getAssetCategoryIds(),
				serviceContext.getAssetTagNames(), true, null, null, null,
				ContentTypes.TEXT_HTML, esfMatch.getStartHour(), null,
				null, null, null, 0, 0, null, false);

		assetLinkLocalService.updateLinks(userId, assetEntry.getEntryId(),
				serviceContext.getAssetLinkEntryIds(),
				AssetLinkConstants.TYPE_RELATED);

	}
	return esfMatch;

}
	
	/*
	 * 
	 * metodo per ricerca dei match da disputare con data di inizio oltre la data attuale e diverisficazione tra match normale o nazionale
	 */
	
	public List<ESFMatch> findMatchToDispute(String code, boolean isnational, int start, int end)throws SystemException{
		
		List<ESFMatch> match = new ArrayList<ESFMatch>();
		Date now = new Date();
		
		match = esfMatchPersistence.findByDate_Code(now, isnational, "%"+code+"%", start, end);
		
		return match;
	}
	
	public int countMatchToDispute(String code, boolean isnational)throws SystemException{
		
		int tot = 0;
		List<ESFMatch> match = new ArrayList<ESFMatch>();
		Date now = new Date();
		
		match = esfMatchPersistence.findByDate_Code(now, isnational, "%"+code+"%");
		tot = match.size();
		return tot;
	}


}
