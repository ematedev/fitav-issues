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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import it.ethica.esf.service.ClpSerializer;
import it.ethica.esf.service.ESFAnnualConiReportLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ethica
 */
public class ESFAnnualConiReportClp extends BaseModelImpl<ESFAnnualConiReport>
	implements ESFAnnualConiReport {
	public ESFAnnualConiReportClp() {
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
	public long getPrimaryKey() {
		return _annualConiReportId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setAnnualConiReportId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _annualConiReportId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getAnnualConiReportId() {
		return _annualConiReportId;
	}

	@Override
	public void setAnnualConiReportId(long annualConiReportId) {
		_annualConiReportId = annualConiReportId;

		if (_esfAnnualConiReportRemoteModel != null) {
			try {
				Class<?> clazz = _esfAnnualConiReportRemoteModel.getClass();

				Method method = clazz.getMethod("setAnnualConiReportId",
						long.class);

				method.invoke(_esfAnnualConiReportRemoteModel,
					annualConiReportId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getAssId() {
		return _assId;
	}

	@Override
	public void setAssId(long assId) {
		_assId = assId;

		if (_esfAnnualConiReportRemoteModel != null) {
			try {
				Class<?> clazz = _esfAnnualConiReportRemoteModel.getClass();

				Method method = clazz.getMethod("setAssId", long.class);

				method.invoke(_esfAnnualConiReportRemoteModel, assId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getYear() {
		return _year;
	}

	@Override
	public void setYear(int year) {
		_year = year;

		if (_esfAnnualConiReportRemoteModel != null) {
			try {
				Class<?> clazz = _esfAnnualConiReportRemoteModel.getClass();

				Method method = clazz.getMethod("setYear", int.class);

				method.invoke(_esfAnnualConiReportRemoteModel, year);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getESFAnnualConiReportRemoteModel() {
		return _esfAnnualConiReportRemoteModel;
	}

	public void setESFAnnualConiReportRemoteModel(
		BaseModel<?> esfAnnualConiReportRemoteModel) {
		_esfAnnualConiReportRemoteModel = esfAnnualConiReportRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _esfAnnualConiReportRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_esfAnnualConiReportRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ESFAnnualConiReportLocalServiceUtil.addESFAnnualConiReport(this);
		}
		else {
			ESFAnnualConiReportLocalServiceUtil.updateESFAnnualConiReport(this);
		}
	}

	@Override
	public ESFAnnualConiReport toEscapedModel() {
		return (ESFAnnualConiReport)ProxyUtil.newProxyInstance(ESFAnnualConiReport.class.getClassLoader(),
			new Class[] { ESFAnnualConiReport.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ESFAnnualConiReportClp clone = new ESFAnnualConiReportClp();

		clone.setAnnualConiReportId(getAnnualConiReportId());
		clone.setAssId(getAssId());
		clone.setYear(getYear());

		return clone;
	}

	@Override
	public int compareTo(ESFAnnualConiReport esfAnnualConiReport) {
		long primaryKey = esfAnnualConiReport.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFAnnualConiReportClp)) {
			return false;
		}

		ESFAnnualConiReportClp esfAnnualConiReport = (ESFAnnualConiReportClp)obj;

		long primaryKey = esfAnnualConiReport.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{annualConiReportId=");
		sb.append(getAnnualConiReportId());
		sb.append(", assId=");
		sb.append(getAssId());
		sb.append(", year=");
		sb.append(getYear());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("it.ethica.esf.model.ESFAnnualConiReport");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>annualConiReportId</column-name><column-value><![CDATA[");
		sb.append(getAnnualConiReportId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>assId</column-name><column-value><![CDATA[");
		sb.append(getAssId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>year</column-name><column-value><![CDATA[");
		sb.append(getYear());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _annualConiReportId;
	private long _assId;
	private int _year;
	private BaseModel<?> _esfAnnualConiReportRemoteModel;
}