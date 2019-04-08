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

import it.ethica.esf.model.ESFTournament;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ESFTournament in entity cache.
 *
 * @author Ethica
 * @see ESFTournament
 * @generated
 */
public class ESFTournamentCacheModel implements CacheModel<ESFTournament>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(43);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", esfTournamentId=");
		sb.append(esfTournamentId);
		sb.append(", esfOrganizationId=");
		sb.append(esfOrganizationId);
		sb.append(", title=");
		sb.append(title);
		sb.append(", description=");
		sb.append(description);
		sb.append(", maxnum=");
		sb.append(maxnum);
		sb.append(", minnum=");
		sb.append(minnum);
		sb.append(", isSingleMatch=");
		sb.append(isSingleMatch);
		sb.append(", isTeamMatch=");
		sb.append(isTeamMatch);
		sb.append(", isIndividualMatch=");
		sb.append(isIndividualMatch);
		sb.append(", isJuniorMatch=");
		sb.append(isJuniorMatch);
		sb.append(", isNationalMatch=");
		sb.append(isNationalMatch);
		sb.append(", isFinal=");
		sb.append(isFinal);
		sb.append(", startDate=");
		sb.append(startDate);
		sb.append(", endDate=");
		sb.append(endDate);
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
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ESFTournament toEntityModel() {
		ESFTournamentImpl esfTournamentImpl = new ESFTournamentImpl();

		if (uuid == null) {
			esfTournamentImpl.setUuid(StringPool.BLANK);
		}
		else {
			esfTournamentImpl.setUuid(uuid);
		}

		esfTournamentImpl.setEsfTournamentId(esfTournamentId);
		esfTournamentImpl.setEsfOrganizationId(esfOrganizationId);

		if (title == null) {
			esfTournamentImpl.setTitle(StringPool.BLANK);
		}
		else {
			esfTournamentImpl.setTitle(title);
		}

		if (description == null) {
			esfTournamentImpl.setDescription(StringPool.BLANK);
		}
		else {
			esfTournamentImpl.setDescription(description);
		}

		esfTournamentImpl.setMaxnum(maxnum);
		esfTournamentImpl.setMinnum(minnum);
		esfTournamentImpl.setIsSingleMatch(isSingleMatch);
		esfTournamentImpl.setIsTeamMatch(isTeamMatch);
		esfTournamentImpl.setIsIndividualMatch(isIndividualMatch);
		esfTournamentImpl.setIsJuniorMatch(isJuniorMatch);
		esfTournamentImpl.setIsNationalMatch(isNationalMatch);
		esfTournamentImpl.setIsFinal(isFinal);

		if (startDate == Long.MIN_VALUE) {
			esfTournamentImpl.setStartDate(null);
		}
		else {
			esfTournamentImpl.setStartDate(new Date(startDate));
		}

		if (endDate == Long.MIN_VALUE) {
			esfTournamentImpl.setEndDate(null);
		}
		else {
			esfTournamentImpl.setEndDate(new Date(endDate));
		}

		esfTournamentImpl.setGroupId(groupId);
		esfTournamentImpl.setCompanyId(companyId);
		esfTournamentImpl.setUserId(userId);

		if (userName == null) {
			esfTournamentImpl.setUserName(StringPool.BLANK);
		}
		else {
			esfTournamentImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			esfTournamentImpl.setCreateDate(null);
		}
		else {
			esfTournamentImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			esfTournamentImpl.setModifiedDate(null);
		}
		else {
			esfTournamentImpl.setModifiedDate(new Date(modifiedDate));
		}

		esfTournamentImpl.resetOriginalValues();

		return esfTournamentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		esfTournamentId = objectInput.readLong();
		esfOrganizationId = objectInput.readLong();
		title = objectInput.readUTF();
		description = objectInput.readUTF();
		maxnum = objectInput.readLong();
		minnum = objectInput.readLong();
		isSingleMatch = objectInput.readBoolean();
		isTeamMatch = objectInput.readBoolean();
		isIndividualMatch = objectInput.readBoolean();
		isJuniorMatch = objectInput.readBoolean();
		isNationalMatch = objectInput.readBoolean();
		isFinal = objectInput.readBoolean();
		startDate = objectInput.readLong();
		endDate = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
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

		objectOutput.writeLong(esfTournamentId);
		objectOutput.writeLong(esfOrganizationId);

		if (title == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeLong(maxnum);
		objectOutput.writeLong(minnum);
		objectOutput.writeBoolean(isSingleMatch);
		objectOutput.writeBoolean(isTeamMatch);
		objectOutput.writeBoolean(isIndividualMatch);
		objectOutput.writeBoolean(isJuniorMatch);
		objectOutput.writeBoolean(isNationalMatch);
		objectOutput.writeBoolean(isFinal);
		objectOutput.writeLong(startDate);
		objectOutput.writeLong(endDate);
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
	}

	public String uuid;
	public long esfTournamentId;
	public long esfOrganizationId;
	public String title;
	public String description;
	public long maxnum;
	public long minnum;
	public boolean isSingleMatch;
	public boolean isTeamMatch;
	public boolean isIndividualMatch;
	public boolean isJuniorMatch;
	public boolean isNationalMatch;
	public boolean isFinal;
	public long startDate;
	public long endDate;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
}