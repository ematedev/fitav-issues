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

import it.ethica.esf.model.ESFRadunoFiles;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ESFRadunoFiles in entity cache.
 *
 * @author Ethica
 * @see ESFRadunoFiles
 * @generated
 */
public class ESFRadunoFilesCacheModel implements CacheModel<ESFRadunoFiles>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{id_esf_raduno_files=");
		sb.append(id_esf_raduno_files);
		sb.append(", id_esf_raduno=");
		sb.append(id_esf_raduno);
		sb.append(", nome=");
		sb.append(nome);
		sb.append(", path=");
		sb.append(path);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ESFRadunoFiles toEntityModel() {
		ESFRadunoFilesImpl esfRadunoFilesImpl = new ESFRadunoFilesImpl();

		esfRadunoFilesImpl.setId_esf_raduno_files(id_esf_raduno_files);
		esfRadunoFilesImpl.setId_esf_raduno(id_esf_raduno);

		if (nome == null) {
			esfRadunoFilesImpl.setNome(StringPool.BLANK);
		}
		else {
			esfRadunoFilesImpl.setNome(nome);
		}

		if (path == null) {
			esfRadunoFilesImpl.setPath(StringPool.BLANK);
		}
		else {
			esfRadunoFilesImpl.setPath(path);
		}

		esfRadunoFilesImpl.resetOriginalValues();

		return esfRadunoFilesImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id_esf_raduno_files = objectInput.readLong();
		id_esf_raduno = objectInput.readLong();
		nome = objectInput.readUTF();
		path = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id_esf_raduno_files);
		objectOutput.writeLong(id_esf_raduno);

		if (nome == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(nome);
		}

		if (path == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(path);
		}
	}

	public long id_esf_raduno_files;
	public long id_esf_raduno;
	public String nome;
	public String path;
}