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

import it.ethica.esf.model.ESFForniture;
import it.ethica.esf.model.ESFFornitureType;
import it.ethica.esf.service.ESFFornitureTypeLocalServiceUtil;
import it.ethica.esf.service.base.ESFFornitureTypeLocalServiceBaseImpl;

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

/**
 * The implementation of the e s f forniture type local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link it.ethica.esf.service.ESFFornitureTypeLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Ethica
 * @see it.ethica.esf.service.base.ESFFornitureTypeLocalServiceBaseImpl
 * @see it.ethica.esf.service.ESFFornitureTypeLocalServiceUtil
 */
public class ESFFornitureTypeLocalServiceImpl
	extends ESFFornitureTypeLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link it.ethica.esf.service.ESFFornitureTypeLocalServiceUtil} to access the e s f forniture type local service.
	 */

	public List<ESFFornitureType> getAllESFFornitureTypes()
			throws SystemException {
		return esfFornitureTypePersistence.findAll();
	}

	public List<ESFFornitureType> getAllESFFornitureTypes(int start, int end)
			throws SystemException {
		return esfFornitureTypePersistence.findAll(start, end);
	}

	public List<ESFFornitureType> getAllESFFornitureTypes(long groupId)
			throws SystemException {
		return esfFornitureTypePersistence.findByGroupId(groupId);
	}

	public List<ESFFornitureType> getAllESFFornitureTypes(long groupId, int start, int end)
			throws SystemException {
		return esfFornitureTypePersistence.findByGroupId(groupId, start, end);
	}

	public int countByGroupId(long groupId)
			throws SystemException {
		return esfFornitureTypePersistence.countByGroupId(groupId);
	}
	
	public List<ESFFornitureType> findESFFornitureTypeByDescription(String description)
			throws SystemException, PortalException {

		DynamicQuery fornitureTypeQuery = DynamicQueryFactoryUtil.forClass(
				ESFForniture.class, "fornitureTypeQuery",
				PortletClassLoaderUtil.getClassLoader());

		fornitureTypeQuery.add(PropertyFactoryUtil.forName("fornitureTypeQuery.name")
				.like(StringPool.PERCENT + description + StringPool.PERCENT));

		List<ESFFornitureType> esfFornitureTypesToSend = ESFFornitureTypeLocalServiceUtil.dynamicQuery(fornitureTypeQuery);

		return esfFornitureTypesToSend;
	}

	
	public ESFFornitureType addESFForntureType(long userId, String description, ServiceContext serviceContext)
				throws SystemException, PortalException {

		long groupId = serviceContext.getScopeGroupId();

		User user = userPersistence.findByPrimaryKey(userId);

		Date now = new Date();

		long esfFornitureTypeId = counterLocalService.increment();

		ESFFornitureType esfFornitureType = esfFornitureTypePersistence.create(esfFornitureTypeId);
		
		esfFornitureType.setUserId(userId);
		esfFornitureType.setGroupId(groupId);
		esfFornitureType.setCompanyId(user.getCompanyId());
		esfFornitureType.setUserName(user.getFullName());
		esfFornitureType.setCreateDate(serviceContext.getCreateDate(now));
		esfFornitureType.setModifiedDate(serviceContext.getModifiedDate(now));
		esfFornitureType.setDescription(description);
		esfFornitureType.setExpandoBridgeAttributes(serviceContext);

		esfFornitureTypePersistence.update(esfFornitureType);
		
		try{
		resourceLocalService.addResources(user.getCompanyId(), groupId, userId,
				ESFFornitureType.class.getName(), esfFornitureTypeId, false, true, true);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return esfFornitureType;
	}
	
	public ESFFornitureType updateESFFornitureType(long userId, long esfFornitureTypeId, String description, ServiceContext serviceContext)
				throws PortalException, SystemException {

		Date now = new Date();


		ESFFornitureType esfFornitureType = getESFFornitureType(esfFornitureTypeId);
		
		User user = UserLocalServiceUtil.getUser(userId);

		esfFornitureType.setUserId(userId);
		esfFornitureType.setUserName(user.getFullName());
		esfFornitureType.setModifiedDate(serviceContext.getModifiedDate(now));
		esfFornitureType.setDescription(description);
		esfFornitureType.setExpandoBridgeAttributes(serviceContext);

		esfFornitureTypePersistence.update(esfFornitureType);
		
		resourceLocalService.updateResources(serviceContext.getCompanyId(),
				serviceContext.getScopeGroupId(), description, esfFornitureTypeId,
				serviceContext.getGroupPermissions(),
				serviceContext.getGuestPermissions());

		return esfFornitureType;
	}
	
	public ESFFornitureType deleteESFFornitureType(long esfFornitureTypeId,
			ServiceContext serviceContext) throws PortalException,
			SystemException {

		ESFFornitureType esfFornitureType = getESFFornitureType(esfFornitureTypeId);

		resourceLocalService.deleteResource(serviceContext.getCompanyId(),
				ESFFornitureType.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL,
				esfFornitureTypeId);

		esfFornitureType = deleteESFFornitureType(esfFornitureTypeId);
		return esfFornitureType;
	}
}