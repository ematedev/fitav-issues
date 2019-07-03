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
public class VW_StaffPK implements Comparable<VW_StaffPK>, Serializable {
	public long userId;
	public String regionId;
	public String provinceId;
	public long esfSportTypeId;

	public VW_StaffPK() {
	}

	public VW_StaffPK(long userId, String regionId, String provinceId,
		long esfSportTypeId) {
		this.userId = userId;
		this.regionId = regionId;
		this.provinceId = provinceId;
		this.esfSportTypeId = esfSportTypeId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getRegionId() {
		return regionId;
	}

	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}

	public String getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}

	public long getEsfSportTypeId() {
		return esfSportTypeId;
	}

	public void setEsfSportTypeId(long esfSportTypeId) {
		this.esfSportTypeId = esfSportTypeId;
	}

	@Override
	public int compareTo(VW_StaffPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

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

		value = regionId.compareTo(pk.regionId);

		if (value != 0) {
			return value;
		}

		value = provinceId.compareTo(pk.provinceId);

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

		if (!(obj instanceof VW_StaffPK)) {
			return false;
		}

		VW_StaffPK pk = (VW_StaffPK)obj;

		if ((userId == pk.userId) && (regionId.equals(pk.regionId)) &&
				(provinceId.equals(pk.provinceId)) &&
				(esfSportTypeId == pk.esfSportTypeId)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (String.valueOf(userId) + String.valueOf(regionId) +
		String.valueOf(provinceId) + String.valueOf(esfSportTypeId)).hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(20);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("userId");
		sb.append(StringPool.EQUAL);
		sb.append(userId);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("regionId");
		sb.append(StringPool.EQUAL);
		sb.append(regionId);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("provinceId");
		sb.append(StringPool.EQUAL);
		sb.append(provinceId);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("esfSportTypeId");
		sb.append(StringPool.EQUAL);
		sb.append(esfSportTypeId);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}