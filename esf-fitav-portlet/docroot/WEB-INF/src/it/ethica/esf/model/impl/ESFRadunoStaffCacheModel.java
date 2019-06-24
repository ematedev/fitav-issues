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
import com.liferay.portal.model.CacheModel;

import it.ethica.esf.model.ESFRadunoStaff;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ESFRadunoStaff in entity cache.
 *
 * @author Ethica
 * @see ESFRadunoStaff
 * @generated
 */
public class ESFRadunoStaffCacheModel implements CacheModel<ESFRadunoStaff>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{id_esf_raduno_staff=");
		sb.append(id_esf_raduno_staff);
		sb.append(", id_esf_raduno=");
		sb.append(id_esf_raduno);
		sb.append(", userId=");
		sb.append(userId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ESFRadunoStaff toEntityModel() {
		ESFRadunoStaffImpl esfRadunoStaffImpl = new ESFRadunoStaffImpl();

		esfRadunoStaffImpl.setId_esf_raduno_staff(id_esf_raduno_staff);
		esfRadunoStaffImpl.setId_esf_raduno(id_esf_raduno);
		esfRadunoStaffImpl.setUserId(userId);

		esfRadunoStaffImpl.resetOriginalValues();

		return esfRadunoStaffImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id_esf_raduno_staff = objectInput.readLong();
		id_esf_raduno = objectInput.readLong();
		userId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id_esf_raduno_staff);
		objectOutput.writeLong(id_esf_raduno);
		objectOutput.writeLong(userId);
	}

	public long id_esf_raduno_staff;
	public long id_esf_raduno;
	public long userId;
}