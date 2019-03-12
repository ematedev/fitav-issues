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

import it.ethica.esf.model.ESFNationalDelegation;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ESFNationalDelegation in entity cache.
 *
 * @author Ethica
 * @see ESFNationalDelegation
 * @generated
 */
public class ESFNationalDelegationCacheModel implements CacheModel<ESFNationalDelegation>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{esfUserId=");
		sb.append(esfUserId);
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
		sb.append(", leaveDate=");
		sb.append(leaveDate);
		sb.append(", returnDate=");
		sb.append(returnDate);
		sb.append(", esfMatchId=");
		sb.append(esfMatchId);
		sb.append(", esfSportTypeId=");
		sb.append(esfSportTypeId);
		sb.append(", esfGunId1=");
		sb.append(esfGunId1);
		sb.append(", esfGunId2=");
		sb.append(esfGunId2);
		sb.append(", esfNationalDelgationId=");
		sb.append(esfNationalDelgationId);
		sb.append(", esfPartecipantTypeId=");
		sb.append(esfPartecipantTypeId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ESFNationalDelegation toEntityModel() {
		ESFNationalDelegationImpl esfNationalDelegationImpl = new ESFNationalDelegationImpl();

		esfNationalDelegationImpl.setEsfUserId(esfUserId);
		esfNationalDelegationImpl.setGroupId(groupId);
		esfNationalDelegationImpl.setCompanyId(companyId);
		esfNationalDelegationImpl.setUserId(userId);

		if (userName == null) {
			esfNationalDelegationImpl.setUserName(StringPool.BLANK);
		}
		else {
			esfNationalDelegationImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			esfNationalDelegationImpl.setCreateDate(null);
		}
		else {
			esfNationalDelegationImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			esfNationalDelegationImpl.setModifiedDate(null);
		}
		else {
			esfNationalDelegationImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (leaveDate == Long.MIN_VALUE) {
			esfNationalDelegationImpl.setLeaveDate(null);
		}
		else {
			esfNationalDelegationImpl.setLeaveDate(new Date(leaveDate));
		}

		if (returnDate == Long.MIN_VALUE) {
			esfNationalDelegationImpl.setReturnDate(null);
		}
		else {
			esfNationalDelegationImpl.setReturnDate(new Date(returnDate));
		}

		esfNationalDelegationImpl.setEsfMatchId(esfMatchId);
		esfNationalDelegationImpl.setEsfSportTypeId(esfSportTypeId);
		esfNationalDelegationImpl.setEsfGunId1(esfGunId1);
		esfNationalDelegationImpl.setEsfGunId2(esfGunId2);
		esfNationalDelegationImpl.setEsfNationalDelgationId(esfNationalDelgationId);
		esfNationalDelegationImpl.setEsfPartecipantTypeId(esfPartecipantTypeId);

		esfNationalDelegationImpl.resetOriginalValues();

		return esfNationalDelegationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		esfUserId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		leaveDate = objectInput.readLong();
		returnDate = objectInput.readLong();
		esfMatchId = objectInput.readLong();
		esfSportTypeId = objectInput.readLong();
		esfGunId1 = objectInput.readLong();
		esfGunId2 = objectInput.readLong();
		esfNationalDelgationId = objectInput.readLong();
		esfPartecipantTypeId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(esfUserId);
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
		objectOutput.writeLong(leaveDate);
		objectOutput.writeLong(returnDate);
		objectOutput.writeLong(esfMatchId);
		objectOutput.writeLong(esfSportTypeId);
		objectOutput.writeLong(esfGunId1);
		objectOutput.writeLong(esfGunId2);
		objectOutput.writeLong(esfNationalDelgationId);
		objectOutput.writeLong(esfPartecipantTypeId);
	}

	public long esfUserId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long leaveDate;
	public long returnDate;
	public long esfMatchId;
	public long esfSportTypeId;
	public long esfGunId1;
	public long esfGunId2;
	public long esfNationalDelgationId;
	public long esfPartecipantTypeId;
}