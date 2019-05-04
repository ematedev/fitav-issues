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

import it.ethica.esf.model.vw_datidirettoretiro;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing vw_datidirettoretiro in entity cache.
 *
 * @author Ethica
 * @see vw_datidirettoretiro
 * @generated
 */
public class vw_datidirettoretiroCacheModel implements CacheModel<vw_datidirettoretiro>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{esfshootingdirectorid=");
		sb.append(esfshootingdirectorid);
		sb.append(", nome=");
		sb.append(nome);
		sb.append(", cognome=");
		sb.append(cognome);
		sb.append(", esfstartdata=");
		sb.append(esfstartdata);
		sb.append(", categoryid=");
		sb.append(categoryid);
		sb.append(", numerotessera=");
		sb.append(numerotessera);
		sb.append(", codiceregione=");
		sb.append(codiceregione);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public vw_datidirettoretiro toEntityModel() {
		vw_datidirettoretiroImpl vw_datidirettoretiroImpl = new vw_datidirettoretiroImpl();

		vw_datidirettoretiroImpl.setEsfshootingdirectorid(esfshootingdirectorid);
		vw_datidirettoretiroImpl.setNome(nome);
		vw_datidirettoretiroImpl.setCognome(cognome);

		if (esfstartdata == Long.MIN_VALUE) {
			vw_datidirettoretiroImpl.setEsfstartdata(null);
		}
		else {
			vw_datidirettoretiroImpl.setEsfstartdata(new Date(esfstartdata));
		}

		vw_datidirettoretiroImpl.setCategoryid(categoryid);
		vw_datidirettoretiroImpl.setNumerotessera(numerotessera);
		vw_datidirettoretiroImpl.setCodiceregione(codiceregione);

		vw_datidirettoretiroImpl.resetOriginalValues();

		return vw_datidirettoretiroImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		esfshootingdirectorid = objectInput.readLong();
		nome = objectInput.readLong();
		cognome = objectInput.readLong();
		esfstartdata = objectInput.readLong();
		categoryid = objectInput.readLong();
		numerotessera = objectInput.readLong();
		codiceregione = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(esfshootingdirectorid);
		objectOutput.writeLong(nome);
		objectOutput.writeLong(cognome);
		objectOutput.writeLong(esfstartdata);
		objectOutput.writeLong(categoryid);
		objectOutput.writeLong(numerotessera);
		objectOutput.writeLong(codiceregione);
	}

	public long esfshootingdirectorid;
	public long nome;
	public long cognome;
	public long esfstartdata;
	public long categoryid;
	public long numerotessera;
	public long codiceregione;
}