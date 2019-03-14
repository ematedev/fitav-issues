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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Ethica
 * @generated
 */
public class ESFPartecipantInfoSoap implements Serializable {
	public static ESFPartecipantInfoSoap toSoapModel(ESFPartecipantInfo model) {
		ESFPartecipantInfoSoap soapModel = new ESFPartecipantInfoSoap();

		soapModel.setEsfPartecipantInfoId(model.getEsfPartecipantInfoId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setIsPortalUser(model.getIsPortalUser());
		soapModel.setEsfUserId(model.getEsfUserId());
		soapModel.setProtocol(model.getProtocol());
		soapModel.setFirstName(model.getFirstName());
		soapModel.setLastName(model.getLastName());
		soapModel.setPlaceOfBirth(model.getPlaceOfBirth());
		soapModel.setDateOfBirth(model.getDateOfBirth());
		soapModel.setResidenceCity(model.getResidenceCity());
		soapModel.setProvince(model.getProvince());
		soapModel.setZip(model.getZip());
		soapModel.setAddress(model.getAddress());
		soapModel.setPhonNumber(model.getPhonNumber());
		soapModel.setEmail(model.getEmail());
		soapModel.setMaritialStatus(model.getMaritialStatus());
		soapModel.setFiscalCode(model.getFiscalCode());
		soapModel.setPassport(model.getPassport());
		soapModel.setReleasedBy(model.getReleasedBy());
		soapModel.setPassportReleaseDate(model.getPassportReleaseDate());
		soapModel.setPassportExpirationDate(model.getPassportExpirationDate());
		soapModel.setEuropeanCardNumber(model.getEuropeanCardNumber());
		soapModel.setEuropeanCardReleaseDate(model.getEuropeanCardReleaseDate());
		soapModel.setEuropeanCardExpirationDate(model.getEuropeanCardExpirationDate());
		soapModel.setGunLicenceNumber(model.getGunLicenceNumber());
		soapModel.setGunLicenceReleaseDate(model.getGunLicenceReleaseDate());
		soapModel.setGunLicenceExpirationDate(model.getGunLicenceExpirationDate());
		soapModel.setFirstGunType(model.getFirstGunType());
		soapModel.setFirstGunKind(model.getFirstGunKind());
		soapModel.setFirstGunCaliber(model.getFirstGunCaliber());
		soapModel.setFirstGunCode(model.getFirstGunCode());
		soapModel.setFirstGunExtraCanes(model.getFirstGunExtraCanes());
		soapModel.setSecondGunType(model.getSecondGunType());
		soapModel.setSecondGunKind(model.getSecondGunKind());
		soapModel.setSecondGunCaliber(model.getSecondGunCaliber());
		soapModel.setSecondGunCode(model.getSecondGunCode());
		soapModel.setSecondGunExtraCanes(model.getSecondGunExtraCanes());
		soapModel.setGunCartridgeType(model.getGunCartridgeType());
		soapModel.setGunCartridgeKind(model.getGunCartridgeKind());
		soapModel.setCartridgeCaliber(model.getCartridgeCaliber());
		soapModel.setEsfMatchId(model.getEsfMatchId());
		soapModel.setEsfGunTypeIdOne(model.getEsfGunTypeIdOne());
		soapModel.setEsfGunKindIdOne(model.getEsfGunKindIdOne());
		soapModel.setEsfGunTypeIdTwo(model.getEsfGunTypeIdTwo());
		soapModel.setEsfGunKindIdTwo(model.getEsfGunKindIdTwo());

		return soapModel;
	}

	public static ESFPartecipantInfoSoap[] toSoapModels(
		ESFPartecipantInfo[] models) {
		ESFPartecipantInfoSoap[] soapModels = new ESFPartecipantInfoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ESFPartecipantInfoSoap[][] toSoapModels(
		ESFPartecipantInfo[][] models) {
		ESFPartecipantInfoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ESFPartecipantInfoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ESFPartecipantInfoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ESFPartecipantInfoSoap[] toSoapModels(
		List<ESFPartecipantInfo> models) {
		List<ESFPartecipantInfoSoap> soapModels = new ArrayList<ESFPartecipantInfoSoap>(models.size());

		for (ESFPartecipantInfo model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ESFPartecipantInfoSoap[soapModels.size()]);
	}

	public ESFPartecipantInfoSoap() {
	}

	public long getPrimaryKey() {
		return _esfPartecipantInfoId;
	}

	public void setPrimaryKey(long pk) {
		setEsfPartecipantInfoId(pk);
	}

	public long getEsfPartecipantInfoId() {
		return _esfPartecipantInfoId;
	}

	public void setEsfPartecipantInfoId(long esfPartecipantInfoId) {
		_esfPartecipantInfoId = esfPartecipantInfoId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public boolean getIsPortalUser() {
		return _isPortalUser;
	}

	public boolean isIsPortalUser() {
		return _isPortalUser;
	}

	public void setIsPortalUser(boolean isPortalUser) {
		_isPortalUser = isPortalUser;
	}

	public long getEsfUserId() {
		return _esfUserId;
	}

	public void setEsfUserId(long esfUserId) {
		_esfUserId = esfUserId;
	}

	public long getProtocol() {
		return _protocol;
	}

	public void setProtocol(long protocol) {
		_protocol = protocol;
	}

	public String getFirstName() {
		return _firstName;
	}

	public void setFirstName(String firstName) {
		_firstName = firstName;
	}

	public String getLastName() {
		return _lastName;
	}

	public void setLastName(String lastName) {
		_lastName = lastName;
	}

	public String getPlaceOfBirth() {
		return _placeOfBirth;
	}

	public void setPlaceOfBirth(String placeOfBirth) {
		_placeOfBirth = placeOfBirth;
	}

	public Date getDateOfBirth() {
		return _dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		_dateOfBirth = dateOfBirth;
	}

	public String getResidenceCity() {
		return _residenceCity;
	}

	public void setResidenceCity(String residenceCity) {
		_residenceCity = residenceCity;
	}

	public String getProvince() {
		return _province;
	}

	public void setProvince(String province) {
		_province = province;
	}

	public int getZip() {
		return _zip;
	}

	public void setZip(int zip) {
		_zip = zip;
	}

	public String getAddress() {
		return _address;
	}

	public void setAddress(String address) {
		_address = address;
	}

	public String getPhonNumber() {
		return _phonNumber;
	}

	public void setPhonNumber(String phonNumber) {
		_phonNumber = phonNumber;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public String getMaritialStatus() {
		return _maritialStatus;
	}

	public void setMaritialStatus(String maritialStatus) {
		_maritialStatus = maritialStatus;
	}

	public String getFiscalCode() {
		return _fiscalCode;
	}

	public void setFiscalCode(String fiscalCode) {
		_fiscalCode = fiscalCode;
	}

	public String getPassport() {
		return _passport;
	}

	public void setPassport(String passport) {
		_passport = passport;
	}

	public String getReleasedBy() {
		return _releasedBy;
	}

	public void setReleasedBy(String releasedBy) {
		_releasedBy = releasedBy;
	}

	public Date getPassportReleaseDate() {
		return _passportReleaseDate;
	}

	public void setPassportReleaseDate(Date passportReleaseDate) {
		_passportReleaseDate = passportReleaseDate;
	}

	public Date getPassportExpirationDate() {
		return _passportExpirationDate;
	}

	public void setPassportExpirationDate(Date passportExpirationDate) {
		_passportExpirationDate = passportExpirationDate;
	}

	public String getEuropeanCardNumber() {
		return _europeanCardNumber;
	}

	public void setEuropeanCardNumber(String europeanCardNumber) {
		_europeanCardNumber = europeanCardNumber;
	}

	public Date getEuropeanCardReleaseDate() {
		return _europeanCardReleaseDate;
	}

	public void setEuropeanCardReleaseDate(Date europeanCardReleaseDate) {
		_europeanCardReleaseDate = europeanCardReleaseDate;
	}

	public Date getEuropeanCardExpirationDate() {
		return _europeanCardExpirationDate;
	}

	public void setEuropeanCardExpirationDate(Date europeanCardExpirationDate) {
		_europeanCardExpirationDate = europeanCardExpirationDate;
	}

	public String getGunLicenceNumber() {
		return _gunLicenceNumber;
	}

	public void setGunLicenceNumber(String gunLicenceNumber) {
		_gunLicenceNumber = gunLicenceNumber;
	}

	public Date getGunLicenceReleaseDate() {
		return _gunLicenceReleaseDate;
	}

	public void setGunLicenceReleaseDate(Date gunLicenceReleaseDate) {
		_gunLicenceReleaseDate = gunLicenceReleaseDate;
	}

	public Date getGunLicenceExpirationDate() {
		return _gunLicenceExpirationDate;
	}

	public void setGunLicenceExpirationDate(Date gunLicenceExpirationDate) {
		_gunLicenceExpirationDate = gunLicenceExpirationDate;
	}

	public String getFirstGunType() {
		return _firstGunType;
	}

	public void setFirstGunType(String firstGunType) {
		_firstGunType = firstGunType;
	}

	public String getFirstGunKind() {
		return _firstGunKind;
	}

	public void setFirstGunKind(String firstGunKind) {
		_firstGunKind = firstGunKind;
	}

	public double getFirstGunCaliber() {
		return _firstGunCaliber;
	}

	public void setFirstGunCaliber(double firstGunCaliber) {
		_firstGunCaliber = firstGunCaliber;
	}

	public String getFirstGunCode() {
		return _firstGunCode;
	}

	public void setFirstGunCode(String firstGunCode) {
		_firstGunCode = firstGunCode;
	}

	public String getFirstGunExtraCanes() {
		return _firstGunExtraCanes;
	}

	public void setFirstGunExtraCanes(String firstGunExtraCanes) {
		_firstGunExtraCanes = firstGunExtraCanes;
	}

	public String getSecondGunType() {
		return _secondGunType;
	}

	public void setSecondGunType(String secondGunType) {
		_secondGunType = secondGunType;
	}

	public String getSecondGunKind() {
		return _secondGunKind;
	}

	public void setSecondGunKind(String secondGunKind) {
		_secondGunKind = secondGunKind;
	}

	public double getSecondGunCaliber() {
		return _secondGunCaliber;
	}

	public void setSecondGunCaliber(double secondGunCaliber) {
		_secondGunCaliber = secondGunCaliber;
	}

	public String getSecondGunCode() {
		return _secondGunCode;
	}

	public void setSecondGunCode(String secondGunCode) {
		_secondGunCode = secondGunCode;
	}

	public String getSecondGunExtraCanes() {
		return _secondGunExtraCanes;
	}

	public void setSecondGunExtraCanes(String secondGunExtraCanes) {
		_secondGunExtraCanes = secondGunExtraCanes;
	}

	public String getGunCartridgeType() {
		return _gunCartridgeType;
	}

	public void setGunCartridgeType(String gunCartridgeType) {
		_gunCartridgeType = gunCartridgeType;
	}

	public String getGunCartridgeKind() {
		return _gunCartridgeKind;
	}

	public void setGunCartridgeKind(String gunCartridgeKind) {
		_gunCartridgeKind = gunCartridgeKind;
	}

	public String getCartridgeCaliber() {
		return _cartridgeCaliber;
	}

	public void setCartridgeCaliber(String cartridgeCaliber) {
		_cartridgeCaliber = cartridgeCaliber;
	}

	public long getEsfMatchId() {
		return _esfMatchId;
	}

	public void setEsfMatchId(long esfMatchId) {
		_esfMatchId = esfMatchId;
	}

	public long getEsfGunTypeIdOne() {
		return _esfGunTypeIdOne;
	}

	public void setEsfGunTypeIdOne(long esfGunTypeIdOne) {
		_esfGunTypeIdOne = esfGunTypeIdOne;
	}

	public long getEsfGunKindIdOne() {
		return _esfGunKindIdOne;
	}

	public void setEsfGunKindIdOne(long esfGunKindIdOne) {
		_esfGunKindIdOne = esfGunKindIdOne;
	}

	public long getEsfGunTypeIdTwo() {
		return _esfGunTypeIdTwo;
	}

	public void setEsfGunTypeIdTwo(long esfGunTypeIdTwo) {
		_esfGunTypeIdTwo = esfGunTypeIdTwo;
	}

	public long getEsfGunKindIdTwo() {
		return _esfGunKindIdTwo;
	}

	public void setEsfGunKindIdTwo(long esfGunKindIdTwo) {
		_esfGunKindIdTwo = esfGunKindIdTwo;
	}

	private long _esfPartecipantInfoId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _isPortalUser;
	private long _esfUserId;
	private long _protocol;
	private String _firstName;
	private String _lastName;
	private String _placeOfBirth;
	private Date _dateOfBirth;
	private String _residenceCity;
	private String _province;
	private int _zip;
	private String _address;
	private String _phonNumber;
	private String _email;
	private String _maritialStatus;
	private String _fiscalCode;
	private String _passport;
	private String _releasedBy;
	private Date _passportReleaseDate;
	private Date _passportExpirationDate;
	private String _europeanCardNumber;
	private Date _europeanCardReleaseDate;
	private Date _europeanCardExpirationDate;
	private String _gunLicenceNumber;
	private Date _gunLicenceReleaseDate;
	private Date _gunLicenceExpirationDate;
	private String _firstGunType;
	private String _firstGunKind;
	private double _firstGunCaliber;
	private String _firstGunCode;
	private String _firstGunExtraCanes;
	private String _secondGunType;
	private String _secondGunKind;
	private double _secondGunCaliber;
	private String _secondGunCode;
	private String _secondGunExtraCanes;
	private String _gunCartridgeType;
	private String _gunCartridgeKind;
	private String _cartridgeCaliber;
	private long _esfMatchId;
	private long _esfGunTypeIdOne;
	private long _esfGunKindIdOne;
	private long _esfGunTypeIdTwo;
	private long _esfGunKindIdTwo;
}