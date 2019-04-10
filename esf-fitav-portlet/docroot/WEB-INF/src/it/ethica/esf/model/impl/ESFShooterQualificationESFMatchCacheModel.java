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

import it.ethica.esf.model.ESFShooterQualificationESFMatch;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ESFShooterQualificationESFMatch in entity cache.
 *
 * @author Ethica
 * @see ESFShooterQualificationESFMatch
 * @generated
 */
public class ESFShooterQualificationESFMatchCacheModel implements CacheModel<ESFShooterQualificationESFMatch>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", esfShooterQualificationId=");
		sb.append(esfShooterQualificationId);
		sb.append(", esfMatchId=");
		sb.append(esfMatchId);
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
	public ESFShooterQualificationESFMatch toEntityModel() {
		ESFShooterQualificationESFMatchImpl esfShooterQualificationESFMatchImpl = new ESFShooterQualificationESFMatchImpl();

		if (uuid == null) {
			esfShooterQualificationESFMatchImpl.setUuid(StringPool.BLANK);
		}
		else {
			esfShooterQualificationESFMatchImpl.setUuid(uuid);
		}

		esfShooterQualificationESFMatchImpl.setEsfShooterQualificationId(esfShooterQualificationId);
		esfShooterQualificationESFMatchImpl.setEsfMatchId(esfMatchId);
		esfShooterQualificationESFMatchImpl.setGroupId(groupId);
		esfShooterQualificationESFMatchImpl.setCompanyId(companyId);
		esfShooterQualificationESFMatchImpl.setUserId(userId);

		if (userName == null) {
			esfShooterQualificationESFMatchImpl.setUserName(StringPool.BLANK);
		}
		else {
			esfShooterQualificationESFMatchImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			esfShooterQualificationESFMatchImpl.setCreateDate(null);
		}
		else {
			esfShooterQualificationESFMatchImpl.setCreateDate(new Date(
					createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			esfShooterQualificationESFMatchImpl.setModifiedDate(null);
		}
		else {
			esfShooterQualificationESFMatchImpl.setModifiedDate(new Date(
					modifiedDate));
		}

		esfShooterQualificationESFMatchImpl.resetOriginalValues();

		return esfShooterQualificationESFMatchImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		esfShooterQualificationId = objectInput.readLong();
		esfMatchId = objectInput.readLong();
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

		objectOutput.writeLong(esfShooterQualificationId);
		objectOutput.writeLong(esfMatchId);
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
	public long esfShooterQualificationId;
	public long esfMatchId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
}