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
public class ESFShooterQualificationESFTournamentPK implements Comparable<ESFShooterQualificationESFTournamentPK>,
	Serializable {
	public long esfShooterQualificationId;
	public long esfTournamentId;

	public ESFShooterQualificationESFTournamentPK() {
	}

	public ESFShooterQualificationESFTournamentPK(
		long esfShooterQualificationId, long esfTournamentId) {
		this.esfShooterQualificationId = esfShooterQualificationId;
		this.esfTournamentId = esfTournamentId;
	}

	public long getEsfShooterQualificationId() {
		return esfShooterQualificationId;
	}

	public void setEsfShooterQualificationId(long esfShooterQualificationId) {
		this.esfShooterQualificationId = esfShooterQualificationId;
	}

	public long getEsfTournamentId() {
		return esfTournamentId;
	}

	public void setEsfTournamentId(long esfTournamentId) {
		this.esfTournamentId = esfTournamentId;
	}

	@Override
	public int compareTo(ESFShooterQualificationESFTournamentPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (esfShooterQualificationId < pk.esfShooterQualificationId) {
			value = -1;
		}
		else if (esfShooterQualificationId > pk.esfShooterQualificationId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (esfTournamentId < pk.esfTournamentId) {
			value = -1;
		}
		else if (esfTournamentId > pk.esfTournamentId) {
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

		if (!(obj instanceof ESFShooterQualificationESFTournamentPK)) {
			return false;
		}

		ESFShooterQualificationESFTournamentPK pk = (ESFShooterQualificationESFTournamentPK)obj;

		if ((esfShooterQualificationId == pk.esfShooterQualificationId) &&
				(esfTournamentId == pk.esfTournamentId)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (String.valueOf(esfShooterQualificationId) +
		String.valueOf(esfTournamentId)).hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(10);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("esfShooterQualificationId");
		sb.append(StringPool.EQUAL);
		sb.append(esfShooterQualificationId);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("esfTournamentId");
		sb.append(StringPool.EQUAL);
		sb.append(esfTournamentId);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}