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

import it.ethica.esf.model.ESFField;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ESFField in entity cache.
 *
 * @author Ethica
 * @see ESFField
 * @generated
 */
public class ESFFieldCacheModel implements CacheModel<ESFField>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(37);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", esfFieldId=");
		sb.append(esfFieldId);
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
		sb.append(", name=");
		sb.append(name);
		sb.append(", ownerOrganizationId=");
		sb.append(ownerOrganizationId);
		sb.append(", esfAddressId=");
		sb.append(esfAddressId);
		sb.append(", billboard=");
		sb.append(billboard);
		sb.append(", billboardStations=");
		sb.append(billboardStations);
		sb.append(", backgroundRampart=");
		sb.append(backgroundRampart);
		sb.append(", backgroundNet=");
		sb.append(backgroundNet);
		sb.append(", backgroundLeadRecovery=");
		sb.append(backgroundLeadRecovery);
		sb.append(", disabledAccess=");
		sb.append(disabledAccess);
		sb.append(", note=");
		sb.append(note);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ESFField toEntityModel() {
		ESFFieldImpl esfFieldImpl = new ESFFieldImpl();

		if (uuid == null) {
			esfFieldImpl.setUuid(StringPool.BLANK);
		}
		else {
			esfFieldImpl.setUuid(uuid);
		}

		esfFieldImpl.setEsfFieldId(esfFieldId);
		esfFieldImpl.setGroupId(groupId);
		esfFieldImpl.setCompanyId(companyId);
		esfFieldImpl.setUserId(userId);

		if (userName == null) {
			esfFieldImpl.setUserName(StringPool.BLANK);
		}
		else {
			esfFieldImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			esfFieldImpl.setCreateDate(null);
		}
		else {
			esfFieldImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			esfFieldImpl.setModifiedDate(null);
		}
		else {
			esfFieldImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			esfFieldImpl.setName(StringPool.BLANK);
		}
		else {
			esfFieldImpl.setName(name);
		}

		esfFieldImpl.setOwnerOrganizationId(ownerOrganizationId);
		esfFieldImpl.setEsfAddressId(esfAddressId);
		esfFieldImpl.setBillboard(billboard);
		esfFieldImpl.setBillboardStations(billboardStations);
		esfFieldImpl.setBackgroundRampart(backgroundRampart);
		esfFieldImpl.setBackgroundNet(backgroundNet);
		esfFieldImpl.setBackgroundLeadRecovery(backgroundLeadRecovery);
		esfFieldImpl.setDisabledAccess(disabledAccess);

		if (note == null) {
			esfFieldImpl.setNote(StringPool.BLANK);
		}
		else {
			esfFieldImpl.setNote(note);
		}

		esfFieldImpl.resetOriginalValues();

		return esfFieldImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		esfFieldId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		name = objectInput.readUTF();
		ownerOrganizationId = objectInput.readLong();
		esfAddressId = objectInput.readLong();
		billboard = objectInput.readLong();
		billboardStations = objectInput.readBoolean();
		backgroundRampart = objectInput.readBoolean();
		backgroundNet = objectInput.readBoolean();
		backgroundLeadRecovery = objectInput.readBoolean();
		disabledAccess = objectInput.readBoolean();
		note = objectInput.readUTF();
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

		objectOutput.writeLong(esfFieldId);
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

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeLong(ownerOrganizationId);
		objectOutput.writeLong(esfAddressId);
		objectOutput.writeLong(billboard);
		objectOutput.writeBoolean(billboardStations);
		objectOutput.writeBoolean(backgroundRampart);
		objectOutput.writeBoolean(backgroundNet);
		objectOutput.writeBoolean(backgroundLeadRecovery);
		objectOutput.writeBoolean(disabledAccess);

		if (note == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(note);
		}
	}

	public String uuid;
	public long esfFieldId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String name;
	public long ownerOrganizationId;
	public long esfAddressId;
	public long billboard;
	public boolean billboardStations;
	public boolean backgroundRampart;
	public boolean backgroundNet;
	public boolean backgroundLeadRecovery;
	public boolean disabledAccess;
	public String note;
}