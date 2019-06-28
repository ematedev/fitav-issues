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

import it.ethica.esf.model.VW_Staff;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing VW_Staff in entity cache.
 *
 * @author Ethica
 * @see VW_Staff
 * @generated
 */
public class VW_StaffCacheModel implements CacheModel<VW_Staff>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{userId=");
		sb.append(userId);
		sb.append(", emailAddress=");
		sb.append(emailAddress);
		sb.append(", firstName=");
		sb.append(firstName);
		sb.append(", lastName=");
		sb.append(lastName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", esfStartData=");
		sb.append(esfStartData);
		sb.append(", esfEndData=");
		sb.append(esfEndData);
		sb.append(", regionId=");
		sb.append(regionId);
		sb.append(", provinceId=");
		sb.append(provinceId);
		sb.append(", esfShootingDirectorQualificationDesc=");
		sb.append(esfShootingDirectorQualificationDesc);
		sb.append(", esfSportTypeId=");
		sb.append(esfSportTypeId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", invitato=");
		sb.append(invitato);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public VW_Staff toEntityModel() {
		VW_StaffImpl vw_StaffImpl = new VW_StaffImpl();

		vw_StaffImpl.setUserId(userId);

		if (emailAddress == null) {
			vw_StaffImpl.setEmailAddress(StringPool.BLANK);
		}
		else {
			vw_StaffImpl.setEmailAddress(emailAddress);
		}

		if (firstName == null) {
			vw_StaffImpl.setFirstName(StringPool.BLANK);
		}
		else {
			vw_StaffImpl.setFirstName(firstName);
		}

		if (lastName == null) {
			vw_StaffImpl.setLastName(StringPool.BLANK);
		}
		else {
			vw_StaffImpl.setLastName(lastName);
		}

		if (createDate == Long.MIN_VALUE) {
			vw_StaffImpl.setCreateDate(null);
		}
		else {
			vw_StaffImpl.setCreateDate(new Date(createDate));
		}

		if (esfStartData == Long.MIN_VALUE) {
			vw_StaffImpl.setEsfStartData(null);
		}
		else {
			vw_StaffImpl.setEsfStartData(new Date(esfStartData));
		}

		if (esfEndData == Long.MIN_VALUE) {
			vw_StaffImpl.setEsfEndData(null);
		}
		else {
			vw_StaffImpl.setEsfEndData(new Date(esfEndData));
		}

		if (regionId == null) {
			vw_StaffImpl.setRegionId(StringPool.BLANK);
		}
		else {
			vw_StaffImpl.setRegionId(regionId);
		}

		if (provinceId == null) {
			vw_StaffImpl.setProvinceId(StringPool.BLANK);
		}
		else {
			vw_StaffImpl.setProvinceId(provinceId);
		}

		if (esfShootingDirectorQualificationDesc == null) {
			vw_StaffImpl.setEsfShootingDirectorQualificationDesc(StringPool.BLANK);
		}
		else {
			vw_StaffImpl.setEsfShootingDirectorQualificationDesc(esfShootingDirectorQualificationDesc);
		}

		vw_StaffImpl.setEsfSportTypeId(esfSportTypeId);

		if (name == null) {
			vw_StaffImpl.setName(StringPool.BLANK);
		}
		else {
			vw_StaffImpl.setName(name);
		}

		vw_StaffImpl.setInvitato(invitato);

		vw_StaffImpl.resetOriginalValues();

		return vw_StaffImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		userId = objectInput.readLong();
		emailAddress = objectInput.readUTF();
		firstName = objectInput.readUTF();
		lastName = objectInput.readUTF();
		createDate = objectInput.readLong();
		esfStartData = objectInput.readLong();
		esfEndData = objectInput.readLong();
		regionId = objectInput.readUTF();
		provinceId = objectInput.readUTF();
		esfShootingDirectorQualificationDesc = objectInput.readUTF();
		esfSportTypeId = objectInput.readLong();
		name = objectInput.readUTF();
		invitato = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(userId);

		if (emailAddress == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(emailAddress);
		}

		if (firstName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(firstName);
		}

		if (lastName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(lastName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(esfStartData);
		objectOutput.writeLong(esfEndData);

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

		if (esfShootingDirectorQualificationDesc == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(esfShootingDirectorQualificationDesc);
		}

		objectOutput.writeLong(esfSportTypeId);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeLong(invitato);
	}

	public long userId;
	public String emailAddress;
	public String firstName;
	public String lastName;
	public long createDate;
	public long esfStartData;
	public long esfEndData;
	public String regionId;
	public String provinceId;
	public String esfShootingDirectorQualificationDesc;
	public long esfSportTypeId;
	public String name;
	public long invitato;
}