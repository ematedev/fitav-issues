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

package it.ethica.esf.renewal.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import it.ethica.esf.renewal.model.ESFRenewalCompany;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ESFRenewalCompany in entity cache.
 *
 * @author Ethica
 * @see ESFRenewalCompany
 * @generated
 */
public class ESFRenewalCompanyCacheModel implements CacheModel<ESFRenewalCompany>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(35);

		sb.append("{esfRenewalCompanyId=");
		sb.append(esfRenewalCompanyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", esfOrganizationId=");
		sb.append(esfOrganizationId);
		sb.append(", cardsNumber=");
		sb.append(cardsNumber);
		sb.append(", year=");
		sb.append(year);
		sb.append(", date=");
		sb.append(date);
		sb.append(", paymentType=");
		sb.append(paymentType);
		sb.append(", status=");
		sb.append(status);
		sb.append(", amount=");
		sb.append(amount);
		sb.append(", info=");
		sb.append(info);
		sb.append(", accountholder=");
		sb.append(accountholder);
		sb.append(", paymentDate=");
		sb.append(paymentDate);
		sb.append(", integrationAmount=");
		sb.append(integrationAmount);
		sb.append(", integrationDate=");
		sb.append(integrationDate);
		sb.append(", integrationType=");
		sb.append(integrationType);
		sb.append(", integrationAccountholder=");
		sb.append(integrationAccountholder);
		sb.append(", join=");
		sb.append(join);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ESFRenewalCompany toEntityModel() {
		ESFRenewalCompanyImpl esfRenewalCompanyImpl = new ESFRenewalCompanyImpl();

		esfRenewalCompanyImpl.setEsfRenewalCompanyId(esfRenewalCompanyId);
		esfRenewalCompanyImpl.setUserId(userId);
		esfRenewalCompanyImpl.setEsfOrganizationId(esfOrganizationId);
		esfRenewalCompanyImpl.setCardsNumber(cardsNumber);
		esfRenewalCompanyImpl.setYear(year);

		if (date == Long.MIN_VALUE) {
			esfRenewalCompanyImpl.setDate(null);
		}
		else {
			esfRenewalCompanyImpl.setDate(new Date(date));
		}

		esfRenewalCompanyImpl.setPaymentType(paymentType);
		esfRenewalCompanyImpl.setStatus(status);
		esfRenewalCompanyImpl.setAmount(amount);

		if (info == null) {
			esfRenewalCompanyImpl.setInfo(StringPool.BLANK);
		}
		else {
			esfRenewalCompanyImpl.setInfo(info);
		}

		if (accountholder == null) {
			esfRenewalCompanyImpl.setAccountholder(StringPool.BLANK);
		}
		else {
			esfRenewalCompanyImpl.setAccountholder(accountholder);
		}

		if (paymentDate == Long.MIN_VALUE) {
			esfRenewalCompanyImpl.setPaymentDate(null);
		}
		else {
			esfRenewalCompanyImpl.setPaymentDate(new Date(paymentDate));
		}

		esfRenewalCompanyImpl.setIntegrationAmount(integrationAmount);

		if (integrationDate == Long.MIN_VALUE) {
			esfRenewalCompanyImpl.setIntegrationDate(null);
		}
		else {
			esfRenewalCompanyImpl.setIntegrationDate(new Date(integrationDate));
		}

		esfRenewalCompanyImpl.setIntegrationType(integrationType);

		if (integrationAccountholder == null) {
			esfRenewalCompanyImpl.setIntegrationAccountholder(StringPool.BLANK);
		}
		else {
			esfRenewalCompanyImpl.setIntegrationAccountholder(integrationAccountholder);
		}

		esfRenewalCompanyImpl.setJoin(join);

		esfRenewalCompanyImpl.resetOriginalValues();

		return esfRenewalCompanyImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		esfRenewalCompanyId = objectInput.readLong();
		userId = objectInput.readLong();
		esfOrganizationId = objectInput.readLong();
		cardsNumber = objectInput.readInt();
		year = objectInput.readInt();
		date = objectInput.readLong();
		paymentType = objectInput.readInt();
		status = objectInput.readInt();
		amount = objectInput.readDouble();
		info = objectInput.readUTF();
		accountholder = objectInput.readUTF();
		paymentDate = objectInput.readLong();
		integrationAmount = objectInput.readDouble();
		integrationDate = objectInput.readLong();
		integrationType = objectInput.readInt();
		integrationAccountholder = objectInput.readUTF();
		join = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(esfRenewalCompanyId);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(esfOrganizationId);
		objectOutput.writeInt(cardsNumber);
		objectOutput.writeInt(year);
		objectOutput.writeLong(date);
		objectOutput.writeInt(paymentType);
		objectOutput.writeInt(status);
		objectOutput.writeDouble(amount);

		if (info == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(info);
		}

		if (accountholder == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(accountholder);
		}

		objectOutput.writeLong(paymentDate);
		objectOutput.writeDouble(integrationAmount);
		objectOutput.writeLong(integrationDate);
		objectOutput.writeInt(integrationType);

		if (integrationAccountholder == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(integrationAccountholder);
		}

		objectOutput.writeBoolean(join);
	}

	public long esfRenewalCompanyId;
	public long userId;
	public long esfOrganizationId;
	public int cardsNumber;
	public int year;
	public long date;
	public int paymentType;
	public int status;
	public double amount;
	public String info;
	public String accountholder;
	public long paymentDate;
	public double integrationAmount;
	public long integrationDate;
	public int integrationType;
	public String integrationAccountholder;
	public boolean join;
}