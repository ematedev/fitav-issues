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

import it.ethica.esf.model.ESFCatridge;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ESFCatridge in entity cache.
 *
 * @author Ethica
 * @see ESFCatridge
 * @generated
 */
public class ESFCatridgeCacheModel implements CacheModel<ESFCatridge>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", esfCatridgeId=");
		sb.append(esfCatridgeId);
		sb.append(", esfUserId=");
		sb.append(esfUserId);
		sb.append(", esfGunTypeId=");
		sb.append(esfGunTypeId);
		sb.append(", catridgeModel=");
		sb.append(catridgeModel);
		sb.append(", catridgeCaliber=");
		sb.append(catridgeCaliber);
		sb.append(", note=");
		sb.append(note);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ESFCatridge toEntityModel() {
		ESFCatridgeImpl esfCatridgeImpl = new ESFCatridgeImpl();

		if (uuid == null) {
			esfCatridgeImpl.setUuid(StringPool.BLANK);
		}
		else {
			esfCatridgeImpl.setUuid(uuid);
		}

		esfCatridgeImpl.setEsfCatridgeId(esfCatridgeId);
		esfCatridgeImpl.setEsfUserId(esfUserId);
		esfCatridgeImpl.setEsfGunTypeId(esfGunTypeId);

		if (catridgeModel == null) {
			esfCatridgeImpl.setCatridgeModel(StringPool.BLANK);
		}
		else {
			esfCatridgeImpl.setCatridgeModel(catridgeModel);
		}

		esfCatridgeImpl.setCatridgeCaliber(catridgeCaliber);

		if (note == null) {
			esfCatridgeImpl.setNote(StringPool.BLANK);
		}
		else {
			esfCatridgeImpl.setNote(note);
		}

		esfCatridgeImpl.resetOriginalValues();

		return esfCatridgeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		esfCatridgeId = objectInput.readLong();
		esfUserId = objectInput.readLong();
		esfGunTypeId = objectInput.readLong();
		catridgeModel = objectInput.readUTF();
		catridgeCaliber = objectInput.readLong();
		note = objectInput.readUTF();
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

		objectOutput.writeLong(esfCatridgeId);
		objectOutput.writeLong(esfUserId);
		objectOutput.writeLong(esfGunTypeId);

		if (catridgeModel == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(catridgeModel);
		}

		objectOutput.writeLong(catridgeCaliber);

		if (note == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(note);
		}
	}

	public String uuid;
	public long esfCatridgeId;
	public long esfUserId;
	public long esfGunTypeId;
	public String catridgeModel;
	public long catridgeCaliber;
	public String note;
}