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

import it.ethica.esf.model.ESFFieldESFSportType;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ESFFieldESFSportType in entity cache.
 *
 * @author Ethica
 * @see ESFFieldESFSportType
 * @generated
 */
public class ESFFieldESFSportTypeCacheModel implements CacheModel<ESFFieldESFSportType>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{esfFieldId=");
		sb.append(esfFieldId);
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
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ESFFieldESFSportType toEntityModel() {
		ESFFieldESFSportTypeImpl esfFieldESFSportTypeImpl = new ESFFieldESFSportTypeImpl();

		esfFieldESFSportTypeImpl.setEsfFieldId(esfFieldId);
		esfFieldESFSportTypeImpl.setEsfSportTypeId(esfSportTypeId);
		esfFieldESFSportTypeImpl.setGroupId(groupId);
		esfFieldESFSportTypeImpl.setCompanyId(companyId);
		esfFieldESFSportTypeImpl.setUserId(userId);

		if (userName == null) {
			esfFieldESFSportTypeImpl.setUserName(StringPool.BLANK);
		}
		else {
			esfFieldESFSportTypeImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			esfFieldESFSportTypeImpl.setCreateDate(null);
		}
		else {
			esfFieldESFSportTypeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			esfFieldESFSportTypeImpl.setModifiedDate(null);
		}
		else {
			esfFieldESFSportTypeImpl.setModifiedDate(new Date(modifiedDate));
		}

		esfFieldESFSportTypeImpl.resetOriginalValues();

		return esfFieldESFSportTypeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		esfFieldId = objectInput.readLong();
		esfSportTypeId = objectInput.readLong();
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
		objectOutput.writeLong(esfFieldId);
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
	}

	public long esfFieldId;
	public long esfSportTypeId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
}