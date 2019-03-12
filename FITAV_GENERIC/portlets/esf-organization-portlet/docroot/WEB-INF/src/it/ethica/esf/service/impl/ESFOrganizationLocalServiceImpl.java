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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Address;
import com.liferay.portal.model.Organization;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.service.AddressLocalServiceUtil;
import com.liferay.portal.service.OrganizationLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.model.AssetLinkConstants;

import it.ethica.esf.ESFOrganizationNameException;
import it.ethica.esf.model.ESFAddress;
import it.ethica.esf.model.ESFField;
import it.ethica.esf.model.ESFOrganization;
import it.ethica.esf.service.ESFAddressLocalServiceUtil;
import it.ethica.esf.service.base.ESFOrganizationLocalServiceBaseImpl;

/**
 * The implementation of the e s f organization local service. <p> All custom
 * service methods should be put in this class. Whenever methods are added,
 * rerun ServiceBuilder to copy their definitions into the
 * {@link it.ethica.esf.service.ESFOrganizationLocalService} interface. <p> This
 * is a local service. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM. </p>
 *
 * @author Ethica
 * @see it.ethica.esf.service.base.ESFOrganizationLocalServiceBaseImpl
 * @see it.ethica.esf.service.ESFOrganizationLocalServiceUtil
 */
