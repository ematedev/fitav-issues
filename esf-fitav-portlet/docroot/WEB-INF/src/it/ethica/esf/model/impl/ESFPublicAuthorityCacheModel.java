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

import it.ethica.esf.model.ESFPublicAuthority;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ESFPublicAuthority in entity cache.
 *
 * @author Ethica
 * @see ESFPublicAuthority
 * @generated
 */
public class ESFPublicAuthorityCacheModel implements CacheModel<ESFPublicAuthority>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{esfPublicAuthorityId=");
		sb.append(esfPublicAuthorityId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", description=");
		sb.append(description);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ESFPublicAuthority toEntityModel() {
		ESFPublicAuthorityImpl esfPublicAuthorityImpl = new ESFPublicAuthorityImpl();

		esfPublicAuthorityImpl.setEsfPublicAuthorityId(esfPublicAuthorityId);

		if (createDate == Long.MIN_VALUE) {
			esfPublicAuthorityImpl.setCreateDate(null);
		}
		else {
			esfPublicAuthorityImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			esfPublicAuthorityImpl.setModifiedDate(null);
		}
		else {
			esfPublicAuthorityImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (description == null) {
			esfPublicAuthorityImpl.setDescription(StringPool.BLANK);
		}
		else {
			esfPublicAuthorityImpl.setDescription(description);
		}

		esfPublicAuthorityImpl.resetOriginalValues();

		return esfPublicAuthorityImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		esfPublicAuthorityId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		description = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(esfPublicAuthorityId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}
	}

	public long esfPublicAuthorityId;
	public long createDate;
	public long modifiedDate;
	public String description;
}