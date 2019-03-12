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

import it.ethica.esf.model.ESFFieldESFElectronic;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ESFFieldESFElectronic in entity cache.
 *
 * @author Ethica
 * @see ESFFieldESFElectronic
 * @generated
 */
public class ESFFieldESFElectronicCacheModel implements CacheModel<ESFFieldESFElectronic>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{id=");
		sb.append(id);
		sb.append(", brandId=");
		sb.append(brandId);
		sb.append(", electronicId=");
		sb.append(electronicId);
		sb.append(", fieldId=");
		sb.append(fieldId);
		sb.append(", description=");
		sb.append(description);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ESFFieldESFElectronic toEntityModel() {
		ESFFieldESFElectronicImpl esfFieldESFElectronicImpl = new ESFFieldESFElectronicImpl();

		esfFieldESFElectronicImpl.setId(id);
		esfFieldESFElectronicImpl.setBrandId(brandId);
		esfFieldESFElectronicImpl.setElectronicId(electronicId);
		esfFieldESFElectronicImpl.setFieldId(fieldId);

		if (description == null) {
			esfFieldESFElectronicImpl.setDescription(StringPool.BLANK);
		}
		else {
			esfFieldESFElectronicImpl.setDescription(description);
		}

		esfFieldESFElectronicImpl.resetOriginalValues();

		return esfFieldESFElectronicImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		brandId = objectInput.readLong();
		electronicId = objectInput.readLong();
		fieldId = objectInput.readLong();
		description = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id);
		objectOutput.writeLong(brandId);
		objectOutput.writeLong(electronicId);
		objectOutput.writeLong(fieldId);

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}
	}

	public long id;
	public long brandId;
	public long electronicId;
	public long fieldId;
	public String description;
}