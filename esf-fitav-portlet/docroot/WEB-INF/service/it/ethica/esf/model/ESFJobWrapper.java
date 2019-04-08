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
 * This class is a wrapper for {@link ESFJob}.
 * </p>
 *
 * @author Ethica
 * @see ESFJob
 * @generated
 */
public class ESFJobWrapper implements ESFJob, ModelWrapper<ESFJob> {
	public ESFJobWrapper(ESFJob esfJob) {
		_esfJob = esfJob;
	}

	@Override
	public Class<?> getModelClass() {
		return ESFJob.class;
	}

	@Override
	public String getModelClassName() {
		return ESFJob.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfJobId", getEsfJobId());
		attributes.put("esfName", getEsfName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esfJobId = (Long)attributes.get("esfJobId");

		if (esfJobId != null) {
			setEsfJobId(esfJobId);
		}

		String esfName = (String)attributes.get("esfName");

		if (esfName != null) {
			setEsfName(esfName);
		}
	}

	/**
	* Returns the primary key of this e s f job.
	*
	* @return the primary key of this e s f job
	*/
	@Override
	public long getPrimaryKey() {
		return _esfJob.getPrimaryKey();
	}

	/**
	* Sets the primary key of this e s f job.
	*
	* @param primaryKey the primary key of this e s f job
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_esfJob.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the esf job ID of this e s f job.
	*
	* @return the esf job ID of this e s f job
	*/
	@Override
	public long getEsfJobId() {
		return _esfJob.getEsfJobId();
	}

	/**
	* Sets the esf job ID of this e s f job.
	*
	* @param esfJobId the esf job ID of this e s f job
	*/
	@Override
	public void setEsfJobId(long esfJobId) {
		_esfJob.setEsfJobId(esfJobId);
	}

	/**
	* Returns the esf name of this e s f job.
	*
	* @return the esf name of this e s f job
	*/
	@Override
	public java.lang.String getEsfName() {
		return _esfJob.getEsfName();
	}

	/**
	* Sets the esf name of this e s f job.
	*
	* @param esfName the esf name of this e s f job
	*/
	@Override
	public void setEsfName(java.lang.String esfName) {
		_esfJob.setEsfName(esfName);
	}

	@Override
	public boolean isNew() {
		return _esfJob.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_esfJob.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _esfJob.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_esfJob.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _esfJob.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _esfJob.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_esfJob.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _esfJob.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_esfJob.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_esfJob.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_esfJob.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ESFJobWrapper((ESFJob)_esfJob.clone());
	}

	@Override
	public int compareTo(it.ethica.esf.model.ESFJob esfJob) {
		return _esfJob.compareTo(esfJob);
	}

	@Override
	public int hashCode() {
		return _esfJob.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.ethica.esf.model.ESFJob> toCacheModel() {
		return _esfJob.toCacheModel();
	}

	@Override
	public it.ethica.esf.model.ESFJob toEscapedModel() {
		return new ESFJobWrapper(_esfJob.toEscapedModel());
	}

	@Override
	public it.ethica.esf.model.ESFJob toUnescapedModel() {
		return new ESFJobWrapper(_esfJob.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _esfJob.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _esfJob.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_esfJob.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFJobWrapper)) {
			return false;
		}

		ESFJobWrapper esfJobWrapper = (ESFJobWrapper)obj;

		if (Validator.equals(_esfJob, esfJobWrapper._esfJob)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ESFJob getWrappedESFJob() {
		return _esfJob;
	}

	@Override
	public ESFJob getWrappedModel() {
		return _esfJob;
	}

	@Override
	public void resetOriginalValues() {
		_esfJob.resetOriginalValues();
	}

	private ESFJob _esfJob;
}