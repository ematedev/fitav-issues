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

import it.ethica.esf.model.ESFStateAssEntity;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ESFStateAssEntity in entity cache.
 *
 * @author Ethica
 * @see ESFStateAssEntity
 * @generated
 */
public class ESFStateAssEntityCacheModel implements CacheModel<ESFStateAssEntity>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", esfStateId=");
		sb.append(esfStateId);
		sb.append(", className=");
		sb.append(className);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ESFStateAssEntity toEntityModel() {
		ESFStateAssEntityImpl esfStateAssEntityImpl = new ESFStateAssEntityImpl();

		if (uuid == null) {
			esfStateAssEntityImpl.setUuid(StringPool.BLANK);
		}
		else {
			esfStateAssEntityImpl.setUuid(uuid);
		}

		esfStateAssEntityImpl.setEsfStateId(esfStateId);

		if (className == null) {
			esfStateAssEntityImpl.setClassName(StringPool.BLANK);
		}
		else {
			esfStateAssEntityImpl.setClassName(className);
		}

		esfStateAssEntityImpl.resetOriginalValues();

		return esfStateAssEntityImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		esfStateId = objectInput.readLong();
		className = objectInput.readUTF();
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

		objectOutput.writeLong(esfStateId);

		if (className == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(className);
		}
	}

	public String uuid;
	public long esfStateId;
	public String className;
}