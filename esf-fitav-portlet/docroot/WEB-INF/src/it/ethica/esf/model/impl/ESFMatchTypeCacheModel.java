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

import it.ethica.esf.model.ESFMatchType;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ESFMatchType in entity cache.
 *
 * @author Ethica
 * @see ESFMatchType
 * @generated
 */
public class ESFMatchTypeCacheModel implements CacheModel<ESFMatchType>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{esfMatchTypeId=");
		sb.append(esfMatchTypeId);
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
		sb.append(", isCategoryQualification=");
		sb.append(isCategoryQualification);
		sb.append(", isNational=");
		sb.append(isNational);
		sb.append(", code=");
		sb.append(code);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ESFMatchType toEntityModel() {
		ESFMatchTypeImpl esfMatchTypeImpl = new ESFMatchTypeImpl();

		esfMatchTypeImpl.setEsfMatchTypeId(esfMatchTypeId);
		esfMatchTypeImpl.setGroupId(groupId);
		esfMatchTypeImpl.setCompanyId(companyId);
		esfMatchTypeImpl.setUserId(userId);

		if (userName == null) {
			esfMatchTypeImpl.setUserName(StringPool.BLANK);
		}
		else {
			esfMatchTypeImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			esfMatchTypeImpl.setCreateDate(null);
		}
		else {
			esfMatchTypeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			esfMatchTypeImpl.setModifiedDate(null);
		}
		else {
			esfMatchTypeImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			esfMatchTypeImpl.setName(StringPool.BLANK);
		}
		else {
			esfMatchTypeImpl.setName(name);
		}

		esfMatchTypeImpl.setIsCategoryQualification(isCategoryQualification);
		esfMatchTypeImpl.setIsNational(isNational);

		if (code == null) {
			esfMatchTypeImpl.setCode(StringPool.BLANK);
		}
		else {
			esfMatchTypeImpl.setCode(code);
		}

		esfMatchTypeImpl.resetOriginalValues();

		return esfMatchTypeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		esfMatchTypeId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		name = objectInput.readUTF();
		isCategoryQualification = objectInput.readBoolean();
		isNational = objectInput.readBoolean();
		code = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(esfMatchTypeId);
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

		objectOutput.writeBoolean(isCategoryQualification);
		objectOutput.writeBoolean(isNational);

		if (code == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(code);
		}
	}

	public long esfMatchTypeId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String name;
	public boolean isCategoryQualification;
	public boolean isNational;
	public String code;
}