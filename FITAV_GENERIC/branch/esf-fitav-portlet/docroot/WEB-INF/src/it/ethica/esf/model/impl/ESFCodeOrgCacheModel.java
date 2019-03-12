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

import it.ethica.esf.model.ESFCodeOrg;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ESFCodeOrg in entity cache.
 *
 * @author Ethica
 * @see ESFCodeOrg
 * @generated
 */
public class ESFCodeOrgCacheModel implements CacheModel<ESFCodeOrg>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{esfCodeOrgId=");
		sb.append(esfCodeOrgId);
		sb.append(", className=");
		sb.append(className);
		sb.append(", code=");
		sb.append(code);
		sb.append(", sequence=");
		sb.append(sequence);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ESFCodeOrg toEntityModel() {
		ESFCodeOrgImpl esfCodeOrgImpl = new ESFCodeOrgImpl();

		esfCodeOrgImpl.setEsfCodeOrgId(esfCodeOrgId);

		if (className == null) {
			esfCodeOrgImpl.setClassName(StringPool.BLANK);
		}
		else {
			esfCodeOrgImpl.setClassName(className);
		}

		if (code == null) {
			esfCodeOrgImpl.setCode(StringPool.BLANK);
		}
		else {
			esfCodeOrgImpl.setCode(code);
		}

		esfCodeOrgImpl.setSequence(sequence);

		esfCodeOrgImpl.resetOriginalValues();

		return esfCodeOrgImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		esfCodeOrgId = objectInput.readLong();
		className = objectInput.readUTF();
		code = objectInput.readUTF();
		sequence = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(esfCodeOrgId);

		if (className == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(className);
		}

		if (code == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(code);
		}

		objectOutput.writeLong(sequence);
	}

	public long esfCodeOrgId;
	public String className;
	public String code;
	public long sequence;
}