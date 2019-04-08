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

import it.ethica.esf.model.ESFgunUser;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ESFgunUser in entity cache.
 *
 * @author Ethica
 * @see ESFgunUser
 * @generated
 */
public class ESFgunUserCacheModel implements CacheModel<ESFgunUser>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{esfGunUserId=");
		sb.append(esfGunUserId);
		sb.append(", esfGunId=");
		sb.append(esfGunId);
		sb.append(", esfUserId=");
		sb.append(esfUserId);
		sb.append(", code=");
		sb.append(code);
		sb.append(", isFavorite=");
		sb.append(isFavorite);
		sb.append(", type=");
		sb.append(type);
		sb.append(", note=");
		sb.append(note);
		sb.append(", esfGunnTypeId=");
		sb.append(esfGunnTypeId);
		sb.append(", esfGunKindId=");
		sb.append(esfGunKindId);
		sb.append(", typeId=");
		sb.append(typeId);
		sb.append(", esfMeasures=");
		sb.append(esfMeasures);
		sb.append(", esfCaliber=");
		sb.append(esfCaliber);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ESFgunUser toEntityModel() {
		ESFgunUserImpl esFgunUserImpl = new ESFgunUserImpl();

		esFgunUserImpl.setEsfGunUserId(esfGunUserId);
		esFgunUserImpl.setEsfGunId(esfGunId);
		esFgunUserImpl.setEsfUserId(esfUserId);

		if (code == null) {
			esFgunUserImpl.setCode(StringPool.BLANK);
		}
		else {
			esFgunUserImpl.setCode(code);
		}

		esFgunUserImpl.setIsFavorite(isFavorite);
		esFgunUserImpl.setType(type);

		if (note == null) {
			esFgunUserImpl.setNote(StringPool.BLANK);
		}
		else {
			esFgunUserImpl.setNote(note);
		}

		esFgunUserImpl.setEsfGunnTypeId(esfGunnTypeId);
		esFgunUserImpl.setEsfGunKindId(esfGunKindId);
		esFgunUserImpl.setTypeId(typeId);

		if (esfMeasures == null) {
			esFgunUserImpl.setEsfMeasures(StringPool.BLANK);
		}
		else {
			esFgunUserImpl.setEsfMeasures(esfMeasures);
		}

		if (esfCaliber == null) {
			esFgunUserImpl.setEsfCaliber(StringPool.BLANK);
		}
		else {
			esFgunUserImpl.setEsfCaliber(esfCaliber);
		}

		esFgunUserImpl.resetOriginalValues();

		return esFgunUserImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		esfGunUserId = objectInput.readLong();
		esfGunId = objectInput.readLong();
		esfUserId = objectInput.readLong();
		code = objectInput.readUTF();
		isFavorite = objectInput.readBoolean();
		type = objectInput.readInt();
		note = objectInput.readUTF();
		esfGunnTypeId = objectInput.readLong();
		esfGunKindId = objectInput.readLong();
		typeId = objectInput.readLong();
		esfMeasures = objectInput.readUTF();
		esfCaliber = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(esfGunUserId);
		objectOutput.writeLong(esfGunId);
		objectOutput.writeLong(esfUserId);

		if (code == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(code);
		}

		objectOutput.writeBoolean(isFavorite);
		objectOutput.writeInt(type);

		if (note == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(note);
		}

		objectOutput.writeLong(esfGunnTypeId);
		objectOutput.writeLong(esfGunKindId);
		objectOutput.writeLong(typeId);

		if (esfMeasures == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(esfMeasures);
		}

		if (esfCaliber == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(esfCaliber);
		}
	}

	public long esfGunUserId;
	public long esfGunId;
	public long esfUserId;
	public String code;
	public boolean isFavorite;
	public int type;
	public String note;
	public long esfGunnTypeId;
	public long esfGunKindId;
	public long typeId;
	public String esfMeasures;
	public String esfCaliber;
}