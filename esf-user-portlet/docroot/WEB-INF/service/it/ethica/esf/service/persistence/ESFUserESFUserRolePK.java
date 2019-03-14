/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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
public class ESFUserESFUserRolePK implements Comparable<ESFUserESFUserRolePK>,
	Serializable {
	public long esfUserRoleId;
	public long esfUserId;

	public ESFUserESFUserRolePK() {
	}

	public ESFUserESFUserRolePK(long esfUserRoleId, long esfUserId) {
		this.esfUserRoleId = esfUserRoleId;
		this.esfUserId = esfUserId;
	}

	public long getEsfUserRoleId() {
		return esfUserRoleId;
	}

	public void setEsfUserRoleId(long esfUserRoleId) {
		this.esfUserRoleId = esfUserRoleId;
	}

	public long getEsfUserId() {
		return esfUserId;
	}

	public void setEsfUserId(long esfUserId) {
		this.esfUserId = esfUserId;
	}

	@Override
	public int compareTo(ESFUserESFUserRolePK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (esfUserRoleId < pk.esfUserRoleId) {
			value = -1;
		}
		else if (esfUserRoleId > pk.esfUserRoleId) {
			value = 1;
		}
		else {
			value = 0;
		}

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

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFUserESFUserRolePK)) {
			return false;
		}

		ESFUserESFUserRolePK pk = (ESFUserESFUserRolePK)obj;

		if ((esfUserRoleId == pk.esfUserRoleId) && (esfUserId == pk.esfUserId)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (String.valueOf(esfUserRoleId) + String.valueOf(esfUserId)).hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(10);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("esfUserRoleId");
		sb.append(StringPool.EQUAL);
		sb.append(esfUserRoleId);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("esfUserId");
		sb.append(StringPool.EQUAL);
		sb.append(esfUserId);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}