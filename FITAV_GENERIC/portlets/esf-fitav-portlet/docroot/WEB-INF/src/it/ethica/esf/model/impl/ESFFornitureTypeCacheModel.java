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

import it.ethica.esf.model.ESFFornitureType;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ESFFornitureType in entity cache.
 *
 * @author Ethica
 * @see ESFFornitureType
 * @generated
 */
public class ESFFornitureTypeCacheModel implements CacheModel<ESFFornitureType>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", esfFornitureTypeId=");
		sb.append(esfFornitureTypeId);
		sb.append(", description=");
		sb.append(description);
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
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ESFFornitureType toEntityModel() {
		ESFFornitureTypeImpl esfFornitureTypeImpl = new ESFFornitureTypeImpl();

		if (uuid == null) {
			esfFornitureTypeImpl.setUuid(StringPool.BLANK);
		}
		else {
			esfFornitureTypeImpl.setUuid(uuid);
		}

		esfFornitureTypeImpl.setEsfFornitureTypeId(esfFornitureTypeId);

		if (description == null) {
			esfFornitureTypeImpl.setDescription(StringPool.BLANK);
		}
		else {
			esfFornitureTypeImpl.setDescription(description);
		}

		esfFornitureTypeImpl.setGroupId(groupId);
		esfFornitureTypeImpl.setCompanyId(companyId);
		esfFornitureTypeImpl.setUserId(userId);

		if (userName == null) {
			esfFornitureTypeImpl.setUserName(StringPool.BLANK);
		}
		else {
			esfFornitureTypeImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			esfFornitureTypeImpl.setCreateDate(null);
		}
		else {
			esfFornitureTypeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			esfFornitureTypeImpl.setModifiedDate(null);
		}
		else {
			esfFornitureTypeImpl.setModifiedDate(new Date(modifiedDate));
		}

		esfFornitureTypeImpl.resetOriginalValues();

		return esfFornitureTypeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		esfFornitureTypeId = objectInput.readLong();
		description = objectInput.readUTF();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
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

		objectOutput.writeLong(esfFornitureTypeId);

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
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
	}

	public String uuid;
	public long esfFornitureTypeId;
	public String description;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
}