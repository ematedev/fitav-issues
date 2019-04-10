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
import it.ethica.esf.service.ESFShootingDirectorQualificationLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ethica
 */
public class ESFShootingDirectorQualificationClp extends BaseModelImpl<ESFShootingDirectorQualification>
	implements ESFShootingDirectorQualification {
	public ESFShootingDirectorQualificationClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ESFShootingDirectorQualification.class;
	}

	@Override
	public String getModelClassName() {
		return ESFShootingDirectorQualification.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _esfShootingDirectorQualificationId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEsfShootingDirectorQualificationId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _esfShootingDirectorQualificationId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfShootingDirectorQualificationId",
			getEsfShootingDirectorQualificationId());
		attributes.put("esfShootingDirectorQualificationDesc",
			getEsfShootingDirectorQualificationDesc());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esfShootingDirectorQualificationId = (Long)attributes.get(
				"esfShootingDirectorQualificationId");

		if (esfShootingDirectorQualificationId != null) {
			setEsfShootingDirectorQualificationId(esfShootingDirectorQualificationId);
		}

		String esfShootingDirectorQualificationDesc = (String)attributes.get(
				"esfShootingDirectorQualificationDesc");

		if (esfShootingDirectorQualificationDesc != null) {
			setEsfShootingDirectorQualificationDesc(esfShootingDirectorQualificationDesc);
		}
	}

	@Override
	public long getEsfShootingDirectorQualificationId() {
		return _esfShootingDirectorQualificationId;
	}

	@Override
	public void setEsfShootingDirectorQualificationId(
		long esfShootingDirectorQualificationId) {
		_esfShootingDirectorQualificationId = esfShootingDirectorQualificationId;

		if (_esfShootingDirectorQualificationRemoteModel != null) {
			try {
				Class<?> clazz = _esfShootingDirectorQualificationRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfShootingDirectorQualificationId",
						long.class);

				method.invoke(_esfShootingDirectorQualificationRemoteModel,
					esfShootingDirectorQualificationId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEsfShootingDirectorQualificationDesc() {
		return _esfShootingDirectorQualificationDesc;
	}

	@Override
	public void setEsfShootingDirectorQualificationDesc(
		String esfShootingDirectorQualificationDesc) {
		_esfShootingDirectorQualificationDesc = esfShootingDirectorQualificationDesc;

		if (_esfShootingDirectorQualificationRemoteModel != null) {
			try {
				Class<?> clazz = _esfShootingDirectorQualificationRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfShootingDirectorQualificationDesc",
						String.class);

				method.invoke(_esfShootingDirectorQualificationRemoteModel,
					esfShootingDirectorQualificationDesc);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getESFShootingDirectorQualificationRemoteModel() {
		return _esfShootingDirectorQualificationRemoteModel;
	}

	public void setESFShootingDirectorQualificationRemoteModel(
		BaseModel<?> esfShootingDirectorQualificationRemoteModel) {
		_esfShootingDirectorQualificationRemoteModel = esfShootingDirectorQualificationRemoteModel;
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

		Class<?> remoteModelClass = _esfShootingDirectorQualificationRemoteModel.getClass();

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

		Object returnValue = method.invoke(_esfShootingDirectorQualificationRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ESFShootingDirectorQualificationLocalServiceUtil.addESFShootingDirectorQualification(this);
		}
		else {
			ESFShootingDirectorQualificationLocalServiceUtil.updateESFShootingDirectorQualification(this);
		}
	}

	@Override
	public ESFShootingDirectorQualification toEscapedModel() {
		return (ESFShootingDirectorQualification)ProxyUtil.newProxyInstance(ESFShootingDirectorQualification.class.getClassLoader(),
			new Class[] { ESFShootingDirectorQualification.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ESFShootingDirectorQualificationClp clone = new ESFShootingDirectorQualificationClp();

		clone.setEsfShootingDirectorQualificationId(getEsfShootingDirectorQualificationId());
		clone.setEsfShootingDirectorQualificationDesc(getEsfShootingDirectorQualificationDesc());

		return clone;
	}

	@Override
	public int compareTo(
		ESFShootingDirectorQualification esfShootingDirectorQualification) {
		int value = 0;

		if (getEsfShootingDirectorQualificationId() < esfShootingDirectorQualification.getEsfShootingDirectorQualificationId()) {
			value = -1;
		}
		else if (getEsfShootingDirectorQualificationId() > esfShootingDirectorQualification.getEsfShootingDirectorQualificationId()) {
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

		if (!(obj instanceof ESFShootingDirectorQualificationClp)) {
			return false;
		}

		ESFShootingDirectorQualificationClp esfShootingDirectorQualification = (ESFShootingDirectorQualificationClp)obj;

		long primaryKey = esfShootingDirectorQualification.getPrimaryKey();

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
		StringBundler sb = new StringBundler(5);

		sb.append("{esfShootingDirectorQualificationId=");
		sb.append(getEsfShootingDirectorQualificationId());
		sb.append(", esfShootingDirectorQualificationDesc=");
		sb.append(getEsfShootingDirectorQualificationDesc());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(10);

		sb.append("<model><model-name>");
		sb.append("it.ethica.esf.model.ESFShootingDirectorQualification");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>esfShootingDirectorQualificationId</column-name><column-value><![CDATA[");
		sb.append(getEsfShootingDirectorQualificationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfShootingDirectorQualificationDesc</column-name><column-value><![CDATA[");
		sb.append(getEsfShootingDirectorQualificationDesc());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _esfShootingDirectorQualificationId;
	private String _esfShootingDirectorQualificationDesc;
	private BaseModel<?> _esfShootingDirectorQualificationRemoteModel;
}