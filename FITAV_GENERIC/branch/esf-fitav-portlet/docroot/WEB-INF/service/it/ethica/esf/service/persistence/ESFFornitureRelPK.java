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
 * @generated
 */
public class ESFFornitureRelPK implements Comparable<ESFFornitureRelPK>,
	Serializable {
	public long esfToolId;
	public String className;
	public long classPK;

	public ESFFornitureRelPK() {
	}

	public ESFFornitureRelPK(long esfToolId, String className, long classPK) {
		this.esfToolId = esfToolId;
		this.className = className;
		this.classPK = classPK;
	}

	public long getEsfToolId() {
		return esfToolId;
	}

	public void setEsfToolId(long esfToolId) {
		this.esfToolId = esfToolId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public long getClassPK() {
		return classPK;
	}

	public void setClassPK(long classPK) {
		this.classPK = classPK;
	}

	@Override
	public int compareTo(ESFFornitureRelPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (esfToolId < pk.esfToolId) {
			value = -1;
		}
		else if (esfToolId > pk.esfToolId) {
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

		if (classPK < pk.classPK) {
			value = -1;
		}
		else if (classPK > pk.classPK) {
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

		if (!(obj instanceof ESFFornitureRelPK)) {
			return false;
		}

		ESFFornitureRelPK pk = (ESFFornitureRelPK)obj;

		if ((esfToolId == pk.esfToolId) && (className.equals(pk.className)) &&
				(classPK == pk.classPK)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (String.valueOf(esfToolId) + String.valueOf(className) +
		String.valueOf(classPK)).hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("esfToolId");
		sb.append(StringPool.EQUAL);
		sb.append(esfToolId);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("className");
		sb.append(StringPool.EQUAL);
		sb.append(className);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("classPK");
		sb.append(StringPool.EQUAL);
		sb.append(classPK);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}