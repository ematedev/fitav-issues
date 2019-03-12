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

import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.Address;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.AddressLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.model.AssetLinkConstants;

import it.ethica.esf.ESFAddressLatitudeException;
import it.ethica.esf.ESFAddressLongitudeException;
import it.ethica.esf.NoSuchAddressException;
import it.ethica.esf.NoSuchCityException;
import it.ethica.esf.NoSuchProvinceException;
import it.ethica.esf.NoSuchRegionException;
import it.ethica.esf.model.City;
import it.ethica.esf.model.Country;
import it.ethica.esf.model.ESFAddress;
import it.ethica.esf.model.Province;
import it.ethica.esf.model.Region;
import it.ethica.esf.service.CountryLocalServiceUtil;
import it.ethica.esf.service.ESFAddressLocalServiceUtil;
import it.ethica.esf.service.RegionLocalServiceUtil;
import it.ethica.esf.service.base.ESFAddressLocalServiceBaseImpl;
import it.ethica.esf.service.persistence.CityPK;
import it.ethica.esf.service.persistence.ProvincePK;
import it.ethica.esf.service.persistence.RegionPK;
import it.ethica.esf.util.ESFConstant;

/**
 * The implementation of the e s f address local service. <p> All custom service
 * methods should be put in this class. Whenever methods are added, rerun
 * ServiceBuilder to copy their definitions into the
 * {@link it.ethica.esf.service.ESFAddressLocalService} interface. <p> This is a
 * local service. Methods of this service will not have security checks based on
 * the propagated JAAS credentials because this service can only be accessed
 * from within the same VM. </p>
 *
 * @author Ethica
 * @see it.ethica.esf.service.base.ESFAddressLocalServiceBaseImpl
 * @see it.ethica.esf.service.ESFAddressLocalServiceUtil
 */
