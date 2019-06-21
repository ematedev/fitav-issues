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
import it.ethica.esf.service.ESFStateAssEntityLocalServiceUtil;
import it.ethica.esf.service.persistence.ESFStateAssEntityPK;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ethica
 */
public class ESFStateAssEntityClp extends BaseModelImpl<ESFStateAssEntity>
	implements ESFStateAssEntity {
	public ESFStateAssEntityClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ESFStateAssEntity.class;
	}

	@Override
	public String getModelClassName() {
		return ESFStateAssEntity.class.getName();
	}

	@Override
	public ESFStateAssEntityPK getPrimaryKey() {
		return new ESFStateAssEntityPK(_esfStateId, _className);
	}

	@Override
	public void setPrimaryKey(ESFStateAssEntityPK primaryKey) {
		setEsfStateId(primaryKey.esfStateId);
		setClassName(primaryKey.className);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new ESFStateAssEntityPK(_esfStateId, _className);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((ESFStateAssEntityPK)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfStateId", getEsfStateId());
		attributes.put("className", getClassName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esfStateId = (Long)attributes.get("esfStateId");

		if (esfStateId != null) {
			setEsfStateId(esfStateId);
		}

		String className = (String)attributes.get("className");

		if (className != null) {
			setClassName(className);
		}
	}

	@Override
	public long getEsfStateId() {
		return _esfStateId;
	}

	@Override
	public void setEsfStateId(long esfStateId) {
		_esfStateId = esfStateId;

		if (_esfStateAssEntityRemoteModel != null) {
			try {
				Class<?> clazz = _esfStateAssEntityRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfStateId", long.class);

				method.invoke(_esfStateAssEntityRemoteModel, esfStateId);
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

		if (_esfStateAssEntityRemoteModel != null) {
			try {
				Class<?> clazz = _esfStateAssEntityRemoteModel.getClass();

				Method method = clazz.getMethod("setClassName", String.class);

				method.invoke(_esfStateAssEntityRemoteModel, className);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getESFStateAssEntityRemoteModel() {
		return _esfStateAssEntityRemoteModel;
	}

	public void setESFStateAssEntityRemoteModel(
		BaseModel<?> esfStateAssEntityRemoteModel) {
		_esfStateAssEntityRemoteModel = esfStateAssEntityRemoteModel;
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

		Class<?> remoteModelClass = _esfStateAssEntityRemoteModel.getClass();

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

		Object returnValue = method.invoke(_esfStateAssEntityRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ESFStateAssEntityLocalServiceUtil.addESFStateAssEntity(this);
		}
		else {
			ESFStateAssEntityLocalServiceUtil.updateESFStateAssEntity(this);
		}
	}

	@Override
	public ESFStateAssEntity toEscapedModel() {
		return (ESFStateAssEntity)ProxyUtil.newProxyInstance(ESFStateAssEntity.class.getClassLoader(),
			new Class[] { ESFStateAssEntity.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ESFStateAssEntityClp clone = new ESFStateAssEntityClp();

		clone.setEsfStateId(getEsfStateId());
		clone.setClassName(getClassName());

		return clone;
	}

	@Override
	public int compareTo(ESFStateAssEntity esfStateAssEntity) {
		ESFStateAssEntityPK primaryKey = esfStateAssEntity.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFStateAssEntityClp)) {
			return false;
		}

		ESFStateAssEntityClp esfStateAssEntity = (ESFStateAssEntityClp)obj;

		ESFStateAssEntityPK primaryKey = esfStateAssEntity.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{esfStateId=");
		sb.append(getEsfStateId());
		sb.append(", className=");
		sb.append(getClassName());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(10);

		sb.append("<model><model-name>");
		sb.append("it.ethica.esf.model.ESFStateAssEntity");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>esfStateId</column-name><column-value><![CDATA[");
		sb.append(getEsfStateId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>className</column-name><column-value><![CDATA[");
		sb.append(getClassName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _esfStateId;
	private String _className;
	private BaseModel<?> _esfStateAssEntityRemoteModel;
}