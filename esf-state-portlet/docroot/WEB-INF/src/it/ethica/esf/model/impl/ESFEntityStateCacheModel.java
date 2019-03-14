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

import it.ethica.esf.model.ESFEntityState;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ESFEntityState in entity cache.
 *
 * @author Ethica
 * @see ESFEntityState
 * @generated
 */
public class ESFEntityStateCacheModel implements CacheModel<ESFEntityState>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{uuid=");
		sb.append(uuid);
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
		sb.append(", className=");
		sb.append(className);
		sb.append(", classPk=");
		sb.append(classPk);
		sb.append(", stateId=");
		sb.append(stateId);
		sb.append(", startDate=");
		sb.append(startDate);
		sb.append(", endDate=");
		sb.append(endDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ESFEntityState toEntityModel() {
		ESFEntityStateImpl esfEntityStateImpl = new ESFEntityStateImpl();

		if (uuid == null) {
			esfEntityStateImpl.setUuid(StringPool.BLANK);
		}
		else {
			esfEntityStateImpl.setUuid(uuid);
		}

		esfEntityStateImpl.setGroupId(groupId);
		esfEntityStateImpl.setCompanyId(companyId);
		esfEntityStateImpl.setUserId(userId);

		if (userName == null) {
			esfEntityStateImpl.setUserName(StringPool.BLANK);
		}
		else {
			esfEntityStateImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			esfEntityStateImpl.setCreateDate(null);
		}
		else {
			esfEntityStateImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			esfEntityStateImpl.setModifiedDate(null);
		}
		else {
			esfEntityStateImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (className == null) {
			esfEntityStateImpl.setClassName(StringPool.BLANK);
		}
		else {
			esfEntityStateImpl.setClassName(className);
		}

		esfEntityStateImpl.setClassPk(classPk);
		esfEntityStateImpl.setStateId(stateId);

		if (startDate == Long.MIN_VALUE) {
			esfEntityStateImpl.setStartDate(null);
		}
		else {
			esfEntityStateImpl.setStartDate(new Date(startDate));
		}

		if (endDate == Long.MIN_VALUE) {
			esfEntityStateImpl.setEndDate(null);
		}
		else {
			esfEntityStateImpl.setEndDate(new Date(endDate));
		}

		esfEntityStateImpl.resetOriginalValues();

		return esfEntityStateImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		className = objectInput.readUTF();
		classPk = objectInput.readLong();
		stateId = objectInput.readLong();
		startDate = objectInput.readLong();
		endDate = objectInput.readLong();
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

		if (className == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(className);
		}

		objectOutput.writeLong(classPk);
		objectOutput.writeLong(stateId);
		objectOutput.writeLong(startDate);
		objectOutput.writeLong(endDate);
	}

	public String uuid;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String className;
	public long classPk;
	public long stateId;
	public long startDate;
	public long endDate;
}