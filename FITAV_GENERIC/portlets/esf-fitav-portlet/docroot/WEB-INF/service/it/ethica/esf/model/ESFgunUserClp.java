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
import it.ethica.esf.service.ESFgunUserLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ethica
 */
public class ESFgunUserClp extends BaseModelImpl<ESFgunUser>
	implements ESFgunUser {
	public ESFgunUserClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ESFgunUser.class;
	}

	@Override
	public String getModelClassName() {
		return ESFgunUser.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _esfGunUserId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEsfGunUserId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _esfGunUserId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfGunUserId", getEsfGunUserId());
		attributes.put("esfGunId", getEsfGunId());
		attributes.put("esfUserId", getEsfUserId());
		attributes.put("code", getCode());
		attributes.put("isFavorite", getIsFavorite());
		attributes.put("type", getType());
		attributes.put("note", getNote());
		attributes.put("esfGunnTypeId", getEsfGunnTypeId());
		attributes.put("esfGunKindId", getEsfGunKindId());
		attributes.put("typeId", getTypeId());
		attributes.put("esfMeasures", getEsfMeasures());
		attributes.put("esfCaliber", getEsfCaliber());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esfGunUserId = (Long)attributes.get("esfGunUserId");

		if (esfGunUserId != null) {
			setEsfGunUserId(esfGunUserId);
		}

		Long esfGunId = (Long)attributes.get("esfGunId");

		if (esfGunId != null) {
			setEsfGunId(esfGunId);
		}

		Long esfUserId = (Long)attributes.get("esfUserId");

		if (esfUserId != null) {
			setEsfUserId(esfUserId);
		}

		String code = (String)attributes.get("code");

		if (code != null) {
			setCode(code);
		}

		Boolean isFavorite = (Boolean)attributes.get("isFavorite");

		if (isFavorite != null) {
			setIsFavorite(isFavorite);
		}

		Integer type = (Integer)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		String note = (String)attributes.get("note");

		if (note != null) {
			setNote(note);
		}

		Long esfGunnTypeId = (Long)attributes.get("esfGunnTypeId");

		if (esfGunnTypeId != null) {
			setEsfGunnTypeId(esfGunnTypeId);
		}

		Long esfGunKindId = (Long)attributes.get("esfGunKindId");

		if (esfGunKindId != null) {
			setEsfGunKindId(esfGunKindId);
		}

		Long typeId = (Long)attributes.get("typeId");

		if (typeId != null) {
			setTypeId(typeId);
		}

		String esfMeasures = (String)attributes.get("esfMeasures");

		if (esfMeasures != null) {
			setEsfMeasures(esfMeasures);
		}

		String esfCaliber = (String)attributes.get("esfCaliber");

		if (esfCaliber != null) {
			setEsfCaliber(esfCaliber);
		}
	}

	@Override
	public long getEsfGunUserId() {
		return _esfGunUserId;
	}

	@Override
	public void setEsfGunUserId(long esfGunUserId) {
		_esfGunUserId = esfGunUserId;

		if (_esFgunUserRemoteModel != null) {
			try {
				Class<?> clazz = _esFgunUserRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfGunUserId", long.class);

				method.invoke(_esFgunUserRemoteModel, esfGunUserId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEsfGunUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getEsfGunUserId(), "uuid",
			_esfGunUserUuid);
	}

	@Override
	public void setEsfGunUserUuid(String esfGunUserUuid) {
		_esfGunUserUuid = esfGunUserUuid;
	}

	@Override
	public long getEsfGunId() {
		return _esfGunId;
	}

	@Override
	public void setEsfGunId(long esfGunId) {
		_esfGunId = esfGunId;

		if (_esFgunUserRemoteModel != null) {
			try {
				Class<?> clazz = _esFgunUserRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfGunId", long.class);

				method.invoke(_esFgunUserRemoteModel, esfGunId);
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

		if (_esFgunUserRemoteModel != null) {
			try {
				Class<?> clazz = _esFgunUserRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfUserId", long.class);

				method.invoke(_esFgunUserRemoteModel, esfUserId);
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
	public String getCode() {
		return _code;
	}

	@Override
	public void setCode(String code) {
		_code = code;

		if (_esFgunUserRemoteModel != null) {
			try {
				Class<?> clazz = _esFgunUserRemoteModel.getClass();

				Method method = clazz.getMethod("setCode", String.class);

				method.invoke(_esFgunUserRemoteModel, code);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getIsFavorite() {
		return _isFavorite;
	}

	@Override
	public boolean isIsFavorite() {
		return _isFavorite;
	}

	@Override
	public void setIsFavorite(boolean isFavorite) {
		_isFavorite = isFavorite;

		if (_esFgunUserRemoteModel != null) {
			try {
				Class<?> clazz = _esFgunUserRemoteModel.getClass();

				Method method = clazz.getMethod("setIsFavorite", boolean.class);

				method.invoke(_esFgunUserRemoteModel, isFavorite);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getType() {
		return _type;
	}

	@Override
	public void setType(int type) {
		_type = type;

		if (_esFgunUserRemoteModel != null) {
			try {
				Class<?> clazz = _esFgunUserRemoteModel.getClass();

				Method method = clazz.getMethod("setType", int.class);

				method.invoke(_esFgunUserRemoteModel, type);
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

		if (_esFgunUserRemoteModel != null) {
			try {
				Class<?> clazz = _esFgunUserRemoteModel.getClass();

				Method method = clazz.getMethod("setNote", String.class);

				method.invoke(_esFgunUserRemoteModel, note);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEsfGunnTypeId() {
		return _esfGunnTypeId;
	}

	@Override
	public void setEsfGunnTypeId(long esfGunnTypeId) {
		_esfGunnTypeId = esfGunnTypeId;

		if (_esFgunUserRemoteModel != null) {
			try {
				Class<?> clazz = _esFgunUserRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfGunnTypeId", long.class);

				method.invoke(_esFgunUserRemoteModel, esfGunnTypeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEsfGunKindId() {
		return _esfGunKindId;
	}

	@Override
	public void setEsfGunKindId(long esfGunKindId) {
		_esfGunKindId = esfGunKindId;

		if (_esFgunUserRemoteModel != null) {
			try {
				Class<?> clazz = _esFgunUserRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfGunKindId", long.class);

				method.invoke(_esFgunUserRemoteModel, esfGunKindId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getTypeId() {
		return _typeId;
	}

	@Override
	public void setTypeId(long typeId) {
		_typeId = typeId;

		if (_esFgunUserRemoteModel != null) {
			try {
				Class<?> clazz = _esFgunUserRemoteModel.getClass();

				Method method = clazz.getMethod("setTypeId", long.class);

				method.invoke(_esFgunUserRemoteModel, typeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEsfMeasures() {
		return _esfMeasures;
	}

	@Override
	public void setEsfMeasures(String esfMeasures) {
		_esfMeasures = esfMeasures;

		if (_esFgunUserRemoteModel != null) {
			try {
				Class<?> clazz = _esFgunUserRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfMeasures", String.class);

				method.invoke(_esFgunUserRemoteModel, esfMeasures);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEsfCaliber() {
		return _esfCaliber;
	}

	@Override
	public void setEsfCaliber(String esfCaliber) {
		_esfCaliber = esfCaliber;

		if (_esFgunUserRemoteModel != null) {
			try {
				Class<?> clazz = _esFgunUserRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfCaliber", String.class);

				method.invoke(_esFgunUserRemoteModel, esfCaliber);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getESFgunUserRemoteModel() {
		return _esFgunUserRemoteModel;
	}

	public void setESFgunUserRemoteModel(BaseModel<?> esFgunUserRemoteModel) {
		_esFgunUserRemoteModel = esFgunUserRemoteModel;
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

		Class<?> remoteModelClass = _esFgunUserRemoteModel.getClass();

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

		Object returnValue = method.invoke(_esFgunUserRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ESFgunUserLocalServiceUtil.addESFgunUser(this);
		}
		else {
			ESFgunUserLocalServiceUtil.updateESFgunUser(this);
		}
	}

	@Override
	public ESFgunUser toEscapedModel() {
		return (ESFgunUser)ProxyUtil.newProxyInstance(ESFgunUser.class.getClassLoader(),
			new Class[] { ESFgunUser.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ESFgunUserClp clone = new ESFgunUserClp();

		clone.setEsfGunUserId(getEsfGunUserId());
		clone.setEsfGunId(getEsfGunId());
		clone.setEsfUserId(getEsfUserId());
		clone.setCode(getCode());
		clone.setIsFavorite(getIsFavorite());
		clone.setType(getType());
		clone.setNote(getNote());
		clone.setEsfGunnTypeId(getEsfGunnTypeId());
		clone.setEsfGunKindId(getEsfGunKindId());
		clone.setTypeId(getTypeId());
		clone.setEsfMeasures(getEsfMeasures());
		clone.setEsfCaliber(getEsfCaliber());

		return clone;
	}

	@Override
	public int compareTo(ESFgunUser esFgunUser) {
		long primaryKey = esFgunUser.getPrimaryKey();

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

		if (!(obj instanceof ESFgunUserClp)) {
			return false;
		}

		ESFgunUserClp esFgunUser = (ESFgunUserClp)obj;

		long primaryKey = esFgunUser.getPrimaryKey();

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
		StringBundler sb = new StringBundler(25);

		sb.append("{esfGunUserId=");
		sb.append(getEsfGunUserId());
		sb.append(", esfGunId=");
		sb.append(getEsfGunId());
		sb.append(", esfUserId=");
		sb.append(getEsfUserId());
		sb.append(", code=");
		sb.append(getCode());
		sb.append(", isFavorite=");
		sb.append(getIsFavorite());
		sb.append(", type=");
		sb.append(getType());
		sb.append(", note=");
		sb.append(getNote());
		sb.append(", esfGunnTypeId=");
		sb.append(getEsfGunnTypeId());
		sb.append(", esfGunKindId=");
		sb.append(getEsfGunKindId());
		sb.append(", typeId=");
		sb.append(getTypeId());
		sb.append(", esfMeasures=");
		sb.append(getEsfMeasures());
		sb.append(", esfCaliber=");
		sb.append(getEsfCaliber());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("it.ethica.esf.model.ESFgunUser");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>esfGunUserId</column-name><column-value><![CDATA[");
		sb.append(getEsfGunUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfGunId</column-name><column-value><![CDATA[");
		sb.append(getEsfGunId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfUserId</column-name><column-value><![CDATA[");
		sb.append(getEsfUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>code</column-name><column-value><![CDATA[");
		sb.append(getCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isFavorite</column-name><column-value><![CDATA[");
		sb.append(getIsFavorite());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>type</column-name><column-value><![CDATA[");
		sb.append(getType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>note</column-name><column-value><![CDATA[");
		sb.append(getNote());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfGunnTypeId</column-name><column-value><![CDATA[");
		sb.append(getEsfGunnTypeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfGunKindId</column-name><column-value><![CDATA[");
		sb.append(getEsfGunKindId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>typeId</column-name><column-value><![CDATA[");
		sb.append(getTypeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfMeasures</column-name><column-value><![CDATA[");
		sb.append(getEsfMeasures());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfCaliber</column-name><column-value><![CDATA[");
		sb.append(getEsfCaliber());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _esfGunUserId;
	private String _esfGunUserUuid;
	private long _esfGunId;
	private long _esfUserId;
	private String _esfUserUuid;
	private String _code;
	private boolean _isFavorite;
	private int _type;
	private String _note;
	private long _esfGunnTypeId;
	private long _esfGunKindId;
	private long _typeId;
	private String _esfMeasures;
	private String _esfCaliber;
	private BaseModel<?> _esFgunUserRemoteModel;
}