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

import it.ethica.esf.model.ESFEventType;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ESFEventType in entity cache.
 *
 * @author Ethica
 * @see ESFEventType
 * @generated
 */
public class ESFEventTypeCacheModel implements CacheModel<ESFEventType>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{esfEventTypeId=");
		sb.append(esfEventTypeId);
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
		sb.append(", macrocategory=");
		sb.append(macrocategory);
		sb.append(", eventType=");
		sb.append(eventType);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ESFEventType toEntityModel() {
		ESFEventTypeImpl esfEventTypeImpl = new ESFEventTypeImpl();

		esfEventTypeImpl.setEsfEventTypeId(esfEventTypeId);
		esfEventTypeImpl.setGroupId(groupId);
		esfEventTypeImpl.setCompanyId(companyId);
		esfEventTypeImpl.setUserId(userId);

		if (userName == null) {
			esfEventTypeImpl.setUserName(StringPool.BLANK);
		}
		else {
			esfEventTypeImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			esfEventTypeImpl.setCreateDate(null);
		}
		else {
			esfEventTypeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			esfEventTypeImpl.setModifiedDate(null);
		}
		else {
			esfEventTypeImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (macrocategory == null) {
			esfEventTypeImpl.setMacrocategory(StringPool.BLANK);
		}
		else {
			esfEventTypeImpl.setMacrocategory(macrocategory);
		}

		if (eventType == null) {
			esfEventTypeImpl.setEventType(StringPool.BLANK);
		}
		else {
			esfEventTypeImpl.setEventType(eventType);
		}

		esfEventTypeImpl.resetOriginalValues();

		return esfEventTypeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		esfEventTypeId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		macrocategory = objectInput.readUTF();
		eventType = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(esfEventTypeId);
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

		if (macrocategory == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(macrocategory);
		}

		if (eventType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(eventType);
		}
	}

	public long esfEventTypeId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String macrocategory;
	public String eventType;
}