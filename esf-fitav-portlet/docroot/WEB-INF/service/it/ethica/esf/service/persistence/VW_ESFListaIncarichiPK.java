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

package it.ethica.esf.service.persistence;

import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

import java.util.Date;

/**
 * @author Ethica
 * @generated
 */
public class VW_ESFListaIncarichiPK implements Comparable<VW_ESFListaIncarichiPK>,
	Serializable {
	public int AnniPrecedenti;
	public int AnnoFineIncarico;
	public int AnnoInizioIncarico;
	public int AnnoCorrente;
	public String NomeRuolo;
	public Date startDate;
	public long esfUserId;
	public long esfOrganizationId;
	public String lastName;
	public String firstName;

	public VW_ESFListaIncarichiPK() {
	}

	public VW_ESFListaIncarichiPK(int AnniPrecedenti, int AnnoFineIncarico,
		int AnnoInizioIncarico, int AnnoCorrente, String NomeRuolo,
		Date startDate, long esfUserId, long esfOrganizationId,
		String lastName, String firstName) {
		this.AnniPrecedenti = AnniPrecedenti;
		this.AnnoFineIncarico = AnnoFineIncarico;
		this.AnnoInizioIncarico = AnnoInizioIncarico;
		this.AnnoCorrente = AnnoCorrente;
		this.NomeRuolo = NomeRuolo;
		this.startDate = startDate;
		this.esfUserId = esfUserId;
		this.esfOrganizationId = esfOrganizationId;
		this.lastName = lastName;
		this.firstName = firstName;
	}

	public int getAnniPrecedenti() {
		return AnniPrecedenti;
	}

	public void setAnniPrecedenti(int AnniPrecedenti) {
		this.AnniPrecedenti = AnniPrecedenti;
	}

	public int getAnnoFineIncarico() {
		return AnnoFineIncarico;
	}

	public void setAnnoFineIncarico(int AnnoFineIncarico) {
		this.AnnoFineIncarico = AnnoFineIncarico;
	}

	public int getAnnoInizioIncarico() {
		return AnnoInizioIncarico;
	}

	public void setAnnoInizioIncarico(int AnnoInizioIncarico) {
		this.AnnoInizioIncarico = AnnoInizioIncarico;
	}

	public int getAnnoCorrente() {
		return AnnoCorrente;
	}

	public void setAnnoCorrente(int AnnoCorrente) {
		this.AnnoCorrente = AnnoCorrente;
	}

	public String getNomeRuolo() {
		return NomeRuolo;
	}

	public void setNomeRuolo(String NomeRuolo) {
		this.NomeRuolo = NomeRuolo;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public long getEsfUserId() {
		return esfUserId;
	}

	public void setEsfUserId(long esfUserId) {
		this.esfUserId = esfUserId;
	}

	public long getEsfOrganizationId() {
		return esfOrganizationId;
	}

	public void setEsfOrganizationId(long esfOrganizationId) {
		this.esfOrganizationId = esfOrganizationId;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Override
	public int compareTo(VW_ESFListaIncarichiPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (AnniPrecedenti < pk.AnniPrecedenti) {
			value = -1;
		}
		else if (AnniPrecedenti > pk.AnniPrecedenti) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (AnnoFineIncarico < pk.AnnoFineIncarico) {
			value = -1;
		}
		else if (AnnoFineIncarico > pk.AnnoFineIncarico) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (AnnoInizioIncarico < pk.AnnoInizioIncarico) {
			value = -1;
		}
		else if (AnnoInizioIncarico > pk.AnnoInizioIncarico) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (AnnoCorrente < pk.AnnoCorrente) {
			value = -1;
		}
		else if (AnnoCorrente > pk.AnnoCorrente) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		value = NomeRuolo.compareTo(pk.NomeRuolo);

		if (value != 0) {
			return value;
		}

		value = DateUtil.compareTo(startDate, pk.startDate);

		if (value != 0) {
			return value;
		}

		if (esfUserId < pk.esfUserId) {
			value = -1;
		}
		else if (esfUserId > pk.esfUserId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (esfOrganizationId < pk.esfOrganizationId) {
			value = -1;
		}
		else if (esfOrganizationId > pk.esfOrganizationId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		value = lastName.compareTo(pk.lastName);

		if (value != 0) {
			return value;
		}

		value = firstName.compareTo(pk.firstName);

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof VW_ESFListaIncarichiPK)) {
			return false;
		}

		VW_ESFListaIncarichiPK pk = (VW_ESFListaIncarichiPK)obj;

		if ((AnniPrecedenti == pk.AnniPrecedenti) &&
				(AnnoFineIncarico == pk.AnnoFineIncarico) &&
				(AnnoInizioIncarico == pk.AnnoInizioIncarico) &&
				(AnnoCorrente == pk.AnnoCorrente) &&
				(NomeRuolo.equals(pk.NomeRuolo)) &&
				(startDate.equals(pk.startDate)) &&
				(esfUserId == pk.esfUserId) &&
				(esfOrganizationId == pk.esfOrganizationId) &&
				(lastName.equals(pk.lastName)) &&
				(firstName.equals(pk.firstName))) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (String.valueOf(AnniPrecedenti) +
		String.valueOf(AnnoFineIncarico) + String.valueOf(AnnoInizioIncarico) +
		String.valueOf(AnnoCorrente) + String.valueOf(NomeRuolo) +
		startDate.toString() + String.valueOf(esfUserId) +
		String.valueOf(esfOrganizationId) + String.valueOf(lastName) +
		String.valueOf(firstName)).hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(50);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("AnniPrecedenti");
		sb.append(StringPool.EQUAL);
		sb.append(AnniPrecedenti);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("AnnoFineIncarico");
		sb.append(StringPool.EQUAL);
		sb.append(AnnoFineIncarico);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("AnnoInizioIncarico");
		sb.append(StringPool.EQUAL);
		sb.append(AnnoInizioIncarico);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("AnnoCorrente");
		sb.append(StringPool.EQUAL);
		sb.append(AnnoCorrente);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("NomeRuolo");
		sb.append(StringPool.EQUAL);
		sb.append(NomeRuolo);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("startDate");
		sb.append(StringPool.EQUAL);
		sb.append(startDate);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("esfUserId");
		sb.append(StringPool.EQUAL);
		sb.append(esfUserId);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("esfOrganizationId");
		sb.append(StringPool.EQUAL);
		sb.append(esfOrganizationId);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("lastName");
		sb.append(StringPool.EQUAL);
		sb.append(lastName);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("firstName");
		sb.append(StringPool.EQUAL);
		sb.append(firstName);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}