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

package it.ethica.esf.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the ESFOrganization service. Represents a row in the &quot;ESFOrganization&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link it.ethica.esf.model.impl.ESFOrganizationModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link it.ethica.esf.model.impl.ESFOrganizationImpl}.
 * </p>
 *
 * @author Ethica
 * @see ESFOrganization
 * @see it.ethica.esf.model.impl.ESFOrganizationImpl
 * @see it.ethica.esf.model.impl.ESFOrganizationModelImpl
 * @generated
 */
public interface ESFOrganizationModel extends BaseModel<ESFOrganization> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a e s f organization model instance should use the {@link ESFOrganization} interface instead.
	 */

	/**
	 * Returns the primary key of this e s f organization.
	 *
	 * @return the primary key of this e s f organization
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this e s f organization.
	 *
	 * @param primaryKey the primary key of this e s f organization
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this e s f organization.
	 *
	 * @return the uuid of this e s f organization
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this e s f organization.
	 *
	 * @param uuid the uuid of this e s f organization
	 */
	public void setUuid(String uuid);

	/**
	 * Returns the esf organization ID of this e s f organization.
	 *
	 * @return the esf organization ID of this e s f organization
	 */
	public long getEsfOrganizationId();

	/**
	 * Sets the esf organization ID of this e s f organization.
	 *
	 * @param esfOrganizationId the esf organization ID of this e s f organization
	 */
	public void setEsfOrganizationId(long esfOrganizationId);

	/**
	 * Returns the group ID of this e s f organization.
	 *
	 * @return the group ID of this e s f organization
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this e s f organization.
	 *
	 * @param groupId the group ID of this e s f organization
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the code of this e s f organization.
	 *
	 * @return the code of this e s f organization
	 */
	@AutoEscape
	public String getCode();

	/**
	 * Sets the code of this e s f organization.
	 *
	 * @param code the code of this e s f organization
	 */
	public void setCode(String code);

	/**
	 * Returns the vat of this e s f organization.
	 *
	 * @return the vat of this e s f organization
	 */
	@AutoEscape
	public String getVat();

	/**
	 * Sets the vat of this e s f organization.
	 *
	 * @param vat the vat of this e s f organization
	 */
	public void setVat(String vat);

	/**
	 * Returns the fiscal code of this e s f organization.
	 *
	 * @return the fiscal code of this e s f organization
	 */
	@AutoEscape
	public String getFiscalCode();

	/**
	 * Sets the fiscal code of this e s f organization.
	 *
	 * @param fiscalCode the fiscal code of this e s f organization
	 */
	public void setFiscalCode(String fiscalCode);

	/**
	 * Returns the iban code of this e s f organization.
	 *
	 * @return the iban code of this e s f organization
	 */
	@AutoEscape
	public String getIbanCode();

	/**
	 * Sets the iban code of this e s f organization.
	 *
	 * @param ibanCode the iban code of this e s f organization
	 */
	public void setIbanCode(String ibanCode);

	/**
	 * Returns the is multi sport of this e s f organization.
	 *
	 * @return the is multi sport of this e s f organization
	 */
	public boolean getIsMultiSport();

	/**
	 * Returns <code>true</code> if this e s f organization is is multi sport.
	 *
	 * @return <code>true</code> if this e s f organization is is multi sport; <code>false</code> otherwise
	 */
	public boolean isIsMultiSport();

	/**
	 * Sets whether this e s f organization is is multi sport.
	 *
	 * @param isMultiSport the is multi sport of this e s f organization
	 */
	public void setIsMultiSport(boolean isMultiSport);

	/**
	 * Returns the legal form of this e s f organization.
	 *
	 * @return the legal form of this e s f organization
	 */
	@AutoEscape
	public String getLegalForm();

	/**
	 * Sets the legal form of this e s f organization.
	 *
	 * @param legalForm the legal form of this e s f organization
	 */
	public void setLegalForm(String legalForm);

	/**
	 * Returns the category of this e s f organization.
	 *
	 * @return the category of this e s f organization
	 */
	@AutoEscape
	public String getCategory();

	/**
	 * Sets the category of this e s f organization.
	 *
	 * @param category the category of this e s f organization
	 */
	public void setCategory(String category);

	/**
	 * Returns the establishment date of this e s f organization.
	 *
	 * @return the establishment date of this e s f organization
	 */
	public Date getEstablishmentDate();

	/**
	 * Sets the establishment date of this e s f organization.
	 *
	 * @param establishmentDate the establishment date of this e s f organization
	 */
	public void setEstablishmentDate(Date establishmentDate);

	/**
	 * Returns the closure date of this e s f organization.
	 *
	 * @return the closure date of this e s f organization
	 */
	public Date getClosureDate();

	/**
	 * Sets the closure date of this e s f organization.
	 *
	 * @param closureDate the closure date of this e s f organization
	 */
	public void setClosureDate(Date closureDate);

	/**
	 * Returns the type of this e s f organization.
	 *
	 * @return the type of this e s f organization
	 */
	public int getType();

	/**
	 * Sets the type of this e s f organization.
	 *
	 * @param type the type of this e s f organization
	 */
	public void setType(int type);

	/**
	 * Returns the insert date of this e s f organization.
	 *
	 * @return the insert date of this e s f organization
	 */
	public Date getInsertDate();

	/**
	 * Sets the insert date of this e s f organization.
	 *
	 * @param insertDate the insert date of this e s f organization
	 */
	public void setInsertDate(Date insertDate);

	/**
	 * Returns the coni date of this e s f organization.
	 *
	 * @return the coni date of this e s f organization
	 */
	public Date getConiDate();

	/**
	 * Sets the coni date of this e s f organization.
	 *
	 * @param coniDate the coni date of this e s f organization
	 */
	public void setConiDate(Date coniDate);

	/**
	 * Returns the coni code of this e s f organization.
	 *
	 * @return the coni code of this e s f organization
	 */
	@AutoEscape
	public String getConiCode();

	/**
	 * Sets the coni code of this e s f organization.
	 *
	 * @param coniCode the coni code of this e s f organization
	 */
	public void setConiCode(String coniCode);

	/**
	 * Returns the description of this e s f organization.
	 *
	 * @return the description of this e s f organization
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this e s f organization.
	 *
	 * @param description the description of this e s f organization
	 */
	public void setDescription(String description);

	/**
	 * Returns the is youth active of this e s f organization.
	 *
	 * @return the is youth active of this e s f organization
	 */
	public boolean getIsYouthActive();

	/**
	 * Returns <code>true</code> if this e s f organization is is youth active.
	 *
	 * @return <code>true</code> if this e s f organization is is youth active; <code>false</code> otherwise
	 */
	public boolean isIsYouthActive();

	/**
	 * Sets whether this e s f organization is is youth active.
	 *
	 * @param isYouthActive the is youth active of this e s f organization
	 */
	public void setIsYouthActive(boolean isYouthActive);

	/**
	 * Returns the first affiliation date of this e s f organization.
	 *
	 * @return the first affiliation date of this e s f organization
	 */
	public Date getFirstAffiliationDate();

	/**
	 * Sets the first affiliation date of this e s f organization.
	 *
	 * @param firstAffiliationDate the first affiliation date of this e s f organization
	 */
	public void setFirstAffiliationDate(Date firstAffiliationDate);

	/**
	 * Returns the variations of this e s f organization.
	 *
	 * @return the variations of this e s f organization
	 */
	public long getVariations();

	/**
	 * Sets the variations of this e s f organization.
	 *
	 * @param variations the variations of this e s f organization
	 */
	public void setVariations(long variations);

	/**
	 * Returns the region code of this e s f organization.
	 *
	 * @return the region code of this e s f organization
	 */
	public long getRegionCode();

	/**
	 * Sets the region code of this e s f organization.
	 *
	 * @param regionCode the region code of this e s f organization
	 */
	public void setRegionCode(long regionCode);

	/**
	 * Returns the id father association of this e s f organization.
	 *
	 * @return the id father association of this e s f organization
	 */
	public long getIdFatherAssociation();

	/**
	 * Sets the id father association of this e s f organization.
	 *
	 * @param idFatherAssociation the id father association of this e s f organization
	 */
	public void setIdFatherAssociation(long idFatherAssociation);

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
	public int compareTo(it.ethica.esf.model.ESFOrganization esfOrganization);

	@Override
	public int hashCode();

	@Override
	public CacheModel<it.ethica.esf.model.ESFOrganization> toCacheModel();

	@Override
	public it.ethica.esf.model.ESFOrganization toEscapedModel();

	@Override
	public it.ethica.esf.model.ESFOrganization toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}