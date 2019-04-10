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

package it.ethica.esf.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import it.ethica.esf.model.ESFRenewal;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ESFRenewal in entity cache.
 *
 * @author Ethica
 * @see ESFRenewal
 * @generated
 */
public class ESFRenewalCacheModel implements CacheModel<ESFRenewal>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(41);

		sb.append("{esfRenewalId=");
		sb.append(esfRenewalId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", quantity=");
		sb.append(quantity);
		sb.append(", paymentReason=");
		sb.append(paymentReason);
		sb.append(", paymentType=");
		sb.append(paymentType);
		sb.append(", paymentDate=");
		sb.append(paymentDate);
		sb.append(", paymentReceived=");
		sb.append(paymentReceived);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", info=");
		sb.append(info);
		sb.append(", madeBy=");
		sb.append(madeBy);
		sb.append(", amount=");
		sb.append(amount);
		sb.append(", organizationId=");
		sb.append(organizationId);
		sb.append(", reportingYear=");
		sb.append(reportingYear);
		sb.append(", amountTotal=");
		sb.append(amountTotal);
		sb.append(", isTotal=");
		sb.append(isTotal);
		sb.append(", renewalFatherId=");
		sb.append(renewalFatherId);
		sb.append(", affiliates=");
		sb.append(affiliates);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ESFRenewal toEntityModel() {
		ESFRenewalImpl esfRenewalImpl = new ESFRenewalImpl();

		esfRenewalImpl.setEsfRenewalId(esfRenewalId);
		esfRenewalImpl.setCompanyId(companyId);
		esfRenewalImpl.setUserId(userId);

		if (modifiedDate == Long.MIN_VALUE) {
			esfRenewalImpl.setModifiedDate(null);
		}
		else {
			esfRenewalImpl.setModifiedDate(new Date(modifiedDate));
		}

		esfRenewalImpl.setQuantity(quantity);

		if (paymentReason == null) {
			esfRenewalImpl.setPaymentReason(StringPool.BLANK);
		}
		else {
			esfRenewalImpl.setPaymentReason(paymentReason);
		}

		if (paymentType == null) {
			esfRenewalImpl.setPaymentType(StringPool.BLANK);
		}
		else {
			esfRenewalImpl.setPaymentType(paymentType);
		}

		if (paymentDate == Long.MIN_VALUE) {
			esfRenewalImpl.setPaymentDate(null);
		}
		else {
			esfRenewalImpl.setPaymentDate(new Date(paymentDate));
		}

		esfRenewalImpl.setPaymentReceived(paymentReceived);

		if (createDate == Long.MIN_VALUE) {
			esfRenewalImpl.setCreateDate(null);
		}
		else {
			esfRenewalImpl.setCreateDate(new Date(createDate));
		}

		esfRenewalImpl.setGroupId(groupId);

		if (info == null) {
			esfRenewalImpl.setInfo(StringPool.BLANK);
		}
		else {
			esfRenewalImpl.setInfo(info);
		}

		if (madeBy == null) {
			esfRenewalImpl.setMadeBy(StringPool.BLANK);
		}
		else {
			esfRenewalImpl.setMadeBy(madeBy);
		}

		esfRenewalImpl.setAmount(amount);
		esfRenewalImpl.setOrganizationId(organizationId);
		esfRenewalImpl.setReportingYear(reportingYear);
		esfRenewalImpl.setAmountTotal(amountTotal);
		esfRenewalImpl.setIsTotal(isTotal);
		esfRenewalImpl.setRenewalFatherId(renewalFatherId);
		esfRenewalImpl.setAffiliates(affiliates);

		esfRenewalImpl.resetOriginalValues();

		return esfRenewalImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		esfRenewalId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		quantity = objectInput.readLong();
		paymentReason = objectInput.readUTF();
		paymentType = objectInput.readUTF();
		paymentDate = objectInput.readLong();
		paymentReceived = objectInput.readBoolean();
		createDate = objectInput.readLong();
		groupId = objectInput.readLong();
		info = objectInput.readUTF();
		madeBy = objectInput.readUTF();
		amount = objectInput.readDouble();
		organizationId = objectInput.readLong();
		reportingYear = objectInput.readInt();
		amountTotal = objectInput.readDouble();
		isTotal = objectInput.readBoolean();
		renewalFatherId = objectInput.readLong();
		affiliates = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(esfRenewalId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(quantity);

		if (paymentReason == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(paymentReason);
		}

		if (paymentType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(paymentType);
		}

		objectOutput.writeLong(paymentDate);
		objectOutput.writeBoolean(paymentReceived);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(groupId);

		if (info == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(info);
		}

		if (madeBy == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(madeBy);
		}

		objectOutput.writeDouble(amount);
		objectOutput.writeLong(organizationId);
		objectOutput.writeInt(reportingYear);
		objectOutput.writeDouble(amountTotal);
		objectOutput.writeBoolean(isTotal);
		objectOutput.writeLong(renewalFatherId);
		objectOutput.writeBoolean(affiliates);
	}

	public long esfRenewalId;
	public long companyId;
	public long userId;
	public long modifiedDate;
	public long quantity;
	public String paymentReason;
	public String paymentType;
	public long paymentDate;
	public boolean paymentReceived;
	public long createDate;
	public long groupId;
	public String info;
	public String madeBy;
	public double amount;
	public long organizationId;
	public int reportingYear;
	public double amountTotal;
	public boolean isTotal;
	public long renewalFatherId;
	public boolean affiliates;
}