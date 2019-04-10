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

package it.ethica.esf.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import it.ethica.esf.model.ESFUser;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ESFUser in entity cache.
 *
 * @author Ethica
 * @see ESFUser
 * @generated
 */
public class ESFUserCacheModel implements CacheModel<ESFUser>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(43);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", esfUserId=");
		sb.append(esfUserId);
		sb.append(", code=");
		sb.append(code);
		sb.append(", typearmy=");
		sb.append(typearmy);
		sb.append(", fiscalCode=");
		sb.append(fiscalCode);
		sb.append(", birthcity=");
		sb.append(birthcity);
		sb.append(", nationality=");
		sb.append(nationality);
		sb.append(", isSportsGroups=");
		sb.append(isSportsGroups);
		sb.append(", job=");
		sb.append(job);
		sb.append(", issfIdNumber=");
		sb.append(issfIdNumber);
		sb.append(", categoryId=");
		sb.append(categoryId);
		sb.append(", pin=");
		sb.append(pin);
		sb.append(", codeUser=");
		sb.append(codeUser);
		sb.append(", DateOfDeath=");
		sb.append(DateOfDeath);
		sb.append(", privacy1=");
		sb.append(privacy1);
		sb.append(", privacy2=");
		sb.append(privacy2);
		sb.append(", privacy3=");
		sb.append(privacy3);
		sb.append(", datePrivacy1=");
		sb.append(datePrivacy1);
		sb.append(", datePrivacy2=");
		sb.append(datePrivacy2);
		sb.append(", datePrivacy3=");
		sb.append(datePrivacy3);
		sb.append(", validateCF=");
		sb.append(validateCF);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ESFUser toEntityModel() {
		ESFUserImpl esfUserImpl = new ESFUserImpl();

		if (uuid == null) {
			esfUserImpl.setUuid(StringPool.BLANK);
		}
		else {
			esfUserImpl.setUuid(uuid);
		}

		esfUserImpl.setEsfUserId(esfUserId);

		if (code == null) {
			esfUserImpl.setCode(StringPool.BLANK);
		}
		else {
			esfUserImpl.setCode(code);
		}

		esfUserImpl.setTypearmy(typearmy);

		if (fiscalCode == null) {
			esfUserImpl.setFiscalCode(StringPool.BLANK);
		}
		else {
			esfUserImpl.setFiscalCode(fiscalCode);
		}

		if (birthcity == null) {
			esfUserImpl.setBirthcity(StringPool.BLANK);
		}
		else {
			esfUserImpl.setBirthcity(birthcity);
		}

		if (nationality == null) {
			esfUserImpl.setNationality(StringPool.BLANK);
		}
		else {
			esfUserImpl.setNationality(nationality);
		}

		esfUserImpl.setIsSportsGroups(isSportsGroups);

		if (job == null) {
			esfUserImpl.setJob(StringPool.BLANK);
		}
		else {
			esfUserImpl.setJob(job);
		}

		if (issfIdNumber == null) {
			esfUserImpl.setIssfIdNumber(StringPool.BLANK);
		}
		else {
			esfUserImpl.setIssfIdNumber(issfIdNumber);
		}

		esfUserImpl.setCategoryId(categoryId);
		esfUserImpl.setPin(pin);
		esfUserImpl.setCodeUser(codeUser);

		if (DateOfDeath == Long.MIN_VALUE) {
			esfUserImpl.setDateOfDeath(null);
		}
		else {
			esfUserImpl.setDateOfDeath(new Date(DateOfDeath));
		}

		esfUserImpl.setPrivacy1(privacy1);
		esfUserImpl.setPrivacy2(privacy2);
		esfUserImpl.setPrivacy3(privacy3);

		if (datePrivacy1 == Long.MIN_VALUE) {
			esfUserImpl.setDatePrivacy1(null);
		}
		else {
			esfUserImpl.setDatePrivacy1(new Date(datePrivacy1));
		}

		if (datePrivacy2 == Long.MIN_VALUE) {
			esfUserImpl.setDatePrivacy2(null);
		}
		else {
			esfUserImpl.setDatePrivacy2(new Date(datePrivacy2));
		}

		if (datePrivacy3 == Long.MIN_VALUE) {
			esfUserImpl.setDatePrivacy3(null);
		}
		else {
			esfUserImpl.setDatePrivacy3(new Date(datePrivacy3));
		}

		esfUserImpl.setValidateCF(validateCF);

		esfUserImpl.resetOriginalValues();

		return esfUserImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		esfUserId = objectInput.readLong();
		code = objectInput.readUTF();
		typearmy = objectInput.readLong();
		fiscalCode = objectInput.readUTF();
		birthcity = objectInput.readUTF();
		nationality = objectInput.readUTF();
		isSportsGroups = objectInput.readBoolean();
		job = objectInput.readUTF();
		issfIdNumber = objectInput.readUTF();
		categoryId = objectInput.readLong();
		pin = objectInput.readLong();
		codeUser = objectInput.readLong();
		DateOfDeath = objectInput.readLong();
		privacy1 = objectInput.readBoolean();
		privacy2 = objectInput.readBoolean();
		privacy3 = objectInput.readBoolean();
		datePrivacy1 = objectInput.readLong();
		datePrivacy2 = objectInput.readLong();
		datePrivacy3 = objectInput.readLong();
		validateCF = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(esfUserId);

		if (code == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(code);
		}

		objectOutput.writeLong(typearmy);

		if (fiscalCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(fiscalCode);
		}

		if (birthcity == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(birthcity);
		}

		if (nationality == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(nationality);
		}

		objectOutput.writeBoolean(isSportsGroups);

		if (job == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(job);
		}

		if (issfIdNumber == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(issfIdNumber);
		}

		objectOutput.writeLong(categoryId);
		objectOutput.writeLong(pin);
		objectOutput.writeLong(codeUser);
		objectOutput.writeLong(DateOfDeath);
		objectOutput.writeBoolean(privacy1);
		objectOutput.writeBoolean(privacy2);
		objectOutput.writeBoolean(privacy3);
		objectOutput.writeLong(datePrivacy1);
		objectOutput.writeLong(datePrivacy2);
		objectOutput.writeLong(datePrivacy3);
		objectOutput.writeBoolean(validateCF);
	}

	public String uuid;
	public long esfUserId;
	public String code;
	public long typearmy;
	public String fiscalCode;
	public String birthcity;
	public String nationality;
	public boolean isSportsGroups;
	public String job;
	public String issfIdNumber;
	public long categoryId;
	public long pin;
	public long codeUser;
	public long DateOfDeath;
	public boolean privacy1;
	public boolean privacy2;
	public boolean privacy3;
	public long datePrivacy1;
	public long datePrivacy2;
	public long datePrivacy3;
	public boolean validateCF;
}