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

import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;

import it.ethica.esf.model.ESFMatchResult;
import it.ethica.esf.service.base.ESFMatchResultLocalServiceBaseImpl;

/**
 * The implementation of the e s f match result local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link it.ethica.esf.service.ESFMatchResultLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Ethica
 * @see it.ethica.esf.service.base.ESFMatchResultLocalServiceBaseImpl
 * @see it.ethica.esf.service.ESFMatchResultLocalServiceUtil
 */
public class ESFMatchResultLocalServiceImpl
	extends ESFMatchResultLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link it.ethica.esf.service.ESFMatchResultLocalServiceUtil} to access the e s f match result local service.
	 */
	
	public List<ESFMatchResult> findbyEsfMatchId(long esfMatchId)
			throws SystemException {
		
		List<ESFMatchResult> matchResults = null;
		
		matchResults = esfMatchResultPersistence.findByEsfMatchId(esfMatchId);

		return matchResults;
	}
	
	
	public List<ESFMatchResult> findByResultUserId(long esfPartecipantId)
			throws SystemException {
			return esfMatchResultPersistence.findByResultUserId(esfPartecipantId);
	}
	
	public List<ESFMatchResult> findByResultUserId(long esfPartecipantId, long matchId)
					throws SystemException {
					return esfMatchResultPersistence.findBymatchId_PartecipantId(esfPartecipantId, matchId);
			}
}