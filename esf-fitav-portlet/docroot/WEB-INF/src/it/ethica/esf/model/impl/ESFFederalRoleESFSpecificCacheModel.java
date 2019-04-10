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

import it.ethica.esf.model.ESFFederalRoleESFSpecific;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ESFFederalRoleESFSpecific in entity cache.
 *
 * @author Ethica
 * @see ESFFederalRoleESFSpecific
 * @generated
 */
public class ESFFederalRoleESFSpecificCacheModel implements CacheModel<ESFFederalRoleESFSpecific>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", esfSpecificId=");
		sb.append(esfSpecificId);
		sb.append(", esfFederalRoleId=");
		sb.append(esfFederalRoleId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ESFFederalRoleESFSpecific toEntityModel() {
		ESFFederalRoleESFSpecificImpl esfFederalRoleESFSpecificImpl = new ESFFederalRoleESFSpecificImpl();

		if (uuid == null) {
			esfFederalRoleESFSpecificImpl.setUuid(StringPool.BLANK);
		}
		else {
			esfFederalRoleESFSpecificImpl.setUuid(uuid);
		}

		esfFederalRoleESFSpecificImpl.setEsfSpecificId(esfSpecificId);
		esfFederalRoleESFSpecificImpl.setEsfFederalRoleId(esfFederalRoleId);

		esfFederalRoleESFSpecificImpl.resetOriginalValues();

		return esfFederalRoleESFSpecificImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		esfSpecificId = objectInput.readLong();
		esfFederalRoleId = objectInput.readLong();
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

		objectOutput.writeLong(esfSpecificId);
		objectOutput.writeLong(esfFederalRoleId);
	}

	public String uuid;
	public long esfSpecificId;
	public long esfFederalRoleId;
}