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
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import it.ethica.esf.service.ClpSerializer;
import it.ethica.esf.service.VW_ESFIncarichiFederaliLocalServiceUtil;
import it.ethica.esf.service.persistence.VW_ESFIncarichiFederaliPK;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ethica
 */
public class VW_ESFIncarichiFederaliClp extends BaseModelImpl<VW_ESFIncarichiFederali>
	implements VW_ESFIncarichiFederali {
	public VW_ESFIncarichiFederaliClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return VW_ESFIncarichiFederali.class;
	}

	@Override
	public String getModelClassName() {
		return VW_ESFIncarichiFederali.class.getName();
	}

	@Override
	public VW_ESFIncarichiFederaliPK getPrimaryKey() {
		return new VW_ESFIncarichiFederaliPK(_esfUserId, _esfFederalRoleId,
			_startDate, _endDate, _active_);
	}

	@Override
	public void setPrimaryKey(VW_ESFIncarichiFederaliPK primaryKey) {
		setEsfUserId(primaryKey.esfUserId);
		setEsfFederalRoleId(primaryKey.esfFederalRoleId);
		setStartDate(primaryKey.startDate);
		setEndDate(primaryKey.endDate);
		setActive_(primaryKey.active_);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new VW_ESFIncarichiFederaliPK(_esfUserId, _esfFederalRoleId,
			_startDate, _endDate, _active_);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((VW_ESFIncarichiFederaliPK)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfUserId", getEsfUserId());
		attributes.put("esfFederalRoleId", getEsfFederalRoleId());
		attributes.put("code_", getCode_());
		attributes.put("description", getDescription());
		attributes.put("startDate", getStartDate());
		attributes.put("endDate", getEndDate());
		attributes.put("active_", getActive_());

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

		String code_ = (String)attributes.get("code_");

		if (code_ != null) {
			setCode_(code_);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Long startDate = (Long)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}

		Boolean active_ = (Boolean)attributes.get("active_");

		if (active_ != null) {
			setActive_(active_);
		}
	}

	@Override
	public long getEsfUserId() {
		return _esfUserId;
	}

	@Override
	public void setEsfUserId(long esfUserId) {
		_esfUserId = esfUserId;

		if (_vw_esfIncarichiFederaliRemoteModel != null) {
			try {
				Class<?> clazz = _vw_esfIncarichiFederaliRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfUserId", long.class);

				method.invoke(_vw_esfIncarichiFederaliRemoteModel, esfUserId);
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

		if (_vw_esfIncarichiFederaliRemoteModel != null) {
			try {
				Class<?> clazz = _vw_esfIncarichiFederaliRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfFederalRoleId",
						long.class);

				method.invoke(_vw_esfIncarichiFederaliRemoteModel,
					esfFederalRoleId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCode_() {
		return _code_;
	}

	@Override
	public void setCode_(String code_) {
		_code_ = code_;

		if (_vw_esfIncarichiFederaliRemoteModel != null) {
			try {
				Class<?> clazz = _vw_esfIncarichiFederaliRemoteModel.getClass();

				Method method = clazz.getMethod("setCode_", String.class);

				method.invoke(_vw_esfIncarichiFederaliRemoteModel, code_);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDescription() {
		return _description;
	}

	@Override
	public void setDescription(String description) {
		_description = description;

		if (_vw_esfIncarichiFederaliRemoteModel != null) {
			try {
				Class<?> clazz = _vw_esfIncarichiFederaliRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_vw_esfIncarichiFederaliRemoteModel, description);
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

		if (_vw_esfIncarichiFederaliRemoteModel != null) {
			try {
				Class<?> clazz = _vw_esfIncarichiFederaliRemoteModel.getClass();

				Method method = clazz.getMethod("setStartDate", long.class);

				method.invoke(_vw_esfIncarichiFederaliRemoteModel, startDate);
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

		if (_vw_esfIncarichiFederaliRemoteModel != null) {
			try {
				Class<?> clazz = _vw_esfIncarichiFederaliRemoteModel.getClass();

				Method method = clazz.getMethod("setEndDate", Date.class);

				method.invoke(_vw_esfIncarichiFederaliRemoteModel, endDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getActive_() {
		return _active_;
	}

	@Override
	public boolean isActive_() {
		return _active_;
	}

	@Override
	public void setActive_(boolean active_) {
		_active_ = active_;

		if (_vw_esfIncarichiFederaliRemoteModel != null) {
			try {
				Class<?> clazz = _vw_esfIncarichiFederaliRemoteModel.getClass();

				Method method = clazz.getMethod("setActive_", boolean.class);

				method.invoke(_vw_esfIncarichiFederaliRemoteModel, active_);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getVW_ESFIncarichiFederaliRemoteModel() {
		return _vw_esfIncarichiFederaliRemoteModel;
	}

	public void setVW_ESFIncarichiFederaliRemoteModel(
		BaseModel<?> vw_esfIncarichiFederaliRemoteModel) {
		_vw_esfIncarichiFederaliRemoteModel = vw_esfIncarichiFederaliRemoteModel;
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

		Class<?> remoteModelClass = _vw_esfIncarichiFederaliRemoteModel.getClass();

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

		Object returnValue = method.invoke(_vw_esfIncarichiFederaliRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			VW_ESFIncarichiFederaliLocalServiceUtil.addVW_ESFIncarichiFederali(this);
		}
		else {
			VW_ESFIncarichiFederaliLocalServiceUtil.updateVW_ESFIncarichiFederali(this);
		}
	}

	@Override
	public VW_ESFIncarichiFederali toEscapedModel() {
		return (VW_ESFIncarichiFederali)ProxyUtil.newProxyInstance(VW_ESFIncarichiFederali.class.getClassLoader(),
			new Class[] { VW_ESFIncarichiFederali.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		VW_ESFIncarichiFederaliClp clone = new VW_ESFIncarichiFederaliClp();

		clone.setEsfUserId(getEsfUserId());
		clone.setEsfFederalRoleId(getEsfFederalRoleId());
		clone.setCode_(getCode_());
		clone.setDescription(getDescription());
		clone.setStartDate(getStartDate());
		clone.setEndDate(getEndDate());
		clone.setActive_(getActive_());

		return clone;
	}

	@Override
	public int compareTo(VW_ESFIncarichiFederali vw_esfIncarichiFederali) {
		int value = 0;

		if (getEsfUserId() < vw_esfIncarichiFederali.getEsfUserId()) {
			value = -1;
		}
		else if (getEsfUserId() > vw_esfIncarichiFederali.getEsfUserId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		value = DateUtil.compareTo(getEndDate(),
				vw_esfIncarichiFederali.getEndDate());

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

		if (!(obj instanceof VW_ESFIncarichiFederaliClp)) {
			return false;
		}

		VW_ESFIncarichiFederaliClp vw_esfIncarichiFederali = (VW_ESFIncarichiFederaliClp)obj;

		VW_ESFIncarichiFederaliPK primaryKey = vw_esfIncarichiFederali.getPrimaryKey();

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
		StringBundler sb = new StringBundler(15);

		sb.append("{esfUserId=");
		sb.append(getEsfUserId());
		sb.append(", esfFederalRoleId=");
		sb.append(getEsfFederalRoleId());
		sb.append(", code_=");
		sb.append(getCode_());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", startDate=");
		sb.append(getStartDate());
		sb.append(", endDate=");
		sb.append(getEndDate());
		sb.append(", active_=");
		sb.append(getActive_());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append("it.ethica.esf.model.VW_ESFIncarichiFederali");
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
			"<column><column-name>code_</column-name><column-value><![CDATA[");
		sb.append(getCode_());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
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
			"<column><column-name>active_</column-name><column-value><![CDATA[");
		sb.append(getActive_());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _esfUserId;
	private String _esfUserUuid;
	private long _esfFederalRoleId;
	private String _code_;
	private String _description;
	private long _startDate;
	private Date _endDate;
	private boolean _active_;
	private BaseModel<?> _vw_esfIncarichiFederaliRemoteModel;
	private Class<?> _clpSerializerClass = it.ethica.esf.service.ClpSerializer.class;
}