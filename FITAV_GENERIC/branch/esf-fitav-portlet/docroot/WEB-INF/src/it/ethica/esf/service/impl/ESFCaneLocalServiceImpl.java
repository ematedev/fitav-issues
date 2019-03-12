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
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ListType;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ListTypeServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;

import it.ethica.esf.model.ESFCane;
import it.ethica.esf.model.ESFGun;
import it.ethica.esf.model.ESFGunKind;
import it.ethica.esf.model.ESFGunType;
import it.ethica.esf.model.ESFgunUser;
import it.ethica.esf.model.impl.ESFGunKindImpl;
import it.ethica.esf.model.impl.ESFgunUserImpl;
import it.ethica.esf.service.ESFCaneLocalServiceUtil;
import it.ethica.esf.service.ESFGunKindLocalServiceUtil;
import it.ethica.esf.service.ESFGunLocalServiceUtil;
import it.ethica.esf.service.ESFgunUserLocalServiceUtil;
import it.ethica.esf.service.base.ESFCaneLocalServiceBaseImpl;

/**
 * The implementation of the e s f cane local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link it.ethica.esf.service.ESFCaneLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Ethica
 * @see it.ethica.esf.service.base.ESFCaneLocalServiceBaseImpl
 * @see it.ethica.esf.service.ESFCaneLocalServiceUtil
 */
public class ESFCaneLocalServiceImpl extends ESFCaneLocalServiceBaseImpl {
	
	public ESFCane addESFCane(
		long userId, long esfGunKindId, long esgGunTypeId,
		long esfUserId, long esfOrganizationId, String code, long caneCaliber, 
		int typology, String measures, boolean isFavoriteGun, long shooterId, 
		String shooter_note, ServiceContext serviceContext)
		throws SystemException, PortalException {

		long groupId = serviceContext.getScopeGroupId();

		User user = userPersistence.findByPrimaryKey(userId);

		

		long esfCaneId = counterLocalService.increment();

		ESFCane esfCane = esfCanePersistence.create(esfCaneId);

	
		esfCane.setEsfUserId(esfUserId);
		esfCane.setEsfGunKindId(esfGunKindId);
		esfCane.setEsfOrganizationId(esfOrganizationId);
		esfCane.setEsfUserId(esfUserId);
		esfCane.setCaneCaliber(caneCaliber);
		esfCane.setTypeId(typology);
		esfCane.setMeasures(measures);
		esfCane.setCode(code);
		esfCane.setIsFavoriteGun(isFavoriteGun);
		esfCane.setShooterId(shooterId);
		esfCane.setEsfGunTypeId(esgGunTypeId);
		esfCane.setExpandoBridgeAttributes(serviceContext);

		esfCanePersistence.update(esfCane);
		
		ESFgunUserLocalServiceUtil.addESFGunUser(esfCaneId, shooterId, code, isFavoriteGun,
				it.ethica.esf.util.ESFKeys.ESFGunType.CANE, shooter_note, 
				esgGunTypeId, esfGunKindId, typology, measures, caneCaliber,serviceContext);

		return esfCane;

	}

