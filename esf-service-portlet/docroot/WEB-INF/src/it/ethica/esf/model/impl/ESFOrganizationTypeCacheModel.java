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

import it.ethica.esf.model.ESFOrganizationType;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ESFOrganizationType in entity cache.
 *
 * @author Ethica
 * @see ESFOrganizationType
 * @generated
 */
public class ESFOrganizationTypeCacheModel implements CacheModel<ESFOrganizationType>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{esfOrganizationTypeId=");
		sb.append(esfOrganizationTypeId);
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
		sb.append(", esfOrganizationId=");
		sb.append(esfOrganizationId);
		sb.append(", esfTypeId=");
		sb.append(esfTypeId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ESFOrganizationType toEntityModel() {
		ESFOrganizationTypeImpl esfOrganizationTypeImpl = new ESFOrganizationTypeImpl();

		esfOrganizationTypeImpl.setEsfOrganizationTypeId(esfOrganizationTypeId);
		esfOrganizationTypeImpl.setGroupId(groupId);
		esfOrganizationTypeImpl.setCompanyId(companyId);
		esfOrganizationTypeImpl.setUserId(userId);

		if (userName == null) {
			esfOrganizationTypeImpl.setUserName(StringPool.BLANK);
		}
		else {
			esfOrganizationTypeImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			esfOrganizationTypeImpl.setCreateDate(null);
		}
		else {
			esfOrganizationTypeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			esfOrganizationTypeImpl.setModifiedDate(null);
		}
		else {
			esfOrganizationTypeImpl.setModifiedDate(new Date(modifiedDate));
		}

		esfOrganizationTypeImpl.setEsfOrganizationId(esfOrganizationId);
		esfOrganizationTypeImpl.setEsfTypeId(esfTypeId);

		esfOrganizationTypeImpl.resetOriginalValues();

		return esfOrganizationTypeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		esfOrganizationTypeId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		esfOrganizationId = objectInput.readLong();
		esfTypeId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(esfOrganizationTypeId);
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
		objectOutput.writeLong(esfOrganizationId);
		objectOutput.writeLong(esfTypeId);
	}

	public long esfOrganizationTypeId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long esfOrganizationId;
	public long esfTypeId;
}