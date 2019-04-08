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

import it.ethica.esf.model.ESFUserESFFederalRole;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ESFUserESFFederalRole in entity cache.
 *
 * @author Ethica
 * @see ESFUserESFFederalRole
 * @generated
 */
public class ESFUserESFFederalRoleCacheModel implements CacheModel<ESFUserESFFederalRole>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{esfUserId=");
		sb.append(esfUserId);
		sb.append(", esfFederalRoleId=");
		sb.append(esfFederalRoleId);
		sb.append(", startDate=");
		sb.append(startDate);
		sb.append(", endDate=");
		sb.append(endDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", active=");
		sb.append(active);
		sb.append(", esfSpecificId=");
		sb.append(esfSpecificId);
		sb.append(", regionId=");
		sb.append(regionId);
		sb.append(", provinceId=");
		sb.append(provinceId);
		sb.append(", notes=");
		sb.append(notes);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ESFUserESFFederalRole toEntityModel() {
		ESFUserESFFederalRoleImpl esfUserESFFederalRoleImpl = new ESFUserESFFederalRoleImpl();

		esfUserESFFederalRoleImpl.setEsfUserId(esfUserId);
		esfUserESFFederalRoleImpl.setEsfFederalRoleId(esfFederalRoleId);
		esfUserESFFederalRoleImpl.setStartDate(startDate);

		if (endDate == Long.MIN_VALUE) {
			esfUserESFFederalRoleImpl.setEndDate(null);
		}
		else {
			esfUserESFFederalRoleImpl.setEndDate(new Date(endDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			esfUserESFFederalRoleImpl.setModifiedDate(null);
		}
		else {
			esfUserESFFederalRoleImpl.setModifiedDate(new Date(modifiedDate));
		}

		esfUserESFFederalRoleImpl.setActive(active);
		esfUserESFFederalRoleImpl.setEsfSpecificId(esfSpecificId);

		if (regionId == null) {
			esfUserESFFederalRoleImpl.setRegionId(StringPool.BLANK);
		}
		else {
			esfUserESFFederalRoleImpl.setRegionId(regionId);
		}

		if (provinceId == null) {
			esfUserESFFederalRoleImpl.setProvinceId(StringPool.BLANK);
		}
		else {
			esfUserESFFederalRoleImpl.setProvinceId(provinceId);
		}

		if (notes == null) {
			esfUserESFFederalRoleImpl.setNotes(StringPool.BLANK);
		}
		else {
			esfUserESFFederalRoleImpl.setNotes(notes);
		}

		esfUserESFFederalRoleImpl.resetOriginalValues();

		return esfUserESFFederalRoleImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		esfUserId = objectInput.readLong();
		esfFederalRoleId = objectInput.readLong();
		startDate = objectInput.readLong();
		endDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		active = objectInput.readBoolean();
		esfSpecificId = objectInput.readLong();
		regionId = objectInput.readUTF();
		provinceId = objectInput.readUTF();
		notes = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(esfUserId);
		objectOutput.writeLong(esfFederalRoleId);
		objectOutput.writeLong(startDate);
		objectOutput.writeLong(endDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeBoolean(active);
		objectOutput.writeLong(esfSpecificId);

		if (regionId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(regionId);
		}

		if (provinceId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(provinceId);
		}

		if (notes == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(notes);
		}
	}

	public long esfUserId;
	public long esfFederalRoleId;
	public long startDate;
	public long endDate;
	public long modifiedDate;
	public boolean active;
	public long esfSpecificId;
	public String regionId;
	public String provinceId;
	public String notes;
}