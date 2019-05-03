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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;

import it.ethica.esf.NoSuchShooterQualificationException;
import it.ethica.esf.model.ESFShooterQualification;
import it.ethica.esf.model.ESFShooterQualificationESFMatch;
import it.ethica.esf.model.ESFShooterQualificationESFTournament;
import it.ethica.esf.model.ESFSportType;
import it.ethica.esf.service.base.ESFShooterQualificationLocalServiceBaseImpl;

/**
 * The implementation of the e s f shooter qualification local service. <p> All
 * custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link it.ethica.esf.service.ESFShooterQualificationLocalService} interface.
 * <p> This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM. </p>
 *
 * @author Ethica
 * @see it.ethica.esf.service.base.ESFShooterQualificationLocalServiceBaseImpl
 * @see it.ethica.esf.service.ESFShooterQualificationLocalServiceUtil
 */
public class ESFShooterQualificationLocalServiceImpl
	extends ESFShooterQualificationLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS: Never reference this interface directly. Always use
	 * {@link it.ethica.esf.service.ESFShooterQualificationLocalServiceUtil} to
	 * access the e s f shooter qualification local service.
	 */

	public List<ESFShooterQualification> getESFShooterQualifications()
		throws SystemException {

		return esfShooterQualificationPersistence.findAll();
	}
	public List<ESFShooterQualification> getESFShooterQualifications(
		int start, int end)
		throws SystemException {

		return esfShooterQualificationPersistence.findAll(start, end);
	}

	public List<ESFShooterQualification> getESFShooterCategories(
		long esfTournamentId)
		throws SystemException, NoSuchShooterQualificationException {

		List<ESFShooterQualification> esfShooterCategories =
			new ArrayList<ESFShooterQualification>();

		List<ESFShooterQualificationESFTournament> esfShooterQualificationESFTournaments =
			esfShooterQualificationESFTournamentPersistence.findByESFTournament(esfTournamentId);

		for (ESFShooterQualificationESFTournament esfShooterQualificationESFTournament : esfShooterQualificationESFTournaments) {

			long esfShooterQualificationId =
				esfShooterQualificationESFTournament.getEsfShooterQualificationId();

			esfShooterCategories.add(esfShooterQualificationPersistence.findByPrimaryKey(esfShooterQualificationId));
		}

		return esfShooterCategories;
	}

	public List<ESFShooterQualification> findByMatchId(long esfMatchId)
		throws SystemException, NoSuchShooterQualificationException {

		List<ESFShooterQualification> esfShooterQualifications =
			new ArrayList<ESFShooterQualification>();

		List<ESFShooterQualificationESFMatch> esfShooterQualificationESFMatchs =
			esfShooterQualificationESFMatchPersistence.findByESFMatch(esfMatchId);
		for (ESFShooterQualificationESFMatch esfShooterQualificationESFMatch : esfShooterQualificationESFMatchs) {
			long esfShooterQualificationId =
				esfShooterQualificationESFMatch.getEsfShooterQualificationId();
			esfShooterQualifications.add(esfShooterQualificationPersistence.findByPrimaryKey(esfShooterQualificationId));

		}

		return esfShooterQualifications;
	}

	public ESFShooterQualification addESFShooterQualification(
		long userId, String name, String description, String code, ServiceContext serviceContext)
		throws SystemException, PortalException {

		long groupId = serviceContext.getScopeGroupId();

		User user = userPersistence.findByPrimaryKey(userId);

		Date now = new Date();

		long esfShooterQualificationId = counterLocalService.increment();

		ESFShooterQualification esfShooterQualification =
			esfShooterQualificationPersistence.create(esfShooterQualificationId);

		esfShooterQualification.setUserId(userId);
		esfShooterQualification.setGroupId(groupId);
		esfShooterQualification.setCompanyId(user.getCompanyId());
		esfShooterQualification.setUserName(user.getFullName());
		esfShooterQualification.setCreateDate(serviceContext.getCreateDate(now));
		esfShooterQualification.setModifiedDate(serviceContext.getModifiedDate(now));

		esfShooterQualification.setName(name);
		esfShooterQualification.setDescription(description);
		esfShooterQualification.setCode(code);
		esfShooterQualificationPersistence.update(esfShooterQualification);

		/*resourceLocalService.addResources(
			user.getCompanyId(), groupId, userId,
			ESFShooterQualification.class.getName(), esfShooterQualificationId,
			false, true, true);*/

		return esfShooterQualification;
	}

	public ESFShooterQualification updateESFShooterQualification(
		long esfShooterQualificationId, String name, String description, String code,
		ServiceContext serviceContext)
		throws SystemException, PortalException {

		Date now = new Date();

		ESFShooterQualification esfShooterQualification =
			getESFShooterQualification(esfShooterQualificationId);

		esfShooterQualification.setModifiedDate(serviceContext.getModifiedDate(now));

		esfShooterQualification.setName(name);
		esfShooterQualification.setDescription(description);
		esfShooterQualification.setCode(code);
		esfShooterQualificationPersistence.update(esfShooterQualification);

		resourceLocalService.updateResources(
			serviceContext.getCompanyId(), serviceContext.getScopeGroupId(),
			ESFShooterQualification.class.getName(), esfShooterQualificationId,
			serviceContext.getGroupPermissions(),
			serviceContext.getGuestPermissions());

		return esfShooterQualification;
	}

	public ESFShooterQualification deleteESFShooterQualification(
		long esfShooterQualificationId, ServiceContext serviceContext)
		throws PortalException, SystemException {

		ESFShooterQualification esfShooterQualification =
			getESFShooterQualification(esfShooterQualificationId);

		resourceLocalService.deleteResource(
			serviceContext.getCompanyId(),
			ESFShooterQualification.class.getName(),
			ResourceConstants.SCOPE_INDIVIDUAL, esfShooterQualificationId);

		esfShooterQualification =
			deleteESFShooterQualification(esfShooterQualificationId);

		return esfShooterQualification;
	}
	public long findIDQualificationByCode(String code) throws Exception
	{
		List<ESFShooterQualification> esf=esfShooterQualificationPersistence.findByCode(code);
		if(esf== null)
			return 0;
		else
			return esf.get(0).getEsfShooterQualificationId();
		
	}
}
