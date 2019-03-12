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

import javax.portlet.ActionRequest;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ServiceContext;

import it.ethica.esf.NoSuchDescriptionException;
import it.ethica.esf.model.ESFDescription;
import it.ethica.esf.model.ESFMatch;
import it.ethica.esf.model.ESFNationalMatchResult;
import it.ethica.esf.service.ESFDescriptionLocalServiceUtil;
import it.ethica.esf.service.ESFMatchLocalServiceUtil;
import it.ethica.esf.service.base.ESFDescriptionLocalServiceBaseImpl;

/**
 * The implementation of the e s f description local service. <p> All custom
 * service methods should be put in this class. Whenever methods are added,
 * rerun ServiceBuilder to copy their definitions into the
 * {@link it.ethica.esf.service.ESFDescriptionLocalService} interface. <p> This
 * is a local service. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM. </p>
 *
 * @author Ethica
 * @see it.ethica.esf.service.base.ESFDescriptionLocalServiceBaseImpl
 * @see it.ethica.esf.service.ESFDescriptionLocalServiceUtil
 */
public class ESFDescriptionLocalServiceImpl
	extends ESFDescriptionLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS: Never reference this interface directly. Always use
	 * {@link it.ethica.esf.service.ESFDescriptionLocalServiceUtil} to access
	 * the e s f description local service.
	 */

	public List<ESFDescription> findAll()
		throws SystemException {

		return esfDescriptionPersistence.findAll();
	}

	public List<ESFDescription> findAllByNational(boolean isNational)
		throws SystemException {

		return esfDescriptionPersistence.findByIsNational(isNational);
	}
	
	public ESFDescription addEsfDescription(
			String name, boolean IsNational, ServiceContext serviceContext)
		throws SystemException {

		long esfDescriptionId = counterLocalService.increment();

		ESFDescription esfDescription =
			esfDescriptionPersistence.create(esfDescriptionId);

		esfDescription.setName(name);
		esfDescription.setIsNational(IsNational);

		esfDescription = esfDescriptionPersistence.update(esfDescription);

		return esfDescription;

	}

	public ESFDescription updateEsfDescription(
		long esfDescriptionId, String name,
		boolean IsNational,
		ServiceContext serviceContext)
		throws SystemException {

		ESFDescription esfDescription =
			esfDescriptionPersistence.fetchByPrimaryKey(esfDescriptionId);

		esfDescription.setName(name);
		esfDescription.setIsNational(IsNational);

		esfDescription = esfDescriptionPersistence.update(esfDescription);

		return esfDescription;

	}

	public ESFDescription deleteEsfDescription(
		long esfDescriptionId, ActionRequest request)
		throws SystemException, NoSuchDescriptionException {

		ESFDescription esfDescription =
			esfDescriptionPersistence.remove(esfDescriptionId);

		return esfDescription;

	}
	
	
	public List<ESFDescription> getESFDescriptionsByMatchUser(List<ESFNationalMatchResult> results) 
			throws PortalException, SystemException{
		List<Long> descr = new ArrayList<Long>();
		List<ESFDescription> descriptions = new ArrayList<ESFDescription>();
		
		for (ESFNationalMatchResult enmr : results ){
			ESFMatch match = ESFMatchLocalServiceUtil.getESFMatch(enmr.getEsfMatchId());
			descr.add(match.getDescription());
		}
		for (long id : descr){
			ESFDescription descri = ESFDescriptionLocalServiceUtil.fetchESFDescription(id);
			descriptions.add(descri);
		}
		return descriptions;
	}
}
