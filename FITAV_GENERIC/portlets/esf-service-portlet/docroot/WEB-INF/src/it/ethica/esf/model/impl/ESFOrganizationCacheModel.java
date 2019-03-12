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

import it.ethica.esf.model.ESFOrganization;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ESFOrganization in entity cache.
 *
 * @author Ethica
 * @see ESFOrganization
 * @generated
 */
public class ESFOrganizationCacheModel implements CacheModel<ESFOrganization>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", esfOrganizationId=");
		sb.append(esfOrganizationId);
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
		sb.append(", portalOrganizationId=");
		sb.append(portalOrganizationId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ESFOrganization toEntityModel() {
		ESFOrganizationImpl esfOrganizationImpl = new ESFOrganizationImpl();

		if (uuid == null) {
			esfOrganizationImpl.setUuid(StringPool.BLANK);
		}
		else {
			esfOrganizationImpl.setUuid(uuid);
		}

		esfOrganizationImpl.setEsfOrganizationId(esfOrganizationId);
		esfOrganizationImpl.setGroupId(groupId);
		esfOrganizationImpl.setCompanyId(companyId);
		esfOrganizationImpl.setUserId(userId);

		if (userName == null) {
			esfOrganizationImpl.setUserName(StringPool.BLANK);
		}
		else {
			esfOrganizationImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			esfOrganizationImpl.setCreateDate(null);
		}
		else {
			esfOrganizationImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			esfOrganizationImpl.setModifiedDate(null);
		}
		else {
			esfOrganizationImpl.setModifiedDate(new Date(modifiedDate));
		}

		esfOrganizationImpl.setPortalOrganizationId(portalOrganizationId);

		esfOrganizationImpl.resetOriginalValues();

		return esfOrganizationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		esfOrganizationId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		portalOrganizationId = objectInput.readLong();
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

		objectOutput.writeLong(esfOrganizationId);
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
		objectOutput.writeLong(portalOrganizationId);
	}

	public String uuid;
	public long esfOrganizationId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long portalOrganizationId;
}