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
import java.util.List;

import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
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
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ListType;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ListTypeServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.model.AssetLinkConstants;

import it.ethica.esf.ESFGunNameExceptionException;
import it.ethica.esf.model.ESFGun;
import it.ethica.esf.model.ESFGunKind;
import it.ethica.esf.model.ESFGunType;
import it.ethica.esf.model.impl.ESFGunKindImpl;
import it.ethica.esf.service.ESFGunKindLocalServiceUtil;
import it.ethica.esf.service.ESFGunLocalServiceUtil;
import it.ethica.esf.service.base.ESFGunLocalServiceBaseImpl;

/**
 * The implementation of the e s f gun local service. <p> All custom service
 * methods should be put in this class. Whenever methods are added, rerun
 * ServiceBuilder to copy their definitions into the
 * {@link it.ethica.esf.service.ESFGunLocalService} interface. <p> This is a
 * local service. Methods of this service will not have security checks based on
 * the propagated JAAS credentials because this service can only be accessed
 * from within the same VM. </p>
 *
 * @author Ethica
 * @see it.ethica.esf.service.base.ESFGunLocalServiceBaseImpl
 * @see it.ethica.esf.service.ESFGunLocalServiceUtil
 */
public class ESFGunLocalServiceImpl extends ESFGunLocalServiceBaseImpl {

