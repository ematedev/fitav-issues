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

import it.ethica.esf.model.ESFCategory;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ESFCategory in entity cache.
 *
 * @author Ethica
 * @see ESFCategory
 * @generated
 */
public class ESFCategoryCacheModel implements CacheModel<ESFCategory>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{esfCategoryId=");
		sb.append(esfCategoryId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", description=");
		sb.append(description);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ESFCategory toEntityModel() {
		ESFCategoryImpl esfCategoryImpl = new ESFCategoryImpl();

		esfCategoryImpl.setEsfCategoryId(esfCategoryId);

		if (name == null) {
			esfCategoryImpl.setName(StringPool.BLANK);
		}
		else {
			esfCategoryImpl.setName(name);
		}

		if (description == null) {
			esfCategoryImpl.setDescription(StringPool.BLANK);
		}
		else {
			esfCategoryImpl.setDescription(description);
		}

		esfCategoryImpl.resetOriginalValues();

		return esfCategoryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		esfCategoryId = objectInput.readLong();
		name = objectInput.readUTF();
		description = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(esfCategoryId);

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

	public long esfCategoryId;
	public String name;
	public String description;
}