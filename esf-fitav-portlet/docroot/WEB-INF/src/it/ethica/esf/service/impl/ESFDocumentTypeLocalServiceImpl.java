/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
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

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.DateUtil;

import it.ethica.esf.model.ESFDocument;
import it.ethica.esf.model.ESFDocumentType;
import it.ethica.esf.service.ESFDocumentLocalServiceUtil;
import it.ethica.esf.service.base.ESFDocumentTypeLocalServiceBaseImpl;

/**
 * The implementation of the e s f document type local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link it.ethica.esf.service.ESFDocumentTypeLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Ethica
 * @see it.ethica.esf.service.base.ESFDocumentTypeLocalServiceBaseImpl
 * @see it.ethica.esf.service.ESFDocumentTypeLocalServiceUtil
 */
public class ESFDocumentTypeLocalServiceImpl extends ESFDocumentTypeLocalServiceBaseImpl {
	private static Log logger = LogFactoryUtil.getLog(ESFDocumentTypeLocalServiceBaseImpl.class);
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link it.ethica.esf.service.ESFDocumentTypeLocalServiceUtil} to access the e s f document type local service.
	 */
	
	public ESFDocumentType saveUpdateESFDocumentType(ESFDocumentType document) throws SystemException{
		ESFDocumentType result = null;
		boolean isUpdate = document.getEsfDocumentTypeId()>0;
		if(isUpdate){
			logger.debug("Aggiornamento del documento con ID: "+document.getEsfDocumentTypeId());
			result = this.fetchESFDocumentType(document.getEsfDocumentTypeId());
			result.setModifiedDate(DateUtil.newDate());
		}else{
			result = this.createESFDocumentType(document.getEsfDocumentTypeId());
//			result.setPrimaryKey(null);
			result.setCreateDate(DateUtil.newDate());
			result.setNew(true);
			logger.debug("Creazione del nuovo documento con ID: "+document.getEsfDocumentTypeId());
		}
		result.setDescription(document.getDescription());
		result.setExpirationMonthsNotice(document.getExpirationMonthsNotice());
//		esfDocumentTypePersistence.update(result);
		if(isUpdate){
			result = this.updateESFDocumentType(result);
		}else{
			result = this.addESFDocumentType(result);
		}		
		return result;
	}
	
	public List<ESFDocumentType> getUserFilteredList(long esfUserId) throws SystemException{
		//Leggo tutti i DocumentTypes esistenti
		List<ESFDocumentType> documentTypes = 
				this.getESFDocumentTypes(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		List<ESFDocumentType> userDocumentTypes = null;
		List<ESFDocument> userDocuments = null;
		List<Long> userDocumentTypeIds = new ArrayList<Long>();
		logger.debug("Verifico se l'utente "+esfUserId+" ha dei documenti associati");
		//Leggo i documenti già associati all'utente
		userDocuments = ESFDocumentLocalServiceUtil.findByesfUserId(esfUserId);
		if(userDocuments!=null && !userDocuments.isEmpty()){
			logger.debug("L'utente "+esfUserId+" ha "+userDocuments.size()+" documenti associati");
			//Scorro la lista e mi memorizzo gli id dei DocumentType già associato all'utente
			for(ESFDocument doc : userDocuments){
				userDocumentTypeIds.add(doc.getEsfDocumentTypeId());
			}
			userDocumentTypes = new ArrayList<ESFDocumentType>();
			for(ESFDocumentType type : documentTypes){
				//Se l'id su cui sto iterando non è presente nella lista dei DocumentType dell'utente 
				//allora lo aggiungo
				if(!userDocumentTypeIds.contains(type.getPrimaryKey())){
					userDocumentTypes.add(type);
				}
			}
		}else{
			logger.debug("L'utente "+esfUserId+" non ha documenti associati");
			//Se l'utente non ha documenti associati allora ritorno l'intera angrafica dei DocumentTypes
			userDocumentTypes = documentTypes;
		}
		logger.debug("DocumentType prima del filter: "+documentTypes.size()
			+"\tDocumentType dopo il filter: "+userDocumentTypes.size());
		return userDocumentTypes;
	}
}