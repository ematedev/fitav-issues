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
import it.ethica.esf.service.ESFNationalLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ethica
 */
public class ESFNationalClp extends BaseModelImpl<ESFNational>
	implements ESFNational {
	public ESFNationalClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ESFNational.class;
	}

	@Override
	public String getModelClassName() {
		return ESFNational.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _esfNationalId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEsfNationalId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _esfNationalId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfNationalId", getEsfNationalId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("esfUserId", getEsfUserId());
		attributes.put("esfSportTypeId", getEsfSportTypeId());
		attributes.put("startDate", getStartDate());
		attributes.put("endDate", getEndDate());
		attributes.put("BDODate", getBDODate());
		attributes.put("idInternational", getIdInternational());
		attributes.put("isUniversity", getIsUniversity());
		attributes.put("isNational", getIsNational());
		attributes.put("deliberate", getDeliberate());
		attributes.put("deliberateDate", getDeliberateDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esfNationalId = (Long)attributes.get("esfNationalId");

		if (esfNationalId != null) {
			setEsfNationalId(esfNationalId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long esfUserId = (Long)attributes.get("esfUserId");

		if (esfUserId != null) {
			setEsfUserId(esfUserId);
		}

		Long esfSportTypeId = (Long)attributes.get("esfSportTypeId");

		if (esfSportTypeId != null) {
			setEsfSportTypeId(esfSportTypeId);
		}

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}

		Date BDODate = (Date)attributes.get("BDODate");

		if (BDODate != null) {
			setBDODate(BDODate);
		}

		String idInternational = (String)attributes.get("idInternational");

		if (idInternational != null) {
			setIdInternational(idInternational);
		}

		Boolean isUniversity = (Boolean)attributes.get("isUniversity");

		if (isUniversity != null) {
			setIsUniversity(isUniversity);
		}

		Boolean isNational = (Boolean)attributes.get("isNational");

		if (isNational != null) {
			setIsNational(isNational);
		}

		String deliberate = (String)attributes.get("deliberate");

		if (deliberate != null) {
			setDeliberate(deliberate);
		}

		Date deliberateDate = (Date)attributes.get("deliberateDate");

		if (deliberateDate != null) {
			setDeliberateDate(deliberateDate);
		}
	}

	@Override
	public long getEsfNationalId() {
		return _esfNationalId;
	}

	@Override
	public void setEsfNationalId(long esfNationalId) {
		_esfNationalId = esfNationalId;

		if (_esfNationalRemoteModel != null) {
			try {
				Class<?> clazz = _esfNationalRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfNationalId", long.class);

				method.invoke(_esfNationalRemoteModel, esfNationalId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_esfNationalRemoteModel != null) {
			try {
				Class<?> clazz = _esfNationalRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_esfNationalRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_esfNationalRemoteModel != null) {
			try {
				Class<?> clazz = _esfNationalRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_esfNationalRemoteModel, companyId);
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

		if (_esfNationalRemoteModel != null) {
			try {
				Class<?> clazz = _esfNationalRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_esfNationalRemoteModel, userId);
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

	@Override
	public String getUserName() {
		return _userName;
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;

		if (_esfNationalRemoteModel != null) {
			try {
				Class<?> clazz = _esfNationalRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_esfNationalRemoteModel, userName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_esfNationalRemoteModel != null) {
			try {
				Class<?> clazz = _esfNationalRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_esfNationalRemoteModel, createDate);
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

		if (_esfNationalRemoteModel != null) {
			try {
				Class<?> clazz = _esfNationalRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_esfNationalRemoteModel, modifiedDate);
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

		if (_esfNationalRemoteModel != null) {
			try {
				Class<?> clazz = _esfNationalRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfUserId", long.class);

				method.invoke(_esfNationalRemoteModel, esfUserId);
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
	public long getEsfSportTypeId() {
		return _esfSportTypeId;
	}

	@Override
	public void setEsfSportTypeId(long esfSportTypeId) {
		_esfSportTypeId = esfSportTypeId;

		if (_esfNationalRemoteModel != null) {
			try {
				Class<?> clazz = _esfNationalRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfSportTypeId", long.class);

				method.invoke(_esfNationalRemoteModel, esfSportTypeId);
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

		if (_esfNationalRemoteModel != null) {
			try {
				Class<?> clazz = _esfNationalRemoteModel.getClass();

				Method method = clazz.getMethod("setStartDate", Date.class);

				method.invoke(_esfNationalRemoteModel, startDate);
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

		if (_esfNationalRemoteModel != null) {
			try {
				Class<?> clazz = _esfNationalRemoteModel.getClass();

				Method method = clazz.getMethod("setEndDate", Date.class);

				method.invoke(_esfNationalRemoteModel, endDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getBDODate() {
		return _BDODate;
	}

	@Override
	public void setBDODate(Date BDODate) {
		_BDODate = BDODate;

		if (_esfNationalRemoteModel != null) {
			try {
				Class<?> clazz = _esfNationalRemoteModel.getClass();

				Method method = clazz.getMethod("setBDODate", Date.class);

				method.invoke(_esfNationalRemoteModel, BDODate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getIdInternational() {
		return _idInternational;
	}

	@Override
	public void setIdInternational(String idInternational) {
		_idInternational = idInternational;

		if (_esfNationalRemoteModel != null) {
			try {
				Class<?> clazz = _esfNationalRemoteModel.getClass();

				Method method = clazz.getMethod("setIdInternational",
						String.class);

				method.invoke(_esfNationalRemoteModel, idInternational);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getIsUniversity() {
		return _isUniversity;
	}

	@Override
	public boolean isIsUniversity() {
		return _isUniversity;
	}

	@Override
	public void setIsUniversity(boolean isUniversity) {
		_isUniversity = isUniversity;

		if (_esfNationalRemoteModel != null) {
			try {
				Class<?> clazz = _esfNationalRemoteModel.getClass();

				Method method = clazz.getMethod("setIsUniversity", boolean.class);

				method.invoke(_esfNationalRemoteModel, isUniversity);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getIsNational() {
		return _isNational;
	}

	@Override
	public boolean isIsNational() {
		return _isNational;
	}

	@Override
	public void setIsNational(boolean isNational) {
		_isNational = isNational;

		if (_esfNationalRemoteModel != null) {
			try {
				Class<?> clazz = _esfNationalRemoteModel.getClass();

				Method method = clazz.getMethod("setIsNational", boolean.class);

				method.invoke(_esfNationalRemoteModel, isNational);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDeliberate() {
		return _deliberate;
	}

	@Override
	public void setDeliberate(String deliberate) {
		_deliberate = deliberate;

		if (_esfNationalRemoteModel != null) {
			try {
				Class<?> clazz = _esfNationalRemoteModel.getClass();

				Method method = clazz.getMethod("setDeliberate", String.class);

				method.invoke(_esfNationalRemoteModel, deliberate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getDeliberateDate() {
		return _deliberateDate;
	}

	@Override
	public void setDeliberateDate(Date deliberateDate) {
		_deliberateDate = deliberateDate;

		if (_esfNationalRemoteModel != null) {
			try {
				Class<?> clazz = _esfNationalRemoteModel.getClass();

				Method method = clazz.getMethod("setDeliberateDate", Date.class);

				method.invoke(_esfNationalRemoteModel, deliberateDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getESFNationalRemoteModel() {
		return _esfNationalRemoteModel;
	}

	public void setESFNationalRemoteModel(BaseModel<?> esfNationalRemoteModel) {
		_esfNationalRemoteModel = esfNationalRemoteModel;
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

		Class<?> remoteModelClass = _esfNationalRemoteModel.getClass();

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

		Object returnValue = method.invoke(_esfNationalRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ESFNationalLocalServiceUtil.addESFNational(this);
		}
		else {
			ESFNationalLocalServiceUtil.updateESFNational(this);
		}
	}

	@Override
	public ESFNational toEscapedModel() {
		return (ESFNational)ProxyUtil.newProxyInstance(ESFNational.class.getClassLoader(),
			new Class[] { ESFNational.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ESFNationalClp clone = new ESFNationalClp();

		clone.setEsfNationalId(getEsfNationalId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setEsfUserId(getEsfUserId());
		clone.setEsfSportTypeId(getEsfSportTypeId());
		clone.setStartDate(getStartDate());
		clone.setEndDate(getEndDate());
		clone.setBDODate(getBDODate());
		clone.setIdInternational(getIdInternational());
		clone.setIsUniversity(getIsUniversity());
		clone.setIsNational(getIsNational());
		clone.setDeliberate(getDeliberate());
		clone.setDeliberateDate(getDeliberateDate());

		return clone;
	}

	@Override
	public int compareTo(ESFNational esfNational) {
		long primaryKey = esfNational.getPrimaryKey();

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

		if (!(obj instanceof ESFNationalClp)) {
			return false;
		}

		ESFNationalClp esfNational = (ESFNationalClp)obj;

		long primaryKey = esfNational.getPrimaryKey();

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
		StringBundler sb = new StringBundler(35);

		sb.append("{esfNationalId=");
		sb.append(getEsfNationalId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", esfUserId=");
		sb.append(getEsfUserId());
		sb.append(", esfSportTypeId=");
		sb.append(getEsfSportTypeId());
		sb.append(", startDate=");
		sb.append(getStartDate());
		sb.append(", endDate=");
		sb.append(getEndDate());
		sb.append(", BDODate=");
		sb.append(getBDODate());
		sb.append(", idInternational=");
		sb.append(getIdInternational());
		sb.append(", isUniversity=");
		sb.append(getIsUniversity());
		sb.append(", isNational=");
		sb.append(getIsNational());
		sb.append(", deliberate=");
		sb.append(getDeliberate());
		sb.append(", deliberateDate=");
		sb.append(getDeliberateDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(55);

		sb.append("<model><model-name>");
		sb.append("it.ethica.esf.model.ESFNational");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>esfNationalId</column-name><column-value><![CDATA[");
		sb.append(getEsfNationalId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfUserId</column-name><column-value><![CDATA[");
		sb.append(getEsfUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfSportTypeId</column-name><column-value><![CDATA[");
		sb.append(getEsfSportTypeId());
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
			"<column><column-name>BDODate</column-name><column-value><![CDATA[");
		sb.append(getBDODate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>idInternational</column-name><column-value><![CDATA[");
		sb.append(getIdInternational());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isUniversity</column-name><column-value><![CDATA[");
		sb.append(getIsUniversity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isNational</column-name><column-value><![CDATA[");
		sb.append(getIsNational());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>deliberate</column-name><column-value><![CDATA[");
		sb.append(getDeliberate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>deliberateDate</column-name><column-value><![CDATA[");
		sb.append(getDeliberateDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _esfNationalId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _esfUserId;
	private String _esfUserUuid;
	private long _esfSportTypeId;
	private Date _startDate;
	private Date _endDate;
	private Date _BDODate;
	private String _idInternational;
	private boolean _isUniversity;
	private boolean _isNational;
	private String _deliberate;
	private Date _deliberateDate;
	private BaseModel<?> _esfNationalRemoteModel;
}