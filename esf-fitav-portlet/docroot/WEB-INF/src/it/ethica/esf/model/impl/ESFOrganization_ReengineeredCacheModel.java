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

import it.ethica.esf.model.ESFOrganization_Reengineered;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ESFOrganization_Reengineered in entity cache.
 *
 * @author Ethica
 * @see ESFOrganization_Reengineered
 * @generated
 */
public class ESFOrganization_ReengineeredCacheModel implements CacheModel<ESFOrganization_Reengineered>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(61);

		sb.append("{esfOrganizationId=");
		sb.append(esfOrganizationId);
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
		sb.append(", type_=");
		sb.append(type_);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ESFOrganization_Reengineered toEntityModel() {
		ESFOrganization_ReengineeredImpl esfOrganization_ReengineeredImpl = new ESFOrganization_ReengineeredImpl();

		esfOrganization_ReengineeredImpl.setEsfOrganizationId(esfOrganizationId);

		if (code == null) {
			esfOrganization_ReengineeredImpl.setCode(StringPool.BLANK);
		}
		else {
			esfOrganization_ReengineeredImpl.setCode(code);
		}

		if (vat == null) {
			esfOrganization_ReengineeredImpl.setVat(StringPool.BLANK);
		}
		else {
			esfOrganization_ReengineeredImpl.setVat(vat);
		}

		if (fiscalCode == null) {
			esfOrganization_ReengineeredImpl.setFiscalCode(StringPool.BLANK);
		}
		else {
			esfOrganization_ReengineeredImpl.setFiscalCode(fiscalCode);
		}

		if (ibanCode == null) {
			esfOrganization_ReengineeredImpl.setIbanCode(StringPool.BLANK);
		}
		else {
			esfOrganization_ReengineeredImpl.setIbanCode(ibanCode);
		}

		esfOrganization_ReengineeredImpl.setIsMultiSport(isMultiSport);

		if (legalForm == null) {
			esfOrganization_ReengineeredImpl.setLegalForm(StringPool.BLANK);
		}
		else {
			esfOrganization_ReengineeredImpl.setLegalForm(legalForm);
		}

		if (category == null) {
			esfOrganization_ReengineeredImpl.setCategory(StringPool.BLANK);
		}
		else {
			esfOrganization_ReengineeredImpl.setCategory(category);
		}

		if (establishmentDate == Long.MIN_VALUE) {
			esfOrganization_ReengineeredImpl.setEstablishmentDate(null);
		}
		else {
			esfOrganization_ReengineeredImpl.setEstablishmentDate(new Date(
					establishmentDate));
		}

		if (closureDate == Long.MIN_VALUE) {
			esfOrganization_ReengineeredImpl.setClosureDate(null);
		}
		else {
			esfOrganization_ReengineeredImpl.setClosureDate(new Date(
					closureDate));
		}

		esfOrganization_ReengineeredImpl.setType(type);

		if (insertDate == Long.MIN_VALUE) {
			esfOrganization_ReengineeredImpl.setInsertDate(null);
		}
		else {
			esfOrganization_ReengineeredImpl.setInsertDate(new Date(insertDate));
		}

		if (coniDate == Long.MIN_VALUE) {
			esfOrganization_ReengineeredImpl.setConiDate(null);
		}
		else {
			esfOrganization_ReengineeredImpl.setConiDate(new Date(coniDate));
		}

		if (coniCode == null) {
			esfOrganization_ReengineeredImpl.setConiCode(StringPool.BLANK);
		}
		else {
			esfOrganization_ReengineeredImpl.setConiCode(coniCode);
		}

		if (description == null) {
			esfOrganization_ReengineeredImpl.setDescription(StringPool.BLANK);
		}
		else {
			esfOrganization_ReengineeredImpl.setDescription(description);
		}

		esfOrganization_ReengineeredImpl.setIsYouthActive(isYouthActive);

		if (firstAffiliationDate == Long.MIN_VALUE) {
			esfOrganization_ReengineeredImpl.setFirstAffiliationDate(null);
		}
		else {
			esfOrganization_ReengineeredImpl.setFirstAffiliationDate(new Date(
					firstAffiliationDate));
		}

		esfOrganization_ReengineeredImpl.setVariations(variations);
		esfOrganization_ReengineeredImpl.setRegionCode(regionCode);
		esfOrganization_ReengineeredImpl.setIdFatherAssociation(idFatherAssociation);
		esfOrganization_ReengineeredImpl.setConstitutiveAct(constitutiveAct);
		esfOrganization_ReengineeredImpl.setRegisteredStatus(registeredStatus);
		esfOrganization_ReengineeredImpl.setPlanimetrySportsStand(planimetrySportsStand);
		esfOrganization_ReengineeredImpl.setCertificateFITAV(certificateFITAV);

		if (note == null) {
			esfOrganization_ReengineeredImpl.setNote(StringPool.BLANK);
		}
		else {
			esfOrganization_ReengineeredImpl.setNote(note);
		}

		esfOrganization_ReengineeredImpl.setIsSimplyOrganizzation(isSimplyOrganizzation);

		if (webSite == null) {
			esfOrganization_ReengineeredImpl.setWebSite(StringPool.BLANK);
		}
		else {
			esfOrganization_ReengineeredImpl.setWebSite(webSite);
		}

		esfOrganization_ReengineeredImpl.setIncludeConiReport(includeConiReport);

		if (organizzationCategory == null) {
			esfOrganization_ReengineeredImpl.setOrganizzationCategory(StringPool.BLANK);
		}
		else {
			esfOrganization_ReengineeredImpl.setOrganizzationCategory(organizzationCategory);
		}

		esfOrganization_ReengineeredImpl.setType_(type_);

		esfOrganization_ReengineeredImpl.resetOriginalValues();

		return esfOrganization_ReengineeredImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		esfOrganizationId = objectInput.readLong();
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
		type_ = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
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

		objectOutput.writeInt(type_);
	}

	public long esfOrganizationId;
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
	public int type_;
}