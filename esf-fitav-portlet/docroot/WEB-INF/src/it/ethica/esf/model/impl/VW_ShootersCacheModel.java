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

import it.ethica.esf.model.VW_Shooters;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing VW_Shooters in entity cache.
 *
 * @author Ethica
 * @see VW_Shooters
 * @generated
 */
public class VW_ShootersCacheModel implements CacheModel<VW_Shooters>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{userId=");
		sb.append(userId);
		sb.append(", CodiceTessera=");
		sb.append(CodiceTessera);
		sb.append(", CodiceOrganizzazione=");
		sb.append(CodiceOrganizzazione);
		sb.append(", Nome=");
		sb.append(Nome);
		sb.append(", Cognome=");
		sb.append(Cognome);
		sb.append(", Email=");
		sb.append(Email);
		sb.append(", CF=");
		sb.append(CF);
		sb.append(", organizationId=");
		sb.append(organizationId);
		sb.append(", invitato=");
		sb.append(invitato);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public VW_Shooters toEntityModel() {
		VW_ShootersImpl vw_ShootersImpl = new VW_ShootersImpl();

		vw_ShootersImpl.setUserId(userId);

		if (CodiceTessera == null) {
			vw_ShootersImpl.setCodiceTessera(StringPool.BLANK);
		}
		else {
			vw_ShootersImpl.setCodiceTessera(CodiceTessera);
		}

		if (CodiceOrganizzazione == null) {
			vw_ShootersImpl.setCodiceOrganizzazione(StringPool.BLANK);
		}
		else {
			vw_ShootersImpl.setCodiceOrganizzazione(CodiceOrganizzazione);
		}

		if (Nome == null) {
			vw_ShootersImpl.setNome(StringPool.BLANK);
		}
		else {
			vw_ShootersImpl.setNome(Nome);
		}

		if (Cognome == null) {
			vw_ShootersImpl.setCognome(StringPool.BLANK);
		}
		else {
			vw_ShootersImpl.setCognome(Cognome);
		}

		if (Email == null) {
			vw_ShootersImpl.setEmail(StringPool.BLANK);
		}
		else {
			vw_ShootersImpl.setEmail(Email);
		}

		if (CF == null) {
			vw_ShootersImpl.setCF(StringPool.BLANK);
		}
		else {
			vw_ShootersImpl.setCF(CF);
		}

		vw_ShootersImpl.setOrganizationId(organizationId);
		vw_ShootersImpl.setInvitato(invitato);

		vw_ShootersImpl.resetOriginalValues();

		return vw_ShootersImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		userId = objectInput.readLong();
		CodiceTessera = objectInput.readUTF();
		CodiceOrganizzazione = objectInput.readUTF();
		Nome = objectInput.readUTF();
		Cognome = objectInput.readUTF();
		Email = objectInput.readUTF();
		CF = objectInput.readUTF();
		organizationId = objectInput.readLong();
		invitato = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(userId);

		if (CodiceTessera == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(CodiceTessera);
		}

		if (CodiceOrganizzazione == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(CodiceOrganizzazione);
		}

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

		if (Email == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(Email);
		}

		if (CF == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(CF);
		}

		objectOutput.writeLong(organizationId);
		objectOutput.writeInt(invitato);
	}

	public long userId;
	public String CodiceTessera;
	public String CodiceOrganizzazione;
	public String Nome;
	public String Cognome;
	public String Email;
	public String CF;
	public long organizationId;
	public int invitato;
}