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
import com.liferay.portal.model.CacheModel;

import it.ethica.esf.model.ESFUserESFUserRole;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ESFUserESFUserRole in entity cache.
 *
 * @author Ethica
 * @see ESFUserESFUserRole
 * @generated
 */
public class ESFUserESFUserRoleCacheModel implements CacheModel<ESFUserESFUserRole>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{esfUserRoleId=");
		sb.append(esfUserRoleId);
		sb.append(", esfUserId=");
		sb.append(esfUserId);
		sb.append(", esfOrganizationId=");
		sb.append(esfOrganizationId);
		sb.append(", startDate=");
		sb.append(startDate);
		sb.append(", endDate=");
		sb.append(endDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ESFUserESFUserRole toEntityModel() {
		ESFUserESFUserRoleImpl esfUserESFUserRoleImpl = new ESFUserESFUserRoleImpl();

		esfUserESFUserRoleImpl.setEsfUserRoleId(esfUserRoleId);
		esfUserESFUserRoleImpl.setEsfUserId(esfUserId);
		esfUserESFUserRoleImpl.setEsfOrganizationId(esfOrganizationId);

		if (startDate == Long.MIN_VALUE) {
			esfUserESFUserRoleImpl.setStartDate(null);
		}
		else {
			esfUserESFUserRoleImpl.setStartDate(new Date(startDate));
		}

		if (endDate == Long.MIN_VALUE) {
			esfUserESFUserRoleImpl.setEndDate(null);
		}
		else {
			esfUserESFUserRoleImpl.setEndDate(new Date(endDate));
		}

		esfUserESFUserRoleImpl.resetOriginalValues();

		return esfUserESFUserRoleImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		esfUserRoleId = objectInput.readLong();
		esfUserId = objectInput.readLong();
		esfOrganizationId = objectInput.readLong();
		startDate = objectInput.readLong();
		endDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(esfUserRoleId);
		objectOutput.writeLong(esfUserId);
		objectOutput.writeLong(esfOrganizationId);
		objectOutput.writeLong(startDate);
		objectOutput.writeLong(endDate);
	}

	public long esfUserRoleId;
	public long esfUserId;
	public long esfOrganizationId;
	public long startDate;
	public long endDate;
}