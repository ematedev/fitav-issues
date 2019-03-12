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
import java.util.Date;
import java.util.Hashtable;
import java.util.List;

import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.model.AssetLinkConstants;

import it.ethica.esf.ESFCardCodeException;
import it.ethica.esf.migration.util.ManageDate;
import it.ethica.esf.model.ESFCard;
import it.ethica.esf.model.ESFConfiguration;
import it.ethica.esf.model.ESFEntityState;
import it.ethica.esf.model.ESFOrganization;
import it.ethica.esf.model.impl.ESFCardImpl;
import it.ethica.esf.model.impl.ESFConfigurationImpl;
import it.ethica.esf.model.impl.ESFEntityStateImpl;
import it.ethica.esf.service.ESFCardLocalServiceUtil;
import it.ethica.esf.service.ESFConfigurationLocalServiceUtil;
import it.ethica.esf.service.ESFEntityStateLocalServiceUtil;
import it.ethica.esf.service.ESFOrganizationLocalServiceUtil;
import it.ethica.esf.service.base.ESFCardLocalServiceBaseImpl;
import it.ethica.esf.service.persistence.ESFCardFinderUtil;
import it.ethica.esf.util.ESFKeys;

/**
 * The implementation of the e s f card local service.
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link it.ethica.esf.service.ESFCardLocalService} interface.
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 * 
 * @author Ethica
 * @see it.ethica.esf.service.base.ESFCardLocalServiceBaseImpl
 * @see it.ethica.esf.service.ESFCardLocalServiceUtil
 */
public class ESFCardLocalServiceImpl extends ESFCardLocalServiceBaseImpl {

	private static Log _log = LogFactoryUtil
			.getLog(ESFCardLocalServiceImpl.class);

	public ESFCard getEsfCardByEsfUserId(long esfUserId)
			throws PortalException, SystemException {
		return esfCardPersistence.findByUserId(esfUserId).get(0);

	}

