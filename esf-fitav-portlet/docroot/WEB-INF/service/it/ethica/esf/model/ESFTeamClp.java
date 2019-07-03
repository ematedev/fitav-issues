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
import it.ethica.esf.service.ESFTeamLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ethica
 */
public class ESFTeamClp extends BaseModelImpl<ESFTeam> implements ESFTeam {
	public ESFTeamClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ESFTeam.class;
	}

	@Override
	public String getModelClassName() {
		return ESFTeam.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _esfTeamId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEsfTeamId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _esfTeamId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfTeamId", getEsfTeamId());
		attributes.put("esfTournamentId", getEsfTournamentId());
		attributes.put("name", getName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esfTeamId = (Long)attributes.get("esfTeamId");

		if (esfTeamId != null) {
			setEsfTeamId(esfTeamId);
		}

		Long esfTournamentId = (Long)attributes.get("esfTournamentId");

		if (esfTournamentId != null) {
			setEsfTournamentId(esfTournamentId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}
	}

	@Override
	public long getEsfTeamId() {
		return _esfTeamId;
	}

	@Override
	public void setEsfTeamId(long esfTeamId) {
		_esfTeamId = esfTeamId;

		if (_esfTeamRemoteModel != null) {
			try {
				Class<?> clazz = _esfTeamRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfTeamId", long.class);

				method.invoke(_esfTeamRemoteModel, esfTeamId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEsfTournamentId() {
		return _esfTournamentId;
	}

	@Override
	public void setEsfTournamentId(long esfTournamentId) {
		_esfTournamentId = esfTournamentId;

		if (_esfTeamRemoteModel != null) {
			try {
				Class<?> clazz = _esfTeamRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfTournamentId", long.class);

				method.invoke(_esfTeamRemoteModel, esfTournamentId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getName() {
		return _name;
	}

	@Override
	public void setName(String name) {
		_name = name;

		if (_esfTeamRemoteModel != null) {
			try {
				Class<?> clazz = _esfTeamRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_esfTeamRemoteModel, name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getESFTeamRemoteModel() {
		return _esfTeamRemoteModel;
	}

	public void setESFTeamRemoteModel(BaseModel<?> esfTeamRemoteModel) {
		_esfTeamRemoteModel = esfTeamRemoteModel;
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

		Class<?> remoteModelClass = _esfTeamRemoteModel.getClass();

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

		Object returnValue = method.invoke(_esfTeamRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ESFTeamLocalServiceUtil.addESFTeam(this);
		}
		else {
			ESFTeamLocalServiceUtil.updateESFTeam(this);
		}
	}

	@Override
	public ESFTeam toEscapedModel() {
		return (ESFTeam)ProxyUtil.newProxyInstance(ESFTeam.class.getClassLoader(),
			new Class[] { ESFTeam.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ESFTeamClp clone = new ESFTeamClp();

		clone.setEsfTeamId(getEsfTeamId());
		clone.setEsfTournamentId(getEsfTournamentId());
		clone.setName(getName());

		return clone;
	}

	@Override
	public int compareTo(ESFTeam esfTeam) {
		long primaryKey = esfTeam.getPrimaryKey();

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

		if (!(obj instanceof ESFTeamClp)) {
			return false;
		}

		ESFTeamClp esfTeam = (ESFTeamClp)obj;

		long primaryKey = esfTeam.getPrimaryKey();

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

		sb.append("{esfTeamId=");
		sb.append(getEsfTeamId());
		sb.append(", esfTournamentId=");
		sb.append(getEsfTournamentId());
		sb.append(", name=");
		sb.append(getName());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("it.ethica.esf.model.ESFTeam");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>esfTeamId</column-name><column-value><![CDATA[");
		sb.append(getEsfTeamId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfTournamentId</column-name><column-value><![CDATA[");
		sb.append(getEsfTournamentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _esfTeamId;
	private long _esfTournamentId;
	private String _name;
	private BaseModel<?> _esfTeamRemoteModel;
	private Class<?> _clpSerializerClass = it.ethica.esf.service.ClpSerializer.class;
}