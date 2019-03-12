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

import it.ethica.esf.model.ESFOrganizationUnitservice;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ESFOrganizationUnitservice in entity cache.
 *
 * @author Ethica
 * @see ESFOrganizationUnitservice
 * @generated
 */
public class ESFOrganizationUnitserviceCacheModel implements CacheModel<ESFOrganizationUnitservice>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", esfOrganizationUnitserviceId=");
		sb.append(esfOrganizationUnitserviceId);
		sb.append(", esfOrganizationId=");
		sb.append(esfOrganizationId);
		sb.append(", esfUnitserviceId=");
		sb.append(esfUnitserviceId);
		sb.append(", numberUnitservices=");
		sb.append(numberUnitservices);
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
	public ESFOrganizationUnitservice toEntityModel() {
		ESFOrganizationUnitserviceImpl esfOrganizationUnitserviceImpl = new ESFOrganizationUnitserviceImpl();

		if (uuid == null) {
			esfOrganizationUnitserviceImpl.setUuid(StringPool.BLANK);
		}
		else {
			esfOrganizationUnitserviceImpl.setUuid(uuid);
		}

		esfOrganizationUnitserviceImpl.setEsfOrganizationUnitserviceId(esfOrganizationUnitserviceId);
		esfOrganizationUnitserviceImpl.setEsfOrganizationId(esfOrganizationId);
		esfOrganizationUnitserviceImpl.setEsfUnitserviceId(esfUnitserviceId);
		esfOrganizationUnitserviceImpl.setNumberUnitservices(numberUnitservices);

		if (description == null) {
			esfOrganizationUnitserviceImpl.setDescription(StringPool.BLANK);
		}
		else {
			esfOrganizationUnitserviceImpl.setDescription(description);
		}

		esfOrganizationUnitserviceImpl.setGroupId(groupId);
		esfOrganizationUnitserviceImpl.setCompanyId(companyId);
		esfOrganizationUnitserviceImpl.setUserId(userId);

		if (userName == null) {
			esfOrganizationUnitserviceImpl.setUserName(StringPool.BLANK);
		}
		else {
			esfOrganizationUnitserviceImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			esfOrganizationUnitserviceImpl.setCreateDate(null);
		}
		else {
			esfOrganizationUnitserviceImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			esfOrganizationUnitserviceImpl.setModifiedDate(null);
		}
		else {
			esfOrganizationUnitserviceImpl.setModifiedDate(new Date(
					modifiedDate));
		}

		esfOrganizationUnitserviceImpl.resetOriginalValues();

		return esfOrganizationUnitserviceImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		esfOrganizationUnitserviceId = objectInput.readLong();
		esfOrganizationId = objectInput.readLong();
		esfUnitserviceId = objectInput.readLong();
		numberUnitservices = objectInput.readLong();
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

		objectOutput.writeLong(esfOrganizationUnitserviceId);
		objectOutput.writeLong(esfOrganizationId);
		objectOutput.writeLong(esfUnitserviceId);
		objectOutput.writeLong(numberUnitservices);

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
	public long esfOrganizationUnitserviceId;
	public long esfOrganizationId;
	public long esfUnitserviceId;
	public long numberUnitservices;
	public String description;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
}