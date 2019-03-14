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

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;

import it.ethica.esf.model.ESFUnitservice;
import it.ethica.esf.service.ESFUnitserviceLocalServiceUtil;
import it.ethica.esf.service.base.ESFUnitserviceLocalServiceBaseImpl;

/**
 * The implementation of the e s f unitservice local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link it.ethica.esf.service.ESFUnitserviceLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Ethica
 * @see it.ethica.esf.service.base.ESFUnitserviceLocalServiceBaseImpl
 * @see it.ethica.esf.service.ESFUnitserviceLocalServiceUtil
 */
public class ESFUnitserviceLocalServiceImpl
	extends ESFUnitserviceLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link it.ethica.esf.service.ESFUnitserviceLocalServiceUtil} to access the e s f unitservice local service.
	 */

	public List<ESFUnitservice> getAllESFUnitservices()
			throws SystemException {
		return esfUnitservicePersistence.findAll();
	}

	public List<ESFUnitservice> getAllESFUnitservices(int start, int end)
			throws SystemException {
		return esfUnitservicePersistence.findAll(start, end);
	}

	public List<ESFUnitservice> getAllESFUnitservices(long groupId)
			throws SystemException {
		return esfUnitservicePersistence.findByGroupId(groupId);
	}

	public List<ESFUnitservice> getAllESFUnitservices(long groupId, int start, int end)
			throws SystemException {
		return esfUnitservicePersistence.findByGroupId(groupId, start, end);
	}
	
	public int countByGroupId(long groupId)
			throws SystemException {
		return esfUnitservicePersistence.countByGroupId(groupId);
	}
	
	public List<ESFUnitservice> findESFUnitserviceByDescription(String description)
			throws SystemException, PortalException {

		DynamicQuery unitserviceQuery = DynamicQueryFactoryUtil.forClass(
				ESFUnitservice.class, "unitserviceQuery",
				PortletClassLoaderUtil.getClassLoader());

		unitserviceQuery.add(PropertyFactoryUtil.forName("unitserviceQuery.description")
				.like(StringPool.PERCENT + description + StringPool.PERCENT));

		List<ESFUnitservice> esfUnitservicesToSend = ESFUnitserviceLocalServiceUtil.dynamicQuery(unitserviceQuery);

		return esfUnitservicesToSend;
	}
	
	public ESFUnitservice addESFUnitservice(long userId, String description, ServiceContext serviceContext)
			throws SystemException, PortalException {

	long groupId = serviceContext.getScopeGroupId();

	User user = userPersistence.findByPrimaryKey(userId);

	Date now = new Date();

	long esfUnitserviceId = counterLocalService.increment();

	ESFUnitservice esfUnitservice = esfUnitservicePersistence.create(esfUnitserviceId);
	
	esfUnitservice.setUserId(userId);
	esfUnitservice.setGroupId(groupId);
	esfUnitservice.setCompanyId(user.getCompanyId());
	esfUnitservice.setUserName(user.getFullName());
	esfUnitservice.setCreateDate(serviceContext.getCreateDate(now));
	esfUnitservice.setModifiedDate(serviceContext.getModifiedDate(now));
	esfUnitservice.setDescription(description);
	esfUnitservice.setExpandoBridgeAttributes(serviceContext);

	esfUnitservicePersistence.update(esfUnitservice);

	return esfUnitservice;
}
	
	public ESFUnitservice updateESFUnitservice(long userId, long esfUnitserviceId, String description, ServiceContext serviceContext)
			throws PortalException, SystemException {

	Date now = new Date();

	ESFUnitservice esfUnitservice = getESFUnitservice(esfUnitserviceId);
	
	User user = UserLocalServiceUtil.getUser(userId);

	esfUnitservice.setUserId(userId);
	esfUnitservice.setUserName(user.getFullName());
	esfUnitservice.setModifiedDate(serviceContext.getModifiedDate(now));
	esfUnitservice.setDescription(description);
	esfUnitservice.setExpandoBridgeAttributes(serviceContext);

	esfUnitservicePersistence.update(esfUnitservice);
	
	resourceLocalService.updateResources(serviceContext.getCompanyId(),
			serviceContext.getScopeGroupId(), description, esfUnitserviceId,
			serviceContext.getGroupPermissions(),
			serviceContext.getGuestPermissions());
	
	return esfUnitservice;
}
	
	public ESFUnitservice deleteESFUnitservice(long esfUnitserviceId,
			ServiceContext serviceContext) throws PortalException,
			SystemException {


		ESFUnitservice esfUnitservice = getESFUnitservice(esfUnitserviceId);

		resourceLocalService.deleteResource(serviceContext.getCompanyId(),
				ESFUnitservice.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL,
				esfUnitserviceId);
		

		esfUnitservice = deleteESFUnitservice(esfUnitserviceId);
		return esfUnitservice;
	}
	
}