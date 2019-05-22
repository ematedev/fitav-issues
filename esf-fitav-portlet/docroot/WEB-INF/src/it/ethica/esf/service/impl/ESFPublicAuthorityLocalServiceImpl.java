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

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.DateUtil;

import it.ethica.esf.model.ESFDocumentType;
import it.ethica.esf.model.ESFPublicAuthority;
import it.ethica.esf.service.base.ESFDocumentTypeLocalServiceBaseImpl;
import it.ethica.esf.service.base.ESFPublicAuthorityLocalServiceBaseImpl;

/**
 * The implementation of the e s f public authority local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link it.ethica.esf.service.ESFPublicAuthorityLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Ethica
 * @see it.ethica.esf.service.base.ESFPublicAuthorityLocalServiceBaseImpl
 * @see it.ethica.esf.service.ESFPublicAuthorityLocalServiceUtil
 */
public class ESFPublicAuthorityLocalServiceImpl
	extends ESFPublicAuthorityLocalServiceBaseImpl {
	private static Log logger = LogFactoryUtil.getLog(ESFPublicAuthorityLocalServiceImpl.class);
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link it.ethica.esf.service.ESFPublicAuthorityLocalServiceUtil} to access the e s f public authority local service.
	 */
	
	public ESFPublicAuthority saveUpdateESFPublicAuthority(ESFPublicAuthority authority) throws SystemException{
		ESFPublicAuthority result = null;
		boolean isUpdate = authority.getEsfPublicAuthorityId()>0;
		if(isUpdate){
			logger.debug("Aggiornamento public authority con ID: "+authority.getEsfPublicAuthorityId());
			result = this.fetchESFPublicAuthority(authority.getEsfPublicAuthorityId());
			result.setModifiedDate(DateUtil.newDate());
		}else{
			result = this.createESFPublicAuthority(authority.getEsfPublicAuthorityId());
//			result.setPrimaryKey(null);
			result.setCreateDate(DateUtil.newDate());
			result.setNew(true);
			logger.debug("Creazione della public authority con ID: "+authority.getEsfPublicAuthorityId());
		}
		result.setDescription(authority.getDescription());
		if(isUpdate){
			result = this.updateESFPublicAuthority(result);
		}else{
			result = this.addESFPublicAuthority(result);
		}
		return result;
	}
}