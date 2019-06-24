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
 */
public class EsfRadunoShootersPK implements Comparable<EsfRadunoShootersPK>,
	Serializable {
	public long id_esf_raduno_shooters;
	public long id_esf_raduno;
	public long userId;

	public EsfRadunoShootersPK() {
	}

	public EsfRadunoShootersPK(long id_esf_raduno_shooters, long id_esf_raduno,
		long userId) {
		this.id_esf_raduno_shooters = id_esf_raduno_shooters;
		this.id_esf_raduno = id_esf_raduno;
		this.userId = userId;
	}

	public long getId_esf_raduno_shooters() {
		return id_esf_raduno_shooters;
	}

	public void setId_esf_raduno_shooters(long id_esf_raduno_shooters) {
		this.id_esf_raduno_shooters = id_esf_raduno_shooters;
	}

	public long getId_esf_raduno() {
		return id_esf_raduno;
	}

	public void setId_esf_raduno(long id_esf_raduno) {
		this.id_esf_raduno = id_esf_raduno;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	@Override
	public int compareTo(EsfRadunoShootersPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (id_esf_raduno_shooters < pk.id_esf_raduno_shooters) {
			value = -1;
		}
		else if (id_esf_raduno_shooters > pk.id_esf_raduno_shooters) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (id_esf_raduno < pk.id_esf_raduno) {
			value = -1;
		}
		else if (id_esf_raduno > pk.id_esf_raduno) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (userId < pk.userId) {
			value = -1;
		}
		else if (userId > pk.userId) {
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

		if (!(obj instanceof EsfRadunoShootersPK)) {
			return false;
		}

		EsfRadunoShootersPK pk = (EsfRadunoShootersPK)obj;

		if ((id_esf_raduno_shooters == pk.id_esf_raduno_shooters) &&
				(id_esf_raduno == pk.id_esf_raduno) && (userId == pk.userId)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (String.valueOf(id_esf_raduno_shooters) +
		String.valueOf(id_esf_raduno) + String.valueOf(userId)).hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("id_esf_raduno_shooters");
		sb.append(StringPool.EQUAL);
		sb.append(id_esf_raduno_shooters);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("id_esf_raduno");
		sb.append(StringPool.EQUAL);
		sb.append(id_esf_raduno);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("userId");
		sb.append(StringPool.EQUAL);
		sb.append(userId);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}