	@Override
	public ESFCard addESFCard(long userId, String code, String codeAlfa,
			long codeNum, ESFEntityState esfEntityState, long esfUserId,
			long esfOrganizationId, ServiceContext serviceContext)
			throws PortalException, SystemException {

		User operator = userPersistence.findByPrimaryKey(userId);

		long groupId = serviceContext.getScopeGroupId();

		Date now = new Date();

		validateESFCardCode(code);

		long esfCardId = counterLocalService.increment();

		ESFCard esfCard = esfCardPersistence.create(esfCardId);

		esfCard.setUuid(serviceContext.getUuid());
		esfCard.setUserId(userId);
		esfCard.setGroupId(groupId);
		esfCard.setCompanyId(operator.getCompanyId());
		esfCard.setUserName(operator.getFullName());
		esfCard.setCreateDate(serviceContext.getCreateDate(now));
		esfCard.setModifiedDate(serviceContext.getModifiedDate(now));
		esfCard.setExpandoBridgeAttributes(serviceContext);

		esfCard.setCodeAlfa(codeAlfa);
		esfCard.setCodeNum(codeNum);
		esfCard.setCode(code);
		esfCard.setEsfUserId(esfUserId);
		esfCard.setEsfOrganizationId(esfOrganizationId);
		esfCardPersistence.update(esfCard);

		ESFEntityStateLocalServiceUtil.addEntityState(
				serviceContext.getUserId(), ESFCard.class.getName(), esfCardId,
				esfEntityState.getEsfStateId(), serviceContext);

		try {
			resourceLocalService.addResources(esfCard.getCompanyId(), groupId,
					userId, ESFCard.class.getName(), esfCardId, false, true,
					true);

			AssetEntry assetEntry = assetEntryLocalService.updateEntry(userId,
					groupId, esfCard.getCreateDate(),
					esfCard.getModifiedDate(), ESFCard.class.getName(),
					esfCardId, esfCard.getUuid(), 0,
					serviceContext.getAssetCategoryIds(),
					serviceContext.getAssetTagNames(), true, null, null, null,
					ContentTypes.TEXT_HTML, esfCard.getCode(), null, null,
					null, null, 0, 0, null, false);

			assetLinkLocalService.updateLinks(userId, assetEntry.getEntryId(),
					serviceContext.getAssetLinkEntryIds(),
					AssetLinkConstants.TYPE_RELATED);

			Indexer indexer = IndexerRegistryUtil
					.nullSafeGetIndexer(ESFCard.class);

			indexer.reindex(esfCard);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return esfCard;
	}

	/*
	 * creo un numero arbitrale di tessere con parte numerica e alfabetica vuote
	 */
	public int createMultiESFCard(long userId, int numCards,
			ServiceContext serviceContext) throws PortalException,
			SystemException {

		int create = 0;
		long groupId = serviceContext.getScopeGroupId();
		Group group = GroupLocalServiceUtil.getGroup(groupId);
		User operator = userPersistence.findByPrimaryKey(userId);
		Date now = new Date();
		List<ESFCard> cards = new ArrayList<ESFCard>();
		ESFCard maxCard = new ESFCardImpl();
		int maxNum = 0;
		int newMaxNum = 0;
		long maxCodeEnum = 0;
		long minCodeEnum = 0;
		String maxCodeEnumString = "";
		String minCodeEnumString = "";
		String maxNumString = "";
		String maxAlfa = "";
		String codeAlfa = "";
		long codeNum = 0;
		List<ESFConfiguration> conf = new ArrayList<ESFConfiguration>();
		ESFConfiguration confMaxalfa = new ESFConfigurationImpl();
		ESFConfiguration confMaxNum = new ESFConfigurationImpl();
		Character[] charters = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
				'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'Z' };
		char first = ' ';
		char second = ' ';
		

		long esfStateId = ESFKeys.ESFStateType.ENABLE;
		ESFEntityState esfEntityState = new ESFEntityStateImpl();
		esfEntityState.setEsfStateId(esfStateId);
		
		create = ESFCardLocalServiceUtil.findAllESFCardsByState(
				ESFKeys.ESFStateType.ENABLE).size();
	
		conf = ESFConfigurationLocalServiceUtil
				.findESFConfigurationTypeByKey(ESFKeys.EsfConfigurationKey.MAXCODENUM_Card);
		maxCodeEnum = Long.parseLong(conf.get(0).getValue());

		maxCodeEnumString = String.valueOf(maxCodeEnum);
		
		conf = ESFConfigurationLocalServiceUtil
				.findESFConfigurationTypeByKey(ESFKeys.EsfConfigurationKey.MINCODENUM_Card);
		minCodeEnum = Long.parseLong(conf.get(0).getValue());
		minCodeEnumString = String.valueOf(minCodeEnum);

		conf = ESFConfigurationLocalServiceUtil
				.findESFConfigurationTypeByKey(ESFKeys.EsfConfigurationKey.maxAlfa);
		
		confMaxalfa =conf.get(0);
		maxAlfa = confMaxalfa.getValue().toUpperCase();
		conf = ESFConfigurationLocalServiceUtil
				.findESFConfigurationTypeByKey(ESFKeys.EsfConfigurationKey.maxNum);
		
		confMaxNum = conf.get(0);
		
		maxNumString = confMaxNum.getValue();
		maxNum = Integer.valueOf(maxNumString);
		newMaxNum = maxNum;

		for (int i = 0; i < numCards; i++) {

			if (newMaxNum < maxCodeEnum) {
				codeNum = newMaxNum + 1;
				codeAlfa = maxAlfa;

				String code = buildCode(codeAlfa, codeNum);

				long esfCardId = counterLocalService.increment();

				ESFCard esfCard = esfCardPersistence.create(esfCardId);
				esfCard.setUuid(serviceContext.getUuid());
				esfCard.setUserId(userId);
				esfCard.setGroupId(groupId);
				esfCard.setCompanyId(operator.getCompanyId());
				esfCard.setUserName(operator.getFullName());
				esfCard.setCreateDate(serviceContext.getCreateDate(now));
				esfCard.setModifiedDate(serviceContext.getModifiedDate(now));
				esfCard.setCodeAlfa(codeAlfa);
				esfCard.setCodeNum(codeNum);
				esfCard.setCode(code);

				esfCardPersistence.update(esfCard);

				ESFEntityStateLocalServiceUtil.addEntityState(
						serviceContext.getUserId(), ESFCard.class.getName(),
						esfCardId, esfEntityState.getEsfStateId(),
						serviceContext);

				newMaxNum = (int) codeNum;
			} else {
				if ("ZZ".equalsIgnoreCase(maxAlfa)) {
					
					List<ESFConfiguration> configurationL = new ArrayList<ESFConfiguration>();
					configurationL =  ESFConfigurationLocalServiceUtil
							.findESFConfigurationTypeByKey(ESFKeys.EsfConfigurationKey.MAXCODENUM_Card);

					ESFConfiguration configuration = configurationL.get(0);
					
					maxCodeEnumString = maxCodeEnumString + "9";
					configuration.setValue(maxCodeEnumString);
					ESFConfigurationLocalServiceUtil
							.updateESFConfiguration(configuration);

					maxCodeEnum = Long.valueOf(maxCodeEnumString);

					List<ESFConfiguration> configurationLMinC = new ArrayList<ESFConfiguration>();
					ESFConfiguration configurationMinc = new ESFConfigurationImpl();
					configurationLMinC =  ESFConfigurationLocalServiceUtil
							.findESFConfigurationTypeByKey(ESFKeys.EsfConfigurationKey.MINCODENUM_Card);
					configurationMinc = configurationLMinC.get(0);
					minCodeEnumString = minCodeEnumString + "0";
					configurationMinc.setValue(minCodeEnumString);
					ESFConfigurationLocalServiceUtil
							.updateESFConfiguration(configurationMinc);

					minCodeEnum = Long.valueOf(minCodeEnumString);

					codeNum = minCodeEnum;
					codeAlfa = "AA";
					maxAlfa = "AA";

					String code = buildCode(codeAlfa, codeNum);

					long esfCardId = counterLocalService.increment();

					ESFCard esfCard = esfCardPersistence.create(esfCardId);
					esfCard.setUuid(serviceContext.getUuid());
					esfCard.setUserId(userId);
					esfCard.setGroupId(groupId);
					esfCard.setCompanyId(operator.getCompanyId());
					esfCard.setUserName(operator.getFullName());
					esfCard.setCreateDate(serviceContext.getCreateDate(now));
					esfCard.setModifiedDate(serviceContext.getModifiedDate(now));
					esfCard.setCodeAlfa(codeAlfa);
					esfCard.setCodeNum(codeNum);
					esfCard.setCode(code);
					esfCardPersistence.update(esfCard);

					ESFEntityStateLocalServiceUtil.addEntityState(
							serviceContext.getUserId(),
							ESFCard.class.getName(), esfCardId,
							esfEntityState.getEsfStateId(), serviceContext);

					newMaxNum = (int) codeNum;

				} else {

					first = maxAlfa.charAt(0);
					second = maxAlfa.charAt(1);

					if ('Z'==(second)) {

						for (int a = 0; a < charters.length; a++) {

							if (charters[a]==(first)) {
								maxAlfa = (charters[a + 1]) + "A";
								break;
							}
						}

						codeAlfa = maxAlfa;
						codeNum = minCodeEnum;

						String code = buildCode(codeAlfa, codeNum);

						long esfCardId = counterLocalService.increment();

						ESFCard esfCard = esfCardPersistence.create(esfCardId);
						esfCard.setUuid(serviceContext.getUuid());
						esfCard.setUserId(userId);
						esfCard.setGroupId(groupId);
						esfCard.setCompanyId(operator.getCompanyId());
						esfCard.setUserName(operator.getFullName());
						esfCard.setCreateDate(serviceContext.getCreateDate(now));
						esfCard.setModifiedDate(serviceContext
								.getModifiedDate(now));
						esfCard.setCodeAlfa(codeAlfa);
						esfCard.setCodeNum(codeNum);
						esfCard.setCode(code);
						esfCardPersistence.update(esfCard);

						ESFEntityStateLocalServiceUtil.addEntityState(
								serviceContext.getUserId(),
								ESFCard.class.getName(), esfCardId,
								esfEntityState.getEsfStateId(), serviceContext);

						newMaxNum = (int) codeNum;
						
					} else {
						first = maxAlfa.charAt(0);
						second = maxAlfa.charAt(1);

						for (int a = 0; a < charters.length; a++) {

							if (charters[a]==(second)) {
								maxAlfa = first + (charters[a + 1]).toString();
								break;
							}
						}

						codeAlfa = maxAlfa;
						codeNum = minCodeEnum;

						String code = buildCode(codeAlfa, codeNum);

						long esfCardId = counterLocalService.increment();

						ESFCard esfCard = esfCardPersistence.create(esfCardId);
						esfCard.setUuid(serviceContext.getUuid());
						esfCard.setUserId(userId);
						esfCard.setGroupId(groupId);
						esfCard.setCompanyId(operator.getCompanyId());
						esfCard.setUserName(operator.getFullName());
						esfCard.setCreateDate(serviceContext.getCreateDate(now));
						esfCard.setModifiedDate(serviceContext
								.getModifiedDate(now));
						esfCard.setCodeAlfa(codeAlfa);
						esfCard.setCodeNum(codeNum);
						esfCard.setCode(code);
						esfCardPersistence.update(esfCard);

						ESFEntityStateLocalServiceUtil.addEntityState(
								serviceContext.getUserId(),
								ESFCard.class.getName(), esfCardId,
								esfEntityState.getEsfStateId(), serviceContext);

						newMaxNum = (int) codeNum;
					}

				}

			}

			
			confMaxalfa.setValue(maxAlfa);
			ESFConfigurationLocalServiceUtil.updateESFConfiguration(confMaxalfa);
			confMaxNum.setValue(String.valueOf(newMaxNum) );
			ESFConfigurationLocalServiceUtil.updateESFConfiguration(confMaxNum);
			create = create++;
		}

		return create;

	}

	/*
	 * creo tessere con parte alfabetica assegnata e con codice 
	 * numerico di inizio e fine assegnato, e associo tali tessere alla societ� selezionata
	 * 
	 */
	
	public int addSelectedCard(long organizationId, int begin, int end, String alfa,
			 long esfUserId , ServiceContext serviceContext)
			throws PortalException, SystemException {
		
		long esfStateId = ESFKeys.ESFStateType.ENABLE;
		ESFEntityState esfEntityState = new ESFEntityStateImpl();
		esfEntityState.setEsfStateId(esfStateId);
		long groupId = serviceContext.getScopeGroupId();
		Group group = GroupLocalServiceUtil.getGroup(groupId);
		User operator = userPersistence.findByPrimaryKey(esfUserId);
		Date now = new Date();
		int i = 0;
		int maxOrgCard = 0;
		
		List<ESFCard> orgCards = ESFCardFinderUtil.findCardsByOrgId(organizationId);
		maxOrgCard = (int) orgCards.get(0).getCodeNum();
		
		for(int k = 1; k < orgCards.size() ; k++){
			if((int) orgCards.get(k).getCodeNum() > maxOrgCard){
				maxOrgCard = (int)  orgCards.get(k).getCodeNum();
			}
		}

		if(begin <= maxOrgCard){
			begin = maxOrgCard+1;
		}

		if(begin > end){
			return 0;
		}
		
		
		for( i = begin ; i <= end ; i++){
			
			String code = buildCode(alfa, i);
			
			long esfCardId = counterLocalService.increment();
			
			ESFCard esfCard = esfCardPersistence.create(esfCardId);
			esfCard.setUuid(serviceContext.getUuid());
			esfCard.setUserId(esfUserId);
			esfCard.setGroupId(groupId);
			esfCard.setCompanyId(operator.getCompanyId());
			esfCard.setUserName(operator.getFullName());
			esfCard.setCreateDate(serviceContext.getCreateDate(now));
			esfCard.setModifiedDate(serviceContext
					.getModifiedDate(now));
			esfCard.setCodeAlfa(alfa);
			esfCard.setCodeNum(i);
			esfCard.setCode(code);
			esfCard.setEsfOrganizationId(organizationId);
			esfCardPersistence.update(esfCard);

			ESFEntityStateLocalServiceUtil.addEntityState(
					serviceContext.getUserId(),
					ESFCard.class.getName(), esfCardId,
					esfEntityState.getEsfStateId(), serviceContext);
			
			
		}
		return i;
	}
	
	
	/*
	 * ricerca di tutte le tessere associate alla societ� figlie della societ�
	 * attuale
	 */

	public int findAllESFCardsChildOrg(long organizationId)
			throws PortalException, SystemException {

		List<ESFCard> esfCardsTot = new ArrayList<ESFCard>();

		esfCardsTot = ESFCardFinderUtil.findCardByOrganizationId(organizationId);
		
		return esfCardsTot.size();
	}

	public int findAllESFCardsReg_Prov(long organizationId)
			throws PortalException, SystemException {

			List<ESFCard> esfCardsTot = new ArrayList<ESFCard>();
		esfCardsTot = ESFCardFinderUtil.findCardByOrganizationIdFree(organizationId);
	
		return esfCardsTot.size();
	}
	
	public List<ESFCard> findAllESFCardsReg_ProvFree(long organizationId)
			throws PortalException, SystemException {

		List<ESFCard> esfCardsTot = new ArrayList<ESFCard>();
		esfCardsTot = ESFCardFinderUtil.findCardByOrganizationIdFree(organizationId);

		return esfCardsTot;
	}
	
/*
 * ricerca le tessere attive ma non associate a regioni province o associazioni e restituisce la quantit�
 * (non-Javadoc)
 * @see it.ethica.esf.service.ESFCardLocalService#addMultiESFCard(long, java.lang.String, long, it.ethica.esf.model.ESFEntityState, long, long, com.liferay.portal.service.ServiceContext)
 */
	public List<ESFCard> getAllFreeCard() {
		
	
		List<ESFCard> cards = new ArrayList<ESFCard>();
		cards = ESFCardFinderUtil.getFreeCards();
		
		return cards;
	}
	
	/*
	 * 
	 * ricerca le tessere attive ma non associate a regioni province o associazioni e restituisce le tessere
	 * (non-Javadoc)
	 * @see it.ethica.esf.service.ESFCardLocalService#findAllFreeCard()
	 */
	
	
	public int findAllFreeCardInt() {
		int tot = 0;
		List<ESFCard> cards = new ArrayList<ESFCard>();
		cards = ESFCardFinderUtil.findFreeCardsInt();
		tot = cards.size();
		return tot;
	}
	
	
	/*
	 * 
	 * ricerca le tessere attive ma non associate a regioni province o associazioni e restituisce le tessere
	 * (non-Javadoc)
	 * @see it.ethica.esf.service.ESFCardLocalService#findAllFreeCard()
	 */
	
	
	public List<ESFCard> findAllFreeCards(int start, int end) {
		List<ESFCard> cards = new ArrayList<ESFCard>();
		cards = ESFCardFinderUtil.findFreeCards(start,
			    end);
		return cards;
	}
	
	
	public long addMultiESFCard(long userId, String codeAlfa, long numCards,
			ESFEntityState esfEntityState, long esfUserId,
			long esfOrganizationId, ServiceContext serviceContext)
			throws PortalException, SystemException {

		long starter = starterNumCard(codeAlfa);

		long inserted = 0;

		for (long codeNum = starter + 1; (codeNum <= starter + numCards && codeNum <= ESFKeys.ESFCard.MAXCODENUM); codeNum++) {
			String code = buildCode(codeAlfa, codeNum);

			addESFCard(userId, code, codeAlfa, codeNum, esfEntityState,
					esfUserId, esfOrganizationId, serviceContext);

			inserted++;
		}
		return inserted;

	}

	@Override
	public ESFCard deleteESFCard(long resourcePrimKey,
			ServiceContext serviceContext) throws PortalException,
			SystemException {

		ESFCard esfCard = getESFCard(resourcePrimKey);

		resourceLocalService.deleteResource(serviceContext.getCompanyId(),
				ESFCard.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL,
				resourcePrimKey);

		AssetEntry assetEntry = assetEntryLocalService.fetchEntry(
				ESFCard.class.getName(), resourcePrimKey);

		assetLinkLocalService.deleteLinks(assetEntry.getEntryId());

		assetEntryLocalService.deleteEntry(assetEntry);

		Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(ESFCard.class);

		indexer.delete(esfCard);

		esfCard = deleteESFCard(resourcePrimKey);

		return esfCard;
	}

	@Override
	public void deleteESFCard(long[] resourcePrimKeys,
			ServiceContext serviceContext) throws PortalException,
			SystemException {

		for (long resourcePrimKey : resourcePrimKeys) {
			deleteESFCard(resourcePrimKey, serviceContext);
		}
	}

	/**
	 * Effettua l'update dell'entit� ESFCard. Nel caso in cui viene fatto il
	 * cambio di stato della card, viene aggiornata la tabella corrispondente.
	 * Da notare che se isNotChangeState = true viene baipassato il controllo
	 * sulla scelta di uno stato differente a quello gi� assegnato
	 * all'entit�. Questo perch� delle volte bisogna creare un riferimento
	 * nella tabella degli stati mantenendo lo stato preesistente (per lo
	 * storico)
	 * 
	 * @param userId
	 * @param resourcePrimKey
	 * @param code
	 * @param esfUserId
	 * @param esfOrganizationId
	 * @param esfEntityState
	 * @param isNotChangeState
	 * @param serviceContext
	 * @return ESFCard
	 * @throws PortalException
	 * @throws SystemException
	 */
	public ESFCard updateESFCard(long userId, long resourcePrimKey,
			String code, String codeAlfa, long codeNum, long esfUserId,
			long esfOrganizationId, ESFEntityState esfEntityState,
			boolean isNotChangeState, ServiceContext serviceContext)
			throws PortalException, SystemException {

		long groupId = serviceContext.getScopeGroupId();

		User operator = userPersistence.findByPrimaryKey(userId);

		Date now = new Date();

		validateESFCardCode(code);

		ESFCard esfCard = getESFCard(resourcePrimKey);

		esfCard.setUserId(userId);
		esfCard.setUserName(operator.getFullName());
		esfCard.setModifiedDate(serviceContext.getModifiedDate(now));
		esfCard.setExpandoBridgeAttributes(serviceContext);

		esfCard.setCodeAlfa(codeAlfa);
		esfCard.setCodeNum(codeNum);
		esfCard.setCode(code);
		esfCard.setEsfUserId(esfUserId);
		esfCard.setEsfOrganizationId(esfOrganizationId);

		ESFEntityState esfEntityStateFromDB = ESFEntityStateLocalServiceUtil
				.findESFEntityStateByC_PK(ESFCard.class.getName(),
						resourcePrimKey);

		if (esfEntityStateFromDB != null
				&& (esfEntityStateFromDB.getEsfStateId() != esfEntityState
						.getEsfStateId()) || isNotChangeState) {

			ESFEntityStateLocalServiceUtil.updateEntityState(
					serviceContext.getUserId(),
					esfEntityStateFromDB.getEsfEntityStateId(), serviceContext);

			ESFCard esfCardNewEntity = getESFCard(resourcePrimKey);

			ESFCardLocalServiceUtil.addESFCard(userId,
					esfCardNewEntity.getCode(), esfCardNewEntity.getCodeAlfa(),
					esfCardNewEntity.getCodeNum(), esfEntityState, 0,
					esfOrganizationId, serviceContext);
		}

		esfCardPersistence.update(esfCard);

		resourceLocalService.updateResources(operator.getCompanyId(), groupId,
				ESFCard.class.getName(), resourcePrimKey,
				serviceContext.getGroupPermissions(),
				serviceContext.getGuestPermissions());

		AssetEntry assetEntry = assetEntryLocalService.updateEntry(userId,
				groupId, esfCard.getCreateDate(), esfCard.getModifiedDate(),
				ESFCard.class.getName(), resourcePrimKey, esfCard.getUuid(), 0,
				serviceContext.getAssetCategoryIds(),
				serviceContext.getAssetTagNames(), true, null, null, null,
				ContentTypes.TEXT_HTML, esfCard.getCode(), null, null, null,
				null, 0, 0, null, false);

		assetLinkLocalService.updateLinks(userId, assetEntry.getEntryId(),
				serviceContext.getAssetLinkEntryIds(),
				AssetLinkConstants.TYPE_RELATED);

		Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(ESFCard.class);

		indexer.reindex(esfCard);

		return esfCard;
	}

	/**
	 * Cerca tutte le Card sulla base dello codice
	 */
	public List<ESFCard> findAllESFCardsByCode_Organization(String code,
			long organizationId) {

		List<ESFCard> esfCards = new ArrayList<ESFCard>();

		try {

			List<ESFOrganization> organizations = ESFOrganizationLocalServiceUtil
					.findAllChildOrganizations(organizationId);

			long[] orgIds = new long[organizations.size() + 1];
			int i = 0;

			for (ESFOrganization esfOrganization : organizations) {
				orgIds[i] = esfOrganization.getEsfOrganizationId();
				i++;
			}

			orgIds[i] = organizationId;

			DynamicQuery cardQuery = DynamicQueryFactoryUtil.forClass(
					ESFCard.class, "cardQuery",
					PortletClassLoaderUtil.getClassLoader());

			cardQuery.add(PropertyFactoryUtil.forName("cardQuery.code").like(
					StringPool.PERCENT + code + StringPool.PERCENT));

			cardQuery.add(PropertyFactoryUtil.forName(
					"cardQuery.esfOrganizationId").in(orgIds));

			esfCards = ESFCardLocalServiceUtil.dynamicQuery(cardQuery);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return esfCards;
	}

	/**
	 * Cerca le Cards che sono associate all' utente con Id = userId e che il
	 * cui codice presenta parte del codice indicato
	 */
	public List<ESFCard> findAllESFCardsByC_U_O(String code, long userId,
			long organizationId) throws SystemException {

		List<ESFCard> cards = esfCardLocalService
				.findAllESFCardsByCode_Organization(code, organizationId);

		long[] classPKs = new long[cards.size()];
		int i = 0;

		for (ESFCard card : cards) {
			classPKs[i] = card.getEsfCardId();
			i++;
		}

		DynamicQuery cardQuery = DynamicQueryFactoryUtil.forClass(
				ESFCard.class, "cardQuery",
				PortletClassLoaderUtil.getClassLoader());

		cardQuery.add(PropertyFactoryUtil.forName("cardQuery.esfUserId").eq(
				userId));
		if (Validator.isNotNull(code)) {
			cardQuery.add(PropertyFactoryUtil.forName("cardQuery.esfCardId")
					.in(classPKs));
		}

		List<ESFCard> esfCards = ESFCardLocalServiceUtil
				.dynamicQuery(cardQuery);

		return esfCards;
	}

	/**
	 * Cerca tutte le Card sulla base dello stato [attivo o disattivo]
	 */
	public List<ESFCard> findAllESFCardsByState(int state) {

		List<ESFCard> esfCards = new ArrayList<ESFCard>();

		try {

			List<ESFEntityState> entityStates = ESFEntityStateLocalServiceUtil
					.findESFEntityStateByC_S(ESFCard.class.getName(), state);

			long[] classPKs = new long[entityStates.size()];

			int i = 0;

			for (ESFEntityState entityState : entityStates) {
				classPKs[i] = entityState.getClassPK();
				i++;
			}

			DynamicQuery cardQuery = DynamicQueryFactoryUtil.forClass(
					ESFCard.class, "cardQuery",
					PortletClassLoaderUtil.getClassLoader());

			cardQuery.add(PropertyFactoryUtil.forName("cardQuery.esfCardId")
					.in(classPKs));
			cardQuery.addOrder(OrderFactoryUtil.asc("cardQuery.codeAlfa"));
			cardQuery.addOrder(OrderFactoryUtil.asc("cardQuery.codeNum"));
			esfCards = ESFCardLocalServiceUtil.dynamicQuery(cardQuery);
		} catch (Exception e) {

		}
		return esfCards;
	}

	/**
	 * Cerca tutte le Card sulla base dello stato [attivo o disattivo]
	 */
	public List<ESFCard> findAllESFCardsByState(int state, int start, int end) {

		List<ESFCard> esfCards = new ArrayList<ESFCard>();

		try {

			List<ESFEntityState> entityStates = ESFEntityStateLocalServiceUtil
					.findESFEntityStateByC_S(ESFCard.class.getName(), state);

			long[] classPKs = new long[entityStates.size()];

			int i = 0;

			for (ESFEntityState entityState : entityStates) {
				classPKs[i] = entityState.getClassPK();
				i++;
			}

			DynamicQuery cardQuery = DynamicQueryFactoryUtil.forClass(
					ESFCard.class, "cardQuery",
					PortletClassLoaderUtil.getClassLoader());

			cardQuery.add(PropertyFactoryUtil.forName("cardQuery.esfCardId")
					.in(classPKs));

			cardQuery.addOrder(OrderFactoryUtil.asc("cardQuery.codeAlfa"));
			cardQuery.addOrder(OrderFactoryUtil.asc("cardQuery.codeNum"));
			esfCards = ESFCardLocalServiceUtil.dynamicQuery(cardQuery, start,
					end);
		} catch (Exception e) {

		}
		return esfCards;
	}

	/**
	 * Cerca tutte le Card che hanno uno stato [attivo o disattivo] e che sono
	 * associate o alle organizzazioni sportive foglie dell' organizazione con
	 * Id = organizationId (caso isLeaf = false) o all' organizzazione sportiva
	 * con Id = organizationId (caso isLeaf = true)
	 */
	public List<ESFCard> findAllByOrganizationId(long organizationId,
			boolean isLeaf, int state) {

		List<ESFCard> esfCards = new ArrayList<ESFCard>();

		try {

			List<ESFOrganization> organizations = new ArrayList<ESFOrganization>();
			List<Long> orgIds = new ArrayList<Long>();

			if (!isLeaf) {
				organizations = ESFOrganizationLocalServiceUtil
						.findAllLeafOrganizations(organizationId);
			}
			if (organizationId > 0)
				organizations.add(ESFOrganizationLocalServiceUtil
						.fetchESFOrganization(organizationId));

			List<ESFEntityState> allesfEntityState = ESFEntityStateLocalServiceUtil
					.findESFEntityStateByC_S(ESFCard.class.getName(), state);
			Hashtable<Long, Boolean> allcard = new Hashtable<Long, Boolean>();
			for (ESFEntityState esfEntityState : allesfEntityState) {
				allcard.put(esfEntityState.getClassPK(), true);
			}

			for (ESFOrganization esfOrganization : organizations) {
				if (esfOrganization != null) {
					List<ESFCard> cardTemps = esfCardPersistence
							.findByOrganizationId(esfOrganization
									.getEsfOrganizationId());
					for (ESFCard cardTemp : cardTemps) {
						if (allcard.get(cardTemp.getEsfCardId()) != null
								&& allcard.get(cardTemp.getEsfCardId()))
							orgIds.add(cardTemp.getEsfCardId());
					}
				}
			}
			if (orgIds.size() == 0)
				return esfCards;
			DynamicQuery cardQuery = DynamicQueryFactoryUtil.forClass(
					ESFCard.class, "cardQuery",
					PortletClassLoaderUtil.getClassLoader());
			cardQuery.add(PropertyFactoryUtil.forName("cardQuery.esfCardId")
					.in(orgIds));
			esfCards = ESFCardLocalServiceUtil.dynamicQuery(cardQuery);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return esfCards;
	}

	/**
	 * Cerca tutte le Card che hanno uno stato [attivo o disattivo] e che sono
	 * associate o alle organizzazioni sportive foglie dell' organizazione con
	 * Id = organizationId (caso isLeaf = false) o all' organizzazione sportiva
	 * con Id = organizationId (caso isLeaf = true)
	 */
	public List<ESFCard> findAllByOrganizationId(long organizationId,
			boolean isLeaf, int state, int start, int end) {

		List<ESFCard> esfCards = new ArrayList<ESFCard>();

		try {
			List<ESFOrganization> organizations = new ArrayList<ESFOrganization>();
			List<Long> orgIds = new ArrayList<Long>();

			if (!isLeaf) {
				organizations = ESFOrganizationLocalServiceUtil
						.findAllLeafOrganizations(organizationId);
			}
			if (organizationId > 0)
				organizations.add(ESFOrganizationLocalServiceUtil
						.fetchESFOrganization(organizationId));

			List<ESFEntityState> allesfEntityState = ESFEntityStateLocalServiceUtil
					.findESFEntityStateByC_S(ESFCard.class.getName(), state);
			Hashtable<Long, Boolean> allcard = new Hashtable<Long, Boolean>();
			for (ESFEntityState esfEntityState : allesfEntityState) {
				allcard.put(esfEntityState.getClassPK(), true);
			}

			for (ESFOrganization esfOrganization : organizations) {
				if (esfOrganization != null) {
					List<ESFCard> cardTemps = esfCardPersistence
							.findByOrganizationId(esfOrganization
									.getEsfOrganizationId());
					for (ESFCard cardTemp : cardTemps) {
						if (allcard.get(cardTemp.getEsfCardId()) != null
								&& allcard.get(cardTemp.getEsfCardId()))
							orgIds.add(cardTemp.getEsfCardId());
					}
				}
			}
			if (orgIds.size() == 0)
				return esfCards;
			DynamicQuery cardQuery = DynamicQueryFactoryUtil.forClass(
					ESFCard.class, "cardQuery",
					PortletClassLoaderUtil.getClassLoader());
			cardQuery.add(PropertyFactoryUtil.forName("cardQuery.esfCardId")
					.in(orgIds));
			esfCards = ESFCardLocalServiceUtil.dynamicQuery(cardQuery, start,
					end);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return esfCards;
	}

	/**
	 * Cerca tutte le Card che hanno uno stato [attivo o disattivo] e che sono
	 * associate o alle organizzazioni sportive foglie dell' organizazione con
	 * Id = organizationId (caso isLeaf = false) o all' organizzazione sportiva
	 * con Id = organizationId (caso isLeaf = true)
	 */
	public List<ESFCard> findAllESFCardsByOrganizationId(long organizationId,
			boolean isLeaf, int state) {

		List<ESFCard> esfCards = new ArrayList<ESFCard>();

		try {

			List<ESFCard> esfCardsByState = ESFCardLocalServiceUtil
					.findAllESFCardsByState(state);

			List<ESFCard> cardsTmp = new ArrayList<ESFCard>();
			List<Long> cardIds = new ArrayList<Long>();

			for (ESFCard esfCardByState : esfCardsByState) {
				cardsTmp.add(esfCardByState);
				cardIds.add(esfCardByState.getEsfCardId());
			}

			List<Long> orgIds = new ArrayList<Long>();

			if (!isLeaf) {
				List<ESFOrganization> organizations = ESFOrganizationLocalServiceUtil
						.findAllLeafOrganizations(organizationId);

				for (ESFOrganization esfOrganization : organizations) {
					for (ESFCard esfCard : cardsTmp) {
						if (esfCard.getEsfOrganizationId() == esfOrganization
								.getEsfOrganizationId())
							orgIds.add(esfCard.getEsfCardId());
					}
				}
			}

			DynamicQuery cardQuery = DynamicQueryFactoryUtil.forClass(
					ESFCard.class, "cardQuery",
					PortletClassLoaderUtil.getClassLoader());

			if (!isLeaf) {
				cardQuery.add(PropertyFactoryUtil
						.forName("cardQuery.esfCardId").in(orgIds));
			} else {
				cardQuery.add(PropertyFactoryUtil.forName(
						"cardQuery.esfOrganizationId").eq(organizationId));
				cardQuery.add(PropertyFactoryUtil
						.forName("cardQuery.esfCardId").in(cardIds));
			}

			esfCards = ESFCardLocalServiceUtil.dynamicQuery(cardQuery);
		} catch (Exception e) {

		}

		return esfCards;
	}

	/**
	 * Cerca tutte le Card che hanno uno stato [attivo o disattivo] e che sono
	 * associate o alle organizzazioni sportive foglie dell' organizazione con
	 * Id = organizationId (caso isLeaf = false) o all' organizzazione sportiva
	 * con Id = organizationId (caso isLeaf = true)
	 */
	public List<ESFCard> findAllESFCardsByOrganizationId(long organizationId,
			boolean isLeaf, int state, int start, int end) {

		List<ESFCard> esfCards = new ArrayList<ESFCard>();

		try {

			List<ESFCard> esfCardsByState = ESFCardLocalServiceUtil
					.findAllESFCardsByState(state);

			List<ESFCard> cardsTmp = new ArrayList<ESFCard>();
			List<Long> cardIds = new ArrayList<Long>();

			for (ESFCard esfCardByState : esfCardsByState) {
				cardsTmp.add(esfCardByState);
				cardIds.add(esfCardByState.getEsfCardId());
			}

			List<Long> orgIds = new ArrayList<Long>();

			if (!isLeaf) {
				List<ESFOrganization> organizations = ESFOrganizationLocalServiceUtil
						.findAllLeafOrganizations(organizationId);

				for (ESFOrganization esfOrganization : organizations) {
					for (ESFCard esfCard : cardsTmp) {
						if (esfCard.getEsfOrganizationId() == esfOrganization
								.getEsfOrganizationId())
							orgIds.add(esfCard.getEsfCardId());
					}
				}
			}

			DynamicQuery cardQuery = DynamicQueryFactoryUtil.forClass(
					ESFCard.class, "cardQuery",
					PortletClassLoaderUtil.getClassLoader());

			if (!isLeaf) {
				cardQuery.add(PropertyFactoryUtil
						.forName("cardQuery.esfCardId").in(orgIds));
			} else {
				cardQuery.add(PropertyFactoryUtil.forName(
						"cardQuery.esfOrganizationId").eq(organizationId));
				cardQuery.add(PropertyFactoryUtil
						.forName("cardQuery.esfCardId").in(cardIds));
			}

			esfCards = ESFCardLocalServiceUtil.dynamicQuery(cardQuery, start,
					end);
		} catch (Exception e) {

		}

		return esfCards;
	}

	/**
	 * Cerca tutte le Card che hanno uno stato [attivo o disattivo] e che sono
	 * associate alle organizzazioni sportive figlie dell' organizazione con Id
	 * = organizationId e alla stessa organizzazione
	 */
	public List<ESFCard> findAllESFCardsByRootOrganizationId(
			long organizationId, int state) {

		List<ESFCard> esfCards = new ArrayList<ESFCard>();

		try {

			List<ESFCard> esfCardsByState = ESFCardLocalServiceUtil
					.findAllESFCardsByState(state);

			List<Long> orgIds = new ArrayList<Long>();

			List<ESFOrganization> organizations = ESFOrganizationLocalServiceUtil
					.findAllChildOrganizations(organizationId);

			for (ESFOrganization esfOrganization : organizations) {
				for (ESFCard esfCard : esfCardsByState) {
					if (esfCard.getEsfOrganizationId() == esfOrganization
							.getEsfOrganizationId())
						orgIds.add(esfCard.getEsfCardId());
				}
			}

			DynamicQuery cardQuery = DynamicQueryFactoryUtil.forClass(
					ESFCard.class, "cardQuery",
					PortletClassLoaderUtil.getClassLoader());

			cardQuery.add(PropertyFactoryUtil.forName("cardQuery.esfCardId")
					.in(orgIds));

			esfCards = ESFCardLocalServiceUtil.dynamicQuery(cardQuery);
		} catch (Exception e) {
		}

		return esfCards;
	}

	/**
	 * Cerca tutte le Card che hanno uno stato [attivo o disattivo] e che sono
	 * associate alle organizzazioni sportive figlie dell' organizazione con Id
	 * = organizationId e alla stessa organizzazione
	 */
	public List<ESFCard> findAllESFCardsByRootOrganizationId(
			long organizationId, int state, int start, int end) {

		List<ESFCard> esfCards = new ArrayList<ESFCard>();

		try {

			List<ESFCard> esfCardsByState = ESFCardLocalServiceUtil
					.findAllESFCardsByState(state);

			List<Long> orgIds = new ArrayList<Long>();

			List<ESFOrganization> organizations = ESFOrganizationLocalServiceUtil
					.findAllChildOrganizations(organizationId);

			for (ESFOrganization esfOrganization : organizations) {
				for (ESFCard esfCard : esfCardsByState) {
					if (esfCard.getEsfOrganizationId() == esfOrganization
							.getEsfOrganizationId())
						orgIds.add(esfCard.getEsfCardId());
				}
			}

			DynamicQuery cardQuery = DynamicQueryFactoryUtil.forClass(
					ESFCard.class, "cardQuery",
					PortletClassLoaderUtil.getClassLoader());

			cardQuery.add(PropertyFactoryUtil.forName("cardQuery.esfCardId")
					.in(orgIds));

			esfCards = ESFCardLocalServiceUtil.dynamicQuery(cardQuery, start,
					end);
		} catch (Exception e) {
		}

		return esfCards;
	}

	/**
	 * Cerca la Card che ha uno stato [attivo o disattivo] e che � associata
	 * all' organizzazione con Id = organizationId e cardId = esfCardId
	 */
	public ESFCard findESFCardByO_C(long organizationId, long esfCardId,
			int state) {

		List<ESFCard> esfCards = new ArrayList<ESFCard>();

		try {

			List<ESFCard> esfCardsByOrgId = ESFCardLocalServiceUtil
					.findAllESFCardsByOrganizationId(organizationId, true,
							state);

			List<Long> cardIds = new ArrayList<Long>();
			for (ESFCard esfCardByState : esfCardsByOrgId) {
				cardIds.add(esfCardByState.getEsfCardId());
			}

			DynamicQuery cardQuery = DynamicQueryFactoryUtil.forClass(
					ESFCard.class, "cardQuery",
					PortletClassLoaderUtil.getClassLoader());

			cardQuery.add(PropertyFactoryUtil.forName("cardQuery.esfCardId")
					.eq(esfCardId));
			cardQuery.add(PropertyFactoryUtil.forName("cardQuery.esfCardId")
					.in(cardIds));

			esfCards = ESFCardLocalServiceUtil.dynamicQuery(cardQuery);
		} catch (Exception e) {

		}
		if (esfCards.size() == 0)
			return null;
		else
			return esfCards.get(0);
	}

	/**
	 * Cerca tutte le Card non ancora assegnate, che hanno uno stato [attivo o
	 * disattivo] e che o sono associate alle organizzazioni sportive foglie
	 * dell' organizazione con Id = organizationId (caso isLeaf = false) o all'
	 * organizzazione sportiva con Id = organizationId (caso isLeaf = true)
	 */
	public List<ESFCard> findAllNotAssignedESFCardsByO_S(long organizationId,
			boolean isLeaf, int state) {

		List<ESFCard> esfCards = new ArrayList<ESFCard>();

		try {

			List<ESFCard> esfCardsByOrgId = ESFCardLocalServiceUtil
					.findAllESFCardsByOrganizationId(organizationId, isLeaf,
							state);

			List<Long> cardIds = new ArrayList<Long>();

			for (ESFCard esfCardByOrgId : esfCardsByOrgId) {
				cardIds.add(esfCardByOrgId.getEsfCardId());

			}

			DynamicQuery cardQuery = DynamicQueryFactoryUtil.forClass(
					ESFCard.class, "cardQuery",
					PortletClassLoaderUtil.getClassLoader());

			cardQuery.add(PropertyFactoryUtil.forName("cardQuery.esfUserId")
					.eq(new Long("0")));
			cardQuery.add(PropertyFactoryUtil.forName("cardQuery.esfCardId")
					.in(cardIds));

			esfCards = ESFCardLocalServiceUtil.dynamicQuery(cardQuery);
		} catch (Exception e) {

		}
		return esfCards;
	}

	/**
	 * Cerca tutte le Card non ancora assegnate, che hanno uno stato [attivo o
	 * disattivo] e che o sono associate alle organizzazioni sportive foglie
	 * dell' organizazione con Id = organizationId (caso isLeaf = false) o all'
	 * organizzazione sportiva con Id = organizationId (caso isLeaf = true)
	 */
	public List<ESFCard> findAllNotAssignedESFCardsByO_S(long organizationId,
			boolean isLeaf, int state, int start, int end) {

		List<ESFCard> esfCards = new ArrayList<ESFCard>();

		try {

			List<ESFCard> esfCardsByOrgId = ESFCardLocalServiceUtil
					.findAllESFCardsByOrganizationId(organizationId, isLeaf,
							state);

			List<Long> cardIds = new ArrayList<Long>();

			for (ESFCard esfCardByOrgId : esfCardsByOrgId) {
				cardIds.add(esfCardByOrgId.getEsfCardId());

			}

			DynamicQuery cardQuery = DynamicQueryFactoryUtil.forClass(
					ESFCard.class, "cardQuery",
					PortletClassLoaderUtil.getClassLoader());

			cardQuery.add(PropertyFactoryUtil.forName("cardQuery.esfUserId")
					.eq(new Long("0")));
			cardQuery.add(PropertyFactoryUtil.forName("cardQuery.esfCardId")
					.in(cardIds));

			esfCards = ESFCardLocalServiceUtil.dynamicQuery(cardQuery, start,
					end);
		} catch (Exception e) {

		}
		return esfCards;
	}

	/**
	 * Cerca tutte le Card non ancora assegnate, tranne quella dell'utente che
	 * corrisponde allo user id esfUserId, che hanno uno stato [attivo o
	 * disattivo] e che o sono associate alle organizzazioni sportive foglie
	 * dell' organizazione con Id = organizationId (caso isLeaf = false) o all'
	 * organizzazione sportiva con Id = organizationId (caso isLeaf = true)
	 */
	public List<ESFCard> findAllNotAssignedESFCardsByO_U_S(long organizationId,
			long esfUserId, boolean isLeaf, int state, int start, int end) {

		List<ESFCard> esfCards = new ArrayList<ESFCard>();
		try {

			List<ESFCard> esfCardsByOrgId = ESFCardLocalServiceUtil
					.findAllESFCardsByOrganizationId(organizationId, isLeaf,
							state);

			List<Long> cardIds = new ArrayList<Long>();

			for (ESFCard esfCardByOrgId : esfCardsByOrgId) {
				cardIds.add(esfCardByOrgId.getEsfCardId());
			}

			DynamicQuery cardQuery = DynamicQueryFactoryUtil.forClass(
					ESFCard.class, "cardQuery",
					PortletClassLoaderUtil.getClassLoader());

			Criterion criterion = null;
			criterion = RestrictionsFactoryUtil.eq("cardQuery.esfUserId",
					new Long("0"));

			if (esfUserId > 0) {
				criterion = RestrictionsFactoryUtil.or(criterion,
						RestrictionsFactoryUtil.eq("cardQuery.esfUserId",
								esfUserId));
			}

			criterion = RestrictionsFactoryUtil.and(criterion,
					RestrictionsFactoryUtil.in("cardQuery.esfCardId", cardIds));

			cardQuery.add(criterion);

			esfCards = ESFCardLocalServiceUtil.dynamicQuery(cardQuery, start,
					end);
		} catch (Exception e) {

		}
		return esfCards;
	}

	/**
	 * Cerca tutte le Card non ancora assegnate, tranne quella dell'utente che
	 * corrisponde allo user id esfUserId, che hanno uno stato [attivo o
	 * disattivo] e che o sono associate alle organizzazioni sportive foglie
	 * dell' organizazione con Id = organizationId (caso isLeaf = false) o all'
	 * organizzazione sportiva con Id = organizationId (caso isLeaf = true)
	 */
	public List<ESFCard> findAllNotAssignedESFCardsByO_U_S(long organizationId,
			boolean isLeaf, long esfUserId, int state) {

		List<ESFCard> esfCards = new ArrayList<ESFCard>();

		try {

			List<ESFCard> esfCardsByOrgId = ESFCardLocalServiceUtil
					.findAllESFCardsByOrganizationId(organizationId, isLeaf,
							state);

			List<Long> cardIds = new ArrayList<Long>();

			for (ESFCard esfCardByOrgId : esfCardsByOrgId) {
				cardIds.add(esfCardByOrgId.getEsfCardId());
			}

			DynamicQuery cardQuery = DynamicQueryFactoryUtil.forClass(
					ESFCard.class, "cardQuery",
					PortletClassLoaderUtil.getClassLoader());

			Criterion criterion = null;
			criterion = RestrictionsFactoryUtil.eq("cardQuery.esfUserId",
					new Long("0"));

			if (esfUserId > 0) {
				criterion = RestrictionsFactoryUtil.or(criterion,
						RestrictionsFactoryUtil.eq("cardQuery.esfUserId",
								esfUserId));
			}

			criterion = RestrictionsFactoryUtil.and(criterion,
					RestrictionsFactoryUtil.in("cardQuery.esfCardId", cardIds));

			cardQuery.add(criterion);

			esfCards = ESFCardLocalServiceUtil.dynamicQuery(cardQuery);
		} catch (Exception e) {

		}
		return esfCards;
	}

	protected void validateESFCardCode(String code) throws PortalException {

		if (Validator.isNull(code)) {
			throw new ESFCardCodeException();
		}
	}

	/**
	 * Cerca le Cards che hanno uno stato [attivo o disattivo], che sono
	 * associate all' utente con Id = userId e all' organizzazione sportiva con
	 * Id = organizationId
	 */
	public List<ESFCard> findAllESFCardsByU_O_S(long userId,
			long organizationId, int state) throws SystemException {

		List<ESFEntityState> entityStates = ESFEntityStateLocalServiceUtil
				.findESFEntityStateByC_S(ESFCard.class.getName(), state);

		long[] classPKs = new long[entityStates.size()];
		int i = 0;

		for (ESFEntityState entityState : entityStates) {
			classPKs[i] = entityState.getClassPK();
			i++;
		}

		DynamicQuery cardQuery = DynamicQueryFactoryUtil.forClass(
				ESFCard.class, "cardQuery",
				PortletClassLoaderUtil.getClassLoader());

		cardQuery.add(PropertyFactoryUtil.forName("cardQuery.esfUserId").eq(
				userId));
		cardQuery.add(PropertyFactoryUtil
				.forName("cardQuery.esfOrganizationId").eq(organizationId));
		cardQuery.add(PropertyFactoryUtil.forName("cardQuery.esfCardId").in(
				classPKs));

		List<ESFCard> esfCards = ESFCardLocalServiceUtil
				.dynamicQuery(cardQuery);

		return esfCards;
	}

	/**
	 * Cerca le Cards che hanno lo stato [disattivo], che sono associate all'
	 * utente con Id = userId, che sono state emesse prima della date
	 * passata per parametro.
	 */
	public List<ESFCard> findAllESFCardsByU_S_Y(long userId, Date date)
			throws SystemException {

		int currentYear = ManageDate.getYear(date);
		List<ESFCard> esfCardresult = new ArrayList<ESFCard>();
		List<ESFCard> esfCards = esfCardPersistence.findByUserId(userId);
		if (esfCards != null) {
			for (ESFCard e : esfCards) {

				ESFEntityState eSFEntityState = ESFEntityStateLocalServiceUtil
						.findAllESFEntityStateByClassName_ClassPK(
								ESFCard.class.getName(), e.getPrimaryKey());
				if (eSFEntityState != null
						&& (eSFEntityState.getEndDate() != null || (eSFEntityState
								.getEndDate() == null && eSFEntityState
								.getEsfStateId() != ESFKeys.ESFStateType.ENABLE))
						&& (ManageDate.getYear(eSFEntityState.getStartDate()) <= currentYear)) {
					esfCardresult.add(e);
				}
			}
		}
		return esfCardresult;
	}

	/**
	 * Cerca le Cards che hanno lo stato [disattivo], che sono associate all'
	 * utente con Id = userId, che sono state emesse  prima della date
	 * passata per parametro.
	 */
	public List<ESFCard> findAllESFCardsByU_S_Y(long userId, Date date,int start,int end)
			throws SystemException {

		List<ESFCard> esfCardresult = findAllESFCardsByU_S_Y( userId,  date);

		return esfCardresult.subList(start, end);

	}
	
	/**
	 * Cerca le Cards che hanno uno stato [attivo o disattivo], che sono
	 * associate all' utente con Id = userId
	 */
	public List<ESFCard> findAllESFCardsByU_S(long userId, int state)
			throws SystemException {
				return ESFCardFinderUtil.findCardByUserState(state, userId);

	}

	/**
	 * Cerca le Cards associate all' utente con Id = userId
	 */
	public List<ESFCard> findCardByUser(long userId)
			throws SystemException {
				return ESFCardFinderUtil.findCardByUser( userId);

	}

	public List<ESFCard> getAllEsfCardByLikeC(String code, int state,
			int start, int end) {

		List<ESFCard> esfCards = new ArrayList<ESFCard>();

		try {
			List<ESFEntityState> entityStates = ESFEntityStateLocalServiceUtil
					.findESFEntityStateByC_S(ESFCard.class.getName(), state);

			long[] classPKs = new long[entityStates.size()];
			int i = 0;

			for (ESFEntityState entityState : entityStates) {
				classPKs[i] = entityState.getClassPK();
				i++;
			}

			DynamicQuery cardsQuery = DynamicQueryFactoryUtil.forClass(
					ESFCard.class, "cardsQuery",
					PortletClassLoaderUtil.getClassLoader());

			cardsQuery.add(PropertyFactoryUtil.forName("cardsQuery.code").like(
					StringPool.PERCENT + code + StringPool.PERCENT));
			cardsQuery.add(PropertyFactoryUtil.forName("cardsQuery.esfCardId")
					.in(classPKs));

			List<ESFCard> esfCardsToFind = ESFCardLocalServiceUtil
					.dynamicQuery(cardsQuery, start, end);

			for (ESFCard esfCardToFind : esfCardsToFind) {
				ESFCard esfCardsToSend = esfCardPersistence
						.fetchByPrimaryKey(esfCardToFind.getEsfCardId());
				esfCards.add(esfCardsToSend);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return esfCards;
	}

	public List<ESFCard> getAllEsfCardByLikeC(String code, int state) {

		List<ESFCard> esfCards = new ArrayList<ESFCard>();

		try {
			List<ESFEntityState> entityStates = ESFEntityStateLocalServiceUtil
					.findESFEntityStateByC_S(ESFCard.class.getName(), state);

			long[] classPKs = new long[entityStates.size()];
			int i = 0;

			for (ESFEntityState entityState : entityStates) {
				classPKs[i] = entityState.getClassPK();
				i++;
			}

			DynamicQuery cardsQuery = DynamicQueryFactoryUtil.forClass(
					ESFCard.class, "cardsQuery",
					PortletClassLoaderUtil.getClassLoader());

			cardsQuery.add(PropertyFactoryUtil.forName("cardsQuery.code").like(
					StringPool.PERCENT + code + StringPool.PERCENT));
			cardsQuery.add(PropertyFactoryUtil.forName("cardsQuery.esfCardId")
					.in(classPKs));

			List<ESFCard> esfCardsToFind = ESFCardLocalServiceUtil
					.dynamicQuery(cardsQuery);

			for (ESFCard esfCardToFind : esfCardsToFind) {
				ESFCard esfCardsToSend = esfCardPersistence
						.fetchByPrimaryKey(esfCardToFind.getEsfCardId());
				esfCards.add(esfCardsToSend);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return esfCards;
	}

	public ESFCard getEsfCardByCode(String code, int state) {

		ESFCard esfCard = null;

		try {
			List<ESFEntityState> entityStates = ESFEntityStateLocalServiceUtil
					.findESFEntityStateByC_S(ESFCard.class.getName(), state);

			long[] classPKs = new long[entityStates.size()];
			int i = 0;

			for (ESFEntityState entityState : entityStates) {
				classPKs[i] = entityState.getClassPK();
				i++;
			}

			DynamicQuery cardsQuery = DynamicQueryFactoryUtil.forClass(
					ESFCard.class, "cardsQuery",
					PortletClassLoaderUtil.getClassLoader());

			cardsQuery.add(PropertyFactoryUtil.forName("cardsQuery.code").eq(
					code));
			cardsQuery.add(PropertyFactoryUtil.forName("cardsQuery.esfCardId")
					.in(classPKs));

			List<ESFCard> esfCardsToFind = ESFCardLocalServiceUtil
					.dynamicQuery(cardsQuery);

			for (ESFCard esfCardToFind : esfCardsToFind) {
				ESFCard esfCardsToSend = esfCardPersistence
						.fetchByPrimaryKey(esfCardToFind.getEsfCardId());
				esfCard = esfCardsToSend;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return esfCard;
	}

	public List<ESFCard> checkCode(String code, ServiceContext serviceContext)
			throws PortalException, SystemException {

		List<ESFCard> esfCards = new ArrayList<ESFCard>();

		if (Validator.isNotNull(code) && !Validator.isBlank(code)) {

			esfCards = esfCardPersistence.findByCode(code);

		}

		return esfCards;
	}

	private long starterNumCard(String codeAlfa) throws SystemException {

		long starter = 0;

		List<ESFCard> cards = new ArrayList<ESFCard>();

		cards = esfCardPersistence.findByCodeAlfa(codeAlfa);

		if (cards.isEmpty())

			starter = ESFKeys.ESFCard.MINCODENUM;

		else {

			starter = cards.get(cards.size() - 1).getCodeNum();

		}

		return starter;

	}

	public String buildCode(String codeAlfa, long codeNum) {

		String code = codeAlfa;

		String codeNumTmp = String.valueOf(codeNum);
		List<ESFConfiguration> conf = new ArrayList<ESFConfiguration>();
		ESFConfiguration maxDimensionConf = new ESFConfigurationImpl();
		String maxDimension = "";
		try {
			conf = ESFConfigurationLocalServiceUtil.findESFConfigurationTypeByKey(ESFKeys.EsfConfigurationKey.MAXCODENUM_Card);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		maxDimensionConf = conf.get(0);
		maxDimension = (maxDimensionConf.getValue()) ;
		
		for (int i = 0; i < ( maxDimension.length() - codeNumTmp.length()); i++) {

			code += "0";
		}

		code += codeNum;

		return code;
	}
	
	public List<ESFCard> findActualUserCards(long esfUserId)
			throws PortalException, SystemException {

		List<ESFCard> esfCards = new ArrayList<ESFCard>();

		esfCards = ESFCardFinderUtil.findActualUserCards(esfUserId);
	
		return esfCards;
	}
	
	
	
	
	
}
