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
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.model.AssetLinkConstants;

import it.ethica.esf.ESFFieldNameException;
import it.ethica.esf.NoSuchFieldESFSportTypeException;
import it.ethica.esf.model.ESFField;
import it.ethica.esf.model.ESFFieldESFSportType;
import it.ethica.esf.service.base.ESFFieldLocalServiceBaseImpl;
import it.ethica.esf.service.persistence.ESFFieldESFSportTypePK;

/**
 * The implementation of the e s f field local service. <p> All custom service
 * methods should be put in this class. Whenever methods are added, rerun
 * ServiceBuilder to copy their definitions into the
 * {@link it.ethica.esf.service.ESFFieldLocalService} interface. <p> This is a
 * local service. Methods of this service will not have security checks based on
 * the propagated JAAS credentials because this service can only be accessed
 * from within the same VM. </p>
 *
 * @author Ethica
 * @see it.ethica.esf.service.base.ESFFieldLocalServiceBaseImpl
 * @see it.ethica.esf.service.ESFFieldLocalServiceUtil
 */
public class ESFFieldLocalServiceImpl extends ESFFieldLocalServiceBaseImpl {

	// Get by group ID
	public List<ESFField> getESFFields(long groupId)
		throws SystemException {

		return esfFieldPersistence.findByGroupId(groupId);
	}

	public List<ESFField> getESFFields(long groupId, int start, int end)
		throws SystemException {

		return esfFieldPersistence.findByGroupId(groupId, start, end);
	}

	public int getESFFieldsCount(long groupId)
		throws SystemException {

		return esfFieldPersistence.countByGroupId(groupId);
	}

	// Get by organization ID
	public List<ESFField> getESFFields(long groupId, long esfOrganizationId)
		throws SystemException {

		return esfFieldPersistence.findByG_O(groupId, esfOrganizationId);
	}

	public List<ESFField> getESFFields(
		long groupId, long esfOrganizationId, int start, int end)
		throws SystemException {

		return esfFieldPersistence.findByG_O(groupId, esfOrganizationId, start, end);
	}

	public int getESFFieldsCount(long groupId, long esfOrganizationId)
		throws SystemException {

		return esfFieldPersistence.countByG_O(groupId, esfOrganizationId);
	}

	public List<ESFField> getESFFieldsByESFSportType(long esfSportTypeId)
		throws SystemException, PortalException {

		List<ESFField> esfFields = new ArrayList<>();

		List<ESFFieldESFSportType> esfFieldEsfSportTypes =
			esfFieldESFSportTypePersistence.findByesfSportTypeId(esfSportTypeId);

		for (ESFFieldESFSportType esfFieldEsfSportType : esfFieldEsfSportTypes) {

			esfFields.add(esfFieldLocalService.getESFField(esfFieldEsfSportType.getEsfFieldId()));
		}

		return esfFields;
	}

	public ESFField addESFField(
		long userId, String name, long ownerOrganizationId,
		long esfAddressIdId, long esfSportTypeIds[],
		ServiceContext serviceContext)
		throws SystemException, PortalException {

		long groupId = serviceContext.getScopeGroupId();

		User user = userPersistence.findByPrimaryKey(userId);

		Date now = new Date();

		validate(name);

		long esfFieldId = counterLocalService.increment();

		ESFField esfField = esfFieldPersistence.create(esfFieldId);

		esfField.setUserId(userId);
		esfField.setGroupId(groupId);
		esfField.setCompanyId(user.getCompanyId());
		esfField.setUserName(user.getFullName());
		esfField.setCreateDate(serviceContext.getCreateDate(now));
		esfField.setModifiedDate(serviceContext.getModifiedDate(now));
		esfField.setName(name);
		esfField.setOwnerOrganizationId(ownerOrganizationId);
		esfField.setEsfAddressId(esfAddressIdId);
		esfField.setExpandoBridgeAttributes(serviceContext);

		esfFieldPersistence.update(esfField);

		resourceLocalService.addResources(
			user.getCompanyId(), groupId, userId, ESFField.class.getName(),
			esfFieldId, false, true, true);

		AssetEntry assetEntry =
			assetEntryLocalService.updateEntry(
				userId, groupId, esfField.getCreateDate(),
				esfField.getModifiedDate(), ESFField.class.getName(),
				esfFieldId, esfField.getUuid(), 0,
				serviceContext.getAssetCategoryIds(),
				serviceContext.getAssetTagNames(), true, null, null, null,
				ContentTypes.TEXT_HTML, esfField.getName(), null, null, null,
				null, 0, 0, null, false);

		assetLinkLocalService.updateLinks(
			userId, assetEntry.getEntryId(),
			serviceContext.getAssetLinkEntryIds(),
			AssetLinkConstants.TYPE_RELATED);

		Indexer indexer =
			IndexerRegistryUtil.nullSafeGetIndexer(ESFField.class);

		indexer.reindex(esfField);

		updateESFFieldESFSportType(esfFieldId, esfSportTypeIds, serviceContext);

		return esfField;

	}

