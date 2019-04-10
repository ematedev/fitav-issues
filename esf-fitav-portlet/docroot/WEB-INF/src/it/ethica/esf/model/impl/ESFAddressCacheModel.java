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

import it.ethica.esf.model.ESFAddress;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ESFAddress in entity cache.
 *
 * @author Ethica
 * @see ESFAddress
 * @generated
 */
public class ESFAddressCacheModel implements CacheModel<ESFAddress>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", esfAddressId=");
		sb.append(esfAddressId);
		sb.append(", longitude=");
		sb.append(longitude);
		sb.append(", latitude=");
		sb.append(latitude);
		sb.append(", esfCountryId=");
		sb.append(esfCountryId);
		sb.append(", esfRegionId=");
		sb.append(esfRegionId);
		sb.append(", esfProvinceId=");
		sb.append(esfProvinceId);
		sb.append(", esfCityId=");
		sb.append(esfCityId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", type=");
		sb.append(type);
		sb.append(", isNotNational=");
		sb.append(isNotNational);
		sb.append(", listTypeId=");
		sb.append(listTypeId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ESFAddress toEntityModel() {
		ESFAddressImpl esfAddressImpl = new ESFAddressImpl();

		if (uuid == null) {
			esfAddressImpl.setUuid(StringPool.BLANK);
		}
		else {
			esfAddressImpl.setUuid(uuid);
		}

		esfAddressImpl.setEsfAddressId(esfAddressId);
		esfAddressImpl.setLongitude(longitude);
		esfAddressImpl.setLatitude(latitude);

		if (esfCountryId == null) {
			esfAddressImpl.setEsfCountryId(StringPool.BLANK);
		}
		else {
			esfAddressImpl.setEsfCountryId(esfCountryId);
		}

		if (esfRegionId == null) {
			esfAddressImpl.setEsfRegionId(StringPool.BLANK);
		}
		else {
			esfAddressImpl.setEsfRegionId(esfRegionId);
		}

		if (esfProvinceId == null) {
			esfAddressImpl.setEsfProvinceId(StringPool.BLANK);
		}
		else {
			esfAddressImpl.setEsfProvinceId(esfProvinceId);
		}

		esfAddressImpl.setEsfCityId(esfCityId);
		esfAddressImpl.setGroupId(groupId);

		if (type == null) {
			esfAddressImpl.setType(StringPool.BLANK);
		}
		else {
			esfAddressImpl.setType(type);
		}

		esfAddressImpl.setIsNotNational(isNotNational);
		esfAddressImpl.setListTypeId(listTypeId);

		esfAddressImpl.resetOriginalValues();

		return esfAddressImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		esfAddressId = objectInput.readLong();
		longitude = objectInput.readDouble();
		latitude = objectInput.readDouble();
		esfCountryId = objectInput.readUTF();
		esfRegionId = objectInput.readUTF();
		esfProvinceId = objectInput.readUTF();
		esfCityId = objectInput.readLong();
		groupId = objectInput.readLong();
		type = objectInput.readUTF();
		isNotNational = objectInput.readBoolean();
		listTypeId = objectInput.readInt();
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

		objectOutput.writeLong(esfAddressId);
		objectOutput.writeDouble(longitude);
		objectOutput.writeDouble(latitude);

		if (esfCountryId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(esfCountryId);
		}

		if (esfRegionId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(esfRegionId);
		}

		if (esfProvinceId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(esfProvinceId);
		}

		objectOutput.writeLong(esfCityId);
		objectOutput.writeLong(groupId);

		if (type == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(type);
		}

		objectOutput.writeBoolean(isNotNational);
		objectOutput.writeInt(listTypeId);
	}

	public String uuid;
	public long esfAddressId;
	public double longitude;
	public double latitude;
	public String esfCountryId;
	public String esfRegionId;
	public String esfProvinceId;
	public long esfCityId;
	public long groupId;
	public String type;
	public boolean isNotNational;
	public int listTypeId;
}