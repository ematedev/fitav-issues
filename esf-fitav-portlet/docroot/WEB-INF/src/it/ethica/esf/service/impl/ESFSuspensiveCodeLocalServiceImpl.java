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

import com.liferay.portal.kernel.exception.SystemException;

import it.ethica.esf.model.ESFSuspensiveCode;
import it.ethica.esf.service.base.ESFSuspensiveCodeLocalServiceBaseImpl;

/**
 * The implementation of the e s f suspensive code local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link it.ethica.esf.service.ESFSuspensiveCodeLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Ethica
 * @see it.ethica.esf.service.base.ESFSuspensiveCodeLocalServiceBaseImpl
 * @see it.ethica.esf.service.ESFSuspensiveCodeLocalServiceUtil
 */
public class ESFSuspensiveCodeLocalServiceImpl
	extends ESFSuspensiveCodeLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link it.ethica.esf.service.ESFSuspensiveCodeLocalServiceUtil} to access the e s f suspensive code local service.
	 */
	
	
	public List<ESFSuspensiveCode> findAll(int start, int end) throws SystemException{
		
		List<ESFSuspensiveCode> spCd = new ArrayList<ESFSuspensiveCode>();
		spCd = esfSuspensiveCodePersistence.findAll(start, end);
		return spCd;
	}
	
	public int conutTotal() throws SystemException{
		
		int total=0;
		List<ESFSuspensiveCode> spCd = new ArrayList<ESFSuspensiveCode>();
		spCd = esfSuspensiveCodePersistence.findAll();
		return total = spCd.size();
	}
	
}