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

import it.ethica.esf.model.ESFTransition;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ESFTransition in entity cache.
 *
 * @author Ethica
 * @see ESFTransition
 * @generated
 */
public class ESFTransitionCacheModel implements CacheModel<ESFTransition>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{esfTransitionId=");
		sb.append(esfTransitionId);
		sb.append(", esfUserId=");
		sb.append(esfUserId);
		sb.append(", esfCategoryId=");
		sb.append(esfCategoryId);
		sb.append(", season=");
		sb.append(season);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ESFTransition toEntityModel() {
		ESFTransitionImpl esfTransitionImpl = new ESFTransitionImpl();

		esfTransitionImpl.setEsfTransitionId(esfTransitionId);
		esfTransitionImpl.setEsfUserId(esfUserId);
		esfTransitionImpl.setEsfCategoryId(esfCategoryId);

		if (season == null) {
			esfTransitionImpl.setSeason(StringPool.BLANK);
		}
		else {
			esfTransitionImpl.setSeason(season);
		}

		esfTransitionImpl.resetOriginalValues();

		return esfTransitionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		esfTransitionId = objectInput.readLong();
		esfUserId = objectInput.readLong();
		esfCategoryId = objectInput.readLong();
		season = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(esfTransitionId);
		objectOutput.writeLong(esfUserId);
		objectOutput.writeLong(esfCategoryId);

		if (season == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(season);
		}
	}

	public long esfTransitionId;
	public long esfUserId;
	public long esfCategoryId;
	public String season;
}