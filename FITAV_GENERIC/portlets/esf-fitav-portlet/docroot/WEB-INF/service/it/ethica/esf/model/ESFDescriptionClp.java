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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import it.ethica.esf.service.ClpSerializer;
import it.ethica.esf.service.ESFDescriptionLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ethica
 */
public class ESFDescriptionClp extends BaseModelImpl<ESFDescription>
	implements ESFDescription {
	public ESFDescriptionClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ESFDescription.class;
	}

	@Override
	public String getModelClassName() {
		return ESFDescription.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _esfDescriptionId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEsfDescriptionId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _esfDescriptionId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfDescriptionId", getEsfDescriptionId());
		attributes.put("isNational", getIsNational());
		attributes.put("name", getName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esfDescriptionId = (Long)attributes.get("esfDescriptionId");

		if (esfDescriptionId != null) {
			setEsfDescriptionId(esfDescriptionId);
		}

		Boolean isNational = (Boolean)attributes.get("isNational");

		if (isNational != null) {
			setIsNational(isNational);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}
	}

	@Override
	public long getEsfDescriptionId() {
		return _esfDescriptionId;
	}

	@Override
	public void setEsfDescriptionId(long esfDescriptionId) {
		_esfDescriptionId = esfDescriptionId;

		if (_esfDescriptionRemoteModel != null) {
			try {
				Class<?> clazz = _esfDescriptionRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfDescriptionId",
						long.class);

				method.invoke(_esfDescriptionRemoteModel, esfDescriptionId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getIsNational() {
		return _isNational;
	}

	@Override
	public boolean isIsNational() {
		return _isNational;
	}

	@Override
	public void setIsNational(boolean isNational) {
		_isNational = isNational;

		if (_esfDescriptionRemoteModel != null) {
			try {
				Class<?> clazz = _esfDescriptionRemoteModel.getClass();

				Method method = clazz.getMethod("setIsNational", boolean.class);

				method.invoke(_esfDescriptionRemoteModel, isNational);
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

		if (_esfDescriptionRemoteModel != null) {
			try {
				Class<?> clazz = _esfDescriptionRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_esfDescriptionRemoteModel, name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getESFDescriptionRemoteModel() {
		return _esfDescriptionRemoteModel;
	}

	public void setESFDescriptionRemoteModel(
		BaseModel<?> esfDescriptionRemoteModel) {
		_esfDescriptionRemoteModel = esfDescriptionRemoteModel;
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

		Class<?> remoteModelClass = _esfDescriptionRemoteModel.getClass();

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

		Object returnValue = method.invoke(_esfDescriptionRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ESFDescriptionLocalServiceUtil.addESFDescription(this);
		}
		else {
			ESFDescriptionLocalServiceUtil.updateESFDescription(this);
		}
	}

	@Override
	public ESFDescription toEscapedModel() {
		return (ESFDescription)ProxyUtil.newProxyInstance(ESFDescription.class.getClassLoader(),
			new Class[] { ESFDescription.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ESFDescriptionClp clone = new ESFDescriptionClp();

		clone.setEsfDescriptionId(getEsfDescriptionId());
		clone.setIsNational(getIsNational());
		clone.setName(getName());

		return clone;
	}

	@Override
	public int compareTo(ESFDescription esfDescription) {
		int value = 0;

		value = getName().compareTo(esfDescription.getName());

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

		if (!(obj instanceof ESFDescriptionClp)) {
			return false;
		}

		ESFDescriptionClp esfDescription = (ESFDescriptionClp)obj;

		long primaryKey = esfDescription.getPrimaryKey();

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

		sb.append("{esfDescriptionId=");
		sb.append(getEsfDescriptionId());
		sb.append(", isNational=");
		sb.append(getIsNational());
		sb.append(", name=");
		sb.append(getName());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("it.ethica.esf.model.ESFDescription");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>esfDescriptionId</column-name><column-value><![CDATA[");
		sb.append(getEsfDescriptionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isNational</column-name><column-value><![CDATA[");
		sb.append(getIsNational());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _esfDescriptionId;
	private boolean _isNational;
	private String _name;
	private BaseModel<?> _esfDescriptionRemoteModel;
}