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
public class VW_AzzurriPK implements Comparable<VW_AzzurriPK>, Serializable {
	public long esfNationalId;
	public long esfSportTypeId;

	public VW_AzzurriPK() {
	}

	public VW_AzzurriPK(long esfNationalId, long esfSportTypeId) {
		this.esfNationalId = esfNationalId;
		this.esfSportTypeId = esfSportTypeId;
	}

	public long getEsfNationalId() {
		return esfNationalId;
	}

	public void setEsfNationalId(long esfNationalId) {
		this.esfNationalId = esfNationalId;
	}

	public long getEsfSportTypeId() {
		return esfSportTypeId;
	}

	public void setEsfSportTypeId(long esfSportTypeId) {
		this.esfSportTypeId = esfSportTypeId;
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

		if ((esfNationalId == pk.esfNationalId) &&
				(esfSportTypeId == pk.esfSportTypeId)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (String.valueOf(esfNationalId) + String.valueOf(esfSportTypeId)).hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(10);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("esfNationalId");
		sb.append(StringPool.EQUAL);
		sb.append(esfNationalId);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("esfSportTypeId");
		sb.append(StringPool.EQUAL);
		sb.append(esfSportTypeId);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}