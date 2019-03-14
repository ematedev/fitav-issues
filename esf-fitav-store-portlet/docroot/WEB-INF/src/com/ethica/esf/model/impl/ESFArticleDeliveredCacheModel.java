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

import com.ethica.esf.model.ESFArticleDelivered;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ESFArticleDelivered in entity cache.
 *
 * @author Ethica
 * @see ESFArticleDelivered
 * @generated
 */
public class ESFArticleDeliveredCacheModel implements CacheModel<ESFArticleDelivered>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{esfArticleDeliveredId=");
		sb.append(esfArticleDeliveredId);
		sb.append(", data=");
		sb.append(data);
		sb.append(", description=");
		sb.append(description);
		sb.append(", esfArticleId=");
		sb.append(esfArticleId);
		sb.append(", esfShooterId=");
		sb.append(esfShooterId);
		sb.append(", xxxlQty=");
		sb.append(xxxlQty);
		sb.append(", xxlQty=");
		sb.append(xxlQty);
		sb.append(", xlQty=");
		sb.append(xlQty);
		sb.append(", lQty=");
		sb.append(lQty);
		sb.append(", mQty=");
		sb.append(mQty);
		sb.append(", sQty=");
		sb.append(sQty);
		sb.append(", xsQty=");
		sb.append(xsQty);
		sb.append(", xxsQty=");
		sb.append(xxsQty);
		sb.append(", otherQty=");
		sb.append(otherQty);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ESFArticleDelivered toEntityModel() {
		ESFArticleDeliveredImpl esfArticleDeliveredImpl = new ESFArticleDeliveredImpl();

		esfArticleDeliveredImpl.setEsfArticleDeliveredId(esfArticleDeliveredId);

		if (data == Long.MIN_VALUE) {
			esfArticleDeliveredImpl.setData(null);
		}
		else {
			esfArticleDeliveredImpl.setData(new Date(data));
		}

		if (description == null) {
			esfArticleDeliveredImpl.setDescription(StringPool.BLANK);
		}
		else {
			esfArticleDeliveredImpl.setDescription(description);
		}

		esfArticleDeliveredImpl.setEsfArticleId(esfArticleId);
		esfArticleDeliveredImpl.setEsfShooterId(esfShooterId);
		esfArticleDeliveredImpl.setXxxlQty(xxxlQty);
		esfArticleDeliveredImpl.setXxlQty(xxlQty);
		esfArticleDeliveredImpl.setXlQty(xlQty);
		esfArticleDeliveredImpl.setLQty(lQty);
		esfArticleDeliveredImpl.setMQty(mQty);
		esfArticleDeliveredImpl.setSQty(sQty);
		esfArticleDeliveredImpl.setXsQty(xsQty);
		esfArticleDeliveredImpl.setXxsQty(xxsQty);
		esfArticleDeliveredImpl.setOtherQty(otherQty);

		esfArticleDeliveredImpl.resetOriginalValues();

		return esfArticleDeliveredImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		esfArticleDeliveredId = objectInput.readLong();
		data = objectInput.readLong();
		description = objectInput.readUTF();
		esfArticleId = objectInput.readLong();
		esfShooterId = objectInput.readLong();
		xxxlQty = objectInput.readLong();
		xxlQty = objectInput.readLong();
		xlQty = objectInput.readLong();
		lQty = objectInput.readLong();
		mQty = objectInput.readLong();
		sQty = objectInput.readLong();
		xsQty = objectInput.readLong();
		xxsQty = objectInput.readLong();
		otherQty = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(esfArticleDeliveredId);
		objectOutput.writeLong(data);

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeLong(esfArticleId);
		objectOutput.writeLong(esfShooterId);
		objectOutput.writeLong(xxxlQty);
		objectOutput.writeLong(xxlQty);
		objectOutput.writeLong(xlQty);
		objectOutput.writeLong(lQty);
		objectOutput.writeLong(mQty);
		objectOutput.writeLong(sQty);
		objectOutput.writeLong(xsQty);
		objectOutput.writeLong(xxsQty);
		objectOutput.writeLong(otherQty);
	}

	public long esfArticleDeliveredId;
	public long data;
	public String description;
	public long esfArticleId;
	public long esfShooterId;
	public long xxxlQty;
	public long xxlQty;
	public long xlQty;
	public long lQty;
	public long mQty;
	public long sQty;
	public long xsQty;
	public long xxsQty;
	public long otherQty;
}