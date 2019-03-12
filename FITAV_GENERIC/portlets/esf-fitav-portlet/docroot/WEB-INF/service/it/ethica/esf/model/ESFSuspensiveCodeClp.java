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
import it.ethica.esf.service.ESFSuspensiveCodeLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ethica
 */
public class ESFSuspensiveCodeClp extends BaseModelImpl<ESFSuspensiveCode>
	implements ESFSuspensiveCode {
	public ESFSuspensiveCodeClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ESFSuspensiveCode.class;
	}

	@Override
	public String getModelClassName() {
		return ESFSuspensiveCode.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _esfSuspensiveCodeId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEsfSuspensiveCodeId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _esfSuspensiveCodeId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfSuspensiveCodeId", getEsfSuspensiveCodeId());
		attributes.put("code", getCode());
		attributes.put("description", getDescription());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esfSuspensiveCodeId = (Long)attributes.get("esfSuspensiveCodeId");

		if (esfSuspensiveCodeId != null) {
			setEsfSuspensiveCodeId(esfSuspensiveCodeId);
		}

		String code = (String)attributes.get("code");

		if (code != null) {
			setCode(code);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}
	}

	@Override
	public long getEsfSuspensiveCodeId() {
		return _esfSuspensiveCodeId;
	}

	@Override
	public void setEsfSuspensiveCodeId(long esfSuspensiveCodeId) {
		_esfSuspensiveCodeId = esfSuspensiveCodeId;

		if (_esfSuspensiveCodeRemoteModel != null) {
			try {
				Class<?> clazz = _esfSuspensiveCodeRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfSuspensiveCodeId",
						long.class);

				method.invoke(_esfSuspensiveCodeRemoteModel, esfSuspensiveCodeId);
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

		if (_esfSuspensiveCodeRemoteModel != null) {
			try {
				Class<?> clazz = _esfSuspensiveCodeRemoteModel.getClass();

				Method method = clazz.getMethod("setCode", String.class);

				method.invoke(_esfSuspensiveCodeRemoteModel, code);
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

		if (_esfSuspensiveCodeRemoteModel != null) {
			try {
				Class<?> clazz = _esfSuspensiveCodeRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_esfSuspensiveCodeRemoteModel, description);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getESFSuspensiveCodeRemoteModel() {
		return _esfSuspensiveCodeRemoteModel;
	}

	public void setESFSuspensiveCodeRemoteModel(
		BaseModel<?> esfSuspensiveCodeRemoteModel) {
		_esfSuspensiveCodeRemoteModel = esfSuspensiveCodeRemoteModel;
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

		Class<?> remoteModelClass = _esfSuspensiveCodeRemoteModel.getClass();

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

		Object returnValue = method.invoke(_esfSuspensiveCodeRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ESFSuspensiveCodeLocalServiceUtil.addESFSuspensiveCode(this);
		}
		else {
			ESFSuspensiveCodeLocalServiceUtil.updateESFSuspensiveCode(this);
		}
	}

	@Override
	public ESFSuspensiveCode toEscapedModel() {
		return (ESFSuspensiveCode)ProxyUtil.newProxyInstance(ESFSuspensiveCode.class.getClassLoader(),
			new Class[] { ESFSuspensiveCode.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ESFSuspensiveCodeClp clone = new ESFSuspensiveCodeClp();

		clone.setEsfSuspensiveCodeId(getEsfSuspensiveCodeId());
		clone.setCode(getCode());
		clone.setDescription(getDescription());

		return clone;
	}

	@Override
	public int compareTo(ESFSuspensiveCode esfSuspensiveCode) {
		long primaryKey = esfSuspensiveCode.getPrimaryKey();

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

		if (!(obj instanceof ESFSuspensiveCodeClp)) {
			return false;
		}

		ESFSuspensiveCodeClp esfSuspensiveCode = (ESFSuspensiveCodeClp)obj;

		long primaryKey = esfSuspensiveCode.getPrimaryKey();

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

		sb.append("{esfSuspensiveCodeId=");
		sb.append(getEsfSuspensiveCodeId());
		sb.append(", code=");
		sb.append(getCode());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("it.ethica.esf.model.ESFSuspensiveCode");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>esfSuspensiveCodeId</column-name><column-value><![CDATA[");
		sb.append(getEsfSuspensiveCodeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>code</column-name><column-value><![CDATA[");
		sb.append(getCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _esfSuspensiveCodeId;
	private String _code;
	private String _description;
	private BaseModel<?> _esfSuspensiveCodeRemoteModel;
}