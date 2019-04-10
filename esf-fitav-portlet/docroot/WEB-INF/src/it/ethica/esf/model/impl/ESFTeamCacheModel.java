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

import it.ethica.esf.model.ESFTeam;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ESFTeam in entity cache.
 *
 * @author Ethica
 * @see ESFTeam
 * @generated
 */
public class ESFTeamCacheModel implements CacheModel<ESFTeam>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{esfTeamId=");
		sb.append(esfTeamId);
		sb.append(", esfTournamentId=");
		sb.append(esfTournamentId);
		sb.append(", name=");
		sb.append(name);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ESFTeam toEntityModel() {
		ESFTeamImpl esfTeamImpl = new ESFTeamImpl();

		esfTeamImpl.setEsfTeamId(esfTeamId);
		esfTeamImpl.setEsfTournamentId(esfTournamentId);

		if (name == null) {
			esfTeamImpl.setName(StringPool.BLANK);
		}
		else {
			esfTeamImpl.setName(name);
		}

		esfTeamImpl.resetOriginalValues();

		return esfTeamImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		esfTeamId = objectInput.readLong();
		esfTournamentId = objectInput.readLong();
		name = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(esfTeamId);
		objectOutput.writeLong(esfTournamentId);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}
	}

	public long esfTeamId;
	public long esfTournamentId;
	public String name;
}