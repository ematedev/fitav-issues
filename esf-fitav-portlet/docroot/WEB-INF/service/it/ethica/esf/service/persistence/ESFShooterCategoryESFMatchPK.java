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
public class ESFShooterCategoryESFMatchPK implements Comparable<ESFShooterCategoryESFMatchPK>,
	Serializable {
	public long esfShooterCategoryId;
	public long esfMatchId;

	public ESFShooterCategoryESFMatchPK() {
	}

	public ESFShooterCategoryESFMatchPK(long esfShooterCategoryId,
		long esfMatchId) {
		this.esfShooterCategoryId = esfShooterCategoryId;
		this.esfMatchId = esfMatchId;
	}

	public long getEsfShooterCategoryId() {
		return esfShooterCategoryId;
	}

	public void setEsfShooterCategoryId(long esfShooterCategoryId) {
		this.esfShooterCategoryId = esfShooterCategoryId;
	}

	public long getEsfMatchId() {
		return esfMatchId;
	}

	public void setEsfMatchId(long esfMatchId) {
		this.esfMatchId = esfMatchId;
	}

	@Override
	public int compareTo(ESFShooterCategoryESFMatchPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (esfShooterCategoryId < pk.esfShooterCategoryId) {
			value = -1;
		}
		else if (esfShooterCategoryId > pk.esfShooterCategoryId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (esfMatchId < pk.esfMatchId) {
			value = -1;
		}
		else if (esfMatchId > pk.esfMatchId) {
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

		if (!(obj instanceof ESFShooterCategoryESFMatchPK)) {
			return false;
		}

		ESFShooterCategoryESFMatchPK pk = (ESFShooterCategoryESFMatchPK)obj;

		if ((esfShooterCategoryId == pk.esfShooterCategoryId) &&
				(esfMatchId == pk.esfMatchId)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (String.valueOf(esfShooterCategoryId) +
		String.valueOf(esfMatchId)).hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(10);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("esfShooterCategoryId");
		sb.append(StringPool.EQUAL);
		sb.append(esfShooterCategoryId);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("esfMatchId");
		sb.append(StringPool.EQUAL);
		sb.append(esfMatchId);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}