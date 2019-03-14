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

import it.ethica.esf.model.ESFOrganization;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ESFOrganization in entity cache.
 *
 * @author Ethica
 * @see ESFOrganization
 * @generated
 */
public class ESFOrganizationCacheModel implements CacheModel<ESFOrganization>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", esfOrganizationId=");
		sb.append(esfOrganizationId);
		sb.append(", code=");
		sb.append(code);
		sb.append(", vat=");
		sb.append(vat);
		sb.append(", fiscalCode=");
		sb.append(fiscalCode);
		sb.append(", establishmentDate=");
		sb.append(establishmentDate);
		sb.append(", closureDate=");
		sb.append(closureDate);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ESFOrganization toEntityModel() {
		ESFOrganizationImpl esfOrganizationImpl = new ESFOrganizationImpl();

		if (uuid == null) {
			esfOrganizationImpl.setUuid(StringPool.BLANK);
		}
		else {
			esfOrganizationImpl.setUuid(uuid);
		}

		esfOrganizationImpl.setEsfOrganizationId(esfOrganizationId);

		if (code == null) {
			esfOrganizationImpl.setCode(StringPool.BLANK);
		}
		else {
			esfOrganizationImpl.setCode(code);
		}

		if (vat == null) {
			esfOrganizationImpl.setVat(StringPool.BLANK);
		}
		else {
			esfOrganizationImpl.setVat(vat);
		}

		if (fiscalCode == null) {
			esfOrganizationImpl.setFiscalCode(StringPool.BLANK);
		}
		else {
			esfOrganizationImpl.setFiscalCode(fiscalCode);
		}

		if (establishmentDate == Long.MIN_VALUE) {
			esfOrganizationImpl.setEstablishmentDate(null);
		}
		else {
			esfOrganizationImpl.setEstablishmentDate(new Date(establishmentDate));
		}

		if (closureDate == Long.MIN_VALUE) {
			esfOrganizationImpl.setClosureDate(null);
		}
		else {
			esfOrganizationImpl.setClosureDate(new Date(closureDate));
		}

		esfOrganizationImpl.setGroupId(groupId);

		esfOrganizationImpl.resetOriginalValues();

		return esfOrganizationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		esfOrganizationId = objectInput.readLong();
		code = objectInput.readUTF();
		vat = objectInput.readUTF();
		fiscalCode = objectInput.readUTF();
		establishmentDate = objectInput.readLong();
		closureDate = objectInput.readLong();
		groupId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(esfOrganizationId);

		if (code == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(code);
		}

		if (vat == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(vat);
		}

		if (fiscalCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(fiscalCode);
		}

		objectOutput.writeLong(establishmentDate);
		objectOutput.writeLong(closureDate);
		objectOutput.writeLong(groupId);
	}

	public String uuid;
	public long esfOrganizationId;
	public String code;
	public String vat;
	public String fiscalCode;
	public long establishmentDate;
	public long closureDate;
	public long groupId;
}