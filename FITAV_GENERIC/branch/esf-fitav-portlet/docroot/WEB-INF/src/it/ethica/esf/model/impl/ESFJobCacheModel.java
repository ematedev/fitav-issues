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
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import it.ethica.esf.model.ESFJob;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ESFJob in entity cache.
 *
 * @author Ethica
 * @see ESFJob
 * @generated
 */
public class ESFJobCacheModel implements CacheModel<ESFJob>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{esfJobId=");
		sb.append(esfJobId);
		sb.append(", esfName=");
		sb.append(esfName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ESFJob toEntityModel() {
		ESFJobImpl esfJobImpl = new ESFJobImpl();

		esfJobImpl.setEsfJobId(esfJobId);

		if (esfName == null) {
			esfJobImpl.setEsfName(StringPool.BLANK);
		}
		else {
			esfJobImpl.setEsfName(esfName);
		}

		esfJobImpl.resetOriginalValues();

		return esfJobImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		esfJobId = objectInput.readLong();
		esfName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(esfJobId);

		if (esfName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(esfName);
		}
	}

	public long esfJobId;
	public String esfName;
}