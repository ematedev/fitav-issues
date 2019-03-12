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

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.portlet.PortletException;

import com.liferay.portal.NoSuchUserException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Contact;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ContactLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.model.AssetLinkConstants;

import it.ethica.esf.ESFUserPortalUserException;
import it.ethica.esf.model.ESFUser;
import it.ethica.esf.service.base.ESFUserLocalServiceBaseImpl;

/**
 * The implementation of the e s f user local service. <p> All custom service
 * methods should be put in this class. Whenever methods are added, rerun
 * ServiceBuilder to copy their definitions into the
 * {@link it.ethica.esf.service.ESFUserLocalService} interface. <p> This is a
 * local service. Methods of this service will not have security checks based on
 * the propagated JAAS credentials because this service can only be accessed
 * from within the same VM. </p>
 * 
 * @author Ethica
 * @see it.ethica.esf.service.base.ESFUserLocalServiceBaseImpl
 * @see it.ethica.esf.service.ESFUserLocalServiceUtil
 */
public class ESFUserLocalServiceImpl extends ESFUserLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS: Never reference this interface directly. Always use
	 * {@link it.ethica.esf.service.ESFUserLocalServiceUtil} to access the e s f
	 * user local service.
	 */
	public ESFUser addESFUser(
			long userId, String code, String screenName, String emailAddress,
			long facebookId, Locale locale, String firstName, String middleName,
			String lastName, int prefixId, int suffixId, boolean male,
			int birthdayMonth, int birthdayDay, int birthdayYear, String jobTitle,
			ServiceContext portalUserServiceContext,
			ServiceContext esfUserServiceContext)
		throws PortalException, SystemException {

		User operator = userPersistence.findByPrimaryKey(userId);
		User portalUser = null;
		try {
			portalUser =
				userLocalService.addUser(
					operator.getUserId(), operator.getCompanyId(), true, "",
					"", false, screenName, emailAddress, facebookId, "",
					locale, firstName, middleName, lastName, prefixId,
					suffixId, male, birthdayMonth, birthdayDay, birthdayYear,
					jobTitle, new long[0], new long[0], new long[0],
					new long[0], false, portalUserServiceContext);
		}
		catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}

		long portalUserId = portalUser.getUserId();

		long groupId = esfUserServiceContext.getScopeGroupId();

		validate(portalUserId);

		long esfUserId = portalUserId;

		ESFUser esfUser = esfUserPersistence.create(esfUserId);
		
		esfUser.setUuid(esfUserServiceContext.getUuid());
		esfUser.setExpandoBridgeAttributes(esfUserServiceContext);
		esfUser.setCode(code);

		esfUserPersistence.update(esfUser);

		resourceLocalService.addResources(
			operator.getCompanyId(), groupId, userId, ESFUser.class.getName(),
			esfUserId, false, true, true);

		AssetEntry assetEntry =
			assetEntryLocalService.updateEntry(
				userId, groupId, esfUser.getOriginalUser().getCreateDate(),
				esfUser.getOriginalUser().getModifiedDate(),
				ESFUser.class.getName(), esfUserId, esfUser.getUuid(), 0,
				esfUserServiceContext.getAssetCategoryIds(),
				esfUserServiceContext.getAssetTagNames(), true, null, null,
				null, ContentTypes.TEXT_HTML, esfUser.getFirstName(), null,
				null, null, null, 0, 0, null, false);

		assetLinkLocalService.updateLinks(
			userId, assetEntry.getEntryId(),
			esfUserServiceContext.getAssetLinkEntryIds(),
			AssetLinkConstants.TYPE_RELATED);

		Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(ESFUser.class);

		indexer.reindex(esfUser);

		return esfUser;
	}

	public ESFUser deleteESFUser(long esfUserId, ServiceContext serviceContext)
		throws PortalException, SystemException {

		ESFUser esfUser = getESFUser(esfUserId);
		User portalUser = userPersistence.findByPrimaryKey(esfUserId);

		resourceLocalService.deleteResource(
			serviceContext.getCompanyId(), ESFUser.class.getName(),
			ResourceConstants.SCOPE_INDIVIDUAL, esfUserId);

		AssetEntry assetEntry =
			assetEntryLocalService.fetchEntry(
				ESFUser.class.getName(), esfUserId);

		assetLinkLocalService.deleteLinks(assetEntry.getEntryId());

		assetEntryLocalService.deleteEntry(assetEntry);

		Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(ESFUser.class);

		indexer.delete(esfUser);

		esfUser = deleteESFUser(esfUser);

		userLocalService.deleteUser(portalUser);

		return esfUser;
	}

	public ESFUser updateESFUser(
		long userId, long esfUserId, String emailAddress, String firstName,
		String lastName, String screenName, boolean male, int birthdayMonth, int birthdayDay,
		int birthdayYear, String jobTitle, ServiceContext serviceContext)
		throws SystemException, PortalException {

		User portalUser = userPersistence.findByPrimaryKey(esfUserId);
		User operator = userPersistence.findByPrimaryKey(userId);

		Contact portalUserContact = portalUser.getContact();
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(Calendar.DAY_OF_MONTH, birthdayDay);
		calendar.set(Calendar.MONTH, birthdayMonth);
		calendar.set(Calendar.YEAR, birthdayYear);
		Date portalUserBirthday = calendar.getTime();

		portalUser.setEmailAddress(emailAddress);
		portalUser.setFirstName(firstName);
		portalUser.setLastName(lastName);
		portalUser.setScreenName(screenName);
		portalUserContact.setMale(male);
		portalUserContact.setBirthday(portalUserBirthday);
		portalUserContact.setJobTitle(jobTitle);

		userLocalService.updateUser(portalUser);
		ContactLocalServiceUtil.updateContact(portalUserContact);

		long groupId = serviceContext.getScopeGroupId();

		validate(esfUserId);

		ESFUser esfUser = getESFUser(esfUserId);

		esfUser.setUuid(serviceContext.getUuid());
		esfUser.setExpandoBridgeAttributes(serviceContext);

		esfUserPersistence.update(esfUser);

		resourceLocalService.updateResources(
			operator.getCompanyId(), groupId, ESFUser.class.getName(),
			esfUserId, serviceContext.getGroupPermissions(),
			serviceContext.getGroupPermissions());

		AssetEntry assetEntry =
			assetEntryLocalService.updateEntry(
				userId, groupId, esfUser.getOriginalUser().getCreateDate(),
				esfUser.getOriginalUser().getModifiedDate(),
				ESFUser.class.getName(), esfUserId, esfUser.getUuid(), 0,
				serviceContext.getAssetCategoryIds(),
				serviceContext.getAssetTagNames(), true, null, null, null,
				ContentTypes.TEXT_HTML, esfUser.getFirstName(), null, null,
				null, null, 0, 0, null, false);

		assetLinkLocalService.updateLinks(
			userId, assetEntry.getEntryId(),
			serviceContext.getAssetLinkEntryIds(),
			AssetLinkConstants.TYPE_RELATED);

		Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(ESFUser.class);

		indexer.reindex(esfUser);

		return esfUser;
	}

	protected void validate(long portalUserId)
		throws PortalException, SystemException {

		if (Validator.isNull(portalUserId) || portalUserId <= 0) {
			try {
				userPersistence.findByPrimaryKey(portalUserId);
			}
			catch (NoSuchUserException ex) {
				throw new ESFUserPortalUserException();
			}
		}
	}

	private static Log _log =
		LogFactoryUtil.getLog(ESFUserLocalServiceImpl.class);
}
