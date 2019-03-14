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

import it.ethica.esf.model.Country;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Country in entity cache.
 *
 * @author Ethica
 * @see Country
 * @generated
 */
public class CountryCacheModel implements CacheModel<Country>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{idCountry=");
		sb.append(idCountry);
		sb.append(", name=");
		sb.append(name);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Country toEntityModel() {
		CountryImpl countryImpl = new CountryImpl();

		if (idCountry == null) {
			countryImpl.setIdCountry(StringPool.BLANK);
		}
		else {
			countryImpl.setIdCountry(idCountry);
		}

		if (name == null) {
			countryImpl.setName(StringPool.BLANK);
		}
		else {
			countryImpl.setName(name);
		}

		countryImpl.resetOriginalValues();

		return countryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		idCountry = objectInput.readUTF();
		name = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
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

	public String idCountry;
	public String name;
}