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

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;

import it.ethica.esf.model.ESFPartecipantInfo;
import it.ethica.esf.service.ESFPartecipantInfoLocalServiceUtil;
import it.ethica.esf.service.base.ESFPartecipantInfoLocalServiceBaseImpl;

/**
 * The implementation of the e s f partecipant info local service. <p> All
 * custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link it.ethica.esf.service.ESFPartecipantInfoLocalService} interface. <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM. </p>
 *
 * @author Ethica
 * @see it.ethica.esf.service.base.ESFPartecipantInfoLocalServiceBaseImpl
 * @see it.ethica.esf.service.ESFPartecipantInfoLocalServiceUtil
 */
public class ESFPartecipantInfoLocalServiceImpl
	extends ESFPartecipantInfoLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS: Never reference this interface directly. Always use
	 * {@link it.ethica.esf.service.ESFPartecipantInfoLocalServiceUtil} to
	 * access the e s f partecipant info local service.
	 */
	public List<ESFPartecipantInfo> getESFPartecipantInfosByFirstName_L_P(
		String firstName, String lastName, long protocol) {
		
		List<ESFPartecipantInfo> p = new ArrayList<ESFPartecipantInfo>();
		
		try {
			
			DynamicQuery esfPartecipantQuery =
							DynamicQueryFactoryUtil.forClass(
								ESFPartecipantInfo.class, "esfPartecipantQuery",
								PortletClassLoaderUtil.getClassLoader());
			
			if (Validator.isNotNull(firstName)) {
				esfPartecipantQuery.add(PropertyFactoryUtil.forName("esfPartecipantQuery.firstName").like(
					firstName + StringPool.PERCENT));
			}
			if (Validator.isNotNull(lastName)) {
				esfPartecipantQuery.add(PropertyFactoryUtil.forName("esfPartecipantQuery.lastName").like(
					lastName + StringPool.PERCENT));
			}
			if (Validator.isNotNull(protocol)) {
				esfPartecipantQuery.add(PropertyFactoryUtil.forName("esfPartecipantQuery.protocol").eq(
					protocol));
			}
			
			p = ESFPartecipantInfoLocalServiceUtil.dynamicQuery(esfPartecipantQuery);
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

	public List<ESFPartecipantInfo> getESFPartecipantInfosByFirstName_L_P(
		String firstName, String lastName, long protocol, int start, int end) {
		
		List<ESFPartecipantInfo> p = new ArrayList<ESFPartecipantInfo>();
		try {
			
			DynamicQuery esfPartecipantQuery =
							DynamicQueryFactoryUtil.forClass(
								ESFPartecipantInfo.class, "esfPartecipantQuery",
								PortletClassLoaderUtil.getClassLoader());
			
			if (Validator.isNotNull(firstName)) {
				esfPartecipantQuery.add(PropertyFactoryUtil.forName("esfPartecipantQuery.firstName").like(
					firstName + StringPool.PERCENT));
			}
			if (Validator.isNotNull(lastName)) {
				esfPartecipantQuery.add(PropertyFactoryUtil.forName("esfPartecipantQuery.lastName").like(
					lastName + StringPool.PERCENT));
			}
			if (Validator.isNotNull(protocol)) {
				esfPartecipantQuery.add(PropertyFactoryUtil.forName("esfPartecipantQuery.protocol").eq(
					protocol));
			}
			
			p = ESFPartecipantInfoLocalServiceUtil.dynamicQuery(esfPartecipantQuery, start, end);
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

	public void updateESFPartecipantInfo(
		long esfPartecipantInfoId, long groupId, long companyId, long userId,
		String userName, boolean isPortalUser, long esfUserId, long protocol,
		String firstName, String lastName, String placeOfBirth,
		Date dateOfBirth, String residenceCity, String province, int zip,
		String address, String phoneNumber, String email,
		String maritialStatus, String fiscalCode, String passport,
		String releasedBy, Date passportReleaseDate,
		Date passportExpirationDate, String europeanCardNumber,
		Date europeanCardReleaseDate, Date europeanCardExpirationDate,
		String gunLicenceNumber, Date gunLicenceReleaseDate,
		Date gunLicenceExpirationDate, String esfGunTypeNameOne,
		String esfGunKindNameOne, String firstGunCode, double firstGunCaliber,
		String firstGunExtraCanes, String esfGunTypeNameTwo,
		String esfGunKindNameTwo, String secondGunCode,
		double secondGunCaliber, String secondGunExtraCanes,
		String gunCartridgeType, String gunCartridgeKind,
		String cartridgeCaliber, long esfMatchId, long esfGunTypeIdOne,long esfGunKindIdOne, 
		long esfGunTypeIdTwo,long esfGunKindIdTwo) throws SystemException {

		ESFPartecipantInfo esfPartecipant =
			ESFPartecipantInfoLocalServiceUtil.fetchESFPartecipantInfo(esfPartecipantInfoId);
		esfPartecipant.setGroupId(groupId);
		esfPartecipant.setCompanyId(companyId);
		esfPartecipant.setUserId(userId);
		esfPartecipant.setUserName(userName);
		esfPartecipant.setModifiedDate(new Date());
		esfPartecipant.setIsPortalUser(isPortalUser);
		esfPartecipant.setEsfUserId(esfUserId);
		esfPartecipant.setProtocol(protocol);
		esfPartecipant.setFirstName(firstName);
		esfPartecipant.setLastName(lastName);
		esfPartecipant.setPlaceOfBirth(placeOfBirth);
		esfPartecipant.setDateOfBirth(dateOfBirth);
		esfPartecipant.setResidenceCity(residenceCity);
		esfPartecipant.setProvince(province);
		esfPartecipant.setZip(zip);
		esfPartecipant.setAddress(address);
		esfPartecipant.setPhonNumber(phoneNumber);
		esfPartecipant.setEmail(email);
		esfPartecipant.setMaritialStatus(maritialStatus);
		esfPartecipant.setFiscalCode(fiscalCode);
		esfPartecipant.setPassport(passport);
		esfPartecipant.setReleasedBy(releasedBy);
		esfPartecipant.setPassportReleaseDate(passportReleaseDate);
		esfPartecipant.setPassportExpirationDate(passportExpirationDate);
		esfPartecipant.setEuropeanCardNumber(europeanCardNumber);
		esfPartecipant.setEuropeanCardReleaseDate(europeanCardReleaseDate);
		esfPartecipant.setEuropeanCardExpirationDate(europeanCardExpirationDate);
		esfPartecipant.setGunLicenceNumber(gunLicenceNumber);
		esfPartecipant.setGunLicenceReleaseDate(gunLicenceReleaseDate);
		esfPartecipant.setGunLicenceExpirationDate(gunLicenceExpirationDate);
		esfPartecipant.setFirstGunType(esfGunTypeNameOne);
		esfPartecipant.setFirstGunKind(esfGunKindNameOne);
		esfPartecipant.setFirstGunCaliber(firstGunCaliber);
		esfPartecipant.setFirstGunCode(firstGunCode);
		esfPartecipant.setFirstGunExtraCanes(firstGunExtraCanes);
		esfPartecipant.setSecondGunType(esfGunTypeNameTwo);
		esfPartecipant.setSecondGunKind(esfGunKindNameTwo);
		esfPartecipant.setSecondGunCode(secondGunCode);
		esfPartecipant.setSecondGunExtraCanes(secondGunExtraCanes);
		esfPartecipant.setSecondGunCaliber(secondGunCaliber);
		esfPartecipant.setGunCartridgeType(gunCartridgeType);
		esfPartecipant.setGunCartridgeKind(gunCartridgeKind);
		esfPartecipant.setCartridgeCaliber(cartridgeCaliber);
		esfPartecipant.setEsfGunTypeIdOne(esfGunTypeIdOne);
		esfPartecipant.setEsfGunKindIdOne(esfGunKindIdOne);
		esfPartecipant.setEsfGunTypeIdTwo(esfGunTypeIdTwo);
		esfPartecipant.setEsfGunKindIdTwo(esfGunKindIdTwo);

		esfPartecipant.setCartridgeCaliber(cartridgeCaliber);
		
		ESFPartecipantInfoLocalServiceUtil.updateESFPartecipantInfo(esfPartecipant);
	}

	public void addESFPartecipantInfo(
		long groupId, long companyId, long userId, String userName,
		Date createDate, boolean isPortalUser, long esfUserId, long protocol,
		String firstName, String lastName, String placeOfBirth,
		Date dateOfBirth, String residenceCity, String province, int zip,
		String address, String phoneNumber, String email,
		String maritialStatus, String fiscalCode, String passport,
		String releasedBy, Date passportReleaseDate,
		Date passportExpirationDate, String europeanCardNumber,
		Date europeanCardReleaseDate, Date europeanCardExpirationDate,
		String gunLicenceNumber, Date gunLicenceReleaseDate,
		Date gunLicenceExpirationDate, String esfGunTypeNameOne,
		String esfGunKindNameOne, String firstGunCode, double firstGunCaliber,
		String firstGunExtraCanes, String esfGunTypeNameTwo,
		String esfGunKindNameTwo, String secondGunCode,
		double secondGunCaliber, String secondGunExtraCanes,
		String gunCartridgeType, String gunCartridgeKind,
		String cartridgeCaliber, long esfMatchId, long esfGunTypeIdOne,long esfGunKindIdOne, 
		long esfGunTypeIdTwo,long esfGunKindIdTwo)
		throws SystemException {

		long esfPartecipantInfoId =
			counterLocalService.increment(ESFPartecipantInfo.class.getName());
		ESFPartecipantInfo esfPartecipant =
			ESFPartecipantInfoLocalServiceUtil.createESFPartecipantInfo(esfPartecipantInfoId);

		esfPartecipant.setGroupId(groupId);
		esfPartecipant.setCompanyId(companyId);
		esfPartecipant.setUserId(userId);
		esfPartecipant.setUserName(userName);
		esfPartecipant.setCreateDate(createDate);
		esfPartecipant.setIsPortalUser(isPortalUser);
		esfPartecipant.setEsfUserId(esfUserId);
		esfPartecipant.setProtocol(protocol);
		esfPartecipant.setFirstName(firstName);
		esfPartecipant.setLastName(lastName);
		esfPartecipant.setPlaceOfBirth(placeOfBirth);
		esfPartecipant.setDateOfBirth(dateOfBirth);
		esfPartecipant.setResidenceCity(residenceCity);
		esfPartecipant.setProvince(province);
		if(zip != 0){
			esfPartecipant.setZip(zip);
		}
		esfPartecipant.setAddress(address);
		esfPartecipant.setPhonNumber(phoneNumber);
		esfPartecipant.setEmail(email);
		esfPartecipant.setMaritialStatus(maritialStatus);
		esfPartecipant.setFiscalCode(fiscalCode);
		esfPartecipant.setPassport(passport);
		esfPartecipant.setReleasedBy(releasedBy);
		esfPartecipant.setPassportReleaseDate(passportReleaseDate);
		esfPartecipant.setPassportExpirationDate(passportExpirationDate);
		esfPartecipant.setEuropeanCardNumber(europeanCardNumber);
		esfPartecipant.setEuropeanCardReleaseDate(europeanCardReleaseDate);
		esfPartecipant.setEuropeanCardExpirationDate(europeanCardExpirationDate);
		esfPartecipant.setGunLicenceNumber(gunLicenceNumber);
		esfPartecipant.setGunLicenceReleaseDate(gunLicenceReleaseDate);
		esfPartecipant.setGunLicenceExpirationDate(gunLicenceExpirationDate);
		esfPartecipant.setFirstGunType(esfGunTypeNameOne);
		esfPartecipant.setFirstGunKind(esfGunKindNameOne);
		esfPartecipant.setFirstGunCaliber(firstGunCaliber);
		esfPartecipant.setFirstGunCode(firstGunCode);
		esfPartecipant.setFirstGunExtraCanes(firstGunExtraCanes);
		esfPartecipant.setSecondGunType(esfGunTypeNameTwo);
		esfPartecipant.setSecondGunKind(esfGunKindNameTwo);
		esfPartecipant.setSecondGunCode(secondGunCode);
		esfPartecipant.setSecondGunExtraCanes(secondGunExtraCanes);
		if(secondGunCaliber != 0){
			esfPartecipant.setSecondGunCaliber(secondGunCaliber);
		}
		esfPartecipant.setGunCartridgeType(gunCartridgeType);
		esfPartecipant.setGunCartridgeKind(gunCartridgeKind);
		esfPartecipant.setCartridgeCaliber(cartridgeCaliber);
		esfPartecipant.setEsfMatchId(esfMatchId);
		
		esfPartecipant.setEsfGunTypeIdOne(esfGunTypeIdOne);
		esfPartecipant.setEsfGunKindIdOne(esfGunKindIdOne);
		esfPartecipant.setEsfGunTypeIdTwo(esfGunTypeIdTwo);
		esfPartecipant.setEsfGunKindIdTwo(esfGunKindIdTwo);

		ESFPartecipantInfoLocalServiceUtil.addESFPartecipantInfo(esfPartecipant);

	}


public long addESFPartecipantInfoAndReturnId(
	long groupId, long companyId, long userId, String userName,
	Date createDate, boolean isPortalUser, long esfUserId, long protocol,
	String firstName, String lastName, String placeOfBirth,
	Date dateOfBirth, String residenceCity, String province, int zip,
	String address, String phoneNumber, String email,
	String maritialStatus, String fiscalCode, String passport,
	String releasedBy, Date passportReleaseDate,
	Date passportExpirationDate, String europeanCardNumber,
	Date europeanCardReleaseDate, Date europeanCardExpirationDate,
	String gunLicenceNumber, Date gunLicenceReleaseDate,
	Date gunLicenceExpirationDate, String esfGunTypeNameOne,
	String esfGunKindNameOne, String firstGunCode, double firstGunCaliber,
	String firstGunExtraCanes, String esfGunTypeNameTwo,
	String esfGunKindNameTwo, String secondGunCode,
	double secondGunCaliber, String secondGunExtraCanes,
	String gunCartridgeType, String gunCartridgeKind,
	String cartridgeCaliber, long esfMatchId, long esfGunTypeIdOne,long esfGunKindIdOne, 
	long esfGunTypeIdTwo,long esfGunKindIdTwo)
	throws SystemException {

	long esfPartecipantInfoId =
		counterLocalService.increment(ESFPartecipantInfo.class.getName());
	ESFPartecipantInfo esfPartecipant =
		ESFPartecipantInfoLocalServiceUtil.createESFPartecipantInfo(esfPartecipantInfoId);

	esfPartecipant.setGroupId(groupId);
	esfPartecipant.setCompanyId(companyId);
	esfPartecipant.setUserId(userId);
	esfPartecipant.setUserName(userName);
	esfPartecipant.setCreateDate(createDate);
	esfPartecipant.setIsPortalUser(isPortalUser);
	esfPartecipant.setEsfUserId(esfUserId);
	esfPartecipant.setProtocol(protocol);
	esfPartecipant.setFirstName(firstName);
	esfPartecipant.setLastName(lastName);
	esfPartecipant.setPlaceOfBirth(placeOfBirth);
	esfPartecipant.setDateOfBirth(dateOfBirth);
	esfPartecipant.setResidenceCity(residenceCity);
	esfPartecipant.setProvince(province);
	if(zip != 0){
		esfPartecipant.setZip(zip);
	}
	esfPartecipant.setAddress(address);
	esfPartecipant.setPhonNumber(phoneNumber);
	esfPartecipant.setEmail(email);
	esfPartecipant.setMaritialStatus(maritialStatus);
	esfPartecipant.setFiscalCode(fiscalCode);
	esfPartecipant.setPassport(passport);
	esfPartecipant.setReleasedBy(releasedBy);
	esfPartecipant.setPassportReleaseDate(passportReleaseDate);
	esfPartecipant.setPassportExpirationDate(passportExpirationDate);
	esfPartecipant.setEuropeanCardNumber(europeanCardNumber);
	esfPartecipant.setEuropeanCardReleaseDate(europeanCardReleaseDate);
	esfPartecipant.setEuropeanCardExpirationDate(europeanCardExpirationDate);
	esfPartecipant.setGunLicenceNumber(gunLicenceNumber);
	esfPartecipant.setGunLicenceReleaseDate(gunLicenceReleaseDate);
	esfPartecipant.setGunLicenceExpirationDate(gunLicenceExpirationDate);
	esfPartecipant.setFirstGunType(esfGunTypeNameOne);
	esfPartecipant.setFirstGunKind(esfGunKindNameOne);
	esfPartecipant.setFirstGunCaliber(firstGunCaliber);
	esfPartecipant.setFirstGunCode(firstGunCode);
	esfPartecipant.setFirstGunExtraCanes(firstGunExtraCanes);
	esfPartecipant.setSecondGunType(esfGunTypeNameTwo);
	esfPartecipant.setSecondGunKind(esfGunKindNameTwo);
	esfPartecipant.setSecondGunCode(secondGunCode);
	esfPartecipant.setSecondGunExtraCanes(secondGunExtraCanes);
	if(secondGunCaliber != 0){
		esfPartecipant.setSecondGunCaliber(secondGunCaliber);
	}
	esfPartecipant.setGunCartridgeType(gunCartridgeType);
	esfPartecipant.setGunCartridgeKind(gunCartridgeKind);
	esfPartecipant.setCartridgeCaliber(cartridgeCaliber);
	esfPartecipant.setEsfMatchId(esfMatchId);
	
	esfPartecipant.setEsfGunTypeIdOne(esfGunTypeIdOne);
	esfPartecipant.setEsfGunKindIdOne(esfGunKindIdOne);
	esfPartecipant.setEsfGunTypeIdTwo(esfGunTypeIdTwo);
	esfPartecipant.setEsfGunKindIdTwo(esfGunKindIdTwo);

	ESFPartecipantInfoLocalServiceUtil.addESFPartecipantInfo(esfPartecipant);
	
	return esfPartecipant.getEsfPartecipantInfoId();
	}
}

