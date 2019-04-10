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

import it.ethica.esf.model.ESFFornitureRel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ESFFornitureRel in entity cache.
 *
 * @author Ethica
 * @see ESFFornitureRel
 * @generated
 */
public class ESFFornitureRelCacheModel implements CacheModel<ESFFornitureRel>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{esfToolId=");
		sb.append(esfToolId);
		sb.append(", className=");
		sb.append(className);
		sb.append(", classPK=");
		sb.append(classPK);
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
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ESFFornitureRel toEntityModel() {
		ESFFornitureRelImpl esfFornitureRelImpl = new ESFFornitureRelImpl();

		esfFornitureRelImpl.setEsfToolId(esfToolId);

		if (className == null) {
			esfFornitureRelImpl.setClassName(StringPool.BLANK);
		}
		else {
			esfFornitureRelImpl.setClassName(className);
		}

		esfFornitureRelImpl.setClassPK(classPK);
		esfFornitureRelImpl.setGroupId(groupId);
		esfFornitureRelImpl.setCompanyId(companyId);
		esfFornitureRelImpl.setUserId(userId);

		if (userName == null) {
			esfFornitureRelImpl.setUserName(StringPool.BLANK);
		}
		else {
			esfFornitureRelImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			esfFornitureRelImpl.setCreateDate(null);
		}
		else {
			esfFornitureRelImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			esfFornitureRelImpl.setModifiedDate(null);
		}
		else {
			esfFornitureRelImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (assignmentDate == Long.MIN_VALUE) {
			esfFornitureRelImpl.setAssignmentDate(null);
		}
		else {
			esfFornitureRelImpl.setAssignmentDate(new Date(assignmentDate));
		}

		esfFornitureRelImpl.resetOriginalValues();

		return esfFornitureRelImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		esfToolId = objectInput.readLong();
		className = objectInput.readUTF();
		classPK = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		assignmentDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(esfToolId);

		if (className == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(className);
		}

		objectOutput.writeLong(classPK);
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
	}

	public long esfToolId;
	public String className;
	public long classPK;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long assignmentDate;
}