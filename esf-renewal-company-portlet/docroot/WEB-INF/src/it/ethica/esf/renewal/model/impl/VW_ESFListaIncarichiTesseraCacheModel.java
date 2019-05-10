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

package it.ethica.esf.renewal.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import it.ethica.esf.renewal.model.VW_ESFListaIncarichiTessera;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing VW_ESFListaIncarichiTessera in entity cache.
 *
 * @author Ethica
 * @see VW_ESFListaIncarichiTessera
 * @generated
 */
public class VW_ESFListaIncarichiTesseraCacheModel implements CacheModel<VW_ESFListaIncarichiTessera>,
	Externalizable {
	@Override
	public String toString() {
<<<<<<< HEAD
		StringBundler sb = new StringBundler(29);
=======
		StringBundler sb = new StringBundler(27);
>>>>>>> origin/master

		sb.append("{AnniPrecedenti=");
		sb.append(AnniPrecedenti);
		sb.append(", AnnoFineIncarico=");
		sb.append(AnnoFineIncarico);
		sb.append(", AnnoInizioIncarico=");
		sb.append(AnnoInizioIncarico);
		sb.append(", AnnoCorrente=");
		sb.append(AnnoCorrente);
		sb.append(", NomeRuolo=");
		sb.append(NomeRuolo);
		sb.append(", endDate=");
		sb.append(endDate);
		sb.append(", startDate=");
		sb.append(startDate);
		sb.append(", esfUserId=");
		sb.append(esfUserId);
		sb.append(", esfOrganizationId=");
		sb.append(esfOrganizationId);
		sb.append(", lastName=");
		sb.append(lastName);
		sb.append(", firstName=");
		sb.append(firstName);
		sb.append(", CodiceTessera=");
		sb.append(CodiceTessera);
		sb.append(", DataTesseramento=");
		sb.append(DataTesseramento);
<<<<<<< HEAD
		sb.append(", CodiceFiscale=");
		sb.append(CodiceFiscale);
=======
>>>>>>> origin/master
		sb.append("}");

		return sb.toString();
	}

	@Override
	public VW_ESFListaIncarichiTessera toEntityModel() {
		VW_ESFListaIncarichiTesseraImpl vw_esfListaIncarichiTesseraImpl = new VW_ESFListaIncarichiTesseraImpl();

		vw_esfListaIncarichiTesseraImpl.setAnniPrecedenti(AnniPrecedenti);
		vw_esfListaIncarichiTesseraImpl.setAnnoFineIncarico(AnnoFineIncarico);
		vw_esfListaIncarichiTesseraImpl.setAnnoInizioIncarico(AnnoInizioIncarico);
		vw_esfListaIncarichiTesseraImpl.setAnnoCorrente(AnnoCorrente);

		if (NomeRuolo == null) {
			vw_esfListaIncarichiTesseraImpl.setNomeRuolo(StringPool.BLANK);
		}
		else {
			vw_esfListaIncarichiTesseraImpl.setNomeRuolo(NomeRuolo);
		}

		if (endDate == Long.MIN_VALUE) {
			vw_esfListaIncarichiTesseraImpl.setEndDate(null);
		}
		else {
			vw_esfListaIncarichiTesseraImpl.setEndDate(new Date(endDate));
		}

		if (startDate == Long.MIN_VALUE) {
			vw_esfListaIncarichiTesseraImpl.setStartDate(null);
		}
		else {
			vw_esfListaIncarichiTesseraImpl.setStartDate(new Date(startDate));
		}

		vw_esfListaIncarichiTesseraImpl.setEsfUserId(esfUserId);
		vw_esfListaIncarichiTesseraImpl.setEsfOrganizationId(esfOrganizationId);

		if (lastName == null) {
			vw_esfListaIncarichiTesseraImpl.setLastName(StringPool.BLANK);
		}
		else {
			vw_esfListaIncarichiTesseraImpl.setLastName(lastName);
		}

		if (firstName == null) {
			vw_esfListaIncarichiTesseraImpl.setFirstName(StringPool.BLANK);
		}
		else {
			vw_esfListaIncarichiTesseraImpl.setFirstName(firstName);
		}

		if (CodiceTessera == null) {
			vw_esfListaIncarichiTesseraImpl.setCodiceTessera(StringPool.BLANK);
		}
		else {
			vw_esfListaIncarichiTesseraImpl.setCodiceTessera(CodiceTessera);
		}

		if (DataTesseramento == Long.MIN_VALUE) {
			vw_esfListaIncarichiTesseraImpl.setDataTesseramento(null);
		}
		else {
			vw_esfListaIncarichiTesseraImpl.setDataTesseramento(new Date(
					DataTesseramento));
		}

<<<<<<< HEAD
		if (CodiceFiscale == null) {
			vw_esfListaIncarichiTesseraImpl.setCodiceFiscale(StringPool.BLANK);
		}
		else {
			vw_esfListaIncarichiTesseraImpl.setCodiceFiscale(CodiceFiscale);
		}

=======
>>>>>>> origin/master
		vw_esfListaIncarichiTesseraImpl.resetOriginalValues();

		return vw_esfListaIncarichiTesseraImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		AnniPrecedenti = objectInput.readInt();
		AnnoFineIncarico = objectInput.readInt();
		AnnoInizioIncarico = objectInput.readInt();
		AnnoCorrente = objectInput.readInt();
		NomeRuolo = objectInput.readUTF();
		endDate = objectInput.readLong();
		startDate = objectInput.readLong();
		esfUserId = objectInput.readLong();
		esfOrganizationId = objectInput.readLong();
		lastName = objectInput.readUTF();
		firstName = objectInput.readUTF();
		CodiceTessera = objectInput.readUTF();
		DataTesseramento = objectInput.readLong();
<<<<<<< HEAD
		CodiceFiscale = objectInput.readUTF();
=======
>>>>>>> origin/master
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeInt(AnniPrecedenti);
		objectOutput.writeInt(AnnoFineIncarico);
		objectOutput.writeInt(AnnoInizioIncarico);
		objectOutput.writeInt(AnnoCorrente);

		if (NomeRuolo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(NomeRuolo);
		}

		objectOutput.writeLong(endDate);
		objectOutput.writeLong(startDate);
		objectOutput.writeLong(esfUserId);
		objectOutput.writeLong(esfOrganizationId);

		if (lastName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(lastName);
		}

		if (firstName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(firstName);
		}

		if (CodiceTessera == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(CodiceTessera);
		}

		objectOutput.writeLong(DataTesseramento);
<<<<<<< HEAD

		if (CodiceFiscale == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(CodiceFiscale);
		}
=======
>>>>>>> origin/master
	}

	public int AnniPrecedenti;
	public int AnnoFineIncarico;
	public int AnnoInizioIncarico;
	public int AnnoCorrente;
	public String NomeRuolo;
	public long endDate;
	public long startDate;
	public long esfUserId;
	public long esfOrganizationId;
	public String lastName;
	public String firstName;
	public String CodiceTessera;
	public long DataTesseramento;
<<<<<<< HEAD
	public String CodiceFiscale;
=======
>>>>>>> origin/master
}