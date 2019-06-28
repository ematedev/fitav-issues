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
import com.liferay.portal.model.CacheModel;

import it.ethica.esf.model.ESFRadunoAzzurri;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ESFRadunoAzzurri in entity cache.
 *
 * @author Ethica
 * @see ESFRadunoAzzurri
 * @generated
 */
public class ESFRadunoAzzurriCacheModel implements CacheModel<ESFRadunoAzzurri>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{id_esf_raduno_azzurri=");
		sb.append(id_esf_raduno_azzurri);
		sb.append(", id_esf_raduno=");
		sb.append(id_esf_raduno);
		sb.append(", esfNationalId=");
		sb.append(esfNationalId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ESFRadunoAzzurri toEntityModel() {
		ESFRadunoAzzurriImpl esfRadunoAzzurriImpl = new ESFRadunoAzzurriImpl();

		esfRadunoAzzurriImpl.setId_esf_raduno_azzurri(id_esf_raduno_azzurri);
		esfRadunoAzzurriImpl.setId_esf_raduno(id_esf_raduno);
		esfRadunoAzzurriImpl.setEsfNationalId(esfNationalId);

		esfRadunoAzzurriImpl.resetOriginalValues();

		return esfRadunoAzzurriImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id_esf_raduno_azzurri = objectInput.readLong();
		id_esf_raduno = objectInput.readLong();
		esfNationalId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id_esf_raduno_azzurri);
		objectOutput.writeLong(id_esf_raduno);
		objectOutput.writeLong(esfNationalId);
	}

	public long id_esf_raduno_azzurri;
	public long id_esf_raduno;
	public long esfNationalId;
}