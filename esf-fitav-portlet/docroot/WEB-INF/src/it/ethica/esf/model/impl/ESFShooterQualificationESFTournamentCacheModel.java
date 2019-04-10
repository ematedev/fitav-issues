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

import it.ethica.esf.model.ESFShooterQualificationESFTournament;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ESFShooterQualificationESFTournament in entity cache.
 *
 * @author Ethica
 * @see ESFShooterQualificationESFTournament
 * @generated
 */
public class ESFShooterQualificationESFTournamentCacheModel
	implements CacheModel<ESFShooterQualificationESFTournament>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", esfShooterQualificationId=");
		sb.append(esfShooterQualificationId);
		sb.append(", esfTournamentId=");
		sb.append(esfTournamentId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ESFShooterQualificationESFTournament toEntityModel() {
		ESFShooterQualificationESFTournamentImpl esfShooterQualificationESFTournamentImpl =
			new ESFShooterQualificationESFTournamentImpl();

		if (uuid == null) {
			esfShooterQualificationESFTournamentImpl.setUuid(StringPool.BLANK);
		}
		else {
			esfShooterQualificationESFTournamentImpl.setUuid(uuid);
		}

		esfShooterQualificationESFTournamentImpl.setEsfShooterQualificationId(esfShooterQualificationId);
		esfShooterQualificationESFTournamentImpl.setEsfTournamentId(esfTournamentId);
		esfShooterQualificationESFTournamentImpl.setGroupId(groupId);

		esfShooterQualificationESFTournamentImpl.resetOriginalValues();

		return esfShooterQualificationESFTournamentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		esfShooterQualificationId = objectInput.readLong();
		esfTournamentId = objectInput.readLong();
		groupId = objectInput.readLong();
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

		objectOutput.writeLong(esfShooterQualificationId);
		objectOutput.writeLong(esfTournamentId);
		objectOutput.writeLong(groupId);
	}

	public String uuid;
	public long esfShooterQualificationId;
	public long esfTournamentId;
	public long groupId;
}