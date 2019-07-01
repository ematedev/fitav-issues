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
 */
public class ESFStateAssEntityPK implements Comparable<ESFStateAssEntityPK>,
	Serializable {
	public long esfStateId;
	public String className;

	public ESFStateAssEntityPK() {
	}

	public ESFStateAssEntityPK(long esfStateId, String className) {
		this.esfStateId = esfStateId;
		this.className = className;
	}

	public long getEsfStateId() {
		return esfStateId;
	}

	public void setEsfStateId(long esfStateId) {
		this.esfStateId = esfStateId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	@Override
	public int compareTo(ESFStateAssEntityPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (esfStateId < pk.esfStateId) {
			value = -1;
		}
		else if (esfStateId > pk.esfStateId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		value = className.compareTo(pk.className);

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

		if (!(obj instanceof ESFStateAssEntityPK)) {
			return false;
		}

		ESFStateAssEntityPK pk = (ESFStateAssEntityPK)obj;

		if ((esfStateId == pk.esfStateId) && (className.equals(pk.className))) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (String.valueOf(esfStateId) + String.valueOf(className)).hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(10);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("esfStateId");
		sb.append(StringPool.EQUAL);
		sb.append(esfStateId);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("className");
		sb.append(StringPool.EQUAL);
		sb.append(className);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}