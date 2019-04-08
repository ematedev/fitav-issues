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

import it.ethica.esf.model.ESFLentField;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ESFLentField in entity cache.
 *
 * @author Ethica
 * @see ESFLentField
 * @generated
 */
public class ESFLentFieldCacheModel implements CacheModel<ESFLentField>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{lentFieldId=");
		sb.append(lentFieldId);
		sb.append(", esfEntityStateId=");
		sb.append(esfEntityStateId);
		sb.append(", esfFieldId=");
		sb.append(esfFieldId);
		sb.append(", realOwnerId=");
		sb.append(realOwnerId);
		sb.append(", actualOwnerId=");
		sb.append(actualOwnerId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ESFLentField toEntityModel() {
		ESFLentFieldImpl esfLentFieldImpl = new ESFLentFieldImpl();

		esfLentFieldImpl.setLentFieldId(lentFieldId);
		esfLentFieldImpl.setEsfEntityStateId(esfEntityStateId);
		esfLentFieldImpl.setEsfFieldId(esfFieldId);
		esfLentFieldImpl.setRealOwnerId(realOwnerId);
		esfLentFieldImpl.setActualOwnerId(actualOwnerId);

		esfLentFieldImpl.resetOriginalValues();

		return esfLentFieldImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		lentFieldId = objectInput.readLong();
		esfEntityStateId = objectInput.readLong();
		esfFieldId = objectInput.readLong();
		realOwnerId = objectInput.readLong();
		actualOwnerId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(lentFieldId);
		objectOutput.writeLong(esfEntityStateId);
		objectOutput.writeLong(esfFieldId);
		objectOutput.writeLong(realOwnerId);
		objectOutput.writeLong(actualOwnerId);
	}

	public long lentFieldId;
	public long esfEntityStateId;
	public long esfFieldId;
	public long realOwnerId;
	public long actualOwnerId;
}