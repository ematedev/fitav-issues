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
public class ESFOrganizationUnitservicePK implements Comparable<ESFOrganizationUnitservicePK>,
	Serializable {
	public ESFOrganizationUnitservicePK() {
	}

	public ESFOrganizationUnitservicePK(long eSFOrganizationUnitserviceId,
		long esfOrganizationId, long esfUnitserviceId) {
		this.eSFOrganizationUnitserviceId = eSFOrganizationUnitserviceId;
		this.esfOrganizationId = esfOrganizationId;
		this.esfUnitserviceId = esfUnitserviceId;
	}

	@Override
	public int compareTo(ESFOrganizationUnitservicePK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (eSFOrganizationUnitserviceId < pk.eSFOrganizationUnitserviceId) {
			value = -1;
		}
		else if (eSFOrganizationUnitserviceId > pk.eSFOrganizationUnitserviceId) {
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

		if (esfUnitserviceId < pk.esfUnitserviceId) {
			value = -1;
		}
		else if (esfUnitserviceId > pk.esfUnitserviceId) {
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

		if (!(obj instanceof ESFOrganizationUnitservicePK)) {
			return false;
		}

		ESFOrganizationUnitservicePK pk = (ESFOrganizationUnitservicePK)obj;

		if ((eSFOrganizationUnitserviceId == pk.eSFOrganizationUnitserviceId) &&
			(esfOrganizationId == pk.esfOrganizationId) &&
			(esfUnitserviceId == pk.esfUnitserviceId)) {
			return true;
		}
		else {
			return false;
		}
	}

	public long getEsfOrganizationId() {
		return esfOrganizationId;
	}

	public long getESFOrganizationUnitserviceId() {
		return eSFOrganizationUnitserviceId;
	}

	public long getEsfUnitserviceId() {
		return esfUnitserviceId;
	}

	@Override
	public int hashCode() {
		return (String.valueOf(eSFOrganizationUnitserviceId) +
		String.valueOf(esfOrganizationId) + String.valueOf(esfUnitserviceId)).hashCode();
	}

	public void setEsfOrganizationId(long esfOrganizationId) {
		this.esfOrganizationId = esfOrganizationId;
	}

	public void setESFOrganizationUnitserviceId(
		long eSFOrganizationUnitserviceId) {
		this.eSFOrganizationUnitserviceId = eSFOrganizationUnitserviceId;
	}

	public void setEsfUnitserviceId(long esfUnitserviceId) {
		this.esfUnitserviceId = esfUnitserviceId;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("eSFOrganizationUnitserviceId");
		sb.append(StringPool.EQUAL);
		sb.append(eSFOrganizationUnitserviceId);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("esfOrganizationId");
		sb.append(StringPool.EQUAL);
		sb.append(esfOrganizationId);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("esfUnitserviceId");
		sb.append(StringPool.EQUAL);
		sb.append(esfUnitserviceId);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	} public long esfUnitserviceId;

	public long esfOrganizationId;
	public long eSFOrganizationUnitserviceId;

}