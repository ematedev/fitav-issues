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

import it.ethica.esf.model.ESFGun;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ESFGun in entity cache.
 *
 * @author Ethica
 * @see ESFGun
 * @generated
 */
public class ESFGunCacheModel implements CacheModel<ESFGun>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(39);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", esfGunId=");
		sb.append(esfGunId);
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
		sb.append(", esfUserId=");
		sb.append(esfUserId);
		sb.append(", code=");
		sb.append(code);
		sb.append(", esfGunKindId=");
		sb.append(esfGunKindId);
		sb.append(", esfOrganizationId=");
		sb.append(esfOrganizationId);
		sb.append(", registrationNumber=");
		sb.append(registrationNumber);
		sb.append(", catridgeCaliber=");
		sb.append(catridgeCaliber);
		sb.append(", isFavoriteGun=");
		sb.append(isFavoriteGun);
		sb.append(", typeId=");
		sb.append(typeId);
		sb.append(", measures=");
		sb.append(measures);
		sb.append(", note=");
		sb.append(note);
		sb.append(", name=");
		sb.append(name);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ESFGun toEntityModel() {
		ESFGunImpl esfGunImpl = new ESFGunImpl();

		if (uuid == null) {
			esfGunImpl.setUuid(StringPool.BLANK);
		}
		else {
			esfGunImpl.setUuid(uuid);
		}

		esfGunImpl.setEsfGunId(esfGunId);
		esfGunImpl.setGroupId(groupId);
		esfGunImpl.setCompanyId(companyId);
		esfGunImpl.setUserId(userId);

		if (userName == null) {
			esfGunImpl.setUserName(StringPool.BLANK);
		}
		else {
			esfGunImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			esfGunImpl.setCreateDate(null);
		}
		else {
			esfGunImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			esfGunImpl.setModifiedDate(null);
		}
		else {
			esfGunImpl.setModifiedDate(new Date(modifiedDate));
		}

		esfGunImpl.setEsfUserId(esfUserId);

		if (code == null) {
			esfGunImpl.setCode(StringPool.BLANK);
		}
		else {
			esfGunImpl.setCode(code);
		}

		esfGunImpl.setEsfGunKindId(esfGunKindId);
		esfGunImpl.setEsfOrganizationId(esfOrganizationId);

		if (registrationNumber == null) {
			esfGunImpl.setRegistrationNumber(StringPool.BLANK);
		}
		else {
			esfGunImpl.setRegistrationNumber(registrationNumber);
		}

		esfGunImpl.setCatridgeCaliber(catridgeCaliber);
		esfGunImpl.setIsFavoriteGun(isFavoriteGun);
		esfGunImpl.setTypeId(typeId);

		if (measures == null) {
			esfGunImpl.setMeasures(StringPool.BLANK);
		}
		else {
			esfGunImpl.setMeasures(measures);
		}

		if (note == null) {
			esfGunImpl.setNote(StringPool.BLANK);
		}
		else {
			esfGunImpl.setNote(note);
		}

		if (name == null) {
			esfGunImpl.setName(StringPool.BLANK);
		}
		else {
			esfGunImpl.setName(name);
		}

		esfGunImpl.resetOriginalValues();

		return esfGunImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		esfGunId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		esfUserId = objectInput.readLong();
		code = objectInput.readUTF();
		esfGunKindId = objectInput.readLong();
		esfOrganizationId = objectInput.readLong();
		registrationNumber = objectInput.readUTF();
		catridgeCaliber = objectInput.readLong();
		isFavoriteGun = objectInput.readBoolean();
		typeId = objectInput.readInt();
		measures = objectInput.readUTF();
		note = objectInput.readUTF();
		name = objectInput.readUTF();
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

		objectOutput.writeLong(esfGunId);
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
		objectOutput.writeLong(esfUserId);

		if (code == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(code);
		}

		objectOutput.writeLong(esfGunKindId);
		objectOutput.writeLong(esfOrganizationId);

		if (registrationNumber == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(registrationNumber);
		}

		objectOutput.writeLong(catridgeCaliber);
		objectOutput.writeBoolean(isFavoriteGun);
		objectOutput.writeInt(typeId);

		if (measures == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(measures);
		}

		if (note == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(note);
		}

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}
	}

	public String uuid;
	public long esfGunId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long esfUserId;
	public String code;
	public long esfGunKindId;
	public long esfOrganizationId;
	public String registrationNumber;
	public long catridgeCaliber;
	public boolean isFavoriteGun;
	public int typeId;
	public String measures;
	public String note;
	public String name;
}