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

import it.ethica.esf.model.ESFUser;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ESFUser in entity cache.
 *
 * @author Ethica
 * @see ESFUser
 * @generated
 */
public class ESFUserCacheModel implements CacheModel<ESFUser>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", esfUserId=");
		sb.append(esfUserId);
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
		sb.append(", portalUserId=");
		sb.append(portalUserId);
		sb.append(", code=");
		sb.append(code);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ESFUser toEntityModel() {
		ESFUserImpl esfUserImpl = new ESFUserImpl();

		if (uuid == null) {
			esfUserImpl.setUuid(StringPool.BLANK);
		}
		else {
			esfUserImpl.setUuid(uuid);
		}

		esfUserImpl.setEsfUserId(esfUserId);
		esfUserImpl.setGroupId(groupId);
		esfUserImpl.setCompanyId(companyId);
		esfUserImpl.setUserId(userId);

		if (userName == null) {
			esfUserImpl.setUserName(StringPool.BLANK);
		}
		else {
			esfUserImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			esfUserImpl.setCreateDate(null);
		}
		else {
			esfUserImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			esfUserImpl.setModifiedDate(null);
		}
		else {
			esfUserImpl.setModifiedDate(new Date(modifiedDate));
		}

		esfUserImpl.setPortalUserId(portalUserId);

		if (code == null) {
			esfUserImpl.setCode(StringPool.BLANK);
		}
		else {
			esfUserImpl.setCode(code);
		}

		esfUserImpl.resetOriginalValues();

		return esfUserImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		esfUserId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		portalUserId = objectInput.readLong();
		code = objectInput.readUTF();
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

		objectOutput.writeLong(esfUserId);
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
		objectOutput.writeLong(portalUserId);

		if (code == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(code);
		}
	}

	public String uuid;
	public long esfUserId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long portalUserId;
	public String code;
}