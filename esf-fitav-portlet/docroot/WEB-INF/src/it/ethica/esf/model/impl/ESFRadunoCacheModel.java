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

import it.ethica.esf.model.ESFRaduno;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ESFRaduno in entity cache.
 *
 * @author Ethica
 * @see ESFRaduno
 * @generated
 */
public class ESFRadunoCacheModel implements CacheModel<ESFRaduno>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{id_esf_raduno=");
		sb.append(id_esf_raduno);
		sb.append(", codice=");
		sb.append(codice);
		sb.append(", data_inizio=");
		sb.append(data_inizio);
		sb.append(", data_fine=");
		sb.append(data_fine);
		sb.append(", tipo_raduno=");
		sb.append(tipo_raduno);
		sb.append(", id_sottotipo_raduno=");
		sb.append(id_sottotipo_raduno);
		sb.append(", note=");
		sb.append(note);
		sb.append(", id_associazione_ospitante=");
		sb.append(id_associazione_ospitante);
		sb.append(", altra_sede_ospitante=");
		sb.append(altra_sede_ospitante);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ESFRaduno toEntityModel() {
		ESFRadunoImpl esfRadunoImpl = new ESFRadunoImpl();

		esfRadunoImpl.setId_esf_raduno(id_esf_raduno);

		if (codice == null) {
			esfRadunoImpl.setCodice(StringPool.BLANK);
		}
		else {
			esfRadunoImpl.setCodice(codice);
		}

		if (data_inizio == Long.MIN_VALUE) {
			esfRadunoImpl.setData_inizio(null);
		}
		else {
			esfRadunoImpl.setData_inizio(new Date(data_inizio));
		}

		if (data_fine == Long.MIN_VALUE) {
			esfRadunoImpl.setData_fine(null);
		}
		else {
			esfRadunoImpl.setData_fine(new Date(data_fine));
		}

		esfRadunoImpl.setTipo_raduno(tipo_raduno);
		esfRadunoImpl.setId_sottotipo_raduno(id_sottotipo_raduno);

		if (note == null) {
			esfRadunoImpl.setNote(StringPool.BLANK);
		}
		else {
			esfRadunoImpl.setNote(note);
		}

		esfRadunoImpl.setId_associazione_ospitante(id_associazione_ospitante);

		if (altra_sede_ospitante == null) {
			esfRadunoImpl.setAltra_sede_ospitante(StringPool.BLANK);
		}
		else {
			esfRadunoImpl.setAltra_sede_ospitante(altra_sede_ospitante);
		}

		esfRadunoImpl.resetOriginalValues();

		return esfRadunoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id_esf_raduno = objectInput.readLong();
		codice = objectInput.readUTF();
		data_inizio = objectInput.readLong();
		data_fine = objectInput.readLong();
		tipo_raduno = objectInput.readLong();
		id_sottotipo_raduno = objectInput.readLong();
		note = objectInput.readUTF();
		id_associazione_ospitante = objectInput.readLong();
		altra_sede_ospitante = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id_esf_raduno);

		if (codice == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(codice);
		}

		objectOutput.writeLong(data_inizio);
		objectOutput.writeLong(data_fine);
		objectOutput.writeLong(tipo_raduno);
		objectOutput.writeLong(id_sottotipo_raduno);

		if (note == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(note);
		}

		objectOutput.writeLong(id_associazione_ospitante);

		if (altra_sede_ospitante == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(altra_sede_ospitante);
		}
	}

	public long id_esf_raduno;
	public String codice;
	public long data_inizio;
	public long data_fine;
	public long tipo_raduno;
	public long id_sottotipo_raduno;
	public String note;
	public long id_associazione_ospitante;
	public String altra_sede_ospitante;
}