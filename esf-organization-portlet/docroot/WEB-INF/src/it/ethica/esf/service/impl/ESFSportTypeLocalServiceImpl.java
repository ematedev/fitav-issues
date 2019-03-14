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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;

import it.ethica.esf.ESFSportTypeNameException;
import it.ethica.esf.model.ESFFieldESFSportType;
import it.ethica.esf.model.ESFSportType;
import it.ethica.esf.service.base.ESFSportTypeLocalServiceBaseImpl;

/**
 * The implementation of the e s f sport type local service. <p> All custom
 * service methods should be put in this class. Whenever methods are added,
 * rerun ServiceBuilder to copy their definitions into the
 * {@link it.ethica.esf.service.ESFSportTypeLocalService} interface. <p> This is
 * a local service. Methods of this service will not have security checks based
 * on the propagated JAAS credentials because this service can only be accessed
 * from within the same VM. </p>
 *
 * @author Ethica
 * @see it.ethica.esf.service.base.ESFSportTypeLocalServiceBaseImpl
 * @see it.ethica.esf.service.ESFSportTypeLocalServiceUtil
 */
public class ESFSportTypeLocalServiceImpl
	extends ESFSportTypeLocalServiceBaseImpl {

	public List<ESFSportType> getAllESFSportTypes()
		throws SystemException {

		return esfSportTypePersistence.findAll();
	}

	public List<ESFSportType> getAllESFSportTypes(int start, int end)
		throws SystemException {

		return esfSportTypePersistence.findAll(start, end);
	}

	public List<ESFSportType> getESFSportTypes(long groupId)
		throws SystemException {

		return esfSportTypePersistence.findByGroupId(groupId);
	}

	public List<ESFSportType> getESFSportTypes(long groupId, int start, int end)
		throws SystemException {

		return esfSportTypePersistence.findByGroupId(groupId, start, end);
	}

	public int getESFSportTypesCountByGroupId(long groupId)
		throws SystemException {

		return esfSportTypePersistence.countByGroupId(groupId);
	}

	public List<ESFSportType> getESFSportTypesByESFField(long esfFieldId)
		throws SystemException, PortalException {

		List<ESFSportType> esfSportTypes = new ArrayList<>();

		List<ESFFieldESFSportType> esfFieldEsfSportTypes =
			esfFieldESFSportTypePersistence.findByesfFieldId(esfFieldId);

		for (ESFFieldESFSportType esfFieldEsfSportType : esfFieldEsfSportTypes) {

			esfSportTypes.add(esfSportTypeLocalService.getESFSportType(esfFieldEsfSportType.getEsfSportTypeId()));
		}

		return esfSportTypes;
	}

	public ESFSportType addESFSportType(
		long userId, String name, String description,
		ServiceContext serviceContext)
		throws SystemException, PortalException {

		long groupId = serviceContext.getScopeGroupId();

		User user = userPersistence.findByPrimaryKey(userId);

		Date now = new Date();

		validate(name);

		long esfSportTypeId = counterLocalService.increment();

		ESFSportType esfSportType =
			esfSportTypePersistence.create(esfSportTypeId);

		esfSportType.setUserId(userId);
		esfSportType.setGroupId(groupId);
		esfSportType.setCompanyId(user.getCompanyId());
		esfSportType.setUserName(user.getFullName());
		esfSportType.setCreateDate(serviceContext.getCreateDate(now));
		esfSportType.setModifiedDate(serviceContext.getModifiedDate(now));
		esfSportType.setName(name);
		esfSportType.setDescription(description);
		esfSportType.setExpandoBridgeAttributes(serviceContext);

		esfSportTypePersistence.update(esfSportType);

		resourceLocalService.addResources(
			user.getCompanyId(), groupId, userId, ESFSportType.class.getName(),
			esfSportTypeId, false, true, true);

		// AssetEntry assetEntry = assetEntryLocalService.updateEntry(userId,
		// groupId, esfSportType.getCreateDate(),
		// esfSportType.getModifiedDate(), ESFSportType.class.getName(),
		// esfSportTypeId, esfSportType.getUuid(), 0,
		// serviceContext.getAssetCategoryIds(),
		// serviceContext.getAssetTagNames(), true, null, null, null,
		// ContentTypes.TEXT_HTML, esfSportType.getName(), null, null, null,
		// null, 0, 0, null, false);
		//
		// assetLinkLocalService.updateLinks(userId, assetEntry.getEntryId(),
		// serviceContext.getAssetLinkEntryIds(),
		// AssetLinkConstants.TYPE_RELATED);
		//
		// Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(
		// ESFSportType.class);
		//
		// indexer.reindex(esfSportType);

		return esfSportType;

	}

	public ESFSportType updateESFSportType(
		long userId, long esfSportTypeId, String name, String description,
		ServiceContext serviceContext)
		throws PortalException, SystemException {

		Date now = new Date();

		validate(name);

		ESFSportType esfSportType = getESFSportType(esfSportTypeId);

		User user = UserLocalServiceUtil.getUser(userId);

		esfSportType.setUserId(userId);
		esfSportType.setUserName(user.getFullName());
		esfSportType.setModifiedDate(serviceContext.getModifiedDate(now));
		esfSportType.setName(name);
		esfSportType.setDescription(description);
		esfSportType.setExpandoBridgeAttributes(serviceContext);

		esfSportTypePersistence.update(esfSportType);

		resourceLocalService.updateResources(
			serviceContext.getCompanyId(), serviceContext.getScopeGroupId(),
			name, esfSportTypeId, serviceContext.getGroupPermissions(),
			serviceContext.getGuestPermissions());

		// AssetEntry assetEntry = assetEntryLocalService.updateEntry(
		// esfSportType.getUserId(), esfSportType.getGroupId(),
		// esfSportType.getCreateDate(), esfSportType.getModifiedDate(),
		// ESFSportType.class.getName(), esfSportTypeId, esfSportType.getUuid(),
		// 0,
		// serviceContext.getAssetCategoryIds(),
		// serviceContext.getAssetTagNames(), true, null, null, null,
		// ContentTypes.TEXT_HTML, esfSportType.getName(), null, null, null,
		// null, 0, 0, null, false);
		//
		// assetLinkLocalService.updateLinks(serviceContext.getUserId(),
		// assetEntry.getEntryId(), serviceContext.getAssetLinkEntryIds(),
		// AssetLinkConstants.TYPE_RELATED);
		//
		// Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(
		// ESFSportType.class);
		//
		// indexer.reindex(esfSportType);

		return esfSportType;
	}

	public ESFSportType deleteESFSportType(
		long esfSportTypeId, ServiceContext serviceContext)
		throws PortalException, SystemException {

		ESFSportType esfSportType = getESFSportType(esfSportTypeId);

		resourceLocalService.deleteResource(
			serviceContext.getCompanyId(), ESFSportType.class.getName(),
			ResourceConstants.SCOPE_INDIVIDUAL, esfSportTypeId);

		// AssetEntry assetEntry = assetEntryLocalService.fetchEntry(
		// ESFSportType.class.getName(), esfSportTypeId);
		//
		// assetLinkLocalService.deleteLinks(assetEntry.getEntryId());
		//
		// assetEntryLocalService.deleteEntry(assetEntry);
		//
		// Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(
		// ESFSportType.class);
		//
		// indexer.delete(esfSportType);

		esfSportType = deleteESFSportType(esfSportTypeId);

		return esfSportType;
	}

	protected void validate(String name)
		throws PortalException {

		if (Validator.isNull(name)) {
			throw new ESFSportTypeNameException();
		}
	}
}
