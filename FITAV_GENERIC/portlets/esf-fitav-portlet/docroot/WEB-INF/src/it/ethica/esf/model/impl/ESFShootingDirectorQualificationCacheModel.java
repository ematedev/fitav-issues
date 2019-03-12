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

import it.ethica.esf.model.ESFShootingDirectorQualification;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ESFShootingDirectorQualification in entity cache.
 *
 * @author Ethica
 * @see ESFShootingDirectorQualification
 * @generated
 */
public class ESFShootingDirectorQualificationCacheModel implements CacheModel<ESFShootingDirectorQualification>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{esfShootingDirectorQualificationId=");
		sb.append(esfShootingDirectorQualificationId);
		sb.append(", esfShootingDirectorQualificationDesc=");
		sb.append(esfShootingDirectorQualificationDesc);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ESFShootingDirectorQualification toEntityModel() {
		ESFShootingDirectorQualificationImpl esfShootingDirectorQualificationImpl =
			new ESFShootingDirectorQualificationImpl();

		esfShootingDirectorQualificationImpl.setEsfShootingDirectorQualificationId(esfShootingDirectorQualificationId);

		if (esfShootingDirectorQualificationDesc == null) {
			esfShootingDirectorQualificationImpl.setEsfShootingDirectorQualificationDesc(StringPool.BLANK);
		}
		else {
			esfShootingDirectorQualificationImpl.setEsfShootingDirectorQualificationDesc(esfShootingDirectorQualificationDesc);
		}

		esfShootingDirectorQualificationImpl.resetOriginalValues();

		return esfShootingDirectorQualificationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		esfShootingDirectorQualificationId = objectInput.readLong();
		esfShootingDirectorQualificationDesc = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(esfShootingDirectorQualificationId);

		if (esfShootingDirectorQualificationDesc == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(esfShootingDirectorQualificationDesc);
		}
	}

	public long esfShootingDirectorQualificationId;
	public String esfShootingDirectorQualificationDesc;
}