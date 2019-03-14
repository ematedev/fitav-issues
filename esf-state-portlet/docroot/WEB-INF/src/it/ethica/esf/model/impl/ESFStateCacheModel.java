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

import it.ethica.esf.model.ESFState;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ESFState in entity cache.
 *
 * @author Ethica
 * @see ESFState
 * @generated
 */
public class ESFStateCacheModel implements CacheModel<ESFState>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", esfStateId=");
		sb.append(esfStateId);
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
		sb.append(", esfName=");
		sb.append(esfName);
		sb.append(", esfDescription=");
		sb.append(esfDescription);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ESFState toEntityModel() {
		ESFStateImpl esfStateImpl = new ESFStateImpl();

		if (uuid == null) {
			esfStateImpl.setUuid(StringPool.BLANK);
		}
		else {
			esfStateImpl.setUuid(uuid);
		}

		esfStateImpl.setEsfStateId(esfStateId);
		esfStateImpl.setGroupId(groupId);
		esfStateImpl.setCompanyId(companyId);
		esfStateImpl.setUserId(userId);

		if (userName == null) {
			esfStateImpl.setUserName(StringPool.BLANK);
		}
		else {
			esfStateImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			esfStateImpl.setCreateDate(null);
		}
		else {
			esfStateImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			esfStateImpl.setModifiedDate(null);
		}
		else {
			esfStateImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (esfName == null) {
			esfStateImpl.setEsfName(StringPool.BLANK);
		}
		else {
			esfStateImpl.setEsfName(esfName);
		}

		if (esfDescription == null) {
			esfStateImpl.setEsfDescription(StringPool.BLANK);
		}
		else {
			esfStateImpl.setEsfDescription(esfDescription);
		}

		esfStateImpl.resetOriginalValues();

		return esfStateImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		esfStateId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		esfName = objectInput.readUTF();
		esfDescription = objectInput.readUTF();
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

		objectOutput.writeLong(esfStateId);
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

		if (esfName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(esfName);
		}

		if (esfDescription == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(esfDescription);
		}
	}

	public String uuid;
	public long esfStateId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String esfName;
	public String esfDescription;
}