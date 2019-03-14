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

import it.ethica.esf.model.ESFShooterCategory;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ESFShooterCategory in entity cache.
 *
 * @author Ethica
 * @see ESFShooterCategory
 * @generated
 */
public class ESFShooterCategoryCacheModel implements CacheModel<ESFShooterCategory>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", esfShooterCategoryId=");
		sb.append(esfShooterCategoryId);
		sb.append(", name=");
		sb.append(name);
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
	public ESFShooterCategory toEntityModel() {
		ESFShooterCategoryImpl esfShooterCategoryImpl = new ESFShooterCategoryImpl();

		if (uuid == null) {
			esfShooterCategoryImpl.setUuid(StringPool.BLANK);
		}
		else {
			esfShooterCategoryImpl.setUuid(uuid);
		}

		esfShooterCategoryImpl.setEsfShooterCategoryId(esfShooterCategoryId);

		if (name == null) {
			esfShooterCategoryImpl.setName(StringPool.BLANK);
		}
		else {
			esfShooterCategoryImpl.setName(name);
		}

		esfShooterCategoryImpl.setGroupId(groupId);
		esfShooterCategoryImpl.setCompanyId(companyId);
		esfShooterCategoryImpl.setUserId(userId);

		if (userName == null) {
			esfShooterCategoryImpl.setUserName(StringPool.BLANK);
		}
		else {
			esfShooterCategoryImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			esfShooterCategoryImpl.setCreateDate(null);
		}
		else {
			esfShooterCategoryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			esfShooterCategoryImpl.setModifiedDate(null);
		}
		else {
			esfShooterCategoryImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (description == null) {
			esfShooterCategoryImpl.setDescription(StringPool.BLANK);
		}
		else {
			esfShooterCategoryImpl.setDescription(description);
		}

		if (code == null) {
			esfShooterCategoryImpl.setCode(StringPool.BLANK);
		}
		else {
			esfShooterCategoryImpl.setCode(code);
		}

		esfShooterCategoryImpl.resetOriginalValues();

		return esfShooterCategoryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		esfShooterCategoryId = objectInput.readLong();
		name = objectInput.readUTF();
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

		objectOutput.writeLong(esfShooterCategoryId);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

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
	public long esfShooterCategoryId;
	public String name;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String description;
	public String code;
}