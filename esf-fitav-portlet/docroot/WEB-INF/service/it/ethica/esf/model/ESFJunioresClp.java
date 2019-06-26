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
import com.liferay.portal.util.PortalUtil;

import it.ethica.esf.service.ClpSerializer;
import it.ethica.esf.service.ESFJunioresLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ethica
 */
public class ESFJunioresClp extends BaseModelImpl<ESFJuniores>
	implements ESFJuniores {
	public ESFJunioresClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ESFJuniores.class;
	}

	@Override
	public String getModelClassName() {
		return ESFJuniores.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _ESFUserId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setESFUserId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _ESFUserId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ESFUserId", getESFUserId());
		attributes.put("startDate", getStartDate());
		attributes.put("endDate", getEndDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long ESFUserId = (Long)attributes.get("ESFUserId");

		if (ESFUserId != null) {
			setESFUserId(ESFUserId);
		}

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}
	}

	@Override
	public long getESFUserId() {
		return _ESFUserId;
	}

	@Override
	public void setESFUserId(long ESFUserId) {
		_ESFUserId = ESFUserId;

		if (_esfJunioresRemoteModel != null) {
			try {
				Class<?> clazz = _esfJunioresRemoteModel.getClass();

				Method method = clazz.getMethod("setESFUserId", long.class);

				method.invoke(_esfJunioresRemoteModel, ESFUserId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getESFUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getESFUserId(), "uuid", _ESFUserUuid);
	}

	@Override
	public void setESFUserUuid(String ESFUserUuid) {
		_ESFUserUuid = ESFUserUuid;
	}

	@Override
	public Date getStartDate() {
		return _startDate;
	}

	@Override
	public void setStartDate(Date startDate) {
		_startDate = startDate;

		if (_esfJunioresRemoteModel != null) {
			try {
				Class<?> clazz = _esfJunioresRemoteModel.getClass();

				Method method = clazz.getMethod("setStartDate", Date.class);

				method.invoke(_esfJunioresRemoteModel, startDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getEndDate() {
		return _endDate;
	}

	@Override
	public void setEndDate(Date endDate) {
		_endDate = endDate;

		if (_esfJunioresRemoteModel != null) {
			try {
				Class<?> clazz = _esfJunioresRemoteModel.getClass();

				Method method = clazz.getMethod("setEndDate", Date.class);

				method.invoke(_esfJunioresRemoteModel, endDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getESFJunioresRemoteModel() {
		return _esfJunioresRemoteModel;
	}

	public void setESFJunioresRemoteModel(BaseModel<?> esfJunioresRemoteModel) {
		_esfJunioresRemoteModel = esfJunioresRemoteModel;
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

		Class<?> remoteModelClass = _esfJunioresRemoteModel.getClass();

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

		Object returnValue = method.invoke(_esfJunioresRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ESFJunioresLocalServiceUtil.addESFJuniores(this);
		}
		else {
			ESFJunioresLocalServiceUtil.updateESFJuniores(this);
		}
	}

	@Override
	public ESFJuniores toEscapedModel() {
		return (ESFJuniores)ProxyUtil.newProxyInstance(ESFJuniores.class.getClassLoader(),
			new Class[] { ESFJuniores.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ESFJunioresClp clone = new ESFJunioresClp();

		clone.setESFUserId(getESFUserId());
		clone.setStartDate(getStartDate());
		clone.setEndDate(getEndDate());

		return clone;
	}

	@Override
	public int compareTo(ESFJuniores esfJuniores) {
		long primaryKey = esfJuniores.getPrimaryKey();

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

		if (!(obj instanceof ESFJunioresClp)) {
			return false;
		}

		ESFJunioresClp esfJuniores = (ESFJunioresClp)obj;

		long primaryKey = esfJuniores.getPrimaryKey();

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

		sb.append("{ESFUserId=");
		sb.append(getESFUserId());
		sb.append(", startDate=");
		sb.append(getStartDate());
		sb.append(", endDate=");
		sb.append(getEndDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("it.ethica.esf.model.ESFJuniores");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>ESFUserId</column-name><column-value><![CDATA[");
		sb.append(getESFUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>startDate</column-name><column-value><![CDATA[");
		sb.append(getStartDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endDate</column-name><column-value><![CDATA[");
		sb.append(getEndDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _ESFUserId;
	private String _ESFUserUuid;
	private Date _startDate;
	private Date _endDate;
	private BaseModel<?> _esfJunioresRemoteModel;
	private Class<?> _clpSerializerClass = it.ethica.esf.service.ClpSerializer.class;
}