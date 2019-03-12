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
public class ESFFederalRoleESFSpecificPK implements Comparable<ESFFederalRoleESFSpecificPK>,
	Serializable {
	public long esfSpecificId;
	public long esfFederalRoleId;

	public ESFFederalRoleESFSpecificPK() {
	}

	public ESFFederalRoleESFSpecificPK(long esfSpecificId, long esfFederalRoleId) {
		this.esfSpecificId = esfSpecificId;
		this.esfFederalRoleId = esfFederalRoleId;
	}

	public long getEsfSpecificId() {
		return esfSpecificId;
	}

	public void setEsfSpecificId(long esfSpecificId) {
		this.esfSpecificId = esfSpecificId;
	}

	public long getEsfFederalRoleId() {
		return esfFederalRoleId;
	}

	public void setEsfFederalRoleId(long esfFederalRoleId) {
		this.esfFederalRoleId = esfFederalRoleId;
	}

	@Override
	public int compareTo(ESFFederalRoleESFSpecificPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (esfSpecificId < pk.esfSpecificId) {
			value = -1;
		}
		else if (esfSpecificId > pk.esfSpecificId) {
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

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFFederalRoleESFSpecificPK)) {
			return false;
		}

		ESFFederalRoleESFSpecificPK pk = (ESFFederalRoleESFSpecificPK)obj;

		if ((esfSpecificId == pk.esfSpecificId) &&
				(esfFederalRoleId == pk.esfFederalRoleId)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (String.valueOf(esfSpecificId) +
		String.valueOf(esfFederalRoleId)).hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(10);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("esfSpecificId");
		sb.append(StringPool.EQUAL);
		sb.append(esfSpecificId);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("esfFederalRoleId");
		sb.append(StringPool.EQUAL);
		sb.append(esfFederalRoleId);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}