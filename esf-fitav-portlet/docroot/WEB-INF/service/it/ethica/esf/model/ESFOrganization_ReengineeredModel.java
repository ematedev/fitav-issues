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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the ESFOrganization_Reengineered service. Represents a row in the &quot;esforganization&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link it.ethica.esf.model.impl.ESFOrganization_ReengineeredModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link it.ethica.esf.model.impl.ESFOrganization_ReengineeredImpl}.
 * </p>
 *
 * @author Ethica
 * @see ESFOrganization_Reengineered
 * @see it.ethica.esf.model.impl.ESFOrganization_ReengineeredImpl
 * @see it.ethica.esf.model.impl.ESFOrganization_ReengineeredModelImpl
 * @generated
 */
public interface ESFOrganization_ReengineeredModel extends BaseModel<ESFOrganization_Reengineered> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a e s f organization_ reengineered model instance should use the {@link ESFOrganization_Reengineered} interface instead.
	 */

	/**
	 * Returns the primary key of this e s f organization_ reengineered.
	 *
	 * @return the primary key of this e s f organization_ reengineered
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this e s f organization_ reengineered.
	 *
	 * @param primaryKey the primary key of this e s f organization_ reengineered
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the esf organization ID of this e s f organization_ reengineered.
	 *
	 * @return the esf organization ID of this e s f organization_ reengineered
	 */
	public long getEsfOrganizationId();

	/**
	 * Sets the esf organization ID of this e s f organization_ reengineered.
	 *
	 * @param esfOrganizationId the esf organization ID of this e s f organization_ reengineered
	 */
	public void setEsfOrganizationId(long esfOrganizationId);

	/**
	 * Returns the code of this e s f organization_ reengineered.
	 *
	 * @return the code of this e s f organization_ reengineered
	 */
	@AutoEscape
	public String getCode();

	/**
	 * Sets the code of this e s f organization_ reengineered.
	 *
	 * @param code the code of this e s f organization_ reengineered
	 */
	public void setCode(String code);

	/**
	 * Returns the vat of this e s f organization_ reengineered.
	 *
	 * @return the vat of this e s f organization_ reengineered
	 */
	@AutoEscape
	public String getVat();

	/**
	 * Sets the vat of this e s f organization_ reengineered.
	 *
	 * @param vat the vat of this e s f organization_ reengineered
	 */
	public void setVat(String vat);

	/**
	 * Returns the fiscal code of this e s f organization_ reengineered.
	 *
	 * @return the fiscal code of this e s f organization_ reengineered
	 */
	@AutoEscape
	public String getFiscalCode();

	/**
	 * Sets the fiscal code of this e s f organization_ reengineered.
	 *
	 * @param fiscalCode the fiscal code of this e s f organization_ reengineered
	 */
	public void setFiscalCode(String fiscalCode);

	/**
	 * Returns the iban code of this e s f organization_ reengineered.
	 *
	 * @return the iban code of this e s f organization_ reengineered
	 */
	@AutoEscape
	public String getIbanCode();

	/**
	 * Sets the iban code of this e s f organization_ reengineered.
	 *
	 * @param ibanCode the iban code of this e s f organization_ reengineered
	 */
	public void setIbanCode(String ibanCode);

	/**
	 * Returns the is multi sport of this e s f organization_ reengineered.
	 *
	 * @return the is multi sport of this e s f organization_ reengineered
	 */
	public boolean getIsMultiSport();

	/**
	 * Returns <code>true</code> if this e s f organization_ reengineered is is multi sport.
	 *
	 * @return <code>true</code> if this e s f organization_ reengineered is is multi sport; <code>false</code> otherwise
	 */
	public boolean isIsMultiSport();

	/**
	 * Sets whether this e s f organization_ reengineered is is multi sport.
	 *
	 * @param isMultiSport the is multi sport of this e s f organization_ reengineered
	 */
	public void setIsMultiSport(boolean isMultiSport);

	/**
	 * Returns the legal form of this e s f organization_ reengineered.
	 *
	 * @return the legal form of this e s f organization_ reengineered
	 */
	@AutoEscape
	public String getLegalForm();

	/**
	 * Sets the legal form of this e s f organization_ reengineered.
	 *
	 * @param legalForm the legal form of this e s f organization_ reengineered
	 */
	public void setLegalForm(String legalForm);

	/**
	 * Returns the category of this e s f organization_ reengineered.
	 *
	 * @return the category of this e s f organization_ reengineered
	 */
	@AutoEscape
	public String getCategory();

	/**
	 * Sets the category of this e s f organization_ reengineered.
	 *
	 * @param category the category of this e s f organization_ reengineered
	 */
	public void setCategory(String category);

	/**
	 * Returns the establishment date of this e s f organization_ reengineered.
	 *
	 * @return the establishment date of this e s f organization_ reengineered
	 */
	public Date getEstablishmentDate();

	/**
	 * Sets the establishment date of this e s f organization_ reengineered.
	 *
	 * @param establishmentDate the establishment date of this e s f organization_ reengineered
	 */
	public void setEstablishmentDate(Date establishmentDate);

	/**
	 * Returns the closure date of this e s f organization_ reengineered.
	 *
	 * @return the closure date of this e s f organization_ reengineered
	 */
	public Date getClosureDate();

	/**
	 * Sets the closure date of this e s f organization_ reengineered.
	 *
	 * @param closureDate the closure date of this e s f organization_ reengineered
	 */
	public void setClosureDate(Date closureDate);

	/**
	 * Returns the type of this e s f organization_ reengineered.
	 *
	 * @return the type of this e s f organization_ reengineered
	 */
	public int getType();

	/**
	 * Sets the type of this e s f organization_ reengineered.
	 *
	 * @param type the type of this e s f organization_ reengineered
	 */
	public void setType(int type);

	/**
	 * Returns the insert date of this e s f organization_ reengineered.
	 *
	 * @return the insert date of this e s f organization_ reengineered
	 */
	public Date getInsertDate();

	/**
	 * Sets the insert date of this e s f organization_ reengineered.
	 *
	 * @param insertDate the insert date of this e s f organization_ reengineered
	 */
	public void setInsertDate(Date insertDate);

	/**
	 * Returns the coni date of this e s f organization_ reengineered.
	 *
	 * @return the coni date of this e s f organization_ reengineered
	 */
	public Date getConiDate();

	/**
	 * Sets the coni date of this e s f organization_ reengineered.
	 *
	 * @param coniDate the coni date of this e s f organization_ reengineered
	 */
	public void setConiDate(Date coniDate);

	/**
	 * Returns the coni code of this e s f organization_ reengineered.
	 *
	 * @return the coni code of this e s f organization_ reengineered
	 */
	@AutoEscape
	public String getConiCode();

	/**
	 * Sets the coni code of this e s f organization_ reengineered.
	 *
	 * @param coniCode the coni code of this e s f organization_ reengineered
	 */
	public void setConiCode(String coniCode);

	/**
	 * Returns the description of this e s f organization_ reengineered.
	 *
	 * @return the description of this e s f organization_ reengineered
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this e s f organization_ reengineered.
	 *
	 * @param description the description of this e s f organization_ reengineered
	 */
	public void setDescription(String description);

	/**
	 * Returns the is youth active of this e s f organization_ reengineered.
	 *
	 * @return the is youth active of this e s f organization_ reengineered
	 */
	public boolean getIsYouthActive();

	/**
	 * Returns <code>true</code> if this e s f organization_ reengineered is is youth active.
	 *
	 * @return <code>true</code> if this e s f organization_ reengineered is is youth active; <code>false</code> otherwise
	 */
	public boolean isIsYouthActive();

	/**
	 * Sets whether this e s f organization_ reengineered is is youth active.
	 *
	 * @param isYouthActive the is youth active of this e s f organization_ reengineered
	 */
	public void setIsYouthActive(boolean isYouthActive);

	/**
	 * Returns the first affiliation date of this e s f organization_ reengineered.
	 *
	 * @return the first affiliation date of this e s f organization_ reengineered
	 */
	public Date getFirstAffiliationDate();

	/**
	 * Sets the first affiliation date of this e s f organization_ reengineered.
	 *
	 * @param firstAffiliationDate the first affiliation date of this e s f organization_ reengineered
	 */
	public void setFirstAffiliationDate(Date firstAffiliationDate);

	/**
	 * Returns the variations of this e s f organization_ reengineered.
	 *
	 * @return the variations of this e s f organization_ reengineered
	 */
	public long getVariations();

	/**
	 * Sets the variations of this e s f organization_ reengineered.
	 *
	 * @param variations the variations of this e s f organization_ reengineered
	 */
	public void setVariations(long variations);

	/**
	 * Returns the region code of this e s f organization_ reengineered.
	 *
	 * @return the region code of this e s f organization_ reengineered
	 */
	public long getRegionCode();

	/**
	 * Sets the region code of this e s f organization_ reengineered.
	 *
	 * @param regionCode the region code of this e s f organization_ reengineered
	 */
	public void setRegionCode(long regionCode);

	/**
	 * Returns the id father association of this e s f organization_ reengineered.
	 *
	 * @return the id father association of this e s f organization_ reengineered
	 */
	public long getIdFatherAssociation();

	/**
	 * Sets the id father association of this e s f organization_ reengineered.
	 *
	 * @param idFatherAssociation the id father association of this e s f organization_ reengineered
	 */
	public void setIdFatherAssociation(long idFatherAssociation);

	/**
	 * Returns the constitutive act of this e s f organization_ reengineered.
	 *
	 * @return the constitutive act of this e s f organization_ reengineered
	 */
	public boolean getConstitutiveAct();

	/**
	 * Returns <code>true</code> if this e s f organization_ reengineered is constitutive act.
	 *
	 * @return <code>true</code> if this e s f organization_ reengineered is constitutive act; <code>false</code> otherwise
	 */
	public boolean isConstitutiveAct();

	/**
	 * Sets whether this e s f organization_ reengineered is constitutive act.
	 *
	 * @param constitutiveAct the constitutive act of this e s f organization_ reengineered
	 */
	public void setConstitutiveAct(boolean constitutiveAct);

	/**
	 * Returns the registered status of this e s f organization_ reengineered.
	 *
	 * @return the registered status of this e s f organization_ reengineered
	 */
	public boolean getRegisteredStatus();

	/**
	 * Returns <code>true</code> if this e s f organization_ reengineered is registered status.
	 *
	 * @return <code>true</code> if this e s f organization_ reengineered is registered status; <code>false</code> otherwise
	 */
	public boolean isRegisteredStatus();

	/**
	 * Sets whether this e s f organization_ reengineered is registered status.
	 *
	 * @param registeredStatus the registered status of this e s f organization_ reengineered
	 */
	public void setRegisteredStatus(boolean registeredStatus);

	/**
	 * Returns the planimetry sports stand of this e s f organization_ reengineered.
	 *
	 * @return the planimetry sports stand of this e s f organization_ reengineered
	 */
	public boolean getPlanimetrySportsStand();

	/**
	 * Returns <code>true</code> if this e s f organization_ reengineered is planimetry sports stand.
	 *
	 * @return <code>true</code> if this e s f organization_ reengineered is planimetry sports stand; <code>false</code> otherwise
	 */
	public boolean isPlanimetrySportsStand();

	/**
	 * Sets whether this e s f organization_ reengineered is planimetry sports stand.
	 *
	 * @param planimetrySportsStand the planimetry sports stand of this e s f organization_ reengineered
	 */
	public void setPlanimetrySportsStand(boolean planimetrySportsStand);

	/**
	 * Returns the certificate f i t a v of this e s f organization_ reengineered.
	 *
	 * @return the certificate f i t a v of this e s f organization_ reengineered
	 */
	public boolean getCertificateFITAV();

	/**
	 * Returns <code>true</code> if this e s f organization_ reengineered is certificate f i t a v.
	 *
	 * @return <code>true</code> if this e s f organization_ reengineered is certificate f i t a v; <code>false</code> otherwise
	 */
	public boolean isCertificateFITAV();

	/**
	 * Sets whether this e s f organization_ reengineered is certificate f i t a v.
	 *
	 * @param certificateFITAV the certificate f i t a v of this e s f organization_ reengineered
	 */
	public void setCertificateFITAV(boolean certificateFITAV);

	/**
	 * Returns the note of this e s f organization_ reengineered.
	 *
	 * @return the note of this e s f organization_ reengineered
	 */
	@AutoEscape
	public String getNote();

	/**
	 * Sets the note of this e s f organization_ reengineered.
	 *
	 * @param note the note of this e s f organization_ reengineered
	 */
	public void setNote(String note);

	/**
	 * Returns the is simply organizzation of this e s f organization_ reengineered.
	 *
	 * @return the is simply organizzation of this e s f organization_ reengineered
	 */
	public boolean getIsSimplyOrganizzation();

	/**
	 * Returns <code>true</code> if this e s f organization_ reengineered is is simply organizzation.
	 *
	 * @return <code>true</code> if this e s f organization_ reengineered is is simply organizzation; <code>false</code> otherwise
	 */
	public boolean isIsSimplyOrganizzation();

	/**
	 * Sets whether this e s f organization_ reengineered is is simply organizzation.
	 *
	 * @param isSimplyOrganizzation the is simply organizzation of this e s f organization_ reengineered
	 */
	public void setIsSimplyOrganizzation(boolean isSimplyOrganizzation);

	/**
	 * Returns the web site of this e s f organization_ reengineered.
	 *
	 * @return the web site of this e s f organization_ reengineered
	 */
	@AutoEscape
	public String getWebSite();

	/**
	 * Sets the web site of this e s f organization_ reengineered.
	 *
	 * @param webSite the web site of this e s f organization_ reengineered
	 */
	public void setWebSite(String webSite);

	/**
	 * Returns the include coni report of this e s f organization_ reengineered.
	 *
	 * @return the include coni report of this e s f organization_ reengineered
	 */
	public boolean getIncludeConiReport();

	/**
	 * Returns <code>true</code> if this e s f organization_ reengineered is include coni report.
	 *
	 * @return <code>true</code> if this e s f organization_ reengineered is include coni report; <code>false</code> otherwise
	 */
	public boolean isIncludeConiReport();

	/**
	 * Sets whether this e s f organization_ reengineered is include coni report.
	 *
	 * @param includeConiReport the include coni report of this e s f organization_ reengineered
	 */
	public void setIncludeConiReport(boolean includeConiReport);

	/**
	 * Returns the organizzation category of this e s f organization_ reengineered.
	 *
	 * @return the organizzation category of this e s f organization_ reengineered
	 */
	@AutoEscape
	public String getOrganizzationCategory();

	/**
	 * Sets the organizzation category of this e s f organization_ reengineered.
	 *
	 * @param organizzationCategory the organizzation category of this e s f organization_ reengineered
	 */
	public void setOrganizzationCategory(String organizzationCategory);

	/**
	 * Returns the type_ of this e s f organization_ reengineered.
	 *
	 * @return the type_ of this e s f organization_ reengineered
	 */
	public int getType_();

	/**
	 * Sets the type_ of this e s f organization_ reengineered.
	 *
	 * @param type_ the type_ of this e s f organization_ reengineered
	 */
	public void setType_(int type_);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(
		ESFOrganization_Reengineered esfOrganization_Reengineered);

	@Override
	public int hashCode();

	@Override
	public CacheModel<ESFOrganization_Reengineered> toCacheModel();

	@Override
	public ESFOrganization_Reengineered toEscapedModel();

	@Override
	public ESFOrganization_Reengineered toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}