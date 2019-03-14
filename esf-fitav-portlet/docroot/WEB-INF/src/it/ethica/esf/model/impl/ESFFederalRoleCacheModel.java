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

import it.ethica.esf.model.ESFFederalRole;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ESFFederalRole in entity cache.
 *
 * @author Ethica
 * @see ESFFederalRole
 * @generated
 */
public class ESFFederalRoleCacheModel implements CacheModel<ESFFederalRole>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", esfFederalRoleId=");
		sb.append(esfFederalRoleId);
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
		sb.append(", regional=");
		sb.append(regional);
		sb.append(", provincial=");
		sb.append(provincial);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ESFFederalRole toEntityModel() {
		ESFFederalRoleImpl esfFederalRoleImpl = new ESFFederalRoleImpl();

		if (uuid == null) {
			esfFederalRoleImpl.setUuid(StringPool.BLANK);
		}
		else {
			esfFederalRoleImpl.setUuid(uuid);
		}

		esfFederalRoleImpl.setEsfFederalRoleId(esfFederalRoleId);
		esfFederalRoleImpl.setGroupId(groupId);
		esfFederalRoleImpl.setCompanyId(companyId);
		esfFederalRoleImpl.setUserId(userId);

		if (userName == null) {
			esfFederalRoleImpl.setUserName(StringPool.BLANK);
		}
		else {
			esfFederalRoleImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			esfFederalRoleImpl.setCreateDate(null);
		}
		else {
			esfFederalRoleImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			esfFederalRoleImpl.setModifiedDate(null);
		}
		else {
			esfFederalRoleImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (code == null) {
			esfFederalRoleImpl.setCode(StringPool.BLANK);
		}
		else {
			esfFederalRoleImpl.setCode(code);
		}

		if (description == null) {
			esfFederalRoleImpl.setDescription(StringPool.BLANK);
		}
		else {
			esfFederalRoleImpl.setDescription(description);
		}

		esfFederalRoleImpl.setRegional(regional);
		esfFederalRoleImpl.setProvincial(provincial);

		esfFederalRoleImpl.resetOriginalValues();

		return esfFederalRoleImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		esfFederalRoleId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		code = objectInput.readUTF();
		description = objectInput.readUTF();
		regional = objectInput.readBoolean();
		provincial = objectInput.readBoolean();
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

		objectOutput.writeLong(esfFederalRoleId);
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

		objectOutput.writeBoolean(regional);
		objectOutput.writeBoolean(provincial);
	}

	public String uuid;
	public long esfFederalRoleId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String code;
	public String description;
	public boolean regional;
	public boolean provincial;
}