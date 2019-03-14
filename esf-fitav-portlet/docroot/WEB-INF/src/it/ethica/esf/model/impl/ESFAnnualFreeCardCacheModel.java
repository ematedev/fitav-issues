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

import it.ethica.esf.model.ESFAnnualFreeCard;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ESFAnnualFreeCard in entity cache.
 *
 * @author Ethica
 * @see ESFAnnualFreeCard
 * @generated
 */
public class ESFAnnualFreeCardCacheModel implements CacheModel<ESFAnnualFreeCard>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{annualFreeCardId=");
		sb.append(annualFreeCardId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", assId=");
		sb.append(assId);
		sb.append(", code=");
		sb.append(code);
		sb.append(", cardCode=");
		sb.append(cardCode);
		sb.append(", assCode=");
		sb.append(assCode);
		sb.append(", assName=");
		sb.append(assName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ESFAnnualFreeCard toEntityModel() {
		ESFAnnualFreeCardImpl esfAnnualFreeCardImpl = new ESFAnnualFreeCardImpl();

		esfAnnualFreeCardImpl.setAnnualFreeCardId(annualFreeCardId);
		esfAnnualFreeCardImpl.setCompanyId(companyId);
		esfAnnualFreeCardImpl.setUserId(userId);

		if (userName == null) {
			esfAnnualFreeCardImpl.setUserName(StringPool.BLANK);
		}
		else {
			esfAnnualFreeCardImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			esfAnnualFreeCardImpl.setCreateDate(null);
		}
		else {
			esfAnnualFreeCardImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			esfAnnualFreeCardImpl.setModifiedDate(null);
		}
		else {
			esfAnnualFreeCardImpl.setModifiedDate(new Date(modifiedDate));
		}

		esfAnnualFreeCardImpl.setAssId(assId);

		if (code == null) {
			esfAnnualFreeCardImpl.setCode(StringPool.BLANK);
		}
		else {
			esfAnnualFreeCardImpl.setCode(code);
		}

		if (cardCode == null) {
			esfAnnualFreeCardImpl.setCardCode(StringPool.BLANK);
		}
		else {
			esfAnnualFreeCardImpl.setCardCode(cardCode);
		}

		if (assCode == null) {
			esfAnnualFreeCardImpl.setAssCode(StringPool.BLANK);
		}
		else {
			esfAnnualFreeCardImpl.setAssCode(assCode);
		}

		if (assName == null) {
			esfAnnualFreeCardImpl.setAssName(StringPool.BLANK);
		}
		else {
			esfAnnualFreeCardImpl.setAssName(assName);
		}

		esfAnnualFreeCardImpl.resetOriginalValues();

		return esfAnnualFreeCardImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		annualFreeCardId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		assId = objectInput.readLong();
		code = objectInput.readUTF();
		cardCode = objectInput.readUTF();
		assCode = objectInput.readUTF();
		assName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(annualFreeCardId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(assId);

		if (code == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(code);
		}

		if (cardCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(cardCode);
		}

		if (assCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(assCode);
		}

		if (assName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(assName);
		}
	}

	public long annualFreeCardId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long assId;
	public String code;
	public String cardCode;
	public String assCode;
	public String assName;
}