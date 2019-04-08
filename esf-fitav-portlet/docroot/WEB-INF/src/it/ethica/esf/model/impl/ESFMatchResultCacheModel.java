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

import it.ethica.esf.model.ESFMatchResult;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ESFMatchResult in entity cache.
 *
 * @author Ethica
 * @see ESFMatchResult
 * @generated
 */
public class ESFMatchResultCacheModel implements CacheModel<ESFMatchResult>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(57);

		sb.append("{esfMatchResultId=");
		sb.append(esfMatchResultId);
		sb.append(", groupId=");
		sb.append(groupId);
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
		sb.append(", esfMatchId=");
		sb.append(esfMatchId);
		sb.append(", esfPartecipantId=");
		sb.append(esfPartecipantId);
		sb.append(", cardCode=");
		sb.append(cardCode);
		sb.append(", generalClassPosition=");
		sb.append(generalClassPosition);
		sb.append(", categoryClassPosition=");
		sb.append(categoryClassPosition);
		sb.append(", categoryName=");
		sb.append(categoryName);
		sb.append(", qualification=");
		sb.append(qualification);
		sb.append(", first=");
		sb.append(first);
		sb.append(", second=");
		sb.append(second);
		sb.append(", third=");
		sb.append(third);
		sb.append(", fourth=");
		sb.append(fourth);
		sb.append(", fifth=");
		sb.append(fifth);
		sb.append(", total=");
		sb.append(total);
		sb.append(", firstPlayOff=");
		sb.append(firstPlayOff);
		sb.append(", secondPlayOff=");
		sb.append(secondPlayOff);
		sb.append(", thirdPlayOff=");
		sb.append(thirdPlayOff);
		sb.append(", totalAfterPlayOff=");
		sb.append(totalAfterPlayOff);
		sb.append(", nextFirstPlayOff=");
		sb.append(nextFirstPlayOff);
		sb.append(", nextSecondPlayOff=");
		sb.append(nextSecondPlayOff);
		sb.append(", nextTotalPlayOff=");
		sb.append(nextTotalPlayOff);
		sb.append(", fiscalCode=");
		sb.append(fiscalCode);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ESFMatchResult toEntityModel() {
		ESFMatchResultImpl esfMatchResultImpl = new ESFMatchResultImpl();

		esfMatchResultImpl.setEsfMatchResultId(esfMatchResultId);
		esfMatchResultImpl.setGroupId(groupId);
		esfMatchResultImpl.setCompanyId(companyId);
		esfMatchResultImpl.setUserId(userId);

		if (userName == null) {
			esfMatchResultImpl.setUserName(StringPool.BLANK);
		}
		else {
			esfMatchResultImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			esfMatchResultImpl.setCreateDate(null);
		}
		else {
			esfMatchResultImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			esfMatchResultImpl.setModifiedDate(null);
		}
		else {
			esfMatchResultImpl.setModifiedDate(new Date(modifiedDate));
		}

		esfMatchResultImpl.setEsfMatchId(esfMatchId);
		esfMatchResultImpl.setEsfPartecipantId(esfPartecipantId);

		if (cardCode == null) {
			esfMatchResultImpl.setCardCode(StringPool.BLANK);
		}
		else {
			esfMatchResultImpl.setCardCode(cardCode);
		}

		esfMatchResultImpl.setGeneralClassPosition(generalClassPosition);
		esfMatchResultImpl.setCategoryClassPosition(categoryClassPosition);

		if (categoryName == null) {
			esfMatchResultImpl.setCategoryName(StringPool.BLANK);
		}
		else {
			esfMatchResultImpl.setCategoryName(categoryName);
		}

		if (qualification == null) {
			esfMatchResultImpl.setQualification(StringPool.BLANK);
		}
		else {
			esfMatchResultImpl.setQualification(qualification);
		}

		esfMatchResultImpl.setFirst(first);
		esfMatchResultImpl.setSecond(second);
		esfMatchResultImpl.setThird(third);
		esfMatchResultImpl.setFourth(fourth);
		esfMatchResultImpl.setFifth(fifth);
		esfMatchResultImpl.setTotal(total);
		esfMatchResultImpl.setFirstPlayOff(firstPlayOff);
		esfMatchResultImpl.setSecondPlayOff(secondPlayOff);
		esfMatchResultImpl.setThirdPlayOff(thirdPlayOff);
		esfMatchResultImpl.setTotalAfterPlayOff(totalAfterPlayOff);
		esfMatchResultImpl.setNextFirstPlayOff(nextFirstPlayOff);
		esfMatchResultImpl.setNextSecondPlayOff(nextSecondPlayOff);
		esfMatchResultImpl.setNextTotalPlayOff(nextTotalPlayOff);

		if (fiscalCode == null) {
			esfMatchResultImpl.setFiscalCode(StringPool.BLANK);
		}
		else {
			esfMatchResultImpl.setFiscalCode(fiscalCode);
		}

		esfMatchResultImpl.resetOriginalValues();

		return esfMatchResultImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		esfMatchResultId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		esfMatchId = objectInput.readLong();
		esfPartecipantId = objectInput.readLong();
		cardCode = objectInput.readUTF();
		generalClassPosition = objectInput.readInt();
		categoryClassPosition = objectInput.readInt();
		categoryName = objectInput.readUTF();
		qualification = objectInput.readUTF();
		first = objectInput.readInt();
		second = objectInput.readInt();
		third = objectInput.readInt();
		fourth = objectInput.readInt();
		fifth = objectInput.readInt();
		total = objectInput.readInt();
		firstPlayOff = objectInput.readInt();
		secondPlayOff = objectInput.readInt();
		thirdPlayOff = objectInput.readInt();
		totalAfterPlayOff = objectInput.readInt();
		nextFirstPlayOff = objectInput.readInt();
		nextSecondPlayOff = objectInput.readInt();
		nextTotalPlayOff = objectInput.readInt();
		fiscalCode = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(esfMatchResultId);
		objectOutput.writeLong(groupId);
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
		objectOutput.writeLong(esfMatchId);
		objectOutput.writeLong(esfPartecipantId);

		if (cardCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(cardCode);
		}

		objectOutput.writeInt(generalClassPosition);
		objectOutput.writeInt(categoryClassPosition);

		if (categoryName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(categoryName);
		}

		if (qualification == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(qualification);
		}

		objectOutput.writeInt(first);
		objectOutput.writeInt(second);
		objectOutput.writeInt(third);
		objectOutput.writeInt(fourth);
		objectOutput.writeInt(fifth);
		objectOutput.writeInt(total);
		objectOutput.writeInt(firstPlayOff);
		objectOutput.writeInt(secondPlayOff);
		objectOutput.writeInt(thirdPlayOff);
		objectOutput.writeInt(totalAfterPlayOff);
		objectOutput.writeInt(nextFirstPlayOff);
		objectOutput.writeInt(nextSecondPlayOff);
		objectOutput.writeInt(nextTotalPlayOff);

		if (fiscalCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(fiscalCode);
		}
	}

	public long esfMatchResultId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long esfMatchId;
	public long esfPartecipantId;
	public String cardCode;
	public int generalClassPosition;
	public int categoryClassPosition;
	public String categoryName;
	public String qualification;
	public int first;
	public int second;
	public int third;
	public int fourth;
	public int fifth;
	public int total;
	public int firstPlayOff;
	public int secondPlayOff;
	public int thirdPlayOff;
	public int totalAfterPlayOff;
	public int nextFirstPlayOff;
	public int nextSecondPlayOff;
	public int nextTotalPlayOff;
	public String fiscalCode;
}