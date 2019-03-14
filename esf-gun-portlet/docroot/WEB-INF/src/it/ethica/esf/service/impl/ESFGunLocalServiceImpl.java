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
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.model.AssetLinkConstants;

import it.ethica.esf.ESFGunNameExceptionException;
import it.ethica.esf.model.ESFGun;
import it.ethica.esf.model.ESFGunKind;
import it.ethica.esf.model.ESFGunType;
import it.ethica.esf.service.base.ESFGunLocalServiceBaseImpl;

/**
 * The implementation of the e s f gun local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link it.ethica.esf.service.ESFGunLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Ethica
 * @see it.ethica.esf.service.base.ESFGunLocalServiceBaseImpl
 * @see it.ethica.esf.service.ESFGunLocalServiceUtil
 */
public class ESFGunLocalServiceImpl extends ESFGunLocalServiceBaseImpl {

	public List<ESFGun> getESFGuns() throws SystemException {
		return esfGunPersistence.findAll();
	}

	public List<ESFGun> getESFGuns(int start, int end)
			throws SystemException {
		return esfGunPersistence.findAll(start, end);
	}

	public List<ESFGun> getESFGunsByESFGunKind(long esfGunKindId)
			throws SystemException {
		return esfGunPersistence.findByEsfGunKindId(esfGunKindId);
	}

	public int getESFGunsByESFGunKindCount(long esfGunKindId)
			throws SystemException {
		return esfGunPersistence.findByEsfGunKindId(esfGunKindId).size();
	}

	public ESFGun addESFGun(long userId,
			String code, long esfGunKindId, long esfOrganizationId, 
			long esfUserId, ServiceContext serviceContext)
					throws SystemException, PortalException {

		long groupId = serviceContext.getScopeGroupId();

		User user = userPersistence.findByPrimaryKey(userId);

		Date now = new Date();

		long esfGunId = counterLocalService.increment();

		ESFGun esfGun = esfGunPersistence.create(esfGunId);

		esfGun.setUserId(userId);
		esfGun.setGroupId(groupId);
		esfGun.setCompanyId(user.getCompanyId());
		esfGun.setUserName(user.getFullName());
		esfGun.setCreateDate(serviceContext.getCreateDate(now));
		esfGun.setModifiedDate(serviceContext.getModifiedDate(now));
		esfGun.setCode(code);
		esfGun.setEsfUserId(esfUserId);
		esfGun.setEsfGunKindId(esfGunKindId);
		esfGun.setEsfOrganizationId(esfOrganizationId);
		esfGun.setExpandoBridgeAttributes(serviceContext);

		esfGunPersistence.update(esfGun);

		resourceLocalService.addResources(user.getCompanyId(), groupId, userId,
				ESFGun.class.getName(), esfGunId, false, true, true);

		String assetName = getAssetName(esfGunKindId);

		AssetEntry assetEntry = assetEntryLocalService.updateEntry(userId,
				groupId, esfGun.getCreateDate(),
				esfGun.getModifiedDate(), ESFGun.class.getName(),
				esfGunId, esfGun.getUuid(), 0,
				serviceContext.getAssetCategoryIds(),
				serviceContext.getAssetTagNames(), true, null, null, null,
				ContentTypes.TEXT_HTML, assetName, null, null, null,
				null, 0, 0, null, false);

		assetLinkLocalService.updateLinks(userId, assetEntry.getEntryId(),
				serviceContext.getAssetLinkEntryIds(),
				AssetLinkConstants.TYPE_RELATED);

		Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(
				ESFGun.class);

		indexer.reindex(esfGun);

		return esfGun;

	}

	public ESFGun updateESFGun(long userId, long esfGunId,
			String code, long esfGunKindId, long esfOrganizationId, 
			long esfUserId, ServiceContext serviceContext)
					throws PortalException, SystemException {

		Date now = new Date();

		ESFGun esfGun = getESFGun(esfGunId);
		
		User user = UserLocalServiceUtil.getUser(userId);

		esfGun.setUserId(userId);
		esfGun.setCompanyId(user.getCompanyId());
		esfGun.setUserName(user.getFullName());
		esfGun.setCreateDate(serviceContext.getCreateDate(now));
		esfGun.setModifiedDate(serviceContext.getModifiedDate(now));
		esfGun.setCode(code);
		esfGun.setEsfUserId(esfUserId);
		esfGun.setEsfGunKindId(esfGunKindId);
		esfGun.setEsfOrganizationId(esfOrganizationId);
		esfGun.setExpandoBridgeAttributes(serviceContext);

		esfGunPersistence.update(esfGun);

		resourceLocalService.updateResources(serviceContext.getCompanyId(),
				serviceContext.getScopeGroupId(), ESFGun.class.getName(),
				esfGunId, serviceContext.getGroupPermissions(),
				serviceContext.getGuestPermissions());

		String assetName = getAssetName(esfGunKindId);

		AssetEntry assetEntry = assetEntryLocalService.updateEntry(
				esfGun.getUserId(), esfGun.getGroupId(),
				esfGun.getCreateDate(), esfGun.getModifiedDate(),
				ESFGun.class.getName(), esfGunId, esfGun.getUuid(), 0,
				serviceContext.getAssetCategoryIds(),
				serviceContext.getAssetTagNames(), true, null, null, null,
				ContentTypes.TEXT_HTML, assetName, null, null, null,
				null, 0, 0, null, false);

		assetLinkLocalService.updateLinks(serviceContext.getUserId(),
				assetEntry.getEntryId(), serviceContext.getAssetLinkEntryIds(),
				AssetLinkConstants.TYPE_RELATED);

		Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(
				ESFGun.class);

		indexer.reindex(esfGun);

		return esfGun;
	}

	public ESFGun deleteESFGun(long esfGunId,
			ServiceContext serviceContext) throws PortalException,
			SystemException {

		ESFGun esfGun = getESFGun(esfGunId);

		resourceLocalService.deleteResource(serviceContext.getCompanyId(),
				ESFGun.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL,
				esfGunId);

		AssetEntry assetEntry = assetEntryLocalService.fetchEntry(
				ESFGun.class.getName(), esfGunId);

		assetLinkLocalService.deleteLinks(assetEntry.getEntryId());

		assetEntryLocalService.deleteEntry(assetEntry);
		
		Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(
				ESFGun.class);

		indexer.delete(esfGun);

		esfGun = deleteESFGun(esfGunId);

		return esfGun;
	}

	public String getFullName(ESFGun esfGun) 
			throws PortalException, SystemException {

		return getAssetName(esfGun.getEsfGunKindId());
	}

	protected void validate(String name) throws PortalException {
		if (Validator.isNull(name)) {
			throw new ESFGunNameExceptionException();
		}
	}
	
	protected String getAssetName(long esfGunKindId) 
			throws PortalException, SystemException {

		ESFGunKind esfGunKind = esfGunKindLocalService
				.getESFGunKind(esfGunKindId);
		ESFGunType esfGunType = esfGunTypeLocalService
				.getESFGunType(esfGunKind.getEsfGunTypeId());

		return StringUtil.add(esfGunType.getName(),
				esfGunKind.getName(), StringPool.SPACE);
	}

}