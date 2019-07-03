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

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

/**
 * @author Ethica
 * @generated
 */
public class VW_DatiDrettoreTiroPK implements Comparable<VW_DatiDrettoreTiroPK>,
	Serializable {
	public long esfShootingDirectorId;
	public String Nome;
	public String Cognome;
	public String CodiceRegione;

	public VW_DatiDrettoreTiroPK() {
	}

	public VW_DatiDrettoreTiroPK(long esfShootingDirectorId, String Nome,
		String Cognome, String CodiceRegione) {
		this.esfShootingDirectorId = esfShootingDirectorId;
		this.Nome = Nome;
		this.Cognome = Cognome;
		this.CodiceRegione = CodiceRegione;
	}

	public long getEsfShootingDirectorId() {
		return esfShootingDirectorId;
	}

	public void setEsfShootingDirectorId(long esfShootingDirectorId) {
		this.esfShootingDirectorId = esfShootingDirectorId;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String Nome) {
		this.Nome = Nome;
	}

	public String getCognome() {
		return Cognome;
	}

	public void setCognome(String Cognome) {
		this.Cognome = Cognome;
	}

	public String getCodiceRegione() {
		return CodiceRegione;
	}

	public void setCodiceRegione(String CodiceRegione) {
		this.CodiceRegione = CodiceRegione;
	}

	@Override
	public int compareTo(VW_DatiDrettoreTiroPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (esfShootingDirectorId < pk.esfShootingDirectorId) {
			value = -1;
		}
		else if (esfShootingDirectorId > pk.esfShootingDirectorId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		value = Nome.compareTo(pk.Nome);

		if (value != 0) {
			return value;
		}

		value = Cognome.compareTo(pk.Cognome);

		if (value != 0) {
			return value;
		}

		value = CodiceRegione.compareTo(pk.CodiceRegione);

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

		if (!(obj instanceof VW_DatiDrettoreTiroPK)) {
			return false;
		}

		VW_DatiDrettoreTiroPK pk = (VW_DatiDrettoreTiroPK)obj;

		if ((esfShootingDirectorId == pk.esfShootingDirectorId) &&
				(Nome.equals(pk.Nome)) && (Cognome.equals(pk.Cognome)) &&
				(CodiceRegione.equals(pk.CodiceRegione))) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (String.valueOf(esfShootingDirectorId) + String.valueOf(Nome) +
		String.valueOf(Cognome) + String.valueOf(CodiceRegione)).hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(20);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("esfShootingDirectorId");
		sb.append(StringPool.EQUAL);
		sb.append(esfShootingDirectorId);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("Nome");
		sb.append(StringPool.EQUAL);
		sb.append(Nome);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("Cognome");
		sb.append(StringPool.EQUAL);
		sb.append(Cognome);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("CodiceRegione");
		sb.append(StringPool.EQUAL);
		sb.append(CodiceRegione);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}