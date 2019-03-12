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
import it.ethica.esf.service.ESFElectronicLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ethica
 */
public class ESFElectronicClp extends BaseModelImpl<ESFElectronic>
	implements ESFElectronic {
	public ESFElectronicClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ESFElectronic.class;
	}

	@Override
	public String getModelClassName() {
		return ESFElectronic.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _electronicId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setElectronicId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _electronicId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("electronicId", getElectronicId());
		attributes.put("name", getName());
		attributes.put("description", getDescription());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long electronicId = (Long)attributes.get("electronicId");

		if (electronicId != null) {
			setElectronicId(electronicId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}
	}

	@Override
	public long getElectronicId() {
		return _electronicId;
	}

	@Override
	public void setElectronicId(long electronicId) {
		_electronicId = electronicId;

		if (_esfElectronicRemoteModel != null) {
			try {
				Class<?> clazz = _esfElectronicRemoteModel.getClass();

				Method method = clazz.getMethod("setElectronicId", long.class);

				method.invoke(_esfElectronicRemoteModel, electronicId);
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

		if (_esfElectronicRemoteModel != null) {
			try {
				Class<?> clazz = _esfElectronicRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_esfElectronicRemoteModel, name);
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

		if (_esfElectronicRemoteModel != null) {
			try {
				Class<?> clazz = _esfElectronicRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_esfElectronicRemoteModel, description);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getESFElectronicRemoteModel() {
		return _esfElectronicRemoteModel;
	}

	public void setESFElectronicRemoteModel(
		BaseModel<?> esfElectronicRemoteModel) {
		_esfElectronicRemoteModel = esfElectronicRemoteModel;
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

		Class<?> remoteModelClass = _esfElectronicRemoteModel.getClass();

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

		Object returnValue = method.invoke(_esfElectronicRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ESFElectronicLocalServiceUtil.addESFElectronic(this);
		}
		else {
			ESFElectronicLocalServiceUtil.updateESFElectronic(this);
		}
	}

	@Override
	public ESFElectronic toEscapedModel() {
		return (ESFElectronic)ProxyUtil.newProxyInstance(ESFElectronic.class.getClassLoader(),
			new Class[] { ESFElectronic.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ESFElectronicClp clone = new ESFElectronicClp();

		clone.setElectronicId(getElectronicId());
		clone.setName(getName());
		clone.setDescription(getDescription());

		return clone;
	}

	@Override
	public int compareTo(ESFElectronic esfElectronic) {
		int value = 0;

		value = getName().compareTo(esfElectronic.getName());

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

		if (!(obj instanceof ESFElectronicClp)) {
			return false;
		}

		ESFElectronicClp esfElectronic = (ESFElectronicClp)obj;

		long primaryKey = esfElectronic.getPrimaryKey();

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
		StringBundler sb = new StringBundler(7);

		sb.append("{electronicId=");
		sb.append(getElectronicId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("it.ethica.esf.model.ESFElectronic");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>electronicId</column-name><column-value><![CDATA[");
		sb.append(getElectronicId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _electronicId;
	private String _name;
	private String _description;
	private BaseModel<?> _esfElectronicRemoteModel;
	private Class<?> _clpSerializerClass = it.ethica.esf.service.ClpSerializer.class;
}