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

import it.ethica.esf.model.ESFDeparture;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ESFDeparture in entity cache.
 *
 * @author Ethica
 * @see ESFDeparture
 * @generated
 */
public class ESFDepartureCacheModel implements CacheModel<ESFDeparture>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(43);

		sb.append("{esfDepartureId=");
		sb.append(esfDepartureId);
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
		sb.append(", leaveHour=");
		sb.append(leaveHour);
		sb.append(", arriveDate=");
		sb.append(arriveDate);
		sb.append(", arriveHour=");
		sb.append(arriveHour);
		sb.append(", code=");
		sb.append(code);
		sb.append(", companyName=");
		sb.append(companyName);
		sb.append(", departureFrom=");
		sb.append(departureFrom);
		sb.append(", arrivalTo=");
		sb.append(arrivalTo);
		sb.append(", esfMatchId=");
		sb.append(esfMatchId);
		sb.append(", esfUserId=");
		sb.append(esfUserId);
		sb.append(", isReturn=");
		sb.append(isReturn);
		sb.append(", meetingPlace=");
		sb.append(meetingPlace);
		sb.append(", typeTravel=");
		sb.append(typeTravel);
		sb.append(", stopoverId=");
		sb.append(stopoverId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ESFDeparture toEntityModel() {
		ESFDepartureImpl esfDepartureImpl = new ESFDepartureImpl();

		esfDepartureImpl.setEsfDepartureId(esfDepartureId);
		esfDepartureImpl.setGroupId(groupId);
		esfDepartureImpl.setCompanyId(companyId);
		esfDepartureImpl.setUserId(userId);

		if (userName == null) {
			esfDepartureImpl.setUserName(StringPool.BLANK);
		}
		else {
			esfDepartureImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			esfDepartureImpl.setCreateDate(null);
		}
		else {
			esfDepartureImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			esfDepartureImpl.setModifiedDate(null);
		}
		else {
			esfDepartureImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (leaveDate == Long.MIN_VALUE) {
			esfDepartureImpl.setLeaveDate(null);
		}
		else {
			esfDepartureImpl.setLeaveDate(new Date(leaveDate));
		}

		if (leaveHour == null) {
			esfDepartureImpl.setLeaveHour(StringPool.BLANK);
		}
		else {
			esfDepartureImpl.setLeaveHour(leaveHour);
		}

		if (arriveDate == Long.MIN_VALUE) {
			esfDepartureImpl.setArriveDate(null);
		}
		else {
			esfDepartureImpl.setArriveDate(new Date(arriveDate));
		}

		if (arriveHour == null) {
			esfDepartureImpl.setArriveHour(StringPool.BLANK);
		}
		else {
			esfDepartureImpl.setArriveHour(arriveHour);
		}

		if (code == null) {
			esfDepartureImpl.setCode(StringPool.BLANK);
		}
		else {
			esfDepartureImpl.setCode(code);
		}

		if (companyName == null) {
			esfDepartureImpl.setCompanyName(StringPool.BLANK);
		}
		else {
			esfDepartureImpl.setCompanyName(companyName);
		}

		if (departureFrom == null) {
			esfDepartureImpl.setDepartureFrom(StringPool.BLANK);
		}
		else {
			esfDepartureImpl.setDepartureFrom(departureFrom);
		}

		if (arrivalTo == null) {
			esfDepartureImpl.setArrivalTo(StringPool.BLANK);
		}
		else {
			esfDepartureImpl.setArrivalTo(arrivalTo);
		}

		esfDepartureImpl.setEsfMatchId(esfMatchId);
		esfDepartureImpl.setEsfUserId(esfUserId);
		esfDepartureImpl.setIsReturn(isReturn);

		if (meetingPlace == null) {
			esfDepartureImpl.setMeetingPlace(StringPool.BLANK);
		}
		else {
			esfDepartureImpl.setMeetingPlace(meetingPlace);
		}

		if (typeTravel == null) {
			esfDepartureImpl.setTypeTravel(StringPool.BLANK);
		}
		else {
			esfDepartureImpl.setTypeTravel(typeTravel);
		}

		if (stopoverId == null) {
			esfDepartureImpl.setStopoverId(StringPool.BLANK);
		}
		else {
			esfDepartureImpl.setStopoverId(stopoverId);
		}

		esfDepartureImpl.resetOriginalValues();

		return esfDepartureImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		esfDepartureId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		leaveDate = objectInput.readLong();
		leaveHour = objectInput.readUTF();
		arriveDate = objectInput.readLong();
		arriveHour = objectInput.readUTF();
		code = objectInput.readUTF();
		companyName = objectInput.readUTF();
		departureFrom = objectInput.readUTF();
		arrivalTo = objectInput.readUTF();
		esfMatchId = objectInput.readLong();
		esfUserId = objectInput.readLong();
		isReturn = objectInput.readBoolean();
		meetingPlace = objectInput.readUTF();
		typeTravel = objectInput.readUTF();
		stopoverId = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(esfDepartureId);
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

		if (leaveHour == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(leaveHour);
		}

		objectOutput.writeLong(arriveDate);

		if (arriveHour == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(arriveHour);
		}

		if (code == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(code);
		}

		if (companyName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(companyName);
		}

		if (departureFrom == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(departureFrom);
		}

		if (arrivalTo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(arrivalTo);
		}

		objectOutput.writeLong(esfMatchId);
		objectOutput.writeLong(esfUserId);
		objectOutput.writeBoolean(isReturn);

		if (meetingPlace == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(meetingPlace);
		}

		if (typeTravel == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(typeTravel);
		}

		if (stopoverId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(stopoverId);
		}
	}

	public long esfDepartureId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long leaveDate;
	public String leaveHour;
	public long arriveDate;
	public String arriveHour;
	public String code;
	public String companyName;
	public String departureFrom;
	public String arrivalTo;
	public long esfMatchId;
	public long esfUserId;
	public boolean isReturn;
	public String meetingPlace;
	public String typeTravel;
	public String stopoverId;
}