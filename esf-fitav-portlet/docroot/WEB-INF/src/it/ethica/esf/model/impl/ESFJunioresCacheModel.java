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

import it.ethica.esf.model.ESFJuniores;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ESFJuniores in entity cache.
 *
 * @author Ethica
 * @see ESFJuniores
 * @generated
 */
public class ESFJunioresCacheModel implements CacheModel<ESFJuniores>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{ESFUserId=");
		sb.append(ESFUserId);
		sb.append(", startDate=");
		sb.append(startDate);
		sb.append(", endDate=");
		sb.append(endDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ESFJuniores toEntityModel() {
		ESFJunioresImpl esfJunioresImpl = new ESFJunioresImpl();

		esfJunioresImpl.setESFUserId(ESFUserId);

		if (startDate == Long.MIN_VALUE) {
			esfJunioresImpl.setStartDate(null);
		}
		else {
			esfJunioresImpl.setStartDate(new Date(startDate));
		}

		if (endDate == Long.MIN_VALUE) {
			esfJunioresImpl.setEndDate(null);
		}
		else {
			esfJunioresImpl.setEndDate(new Date(endDate));
		}

		esfJunioresImpl.resetOriginalValues();

		return esfJunioresImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		ESFUserId = objectInput.readLong();
		startDate = objectInput.readLong();
		endDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(ESFUserId);
		objectOutput.writeLong(startDate);
		objectOutput.writeLong(endDate);
	}

	public long ESFUserId;
	public long startDate;
	public long endDate;
}