public class ESFAddressLocalServiceImpl extends ESFAddressLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS: Never reference this interface directly. Always use
	 * {@link it.ethica.esf.service.ESFAddressLocalServiceUtil} to access the e
	 * s f address local service.
	 */

	public String getNameRegion(String idRegion)
		throws NoSuchRegionException, SystemException {

		if (idRegion.equals(""))
			return "";

		RegionPK regionPk = new RegionPK();
		regionPk.setIdCountry(ESFConstant.DEFAULT_COUNTRY);
		regionPk.setIdRegion(idRegion);
		Region region = regionPersistence.findByPrimaryKey(regionPk);

		return region.getName();
	}

	public String getNameProvince(String idRegion, String idProvince)
		throws NoSuchProvinceException, SystemException {

		if (idRegion.equals("") || idProvince.equals(""))
			return "";

		ProvincePK provincePk = new ProvincePK();
		provincePk.setIdCountry(ESFConstant.DEFAULT_COUNTRY);
		provincePk.setIdRegion(idRegion);
		provincePk.setIdProvince(idProvince);
		Province province = provincePersistence.findByPrimaryKey(provincePk);

		return province.getName();
	}

	public String getNameCity(String idRegion, String idProvince, long idCity)
		throws NoSuchCityException, SystemException {

		if (idRegion.equals("") || idProvince.equals("") || idCity == 0)
			return "";

		CityPK cityPk = new CityPK();
		cityPk.setIdCountry(ESFConstant.DEFAULT_COUNTRY);
		cityPk.setIdRegion(idRegion);
		cityPk.setIdProvince(idProvince);
		cityPk.setIdCity(idCity);
		City city = cityPersistence.findByPrimaryKey(cityPk);

		return city.getName();
	}

	public List<Country> findAllCountry()
		throws SystemException {

		return countryPersistence.findAll();
	}

	public List<Country> findAllCountry(int start, int end)
		throws SystemException {

		return countryPersistence.findAll(start, end);
	}

	public List<Region> findAllRegions()
		throws SystemException {

		return regionPersistence.findAll();
	}

	public List<Region> findByCountry(String idCountry)
		throws SystemException {

		return regionPersistence.findByCountry(idCountry);
	}

	public List<Region> findByCountry(String idCountry, int start, int end)
		throws SystemException {

		return regionPersistence.findByCountry(idCountry, start, end);
	}

	public List<Province> findByC_R(String idRegion, String idCountry)
		throws SystemException {

		return provincePersistence.findByC_R(idRegion, idCountry);
	}

	public List<Province> findByC_R(
		String idRegion, String idCountry, int start, int end)
		throws SystemException {

		return provincePersistence.findByC_R(idRegion, idCountry, start, end);
	}

	public List<City> findByC_R_P(String idCountry, String idRegion, String idProvince)
		throws SystemException {

		return cityPersistence.findByC_R_P(idCountry, idRegion, idProvince);
	}

	public List<City> findByC_R_P(
		String idCountry, String idRegion, String idProvince, int start, int end)
		throws SystemException {

		return cityPersistence.findByC_R_P(
			idCountry, idRegion, idProvince, start, end);
	}

	/**
	 * Ritorna un oggetto ESFAddress sulla base dei parametri in input
	 * 
	 * @param longitude
	 * @param latitude
	 * @return ESFAddress
	 * @throws NoSuchAddressException
	 * @throws SystemException
	 */
	public ESFAddress findByL_L(double longitude, double latitude)
		throws NoSuchAddressException, SystemException {

		return esfAddressPersistence.findByL_L(longitude, latitude);
	}

	/**
	 * Inserimento dell' elemento ESFAddress
	 * 
	 * @param userId
	 * @param longitude
	 * @param esfCountryId
	 * @param esfRegionId
	 * @param esfProvinceId
	 * @param esfCityId
	 * @param latitude
	 * @param className
	 * @param classNameId
	 * @param classPk
	 * @param street1
	 * @param street2
	 * @param street3
	 * @param zip
	 * @param typeId
	 * @param mailing
	 * @param primary
	 * @param serviceContext
	 * @return ESFAddress
	 * @throws SystemException
	 * @throws PortalException
	 */
	public ESFAddress addESFAddress(
		long userId, double longitude, String esfCountryId, String esfRegionId,
		String esfProvinceId, long esfCityId, double latitude,
		String className, long classPk, String street1, String street2,
		String street3, String zip, int typeId, boolean mailing,
		boolean primary, ServiceContext serviceContext)
		throws SystemException, PortalException {

		// validate(longitude, latitude);

		long groupId = serviceContext.getScopeGroupId();

		User user = userPersistence.findByPrimaryKey(userId);
		Address address = null;
		try {
			address =
				AddressLocalServiceUtil.addAddress(
					userId, className, classPk, street1, street2, street3,
					"city", zip, 0, 0, typeId, mailing, primary, serviceContext);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		long esfAddressId = address.getAddressId();

		ESFAddress esfAddress = esfAddressPersistence.create(esfAddressId);

		esfAddress.setGroupId(groupId);
		esfAddress.setEsfAddressId(esfAddressId);
		esfAddress.setLatitude(latitude);
		esfAddress.setLongitude(longitude);
		esfAddress.setEsfCityId(esfCityId);
		esfAddress.setEsfProvinceId(esfProvinceId);
		esfAddress.setEsfRegionId(esfRegionId);
		esfAddress.setEsfCountryId(esfCountryId);

		esfAddressPersistence.update(esfAddress);

		resourceLocalService.addResources(
			user.getCompanyId(), groupId, userId, ESFAddress.class.getName(),
			esfAddressId, false, true, true);

		AssetEntry assetEntry =
			assetEntryLocalService.updateEntry(
				userId, groupId, esfAddress.getCreateDate(),
				esfAddress.getModifiedDate(), ESFAddress.class.getName(),
				esfAddressId, address.getUuid(), 0,
				serviceContext.getAssetCategoryIds(),
				serviceContext.getAssetTagNames(), true, null, null, null,
				ContentTypes.TEXT_HTML, esfAddress.getStreet1(), null, null,
				null, null, 0, 0, null, false);

		assetLinkLocalService.updateLinks(
			userId, assetEntry.getEntryId(),
			serviceContext.getAssetLinkEntryIds(),
			AssetLinkConstants.TYPE_RELATED);

		Indexer indexer =
			IndexerRegistryUtil.nullSafeGetIndexer(ESFAddress.class);
		indexer.reindex(esfAddress);

		return esfAddress;
	}

	/**
	 * Update dell'elemento ESFAddress
	 * 
	 * @param userId
	 * @param esfAddressId
	 * @param esfCountryId
	 * @param esfRegionId
	 * @param esfProvinceId
	 * @param esfCityId
	 * @param latitude
	 * @param longitude
	 * @param className
	 * @param classNameId
	 * @param classPk
	 * @param street1
	 * @param street2
	 * @param street3
	 * @param zip
	 * @param typeId
	 * @param mailing
	 * @param primary
	 * @param serviceContext
	 * @return ESFAddress
	 * @throws PortalException
	 * @throws SystemException
	 */
	public ESFAddress updateESFAddress(
		long userId, long esfAddressId, String esfCountryId,
		String esfRegionId, String esfProvinceId, long esfCityId,
		double latitude, double longitude, String className, long classPk,
		String street1, String street2, String street3, String zip, int typeId,
		boolean mailing, boolean primary, ServiceContext serviceContext)
		throws PortalException, SystemException {

		// validate(longitude, latitude);

		long groupId = serviceContext.getScopeGroupId();
		Address address = null;
		try {
			address =
				AddressLocalServiceUtil.updateAddress(
					esfAddressId, street1, street2, street3, "city", zip, 0, 0,
					typeId, mailing, primary);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		ESFAddress esfAddress = getESFAddress(address.getAddressId());

		esfAddress.setGroupId(groupId);
		esfAddress.setLatitude(latitude);
		esfAddress.setLongitude(longitude);
		esfAddress.setEsfCityId(esfCityId);
		esfAddress.setEsfProvinceId(esfProvinceId);
		esfAddress.setEsfRegionId(esfRegionId);
		esfAddress.setEsfCountryId(esfCountryId);

		esfAddressPersistence.update(esfAddress);

		resourceLocalService.updateResources(
			serviceContext.getCompanyId(), serviceContext.getScopeGroupId(),
			ESFAddress.class.getName(), esfAddress.getEsfAddressId(),
			serviceContext.getGroupPermissions(),
			serviceContext.getGuestPermissions());

		AssetEntry assetEntry =
			assetEntryLocalService.updateEntry(
				esfAddress.getUserId(), groupId, esfAddress.getCreateDate(),
				esfAddress.getModifiedDate(), ESFAddress.class.getName(),
				esfAddressId, esfAddress.getUuid(), 0,
				serviceContext.getAssetCategoryIds(),
				serviceContext.getAssetTagNames(), true, null, null, null,
				ContentTypes.TEXT_HTML, esfAddress.getStreet1(), null, null,
				null, null, 0, 0, null, false);

		assetLinkLocalService.updateLinks(
			serviceContext.getUserId(), assetEntry.getEntryId(),
			serviceContext.getAssetLinkEntryIds(),
			AssetLinkConstants.TYPE_RELATED);

		Indexer indexer =
			IndexerRegistryUtil.nullSafeGetIndexer(ESFAddress.class);
		indexer.reindex(esfAddress);

		return esfAddress;
	}

	/**
	 * Delete dell'elemento ESFAddress
	 * 
	 * @param esfAddressId
	 * @param serviceContext
	 * @return ESFAddress
	 * @throws SystemException
	 * @throws PortalException
	 */
	public ESFAddress deleteESFAddress(
		long esfAddressId, ServiceContext serviceContext)
		throws SystemException, PortalException {

		ESFAddress esfAddress = getESFAddress(esfAddressId);

		resourceLocalService.deleteResource(
			serviceContext.getCompanyId(), ESFAddress.class.getName(),
			ResourceConstants.SCOPE_INDIVIDUAL, esfAddressId);

		AssetEntry assetEntry =
			assetEntryLocalService.fetchEntry(
				ESFAddress.class.getName(), esfAddressId);

		assetLinkLocalService.deleteLinks(assetEntry.getEntryId());

		assetEntryLocalService.deleteEntry(assetEntry);

		Indexer indexer =
			IndexerRegistryUtil.nullSafeGetIndexer(ESFAddress.class);

		indexer.delete(esfAddress);

		try {
			esfAddress =
				ESFAddressLocalServiceUtil.deleteESFAddress(esfAddressId);
			AddressLocalServiceUtil.deleteAddress(esfAddressId);
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return esfAddress;
	}

	protected void validate(double longitude, double latitude)
		throws PortalException {

		if (Double.isNaN(latitude)) {
			throw new ESFAddressLatitudeException("La latitudine è scorretta");
		}

		if (Double.isNaN(longitude)) {
			throw new ESFAddressLongitudeException("La longitudine è scorretta");
		}
	}
}
