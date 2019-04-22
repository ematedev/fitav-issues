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

import it.ethica.esf.model.ESFDocumentType;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ESFDocumentType in entity cache.
 *
 * @author Ethica
 * @see ESFDocumentType
 * @generated
 */
public class ESFDocumentTypeCacheModel implements CacheModel<ESFDocumentType>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{esfDocumentTypeId=");
		sb.append(esfDocumentTypeId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", description=");
		sb.append(description);
		sb.append(", expirationMonthsNotice=");
		sb.append(expirationMonthsNotice);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ESFDocumentType toEntityModel() {
		ESFDocumentTypeImpl esfDocumentTypeImpl = new ESFDocumentTypeImpl();

		esfDocumentTypeImpl.setEsfDocumentTypeId(esfDocumentTypeId);

		if (createDate == Long.MIN_VALUE) {
			esfDocumentTypeImpl.setCreateDate(null);
		}
		else {
			esfDocumentTypeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			esfDocumentTypeImpl.setModifiedDate(null);
		}
		else {
			esfDocumentTypeImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (description == null) {
			esfDocumentTypeImpl.setDescription(StringPool.BLANK);
		}
		else {
			esfDocumentTypeImpl.setDescription(description);
		}

		esfDocumentTypeImpl.setExpirationMonthsNotice(expirationMonthsNotice);

		esfDocumentTypeImpl.resetOriginalValues();

		return esfDocumentTypeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		esfDocumentTypeId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		description = objectInput.readUTF();
		expirationMonthsNotice = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(esfDocumentTypeId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeInt(expirationMonthsNotice);
	}

	public long esfDocumentTypeId;
	public long createDate;
	public long modifiedDate;
	public String description;
	public int expirationMonthsNotice;
}