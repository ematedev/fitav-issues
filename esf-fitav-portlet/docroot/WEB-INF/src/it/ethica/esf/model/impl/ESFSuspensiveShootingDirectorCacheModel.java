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

import it.ethica.esf.model.ESFSuspensiveShootingDirector;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ESFSuspensiveShootingDirector in entity cache.
 *
 * @author Ethica
 * @see ESFSuspensiveShootingDirector
 * @generated
 */
public class ESFSuspensiveShootingDirectorCacheModel implements CacheModel<ESFSuspensiveShootingDirector>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(47);

		sb.append("{esfSuspensiveShooingDirectorId=");
		sb.append(esfSuspensiveShooingDirectorId);
		sb.append(", esfData=");
		sb.append(esfData);
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
		sb.append(", Codice_Sosp=");
		sb.append(Codice_Sosp);
		sb.append(", note=");
		sb.append(note);
		sb.append(", Qualif1_Utiliz=");
		sb.append(Qualif1_Utiliz);
		sb.append(", Qualif2_Utiliz=");
		sb.append(Qualif2_Utiliz);
		sb.append(", Qualif3_Utiliz=");
		sb.append(Qualif3_Utiliz);
		sb.append(", Tipo_Gara1_noUtil=");
		sb.append(Tipo_Gara1_noUtil);
		sb.append(", Tipo_Gara2_noUtil=");
		sb.append(Tipo_Gara2_noUtil);
		sb.append(", Tipo_Gara3_noUtil=");
		sb.append(Tipo_Gara3_noUtil);
		sb.append(", Tipo_Gara4_noUtil=");
		sb.append(Tipo_Gara4_noUtil);
		sb.append(", Tipo_Gara5_noUtil=");
		sb.append(Tipo_Gara5_noUtil);
		sb.append(", Tipo_Gara6_noUtil=");
		sb.append(Tipo_Gara6_noUtil);
		sb.append(", Tipo_Gara7_noUtil=");
		sb.append(Tipo_Gara7_noUtil);
		sb.append(", Tipo_Gara8_noUtil=");
		sb.append(Tipo_Gara8_noUtil);
		sb.append(", Tipo_Gara9_noUtil=");
		sb.append(Tipo_Gara9_noUtil);
		sb.append(", Tipo_Gara10_noUtil=");
		sb.append(Tipo_Gara10_noUtil);
		sb.append(", esfVariationData=");
		sb.append(esfVariationData);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ESFSuspensiveShootingDirector toEntityModel() {
		ESFSuspensiveShootingDirectorImpl esfSuspensiveShootingDirectorImpl = new ESFSuspensiveShootingDirectorImpl();

		esfSuspensiveShootingDirectorImpl.setEsfSuspensiveShooingDirectorId(esfSuspensiveShooingDirectorId);

		if (esfData == Long.MIN_VALUE) {
			esfSuspensiveShootingDirectorImpl.setEsfData(null);
		}
		else {
			esfSuspensiveShootingDirectorImpl.setEsfData(new Date(esfData));
		}

		if (esfCodeData == null) {
			esfSuspensiveShootingDirectorImpl.setEsfCodeData(StringPool.BLANK);
		}
		else {
			esfSuspensiveShootingDirectorImpl.setEsfCodeData(esfCodeData);
		}

		if (esfStartData == Long.MIN_VALUE) {
			esfSuspensiveShootingDirectorImpl.setEsfStartData(null);
		}
		else {
			esfSuspensiveShootingDirectorImpl.setEsfStartData(new Date(
					esfStartData));
		}

		if (esfEndData == Long.MIN_VALUE) {
			esfSuspensiveShootingDirectorImpl.setEsfEndData(null);
		}
		else {
			esfSuspensiveShootingDirectorImpl.setEsfEndData(new Date(esfEndData));
		}

		esfSuspensiveShootingDirectorImpl.setEsfUserId(esfUserId);
		esfSuspensiveShootingDirectorImpl.setCodeUser(codeUser);
		esfSuspensiveShootingDirectorImpl.setCodice_Sosp(Codice_Sosp);

		if (note == null) {
			esfSuspensiveShootingDirectorImpl.setNote(StringPool.BLANK);
		}
		else {
			esfSuspensiveShootingDirectorImpl.setNote(note);
		}

		esfSuspensiveShootingDirectorImpl.setQualif1_Utiliz(Qualif1_Utiliz);
		esfSuspensiveShootingDirectorImpl.setQualif2_Utiliz(Qualif2_Utiliz);
		esfSuspensiveShootingDirectorImpl.setQualif3_Utiliz(Qualif3_Utiliz);
		esfSuspensiveShootingDirectorImpl.setTipo_Gara1_noUtil(Tipo_Gara1_noUtil);
		esfSuspensiveShootingDirectorImpl.setTipo_Gara2_noUtil(Tipo_Gara2_noUtil);
		esfSuspensiveShootingDirectorImpl.setTipo_Gara3_noUtil(Tipo_Gara3_noUtil);
		esfSuspensiveShootingDirectorImpl.setTipo_Gara4_noUtil(Tipo_Gara4_noUtil);
		esfSuspensiveShootingDirectorImpl.setTipo_Gara5_noUtil(Tipo_Gara5_noUtil);
		esfSuspensiveShootingDirectorImpl.setTipo_Gara6_noUtil(Tipo_Gara6_noUtil);
		esfSuspensiveShootingDirectorImpl.setTipo_Gara7_noUtil(Tipo_Gara7_noUtil);
		esfSuspensiveShootingDirectorImpl.setTipo_Gara8_noUtil(Tipo_Gara8_noUtil);
		esfSuspensiveShootingDirectorImpl.setTipo_Gara9_noUtil(Tipo_Gara9_noUtil);
		esfSuspensiveShootingDirectorImpl.setTipo_Gara10_noUtil(Tipo_Gara10_noUtil);

		if (esfVariationData == Long.MIN_VALUE) {
			esfSuspensiveShootingDirectorImpl.setEsfVariationData(null);
		}
		else {
			esfSuspensiveShootingDirectorImpl.setEsfVariationData(new Date(
					esfVariationData));
		}

		esfSuspensiveShootingDirectorImpl.resetOriginalValues();

		return esfSuspensiveShootingDirectorImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		esfSuspensiveShooingDirectorId = objectInput.readLong();
		esfData = objectInput.readLong();
		esfCodeData = objectInput.readUTF();
		esfStartData = objectInput.readLong();
		esfEndData = objectInput.readLong();
		esfUserId = objectInput.readLong();
		codeUser = objectInput.readLong();
		Codice_Sosp = objectInput.readLong();
		note = objectInput.readUTF();
		Qualif1_Utiliz = objectInput.readLong();
		Qualif2_Utiliz = objectInput.readLong();
		Qualif3_Utiliz = objectInput.readLong();
		Tipo_Gara1_noUtil = objectInput.readLong();
		Tipo_Gara2_noUtil = objectInput.readLong();
		Tipo_Gara3_noUtil = objectInput.readLong();
		Tipo_Gara4_noUtil = objectInput.readLong();
		Tipo_Gara5_noUtil = objectInput.readLong();
		Tipo_Gara6_noUtil = objectInput.readLong();
		Tipo_Gara7_noUtil = objectInput.readLong();
		Tipo_Gara8_noUtil = objectInput.readLong();
		Tipo_Gara9_noUtil = objectInput.readLong();
		Tipo_Gara10_noUtil = objectInput.readLong();
		esfVariationData = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(esfSuspensiveShooingDirectorId);
		objectOutput.writeLong(esfData);

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
		objectOutput.writeLong(Codice_Sosp);

		if (note == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(note);
		}

		objectOutput.writeLong(Qualif1_Utiliz);
		objectOutput.writeLong(Qualif2_Utiliz);
		objectOutput.writeLong(Qualif3_Utiliz);
		objectOutput.writeLong(Tipo_Gara1_noUtil);
		objectOutput.writeLong(Tipo_Gara2_noUtil);
		objectOutput.writeLong(Tipo_Gara3_noUtil);
		objectOutput.writeLong(Tipo_Gara4_noUtil);
		objectOutput.writeLong(Tipo_Gara5_noUtil);
		objectOutput.writeLong(Tipo_Gara6_noUtil);
		objectOutput.writeLong(Tipo_Gara7_noUtil);
		objectOutput.writeLong(Tipo_Gara8_noUtil);
		objectOutput.writeLong(Tipo_Gara9_noUtil);
		objectOutput.writeLong(Tipo_Gara10_noUtil);
		objectOutput.writeLong(esfVariationData);
	}

	public long esfSuspensiveShooingDirectorId;
	public long esfData;
	public String esfCodeData;
	public long esfStartData;
	public long esfEndData;
	public long esfUserId;
	public long codeUser;
	public long Codice_Sosp;
	public String note;
	public long Qualif1_Utiliz;
	public long Qualif2_Utiliz;
	public long Qualif3_Utiliz;
	public long Tipo_Gara1_noUtil;
	public long Tipo_Gara2_noUtil;
	public long Tipo_Gara3_noUtil;
	public long Tipo_Gara4_noUtil;
	public long Tipo_Gara5_noUtil;
	public long Tipo_Gara6_noUtil;
	public long Tipo_Gara7_noUtil;
	public long Tipo_Gara8_noUtil;
	public long Tipo_Gara9_noUtil;
	public long Tipo_Gara10_noUtil;
	public long esfVariationData;
}