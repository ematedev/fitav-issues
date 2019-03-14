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
import it.ethica.esf.service.ESFUserESFUserRoleLocalServiceUtil;
import it.ethica.esf.service.persistence.ESFUserESFUserRolePK;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ethica
 */
public class ESFUserESFUserRoleClp extends BaseModelImpl<ESFUserESFUserRole>
	implements ESFUserESFUserRole {
	public ESFUserESFUserRoleClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ESFUserESFUserRole.class;
	}

	@Override
	public String getModelClassName() {
		return ESFUserESFUserRole.class.getName();
	}

	@Override
	public ESFUserESFUserRolePK getPrimaryKey() {
		return new ESFUserESFUserRolePK(_esfUserRoleId, _esfUserId,
			_esfOrganizationId, _startDate);
	}

	@Override
	public void setPrimaryKey(ESFUserESFUserRolePK primaryKey) {
		setEsfUserRoleId(primaryKey.esfUserRoleId);
		setEsfUserId(primaryKey.esfUserId);
		setEsfOrganizationId(primaryKey.esfOrganizationId);
		setStartDate(primaryKey.startDate);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new ESFUserESFUserRolePK(_esfUserRoleId, _esfUserId,
			_esfOrganizationId, _startDate);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((ESFUserESFUserRolePK)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfUserRoleId", getEsfUserRoleId());
		attributes.put("esfUserId", getEsfUserId());
		attributes.put("esfOrganizationId", getEsfOrganizationId());
		attributes.put("startDate", getStartDate());
		attributes.put("endDate", getEndDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esfUserRoleId = (Long)attributes.get("esfUserRoleId");

		if (esfUserRoleId != null) {
			setEsfUserRoleId(esfUserRoleId);
		}

		Long esfUserId = (Long)attributes.get("esfUserId");

		if (esfUserId != null) {
			setEsfUserId(esfUserId);
		}

		Long esfOrganizationId = (Long)attributes.get("esfOrganizationId");

		if (esfOrganizationId != null) {
			setEsfOrganizationId(esfOrganizationId);
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
	public long getEsfUserRoleId() {
		return _esfUserRoleId;
	}

	@Override
	public void setEsfUserRoleId(long esfUserRoleId) {
		_esfUserRoleId = esfUserRoleId;

		if (_esfUserESFUserRoleRemoteModel != null) {
			try {
				Class<?> clazz = _esfUserESFUserRoleRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfUserRoleId", long.class);

				method.invoke(_esfUserESFUserRoleRemoteModel, esfUserRoleId);
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

		if (_esfUserESFUserRoleRemoteModel != null) {
			try {
				Class<?> clazz = _esfUserESFUserRoleRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfUserId", long.class);

				method.invoke(_esfUserESFUserRoleRemoteModel, esfUserId);
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
	public long getEsfOrganizationId() {
		return _esfOrganizationId;
	}

	@Override
	public void setEsfOrganizationId(long esfOrganizationId) {
		_esfOrganizationId = esfOrganizationId;

		if (_esfUserESFUserRoleRemoteModel != null) {
			try {
				Class<?> clazz = _esfUserESFUserRoleRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfOrganizationId",
						long.class);

				method.invoke(_esfUserESFUserRoleRemoteModel, esfOrganizationId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getStartDate() {
		return _startDate;
	}

	@Override
	public void setStartDate(Date startDate) {
		_startDate = startDate;

		if (_esfUserESFUserRoleRemoteModel != null) {
			try {
				Class<?> clazz = _esfUserESFUserRoleRemoteModel.getClass();

				Method method = clazz.getMethod("setStartDate", Date.class);

				method.invoke(_esfUserESFUserRoleRemoteModel, startDate);
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

		if (_esfUserESFUserRoleRemoteModel != null) {
			try {
				Class<?> clazz = _esfUserESFUserRoleRemoteModel.getClass();

				Method method = clazz.getMethod("setEndDate", Date.class);

				method.invoke(_esfUserESFUserRoleRemoteModel, endDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getESFUserESFUserRoleRemoteModel() {
		return _esfUserESFUserRoleRemoteModel;
	}

	public void setESFUserESFUserRoleRemoteModel(
		BaseModel<?> esfUserESFUserRoleRemoteModel) {
		_esfUserESFUserRoleRemoteModel = esfUserESFUserRoleRemoteModel;
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

		Class<?> remoteModelClass = _esfUserESFUserRoleRemoteModel.getClass();

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

		Object returnValue = method.invoke(_esfUserESFUserRoleRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ESFUserESFUserRoleLocalServiceUtil.addESFUserESFUserRole(this);
		}
		else {
			ESFUserESFUserRoleLocalServiceUtil.updateESFUserESFUserRole(this);
		}
	}

	@Override
	public ESFUserESFUserRole toEscapedModel() {
		return (ESFUserESFUserRole)ProxyUtil.newProxyInstance(ESFUserESFUserRole.class.getClassLoader(),
			new Class[] { ESFUserESFUserRole.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ESFUserESFUserRoleClp clone = new ESFUserESFUserRoleClp();

		clone.setEsfUserRoleId(getEsfUserRoleId());
		clone.setEsfUserId(getEsfUserId());
		clone.setEsfOrganizationId(getEsfOrganizationId());
		clone.setStartDate(getStartDate());
		clone.setEndDate(getEndDate());

		return clone;
	}

	@Override
	public int compareTo(ESFUserESFUserRole esfUserESFUserRole) {
		ESFUserESFUserRolePK primaryKey = esfUserESFUserRole.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFUserESFUserRoleClp)) {
			return false;
		}

		ESFUserESFUserRoleClp esfUserESFUserRole = (ESFUserESFUserRoleClp)obj;

		ESFUserESFUserRolePK primaryKey = esfUserESFUserRole.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{esfUserRoleId=");
		sb.append(getEsfUserRoleId());
		sb.append(", esfUserId=");
		sb.append(getEsfUserId());
		sb.append(", esfOrganizationId=");
		sb.append(getEsfOrganizationId());
		sb.append(", startDate=");
		sb.append(getStartDate());
		sb.append(", endDate=");
		sb.append(getEndDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("it.ethica.esf.model.ESFUserESFUserRole");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>esfUserRoleId</column-name><column-value><![CDATA[");
		sb.append(getEsfUserRoleId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfUserId</column-name><column-value><![CDATA[");
		sb.append(getEsfUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfOrganizationId</column-name><column-value><![CDATA[");
		sb.append(getEsfOrganizationId());
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

	private long _esfUserRoleId;
	private long _esfUserId;
	private String _esfUserUuid;
	private long _esfOrganizationId;
	private Date _startDate;
	private Date _endDate;
	private BaseModel<?> _esfUserESFUserRoleRemoteModel;
}