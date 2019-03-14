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

package it.ethica.esf.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import it.ethica.esf.model.ESFShooterAffiliationChrono;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ESFShooterAffiliationChrono in entity cache.
 *
 * @author Ethica
 * @see ESFShooterAffiliationChrono
 * @generated
 */
public class ESFShooterAffiliationChronoCacheModel implements CacheModel<ESFShooterAffiliationChrono>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{esfShooterAffiliationChronoId=");
		sb.append(esfShooterAffiliationChronoId);
		sb.append(", esfuserId=");
		sb.append(esfuserId);
		sb.append(", affiliationDate=");
		sb.append(affiliationDate);
		sb.append(", year=");
		sb.append(year);
		sb.append(", Vcampo=");
		sb.append(Vcampo);
		sb.append(", paymentDate=");
		sb.append(paymentDate);
		sb.append(", payment=");
		sb.append(payment);
		sb.append(", card=");
		sb.append(card);
		sb.append(", esfOrganization=");
		sb.append(esfOrganization);
		sb.append(", note=");
		sb.append(note);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ESFShooterAffiliationChrono toEntityModel() {
		ESFShooterAffiliationChronoImpl esfShooterAffiliationChronoImpl = new ESFShooterAffiliationChronoImpl();

		esfShooterAffiliationChronoImpl.setEsfShooterAffiliationChronoId(esfShooterAffiliationChronoId);
		esfShooterAffiliationChronoImpl.setEsfuserId(esfuserId);

		if (affiliationDate == Long.MIN_VALUE) {
			esfShooterAffiliationChronoImpl.setAffiliationDate(null);
		}
		else {
			esfShooterAffiliationChronoImpl.setAffiliationDate(new Date(
					affiliationDate));
		}

		esfShooterAffiliationChronoImpl.setYear(year);

		if (Vcampo == null) {
			esfShooterAffiliationChronoImpl.setVcampo(StringPool.BLANK);
		}
		else {
			esfShooterAffiliationChronoImpl.setVcampo(Vcampo);
		}

		if (paymentDate == Long.MIN_VALUE) {
			esfShooterAffiliationChronoImpl.setPaymentDate(null);
		}
		else {
			esfShooterAffiliationChronoImpl.setPaymentDate(new Date(paymentDate));
		}

		if (payment == null) {
			esfShooterAffiliationChronoImpl.setPayment(StringPool.BLANK);
		}
		else {
			esfShooterAffiliationChronoImpl.setPayment(payment);
		}

		if (card == null) {
			esfShooterAffiliationChronoImpl.setCard(StringPool.BLANK);
		}
		else {
			esfShooterAffiliationChronoImpl.setCard(card);
		}

		if (esfOrganization == null) {
			esfShooterAffiliationChronoImpl.setEsfOrganization(StringPool.BLANK);
		}
		else {
			esfShooterAffiliationChronoImpl.setEsfOrganization(esfOrganization);
		}

		if (note == null) {
			esfShooterAffiliationChronoImpl.setNote(StringPool.BLANK);
		}
		else {
			esfShooterAffiliationChronoImpl.setNote(note);
		}

		esfShooterAffiliationChronoImpl.resetOriginalValues();

		return esfShooterAffiliationChronoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		esfShooterAffiliationChronoId = objectInput.readLong();
		esfuserId = objectInput.readLong();
		affiliationDate = objectInput.readLong();
		year = objectInput.readInt();
		Vcampo = objectInput.readUTF();
		paymentDate = objectInput.readLong();
		payment = objectInput.readUTF();
		card = objectInput.readUTF();
		esfOrganization = objectInput.readUTF();
		note = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(esfShooterAffiliationChronoId);
		objectOutput.writeLong(esfuserId);
		objectOutput.writeLong(affiliationDate);
		objectOutput.writeInt(year);

		if (Vcampo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(Vcampo);
		}

		objectOutput.writeLong(paymentDate);

		if (payment == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(payment);
		}

		if (card == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(card);
		}

		if (esfOrganization == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(esfOrganization);
		}

		if (note == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(note);
		}
	}

	public long esfShooterAffiliationChronoId;
	public long esfuserId;
	public long affiliationDate;
	public int year;
	public String Vcampo;
	public long paymentDate;
	public String payment;
	public String card;
	public String esfOrganization;
	public String note;
}