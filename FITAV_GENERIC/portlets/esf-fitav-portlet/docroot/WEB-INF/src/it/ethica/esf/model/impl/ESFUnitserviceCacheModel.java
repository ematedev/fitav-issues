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

import it.ethica.esf.model.ESFUnitservice;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ESFUnitservice in entity cache.
 *
 * @author Ethica
 * @see ESFUnitservice
 * @generated
 */
public class ESFUnitserviceCacheModel implements CacheModel<ESFUnitservice>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", esfUnitserviceId=");
		sb.append(esfUnitserviceId);
		sb.append(", description=");
		sb.append(description);
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
	public ESFUnitservice toEntityModel() {
		ESFUnitserviceImpl esfUnitserviceImpl = new ESFUnitserviceImpl();

		if (uuid == null) {
			esfUnitserviceImpl.setUuid(StringPool.BLANK);
		}
		else {
			esfUnitserviceImpl.setUuid(uuid);
		}

		esfUnitserviceImpl.setEsfUnitserviceId(esfUnitserviceId);

		if (description == null) {
			esfUnitserviceImpl.setDescription(StringPool.BLANK);
		}
		else {
			esfUnitserviceImpl.setDescription(description);
		}

		esfUnitserviceImpl.setGroupId(groupId);
		esfUnitserviceImpl.setCompanyId(companyId);
		esfUnitserviceImpl.setUserId(userId);

		if (userName == null) {
			esfUnitserviceImpl.setUserName(StringPool.BLANK);
		}
		else {
			esfUnitserviceImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			esfUnitserviceImpl.setCreateDate(null);
		}
		else {
			esfUnitserviceImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			esfUnitserviceImpl.setModifiedDate(null);
		}
		else {
			esfUnitserviceImpl.setModifiedDate(new Date(modifiedDate));
		}

		esfUnitserviceImpl.resetOriginalValues();

		return esfUnitserviceImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		esfUnitserviceId = objectInput.readLong();
		description = objectInput.readUTF();
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

		objectOutput.writeLong(esfUnitserviceId);

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
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
	}

	public String uuid;
	public long esfUnitserviceId;
	public String description;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
}