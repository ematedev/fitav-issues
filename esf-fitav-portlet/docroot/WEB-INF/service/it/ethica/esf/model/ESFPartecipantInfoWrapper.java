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

package it.ethica.esf.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ESFPartecipantInfo}.
 * </p>
 *
 * @author Ethica
 * @see ESFPartecipantInfo
 * @generated
 */
public class ESFPartecipantInfoWrapper implements ESFPartecipantInfo,
	ModelWrapper<ESFPartecipantInfo> {
	public ESFPartecipantInfoWrapper(ESFPartecipantInfo esfPartecipantInfo) {
		_esfPartecipantInfo = esfPartecipantInfo;
	}

	@Override
	public Class<?> getModelClass() {
		return ESFPartecipantInfo.class;
	}

	@Override
	public String getModelClassName() {
		return ESFPartecipantInfo.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfPartecipantInfoId", getEsfPartecipantInfoId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("isPortalUser", getIsPortalUser());
		attributes.put("esfUserId", getEsfUserId());
		attributes.put("protocol", getProtocol());
		attributes.put("firstName", getFirstName());
		attributes.put("lastName", getLastName());
		attributes.put("placeOfBirth", getPlaceOfBirth());
		attributes.put("dateOfBirth", getDateOfBirth());
		attributes.put("residenceCity", getResidenceCity());
		attributes.put("province", getProvince());
		attributes.put("zip", getZip());
		attributes.put("address", getAddress());
		attributes.put("phonNumber", getPhonNumber());
		attributes.put("email", getEmail());
		attributes.put("maritialStatus", getMaritialStatus());
		attributes.put("fiscalCode", getFiscalCode());
		attributes.put("passport", getPassport());
		attributes.put("releasedBy", getReleasedBy());
		attributes.put("passportReleaseDate", getPassportReleaseDate());
		attributes.put("passportExpirationDate", getPassportExpirationDate());
		attributes.put("europeanCardNumber", getEuropeanCardNumber());
		attributes.put("europeanCardReleaseDate", getEuropeanCardReleaseDate());
		attributes.put("europeanCardExpirationDate",
			getEuropeanCardExpirationDate());
		attributes.put("gunLicenceNumber", getGunLicenceNumber());
		attributes.put("gunLicenceReleaseDate", getGunLicenceReleaseDate());
		attributes.put("gunLicenceExpirationDate", getGunLicenceExpirationDate());
		attributes.put("firstGunType", getFirstGunType());
		attributes.put("firstGunKind", getFirstGunKind());
		attributes.put("firstGunCaliber", getFirstGunCaliber());
		attributes.put("firstGunCode", getFirstGunCode());
		attributes.put("firstGunExtraCanes", getFirstGunExtraCanes());
		attributes.put("secondGunType", getSecondGunType());
		attributes.put("secondGunKind", getSecondGunKind());
		attributes.put("secondGunCaliber", getSecondGunCaliber());
		attributes.put("secondGunCode", getSecondGunCode());
		attributes.put("secondGunExtraCanes", getSecondGunExtraCanes());
		attributes.put("gunCartridgeType", getGunCartridgeType());
		attributes.put("gunCartridgeKind", getGunCartridgeKind());
		attributes.put("cartridgeCaliber", getCartridgeCaliber());
		attributes.put("esfMatchId", getEsfMatchId());
		attributes.put("esfGunTypeIdOne", getEsfGunTypeIdOne());
		attributes.put("esfGunKindIdOne", getEsfGunKindIdOne());
		attributes.put("esfGunTypeIdTwo", getEsfGunTypeIdTwo());
		attributes.put("esfGunKindIdTwo", getEsfGunKindIdTwo());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esfPartecipantInfoId = (Long)attributes.get("esfPartecipantInfoId");

		if (esfPartecipantInfoId != null) {
			setEsfPartecipantInfoId(esfPartecipantInfoId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Boolean isPortalUser = (Boolean)attributes.get("isPortalUser");

		if (isPortalUser != null) {
			setIsPortalUser(isPortalUser);
		}

		Long esfUserId = (Long)attributes.get("esfUserId");

		if (esfUserId != null) {
			setEsfUserId(esfUserId);
		}

		Long protocol = (Long)attributes.get("protocol");

		if (protocol != null) {
			setProtocol(protocol);
		}

		String firstName = (String)attributes.get("firstName");

		if (firstName != null) {
			setFirstName(firstName);
		}

		String lastName = (String)attributes.get("lastName");

		if (lastName != null) {
			setLastName(lastName);
		}

		String placeOfBirth = (String)attributes.get("placeOfBirth");

		if (placeOfBirth != null) {
			setPlaceOfBirth(placeOfBirth);
		}

		Date dateOfBirth = (Date)attributes.get("dateOfBirth");

		if (dateOfBirth != null) {
			setDateOfBirth(dateOfBirth);
		}

		String residenceCity = (String)attributes.get("residenceCity");

		if (residenceCity != null) {
			setResidenceCity(residenceCity);
		}

		String province = (String)attributes.get("province");

		if (province != null) {
			setProvince(province);
		}

		Integer zip = (Integer)attributes.get("zip");

		if (zip != null) {
			setZip(zip);
		}

		String address = (String)attributes.get("address");

		if (address != null) {
			setAddress(address);
		}

		String phonNumber = (String)attributes.get("phonNumber");

		if (phonNumber != null) {
			setPhonNumber(phonNumber);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String maritialStatus = (String)attributes.get("maritialStatus");

		if (maritialStatus != null) {
			setMaritialStatus(maritialStatus);
		}

		String fiscalCode = (String)attributes.get("fiscalCode");

		if (fiscalCode != null) {
			setFiscalCode(fiscalCode);
		}

		String passport = (String)attributes.get("passport");

		if (passport != null) {
			setPassport(passport);
		}

		String releasedBy = (String)attributes.get("releasedBy");

		if (releasedBy != null) {
			setReleasedBy(releasedBy);
		}

		Date passportReleaseDate = (Date)attributes.get("passportReleaseDate");

		if (passportReleaseDate != null) {
			setPassportReleaseDate(passportReleaseDate);
		}

		Date passportExpirationDate = (Date)attributes.get(
				"passportExpirationDate");

		if (passportExpirationDate != null) {
			setPassportExpirationDate(passportExpirationDate);
		}

		String europeanCardNumber = (String)attributes.get("europeanCardNumber");

		if (europeanCardNumber != null) {
			setEuropeanCardNumber(europeanCardNumber);
		}

		Date europeanCardReleaseDate = (Date)attributes.get(
				"europeanCardReleaseDate");

		if (europeanCardReleaseDate != null) {
			setEuropeanCardReleaseDate(europeanCardReleaseDate);
		}

		Date europeanCardExpirationDate = (Date)attributes.get(
				"europeanCardExpirationDate");

		if (europeanCardExpirationDate != null) {
			setEuropeanCardExpirationDate(europeanCardExpirationDate);
		}

		String gunLicenceNumber = (String)attributes.get("gunLicenceNumber");

		if (gunLicenceNumber != null) {
			setGunLicenceNumber(gunLicenceNumber);
		}

		Date gunLicenceReleaseDate = (Date)attributes.get(
				"gunLicenceReleaseDate");

		if (gunLicenceReleaseDate != null) {
			setGunLicenceReleaseDate(gunLicenceReleaseDate);
		}

		Date gunLicenceExpirationDate = (Date)attributes.get(
				"gunLicenceExpirationDate");

		if (gunLicenceExpirationDate != null) {
			setGunLicenceExpirationDate(gunLicenceExpirationDate);
		}

		String firstGunType = (String)attributes.get("firstGunType");

		if (firstGunType != null) {
			setFirstGunType(firstGunType);
		}

		String firstGunKind = (String)attributes.get("firstGunKind");

		if (firstGunKind != null) {
			setFirstGunKind(firstGunKind);
		}

		Double firstGunCaliber = (Double)attributes.get("firstGunCaliber");

		if (firstGunCaliber != null) {
			setFirstGunCaliber(firstGunCaliber);
		}

		String firstGunCode = (String)attributes.get("firstGunCode");

		if (firstGunCode != null) {
			setFirstGunCode(firstGunCode);
		}

		String firstGunExtraCanes = (String)attributes.get("firstGunExtraCanes");

		if (firstGunExtraCanes != null) {
			setFirstGunExtraCanes(firstGunExtraCanes);
		}

		String secondGunType = (String)attributes.get("secondGunType");

		if (secondGunType != null) {
			setSecondGunType(secondGunType);
		}

		String secondGunKind = (String)attributes.get("secondGunKind");

		if (secondGunKind != null) {
			setSecondGunKind(secondGunKind);
		}

		Double secondGunCaliber = (Double)attributes.get("secondGunCaliber");

		if (secondGunCaliber != null) {
			setSecondGunCaliber(secondGunCaliber);
		}

		String secondGunCode = (String)attributes.get("secondGunCode");

		if (secondGunCode != null) {
			setSecondGunCode(secondGunCode);
		}

		String secondGunExtraCanes = (String)attributes.get(
				"secondGunExtraCanes");

		if (secondGunExtraCanes != null) {
			setSecondGunExtraCanes(secondGunExtraCanes);
		}

		String gunCartridgeType = (String)attributes.get("gunCartridgeType");

		if (gunCartridgeType != null) {
			setGunCartridgeType(gunCartridgeType);
		}

		String gunCartridgeKind = (String)attributes.get("gunCartridgeKind");

		if (gunCartridgeKind != null) {
			setGunCartridgeKind(gunCartridgeKind);
		}

		String cartridgeCaliber = (String)attributes.get("cartridgeCaliber");

		if (cartridgeCaliber != null) {
			setCartridgeCaliber(cartridgeCaliber);
		}

		Long esfMatchId = (Long)attributes.get("esfMatchId");

		if (esfMatchId != null) {
			setEsfMatchId(esfMatchId);
		}

		Long esfGunTypeIdOne = (Long)attributes.get("esfGunTypeIdOne");

		if (esfGunTypeIdOne != null) {
			setEsfGunTypeIdOne(esfGunTypeIdOne);
		}

		Long esfGunKindIdOne = (Long)attributes.get("esfGunKindIdOne");

		if (esfGunKindIdOne != null) {
			setEsfGunKindIdOne(esfGunKindIdOne);
		}

		Long esfGunTypeIdTwo = (Long)attributes.get("esfGunTypeIdTwo");

		if (esfGunTypeIdTwo != null) {
			setEsfGunTypeIdTwo(esfGunTypeIdTwo);
		}

		Long esfGunKindIdTwo = (Long)attributes.get("esfGunKindIdTwo");

		if (esfGunKindIdTwo != null) {
			setEsfGunKindIdTwo(esfGunKindIdTwo);
		}
	}

	/**
	* Returns the primary key of this e s f partecipant info.
	*
	* @return the primary key of this e s f partecipant info
	*/
	@Override
	public long getPrimaryKey() {
		return _esfPartecipantInfo.getPrimaryKey();
	}

	/**
	* Sets the primary key of this e s f partecipant info.
	*
	* @param primaryKey the primary key of this e s f partecipant info
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_esfPartecipantInfo.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the esf partecipant info ID of this e s f partecipant info.
	*
	* @return the esf partecipant info ID of this e s f partecipant info
	*/
	@Override
	public long getEsfPartecipantInfoId() {
		return _esfPartecipantInfo.getEsfPartecipantInfoId();
	}

	/**
	* Sets the esf partecipant info ID of this e s f partecipant info.
	*
	* @param esfPartecipantInfoId the esf partecipant info ID of this e s f partecipant info
	*/
	@Override
	public void setEsfPartecipantInfoId(long esfPartecipantInfoId) {
		_esfPartecipantInfo.setEsfPartecipantInfoId(esfPartecipantInfoId);
	}

	/**
	* Returns the group ID of this e s f partecipant info.
	*
	* @return the group ID of this e s f partecipant info
	*/
	@Override
	public long getGroupId() {
		return _esfPartecipantInfo.getGroupId();
	}

	/**
	* Sets the group ID of this e s f partecipant info.
	*
	* @param groupId the group ID of this e s f partecipant info
	*/
	@Override
	public void setGroupId(long groupId) {
		_esfPartecipantInfo.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this e s f partecipant info.
	*
	* @return the company ID of this e s f partecipant info
	*/
	@Override
	public long getCompanyId() {
		return _esfPartecipantInfo.getCompanyId();
	}

	/**
	* Sets the company ID of this e s f partecipant info.
	*
	* @param companyId the company ID of this e s f partecipant info
	*/
	@Override
	public void setCompanyId(long companyId) {
		_esfPartecipantInfo.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this e s f partecipant info.
	*
	* @return the user ID of this e s f partecipant info
	*/
	@Override
	public long getUserId() {
		return _esfPartecipantInfo.getUserId();
	}

	/**
	* Sets the user ID of this e s f partecipant info.
	*
	* @param userId the user ID of this e s f partecipant info
	*/
	@Override
	public void setUserId(long userId) {
		_esfPartecipantInfo.setUserId(userId);
	}

	/**
	* Returns the user uuid of this e s f partecipant info.
	*
	* @return the user uuid of this e s f partecipant info
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfPartecipantInfo.getUserUuid();
	}

	/**
	* Sets the user uuid of this e s f partecipant info.
	*
	* @param userUuid the user uuid of this e s f partecipant info
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_esfPartecipantInfo.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this e s f partecipant info.
	*
	* @return the user name of this e s f partecipant info
	*/
	@Override
	public java.lang.String getUserName() {
		return _esfPartecipantInfo.getUserName();
	}

	/**
	* Sets the user name of this e s f partecipant info.
	*
	* @param userName the user name of this e s f partecipant info
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_esfPartecipantInfo.setUserName(userName);
	}

	/**
	* Returns the create date of this e s f partecipant info.
	*
	* @return the create date of this e s f partecipant info
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _esfPartecipantInfo.getCreateDate();
	}

	/**
	* Sets the create date of this e s f partecipant info.
	*
	* @param createDate the create date of this e s f partecipant info
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_esfPartecipantInfo.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this e s f partecipant info.
	*
	* @return the modified date of this e s f partecipant info
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _esfPartecipantInfo.getModifiedDate();
	}

	/**
	* Sets the modified date of this e s f partecipant info.
	*
	* @param modifiedDate the modified date of this e s f partecipant info
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_esfPartecipantInfo.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the is portal user of this e s f partecipant info.
	*
	* @return the is portal user of this e s f partecipant info
	*/
	@Override
	public boolean getIsPortalUser() {
		return _esfPartecipantInfo.getIsPortalUser();
	}

	/**
	* Returns <code>true</code> if this e s f partecipant info is is portal user.
	*
	* @return <code>true</code> if this e s f partecipant info is is portal user; <code>false</code> otherwise
	*/
	@Override
	public boolean isIsPortalUser() {
		return _esfPartecipantInfo.isIsPortalUser();
	}

	/**
	* Sets whether this e s f partecipant info is is portal user.
	*
	* @param isPortalUser the is portal user of this e s f partecipant info
	*/
	@Override
	public void setIsPortalUser(boolean isPortalUser) {
		_esfPartecipantInfo.setIsPortalUser(isPortalUser);
	}

	/**
	* Returns the esf user ID of this e s f partecipant info.
	*
	* @return the esf user ID of this e s f partecipant info
	*/
	@Override
	public long getEsfUserId() {
		return _esfPartecipantInfo.getEsfUserId();
	}

	/**
	* Sets the esf user ID of this e s f partecipant info.
	*
	* @param esfUserId the esf user ID of this e s f partecipant info
	*/
	@Override
	public void setEsfUserId(long esfUserId) {
		_esfPartecipantInfo.setEsfUserId(esfUserId);
	}

	/**
	* Returns the esf user uuid of this e s f partecipant info.
	*
	* @return the esf user uuid of this e s f partecipant info
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getEsfUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfPartecipantInfo.getEsfUserUuid();
	}

	/**
	* Sets the esf user uuid of this e s f partecipant info.
	*
	* @param esfUserUuid the esf user uuid of this e s f partecipant info
	*/
	@Override
	public void setEsfUserUuid(java.lang.String esfUserUuid) {
		_esfPartecipantInfo.setEsfUserUuid(esfUserUuid);
	}

	/**
	* Returns the protocol of this e s f partecipant info.
	*
	* @return the protocol of this e s f partecipant info
	*/
	@Override
	public long getProtocol() {
		return _esfPartecipantInfo.getProtocol();
	}

	/**
	* Sets the protocol of this e s f partecipant info.
	*
	* @param protocol the protocol of this e s f partecipant info
	*/
	@Override
	public void setProtocol(long protocol) {
		_esfPartecipantInfo.setProtocol(protocol);
	}

	/**
	* Returns the first name of this e s f partecipant info.
	*
	* @return the first name of this e s f partecipant info
	*/
	@Override
	public java.lang.String getFirstName() {
		return _esfPartecipantInfo.getFirstName();
	}

	/**
	* Sets the first name of this e s f partecipant info.
	*
	* @param firstName the first name of this e s f partecipant info
	*/
	@Override
	public void setFirstName(java.lang.String firstName) {
		_esfPartecipantInfo.setFirstName(firstName);
	}

	/**
	* Returns the last name of this e s f partecipant info.
	*
	* @return the last name of this e s f partecipant info
	*/
	@Override
	public java.lang.String getLastName() {
		return _esfPartecipantInfo.getLastName();
	}

	/**
	* Sets the last name of this e s f partecipant info.
	*
	* @param lastName the last name of this e s f partecipant info
	*/
	@Override
	public void setLastName(java.lang.String lastName) {
		_esfPartecipantInfo.setLastName(lastName);
	}

	/**
	* Returns the place of birth of this e s f partecipant info.
	*
	* @return the place of birth of this e s f partecipant info
	*/
	@Override
	public java.lang.String getPlaceOfBirth() {
		return _esfPartecipantInfo.getPlaceOfBirth();
	}

	/**
	* Sets the place of birth of this e s f partecipant info.
	*
	* @param placeOfBirth the place of birth of this e s f partecipant info
	*/
	@Override
	public void setPlaceOfBirth(java.lang.String placeOfBirth) {
		_esfPartecipantInfo.setPlaceOfBirth(placeOfBirth);
	}

	/**
	* Returns the date of birth of this e s f partecipant info.
	*
	* @return the date of birth of this e s f partecipant info
	*/
	@Override
	public java.util.Date getDateOfBirth() {
		return _esfPartecipantInfo.getDateOfBirth();
	}

	/**
	* Sets the date of birth of this e s f partecipant info.
	*
	* @param dateOfBirth the date of birth of this e s f partecipant info
	*/
	@Override
	public void setDateOfBirth(java.util.Date dateOfBirth) {
		_esfPartecipantInfo.setDateOfBirth(dateOfBirth);
	}

	/**
	* Returns the residence city of this e s f partecipant info.
	*
	* @return the residence city of this e s f partecipant info
	*/
	@Override
	public java.lang.String getResidenceCity() {
		return _esfPartecipantInfo.getResidenceCity();
	}

	/**
	* Sets the residence city of this e s f partecipant info.
	*
	* @param residenceCity the residence city of this e s f partecipant info
	*/
	@Override
	public void setResidenceCity(java.lang.String residenceCity) {
		_esfPartecipantInfo.setResidenceCity(residenceCity);
	}

	/**
	* Returns the province of this e s f partecipant info.
	*
	* @return the province of this e s f partecipant info
	*/
	@Override
	public java.lang.String getProvince() {
		return _esfPartecipantInfo.getProvince();
	}

	/**
	* Sets the province of this e s f partecipant info.
	*
	* @param province the province of this e s f partecipant info
	*/
	@Override
	public void setProvince(java.lang.String province) {
		_esfPartecipantInfo.setProvince(province);
	}

	/**
	* Returns the zip of this e s f partecipant info.
	*
	* @return the zip of this e s f partecipant info
	*/
	@Override
	public int getZip() {
		return _esfPartecipantInfo.getZip();
	}

	/**
	* Sets the zip of this e s f partecipant info.
	*
	* @param zip the zip of this e s f partecipant info
	*/
	@Override
	public void setZip(int zip) {
		_esfPartecipantInfo.setZip(zip);
	}

	/**
	* Returns the address of this e s f partecipant info.
	*
	* @return the address of this e s f partecipant info
	*/
	@Override
	public java.lang.String getAddress() {
		return _esfPartecipantInfo.getAddress();
	}

	/**
	* Sets the address of this e s f partecipant info.
	*
	* @param address the address of this e s f partecipant info
	*/
	@Override
	public void setAddress(java.lang.String address) {
		_esfPartecipantInfo.setAddress(address);
	}

	/**
	* Returns the phon number of this e s f partecipant info.
	*
	* @return the phon number of this e s f partecipant info
	*/
	@Override
	public java.lang.String getPhonNumber() {
		return _esfPartecipantInfo.getPhonNumber();
	}

	/**
	* Sets the phon number of this e s f partecipant info.
	*
	* @param phonNumber the phon number of this e s f partecipant info
	*/
	@Override
	public void setPhonNumber(java.lang.String phonNumber) {
		_esfPartecipantInfo.setPhonNumber(phonNumber);
	}

	/**
	* Returns the email of this e s f partecipant info.
	*
	* @return the email of this e s f partecipant info
	*/
	@Override
	public java.lang.String getEmail() {
		return _esfPartecipantInfo.getEmail();
	}

	/**
	* Sets the email of this e s f partecipant info.
	*
	* @param email the email of this e s f partecipant info
	*/
	@Override
	public void setEmail(java.lang.String email) {
		_esfPartecipantInfo.setEmail(email);
	}

	/**
	* Returns the maritial status of this e s f partecipant info.
	*
	* @return the maritial status of this e s f partecipant info
	*/
	@Override
	public java.lang.String getMaritialStatus() {
		return _esfPartecipantInfo.getMaritialStatus();
	}

	/**
	* Sets the maritial status of this e s f partecipant info.
	*
	* @param maritialStatus the maritial status of this e s f partecipant info
	*/
	@Override
	public void setMaritialStatus(java.lang.String maritialStatus) {
		_esfPartecipantInfo.setMaritialStatus(maritialStatus);
	}

	/**
	* Returns the fiscal code of this e s f partecipant info.
	*
	* @return the fiscal code of this e s f partecipant info
	*/
	@Override
	public java.lang.String getFiscalCode() {
		return _esfPartecipantInfo.getFiscalCode();
	}

	/**
	* Sets the fiscal code of this e s f partecipant info.
	*
	* @param fiscalCode the fiscal code of this e s f partecipant info
	*/
	@Override
	public void setFiscalCode(java.lang.String fiscalCode) {
		_esfPartecipantInfo.setFiscalCode(fiscalCode);
	}

	/**
	* Returns the passport of this e s f partecipant info.
	*
	* @return the passport of this e s f partecipant info
	*/
	@Override
	public java.lang.String getPassport() {
		return _esfPartecipantInfo.getPassport();
	}

	/**
	* Sets the passport of this e s f partecipant info.
	*
	* @param passport the passport of this e s f partecipant info
	*/
	@Override
	public void setPassport(java.lang.String passport) {
		_esfPartecipantInfo.setPassport(passport);
	}

	/**
	* Returns the released by of this e s f partecipant info.
	*
	* @return the released by of this e s f partecipant info
	*/
	@Override
	public java.lang.String getReleasedBy() {
		return _esfPartecipantInfo.getReleasedBy();
	}

	/**
	* Sets the released by of this e s f partecipant info.
	*
	* @param releasedBy the released by of this e s f partecipant info
	*/
	@Override
	public void setReleasedBy(java.lang.String releasedBy) {
		_esfPartecipantInfo.setReleasedBy(releasedBy);
	}

	/**
	* Returns the passport release date of this e s f partecipant info.
	*
	* @return the passport release date of this e s f partecipant info
	*/
	@Override
	public java.util.Date getPassportReleaseDate() {
		return _esfPartecipantInfo.getPassportReleaseDate();
	}

	/**
	* Sets the passport release date of this e s f partecipant info.
	*
	* @param passportReleaseDate the passport release date of this e s f partecipant info
	*/
	@Override
	public void setPassportReleaseDate(java.util.Date passportReleaseDate) {
		_esfPartecipantInfo.setPassportReleaseDate(passportReleaseDate);
	}

	/**
	* Returns the passport expiration date of this e s f partecipant info.
	*
	* @return the passport expiration date of this e s f partecipant info
	*/
	@Override
	public java.util.Date getPassportExpirationDate() {
		return _esfPartecipantInfo.getPassportExpirationDate();
	}

	/**
	* Sets the passport expiration date of this e s f partecipant info.
	*
	* @param passportExpirationDate the passport expiration date of this e s f partecipant info
	*/
	@Override
	public void setPassportExpirationDate(java.util.Date passportExpirationDate) {
		_esfPartecipantInfo.setPassportExpirationDate(passportExpirationDate);
	}

	/**
	* Returns the european card number of this e s f partecipant info.
	*
	* @return the european card number of this e s f partecipant info
	*/
	@Override
	public java.lang.String getEuropeanCardNumber() {
		return _esfPartecipantInfo.getEuropeanCardNumber();
	}

	/**
	* Sets the european card number of this e s f partecipant info.
	*
	* @param europeanCardNumber the european card number of this e s f partecipant info
	*/
	@Override
	public void setEuropeanCardNumber(java.lang.String europeanCardNumber) {
		_esfPartecipantInfo.setEuropeanCardNumber(europeanCardNumber);
	}

	/**
	* Returns the european card release date of this e s f partecipant info.
	*
	* @return the european card release date of this e s f partecipant info
	*/
	@Override
	public java.util.Date getEuropeanCardReleaseDate() {
		return _esfPartecipantInfo.getEuropeanCardReleaseDate();
	}

	/**
	* Sets the european card release date of this e s f partecipant info.
	*
	* @param europeanCardReleaseDate the european card release date of this e s f partecipant info
	*/
	@Override
	public void setEuropeanCardReleaseDate(
		java.util.Date europeanCardReleaseDate) {
		_esfPartecipantInfo.setEuropeanCardReleaseDate(europeanCardReleaseDate);
	}

	/**
	* Returns the european card expiration date of this e s f partecipant info.
	*
	* @return the european card expiration date of this e s f partecipant info
	*/
	@Override
	public java.util.Date getEuropeanCardExpirationDate() {
		return _esfPartecipantInfo.getEuropeanCardExpirationDate();
	}

	/**
	* Sets the european card expiration date of this e s f partecipant info.
	*
	* @param europeanCardExpirationDate the european card expiration date of this e s f partecipant info
	*/
	@Override
	public void setEuropeanCardExpirationDate(
		java.util.Date europeanCardExpirationDate) {
		_esfPartecipantInfo.setEuropeanCardExpirationDate(europeanCardExpirationDate);
	}

	/**
	* Returns the gun licence number of this e s f partecipant info.
	*
	* @return the gun licence number of this e s f partecipant info
	*/
	@Override
	public java.lang.String getGunLicenceNumber() {
		return _esfPartecipantInfo.getGunLicenceNumber();
	}

	/**
	* Sets the gun licence number of this e s f partecipant info.
	*
	* @param gunLicenceNumber the gun licence number of this e s f partecipant info
	*/
	@Override
	public void setGunLicenceNumber(java.lang.String gunLicenceNumber) {
		_esfPartecipantInfo.setGunLicenceNumber(gunLicenceNumber);
	}

	/**
	* Returns the gun licence release date of this e s f partecipant info.
	*
	* @return the gun licence release date of this e s f partecipant info
	*/
	@Override
	public java.util.Date getGunLicenceReleaseDate() {
		return _esfPartecipantInfo.getGunLicenceReleaseDate();
	}

	/**
	* Sets the gun licence release date of this e s f partecipant info.
	*
	* @param gunLicenceReleaseDate the gun licence release date of this e s f partecipant info
	*/
	@Override
	public void setGunLicenceReleaseDate(java.util.Date gunLicenceReleaseDate) {
		_esfPartecipantInfo.setGunLicenceReleaseDate(gunLicenceReleaseDate);
	}

	/**
	* Returns the gun licence expiration date of this e s f partecipant info.
	*
	* @return the gun licence expiration date of this e s f partecipant info
	*/
	@Override
	public java.util.Date getGunLicenceExpirationDate() {
		return _esfPartecipantInfo.getGunLicenceExpirationDate();
	}

	/**
	* Sets the gun licence expiration date of this e s f partecipant info.
	*
	* @param gunLicenceExpirationDate the gun licence expiration date of this e s f partecipant info
	*/
	@Override
	public void setGunLicenceExpirationDate(
		java.util.Date gunLicenceExpirationDate) {
		_esfPartecipantInfo.setGunLicenceExpirationDate(gunLicenceExpirationDate);
	}

	/**
	* Returns the first gun type of this e s f partecipant info.
	*
	* @return the first gun type of this e s f partecipant info
	*/
	@Override
	public java.lang.String getFirstGunType() {
		return _esfPartecipantInfo.getFirstGunType();
	}

	/**
	* Sets the first gun type of this e s f partecipant info.
	*
	* @param firstGunType the first gun type of this e s f partecipant info
	*/
	@Override
	public void setFirstGunType(java.lang.String firstGunType) {
		_esfPartecipantInfo.setFirstGunType(firstGunType);
	}

	/**
	* Returns the first gun kind of this e s f partecipant info.
	*
	* @return the first gun kind of this e s f partecipant info
	*/
	@Override
	public java.lang.String getFirstGunKind() {
		return _esfPartecipantInfo.getFirstGunKind();
	}

	/**
	* Sets the first gun kind of this e s f partecipant info.
	*
	* @param firstGunKind the first gun kind of this e s f partecipant info
	*/
	@Override
	public void setFirstGunKind(java.lang.String firstGunKind) {
		_esfPartecipantInfo.setFirstGunKind(firstGunKind);
	}

	/**
	* Returns the first gun caliber of this e s f partecipant info.
	*
	* @return the first gun caliber of this e s f partecipant info
	*/
	@Override
	public double getFirstGunCaliber() {
		return _esfPartecipantInfo.getFirstGunCaliber();
	}

	/**
	* Sets the first gun caliber of this e s f partecipant info.
	*
	* @param firstGunCaliber the first gun caliber of this e s f partecipant info
	*/
	@Override
	public void setFirstGunCaliber(double firstGunCaliber) {
		_esfPartecipantInfo.setFirstGunCaliber(firstGunCaliber);
	}

	/**
	* Returns the first gun code of this e s f partecipant info.
	*
	* @return the first gun code of this e s f partecipant info
	*/
	@Override
	public java.lang.String getFirstGunCode() {
		return _esfPartecipantInfo.getFirstGunCode();
	}

	/**
	* Sets the first gun code of this e s f partecipant info.
	*
	* @param firstGunCode the first gun code of this e s f partecipant info
	*/
	@Override
	public void setFirstGunCode(java.lang.String firstGunCode) {
		_esfPartecipantInfo.setFirstGunCode(firstGunCode);
	}

	/**
	* Returns the first gun extra canes of this e s f partecipant info.
	*
	* @return the first gun extra canes of this e s f partecipant info
	*/
	@Override
	public java.lang.String getFirstGunExtraCanes() {
		return _esfPartecipantInfo.getFirstGunExtraCanes();
	}

	/**
	* Sets the first gun extra canes of this e s f partecipant info.
	*
	* @param firstGunExtraCanes the first gun extra canes of this e s f partecipant info
	*/
	@Override
	public void setFirstGunExtraCanes(java.lang.String firstGunExtraCanes) {
		_esfPartecipantInfo.setFirstGunExtraCanes(firstGunExtraCanes);
	}

	/**
	* Returns the second gun type of this e s f partecipant info.
	*
	* @return the second gun type of this e s f partecipant info
	*/
	@Override
	public java.lang.String getSecondGunType() {
		return _esfPartecipantInfo.getSecondGunType();
	}

	/**
	* Sets the second gun type of this e s f partecipant info.
	*
	* @param secondGunType the second gun type of this e s f partecipant info
	*/
	@Override
	public void setSecondGunType(java.lang.String secondGunType) {
		_esfPartecipantInfo.setSecondGunType(secondGunType);
	}

	/**
	* Returns the second gun kind of this e s f partecipant info.
	*
	* @return the second gun kind of this e s f partecipant info
	*/
	@Override
	public java.lang.String getSecondGunKind() {
		return _esfPartecipantInfo.getSecondGunKind();
	}

	/**
	* Sets the second gun kind of this e s f partecipant info.
	*
	* @param secondGunKind the second gun kind of this e s f partecipant info
	*/
	@Override
	public void setSecondGunKind(java.lang.String secondGunKind) {
		_esfPartecipantInfo.setSecondGunKind(secondGunKind);
	}

	/**
	* Returns the second gun caliber of this e s f partecipant info.
	*
	* @return the second gun caliber of this e s f partecipant info
	*/
	@Override
	public double getSecondGunCaliber() {
		return _esfPartecipantInfo.getSecondGunCaliber();
	}

	/**
	* Sets the second gun caliber of this e s f partecipant info.
	*
	* @param secondGunCaliber the second gun caliber of this e s f partecipant info
	*/
	@Override
	public void setSecondGunCaliber(double secondGunCaliber) {
		_esfPartecipantInfo.setSecondGunCaliber(secondGunCaliber);
	}

	/**
	* Returns the second gun code of this e s f partecipant info.
	*
	* @return the second gun code of this e s f partecipant info
	*/
	@Override
	public java.lang.String getSecondGunCode() {
		return _esfPartecipantInfo.getSecondGunCode();
	}

	/**
	* Sets the second gun code of this e s f partecipant info.
	*
	* @param secondGunCode the second gun code of this e s f partecipant info
	*/
	@Override
	public void setSecondGunCode(java.lang.String secondGunCode) {
		_esfPartecipantInfo.setSecondGunCode(secondGunCode);
	}

	/**
	* Returns the second gun extra canes of this e s f partecipant info.
	*
	* @return the second gun extra canes of this e s f partecipant info
	*/
	@Override
	public java.lang.String getSecondGunExtraCanes() {
		return _esfPartecipantInfo.getSecondGunExtraCanes();
	}

	/**
	* Sets the second gun extra canes of this e s f partecipant info.
	*
	* @param secondGunExtraCanes the second gun extra canes of this e s f partecipant info
	*/
	@Override
	public void setSecondGunExtraCanes(java.lang.String secondGunExtraCanes) {
		_esfPartecipantInfo.setSecondGunExtraCanes(secondGunExtraCanes);
	}

	/**
	* Returns the gun cartridge type of this e s f partecipant info.
	*
	* @return the gun cartridge type of this e s f partecipant info
	*/
	@Override
	public java.lang.String getGunCartridgeType() {
		return _esfPartecipantInfo.getGunCartridgeType();
	}

	/**
	* Sets the gun cartridge type of this e s f partecipant info.
	*
	* @param gunCartridgeType the gun cartridge type of this e s f partecipant info
	*/
	@Override
	public void setGunCartridgeType(java.lang.String gunCartridgeType) {
		_esfPartecipantInfo.setGunCartridgeType(gunCartridgeType);
	}

	/**
	* Returns the gun cartridge kind of this e s f partecipant info.
	*
	* @return the gun cartridge kind of this e s f partecipant info
	*/
	@Override
	public java.lang.String getGunCartridgeKind() {
		return _esfPartecipantInfo.getGunCartridgeKind();
	}

	/**
	* Sets the gun cartridge kind of this e s f partecipant info.
	*
	* @param gunCartridgeKind the gun cartridge kind of this e s f partecipant info
	*/
	@Override
	public void setGunCartridgeKind(java.lang.String gunCartridgeKind) {
		_esfPartecipantInfo.setGunCartridgeKind(gunCartridgeKind);
	}

	/**
	* Returns the cartridge caliber of this e s f partecipant info.
	*
	* @return the cartridge caliber of this e s f partecipant info
	*/
	@Override
	public java.lang.String getCartridgeCaliber() {
		return _esfPartecipantInfo.getCartridgeCaliber();
	}

	/**
	* Sets the cartridge caliber of this e s f partecipant info.
	*
	* @param cartridgeCaliber the cartridge caliber of this e s f partecipant info
	*/
	@Override
	public void setCartridgeCaliber(java.lang.String cartridgeCaliber) {
		_esfPartecipantInfo.setCartridgeCaliber(cartridgeCaliber);
	}

	/**
	* Returns the esf match ID of this e s f partecipant info.
	*
	* @return the esf match ID of this e s f partecipant info
	*/
	@Override
	public long getEsfMatchId() {
		return _esfPartecipantInfo.getEsfMatchId();
	}

	/**
	* Sets the esf match ID of this e s f partecipant info.
	*
	* @param esfMatchId the esf match ID of this e s f partecipant info
	*/
	@Override
	public void setEsfMatchId(long esfMatchId) {
		_esfPartecipantInfo.setEsfMatchId(esfMatchId);
	}

	/**
	* Returns the esf gun type ID one of this e s f partecipant info.
	*
	* @return the esf gun type ID one of this e s f partecipant info
	*/
	@Override
	public long getEsfGunTypeIdOne() {
		return _esfPartecipantInfo.getEsfGunTypeIdOne();
	}

	/**
	* Sets the esf gun type ID one of this e s f partecipant info.
	*
	* @param esfGunTypeIdOne the esf gun type ID one of this e s f partecipant info
	*/
	@Override
	public void setEsfGunTypeIdOne(long esfGunTypeIdOne) {
		_esfPartecipantInfo.setEsfGunTypeIdOne(esfGunTypeIdOne);
	}

	/**
	* Returns the esf gun kind ID one of this e s f partecipant info.
	*
	* @return the esf gun kind ID one of this e s f partecipant info
	*/
	@Override
	public long getEsfGunKindIdOne() {
		return _esfPartecipantInfo.getEsfGunKindIdOne();
	}

	/**
	* Sets the esf gun kind ID one of this e s f partecipant info.
	*
	* @param esfGunKindIdOne the esf gun kind ID one of this e s f partecipant info
	*/
	@Override
	public void setEsfGunKindIdOne(long esfGunKindIdOne) {
		_esfPartecipantInfo.setEsfGunKindIdOne(esfGunKindIdOne);
	}

	/**
	* Returns the esf gun type ID two of this e s f partecipant info.
	*
	* @return the esf gun type ID two of this e s f partecipant info
	*/
	@Override
	public long getEsfGunTypeIdTwo() {
		return _esfPartecipantInfo.getEsfGunTypeIdTwo();
	}

	/**
	* Sets the esf gun type ID two of this e s f partecipant info.
	*
	* @param esfGunTypeIdTwo the esf gun type ID two of this e s f partecipant info
	*/
	@Override
	public void setEsfGunTypeIdTwo(long esfGunTypeIdTwo) {
		_esfPartecipantInfo.setEsfGunTypeIdTwo(esfGunTypeIdTwo);
	}

	/**
	* Returns the esf gun kind ID two of this e s f partecipant info.
	*
	* @return the esf gun kind ID two of this e s f partecipant info
	*/
	@Override
	public long getEsfGunKindIdTwo() {
		return _esfPartecipantInfo.getEsfGunKindIdTwo();
	}

	/**
	* Sets the esf gun kind ID two of this e s f partecipant info.
	*
	* @param esfGunKindIdTwo the esf gun kind ID two of this e s f partecipant info
	*/
	@Override
	public void setEsfGunKindIdTwo(long esfGunKindIdTwo) {
		_esfPartecipantInfo.setEsfGunKindIdTwo(esfGunKindIdTwo);
	}

	@Override
	public boolean isNew() {
		return _esfPartecipantInfo.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_esfPartecipantInfo.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _esfPartecipantInfo.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_esfPartecipantInfo.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _esfPartecipantInfo.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _esfPartecipantInfo.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_esfPartecipantInfo.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _esfPartecipantInfo.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_esfPartecipantInfo.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_esfPartecipantInfo.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_esfPartecipantInfo.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ESFPartecipantInfoWrapper((ESFPartecipantInfo)_esfPartecipantInfo.clone());
	}

	@Override
	public int compareTo(
		it.ethica.esf.model.ESFPartecipantInfo esfPartecipantInfo) {
		return _esfPartecipantInfo.compareTo(esfPartecipantInfo);
	}

	@Override
	public int hashCode() {
		return _esfPartecipantInfo.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.ethica.esf.model.ESFPartecipantInfo> toCacheModel() {
		return _esfPartecipantInfo.toCacheModel();
	}

	@Override
	public it.ethica.esf.model.ESFPartecipantInfo toEscapedModel() {
		return new ESFPartecipantInfoWrapper(_esfPartecipantInfo.toEscapedModel());
	}

	@Override
	public it.ethica.esf.model.ESFPartecipantInfo toUnescapedModel() {
		return new ESFPartecipantInfoWrapper(_esfPartecipantInfo.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _esfPartecipantInfo.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _esfPartecipantInfo.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_esfPartecipantInfo.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFPartecipantInfoWrapper)) {
			return false;
		}

		ESFPartecipantInfoWrapper esfPartecipantInfoWrapper = (ESFPartecipantInfoWrapper)obj;

		if (Validator.equals(_esfPartecipantInfo,
					esfPartecipantInfoWrapper._esfPartecipantInfo)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ESFPartecipantInfo getWrappedESFPartecipantInfo() {
		return _esfPartecipantInfo;
	}

	@Override
	public ESFPartecipantInfo getWrappedModel() {
		return _esfPartecipantInfo;
	}

	@Override
	public void resetOriginalValues() {
		_esfPartecipantInfo.resetOriginalValues();
	}

	private ESFPartecipantInfo _esfPartecipantInfo;
}