public class ESFOrganizationLocalServiceImpl
	extends ESFOrganizationLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS: Never reference this interface directly. Always use
	 * {@link it.ethica.esf.service.ESFOrganizationLocalServiceUtil} to access
	 * the e s f organization local service.
	 */

	public List<ESFOrganization> findByGroupId(long groupId)
		throws SystemException {

		return esfOrganizationPersistence.findByGroupId(groupId);
	}

	public List<ESFOrganization> findByGroupId(long groupId, int start, int end)
		throws SystemException {

		return esfOrganizationPersistence.findByGroupId(groupId, start, end);
	}

	public ESFOrganization addESFOrganization(
		long userId, String name, String code, String vat, String fiscalCode,
		Date establishmentDate, Date closureDate,
		List<ESFAddress> esfAddresses, ServiceContext serviceContext)
		throws PortalException, SystemException {

		ESFOrganization esfOrganization =
			addESFOrganization(
				userId, name, code, vat, fiscalCode, establishmentDate,
				closureDate, serviceContext);

		try {
			for (ESFAddress esfAddress : esfAddresses) {
				ESFAddressLocalServiceUtil.addESFAddress(
					userId, esfAddress.getLongitude(),
					esfAddress.getEsfCountryId(), esfAddress.getEsfRegionId(),
					esfAddress.getEsfProvinceId(), esfAddress.getEsfCityId(),
					esfAddress.getLatitude(), Organization.class.getName(),
					esfOrganization.getEsfOrganizationId(),
					esfAddress.getStreet1(), esfAddress.getStreet2(),
					esfAddress.getStreet3(), esfAddress.getZip(), 12000,
					esfAddress.getMailing(), esfAddress.getPrimary_(),
					serviceContext);
			}
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}

		return esfOrganization;
	}

	public ESFOrganization addESFOrganization(
		long userId, String name, String code, String vat, String fiscalCode,
		Date establishmentDate, Date closureDate, ServiceContext serviceContext)
		throws PortalException, SystemException {

		validate(name);

		Organization organization =
			OrganizationLocalServiceUtil.addOrganization(
				userId, 0, name, "regular-organization", 0, 0, 12017, "", true,
				serviceContext);

		long portalOrganizationId = organization.getOrganizationId();

		ESFOrganization esfOrganization =
			esfOrganizationPersistence.create(portalOrganizationId);

		esfOrganization.setUuid(serviceContext.getUuid());
		esfOrganization.setCode(code);
		esfOrganization.setVat(vat);
		esfOrganization.setFiscalCode(fiscalCode);
		esfOrganization.setEstablishmentDate(establishmentDate);
		esfOrganization.setClosureDate(closureDate);
		esfOrganization.setGroupId(serviceContext.getScopeGroupId());
		esfOrganization.setExpandoBridgeAttributes(serviceContext);

		esfOrganizationPersistence.update(esfOrganization);

		resourceLocalService.addResources(
			serviceContext.getCompanyId(), serviceContext.getScopeGroupId(),
			userId, ESFOrganization.class.getName(), portalOrganizationId,
			false, true, true);

		AssetEntry assetEntry =
			assetEntryLocalService.updateEntry(
				userId, serviceContext.getScopeGroupId(),
				organization.getCreateDate(), organization.getModifiedDate(),
				ESFOrganization.class.getName(), portalOrganizationId,
				esfOrganization.getUuid(), 0,
				serviceContext.getAssetCategoryIds(),
				serviceContext.getAssetTagNames(), true, null, null, null,
				ContentTypes.TEXT_HTML, esfOrganization.getName(), null, null,
				null, null, 0, 0, null, false);

		assetLinkLocalService.updateLinks(
			userId, assetEntry.getEntryId(),
			serviceContext.getAssetLinkEntryIds(),
			AssetLinkConstants.TYPE_RELATED);

		Indexer indexer =
			IndexerRegistryUtil.nullSafeGetIndexer(ESFOrganization.class);

		indexer.reindex(esfOrganization);

		return esfOrganization;

	}

	public ESFOrganization deleteESFOrganization(
		long esfOrganizationId, ServiceContext serviceContext)
		throws PortalException, SystemException {

		ESFOrganization esfOrganization = getESFOrganization(esfOrganizationId);

		resourceLocalService.deleteResource(
			serviceContext.getCompanyId(), ESFOrganization.class.getName(),
			ResourceConstants.SCOPE_INDIVIDUAL, esfOrganizationId);

		AssetEntry assetEntry =
			assetEntryLocalService.fetchEntry(
				ESFOrganization.class.getName(), esfOrganizationId);

		assetLinkLocalService.deleteLinks(assetEntry.getEntryId());

		assetEntryLocalService.deleteEntry(assetEntry);

		Indexer indexer =
			IndexerRegistryUtil.nullSafeGetIndexer(ESFOrganization.class);

		indexer.delete(esfOrganization);

		deleteESFOrganization(esfOrganizationId);
		organizationLocalService.deleteOrganization(esfOrganizationId);

		List<Address> addresses =
			AddressLocalServiceUtil.getAddresses(
				serviceContext.getCompanyId(), Organization.class.getName(),
				esfOrganizationId);
		for (Address address : addresses) {
			esfAddressLocalService.deleteESFAddress(address.getAddressId());
		}

		List<ESFField> esfFields =
			esfFieldLocalService.getESFFields(
				serviceContext.getScopeGroupId(), esfOrganizationId);

		for (ESFField esfField : esfFields) {
			esfFieldLocalService.deleteESFField(esfField.getEsfFieldId());
		}

		return esfOrganization;
	}

	public ESFOrganization updateESFOrganization(
		long userId, long esfOrganizationId, String name, String code,
		String vat, String fiscalCode, Date establishmentDate,
		Date closureDate, List<ESFAddress> esfAddresses,
		ServiceContext serviceContext)
		throws PortalException, SystemException {

		ESFOrganization esfOrganization =
			updateESFOrganization(
				userId, esfOrganizationId, name, code, vat, fiscalCode,
				establishmentDate, closureDate, serviceContext);

		try {
			for (ESFAddress esfAddress : esfAddresses) {
				if (esfAddressPersistence.fetchByPrimaryKey(esfAddress.getEsfAddressId()) != null) {
					System.out.println("Modifica address " + esfAddress.getStreet1());
					ESFAddressLocalServiceUtil.updateESFAddress(
						userId, esfAddress.getEsfAddressId(),
						esfAddress.getEsfCountryId(),
						esfAddress.getEsfRegionId(),
						esfAddress.getEsfProvinceId(),
						esfAddress.getEsfCityId(), esfAddress.getLatitude(),
						esfAddress.getLongitude(),
						Organization.class.getName(),
						esfOrganization.getEsfOrganizationId(),
						esfAddress.getStreet1(), esfAddress.getStreet2(),
						esfAddress.getStreet3(), esfAddress.getZip(), 12000,
						esfAddress.getMailing(), esfAddress.getPrimary_(),
						serviceContext);
				}
				else {
					System.out.println("Aggiunta address " + esfAddress.getEsfAddressId());
					ESFAddressLocalServiceUtil.addESFAddress(
						userId, esfAddress.getLongitude(),
						esfAddress.getEsfCountryId(),
						esfAddress.getEsfRegionId(),
						esfAddress.getEsfProvinceId(),
						esfAddress.getEsfCityId(), esfAddress.getLatitude(),
						Organization.class.getName(),
						esfOrganization.getEsfOrganizationId(),
						esfAddress.getStreet1(), esfAddress.getStreet2(),
						esfAddress.getStreet3(), esfAddress.getZip(), 12000,
						esfAddress.getMailing(), esfAddress.getPrimary_(),
						serviceContext);
				}
			}
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}

		return esfOrganization;

	}

	public ESFOrganization updateESFOrganization(
		long userId, long esfOrganizationId, String name, String code,
		String vat, String fiscalCode, Date establishmentDate,
		Date closureDate, ServiceContext serviceContext)
		throws PortalException, SystemException {

		validate(name);

		ESFOrganization esfOrganization = getESFOrganization(esfOrganizationId);

		esfOrganization.setCode(code);
		esfOrganization.setVat(vat);
		esfOrganization.setFiscalCode(fiscalCode);
		esfOrganization.setEstablishmentDate(establishmentDate);
		esfOrganization.setClosureDate(closureDate);

		esfOrganizationPersistence.update(esfOrganization);

		Organization organization =
			organizationPersistence.findByPrimaryKey(esfOrganization.getPrimaryKey());

		organization.setName(name);
		organization.setModifiedDate(new Date());

		organizationPersistence.update(organization);

		resourceLocalService.updateResources(
			serviceContext.getCompanyId(), serviceContext.getScopeGroupId(),
			name, esfOrganizationId, serviceContext.getGroupPermissions(),
			serviceContext.getGuestPermissions());

		AssetEntry assetEntry =
			assetEntryLocalService.updateEntry(
				organization.getUserId(), esfOrganization.getGroupId(),
				organization.getCreateDate(), organization.getModifiedDate(),
				ESFOrganization.class.getName(), esfOrganizationId,
				esfOrganization.getUuid(), 0,
				serviceContext.getAssetCategoryIds(),
				serviceContext.getAssetTagNames(), true, null, null, null,
				ContentTypes.TEXT_HTML, esfOrganization.getName(), null, null,
				null, null, 0, 0, null, false);

		assetLinkLocalService.updateLinks(
			serviceContext.getUserId(), assetEntry.getEntryId(),
			serviceContext.getAssetLinkEntryIds(),
			AssetLinkConstants.TYPE_RELATED);

		Indexer indexer =
			IndexerRegistryUtil.nullSafeGetIndexer(ESFOrganization.class);

		indexer.reindex(esfOrganization);

		return esfOrganization;
	}

	protected void validate(String name)
		throws PortalException {

		if (Validator.isNull(name)) {
			throw new ESFOrganizationNameException();
		}
	}
}
