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

import it.ethica.esf.model.ESFUserCategory;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ESFUserCategory in entity cache.
 *
 * @author Ethica
 * @see ESFUserCategory
 * @generated
 */
public class ESFUserCategoryCacheModel implements CacheModel<ESFUserCategory>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{esfUserCategoryId=");
		sb.append(esfUserCategoryId);
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
		sb.append(", startDate=");
		sb.append(startDate);
		sb.append(", endDate=");
		sb.append(endDate);
		sb.append(", esfCategoryId=");
		sb.append(esfCategoryId);
		sb.append(", esfSportTypeId=");
		sb.append(esfSportTypeId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ESFUserCategory toEntityModel() {
		ESFUserCategoryImpl esfUserCategoryImpl = new ESFUserCategoryImpl();

		esfUserCategoryImpl.setEsfUserCategoryId(esfUserCategoryId);
		esfUserCategoryImpl.setGroupId(groupId);
		esfUserCategoryImpl.setCompanyId(companyId);
		esfUserCategoryImpl.setUserId(userId);

		if (userName == null) {
			esfUserCategoryImpl.setUserName(StringPool.BLANK);
		}
		else {
			esfUserCategoryImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			esfUserCategoryImpl.setCreateDate(null);
		}
		else {
			esfUserCategoryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			esfUserCategoryImpl.setModifiedDate(null);
		}
		else {
			esfUserCategoryImpl.setModifiedDate(new Date(modifiedDate));
		}

		esfUserCategoryImpl.setEsfUserId(esfUserId);

		if (startDate == Long.MIN_VALUE) {
			esfUserCategoryImpl.setStartDate(null);
		}
		else {
			esfUserCategoryImpl.setStartDate(new Date(startDate));
		}

		if (endDate == Long.MIN_VALUE) {
			esfUserCategoryImpl.setEndDate(null);
		}
		else {
			esfUserCategoryImpl.setEndDate(new Date(endDate));
		}

		esfUserCategoryImpl.setEsfCategoryId(esfCategoryId);
		esfUserCategoryImpl.setEsfSportTypeId(esfSportTypeId);

		esfUserCategoryImpl.resetOriginalValues();

		return esfUserCategoryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		esfUserCategoryId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		esfUserId = objectInput.readLong();
		startDate = objectInput.readLong();
		endDate = objectInput.readLong();
		esfCategoryId = objectInput.readLong();
		esfSportTypeId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(esfUserCategoryId);
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
		objectOutput.writeLong(startDate);
		objectOutput.writeLong(endDate);
		objectOutput.writeLong(esfCategoryId);
		objectOutput.writeLong(esfSportTypeId);
	}

	public long esfUserCategoryId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long esfUserId;
	public long startDate;
	public long endDate;
	public long esfCategoryId;
	public long esfSportTypeId;
}