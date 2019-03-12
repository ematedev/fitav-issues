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

package com.ethica.esf.model;

import com.ethica.esf.service.ClpSerializer;
import com.ethica.esf.service.ESFArticleTypeLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ethica
 */
public class ESFArticleTypeClp extends BaseModelImpl<ESFArticleType>
	implements ESFArticleType {
	public ESFArticleTypeClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ESFArticleType.class;
	}

	@Override
	public String getModelClassName() {
		return ESFArticleType.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _esfArticleTypeId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEsfArticleTypeId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _esfArticleTypeId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfArticleTypeId", getEsfArticleTypeId());
		attributes.put("description", getDescription());
		attributes.put("department", getDepartment());
		attributes.put("area", getArea());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esfArticleTypeId = (Long)attributes.get("esfArticleTypeId");

		if (esfArticleTypeId != null) {
			setEsfArticleTypeId(esfArticleTypeId);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String department = (String)attributes.get("department");

		if (department != null) {
			setDepartment(department);
		}

		String area = (String)attributes.get("area");

		if (area != null) {
			setArea(area);
		}
	}

	@Override
	public long getEsfArticleTypeId() {
		return _esfArticleTypeId;
	}

	@Override
	public void setEsfArticleTypeId(long esfArticleTypeId) {
		_esfArticleTypeId = esfArticleTypeId;

		if (_esfArticleTypeRemoteModel != null) {
			try {
				Class<?> clazz = _esfArticleTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfArticleTypeId",
						long.class);

				method.invoke(_esfArticleTypeRemoteModel, esfArticleTypeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDescription() {
		return _description;
	}

	@Override
	public void setDescription(String description) {
		_description = description;

		if (_esfArticleTypeRemoteModel != null) {
			try {
				Class<?> clazz = _esfArticleTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_esfArticleTypeRemoteModel, description);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDepartment() {
		return _department;
	}

	@Override
	public void setDepartment(String department) {
		_department = department;

		if (_esfArticleTypeRemoteModel != null) {
			try {
				Class<?> clazz = _esfArticleTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setDepartment", String.class);

				method.invoke(_esfArticleTypeRemoteModel, department);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getArea() {
		return _area;
	}

	@Override
	public void setArea(String area) {
		_area = area;

		if (_esfArticleTypeRemoteModel != null) {
			try {
				Class<?> clazz = _esfArticleTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setArea", String.class);

				method.invoke(_esfArticleTypeRemoteModel, area);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getESFArticleTypeRemoteModel() {
		return _esfArticleTypeRemoteModel;
	}

	public void setESFArticleTypeRemoteModel(
		BaseModel<?> esfArticleTypeRemoteModel) {
		_esfArticleTypeRemoteModel = esfArticleTypeRemoteModel;
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

		Class<?> remoteModelClass = _esfArticleTypeRemoteModel.getClass();

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

		Object returnValue = method.invoke(_esfArticleTypeRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ESFArticleTypeLocalServiceUtil.addESFArticleType(this);
		}
		else {
			ESFArticleTypeLocalServiceUtil.updateESFArticleType(this);
		}
	}

	@Override
	public ESFArticleType toEscapedModel() {
		return (ESFArticleType)ProxyUtil.newProxyInstance(ESFArticleType.class.getClassLoader(),
			new Class[] { ESFArticleType.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ESFArticleTypeClp clone = new ESFArticleTypeClp();

		clone.setEsfArticleTypeId(getEsfArticleTypeId());
		clone.setDescription(getDescription());
		clone.setDepartment(getDepartment());
		clone.setArea(getArea());

		return clone;
	}

	@Override
	public int compareTo(ESFArticleType esfArticleType) {
		long primaryKey = esfArticleType.getPrimaryKey();

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

		if (!(obj instanceof ESFArticleTypeClp)) {
			return false;
		}

		ESFArticleTypeClp esfArticleType = (ESFArticleTypeClp)obj;

		long primaryKey = esfArticleType.getPrimaryKey();

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
		StringBundler sb = new StringBundler(9);

		sb.append("{esfArticleTypeId=");
		sb.append(getEsfArticleTypeId());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", department=");
		sb.append(getDepartment());
		sb.append(", area=");
		sb.append(getArea());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("com.ethica.esf.model.ESFArticleType");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>esfArticleTypeId</column-name><column-value><![CDATA[");
		sb.append(getEsfArticleTypeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>department</column-name><column-value><![CDATA[");
		sb.append(getDepartment());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>area</column-name><column-value><![CDATA[");
		sb.append(getArea());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _esfArticleTypeId;
	private String _description;
	private String _department;
	private String _area;
	private BaseModel<?> _esfArticleTypeRemoteModel;
}