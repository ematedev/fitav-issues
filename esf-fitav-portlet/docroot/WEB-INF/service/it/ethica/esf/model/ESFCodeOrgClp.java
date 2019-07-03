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
import it.ethica.esf.service.ESFCodeOrgLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ethica
 */
public class ESFCodeOrgClp extends BaseModelImpl<ESFCodeOrg>
	implements ESFCodeOrg {
	public ESFCodeOrgClp() {
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
	public long getPrimaryKey() {
		return _esfCodeOrgId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEsfCodeOrgId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _esfCodeOrgId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfCodeOrgId", getEsfCodeOrgId());
		attributes.put("className", getClassName());
		attributes.put("code", getCode());
		attributes.put("sequence", getSequence());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
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

	@Override
	public long getEsfCodeOrgId() {
		return _esfCodeOrgId;
	}

	@Override
	public void setEsfCodeOrgId(long esfCodeOrgId) {
		_esfCodeOrgId = esfCodeOrgId;

		if (_esfCodeOrgRemoteModel != null) {
			try {
				Class<?> clazz = _esfCodeOrgRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfCodeOrgId", long.class);

				method.invoke(_esfCodeOrgRemoteModel, esfCodeOrgId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getClassName() {
		return _className;
	}

	@Override
	public void setClassName(String className) {
		_className = className;

		if (_esfCodeOrgRemoteModel != null) {
			try {
				Class<?> clazz = _esfCodeOrgRemoteModel.getClass();

				Method method = clazz.getMethod("setClassName", String.class);

				method.invoke(_esfCodeOrgRemoteModel, className);
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

		if (_esfCodeOrgRemoteModel != null) {
			try {
				Class<?> clazz = _esfCodeOrgRemoteModel.getClass();

				Method method = clazz.getMethod("setCode", String.class);

				method.invoke(_esfCodeOrgRemoteModel, code);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSequence() {
		return _sequence;
	}

	@Override
	public void setSequence(long sequence) {
		_sequence = sequence;

		if (_esfCodeOrgRemoteModel != null) {
			try {
				Class<?> clazz = _esfCodeOrgRemoteModel.getClass();

				Method method = clazz.getMethod("setSequence", long.class);

				method.invoke(_esfCodeOrgRemoteModel, sequence);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getESFCodeOrgRemoteModel() {
		return _esfCodeOrgRemoteModel;
	}

	public void setESFCodeOrgRemoteModel(BaseModel<?> esfCodeOrgRemoteModel) {
		_esfCodeOrgRemoteModel = esfCodeOrgRemoteModel;
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

		Class<?> remoteModelClass = _esfCodeOrgRemoteModel.getClass();

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

		Object returnValue = method.invoke(_esfCodeOrgRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ESFCodeOrgLocalServiceUtil.addESFCodeOrg(this);
		}
		else {
			ESFCodeOrgLocalServiceUtil.updateESFCodeOrg(this);
		}
	}

	@Override
	public ESFCodeOrg toEscapedModel() {
		return (ESFCodeOrg)ProxyUtil.newProxyInstance(ESFCodeOrg.class.getClassLoader(),
			new Class[] { ESFCodeOrg.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ESFCodeOrgClp clone = new ESFCodeOrgClp();

		clone.setEsfCodeOrgId(getEsfCodeOrgId());
		clone.setClassName(getClassName());
		clone.setCode(getCode());
		clone.setSequence(getSequence());

		return clone;
	}

	@Override
	public int compareTo(ESFCodeOrg esfCodeOrg) {
		int value = 0;

		if (getSequence() < esfCodeOrg.getSequence()) {
			value = -1;
		}
		else if (getSequence() > esfCodeOrg.getSequence()) {
			value = 1;
		}
		else {
			value = 0;
		}

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

		if (!(obj instanceof ESFCodeOrgClp)) {
			return false;
		}

		ESFCodeOrgClp esfCodeOrg = (ESFCodeOrgClp)obj;

		long primaryKey = esfCodeOrg.getPrimaryKey();

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
		StringBundler sb = new StringBundler(9);

		sb.append("{esfCodeOrgId=");
		sb.append(getEsfCodeOrgId());
		sb.append(", className=");
		sb.append(getClassName());
		sb.append(", code=");
		sb.append(getCode());
		sb.append(", sequence=");
		sb.append(getSequence());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("it.ethica.esf.model.ESFCodeOrg");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>esfCodeOrgId</column-name><column-value><![CDATA[");
		sb.append(getEsfCodeOrgId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>className</column-name><column-value><![CDATA[");
		sb.append(getClassName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>code</column-name><column-value><![CDATA[");
		sb.append(getCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sequence</column-name><column-value><![CDATA[");
		sb.append(getSequence());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _esfCodeOrgId;
	private String _className;
	private String _code;
	private long _sequence;
	private BaseModel<?> _esfCodeOrgRemoteModel;
	private Class<?> _clpSerializerClass = it.ethica.esf.service.ClpSerializer.class;
}