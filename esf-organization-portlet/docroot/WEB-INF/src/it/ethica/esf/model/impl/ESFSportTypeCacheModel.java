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

import it.ethica.esf.model.ESFSportType;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ESFSportType in entity cache.
 *
 * @author Ethica
 * @see ESFSportType
 * @generated
 */
public class ESFSportTypeCacheModel implements CacheModel<ESFSportType>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", esfSportTypeId=");
		sb.append(esfSportTypeId);
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
		sb.append(", name=");
		sb.append(name);
		sb.append(", description=");
		sb.append(description);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ESFSportType toEntityModel() {
		ESFSportTypeImpl esfSportTypeImpl = new ESFSportTypeImpl();

		if (uuid == null) {
			esfSportTypeImpl.setUuid(StringPool.BLANK);
		}
		else {
			esfSportTypeImpl.setUuid(uuid);
		}

		esfSportTypeImpl.setEsfSportTypeId(esfSportTypeId);
		esfSportTypeImpl.setGroupId(groupId);
		esfSportTypeImpl.setCompanyId(companyId);
		esfSportTypeImpl.setUserId(userId);

		if (userName == null) {
			esfSportTypeImpl.setUserName(StringPool.BLANK);
		}
		else {
			esfSportTypeImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			esfSportTypeImpl.setCreateDate(null);
		}
		else {
			esfSportTypeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			esfSportTypeImpl.setModifiedDate(null);
		}
		else {
			esfSportTypeImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			esfSportTypeImpl.setName(StringPool.BLANK);
		}
		else {
			esfSportTypeImpl.setName(name);
		}

		if (description == null) {
			esfSportTypeImpl.setDescription(StringPool.BLANK);
		}
		else {
			esfSportTypeImpl.setDescription(description);
		}

		esfSportTypeImpl.resetOriginalValues();

		return esfSportTypeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		esfSportTypeId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		name = objectInput.readUTF();
		description = objectInput.readUTF();
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

		objectOutput.writeLong(esfSportTypeId);
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

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}
	}

	public String uuid;
	public long esfSportTypeId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String name;
	public String description;
}