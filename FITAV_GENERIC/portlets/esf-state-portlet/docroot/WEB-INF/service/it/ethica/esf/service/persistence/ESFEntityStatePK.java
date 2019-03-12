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
public class ESFEntityStatePK implements Comparable<ESFEntityStatePK>,
	Serializable {
	public String className;
	public long classPk;
	public long stateId;

	public ESFEntityStatePK() {
	}

	public ESFEntityStatePK(String className, long classPk, long stateId) {
		this.className = className;
		this.classPk = classPk;
		this.stateId = stateId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public long getClassPk() {
		return classPk;
	}

	public void setClassPk(long classPk) {
		this.classPk = classPk;
	}

	public long getStateId() {
		return stateId;
	}

	public void setStateId(long stateId) {
		this.stateId = stateId;
	}

	@Override
	public int compareTo(ESFEntityStatePK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		value = className.compareTo(pk.className);

		if (value != 0) {
			return value;
		}

		if (classPk < pk.classPk) {
			value = -1;
		}
		else if (classPk > pk.classPk) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (stateId < pk.stateId) {
			value = -1;
		}
		else if (stateId > pk.stateId) {
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

		if (!(obj instanceof ESFEntityStatePK)) {
			return false;
		}

		ESFEntityStatePK pk = (ESFEntityStatePK)obj;

		if ((className.equals(pk.className)) && (classPk == pk.classPk) &&
				(stateId == pk.stateId)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (String.valueOf(className) + String.valueOf(classPk) +
		String.valueOf(stateId)).hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("className");
		sb.append(StringPool.EQUAL);
		sb.append(className);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("classPk");
		sb.append(StringPool.EQUAL);
		sb.append(classPk);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("stateId");
		sb.append(StringPool.EQUAL);
		sb.append(stateId);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}