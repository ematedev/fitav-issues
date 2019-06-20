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
public class VW_AzzurriPK implements Comparable<VW_AzzurriPK>, Serializable {
	public long esfNationalId;
	public long userId;
	public long esfSportTypeId;
	public long id_esf_raduno;

	public VW_AzzurriPK() {
	}

	public VW_AzzurriPK(long esfNationalId, long userId, long esfSportTypeId,
		long id_esf_raduno) {
		this.esfNationalId = esfNationalId;
		this.userId = userId;
		this.esfSportTypeId = esfSportTypeId;
		this.id_esf_raduno = id_esf_raduno;
	}

	public long getEsfNationalId() {
		return esfNationalId;
	}

	public void setEsfNationalId(long esfNationalId) {
		this.esfNationalId = esfNationalId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getEsfSportTypeId() {
		return esfSportTypeId;
	}

	public void setEsfSportTypeId(long esfSportTypeId) {
		this.esfSportTypeId = esfSportTypeId;
	}

	public long getId_esf_raduno() {
		return id_esf_raduno;
	}

	public void setId_esf_raduno(long id_esf_raduno) {
		this.id_esf_raduno = id_esf_raduno;
	}

	@Override
	public int compareTo(VW_AzzurriPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (esfNationalId < pk.esfNationalId) {
			value = -1;
		}
		else if (esfNationalId > pk.esfNationalId) {
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

		if (esfSportTypeId < pk.esfSportTypeId) {
			value = -1;
		}
		else if (esfSportTypeId > pk.esfSportTypeId) {
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

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof VW_AzzurriPK)) {
			return false;
		}

		VW_AzzurriPK pk = (VW_AzzurriPK)obj;

		if ((esfNationalId == pk.esfNationalId) && (userId == pk.userId) &&
				(esfSportTypeId == pk.esfSportTypeId) &&
				(id_esf_raduno == pk.id_esf_raduno)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (String.valueOf(esfNationalId) + String.valueOf(userId) +
		String.valueOf(esfSportTypeId) + String.valueOf(id_esf_raduno)).hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(20);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("esfNationalId");
		sb.append(StringPool.EQUAL);
		sb.append(esfNationalId);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("userId");
		sb.append(StringPool.EQUAL);
		sb.append(userId);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("esfSportTypeId");
		sb.append(StringPool.EQUAL);
		sb.append(esfSportTypeId);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("id_esf_raduno");
		sb.append(StringPool.EQUAL);
		sb.append(id_esf_raduno);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}