	public ESFCane updateESFCane(
		long userId, long esfCaneId,long esfGunKindId, long esgGunTypeId, 
		long esfUserId,String code, long caneCaliber, int typology, String measures,boolean isFavoriteGun,long shooterId,
		String shooter_note, long gunUserId,ServiceContext serviceContext)
		throws PortalException, SystemException {


		ESFgunUser gunUser = new ESFgunUserImpl();
		ESFCane esfCane = getESFCane(esfCaneId);

		User user = UserLocalServiceUtil.getUser(userId);

		esfCane.setEsfUserId(esfUserId);
		esfCane.setEsfGunKindId(esfGunKindId);
		esfCane.setEsfUserId(esfUserId);
		esfCane.setCaneCaliber(caneCaliber);
		esfCane.setTypeId(typology);
		esfCane.setMeasures(measures);
		esfCane.setCode(code);
		esfCane.setIsFavoriteGun(isFavoriteGun);
		esfCane.setShooterId(shooterId);
		esfCane.setExpandoBridgeAttributes(serviceContext);
		

		esfCanePersistence.update(esfCane);
		
		gunUser = ESFgunUserLocalServiceUtil.fetchESFgunUser(gunUserId);
		
		if(Validator.isNotNull(gunUser)){
			gunUser.setEsfGunId(esfCaneId);
			gunUser.setEsfUserId(shooterId);
			gunUser.setCode(code);
			gunUser.setIsFavorite(isFavoriteGun);
			gunUser.setType(it.ethica.esf.util.ESFKeys.ESFGunType.CANE);
			gunUser.setNote(shooter_note);
			
			ESFgunUserLocalServiceUtil.updateESFgunUser(gunUser);
			
		}

		return esfCane;
	}

	
	public ESFCane deleteESFCane(long esfCaneId, ServiceContext serviceContext)
					throws PortalException, SystemException {

					ESFCane esfCane = getESFCane(esfCaneId);


					esfCane = deleteESFCane(esfCaneId);

					return esfCane;
				}
	
	/**
	 * Ricerca tutti gli oggetti ESFCane sulla base dell'utente.
	 * 
	 * @param esfUserId l'identificativo dell'utente
	 * @return List<ESFCane> 
	 */
	public List<ESFCane> getESFCanesByUserId(long esfUserId)
		throws SystemException {

		return esfCanePersistence.findByEsfUserId(esfUserId);
	}

	/**
	 * Ricerca tutti gli oggetti ESFCane sulla base dell'utente.
	 * I parametri di <b>start</b> e <b>end</b> definiscono il range di oggetti da restituire
	 * 
	 * @param esfUserId l'identificativo dell'utente
	 * @param start
	 * @param end
	 * @return List<ESFCane> 
	 */
	public List<ESFCane> getESFCanesByUserId(long esfUserId, int start, int end)
		throws SystemException {

		return esfCanePersistence.findByEsfUserId(esfUserId, start, end);
	}

	/**
	 * Ricerca tutti gli oggetti ESFCane.
	 * I parametri di <b>start</b> e <b>end</b> definiscono il range di oggetti da restituire
	 * 
	 * @return List<ESFCane> 
	 */
	public List<ESFCane> getESFCanes()
		throws SystemException {

		return esfCanePersistence.findAll();
	}

	/**
	 * Ricerca tutti gli oggetti ESFCane.
	 * I parametri di <b>start</b> e <b>end</b> definiscono il range di oggetti da restituire
	 * 
	 * @return List<ESFCane> 
	 */
	public List<ESFCane> getESFCanes(int start, int end)
		throws SystemException {

		return esfCanePersistence.findAll(start, end);
	}
	
