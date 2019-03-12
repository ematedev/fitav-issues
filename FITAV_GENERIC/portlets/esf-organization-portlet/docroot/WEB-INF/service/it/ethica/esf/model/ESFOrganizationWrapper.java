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
		attributes.put("code", getCode());
		attributes.put("vat", getVat());
		attributes.put("fiscalCode", getFiscalCode());
		attributes.put("establishmentDate", getEstablishmentDate());
		attributes.put("closureDate", getClosureDate());
		attributes.put("groupId", getGroupId());

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

		Date establishmentDate = (Date)attributes.get("establishmentDate");

		if (establishmentDate != null) {
			setEstablishmentDate(establishmentDate);
		}

		Date closureDate = (Date)attributes.get("closureDate");

		if (closureDate != null) {
			setClosureDate(closureDate);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
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