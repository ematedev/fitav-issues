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

package com.ethica.esf.model.impl;

import com.ethica.esf.model.ESFArticleType;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ESFArticleType in entity cache.
 *
 * @author Ethica
 * @see ESFArticleType
 * @generated
 */
public class ESFArticleTypeCacheModel implements CacheModel<ESFArticleType>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{esfArticleTypeId=");
		sb.append(esfArticleTypeId);
		sb.append(", description=");
		sb.append(description);
		sb.append(", department=");
		sb.append(department);
		sb.append(", area=");
		sb.append(area);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ESFArticleType toEntityModel() {
		ESFArticleTypeImpl esfArticleTypeImpl = new ESFArticleTypeImpl();

		esfArticleTypeImpl.setEsfArticleTypeId(esfArticleTypeId);

		if (description == null) {
			esfArticleTypeImpl.setDescription(StringPool.BLANK);
		}
		else {
			esfArticleTypeImpl.setDescription(description);
		}

		if (department == null) {
			esfArticleTypeImpl.setDepartment(StringPool.BLANK);
		}
		else {
			esfArticleTypeImpl.setDepartment(department);
		}

		if (area == null) {
			esfArticleTypeImpl.setArea(StringPool.BLANK);
		}
		else {
			esfArticleTypeImpl.setArea(area);
		}

		esfArticleTypeImpl.resetOriginalValues();

		return esfArticleTypeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		esfArticleTypeId = objectInput.readLong();
		description = objectInput.readUTF();
		department = objectInput.readUTF();
		area = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(esfArticleTypeId);

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (department == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(department);
		}

		if (area == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(area);
		}
	}

	public long esfArticleTypeId;
	public String description;
	public String department;
	public String area;
}