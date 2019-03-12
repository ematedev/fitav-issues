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

import it.ethica.esf.model.ESFCard;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ESFCard in entity cache.
 *
 * @author Ethica
 * @see ESFCard
 * @generated
 */
public class ESFCardCacheModel implements CacheModel<ESFCard>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", esfCardId=");
		sb.append(esfCardId);
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
		sb.append(", codeAlfa=");
		sb.append(codeAlfa);
		sb.append(", codeNum=");
		sb.append(codeNum);
		sb.append(", esfUserId=");
		sb.append(esfUserId);
		sb.append(", esfOrganizationId=");
		sb.append(esfOrganizationId);
		sb.append(", temporary=");
		sb.append(temporary);
		sb.append(", code=");
		sb.append(code);
		sb.append(", oldCode=");
		sb.append(oldCode);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ESFCard toEntityModel() {
		ESFCardImpl esfCardImpl = new ESFCardImpl();

		if (uuid == null) {
			esfCardImpl.setUuid(StringPool.BLANK);
		}
		else {
			esfCardImpl.setUuid(uuid);
		}

		esfCardImpl.setEsfCardId(esfCardId);
		esfCardImpl.setGroupId(groupId);
		esfCardImpl.setCompanyId(companyId);
		esfCardImpl.setUserId(userId);

		if (userName == null) {
			esfCardImpl.setUserName(StringPool.BLANK);
		}
		else {
			esfCardImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			esfCardImpl.setCreateDate(null);
		}
		else {
			esfCardImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			esfCardImpl.setModifiedDate(null);
		}
		else {
			esfCardImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (codeAlfa == null) {
			esfCardImpl.setCodeAlfa(StringPool.BLANK);
		}
		else {
			esfCardImpl.setCodeAlfa(codeAlfa);
		}

		esfCardImpl.setCodeNum(codeNum);
		esfCardImpl.setEsfUserId(esfUserId);
		esfCardImpl.setEsfOrganizationId(esfOrganizationId);

		if (temporary == null) {
			esfCardImpl.setTemporary(StringPool.BLANK);
		}
		else {
			esfCardImpl.setTemporary(temporary);
		}

		if (code == null) {
			esfCardImpl.setCode(StringPool.BLANK);
		}
		else {
			esfCardImpl.setCode(code);
		}

		if (oldCode == null) {
			esfCardImpl.setOldCode(StringPool.BLANK);
		}
		else {
			esfCardImpl.setOldCode(oldCode);
		}

		esfCardImpl.resetOriginalValues();

		return esfCardImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		esfCardId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		codeAlfa = objectInput.readUTF();
		codeNum = objectInput.readLong();
		esfUserId = objectInput.readLong();
		esfOrganizationId = objectInput.readLong();
		temporary = objectInput.readUTF();
		code = objectInput.readUTF();
		oldCode = objectInput.readUTF();
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

		objectOutput.writeLong(esfCardId);
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

		if (codeAlfa == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(codeAlfa);
		}

		objectOutput.writeLong(codeNum);
		objectOutput.writeLong(esfUserId);
		objectOutput.writeLong(esfOrganizationId);

		if (temporary == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(temporary);
		}

		if (code == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(code);
		}

		if (oldCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(oldCode);
		}
	}

	public String uuid;
	public long esfCardId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String codeAlfa;
	public long codeNum;
	public long esfUserId;
	public long esfOrganizationId;
	public String temporary;
	public String code;
	public String oldCode;
}