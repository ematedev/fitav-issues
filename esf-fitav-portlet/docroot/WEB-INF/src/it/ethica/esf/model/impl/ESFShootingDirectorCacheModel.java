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

import it.ethica.esf.model.ESFShootingDirector;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ESFShootingDirector in entity cache.
 *
 * @author Ethica
 * @see ESFShootingDirector
 * @generated
 */
public class ESFShootingDirectorCacheModel implements CacheModel<ESFShootingDirector>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{esfShootingDirectorId=");
		sb.append(esfShootingDirectorId);
		sb.append(", esfCodeData=");
		sb.append(esfCodeData);
		sb.append(", esfStartData=");
		sb.append(esfStartData);
		sb.append(", esfEndData=");
		sb.append(esfEndData);
		sb.append(", esfUserId=");
		sb.append(esfUserId);
		sb.append(", codeUser=");
		sb.append(codeUser);
		sb.append(", shootingDirectorQualificationId=");
		sb.append(shootingDirectorQualificationId);
		sb.append(", sportTypeId=");
		sb.append(sportTypeId);
		sb.append(", regionId=");
		sb.append(regionId);
		sb.append(", provinceId=");
		sb.append(provinceId);
		sb.append(", flagCrea=");
		sb.append(flagCrea);
		sb.append(", DateVar=");
		sb.append(DateVar);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ESFShootingDirector toEntityModel() {
		ESFShootingDirectorImpl esfShootingDirectorImpl = new ESFShootingDirectorImpl();

		esfShootingDirectorImpl.setEsfShootingDirectorId(esfShootingDirectorId);

		if (esfCodeData == null) {
			esfShootingDirectorImpl.setEsfCodeData(StringPool.BLANK);
		}
		else {
			esfShootingDirectorImpl.setEsfCodeData(esfCodeData);
		}

		if (esfStartData == Long.MIN_VALUE) {
			esfShootingDirectorImpl.setEsfStartData(null);
		}
		else {
			esfShootingDirectorImpl.setEsfStartData(new Date(esfStartData));
		}

		if (esfEndData == Long.MIN_VALUE) {
			esfShootingDirectorImpl.setEsfEndData(null);
		}
		else {
			esfShootingDirectorImpl.setEsfEndData(new Date(esfEndData));
		}

		esfShootingDirectorImpl.setEsfUserId(esfUserId);
		esfShootingDirectorImpl.setCodeUser(codeUser);
		esfShootingDirectorImpl.setShootingDirectorQualificationId(shootingDirectorQualificationId);
		esfShootingDirectorImpl.setSportTypeId(sportTypeId);

		if (regionId == null) {
			esfShootingDirectorImpl.setRegionId(StringPool.BLANK);
		}
		else {
			esfShootingDirectorImpl.setRegionId(regionId);
		}

		if (provinceId == null) {
			esfShootingDirectorImpl.setProvinceId(StringPool.BLANK);
		}
		else {
			esfShootingDirectorImpl.setProvinceId(provinceId);
		}

		if (flagCrea == null) {
			esfShootingDirectorImpl.setFlagCrea(StringPool.BLANK);
		}
		else {
			esfShootingDirectorImpl.setFlagCrea(flagCrea);
		}

		if (DateVar == Long.MIN_VALUE) {
			esfShootingDirectorImpl.setDateVar(null);
		}
		else {
			esfShootingDirectorImpl.setDateVar(new Date(DateVar));
		}

		esfShootingDirectorImpl.resetOriginalValues();

		return esfShootingDirectorImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		esfShootingDirectorId = objectInput.readLong();
		esfCodeData = objectInput.readUTF();
		esfStartData = objectInput.readLong();
		esfEndData = objectInput.readLong();
		esfUserId = objectInput.readLong();
		codeUser = objectInput.readLong();
		shootingDirectorQualificationId = objectInput.readLong();
		sportTypeId = objectInput.readLong();
		regionId = objectInput.readUTF();
		provinceId = objectInput.readUTF();
		flagCrea = objectInput.readUTF();
		DateVar = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(esfShootingDirectorId);

		if (esfCodeData == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(esfCodeData);
		}

		objectOutput.writeLong(esfStartData);
		objectOutput.writeLong(esfEndData);
		objectOutput.writeLong(esfUserId);
		objectOutput.writeLong(codeUser);
		objectOutput.writeLong(shootingDirectorQualificationId);
		objectOutput.writeLong(sportTypeId);

		if (regionId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(regionId);
		}

		if (provinceId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(provinceId);
		}

		if (flagCrea == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(flagCrea);
		}

		objectOutput.writeLong(DateVar);
	}

	public long esfShootingDirectorId;
	public String esfCodeData;
	public long esfStartData;
	public long esfEndData;
	public Long esfUserId;
	public Long codeUser;
	public Long shootingDirectorQualificationId;
	public Long sportTypeId;
	public String regionId;
	public String provinceId;
	public String flagCrea;
	public long DateVar;
}