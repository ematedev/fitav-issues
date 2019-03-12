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

import it.ethica.esf.model.ESFNationalMatchResult;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ESFNationalMatchResult in entity cache.
 *
 * @author Ethica
 * @see ESFNationalMatchResult
 * @generated
 */
public class ESFNationalMatchResultCacheModel implements CacheModel<ESFNationalMatchResult>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(35);

		sb.append("{esfNationalMatchResultId=");
		sb.append(esfNationalMatchResultId);
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
		sb.append(", esfUserId=");
		sb.append(esfUserId);
		sb.append(", position=");
		sb.append(position);
		sb.append(", qualification=");
		sb.append(qualification);
		sb.append(", shootOff=");
		sb.append(shootOff);
		sb.append(", clayPigeonTotal=");
		sb.append(clayPigeonTotal);
		sb.append(", finalResult=");
		sb.append(finalResult);
		sb.append(", shootOffFinal=");
		sb.append(shootOffFinal);
		sb.append(", externalShooter=");
		sb.append(externalShooter);
		sb.append(", externalName=");
		sb.append(externalName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ESFNationalMatchResult toEntityModel() {
		ESFNationalMatchResultImpl esfNationalMatchResultImpl = new ESFNationalMatchResultImpl();

		esfNationalMatchResultImpl.setEsfNationalMatchResultId(esfNationalMatchResultId);
		esfNationalMatchResultImpl.setGroupId(groupId);
		esfNationalMatchResultImpl.setCompanyId(companyId);
		esfNationalMatchResultImpl.setUserId(userId);

		if (userName == null) {
			esfNationalMatchResultImpl.setUserName(StringPool.BLANK);
		}
		else {
			esfNationalMatchResultImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			esfNationalMatchResultImpl.setCreateDate(null);
		}
		else {
			esfNationalMatchResultImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			esfNationalMatchResultImpl.setModifiedDate(null);
		}
		else {
			esfNationalMatchResultImpl.setModifiedDate(new Date(modifiedDate));
		}

		esfNationalMatchResultImpl.setEsfMatchId(esfMatchId);
		esfNationalMatchResultImpl.setEsfUserId(esfUserId);
		esfNationalMatchResultImpl.setPosition(position);
		esfNationalMatchResultImpl.setQualification(qualification);
		esfNationalMatchResultImpl.setShootOff(shootOff);
		esfNationalMatchResultImpl.setClayPigeonTotal(clayPigeonTotal);
		esfNationalMatchResultImpl.setFinalResult(finalResult);
		esfNationalMatchResultImpl.setShootOffFinal(shootOffFinal);
		esfNationalMatchResultImpl.setExternalShooter(externalShooter);

		if (externalName == null) {
			esfNationalMatchResultImpl.setExternalName(StringPool.BLANK);
		}
		else {
			esfNationalMatchResultImpl.setExternalName(externalName);
		}

		esfNationalMatchResultImpl.resetOriginalValues();

		return esfNationalMatchResultImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		esfNationalMatchResultId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		esfMatchId = objectInput.readLong();
		esfUserId = objectInput.readLong();
		position = objectInput.readInt();
		qualification = objectInput.readInt();
		shootOff = objectInput.readInt();
		clayPigeonTotal = objectInput.readInt();
		finalResult = objectInput.readInt();
		shootOffFinal = objectInput.readInt();
		externalShooter = objectInput.readBoolean();
		externalName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(esfNationalMatchResultId);
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
		objectOutput.writeLong(esfUserId);
		objectOutput.writeInt(position);
		objectOutput.writeInt(qualification);
		objectOutput.writeInt(shootOff);
		objectOutput.writeInt(clayPigeonTotal);
		objectOutput.writeInt(finalResult);
		objectOutput.writeInt(shootOffFinal);
		objectOutput.writeBoolean(externalShooter);

		if (externalName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(externalName);
		}
	}

	public long esfNationalMatchResultId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long esfMatchId;
	public long esfUserId;
	public int position;
	public int qualification;
	public int shootOff;
	public int clayPigeonTotal;
	public int finalResult;
	public int shootOffFinal;
	public boolean externalShooter;
	public String externalName;
}