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

import it.ethica.esf.model.VW_DatiDrettoreTiro;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing VW_DatiDrettoreTiro in entity cache.
 *
 * @author Ethica
 * @see VW_DatiDrettoreTiro
 * @generated
 */
public class VW_DatiDrettoreTiroCacheModel implements CacheModel<VW_DatiDrettoreTiro>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{esfShootingDirectorId=");
		sb.append(esfShootingDirectorId);
		sb.append(", Nome=");
		sb.append(Nome);
		sb.append(", Cognome=");
		sb.append(Cognome);
		sb.append(", CodiceRegione=");
		sb.append(CodiceRegione);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public VW_DatiDrettoreTiro toEntityModel() {
		VW_DatiDrettoreTiroImpl vw_DatiDrettoreTiroImpl = new VW_DatiDrettoreTiroImpl();

		vw_DatiDrettoreTiroImpl.setEsfShootingDirectorId(esfShootingDirectorId);

		if (Nome == null) {
			vw_DatiDrettoreTiroImpl.setNome(StringPool.BLANK);
		}
		else {
			vw_DatiDrettoreTiroImpl.setNome(Nome);
		}

		if (Cognome == null) {
			vw_DatiDrettoreTiroImpl.setCognome(StringPool.BLANK);
		}
		else {
			vw_DatiDrettoreTiroImpl.setCognome(Cognome);
		}

		if (CodiceRegione == null) {
			vw_DatiDrettoreTiroImpl.setCodiceRegione(StringPool.BLANK);
		}
		else {
			vw_DatiDrettoreTiroImpl.setCodiceRegione(CodiceRegione);
		}

		vw_DatiDrettoreTiroImpl.resetOriginalValues();

		return vw_DatiDrettoreTiroImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		esfShootingDirectorId = objectInput.readLong();
		Nome = objectInput.readUTF();
		Cognome = objectInput.readUTF();
		CodiceRegione = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(esfShootingDirectorId);

		if (Nome == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(Nome);
		}

		if (Cognome == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(Cognome);
		}

		if (CodiceRegione == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(CodiceRegione);
		}
	}

	public long esfShootingDirectorId;
	public String Nome;
	public String Cognome;
	public String CodiceRegione;
}