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
import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import it.ethica.esf.service.ClpSerializer;
import it.ethica.esf.service.ESFTournamentLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ethica
 */
public class ESFTournamentClp extends BaseModelImpl<ESFTournament>
	implements ESFTournament {
	public ESFTournamentClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ESFTournament.class;
	}

	@Override
	public String getModelClassName() {
		return ESFTournament.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _esfTournamentId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEsfTournamentId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _esfTournamentId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("esfTournamentId", getEsfTournamentId());
		attributes.put("esfOrganizationId", getEsfOrganizationId());
		attributes.put("title", getTitle());
		attributes.put("description", getDescription());
		attributes.put("maxnum", getMaxnum());
		attributes.put("minnum", getMinnum());
		attributes.put("isSingleMatch", getIsSingleMatch());
		attributes.put("isTeamMatch", getIsTeamMatch());
		attributes.put("isIndividualMatch", getIsIndividualMatch());
		attributes.put("isJuniorMatch", getIsJuniorMatch());
		attributes.put("isNationalMatch", getIsNationalMatch());
		attributes.put("isFinal", getIsFinal());
		attributes.put("startDate", getStartDate());
		attributes.put("endDate", getEndDate());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long esfTournamentId = (Long)attributes.get("esfTournamentId");

		if (esfTournamentId != null) {
			setEsfTournamentId(esfTournamentId);
		}

		Long esfOrganizationId = (Long)attributes.get("esfOrganizationId");

		if (esfOrganizationId != null) {
			setEsfOrganizationId(esfOrganizationId);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Long maxnum = (Long)attributes.get("maxnum");

		if (maxnum != null) {
			setMaxnum(maxnum);
		}

		Long minnum = (Long)attributes.get("minnum");

		if (minnum != null) {
			setMinnum(minnum);
		}

		Boolean isSingleMatch = (Boolean)attributes.get("isSingleMatch");

		if (isSingleMatch != null) {
			setIsSingleMatch(isSingleMatch);
		}

		Boolean isTeamMatch = (Boolean)attributes.get("isTeamMatch");

		if (isTeamMatch != null) {
			setIsTeamMatch(isTeamMatch);
		}

		Boolean isIndividualMatch = (Boolean)attributes.get("isIndividualMatch");

		if (isIndividualMatch != null) {
			setIsIndividualMatch(isIndividualMatch);
		}

		Boolean isJuniorMatch = (Boolean)attributes.get("isJuniorMatch");

		if (isJuniorMatch != null) {
			setIsJuniorMatch(isJuniorMatch);
		}

		Boolean isNationalMatch = (Boolean)attributes.get("isNationalMatch");

		if (isNationalMatch != null) {
			setIsNationalMatch(isNationalMatch);
		}

		Boolean isFinal = (Boolean)attributes.get("isFinal");

		if (isFinal != null) {
			setIsFinal(isFinal);
		}

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
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
	}

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_esfTournamentRemoteModel != null) {
			try {
				Class<?> clazz = _esfTournamentRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_esfTournamentRemoteModel, uuid);
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

		if (_esfTournamentRemoteModel != null) {
			try {
				Class<?> clazz = _esfTournamentRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfTournamentId", long.class);

				method.invoke(_esfTournamentRemoteModel, esfTournamentId);
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

		if (_esfTournamentRemoteModel != null) {
			try {
				Class<?> clazz = _esfTournamentRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfOrganizationId",
						long.class);

				method.invoke(_esfTournamentRemoteModel, esfOrganizationId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTitle() {
		return _title;
	}

	@Override
	public void setTitle(String title) {
		_title = title;

		if (_esfTournamentRemoteModel != null) {
			try {
				Class<?> clazz = _esfTournamentRemoteModel.getClass();

				Method method = clazz.getMethod("setTitle", String.class);

				method.invoke(_esfTournamentRemoteModel, title);
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

		if (_esfTournamentRemoteModel != null) {
			try {
				Class<?> clazz = _esfTournamentRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_esfTournamentRemoteModel, description);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getMaxnum() {
		return _maxnum;
	}

	@Override
	public void setMaxnum(long maxnum) {
		_maxnum = maxnum;

		if (_esfTournamentRemoteModel != null) {
			try {
				Class<?> clazz = _esfTournamentRemoteModel.getClass();

				Method method = clazz.getMethod("setMaxnum", long.class);

				method.invoke(_esfTournamentRemoteModel, maxnum);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getMinnum() {
		return _minnum;
	}

	@Override
	public void setMinnum(long minnum) {
		_minnum = minnum;

		if (_esfTournamentRemoteModel != null) {
			try {
				Class<?> clazz = _esfTournamentRemoteModel.getClass();

				Method method = clazz.getMethod("setMinnum", long.class);

				method.invoke(_esfTournamentRemoteModel, minnum);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getIsSingleMatch() {
		return _isSingleMatch;
	}

	@Override
	public boolean isIsSingleMatch() {
		return _isSingleMatch;
	}

	@Override
	public void setIsSingleMatch(boolean isSingleMatch) {
		_isSingleMatch = isSingleMatch;

		if (_esfTournamentRemoteModel != null) {
			try {
				Class<?> clazz = _esfTournamentRemoteModel.getClass();

				Method method = clazz.getMethod("setIsSingleMatch",
						boolean.class);

				method.invoke(_esfTournamentRemoteModel, isSingleMatch);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getIsTeamMatch() {
		return _isTeamMatch;
	}

	@Override
	public boolean isIsTeamMatch() {
		return _isTeamMatch;
	}

	@Override
	public void setIsTeamMatch(boolean isTeamMatch) {
		_isTeamMatch = isTeamMatch;

		if (_esfTournamentRemoteModel != null) {
			try {
				Class<?> clazz = _esfTournamentRemoteModel.getClass();

				Method method = clazz.getMethod("setIsTeamMatch", boolean.class);

				method.invoke(_esfTournamentRemoteModel, isTeamMatch);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getIsIndividualMatch() {
		return _isIndividualMatch;
	}

	@Override
	public boolean isIsIndividualMatch() {
		return _isIndividualMatch;
	}

	@Override
	public void setIsIndividualMatch(boolean isIndividualMatch) {
		_isIndividualMatch = isIndividualMatch;

		if (_esfTournamentRemoteModel != null) {
			try {
				Class<?> clazz = _esfTournamentRemoteModel.getClass();

				Method method = clazz.getMethod("setIsIndividualMatch",
						boolean.class);

				method.invoke(_esfTournamentRemoteModel, isIndividualMatch);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getIsJuniorMatch() {
		return _isJuniorMatch;
	}

	@Override
	public boolean isIsJuniorMatch() {
		return _isJuniorMatch;
	}

	@Override
	public void setIsJuniorMatch(boolean isJuniorMatch) {
		_isJuniorMatch = isJuniorMatch;

		if (_esfTournamentRemoteModel != null) {
			try {
				Class<?> clazz = _esfTournamentRemoteModel.getClass();

				Method method = clazz.getMethod("setIsJuniorMatch",
						boolean.class);

				method.invoke(_esfTournamentRemoteModel, isJuniorMatch);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getIsNationalMatch() {
		return _isNationalMatch;
	}

	@Override
	public boolean isIsNationalMatch() {
		return _isNationalMatch;
	}

	@Override
	public void setIsNationalMatch(boolean isNationalMatch) {
		_isNationalMatch = isNationalMatch;

		if (_esfTournamentRemoteModel != null) {
			try {
				Class<?> clazz = _esfTournamentRemoteModel.getClass();

				Method method = clazz.getMethod("setIsNationalMatch",
						boolean.class);

				method.invoke(_esfTournamentRemoteModel, isNationalMatch);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getIsFinal() {
		return _isFinal;
	}

	@Override
	public boolean isIsFinal() {
		return _isFinal;
	}

	@Override
	public void setIsFinal(boolean isFinal) {
		_isFinal = isFinal;

		if (_esfTournamentRemoteModel != null) {
			try {
				Class<?> clazz = _esfTournamentRemoteModel.getClass();

				Method method = clazz.getMethod("setIsFinal", boolean.class);

				method.invoke(_esfTournamentRemoteModel, isFinal);
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

		if (_esfTournamentRemoteModel != null) {
			try {
				Class<?> clazz = _esfTournamentRemoteModel.getClass();

				Method method = clazz.getMethod("setStartDate", Date.class);

				method.invoke(_esfTournamentRemoteModel, startDate);
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

		if (_esfTournamentRemoteModel != null) {
			try {
				Class<?> clazz = _esfTournamentRemoteModel.getClass();

				Method method = clazz.getMethod("setEndDate", Date.class);

				method.invoke(_esfTournamentRemoteModel, endDate);
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

		if (_esfTournamentRemoteModel != null) {
			try {
				Class<?> clazz = _esfTournamentRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_esfTournamentRemoteModel, groupId);
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

		if (_esfTournamentRemoteModel != null) {
			try {
				Class<?> clazz = _esfTournamentRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_esfTournamentRemoteModel, companyId);
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

		if (_esfTournamentRemoteModel != null) {
			try {
				Class<?> clazz = _esfTournamentRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_esfTournamentRemoteModel, userId);
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

		if (_esfTournamentRemoteModel != null) {
			try {
				Class<?> clazz = _esfTournamentRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_esfTournamentRemoteModel, userName);
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

		if (_esfTournamentRemoteModel != null) {
			try {
				Class<?> clazz = _esfTournamentRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_esfTournamentRemoteModel, createDate);
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

		if (_esfTournamentRemoteModel != null) {
			try {
				Class<?> clazz = _esfTournamentRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_esfTournamentRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				ESFTournament.class.getName()));
	}

	public BaseModel<?> getESFTournamentRemoteModel() {
		return _esfTournamentRemoteModel;
	}

	public void setESFTournamentRemoteModel(
		BaseModel<?> esfTournamentRemoteModel) {
		_esfTournamentRemoteModel = esfTournamentRemoteModel;
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

		Class<?> remoteModelClass = _esfTournamentRemoteModel.getClass();

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

		Object returnValue = method.invoke(_esfTournamentRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ESFTournamentLocalServiceUtil.addESFTournament(this);
		}
		else {
			ESFTournamentLocalServiceUtil.updateESFTournament(this);
		}
	}

	@Override
	public ESFTournament toEscapedModel() {
		return (ESFTournament)ProxyUtil.newProxyInstance(ESFTournament.class.getClassLoader(),
			new Class[] { ESFTournament.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ESFTournamentClp clone = new ESFTournamentClp();

		clone.setUuid(getUuid());
		clone.setEsfTournamentId(getEsfTournamentId());
		clone.setEsfOrganizationId(getEsfOrganizationId());
		clone.setTitle(getTitle());
		clone.setDescription(getDescription());
		clone.setMaxnum(getMaxnum());
		clone.setMinnum(getMinnum());
		clone.setIsSingleMatch(getIsSingleMatch());
		clone.setIsTeamMatch(getIsTeamMatch());
		clone.setIsIndividualMatch(getIsIndividualMatch());
		clone.setIsJuniorMatch(getIsJuniorMatch());
		clone.setIsNationalMatch(getIsNationalMatch());
		clone.setIsFinal(getIsFinal());
		clone.setStartDate(getStartDate());
		clone.setEndDate(getEndDate());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());

		return clone;
	}

	@Override
	public int compareTo(ESFTournament esfTournament) {
		long primaryKey = esfTournament.getPrimaryKey();

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

		if (!(obj instanceof ESFTournamentClp)) {
			return false;
		}

		ESFTournamentClp esfTournament = (ESFTournamentClp)obj;

		long primaryKey = esfTournament.getPrimaryKey();

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
		StringBundler sb = new StringBundler(43);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", esfTournamentId=");
		sb.append(getEsfTournamentId());
		sb.append(", esfOrganizationId=");
		sb.append(getEsfOrganizationId());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", maxnum=");
		sb.append(getMaxnum());
		sb.append(", minnum=");
		sb.append(getMinnum());
		sb.append(", isSingleMatch=");
		sb.append(getIsSingleMatch());
		sb.append(", isTeamMatch=");
		sb.append(getIsTeamMatch());
		sb.append(", isIndividualMatch=");
		sb.append(getIsIndividualMatch());
		sb.append(", isJuniorMatch=");
		sb.append(getIsJuniorMatch());
		sb.append(", isNationalMatch=");
		sb.append(getIsNationalMatch());
		sb.append(", isFinal=");
		sb.append(getIsFinal());
		sb.append(", startDate=");
		sb.append(getStartDate());
		sb.append(", endDate=");
		sb.append(getEndDate());
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
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(67);

		sb.append("<model><model-name>");
		sb.append("it.ethica.esf.model.ESFTournament");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfTournamentId</column-name><column-value><![CDATA[");
		sb.append(getEsfTournamentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfOrganizationId</column-name><column-value><![CDATA[");
		sb.append(getEsfOrganizationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>maxnum</column-name><column-value><![CDATA[");
		sb.append(getMaxnum());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>minnum</column-name><column-value><![CDATA[");
		sb.append(getMinnum());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isSingleMatch</column-name><column-value><![CDATA[");
		sb.append(getIsSingleMatch());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isTeamMatch</column-name><column-value><![CDATA[");
		sb.append(getIsTeamMatch());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isIndividualMatch</column-name><column-value><![CDATA[");
		sb.append(getIsIndividualMatch());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isJuniorMatch</column-name><column-value><![CDATA[");
		sb.append(getIsJuniorMatch());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isNationalMatch</column-name><column-value><![CDATA[");
		sb.append(getIsNationalMatch());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isFinal</column-name><column-value><![CDATA[");
		sb.append(getIsFinal());
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

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _esfTournamentId;
	private long _esfOrganizationId;
	private String _title;
	private String _description;
	private long _maxnum;
	private long _minnum;
	private boolean _isSingleMatch;
	private boolean _isTeamMatch;
	private boolean _isIndividualMatch;
	private boolean _isJuniorMatch;
	private boolean _isNationalMatch;
	private boolean _isFinal;
	private Date _startDate;
	private Date _endDate;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private BaseModel<?> _esfTournamentRemoteModel;
	private Class<?> _clpSerializerClass = it.ethica.esf.service.ClpSerializer.class;
}