	public ESFField updateESFField(
		long userId, long esfFieldId, String name, long ownerOrganizationId,
		long esfAddressId, long esfSportTypeIds[], ServiceContext serviceContext)
		throws PortalException, SystemException {

		Date now = new Date();

		validate(name);

		ESFField esfField = getESFField(esfFieldId);

		User user = UserLocalServiceUtil.getUser(userId);

		esfField.setUserId(userId);
		esfField.setUserName(user.getFullName());
		esfField.setModifiedDate(serviceContext.getModifiedDate(now));
		esfField.setName(name);
		esfField.setOwnerOrganizationId(ownerOrganizationId);
		esfField.setEsfAddressId(esfAddressId);
		esfField.setExpandoBridgeAttributes(serviceContext);

		esfFieldPersistence.update(esfField);

		resourceLocalService.updateResources(
			serviceContext.getCompanyId(), serviceContext.getScopeGroupId(),
			name, esfFieldId, serviceContext.getGroupPermissions(),
			serviceContext.getGuestPermissions());

		AssetEntry assetEntry =
			assetEntryLocalService.updateEntry(
				esfField.getUserId(), esfField.getGroupId(),
				esfField.getCreateDate(), esfField.getModifiedDate(),
				ESFField.class.getName(), esfFieldId, esfField.getUuid(), 0,
				serviceContext.getAssetCategoryIds(),
				serviceContext.getAssetTagNames(), true, null, null, null,
				ContentTypes.TEXT_HTML, esfField.getName(), null, null, null,
				null, 0, 0, null, false);

		assetLinkLocalService.updateLinks(
			serviceContext.getUserId(), assetEntry.getEntryId(),
			serviceContext.getAssetLinkEntryIds(),
			AssetLinkConstants.TYPE_RELATED);

		Indexer indexer =
			IndexerRegistryUtil.nullSafeGetIndexer(ESFField.class);

		indexer.reindex(esfField);

		updateESFFieldESFSportType(esfFieldId, esfSportTypeIds, serviceContext);

		return esfField;
	}

	public ESFField deleteESFField(
		long esfFieldId, ServiceContext serviceContext)
		throws PortalException, SystemException {

		ESFField esfField = getESFField(esfFieldId);

		resourceLocalService.deleteResource(
			serviceContext.getCompanyId(), ESFField.class.getName(),
			ResourceConstants.SCOPE_INDIVIDUAL, esfFieldId);

		AssetEntry assetEntry =
			assetEntryLocalService.fetchEntry(
				ESFField.class.getName(), esfFieldId);

		assetLinkLocalService.deleteLinks(assetEntry.getEntryId());

		assetEntryLocalService.deleteEntry(assetEntry);

		Indexer indexer =
			IndexerRegistryUtil.nullSafeGetIndexer(ESFField.class);

		indexer.delete(esfField);

		esfFieldESFSportTypePersistence.removeByesfFieldId(esfFieldId);

		esfField = deleteESFField(esfFieldId);

		return esfField;
	}

	protected void validate(String name)
		throws PortalException {

		if (Validator.isNull(name)) {
			throw new ESFFieldNameException();
		}
	}

	protected void updateESFFieldESFSportType(
		long esfFieldId, long esfSportTypeIds[], ServiceContext serviceContext)
		throws SystemException {

		for (long esfSportTypeId : esfSportTypeIds) {
			if (Validator.isNotNull(esfSportTypeId) && esfSportTypeId > 0) {

				ESFFieldESFSportTypePK esfFieldEsfSportTypePK =
					new ESFFieldESFSportTypePK(esfFieldId, esfSportTypeId);

				ESFFieldESFSportType esfFieldESFSportType = null;

				try {

					esfFieldESFSportType =
						esfFieldESFSportTypePersistence.findByPrimaryKey(esfFieldEsfSportTypePK);

				}
				catch (NoSuchFieldESFSportTypeException e) {

					esfFieldESFSportType =
						esfFieldESFSportTypePersistence.create(esfFieldEsfSportTypePK);

				}

				esfFieldESFSportTypePersistence.update(
					esfFieldESFSportType, serviceContext);
			}
		}
	}
}
