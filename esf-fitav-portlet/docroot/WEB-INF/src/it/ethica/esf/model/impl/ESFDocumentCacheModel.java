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
		StringBundler sb = new StringBundler(29);

		sb.append("{esfDocumentId=");
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
		sb.append(", code=");
		sb.append(code);
		sb.append(", releasedBy=");
		sb.append(releasedBy);
		sb.append(", releaseDate=");
		sb.append(releaseDate);
		sb.append(", expirationDate=");
		sb.append(expirationDate);
		sb.append(", esfUserId=");
		sb.append(esfUserId);
		sb.append(", type=");
		sb.append(type);
		sb.append(", path=");
		sb.append(path);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ESFDocument toEntityModel() {
		ESFDocumentImpl esfDocumentImpl = new ESFDocumentImpl();

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

		if (code == null) {
			esfDocumentImpl.setCode(StringPool.BLANK);
		}
		else {
			esfDocumentImpl.setCode(code);
		}

		if (releasedBy == null) {
			esfDocumentImpl.setReleasedBy(StringPool.BLANK);
		}
		else {
			esfDocumentImpl.setReleasedBy(releasedBy);
		}

		if (releaseDate == Long.MIN_VALUE) {
			esfDocumentImpl.setReleaseDate(null);
		}
		else {
			esfDocumentImpl.setReleaseDate(new Date(releaseDate));
		}

		if (expirationDate == Long.MIN_VALUE) {
			esfDocumentImpl.setExpirationDate(null);
		}
		else {
			esfDocumentImpl.setExpirationDate(new Date(expirationDate));
		}

		esfDocumentImpl.setEsfUserId(esfUserId);

		if (type == null) {
			esfDocumentImpl.setType(StringPool.BLANK);
		}
		else {
			esfDocumentImpl.setType(type);
		}

		if (path == null) {
			esfDocumentImpl.setPath(StringPool.BLANK);
		}
		else {
			esfDocumentImpl.setPath(path);
		}

		esfDocumentImpl.resetOriginalValues();

		return esfDocumentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		esfDocumentId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		code = objectInput.readUTF();
		releasedBy = objectInput.readUTF();
		releaseDate = objectInput.readLong();
		expirationDate = objectInput.readLong();
		esfUserId = objectInput.readLong();
		type = objectInput.readUTF();
		path = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
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

		if (code == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(code);
		}

		if (releasedBy == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(releasedBy);
		}

		objectOutput.writeLong(releaseDate);
		objectOutput.writeLong(expirationDate);
		objectOutput.writeLong(esfUserId);

		if (type == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(type);
		}

		if (path == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(path);
		}
	}

	public long esfDocumentId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String code;
	public String releasedBy;
	public long releaseDate;
	public long expirationDate;
	public long esfUserId;
	public String type;
	public String path;
}