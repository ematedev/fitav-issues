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

import it.ethica.esf.model.ESFToolRel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ESFToolRel in entity cache.
 *
 * @author Ethica
 * @see ESFToolRel
 * @generated
 */
public class ESFToolRelCacheModel implements CacheModel<ESFToolRel>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{uuid=");
		sb.append(uuid);
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
		sb.append(", assignmentDate=");
		sb.append(assignmentDate);
		sb.append(", esfToolId=");
		sb.append(esfToolId);
		sb.append(", className=");
		sb.append(className);
		sb.append(", classPK=");
		sb.append(classPK);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ESFToolRel toEntityModel() {
		ESFToolRelImpl esfToolRelImpl = new ESFToolRelImpl();

		if (uuid == null) {
			esfToolRelImpl.setUuid(StringPool.BLANK);
		}
		else {
			esfToolRelImpl.setUuid(uuid);
		}

		esfToolRelImpl.setGroupId(groupId);
		esfToolRelImpl.setCompanyId(companyId);
		esfToolRelImpl.setUserId(userId);

		if (userName == null) {
			esfToolRelImpl.setUserName(StringPool.BLANK);
		}
		else {
			esfToolRelImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			esfToolRelImpl.setCreateDate(null);
		}
		else {
			esfToolRelImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			esfToolRelImpl.setModifiedDate(null);
		}
		else {
			esfToolRelImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (assignmentDate == Long.MIN_VALUE) {
			esfToolRelImpl.setAssignmentDate(null);
		}
		else {
			esfToolRelImpl.setAssignmentDate(new Date(assignmentDate));
		}

		esfToolRelImpl.setEsfToolId(esfToolId);

		if (className == null) {
			esfToolRelImpl.setClassName(StringPool.BLANK);
		}
		else {
			esfToolRelImpl.setClassName(className);
		}

		esfToolRelImpl.setClassPK(classPK);

		esfToolRelImpl.resetOriginalValues();

		return esfToolRelImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		assignmentDate = objectInput.readLong();
		esfToolId = objectInput.readLong();
		className = objectInput.readUTF();
		classPK = objectInput.readLong();
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
		objectOutput.writeLong(assignmentDate);
		objectOutput.writeLong(esfToolId);

		if (className == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(className);
		}

		objectOutput.writeLong(classPK);
	}

	public String uuid;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long assignmentDate;
	public long esfToolId;
	public String className;
	public long classPK;
}