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

import it.ethica.esf.model.ESFShooterQualification;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ESFShooterQualification in entity cache.
 *
 * @author Ethica
 * @see ESFShooterQualification
 * @generated
 */
public class ESFShooterQualificationCacheModel implements CacheModel<ESFShooterQualification>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", esfShooterQualificationId=");
		sb.append(esfShooterQualificationId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", isJunior=");
		sb.append(isJunior);
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
		sb.append(", description=");
		sb.append(description);
		sb.append(", code=");
		sb.append(code);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ESFShooterQualification toEntityModel() {
		ESFShooterQualificationImpl esfShooterQualificationImpl = new ESFShooterQualificationImpl();

		if (uuid == null) {
			esfShooterQualificationImpl.setUuid(StringPool.BLANK);
		}
		else {
			esfShooterQualificationImpl.setUuid(uuid);
		}

		esfShooterQualificationImpl.setEsfShooterQualificationId(esfShooterQualificationId);

		if (name == null) {
			esfShooterQualificationImpl.setName(StringPool.BLANK);
		}
		else {
			esfShooterQualificationImpl.setName(name);
		}

		esfShooterQualificationImpl.setIsJunior(isJunior);
		esfShooterQualificationImpl.setGroupId(groupId);
		esfShooterQualificationImpl.setCompanyId(companyId);
		esfShooterQualificationImpl.setUserId(userId);

		if (userName == null) {
			esfShooterQualificationImpl.setUserName(StringPool.BLANK);
		}
		else {
			esfShooterQualificationImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			esfShooterQualificationImpl.setCreateDate(null);
		}
		else {
			esfShooterQualificationImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			esfShooterQualificationImpl.setModifiedDate(null);
		}
		else {
			esfShooterQualificationImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (description == null) {
			esfShooterQualificationImpl.setDescription(StringPool.BLANK);
		}
		else {
			esfShooterQualificationImpl.setDescription(description);
		}

		if (code == null) {
			esfShooterQualificationImpl.setCode(StringPool.BLANK);
		}
		else {
			esfShooterQualificationImpl.setCode(code);
		}

		esfShooterQualificationImpl.resetOriginalValues();

		return esfShooterQualificationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		esfShooterQualificationId = objectInput.readLong();
		name = objectInput.readUTF();
		isJunior = objectInput.readBoolean();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		description = objectInput.readUTF();
		code = objectInput.readUTF();
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

		objectOutput.writeLong(esfShooterQualificationId);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeBoolean(isJunior);
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

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (code == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(code);
		}
	}

	public String uuid;
	public long esfShooterQualificationId;
	public String name;
	public boolean isJunior;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String description;
	public String code;
}