	/**
	 * Ricerca tutti gli oggetti ESFGun sulla base del codice e della tipologia
	 * dell'arma.
	 * Il parametro <b>code</b> e' in LIKE mentre il <b>esfGunKindId</b> e' in equal.
	 * 
	 * @param code il codice dell'arma
	 * @param esfGunKindId l'identificativo del tipo di arma
	 * @return List<ESFGun> 
	 */
	public List<ESFGun> getESFGunByLikeC_K(String code, long esfGunKindId) {

		List<ESFGun> esfGuns = new ArrayList<ESFGun>();

		try {

			DynamicQuery gunQuery =
				DynamicQueryFactoryUtil.forClass(
					ESFGun.class, "gunQuery",
					PortletClassLoaderUtil.getClassLoader());

			if (esfGunKindId != 0) {
				gunQuery.add(RestrictionsFactoryUtil.and(
					PropertyFactoryUtil.forName("gunQuery.code").like(
						StringPool.PERCENT + code + StringPool.PERCENT),
					PropertyFactoryUtil.forName("gunQuery.esfGunKindId").eq(
						esfGunKindId)));
			}
			else {
				gunQuery.add(PropertyFactoryUtil.forName("gunQuery.code").like(
					StringPool.PERCENT + code + StringPool.PERCENT));
			}

			esfGuns = ESFGunLocalServiceUtil.dynamicQuery(gunQuery);

		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return esfGuns;
	}

	
	/**
	 * Ricerca tutti gli oggetti ESFGun sulla base del codice e della tipologia
	 * dell'arma.
	 * Il parametro <b>code</b> e' in LIKE mentre il <b>esfGunKindId</b> e' in equal.
	 * I parametri di <b>start</b> e <b>end</b> definiscono il range di oggetti da restituire.
	 * 
	 * @param code il codice dell'arma
	 * @param esfGunKindId l'identificativo del tipo di arma
	 * @param start
	 * @param end
	 * @return List<ESFGun> 
	 */
	public List<ESFGun> getESFGunByLikeC_K(
		String code, long esfGunKindId, int start, int end) {

		List<ESFGun> esfGuns = new ArrayList<ESFGun>();

		try {

			DynamicQuery gunQuery =
				DynamicQueryFactoryUtil.forClass(
					ESFGun.class, "gunQuery",
					PortletClassLoaderUtil.getClassLoader());

			if (esfGunKindId != 0) {
				gunQuery.add(RestrictionsFactoryUtil.and(
					PropertyFactoryUtil.forName("gunQuery.code").like(
						StringPool.PERCENT + code + StringPool.PERCENT),
					PropertyFactoryUtil.forName("gunQuery.esfGunKindId").eq(
						esfGunKindId)));
			}
			else {
				gunQuery.add(PropertyFactoryUtil.forName("gunQuery.code").like(
					StringPool.PERCENT + code + StringPool.PERCENT));
			}

			esfGuns = ESFGunLocalServiceUtil.dynamicQuery(gunQuery, start, end);

		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return esfGuns;
	}

	
	/**
	 * Ricerca tutti gli oggetti ESFGun sulla base del codice dell'arma, della tipologia
	 * dell'arma e dell'utente.
	 * Il parametro <b>code</b> e' in LIKE mentre il <b>esfGunKindId</b> e il <b>esfUserId</b>
	 * e' in equal.
	 * 
	 * @param code il codice dell'arma
	 * @param esfGunKindId l'identificativo del tipo di arma
	 * @param esfUserId l'identificativo dell'utente
	 * @return List<ESFGun> 
	 */
	public List<ESFGun> getESFGunByLikeC_K_U(
		String code, long esfGunKindId, long esfUserId) {

		List<ESFGun> esfGuns = new ArrayList<ESFGun>();

		try {

			DynamicQuery gunQuery =
				DynamicQueryFactoryUtil.forClass(
					ESFGun.class, "gunQuery",
					PortletClassLoaderUtil.getClassLoader());

			if (esfGunKindId != 0) {
				gunQuery.add(RestrictionsFactoryUtil.and(
					PropertyFactoryUtil.forName("gunQuery.code").like(
						StringPool.PERCENT + code + StringPool.PERCENT),
					PropertyFactoryUtil.forName("gunQuery.esfGunKindId").eq(
						esfGunKindId)));
			}
			else {
				gunQuery.add(PropertyFactoryUtil.forName("gunQuery.code").like(
					StringPool.PERCENT + code + StringPool.PERCENT));
			}

			gunQuery.add(PropertyFactoryUtil.forName("gunQuery.esfUserId").like(
				esfUserId));
			
			esfGuns = ESFGunLocalServiceUtil.dynamicQuery(gunQuery);

		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return esfGuns;
	}
	
	/**
	 * Ricerca arma per Produttore Modello e Codice
	 * 
	 * 
	 */
	public List<ESFGun> getESFGunByLikeM_C_K_U(long esfGunTypeId,
			String code, long esfGunKindId, long esfUserId, int start, int end) {

			List<ESFGun> esfGuns = new ArrayList<ESFGun>();
			List<ESFGun> esfGunsByM = new ArrayList<ESFGun>();
			
			try {

				DynamicQuery gunQuery =
					DynamicQueryFactoryUtil.forClass(
						ESFGun.class, "gunQuery",
						PortletClassLoaderUtil.getClassLoader());

				if (esfGunKindId != 0) {
					gunQuery.add(RestrictionsFactoryUtil.and(
						PropertyFactoryUtil.forName("gunQuery.code").like(
							StringPool.PERCENT + code + StringPool.PERCENT),
						PropertyFactoryUtil.forName("gunQuery.esfGunKindId").eq(
							esfGunKindId)));
				}
				else {
					gunQuery.add(PropertyFactoryUtil.forName("gunQuery.code").like(
						StringPool.PERCENT + code + StringPool.PERCENT));
				}

				gunQuery.add(PropertyFactoryUtil.forName("gunQuery.esfUserId").like(
					esfUserId));
				
				esfGuns = ESFGunLocalServiceUtil.dynamicQuery(gunQuery);
				
				if(0 !=esfGunTypeId){
					for(ESFGun gun : esfGuns){
						ESFGunKind kind = ESFGunKindLocalServiceUtil.fetchESFGunKind(gun.getEsfGunKindId());
						if(kind.getEsfGunTypeId() == esfGunTypeId){
							esfGunsByM.add(gun);
						}
					}
					
				}else{
					esfGunsByM = esfGuns;
				}

			}
			catch (Exception e) {
				e.printStackTrace();
			}
			
			if(end > esfGunsByM.size()){
				end = esfGunsByM.size();
			}
			esfGunsByM = esfGunsByM.subList(start, end);
			return esfGunsByM;
		}
	
	
	public int countESFGunByLikeM_C_K_U(long esfGunTypeId,
			String code, long esfGunKindId, long esfUserId) {

			List<ESFGun> esfGuns = new ArrayList<ESFGun>();
			List<ESFGun> esfGunsByM = new ArrayList<ESFGun>();
			int tot = 0;
			try {

				DynamicQuery gunQuery =
					DynamicQueryFactoryUtil.forClass(
						ESFGun.class, "gunQuery",
						PortletClassLoaderUtil.getClassLoader());

				if (esfGunKindId != 0) {
					gunQuery.add(RestrictionsFactoryUtil.and(
						PropertyFactoryUtil.forName("gunQuery.code").like(
							StringPool.PERCENT + code + StringPool.PERCENT),
						PropertyFactoryUtil.forName("gunQuery.esfGunKindId").eq(
							esfGunKindId)));
				}
				else {
					gunQuery.add(PropertyFactoryUtil.forName("gunQuery.code").like(
						StringPool.PERCENT + code + StringPool.PERCENT));
				}

				gunQuery.add(PropertyFactoryUtil.forName("gunQuery.esfUserId").like(
					esfUserId));

				esfGuns = ESFGunLocalServiceUtil.dynamicQuery(gunQuery);
				
				if(0 !=esfGunTypeId){
					for(ESFGun gun : esfGuns){
						ESFGunKind kind = ESFGunKindLocalServiceUtil.fetchESFGunKind(gun.getEsfGunKindId());
						if(kind.getEsfGunTypeId() == esfGunTypeId){
							esfGunsByM.add(gun);
						}
					}
					
				}else{
					esfGunsByM = esfGuns;
				}

			}
			catch (Exception e) {
				e.printStackTrace();
			}
			tot = esfGunsByM.size();
			return tot;
		}
	/**
	 * Ricerca arma per Produttore Modello e Codice
	 * @throws SystemException 
	 * 
	 * 
	 */
	public List<ESFGun> getESFGunByLikeM_K(long esfGunTypeId,
			 long esfGunKindId, int start, int end) throws SystemException {

		List<ESFGun> gunsK = new ArrayList<ESFGun>();
		List<ESFGun> gunsT = new ArrayList<ESFGun>();
		ESFGunKind kind = new ESFGunKindImpl();
		List<Long> caneId = new ArrayList<Long>();
		
		if(esfGunKindId > 0){
		gunsK = ESFGunLocalServiceUtil.getESFGunsByESFGunKind(esfGunKindId);
		}else{
			gunsK = ESFGunLocalServiceUtil.getESFGuns();
		}
		
		if(esfGunTypeId > 0){
			for(ESFGun gun : gunsK){
				kind = ESFGunKindLocalServiceUtil.fetchESFGunKind(gun.getEsfGunKindId());
				if(Validator.isNotNull(kind) && esfGunTypeId == kind.getEsfGunTypeId()){
					gunsT.add(gun);
				}
			}
			
			
		}else{
			gunsT = gunsK;
		}
		
			if(end > gunsT.size()){
				end = gunsT.size();
			}
			gunsT = gunsT.subList(start, end);
			return gunsT;
		}
	
	
	public int countESFGunByLikeM_K(long esfGunTypeId, long esfGunKindId) 
			throws SystemException {
		int tot = 0;
		List<ESFGun> gunsK = new ArrayList<ESFGun>();
		List<ESFGun> gunsT = new ArrayList<ESFGun>();
		ESFGunKind kind = new ESFGunKindImpl();
		List<Long> caneId = new ArrayList<Long>();
		
		if(esfGunKindId > 0){
		gunsK = ESFGunLocalServiceUtil.getESFGunsByESFGunKind(esfGunKindId);
		}else{
			gunsK = ESFGunLocalServiceUtil.getESFGuns();
		}
		
		if(esfGunTypeId > 0){
			for(ESFGun gun : gunsK){
				kind = ESFGunKindLocalServiceUtil.fetchESFGunKind(gun.getEsfGunKindId());
				if(Validator.isNotNull(kind) && esfGunTypeId == kind.getEsfGunTypeId()){
					gunsT.add(gun);
				}
			}
			
			
		}else{
			gunsT = gunsK;
		}
		
			tot = gunsT.size();
			return tot;
		}
	
	
	

	/**
	 * Ricerca tutti gli oggetti ESFGun sulla base dell'utente.
	 * 
	 * @param esfUserId l'identificativo dell'utente
	 * @return List<ESFGun> 
	 */
	public List<ESFGun> getESFGunsByUserId(long esfUserId)
		throws SystemException {

		return esfGunPersistence.findByEsfUserId(esfUserId);
	}

	/**
	 * Ricerca tutti gli oggetti ESFGun sulla base dell'utente.
	 * I parametri di <b>start</b> e <b>end</b> definiscono il range di oggetti da restituire
	 * 
	 * @param esfUserId l'identificativo dell'utente
	 * @param start
	 * @param end
	 * @return List<ESFGun> 
	 */
	public List<ESFGun> getESFGunsByUserId(long esfUserId, int start, int end)
		throws SystemException {

		return esfGunPersistence.findByEsfUserId(esfUserId, start, end);
	}

	/**
	 * Ricerca tutti gli oggetti ESFGun.
	 * I parametri di <b>start</b> e <b>end</b> definiscono il range di oggetti da restituire
	 * 
	 * @return List<ESFGun> 
	 */
	public List<ESFGun> getESFGuns()
		throws SystemException {

		return esfGunPersistence.findAll();
	}

	/**
	 * Ricerca tutti gli oggetti ESFGun.
	 * I parametri di <b>start</b> e <b>end</b> definiscono il range di oggetti da restituire
	 * 
	 * @return List<ESFGun> 
	 */
	public List<ESFGun> getESFGuns(int start, int end)
		throws SystemException {

		return esfGunPersistence.findAll(start, end);
	}

	/**
	 * Ricerca tutti gli oggetti ESFGun sulla base della tipologia di arma.
	 * 
	 * @param esfGunKindId l'identificativo del tipo di arma
	 * @return List<ESFGun> 
	 */
	public List<ESFGun> getESFGunsByESFGunKind(long esfGunKindId)
		throws SystemException {

		return esfGunPersistence.findByEsfGunKindId(esfGunKindId);
	}

	/**
	 * Ritorna la quantit� di oggetti ESFGun sulla base della tipologia di arma.
	 * 
	 * @param esfGunKindId l'identificativo del tipo di arma
	 * @return List<ESFGun> 
	 */
	public int getESFGunsByESFGunKindCount(long esfGunKindId)
		throws SystemException {

		return esfGunPersistence.findByEsfGunKindId(esfGunKindId).size();
	}
	
	
	
	

	/**
	 * Ricerca tutti gli oggetti ESFGun sulla base del codice e della tipologia
	 * dell'arma. Il parametro catridgeName viene usato per distinguere il fucile dalla cartuccia
	 * Il parametro <b>code</b> e' in LIKE mentre il <b>esfGunKindId</b> e' in equal.
	 * * I parametri di <b>start</b> e <b>end</b> definiscono il range di oggetti da restituire.
	 * @param code il codice dell'arma
	 * @param esfGunKindId l'identificativo del tipo di arma
	 *   @param catridgeName identifica la cartuccia, se � vuoto, indica un arma di tipo fucile
	 *  @param start
	 *  @param end
	 * @return List<ESFGun> 
	 */
	public List<ESFGun> getESFGunByLikeC_K_U(String code, long esfGunKindId, long esfUserId,int start, int end) {

		List<ESFGun> esfGuns = new ArrayList<ESFGun>();
		Criterion crit = null;
		try {

			DynamicQuery gunQuery =
				DynamicQueryFactoryUtil.forClass(
					ESFGun.class, "gunQuery",
					PortletClassLoaderUtil.getClassLoader());

			if (esfGunKindId != 0) {
			crit=PropertyFactoryUtil.forName("gunQuery.code").like(
				StringPool.PERCENT + code + StringPool.PERCENT);
			crit=RestrictionsFactoryUtil.and(crit, PropertyFactoryUtil.forName("gunQuery.esfGunKindId").eq(
					esfGunKindId));
			gunQuery.add(crit);
			}
			else {
				
			
			gunQuery.add(PropertyFactoryUtil.forName("gunQuery.code").like(
			 StringPool.PERCENT + code + StringPool.PERCENT));
			}
			gunQuery.add(PropertyFactoryUtil.forName("gunQuery.esfUserId").like(
				esfUserId));
			
			esfGuns = ESFGunLocalServiceUtil.dynamicQuery(gunQuery,start,end);

		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return esfGuns;
	}
	
	
	/**
	 * Ricerca tutti gli oggetti ESFGun sulla base del codice e della tipologia
	 * dell'arma. Il parametro catridgeName viene usato per distinguere il fucile dalla cartuccia
	 * Il parametro <b>code</b> e' in LIKE mentre il <b>esfGunKindId</b> e' in equal.
	 * @param code il codice dell'arma
	 * @param esfGunKindId l'identificativo del tipo di arma
	 *   @param catridgeName identifica la cartuccia, se � vuoto, indica un arma di tipo fucile

	 * @return List<ESFGun> 
	 */
	public List<ESFGun> getESFGunByLikeC_K_M_U(String code, long esfGunKindId, String catridgeName, long esfUserId) {

		List<ESFGun> esfGuns = new ArrayList<ESFGun>();
		Criterion crit = null;
		try {

			DynamicQuery gunQuery =
				DynamicQueryFactoryUtil.forClass(
					ESFGun.class, "gunQuery",
					PortletClassLoaderUtil.getClassLoader());

			if (esfGunKindId != 0) {
				crit=PropertyFactoryUtil.forName("gunQuery.code").like(
					StringPool.PERCENT + code + StringPool.PERCENT);
				crit=RestrictionsFactoryUtil.and(crit, PropertyFactoryUtil.forName("gunQuery.esfGunKindId").eq(
						esfGunKindId));
				crit=RestrictionsFactoryUtil.and(crit, PropertyFactoryUtil.forName("gunQuery.catridgeName").like(catridgeName
								));
				gunQuery.add(crit);
			}
			else {
				gunQuery.add(RestrictionsFactoryUtil.and(PropertyFactoryUtil.forName("gunQuery.code").like(
					StringPool.PERCENT + code + StringPool.PERCENT),PropertyFactoryUtil.forName("gunQuery.catridgeName").like(catridgeName
			)));
			}
			gunQuery.add(PropertyFactoryUtil.forName("gunQuery.esfUserId").like(
				esfUserId));
			esfGuns = ESFGunLocalServiceUtil.dynamicQuery(gunQuery);

		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return esfGuns;
	}
	
	public ESFGun addESFGun(
		long userId, String code, long esfGunKindId, long esfOrganizationId,
		long esfUserId, String registrationNumber,
		 long catridgeCaliber,int typology, String measures, boolean isFavoriteGun, String note, String name,
		ServiceContext serviceContext)
		throws SystemException, PortalException {
		
		long groupId = serviceContext.getScopeGroupId();

		User user = userPersistence.findByPrimaryKey(userId);

		Date now = new Date();

		long esfGunId = counterLocalService.increment();
		ESFGun esfGun = esfGunPersistence.create(esfGunId);
		
		esfGun.setUserId(userId);
		esfGun.setGroupId(groupId);
		esfGun.setCompanyId(user.getCompanyId());
		esfGun.setUserName(user.getFullName());
		esfGun.setCreateDate(serviceContext.getCreateDate(now));
		esfGun.setModifiedDate(serviceContext.getModifiedDate(now));
		esfGun.setCode(code);
		esfGun.setEsfUserId(esfUserId);
		esfGun.setEsfGunKindId(esfGunKindId);
		esfGun.setEsfOrganizationId(esfOrganizationId);
		esfGun.setRegistrationNumber(registrationNumber);
		esfGun.setCatridgeCaliber(catridgeCaliber);
		esfGun.setIsFavoriteGun(isFavoriteGun);
		esfGun.setNote(note);
		esfGun.setTypeId(typology);
		esfGun.setMeasures(measures);
		esfGun.setName(name);
		esfGun.setExpandoBridgeAttributes(serviceContext);

		esfGunPersistence.update(esfGun);

		resourceLocalService.addResources(
			user.getCompanyId(), groupId, userId, ESFGun.class.getName(),
			esfGunId, false, true, true);

		String assetName = getAssetName(esfGunKindId);

		AssetEntry assetEntry =
			assetEntryLocalService.updateEntry(
				userId, groupId, esfGun.getCreateDate(),
				esfGun.getModifiedDate(), ESFGun.class.getName(), esfGunId,
				esfGun.getUuid(), 0, serviceContext.getAssetCategoryIds(),
				serviceContext.getAssetTagNames(), true, null, null, null,
				ContentTypes.TEXT_HTML, assetName, null, null, null, null, 0,
				0, null, false);

		assetLinkLocalService.updateLinks(
			userId, assetEntry.getEntryId(),
			serviceContext.getAssetLinkEntryIds(),
			AssetLinkConstants.TYPE_RELATED);

		Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(ESFGun.class);

		indexer.reindex(esfGun);

		return esfGun;

	}

	public ESFGun updateESFGun(
		long userId, long esfGunId, String code, long esfGunKindId,
		long esfOrganizationId, long esfUserId, String registrationNumber,
		long catridgeCaliber, int typology, String measures,
		boolean isFavoriteGun, String note, String name, ServiceContext serviceContext)
		throws PortalException, SystemException {

		Date now = new Date();

		ESFGun esfGun = getESFGun(esfGunId);

		User user = UserLocalServiceUtil.getUser(userId);

		esfGun.setUserId(userId);
		esfGun.setCompanyId(user.getCompanyId());
		esfGun.setUserName(user.getFullName());
		esfGun.setCreateDate(serviceContext.getCreateDate(now));
		esfGun.setModifiedDate(serviceContext.getModifiedDate(now));
		esfGun.setCode(code);
		esfGun.setEsfUserId(esfUserId);
		esfGun.setEsfGunKindId(esfGunKindId);
		esfGun.setEsfOrganizationId(esfOrganizationId);
		esfGun.setEsfOrganizationId(esfOrganizationId);
		esfGun.setCatridgeCaliber(catridgeCaliber);
		esfGun.setIsFavoriteGun(isFavoriteGun);
		esfGun.setNote(note);
		esfGun.setTypeId(typology);
		esfGun.setMeasures(measures);
		esfGun.setName(name);
		esfGun.setExpandoBridgeAttributes(serviceContext);
		

		esfGunPersistence.update(esfGun);

		resourceLocalService.updateResources(
			serviceContext.getCompanyId(), serviceContext.getScopeGroupId(),
			ESFGun.class.getName(), esfGunId,
			serviceContext.getGroupPermissions(),
			serviceContext.getGuestPermissions());

		String assetName = getAssetName(esfGunKindId);

		AssetEntry assetEntry =
			assetEntryLocalService.updateEntry(
				esfGun.getUserId(), esfGun.getGroupId(),
				esfGun.getCreateDate(), esfGun.getModifiedDate(),
				ESFGun.class.getName(), esfGunId, esfGun.getUuid(), 0,
				serviceContext.getAssetCategoryIds(),
				serviceContext.getAssetTagNames(), true, null, null, null,
				ContentTypes.TEXT_HTML, assetName, null, null, null, null, 0,
				0, null, false);

		assetLinkLocalService.updateLinks(
			serviceContext.getUserId(), assetEntry.getEntryId(),
			serviceContext.getAssetLinkEntryIds(),
			AssetLinkConstants.TYPE_RELATED);

		Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(ESFGun.class);

		indexer.reindex(esfGun);

		return esfGun;
	}

	public ESFGun deleteESFGun(long esfGunId, ServiceContext serviceContext)
		throws PortalException, SystemException {

		ESFGun esfGun = getESFGun(esfGunId);

		resourceLocalService.deleteResource(
			serviceContext.getCompanyId(), ESFGun.class.getName(),
			ResourceConstants.SCOPE_INDIVIDUAL, esfGunId);

		AssetEntry assetEntry =
			assetEntryLocalService.fetchEntry(ESFGun.class.getName(), esfGunId);

		assetLinkLocalService.deleteLinks(assetEntry.getEntryId());

		assetEntryLocalService.deleteEntry(assetEntry);

		Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(ESFGun.class);

		indexer.delete(esfGun);

		esfGun = deleteESFGun(esfGunId);

		return esfGun;
	}

	public String getFullName(ESFGun esfGun)
		throws PortalException, SystemException {

		return getAssetName(esfGun.getEsfGunKindId());
	}

	protected void validate(String name)
		throws PortalException {

		if (Validator.isNull(name)) {
			throw new ESFGunNameExceptionException();
		}
	}

	protected String getAssetName(long esfGunKindId)
		throws PortalException, SystemException {

		ESFGunKind esfGunKind =
			esfGunKindLocalService.getESFGunKind(esfGunKindId);
		ESFGunType esfGunType =
			esfGunTypeLocalService.getESFGunType(esfGunKind.getEsfGunTypeId());

		return StringUtil.add(
			esfGunType.getName(), esfGunKind.getName(), StringPool.SPACE);
	}

	public ESFGun checkCode(String code, ServiceContext serviceContext)
		throws PortalException, SystemException {

		if (Validator.isNotNull(code) && !Validator.isBlank(code)) {
			return esfGunPersistence.fetchByCode(code);
		}

		return null;
	}
	
	public String getNameMod(ESFGun esfGun) throws PortalException, SystemException{
		ESFGunKind esfGunKind =
						esfGunKindLocalService.getESFGunKind(esfGun.getEsfGunKindId());
		return esfGunKind.getName();
	}
	
	public String getNameM(ESFGun esfGun) throws PortalException, SystemException{
		ESFGunKind esfGunKind =
						esfGunKindLocalService.getESFGunKind(esfGun.getEsfGunKindId());
					ESFGunType esfGunType =
						esfGunTypeLocalService.getESFGunType(esfGunKind.getEsfGunTypeId());
		return esfGunType.getName();
	}
	
	public String getNameT(ESFGun esfGun) throws PortalException, SystemException{
		ListType type=ListTypeServiceUtil.getListType(esfGun.getTypeId());
			
			return type.getName();
	}
	private static Log _log = LogFactoryUtil.getLog(ESFGunLocalServiceImpl.class);
}
