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

import it.ethica.esf.model.ESFCard;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ESFCard in entity cache.
 *
 * @author Ethica
 * @see ESFCard
 * @generated
 */
public class ESFCardCacheModel implements CacheModel<ESFCard>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", esfCardId=");
		sb.append(esfCardId);
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
		sb.append(", startDate=");
		sb.append(startDate);
		sb.append(", endDate=");
		sb.append(endDate);
		sb.append(", esfUserId=");
		sb.append(esfUserId);
		sb.append(", esfOrganizationId=");
		sb.append(esfOrganizationId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ESFCard toEntityModel() {
		ESFCardImpl esfCardImpl = new ESFCardImpl();

		if (uuid == null) {
			esfCardImpl.setUuid(StringPool.BLANK);
		}
		else {
			esfCardImpl.setUuid(uuid);
		}

		esfCardImpl.setEsfCardId(esfCardId);
		esfCardImpl.setGroupId(groupId);
		esfCardImpl.setCompanyId(companyId);
		esfCardImpl.setUserId(userId);

		if (userName == null) {
			esfCardImpl.setUserName(StringPool.BLANK);
		}
		else {
			esfCardImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			esfCardImpl.setCreateDate(null);
		}
		else {
			esfCardImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			esfCardImpl.setModifiedDate(null);
		}
		else {
			esfCardImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (code == null) {
			esfCardImpl.setCode(StringPool.BLANK);
		}
		else {
			esfCardImpl.setCode(code);
		}

		if (startDate == Long.MIN_VALUE) {
			esfCardImpl.setStartDate(null);
		}
		else {
			esfCardImpl.setStartDate(new Date(startDate));
		}

		if (endDate == Long.MIN_VALUE) {
			esfCardImpl.setEndDate(null);
		}
		else {
			esfCardImpl.setEndDate(new Date(endDate));
		}

		esfCardImpl.setEsfUserId(esfUserId);
		esfCardImpl.setEsfOrganizationId(esfOrganizationId);

		esfCardImpl.resetOriginalValues();

		return esfCardImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		esfCardId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		code = objectInput.readUTF();
		startDate = objectInput.readLong();
		endDate = objectInput.readLong();
		esfUserId = objectInput.readLong();
		esfOrganizationId = objectInput.readLong();
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

		objectOutput.writeLong(esfCardId);
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

		objectOutput.writeLong(startDate);
		objectOutput.writeLong(endDate);
		objectOutput.writeLong(esfUserId);
		objectOutput.writeLong(esfOrganizationId);
	}

	public String uuid;
	public long esfCardId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String code;
	public long startDate;
	public long endDate;
	public long esfUserId;
	public long esfOrganizationId;
}