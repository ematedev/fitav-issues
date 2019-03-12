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

import com.ethica.esf.model.ESFStockist;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ESFStockist in entity cache.
 *
 * @author Ethica
 * @see ESFStockist
 * @generated
 */
public class ESFStockistCacheModel implements CacheModel<ESFStockist>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{esfStockistId=");
		sb.append(esfStockistId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", email=");
		sb.append(email);
		sb.append(", phone=");
		sb.append(phone);
		sb.append(", address=");
		sb.append(address);
		sb.append(", description=");
		sb.append(description);
		sb.append(", other=");
		sb.append(other);
		sb.append(", nameReference=");
		sb.append(nameReference);
		sb.append(", lastNameReference=");
		sb.append(lastNameReference);
		sb.append(", emailReference=");
		sb.append(emailReference);
		sb.append(", phoneReference=");
		sb.append(phoneReference);
		sb.append(", vatNumber=");
		sb.append(vatNumber);
		sb.append(", iban=");
		sb.append(iban);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ESFStockist toEntityModel() {
		ESFStockistImpl esfStockistImpl = new ESFStockistImpl();

		esfStockistImpl.setEsfStockistId(esfStockistId);

		if (name == null) {
			esfStockistImpl.setName(StringPool.BLANK);
		}
		else {
			esfStockistImpl.setName(name);
		}

		if (email == null) {
			esfStockistImpl.setEmail(StringPool.BLANK);
		}
		else {
			esfStockistImpl.setEmail(email);
		}

		if (phone == null) {
			esfStockistImpl.setPhone(StringPool.BLANK);
		}
		else {
			esfStockistImpl.setPhone(phone);
		}

		if (address == null) {
			esfStockistImpl.setAddress(StringPool.BLANK);
		}
		else {
			esfStockistImpl.setAddress(address);
		}

		if (description == null) {
			esfStockistImpl.setDescription(StringPool.BLANK);
		}
		else {
			esfStockistImpl.setDescription(description);
		}

		if (other == null) {
			esfStockistImpl.setOther(StringPool.BLANK);
		}
		else {
			esfStockistImpl.setOther(other);
		}

		if (nameReference == null) {
			esfStockistImpl.setNameReference(StringPool.BLANK);
		}
		else {
			esfStockistImpl.setNameReference(nameReference);
		}

		if (lastNameReference == null) {
			esfStockistImpl.setLastNameReference(StringPool.BLANK);
		}
		else {
			esfStockistImpl.setLastNameReference(lastNameReference);
		}

		if (emailReference == null) {
			esfStockistImpl.setEmailReference(StringPool.BLANK);
		}
		else {
			esfStockistImpl.setEmailReference(emailReference);
		}

		if (phoneReference == null) {
			esfStockistImpl.setPhoneReference(StringPool.BLANK);
		}
		else {
			esfStockistImpl.setPhoneReference(phoneReference);
		}

		if (vatNumber == null) {
			esfStockistImpl.setVatNumber(StringPool.BLANK);
		}
		else {
			esfStockistImpl.setVatNumber(vatNumber);
		}

		if (iban == null) {
			esfStockistImpl.setIban(StringPool.BLANK);
		}
		else {
			esfStockistImpl.setIban(iban);
		}

		esfStockistImpl.resetOriginalValues();

		return esfStockistImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		esfStockistId = objectInput.readLong();
		name = objectInput.readUTF();
		email = objectInput.readUTF();
		phone = objectInput.readUTF();
		address = objectInput.readUTF();
		description = objectInput.readUTF();
		other = objectInput.readUTF();
		nameReference = objectInput.readUTF();
		lastNameReference = objectInput.readUTF();
		emailReference = objectInput.readUTF();
		phoneReference = objectInput.readUTF();
		vatNumber = objectInput.readUTF();
		iban = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(esfStockistId);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (email == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(email);
		}

		if (phone == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(phone);
		}

		if (address == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(address);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (other == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(other);
		}

		if (nameReference == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(nameReference);
		}

		if (lastNameReference == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(lastNameReference);
		}

		if (emailReference == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(emailReference);
		}

		if (phoneReference == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(phoneReference);
		}

		if (vatNumber == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(vatNumber);
		}

		if (iban == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(iban);
		}
	}

	public long esfStockistId;
	public String name;
	public String email;
	public String phone;
	public String address;
	public String description;
	public String other;
	public String nameReference;
	public String lastNameReference;
	public String emailReference;
	public String phoneReference;
	public String vatNumber;
	public String iban;
}