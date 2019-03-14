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

import com.ethica.esf.model.ESFBill;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ESFBill in entity cache.
 *
 * @author Ethica
 * @see ESFBill
 * @generated
 */
public class ESFBillCacheModel implements CacheModel<ESFBill>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{esfBillId=");
		sb.append(esfBillId);
		sb.append(", esfArticleId=");
		sb.append(esfArticleId);
		sb.append(", esfOrderId=");
		sb.append(esfOrderId);
		sb.append(", billNumber=");
		sb.append(billNumber);
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
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ESFBill toEntityModel() {
		ESFBillImpl esfBillImpl = new ESFBillImpl();

		esfBillImpl.setEsfBillId(esfBillId);
		esfBillImpl.setEsfArticleId(esfArticleId);
		esfBillImpl.setEsfOrderId(esfOrderId);

		if (billNumber == null) {
			esfBillImpl.setBillNumber(StringPool.BLANK);
		}
		else {
			esfBillImpl.setBillNumber(billNumber);
		}

		esfBillImpl.setXxxlQty(xxxlQty);
		esfBillImpl.setXxlQty(xxlQty);
		esfBillImpl.setXlQty(xlQty);
		esfBillImpl.setLQty(lQty);
		esfBillImpl.setMQty(mQty);
		esfBillImpl.setSQty(sQty);
		esfBillImpl.setXsQty(xsQty);
		esfBillImpl.setXxsQty(xxsQty);
		esfBillImpl.setOtherQty(otherQty);
		esfBillImpl.setTotalQty(totalQty);

		esfBillImpl.resetOriginalValues();

		return esfBillImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		esfBillId = objectInput.readLong();
		esfArticleId = objectInput.readLong();
		esfOrderId = objectInput.readLong();
		billNumber = objectInput.readUTF();
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
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(esfBillId);
		objectOutput.writeLong(esfArticleId);
		objectOutput.writeLong(esfOrderId);

		if (billNumber == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(billNumber);
		}

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
	}

	public long esfBillId;
	public long esfArticleId;
	public long esfOrderId;
	public String billNumber;
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
}