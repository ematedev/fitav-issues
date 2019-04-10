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

import it.ethica.esf.model.ESFPartecipant;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ESFPartecipant in entity cache.
 *
 * @author Ethica
 * @see ESFPartecipant
 * @generated
 */
public class ESFPartecipantCacheModel implements CacheModel<ESFPartecipant>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", esfPartecipantId=");
		sb.append(esfPartecipantId);
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
		sb.append(", esfUserId=");
		sb.append(esfUserId);
		sb.append(", esfMatchId=");
		sb.append(esfMatchId);
		sb.append(", esfTeamId=");
		sb.append(esfTeamId);
		sb.append(", ct=");
		sb.append(ct);
		sb.append(", esfPartecipantTypeId=");
		sb.append(esfPartecipantTypeId);
		sb.append(", result=");
		sb.append(result);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ESFPartecipant toEntityModel() {
		ESFPartecipantImpl esfPartecipantImpl = new ESFPartecipantImpl();

		if (uuid == null) {
			esfPartecipantImpl.setUuid(StringPool.BLANK);
		}
		else {
			esfPartecipantImpl.setUuid(uuid);
		}

		esfPartecipantImpl.setEsfPartecipantId(esfPartecipantId);
		esfPartecipantImpl.setGroupId(groupId);
		esfPartecipantImpl.setCompanyId(companyId);
		esfPartecipantImpl.setUserId(userId);

		if (userName == null) {
			esfPartecipantImpl.setUserName(StringPool.BLANK);
		}
		else {
			esfPartecipantImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			esfPartecipantImpl.setCreateDate(null);
		}
		else {
			esfPartecipantImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			esfPartecipantImpl.setModifiedDate(null);
		}
		else {
			esfPartecipantImpl.setModifiedDate(new Date(modifiedDate));
		}

		esfPartecipantImpl.setEsfUserId(esfUserId);
		esfPartecipantImpl.setEsfMatchId(esfMatchId);
		esfPartecipantImpl.setEsfTeamId(esfTeamId);
		esfPartecipantImpl.setCt(ct);
		esfPartecipantImpl.setEsfPartecipantTypeId(esfPartecipantTypeId);
		esfPartecipantImpl.setResult(result);

		esfPartecipantImpl.resetOriginalValues();

		return esfPartecipantImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		esfPartecipantId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		esfUserId = objectInput.readLong();
		esfMatchId = objectInput.readLong();
		esfTeamId = objectInput.readLong();
		ct = objectInput.readLong();
		esfPartecipantTypeId = objectInput.readLong();
		result = objectInput.readLong();
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

		objectOutput.writeLong(esfPartecipantId);
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
		objectOutput.writeLong(esfUserId);
		objectOutput.writeLong(esfMatchId);
		objectOutput.writeLong(esfTeamId);
		objectOutput.writeLong(ct);
		objectOutput.writeLong(esfPartecipantTypeId);
		objectOutput.writeLong(result);
	}

	public String uuid;
	public long esfPartecipantId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long esfUserId;
	public long esfMatchId;
	public long esfTeamId;
	public long ct;
	public long esfPartecipantTypeId;
	public long result;
}