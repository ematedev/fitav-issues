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

import it.ethica.esf.model.ESFInstructsShootingDirector;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ESFInstructsShootingDirector in entity cache.
 *
 * @author Ethica
 * @see ESFInstructsShootingDirector
 * @generated
 */
public class ESFInstructsShootingDirectorCacheModel implements CacheModel<ESFInstructsShootingDirector>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{esfInstructsShootingDirectorId=");
		sb.append(esfInstructsShootingDirectorId);
		sb.append(", esfInstructsShootingDirectorCode=");
		sb.append(esfInstructsShootingDirectorCode);
		sb.append(", esfInstructsShootingDirectorDesc=");
		sb.append(esfInstructsShootingDirectorDesc);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ESFInstructsShootingDirector toEntityModel() {
		ESFInstructsShootingDirectorImpl esfInstructsShootingDirectorImpl = new ESFInstructsShootingDirectorImpl();

		esfInstructsShootingDirectorImpl.setEsfInstructsShootingDirectorId(esfInstructsShootingDirectorId);

		if (esfInstructsShootingDirectorCode == null) {
			esfInstructsShootingDirectorImpl.setEsfInstructsShootingDirectorCode(StringPool.BLANK);
		}
		else {
			esfInstructsShootingDirectorImpl.setEsfInstructsShootingDirectorCode(esfInstructsShootingDirectorCode);
		}

		if (esfInstructsShootingDirectorDesc == null) {
			esfInstructsShootingDirectorImpl.setEsfInstructsShootingDirectorDesc(StringPool.BLANK);
		}
		else {
			esfInstructsShootingDirectorImpl.setEsfInstructsShootingDirectorDesc(esfInstructsShootingDirectorDesc);
		}

		esfInstructsShootingDirectorImpl.resetOriginalValues();

		return esfInstructsShootingDirectorImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		esfInstructsShootingDirectorId = objectInput.readLong();
		esfInstructsShootingDirectorCode = objectInput.readUTF();
		esfInstructsShootingDirectorDesc = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(esfInstructsShootingDirectorId);

		if (esfInstructsShootingDirectorCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(esfInstructsShootingDirectorCode);
		}

		if (esfInstructsShootingDirectorDesc == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(esfInstructsShootingDirectorDesc);
		}
	}

	public long esfInstructsShootingDirectorId;
	public String esfInstructsShootingDirectorCode;
	public String esfInstructsShootingDirectorDesc;
}