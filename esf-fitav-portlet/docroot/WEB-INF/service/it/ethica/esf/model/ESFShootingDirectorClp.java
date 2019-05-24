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
import it.ethica.esf.service.ESFShootingDirectorLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ethica
 */
public class ESFShootingDirectorClp extends BaseModelImpl<ESFShootingDirector>
	implements ESFShootingDirector {
	public ESFShootingDirectorClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ESFShootingDirector.class;
	}

	@Override
	public String getModelClassName() {
		return ESFShootingDirector.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _esfShootingDirectorId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEsfShootingDirectorId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _esfShootingDirectorId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfShootingDirectorId", getEsfShootingDirectorId());
		attributes.put("esfCodeData", getEsfCodeData());
		attributes.put("esfStartData", getEsfStartData());
		attributes.put("esfEndData", getEsfEndData());
		attributes.put("esfUserId", getEsfUserId());
		attributes.put("codeUser", getCodeUser());
		attributes.put("shootingDirectorQualificationId",
			getShootingDirectorQualificationId());
		attributes.put("sportTypeId", getSportTypeId());
		attributes.put("regionId", getRegionId());
		attributes.put("provinceId", getProvinceId());
		attributes.put("flagCrea", getFlagCrea());
		attributes.put("DateVar", getDateVar());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esfShootingDirectorId = (Long)attributes.get(
				"esfShootingDirectorId");

		if (esfShootingDirectorId != null) {
			setEsfShootingDirectorId(esfShootingDirectorId);
		}

		String esfCodeData = (String)attributes.get("esfCodeData");

		if (esfCodeData != null) {
			setEsfCodeData(esfCodeData);
		}

		Date esfStartData = (Date)attributes.get("esfStartData");

		if (esfStartData != null) {
			setEsfStartData(esfStartData);
		}

		Date esfEndData = (Date)attributes.get("esfEndData");

		if (esfEndData != null) {
			setEsfEndData(esfEndData);
		}

		Long esfUserId = (Long)attributes.get("esfUserId");

		if (esfUserId != null) {
			setEsfUserId(esfUserId);
		}

		Long codeUser = (Long)attributes.get("codeUser");

		if (codeUser != null) {
			setCodeUser(codeUser);
		}

		Long shootingDirectorQualificationId = (Long)attributes.get(
				"shootingDirectorQualificationId");

		if (shootingDirectorQualificationId != null) {
			setShootingDirectorQualificationId(shootingDirectorQualificationId);
		}

		Long sportTypeId = (Long)attributes.get("sportTypeId");

		if (sportTypeId != null) {
			setSportTypeId(sportTypeId);
		}

		String regionId = (String)attributes.get("regionId");

		if (regionId != null) {
			setRegionId(regionId);
		}

		String provinceId = (String)attributes.get("provinceId");

		if (provinceId != null) {
			setProvinceId(provinceId);
		}

		String flagCrea = (String)attributes.get("flagCrea");

		if (flagCrea != null) {
			setFlagCrea(flagCrea);
		}

		Date DateVar = (Date)attributes.get("DateVar");

		if (DateVar != null) {
			setDateVar(DateVar);
		}
	}

	@Override
	public long getEsfShootingDirectorId() {
		return _esfShootingDirectorId;
	}

	@Override
	public void setEsfShootingDirectorId(long esfShootingDirectorId) {
		_esfShootingDirectorId = esfShootingDirectorId;

		if (_esfShootingDirectorRemoteModel != null) {
			try {
				Class<?> clazz = _esfShootingDirectorRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfShootingDirectorId",
						long.class);

				method.invoke(_esfShootingDirectorRemoteModel,
					esfShootingDirectorId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEsfCodeData() {
		return _esfCodeData;
	}

	@Override
	public void setEsfCodeData(String esfCodeData) {
		_esfCodeData = esfCodeData;

		if (_esfShootingDirectorRemoteModel != null) {
			try {
				Class<?> clazz = _esfShootingDirectorRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfCodeData", String.class);

				method.invoke(_esfShootingDirectorRemoteModel, esfCodeData);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getEsfStartData() {
		return _esfStartData;
	}

	@Override
	public void setEsfStartData(Date esfStartData) {
		_esfStartData = esfStartData;

		if (_esfShootingDirectorRemoteModel != null) {
			try {
				Class<?> clazz = _esfShootingDirectorRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfStartData", Date.class);

				method.invoke(_esfShootingDirectorRemoteModel, esfStartData);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getEsfEndData() {
		return _esfEndData;
	}

	@Override
	public void setEsfEndData(Date esfEndData) {
		_esfEndData = esfEndData;

		if (_esfShootingDirectorRemoteModel != null) {
			try {
				Class<?> clazz = _esfShootingDirectorRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfEndData", Date.class);

				method.invoke(_esfShootingDirectorRemoteModel, esfEndData);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Long getEsfUserId() {
		return _esfUserId;
	}

	@Override
	public void setEsfUserId(Long esfUserId) {
		_esfUserId = esfUserId;

		if (_esfShootingDirectorRemoteModel != null) {
			try {
				Class<?> clazz = _esfShootingDirectorRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfUserId", Long.class);

				method.invoke(_esfShootingDirectorRemoteModel, esfUserId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Long getCodeUser() {
		return _codeUser;
	}

	@Override
	public void setCodeUser(Long codeUser) {
		_codeUser = codeUser;

		if (_esfShootingDirectorRemoteModel != null) {
			try {
				Class<?> clazz = _esfShootingDirectorRemoteModel.getClass();

				Method method = clazz.getMethod("setCodeUser", Long.class);

				method.invoke(_esfShootingDirectorRemoteModel, codeUser);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Long getShootingDirectorQualificationId() {
		return _shootingDirectorQualificationId;
	}

	@Override
	public void setShootingDirectorQualificationId(
		Long shootingDirectorQualificationId) {
		_shootingDirectorQualificationId = shootingDirectorQualificationId;

		if (_esfShootingDirectorRemoteModel != null) {
			try {
				Class<?> clazz = _esfShootingDirectorRemoteModel.getClass();

				Method method = clazz.getMethod("setShootingDirectorQualificationId",
						Long.class);

				method.invoke(_esfShootingDirectorRemoteModel,
					shootingDirectorQualificationId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Long getSportTypeId() {
		return _sportTypeId;
	}

	@Override
	public void setSportTypeId(Long sportTypeId) {
		_sportTypeId = sportTypeId;

		if (_esfShootingDirectorRemoteModel != null) {
			try {
				Class<?> clazz = _esfShootingDirectorRemoteModel.getClass();

				Method method = clazz.getMethod("setSportTypeId", Long.class);

				method.invoke(_esfShootingDirectorRemoteModel, sportTypeId);
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

		if (_esfShootingDirectorRemoteModel != null) {
			try {
				Class<?> clazz = _esfShootingDirectorRemoteModel.getClass();

				Method method = clazz.getMethod("setRegionId", String.class);

				method.invoke(_esfShootingDirectorRemoteModel, regionId);
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

		if (_esfShootingDirectorRemoteModel != null) {
			try {
				Class<?> clazz = _esfShootingDirectorRemoteModel.getClass();

				Method method = clazz.getMethod("setProvinceId", String.class);

				method.invoke(_esfShootingDirectorRemoteModel, provinceId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFlagCrea() {
		return _flagCrea;
	}

	@Override
	public void setFlagCrea(String flagCrea) {
		_flagCrea = flagCrea;

		if (_esfShootingDirectorRemoteModel != null) {
			try {
				Class<?> clazz = _esfShootingDirectorRemoteModel.getClass();

				Method method = clazz.getMethod("setFlagCrea", String.class);

				method.invoke(_esfShootingDirectorRemoteModel, flagCrea);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getDateVar() {
		return _DateVar;
	}

	@Override
	public void setDateVar(Date DateVar) {
		_DateVar = DateVar;

		if (_esfShootingDirectorRemoteModel != null) {
			try {
				Class<?> clazz = _esfShootingDirectorRemoteModel.getClass();

				Method method = clazz.getMethod("setDateVar", Date.class);

				method.invoke(_esfShootingDirectorRemoteModel, DateVar);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getESFShootingDirectorRemoteModel() {
		return _esfShootingDirectorRemoteModel;
	}

	public void setESFShootingDirectorRemoteModel(
		BaseModel<?> esfShootingDirectorRemoteModel) {
		_esfShootingDirectorRemoteModel = esfShootingDirectorRemoteModel;
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

		Class<?> remoteModelClass = _esfShootingDirectorRemoteModel.getClass();

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

		Object returnValue = method.invoke(_esfShootingDirectorRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ESFShootingDirectorLocalServiceUtil.addESFShootingDirector(this);
		}
		else {
			ESFShootingDirectorLocalServiceUtil.updateESFShootingDirector(this);
		}
	}

	@Override
	public ESFShootingDirector toEscapedModel() {
		return (ESFShootingDirector)ProxyUtil.newProxyInstance(ESFShootingDirector.class.getClassLoader(),
			new Class[] { ESFShootingDirector.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ESFShootingDirectorClp clone = new ESFShootingDirectorClp();

		clone.setEsfShootingDirectorId(getEsfShootingDirectorId());
		clone.setEsfCodeData(getEsfCodeData());
		clone.setEsfStartData(getEsfStartData());
		clone.setEsfEndData(getEsfEndData());
		clone.setEsfUserId(getEsfUserId());
		clone.setCodeUser(getCodeUser());
		clone.setShootingDirectorQualificationId(getShootingDirectorQualificationId());
		clone.setSportTypeId(getSportTypeId());
		clone.setRegionId(getRegionId());
		clone.setProvinceId(getProvinceId());
		clone.setFlagCrea(getFlagCrea());
		clone.setDateVar(getDateVar());

		return clone;
	}

	@Override
	public int compareTo(ESFShootingDirector esfShootingDirector) {
		int value = 0;

		if (getShootingDirectorQualificationId() < esfShootingDirector.getShootingDirectorQualificationId()) {
			value = -1;
		}
		else if (getShootingDirectorQualificationId() > esfShootingDirector.getShootingDirectorQualificationId()) {
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

		if (!(obj instanceof ESFShootingDirectorClp)) {
			return false;
		}

		ESFShootingDirectorClp esfShootingDirector = (ESFShootingDirectorClp)obj;

		long primaryKey = esfShootingDirector.getPrimaryKey();

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

		sb.append("{esfShootingDirectorId=");
		sb.append(getEsfShootingDirectorId());
		sb.append(", esfCodeData=");
		sb.append(getEsfCodeData());
		sb.append(", esfStartData=");
		sb.append(getEsfStartData());
		sb.append(", esfEndData=");
		sb.append(getEsfEndData());
		sb.append(", esfUserId=");
		sb.append(getEsfUserId());
		sb.append(", codeUser=");
		sb.append(getCodeUser());
		sb.append(", shootingDirectorQualificationId=");
		sb.append(getShootingDirectorQualificationId());
		sb.append(", sportTypeId=");
		sb.append(getSportTypeId());
		sb.append(", regionId=");
		sb.append(getRegionId());
		sb.append(", provinceId=");
		sb.append(getProvinceId());
		sb.append(", flagCrea=");
		sb.append(getFlagCrea());
		sb.append(", DateVar=");
		sb.append(getDateVar());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("it.ethica.esf.model.ESFShootingDirector");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>esfShootingDirectorId</column-name><column-value><![CDATA[");
		sb.append(getEsfShootingDirectorId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfCodeData</column-name><column-value><![CDATA[");
		sb.append(getEsfCodeData());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfStartData</column-name><column-value><![CDATA[");
		sb.append(getEsfStartData());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfEndData</column-name><column-value><![CDATA[");
		sb.append(getEsfEndData());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfUserId</column-name><column-value><![CDATA[");
		sb.append(getEsfUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>codeUser</column-name><column-value><![CDATA[");
		sb.append(getCodeUser());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>shootingDirectorQualificationId</column-name><column-value><![CDATA[");
		sb.append(getShootingDirectorQualificationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sportTypeId</column-name><column-value><![CDATA[");
		sb.append(getSportTypeId());
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
			"<column><column-name>flagCrea</column-name><column-value><![CDATA[");
		sb.append(getFlagCrea());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>DateVar</column-name><column-value><![CDATA[");
		sb.append(getDateVar());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _esfShootingDirectorId;
	private String _esfCodeData;
	private Date _esfStartData;
	private Date _esfEndData;
	private Long _esfUserId;
	private Long _codeUser;
	private Long _shootingDirectorQualificationId;
	private Long _sportTypeId;
	private String _regionId;
	private String _provinceId;
	private String _flagCrea;
	private Date _DateVar;
	private BaseModel<?> _esfShootingDirectorRemoteModel;
	private Class<?> _clpSerializerClass = it.ethica.esf.service.ClpSerializer.class;
}