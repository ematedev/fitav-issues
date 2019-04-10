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

import it.ethica.esf.model.ESFBrand;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ESFBrand in entity cache.
 *
 * @author Ethica
 * @see ESFBrand
 * @generated
 */
public class ESFBrandCacheModel implements CacheModel<ESFBrand>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{brandId=");
		sb.append(brandId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", description=");
		sb.append(description);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ESFBrand toEntityModel() {
		ESFBrandImpl esfBrandImpl = new ESFBrandImpl();

		esfBrandImpl.setBrandId(brandId);

		if (name == null) {
			esfBrandImpl.setName(StringPool.BLANK);
		}
		else {
			esfBrandImpl.setName(name);
		}

		if (description == null) {
			esfBrandImpl.setDescription(StringPool.BLANK);
		}
		else {
			esfBrandImpl.setDescription(description);
		}

		esfBrandImpl.resetOriginalValues();

		return esfBrandImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		brandId = objectInput.readLong();
		name = objectInput.readUTF();
		description = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(brandId);

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

	public long brandId;
	public String name;
	public String description;
}