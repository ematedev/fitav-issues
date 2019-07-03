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
import it.ethica.esf.service.EsfRadunoShootersLocalServiceUtil;
import it.ethica.esf.service.persistence.EsfRadunoShootersPK;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ethica
 */
public class EsfRadunoShootersClp extends BaseModelImpl<EsfRadunoShooters>
	implements EsfRadunoShooters {
	public EsfRadunoShootersClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return EsfRadunoShooters.class;
	}

	@Override
	public String getModelClassName() {
		return EsfRadunoShooters.class.getName();
	}

	@Override
	public EsfRadunoShootersPK getPrimaryKey() {
		return new EsfRadunoShootersPK(_id_esf_raduno_shooters, _id_esf_raduno,
			_userId);
	}

	@Override
	public void setPrimaryKey(EsfRadunoShootersPK primaryKey) {
		setId_esf_raduno_shooters(primaryKey.id_esf_raduno_shooters);
		setId_esf_raduno(primaryKey.id_esf_raduno);
		setUserId(primaryKey.userId);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new EsfRadunoShootersPK(_id_esf_raduno_shooters, _id_esf_raduno,
			_userId);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((EsfRadunoShootersPK)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id_esf_raduno_shooters", getId_esf_raduno_shooters());
		attributes.put("id_esf_raduno", getId_esf_raduno());
		attributes.put("userId", getUserId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id_esf_raduno_shooters = (Long)attributes.get(
				"id_esf_raduno_shooters");

		if (id_esf_raduno_shooters != null) {
			setId_esf_raduno_shooters(id_esf_raduno_shooters);
		}

		Long id_esf_raduno = (Long)attributes.get("id_esf_raduno");

		if (id_esf_raduno != null) {
			setId_esf_raduno(id_esf_raduno);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}
	}

	@Override
	public long getId_esf_raduno_shooters() {
		return _id_esf_raduno_shooters;
	}

	@Override
	public void setId_esf_raduno_shooters(long id_esf_raduno_shooters) {
		_id_esf_raduno_shooters = id_esf_raduno_shooters;

		if (_esfRadunoShootersRemoteModel != null) {
			try {
				Class<?> clazz = _esfRadunoShootersRemoteModel.getClass();

				Method method = clazz.getMethod("setId_esf_raduno_shooters",
						long.class);

				method.invoke(_esfRadunoShootersRemoteModel,
					id_esf_raduno_shooters);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getId_esf_raduno() {
		return _id_esf_raduno;
	}

	@Override
	public void setId_esf_raduno(long id_esf_raduno) {
		_id_esf_raduno = id_esf_raduno;

		if (_esfRadunoShootersRemoteModel != null) {
			try {
				Class<?> clazz = _esfRadunoShootersRemoteModel.getClass();

				Method method = clazz.getMethod("setId_esf_raduno", long.class);

				method.invoke(_esfRadunoShootersRemoteModel, id_esf_raduno);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_esfRadunoShootersRemoteModel != null) {
			try {
				Class<?> clazz = _esfRadunoShootersRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_esfRadunoShootersRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public BaseModel<?> getEsfRadunoShootersRemoteModel() {
		return _esfRadunoShootersRemoteModel;
	}

	public void setEsfRadunoShootersRemoteModel(
		BaseModel<?> esfRadunoShootersRemoteModel) {
		_esfRadunoShootersRemoteModel = esfRadunoShootersRemoteModel;
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

		Class<?> remoteModelClass = _esfRadunoShootersRemoteModel.getClass();

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

		Object returnValue = method.invoke(_esfRadunoShootersRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			EsfRadunoShootersLocalServiceUtil.addEsfRadunoShooters(this);
		}
		else {
			EsfRadunoShootersLocalServiceUtil.updateEsfRadunoShooters(this);
		}
	}

	@Override
	public EsfRadunoShooters toEscapedModel() {
		return (EsfRadunoShooters)ProxyUtil.newProxyInstance(EsfRadunoShooters.class.getClassLoader(),
			new Class[] { EsfRadunoShooters.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		EsfRadunoShootersClp clone = new EsfRadunoShootersClp();

		clone.setId_esf_raduno_shooters(getId_esf_raduno_shooters());
		clone.setId_esf_raduno(getId_esf_raduno());
		clone.setUserId(getUserId());

		return clone;
	}

	@Override
	public int compareTo(EsfRadunoShooters esfRadunoShooters) {
		EsfRadunoShootersPK primaryKey = esfRadunoShooters.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EsfRadunoShootersClp)) {
			return false;
		}

		EsfRadunoShootersClp esfRadunoShooters = (EsfRadunoShootersClp)obj;

		EsfRadunoShootersPK primaryKey = esfRadunoShooters.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
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
		return getPrimaryKey().hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{id_esf_raduno_shooters=");
		sb.append(getId_esf_raduno_shooters());
		sb.append(", id_esf_raduno=");
		sb.append(getId_esf_raduno());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("it.ethica.esf.model.EsfRadunoShooters");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id_esf_raduno_shooters</column-name><column-value><![CDATA[");
		sb.append(getId_esf_raduno_shooters());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>id_esf_raduno</column-name><column-value><![CDATA[");
		sb.append(getId_esf_raduno());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id_esf_raduno_shooters;
	private long _id_esf_raduno;
	private long _userId;
	private String _userUuid;
	private BaseModel<?> _esfRadunoShootersRemoteModel;
	private Class<?> _clpSerializerClass = it.ethica.esf.service.ClpSerializer.class;
}