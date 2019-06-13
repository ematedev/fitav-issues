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

import it.ethica.esf.model.ESFRadunoTipo;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ESFRadunoTipo in entity cache.
 *
 * @author Ethica
 * @see ESFRadunoTipo
 * @generated
 */
public class ESFRadunoTipoCacheModel implements CacheModel<ESFRadunoTipo>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{id_esf_raduno_tipo=");
		sb.append(id_esf_raduno_tipo);
		sb.append(", descrizione=");
		sb.append(descrizione);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ESFRadunoTipo toEntityModel() {
		ESFRadunoTipoImpl esfRadunoTipoImpl = new ESFRadunoTipoImpl();

		esfRadunoTipoImpl.setId_esf_raduno_tipo(id_esf_raduno_tipo);

		if (descrizione == null) {
			esfRadunoTipoImpl.setDescrizione(StringPool.BLANK);
		}
		else {
			esfRadunoTipoImpl.setDescrizione(descrizione);
		}

		esfRadunoTipoImpl.resetOriginalValues();

		return esfRadunoTipoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id_esf_raduno_tipo = objectInput.readLong();
		descrizione = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id_esf_raduno_tipo);

		if (descrizione == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(descrizione);
		}
	}

	public long id_esf_raduno_tipo;
	public String descrizione;
}