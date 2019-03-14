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

import it.ethica.esf.model.ESFSuspensiveCode;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ESFSuspensiveCode in entity cache.
 *
 * @author Ethica
 * @see ESFSuspensiveCode
 * @generated
 */
public class ESFSuspensiveCodeCacheModel implements CacheModel<ESFSuspensiveCode>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{esfSuspensiveCodeId=");
		sb.append(esfSuspensiveCodeId);
		sb.append(", code=");
		sb.append(code);
		sb.append(", description=");
		sb.append(description);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ESFSuspensiveCode toEntityModel() {
		ESFSuspensiveCodeImpl esfSuspensiveCodeImpl = new ESFSuspensiveCodeImpl();

		esfSuspensiveCodeImpl.setEsfSuspensiveCodeId(esfSuspensiveCodeId);

		if (code == null) {
			esfSuspensiveCodeImpl.setCode(StringPool.BLANK);
		}
		else {
			esfSuspensiveCodeImpl.setCode(code);
		}

		if (description == null) {
			esfSuspensiveCodeImpl.setDescription(StringPool.BLANK);
		}
		else {
			esfSuspensiveCodeImpl.setDescription(description);
		}

		esfSuspensiveCodeImpl.resetOriginalValues();

		return esfSuspensiveCodeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		esfSuspensiveCodeId = objectInput.readLong();
		code = objectInput.readUTF();
		description = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(esfSuspensiveCodeId);

		if (code == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(code);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}
	}

	public long esfSuspensiveCodeId;
	public String code;
	public String description;
}