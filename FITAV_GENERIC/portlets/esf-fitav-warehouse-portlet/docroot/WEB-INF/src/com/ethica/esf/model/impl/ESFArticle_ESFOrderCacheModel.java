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

import com.ethica.esf.model.ESFArticle_ESFOrder;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ESFArticle_ESFOrder in entity cache.
 *
 * @author Ethica
 * @see ESFArticle_ESFOrder
 * @generated
 */
public class ESFArticle_ESFOrderCacheModel implements CacheModel<ESFArticle_ESFOrder>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{esfArticleId=");
		sb.append(esfArticleId);
		sb.append(", esfOrderId=");
		sb.append(esfOrderId);
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
		sb.append(", totalQty=");
		sb.append(totalQty);
		sb.append(", price=");
		sb.append(price);
		sb.append(", vat=");
		sb.append(vat);
		sb.append(", sale=");
		sb.append(sale);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ESFArticle_ESFOrder toEntityModel() {
		ESFArticle_ESFOrderImpl esfArticle_ESFOrderImpl = new ESFArticle_ESFOrderImpl();

		esfArticle_ESFOrderImpl.setEsfArticleId(esfArticleId);
		esfArticle_ESFOrderImpl.setEsfOrderId(esfOrderId);
		esfArticle_ESFOrderImpl.setXxxlQty(xxxlQty);
		esfArticle_ESFOrderImpl.setXxlQty(xxlQty);
		esfArticle_ESFOrderImpl.setXlQty(xlQty);
		esfArticle_ESFOrderImpl.setLQty(lQty);
		esfArticle_ESFOrderImpl.setMQty(mQty);
		esfArticle_ESFOrderImpl.setSQty(sQty);
		esfArticle_ESFOrderImpl.setXsQty(xsQty);
		esfArticle_ESFOrderImpl.setXxsQty(xxsQty);
		esfArticle_ESFOrderImpl.setOtherQty(otherQty);
		esfArticle_ESFOrderImpl.setTotalQty(totalQty);
		esfArticle_ESFOrderImpl.setPrice(price);
		esfArticle_ESFOrderImpl.setVat(vat);
		esfArticle_ESFOrderImpl.setSale(sale);

		esfArticle_ESFOrderImpl.resetOriginalValues();

		return esfArticle_ESFOrderImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		esfArticleId = objectInput.readLong();
		esfOrderId = objectInput.readLong();
		xxxlQty = objectInput.readLong();
		xxlQty = objectInput.readLong();
		xlQty = objectInput.readLong();
		lQty = objectInput.readLong();
		mQty = objectInput.readLong();
		sQty = objectInput.readLong();
		xsQty = objectInput.readLong();
		xxsQty = objectInput.readLong();
		otherQty = objectInput.readLong();
		totalQty = objectInput.readLong();
		price = objectInput.readDouble();
		vat = objectInput.readDouble();
		sale = objectInput.readDouble();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(esfArticleId);
		objectOutput.writeLong(esfOrderId);
		objectOutput.writeLong(xxxlQty);
		objectOutput.writeLong(xxlQty);
		objectOutput.writeLong(xlQty);
		objectOutput.writeLong(lQty);
		objectOutput.writeLong(mQty);
		objectOutput.writeLong(sQty);
		objectOutput.writeLong(xsQty);
		objectOutput.writeLong(xxsQty);
		objectOutput.writeLong(otherQty);
		objectOutput.writeLong(totalQty);
		objectOutput.writeDouble(price);
		objectOutput.writeDouble(vat);
		objectOutput.writeDouble(sale);
	}

	public long esfArticleId;
	public long esfOrderId;
	public long xxxlQty;
	public long xxlQty;
	public long xlQty;
	public long lQty;
	public long mQty;
	public long sQty;
	public long xsQty;
	public long xxsQty;
	public long otherQty;
	public long totalQty;
	public double price;
	public double vat;
	public double sale;
}