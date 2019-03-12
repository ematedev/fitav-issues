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

import it.ethica.esf.model.ESFDescription;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ESFDescription in entity cache.
 *
 * @author Ethica
 * @see ESFDescription
 * @generated
 */
public class ESFDescriptionCacheModel implements CacheModel<ESFDescription>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{esfDescriptionId=");
		sb.append(esfDescriptionId);
		sb.append(", isNational=");
		sb.append(isNational);
		sb.append(", name=");
		sb.append(name);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ESFDescription toEntityModel() {
		ESFDescriptionImpl esfDescriptionImpl = new ESFDescriptionImpl();

		esfDescriptionImpl.setEsfDescriptionId(esfDescriptionId);
		esfDescriptionImpl.setIsNational(isNational);

		if (name == null) {
			esfDescriptionImpl.setName(StringPool.BLANK);
		}
		else {
			esfDescriptionImpl.setName(name);
		}

		esfDescriptionImpl.resetOriginalValues();

		return esfDescriptionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		esfDescriptionId = objectInput.readLong();
		isNational = objectInput.readBoolean();
		name = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(esfDescriptionId);
		objectOutput.writeBoolean(isNational);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}
	}

	public long esfDescriptionId;
	public boolean isNational;
	public String name;
}