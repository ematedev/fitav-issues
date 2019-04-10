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
public class ProvincePK implements Comparable<ProvincePK>, Serializable {
	public ProvincePK(String idProvince, String idRegion, String idCountry) {
		this.idProvince = idProvince;
		this.idRegion = idRegion;
		this.idCountry = idCountry;
	}

	@Override
	public int compareTo(ProvincePK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		value = idProvince.compareTo(pk.idProvince);

		if (value != 0) {
			return value;
		}

		value = idRegion.compareTo(pk.idRegion);

		if (value != 0) {
			return value;
		}

		value = idCountry.compareTo(pk.idCountry);

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

		if (!(obj instanceof ProvincePK)) {
			return false;
		}

		ProvincePK pk = (ProvincePK)obj;

		if ((idProvince.equals(pk.idProvince)) &&
			(idRegion.equals(pk.idRegion)) &&
			(idCountry.equals(pk.idCountry))) {
			return true;
		}
		else {
			return false;
		}
	}

	public String getIdCountry() {
		return idCountry;
	}

	public String getIdProvince() {
		return idProvince;
	}

	public String getIdRegion() {
		return idRegion;
	}

	@Override
	public int hashCode() {
		return (String.valueOf(idProvince) + String.valueOf(idRegion) +
		String.valueOf(idCountry)).hashCode();
	}

	public void setIdCountry(String idCountry) {
		this.idCountry = idCountry;
	}

	public void setIdProvince(String idProvince) {
		this.idProvince = idProvince;
	}

	public void setIdRegion(String idRegion) {
		this.idRegion = idRegion;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("idProvince");
		sb.append(StringPool.EQUAL);
		sb.append(idProvince);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("idRegion");
		sb.append(StringPool.EQUAL);
		sb.append(idRegion);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("idCountry");
		sb.append(StringPool.EQUAL);
		sb.append(idCountry);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	} public ProvincePK() {
	}

	public String idCountry;
	public String idProvince;
	public String idRegion;

}