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

import it.ethica.esf.model.VW_ESFListaIncarichi;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing VW_ESFListaIncarichi in entity cache.
 *
 * @author Ethica
 * @see VW_ESFListaIncarichi
 * @generated
 */
public class VW_ESFListaIncarichiCacheModel implements CacheModel<VW_ESFListaIncarichi>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

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
		sb.append("}");

		return sb.toString();
	}

	@Override
	public VW_ESFListaIncarichi toEntityModel() {
		VW_ESFListaIncarichiImpl vw_esfListaIncarichiImpl = new VW_ESFListaIncarichiImpl();

		vw_esfListaIncarichiImpl.setAnniPrecedenti(AnniPrecedenti);
		vw_esfListaIncarichiImpl.setAnnoFineIncarico(AnnoFineIncarico);
		vw_esfListaIncarichiImpl.setAnnoInizioIncarico(AnnoInizioIncarico);
		vw_esfListaIncarichiImpl.setAnnoCorrente(AnnoCorrente);

		if (NomeRuolo == null) {
			vw_esfListaIncarichiImpl.setNomeRuolo(StringPool.BLANK);
		}
		else {
			vw_esfListaIncarichiImpl.setNomeRuolo(NomeRuolo);
		}

		if (endDate == Long.MIN_VALUE) {
			vw_esfListaIncarichiImpl.setEndDate(null);
		}
		else {
			vw_esfListaIncarichiImpl.setEndDate(new Date(endDate));
		}

		if (startDate == Long.MIN_VALUE) {
			vw_esfListaIncarichiImpl.setStartDate(null);
		}
		else {
			vw_esfListaIncarichiImpl.setStartDate(new Date(startDate));
		}

		vw_esfListaIncarichiImpl.setEsfUserId(esfUserId);
		vw_esfListaIncarichiImpl.setEsfOrganizationId(esfOrganizationId);

		if (lastName == null) {
			vw_esfListaIncarichiImpl.setLastName(StringPool.BLANK);
		}
		else {
			vw_esfListaIncarichiImpl.setLastName(lastName);
		}

		if (firstName == null) {
			vw_esfListaIncarichiImpl.setFirstName(StringPool.BLANK);
		}
		else {
			vw_esfListaIncarichiImpl.setFirstName(firstName);
		}

		vw_esfListaIncarichiImpl.resetOriginalValues();

		return vw_esfListaIncarichiImpl;
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
}