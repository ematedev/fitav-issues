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
public class ESFNationalDelegationPK implements Comparable<ESFNationalDelegationPK>,
	Serializable {
	public long esfTournamentId;
	public long esfUserId;

	public ESFNationalDelegationPK() {
	}

	public ESFNationalDelegationPK(long esfTournamentId, long esfUserId) {
		this.esfTournamentId = esfTournamentId;
		this.esfUserId = esfUserId;
	}

	public long getEsfTournamentId() {
		return esfTournamentId;
	}

	public void setEsfTournamentId(long esfTournamentId) {
		this.esfTournamentId = esfTournamentId;
	}

	public long getEsfUserId() {
		return esfUserId;
	}

	public void setEsfUserId(long esfUserId) {
		this.esfUserId = esfUserId;
	}

	@Override
	public int compareTo(ESFNationalDelegationPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

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

		if (!(obj instanceof ESFNationalDelegationPK)) {
			return false;
		}

		ESFNationalDelegationPK pk = (ESFNationalDelegationPK)obj;

		if ((esfTournamentId == pk.esfTournamentId) &&
				(esfUserId == pk.esfUserId)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (String.valueOf(esfTournamentId) + String.valueOf(esfUserId)).hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(10);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("esfTournamentId");
		sb.append(StringPool.EQUAL);
		sb.append(esfTournamentId);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("esfUserId");
		sb.append(StringPool.EQUAL);
		sb.append(esfUserId);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}