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
import it.ethica.esf.service.ESFLentFieldLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ethica
 */
public class ESFLentFieldClp extends BaseModelImpl<ESFLentField>
	implements ESFLentField {
	public ESFLentFieldClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ESFLentField.class;
	}

	@Override
	public String getModelClassName() {
		return ESFLentField.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _lentFieldId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setLentFieldId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _lentFieldId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("lentFieldId", getLentFieldId());
		attributes.put("esfEntityStateId", getEsfEntityStateId());
		attributes.put("esfFieldId", getEsfFieldId());
		attributes.put("realOwnerId", getRealOwnerId());
		attributes.put("actualOwnerId", getActualOwnerId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long lentFieldId = (Long)attributes.get("lentFieldId");

		if (lentFieldId != null) {
			setLentFieldId(lentFieldId);
		}

		Long esfEntityStateId = (Long)attributes.get("esfEntityStateId");

		if (esfEntityStateId != null) {
			setEsfEntityStateId(esfEntityStateId);
		}

		Long esfFieldId = (Long)attributes.get("esfFieldId");

		if (esfFieldId != null) {
			setEsfFieldId(esfFieldId);
		}

		Long realOwnerId = (Long)attributes.get("realOwnerId");

		if (realOwnerId != null) {
			setRealOwnerId(realOwnerId);
		}

		Long actualOwnerId = (Long)attributes.get("actualOwnerId");

		if (actualOwnerId != null) {
			setActualOwnerId(actualOwnerId);
		}
	}

	@Override
	public long getLentFieldId() {
		return _lentFieldId;
	}

	@Override
	public void setLentFieldId(long lentFieldId) {
		_lentFieldId = lentFieldId;

		if (_esfLentFieldRemoteModel != null) {
			try {
				Class<?> clazz = _esfLentFieldRemoteModel.getClass();

				Method method = clazz.getMethod("setLentFieldId", long.class);

				method.invoke(_esfLentFieldRemoteModel, lentFieldId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEsfEntityStateId() {
		return _esfEntityStateId;
	}

	@Override
	public void setEsfEntityStateId(long esfEntityStateId) {
		_esfEntityStateId = esfEntityStateId;

		if (_esfLentFieldRemoteModel != null) {
			try {
				Class<?> clazz = _esfLentFieldRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfEntityStateId",
						long.class);

				method.invoke(_esfLentFieldRemoteModel, esfEntityStateId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEsfFieldId() {
		return _esfFieldId;
	}

	@Override
	public void setEsfFieldId(long esfFieldId) {
		_esfFieldId = esfFieldId;

		if (_esfLentFieldRemoteModel != null) {
			try {
				Class<?> clazz = _esfLentFieldRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfFieldId", long.class);

				method.invoke(_esfLentFieldRemoteModel, esfFieldId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getRealOwnerId() {
		return _realOwnerId;
	}

	@Override
	public void setRealOwnerId(long realOwnerId) {
		_realOwnerId = realOwnerId;

		if (_esfLentFieldRemoteModel != null) {
			try {
				Class<?> clazz = _esfLentFieldRemoteModel.getClass();

				Method method = clazz.getMethod("setRealOwnerId", long.class);

				method.invoke(_esfLentFieldRemoteModel, realOwnerId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getActualOwnerId() {
		return _actualOwnerId;
	}

	@Override
	public void setActualOwnerId(long actualOwnerId) {
		_actualOwnerId = actualOwnerId;

		if (_esfLentFieldRemoteModel != null) {
			try {
				Class<?> clazz = _esfLentFieldRemoteModel.getClass();

				Method method = clazz.getMethod("setActualOwnerId", long.class);

				method.invoke(_esfLentFieldRemoteModel, actualOwnerId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getESFLentFieldRemoteModel() {
		return _esfLentFieldRemoteModel;
	}

	public void setESFLentFieldRemoteModel(BaseModel<?> esfLentFieldRemoteModel) {
		_esfLentFieldRemoteModel = esfLentFieldRemoteModel;
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

		Class<?> remoteModelClass = _esfLentFieldRemoteModel.getClass();

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

		Object returnValue = method.invoke(_esfLentFieldRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ESFLentFieldLocalServiceUtil.addESFLentField(this);
		}
		else {
			ESFLentFieldLocalServiceUtil.updateESFLentField(this);
		}
	}

	@Override
	public ESFLentField toEscapedModel() {
		return (ESFLentField)ProxyUtil.newProxyInstance(ESFLentField.class.getClassLoader(),
			new Class[] { ESFLentField.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ESFLentFieldClp clone = new ESFLentFieldClp();

		clone.setLentFieldId(getLentFieldId());
		clone.setEsfEntityStateId(getEsfEntityStateId());
		clone.setEsfFieldId(getEsfFieldId());
		clone.setRealOwnerId(getRealOwnerId());
		clone.setActualOwnerId(getActualOwnerId());

		return clone;
	}

	@Override
	public int compareTo(ESFLentField esfLentField) {
		long primaryKey = esfLentField.getPrimaryKey();

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

		if (!(obj instanceof ESFLentFieldClp)) {
			return false;
		}

		ESFLentFieldClp esfLentField = (ESFLentFieldClp)obj;

		long primaryKey = esfLentField.getPrimaryKey();

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
		StringBundler sb = new StringBundler(11);

		sb.append("{lentFieldId=");
		sb.append(getLentFieldId());
		sb.append(", esfEntityStateId=");
		sb.append(getEsfEntityStateId());
		sb.append(", esfFieldId=");
		sb.append(getEsfFieldId());
		sb.append(", realOwnerId=");
		sb.append(getRealOwnerId());
		sb.append(", actualOwnerId=");
		sb.append(getActualOwnerId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("it.ethica.esf.model.ESFLentField");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>lentFieldId</column-name><column-value><![CDATA[");
		sb.append(getLentFieldId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfEntityStateId</column-name><column-value><![CDATA[");
		sb.append(getEsfEntityStateId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfFieldId</column-name><column-value><![CDATA[");
		sb.append(getEsfFieldId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>realOwnerId</column-name><column-value><![CDATA[");
		sb.append(getRealOwnerId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>actualOwnerId</column-name><column-value><![CDATA[");
		sb.append(getActualOwnerId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _lentFieldId;
	private long _esfEntityStateId;
	private long _esfFieldId;
	private long _realOwnerId;
	private long _actualOwnerId;
	private BaseModel<?> _esfLentFieldRemoteModel;
	private Class<?> _clpSerializerClass = it.ethica.esf.service.ClpSerializer.class;
}