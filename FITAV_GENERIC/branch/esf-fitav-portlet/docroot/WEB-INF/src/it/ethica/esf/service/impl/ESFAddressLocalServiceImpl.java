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
import java.util.List;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.Address;
import com.liferay.portal.service.AddressLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;

import it.ethica.esf.ESFAddressLatitudeException;
import it.ethica.esf.ESFAddressLongitudeException;
import it.ethica.esf.NoSuchAddressException;
import it.ethica.esf.model.ESFAddress;
import it.ethica.esf.model.ESFCity;
import it.ethica.esf.model.ESFCountry;
import it.ethica.esf.model.ESFProvince;
import it.ethica.esf.model.ESFRegion;
import it.ethica.esf.model.impl.ESFAddressImpl;
import it.ethica.esf.service.ESFAddressLocalServiceUtil;
import it.ethica.esf.service.base.ESFAddressLocalServiceBaseImpl;
import it.ethica.esf.service.persistence.CityPK;
import it.ethica.esf.service.persistence.ProvincePK;
import it.ethica.esf.service.persistence.RegionPK;
import it.ethica.esf.util.ESFKeys;

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
	public ESFAddress newESFAddress() {

		return new ESFAddressImpl();
	}

	public ESFAddress findByL_L(double longitude, double latitude)
		throws NoSuchAddressException, SystemException {

		return esfAddressPersistence.findByL_L(longitude, latitude);
	}

	public List<ESFAddress> getESFAddresses(
		long companyId, String className, long classPK)
		throws SystemException {
		List<Address> addresses =
			addressLocalService.getAddresses(companyId, className, classPK);
		List<ESFAddress> esfAddresses = new ArrayList<ESFAddress>();
		for (Address address : addresses) {
			esfAddresses.add(esfAddressPersistence.fetchByPrimaryKey(address.getAddressId()));
		}
		return esfAddresses;
	}

	public String getNameRegion(String idRegion)
		throws SystemException, NoSuchModelException {

		if (idRegion.equals(""))
			return "";

		RegionPK regionPk = new RegionPK();
		regionPk.setIdCountry(ESFKeys.ESFAddressConstant.DEFAULT_COUNTRY);
		regionPk.setIdRegion(idRegion);
		ESFRegion region = esfRegionPersistence.findByPrimaryKey(regionPk);

		return region.getName();
	}

	public String getNameProvince(String idRegion, String idProvince)
		throws SystemException, NoSuchModelException {

		if (idRegion.equals("") || idProvince.equals(""))
			return "";

		ProvincePK provincePk = new ProvincePK();
		provincePk.setIdCountry(ESFKeys.ESFAddressConstant.DEFAULT_COUNTRY);
		provincePk.setIdRegion(idRegion);
		provincePk.setIdProvince(idProvince);
		ESFProvince province =
			esfProvincePersistence.findByPrimaryKey(provincePk);

		return province.getName();
	}

	public String getNameCity(String idRegion, String idProvince, long idCity)
		throws SystemException, NoSuchModelException {

		if (idRegion.equals("") || idProvince.equals("") || idCity == 0)
			return "";

		CityPK cityPk = new CityPK();
		cityPk.setIdCountry(ESFKeys.ESFAddressConstant.DEFAULT_COUNTRY);
		cityPk.setIdRegion(idRegion);
		cityPk.setIdProvince(idProvince);
		cityPk.setIdCity(idCity);
		ESFCity city = esfCityPersistence.findByPrimaryKey(cityPk);

		return city.getName();
	}

	public List<ESFCountry> findAllCountry()
		throws SystemException {

		return esfCountryPersistence.findAll();
	}

	public List<ESFCountry> findAllCountry(int start, int end)
		throws SystemException {

		return esfCountryPersistence.findAll(start, end);
	}

	public List<ESFRegion> findAllRegions()
		throws SystemException {

		return esfRegionPersistence.findAll();
	}

	public List<ESFRegion> findByCountry(String idCountry)
		throws SystemException {

		return esfRegionPersistence.findByCountry(idCountry);
	}

	public List<ESFRegion> findByCountry(String idCountry, int start, int end)
		throws SystemException {

		return esfRegionPersistence.findByCountry(idCountry, start, end);
	}

	public List<ESFProvince> findByC_R(String idRegion, String idCountry)
		throws SystemException {

		return esfProvincePersistence.findByC_R(idRegion, idCountry);
	}

	public List<ESFProvince> findByC_R(
		String idRegion, String idCountry, int start, int end)
		throws SystemException {

		return esfProvincePersistence.findByC_R(idRegion, idCountry, start, end);
	}

	public List<ESFCity> findByC_R_P(
		String idCountry, String idRegion, String idProvince)
		throws SystemException {

		return esfCityPersistence.findByC_R_P(idCountry, idRegion, idProvince);
	}

	public List<ESFCity> findByC_R_P(
		String idCountry, String idRegion, String idProvince, int start, int end)
		throws SystemException {

		return esfCityPersistence.findByC_R_P(
			idCountry, idRegion, idProvince, start, end);
	}

	public ESFAddress addESFAddress(
		long userId, double longitude, String esfCountryId, String esfRegionId,
		String esfProvinceId, long esfCityId, double latitude, String type, int listTypeId,
		String className, long classPk, String street1, String street2,
		String street3, String zip, int typeId, boolean mailing,
		boolean primary, ServiceContext serviceContext)
		throws SystemException, PortalException {

		
		if (zip == null) {
			throw new SystemException();
		}

		long groupId = serviceContext.getScopeGroupId();

		userPersistence.findByPrimaryKey(userId);
		Address address = null;
		ESFAddress esfAddress = null;
		try {
			address =
				AddressLocalServiceUtil.addAddress(
					userId, className, classPk, street1, street2, street3,
					"city", zip, 0, 8, typeId, mailing, primary, serviceContext);

			long esfAddressId = address.getAddressId();

			esfAddress = esfAddressPersistence.create(esfAddressId);

			esfAddress.setGroupId(groupId);
			esfAddress.setEsfAddressId(esfAddressId);
			esfAddress.setLatitude(latitude);
			esfAddress.setLongitude(longitude);
			esfAddress.setEsfCityId(esfCityId);
			esfAddress.setEsfProvinceId(esfProvinceId);
			esfAddress.setEsfRegionId(esfRegionId);
			esfAddress.setEsfCountryId(esfCountryId);
			esfAddress.setType(type);
			esfAddress.setListTypeId(listTypeId);

			esfAddressPersistence.update(esfAddress);

		}
		catch (Exception e) {
			//e.printStackTrace();
		}

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
			double latitude, double longitude, String type, int listTypeId, String className,
			long classPk, String street1, String street2, String street3,
			String zip, int typeId, boolean mailing, boolean primary,
			ServiceContext serviceContext)
		throws PortalException, SystemException {

		long groupId = serviceContext.getScopeGroupId();
		Address address = null;
		ESFAddress esfAddress = null;

		try {
			address =
				AddressLocalServiceUtil.updateAddress(
					esfAddressId, street1, street2, street3, "city", zip, 0, 0,
					typeId, mailing, primary);

			esfAddress = getESFAddress(address.getAddressId());

			esfAddress.setGroupId(groupId);
			esfAddress.setLatitude(latitude);
			esfAddress.setLongitude(longitude);
			esfAddress.setEsfCityId(esfCityId);
			esfAddress.setEsfProvinceId(esfProvinceId);
			esfAddress.setEsfRegionId(esfRegionId);
			esfAddress.setEsfCountryId(esfCountryId);
			esfAddress.setType(type);
			esfAddress.setListTypeId(listTypeId);

			esfAddressPersistence.update(esfAddress);
		}
		catch (Exception e) {
			e.printStackTrace();
		}

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

		// resourceLocalService.deleteResource(
		// serviceContext.getCompanyId(), ESFAddress.class.getName(),
		// ResourceConstants.SCOPE_INDIVIDUAL, esfAddressId);

		try {
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
			throw new ESFAddressLatitudeException(
				"Latitude value is incorrect.");
		}

		if (Double.isNaN(longitude)) {
			throw new ESFAddressLongitudeException(
				"Longitude value is incorrect.");
		}
	}
	private static Log _log = LogFactoryUtil.getLog(ESFAddress.class);
}
