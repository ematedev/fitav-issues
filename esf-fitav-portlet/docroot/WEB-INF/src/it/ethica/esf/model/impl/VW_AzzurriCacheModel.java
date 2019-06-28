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

import it.ethica.esf.model.VW_Azzurri;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing VW_Azzurri in entity cache.
 *
 * @author Ethica
 * @see VW_Azzurri
 * @generated
 */
public class VW_AzzurriCacheModel implements CacheModel<VW_Azzurri>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{esfNationalId=");
		sb.append(esfNationalId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", startDate=");
		sb.append(startDate);
		sb.append(", endDate=");
		sb.append(endDate);
		sb.append(", esfSportTypeId=");
		sb.append(esfSportTypeId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", description=");
		sb.append(description);
		sb.append(", invitato=");
		sb.append(invitato);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public VW_Azzurri toEntityModel() {
		VW_AzzurriImpl vw_AzzurriImpl = new VW_AzzurriImpl();

		vw_AzzurriImpl.setEsfNationalId(esfNationalId);

		if (userName == null) {
			vw_AzzurriImpl.setUserName(StringPool.BLANK);
		}
		else {
			vw_AzzurriImpl.setUserName(userName);
		}

		if (startDate == Long.MIN_VALUE) {
			vw_AzzurriImpl.setStartDate(null);
		}
		else {
			vw_AzzurriImpl.setStartDate(new Date(startDate));
		}

		if (endDate == Long.MIN_VALUE) {
			vw_AzzurriImpl.setEndDate(null);
		}
		else {
			vw_AzzurriImpl.setEndDate(new Date(endDate));
		}

		vw_AzzurriImpl.setEsfSportTypeId(esfSportTypeId);

		if (name == null) {
			vw_AzzurriImpl.setName(StringPool.BLANK);
		}
		else {
			vw_AzzurriImpl.setName(name);
		}

		if (description == null) {
			vw_AzzurriImpl.setDescription(StringPool.BLANK);
		}
		else {
			vw_AzzurriImpl.setDescription(description);
		}

		vw_AzzurriImpl.setInvitato(invitato);

		vw_AzzurriImpl.resetOriginalValues();

		return vw_AzzurriImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		esfNationalId = objectInput.readLong();
		userName = objectInput.readUTF();
		startDate = objectInput.readLong();
		endDate = objectInput.readLong();
		esfSportTypeId = objectInput.readLong();
		name = objectInput.readUTF();
		description = objectInput.readUTF();
		invitato = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(esfNationalId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(startDate);
		objectOutput.writeLong(endDate);
		objectOutput.writeLong(esfSportTypeId);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeLong(invitato);
	}

	public long esfNationalId;
	public String userName;
	public long startDate;
	public long endDate;
	public long esfSportTypeId;
	public String name;
	public String description;
	public long invitato;
}