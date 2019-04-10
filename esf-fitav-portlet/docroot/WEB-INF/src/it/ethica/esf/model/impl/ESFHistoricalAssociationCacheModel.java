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

import it.ethica.esf.model.ESFHistoricalAssociation;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ESFHistoricalAssociation in entity cache.
 *
 * @author Ethica
 * @see ESFHistoricalAssociation
 * @generated
 */
public class ESFHistoricalAssociationCacheModel implements CacheModel<ESFHistoricalAssociation>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{idHistoricalAssociation=");
		sb.append(idHistoricalAssociation);
		sb.append(", name=");
		sb.append(name);
		sb.append(", code=");
		sb.append(code);
		sb.append(", dateChange=");
		sb.append(dateChange);
		sb.append(", endDate=");
		sb.append(endDate);
		sb.append(", organizationId=");
		sb.append(organizationId);
		sb.append(", stateId=");
		sb.append(stateId);
		sb.append(", variationId=");
		sb.append(variationId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ESFHistoricalAssociation toEntityModel() {
		ESFHistoricalAssociationImpl esfHistoricalAssociationImpl = new ESFHistoricalAssociationImpl();

		esfHistoricalAssociationImpl.setIdHistoricalAssociation(idHistoricalAssociation);

		if (name == null) {
			esfHistoricalAssociationImpl.setName(StringPool.BLANK);
		}
		else {
			esfHistoricalAssociationImpl.setName(name);
		}

		if (code == null) {
			esfHistoricalAssociationImpl.setCode(StringPool.BLANK);
		}
		else {
			esfHistoricalAssociationImpl.setCode(code);
		}

		if (dateChange == Long.MIN_VALUE) {
			esfHistoricalAssociationImpl.setDateChange(null);
		}
		else {
			esfHistoricalAssociationImpl.setDateChange(new Date(dateChange));
		}

		if (endDate == Long.MIN_VALUE) {
			esfHistoricalAssociationImpl.setEndDate(null);
		}
		else {
			esfHistoricalAssociationImpl.setEndDate(new Date(endDate));
		}

		esfHistoricalAssociationImpl.setOrganizationId(organizationId);
		esfHistoricalAssociationImpl.setStateId(stateId);
		esfHistoricalAssociationImpl.setVariationId(variationId);

		esfHistoricalAssociationImpl.resetOriginalValues();

		return esfHistoricalAssociationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		idHistoricalAssociation = objectInput.readLong();
		name = objectInput.readUTF();
		code = objectInput.readUTF();
		dateChange = objectInput.readLong();
		endDate = objectInput.readLong();
		organizationId = objectInput.readLong();
		stateId = objectInput.readLong();
		variationId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(idHistoricalAssociation);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (code == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(code);
		}

		objectOutput.writeLong(dateChange);
		objectOutput.writeLong(endDate);
		objectOutput.writeLong(organizationId);
		objectOutput.writeLong(stateId);
		objectOutput.writeLong(variationId);
	}

	public long idHistoricalAssociation;
	public String name;
	public String code;
	public long dateChange;
	public long endDate;
	public long organizationId;
	public long stateId;
	public long variationId;
}