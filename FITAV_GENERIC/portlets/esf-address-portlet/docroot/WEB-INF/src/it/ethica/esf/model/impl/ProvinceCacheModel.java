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

import it.ethica.esf.model.Province;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Province in entity cache.
 *
 * @author Ethica
 * @see Province
 * @generated
 */
public class ProvinceCacheModel implements CacheModel<Province>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{idProvince=");
		sb.append(idProvince);
		sb.append(", idRegion=");
		sb.append(idRegion);
		sb.append(", idCountry=");
		sb.append(idCountry);
		sb.append(", name=");
		sb.append(name);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Province toEntityModel() {
		ProvinceImpl provinceImpl = new ProvinceImpl();

		if (idProvince == null) {
			provinceImpl.setIdProvince(StringPool.BLANK);
		}
		else {
			provinceImpl.setIdProvince(idProvince);
		}

		if (idRegion == null) {
			provinceImpl.setIdRegion(StringPool.BLANK);
		}
		else {
			provinceImpl.setIdRegion(idRegion);
		}

		if (idCountry == null) {
			provinceImpl.setIdCountry(StringPool.BLANK);
		}
		else {
			provinceImpl.setIdCountry(idCountry);
		}

		if (name == null) {
			provinceImpl.setName(StringPool.BLANK);
		}
		else {
			provinceImpl.setName(name);
		}

		provinceImpl.resetOriginalValues();

		return provinceImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		idProvince = objectInput.readUTF();
		idRegion = objectInput.readUTF();
		idCountry = objectInput.readUTF();
		name = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (idProvince == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(idProvince);
		}

		if (idRegion == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(idRegion);
		}

		if (idCountry == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(idCountry);
		}

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}
	}

	public String idProvince;
	public String idRegion;
	public String idCountry;
	public String name;
}