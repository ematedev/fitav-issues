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

import it.ethica.esf.model.ESFForniture;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ESFForniture in entity cache.
 *
 * @author Ethica
 * @see ESFForniture
 * @generated
 */
public class ESFFornitureCacheModel implements CacheModel<ESFForniture>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", esfFornitureId=");
		sb.append(esfFornitureId);
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
		sb.append(", code=");
		sb.append(code);
		sb.append(", name=");
		sb.append(name);
		sb.append(", description=");
		sb.append(description);
		sb.append(", type=");
		sb.append(type);
		sb.append(", insertDate=");
		sb.append(insertDate);
		sb.append(", numberFornitures=");
		sb.append(numberFornitures);
		sb.append(", size=");
		sb.append(size);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ESFForniture toEntityModel() {
		ESFFornitureImpl esfFornitureImpl = new ESFFornitureImpl();

		if (uuid == null) {
			esfFornitureImpl.setUuid(StringPool.BLANK);
		}
		else {
			esfFornitureImpl.setUuid(uuid);
		}

		esfFornitureImpl.setEsfFornitureId(esfFornitureId);
		esfFornitureImpl.setGroupId(groupId);
		esfFornitureImpl.setCompanyId(companyId);
		esfFornitureImpl.setUserId(userId);

		if (userName == null) {
			esfFornitureImpl.setUserName(StringPool.BLANK);
		}
		else {
			esfFornitureImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			esfFornitureImpl.setCreateDate(null);
		}
		else {
			esfFornitureImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			esfFornitureImpl.setModifiedDate(null);
		}
		else {
			esfFornitureImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (code == null) {
			esfFornitureImpl.setCode(StringPool.BLANK);
		}
		else {
			esfFornitureImpl.setCode(code);
		}

		if (name == null) {
			esfFornitureImpl.setName(StringPool.BLANK);
		}
		else {
			esfFornitureImpl.setName(name);
		}

		if (description == null) {
			esfFornitureImpl.setDescription(StringPool.BLANK);
		}
		else {
			esfFornitureImpl.setDescription(description);
		}

		esfFornitureImpl.setType(type);

		if (insertDate == Long.MIN_VALUE) {
			esfFornitureImpl.setInsertDate(null);
		}
		else {
			esfFornitureImpl.setInsertDate(new Date(insertDate));
		}

		esfFornitureImpl.setNumberFornitures(numberFornitures);

		if (size == null) {
			esfFornitureImpl.setSize(StringPool.BLANK);
		}
		else {
			esfFornitureImpl.setSize(size);
		}

		esfFornitureImpl.resetOriginalValues();

		return esfFornitureImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		esfFornitureId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		code = objectInput.readUTF();
		name = objectInput.readUTF();
		description = objectInput.readUTF();
		type = objectInput.readLong();
		insertDate = objectInput.readLong();
		numberFornitures = objectInput.readLong();
		size = objectInput.readUTF();
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

		objectOutput.writeLong(esfFornitureId);
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

		if (code == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(code);
		}

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

		objectOutput.writeLong(type);
		objectOutput.writeLong(insertDate);
		objectOutput.writeLong(numberFornitures);

		if (size == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(size);
		}
	}

	public String uuid;
	public long esfFornitureId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String code;
	public String name;
	public String description;
	public long type;
	public long insertDate;
	public long numberFornitures;
	public String size;
}