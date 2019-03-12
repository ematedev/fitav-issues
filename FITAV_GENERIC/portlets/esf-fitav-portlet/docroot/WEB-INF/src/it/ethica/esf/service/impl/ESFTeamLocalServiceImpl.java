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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ServiceContext;

import it.ethica.esf.model.ESFTeam;
import it.ethica.esf.service.base.ESFTeamLocalServiceBaseImpl;

/**
 * The implementation of the e s f team local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link it.ethica.esf.service.ESFTeamLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Ethica
 * @see it.ethica.esf.service.base.ESFTeamLocalServiceBaseImpl
 * @see it.ethica.esf.service.ESFTeamLocalServiceUtil
 */
public class ESFTeamLocalServiceImpl extends ESFTeamLocalServiceBaseImpl {
	
	public List<ESFTeam> getAllEsfTeam() throws SystemException{
		return esfTeamPersistence.findAll();
	}
	
	public List<ESFTeam> findByTournament(long esfTournamentId) throws SystemException{
		return esfTeamPersistence.findByTournament(esfTournamentId);
	}
	
	public ESFTeam addESFTeam(long userId, String name, long esfTournamentId,
		ServiceContext serviceContext) throws SystemException{
		
		long esfTeamId = counterLocalService.increment();
		ESFTeam esfTeam = esfTeamPersistence.create(esfTeamId);
		
		esfTeam.setEsfTournamentId(esfTournamentId);
		esfTeam.setName(name);
		
		return esfTeamPersistence.update(esfTeam);
	}
	
	public ESFTeam updateESFTeam(long userId, long esfTeamId, String name, long esfTournamentId,
		ServiceContext serviceContext) throws SystemException, PortalException{
		
		ESFTeam esfTeam = getESFTeam(esfTeamId);
		
		esfTeam.setName(name);
		
		return esfTeamPersistence.update(esfTeam);
	}
	
	public ESFTeam deleteESFTeam(long esfTeamId) throws SystemException, PortalException{
		
		ESFTeam esfTeam = getESFTeam(esfTeamId);
		
		return esfTeamPersistence.remove(esfTeam);
	}
}