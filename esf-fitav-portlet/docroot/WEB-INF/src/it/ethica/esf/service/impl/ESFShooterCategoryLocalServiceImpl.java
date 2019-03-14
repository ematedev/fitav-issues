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

import it.ethica.esf.NoSuchShooterCategoryException;
import it.ethica.esf.model.ESFShooterCategory;
import it.ethica.esf.model.ESFShooterCategoryESFMatch;
import it.ethica.esf.model.ESFShooterCategoryESFTournament;
import it.ethica.esf.service.base.ESFShooterCategoryLocalServiceBaseImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;

/**
 * The implementation of the e s f shooter category local service. <p> All
 * custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link it.ethica.esf.service.ESFShooterCategoryLocalService} interface. <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM. </p>
 *
 * @author Ethica
 * @see it.ethica.esf.service.base.ESFShooterCategoryLocalServiceBaseImpl
 * @see it.ethica.esf.service.ESFShooterCategoryLocalServiceUtil
 */
public class ESFShooterCategoryLocalServiceImpl
	extends ESFShooterCategoryLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS: Never reference this interface directly. Always use
	 * {@link it.ethica.esf.service.ESFShooterCategoryLocalServiceUtil} to
	 * access the e s f shooter category local service.
	 */

	public List<ESFShooterCategory> getESFShooterCategories()
		throws SystemException {

		return esfShooterCategoryPersistence.findAll();
	}

	public List<ESFShooterCategory> getESFShooterCategories(int start, int end)
		throws SystemException {

		return esfShooterCategoryPersistence.findAll(start, end);
	}

	public List<ESFShooterCategory> getESFShooterCategories(long esfTournamentId)
		throws SystemException, NoSuchShooterCategoryException {

		List<ESFShooterCategory> esfShooterCategories =
			new ArrayList<ESFShooterCategory>();

		List<ESFShooterCategoryESFTournament> esfShooterCategoryESFTournaments =
			esfShooterCategoryESFTournamentPersistence.findByESFTournament(esfTournamentId);

		for (ESFShooterCategoryESFTournament esfShooterCategoryESFTournament : esfShooterCategoryESFTournaments) {

			long esfShooterCategoryId =
				esfShooterCategoryESFTournament.getEsfShooterCategoryId();

			esfShooterCategories.add(esfShooterCategoryPersistence.findByPrimaryKey(esfShooterCategoryId));
		}

		return esfShooterCategories;
	}

	public List<ESFShooterCategory> findByMatchId(long esfMatchId)
		throws SystemException, NoSuchShooterCategoryException {

		List<ESFShooterCategory> esfShooterCategories =
			new ArrayList<ESFShooterCategory>();

		List<ESFShooterCategoryESFMatch> esfShooterCategoryESFMatchs =
			esfShooterCategoryESFMatchPersistence.findByESFMatch(esfMatchId);
		for (ESFShooterCategoryESFMatch esfShooterCategoryESFMatch : esfShooterCategoryESFMatchs) {
			long esfShooterCategoryId =
				esfShooterCategoryESFMatch.getEsfShooterCategoryId();
			esfShooterCategories.add(esfShooterCategoryPersistence.findByPrimaryKey(esfShooterCategoryId));

		}

		return esfShooterCategories;
	}

	public ESFShooterCategory addESFShooterCategory(
		long userId, String name, String description, String code, ServiceContext serviceContext)
		throws SystemException, PortalException {

		long groupId = serviceContext.getScopeGroupId();

		User user = userPersistence.findByPrimaryKey(userId);

		Date now = new Date();

		long esfShooterCategoryId = counterLocalService.increment();

		ESFShooterCategory esfShooterCategory =
			esfShooterCategoryPersistence.create(esfShooterCategoryId);

		esfShooterCategory.setUserId(userId);
		esfShooterCategory.setGroupId(groupId);
		esfShooterCategory.setCompanyId(user.getCompanyId());
		esfShooterCategory.setUserName(user.getFullName());
		esfShooterCategory.setCreateDate(serviceContext.getCreateDate(now));
		esfShooterCategory.setModifiedDate(serviceContext.getModifiedDate(now));

		esfShooterCategory.setName(name);
		esfShooterCategory.setDescription(description);
		esfShooterCategory.setCode(code);

		esfShooterCategoryPersistence.update(esfShooterCategory);

		resourceLocalService.addResources(
			user.getCompanyId(), groupId, userId,
			ESFShooterCategory.class.getName(), esfShooterCategoryId, false,
			true, true);

		return esfShooterCategory;
	}

	public ESFShooterCategory updateESFShooterCategory(
		long esfShooterCategoryId, String name, String description, String code, ServiceContext serviceContext)
		throws SystemException, PortalException {

		Date now = new Date();

		ESFShooterCategory esfShooterCategory =
			getESFShooterCategory(esfShooterCategoryId);

		esfShooterCategory.setModifiedDate(serviceContext.getModifiedDate(now));

		esfShooterCategory.setName(name);
		esfShooterCategory.setDescription(description);
		esfShooterCategory.setCode(code);
		esfShooterCategoryPersistence.update(esfShooterCategory);

		resourceLocalService.updateResources(
			serviceContext.getCompanyId(), serviceContext.getScopeGroupId(),
			ESFShooterCategory.class.getName(), esfShooterCategoryId,
			serviceContext.getGroupPermissions(),
			serviceContext.getGuestPermissions());

		return esfShooterCategory;
	}

	public ESFShooterCategory deleteESFShooterCategory(
		long esfShooterCategoryId, ServiceContext serviceContext)
		throws PortalException, SystemException {

		ESFShooterCategory esfShooterCategory =
			getESFShooterCategory(esfShooterCategoryId);

		resourceLocalService.deleteResource(
			serviceContext.getCompanyId(), ESFShooterCategory.class.getName(),
			ResourceConstants.SCOPE_INDIVIDUAL, esfShooterCategoryId);

		esfShooterCategory = deleteESFShooterCategory(esfShooterCategoryId);

		return esfShooterCategory;
	}
	public long findIDCategoryByName(String name) throws Exception
	{
		long esfCategoryId=0;
		List<ESFShooterCategory> allESFShooterCategories = esfShooterCategoryPersistence.findAll();
		for(ESFShooterCategory cat:allESFShooterCategories)
		{
			String nameCat = cat.getName();
			if(nameCat.equalsIgnoreCase(name));
				return cat.getPrimaryKey();
			
		}
		return esfCategoryId;
		
	}
	public long findIDCategoryByCode(String code) throws Exception
	{
		//List<ESFShooterCategory> esf = esfShooterCategoryPersistence.findByCode(code);
		ESFShooterCategory esf = esfShooterCategoryPersistence.findByCode(code);
		
		if(esf==null)
			return 0;
		else
			return esf.getEsfShooterCategoryId();
		
	}
}
