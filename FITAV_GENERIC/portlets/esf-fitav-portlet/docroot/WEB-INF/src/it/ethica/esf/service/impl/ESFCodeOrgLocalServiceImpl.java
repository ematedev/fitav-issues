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

import com.liferay.portal.kernel.exception.SystemException;

import it.ethica.esf.NoSuchCodeOrgException;
import it.ethica.esf.model.ESFCodeOrg;
import it.ethica.esf.service.base.ESFCodeOrgLocalServiceBaseImpl;

/**
 * The implementation of the e s f code org local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link it.ethica.esf.service.ESFCodeOrgLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Ethica
 * @see it.ethica.esf.service.base.ESFCodeOrgLocalServiceBaseImpl
 * @see it.ethica.esf.service.ESFCodeOrgLocalServiceUtil
 */
public class ESFCodeOrgLocalServiceImpl extends ESFCodeOrgLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link it.ethica.esf.service.ESFCodeOrgLocalServiceUtil} to access the e s f code org local service.
	 */
	
	public ESFCodeOrg findESFCodeOrgByN_C(String className, String code) throws NoSuchCodeOrgException, SystemException{
		
		return esfCodeOrgPersistence.fetchByN_C(className, code);
	}
	
	public ESFCodeOrg addESFCode(String className, String code, long sequence) throws NoSuchCodeOrgException, SystemException{
		
		long esfCodeOrgId = counterLocalService.increment();
		
		ESFCodeOrg esfCodeOrg = esfCodeOrgPersistence.create(esfCodeOrgId);
		
		esfCodeOrg.setCode(code);
		esfCodeOrg.setClassName(className);
		esfCodeOrg.setSequence(sequence);
		
		esfCodeOrgPersistence.update(esfCodeOrg);
		
		return esfCodeOrg;
	}
	
	public ESFCodeOrg updateESFCode(long esfCodeOrgId, long sequence) throws NoSuchCodeOrgException, SystemException{
		
		ESFCodeOrg esfCodeOrg = esfCodeOrgPersistence.fetchByPrimaryKey(esfCodeOrgId);
		
		esfCodeOrg.setSequence(sequence);
		
		esfCodeOrgPersistence.update(esfCodeOrg);
		
		return esfCodeOrg;
	}
}