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

import it.ethica.esf.model.ESFRegion;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ESFRegion in entity cache.
 *
 * @author Ethica
 * @see ESFRegion
 * @generated
 */
public class ESFRegionCacheModel implements CacheModel<ESFRegion>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{idRegion=");
		sb.append(idRegion);
		sb.append(", idCountry=");
		sb.append(idCountry);
		sb.append(", name=");
		sb.append(name);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ESFRegion toEntityModel() {
		ESFRegionImpl esfRegionImpl = new ESFRegionImpl();

		if (idRegion == null) {
			esfRegionImpl.setIdRegion(StringPool.BLANK);
		}
		else {
			esfRegionImpl.setIdRegion(idRegion);
		}

		if (idCountry == null) {
			esfRegionImpl.setIdCountry(StringPool.BLANK);
		}
		else {
			esfRegionImpl.setIdCountry(idCountry);
		}

		if (name == null) {
			esfRegionImpl.setName(StringPool.BLANK);
		}
		else {
			esfRegionImpl.setName(name);
		}

		esfRegionImpl.resetOriginalValues();

		return esfRegionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		idRegion = objectInput.readUTF();
		idCountry = objectInput.readUTF();
		name = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
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

	public String idRegion;
	public String idCountry;
	public String name;
}