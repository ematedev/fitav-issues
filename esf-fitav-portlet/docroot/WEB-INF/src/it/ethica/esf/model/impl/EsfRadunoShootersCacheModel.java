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

import it.ethica.esf.model.EsfRadunoShooters;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing EsfRadunoShooters in entity cache.
 *
 * @author Ethica
 * @see EsfRadunoShooters
 * @generated
 */
public class EsfRadunoShootersCacheModel implements CacheModel<EsfRadunoShooters>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{id_esf_raduno_shooters=");
		sb.append(id_esf_raduno_shooters);
		sb.append(", id_esf_raduno=");
		sb.append(id_esf_raduno);
		sb.append(", userId=");
		sb.append(userId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EsfRadunoShooters toEntityModel() {
		EsfRadunoShootersImpl esfRadunoShootersImpl = new EsfRadunoShootersImpl();

		esfRadunoShootersImpl.setId_esf_raduno_shooters(id_esf_raduno_shooters);
		esfRadunoShootersImpl.setId_esf_raduno(id_esf_raduno);
		esfRadunoShootersImpl.setUserId(userId);

		esfRadunoShootersImpl.resetOriginalValues();

		return esfRadunoShootersImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id_esf_raduno_shooters = objectInput.readLong();
		id_esf_raduno = objectInput.readLong();
		userId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id_esf_raduno_shooters);
		objectOutput.writeLong(id_esf_raduno);
		objectOutput.writeLong(userId);
	}

	public long id_esf_raduno_shooters;
	public long id_esf_raduno;
	public long userId;
}