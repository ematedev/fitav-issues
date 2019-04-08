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

import it.ethica.esf.model.ESFConfiguration;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ESFConfiguration in entity cache.
 *
 * @author Ethica
 * @see ESFConfiguration
 * @generated
 */
public class ESFConfigurationCacheModel implements CacheModel<ESFConfiguration>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{esfConfigurationId=");
		sb.append(esfConfigurationId);
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
		sb.append(", key=");
		sb.append(key);
		sb.append(", value=");
		sb.append(value);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ESFConfiguration toEntityModel() {
		ESFConfigurationImpl esfConfigurationImpl = new ESFConfigurationImpl();

		esfConfigurationImpl.setEsfConfigurationId(esfConfigurationId);
		esfConfigurationImpl.setGroupId(groupId);
		esfConfigurationImpl.setCompanyId(companyId);
		esfConfigurationImpl.setUserId(userId);

		if (userName == null) {
			esfConfigurationImpl.setUserName(StringPool.BLANK);
		}
		else {
			esfConfigurationImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			esfConfigurationImpl.setCreateDate(null);
		}
		else {
			esfConfigurationImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			esfConfigurationImpl.setModifiedDate(null);
		}
		else {
			esfConfigurationImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (key == null) {
			esfConfigurationImpl.setKey(StringPool.BLANK);
		}
		else {
			esfConfigurationImpl.setKey(key);
		}

		if (value == null) {
			esfConfigurationImpl.setValue(StringPool.BLANK);
		}
		else {
			esfConfigurationImpl.setValue(value);
		}

		esfConfigurationImpl.resetOriginalValues();

		return esfConfigurationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		esfConfigurationId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		key = objectInput.readUTF();
		value = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(esfConfigurationId);
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

		if (key == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(key);
		}

		if (value == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(value);
		}
	}

	public long esfConfigurationId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String key;
	public String value;
}