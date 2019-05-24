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
import it.ethica.esf.service.ESFInstructsShootingDirectorLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ethica
 */
public class ESFInstructsShootingDirectorClp extends BaseModelImpl<ESFInstructsShootingDirector>
	implements ESFInstructsShootingDirector {
	public ESFInstructsShootingDirectorClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ESFInstructsShootingDirector.class;
	}

	@Override
	public String getModelClassName() {
		return ESFInstructsShootingDirector.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _esfInstructsShootingDirectorId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEsfInstructsShootingDirectorId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _esfInstructsShootingDirectorId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfInstructsShootingDirectorId",
			getEsfInstructsShootingDirectorId());
		attributes.put("esfInstructsShootingDirectorCode",
			getEsfInstructsShootingDirectorCode());
		attributes.put("esfInstructsShootingDirectorDesc",
			getEsfInstructsShootingDirectorDesc());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esfInstructsShootingDirectorId = (Long)attributes.get(
				"esfInstructsShootingDirectorId");

		if (esfInstructsShootingDirectorId != null) {
			setEsfInstructsShootingDirectorId(esfInstructsShootingDirectorId);
		}

		String esfInstructsShootingDirectorCode = (String)attributes.get(
				"esfInstructsShootingDirectorCode");

		if (esfInstructsShootingDirectorCode != null) {
			setEsfInstructsShootingDirectorCode(esfInstructsShootingDirectorCode);
		}

		String esfInstructsShootingDirectorDesc = (String)attributes.get(
				"esfInstructsShootingDirectorDesc");

		if (esfInstructsShootingDirectorDesc != null) {
			setEsfInstructsShootingDirectorDesc(esfInstructsShootingDirectorDesc);
		}
	}

	@Override
	public long getEsfInstructsShootingDirectorId() {
		return _esfInstructsShootingDirectorId;
	}

	@Override
	public void setEsfInstructsShootingDirectorId(
		long esfInstructsShootingDirectorId) {
		_esfInstructsShootingDirectorId = esfInstructsShootingDirectorId;

		if (_esfInstructsShootingDirectorRemoteModel != null) {
			try {
				Class<?> clazz = _esfInstructsShootingDirectorRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfInstructsShootingDirectorId",
						long.class);

				method.invoke(_esfInstructsShootingDirectorRemoteModel,
					esfInstructsShootingDirectorId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEsfInstructsShootingDirectorCode() {
		return _esfInstructsShootingDirectorCode;
	}

	@Override
	public void setEsfInstructsShootingDirectorCode(
		String esfInstructsShootingDirectorCode) {
		_esfInstructsShootingDirectorCode = esfInstructsShootingDirectorCode;

		if (_esfInstructsShootingDirectorRemoteModel != null) {
			try {
				Class<?> clazz = _esfInstructsShootingDirectorRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfInstructsShootingDirectorCode",
						String.class);

				method.invoke(_esfInstructsShootingDirectorRemoteModel,
					esfInstructsShootingDirectorCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEsfInstructsShootingDirectorDesc() {
		return _esfInstructsShootingDirectorDesc;
	}

	@Override
	public void setEsfInstructsShootingDirectorDesc(
		String esfInstructsShootingDirectorDesc) {
		_esfInstructsShootingDirectorDesc = esfInstructsShootingDirectorDesc;

		if (_esfInstructsShootingDirectorRemoteModel != null) {
			try {
				Class<?> clazz = _esfInstructsShootingDirectorRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfInstructsShootingDirectorDesc",
						String.class);

				method.invoke(_esfInstructsShootingDirectorRemoteModel,
					esfInstructsShootingDirectorDesc);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getESFInstructsShootingDirectorRemoteModel() {
		return _esfInstructsShootingDirectorRemoteModel;
	}

	public void setESFInstructsShootingDirectorRemoteModel(
		BaseModel<?> esfInstructsShootingDirectorRemoteModel) {
		_esfInstructsShootingDirectorRemoteModel = esfInstructsShootingDirectorRemoteModel;
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

		Class<?> remoteModelClass = _esfInstructsShootingDirectorRemoteModel.getClass();

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

		Object returnValue = method.invoke(_esfInstructsShootingDirectorRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ESFInstructsShootingDirectorLocalServiceUtil.addESFInstructsShootingDirector(this);
		}
		else {
			ESFInstructsShootingDirectorLocalServiceUtil.updateESFInstructsShootingDirector(this);
		}
	}

	@Override
	public ESFInstructsShootingDirector toEscapedModel() {
		return (ESFInstructsShootingDirector)ProxyUtil.newProxyInstance(ESFInstructsShootingDirector.class.getClassLoader(),
			new Class[] { ESFInstructsShootingDirector.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ESFInstructsShootingDirectorClp clone = new ESFInstructsShootingDirectorClp();

		clone.setEsfInstructsShootingDirectorId(getEsfInstructsShootingDirectorId());
		clone.setEsfInstructsShootingDirectorCode(getEsfInstructsShootingDirectorCode());
		clone.setEsfInstructsShootingDirectorDesc(getEsfInstructsShootingDirectorDesc());

		return clone;
	}

	@Override
	public int compareTo(
		ESFInstructsShootingDirector esfInstructsShootingDirector) {
		int value = 0;

		if (getEsfInstructsShootingDirectorId() < esfInstructsShootingDirector.getEsfInstructsShootingDirectorId()) {
			value = -1;
		}
		else if (getEsfInstructsShootingDirectorId() > esfInstructsShootingDirector.getEsfInstructsShootingDirectorId()) {
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

		if (!(obj instanceof ESFInstructsShootingDirectorClp)) {
			return false;
		}

		ESFInstructsShootingDirectorClp esfInstructsShootingDirector = (ESFInstructsShootingDirectorClp)obj;

		long primaryKey = esfInstructsShootingDirector.getPrimaryKey();

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

		sb.append("{esfInstructsShootingDirectorId=");
		sb.append(getEsfInstructsShootingDirectorId());
		sb.append(", esfInstructsShootingDirectorCode=");
		sb.append(getEsfInstructsShootingDirectorCode());
		sb.append(", esfInstructsShootingDirectorDesc=");
		sb.append(getEsfInstructsShootingDirectorDesc());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("it.ethica.esf.model.ESFInstructsShootingDirector");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>esfInstructsShootingDirectorId</column-name><column-value><![CDATA[");
		sb.append(getEsfInstructsShootingDirectorId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfInstructsShootingDirectorCode</column-name><column-value><![CDATA[");
		sb.append(getEsfInstructsShootingDirectorCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfInstructsShootingDirectorDesc</column-name><column-value><![CDATA[");
		sb.append(getEsfInstructsShootingDirectorDesc());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _esfInstructsShootingDirectorId;
	private String _esfInstructsShootingDirectorCode;
	private String _esfInstructsShootingDirectorDesc;
	private BaseModel<?> _esfInstructsShootingDirectorRemoteModel;
	private Class<?> _clpSerializerClass = it.ethica.esf.service.ClpSerializer.class;
}