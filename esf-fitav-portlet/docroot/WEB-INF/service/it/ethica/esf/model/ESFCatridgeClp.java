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
import it.ethica.esf.service.ESFCatridgeLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ethica
 */
public class ESFCatridgeClp extends BaseModelImpl<ESFCatridge>
	implements ESFCatridge {
	public ESFCatridgeClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ESFCatridge.class;
	}

	@Override
	public String getModelClassName() {
		return ESFCatridge.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _esfCatridgeId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEsfCatridgeId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _esfCatridgeId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("esfCatridgeId", getEsfCatridgeId());
		attributes.put("esfUserId", getEsfUserId());
		attributes.put("esfGunTypeId", getEsfGunTypeId());
		attributes.put("catridgeModel", getCatridgeModel());
		attributes.put("catridgeCaliber", getCatridgeCaliber());
		attributes.put("note", getNote());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long esfCatridgeId = (Long)attributes.get("esfCatridgeId");

		if (esfCatridgeId != null) {
			setEsfCatridgeId(esfCatridgeId);
		}

		Long esfUserId = (Long)attributes.get("esfUserId");

		if (esfUserId != null) {
			setEsfUserId(esfUserId);
		}

		Long esfGunTypeId = (Long)attributes.get("esfGunTypeId");

		if (esfGunTypeId != null) {
			setEsfGunTypeId(esfGunTypeId);
		}

		String catridgeModel = (String)attributes.get("catridgeModel");

		if (catridgeModel != null) {
			setCatridgeModel(catridgeModel);
		}

		Long catridgeCaliber = (Long)attributes.get("catridgeCaliber");

		if (catridgeCaliber != null) {
			setCatridgeCaliber(catridgeCaliber);
		}

		String note = (String)attributes.get("note");

		if (note != null) {
			setNote(note);
		}
	}

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_esfCatridgeRemoteModel != null) {
			try {
				Class<?> clazz = _esfCatridgeRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_esfCatridgeRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEsfCatridgeId() {
		return _esfCatridgeId;
	}

	@Override
	public void setEsfCatridgeId(long esfCatridgeId) {
		_esfCatridgeId = esfCatridgeId;

		if (_esfCatridgeRemoteModel != null) {
			try {
				Class<?> clazz = _esfCatridgeRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfCatridgeId", long.class);

				method.invoke(_esfCatridgeRemoteModel, esfCatridgeId);
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

		if (_esfCatridgeRemoteModel != null) {
			try {
				Class<?> clazz = _esfCatridgeRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfUserId", long.class);

				method.invoke(_esfCatridgeRemoteModel, esfUserId);
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
	public long getEsfGunTypeId() {
		return _esfGunTypeId;
	}

	@Override
	public void setEsfGunTypeId(long esfGunTypeId) {
		_esfGunTypeId = esfGunTypeId;

		if (_esfCatridgeRemoteModel != null) {
			try {
				Class<?> clazz = _esfCatridgeRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfGunTypeId", long.class);

				method.invoke(_esfCatridgeRemoteModel, esfGunTypeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCatridgeModel() {
		return _catridgeModel;
	}

	@Override
	public void setCatridgeModel(String catridgeModel) {
		_catridgeModel = catridgeModel;

		if (_esfCatridgeRemoteModel != null) {
			try {
				Class<?> clazz = _esfCatridgeRemoteModel.getClass();

				Method method = clazz.getMethod("setCatridgeModel", String.class);

				method.invoke(_esfCatridgeRemoteModel, catridgeModel);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCatridgeCaliber() {
		return _catridgeCaliber;
	}

	@Override
	public void setCatridgeCaliber(long catridgeCaliber) {
		_catridgeCaliber = catridgeCaliber;

		if (_esfCatridgeRemoteModel != null) {
			try {
				Class<?> clazz = _esfCatridgeRemoteModel.getClass();

				Method method = clazz.getMethod("setCatridgeCaliber", long.class);

				method.invoke(_esfCatridgeRemoteModel, catridgeCaliber);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getNote() {
		return _note;
	}

	@Override
	public void setNote(String note) {
		_note = note;

		if (_esfCatridgeRemoteModel != null) {
			try {
				Class<?> clazz = _esfCatridgeRemoteModel.getClass();

				Method method = clazz.getMethod("setNote", String.class);

				method.invoke(_esfCatridgeRemoteModel, note);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getESFCatridgeRemoteModel() {
		return _esfCatridgeRemoteModel;
	}

	public void setESFCatridgeRemoteModel(BaseModel<?> esfCatridgeRemoteModel) {
		_esfCatridgeRemoteModel = esfCatridgeRemoteModel;
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

		Class<?> remoteModelClass = _esfCatridgeRemoteModel.getClass();

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

		Object returnValue = method.invoke(_esfCatridgeRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ESFCatridgeLocalServiceUtil.addESFCatridge(this);
		}
		else {
			ESFCatridgeLocalServiceUtil.updateESFCatridge(this);
		}
	}

	@Override
	public ESFCatridge toEscapedModel() {
		return (ESFCatridge)ProxyUtil.newProxyInstance(ESFCatridge.class.getClassLoader(),
			new Class[] { ESFCatridge.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ESFCatridgeClp clone = new ESFCatridgeClp();

		clone.setUuid(getUuid());
		clone.setEsfCatridgeId(getEsfCatridgeId());
		clone.setEsfUserId(getEsfUserId());
		clone.setEsfGunTypeId(getEsfGunTypeId());
		clone.setCatridgeModel(getCatridgeModel());
		clone.setCatridgeCaliber(getCatridgeCaliber());
		clone.setNote(getNote());

		return clone;
	}

	@Override
	public int compareTo(ESFCatridge esfCatridge) {
		int value = 0;

		if (getEsfGunTypeId() < esfCatridge.getEsfGunTypeId()) {
			value = -1;
		}
		else if (getEsfGunTypeId() > esfCatridge.getEsfGunTypeId()) {
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

		if (!(obj instanceof ESFCatridgeClp)) {
			return false;
		}

		ESFCatridgeClp esfCatridge = (ESFCatridgeClp)obj;

		long primaryKey = esfCatridge.getPrimaryKey();

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
		StringBundler sb = new StringBundler(15);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", esfCatridgeId=");
		sb.append(getEsfCatridgeId());
		sb.append(", esfUserId=");
		sb.append(getEsfUserId());
		sb.append(", esfGunTypeId=");
		sb.append(getEsfGunTypeId());
		sb.append(", catridgeModel=");
		sb.append(getCatridgeModel());
		sb.append(", catridgeCaliber=");
		sb.append(getCatridgeCaliber());
		sb.append(", note=");
		sb.append(getNote());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append("it.ethica.esf.model.ESFCatridge");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfCatridgeId</column-name><column-value><![CDATA[");
		sb.append(getEsfCatridgeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfUserId</column-name><column-value><![CDATA[");
		sb.append(getEsfUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfGunTypeId</column-name><column-value><![CDATA[");
		sb.append(getEsfGunTypeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>catridgeModel</column-name><column-value><![CDATA[");
		sb.append(getCatridgeModel());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>catridgeCaliber</column-name><column-value><![CDATA[");
		sb.append(getCatridgeCaliber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>note</column-name><column-value><![CDATA[");
		sb.append(getNote());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _esfCatridgeId;
	private long _esfUserId;
	private String _esfUserUuid;
	private long _esfGunTypeId;
	private String _catridgeModel;
	private long _catridgeCaliber;
	private String _note;
	private BaseModel<?> _esfCatridgeRemoteModel;
}