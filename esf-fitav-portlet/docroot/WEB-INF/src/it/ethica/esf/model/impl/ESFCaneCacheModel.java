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

import it.ethica.esf.model.ESFCane;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ESFCane in entity cache.
 *
 * @author Ethica
 * @see ESFCane
 * @generated
 */
public class ESFCaneCacheModel implements CacheModel<ESFCane>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", esfCaneId=");
		sb.append(esfCaneId);
		sb.append(", esfUserId=");
		sb.append(esfUserId);
		sb.append(", code=");
		sb.append(code);
		sb.append(", esfGunKindId=");
		sb.append(esfGunKindId);
		sb.append(", esfOrganizationId=");
		sb.append(esfOrganizationId);
		sb.append(", caneCaliber=");
		sb.append(caneCaliber);
		sb.append(", isFavoriteGun=");
		sb.append(isFavoriteGun);
		sb.append(", typeId=");
		sb.append(typeId);
		sb.append(", measures=");
		sb.append(measures);
		sb.append(", shooterId=");
		sb.append(shooterId);
		sb.append(", esfGunTypeId=");
		sb.append(esfGunTypeId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ESFCane toEntityModel() {
		ESFCaneImpl esfCaneImpl = new ESFCaneImpl();

		if (uuid == null) {
			esfCaneImpl.setUuid(StringPool.BLANK);
		}
		else {
			esfCaneImpl.setUuid(uuid);
		}

		esfCaneImpl.setEsfCaneId(esfCaneId);
		esfCaneImpl.setEsfUserId(esfUserId);

		if (code == null) {
			esfCaneImpl.setCode(StringPool.BLANK);
		}
		else {
			esfCaneImpl.setCode(code);
		}

		esfCaneImpl.setEsfGunKindId(esfGunKindId);
		esfCaneImpl.setEsfOrganizationId(esfOrganizationId);
		esfCaneImpl.setCaneCaliber(caneCaliber);
		esfCaneImpl.setIsFavoriteGun(isFavoriteGun);
		esfCaneImpl.setTypeId(typeId);

		if (measures == null) {
			esfCaneImpl.setMeasures(StringPool.BLANK);
		}
		else {
			esfCaneImpl.setMeasures(measures);
		}

		esfCaneImpl.setShooterId(shooterId);
		esfCaneImpl.setEsfGunTypeId(esfGunTypeId);

		esfCaneImpl.resetOriginalValues();

		return esfCaneImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		esfCaneId = objectInput.readLong();
		esfUserId = objectInput.readLong();
		code = objectInput.readUTF();
		esfGunKindId = objectInput.readLong();
		esfOrganizationId = objectInput.readLong();
		caneCaliber = objectInput.readLong();
		isFavoriteGun = objectInput.readBoolean();
		typeId = objectInput.readInt();
		measures = objectInput.readUTF();
		shooterId = objectInput.readLong();
		esfGunTypeId = objectInput.readLong();
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

		objectOutput.writeLong(esfCaneId);
		objectOutput.writeLong(esfUserId);

		if (code == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(code);
		}

		objectOutput.writeLong(esfGunKindId);
		objectOutput.writeLong(esfOrganizationId);
		objectOutput.writeLong(caneCaliber);
		objectOutput.writeBoolean(isFavoriteGun);
		objectOutput.writeInt(typeId);

		if (measures == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(measures);
		}

		objectOutput.writeLong(shooterId);
		objectOutput.writeLong(esfGunTypeId);
	}

	public String uuid;
	public long esfCaneId;
	public long esfUserId;
	public String code;
	public long esfGunKindId;
	public long esfOrganizationId;
	public long caneCaliber;
	public boolean isFavoriteGun;
	public int typeId;
	public String measures;
	public long shooterId;
	public long esfGunTypeId;
}