	/**
	 * Ricerca tutti gli oggetti ESFCane sulla base del codice e della tipologia
	 * dell'arma.
	 * Il parametro <b>code</b> e' in LIKE mentre il <b>esfGunKindId</b> e' in equal.
	 * 
	 * @param code il codice dell'arma
	 * @param esfGunKindId l'identificativo del tipo di arma
	 * @return List<ESFCane> 
	 */
	public List<ESFCane> getESFCaneByLikeC_K(String code, long esfGunKindId) {

		List<ESFCane> esfCannes = new ArrayList<ESFCane>();

		try {

			DynamicQuery caneQuery =
				DynamicQueryFactoryUtil.forClass(
					ESFCane.class, "caneQuery",
					PortletClassLoaderUtil.getClassLoader());

			if (esfGunKindId != 0) {
				caneQuery.add(RestrictionsFactoryUtil.and(
					PropertyFactoryUtil.forName("caneQuery.code").like(
						StringPool.PERCENT + code + StringPool.PERCENT),
					PropertyFactoryUtil.forName("caneQuery.esfGunKindId").eq(
						esfGunKindId)));
			}
			else {
				caneQuery.add(PropertyFactoryUtil.forName("caneQuery.code").like(
					StringPool.PERCENT + code + StringPool.PERCENT));
			}

			esfCannes = ESFCaneLocalServiceUtil.dynamicQuery(caneQuery);

		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return esfCannes;
	}

	
	/**
	 * Ricerca tutti gli oggetti ESFCane sulla base del codice e della tipologia
	 * dell'arma.
	 * Il parametro <b>code</b> e' in LIKE mentre il <b>esfGunKindId</b> e' in equal.
	 * I parametri di <b>start</b> e <b>end</b> definiscono il range di oggetti da restituire.
	 * 
	 * @param code il codice dell'arma
	 * @param esfGunKindId l'identificativo del tipo di arma
	 * @param start
	 * @param end
	 * @return List<ESFCane> 
	 */
	public List<ESFCane> getESFCaneByLikeC_K(
		String code, long esfGunKindId, int start, int end) {

		List<ESFCane> esfCannes = new ArrayList<ESFCane>();

		try {

			DynamicQuery caneQuery =
				DynamicQueryFactoryUtil.forClass(
					ESFCane.class, "caneQuery",
					PortletClassLoaderUtil.getClassLoader());

			if (esfGunKindId != 0) {
				caneQuery.add(RestrictionsFactoryUtil.and(
					PropertyFactoryUtil.forName("caneQuery.code").like(
						StringPool.PERCENT + code + StringPool.PERCENT),
					PropertyFactoryUtil.forName("caneQuery.esfGunKindId").eq(
						esfGunKindId)));
			}
			else {
				caneQuery.add(PropertyFactoryUtil.forName("caneQuery.code").like(
					StringPool.PERCENT + code + StringPool.PERCENT));
			}

			esfCannes = ESFCaneLocalServiceUtil.dynamicQuery(caneQuery, start, end);

		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return esfCannes;
	}

	
	/**
	 * Ricerca tutti gli oggetti ESFCane sulla base del codice dell'arma, della tipologia
	 * dell'arma e dell'utente.
	 * Il parametro <b>code</b> e' in LIKE mentre il <b>esfGunKindId</b> e il <b>esfUserId</b>
	 * e' in equal.
	 * 
	 * @param code il codice dell'arma
	 * @param esfGunKindId l'identificativo del tipo di arma
	 * @param esfUserId l'identificativo dell'utente
	 * @return List<ESFCane> 
	 */
	public List<ESFCane> getESFGunByLikeC_K_U(
		String code, long esfGunKindId, long esfUserId) {

		List<ESFCane> esfCannes = new ArrayList<ESFCane>();

		try {

			DynamicQuery caneQuery =
				DynamicQueryFactoryUtil.forClass(
					ESFCane.class, "caneQuery",
					PortletClassLoaderUtil.getClassLoader());

			if (esfGunKindId != 0) {
				caneQuery.add(RestrictionsFactoryUtil.and(
					PropertyFactoryUtil.forName("caneQuery.code").like(
						StringPool.PERCENT + code + StringPool.PERCENT),
					PropertyFactoryUtil.forName("caneQuery.esfGunKindId").eq(
						esfGunKindId)));
			}
			else {
				caneQuery.add(PropertyFactoryUtil.forName("caneQuery.code").like(
					StringPool.PERCENT + code + StringPool.PERCENT));
			}

			caneQuery.add(PropertyFactoryUtil.forName("caneQuery.esfUserId").like(
				esfUserId));

			esfCannes = ESFCaneLocalServiceUtil.dynamicQuery(caneQuery);

		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return esfCannes;
	}
	
	
	/**
	 * Ricerca tutti gli oggetti ESFCane sulla base del codice dell'arma, della tipologia
	 * dell'arma e dell'utente.
	 * Il parametro <b>code</b> e' in LIKE mentre il <b>esfGunKindId</b> e il <b>esfUserId</b>
	 * e' in equal.
	 * I parametri di <b>start</b> e <b>end</b> definiscono il range di oggetti da restituire.
	 * 
	 * @param code il codice dell'arma
	 * @param esfGunKindId l'identificativo del tipo di arma
	 * @param esfUserId l'identificativo dell'utente
	 * @param start
	 * @param end
	 * @return List<ESFCane> 
	 */
	public List<ESFCane> getESFGunByLikeC_K_U(
		String code, long esfGunKindId, long esfUserId, int start, int end) {

		List<ESFCane> esfCannes = new ArrayList<ESFCane>();

		try {

			DynamicQuery caneQuery =
				DynamicQueryFactoryUtil.forClass(
					ESFCane.class, "caneQuery",
					PortletClassLoaderUtil.getClassLoader());

			if (esfGunKindId != 0) {
				caneQuery.add(RestrictionsFactoryUtil.and(
					PropertyFactoryUtil.forName("caneQuery.code").like(
						StringPool.PERCENT + code + StringPool.PERCENT),
					PropertyFactoryUtil.forName("caneQuery.esfGunKindId").eq(
						esfGunKindId)));
			}
			else {
				caneQuery.add(PropertyFactoryUtil.forName("caneQuery.code").like(
					StringPool.PERCENT + code + StringPool.PERCENT));
			}

			caneQuery.add(PropertyFactoryUtil.forName("caneQuery.esfUserId").like(
				esfUserId));
			
			esfCannes = ESFCaneLocalServiceUtil.dynamicQuery(caneQuery, start, end);

		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return esfCannes;
	}
	
/*
 * ricerca canne tramite tipo modello e codice
 */
	public List<ESFCane> getESFGunByLikeT_C_K_U(long esfGunTypeId,
			String code, long esfGunKindId, long esfUserId, int start, int end) {

			List<ESFCane> esfCannes = new ArrayList<ESFCane>();
			List<ESFCane> esfCannesreturns = new ArrayList<ESFCane>();
			ESFGunKind kind = new ESFGunKindImpl();
			
			try {

				DynamicQuery caneQuery =
					DynamicQueryFactoryUtil.forClass(
						ESFCane.class, "caneQuery",
						PortletClassLoaderUtil.getClassLoader());

				if (esfGunKindId != 0) {
					caneQuery.add(RestrictionsFactoryUtil.and(
						PropertyFactoryUtil.forName("caneQuery.code").like(
							StringPool.PERCENT + code + StringPool.PERCENT),
						PropertyFactoryUtil.forName("caneQuery.esfGunKindId").eq(
							esfGunKindId)));
				}
				else {
					caneQuery.add(PropertyFactoryUtil.forName("caneQuery.code").like(
						StringPool.PERCENT + code + StringPool.PERCENT));
				}
				esfCannes = ESFCaneLocalServiceUtil.dynamicQuery(caneQuery);
				
				
				if(Validator.isNotNull(esfCannes)){
					for(ESFCane esfCanne: esfCannes){
						kind = ESFGunKindLocalServiceUtil.fetchESFGunKind(esfCanne.getEsfGunKindId());
						if(Validator.isNotNull(kind) && esfGunTypeId == kind.getEsfGunTypeId()){
							esfCannesreturns.add(esfCanne);
						}
					}
				}

			}
			catch (Exception e) {
				e.printStackTrace();
			}
			
			if(end > esfCannesreturns.size()){
				end = esfCannesreturns.size();
			}
			esfCannesreturns=esfCannesreturns.subList(start, end);
			return esfCannesreturns;
		}
	
	
	public int countESFGunByLikeT_C_K_U(long esfGunTypeId,
			String code, long esfGunKindId, long esfUserId) {

			List<ESFCane> esfCannes = new ArrayList<ESFCane>();
			List<ESFCane> esfCannesreturns = new ArrayList<ESFCane>();
			ESFGunKind kind = new ESFGunKindImpl();
			int tot = 0;
			try {

				DynamicQuery caneQuery =
					DynamicQueryFactoryUtil.forClass(
						ESFCane.class, "caneQuery",
						PortletClassLoaderUtil.getClassLoader());

				if (esfGunKindId != 0) {
					caneQuery.add(RestrictionsFactoryUtil.and(
						PropertyFactoryUtil.forName("caneQuery.code").like(
							StringPool.PERCENT + code + StringPool.PERCENT),
						PropertyFactoryUtil.forName("caneQuery.esfGunKindId").eq(
							esfGunKindId)));
				}
				else {
					caneQuery.add(PropertyFactoryUtil.forName("caneQuery.code").like(
						StringPool.PERCENT + code + StringPool.PERCENT));
				}
				esfCannes = ESFCaneLocalServiceUtil.dynamicQuery(caneQuery);
				
				
				if(Validator.isNotNull(esfCannes)){
					for(ESFCane esfCanne: esfCannes){
						kind = ESFGunKindLocalServiceUtil.fetchESFGunKind(esfCanne.getEsfGunKindId());
						if(Validator.isNotNull(kind) && esfGunTypeId == kind.getEsfGunTypeId()){
							esfCannesreturns.add(esfCanne);
						}
					}
				}
				tot = esfCannesreturns.size();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			
			
			return tot;
		}
	
	
	/*
	 * ricerca canne tramite tipo modello 
	 */
	public List<ESFCane> getESFGunByLikeT_K(long esfGunTypeId,
			 long esfGunKindId, int start, int end) throws SystemException {

			List<ESFCane> esfCannes = new ArrayList<ESFCane>();
			List<ESFCane> esfCannesreturns = new ArrayList<ESFCane>();
			List<ESFGun> gunsK = new ArrayList<ESFGun>();
			List<ESFGun> gunsT = new ArrayList<ESFGun>();
			ESFGunKind kind = new ESFGunKindImpl();
			List<Long> caneId = new ArrayList<Long>();
			
			esfCannes = ESFCaneLocalServiceUtil.getESFCanes();
			
			
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
			
			for(ESFGun a : gunsT){
				caneId.add(a.getEsfGunId());
			}
			for(ESFCane c  : esfCannes){
				if(caneId.contains(c.getEsfGunKindId()) ){
					esfCannesreturns.add(c);
				}
			}
			
			if(end > esfCannesreturns.size()){
				end = esfCannesreturns.size();
			}
			esfCannesreturns=esfCannesreturns.subList(start, end);
			return esfCannesreturns;
		}
	
	public int countESFGunByLikeT_K(long esfGunTypeId, long esfGunKindId) throws SystemException {
			int tot = 0;
			List<ESFCane> esfCannes = new ArrayList<ESFCane>();
			List<ESFCane> esfCannesreturns = new ArrayList<ESFCane>();
			List<ESFGun> gunsK = new ArrayList<ESFGun>();
			List<ESFGun> gunsT = new ArrayList<ESFGun>();
			ESFGunKind kind = new ESFGunKindImpl();
			List<Long> caneId = new ArrayList<Long>();
			
			esfCannes = ESFCaneLocalServiceUtil.getESFCanes();
			
			
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
			
			for(ESFGun a : gunsT){
				caneId.add(a.getEsfGunId());
			}
			for(ESFCane c  : esfCannes){
				if(caneId.contains(c.getEsfGunKindId()) ){
					esfCannesreturns.add(c);
				}
			}
			
			tot = esfCannesreturns.size();
			return tot;
		}
	
	
	/*
	 * Ricerca canne tramite MArca canne
	 * (non-Javadoc)
	 * @see it.ethica.esf.service.ESFCaneLocalService#getFullName(it.ethica.esf.model.ESFCane)
	 */
	public List<ESFCane> getESFGunByLikeT(long esfGunTypeId,
			  int start, int end) throws SystemException {
		
		List<ESFCane> canes = new ArrayList<ESFCane>();
		List<ESFCane> allCanes = new ArrayList<ESFCane>();
		ESFGunKind gunKind = new ESFGunKindImpl();
		
		allCanes = ESFCaneLocalServiceUtil.getESFCanes();
		
		if(esfGunTypeId > 0){
			
			for(ESFCane c : allCanes){
				gunKind = ESFGunKindLocalServiceUtil.fetchESFGunKind(c.getEsfGunKindId());
				if(gunKind.getEsfGunTypeId() == esfGunTypeId){
					canes.add(c);
				}
			}
			
		}else{
			canes = allCanes;
		}
		if(end > canes.size()){
			end = canes.size();
		}
		
		return canes.subList(start, end);
	}
	
	
	public int countESFGunByLikeT(long esfGunTypeId)
			throws SystemException {
		int tot = 0;
		List<ESFCane> canes = new ArrayList<ESFCane>();
		List<ESFCane> allCanes = new ArrayList<ESFCane>();
		ESFGunKind gunKind = new ESFGunKindImpl();
		
		allCanes = ESFCaneLocalServiceUtil.getESFCanes();
		
		if(esfGunTypeId > 0){
			
			for(ESFCane c : allCanes){
				gunKind = ESFGunKindLocalServiceUtil.fetchESFGunKind(c.getEsfGunKindId());
				if(gunKind.getEsfGunTypeId() == esfGunTypeId){
					canes.add(c);
				}
			}
			
		}else{
			canes = allCanes;
		}
		
		tot = canes.size();
		return tot;
		
	}
	
	/*
	 * (non-Javadoc)
	 * @see it.ethica.esf.service.ESFCaneLocalService#getFullName(it.ethica.esf.model.ESFCane)
	 */
	public String getFullName(ESFCane esfCane)
					throws PortalException, SystemException {

					return getAssetName(esfCane.getEsfGunKindId());
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
	public String getNameMod(ESFCane esfCane) throws PortalException, SystemException{
		ESFGunKind esfGunKind =
						esfGunKindLocalService.getESFGunKind(esfCane.getEsfGunKindId());
		return esfGunKind.getName();
	}
	
	public String getNameM(ESFCane esfCane) throws PortalException, SystemException{
		ESFGunKind esfGunKind =
						esfGunKindLocalService.getESFGunKind(esfCane.getEsfGunKindId());
					ESFGunType esfGunType =
						esfGunTypeLocalService.getESFGunType(esfGunKind.getEsfGunTypeId());
		return esfGunType.getName();
	}
	
	public String getNameT(ESFCane esfCane) throws PortalException, SystemException{
		ListType type=ListTypeServiceUtil.getListType(esfCane.getTypeId());
			
			return type.getName();
	}
	
	public ESFCane checkCode(String code, ServiceContext serviceContext)
					throws PortalException, SystemException {

					if (Validator.isNotNull(code) && !Validator.isBlank(code)) {
						return esfCanePersistence.fetchByCode(code);
					}
					return null;
	}
	
	public List<ESFCane> getCanebyK(long gunKindId) throws SystemException{
		
		List<ESFCane> canes = new ArrayList<ESFCane>();
		
		canes = esfCanePersistence.findByEsfGunKindId(gunKindId);
		
		return canes;
	}
	
	public List<ESFCane> getCanebyKindId(long gunKindId, int start, int end) throws SystemException{
		
		List<ESFCane> canes = new ArrayList<ESFCane>();
		
		canes = esfCanePersistence.findByEsfGunKindId(gunKindId);
		if(end > canes.size()){
			end = canes.size();
		}
		
		return canes.subList(start, end);
	}
	
	public int countCanebyKindId(long gunKindId) throws SystemException{
		
		int tot = 0 ;
		List<ESFCane> canes = new ArrayList<ESFCane>();
		
		canes = esfCanePersistence.findByEsfGunKindId(gunKindId);
		tot = canes.size();

		return tot;
	}

}