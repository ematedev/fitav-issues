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
import com.liferay.portal.util.PortalUtil;

import it.ethica.esf.service.ClpSerializer;
import it.ethica.esf.service.ESFTransitionLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ethica
 */
public class ESFTransitionClp extends BaseModelImpl<ESFTransition>
	implements ESFTransition {
	public ESFTransitionClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ESFTransition.class;
	}

	@Override
	public String getModelClassName() {
		return ESFTransition.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _esfTransitionId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEsfTransitionId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _esfTransitionId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfTransitionId", getEsfTransitionId());
		attributes.put("esfUserId", getEsfUserId());
		attributes.put("esfCategoryId", getEsfCategoryId());
		attributes.put("season", getSeason());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esfTransitionId = (Long)attributes.get("esfTransitionId");

		if (esfTransitionId != null) {
			setEsfTransitionId(esfTransitionId);
		}

		Long esfUserId = (Long)attributes.get("esfUserId");

		if (esfUserId != null) {
			setEsfUserId(esfUserId);
		}

		Long esfCategoryId = (Long)attributes.get("esfCategoryId");

		if (esfCategoryId != null) {
			setEsfCategoryId(esfCategoryId);
		}

		String season = (String)attributes.get("season");

		if (season != null) {
			setSeason(season);
		}
	}

	@Override
	public long getEsfTransitionId() {
		return _esfTransitionId;
	}

	@Override
	public void setEsfTransitionId(long esfTransitionId) {
		_esfTransitionId = esfTransitionId;

		if (_esfTransitionRemoteModel != null) {
			try {
				Class<?> clazz = _esfTransitionRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfTransitionId", long.class);

				method.invoke(_esfTransitionRemoteModel, esfTransitionId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEsfUserId() {
		return _esfUserId;
	}

	@Override
	public void setEsfUserId(long esfUserId) {
		_esfUserId = esfUserId;

		if (_esfTransitionRemoteModel != null) {
			try {
				Class<?> clazz = _esfTransitionRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfUserId", long.class);

				method.invoke(_esfTransitionRemoteModel, esfUserId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEsfUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getEsfUserId(), "uuid", _esfUserUuid);
	}

	@Override
	public void setEsfUserUuid(String esfUserUuid) {
		_esfUserUuid = esfUserUuid;
	}

	@Override
	public long getEsfCategoryId() {
		return _esfCategoryId;
	}

	@Override
	public void setEsfCategoryId(long esfCategoryId) {
		_esfCategoryId = esfCategoryId;

		if (_esfTransitionRemoteModel != null) {
			try {
				Class<?> clazz = _esfTransitionRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfCategoryId", long.class);

				method.invoke(_esfTransitionRemoteModel, esfCategoryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSeason() {
		return _season;
	}

	@Override
	public void setSeason(String season) {
		_season = season;

		if (_esfTransitionRemoteModel != null) {
			try {
				Class<?> clazz = _esfTransitionRemoteModel.getClass();

				Method method = clazz.getMethod("setSeason", String.class);

				method.invoke(_esfTransitionRemoteModel, season);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getESFTransitionRemoteModel() {
		return _esfTransitionRemoteModel;
	}

	public void setESFTransitionRemoteModel(
		BaseModel<?> esfTransitionRemoteModel) {
		_esfTransitionRemoteModel = esfTransitionRemoteModel;
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

		Class<?> remoteModelClass = _esfTransitionRemoteModel.getClass();

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

		Object returnValue = method.invoke(_esfTransitionRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ESFTransitionLocalServiceUtil.addESFTransition(this);
		}
		else {
			ESFTransitionLocalServiceUtil.updateESFTransition(this);
		}
	}

	@Override
	public ESFTransition toEscapedModel() {
		return (ESFTransition)ProxyUtil.newProxyInstance(ESFTransition.class.getClassLoader(),
			new Class[] { ESFTransition.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ESFTransitionClp clone = new ESFTransitionClp();

		clone.setEsfTransitionId(getEsfTransitionId());
		clone.setEsfUserId(getEsfUserId());
		clone.setEsfCategoryId(getEsfCategoryId());
		clone.setSeason(getSeason());

		return clone;
	}

	@Override
	public int compareTo(ESFTransition esfTransition) {
		long primaryKey = esfTransition.getPrimaryKey();

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

		if (!(obj instanceof ESFTransitionClp)) {
			return false;
		}

		ESFTransitionClp esfTransition = (ESFTransitionClp)obj;

		long primaryKey = esfTransition.getPrimaryKey();

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
		StringBundler sb = new StringBundler(9);

		sb.append("{esfTransitionId=");
		sb.append(getEsfTransitionId());
		sb.append(", esfUserId=");
		sb.append(getEsfUserId());
		sb.append(", esfCategoryId=");
		sb.append(getEsfCategoryId());
		sb.append(", season=");
		sb.append(getSeason());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("it.ethica.esf.model.ESFTransition");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>esfTransitionId</column-name><column-value><![CDATA[");
		sb.append(getEsfTransitionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfUserId</column-name><column-value><![CDATA[");
		sb.append(getEsfUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfCategoryId</column-name><column-value><![CDATA[");
		sb.append(getEsfCategoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>season</column-name><column-value><![CDATA[");
		sb.append(getSeason());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _esfTransitionId;
	private long _esfUserId;
	private String _esfUserUuid;
	private long _esfCategoryId;
	private String _season;
	private BaseModel<?> _esfTransitionRemoteModel;
}