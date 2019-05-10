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
 */
public class vw_datidirettoretiroPK implements Comparable<vw_datidirettoretiroPK>,
	Serializable {
	public long esfshootingdirectorid;
	public long nome;
	public long cognome;
	public Date esfstartdata;
	public long categoryid;
	public long numerotessera;
	public long codiceregione;

	public vw_datidirettoretiroPK() {
	}

	public vw_datidirettoretiroPK(long esfshootingdirectorid, long nome,
		long cognome, Date esfstartdata, long categoryid, long numerotessera,
		long codiceregione) {
		this.esfshootingdirectorid = esfshootingdirectorid;
		this.nome = nome;
		this.cognome = cognome;
		this.esfstartdata = esfstartdata;
		this.categoryid = categoryid;
		this.numerotessera = numerotessera;
		this.codiceregione = codiceregione;
	}

	public long getEsfshootingdirectorid() {
		return esfshootingdirectorid;
	}

	public void setEsfshootingdirectorid(long esfshootingdirectorid) {
		this.esfshootingdirectorid = esfshootingdirectorid;
	}

	public long getNome() {
		return nome;
	}

	public void setNome(long nome) {
		this.nome = nome;
	}

	public long getCognome() {
		return cognome;
	}

	public void setCognome(long cognome) {
		this.cognome = cognome;
	}

	public Date getEsfstartdata() {
		return esfstartdata;
	}

	public void setEsfstartdata(Date esfstartdata) {
		this.esfstartdata = esfstartdata;
	}

	public long getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(long categoryid) {
		this.categoryid = categoryid;
	}

	public long getNumerotessera() {
		return numerotessera;
	}

	public void setNumerotessera(long numerotessera) {
		this.numerotessera = numerotessera;
	}

	public long getCodiceregione() {
		return codiceregione;
	}

	public void setCodiceregione(long codiceregione) {
		this.codiceregione = codiceregione;
	}

	@Override
	public int compareTo(vw_datidirettoretiroPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (esfshootingdirectorid < pk.esfshootingdirectorid) {
			value = -1;
		}
		else if (esfshootingdirectorid > pk.esfshootingdirectorid) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (nome < pk.nome) {
			value = -1;
		}
		else if (nome > pk.nome) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (cognome < pk.cognome) {
			value = -1;
		}
		else if (cognome > pk.cognome) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		value = DateUtil.compareTo(esfstartdata, pk.esfstartdata);

		if (value != 0) {
			return value;
		}

		if (categoryid < pk.categoryid) {
			value = -1;
		}
		else if (categoryid > pk.categoryid) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (numerotessera < pk.numerotessera) {
			value = -1;
		}
		else if (numerotessera > pk.numerotessera) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (codiceregione < pk.codiceregione) {
			value = -1;
		}
		else if (codiceregione > pk.codiceregione) {
			value = 1;
		}
		else {
			value = 0;
		}

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

		if (!(obj instanceof vw_datidirettoretiroPK)) {
			return false;
		}

		vw_datidirettoretiroPK pk = (vw_datidirettoretiroPK)obj;

		if ((esfshootingdirectorid == pk.esfshootingdirectorid) &&
				(nome == pk.nome) && (cognome == pk.cognome) &&
				(esfstartdata.equals(pk.esfstartdata)) &&
				(categoryid == pk.categoryid) &&
				(numerotessera == pk.numerotessera) &&
				(codiceregione == pk.codiceregione)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (String.valueOf(esfshootingdirectorid) + String.valueOf(nome) +
		String.valueOf(cognome) + esfstartdata.toString() +
		String.valueOf(categoryid) + String.valueOf(numerotessera) +
		String.valueOf(codiceregione)).hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(35);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("esfshootingdirectorid");
		sb.append(StringPool.EQUAL);
		sb.append(esfshootingdirectorid);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("nome");
		sb.append(StringPool.EQUAL);
		sb.append(nome);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("cognome");
		sb.append(StringPool.EQUAL);
		sb.append(cognome);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("esfstartdata");
		sb.append(StringPool.EQUAL);
		sb.append(esfstartdata);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("categoryid");
		sb.append(StringPool.EQUAL);
		sb.append(categoryid);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("numerotessera");
		sb.append(StringPool.EQUAL);
		sb.append(numerotessera);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("codiceregione");
		sb.append(StringPool.EQUAL);
		sb.append(codiceregione);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}