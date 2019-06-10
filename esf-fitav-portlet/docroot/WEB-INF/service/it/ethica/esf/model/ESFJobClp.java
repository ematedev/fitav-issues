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
import it.ethica.esf.service.ESFJobLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ethica
 */
public class ESFJobClp extends BaseModelImpl<ESFJob> implements ESFJob {
	public ESFJobClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ESFJob.class;
	}

	@Override
	public String getModelClassName() {
		return ESFJob.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _esfJobId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEsfJobId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _esfJobId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfJobId", getEsfJobId());
		attributes.put("esfName", getEsfName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esfJobId = (Long)attributes.get("esfJobId");

		if (esfJobId != null) {
			setEsfJobId(esfJobId);
		}

		String esfName = (String)attributes.get("esfName");

		if (esfName != null) {
			setEsfName(esfName);
		}
	}

	@Override
	public long getEsfJobId() {
		return _esfJobId;
	}

	@Override
	public void setEsfJobId(long esfJobId) {
		_esfJobId = esfJobId;

		if (_esfJobRemoteModel != null) {
			try {
				Class<?> clazz = _esfJobRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfJobId", long.class);

				method.invoke(_esfJobRemoteModel, esfJobId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEsfName() {
		return _esfName;
	}

	@Override
	public void setEsfName(String esfName) {
		_esfName = esfName;

		if (_esfJobRemoteModel != null) {
			try {
				Class<?> clazz = _esfJobRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfName", String.class);

				method.invoke(_esfJobRemoteModel, esfName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getESFJobRemoteModel() {
		return _esfJobRemoteModel;
	}

	public void setESFJobRemoteModel(BaseModel<?> esfJobRemoteModel) {
		_esfJobRemoteModel = esfJobRemoteModel;
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

		Class<?> remoteModelClass = _esfJobRemoteModel.getClass();

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

		Object returnValue = method.invoke(_esfJobRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ESFJobLocalServiceUtil.addESFJob(this);
		}
		else {
			ESFJobLocalServiceUtil.updateESFJob(this);
		}
	}

	@Override
	public ESFJob toEscapedModel() {
		return (ESFJob)ProxyUtil.newProxyInstance(ESFJob.class.getClassLoader(),
			new Class[] { ESFJob.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ESFJobClp clone = new ESFJobClp();

		clone.setEsfJobId(getEsfJobId());
		clone.setEsfName(getEsfName());

		return clone;
	}

	@Override
	public int compareTo(ESFJob esfJob) {
		long primaryKey = esfJob.getPrimaryKey();

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

		if (!(obj instanceof ESFJobClp)) {
			return false;
		}

		ESFJobClp esfJob = (ESFJobClp)obj;

		long primaryKey = esfJob.getPrimaryKey();

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

		sb.append("{esfJobId=");
		sb.append(getEsfJobId());
		sb.append(", esfName=");
		sb.append(getEsfName());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(10);

		sb.append("<model><model-name>");
		sb.append("it.ethica.esf.model.ESFJob");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>esfJobId</column-name><column-value><![CDATA[");
		sb.append(getEsfJobId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfName</column-name><column-value><![CDATA[");
		sb.append(getEsfName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _esfJobId;
	private String _esfName;
	private BaseModel<?> _esfJobRemoteModel;
}