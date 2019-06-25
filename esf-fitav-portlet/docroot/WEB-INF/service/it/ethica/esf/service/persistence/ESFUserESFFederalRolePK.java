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
public class ESFUserESFFederalRolePK implements Comparable<ESFUserESFFederalRolePK>,
	Serializable {
	public long esfUserId;
	public long esfFederalRoleId;
	public long startDate;

	public ESFUserESFFederalRolePK() {
	}

	public ESFUserESFFederalRolePK(long esfUserId, long esfFederalRoleId,
		long startDate) {
		this.esfUserId = esfUserId;
		this.esfFederalRoleId = esfFederalRoleId;
		this.startDate = startDate;
	}

	public long getEsfUserId() {
		return esfUserId;
	}

	public void setEsfUserId(long esfUserId) {
		this.esfUserId = esfUserId;
	}

	public long getEsfFederalRoleId() {
		return esfFederalRoleId;
	}

	public void setEsfFederalRoleId(long esfFederalRoleId) {
		this.esfFederalRoleId = esfFederalRoleId;
	}

	public long getStartDate() {
		return startDate;
	}

	public void setStartDate(long startDate) {
		this.startDate = startDate;
	}

	@Override
	public int compareTo(ESFUserESFFederalRolePK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

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

		if (esfFederalRoleId < pk.esfFederalRoleId) {
			value = -1;
		}
		else if (esfFederalRoleId > pk.esfFederalRoleId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (startDate < pk.startDate) {
			value = -1;
		}
		else if (startDate > pk.startDate) {
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

		if (!(obj instanceof ESFUserESFFederalRolePK)) {
			return false;
		}

		ESFUserESFFederalRolePK pk = (ESFUserESFFederalRolePK)obj;

		if ((esfUserId == pk.esfUserId) &&
				(esfFederalRoleId == pk.esfFederalRoleId) &&
				(startDate == pk.startDate)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (String.valueOf(esfUserId) + String.valueOf(esfFederalRoleId) +
		String.valueOf(startDate)).hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("esfUserId");
		sb.append(StringPool.EQUAL);
		sb.append(esfUserId);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("esfFederalRoleId");
		sb.append(StringPool.EQUAL);
		sb.append(esfFederalRoleId);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("startDate");
		sb.append(StringPool.EQUAL);
		sb.append(startDate);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}