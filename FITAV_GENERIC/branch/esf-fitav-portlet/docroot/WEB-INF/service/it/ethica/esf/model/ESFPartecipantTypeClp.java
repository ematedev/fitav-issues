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
import it.ethica.esf.service.ESFPartecipantTypeLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ethica
 */
public class ESFPartecipantTypeClp extends BaseModelImpl<ESFPartecipantType>
	implements ESFPartecipantType {
	public ESFPartecipantTypeClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ESFPartecipantType.class;
	}

	@Override
	public String getModelClassName() {
		return ESFPartecipantType.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _esfPartecipantTypeId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEsfPartecipantTypeId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _esfPartecipantTypeId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfPartecipantTypeId", getEsfPartecipantTypeId());
		attributes.put("name", getName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esfPartecipantTypeId = (Long)attributes.get("esfPartecipantTypeId");

		if (esfPartecipantTypeId != null) {
			setEsfPartecipantTypeId(esfPartecipantTypeId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}
	}

	@Override
	public long getEsfPartecipantTypeId() {
		return _esfPartecipantTypeId;
	}

	@Override
	public void setEsfPartecipantTypeId(long esfPartecipantTypeId) {
		_esfPartecipantTypeId = esfPartecipantTypeId;

		if (_esfPartecipantTypeRemoteModel != null) {
			try {
				Class<?> clazz = _esfPartecipantTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfPartecipantTypeId",
						long.class);

				method.invoke(_esfPartecipantTypeRemoteModel,
					esfPartecipantTypeId);
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

		if (_esfPartecipantTypeRemoteModel != null) {
			try {
				Class<?> clazz = _esfPartecipantTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_esfPartecipantTypeRemoteModel, name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getESFPartecipantTypeRemoteModel() {
		return _esfPartecipantTypeRemoteModel;
	}

	public void setESFPartecipantTypeRemoteModel(
		BaseModel<?> esfPartecipantTypeRemoteModel) {
		_esfPartecipantTypeRemoteModel = esfPartecipantTypeRemoteModel;
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

		Class<?> remoteModelClass = _esfPartecipantTypeRemoteModel.getClass();

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

		Object returnValue = method.invoke(_esfPartecipantTypeRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ESFPartecipantTypeLocalServiceUtil.addESFPartecipantType(this);
		}
		else {
			ESFPartecipantTypeLocalServiceUtil.updateESFPartecipantType(this);
		}
	}

	@Override
	public ESFPartecipantType toEscapedModel() {
		return (ESFPartecipantType)ProxyUtil.newProxyInstance(ESFPartecipantType.class.getClassLoader(),
			new Class[] { ESFPartecipantType.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ESFPartecipantTypeClp clone = new ESFPartecipantTypeClp();

		clone.setEsfPartecipantTypeId(getEsfPartecipantTypeId());
		clone.setName(getName());

		return clone;
	}

	@Override
	public int compareTo(ESFPartecipantType esfPartecipantType) {
		long primaryKey = esfPartecipantType.getPrimaryKey();

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

		if (!(obj instanceof ESFPartecipantTypeClp)) {
			return false;
		}

		ESFPartecipantTypeClp esfPartecipantType = (ESFPartecipantTypeClp)obj;

		long primaryKey = esfPartecipantType.getPrimaryKey();

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
		StringBundler sb = new StringBundler(5);

		sb.append("{esfPartecipantTypeId=");
		sb.append(getEsfPartecipantTypeId());
		sb.append(", name=");
		sb.append(getName());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(10);

		sb.append("<model><model-name>");
		sb.append("it.ethica.esf.model.ESFPartecipantType");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>esfPartecipantTypeId</column-name><column-value><![CDATA[");
		sb.append(getEsfPartecipantTypeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _esfPartecipantTypeId;
	private String _name;
	private BaseModel<?> _esfPartecipantTypeRemoteModel;
	private Class<?> _clpSerializerClass = it.ethica.esf.service.ClpSerializer.class;
}