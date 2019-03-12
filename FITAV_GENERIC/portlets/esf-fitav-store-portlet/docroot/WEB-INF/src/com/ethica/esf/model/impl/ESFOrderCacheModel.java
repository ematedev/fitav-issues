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

package com.ethica.esf.model.impl;

import com.ethica.esf.model.ESFOrder;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ESFOrder in entity cache.
 *
 * @author Ethica
 * @see ESFOrder
 * @generated
 */
public class ESFOrderCacheModel implements CacheModel<ESFOrder>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{esfOrderId=");
		sb.append(esfOrderId);
		sb.append(", code=");
		sb.append(code);
		sb.append(", data=");
		sb.append(data);
		sb.append(", description=");
		sb.append(description);
		sb.append(", esfStockistId=");
		sb.append(esfStockistId);
		sb.append(", qty=");
		sb.append(qty);
		sb.append(", esfArticleId=");
		sb.append(esfArticleId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ESFOrder toEntityModel() {
		ESFOrderImpl esfOrderImpl = new ESFOrderImpl();

		esfOrderImpl.setEsfOrderId(esfOrderId);

		if (code == null) {
			esfOrderImpl.setCode(StringPool.BLANK);
		}
		else {
			esfOrderImpl.setCode(code);
		}

		if (data == Long.MIN_VALUE) {
			esfOrderImpl.setData(null);
		}
		else {
			esfOrderImpl.setData(new Date(data));
		}

		if (description == null) {
			esfOrderImpl.setDescription(StringPool.BLANK);
		}
		else {
			esfOrderImpl.setDescription(description);
		}

		esfOrderImpl.setEsfStockistId(esfStockistId);
		esfOrderImpl.setQty(qty);
		esfOrderImpl.setEsfArticleId(esfArticleId);

		esfOrderImpl.resetOriginalValues();

		return esfOrderImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		esfOrderId = objectInput.readLong();
		code = objectInput.readUTF();
		data = objectInput.readLong();
		description = objectInput.readUTF();
		esfStockistId = objectInput.readLong();
		qty = objectInput.readLong();
		esfArticleId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(esfOrderId);

		if (code == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(code);
		}

		objectOutput.writeLong(data);

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeLong(esfStockistId);
		objectOutput.writeLong(qty);
		objectOutput.writeLong(esfArticleId);
	}

	public long esfOrderId;
	public String code;
	public long data;
	public String description;
	public long esfStockistId;
	public long qty;
	public long esfArticleId;
}