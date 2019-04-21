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

import it.ethica.esf.model.ESFPartecipantType;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ESFPartecipantType in entity cache.
 *
 * @author Ethica
 * @see ESFPartecipantType
 * @generated
 */
public class ESFPartecipantTypeCacheModel implements CacheModel<ESFPartecipantType>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", esfPartecipantTypeId=");
		sb.append(esfPartecipantTypeId);
		sb.append(", name=");
		sb.append(name);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ESFPartecipantType toEntityModel() {
		ESFPartecipantTypeImpl esfPartecipantTypeImpl = new ESFPartecipantTypeImpl();

		if (uuid == null) {
			esfPartecipantTypeImpl.setUuid(StringPool.BLANK);
		}
		else {
			esfPartecipantTypeImpl.setUuid(uuid);
		}

		esfPartecipantTypeImpl.setEsfPartecipantTypeId(esfPartecipantTypeId);

		if (name == null) {
			esfPartecipantTypeImpl.setName(StringPool.BLANK);
		}
		else {
			esfPartecipantTypeImpl.setName(name);
		}

		esfPartecipantTypeImpl.resetOriginalValues();

		return esfPartecipantTypeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		esfPartecipantTypeId = objectInput.readLong();
		name = objectInput.readUTF();
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

		objectOutput.writeLong(esfPartecipantTypeId);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}
	}

	public String uuid;
	public long esfPartecipantTypeId;
	public String name;
}