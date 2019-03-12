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

import it.ethica.esf.model.ESFDocument;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ESFDocument in entity cache.
 *
 * @author Ethica
 * @see ESFDocument
 * @generated
 */
public class ESFDocumentCacheModel implements CacheModel<ESFDocument>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(35);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", esfDocumentId=");
		sb.append(esfDocumentId);
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
		sb.append(", ownerId=");
		sb.append(ownerId);
		sb.append(", ownerType=");
		sb.append(ownerType);
		sb.append(", name=");
		sb.append(name);
		sb.append(", number=");
		sb.append(number);
		sb.append(", releaseDate=");
		sb.append(releaseDate);
		sb.append(", expireDate=");
		sb.append(expireDate);
		sb.append(", issuer=");
		sb.append(issuer);
		sb.append(", contents=");
		sb.append(contents);
		sb.append(", locationReference=");
		sb.append(locationReference);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ESFDocument toEntityModel() {
		ESFDocumentImpl esfDocumentImpl = new ESFDocumentImpl();

		if (uuid == null) {
			esfDocumentImpl.setUuid(StringPool.BLANK);
		}
		else {
			esfDocumentImpl.setUuid(uuid);
		}

		esfDocumentImpl.setEsfDocumentId(esfDocumentId);
		esfDocumentImpl.setGroupId(groupId);
		esfDocumentImpl.setCompanyId(companyId);
		esfDocumentImpl.setUserId(userId);

		if (userName == null) {
			esfDocumentImpl.setUserName(StringPool.BLANK);
		}
		else {
			esfDocumentImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			esfDocumentImpl.setCreateDate(null);
		}
		else {
			esfDocumentImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			esfDocumentImpl.setModifiedDate(null);
		}
		else {
			esfDocumentImpl.setModifiedDate(new Date(modifiedDate));
		}

		esfDocumentImpl.setOwnerId(ownerId);

		if (ownerType == null) {
			esfDocumentImpl.setOwnerType(StringPool.BLANK);
		}
		else {
			esfDocumentImpl.setOwnerType(ownerType);
		}

		if (name == null) {
			esfDocumentImpl.setName(StringPool.BLANK);
		}
		else {
			esfDocumentImpl.setName(name);
		}

		esfDocumentImpl.setNumber(number);

		if (releaseDate == Long.MIN_VALUE) {
			esfDocumentImpl.setReleaseDate(null);
		}
		else {
			esfDocumentImpl.setReleaseDate(new Date(releaseDate));
		}

		if (expireDate == Long.MIN_VALUE) {
			esfDocumentImpl.setExpireDate(null);
		}
		else {
			esfDocumentImpl.setExpireDate(new Date(expireDate));
		}

		if (issuer == null) {
			esfDocumentImpl.setIssuer(StringPool.BLANK);
		}
		else {
			esfDocumentImpl.setIssuer(issuer);
		}

		if (contents == null) {
			esfDocumentImpl.setContents(StringPool.BLANK);
		}
		else {
			esfDocumentImpl.setContents(contents);
		}

		if (locationReference == null) {
			esfDocumentImpl.setLocationReference(StringPool.BLANK);
		}
		else {
			esfDocumentImpl.setLocationReference(locationReference);
		}

		esfDocumentImpl.resetOriginalValues();

		return esfDocumentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		esfDocumentId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		ownerId = objectInput.readLong();
		ownerType = objectInput.readUTF();
		name = objectInput.readUTF();
		number = objectInput.readLong();
		releaseDate = objectInput.readLong();
		expireDate = objectInput.readLong();
		issuer = objectInput.readUTF();
		contents = objectInput.readUTF();
		locationReference = objectInput.readUTF();
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

		objectOutput.writeLong(esfDocumentId);
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
		objectOutput.writeLong(ownerId);

		if (ownerType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ownerType);
		}

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeLong(number);
		objectOutput.writeLong(releaseDate);
		objectOutput.writeLong(expireDate);

		if (issuer == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(issuer);
		}

		if (contents == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(contents);
		}

		if (locationReference == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(locationReference);
		}
	}

	public String uuid;
	public long esfDocumentId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long ownerId;
	public String ownerType;
	public String name;
	public long number;
	public long releaseDate;
	public long expireDate;
	public String issuer;
	public String contents;
	public String locationReference;
}