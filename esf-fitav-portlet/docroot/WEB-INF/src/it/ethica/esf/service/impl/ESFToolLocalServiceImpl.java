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

import com.liferay.portal.NoSuchUserException;
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

import it.ethica.esf.ESFToolNameException;
import it.ethica.esf.NoSuchToolException;
import it.ethica.esf.model.ESFTool;
import it.ethica.esf.model.ESFToolRel;
import it.ethica.esf.service.base.ESFToolLocalServiceBaseImpl;
import it.ethica.esf.service.persistence.ESFToolRelPK;

/**
 * The implementation of the e s f tool local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link it.ethica.esf.service.ESFToolLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Ethica
 * @see it.ethica.esf.service.base.ESFToolLocalServiceBaseImpl
 * @see it.ethica.esf.service.ESFToolLocalServiceUtil
 */
public class ESFToolLocalServiceImpl extends ESFToolLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link it.ethica.esf.service.ESFToolLocalServiceUtil} to access the e s f tool local service.
	 */
	public List<ESFTool> findByT_G(long esfToolId, long groupId)
			throws SystemException {

		return esfToolPersistence.findByT_G(esfToolId, groupId);
	}

	public List<ESFTool> findByT_G(
		long esfToolId, long groupId, int start, int end)
		throws SystemException {

		return esfToolPersistence.findByT_G(esfToolId, groupId, start, end);
	}

	public List<ESFTool> findByTools(String className, long classPK)
		throws SystemException, NoSuchToolException {

		List<ESFToolRel> esfToolRels =
			esfToolRelPersistence.findByN_P(className, classPK);

		List<ESFTool> ESFTools = new ArrayList<ESFTool>();
		for (ESFToolRel esfToolRel : esfToolRels) {
			ESFTool esfTool =
				esfToolPersistence.findByPrimaryKey(esfToolRel.getEsfToolId());

			ESFTools.add(esfTool);
		}

		return ESFTools;
	}

	public List<ESFTool> findByTools(
		String className, long classPK, int start, int end)
		throws SystemException, NoSuchToolException {

		List<ESFToolRel> esfToolRels =
			esfToolRelPersistence.findByN_P(className, classPK, start, end);

		List<ESFTool> ESFTools = new ArrayList<ESFTool>();
		for (ESFToolRel esfToolRel : esfToolRels) {
			ESFTool esfTool =
				esfToolPersistence.findByPrimaryKey(esfToolRel.getEsfToolId());

			ESFTools.add(esfTool);
		}

		return ESFTools;
	}

	public ESFTool addESFTool(
		long userId, String code, String name, String description, String type,
		ServiceContext serviceContext)
				throws SystemException, PortalException {

		long groupId = serviceContext.getScopeGroupId();

		User user = userPersistence.findByPrimaryKey(userId);

		Date date = new Date();

		validate(code, name, description, type);

		long esfToolId = counterLocalService.increment();

		ESFTool esfTool = esfToolPersistence.create(esfToolId);

		esfTool.setUuid(serviceContext.getUuid());
		esfTool.setUserId(userId);
		esfTool.setGroupId(groupId);
		esfTool.setCompanyId(user.getCompanyId());
		esfTool.setUserName(user.getFullName());
		esfTool.setCreateDate(serviceContext.getCreateDate(date));
		esfTool.setModifiedDate(serviceContext.getModifiedDate(date));
		esfTool.setCode(code);
		esfTool.setName(name);
		esfTool.setDescription(description);
		esfTool.setType(type);

		esfToolPersistence.update(esfTool);

		resourceLocalService.addResources(
			user.getCompanyId(), groupId, userId, ESFTool.class.getName(),
			esfToolId, false, true, true);

		AssetEntry assetEntry =
			assetEntryLocalService.updateEntry(
				userId, groupId, esfTool.getCreateDate(),
				esfTool.getModifiedDate(), ESFTool.class.getName(), esfToolId,
				esfTool.getUuid(), 0, serviceContext.getAssetCategoryIds(),
				serviceContext.getAssetTagNames(), true, null, null, null,
				ContentTypes.TEXT_HTML, esfTool.getName(), null, null, null,
				null, 0, 0, null, false);

		assetLinkLocalService.updateLinks(
			userId, assetEntry.getEntryId(),
			serviceContext.getAssetLinkEntryIds(),
			AssetLinkConstants.TYPE_RELATED);

		Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(ESFTool.class);

		indexer.reindex(esfTool);

		return esfTool;
	}

	public ESFTool updateESFTool(
		long userId, long esfToolId, String code, String name,
		String description, String type, ServiceContext serviceContext)
		throws PortalException, SystemException {

		long groupId = serviceContext.getScopeGroupId();

		User user = userPersistence.findByPrimaryKey(userId);

		Date date = new Date();

		validate(code, name, description, type);

		ESFTool esfTool = getESFTool(esfToolId);

		esfTool.setUserId(userId);
		esfTool.setUserName(user.getFullName());
		esfTool.setModifiedDate(serviceContext.getModifiedDate(date));
		esfTool.setCode(code);
		esfTool.setName(name);
		esfTool.setDescription(description);
		esfTool.setType(type);

		esfToolPersistence.update(esfTool);

		resourceLocalService.updateResources(
			user.getCompanyId(), groupId, ESFTool.class.getName(), esfToolId,
			serviceContext.getGroupPermissions(),
			serviceContext.getGuestPermissions());

		AssetEntry assetEntry =
			assetEntryLocalService.updateEntry(
				userId, groupId, esfTool.getCreateDate(),
				esfTool.getModifiedDate(), ESFTool.class.getName(), esfToolId,
				esfTool.getUuid(), 0, serviceContext.getAssetCategoryIds(),
				serviceContext.getAssetTagNames(), true, null, null, null,
				ContentTypes.TEXT_HTML, esfTool.getName(), null, null, null,
				null, 0, 0, null, false);

		assetLinkLocalService.updateLinks(
			userId, assetEntry.getEntryId(),
			serviceContext.getAssetLinkEntryIds(),
			AssetLinkConstants.TYPE_RELATED);

		Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(ESFTool.class);

		indexer.reindex(esfTool);

		return esfTool;
	}

	public ESFTool deleteESFTool(long esfToolId, ServiceContext serviceContext)
		throws PortalException, SystemException {

		ESFTool esfTool = getESFTool(esfToolId);

		resourceLocalService.deleteResource(
			serviceContext.getCompanyId(), ESFTool.class.getName(),
			ResourceConstants.SCOPE_INDIVIDUAL, esfToolId);

		AssetEntry assetEntry =
			assetEntryLocalService.fetchEntry(
				ESFTool.class.getName(), esfToolId);

		assetLinkLocalService.deleteLinks(assetEntry.getEntryId());

		assetEntryLocalService.deleteEntry(assetEntry);

		Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(ESFTool.class);

		indexer.delete(esfTool);

		esfTool = deleteESFTool(esfToolId);

		return esfTool;
	}

	public ESFToolRel addESFToolREL(
		long userId, long classPK, long esfToolId, String className,
		Date assignmentDate, ServiceContext serviceContext)
		throws NoSuchUserException, SystemException {

		long groupId = serviceContext.getScopeGroupId();

		User user = userPersistence.findByPrimaryKey(userId);

		Date date = new Date();

		// chiave tripla per l'entità ESFToolRel
		ESFToolRelPK esfToolRelPK = new ESFToolRelPK();
		esfToolRelPK.setClassName(className);
		esfToolRelPK.setClassPK(classPK);
		esfToolRelPK.setEsfToolId(esfToolId);

		ESFToolRel esfToolRel = esfToolRelPersistence.create(esfToolRelPK);

		esfToolRel.setAssignmentDate(assignmentDate);
		esfToolRel.setUserId(userId);
		esfToolRel.setGroupId(groupId);
		esfToolRel.setCompanyId(user.getCompanyId());
		esfToolRel.setUserName(user.getFullName());
		esfToolRel.setCreateDate(serviceContext.getCreateDate(date));
		esfToolRel.setModifiedDate(serviceContext.getModifiedDate(date));

		esfToolRelPersistence.update(esfToolRel);

		return esfToolRel;
	}

	public ESFToolRel updateESFToolREL(
		long userId, long classPKOld, long esfToolIdOld, String classNameOld,
		long classPKNew, long esfToolIdNew, String classNameNew,
		Date assignmentDate, ServiceContext serviceContext)
		throws SystemException, PortalException {

		User user = userPersistence.findByPrimaryKey(userId);

		Date date = new Date();

		// chiave tripla per l'entità ESFToolRel
		ESFToolRelPK esfToolRelPK = new ESFToolRelPK();
		esfToolRelPK.setClassName(classNameOld);
		esfToolRelPK.setClassPK(classPKOld);
		esfToolRelPK.setEsfToolId(esfToolIdOld);

		ESFToolRel esfToolRel =
			esfToolRelPersistence.fetchByPrimaryKey(esfToolRelPK);

		esfToolRel.setEsfToolId(esfToolIdNew);
		esfToolRel.setClassName(classNameNew);
		esfToolRel.setClassPK(classPKNew);
		esfToolRel.setAssignmentDate(assignmentDate);
		esfToolRel.setUserName(user.getFullName());
		esfToolRel.setModifiedDate(serviceContext.getModifiedDate(date));

		esfToolRelPersistence.update(esfToolRel);
		return esfToolRel;

	}

	public ESFToolRel deleteESFToolREL(
		long classPK, long esfToolId, String className,
		ServiceContext serviceContext)
		throws PortalException, SystemException {

		ESFToolRel esfToolRel =
			deleteESFToolREL(classPK, esfToolId, className, serviceContext);

		return esfToolRel;
	}

	protected void validate(
		String code, String name, String description, String type)
		throws PortalException {

		if (Validator.isNull(name)) {
			throw new ESFToolNameException();
		}
	}
}