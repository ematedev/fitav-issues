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

import com.ethica.esf.model.ESFArticle_ESFUser;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ESFArticle_ESFUser in entity cache.
 *
 * @author Ethica
 * @see ESFArticle_ESFUser
 * @generated
 */
public class ESFArticle_ESFUserCacheModel implements CacheModel<ESFArticle_ESFUser>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{esfArticleId=");
		sb.append(esfArticleId);
		sb.append(", esfUserId=");
		sb.append(esfUserId);
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
		sb.append(", description=");
		sb.append(description);
		sb.append(", deliveryDate=");
		sb.append(deliveryDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ESFArticle_ESFUser toEntityModel() {
		ESFArticle_ESFUserImpl esfArticle_ESFUserImpl = new ESFArticle_ESFUserImpl();

		esfArticle_ESFUserImpl.setEsfArticleId(esfArticleId);
		esfArticle_ESFUserImpl.setEsfUserId(esfUserId);
		esfArticle_ESFUserImpl.setXxxlQty(xxxlQty);
		esfArticle_ESFUserImpl.setXxlQty(xxlQty);
		esfArticle_ESFUserImpl.setXlQty(xlQty);
		esfArticle_ESFUserImpl.setLQty(lQty);
		esfArticle_ESFUserImpl.setMQty(mQty);
		esfArticle_ESFUserImpl.setSQty(sQty);
		esfArticle_ESFUserImpl.setXsQty(xsQty);
		esfArticle_ESFUserImpl.setXxsQty(xxsQty);
		esfArticle_ESFUserImpl.setOtherQty(otherQty);
		esfArticle_ESFUserImpl.setTotalQty(totalQty);

		if (description == null) {
			esfArticle_ESFUserImpl.setDescription(StringPool.BLANK);
		}
		else {
			esfArticle_ESFUserImpl.setDescription(description);
		}

		if (deliveryDate == Long.MIN_VALUE) {
			esfArticle_ESFUserImpl.setDeliveryDate(null);
		}
		else {
			esfArticle_ESFUserImpl.setDeliveryDate(new Date(deliveryDate));
		}

		esfArticle_ESFUserImpl.resetOriginalValues();

		return esfArticle_ESFUserImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		esfArticleId = objectInput.readLong();
		esfUserId = objectInput.readLong();
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
		description = objectInput.readUTF();
		deliveryDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(esfArticleId);
		objectOutput.writeLong(esfUserId);
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

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeLong(deliveryDate);
	}

	public long esfArticleId;
	public long esfUserId;
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
	public String description;
	public long deliveryDate;
}