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

import it.ethica.esf.model.ESFGunType;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ESFGunType in entity cache.
 *
 * @author Ethica
 * @see ESFGunType
 * @generated
 */
public class ESFGunTypeCacheModel implements CacheModel<ESFGunType>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", esfGunTypeId=");
		sb.append(esfGunTypeId);
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
		sb.append(", isCatridgeProductor=");
		sb.append(isCatridgeProductor);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ESFGunType toEntityModel() {
		ESFGunTypeImpl esfGunTypeImpl = new ESFGunTypeImpl();

		if (uuid == null) {
			esfGunTypeImpl.setUuid(StringPool.BLANK);
		}
		else {
			esfGunTypeImpl.setUuid(uuid);
		}

		esfGunTypeImpl.setEsfGunTypeId(esfGunTypeId);
		esfGunTypeImpl.setGroupId(groupId);
		esfGunTypeImpl.setCompanyId(companyId);
		esfGunTypeImpl.setUserId(userId);

		if (userName == null) {
			esfGunTypeImpl.setUserName(StringPool.BLANK);
		}
		else {
			esfGunTypeImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			esfGunTypeImpl.setCreateDate(null);
		}
		else {
			esfGunTypeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			esfGunTypeImpl.setModifiedDate(null);
		}
		else {
			esfGunTypeImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			esfGunTypeImpl.setName(StringPool.BLANK);
		}
		else {
			esfGunTypeImpl.setName(name);
		}

		if (description == null) {
			esfGunTypeImpl.setDescription(StringPool.BLANK);
		}
		else {
			esfGunTypeImpl.setDescription(description);
		}

		esfGunTypeImpl.setIsCatridgeProductor(isCatridgeProductor);

		esfGunTypeImpl.resetOriginalValues();

		return esfGunTypeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		esfGunTypeId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		name = objectInput.readUTF();
		description = objectInput.readUTF();
		isCatridgeProductor = objectInput.readBoolean();
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

		objectOutput.writeLong(esfGunTypeId);
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

		objectOutput.writeBoolean(isCatridgeProductor);
	}

	public String uuid;
	public long esfGunTypeId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String name;
	public String description;
	public boolean isCatridgeProductor;
}