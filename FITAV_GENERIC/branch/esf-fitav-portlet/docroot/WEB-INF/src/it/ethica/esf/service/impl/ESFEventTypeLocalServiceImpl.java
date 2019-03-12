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

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ServiceContext;

import it.ethica.esf.model.ESFEventType;
import it.ethica.esf.service.base.ESFEventTypeLocalServiceBaseImpl;

/**
 * The implementation of the e s f event type local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link it.ethica.esf.service.ESFEventTypeLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Ethica
 * @see it.ethica.esf.service.base.ESFEventTypeLocalServiceBaseImpl
 * @see it.ethica.esf.service.ESFEventTypeLocalServiceUtil
 */
public class ESFEventTypeLocalServiceImpl
	extends ESFEventTypeLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link it.ethica.esf.service.ESFEventTypeLocalServiceUtil} to access the e s f event type local service.
	 */

	public List<ESFEventType> findAll()
			throws SystemException {

			return esfEventTypePersistence.findAll();
		}
	public ESFEventType addEsfEventType(long groupId, long companyId,
			String userName, long esfUserId, Date createDate, String macrocategory,
			String eventType, ServiceContext serviceContext)
			throws SystemException {

		long esfEventTypeId = counterLocalService.increment();

		ESFEventType esfEventType= esfEventTypeLocalService
				.createESFEventType(esfEventTypeId);

		esfEventType.setGroupId(groupId);
		esfEventType.setCompanyId(companyId);
		esfEventType.setUserName(userName);
		esfEventType.setUserId(serviceContext.getUserId());
		esfEventType.setCreateDate(createDate);
		esfEventType.setMacrocategory(macrocategory);
		esfEventType.setEventType(eventType);
	

		esfEventTypeLocalService.updateESFEventType(esfEventType);

		return esfEventType;
	}
	
	public ESFEventType updateEsfEventType(long esfEventTypeId, long groupId, long companyId,
			String userName, long esfUserId, Date modifiedDate, String macrocategory,
			String eventType, ServiceContext serviceContext)
			throws SystemException {

		ESFEventType esfEventType = esfEventTypeLocalService
				.fetchESFEventType(esfEventTypeId);

		esfEventType.setGroupId(groupId);
		esfEventType.setCompanyId(companyId);
		esfEventType.setUserName(userName);
		esfEventType.setUserId(serviceContext.getUserId());
		esfEventType.setModifiedDate(modifiedDate);
		esfEventType.setMacrocategory(macrocategory);
		esfEventType.setEventType(eventType);
	
		esfEventTypeLocalService.updateESFEventType(esfEventType);

		return esfEventType;
	}
}