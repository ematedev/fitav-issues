/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import it.ethica.esf.service.ClpSerializer;
import it.ethica.esf.service.ESFPartecipantInfoLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ethica
 */
public class ESFPartecipantInfoClp extends BaseModelImpl<ESFPartecipantInfo>
	implements ESFPartecipantInfo {
	public ESFPartecipantInfoClp() {
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
	public long getPrimaryKey() {
		return _esfPartecipantInfoId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEsfPartecipantInfoId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _esfPartecipantInfoId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getEsfPartecipantInfoId() {
		return _esfPartecipantInfoId;
	}

	@Override
	public void setEsfPartecipantInfoId(long esfPartecipantInfoId) {
		_esfPartecipantInfoId = esfPartecipantInfoId;

		if (_esfPartecipantInfoRemoteModel != null) {
			try {
				Class<?> clazz = _esfPartecipantInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfPartecipantInfoId",
						long.class);

				method.invoke(_esfPartecipantInfoRemoteModel,
					esfPartecipantInfoId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_esfPartecipantInfoRemoteModel != null) {
			try {
				Class<?> clazz = _esfPartecipantInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_esfPartecipantInfoRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_esfPartecipantInfoRemoteModel != null) {
			try {
				Class<?> clazz = _esfPartecipantInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_esfPartecipantInfoRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_esfPartecipantInfoRemoteModel != null) {
			try {
				Class<?> clazz = _esfPartecipantInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_esfPartecipantInfoRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public String getUserName() {
		return _userName;
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;

		if (_esfPartecipantInfoRemoteModel != null) {
			try {
				Class<?> clazz = _esfPartecipantInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_esfPartecipantInfoRemoteModel, userName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_esfPartecipantInfoRemoteModel != null) {
			try {
				Class<?> clazz = _esfPartecipantInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_esfPartecipantInfoRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_esfPartecipantInfoRemoteModel != null) {
			try {
				Class<?> clazz = _esfPartecipantInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_esfPartecipantInfoRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getIsPortalUser() {
		return _isPortalUser;
	}

	@Override
	public boolean isIsPortalUser() {
		return _isPortalUser;
	}

	@Override
	public void setIsPortalUser(boolean isPortalUser) {
		_isPortalUser = isPortalUser;

		if (_esfPartecipantInfoRemoteModel != null) {
			try {
				Class<?> clazz = _esfPartecipantInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setIsPortalUser", boolean.class);

				method.invoke(_esfPartecipantInfoRemoteModel, isPortalUser);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEsfUserId() {
		return _esfUserId;
	}

	@Override
	public void setEsfUserId(long esfUserId) {
		_esfUserId = esfUserId;

		if (_esfPartecipantInfoRemoteModel != null) {
			try {
				Class<?> clazz = _esfPartecipantInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfUserId", long.class);

				method.invoke(_esfPartecipantInfoRemoteModel, esfUserId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEsfUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getEsfUserId(), "uuid", _esfUserUuid);
	}

	@Override
	public void setEsfUserUuid(String esfUserUuid) {
		_esfUserUuid = esfUserUuid;
	}

	@Override
	public long getProtocol() {
		return _protocol;
	}

	@Override
	public void setProtocol(long protocol) {
		_protocol = protocol;

		if (_esfPartecipantInfoRemoteModel != null) {
			try {
				Class<?> clazz = _esfPartecipantInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setProtocol", long.class);

				method.invoke(_esfPartecipantInfoRemoteModel, protocol);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFirstName() {
		return _firstName;
	}

	@Override
	public void setFirstName(String firstName) {
		_firstName = firstName;

		if (_esfPartecipantInfoRemoteModel != null) {
			try {
				Class<?> clazz = _esfPartecipantInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setFirstName", String.class);

				method.invoke(_esfPartecipantInfoRemoteModel, firstName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLastName() {
		return _lastName;
	}

	@Override
	public void setLastName(String lastName) {
		_lastName = lastName;

		if (_esfPartecipantInfoRemoteModel != null) {
			try {
				Class<?> clazz = _esfPartecipantInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setLastName", String.class);

				method.invoke(_esfPartecipantInfoRemoteModel, lastName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPlaceOfBirth() {
		return _placeOfBirth;
	}

	@Override
	public void setPlaceOfBirth(String placeOfBirth) {
		_placeOfBirth = placeOfBirth;

		if (_esfPartecipantInfoRemoteModel != null) {
			try {
				Class<?> clazz = _esfPartecipantInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setPlaceOfBirth", String.class);

				method.invoke(_esfPartecipantInfoRemoteModel, placeOfBirth);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getDateOfBirth() {
		return _dateOfBirth;
	}

	@Override
	public void setDateOfBirth(Date dateOfBirth) {
		_dateOfBirth = dateOfBirth;

		if (_esfPartecipantInfoRemoteModel != null) {
			try {
				Class<?> clazz = _esfPartecipantInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setDateOfBirth", Date.class);

				method.invoke(_esfPartecipantInfoRemoteModel, dateOfBirth);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getResidenceCity() {
		return _residenceCity;
	}

	@Override
	public void setResidenceCity(String residenceCity) {
		_residenceCity = residenceCity;

		if (_esfPartecipantInfoRemoteModel != null) {
			try {
				Class<?> clazz = _esfPartecipantInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setResidenceCity", String.class);

				method.invoke(_esfPartecipantInfoRemoteModel, residenceCity);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getProvince() {
		return _province;
	}

	@Override
	public void setProvince(String province) {
		_province = province;

		if (_esfPartecipantInfoRemoteModel != null) {
			try {
				Class<?> clazz = _esfPartecipantInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setProvince", String.class);

				method.invoke(_esfPartecipantInfoRemoteModel, province);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getZip() {
		return _zip;
	}

	@Override
	public void setZip(int zip) {
		_zip = zip;

		if (_esfPartecipantInfoRemoteModel != null) {
			try {
				Class<?> clazz = _esfPartecipantInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setZip", int.class);

				method.invoke(_esfPartecipantInfoRemoteModel, zip);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAddress() {
		return _address;
	}

	@Override
	public void setAddress(String address) {
		_address = address;

		if (_esfPartecipantInfoRemoteModel != null) {
			try {
				Class<?> clazz = _esfPartecipantInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setAddress", String.class);

				method.invoke(_esfPartecipantInfoRemoteModel, address);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPhonNumber() {
		return _phonNumber;
	}

	@Override
	public void setPhonNumber(String phonNumber) {
		_phonNumber = phonNumber;

		if (_esfPartecipantInfoRemoteModel != null) {
			try {
				Class<?> clazz = _esfPartecipantInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setPhonNumber", String.class);

				method.invoke(_esfPartecipantInfoRemoteModel, phonNumber);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEmail() {
		return _email;
	}

	@Override
	public void setEmail(String email) {
		_email = email;

		if (_esfPartecipantInfoRemoteModel != null) {
			try {
				Class<?> clazz = _esfPartecipantInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setEmail", String.class);

				method.invoke(_esfPartecipantInfoRemoteModel, email);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMaritialStatus() {
		return _maritialStatus;
	}

	@Override
	public void setMaritialStatus(String maritialStatus) {
		_maritialStatus = maritialStatus;

		if (_esfPartecipantInfoRemoteModel != null) {
			try {
				Class<?> clazz = _esfPartecipantInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setMaritialStatus",
						String.class);

				method.invoke(_esfPartecipantInfoRemoteModel, maritialStatus);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFiscalCode() {
		return _fiscalCode;
	}

	@Override
	public void setFiscalCode(String fiscalCode) {
		_fiscalCode = fiscalCode;

		if (_esfPartecipantInfoRemoteModel != null) {
			try {
				Class<?> clazz = _esfPartecipantInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setFiscalCode", String.class);

				method.invoke(_esfPartecipantInfoRemoteModel, fiscalCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPassport() {
		return _passport;
	}

	@Override
	public void setPassport(String passport) {
		_passport = passport;

		if (_esfPartecipantInfoRemoteModel != null) {
			try {
				Class<?> clazz = _esfPartecipantInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setPassport", String.class);

				method.invoke(_esfPartecipantInfoRemoteModel, passport);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getReleasedBy() {
		return _releasedBy;
	}

	@Override
	public void setReleasedBy(String releasedBy) {
		_releasedBy = releasedBy;

		if (_esfPartecipantInfoRemoteModel != null) {
			try {
				Class<?> clazz = _esfPartecipantInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setReleasedBy", String.class);

				method.invoke(_esfPartecipantInfoRemoteModel, releasedBy);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getPassportReleaseDate() {
		return _passportReleaseDate;
	}

	@Override
	public void setPassportReleaseDate(Date passportReleaseDate) {
		_passportReleaseDate = passportReleaseDate;

		if (_esfPartecipantInfoRemoteModel != null) {
			try {
				Class<?> clazz = _esfPartecipantInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setPassportReleaseDate",
						Date.class);

				method.invoke(_esfPartecipantInfoRemoteModel,
					passportReleaseDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getPassportExpirationDate() {
		return _passportExpirationDate;
	}

	@Override
	public void setPassportExpirationDate(Date passportExpirationDate) {
		_passportExpirationDate = passportExpirationDate;

		if (_esfPartecipantInfoRemoteModel != null) {
			try {
				Class<?> clazz = _esfPartecipantInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setPassportExpirationDate",
						Date.class);

				method.invoke(_esfPartecipantInfoRemoteModel,
					passportExpirationDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEuropeanCardNumber() {
		return _europeanCardNumber;
	}

	@Override
	public void setEuropeanCardNumber(String europeanCardNumber) {
		_europeanCardNumber = europeanCardNumber;

		if (_esfPartecipantInfoRemoteModel != null) {
			try {
				Class<?> clazz = _esfPartecipantInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setEuropeanCardNumber",
						String.class);

				method.invoke(_esfPartecipantInfoRemoteModel, europeanCardNumber);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getEuropeanCardReleaseDate() {
		return _europeanCardReleaseDate;
	}

	@Override
	public void setEuropeanCardReleaseDate(Date europeanCardReleaseDate) {
		_europeanCardReleaseDate = europeanCardReleaseDate;

		if (_esfPartecipantInfoRemoteModel != null) {
			try {
				Class<?> clazz = _esfPartecipantInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setEuropeanCardReleaseDate",
						Date.class);

				method.invoke(_esfPartecipantInfoRemoteModel,
					europeanCardReleaseDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getEuropeanCardExpirationDate() {
		return _europeanCardExpirationDate;
	}

	@Override
	public void setEuropeanCardExpirationDate(Date europeanCardExpirationDate) {
		_europeanCardExpirationDate = europeanCardExpirationDate;

		if (_esfPartecipantInfoRemoteModel != null) {
			try {
				Class<?> clazz = _esfPartecipantInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setEuropeanCardExpirationDate",
						Date.class);

				method.invoke(_esfPartecipantInfoRemoteModel,
					europeanCardExpirationDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getGunLicenceNumber() {
		return _gunLicenceNumber;
	}

	@Override
	public void setGunLicenceNumber(String gunLicenceNumber) {
		_gunLicenceNumber = gunLicenceNumber;

		if (_esfPartecipantInfoRemoteModel != null) {
			try {
				Class<?> clazz = _esfPartecipantInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setGunLicenceNumber",
						String.class);

				method.invoke(_esfPartecipantInfoRemoteModel, gunLicenceNumber);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getGunLicenceReleaseDate() {
		return _gunLicenceReleaseDate;
	}

	@Override
	public void setGunLicenceReleaseDate(Date gunLicenceReleaseDate) {
		_gunLicenceReleaseDate = gunLicenceReleaseDate;

		if (_esfPartecipantInfoRemoteModel != null) {
			try {
				Class<?> clazz = _esfPartecipantInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setGunLicenceReleaseDate",
						Date.class);

				method.invoke(_esfPartecipantInfoRemoteModel,
					gunLicenceReleaseDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getGunLicenceExpirationDate() {
		return _gunLicenceExpirationDate;
	}

	@Override
	public void setGunLicenceExpirationDate(Date gunLicenceExpirationDate) {
		_gunLicenceExpirationDate = gunLicenceExpirationDate;

		if (_esfPartecipantInfoRemoteModel != null) {
			try {
				Class<?> clazz = _esfPartecipantInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setGunLicenceExpirationDate",
						Date.class);

				method.invoke(_esfPartecipantInfoRemoteModel,
					gunLicenceExpirationDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFirstGunType() {
		return _firstGunType;
	}

	@Override
	public void setFirstGunType(String firstGunType) {
		_firstGunType = firstGunType;

		if (_esfPartecipantInfoRemoteModel != null) {
			try {
				Class<?> clazz = _esfPartecipantInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setFirstGunType", String.class);

				method.invoke(_esfPartecipantInfoRemoteModel, firstGunType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFirstGunKind() {
		return _firstGunKind;
	}

	@Override
	public void setFirstGunKind(String firstGunKind) {
		_firstGunKind = firstGunKind;

		if (_esfPartecipantInfoRemoteModel != null) {
			try {
				Class<?> clazz = _esfPartecipantInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setFirstGunKind", String.class);

				method.invoke(_esfPartecipantInfoRemoteModel, firstGunKind);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getFirstGunCaliber() {
		return _firstGunCaliber;
	}

	@Override
	public void setFirstGunCaliber(double firstGunCaliber) {
		_firstGunCaliber = firstGunCaliber;

		if (_esfPartecipantInfoRemoteModel != null) {
			try {
				Class<?> clazz = _esfPartecipantInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setFirstGunCaliber",
						double.class);

				method.invoke(_esfPartecipantInfoRemoteModel, firstGunCaliber);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFirstGunCode() {
		return _firstGunCode;
	}

	@Override
	public void setFirstGunCode(String firstGunCode) {
		_firstGunCode = firstGunCode;

		if (_esfPartecipantInfoRemoteModel != null) {
			try {
				Class<?> clazz = _esfPartecipantInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setFirstGunCode", String.class);

				method.invoke(_esfPartecipantInfoRemoteModel, firstGunCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFirstGunExtraCanes() {
		return _firstGunExtraCanes;
	}

	@Override
	public void setFirstGunExtraCanes(String firstGunExtraCanes) {
		_firstGunExtraCanes = firstGunExtraCanes;

		if (_esfPartecipantInfoRemoteModel != null) {
			try {
				Class<?> clazz = _esfPartecipantInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setFirstGunExtraCanes",
						String.class);

				method.invoke(_esfPartecipantInfoRemoteModel, firstGunExtraCanes);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSecondGunType() {
		return _secondGunType;
	}

	@Override
	public void setSecondGunType(String secondGunType) {
		_secondGunType = secondGunType;

		if (_esfPartecipantInfoRemoteModel != null) {
			try {
				Class<?> clazz = _esfPartecipantInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setSecondGunType", String.class);

				method.invoke(_esfPartecipantInfoRemoteModel, secondGunType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSecondGunKind() {
		return _secondGunKind;
	}

	@Override
	public void setSecondGunKind(String secondGunKind) {
		_secondGunKind = secondGunKind;

		if (_esfPartecipantInfoRemoteModel != null) {
			try {
				Class<?> clazz = _esfPartecipantInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setSecondGunKind", String.class);

				method.invoke(_esfPartecipantInfoRemoteModel, secondGunKind);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getSecondGunCaliber() {
		return _secondGunCaliber;
	}

	@Override
	public void setSecondGunCaliber(double secondGunCaliber) {
		_secondGunCaliber = secondGunCaliber;

		if (_esfPartecipantInfoRemoteModel != null) {
			try {
				Class<?> clazz = _esfPartecipantInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setSecondGunCaliber",
						double.class);

				method.invoke(_esfPartecipantInfoRemoteModel, secondGunCaliber);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSecondGunCode() {
		return _secondGunCode;
	}

	@Override
	public void setSecondGunCode(String secondGunCode) {
		_secondGunCode = secondGunCode;

		if (_esfPartecipantInfoRemoteModel != null) {
			try {
				Class<?> clazz = _esfPartecipantInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setSecondGunCode", String.class);

				method.invoke(_esfPartecipantInfoRemoteModel, secondGunCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSecondGunExtraCanes() {
		return _secondGunExtraCanes;
	}

	@Override
	public void setSecondGunExtraCanes(String secondGunExtraCanes) {
		_secondGunExtraCanes = secondGunExtraCanes;

		if (_esfPartecipantInfoRemoteModel != null) {
			try {
				Class<?> clazz = _esfPartecipantInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setSecondGunExtraCanes",
						String.class);

				method.invoke(_esfPartecipantInfoRemoteModel,
					secondGunExtraCanes);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getGunCartridgeType() {
		return _gunCartridgeType;
	}

	@Override
	public void setGunCartridgeType(String gunCartridgeType) {
		_gunCartridgeType = gunCartridgeType;

		if (_esfPartecipantInfoRemoteModel != null) {
			try {
				Class<?> clazz = _esfPartecipantInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setGunCartridgeType",
						String.class);

				method.invoke(_esfPartecipantInfoRemoteModel, gunCartridgeType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getGunCartridgeKind() {
		return _gunCartridgeKind;
	}

	@Override
	public void setGunCartridgeKind(String gunCartridgeKind) {
		_gunCartridgeKind = gunCartridgeKind;

		if (_esfPartecipantInfoRemoteModel != null) {
			try {
				Class<?> clazz = _esfPartecipantInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setGunCartridgeKind",
						String.class);

				method.invoke(_esfPartecipantInfoRemoteModel, gunCartridgeKind);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCartridgeCaliber() {
		return _cartridgeCaliber;
	}

	@Override
	public void setCartridgeCaliber(String cartridgeCaliber) {
		_cartridgeCaliber = cartridgeCaliber;

		if (_esfPartecipantInfoRemoteModel != null) {
			try {
				Class<?> clazz = _esfPartecipantInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setCartridgeCaliber",
						String.class);

				method.invoke(_esfPartecipantInfoRemoteModel, cartridgeCaliber);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEsfMatchId() {
		return _esfMatchId;
	}

	@Override
	public void setEsfMatchId(long esfMatchId) {
		_esfMatchId = esfMatchId;

		if (_esfPartecipantInfoRemoteModel != null) {
			try {
				Class<?> clazz = _esfPartecipantInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfMatchId", long.class);

				method.invoke(_esfPartecipantInfoRemoteModel, esfMatchId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEsfGunTypeIdOne() {
		return _esfGunTypeIdOne;
	}

	@Override
	public void setEsfGunTypeIdOne(long esfGunTypeIdOne) {
		_esfGunTypeIdOne = esfGunTypeIdOne;

		if (_esfPartecipantInfoRemoteModel != null) {
			try {
				Class<?> clazz = _esfPartecipantInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfGunTypeIdOne", long.class);

				method.invoke(_esfPartecipantInfoRemoteModel, esfGunTypeIdOne);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEsfGunKindIdOne() {
		return _esfGunKindIdOne;
	}

	@Override
	public void setEsfGunKindIdOne(long esfGunKindIdOne) {
		_esfGunKindIdOne = esfGunKindIdOne;

		if (_esfPartecipantInfoRemoteModel != null) {
			try {
				Class<?> clazz = _esfPartecipantInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfGunKindIdOne", long.class);

				method.invoke(_esfPartecipantInfoRemoteModel, esfGunKindIdOne);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEsfGunTypeIdTwo() {
		return _esfGunTypeIdTwo;
	}

	@Override
	public void setEsfGunTypeIdTwo(long esfGunTypeIdTwo) {
		_esfGunTypeIdTwo = esfGunTypeIdTwo;

		if (_esfPartecipantInfoRemoteModel != null) {
			try {
				Class<?> clazz = _esfPartecipantInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfGunTypeIdTwo", long.class);

				method.invoke(_esfPartecipantInfoRemoteModel, esfGunTypeIdTwo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEsfGunKindIdTwo() {
		return _esfGunKindIdTwo;
	}

	@Override
	public void setEsfGunKindIdTwo(long esfGunKindIdTwo) {
		_esfGunKindIdTwo = esfGunKindIdTwo;

		if (_esfPartecipantInfoRemoteModel != null) {
			try {
				Class<?> clazz = _esfPartecipantInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfGunKindIdTwo", long.class);

				method.invoke(_esfPartecipantInfoRemoteModel, esfGunKindIdTwo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getESFPartecipantInfoRemoteModel() {
		return _esfPartecipantInfoRemoteModel;
	}

	public void setESFPartecipantInfoRemoteModel(
		BaseModel<?> esfPartecipantInfoRemoteModel) {
		_esfPartecipantInfoRemoteModel = esfPartecipantInfoRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _esfPartecipantInfoRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_esfPartecipantInfoRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ESFPartecipantInfoLocalServiceUtil.addESFPartecipantInfo(this);
		}
		else {
			ESFPartecipantInfoLocalServiceUtil.updateESFPartecipantInfo(this);
		}
	}

	@Override
	public ESFPartecipantInfo toEscapedModel() {
		return (ESFPartecipantInfo)ProxyUtil.newProxyInstance(ESFPartecipantInfo.class.getClassLoader(),
			new Class[] { ESFPartecipantInfo.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ESFPartecipantInfoClp clone = new ESFPartecipantInfoClp();

		clone.setEsfPartecipantInfoId(getEsfPartecipantInfoId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setIsPortalUser(getIsPortalUser());
		clone.setEsfUserId(getEsfUserId());
		clone.setProtocol(getProtocol());
		clone.setFirstName(getFirstName());
		clone.setLastName(getLastName());
		clone.setPlaceOfBirth(getPlaceOfBirth());
		clone.setDateOfBirth(getDateOfBirth());
		clone.setResidenceCity(getResidenceCity());
		clone.setProvince(getProvince());
		clone.setZip(getZip());
		clone.setAddress(getAddress());
		clone.setPhonNumber(getPhonNumber());
		clone.setEmail(getEmail());
		clone.setMaritialStatus(getMaritialStatus());
		clone.setFiscalCode(getFiscalCode());
		clone.setPassport(getPassport());
		clone.setReleasedBy(getReleasedBy());
		clone.setPassportReleaseDate(getPassportReleaseDate());
		clone.setPassportExpirationDate(getPassportExpirationDate());
		clone.setEuropeanCardNumber(getEuropeanCardNumber());
		clone.setEuropeanCardReleaseDate(getEuropeanCardReleaseDate());
		clone.setEuropeanCardExpirationDate(getEuropeanCardExpirationDate());
		clone.setGunLicenceNumber(getGunLicenceNumber());
		clone.setGunLicenceReleaseDate(getGunLicenceReleaseDate());
		clone.setGunLicenceExpirationDate(getGunLicenceExpirationDate());
		clone.setFirstGunType(getFirstGunType());
		clone.setFirstGunKind(getFirstGunKind());
		clone.setFirstGunCaliber(getFirstGunCaliber());
		clone.setFirstGunCode(getFirstGunCode());
		clone.setFirstGunExtraCanes(getFirstGunExtraCanes());
		clone.setSecondGunType(getSecondGunType());
		clone.setSecondGunKind(getSecondGunKind());
		clone.setSecondGunCaliber(getSecondGunCaliber());
		clone.setSecondGunCode(getSecondGunCode());
		clone.setSecondGunExtraCanes(getSecondGunExtraCanes());
		clone.setGunCartridgeType(getGunCartridgeType());
		clone.setGunCartridgeKind(getGunCartridgeKind());
		clone.setCartridgeCaliber(getCartridgeCaliber());
		clone.setEsfMatchId(getEsfMatchId());
		clone.setEsfGunTypeIdOne(getEsfGunTypeIdOne());
		clone.setEsfGunKindIdOne(getEsfGunKindIdOne());
		clone.setEsfGunTypeIdTwo(getEsfGunTypeIdTwo());
		clone.setEsfGunKindIdTwo(getEsfGunKindIdTwo());

		return clone;
	}

	@Override
	public int compareTo(ESFPartecipantInfo esfPartecipantInfo) {
		long primaryKey = esfPartecipantInfo.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFPartecipantInfoClp)) {
			return false;
		}

		ESFPartecipantInfoClp esfPartecipantInfo = (ESFPartecipantInfoClp)obj;

		long primaryKey = esfPartecipantInfo.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(101);

		sb.append("{esfPartecipantInfoId=");
		sb.append(getEsfPartecipantInfoId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", isPortalUser=");
		sb.append(getIsPortalUser());
		sb.append(", esfUserId=");
		sb.append(getEsfUserId());
		sb.append(", protocol=");
		sb.append(getProtocol());
		sb.append(", firstName=");
		sb.append(getFirstName());
		sb.append(", lastName=");
		sb.append(getLastName());
		sb.append(", placeOfBirth=");
		sb.append(getPlaceOfBirth());
		sb.append(", dateOfBirth=");
		sb.append(getDateOfBirth());
		sb.append(", residenceCity=");
		sb.append(getResidenceCity());
		sb.append(", province=");
		sb.append(getProvince());
		sb.append(", zip=");
		sb.append(getZip());
		sb.append(", address=");
		sb.append(getAddress());
		sb.append(", phonNumber=");
		sb.append(getPhonNumber());
		sb.append(", email=");
		sb.append(getEmail());
		sb.append(", maritialStatus=");
		sb.append(getMaritialStatus());
		sb.append(", fiscalCode=");
		sb.append(getFiscalCode());
		sb.append(", passport=");
		sb.append(getPassport());
		sb.append(", releasedBy=");
		sb.append(getReleasedBy());
		sb.append(", passportReleaseDate=");
		sb.append(getPassportReleaseDate());
		sb.append(", passportExpirationDate=");
		sb.append(getPassportExpirationDate());
		sb.append(", europeanCardNumber=");
		sb.append(getEuropeanCardNumber());
		sb.append(", europeanCardReleaseDate=");
		sb.append(getEuropeanCardReleaseDate());
		sb.append(", europeanCardExpirationDate=");
		sb.append(getEuropeanCardExpirationDate());
		sb.append(", gunLicenceNumber=");
		sb.append(getGunLicenceNumber());
		sb.append(", gunLicenceReleaseDate=");
		sb.append(getGunLicenceReleaseDate());
		sb.append(", gunLicenceExpirationDate=");
		sb.append(getGunLicenceExpirationDate());
		sb.append(", firstGunType=");
		sb.append(getFirstGunType());
		sb.append(", firstGunKind=");
		sb.append(getFirstGunKind());
		sb.append(", firstGunCaliber=");
		sb.append(getFirstGunCaliber());
		sb.append(", firstGunCode=");
		sb.append(getFirstGunCode());
		sb.append(", firstGunExtraCanes=");
		sb.append(getFirstGunExtraCanes());
		sb.append(", secondGunType=");
		sb.append(getSecondGunType());
		sb.append(", secondGunKind=");
		sb.append(getSecondGunKind());
		sb.append(", secondGunCaliber=");
		sb.append(getSecondGunCaliber());
		sb.append(", secondGunCode=");
		sb.append(getSecondGunCode());
		sb.append(", secondGunExtraCanes=");
		sb.append(getSecondGunExtraCanes());
		sb.append(", gunCartridgeType=");
		sb.append(getGunCartridgeType());
		sb.append(", gunCartridgeKind=");
		sb.append(getGunCartridgeKind());
		sb.append(", cartridgeCaliber=");
		sb.append(getCartridgeCaliber());
		sb.append(", esfMatchId=");
		sb.append(getEsfMatchId());
		sb.append(", esfGunTypeIdOne=");
		sb.append(getEsfGunTypeIdOne());
		sb.append(", esfGunKindIdOne=");
		sb.append(getEsfGunKindIdOne());
		sb.append(", esfGunTypeIdTwo=");
		sb.append(getEsfGunTypeIdTwo());
		sb.append(", esfGunKindIdTwo=");
		sb.append(getEsfGunKindIdTwo());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(154);

		sb.append("<model><model-name>");
		sb.append("it.ethica.esf.model.ESFPartecipantInfo");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>esfPartecipantInfoId</column-name><column-value><![CDATA[");
		sb.append(getEsfPartecipantInfoId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isPortalUser</column-name><column-value><![CDATA[");
		sb.append(getIsPortalUser());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfUserId</column-name><column-value><![CDATA[");
		sb.append(getEsfUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>protocol</column-name><column-value><![CDATA[");
		sb.append(getProtocol());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>firstName</column-name><column-value><![CDATA[");
		sb.append(getFirstName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastName</column-name><column-value><![CDATA[");
		sb.append(getLastName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>placeOfBirth</column-name><column-value><![CDATA[");
		sb.append(getPlaceOfBirth());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dateOfBirth</column-name><column-value><![CDATA[");
		sb.append(getDateOfBirth());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>residenceCity</column-name><column-value><![CDATA[");
		sb.append(getResidenceCity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>province</column-name><column-value><![CDATA[");
		sb.append(getProvince());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>zip</column-name><column-value><![CDATA[");
		sb.append(getZip());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>address</column-name><column-value><![CDATA[");
		sb.append(getAddress());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>phonNumber</column-name><column-value><![CDATA[");
		sb.append(getPhonNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>email</column-name><column-value><![CDATA[");
		sb.append(getEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>maritialStatus</column-name><column-value><![CDATA[");
		sb.append(getMaritialStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fiscalCode</column-name><column-value><![CDATA[");
		sb.append(getFiscalCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>passport</column-name><column-value><![CDATA[");
		sb.append(getPassport());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>releasedBy</column-name><column-value><![CDATA[");
		sb.append(getReleasedBy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>passportReleaseDate</column-name><column-value><![CDATA[");
		sb.append(getPassportReleaseDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>passportExpirationDate</column-name><column-value><![CDATA[");
		sb.append(getPassportExpirationDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>europeanCardNumber</column-name><column-value><![CDATA[");
		sb.append(getEuropeanCardNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>europeanCardReleaseDate</column-name><column-value><![CDATA[");
		sb.append(getEuropeanCardReleaseDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>europeanCardExpirationDate</column-name><column-value><![CDATA[");
		sb.append(getEuropeanCardExpirationDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>gunLicenceNumber</column-name><column-value><![CDATA[");
		sb.append(getGunLicenceNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>gunLicenceReleaseDate</column-name><column-value><![CDATA[");
		sb.append(getGunLicenceReleaseDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>gunLicenceExpirationDate</column-name><column-value><![CDATA[");
		sb.append(getGunLicenceExpirationDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>firstGunType</column-name><column-value><![CDATA[");
		sb.append(getFirstGunType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>firstGunKind</column-name><column-value><![CDATA[");
		sb.append(getFirstGunKind());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>firstGunCaliber</column-name><column-value><![CDATA[");
		sb.append(getFirstGunCaliber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>firstGunCode</column-name><column-value><![CDATA[");
		sb.append(getFirstGunCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>firstGunExtraCanes</column-name><column-value><![CDATA[");
		sb.append(getFirstGunExtraCanes());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>secondGunType</column-name><column-value><![CDATA[");
		sb.append(getSecondGunType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>secondGunKind</column-name><column-value><![CDATA[");
		sb.append(getSecondGunKind());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>secondGunCaliber</column-name><column-value><![CDATA[");
		sb.append(getSecondGunCaliber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>secondGunCode</column-name><column-value><![CDATA[");
		sb.append(getSecondGunCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>secondGunExtraCanes</column-name><column-value><![CDATA[");
		sb.append(getSecondGunExtraCanes());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>gunCartridgeType</column-name><column-value><![CDATA[");
		sb.append(getGunCartridgeType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>gunCartridgeKind</column-name><column-value><![CDATA[");
		sb.append(getGunCartridgeKind());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cartridgeCaliber</column-name><column-value><![CDATA[");
		sb.append(getCartridgeCaliber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfMatchId</column-name><column-value><![CDATA[");
		sb.append(getEsfMatchId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfGunTypeIdOne</column-name><column-value><![CDATA[");
		sb.append(getEsfGunTypeIdOne());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfGunKindIdOne</column-name><column-value><![CDATA[");
		sb.append(getEsfGunKindIdOne());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfGunTypeIdTwo</column-name><column-value><![CDATA[");
		sb.append(getEsfGunTypeIdTwo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfGunKindIdTwo</column-name><column-value><![CDATA[");
		sb.append(getEsfGunKindIdTwo());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _esfPartecipantInfoId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _isPortalUser;
	private long _esfUserId;
	private String _esfUserUuid;
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
	private BaseModel<?> _esfPartecipantInfoRemoteModel;
}