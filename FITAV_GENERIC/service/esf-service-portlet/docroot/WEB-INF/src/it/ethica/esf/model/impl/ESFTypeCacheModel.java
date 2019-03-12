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

import it.ethica.esf.model.ESFType;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ESFType in entity cache.
 *
 * @author Ethica
 * @see ESFType
 * @generated
 */
public class ESFTypeCacheModel implements CacheModel<ESFType>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{esfTypeId=");
		sb.append(esfTypeId);
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
		sb.append(", className=");
		sb.append(className);
		sb.append(", status=");
		sb.append(status);
		sb.append(", typeParentId=");
		sb.append(typeParentId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ESFType toEntityModel() {
		ESFTypeImpl esfTypeImpl = new ESFTypeImpl();

		esfTypeImpl.setEsfTypeId(esfTypeId);
		esfTypeImpl.setGroupId(groupId);
		esfTypeImpl.setCompanyId(companyId);
		esfTypeImpl.setUserId(userId);

		if (userName == null) {
			esfTypeImpl.setUserName(StringPool.BLANK);
		}
		else {
			esfTypeImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			esfTypeImpl.setCreateDate(null);
		}
		else {
			esfTypeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			esfTypeImpl.setModifiedDate(null);
		}
		else {
			esfTypeImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (code == null) {
			esfTypeImpl.setCode(StringPool.BLANK);
		}
		else {
			esfTypeImpl.setCode(code);
		}

		if (name == null) {
			esfTypeImpl.setName(StringPool.BLANK);
		}
		else {
			esfTypeImpl.setName(name);
		}

		if (description == null) {
			esfTypeImpl.setDescription(StringPool.BLANK);
		}
		else {
			esfTypeImpl.setDescription(description);
		}

		if (className == null) {
			esfTypeImpl.setClassName(StringPool.BLANK);
		}
		else {
			esfTypeImpl.setClassName(className);
		}

		if (status == null) {
			esfTypeImpl.setStatus(StringPool.BLANK);
		}
		else {
			esfTypeImpl.setStatus(status);
		}

		esfTypeImpl.setTypeParentId(typeParentId);

		esfTypeImpl.resetOriginalValues();

		return esfTypeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		esfTypeId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		code = objectInput.readUTF();
		name = objectInput.readUTF();
		description = objectInput.readUTF();
		className = objectInput.readUTF();
		status = objectInput.readUTF();
		typeParentId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(esfTypeId);
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

		if (className == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(className);
		}

		if (status == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(status);
		}

		objectOutput.writeLong(typeParentId);
	}

	public long esfTypeId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String code;
	public String name;
	public String description;
	public String className;
	public String status;
	public long typeParentId;
}