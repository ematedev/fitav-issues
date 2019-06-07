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

import it.ethica.esf.model.ESFMatch;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ESFMatch in entity cache.
 *
 * @author Ethica
 * @see ESFMatch
 * @generated
 */
public class ESFMatchCacheModel implements CacheModel<ESFMatch>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(75);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", esfMatchId=");
		sb.append(esfMatchId);
		sb.append(", startDate=");
		sb.append(startDate);
		sb.append(", startHour=");
		sb.append(startHour);
		sb.append(", esfSportTypeId=");
		sb.append(esfSportTypeId);
		sb.append(", esfMatchTypeId=");
		sb.append(esfMatchTypeId);
		sb.append(", isDraft=");
		sb.append(isDraft);
		sb.append(", isTeamMatch=");
		sb.append(isTeamMatch);
		sb.append(", isIndividualMatch=");
		sb.append(isIndividualMatch);
		sb.append(", isJuniorMatch=");
		sb.append(isJuniorMatch);
		sb.append(", numDisk=");
		sb.append(numDisk);
		sb.append(", numDiskTeam=");
		sb.append(numDiskTeam);
		sb.append(", esfAssociationId=");
		sb.append(esfAssociationId);
		sb.append(", notes=");
		sb.append(notes);
		sb.append(", description=");
		sb.append(description);
		sb.append(", endDate=");
		sb.append(endDate);
		sb.append(", numFields=");
		sb.append(numFields);
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
		sb.append(", isSingleMatch=");
		sb.append(isSingleMatch);
		sb.append(", site=");
		sb.append(site);
		sb.append(", countryId=");
		sb.append(countryId);
		sb.append(", code=");
		sb.append(code);
		sb.append(", isNational=");
		sb.append(isNational);
		sb.append(", HasPenality=");
		sb.append(HasPenality);
		sb.append(", isOlimpicQualificationMatch=");
		sb.append(isOlimpicQualificationMatch);
		sb.append(", eventType=");
		sb.append(eventType);
		sb.append(", notNationalAssotiation=");
		sb.append(notNationalAssotiation);
		sb.append(", isChangeCategoryMatch=");
		sb.append(isChangeCategoryMatch);
		sb.append(", esfNationalSportTypeId=");
		sb.append(esfNationalSportTypeId);
		sb.append(", oldCode=");
		sb.append(oldCode);
		sb.append(", matchYear=");
		sb.append(matchYear);
		sb.append(", matchYearSeq=");
		sb.append(matchYearSeq);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ESFMatch toEntityModel() {
		ESFMatchImpl esfMatchImpl = new ESFMatchImpl();

		if (uuid == null) {
			esfMatchImpl.setUuid(StringPool.BLANK);
		}
		else {
			esfMatchImpl.setUuid(uuid);
		}

		esfMatchImpl.setEsfMatchId(esfMatchId);

		if (startDate == Long.MIN_VALUE) {
			esfMatchImpl.setStartDate(null);
		}
		else {
			esfMatchImpl.setStartDate(new Date(startDate));
		}

		if (startHour == null) {
			esfMatchImpl.setStartHour(StringPool.BLANK);
		}
		else {
			esfMatchImpl.setStartHour(startHour);
		}

		esfMatchImpl.setEsfSportTypeId(esfSportTypeId);
		esfMatchImpl.setEsfMatchTypeId(esfMatchTypeId);
		esfMatchImpl.setIsDraft(isDraft);
		esfMatchImpl.setIsTeamMatch(isTeamMatch);
		esfMatchImpl.setIsIndividualMatch(isIndividualMatch);
		esfMatchImpl.setIsJuniorMatch(isJuniorMatch);
		esfMatchImpl.setNumDisk(numDisk);
		esfMatchImpl.setNumDiskTeam(numDiskTeam);
		esfMatchImpl.setEsfAssociationId(esfAssociationId);

		if (notes == null) {
			esfMatchImpl.setNotes(StringPool.BLANK);
		}
		else {
			esfMatchImpl.setNotes(notes);
		}

		esfMatchImpl.setDescription(description);

		if (endDate == Long.MIN_VALUE) {
			esfMatchImpl.setEndDate(null);
		}
		else {
			esfMatchImpl.setEndDate(new Date(endDate));
		}

		esfMatchImpl.setNumFields(numFields);
		esfMatchImpl.setGroupId(groupId);
		esfMatchImpl.setCompanyId(companyId);
		esfMatchImpl.setUserId(userId);

		if (userName == null) {
			esfMatchImpl.setUserName(StringPool.BLANK);
		}
		else {
			esfMatchImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			esfMatchImpl.setCreateDate(null);
		}
		else {
			esfMatchImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			esfMatchImpl.setModifiedDate(null);
		}
		else {
			esfMatchImpl.setModifiedDate(new Date(modifiedDate));
		}

		esfMatchImpl.setIsSingleMatch(isSingleMatch);

		if (site == null) {
			esfMatchImpl.setSite(StringPool.BLANK);
		}
		else {
			esfMatchImpl.setSite(site);
		}

		esfMatchImpl.setCountryId(countryId);

		if (code == null) {
			esfMatchImpl.setCode(StringPool.BLANK);
		}
		else {
			esfMatchImpl.setCode(code);
		}

		esfMatchImpl.setIsNational(isNational);
		esfMatchImpl.setHasPenality(HasPenality);
		esfMatchImpl.setIsOlimpicQualificationMatch(isOlimpicQualificationMatch);

		if (eventType == null) {
			esfMatchImpl.setEventType(StringPool.BLANK);
		}
		else {
			esfMatchImpl.setEventType(eventType);
		}

		if (notNationalAssotiation == null) {
			esfMatchImpl.setNotNationalAssotiation(StringPool.BLANK);
		}
		else {
			esfMatchImpl.setNotNationalAssotiation(notNationalAssotiation);
		}

		esfMatchImpl.setIsChangeCategoryMatch(isChangeCategoryMatch);

		if (esfNationalSportTypeId == null) {
			esfMatchImpl.setEsfNationalSportTypeId(StringPool.BLANK);
		}
		else {
			esfMatchImpl.setEsfNationalSportTypeId(esfNationalSportTypeId);
		}

		if (oldCode == null) {
			esfMatchImpl.setOldCode(StringPool.BLANK);
		}
		else {
			esfMatchImpl.setOldCode(oldCode);
		}

		esfMatchImpl.setMatchYear(matchYear);
		esfMatchImpl.setMatchYearSeq(matchYearSeq);

		esfMatchImpl.resetOriginalValues();

		return esfMatchImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		esfMatchId = objectInput.readLong();
		startDate = objectInput.readLong();
		startHour = objectInput.readUTF();
		esfSportTypeId = objectInput.readLong();
		esfMatchTypeId = objectInput.readLong();
		isDraft = objectInput.readBoolean();
		isTeamMatch = objectInput.readBoolean();
		isIndividualMatch = objectInput.readBoolean();
		isJuniorMatch = objectInput.readBoolean();
		numDisk = objectInput.readInt();
		numDiskTeam = objectInput.readInt();
		esfAssociationId = objectInput.readLong();
		notes = objectInput.readUTF();
		description = objectInput.readLong();
		endDate = objectInput.readLong();
		numFields = objectInput.readInt();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		isSingleMatch = objectInput.readBoolean();
		site = objectInput.readUTF();
		countryId = objectInput.readLong();
		code = objectInput.readUTF();
		isNational = objectInput.readBoolean();
		HasPenality = objectInput.readBoolean();
		isOlimpicQualificationMatch = objectInput.readBoolean();
		eventType = objectInput.readUTF();
		notNationalAssotiation = objectInput.readUTF();
		isChangeCategoryMatch = objectInput.readBoolean();
		esfNationalSportTypeId = objectInput.readUTF();
		oldCode = objectInput.readUTF();
		matchYear = objectInput.readInt();
		matchYearSeq = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(esfMatchId);
		objectOutput.writeLong(startDate);

		if (startHour == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(startHour);
		}

		objectOutput.writeLong(esfSportTypeId);
		objectOutput.writeLong(esfMatchTypeId);
		objectOutput.writeBoolean(isDraft);
		objectOutput.writeBoolean(isTeamMatch);
		objectOutput.writeBoolean(isIndividualMatch);
		objectOutput.writeBoolean(isJuniorMatch);
		objectOutput.writeInt(numDisk);
		objectOutput.writeInt(numDiskTeam);
		objectOutput.writeLong(esfAssociationId);

		if (notes == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(notes);
		}

		objectOutput.writeLong(description);
		objectOutput.writeLong(endDate);
		objectOutput.writeInt(numFields);
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
		objectOutput.writeBoolean(isSingleMatch);

		if (site == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(site);
		}

		objectOutput.writeLong(countryId);

		if (code == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(code);
		}

		objectOutput.writeBoolean(isNational);
		objectOutput.writeBoolean(HasPenality);
		objectOutput.writeBoolean(isOlimpicQualificationMatch);

		if (eventType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(eventType);
		}

		if (notNationalAssotiation == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(notNationalAssotiation);
		}

		objectOutput.writeBoolean(isChangeCategoryMatch);

		if (esfNationalSportTypeId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(esfNationalSportTypeId);
		}

		if (oldCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(oldCode);
		}

		objectOutput.writeInt(matchYear);
		objectOutput.writeInt(matchYearSeq);
	}

	public String uuid;
	public long esfMatchId;
	public long startDate;
	public String startHour;
	public long esfSportTypeId;
	public long esfMatchTypeId;
	public boolean isDraft;
	public boolean isTeamMatch;
	public boolean isIndividualMatch;
	public boolean isJuniorMatch;
	public int numDisk;
	public int numDiskTeam;
	public long esfAssociationId;
	public String notes;
	public long description;
	public long endDate;
	public int numFields;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public boolean isSingleMatch;
	public String site;
	public long countryId;
	public String code;
	public boolean isNational;
	public boolean HasPenality;
	public boolean isOlimpicQualificationMatch;
	public String eventType;
	public String notNationalAssotiation;
	public boolean isChangeCategoryMatch;
	public String esfNationalSportTypeId;
	public String oldCode;
	public int matchYear;
	public int matchYearSeq;
}