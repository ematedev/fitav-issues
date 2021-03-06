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
public class RegionPK implements Comparable<RegionPK>, Serializable {
	public RegionPK(String idRegion, String idCountry) {
		this.idRegion = idRegion;
		this.idCountry = idCountry;
	}

	@Override
	public int compareTo(RegionPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

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

		if (!(obj instanceof RegionPK)) {
			return false;
		}

		RegionPK pk = (RegionPK)obj;

		if ((idRegion.equals(pk.idRegion)) && (idCountry.equals(pk.idCountry))) {
			return true;
		}
		else {
			return false;
		}
	}

	public String getIdCountry() {
		return idCountry;
	}

	public String getIdRegion() {
		return idRegion;
	}

	@Override
	public int hashCode() {
		return (String.valueOf(idRegion) + String.valueOf(idCountry)).hashCode();
	}

	public void setIdCountry(String idCountry) {
		this.idCountry = idCountry;
	}

	public void setIdRegion(String idRegion) {
		this.idRegion = idRegion;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(10);

		sb.append(StringPool.OPEN_CURLY_BRACE);

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
	} public RegionPK() {
	}

	public String idCountry;
	public String idRegion;

}