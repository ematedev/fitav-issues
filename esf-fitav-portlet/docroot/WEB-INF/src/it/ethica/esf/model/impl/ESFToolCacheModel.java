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

import it.ethica.esf.model.ESFTool;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ESFTool in entity cache.
 *
 * @author Ethica
 * @see ESFTool
 * @generated
 */
public class ESFToolCacheModel implements CacheModel<ESFTool>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", esfToolId=");
		sb.append(esfToolId);
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
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ESFTool toEntityModel() {
		ESFToolImpl esfToolImpl = new ESFToolImpl();

		if (uuid == null) {
			esfToolImpl.setUuid(StringPool.BLANK);
		}
		else {
			esfToolImpl.setUuid(uuid);
		}

		esfToolImpl.setEsfToolId(esfToolId);
		esfToolImpl.setGroupId(groupId);
		esfToolImpl.setCompanyId(companyId);
		esfToolImpl.setUserId(userId);

		if (userName == null) {
			esfToolImpl.setUserName(StringPool.BLANK);
		}
		else {
			esfToolImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			esfToolImpl.setCreateDate(null);
		}
		else {
			esfToolImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			esfToolImpl.setModifiedDate(null);
		}
		else {
			esfToolImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (code == null) {
			esfToolImpl.setCode(StringPool.BLANK);
		}
		else {
			esfToolImpl.setCode(code);
		}

		if (name == null) {
			esfToolImpl.setName(StringPool.BLANK);
		}
		else {
			esfToolImpl.setName(name);
		}

		if (description == null) {
			esfToolImpl.setDescription(StringPool.BLANK);
		}
		else {
			esfToolImpl.setDescription(description);
		}

		if (type == null) {
			esfToolImpl.setType(StringPool.BLANK);
		}
		else {
			esfToolImpl.setType(type);
		}

		esfToolImpl.resetOriginalValues();

		return esfToolImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		esfToolId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		code = objectInput.readUTF();
		name = objectInput.readUTF();
		description = objectInput.readUTF();
		type = objectInput.readUTF();
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

		objectOutput.writeLong(esfToolId);
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

		if (type == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(type);
		}
	}

	public String uuid;
	public long esfToolId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String code;
	public String name;
	public String description;
	public String type;
}