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
 * This class is a wrapper for {@link ESFAnnualConiReport}.
 * </p>
 *
 * @author Ethica
 * @see ESFAnnualConiReport
 * @generated
 */
public class ESFAnnualConiReportWrapper implements ESFAnnualConiReport,
	ModelWrapper<ESFAnnualConiReport> {
	public ESFAnnualConiReportWrapper(ESFAnnualConiReport esfAnnualConiReport) {
		_esfAnnualConiReport = esfAnnualConiReport;
	}

	@Override
	public Class<?> getModelClass() {
		return ESFAnnualConiReport.class;
	}

	@Override
	public String getModelClassName() {
		return ESFAnnualConiReport.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("annualConiReportId", getAnnualConiReportId());
		attributes.put("assId", getAssId());
		attributes.put("year", getYear());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long annualConiReportId = (Long)attributes.get("annualConiReportId");

		if (annualConiReportId != null) {
			setAnnualConiReportId(annualConiReportId);
		}

		Long assId = (Long)attributes.get("assId");

		if (assId != null) {
			setAssId(assId);
		}

		Integer year = (Integer)attributes.get("year");

		if (year != null) {
			setYear(year);
		}
	}

	/**
	* Returns the primary key of this e s f annual coni report.
	*
	* @return the primary key of this e s f annual coni report
	*/
	@Override
	public long getPrimaryKey() {
		return _esfAnnualConiReport.getPrimaryKey();
	}

	/**
	* Sets the primary key of this e s f annual coni report.
	*
	* @param primaryKey the primary key of this e s f annual coni report
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_esfAnnualConiReport.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the annual coni report ID of this e s f annual coni report.
	*
	* @return the annual coni report ID of this e s f annual coni report
	*/
	@Override
	public long getAnnualConiReportId() {
		return _esfAnnualConiReport.getAnnualConiReportId();
	}

	/**
	* Sets the annual coni report ID of this e s f annual coni report.
	*
	* @param annualConiReportId the annual coni report ID of this e s f annual coni report
	*/
	@Override
	public void setAnnualConiReportId(long annualConiReportId) {
		_esfAnnualConiReport.setAnnualConiReportId(annualConiReportId);
	}

	/**
	* Returns the ass ID of this e s f annual coni report.
	*
	* @return the ass ID of this e s f annual coni report
	*/
	@Override
	public long getAssId() {
		return _esfAnnualConiReport.getAssId();
	}

	/**
	* Sets the ass ID of this e s f annual coni report.
	*
	* @param assId the ass ID of this e s f annual coni report
	*/
	@Override
	public void setAssId(long assId) {
		_esfAnnualConiReport.setAssId(assId);
	}

	/**
	* Returns the year of this e s f annual coni report.
	*
	* @return the year of this e s f annual coni report
	*/
	@Override
	public int getYear() {
		return _esfAnnualConiReport.getYear();
	}

	/**
	* Sets the year of this e s f annual coni report.
	*
	* @param year the year of this e s f annual coni report
	*/
	@Override
	public void setYear(int year) {
		_esfAnnualConiReport.setYear(year);
	}

	@Override
	public boolean isNew() {
		return _esfAnnualConiReport.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_esfAnnualConiReport.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _esfAnnualConiReport.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_esfAnnualConiReport.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _esfAnnualConiReport.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _esfAnnualConiReport.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_esfAnnualConiReport.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _esfAnnualConiReport.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_esfAnnualConiReport.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_esfAnnualConiReport.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_esfAnnualConiReport.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ESFAnnualConiReportWrapper((ESFAnnualConiReport)_esfAnnualConiReport.clone());
	}

	@Override
	public int compareTo(
		it.ethica.esf.model.ESFAnnualConiReport esfAnnualConiReport) {
		return _esfAnnualConiReport.compareTo(esfAnnualConiReport);
	}

	@Override
	public int hashCode() {
		return _esfAnnualConiReport.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.ethica.esf.model.ESFAnnualConiReport> toCacheModel() {
		return _esfAnnualConiReport.toCacheModel();
	}

	@Override
	public it.ethica.esf.model.ESFAnnualConiReport toEscapedModel() {
		return new ESFAnnualConiReportWrapper(_esfAnnualConiReport.toEscapedModel());
	}

	@Override
	public it.ethica.esf.model.ESFAnnualConiReport toUnescapedModel() {
		return new ESFAnnualConiReportWrapper(_esfAnnualConiReport.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _esfAnnualConiReport.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _esfAnnualConiReport.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_esfAnnualConiReport.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFAnnualConiReportWrapper)) {
			return false;
		}

		ESFAnnualConiReportWrapper esfAnnualConiReportWrapper = (ESFAnnualConiReportWrapper)obj;

		if (Validator.equals(_esfAnnualConiReport,
					esfAnnualConiReportWrapper._esfAnnualConiReport)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ESFAnnualConiReport getWrappedESFAnnualConiReport() {
		return _esfAnnualConiReport;
	}

	@Override
	public ESFAnnualConiReport getWrappedModel() {
		return _esfAnnualConiReport;
	}

	@Override
	public void resetOriginalValues() {
		_esfAnnualConiReport.resetOriginalValues();
	}

	private ESFAnnualConiReport _esfAnnualConiReport;
}