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

import it.ethica.esf.model.ESFAirport;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ESFAirport in entity cache.
 *
 * @author Ethica
 * @see ESFAirport
 * @generated
 */
public class ESFAirportCacheModel implements CacheModel<ESFAirport>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{esfAirportId=");
		sb.append(esfAirportId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", city=");
		sb.append(city);
		sb.append(", country=");
		sb.append(country);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ESFAirport toEntityModel() {
		ESFAirportImpl esfAirportImpl = new ESFAirportImpl();

		esfAirportImpl.setEsfAirportId(esfAirportId);

		if (name == null) {
			esfAirportImpl.setName(StringPool.BLANK);
		}
		else {
			esfAirportImpl.setName(name);
		}

		if (city == null) {
			esfAirportImpl.setCity(StringPool.BLANK);
		}
		else {
			esfAirportImpl.setCity(city);
		}

		if (country == null) {
			esfAirportImpl.setCountry(StringPool.BLANK);
		}
		else {
			esfAirportImpl.setCountry(country);
		}

		esfAirportImpl.resetOriginalValues();

		return esfAirportImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		esfAirportId = objectInput.readLong();
		name = objectInput.readUTF();
		city = objectInput.readUTF();
		country = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(esfAirportId);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (city == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(city);
		}

		if (country == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(country);
		}
	}

	public long esfAirportId;
	public String name;
	public String city;
	public String country;
}