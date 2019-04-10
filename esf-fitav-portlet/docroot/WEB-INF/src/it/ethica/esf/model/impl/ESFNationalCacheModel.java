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

import it.ethica.esf.model.ESFNational;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ESFNational in entity cache.
 *
 * @author Ethica
 * @see ESFNational
 * @generated
 */
public class ESFNationalCacheModel implements CacheModel<ESFNational>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(35);

		sb.append("{esfNationalId=");
		sb.append(esfNationalId);
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
		sb.append(", esfSportTypeId=");
		sb.append(esfSportTypeId);
		sb.append(", startDate=");
		sb.append(startDate);
		sb.append(", endDate=");
		sb.append(endDate);
		sb.append(", BDODate=");
		sb.append(BDODate);
		sb.append(", idInternational=");
		sb.append(idInternational);
		sb.append(", isUniversity=");
		sb.append(isUniversity);
		sb.append(", isNational=");
		sb.append(isNational);
		sb.append(", deliberate=");
		sb.append(deliberate);
		sb.append(", deliberateDate=");
		sb.append(deliberateDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ESFNational toEntityModel() {
		ESFNationalImpl esfNationalImpl = new ESFNationalImpl();

		esfNationalImpl.setEsfNationalId(esfNationalId);
		esfNationalImpl.setGroupId(groupId);
		esfNationalImpl.setCompanyId(companyId);
		esfNationalImpl.setUserId(userId);

		if (userName == null) {
			esfNationalImpl.setUserName(StringPool.BLANK);
		}
		else {
			esfNationalImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			esfNationalImpl.setCreateDate(null);
		}
		else {
			esfNationalImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			esfNationalImpl.setModifiedDate(null);
		}
		else {
			esfNationalImpl.setModifiedDate(new Date(modifiedDate));
		}

		esfNationalImpl.setEsfUserId(esfUserId);
		esfNationalImpl.setEsfSportTypeId(esfSportTypeId);

		if (startDate == Long.MIN_VALUE) {
			esfNationalImpl.setStartDate(null);
		}
		else {
			esfNationalImpl.setStartDate(new Date(startDate));
		}

		if (endDate == Long.MIN_VALUE) {
			esfNationalImpl.setEndDate(null);
		}
		else {
			esfNationalImpl.setEndDate(new Date(endDate));
		}

		if (BDODate == Long.MIN_VALUE) {
			esfNationalImpl.setBDODate(null);
		}
		else {
			esfNationalImpl.setBDODate(new Date(BDODate));
		}

		if (idInternational == null) {
			esfNationalImpl.setIdInternational(StringPool.BLANK);
		}
		else {
			esfNationalImpl.setIdInternational(idInternational);
		}

		esfNationalImpl.setIsUniversity(isUniversity);
		esfNationalImpl.setIsNational(isNational);

		if (deliberate == null) {
			esfNationalImpl.setDeliberate(StringPool.BLANK);
		}
		else {
			esfNationalImpl.setDeliberate(deliberate);
		}

		if (deliberateDate == Long.MIN_VALUE) {
			esfNationalImpl.setDeliberateDate(null);
		}
		else {
			esfNationalImpl.setDeliberateDate(new Date(deliberateDate));
		}

		esfNationalImpl.resetOriginalValues();

		return esfNationalImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		esfNationalId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		esfUserId = objectInput.readLong();
		esfSportTypeId = objectInput.readLong();
		startDate = objectInput.readLong();
		endDate = objectInput.readLong();
		BDODate = objectInput.readLong();
		idInternational = objectInput.readUTF();
		isUniversity = objectInput.readBoolean();
		isNational = objectInput.readBoolean();
		deliberate = objectInput.readUTF();
		deliberateDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(esfNationalId);
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
		objectOutput.writeLong(esfSportTypeId);
		objectOutput.writeLong(startDate);
		objectOutput.writeLong(endDate);
		objectOutput.writeLong(BDODate);

		if (idInternational == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(idInternational);
		}

		objectOutput.writeBoolean(isUniversity);
		objectOutput.writeBoolean(isNational);

		if (deliberate == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(deliberate);
		}

		objectOutput.writeLong(deliberateDate);
	}

	public long esfNationalId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long esfUserId;
	public long esfSportTypeId;
	public long startDate;
	public long endDate;
	public long BDODate;
	public String idInternational;
	public boolean isUniversity;
	public boolean isNational;
	public String deliberate;
	public long deliberateDate;
}