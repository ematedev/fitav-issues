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
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;

import it.ethica.esf.model.ESFForniture;
import it.ethica.esf.model.ESFFornitureType;
import it.ethica.esf.service.base.ESFFornitureLocalServiceBaseImpl;

/**
 * The implementation of the e s f forniture local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link it.ethica.esf.service.ESFFornitureLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Ethica
 * @see it.ethica.esf.service.base.ESFFornitureLocalServiceBaseImpl
 * @see it.ethica.esf.service.ESFFornitureLocalServiceUtil
 */
public class ESFFornitureLocalServiceImpl extends
		ESFFornitureLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * it.ethica.esf.service.ESFFornitureLocalServiceUtil} to access the e s f
	 * forniture local service.  
	 */

	public List<ESFForniture> getAllESFFornitures() throws SystemException {
		return esfForniturePersistence.findAll();
	}
	

	public List<ESFForniture> getAllESFFornitures(int start, int end)
			throws SystemException {
		return esfForniturePersistence.findAll(start, end);
	}

	public List<ESFForniture> getAllESFFornitures(long groupId)
			throws SystemException {
		return esfForniturePersistence.findByGroupId(groupId);
	}

	public List<ESFForniture> getAllESFFornitures(long groupId, int start,
			int end) throws SystemException {
		return esfForniturePersistence.findByGroupId(groupId, start, end);
	}
	
	public List<ESFForniture> findAllESFFornituresByType(long type) throws SystemException{
		return esfForniturePersistence.findByType(type);
	}

	public int countByGroupId(long groupId) throws SystemException {
		return esfForniturePersistence.countByGroupId(groupId);
	}

	public ESFForniture addESFForniture(long userId, String code,
			String description, String name, long esfFornitureTypeId,
			long numberFornitures, Date insertDate,String size, ServiceContext serviceContext)
			throws SystemException, PortalException {

		long groupId = serviceContext.getScopeGroupId();

		User user = userPersistence.findByPrimaryKey(userId);

		Date now = new Date();

		long esfFornitureId = counterLocalService.increment();

		ESFForniture esfForniture = esfForniturePersistence
				.create(esfFornitureId);

		esfForniture.setUserId(userId);
		esfForniture.setGroupId(groupId);
		esfForniture.setCompanyId(user.getCompanyId());
		esfForniture.setUserName(user.getFullName());
		esfForniture.setCreateDate(serviceContext.getCreateDate(now));
		esfForniture.setModifiedDate(serviceContext.getModifiedDate(now));
		esfForniture.setDescription(description);
		esfForniture.setExpandoBridgeAttributes(serviceContext);
		esfForniture.setSize(size);
		esfForniture.setName(name);
		esfForniture.setDescription(description);
		esfForniture.setCode(code);
		esfForniture.setType(esfFornitureTypeId);
		esfForniture.setInsertDate(insertDate);
		esfForniture.setNumberFornitures(numberFornitures);

		esfForniturePersistence.update(esfForniture);

		try {
			resourceLocalService.addResources(user.getCompanyId(), groupId,
					userId, ESFFornitureType.class.getName(), esfFornitureId,
					false, true, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return esfForniture;
	}
	
	public ESFForniture updateESFForniture(long userId, long esfFornitureId, String code,
			String description, String name, long esfFornitureTypeId,
			long numberFornitures, Date insertDate,String size, ServiceContext serviceContext)
			throws SystemException, PortalException {

		User user = userPersistence.findByPrimaryKey(userId);

		ESFForniture esfForniture = getESFForniture(esfFornitureId);
		Date now = new Date();
		
		esfForniture.setUserId(userId);
		esfForniture.setUserName(user.getFullName());
		esfForniture.setModifiedDate(serviceContext.getModifiedDate(now));
		esfForniture.setExpandoBridgeAttributes(serviceContext);
		esfForniture.setSize(size);
		esfForniture.setName(name);
		esfForniture.setDescription(description);
		esfForniture.setCode(code);
		esfForniture.setType(esfFornitureTypeId);
		esfForniture.setInsertDate(insertDate);
		esfForniture.setNumberFornitures(numberFornitures);

		esfForniturePersistence.update(esfForniture);

		try {
			resourceLocalService.updateResources(serviceContext.getCompanyId(),
					serviceContext.getScopeGroupId(), description, esfFornitureId,
					serviceContext.getGroupPermissions(),
					serviceContext.getGuestPermissions());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return esfForniture;
	}
	
	public ESFForniture deleteESFForniture(long esfFornitureId,
			ServiceContext serviceContext) throws PortalException,
			SystemException {

		ESFForniture esfForniture = getESFForniture(esfFornitureId);

		resourceLocalService.deleteResource(serviceContext.getCompanyId(),
				ESFForniture.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL,
				esfFornitureId);

		esfForniture = deleteESFForniture(esfFornitureId);
		return esfForniture;
	}

}