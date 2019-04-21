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

package it.ethica.esf.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ESFOrganization_Reengineered}.
 * </p>
 *
 * @author Ethica
 * @see ESFOrganization_Reengineered
 * @generated
 */
public class ESFOrganization_ReengineeredWrapper
	implements ESFOrganization_Reengineered,
		ModelWrapper<ESFOrganization_Reengineered> {
	public ESFOrganization_ReengineeredWrapper(
		ESFOrganization_Reengineered esfOrganization_Reengineered) {
		_esfOrganization_Reengineered = esfOrganization_Reengineered;
	}

	@Override
	public Class<?> getModelClass() {
		return ESFOrganization_Reengineered.class;
	}

	@Override
	public String getModelClassName() {
		return ESFOrganization_Reengineered.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfOrganizationId", getEsfOrganizationId());
		attributes.put("code", getCode());
		attributes.put("vat", getVat());
		attributes.put("fiscalCode", getFiscalCode());
		attributes.put("ibanCode", getIbanCode());
		attributes.put("isMultiSport", getIsMultiSport());
		attributes.put("legalForm", getLegalForm());
		attributes.put("category", getCategory());
		attributes.put("establishmentDate", getEstablishmentDate());
		attributes.put("closureDate", getClosureDate());
		attributes.put("type", getType());
		attributes.put("insertDate", getInsertDate());
		attributes.put("coniDate", getConiDate());
		attributes.put("coniCode", getConiCode());
		attributes.put("description", getDescription());
		attributes.put("isYouthActive", getIsYouthActive());
		attributes.put("firstAffiliationDate", getFirstAffiliationDate());
		attributes.put("variations", getVariations());
		attributes.put("regionCode", getRegionCode());
		attributes.put("idFatherAssociation", getIdFatherAssociation());
		attributes.put("constitutiveAct", getConstitutiveAct());
		attributes.put("registeredStatus", getRegisteredStatus());
		attributes.put("planimetrySportsStand", getPlanimetrySportsStand());
		attributes.put("certificateFITAV", getCertificateFITAV());
		attributes.put("note", getNote());
		attributes.put("isSimplyOrganizzation", getIsSimplyOrganizzation());
		attributes.put("webSite", getWebSite());
		attributes.put("includeConiReport", getIncludeConiReport());
		attributes.put("organizzationCategory", getOrganizzationCategory());
		attributes.put("type_", getType_());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esfOrganizationId = (Long)attributes.get("esfOrganizationId");

		if (esfOrganizationId != null) {
			setEsfOrganizationId(esfOrganizationId);
		}

		String code = (String)attributes.get("code");

		if (code != null) {
			setCode(code);
		}

		String vat = (String)attributes.get("vat");

		if (vat != null) {
			setVat(vat);
		}

		String fiscalCode = (String)attributes.get("fiscalCode");

		if (fiscalCode != null) {
			setFiscalCode(fiscalCode);
		}

		String ibanCode = (String)attributes.get("ibanCode");

		if (ibanCode != null) {
			setIbanCode(ibanCode);
		}

		Boolean isMultiSport = (Boolean)attributes.get("isMultiSport");

		if (isMultiSport != null) {
			setIsMultiSport(isMultiSport);
		}

		String legalForm = (String)attributes.get("legalForm");

		if (legalForm != null) {
			setLegalForm(legalForm);
		}

		String category = (String)attributes.get("category");

		if (category != null) {
			setCategory(category);
		}

		Date establishmentDate = (Date)attributes.get("establishmentDate");

		if (establishmentDate != null) {
			setEstablishmentDate(establishmentDate);
		}

		Date closureDate = (Date)attributes.get("closureDate");

		if (closureDate != null) {
			setClosureDate(closureDate);
		}

		Integer type = (Integer)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		Date insertDate = (Date)attributes.get("insertDate");

		if (insertDate != null) {
			setInsertDate(insertDate);
		}

		Date coniDate = (Date)attributes.get("coniDate");

		if (coniDate != null) {
			setConiDate(coniDate);
		}

		String coniCode = (String)attributes.get("coniCode");

		if (coniCode != null) {
			setConiCode(coniCode);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Boolean isYouthActive = (Boolean)attributes.get("isYouthActive");

		if (isYouthActive != null) {
			setIsYouthActive(isYouthActive);
		}

		Date firstAffiliationDate = (Date)attributes.get("firstAffiliationDate");

		if (firstAffiliationDate != null) {
			setFirstAffiliationDate(firstAffiliationDate);
		}

		Long variations = (Long)attributes.get("variations");

		if (variations != null) {
			setVariations(variations);
		}

		Long regionCode = (Long)attributes.get("regionCode");

		if (regionCode != null) {
			setRegionCode(regionCode);
		}

		Long idFatherAssociation = (Long)attributes.get("idFatherAssociation");

		if (idFatherAssociation != null) {
			setIdFatherAssociation(idFatherAssociation);
		}

		Boolean constitutiveAct = (Boolean)attributes.get("constitutiveAct");

		if (constitutiveAct != null) {
			setConstitutiveAct(constitutiveAct);
		}

		Boolean registeredStatus = (Boolean)attributes.get("registeredStatus");

		if (registeredStatus != null) {
			setRegisteredStatus(registeredStatus);
		}

		Boolean planimetrySportsStand = (Boolean)attributes.get(
				"planimetrySportsStand");

		if (planimetrySportsStand != null) {
			setPlanimetrySportsStand(planimetrySportsStand);
		}

		Boolean certificateFITAV = (Boolean)attributes.get("certificateFITAV");

		if (certificateFITAV != null) {
			setCertificateFITAV(certificateFITAV);
		}

		String note = (String)attributes.get("note");

		if (note != null) {
			setNote(note);
		}

		Boolean isSimplyOrganizzation = (Boolean)attributes.get(
				"isSimplyOrganizzation");

		if (isSimplyOrganizzation != null) {
			setIsSimplyOrganizzation(isSimplyOrganizzation);
		}

		String webSite = (String)attributes.get("webSite");

		if (webSite != null) {
			setWebSite(webSite);
		}

		Boolean includeConiReport = (Boolean)attributes.get("includeConiReport");

		if (includeConiReport != null) {
			setIncludeConiReport(includeConiReport);
		}

		String organizzationCategory = (String)attributes.get(
				"organizzationCategory");

		if (organizzationCategory != null) {
			setOrganizzationCategory(organizzationCategory);
		}

		Integer type_ = (Integer)attributes.get("type_");

		if (type_ != null) {
			setType_(type_);
		}
	}

	/**
	* Returns the primary key of this e s f organization_ reengineered.
	*
	* @return the primary key of this e s f organization_ reengineered
	*/
	@Override
	public long getPrimaryKey() {
		return _esfOrganization_Reengineered.getPrimaryKey();
	}

	/**
	* Sets the primary key of this e s f organization_ reengineered.
	*
	* @param primaryKey the primary key of this e s f organization_ reengineered
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_esfOrganization_Reengineered.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the esf organization ID of this e s f organization_ reengineered.
	*
	* @return the esf organization ID of this e s f organization_ reengineered
	*/
	@Override
	public long getEsfOrganizationId() {
		return _esfOrganization_Reengineered.getEsfOrganizationId();
	}

	/**
	* Sets the esf organization ID of this e s f organization_ reengineered.
	*
	* @param esfOrganizationId the esf organization ID of this e s f organization_ reengineered
	*/
	@Override
	public void setEsfOrganizationId(long esfOrganizationId) {
		_esfOrganization_Reengineered.setEsfOrganizationId(esfOrganizationId);
	}

	/**
	* Returns the code of this e s f organization_ reengineered.
	*
	* @return the code of this e s f organization_ reengineered
	*/
	@Override
	public java.lang.String getCode() {
		return _esfOrganization_Reengineered.getCode();
	}

	/**
	* Sets the code of this e s f organization_ reengineered.
	*
	* @param code the code of this e s f organization_ reengineered
	*/
	@Override
	public void setCode(java.lang.String code) {
		_esfOrganization_Reengineered.setCode(code);
	}

	/**
	* Returns the vat of this e s f organization_ reengineered.
	*
	* @return the vat of this e s f organization_ reengineered
	*/
	@Override
	public java.lang.String getVat() {
		return _esfOrganization_Reengineered.getVat();
	}

	/**
	* Sets the vat of this e s f organization_ reengineered.
	*
	* @param vat the vat of this e s f organization_ reengineered
	*/
	@Override
	public void setVat(java.lang.String vat) {
		_esfOrganization_Reengineered.setVat(vat);
	}

	/**
	* Returns the fiscal code of this e s f organization_ reengineered.
	*
	* @return the fiscal code of this e s f organization_ reengineered
	*/
	@Override
	public java.lang.String getFiscalCode() {
		return _esfOrganization_Reengineered.getFiscalCode();
	}

	/**
	* Sets the fiscal code of this e s f organization_ reengineered.
	*
	* @param fiscalCode the fiscal code of this e s f organization_ reengineered
	*/
	@Override
	public void setFiscalCode(java.lang.String fiscalCode) {
		_esfOrganization_Reengineered.setFiscalCode(fiscalCode);
	}

	/**
	* Returns the iban code of this e s f organization_ reengineered.
	*
	* @return the iban code of this e s f organization_ reengineered
	*/
	@Override
	public java.lang.String getIbanCode() {
		return _esfOrganization_Reengineered.getIbanCode();
	}

	/**
	* Sets the iban code of this e s f organization_ reengineered.
	*
	* @param ibanCode the iban code of this e s f organization_ reengineered
	*/
	@Override
	public void setIbanCode(java.lang.String ibanCode) {
		_esfOrganization_Reengineered.setIbanCode(ibanCode);
	}

	/**
	* Returns the is multi sport of this e s f organization_ reengineered.
	*
	* @return the is multi sport of this e s f organization_ reengineered
	*/
	@Override
	public boolean getIsMultiSport() {
		return _esfOrganization_Reengineered.getIsMultiSport();
	}

	/**
	* Returns <code>true</code> if this e s f organization_ reengineered is is multi sport.
	*
	* @return <code>true</code> if this e s f organization_ reengineered is is multi sport; <code>false</code> otherwise
	*/
	@Override
	public boolean isIsMultiSport() {
		return _esfOrganization_Reengineered.isIsMultiSport();
	}

	/**
	* Sets whether this e s f organization_ reengineered is is multi sport.
	*
	* @param isMultiSport the is multi sport of this e s f organization_ reengineered
	*/
	@Override
	public void setIsMultiSport(boolean isMultiSport) {
		_esfOrganization_Reengineered.setIsMultiSport(isMultiSport);
	}

	/**
	* Returns the legal form of this e s f organization_ reengineered.
	*
	* @return the legal form of this e s f organization_ reengineered
	*/
	@Override
	public java.lang.String getLegalForm() {
		return _esfOrganization_Reengineered.getLegalForm();
	}

	/**
	* Sets the legal form of this e s f organization_ reengineered.
	*
	* @param legalForm the legal form of this e s f organization_ reengineered
	*/
	@Override
	public void setLegalForm(java.lang.String legalForm) {
		_esfOrganization_Reengineered.setLegalForm(legalForm);
	}

	/**
	* Returns the category of this e s f organization_ reengineered.
	*
	* @return the category of this e s f organization_ reengineered
	*/
	@Override
	public java.lang.String getCategory() {
		return _esfOrganization_Reengineered.getCategory();
	}

	/**
	* Sets the category of this e s f organization_ reengineered.
	*
	* @param category the category of this e s f organization_ reengineered
	*/
	@Override
	public void setCategory(java.lang.String category) {
		_esfOrganization_Reengineered.setCategory(category);
	}

	/**
	* Returns the establishment date of this e s f organization_ reengineered.
	*
	* @return the establishment date of this e s f organization_ reengineered
	*/
	@Override
	public java.util.Date getEstablishmentDate() {
		return _esfOrganization_Reengineered.getEstablishmentDate();
	}

	/**
	* Sets the establishment date of this e s f organization_ reengineered.
	*
	* @param establishmentDate the establishment date of this e s f organization_ reengineered
	*/
	@Override
	public void setEstablishmentDate(java.util.Date establishmentDate) {
		_esfOrganization_Reengineered.setEstablishmentDate(establishmentDate);
	}

	/**
	* Returns the closure date of this e s f organization_ reengineered.
	*
	* @return the closure date of this e s f organization_ reengineered
	*/
	@Override
	public java.util.Date getClosureDate() {
		return _esfOrganization_Reengineered.getClosureDate();
	}

	/**
	* Sets the closure date of this e s f organization_ reengineered.
	*
	* @param closureDate the closure date of this e s f organization_ reengineered
	*/
	@Override
	public void setClosureDate(java.util.Date closureDate) {
		_esfOrganization_Reengineered.setClosureDate(closureDate);
	}

	/**
	* Returns the type of this e s f organization_ reengineered.
	*
	* @return the type of this e s f organization_ reengineered
	*/
	@Override
	public int getType() {
		return _esfOrganization_Reengineered.getType();
	}

	/**
	* Sets the type of this e s f organization_ reengineered.
	*
	* @param type the type of this e s f organization_ reengineered
	*/
	@Override
	public void setType(int type) {
		_esfOrganization_Reengineered.setType(type);
	}

	/**
	* Returns the insert date of this e s f organization_ reengineered.
	*
	* @return the insert date of this e s f organization_ reengineered
	*/
	@Override
	public java.util.Date getInsertDate() {
		return _esfOrganization_Reengineered.getInsertDate();
	}

	/**
	* Sets the insert date of this e s f organization_ reengineered.
	*
	* @param insertDate the insert date of this e s f organization_ reengineered
	*/
	@Override
	public void setInsertDate(java.util.Date insertDate) {
		_esfOrganization_Reengineered.setInsertDate(insertDate);
	}

	/**
	* Returns the coni date of this e s f organization_ reengineered.
	*
	* @return the coni date of this e s f organization_ reengineered
	*/
	@Override
	public java.util.Date getConiDate() {
		return _esfOrganization_Reengineered.getConiDate();
	}

	/**
	* Sets the coni date of this e s f organization_ reengineered.
	*
	* @param coniDate the coni date of this e s f organization_ reengineered
	*/
	@Override
	public void setConiDate(java.util.Date coniDate) {
		_esfOrganization_Reengineered.setConiDate(coniDate);
	}

	/**
	* Returns the coni code of this e s f organization_ reengineered.
	*
	* @return the coni code of this e s f organization_ reengineered
	*/
	@Override
	public java.lang.String getConiCode() {
		return _esfOrganization_Reengineered.getConiCode();
	}

	/**
	* Sets the coni code of this e s f organization_ reengineered.
	*
	* @param coniCode the coni code of this e s f organization_ reengineered
	*/
	@Override
	public void setConiCode(java.lang.String coniCode) {
		_esfOrganization_Reengineered.setConiCode(coniCode);
	}

	/**
	* Returns the description of this e s f organization_ reengineered.
	*
	* @return the description of this e s f organization_ reengineered
	*/
	@Override
	public java.lang.String getDescription() {
		return _esfOrganization_Reengineered.getDescription();
	}

	/**
	* Sets the description of this e s f organization_ reengineered.
	*
	* @param description the description of this e s f organization_ reengineered
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_esfOrganization_Reengineered.setDescription(description);
	}

	/**
	* Returns the is youth active of this e s f organization_ reengineered.
	*
	* @return the is youth active of this e s f organization_ reengineered
	*/
	@Override
	public boolean getIsYouthActive() {
		return _esfOrganization_Reengineered.getIsYouthActive();
	}

	/**
	* Returns <code>true</code> if this e s f organization_ reengineered is is youth active.
	*
	* @return <code>true</code> if this e s f organization_ reengineered is is youth active; <code>false</code> otherwise
	*/
	@Override
	public boolean isIsYouthActive() {
		return _esfOrganization_Reengineered.isIsYouthActive();
	}

	/**
	* Sets whether this e s f organization_ reengineered is is youth active.
	*
	* @param isYouthActive the is youth active of this e s f organization_ reengineered
	*/
	@Override
	public void setIsYouthActive(boolean isYouthActive) {
		_esfOrganization_Reengineered.setIsYouthActive(isYouthActive);
	}

	/**
	* Returns the first affiliation date of this e s f organization_ reengineered.
	*
	* @return the first affiliation date of this e s f organization_ reengineered
	*/
	@Override
	public java.util.Date getFirstAffiliationDate() {
		return _esfOrganization_Reengineered.getFirstAffiliationDate();
	}

	/**
	* Sets the first affiliation date of this e s f organization_ reengineered.
	*
	* @param firstAffiliationDate the first affiliation date of this e s f organization_ reengineered
	*/
	@Override
	public void setFirstAffiliationDate(java.util.Date firstAffiliationDate) {
		_esfOrganization_Reengineered.setFirstAffiliationDate(firstAffiliationDate);
	}

	/**
	* Returns the variations of this e s f organization_ reengineered.
	*
	* @return the variations of this e s f organization_ reengineered
	*/
	@Override
	public long getVariations() {
		return _esfOrganization_Reengineered.getVariations();
	}

	/**
	* Sets the variations of this e s f organization_ reengineered.
	*
	* @param variations the variations of this e s f organization_ reengineered
	*/
	@Override
	public void setVariations(long variations) {
		_esfOrganization_Reengineered.setVariations(variations);
	}

	/**
	* Returns the region code of this e s f organization_ reengineered.
	*
	* @return the region code of this e s f organization_ reengineered
	*/
	@Override
	public long getRegionCode() {
		return _esfOrganization_Reengineered.getRegionCode();
	}

	/**
	* Sets the region code of this e s f organization_ reengineered.
	*
	* @param regionCode the region code of this e s f organization_ reengineered
	*/
	@Override
	public void setRegionCode(long regionCode) {
		_esfOrganization_Reengineered.setRegionCode(regionCode);
	}

	/**
	* Returns the id father association of this e s f organization_ reengineered.
	*
	* @return the id father association of this e s f organization_ reengineered
	*/
	@Override
	public long getIdFatherAssociation() {
		return _esfOrganization_Reengineered.getIdFatherAssociation();
	}

	/**
	* Sets the id father association of this e s f organization_ reengineered.
	*
	* @param idFatherAssociation the id father association of this e s f organization_ reengineered
	*/
	@Override
	public void setIdFatherAssociation(long idFatherAssociation) {
		_esfOrganization_Reengineered.setIdFatherAssociation(idFatherAssociation);
	}

	/**
	* Returns the constitutive act of this e s f organization_ reengineered.
	*
	* @return the constitutive act of this e s f organization_ reengineered
	*/
	@Override
	public boolean getConstitutiveAct() {
		return _esfOrganization_Reengineered.getConstitutiveAct();
	}

	/**
	* Returns <code>true</code> if this e s f organization_ reengineered is constitutive act.
	*
	* @return <code>true</code> if this e s f organization_ reengineered is constitutive act; <code>false</code> otherwise
	*/
	@Override
	public boolean isConstitutiveAct() {
		return _esfOrganization_Reengineered.isConstitutiveAct();
	}

	/**
	* Sets whether this e s f organization_ reengineered is constitutive act.
	*
	* @param constitutiveAct the constitutive act of this e s f organization_ reengineered
	*/
	@Override
	public void setConstitutiveAct(boolean constitutiveAct) {
		_esfOrganization_Reengineered.setConstitutiveAct(constitutiveAct);
	}

	/**
	* Returns the registered status of this e s f organization_ reengineered.
	*
	* @return the registered status of this e s f organization_ reengineered
	*/
	@Override
	public boolean getRegisteredStatus() {
		return _esfOrganization_Reengineered.getRegisteredStatus();
	}

	/**
	* Returns <code>true</code> if this e s f organization_ reengineered is registered status.
	*
	* @return <code>true</code> if this e s f organization_ reengineered is registered status; <code>false</code> otherwise
	*/
	@Override
	public boolean isRegisteredStatus() {
		return _esfOrganization_Reengineered.isRegisteredStatus();
	}

	/**
	* Sets whether this e s f organization_ reengineered is registered status.
	*
	* @param registeredStatus the registered status of this e s f organization_ reengineered
	*/
	@Override
	public void setRegisteredStatus(boolean registeredStatus) {
		_esfOrganization_Reengineered.setRegisteredStatus(registeredStatus);
	}

	/**
	* Returns the planimetry sports stand of this e s f organization_ reengineered.
	*
	* @return the planimetry sports stand of this e s f organization_ reengineered
	*/
	@Override
	public boolean getPlanimetrySportsStand() {
		return _esfOrganization_Reengineered.getPlanimetrySportsStand();
	}

	/**
	* Returns <code>true</code> if this e s f organization_ reengineered is planimetry sports stand.
	*
	* @return <code>true</code> if this e s f organization_ reengineered is planimetry sports stand; <code>false</code> otherwise
	*/
	@Override
	public boolean isPlanimetrySportsStand() {
		return _esfOrganization_Reengineered.isPlanimetrySportsStand();
	}

	/**
	* Sets whether this e s f organization_ reengineered is planimetry sports stand.
	*
	* @param planimetrySportsStand the planimetry sports stand of this e s f organization_ reengineered
	*/
	@Override
	public void setPlanimetrySportsStand(boolean planimetrySportsStand) {
		_esfOrganization_Reengineered.setPlanimetrySportsStand(planimetrySportsStand);
	}

	/**
	* Returns the certificate f i t a v of this e s f organization_ reengineered.
	*
	* @return the certificate f i t a v of this e s f organization_ reengineered
	*/
	@Override
	public boolean getCertificateFITAV() {
		return _esfOrganization_Reengineered.getCertificateFITAV();
	}

	/**
	* Returns <code>true</code> if this e s f organization_ reengineered is certificate f i t a v.
	*
	* @return <code>true</code> if this e s f organization_ reengineered is certificate f i t a v; <code>false</code> otherwise
	*/
	@Override
	public boolean isCertificateFITAV() {
		return _esfOrganization_Reengineered.isCertificateFITAV();
	}

	/**
	* Sets whether this e s f organization_ reengineered is certificate f i t a v.
	*
	* @param certificateFITAV the certificate f i t a v of this e s f organization_ reengineered
	*/
	@Override
	public void setCertificateFITAV(boolean certificateFITAV) {
		_esfOrganization_Reengineered.setCertificateFITAV(certificateFITAV);
	}

	/**
	* Returns the note of this e s f organization_ reengineered.
	*
	* @return the note of this e s f organization_ reengineered
	*/
	@Override
	public java.lang.String getNote() {
		return _esfOrganization_Reengineered.getNote();
	}

	/**
	* Sets the note of this e s f organization_ reengineered.
	*
	* @param note the note of this e s f organization_ reengineered
	*/
	@Override
	public void setNote(java.lang.String note) {
		_esfOrganization_Reengineered.setNote(note);
	}

	/**
	* Returns the is simply organizzation of this e s f organization_ reengineered.
	*
	* @return the is simply organizzation of this e s f organization_ reengineered
	*/
	@Override
	public boolean getIsSimplyOrganizzation() {
		return _esfOrganization_Reengineered.getIsSimplyOrganizzation();
	}

	/**
	* Returns <code>true</code> if this e s f organization_ reengineered is is simply organizzation.
	*
	* @return <code>true</code> if this e s f organization_ reengineered is is simply organizzation; <code>false</code> otherwise
	*/
	@Override
	public boolean isIsSimplyOrganizzation() {
		return _esfOrganization_Reengineered.isIsSimplyOrganizzation();
	}

	/**
	* Sets whether this e s f organization_ reengineered is is simply organizzation.
	*
	* @param isSimplyOrganizzation the is simply organizzation of this e s f organization_ reengineered
	*/
	@Override
	public void setIsSimplyOrganizzation(boolean isSimplyOrganizzation) {
		_esfOrganization_Reengineered.setIsSimplyOrganizzation(isSimplyOrganizzation);
	}

	/**
	* Returns the web site of this e s f organization_ reengineered.
	*
	* @return the web site of this e s f organization_ reengineered
	*/
	@Override
	public java.lang.String getWebSite() {
		return _esfOrganization_Reengineered.getWebSite();
	}

	/**
	* Sets the web site of this e s f organization_ reengineered.
	*
	* @param webSite the web site of this e s f organization_ reengineered
	*/
	@Override
	public void setWebSite(java.lang.String webSite) {
		_esfOrganization_Reengineered.setWebSite(webSite);
	}

	/**
	* Returns the include coni report of this e s f organization_ reengineered.
	*
	* @return the include coni report of this e s f organization_ reengineered
	*/
	@Override
	public boolean getIncludeConiReport() {
		return _esfOrganization_Reengineered.getIncludeConiReport();
	}

	/**
	* Returns <code>true</code> if this e s f organization_ reengineered is include coni report.
	*
	* @return <code>true</code> if this e s f organization_ reengineered is include coni report; <code>false</code> otherwise
	*/
	@Override
	public boolean isIncludeConiReport() {
		return _esfOrganization_Reengineered.isIncludeConiReport();
	}

	/**
	* Sets whether this e s f organization_ reengineered is include coni report.
	*
	* @param includeConiReport the include coni report of this e s f organization_ reengineered
	*/
	@Override
	public void setIncludeConiReport(boolean includeConiReport) {
		_esfOrganization_Reengineered.setIncludeConiReport(includeConiReport);
	}

	/**
	* Returns the organizzation category of this e s f organization_ reengineered.
	*
	* @return the organizzation category of this e s f organization_ reengineered
	*/
	@Override
	public java.lang.String getOrganizzationCategory() {
		return _esfOrganization_Reengineered.getOrganizzationCategory();
	}

	/**
	* Sets the organizzation category of this e s f organization_ reengineered.
	*
	* @param organizzationCategory the organizzation category of this e s f organization_ reengineered
	*/
	@Override
	public void setOrganizzationCategory(java.lang.String organizzationCategory) {
		_esfOrganization_Reengineered.setOrganizzationCategory(organizzationCategory);
	}

	/**
	* Returns the type_ of this e s f organization_ reengineered.
	*
	* @return the type_ of this e s f organization_ reengineered
	*/
	@Override
	public int getType_() {
		return _esfOrganization_Reengineered.getType_();
	}

	/**
	* Sets the type_ of this e s f organization_ reengineered.
	*
	* @param type_ the type_ of this e s f organization_ reengineered
	*/
	@Override
	public void setType_(int type_) {
		_esfOrganization_Reengineered.setType_(type_);
	}

	@Override
	public boolean isNew() {
		return _esfOrganization_Reengineered.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_esfOrganization_Reengineered.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _esfOrganization_Reengineered.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_esfOrganization_Reengineered.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _esfOrganization_Reengineered.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _esfOrganization_Reengineered.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_esfOrganization_Reengineered.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _esfOrganization_Reengineered.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_esfOrganization_Reengineered.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_esfOrganization_Reengineered.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_esfOrganization_Reengineered.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ESFOrganization_ReengineeredWrapper((ESFOrganization_Reengineered)_esfOrganization_Reengineered.clone());
	}

	@Override
	public int compareTo(
		ESFOrganization_Reengineered esfOrganization_Reengineered) {
		return _esfOrganization_Reengineered.compareTo(esfOrganization_Reengineered);
	}

	@Override
	public int hashCode() {
		return _esfOrganization_Reengineered.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<ESFOrganization_Reengineered> toCacheModel() {
		return _esfOrganization_Reengineered.toCacheModel();
	}

	@Override
	public ESFOrganization_Reengineered toEscapedModel() {
		return new ESFOrganization_ReengineeredWrapper(_esfOrganization_Reengineered.toEscapedModel());
	}

	@Override
	public ESFOrganization_Reengineered toUnescapedModel() {
		return new ESFOrganization_ReengineeredWrapper(_esfOrganization_Reengineered.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _esfOrganization_Reengineered.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _esfOrganization_Reengineered.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_esfOrganization_Reengineered.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFOrganization_ReengineeredWrapper)) {
			return false;
		}

		ESFOrganization_ReengineeredWrapper esfOrganization_ReengineeredWrapper = (ESFOrganization_ReengineeredWrapper)obj;

		if (Validator.equals(_esfOrganization_Reengineered,
					esfOrganization_ReengineeredWrapper._esfOrganization_Reengineered)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ESFOrganization_Reengineered getWrappedESFOrganization_Reengineered() {
		return _esfOrganization_Reengineered;
	}

	@Override
	public ESFOrganization_Reengineered getWrappedModel() {
		return _esfOrganization_Reengineered;
	}

	@Override
	public void resetOriginalValues() {
		_esfOrganization_Reengineered.resetOriginalValues();
	}

	private ESFOrganization_Reengineered _esfOrganization_Reengineered;
}