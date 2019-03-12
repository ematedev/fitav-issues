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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ESFOrganization}.
 * </p>
 *
 * @author Ethica
 * @see ESFOrganization
 * @generated
 */
public class ESFOrganizationWrapper implements ESFOrganization,
	ModelWrapper<ESFOrganization> {
	public ESFOrganizationWrapper(ESFOrganization esfOrganization) {
		_esfOrganization = esfOrganization;
	}

	@Override
	public Class<?> getModelClass() {
		return ESFOrganization.class;
	}

	@Override
	public String getModelClassName() {
		return ESFOrganization.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("esfOrganizationId", getEsfOrganizationId());
		attributes.put("groupId", getGroupId());
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

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long esfOrganizationId = (Long)attributes.get("esfOrganizationId");

		if (esfOrganizationId != null) {
			setEsfOrganizationId(esfOrganizationId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
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
	}

	/**
	* Returns the primary key of this e s f organization.
	*
	* @return the primary key of this e s f organization
	*/
	@Override
	public long getPrimaryKey() {
		return _esfOrganization.getPrimaryKey();
	}

	/**
	* Sets the primary key of this e s f organization.
	*
	* @param primaryKey the primary key of this e s f organization
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_esfOrganization.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this e s f organization.
	*
	* @return the uuid of this e s f organization
	*/
	@Override
	public java.lang.String getUuid() {
		return _esfOrganization.getUuid();
	}

	/**
	* Sets the uuid of this e s f organization.
	*
	* @param uuid the uuid of this e s f organization
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_esfOrganization.setUuid(uuid);
	}

	/**
	* Returns the esf organization ID of this e s f organization.
	*
	* @return the esf organization ID of this e s f organization
	*/
	@Override
	public long getEsfOrganizationId() {
		return _esfOrganization.getEsfOrganizationId();
	}

	/**
	* Sets the esf organization ID of this e s f organization.
	*
	* @param esfOrganizationId the esf organization ID of this e s f organization
	*/
	@Override
	public void setEsfOrganizationId(long esfOrganizationId) {
		_esfOrganization.setEsfOrganizationId(esfOrganizationId);
	}

	/**
	* Returns the group ID of this e s f organization.
	*
	* @return the group ID of this e s f organization
	*/
	@Override
	public long getGroupId() {
		return _esfOrganization.getGroupId();
	}

	/**
	* Sets the group ID of this e s f organization.
	*
	* @param groupId the group ID of this e s f organization
	*/
	@Override
	public void setGroupId(long groupId) {
		_esfOrganization.setGroupId(groupId);
	}

	/**
	* Returns the code of this e s f organization.
	*
	* @return the code of this e s f organization
	*/
	@Override
	public java.lang.String getCode() {
		return _esfOrganization.getCode();
	}

	/**
	* Sets the code of this e s f organization.
	*
	* @param code the code of this e s f organization
	*/
	@Override
	public void setCode(java.lang.String code) {
		_esfOrganization.setCode(code);
	}

	/**
	* Returns the vat of this e s f organization.
	*
	* @return the vat of this e s f organization
	*/
	@Override
	public java.lang.String getVat() {
		return _esfOrganization.getVat();
	}

	/**
	* Sets the vat of this e s f organization.
	*
	* @param vat the vat of this e s f organization
	*/
	@Override
	public void setVat(java.lang.String vat) {
		_esfOrganization.setVat(vat);
	}

	/**
	* Returns the fiscal code of this e s f organization.
	*
	* @return the fiscal code of this e s f organization
	*/
	@Override
	public java.lang.String getFiscalCode() {
		return _esfOrganization.getFiscalCode();
	}

	/**
	* Sets the fiscal code of this e s f organization.
	*
	* @param fiscalCode the fiscal code of this e s f organization
	*/
	@Override
	public void setFiscalCode(java.lang.String fiscalCode) {
		_esfOrganization.setFiscalCode(fiscalCode);
	}

	/**
	* Returns the iban code of this e s f organization.
	*
	* @return the iban code of this e s f organization
	*/
	@Override
	public java.lang.String getIbanCode() {
		return _esfOrganization.getIbanCode();
	}

	/**
	* Sets the iban code of this e s f organization.
	*
	* @param ibanCode the iban code of this e s f organization
	*/
	@Override
	public void setIbanCode(java.lang.String ibanCode) {
		_esfOrganization.setIbanCode(ibanCode);
	}

	/**
	* Returns the is multi sport of this e s f organization.
	*
	* @return the is multi sport of this e s f organization
	*/
	@Override
	public boolean getIsMultiSport() {
		return _esfOrganization.getIsMultiSport();
	}

	/**
	* Returns <code>true</code> if this e s f organization is is multi sport.
	*
	* @return <code>true</code> if this e s f organization is is multi sport; <code>false</code> otherwise
	*/
	@Override
	public boolean isIsMultiSport() {
		return _esfOrganization.isIsMultiSport();
	}

	/**
	* Sets whether this e s f organization is is multi sport.
	*
	* @param isMultiSport the is multi sport of this e s f organization
	*/
	@Override
	public void setIsMultiSport(boolean isMultiSport) {
		_esfOrganization.setIsMultiSport(isMultiSport);
	}

	/**
	* Returns the legal form of this e s f organization.
	*
	* @return the legal form of this e s f organization
	*/
	@Override
	public java.lang.String getLegalForm() {
		return _esfOrganization.getLegalForm();
	}

	/**
	* Sets the legal form of this e s f organization.
	*
	* @param legalForm the legal form of this e s f organization
	*/
	@Override
	public void setLegalForm(java.lang.String legalForm) {
		_esfOrganization.setLegalForm(legalForm);
	}

	/**
	* Returns the category of this e s f organization.
	*
	* @return the category of this e s f organization
	*/
	@Override
	public java.lang.String getCategory() {
		return _esfOrganization.getCategory();
	}

	/**
	* Sets the category of this e s f organization.
	*
	* @param category the category of this e s f organization
	*/
	@Override
	public void setCategory(java.lang.String category) {
		_esfOrganization.setCategory(category);
	}

	/**
	* Returns the establishment date of this e s f organization.
	*
	* @return the establishment date of this e s f organization
	*/
	@Override
	public java.util.Date getEstablishmentDate() {
		return _esfOrganization.getEstablishmentDate();
	}

	/**
	* Sets the establishment date of this e s f organization.
	*
	* @param establishmentDate the establishment date of this e s f organization
	*/
	@Override
	public void setEstablishmentDate(java.util.Date establishmentDate) {
		_esfOrganization.setEstablishmentDate(establishmentDate);
	}

	/**
	* Returns the closure date of this e s f organization.
	*
	* @return the closure date of this e s f organization
	*/
	@Override
	public java.util.Date getClosureDate() {
		return _esfOrganization.getClosureDate();
	}

	/**
	* Sets the closure date of this e s f organization.
	*
	* @param closureDate the closure date of this e s f organization
	*/
	@Override
	public void setClosureDate(java.util.Date closureDate) {
		_esfOrganization.setClosureDate(closureDate);
	}

	/**
	* Returns the type of this e s f organization.
	*
	* @return the type of this e s f organization
	*/
	@Override
	public int getType() {
		return _esfOrganization.getType();
	}

	/**
	* Sets the type of this e s f organization.
	*
	* @param type the type of this e s f organization
	*/
	@Override
	public void setType(int type) {
		_esfOrganization.setType(type);
	}

	/**
	* Returns the insert date of this e s f organization.
	*
	* @return the insert date of this e s f organization
	*/
	@Override
	public java.util.Date getInsertDate() {
		return _esfOrganization.getInsertDate();
	}

	/**
	* Sets the insert date of this e s f organization.
	*
	* @param insertDate the insert date of this e s f organization
	*/
	@Override
	public void setInsertDate(java.util.Date insertDate) {
		_esfOrganization.setInsertDate(insertDate);
	}

	/**
	* Returns the coni date of this e s f organization.
	*
	* @return the coni date of this e s f organization
	*/
	@Override
	public java.util.Date getConiDate() {
		return _esfOrganization.getConiDate();
	}

	/**
	* Sets the coni date of this e s f organization.
	*
	* @param coniDate the coni date of this e s f organization
	*/
	@Override
	public void setConiDate(java.util.Date coniDate) {
		_esfOrganization.setConiDate(coniDate);
	}

	/**
	* Returns the coni code of this e s f organization.
	*
	* @return the coni code of this e s f organization
	*/
	@Override
	public java.lang.String getConiCode() {
		return _esfOrganization.getConiCode();
	}

	/**
	* Sets the coni code of this e s f organization.
	*
	* @param coniCode the coni code of this e s f organization
	*/
	@Override
	public void setConiCode(java.lang.String coniCode) {
		_esfOrganization.setConiCode(coniCode);
	}

	/**
	* Returns the description of this e s f organization.
	*
	* @return the description of this e s f organization
	*/
	@Override
	public java.lang.String getDescription() {
		return _esfOrganization.getDescription();
	}

	/**
	* Sets the description of this e s f organization.
	*
	* @param description the description of this e s f organization
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_esfOrganization.setDescription(description);
	}

	/**
	* Returns the is youth active of this e s f organization.
	*
	* @return the is youth active of this e s f organization
	*/
	@Override
	public boolean getIsYouthActive() {
		return _esfOrganization.getIsYouthActive();
	}

	/**
	* Returns <code>true</code> if this e s f organization is is youth active.
	*
	* @return <code>true</code> if this e s f organization is is youth active; <code>false</code> otherwise
	*/
	@Override
	public boolean isIsYouthActive() {
		return _esfOrganization.isIsYouthActive();
	}

	/**
	* Sets whether this e s f organization is is youth active.
	*
	* @param isYouthActive the is youth active of this e s f organization
	*/
	@Override
	public void setIsYouthActive(boolean isYouthActive) {
		_esfOrganization.setIsYouthActive(isYouthActive);
	}

	/**
	* Returns the first affiliation date of this e s f organization.
	*
	* @return the first affiliation date of this e s f organization
	*/
	@Override
	public java.util.Date getFirstAffiliationDate() {
		return _esfOrganization.getFirstAffiliationDate();
	}

	/**
	* Sets the first affiliation date of this e s f organization.
	*
	* @param firstAffiliationDate the first affiliation date of this e s f organization
	*/
	@Override
	public void setFirstAffiliationDate(java.util.Date firstAffiliationDate) {
		_esfOrganization.setFirstAffiliationDate(firstAffiliationDate);
	}

	/**
	* Returns the variations of this e s f organization.
	*
	* @return the variations of this e s f organization
	*/
	@Override
	public long getVariations() {
		return _esfOrganization.getVariations();
	}

	/**
	* Sets the variations of this e s f organization.
	*
	* @param variations the variations of this e s f organization
	*/
	@Override
	public void setVariations(long variations) {
		_esfOrganization.setVariations(variations);
	}

	/**
	* Returns the region code of this e s f organization.
	*
	* @return the region code of this e s f organization
	*/
	@Override
	public long getRegionCode() {
		return _esfOrganization.getRegionCode();
	}

	/**
	* Sets the region code of this e s f organization.
	*
	* @param regionCode the region code of this e s f organization
	*/
	@Override
	public void setRegionCode(long regionCode) {
		_esfOrganization.setRegionCode(regionCode);
	}

	/**
	* Returns the id father association of this e s f organization.
	*
	* @return the id father association of this e s f organization
	*/
	@Override
	public long getIdFatherAssociation() {
		return _esfOrganization.getIdFatherAssociation();
	}

	/**
	* Sets the id father association of this e s f organization.
	*
	* @param idFatherAssociation the id father association of this e s f organization
	*/
	@Override
	public void setIdFatherAssociation(long idFatherAssociation) {
		_esfOrganization.setIdFatherAssociation(idFatherAssociation);
	}

	@Override
	public boolean isNew() {
		return _esfOrganization.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_esfOrganization.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _esfOrganization.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_esfOrganization.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _esfOrganization.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _esfOrganization.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_esfOrganization.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _esfOrganization.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_esfOrganization.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_esfOrganization.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_esfOrganization.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ESFOrganizationWrapper((ESFOrganization)_esfOrganization.clone());
	}

	@Override
	public int compareTo(it.ethica.esf.model.ESFOrganization esfOrganization) {
		return _esfOrganization.compareTo(esfOrganization);
	}

	@Override
	public int hashCode() {
		return _esfOrganization.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.ethica.esf.model.ESFOrganization> toCacheModel() {
		return _esfOrganization.toCacheModel();
	}

	@Override
	public it.ethica.esf.model.ESFOrganization toEscapedModel() {
		return new ESFOrganizationWrapper(_esfOrganization.toEscapedModel());
	}

	@Override
	public it.ethica.esf.model.ESFOrganization toUnescapedModel() {
		return new ESFOrganizationWrapper(_esfOrganization.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _esfOrganization.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _esfOrganization.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_esfOrganization.persist();
	}

	@Override
	public boolean isRoot() {
		return _esfOrganization.isRoot();
	}

	@Override
	public boolean isRegion() {
		return _esfOrganization.isRegion();
	}

	@Override
	public boolean isProvince() {
		return _esfOrganization.isProvince();
	}

	@Override
	public boolean isAssociation() {
		return _esfOrganization.isAssociation();
	}

	@Override
	public long getCompanyId()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfOrganization.getCompanyId();
	}

	@Override
	public long getUserId()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfOrganization.getUserId();
	}

	@Override
	public java.lang.String getUserName()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfOrganization.getUserName();
	}

	@Override
	public java.util.Date getCreateDate()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfOrganization.getCreateDate();
	}

	@Override
	public java.util.Date getModifiedDate()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfOrganization.getModifiedDate();
	}

	@Override
	public long getParentOrganizationId()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfOrganization.getParentOrganizationId();
	}

	@Override
	public java.lang.String getTreePath()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfOrganization.getTreePath();
	}

	@Override
	public java.lang.String getName()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfOrganization.getName();
	}

	@Override
	public java.lang.String getType_()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfOrganization.getType_();
	}

	@Override
	public boolean getRecursable()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfOrganization.getRecursable();
	}

	@Override
	public long getStatusId()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfOrganization.getStatusId();
	}

	@Override
	public java.lang.String getComments()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfOrganization.getComments();
	}

	@Override
	public long getDefaultLayoutSetPrototypeId(boolean publicLayout) {
		return _esfOrganization.getDefaultLayoutSetPrototypeId(publicLayout);
	}

	@Override
	public void setCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_esfOrganization.setCompanyId(companyId);
	}

	@Override
	public void setUserId(long userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_esfOrganization.setUserId(userId);
	}

	@Override
	public void setUserName(java.lang.String userName)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_esfOrganization.setUserName(userName);
	}

	@Override
	public void setCreateDate(java.util.Date createDate)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_esfOrganization.setCreateDate(createDate);
	}

	@Override
	public void setModifiedDate(java.util.Date modifiedDate)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_esfOrganization.setModifiedDate(modifiedDate);
	}

	@Override
	public void setParentOrganizationId(long parentOrganizationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_esfOrganization.setParentOrganizationId(parentOrganizationId);
	}

	@Override
	public void setTreePath(java.lang.String treePath)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_esfOrganization.setTreePath(treePath);
	}

	@Override
	public void setName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_esfOrganization.setName(name);
	}

	@Override
	public void setType_(java.lang.String type_)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_esfOrganization.setType_(type_);
	}

	@Override
	public void setRecursable(boolean recursable)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_esfOrganization.setRecursable(recursable);
	}

	@Override
	public void setStatusId(int statusId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_esfOrganization.setStatusId(statusId);
	}

	@Override
	public void setComments(java.lang.String comments)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_esfOrganization.setComments(comments);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFOrganizationWrapper)) {
			return false;
		}

		ESFOrganizationWrapper esfOrganizationWrapper = (ESFOrganizationWrapper)obj;

		if (Validator.equals(_esfOrganization,
					esfOrganizationWrapper._esfOrganization)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ESFOrganization getWrappedESFOrganization() {
		return _esfOrganization;
	}

	@Override
	public ESFOrganization getWrappedModel() {
		return _esfOrganization;
	}

	@Override
	public void resetOriginalValues() {
		_esfOrganization.resetOriginalValues();
	}

	private ESFOrganization _esfOrganization;
}