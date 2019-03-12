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

package com.ethica.esf.service.persistence;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

/**
 * @author Ethica
 */
public class ESFArticle_ESFOrderPK implements Comparable<ESFArticle_ESFOrderPK>,
	Serializable {
	public long esfArticleId;
	public long esfOrderId;

	public ESFArticle_ESFOrderPK() {
	}

	public ESFArticle_ESFOrderPK(long esfArticleId, long esfOrderId) {
		this.esfArticleId = esfArticleId;
		this.esfOrderId = esfOrderId;
	}

	public long getEsfArticleId() {
		return esfArticleId;
	}

	public void setEsfArticleId(long esfArticleId) {
		this.esfArticleId = esfArticleId;
	}

	public long getEsfOrderId() {
		return esfOrderId;
	}

	public void setEsfOrderId(long esfOrderId) {
		this.esfOrderId = esfOrderId;
	}

	@Override
	public int compareTo(ESFArticle_ESFOrderPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (esfArticleId < pk.esfArticleId) {
			value = -1;
		}
		else if (esfArticleId > pk.esfArticleId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (esfOrderId < pk.esfOrderId) {
			value = -1;
		}
		else if (esfOrderId > pk.esfOrderId) {
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

		if (!(obj instanceof ESFArticle_ESFOrderPK)) {
			return false;
		}

		ESFArticle_ESFOrderPK pk = (ESFArticle_ESFOrderPK)obj;

		if ((esfArticleId == pk.esfArticleId) && (esfOrderId == pk.esfOrderId)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (String.valueOf(esfArticleId) + String.valueOf(esfOrderId)).hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(10);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("esfArticleId");
		sb.append(StringPool.EQUAL);
		sb.append(esfArticleId);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("esfOrderId");
		sb.append(StringPool.EQUAL);
		sb.append(esfOrderId);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}