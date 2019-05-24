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

import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

import java.util.Date;

/**
 * @author Ethica
 */
public class VW_ESFIncarichiFederaliPK implements Comparable<VW_ESFIncarichiFederaliPK>,
	Serializable {
	public long esfUserId;
	public long esfFederalRoleId;
	public long startDate;
	public Date endDate;
	public boolean active_;

	public VW_ESFIncarichiFederaliPK() {
	}

	public VW_ESFIncarichiFederaliPK(long esfUserId, long esfFederalRoleId,
		long startDate, Date endDate, boolean active_) {
		this.esfUserId = esfUserId;
		this.esfFederalRoleId = esfFederalRoleId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.active_ = active_;
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

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public boolean getActive_() {
		return active_;
	}

	public boolean isActive_() {
		return active_;
	}

	public void setActive_(boolean active_) {
		this.active_ = active_;
	}

	@Override
	public int compareTo(VW_ESFIncarichiFederaliPK pk) {
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

		value = DateUtil.compareTo(endDate, pk.endDate);

		if (value != 0) {
			return value;
		}

		if (!active_ && pk.active_) {
			value = -1;
		}
		else if (active_ && !pk.active_) {
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

		if (!(obj instanceof VW_ESFIncarichiFederaliPK)) {
			return false;
		}

		VW_ESFIncarichiFederaliPK pk = (VW_ESFIncarichiFederaliPK)obj;

		if ((esfUserId == pk.esfUserId) &&
				(esfFederalRoleId == pk.esfFederalRoleId) &&
				(startDate == pk.startDate) && (endDate.equals(pk.endDate)) &&
				(active_ == pk.active_)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (String.valueOf(esfUserId) + String.valueOf(esfFederalRoleId) +
		String.valueOf(startDate) + endDate.toString() +
		String.valueOf(active_)).hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

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

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("endDate");
		sb.append(StringPool.EQUAL);
		sb.append(endDate);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("active_");
		sb.append(StringPool.EQUAL);
		sb.append(active_);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}