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

import it.ethica.esf.model.ESFSpecific;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ESFSpecific in entity cache.
 *
 * @author Ethica
 * @see ESFSpecific
 * @generated
 */
public class ESFSpecificCacheModel implements CacheModel<ESFSpecific>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", esfSpecificId=");
		sb.append(esfSpecificId);
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
		sb.append(", description=");
		sb.append(description);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ESFSpecific toEntityModel() {
		ESFSpecificImpl esfSpecificImpl = new ESFSpecificImpl();

		if (uuid == null) {
			esfSpecificImpl.setUuid(StringPool.BLANK);
		}
		else {
			esfSpecificImpl.setUuid(uuid);
		}

		esfSpecificImpl.setEsfSpecificId(esfSpecificId);
		esfSpecificImpl.setGroupId(groupId);
		esfSpecificImpl.setCompanyId(companyId);
		esfSpecificImpl.setUserId(userId);

		if (userName == null) {
			esfSpecificImpl.setUserName(StringPool.BLANK);
		}
		else {
			esfSpecificImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			esfSpecificImpl.setCreateDate(null);
		}
		else {
			esfSpecificImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			esfSpecificImpl.setModifiedDate(null);
		}
		else {
			esfSpecificImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (code == null) {
			esfSpecificImpl.setCode(StringPool.BLANK);
		}
		else {
			esfSpecificImpl.setCode(code);
		}

		if (description == null) {
			esfSpecificImpl.setDescription(StringPool.BLANK);
		}
		else {
			esfSpecificImpl.setDescription(description);
		}

		esfSpecificImpl.resetOriginalValues();

		return esfSpecificImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		esfSpecificId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		code = objectInput.readUTF();
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

		objectOutput.writeLong(esfSpecificId);
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

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}
	}

	public String uuid;
	public long esfSpecificId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String code;
	public String description;
}