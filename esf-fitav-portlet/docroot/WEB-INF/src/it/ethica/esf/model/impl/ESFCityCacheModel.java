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

import it.ethica.esf.model.ESFCity;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ESFCity in entity cache.
 *
 * @author Ethica
 * @see ESFCity
 * @generated
 */
public class ESFCityCacheModel implements CacheModel<ESFCity>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{idCity=");
		sb.append(idCity);
		sb.append(", idProvince=");
		sb.append(idProvince);
		sb.append(", idRegion=");
		sb.append(idRegion);
		sb.append(", idCountry=");
		sb.append(idCountry);
		sb.append(", zip=");
		sb.append(zip);
		sb.append(", name=");
		sb.append(name);
		sb.append(", latitude=");
		sb.append(latitude);
		sb.append(", longitude=");
		sb.append(longitude);
		sb.append(", altitude=");
		sb.append(altitude);
		sb.append(", website=");
		sb.append(website);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ESFCity toEntityModel() {
		ESFCityImpl esfCityImpl = new ESFCityImpl();

		esfCityImpl.setIdCity(idCity);

		if (idProvince == null) {
			esfCityImpl.setIdProvince(StringPool.BLANK);
		}
		else {
			esfCityImpl.setIdProvince(idProvince);
		}

		if (idRegion == null) {
			esfCityImpl.setIdRegion(StringPool.BLANK);
		}
		else {
			esfCityImpl.setIdRegion(idRegion);
		}

		if (idCountry == null) {
			esfCityImpl.setIdCountry(StringPool.BLANK);
		}
		else {
			esfCityImpl.setIdCountry(idCountry);
		}

		esfCityImpl.setZip(zip);

		if (name == null) {
			esfCityImpl.setName(StringPool.BLANK);
		}
		else {
			esfCityImpl.setName(name);
		}

		esfCityImpl.setLatitude(latitude);
		esfCityImpl.setLongitude(longitude);
		esfCityImpl.setAltitude(altitude);

		if (website == null) {
			esfCityImpl.setWebsite(StringPool.BLANK);
		}
		else {
			esfCityImpl.setWebsite(website);
		}

		esfCityImpl.resetOriginalValues();

		return esfCityImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		idCity = objectInput.readLong();
		idProvince = objectInput.readUTF();
		idRegion = objectInput.readUTF();
		idCountry = objectInput.readUTF();
		zip = objectInput.readLong();
		name = objectInput.readUTF();
		latitude = objectInput.readDouble();
		longitude = objectInput.readDouble();
		altitude = objectInput.readDouble();
		website = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(idCity);

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

		objectOutput.writeLong(zip);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeDouble(latitude);
		objectOutput.writeDouble(longitude);
		objectOutput.writeDouble(altitude);

		if (website == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(website);
		}
	}

	public long idCity;
	public String idProvince;
	public String idRegion;
	public String idCountry;
	public long zip;
	public String name;
	public double latitude;
	public double longitude;
	public double altitude;
	public String website;
}