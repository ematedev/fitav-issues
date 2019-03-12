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

import it.ethica.esf.model.ESFDocumentType;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ESFDocumentType in entity cache.
 *
 * @author Ethica
 * @see ESFDocumentType
 * @generated
 */
public class ESFDocumentTypeCacheModel implements CacheModel<ESFDocumentType>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{esfDocumentTypeId=");
		sb.append(esfDocumentTypeId);
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
		sb.append(", esfDocumentId=");
		sb.append(esfDocumentId);
		sb.append(", esfTypeId=");
		sb.append(esfTypeId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ESFDocumentType toEntityModel() {
		ESFDocumentTypeImpl esfDocumentTypeImpl = new ESFDocumentTypeImpl();

		esfDocumentTypeImpl.setEsfDocumentTypeId(esfDocumentTypeId);
		esfDocumentTypeImpl.setGroupId(groupId);
		esfDocumentTypeImpl.setCompanyId(companyId);
		esfDocumentTypeImpl.setUserId(userId);

		if (userName == null) {
			esfDocumentTypeImpl.setUserName(StringPool.BLANK);
		}
		else {
			esfDocumentTypeImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			esfDocumentTypeImpl.setCreateDate(null);
		}
		else {
			esfDocumentTypeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			esfDocumentTypeImpl.setModifiedDate(null);
		}
		else {
			esfDocumentTypeImpl.setModifiedDate(new Date(modifiedDate));
		}

		esfDocumentTypeImpl.setEsfDocumentId(esfDocumentId);
		esfDocumentTypeImpl.setEsfTypeId(esfTypeId);

		esfDocumentTypeImpl.resetOriginalValues();

		return esfDocumentTypeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		esfDocumentTypeId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		esfDocumentId = objectInput.readLong();
		esfTypeId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(esfDocumentTypeId);
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
		objectOutput.writeLong(esfDocumentId);
		objectOutput.writeLong(esfTypeId);
	}

	public long esfDocumentTypeId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long esfDocumentId;
	public long esfTypeId;
}