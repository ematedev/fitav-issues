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

import it.ethica.esf.model.VW_ESFIncarichiFederali;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing VW_ESFIncarichiFederali in entity cache.
 *
 * @author Ethica
 * @see VW_ESFIncarichiFederali
 * @generated
 */
public class VW_ESFIncarichiFederaliCacheModel implements CacheModel<VW_ESFIncarichiFederali>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{esfUserId=");
		sb.append(esfUserId);
		sb.append(", esfFederalRoleId=");
		sb.append(esfFederalRoleId);
		sb.append(", code_=");
		sb.append(code_);
		sb.append(", description=");
		sb.append(description);
		sb.append(", startDate=");
		sb.append(startDate);
		sb.append(", endDate=");
		sb.append(endDate);
		sb.append(", active_=");
		sb.append(active_);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public VW_ESFIncarichiFederali toEntityModel() {
		VW_ESFIncarichiFederaliImpl vw_esfIncarichiFederaliImpl = new VW_ESFIncarichiFederaliImpl();

		vw_esfIncarichiFederaliImpl.setEsfUserId(esfUserId);
		vw_esfIncarichiFederaliImpl.setEsfFederalRoleId(esfFederalRoleId);

		if (code_ == null) {
			vw_esfIncarichiFederaliImpl.setCode_(StringPool.BLANK);
		}
		else {
			vw_esfIncarichiFederaliImpl.setCode_(code_);
		}

		if (description == null) {
			vw_esfIncarichiFederaliImpl.setDescription(StringPool.BLANK);
		}
		else {
			vw_esfIncarichiFederaliImpl.setDescription(description);
		}

		vw_esfIncarichiFederaliImpl.setStartDate(startDate);

		if (endDate == Long.MIN_VALUE) {
			vw_esfIncarichiFederaliImpl.setEndDate(null);
		}
		else {
			vw_esfIncarichiFederaliImpl.setEndDate(new Date(endDate));
		}

		vw_esfIncarichiFederaliImpl.setActive_(active_);

		vw_esfIncarichiFederaliImpl.resetOriginalValues();

		return vw_esfIncarichiFederaliImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		esfUserId = objectInput.readLong();
		esfFederalRoleId = objectInput.readLong();
		code_ = objectInput.readUTF();
		description = objectInput.readUTF();
		startDate = objectInput.readLong();
		endDate = objectInput.readLong();
		active_ = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(esfUserId);
		objectOutput.writeLong(esfFederalRoleId);

		if (code_ == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(code_);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeLong(startDate);
		objectOutput.writeLong(endDate);
		objectOutput.writeBoolean(active_);
	}

	public long esfUserId;
	public long esfFederalRoleId;
	public String code_;
	public String description;
	public long startDate;
	public long endDate;
	public boolean active_;
}