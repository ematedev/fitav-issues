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
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.model.AssetLinkConstants;
import it.ethica.esf.ESFCardCodeException;
import it.ethica.esf.ESFCardEndDateException;
import it.ethica.esf.ESFCardStartDateException;
import it.ethica.esf.model.ESFCard;
import it.ethica.esf.service.base.ESFCardLocalServiceBaseImpl;

/**
 * The implementation of the e s f card local service. <p> All custom service
 * methods should be put in this class. Whenever methods are added, rerun
 * ServiceBuilder to copy their definitions into the
 * {@link it.ethica.esf.service.ESFCardLocalService} interface. <p> This is a
 * local service. Methods of this service will not have security checks based on
 * the propagated JAAS credentials because this service can only be accessed
 * from within the same VM. </p>
 *
 * @author Ethica
 * @see it.ethica.esf.service.base.ESFCardLocalServiceBaseImpl
 * @see it.ethica.esf.service.ESFCardLocalServiceUtil
 */
public class ESFCardLocalServiceImpl extends ESFCardLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS: Never reference this interface directly. Always use
	 * {@link it.ethica.esf.service.ESFCardLocalServiceUtil} to access the e s f
	 * card local service.
	 */

	public ESFCard addESFCard(
		long userId, String code, Date startDate, Date endDate, long esfUserId,
		long esfOrganizationId, ServiceContext serviceContext)
		throws SystemException, PortalException {

		long groupId = serviceContext.getScopeGroupId();

		User user = userPersistence.findByPrimaryKey(userId);

		Date date = new Date();

//		validate(code, startDate, endDate);

		long esfCardId = counterLocalService.increment();

		ESFCard esfCard = esfCardPersistence.create(esfCardId);

		esfCard.setUuid(serviceContext.getUuid());
		esfCard.setUserId(userId);
		esfCard.setGroupId(groupId);
		esfCard.setCompanyId(user.getCompanyId());
		esfCard.setUserName(user.getFullName());
		esfCard.setCreateDate(serviceContext.getCreateDate(date));
		esfCard.setModifiedDate(serviceContext.getModifiedDate(date));
		esfCard.setCode(code);
		esfCard.setStartDate(startDate);
		esfCard.setEndDate(endDate);
		esfCard.setEsfUserId(esfUserId);
		esfCard.setEsfOrganizationId(esfOrganizationId);

		esfCardPersistence.update(esfCard);

		resourceLocalService.addResources(
			user.getCompanyId(), groupId, userId, ESFCard.class.getName(),
			esfCardId, false, true, true);

		AssetEntry assetEntry =
			assetEntryLocalService.updateEntry(
				userId, groupId, esfCard.getCreateDate(),
				esfCard.getModifiedDate(), ESFCard.class.getName(), esfCardId,
				esfCard.getUuid(), 0, serviceContext.getAssetCategoryIds(),
				serviceContext.getAssetTagNames(), true, null, null, null,
				ContentTypes.TEXT_HTML, esfCard.getCode(), null, null, null,
				null, 0, 0, null, false);

		assetLinkLocalService.updateLinks(
			userId, assetEntry.getEntryId(),
			serviceContext.getAssetLinkEntryIds(),
			AssetLinkConstants.TYPE_RELATED);

		Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(ESFCard.class);
		
		indexer.reindex(esfCard);
		return esfCard;
	}

	public ESFCard updateESFCard(
		long userId, long esfCardId, String code, Date startDate, Date endDate,
		long esfUserId, long esfOrganizationId, ServiceContext serviceContext)
		throws SystemException, PortalException {

		long groupId = serviceContext.getScopeGroupId();

		User user = userPersistence.findByPrimaryKey(userId);

		Date date = new Date();

//		validate(code, startDate, endDate);

		ESFCard esfCard = getESFCard(esfCardId);

		esfCard.setUserName(user.getFullName());
		esfCard.setModifiedDate(serviceContext.getModifiedDate(date));
		esfCard.setCode(code);
		esfCard.setStartDate(startDate);
		esfCard.setEndDate(endDate);
		esfCard.setEsfUserId(esfUserId);
		esfCard.setEsfOrganizationId(esfOrganizationId);

		esfCardPersistence.update(esfCard);

		resourceLocalService.updateResources(
			user.getCompanyId(), groupId, ESFCard.class.getName(), esfCardId,
			serviceContext.getGroupPermissions(),
			serviceContext.getGuestPermissions());

		AssetEntry assetEntry =
			assetEntryLocalService.updateEntry(
				userId, groupId, esfCard.getCreateDate(),
				esfCard.getModifiedDate(), ESFCard.class.getName(), esfCardId,
				esfCard.getUuid(), 0, serviceContext.getAssetCategoryIds(),
				serviceContext.getAssetTagNames(), true, null, null, null,
				ContentTypes.TEXT_HTML, esfCard.getCode(), null, null, null,
				null, 0, 0, null, false);

		assetLinkLocalService.updateLinks(
			userId, assetEntry.getEntryId(),
			serviceContext.getAssetLinkEntryIds(),
			AssetLinkConstants.TYPE_RELATED);

		Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(ESFCard.class);

		indexer.reindex(esfCard);
		return esfCard;
	}

	public ESFCard deleteESFCard(long esfCardId, ServiceContext serviceContext) throws PortalException, SystemException {

		ESFCard esfCard = getESFCard(esfCardId);

		resourceLocalService.deleteResource(
			serviceContext.getCompanyId(), ESFCard.class.getName(),
			ResourceConstants.SCOPE_INDIVIDUAL, esfCardId);
		AssetEntry assetEntry =
			assetEntryLocalService.fetchEntry(
				ESFCard.class.getName(), esfCardId);
		
		assetLinkLocalService.deleteLinks(assetEntry.getEntryId());
		assetEntryLocalService.deleteEntry(assetEntry);
		Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(ESFCard.class);
		
		indexer.delete(esfCard);
		
		esfCard = deleteESFCard(esfCardId);
		return esfCard;
	}

	protected void validate(String code, Date startDate, Date endDate)
		throws PortalException {

		if (Validator.isNull(code)) {
			throw new ESFCardCodeException();
		}

		if (Validator.isNull(startDate)) {
			throw new ESFCardStartDateException();
		}

		if (Validator.isNull(endDate)) {
			throw new ESFCardEndDateException();
		}
	}
}
