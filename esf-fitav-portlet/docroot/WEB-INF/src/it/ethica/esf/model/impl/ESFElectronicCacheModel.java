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

import it.ethica.esf.model.ESFElectronic;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ESFElectronic in entity cache.
 *
 * @author Ethica
 * @see ESFElectronic
 * @generated
 */
public class ESFElectronicCacheModel implements CacheModel<ESFElectronic>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{electronicId=");
		sb.append(electronicId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", description=");
		sb.append(description);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ESFElectronic toEntityModel() {
		ESFElectronicImpl esfElectronicImpl = new ESFElectronicImpl();

		esfElectronicImpl.setElectronicId(electronicId);

		if (name == null) {
			esfElectronicImpl.setName(StringPool.BLANK);
		}
		else {
			esfElectronicImpl.setName(name);
		}

		if (description == null) {
			esfElectronicImpl.setDescription(StringPool.BLANK);
		}
		else {
			esfElectronicImpl.setDescription(description);
		}

		esfElectronicImpl.resetOriginalValues();

		return esfElectronicImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		electronicId = objectInput.readLong();
		name = objectInput.readUTF();
		description = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(electronicId);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}
	}

	public long electronicId;
	public String name;
	public String description;
}