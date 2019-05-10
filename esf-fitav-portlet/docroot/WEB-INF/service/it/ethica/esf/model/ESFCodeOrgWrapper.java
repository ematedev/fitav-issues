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

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ESFCodeOrg}.
 * </p>
 *
 * @author Ethica
 * @see ESFCodeOrg
 * @generated
 */
public class ESFCodeOrgWrapper implements ESFCodeOrg, ModelWrapper<ESFCodeOrg> {
	public ESFCodeOrgWrapper(ESFCodeOrg esfCodeOrg) {
		_esfCodeOrg = esfCodeOrg;
	}

	@Override
	public Class<?> getModelClass() {
		return ESFCodeOrg.class;
	}

	@Override
	public String getModelClassName() {
		return ESFCodeOrg.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("esfCodeOrgId", getEsfCodeOrgId());
		attributes.put("className", getClassName());
		attributes.put("code", getCode());
		attributes.put("sequence", getSequence());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long esfCodeOrgId = (Long)attributes.get("esfCodeOrgId");

		if (esfCodeOrgId != null) {
			setEsfCodeOrgId(esfCodeOrgId);
		}

		String className = (String)attributes.get("className");

		if (className != null) {
			setClassName(className);
		}

		String code = (String)attributes.get("code");

		if (code != null) {
			setCode(code);
		}

		Long sequence = (Long)attributes.get("sequence");

		if (sequence != null) {
			setSequence(sequence);
		}
	}

	/**
	* Returns the primary key of this e s f code org.
	*
	* @return the primary key of this e s f code org
	*/
	@Override
	public long getPrimaryKey() {
		return _esfCodeOrg.getPrimaryKey();
	}

	/**
	* Sets the primary key of this e s f code org.
	*
	* @param primaryKey the primary key of this e s f code org
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_esfCodeOrg.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this e s f code org.
	*
	* @return the uuid of this e s f code org
	*/
	@Override
	public java.lang.String getUuid() {
		return _esfCodeOrg.getUuid();
	}

	/**
	* Sets the uuid of this e s f code org.
	*
	* @param uuid the uuid of this e s f code org
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_esfCodeOrg.setUuid(uuid);
	}

	/**
	* Returns the esf code org ID of this e s f code org.
	*
	* @return the esf code org ID of this e s f code org
	*/
	@Override
	public long getEsfCodeOrgId() {
		return _esfCodeOrg.getEsfCodeOrgId();
	}

	/**
	* Sets the esf code org ID of this e s f code org.
	*
	* @param esfCodeOrgId the esf code org ID of this e s f code org
	*/
	@Override
	public void setEsfCodeOrgId(long esfCodeOrgId) {
		_esfCodeOrg.setEsfCodeOrgId(esfCodeOrgId);
	}

	/**
	* Returns the class name of this e s f code org.
	*
	* @return the class name of this e s f code org
	*/
	@Override
	public java.lang.String getClassName() {
		return _esfCodeOrg.getClassName();
	}

	/**
	* Sets the class name of this e s f code org.
	*
	* @param className the class name of this e s f code org
	*/
	@Override
	public void setClassName(java.lang.String className) {
		_esfCodeOrg.setClassName(className);
	}

	/**
	* Returns the code of this e s f code org.
	*
	* @return the code of this e s f code org
	*/
	@Override
	public java.lang.String getCode() {
		return _esfCodeOrg.getCode();
	}

	/**
	* Sets the code of this e s f code org.
	*
	* @param code the code of this e s f code org
	*/
	@Override
	public void setCode(java.lang.String code) {
		_esfCodeOrg.setCode(code);
	}

	/**
	* Returns the sequence of this e s f code org.
	*
	* @return the sequence of this e s f code org
	*/
	@Override
	public long getSequence() {
		return _esfCodeOrg.getSequence();
	}

	/**
	* Sets the sequence of this e s f code org.
	*
	* @param sequence the sequence of this e s f code org
	*/
	@Override
	public void setSequence(long sequence) {
		_esfCodeOrg.setSequence(sequence);
	}

	@Override
	public boolean isNew() {
		return _esfCodeOrg.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_esfCodeOrg.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _esfCodeOrg.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_esfCodeOrg.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _esfCodeOrg.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _esfCodeOrg.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_esfCodeOrg.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _esfCodeOrg.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_esfCodeOrg.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_esfCodeOrg.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_esfCodeOrg.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ESFCodeOrgWrapper((ESFCodeOrg)_esfCodeOrg.clone());
	}

	@Override
	public int compareTo(ESFCodeOrg esfCodeOrg) {
		return _esfCodeOrg.compareTo(esfCodeOrg);
	}

	@Override
	public int hashCode() {
		return _esfCodeOrg.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<ESFCodeOrg> toCacheModel() {
		return _esfCodeOrg.toCacheModel();
	}

	@Override
	public ESFCodeOrg toEscapedModel() {
		return new ESFCodeOrgWrapper(_esfCodeOrg.toEscapedModel());
	}

	@Override
	public ESFCodeOrg toUnescapedModel() {
		return new ESFCodeOrgWrapper(_esfCodeOrg.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _esfCodeOrg.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _esfCodeOrg.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_esfCodeOrg.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFCodeOrgWrapper)) {
			return false;
		}

		ESFCodeOrgWrapper esfCodeOrgWrapper = (ESFCodeOrgWrapper)obj;

		if (Validator.equals(_esfCodeOrg, esfCodeOrgWrapper._esfCodeOrg)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ESFCodeOrg getWrappedESFCodeOrg() {
		return _esfCodeOrg;
	}

	@Override
	public ESFCodeOrg getWrappedModel() {
		return _esfCodeOrg;
	}

	@Override
	public void resetOriginalValues() {
		_esfCodeOrg.resetOriginalValues();
	}

	private ESFCodeOrg _esfCodeOrg;
}