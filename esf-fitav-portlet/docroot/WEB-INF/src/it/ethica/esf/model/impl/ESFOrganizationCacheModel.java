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
		StringBundler sb = new StringBundler(63);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", esfOrganizationId=");
		sb.append(esfOrganizationId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", code=");
		sb.append(code);
		sb.append(", vat=");
		sb.append(vat);
		sb.append(", fiscalCode=");
		sb.append(fiscalCode);
		sb.append(", ibanCode=");
		sb.append(ibanCode);
		sb.append(", isMultiSport=");
		sb.append(isMultiSport);
		sb.append(", legalForm=");
		sb.append(legalForm);
		sb.append(", category=");
		sb.append(category);
		sb.append(", establishmentDate=");
		sb.append(establishmentDate);
		sb.append(", closureDate=");
		sb.append(closureDate);
		sb.append(", type=");
		sb.append(type);
		sb.append(", insertDate=");
		sb.append(insertDate);
		sb.append(", coniDate=");
		sb.append(coniDate);
		sb.append(", coniCode=");
		sb.append(coniCode);
		sb.append(", description=");
		sb.append(description);
		sb.append(", isYouthActive=");
		sb.append(isYouthActive);
		sb.append(", firstAffiliationDate=");
		sb.append(firstAffiliationDate);
		sb.append(", variations=");
		sb.append(variations);
		sb.append(", regionCode=");
		sb.append(regionCode);
		sb.append(", idFatherAssociation=");
		sb.append(idFatherAssociation);
		sb.append(", constitutiveAct=");
		sb.append(constitutiveAct);
		sb.append(", registeredStatus=");
		sb.append(registeredStatus);
		sb.append(", planimetrySportsStand=");
		sb.append(planimetrySportsStand);
		sb.append(", certificateFITAV=");
		sb.append(certificateFITAV);
		sb.append(", note=");
		sb.append(note);
		sb.append(", isSimplyOrganizzation=");
		sb.append(isSimplyOrganizzation);
		sb.append(", webSite=");
		sb.append(webSite);
		sb.append(", includeConiReport=");
		sb.append(includeConiReport);
		sb.append(", organizzationCategory=");
		sb.append(organizzationCategory);
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
		esfOrganizationImpl.setGroupId(groupId);

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

		if (ibanCode == null) {
			esfOrganizationImpl.setIbanCode(StringPool.BLANK);
		}
		else {
			esfOrganizationImpl.setIbanCode(ibanCode);
		}

		esfOrganizationImpl.setIsMultiSport(isMultiSport);

		if (legalForm == null) {
			esfOrganizationImpl.setLegalForm(StringPool.BLANK);
		}
		else {
			esfOrganizationImpl.setLegalForm(legalForm);
		}

		if (category == null) {
			esfOrganizationImpl.setCategory(StringPool.BLANK);
		}
		else {
			esfOrganizationImpl.setCategory(category);
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

		esfOrganizationImpl.setType(type);

		if (insertDate == Long.MIN_VALUE) {
			esfOrganizationImpl.setInsertDate(null);
		}
		else {
			esfOrganizationImpl.setInsertDate(new Date(insertDate));
		}

		if (coniDate == Long.MIN_VALUE) {
			esfOrganizationImpl.setConiDate(null);
		}
		else {
			esfOrganizationImpl.setConiDate(new Date(coniDate));
		}

		if (coniCode == null) {
			esfOrganizationImpl.setConiCode(StringPool.BLANK);
		}
		else {
			esfOrganizationImpl.setConiCode(coniCode);
		}

		if (description == null) {
			esfOrganizationImpl.setDescription(StringPool.BLANK);
		}
		else {
			esfOrganizationImpl.setDescription(description);
		}

		esfOrganizationImpl.setIsYouthActive(isYouthActive);

		if (firstAffiliationDate == Long.MIN_VALUE) {
			esfOrganizationImpl.setFirstAffiliationDate(null);
		}
		else {
			esfOrganizationImpl.setFirstAffiliationDate(new Date(
					firstAffiliationDate));
		}

		esfOrganizationImpl.setVariations(variations);
		esfOrganizationImpl.setRegionCode(regionCode);
		esfOrganizationImpl.setIdFatherAssociation(idFatherAssociation);
		esfOrganizationImpl.setConstitutiveAct(constitutiveAct);
		esfOrganizationImpl.setRegisteredStatus(registeredStatus);
		esfOrganizationImpl.setPlanimetrySportsStand(planimetrySportsStand);
		esfOrganizationImpl.setCertificateFITAV(certificateFITAV);

		if (note == null) {
			esfOrganizationImpl.setNote(StringPool.BLANK);
		}
		else {
			esfOrganizationImpl.setNote(note);
		}

		esfOrganizationImpl.setIsSimplyOrganizzation(isSimplyOrganizzation);

		if (webSite == null) {
			esfOrganizationImpl.setWebSite(StringPool.BLANK);
		}
		else {
			esfOrganizationImpl.setWebSite(webSite);
		}

		esfOrganizationImpl.setIncludeConiReport(includeConiReport);

		if (organizzationCategory == null) {
			esfOrganizationImpl.setOrganizzationCategory(StringPool.BLANK);
		}
		else {
			esfOrganizationImpl.setOrganizzationCategory(organizzationCategory);
		}

		esfOrganizationImpl.resetOriginalValues();

		return esfOrganizationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		esfOrganizationId = objectInput.readLong();
		groupId = objectInput.readLong();
		code = objectInput.readUTF();
		vat = objectInput.readUTF();
		fiscalCode = objectInput.readUTF();
		ibanCode = objectInput.readUTF();
		isMultiSport = objectInput.readBoolean();
		legalForm = objectInput.readUTF();
		category = objectInput.readUTF();
		establishmentDate = objectInput.readLong();
		closureDate = objectInput.readLong();
		type = objectInput.readInt();
		insertDate = objectInput.readLong();
		coniDate = objectInput.readLong();
		coniCode = objectInput.readUTF();
		description = objectInput.readUTF();
		isYouthActive = objectInput.readBoolean();
		firstAffiliationDate = objectInput.readLong();
		variations = objectInput.readLong();
		regionCode = objectInput.readLong();
		idFatherAssociation = objectInput.readLong();
		constitutiveAct = objectInput.readBoolean();
		registeredStatus = objectInput.readBoolean();
		planimetrySportsStand = objectInput.readBoolean();
		certificateFITAV = objectInput.readBoolean();
		note = objectInput.readUTF();
		isSimplyOrganizzation = objectInput.readBoolean();
		webSite = objectInput.readUTF();
		includeConiReport = objectInput.readBoolean();
		organizzationCategory = objectInput.readUTF();
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
		objectOutput.writeLong(groupId);

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

		if (ibanCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ibanCode);
		}

		objectOutput.writeBoolean(isMultiSport);

		if (legalForm == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(legalForm);
		}

		if (category == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(category);
		}

		objectOutput.writeLong(establishmentDate);
		objectOutput.writeLong(closureDate);
		objectOutput.writeInt(type);
		objectOutput.writeLong(insertDate);
		objectOutput.writeLong(coniDate);

		if (coniCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(coniCode);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeBoolean(isYouthActive);
		objectOutput.writeLong(firstAffiliationDate);
		objectOutput.writeLong(variations);
		objectOutput.writeLong(regionCode);
		objectOutput.writeLong(idFatherAssociation);
		objectOutput.writeBoolean(constitutiveAct);
		objectOutput.writeBoolean(registeredStatus);
		objectOutput.writeBoolean(planimetrySportsStand);
		objectOutput.writeBoolean(certificateFITAV);

		if (note == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(note);
		}

		objectOutput.writeBoolean(isSimplyOrganizzation);

		if (webSite == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(webSite);
		}

		objectOutput.writeBoolean(includeConiReport);

		if (organizzationCategory == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(organizzationCategory);
		}
	}

	public String uuid;
	public long esfOrganizationId;
	public long groupId;
	public String code;
	public String vat;
	public String fiscalCode;
	public String ibanCode;
	public boolean isMultiSport;
	public String legalForm;
	public String category;
	public long establishmentDate;
	public long closureDate;
	public int type;
	public long insertDate;
	public long coniDate;
	public String coniCode;
	public String description;
	public boolean isYouthActive;
	public long firstAffiliationDate;
	public long variations;
	public long regionCode;
	public long idFatherAssociation;
	public boolean constitutiveAct;
	public boolean registeredStatus;
	public boolean planimetrySportsStand;
	public boolean certificateFITAV;
	public String note;
	public boolean isSimplyOrganizzation;
	public String webSite;
	public boolean includeConiReport;
	public String organizzationCategory;
}