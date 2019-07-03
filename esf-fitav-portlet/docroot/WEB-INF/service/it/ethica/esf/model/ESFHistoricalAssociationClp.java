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
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import it.ethica.esf.service.ClpSerializer;
import it.ethica.esf.service.ESFHistoricalAssociationLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ethica
 */
public class ESFHistoricalAssociationClp extends BaseModelImpl<ESFHistoricalAssociation>
	implements ESFHistoricalAssociation {
	public ESFHistoricalAssociationClp() {
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
	public long getPrimaryKey() {
		return _idHistoricalAssociation;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setIdHistoricalAssociation(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _idHistoricalAssociation;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getIdHistoricalAssociation() {
		return _idHistoricalAssociation;
	}

	@Override
	public void setIdHistoricalAssociation(long idHistoricalAssociation) {
		_idHistoricalAssociation = idHistoricalAssociation;

		if (_esfHistoricalAssociationRemoteModel != null) {
			try {
				Class<?> clazz = _esfHistoricalAssociationRemoteModel.getClass();

				Method method = clazz.getMethod("setIdHistoricalAssociation",
						long.class);

				method.invoke(_esfHistoricalAssociationRemoteModel,
					idHistoricalAssociation);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getName() {
		return _name;
	}

	@Override
	public void setName(String name) {
		_name = name;

		if (_esfHistoricalAssociationRemoteModel != null) {
			try {
				Class<?> clazz = _esfHistoricalAssociationRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_esfHistoricalAssociationRemoteModel, name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCode() {
		return _code;
	}

	@Override
	public void setCode(String code) {
		_code = code;

		if (_esfHistoricalAssociationRemoteModel != null) {
			try {
				Class<?> clazz = _esfHistoricalAssociationRemoteModel.getClass();

				Method method = clazz.getMethod("setCode", String.class);

				method.invoke(_esfHistoricalAssociationRemoteModel, code);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getDateChange() {
		return _dateChange;
	}

	@Override
	public void setDateChange(Date dateChange) {
		_dateChange = dateChange;

		if (_esfHistoricalAssociationRemoteModel != null) {
			try {
				Class<?> clazz = _esfHistoricalAssociationRemoteModel.getClass();

				Method method = clazz.getMethod("setDateChange", Date.class);

				method.invoke(_esfHistoricalAssociationRemoteModel, dateChange);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getEndDate() {
		return _endDate;
	}

	@Override
	public void setEndDate(Date endDate) {
		_endDate = endDate;

		if (_esfHistoricalAssociationRemoteModel != null) {
			try {
				Class<?> clazz = _esfHistoricalAssociationRemoteModel.getClass();

				Method method = clazz.getMethod("setEndDate", Date.class);

				method.invoke(_esfHistoricalAssociationRemoteModel, endDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getOrganizationId() {
		return _organizationId;
	}

	@Override
	public void setOrganizationId(long organizationId) {
		_organizationId = organizationId;

		if (_esfHistoricalAssociationRemoteModel != null) {
			try {
				Class<?> clazz = _esfHistoricalAssociationRemoteModel.getClass();

				Method method = clazz.getMethod("setOrganizationId", long.class);

				method.invoke(_esfHistoricalAssociationRemoteModel,
					organizationId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getStateId() {
		return _stateId;
	}

	@Override
	public void setStateId(long stateId) {
		_stateId = stateId;

		if (_esfHistoricalAssociationRemoteModel != null) {
			try {
				Class<?> clazz = _esfHistoricalAssociationRemoteModel.getClass();

				Method method = clazz.getMethod("setStateId", long.class);

				method.invoke(_esfHistoricalAssociationRemoteModel, stateId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getVariationId() {
		return _variationId;
	}

	@Override
	public void setVariationId(long variationId) {
		_variationId = variationId;

		if (_esfHistoricalAssociationRemoteModel != null) {
			try {
				Class<?> clazz = _esfHistoricalAssociationRemoteModel.getClass();

				Method method = clazz.getMethod("setVariationId", long.class);

				method.invoke(_esfHistoricalAssociationRemoteModel, variationId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getESFHistoricalAssociationRemoteModel() {
		return _esfHistoricalAssociationRemoteModel;
	}

	public void setESFHistoricalAssociationRemoteModel(
		BaseModel<?> esfHistoricalAssociationRemoteModel) {
		_esfHistoricalAssociationRemoteModel = esfHistoricalAssociationRemoteModel;
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

		Class<?> remoteModelClass = _esfHistoricalAssociationRemoteModel.getClass();

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

		Object returnValue = method.invoke(_esfHistoricalAssociationRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ESFHistoricalAssociationLocalServiceUtil.addESFHistoricalAssociation(this);
		}
		else {
			ESFHistoricalAssociationLocalServiceUtil.updateESFHistoricalAssociation(this);
		}
	}

	@Override
	public ESFHistoricalAssociation toEscapedModel() {
		return (ESFHistoricalAssociation)ProxyUtil.newProxyInstance(ESFHistoricalAssociation.class.getClassLoader(),
			new Class[] { ESFHistoricalAssociation.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ESFHistoricalAssociationClp clone = new ESFHistoricalAssociationClp();

		clone.setIdHistoricalAssociation(getIdHistoricalAssociation());
		clone.setName(getName());
		clone.setCode(getCode());
		clone.setDateChange(getDateChange());
		clone.setEndDate(getEndDate());
		clone.setOrganizationId(getOrganizationId());
		clone.setStateId(getStateId());
		clone.setVariationId(getVariationId());

		return clone;
	}

	@Override
	public int compareTo(ESFHistoricalAssociation esfHistoricalAssociation) {
		int value = 0;

		value = DateUtil.compareTo(getDateChange(),
				esfHistoricalAssociation.getDateChange());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFHistoricalAssociationClp)) {
			return false;
		}

		ESFHistoricalAssociationClp esfHistoricalAssociation = (ESFHistoricalAssociationClp)obj;

		long primaryKey = esfHistoricalAssociation.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{idHistoricalAssociation=");
		sb.append(getIdHistoricalAssociation());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", code=");
		sb.append(getCode());
		sb.append(", dateChange=");
		sb.append(getDateChange());
		sb.append(", endDate=");
		sb.append(getEndDate());
		sb.append(", organizationId=");
		sb.append(getOrganizationId());
		sb.append(", stateId=");
		sb.append(getStateId());
		sb.append(", variationId=");
		sb.append(getVariationId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("it.ethica.esf.model.ESFHistoricalAssociation");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>idHistoricalAssociation</column-name><column-value><![CDATA[");
		sb.append(getIdHistoricalAssociation());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>code</column-name><column-value><![CDATA[");
		sb.append(getCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dateChange</column-name><column-value><![CDATA[");
		sb.append(getDateChange());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endDate</column-name><column-value><![CDATA[");
		sb.append(getEndDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>organizationId</column-name><column-value><![CDATA[");
		sb.append(getOrganizationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>stateId</column-name><column-value><![CDATA[");
		sb.append(getStateId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>variationId</column-name><column-value><![CDATA[");
		sb.append(getVariationId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _idHistoricalAssociation;
	private String _name;
	private String _code;
	private Date _dateChange;
	private Date _endDate;
	private long _organizationId;
	private long _stateId;
	private long _variationId;
	private BaseModel<?> _esfHistoricalAssociationRemoteModel;
	private Class<?> _clpSerializerClass = it.ethica.esf.service.ClpSerializer.class;
}