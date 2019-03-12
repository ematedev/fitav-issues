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
import com.liferay.portal.model.CacheModel;

import it.ethica.esf.model.ESFPhone;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ESFPhone in entity cache.
 *
 * @author Ethica
 * @see ESFPhone
 * @generated
 */
public class ESFPhoneCacheModel implements CacheModel<ESFPhone>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{esfPhoneId=");
		sb.append(esfPhoneId);
		sb.append(", listTypeId=");
		sb.append(listTypeId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ESFPhone toEntityModel() {
		ESFPhoneImpl esfPhoneImpl = new ESFPhoneImpl();

		esfPhoneImpl.setEsfPhoneId(esfPhoneId);
		esfPhoneImpl.setListTypeId(listTypeId);

		esfPhoneImpl.resetOriginalValues();

		return esfPhoneImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		esfPhoneId = objectInput.readLong();
		listTypeId = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(esfPhoneId);
		objectOutput.writeInt(listTypeId);
	}

	public long esfPhoneId;
	public int listTypeId;
}