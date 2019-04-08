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
 * This class is a wrapper for {@link ESFHistoricalAssociation}.
 * </p>
 *
 * @author Ethica
 * @see ESFHistoricalAssociation
 * @generated
 */
public class ESFHistoricalAssociationWrapper implements ESFHistoricalAssociation,
	ModelWrapper<ESFHistoricalAssociation> {
	public ESFHistoricalAssociationWrapper(
		ESFHistoricalAssociation esfHistoricalAssociation) {
		_esfHistoricalAssociation = esfHistoricalAssociation;
	}

	@Override
	public Class<?> getModelClass() {
		return ESFHistoricalAssociation.class;
	}

	@Override
	public String getModelClassName() {
		return ESFHistoricalAssociation.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("idHistoricalAssociation", getIdHistoricalAssociation());
		attributes.put("name", getName());
		attributes.put("code", getCode());
		attributes.put("dateChange", getDateChange());
		attributes.put("endDate", getEndDate());
		attributes.put("organizationId", getOrganizationId());
		attributes.put("stateId", getStateId());
		attributes.put("variationId", getVariationId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long idHistoricalAssociation = (Long)attributes.get(
				"idHistoricalAssociation");

		if (idHistoricalAssociation != null) {
			setIdHistoricalAssociation(idHistoricalAssociation);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String code = (String)attributes.get("code");

		if (code != null) {
			setCode(code);
		}

		Date dateChange = (Date)attributes.get("dateChange");

		if (dateChange != null) {
			setDateChange(dateChange);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}

		Long organizationId = (Long)attributes.get("organizationId");

		if (organizationId != null) {
			setOrganizationId(organizationId);
		}

		Long stateId = (Long)attributes.get("stateId");

		if (stateId != null) {
			setStateId(stateId);
		}

		Long variationId = (Long)attributes.get("variationId");

		if (variationId != null) {
			setVariationId(variationId);
		}
	}

	/**
	* Returns the primary key of this e s f historical association.
	*
	* @return the primary key of this e s f historical association
	*/
	@Override
	public long getPrimaryKey() {
		return _esfHistoricalAssociation.getPrimaryKey();
	}

	/**
	* Sets the primary key of this e s f historical association.
	*
	* @param primaryKey the primary key of this e s f historical association
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_esfHistoricalAssociation.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the id historical association of this e s f historical association.
	*
	* @return the id historical association of this e s f historical association
	*/
	@Override
	public long getIdHistoricalAssociation() {
		return _esfHistoricalAssociation.getIdHistoricalAssociation();
	}

	/**
	* Sets the id historical association of this e s f historical association.
	*
	* @param idHistoricalAssociation the id historical association of this e s f historical association
	*/
	@Override
	public void setIdHistoricalAssociation(long idHistoricalAssociation) {
		_esfHistoricalAssociation.setIdHistoricalAssociation(idHistoricalAssociation);
	}

	/**
	* Returns the name of this e s f historical association.
	*
	* @return the name of this e s f historical association
	*/
	@Override
	public java.lang.String getName() {
		return _esfHistoricalAssociation.getName();
	}

	/**
	* Sets the name of this e s f historical association.
	*
	* @param name the name of this e s f historical association
	*/
	@Override
	public void setName(java.lang.String name) {
		_esfHistoricalAssociation.setName(name);
	}

	/**
	* Returns the code of this e s f historical association.
	*
	* @return the code of this e s f historical association
	*/
	@Override
	public java.lang.String getCode() {
		return _esfHistoricalAssociation.getCode();
	}

	/**
	* Sets the code of this e s f historical association.
	*
	* @param code the code of this e s f historical association
	*/
	@Override
	public void setCode(java.lang.String code) {
		_esfHistoricalAssociation.setCode(code);
	}

	/**
	* Returns the date change of this e s f historical association.
	*
	* @return the date change of this e s f historical association
	*/
	@Override
	public java.util.Date getDateChange() {
		return _esfHistoricalAssociation.getDateChange();
	}

	/**
	* Sets the date change of this e s f historical association.
	*
	* @param dateChange the date change of this e s f historical association
	*/
	@Override
	public void setDateChange(java.util.Date dateChange) {
		_esfHistoricalAssociation.setDateChange(dateChange);
	}

	/**
	* Returns the end date of this e s f historical association.
	*
	* @return the end date of this e s f historical association
	*/
	@Override
	public java.util.Date getEndDate() {
		return _esfHistoricalAssociation.getEndDate();
	}

	/**
	* Sets the end date of this e s f historical association.
	*
	* @param endDate the end date of this e s f historical association
	*/
	@Override
	public void setEndDate(java.util.Date endDate) {
		_esfHistoricalAssociation.setEndDate(endDate);
	}

	/**
	* Returns the organization ID of this e s f historical association.
	*
	* @return the organization ID of this e s f historical association
	*/
	@Override
	public long getOrganizationId() {
		return _esfHistoricalAssociation.getOrganizationId();
	}

	/**
	* Sets the organization ID of this e s f historical association.
	*
	* @param organizationId the organization ID of this e s f historical association
	*/
	@Override
	public void setOrganizationId(long organizationId) {
		_esfHistoricalAssociation.setOrganizationId(organizationId);
	}

	/**
	* Returns the state ID of this e s f historical association.
	*
	* @return the state ID of this e s f historical association
	*/
	@Override
	public long getStateId() {
		return _esfHistoricalAssociation.getStateId();
	}

	/**
	* Sets the state ID of this e s f historical association.
	*
	* @param stateId the state ID of this e s f historical association
	*/
	@Override
	public void setStateId(long stateId) {
		_esfHistoricalAssociation.setStateId(stateId);
	}

	/**
	* Returns the variation ID of this e s f historical association.
	*
	* @return the variation ID of this e s f historical association
	*/
	@Override
	public long getVariationId() {
		return _esfHistoricalAssociation.getVariationId();
	}

	/**
	* Sets the variation ID of this e s f historical association.
	*
	* @param variationId the variation ID of this e s f historical association
	*/
	@Override
	public void setVariationId(long variationId) {
		_esfHistoricalAssociation.setVariationId(variationId);
	}

	@Override
	public boolean isNew() {
		return _esfHistoricalAssociation.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_esfHistoricalAssociation.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _esfHistoricalAssociation.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_esfHistoricalAssociation.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _esfHistoricalAssociation.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _esfHistoricalAssociation.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_esfHistoricalAssociation.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _esfHistoricalAssociation.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_esfHistoricalAssociation.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_esfHistoricalAssociation.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_esfHistoricalAssociation.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ESFHistoricalAssociationWrapper((ESFHistoricalAssociation)_esfHistoricalAssociation.clone());
	}

	@Override
	public int compareTo(
		it.ethica.esf.model.ESFHistoricalAssociation esfHistoricalAssociation) {
		return _esfHistoricalAssociation.compareTo(esfHistoricalAssociation);
	}

	@Override
	public int hashCode() {
		return _esfHistoricalAssociation.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.ethica.esf.model.ESFHistoricalAssociation> toCacheModel() {
		return _esfHistoricalAssociation.toCacheModel();
	}

	@Override
	public it.ethica.esf.model.ESFHistoricalAssociation toEscapedModel() {
		return new ESFHistoricalAssociationWrapper(_esfHistoricalAssociation.toEscapedModel());
	}

	@Override
	public it.ethica.esf.model.ESFHistoricalAssociation toUnescapedModel() {
		return new ESFHistoricalAssociationWrapper(_esfHistoricalAssociation.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _esfHistoricalAssociation.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _esfHistoricalAssociation.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_esfHistoricalAssociation.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFHistoricalAssociationWrapper)) {
			return false;
		}

		ESFHistoricalAssociationWrapper esfHistoricalAssociationWrapper = (ESFHistoricalAssociationWrapper)obj;

		if (Validator.equals(_esfHistoricalAssociation,
					esfHistoricalAssociationWrapper._esfHistoricalAssociation)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ESFHistoricalAssociation getWrappedESFHistoricalAssociation() {
		return _esfHistoricalAssociation;
	}

	@Override
	public ESFHistoricalAssociation getWrappedModel() {
		return _esfHistoricalAssociation;
	}

	@Override
	public void resetOriginalValues() {
		_esfHistoricalAssociation.resetOriginalValues();
	}

	private ESFHistoricalAssociation _esfHistoricalAssociation;
}