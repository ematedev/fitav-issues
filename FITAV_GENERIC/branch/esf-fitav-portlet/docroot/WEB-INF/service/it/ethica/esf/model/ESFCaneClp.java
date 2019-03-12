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
import it.ethica.esf.service.ESFCaneLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ethica
 */
public class ESFCaneClp extends BaseModelImpl<ESFCane> implements ESFCane {
	public ESFCaneClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ESFCane.class;
	}

	@Override
	public String getModelClassName() {
		return ESFCane.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _esfCaneId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEsfCaneId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _esfCaneId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("esfCaneId", getEsfCaneId());
		attributes.put("esfUserId", getEsfUserId());
		attributes.put("code", getCode());
		attributes.put("esfGunKindId", getEsfGunKindId());
		attributes.put("esfOrganizationId", getEsfOrganizationId());
		attributes.put("caneCaliber", getCaneCaliber());
		attributes.put("isFavoriteGun", getIsFavoriteGun());
		attributes.put("typeId", getTypeId());
		attributes.put("measures", getMeasures());
		attributes.put("shooterId", getShooterId());
		attributes.put("esfGunTypeId", getEsfGunTypeId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long esfCaneId = (Long)attributes.get("esfCaneId");

		if (esfCaneId != null) {
			setEsfCaneId(esfCaneId);
		}

		Long esfUserId = (Long)attributes.get("esfUserId");

		if (esfUserId != null) {
			setEsfUserId(esfUserId);
		}

		String code = (String)attributes.get("code");

		if (code != null) {
			setCode(code);
		}

		Long esfGunKindId = (Long)attributes.get("esfGunKindId");

		if (esfGunKindId != null) {
			setEsfGunKindId(esfGunKindId);
		}

		Long esfOrganizationId = (Long)attributes.get("esfOrganizationId");

		if (esfOrganizationId != null) {
			setEsfOrganizationId(esfOrganizationId);
		}

		Long caneCaliber = (Long)attributes.get("caneCaliber");

		if (caneCaliber != null) {
			setCaneCaliber(caneCaliber);
		}

		Boolean isFavoriteGun = (Boolean)attributes.get("isFavoriteGun");

		if (isFavoriteGun != null) {
			setIsFavoriteGun(isFavoriteGun);
		}

		Integer typeId = (Integer)attributes.get("typeId");

		if (typeId != null) {
			setTypeId(typeId);
		}

		String measures = (String)attributes.get("measures");

		if (measures != null) {
			setMeasures(measures);
		}

		Long shooterId = (Long)attributes.get("shooterId");

		if (shooterId != null) {
			setShooterId(shooterId);
		}

		Long esfGunTypeId = (Long)attributes.get("esfGunTypeId");

		if (esfGunTypeId != null) {
			setEsfGunTypeId(esfGunTypeId);
		}
	}

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_esfCaneRemoteModel != null) {
			try {
				Class<?> clazz = _esfCaneRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_esfCaneRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEsfCaneId() {
		return _esfCaneId;
	}

	@Override
	public void setEsfCaneId(long esfCaneId) {
		_esfCaneId = esfCaneId;

		if (_esfCaneRemoteModel != null) {
			try {
				Class<?> clazz = _esfCaneRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfCaneId", long.class);

				method.invoke(_esfCaneRemoteModel, esfCaneId);
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

		if (_esfCaneRemoteModel != null) {
			try {
				Class<?> clazz = _esfCaneRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfUserId", long.class);

				method.invoke(_esfCaneRemoteModel, esfUserId);
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

		if (_esfCaneRemoteModel != null) {
			try {
				Class<?> clazz = _esfCaneRemoteModel.getClass();

				Method method = clazz.getMethod("setCode", String.class);

				method.invoke(_esfCaneRemoteModel, code);
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

		if (_esfCaneRemoteModel != null) {
			try {
				Class<?> clazz = _esfCaneRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfGunKindId", long.class);

				method.invoke(_esfCaneRemoteModel, esfGunKindId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEsfOrganizationId() {
		return _esfOrganizationId;
	}

	@Override
	public void setEsfOrganizationId(long esfOrganizationId) {
		_esfOrganizationId = esfOrganizationId;

		if (_esfCaneRemoteModel != null) {
			try {
				Class<?> clazz = _esfCaneRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfOrganizationId",
						long.class);

				method.invoke(_esfCaneRemoteModel, esfOrganizationId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCaneCaliber() {
		return _caneCaliber;
	}

	@Override
	public void setCaneCaliber(long caneCaliber) {
		_caneCaliber = caneCaliber;

		if (_esfCaneRemoteModel != null) {
			try {
				Class<?> clazz = _esfCaneRemoteModel.getClass();

				Method method = clazz.getMethod("setCaneCaliber", long.class);

				method.invoke(_esfCaneRemoteModel, caneCaliber);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getIsFavoriteGun() {
		return _isFavoriteGun;
	}

	@Override
	public boolean isIsFavoriteGun() {
		return _isFavoriteGun;
	}

	@Override
	public void setIsFavoriteGun(boolean isFavoriteGun) {
		_isFavoriteGun = isFavoriteGun;

		if (_esfCaneRemoteModel != null) {
			try {
				Class<?> clazz = _esfCaneRemoteModel.getClass();

				Method method = clazz.getMethod("setIsFavoriteGun",
						boolean.class);

				method.invoke(_esfCaneRemoteModel, isFavoriteGun);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getTypeId() {
		return _typeId;
	}

	@Override
	public void setTypeId(int typeId) {
		_typeId = typeId;

		if (_esfCaneRemoteModel != null) {
			try {
				Class<?> clazz = _esfCaneRemoteModel.getClass();

				Method method = clazz.getMethod("setTypeId", int.class);

				method.invoke(_esfCaneRemoteModel, typeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMeasures() {
		return _measures;
	}

	@Override
	public void setMeasures(String measures) {
		_measures = measures;

		if (_esfCaneRemoteModel != null) {
			try {
				Class<?> clazz = _esfCaneRemoteModel.getClass();

				Method method = clazz.getMethod("setMeasures", String.class);

				method.invoke(_esfCaneRemoteModel, measures);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getShooterId() {
		return _shooterId;
	}

	@Override
	public void setShooterId(long shooterId) {
		_shooterId = shooterId;

		if (_esfCaneRemoteModel != null) {
			try {
				Class<?> clazz = _esfCaneRemoteModel.getClass();

				Method method = clazz.getMethod("setShooterId", long.class);

				method.invoke(_esfCaneRemoteModel, shooterId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEsfGunTypeId() {
		return _esfGunTypeId;
	}

	@Override
	public void setEsfGunTypeId(long esfGunTypeId) {
		_esfGunTypeId = esfGunTypeId;

		if (_esfCaneRemoteModel != null) {
			try {
				Class<?> clazz = _esfCaneRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfGunTypeId", long.class);

				method.invoke(_esfCaneRemoteModel, esfGunTypeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getESFCaneRemoteModel() {
		return _esfCaneRemoteModel;
	}

	public void setESFCaneRemoteModel(BaseModel<?> esfCaneRemoteModel) {
		_esfCaneRemoteModel = esfCaneRemoteModel;
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

		Class<?> remoteModelClass = _esfCaneRemoteModel.getClass();

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

		Object returnValue = method.invoke(_esfCaneRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ESFCaneLocalServiceUtil.addESFCane(this);
		}
		else {
			ESFCaneLocalServiceUtil.updateESFCane(this);
		}
	}

	@Override
	public ESFCane toEscapedModel() {
		return (ESFCane)ProxyUtil.newProxyInstance(ESFCane.class.getClassLoader(),
			new Class[] { ESFCane.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ESFCaneClp clone = new ESFCaneClp();

		clone.setUuid(getUuid());
		clone.setEsfCaneId(getEsfCaneId());
		clone.setEsfUserId(getEsfUserId());
		clone.setCode(getCode());
		clone.setEsfGunKindId(getEsfGunKindId());
		clone.setEsfOrganizationId(getEsfOrganizationId());
		clone.setCaneCaliber(getCaneCaliber());
		clone.setIsFavoriteGun(getIsFavoriteGun());
		clone.setTypeId(getTypeId());
		clone.setMeasures(getMeasures());
		clone.setShooterId(getShooterId());
		clone.setEsfGunTypeId(getEsfGunTypeId());

		return clone;
	}

	@Override
	public int compareTo(ESFCane esfCane) {
		int value = 0;

		value = getCode().compareTo(esfCane.getCode());

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

		if (!(obj instanceof ESFCaneClp)) {
			return false;
		}

		ESFCaneClp esfCane = (ESFCaneClp)obj;

		long primaryKey = esfCane.getPrimaryKey();

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
		StringBundler sb = new StringBundler(25);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", esfCaneId=");
		sb.append(getEsfCaneId());
		sb.append(", esfUserId=");
		sb.append(getEsfUserId());
		sb.append(", code=");
		sb.append(getCode());
		sb.append(", esfGunKindId=");
		sb.append(getEsfGunKindId());
		sb.append(", esfOrganizationId=");
		sb.append(getEsfOrganizationId());
		sb.append(", caneCaliber=");
		sb.append(getCaneCaliber());
		sb.append(", isFavoriteGun=");
		sb.append(getIsFavoriteGun());
		sb.append(", typeId=");
		sb.append(getTypeId());
		sb.append(", measures=");
		sb.append(getMeasures());
		sb.append(", shooterId=");
		sb.append(getShooterId());
		sb.append(", esfGunTypeId=");
		sb.append(getEsfGunTypeId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("it.ethica.esf.model.ESFCane");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfCaneId</column-name><column-value><![CDATA[");
		sb.append(getEsfCaneId());
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
			"<column><column-name>esfGunKindId</column-name><column-value><![CDATA[");
		sb.append(getEsfGunKindId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfOrganizationId</column-name><column-value><![CDATA[");
		sb.append(getEsfOrganizationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>caneCaliber</column-name><column-value><![CDATA[");
		sb.append(getCaneCaliber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isFavoriteGun</column-name><column-value><![CDATA[");
		sb.append(getIsFavoriteGun());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>typeId</column-name><column-value><![CDATA[");
		sb.append(getTypeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>measures</column-name><column-value><![CDATA[");
		sb.append(getMeasures());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>shooterId</column-name><column-value><![CDATA[");
		sb.append(getShooterId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfGunTypeId</column-name><column-value><![CDATA[");
		sb.append(getEsfGunTypeId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _esfCaneId;
	private long _esfUserId;
	private String _esfUserUuid;
	private String _code;
	private long _esfGunKindId;
	private long _esfOrganizationId;
	private long _caneCaliber;
	private boolean _isFavoriteGun;
	private int _typeId;
	private String _measures;
	private long _shooterId;
	private long _esfGunTypeId;
	private BaseModel<?> _esfCaneRemoteModel;
	private Class<?> _clpSerializerClass = it.ethica.esf.service.ClpSerializer.class;
}