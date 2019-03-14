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

import it.ethica.esf.model.ESFUserRole;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ESFUserRole in entity cache.
 *
 * @author Ethica
 * @see ESFUserRole
 * @generated
 */
public class ESFUserRoleCacheModel implements CacheModel<ESFUserRole>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", esfUserRoleId=");
		sb.append(esfUserRoleId);
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
		sb.append(", isBDO=");
		sb.append(isBDO);
		sb.append(", isLEA=");
		sb.append(isLEA);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ESFUserRole toEntityModel() {
		ESFUserRoleImpl esfUserRoleImpl = new ESFUserRoleImpl();

		if (uuid == null) {
			esfUserRoleImpl.setUuid(StringPool.BLANK);
		}
		else {
			esfUserRoleImpl.setUuid(uuid);
		}

		esfUserRoleImpl.setEsfUserRoleId(esfUserRoleId);
		esfUserRoleImpl.setGroupId(groupId);
		esfUserRoleImpl.setCompanyId(companyId);
		esfUserRoleImpl.setUserId(userId);

		if (userName == null) {
			esfUserRoleImpl.setUserName(StringPool.BLANK);
		}
		else {
			esfUserRoleImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			esfUserRoleImpl.setCreateDate(null);
		}
		else {
			esfUserRoleImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			esfUserRoleImpl.setModifiedDate(null);
		}
		else {
			esfUserRoleImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			esfUserRoleImpl.setName(StringPool.BLANK);
		}
		else {
			esfUserRoleImpl.setName(name);
		}

		if (description == null) {
			esfUserRoleImpl.setDescription(StringPool.BLANK);
		}
		else {
			esfUserRoleImpl.setDescription(description);
		}

		esfUserRoleImpl.setIsBDO(isBDO);
		esfUserRoleImpl.setIsLEA(isLEA);

		esfUserRoleImpl.resetOriginalValues();

		return esfUserRoleImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		esfUserRoleId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		name = objectInput.readUTF();
		description = objectInput.readUTF();
		isBDO = objectInput.readBoolean();
		isLEA = objectInput.readBoolean();
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

		objectOutput.writeLong(esfUserRoleId);
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

		objectOutput.writeBoolean(isBDO);
		objectOutput.writeBoolean(isLEA);
	}

	public String uuid;
	public long esfUserRoleId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String name;
	public String description;
	public boolean isBDO;
	public boolean isLEA;
}