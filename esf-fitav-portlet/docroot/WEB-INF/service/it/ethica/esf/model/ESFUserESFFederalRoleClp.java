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
import it.ethica.esf.service.ESFUserESFFederalRoleLocalServiceUtil;
import it.ethica.esf.service.persistence.ESFUserESFFederalRolePK;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ethica
 */
public class ESFUserESFFederalRoleClp extends BaseModelImpl<ESFUserESFFederalRole>
	implements ESFUserESFFederalRole {
	public ESFUserESFFederalRoleClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ESFUserESFFederalRole.class;
	}

	@Override
	public String getModelClassName() {
		return ESFUserESFFederalRole.class.getName();
	}

	@Override
	public ESFUserESFFederalRolePK getPrimaryKey() {
		return new ESFUserESFFederalRolePK(_esfUserId, _esfFederalRoleId,
			_startDate);
	}

	@Override
	public void setPrimaryKey(ESFUserESFFederalRolePK primaryKey) {
		setEsfUserId(primaryKey.esfUserId);
		setEsfFederalRoleId(primaryKey.esfFederalRoleId);
		setStartDate(primaryKey.startDate);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new ESFUserESFFederalRolePK(_esfUserId, _esfFederalRoleId,
			_startDate);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((ESFUserESFFederalRolePK)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfUserId", getEsfUserId());
		attributes.put("esfFederalRoleId", getEsfFederalRoleId());
		attributes.put("startDate", getStartDate());
		attributes.put("endDate", getEndDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("active", getActive());
		attributes.put("esfSpecificId", getEsfSpecificId());
		attributes.put("regionId", getRegionId());
		attributes.put("provinceId", getProvinceId());
		attributes.put("notes", getNotes());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esfUserId = (Long)attributes.get("esfUserId");

		if (esfUserId != null) {
			setEsfUserId(esfUserId);
		}

		Long esfFederalRoleId = (Long)attributes.get("esfFederalRoleId");

		if (esfFederalRoleId != null) {
			setEsfFederalRoleId(esfFederalRoleId);
		}

		Long startDate = (Long)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Boolean active = (Boolean)attributes.get("active");

		if (active != null) {
			setActive(active);
		}

		Long esfSpecificId = (Long)attributes.get("esfSpecificId");

		if (esfSpecificId != null) {
			setEsfSpecificId(esfSpecificId);
		}

		String regionId = (String)attributes.get("regionId");

		if (regionId != null) {
			setRegionId(regionId);
		}

		String provinceId = (String)attributes.get("provinceId");

		if (provinceId != null) {
			setProvinceId(provinceId);
		}

		String notes = (String)attributes.get("notes");

		if (notes != null) {
			setNotes(notes);
		}
	}

	@Override
	public long getEsfUserId() {
		return _esfUserId;
	}

	@Override
	public void setEsfUserId(long esfUserId) {
		_esfUserId = esfUserId;

		if (_esfUserESFFederalRoleRemoteModel != null) {
			try {
				Class<?> clazz = _esfUserESFFederalRoleRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfUserId", long.class);

				method.invoke(_esfUserESFFederalRoleRemoteModel, esfUserId);
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
	public long getEsfFederalRoleId() {
		return _esfFederalRoleId;
	}

	@Override
	public void setEsfFederalRoleId(long esfFederalRoleId) {
		_esfFederalRoleId = esfFederalRoleId;

		if (_esfUserESFFederalRoleRemoteModel != null) {
			try {
				Class<?> clazz = _esfUserESFFederalRoleRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfFederalRoleId",
						long.class);

				method.invoke(_esfUserESFFederalRoleRemoteModel,
					esfFederalRoleId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getStartDate() {
		return _startDate;
	}

	@Override
	public void setStartDate(long startDate) {
		_startDate = startDate;

		if (_esfUserESFFederalRoleRemoteModel != null) {
			try {
				Class<?> clazz = _esfUserESFFederalRoleRemoteModel.getClass();

				Method method = clazz.getMethod("setStartDate", long.class);

				method.invoke(_esfUserESFFederalRoleRemoteModel, startDate);
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

		if (_esfUserESFFederalRoleRemoteModel != null) {
			try {
				Class<?> clazz = _esfUserESFFederalRoleRemoteModel.getClass();

				Method method = clazz.getMethod("setEndDate", Date.class);

				method.invoke(_esfUserESFFederalRoleRemoteModel, endDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_esfUserESFFederalRoleRemoteModel != null) {
			try {
				Class<?> clazz = _esfUserESFFederalRoleRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_esfUserESFFederalRoleRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getActive() {
		return _active;
	}

	@Override
	public boolean isActive() {
		return _active;
	}

	@Override
	public void setActive(boolean active) {
		_active = active;

		if (_esfUserESFFederalRoleRemoteModel != null) {
			try {
				Class<?> clazz = _esfUserESFFederalRoleRemoteModel.getClass();

				Method method = clazz.getMethod("setActive", boolean.class);

				method.invoke(_esfUserESFFederalRoleRemoteModel, active);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEsfSpecificId() {
		return _esfSpecificId;
	}

	@Override
	public void setEsfSpecificId(long esfSpecificId) {
		_esfSpecificId = esfSpecificId;

		if (_esfUserESFFederalRoleRemoteModel != null) {
			try {
				Class<?> clazz = _esfUserESFFederalRoleRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfSpecificId", long.class);

				method.invoke(_esfUserESFFederalRoleRemoteModel, esfSpecificId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getRegionId() {
		return _regionId;
	}

	@Override
	public void setRegionId(String regionId) {
		_regionId = regionId;

		if (_esfUserESFFederalRoleRemoteModel != null) {
			try {
				Class<?> clazz = _esfUserESFFederalRoleRemoteModel.getClass();

				Method method = clazz.getMethod("setRegionId", String.class);

				method.invoke(_esfUserESFFederalRoleRemoteModel, regionId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getProvinceId() {
		return _provinceId;
	}

	@Override
	public void setProvinceId(String provinceId) {
		_provinceId = provinceId;

		if (_esfUserESFFederalRoleRemoteModel != null) {
			try {
				Class<?> clazz = _esfUserESFFederalRoleRemoteModel.getClass();

				Method method = clazz.getMethod("setProvinceId", String.class);

				method.invoke(_esfUserESFFederalRoleRemoteModel, provinceId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getNotes() {
		return _notes;
	}

	@Override
	public void setNotes(String notes) {
		_notes = notes;

		if (_esfUserESFFederalRoleRemoteModel != null) {
			try {
				Class<?> clazz = _esfUserESFFederalRoleRemoteModel.getClass();

				Method method = clazz.getMethod("setNotes", String.class);

				method.invoke(_esfUserESFFederalRoleRemoteModel, notes);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getESFUserESFFederalRoleRemoteModel() {
		return _esfUserESFFederalRoleRemoteModel;
	}

	public void setESFUserESFFederalRoleRemoteModel(
		BaseModel<?> esfUserESFFederalRoleRemoteModel) {
		_esfUserESFFederalRoleRemoteModel = esfUserESFFederalRoleRemoteModel;
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

		Class<?> remoteModelClass = _esfUserESFFederalRoleRemoteModel.getClass();

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

		Object returnValue = method.invoke(_esfUserESFFederalRoleRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ESFUserESFFederalRoleLocalServiceUtil.addESFUserESFFederalRole(this);
		}
		else {
			ESFUserESFFederalRoleLocalServiceUtil.updateESFUserESFFederalRole(this);
		}
	}

	@Override
	public ESFUserESFFederalRole toEscapedModel() {
		return (ESFUserESFFederalRole)ProxyUtil.newProxyInstance(ESFUserESFFederalRole.class.getClassLoader(),
			new Class[] { ESFUserESFFederalRole.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ESFUserESFFederalRoleClp clone = new ESFUserESFFederalRoleClp();

		clone.setEsfUserId(getEsfUserId());
		clone.setEsfFederalRoleId(getEsfFederalRoleId());
		clone.setStartDate(getStartDate());
		clone.setEndDate(getEndDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setActive(getActive());
		clone.setEsfSpecificId(getEsfSpecificId());
		clone.setRegionId(getRegionId());
		clone.setProvinceId(getProvinceId());
		clone.setNotes(getNotes());

		return clone;
	}

	@Override
	public int compareTo(ESFUserESFFederalRole esfUserESFFederalRole) {
		ESFUserESFFederalRolePK primaryKey = esfUserESFFederalRole.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFUserESFFederalRoleClp)) {
			return false;
		}

		ESFUserESFFederalRoleClp esfUserESFFederalRole = (ESFUserESFFederalRoleClp)obj;

		ESFUserESFFederalRolePK primaryKey = esfUserESFFederalRole.getPrimaryKey();

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
		StringBundler sb = new StringBundler(21);

		sb.append("{esfUserId=");
		sb.append(getEsfUserId());
		sb.append(", esfFederalRoleId=");
		sb.append(getEsfFederalRoleId());
		sb.append(", startDate=");
		sb.append(getStartDate());
		sb.append(", endDate=");
		sb.append(getEndDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", active=");
		sb.append(getActive());
		sb.append(", esfSpecificId=");
		sb.append(getEsfSpecificId());
		sb.append(", regionId=");
		sb.append(getRegionId());
		sb.append(", provinceId=");
		sb.append(getProvinceId());
		sb.append(", notes=");
		sb.append(getNotes());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("it.ethica.esf.model.ESFUserESFFederalRole");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>esfUserId</column-name><column-value><![CDATA[");
		sb.append(getEsfUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfFederalRoleId</column-name><column-value><![CDATA[");
		sb.append(getEsfFederalRoleId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>startDate</column-name><column-value><![CDATA[");
		sb.append(getStartDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endDate</column-name><column-value><![CDATA[");
		sb.append(getEndDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>active</column-name><column-value><![CDATA[");
		sb.append(getActive());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfSpecificId</column-name><column-value><![CDATA[");
		sb.append(getEsfSpecificId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>regionId</column-name><column-value><![CDATA[");
		sb.append(getRegionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>provinceId</column-name><column-value><![CDATA[");
		sb.append(getProvinceId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>notes</column-name><column-value><![CDATA[");
		sb.append(getNotes());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _esfUserId;
	private String _esfUserUuid;
	private long _esfFederalRoleId;
	private long _startDate;
	private Date _endDate;
	private Date _modifiedDate;
	private boolean _active;
	private long _esfSpecificId;
	private String _regionId;
	private String _provinceId;
	private String _notes;
	private BaseModel<?> _esfUserESFFederalRoleRemoteModel;
}