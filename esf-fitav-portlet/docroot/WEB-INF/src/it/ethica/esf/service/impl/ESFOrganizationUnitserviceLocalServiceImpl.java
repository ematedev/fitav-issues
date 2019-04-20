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

import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;

import it.ethica.esf.model.ESFOrganizationUnitservice;
import it.ethica.esf.service.base.ESFOrganizationUnitserviceLocalServiceBaseImpl;

/**
 * The implementation of the e s f organization unitservice local service. <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link it.ethica.esf.service.ESFOrganizationUnitserviceLocalService}
 * interface. <p> This is a local service. Methods of this service will not have
 * security checks based on the propagated JAAS credentials because this service
 * can only be accessed from within the same VM. </p>
 *
 * @author Ethica
 * @see it.ethica.esf.service.base.ESFOrganizationUnitserviceLocalServiceBaseImpl
 * @see it.ethica.esf.service.ESFOrganizationUnitserviceLocalServiceUtil
 */
public class ESFOrganizationUnitserviceLocalServiceImpl
	extends ESFOrganizationUnitserviceLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS: Never reference this interface directly. Always use
	 * {@link it.ethica.esf.service.ESFOrganizationUnitserviceLocalServiceUtil}
	 * to access the e s f organization unitservice local service.
	 */
	public List<ESFOrganizationUnitservice> getAllESFOrganizationUnitservices()
		throws SystemException {

		return esfOrganizationUnitservicePersistence.findAll();
	}

	public List<ESFOrganizationUnitservice> getAllESFOrganizationUnitservices(
		int start, int end)
		throws SystemException {

		return esfOrganizationUnitservicePersistence.findAll(start, end);
	}

	public List<ESFOrganizationUnitservice> getAllESFOrganizationUnitservices(
		long groupId)
		throws SystemException {

		return esfOrganizationUnitservicePersistence.findByGroupId(groupId);
	}

	public List<ESFOrganizationUnitservice> getAllESFOrganizationUnitservices(
		long groupId, int start, int end)
		throws SystemException {

		return esfOrganizationUnitservicePersistence.findByGroupId(
			groupId, start, end);
	}

	public int countByGroupId(long groupId)
		throws SystemException {

		return esfOrganizationUnitservicePersistence.countByGroupId(groupId);
	}

	public List<ESFOrganizationUnitservice> findByESFOrganizationId(
		long esfOrganizationId, int start, int end)
		throws SystemException {

		return esfOrganizationUnitservicePersistence.findByEsfOrganizationId(
			esfOrganizationId, start, end);
	}

	public List<ESFOrganizationUnitservice> findByESFOrganizationId(
		long esfOrganizationId)
		throws SystemException {

		return esfOrganizationUnitservicePersistence.findByEsfOrganizationId(esfOrganizationId);
	}

	public List<ESFOrganizationUnitservice> findByESFUnitserviceId(
		long esfUnitserviceId)
		throws SystemException {

		return esfOrganizationUnitservicePersistence.findByEsfUnitserviceId(esfUnitserviceId);
	}

	public ESFOrganizationUnitservice addESFOrganizationUnitservice(
		long userId, long esfOrganizationId, long esfUnitserviceId,
		long numberUnitservices, String description,
		ServiceContext serviceContext)
		throws SystemException, PortalException {

		long groupId = serviceContext.getScopeGroupId();

		User user = userPersistence.findByPrimaryKey(userId);

		Date now = new Date();

		long esfOrganizationUnitserviceId = counterLocalService.increment();

		ESFOrganizationUnitservice esfOrganizationUnitservice =
			esfOrganizationUnitservicePersistence.create(esfOrganizationUnitserviceId);

		esfOrganizationUnitservice.setUserId(userId);
		esfOrganizationUnitservice.setGroupId(groupId);
		esfOrganizationUnitservice.setCompanyId(user.getCompanyId());
		esfOrganizationUnitservice.setUserName(user.getFullName());
		esfOrganizationUnitservice.setCreateDate(serviceContext.getCreateDate(now));
		esfOrganizationUnitservice.setModifiedDate(serviceContext.getModifiedDate(now));
		esfOrganizationUnitservice.setExpandoBridgeAttributes(serviceContext);
		esfOrganizationUnitservice.setEsfOrganizationId(esfOrganizationId);
		esfOrganizationUnitservice.setEsfUnitserviceId(esfUnitserviceId);
		esfOrganizationUnitservice.setNumberUnitservices(numberUnitservices);
		esfOrganizationUnitservice.setDescription(description);

		esfOrganizationUnitservicePersistence.update(esfOrganizationUnitservice);

		return esfOrganizationUnitservice;
	}

	public ESFOrganizationUnitservice updateESFOrganizationUnitservice(
		long userId, long esfOrganizationUnitserviceId, long esfOrganizationId,
		long esfUnitserviceId, long numberUnitservices, String description,
		ServiceContext serviceContext)
		throws PortalException, SystemException {

		Date now = new Date();

		ESFOrganizationUnitservice esfOrganizationUnitservice =
			getESFOrganizationUnitservice(esfOrganizationUnitserviceId);

		User user = UserLocalServiceUtil.getUser(userId);

		esfOrganizationUnitservice.setUserId(userId);
		esfOrganizationUnitservice.setUserName(user.getFullName());
		esfOrganizationUnitservice.setModifiedDate(serviceContext.getModifiedDate(now));
		esfOrganizationUnitservice.setExpandoBridgeAttributes(serviceContext);
		esfOrganizationUnitservice.setEsfOrganizationId(esfOrganizationId);
		esfOrganizationUnitservice.setEsfUnitserviceId(esfUnitserviceId);
		esfOrganizationUnitservice.setNumberUnitservices(numberUnitservices);
		esfOrganizationUnitservice.setDescription(description);

		esfOrganizationUnitservicePersistence.update(esfOrganizationUnitservice);

		return esfOrganizationUnitservice;
	}

	public ESFOrganizationUnitservice deleteESFOrganizationUnitservice(
		long esfOrganizationUnitserviceId, ServiceContext serviceContext)
		throws PortalException, SystemException {

		ESFOrganizationUnitservice esfOrganizationUnitservice =
			getESFOrganizationUnitservice(esfOrganizationUnitserviceId);
		esfOrganizationUnitservice =
			deleteESFOrganizationUnitservice(esfOrganizationUnitserviceId);
		return esfOrganizationUnitservice;
	}

}
