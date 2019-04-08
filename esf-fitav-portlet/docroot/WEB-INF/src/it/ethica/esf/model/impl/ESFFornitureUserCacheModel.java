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

import it.ethica.esf.model.ESFFornitureUser;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ESFFornitureUser in entity cache.
 *
 * @author Ethica
 * @see ESFFornitureUser
 * @generated
 */
public class ESFFornitureUserCacheModel implements CacheModel<ESFFornitureUser>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{esfIDForniture=");
		sb.append(esfIDForniture);
		sb.append(", esfIdUser=");
		sb.append(esfIdUser);
		sb.append(", esfQuantity=");
		sb.append(esfQuantity);
		sb.append(", esfDateAssign=");
		sb.append(esfDateAssign);
		sb.append(", esfFornitureUserID=");
		sb.append(esfFornitureUserID);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ESFFornitureUser toEntityModel() {
		ESFFornitureUserImpl esfFornitureUserImpl = new ESFFornitureUserImpl();

		esfFornitureUserImpl.setEsfIDForniture(esfIDForniture);
		esfFornitureUserImpl.setEsfIdUser(esfIdUser);
		esfFornitureUserImpl.setEsfQuantity(esfQuantity);

		if (esfDateAssign == Long.MIN_VALUE) {
			esfFornitureUserImpl.setEsfDateAssign(null);
		}
		else {
			esfFornitureUserImpl.setEsfDateAssign(new Date(esfDateAssign));
		}

		esfFornitureUserImpl.setEsfFornitureUserID(esfFornitureUserID);

		esfFornitureUserImpl.resetOriginalValues();

		return esfFornitureUserImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		esfIDForniture = objectInput.readLong();
		esfIdUser = objectInput.readLong();
		esfQuantity = objectInput.readLong();
		esfDateAssign = objectInput.readLong();
		esfFornitureUserID = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(esfIDForniture);
		objectOutput.writeLong(esfIdUser);
		objectOutput.writeLong(esfQuantity);
		objectOutput.writeLong(esfDateAssign);
		objectOutput.writeLong(esfFornitureUserID);
	}

	public long esfIDForniture;
	public long esfIdUser;
	public long esfQuantity;
	public long esfDateAssign;
	public long esfFornitureUserID;
}