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

package it.ethica.esf.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import it.ethica.esf.model.ESFPartecipantInfo;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ESFPartecipantInfo in entity cache.
 *
 * @author Ethica
 * @see ESFPartecipantInfo
 * @generated
 */
public class ESFPartecipantInfoCacheModel implements CacheModel<ESFPartecipantInfo>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(101);

		sb.append("{esfPartecipantInfoId=");
		sb.append(esfPartecipantInfoId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", isPortalUser=");
		sb.append(isPortalUser);
		sb.append(", esfUserId=");
		sb.append(esfUserId);
		sb.append(", protocol=");
		sb.append(protocol);
		sb.append(", firstName=");
		sb.append(firstName);
		sb.append(", lastName=");
		sb.append(lastName);
		sb.append(", placeOfBirth=");
		sb.append(placeOfBirth);
		sb.append(", dateOfBirth=");
		sb.append(dateOfBirth);
		sb.append(", residenceCity=");
		sb.append(residenceCity);
		sb.append(", province=");
		sb.append(province);
		sb.append(", zip=");
		sb.append(zip);
		sb.append(", address=");
		sb.append(address);
		sb.append(", phonNumber=");
		sb.append(phonNumber);
		sb.append(", email=");
		sb.append(email);
		sb.append(", maritialStatus=");
		sb.append(maritialStatus);
		sb.append(", fiscalCode=");
		sb.append(fiscalCode);
		sb.append(", passport=");
		sb.append(passport);
		sb.append(", releasedBy=");
		sb.append(releasedBy);
		sb.append(", passportReleaseDate=");
		sb.append(passportReleaseDate);
		sb.append(", passportExpirationDate=");
		sb.append(passportExpirationDate);
		sb.append(", europeanCardNumber=");
		sb.append(europeanCardNumber);
		sb.append(", europeanCardReleaseDate=");
		sb.append(europeanCardReleaseDate);
		sb.append(", europeanCardExpirationDate=");
		sb.append(europeanCardExpirationDate);
		sb.append(", gunLicenceNumber=");
		sb.append(gunLicenceNumber);
		sb.append(", gunLicenceReleaseDate=");
		sb.append(gunLicenceReleaseDate);
		sb.append(", gunLicenceExpirationDate=");
		sb.append(gunLicenceExpirationDate);
		sb.append(", firstGunType=");
		sb.append(firstGunType);
		sb.append(", firstGunKind=");
		sb.append(firstGunKind);
		sb.append(", firstGunCaliber=");
		sb.append(firstGunCaliber);
		sb.append(", firstGunCode=");
		sb.append(firstGunCode);
		sb.append(", firstGunExtraCanes=");
		sb.append(firstGunExtraCanes);
		sb.append(", secondGunType=");
		sb.append(secondGunType);
		sb.append(", secondGunKind=");
		sb.append(secondGunKind);
		sb.append(", secondGunCaliber=");
		sb.append(secondGunCaliber);
		sb.append(", secondGunCode=");
		sb.append(secondGunCode);
		sb.append(", secondGunExtraCanes=");
		sb.append(secondGunExtraCanes);
		sb.append(", gunCartridgeType=");
		sb.append(gunCartridgeType);
		sb.append(", gunCartridgeKind=");
		sb.append(gunCartridgeKind);
		sb.append(", cartridgeCaliber=");
		sb.append(cartridgeCaliber);
		sb.append(", esfMatchId=");
		sb.append(esfMatchId);
		sb.append(", esfGunTypeIdOne=");
		sb.append(esfGunTypeIdOne);
		sb.append(", esfGunKindIdOne=");
		sb.append(esfGunKindIdOne);
		sb.append(", esfGunTypeIdTwo=");
		sb.append(esfGunTypeIdTwo);
		sb.append(", esfGunKindIdTwo=");
		sb.append(esfGunKindIdTwo);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ESFPartecipantInfo toEntityModel() {
		ESFPartecipantInfoImpl esfPartecipantInfoImpl = new ESFPartecipantInfoImpl();

		esfPartecipantInfoImpl.setEsfPartecipantInfoId(esfPartecipantInfoId);
		esfPartecipantInfoImpl.setGroupId(groupId);
		esfPartecipantInfoImpl.setCompanyId(companyId);
		esfPartecipantInfoImpl.setUserId(userId);

		if (userName == null) {
			esfPartecipantInfoImpl.setUserName(StringPool.BLANK);
		}
		else {
			esfPartecipantInfoImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			esfPartecipantInfoImpl.setCreateDate(null);
		}
		else {
			esfPartecipantInfoImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			esfPartecipantInfoImpl.setModifiedDate(null);
		}
		else {
			esfPartecipantInfoImpl.setModifiedDate(new Date(modifiedDate));
		}

		esfPartecipantInfoImpl.setIsPortalUser(isPortalUser);
		esfPartecipantInfoImpl.setEsfUserId(esfUserId);
		esfPartecipantInfoImpl.setProtocol(protocol);

		if (firstName == null) {
			esfPartecipantInfoImpl.setFirstName(StringPool.BLANK);
		}
		else {
			esfPartecipantInfoImpl.setFirstName(firstName);
		}

		if (lastName == null) {
			esfPartecipantInfoImpl.setLastName(StringPool.BLANK);
		}
		else {
			esfPartecipantInfoImpl.setLastName(lastName);
		}

		if (placeOfBirth == null) {
			esfPartecipantInfoImpl.setPlaceOfBirth(StringPool.BLANK);
		}
		else {
			esfPartecipantInfoImpl.setPlaceOfBirth(placeOfBirth);
		}

		if (dateOfBirth == Long.MIN_VALUE) {
			esfPartecipantInfoImpl.setDateOfBirth(null);
		}
		else {
			esfPartecipantInfoImpl.setDateOfBirth(new Date(dateOfBirth));
		}

		if (residenceCity == null) {
			esfPartecipantInfoImpl.setResidenceCity(StringPool.BLANK);
		}
		else {
			esfPartecipantInfoImpl.setResidenceCity(residenceCity);
		}

		if (province == null) {
			esfPartecipantInfoImpl.setProvince(StringPool.BLANK);
		}
		else {
			esfPartecipantInfoImpl.setProvince(province);
		}

		esfPartecipantInfoImpl.setZip(zip);

		if (address == null) {
			esfPartecipantInfoImpl.setAddress(StringPool.BLANK);
		}
		else {
			esfPartecipantInfoImpl.setAddress(address);
		}

		if (phonNumber == null) {
			esfPartecipantInfoImpl.setPhonNumber(StringPool.BLANK);
		}
		else {
			esfPartecipantInfoImpl.setPhonNumber(phonNumber);
		}

		if (email == null) {
			esfPartecipantInfoImpl.setEmail(StringPool.BLANK);
		}
		else {
			esfPartecipantInfoImpl.setEmail(email);
		}

		if (maritialStatus == null) {
			esfPartecipantInfoImpl.setMaritialStatus(StringPool.BLANK);
		}
		else {
			esfPartecipantInfoImpl.setMaritialStatus(maritialStatus);
		}

		if (fiscalCode == null) {
			esfPartecipantInfoImpl.setFiscalCode(StringPool.BLANK);
		}
		else {
			esfPartecipantInfoImpl.setFiscalCode(fiscalCode);
		}

		if (passport == null) {
			esfPartecipantInfoImpl.setPassport(StringPool.BLANK);
		}
		else {
			esfPartecipantInfoImpl.setPassport(passport);
		}

		if (releasedBy == null) {
			esfPartecipantInfoImpl.setReleasedBy(StringPool.BLANK);
		}
		else {
			esfPartecipantInfoImpl.setReleasedBy(releasedBy);
		}

		if (passportReleaseDate == Long.MIN_VALUE) {
			esfPartecipantInfoImpl.setPassportReleaseDate(null);
		}
		else {
			esfPartecipantInfoImpl.setPassportReleaseDate(new Date(
					passportReleaseDate));
		}

		if (passportExpirationDate == Long.MIN_VALUE) {
			esfPartecipantInfoImpl.setPassportExpirationDate(null);
		}
		else {
			esfPartecipantInfoImpl.setPassportExpirationDate(new Date(
					passportExpirationDate));
		}

		if (europeanCardNumber == null) {
			esfPartecipantInfoImpl.setEuropeanCardNumber(StringPool.BLANK);
		}
		else {
			esfPartecipantInfoImpl.setEuropeanCardNumber(europeanCardNumber);
		}

		if (europeanCardReleaseDate == Long.MIN_VALUE) {
			esfPartecipantInfoImpl.setEuropeanCardReleaseDate(null);
		}
		else {
			esfPartecipantInfoImpl.setEuropeanCardReleaseDate(new Date(
					europeanCardReleaseDate));
		}

		if (europeanCardExpirationDate == Long.MIN_VALUE) {
			esfPartecipantInfoImpl.setEuropeanCardExpirationDate(null);
		}
		else {
			esfPartecipantInfoImpl.setEuropeanCardExpirationDate(new Date(
					europeanCardExpirationDate));
		}

		if (gunLicenceNumber == null) {
			esfPartecipantInfoImpl.setGunLicenceNumber(StringPool.BLANK);
		}
		else {
			esfPartecipantInfoImpl.setGunLicenceNumber(gunLicenceNumber);
		}

		if (gunLicenceReleaseDate == Long.MIN_VALUE) {
			esfPartecipantInfoImpl.setGunLicenceReleaseDate(null);
		}
		else {
			esfPartecipantInfoImpl.setGunLicenceReleaseDate(new Date(
					gunLicenceReleaseDate));
		}

		if (gunLicenceExpirationDate == Long.MIN_VALUE) {
			esfPartecipantInfoImpl.setGunLicenceExpirationDate(null);
		}
		else {
			esfPartecipantInfoImpl.setGunLicenceExpirationDate(new Date(
					gunLicenceExpirationDate));
		}

		if (firstGunType == null) {
			esfPartecipantInfoImpl.setFirstGunType(StringPool.BLANK);
		}
		else {
			esfPartecipantInfoImpl.setFirstGunType(firstGunType);
		}

		if (firstGunKind == null) {
			esfPartecipantInfoImpl.setFirstGunKind(StringPool.BLANK);
		}
		else {
			esfPartecipantInfoImpl.setFirstGunKind(firstGunKind);
		}

		esfPartecipantInfoImpl.setFirstGunCaliber(firstGunCaliber);

		if (firstGunCode == null) {
			esfPartecipantInfoImpl.setFirstGunCode(StringPool.BLANK);
		}
		else {
			esfPartecipantInfoImpl.setFirstGunCode(firstGunCode);
		}

		if (firstGunExtraCanes == null) {
			esfPartecipantInfoImpl.setFirstGunExtraCanes(StringPool.BLANK);
		}
		else {
			esfPartecipantInfoImpl.setFirstGunExtraCanes(firstGunExtraCanes);
		}

		if (secondGunType == null) {
			esfPartecipantInfoImpl.setSecondGunType(StringPool.BLANK);
		}
		else {
			esfPartecipantInfoImpl.setSecondGunType(secondGunType);
		}

		if (secondGunKind == null) {
			esfPartecipantInfoImpl.setSecondGunKind(StringPool.BLANK);
		}
		else {
			esfPartecipantInfoImpl.setSecondGunKind(secondGunKind);
		}

		esfPartecipantInfoImpl.setSecondGunCaliber(secondGunCaliber);

		if (secondGunCode == null) {
			esfPartecipantInfoImpl.setSecondGunCode(StringPool.BLANK);
		}
		else {
			esfPartecipantInfoImpl.setSecondGunCode(secondGunCode);
		}

		if (secondGunExtraCanes == null) {
			esfPartecipantInfoImpl.setSecondGunExtraCanes(StringPool.BLANK);
		}
		else {
			esfPartecipantInfoImpl.setSecondGunExtraCanes(secondGunExtraCanes);
		}

		if (gunCartridgeType == null) {
			esfPartecipantInfoImpl.setGunCartridgeType(StringPool.BLANK);
		}
		else {
			esfPartecipantInfoImpl.setGunCartridgeType(gunCartridgeType);
		}

		if (gunCartridgeKind == null) {
			esfPartecipantInfoImpl.setGunCartridgeKind(StringPool.BLANK);
		}
		else {
			esfPartecipantInfoImpl.setGunCartridgeKind(gunCartridgeKind);
		}

		if (cartridgeCaliber == null) {
			esfPartecipantInfoImpl.setCartridgeCaliber(StringPool.BLANK);
		}
		else {
			esfPartecipantInfoImpl.setCartridgeCaliber(cartridgeCaliber);
		}

		esfPartecipantInfoImpl.setEsfMatchId(esfMatchId);
		esfPartecipantInfoImpl.setEsfGunTypeIdOne(esfGunTypeIdOne);
		esfPartecipantInfoImpl.setEsfGunKindIdOne(esfGunKindIdOne);
		esfPartecipantInfoImpl.setEsfGunTypeIdTwo(esfGunTypeIdTwo);
		esfPartecipantInfoImpl.setEsfGunKindIdTwo(esfGunKindIdTwo);

		esfPartecipantInfoImpl.resetOriginalValues();

		return esfPartecipantInfoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		esfPartecipantInfoId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		isPortalUser = objectInput.readBoolean();
		esfUserId = objectInput.readLong();
		protocol = objectInput.readLong();
		firstName = objectInput.readUTF();
		lastName = objectInput.readUTF();
		placeOfBirth = objectInput.readUTF();
		dateOfBirth = objectInput.readLong();
		residenceCity = objectInput.readUTF();
		province = objectInput.readUTF();
		zip = objectInput.readInt();
		address = objectInput.readUTF();
		phonNumber = objectInput.readUTF();
		email = objectInput.readUTF();
		maritialStatus = objectInput.readUTF();
		fiscalCode = objectInput.readUTF();
		passport = objectInput.readUTF();
		releasedBy = objectInput.readUTF();
		passportReleaseDate = objectInput.readLong();
		passportExpirationDate = objectInput.readLong();
		europeanCardNumber = objectInput.readUTF();
		europeanCardReleaseDate = objectInput.readLong();
		europeanCardExpirationDate = objectInput.readLong();
		gunLicenceNumber = objectInput.readUTF();
		gunLicenceReleaseDate = objectInput.readLong();
		gunLicenceExpirationDate = objectInput.readLong();
		firstGunType = objectInput.readUTF();
		firstGunKind = objectInput.readUTF();
		firstGunCaliber = objectInput.readDouble();
		firstGunCode = objectInput.readUTF();
		firstGunExtraCanes = objectInput.readUTF();
		secondGunType = objectInput.readUTF();
		secondGunKind = objectInput.readUTF();
		secondGunCaliber = objectInput.readDouble();
		secondGunCode = objectInput.readUTF();
		secondGunExtraCanes = objectInput.readUTF();
		gunCartridgeType = objectInput.readUTF();
		gunCartridgeKind = objectInput.readUTF();
		cartridgeCaliber = objectInput.readUTF();
		esfMatchId = objectInput.readLong();
		esfGunTypeIdOne = objectInput.readLong();
		esfGunKindIdOne = objectInput.readLong();
		esfGunTypeIdTwo = objectInput.readLong();
		esfGunKindIdTwo = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(esfPartecipantInfoId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeBoolean(isPortalUser);
		objectOutput.writeLong(esfUserId);
		objectOutput.writeLong(protocol);

		if (firstName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(firstName);
		}

		if (lastName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(lastName);
		}

		if (placeOfBirth == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(placeOfBirth);
		}

		objectOutput.writeLong(dateOfBirth);

		if (residenceCity == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(residenceCity);
		}

		if (province == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(province);
		}

		objectOutput.writeInt(zip);

		if (address == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(address);
		}

		if (phonNumber == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(phonNumber);
		}

		if (email == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(email);
		}

		if (maritialStatus == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(maritialStatus);
		}

		if (fiscalCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(fiscalCode);
		}

		if (passport == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(passport);
		}

		if (releasedBy == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(releasedBy);
		}

		objectOutput.writeLong(passportReleaseDate);
		objectOutput.writeLong(passportExpirationDate);

		if (europeanCardNumber == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(europeanCardNumber);
		}

		objectOutput.writeLong(europeanCardReleaseDate);
		objectOutput.writeLong(europeanCardExpirationDate);

		if (gunLicenceNumber == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(gunLicenceNumber);
		}

		objectOutput.writeLong(gunLicenceReleaseDate);
		objectOutput.writeLong(gunLicenceExpirationDate);

		if (firstGunType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(firstGunType);
		}

		if (firstGunKind == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(firstGunKind);
		}

		objectOutput.writeDouble(firstGunCaliber);

		if (firstGunCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(firstGunCode);
		}

		if (firstGunExtraCanes == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(firstGunExtraCanes);
		}

		if (secondGunType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(secondGunType);
		}

		if (secondGunKind == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(secondGunKind);
		}

		objectOutput.writeDouble(secondGunCaliber);

		if (secondGunCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(secondGunCode);
		}

		if (secondGunExtraCanes == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(secondGunExtraCanes);
		}

		if (gunCartridgeType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(gunCartridgeType);
		}

		if (gunCartridgeKind == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(gunCartridgeKind);
		}

		if (cartridgeCaliber == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(cartridgeCaliber);
		}

		objectOutput.writeLong(esfMatchId);
		objectOutput.writeLong(esfGunTypeIdOne);
		objectOutput.writeLong(esfGunKindIdOne);
		objectOutput.writeLong(esfGunTypeIdTwo);
		objectOutput.writeLong(esfGunKindIdTwo);
	}

	public long esfPartecipantInfoId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public boolean isPortalUser;
	public long esfUserId;
	public long protocol;
	public String firstName;
	public String lastName;
	public String placeOfBirth;
	public long dateOfBirth;
	public String residenceCity;
	public String province;
	public int zip;
	public String address;
	public String phonNumber;
	public String email;
	public String maritialStatus;
	public String fiscalCode;
	public String passport;
	public String releasedBy;
	public long passportReleaseDate;
	public long passportExpirationDate;
	public String europeanCardNumber;
	public long europeanCardReleaseDate;
	public long europeanCardExpirationDate;
	public String gunLicenceNumber;
	public long gunLicenceReleaseDate;
	public long gunLicenceExpirationDate;
	public String firstGunType;
	public String firstGunKind;
	public double firstGunCaliber;
	public String firstGunCode;
	public String firstGunExtraCanes;
	public String secondGunType;
	public String secondGunKind;
	public double secondGunCaliber;
	public String secondGunCode;
	public String secondGunExtraCanes;
	public String gunCartridgeType;
	public String gunCartridgeKind;
	public String cartridgeCaliber;
	public long esfMatchId;
	public long esfGunTypeIdOne;
	public long esfGunKindIdOne;
	public long esfGunTypeIdTwo;
	public long esfGunKindIdTwo;
}