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

import it.ethica.esf.model.ESFShooterCategoryESFTournament;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ESFShooterCategoryESFTournament in entity cache.
 *
 * @author Ethica
 * @see ESFShooterCategoryESFTournament
 * @generated
 */
public class ESFShooterCategoryESFTournamentCacheModel implements CacheModel<ESFShooterCategoryESFTournament>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", esfShooterCategoryId=");
		sb.append(esfShooterCategoryId);
		sb.append(", esfTournamentId=");
		sb.append(esfTournamentId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ESFShooterCategoryESFTournament toEntityModel() {
		ESFShooterCategoryESFTournamentImpl esfShooterCategoryESFTournamentImpl = new ESFShooterCategoryESFTournamentImpl();

		if (uuid == null) {
			esfShooterCategoryESFTournamentImpl.setUuid(StringPool.BLANK);
		}
		else {
			esfShooterCategoryESFTournamentImpl.setUuid(uuid);
		}

		esfShooterCategoryESFTournamentImpl.setEsfShooterCategoryId(esfShooterCategoryId);
		esfShooterCategoryESFTournamentImpl.setEsfTournamentId(esfTournamentId);
		esfShooterCategoryESFTournamentImpl.setGroupId(groupId);

		esfShooterCategoryESFTournamentImpl.resetOriginalValues();

		return esfShooterCategoryESFTournamentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		esfShooterCategoryId = objectInput.readLong();
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

		objectOutput.writeLong(esfShooterCategoryId);
		objectOutput.writeLong(esfTournamentId);
		objectOutput.writeLong(groupId);
	}

	public String uuid;
	public long esfShooterCategoryId;
	public long esfTournamentId;
	public long groupId;
}