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

import it.ethica.esf.model.ESFFlight;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ESFFlight in entity cache.
 *
 * @author Ethica
 * @see ESFFlight
 * @generated
 */
public class ESFFlightCacheModel implements CacheModel<ESFFlight>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(35);

		sb.append("{esfFlightId=");
		sb.append(esfFlightId);
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
		sb.append(", flightCode=");
		sb.append(flightCode);
		sb.append(", companyName=");
		sb.append(companyName);
		sb.append(", departureAirport=");
		sb.append(departureAirport);
		sb.append(", arrivalAirport=");
		sb.append(arrivalAirport);
		sb.append(", esfMatchId=");
		sb.append(esfMatchId);
		sb.append(", esfUserId=");
		sb.append(esfUserId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ESFFlight toEntityModel() {
		ESFFlightImpl esfFlightImpl = new ESFFlightImpl();

		esfFlightImpl.setEsfFlightId(esfFlightId);
		esfFlightImpl.setGroupId(groupId);
		esfFlightImpl.setCompanyId(companyId);
		esfFlightImpl.setUserId(userId);

		if (userName == null) {
			esfFlightImpl.setUserName(StringPool.BLANK);
		}
		else {
			esfFlightImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			esfFlightImpl.setCreateDate(null);
		}
		else {
			esfFlightImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			esfFlightImpl.setModifiedDate(null);
		}
		else {
			esfFlightImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (leaveDate == Long.MIN_VALUE) {
			esfFlightImpl.setLeaveDate(null);
		}
		else {
			esfFlightImpl.setLeaveDate(new Date(leaveDate));
		}

		if (leaveHour == null) {
			esfFlightImpl.setLeaveHour(StringPool.BLANK);
		}
		else {
			esfFlightImpl.setLeaveHour(leaveHour);
		}

		if (arriveDate == Long.MIN_VALUE) {
			esfFlightImpl.setArriveDate(null);
		}
		else {
			esfFlightImpl.setArriveDate(new Date(arriveDate));
		}

		if (arriveHour == null) {
			esfFlightImpl.setArriveHour(StringPool.BLANK);
		}
		else {
			esfFlightImpl.setArriveHour(arriveHour);
		}

		if (flightCode == null) {
			esfFlightImpl.setFlightCode(StringPool.BLANK);
		}
		else {
			esfFlightImpl.setFlightCode(flightCode);
		}

		if (companyName == null) {
			esfFlightImpl.setCompanyName(StringPool.BLANK);
		}
		else {
			esfFlightImpl.setCompanyName(companyName);
		}

		if (departureAirport == null) {
			esfFlightImpl.setDepartureAirport(StringPool.BLANK);
		}
		else {
			esfFlightImpl.setDepartureAirport(departureAirport);
		}

		if (arrivalAirport == null) {
			esfFlightImpl.setArrivalAirport(StringPool.BLANK);
		}
		else {
			esfFlightImpl.setArrivalAirport(arrivalAirport);
		}

		esfFlightImpl.setEsfMatchId(esfMatchId);
		esfFlightImpl.setEsfUserId(esfUserId);

		esfFlightImpl.resetOriginalValues();

		return esfFlightImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		esfFlightId = objectInput.readLong();
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
		flightCode = objectInput.readUTF();
		companyName = objectInput.readUTF();
		departureAirport = objectInput.readUTF();
		arrivalAirport = objectInput.readUTF();
		esfMatchId = objectInput.readLong();
		esfUserId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(esfFlightId);
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

		if (flightCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(flightCode);
		}

		if (companyName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(companyName);
		}

		if (departureAirport == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(departureAirport);
		}

		if (arrivalAirport == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(arrivalAirport);
		}

		objectOutput.writeLong(esfMatchId);
		objectOutput.writeLong(esfUserId);
	}

	public long esfFlightId;
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
	public String flightCode;
	public String companyName;
	public String departureAirport;
	public String arrivalAirport;
	public long esfMatchId;
	public long esfUserId;
}